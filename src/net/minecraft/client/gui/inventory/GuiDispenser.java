package net.minecraft.client.gui.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.inventory.*;

public class GuiDispenser extends GuiContainer
{
    private final /* synthetic */ InventoryPlayer field_175376_w;
    public /* synthetic */ IInventory field_175377_u;
    private static final /* synthetic */ ResourceLocation dispenserGuiTextures;
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllllIIlllIIIIllIlIlIl, final int lllllllllllllllIIlllIIIIllIlIlII, final int lllllllllllllllIIlllIIIIllIlIIll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiDispenser.dispenserGuiTextures);
        final int lllllllllllllllIIlllIIIIllIlIIlI = (this.width - this.xSize) / 2;
        final int lllllllllllllllIIlllIIIIllIlIIIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllllIIlllIIIIllIlIIlI, lllllllllllllllIIlllIIIIllIlIIIl, 0, 0, this.xSize, this.ySize);
    }
    
    static {
        __OBFID = "CL_00000765";
        dispenserGuiTextures = new ResourceLocation("textures/gui/container/dispenser.png");
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllIIlllIIIIllIllllI, final int lllllllllllllllIIlllIIIIllIlllIl) {
        final String lllllllllllllllIIlllIIIIllIlllII = this.field_175377_u.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(lllllllllllllllIIlllIIIIllIlllII, this.xSize / 2 - this.fontRendererObj.getStringWidth(lllllllllllllllIIlllIIIIllIlllII) / 2, 6.0, 4210752);
        this.fontRendererObj.drawString(this.field_175376_w.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    public GuiDispenser(final InventoryPlayer lllllllllllllllIIlllIIIIlllIIIll, final IInventory lllllllllllllllIIlllIIIIlllIIlIl) {
        super(new ContainerDispenser(lllllllllllllllIIlllIIIIlllIIIll, lllllllllllllllIIlllIIIIlllIIlIl));
        this.field_175376_w = lllllllllllllllIIlllIIIIlllIIIll;
        this.field_175377_u = lllllllllllllllIIlllIIIIlllIIlIl;
    }
}
