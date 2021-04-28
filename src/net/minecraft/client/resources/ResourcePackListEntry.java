package net.minecraft.client.resources;

import net.minecraft.util.*;
import net.minecraft.client.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;

public abstract class ResourcePackListEntry implements GuiListExtended.IGuiListEntry
{
    protected final /* synthetic */ GuiScreenResourcePacks field_148315_b;
    private static final /* synthetic */ ResourceLocation field_148316_c;
    protected final /* synthetic */ Minecraft field_148317_a;
    
    protected boolean func_148314_g() {
        final List llllllllllllllIlIlllllIIIllIIllI = this.field_148315_b.func_146962_b(this);
        final int llllllllllllllIlIlllllIIIllIIlIl = llllllllllllllIlIlllllIIIllIIllI.indexOf(this);
        return llllllllllllllIlIlllllIIIllIIlIl > 0 && llllllllllllllIlIlllllIIIllIIllI.get(llllllllllllllIlIlllllIIIllIIlIl - 1).func_148310_d();
    }
    
    static {
        __OBFID = "CL_00000821";
        field_148316_c = new ResourceLocation("textures/gui/resource_packs.png");
    }
    
    @Override
    public void setSelected(final int llllllllllllllIlIlllllIIIlIIIIlI, final int llllllllllllllIlIlllllIIIlIIIIIl, final int llllllllllllllIlIlllllIIIlIIIIII) {
    }
    
    protected abstract void func_148313_c();
    
    protected boolean func_148307_h() {
        final List llllllllllllllIlIlllllIIIlIlllIl = this.field_148315_b.func_146962_b(this);
        final int llllllllllllllIlIlllllIIIlIlllII = llllllllllllllIlIlllllIIIlIlllIl.indexOf(this);
        return llllllllllllllIlIlllllIIIlIlllII >= 0 && llllllllllllllIlIlllllIIIlIlllII < llllllllllllllIlIlllllIIIlIlllIl.size() - 1 && llllllllllllllIlIlllllIIIlIlllIl.get(llllllllllllllIlIlllllIIIlIlllII + 1).func_148310_d();
    }
    
    protected boolean func_148310_d() {
        return true;
    }
    
    public ResourcePackListEntry(final GuiScreenResourcePacks llllllllllllllIlIlllllIIlIIlIlll) {
        this.field_148315_b = llllllllllllllIlIlllllIIlIIlIlll;
        this.field_148317_a = Minecraft.getMinecraft();
    }
    
    protected boolean func_148308_f() {
        return this.field_148315_b.hasResourcePackEntry(this);
    }
    
    protected boolean func_148309_e() {
        return !this.field_148315_b.hasResourcePackEntry(this);
    }
    
