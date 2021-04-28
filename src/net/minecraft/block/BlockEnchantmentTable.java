package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockEnchantmentTable extends BlockContainer
{
    @Override
    public void randomDisplayTick(final World llllllllllllllllIlIIIllIlIlIIlII, final BlockPos llllllllllllllllIlIIIllIlIlIIIll, final IBlockState llllllllllllllllIlIIIllIlIlIlIll, final Random llllllllllllllllIlIIIllIlIlIIIIl) {
        super.randomDisplayTick(llllllllllllllllIlIIIllIlIlIIlII, llllllllllllllllIlIIIllIlIlIIIll, llllllllllllllllIlIIIllIlIlIlIll, llllllllllllllllIlIIIllIlIlIIIIl);
        for (int llllllllllllllllIlIIIllIlIlIlIIl = -2; llllllllllllllllIlIIIllIlIlIlIIl <= 2; ++llllllllllllllllIlIIIllIlIlIlIIl) {
            for (int llllllllllllllllIlIIIllIlIlIlIII = -2; llllllllllllllllIlIIIllIlIlIlIII <= 2; ++llllllllllllllllIlIIIllIlIlIlIII) {
                if (llllllllllllllllIlIIIllIlIlIlIIl > -2 && llllllllllllllllIlIIIllIlIlIlIIl < 2 && llllllllllllllllIlIIIllIlIlIlIII == -1) {
                    llllllllllllllllIlIIIllIlIlIlIII = 2;
                }
                if (llllllllllllllllIlIIIllIlIlIIIIl.nextInt(16) == 0) {
                    for (int llllllllllllllllIlIIIllIlIlIIlll = 0; llllllllllllllllIlIIIllIlIlIIlll <= 1; ++llllllllllllllllIlIIIllIlIlIIlll) {
                        final BlockPos llllllllllllllllIlIIIllIlIlIIllI = llllllllllllllllIlIIIllIlIlIIIll.add(llllllllllllllllIlIIIllIlIlIlIIl, llllllllllllllllIlIIIllIlIlIIlll, llllllllllllllllIlIIIllIlIlIlIII);
                        if (llllllllllllllllIlIIIllIlIlIIlII.getBlockState(llllllllllllllllIlIIIllIlIlIIllI).getBlock() == Blocks.bookshelf) {
                            if (!llllllllllllllllIlIIIllIlIlIIlII.isAirBlock(llllllllllllllllIlIIIllIlIlIIIll.add(llllllllllllllllIlIIIllIlIlIlIIl / 2, 0, llllllllllllllllIlIIIllIlIlIlIII / 2))) {
                                break;
                            }
                            llllllllllllllllIlIIIllIlIlIIlII.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, llllllllllllllllIlIIIllIlIlIIIll.getX() + 0.5, llllllllllllllllIlIIIllIlIlIIIll.getY() + 2.0, llllllllllllllllIlIIIllIlIlIIIll.getZ() + 0.5, llllllllllllllllIlIIIllIlIlIlIIl + llllllllllllllllIlIIIllIlIlIIIIl.nextFloat() - 0.5, llllllllllllllllIlIIIllIlIlIIlll - llllllllllllllllIlIIIllIlIlIIIIl.nextFloat() - 1.0f, llllllllllllllllIlIIIllIlIlIlIII + llllllllllllllllIlIIIllIlIlIIIIl.nextFloat() - 0.5, new int[0]);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllllIlIIIllIlIIllIIl, final int llllllllllllllllIlIIIllIlIIllIII) {
        return new TileEntityEnchantmentTable();
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllllIlIIIllIlIIlIIlI, final BlockPos llllllllllllllllIlIIIllIlIIlIIIl, final IBlockState llllllllllllllllIlIIIllIlIIlIIII, final EntityPlayer llllllllllllllllIlIIIllIlIIIllll, final EnumFacing llllllllllllllllIlIIIllIlIIIlllI, final float llllllllllllllllIlIIIllIlIIIllIl, final float llllllllllllllllIlIIIllIlIIIllII, final float llllllllllllllllIlIIIllIlIIIlIll) {
        if (llllllllllllllllIlIIIllIlIIlIIlI.isRemote) {
            return true;
        }
        final TileEntity llllllllllllllllIlIIIllIlIIIlIlI = llllllllllllllllIlIIIllIlIIlIIlI.getTileEntity(llllllllllllllllIlIIIllIlIIlIIIl);
        if (llllllllllllllllIlIIIllIlIIIlIlI instanceof TileEntityEnchantmentTable) {
            llllllllllllllllIlIIIllIlIIIllll.displayGui((IInteractionObject)llllllllllllllllIlIIIllIlIIIlIlI);
        }
        return true;
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllllIlIIIllIIlllIllI, final BlockPos llllllllllllllllIlIIIllIIlllIlIl, final IBlockState llllllllllllllllIlIIIllIIllllIll, final EntityLivingBase llllllllllllllllIlIIIllIIlllIIll, final ItemStack llllllllllllllllIlIIIllIIllllIIl) {
        super.onBlockPlacedBy(llllllllllllllllIlIIIllIIlllIllI, llllllllllllllllIlIIIllIIlllIlIl, llllllllllllllllIlIIIllIIllllIll, llllllllllllllllIlIIIllIIlllIIll, llllllllllllllllIlIIIllIIllllIIl);
        if (llllllllllllllllIlIIIllIIllllIIl.hasDisplayName()) {
            final TileEntity llllllllllllllllIlIIIllIIllllIII = llllllllllllllllIlIIIllIIlllIllI.getTileEntity(llllllllllllllllIlIIIllIIlllIlIl);
            if (llllllllllllllllIlIIIllIIllllIII instanceof TileEntityEnchantmentTable) {
                ((TileEntityEnchantmentTable)llllllllllllllllIlIIIllIIllllIII).func_145920_a(llllllllllllllllIlIIIllIIllllIIl.getDisplayName());
            }
        }
    }
    
    protected BlockEnchantmentTable() {
        super(Material.rock);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000235";
    }
}
