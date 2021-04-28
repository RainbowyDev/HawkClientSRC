package net.minecraft.client.gui.stream;

import net.minecraft.client.stream.*;
import net.minecraft.client.gui.*;
import java.io.*;
import net.minecraft.client.resources.*;
import tv.twitch.chat.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import java.util.*;

public class GuiTwitchUserMode extends GuiScreen
{
    private final /* synthetic */ ChatUserInfo field_152337_h;
    private /* synthetic */ int field_152334_t;
    private static final /* synthetic */ EnumChatFormatting field_152331_a;
    private static final /* synthetic */ EnumChatFormatting field_152335_f;
    private static final /* synthetic */ EnumChatFormatting field_152336_g;
    private final /* synthetic */ IStream field_152333_s;
    private final /* synthetic */ IChatComponent field_152338_i;
    private final /* synthetic */ List field_152332_r;
    
    @Override
    public void drawScreen(final int llllllllllllllIlIIlIlllllIIIIIlI, final int llllllllllllllIlIIlIlllllIIIIIIl, final float llllllllllllllIlIIlIllllIllllIIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.field_152338_i.getUnformattedText(), this.width / 2, 70, 16777215);
        int llllllllllllllIlIIlIllllIlllllll = 80;
        for (final IChatComponent llllllllllllllIlIIlIllllIlllllIl : this.field_152332_r) {
            this.drawString(this.fontRendererObj, llllllllllllllIlIIlIllllIlllllIl.getFormattedText(), this.field_152334_t, llllllllllllllIlIIlIllllIlllllll, 16777215);
            llllllllllllllIlIIlIllllIlllllll += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(llllllllllllllIlIIlIlllllIIIIIlI, llllllllllllllIlIIlIlllllIIIIIIl, llllllllllllllIlIIlIllllIllllIIl);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlIIlIlllllIIIlIll) throws IOException {
        if (llllllllllllllIlIIlIlllllIIIlIll.enabled) {
            if (llllllllllllllIlIIlIlllllIIIlIll.id == 0) {
                this.field_152333_s.func_152917_b(String.valueOf(new StringBuilder("/ban ").append(this.field_152337_h.displayName)));
            }
            else if (llllllllllllllIlIIlIlllllIIIlIll.id == 3) {
                this.field_152333_s.func_152917_b(String.valueOf(new StringBuilder("/unban ").append(this.field_152337_h.displayName)));
            }
            else if (llllllllllllllIlIIlIlllllIIIlIll.id == 2) {
                this.field_152333_s.func_152917_b(String.valueOf(new StringBuilder("/mod ").append(this.field_152337_h.displayName)));
            }
            else if (llllllllllllllIlIIlIlllllIIIlIll.id == 4) {
                this.field_152333_s.func_152917_b(String.valueOf(new StringBuilder("/unmod ").append(this.field_152337_h.displayName)));
            }
            else if (llllllllllllllIlIIlIlllllIIIlIll.id == 1) {
                this.field_152333_s.func_152917_b(String.valueOf(new StringBuilder("/timeout ").append(this.field_152337_h.displayName)));
            }
            this.mc.displayGuiScreen(null);
        }
    }
    
    static {
        __OBFID = "CL_00001837";
        field_152331_a = EnumChatFormatting.DARK_GREEN;
        field_152335_f = EnumChatFormatting.RED;
        field_152336_g = EnumChatFormatting.DARK_PURPLE;
    }
    
    @Override
    public void initGui() {
        final int llllllllllllllIlIIlIlllllIIllIll = this.width / 3;
        final int llllllllllllllIlIIlIlllllIIllIlI = llllllllllllllIlIIlIlllllIIllIll - 130;
        this.buttonList.add(new GuiButton(1, llllllllllllllIlIIlIlllllIIllIll * 0 + llllllllllllllIlIIlIlllllIIllIlI / 2, this.height - 70, 130, 20, I18n.format("stream.userinfo.timeout", new Object[0])));
        this.buttonList.add(new GuiButton(0, llllllllllllllIlIIlIlllllIIllIll * 1 + llllllllllllllIlIIlIlllllIIllIlI / 2, this.height - 70, 130, 20, I18n.format("stream.userinfo.ban", new Object[0])));
        this.buttonList.add(new GuiButton(2, llllllllllllllIlIIlIlllllIIllIll * 2 + llllllllllllllIlIIlIlllllIIllIlI / 2, this.height - 70, 130, 20, I18n.format("stream.userinfo.mod", new Object[0])));
        this.buttonList.add(new GuiButton(5, llllllllllllllIlIIlIlllllIIllIll * 0 + llllllllllllllIlIIlIlllllIIllIlI / 2, this.height - 45, 130, 20, I18n.format("gui.cancel", new Object[0])));
        this.buttonList.add(new GuiButton(3, llllllllllllllIlIIlIlllllIIllIll * 1 + llllllllllllllIlIIlIlllllIIllIlI / 2, this.height - 45, 130, 20, I18n.format("stream.userinfo.unban", new Object[0])));
        this.buttonList.add(new GuiButton(4, llllllllllllllIlIIlIlllllIIllIll * 2 + llllllllllllllIlIIlIlllllIIllIlI / 2, this.height - 45, 130, 20, I18n.format("stream.userinfo.unmod", new Object[0])));
        int llllllllllllllIlIIlIlllllIIllIIl = 0;
        for (final IChatComponent llllllllllllllIlIIlIlllllIIllIII : this.field_152332_r) {
            llllllllllllllIlIIlIlllllIIllIIl = Math.max(llllllllllllllIlIIlIlllllIIllIIl, this.fontRendererObj.getStringWidth(llllllllllllllIlIIlIlllllIIllIII.getFormattedText()));
        }
        this.field_152334_t = this.width / 2 - llllllllllllllIlIIlIlllllIIllIIl / 2;
    }
    
