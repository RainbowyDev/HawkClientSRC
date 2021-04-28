package net.minecraft.util;

import java.lang.reflect.*;
import java.util.concurrent.locks.*;

public class ThreadSafeBoundList
{
    private final /* synthetic */ Object[] field_152759_a;
    private /* synthetic */ int field_152762_d;
    private final /* synthetic */ Class field_152760_b;
    private /* synthetic */ int field_152763_e;
    private final /* synthetic */ ReadWriteLock field_152761_c;
    
    public Object[] func_152756_c() {
        final Object[] llllllllllllllllIIIIIIIlIIlIlIlI = (Object[])Array.newInstance(this.field_152760_b, this.field_152762_d);
        this.field_152761_c.readLock().lock();
        for (int llllllllllllllllIIIIIIIlIIlIlIIl = 0; llllllllllllllllIIIIIIIlIIlIlIIl < this.field_152762_d; ++llllllllllllllllIIIIIIIlIIlIlIIl) {
            int llllllllllllllllIIIIIIIlIIlIlIII = (this.field_152763_e - this.field_152762_d + llllllllllllllllIIIIIIIlIIlIlIIl) % this.func_152758_b();
            if (llllllllllllllllIIIIIIIlIIlIlIII < 0) {
                llllllllllllllllIIIIIIIlIIlIlIII += this.func_152758_b();
            }
            llllllllllllllllIIIIIIIlIIlIlIlI[llllllllllllllllIIIIIIIlIIlIlIIl] = this.field_152759_a[llllllllllllllllIIIIIIIlIIlIlIII];
        }
        this.field_152761_c.readLock().unlock();
        return llllllllllllllllIIIIIIIlIIlIlIlI;
    }
    
    public Object func_152757_a(final Object llllllllllllllllIIIIIIIlIIllIllI) {
        this.field_152761_c.writeLock().lock();
        this.field_152759_a[this.field_152763_e] = llllllllllllllllIIIIIIIlIIllIllI;
        this.field_152763_e = (this.field_152763_e + 1) % this.func_152758_b();
        if (this.field_152762_d < this.func_152758_b()) {
            ++this.field_152762_d;
        }
        this.field_152761_c.writeLock().unlock();
        return llllllllllllllllIIIIIIIlIIllIllI;
    }
    
    static {
        __OBFID = "CL_00001868";
    }
    
    public int func_152758_b() {
        this.field_152761_c.readLock().lock();
        final int llllllllllllllllIIIIIIIlIIllIIlI = this.field_152759_a.length;
        this.field_152761_c.readLock().unlock();
        return llllllllllllllllIIIIIIIlIIllIIlI;
    }
    
    public ThreadSafeBoundList(final Class llllllllllllllllIIIIIIIlIlIIIIII, final int llllllllllllllllIIIIIIIlIIllllII) {
        this.field_152761_c = new ReentrantReadWriteLock();
        this.field_152760_b = llllllllllllllllIIIIIIIlIlIIIIII;
        this.field_152759_a = (Object[])Array.newInstance(llllllllllllllllIIIIIIIlIlIIIIII, llllllllllllllllIIIIIIIlIIllllII);
    }
}
