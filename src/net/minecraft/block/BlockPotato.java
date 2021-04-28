package net.minecraft.block;

import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import net.minecraft.item.*;

public class BlockPotato extends BlockCrops
{
    static {
        __OBFID = "CL_00000286";
    }
    
    @Override
    protected Item getCrop() {
        return Items.potato;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lIIlIIIIIIlllI, final BlockPos lIIlIIIIIIllIl, final IBlockState lIIlIIIIIIIllI, final float lIIlIIIIIIIlIl, final int lIIlIIIIIIlIlI) {
        super.dropBlockAsItemWithChance(lIIlIIIIIIlllI, lIIlIIIIIIllIl, lIIlIIIIIIIllI, lIIlIIIIIIIlIl, lIIlIIIIIIlIlI);
        if (!lIIlIIIIIIlllI.isRemote && (int)lIIlIIIIIIIllI.getValue(BlockPotato.AGE) >= 7 && lIIlIIIIIIlllI.rand.nextInt(50) == 0) {
            Block.spawnAsEntity(lIIlIIIIIIlllI, lIIlIIIIIIllIl, new ItemStack(Items.poisonous_potato));
        }
    }
    
    @Override
    protected Item getSeed() {
        return Items.potato;
    }
}
