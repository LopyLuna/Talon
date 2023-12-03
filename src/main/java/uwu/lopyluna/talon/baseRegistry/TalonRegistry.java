package uwu.lopyluna.talon.baseRegistry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.talon.Talon;

import java.util.function.Supplier;

import static uwu.lopyluna.talon.baseRegistry.TalonRegistry.TalonProperties.BP;
import static uwu.lopyluna.talon.baseRegistry.TalonRegistry.TalonProperties.IP;

@SuppressWarnings({"all"})
public class TalonRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Talon.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Talon.MOD_ID);



    public static final RegistryObject<Item>
            ROSE_GOLD = Item("rose_gold", IP),
            ROSE_NUGGET = Item("rose_nugget", IP);

    public static final RegistryObject<Block>
            ROSE_GOLD_BLOCK = Block("rose_gold_block", IP,
            5.0F, 6.0F, SoundType.METAL, MapColor.DIAMOND,
            BP.requiresCorrectToolForDrops());


















    public class TalonProperties {
        public static Item.Properties IP = new Item.Properties();
        public static Block.Properties BP = BlockBehaviour.Properties.copy(Blocks.STONE);
    }

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Talon.MOD_ID);

    public static RegistryObject<Item> Item(String id, Item.Properties pIProp) {
        return regItem(id, pIProp);}

    public static RegistryObject<Block> Block(String id, Item.Properties pIProp, float destroyTime, float explosionResistance, SoundType soundType, MapColor mapColor, Block.Properties pBProp) {
        return regBlock(id, () -> new Block(pBProp.mapColor(mapColor).strength(destroyTime, explosionResistance).sound(soundType)), pIProp);}

    public static RegistryObject<Block> Block(String id, Block.Properties pBProp, Item.Properties pIProp) {
        return regBlock(id, () -> new Block(pBProp), pIProp);}


    public static <T extends Block> RegistryObject<T> regBlock(String id, Supplier<T> block, Item.Properties pIProp) {
        RegistryObject<T> toReturn = BLOCKS.register(id, block);
        regBlockItem(id, toReturn, pIProp);
        return toReturn;
    }

    public static <T extends Block> void regBlockItem(String id, RegistryObject<T> block, Item.Properties pIProp) {
        ITEMS.register(id, () -> new BlockItem(block.get(), pIProp));
    }

    public static RegistryObject<Item> regItem(String id, Item.Properties pIProp) {
        return ITEMS.register(id, () -> new Item(pIProp));}


    public static final RegistryObject<CreativeModeTab> TALON_TAB = CREATIVE_MODE_TABS.register("talon_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ROSE_GOLD.get()))
                    .title(Component.translatable(Talon.NAME))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ROSE_GOLD.get());
                        pOutput.accept(ROSE_NUGGET.get());
                        pOutput.accept(ROSE_GOLD_BLOCK.get().asItem());
                    })
                    .build());
}
