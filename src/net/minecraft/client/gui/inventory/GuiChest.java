package net.minecraft.client.gui.inventory;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class GuiChest extends GuiContainer
{
    private /* synthetic */ int inventoryRows;
    private /* synthetic */ IInventory upperChestInventory;
    private /* synthetic */ IInventory lowerChestInventory;
    private static final /* synthetic */ ResourceLocation field_147017_u;
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllllIllIIIIIlIlIlllII, final int lllllllllllllllIllIIIIIlIlIllIll, final int lllllllllllllllIllIIIIIlIlIllIlI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiChest.field_147017_u);
        final int lllllllllllllllIllIIIIIlIlIllIIl = (this.width - this.xSize) / 2;
        final int lllllllllllllllIllIIIIIlIlIllIII = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllllIllIIIIIlIlIllIIl, lllllllllllllllIllIIIIIlIlIllIII, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.drawTexturedModalRect(lllllllllllllllIllIIIIIlIlIllIIl, lllllllllllllllIllIIIIIlIlIllIII + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
    
    static {
        __OBFID = "CL_00000749";
        field_147017_u = new ResourceLocation("textures/gui/container/generic_54.png");
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllIllIIIIIlIllIIIll, final int lllllllllllllllIllIIIIIlIllIIIlI) {
        this.fontRendererObj.drawString(this.lowerChestInventory.getDisplayName().getUnformattedText(), 8.0, 6.0, 4210752);
        this.fontRendererObj.drawString(this.upperChestInventory.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    public GuiChest(final IInventory lllllllllllllllIllIIIIIlIllIlIIl, final IInventory lllllllllllllllIllIIIIIlIllIllIl) {
        super(new ContainerChest(lllllllllllllllIllIIIIIlIllIlIIl, lllllllllllllllIllIIIIIlIllIllIl, Minecraft.getMinecraft().thePlayer));
        this.upperChestInventory = lllllllllllllllIllIIIIIlIllIlIIl;
        this.lowerChestInventory = lllllllllllllllIllIIIIIlIllIllIl;
        this.allowUserInput = false;
        final short lllllllllllllllIllIIIIIlIllIllII = 222;
        final int lllllllllllllllIllIIIIIlIllIlIll = lllllllllllllllIllIIIIIlIllIllII - 108;
        this.inventoryRows = lllllllllllllllIllIIIIIlIllIllIl.getSizeInventory() / 9;
        this.ySize = lllllllllllllllIllIIIIIlIllIlIll + this.inventoryRows * 18;
    }
}
