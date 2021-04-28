package net.minecraft.tileentity;

import net.minecraft.nbt.*;

public class TileEntityComparator extends TileEntity
{
    private /* synthetic */ int outputSignal;
    
    @Override
    public void readFromNBT(final NBTTagCompound lIIIIllIIllII) {
        super.readFromNBT(lIIIIllIIllII);
        this.outputSignal = lIIIIllIIllII.getInteger("OutputSignal");
    }
    
    public void setOutputSignal(final int lIIIIllIIIlIl) {
        this.outputSignal = lIIIIllIIIlIl;
    }
    
    public int getOutputSignal() {
        return this.outputSignal;
    }
    
    static {
        __OBFID = "CL_00000349";
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound lIIIIllIlIlII) {
        super.writeToNBT(lIIIIllIlIlII);
        lIIIIllIlIlII.setInteger("OutputSignal", this.outputSignal);
    }
}
