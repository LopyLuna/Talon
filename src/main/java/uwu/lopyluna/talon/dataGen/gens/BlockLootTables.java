package uwu.lopyluna.talon.dataGen.gens;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.talon.baseRegistry.TalonRegistry;

import java.util.List;
import java.util.Set;

@SuppressWarnings({"all"})
public class BlockLootTables extends BlockLootSubProvider {
    public BlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(TalonRegistry.Rose_Gold_Block.get());
        this.dropSelf(TalonRegistry.Kiln.get());

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TalonRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
