package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.profiler.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;

public class Lagometer
{
    private static /* synthetic */ long[] timesServer;
    private static /* synthetic */ long memDiff;
    private static /* synthetic */ long[] timesChunkUpdate;
    private static /* synthetic */ long prevFrameTimeNano;
    private static /* synthetic */ long[] timesVisibility;
    private static /* synthetic */ long[] timesChunkUpload;
    public static /* synthetic */ TimerNano timerVisibility;
    private static /* synthetic */ long memLast;
    public static /* synthetic */ TimerNano timerScheduledExecutables;
    private static /* synthetic */ int memMbSec;
    private static /* synthetic */ int numRecordedFrameTimes;
    public static /* synthetic */ TimerNano timerTick;
    public static /* synthetic */ TimerNano timerServer;
    public static /* synthetic */ TimerNano timerTerrain;
    private static /* synthetic */ long memTimeStartMs;
    private static /* synthetic */ GameSettings gameSettings;
    public static /* synthetic */ TimerNano timerChunkUpload;
    private static /* synthetic */ long memTimeDiffMs;
    private static /* synthetic */ long[] timesTick;
    public static /* synthetic */ boolean active;
    public static /* synthetic */ TimerNano timerChunkUpdate;
    private static /* synthetic */ long[] timesFrame;
    private static /* synthetic */ long memTimeLast;
    private static /* synthetic */ boolean[] gcs;
    private static /* synthetic */ Profiler profiler;
    private static /* synthetic */ long memStart;
    private static /* synthetic */ long renderTimeNano;
    private static /* synthetic */ Minecraft mc;
    private static /* synthetic */ long[] timesScheduledExecutables;
    private static /* synthetic */ long[] timesTerrain;
    
    private static long getMemoryUsed() {
        final Runtime llllllllllllllIIlIllIlIlIlllIIIl = Runtime.getRuntime();
        return llllllllllllllIIlIllIlIlIlllIIIl.totalMemory() - llllllllllllllIIlIllIlIlIlllIIIl.freeMemory();
    }
    
    public static void updateLagometer() {
        if (Lagometer.mc == null) {
            Lagometer.mc = Minecraft.getMinecraft();
            Lagometer.gameSettings = Lagometer.mc.gameSettings;
            Lagometer.profiler = Lagometer.mc.mcProfiler;
        }
        if (Lagometer.gameSettings.showDebugInfo && Lagometer.gameSettings.ofLagometer) {
            Lagometer.active = true;
            final long llllllllllllllIIlIllIlIlIllIllII = System.nanoTime();
            if (Lagometer.prevFrameTimeNano == -1L) {
                Lagometer.prevFrameTimeNano = llllllllllllllIIlIllIlIlIllIllII;
            }
            else {
                final int llllllllllllllIIlIllIlIlIllIlIll = Lagometer.numRecordedFrameTimes & Lagometer.timesFrame.length - 1;
                ++Lagometer.numRecordedFrameTimes;
                final boolean llllllllllllllIIlIllIlIlIllIlIlI = updateMemoryAllocation();
                Lagometer.timesFrame[llllllllllllllIIlIllIlIlIllIlIll] = llllllllllllllIIlIllIlIlIllIllII - Lagometer.prevFrameTimeNano - Lagometer.renderTimeNano;
                Lagometer.timesTick[llllllllllllllIIlIllIlIlIllIlIll] = Lagometer.timerTick.timeNano;
                Lagometer.timesScheduledExecutables[llllllllllllllIIlIllIlIlIllIlIll] = Lagometer.timerScheduledExecutables.timeNano;
                Lagometer.timesChunkUpload[llllllllllllllIIlIllIlIlIllIlIll] = Lagometer.timerChunkUpload.timeNano;
                Lagometer.timesChunkUpdate[llllllllllllllIIlIllIlIlIllIlIll] = Lagometer.timerChunkUpdate.timeNano;
                Lagometer.timesVisibility[llllllllllllllIIlIllIlIlIllIlIll] = Lagometer.timerVisibility.timeNano;
                Lagometer.timesTerrain[llllllllllllllIIlIllIlIlIllIlIll] = Lagometer.timerTerrain.timeNano;
                Lagometer.timesServer[llllllllllllllIIlIllIlIlIllIlIll] = Lagometer.timerServer.timeNano;
                Lagometer.gcs[llllllllllllllIIlIllIlIlIllIlIll] = llllllllllllllIIlIllIlIlIllIlIlI;
                Lagometer.timerTick.reset();
                Lagometer.timerScheduledExecutables.reset();
                Lagometer.timerVisibility.reset();
                Lagometer.timerChunkUpdate.reset();
                Lagometer.timerChunkUpload.reset();
                Lagometer.timerTerrain.reset();
                Lagometer.timerServer.reset();
                Lagometer.prevFrameTimeNano = System.nanoTime();
            }
        }
        else {
            Lagometer.active = false;
            Lagometer.prevFrameTimeNano = -1L;
        }
    }
    
