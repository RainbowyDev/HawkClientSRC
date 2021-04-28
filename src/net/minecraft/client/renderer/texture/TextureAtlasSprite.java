package net.minecraft.client.renderer.texture;

import shadersmod.client.*;
import com.google.common.collect.*;
import java.util.concurrent.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;
import optifine.*;
import java.awt.image.*;
import net.minecraft.client.resources.data.*;
import java.util.*;
import java.io.*;
import net.minecraft.client.resources.*;

public class TextureAtlasSprite
{
    protected /* synthetic */ int[][] field_176605_b;
    private /* synthetic */ float maxV;
    private static /* synthetic */ String field_176607_p;
    protected /* synthetic */ int originY;
    private static /* synthetic */ String field_176606_q;
    protected /* synthetic */ int tickCounter;
    public /* synthetic */ int glSpriteTextureId;
    public /* synthetic */ int mipmapLevels;
    protected /* synthetic */ int width;
    private /* synthetic */ float minU;
    public /* synthetic */ float baseU;
    public /* synthetic */ float baseV;
    protected /* synthetic */ boolean rotated;
    protected /* synthetic */ int height;
    private /* synthetic */ float maxU;
    public /* synthetic */ int sheetWidth;
    protected /* synthetic */ int originX;
    protected /* synthetic */ int frameCounter;
    private final /* synthetic */ String iconName;
    public /* synthetic */ int sheetHeight;
    private /* synthetic */ float minV;
    private /* synthetic */ int indexInMap;
    protected /* synthetic */ List framesTextureData;
    public /* synthetic */ boolean isSpriteSingle;
    public /* synthetic */ TextureAtlasSprite spriteSingle;
    private /* synthetic */ AnimationMetadataSection animationMetadata;
    
    public double getSpriteV16(final float llllllllllllllllIIIlIIIllIIIIlll) {
        final float llllllllllllllllIIIlIIIllIIIIllI = this.maxV - this.minV;
        return (llllllllllllllllIIIlIIIllIIIIlll - this.minV) / llllllllllllllllIIIlIIIllIIIIllI * 16.0f;
    }
    
    public void copyFrom(final TextureAtlasSprite llllllllllllllllIIIlIIlIlIlllllI) {
        this.originX = llllllllllllllllIIIlIIlIlIlllllI.originX;
        this.originY = llllllllllllllllIIIlIIlIlIlllllI.originY;
        this.width = llllllllllllllllIIIlIIlIlIlllllI.width;
        this.height = llllllllllllllllIIIlIIlIlIlllllI.height;
        this.rotated = llllllllllllllllIIIlIIlIlIlllllI.rotated;
        this.minU = llllllllllllllllIIIlIIlIlIlllllI.minU;
        this.maxU = llllllllllllllllIIIlIIlIlIlllllI.maxU;
        this.minV = llllllllllllllllIIIlIIlIlIlllllI.minV;
        this.maxV = llllllllllllllllIIIlIIlIlIlllllI.maxV;
        if (this.spriteSingle != null) {
            this.spriteSingle.initSprite(this.width, this.height, 0, 0, false);
        }
    }
    
    public double getSpriteU16(final float llllllllllllllllIIIlIIIllIIlIIII) {
        final float llllllllllllllllIIIlIIIllIIIllll = this.maxU - this.minU;
        return (llllllllllllllllIIIlIIIllIIlIIII - this.minU) / llllllllllllllllIIIlIIIllIIIllll * 16.0f;
    }
    
    public void updateAnimation() {
        ++this.tickCounter;
        if (this.tickCounter >= this.animationMetadata.getFrameTimeSingle(this.frameCounter)) {
            final int llllllllllllllllIIIlIIlIlIIIIlll = this.animationMetadata.getFrameIndex(this.frameCounter);
            final int llllllllllllllllIIIlIIlIlIIIIllI = (this.animationMetadata.getFrameCount() == 0) ? this.framesTextureData.size() : this.animationMetadata.getFrameCount();
            this.frameCounter = (this.frameCounter + 1) % llllllllllllllllIIIlIIlIlIIIIllI;
            this.tickCounter = 0;
            final int llllllllllllllllIIIlIIlIlIIIIlIl = this.animationMetadata.getFrameIndex(this.frameCounter);
            final boolean llllllllllllllllIIIlIIlIlIIIIlII = false;
            final boolean llllllllllllllllIIIlIIlIlIIIIIll = this.isSpriteSingle;
            if (llllllllllllllllIIIlIIlIlIIIIlll != llllllllllllllllIIIlIIlIlIIIIlIl && llllllllllllllllIIIlIIlIlIIIIlIl >= 0 && llllllllllllllllIIIlIIlIlIIIIlIl < this.framesTextureData.size()) {
                if (Config.isShaders()) {
                    ShadersTex.uploadTexSub(this.framesTextureData.get(llllllllllllllllIIIlIIlIlIIIIlIl), this.width, this.height, this.originX, this.originY, llllllllllllllllIIIlIIlIlIIIIlII, llllllllllllllllIIIlIIlIlIIIIIll);
                }
                else {
                    TextureUtil.uploadTextureMipmap(this.framesTextureData.get(llllllllllllllllIIIlIIlIlIIIIlIl), this.width, this.height, this.originX, this.originY, llllllllllllllllIIIlIIlIlIIIIlII, llllllllllllllllIIIlIIlIlIIIIIll);
                }
            }
        }
        else if (this.animationMetadata.func_177219_e()) {
            this.func_180599_n();
        }
    }
    
