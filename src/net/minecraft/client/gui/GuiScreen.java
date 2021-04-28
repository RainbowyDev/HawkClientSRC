package net.minecraft.client.gui;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.*;
import com.google.common.base.*;
import org.apache.commons.lang3.*;
import java.awt.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.stats.*;
import org.lwjgl.input.*;
import java.util.*;
import net.minecraft.entity.player.*;
import java.awt.datatransfer.*;
import net.minecraft.event.*;
import java.net.*;
import java.io.*;
import net.minecraft.client.gui.stream.*;
import tv.twitch.chat.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.*;

public abstract class GuiScreen extends Gui implements GuiYesNoCallback
{
    private static final /* synthetic */ Logger field_175287_a;
    public /* synthetic */ int height;
    private /* synthetic */ GuiButton selectedButton;
    private static final /* synthetic */ Set field_175284_f;
    public /* synthetic */ int width;
    protected /* synthetic */ FontRenderer fontRendererObj;
    protected /* synthetic */ RenderItem itemRender;
    public /* synthetic */ int eventButton;
    private /* synthetic */ URI field_175286_t;
    private /* synthetic */ int touchValue;
    private /* synthetic */ long lastMouseEvent;
    protected /* synthetic */ Minecraft mc;
    protected /* synthetic */ List buttonList;
    private static final /* synthetic */ Splitter field_175285_g;
    protected /* synthetic */ List labelList;
    
    public void func_175281_b(final String lllllllllllllllIIIIllIIIlllllIIl, final boolean lllllllllllllllIIIIllIIIlllllIII) {
        if (lllllllllllllllIIIIllIIIlllllIII) {
            this.mc.ingameGUI.getChatGUI().addToSentMessages(lllllllllllllllIIIIllIIIlllllIIl);
        }
        this.mc.thePlayer.sendChatMessage(lllllllllllllllIIIIllIIIlllllIIl);
    }
    
