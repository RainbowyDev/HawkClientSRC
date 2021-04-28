package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class BlockHay extends BlockRotatedPillar
{
    public BlockHay() {
        super(Material.grass);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockHay.field_176298_M, EnumFacing.Axis.Y));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llIIIllllIlllII) {
        int llIIIllllIllllI = 0;
        final EnumFacing.Axis llIIIllllIlllIl = (EnumFacing.Axis)llIIIllllIlllII.getValue(BlockHay.field_176298_M);
        if (llIIIllllIlllIl == EnumFacing.Axis.X) {
            llIIIllllIllllI |= 0x4;
        }
        else if (llIIIllllIlllIl == EnumFacing.Axis.Z) {
            llIIIllllIllllI |= 0x8;
        }
        return llIIIllllIllllI;
    }
    
    static {
        __OBFID = "CL_00000256";
    }
    
    @Override
    protected ItemStack createStackedBlock(final IBlockState llIIIllllIlIlII) {
        return new ItemStack(Item.getItemFromBlock(this), 1, 0);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockHay.field_176298_M });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llIIIlllllIIllI) {
        EnumFacing.Axis llIIIlllllIlIIl = EnumFacing.Axis.Y;
        final int llIIIlllllIlIII = llIIIlllllIIllI & 0xC;
        if (llIIIlllllIlIII == 4) {
            llIIIlllllIlIIl = EnumFacing.Axis.X;
        }
        else if (llIIIlllllIlIII == 8) {
            llIIIlllllIlIIl = EnumFacing.Axis.Z;
        }
        return this.getDefaultState().withProperty(BlockHay.field_176298_M, llIIIlllllIlIIl);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llIIIlllIllllll, final BlockPos llIIIlllIlllllI, final EnumFacing llIIIllllIIIllI, final float llIIIllllIIIlIl, final float llIIIllllIIIlII, final float llIIIllllIIIIll, final int llIIIlllIlllIIl, final EntityLivingBase llIIIllllIIIIIl) {
        return super.onBlockPlaced(llIIIlllIllllll, llIIIlllIlllllI, llIIIllllIIIllI, llIIIllllIIIlIl, llIIIllllIIIlII, llIIIllllIIIIll, llIIIlllIlllIIl, llIIIllllIIIIIl).withProperty(BlockHay.field_176298_M, llIIIllllIIIllI.getAxis());
    }
}
