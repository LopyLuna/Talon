package uwu.lopyluna.talon.dataGen.gens;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import uwu.lopyluna.talon.baseRegistry.TalonRegistry;

import java.util.function.Consumer;

@SuppressWarnings({"all"})
public class Recipes extends RecipeProvider implements IConditionBuilder {

    public Recipes(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        CompressRecipeFull(TalonRegistry.Rose_Gold.get(), TalonRegistry.Rose_Gold_Block.get().asItem(), 1).save(pWriter);
        DeCompressRecipe(TalonRegistry.Rose_Gold_Block.get().asItem(), TalonRegistry.Rose_Gold.get(), 9).save(pWriter);

        CompressRecipeFull(TalonRegistry.Rose_Gold_Nugget.get(), TalonRegistry.Rose_Gold.get(), 1).save(pWriter);
        DeCompressRecipe(TalonRegistry.Rose_Gold.get(), TalonRegistry.Rose_Gold_Nugget.get(), 9).save(pWriter);


        CompressRecipeQuad(TalonRegistry.Oak_PK.get(), Items.OAK_PLANKS, 1).save(pWriter);
        DeCompressRecipe(Items.OAK_PLANKS, TalonRegistry.Oak_PK.get(), 4).save(pWriter);

        CompressRecipeQuad(TalonRegistry.Spruce_PK.get(), Items.SPRUCE_PLANKS, 1).save(pWriter);
        DeCompressRecipe(Items.SPRUCE_PLANKS, TalonRegistry.Spruce_PK.get(), 4).save(pWriter);

        CompressRecipeQuad(TalonRegistry.Birch_PK.get(), Items.BIRCH_PLANKS, 1).save(pWriter);
        DeCompressRecipe(Items.BIRCH_PLANKS, TalonRegistry.Birch_PK.get(), 4).save(pWriter);

        CompressRecipeQuad(TalonRegistry.Acacia_PK.get(), Items.ACACIA_PLANKS, 1).save(pWriter);
        DeCompressRecipe(Items.ACACIA_PLANKS, TalonRegistry.Acacia_PK.get(), 4).save(pWriter);

        CompressRecipeQuad(TalonRegistry.Cherry_PK.get(), Items.CHERRY_PLANKS, 1).save(pWriter);
        DeCompressRecipe(Items.CHERRY_PLANKS, TalonRegistry.Cherry_PK.get(), 4).save(pWriter);

        CompressRecipeQuad(TalonRegistry.Crimson_PK.get(), Items.CRIMSON_PLANKS, 1).save(pWriter);
        DeCompressRecipe(Items.CRIMSON_PLANKS, TalonRegistry.Crimson_PK.get(), 4).save(pWriter);

        CompressRecipeQuad(TalonRegistry.Dark_Oak_PK.get(), Items.DARK_OAK_PLANKS, 1).save(pWriter);
        DeCompressRecipe(Items.DARK_OAK_PLANKS, TalonRegistry.Dark_Oak_PK.get(), 4).save(pWriter);

        CompressRecipeQuad(TalonRegistry.Jungle_PK.get(), Items.JUNGLE_PLANKS, 1).save(pWriter);
        DeCompressRecipe(Items.JUNGLE_PLANKS, TalonRegistry.Jungle_PK.get(), 4).save(pWriter);

        CompressRecipeQuad(TalonRegistry.Mangrove_PK.get(), Items.MANGROVE_PLANKS, 1).save(pWriter);
        DeCompressRecipe(Items.MANGROVE_PLANKS, TalonRegistry.Mangrove_PK.get(), 4).save(pWriter);

        CompressRecipeQuad(TalonRegistry.Warped_PK.get(), Items.WARPED_PLANKS, 1).save(pWriter);
        DeCompressRecipe(Items.WARPED_PLANKS, TalonRegistry.Warped_PK.get(), 4).save(pWriter);
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

    public static ShapelessRecipeBuilder DeCompressRecipe(Item input, Item output, int count) {
        return ShapelessRecipeBuilder.shapeless (RecipeCategory.MISC, output, count)
                .requires(input)
                .unlockedBy(getHasName(input), has(input));
    }

}
