package uwu.lopyluna.talon.baseRegistry.block_properties;

import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.talon.baseRegistry.TalonRegistry;

import javax.annotation.Nullable;

public class KilnBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(2);

    private static final int INPUT_SLOT_1ST = 0;
    private static final int INPUT_SLOT_2ND = 1;
    private static final int FUEL_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int litTime = 0;
    private int litDuration;
    private int cookingProgress = 0;
    private int cookingTotalTime = 200;

    public KilnBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(TalonRegistry.Kiln_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> KilnBlockEntity.this.litTime;
                    case 1 -> KilnBlockEntity.this.litDuration;
                    case 2 -> KilnBlockEntity.this.cookingProgress;
                    case 3 -> KilnBlockEntity.this.cookingTotalTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> KilnBlockEntity.this.litTime = pValue;
                    case 1 -> KilnBlockEntity.this.litDuration = pValue;
                    case 2 -> KilnBlockEntity.this.cookingProgress = pValue;
                    case 3 -> KilnBlockEntity.this.cookingTotalTime = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.talon.kiln");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new KilnMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("Inventory", itemHandler.serializeNBT());
        pTag.putInt("BurnTime", this.litTime);
        pTag.putInt("CookTime", this.cookingProgress);
        pTag.putInt("CookTimeTotal", this.cookingTotalTime);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        litTime = pTag.getInt("kiln.lit_time");
        cookingProgress = pTag.getInt("kiln.cooking_progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (hasFuel()) {
            getFuelTime();
        }
        if (hasRecipe() && hasFuel()) {
            increaseCookingProgress();
            increaseLitTime();
            setChanged(pLevel, pPos, pState);

            if(hasCookingProgressFinished() && litTime > 0) {
                craftItem();
                resetCookingProgress();
            } else if (hasLitTimeFinished()) {
                resetLitTime();
            }
        } else {
            resetCookingProgress();
        }

        if (litTime > 0) {
            pState.setValue(KilnBlock.LIT, true);
        } else {
            pState.setValue(KilnBlock.LIT, false);
        }
    }

    private void resetCookingProgress() {
        cookingProgress = 0;
    }
    private void resetLitTime() {
        litTime = 0;
    }

    private void craftItem() {
        ItemStack result = new ItemStack(TalonRegistry.Rose_Gold_Ingot.get(), 1);
        this.itemHandler.extractItem(INPUT_SLOT_1ST, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT_2ND, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasRecipe() {
        boolean hasCraftingItem1 = this.itemHandler.getStackInSlot(INPUT_SLOT_1ST).getItem() == Items.COPPER_INGOT;
        boolean hasCraftingItem2 = this.itemHandler.getStackInSlot(INPUT_SLOT_2ND).getItem() == Items.GOLD_INGOT;
        ItemStack result = new ItemStack(TalonRegistry.Rose_Gold_Ingot.get());

        return hasCraftingItem1 && hasCraftingItem2 && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }
    private boolean hasFuel() {
        return isFuel(this.itemHandler.getStackInSlot(FUEL_SLOT));
    }

    private int getFuelTime() {
        if (!(this.itemHandler.getStackInSlot(FUEL_SLOT).getItem().getDefaultInstance() == null)) {
            litDuration = net.minecraftforge.common.ForgeHooks.getBurnTime(this.itemHandler.getStackInSlot(FUEL_SLOT).getItem().getDefaultInstance(), null);

        } else {
            litDuration = 1;
        }
        return litDuration;
    }

    public static boolean isFuel(ItemStack pStack) {
        return net.minecraftforge.common.ForgeHooks.getBurnTime(pStack, null) > 0;
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasCookingProgressFinished() {
        return cookingProgress >= cookingTotalTime;
    }
    private boolean hasLitTimeFinished() {
        return litTime >= litDuration;
    }

    private void increaseCookingProgress() {
        cookingProgress++;
    }
    private void increaseLitTime() {
        litTime++;
    }
}
