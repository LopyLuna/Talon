package uwu.lopyluna.talon.dataGen.gens;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import uwu.lopyluna.talon.Talon;
import uwu.lopyluna.talon.baseRegistry.TalonRegistry;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings({"all"})
public class BlockTag extends BlockTagsProvider {
    public BlockTag(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Talon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                TalonRegistry.Rose_Gold_Block.get(),
                TalonRegistry.Kiln.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(TalonRegistry.Rose_Gold_Block.get()
                );
        this.tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(TalonRegistry.Rose_Gold_Block.get()
                );
        this.tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(TalonRegistry.Rose_Gold_Block.get()
                );
    }
}
