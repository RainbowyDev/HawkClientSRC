package net.minecraft.client.renderer;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.inventory.*;
import net.minecraft.potion.*;
import net.minecraft.client.resources.*;
import java.util.*;

public abstract class InventoryEffectRenderer extends GuiContainer
{
    private /* synthetic */ boolean hasActivePotionEffects;
    
    @Override
    public void drawScreen(final int llllllllllllllIlIlIIIlllIIIIllIl, final int llllllllllllllIlIlIIIlllIIIIllII, final float llllllllllllllIlIlIIIlllIIIIlIll) {
        super.drawScreen(llllllllllllllIlIlIIIlllIIIIllIl, llllllllllllllIlIlIIIlllIIIIllII, llllllllllllllIlIlIIIlllIIIIlIll);
        if (this.hasActivePotionEffects) {
            this.drawActivePotionEffects();
        }
    }
    
    static {
        __OBFID = "CL_00000755";
    }
    
    protected void func_175378_g() {
        if (!this.mc.thePlayer.getActivePotionEffects().isEmpty()) {
            this.guiLeft = 160 + (this.width - this.xSize - 200) / 2;
            this.hasActivePotionEffects = true;
        }
        else {
            this.guiLeft = (this.width - this.xSize) / 2;
            this.hasActivePotionEffects = false;
        }
    }
    
    public InventoryEffectRenderer(final Container llllllllllllllIlIlIIIlllIIIllIll) {
        super(llllllllllllllIlIlIIIlllIIIllIll);
    }
    
    private void drawActivePotionEffects() {
        final int llllllllllllllIlIlIIIllIlllllIlI = this.guiLeft - 124;
        int llllllllllllllIlIlIIIllIlllllIIl = this.guiTop;
        final boolean llllllllllllllIlIlIIIllIlllllIII = true;
        final Collection llllllllllllllIlIlIIIllIllllIlll = this.mc.thePlayer.getActivePotionEffects();
        if (!llllllllllllllIlIlIIIllIllllIlll.isEmpty()) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableLighting();
            int llllllllllllllIlIlIIIllIllllIllI = 33;
            if (llllllllllllllIlIlIIIllIllllIlll.size() > 5) {
                llllllllllllllIlIlIIIllIllllIllI = 132 / (llllllllllllllIlIlIIIllIllllIlll.size() - 1);
            }
            for (final PotionEffect llllllllllllllIlIlIIIllIllllIlII : this.mc.thePlayer.getActivePotionEffects()) {
                final Potion llllllllllllllIlIlIIIllIllllIIll = Potion.potionTypes[llllllllllllllIlIlIIIllIllllIlII.getPotionID()];
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.mc.getTextureManager().bindTexture(InventoryEffectRenderer.inventoryBackground);
                this.drawTexturedModalRect(llllllllllllllIlIlIIIllIlllllIlI, llllllllllllllIlIlIIIllIlllllIIl, 0, 166, 140, 32);
                if (llllllllllllllIlIlIIIllIllllIIll.hasStatusIcon()) {
                    final int llllllllllllllIlIlIIIllIllllIIlI = llllllllllllllIlIlIIIllIllllIIll.getStatusIconIndex();
                    this.drawTexturedModalRect(llllllllllllllIlIlIIIllIlllllIlI + 6, llllllllllllllIlIlIIIllIlllllIIl + 7, 0 + llllllllllllllIlIlIIIllIllllIIlI % 8 * 18, 198 + llllllllllllllIlIlIIIllIllllIIlI / 8 * 18, 18, 18);
                }
                String llllllllllllllIlIlIIIllIllllIIIl = I18n.format(llllllllllllllIlIlIIIllIllllIIll.getName(), new Object[0]);
                if (llllllllllllllIlIlIIIllIllllIlII.getAmplifier() == 1) {
                    llllllllllllllIlIlIIIllIllllIIIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIlIIIllIllllIIIl)).append(" ").append(I18n.format("enchantment.level.2", new Object[0])));
                }
                else if (llllllllllllllIlIlIIIllIllllIlII.getAmplifier() == 2) {
                    llllllllllllllIlIlIIIllIllllIIIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIlIIIllIllllIIIl)).append(" ").append(I18n.format("enchantment.level.3", new Object[0])));
                }
                else if (llllllllllllllIlIlIIIllIllllIlII.getAmplifier() == 3) {
                    llllllllllllllIlIlIIIllIllllIIIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIlIIIllIllllIIIl)).append(" ").append(I18n.format("enchantment.level.4", new Object[0])));
                }
                this.fontRendererObj.drawStringWithShadow(llllllllllllllIlIlIIIllIllllIIIl, (float)(llllllllllllllIlIlIIIllIlllllIlI + 10 + 18), (float)(llllllllllllllIlIlIIIllIlllllIIl + 6), 16777215);
                final String llllllllllllllIlIlIIIllIllllIIII = Potion.getDurationString(llllllllllllllIlIlIIIllIllllIlII);
                this.fontRendererObj.drawStringWithShadow(llllllllllllllIlIlIIIllIllllIIII, (float)(llllllllllllllIlIlIIIllIlllllIlI + 10 + 18), (float)(llllllllllllllIlIlIIIllIlllllIIl + 6 + 10), 8355711);
                llllllllllllllIlIlIIIllIlllllIIl += llllllllllllllIlIlIIIllIllllIllI;
            }
        }
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.func_175378_g();
    }
}
