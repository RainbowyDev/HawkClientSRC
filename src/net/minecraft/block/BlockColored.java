package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;

public class BlockColored extends Block
{
    public static final /* synthetic */ PropertyEnum COLOR;
    
    static {
        __OBFID = "CL_00000217";
        COLOR = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIIIIIIlllIlIIllI) {
        return ((EnumDyeColor)llllllllllllllIlIIIIIIlllIlIIllI.getValue(BlockColored.COLOR)).func_176765_a();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockColored.COLOR });
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIlIIIIIIlllIlllIII) {
        return ((EnumDyeColor)llllllllllllllIlIIIIIIlllIlllIII.getValue(BlockColored.COLOR)).func_176768_e();
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlIIIIIIlllllIIIll) {
        return ((EnumDyeColor)llllllllllllllIlIIIIIIlllllIIIll.getValue(BlockColored.COLOR)).func_176765_a();
    }
    
    public BlockColored(final Material llllllllllllllIlIIIIIIlllllIlIll) {
        super(llllllllllllllIlIIIIIIlllllIlIll);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIIIIIIlllIlIlllI) {
        return this.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.func_176764_b(llllllllllllllIlIIIIIIlllIlIlllI));
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllIlIIIIIIllllIIIlII, final CreativeTabs llllllllllllllIlIIIIIIllllIIlllI, final List llllllllllllllIlIIIIIIllllIIllIl) {
        for (final EnumDyeColor llllllllllllllIlIIIIIIllllIIIllI : EnumDyeColor.values()) {
            llllllllllllllIlIIIIIIllllIIllIl.add(new ItemStack(llllllllllllllIlIIIIIIllllIIIlII, 1, llllllllllllllIlIIIIIIllllIIIllI.func_176765_a()));
        }
    }
}