    private void allocateFrameTextureData(final int llllllllllllllllIIIlIIIllllllIIl) {
        if (this.framesTextureData.size() <= llllllllllllllllIIIlIIIllllllIIl) {
            for (int llllllllllllllllIIIlIIIllllllIII = this.framesTextureData.size(); llllllllllllllllIIIlIIIllllllIII <= llllllllllllllllIIIlIIIllllllIIl; ++llllllllllllllllIIIlIIIllllllIII) {
                this.framesTextureData.add(null);
            }
        }
        if (this.spriteSingle != null) {
            this.spriteSingle.allocateFrameTextureData(llllllllllllllllIIIlIIIllllllIIl);
        }
    }
    
    public float getMaxV() {
        return this.maxV;
    }
    
    public void initSprite(final int llllllllllllllllIIIlIIlIllIIlIII, final int llllllllllllllllIIIlIIlIllIIllll, final int llllllllllllllllIIIlIIlIllIIIllI, final int llllllllllllllllIIIlIIlIllIIIlIl, final boolean llllllllllllllllIIIlIIlIllIIllII) {
        this.originX = llllllllllllllllIIIlIIlIllIIIllI;
        this.originY = llllllllllllllllIIIlIIlIllIIIlIl;
        this.rotated = llllllllllllllllIIIlIIlIllIIllII;
        final float llllllllllllllllIIIlIIlIllIIlIll = (float)(0.009999999776482582 / llllllllllllllllIIIlIIlIllIIlIII);
        final float llllllllllllllllIIIlIIlIllIIlIlI = (float)(0.009999999776482582 / llllllllllllllllIIIlIIlIllIIllll);
        this.minU = llllllllllllllllIIIlIIlIllIIIllI / (float)llllllllllllllllIIIlIIlIllIIlIII + llllllllllllllllIIIlIIlIllIIlIll;
        this.maxU = (llllllllllllllllIIIlIIlIllIIIllI + this.width) / (float)llllllllllllllllIIIlIIlIllIIlIII - llllllllllllllllIIIlIIlIllIIlIll;
        this.minV = llllllllllllllllIIIlIIlIllIIIlIl / (float)llllllllllllllllIIIlIIlIllIIllll + llllllllllllllllIIIlIIlIllIIlIlI;
        this.maxV = (llllllllllllllllIIIlIIlIllIIIlIl + this.height) / (float)llllllllllllllllIIIlIIlIllIIllll - llllllllllllllllIIIlIIlIllIIlIlI;
        this.baseU = Math.min(this.minU, this.maxU);
        this.baseV = Math.min(this.minV, this.maxV);
        if (this.spriteSingle != null) {
            this.spriteSingle.initSprite(this.width, this.height, 0, 0, false);
        }
    }
    
    public float getMinV() {
        return this.minV;
    }
    
    public float getInterpolatedV(final double llllllllllllllllIIIlIIlIlIIlIIll) {
        final float llllllllllllllllIIIlIIlIlIIlIlIl = this.maxV - this.minV;
        return this.minV + llllllllllllllllIIIlIIlIlIIlIlIl * ((float)llllllllllllllllIIIlIIlIlIIlIIll / 16.0f);
    }
    
    public void deleteSpriteTexture() {
        if (this.glSpriteTextureId >= 0) {
            TextureUtil.deleteTexture(this.glSpriteTextureId);
            this.glSpriteTextureId = -1;
        }
    }
    
    private void resetSprite() {
        this.animationMetadata = null;
        this.setFramesTextureData(Lists.newArrayList());
        this.frameCounter = 0;
        this.tickCounter = 0;
        if (this.spriteSingle != null) {
            this.spriteSingle.resetSprite();
        }
    }
    
    public float toSingleV(float llllllllllllllllIIIlIIIlIllIllII) {
        llllllllllllllllIIIlIIIlIllIllII -= this.baseV;
        final float llllllllllllllllIIIlIIIlIllIlllI = this.sheetHeight / (float)this.height;
        llllllllllllllllIIIlIIIlIllIllII *= llllllllllllllllIIIlIIIlIllIlllI;
        return llllllllllllllllIIIlIIIlIllIllII;
    }
    
