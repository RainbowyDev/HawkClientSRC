package net.minecraft.client.gui.inventory;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.inventory.*;

public class GuiCrafting extends GuiContainer
{
    private static final /* synthetic */ ResourceLocation craftingTableGuiTextures;
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllllllIllIIIlllIllIllIIl, final int llllllllllllllIllIIIlllIllIllIII, final int llllllllllllllIllIIIlllIllIlIlll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiCrafting.craftingTableGuiTextures);
        final int llllllllllllllIllIIIlllIllIlIllI = (this.width - this.xSize) / 2;
        final int llllllllllllllIllIIIlllIllIlIlIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(llllllllllllllIllIIIlllIllIlIllI, llllllllllllllIllIIIlllIllIlIlIl, 0, 0, this.xSize, this.ySize);
    }
    
    public GuiCrafting(final InventoryPlayer llllllllllllllIllIIIlllIllllIIll, final World llllllllllllllIllIIIlllIlllIllll) {
        this(llllllllllllllIllIIIlllIllllIIll, llllllllllllllIllIIIlllIlllIllll, BlockPos.ORIGIN);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllllllIllIIIlllIlllIIIII, final int llllllllllllllIllIIIlllIllIlllll) {
        this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 28.0, 6.0, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    public GuiCrafting(final InventoryPlayer llllllllllllllIllIIIlllIlllIIlIl, final World llllllllllllllIllIIIlllIlllIIlII, final BlockPos llllllllllllllIllIIIlllIlllIIIll) {
        super(new ContainerWorkbench(llllllllllllllIllIIIlllIlllIIlIl, llllllllllllllIllIIIlllIlllIIlII, llllllllllllllIllIIIlllIlllIIIll));
    }
    
    static {
        __OBFID = "CL_00000750";
        craftingTableGuiTextures = new ResourceLocation("textures/gui/container/crafting_table.png");
    }
}
