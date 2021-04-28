package net.minecraft.client.gui.inventory;

import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.resources.*;
import java.util.*;
import net.minecraft.client.gui.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.client.*;
import net.minecraft.potion.*;

public class GuiBeacon extends GuiContainer
{
    private /* synthetic */ boolean buttonsNotDrawn;
    private /* synthetic */ IInventory tileBeacon;
    private /* synthetic */ ConfirmButton beaconConfirmButton;
    private static final /* synthetic */ ResourceLocation beaconGuiTextures;
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final int llllllllllllllIllIllIlIIlllIIlII = this.tileBeacon.getField(0);
        final int llllllllllllllIllIllIlIIlllIIIll = this.tileBeacon.getField(1);
        final int llllllllllllllIllIllIlIIlllIIIlI = this.tileBeacon.getField(2);
        if (this.buttonsNotDrawn && llllllllllllllIllIllIlIIlllIIlII >= 0) {
            this.buttonsNotDrawn = false;
            for (int llllllllllllllIllIllIlIIllIlIlll = 0; llllllllllllllIllIllIlIIllIlIlll <= 2; ++llllllllllllllIllIllIlIIllIlIlll) {
                final int llllllllllllllIllIllIlIIlllIIIIl = TileEntityBeacon.effectsList[llllllllllllllIllIllIlIIllIlIlll].length;
                final int llllllllllllllIllIllIlIIllIlllll = llllllllllllllIllIllIlIIlllIIIIl * 22 + (llllllllllllllIllIllIlIIlllIIIIl - 1) * 2;
                for (int llllllllllllllIllIllIlIIllIlllIl = 0; llllllllllllllIllIllIlIIllIlllIl < llllllllllllllIllIllIlIIlllIIIIl; ++llllllllllllllIllIllIlIIllIlllIl) {
                    final int llllllllllllllIllIllIlIIllIllIll = TileEntityBeacon.effectsList[llllllllllllllIllIllIlIIllIlIlll][llllllllllllllIllIllIlIIllIlllIl].id;
                    final PowerButton llllllllllllllIllIllIlIIllIllIIl = new PowerButton(llllllllllllllIllIllIlIIllIlIlll << 8 | llllllllllllllIllIllIlIIllIllIll, this.guiLeft + 76 + llllllllllllllIllIllIlIIllIlllIl * 24 - llllllllllllllIllIllIlIIllIlllll / 2, this.guiTop + 22 + llllllllllllllIllIllIlIIllIlIlll * 25, llllllllllllllIllIllIlIIllIllIll, llllllllllllllIllIllIlIIllIlIlll);
                    this.buttonList.add(llllllllllllllIllIllIlIIllIllIIl);
                    if (llllllllllllllIllIllIlIIllIlIlll >= llllllllllllllIllIllIlIIlllIIlII) {
                        llllllllllllllIllIllIlIIllIllIIl.enabled = false;
                    }
                    else if (llllllllllllllIllIllIlIIllIllIll == llllllllllllllIllIllIlIIlllIIIll) {
                        llllllllllllllIllIllIlIIllIllIIl.func_146140_b(true);
                    }
                }
            }
            final byte llllllllllllllIllIllIlIIllIlIllI = 3;
            final int llllllllllllllIllIllIlIIlllIIIII = TileEntityBeacon.effectsList[llllllllllllllIllIllIlIIllIlIllI].length + 1;
            final int llllllllllllllIllIllIlIIllIllllI = llllllllllllllIllIllIlIIlllIIIII * 22 + (llllllllllllllIllIllIlIIlllIIIII - 1) * 2;
            for (int llllllllllllllIllIllIlIIllIlllII = 0; llllllllllllllIllIllIlIIllIlllII < llllllllllllllIllIllIlIIlllIIIII - 1; ++llllllllllllllIllIllIlIIllIlllII) {
                final int llllllllllllllIllIllIlIIllIllIlI = TileEntityBeacon.effectsList[llllllllllllllIllIllIlIIllIlIllI][llllllllllllllIllIllIlIIllIlllII].id;
                final PowerButton llllllllllllllIllIllIlIIllIllIII = new PowerButton(llllllllllllllIllIllIlIIllIlIllI << 8 | llllllllllllllIllIllIlIIllIllIlI, this.guiLeft + 167 + llllllllllllllIllIllIlIIllIlllII * 24 - llllllllllllllIllIllIlIIllIllllI / 2, this.guiTop + 47, llllllllllllllIllIllIlIIllIllIlI, llllllllllllllIllIllIlIIllIlIllI);
                this.buttonList.add(llllllllllllllIllIllIlIIllIllIII);
                if (llllllllllllllIllIllIlIIllIlIllI >= llllllllllllllIllIllIlIIlllIIlII) {
                    llllllllllllllIllIllIlIIllIllIII.enabled = false;
                }
                else if (llllllllllllllIllIllIlIIllIllIlI == llllllllllllllIllIllIlIIlllIIIlI) {
                    llllllllllllllIllIllIlIIllIllIII.func_146140_b(true);
                }
            }
            if (llllllllllllllIllIllIlIIlllIIIll > 0) {
                final PowerButton llllllllllllllIllIllIlIIllIlIlIl = new PowerButton(llllllllllllllIllIllIlIIllIlIllI << 8 | llllllllllllllIllIllIlIIlllIIIll, this.guiLeft + 167 + (llllllllllllllIllIllIlIIlllIIIII - 1) * 24 - llllllllllllllIllIllIlIIllIllllI / 2, this.guiTop + 47, llllllllllllllIllIllIlIIlllIIIll, llllllllllllllIllIllIlIIllIlIllI);
                this.buttonList.add(llllllllllllllIllIllIlIIllIlIlIl);
                if (llllllllllllllIllIllIlIIllIlIllI >= llllllllllllllIllIllIlIIlllIIlII) {
                    llllllllllllllIllIllIlIIllIlIlIl.enabled = false;
                }
                else if (llllllllllllllIllIllIlIIlllIIIll == llllllllllllllIllIllIlIIlllIIIlI) {
                    llllllllllllllIllIllIlIIllIlIlIl.func_146140_b(true);
                }
            }
        }
        this.beaconConfirmButton.enabled = (this.tileBeacon.getStackInSlot(0) != null && llllllllllllllIllIllIlIIlllIIIll > 0);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllllllIllIllIlIIlIllIIlI, final int llllllllllllllIllIllIlIIlIlIllII) {
        RenderHelper.disableStandardItemLighting();
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.primary", new Object[0]), 62, 10, 14737632);
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.secondary", new Object[0]), 169, 10, 14737632);
        for (final GuiButton llllllllllllllIllIllIlIIlIlIllll : this.buttonList) {
            if (llllllllllllllIllIllIlIIlIlIllll.isMouseOver()) {
                llllllllllllllIllIllIlIIlIlIllll.drawButtonForegroundLayer(llllllllllllllIllIllIlIIlIllIIlI - this.guiLeft, llllllllllllllIllIllIlIIlIlIllII - this.guiTop);
                break;
            }
        }
        RenderHelper.enableGUIStandardItemLighting();
    }
    
    @Override
    public void initGui() {
        super.initGui();
        final List buttonList = this.buttonList;
        final ConfirmButton beaconConfirmButton = new ConfirmButton(-1, this.guiLeft + 164, this.guiTop + 107);
        this.beaconConfirmButton = beaconConfirmButton;
        buttonList.add(beaconConfirmButton);
        this.buttonList.add(new CancelButton(-2, this.guiLeft + 190, this.guiTop + 107));
        this.buttonsNotDrawn = true;
        this.beaconConfirmButton.enabled = false;
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIllIllIlIIlIllllII) throws IOException {
        if (llllllllllllllIllIllIlIIlIllllII.id == -2) {
            this.mc.displayGuiScreen(null);
        }
        else if (llllllllllllllIllIllIlIIlIllllII.id == -1) {
            final String llllllllllllllIllIllIlIIllIIIIlI = "MC|Beacon";
            final PacketBuffer llllllllllllllIllIllIlIIllIIIIIl = new PacketBuffer(Unpooled.buffer());
            llllllllllllllIllIllIlIIllIIIIIl.writeInt(this.tileBeacon.getField(1));
            llllllllllllllIllIllIlIIllIIIIIl.writeInt(this.tileBeacon.getField(2));
            this.mc.getNetHandler().addToSendQueue(new C17PacketCustomPayload(llllllllllllllIllIllIlIIllIIIIlI, llllllllllllllIllIllIlIIllIIIIIl));
            this.mc.displayGuiScreen(null);
        }
        else if (llllllllllllllIllIllIlIIlIllllII instanceof PowerButton) {
            if (((PowerButton)llllllllllllllIllIllIlIIlIllllII).func_146141_c()) {
                return;
            }
            final int llllllllllllllIllIllIlIIllIIIIII = llllllllllllllIllIllIlIIlIllllII.id;
            final int llllllllllllllIllIllIlIIlIllllll = llllllllllllllIllIllIlIIllIIIIII & 0xFF;
            final int llllllllllllllIllIllIlIIlIlllllI = llllllllllllllIllIllIlIIllIIIIII >> 8;
            if (llllllllllllllIllIllIlIIlIlllllI < 3) {
                this.tileBeacon.setField(1, llllllllllllllIllIllIlIIlIllllll);
            }
            else {
                this.tileBeacon.setField(2, llllllllllllllIllIllIlIIlIllllll);
            }
            this.buttonList.clear();
            this.initGui();
            this.updateScreen();
        }
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllllllIllIllIlIIlIlIIlIl, final int llllllllllllllIllIllIlIIlIlIIlII, final int llllllllllllllIllIllIlIIlIlIIIll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiBeacon.beaconGuiTextures);
        final int llllllllllllllIllIllIlIIlIlIIIlI = (this.width - this.xSize) / 2;
        final int llllllllllllllIllIllIlIIlIlIIIIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(llllllllllllllIllIllIlIIlIlIIIlI, llllllllllllllIllIllIlIIlIlIIIIl, 0, 0, this.xSize, this.ySize);
        this.itemRender.zLevel = 100.0f;
        this.itemRender.func_180450_b(new ItemStack(Items.emerald), llllllllllllllIllIllIlIIlIlIIIlI + 42, llllllllllllllIllIllIlIIlIlIIIIl + 109);
        this.itemRender.func_180450_b(new ItemStack(Items.diamond), llllllllllllllIllIllIlIIlIlIIIlI + 42 + 22, llllllllllllllIllIllIlIIlIlIIIIl + 109);
        this.itemRender.func_180450_b(new ItemStack(Items.gold_ingot), llllllllllllllIllIllIlIIlIlIIIlI + 42 + 44, llllllllllllllIllIllIlIIlIlIIIIl + 109);
        this.itemRender.func_180450_b(new ItemStack(Items.iron_ingot), llllllllllllllIllIllIlIIlIlIIIlI + 42 + 66, llllllllllllllIllIllIlIIlIlIIIIl + 109);
        this.itemRender.zLevel = 0.0f;
    }
    
    static {
        __OBFID = "CL_00000739";
        logger = LogManager.getLogger();
        beaconGuiTextures = new ResourceLocation("textures/gui/container/beacon.png");
    }
    
    public GuiBeacon(final InventoryPlayer llllllllllllllIllIllIlIIlllllIII, final IInventory llllllllllllllIllIllIlIIllllIlll) {
        super(new ContainerBeacon(llllllllllllllIllIllIlIIlllllIII, llllllllllllllIllIllIlIIllllIlll));
        this.tileBeacon = llllllllllllllIllIllIlIIllllIlll;
        this.xSize = 230;
        this.ySize = 219;
    }
    
    class ConfirmButton extends Button
    {
        static {
            __OBFID = "CL_00000741";
        }
        
        public ConfirmButton(final int llllllllllllllIIIllIllIlllIIIIll, final int llllllllllllllIIIllIllIlllIIIIlI, final int llllllllllllllIIIllIllIlllIIIIIl) {
            super(llllllllllllllIIIllIllIlllIIIIll, llllllllllllllIIIllIllIlllIIIIlI, llllllllllllllIIIllIllIlllIIIIIl, GuiBeacon.beaconGuiTextures, 90, 220);
        }
        
        @Override
        public void drawButtonForegroundLayer(final int llllllllllllllIIIllIllIllIllllII, final int llllllllllllllIIIllIllIllIlllIII) {
            GuiScreen.this.drawCreativeTabHoveringText(I18n.format("gui.done", new Object[0]), llllllllllllllIIIllIllIllIllllII, llllllllllllllIIIllIllIllIlllIII);
        }
    }
    
    static class Button extends GuiButton
    {
        private final /* synthetic */ int field_146144_p;
        private /* synthetic */ boolean field_146142_r;
        private final /* synthetic */ int field_146143_q;
        private final /* synthetic */ ResourceLocation field_146145_o;
        
        public boolean func_146141_c() {
            return this.field_146142_r;
        }
        
        public void func_146140_b(final boolean lllllllllllllllIIllIllllIlIIlIII) {
            this.field_146142_r = lllllllllllllllIIllIllllIlIIlIII;
        }
        
        protected Button(final int lllllllllllllllIIllIllllIllIllIl, final int lllllllllllllllIIllIllllIllIIlIl, final int lllllllllllllllIIllIllllIllIlIll, final ResourceLocation lllllllllllllllIIllIllllIllIlIlI, final int lllllllllllllllIIllIllllIllIlIIl, final int lllllllllllllllIIllIllllIllIIIIl) {
            super(lllllllllllllllIIllIllllIllIllIl, lllllllllllllllIIllIllllIllIIlIl, lllllllllllllllIIllIllllIllIlIll, 22, 22, "");
            this.field_146145_o = lllllllllllllllIIllIllllIllIlIlI;
            this.field_146144_p = lllllllllllllllIIllIllllIllIlIIl;
            this.field_146143_q = lllllllllllllllIIllIllllIllIIIIl;
        }
        
        @Override
        public void drawButton(final Minecraft lllllllllllllllIIllIllllIlIlIIll, final int lllllllllllllllIIllIllllIlIllIII, final int lllllllllllllllIIllIllllIlIlIlll) {
            if (this.visible) {
                lllllllllllllllIIllIllllIlIlIIll.getTextureManager().bindTexture(GuiBeacon.beaconGuiTextures);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.hovered = (lllllllllllllllIIllIllllIlIllIII >= this.xPosition && lllllllllllllllIIllIllllIlIlIlll >= this.yPosition && lllllllllllllllIIllIllllIlIllIII < this.xPosition + this.width && lllllllllllllllIIllIllllIlIlIlll < this.yPosition + this.height);
                final short lllllllllllllllIIllIllllIlIlIllI = 219;
                int lllllllllllllllIIllIllllIlIlIlIl = 0;
                if (!this.enabled) {
                    lllllllllllllllIIllIllllIlIlIlIl += this.width * 2;
                }
                else if (this.field_146142_r) {
                    lllllllllllllllIIllIllllIlIlIlIl += this.width * 1;
                }
                else if (this.hovered) {
                    lllllllllllllllIIllIllllIlIlIlIl += this.width * 3;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, lllllllllllllllIIllIllllIlIlIlIl, lllllllllllllllIIllIllllIlIlIllI, this.width, this.height);
                if (!GuiBeacon.beaconGuiTextures.equals(this.field_146145_o)) {
                    lllllllllllllllIIllIllllIlIlIIll.getTextureManager().bindTexture(this.field_146145_o);
                }
                this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, this.field_146144_p, this.field_146143_q, 18, 18);
            }
        }
        
        static {
            __OBFID = "CL_00000743";
        }
    }
    
    class PowerButton extends Button
    {
        private final /* synthetic */ int field_146149_p;
        private final /* synthetic */ int field_146148_q;
        
        @Override
        public void drawButtonForegroundLayer(final int lllllllllllllllllIIlIllIlIlIIIll, final int lllllllllllllllllIIlIllIlIIllllI) {
            String lllllllllllllllllIIlIllIlIlIIIIl = I18n.format(Potion.potionTypes[this.field_146149_p].getName(), new Object[0]);
            if (this.field_146148_q >= 3 && this.field_146149_p != Potion.regeneration.id) {
                lllllllllllllllllIIlIllIlIlIIIIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIlIllIlIlIIIIl)).append(" II"));
            }
            GuiScreen.this.drawCreativeTabHoveringText(lllllllllllllllllIIlIllIlIlIIIIl, lllllllllllllllllIIlIllIlIlIIIll, lllllllllllllllllIIlIllIlIIllllI);
        }
        
        public PowerButton(final int lllllllllllllllllIIlIllIlIllIlII, final int lllllllllllllllllIIlIllIlIlIllII, final int lllllllllllllllllIIlIllIlIlIlIll, final int lllllllllllllllllIIlIllIlIlIlIlI, final int lllllllllllllllllIIlIllIlIlIlIIl) {
            super(lllllllllllllllllIIlIllIlIllIlII, lllllllllllllllllIIlIllIlIlIllII, lllllllllllllllllIIlIllIlIlIlIll, GuiContainer.inventoryBackground, 0 + Potion.potionTypes[lllllllllllllllllIIlIllIlIlIlIlI].getStatusIconIndex() % 8 * 18, 198 + Potion.potionTypes[lllllllllllllllllIIlIllIlIlIlIlI].getStatusIconIndex() / 8 * 18);
            this.field_146149_p = lllllllllllllllllIIlIllIlIlIlIlI;
            this.field_146148_q = lllllllllllllllllIIlIllIlIlIlIIl;
        }
        
        static {
            __OBFID = "CL_00000742";
        }
    }
    
    class CancelButton extends Button
    {
        static {
            __OBFID = "CL_00000740";
        }
        
        public CancelButton(final int llllllllllllllllIlllllIIIlllIIII, final int llllllllllllllllIlllllIIIllIllll, final int llllllllllllllllIlllllIIIllIlIIl) {
            super(llllllllllllllllIlllllIIIlllIIII, llllllllllllllllIlllllIIIllIllll, llllllllllllllllIlllllIIIllIlIIl, GuiBeacon.beaconGuiTextures, 112, 220);
        }
        
        @Override
        public void drawButtonForegroundLayer(final int llllllllllllllllIlllllIIIllIIlII, final int llllllllllllllllIlllllIIIllIIIll) {
            GuiScreen.this.drawCreativeTabHoveringText(I18n.format("gui.cancel", new Object[0]), llllllllllllllllIlllllIIIllIIlII, llllllllllllllllIlllllIIIllIIIll);
        }
    }
}
