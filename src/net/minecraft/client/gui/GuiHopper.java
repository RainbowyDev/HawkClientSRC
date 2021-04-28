package net.minecraft.client.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class GuiHopper extends GuiContainer
{
    private /* synthetic */ IInventory field_147083_w;
    private /* synthetic */ IInventory field_147084_v;
    private static final /* synthetic */ ResourceLocation field_147085_u;
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllllllIlIIIIIIIllII, final int lllllllllllllllllllIlIIIIIIIlIll) {
        this.fontRendererObj.drawString(this.field_147083_w.getDisplayName().getUnformattedText(), 8.0, 6.0, 4210752);
        this.fontRendererObj.drawString(this.field_147084_v.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllllllllIlIIIIIIIIlIl, final int lllllllllllllllllllIlIIIIIIIIlII, final int lllllllllllllllllllIlIIIIIIIIIll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiHopper.field_147085_u);
        final int lllllllllllllllllllIlIIIIIIIIIlI = (this.width - this.xSize) / 2;
        final int lllllllllllllllllllIlIIIIIIIIIIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllllllllIlIIIIIIIIIlI, lllllllllllllllllllIlIIIIIIIIIIl, 0, 0, this.xSize, this.ySize);
    }
    
    public GuiHopper(final InventoryPlayer lllllllllllllllllllIlIIIIIIlIIII, final IInventory lllllllllllllllllllIlIIIIIIIllll) {
        super(new ContainerHopper(lllllllllllllllllllIlIIIIIIlIIII, lllllllllllllllllllIlIIIIIIIllll, Minecraft.getMinecraft().thePlayer));
        this.field_147084_v = lllllllllllllllllllIlIIIIIIlIIII;
        this.field_147083_w = lllllllllllllllllllIlIIIIIIIllll;
        this.allowUserInput = false;
        this.ySize = 133;
    }
    
    static {
        __OBFID = "CL_00000759";
        field_147085_u = new ResourceLocation("textures/gui/container/hopper.png");
    }
}
