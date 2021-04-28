package net.minecraft.client.renderer.chunk;

import java.util.concurrent.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.renderer.vertex.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import com.google.common.util.concurrent.*;
import java.util.*;

public class ChunkRenderDispatcher
{
    private final /* synthetic */ VertexBufferUploader field_178518_g;
    private final /* synthetic */ BlockingQueue field_178519_d;
    private final /* synthetic */ Queue field_178524_h;
    private final /* synthetic */ ChunkRenderWorker field_178525_i;
    private final /* synthetic */ BlockingQueue field_178520_e;
    private final /* synthetic */ WorldVertexBufferUploader field_178517_f;
    private final /* synthetic */ List field_178522_c;
    private static final /* synthetic */ ThreadFactory field_178521_b;
    
    public boolean func_178507_a(final RenderChunk llllllllllllllIlIIIIlIIlIlllIlll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178579_c:()Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_1         /* llllllllllllllIlIIIIlIIlIlllllIl */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178574_d:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: astore_3        /* llllllllllllllIlIIIIlIIlIlllIlIl */
        //    12: aload_3         /* llllllllllllllIlIIIIlIIlIllllIlI */
        //    13: new             Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher$1;
        //    16: dup            
        //    17: aload_0         /* llllllllllllllIlIIIIlIIlIllllllI */
        //    18: aload_3         /* llllllllllllllIlIIIIlIIlIllllIlI */
        //    19: invokespecial   net/minecraft/client/renderer/chunk/ChunkRenderDispatcher$1.<init>:(Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;)V
        //    22: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178539_a:(Ljava/lang/Runnable;)V
        //    25: aload_0         /* llllllllllllllIlIIIIlIIlIllllllI */
        //    26: getfield        net/minecraft/client/renderer/chunk/ChunkRenderDispatcher.field_178519_d:Ljava/util/concurrent/BlockingQueue;
        //    29: aload_3         /* llllllllllllllIlIIIIlIIlIllllIlI */
        //    30: invokeinterface java/util/concurrent/BlockingQueue.offer:(Ljava/lang/Object;)Z
        //    35: istore          llllllllllllllIlIIIIlIIlIllllIIl
        //    37: iload           llllllllllllllIlIIIIlIIlIllllIIl
        //    39: ifne            46
        //    42: aload_3         /* llllllllllllllIlIIIIlIIlIllllIlI */
        //    43: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178542_e:()V
        //    46: iload           llllllllllllllIlIIIIlIIlIllllIIl
        //    48: istore_2        /* llllllllllllllIlIIIIlIIlIlllllII */
        //    49: goto            64
        //    52: astore          llllllllllllllIlIIIIlIIlIlllIIll
        //    54: aload_1         /* llllllllllllllIlIIIIlIIlIlllllIl */
        //    55: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178579_c:()Ljava/util/concurrent/locks/ReentrantLock;
        //    58: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    61: aload           llllllllllllllIlIIIIlIIlIlllIIll
        //    63: athrow         
        //    64: aload_1         /* llllllllllllllIlIIIIlIIlIlllllIl */
        //    65: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178579_c:()Ljava/util/concurrent/locks/ReentrantLock;
        //    68: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    71: iload_2         /* llllllllllllllIlIIIIlIIlIllllIll */
        //    72: ireturn        
        //    StackMapTable: 00 03 FE 00 2E 00 07 00 35 01 FF 00 05 00 02 07 00 02 07 00 21 00 01 07 00 5B FE 00 0B 01 07 00 35 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      52     52     64     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public ChunkCompileTaskGenerator func_178511_d() throws InterruptedException {
        return this.field_178519_d.take();
    }
    
    public ChunkRenderDispatcher() {
        this.field_178522_c = Lists.newArrayList();
        this.field_178519_d = Queues.newArrayBlockingQueue(100);
        this.field_178520_e = Queues.newArrayBlockingQueue(5);
        this.field_178517_f = new WorldVertexBufferUploader();
        this.field_178518_g = new VertexBufferUploader();
        this.field_178524_h = Queues.newArrayDeque();
        for (int llllllllllllllIlIIIIlIIllIlIIlIl = 0; llllllllllllllIlIIIIlIIllIlIIlIl < 2; ++llllllllllllllIlIIIIlIIllIlIIlIl) {
            final ChunkRenderWorker llllllllllllllIlIIIIlIIllIlIIlII = new ChunkRenderWorker(this);
            final Thread llllllllllllllIlIIIIlIIllIlIIIll = ChunkRenderDispatcher.field_178521_b.newThread(llllllllllllllIlIIIIlIIllIlIIlII);
            llllllllllllllIlIIIIlIIllIlIIIll.start();
            this.field_178522_c.add(llllllllllllllIlIIIIlIIllIlIIlII);
        }
        for (int llllllllllllllIlIIIIlIIllIlIIlIl = 0; llllllllllllllIlIIIIlIIllIlIIlIl < 5; ++llllllllllllllIlIIIIlIIllIlIIlIl) {
            this.field_178520_e.add(new RegionRenderCacheBuilder());
        }
        this.field_178525_i = new ChunkRenderWorker(this, new RegionRenderCacheBuilder());
    }
    