    private void fixTransparentColor(final int[] llllllllllllllllIIIlIIIllIllIIIl) {
        if (llllllllllllllllIIIlIIIllIllIIIl != null) {
            long llllllllllllllllIIIlIIIllIllIIII = 0L;
            long llllllllllllllllIIIlIIIllIlIllll = 0L;
            long llllllllllllllllIIIlIIIllIlIlllI = 0L;
            long llllllllllllllllIIIlIIIllIlIllIl = 0L;
            for (int llllllllllllllllIIIlIIIllIlIllII = 0; llllllllllllllllIIIlIIIllIlIllII < llllllllllllllllIIIlIIIllIllIIIl.length; ++llllllllllllllllIIIlIIIllIlIllII) {
                final int llllllllllllllllIIIlIIIllIlIlIll = llllllllllllllllIIIlIIIllIllIIIl[llllllllllllllllIIIlIIIllIlIllII];
                final int llllllllllllllllIIIlIIIllIlIlIIl = llllllllllllllllIIIlIIIllIlIlIll >> 24 & 0xFF;
                if (llllllllllllllllIIIlIIIllIlIlIIl >= 16) {
                    final int llllllllllllllllIIIlIIIllIlIIlll = llllllllllllllllIIIlIIIllIlIlIll >> 16 & 0xFF;
                    final int llllllllllllllllIIIlIIIllIlIIlIl = llllllllllllllllIIIlIIIllIlIlIll >> 8 & 0xFF;
                    final int llllllllllllllllIIIlIIIllIlIIIll = llllllllllllllllIIIlIIIllIlIlIll & 0xFF;
                    llllllllllllllllIIIlIIIllIllIIII += llllllllllllllllIIIlIIIllIlIIlll;
                    llllllllllllllllIIIlIIIllIlIllll += llllllllllllllllIIIlIIIllIlIIlIl;
                    llllllllllllllllIIIlIIIllIlIlllI += llllllllllllllllIIIlIIIllIlIIIll;
                    ++llllllllllllllllIIIlIIIllIlIllIl;
                }
            }
            if (llllllllllllllllIIIlIIIllIlIllIl > 0L) {
                final int llllllllllllllllIIIlIIIllIlIllII = (int)(llllllllllllllllIIIlIIIllIllIIII / llllllllllllllllIIIlIIIllIlIllIl);
                final int llllllllllllllllIIIlIIIllIlIlIlI = (int)(llllllllllllllllIIIlIIIllIlIllll / llllllllllllllllIIIlIIIllIlIllIl);
                final int llllllllllllllllIIIlIIIllIlIlIII = (int)(llllllllllllllllIIIlIIIllIlIlllI / llllllllllllllllIIIlIIIllIlIllIl);
                final int llllllllllllllllIIIlIIIllIlIIllI = llllllllllllllllIIIlIIIllIlIllII << 16 | llllllllllllllllIIIlIIIllIlIlIlI << 8 | llllllllllllllllIIIlIIIllIlIlIII;
                for (int llllllllllllllllIIIlIIIllIlIIlII = 0; llllllllllllllllIIIlIIIllIlIIlII < llllllllllllllllIIIlIIIllIllIIIl.length; ++llllllllllllllllIIIlIIIllIlIIlII) {
                    final int llllllllllllllllIIIlIIIllIlIIIlI = llllllllllllllllIIIlIIIllIllIIIl[llllllllllllllllIIIlIIIllIlIIlII];
                    final int llllllllllllllllIIIlIIIllIlIIIIl = llllllllllllllllIIIlIIIllIlIIIlI >> 24 & 0xFF;
                    if (llllllllllllllllIIIlIIIllIlIIIIl <= 16) {
                        llllllllllllllllIIIlIIIllIllIIIl[llllllllllllllllIIIlIIIllIlIIlII] = llllllllllllllllIIIlIIIllIlIIllI;
                    }
                }
            }
        }
    }
    
    public void setFramesTextureData(final List llllllllllllllllIIIlIIIlllIlIllI) {
        this.framesTextureData = llllllllllllllllIIIlIIIlllIlIllI;
        if (this.spriteSingle != null) {
            this.spriteSingle.setFramesTextureData(llllllllllllllllIIIlIIIlllIlIllI);
        }
    }
    
