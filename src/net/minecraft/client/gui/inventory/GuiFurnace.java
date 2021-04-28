package net.minecraft.client.gui.inventory;

import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.*;
import net.minecraft.tileentity.*;

public class GuiFurnace extends GuiContainer
{
    private static final /* synthetic */ ResourceLocation furnaceGuiTextures;
    private /* synthetic */ IInventory tileFurnace;
    private final /* synthetic */ InventoryPlayer field_175383_v;
    
    public GuiFurnace(final InventoryPlayer lllllllllllllllllIllllllllIIlIIl, final IInventory lllllllllllllllllIllllllllIIIlIl) {
        super(new ContainerFurnace(lllllllllllllllllIllllllllIIlIIl, lllllllllllllllllIllllllllIIIlIl));
        this.field_175383_v = lllllllllllllllllIllllllllIIlIIl;
        this.tileFurnace = lllllllllllllllllIllllllllIIIlIl;
    }
    
    static {
        __OBFID = "CL_00000758";
        furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
    }
    
    private int func_175381_h(final int lllllllllllllllllIlllllllIlIIlll) {
        final int lllllllllllllllllIlllllllIlIIllI = this.tileFurnace.getField(2);
        final int lllllllllllllllllIlllllllIlIIlIl = this.tileFurnace.getField(3);
        return (lllllllllllllllllIlllllllIlIIlIl != 0 && lllllllllllllllllIlllllllIlIIllI != 0) ? (lllllllllllllllllIlllllllIlIIllI * lllllllllllllllllIlllllllIlIIlll / lllllllllllllllllIlllllllIlIIlIl) : 0;
    }
    
    private int func_175382_i(final int lllllllllllllllllIlllllllIIllIIl) {
        int lllllllllllllllllIlllllllIIllIll = this.tileFurnace.getField(1);
        if (lllllllllllllllllIlllllllIIllIll == 0) {
            lllllllllllllllllIlllllllIIllIll = 200;
        }
        return this.tileFurnace.getField(0) * lllllllllllllllllIlllllllIIllIIl / lllllllllllllllllIlllllllIIllIll;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllllIllllllllIIIIIl, final int lllllllllllllllllIllllllllIIIIII) {
        final String lllllllllllllllllIlllllllIllllll = this.tileFurnace.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(lllllllllllllllllIlllllllIllllll, this.xSize / 2 - this.fontRendererObj.getStringWidth(lllllllllllllllllIlllllllIllllll) / 2, 6.0, 4210752);
        this.fontRendererObj.drawString(this.field_175383_v.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllllllIlllllllIllIlll, final int lllllllllllllllllIlllllllIllIllI, final int lllllllllllllllllIlllllllIllIlIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiFurnace.furnaceGuiTextures);
        final int lllllllllllllllllIlllllllIllIlII = (this.width - this.xSize) / 2;
        final int lllllllllllllllllIlllllllIllIIll = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllllllIlllllllIllIlII, lllllllllllllllllIlllllllIllIIll, 0, 0, this.xSize, this.ySize);
        if (TileEntityFurnace.func_174903_a(this.tileFurnace)) {
            final int lllllllllllllllllIlllllllIllIIlI = this.func_175382_i(13);
            this.drawTexturedModalRect(lllllllllllllllllIlllllllIllIlII + 56, lllllllllllllllllIlllllllIllIIll + 36 + 12 - lllllllllllllllllIlllllllIllIIlI, 176, 12 - lllllllllllllllllIlllllllIllIIlI, 14, lllllllllllllllllIlllllllIllIIlI + 1);
        }
        final int lllllllllllllllllIlllllllIllIIIl = this.func_175381_h(24);
        this.drawTexturedModalRect(lllllllllllllllllIlllllllIllIlII + 79, lllllllllllllllllIlllllllIllIIll + 34, 176, 14, lllllllllllllllllIlllllllIllIIIl + 1, 16);
    }
}