    static {
        __OBFID = "CL_00002463";
        field_178523_a = LogManager.getLogger();
        field_178521_b = new ThreadFactoryBuilder().setNameFormat("Chunk Batcher %d").setDaemon(true).build();
    }
    
    public boolean func_178509_c(final RenderChunk llllllllllllllIlIIIIlIIlIIlllllI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178579_c:()Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_1         /* llllllllllllllIlIIIIlIIlIlIIIlIl */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178582_e:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: astore_3        /* llllllllllllllIlIIIIlIIlIlIIIIlI */
        //    12: aload_3         /* llllllllllllllIlIIIIlIIlIlIIIIlI */
        //    13: ifnonnull       33
        //    16: iconst_1       
        //    17: istore          llllllllllllllIlIIIIlIIlIlIIIIIl
        //    19: iload           llllllllllllllIlIIIIlIIlIlIIIIIl
        //    21: istore          llllllllllllllIlIIIIlIIlIIlllIIl
        //    23: aload_1         /* llllllllllllllIlIIIIlIIlIlIIIlIl */
        //    24: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178579_c:()Ljava/util/concurrent/locks/ReentrantLock;
        //    27: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    30: iload           llllllllllllllIlIIIIlIIlIIlllIIl
        //    32: ireturn        
        //    33: aload_3         /* llllllllllllllIlIIIIlIIlIlIIIIlI */
        //    34: new             Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher$2;
        //    37: dup            
        //    38: aload_0         /* llllllllllllllIlIIIIlIIlIlIIIllI */
        //    39: aload_3         /* llllllllllllllIlIIIIlIIlIlIIIIlI */
        //    40: invokespecial   net/minecraft/client/renderer/chunk/ChunkRenderDispatcher$2.<init>:(Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;)V
        //    43: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178539_a:(Ljava/lang/Runnable;)V
        //    46: aload_0         /* llllllllllllllIlIIIIlIIlIlIIIllI */
        //    47: getfield        net/minecraft/client/renderer/chunk/ChunkRenderDispatcher.field_178519_d:Ljava/util/concurrent/BlockingQueue;
        //    50: aload_3         /* llllllllllllllIlIIIIlIIlIlIIIIlI */
        //    51: invokeinterface java/util/concurrent/BlockingQueue.offer:(Ljava/lang/Object;)Z
        //    56: istore          llllllllllllllIlIIIIlIIlIlIIIIII
        //    58: iload           llllllllllllllIlIIIIlIIlIlIIIIII
        //    60: istore_2        /* llllllllllllllIlIIIIlIIlIlIIIlII */
        //    61: goto            76
        //    64: astore          llllllllllllllIlIIIIlIIlIIlllIlI
        //    66: aload_1         /* llllllllllllllIlIIIIlIIlIlIIIlIl */
        //    67: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178579_c:()Ljava/util/concurrent/locks/ReentrantLock;
        //    70: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    73: aload           llllllllllllllIlIIIIlIIlIIlllIlI
        //    75: athrow         
        //    76: aload_1         /* llllllllllllllIlIIIIlIIlIlIIIlIl */
        //    77: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178579_c:()Ljava/util/concurrent/locks/ReentrantLock;
        //    80: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    83: iload_2         /* llllllllllllllIlIIIIlIIlIlIIIIll */
        //    84: ireturn        
        //    StackMapTable: 00 03 FD 00 21 00 07 00 35 FF 00 1E 00 02 07 00 02 07 00 21 00 01 07 00 5B FE 00 0B 01 07 00 35 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      23     64     76     Any
        //  33     64     64     76     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void func_178512_a(final RegionRenderCacheBuilder llllllllllllllIlIIIIlIIlIlIlIllI) {
        this.field_178520_e.add(llllllllllllllIlIIIIlIIlIlIlIllI);
    }
    
