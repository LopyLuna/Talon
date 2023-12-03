package uwu.lopyluna.talon.baseRegistry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import uwu.lopyluna.talon.Talon;

import java.util.function.Supplier;

import static uwu.lopyluna.talon.baseRegistry.TalonRegistry.TalonProperties.BlockProperties;
import static uwu.lopyluna.talon.baseRegistry.TalonRegistry.TalonProperties.ItemProperties;

@SuppressWarnings({"all"})
public class TalonRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Talon.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Talon.MOD_ID);
    public static String UT = "_smithing_template";
    public static String PB = "_pebble";
    public static String PK = "_planks";


    public static final RegistryObject<Item>

            //STONE TYPES

            Cobblestone_UT = Item("cobblestone" + UT, ItemProperties),
            Cobblestone_PB = Item("cobblestone" + PB, ItemProperties),
            Mossy_Cobblestone_UT = Item("mossy_cobblestone" + UT, ItemProperties),
            Mossy_Cobblestone_PB = Item("mossy_cobblestone" + PB, ItemProperties),
            Diorite_UT = Item("diorite" + UT, ItemProperties),
            Diorite_PB = Item("diorite" + PB, ItemProperties),
            Granite_UT = Item("granite" + UT, ItemProperties),
            Granite_PB = Item("granite" + PB, ItemProperties),
            Andesite_UT = Item("andesite" + UT, ItemProperties),
            Andesite_PB = Item("andesite" + PB, ItemProperties),
            Sandstone_UT = Item("sandstone" + UT, ItemProperties),
            Sandstone_PB = Item("sandstone" + PB, ItemProperties),
            Red_Sandstone_UT = Item("red_sandstone" + UT, ItemProperties),
            Red_Sandstone_PB = Item("red_sandstone" + PB, ItemProperties),
            Deepslate_UT = Item("deepslate" + UT, ItemProperties),
            Deepslate_PB = Item("deepslate" + PB, ItemProperties),
            Tuff_UT = Item("tuff" + UT, ItemProperties),
            Tuff_PB = Item("tuff" + PB, ItemProperties),
            Calcite_UT = Item("calcite" + UT, ItemProperties),
            Calcite_PB = Item("calcite" + PB, ItemProperties),
            Dripstone_UT = Item("dripstone" + UT, ItemProperties),
            Dripstone_PB = Item("dripstone" + PB, ItemProperties),
            Netherrack_UT = Item("netherrack" + UT, ItemProperties),
            Netherrack_PB = Item("netherrack" + PB, ItemProperties),
            Blackstone_UT = Item("blackstone" + UT, ItemProperties),
            Blackstone_PB = Item("blackstone" + PB, ItemProperties),
            Endstone_UT = Item("endstone" + UT, ItemProperties),
            Endstone_PB = Item("endstone" + PB, ItemProperties),

            //WOOD TYPES

            Oak_UT = Item("oak" + UT, ItemProperties),
            Spruce_UT = Item("spruce" + UT, ItemProperties),
            Birch_UT = Item("birch" + UT, ItemProperties),
            Jungle_UT = Item("jungle" + UT, ItemProperties),
            Acacia_UT = Item("acacia" + UT, ItemProperties),
            Dark_Oak_UT = Item("dark_oak" + UT, ItemProperties),
            Mangrove_UT = Item("mangrove" + UT, ItemProperties),
            Cherry_UT = Item("cherry" + UT, ItemProperties),
            Crimson_UT = Item("crimson" + UT, ItemProperties),
            Warped_UT = Item("warped" + UT, ItemProperties),

            //MATERIALS

            Rose_Gold = Item("rose_gold_ingot", ItemProperties),
            Rose_Gold_Nugget = Item("rose_gold_nugget", ItemProperties),
            Copper_Nugget = Item("copper_nugget", ItemProperties);

    public static final RegistryObject<CombustableItem>
            Oak_PK = CombustableItem("oak" + PK, 75, ItemProperties),
            Spruce_PK = CombustableItem("spruce" + PK, 75, ItemProperties),
            Birch_PK = CombustableItem("birch" + PK, 75, ItemProperties),
            Jungle_PK = CombustableItem("jungle" + PK, 75, ItemProperties),
            Acacia_PK = CombustableItem("acacia" + PK, 75, ItemProperties),
            Dark_Oak_PK = CombustableItem("dark_oak" + PK, 75, ItemProperties),
            Mangrove_PK = CombustableItem("mangrove" + PK, 75, ItemProperties),
            Cherry_PK = CombustableItem("cherry" + PK, 75, ItemProperties),
            Crimson_PK = CombustableItem("crimson" + PK, 75, ItemProperties),
            Warped_PK = CombustableItem("warped" + PK, 75, ItemProperties);

    ;



    public static final RegistryObject<Block>
            Rose_Gold_Block = Block("rose_gold_block",
            ItemProperties, 5.0F, 6.0F, SoundType.METAL, MapColor.DIAMOND,
            BlockProperties.requiresCorrectToolForDrops());
















    public class TalonProperties {
        public static Item.Properties ItemProperties = new Item.Properties();
        public static Block.Properties BlockProperties = BlockBehaviour.Properties.copy(Blocks.STONE);
    }

    public static class CombustableItem extends Item {
        public int burnTime = 0;
        public CombustableItem(Properties pProperties, int burnTime) {super(pProperties);this.burnTime = burnTime;}
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {return this.burnTime;}
    }

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Talon.MOD_ID);

    public static RegistryObject<Item> Item(String id, Item.Properties pIProp) {
        return regItem(id.toLowerCase(), pIProp);}

    public static RegistryObject<CombustableItem> CombustableItem(String id, int burnTime, Item.Properties pIProp) {
        return regCombustableItem(id.toLowerCase(), burnTime, pIProp);}

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

    public static RegistryObject<CombustableItem> regCombustableItem(String id, int burnTime, Item.Properties pIProp) {
        return ITEMS.register(id, () -> new CombustableItem(pIProp, burnTime));}


    public static final RegistryObject<CreativeModeTab> TALON_TAB = CREATIVE_MODE_TABS.register("talon_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Rose_Gold.get()))
                    .title(Component.translatable(Talon.NAME))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Rose_Gold.get());
                        pOutput.accept(Rose_Gold_Nugget.get());
                        pOutput.accept(Rose_Gold_Block.get().asItem());
                        pOutput.accept(Copper_Nugget.get());



                        pOutput.accept(Cobblestone_PB.get());
                        pOutput.accept(Mossy_Cobblestone_PB.get());
                        pOutput.accept(Diorite_PB.get());
                        pOutput.accept(Granite_PB.get());
                        pOutput.accept(Andesite_PB.get());
                        pOutput.accept(Deepslate_PB.get());
                        pOutput.accept(Tuff_PB.get());
                        pOutput.accept(Calcite_PB.get());
                        pOutput.accept(Dripstone_PB.get());
                        pOutput.accept(Netherrack_PB.get());
                        pOutput.accept(Blackstone_PB.get());
                        pOutput.accept(Endstone_PB.get());
                        pOutput.accept(Oak_PK.get());
                        pOutput.accept(Spruce_PK.get());
                        pOutput.accept(Birch_PK.get());
                        pOutput.accept(Jungle_PK.get());
                        pOutput.accept(Acacia_PK.get());
                        pOutput.accept(Dark_Oak_PK.get());
                        pOutput.accept(Mangrove_PK.get());
                        pOutput.accept(Cherry_PK.get());
                        pOutput.accept(Crimson_PK.get());
                        pOutput.accept(Warped_PK.get());
                    }).withSearchBar()
                    .build());


    public static final RegistryObject<CreativeModeTab> TALON_TAB_UT = CREATIVE_MODE_TABS.register("talon_tab_upgrade_templates",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                    .title(Component.translatable("Smithing Upgrade"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE);
                        pOutput.accept(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                        pOutput.accept(Cobblestone_UT.get());
                        pOutput.accept(Mossy_Cobblestone_UT.get());
                        pOutput.accept(Diorite_UT.get());
                        pOutput.accept(Granite_UT.get());
                        pOutput.accept(Andesite_UT.get());
                        pOutput.accept(Deepslate_UT.get());
                        pOutput.accept(Tuff_UT.get());
                        pOutput.accept(Calcite_UT.get());
                        pOutput.accept(Dripstone_UT.get());
                        pOutput.accept(Netherrack_UT.get());
                        pOutput.accept(Blackstone_UT.get());
                        pOutput.accept(Endstone_UT.get());
                        pOutput.accept(Oak_UT.get());
                        pOutput.accept(Spruce_UT.get());
                        pOutput.accept(Birch_UT.get());
                        pOutput.accept(Jungle_UT.get());
                        pOutput.accept(Acacia_UT.get());
                        pOutput.accept(Dark_Oak_UT.get());
                        pOutput.accept(Mangrove_UT.get());
                        pOutput.accept(Cherry_UT.get());
                        pOutput.accept(Crimson_UT.get());
                        pOutput.accept(Warped_UT.get());
                    })
                    .build());
}
