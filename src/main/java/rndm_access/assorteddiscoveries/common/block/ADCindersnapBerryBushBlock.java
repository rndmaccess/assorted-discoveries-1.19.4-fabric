package rndm_access.assorteddiscoveries.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import rndm_access.assorteddiscoveries.common.core.ADEntityTypeTags;
import rndm_access.assorteddiscoveries.common.core.ADItems;
import rndm_access.assorteddiscoveries.common.core.CBlockTags;

public class ADCindersnapBerryBushBlock extends ADAbstractBerryBushBlock {
    public ADCindersnapBerryBushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected TagKey<EntityType<?>> mobsImmune() {
        return ADEntityTypeTags.CINDERSNAP_BERRY_BUSH_IMMUNE_ENTITY_TYPES;
    }

    @Override
    protected boolean bushDamages() {
        return true;
    }

    @Override
    protected Item berryItem() {
        return ADItems.CINDERSNAP_BERRIES;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double x = pos.getX() + random.nextDouble();
        double y = pos.getY() + random.nextDouble();
        double z = pos.getZ() + random.nextDouble();
        double randNum = random.nextDouble();

        if(randNum < 0.3) {
            world.addParticle(ParticleTypes.LAVA, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(CBlockTags.CINDERSNAP_BERRY_BUSH_PLANTABLE_ON);
    }
}
