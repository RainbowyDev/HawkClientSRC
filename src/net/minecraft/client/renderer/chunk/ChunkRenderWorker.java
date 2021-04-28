package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import com.google.common.util.concurrent.*;
import java.util.concurrent.*;
import net.minecraft.crash.*;
import net.minecraft.entity.*;
import java.util.*;

public class ChunkRenderWorker implements Runnable
{
    private final /* synthetic */ RegionRenderCacheBuilder field_178478_c;
    private final /* synthetic */ ChunkRenderDispatcher field_178477_b;
    private static final /* synthetic */ Logger LOGGER;
    
    public ChunkRenderWorker(final ChunkRenderDispatcher lllllllllllllllIIllllIIIlIlIlllI) {
        this(lllllllllllllllIIllllIIIlIlIlllI, null);
    }
    
    public ChunkRenderWorker(final ChunkRenderDispatcher lllllllllllllllIIllllIIIlIlIIlII, final RegionRenderCacheBuilder lllllllllllllllIIllllIIIlIlIIllI) {
        this.field_178477_b = lllllllllllllllIIllllIIIlIlIIlII;
        this.field_178478_c = lllllllllllllllIIllllIIIlIlIIllI;
    }
    
    static {
        __OBFID = "CL_00002459";
        LOGGER = LogManager.getLogger();
    }
    
