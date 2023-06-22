package rndm_access.assorteddiscoveries.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import rndm_access.assorteddiscoveries.common.core.ADEntityTypeTags;
import rndm_access.assorteddiscoveries.common.core.ADItems;
import rndm_access.assorteddiscoveries.common.core.CBlockTags;

public class ADFrostbiteBerryBushBlock extends ADAbstractBerryBushBlock {
    public ADFrostbiteBerryBushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected TagKey<EntityType<?>> mobsImmune() {
        return ADEntityTypeTags.FROSTBITE_BERRY_BUSH_IMMUNE_ENTITY_TYPES;
    }

    @Override
    protected boolean bushDamages() {
        return true;
    }

    @Override
    protected Item berryItem() {
        return ADItems.FROSTBITE_BERRIES;
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(CBlockTags.FROSTBITE_BERRY_BUSH_PLANTABLE_ON);
    }
}
