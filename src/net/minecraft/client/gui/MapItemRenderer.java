package net.minecraft.client.gui;

import net.minecraft.world.storage.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.block.material.*;

public class MapItemRenderer
{
    private final /* synthetic */ Map loadedMaps;
    private final /* synthetic */ TextureManager textureManager;
    private static final /* synthetic */ ResourceLocation mapIcons;
    
    public void func_148250_a(final MapData lllllllllllllllIlIIIlIlIIlllIIII, final boolean lllllllllllllllIlIIIlIlIIllIllll) {
        this.func_148248_b(lllllllllllllllIlIIIlIlIIlllIIII).func_148237_a(lllllllllllllllIlIIIlIlIIllIllll);
    }
    
    public MapItemRenderer(final TextureManager lllllllllllllllIlIIIlIlIIllllIll) {
        this.loadedMaps = Maps.newHashMap();
        this.textureManager = lllllllllllllllIlIIIlIlIIllllIll;
    }
    
    private Instance func_148248_b(final MapData lllllllllllllllIlIIIlIlIIllIIlll) {
        Instance lllllllllllllllIlIIIlIlIIllIIllI = this.loadedMaps.get(lllllllllllllllIlIIIlIlIIllIIlll.mapName);
        if (lllllllllllllllIlIIIlIlIIllIIllI == null) {
            lllllllllllllllIlIIIlIlIIllIIllI = new Instance(lllllllllllllllIlIIIlIlIIllIIlll, null);
            this.loadedMaps.put(lllllllllllllllIlIIIlIlIIllIIlll.mapName, lllllllllllllllIlIIIlIlIIllIIllI);
        }
        return lllllllllllllllIlIIIlIlIIllIIllI;
    }
    
    public void func_148249_a() {
        for (final Instance lllllllllllllllIlIIIlIlIIlIlllIl : this.loadedMaps.values()) {
            this.textureManager.deleteTexture(lllllllllllllllIlIIIlIlIIlIlllIl.field_148240_d);
        }
        this.loadedMaps.clear();
    }
    
    public void func_148246_a(final MapData lllllllllllllllIlIIIlIlIIlllIlIl) {
        this.func_148248_b(lllllllllllllllIlIIIlIlIIlllIlIl).func_148236_a();
    }
    
    static {
        __OBFID = "CL_00000663";
        mapIcons = new ResourceLocation("textures/map/map_icons.png");
    }
    
    class Instance
    {
        private final /* synthetic */ DynamicTexture field_148243_c;
        private final /* synthetic */ int[] field_148241_e;
        private final /* synthetic */ MapData field_148242_b;
        private final /* synthetic */ ResourceLocation field_148240_d;
        
        Instance(final MapItemRenderer llllllllllllllIIIIlIIlIlIIIlIIlI, final MapData llllllllllllllIIIIlIIlIlIIIlIIIl, final Object llllllllllllllIIIIlIIlIlIIIlIlII) {
            this(llllllllllllllIIIIlIIlIlIIIlIIlI, llllllllllllllIIIIlIIlIlIIIlIIIl);
        }
        
        static {
            __OBFID = "CL_00000665";
        }
        