    @Override
    public void drawEntry(final int llllllllllllllIlIlllllIIlIIIlIIl, final int llllllllllllllIlIlllllIIlIIIlIII, final int llllllllllllllIlIlllllIIIllllIIl, final int llllllllllllllIlIlllllIIlIIIIllI, final int llllllllllllllIlIlllllIIlIIIIlIl, final int llllllllllllllIlIlllllIIlIIIIlII, final int llllllllllllllIlIlllllIIIlllIlll, final boolean llllllllllllllIlIlllllIIlIIIIIlI) {
        this.func_148313_c();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Gui.drawModalRectWithCustomSizedTexture(llllllllllllllIlIlllllIIlIIIlIII, llllllllllllllIlIlllllIIIllllIIl, 0.0f, 0.0f, 32, 32, 32.0f, 32.0f);
        if ((this.field_148317_a.gameSettings.touchscreen || llllllllllllllIlIlllllIIlIIIIIlI) && this.func_148310_d()) {
            this.field_148317_a.getTextureManager().bindTexture(ResourcePackListEntry.field_148316_c);
            Gui.drawRect(llllllllllllllIlIlllllIIlIIIlIII, llllllllllllllIlIlllllIIIllllIIl, llllllllllllllIlIlllllIIlIIIlIII + 32, llllllllllllllIlIlllllIIIllllIIl + 32, -1601138544);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final int llllllllllllllIlIlllllIIIlllllll = llllllllllllllIlIlllllIIlIIIIlII - llllllllllllllIlIlllllIIlIIIlIII;
            final int llllllllllllllIlIlllllIIlIIIIIIl = llllllllllllllIlIlllllIIIlllIlll - llllllllllllllIlIlllllIIIllllIIl;
            if (this.func_148309_e()) {
                if (llllllllllllllIlIlllllIIIlllllll < 32) {
                    Gui.drawModalRectWithCustomSizedTexture(llllllllllllllIlIlllllIIlIIIlIII, llllllllllllllIlIlllllIIIllllIIl, 0.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture(llllllllllllllIlIlllllIIlIIIlIII, llllllllllllllIlIlllllIIIllllIIl, 0.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
            else {
                if (this.func_148308_f()) {
                    if (llllllllllllllIlIlllllIIIlllllll < 16) {
                        Gui.drawModalRectWithCustomSizedTexture(llllllllllllllIlIlllllIIlIIIlIII, llllllllllllllIlIlllllIIIllllIIl, 32.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                    }
                    else {
                        Gui.drawModalRectWithCustomSizedTexture(llllllllllllllIlIlllllIIlIIIlIII, llllllllllllllIlIlllllIIIllllIIl, 32.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                    }
                }
                if (this.func_148314_g()) {
                    if (llllllllllllllIlIlllllIIIlllllll < 32 && llllllllllllllIlIlllllIIIlllllll > 16 && llllllllllllllIlIlllllIIlIIIIIIl < 16) {
                        Gui.drawModalRectWithCustomSizedTexture(llllllllllllllIlIlllllIIlIIIlIII, llllllllllllllIlIlllllIIIllllIIl, 96.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                    }
                    else {
                        Gui.drawModalRectWithCustomSizedTexture(llllllllllllllIlIlllllIIlIIIlIII, llllllllllllllIlIlllllIIIllllIIl, 96.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                    }
                }
                if (this.func_148307_h()) {
                    if (llllllllllllllIlIlllllIIIlllllll < 32 && llllllllllllllIlIlllllIIIlllllll > 16 && llllllllllllllIlIlllllIIlIIIIIIl > 16) {
                        Gui.drawModalRectWithCustomSizedTexture(llllllllllllllIlIlllllIIlIIIlIII, llllllllllllllIlIlllllIIIllllIIl, 64.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                    }
                    else {
                        Gui.drawModalRectWithCustomSizedTexture(llllllllllllllIlIlllllIIlIIIlIII, llllllllllllllIlIlllllIIIllllIIl, 64.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                    }
                }
            }
        }
        String llllllllllllllIlIlllllIIIllllllI = this.func_148312_b();
        final int llllllllllllllIlIlllllIIlIIIIIII = this.field_148317_a.fontRendererObj.getStringWidth(llllllllllllllIlIlllllIIIllllllI);
        if (llllllllllllllIlIlllllIIlIIIIIII > 157) {
            llllllllllllllIlIlllllIIIllllllI = String.valueOf(new StringBuilder(String.valueOf(this.field_148317_a.fontRendererObj.trimStringToWidth(llllllllllllllIlIlllllIIIllllllI, 157 - this.field_148317_a.fontRendererObj.getStringWidth("...")))).append("..."));
        }
        this.field_148317_a.fontRendererObj.drawStringWithShadow(llllllllllllllIlIlllllIIIllllllI, (float)(llllllllllllllIlIlllllIIlIIIlIII + 32 + 2), (float)(llllllllllllllIlIlllllIIIllllIIl + 1), 16777215);
        final List llllllllllllllIlIlllllIIIlllllIl = this.field_148317_a.fontRendererObj.listFormattedStringToWidth(this.func_148311_a(), 157);
        for (int llllllllllllllIlIlllllIIIlllllII = 0; llllllllllllllIlIlllllIIIlllllII < 2 && llllllllllllllIlIlllllIIIlllllII < llllllllllllllIlIlllllIIIlllllIl.size(); ++llllllllllllllIlIlllllIIIlllllII) {
            this.field_148317_a.fontRendererObj.drawStringWithShadow(llllllllllllllIlIlllllIIIlllllIl.get(llllllllllllllIlIlllllIIIlllllII), (float)(llllllllllllllIlIlllllIIlIIIlIII + 32 + 2), (float)(llllllllllllllIlIlllllIIIllllIIl + 12 + 10 * llllllllllllllIlIlllllIIIlllllII), 8421504);
        }
    }
    
    protected abstract String func_148312_b();
    
    protected abstract String func_148311_a();
    
    @Override
    public boolean mousePressed(final int llllllllllllllIlIlllllIIIlIlIIlI, final int llllllllllllllIlIlllllIIIlIlIIIl, final int llllllllllllllIlIlllllIIIlIlIIII, final int llllllllllllllIlIlllllIIIlIIllll, final int llllllllllllllIlIlllllIIIlIIlllI, final int llllllllllllllIlIlllllIIIlIIllIl) {
        if (this.func_148310_d() && llllllllllllllIlIlllllIIIlIIlllI <= 32) {
            if (this.func_148309_e()) {
                this.field_148315_b.func_146962_b(this).remove(this);
                this.field_148315_b.func_146963_h().add(0, this);
                this.field_148315_b.func_175288_g();
                return true;
            }
            if (llllllllllllllIlIlllllIIIlIIlllI < 16 && this.func_148308_f()) {
                this.field_148315_b.func_146962_b(this).remove(this);
                this.field_148315_b.func_146964_g().add(0, this);
                this.field_148315_b.func_175288_g();
                return true;
            }
            if (llllllllllllllIlIlllllIIIlIIlllI > 16 && llllllllllllllIlIlllllIIIlIIllIl < 16 && this.func_148314_g()) {
                final List llllllllllllllIlIlllllIIIlIIllII = this.field_148315_b.func_146962_b(this);
                final int llllllllllllllIlIlllllIIIlIIlIlI = llllllllllllllIlIlllllIIIlIIllII.indexOf(this);
                llllllllllllllIlIlllllIIIlIIllII.remove(this);
                llllllllllllllIlIlllllIIIlIIllII.add(llllllllllllllIlIlllllIIIlIIlIlI - 1, this);
                this.field_148315_b.func_175288_g();
                return true;
            }
            if (llllllllllllllIlIlllllIIIlIIlllI > 16 && llllllllllllllIlIlllllIIIlIIllIl > 16 && this.func_148307_h()) {
                final List llllllllllllllIlIlllllIIIlIIlIll = this.field_148315_b.func_146962_b(this);
                final int llllllllllllllIlIlllllIIIlIIlIIl = llllllllllllllIlIlllllIIIlIIlIll.indexOf(this);
                llllllllllllllIlIlllllIIIlIIlIll.remove(this);
                llllllllllllllIlIlllllIIIlIIlIll.add(llllllllllllllIlIlllllIIIlIIlIIl + 1, this);
                this.field_148315_b.func_175288_g();
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void mouseReleased(final int llllllllllllllIlIlllllIIIIlllllI, final int llllllllllllllIlIlllllIIIIllllIl, final int llllllllllllllIlIlllllIIIIllllII, final int llllllllllllllIlIlllllIIIIlllIll, final int llllllllllllllIlIlllllIIIIlllIlI, final int llllllllllllllIlIlllllIIIIlllIIl) {
    }
}
