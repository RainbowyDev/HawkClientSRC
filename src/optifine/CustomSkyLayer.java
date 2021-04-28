package optifine;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.client.renderer.*;

public class CustomSkyLayer
{
    public /* synthetic */ int textureId;
    private /* synthetic */ float speed;
    private /* synthetic */ int blend;
    private /* synthetic */ int startFadeIn;
    private /* synthetic */ RangeListInt days;
    private /* synthetic */ int daysLoop;
    private /* synthetic */ int endFadeOut;
    private /* synthetic */ int endFadeIn;
    public static final /* synthetic */ float[] DEFAULT_AXIS;
    private /* synthetic */ boolean rotate;
    private /* synthetic */ int startFadeOut;
    public /* synthetic */ String source;
    private /* synthetic */ float[] axis;
    
    private float getFadeBrightness(final int llllIllIlIIIIlI) {
        if (this.timeBetween(llllIllIlIIIIlI, this.startFadeIn, this.endFadeIn)) {
            final int llllIllIlIIIlll = this.normalizeTime(this.endFadeIn - this.startFadeIn);
            final int llllIllIlIIIlIl = this.normalizeTime(llllIllIlIIIIlI - this.startFadeIn);
            return llllIllIlIIIlIl / (float)llllIllIlIIIlll;
        }
        if (this.timeBetween(llllIllIlIIIIlI, this.endFadeIn, this.startFadeOut)) {
            return 1.0f;
        }
        if (this.timeBetween(llllIllIlIIIIlI, this.startFadeOut, this.endFadeOut)) {
            final int llllIllIlIIIllI = this.normalizeTime(this.endFadeOut - this.startFadeOut);
            final int llllIllIlIIIlII = this.normalizeTime(llllIllIlIIIIlI - this.startFadeOut);
            return 1.0f - llllIllIlIIIlII / (float)llllIllIlIIIllI;
        }
        return 0.0f;
    }
    
    public boolean isValid(final String llllIllIlllIIII) {
        if (this.source == null) {
            Config.warn(String.valueOf(new StringBuilder("No source texture: ").append(llllIllIlllIIII)));
            return false;
        }
        this.source = TextureUtils.fixResourcePath(this.source, TextureUtils.getBasePath(llllIllIlllIIII));
        if (this.startFadeIn < 0 || this.endFadeIn < 0 || this.endFadeOut < 0) {
            Config.warn("Invalid times, required are: startFadeIn, endFadeIn and endFadeOut.");
            return false;
        }
        final int llllIllIllIllll = this.normalizeTime(this.endFadeIn - this.startFadeIn);
        if (this.startFadeOut < 0) {
            this.startFadeOut = this.normalizeTime(this.endFadeOut - llllIllIllIllll);
            if (this.timeBetween(this.startFadeOut, this.startFadeIn, this.endFadeIn)) {
                this.startFadeOut = this.endFadeIn;
            }
        }
        final int llllIllIllIlllI = this.normalizeTime(this.startFadeOut - this.endFadeIn);
        final int llllIllIllIllIl = this.normalizeTime(this.endFadeOut - this.startFadeOut);
        final int llllIllIllIllII = this.normalizeTime(this.startFadeIn - this.endFadeOut);
        final int llllIllIllIlIll = llllIllIllIllll + llllIllIllIlllI + llllIllIllIllIl + llllIllIllIllII;
        if (llllIllIllIlIll != 24000) {
            Config.warn(String.valueOf(new StringBuilder("Invalid fadeIn/fadeOut times, sum is not 24h: ").append(llllIllIllIlIll)));
            return false;
        }
        if (this.speed < 0.0f) {
            Config.warn(String.valueOf(new StringBuilder("Invalid speed: ").append(this.speed)));
            return false;
        }
        if (this.daysLoop <= 0) {
            Config.warn(String.valueOf(new StringBuilder("Invalid daysLoop: ").append(this.daysLoop)));
            return false;
        }
        return true;
    }
    
    private float parseFloat(final String llllIlllIIllIII, final float llllIlllIIlIlll) {
        if (llllIlllIIllIII == null) {
            return llllIlllIIlIlll;
        }
        final float llllIlllIIlIllI = Config.parseFloat(llllIlllIIllIII, Float.MIN_VALUE);
        if (llllIlllIIlIllI == Float.MIN_VALUE) {
            Config.warn(String.valueOf(new StringBuilder("Invalid value: ").append(llllIlllIIllIII)));
            return llllIlllIIlIlll;
        }
        return llllIlllIIlIllI;
    }
    
    private boolean timeBetween(final int llllIllIIIlIllI, final int llllIllIIIlIIlI, final int llllIllIIIlIIIl) {
        return (llllIllIIIlIIlI <= llllIllIIIlIIIl) ? (llllIllIIIlIllI >= llllIllIIIlIIlI && llllIllIIIlIllI <= llllIllIIIlIIIl) : (llllIllIIIlIllI >= llllIllIIIlIIlI || llllIllIIIlIllI <= llllIllIIIlIIIl);
    }
    
