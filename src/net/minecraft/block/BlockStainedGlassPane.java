package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public class BlockStainedGlassPane extends BlockPane
{
    public static final /* synthetic */ PropertyEnum field_176245_a;
    
    @Override
    public int getMetaFromState(final IBlockState lIIIllIIlllIIl) {
        return ((EnumDyeColor)lIIIllIIlllIIl.getValue(BlockStainedGlassPane.field_176245_a)).func_176765_a();
    }
    
    @Override
    public int damageDropped(final IBlockState lIIIllIlIIlllI) {
        return ((EnumDyeColor)lIIIllIlIIlllI.getValue(BlockStainedGlassPane.field_176245_a)).func_176765_a();
    }
    
    @Override
    public void onBlockAdded(final World lIIIllIIllIIIl, final BlockPos lIIIllIIllIIII, final IBlockState lIIIllIIlIllll) {
        if (!lIIIllIIllIIIl.isRemote) {
            BlockBeacon.func_176450_d(lIIIllIIllIIIl, lIIIllIIllIIII);
        }
    }
    
    static {
        __OBFID = "CL_00000313";
        field_176245_a = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIIllIIllllII) {
        return this.getDefaultState().withProperty(BlockStainedGlassPane.field_176245_a, EnumDyeColor.func_176764_b(lIIIllIIllllII));
    }
    
    @Override
    public void breakBlock(final World lIIIllIIlIlIIl, final BlockPos lIIIllIIlIlIII, final IBlockState lIIIllIIlIIlll) {
        if (!lIIIllIIlIlIIl.isRemote) {
            BlockBeacon.func_176450_d(lIIIllIIlIlIIl, lIIIllIIlIlIII);
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockStainedGlassPane.NORTH, BlockStainedGlassPane.EAST, BlockStainedGlassPane.WEST, BlockStainedGlassPane.SOUTH, BlockStainedGlassPane.field_176245_a });
    }
    
    @Override
    public void getSubBlocks(final Item lIIIllIlIIlIIl, final CreativeTabs lIIIllIlIIlIII, final List lIIIllIlIIIlll) {
        for (int lIIIllIlIIIllI = 0; lIIIllIlIIIllI < EnumDyeColor.values().length; ++lIIIllIlIIIllI) {
            lIIIllIlIIIlll.add(new ItemStack(lIIIllIlIIlIIl, 1, lIIIllIlIIIllI));
        }
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
    
    public BlockStainedGlassPane() {
        super(Material.glass, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStainedGlassPane.NORTH, false).withProperty(BlockStainedGlassPane.EAST, false).withProperty(BlockStainedGlassPane.SOUTH, false).withProperty(BlockStainedGlassPane.WEST, false).withProperty(BlockStainedGlassPane.field_176245_a, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
}