    private void func_180599_n() {
        final double llllllllllllllllIIIlIIlIIllIllIl = 1.0 - this.tickCounter / (double)this.animationMetadata.getFrameTimeSingle(this.frameCounter);
        final int llllllllllllllllIIIlIIlIIllIllII = this.animationMetadata.getFrameIndex(this.frameCounter);
        final int llllllllllllllllIIIlIIlIIllIlIll = (this.animationMetadata.getFrameCount() == 0) ? this.framesTextureData.size() : this.animationMetadata.getFrameCount();
        final int llllllllllllllllIIIlIIlIIllIlIlI = this.animationMetadata.getFrameIndex((this.frameCounter + 1) % llllllllllllllllIIIlIIlIIllIlIll);
        if (llllllllllllllllIIIlIIlIIllIllII != llllllllllllllllIIIlIIlIIllIlIlI && llllllllllllllllIIIlIIlIIllIlIlI >= 0 && llllllllllllllllIIIlIIlIIllIlIlI < this.framesTextureData.size()) {
            final int[][] llllllllllllllllIIIlIIlIIllIlIIl = this.framesTextureData.get(llllllllllllllllIIIlIIlIIllIllII);
            final int[][] llllllllllllllllIIIlIIlIIllIlIII = this.framesTextureData.get(llllllllllllllllIIIlIIlIIllIlIlI);
            if (this.field_176605_b == null || this.field_176605_b.length != llllllllllllllllIIIlIIlIIllIlIIl.length) {
                this.field_176605_b = new int[llllllllllllllllIIIlIIlIIllIlIIl.length][];
            }
            for (int llllllllllllllllIIIlIIlIIllIIlll = 0; llllllllllllllllIIIlIIlIIllIIlll < llllllllllllllllIIIlIIlIIllIlIIl.length; ++llllllllllllllllIIIlIIlIIllIIlll) {
                if (this.field_176605_b[llllllllllllllllIIIlIIlIIllIIlll] == null) {
                    this.field_176605_b[llllllllllllllllIIIlIIlIIllIIlll] = new int[llllllllllllllllIIIlIIlIIllIlIIl[llllllllllllllllIIIlIIlIIllIIlll].length];
                }
                if (llllllllllllllllIIIlIIlIIllIIlll < llllllllllllllllIIIlIIlIIllIlIII.length && llllllllllllllllIIIlIIlIIllIlIII[llllllllllllllllIIIlIIlIIllIIlll].length == llllllllllllllllIIIlIIlIIllIlIIl[llllllllllllllllIIIlIIlIIllIIlll].length) {
                    for (int llllllllllllllllIIIlIIlIIllIIllI = 0; llllllllllllllllIIIlIIlIIllIIllI < llllllllllllllllIIIlIIlIIllIlIIl[llllllllllllllllIIIlIIlIIllIIlll].length; ++llllllllllllllllIIIlIIlIIllIIllI) {
                        final int llllllllllllllllIIIlIIlIIllIIlIl = llllllllllllllllIIIlIIlIIllIlIIl[llllllllllllllllIIIlIIlIIllIIlll][llllllllllllllllIIIlIIlIIllIIllI];
                        final int llllllllllllllllIIIlIIlIIllIIlII = llllllllllllllllIIIlIIlIIllIlIII[llllllllllllllllIIIlIIlIIllIIlll][llllllllllllllllIIIlIIlIIllIIllI];
                        final int llllllllllllllllIIIlIIlIIllIIIll = (int)(((llllllllllllllllIIIlIIlIIllIIlIl & 0xFF0000) >> 16) * llllllllllllllllIIIlIIlIIllIllIl + ((llllllllllllllllIIIlIIlIIllIIlII & 0xFF0000) >> 16) * (1.0 - llllllllllllllllIIIlIIlIIllIllIl));
                        final int llllllllllllllllIIIlIIlIIllIIIlI = (int)(((llllllllllllllllIIIlIIlIIllIIlIl & 0xFF00) >> 8) * llllllllllllllllIIIlIIlIIllIllIl + ((llllllllllllllllIIIlIIlIIllIIlII & 0xFF00) >> 8) * (1.0 - llllllllllllllllIIIlIIlIIllIllIl));
                        final int llllllllllllllllIIIlIIlIIllIIIIl = (int)((llllllllllllllllIIIlIIlIIllIIlIl & 0xFF) * llllllllllllllllIIIlIIlIIllIllIl + (llllllllllllllllIIIlIIlIIllIIlII & 0xFF) * (1.0 - llllllllllllllllIIIlIIlIIllIllIl));
                        this.field_176605_b[llllllllllllllllIIIlIIlIIllIIlll][llllllllllllllllIIIlIIlIIllIIllI] = ((llllllllllllllllIIIlIIlIIllIIlIl & 0xFF000000) | llllllllllllllllIIIlIIlIIllIIIll << 16 | llllllllllllllllIIIlIIlIIllIIIlI << 8 | llllllllllllllllIIIlIIlIIllIIIIl);
                    }
                }
            }
            TextureUtil.uploadTextureMipmap(this.field_176605_b, this.width, this.height, this.originX, this.originY, false, false);
        }
    }
    
