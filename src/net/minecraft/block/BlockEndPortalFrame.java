package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.item.*;
import com.google.common.base.*;

public class BlockEndPortalFrame extends Block
{
    public static final /* synthetic */ PropertyBool field_176507_b;
    public static final /* synthetic */ PropertyDirection field_176508_a;
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockEndPortalFrame.field_176508_a, BlockEndPortalFrame.field_176507_b });
    }
    
    public BlockEndPortalFrame() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockEndPortalFrame.field_176508_a, EnumFacing.NORTH).withProperty(BlockEndPortalFrame.field_176507_b, false));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIllIlIlIIIllIllllI) {
        return this.getDefaultState().withProperty(BlockEndPortalFrame.field_176507_b, (llllllllllllllIllIlIlIIIllIllllI & 0x4) != 0x0).withProperty(BlockEndPortalFrame.field_176508_a, EnumFacing.getHorizontal(llllllllllllllIllIlIlIIIllIllllI & 0x3));
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public void addCollisionBoxesToList(final World llllllllllllllIllIlIlIIlIIIIIlll, final BlockPos llllllllllllllIllIlIlIIlIIIIIllI, final IBlockState llllllllllllllIllIlIlIIlIIIIIlIl, final AxisAlignedBB llllllllllllllIllIlIlIIlIIIIIlII, final List llllllllllllllIllIlIlIIlIIIIIIll, final Entity llllllllllllllIllIlIlIIlIIIIIIlI) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.8125f, 1.0f);
        super.addCollisionBoxesToList(llllllllllllllIllIlIlIIlIIIIIlll, llllllllllllllIllIlIlIIlIIIIIllI, llllllllllllllIllIlIlIIlIIIIIlIl, llllllllllllllIllIlIlIIlIIIIIlII, llllllllllllllIllIlIlIIlIIIIIIll, llllllllllllllIllIlIlIIlIIIIIIlI);
        if (llllllllllllllIllIlIlIIlIIIIIlll.getBlockState(llllllllllllllIllIlIlIIlIIIIIllI).getValue(BlockEndPortalFrame.field_176507_b)) {
            this.setBlockBounds(0.3125f, 0.8125f, 0.3125f, 0.6875f, 1.0f, 0.6875f);
            super.addCollisionBoxesToList(llllllllllllllIllIlIlIIlIIIIIlll, llllllllllllllIllIlIlIIlIIIIIllI, llllllllllllllIllIlIlIIlIIIIIlIl, llllllllllllllIllIlIlIIlIIIIIlII, llllllllllllllIllIlIlIIlIIIIIIll, llllllllllllllIllIlIlIIlIIIIIIlI);
        }
        this.setBlockBoundsForItemRender();
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIllIlIlIIIllllIIll, final BlockPos llllllllllllllIllIlIlIIIllllIIlI, final EnumFacing llllllllllllllIllIlIlIIIllllIIIl, final float llllllllllllllIllIlIlIIIllllIIII, final float llllllllllllllIllIlIlIIIlllIllll, final float llllllllllllllIllIlIlIIIlllIlllI, final int llllllllllllllIllIlIlIIIlllIllIl, final EntityLivingBase llllllllllllllIllIlIlIIIlllIllII) {
        return this.getDefaultState().withProperty(BlockEndPortalFrame.field_176508_a, llllllllllllllIllIlIlIIIlllIllII.func_174811_aO().getOpposite()).withProperty(BlockEndPortalFrame.field_176507_b, false);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIllIlIlIIIlllllIIl, final Random llllllllllllllIllIlIlIIIlllllIII, final int llllllllllllllIllIlIlIIIllllIlll) {
        return null;
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.8125f, 1.0f);
    }
    
    static {
        __OBFID = "CL_00000237";
        field_176508_a = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
        field_176507_b = PropertyBool.create("eye");
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIllIlIlIIIllIlIlII) {
        final byte llllllllllllllIllIlIlIIIllIlIllI = 0;
        int llllllllllllllIllIlIlIIIllIlIlIl = llllllllllllllIllIlIlIIIllIlIllI | ((EnumFacing)llllllllllllllIllIlIlIIIllIlIlII.getValue(BlockEndPortalFrame.field_176508_a)).getHorizontalIndex();
        if (llllllllllllllIllIlIlIIIllIlIlII.getValue(BlockEndPortalFrame.field_176507_b)) {
            llllllllllllllIllIlIlIIIllIlIlIl |= 0x4;
        }
        return llllllllllllllIllIlIlIIIllIlIlIl;
    }
    
    @Override
    public int getComparatorInputOverride(final World llllllllllllllIllIlIlIIIlllIIlIl, final BlockPos llllllllllllllIllIlIlIIIlllIIlII) {
        return llllllllllllllIllIlIlIIIlllIIlIl.getBlockState(llllllllllllllIllIlIlIIIlllIIlII).getValue(BlockEndPortalFrame.field_176507_b) ? 15 : 0;
    }
}