    protected void keyTyped(final char lllllllllllllllIIIIllIIllIIlIIll, final int lllllllllllllllIIIIllIIllIIlIIII) throws IOException {
        if (lllllllllllllllIIIIllIIllIIlIIII == 1) {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null) {
                this.mc.setIngameFocus();
            }
        }
    }
    
    public void updateScreen() {
    }
    
    public static void setClipboardString(final String lllllllllllllllIIIIllIIllIIIlIII) {
        if (!StringUtils.isEmpty((CharSequence)lllllllllllllllIIIIllIIllIIIlIII)) {
            try {
                final StringSelection lllllllllllllllIIIIllIIllIIIlIIl = new StringSelection(lllllllllllllllIIIIllIIllIIIlIII);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(lllllllllllllllIIIIllIIllIIIlIIl, null);
            }
            catch (Exception ex) {}
        }
    }
    
    public static boolean isCtrlKeyDown() {
        return Minecraft.isRunningOnMac ? (Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220)) : (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157));
    }
    
    public GuiScreen() {
        this.buttonList = Lists.newArrayList();
        this.labelList = Lists.newArrayList();
    }
    
    public void drawWorldBackground(final int lllllllllllllllIIIIllIIIlIlIIlIl) {
        if (this.mc.theWorld != null) {
            this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
        }
        else {
            this.drawBackground(lllllllllllllllIIIIllIIIlIlIIlIl);
        }
    }
    
    protected void mouseClicked(final int lllllllllllllllIIIIllIIIlllIllIl, final int lllllllllllllllIIIIllIIIlllIIllI, final int lllllllllllllllIIIIllIIIlllIIlIl) throws IOException {
        if (lllllllllllllllIIIIllIIIlllIIlIl == 0) {
            for (int lllllllllllllllIIIIllIIIlllIlIlI = 0; lllllllllllllllIIIIllIIIlllIlIlI < this.buttonList.size(); ++lllllllllllllllIIIIllIIIlllIlIlI) {
                final GuiButton lllllllllllllllIIIIllIIIlllIlIIl = this.buttonList.get(lllllllllllllllIIIIllIIIlllIlIlI);
                if (lllllllllllllllIIIIllIIIlllIlIIl.mousePressed(this.mc, lllllllllllllllIIIIllIIIlllIllIl, lllllllllllllllIIIIllIIIlllIIllI)) {
                    this.selectedButton = lllllllllllllllIIIIllIIIlllIlIIl;
                    lllllllllllllllIIIIllIIIlllIlIIl.playPressSound(this.mc.getSoundHandler());
                    this.actionPerformed(lllllllllllllllIIIIllIIIlllIlIIl);
                }
            }
        }
    }
    
    protected void drawHoveringText(final List lllllllllllllllIIIIllIIlIlIIlIIl, final int lllllllllllllllIIIIllIIlIlIIlIII, final int lllllllllllllllIIIIllIIlIlIlIlll) {
        if (!lllllllllllllllIIIIllIIlIlIIlIIl.isEmpty()) {
            GlStateManager.disableRescaleNormal();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            int lllllllllllllllIIIIllIIlIlIlIllI = 0;
            for (final String lllllllllllllllIIIIllIIlIlIlIlII : lllllllllllllllIIIIllIIlIlIIlIIl) {
                final int lllllllllllllllIIIIllIIlIlIlIIll = this.fontRendererObj.getStringWidth(lllllllllllllllIIIIllIIlIlIlIlII);
                if (lllllllllllllllIIIIllIIlIlIlIIll > lllllllllllllllIIIIllIIlIlIlIllI) {
                    lllllllllllllllIIIIllIIlIlIlIllI = lllllllllllllllIIIIllIIlIlIlIIll;
                }
            }
            int lllllllllllllllIIIIllIIlIlIlIIlI = lllllllllllllllIIIIllIIlIlIIlIII + 12;
            int lllllllllllllllIIIIllIIlIlIlIIIl = lllllllllllllllIIIIllIIlIlIlIlll - 12;
            int lllllllllllllllIIIIllIIlIlIlIIII = 8;
            if (lllllllllllllllIIIIllIIlIlIIlIIl.size() > 1) {
                lllllllllllllllIIIIllIIlIlIlIIII += 2 + (lllllllllllllllIIIIllIIlIlIIlIIl.size() - 1) * 10;
            }
            if (lllllllllllllllIIIIllIIlIlIlIIlI + lllllllllllllllIIIIllIIlIlIlIllI > this.width) {
                lllllllllllllllIIIIllIIlIlIlIIlI -= 28 + lllllllllllllllIIIIllIIlIlIlIllI;
            }
            if (lllllllllllllllIIIIllIIlIlIlIIIl + lllllllllllllllIIIIllIIlIlIlIIII + 6 > this.height) {
                lllllllllllllllIIIIllIIlIlIlIIIl = this.height - lllllllllllllllIIIIllIIlIlIlIIII - 6;
            }
            this.zLevel = 300.0f;
            this.itemRender.zLevel = 300.0f;
            final int lllllllllllllllIIIIllIIlIlIIllll = -267386864;
            this.drawGradientRect(lllllllllllllllIIIIllIIlIlIlIIlI - 3, lllllllllllllllIIIIllIIlIlIlIIIl - 4, lllllllllllllllIIIIllIIlIlIlIIlI + lllllllllllllllIIIIllIIlIlIlIllI + 3, lllllllllllllllIIIIllIIlIlIlIIIl - 3, lllllllllllllllIIIIllIIlIlIIllll, lllllllllllllllIIIIllIIlIlIIllll);
            this.drawGradientRect(lllllllllllllllIIIIllIIlIlIlIIlI - 3, lllllllllllllllIIIIllIIlIlIlIIIl + lllllllllllllllIIIIllIIlIlIlIIII + 3, lllllllllllllllIIIIllIIlIlIlIIlI + lllllllllllllllIIIIllIIlIlIlIllI + 3, lllllllllllllllIIIIllIIlIlIlIIIl + lllllllllllllllIIIIllIIlIlIlIIII + 4, lllllllllllllllIIIIllIIlIlIIllll, lllllllllllllllIIIIllIIlIlIIllll);
            this.drawGradientRect(lllllllllllllllIIIIllIIlIlIlIIlI - 3, lllllllllllllllIIIIllIIlIlIlIIIl - 3, lllllllllllllllIIIIllIIlIlIlIIlI + lllllllllllllllIIIIllIIlIlIlIllI + 3, lllllllllllllllIIIIllIIlIlIlIIIl + lllllllllllllllIIIIllIIlIlIlIIII + 3, lllllllllllllllIIIIllIIlIlIIllll, lllllllllllllllIIIIllIIlIlIIllll);
            this.drawGradientRect(lllllllllllllllIIIIllIIlIlIlIIlI - 4, lllllllllllllllIIIIllIIlIlIlIIIl - 3, lllllllllllllllIIIIllIIlIlIlIIlI - 3, lllllllllllllllIIIIllIIlIlIlIIIl + lllllllllllllllIIIIllIIlIlIlIIII + 3, lllllllllllllllIIIIllIIlIlIIllll, lllllllllllllllIIIIllIIlIlIIllll);
            this.drawGradientRect(lllllllllllllllIIIIllIIlIlIlIIlI + lllllllllllllllIIIIllIIlIlIlIllI + 3, lllllllllllllllIIIIllIIlIlIlIIIl - 3, lllllllllllllllIIIIllIIlIlIlIIlI + lllllllllllllllIIIIllIIlIlIlIllI + 4, lllllllllllllllIIIIllIIlIlIlIIIl + lllllllllllllllIIIIllIIlIlIlIIII + 3, lllllllllllllllIIIIllIIlIlIIllll, lllllllllllllllIIIIllIIlIlIIllll);
            final int lllllllllllllllIIIIllIIlIlIIlllI = 1347420415;
            final int lllllllllllllllIIIIllIIlIlIIllIl = (lllllllllllllllIIIIllIIlIlIIlllI & 0xFEFEFE) >> 1 | (lllllllllllllllIIIIllIIlIlIIlllI & 0xFF000000);
            this.drawGradientRect(lllllllllllllllIIIIllIIlIlIlIIlI - 3, lllllllllllllllIIIIllIIlIlIlIIIl - 3 + 1, lllllllllllllllIIIIllIIlIlIlIIlI - 3 + 1, lllllllllllllllIIIIllIIlIlIlIIIl + lllllllllllllllIIIIllIIlIlIlIIII + 3 - 1, lllllllllllllllIIIIllIIlIlIIlllI, lllllllllllllllIIIIllIIlIlIIllIl);
            this.drawGradientRect(lllllllllllllllIIIIllIIlIlIlIIlI + lllllllllllllllIIIIllIIlIlIlIllI + 2, lllllllllllllllIIIIllIIlIlIlIIIl - 3 + 1, lllllllllllllllIIIIllIIlIlIlIIlI + lllllllllllllllIIIIllIIlIlIlIllI + 3, lllllllllllllllIIIIllIIlIlIlIIIl + lllllllllllllllIIIIllIIlIlIlIIII + 3 - 1, lllllllllllllllIIIIllIIlIlIIlllI, lllllllllllllllIIIIllIIlIlIIllIl);
            this.drawGradientRect(lllllllllllllllIIIIllIIlIlIlIIlI - 3, lllllllllllllllIIIIllIIlIlIlIIIl - 3, lllllllllllllllIIIIllIIlIlIlIIlI + lllllllllllllllIIIIllIIlIlIlIllI + 3, lllllllllllllllIIIIllIIlIlIlIIIl - 3 + 1, lllllllllllllllIIIIllIIlIlIIlllI, lllllllllllllllIIIIllIIlIlIIlllI);
            this.drawGradientRect(lllllllllllllllIIIIllIIlIlIlIIlI - 3, lllllllllllllllIIIIllIIlIlIlIIIl + lllllllllllllllIIIIllIIlIlIlIIII + 2, lllllllllllllllIIIIllIIlIlIlIIlI + lllllllllllllllIIIIllIIlIlIlIllI + 3, lllllllllllllllIIIIllIIlIlIlIIIl + lllllllllllllllIIIIllIIlIlIlIIII + 3, lllllllllllllllIIIIllIIlIlIIllIl, lllllllllllllllIIIIllIIlIlIIllIl);
            for (int lllllllllllllllIIIIllIIlIlIIllII = 0; lllllllllllllllIIIIllIIlIlIIllII < lllllllllllllllIIIIllIIlIlIIlIIl.size(); ++lllllllllllllllIIIIllIIlIlIIllII) {
                final String lllllllllllllllIIIIllIIlIlIIlIll = lllllllllllllllIIIIllIIlIlIIlIIl.get(lllllllllllllllIIIIllIIlIlIIllII);
                this.fontRendererObj.drawStringWithShadow(lllllllllllllllIIIIllIIlIlIIlIll, (float)lllllllllllllllIIIIllIIlIlIlIIlI, (float)lllllllllllllllIIIIllIIlIlIlIIIl, -1);
                if (lllllllllllllllIIIIllIIlIlIIllII == 0) {
                    lllllllllllllllIIIIllIIlIlIlIIIl += 2;
                }
                lllllllllllllllIIIIllIIlIlIlIIIl += 10;
            }
            this.zLevel = 0.0f;
            this.itemRender.zLevel = 0.0f;
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableRescaleNormal();
        }
    }
    
    protected void func_175272_a(final IChatComponent lllllllllllllllIIIIllIIlIIlIIIII, final int lllllllllllllllIIIIllIIlIIIlllll, final int lllllllllllllllIIIIllIIlIIlIllll) {
        if (lllllllllllllllIIIIllIIlIIlIIIII != null && lllllllllllllllIIIIllIIlIIlIIIII.getChatStyle().getChatHoverEvent() != null) {
            final HoverEvent lllllllllllllllIIIIllIIlIIlIlllI = lllllllllllllllIIIIllIIlIIlIIIII.getChatStyle().getChatHoverEvent();
            if (lllllllllllllllIIIIllIIlIIlIlllI.getAction() == HoverEvent.Action.SHOW_ITEM) {
                ItemStack lllllllllllllllIIIIllIIlIIlIllIl = null;
                try {
                    final NBTTagCompound lllllllllllllllIIIIllIIlIIlIllII = JsonToNBT.func_180713_a(lllllllllllllllIIIIllIIlIIlIlllI.getValue().getUnformattedText());
                    if (lllllllllllllllIIIIllIIlIIlIllII instanceof NBTTagCompound) {
                        lllllllllllllllIIIIllIIlIIlIllIl = ItemStack.loadItemStackFromNBT(lllllllllllllllIIIIllIIlIIlIllII);
                    }
                }
                catch (NBTException ex) {}
                if (lllllllllllllllIIIIllIIlIIlIllIl != null) {
                    this.renderToolTip(lllllllllllllllIIIIllIIlIIlIllIl, lllllllllllllllIIIIllIIlIIIlllll, lllllllllllllllIIIIllIIlIIlIllll);
                }
                else {
                    this.drawCreativeTabHoveringText(String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Invalid Item!")), lllllllllllllllIIIIllIIlIIIlllll, lllllllllllllllIIIIllIIlIIlIllll);
                }
            }
            else if (lllllllllllllllIIIIllIIlIIlIlllI.getAction() == HoverEvent.Action.SHOW_ENTITY) {
                if (this.mc.gameSettings.advancedItemTooltips) {
                    try {
                        final NBTTagCompound lllllllllllllllIIIIllIIlIIlIlIIl = JsonToNBT.func_180713_a(lllllllllllllllIIIIllIIlIIlIlllI.getValue().getUnformattedText());
                        if (lllllllllllllllIIIIllIIlIIlIlIIl instanceof NBTTagCompound) {
                            final ArrayList lllllllllllllllIIIIllIIlIIlIlIII = Lists.newArrayList();
                            final NBTTagCompound lllllllllllllllIIIIllIIlIIlIIlll = lllllllllllllllIIIIllIIlIIlIlIIl;
                            lllllllllllllllIIIIllIIlIIlIlIII.add(lllllllllllllllIIIIllIIlIIlIIlll.getString("name"));
                            if (lllllllllllllllIIIIllIIlIIlIIlll.hasKey("type", 8)) {
                                final String lllllllllllllllIIIIllIIlIIlIlIll = lllllllllllllllIIIIllIIlIIlIIlll.getString("type");
                                lllllllllllllllIIIIllIIlIIlIlIII.add(String.valueOf(new StringBuilder("Type: ").append(lllllllllllllllIIIIllIIlIIlIlIll).append(" (").append(EntityList.func_180122_a(lllllllllllllllIIIIllIIlIIlIlIll)).append(")")));
                            }
                            lllllllllllllllIIIIllIIlIIlIlIII.add(lllllllllllllllIIIIllIIlIIlIIlll.getString("id"));
                            this.drawHoveringText(lllllllllllllllIIIIllIIlIIlIlIII, lllllllllllllllIIIIllIIlIIIlllll, lllllllllllllllIIIIllIIlIIlIllll);
                        }
                        else {
                            this.drawCreativeTabHoveringText(String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Invalid Entity!")), lllllllllllllllIIIIllIIlIIIlllll, lllllllllllllllIIIIllIIlIIlIllll);
                        }
                    }
                    catch (NBTException lllllllllllllllIIIIllIIlIIlIIllI) {
                        this.drawCreativeTabHoveringText(String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Invalid Entity!")), lllllllllllllllIIIIllIIlIIIlllll, lllllllllllllllIIIIllIIlIIlIllll);
                    }
                }
            }
            else if (lllllllllllllllIIIIllIIlIIlIlllI.getAction() == HoverEvent.Action.SHOW_TEXT) {
                this.drawHoveringText(GuiScreen.field_175285_g.splitToList((CharSequence)lllllllllllllllIIIIllIIlIIlIlllI.getValue().getFormattedText()), lllllllllllllllIIIIllIIlIIIlllll, lllllllllllllllIIIIllIIlIIlIllll);
            }
            else if (lllllllllllllllIIIIllIIlIIlIlllI.getAction() == HoverEvent.Action.SHOW_ACHIEVEMENT) {
                final StatBase lllllllllllllllIIIIllIIlIIlIIlIl = StatList.getOneShotStat(lllllllllllllllIIIIllIIlIIlIlllI.getValue().getUnformattedText());
                if (lllllllllllllllIIIIllIIlIIlIIlIl != null) {
                    final IChatComponent lllllllllllllllIIIIllIIlIIlIIlII = lllllllllllllllIIIIllIIlIIlIIlIl.getStatName();
                    final ChatComponentTranslation lllllllllllllllIIIIllIIlIIlIIIll = new ChatComponentTranslation(String.valueOf(new StringBuilder("stats.tooltip.type.").append(lllllllllllllllIIIIllIIlIIlIIlIl.isAchievement() ? "achievement" : "statistic")), new Object[0]);
                    lllllllllllllllIIIIllIIlIIlIIIll.getChatStyle().setItalic(true);
                    final String lllllllllllllllIIIIllIIlIIlIlIlI = (lllllllllllllllIIIIllIIlIIlIIlIl instanceof Achievement) ? ((Achievement)lllllllllllllllIIIIllIIlIIlIIlIl).getDescription() : null;
                    final ArrayList lllllllllllllllIIIIllIIlIIlIIIlI = Lists.newArrayList((Object[])new String[] { lllllllllllllllIIIIllIIlIIlIIlII.getFormattedText(), lllllllllllllllIIIIllIIlIIlIIIll.getFormattedText() });
                    if (lllllllllllllllIIIIllIIlIIlIlIlI != null) {
                        lllllllllllllllIIIIllIIlIIlIIIlI.addAll(this.fontRendererObj.listFormattedStringToWidth(lllllllllllllllIIIIllIIlIIlIlIlI, 150));
                    }
                    this.drawHoveringText(lllllllllllllllIIIIllIIlIIlIIIlI, lllllllllllllllIIIIllIIlIIIlllll, lllllllllllllllIIIIllIIlIIlIllll);
                }
                else {
                    this.drawCreativeTabHoveringText(String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Invalid statistic/achievement!")), lllllllllllllllIIIIllIIlIIIlllll, lllllllllllllllIIIIllIIlIIlIllll);
                }
            }
            GlStateManager.disableLighting();
        }
    }
    
    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }
    
    public void handleInput() throws IOException {
        if (Mouse.isCreated()) {
            while (Mouse.next()) {
                this.handleMouseInput();
            }
        }
        if (Keyboard.isCreated()) {
            while (Keyboard.next()) {
                this.handleKeyboardInput();
            }
        }
    }
    
    public void setWorldAndResolution(final Minecraft lllllllllllllllIIIIllIIIllIIIllI, final int lllllllllllllllIIIIllIIIllIIIlIl, final int lllllllllllllllIIIIllIIIllIIlIII) {
        this.mc = lllllllllllllllIIIIllIIIllIIIllI;
        this.itemRender = lllllllllllllllIIIIllIIIllIIIllI.getRenderItem();
        this.fontRendererObj = lllllllllllllllIIIIllIIIllIIIllI.fontRendererObj;
        this.width = lllllllllllllllIIIIllIIIllIIIlIl;
        this.height = lllllllllllllllIIIIllIIIllIIlIII;
        this.buttonList.clear();
        this.initGui();
    }
    
    public void drawDefaultBackground() {
        this.drawWorldBackground(0);
    }
    
    public boolean doesGuiPauseGame() {
        return true;
    }
    
    protected void mouseClickMove(final int lllllllllllllllIIIIllIIIllIlIlIl, final int lllllllllllllllIIIIllIIIllIlIlII, final int lllllllllllllllIIIIllIIIllIlIIll, final long lllllllllllllllIIIIllIIIllIlIIlI) {
    }
    
    public void func_175273_b(final Minecraft lllllllllllllllIIIIllIIIIllIllIl, final int lllllllllllllllIIIIllIIIIllIllII, final int lllllllllllllllIIIIllIIIIllIlIll) {
        this.setWorldAndResolution(lllllllllllllllIIIIllIIIIllIllIl, lllllllllllllllIIIIllIIIIllIllII, lllllllllllllllIIIIllIIIIllIlIll);
    }
    
    public void handleKeyboardInput() throws IOException {
        if (Keyboard.getEventKeyState()) {
            this.keyTyped(Keyboard.getEventCharacter(), Keyboard.getEventKey());
        }
        this.mc.dispatchKeypresses();
    }
    
    protected void actionPerformed(final GuiButton lllllllllllllllIIIIllIIIllIlIIII) throws IOException {
    }
    
    protected void drawCreativeTabHoveringText(final String lllllllllllllllIIIIllIIlIllIlIll, final int lllllllllllllllIIIIllIIlIllIlllI, final int lllllllllllllllIIIIllIIlIllIllIl) {
        this.drawHoveringText(Arrays.asList(lllllllllllllllIIIIllIIlIllIlIll), lllllllllllllllIIIIllIIlIllIlllI, lllllllllllllllIIIIllIIlIllIllIl);
    }
    
    private void func_175282_a(final URI lllllllllllllllIIIIllIIIlIIIIlIl) {
        try {
            final Class lllllllllllllllIIIIllIIIlIIIIlII = Class.forName("java.awt.Desktop");
            final Object lllllllllllllllIIIIllIIIlIIIIIll = lllllllllllllllIIIIllIIIlIIIIlII.getMethod("getDesktop", (Class[])new Class[0]).invoke(null, new Object[0]);
            lllllllllllllllIIIIllIIIlIIIIlII.getMethod("browse", URI.class).invoke(lllllllllllllllIIIIllIIIlIIIIIll, lllllllllllllllIIIIllIIIlIIIIlIl);
        }
        catch (Throwable lllllllllllllllIIIIllIIIlIIIIIlI) {
            GuiScreen.field_175287_a.error("Couldn't open link", lllllllllllllllIIIIllIIIlIIIIIlI);
        }
    }
    
    protected void renderToolTip(final ItemStack lllllllllllllllIIIIllIIlIllllIIl, final int lllllllllllllllIIIIllIIlIllllllI, final int lllllllllllllllIIIIllIIlIlllIlll) {
        final List lllllllllllllllIIIIllIIlIlllllII = lllllllllllllllIIIIllIIlIllllIIl.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips);
        for (int lllllllllllllllIIIIllIIlIllllIll = 0; lllllllllllllllIIIIllIIlIllllIll < lllllllllllllllIIIIllIIlIlllllII.size(); ++lllllllllllllllIIIIllIIlIllllIll) {
            if (lllllllllllllllIIIIllIIlIllllIll == 0) {
                lllllllllllllllIIIIllIIlIlllllII.set(lllllllllllllllIIIIllIIlIllllIll, String.valueOf(new StringBuilder().append(lllllllllllllllIIIIllIIlIllllIIl.getRarity().rarityColor).append(lllllllllllllllIIIIllIIlIlllllII.get(lllllllllllllllIIIIllIIlIllllIll))));
            }
            else {
                lllllllllllllllIIIIllIIlIlllllII.set(lllllllllllllllIIIIllIIlIllllIll, String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append(lllllllllllllllIIIIllIIlIlllllII.get(lllllllllllllllIIIIllIIlIllllIll))));
            }
        }
        this.drawHoveringText(lllllllllllllllIIIIllIIlIlllllII, lllllllllllllllIIIIllIIlIllllllI, lllllllllllllllIIIIllIIlIlllIlll);
    }
    
    public void handleMouseInput() throws IOException {
        final int lllllllllllllllIIIIllIIIlIlllIIl = Mouse.getEventX() * this.width / this.mc.displayWidth;
        final int lllllllllllllllIIIIllIIIlIlllIII = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
        final int lllllllllllllllIIIIllIIIlIllIlll = Mouse.getEventButton();
        if (Mouse.getEventButtonState()) {
            if (this.mc.gameSettings.touchscreen && this.touchValue++ > 0) {
                return;
            }
            this.eventButton = lllllllllllllllIIIIllIIIlIllIlll;
            this.lastMouseEvent = Minecraft.getSystemTime();
            this.mouseClicked(lllllllllllllllIIIIllIIIlIlllIIl, lllllllllllllllIIIIllIIIlIlllIII, this.eventButton);
        }
        else if (lllllllllllllllIIIIllIIIlIllIlll != -1) {
            if (this.mc.gameSettings.touchscreen && --this.touchValue > 0) {
                return;
            }
            this.eventButton = -1;
            this.mouseReleased(lllllllllllllllIIIIllIIIlIlllIIl, lllllllllllllllIIIIllIIIlIlllIII, lllllllllllllllIIIIllIIIlIllIlll);
        }
        else if (this.eventButton != -1 && this.lastMouseEvent > 0L) {
            final long lllllllllllllllIIIIllIIIlIllIllI = Minecraft.getSystemTime() - this.lastMouseEvent;
            this.mouseClickMove(lllllllllllllllIIIIllIIIlIlllIIl, lllllllllllllllIIIIllIIIlIlllIII, this.eventButton, lllllllllllllllIIIIllIIIlIllIllI);
        }
    }
    
    public static String getClipboardString() {
        try {
            final Transferable lllllllllllllllIIIIllIIllIIIlllI = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (lllllllllllllllIIIIllIIllIIIlllI != null && lllllllllllllllIIIIllIIllIIIlllI.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String)lllllllllllllllIIIIllIIllIIIlllI.getTransferData(DataFlavor.stringFlavor);
            }
        }
        catch (Exception ex) {}
        return "";
    }
    
    @Override
    public void confirmClicked(final boolean lllllllllllllllIIIIllIIIlIIIlIll, final int lllllllllllllllIIIIllIIIlIIIlIlI) {
        if (lllllllllllllllIIIIllIIIlIIIlIlI == 31102009) {
            if (lllllllllllllllIIIIllIIIlIIIlIll) {
                this.func_175282_a(this.field_175286_t);
            }
            this.field_175286_t = null;
            this.mc.displayGuiScreen(this);
        }
    }
    
    protected void func_175274_a(final String lllllllllllllllIIIIllIIlIIIlIllI, final boolean lllllllllllllllIIIIllIIlIIIlIlIl) {
    }
    
    protected boolean func_175276_a(final IChatComponent lllllllllllllllIIIIllIIlIIIIlllI) {
        if (lllllllllllllllIIIIllIIlIIIIlllI == null) {
            return false;
        }
        final ClickEvent lllllllllllllllIIIIllIIlIIIIllIl = lllllllllllllllIIIIllIIlIIIIlllI.getChatStyle().getChatClickEvent();
        if (isShiftKeyDown()) {
            if (lllllllllllllllIIIIllIIlIIIIlllI.getChatStyle().getInsertion() != null) {
                this.func_175274_a(lllllllllllllllIIIIllIIlIIIIlllI.getChatStyle().getInsertion(), false);
            }
        }
        else if (lllllllllllllllIIIIllIIlIIIIllIl != null) {
            if (lllllllllllllllIIIIllIIlIIIIllIl.getAction() == ClickEvent.Action.OPEN_URL) {
                if (!this.mc.gameSettings.chatLinks) {
                    return false;
                }
                try {
                    final URI lllllllllllllllIIIIllIIlIIIIllII = new URI(lllllllllllllllIIIIllIIlIIIIllIl.getValue());
                    if (!GuiScreen.field_175284_f.contains(lllllllllllllllIIIIllIIlIIIIllII.getScheme().toLowerCase())) {
                        throw new URISyntaxException(lllllllllllllllIIIIllIIlIIIIllIl.getValue(), String.valueOf(new StringBuilder("Unsupported protocol: ").append(lllllllllllllllIIIIllIIlIIIIllII.getScheme().toLowerCase())));
                    }
                    if (this.mc.gameSettings.chatLinksPrompt) {
                        this.field_175286_t = lllllllllllllllIIIIllIIlIIIIllII;
                        this.mc.displayGuiScreen(new GuiConfirmOpenLink(this, lllllllllllllllIIIIllIIlIIIIllIl.getValue(), 31102009, false));
                    }
                    else {
                        this.func_175282_a(lllllllllllllllIIIIllIIlIIIIllII);
                    }
                }
                catch (URISyntaxException lllllllllllllllIIIIllIIlIIIIlIlI) {
                    GuiScreen.field_175287_a.error(String.valueOf(new StringBuilder("Can't open url for ").append(lllllllllllllllIIIIllIIlIIIIllIl)), (Throwable)lllllllllllllllIIIIllIIlIIIIlIlI);
                }
            }
            else if (lllllllllllllllIIIIllIIlIIIIllIl.getAction() == ClickEvent.Action.OPEN_FILE) {
                final URI lllllllllllllllIIIIllIIlIIIIlIll = new File(lllllllllllllllIIIIllIIlIIIIllIl.getValue()).toURI();
                this.func_175282_a(lllllllllllllllIIIIllIIlIIIIlIll);
            }
            else if (lllllllllllllllIIIIllIIlIIIIllIl.getAction() == ClickEvent.Action.SUGGEST_COMMAND) {
                this.func_175274_a(lllllllllllllllIIIIllIIlIIIIllIl.getValue(), true);
            }
            else if (lllllllllllllllIIIIllIIlIIIIllIl.getAction() == ClickEvent.Action.RUN_COMMAND) {
                this.func_175281_b(lllllllllllllllIIIIllIIlIIIIllIl.getValue(), false);
            }
            else if (lllllllllllllllIIIIllIIlIIIIllIl.getAction() == ClickEvent.Action.TWITCH_USER_INFO) {
                final ChatUserInfo lllllllllllllllIIIIllIIlIIIIlIIl = this.mc.getTwitchStream().func_152926_a(lllllllllllllllIIIIllIIlIIIIllIl.getValue());
                if (lllllllllllllllIIIIllIIlIIIIlIIl != null) {
                    this.mc.displayGuiScreen(new GuiTwitchUserMode(this.mc.getTwitchStream(), lllllllllllllllIIIIllIIlIIIIlIIl));
                }
                else {
                    GuiScreen.field_175287_a.error("Tried to handle twitch user but couldn't find them!");
                }
            }
            else {
                GuiScreen.field_175287_a.error(String.valueOf(new StringBuilder("Don't know how to handle ").append(lllllllllllllllIIIIllIIlIIIIllIl)));
            }
            return true;
        }
        return false;
    }
    
    public void drawScreen(final int lllllllllllllllIIIIllIIllIIllIIl, final int lllllllllllllllIIIIllIIllIIllIII, final float lllllllllllllllIIIIllIIllIIlllII) {
        for (int lllllllllllllllIIIIllIIllIIllIll = 0; lllllllllllllllIIIIllIIllIIllIll < this.buttonList.size(); ++lllllllllllllllIIIIllIIllIIllIll) {
            this.buttonList.get(lllllllllllllllIIIIllIIllIIllIll).drawButton(this.mc, lllllllllllllllIIIIllIIllIIllIIl, lllllllllllllllIIIIllIIllIIllIII);
        }
        for (int lllllllllllllllIIIIllIIllIIllIll = 0; lllllllllllllllIIIIllIIllIIllIll < this.labelList.size(); ++lllllllllllllllIIIIllIIllIIllIll) {
            this.labelList.get(lllllllllllllllIIIIllIIllIIllIll).drawLabel(this.mc, lllllllllllllllIIIIllIIllIIllIIl, lllllllllllllllIIIIllIIllIIllIII);
        }
    }
    
    public static boolean func_175279_e(final int lllllllllllllllIIIIllIIIIllllIIl) {
        return lllllllllllllllIIIIllIIIIllllIIl == 47 && isCtrlKeyDown();
    }
    
    public static boolean func_175280_f(final int lllllllllllllllIIIIllIIIIlllIllI) {
        return lllllllllllllllIIIIllIIIIlllIllI == 46 && isCtrlKeyDown();
    }
    
    public void initGui() {
    }
    
    static {
        __OBFID = "CL_00000710";
        field_175287_a = LogManager.getLogger();
        field_175284_f = Sets.newHashSet((Object[])new String[] { "http", "https" });
        field_175285_g = Splitter.on('\n');
    }
    
    public void onGuiClosed() {
    }
    
    public void func_175275_f(final String lllllllllllllllIIIIllIIlIIIIIIII) {
        this.func_175281_b(lllllllllllllllIIIIllIIlIIIIIIII, true);
    }
    
    public static boolean func_175283_s() {
        return Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
    }
    
    protected void mouseReleased(final int lllllllllllllllIIIIllIIIllIllIIl, final int lllllllllllllllIIIIllIIIllIllIII, final int lllllllllllllllIIIIllIIIllIllIll) {
        if (this.selectedButton != null && lllllllllllllllIIIIllIIIllIllIll == 0) {
            this.selectedButton.mouseReleased(lllllllllllllllIIIIllIIIllIllIIl, lllllllllllllllIIIIllIIIllIllIII);
            this.selectedButton = null;
        }
    }
    
    public void drawBackground(final int lllllllllllllllIIIIllIIIlIIlIlll) {
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        final Tessellator lllllllllllllllIIIIllIIIlIIllIll = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllIIIIllIIIlIIllIlI = lllllllllllllllIIIIllIIIlIIllIll.getWorldRenderer();
        this.mc.getTextureManager().bindTexture(GuiScreen.optionsBackground);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final float lllllllllllllllIIIIllIIIlIIllIIl = 32.0f;
        lllllllllllllllIIIIllIIIlIIllIlI.startDrawingQuads();
        lllllllllllllllIIIIllIIIlIIllIlI.func_178991_c(4210752);
        lllllllllllllllIIIIllIIIlIIllIlI.addVertexWithUV(0.0, this.height, 0.0, 0.0, this.height / lllllllllllllllIIIIllIIIlIIllIIl + lllllllllllllllIIIIllIIIlIIlIlll);
        lllllllllllllllIIIIllIIIlIIllIlI.addVertexWithUV(this.width, this.height, 0.0, this.width / lllllllllllllllIIIIllIIIlIIllIIl, this.height / lllllllllllllllIIIIllIIIlIIllIIl + lllllllllllllllIIIIllIIIlIIlIlll);
        lllllllllllllllIIIIllIIIlIIllIlI.addVertexWithUV(this.width, 0.0, 0.0, this.width / lllllllllllllllIIIIllIIIlIIllIIl, lllllllllllllllIIIIllIIIlIIlIlll);
        lllllllllllllllIIIIllIIIlIIllIlI.addVertexWithUV(0.0, 0.0, 0.0, 0.0, lllllllllllllllIIIIllIIIlIIlIlll);
        lllllllllllllllIIIIllIIIlIIllIll.draw();
    }
    
    public static boolean func_175277_d(final int lllllllllllllllIIIIllIIIIlllllII) {
        return lllllllllllllllIIIIllIIIIlllllII == 45 && isCtrlKeyDown();
    }
    
    public static boolean func_175278_g(final int lllllllllllllllIIIIllIIIIlllIIll) {
        return lllllllllllllllIIIIllIIIIlllIIll == 30 && isCtrlKeyDown();
    }
}
