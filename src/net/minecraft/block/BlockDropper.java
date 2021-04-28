package net.minecraft.block;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.dispenser.*;
import net.minecraft.inventory.*;

public class BlockDropper extends BlockDispenser
{
    private final /* synthetic */ IBehaviorDispenseItem field_149947_P;
    
    static {
        __OBFID = "CL_00000233";
    }
    
    public BlockDropper() {
        this.field_149947_P = new BehaviorDefaultDispenseItem();
    }
    
    @Override
    protected IBehaviorDispenseItem func_149940_a(final ItemStack llllllllllllllIlllIIlIllIIIIlllI) {
        return this.field_149947_P;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIlllIIlIllIIIIlIll, final int llllllllllllllIlllIIlIllIIIIlIlI) {
        return new TileEntityDropper();
    }
    
    @Override
    protected void func_176439_d(final World llllllllllllllIlllIIlIlIllllIIIl, final BlockPos llllllllllllllIlllIIlIlIllllIIII) {
        final BlockSourceImpl llllllllllllllIlllIIlIlIlllllIll = new BlockSourceImpl(llllllllllllllIlllIIlIlIllllIIIl, llllllllllllllIlllIIlIlIllllIIII);
        final TileEntityDispenser llllllllllllllIlllIIlIlIlllllIlI = (TileEntityDispenser)llllllllllllllIlllIIlIlIlllllIll.getBlockTileEntity();
        if (llllllllllllllIlllIIlIlIlllllIlI != null) {
            final int llllllllllllllIlllIIlIlIlllllIIl = llllllllllllllIlllIIlIlIlllllIlI.func_146017_i();
            if (llllllllllllllIlllIIlIlIlllllIIl < 0) {
                llllllllllllllIlllIIlIlIllllIIIl.playAuxSFX(1001, llllllllllllllIlllIIlIlIllllIIII, 0);
            }
            else {
                final ItemStack llllllllllllllIlllIIlIlIlllllIII = llllllllllllllIlllIIlIlIlllllIlI.getStackInSlot(llllllllllllllIlllIIlIlIlllllIIl);
                if (llllllllllllllIlllIIlIlIlllllIII != null) {
                    final EnumFacing llllllllllllllIlllIIlIlIllllIlll = (EnumFacing)llllllllllllllIlllIIlIlIllllIIIl.getBlockState(llllllllllllllIlllIIlIlIllllIIII).getValue(BlockDropper.FACING);
                    final BlockPos llllllllllllllIlllIIlIlIllllIllI = llllllllllllllIlllIIlIlIllllIIII.offset(llllllllllllllIlllIIlIlIllllIlll);
                    final IInventory llllllllllllllIlllIIlIlIllllIlIl = TileEntityHopper.func_145893_b(llllllllllllllIlllIIlIlIllllIIIl, llllllllllllllIlllIIlIlIllllIllI.getX(), llllllllllllllIlllIIlIlIllllIllI.getY(), llllllllllllllIlllIIlIlIllllIllI.getZ());
                    ItemStack llllllllllllllIlllIIlIlIllllIIll = null;
                    if (llllllllllllllIlllIIlIlIllllIlIl == null) {
                        ItemStack llllllllllllllIlllIIlIlIllllIlII = this.field_149947_P.dispense(llllllllllllllIlllIIlIlIlllllIll, llllllllllllllIlllIIlIlIlllllIII);
                        if (llllllllllllllIlllIIlIlIllllIlII != null && llllllllllllllIlllIIlIlIllllIlII.stackSize == 0) {
                            llllllllllllllIlllIIlIlIllllIlII = null;
                        }
                    }
                    else {
                        llllllllllllllIlllIIlIlIllllIIll = TileEntityHopper.func_174918_a(llllllllllllllIlllIIlIlIllllIlIl, llllllllllllllIlllIIlIlIlllllIII.copy().splitStack(1), llllllllllllllIlllIIlIlIllllIlll.getOpposite());
                        if (llllllllllllllIlllIIlIlIllllIIll == null) {
                            final ItemStack copy;
                            llllllllllllllIlllIIlIlIllllIIll = (copy = llllllllllllllIlllIIlIlIlllllIII.copy());
                            if (--copy.stackSize == 0) {
                                llllllllllllllIlllIIlIlIllllIIll = null;
                            }
                        }
                        else {
                            llllllllllllllIlllIIlIlIllllIIll = llllllllllllllIlllIIlIlIlllllIII.copy();
                        }
                    }
                    llllllllllllllIlllIIlIlIlllllIlI.setInventorySlotContents(llllllllllllllIlllIIlIlIlllllIIl, llllllllllllllIlllIIlIlIllllIIll);
                }
            }
        }
    }
}
