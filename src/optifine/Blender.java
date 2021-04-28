package optifine;

import net.minecraft.client.renderer.*;

public class Blender
{
    static {
        BLEND_SUBSTRACT = 2;
        BLEND_MULTIPLY = 3;
        BLEND_SCREEN = 6;
        BLEND_ADD = 1;
        BLEND_ALPHA = 0;
        BLEND_REPLACE = 8;
        BLEND_OVERLAY = 7;
        BLEND_BURN = 5;
        BLEND_DEFAULT = 1;
        BLEND_DODGE = 4;
    }
    
    public static void setupBlend(final int lllllllllllllllIlllllIIIlIlIIlll, final float lllllllllllllllIlllllIIIlIlIIlII) {
        switch (lllllllllllllllIlllllIIIlIlIIlll) {
            case 0: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 771);
                GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllllIlllllIIIlIlIIlII);
                break;
            }
            case 1: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 1);
                GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllllIlllllIIIlIlIIlII);
                break;
            }
            case 2: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(775, 0);
                GlStateManager.color(lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, 1.0f);
                break;
            }
            case 3: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(774, 771);
                GlStateManager.color(lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII);
                break;
            }
            case 4: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(1, 1);
                GlStateManager.color(lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, 1.0f);
                break;
            }
            case 5: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(0, 769);
                GlStateManager.color(lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, 1.0f);
                break;
            }
            case 6: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(1, 769);
                GlStateManager.color(lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, 1.0f);
                break;
            }
            case 7: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(774, 768);
                GlStateManager.color(lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, lllllllllllllllIlllllIIIlIlIIlII, 1.0f);
                break;
            }
            case 8: {
                GlStateManager.enableAlpha();
                GlStateManager.disableBlend();
                GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllllIlllllIIIlIlIIlII);
                break;
            }
        }
        GlStateManager.func_179098_w();
    }
    
    public static int parseBlend(String lllllllllllllllIlllllIIIlIlIlIlI) {
        if (lllllllllllllllIlllllIIIlIlIlIlI == null) {
            return 1;
        }
        lllllllllllllllIlllllIIIlIlIlIlI = lllllllllllllllIlllllIIIlIlIlIlI.toLowerCase().trim();
        if (lllllllllllllllIlllllIIIlIlIlIlI.equals("alpha")) {
            return 0;
        }
        if (lllllllllllllllIlllllIIIlIlIlIlI.equals("add")) {
            return 1;
        }
        if (lllllllllllllllIlllllIIIlIlIlIlI.equals("subtract")) {
            return 2;
        }
        if (lllllllllllllllIlllllIIIlIlIlIlI.equals("multiply")) {
            return 3;
        }
        if (lllllllllllllllIlllllIIIlIlIlIlI.equals("dodge")) {
            return 4;
        }
        if (lllllllllllllllIlllllIIIlIlIlIlI.equals("burn")) {
            return 5;
        }
        if (lllllllllllllllIlllllIIIlIlIlIlI.equals("screen")) {
            return 6;
        }
        if (lllllllllllllllIlllllIIIlIlIlIlI.equals("overlay")) {
            return 7;
        }
        if (lllllllllllllllIlllllIIIlIlIlIlI.equals("replace")) {
            return 8;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown blend: ").append(lllllllllllllllIlllllIIIlIlIlIlI)));
        return 1;
    }
    
    public static void clearBlend(final float lllllllllllllllIlllllIIIlIlIIIIl) {
        GlStateManager.disableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 1);
        GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllllIlllllIIIlIlIIIIl);
    }
}
