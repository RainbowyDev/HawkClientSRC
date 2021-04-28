package net.minecraft.world;

import net.minecraft.nbt.*;

public class LockCode
{
    public static final /* synthetic */ LockCode EMPTY_CODE;
    private final /* synthetic */ String lock;
    
    public void toNBT(final NBTTagCompound llllllllllllllIIlIIIlIllllIlIllI) {
        llllllllllllllIIlIIIlIllllIlIllI.setString("Lock", this.lock);
    }
    
    static {
        __OBFID = "CL_00002260";
        EMPTY_CODE = new LockCode("");
    }
    
    public static LockCode fromNBT(final NBTTagCompound llllllllllllllIIlIIIlIllllIlIIIl) {
        if (llllllllllllllIIlIIIlIllllIlIIIl.hasKey("Lock", 8)) {
            final String llllllllllllllIIlIIIlIllllIlIIII = llllllllllllllIIlIIIlIllllIlIIIl.getString("Lock");
            return new LockCode(llllllllllllllIIlIIIlIllllIlIIII);
        }
        return LockCode.EMPTY_CODE;
    }
    
    public String getLock() {
        return this.lock;
    }
    
    public LockCode(final String llllllllllllllIIlIIIlIlllllIIIlI) {
        this.lock = llllllllllllllIIlIIIlIlllllIIIlI;
    }
    
    public boolean isEmpty() {
        return this.lock == null || this.lock.isEmpty();
    }
}