    public static IChatComponent func_152330_a(final ChatUserSubscription llllllllllllllIlIIlIlllllIllIIlI, final String llllllllllllllIlIIlIlllllIllIIIl, final boolean llllllllllllllIlIIlIlllllIllIIII) {
        ChatComponentTranslation llllllllllllllIlIIlIlllllIllIIll = null;
        if (llllllllllllllIlIIlIlllllIllIIlI == ChatUserSubscription.TTV_CHAT_USERSUB_SUBSCRIBER) {
            if (llllllllllllllIlIIlIlllllIllIIIl == null) {
                llllllllllllllIlIIlIlllllIllIIll = new ChatComponentTranslation("stream.user.subscription.subscriber", new Object[0]);
            }
            else if (llllllllllllllIlIIlIlllllIllIIII) {
                llllllllllllllIlIIlIlllllIllIIll = new ChatComponentTranslation("stream.user.subscription.subscriber.self", new Object[0]);
            }
            else {
                llllllllllllllIlIIlIlllllIllIIll = new ChatComponentTranslation("stream.user.subscription.subscriber.other", new Object[] { llllllllllllllIlIIlIlllllIllIIIl });
            }
            llllllllllllllIlIIlIlllllIllIIll.getChatStyle().setColor(GuiTwitchUserMode.field_152331_a);
        }
        else if (llllllllllllllIlIIlIlllllIllIIlI == ChatUserSubscription.TTV_CHAT_USERSUB_TURBO) {
            llllllllllllllIlIIlIlllllIllIIll = new ChatComponentTranslation("stream.user.subscription.turbo", new Object[0]);
            llllllllllllllIlIIlIlllllIllIIll.getChatStyle().setColor(GuiTwitchUserMode.field_152336_g);
        }
        return llllllllllllllIlIIlIlllllIllIIll;
    }
    
    public static IChatComponent func_152329_a(final ChatUserMode llllllllllllllIlIIlIlllllIlIIllI, final String llllllllllllllIlIIlIlllllIlIIlIl, final boolean llllllllllllllIlIIlIlllllIlIIlII) {
        ChatComponentTranslation llllllllllllllIlIIlIlllllIlIIlll = null;
        if (llllllllllllllIlIIlIlllllIlIIllI == ChatUserMode.TTV_CHAT_USERMODE_ADMINSTRATOR) {
            llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.administrator", new Object[0]);
            llllllllllllllIlIIlIlllllIlIIlll.getChatStyle().setColor(GuiTwitchUserMode.field_152336_g);
        }
        else if (llllllllllllllIlIIlIlllllIlIIllI == ChatUserMode.TTV_CHAT_USERMODE_BANNED) {
            if (llllllllllllllIlIIlIlllllIlIIlIl == null) {
                llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.banned", new Object[0]);
            }
            else if (llllllllllllllIlIIlIlllllIlIIlII) {
                llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.banned.self", new Object[0]);
            }
            else {
                llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.banned.other", new Object[] { llllllllllllllIlIIlIlllllIlIIlIl });
            }
            llllllllllllllIlIIlIlllllIlIIlll.getChatStyle().setColor(GuiTwitchUserMode.field_152335_f);
        }
        else if (llllllllllllllIlIIlIlllllIlIIllI == ChatUserMode.TTV_CHAT_USERMODE_BROADCASTER) {
            if (llllllllllllllIlIIlIlllllIlIIlIl == null) {
                llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.broadcaster", new Object[0]);
            }
            else if (llllllllllllllIlIIlIlllllIlIIlII) {
                llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.broadcaster.self", new Object[0]);
            }
            else {
                llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.broadcaster.other", new Object[0]);
            }
            llllllllllllllIlIIlIlllllIlIIlll.getChatStyle().setColor(GuiTwitchUserMode.field_152331_a);
        }
        else if (llllllllllllllIlIIlIlllllIlIIllI == ChatUserMode.TTV_CHAT_USERMODE_MODERATOR) {
            if (llllllllllllllIlIIlIlllllIlIIlIl == null) {
                llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.moderator", new Object[0]);
            }
            else if (llllllllllllllIlIIlIlllllIlIIlII) {
                llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.moderator.self", new Object[0]);
            }
            else {
                llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.moderator.other", new Object[] { llllllllllllllIlIIlIlllllIlIIlIl });
            }
            llllllllllllllIlIIlIlllllIlIIlll.getChatStyle().setColor(GuiTwitchUserMode.field_152331_a);
        }
        else if (llllllllllllllIlIIlIlllllIlIIllI == ChatUserMode.TTV_CHAT_USERMODE_STAFF) {
            llllllllllllllIlIIlIlllllIlIIlll = new ChatComponentTranslation("stream.user.mode.staff", new Object[0]);
            llllllllllllllIlIIlIlllllIlIIlll.getChatStyle().setColor(GuiTwitchUserMode.field_152336_g);
        }
        return llllllllllllllIlIIlIlllllIlIIlll;
    }
    
