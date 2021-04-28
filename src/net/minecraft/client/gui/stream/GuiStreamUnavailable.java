package net.minecraft.client.gui.stream;

import net.minecraft.client.gui.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import com.google.common.collect.*;
import org.lwjgl.opengl.*;
import tv.twitch.*;
import net.minecraft.util.*;
import net.minecraft.client.stream.*;
import java.net.*;
import org.apache.logging.log4j.*;
import java.util.*;
import net.minecraft.client.resources.*;

public class GuiStreamUnavailable extends GuiScreen
{
    private final /* synthetic */ Reason field_152326_h;
    private final /* synthetic */ GuiScreen field_152325_g;
    private final /* synthetic */ IChatComponent field_152324_f;
    private final /* synthetic */ List field_152323_r;
    private static final /* synthetic */ Logger field_152322_a;
    private final /* synthetic */ List field_152327_i;
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIIIlIlIIIlllIIIII) throws IOException {
        if (lllllllllllllllIIIlIlIIIlllIIIII.enabled) {
            if (lllllllllllllllIIIlIlIIIlllIIIII.id == 1) {
                switch (SwitchReason.field_152577_a[this.field_152326_h.ordinal()]) {
                    case 1:
                    case 2: {
                        this.func_152320_a("https://account.mojang.com/me/settings");
                        break;
                    }
                    case 3: {
                        this.func_152320_a("https://account.mojang.com/migrate");
                        break;
                    }
                    case 4: {
                        this.func_152320_a("http://www.apple.com/osx/");
                        break;
                    }
                    case 5:
                    case 6:
                    case 7: {
                        this.func_152320_a("http://bugs.mojang.com/browse/MC");
                        break;
                    }
                }
            }
            this.mc.displayGuiScreen(this.field_152325_g);
        }
    }
    
    public static void func_152321_a(final GuiScreen lllllllllllllllIIIlIlIIIllIIlIIl) {
        final Minecraft lllllllllllllllIIIlIlIIIllIIllIl = Minecraft.getMinecraft();
        final IStream lllllllllllllllIIIlIlIIIllIIllII = lllllllllllllllIIIlIlIIIllIIllIl.getTwitchStream();
        if (!OpenGlHelper.framebufferSupported) {
            final ArrayList lllllllllllllllIIIlIlIIIllIIlIll = Lists.newArrayList();
            lllllllllllllllIIIlIlIIIllIIlIll.add(new ChatComponentTranslation("stream.unavailable.no_fbo.version", new Object[] { GL11.glGetString(7938) }));
            lllllllllllllllIIIlIlIIIllIIlIll.add(new ChatComponentTranslation("stream.unavailable.no_fbo.blend", new Object[] { GLContext.getCapabilities().GL_EXT_blend_func_separate }));
            lllllllllllllllIIIlIlIIIllIIlIll.add(new ChatComponentTranslation("stream.unavailable.no_fbo.arb", new Object[] { GLContext.getCapabilities().GL_ARB_framebuffer_object }));
            lllllllllllllllIIIlIlIIIllIIlIll.add(new ChatComponentTranslation("stream.unavailable.no_fbo.ext", new Object[] { GLContext.getCapabilities().GL_EXT_framebuffer_object }));
            lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.NO_FBO, lllllllllllllllIIIlIlIIIllIIlIll));
        }
        else if (lllllllllllllllIIIlIlIIIllIIllII instanceof NullStream) {
            if (((NullStream)lllllllllllllllIIIlIlIIIllIIllII).func_152937_a().getMessage().contains("Can't load AMD 64-bit .dll on a IA 32-bit platform")) {
                lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.LIBRARY_ARCH_MISMATCH));
            }
            else {
                lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.LIBRARY_FAILURE));
            }
        }
        else if (!lllllllllllllllIIIlIlIIIllIIllII.func_152928_D() && lllllllllllllllIIIlIlIIIllIIllII.func_152912_E() == ErrorCode.TTV_EC_OS_TOO_OLD) {
            switch (SwitchReason.field_152578_b[Util.getOSType().ordinal()]) {
                case 1: {
                    lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.UNSUPPORTED_OS_WINDOWS));
                    break;
                }
                case 2: {
                    lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.UNSUPPORTED_OS_MAC));
                    break;
                }
                default: {
                    lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.UNSUPPORTED_OS_OTHER));
                    break;
                }
            }
        }
        else if (!lllllllllllllllIIIlIlIIIllIIllIl.func_180509_L().containsKey((Object)"twitch_access_token")) {
            if (lllllllllllllllIIIlIlIIIllIIllIl.getSession().getSessionType() == Session.Type.LEGACY) {
                lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.ACCOUNT_NOT_MIGRATED));
            }
            else {
                lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.ACCOUNT_NOT_BOUND));
            }
        }
        else if (!lllllllllllllllIIIlIlIIIllIIllII.func_152913_F()) {
            switch (SwitchReason.field_152579_c[lllllllllllllllIIIlIlIIIllIIllII.func_152918_H().ordinal()]) {
                case 1: {
                    lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.FAILED_TWITCH_AUTH));
                    break;
                }
                default: {
                    lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.FAILED_TWITCH_AUTH_ERROR));
                    break;
                }
            }
        }
        else if (lllllllllllllllIIIlIlIIIllIIllII.func_152912_E() != null) {
            final List lllllllllllllllIIIlIlIIIllIIlIlI = Arrays.asList(new ChatComponentTranslation("stream.unavailable.initialization_failure.extra", new Object[] { ErrorCode.getString(lllllllllllllllIIIlIlIIIllIIllII.func_152912_E()) }));
            lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.INITIALIZATION_FAILURE, lllllllllllllllIIIlIlIIIllIIlIlI));
        }
        else {
            lllllllllllllllIIIlIlIIIllIIllIl.displayGuiScreen(new GuiStreamUnavailable(lllllllllllllllIIIlIlIIIllIIlIIl, Reason.UNKNOWN));
        }
    }
    
    private void func_152320_a(final String lllllllllllllllIIIlIlIIIllIlIlIl) {
        try {
            final Class lllllllllllllllIIIlIlIIIllIllIII = Class.forName("java.awt.Desktop");
            final Object lllllllllllllllIIIlIlIIIllIlIlll = lllllllllllllllIIIlIlIIIllIllIII.getMethod("getDesktop", (Class[])new Class[0]).invoke(null, new Object[0]);
            lllllllllllllllIIIlIlIIIllIllIII.getMethod("browse", URI.class).invoke(lllllllllllllllIIIlIlIIIllIlIlll, new URI(lllllllllllllllIIIlIlIIIllIlIlIl));
        }
        catch (Throwable lllllllllllllllIIIlIlIIIllIlIllI) {
            GuiStreamUnavailable.field_152322_a.error("Couldn't open link", lllllllllllllllIIIlIlIIIllIlIllI);
        }
    }
    
    @Override
    public void onGuiClosed() {
    }
    
    public GuiStreamUnavailable(final GuiScreen lllllllllllllllIIIlIlIIlIIIlIIII, final Reason lllllllllllllllIIIlIlIIlIIIlIIlI) {
        this(lllllllllllllllIIIlIlIIlIIIlIIII, lllllllllllllllIIIlIlIIlIIIlIIlI, null);
    }
    
    public GuiStreamUnavailable(final GuiScreen lllllllllllllllIIIlIlIIlIIIIIlIl, final Reason lllllllllllllllIIIlIlIIlIIIIIlII, final List lllllllllllllllIIIlIlIIlIIIIIlll) {
        this.field_152324_f = new ChatComponentTranslation("stream.unavailable.title", new Object[0]);
        this.field_152323_r = Lists.newArrayList();
        this.field_152325_g = lllllllllllllllIIIlIlIIlIIIIIlIl;
        this.field_152326_h = lllllllllllllllIIIlIlIIlIIIIIlII;
        this.field_152327_i = lllllllllllllllIIIlIlIIlIIIIIlll;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIIIlIlIIIllllIIII, final int lllllllllllllllIIIlIlIIIlllIlIII, final float lllllllllllllllIIIlIlIIIlllIlllI) {
        this.drawDefaultBackground();
        int lllllllllllllllIIIlIlIIIlllIllIl = Math.max((int)(this.height * 0.85 / 2.0 - this.field_152323_r.size() * this.fontRendererObj.FONT_HEIGHT / 2.0f), 50);
        this.drawCenteredString(this.fontRendererObj, this.field_152324_f.getFormattedText(), this.width / 2, lllllllllllllllIIIlIlIIIlllIllIl - this.fontRendererObj.FONT_HEIGHT * 2, 16777215);
        for (final String lllllllllllllllIIIlIlIIIlllIlIll : this.field_152323_r) {
            this.drawCenteredString(this.fontRendererObj, lllllllllllllllIIIlIlIIIlllIlIll, this.width / 2, lllllllllllllllIIIlIlIIIlllIllIl, 10526880);
            lllllllllllllllIIIlIlIIIlllIllIl += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(lllllllllllllllIIIlIlIIIllllIIII, lllllllllllllllIIIlIlIIIlllIlIII, lllllllllllllllIIIlIlIIIlllIlllI);
    }
    
    static {
        __OBFID = "CL_00001840";
        field_152322_a = LogManager.getLogger();
    }
    
    @Override
    public void initGui() {
        if (this.field_152323_r.isEmpty()) {
            this.field_152323_r.addAll(this.fontRendererObj.listFormattedStringToWidth(this.field_152326_h.func_152561_a().getFormattedText(), (int)(this.width * 0.75f)));
            if (this.field_152327_i != null) {
                this.field_152323_r.add("");
                for (final ChatComponentTranslation lllllllllllllllIIIlIlIIIllllllIl : this.field_152327_i) {
                    this.field_152323_r.add(lllllllllllllllIIIlIlIIIllllllIl.getUnformattedTextForChat());
                }
            }
        }
        if (this.field_152326_h.func_152559_b() != null) {
            this.buttonList.add(new GuiButton(0, this.width / 2 - 155, this.height - 50, 150, 20, I18n.format("gui.cancel", new Object[0])));
            this.buttonList.add(new GuiButton(1, this.width / 2 - 155 + 160, this.height - 50, 150, 20, I18n.format(this.field_152326_h.func_152559_b().getFormattedText(), new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(0, this.width / 2 - 75, this.height - 50, 150, 20, I18n.format("gui.cancel", new Object[0])));
        }
    }
    
    static final class SwitchReason
    {
        static final /* synthetic */ int[] field_152577_a;
        static final /* synthetic */ int[] field_152579_c;
        static final /* synthetic */ int[] field_152578_b;
        
        static {
            __OBFID = "CL_00001839";
            field_152579_c = new int[IStream.AuthFailureReason.values().length];
            try {
                SwitchReason.field_152579_c[IStream.AuthFailureReason.INVALID_TOKEN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchReason.field_152579_c[IStream.AuthFailureReason.ERROR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            field_152578_b = new int[Util.EnumOS.values().length];
            try {
                SwitchReason.field_152578_b[Util.EnumOS.WINDOWS.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchReason.field_152578_b[Util.EnumOS.OSX.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            field_152577_a = new int[Reason.values().length];
            try {
                SwitchReason.field_152577_a[Reason.ACCOUNT_NOT_BOUND.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchReason.field_152577_a[Reason.FAILED_TWITCH_AUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchReason.field_152577_a[Reason.ACCOUNT_NOT_MIGRATED.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchReason.field_152577_a[Reason.UNSUPPORTED_OS_MAC.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchReason.field_152577_a[Reason.UNKNOWN.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                SwitchReason.field_152577_a[Reason.LIBRARY_FAILURE.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            try {
                SwitchReason.field_152577_a[Reason.INITIALIZATION_FAILURE.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError11) {}
        }
    }
    
    public enum Reason
    {
        UNSUPPORTED_OS_MAC("UNSUPPORTED_OS_MAC", 4, "UNSUPPORTED_OS_MAC", 4, (IChatComponent)new ChatComponentTranslation("stream.unavailable.not_supported.mac", new Object[0]), (IChatComponent)new ChatComponentTranslation("stream.unavailable.not_supported.mac.okay", new Object[0])), 
        FAILED_TWITCH_AUTH("FAILED_TWITCH_AUTH", 8, "FAILED_TWITCH_AUTH", 8, (IChatComponent)new ChatComponentTranslation("stream.unavailable.failed_auth", new Object[0]), (IChatComponent)new ChatComponentTranslation("stream.unavailable.failed_auth.okay", new Object[0])), 
        NO_FBO("NO_FBO", 0, "NO_FBO", 0, (IChatComponent)new ChatComponentTranslation("stream.unavailable.no_fbo", new Object[0])), 
        UNKNOWN("UNKNOWN", 11, "UNKNOWN", 11, (IChatComponent)new ChatComponentTranslation("stream.unavailable.unknown", new Object[0]), (IChatComponent)new ChatComponentTranslation("stream.unavailable.report_to_mojang", new Object[0])), 
        FAILED_TWITCH_AUTH_ERROR("FAILED_TWITCH_AUTH_ERROR", 9, "FAILED_TWITCH_AUTH_ERROR", 9, (IChatComponent)new ChatComponentTranslation("stream.unavailable.failed_auth_error", new Object[0])), 
        ACCOUNT_NOT_BOUND("ACCOUNT_NOT_BOUND", 7, "ACCOUNT_NOT_BOUND", 7, (IChatComponent)new ChatComponentTranslation("stream.unavailable.account_not_bound", new Object[0]), (IChatComponent)new ChatComponentTranslation("stream.unavailable.account_not_bound.okay", new Object[0])), 
        LIBRARY_ARCH_MISMATCH("LIBRARY_ARCH_MISMATCH", 1, "LIBRARY_ARCH_MISMATCH", 1, (IChatComponent)new ChatComponentTranslation("stream.unavailable.library_arch_mismatch", new Object[0])), 
        UNSUPPORTED_OS_OTHER("UNSUPPORTED_OS_OTHER", 5, "UNSUPPORTED_OS_OTHER", 5, (IChatComponent)new ChatComponentTranslation("stream.unavailable.not_supported.other", new Object[0]));
        
        private final /* synthetic */ IChatComponent field_152574_m;
        
        UNSUPPORTED_OS_WINDOWS("UNSUPPORTED_OS_WINDOWS", 3, "UNSUPPORTED_OS_WINDOWS", 3, (IChatComponent)new ChatComponentTranslation("stream.unavailable.not_supported.windows", new Object[0])), 
        ACCOUNT_NOT_MIGRATED("ACCOUNT_NOT_MIGRATED", 6, "ACCOUNT_NOT_MIGRATED", 6, (IChatComponent)new ChatComponentTranslation("stream.unavailable.account_not_migrated", new Object[0]), (IChatComponent)new ChatComponentTranslation("stream.unavailable.account_not_migrated.okay", new Object[0])), 
        INITIALIZATION_FAILURE("INITIALIZATION_FAILURE", 10, "INITIALIZATION_FAILURE", 10, (IChatComponent)new ChatComponentTranslation("stream.unavailable.initialization_failure", new Object[0]), (IChatComponent)new ChatComponentTranslation("stream.unavailable.report_to_mojang", new Object[0])), 
        LIBRARY_FAILURE("LIBRARY_FAILURE", 2, "LIBRARY_FAILURE", 2, (IChatComponent)new ChatComponentTranslation("stream.unavailable.library_failure", new Object[0]), (IChatComponent)new ChatComponentTranslation("stream.unavailable.report_to_mojang", new Object[0]));
        
        private final /* synthetic */ IChatComponent field_152575_n;
        
        private Reason(final String lllIlllIll, final int lllIlllIlI, final String lllIllllll, final int lllIlllIII, final IChatComponent lllIllIlll) {
            this(lllIlllIll, lllIlllIlI, lllIllllll, lllIlllIII, lllIllIlll, null);
        }
        
        public IChatComponent func_152559_b() {
            return this.field_152575_n;
        }
        
        private Reason(final String lllIlIlIll, final int lllIlIlIlI, final String lllIllIIII, final int lllIlIllll, final IChatComponent lllIlIlIIl, final IChatComponent lllIlIlIII) {
            this.field_152574_m = lllIlIlIIl;
            this.field_152575_n = lllIlIlIII;
        }
        
        static {
            __OBFID = "CL_00001838";
        }
        
        public IChatComponent func_152561_a() {
            return this.field_152574_m;
        }
    }
}
