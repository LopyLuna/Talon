package uwu.lopyluna.talon.dataGen.gens;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.talon.Talon;
import uwu.lopyluna.talon.baseRegistry.TalonRegistry;

@SuppressWarnings({"all"})
public class Blockstate extends BlockStateProvider {
    public Blockstate(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Talon.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(TalonRegistry.Rose_Gold_Block);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
