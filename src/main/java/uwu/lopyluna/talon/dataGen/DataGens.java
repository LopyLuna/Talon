package uwu.lopyluna.talon.dataGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import uwu.lopyluna.talon.Talon;
import uwu.lopyluna.talon.dataGen.gens.*;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Talon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGens {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        boolean s = event.includeServer();
        boolean c = event.includeClient();


        generator.addProvider(s, new Recipes(packOutput));
        generator.addProvider(s, BlockLootTables.create(packOutput));

        generator.addProvider(c, new Blockstate(packOutput, existingFileHelper));
        generator.addProvider(c, new ItemModel(packOutput, existingFileHelper));

        BlockTag blockTagGenerator = generator.addProvider(s, new BlockTag(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(s, new ItemTag(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }

}
