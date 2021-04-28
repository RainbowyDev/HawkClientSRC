package net.minecraft.client.gui;

import net.minecraft.client.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;

public class GuiNewChat extends Gui
{
    private /* synthetic */ boolean isScrolled;
    private /* synthetic */ int scrollPos;
    private final /* synthetic */ List field_146253_i;
    private final /* synthetic */ Minecraft mc;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ List chatLines;
    private final /* synthetic */ List sentMessages;
    
    public void deleteChatLine(final int llllllllllllllIIllllIIlIIIIllIIl) {
        Iterator llllllllllllllIIllllIIlIIIIllIII = this.field_146253_i.iterator();
        while (llllllllllllllIIllllIIlIIIIllIII.hasNext()) {
            final ChatLine llllllllllllllIIllllIIlIIIIlIlll = llllllllllllllIIllllIIlIIIIllIII.next();
            if (llllllllllllllIIllllIIlIIIIlIlll.getChatLineID() == llllllllllllllIIllllIIlIIIIllIIl) {
                llllllllllllllIIllllIIlIIIIllIII.remove();
            }
        }
        llllllllllllllIIllllIIlIIIIllIII = this.chatLines.iterator();
        while (llllllllllllllIIllllIIlIIIIllIII.hasNext()) {
            final ChatLine llllllllllllllIIllllIIlIIIIlIllI = llllllllllllllIIllllIIlIIIIllIII.next();
            if (llllllllllllllIIllllIIlIIIIlIllI.getChatLineID() == llllllllllllllIIllllIIlIIIIllIIl) {
                llllllllllllllIIllllIIlIIIIllIII.remove();
                break;
            }
        }
    }
    
    public int getChatHeight() {
        return calculateChatboxHeight(this.getChatOpen() ? this.mc.gameSettings.chatHeightFocused : this.mc.gameSettings.chatHeightUnfocused);
    }
    
    public boolean getChatOpen() {
        return this.mc.currentScreen instanceof GuiChat;
    }
    
    public void clearChatMessages() {
        this.field_146253_i.clear();
        this.chatLines.clear();
        this.sentMessages.clear();
    }
    
    public void addToSentMessages(final String llllllllllllllIIllllIIlIIlIllIII) {
        if (this.sentMessages.isEmpty() || !this.sentMessages.get(this.sentMessages.size() - 1).equals(llllllllllllllIIllllIIlIIlIllIII)) {
            this.sentMessages.add(llllllllllllllIIllllIIlIIlIllIII);
        }
    }
    
    public void printChatMessageWithOptionalDeletion(final IChatComponent llllllllllllllIIllllIIlIlIIIllII, final int llllllllllllllIIllllIIlIlIIIlIII) {
        this.setChatLine(llllllllllllllIIllllIIlIlIIIllII, llllllllllllllIIllllIIlIlIIIlIII, this.mc.ingameGUI.getUpdateCounter(), false);
        GuiNewChat.logger.info(String.valueOf(new StringBuilder("[CHAT] ").append(llllllllllllllIIllllIIlIlIIIllII.getUnformattedText())));
    }
    
    public int getLineCount() {
        return this.getChatHeight() / 9;
    }
    
    public void printChatMessage(final IChatComponent llllllllllllllIIllllIIlIlIIlIIIl) {
        this.printChatMessageWithOptionalDeletion(llllllllllllllIIllllIIlIlIIlIIIl, 0);
    }
    
