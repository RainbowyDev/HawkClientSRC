package net.minecraft.client.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import java.io.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.resources.*;
import net.minecraft.village.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.item.*;
import net.minecraft.client.*;

public class GuiMerchant extends GuiContainer
{
    private /* synthetic */ MerchantButton field_147043_x;
    private /* synthetic */ MerchantButton field_147042_y;
    private static final /* synthetic */ ResourceLocation field_147038_v;
    private /* synthetic */ IChatComponent field_147040_A;
    private /* synthetic */ IMerchant field_147037_w;
    private /* synthetic */ int field_147041_z;
    
    public GuiMerchant(final InventoryPlayer llllllllllllllIIlllIlIIIlIIlllIl, final IMerchant llllllllllllllIIlllIlIIIlIlIIIII, final World llllllllllllllIIlllIlIIIlIIlllll) {
        super(new ContainerMerchant(llllllllllllllIIlllIlIIIlIIlllIl, llllllllllllllIIlllIlIIIlIlIIIII, llllllllllllllIIlllIlIIIlIIlllll));
        this.field_147037_w = llllllllllllllIIlllIlIIIlIlIIIII;
        this.field_147040_A = llllllllllllllIIlllIlIIIlIlIIIII.getDisplayName();
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIlllIlIIIIllllIIl) throws IOException {
        boolean llllllllllllllIIlllIlIIIIlllllIl = false;
        if (llllllllllllllIIlllIlIIIIllllIIl == this.field_147043_x) {
            ++this.field_147041_z;
            final MerchantRecipeList llllllllllllllIIlllIlIIIIlllllII = this.field_147037_w.getRecipes(this.mc.thePlayer);
            if (llllllllllllllIIlllIlIIIIlllllII != null && this.field_147041_z >= llllllllllllllIIlllIlIIIIlllllII.size()) {
                this.field_147041_z = llllllllllllllIIlllIlIIIIlllllII.size() - 1;
            }
            llllllllllllllIIlllIlIIIIlllllIl = true;
        }
        else if (llllllllllllllIIlllIlIIIIllllIIl == this.field_147042_y) {
            --this.field_147041_z;
            if (this.field_147041_z < 0) {
                this.field_147041_z = 0;
            }
            llllllllllllllIIlllIlIIIIlllllIl = true;
        }
        if (llllllllllllllIIlllIlIIIIlllllIl) {
            ((ContainerMerchant)this.inventorySlots).setCurrentRecipeIndex(this.field_147041_z);
            final PacketBuffer llllllllllllllIIlllIlIIIIllllIll = new PacketBuffer(Unpooled.buffer());
            llllllllllllllIIlllIlIIIIllllIll.writeInt(this.field_147041_z);
            this.mc.getNetHandler().addToSendQueue(new C17PacketCustomPayload("MC|TrSel", llllllllllllllIIlllIlIIIIllllIll));
        }
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final MerchantRecipeList llllllllllllllIIlllIlIIIlIIIIllI = this.field_147037_w.getRecipes(this.mc.thePlayer);
        if (llllllllllllllIIlllIlIIIlIIIIllI != null) {
            this.field_147043_x.enabled = (this.field_147041_z < llllllllllllllIIlllIlIIIlIIIIllI.size() - 1);
            this.field_147042_y.enabled = (this.field_147041_z > 0);
        }
    }
    
    public IMerchant getMerchant() {
        return this.field_147037_w;
    }
    
