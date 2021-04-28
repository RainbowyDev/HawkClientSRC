package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;

public class TileEntityRendererDispatcher
{
    public /* synthetic */ float field_147563_i;
    public /* synthetic */ float field_147562_h;
    public /* synthetic */ double field_147558_l;
    private /* synthetic */ FontRenderer field_147557_n;
    public static /* synthetic */ TileEntityRendererDispatcher instance;
    public /* synthetic */ TextureManager renderEngine;
    public static /* synthetic */ double staticPlayerY;
    public /* synthetic */ double field_147561_k;
    public /* synthetic */ double field_147560_j;
    public /* synthetic */ Entity field_147551_g;
    private /* synthetic */ Map mapSpecialRenderers;
    public static /* synthetic */ double staticPlayerZ;
    public /* synthetic */ World worldObj;
    public static /* synthetic */ double staticPlayerX;
    
    public TileEntitySpecialRenderer getSpecialRenderer(final TileEntity llllllllllllllIlIIIlIllIlllIIIIl) {
        return (llllllllllllllIlIIIlIllIlllIIIIl == null) ? null : this.getSpecialRendererByClass(llllllllllllllIlIIIlIllIlllIIIIl.getClass());
    }
    
    static {
        __OBFID = "CL_00000963";
        TileEntityRendererDispatcher.instance = new TileEntityRendererDispatcher();
    }
    
    private TileEntityRendererDispatcher() {
        this.mapSpecialRenderers = Maps.newHashMap();
        this.mapSpecialRenderers.put(TileEntitySign.class, new TileEntitySignRenderer());
        this.mapSpecialRenderers.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
        this.mapSpecialRenderers.put(TileEntityPiston.class, new TileEntityPistonRenderer());
        this.mapSpecialRenderers.put(TileEntityChest.class, new TileEntityChestRenderer());
        this.mapSpecialRenderers.put(TileEntityEnderChest.class, new TileEntityEnderChestRenderer());
        this.mapSpecialRenderers.put(TileEntityEnchantmentTable.class, new TileEntityEnchantmentTableRenderer());
        this.mapSpecialRenderers.put(TileEntityEndPortal.class, new TileEntityEndPortalRenderer());
        this.mapSpecialRenderers.put(TileEntityBeacon.class, new TileEntityBeaconRenderer());
        this.mapSpecialRenderers.put(TileEntitySkull.class, new TileEntitySkullRenderer());
        this.mapSpecialRenderers.put(TileEntityBanner.class, new TileEntityBannerRenderer());
        for (final TileEntitySpecialRenderer llllllllllllllIlIIIlIllIlllllIIl : this.mapSpecialRenderers.values()) {
            llllllllllllllIlIIIlIllIlllllIIl.setRendererDispatcher(this);
        }
    }
    
    public FontRenderer getFontRenderer() {
        return this.field_147557_n;
    }
    
    public void func_178470_a(final World llllllllllllllIlIIIlIllIllIlIIll, final TextureManager llllllllllllllIlIIIlIllIllIllIII, final FontRenderer llllllllllllllIlIIIlIllIllIlIlll, final Entity llllllllllllllIlIIIlIllIllIlIIII, final float llllllllllllllIlIIIlIllIllIlIlIl) {
        if (this.worldObj != llllllllllllllIlIIIlIllIllIlIIll) {
            this.func_147543_a(llllllllllllllIlIIIlIllIllIlIIll);
        }
        this.renderEngine = llllllllllllllIlIIIlIllIllIllIII;
        this.field_147551_g = llllllllllllllIlIIIlIllIllIlIIII;
        this.field_147557_n = llllllllllllllIlIIIlIllIllIlIlll;
        this.field_147562_h = llllllllllllllIlIIIlIllIllIlIIII.prevRotationYaw + (llllllllllllllIlIIIlIllIllIlIIII.rotationYaw - llllllllllllllIlIIIlIllIllIlIIII.prevRotationYaw) * llllllllllllllIlIIIlIllIllIlIlIl;
        this.field_147563_i = llllllllllllllIlIIIlIllIllIlIIII.prevRotationPitch + (llllllllllllllIlIIIlIllIllIlIIII.rotationPitch - llllllllllllllIlIIIlIllIllIlIIII.prevRotationPitch) * llllllllllllllIlIIIlIllIllIlIlIl;
        this.field_147560_j = llllllllllllllIlIIIlIllIllIlIIII.lastTickPosX + (llllllllllllllIlIIIlIllIllIlIIII.posX - llllllllllllllIlIIIlIllIllIlIIII.lastTickPosX) * llllllllllllllIlIIIlIllIllIlIlIl;
        this.field_147561_k = llllllllllllllIlIIIlIllIllIlIIII.lastTickPosY + (llllllllllllllIlIIIlIllIllIlIIII.posY - llllllllllllllIlIIIlIllIllIlIIII.lastTickPosY) * llllllllllllllIlIIIlIllIllIlIlIl;
        this.field_147558_l = llllllllllllllIlIIIlIllIllIlIIII.lastTickPosZ + (llllllllllllllIlIIIlIllIllIlIIII.posZ - llllllllllllllIlIIIlIllIllIlIIII.lastTickPosZ) * llllllllllllllIlIIIlIllIllIlIlIl;
    }
    
