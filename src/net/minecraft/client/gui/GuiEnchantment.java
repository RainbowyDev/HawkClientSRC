package net.minecraft.client.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.model.*;
import net.minecraft.item.*;
import org.lwjgl.util.glu.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import java.io.*;

public class GuiEnchantment extends GuiContainer
{
    private static final /* synthetic */ ModelBook field_147072_E;
    public /* synthetic */ int field_147073_u;
    public /* synthetic */ float field_147081_y;
    /* synthetic */ ItemStack field_147077_B;
    public /* synthetic */ float field_147069_w;
    private final /* synthetic */ IWorldNameable field_175380_I;
    private /* synthetic */ Random field_147074_F;
    private /* synthetic */ ContainerEnchantment field_147075_G;
    public /* synthetic */ float field_147071_v;
    public /* synthetic */ float field_147076_A;
    public /* synthetic */ float field_147080_z;
    public /* synthetic */ float field_147082_x;
    private static final /* synthetic */ ResourceLocation field_147070_D;
    private static final /* synthetic */ ResourceLocation field_147078_C;
    private final /* synthetic */ InventoryPlayer field_175379_F;
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllllIIlIIIlIlllIlIIll, final int lllllllllllllllIIlIIIlIllIlIlIIl, final int lllllllllllllllIIlIIIlIlllIIllll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiEnchantment.field_147078_C);
        final int lllllllllllllllIIlIIIlIlllIIllIl = (this.width - this.xSize) / 2;
        final int lllllllllllllllIIlIIIlIlllIIlIll = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllllIIlIIIlIlllIIllIl, lllllllllllllllIIlIIIlIlllIIlIll, 0, 0, this.xSize, this.ySize);
        GlStateManager.pushMatrix();
        GlStateManager.matrixMode(5889);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        final ScaledResolution lllllllllllllllIIlIIIlIlllIIlIIl = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        GlStateManager.viewport((lllllllllllllllIIlIIIlIlllIIlIIl.getScaledWidth() - 320) / 2 * lllllllllllllllIIlIIIlIlllIIlIIl.getScaleFactor(), (lllllllllllllllIIlIIIlIlllIIlIIl.getScaledHeight() - 240) / 2 * lllllllllllllllIIlIIIlIlllIIlIIl.getScaleFactor(), 320 * lllllllllllllllIIlIIIlIlllIIlIIl.getScaleFactor(), 240 * lllllllllllllllIIlIIIlIlllIIlIIl.getScaleFactor());
        GlStateManager.translate(-0.34f, 0.23f, 0.0f);
        Project.gluPerspective(90.0f, 1.3333334f, 9.0f, 80.0f);
        final float lllllllllllllllIIlIIIlIlllIIIlll = 1.0f;
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.translate(0.0f, 3.3f, -16.0f);
        GlStateManager.scale(lllllllllllllllIIlIIIlIlllIIIlll, lllllllllllllllIIlIIIlIlllIIIlll, lllllllllllllllIIlIIIlIlllIIIlll);
        final float lllllllllllllllIIlIIIlIlllIIIlIl = 5.0f;
        GlStateManager.scale(lllllllllllllllIIlIIIlIlllIIIlIl, lllllllllllllllIIlIIIlIlllIIIlIl, lllllllllllllllIIlIIIlIlllIIIlIl);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiEnchantment.field_147070_D);
        GlStateManager.rotate(20.0f, 1.0f, 0.0f, 0.0f);
        final float lllllllllllllllIIlIIIlIlllIIIIll = this.field_147076_A + (this.field_147080_z - this.field_147076_A) * lllllllllllllllIIlIIIlIlllIlIIll;
        GlStateManager.translate((1.0f - lllllllllllllllIIlIIIlIlllIIIIll) * 0.2f, (1.0f - lllllllllllllllIIlIIIlIlllIIIIll) * 0.1f, (1.0f - lllllllllllllllIIlIIIlIlllIIIIll) * 0.25f);
        GlStateManager.rotate(-(1.0f - lllllllllllllllIIlIIIlIlllIIIIll) * 90.0f - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        float lllllllllllllllIIlIIIlIlllIIIIIl = this.field_147069_w + (this.field_147071_v - this.field_147069_w) * lllllllllllllllIIlIIIlIlllIlIIll + 0.25f;
        float lllllllllllllllIIlIIIlIllIllllll = this.field_147069_w + (this.field_147071_v - this.field_147069_w) * lllllllllllllllIIlIIIlIlllIlIIll + 0.75f;
        lllllllllllllllIIlIIIlIlllIIIIIl = (lllllllllllllllIIlIIIlIlllIIIIIl - MathHelper.truncateDoubleToInt(lllllllllllllllIIlIIIlIlllIIIIIl)) * 1.6f - 0.3f;
        lllllllllllllllIIlIIIlIllIllllll = (lllllllllllllllIIlIIIlIllIllllll - MathHelper.truncateDoubleToInt(lllllllllllllllIIlIIIlIllIllllll)) * 1.6f - 0.3f;
        if (lllllllllllllllIIlIIIlIlllIIIIIl < 0.0f) {
            lllllllllllllllIIlIIIlIlllIIIIIl = 0.0f;
        }
        if (lllllllllllllllIIlIIIlIllIllllll < 0.0f) {
            lllllllllllllllIIlIIIlIllIllllll = 0.0f;
        }
        if (lllllllllllllllIIlIIIlIlllIIIIIl > 1.0f) {
            lllllllllllllllIIlIIIlIlllIIIIIl = 1.0f;
        }
        if (lllllllllllllllIIlIIIlIllIllllll > 1.0f) {
            lllllllllllllllIIlIIIlIllIllllll = 1.0f;
        }
        GlStateManager.enableRescaleNormal();
        GuiEnchantment.field_147072_E.render(null, 0.0f, lllllllllllllllIIlIIIlIlllIIIIIl, lllllllllllllllIIlIIIlIllIllllll, lllllllllllllllIIlIIIlIlllIIIIll, 0.0f, 0.0625f);
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.matrixMode(5889);
        GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        EnchantmentNameParts.func_178176_a().reseedRandomGenerator(this.field_147075_G.field_178149_f);
        final int lllllllllllllllIIlIIIlIllIllllIl = this.field_147075_G.func_178147_e();
        for (int lllllllllllllllIIlIIIlIllIlllIll = 0; lllllllllllllllIIlIIIlIllIlllIll < 3; ++lllllllllllllllIIlIIIlIllIlllIll) {
            final int lllllllllllllllIIlIIIlIllIlllIIl = lllllllllllllllIIlIIIlIlllIIllIl + 60;
            final int lllllllllllllllIIlIIIlIllIllIlll = lllllllllllllllIIlIIIlIllIlllIIl + 20;
            final byte lllllllllllllllIIlIIIlIllIllIlIl = 86;
            final String lllllllllllllllIIlIIIlIllIllIIll = EnchantmentNameParts.func_178176_a().generateNewRandomName();
            this.zLevel = 0.0f;
            this.mc.getTextureManager().bindTexture(GuiEnchantment.field_147078_C);
            final int lllllllllllllllIIlIIIlIllIllIIlI = this.field_147075_G.enchantLevels[lllllllllllllllIIlIIIlIllIlllIll];
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (lllllllllllllllIIlIIIlIllIllIIlI == 0) {
                this.drawTexturedModalRect(lllllllllllllllIIlIIIlIllIlllIIl, lllllllllllllllIIlIIIlIlllIIlIll + 14 + 19 * lllllllllllllllIIlIIIlIllIlllIll, 0, 185, 108, 19);
            }
            else {
                final String lllllllllllllllIIlIIIlIllIllIIIl = String.valueOf(new StringBuilder().append(lllllllllllllllIIlIIIlIllIllIIlI));
                FontRenderer lllllllllllllllIIlIIIlIllIllIIII = this.mc.standardGalacticFontRenderer;
                int lllllllllllllllIIlIIIlIllIlIllll = 6839882;
                if ((lllllllllllllllIIlIIIlIllIllllIl < lllllllllllllllIIlIIIlIllIlllIll + 1 || this.mc.thePlayer.experienceLevel < lllllllllllllllIIlIIIlIllIllIIlI) && !this.mc.thePlayer.capabilities.isCreativeMode) {
                    this.drawTexturedModalRect(lllllllllllllllIIlIIIlIllIlllIIl, lllllllllllllllIIlIIIlIlllIIlIll + 14 + 19 * lllllllllllllllIIlIIIlIllIlllIll, 0, 185, 108, 19);
                    this.drawTexturedModalRect(lllllllllllllllIIlIIIlIllIlllIIl + 1, lllllllllllllllIIlIIIlIlllIIlIll + 15 + 19 * lllllllllllllllIIlIIIlIllIlllIll, 16 * lllllllllllllllIIlIIIlIllIlllIll, 239, 16, 16);
                    lllllllllllllllIIlIIIlIllIllIIII.drawSplitString(lllllllllllllllIIlIIIlIllIllIIll, lllllllllllllllIIlIIIlIllIllIlll, lllllllllllllllIIlIIIlIlllIIlIll + 16 + 19 * lllllllllllllllIIlIIIlIllIlllIll, lllllllllllllllIIlIIIlIllIllIlIl, (lllllllllllllllIIlIIIlIllIlIllll & 0xFEFEFE) >> 1);
                    lllllllllllllllIIlIIIlIllIlIllll = 4226832;
                }
                else {
                    final int lllllllllllllllIIlIIIlIllIlIlllI = lllllllllllllllIIlIIIlIllIlIlIIl - (lllllllllllllllIIlIIIlIlllIIllIl + 60);
                    final int lllllllllllllllIIlIIIlIllIlIllIl = lllllllllllllllIIlIIIlIlllIIllll - (lllllllllllllllIIlIIIlIlllIIlIll + 14 + 19 * lllllllllllllllIIlIIIlIllIlllIll);
                    if (lllllllllllllllIIlIIIlIllIlIlllI >= 0 && lllllllllllllllIIlIIIlIllIlIllIl >= 0 && lllllllllllllllIIlIIIlIllIlIlllI < 108 && lllllllllllllllIIlIIIlIllIlIllIl < 19) {
                        this.drawTexturedModalRect(lllllllllllllllIIlIIIlIllIlllIIl, lllllllllllllllIIlIIIlIlllIIlIll + 14 + 19 * lllllllllllllllIIlIIIlIllIlllIll, 0, 204, 108, 19);
                        lllllllllllllllIIlIIIlIllIlIllll = 16777088;
                    }
                    else {
                        this.drawTexturedModalRect(lllllllllllllllIIlIIIlIllIlllIIl, lllllllllllllllIIlIIIlIlllIIlIll + 14 + 19 * lllllllllllllllIIlIIIlIllIlllIll, 0, 166, 108, 19);
                    }
                    this.drawTexturedModalRect(lllllllllllllllIIlIIIlIllIlllIIl + 1, lllllllllllllllIIlIIIlIlllIIlIll + 15 + 19 * lllllllllllllllIIlIIIlIllIlllIll, 16 * lllllllllllllllIIlIIIlIllIlllIll, 223, 16, 16);
                    lllllllllllllllIIlIIIlIllIllIIII.drawSplitString(lllllllllllllllIIlIIIlIllIllIIll, lllllllllllllllIIlIIIlIllIllIlll, lllllllllllllllIIlIIIlIlllIIlIll + 16 + 19 * lllllllllllllllIIlIIIlIllIlllIll, lllllllllllllllIIlIIIlIllIllIlIl, lllllllllllllllIIlIIIlIllIlIllll);
                    lllllllllllllllIIlIIIlIllIlIllll = 8453920;
                }
                lllllllllllllllIIlIIIlIllIllIIII = this.mc.fontRendererObj;
                lllllllllllllllIIlIIIlIllIllIIII.drawStringWithShadow(lllllllllllllllIIlIIIlIllIllIIIl, (float)(lllllllllllllllIIlIIIlIllIllIlll + 86 - lllllllllllllllIIlIIIlIllIllIIII.getStringWidth(lllllllllllllllIIlIIIlIllIllIIIl)), (float)(lllllllllllllllIIlIIIlIlllIIlIll + 16 + 19 * lllllllllllllllIIlIIIlIllIlllIll + 7), lllllllllllllllIIlIIIlIllIlIllll);
            }
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIIlIIIlIlIlIIlIll, final int lllllllllllllllIIlIIIlIlIlIIlIIl, final float lllllllllllllllIIlIIIlIlIlIIlIII) {
        super.drawScreen(lllllllllllllllIIlIIIlIlIlIIlIll, lllllllllllllllIIlIIIlIlIlIIlIIl, lllllllllllllllIIlIIIlIlIlIIlIII);
        final boolean lllllllllllllllIIlIIIlIlIlIIIlll = this.mc.thePlayer.capabilities.isCreativeMode;
        final int lllllllllllllllIIlIIIlIlIlIIIllI = this.field_147075_G.func_178147_e();
        for (int lllllllllllllllIIlIIIlIlIlIIIlII = 0; lllllllllllllllIIlIIIlIlIlIIIlII < 3; ++lllllllllllllllIIlIIIlIlIlIIIlII) {
            final int lllllllllllllllIIlIIIlIlIlIIIIlI = this.field_147075_G.enchantLevels[lllllllllllllllIIlIIIlIlIlIIIlII];
            final int lllllllllllllllIIlIIIlIlIlIIIIII = this.field_147075_G.field_178151_h[lllllllllllllllIIlIIIlIlIlIIIlII];
            final int lllllllllllllllIIlIIIlIlIIlllllI = lllllllllllllllIIlIIIlIlIlIIIlII + 1;
            if (this.isPointInRegion(60, 14 + 19 * lllllllllllllllIIlIIIlIlIlIIIlII, 108, 17, lllllllllllllllIIlIIIlIlIlIIlIll, lllllllllllllllIIlIIIlIlIlIIlIIl) && lllllllllllllllIIlIIIlIlIlIIIIlI > 0 && lllllllllllllllIIlIIIlIlIlIIIIII >= 0) {
                final ArrayList lllllllllllllllIIlIIIlIlIIllllII = Lists.newArrayList();
                if (lllllllllllllllIIlIIIlIlIlIIIIII >= 0 && Enchantment.func_180306_c(lllllllllllllllIIlIIIlIlIlIIIIII & 0xFF) != null) {
                    final String lllllllllllllllIIlIIIlIlIIlllIll = Enchantment.func_180306_c(lllllllllllllllIIlIIIlIlIlIIIIII & 0xFF).getTranslatedName((lllllllllllllllIIlIIIlIlIlIIIIII & 0xFF00) >> 8);
                    lllllllllllllllIIlIIIlIlIIllllII.add(String.valueOf(new StringBuilder(String.valueOf(EnumChatFormatting.WHITE.toString())).append(EnumChatFormatting.ITALIC.toString()).append(I18n.format("container.enchant.clue", lllllllllllllllIIlIIIlIlIIlllIll))));
                }
                if (!lllllllllllllllIIlIIIlIlIlIIIlll) {
                    if (lllllllllllllllIIlIIIlIlIlIIIIII >= 0) {
                        lllllllllllllllIIlIIIlIlIIllllII.add("");
                    }
                    if (this.mc.thePlayer.experienceLevel < lllllllllllllllIIlIIIlIlIlIIIIlI) {
                        lllllllllllllllIIlIIIlIlIIllllII.add(String.valueOf(new StringBuilder(String.valueOf(EnumChatFormatting.RED.toString())).append("Level Requirement: ").append(this.field_147075_G.enchantLevels[lllllllllllllllIIlIIIlIlIlIIIlII])));
                    }
                    else {
                        String lllllllllllllllIIlIIIlIlIIlllIlI = "";
                        if (lllllllllllllllIIlIIIlIlIIlllllI == 1) {
                            lllllllllllllllIIlIIIlIlIIlllIlI = I18n.format("container.enchant.lapis.one", new Object[0]);
                        }
                        else {
                            lllllllllllllllIIlIIIlIlIIlllIlI = I18n.format("container.enchant.lapis.many", lllllllllllllllIIlIIIlIlIIlllllI);
                        }
                        if (lllllllllllllllIIlIIIlIlIlIIIllI >= lllllllllllllllIIlIIIlIlIIlllllI) {
                            lllllllllllllllIIlIIIlIlIIllllII.add(String.valueOf(new StringBuilder(String.valueOf(EnumChatFormatting.GRAY.toString())).append(lllllllllllllllIIlIIIlIlIIlllIlI)));
                        }
                        else {
                            lllllllllllllllIIlIIIlIlIIllllII.add(String.valueOf(new StringBuilder(String.valueOf(EnumChatFormatting.RED.toString())).append(lllllllllllllllIIlIIIlIlIIlllIlI)));
                        }
                        if (lllllllllllllllIIlIIIlIlIIlllllI == 1) {
                            lllllllllllllllIIlIIIlIlIIlllIlI = I18n.format("container.enchant.level.one", new Object[0]);
                        }
                        else {
                            lllllllllllllllIIlIIIlIlIIlllIlI = I18n.format("container.enchant.level.many", lllllllllllllllIIlIIIlIlIIlllllI);
                        }
                        lllllllllllllllIIlIIIlIlIIllllII.add(String.valueOf(new StringBuilder(String.valueOf(EnumChatFormatting.GRAY.toString())).append(lllllllllllllllIIlIIIlIlIIlllIlI)));
                    }
                }
                this.drawHoveringText(lllllllllllllllIIlIIIlIlIIllllII, lllllllllllllllIIlIIIlIlIlIIlIll, lllllllllllllllIIlIIIlIlIlIIlIIl);
                break;
            }
        }
    }
    
    static {
        __OBFID = "CL_00000757";
        field_147078_C = new ResourceLocation("textures/gui/container/enchanting_table.png");
        field_147070_D = new ResourceLocation("textures/entity/enchanting_table_book.png");
        field_147072_E = new ModelBook();
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllIIlIIIllIIllIIIII, final int lllllllllllllllIIlIIIllIIlIlllll) {
        this.fontRendererObj.drawString(this.field_175380_I.getDisplayName().getUnformattedText(), 12.0, 5.0, 4210752);
        this.fontRendererObj.drawString(this.field_175379_F.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        this.func_147068_g();
    }
    
    public GuiEnchantment(final InventoryPlayer lllllllllllllllIIlIIIllIIllIIlIl, final World lllllllllllllllIIlIIIllIIllIlIII, final IWorldNameable lllllllllllllllIIlIIIllIIllIIIll) {
        super(new ContainerEnchantment(lllllllllllllllIIlIIIllIIllIIlIl, lllllllllllllllIIlIIIllIIllIlIII));
        this.field_147074_F = new Random();
        this.field_175379_F = lllllllllllllllIIlIIIllIIllIIlIl;
        this.field_147075_G = (ContainerEnchantment)this.inventorySlots;
        this.field_175380_I = lllllllllllllllIIlIIIllIIllIIIll;
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllIIlIIIllIIlIIIlIl, final int lllllllllllllllIIlIIIllIIlIIIIll, final int lllllllllllllllIIlIIIllIIlIIIIIl) throws IOException {
        super.mouseClicked(lllllllllllllllIIlIIIllIIlIIIlIl, lllllllllllllllIIlIIIllIIlIIIIll, lllllllllllllllIIlIIIllIIlIIIIIl);
        final int lllllllllllllllIIlIIIllIIlIIllIl = (this.width - this.xSize) / 2;
        final int lllllllllllllllIIlIIIllIIlIIllII = (this.height - this.ySize) / 2;
        for (int lllllllllllllllIIlIIIllIIlIIlIlI = 0; lllllllllllllllIIlIIIllIIlIIlIlI < 3; ++lllllllllllllllIIlIIIllIIlIIlIlI) {
            final int lllllllllllllllIIlIIIllIIlIIlIIl = lllllllllllllllIIlIIIllIIlIIIlIl - (lllllllllllllllIIlIIIllIIlIIllIl + 60);
            final int lllllllllllllllIIlIIIllIIlIIlIII = lllllllllllllllIIlIIIllIIlIIIIll - (lllllllllllllllIIlIIIllIIlIIllII + 14 + 19 * lllllllllllllllIIlIIIllIIlIIlIlI);
            if (lllllllllllllllIIlIIIllIIlIIlIIl >= 0 && lllllllllllllllIIlIIIllIIlIIlIII >= 0 && lllllllllllllllIIlIIIllIIlIIlIIl < 108 && lllllllllllllllIIlIIIllIIlIIlIII < 19 && this.field_147075_G.enchantItem(this.mc.thePlayer, lllllllllllllllIIlIIIllIIlIIlIlI)) {
                this.mc.playerController.sendEnchantPacket(this.field_147075_G.windowId, lllllllllllllllIIlIIIllIIlIIlIlI);
            }
        }
    }
    
    public void func_147068_g() {
        final ItemStack lllllllllllllllIIlIIIlIlIIIIIIIl = this.inventorySlots.getSlot(0).getStack();
        if (!ItemStack.areItemStacksEqual(lllllllllllllllIIlIIIlIlIIIIIIIl, this.field_147077_B)) {
            this.field_147077_B = lllllllllllllllIIlIIIlIlIIIIIIIl;
            do {
                this.field_147082_x += this.field_147074_F.nextInt(4) - this.field_147074_F.nextInt(4);
            } while (this.field_147071_v <= this.field_147082_x + 1.0f && this.field_147071_v >= this.field_147082_x - 1.0f);
        }
        ++this.field_147073_u;
        this.field_147069_w = this.field_147071_v;
        this.field_147076_A = this.field_147080_z;
        boolean lllllllllllllllIIlIIIlIIllllllll = false;
        for (int lllllllllllllllIIlIIIlIIllllllIl = 0; lllllllllllllllIIlIIIlIIllllllIl < 3; ++lllllllllllllllIIlIIIlIIllllllIl) {
            if (this.field_147075_G.enchantLevels[lllllllllllllllIIlIIIlIIllllllIl] != 0) {
                lllllllllllllllIIlIIIlIIllllllll = true;
            }
        }
        if (lllllllllllllllIIlIIIlIIllllllll) {
            this.field_147080_z += 0.2f;
        }
        else {
            this.field_147080_z -= 0.2f;
        }
        this.field_147080_z = MathHelper.clamp_float(this.field_147080_z, 0.0f, 1.0f);
        float lllllllllllllllIIlIIIlIIlllllIll = (this.field_147082_x - this.field_147071_v) * 0.4f;
        final float lllllllllllllllIIlIIIlIIlllllIIl = 0.2f;
        lllllllllllllllIIlIIIlIIlllllIll = MathHelper.clamp_float(lllllllllllllllIIlIIIlIIlllllIll, -lllllllllllllllIIlIIIlIIlllllIIl, lllllllllllllllIIlIIIlIIlllllIIl);
        this.field_147081_y += (lllllllllllllllIIlIIIlIIlllllIll - this.field_147081_y) * 0.9f;
        this.field_147071_v += this.field_147081_y;
    }
}