    public GuiTwitchUserMode(final IStream llllllllllllllIlIIlIllllllIlllIl, final ChatUserInfo llllllllllllllIlIIlIllllllIlllII) {
        this.field_152332_r = Lists.newArrayList();
        this.field_152333_s = llllllllllllllIlIIlIllllllIlllIl;
        this.field_152337_h = llllllllllllllIlIIlIllllllIlllII;
        this.field_152338_i = new ChatComponentText(llllllllllllllIlIIlIllllllIlllII.displayName);
        this.field_152332_r.addAll(func_152328_a(llllllllllllllIlIIlIllllllIlllII.modes, llllllllllllllIlIIlIllllllIlllII.subscriptions, llllllllllllllIlIIlIllllllIlllIl));
    }
    
    public static List func_152328_a(final Set llllllllllllllIlIIlIllllllIlIIIl, final Set llllllllllllllIlIIlIllllllIlIIII, final IStream llllllllllllllIlIIlIllllllIIllll) {
        final String llllllllllllllIlIIlIllllllIIlllI = (llllllllllllllIlIIlIllllllIIllll == null) ? null : llllllllllllllIlIIlIllllllIIllll.func_152921_C();
        final boolean llllllllllllllIlIIlIllllllIIllIl = llllllllllllllIlIIlIllllllIIllll != null && llllllllllllllIlIIlIllllllIIllll.func_152927_B();
        final ArrayList llllllllllllllIlIIlIllllllIIllII = Lists.newArrayList();
        for (final ChatUserMode llllllllllllllIlIIlIllllllIIIllI : llllllllllllllIlIIlIllllllIlIIIl) {
            final IChatComponent llllllllllllllIlIIlIllllllIIlIlI = func_152329_a(llllllllllllllIlIIlIllllllIIIllI, llllllllllllllIlIIlIllllllIIlllI, llllllllllllllIlIIlIllllllIIllIl);
            if (llllllllllllllIlIIlIllllllIIlIlI != null) {
                final ChatComponentText llllllllllllllIlIIlIllllllIIlIII = new ChatComponentText("- ");
                llllllllllllllIlIIlIllllllIIlIII.appendSibling(llllllllllllllIlIIlIllllllIIlIlI);
                llllllllllllllIlIIlIllllllIIllII.add(llllllllllllllIlIIlIllllllIIlIII);
            }
        }
        for (final ChatUserSubscription llllllllllllllIlIIlIllllllIIIlIl : llllllllllllllIlIIlIllllllIlIIII) {
            final IChatComponent llllllllllllllIlIIlIllllllIIlIIl = func_152330_a(llllllllllllllIlIIlIllllllIIIlIl, llllllllllllllIlIIlIllllllIIlllI, llllllllllllllIlIIlIllllllIIllIl);
            if (llllllllllllllIlIIlIllllllIIlIIl != null) {
                final ChatComponentText llllllllllllllIlIIlIllllllIIIlll = new ChatComponentText("- ");
                llllllllllllllIlIIlIllllllIIIlll.appendSibling(llllllllllllllIlIIlIllllllIIlIIl);
                llllllllllllllIlIIlIllllllIIllII.add(llllllllllllllIlIIlIllllllIIIlll);
            }
        }
        return llllllllllllllIlIIlIllllllIIllII;
    }
}
