package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.tileentity.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class TileEntityBannerRenderer extends TileEntitySpecialRenderer
{
    private static final /* synthetic */ Map field_178466_c;
    private /* synthetic */ ModelBanner field_178465_e;
    private static final /* synthetic */ ResourceLocation field_178464_d;
    
    private ResourceLocation func_178463_a(final TileEntityBanner lllllllllllllllllllIllIIlIIIlIlI) {
        final String lllllllllllllllllllIllIIlIIlIlIl = lllllllllllllllllllIllIIlIIIlIlI.func_175116_e();
        if (lllllllllllllllllllIllIIlIIlIlIl.isEmpty()) {
            return null;
        }
        TimedBannerTexture lllllllllllllllllllIllIIlIIlIlII = TileEntityBannerRenderer.field_178466_c.get(lllllllllllllllllllIllIIlIIlIlIl);
        if (lllllllllllllllllllIllIIlIIlIlII == null) {
            if (TileEntityBannerRenderer.field_178466_c.size() >= 256) {
                final long lllllllllllllllllllIllIIlIIlIIll = System.currentTimeMillis();
                final Iterator lllllllllllllllllllIllIIlIIlIIlI = TileEntityBannerRenderer.field_178466_c.keySet().iterator();
                while (lllllllllllllllllllIllIIlIIlIIlI.hasNext()) {
                    final String lllllllllllllllllllIllIIlIIlIIIl = lllllllllllllllllllIllIIlIIlIIlI.next();
                    final TimedBannerTexture lllllllllllllllllllIllIIlIIlIIII = TileEntityBannerRenderer.field_178466_c.get(lllllllllllllllllllIllIIlIIlIIIl);
                    if (lllllllllllllllllllIllIIlIIlIIll - lllllllllllllllllllIllIIlIIlIIII.field_178472_a > 60000L) {
                        Minecraft.getMinecraft().getTextureManager().deleteTexture(lllllllllllllllllllIllIIlIIlIIII.field_178471_b);
                        lllllllllllllllllllIllIIlIIlIIlI.remove();
                    }
                }
                if (TileEntityBannerRenderer.field_178466_c.size() >= 256) {
                    return null;
                }
            }
            final List lllllllllllllllllllIllIIlIIIllll = lllllllllllllllllllIllIIlIIIlIlI.func_175114_c();
            final List lllllllllllllllllllIllIIlIIIlllI = lllllllllllllllllllIllIIlIIIlIlI.func_175110_d();
            final ArrayList lllllllllllllllllllIllIIlIIIllIl = Lists.newArrayList();
            for (final TileEntityBanner.EnumBannerPattern lllllllllllllllllllIllIIlIIIlIll : lllllllllllllllllllIllIIlIIIllll) {
                lllllllllllllllllllIllIIlIIIllIl.add(String.valueOf(new StringBuilder("textures/entity/banner/").append(lllllllllllllllllllIllIIlIIIlIll.func_177271_a()).append(".png")));
            }
            lllllllllllllllllllIllIIlIIlIlII = new TimedBannerTexture(null);
            lllllllllllllllllllIllIIlIIlIlII.field_178471_b = new ResourceLocation(lllllllllllllllllllIllIIlIIlIlIl);
            Minecraft.getMinecraft().getTextureManager().loadTexture(lllllllllllllllllllIllIIlIIlIlII.field_178471_b, new LayeredColorMaskTexture(TileEntityBannerRenderer.field_178464_d, lllllllllllllllllllIllIIlIIIllIl, lllllllllllllllllllIllIIlIIIlllI));
            TileEntityBannerRenderer.field_178466_c.put(lllllllllllllllllllIllIIlIIlIlIl, lllllllllllllllllllIllIIlIIlIlII);
        }
        lllllllllllllllllllIllIIlIIlIlII.field_178472_a = System.currentTimeMillis();
        return lllllllllllllllllllIllIIlIIlIlII.field_178471_b;
    }
    
    static {
        __OBFID = "CL_00002473";
        field_178466_c = Maps.newHashMap();
        field_178464_d = new ResourceLocation("textures/entity/banner_base.png");
    }
    
    @Override
    public void renderTileEntityAt(final TileEntity lllllllllllllllllllIllIIIllllIlI, final double lllllllllllllllllllIllIIIlllIIlI, final double lllllllllllllllllllIllIIIlllIIIl, final double lllllllllllllllllllIllIIIlllIIII, final float lllllllllllllllllllIllIIIlllIllI, final int lllllllllllllllllllIllIIIllIlllI) {
        this.func_180545_a((TileEntityBanner)lllllllllllllllllllIllIIIllllIlI, lllllllllllllllllllIllIIIlllIIlI, lllllllllllllllllllIllIIIlllIIIl, lllllllllllllllllllIllIIIlllIIII, lllllllllllllllllllIllIIIlllIllI, lllllllllllllllllllIllIIIllIlllI);
    }
    
    public void func_180545_a(final TileEntityBanner lllllllllllllllllllIllIIlIlIllII, final double lllllllllllllllllllIllIIlIlIlIll, final double lllllllllllllllllllIllIIlIlllIll, final double lllllllllllllllllllIllIIlIlllIlI, final float lllllllllllllllllllIllIIlIlllIIl, final int lllllllllllllllllllIllIIlIlllIII) {
        final boolean lllllllllllllllllllIllIIlIllIlll = lllllllllllllllllllIllIIlIlIllII.getWorld() != null;
        final boolean lllllllllllllllllllIllIIlIllIllI = !lllllllllllllllllllIllIIlIllIlll || lllllllllllllllllllIllIIlIlIllII.getBlockType() == Blocks.standing_banner;
        final int lllllllllllllllllllIllIIlIllIlIl = lllllllllllllllllllIllIIlIllIlll ? lllllllllllllllllllIllIIlIlIllII.getBlockMetadata() : 0;
        final long lllllllllllllllllllIllIIlIllIlII = lllllllllllllllllllIllIIlIllIlll ? lllllllllllllllllllIllIIlIlIllII.getWorld().getTotalWorldTime() : 0L;
        GlStateManager.pushMatrix();
        final float lllllllllllllllllllIllIIlIllIIll = 0.6666667f;
        if (lllllllllllllllllllIllIIlIllIllI) {
            GlStateManager.translate((float)lllllllllllllllllllIllIIlIlIlIll + 0.5f, (float)lllllllllllllllllllIllIIlIlllIll + 0.75f * lllllllllllllllllllIllIIlIllIIll, (float)lllllllllllllllllllIllIIlIlllIlI + 0.5f);
            final float lllllllllllllllllllIllIIlIllIIII = lllllllllllllllllllIllIIlIllIlIl * 360 / 16.0f;
            GlStateManager.rotate(-lllllllllllllllllllIllIIlIllIIII, 0.0f, 1.0f, 0.0f);
            this.field_178465_e.bannerStand.showModel = true;
        }
        else {
            float lllllllllllllllllllIllIIlIllIIlI = 0.0f;
            if (lllllllllllllllllllIllIIlIllIlIl == 2) {
                lllllllllllllllllllIllIIlIllIIlI = 180.0f;
            }
            if (lllllllllllllllllllIllIIlIllIlIl == 4) {
                lllllllllllllllllllIllIIlIllIIlI = 90.0f;
            }
            if (lllllllllllllllllllIllIIlIllIlIl == 5) {
                lllllllllllllllllllIllIIlIllIIlI = -90.0f;
            }
            GlStateManager.translate((float)lllllllllllllllllllIllIIlIlIlIll + 0.5f, (float)lllllllllllllllllllIllIIlIlllIll - 0.25f * lllllllllllllllllllIllIIlIllIIll, (float)lllllllllllllllllllIllIIlIlllIlI + 0.5f);
            GlStateManager.rotate(-lllllllllllllllllllIllIIlIllIIlI, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.3125f, -0.4375f);
            this.field_178465_e.bannerStand.showModel = false;
        }
        final BlockPos lllllllllllllllllllIllIIlIlIllll = lllllllllllllllllllIllIIlIlIllII.getPos();
        final float lllllllllllllllllllIllIIlIllIIIl = lllllllllllllllllllIllIIlIlIllll.getX() * 7 + lllllllllllllllllllIllIIlIlIllll.getY() * 9 + lllllllllllllllllllIllIIlIlIllll.getZ() * 13 + (float)lllllllllllllllllllIllIIlIllIlII + lllllllllllllllllllIllIIlIlllIIl;
        this.field_178465_e.bannerSlate.rotateAngleX = (-0.0125f + 0.01f * MathHelper.cos(lllllllllllllllllllIllIIlIllIIIl * 3.1415927f * 0.02f)) * 3.1415927f;
        GlStateManager.enableRescaleNormal();
        final ResourceLocation lllllllllllllllllllIllIIlIlIlllI = this.func_178463_a(lllllllllllllllllllIllIIlIlIllII);
        if (lllllllllllllllllllIllIIlIlIlllI != null) {
            this.bindTexture(lllllllllllllllllllIllIIlIlIlllI);
            GlStateManager.pushMatrix();
            GlStateManager.scale(lllllllllllllllllllIllIIlIllIIll, -lllllllllllllllllllIllIIlIllIIll, -lllllllllllllllllllIllIIlIllIIll);
            this.field_178465_e.func_178687_a();
            GlStateManager.popMatrix();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
    }
    
    public TileEntityBannerRenderer() {
        this.field_178465_e = new ModelBanner();
    }
    
    static class TimedBannerTexture
    {
        public /* synthetic */ ResourceLocation field_178471_b;
        public /* synthetic */ long field_178472_a;
        
        private TimedBannerTexture() {
        }
        
        TimedBannerTexture(final Object lIlIIIIlIIlIll) {
            this();
        }
        
        static {
            __OBFID = "CL_00002471";
        }
    }
}
