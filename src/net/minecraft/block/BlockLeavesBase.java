package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import optifine.*;
import java.util.*;

public class BlockLeavesBase extends Block
{
    protected /* synthetic */ boolean field_150121_P;
    private static /* synthetic */ Map mapOriginalOpacity;
    
    protected BlockLeavesBase(final Material lllllllllllllllIlIlIllIIlIlIlIIl, final boolean lllllllllllllllIlIlIllIIlIlIIlIl) {
        super(lllllllllllllllIlIlIllIIlIlIlIIl);
        this.field_150121_P = lllllllllllllllIlIlIllIIlIlIIlIl;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    public static void restoreLightOpacity(final Block lllllllllllllllIlIlIllIIlIIIllIl) {
        if (BlockLeavesBase.mapOriginalOpacity.containsKey(lllllllllllllllIlIlIllIIlIIIllIl)) {
            final int lllllllllllllllIlIlIllIIlIIIlllI = BlockLeavesBase.mapOriginalOpacity.get(lllllllllllllllIlIlIllIIlIIIllIl);
            setLightOpacity(lllllllllllllllIlIlIllIIlIIIllIl, lllllllllllllllIlIlIllIIlIIIlllI);
        }
    }
    
    public static void setLightOpacity(final Block lllllllllllllllIlIlIllIIlIIlIIll, final int lllllllllllllllIlIlIllIIlIIlIlII) {
        if (!BlockLeavesBase.mapOriginalOpacity.containsKey(lllllllllllllllIlIlIllIIlIIlIIll)) {
            BlockLeavesBase.mapOriginalOpacity.put(lllllllllllllllIlIlIllIIlIIlIIll, lllllllllllllllIlIlIllIIlIIlIIll.getLightOpacity());
        }
        lllllllllllllllIlIlIllIIlIIlIIll.setLightOpacity(lllllllllllllllIlIlIllIIlIIlIlII);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess lllllllllllllllIlIlIllIIlIIllllI, final BlockPos lllllllllllllllIlIlIllIIlIIllIIl, final EnumFacing lllllllllllllllIlIlIllIIlIIllIII) {
        return (!Config.isCullFacesLeaves() || lllllllllllllllIlIlIllIIlIIllllI.getBlockState(lllllllllllllllIlIlIllIIlIIllIIl).getBlock() != this) && super.shouldSideBeRendered(lllllllllllllllIlIlIllIIlIIllllI, lllllllllllllllIlIlIllIIlIIllIIl, lllllllllllllllIlIlIllIIlIIllIII);
    }
    
    static {
        __OBFID = "CL_00000326";
        BlockLeavesBase.mapOriginalOpacity = new IdentityHashMap();
    }
}
