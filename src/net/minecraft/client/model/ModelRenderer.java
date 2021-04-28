package net.minecraft.client.model;

import optifine.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import com.google.common.collect.*;

public class ModelRenderer
{
    public /* synthetic */ float offsetY;
    private /* synthetic */ boolean compiled;
    public /* synthetic */ float textureHeight;
    public /* synthetic */ float textureWidth;
    public /* synthetic */ List childModels;
    public /* synthetic */ float rotationPointX;
    private /* synthetic */ int displayList;
    public final /* synthetic */ String boxName;
    public /* synthetic */ float rotationPointZ;
    public /* synthetic */ float rotationPointY;
    private /* synthetic */ ModelBase baseModel;
    public /* synthetic */ List spriteList;
    public /* synthetic */ float offsetZ;
    public /* synthetic */ float rotateAngleY;
    public /* synthetic */ List cubeList;
    /* synthetic */ float savedScale;
    public /* synthetic */ float rotateAngleZ;
    private /* synthetic */ int textureOffsetX;
    private /* synthetic */ int textureOffsetY;
    public /* synthetic */ float rotateAngleX;
    public /* synthetic */ boolean isHidden;
    public /* synthetic */ boolean showModel;
    public /* synthetic */ boolean mirrorV;
    public /* synthetic */ float offsetX;
    
    public void addSprite(final float lllllllllllllllllIIIlIllIIIIIIII, final float lllllllllllllllllIIIlIllIIIIIlll, final float lllllllllllllllllIIIlIllIIIIIllI, final int lllllllllllllllllIIIlIlIllllllIl, final int lllllllllllllllllIIIlIllIIIIIlII, final int lllllllllllllllllIIIlIlIlllllIll, final float lllllllllllllllllIIIlIlIlllllIlI) {
        this.spriteList.add(new ModelSprite(this, this.textureOffsetX, this.textureOffsetY, lllllllllllllllllIIIlIllIIIIIIII, lllllllllllllllllIIIlIllIIIIIlll, lllllllllllllllllIIIlIllIIIIIllI, lllllllllllllllllIIIlIlIllllllIl, lllllllllllllllllIIIlIllIIIIIlII, lllllllllllllllllIIIlIlIlllllIll, lllllllllllllllllIIIlIlIlllllIlI));
    }
    
