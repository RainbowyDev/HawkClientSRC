package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockBeacon extends BlockContainer
{
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIIIIIIlIllIllIIlI, final BlockPos lllllllllllllllIIIIIIlIllIllIIIl, final IBlockState lllllllllllllllIIIIIIlIllIlllIIl, final EntityPlayer lllllllllllllllIIIIIIlIllIlllIII, final EnumFacing lllllllllllllllIIIIIIlIllIllIlll, final float lllllllllllllllIIIIIIlIllIllIllI, final float lllllllllllllllIIIIIIlIllIllIlIl, final float lllllllllllllllIIIIIIlIllIllIlII) {
        if (lllllllllllllllIIIIIIlIllIllIIlI.isRemote) {
            return true;
        }
        final TileEntity lllllllllllllllIIIIIIlIllIllIIll = lllllllllllllllIIIIIIlIllIllIIlI.getTileEntity(lllllllllllllllIIIIIIlIllIllIIIl);
        if (lllllllllllllllIIIIIIlIllIllIIll instanceof TileEntityBeacon) {
            lllllllllllllllIIIIIIlIllIlllIII.displayGUIChest((IInventory)lllllllllllllllIIIIIIlIllIllIIll);
        }
        return true;
    }
    
    public static void func_176450_d(final World lllllllllllllllIIIIIIlIllIIIIlIl, final BlockPos lllllllllllllllIIIIIIlIllIIIIlII) {
        HttpUtil.field_180193_a.submit((Runnable)new Runnable() {
            @Override
            public void run() {
                final Chunk llllllllllllllIIlllIIllllllIIIll = lllllllllllllllIIIIIIlIllIIIIlIl.getChunkFromBlockCoords(lllllllllllllllIIIIIIlIllIIIIlII);
                for (int llllllllllllllIIlllIIllllllIIIlI = lllllllllllllllIIIIIIlIllIIIIlII.getY() - 1; llllllllllllllIIlllIIllllllIIIlI >= 0; --llllllllllllllIIlllIIllllllIIIlI) {
                    final BlockPos llllllllllllllIIlllIIllllllIIIIl = new BlockPos(lllllllllllllllIIIIIIlIllIIIIlII.getX(), llllllllllllllIIlllIIllllllIIIlI, lllllllllllllllIIIIIIlIllIIIIlII.getZ());
                    if (!llllllllllllllIIlllIIllllllIIIll.canSeeSky(llllllllllllllIIlllIIllllllIIIIl)) {
                        break;
                    }
                    final IBlockState llllllllllllllIIlllIIllllllIIIII = lllllllllllllllIIIIIIlIllIIIIlIl.getBlockState(llllllllllllllIIlllIIllllllIIIIl);
                    if (llllllllllllllIIlllIIllllllIIIII.getBlock() == Blocks.beacon) {
                        ((WorldServer)lllllllllllllllIIIIIIlIllIIIIlIl).addScheduledTask(new Runnable() {
                            static {
                                __OBFID = "CL_00002135";
                            }
                            
                            @Override
                            public void run() {
                                final TileEntity lIllIIIllIllIl = lllllllllllllllIIIIIIlIllIIIIlIl.getTileEntity(llllllllllllllIIlllIIllllllIIIIl);
                                if (lIllIIIllIllIl instanceof TileEntityBeacon) {
                                    ((TileEntityBeacon)lIllIIIllIllIl).func_174908_m();
                                    lllllllllllllllIIIIIIlIllIIIIlIl.addBlockEvent(llllllllllllllIIlllIIllllllIIIIl, Blocks.beacon, 1, 0);
                                }
                            }
                        });
                    }
                }
            }
            
            static {
                __OBFID = "CL_00002136";
            }
        });
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllIIIIIIlIllIIIlIll, final BlockPos lllllllllllllllIIIIIIlIllIIIlIlI, final IBlockState lllllllllllllllIIIIIIlIllIIIllll, final Block lllllllllllllllIIIIIIlIllIIIlllI) {
        final TileEntity lllllllllllllllIIIIIIlIllIIIllIl = lllllllllllllllIIIIIIlIllIIIlIll.getTileEntity(lllllllllllllllIIIIIIlIllIIIlIlI);
        if (lllllllllllllllIIIIIIlIllIIIllIl instanceof TileEntityBeacon) {
            ((TileEntityBeacon)lllllllllllllllIIIIIIlIllIIIllIl).func_174908_m();
            lllllllllllllllIIIIIIlIllIIIlIll.addBlockEvent(lllllllllllllllIIIIIIlIllIIIlIlI, this, 1, 0);
        }
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllllIIIIIIlIllIIlllII, final BlockPos lllllllllllllllIIIIIIlIllIlIIIlI, final IBlockState lllllllllllllllIIIIIIlIllIIllIlI, final EntityLivingBase lllllllllllllllIIIIIIlIllIlIIIII, final ItemStack lllllllllllllllIIIIIIlIllIIllIII) {
        super.onBlockPlacedBy(lllllllllllllllIIIIIIlIllIIlllII, lllllllllllllllIIIIIIlIllIlIIIlI, lllllllllllllllIIIIIIlIllIIllIlI, lllllllllllllllIIIIIIlIllIlIIIII, lllllllllllllllIIIIIIlIllIIllIII);
        if (lllllllllllllllIIIIIIlIllIIllIII.hasDisplayName()) {
            final TileEntity lllllllllllllllIIIIIIlIllIIllllI = lllllllllllllllIIIIIIlIllIIlllII.getTileEntity(lllllllllllllllIIIIIIlIllIlIIIlI);
            if (lllllllllllllllIIIIIIlIllIIllllI instanceof TileEntityBeacon) {
                ((TileEntityBeacon)lllllllllllllllIIIIIIlIllIIllllI).func_145999_a(lllllllllllllllIIIIIIlIllIIllIII.getDisplayName());
            }
        }
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllllIIIIIIlIlllIIIIlI, final int lllllllllllllllIIIIIIlIlllIIIIIl) {
        return new TileEntityBeacon();
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    static {
        __OBFID = "CL_00000197";
    }
    
    public BlockBeacon() {
        super(Material.glass);
        this.setHardness(3.0f);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
}