    public float getInterpolatedU(final double llllllllllllllllIIIlIIlIlIlIIIlI) {
        final float llllllllllllllllIIIlIIlIlIlIIlII = this.maxU - this.minU;
        return this.minU + llllllllllllllllIIIlIIlIlIlIIlII * (float)llllllllllllllllIIIlIIlIlIlIIIlI / 16.0f;
    }
    
    public int getOriginY() {
        return this.originY;
    }
    
    public boolean hasAnimationMetadata() {
        return this.animationMetadata != null;
    }
    
    public int getIconWidth() {
        return this.width;
    }
    
    public float getMinU() {
        return this.minU;
    }
    
    public void setIndexInMap(final int llllllllllllllllIIIlIIIlllIIIIIl) {
        this.indexInMap = llllllllllllllllIIIlIIIlllIIIIIl;
    }
    
    public void generateMipmaps(final int llllllllllllllllIIIlIIlIIIIIllII) {
        final ArrayList llllllllllllllllIIIlIIlIIIIIlIll = Lists.newArrayList();
        for (int llllllllllllllllIIIlIIlIIIIIlIlI = 0; llllllllllllllllIIIlIIlIIIIIlIlI < this.framesTextureData.size(); ++llllllllllllllllIIIlIIlIIIIIlIlI) {
            final int[][] llllllllllllllllIIIlIIlIIIIIlIIl = this.framesTextureData.get(llllllllllllllllIIIlIIlIIIIIlIlI);
            if (llllllllllllllllIIIlIIlIIIIIlIIl != null) {
                try {
                    llllllllllllllllIIIlIIlIIIIIlIll.add(TextureUtil.generateMipmapData(llllllllllllllllIIIlIIlIIIIIllII, this.width, llllllllllllllllIIIlIIlIIIIIlIIl));
                }
                catch (Throwable llllllllllllllllIIIlIIlIIIIIlIII) {
                    final CrashReport llllllllllllllllIIIlIIlIIIIIIlll = CrashReport.makeCrashReport(llllllllllllllllIIIlIIlIIIIIlIII, "Generating mipmaps for frame");
                    final CrashReportCategory llllllllllllllllIIIlIIlIIIIIIllI = llllllllllllllllIIIlIIlIIIIIIlll.makeCategory("Frame being iterated");
                    llllllllllllllllIIIlIIlIIIIIIllI.addCrashSection("Frame index", llllllllllllllllIIIlIIlIIIIIlIlI);
                    llllllllllllllllIIIlIIlIIIIIIllI.addCrashSectionCallable("Frame sizes", new Callable() {
                        @Override
                        public String call() {
                            final StringBuilder llllllllllllllllIllIlIIllllIllII = new StringBuilder();
                            for (final int[] llllllllllllllllIllIlIIllllIlIII : llllllllllllllllIIIlIIlIIIIIlIIl) {
                                if (llllllllllllllllIllIlIIllllIllII.length() > 0) {
                                    llllllllllllllllIllIlIIllllIllII.append(", ");
                                }
                                llllllllllllllllIllIlIIllllIllII.append((llllllllllllllllIllIlIIllllIlIII == null) ? "null" : Integer.valueOf(llllllllllllllllIllIlIIllllIlIII.length));
                            }
                            return String.valueOf(llllllllllllllllIllIlIIllllIllII);
                        }
                        
                        static {
                            __OBFID = "CL_00001063";
                        }
                    });
                    throw new ReportedException(llllllllllllllllIIIlIIlIIIIIIlll);
                }
            }
        }
        this.setFramesTextureData(llllllllllllllllIIIlIIlIIIIIlIll);
        if (this.spriteSingle != null) {
            this.spriteSingle.generateMipmaps(llllllllllllllllIIIlIIlIIIIIllII);
        }
    }
    
    public int getIconHeight() {
        return this.height;
    }
    
    public static void func_176603_b(final String llllllllllllllllIIIlIIlIllIllIlI) {
        TextureAtlasSprite.field_176606_q = llllllllllllllllIIIlIIlIllIllIlI;
    }
    
    public int getIndexInMap() {
        return this.indexInMap;
    }
    
    protected static TextureAtlasSprite func_176604_a(final ResourceLocation llllllllllllllllIIIlIIlIlllIIIIl) {
        final String llllllllllllllllIIIlIIlIlllIIIlI = llllllllllllllllIIIlIIlIlllIIIIl.toString();
        return TextureAtlasSprite.field_176607_p.equals(llllllllllllllllIIIlIIlIlllIIIlI) ? new TextureClock(llllllllllllllllIIIlIIlIlllIIIlI) : (TextureAtlasSprite.field_176606_q.equals(llllllllllllllllIIIlIIlIlllIIIlI) ? new TextureCompass(llllllllllllllllIIIlIIlIlllIIIlI) : new TextureAtlasSprite(llllllllllllllllIIIlIIlIlllIIIlI));
    }
    