    public static boolean updateMemoryAllocation() {
        final long llllllllllllllIIlIllIlIlIllllllI = System.currentTimeMillis();
        final long llllllllllllllIIlIllIlIlIlllllIl = getMemoryUsed();
        boolean llllllllllllllIIlIllIlIlIlllllII = false;
        if (llllllllllllllIIlIllIlIlIlllllIl < Lagometer.memLast) {
            final double llllllllllllllIIlIllIlIlIllllIll = Lagometer.memDiff / 1000000.0;
            final double llllllllllllllIIlIllIlIlIllllIlI = Lagometer.memTimeDiffMs / 1000.0;
            final int llllllllllllllIIlIllIlIlIllllIIl = (int)(llllllllllllllIIlIllIlIlIllllIll / llllllllllllllIIlIllIlIlIllllIlI);
            if (llllllllllllllIIlIllIlIlIllllIIl > 0) {
                Lagometer.memMbSec = llllllllllllllIIlIllIlIlIllllIIl;
            }
            Lagometer.memTimeStartMs = llllllllllllllIIlIllIlIlIllllllI;
            Lagometer.memStart = llllllllllllllIIlIllIlIlIlllllIl;
            Lagometer.memTimeDiffMs = 0L;
            Lagometer.memDiff = 0L;
            llllllllllllllIIlIllIlIlIlllllII = true;
        }
        else {
            Lagometer.memTimeDiffMs = llllllllllllllIIlIllIlIlIllllllI - Lagometer.memTimeStartMs;
            Lagometer.memDiff = llllllllllllllIIlIllIlIlIlllllIl - Lagometer.memStart;
        }
        Lagometer.memTimeLast = llllllllllllllIIlIllIlIlIllllllI;
        Lagometer.memLast = llllllllllllllIIlIllIlIlIlllllIl;
        return llllllllllllllIIlIllIlIlIlllllII;
    }
    
    private static long renderTime(final int llllllllllllllIIlIllIlIlIIlIlIIl, final long llllllllllllllIIlIllIlIlIIllIIII, final int llllllllllllllIIlIllIlIlIIlIIlll, final int llllllllllllllIIlIllIlIlIIlIIllI, final int llllllllllllllIIlIllIlIlIIlIIlIl, final float llllllllllllllIIlIllIlIlIIlIIlII, final WorldRenderer llllllllllllllIIlIllIlIlIIlIIIll) {
        final long llllllllllllllIIlIllIlIlIIlIlIlI = llllllllllllllIIlIllIlIlIIllIIII / 200000L;
        if (llllllllllllllIIlIllIlIlIIlIlIlI < 3L) {
            return 0L;
        }
        llllllllllllllIIlIllIlIlIIlIIIll.func_178961_b(llllllllllllllIIlIllIlIlIIlIIlll, llllllllllllllIIlIllIlIlIIlIIllI, llllllllllllllIIlIllIlIlIIlIIlIl, 255);
        llllllllllllllIIlIllIlIlIIlIIIll.addVertex(llllllllllllllIIlIllIlIlIIlIlIIl + 0.5f, llllllllllllllIIlIllIlIlIIlIIlII - llllllllllllllIIlIllIlIlIIlIlIlI + 0.5f, 0.0);
        llllllllllllllIIlIllIlIlIIlIIIll.addVertex(llllllllllllllIIlIllIlIlIIlIlIIl + 0.5f, llllllllllllllIIlIllIlIlIIlIIlII + 0.5f, 0.0);
        return llllllllllllllIIlIllIlIlIIlIlIlI;
    }
    
