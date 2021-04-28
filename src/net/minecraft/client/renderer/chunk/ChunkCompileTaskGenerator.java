package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.*;
import java.util.concurrent.locks.*;
import com.google.common.collect.*;
import java.util.*;

public class ChunkCompileTaskGenerator
{
    private /* synthetic */ CompiledChunk field_178547_f;
    private /* synthetic */ Status field_178548_g;
    private /* synthetic */ RegionRenderCacheBuilder field_178550_e;
    private final /* synthetic */ RenderChunk field_178553_a;
    private final /* synthetic */ ReentrantLock field_178551_b;
    private final /* synthetic */ Type field_178549_d;
    private /* synthetic */ boolean field_178554_h;
    private final /* synthetic */ List field_178552_c;
    
    public RenderChunk func_178536_b() {
        return this.field_178553_a;
    }
    
    public RegionRenderCacheBuilder func_178545_d() {
        return this.field_178550_e;
    }
    
    public void func_178543_a(final CompiledChunk lllllllllllllIlllllllllIIlIIllll) {
        this.field_178547_f = lllllllllllllIlllllllllIIlIIllll;
    }
    
    public Type func_178538_g() {
        return this.field_178549_d;
    }
    
    public Status func_178546_a() {
        return this.field_178548_g;
    }
    
    static {
        __OBFID = "CL_00002466";
    }
    
    public ReentrantLock func_178540_f() {
        return this.field_178551_b;
    }
    
    public ChunkCompileTaskGenerator(final RenderChunk lllllllllllllIlllllllllIIllIIIlI, final Type lllllllllllllIlllllllllIIllIIIIl) {
        this.field_178551_b = new ReentrantLock();
        this.field_178552_c = Lists.newArrayList();
        this.field_178548_g = Status.PENDING;
        this.field_178553_a = lllllllllllllIlllllllllIIllIIIlI;
        this.field_178549_d = lllllllllllllIlllllllllIIllIIIIl;
    }
    
    public void func_178539_a(final Runnable lllllllllllllIlllllllllIIIIllIll) {
        this.field_178551_b.lock();
        try {
            this.field_178552_c.add(lllllllllllllIlllllllllIIIIllIll);
            if (this.field_178554_h) {
                lllllllllllllIlllllllllIIIIllIll.run();
            }
        }
        finally {
            this.field_178551_b.unlock();
        }
        this.field_178551_b.unlock();
    }
    
    public void func_178542_e() {
        this.field_178551_b.lock();
        try {
            if (this.field_178549_d == Type.REBUILD_CHUNK && this.field_178548_g != Status.DONE) {
                this.field_178553_a.func_178575_a(true);
            }
            this.field_178554_h = true;
            this.field_178548_g = Status.DONE;
            for (final Runnable lllllllllllllIlllllllllIIIlIlIIl : this.field_178552_c) {
                lllllllllllllIlllllllllIIIlIlIIl.run();
            }
        }
        finally {
            this.field_178551_b.unlock();
        }
        this.field_178551_b.unlock();
    }
    
    public boolean func_178537_h() {
        return this.field_178554_h;
    }
    
    public void func_178535_a(final Status lllllllllllllIlllllllllIIIllllll) {
        this.field_178551_b.lock();
        try {
            this.field_178548_g = lllllllllllllIlllllllllIIIllllll;
        }
        finally {
            this.field_178551_b.unlock();
        }
        this.field_178551_b.unlock();
    }
    
    public CompiledChunk func_178544_c() {
        return this.field_178547_f;
    }
    
    public void func_178541_a(final RegionRenderCacheBuilder lllllllllllllIlllllllllIIlIIIllI) {
        this.field_178550_e = lllllllllllllIlllllllllIIlIIIllI;
    }
    
    public enum Status
    {
        DONE("DONE", 3, "DONE", 3, "DONE", 3), 
        PENDING("PENDING", 0, "PENDING", 0, "PENDING", 0), 
        UPLOADING("UPLOADING", 2, "UPLOADING", 2, "UPLOADING", 2), 
        COMPILING("COMPILING", 1, "COMPILING", 1, "COMPILING", 1);
        
        private Status(final String llllllllllllllIIlllIlllllIIIIIII, final int llllllllllllllIIlllIllllIlllllll, final String llllllllllllllIIlllIlllllIIIIlIl, final int llllllllllllllIIlllIlllllIIIIlII, final String llllllllllllllIIlllIlllllIIIIIll, final int llllllllllllllIIlllIlllllIIIIIlI) {
        }
        
        static {
            __OBFID = "CL_00002465";
        }
    }
    
    public enum Type
    {
        RESORT_TRANSPARENCY("RESORT_TRANSPARENCY", 1, "RESORT_TRANSPARENCY", 1, "RESORT_TRANSPARENCY", 1), 
        REBUILD_CHUNK("REBUILD_CHUNK", 0, "REBUILD_CHUNK", 0, "REBUILD_CHUNK", 0);
        
        private Type(final String lllllllllllllllIIIIlIIllIIllIllI, final int lllllllllllllllIIIIlIIllIIllIlII, final String lllllllllllllllIIIIlIIllIIllllIl, final int lllllllllllllllIIIIlIIllIIllllII, final String lllllllllllllllIIIIlIIllIIlllIll, final int lllllllllllllllIIIIlIIllIIlllIIl) {
        }
        
        static {
            __OBFID = "CL_00002464";
        }
    }
}
