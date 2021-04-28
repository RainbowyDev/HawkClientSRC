package net.minecraft.block;

import net.minecraft.entity.player.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class BlockRedstoneRepeater extends BlockRedstoneDiode
{
    public static final /* synthetic */ PropertyInteger field_176410_b;
    public static final /* synthetic */ PropertyBool field_176411_a;
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIIIlIllIlIIlIIlII, final BlockPos llllllllllllllIIIIlIllIlIIlIlIll, final IBlockState llllllllllllllIIIIlIllIlIIlIIIlI, final EntityPlayer llllllllllllllIIIIlIllIlIIlIlIIl, final EnumFacing llllllllllllllIIIIlIllIlIIlIlIII, final float llllllllllllllIIIIlIllIlIIlIIlll, final float llllllllllllllIIIIlIllIlIIlIIllI, final float llllllllllllllIIIIlIllIlIIlIIlIl) {
        if (!llllllllllllllIIIIlIllIlIIlIlIIl.capabilities.allowEdit) {
            return false;
        }
        llllllllllllllIIIIlIllIlIIlIIlII.setBlockState(llllllllllllllIIIIlIllIlIIlIlIll, llllllllllllllIIIIlIllIlIIlIIIlI.cycleProperty(BlockRedstoneRepeater.field_176410_b), 3);
        return true;
    }
    
    static {
        __OBFID = "CL_00000301";
        field_176411_a = PropertyBool.create("locked");
        field_176410_b = PropertyInteger.create("delay", 1, 4);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockRedstoneRepeater.AGE, BlockRedstoneRepeater.field_176410_b, BlockRedstoneRepeater.field_176411_a });
    }
    
    @Override
    public boolean func_176405_b(final IBlockAccess llllllllllllllIIIIlIllIIllllIIlI, final BlockPos llllllllllllllIIIIlIllIIllllIIIl, final IBlockState llllllllllllllIIIIlIllIIllllIIII) {
        return this.func_176407_c(llllllllllllllIIIIlIllIIllllIIlI, llllllllllllllIIIIlIllIIllllIIIl, llllllllllllllIIIIlIllIIllllIIII) > 0;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIIlIllIIlIllIIIl) {
        final byte llllllllllllllIIIIlIllIIlIllIIII = 0;
        int llllllllllllllIIIIlIllIIlIlIllll = llllllllllllllIIIIlIllIIlIllIIII | ((EnumFacing)llllllllllllllIIIIlIllIIlIllIIIl.getValue(BlockRedstoneRepeater.AGE)).getHorizontalIndex();
        llllllllllllllIIIIlIllIIlIlIllll |= (int)llllllllllllllIIIIlIllIIlIllIIIl.getValue(BlockRedstoneRepeater.field_176410_b) - 1 << 2;
        return llllllllllllllIIIIlIllIIlIlIllll;
    }
    
    @Override
    protected IBlockState func_180674_e(final IBlockState llllllllllllllIIIIlIllIlIIIlIlll) {
        final Integer llllllllllllllIIIIlIllIlIIIlIllI = (Integer)llllllllllllllIIIIlIllIlIIIlIlll.getValue(BlockRedstoneRepeater.field_176410_b);
        final Boolean llllllllllllllIIIIlIllIlIIIlIlIl = (Boolean)llllllllllllllIIIIlIllIlIIIlIlll.getValue(BlockRedstoneRepeater.field_176411_a);
        final EnumFacing llllllllllllllIIIIlIllIlIIIlIlII = (EnumFacing)llllllllllllllIIIIlIllIlIIIlIlll.getValue(BlockRedstoneRepeater.AGE);
        return Blocks.powered_repeater.getDefaultState().withProperty(BlockRedstoneRepeater.AGE, llllllllllllllIIIIlIllIlIIIlIlII).withProperty(BlockRedstoneRepeater.field_176410_b, llllllllllllllIIIIlIllIlIIIlIllI).withProperty(BlockRedstoneRepeater.field_176411_a, llllllllllllllIIIIlIllIlIIIlIlIl);
    }
    
    @Override
    protected IBlockState func_180675_k(final IBlockState llllllllllllllIIIIlIllIlIIIIIllI) {
        final Integer llllllllllllllIIIIlIllIlIIIIlIIl = (Integer)llllllllllllllIIIIlIllIlIIIIIllI.getValue(BlockRedstoneRepeater.field_176410_b);
        final Boolean llllllllllllllIIIIlIllIlIIIIlIII = (Boolean)llllllllllllllIIIIlIllIlIIIIIllI.getValue(BlockRedstoneRepeater.field_176411_a);
        final EnumFacing llllllllllllllIIIIlIllIlIIIIIlll = (EnumFacing)llllllllllllllIIIIlIllIlIIIIIllI.getValue(BlockRedstoneRepeater.AGE);
        return Blocks.unpowered_repeater.getDefaultState().withProperty(BlockRedstoneRepeater.AGE, llllllllllllllIIIIlIllIlIIIIIlll).withProperty(BlockRedstoneRepeater.field_176410_b, llllllllllllllIIIIlIllIlIIIIlIIl).withProperty(BlockRedstoneRepeater.field_176411_a, llllllllllllllIIIIlIllIlIIIIlIII);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIIlIllIIlIlllIII) {
        return this.getDefaultState().withProperty(BlockRedstoneRepeater.AGE, EnumFacing.getHorizontal(llllllllllllllIIIIlIllIIlIlllIII)).withProperty(BlockRedstoneRepeater.field_176411_a, false).withProperty(BlockRedstoneRepeater.field_176410_b, 1 + (llllllllllllllIIIIlIllIIlIlllIII >> 2));
    }
    
    @Override
    protected int func_176403_d(final IBlockState llllllllllllllIIIIlIllIlIIIllllI) {
        return (int)llllllllllllllIIIIlIllIlIIIllllI.getValue(BlockRedstoneRepeater.field_176410_b) * 2;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIIIlIllIlIIIIIIIl, final Random llllllllllllllIIIIlIllIlIIIIIIII, final int llllllllllllllIIIIlIllIIllllllll) {
        return Items.repeater;
    }
    
    @Override
    protected boolean func_149908_a(final Block llllllllllllllIIIIlIllIIlllIllII) {
        return BlockRedstoneDiode.isRedstoneRepeaterBlockID(llllllllllllllIIIIlIllIIlllIllII);
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIIIIlIllIIllIIIIlI, final BlockPos llllllllllllllIIIIlIllIIllIIIIIl, final IBlockState llllllllllllllIIIIlIllIIlIllllII) {
        super.breakBlock(llllllllllllllIIIIlIllIIllIIIIlI, llllllllllllllIIIIlIllIIllIIIIIl, llllllllllllllIIIIlIllIIlIllllII);
        this.func_176400_h(llllllllllllllIIIIlIllIIllIIIIlI, llllllllllllllIIIIlIllIIllIIIIIl, llllllllllllllIIIIlIllIIlIllllII);
    }
    
    protected BlockRedstoneRepeater(final boolean llllllllllllllIIIIlIllIlIlIIIIII) {
        super(llllllllllllllIIIIlIllIlIlIIIIII);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRedstoneRepeater.AGE, EnumFacing.NORTH).withProperty(BlockRedstoneRepeater.field_176410_b, 1).withProperty(BlockRedstoneRepeater.field_176411_a, false));
    }
    
    @Override
    public void randomDisplayTick(final World llllllllllllllIIIIlIllIIllIllllI, final BlockPos llllllllllllllIIIIlIllIIllIlIIIl, final IBlockState llllllllllllllIIIIlIllIIllIlIIII, final Random llllllllllllllIIIIlIllIIllIllIll) {
        if (this.isRepeaterPowered) {
            final EnumFacing llllllllllllllIIIIlIllIIllIllIlI = (EnumFacing)llllllllllllllIIIIlIllIIllIlIIII.getValue(BlockRedstoneRepeater.AGE);
            final double llllllllllllllIIIIlIllIIllIllIIl = llllllllllllllIIIIlIllIIllIlIIIl.getX() + 0.5f + (llllllllllllllIIIIlIllIIllIllIll.nextFloat() - 0.5f) * 0.2;
            final double llllllllllllllIIIIlIllIIllIllIII = llllllllllllllIIIIlIllIIllIlIIIl.getY() + 0.4f + (llllllllllllllIIIIlIllIIllIllIll.nextFloat() - 0.5f) * 0.2;
            final double llllllllllllllIIIIlIllIIllIlIlll = llllllllllllllIIIIlIllIIllIlIIIl.getZ() + 0.5f + (llllllllllllllIIIIlIllIIllIllIll.nextFloat() - 0.5f) * 0.2;
            float llllllllllllllIIIIlIllIIllIlIllI = -5.0f;
            if (llllllllllllllIIIIlIllIIllIllIll.nextBoolean()) {
                llllllllllllllIIIIlIllIIllIlIllI = (float)((int)llllllllllllllIIIIlIllIIllIlIIII.getValue(BlockRedstoneRepeater.field_176410_b) * 2 - 1);
            }
            llllllllllllllIIIIlIllIIllIlIllI /= 16.0f;
            final double llllllllllllllIIIIlIllIIllIlIlIl = llllllllllllllIIIIlIllIIllIlIllI * llllllllllllllIIIIlIllIIllIllIlI.getFrontOffsetX();
            final double llllllllllllllIIIIlIllIIllIlIlII = llllllllllllllIIIIlIllIIllIlIllI * llllllllllllllIIIIlIllIIllIllIlI.getFrontOffsetZ();
            llllllllllllllIIIIlIllIIllIllllI.spawnParticle(EnumParticleTypes.REDSTONE, llllllllllllllIIIIlIllIIllIllIIl + llllllllllllllIIIIlIllIIllIlIlIl, llllllllllllllIIIIlIllIIllIllIII, llllllllllllllIIIIlIllIIllIlIlll + llllllllllllllIIIIlIllIIllIlIlII, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public Item getItem(final World llllllllllllllIIIIlIllIIllllllIl, final BlockPos llllllllllllllIIIIlIllIIllllllII) {
        return Items.repeater;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllllIIIIlIllIlIIlllIII, final IBlockAccess llllllllllllllIIIIlIllIlIIllIIll, final BlockPos llllllllllllllIIIIlIllIlIIllIllI) {
        return llllllllllllllIIIIlIllIlIIlllIII.withProperty(BlockRedstoneRepeater.field_176411_a, this.func_176405_b(llllllllllllllIIIIlIllIlIIllIIll, llllllllllllllIIIIlIllIlIIllIllI, llllllllllllllIIIIlIllIlIIlllIII));
    }
}
