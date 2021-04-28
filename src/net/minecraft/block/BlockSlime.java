package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class BlockSlime extends BlockBreakable
{
    @Override
    public void onLanded(final World lllllllllllllllIIIlIlIlllIllllIl, final Entity lllllllllllllllIIIlIlIlllIllllII) {
        if (lllllllllllllllIIIlIlIlllIllllII.isSneaking()) {
            super.onLanded(lllllllllllllllIIIlIlIlllIllllIl, lllllllllllllllIIIlIlIlllIllllII);
        }
        else if (lllllllllllllllIIIlIlIlllIllllII.motionY < 0.0) {
            lllllllllllllllIIIlIlIlllIllllII.motionY = -lllllllllllllllIIIlIlIlllIllllII.motionY;
        }
    }
    
    public BlockSlime() {
        super(Material.clay, false);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.slipperiness = 0.8f;
    }
    
    static {
        __OBFID = "CL_00002063";
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllllIIIlIlIlllIIllIIl, final BlockPos lllllllllllllllIIIlIlIlllIlIIIIl, final Entity lllllllllllllllIIIlIlIlllIIlllll) {
        if (Math.abs(lllllllllllllllIIIlIlIlllIIlllll.motionY) < 0.1 && !lllllllllllllllIIIlIlIlllIIlllll.isSneaking()) {
            final double lllllllllllllllIIIlIlIlllIIlllIl = 0.4 + Math.abs(lllllllllllllllIIIlIlIlllIIlllll.motionY) * 0.2;
            lllllllllllllllIIIlIlIlllIIlllll.motionX *= lllllllllllllllIIIlIlIlllIIlllIl;
            lllllllllllllllIIIlIlIlllIIlllll.motionZ *= lllllllllllllllIIIlIlIlllIIlllIl;
        }
        super.onEntityCollidedWithBlock(lllllllllllllllIIIlIlIlllIIllIIl, lllllllllllllllIIIlIlIlllIlIIIIl, lllllllllllllllIIIlIlIlllIIlllll);
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
    
    @Override
    public void onFallenUpon(final World lllllllllllllllIIIlIlIllllIIIlIl, final BlockPos lllllllllllllllIIIlIlIllllIIlIIl, final Entity lllllllllllllllIIIlIlIllllIIlIII, final float lllllllllllllllIIIlIlIllllIIIIlI) {
        if (lllllllllllllllIIIlIlIllllIIlIII.isSneaking()) {
            super.onFallenUpon(lllllllllllllllIIIlIlIllllIIIlIl, lllllllllllllllIIIlIlIllllIIlIIl, lllllllllllllllIIIlIlIllllIIlIII, lllllllllllllllIIIlIlIllllIIIIlI);
        }
        else {
            lllllllllllllllIIIlIlIllllIIlIII.fall(lllllllllllllllIIIlIlIllllIIIIlI, 0.0f);
        }
    }
}
