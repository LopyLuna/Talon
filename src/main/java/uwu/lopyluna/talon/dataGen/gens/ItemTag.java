package uwu.lopyluna.talon.dataGen.gens;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import uwu.lopyluna.talon.Talon;
import uwu.lopyluna.talon.baseRegistry.TalonRegistry;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings({"all"})
public class ItemTag extends ItemTagsProvider {
    public ItemTag(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Talon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(ItemTags.SWORDS)
                .add(TalonRegistry.Rose_Gold_Sword.get());
        this.tag(ItemTags.AXES)
                .add(TalonRegistry.Rose_Gold_Axe.get());
        this.tag(ItemTags.SHOVELS)
                .add(TalonRegistry.Rose_Gold_Shovel.get());
        this.tag(ItemTags.HOES)
                .add(TalonRegistry.Rose_Gold_Hoe.get());
        this.tag(ItemTags.PICKAXES)
                .add(TalonRegistry.Rose_Gold_Pickaxe.get());
    }
}