    public void addBox(final float lllllllllllllllllIIIlIllIlIllIll, final float lllllllllllllllllIIIlIllIlIllIlI, final float lllllllllllllllllIIIlIllIlIlIIIl, final int lllllllllllllllllIIIlIllIlIlIIII, final int lllllllllllllllllIIIlIllIlIIllll, final int lllllllllllllllllIIIlIllIlIlIllI, final float lllllllllllllllllIIIlIllIlIlIlIl) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, lllllllllllllllllIIIlIllIlIllIll, lllllllllllllllllIIIlIllIlIllIlI, lllllllllllllllllIIIlIllIlIlIIIl, lllllllllllllllllIIIlIllIlIlIIII, lllllllllllllllllIIIlIllIlIIllll, lllllllllllllllllIIIlIllIlIlIllI, lllllllllllllllllIIIlIllIlIlIlIl));
    }
    
    public ModelRenderer(final ModelBase lllllllllllllllllIIIlIllllIIIIlI, final int lllllllllllllllllIIIlIlllIllllIl, final int lllllllllllllllllIIIlIlllIllllII) {
        this(lllllllllllllllllIIIlIllllIIIIlI);
        this.setTextureOffset(lllllllllllllllllIIIlIlllIllllIl, lllllllllllllllllIIIlIlllIllllII);
    }
    
    public void renderWithRotation(final float lllllllllllllllllIIIlIllIIllIIlI) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(lllllllllllllllllIIIlIllIIllIIlI);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(this.rotationPointX * lllllllllllllllllIIIlIllIIllIIlI, this.rotationPointY * lllllllllllllllllIIIlIllIIllIIlI, this.rotationPointZ * lllllllllllllllllIIIlIllIIllIIlI);
            if (this.rotateAngleY != 0.0f) {
                GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
            }
            if (this.rotateAngleX != 0.0f) {
                GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
            }
            if (this.rotateAngleZ != 0.0f) {
                GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
            }
            GlStateManager.callList(this.displayList);
            GlStateManager.popMatrix();
        }
    }
    
    static {
        __OBFID = "CL_00000874";
    }
    
    public ModelRenderer setTextureOffset(final int lllllllllllllllllIIIlIlllIllIIIl, final int lllllllllllllllllIIIlIlllIlIllIl) {
        this.textureOffsetX = lllllllllllllllllIIIlIlllIllIIIl;
        this.textureOffsetY = lllllllllllllllllIIIlIlllIlIllIl;
        return this;
    }
    
    public void setRotationPoint(final float lllllllllllllllllIIIlIllIlIIIlll, final float lllllllllllllllllIIIlIllIlIIIllI, final float lllllllllllllllllIIIlIllIlIIIIIl) {
        this.rotationPointX = lllllllllllllllllIIIlIllIlIIIlll;
        this.rotationPointY = lllllllllllllllllIIIlIllIlIIIllI;
        this.rotationPointZ = lllllllllllllllllIIIlIllIlIIIIIl;
    }
    
    private void compileDisplayList(final float lllllllllllllllllIIIlIllIIIllllI) {
        if (this.displayList == 0) {
            this.savedScale = lllllllllllllllllIIIlIllIIIllllI;
            this.displayList = GLAllocation.generateDisplayLists(1);
        }
        GL11.glNewList(this.displayList, 4864);
        final WorldRenderer lllllllllllllllllIIIlIllIIlIIIlI = Tessellator.getInstance().getWorldRenderer();
        for (int lllllllllllllllllIIIlIllIIlIIIIl = 0; lllllllllllllllllIIIlIllIIlIIIIl < this.cubeList.size(); ++lllllllllllllllllIIIlIllIIlIIIIl) {
            this.cubeList.get(lllllllllllllllllIIIlIllIIlIIIIl).render(lllllllllllllllllIIIlIllIIlIIIlI, lllllllllllllllllIIIlIllIIIllllI);
        }
        for (int lllllllllllllllllIIIlIllIIlIIIIl = 0; lllllllllllllllllIIIlIllIIlIIIIl < this.spriteList.size(); ++lllllllllllllllllIIIlIllIIlIIIIl) {
            final ModelSprite lllllllllllllllllIIIlIllIIlIIIII = this.spriteList.get(lllllllllllllllllIIIlIllIIlIIIIl);
            lllllllllllllllllIIIlIllIIlIIIII.render(Tessellator.getInstance(), lllllllllllllllllIIIlIllIIIllllI);
        }
        GL11.glEndList();
        this.compiled = true;
    }
    
    public ModelRenderer addBox(final float lllllllllllllllllIIIlIlllIIIlIIl, final float lllllllllllllllllIIIlIlllIIIIIIl, final float lllllllllllllllllIIIlIlllIIIIIII, final int lllllllllllllllllIIIlIllIlllllll, final int lllllllllllllllllIIIlIlllIIIIlIl, final int lllllllllllllllllIIIlIlllIIIIlII) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, lllllllllllllllllIIIlIlllIIIlIIl, lllllllllllllllllIIIlIlllIIIIIIl, lllllllllllllllllIIIlIlllIIIIIII, lllllllllllllllllIIIlIllIlllllll, lllllllllllllllllIIIlIlllIIIIlIl, lllllllllllllllllIIIlIlllIIIIlII, 0.0f));
        return this;
    }
    
    public ModelRenderer(final ModelBase lllllllllllllllllIIIlIllllIIllll, final String lllllllllllllllllIIIlIllllIIlllI) {
        this.spriteList = new ArrayList();
        this.mirrorV = false;
        this.textureWidth = 64.0f;
        this.textureHeight = 32.0f;
        this.showModel = true;
        this.cubeList = Lists.newArrayList();
        this.baseModel = lllllllllllllllllIIIlIllllIIllll;
        lllllllllllllllllIIIlIllllIIllll.boxList.add(this);
        this.boxName = lllllllllllllllllIIIlIllllIIlllI;
        this.setTextureSize(lllllllllllllllllIIIlIllllIIllll.textureWidth, lllllllllllllllllIIIlIllllIIllll.textureHeight);
    }
    
    public ModelRenderer setTextureSize(final int lllllllllllllllllIIIlIllIIIlIllI, final int lllllllllllllllllIIIlIllIIIlIIlI) {
        this.textureWidth = (float)lllllllllllllllllIIIlIllIIIlIllI;
        this.textureHeight = (float)lllllllllllllllllIIIlIllIIIlIIlI;
        return this;
    }
    
    public void resetDisplayList() {
        if (this.compiled) {
            this.compiled = false;
            this.compileDisplayList(this.savedScale);
        }
    }
    
    public int getDisplayList() {
        return this.displayList;
    }
    
    public boolean getCompiled() {
        return this.compiled;
    }
    
    public ModelRenderer addBox(String lllllllllllllllllIIIlIlllIIllIIl, final float lllllllllllllllllIIIlIlllIlIIIIl, final float lllllllllllllllllIIIlIlllIIlIlll, final float lllllllllllllllllIIIlIlllIIlIllI, final int lllllllllllllllllIIIlIlllIIlIlIl, final int lllllllllllllllllIIIlIlllIIlIlII, final int lllllllllllllllllIIIlIlllIIlllII) {
        lllllllllllllllllIIIlIlllIIllIIl = (float)String.valueOf(new StringBuilder(String.valueOf(this.boxName)).append(".").append((String)lllllllllllllllllIIIlIlllIIllIIl));
        final TextureOffset lllllllllllllllllIIIlIlllIIllIll = this.baseModel.getTextureOffset((String)lllllllllllllllllIIIlIlllIIllIIl);
        this.setTextureOffset(lllllllllllllllllIIIlIlllIIllIll.textureOffsetX, lllllllllllllllllIIIlIlllIIllIll.textureOffsetY);
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, lllllllllllllllllIIIlIlllIlIIIIl, lllllllllllllllllIIIlIlllIIlIlll, lllllllllllllllllIIIlIlllIIlIllI, lllllllllllllllllIIIlIlllIIlIlIl, lllllllllllllllllIIIlIlllIIlIlII, lllllllllllllllllIIIlIlllIIlllII, 0.0f).func_78244_a((String)lllllllllllllllllIIIlIlllIIllIIl));
        return this;
    }
    
    public void postRender(final float lllllllllllllllllIIIlIllIIlIlIlI) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(lllllllllllllllllIIIlIllIIlIlIlI);
            }
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX != 0.0f || this.rotationPointY != 0.0f || this.rotationPointZ != 0.0f) {
                    GlStateManager.translate(this.rotationPointX * lllllllllllllllllIIIlIllIIlIlIlI, this.rotationPointY * lllllllllllllllllIIIlIllIIlIlIlI, this.rotationPointZ * lllllllllllllllllIIIlIllIIlIlIlI);
                }
            }
            else {
                GlStateManager.translate(this.rotationPointX * lllllllllllllllllIIIlIllIIlIlIlI, this.rotationPointY * lllllllllllllllllIIIlIllIIlIlIlI, this.rotationPointZ * lllllllllllllllllIIIlIllIIlIlIlI);
                if (this.rotateAngleZ != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
            }
        }
    }
    
    public ModelRenderer addBox(final float lllllllllllllllllIIIlIllIlllIIll, final float lllllllllllllllllIIIlIllIllIlIlI, final float lllllllllllllllllIIIlIllIllIlIIl, final int lllllllllllllllllIIIlIllIllIlIII, final int lllllllllllllllllIIIlIllIllIIlll, final int lllllllllllllllllIIIlIllIllIIllI, final boolean lllllllllllllllllIIIlIllIllIIlIl) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, lllllllllllllllllIIIlIllIlllIIll, lllllllllllllllllIIIlIllIllIlIlI, lllllllllllllllllIIIlIllIllIlIIl, lllllllllllllllllIIIlIllIllIlIII, lllllllllllllllllIIIlIllIllIIlll, lllllllllllllllllIIIlIllIllIIllI, 0.0f, lllllllllllllllllIIIlIllIllIIlIl));
        return this;
    }
    
    public void render(final float lllllllllllllllllIIIlIllIIllllII) {
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(lllllllllllllllllIIIlIllIIllllII);
            }
            GlStateManager.translate(this.offsetX, this.offsetY, this.offsetZ);
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX == 0.0f && this.rotationPointY == 0.0f && this.rotationPointZ == 0.0f) {
                    GlStateManager.callList(this.displayList);
                    if (this.childModels != null) {
                        for (int lllllllllllllllllIIIlIllIIlllIll = 0; lllllllllllllllllIIIlIllIIlllIll < this.childModels.size(); ++lllllllllllllllllIIIlIllIIlllIll) {
                            this.childModels.get(lllllllllllllllllIIIlIllIIlllIll).render(lllllllllllllllllIIIlIllIIllllII);
                        }
                    }
                }
                else {
                    GlStateManager.translate(this.rotationPointX * lllllllllllllllllIIIlIllIIllllII, this.rotationPointY * lllllllllllllllllIIIlIllIIllllII, this.rotationPointZ * lllllllllllllllllIIIlIllIIllllII);
                    GlStateManager.callList(this.displayList);
                    if (this.childModels != null) {
                        for (int lllllllllllllllllIIIlIllIIlllIlI = 0; lllllllllllllllllIIIlIllIIlllIlI < this.childModels.size(); ++lllllllllllllllllIIIlIllIIlllIlI) {
                            this.childModels.get(lllllllllllllllllIIIlIllIIlllIlI).render(lllllllllllllllllIIIlIllIIllllII);
                        }
                    }
                    GlStateManager.translate(-this.rotationPointX * lllllllllllllllllIIIlIllIIllllII, -this.rotationPointY * lllllllllllllllllIIIlIllIIllllII, -this.rotationPointZ * lllllllllllllllllIIIlIllIIllllII);
                }
            }
            else {
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.rotationPointX * lllllllllllllllllIIIlIllIIllllII, this.rotationPointY * lllllllllllllllllIIIlIllIIllllII, this.rotationPointZ * lllllllllllllllllIIIlIllIIllllII);
                if (this.rotateAngleZ != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
                GlStateManager.callList(this.displayList);
                if (this.childModels != null) {
                    for (int lllllllllllllllllIIIlIllIIlllIIl = 0; lllllllllllllllllIIIlIllIIlllIIl < this.childModels.size(); ++lllllllllllllllllIIIlIllIIlllIIl) {
                        this.childModels.get(lllllllllllllllllIIIlIllIIlllIIl).render(lllllllllllllllllIIIlIllIIllllII);
                    }
                }
                GlStateManager.popMatrix();
            }
            GlStateManager.translate(-this.offsetX, -this.offsetY, -this.offsetZ);
        }
    }
    
    public void addChild(final ModelRenderer lllllllllllllllllIIIlIlllIllIllI) {
        if (this.childModels == null) {
            this.childModels = Lists.newArrayList();
        }
        this.childModels.add(lllllllllllllllllIIIlIlllIllIllI);
    }
    
    public ModelRenderer(final ModelBase lllllllllllllllllIIIlIllllIIlIlI) {
        this(lllllllllllllllllIIIlIllllIIlIlI, null);
    }
}
