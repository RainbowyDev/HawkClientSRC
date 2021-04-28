package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.block.material.*;

public class BlockStainedGlass extends BlockBreakable
{
    public static final /* synthetic */ PropertyEnum field_176547_a;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIllIllIIIlIlIllIl) {
        return this.getDefaultState().withProperty(BlockStainedGlass.field_176547_a, EnumDyeColor.func_176764_b(lllllllllllllllIllIllIIIlIlIllIl));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIllIllIIIlIIllIII) {
        return ((EnumDyeColor)lllllllllllllllIllIllIIIlIIllIII.getValue(BlockStainedGlass.field_176547_a)).func_176765_a();
    }
    
    static {
        __OBFID = "CL_00000312";
        field_176547_a = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIllIllIIIllIIlllI) {
        return ((EnumDyeColor)lllllllllllllllIllIllIIIllIIlllI.getValue(BlockStainedGlass.field_176547_a)).func_176765_a();
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllIllIllIIIlIlIIlII, final BlockPos lllllllllllllllIllIllIIIlIlIIIll, final IBlockState lllllllllllllllIllIllIIIlIlIIlIl) {
        if (!lllllllllllllllIllIllIIIlIlIIlII.isRemote) {
            BlockBeacon.func_176450_d(lllllllllllllllIllIllIIIlIlIIlII, lllllllllllllllIllIllIIIlIlIIIll);
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockStainedGlass.field_176547_a });
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllIllIllIIIlIllllll, final CreativeTabs lllllllllllllllIllIllIIIllIIIlIl, final List lllllllllllllllIllIllIIIllIIIlII) {
        for (final EnumDyeColor lllllllllllllllIllIllIIIllIIIIII : EnumDyeColor.values()) {
            lllllllllllllllIllIllIIIllIIIlII.add(new ItemStack(lllllllllllllllIllIllIIIlIllllll, 1, lllllllllllllllIllIllIIIllIIIIII.func_176765_a()));
        }
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllIllIllIIIlIllIIll) {
        return 0;
    }
    
    public BlockStainedGlass(final Material lllllllllllllllIllIllIIIllIlIlII) {
        super(lllllllllllllllIllIllIIIllIlIlII, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStainedGlass.field_176547_a, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllIllIllIIIlIIlllll, final BlockPos lllllllllllllllIllIllIIIlIIllIll, final IBlockState lllllllllllllllIllIllIIIlIIlllIl) {
        if (!lllllllllllllllIllIllIIIlIIlllll.isRemote) {
            BlockBeacon.func_176450_d(lllllllllllllllIllIllIIIlIIlllll, lllllllllllllllIllIllIIIlIIllIll);
        }
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIllIllIIIlIllIlll) {
        return ((EnumDyeColor)lllllllllllllllIllIllIIIlIllIlll.getValue(BlockStainedGlass.field_176547_a)).func_176768_e();
    }
}
