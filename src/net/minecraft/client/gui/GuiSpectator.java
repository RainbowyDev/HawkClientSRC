package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.gui.spectator.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.gui.spectator.categories.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class GuiSpectator extends Gui implements ISpectatorMenuReciepient
{
    private static final /* synthetic */ ResourceLocation field_175267_f;
    public static final /* synthetic */ ResourceLocation field_175269_a;
    private /* synthetic */ long field_175270_h;
    private final /* synthetic */ Minecraft field_175268_g;
    private /* synthetic */ SpectatorMenu field_175271_i;
    
    static {
        __OBFID = "CL_00001940";
        field_175267_f = new ResourceLocation("textures/gui/widgets.png");
        field_175269_a = new ResourceLocation("textures/gui/spectator_widgets.png");
    }
    
    public void func_175259_b(final int llllllllllllllIlIlIllIIlIIllIIlI) {
        int llllllllllllllIlIlIllIIlIIllIIIl;
        for (llllllllllllllIlIlIllIIlIIllIIIl = this.field_175271_i.func_178648_e() + llllllllllllllIlIlIllIIlIIllIIlI; llllllllllllllIlIlIllIIlIIllIIIl >= 0 && llllllllllllllIlIlIllIIlIIllIIIl <= 8 && (this.field_175271_i.func_178643_a(llllllllllllllIlIlIllIIlIIllIIIl) == SpectatorMenu.field_178657_a || !this.field_175271_i.func_178643_a(llllllllllllllIlIlIllIIlIIllIIIl).func_178662_A_()); llllllllllllllIlIlIllIIlIIllIIIl += llllllllllllllIlIlIllIIlIIllIIlI) {}
        if (llllllllllllllIlIlIllIIlIIllIIIl >= 0 && llllllllllllllIlIlIllIIlIIllIIIl <= 8) {
            this.field_175271_i.func_178644_b(llllllllllllllIlIlIllIIlIIllIIIl);
            this.field_175270_h = Minecraft.getSystemTime();
        }
    }
    
    public boolean func_175262_a() {
        return this.field_175271_i != null;
    }
    
    @Override
    public void func_175257_a(final SpectatorMenu llllllllllllllIlIlIllIIlIIlllIll) {
        this.field_175271_i = null;
        this.field_175270_h = 0L;
    }
    
    public void func_175260_a(final int llllllllllllllIlIlIllIIllIlIIIIl) {
        this.field_175270_h = Minecraft.getSystemTime();
        if (this.field_175271_i != null) {
            this.field_175271_i.func_178644_b(llllllllllllllIlIlIllIIllIlIIIIl);
        }
        else {
            this.field_175271_i = new SpectatorMenu(this);
        }
    }
    
    public GuiSpectator(final Minecraft llllllllllllllIlIlIllIIllIlIIlll) {
        this.field_175268_g = llllllllllllllIlIlIllIIllIlIIlll;
    }
    
    private void func_175266_a(final int llllllllllllllIlIlIllIIlIllIIIll, final int llllllllllllllIlIlIllIIlIlIllIIl, final float llllllllllllllIlIlIllIIlIllIIIIl, final float llllllllllllllIlIlIllIIlIllIIIII, final ISpectatorMenuObject llllllllllllllIlIlIllIIlIlIlllll) {
        this.field_175268_g.getTextureManager().bindTexture(GuiSpectator.field_175269_a);
        if (llllllllllllllIlIlIllIIlIlIlllll != SpectatorMenu.field_178657_a) {
            final int llllllllllllllIlIlIllIIlIlIllllI = (int)(llllllllllllllIlIlIllIIlIllIIIII * 255.0f);
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)llllllllllllllIlIlIllIIlIlIllIIl, llllllllllllllIlIlIllIIlIllIIIIl, 0.0f);
            final float llllllllllllllIlIlIllIIlIlIlllIl = llllllllllllllIlIlIllIIlIlIlllll.func_178662_A_() ? 1.0f : 0.25f;
            GlStateManager.color(llllllllllllllIlIlIllIIlIlIlllIl, llllllllllllllIlIlIllIIlIlIlllIl, llllllllllllllIlIlIllIIlIlIlllIl, llllllllllllllIlIlIllIIlIllIIIII);
            llllllllllllllIlIlIllIIlIlIlllll.func_178663_a(llllllllllllllIlIlIllIIlIlIlllIl, llllllllllllllIlIlIllIIlIlIllllI);
            GlStateManager.popMatrix();
            final String llllllllllllllIlIlIllIIlIlIlllII = String.valueOf(GameSettings.getKeyDisplayString(this.field_175268_g.gameSettings.keyBindsHotbar[llllllllllllllIlIlIllIIlIllIIIll].getKeyCode()));
            if (llllllllllllllIlIlIllIIlIlIllllI > 3 && llllllllllllllIlIlIllIIlIlIlllll.func_178662_A_()) {
                this.field_175268_g.fontRendererObj.drawStringWithShadow(llllllllllllllIlIlIllIIlIlIlllII, (float)(llllllllllllllIlIlIllIIlIlIllIIl + 19 - 2 - this.field_175268_g.fontRendererObj.getStringWidth(llllllllllllllIlIlIllIIlIlIlllII)), llllllllllllllIlIlIllIIlIllIIIIl + 6.0f + 3.0f, 16777215 + (llllllllllllllIlIlIllIIlIlIllllI << 24));
            }
        }
    }
    
    protected void func_175258_a(final ScaledResolution llllllllllllllIlIlIllIIlIlllIIll, final float llllllllllllllIlIlIllIIlIllllIIl, final int llllllllllllllIlIlIllIIlIllllIII, final float llllllllllllllIlIlIllIIlIlllIlll, final SpectatorDetails llllllllllllllIlIlIllIIlIllIllll) {
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllllIlIlIllIIlIllllIIl);
        this.field_175268_g.getTextureManager().bindTexture(GuiSpectator.field_175267_f);
        this.func_175174_a((float)(llllllllllllllIlIlIllIIlIllllIII - 91), llllllllllllllIlIlIllIIlIlllIlll, 0, 0, 182, 22);
        if (llllllllllllllIlIlIllIIlIllIllll.func_178681_b() >= 0) {
            this.func_175174_a((float)(llllllllllllllIlIlIllIIlIllllIII - 91 - 1 + llllllllllllllIlIlIllIIlIllIllll.func_178681_b() * 20), llllllllllllllIlIlIllIIlIlllIlll - 1.0f, 0, 22, 24, 22);
        }
        RenderHelper.enableGUIStandardItemLighting();
        for (int llllllllllllllIlIlIllIIlIlllIlIl = 0; llllllllllllllIlIlIllIIlIlllIlIl < 9; ++llllllllllllllIlIlIllIIlIlllIlIl) {
            this.func_175266_a(llllllllllllllIlIlIllIIlIlllIlIl, llllllllllllllIlIlIllIIlIlllIIll.getScaledWidth() / 2 - 90 + llllllllllllllIlIlIllIIlIlllIlIl * 20 + 2, llllllllllllllIlIlIllIIlIlllIlll + 3.0f, llllllllllllllIlIlIllIIlIllllIIl, llllllllllllllIlIlIllIIlIllIllll.func_178680_a(llllllllllllllIlIlIllIIlIlllIlIl));
        }
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
    }
    
    public void func_175263_a(final ScaledResolution llllllllllllllIlIlIllIIlIlIIIIll) {
        final int llllllllllllllIlIlIllIIlIlIIlIIl = (int)(this.func_175265_c() * 255.0f);
        if (llllllllllllllIlIlIllIIlIlIIlIIl > 3 && this.field_175271_i != null) {
            final ISpectatorMenuObject llllllllllllllIlIlIllIIlIlIIlIII = this.field_175271_i.func_178645_b();
            final String llllllllllllllIlIlIllIIlIlIIIlll = (llllllllllllllIlIlIllIIlIlIIlIII != SpectatorMenu.field_178657_a) ? llllllllllllllIlIlIllIIlIlIIlIII.func_178664_z_().getFormattedText() : this.field_175271_i.func_178650_c().func_178670_b().getFormattedText();
            if (llllllllllllllIlIlIllIIlIlIIIlll != null) {
                final int llllllllllllllIlIlIllIIlIlIIIllI = (llllllllllllllIlIlIllIIlIlIIIIll.getScaledWidth() - this.field_175268_g.fontRendererObj.getStringWidth(llllllllllllllIlIlIllIIlIlIIIlll)) / 2;
                final int llllllllllllllIlIlIllIIlIlIIIlIl = llllllllllllllIlIlIllIIlIlIIIIll.getScaledHeight() - 35;
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                this.field_175268_g.fontRendererObj.drawStringWithShadow(llllllllllllllIlIlIllIIlIlIIIlll, (float)llllllllllllllIlIlIllIIlIlIIIllI, (float)llllllllllllllIlIlIllIIlIlIIIlIl, 16777215 + (llllllllllllllIlIlIllIIlIlIIlIIl << 24));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
        }
    }
    
    public void func_175261_b() {
        this.field_175270_h = Minecraft.getSystemTime();
        if (this.func_175262_a()) {
            final int llllllllllllllIlIlIllIIlIIlIlIlI = this.field_175271_i.func_178648_e();
            if (llllllllllllllIlIlIllIIlIIlIlIlI != -1) {
                this.field_175271_i.func_178644_b(llllllllllllllIlIlIllIIlIIlIlIlI);
            }
        }
        else {
            this.field_175271_i = new SpectatorMenu(this);
        }
    }
    
    public void func_175264_a(final ScaledResolution llllllllllllllIlIlIllIIllIIlIIII, final float llllllllllllllIlIlIllIIllIIIllll) {
        if (this.field_175271_i != null) {
            final float llllllllllllllIlIlIllIIllIIIlllI = this.func_175265_c();
            if (llllllllllllllIlIlIllIIllIIIlllI <= 0.0f) {
                this.field_175271_i.func_178641_d();
            }
            else {
                final int llllllllllllllIlIlIllIIllIIIllIl = llllllllllllllIlIlIllIIllIIlIIII.getScaledWidth() / 2;
                final float llllllllllllllIlIlIllIIllIIIllII = this.zLevel;
                this.zLevel = -90.0f;
                final float llllllllllllllIlIlIllIIllIIIlIll = llllllllllllllIlIlIllIIllIIlIIII.getScaledHeight() - 22.0f * llllllllllllllIlIlIllIIllIIIlllI;
                final SpectatorDetails llllllllllllllIlIlIllIIllIIIlIlI = this.field_175271_i.func_178646_f();
                this.func_175258_a(llllllllllllllIlIlIllIIllIIlIIII, llllllllllllllIlIlIllIIllIIIlllI, llllllllllllllIlIlIllIIllIIIllIl, llllllllllllllIlIlIllIIllIIIlIll, llllllllllllllIlIlIllIIllIIIlIlI);
                this.zLevel = llllllllllllllIlIlIllIIllIIIllII;
            }
        }
    }
    
    private float func_175265_c() {
        final long llllllllllllllIlIlIllIIllIIllIll = this.field_175270_h - Minecraft.getSystemTime() + 5000L;
        return MathHelper.clamp_float(llllllllllllllIlIlIllIIllIIllIll / 2000.0f, 0.0f, 1.0f);
    }
}
