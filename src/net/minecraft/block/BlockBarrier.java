package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;

public class BlockBarrier extends Block
{
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIlIlIIllIIlllIIIII, final BlockPos llllllllllllllIlIlIIllIIllIlllll, final IBlockState llllllllllllllIlIlIIllIIllIllllI, final float llllllllllllllIlIlIIllIIllIlllIl, final int llllllllllllllIlIlIIllIIllIlllII) {
    }
    
    protected BlockBarrier() {
        super(Material.barrier);
        this.setBlockUnbreakable();
        this.setResistance(6000001.0f);
        this.disableStats();
        this.translucent = true;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public float getAmbientOcclusionLightValue() {
        return 1.0f;
    }
    
    static {
        __OBFID = "CL_00002139";
    }
    
    @Override
    public int getRenderType() {
        return -1;
    }
}
