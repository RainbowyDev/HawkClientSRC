package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class BlockPressurePlateWeighted extends BlockBasePressurePlate
{
    public static final /* synthetic */ PropertyInteger POWER;
    private final /* synthetic */ int field_150068_a;
    
    @Override
    public int tickRate(final World llllllllllllllIlllIIllIIlIlIllll) {
        return 10;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockPressurePlateWeighted.POWER });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlllIIllIIlIlIlIIl) {
        return this.getDefaultState().withProperty(BlockPressurePlateWeighted.POWER, llllllllllllllIlllIIllIIlIlIlIIl);
    }
    
    protected BlockPressurePlateWeighted(final String llllllllllllllIlllIIllIIllIlIIII, final Material llllllllllllllIlllIIllIIllIIllII, final int llllllllllllllIlllIIllIIllIIlllI) {
        super(llllllllllllllIlllIIllIIllIIllII);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPressurePlateWeighted.POWER, 0));
        this.field_150068_a = llllllllllllllIlllIIllIIllIIlllI;
    }
    
    static {
        __OBFID = "CL_00000334";
        POWER = PropertyInteger.create("power", 0, 15);
    }
    
    @Override
    protected int computeRedstoneStrength(final World llllllllllllllIlllIIllIIllIIIlII, final BlockPos llllllllllllllIlllIIllIIllIIIIll) {
        final int llllllllllllllIlllIIllIIllIIIIlI = Math.min(llllllllllllllIlllIIllIIllIIIlII.getEntitiesWithinAABB(Entity.class, this.getSensitiveAABB(llllllllllllllIlllIIllIIllIIIIll)).size(), this.field_150068_a);
        if (llllllllllllllIlllIIllIIllIIIIlI > 0) {
            final float llllllllllllllIlllIIllIIllIIIIIl = Math.min(this.field_150068_a, llllllllllllllIlllIIllIIllIIIIlI) / (float)this.field_150068_a;
            return MathHelper.ceiling_float_int(llllllllllllllIlllIIllIIllIIIIIl * 15.0f);
        }
        return 0;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlllIIllIIlIlIIllI) {
        return (int)llllllllllllllIlllIIllIIlIlIIllI.getValue(BlockPressurePlateWeighted.POWER);
    }
    
    @Override
    protected IBlockState setRedstoneStrength(final IBlockState llllllllllllllIlllIIllIIlIllIIlI, final int llllllllllllllIlllIIllIIlIllIIIl) {
        return llllllllllllllIlllIIllIIlIllIIlI.withProperty(BlockPressurePlateWeighted.POWER, llllllllllllllIlllIIllIIlIllIIIl);
    }
    
    @Override
    protected int getRedstoneStrength(final IBlockState llllllllllllllIlllIIllIIlIlllIIl) {
        return (int)llllllllllllllIlllIIllIIlIlllIIl.getValue(BlockPressurePlateWeighted.POWER);
    }
}