    public void bindSpriteTexture() {
        if (this.glSpriteTextureId < 0) {
            this.glSpriteTextureId = TextureUtil.glGenTextures();
            TextureUtil.func_180600_a(this.glSpriteTextureId, this.mipmapLevels, this.width, this.height);
            TextureUtils.applyAnisotropicLevel();
        }
        TextureUtils.bindTexture(this.glSpriteTextureId);
    }
    
    private static int[][] getFrameTextureData(final int[][] llllllllllllllllIIIlIIIllllIIllI, final int llllllllllllllllIIIlIIIllllIllII, final int llllllllllllllllIIIlIIIllllIlIll, final int llllllllllllllllIIIlIIIllllIlIlI) {
        final int[][] llllllllllllllllIIIlIIIllllIlIIl = new int[llllllllllllllllIIIlIIIllllIIllI.length][];
        for (int llllllllllllllllIIIlIIIllllIlIII = 0; llllllllllllllllIIIlIIIllllIlIII < llllllllllllllllIIIlIIIllllIIllI.length; ++llllllllllllllllIIIlIIIllllIlIII) {
            final int[] llllllllllllllllIIIlIIIllllIIlll = llllllllllllllllIIIlIIIllllIIllI[llllllllllllllllIIIlIIIllllIlIII];
            if (llllllllllllllllIIIlIIIllllIIlll != null) {
                llllllllllllllllIIIlIIIllllIlIIl[llllllllllllllllIIIlIIIllllIlIII] = new int[(llllllllllllllllIIIlIIIllllIllII >> llllllllllllllllIIIlIIIllllIlIII) * (llllllllllllllllIIIlIIIllllIlIll >> llllllllllllllllIIIlIIIllllIlIII)];
                System.arraycopy(llllllllllllllllIIIlIIIllllIIlll, llllllllllllllllIIIlIIIllllIlIlI * llllllllllllllllIIIlIIIllllIlIIl[llllllllllllllllIIIlIIIllllIlIII].length, llllllllllllllllIIIlIIIllllIlIIl[llllllllllllllllIIIlIIIllllIlIII], 0, llllllllllllllllIIIlIIIllllIlIIl[llllllllllllllllIIIlIIIllllIlIII].length);
            }
        }
        return llllllllllllllllIIIlIIIllllIlIIl;
    }
    
    public int[][] getFrameTextureData(final int llllllllllllllllIIIlIIlIIlIIllll) {
        return this.framesTextureData.get(llllllllllllllllIIIlIIlIIlIIllll);
    }
    
    public float toSingleU(float llllllllllllllllIIIlIIIlIlllIlIl) {
        llllllllllllllllIIIlIIIlIlllIlIl -= (short)this.baseU;
        final float llllllllllllllllIIIlIIIlIlllIlll = this.sheetWidth / (float)this.width;
        llllllllllllllllIIIlIIIlIlllIlIl *= (short)llllllllllllllllIIIlIIIlIlllIlll;
        return llllllllllllllllIIIlIIIlIlllIlIl;
    }
    
    public void setIconHeight(final int llllllllllllllllIIIlIIlIIIlllllI) {
        this.height = llllllllllllllllIIIlIIlIIIlllllI;
        if (this.spriteSingle != null) {
            this.spriteSingle.setIconHeight(this.height);
        }
    }
    
    protected TextureAtlasSprite(final String llllllllllllllllIIIlIIlIlllIlIII) {
        this.framesTextureData = Lists.newArrayList();
        this.indexInMap = -1;
        this.glSpriteTextureId = -1;
        this.spriteSingle = null;
        this.isSpriteSingle = false;
        this.mipmapLevels = 0;
        this.iconName = llllllllllllllllIIIlIIlIlllIlIII;
        if (Config.isMultiTexture()) {
            this.spriteSingle = new TextureAtlasSprite(this);
        }
    }
    
    static {
        __OBFID = "CL_00001062";
        TextureAtlasSprite.field_176607_p = "builtin/clock";
        TextureAtlasSprite.field_176606_q = "builtin/compass";
    }
    
    public int getFrameCount() {
        return this.framesTextureData.size();
    }
    
    private TextureAtlasSprite(final TextureAtlasSprite llllllllllllllllIIIlIIlIlllIllII) {
        this.framesTextureData = Lists.newArrayList();
        this.indexInMap = -1;
        this.glSpriteTextureId = -1;
        this.spriteSingle = null;
        this.isSpriteSingle = false;
        this.mipmapLevels = 0;
        this.iconName = llllllllllllllllIIIlIIlIlllIllII.iconName;
        this.isSpriteSingle = true;
    }
    
