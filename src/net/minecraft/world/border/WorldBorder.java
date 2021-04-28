package net.minecraft.world.border;

import com.google.common.collect.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class WorldBorder
{
    private /* synthetic */ double startDiameter;
    private /* synthetic */ int warningDistance;
    private /* synthetic */ int worldSize;
    private final /* synthetic */ List listeners;
    private /* synthetic */ double damageAmount;
    private /* synthetic */ double endDiameter;
    private /* synthetic */ double centerZ;
    private /* synthetic */ double centerX;
    private /* synthetic */ double damageBuffer;
    private /* synthetic */ long startTime;
    private /* synthetic */ int warningTime;
    private /* synthetic */ long endTime;
    
    public WorldBorder() {
        this.listeners = Lists.newArrayList();
        this.centerX = 0.0;
        this.centerZ = 0.0;
        this.startDiameter = 6.0E7;
        this.endDiameter = this.startDiameter;
        this.worldSize = 29999984;
        this.damageAmount = 0.2;
        this.damageBuffer = 5.0;
        this.warningTime = 15;
        this.warningDistance = 5;
    }
    
    public double getCenterZ() {
        return this.centerZ;
    }
    
    public double maxX() {
        double llllllllllllllIllIlIlllIlIIlIIII = this.getCenterX() + this.getDiameter() / 2.0;
        if (llllllllllllllIllIlIlllIlIIlIIII > this.worldSize) {
            llllllllllllllIllIlIlllIlIIlIIII = this.worldSize;
        }
        return llllllllllllllIllIlIlllIlIIlIIII;
    }
    
    public void func_177744_c(final double llllllllllllllIllIlIlllIIIIllIll) {
        this.damageAmount = llllllllllllllIllIlIlllIIIIllIll;
        for (final IBorderListener llllllllllllllIllIlIlllIIIIlllIl : this.getListeners()) {
            llllllllllllllIllIlIlllIIIIlllIl.func_177696_b(this, llllllllllllllIllIlIlllIIIIllIll);
        }
    }
    
    public void setDamageBuffer(final double llllllllllllllIllIlIlllIIIlIlllI) {
        this.damageBuffer = llllllllllllllIllIlIlllIIIlIlllI;
        for (final IBorderListener llllllllllllllIllIlIlllIIIlIllII : this.getListeners()) {
            llllllllllllllIllIlIlllIIIlIllII.func_177695_c(this, llllllllllllllIllIlIlllIIIlIlllI);
        }
    }
    
    public boolean contains(final BlockPos llllllllllllllIllIlIlllIllIIllll) {
        return llllllllllllllIllIlIlllIllIIllll.getX() + 1 > this.minX() && llllllllllllllIllIlIlllIllIIllll.getX() < this.maxX() && llllllllllllllIllIlIlllIllIIllll.getZ() + 1 > this.minZ() && llllllllllllllIllIlIlllIllIIllll.getZ() < this.maxZ();
    }
    
    public int getWarningDistance() {
        return this.warningDistance;
    }
    
    public double maxZ() {
        double llllllllllllllIllIlIlllIlIIIlIlI = this.getCenterZ() + this.getDiameter() / 2.0;
        if (llllllllllllllIllIlIlllIlIIIlIlI > this.worldSize) {
            llllllllllllllIllIlIlllIlIIIlIlI = this.worldSize;
        }
        return llllllllllllllIllIlIlllIlIIIlIlI;
    }
    
    public void setWarningTime(final int llllllllllllllIllIlIlllIIIIIlIIl) {
        this.warningTime = llllllllllllllIllIlIlllIIIIIlIIl;
        for (final IBorderListener llllllllllllllIllIlIlllIIIIIlIll : this.getListeners()) {
            llllllllllllllIllIlIlllIIIIIlIll.onWarningTimeChanged(this, llllllllllllllIllIlIlllIIIIIlIIl);
        }
    }
    
    public double minZ() {
        double llllllllllllllIllIlIlllIlIIlIllI = this.getCenterZ() - this.getDiameter() / 2.0;
        if (llllllllllllllIllIlIlllIlIIlIllI < -this.worldSize) {
            llllllllllllllIllIlIlllIlIIlIllI = -this.worldSize;
        }
        return llllllllllllllIllIlIlllIlIIlIllI;
    }
    
    public boolean contains(final AxisAlignedBB llllllllllllllIllIlIlllIllIIIIll) {
        return llllllllllllllIllIlIlllIllIIIIll.maxX > this.minX() && llllllllllllllIllIlIlllIllIIIIll.minX < this.maxX() && llllllllllllllIllIlIlllIllIIIIll.maxZ > this.minZ() && llllllllllllllIllIlIlllIllIIIIll.minZ < this.maxZ();
    }
    
    public double minX() {
        double llllllllllllllIllIlIlllIlIIlllII = this.getCenterX() - this.getDiameter() / 2.0;
        if (llllllllllllllIllIlIlllIlIIlllII < -this.worldSize) {
            llllllllllllllIllIlIlllIlIIlllII = -this.worldSize;
        }
        return llllllllllllllIllIlIlllIlIIlllII;
    }
    
    public double getClosestDistance(final double llllllllllllllIllIlIlllIlIlIlIIl, final double llllllllllllllIllIlIlllIlIllIIII) {
        final double llllllllllllllIllIlIlllIlIlIllll = llllllllllllllIllIlIlllIlIllIIII - this.minZ();
        final double llllllllllllllIllIlIlllIlIlIlllI = this.maxZ() - llllllllllllllIllIlIlllIlIllIIII;
        final double llllllllllllllIllIlIlllIlIlIllIl = llllllllllllllIllIlIlllIlIlIlIIl - this.minX();
        final double llllllllllllllIllIlIlllIlIlIllII = this.maxX() - llllllllllllllIllIlIlllIlIlIlIIl;
        double llllllllllllllIllIlIlllIlIlIlIll = Math.min(llllllllllllllIllIlIlllIlIlIllIl, llllllllllllllIllIlIlllIlIlIllII);
        llllllllllllllIllIlIlllIlIlIlIll = Math.min(llllllllllllllIllIlIlllIlIlIlIll, llllllllllllllIllIlIlllIlIlIllll);
        return Math.min(llllllllllllllIllIlIlllIlIlIlIll, llllllllllllllIllIlIlllIlIlIlllI);
    }
    
    public void addListener(final IBorderListener llllllllllllllIllIlIlllIIlIIIIII) {
        this.listeners.add(llllllllllllllIllIlIlllIIlIIIIII);
    }
    
    public EnumBorderStatus getStatus() {
        return (this.endDiameter < this.startDiameter) ? EnumBorderStatus.SHRINKING : ((this.endDiameter > this.startDiameter) ? EnumBorderStatus.GROWING : EnumBorderStatus.STATIONARY);
    }
    
    public double getDamageBuffer() {
        return this.damageBuffer;
    }
    
    public int getWarningTime() {
        return this.warningTime;
    }
    
    public int getSize() {
        return this.worldSize;
    }
    
    public void setWarningDistance(final int llllllllllllllIllIlIllIllllllIlI) {
        this.warningDistance = llllllllllllllIllIlIllIllllllIlI;
        for (final IBorderListener llllllllllllllIllIlIllIlllllllII : this.getListeners()) {
            llllllllllllllIllIlIllIlllllllII.onWarningDistanceChanged(this, llllllllllllllIllIlIllIllllllIlI);
        }
    }
    
    public double getDiameter() {
        if (this.getStatus() != EnumBorderStatus.STATIONARY) {
            final double llllllllllllllIllIlIlllIIllIllll = (System.currentTimeMillis() - this.startTime) / (float)(this.endTime - this.startTime);
            if (llllllllllllllIllIlIlllIIllIllll < 1.0) {
                return this.startDiameter + (this.endDiameter - this.startDiameter) * llllllllllllllIllIlIlllIIllIllll;
            }
            this.setTransition(this.endDiameter);
        }
        return this.startDiameter;
    }
    
    public void setSize(final int llllllllllllllIllIlIlllIIIllllII) {
        this.worldSize = llllllllllllllIllIlIlllIIIllllII;
    }
    
    public long getTimeUntilTarget() {
        return (this.getStatus() != EnumBorderStatus.STATIONARY) ? (this.endTime - System.currentTimeMillis()) : 0L;
    }
    
    public double getCenterX() {
        return this.centerX;
    }
    
    static {
        __OBFID = "CL_00002012";
    }
    
    public double getTargetSize() {
        return this.endDiameter;
    }
    
    public void setTransition(final double llllllllllllllIllIlIlllIIlIlIIll, final double llllllllllllllIllIlIlllIIlIIllII, final long llllllllllllllIllIlIlllIIlIlIIIl) {
        this.startDiameter = llllllllllllllIllIlIlllIIlIlIIll;
        this.endDiameter = llllllllllllllIllIlIlllIIlIIllII;
        this.startTime = System.currentTimeMillis();
        this.endTime = this.startTime + llllllllllllllIllIlIlllIIlIlIIIl;
        for (final IBorderListener llllllllllllllIllIlIlllIIlIIllll : this.getListeners()) {
            llllllllllllllIllIlIlllIIlIIllll.func_177692_a(this, llllllllllllllIllIlIlllIIlIlIIll, llllllllllllllIllIlIlllIIlIIllII, llllllllllllllIllIlIlllIIlIlIIIl);
        }
    }
    
    protected List getListeners() {
        return Lists.newArrayList((Iterable)this.listeners);
    }
    
    public void setCenter(final double llllllllllllllIllIlIlllIIlllIllI, final double llllllllllllllIllIlIlllIIlllIlIl) {
        this.centerX = llllllllllllllIllIlIlllIIlllIllI;
        this.centerZ = llllllllllllllIllIlIlllIIlllIlIl;
        for (final IBorderListener llllllllllllllIllIlIlllIIllllIII : this.getListeners()) {
            llllllllllllllIllIlIlllIIllllIII.onCenterChanged(this, llllllllllllllIllIlIlllIIlllIllI, llllllllllllllIllIlIlllIIlllIlIl);
        }
    }
    
    public double func_177727_n() {
        return this.damageAmount;
    }
    
    public double getClosestDistance(final Entity llllllllllllllIllIlIlllIlIlllIll) {
        return this.getClosestDistance(llllllllllllllIllIlIlllIlIlllIll.posX, llllllllllllllIllIlIlllIlIlllIll.posZ);
    }
    
    public void setTransition(final double llllllllllllllIllIlIlllIIlIlllIl) {
        this.startDiameter = llllllllllllllIllIlIlllIIlIlllIl;
        this.endDiameter = llllllllllllllIllIlIlllIIlIlllIl;
        this.endTime = System.currentTimeMillis();
        this.startTime = this.endTime;
        for (final IBorderListener llllllllllllllIllIlIlllIIlIlllll : this.getListeners()) {
            llllllllllllllIllIlIlllIIlIlllll.onSizeChanged(this, llllllllllllllIllIlIlllIIlIlllIl);
        }
    }
    
    public double func_177749_o() {
        return (this.endTime == this.startTime) ? 0.0 : (Math.abs(this.startDiameter - this.endDiameter) / (this.endTime - this.startTime));
    }
    
    public boolean contains(final ChunkCoordIntPair llllllllllllllIllIlIlllIllIIIlll) {
        return llllllllllllllIllIlIlllIllIIIlll.getXEnd() > this.minX() && llllllllllllllIllIlIlllIllIIIlll.getXStart() < this.maxX() && llllllllllllllIllIlIlllIllIIIlll.getZEnd() > this.minZ() && llllllllllllllIllIlIlllIllIIIlll.getZStart() < this.maxZ();
    }
}
