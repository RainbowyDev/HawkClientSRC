package net.minecraft.client.gui.inventory;

import net.minecraft.client.resources.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.achievement.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;

public class GuiInventory extends InventoryEffectRenderer
{
    private /* synthetic */ float oldMouseY;
    private /* synthetic */ float oldMouseX;
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllllllIlIllIlIlIIIlIlIlI, final int llllllllllllllIlIllIlIlIIIlIlIIl) {
        this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 86.0, 16.0, 4210752);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        if (this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.thePlayer));
        }
        else {
            super.initGui();
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlIllIlIIlIlllIIlI) throws IOException {
        if (llllllllllllllIlIllIlIIlIlllIIlI.id == 0) {
            this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
        }
        if (llllllllllllllIlIllIlIIlIlllIIlI.id == 1) {
            this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
        }
    }
    
    public GuiInventory(final EntityPlayer llllllllllllllIlIllIlIlIIIllIlIl) {
        super(llllllllllllllIlIllIlIlIIIllIlIl.inventoryContainer);
        this.allowUserInput = true;
    }
    
    static {
        __OBFID = "CL_00000761";
    }
    
    @Override
    public void updateScreen() {
        if (this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.thePlayer));
        }
        this.func_175378_g();
    }
    
    public static void drawEntityOnScreen(final int llllllllllllllIlIllIlIIlllllIlll, final int llllllllllllllIlIllIlIIlllllIllI, final int llllllllllllllIlIllIlIIlllllIlIl, final float llllllllllllllIlIllIlIlIIIIIIIII, final float llllllllllllllIlIllIlIIlllllllll, final EntityLivingBase llllllllllllllIlIllIlIIllllllllI) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllllIlIllIlIIlllllIlll, (float)llllllllllllllIlIllIlIIlllllIllI, 50.0f);
        GlStateManager.scale((float)(-llllllllllllllIlIllIlIIlllllIlIl), (float)llllllllllllllIlIllIlIIlllllIlIl, (float)llllllllllllllIlIllIlIIlllllIlIl);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        final float llllllllllllllIlIllIlIIlllllllIl = llllllllllllllIlIllIlIIllllllllI.renderYawOffset;
        final float llllllllllllllIlIllIlIIlllllllII = llllllllllllllIlIllIlIIllllllllI.rotationYaw;
        final float llllllllllllllIlIllIlIIllllllIll = llllllllllllllIlIllIlIIllllllllI.rotationPitch;
        final float llllllllllllllIlIllIlIIllllllIlI = llllllllllllllIlIllIlIIllllllllI.prevRotationYawHead;
        final float llllllllllllllIlIllIlIIllllllIIl = llllllllllllllIlIllIlIIllllllllI.rotationYawHead;
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-(float)Math.atan(llllllllllllllIlIllIlIIlllllllll / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
        llllllllllllllIlIllIlIIllllllllI.renderYawOffset = (float)Math.atan(llllllllllllllIlIllIlIlIIIIIIIII / 40.0f) * 20.0f;
        llllllllllllllIlIllIlIIllllllllI.rotationYaw = (float)Math.atan(llllllllllllllIlIllIlIlIIIIIIIII / 40.0f) * 40.0f;
        llllllllllllllIlIllIlIIllllllllI.rotationPitch = -(float)Math.atan(llllllllllllllIlIllIlIIlllllllll / 40.0f) * 20.0f;
        llllllllllllllIlIllIlIIllllllllI.rotationYawHead = llllllllllllllIlIllIlIIllllllllI.rotationYaw;
        llllllllllllllIlIllIlIIllllllllI.prevRotationYawHead = llllllllllllllIlIllIlIIllllllllI.rotationYaw;
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        final RenderManager llllllllllllllIlIllIlIIllllllIII = Minecraft.getMinecraft().getRenderManager();
        llllllllllllllIlIllIlIIllllllIII.func_178631_a(180.0f);
        llllllllllllllIlIllIlIIllllllIII.func_178633_a(false);
        llllllllllllllIlIllIlIIllllllIII.renderEntityWithPosYaw(llllllllllllllIlIllIlIIllllllllI, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        llllllllllllllIlIllIlIIllllllIII.func_178633_a(true);
        llllllllllllllIlIllIlIIllllllllI.renderYawOffset = llllllllllllllIlIllIlIIlllllllIl;
        llllllllllllllIlIllIlIIllllllllI.rotationYaw = llllllllllllllIlIllIlIIlllllllII;
        llllllllllllllIlIllIlIIllllllllI.rotationPitch = llllllllllllllIlIllIlIIllllllIll;
        llllllllllllllIlIllIlIIllllllllI.prevRotationYawHead = llllllllllllllIlIllIlIIllllllIlI;
        llllllllllllllIlIllIlIIllllllllI.rotationYawHead = llllllllllllllIlIllIlIIllllllIIl;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.func_179090_x();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlIllIlIlIIIlIIIlI, final int llllllllllllllIlIllIlIlIIIIlllIl, final float llllllllllllllIlIllIlIlIIIlIIIII) {
        super.drawScreen(llllllllllllllIlIllIlIlIIIlIIIlI, llllllllllllllIlIllIlIlIIIIlllIl, llllllllllllllIlIllIlIlIIIlIIIII);
        this.oldMouseX = (float)llllllllllllllIlIllIlIlIIIlIIIlI;
        this.oldMouseY = (float)llllllllllllllIlIllIlIlIIIIlllIl;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllllllIlIllIlIlIIIIlIlll, final int llllllllllllllIlIllIlIlIIIIlIllI, final int llllllllllllllIlIllIlIlIIIIlIlIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiInventory.inventoryBackground);
        final int llllllllllllllIlIllIlIlIIIIlIlII = this.guiLeft;
        final int llllllllllllllIlIllIlIlIIIIlIIll = this.guiTop;
        this.drawTexturedModalRect(llllllllllllllIlIllIlIlIIIIlIlII, llllllllllllllIlIllIlIlIIIIlIIll, 0, 0, this.xSize, this.ySize);
        drawEntityOnScreen(llllllllllllllIlIllIlIlIIIIlIlII + 51, llllllllllllllIlIllIlIlIIIIlIIll + 75, 30, llllllllllllllIlIllIlIlIIIIlIlII + 51 - this.oldMouseX, llllllllllllllIlIllIlIlIIIIlIIll + 75 - 50 - this.oldMouseY, this.mc.thePlayer);
    }
}
