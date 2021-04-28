package net.minecraft.client.particle;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.client.*;

public class EntityPickupFX extends EntityFX
{
    private /* synthetic */ Entity field_174840_a;
    private /* synthetic */ int maxAge;
    private /* synthetic */ int age;
    private /* synthetic */ float field_174841_aA;
    private /* synthetic */ RenderManager field_174842_aB;
    private /* synthetic */ Entity field_174843_ax;
    
    static {
        __OBFID = "CL_00000930";
    }
    
    @Override
    public void func_180434_a(final WorldRenderer lllllllllllllllIIIlIllllIllIlIII, final Entity lllllllllllllllIIIlIllllIllIIlll, final float lllllllllllllllIIIlIllllIllIIllI, final float lllllllllllllllIIIlIllllIllIIlIl, final float lllllllllllllllIIIlIllllIllIIlII, final float lllllllllllllllIIIlIllllIllIIIll, final float lllllllllllllllIIIlIllllIllIIIlI, final float lllllllllllllllIIIlIllllIllIIIIl) {
        float lllllllllllllllIIIlIllllIllIIIII = (this.age + lllllllllllllllIIIlIllllIllIIllI) / this.maxAge;
        lllllllllllllllIIIlIllllIllIIIII *= lllllllllllllllIIIlIllllIllIIIII;
        final double lllllllllllllllIIIlIllllIlIlllll = this.field_174840_a.posX;
        final double lllllllllllllllIIIlIllllIlIllllI = this.field_174840_a.posY;
        final double lllllllllllllllIIIlIllllIlIlllIl = this.field_174840_a.posZ;
        final double lllllllllllllllIIIlIllllIlIlllII = this.field_174843_ax.lastTickPosX + (this.field_174843_ax.posX - this.field_174843_ax.lastTickPosX) * lllllllllllllllIIIlIllllIllIIllI;
        final double lllllllllllllllIIIlIllllIlIllIll = this.field_174843_ax.lastTickPosY + (this.field_174843_ax.posY - this.field_174843_ax.lastTickPosY) * lllllllllllllllIIIlIllllIllIIllI + this.field_174841_aA;
        final double lllllllllllllllIIIlIllllIlIllIlI = this.field_174843_ax.lastTickPosZ + (this.field_174843_ax.posZ - this.field_174843_ax.lastTickPosZ) * lllllllllllllllIIIlIllllIllIIllI;
        double lllllllllllllllIIIlIllllIlIllIIl = lllllllllllllllIIIlIllllIlIlllll + (lllllllllllllllIIIlIllllIlIlllII - lllllllllllllllIIIlIllllIlIlllll) * lllllllllllllllIIIlIllllIllIIIII;
        double lllllllllllllllIIIlIllllIlIllIII = lllllllllllllllIIIlIllllIlIllllI + (lllllllllllllllIIIlIllllIlIllIll - lllllllllllllllIIIlIllllIlIllllI) * lllllllllllllllIIIlIllllIllIIIII;
        double lllllllllllllllIIIlIllllIlIlIlll = lllllllllllllllIIIlIllllIlIlllIl + (lllllllllllllllIIIlIllllIlIllIlI - lllllllllllllllIIIlIllllIlIlllIl) * lllllllllllllllIIIlIllllIllIIIII;
        final int lllllllllllllllIIIlIllllIlIlIllI = this.getBrightnessForRender(lllllllllllllllIIIlIllllIllIIllI);
        final int lllllllllllllllIIIlIllllIlIlIlIl = lllllllllllllllIIIlIllllIlIlIllI % 65536;
        final int lllllllllllllllIIIlIllllIlIlIlII = lllllllllllllllIIIlIllllIlIlIllI / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lllllllllllllllIIIlIllllIlIlIlIl / 1.0f, lllllllllllllllIIIlIllllIlIlIlII / 1.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        lllllllllllllllIIIlIllllIlIllIIl -= EntityPickupFX.interpPosX;
        lllllllllllllllIIIlIllllIlIllIII -= EntityPickupFX.interpPosY;
        lllllllllllllllIIIlIllllIlIlIlll -= EntityPickupFX.interpPosZ;
        this.field_174842_aB.renderEntityWithPosYaw(this.field_174840_a, (float)lllllllllllllllIIIlIllllIlIllIIl, (float)lllllllllllllllIIIlIllllIlIllIII, (float)lllllllllllllllIIIlIllllIlIlIlll, this.field_174840_a.rotationYaw, lllllllllllllllIIIlIllllIllIIllI);
    }
    
    @Override
    public void onUpdate() {
        ++this.age;
        if (this.age == this.maxAge) {
            this.setDead();
        }
    }
    
    public EntityPickupFX(final World lllllllllllllllIIIlIlllllIIIIIIl, final Entity lllllllllllllllIIIlIlllllIIIIIII, final Entity lllllllllllllllIIIlIllllIlllllll, final float lllllllllllllllIIIlIllllIllllllI) {
        super(lllllllllllllllIIIlIlllllIIIIIIl, lllllllllllllllIIIlIlllllIIIIIII.posX, lllllllllllllllIIIlIlllllIIIIIII.posY, lllllllllllllllIIIlIlllllIIIIIII.posZ, lllllllllllllllIIIlIlllllIIIIIII.motionX, lllllllllllllllIIIlIlllllIIIIIII.motionY, lllllllllllllllIIIlIlllllIIIIIII.motionZ);
        this.field_174842_aB = Minecraft.getMinecraft().getRenderManager();
        this.field_174840_a = lllllllllllllllIIIlIlllllIIIIIII;
        this.field_174843_ax = lllllllllllllllIIIlIllllIlllllll;
        this.maxAge = 3;
        this.field_174841_aA = lllllllllllllllIIIlIllllIllllllI;
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
}
