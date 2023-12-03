package uwu.lopyluna.talon.dataGen.gens;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.talon.Talon;
import uwu.lopyluna.talon.baseRegistry.TalonRegistry;

@SuppressWarnings({"all"})
public class ItemModel extends ItemModelProvider {
    public ItemModel(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Talon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(TalonRegistry.Cobblestone_UT);
        simpleItem(TalonRegistry.Cobblestone_PB);
        simpleItem(TalonRegistry.Mossy_Cobblestone_UT);
        simpleItem(TalonRegistry.Mossy_Cobblestone_PB);
        simpleItem(TalonRegistry.Diorite_UT);
        simpleItem(TalonRegistry.Diorite_PB);
        simpleItem(TalonRegistry.Granite_UT);
        simpleItem(TalonRegistry.Granite_PB);
        simpleItem(TalonRegistry.Andesite_UT);
        simpleItem(TalonRegistry.Andesite_PB);
        simpleItem(TalonRegistry.Deepslate_UT);
        simpleItem(TalonRegistry.Deepslate_PB);
        simpleItem(TalonRegistry.Tuff_UT);
        simpleItem(TalonRegistry.Tuff_PB);
        simpleItem(TalonRegistry.Calcite_UT);
        simpleItem(TalonRegistry.Calcite_PB);
        simpleItem(TalonRegistry.Dripstone_UT);
        simpleItem(TalonRegistry.Dripstone_PB);
        simpleItem(TalonRegistry.Netherrack_UT);
        simpleItem(TalonRegistry.Netherrack_PB);
        simpleItem(TalonRegistry.Blackstone_UT);
        simpleItem(TalonRegistry.Blackstone_PB);
        simpleItem(TalonRegistry.Endstone_UT);
        simpleItem(TalonRegistry.Endstone_PB);
        simpleItem(TalonRegistry.Oak_UT);
        simpleItem(TalonRegistry.Spruce_UT);
        simpleItem(TalonRegistry.Birch_UT);
        simpleItem(TalonRegistry.Jungle_UT);
        simpleItem(TalonRegistry.Acacia_UT);
        simpleItem(TalonRegistry.Dark_Oak_UT);
        simpleItem(TalonRegistry.Mangrove_UT);
        simpleItem(TalonRegistry.Cherry_UT);
        simpleItem(TalonRegistry.Crimson_UT);
        simpleItem(TalonRegistry.Warped_UT);
        simpleItem(TalonRegistry.Rose_Gold);
        simpleItem(TalonRegistry.Rose_Gold_Nugget);
        simpleCombustableItem(TalonRegistry.Oak_PK);
        simpleCombustableItem(TalonRegistry.Spruce_PK);
        simpleCombustableItem(TalonRegistry.Birch_PK);
        simpleCombustableItem(TalonRegistry.Jungle_PK);
        simpleCombustableItem(TalonRegistry.Acacia_PK);
        simpleCombustableItem(TalonRegistry.Dark_Oak_PK);
        simpleCombustableItem(TalonRegistry.Mangrove_PK);
        simpleCombustableItem(TalonRegistry.Cherry_PK);
        simpleCombustableItem(TalonRegistry.Crimson_PK);
        simpleCombustableItem(TalonRegistry.Warped_PK);

    }






    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Talon.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleCombustableItem(RegistryObject<TalonRegistry.CombustableItem> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Talon.MOD_ID,"item/" + item.getId().getPath()));
    }
}
