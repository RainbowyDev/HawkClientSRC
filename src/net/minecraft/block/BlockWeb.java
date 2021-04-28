package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class BlockWeb extends Block
{
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIllIIIllIlllIllIl, final Random llllllllllllllIIllIIIllIlllIllII, final int llllllllllllllIIllIIIllIlllIlIll) {
        return Items.string;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllllIIllIIIllIlllllIIl, final BlockPos llllllllllllllIIllIIIllIlllllIII, final IBlockState llllllllllllllIIllIIIllIllllIlll, final Entity llllllllllllllIIllIIIllIllllIlIl) {
        llllllllllllllIIllIIIllIllllIlIl.setInWeb();
    }
    
    public BlockWeb() {
        super(Material.web);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    static {
        __OBFID = "CL_00000333";
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIIllIIIllIllllIIlI, final BlockPos llllllllllllllIIllIIIllIllllIIIl, final IBlockState llllllllllllllIIllIIIllIllllIIII) {
        return null;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
}
