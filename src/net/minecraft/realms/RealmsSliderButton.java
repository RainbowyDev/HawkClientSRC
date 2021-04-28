package net.minecraft.realms;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class RealmsSliderButton extends RealmsButton
{
    public /* synthetic */ boolean sliding;
    private /* synthetic */ int steps;
    private final /* synthetic */ float minValue;
    private final /* synthetic */ float maxValue;
    public /* synthetic */ float value;
    
    public void clicked(final float lllllllllllllllIllIlIIIIlIIIIIIl) {
    }
    
    @Override
    public int getYImage(final boolean lllllllllllllllIllIlIIIIlIIlIlII) {
        return 0;
    }
    
    @Override
    public void renderBg(final int lllllllllllllllIllIlIIIIlIIIllll, final int lllllllllllllllIllIlIIIIlIIIlllI) {
        if (this.getProxy().visible) {
            if (this.sliding) {
                this.value = (lllllllllllllllIllIlIIIIlIIIllll - (this.getProxy().xPosition + 4)) / (float)(this.getProxy().getButtonWidth() - 8);
                this.value = MathHelper.clamp_float(this.value, 0.0f, 1.0f);
                final float lllllllllllllllIllIlIIIIlIIIllIl = this.toValue(this.value);
                this.clicked(lllllllllllllllIllIlIIIIlIIIllIl);
                this.value = this.toPct(lllllllllllllllIllIlIIIIlIIIllIl);
                this.getProxy().displayString = this.getMessage();
            }
            Minecraft.getMinecraft().getTextureManager().bindTexture(RealmsSliderButton.WIDGETS_LOCATION);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.blit(this.getProxy().xPosition + (int)(this.value * (this.getProxy().getButtonWidth() - 8)), this.getProxy().yPosition, 0, 66, 4, 20);
            this.blit(this.getProxy().xPosition + (int)(this.value * (this.getProxy().getButtonWidth() - 8)) + 4, this.getProxy().yPosition, 196, 66, 4, 20);
        }
    }
    
    @Override
    public void released(final int lllllllllllllllIllIlIIIIIllllllI, final int lllllllllllllllIllIlIIIIIlllllIl) {
        this.sliding = false;
    }
    
    public float toPct(final float lllllllllllllllIllIlIIIIlIlIlIII) {
        return MathHelper.clamp_float((this.clamp(lllllllllllllllIllIlIIIIlIlIlIII) - this.minValue) / (this.maxValue - this.minValue), 0.0f, 1.0f);
    }
    
    public float toValue(final float lllllllllllllllIllIlIIIIlIlIIlII) {
        return this.clamp(this.minValue + (this.maxValue - this.minValue) * MathHelper.clamp_float(lllllllllllllllIllIlIIIIlIlIIlII, 0.0f, 1.0f));
    }
    
    public RealmsSliderButton(final int lllllllllllllllIllIlIIIIlIlllllI, final int lllllllllllllllIllIlIIIIlIllIlII, final int lllllllllllllllIllIlIIIIlIllIIll, final int lllllllllllllllIllIlIIIIlIlllIll, final int lllllllllllllllIllIlIIIIlIlllIlI, final int lllllllllllllllIllIlIIIIlIlllIIl, final float lllllllllllllllIllIlIIIIlIllIIII, final float lllllllllllllllIllIlIIIIlIlIllll) {
        super(lllllllllllllllIllIlIIIIlIlllllI, lllllllllllllllIllIlIIIIlIllIlII, lllllllllllllllIllIlIIIIlIllIIll, lllllllllllllllIllIlIIIIlIlllIll, 20, "");
        this.value = 1.0f;
        this.minValue = lllllllllllllllIllIlIIIIlIllIIII;
        this.maxValue = lllllllllllllllIllIlIIIIlIlIllll;
        this.value = this.toPct((float)lllllllllllllllIllIlIIIIlIlllIIl);
        this.getProxy().displayString = this.getMessage();
    }
    
    public float clamp(float lllllllllllllllIllIlIIIIlIIlllII) {
        lllllllllllllllIllIlIIIIlIIlllII = (long)this.clampSteps((float)lllllllllllllllIllIlIIIIlIIlllII);
        return MathHelper.clamp_float((float)lllllllllllllllIllIlIIIIlIIlllII, this.minValue, this.maxValue);
    }
    
    protected float clampSteps(float lllllllllllllllIllIlIIIIlIIlIllI) {
        if (this.steps > 0) {
            lllllllllllllllIllIlIIIIlIIlIllI = (float)(this.steps * Math.round(lllllllllllllllIllIlIIIIlIIlIllI / this.steps));
        }
        return lllllllllllllllIllIlIIIIlIIlIllI;
    }
    
    @Override
    public void clicked(final int lllllllllllllllIllIlIIIIlIIIIllI, final int lllllllllllllllIllIlIIIIlIIIIlIl) {
        this.value = (lllllllllllllllIllIlIIIIlIIIIllI - (this.getProxy().xPosition + 4)) / (float)(this.getProxy().getButtonWidth() - 8);
        this.value = MathHelper.clamp_float(this.value, 0.0f, 1.0f);
        this.clicked(this.toValue(this.value));
        this.getProxy().displayString = this.getMessage();
        this.sliding = true;
    }
    
    public RealmsSliderButton(final int lllllllllllllllIllIlIIIIllIlIlII, final int lllllllllllllllIllIlIIIIllIlIIll, final int lllllllllllllllIllIlIIIIllIIlIll, final int lllllllllllllllIllIlIIIIllIIlIlI, final int lllllllllllllllIllIlIIIIllIIlIIl, final int lllllllllllllllIllIlIIIIllIIlIII) {
        this(lllllllllllllllIllIlIIIIllIlIlII, lllllllllllllllIllIlIIIIllIlIIll, lllllllllllllllIllIlIIIIllIIlIll, lllllllllllllllIllIlIIIIllIIlIlI, lllllllllllllllIllIlIIIIllIIlIII, 0, 1.0f, (float)lllllllllllllllIllIlIIIIllIIlIIl);
    }
    
    static {
        __OBFID = "CL_00001834";
    }
    
    public String getMessage() {
        return "";
    }
}
