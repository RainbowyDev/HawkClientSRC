package net.minecraft.client.gui.inventory;

import net.minecraft.creativetab.*;
import net.minecraft.client.resources.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.client.settings.*;
import java.io.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.achievement.*;
import net.minecraft.enchantment.*;
import java.util.*;
import org.lwjgl.input.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class GuiContainerCreative extends InventoryEffectRenderer
{
    private /* synthetic */ boolean field_147057_D;
    private static /* synthetic */ InventoryBasic field_147060_v;
    private /* synthetic */ boolean wasClicking;
    private static /* synthetic */ int selectedTabIndex;
    private /* synthetic */ boolean isScrolling;
    private /* synthetic */ float currentScroll;
    private /* synthetic */ Slot field_147064_C;
    private /* synthetic */ List field_147063_B;
    private /* synthetic */ GuiTextField searchField;
    private /* synthetic */ CreativeCrafting field_147059_E;
    private static final /* synthetic */ ResourceLocation creativeInventoryTabs;
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllIllIlllIllIlIIlll, final int lllllllllllllllIllIlllIllIlIIllI) {
        final CreativeTabs lllllllllllllllIllIlllIllIlIIlIl = CreativeTabs.creativeTabArray[GuiContainerCreative.selectedTabIndex];
        if (lllllllllllllllIllIlllIllIlIIlIl.drawInForegroundOfTab()) {
            GlStateManager.disableBlend();
            this.fontRendererObj.drawString(I18n.format(lllllllllllllllIllIlllIllIlIIlIl.getTranslatedTabLabel(), new Object[0]), 8.0, 6.0, 4210752);
        }
    }
    
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        if (this.mc.thePlayer != null && this.mc.thePlayer.inventory != null) {
            this.mc.thePlayer.inventoryContainer.removeCraftingFromCrafters(this.field_147059_E);
        }
        Keyboard.enableRepeatEvents(false);
    }
    
    private void updateCreativeSearch() {
        final ContainerCreative lllllllllllllllIllIlllIlllIIIIII = (ContainerCreative)this.inventorySlots;
        lllllllllllllllIllIlllIlllIIIIII.itemList.clear();
        for (final Item lllllllllllllllIllIlllIllIlllllI : Item.itemRegistry) {
            if (lllllllllllllllIllIlllIllIlllllI != null && lllllllllllllllIllIlllIllIlllllI.getCreativeTab() != null) {
                lllllllllllllllIllIlllIllIlllllI.getSubItems(lllllllllllllllIllIlllIllIlllllI, null, lllllllllllllllIllIlllIlllIIIIII.itemList);
            }
        }
        for (final Enchantment lllllllllllllllIllIlllIllIlllIlI : Enchantment.enchantmentsList) {
            if (lllllllllllllllIllIlllIllIlllIlI != null && lllllllllllllllIllIlllIllIlllIlI.type != null) {
                Items.enchanted_book.func_92113_a(lllllllllllllllIllIlllIllIlllIlI, lllllllllllllllIllIlllIlllIIIIII.itemList);
            }
        }
        final Iterator lllllllllllllllIllIlllIllIllllll = lllllllllllllllIllIlllIlllIIIIII.itemList.iterator();
        final String lllllllllllllllIllIlllIllIlllIIl = this.searchField.getText().toLowerCase();
        while (lllllllllllllllIllIlllIllIllllll.hasNext()) {
            final ItemStack lllllllllllllllIllIlllIllIlllIII = lllllllllllllllIllIlllIllIllllll.next();
            boolean lllllllllllllllIllIlllIllIllIlll = false;
            for (final String lllllllllllllllIllIlllIllIllIlIl : lllllllllllllllIllIlllIllIlllIII.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips)) {
                if (!EnumChatFormatting.getTextWithoutFormattingCodes(lllllllllllllllIllIlllIllIllIlIl).toLowerCase().contains(lllllllllllllllIllIlllIllIlllIIl)) {
                    continue;
                }
                lllllllllllllllIllIlllIllIllIlll = true;
                break;
            }
            if (!lllllllllllllllIllIlllIllIllIlll) {
                lllllllllllllllIllIlllIllIllllll.remove();
            }
        }
        this.currentScroll = 0.0f;
        lllllllllllllllIllIlllIlllIIIIII.scrollTo(0.0f);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllllIllIlllIlllIIllIl, final int lllllllllllllllIllIlllIlllIIllII) throws IOException {
        if (GuiContainerCreative.selectedTabIndex != CreativeTabs.tabAllSearch.getTabIndex()) {
            if (GameSettings.isKeyDown(this.mc.gameSettings.keyBindChat)) {
                this.setCurrentCreativeTab(CreativeTabs.tabAllSearch);
            }
            else {
                super.keyTyped(lllllllllllllllIllIlllIlllIIllIl, lllllllllllllllIllIlllIlllIIllII);
            }
        }
        else {
            if (this.field_147057_D) {
                this.field_147057_D = false;
                this.searchField.setText("");
            }
            if (!this.checkHotbarKeys(lllllllllllllllIllIlllIlllIIllII)) {
                if (this.searchField.textboxKeyTyped(lllllllllllllllIllIlllIlllIIllIl, lllllllllllllllIllIlllIlllIIllII)) {
                    this.updateCreativeSearch();
                }
                else {
                    super.keyTyped(lllllllllllllllIllIlllIlllIIllIl, lllllllllllllllIllIlllIlllIIllII);
                }
            }
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIllIlllIIIlllIlIl) throws IOException {
        if (lllllllllllllllIllIlllIIIlllIlIl.id == 0) {
            this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
        }
        if (lllllllllllllllIllIlllIIIlllIlIl.id == 1) {
            this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
        }
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllllllIllIlllIlIllIllll, final int lllllllllllllllIllIlllIlIllIlllI, final int lllllllllllllllIllIlllIlIllIllIl) {
        if (lllllllllllllllIllIlllIlIllIllIl == 0) {
            final int lllllllllllllllIllIlllIlIlllIllI = lllllllllllllllIllIlllIlIllIllll - this.guiLeft;
            final int lllllllllllllllIllIlllIlIlllIlIl = lllllllllllllllIllIlllIlIllIlllI - this.guiTop;
            for (final CreativeTabs lllllllllllllllIllIlllIlIlllIIIl : CreativeTabs.creativeTabArray) {
                if (this.func_147049_a(lllllllllllllllIllIlllIlIlllIIIl, lllllllllllllllIllIlllIlIlllIllI, lllllllllllllllIllIlllIlIlllIlIl)) {
                    this.setCurrentCreativeTab(lllllllllllllllIllIlllIlIlllIIIl);
                    return;
                }
            }
        }
        super.mouseReleased(lllllllllllllllIllIlllIlIllIllll, lllllllllllllllIllIlllIlIllIlllI, lllllllllllllllIllIlllIlIllIllIl);
    }
    
    @Override
    protected void renderToolTip(final ItemStack lllllllllllllllIllIlllIIllllllll, final int lllllllllllllllIllIlllIIlllllllI, final int lllllllllllllllIllIlllIIllllIIII) {
        if (GuiContainerCreative.selectedTabIndex == CreativeTabs.tabAllSearch.getTabIndex()) {
            final List lllllllllllllllIllIlllIIllllllII = lllllllllllllllIllIlllIIllllllll.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips);
            CreativeTabs lllllllllllllllIllIlllIIlllllIll = lllllllllllllllIllIlllIIllllllll.getItem().getCreativeTab();
            if (lllllllllllllllIllIlllIIlllllIll == null && lllllllllllllllIllIlllIIllllllll.getItem() == Items.enchanted_book) {
                final Map lllllllllllllllIllIlllIIlllllIlI = EnchantmentHelper.getEnchantments(lllllllllllllllIllIlllIIllllllll);
                if (lllllllllllllllIllIlllIIlllllIlI.size() == 1) {
                    final Enchantment lllllllllllllllIllIlllIIlllllIIl = Enchantment.func_180306_c(lllllllllllllllIllIlllIIlllllIlI.keySet().iterator().next());
                    for (final CreativeTabs lllllllllllllllIllIlllIIllllIlIl : CreativeTabs.creativeTabArray) {
                        if (lllllllllllllllIllIlllIIllllIlIl.hasRelevantEnchantmentType(lllllllllllllllIllIlllIIlllllIIl.type)) {
                            lllllllllllllllIllIlllIIlllllIll = lllllllllllllllIllIlllIIllllIlIl;
                            break;
                        }
                    }
                }
            }
            if (lllllllllllllllIllIlllIIlllllIll != null) {
                lllllllllllllllIllIlllIIllllllII.add(1, String.valueOf(new StringBuilder().append(EnumChatFormatting.BOLD).append(EnumChatFormatting.BLUE).append(I18n.format(lllllllllllllllIllIlllIIlllllIll.getTranslatedTabLabel(), new Object[0]))));
            }
            for (int lllllllllllllllIllIlllIIllllIlII = 0; lllllllllllllllIllIlllIIllllIlII < lllllllllllllllIllIlllIIllllllII.size(); ++lllllllllllllllIllIlllIIllllIlII) {
                if (lllllllllllllllIllIlllIIllllIlII == 0) {
                    lllllllllllllllIllIlllIIllllllII.set(lllllllllllllllIllIlllIIllllIlII, String.valueOf(new StringBuilder().append(lllllllllllllllIllIlllIIllllllll.getRarity().rarityColor).append(lllllllllllllllIllIlllIIllllllII.get(lllllllllllllllIllIlllIIllllIlII))));
                }
                else {
                    lllllllllllllllIllIlllIIllllllII.set(lllllllllllllllIllIlllIIllllIlII, String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append(lllllllllllllllIllIlllIIllllllII.get(lllllllllllllllIllIlllIIllllIlII))));
                }
            }
            this.drawHoveringText(lllllllllllllllIllIlllIIllllllII, lllllllllllllllIllIlllIIlllllllI, lllllllllllllllIllIlllIIllllIIII);
        }
        else {
            super.renderToolTip(lllllllllllllllIllIlllIIllllllll, lllllllllllllllIllIlllIIlllllllI, lllllllllllllllIllIlllIIllllIIII);
        }
    }
    
    public int func_147056_g() {
        return GuiContainerCreative.selectedTabIndex;
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllIllIlllIllIIlIlll, final int lllllllllllllllIllIlllIllIIlIllI, final int lllllllllllllllIllIlllIllIIlIlIl) throws IOException {
        if (lllllllllllllllIllIlllIllIIlIlIl == 0) {
            final int lllllllllllllllIllIlllIllIIlIlII = lllllllllllllllIllIlllIllIIlIlll - this.guiLeft;
            final int lllllllllllllllIllIlllIllIIlIIll = lllllllllllllllIllIlllIllIIlIllI - this.guiTop;
            for (final CreativeTabs lllllllllllllllIllIlllIllIIIllll : CreativeTabs.creativeTabArray) {
                if (this.func_147049_a(lllllllllllllllIllIlllIllIIIllll, lllllllllllllllIllIlllIllIIlIlII, lllllllllllllllIllIlllIllIIlIIll)) {
                    return;
                }
            }
        }
        super.mouseClicked(lllllllllllllllIllIlllIllIIlIlll, lllllllllllllllIllIlllIllIIlIllI, lllllllllllllllIllIlllIllIIlIlIl);
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int lllllllllllllllIllIlllIlIIlllllI = Mouse.getEventDWheel();
        if (lllllllllllllllIllIlllIlIIlllllI != 0 && this.needsScrollBars()) {
            final int lllllllllllllllIllIlllIlIIllllIl = ((ContainerCreative)this.inventorySlots).itemList.size() / 9 - 5 + 1;
            if (lllllllllllllllIllIlllIlIIlllllI > 0) {
                lllllllllllllllIllIlllIlIIlllllI = 1;
            }
            if (lllllllllllllllIllIlllIlIIlllllI < 0) {
                lllllllllllllllIllIlllIlIIlllllI = -1;
            }
            this.currentScroll -= (float)(lllllllllllllllIllIlllIlIIlllllI / (double)lllllllllllllllIllIlllIlIIllllIl);
            this.currentScroll = MathHelper.clamp_float(this.currentScroll, 0.0f, 1.0f);
            ((ContainerCreative)this.inventorySlots).scrollTo(this.currentScroll);
        }
    }
    
    @Override
    protected void handleMouseClick(final Slot lllllllllllllllIllIlllIllllIlIII, final int lllllllllllllllIllIlllIllllIIlll, final int lllllllllllllllIllIlllIllllIIllI, int lllllllllllllllIllIlllIllllIIlIl) {
        this.field_147057_D = true;
        final boolean lllllllllllllllIllIlllIlllllIllI = lllllllllllllllIllIlllIllllIIlIl == 1;
        lllllllllllllllIllIlllIllllIIlIl = ((lllllllllllllllIllIlllIllllIIlll == -999 && lllllllllllllllIllIlllIllllIIlIl == 0) ? 4 : lllllllllllllllIllIlllIllllIIlIl);
        if (lllllllllllllllIllIlllIllllIlIII == null && GuiContainerCreative.selectedTabIndex != CreativeTabs.tabInventory.getTabIndex() && lllllllllllllllIllIlllIllllIIlIl != 5) {
            final InventoryPlayer lllllllllllllllIllIlllIlllllIIll = this.mc.thePlayer.inventory;
            if (lllllllllllllllIllIlllIlllllIIll.getItemStack() != null) {
                if (lllllllllllllllIllIlllIllllIIllI == 0) {
                    this.mc.thePlayer.dropPlayerItemWithRandomChoice(lllllllllllllllIllIlllIlllllIIll.getItemStack(), true);
                    this.mc.playerController.sendPacketDropItem(lllllllllllllllIllIlllIlllllIIll.getItemStack());
                    lllllllllllllllIllIlllIlllllIIll.setItemStack(null);
                }
                if (lllllllllllllllIllIlllIllllIIllI == 1) {
                    final ItemStack lllllllllllllllIllIlllIlllllIlIl = lllllllllllllllIllIlllIlllllIIll.getItemStack().splitStack(1);
                    this.mc.thePlayer.dropPlayerItemWithRandomChoice(lllllllllllllllIllIlllIlllllIlIl, true);
                    this.mc.playerController.sendPacketDropItem(lllllllllllllllIllIlllIlllllIlIl);
                    if (lllllllllllllllIllIlllIlllllIIll.getItemStack().stackSize == 0) {
                        lllllllllllllllIllIlllIlllllIIll.setItemStack(null);
                    }
                }
            }
        }
        else if (lllllllllllllllIllIlllIllllIlIII == this.field_147064_C && lllllllllllllllIllIlllIlllllIllI) {
            for (int lllllllllllllllIllIlllIlllllIIIl = 0; lllllllllllllllIllIlllIlllllIIIl < this.mc.thePlayer.inventoryContainer.getInventory().size(); ++lllllllllllllllIllIlllIlllllIIIl) {
                this.mc.playerController.sendSlotPacket(null, lllllllllllllllIllIlllIlllllIIIl);
            }
        }
        else if (GuiContainerCreative.selectedTabIndex == CreativeTabs.tabInventory.getTabIndex()) {
            if (lllllllllllllllIllIlllIllllIlIII == this.field_147064_C) {
                this.mc.thePlayer.inventory.setItemStack(null);
            }
            else if (lllllllllllllllIllIlllIllllIIlIl == 4 && lllllllllllllllIllIlllIllllIlIII != null && lllllllllllllllIllIlllIllllIlIII.getHasStack()) {
                final ItemStack lllllllllllllllIllIlllIllllIllll = lllllllllllllllIllIlllIllllIlIII.decrStackSize((lllllllllllllllIllIlllIllllIIllI == 0) ? 1 : lllllllllllllllIllIlllIllllIlIII.getStack().getMaxStackSize());
                this.mc.thePlayer.dropPlayerItemWithRandomChoice(lllllllllllllllIllIlllIllllIllll, true);
                this.mc.playerController.sendPacketDropItem(lllllllllllllllIllIlllIllllIllll);
            }
            else if (lllllllllllllllIllIlllIllllIIlIl == 4 && this.mc.thePlayer.inventory.getItemStack() != null) {
                this.mc.thePlayer.dropPlayerItemWithRandomChoice(this.mc.thePlayer.inventory.getItemStack(), true);
                this.mc.playerController.sendPacketDropItem(this.mc.thePlayer.inventory.getItemStack());
                this.mc.thePlayer.inventory.setItemStack(null);
            }
            else {
                this.mc.thePlayer.inventoryContainer.slotClick((lllllllllllllllIllIlllIllllIlIII == null) ? lllllllllllllllIllIlllIllllIIlll : ((CreativeSlot)lllllllllllllllIllIlllIllllIlIII).field_148332_b.slotNumber, lllllllllllllllIllIlllIllllIIllI, lllllllllllllllIllIlllIllllIIlIl, this.mc.thePlayer);
                this.mc.thePlayer.inventoryContainer.detectAndSendChanges();
            }
        }
        else if (lllllllllllllllIllIlllIllllIIlIl != 5 && lllllllllllllllIllIlllIllllIlIII.inventory == GuiContainerCreative.field_147060_v) {
            final InventoryPlayer lllllllllllllllIllIlllIlllllIIlI = this.mc.thePlayer.inventory;
            ItemStack lllllllllllllllIllIlllIlllllIlII = lllllllllllllllIllIlllIlllllIIlI.getItemStack();
            final ItemStack lllllllllllllllIllIlllIllllIllIl = lllllllllllllllIllIlllIllllIlIII.getStack();
            if (lllllllllllllllIllIlllIllllIIlIl == 2) {
                if (lllllllllllllllIllIlllIllllIllIl != null && lllllllllllllllIllIlllIllllIIllI >= 0 && lllllllllllllllIllIlllIllllIIllI < 9) {
                    final ItemStack lllllllllllllllIllIlllIllllIllII = lllllllllllllllIllIlllIllllIllIl.copy();
                    lllllllllllllllIllIlllIllllIllII.stackSize = lllllllllllllllIllIlllIllllIllII.getMaxStackSize();
                    this.mc.thePlayer.inventory.setInventorySlotContents(lllllllllllllllIllIlllIllllIIllI, lllllllllllllllIllIlllIllllIllII);
                    this.mc.thePlayer.inventoryContainer.detectAndSendChanges();
                }
                return;
            }
            if (lllllllllllllllIllIlllIllllIIlIl == 3) {
                if (lllllllllllllllIllIlllIlllllIIlI.getItemStack() == null && lllllllllllllllIllIlllIllllIlIII.getHasStack()) {
                    final ItemStack lllllllllllllllIllIlllIllllIlIll = lllllllllllllllIllIlllIllllIlIII.getStack().copy();
                    lllllllllllllllIllIlllIllllIlIll.stackSize = lllllllllllllllIllIlllIllllIlIll.getMaxStackSize();
                    lllllllllllllllIllIlllIlllllIIlI.setItemStack(lllllllllllllllIllIlllIllllIlIll);
                }
                return;
            }
            if (lllllllllllllllIllIlllIllllIIlIl == 4) {
                if (lllllllllllllllIllIlllIllllIllIl != null) {
                    final ItemStack lllllllllllllllIllIlllIllllIlIlI = lllllllllllllllIllIlllIllllIllIl.copy();
                    lllllllllllllllIllIlllIllllIlIlI.stackSize = ((lllllllllllllllIllIlllIllllIIllI == 0) ? 1 : lllllllllllllllIllIlllIllllIlIlI.getMaxStackSize());
                    this.mc.thePlayer.dropPlayerItemWithRandomChoice(lllllllllllllllIllIlllIllllIlIlI, true);
                    this.mc.playerController.sendPacketDropItem(lllllllllllllllIllIlllIllllIlIlI);
                }
                return;
            }
            if (lllllllllllllllIllIlllIlllllIlII != null && lllllllllllllllIllIlllIllllIllIl != null && lllllllllllllllIllIlllIlllllIlII.isItemEqual(lllllllllllllllIllIlllIllllIllIl)) {
                if (lllllllllllllllIllIlllIllllIIllI == 0) {
                    if (lllllllllllllllIllIlllIlllllIllI) {
                        lllllllllllllllIllIlllIlllllIlII.stackSize = lllllllllllllllIllIlllIlllllIlII.getMaxStackSize();
                    }
                    else if (lllllllllllllllIllIlllIlllllIlII.stackSize < lllllllllllllllIllIlllIlllllIlII.getMaxStackSize()) {
                        final ItemStack itemStack = lllllllllllllllIllIlllIlllllIlII;
                        ++itemStack.stackSize;
                    }
                }
                else if (lllllllllllllllIllIlllIlllllIlII.stackSize <= 1) {
                    lllllllllllllllIllIlllIlllllIIlI.setItemStack(null);
                }
                else {
                    final ItemStack itemStack2 = lllllllllllllllIllIlllIlllllIlII;
                    --itemStack2.stackSize;
                }
            }
            else if (lllllllllllllllIllIlllIllllIllIl != null && lllllllllllllllIllIlllIlllllIlII == null) {
                lllllllllllllllIllIlllIlllllIIlI.setItemStack(ItemStack.copyItemStack(lllllllllllllllIllIlllIllllIllIl));
                lllllllllllllllIllIlllIlllllIlII = lllllllllllllllIllIlllIlllllIIlI.getItemStack();
                if (lllllllllllllllIllIlllIlllllIllI) {
                    lllllllllllllllIllIlllIlllllIlII.stackSize = lllllllllllllllIllIlllIlllllIlII.getMaxStackSize();
                }
            }
            else {
                lllllllllllllllIllIlllIlllllIIlI.setItemStack(null);
            }
        }
        else {
            this.inventorySlots.slotClick((lllllllllllllllIllIlllIllllIlIII == null) ? lllllllllllllllIllIlllIllllIIlll : lllllllllllllllIllIlllIllllIlIII.slotNumber, lllllllllllllllIllIlllIllllIIllI, lllllllllllllllIllIlllIllllIIlIl, this.mc.thePlayer);
            if (Container.getDragEvent(lllllllllllllllIllIlllIllllIIllI) == 2) {
                for (int lllllllllllllllIllIlllIlllllIIII = 0; lllllllllllllllIllIlllIlllllIIII < 9; ++lllllllllllllllIllIlllIlllllIIII) {
                    this.mc.playerController.sendSlotPacket(this.inventorySlots.getSlot(45 + lllllllllllllllIllIlllIlllllIIII).getStack(), 36 + lllllllllllllllIllIlllIlllllIIII);
                }
            }
            else if (lllllllllllllllIllIlllIllllIlIII != null) {
                final ItemStack lllllllllllllllIllIlllIllllIlllI = this.inventorySlots.getSlot(lllllllllllllllIllIlllIllllIlIII.slotNumber).getStack();
                this.mc.playerController.sendSlotPacket(lllllllllllllllIllIlllIllllIlllI, lllllllllllllllIllIlllIllllIlIII.slotNumber - this.inventorySlots.inventorySlots.size() + 9 + 36);
            }
        }
    }
    
    static {
        __OBFID = "CL_00000752";
        creativeInventoryTabs = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
        GuiContainerCreative.field_147060_v = new InventoryBasic("tmp", true, 45);
        GuiContainerCreative.selectedTabIndex = CreativeTabs.tabBlock.getTabIndex();
    }
    
    @Override
    public void initGui() {
        if (this.mc.playerController.isInCreativeMode()) {
            super.initGui();
            this.buttonList.clear();
            Keyboard.enableRepeatEvents(true);
            this.searchField = new GuiTextField(0, this.fontRendererObj, this.guiLeft + 82, this.guiTop + 6, 89, this.fontRendererObj.FONT_HEIGHT);
            this.searchField.setMaxStringLength(15);
            this.searchField.setEnableBackgroundDrawing(false);
            this.searchField.setVisible(false);
            this.searchField.setTextColor(16777215);
            final int lllllllllllllllIllIlllIlllIllIlI = GuiContainerCreative.selectedTabIndex;
            GuiContainerCreative.selectedTabIndex = -1;
            this.setCurrentCreativeTab(CreativeTabs.creativeTabArray[lllllllllllllllIllIlllIlllIllIlI]);
            this.field_147059_E = new CreativeCrafting(this.mc);
            this.mc.thePlayer.inventoryContainer.onCraftGuiOpened(this.field_147059_E);
        }
        else {
            this.mc.displayGuiScreen(new GuiInventory(this.mc.thePlayer));
        }
    }
    
    @Override
    public void updateScreen() {
        if (!this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiInventory(this.mc.thePlayer));
        }
        this.func_175378_g();
    }
    
    private void setCurrentCreativeTab(final CreativeTabs lllllllllllllllIllIlllIlIlIIlIll) {
        final int lllllllllllllllIllIlllIlIlIlIlll = GuiContainerCreative.selectedTabIndex;
        GuiContainerCreative.selectedTabIndex = lllllllllllllllIllIlllIlIlIIlIll.getTabIndex();
        final ContainerCreative lllllllllllllllIllIlllIlIlIlIllI = (ContainerCreative)this.inventorySlots;
        this.dragSplittingSlots.clear();
        lllllllllllllllIllIlllIlIlIlIllI.itemList.clear();
        lllllllllllllllIllIlllIlIlIIlIll.displayAllReleventItems(lllllllllllllllIllIlllIlIlIlIllI.itemList);
        if (lllllllllllllllIllIlllIlIlIIlIll == CreativeTabs.tabInventory) {
            final Container lllllllllllllllIllIlllIlIlIlIlIl = this.mc.thePlayer.inventoryContainer;
            if (this.field_147063_B == null) {
                this.field_147063_B = lllllllllllllllIllIlllIlIlIlIllI.inventorySlots;
            }
            lllllllllllllllIllIlllIlIlIlIllI.inventorySlots = Lists.newArrayList();
            for (int lllllllllllllllIllIlllIlIlIlIlII = 0; lllllllllllllllIllIlllIlIlIlIlII < lllllllllllllllIllIlllIlIlIlIlIl.inventorySlots.size(); ++lllllllllllllllIllIlllIlIlIlIlII) {
                final CreativeSlot lllllllllllllllIllIlllIlIlIlIIll = new CreativeSlot(lllllllllllllllIllIlllIlIlIlIlIl.inventorySlots.get(lllllllllllllllIllIlllIlIlIlIlII), lllllllllllllllIllIlllIlIlIlIlII);
                lllllllllllllllIllIlllIlIlIlIllI.inventorySlots.add(lllllllllllllllIllIlllIlIlIlIIll);
                if (lllllllllllllllIllIlllIlIlIlIlII >= 5 && lllllllllllllllIllIlllIlIlIlIlII < 9) {
                    final int lllllllllllllllIllIlllIlIlIlIIlI = lllllllllllllllIllIlllIlIlIlIlII - 5;
                    final int lllllllllllllllIllIlllIlIlIlIIII = lllllllllllllllIllIlllIlIlIlIIlI / 2;
                    final int lllllllllllllllIllIlllIlIlIIlllI = lllllllllllllllIllIlllIlIlIlIIlI % 2;
                    lllllllllllllllIllIlllIlIlIlIIll.xDisplayPosition = 9 + lllllllllllllllIllIlllIlIlIlIIII * 54;
                    lllllllllllllllIllIlllIlIlIlIIll.yDisplayPosition = 6 + lllllllllllllllIllIlllIlIlIIlllI * 27;
                }
                else if (lllllllllllllllIllIlllIlIlIlIlII >= 0 && lllllllllllllllIllIlllIlIlIlIlII < 5) {
                    lllllllllllllllIllIlllIlIlIlIIll.yDisplayPosition = -2000;
                    lllllllllllllllIllIlllIlIlIlIIll.xDisplayPosition = -2000;
                }
                else if (lllllllllllllllIllIlllIlIlIlIlII < lllllllllllllllIllIlllIlIlIlIlIl.inventorySlots.size()) {
                    final int lllllllllllllllIllIlllIlIlIlIIIl = lllllllllllllllIllIlllIlIlIlIlII - 9;
                    final int lllllllllllllllIllIlllIlIlIIllll = lllllllllllllllIllIlllIlIlIlIIIl % 9;
                    final int lllllllllllllllIllIlllIlIlIIllIl = lllllllllllllllIllIlllIlIlIlIIIl / 9;
                    lllllllllllllllIllIlllIlIlIlIIll.xDisplayPosition = 9 + lllllllllllllllIllIlllIlIlIIllll * 18;
                    if (lllllllllllllllIllIlllIlIlIlIlII >= 36) {
                        lllllllllllllllIllIlllIlIlIlIIll.yDisplayPosition = 112;
                    }
                    else {
                        lllllllllllllllIllIlllIlIlIlIIll.yDisplayPosition = 54 + lllllllllllllllIllIlllIlIlIIllIl * 18;
                    }
                }
            }
            this.field_147064_C = new Slot(GuiContainerCreative.field_147060_v, 0, 173, 112);
            lllllllllllllllIllIlllIlIlIlIllI.inventorySlots.add(this.field_147064_C);
        }
        else if (lllllllllllllllIllIlllIlIlIlIlll == CreativeTabs.tabInventory.getTabIndex()) {
            lllllllllllllllIllIlllIlIlIlIllI.inventorySlots = this.field_147063_B;
            this.field_147063_B = null;
        }
        if (this.searchField != null) {
            if (lllllllllllllllIllIlllIlIlIIlIll == CreativeTabs.tabAllSearch) {
                this.searchField.setVisible(true);
                this.searchField.setCanLoseFocus(false);
                this.searchField.setFocused(true);
                this.searchField.setText("");
                this.updateCreativeSearch();
            }
            else {
                this.searchField.setVisible(false);
                this.searchField.setCanLoseFocus(true);
                this.searchField.setFocused(false);
            }
        }
        this.currentScroll = 0.0f;
        lllllllllllllllIllIlllIlIlIlIllI.scrollTo(0.0f);
    }
    
    protected boolean renderCreativeInventoryHoveringText(final CreativeTabs lllllllllllllllIllIlllIIlIlIlIll, final int lllllllllllllllIllIlllIIlIlIlIlI, final int lllllllllllllllIllIlllIIlIlIlIIl) {
        final int lllllllllllllllIllIlllIIlIlIlIII = lllllllllllllllIllIlllIIlIlIlIll.getTabColumn();
        int lllllllllllllllIllIlllIIlIlIIlll = 28 * lllllllllllllllIllIlllIIlIlIlIII;
        final byte lllllllllllllllIllIlllIIlIlIIllI = 0;
        if (lllllllllllllllIllIlllIIlIlIlIII == 5) {
            lllllllllllllllIllIlllIIlIlIIlll = this.xSize - 28 + 2;
        }
        else if (lllllllllllllllIllIlllIIlIlIlIII > 0) {
            lllllllllllllllIllIlllIIlIlIIlll += lllllllllllllllIllIlllIIlIlIlIII;
        }
        int lllllllllllllllIllIlllIIlIlIIlII = 0;
        if (lllllllllllllllIllIlllIIlIlIlIll.isTabInFirstRow()) {
            final int lllllllllllllllIllIlllIIlIlIIlIl = lllllllllllllllIllIlllIIlIlIIllI - 32;
        }
        else {
            lllllllllllllllIllIlllIIlIlIIlII = lllllllllllllllIllIlllIIlIlIIllI + this.ySize;
        }
        if (this.isPointInRegion(lllllllllllllllIllIlllIIlIlIIlll + 3, lllllllllllllllIllIlllIIlIlIIlII + 3, 23, 27, lllllllllllllllIllIlllIIlIlIlIlI, lllllllllllllllIllIlllIIlIlIlIIl)) {
            this.drawCreativeTabHoveringText(I18n.format(lllllllllllllllIllIlllIIlIlIlIll.getTranslatedTabLabel(), new Object[0]), lllllllllllllllIllIlllIIlIlIlIlI, lllllllllllllllIllIlllIIlIlIlIIl);
            return true;
        }
        return false;
    }
    
    protected boolean func_147049_a(final CreativeTabs lllllllllllllllIllIlllIIllIIIlII, final int lllllllllllllllIllIlllIIllIIIIll, final int lllllllllllllllIllIlllIIlIlllIIl) {
        final int lllllllllllllllIllIlllIIllIIIIIl = lllllllllllllllIllIlllIIllIIIlII.getTabColumn();
        int lllllllllllllllIllIlllIIllIIIIII = 28 * lllllllllllllllIllIlllIIllIIIIIl;
        final byte lllllllllllllllIllIlllIIlIllllll = 0;
        if (lllllllllllllllIllIlllIIllIIIIIl == 5) {
            lllllllllllllllIllIlllIIllIIIIII = this.xSize - 28 + 2;
        }
        else if (lllllllllllllllIllIlllIIllIIIIIl > 0) {
            lllllllllllllllIllIlllIIllIIIIII += lllllllllllllllIllIlllIIllIIIIIl;
        }
        int lllllllllllllllIllIlllIIlIllllIl = 0;
        if (lllllllllllllllIllIlllIIllIIIlII.isTabInFirstRow()) {
            final int lllllllllllllllIllIlllIIlIlllllI = lllllllllllllllIllIlllIIlIllllll - 32;
        }
        else {
            lllllllllllllllIllIlllIIlIllllIl = lllllllllllllllIllIlllIIlIllllll + this.ySize;
        }
        return lllllllllllllllIllIlllIIllIIIIll >= lllllllllllllllIllIlllIIllIIIIII && lllllllllllllllIllIlllIIllIIIIll <= lllllllllllllllIllIlllIIllIIIIII + 28 && lllllllllllllllIllIlllIIlIlllIIl >= lllllllllllllllIllIlllIIlIllllIl && lllllllllllllllIllIlllIIlIlllIIl <= lllllllllllllllIllIlllIIlIllllIl + 32;
    }
    
    private boolean needsScrollBars() {
        return GuiContainerCreative.selectedTabIndex != CreativeTabs.tabInventory.getTabIndex() && CreativeTabs.creativeTabArray[GuiContainerCreative.selectedTabIndex].shouldHidePlayerInventory() && ((ContainerCreative)this.inventorySlots).func_148328_e();
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllllIllIlllIIllIllllI, final int lllllllllllllllIllIlllIIllIlllIl, final int lllllllllllllllIllIlllIIllIlllII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        RenderHelper.enableGUIStandardItemLighting();
        final CreativeTabs lllllllllllllllIllIlllIIllIllIll = CreativeTabs.creativeTabArray[GuiContainerCreative.selectedTabIndex];
        for (final CreativeTabs lllllllllllllllIllIlllIIllIlIlll : CreativeTabs.creativeTabArray) {
            this.mc.getTextureManager().bindTexture(GuiContainerCreative.creativeInventoryTabs);
            if (lllllllllllllllIllIlllIIllIlIlll.getTabIndex() != GuiContainerCreative.selectedTabIndex) {
                this.func_147051_a(lllllllllllllllIllIlllIIllIlIlll);
            }
        }
        this.mc.getTextureManager().bindTexture(new ResourceLocation(String.valueOf(new StringBuilder("textures/gui/container/creative_inventory/tab_").append(lllllllllllllllIllIlllIIllIllIll.getBackgroundImageName()))));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.searchField.drawTextBox();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final int lllllllllllllllIllIlllIIllIlIllI = this.guiLeft + 175;
        final int lllllllllllllllIllIlllIIllIllIIl = this.guiTop + 18;
        final int lllllllllllllllIllIlllIIllIllIII = lllllllllllllllIllIlllIIllIllIIl + 112;
        this.mc.getTextureManager().bindTexture(GuiContainerCreative.creativeInventoryTabs);
        if (lllllllllllllllIllIlllIIllIllIll.shouldHidePlayerInventory()) {
            this.drawTexturedModalRect(lllllllllllllllIllIlllIIllIlIllI, lllllllllllllllIllIlllIIllIllIIl + (int)((lllllllllllllllIllIlllIIllIllIII - lllllllllllllllIllIlllIIllIllIIl - 17) * this.currentScroll), 232 + (this.needsScrollBars() ? 0 : 12), 0, 12, 15);
        }
        this.func_147051_a(lllllllllllllllIllIlllIIllIllIll);
        if (lllllllllllllllIllIlllIIllIllIll == CreativeTabs.tabInventory) {
            GuiInventory.drawEntityOnScreen(this.guiLeft + 43, this.guiTop + 45, 20, (float)(this.guiLeft + 43 - lllllllllllllllIllIlllIIllIlllIl), (float)(this.guiTop + 45 - 30 - lllllllllllllllIllIlllIIllIlllII), this.mc.thePlayer);
        }
    }
    
    protected void func_147051_a(final CreativeTabs lllllllllllllllIllIlllIIlIIIIlII) {
        final boolean lllllllllllllllIllIlllIIlIIIlllI = lllllllllllllllIllIlllIIlIIIIlII.getTabIndex() == GuiContainerCreative.selectedTabIndex;
        final boolean lllllllllllllllIllIlllIIlIIIllIl = lllllllllllllllIllIlllIIlIIIIlII.isTabInFirstRow();
        final int lllllllllllllllIllIlllIIlIIIllII = lllllllllllllllIllIlllIIlIIIIlII.getTabColumn();
        final int lllllllllllllllIllIlllIIlIIIlIll = lllllllllllllllIllIlllIIlIIIllII * 28;
        int lllllllllllllllIllIlllIIlIIIlIlI = 0;
        int lllllllllllllllIllIlllIIlIIIlIIl = this.guiLeft + 28 * lllllllllllllllIllIlllIIlIIIllII;
        int lllllllllllllllIllIlllIIlIIIlIII = this.guiTop;
        final byte lllllllllllllllIllIlllIIlIIIIlll = 32;
        if (lllllllllllllllIllIlllIIlIIIlllI) {
            lllllllllllllllIllIlllIIlIIIlIlI += 32;
        }
        if (lllllllllllllllIllIlllIIlIIIllII == 5) {
            lllllllllllllllIllIlllIIlIIIlIIl = this.guiLeft + this.xSize - 28;
        }
        else if (lllllllllllllllIllIlllIIlIIIllII > 0) {
            lllllllllllllllIllIlllIIlIIIlIIl += lllllllllllllllIllIlllIIlIIIllII;
        }
        if (lllllllllllllllIllIlllIIlIIIllIl) {
            lllllllllllllllIllIlllIIlIIIlIII -= 28;
        }
        else {
            lllllllllllllllIllIlllIIlIIIlIlI += 64;
            lllllllllllllllIllIlllIIlIIIlIII += this.ySize - 4;
        }
        GlStateManager.disableLighting();
        this.drawTexturedModalRect(lllllllllllllllIllIlllIIlIIIlIIl, lllllllllllllllIllIlllIIlIIIlIII, lllllllllllllllIllIlllIIlIIIlIll, lllllllllllllllIllIlllIIlIIIlIlI, 28, lllllllllllllllIllIlllIIlIIIIlll);
        this.zLevel = 100.0f;
        this.itemRender.zLevel = 100.0f;
        lllllllllllllllIllIlllIIlIIIlIIl += 6;
        lllllllllllllllIllIlllIIlIIIlIII += 8 + (lllllllllllllllIllIlllIIlIIIllIl ? 1 : -1);
        GlStateManager.enableLighting();
        GlStateManager.enableRescaleNormal();
        final ItemStack lllllllllllllllIllIlllIIlIIIIllI = lllllllllllllllIllIlllIIlIIIIlII.getIconItemStack();
        this.itemRender.func_180450_b(lllllllllllllllIllIlllIIlIIIIllI, lllllllllllllllIllIlllIIlIIIlIIl, lllllllllllllllIllIlllIIlIIIlIII);
        this.itemRender.func_175030_a(this.fontRendererObj, lllllllllllllllIllIlllIIlIIIIllI, lllllllllllllllIllIlllIIlIIIlIIl, lllllllllllllllIllIlllIIlIIIlIII);
        GlStateManager.disableLighting();
        this.itemRender.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIllIlllIlIIlIlIIl, final int lllllllllllllllIllIlllIlIIlIlIII, final float lllllllllllllllIllIlllIlIIlIIlll) {
        final boolean lllllllllllllllIllIlllIlIIlIIllI = Mouse.isButtonDown(0);
        final int lllllllllllllllIllIlllIlIIlIIlIl = this.guiLeft;
        final int lllllllllllllllIllIlllIlIIlIIlII = this.guiTop;
        final int lllllllllllllllIllIlllIlIIlIIIll = lllllllllllllllIllIlllIlIIlIIlIl + 175;
        final int lllllllllllllllIllIlllIlIIlIIIlI = lllllllllllllllIllIlllIlIIlIIlII + 18;
        final int lllllllllllllllIllIlllIlIIlIIIIl = lllllllllllllllIllIlllIlIIlIIIll + 14;
        final int lllllllllllllllIllIlllIlIIlIIIII = lllllllllllllllIllIlllIlIIlIIIlI + 112;
        if (!this.wasClicking && lllllllllllllllIllIlllIlIIlIIllI && lllllllllllllllIllIlllIlIIlIlIIl >= lllllllllllllllIllIlllIlIIlIIIll && lllllllllllllllIllIlllIlIIlIlIII >= lllllllllllllllIllIlllIlIIlIIIlI && lllllllllllllllIllIlllIlIIlIlIIl < lllllllllllllllIllIlllIlIIlIIIIl && lllllllllllllllIllIlllIlIIlIlIII < lllllllllllllllIllIlllIlIIlIIIII) {
            this.isScrolling = this.needsScrollBars();
        }
        if (!lllllllllllllllIllIlllIlIIlIIllI) {
            this.isScrolling = false;
        }
        this.wasClicking = lllllllllllllllIllIlllIlIIlIIllI;
        if (this.isScrolling) {
            this.currentScroll = (lllllllllllllllIllIlllIlIIlIlIII - lllllllllllllllIllIlllIlIIlIIIlI - 7.5f) / (lllllllllllllllIllIlllIlIIlIIIII - lllllllllllllllIllIlllIlIIlIIIlI - 15.0f);
            this.currentScroll = MathHelper.clamp_float(this.currentScroll, 0.0f, 1.0f);
            ((ContainerCreative)this.inventorySlots).scrollTo(this.currentScroll);
        }
        super.drawScreen(lllllllllllllllIllIlllIlIIlIlIIl, lllllllllllllllIllIlllIlIIlIlIII, lllllllllllllllIllIlllIlIIlIIlll);
        for (final CreativeTabs lllllllllllllllIllIlllIlIIIlllII : CreativeTabs.creativeTabArray) {
            if (this.renderCreativeInventoryHoveringText(lllllllllllllllIllIlllIlIIIlllII, lllllllllllllllIllIlllIlIIlIlIIl, lllllllllllllllIllIlllIlIIlIlIII)) {
                break;
            }
        }
        if (this.field_147064_C != null && GuiContainerCreative.selectedTabIndex == CreativeTabs.tabInventory.getTabIndex() && this.isPointInRegion(this.field_147064_C.xDisplayPosition, this.field_147064_C.yDisplayPosition, 16, 16, lllllllllllllllIllIlllIlIIlIlIIl, lllllllllllllllIllIlllIlIIlIlIII)) {
            this.drawCreativeTabHoveringText(I18n.format("inventory.binSlot", new Object[0]), lllllllllllllllIllIlllIlIIlIlIIl, lllllllllllllllIllIlllIlIIlIlIII);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableLighting();
    }
    
    public GuiContainerCreative(final EntityPlayer lllllllllllllllIllIllllIIIIIllIl) {
        super(new ContainerCreative(lllllllllllllllIllIllllIIIIIllIl));
        lllllllllllllllIllIllllIIIIIllIl.openContainer = this.inventorySlots;
        this.allowUserInput = true;
        this.ySize = 136;
        this.xSize = 195;
    }
    
    static class ContainerCreative extends Container
    {
        public /* synthetic */ List itemList;
        
        @Override
        public boolean func_94530_a(final ItemStack llllllllllllllIllllIlIIIIllllIIl, final Slot llllllllllllllIllllIlIIIIlllIlll) {
            return llllllllllllllIllllIlIIIIlllIlll.yDisplayPosition > 90;
        }
        
        @Override
        public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllIllllIlIIIlIIIIIIl, final int llllllllllllllIllllIlIIIIlllllIl) {
            if (llllllllllllllIllllIlIIIIlllllIl >= this.inventorySlots.size() - 9 && llllllllllllllIllllIlIIIIlllllIl < this.inventorySlots.size()) {
                final Slot llllllllllllllIllllIlIIIIlllllll = this.inventorySlots.get(llllllllllllllIllllIlIIIIlllllIl);
                if (llllllllllllllIllllIlIIIIlllllll != null && llllllllllllllIllllIlIIIIlllllll.getHasStack()) {
                    llllllllllllllIllllIlIIIIlllllll.putStack(null);
                }
            }
            return null;
        }
        
        static {
            __OBFID = "CL_00000753";
        }
        
        @Override
        protected void retrySlotClick(final int llllllllllllllIllllIlIIIlIIIlIIl, final int llllllllllllllIllllIlIIIlIIIlIII, final boolean llllllllllllllIllllIlIIIlIIIIlll, final EntityPlayer llllllllllllllIllllIlIIIlIIIIllI) {
        }
        
        public ContainerCreative(final EntityPlayer llllllllllllllIllllIlIIIlIlIlIII) {
            this.itemList = Lists.newArrayList();
            final InventoryPlayer llllllllllllllIllllIlIIIlIlIllII = llllllllllllllIllllIlIIIlIlIlIII.inventory;
            for (int llllllllllllllIllllIlIIIlIlIlIll = 0; llllllllllllllIllllIlIIIlIlIlIll < 5; ++llllllllllllllIllllIlIIIlIlIlIll) {
                for (int llllllllllllllIllllIlIIIlIlIlIlI = 0; llllllllllllllIllllIlIIIlIlIlIlI < 9; ++llllllllllllllIllllIlIIIlIlIlIlI) {
                    this.addSlotToContainer(new Slot(GuiContainerCreative.field_147060_v, llllllllllllllIllllIlIIIlIlIlIll * 9 + llllllllllllllIllllIlIIIlIlIlIlI, 9 + llllllllllllllIllllIlIIIlIlIlIlI * 18, 18 + llllllllllllllIllllIlIIIlIlIlIll * 18));
                }
            }
            for (int llllllllllllllIllllIlIIIlIlIlIll = 0; llllllllllllllIllllIlIIIlIlIlIll < 9; ++llllllllllllllIllllIlIIIlIlIlIll) {
                this.addSlotToContainer(new Slot(llllllllllllllIllllIlIIIlIlIllII, llllllllllllllIllllIlIIIlIlIlIll, 9 + llllllllllllllIllllIlIIIlIlIlIll * 18, 112));
            }
            this.scrollTo(0.0f);
        }
        
        @Override
        public boolean canDragIntoSlot(final Slot llllllllllllllIllllIlIIIIlllIIll) {
            return llllllllllllllIllllIlIIIIlllIIll.inventory instanceof InventoryPlayer || (llllllllllllllIllllIlIIIIlllIIll.yDisplayPosition > 90 && llllllllllllllIllllIlIIIIlllIIll.xDisplayPosition <= 162);
        }
        
        public void scrollTo(final float llllllllllllllIllllIlIIIlIIllIlI) {
            final int llllllllllllllIllllIlIIIlIIllIIl = (this.itemList.size() + 8) / 9 - 5;
            int llllllllllllllIllllIlIIIlIIllIII = (int)(llllllllllllllIllllIlIIIlIIllIlI * llllllllllllllIllllIlIIIlIIllIIl + 0.5);
            if (llllllllllllllIllllIlIIIlIIllIII < 0) {
                llllllllllllllIllllIlIIIlIIllIII = 0;
            }
            for (int llllllllllllllIllllIlIIIlIIlIlll = 0; llllllllllllllIllllIlIIIlIIlIlll < 5; ++llllllllllllllIllllIlIIIlIIlIlll) {
                for (int llllllllllllllIllllIlIIIlIIlIllI = 0; llllllllllllllIllllIlIIIlIIlIllI < 9; ++llllllllllllllIllllIlIIIlIIlIllI) {
                    final int llllllllllllllIllllIlIIIlIIlIlIl = llllllllllllllIllllIlIIIlIIlIllI + (llllllllllllllIllllIlIIIlIIlIlll + llllllllllllllIllllIlIIIlIIllIII) * 9;
                    if (llllllllllllllIllllIlIIIlIIlIlIl >= 0 && llllllllllllllIllllIlIIIlIIlIlIl < this.itemList.size()) {
                        GuiContainerCreative.field_147060_v.setInventorySlotContents(llllllllllllllIllllIlIIIlIIlIllI + llllllllllllllIllllIlIIIlIIlIlll * 9, this.itemList.get(llllllllllllllIllllIlIIIlIIlIlIl));
                    }
                    else {
                        GuiContainerCreative.field_147060_v.setInventorySlotContents(llllllllllllllIllllIlIIIlIIlIllI + llllllllllllllIllllIlIIIlIIlIlll * 9, null);
                    }
                }
            }
        }
        
        public boolean func_148328_e() {
            return this.itemList.size() > 45;
        }
        
        @Override
        public boolean canInteractWith(final EntityPlayer llllllllllllllIllllIlIIIlIlIIIll) {
            return true;
        }
    }
    
    class CreativeSlot extends Slot
    {
        private final /* synthetic */ Slot field_148332_b;
        
        @Override
        public boolean getHasStack() {
            return this.field_148332_b.getHasStack();
        }
        
        @Override
        public ItemStack decrStackSize(final int llllllllllllllIllllIlIIlIIlIllII) {
            return this.field_148332_b.decrStackSize(llllllllllllllIllllIlIIlIIlIllII);
        }
        
        @Override
        public ItemStack getStack() {
            return this.field_148332_b.getStack();
        }
        
        @Override
        public boolean isHere(final IInventory llllllllllllllIllllIlIIlIIlIIlIl, final int llllllllllllllIllllIlIIlIIlIIlII) {
            return this.field_148332_b.isHere(llllllllllllllIllllIlIIlIIlIIlIl, llllllllllllllIllllIlIIlIIlIIlII);
        }
        
        @Override
        public void onPickupFromSlot(final EntityPlayer llllllllllllllIllllIlIIlIlIlIlIl, final ItemStack llllllllllllllIllllIlIIlIlIlIlII) {
            this.field_148332_b.onPickupFromSlot(llllllllllllllIllllIlIIlIlIlIlIl, llllllllllllllIllllIlIIlIlIlIlII);
        }
        
        public CreativeSlot(final Slot llllllllllllllIllllIlIIlIlIlllll, final int llllllllllllllIllllIlIIlIlIllllI) {
            super(llllllllllllllIllllIlIIlIlIlllll.inventory, llllllllllllllIllllIlIIlIlIllllI, 0, 0);
            this.field_148332_b = llllllllllllllIllllIlIIlIlIlllll;
        }
        
        @Override
        public void putStack(final ItemStack llllllllllllllIllllIlIIlIlIIIIIl) {
            this.field_148332_b.putStack(llllllllllllllIllllIlIIlIlIIIIIl);
        }
        
        @Override
        public String func_178171_c() {
            return this.field_148332_b.func_178171_c();
        }
        
        static {
            __OBFID = "CL_00000754";
        }
        
        @Override
        public void onSlotChanged() {
            this.field_148332_b.onSlotChanged();
        }
        
        @Override
        public boolean isItemValid(final ItemStack llllllllllllllIllllIlIIlIlIIlIll) {
            return this.field_148332_b.isItemValid(llllllllllllllIllllIlIIlIlIIlIll);
        }
        
        @Override
        public int getSlotStackLimit() {
            return this.field_148332_b.getSlotStackLimit();
        }
        
        @Override
        public int func_178170_b(final ItemStack llllllllllllllIllllIlIIlIIllIIll) {
            return this.field_148332_b.func_178170_b(llllllllllllllIllllIlIIlIIllIIll);
        }
    }
}
