package optifine;

import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class CloudRenderer
{
    private /* synthetic */ boolean updated;
    /* synthetic */ float partialTicks;
    private /* synthetic */ double cloudPlayerZ;
    /* synthetic */ int cloudTickCounter;
    private /* synthetic */ double cloudPlayerY;
    private /* synthetic */ Minecraft mc;
    private /* synthetic */ int cloudTickCounterUpdate;
    private /* synthetic */ boolean renderFancy;
    private /* synthetic */ double cloudPlayerX;
    private /* synthetic */ int glListClouds;
    
    public void reset() {
        this.updated = false;
    }
    
    public void endUpdateGlList() {
        GL11.glEndList();
        this.cloudTickCounterUpdate = this.cloudTickCounter;
        this.cloudPlayerX = this.mc.func_175606_aa().prevPosX;
        this.cloudPlayerY = this.mc.func_175606_aa().prevPosY;
        this.cloudPlayerZ = this.mc.func_175606_aa().prevPosZ;
        this.updated = true;
        GlStateManager.func_179117_G();
    }
    
    public void renderGlList() {
        final Entity llllllllllllllIlIIIlIIIllllllIII = this.mc.func_175606_aa();
        final double llllllllllllllIlIIIlIIIlllllIlll = llllllllllllllIlIIIlIIIllllllIII.prevPosX + (llllllllllllllIlIIIlIIIllllllIII.posX - llllllllllllllIlIIIlIIIllllllIII.prevPosX) * this.partialTicks;
        final double llllllllllllllIlIIIlIIIlllllIllI = llllllllllllllIlIIIlIIIllllllIII.prevPosY + (llllllllllllllIlIIIlIIIllllllIII.posY - llllllllllllllIlIIIlIIIllllllIII.prevPosY) * this.partialTicks;
        final double llllllllllllllIlIIIlIIIlllllIlIl = llllllllllllllIlIIIlIIIllllllIII.prevPosZ + (llllllllllllllIlIIIlIIIllllllIII.posZ - llllllllllllllIlIIIlIIIllllllIII.prevPosZ) * this.partialTicks;
        final double llllllllllllllIlIIIlIIIlllllIlII = this.cloudTickCounter - this.cloudTickCounterUpdate + this.partialTicks;
        final float llllllllllllllIlIIIlIIIlllllIIll = (float)(llllllllllllllIlIIIlIIIlllllIlll - this.cloudPlayerX + llllllllllllllIlIIIlIIIlllllIlII * 0.03);
        final float llllllllllllllIlIIIlIIIlllllIIlI = (float)(llllllllllllllIlIIIlIIIlllllIllI - this.cloudPlayerY);
        final float llllllllllllllIlIIIlIIIlllllIIIl = (float)(llllllllllllllIlIIIlIIIlllllIlIl - this.cloudPlayerZ);
        GlStateManager.pushMatrix();
        if (this.renderFancy) {
            GlStateManager.translate(-llllllllllllllIlIIIlIIIlllllIIll / 12.0f, -llllllllllllllIlIIIlIIIlllllIIlI, -llllllllllllllIlIIIlIIIlllllIIIl / 12.0f);
        }
        else {
            GlStateManager.translate(-llllllllllllllIlIIIlIIIlllllIIll, -llllllllllllllIlIIIlIIIlllllIIlI, -llllllllllllllIlIIIlIIIlllllIIIl);
        }
        GlStateManager.callList(this.glListClouds);
        GlStateManager.popMatrix();
        GlStateManager.func_179117_G();
    }
    
    public CloudRenderer(final Minecraft llllllllllllllIlIIIlIIlIIIlIIIIl) {
        this.updated = false;
        this.renderFancy = false;
        this.glListClouds = -1;
        this.cloudTickCounterUpdate = 0;
        this.cloudPlayerX = 0.0;
        this.cloudPlayerY = 0.0;
        this.cloudPlayerZ = 0.0;
        this.mc = llllllllllllllIlIIIlIIlIIIlIIIIl;
        this.glListClouds = GLAllocation.generateDisplayLists(1);
    }
    
    public void startUpdateGlList() {
        GL11.glNewList(this.glListClouds, 4864);
    }
    
    public void prepareToRender(final boolean llllllllllllllIlIIIlIIlIIIIllIll, final int llllllllllllllIlIIIlIIlIIIIllIlI, final float llllllllllllllIlIIIlIIlIIIIllIIl) {
        if (this.renderFancy != llllllllllllllIlIIIlIIlIIIIllIll) {
            this.updated = false;
        }
        this.renderFancy = llllllllllllllIlIIIlIIlIIIIllIll;
        this.cloudTickCounter = llllllllllllllIlIIIlIIlIIIIllIlI;
        this.partialTicks = llllllllllllllIlIIIlIIlIIIIllIIl;
    }
    
    public boolean shouldUpdateGlList() {
        if (!this.updated) {
            return true;
        }
        if (this.cloudTickCounter >= this.cloudTickCounterUpdate + 20) {
            return true;
        }
        final Entity llllllllllllllIlIIIlIIlIIIIIllll = this.mc.func_175606_aa();
        final boolean llllllllllllllIlIIIlIIlIIIIIlllI = this.cloudPlayerY + llllllllllllllIlIIIlIIlIIIIIllll.getEyeHeight() < 128.0 + this.mc.gameSettings.ofCloudsHeight * 128.0f;
        final boolean llllllllllllllIlIIIlIIlIIIIIllIl = llllllllllllllIlIIIlIIlIIIIIllll.prevPosY + llllllllllllllIlIIIlIIlIIIIIllll.getEyeHeight() < 128.0 + this.mc.gameSettings.ofCloudsHeight * 128.0f;
        return llllllllllllllIlIIIlIIlIIIIIllIl ^ llllllllllllllIlIIIlIIlIIIIIlllI;
    }
}
