package uwu.lopyluna.talon.baseRegistry.block_properties.kiln;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import uwu.lopyluna.talon.baseRegistry.TalonRegistry;

import javax.annotation.Nullable;

public class KilnBlock extends AbstractFurnaceBlock {
    public KilnBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SmokerBlockEntity(pPos, pState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createFurnaceTicker(pLevel, pBlockEntityType, TalonRegistry.KilnBE.get());
    }

    protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof SmokerBlockEntity) {
            pPlayer.openMenu((MenuProvider)blockentity);
            pPlayer.awardStat(Stats.INTERACT_WITH_FURNACE);
        }

    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            double posX = (double)pPos.getX() + 0.5D;
            double posY = (double)pPos.getY();
            double posZ = (double)pPos.getZ() + 0.5D;
            if (pRandom.nextDouble() < 0.1D) {
                pLevel.playLocalSound(posX, posY, posZ, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 0.75F, 1.0F, false);
                pLevel.playLocalSound(posX, posY, posZ, SoundEvents.SMOKER_SMOKE, SoundSource.BLOCKS, 0.75F, 1.0F, false);
            }

            pLevel.addParticle(ParticleTypes.SMOKE, posX, posY + 1.1D, posZ, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.FLAME, posX, posY + 1.1D, posZ, 0.0D, 0.0D, 0.0D);

            Direction direction = pState.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double pos1 = 0.52D;
            double pos2 = pRandom.nextDouble() * 0.6D - 0.3D;
            double pos3 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : pos2;
            double pos4 = pRandom.nextDouble() * 7.0D / 16.0D;
            double pos5 = pRandom.nextDouble() * 5.0D / 16.0D;
            double pos6 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : pos2;
            pLevel.addParticle(ParticleTypes.SMOKE, posX + pos3, posY + pos4, posZ + pos6, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.FLAME, posX + pos3, posY + pos4, posZ + pos6, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.FLAME, posX + pos3, posY + pos4, posZ + pos6, 0.0D, 0.0D, 0.0D);

            pLevel.addParticle(ParticleTypes.SMOKE, posX, posY + pos5, posZ + pos6, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.FLAME, posX, posY + pos5, posZ + pos6, 0.0D, 0.0D, 0.0D);

            pLevel.addParticle(ParticleTypes.SMOKE, posX + pos3, posY + pos5, posZ, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.FLAME, posX + pos3, posY + pos5, posZ, 0.0D, 0.0D, 0.0D);
        }
    }
}