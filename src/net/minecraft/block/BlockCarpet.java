package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;

public class BlockCarpet extends Block
{
    public static final /* synthetic */ PropertyEnum field_176330_a;
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIIIlIIlIIIlIIlIl) {
        return this.getDefaultState().withProperty(BlockCarpet.field_176330_a, EnumDyeColor.func_176764_b(lllllllllllllllIIIIlIIlIIIlIIlIl));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIIlIIlIIIIlllll) {
        return ((EnumDyeColor)lllllllllllllllIIIIlIIlIIIIlllll.getValue(BlockCarpet.field_176330_a)).func_176765_a();
    }
    
    private boolean checkAndDropBlock(final World lllllllllllllllIIIIlIIlIIlIIllIl, final BlockPos lllllllllllllllIIIIlIIlIIlIIllII, final IBlockState lllllllllllllllIIIIlIIlIIlIIllll) {
        if (!this.canBlockStay(lllllllllllllllIIIIlIIlIIlIIllIl, lllllllllllllllIIIIlIIlIIlIIllII)) {
            this.dropBlockAsItem(lllllllllllllllIIIIlIIlIIlIIllIl, lllllllllllllllIIIIlIIlIIlIIllII, lllllllllllllllIIIIlIIlIIlIIllll, 0);
            lllllllllllllllIIIIlIIlIIlIIllIl.setBlockToAir(lllllllllllllllIIIIlIIlIIlIIllII);
            return false;
        }
        return true;
    }
    
    private boolean canBlockStay(final World lllllllllllllllIIIIlIIlIIlIIIlll, final BlockPos lllllllllllllllIIIIlIIlIIlIIIllI) {
        return !lllllllllllllllIIIIlIIlIIlIIIlll.isAirBlock(lllllllllllllllIIIIlIIlIIlIIIllI.offsetDown());
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockCarpet.field_176330_a });
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIIIIlIIlIIIllIlII) {
        return ((EnumDyeColor)lllllllllllllllIIIIlIIlIIIllIlII.getValue(BlockCarpet.field_176330_a)).func_176765_a();
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIIIIlIIlIIllIIlIl, final BlockPos lllllllllllllllIIIIlIIlIIllIIlll) {
        return super.canPlaceBlockAt(lllllllllllllllIIIIlIIlIIllIIlIl, lllllllllllllllIIIIlIIlIIllIIlll) && this.canBlockStay(lllllllllllllllIIIIlIIlIIllIIlIl, lllllllllllllllIIIIlIIlIIllIIlll);
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBoundsFromMeta(0);
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllIIIIlIIlIIlIllllI, final BlockPos lllllllllllllllIIIIlIIlIIlIllIII, final IBlockState lllllllllllllllIIIIlIIlIIlIlIlll, final Block lllllllllllllllIIIIlIIlIIlIllIll) {
        this.checkAndDropBlock(lllllllllllllllIIIIlIIlIIlIllllI, lllllllllllllllIIIIlIIlIIlIllIII, lllllllllllllllIIIIlIIlIIlIlIlll);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess lllllllllllllllIIIIlIIlIIIlllIlI, final BlockPos lllllllllllllllIIIIlIIlIIIllllIl, final EnumFacing lllllllllllllllIIIIlIIlIIIllllII) {
        return lllllllllllllllIIIIlIIlIIIllllII == EnumFacing.UP || super.shouldSideBeRendered(lllllllllllllllIIIIlIIlIIIlllIlI, lllllllllllllllIIIIlIIlIIIllllIl, lllllllllllllllIIIIlIIlIIIllllII);
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllIIIIlIIlIIIlIllll, final CreativeTabs lllllllllllllllIIIIlIIlIIIlIlllI, final List lllllllllllllllIIIIlIIlIIIlIlIlI) {
        for (int lllllllllllllllIIIIlIIlIIIlIllII = 0; lllllllllllllllIIIIlIIlIIIlIllII < 16; ++lllllllllllllllIIIIlIIlIIIlIllII) {
            lllllllllllllllIIIIlIIlIIIlIlIlI.add(new ItemStack(lllllllllllllllIIIIlIIlIIIlIllll, 1, lllllllllllllllIIIIlIIlIIIlIllII));
        }
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllIIIIlIIlIIllllIIl, final BlockPos lllllllllllllllIIIIlIIlIIllllIII) {
        this.setBlockBoundsFromMeta(0);
    }
    
    protected void setBlockBoundsFromMeta(final int lllllllllllllllIIIIlIIlIIlllIIlI) {
        final byte lllllllllllllllIIIIlIIlIIlllIIIl = 0;
        final float lllllllllllllllIIIIlIIlIIlllIIII = 1 * (1 + lllllllllllllllIIIIlIIlIIlllIIIl) / 16.0f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, lllllllllllllllIIIIlIIlIIlllIIII, 1.0f);
    }
    
    protected BlockCarpet() {
        super(Material.carpet);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockCarpet.field_176330_a, EnumDyeColor.WHITE));
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockBoundsFromMeta(0);
    }
    
    static {
        __OBFID = "CL_00000338";
        field_176330_a = PropertyEnum.create("color", EnumDyeColor.class);
    }
}
