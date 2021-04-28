package net.minecraft.client.gui.inventory;

import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;
import java.util.*;
import java.io.*;
import hawk.events.listeners.*;
import hawk.*;
import hawk.events.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.texture.*;

public abstract class GuiContainer extends GuiScreen
{
    protected /* synthetic */ int guiTop;
    private /* synthetic */ int touchUpX;
    private /* synthetic */ Slot currentDragTargetSlot;
    protected /* synthetic */ int guiLeft;
    private /* synthetic */ Slot theSlot;
    private /* synthetic */ boolean isRightMouseClick;
    private /* synthetic */ ItemStack draggedStack;
    private /* synthetic */ int dragSplittingButton;
    private /* synthetic */ boolean ignoreMouseUp;
    private /* synthetic */ int dragSplittingRemnant;
    private /* synthetic */ ItemStack shiftClickedSlot;
    private /* synthetic */ long lastClickTime;
    private /* synthetic */ long returningStackTime;
    private /* synthetic */ int touchUpY;
    protected final /* synthetic */ Set dragSplittingSlots;
    protected /* synthetic */ boolean dragSplitting;
    protected /* synthetic */ int xSize;
    public /* synthetic */ Container inventorySlots;
    private /* synthetic */ int dragSplittingLimit;
    private /* synthetic */ ItemStack returningStack;
    private /* synthetic */ long dragItemDropDelay;
    private /* synthetic */ Slot clickedSlot;
    private /* synthetic */ Slot lastClickSlot;
    private /* synthetic */ int lastClickButton;
    protected /* synthetic */ int ySize;
    private /* synthetic */ boolean doubleClick;
    private /* synthetic */ Slot returningStackDestSlot;
    
