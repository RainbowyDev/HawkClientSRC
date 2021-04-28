package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockCactus extends Block
{
    public static final /* synthetic */ PropertyInteger AGE_PROP;
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllllIIllllIIIlIlIlIIIl, final BlockPos llllllllllllllIIllllIIIlIlIlIIII, final IBlockState llllllllllllllIIllllIIIlIlIIllll, final Entity llllllllllllllIIllllIIIlIlIIlllI) {
        llllllllllllllIIllllIIIlIlIIlllI.attackEntityFrom(DamageSource.cactus, 1.0f);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    protected BlockCactus() {
        super(Material.cactus);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockCactus.AGE_PROP, 0));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIllllIIIlIlIIIIlI) {
        return (int)llllllllllllllIIllllIIIlIlIIIIlI.getValue(BlockCactus.AGE_PROP);
    }
    
    public boolean canBlockStay(final World llllllllllllllIIllllIIIlIlIlllII, final BlockPos llllllllllllllIIllllIIIlIlIllIll) {
        for (final EnumFacing llllllllllllllIIllllIIIlIlIllIIl : EnumFacing.Plane.HORIZONTAL) {
            if (llllllllllllllIIllllIIIlIlIlllII.getBlockState(llllllllllllllIIllllIIIlIlIllIll.offset(llllllllllllllIIllllIIIlIlIllIIl)).getBlock().getMaterial().isSolid()) {
                return false;
            }
        }
        final Block llllllllllllllIIllllIIIlIlIllIII = llllllllllllllIIllllIIIlIlIlllII.getBlockState(llllllllllllllIIllllIIIlIlIllIll.offsetDown()).getBlock();
        return llllllllllllllIIllllIIIlIlIllIII == Blocks.cactus || llllllllllllllIIllllIIIlIlIllIII == Blocks.sand;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIIllllIIIlIlllIIIl, final BlockPos llllllllllllllIIllllIIIlIlllIIII) {
        return super.canPlaceBlockAt(llllllllllllllIIllllIIIlIlllIIIl, llllllllllllllIIllllIIIlIlllIIII) && this.canBlockStay(llllllllllllllIIllllIIIlIlllIIIl, llllllllllllllIIllllIIIlIlllIIII);
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIllllIIIllIIllIII, final BlockPos llllllllllllllIIllllIIIllIIlIlll, final IBlockState llllllllllllllIIllllIIIllIIIllIl, final Random llllllllllllllIIllllIIIllIIlIlIl) {
        final BlockPos llllllllllllllIIllllIIIllIIlIlII = llllllllllllllIIllllIIIllIIlIlll.offsetUp();
        if (llllllllllllllIIllllIIIllIIllIII.isAirBlock(llllllllllllllIIllllIIIllIIlIlII)) {
            int llllllllllllllIIllllIIIllIIlIIll;
            for (llllllllllllllIIllllIIIllIIlIIll = 1; llllllllllllllIIllllIIIllIIllIII.getBlockState(llllllllllllllIIllllIIIllIIlIlll.offsetDown(llllllllllllllIIllllIIIllIIlIIll)).getBlock() == this; ++llllllllllllllIIllllIIIllIIlIIll) {}
            if (llllllllllllllIIllllIIIllIIlIIll < 3) {
                final int llllllllllllllIIllllIIIllIIlIIlI = (int)llllllllllllllIIllllIIIllIIIllIl.getValue(BlockCactus.AGE_PROP);
                if (llllllllllllllIIllllIIIllIIlIIlI == 15) {
                    llllllllllllllIIllllIIIllIIllIII.setBlockState(llllllllllllllIIllllIIIllIIlIlII, this.getDefaultState());
                    final IBlockState llllllllllllllIIllllIIIllIIlIIIl = llllllllllllllIIllllIIIllIIIllIl.withProperty(BlockCactus.AGE_PROP, 0);
                    llllllllllllllIIllllIIIllIIllIII.setBlockState(llllllllllllllIIllllIIIllIIlIlll, llllllllllllllIIllllIIIllIIlIIIl, 4);
                    this.onNeighborBlockChange(llllllllllllllIIllllIIIllIIllIII, llllllllllllllIIllllIIIllIIlIlII, llllllllllllllIIllllIIIllIIlIIIl, this);
                }
                else {
                    llllllllllllllIIllllIIIllIIllIII.setBlockState(llllllllllllllIIllllIIIllIIlIlll, llllllllllllllIIllllIIIllIIIllIl.withProperty(BlockCactus.AGE_PROP, llllllllllllllIIllllIIIllIIlIIlI + 1), 4);
                }
            }
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockCactus.AGE_PROP });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIllllIIIlIlIIlIII) {
        return this.getDefaultState().withProperty(BlockCactus.AGE_PROP, llllllllllllllIIllllIIIlIlIIlIII);
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final World llllllllllllllIIllllIIIlIlllllII, final BlockPos llllllllllllllIIllllIIIlIllllIIl) {
        final float llllllllllllllIIllllIIIlIllllIlI = 0.0625f;
        return new AxisAlignedBB(llllllllllllllIIllllIIIlIllllIIl.getX() + llllllllllllllIIllllIIIlIllllIlI, llllllllllllllIIllllIIIlIllllIIl.getY(), llllllllllllllIIllllIIIlIllllIIl.getZ() + llllllllllllllIIllllIIIlIllllIlI, llllllllllllllIIllllIIIlIllllIIl.getX() + 1 - llllllllllllllIIllllIIIlIllllIlI, llllllllllllllIIllllIIIlIllllIIl.getY() + 1, llllllllllllllIIllllIIIlIllllIIl.getZ() + 1 - llllllllllllllIIllllIIIlIllllIlI);
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIIllllIIIlIllIlIII, final BlockPos llllllllllllllIIllllIIIlIllIIIlI, final IBlockState llllllllllllllIIllllIIIlIllIIllI, final Block llllllllllllllIIllllIIIlIllIIlIl) {
        if (!this.canBlockStay(llllllllllllllIIllllIIIlIllIlIII, llllllllllllllIIllllIIIlIllIIIlI)) {
            llllllllllllllIIllllIIIlIllIlIII.destroyBlock(llllllllllllllIIllllIIIlIllIIIlI, true);
        }
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000210";
        AGE_PROP = PropertyInteger.create("age", 0, 15);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIIllllIIIllIIIIlIl, final BlockPos llllllllllllllIIllllIIIllIIIIIIl, final IBlockState llllllllllllllIIllllIIIllIIIIIll) {
        final float llllllllllllllIIllllIIIllIIIIIlI = 0.0625f;
        return new AxisAlignedBB(llllllllllllllIIllllIIIllIIIIIIl.getX() + llllllllllllllIIllllIIIllIIIIIlI, llllllllllllllIIllllIIIllIIIIIIl.getY(), llllllllllllllIIllllIIIllIIIIIIl.getZ() + llllllllllllllIIllllIIIllIIIIIlI, llllllllllllllIIllllIIIllIIIIIIl.getX() + 1 - llllllllllllllIIllllIIIllIIIIIlI, llllllllllllllIIllllIIIllIIIIIIl.getY() + 1 - llllllllllllllIIllllIIIllIIIIIlI, llllllllllllllIIllllIIIllIIIIIIl.getZ() + 1 - llllllllllllllIIllllIIIllIIIIIlI);
    }
}