    private void func_178506_a(final WorldRenderer llllllllllllllIlIIIIlIIlIIIIlllI, final VertexBuffer llllllllllllllIlIIIIlIIlIIIIlIlI) {
        this.field_178518_g.func_178178_a(llllllllllllllIlIIIIlIIlIIIIlIlI);
        this.field_178518_g.draw(llllllllllllllIlIIIIlIIlIIIIlllI, llllllllllllllIlIIIIlIIlIIIIlllI.func_178976_e());
    }
    
    public void func_178513_e() {
        while (!this.field_178519_d.isEmpty()) {
            final ChunkCompileTaskGenerator llllllllllllllIlIIIIlIIlIIIIIllI = (ChunkCompileTaskGenerator)this.field_178519_d.poll();
            if (llllllllllllllIlIIIIlIIlIIIIIllI != null) {
                llllllllllllllIlIIIIlIIlIIIIIllI.func_178542_e();
            }
        }
    }
    
    public boolean func_178505_b(final RenderChunk llllllllllllllIlIIIIlIIlIllIIllI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178579_c:()Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_1         /* llllllllllllllIlIIIIlIIlIllIlIll */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178574_d:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: astore_3        /* llllllllllllllIlIIIIlIIlIllIlIII */
        //    12: aload_0         /* llllllllllllllIlIIIIlIIlIllIllII */
        //    13: getfield        net/minecraft/client/renderer/chunk/ChunkRenderDispatcher.field_178525_i:Lnet/minecraft/client/renderer/chunk/ChunkRenderWorker;
        //    16: aload_3         /* llllllllllllllIlIIIIlIIlIllIlIII */
        //    17: invokevirtual   net/minecraft/client/renderer/chunk/ChunkRenderWorker.func_178474_a:(Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;)V
        //    20: goto            25
        //    23: astore          llllllllllllllIlIIIIlIIlIllIIIll
        //    25: iconst_1       
        //    26: istore_2        /* llllllllllllllIlIIIIlIIlIllIIlIl */
        //    27: goto            42
        //    30: astore          llllllllllllllIlIIIIlIIlIllIIIlI
        //    32: aload_1         /* llllllllllllllIlIIIIlIIlIllIlIll */
        //    33: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178579_c:()Ljava/util/concurrent/locks/ReentrantLock;
        //    36: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    39: aload           llllllllllllllIlIIIIlIIlIllIIIlI
        //    41: athrow         
        //    42: aload_1         /* llllllllllllllIlIIIIlIIlIllIlIll */
        //    43: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178579_c:()Ljava/util/concurrent/locks/ReentrantLock;
        //    46: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    49: iload_2         /* llllllllllllllIlIIIIlIIlIllIlIIl */
        //    50: ireturn        
        //    StackMapTable: 00 04 FF 00 17 00 04 07 00 02 07 00 21 00 07 00 35 00 01 07 00 5E 01 FF 00 04 00 02 07 00 02 07 00 21 00 01 07 00 5B FD 00 0B 01 07 00 35
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  12     20     23     25     Ljava/lang/InterruptedException;
        //  7      30     30     42     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean func_178516_a(final long llllllllllllllIlIIIIlIIllIIIlIll) {
        boolean llllllllllllllIlIIIIlIIllIIlIIIl = false;
        long llllllllllllllIlIIIIlIIllIIlIIII;
        do {
            boolean llllllllllllllIlIIIIlIIllIIIllll = false;
            final Queue llllllllllllllIlIIIIlIIllIIIlllI = this.field_178524_h;
            final Queue llllllllllllllIlIIIIlIIllIIIllIl = this.field_178524_h;
            synchronized (this.field_178524_h) {
                if (!this.field_178524_h.isEmpty()) {
                    this.field_178524_h.poll().run();
                    llllllllllllllIlIIIIlIIllIIIllll = true;
                    llllllllllllllIlIIIIlIIllIIlIIIl = true;
                }
            }
            // monitorexit(this.field_178524_h)
            if (llllllllllllllIlIIIIlIIllIIIlIll == 0L) {
                break;
            }
            if (!llllllllllllllIlIIIIlIIllIIIllll) {
                break;
            }
            llllllllllllllIlIIIIlIIllIIlIIII = llllllllllllllIlIIIIlIIllIIIlIll - System.nanoTime();
        } while (llllllllllllllIlIIIIlIIllIIlIIII >= 0L && llllllllllllllIlIIIIlIIllIIlIIII <= 1000000000L);
        return llllllllllllllIlIIIIlIIllIIlIIIl;
    }
    
