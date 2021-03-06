package com.wuest.prefab.Blocks;

import com.wuest.prefab.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * This class allows custom stairs blocks to be created.
 *
 * @author Brian
 */
public class BlockStairs extends StairsBlock {
    public BlockStairs(BlockState state, Block.Properties properties) {
        super(state, properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        Tag<Block> tags = BlockTags.getCollection().get(new ResourceLocation("forge", "glass"));
        Block adjacentBlock = adjacentBlockState.getBlock();

        return tags.contains(adjacentBlock) || adjacentBlock == this
                || (adjacentBlock == ModRegistry.GlassSlab()
                    && adjacentBlockState.get(SlabBlock.TYPE) == SlabType.DOUBLE);
    }
}