    public IChatComponent getChatComponent(final int llllllllllllllIIllllIIlIIIllllII, final int llllllllllllllIIllllIIlIIIlllIll) {
        if (!this.getChatOpen()) {
            return null;
        }
        final ScaledResolution llllllllllllllIIllllIIlIIIlllIlI = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int llllllllllllllIIllllIIlIIIlllIIl = llllllllllllllIIllllIIlIIIlllIlI.getScaleFactor();
        final float llllllllllllllIIllllIIlIIIlllIII = this.getChatScale();
        int llllllllllllllIIllllIIlIIIllIlll = llllllllllllllIIllllIIlIIIllllII / llllllllllllllIIllllIIlIIIlllIIl - 3;
        int llllllllllllllIIllllIIlIIIllIllI = llllllllllllllIIllllIIlIIIlllIll / llllllllllllllIIllllIIlIIIlllIIl - 27;
        llllllllllllllIIllllIIlIIIllIlll = MathHelper.floor_float(llllllllllllllIIllllIIlIIIllIlll / llllllllllllllIIllllIIlIIIlllIII);
        llllllllllllllIIllllIIlIIIllIllI = MathHelper.floor_float(llllllllllllllIIllllIIlIIIllIllI / llllllllllllllIIllllIIlIIIlllIII);
        if (llllllllllllllIIllllIIlIIIllIlll < 0 || llllllllllllllIIllllIIlIIIllIllI < 0) {
            return null;
        }
        final int llllllllllllllIIllllIIlIIIllIlIl = Math.min(this.getLineCount(), this.field_146253_i.size());
        if (llllllllllllllIIllllIIlIIIllIlll <= MathHelper.floor_float(this.getChatWidth() / this.getChatScale()) && llllllllllllllIIllllIIlIIIllIllI < this.mc.fontRendererObj.FONT_HEIGHT * llllllllllllllIIllllIIlIIIllIlIl + llllllllllllllIIllllIIlIIIllIlIl) {
            final int llllllllllllllIIllllIIlIIIllIlII = llllllllllllllIIllllIIlIIIllIllI / this.mc.fontRendererObj.FONT_HEIGHT + this.scrollPos;
            if (llllllllllllllIIllllIIlIIIllIlII >= 0 && llllllllllllllIIllllIIlIIIllIlII < this.field_146253_i.size()) {
                final ChatLine llllllllllllllIIllllIIlIIIllIIll = this.field_146253_i.get(llllllllllllllIIllllIIlIIIllIlII);
                int llllllllllllllIIllllIIlIIIllIIlI = 0;
                for (final IChatComponent llllllllllllllIIllllIIlIIIllIIII : llllllllllllllIIllllIIlIIIllIIll.getChatComponent()) {
                    if (llllllllllllllIIllllIIlIIIllIIII instanceof ChatComponentText) {
                        llllllllllllllIIllllIIlIIIllIIlI += this.mc.fontRendererObj.getStringWidth(GuiUtilRenderComponents.func_178909_a(((ChatComponentText)llllllllllllllIIllllIIlIIIllIIII).getChatComponentText_TextValue(), false));
                        if (llllllllllllllIIllllIIlIIIllIIlI > llllllllllllllIIllllIIlIIIllIlll) {
                            return llllllllllllllIIllllIIlIIIllIIII;
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return null;
    }
    
    public static int calculateChatboxWidth(final float llllllllllllllIIllllIIlIIIIIIIlI) {
        final short llllllllllllllIIllllIIlIIIIIIlII = 320;
        final byte llllllllllllllIIllllIIlIIIIIIIll = 40;
        return MathHelper.floor_float(llllllllllllllIIllllIIlIIIIIIIlI * (llllllllllllllIIllllIIlIIIIIIlII - llllllllllllllIIllllIIlIIIIIIIll) + llllllllllllllIIllllIIlIIIIIIIll);
    }
    
    private void setChatLine(final IChatComponent llllllllllllllIIllllIIlIIlllllII, final int llllllllllllllIIllllIIlIIllllIll, final int llllllllllllllIIllllIIlIIlllIIII, final boolean llllllllllllllIIllllIIlIIllIllll) {
        if (llllllllllllllIIllllIIlIIllllIll != 0) {
            this.deleteChatLine(llllllllllllllIIllllIIlIIllllIll);
        }
        final int llllllllllllllIIllllIIlIIllllIII = MathHelper.floor_float(this.getChatWidth() / this.getChatScale());
        final List llllllllllllllIIllllIIlIIlllIlll = GuiUtilRenderComponents.func_178908_a(llllllllllllllIIllllIIlIIlllllII, llllllllllllllIIllllIIlIIllllIII, this.mc.fontRendererObj, false, false);
        final boolean llllllllllllllIIllllIIlIIlllIllI = this.getChatOpen();
        for (final IChatComponent llllllllllllllIIllllIIlIIlllIlIl : llllllllllllllIIllllIIlIIlllIlll) {
            if (llllllllllllllIIllllIIlIIlllIllI && this.scrollPos > 0) {
                this.isScrolled = true;
                this.scroll(1);
            }
            this.field_146253_i.add(0, new ChatLine(llllllllllllllIIllllIIlIIlllIIII, llllllllllllllIIllllIIlIIlllIlIl, llllllllllllllIIllllIIlIIllllIll));
        }
        while (this.field_146253_i.size() > 100) {
            this.field_146253_i.remove(this.field_146253_i.size() - 1);
        }
        if (!llllllllllllllIIllllIIlIIllIllll) {
            this.chatLines.add(0, new ChatLine(llllllllllllllIIllllIIlIIlllIIII, llllllllllllllIIllllIIlIIlllllII, llllllllllllllIIllllIIlIIllllIll));
            while (this.chatLines.size() > 100) {
                this.chatLines.remove(this.chatLines.size() - 1);
            }
        }
    }
    
    public int getChatWidth() {
        return calculateChatboxWidth(this.mc.gameSettings.chatWidth);
    }
    
    public void scroll(final int llllllllllllllIIllllIIlIIlIIllIl) {
        this.scrollPos += llllllllllllllIIllllIIlIIlIIllIl;
        final int llllllllllllllIIllllIIlIIlIIllll = this.field_146253_i.size();
        if (this.scrollPos > llllllllllllllIIllllIIlIIlIIllll - this.getLineCount()) {
            this.scrollPos = llllllllllllllIIllllIIlIIlIIllll - this.getLineCount();
        }
        if (this.scrollPos <= 0) {
            this.scrollPos = 0;
            this.isScrolled = false;
        }
    }
    
    public static int calculateChatboxHeight(final float llllllllllllllIIllllIIIlllllllII) {
        final short llllllllllllllIIllllIIIllllllIll = 180;
        final byte llllllllllllllIIllllIIIllllllIlI = 20;
        return MathHelper.floor_float(llllllllllllllIIllllIIIlllllllII * (llllllllllllllIIllllIIIllllllIll - llllllllllllllIIllllIIIllllllIlI) + llllllllllllllIIllllIIIllllllIlI);
    }
    
    public void drawChat(final int llllllllllllllIIllllIIlIllIIIIIl) {
        if (this.mc.gameSettings.chatVisibility != EntityPlayer.EnumChatVisibility.HIDDEN) {
            final int llllllllllllllIIllllIIlIllIIIIII = this.getLineCount();
            boolean llllllllllllllIIllllIIlIlIllllll = false;
            int llllllllllllllIIllllIIlIlIlllllI = 0;
            final int llllllllllllllIIllllIIlIlIllllIl = this.field_146253_i.size();
            final float llllllllllllllIIllllIIlIlIllllII = this.mc.gameSettings.chatOpacity * 0.9f + 0.1f;
            if (llllllllllllllIIllllIIlIlIllllIl > 0) {
                if (this.getChatOpen()) {
                    llllllllllllllIIllllIIlIlIllllll = true;
                }
                final float llllllllllllllIIllllIIlIlIlllIll = this.getChatScale();
                final int llllllllllllllIIllllIIlIlIlllIlI = MathHelper.ceiling_float_int(this.getChatWidth() / llllllllllllllIIllllIIlIlIlllIll);
                GlStateManager.pushMatrix();
                GlStateManager.translate(2.0f, 20.0f, 0.0f);
                GlStateManager.scale(llllllllllllllIIllllIIlIlIlllIll, llllllllllllllIIllllIIlIlIlllIll, 1.0f);
                for (int llllllllllllllIIllllIIlIlIlllIIl = 0; llllllllllllllIIllllIIlIlIlllIIl + this.scrollPos < this.field_146253_i.size() && llllllllllllllIIllllIIlIlIlllIIl < llllllllllllllIIllllIIlIllIIIIII; ++llllllllllllllIIllllIIlIlIlllIIl) {
                    final ChatLine llllllllllllllIIllllIIlIlIllIlII = this.field_146253_i.get(llllllllllllllIIllllIIlIlIlllIIl + this.scrollPos);
                    if (llllllllllllllIIllllIIlIlIllIlII != null) {
                        final int llllllllllllllIIllllIIlIlIlllIII = llllllllllllllIIllllIIlIllIIIIIl - llllllllllllllIIllllIIlIlIllIlII.getUpdatedCounter();
                        if (llllllllllllllIIllllIIlIlIlllIII < 200 || llllllllllllllIIllllIIlIlIllllll) {
                            double llllllllllllllIIllllIIlIlIllIIll = llllllllllllllIIllllIIlIlIlllIII / 200.0;
                            llllllllllllllIIllllIIlIlIllIIll = 1.0 - llllllllllllllIIllllIIlIlIllIIll;
                            llllllllllllllIIllllIIlIlIllIIll *= 10.0;
                            llllllllllllllIIllllIIlIlIllIIll = MathHelper.clamp_double(llllllllllllllIIllllIIlIlIllIIll, 0.0, 1.0);
                            llllllllllllllIIllllIIlIlIllIIll *= llllllllllllllIIllllIIlIlIllIIll;
                            int llllllllllllllIIllllIIlIlIllIllI = (int)(255.0 * llllllllllllllIIllllIIlIlIllIIll);
                            if (llllllllllllllIIllllIIlIlIllllll) {
                                llllllllllllllIIllllIIlIlIllIllI = 255;
                            }
                            llllllllllllllIIllllIIlIlIllIllI *= (int)llllllllllllllIIllllIIlIlIllllII;
                            ++llllllllllllllIIllllIIlIlIlllllI;
                            if (llllllllllllllIIllllIIlIlIllIllI > 3) {
                                final byte llllllllllllllIIllllIIlIlIllIIlI = 0;
                                final int llllllllllllllIIllllIIlIlIllIIIl = -llllllllllllllIIllllIIlIlIlllIIl * 9;
                                Gui.drawRect(llllllllllllllIIllllIIlIlIllIIlI, llllllllllllllIIllllIIlIlIllIIIl - 9, llllllllllllllIIllllIIlIlIllIIlI + llllllllllllllIIllllIIlIlIlllIlI + 4, llllllllllllllIIllllIIlIlIllIIIl, llllllllllllllIIllllIIlIlIllIllI / 2 << 24);
                                final String llllllllllllllIIllllIIlIlIllIIII = llllllllllllllIIllllIIlIlIllIlII.getChatComponent().getFormattedText();
                                GlStateManager.enableBlend();
                                this.mc.fontRendererObj.drawStringWithShadow(llllllllllllllIIllllIIlIlIllIIII, llllllllllllllIIllllIIlIlIllIIlI, (float)(llllllllllllllIIllllIIlIlIllIIIl - 8), 16777215 + (llllllllllllllIIllllIIlIlIllIllI << 24));
                                GlStateManager.disableAlpha();
                                GlStateManager.disableBlend();
                            }
                        }
                    }
                }
                if (llllllllllllllIIllllIIlIlIllllll) {
                    final int llllllllllllllIIllllIIlIlIlllIIl = this.mc.fontRendererObj.FONT_HEIGHT;
                    GlStateManager.translate(-3.0f, 0.0f, 0.0f);
                    final int llllllllllllllIIllllIIlIlIlIllll = llllllllllllllIIllllIIlIlIllllIl * llllllllllllllIIllllIIlIlIlllIIl + llllllllllllllIIllllIIlIlIllllIl;
                    final int llllllllllllllIIllllIIlIlIllIlll = llllllllllllllIIllllIIlIlIlllllI * llllllllllllllIIllllIIlIlIlllIIl + llllllllllllllIIllllIIlIlIlllllI;
                    final int llllllllllllllIIllllIIlIlIlIlllI = this.scrollPos * llllllllllllllIIllllIIlIlIllIlll / llllllllllllllIIllllIIlIlIllllIl;
                    final int llllllllllllllIIllllIIlIlIlIllIl = llllllllllllllIIllllIIlIlIllIlll * llllllllllllllIIllllIIlIlIllIlll / llllllllllllllIIllllIIlIlIlIllll;
                    if (llllllllllllllIIllllIIlIlIlIllll != llllllllllllllIIllllIIlIlIllIlll) {
                        final int llllllllllllllIIllllIIlIlIllIlIl = (llllllllllllllIIllllIIlIlIlIlllI > 0) ? 170 : 96;
                        final int llllllllllllllIIllllIIlIlIlIllII = this.isScrolled ? 13382451 : 3355562;
                        Gui.drawRect(0.0, -llllllllllllllIIllllIIlIlIlIlllI, 2.0, -llllllllllllllIIllllIIlIlIlIlllI - llllllllllllllIIllllIIlIlIlIllIl, llllllllllllllIIllllIIlIlIlIllII + (llllllllllllllIIllllIIlIlIllIlIl << 24));
                        Gui.drawRect(2.0, -llllllllllllllIIllllIIlIlIlIlllI, 1.0, -llllllllllllllIIllllIIlIlIlIlllI - llllllllllllllIIllllIIlIlIlIllIl, 13421772 + (llllllllllllllIIllllIIlIlIllIlIl << 24));
                    }
                }
                GlStateManager.popMatrix();
            }
        }
    }
    
    static {
        __OBFID = "CL_00000669";
        logger = LogManager.getLogger();
    }
    
    public List getSentMessages() {
        return this.sentMessages;
    }
    
    public float getChatScale() {
        return this.mc.gameSettings.chatScale;
    }
    
    public void refreshChat() {
        this.field_146253_i.clear();
        this.resetScroll();
        for (int llllllllllllllIIllllIIlIIllIIlIl = this.chatLines.size() - 1; llllllllllllllIIllllIIlIIllIIlIl >= 0; --llllllllllllllIIllllIIlIIllIIlIl) {
            final ChatLine llllllllllllllIIllllIIlIIllIIlII = this.chatLines.get(llllllllllllllIIllllIIlIIllIIlIl);
            this.setChatLine(llllllllllllllIIllllIIlIIllIIlII.getChatComponent(), llllllllllllllIIllllIIlIIllIIlII.getChatLineID(), llllllllllllllIIllllIIlIIllIIlII.getUpdatedCounter(), true);
        }
    }
    
    public GuiNewChat(final Minecraft llllllllllllllIIllllIIlIllIlllll) {
        this.sentMessages = Lists.newArrayList();
        this.chatLines = Lists.newArrayList();
        this.field_146253_i = Lists.newArrayList();
        this.mc = llllllllllllllIIllllIIlIllIlllll;
    }
    
    public void resetScroll() {
        this.scrollPos = 0;
        this.isScrolled = false;
    }
}