    private static long renderTimeDivider(final int llllllllllllllIIlIllIlIlIIIIllll, final int llllllllllllllIIlIllIlIlIIIIlllI, final long llllllllllllllIIlIllIlIlIIIIllIl, final int llllllllllllllIIlIllIlIlIIIlIlIl, final int llllllllllllllIIlIllIlIlIIIIlIll, final int llllllllllllllIIlIllIlIlIIIlIIll, final float llllllllllllllIIlIllIlIlIIIlIIlI, final WorldRenderer llllllllllllllIIlIllIlIlIIIlIIIl) {
        final long llllllllllllllIIlIllIlIlIIIlIIII = llllllllllllllIIlIllIlIlIIIIllIl / 200000L;
        if (llllllllllllllIIlIllIlIlIIIlIIII < 3L) {
            return 0L;
        }
        llllllllllllllIIlIllIlIlIIIlIIIl.func_178961_b(llllllllllllllIIlIllIlIlIIIlIlIl, llllllllllllllIIlIllIlIlIIIIlIll, llllllllllllllIIlIllIlIlIIIlIIll, 255);
        llllllllllllllIIlIllIlIlIIIlIIIl.addVertex(llllllllllllllIIlIllIlIlIIIIllll + 0.5f, llllllllllllllIIlIllIlIlIIIlIIlI - llllllllllllllIIlIllIlIlIIIlIIII + 0.5f, 0.0);
        llllllllllllllIIlIllIlIlIIIlIIIl.addVertex(llllllllllllllIIlIllIlIlIIIIlllI + 0.5f, llllllllllllllIIlIllIlIlIIIlIIlI - llllllllllllllIIlIllIlIlIIIlIIII + 0.5f, 0.0);
        return llllllllllllllIIlIllIlIlIIIlIIII;
    }
    