    public String getIconName() {
        return this.iconName;
    }
    
    public void func_180598_a(final BufferedImage[] llllllllllllllllIIIlIIlIIIIlllll, final AnimationMetadataSection llllllllllllllllIIIlIIlIIIIllllI) throws IOException {
        this.resetSprite();
        final int llllllllllllllllIIIlIIlIIIlIllll = llllllllllllllllIIIlIIlIIIIlllll[0].getWidth();
        final int llllllllllllllllIIIlIIlIIIlIlllI = llllllllllllllllIIIlIIlIIIIlllll[0].getHeight();
        this.width = llllllllllllllllIIIlIIlIIIlIllll;
        this.height = llllllllllllllllIIIlIIlIIIlIlllI;
        final int[][] llllllllllllllllIIIlIIlIIIlIllIl = new int[llllllllllllllllIIIlIIlIIIIlllll.length][];
        for (int llllllllllllllllIIIlIIlIIIlIllII = 0; llllllllllllllllIIIlIIlIIIlIllII < llllllllllllllllIIIlIIlIIIIlllll.length; ++llllllllllllllllIIIlIIlIIIlIllII) {
            final BufferedImage llllllllllllllllIIIlIIlIIIlIlIll = llllllllllllllllIIIlIIlIIIIlllll[llllllllllllllllIIIlIIlIIIlIllII];
            if (llllllllllllllllIIIlIIlIIIlIlIll != null) {
                if (llllllllllllllllIIIlIIlIIIlIllII > 0 && (llllllllllllllllIIIlIIlIIIlIlIll.getWidth() != llllllllllllllllIIIlIIlIIIlIllll >> llllllllllllllllIIIlIIlIIIlIllII || llllllllllllllllIIIlIIlIIIlIlIll.getHeight() != llllllllllllllllIIIlIIlIIIlIlllI >> llllllllllllllllIIIlIIlIIIlIllII)) {
                    throw new RuntimeException(String.format("Unable to load miplevel: %d, image is size: %dx%d, expected %dx%d", llllllllllllllllIIIlIIlIIIlIllII, llllllllllllllllIIIlIIlIIIlIlIll.getWidth(), llllllllllllllllIIIlIIlIIIlIlIll.getHeight(), llllllllllllllllIIIlIIlIIIlIllll >> llllllllllllllllIIIlIIlIIIlIllII, llllllllllllllllIIIlIIlIIIlIlllI >> llllllllllllllllIIIlIIlIIIlIllII));
                }
                llllllllllllllllIIIlIIlIIIlIllIl[llllllllllllllllIIIlIIlIIIlIllII] = new int[llllllllllllllllIIIlIIlIIIlIlIll.getWidth() * llllllllllllllllIIIlIIlIIIlIlIll.getHeight()];
                llllllllllllllllIIIlIIlIIIlIlIll.getRGB(0, 0, llllllllllllllllIIIlIIlIIIlIlIll.getWidth(), llllllllllllllllIIIlIIlIIIlIlIll.getHeight(), llllllllllllllllIIIlIIlIIIlIllIl[llllllllllllllllIIIlIIlIIIlIllII], 0, llllllllllllllllIIIlIIlIIIlIlIll.getWidth());
            }
        }
        if (llllllllllllllllIIIlIIlIIIIllllI == null) {
            if (llllllllllllllllIIIlIIlIIIlIlllI != llllllllllllllllIIIlIIlIIIlIllll) {
                throw new RuntimeException("broken aspect ratio and not an animation");
            }
            this.framesTextureData.add(llllllllllllllllIIIlIIlIIIlIllIl);
        }
        else {
            final int llllllllllllllllIIIlIIlIIIlIllII = llllllllllllllllIIIlIIlIIIlIlllI / llllllllllllllllIIIlIIlIIIlIllll;
            final int llllllllllllllllIIIlIIlIIIlIIlll = llllllllllllllllIIIlIIlIIIlIllll;
            final int llllllllllllllllIIIlIIlIIIlIIlIl = llllllllllllllllIIIlIIlIIIlIllll;
            this.height = this.width;
            if (llllllllllllllllIIIlIIlIIIIllllI.getFrameCount() > 0) {
                for (final int llllllllllllllllIIIlIIlIIIlIlIlI : llllllllllllllllIIIlIIlIIIIllllI.getFrameIndexSet()) {
                    if (llllllllllllllllIIIlIIlIIIlIlIlI >= llllllllllllllllIIIlIIlIIIlIllII) {
                        throw new RuntimeException(String.valueOf(new StringBuilder("invalid frameindex ").append(llllllllllllllllIIIlIIlIIIlIlIlI)));
                    }
                    this.allocateFrameTextureData(llllllllllllllllIIIlIIlIIIlIlIlI);
                    this.framesTextureData.set(llllllllllllllllIIIlIIlIIIlIlIlI, getFrameTextureData(llllllllllllllllIIIlIIlIIIlIllIl, llllllllllllllllIIIlIIlIIIlIIlll, llllllllllllllllIIIlIIlIIIlIIlIl, llllllllllllllllIIIlIIlIIIlIlIlI));
                }
                this.animationMetadata = llllllllllllllllIIIlIIlIIIIllllI;
            }
            else {
                final ArrayList llllllllllllllllIIIlIIlIIIlIIIll = Lists.newArrayList();
                for (int llllllllllllllllIIIlIIlIIIlIlIIl = 0; llllllllllllllllIIIlIIlIIIlIlIIl < llllllllllllllllIIIlIIlIIIlIllII; ++llllllllllllllllIIIlIIlIIIlIlIIl) {
                    this.framesTextureData.add(getFrameTextureData(llllllllllllllllIIIlIIlIIIlIllIl, llllllllllllllllIIIlIIlIIIlIIlll, llllllllllllllllIIIlIIlIIIlIIlIl, llllllllllllllllIIIlIIlIIIlIlIIl));
                    llllllllllllllllIIIlIIlIIIlIIIll.add(new AnimationFrame(llllllllllllllllIIIlIIlIIIlIlIIl, -1));
                }
                this.animationMetadata = new AnimationMetadataSection(llllllllllllllllIIIlIIlIIIlIIIll, this.width, this.height, llllllllllllllllIIIlIIlIIIIllllI.getFrameTime(), llllllllllllllllIIIlIIlIIIIllllI.func_177219_e());
            }
        }
        for (int llllllllllllllllIIIlIIlIIIlIIllI = 0; llllllllllllllllIIIlIIlIIIlIIllI < this.framesTextureData.size(); ++llllllllllllllllIIIlIIlIIIlIIllI) {
            final int[][] llllllllllllllllIIIlIIlIIIlIIIlI = this.framesTextureData.get(llllllllllllllllIIIlIIlIIIlIIllI);
            if (llllllllllllllllIIIlIIlIIIlIIIlI != null && !this.iconName.startsWith("minecraft:blocks/leaves_")) {
                for (int llllllllllllllllIIIlIIlIIIlIlIII = 0; llllllllllllllllIIIlIIlIIIlIlIII < llllllllllllllllIIIlIIlIIIlIIIlI.length; ++llllllllllllllllIIIlIIlIIIlIlIII) {
                    final int[] llllllllllllllllIIIlIIlIIIlIIIIl = llllllllllllllllIIIlIIlIIIlIIIlI[llllllllllllllllIIIlIIlIIIlIlIII];
                    this.fixTransparentColor(llllllllllllllllIIIlIIlIIIlIIIIl);
                }
            }
        }
        if (this.spriteSingle != null) {
            this.spriteSingle.func_180598_a(llllllllllllllllIIIlIIlIIIIlllll, llllllllllllllllIIIlIIlIIIIllllI);
        }
    }
    