    public void func_180546_a(final TileEntity llllllllllllllIlIIIlIllIllIIIlIl, final float llllllllllllllIlIIIlIllIlIllllII, final int llllllllllllllIlIIIlIllIlIlllIll) {
        if (llllllllllllllIlIIIlIllIllIIIlIl.getDistanceSq(this.field_147560_j, this.field_147561_k, this.field_147558_l) < llllllllllllllIlIIIlIllIllIIIlIl.getMaxRenderDistanceSquared()) {
            final int llllllllllllllIlIIIlIllIllIIIIlI = this.worldObj.getCombinedLight(llllllllllllllIlIIIlIllIllIIIlIl.getPos(), 0);
            final int llllllllllllllIlIIIlIllIllIIIIIl = llllllllllllllIlIIIlIllIllIIIIlI % 65536;
            final int llllllllllllllIlIIIlIllIllIIIIII = llllllllllllllIlIIIlIllIllIIIIlI / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, llllllllllllllIlIIIlIllIllIIIIIl / 1.0f, llllllllllllllIlIIIlIllIllIIIIII / 1.0f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos llllllllllllllIlIIIlIllIlIllllll = llllllllllllllIlIIIlIllIllIIIlIl.getPos();
            this.func_178469_a(llllllllllllllIlIIIlIllIllIIIlIl, llllllllllllllIlIIIlIllIlIllllll.getX() - TileEntityRendererDispatcher.staticPlayerX, llllllllllllllIlIIIlIllIlIllllll.getY() - TileEntityRendererDispatcher.staticPlayerY, llllllllllllllIlIIIlIllIlIllllll.getZ() - TileEntityRendererDispatcher.staticPlayerZ, llllllllllllllIlIIIlIllIlIllllII, llllllllllllllIlIIIlIllIlIlllIll);
        }
    }
    
    public void func_178469_a(final TileEntity llllllllllllllIlIIIlIllIlIIllIII, final double llllllllllllllIlIIIlIllIlIIIllII, final double llllllllllllllIlIIIlIllIlIIlIllI, final double llllllllllllllIlIIIlIllIlIIIlIlI, final float llllllllllllllIlIIIlIllIlIIlIlII, final int llllllllllllllIlIIIlIllIlIIlIIll) {
        final TileEntitySpecialRenderer llllllllllllllIlIIIlIllIlIIlIIlI = this.getSpecialRenderer(llllllllllllllIlIIIlIllIlIIllIII);
        if (llllllllllllllIlIIIlIllIlIIlIIlI != null) {
            try {
                llllllllllllllIlIIIlIllIlIIlIIlI.renderTileEntityAt(llllllllllllllIlIIIlIllIlIIllIII, llllllllllllllIlIIIlIllIlIIIllII, llllllllllllllIlIIIlIllIlIIlIllI, llllllllllllllIlIIIlIllIlIIIlIlI, llllllllllllllIlIIIlIllIlIIlIlII, llllllllllllllIlIIIlIllIlIIlIIll);
            }
            catch (Throwable llllllllllllllIlIIIlIllIlIIlIIIl) {
                final CrashReport llllllllllllllIlIIIlIllIlIIlIIII = CrashReport.makeCrashReport(llllllllllllllIlIIIlIllIlIIlIIIl, "Rendering Block Entity");
                final CrashReportCategory llllllllllllllIlIIIlIllIlIIIllll = llllllllllllllIlIIIlIllIlIIlIIII.makeCategory("Block Entity Details");
                llllllllllllllIlIIIlIllIlIIllIII.addInfoToCrashReport(llllllllllllllIlIIIlIllIlIIIllll);
                throw new ReportedException(llllllllllllllIlIIIlIllIlIIlIIII);
            }
        }
    }
    
    public boolean hasSpecialRenderer(final TileEntity llllllllllllllIlIIIlIllIlllIlIIl) {
        return this.getSpecialRenderer(llllllllllllllIlIIIlIllIlllIlIIl) != null;
    }
    
    public void func_147543_a(final World llllllllllllllIlIIIlIllIIllllllI) {
        this.worldObj = llllllllllllllIlIIIlIllIIllllllI;
    }
    
    public void renderTileEntityAt(final TileEntity llllllllllllllIlIIIlIllIlIlIlIIl, final double llllllllllllllIlIIIlIllIlIlIlllI, final double llllllllllllllIlIIIlIllIlIlIIlll, final double llllllllllllllIlIIIlIllIlIlIllII, final float llllllllllllllIlIIIlIllIlIlIIlIl) {
        this.func_178469_a(llllllllllllllIlIIIlIllIlIlIlIIl, llllllllllllllIlIIIlIllIlIlIlllI, llllllllllllllIlIIIlIllIlIlIIlll, llllllllllllllIlIIIlIllIlIlIllII, llllllllllllllIlIIIlIllIlIlIIlIl, -1);
    }
    
    public TileEntitySpecialRenderer getSpecialRendererByClass(final Class llllllllllllllIlIIIlIllIllllIIIl) {
        TileEntitySpecialRenderer llllllllllllllIlIIIlIllIllllIIII = (TileEntitySpecialRenderer)this.mapSpecialRenderers.get(llllllllllllllIlIIIlIllIllllIIIl);
        if (llllllllllllllIlIIIlIllIllllIIII == null && llllllllllllllIlIIIlIllIllllIIIl != TileEntity.class) {
            llllllllllllllIlIIIlIllIllllIIII = this.getSpecialRendererByClass(llllllllllllllIlIIIlIllIllllIIIl.getSuperclass());
            this.mapSpecialRenderers.put(llllllllllllllIlIIIlIllIllllIIIl, llllllllllllllIlIIIlIllIllllIIII);
        }
        return llllllllllllllIlIIIlIllIllllIIII;
    }
}
