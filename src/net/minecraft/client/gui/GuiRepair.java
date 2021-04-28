package net.minecraft.client.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.world.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import java.io.*;
import java.util.*;
import org.lwjgl.input.*;
import net.minecraft.item.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.inventory.*;

public class GuiRepair extends GuiContainer implements ICrafting
{
    private /* synthetic */ ContainerRepair anvil;
    private /* synthetic */ GuiTextField nameField;
    private static final /* synthetic */ ResourceLocation anvilResource;
    private /* synthetic */ InventoryPlayer playerInventory;
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llIIlIIllIll, final int llIIlIIllIlI) {
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        this.fontRendererObj.drawString(I18n.format("container.repair", new Object[0]), 60.0, 6.0, 4210752);
        if (this.anvil.maximumCost > 0) {
            int llIIlIIllIIl = 8453920;
            boolean llIIlIIllIII = true;
            String llIIlIIlIlll = I18n.format("container.repair.cost", this.anvil.maximumCost);
            if (this.anvil.maximumCost >= 40 && !this.mc.thePlayer.capabilities.isCreativeMode) {
                llIIlIIlIlll = I18n.format("container.repair.expensive", new Object[0]);
                llIIlIIllIIl = 16736352;
            }
            else if (!this.anvil.getSlot(2).getHasStack()) {
                llIIlIIllIII = false;
            }
            else if (!this.anvil.getSlot(2).canTakeStack(this.playerInventory.player)) {
                llIIlIIllIIl = 16736352;
            }
            if (llIIlIIllIII) {
                final int llIIlIIlIllI = 0xFF000000 | (llIIlIIllIIl & 0xFCFCFC) >> 2 | (llIIlIIllIIl & 0xFF000000);
                final int llIIlIIlIlIl = this.xSize - 8 - this.fontRendererObj.getStringWidth(llIIlIIlIlll);
                final byte llIIlIIlIlII = 67;
                if (this.fontRendererObj.getUnicodeFlag()) {
                    Gui.drawRect(llIIlIIlIlIl - 3, llIIlIIlIlII - 2, this.xSize - 7, llIIlIIlIlII + 10, -16777216);
                    Gui.drawRect(llIIlIIlIlIl - 2, llIIlIIlIlII - 1, this.xSize - 8, llIIlIIlIlII + 9, -12895429);
                }
                else {
                    this.fontRendererObj.drawString(llIIlIIlIlll, llIIlIIlIlIl, llIIlIIlIlII + 1, llIIlIIlIllI);
                    this.fontRendererObj.drawString(llIIlIIlIlll, llIIlIIlIlIl + 1, llIIlIIlIlII, llIIlIIlIllI);
                    this.fontRendererObj.drawString(llIIlIIlIlll, llIIlIIlIlIl + 1, llIIlIIlIlII + 1, llIIlIIlIllI);
                }
                this.fontRendererObj.drawString(llIIlIIlIlll, llIIlIIlIlIl, llIIlIIlIlII, llIIlIIllIIl);
            }
        }
        GlStateManager.enableLighting();
    }
    
    public GuiRepair(final InventoryPlayer llIIlIllIlII, final World llIIlIllIIII) {
        super(new ContainerRepair(llIIlIllIlII, llIIlIllIIII, Minecraft.getMinecraft().thePlayer));
        this.playerInventory = llIIlIllIlII;
        this.anvil = (ContainerRepair)this.inventorySlots;
    }
    
    @Override
    protected void mouseClicked(final int llIIIlllIlIl, final int llIIIlllIlII, final int llIIIlllIIll) throws IOException {
        super.mouseClicked(llIIIlllIlIl, llIIIlllIlII, llIIIlllIIll);
        this.nameField.mouseClicked(llIIIlllIlIl, llIIIlllIlII, llIIIlllIIll);
    }
    
    @Override
    public void updateCraftingInventory(final Container llIIIlIlIIll, final List llIIIlIlIIlI) {
        this.sendSlotContents(llIIIlIlIIll, 0, llIIIlIlIIll.getSlot(0).getStack());
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llIIIlIllllI, final int llIIIlIlllIl, final int llIIIlIlllII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiRepair.anvilResource);
        final int llIIIlIllIll = (this.width - this.xSize) / 2;
        final int llIIIlIllIlI = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(llIIIlIllIll, llIIIlIllIlI, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(llIIIlIllIll + 59, llIIIlIllIlI + 20, 0, this.ySize + (this.anvil.getSlot(0).getHasStack() ? 0 : 16), 110, 16);
        if ((this.anvil.getSlot(0).getHasStack() || this.anvil.getSlot(1).getHasStack()) && !this.anvil.getSlot(2).getHasStack()) {
            this.drawTexturedModalRect(llIIIlIllIll + 99, llIIIlIllIlI + 45, this.xSize, 0, 28, 21);
        }
    }
    
    static {
        __OBFID = "CL_00000738";
        anvilResource = new ResourceLocation("textures/gui/container/anvil.png");
    }
    
    @Override
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(true);
        final int llIIlIlIlIll = (this.width - this.xSize) / 2;
        final int llIIlIlIlIlI = (this.height - this.ySize) / 2;
        this.nameField = new GuiTextField(0, this.fontRendererObj, llIIlIlIlIll + 62, llIIlIlIlIlI + 24, 103, 12);
        this.nameField.setTextColor(-1);
        this.nameField.setDisabledTextColour(-1);
        this.nameField.setEnableBackgroundDrawing(false);
        this.nameField.setMaxStringLength(40);
        this.inventorySlots.removeCraftingFromCrafters(this);
        this.inventorySlots.onCraftGuiOpened(this);
    }
    
    @Override
    public void func_175173_a(final Container llIIIlIIIIII, final IInventory llIIIIllllll) {
    }
    
    @Override
    public void sendProgressBarUpdate(final Container llIIIlIIIlII, final int llIIIlIIIIll, final int llIIIlIIIIlI) {
    }
    
    @Override
    public void drawScreen(final int llIIIllIlIIl, final int llIIIllIlIII, final float llIIIllIIIll) {
        super.drawScreen(llIIIllIlIIl, llIIIllIlIII, llIIIllIIIll);
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        this.nameField.drawTextBox();
    }
    
    @Override
    protected void keyTyped(final char llIIlIIIIlIl, final int llIIlIIIIlll) throws IOException {
        if (this.nameField.textboxKeyTyped(llIIlIIIIlIl, llIIlIIIIlll)) {
            this.renameItem();
        }
        else {
            super.keyTyped(llIIlIIIIlIl, llIIlIIIIlll);
        }
    }
    
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
        this.inventorySlots.removeCraftingFromCrafters(this);
    }
    
    @Override
    public void sendSlotContents(final Container llIIIlIIlIll, final int llIIIlIIlIlI, final ItemStack llIIIlIIIllI) {
        if (llIIIlIIlIlI == 0) {
            this.nameField.setText((llIIIlIIIllI == null) ? "" : llIIIlIIIllI.getDisplayName());
            this.nameField.setEnabled(llIIIlIIIllI != null);
            if (llIIIlIIIllI != null) {
                this.renameItem();
            }
        }
    }
    
    private void renameItem() {
        String llIIIlllllll = this.nameField.getText();
        final Slot llIIIllllllI = this.anvil.getSlot(0);
        if (llIIIllllllI != null && llIIIllllllI.getHasStack() && !llIIIllllllI.getStack().hasDisplayName() && llIIIlllllll.equals(llIIIllllllI.getStack().getDisplayName())) {
            llIIIlllllll = "";
        }
        this.anvil.updateItemName(llIIIlllllll);
        this.mc.thePlayer.sendQueue.addToSendQueue(new C17PacketCustomPayload("MC|ItemName", new PacketBuffer(Unpooled.buffer()).writeString(llIIIlllllll)));
    }
}
