package net.minecraft.client.renderer.culling;

import net.minecraft.util.*;

public class Frustrum implements ICamera
{
    private /* synthetic */ double yPosition;
    private /* synthetic */ double xPosition;
    private /* synthetic */ ClippingHelper clippingHelper;
    private /* synthetic */ double zPosition;
    
    @Override
    public boolean isBoundingBoxInFrustum(final AxisAlignedBB llllllllllllllIIlIlIlIIlIlllIlII) {
        return this.isBoxInFrustum(llllllllllllllIIlIlIlIIlIlllIlII.minX, llllllllllllllIIlIlIlIIlIlllIlII.minY, llllllllllllllIIlIlIlIIlIlllIlII.minZ, llllllllllllllIIlIlIlIIlIlllIlII.maxX, llllllllllllllIIlIlIlIIlIlllIlII.maxY, llllllllllllllIIlIlIlIIlIlllIlII.maxZ);
    }
    
    @Override
    public void setPosition(final double llllllllllllllIIlIlIlIIllIIlIIll, final double llllllllllllllIIlIlIlIIllIIlIIlI, final double llllllllllllllIIlIlIlIIllIIlIIIl) {
        this.xPosition = llllllllllllllIIlIlIlIIllIIlIIll;
        this.yPosition = llllllllllllllIIlIlIlIIllIIlIIlI;
        this.zPosition = llllllllllllllIIlIlIlIIllIIlIIIl;
    }
    
    static {
        __OBFID = "CL_00000976";
    }
    
    public Frustrum(final ClippingHelper llllllllllllllIIlIlIlIIllIIllIll) {
        this.clippingHelper = llllllllllllllIIlIlIlIIllIIllIll;
    }
    
    public boolean isBoxInFrustum(final double llllllllllllllIIlIlIlIIllIIIIlII, final double llllllllllllllIIlIlIlIIllIIIIIll, final double llllllllllllllIIlIlIlIIllIIIIIlI, final double llllllllllllllIIlIlIlIIlIllllIlI, final double llllllllllllllIIlIlIlIIllIIIIIII, final double llllllllllllllIIlIlIlIIlIlllllll) {
        return this.clippingHelper.isBoxInFrustum(llllllllllllllIIlIlIlIIllIIIIlII - this.xPosition, llllllllllllllIIlIlIlIIllIIIIIll - this.yPosition, llllllllllllllIIlIlIlIIllIIIIIlI - this.zPosition, llllllllllllllIIlIlIlIIlIllllIlI - this.xPosition, llllllllllllllIIlIlIlIIllIIIIIII - this.yPosition, llllllllllllllIIlIlIlIIlIlllllll - this.zPosition);
    }
    
    public Frustrum() {
        this(ClippingHelperImpl.getInstance());
    }
}
