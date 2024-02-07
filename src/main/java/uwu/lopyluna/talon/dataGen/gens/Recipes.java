package uwu.lopyluna.talon.dataGen.gens;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import uwu.lopyluna.talon.Talon;
import uwu.lopyluna.talon.baseRegistry.TalonRegistry;

import java.util.function.Consumer;

@SuppressWarnings({"all"})
public class Recipes extends RecipeProvider implements IConditionBuilder {

    public Recipes(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        CompressRecipeFull(TalonRegistry.Rose_Gold_Ingot.get(), TalonRegistry.Rose_Gold_Block.get().asItem(), 1).save(pWriter, Talon.MOD_ID + ":rose_gold_to_rose_gold_block");
        DeCompressRecipe(TalonRegistry.Rose_Gold_Block.get().asItem(), TalonRegistry.Rose_Gold_Ingot.get(), 9).save(pWriter, Talon.MOD_ID + ":rose_gold_block_to_rose_gold");

        CompressRecipeFull(TalonRegistry.Rose_Gold_Nugget.get(), TalonRegistry.Rose_Gold_Ingot.get(), 1).save(pWriter, Talon.MOD_ID + ":rose_gold_nugget_to_rose_gold");
        DeCompressRecipe(TalonRegistry.Rose_Gold_Ingot.get(), TalonRegistry.Rose_Gold_Nugget.get(), 9).save(pWriter, Talon.MOD_ID + ":rose_gold_to_rose_gold_nugget");

        CompressRecipeFull(TalonRegistry.Copper_Nugget.get(), Items.COPPER_INGOT, 1).save(pWriter, Talon.MOD_ID + ":copper_nugget_to_copper_ingot");
        DeCompressRecipe(Items.COPPER_INGOT, TalonRegistry.Copper_Nugget.get(), 9).save(pWriter, Talon.MOD_ID + ":copper_ingot_to_copper_nugget");

        CompressRecipeQuad(TalonRegistry.Oak_PK.get(), Items.OAK_PLANKS, 1).save(pWriter, Talon.MOD_ID + ":oak_pk_to_oak_planks");
        DeCompressRecipe(Items.OAK_PLANKS, TalonRegistry.Oak_PK.get(), 4).save(pWriter, Talon.MOD_ID + ":oak_planks_to_oak_pk");

        CompressRecipeQuad(TalonRegistry.Spruce_PK.get(), Items.SPRUCE_PLANKS, 1).save(pWriter, Talon.MOD_ID + ":spruce_pk_to_spruce_planks");
        DeCompressRecipe(Items.SPRUCE_PLANKS, TalonRegistry.Spruce_PK.get(), 4).save(pWriter, Talon.MOD_ID + ":spruce_planks_to_spruce_pk");

        CompressRecipeQuad(TalonRegistry.Birch_PK.get(), Items.BIRCH_PLANKS, 1).save(pWriter, Talon.MOD_ID + ":birch_pk_to_birch_planks");
        DeCompressRecipe(Items.BIRCH_PLANKS, TalonRegistry.Birch_PK.get(), 4).save(pWriter, Talon.MOD_ID + ":birch_planks_to_birch_pk");

        CompressRecipeQuad(TalonRegistry.Acacia_PK.get(), Items.ACACIA_PLANKS, 1).save(pWriter, Talon.MOD_ID + ":acacia_pk_to_acacia_planks");
        DeCompressRecipe(Items.ACACIA_PLANKS, TalonRegistry.Acacia_PK.get(), 4).save(pWriter, Talon.MOD_ID + ":acacia_planks_to_acacia_pk");

        CompressRecipeQuad(TalonRegistry.Cherry_PK.get(), Items.CHERRY_PLANKS, 1).save(pWriter, Talon.MOD_ID + ":cherry_pk_to_cherry_planks");
        DeCompressRecipe(Items.CHERRY_PLANKS, TalonRegistry.Cherry_PK.get(), 4).save(pWriter, Talon.MOD_ID + ":cherry_planks_to_cherry_pk");

        CompressRecipeQuad(TalonRegistry.Crimson_PK.get(), Items.CRIMSON_PLANKS, 1).save(pWriter, Talon.MOD_ID + ":crimson_pk_to_crimson_planks");
        DeCompressRecipe(Items.CRIMSON_PLANKS, TalonRegistry.Crimson_PK.get(), 4).save(pWriter, Talon.MOD_ID + ":crimson_planks_to_crimson_pk");

        CompressRecipeQuad(TalonRegistry.Dark_Oak_PK.get(), Items.DARK_OAK_PLANKS, 1).save(pWriter, Talon.MOD_ID + ":dark_oak_pk_to_dark_oak_planks");
        DeCompressRecipe(Items.DARK_OAK_PLANKS, TalonRegistry.Dark_Oak_PK.get(), 4).save(pWriter, Talon.MOD_ID + ":dark_oak_planks_to_dark_oak_pk");

        CompressRecipeQuad(TalonRegistry.Jungle_PK.get(), Items.JUNGLE_PLANKS, 1).save(pWriter, Talon.MOD_ID + ":jungle_pk_to_jungle_planks");
        DeCompressRecipe(Items.JUNGLE_PLANKS, TalonRegistry.Jungle_PK.get(), 4).save(pWriter, Talon.MOD_ID + ":jungle_planks_to_jungle_pk");

        CompressRecipeQuad(TalonRegistry.Mangrove_PK.get(), Items.MANGROVE_PLANKS, 1).save(pWriter, Talon.MOD_ID + ":mangrove_pk_to_mangrove_planks");
        DeCompressRecipe(Items.MANGROVE_PLANKS, TalonRegistry.Mangrove_PK.get(), 4).save(pWriter, Talon.MOD_ID + ":mangrove_planks_to_mangrove_pk");

        CompressRecipeQuad(TalonRegistry.Warped_PK.get(), Items.WARPED_PLANKS, 1).save(pWriter, Talon.MOD_ID + ":warped_pk_to_warped_planks");
        DeCompressRecipe(Items.WARPED_PLANKS, TalonRegistry.Warped_PK.get(), 4).save(pWriter, Talon.MOD_ID + ":warped_planks_to_warped_pk");

        CompressRecipeQuad(TalonRegistry.Packed_Mud_Brick.get(), TalonRegistry.Template_Blank.get().asItem(), 2).save(pWriter, Talon.MOD_ID + ":template_blank_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TalonRegistry.Rose_Gold_UT.get(), 2)
                .pattern("RGR")
                .pattern("RTR")
                .pattern("RCR")
                .define('R', TalonRegistry.Rose_Gold_Ingot.get())
                .define('T', TalonRegistry.Template_Blank.get())
                .define('C', Items.COPPER_INGOT)
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(TalonRegistry.Rose_Gold_Ingot.get()), has(TalonRegistry.Rose_Gold_Ingot.get())
                ).save(pWriter, Talon.MOD_ID + ":rose_gold_upgrade_smithing_template_crafting");

        TemplateRecipe2(TalonRegistry.Template_Blade.get(), Items.DIAMOND, TalonRegistry.diamond_blade.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.diamond_blade.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe3(TalonRegistry.Template_Pickaxe_head.get(), Items.DIAMOND, TalonRegistry.diamond_pickaxe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.diamond_pickaxe_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe3(TalonRegistry.Template_Axe_head.get(), Items.DIAMOND, TalonRegistry.diamond_axe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.diamond_axe_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe1(TalonRegistry.Template_Shovel_head.get(), Items.DIAMOND, TalonRegistry.diamond_shovel_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.diamond_shovel_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe2(TalonRegistry.Template_Hoe_head.get(), Items.DIAMOND, TalonRegistry.diamond_hoe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.diamond_hoe_head.getId().getPath().toLowerCase() + "_crafting");


        TemplateRecipe2(TalonRegistry.Template_Blade.get(), Items.GOLD_INGOT, TalonRegistry.gold_blade.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.gold_blade.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe3(TalonRegistry.Template_Pickaxe_head.get(), Items.GOLD_INGOT, TalonRegistry.gold_pickaxe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.gold_pickaxe_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe3(TalonRegistry.Template_Axe_head.get(), Items.GOLD_INGOT, TalonRegistry.gold_axe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.gold_axe_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe1(TalonRegistry.Template_Shovel_head.get(), Items.GOLD_INGOT, TalonRegistry.gold_shovel_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.gold_shovel_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe2(TalonRegistry.Template_Hoe_head.get(), Items.GOLD_INGOT, TalonRegistry.gold_hoe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.gold_hoe_head.getId().getPath().toLowerCase() + "_crafting");

        TemplateRecipe2(TalonRegistry.Template_Blade.get(), Items.IRON_INGOT, TalonRegistry.iron_blade.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.iron_blade.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe3(TalonRegistry.Template_Pickaxe_head.get(), Items.IRON_INGOT, TalonRegistry.iron_pickaxe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.iron_pickaxe_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe3(TalonRegistry.Template_Axe_head.get(), Items.IRON_INGOT, TalonRegistry.iron_axe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.iron_axe_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe1(TalonRegistry.Template_Shovel_head.get(), Items.IRON_INGOT, TalonRegistry.iron_shovel_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.iron_shovel_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe2(TalonRegistry.Template_Hoe_head.get(), Items.IRON_INGOT, TalonRegistry.iron_hoe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.iron_hoe_head.getId().getPath().toLowerCase() + "_crafting");

        TemplateRecipe2(TalonRegistry.Template_Blade.get(), Ingredient.of(ItemTags.STONE_TOOL_MATERIALS), TalonRegistry.stone_blade.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.stone_blade.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe3(TalonRegistry.Template_Pickaxe_head.get(), Ingredient.of(ItemTags.STONE_TOOL_MATERIALS), TalonRegistry.stone_pickaxe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.stone_pickaxe_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe3(TalonRegistry.Template_Axe_head.get(), Ingredient.of(ItemTags.STONE_TOOL_MATERIALS), TalonRegistry.stone_axe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.stone_axe_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe1(TalonRegistry.Template_Shovel_head.get(), Ingredient.of(ItemTags.STONE_TOOL_MATERIALS), TalonRegistry.stone_shovel_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.stone_shovel_head.getId().getPath().toLowerCase() + "_crafting");
        TemplateRecipe2(TalonRegistry.Template_Hoe_head.get(), Ingredient.of(ItemTags.STONE_TOOL_MATERIALS), TalonRegistry.stone_hoe_head.get(), 1)
                .save(pWriter, Talon.MOD_ID + ":" + TalonRegistry.stone_hoe_head.getId().getPath().toLowerCase() + "_crafting");
    }


    public static ShapedRecipeBuilder CompressRecipeFull(Item input, Item output, int count) {
        return ShapedRecipeBuilder.shaped (RecipeCategory.MISC, output, count)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', input)
                .unlockedBy(getHasName(input), has(input));
    }
    public static ShapedRecipeBuilder CompressRecipeQuad(Item input, Item output, int count) {
        return ShapedRecipeBuilder.shaped (RecipeCategory.MISC, output, count)
                .pattern("SS")
                .pattern("SS")
                .define('S', input)
                .unlockedBy(getHasName(input), has(input));
    }

    public static ShapelessRecipeBuilder TemplateRecipe1(Item template1, ItemLike mat2,Item output, int count) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, count)
                .requires(template1)
                .requires(mat2)
                .unlockedBy(getHasName(mat2), has(mat2));
    }
    public static ShapelessRecipeBuilder TemplateRecipe2(Item template1, ItemLike mat2,Item output, int count) {
        return ShapelessRecipeBuilder.shapeless (RecipeCategory.MISC, output, count)
                .requires(template1)
                .requires(mat2)
                .requires(mat2)
                .unlockedBy(getHasName(mat2), has(mat2));
    }
    public static ShapelessRecipeBuilder TemplateRecipe3(Item template1, ItemLike mat2,Item output, int count) {
        return ShapelessRecipeBuilder.shapeless (RecipeCategory.MISC, output, count)
                .requires(template1)
                .requires(mat2)
                .requires(mat2)
                .requires(mat2)
                .unlockedBy(getHasName(mat2), has(mat2));
    }

    public static ShapelessRecipeBuilder TemplateRecipe1(Item template1, Ingredient mat2,Item output, int count) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, count)
                .requires(template1)
                .requires(mat2)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE));
    }
    public static ShapelessRecipeBuilder TemplateRecipe2(Item template1, Ingredient mat2,Item output, int count) {
        return ShapelessRecipeBuilder.shapeless (RecipeCategory.MISC, output, count)
                .requires(template1)
                .requires(mat2)
                .requires(mat2)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE));
    }
    public static ShapelessRecipeBuilder TemplateRecipe3(Item template1, Ingredient mat2,Item output, int count) {
        return ShapelessRecipeBuilder.shapeless (RecipeCategory.MISC, output, count)
                .requires(template1)
                .requires(mat2)
                .requires(mat2)
                .requires(mat2)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE));
    }

    public static ShapelessRecipeBuilder DeCompressRecipe(Item input, Item output, int count) {
        return ShapelessRecipeBuilder.shapeless (RecipeCategory.MISC, output, count)
                .requires(input)
                .unlockedBy(getHasName(input), has(input));
    }

}
