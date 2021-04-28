package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.util.*;

public class ScaledResolution
{
    private final /* synthetic */ double scaledWidthD;
    private /* synthetic */ int scaledHeight;
    private /* synthetic */ int scaledWidth;
    private /* synthetic */ int scaleFactor;
    private final /* synthetic */ double scaledHeightD;
    
    public double getScaledWidth_double() {
        return this.scaledWidthD;
    }
    
    public double getScaledHeight_double() {
        return this.scaledHeightD;
    }
    
    static {
        __OBFID = "CL_00000666";
    }
    
    public int getScaledWidth() {
        return this.scaledWidth;
    }
    
    public int getScaleFactor() {
        return this.scaleFactor;
    }
    
    public int getScaledHeight() {
        return this.scaledHeight;
    }
    
    public ScaledResolution(final Minecraft lllllllllllllllIllIIIIIllIlIlIll, final int lllllllllllllllIllIIIIIllIlIlIlI, final int lllllllllllllllIllIIIIIllIlIIIll) {
        this.scaledWidth = lllllllllllllllIllIIIIIllIlIlIlI;
        this.scaledHeight = lllllllllllllllIllIIIIIllIlIIIll;
        this.scaleFactor = 1;
        final boolean lllllllllllllllIllIIIIIllIlIlIII = lllllllllllllllIllIIIIIllIlIlIll.isUnicode();
        int lllllllllllllllIllIIIIIllIlIIlll = lllllllllllllllIllIIIIIllIlIlIll.gameSettings.guiScale;
        if (lllllllllllllllIllIIIIIllIlIIlll == 0) {
            lllllllllllllllIllIIIIIllIlIIlll = 1000;
        }
        while (this.scaleFactor < lllllllllllllllIllIIIIIllIlIIlll && this.scaledWidth / (this.scaleFactor + 1) >= 320 && this.scaledHeight / (this.scaleFactor + 1) >= 240) {
            ++this.scaleFactor;
        }
        if (lllllllllllllllIllIIIIIllIlIlIII && this.scaleFactor % 2 != 0 && this.scaleFactor != 1) {
            --this.scaleFactor;
        }
        this.scaledWidthD = this.scaledWidth / (double)this.scaleFactor;
        this.scaledHeightD = this.scaledHeight / (double)this.scaleFactor;
        this.scaledWidth = MathHelper.ceiling_double_int(this.scaledWidthD);
        this.scaledHeight = MathHelper.ceiling_double_int(this.scaledHeightD);
    }
}
