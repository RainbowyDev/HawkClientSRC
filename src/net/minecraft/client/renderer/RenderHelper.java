package net.minecraft.client.renderer;

import net.minecraft.util.*;
import java.nio.*;
import org.lwjgl.opengl.*;

public class RenderHelper
{
    private static final /* synthetic */ Vec3 field_82885_c;
    private static final /* synthetic */ Vec3 field_82884_b;
    private static /* synthetic */ FloatBuffer colorBuffer;
    
    private static FloatBuffer setColorBuffer(final double lIlIIlIllIIlIII, final double lIlIIlIllIIIIll, final double lIlIIlIllIIIllI, final double lIlIIlIllIIIIIl) {
        return setColorBuffer((float)lIlIIlIllIIlIII, (float)lIlIIlIllIIIIll, (float)lIlIIlIllIIIllI, (float)lIlIIlIllIIIIIl);
    }
    
    public static void disableStandardItemLighting() {
        GlStateManager.disableLighting();
        GlStateManager.disableBooleanStateAt(0);
        GlStateManager.disableBooleanStateAt(1);
        GlStateManager.disableColorMaterial();
    }
    
    private static FloatBuffer setColorBuffer(final float lIlIIlIlIlllIII, final float lIlIIlIlIllIlll, final float lIlIIlIlIllIllI, final float lIlIIlIlIllIlIl) {
        RenderHelper.colorBuffer.clear();
        RenderHelper.colorBuffer.put(lIlIIlIlIlllIII).put(lIlIIlIlIllIlll).put(lIlIIlIlIllIllI).put(lIlIIlIlIllIlIl);
        RenderHelper.colorBuffer.flip();
        return RenderHelper.colorBuffer;
    }
    
    public static void enableStandardItemLighting() {
        GlStateManager.enableLighting();
        GlStateManager.enableBooleanStateAt(0);
        GlStateManager.enableBooleanStateAt(1);
        GlStateManager.enableColorMaterial();
        GlStateManager.colorMaterial(1032, 5634);
        final float lIlIIlIllIlIIlI = 0.4f;
        final float lIlIIlIllIlIIIl = 0.6f;
        final float lIlIIlIllIlIIII = 0.0f;
        GL11.glLight(16384, 4611, setColorBuffer(RenderHelper.field_82884_b.xCoord, RenderHelper.field_82884_b.yCoord, RenderHelper.field_82884_b.zCoord, 0.0));
        GL11.glLight(16384, 4609, setColorBuffer(lIlIIlIllIlIIIl, lIlIIlIllIlIIIl, lIlIIlIllIlIIIl, 1.0f));
        GL11.glLight(16384, 4608, setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight(16384, 4610, setColorBuffer(lIlIIlIllIlIIII, lIlIIlIllIlIIII, lIlIIlIllIlIIII, 1.0f));
        GL11.glLight(16385, 4611, setColorBuffer(RenderHelper.field_82885_c.xCoord, RenderHelper.field_82885_c.yCoord, RenderHelper.field_82885_c.zCoord, 0.0));
        GL11.glLight(16385, 4609, setColorBuffer(lIlIIlIllIlIIIl, lIlIIlIllIlIIIl, lIlIIlIllIlIIIl, 1.0f));
        GL11.glLight(16385, 4608, setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight(16385, 4610, setColorBuffer(lIlIIlIllIlIIII, lIlIIlIllIlIIII, lIlIIlIllIlIIII, 1.0f));
        GlStateManager.shadeModel(7424);
        GL11.glLightModel(2899, setColorBuffer(lIlIIlIllIlIIlI, lIlIIlIllIlIIlI, lIlIIlIllIlIIlI, 1.0f));
    }
    
    public static void enableGUIStandardItemLighting() {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-30.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(165.0f, 1.0f, 0.0f, 0.0f);
        enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    static {
        __OBFID = "CL_00000629";
        RenderHelper.colorBuffer = GLAllocation.createDirectFloatBuffer(16);
        field_82884_b = new Vec3(0.20000000298023224, 1.0, -0.699999988079071).normalize();
        field_82885_c = new Vec3(-0.20000000298023224, 1.0, 0.699999988079071).normalize();
    }
}