        private void func_148237_a(final boolean llllllllllllllIIIIlIIlIlIIlIIlll) {
            final byte llllllllllllllIIIIlIIlIlIIllIlIl = 0;
            final byte llllllllllllllIIIIlIIlIlIIllIlII = 0;
            final Tessellator llllllllllllllIIIIlIIlIlIIllIIll = Tessellator.getInstance();
            final WorldRenderer llllllllllllllIIIIlIIlIlIIllIIlI = llllllllllllllIIIIlIIlIlIIllIIll.getWorldRenderer();
            final float llllllllllllllIIIIlIIlIlIIllIIIl = 0.0f;
            MapItemRenderer.this.textureManager.bindTexture(this.field_148240_d);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(1, 771, 0, 1);
            GlStateManager.disableAlpha();
            llllllllllllllIIIIlIIlIlIIllIIlI.startDrawingQuads();
            llllllllllllllIIIIlIIlIlIIllIIlI.addVertexWithUV(llllllllllllllIIIIlIIlIlIIllIlIl + 0 + llllllllllllllIIIIlIIlIlIIllIIIl, llllllllllllllIIIIlIIlIlIIllIlII + 128 - llllllllllllllIIIIlIIlIlIIllIIIl, -0.009999999776482582, 0.0, 1.0);
            llllllllllllllIIIIlIIlIlIIllIIlI.addVertexWithUV(llllllllllllllIIIIlIIlIlIIllIlIl + 128 - llllllllllllllIIIIlIIlIlIIllIIIl, llllllllllllllIIIIlIIlIlIIllIlII + 128 - llllllllllllllIIIIlIIlIlIIllIIIl, -0.009999999776482582, 1.0, 1.0);
            llllllllllllllIIIIlIIlIlIIllIIlI.addVertexWithUV(llllllllllllllIIIIlIIlIlIIllIlIl + 128 - llllllllllllllIIIIlIIlIlIIllIIIl, llllllllllllllIIIIlIIlIlIIllIlII + 0 + llllllllllllllIIIIlIIlIlIIllIIIl, -0.009999999776482582, 1.0, 0.0);
            llllllllllllllIIIIlIIlIlIIllIIlI.addVertexWithUV(llllllllllllllIIIIlIIlIlIIllIlIl + 0 + llllllllllllllIIIIlIIlIlIIllIIIl, llllllllllllllIIIIlIIlIlIIllIlII + 0 + llllllllllllllIIIIlIIlIlIIllIIIl, -0.009999999776482582, 0.0, 0.0);
            llllllllllllllIIIIlIIlIlIIllIIll.draw();
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
            MapItemRenderer.this.textureManager.bindTexture(MapItemRenderer.mapIcons);
            int llllllllllllllIIIIlIIlIlIIllIIII = 0;
            for (final Vec4b llllllllllllllIIIIlIIlIlIIlIlllI : this.field_148242_b.playersVisibleOnMap.values()) {
                if (!llllllllllllllIIIIlIIlIlIIlIIlll || llllllllllllllIIIIlIIlIlIIlIlllI.func_176110_a() == 1) {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(llllllllllllllIIIIlIIlIlIIllIlIl + llllllllllllllIIIIlIIlIlIIlIlllI.func_176112_b() / 2.0f + 64.0f, llllllllllllllIIIIlIIlIlIIllIlII + llllllllllllllIIIIlIIlIlIIlIlllI.func_176113_c() / 2.0f + 64.0f, -0.02f);
                    GlStateManager.rotate(llllllllllllllIIIIlIIlIlIIlIlllI.func_176111_d() * 360 / 16.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.scale(4.0f, 4.0f, 3.0f);
                    GlStateManager.translate(-0.125f, 0.125f, 0.0f);
                    final byte llllllllllllllIIIIlIIlIlIIlIllIl = llllllllllllllIIIIlIIlIlIIlIlllI.func_176110_a();
                    final float llllllllllllllIIIIlIIlIlIIlIllII = (llllllllllllllIIIIlIIlIlIIlIllIl % 4 + 0) / 4.0f;
                    final float llllllllllllllIIIIlIIlIlIIlIlIll = (llllllllllllllIIIIlIIlIlIIlIllIl / 4 + 0) / 4.0f;
                    final float llllllllllllllIIIIlIIlIlIIlIlIlI = (llllllllllllllIIIIlIIlIlIIlIllIl % 4 + 1) / 4.0f;
                    final float llllllllllllllIIIIlIIlIlIIlIlIIl = (llllllllllllllIIIIlIIlIlIIlIllIl / 4 + 1) / 4.0f;
                    llllllllllllllIIIIlIIlIlIIllIIlI.startDrawingQuads();
                    llllllllllllllIIIIlIIlIlIIllIIlI.addVertexWithUV(-1.0, 1.0, llllllllllllllIIIIlIIlIlIIllIIII * 0.001f, llllllllllllllIIIIlIIlIlIIlIllII, llllllllllllllIIIIlIIlIlIIlIlIll);
                    llllllllllllllIIIIlIIlIlIIllIIlI.addVertexWithUV(1.0, 1.0, llllllllllllllIIIIlIIlIlIIllIIII * 0.001f, llllllllllllllIIIIlIIlIlIIlIlIlI, llllllllllllllIIIIlIIlIlIIlIlIll);
                    llllllllllllllIIIIlIIlIlIIllIIlI.addVertexWithUV(1.0, -1.0, llllllllllllllIIIIlIIlIlIIllIIII * 0.001f, llllllllllllllIIIIlIIlIlIIlIlIlI, llllllllllllllIIIIlIIlIlIIlIlIIl);
                    llllllllllllllIIIIlIIlIlIIllIIlI.addVertexWithUV(-1.0, -1.0, llllllllllllllIIIIlIIlIlIIllIIII * 0.001f, llllllllllllllIIIIlIIlIlIIlIllII, llllllllllllllIIIIlIIlIlIIlIlIIl);
                    llllllllllllllIIIIlIIlIlIIllIIll.draw();
                    GlStateManager.popMatrix();
                    ++llllllllllllllIIIIlIIlIlIIllIIII;
                }
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, -0.04f);
            GlStateManager.scale(1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
        
        private void func_148236_a() {
            for (int llllllllllllllIIIIlIIlIlIlIIlIll = 0; llllllllllllllIIIIlIIlIlIlIIlIll < 16384; ++llllllllllllllIIIIlIIlIlIlIIlIll) {
                final int llllllllllllllIIIIlIIlIlIlIIlIlI = this.field_148242_b.colors[llllllllllllllIIIIlIIlIlIlIIlIll] & 0xFF;
                if (llllllllllllllIIIIlIIlIlIlIIlIlI / 4 == 0) {
                    this.field_148241_e[llllllllllllllIIIIlIIlIlIlIIlIll] = (llllllllllllllIIIIlIIlIlIlIIlIll + llllllllllllllIIIIlIIlIlIlIIlIll / 128 & 0x1) * 8 + 16 << 24;
                }
                else {
                    this.field_148241_e[llllllllllllllIIIIlIIlIlIlIIlIll] = MapColor.mapColorArray[llllllllllllllIIIIlIIlIlIlIIlIlI / 4].func_151643_b(llllllllllllllIIIIlIIlIlIlIIlIlI & 0x3);
                }
            }
            this.field_148243_c.updateDynamicTexture();
        }
        
        private Instance(final MapData llllllllllllllIIIIlIIlIlIlIlIIIl) {
            this.field_148242_b = llllllllllllllIIIIlIIlIlIlIlIIIl;
            this.field_148243_c = new DynamicTexture(128, 128);
            this.field_148241_e = this.field_148243_c.getTextureData();
            this.field_148240_d = MapItemRenderer.this.textureManager.getDynamicTextureLocation(String.valueOf(new StringBuilder("map/").append(llllllllllllllIIIIlIIlIlIlIlIIIl.mapName)), this.field_148243_c);
            for (int llllllllllllllIIIIlIIlIlIlIlIlII = 0; llllllllllllllIIIIlIIlIlIlIlIlII < this.field_148241_e.length; ++llllllllllllllIIIIlIIlIlIlIlIlII) {
                this.field_148241_e[llllllllllllllIIIIlIIlIlIlIlIlII] = 0;
            }
        }
    }
}