    static {
        __OBFID = "CL_00000762";
        logger = LogManager.getLogger();
        field_147038_v = new ResourceLocation("textures/gui/container/villager.png");
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllllllIIlllIlIIIlIIIlllI, final int llllllllllllllIIlllIlIIIlIIIllIl) {
        final String llllllllllllllIIlllIlIIIlIIIllII = this.field_147040_A.getUnformattedText();
        this.fontRendererObj.drawString(llllllllllllllIIlllIlIIIlIIIllII, this.xSize / 2 - this.fontRendererObj.getStringWidth(llllllllllllllIIlllIlIIIlIIIllII) / 2, 6.0, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllllllIIlllIlIIIIllIllll, final int llllllllllllllIIlllIlIIIIllIlllI, final int llllllllllllllIIlllIlIIIIllIllIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiMerchant.field_147038_v);
        final int llllllllllllllIIlllIlIIIIllIllII = (this.width - this.xSize) / 2;
        final int llllllllllllllIIlllIlIIIIllIlIll = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(llllllllllllllIIlllIlIIIIllIllII, llllllllllllllIIlllIlIIIIllIlIll, 0, 0, this.xSize, this.ySize);
        final MerchantRecipeList llllllllllllllIIlllIlIIIIllIlIlI = this.field_147037_w.getRecipes(this.mc.thePlayer);
        if (llllllllllllllIIlllIlIIIIllIlIlI != null && !llllllllllllllIIlllIlIIIIllIlIlI.isEmpty()) {
            final int llllllllllllllIIlllIlIIIIllIlIIl = this.field_147041_z;
            if (llllllllllllllIIlllIlIIIIllIlIIl < 0 || llllllllllllllIIlllIlIIIIllIlIIl >= llllllllllllllIIlllIlIIIIllIlIlI.size()) {
                return;
            }
            final MerchantRecipe llllllllllllllIIlllIlIIIIllIlIII = llllllllllllllIIlllIlIIIIllIlIlI.get(llllllllllllllIIlllIlIIIIllIlIIl);
            if (llllllllllllllIIlllIlIIIIllIlIII.isRecipeDisabled()) {
                this.mc.getTextureManager().bindTexture(GuiMerchant.field_147038_v);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.disableLighting();
                this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 21, 212, 0, 28, 21);
                this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 51, 212, 0, 28, 21);
            }
        }
    }
    
    @Override
    public void initGui() {
        super.initGui();
        final int llllllllllllllIIlllIlIIIlIIlIllI = (this.width - this.xSize) / 2;
        final int llllllllllllllIIlllIlIIIlIIlIlIl = (this.height - this.ySize) / 2;
        final List buttonList = this.buttonList;
        final MerchantButton field_147043_x = new MerchantButton(1, llllllllllllllIIlllIlIIIlIIlIllI + 120 + 27, llllllllllllllIIlllIlIIIlIIlIlIl + 24 - 1, true);
        this.field_147043_x = field_147043_x;
        buttonList.add(field_147043_x);
        final List buttonList2 = this.buttonList;
        final MerchantButton field_147042_y = new MerchantButton(2, llllllllllllllIIlllIlIIIlIIlIllI + 36 - 19, llllllllllllllIIlllIlIIIlIIlIlIl + 24 - 1, false);
        this.field_147042_y = field_147042_y;
        buttonList2.add(field_147042_y);
        this.field_147043_x.enabled = false;
        this.field_147042_y.enabled = false;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIlllIlIIIIlIlIlII, final int llllllllllllllIIlllIlIIIIlIlIIll, final float llllllllllllllIIlllIlIIIIlIIIllI) {
        super.drawScreen(llllllllllllllIIlllIlIIIIlIlIlII, llllllllllllllIIlllIlIIIIlIlIIll, llllllllllllllIIlllIlIIIIlIIIllI);
        final MerchantRecipeList llllllllllllllIIlllIlIIIIlIlIIIl = this.field_147037_w.getRecipes(this.mc.thePlayer);
        if (llllllllllllllIIlllIlIIIIlIlIIIl != null && !llllllllllllllIIlllIlIIIIlIlIIIl.isEmpty()) {
            final int llllllllllllllIIlllIlIIIIlIlIIII = (this.width - this.xSize) / 2;
            final int llllllllllllllIIlllIlIIIIlIIllll = (this.height - this.ySize) / 2;
            final int llllllllllllllIIlllIlIIIIlIIlllI = this.field_147041_z;
            final MerchantRecipe llllllllllllllIIlllIlIIIIlIIllIl = llllllllllllllIIlllIlIIIIlIlIIIl.get(llllllllllllllIIlllIlIIIIlIIlllI);
            final ItemStack llllllllllllllIIlllIlIIIIlIIllII = llllllllllllllIIlllIlIIIIlIIllIl.getItemToBuy();
            final ItemStack llllllllllllllIIlllIlIIIIlIIlIll = llllllllllllllIIlllIlIIIIlIIllIl.getSecondItemToBuy();
            final ItemStack llllllllllllllIIlllIlIIIIlIIlIlI = llllllllllllllIIlllIlIIIIlIIllIl.getItemToSell();
            GlStateManager.pushMatrix();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableColorMaterial();
            GlStateManager.enableLighting();
            this.itemRender.zLevel = 100.0f;
            this.itemRender.func_180450_b(llllllllllllllIIlllIlIIIIlIIllII, llllllllllllllIIlllIlIIIIlIlIIII + 36, llllllllllllllIIlllIlIIIIlIIllll + 24);
            this.itemRender.func_175030_a(this.fontRendererObj, llllllllllllllIIlllIlIIIIlIIllII, llllllllllllllIIlllIlIIIIlIlIIII + 36, llllllllllllllIIlllIlIIIIlIIllll + 24);
            if (llllllllllllllIIlllIlIIIIlIIlIll != null) {
                this.itemRender.func_180450_b(llllllllllllllIIlllIlIIIIlIIlIll, llllllllllllllIIlllIlIIIIlIlIIII + 62, llllllllllllllIIlllIlIIIIlIIllll + 24);
                this.itemRender.func_175030_a(this.fontRendererObj, llllllllllllllIIlllIlIIIIlIIlIll, llllllllllllllIIlllIlIIIIlIlIIII + 62, llllllllllllllIIlllIlIIIIlIIllll + 24);
            }
            this.itemRender.func_180450_b(llllllllllllllIIlllIlIIIIlIIlIlI, llllllllllllllIIlllIlIIIIlIlIIII + 120, llllllllllllllIIlllIlIIIIlIIllll + 24);
            this.itemRender.func_175030_a(this.fontRendererObj, llllllllllllllIIlllIlIIIIlIIlIlI, llllllllllllllIIlllIlIIIIlIlIIII + 120, llllllllllllllIIlllIlIIIIlIIllll + 24);
            this.itemRender.zLevel = 0.0f;
            GlStateManager.disableLighting();
            if (this.isPointInRegion(36, 24, 16, 16, llllllllllllllIIlllIlIIIIlIlIlII, llllllllllllllIIlllIlIIIIlIlIIll) && llllllllllllllIIlllIlIIIIlIIllII != null) {
                this.renderToolTip(llllllllllllllIIlllIlIIIIlIIllII, llllllllllllllIIlllIlIIIIlIlIlII, llllllllllllllIIlllIlIIIIlIlIIll);
            }
            else if (llllllllllllllIIlllIlIIIIlIIlIll != null && this.isPointInRegion(62, 24, 16, 16, llllllllllllllIIlllIlIIIIlIlIlII, llllllllllllllIIlllIlIIIIlIlIIll) && llllllllllllllIIlllIlIIIIlIIlIll != null) {
                this.renderToolTip(llllllllllllllIIlllIlIIIIlIIlIll, llllllllllllllIIlllIlIIIIlIlIlII, llllllllllllllIIlllIlIIIIlIlIIll);
            }
            else if (llllllllllllllIIlllIlIIIIlIIlIlI != null && this.isPointInRegion(120, 24, 16, 16, llllllllllllllIIlllIlIIIIlIlIlII, llllllllllllllIIlllIlIIIIlIlIIll) && llllllllllllllIIlllIlIIIIlIIlIlI != null) {
                this.renderToolTip(llllllllllllllIIlllIlIIIIlIIlIlI, llllllllllllllIIlllIlIIIIlIlIlII, llllllllllllllIIlllIlIIIIlIlIIll);
            }
            else if (llllllllllllllIIlllIlIIIIlIIllIl.isRecipeDisabled() && (this.isPointInRegion(83, 21, 28, 21, llllllllllllllIIlllIlIIIIlIlIlII, llllllllllllllIIlllIlIIIIlIlIIll) || this.isPointInRegion(83, 51, 28, 21, llllllllllllllIIlllIlIIIIlIlIlII, llllllllllllllIIlllIlIIIIlIlIIll))) {
                this.drawCreativeTabHoveringText(I18n.format("merchant.deprecated", new Object[0]), llllllllllllllIIlllIlIIIIlIlIlII, llllllllllllllIIlllIlIIIIlIlIIll);
            }
            GlStateManager.popMatrix();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
        }
    }
    
    static class MerchantButton extends GuiButton
    {
        private final /* synthetic */ boolean field_146157_o;
        
        @Override
        public void drawButton(final Minecraft lllllllllllllllllIIlIllIlllllIlI, final int lllllllllllllllllIIlIllIlllllIIl, final int lllllllllllllllllIIlIllIlllllIII) {
            if (this.visible) {
                lllllllllllllllllIIlIllIlllllIlI.getTextureManager().bindTexture(GuiMerchant.field_147038_v);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                final boolean lllllllllllllllllIIlIllIllllIlll = lllllllllllllllllIIlIllIlllllIIl >= this.xPosition && lllllllllllllllllIIlIllIlllllIII >= this.yPosition && lllllllllllllllllIIlIllIlllllIIl < this.xPosition + this.width && lllllllllllllllllIIlIllIlllllIII < this.yPosition + this.height;
                int lllllllllllllllllIIlIllIllllIllI = 0;
                int lllllllllllllllllIIlIllIllllIlIl = 176;
                if (!this.enabled) {
                    lllllllllllllllllIIlIllIllllIlIl += this.width * 2;
                }
                else if (lllllllllllllllllIIlIllIllllIlll) {
                    lllllllllllllllllIIlIllIllllIlIl += this.width;
                }
                if (!this.field_146157_o) {
                    lllllllllllllllllIIlIllIllllIllI += this.height;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, lllllllllllllllllIIlIllIllllIlIl, lllllllllllllllllIIlIllIllllIllI, this.width, this.height);
            }
        }
        
        public MerchantButton(final int lllllllllllllllllIIlIlllIIIIlIll, final int lllllllllllllllllIIlIlllIIIIIlIl, final int lllllllllllllllllIIlIlllIIIIIlII, final boolean lllllllllllllllllIIlIlllIIIIlIII) {
            super(lllllllllllllllllIIlIlllIIIIlIll, lllllllllllllllllIIlIlllIIIIIlIl, lllllllllllllllllIIlIlllIIIIIlII, 12, 19, "");
            this.field_146157_o = lllllllllllllllllIIlIlllIIIIlIII;
        }
        
        static {
            __OBFID = "CL_00000763";
        }
    }
}