    @Override
    protected void mouseReleased(final int lllllllllllllllllIllIlIlllIlIlII, final int lllllllllllllllllIllIlIlllIlIIll, final int lllllllllllllllllIllIlIllllIIIIl) {
        final Slot lllllllllllllllllIllIlIllllIIIII = this.getSlotAtPosition(lllllllllllllllllIllIlIlllIlIlII, lllllllllllllllllIllIlIlllIlIIll);
        final int lllllllllllllllllIllIlIlllIlllll = this.guiLeft;
        final int lllllllllllllllllIllIlIlllIllllI = this.guiTop;
        final boolean lllllllllllllllllIllIlIlllIlllIl = lllllllllllllllllIllIlIlllIlIlII < lllllllllllllllllIllIlIlllIlllll || lllllllllllllllllIllIlIlllIlIIll < lllllllllllllllllIllIlIlllIllllI || lllllllllllllllllIllIlIlllIlIlII >= lllllllllllllllllIllIlIlllIlllll + this.xSize || lllllllllllllllllIllIlIlllIlIIll >= lllllllllllllllllIllIlIlllIllllI + this.ySize;
        int lllllllllllllllllIllIlIlllIlllII = -1;
        if (lllllllllllllllllIllIlIllllIIIII != null) {
            lllllllllllllllllIllIlIlllIlllII = lllllllllllllllllIllIlIllllIIIII.slotNumber;
        }
        if (lllllllllllllllllIllIlIlllIlllIl) {
            lllllllllllllllllIllIlIlllIlllII = -999;
        }
        if (this.doubleClick && lllllllllllllllllIllIlIllllIIIII != null && lllllllllllllllllIllIlIllllIIIIl == 0 && this.inventorySlots.func_94530_a(null, lllllllllllllllllIllIlIllllIIIII)) {
            if (isShiftKeyDown()) {
                if (lllllllllllllllllIllIlIllllIIIII != null && lllllllllllllllllIllIlIllllIIIII.inventory != null && this.shiftClickedSlot != null) {
                    for (final Slot lllllllllllllllllIllIlIlllIllIll : this.inventorySlots.inventorySlots) {
                        if (lllllllllllllllllIllIlIlllIllIll != null && lllllllllllllllllIllIlIlllIllIll.canTakeStack(this.mc.thePlayer) && lllllllllllllllllIllIlIlllIllIll.getHasStack() && lllllllllllllllllIllIlIlllIllIll.inventory == lllllllllllllllllIllIlIllllIIIII.inventory && Container.canAddItemToSlot(lllllllllllllllllIllIlIlllIllIll, this.shiftClickedSlot, true)) {
                            this.handleMouseClick(lllllllllllllllllIllIlIlllIllIll, lllllllllllllllllIllIlIlllIllIll.slotNumber, lllllllllllllllllIllIlIllllIIIIl, 1);
                        }
                    }
                }
            }
            else {
                this.handleMouseClick(lllllllllllllllllIllIlIllllIIIII, lllllllllllllllllIllIlIlllIlllII, lllllllllllllllllIllIlIllllIIIIl, 6);
            }
            this.doubleClick = false;
            this.lastClickTime = 0L;
        }
        else {
            if (this.dragSplitting && this.dragSplittingButton != lllllllllllllllllIllIlIllllIIIIl) {
                this.dragSplitting = false;
                this.dragSplittingSlots.clear();
                this.ignoreMouseUp = true;
                return;
            }
            if (this.ignoreMouseUp) {
                this.ignoreMouseUp = false;
                return;
            }
            if (this.clickedSlot != null && this.mc.gameSettings.touchscreen) {
                if (lllllllllllllllllIllIlIllllIIIIl == 0 || lllllllllllllllllIllIlIllllIIIIl == 1) {
                    if (this.draggedStack == null && lllllllllllllllllIllIlIllllIIIII != this.clickedSlot) {
                        this.draggedStack = this.clickedSlot.getStack();
                    }
                    final boolean lllllllllllllllllIllIlIlllIlIlll = Container.canAddItemToSlot(lllllllllllllllllIllIlIllllIIIII, this.draggedStack, false);
                    if (lllllllllllllllllIllIlIlllIlllII != -1 && this.draggedStack != null && lllllllllllllllllIllIlIlllIlIlll) {
                        this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, lllllllllllllllllIllIlIllllIIIIl, 0);
                        this.handleMouseClick(lllllllllllllllllIllIlIllllIIIII, lllllllllllllllllIllIlIlllIlllII, 0, 0);
                        if (this.mc.thePlayer.inventory.getItemStack() != null) {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, lllllllllllllllllIllIlIllllIIIIl, 0);
                            this.touchUpX = lllllllllllllllllIllIlIlllIlIlII - lllllllllllllllllIllIlIlllIlllll;
                            this.touchUpY = lllllllllllllllllIllIlIlllIlIIll - lllllllllllllllllIllIlIlllIllllI;
                            this.returningStackDestSlot = this.clickedSlot;
                            this.returningStack = this.draggedStack;
                            this.returningStackTime = Minecraft.getSystemTime();
                        }
                        else {
                            this.returningStack = null;
                        }
                    }
                    else if (this.draggedStack != null) {
                        this.touchUpX = lllllllllllllllllIllIlIlllIlIlII - lllllllllllllllllIllIlIlllIlllll;
                        this.touchUpY = lllllllllllllllllIllIlIlllIlIIll - lllllllllllllllllIllIlIlllIllllI;
                        this.returningStackDestSlot = this.clickedSlot;
                        this.returningStack = this.draggedStack;
                        this.returningStackTime = Minecraft.getSystemTime();
                    }
                    this.draggedStack = null;
                    this.clickedSlot = null;
                }
            }
            else if (this.dragSplitting && !this.dragSplittingSlots.isEmpty()) {
                this.handleMouseClick(null, -999, Container.func_94534_d(0, this.dragSplittingLimit), 5);
                for (final Slot lllllllllllllllllIllIlIlllIllIlI : this.dragSplittingSlots) {
                    this.handleMouseClick(lllllllllllllllllIllIlIlllIllIlI, lllllllllllllllllIllIlIlllIllIlI.slotNumber, Container.func_94534_d(1, this.dragSplittingLimit), 5);
                }
                this.handleMouseClick(null, -999, Container.func_94534_d(2, this.dragSplittingLimit), 5);
            }
            else if (this.mc.thePlayer.inventory.getItemStack() != null) {
                if (lllllllllllllllllIllIlIllllIIIIl == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                    this.handleMouseClick(lllllllllllllllllIllIlIllllIIIII, lllllllllllllllllIllIlIlllIlllII, lllllllllllllllllIllIlIllllIIIIl, 3);
                }
                else {
                    final boolean lllllllllllllllllIllIlIlllIlIllI = lllllllllllllllllIllIlIlllIlllII != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                    if (lllllllllllllllllIllIlIlllIlIllI) {
                        this.shiftClickedSlot = ((lllllllllllllllllIllIlIllllIIIII != null && lllllllllllllllllIllIlIllllIIIII.getHasStack()) ? lllllllllllllllllIllIlIllllIIIII.getStack() : null);
                    }
                    this.handleMouseClick(lllllllllllllllllIllIlIllllIIIII, lllllllllllllllllIllIlIlllIlllII, lllllllllllllllllIllIlIllllIIIIl, lllllllllllllllllIllIlIlllIlIllI ? 1 : 0);
                }
            }
        }
        if (this.mc.thePlayer.inventory.getItemStack() == null) {
            this.lastClickTime = 0L;
        }
        this.dragSplitting = false;
    }
    
    protected void handleMouseClick(final Slot lllllllllllllllllIllIlIllIIlllII, int lllllllllllllllllIllIlIllIIlIllI, final int lllllllllllllllllIllIlIllIIlIlIl, final int lllllllllllllllllIllIlIllIIlIlII) {
        if (lllllllllllllllllIllIlIllIIlllII != null) {
            lllllllllllllllllIllIlIllIIlIllI = lllllllllllllllllIllIlIllIIlllII.slotNumber;
        }
        this.mc.playerController.windowClick(this.inventorySlots.windowId, lllllllllllllllllIllIlIllIIlIllI, lllllllllllllllllIllIlIllIIlIlIl, lllllllllllllllllIllIlIllIIlIlII, this.mc.thePlayer);
    }
    
    private void drawItemStack(final ItemStack lllllllllllllllllIllIllIIllllIll, final int lllllllllllllllllIllIllIIllllIlI, final int lllllllllllllllllIllIllIIlllIlII, final String lllllllllllllllllIllIllIIlllIIll) {
        GlStateManager.translate(0.0f, 0.0f, 32.0f);
        this.zLevel = 200.0f;
        this.itemRender.zLevel = 200.0f;
        this.itemRender.func_180450_b(lllllllllllllllllIllIllIIllllIll, lllllllllllllllllIllIllIIllllIlI, lllllllllllllllllIllIllIIlllIlII);
        this.itemRender.func_180453_a(this.fontRendererObj, lllllllllllllllllIllIllIIllllIll, lllllllllllllllllIllIllIIllllIlI, lllllllllllllllllIllIllIIlllIlII - ((this.draggedStack == null) ? 0 : 8), lllllllllllllllllIllIllIIlllIIll);
        this.zLevel = 0.0f;
        this.itemRender.zLevel = 0.0f;
    }
    
    protected abstract void drawGuiContainerBackgroundLayer(final float p0, final int p1, final int p2);
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllllIllIllIIlllIIIl, final int lllllllllllllllllIllIllIIlllIIII) {
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.mc.thePlayer.openContainer = this.inventorySlots;
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllllIllIllIIIIlllll, final int lllllllllllllllllIllIllIIIIllllI, final int lllllllllllllllllIllIllIIIIlllIl) throws IOException {
        super.mouseClicked(lllllllllllllllllIllIllIIIIlllll, lllllllllllllllllIllIllIIIIllllI, lllllllllllllllllIllIllIIIIlllIl);
        final boolean lllllllllllllllllIllIllIIIIlllII = lllllllllllllllllIllIllIIIIlllIl == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100;
        final Slot lllllllllllllllllIllIllIIIIllIll = this.getSlotAtPosition(lllllllllllllllllIllIllIIIIlllll, lllllllllllllllllIllIllIIIIllllI);
        final long lllllllllllllllllIllIllIIIIllIlI = Minecraft.getSystemTime();
        this.doubleClick = (this.lastClickSlot == lllllllllllllllllIllIllIIIIllIll && lllllllllllllllllIllIllIIIIllIlI - this.lastClickTime < 250L && this.lastClickButton == lllllllllllllllllIllIllIIIIlllIl);
        this.ignoreMouseUp = false;
        if (lllllllllllllllllIllIllIIIIlllIl == 0 || lllllllllllllllllIllIllIIIIlllIl == 1 || lllllllllllllllllIllIllIIIIlllII) {
            final int lllllllllllllllllIllIllIIIIllIIl = this.guiLeft;
            final int lllllllllllllllllIllIllIIIIllIII = this.guiTop;
            final boolean lllllllllllllllllIllIllIIIIlIlll = lllllllllllllllllIllIllIIIIlllll < lllllllllllllllllIllIllIIIIllIIl || lllllllllllllllllIllIllIIIIllllI < lllllllllllllllllIllIllIIIIllIII || lllllllllllllllllIllIllIIIIlllll >= lllllllllllllllllIllIllIIIIllIIl + this.xSize || lllllllllllllllllIllIllIIIIllllI >= lllllllllllllllllIllIllIIIIllIII + this.ySize;
            int lllllllllllllllllIllIllIIIIlIllI = -1;
            if (lllllllllllllllllIllIllIIIIllIll != null) {
                lllllllllllllllllIllIllIIIIlIllI = lllllllllllllllllIllIllIIIIllIll.slotNumber;
            }
            if (lllllllllllllllllIllIllIIIIlIlll) {
                lllllllllllllllllIllIllIIIIlIllI = -999;
            }
            if (this.mc.gameSettings.touchscreen && lllllllllllllllllIllIllIIIIlIlll && this.mc.thePlayer.inventory.getItemStack() == null) {
                this.mc.displayGuiScreen(null);
                return;
            }
            if (lllllllllllllllllIllIllIIIIlIllI != -1) {
                if (this.mc.gameSettings.touchscreen) {
                    if (lllllllllllllllllIllIllIIIIllIll != null && lllllllllllllllllIllIllIIIIllIll.getHasStack()) {
                        this.clickedSlot = lllllllllllllllllIllIllIIIIllIll;
                        this.draggedStack = null;
                        this.isRightMouseClick = (lllllllllllllllllIllIllIIIIlllIl == 1);
                    }
                    else {
                        this.clickedSlot = null;
                    }
                }
                else if (!this.dragSplitting) {
                    if (this.mc.thePlayer.inventory.getItemStack() == null) {
                        if (lllllllllllllllllIllIllIIIIlllIl == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                            this.handleMouseClick(lllllllllllllllllIllIllIIIIllIll, lllllllllllllllllIllIllIIIIlIllI, lllllllllllllllllIllIllIIIIlllIl, 3);
                        }
                        else {
                            final boolean lllllllllllllllllIllIllIIIIlIlIl = lllllllllllllllllIllIllIIIIlIllI != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                            byte lllllllllllllllllIllIllIIIIlIlII = 0;
                            if (lllllllllllllllllIllIllIIIIlIlIl) {
                                this.shiftClickedSlot = ((lllllllllllllllllIllIllIIIIllIll != null && lllllllllllllllllIllIllIIIIllIll.getHasStack()) ? lllllllllllllllllIllIllIIIIllIll.getStack() : null);
                                lllllllllllllllllIllIllIIIIlIlII = 1;
                            }
                            else if (lllllllllllllllllIllIllIIIIlIllI == -999) {
                                lllllllllllllllllIllIllIIIIlIlII = 4;
                            }
                            this.handleMouseClick(lllllllllllllllllIllIllIIIIllIll, lllllllllllllllllIllIllIIIIlIllI, lllllllllllllllllIllIllIIIIlllIl, lllllllllllllllllIllIllIIIIlIlII);
                        }
                        this.ignoreMouseUp = true;
                    }
                    else {
                        this.dragSplitting = true;
                        this.dragSplittingButton = lllllllllllllllllIllIllIIIIlllIl;
                        this.dragSplittingSlots.clear();
                        if (lllllllllllllllllIllIllIIIIlllIl == 0) {
                            this.dragSplittingLimit = 0;
                        }
                        else if (lllllllllllllllllIllIllIIIIlllIl == 1) {
                            this.dragSplittingLimit = 1;
                        }
                        else if (lllllllllllllllllIllIllIIIIlllIl == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                            this.dragSplittingLimit = 2;
                        }
                    }
                }
            }
        }
        this.lastClickSlot = lllllllllllllllllIllIllIIIIllIll;
        this.lastClickTime = lllllllllllllllllIllIllIIIIllIlI;
        this.lastClickButton = lllllllllllllllllIllIllIIIIlllIl;
    }
    
    private Slot getSlotAtPosition(final int lllllllllllllllllIllIllIIIllIIIl, final int lllllllllllllllllIllIllIIIllIlIl) {
        for (int lllllllllllllllllIllIllIIIllIlII = 0; lllllllllllllllllIllIllIIIllIlII < this.inventorySlots.inventorySlots.size(); ++lllllllllllllllllIllIllIIIllIlII) {
            final Slot lllllllllllllllllIllIllIIIllIIll = this.inventorySlots.inventorySlots.get(lllllllllllllllllIllIllIIIllIlII);
            if (this.isMouseOverSlot(lllllllllllllllllIllIllIIIllIIll, lllllllllllllllllIllIllIIIllIIIl, lllllllllllllllllIllIllIIIllIlIl)) {
                return lllllllllllllllllIllIllIIIllIIll;
            }
        }
        return null;
    }
    
    protected boolean isPointInRegion(final int lllllllllllllllllIllIlIllIlIlIlI, final int lllllllllllllllllIllIlIllIlIlIIl, final int lllllllllllllllllIllIlIllIlIlIII, final int lllllllllllllllllIllIlIllIlIIlll, int lllllllllllllllllIllIlIllIlIllll, int lllllllllllllllllIllIlIllIlIIlIl) {
        final int lllllllllllllllllIllIlIllIlIllIl = this.guiLeft;
        final int lllllllllllllllllIllIlIllIlIllII = this.guiTop;
        lllllllllllllllllIllIlIllIlIllll -= lllllllllllllllllIllIlIllIlIllIl;
        lllllllllllllllllIllIlIllIlIIlIl -= lllllllllllllllllIllIlIllIlIllII;
        return lllllllllllllllllIllIlIllIlIllll >= lllllllllllllllllIllIlIllIlIlIlI - 1 && lllllllllllllllllIllIlIllIlIllll < lllllllllllllllllIllIlIllIlIlIlI + lllllllllllllllllIllIlIllIlIlIII + 1 && lllllllllllllllllIllIlIllIlIIlIl >= lllllllllllllllllIllIlIllIlIlIIl - 1 && lllllllllllllllllIllIlIllIlIIlIl < lllllllllllllllllIllIlIllIlIlIIl + lllllllllllllllllIllIlIllIlIIlll + 1;
    }
    
    static {
        __OBFID = "CL_00000737";
        inventoryBackground = new ResourceLocation("textures/gui/container/inventory.png");
    }
    
    @Override
    public void onGuiClosed() {
        if (this.mc.thePlayer != null) {
            this.inventorySlots.onContainerClosed(this.mc.thePlayer);
        }
    }
    
    private void updateDragSplitting() {
        final ItemStack lllllllllllllllllIllIllIIlIIIlll = this.mc.thePlayer.inventory.getItemStack();
        if (lllllllllllllllllIllIllIIlIIIlll != null && this.dragSplitting) {
            this.dragSplittingRemnant = lllllllllllllllllIllIllIIlIIIlll.stackSize;
            for (final Slot lllllllllllllllllIllIllIIlIIIIll : this.dragSplittingSlots) {
                final ItemStack lllllllllllllllllIllIllIIlIIIllI = lllllllllllllllllIllIllIIlIIIlll.copy();
                final int lllllllllllllllllIllIllIIlIIIlIl = (lllllllllllllllllIllIllIIlIIIIll.getStack() == null) ? 0 : lllllllllllllllllIllIllIIlIIIIll.getStack().stackSize;
                Container.computeStackSize(this.dragSplittingSlots, this.dragSplittingLimit, lllllllllllllllllIllIllIIlIIIllI, lllllllllllllllllIllIllIIlIIIlIl);
                if (lllllllllllllllllIllIllIIlIIIllI.stackSize > lllllllllllllllllIllIllIIlIIIllI.getMaxStackSize()) {
                    lllllllllllllllllIllIllIIlIIIllI.stackSize = lllllllllllllllllIllIllIIlIIIllI.getMaxStackSize();
                }
                if (lllllllllllllllllIllIllIIlIIIllI.stackSize > lllllllllllllllllIllIllIIlIIIIll.func_178170_b(lllllllllllllllllIllIllIIlIIIllI)) {
                    lllllllllllllllllIllIllIIlIIIllI.stackSize = lllllllllllllllllIllIllIIlIIIIll.func_178170_b(lllllllllllllllllIllIllIIlIIIllI);
                }
                this.dragSplittingRemnant -= lllllllllllllllllIllIllIIlIIIllI.stackSize - lllllllllllllllllIllIllIIlIIIlIl;
            }
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllllIllIllIlIIlIIII, final int lllllllllllllllllIllIllIlIlIIlll, final float lllllllllllllllllIllIllIlIlIIllI) {
        final EventOpenChest lllllllllllllllllIllIllIlIlIIlIl = new EventOpenChest();
        Client.onEvent(lllllllllllllllllIllIllIlIlIIlIl);
        if (lllllllllllllllllIllIllIlIlIIlIl.isCancelled()) {
            return;
        }
        this.drawDefaultBackground();
        final int lllllllllllllllllIllIllIlIlIIlII = this.guiLeft;
        final int lllllllllllllllllIllIllIlIlIIIll = this.guiTop;
        this.drawGuiContainerBackgroundLayer(lllllllllllllllllIllIllIlIlIIllI, lllllllllllllllllIllIllIlIIlIIII, lllllllllllllllllIllIllIlIlIIlll);
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        super.drawScreen(lllllllllllllllllIllIllIlIIlIIII, lllllllllllllllllIllIllIlIlIIlll, lllllllllllllllllIllIllIlIlIIllI);
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllllllIllIllIlIlIIlII, (float)lllllllllllllllllIllIllIlIlIIIll, 0.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableRescaleNormal();
        this.theSlot = null;
        final short lllllllllllllllllIllIllIlIlIIIlI = 240;
        final short lllllllllllllllllIllIllIlIlIIIIl = 240;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lllllllllllllllllIllIllIlIlIIIlI / 1.0f, lllllllllllllllllIllIllIlIlIIIIl / 1.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        for (int lllllllllllllllllIllIllIlIIlllIl = 0; lllllllllllllllllIllIllIlIIlllIl < this.inventorySlots.inventorySlots.size(); ++lllllllllllllllllIllIllIlIIlllIl) {
            final Slot lllllllllllllllllIllIllIlIIlllII = this.inventorySlots.inventorySlots.get(lllllllllllllllllIllIllIlIIlllIl);
            this.drawSlot(lllllllllllllllllIllIllIlIIlllII);
            if (this.isMouseOverSlot(lllllllllllllllllIllIllIlIIlllII, lllllllllllllllllIllIllIlIIlIIII, lllllllllllllllllIllIllIlIlIIlll) && lllllllllllllllllIllIllIlIIlllII.canBeHovered()) {
                this.theSlot = lllllllllllllllllIllIllIlIIlllII;
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                final int lllllllllllllllllIllIllIlIIllIll = lllllllllllllllllIllIllIlIIlllII.xDisplayPosition;
                final int lllllllllllllllllIllIllIlIlIIIII = lllllllllllllllllIllIllIlIIlllII.yDisplayPosition;
                GlStateManager.colorMask(true, true, true, false);
                this.drawGradientRect(lllllllllllllllllIllIllIlIIllIll, lllllllllllllllllIllIllIlIlIIIII, lllllllllllllllllIllIllIlIIllIll + 16, lllllllllllllllllIllIllIlIlIIIII + 16, -2130706433, -2130706433);
                GlStateManager.colorMask(true, true, true, true);
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
        }
        RenderHelper.disableStandardItemLighting();
        this.drawGuiContainerForegroundLayer(lllllllllllllllllIllIllIlIIlIIII, lllllllllllllllllIllIllIlIlIIlll);
        RenderHelper.enableGUIStandardItemLighting();
        final InventoryPlayer lllllllllllllllllIllIllIlIIllIlI = this.mc.thePlayer.inventory;
        ItemStack lllllllllllllllllIllIllIlIIllIIl = (this.draggedStack == null) ? lllllllllllllllllIllIllIlIIllIlI.getItemStack() : this.draggedStack;
        if (lllllllllllllllllIllIllIlIIllIIl != null) {
            final byte lllllllllllllllllIllIllIlIIllIII = 8;
            final int lllllllllllllllllIllIllIlIIlllll = (this.draggedStack == null) ? 8 : 16;
            String lllllllllllllllllIllIllIlIIlIlll = null;
            if (this.draggedStack != null && this.isRightMouseClick) {
                lllllllllllllllllIllIllIlIIllIIl = lllllllllllllllllIllIllIlIIllIIl.copy();
                lllllllllllllllllIllIllIlIIllIIl.stackSize = MathHelper.ceiling_float_int(lllllllllllllllllIllIllIlIIllIIl.stackSize / 2.0f);
            }
            else if (this.dragSplitting && this.dragSplittingSlots.size() > 1) {
                lllllllllllllllllIllIllIlIIllIIl = lllllllllllllllllIllIllIlIIllIIl.copy();
                lllllllllllllllllIllIllIlIIllIIl.stackSize = this.dragSplittingRemnant;
                if (lllllllllllllllllIllIllIlIIllIIl.stackSize == 0) {
                    lllllllllllllllllIllIllIlIIlIlll = String.valueOf(new StringBuilder().append(EnumChatFormatting.YELLOW).append("0"));
                }
            }
            this.drawItemStack(lllllllllllllllllIllIllIlIIllIIl, lllllllllllllllllIllIllIlIIlIIII - lllllllllllllllllIllIllIlIlIIlII - lllllllllllllllllIllIllIlIIllIII, lllllllllllllllllIllIllIlIlIIlll - lllllllllllllllllIllIllIlIlIIIll - lllllllllllllllllIllIllIlIIlllll, lllllllllllllllllIllIllIlIIlIlll);
        }
        if (this.returningStack != null) {
            float lllllllllllllllllIllIllIlIIlIllI = (Minecraft.getSystemTime() - this.returningStackTime) / 100.0f;
            if (lllllllllllllllllIllIllIlIIlIllI >= 1.0f) {
                lllllllllllllllllIllIllIlIIlIllI = 1.0f;
                this.returningStack = null;
            }
            final int lllllllllllllllllIllIllIlIIllllI = this.returningStackDestSlot.xDisplayPosition - this.touchUpX;
            final int lllllllllllllllllIllIllIlIIlIlIl = this.returningStackDestSlot.yDisplayPosition - this.touchUpY;
            final int lllllllllllllllllIllIllIlIIlIlII = this.touchUpX + (int)(lllllllllllllllllIllIllIlIIllllI * lllllllllllllllllIllIllIlIIlIllI);
            final int lllllllllllllllllIllIllIlIIlIIll = this.touchUpY + (int)(lllllllllllllllllIllIllIlIIlIlIl * lllllllllllllllllIllIllIlIIlIllI);
            this.drawItemStack(this.returningStack, lllllllllllllllllIllIllIlIIlIlII, lllllllllllllllllIllIllIlIIlIIll, null);
        }
        GlStateManager.popMatrix();
        if (lllllllllllllllllIllIllIlIIllIlI.getItemStack() == null && this.theSlot != null && this.theSlot.getHasStack()) {
            final ItemStack lllllllllllllllllIllIllIlIIlIIlI = this.theSlot.getStack();
            this.renderToolTip(lllllllllllllllllIllIllIlIIlIIlI, lllllllllllllllllIllIllIlIIlIIII, lllllllllllllllllIllIllIlIlIIlll);
        }
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
    }
    
    protected boolean checkHotbarKeys(final int lllllllllllllllllIllIlIllIIIIlIl) {
        if (this.mc.thePlayer.inventory.getItemStack() == null && this.theSlot != null) {
            for (int lllllllllllllllllIllIlIllIIIIlll = 0; lllllllllllllllllIllIlIllIIIIlll < 9; ++lllllllllllllllllIllIlIllIIIIlll) {
                if (lllllllllllllllllIllIlIllIIIIlIl == this.mc.gameSettings.keyBindsHotbar[lllllllllllllllllIllIlIllIIIIlll].getKeyCode()) {
                    this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, lllllllllllllllllIllIlIllIIIIlll, 2);
                    return true;
                }
            }
        }
        return false;
    }
    
    public GuiContainer(final Container lllllllllllllllllIllIllIlIllllll) {
        this.xSize = 176;
        this.ySize = 166;
        this.dragSplittingSlots = Sets.newHashSet();
        this.inventorySlots = lllllllllllllllllIllIllIlIllllll;
        this.ignoreMouseUp = true;
    }
    
    private boolean isMouseOverSlot(final Slot lllllllllllllllllIllIlIlllIIIIII, final int lllllllllllllllllIllIlIllIllllll, final int lllllllllllllllllIllIlIlllIIIIlI) {
        return this.isPointInRegion(lllllllllllllllllIllIlIlllIIIIII.xDisplayPosition, lllllllllllllllllIllIlIlllIIIIII.yDisplayPosition, 16, 16, lllllllllllllllllIllIlIllIllllll, lllllllllllllllllIllIlIlllIIIIlI);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        if (!this.mc.thePlayer.isEntityAlive() || this.mc.thePlayer.isDead) {
            this.mc.thePlayer.closeScreen();
        }
    }
    
    private void drawSlot(final Slot lllllllllllllllllIllIllIIllIIIll) {
        final int lllllllllllllllllIllIllIIllIIIlI = lllllllllllllllllIllIllIIllIIIll.xDisplayPosition;
        final int lllllllllllllllllIllIllIIllIIIIl = lllllllllllllllllIllIllIIllIIIll.yDisplayPosition;
        ItemStack lllllllllllllllllIllIllIIllIIIII = lllllllllllllllllIllIllIIllIIIll.getStack();
        boolean lllllllllllllllllIllIllIIlIlllll = false;
        boolean lllllllllllllllllIllIllIIlIllllI = lllllllllllllllllIllIllIIllIIIll == this.clickedSlot && this.draggedStack != null && !this.isRightMouseClick;
        final ItemStack lllllllllllllllllIllIllIIlIlllIl = this.mc.thePlayer.inventory.getItemStack();
        String lllllllllllllllllIllIllIIlIlllII = null;
        if (lllllllllllllllllIllIllIIllIIIll == this.clickedSlot && this.draggedStack != null && this.isRightMouseClick && lllllllllllllllllIllIllIIllIIIII != null) {
            final ItemStack copy;
            lllllllllllllllllIllIllIIllIIIII = (copy = lllllllllllllllllIllIllIIllIIIII.copy());
            copy.stackSize /= 2;
        }
        else if (this.dragSplitting && this.dragSplittingSlots.contains(lllllllllllllllllIllIllIIllIIIll) && lllllllllllllllllIllIllIIlIlllIl != null) {
            if (this.dragSplittingSlots.size() == 1) {
                return;
            }
            if (Container.canAddItemToSlot(lllllllllllllllllIllIllIIllIIIll, lllllllllllllllllIllIllIIlIlllIl, true) && this.inventorySlots.canDragIntoSlot(lllllllllllllllllIllIllIIllIIIll)) {
                lllllllllllllllllIllIllIIllIIIII = lllllllllllllllllIllIllIIlIlllIl.copy();
                lllllllllllllllllIllIllIIlIlllll = true;
                Container.computeStackSize(this.dragSplittingSlots, this.dragSplittingLimit, lllllllllllllllllIllIllIIllIIIII, (lllllllllllllllllIllIllIIllIIIll.getStack() == null) ? 0 : lllllllllllllllllIllIllIIllIIIll.getStack().stackSize);
                if (lllllllllllllllllIllIllIIllIIIII.stackSize > lllllllllllllllllIllIllIIllIIIII.getMaxStackSize()) {
                    lllllllllllllllllIllIllIIlIlllII = String.valueOf(new StringBuilder().append(EnumChatFormatting.YELLOW).append(lllllllllllllllllIllIllIIllIIIII.getMaxStackSize()));
                    lllllllllllllllllIllIllIIllIIIII.stackSize = lllllllllllllllllIllIllIIllIIIII.getMaxStackSize();
                }
                if (lllllllllllllllllIllIllIIllIIIII.stackSize > lllllllllllllllllIllIllIIllIIIll.func_178170_b(lllllllllllllllllIllIllIIllIIIII)) {
                    lllllllllllllllllIllIllIIlIlllII = String.valueOf(new StringBuilder().append(EnumChatFormatting.YELLOW).append(lllllllllllllllllIllIllIIllIIIll.func_178170_b(lllllllllllllllllIllIllIIllIIIII)));
                    lllllllllllllllllIllIllIIllIIIII.stackSize = lllllllllllllllllIllIllIIllIIIll.func_178170_b(lllllllllllllllllIllIllIIllIIIII);
                }
            }
            else {
                this.dragSplittingSlots.remove(lllllllllllllllllIllIllIIllIIIll);
                this.updateDragSplitting();
            }
        }
        this.zLevel = 100.0f;
        this.itemRender.zLevel = 100.0f;
        if (lllllllllllllllllIllIllIIllIIIII == null) {
            final String lllllllllllllllllIllIllIIlIllIll = lllllllllllllllllIllIllIIllIIIll.func_178171_c();
            if (lllllllllllllllllIllIllIIlIllIll != null) {
                final TextureAtlasSprite lllllllllllllllllIllIllIIlIllIlI = this.mc.getTextureMapBlocks().getAtlasSprite(lllllllllllllllllIllIllIIlIllIll);
                GlStateManager.disableLighting();
                this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
                this.func_175175_a(lllllllllllllllllIllIllIIllIIIlI, lllllllllllllllllIllIllIIllIIIIl, lllllllllllllllllIllIllIIlIllIlI, 16, 16);
                GlStateManager.enableLighting();
                lllllllllllllllllIllIllIIlIllllI = true;
            }
        }
        if (!lllllllllllllllllIllIllIIlIllllI) {
            if (lllllllllllllllllIllIllIIlIlllll) {
                Gui.drawRect(lllllllllllllllllIllIllIIllIIIlI, lllllllllllllllllIllIllIIllIIIIl, lllllllllllllllllIllIllIIllIIIlI + 16, lllllllllllllllllIllIllIIllIIIIl + 16, -2130706433);
            }
            GlStateManager.enableDepth();
            this.itemRender.func_180450_b(lllllllllllllllllIllIllIIllIIIII, lllllllllllllllllIllIllIIllIIIlI, lllllllllllllllllIllIllIIllIIIIl);
            this.itemRender.func_180453_a(this.fontRendererObj, lllllllllllllllllIllIllIIllIIIII, lllllllllllllllllIllIllIIllIIIlI, lllllllllllllllllIllIllIIllIIIIl, lllllllllllllllllIllIllIIlIlllII);
        }
        this.itemRender.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllllllIllIlIllIIlIIII, final int lllllllllllllllllIllIlIllIIIllll) throws IOException {
        if (lllllllllllllllllIllIlIllIIIllll == 1 || lllllllllllllllllIllIlIllIIIllll == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.thePlayer.closeScreen();
        }
        this.checkHotbarKeys(lllllllllllllllllIllIlIllIIIllll);
        if (this.theSlot != null && this.theSlot.getHasStack()) {
            if (lllllllllllllllllIllIlIllIIIllll == this.mc.gameSettings.keyBindPickBlock.getKeyCode()) {
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, 0, 3);
            }
            else if (lllllllllllllllllIllIlIllIIIllll == this.mc.gameSettings.keyBindDrop.getKeyCode()) {
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, GuiScreen.isCtrlKeyDown() ? 1 : 0, 4);
            }
        }
    }
    
    @Override
    protected void mouseClickMove(final int lllllllllllllllllIllIlIlllllIllI, final int lllllllllllllllllIllIlIlllllIlIl, final int lllllllllllllllllIllIlIlllllIlII, final long lllllllllllllllllIllIlIllllllIll) {
        final Slot lllllllllllllllllIllIlIllllllIlI = this.getSlotAtPosition(lllllllllllllllllIllIlIlllllIllI, lllllllllllllllllIllIlIlllllIlIl);
        final ItemStack lllllllllllllllllIllIlIllllllIIl = this.mc.thePlayer.inventory.getItemStack();
        if (this.clickedSlot != null && this.mc.gameSettings.touchscreen) {
            if (lllllllllllllllllIllIlIlllllIlII == 0 || lllllllllllllllllIllIlIlllllIlII == 1) {
                if (this.draggedStack == null) {
                    if (lllllllllllllllllIllIlIllllllIlI != this.clickedSlot) {
                        this.draggedStack = this.clickedSlot.getStack().copy();
                    }
                }
                else if (this.draggedStack.stackSize > 1 && lllllllllllllllllIllIlIllllllIlI != null && Container.canAddItemToSlot(lllllllllllllllllIllIlIllllllIlI, this.draggedStack, false)) {
                    final long lllllllllllllllllIllIlIllllllIII = Minecraft.getSystemTime();
                    if (this.currentDragTargetSlot == lllllllllllllllllIllIlIllllllIlI) {
                        if (lllllllllllllllllIllIlIllllllIII - this.dragItemDropDelay > 500L) {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, 0);
                            this.handleMouseClick(lllllllllllllllllIllIlIllllllIlI, lllllllllllllllllIllIlIllllllIlI.slotNumber, 1, 0);
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, 0);
                            this.dragItemDropDelay = lllllllllllllllllIllIlIllllllIII + 750L;
                            final ItemStack draggedStack = this.draggedStack;
                            --draggedStack.stackSize;
                        }
                    }
                    else {
                        this.currentDragTargetSlot = lllllllllllllllllIllIlIllllllIlI;
                        this.dragItemDropDelay = lllllllllllllllllIllIlIllllllIII;
                    }
                }
            }
        }
        else if (this.dragSplitting && lllllllllllllllllIllIlIllllllIlI != null && lllllllllllllllllIllIlIllllllIIl != null && lllllllllllllllllIllIlIllllllIIl.stackSize > this.dragSplittingSlots.size() && Container.canAddItemToSlot(lllllllllllllllllIllIlIllllllIlI, lllllllllllllllllIllIlIllllllIIl, true) && lllllllllllllllllIllIlIllllllIlI.isItemValid(lllllllllllllllllIllIlIllllllIIl) && this.inventorySlots.canDragIntoSlot(lllllllllllllllllIllIlIllllllIlI)) {
            this.dragSplittingSlots.add(lllllllllllllllllIllIlIllllllIlI);
            this.updateDragSplitting();
        }
    }
}
