package net.minecraft.client.gui.inventory;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class GuiScreenHorseInventory extends GuiContainer
{
    private /* synthetic */ EntityHorse field_147034_x;
    private /* synthetic */ float field_147033_y;
    private static final /* synthetic */ ResourceLocation horseGuiTextures;
    private /* synthetic */ float field_147032_z;
    private /* synthetic */ IInventory field_147029_w;
    private /* synthetic */ IInventory field_147030_v;
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllllllllIlllIlIIlIIlIlll, final int llllllllllllllllIlllIlIIlIIlIllI) {
        this.fontRendererObj.drawString(this.field_147029_w.getDisplayName().getUnformattedText(), 8.0, 6.0, 4210752);
        this.fontRendererObj.drawString(this.field_147030_v.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllllllllIlllIlIIlIIlIIII, final int llllllllllllllllIlllIlIIlIIIllll, final int llllllllllllllllIlllIlIIlIIIlllI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiScreenHorseInventory.horseGuiTextures);
        final int llllllllllllllllIlllIlIIlIIIllIl = (this.width - this.xSize) / 2;
        final int llllllllllllllllIlllIlIIlIIIllII = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(llllllllllllllllIlllIlIIlIIIllIl, llllllllllllllllIlllIlIIlIIIllII, 0, 0, this.xSize, this.ySize);
        if (this.field_147034_x.isChested()) {
            this.drawTexturedModalRect(llllllllllllllllIlllIlIIlIIIllIl + 79, llllllllllllllllIlllIlIIlIIIllII + 17, 0, this.ySize, 90, 54);
        }
        if (this.field_147034_x.canWearArmor()) {
            this.drawTexturedModalRect(llllllllllllllllIlllIlIIlIIIllIl + 7, llllllllllllllllIlllIlIIlIIIllII + 35, 0, this.ySize + 54, 18, 18);
        }
        GuiInventory.drawEntityOnScreen(llllllllllllllllIlllIlIIlIIIllIl + 51, llllllllllllllllIlllIlIIlIIIllII + 60, 17, llllllllllllllllIlllIlIIlIIIllIl + 51 - this.field_147033_y, llllllllllllllllIlllIlIIlIIIllII + 75 - 50 - this.field_147032_z, this.field_147034_x);
    }
    
    static {
        __OBFID = "CL_00000760";
        horseGuiTextures = new ResourceLocation("textures/gui/container/horse.png");
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIlllIlIIlIIIIIll, final int llllllllllllllllIlllIlIIlIIIIIlI, final float llllllllllllllllIlllIlIIlIIIIIIl) {
        this.field_147033_y = (float)llllllllllllllllIlllIlIIlIIIIIll;
        this.field_147032_z = (float)llllllllllllllllIlllIlIIlIIIIIlI;
        super.drawScreen(llllllllllllllllIlllIlIIlIIIIIll, llllllllllllllllIlllIlIIlIIIIIlI, llllllllllllllllIlllIlIIlIIIIIIl);
    }
    
    public GuiScreenHorseInventory(final IInventory llllllllllllllllIlllIlIIlIIlllII, final IInventory llllllllllllllllIlllIlIIlIIlllll, final EntityHorse llllllllllllllllIlllIlIIlIIllllI) {
        super(new ContainerHorseInventory(llllllllllllllllIlllIlIIlIIlllII, llllllllllllllllIlllIlIIlIIlllll, llllllllllllllllIlllIlIIlIIllllI, Minecraft.getMinecraft().thePlayer));
        this.field_147030_v = llllllllllllllllIlllIlIIlIIlllII;
        this.field_147029_w = llllllllllllllllIlllIlIIlIIlllll;
        this.field_147034_x = llllllllllllllllIlllIlIIlIIllllI;
        this.allowUserInput = false;
    }
}
