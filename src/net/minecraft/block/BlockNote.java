package net.minecraft.block;

import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import net.minecraft.util.*;

public class BlockNote extends BlockContainer
{
    private static final /* synthetic */ List field_176434_a;
    
    private String func_176433_b(int lllllllllllllllIlIIlIlIllIlllIlI) {
        if (lllllllllllllllIlIIlIlIllIlllIlI < 0 || lllllllllllllllIlIIlIlIllIlllIlI >= BlockNote.field_176434_a.size()) {
            lllllllllllllllIlIIlIlIllIlllIlI = 0;
        }
        return BlockNote.field_176434_a.get(lllllllllllllllIlIIlIlIllIlllIlI);
    }
    
    public BlockNote() {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllIlIIlIlIllllIIIll, final BlockPos lllllllllllllllIlIIlIlIllllIlIIl, final IBlockState lllllllllllllllIlIIlIlIllllIlIII, final Block lllllllllllllllIlIIlIlIllllIIlll) {
        final boolean lllllllllllllllIlIIlIlIllllIIllI = lllllllllllllllIlIIlIlIllllIIIll.isBlockPowered(lllllllllllllllIlIIlIlIllllIlIIl);
        final TileEntity lllllllllllllllIlIIlIlIllllIIlIl = lllllllllllllllIlIIlIlIllllIIIll.getTileEntity(lllllllllllllllIlIIlIlIllllIlIIl);
        if (lllllllllllllllIlIIlIlIllllIIlIl instanceof TileEntityNote) {
            final TileEntityNote lllllllllllllllIlIIlIlIllllIIlII = (TileEntityNote)lllllllllllllllIlIIlIlIllllIIlIl;
            if (lllllllllllllllIlIIlIlIllllIIlII.previousRedstoneState != lllllllllllllllIlIIlIlIllllIIllI) {
                if (lllllllllllllllIlIIlIlIllllIIllI) {
                    lllllllllllllllIlIIlIlIllllIIlII.func_175108_a(lllllllllllllllIlIIlIlIllllIIIll, lllllllllllllllIlIIlIlIllllIlIIl);
                }
                lllllllllllllllIlIIlIlIllllIIlII.previousRedstoneState = lllllllllllllllIlIIlIlIllllIIllI;
            }
        }
    }
    
    @Override
    public void onBlockClicked(final World lllllllllllllllIlIIlIlIlllIIIlll, final BlockPos lllllllllllllllIlIIlIlIlllIIIllI, final EntityPlayer lllllllllllllllIlIIlIlIlllIIIlIl) {
        if (!lllllllllllllllIlIIlIlIlllIIIlll.isRemote) {
            final TileEntity lllllllllllllllIlIIlIlIlllIIIlII = lllllllllllllllIlIIlIlIlllIIIlll.getTileEntity(lllllllllllllllIlIIlIlIlllIIIllI);
            if (lllllllllllllllIlIIlIlIlllIIIlII instanceof TileEntityNote) {
                ((TileEntityNote)lllllllllllllllIlIIlIlIlllIIIlII).func_175108_a(lllllllllllllllIlIIlIlIlllIIIlll, lllllllllllllllIlIIlIlIlllIIIllI);
            }
        }
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    static {
        __OBFID = "CL_00000278";
        field_176434_a = Lists.newArrayList((Object[])new String[] { "harp", "bd", "snare", "hat", "bassattack" });
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIlIIlIlIlllIIllll, final BlockPos lllllllllllllllIlIIlIlIlllIIlllI, final IBlockState lllllllllllllllIlIIlIlIlllIlIlll, final EntityPlayer lllllllllllllllIlIIlIlIlllIlIllI, final EnumFacing lllllllllllllllIlIIlIlIlllIlIlIl, final float lllllllllllllllIlIIlIlIlllIlIlII, final float lllllllllllllllIlIIlIlIlllIlIIll, final float lllllllllllllllIlIIlIlIlllIlIIlI) {
        if (lllllllllllllllIlIIlIlIlllIIllll.isRemote) {
            return true;
        }
        final TileEntity lllllllllllllllIlIIlIlIlllIlIIIl = lllllllllllllllIlIIlIlIlllIIllll.getTileEntity(lllllllllllllllIlIIlIlIlllIIlllI);
        if (lllllllllllllllIlIIlIlIlllIlIIIl instanceof TileEntityNote) {
            final TileEntityNote lllllllllllllllIlIIlIlIlllIlIIII = (TileEntityNote)lllllllllllllllIlIIlIlIlllIlIIIl;
            lllllllllllllllIlIIlIlIlllIlIIII.changePitch();
            lllllllllllllllIlIIlIlIlllIlIIII.func_175108_a(lllllllllllllllIlIIlIlIlllIIllll, lllllllllllllllIlIIlIlIlllIIlllI);
        }
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllllIlIIlIlIllIllllll, final int lllllllllllllllIlIIlIlIllIlllllI) {
        return new TileEntityNote();
    }
    
    @Override
    public boolean onBlockEventReceived(final World lllllllllllllllIlIIlIlIllIllIIlI, final BlockPos lllllllllllllllIlIIlIlIllIllIIIl, final IBlockState lllllllllllllllIlIIlIlIllIllIIII, final int lllllllllllllllIlIIlIlIllIlIllll, final int lllllllllllllllIlIIlIlIllIlIlIII) {
        final float lllllllllllllllIlIIlIlIllIlIllIl = (float)Math.pow(2.0, (lllllllllllllllIlIIlIlIllIlIlIII - 12) / 12.0);
        lllllllllllllllIlIIlIlIllIllIIlI.playSoundEffect(lllllllllllllllIlIIlIlIllIllIIIl.getX() + 0.5, lllllllllllllllIlIIlIlIllIllIIIl.getY() + 0.5, lllllllllllllllIlIIlIlIllIllIIIl.getZ() + 0.5, String.valueOf(new StringBuilder("note.").append(this.func_176433_b(lllllllllllllllIlIIlIlIllIlIllll))), 3.0f, lllllllllllllllIlIIlIlIllIlIllIl);
        lllllllllllllllIlIIlIlIllIllIIlI.spawnParticle(EnumParticleTypes.NOTE, lllllllllllllllIlIIlIlIllIllIIIl.getX() + 0.5, lllllllllllllllIlIIlIlIllIllIIIl.getY() + 1.2, lllllllllllllllIlIIlIlIllIllIIIl.getZ() + 0.5, lllllllllllllllIlIIlIlIllIlIlIII / 24.0, 0.0, 0.0, new int[0]);
        return true;
    }
}