    private boolean parseBoolean(final String llllIlllIlIIIII, final boolean llllIlllIIlllll) {
        if (llllIlllIlIIIII == null) {
            return llllIlllIIlllll;
        }
        if (llllIlllIlIIIII.toLowerCase().equals("true")) {
            return true;
        }
        if (llllIlllIlIIIII.toLowerCase().equals("false")) {
            return false;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown boolean: ").append(llllIlllIlIIIII)));
        return llllIlllIIlllll;
    }
    
    static {
        DEFAULT_AXIS = new float[] { 1.0f, 0.0f, 0.0f };
    }
    
    private float[] parseAxis(final String llllIlllIIIIIII, final float[] llllIlllIIIlIII) {
        if (llllIlllIIIIIII == null) {
            return llllIlllIIIlIII;
        }
        final String[] llllIlllIIIIlll = Config.tokenize(llllIlllIIIIIII, " ");
        if (llllIlllIIIIlll.length != 3) {
            Config.warn(String.valueOf(new StringBuilder("Invalid axis: ").append(llllIlllIIIIIII)));
            return llllIlllIIIlIII;
        }
        final float[] llllIlllIIIIllI = new float[3];
        for (int llllIlllIIIIlIl = 0; llllIlllIIIIlIl < llllIlllIIIIlll.length; ++llllIlllIIIIlIl) {
            llllIlllIIIIllI[llllIlllIIIIlIl] = Config.parseFloat(llllIlllIIIIlll[llllIlllIIIIlIl], Float.MIN_VALUE);
            if (llllIlllIIIIllI[llllIlllIIIIlIl] == Float.MIN_VALUE) {
                Config.warn(String.valueOf(new StringBuilder("Invalid axis: ").append(llllIlllIIIIIII)));
                return llllIlllIIIlIII;
            }
            if (llllIlllIIIIllI[llllIlllIIIIlIl] < -1.0f || llllIlllIIIIllI[llllIlllIIIIlIl] > 1.0f) {
                Config.warn(String.valueOf(new StringBuilder("Invalid axis values: ").append(llllIlllIIIIIII)));
                return llllIlllIIIlIII;
            }
        }
        final float llllIlllIIIIlII = llllIlllIIIIllI[0];
        final float llllIlllIIIIIll = llllIlllIIIIllI[1];
        final float llllIlllIIIIIlI = llllIlllIIIIllI[2];
        if (llllIlllIIIIlII * llllIlllIIIIlII + llllIlllIIIIIll * llllIlllIIIIIll + llllIlllIIIIIlI * llllIlllIIIIIlI < 1.0E-5f) {
            Config.warn(String.valueOf(new StringBuilder("Invalid axis values: ").append(llllIlllIIIIIII)));
            return llllIlllIIIlIII;
        }
        final float[] llllIlllIIIIIIl = { llllIlllIIIIIlI, llllIlllIIIIIll, -llllIlllIIIIlII };
        return llllIlllIIIIIIl;
    }
    
    public boolean isActive(final World llllIllIIlIIIII, final int llllIllIIlIIllI) {
        if (this.timeBetween(llllIllIIlIIllI, this.endFadeOut, this.startFadeIn)) {
            return false;
        }
        if (this.days != null) {
            final long llllIllIIlIIlIl = llllIllIIlIIIII.getWorldTime();
            long llllIllIIlIIlII;
            for (llllIllIIlIIlII = llllIllIIlIIlIl - this.startFadeIn; llllIllIIlIIlII < 0L; llllIllIIlIIlII += 24000 * this.daysLoop) {}
            final int llllIllIIlIIIll = (int)(llllIllIIlIIlII / 24000L);
            final int llllIllIIlIIIlI = llllIllIIlIIIll % this.daysLoop;
            if (!this.days.isInRange(llllIllIIlIIIlI)) {
                return false;
            }
        }
        return true;
    }
    
    private void renderSide(final Tessellator llllIllIIllIlII, final int llllIllIIlllIII) {
        final WorldRenderer llllIllIIllIlll = llllIllIIllIlII.getWorldRenderer();
        final double llllIllIIllIllI = llllIllIIlllIII % 3 / 3.0;
        final double llllIllIIllIlIl = llllIllIIlllIII / 3 / 2.0;
        llllIllIIllIlll.startDrawingQuads();
        llllIllIIllIlll.addVertexWithUV(-100.0, -100.0, -100.0, llllIllIIllIllI, llllIllIIllIlIl);
        llllIllIIllIlll.addVertexWithUV(-100.0, -100.0, 100.0, llllIllIIllIllI, llllIllIIllIlIl + 0.5);
        llllIllIIllIlll.addVertexWithUV(100.0, -100.0, 100.0, llllIllIIllIllI + 0.3333333333333333, llllIllIIllIlIl + 0.5);
        llllIllIIllIlll.addVertexWithUV(100.0, -100.0, -100.0, llllIllIIllIllI + 0.3333333333333333, llllIllIIllIlIl);
        llllIllIIllIlII.draw();
    }
    
    public CustomSkyLayer(final Properties llllIlllIllllII, final String llllIlllIlllIll) {
        this.source = null;
        this.startFadeIn = -1;
        this.endFadeIn = -1;
        this.startFadeOut = -1;
        this.endFadeOut = -1;
        this.blend = 1;
        this.rotate = false;
        this.speed = 1.0f;
        this.axis = CustomSkyLayer.DEFAULT_AXIS;
        this.days = null;
        this.daysLoop = 8;
        this.textureId = -1;
        final ConnectedParser llllIlllIlllllI = new ConnectedParser("CustomSky");
        this.source = llllIlllIllllII.getProperty("source", llllIlllIlllIll);
        this.startFadeIn = this.parseTime(llllIlllIllllII.getProperty("startFadeIn"));
        this.endFadeIn = this.parseTime(llllIlllIllllII.getProperty("endFadeIn"));
        this.startFadeOut = this.parseTime(llllIlllIllllII.getProperty("startFadeOut"));
        this.endFadeOut = this.parseTime(llllIlllIllllII.getProperty("endFadeOut"));
        this.blend = Blender.parseBlend(llllIlllIllllII.getProperty("blend"));
        this.rotate = this.parseBoolean(llllIlllIllllII.getProperty("rotate"), true);
        this.speed = this.parseFloat(llllIlllIllllII.getProperty("speed"), 1.0f);
        this.axis = this.parseAxis(llllIlllIllllII.getProperty("axis"), CustomSkyLayer.DEFAULT_AXIS);
        this.days = llllIlllIlllllI.parseRangeListInt(llllIlllIllllII.getProperty("days"));
        this.daysLoop = llllIlllIlllllI.parseInt(llllIlllIllllII.getProperty("daysLoop"), 8);
    }
    
    public void render(final int llllIllIlIlIIlI, final float llllIllIlIlIlll, final float llllIllIlIlIIII) {
        float llllIllIlIlIlIl = llllIllIlIlIIII * this.getFadeBrightness(llllIllIlIlIIlI);
        llllIllIlIlIlIl = Config.limit(llllIllIlIlIlIl, 0.0f, 1.0f);
        if (llllIllIlIlIlIl >= 1.0E-4f) {
            GlStateManager.func_179144_i(this.textureId);
            Blender.setupBlend(this.blend, llllIllIlIlIlIl);
            GlStateManager.pushMatrix();
            if (this.rotate) {
                GlStateManager.rotate(llllIllIlIlIlll * 360.0f * this.speed, this.axis[0], this.axis[1], this.axis[2]);
            }
            final Tessellator llllIllIlIlIlII = Tessellator.getInstance();
            GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(llllIllIlIlIlII, 4);
            GlStateManager.pushMatrix();
            GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
            this.renderSide(llllIllIlIlIlII, 1);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
            this.renderSide(llllIllIlIlIlII, 0);
            GlStateManager.popMatrix();
            GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(llllIllIlIlIlII, 5);
            GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(llllIllIlIlIlII, 2);
            GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(llllIllIlIlIlII, 3);
            GlStateManager.popMatrix();
        }
    }
    
    private int parseTime(final String llllIlllIlIlIlI) {
        if (llllIlllIlIlIlI == null) {
            return -1;
        }
        final String[] llllIlllIllIIII = Config.tokenize(llllIlllIlIlIlI, ":");
        if (llllIlllIllIIII.length != 2) {
            Config.warn(String.valueOf(new StringBuilder("Invalid time: ").append(llllIlllIlIlIlI)));
            return -1;
        }
        final String llllIlllIlIllll = llllIlllIllIIII[0];
        final String llllIlllIlIlllI = llllIlllIllIIII[1];
        int llllIlllIlIllIl = Config.parseInt(llllIlllIlIllll, -1);
        final int llllIlllIlIllII = Config.parseInt(llllIlllIlIlllI, -1);
        if (llllIlllIlIllIl >= 0 && llllIlllIlIllIl <= 23 && llllIlllIlIllII >= 0 && llllIlllIlIllII <= 59) {
            llllIlllIlIllIl -= 6;
            if (llllIlllIlIllIl < 0) {
                llllIlllIlIllIl += 24;
            }
            final int llllIlllIlIlIll = llllIlllIlIllIl * 1000 + (int)(llllIlllIlIllII / 60.0 * 1000.0);
            return llllIlllIlIlIll;
        }
        Config.warn(String.valueOf(new StringBuilder("Invalid time: ").append(llllIlllIlIlIlI)));
        return -1;
    }
    
    private int normalizeTime(int llllIllIllIIIIl) {
        while (llllIllIllIIIIl >= 24000) {
            llllIllIllIIIIl -= 24000;
        }
        while (llllIllIllIIIIl < 0) {
            llllIllIllIIIIl += 24000;
        }
        return llllIllIllIIIIl;
    }
}
