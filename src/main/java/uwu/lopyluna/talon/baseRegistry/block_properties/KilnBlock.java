package uwu.lopyluna.talon.baseRegistry.block_properties;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings({"all"})
public class KilnBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public KilnBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)));
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            if (pPlayer.isCrouching()) {
                return InteractionResult.FAIL;
            } else {
                return InteractionResult.SUCCESS;
            }
        } else {
            if (pPlayer.isCrouching()) {
                return InteractionResult.FAIL;
            } else {
                this.openContainer(pLevel, pPos, pPlayer);
                return InteractionResult.CONSUME;
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new KilnBlockEntity(pPos, pState);
    }

    protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
        if (!pLevel.isClientSide()) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof KilnBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (KilnBlockEntity)blockentity, pPos);
                pPlayer.awardStat(Stats.INTERACT_WITH_FURNACE);
            } else {
                throw new IllegalStateException("Container provider is missing?");
            }
        }
    }
    public BlockState LitKiln(BlockState pState, Rotation pRotation) {
        return pState.setValue(LIT, true);
    }
    public BlockState UnlitKiln(BlockState pState, Rotation pRotation) {
        return pState.setValue(LIT, false);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LIT);
    }

    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        RandomSource pRandom = pLevel.random;
        if (pRandom.nextDouble() < 0.2D && pState.getValue(LIT) && !pEntity.isSteppingCarefully() && pEntity instanceof LivingEntity && ((LivingEntity) pEntity).getHealth() > 1.0F && !EnchantmentHelper.hasFrostWalker((LivingEntity)pEntity)) {
            pEntity.hurt(pLevel.damageSources().hotFloor(), 1.0F);
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            double d0 = (double)pPos.getX() + 0.5D;
            double d1 = (double)pPos.getY();
            double d2 = (double)pPos.getZ() + 0.5D;

            if (pRandom.nextDouble() < 0.1D) {
                pLevel.playLocalSound(d0, d1 + (10.0D / 16.0D), d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 0.75F, 0.95F, false);
                pLevel.playLocalSound(d0, d1 + (10.0D / 16.0D), d2, SoundEvents.SMOKER_SMOKE, SoundSource.BLOCKS, 0.75F, 0.95F, false);
            }

            Direction direction = pState.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();

            double d4 = pRandom.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.5D : d4;
            double d6 = pRandom.nextDouble() * (2.5D / 16.0D);
            double d7 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.5D : d4;

            double d8 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * -0.5D : d4;
            double d9 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * -0.5D : d4;

            double d10 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.5D : d4;
            double d11 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.5D : d4;


            pLevel.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + (8.5D / 16.0D) + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + (8.5D / 16.0D) + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + (8.5D / 16.0D) + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.SMOKE, d0 + d8, d1 + (8.5D / 16.0D) + d6, d2 + d9, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.SMOKE, d0 + d8, d1 + (8.5D / 16.0D) + d6, d2 + d9, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.FLAME, d0 + d8, d1 + (8.5D / 16.0D) + d6, d2 + d9, 0.0D, 0.0D, 0.0D);

            pLevel.addParticle(ParticleTypes.SMOKE, d0 + d10, d1 + (10.0D / 16.0D) + d6, d2 + d11, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.SMOKE, d0 + d10, d1 + (10.0D / 16.0D) + d6, d2 + d11, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.FLAME, d0 + d10, d1 + (10.0D / 16.0D) + d6, d2 + d11, 0.0D, 0.0D, 0.0D);

            pLevel.addParticle(ParticleTypes.SMOKE, d0 + (d4 / 0.9), d1 + 1.1D, d2 + (d4 / 0.9), 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.SMOKE, d0 + (d4 / 0.9), d1 + 1.1D, d2 + (d4 / 0.9), 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(ParticleTypes.FLAME, d0 + (d4 / 0.9), d1 + 1.1D, d2 + (d4 / 0.9), 0.0D, 0.0D, 0.0D);
        }
    }
}