    protected void func_178474_a(final ChunkCompileTaskGenerator lllllllllllllllIIllllIIIIlllllII) throws InterruptedException {
        lllllllllllllllIIllllIIIIlllllII.func_178540_f().lock();
        Label_0094: {
            try {
                if (lllllllllllllllIIllllIIIIlllllII.func_178546_a() == ChunkCompileTaskGenerator.Status.PENDING) {
                    lllllllllllllllIIllllIIIIlllllII.func_178535_a(ChunkCompileTaskGenerator.Status.COMPILING);
                    break Label_0094;
                }
                if (!lllllllllllllllIIllllIIIIlllllII.func_178537_h()) {
                    ChunkRenderWorker.LOGGER.warn(String.valueOf(new StringBuilder("Chunk render task was ").append(lllllllllllllllIIllllIIIIlllllII.func_178546_a()).append(" when I expected it to be pending; ignoring task")));
                }
            }
            finally {
                lllllllllllllllIIllllIIIIlllllII.func_178540_f().unlock();
            }
            lllllllllllllllIIllllIIIIlllllII.func_178540_f().unlock();
            return;
        }
        final Entity lllllllllllllllIIllllIIIlIIIlIIl = Minecraft.getMinecraft().func_175606_aa();
        if (lllllllllllllllIIllllIIIlIIIlIIl == null) {
            lllllllllllllllIIllllIIIIlllllII.func_178542_e();
        }
        else {
            lllllllllllllllIIllllIIIIlllllII.func_178541_a(this.func_178475_b());
            final float lllllllllllllllIIllllIIIlIIIlIII = (float)lllllllllllllllIIllllIIIlIIIlIIl.posX;
            final float lllllllllllllllIIllllIIIlIIIIlll = (float)lllllllllllllllIIllllIIIlIIIlIIl.posY + lllllllllllllllIIllllIIIlIIIlIIl.getEyeHeight();
            final float lllllllllllllllIIllllIIIlIIIIllI = (float)lllllllllllllllIIllllIIIlIIIlIIl.posZ;
            final ChunkCompileTaskGenerator.Type lllllllllllllllIIllllIIIlIIIIlIl = lllllllllllllllIIllllIIIIlllllII.func_178538_g();
            if (lllllllllllllllIIllllIIIlIIIIlIl == ChunkCompileTaskGenerator.Type.REBUILD_CHUNK) {
                lllllllllllllllIIllllIIIIlllllII.func_178536_b().func_178581_b(lllllllllllllllIIllllIIIlIIIlIII, lllllllllllllllIIllllIIIlIIIIlll, lllllllllllllllIIllllIIIlIIIIllI, lllllllllllllllIIllllIIIIlllllII);
            }
            else if (lllllllllllllllIIllllIIIlIIIIlIl == ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY) {
                lllllllllllllllIIllllIIIIlllllII.func_178536_b().func_178570_a(lllllllllllllllIIllllIIIlIIIlIII, lllllllllllllllIIllllIIIlIIIIlll, lllllllllllllllIIllllIIIlIIIIllI, lllllllllllllllIIllllIIIIlllllII);
            }
            lllllllllllllllIIllllIIIIlllllII.func_178540_f().lock();
            try {
                if (lllllllllllllllIIllllIIIIlllllII.func_178546_a() != ChunkCompileTaskGenerator.Status.COMPILING) {
                    if (!lllllllllllllllIIllllIIIIlllllII.func_178537_h()) {
                        ChunkRenderWorker.LOGGER.warn(String.valueOf(new StringBuilder("Chunk render task was ").append(lllllllllllllllIIllllIIIIlllllII.func_178546_a()).append(" when I expected it to be compiling; aborting task")));
                    }
                    this.func_178473_b(lllllllllllllllIIllllIIIIlllllII);
                    return;
                }
                lllllllllllllllIIllllIIIIlllllII.func_178535_a(ChunkCompileTaskGenerator.Status.UPLOADING);
            }
            finally {
                lllllllllllllllIIllllIIIIlllllII.func_178540_f().unlock();
            }
            lllllllllllllllIIllllIIIIlllllII.func_178540_f().unlock();
            final CompiledChunk lllllllllllllllIIllllIIIlIIIIlII = lllllllllllllllIIllllIIIIlllllII.func_178544_c();
            final ArrayList lllllllllllllllIIllllIIIlIIIIIll = Lists.newArrayList();
            if (lllllllllllllllIIllllIIIlIIIIlIl == ChunkCompileTaskGenerator.Type.REBUILD_CHUNK) {
                for (final EnumWorldBlockLayer lllllllllllllllIIllllIIIIlllllll : EnumWorldBlockLayer.values()) {
                    if (lllllllllllllllIIllllIIIlIIIIlII.func_178492_d(lllllllllllllllIIllllIIIIlllllll)) {
                        lllllllllllllllIIllllIIIlIIIIIll.add(this.field_178477_b.func_178503_a(lllllllllllllllIIllllIIIIlllllll, lllllllllllllllIIllllIIIIlllllII.func_178545_d().func_179038_a(lllllllllllllllIIllllIIIIlllllll), lllllllllllllllIIllllIIIIlllllII.func_178536_b(), lllllllllllllllIIllllIIIlIIIIlII));
                    }
                }
            }
            else if (lllllllllllllllIIllllIIIlIIIIlIl == ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY) {
                lllllllllllllllIIllllIIIlIIIIIll.add(this.field_178477_b.func_178503_a(EnumWorldBlockLayer.TRANSLUCENT, lllllllllllllllIIllllIIIIlllllII.func_178545_d().func_179038_a(EnumWorldBlockLayer.TRANSLUCENT), lllllllllllllllIIllllIIIIlllllII.func_178536_b(), lllllllllllllllIIllllIIIlIIIIlII));
            }
            final ListenableFuture lllllllllllllllIIllllIIIIllllllI = Futures.allAsList((Iterable)lllllllllllllllIIllllIIIlIIIIIll);
            lllllllllllllllIIllllIIIIlllllII.func_178539_a(new Runnable() {
                @Override
                public void run() {
                    lllllllllllllllIIllllIIIIllllllI.cancel(false);
                }
                
                static {
                    __OBFID = "CL_00002458";
                }
            });
            Futures.addCallback(lllllllllllllllIIllllIIIIllllllI, (FutureCallback)new FutureCallback() {
                public void func_178481_a(final List lllIIIIIlIIIll) {
                    ChunkRenderWorker.this.func_178473_b(lllllllllllllllIIllllIIIIlllllII);
                    lllllllllllllllIIllllIIIIlllllII.func_178540_f().lock();
                    try {
                        if (lllllllllllllllIIllllIIIIlllllII.func_178546_a() != ChunkCompileTaskGenerator.Status.UPLOADING) {
                            if (!lllllllllllllllIIllllIIIIlllllII.func_178537_h()) {
                                ChunkRenderWorker.LOGGER.warn(String.valueOf(new StringBuilder("Chunk render task was ").append(lllllllllllllllIIllllIIIIlllllII.func_178546_a()).append(" when I expected it to be uploading; aborting task")));
                            }
                            return;
                        }
                        lllllllllllllllIIllllIIIIlllllII.func_178535_a(ChunkCompileTaskGenerator.Status.DONE);
                    }
                    finally {
                        lllllllllllllllIIllllIIIIlllllII.func_178540_f().unlock();
                    }
                    lllllllllllllllIIllllIIIIlllllII.func_178540_f().unlock();
                    lllllllllllllllIIllllIIIIlllllII.func_178536_b().func_178580_a(lllllllllllllllIIllllIIIlIIIIlII);
                }
                
                public void onFailure(final Throwable lllIIIIIIlllIl) {
                    ChunkRenderWorker.this.func_178473_b(lllllllllllllllIIllllIIIIlllllII);
                    if (!(lllIIIIIIlllIl instanceof CancellationException) && !(lllIIIIIIlllIl instanceof InterruptedException)) {
                        Minecraft.getMinecraft().crashed(CrashReport.makeCrashReport(lllIIIIIIlllIl, "Rendering chunk"));
                    }
                }
                
                public void onSuccess(final Object lllIIIIIIlIlIl) {
                    this.func_178481_a((List)lllIIIIIIlIlIl);
                }
                
                static {
                    __OBFID = "CL_00002457";
                }
            });
        }
    }
    
    private RegionRenderCacheBuilder func_178475_b() throws InterruptedException {
        return (this.field_178478_c != null) ? this.field_178478_c : this.field_178477_b.func_178515_c();
    }
    
    private void func_178473_b(final ChunkCompileTaskGenerator lllllllllllllllIIllllIIIIllIlIlI) {
        if (this.field_178478_c == null) {
            this.field_178477_b.func_178512_a(lllllllllllllllIIllllIIIIllIlIlI.func_178545_d());
        }
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                this.func_178474_a(this.field_178477_b.func_178511_d());
            }
        }
        catch (InterruptedException lllllllllllllllIIllllIIIlIIllllI) {
            ChunkRenderWorker.LOGGER.debug("Stopping due to interrupt");
        }
        catch (Throwable lllllllllllllllIIllllIIIlIIlllIl) {
            final CrashReport lllllllllllllllIIllllIIIlIIlllII = CrashReport.makeCrashReport(lllllllllllllllIIllllIIIlIIlllIl, "Batching chunks");
            Minecraft.getMinecraft().crashed(Minecraft.getMinecraft().addGraphicsAndWorldToCrashReport(lllllllllllllllIIllllIIIlIIlllII));
        }
    }
}
