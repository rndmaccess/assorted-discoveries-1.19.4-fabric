package rndm_access.assorteddiscoveries.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class ADAbstractThornyBerryBushBlock extends ADAbstractBerryBushBlock {
    public ADAbstractThornyBerryBushBlock(Settings settings) {
        super(settings);
    }

    protected abstract TagKey<EntityType<?>> mobsImmune();

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!entity.getType().isIn(this.mobsImmune())) {
            entity.slowMovement(state, new Vec3d(0.8D, 0.75D, 0.8D));

            if (!world.isClient() && state.get(AGE) > 0 && (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.lastRenderX);
                double e = Math.abs(entity.getZ() - entity.lastRenderZ);

                if (d >= 0.003D || e >= 0.003D) {
                    entity.damage(world.getDamageSources().sweetBerryBush(), 1.0F);
                }
            }
        }
    }
}