    private void func_178510_a(final WorldRenderer llllllllllllllIlIIIIlIIlIIIllIIl, final int llllllllllllllIlIIIIlIIlIIIlIlII, final RenderChunk llllllllllllllIlIIIIlIIlIIIlIlll) {
        GL11.glNewList(llllllllllllllIlIIIIlIIlIIIlIlII, 4864);
        GlStateManager.pushMatrix();
        llllllllllllllIlIIIIlIIlIIIlIlll.func_178572_f();
        this.field_178517_f.draw(llllllllllllllIlIIIIlIIlIIIllIIl, llllllllllllllIlIIIIlIIlIIIllIIl.func_178976_e());
        GlStateManager.popMatrix();
        GL11.glEndList();
    }
    
    public String func_178504_a() {
        return String.format("pC: %03d, pU: %1d, aB: %1d", this.field_178519_d.size(), this.field_178524_h.size(), this.field_178520_e.size());
    }
    
    public ListenableFuture func_178503_a(final EnumWorldBlockLayer llllllllllllllIlIIIIlIIlIIlIIllI, final WorldRenderer llllllllllllllIlIIIIlIIlIIlIIlIl, final RenderChunk llllllllllllllIlIIIIlIIlIIlIllII, final CompiledChunk llllllllllllllIlIIIIlIIlIIlIIIll) {
        if (Minecraft.getMinecraft().isCallingFromMinecraftThread()) {
            if (OpenGlHelper.func_176075_f()) {
                this.func_178506_a(llllllllllllllIlIIIIlIIlIIlIIlIl, llllllllllllllIlIIIIlIIlIIlIllII.func_178565_b(llllllllllllllIlIIIIlIIlIIlIIllI.ordinal()));
            }
            else {
                this.func_178510_a(llllllllllllllIlIIIIlIIlIIlIIlIl, ((ListedRenderChunk)llllllllllllllIlIIIIlIIlIIlIllII).func_178600_a(llllllllllllllIlIIIIlIIlIIlIIllI, llllllllllllllIlIIIIlIIlIIlIIIll), llllllllllllllIlIIIIlIIlIIlIllII);
            }
            llllllllllllllIlIIIIlIIlIIlIIlIl.setTranslation(0.0, 0.0, 0.0);
            return Futures.immediateFuture((Object)null);
        }
        final ListenableFutureTask llllllllllllllIlIIIIlIIlIIlIlIlI = ListenableFutureTask.create((Runnable)new Runnable() {
            static {
                __OBFID = "CL_00002460";
            }
            
            @Override
            public void run() {
                ChunkRenderDispatcher.this.func_178503_a(llllllllllllllIlIIIIlIIlIIlIIllI, llllllllllllllIlIIIIlIIlIIlIIlIl, llllllllllllllIlIIIIlIIlIIlIllII, llllllllllllllIlIIIIlIIlIIlIIIll);
            }
        }, (Object)null);
        final Queue llllllllllllllIlIIIIlIIlIIlIlIIl = this.field_178524_h;
        final Queue llllllllllllllIlIIIIlIIlIIlIlIII = this.field_178524_h;
        synchronized (this.field_178524_h) {
            this.field_178524_h.add(llllllllllllllIlIIIIlIIlIIlIlIlI);
            final ListenableFutureTask listenableFutureTask = llllllllllllllIlIIIIlIIlIIlIlIlI;
            // monitorexit(this.field_178524_h)
            return (ListenableFuture)listenableFutureTask;
        }
    }
    
    public RegionRenderCacheBuilder func_178515_c() throws InterruptedException {
        return this.field_178520_e.take();
    }
    
    public void func_178514_b() {
        this.func_178513_e();
        while (this.func_178516_a(0L)) {}
        final ArrayList llllllllllllllIlIIIIlIIlIlIlllIl = Lists.newArrayList();
        while (llllllllllllllIlIIIIlIIlIlIlllIl.size() != 5) {
            try {
                llllllllllllllIlIIIIlIIlIlIlllIl.add(this.func_178515_c());
            }
            catch (InterruptedException ex) {}
        }
        this.field_178520_e.addAll(llllllllllllllIlIIIIlIIlIlIlllIl);
    }
}
