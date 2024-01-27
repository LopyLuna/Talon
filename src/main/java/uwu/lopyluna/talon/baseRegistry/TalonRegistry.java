package uwu.lopyluna.talon.baseRegistry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import uwu.lopyluna.talon.Talon;
import uwu.lopyluna.talon.baseRegistry.block_properties.KilnBlock;

import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;


@SuppressWarnings({"all"})
public class TalonRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Talon.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Talon.MOD_ID);
    public static String UT = "_smithing_template";
    public static String PB = "_pebble";
    public static String PK = "_planks";

    //ITEMS

    public static final RegistryObject<Item>

            //STONE TYPES

            Cobblestone_UT = Item("cobblestone" + UT, new Item.Properties()),
            Cobblestone_PB = Item("cobblestone" + PB, new Item.Properties()),
            Diorite_UT = Item("diorite" + UT, new Item.Properties()),
            Diorite_PB = Item("diorite" + PB, new Item.Properties()),
            Granite_UT = Item("granite" + UT, new Item.Properties()),
            Granite_PB = Item("granite" + PB, new Item.Properties()),
            Andesite_UT = Item("andesite" + UT, new Item.Properties()),
            Andesite_PB = Item("andesite" + PB, new Item.Properties()),
            Deepslate_UT = Item("deepslate" + UT, new Item.Properties()),
            Deepslate_PB = Item("deepslate" + PB, new Item.Properties()),
            Tuff_UT = Item("tuff" + UT, new Item.Properties()),
            Tuff_PB = Item("tuff" + PB, new Item.Properties()),
            Calcite_UT = Item("calcite" + UT, new Item.Properties()),
            Calcite_PB = Item("calcite" + PB, new Item.Properties()),
            Dripstone_UT = Item("dripstone" + UT, new Item.Properties()),
            Dripstone_PB = Item("dripstone" + PB, new Item.Properties()),
            Netherrack_UT = Item("netherrack" + UT, new Item.Properties()),
            Netherrack_PB = Item("netherrack" + PB, new Item.Properties()),
            Blackstone_UT = Item("blackstone" + UT, new Item.Properties()),
            Blackstone_PB = Item("blackstone" + PB, new Item.Properties()),
            Endstone_UT = Item("endstone" + UT, new Item.Properties()),
            Endstone_PB = Item("endstone" + PB, new Item.Properties()),

            //WOOD TYPES

            Oak_UT = Item("oak" + UT, new Item.Properties()),
            Spruce_UT = Item("spruce" + UT, new Item.Properties()),
            Birch_UT = Item("birch" + UT, new Item.Properties()),
            Jungle_UT = Item("jungle" + UT, new Item.Properties()),
            Acacia_UT = Item("acacia" + UT, new Item.Properties()),
            Dark_Oak_UT = Item("dark_oak" + UT, new Item.Properties()),
            Mangrove_UT = Item("mangrove" + UT, new Item.Properties()),
            Cherry_UT = Item("cherry" + UT, new Item.Properties()),
            Crimson_UT = Item("crimson" + UT, new Item.Properties()),
            Warped_UT = Item("warped" + UT, new Item.Properties()),

            //MATERIALS

            Mud_Brick = Item("mud_brick", new Item.Properties()),
            Packed_Mud_Brick = Item("packed_mud_brick", new Item.Properties()),
            Template_Blank = Item("template_blank", new Item.Properties()),
            Template_Blade = Item("template_blade", new Item.Properties()),
            Template_Shovel_head = Item("template_shovel_head", new Item.Properties()),
            Template_Pickaxe_head = Item("template_pickaxe_head", new Item.Properties()),
            Template_Axe_head = Item("template_axe_head", new Item.Properties()),
            Template_Hoe_head = Item("template_hoe_head", new Item.Properties()),

            Rose_Gold = Item("rose_gold_ingot", new Item.Properties()),
            Rose_Gold_Nugget = Item("rose_gold_nugget", new Item.Properties()),
            Copper_Nugget = Item("copper_nugget", new Item.Properties());

    public static final RegistryObject<CombustableItem>
            Oak_PK = CombustableItem("oak" + PK, 75, new Item.Properties()),
            Spruce_PK = CombustableItem("spruce" + PK, 75, new Item.Properties()),
            Birch_PK = CombustableItem("birch" + PK, 75, new Item.Properties()),
            Jungle_PK = CombustableItem("jungle" + PK, 75, new Item.Properties()),
            Acacia_PK = CombustableItem("acacia" + PK, 75, new Item.Properties()),
            Dark_Oak_PK = CombustableItem("dark_oak" + PK, 75, new Item.Properties()),
            Mangrove_PK = CombustableItem("mangrove" + PK, 75, new Item.Properties()),
            Cherry_PK = CombustableItem("cherry" + PK, 75, new Item.Properties()),
            Crimson_PK = CombustableItem("crimson" + PK, 75, new Item.Properties()),
            Warped_PK = CombustableItem("warped" + PK, 75, new Item.Properties());

    ;

    public static final RegistryObject<ToolpartItem>
            //TOOLPART TYPES

            //PICKAXE HEADS
            netherite_pickaxe_head = ToolpartItem("netherite_pickaxe_head", new Item.Properties()),
            diamond_pickaxe_head = ToolpartItem("diamond_pickaxe_head", new Item.Properties()),
            iron_pickaxe_head = ToolpartItem("iron_pickaxe_head", new Item.Properties()),
            rose_gold_pickaxe_head = ToolpartItem("rose_gold_pickaxe_head", new Item.Properties()),
            gold_pickaxe_head = ToolpartItem("gold_pickaxe_head", new Item.Properties()),
            stone_pickaxe_head = ToolpartItem("stone_pickaxe_head", new Item.Properties()),

            //AXE HEADS
            netherite_axe_head = ToolpartItem("netherite_axe_head", new Item.Properties()),
            diamond_axe_head = ToolpartItem("diamond_axe_head", new Item.Properties()),
            iron_axe_head = ToolpartItem("iron_axe_head", new Item.Properties()),
            rose_gold_axe_head = ToolpartItem("rose_gold_axe_head", new Item.Properties()),
            gold_axe_head = ToolpartItem("gold_axe_head", new Item.Properties()),
            stone_axe_head = ToolpartItem("stone_axe_head", new Item.Properties()),

            //SHOVEL HEADS
            netherite_shovel_head = ToolpartItem("netherite_shovel_head", new Item.Properties()),
            diamond_shovel_head = ToolpartItem("diamond_shovel_head", new Item.Properties()),
            iron_shovel_head = ToolpartItem("iron_shovel_head", new Item.Properties()),
            rose_gold_shovel_head = ToolpartItem("rose_gold_shovel_head", new Item.Properties()),
            gold_shovel_head = ToolpartItem("gold_shovel_head", new Item.Properties()),
            stone_shovel_head = ToolpartItem("stone_shovel_head", new Item.Properties()),

            //HOE HEADS
            netherite_hoe_head = ToolpartItem("netherite_hoe_head", new Item.Properties()),
            diamond_hoe_head = ToolpartItem("diamond_hoe_head", new Item.Properties()),
            iron_hoe_head = ToolpartItem("iron_hoe_head", new Item.Properties()),
            rose_gold_hoe_head = ToolpartItem("rose_gold_hoe_head", new Item.Properties()),
            gold_hoe_head = ToolpartItem("gold_hoe_head", new Item.Properties()),
            stone_hoe_head = ToolpartItem("stone_hoe_head", new Item.Properties()),

            //BLADES
            netherite_blade = ToolpartItem("netherite_blade", new Item.Properties()),
            diamond_blade = ToolpartItem("diamond_blade", new Item.Properties()),
            iron_blade = ToolpartItem("iron_blade", new Item.Properties()),
            rose_gold_blade = ToolpartItem("rose_gold_blade", new Item.Properties()),
            gold_blade = ToolpartItem("gold_blade", new Item.Properties()),
            stone_blade = ToolpartItem("stone_blade", new Item.Properties());

    ;

    //ITEMS WITH PROPERTIES

    public static final RegistryObject<Item> Rose_Gold_Sword = ITEMS.register("rose_gold_sword",
            () -> new SwordItem(TalonTiers.TierRoseGold, 3, -2.4F, new Item.Properties()
                    .stacksTo(1)
            ));
    public static final RegistryObject<Item> Rose_Gold_Shovel = ITEMS.register("rose_gold_shovel",
            () -> new ShovelItem(TalonTiers.TierRoseGold, 1.5F, -3.0F, new Item.Properties()
                    .stacksTo(1)
            ));
    public static final RegistryObject<Item> Rose_Gold_Pickaxe = ITEMS.register("rose_gold_pickaxe",
            () -> new PickaxeItem(TalonTiers.TierRoseGold, 1, -2.8F, new Item.Properties()
                    .stacksTo(1)
            ));
    public static final RegistryObject<Item> Rose_Gold_Axe = ITEMS.register("rose_gold_axe",
            () -> new AxeItem(TalonTiers.TierRoseGold, 6.0F, -3.0F, new Item.Properties()
                    .stacksTo(1)
            ));
    public static final RegistryObject<Item> Rose_Gold_Hoe = ITEMS.register("rose_gold_hoe",
            () -> new HoeItem(TalonTiers.TierRoseGold, 0, -3.0F, new Item.Properties()
                    .stacksTo(1)
            ));

    public static final RegistryObject<Item> Rose_Gold_UT = ITEMS.register("rose_gold_upgrade_smithing_template",
            () -> new Item(new Item.Properties()
            ));


    //BLOCKS + BLOCKS WITH PROPERTIES

    public static final RegistryObject<Block>
            Rose_Gold_Block = Block("rose_gold_block",
            new Item.Properties(), 5.0F, 6.0F, SoundType.METAL, MapColor.DIAMOND,
            BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops());


    public static final RegistryObject<KilnBlock> Kiln = regBlock("kiln",
            () -> new KilnBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).strength(3.5F).lightLevel(litBlockEmission(13))), new Item.Properties());









    //TAGS

    public static class TalonItemTags {



        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Talon.MOD_ID, name));
        }
    }
    public static class TalonBlockTags {

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Talon.MOD_ID, name));
        }
    }

    //CUSTOM SIMPLIFIED CODE HELPERS (I would call it)

    public static class CombustableItem extends Item {
        public int burnTime = 0;
        public CombustableItem(Properties pProperties, int burnTime) {super(pProperties);this.burnTime = burnTime;}
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {return this.burnTime;}
    }
    public static class ToolpartItem extends Item {
        public ToolpartItem(Properties pProperties) {super(pProperties.stacksTo(16));}
    }

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Talon.MOD_ID);

    //Make sures anything that is UpperCase turns to LowerCased
    public static RegistryObject<Item> Item(String id, Item.Properties pIProp) {
        return regItem(id.toLowerCase(), pIProp);}

    public static RegistryObject<CombustableItem> CombustableItem(String id, int burnTime, Item.Properties pIProp) {
        return regCombustableItem(id.toLowerCase(), burnTime, pIProp);}

    public static RegistryObject<ToolpartItem> ToolpartItem(String id, Item.Properties pIProp) {
        return regToolpartItem(id.toLowerCase(), pIProp);}

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

    public static RegistryObject<ToolpartItem> regToolpartItem(String id, Item.Properties pIProp) {
        return ITEMS.register(id, () -> new ToolpartItem(pIProp));}
    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
        };
    }

    public class TalonTiers {
        public static final Tier TierRoseGold = TierSortingRegistry.registerTier(
                new ForgeTier(2, 250, 12.0F, 1.0F, 18,
                        BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Rose_Gold.get())),
                new ResourceLocation(Talon.MOD_ID, "rose_gold"), List.of(Tiers.GOLD), List.of());
    }


    // CREATIVE MODE TABS

    public static final RegistryObject<CreativeModeTab> TALON_TAB = CREATIVE_MODE_TABS.register("talon_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Rose_Gold.get()))
                    .title(Component.translatable(Talon.NAME))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Rose_Gold_Block.get());
                        pOutput.accept(Rose_Gold.get());
                        pOutput.accept(Rose_Gold_Nugget.get());
                        pOutput.accept(Rose_Gold_UT.get());
                        pOutput.accept(Rose_Gold_Sword.get());
                        pOutput.accept(Rose_Gold_Pickaxe.get());
                        pOutput.accept(Rose_Gold_Axe.get());
                        pOutput.accept(Rose_Gold_Shovel.get());
                        pOutput.accept(Rose_Gold_Hoe.get());

                        pOutput.accept(Copper_Nugget.get());
                        pOutput.accept(Mud_Brick.get().asItem());
                        pOutput.accept(Packed_Mud_Brick.get().asItem());
                        pOutput.accept(Kiln.get().asItem());

                        pOutput.accept(Cobblestone_PB.get());
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
                        pOutput.accept(Rose_Gold_UT.get());
                        pOutput.accept(Cobblestone_UT.get());
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

    public static final RegistryObject<CreativeModeTab> TALON_TAB_TOOL = CREATIVE_MODE_TABS.register("talon_tab_toolparts",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(rose_gold_axe_head.get()))
                    .title(Component.translatable("Toolparts"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Template_Blank.get());
                        pOutput.accept(Template_Pickaxe_head.get());
                        pOutput.accept(Template_Axe_head.get());
                        pOutput.accept(Template_Shovel_head.get());
                        pOutput.accept(Template_Hoe_head.get());
                        pOutput.accept(Template_Blade.get());
                        pOutput.accept(netherite_pickaxe_head.get());
                        pOutput.accept(netherite_axe_head.get());
                        pOutput.accept(netherite_shovel_head.get());
                        pOutput.accept(netherite_hoe_head.get());
                        pOutput.accept(netherite_blade.get());
                        pOutput.accept(diamond_pickaxe_head.get());
                        pOutput.accept(diamond_axe_head.get());
                        pOutput.accept(diamond_shovel_head.get());
                        pOutput.accept(diamond_hoe_head.get());
                        pOutput.accept(diamond_blade.get());
                        pOutput.accept(iron_pickaxe_head.get());
                        pOutput.accept(iron_axe_head.get());
                        pOutput.accept(iron_shovel_head.get());
                        pOutput.accept(iron_hoe_head.get());
                        pOutput.accept(iron_blade.get());
                        pOutput.accept(rose_gold_pickaxe_head.get());
                        pOutput.accept(rose_gold_axe_head.get());
                        pOutput.accept(rose_gold_shovel_head.get());
                        pOutput.accept(rose_gold_hoe_head.get());
                        pOutput.accept(rose_gold_blade.get());
                        pOutput.accept(gold_pickaxe_head.get());
                        pOutput.accept(gold_axe_head.get());
                        pOutput.accept(gold_shovel_head.get());
                        pOutput.accept(gold_hoe_head.get());
                        pOutput.accept(gold_blade.get());
                        pOutput.accept(stone_pickaxe_head.get());
                        pOutput.accept(stone_axe_head.get());
                        pOutput.accept(stone_shovel_head.get());
                        pOutput.accept(stone_hoe_head.get());
                        pOutput.accept(stone_blade.get());
                    }).withSearchBar()
                    .build());
}
