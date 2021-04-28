package net.minecraft.util;

import net.minecraft.client.*;

public class Timer
{
    public /* synthetic */ float elapsedPartialTicks;
    private /* synthetic */ long lastSyncSysClock;
    /* synthetic */ float ticksPerSecond;
    private /* synthetic */ double lastHRTime;
    public /* synthetic */ float renderPartialTicks;
    private /* synthetic */ long lastSyncHRClock;
    public /* synthetic */ float timerSpeed;
    private /* synthetic */ long field_74285_i;
    private /* synthetic */ double timeSyncAdjustment;
    public /* synthetic */ int elapsedTicks;
    
    public void updateTimer() {
        final long llllllllllllllllllIlIIIIlllIllII = Minecraft.getSystemTime();
        final long llllllllllllllllllIlIIIIlllIlIll = llllllllllllllllllIlIIIIlllIllII - this.lastSyncSysClock;
        final long llllllllllllllllllIlIIIIlllIlIlI = System.nanoTime() / 1000000L;
        final double llllllllllllllllllIlIIIIlllIlIIl = llllllllllllllllllIlIIIIlllIlIlI / 1000.0;
        if (llllllllllllllllllIlIIIIlllIlIll <= 1000L && llllllllllllllllllIlIIIIlllIlIll >= 0L) {
            this.field_74285_i += llllllllllllllllllIlIIIIlllIlIll;
            if (this.field_74285_i > 1000L) {
                final long llllllllllllllllllIlIIIIlllIlIII = llllllllllllllllllIlIIIIlllIlIlI - this.lastSyncHRClock;
                final double llllllllllllllllllIlIIIIlllIIlll = this.field_74285_i / (double)llllllllllllllllllIlIIIIlllIlIII;
                this.timeSyncAdjustment += (llllllllllllllllllIlIIIIlllIIlll - this.timeSyncAdjustment) * 0.20000000298023224;
                this.lastSyncHRClock = llllllllllllllllllIlIIIIlllIlIlI;
                this.field_74285_i = 0L;
            }
            if (this.field_74285_i < 0L) {
                this.lastSyncHRClock = llllllllllllllllllIlIIIIlllIlIlI;
            }
        }
        else {
            this.lastHRTime = llllllllllllllllllIlIIIIlllIlIIl;
        }
        this.lastSyncSysClock = llllllllllllllllllIlIIIIlllIllII;
        double llllllllllllllllllIlIIIIlllIIllI = (llllllllllllllllllIlIIIIlllIlIIl - this.lastHRTime) * this.timeSyncAdjustment;
        this.lastHRTime = llllllllllllllllllIlIIIIlllIlIIl;
        llllllllllllllllllIlIIIIlllIIllI = MathHelper.clamp_double(llllllllllllllllllIlIIIIlllIIllI, 0.0, 1.0);
        this.elapsedPartialTicks += (float)(llllllllllllllllllIlIIIIlllIIllI * this.timerSpeed * this.ticksPerSecond);
        this.elapsedTicks = (int)this.elapsedPartialTicks;
        this.elapsedPartialTicks -= this.elapsedTicks;
        if (this.elapsedTicks > 10) {
            this.elapsedTicks = 10;
        }
        this.renderPartialTicks = this.elapsedPartialTicks;
    }
    
    static {
        __OBFID = "CL_00000658";
    }
    
    public Timer(final float llllllllllllllllllIlIIIIllllIlIl) {
        this.timerSpeed = 1.0f;
        this.timeSyncAdjustment = 1.0;
        this.ticksPerSecond = llllllllllllllllllIlIIIIllllIlIl;
        this.lastSyncSysClock = Minecraft.getSystemTime();
        this.lastSyncHRClock = System.nanoTime() / 1000000L;
    }
}