    public static void showLagometer(final ScaledResolution llllllllllllllIIlIllIlIlIlIllIII) {
        if (Lagometer.gameSettings != null && Lagometer.gameSettings.ofLagometer) {
            final long llllllllllllllIIlIllIlIlIlIlIlll = System.nanoTime();
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.pushMatrix();
            GlStateManager.enableColorMaterial();
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0, Lagometer.mc.displayWidth, Lagometer.mc.displayHeight, 0.0, 1000.0, 3000.0);
            GlStateManager.matrixMode(5888);
            GlStateManager.pushMatrix();
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -2000.0f);
            GL11.glLineWidth(1.0f);
            GlStateManager.func_179090_x();
            final Tessellator llllllllllllllIIlIllIlIlIlIlIllI = Tessellator.getInstance();
            final WorldRenderer llllllllllllllIIlIllIlIlIlIlIlIl = llllllllllllllIIlIllIlIlIlIlIllI.getWorldRenderer();
            llllllllllllllIIlIllIlIlIlIlIlIl.startDrawing(1);
            for (int llllllllllllllIIlIllIlIlIlIlIlII = 0; llllllllllllllIIlIllIlIlIlIlIlII < Lagometer.timesFrame.length; ++llllllllllllllIIlIllIlIlIlIlIlII) {
                int llllllllllllllIIlIllIlIlIlIlIIll = (llllllllllllllIIlIllIlIlIlIlIlII - Lagometer.numRecordedFrameTimes & Lagometer.timesFrame.length - 1) * 100 / Lagometer.timesFrame.length;
                llllllllllllllIIlIllIlIlIlIlIIll += 155;
                float llllllllllllllIIlIllIlIlIlIlIIIl = (float)Lagometer.mc.displayHeight;
                final long llllllllllllllIIlIllIlIlIlIIllll = 0L;
                if (Lagometer.gcs[llllllllllllllIIlIllIlIlIlIlIlII]) {
                    renderTime(llllllllllllllIIlIllIlIlIlIlIlII, Lagometer.timesFrame[llllllllllllllIIlIllIlIlIlIlIlII], llllllllllllllIIlIllIlIlIlIlIIll, llllllllllllllIIlIllIlIlIlIlIIll / 2, 0, llllllllllllllIIlIllIlIlIlIlIIIl, llllllllllllllIIlIllIlIlIlIlIlIl);
                }
                else {
                    renderTime(llllllllllllllIIlIllIlIlIlIlIlII, Lagometer.timesFrame[llllllllllllllIIlIllIlIlIlIlIlII], llllllllllllllIIlIllIlIlIlIlIIll, llllllllllllllIIlIllIlIlIlIlIIll, llllllllllllllIIlIllIlIlIlIlIIll, llllllllllllllIIlIllIlIlIlIlIIIl, llllllllllllllIIlIllIlIlIlIlIlIl);
                    llllllllllllllIIlIllIlIlIlIlIIIl -= renderTime(llllllllllllllIIlIllIlIlIlIlIlII, Lagometer.timesServer[llllllllllllllIIlIllIlIlIlIlIlII], llllllllllllllIIlIllIlIlIlIlIIll / 2, llllllllllllllIIlIllIlIlIlIlIIll / 2, llllllllllllllIIlIllIlIlIlIlIIll / 2, llllllllllllllIIlIllIlIlIlIlIIIl, llllllllllllllIIlIllIlIlIlIlIlIl);
                    llllllllllllllIIlIllIlIlIlIlIIIl -= renderTime(llllllllllllllIIlIllIlIlIlIlIlII, Lagometer.timesTerrain[llllllllllllllIIlIllIlIlIlIlIlII], 0, llllllllllllllIIlIllIlIlIlIlIIll, 0, llllllllllllllIIlIllIlIlIlIlIIIl, llllllllllllllIIlIllIlIlIlIlIlIl);
                    llllllllllllllIIlIllIlIlIlIlIIIl -= renderTime(llllllllllllllIIlIllIlIlIlIlIlII, Lagometer.timesVisibility[llllllllllllllIIlIllIlIlIlIlIlII], llllllllllllllIIlIllIlIlIlIlIIll, llllllllllllllIIlIllIlIlIlIlIIll, 0, llllllllllllllIIlIllIlIlIlIlIIIl, llllllllllllllIIlIllIlIlIlIlIlIl);
                    llllllllllllllIIlIllIlIlIlIlIIIl -= renderTime(llllllllllllllIIlIllIlIlIlIlIlII, Lagometer.timesChunkUpdate[llllllllllllllIIlIllIlIlIlIlIlII], llllllllllllllIIlIllIlIlIlIlIIll, 0, 0, llllllllllllllIIlIllIlIlIlIlIIIl, llllllllllllllIIlIllIlIlIlIlIlIl);
                    llllllllllllllIIlIllIlIlIlIlIIIl -= renderTime(llllllllllllllIIlIllIlIlIlIlIlII, Lagometer.timesChunkUpload[llllllllllllllIIlIllIlIlIlIlIlII], llllllllllllllIIlIllIlIlIlIlIIll, 0, llllllllllllllIIlIllIlIlIlIlIIll, llllllllllllllIIlIllIlIlIlIlIIIl, llllllllllllllIIlIllIlIlIlIlIlIl);
                    llllllllllllllIIlIllIlIlIlIlIIIl -= renderTime(llllllllllllllIIlIllIlIlIlIlIlII, Lagometer.timesScheduledExecutables[llllllllllllllIIlIllIlIlIlIlIlII], 0, 0, llllllllllllllIIlIllIlIlIlIlIIll, llllllllllllllIIlIllIlIlIlIlIIIl, llllllllllllllIIlIllIlIlIlIlIlIl);
                    final String llllllllllllllIIlIllIlIlIIlllllI = (String)(llllllllllllllIIlIllIlIlIlIlIIIl - renderTime(llllllllllllllIIlIllIlIlIlIlIlII, Lagometer.timesTick[llllllllllllllIIlIllIlIlIlIlIlII], 0, llllllllllllllIIlIllIlIlIlIlIIll, llllllllllllllIIlIllIlIlIlIlIIll, llllllllllllllIIlIllIlIlIlIlIIIl, llllllllllllllIIlIllIlIlIlIlIlIl));
                }
            }
            renderTimeDivider(0, Lagometer.timesFrame.length, 33333333L, 196, 196, 196, (float)Lagometer.mc.displayHeight, llllllllllllllIIlIllIlIlIlIlIlIl);
            renderTimeDivider(0, Lagometer.timesFrame.length, 16666666L, 196, 196, 196, (float)Lagometer.mc.displayHeight, llllllllllllllIIlIllIlIlIlIlIlIl);
            llllllllllllllIIlIllIlIlIlIlIllI.draw();
            GlStateManager.func_179098_w();
            int llllllllllllllIIlIllIlIlIlIlIlII = Lagometer.mc.displayHeight - 80;
            final int llllllllllllllIIlIllIlIlIlIlIIlI = Lagometer.mc.displayHeight - 160;
            Lagometer.mc.fontRendererObj.drawString("30", 2.0, llllllllllllllIIlIllIlIlIlIlIIlI + 1, -8947849);
            Lagometer.mc.fontRendererObj.drawString("30", 1.0, llllllllllllllIIlIllIlIlIlIlIIlI, -3881788);
            Lagometer.mc.fontRendererObj.drawString("60", 2.0, llllllllllllllIIlIllIlIlIlIlIlII + 1, -8947849);
            Lagometer.mc.fontRendererObj.drawString("60", 1.0, llllllllllllllIIlIllIlIlIlIlIlII, -3881788);
            GlStateManager.matrixMode(5889);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.func_179098_w();
            float llllllllllllllIIlIllIlIlIlIlIIII = 1.0f - (float)((System.currentTimeMillis() - Lagometer.memTimeStartMs) / 1000.0);
            llllllllllllllIIlIllIlIlIlIlIIII = Config.limit(llllllllllllllIIlIllIlIlIlIlIIII, 0.0f, 1.0f);
            final int llllllllllllllIIlIllIlIlIlIIlllI = (int)(170.0f + llllllllllllllIIlIllIlIlIlIlIIII * 85.0f);
            final int llllllllllllllIIlIllIlIlIlIIllIl = (int)(100.0f + llllllllllllllIIlIllIlIlIlIlIIII * 55.0f);
            final int llllllllllllllIIlIllIlIlIlIIllII = (int)(10.0f + llllllllllllllIIlIllIlIlIlIlIIII * 10.0f);
            final int llllllllllllllIIlIllIlIlIlIIlIll = llllllllllllllIIlIllIlIlIlIIlllI << 16 | llllllllllllllIIlIllIlIlIlIIllIl << 8 | llllllllllllllIIlIllIlIlIlIIllII;
            final int llllllllllllllIIlIllIlIlIlIIlIlI = 512 / llllllllllllllIIlIllIlIlIlIllIII.getScaleFactor() + 2;
            final int llllllllllllllIIlIllIlIlIlIIlIIl = Lagometer.mc.displayHeight / llllllllllllllIIlIllIlIlIlIllIII.getScaleFactor() - 8;
            final GuiIngame llllllllllllllIIlIllIlIlIlIIlIII = Lagometer.mc.ingameGUI;
            Gui.drawRect(llllllllllllllIIlIllIlIlIlIIlIlI - 1, llllllllllllllIIlIllIlIlIlIIlIIl - 1, llllllllllllllIIlIllIlIlIlIIlIlI + 50, llllllllllllllIIlIllIlIlIlIIlIIl + 10, -1605349296);
            Lagometer.mc.fontRendererObj.drawString(String.valueOf(new StringBuilder(" ").append(Lagometer.memMbSec).append(" MB/s")), llllllllllllllIIlIllIlIlIlIIlIlI, llllllllllllllIIlIllIlIlIlIIlIIl, llllllllllllllIIlIllIlIlIlIIlIll);
            Lagometer.renderTimeNano = System.nanoTime() - llllllllllllllIIlIllIlIlIlIlIlll;
        }
    }
    
    public static boolean isActive() {
        return Lagometer.active;
    }
    
    static {
        Lagometer.active = false;
        Lagometer.timerTick = new TimerNano();
        Lagometer.timerScheduledExecutables = new TimerNano();
        Lagometer.timerChunkUpload = new TimerNano();
        Lagometer.timerChunkUpdate = new TimerNano();
        Lagometer.timerVisibility = new TimerNano();
        Lagometer.timerTerrain = new TimerNano();
        Lagometer.timerServer = new TimerNano();
        Lagometer.timesFrame = new long[512];
        Lagometer.timesTick = new long[512];
        Lagometer.timesScheduledExecutables = new long[512];
        Lagometer.timesChunkUpload = new long[512];
        Lagometer.timesChunkUpdate = new long[512];
        Lagometer.timesVisibility = new long[512];
        Lagometer.timesTerrain = new long[512];
        Lagometer.timesServer = new long[512];
        Lagometer.gcs = new boolean[512];
        Lagometer.numRecordedFrameTimes = 0;
        Lagometer.prevFrameTimeNano = -1L;
        Lagometer.renderTimeNano = 0L;
        Lagometer.memTimeStartMs = System.currentTimeMillis();
        Lagometer.memStart = getMemoryUsed();
        Lagometer.memTimeLast = Lagometer.memTimeStartMs;
        Lagometer.memLast = Lagometer.memStart;
        Lagometer.memTimeDiffMs = 1L;
        Lagometer.memDiff = 0L;
        Lagometer.memMbSec = 0;
    }
    
    public static class TimerNano
    {
        public /* synthetic */ long timeStartNano;
        public /* synthetic */ long timeNano;
        
        public void end() {
            if (Lagometer.active && this.timeStartNano != 0L) {
                this.timeNano += System.nanoTime() - this.timeStartNano;
                this.timeStartNano = 0L;
            }
        }
        
        public TimerNano() {
            this.timeStartNano = 0L;
            this.timeNano = 0L;
        }
        
        public void start() {
            if (Lagometer.active && this.timeStartNano == 0L) {
                this.timeStartNano = System.nanoTime();
            }
        }
        
        private void reset() {
            this.timeNano = 0L;
            this.timeStartNano = 0L;
        }
    }
}