    public boolean load(final IResourceManager llllllllllllllllIIIlIIIlllIIlIIl, final ResourceLocation llllllllllllllllIIIlIIIlllIIlIII) {
        return true;
    }
    
    public int getOriginX() {
        return this.originX;
    }
    
    public float getMaxU() {
        return this.maxU;
    }
    
    public boolean hasCustomLoader(final IResourceManager llllllllllllllllIIIlIIIlllIIllII, final ResourceLocation llllllllllllllllIIIlIIIlllIIlIll) {
        return false;
    }
    
    public void setIconWidth(final int llllllllllllllllIIIlIIlIIlIIIlII) {
        this.width = llllllllllllllllIIIlIIlIIlIIIlII;
        if (this.spriteSingle != null) {
            this.spriteSingle.setIconWidth(this.width);
        }
    }
    
    public void clearFramesTextureData() {
        this.framesTextureData.clear();
        if (this.spriteSingle != null) {
            this.spriteSingle.clearFramesTextureData();
        }
    }
    
    public static void func_176602_a(final String llllllllllllllllIIIlIIlIllIlllIl) {
        TextureAtlasSprite.field_176607_p = llllllllllllllllIIIlIIlIllIlllIl;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("TextureAtlasSprite{name='").append(this.iconName).append('\'').append(", frameCount=").append(this.framesTextureData.size()).append(", rotated=").append(this.rotated).append(", x=").append(this.originX).append(", y=").append(this.originY).append(", height=").append(this.height).append(", width=").append(this.width).append(", u0=").append(this.minU).append(", u1=").append(this.maxU).append(", v0=").append(this.minV).append(", v1=").append(this.maxV).append('}'));
    }
}
