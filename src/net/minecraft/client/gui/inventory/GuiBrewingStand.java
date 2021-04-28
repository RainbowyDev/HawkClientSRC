package net.minecraft.client.gui.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.inventory.*;

public class GuiBrewingStand extends GuiContainer
{
    private final /* synthetic */ InventoryPlayer field_175384_v;
    private /* synthetic */ IInventory tileBrewingStand;
    private static final /* synthetic */ ResourceLocation brewingStandGuiTextures;
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllllllIIIIIlllIlllIlllll, final int llllllllllllllIIIIIlllIlllIllllI, final int llllllllllllllIIIIIlllIlllIlllIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiBrewingStand.brewingStandGuiTextures);
        final int llllllllllllllIIIIIlllIlllIlllII = (this.width - this.xSize) / 2;
        final int llllllllllllllIIIIIlllIlllIllIll = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(llllllllllllllIIIIIlllIlllIlllII, llllllllllllllIIIIIlllIlllIllIll, 0, 0, this.xSize, this.ySize);
        final int llllllllllllllIIIIIlllIlllIllIlI = this.tileBrewingStand.getField(0);
        if (llllllllllllllIIIIIlllIlllIllIlI > 0) {
            int llllllllllllllIIIIIlllIlllIllIIl = (int)(28.0f * (1.0f - llllllllllllllIIIIIlllIlllIllIlI / 400.0f));
            if (llllllllllllllIIIIIlllIlllIllIIl > 0) {
                this.drawTexturedModalRect(llllllllllllllIIIIIlllIlllIlllII + 97, llllllllllllllIIIIIlllIlllIllIll + 16, 176, 0, 9, llllllllllllllIIIIIlllIlllIllIIl);
            }
            final int llllllllllllllIIIIIlllIlllIllIII = llllllllllllllIIIIIlllIlllIllIlI / 2 % 7;
            switch (llllllllllllllIIIIIlllIlllIllIII) {
                case 0: {
                    llllllllllllllIIIIIlllIlllIllIIl = 29;
                    break;
                }
                case 1: {
                    llllllllllllllIIIIIlllIlllIllIIl = 24;
                    break;
                }
                case 2: {
                    llllllllllllllIIIIIlllIlllIllIIl = 20;
                    break;
                }
                case 3: {
                    llllllllllllllIIIIIlllIlllIllIIl = 16;
                    break;
                }
                case 4: {
                    llllllllllllllIIIIIlllIlllIllIIl = 11;
                    break;
                }
                case 5: {
                    llllllllllllllIIIIIlllIlllIllIIl = 6;
                    break;
                }
                case 6: {
                    llllllllllllllIIIIIlllIlllIllIIl = 0;
                    break;
                }
            }
            if (llllllllllllllIIIIIlllIlllIllIIl > 0) {
                this.drawTexturedModalRect(llllllllllllllIIIIIlllIlllIlllII + 65, llllllllllllllIIIIIlllIlllIllIll + 14 + 29 - llllllllllllllIIIIIlllIlllIllIIl, 185, 29 - llllllllllllllIIIIIlllIlllIllIIl, 12, llllllllllllllIIIIIlllIlllIllIIl);
            }
        }
    }
    
    public GuiBrewingStand(final InventoryPlayer llllllllllllllIIIIIlllIlllllIIll, final IInventory llllllllllllllIIIIIlllIllllIllll) {
        super(new ContainerBrewingStand(llllllllllllllIIIIIlllIlllllIIll, llllllllllllllIIIIIlllIllllIllll));
        this.field_175384_v = llllllllllllllIIIIIlllIlllllIIll;
        this.tileBrewingStand = llllllllllllllIIIIIlllIllllIllll;
    }
    
    static {
        __OBFID = "CL_00000746";
        brewingStandGuiTextures = new ResourceLocation("textures/gui/container/brewing_stand.png");
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllllllIIIIIlllIllllIlIll, final int llllllllllllllIIIIIlllIllllIlIlI) {
        final String llllllllllllllIIIIIlllIllllIlIIl = this.tileBrewingStand.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(llllllllllllllIIIIIlllIllllIlIIl, this.xSize / 2 - this.fontRendererObj.getStringWidth(llllllllllllllIIIIIlllIllllIlIIl) / 2, 6.0, 4210752);
        this.fontRendererObj.drawString(this.field_175384_v.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
}
