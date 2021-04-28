package net.minecraft.tileentity;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class TileEntityNote extends TileEntity
{
    public /* synthetic */ byte note;
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllIIlIIIIllIIlIlIlII) {
        super.writeToNBT(llllllllllllllIIlIIIIllIIlIlIlII);
        llllllllllllllIIlIIIIllIIlIlIlII.setByte("note", this.note);
    }
    
    public void func_175108_a(final World llllllllllllllIIlIIIIllIIIllllll, final BlockPos llllllllllllllIIlIIIIllIIIlllllI) {
        if (llllllllllllllIIlIIIIllIIIllllll.getBlockState(llllllllllllllIIlIIIIllIIIlllllI.offsetUp()).getBlock().getMaterial() == Material.air) {
            final Material llllllllllllllIIlIIIIllIIlIIIIlI = llllllllllllllIIlIIIIllIIIllllll.getBlockState(llllllllllllllIIlIIIIllIIIlllllI.offsetDown()).getBlock().getMaterial();
            byte llllllllllllllIIlIIIIllIIlIIIIIl = 0;
            if (llllllllllllllIIlIIIIllIIlIIIIlI == Material.rock) {
                llllllllllllllIIlIIIIllIIlIIIIIl = 1;
            }
            if (llllllllllllllIIlIIIIllIIlIIIIlI == Material.sand) {
                llllllllllllllIIlIIIIllIIlIIIIIl = 2;
            }
            if (llllllllllllllIIlIIIIllIIlIIIIlI == Material.glass) {
                llllllllllllllIIlIIIIllIIlIIIIIl = 3;
            }
            if (llllllllllllllIIlIIIIllIIlIIIIlI == Material.wood) {
                llllllllllllllIIlIIIIllIIlIIIIIl = 4;
            }
            llllllllllllllIIlIIIIllIIIllllll.addBlockEvent(llllllllllllllIIlIIIIllIIIlllllI, Blocks.noteblock, llllllllllllllIIlIIIIllIIlIIIIIl, this.note);
        }
    }
    
    public void changePitch() {
        this.note = (byte)((this.note + 1) % 25);
        this.markDirty();
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIlIIIIllIIlIlIIII) {
        super.readFromNBT(llllllllllllllIIlIIIIllIIlIlIIII);
        this.note = llllllllllllllIIlIIIIllIIlIlIIII.getByte("note");
        this.note = (byte)MathHelper.clamp_int(this.note, 0, 24);
    }
    
    static {
        __OBFID = "CL_00000362";
    }
}
