package net.minecraft.client.renderer.entity;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class RenderEntity extends Render
{
    public RenderEntity(final RenderManager llllllllllllllIIlIlIIllIllIlIIII) {
        super(llllllllllllllIIlIlIIllIllIlIIII);
    }
    
    @Override
    public void doRender(final Entity llllllllllllllIIlIlIIllIlIlllllI, final double llllllllllllllIIlIlIIllIllIIIlII, final double llllllllllllllIIlIlIIllIlIllllII, final double llllllllllllllIIlIlIIllIllIIIIlI, final float llllllllllllllIIlIlIIllIllIIIIIl, final float llllllllllllllIIlIlIIllIlIlllIIl) {
        GlStateManager.pushMatrix();
        Render.renderOffsetAABB(llllllllllllllIIlIlIIllIlIlllllI.getEntityBoundingBox(), llllllllllllllIIlIlIIllIllIIIlII - llllllllllllllIIlIlIIllIlIlllllI.lastTickPosX, llllllllllllllIIlIlIIllIlIllllII - llllllllllllllIIlIlIIllIlIlllllI.lastTickPosY, llllllllllllllIIlIlIIllIllIIIIlI - llllllllllllllIIlIlIIllIlIlllllI.lastTickPosZ);
        GlStateManager.popMatrix();
        super.doRender(llllllllllllllIIlIlIIllIlIlllllI, llllllllllllllIIlIlIIllIllIIIlII, llllllllllllllIIlIlIIllIlIllllII, llllllllllllllIIlIlIIllIllIIIIlI, llllllllllllllIIlIlIIllIllIIIIIl, llllllllllllllIIlIlIIllIlIlllIIl);
    }
    
    static {
        __OBFID = "CL_00000986";
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIlIlIIllIlIllIlll) {
        return null;
    }
}
