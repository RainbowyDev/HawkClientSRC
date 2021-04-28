package shadersmod.client;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import java.io.*;
import optifine.*;
import java.util.*;
import net.minecraft.client.gui.*;

public class GuiShaderOptions extends GuiScreen
{
    private /* synthetic */ int lastMouseY;
    private /* synthetic */ int lastMouseX;
    private /* synthetic */ String screenName;
    private /* synthetic */ GuiScreen prevScreen;
    private /* synthetic */ boolean changed;
    private /* synthetic */ long mouseStillTime;
    private /* synthetic */ String screenText;
    private /* synthetic */ GameSettings settings;
    protected /* synthetic */ String title;
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.shaderOptionsTitle", new Object[0]);
        final byte llllllllllllllIIllIlllIIllllIIII = 100;
        final boolean llllllllllllllIIllIlllIIlllIllll = false;
        final byte llllllllllllllIIllIlllIIlllIlllI = 30;
        final byte llllllllllllllIIllIlllIIlllIllIl = 20;
        final int llllllllllllllIIllIlllIIlllIllII = this.width - 130;
        final byte llllllllllllllIIllIlllIIlllIlIll = 120;
        final byte llllllllllllllIIllIlllIIlllIlIlI = 20;
        int llllllllllllllIIllIlllIIlllIlIIl = 2;
        final ShaderOption[] llllllllllllllIIllIlllIIlllIlIII = Shaders.getShaderPackOptions(this.screenName);
        if (llllllllllllllIIllIlllIIlllIlIII != null) {
            if (llllllllllllllIIllIlllIIlllIlIII.length > 18) {
                llllllllllllllIIllIlllIIlllIlIIl = llllllllllllllIIllIlllIIlllIlIII.length / 9 + 1;
            }
            for (int llllllllllllllIIllIlllIIlllIIlll = 0; llllllllllllllIIllIlllIIlllIIlll < llllllllllllllIIllIlllIIlllIlIII.length; ++llllllllllllllIIllIlllIIlllIIlll) {
                final ShaderOption llllllllllllllIIllIlllIIlllIIllI = llllllllllllllIIllIlllIIlllIlIII[llllllllllllllIIllIlllIIlllIIlll];
                if (llllllllllllllIIllIlllIIlllIIllI != null && llllllllllllllIIllIlllIIlllIIllI.isVisible()) {
                    final int llllllllllllllIIllIlllIIlllIIlIl = llllllllllllllIIllIlllIIlllIIlll % llllllllllllllIIllIlllIIlllIlIIl;
                    final int llllllllllllllIIllIlllIIlllIIlII = llllllllllllllIIllIlllIIlllIIlll / llllllllllllllIIllIlllIIlllIlIIl;
                    final int llllllllllllllIIllIlllIIlllIIIll = Math.min(this.width / llllllllllllllIIllIlllIIlllIlIIl, 200);
                    final int llllllllllllllIIllIlllIIlllIIIlI = (this.width - llllllllllllllIIllIlllIIlllIIIll * llllllllllllllIIllIlllIIlllIlIIl) / 2;
                    final int llllllllllllllIIllIlllIIlllIIIIl = llllllllllllllIIllIlllIIlllIIlIl * llllllllllllllIIllIlllIIlllIIIll + 5 + llllllllllllllIIllIlllIIlllIIIlI;
                    final int llllllllllllllIIllIlllIIlllIIIII = llllllllllllllIIllIlllIIlllIlllI + llllllllllllllIIllIlllIIlllIIlII * llllllllllllllIIllIlllIIlllIllIl;
                    final int llllllllllllllIIllIlllIIllIlllll = llllllllllllllIIllIlllIIlllIIIll - 10;
                    final String llllllllllllllIIllIlllIIllIllllI = this.getButtonText(llllllllllllllIIllIlllIIlllIIllI, llllllllllllllIIllIlllIIllIlllll);
                    final GuiButtonShaderOption llllllllllllllIIllIlllIIllIlllIl = new GuiButtonShaderOption(llllllllllllllIIllIlllIIllllIIII + llllllllllllllIIllIlllIIlllIIlll, llllllllllllllIIllIlllIIlllIIIIl, llllllllllllllIIllIlllIIlllIIIII, llllllllllllllIIllIlllIIllIlllll, llllllllllllllIIllIlllIIlllIlIlI, llllllllllllllIIllIlllIIlllIIllI, llllllllllllllIIllIlllIIllIllllI);
                    llllllllllllllIIllIlllIIllIlllIl.enabled = llllllllllllllIIllIlllIIlllIIllI.isEnabled();
                    this.buttonList.add(llllllllllllllIIllIlllIIllIlllIl);
                }
            }
        }
        this.buttonList.add(new GuiButton(201, this.width / 2 - llllllllllllllIIllIlllIIlllIlIll - 20, this.height / 6 + 168 + 11, llllllllllllllIIllIlllIIlllIlIll, llllllllllllllIIllIlllIIlllIlIlI, I18n.format("controls.reset", new Object[0])));
        this.buttonList.add(new GuiButton(200, this.width / 2 + 20, this.height / 6 + 168 + 11, llllllllllllllIIllIlllIIlllIlIll, llllllllllllllIIllIlllIIlllIlIlI, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIllIlllIIIllIllIl, final int llllllllllllllIIllIlllIIIlllIIII, final float llllllllllllllIIllIlllIIIllIlIll) {
        this.drawDefaultBackground();
        if (this.screenText != null) {
            this.drawCenteredString(this.fontRendererObj, this.screenText, this.width / 2, 15, 16777215);
        }
        else {
            this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        }
        super.drawScreen(llllllllllllllIIllIlllIIIllIllIl, llllllllllllllIIllIlllIIIlllIIII, llllllllllllllIIllIlllIIIllIlIll);
        if (Math.abs(llllllllllllllIIllIlllIIIllIllIl - this.lastMouseX) <= 5 && Math.abs(llllllllllllllIIllIlllIIIlllIIII - this.lastMouseY) <= 5) {
            this.drawTooltips(llllllllllllllIIllIlllIIIllIllIl, llllllllllllllIIllIlllIIIlllIIII, this.buttonList);
        }
        else {
            this.lastMouseX = llllllllllllllIIllIlllIIIllIllIl;
            this.lastMouseY = llllllllllllllIIllIlllIIIlllIIII;
            this.mouseStillTime = System.currentTimeMillis();
        }
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIIllIlllIIlIIlIlIl, final int llllllllllllllIIllIlllIIlIIlIlII, final int llllllllllllllIIllIlllIIlIIIllII) throws IOException {
        super.mouseClicked(llllllllllllllIIllIlllIIlIIlIlIl, llllllllllllllIIllIlllIIlIIlIlII, llllllllllllllIIllIlllIIlIIIllII);
        if (llllllllllllllIIllIlllIIlIIIllII == 1) {
            final GuiButton llllllllllllllIIllIlllIIlIIlIIlI = this.getSelectedButton(llllllllllllllIIllIlllIIlIIlIlIl, llllllllllllllIIllIlllIIlIIlIlII);
            if (llllllllllllllIIllIlllIIlIIlIIlI instanceof GuiButtonShaderOption) {
                final GuiButtonShaderOption llllllllllllllIIllIlllIIlIIlIIIl = (GuiButtonShaderOption)llllllllllllllIIllIlllIIlIIlIIlI;
                final ShaderOption llllllllllllllIIllIlllIIlIIlIIII = llllllllllllllIIllIlllIIlIIlIIIl.getShaderOption();
                if (llllllllllllllIIllIlllIIlIIlIIII.isChanged()) {
                    llllllllllllllIIllIlllIIlIIlIIIl.playPressSound(this.mc.getSoundHandler());
                    llllllllllllllIIllIlllIIlIIlIIII.resetValue();
                    this.changed = true;
                    this.updateAllButtons();
                }
            }
        }
    }
    
    private String[] makeTooltipLines(final int llllllllllllllIIllIlllIIIIIIIllI, final List<String> llllllllllllllIIllIlllIIIIIIIlIl) {
        final FontRenderer llllllllllllllIIllIlllIIIIIIIlII = Config.getMinecraft().fontRendererObj;
        final ArrayList llllllllllllllIIllIlllIIIIIIIIll = new ArrayList();
        for (int llllllllllllllIIllIlllIIIIIIIIlI = 0; llllllllllllllIIllIlllIIIIIIIIlI < llllllllllllllIIllIlllIIIIIIIlIl.size(); ++llllllllllllllIIllIlllIIIIIIIIlI) {
            final String llllllllllllllIIllIlllIIIIIIIIIl = llllllllllllllIIllIlllIIIIIIIlIl.get(llllllllllllllIIllIlllIIIIIIIIlI);
            if (llllllllllllllIIllIlllIIIIIIIIIl != null && llllllllllllllIIllIlllIIIIIIIIIl.length() > 0) {
                final List llllllllllllllIIllIlllIIIIIIIIII = llllllllllllllIIllIlllIIIIIIIlII.listFormattedStringToWidth(llllllllllllllIIllIlllIIIIIIIIIl, llllllllllllllIIllIlllIIIIIIIllI);
                for (final String llllllllllllllIIllIllIlllllllllI : llllllllllllllIIllIlllIIIIIIIIII) {
                    llllllllllllllIIllIlllIIIIIIIIll.add(llllllllllllllIIllIllIlllllllllI);
                }
            }
        }
        final String[] llllllllllllllIIllIllIllllllllIl = llllllllllllllIIllIlllIIIIIIIIll.toArray(new String[llllllllllllllIIllIlllIIIIIIIIll.size()]);
        return llllllllllllllIIllIllIllllllllIl;
    }
    
    public GuiShaderOptions(final GuiScreen llllllllllllllIIllIlllIlIIIlIlll, final GameSettings llllllllllllllIIllIlllIlIIIlIIll) {
        this.lastMouseX = 0;
        this.lastMouseY = 0;
        this.mouseStillTime = 0L;
        this.screenName = null;
        this.screenText = null;
        this.changed = false;
        this.title = "Shader Options";
        this.prevScreen = llllllllllllllIIllIlllIlIIIlIlll;
        this.settings = llllllllllllllIIllIlllIlIIIlIIll;
    }
    
    private void updateAllButtons() {
        for (final GuiButton llllllllllllllIIllIlllIIlIIIIIII : this.buttonList) {
            if (llllllllllllllIIllIlllIIlIIIIIII instanceof GuiButtonShaderOption) {
                final GuiButtonShaderOption llllllllllllllIIllIlllIIIlllllll = (GuiButtonShaderOption)llllllllllllllIIllIlllIIlIIIIIII;
                final ShaderOption llllllllllllllIIllIlllIIIllllllI = llllllllllllllIIllIlllIIIlllllll.getShaderOption();
                if (llllllllllllllIIllIlllIIIllllllI instanceof ShaderOptionProfile) {
                    final ShaderOptionProfile llllllllllllllIIllIlllIIIlllllIl = (ShaderOptionProfile)llllllllllllllIIllIlllIIIllllllI;
                    llllllllllllllIIllIlllIIIlllllIl.updateProfile();
                }
                llllllllllllllIIllIlllIIIlllllll.displayString = this.getButtonText(llllllllllllllIIllIlllIIIllllllI, llllllllllllllIIllIlllIIIlllllll.getButtonWidth());
            }
        }
    }
    
    private String getButtonText(final ShaderOption llllllllllllllIIllIlllIIlIlllIII, final int llllllllllllllIIllIlllIIlIllllll) {
        String llllllllllllllIIllIlllIIlIlllllI = llllllllllllllIIllIlllIIlIlllIII.getNameText();
        if (llllllllllllllIIllIlllIIlIlllIII instanceof ShaderOptionScreen) {
            final ShaderOptionScreen llllllllllllllIIllIlllIIlIllllIl = (ShaderOptionScreen)llllllllllllllIIllIlllIIlIlllIII;
            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIlllIIlIlllllI)).append("..."));
        }
        final FontRenderer llllllllllllllIIllIlllIIlIllllII = Config.getMinecraft().fontRendererObj;
        for (int llllllllllllllIIllIlllIIlIlllIll = llllllllllllllIIllIlllIIlIllllII.getStringWidth(String.valueOf(new StringBuilder(": ").append(Lang.getOff()))) + 5; llllllllllllllIIllIlllIIlIllllII.getStringWidth(llllllllllllllIIllIlllIIlIlllllI) + llllllllllllllIIllIlllIIlIlllIll >= llllllllllllllIIllIlllIIlIllllll && llllllllllllllIIllIlllIIlIlllllI.length() > 0; llllllllllllllIIllIlllIIlIlllllI = llllllllllllllIIllIlllIIlIlllllI.substring(0, llllllllllllllIIllIlllIIlIlllllI.length() - 1)) {}
        final String llllllllllllllIIllIlllIIlIlllIlI = llllllllllllllIIllIlllIIlIlllIII.isChanged() ? llllllllllllllIIllIlllIIlIlllIII.getValueColor(llllllllllllllIIllIlllIIlIlllIII.getValue()) : "";
        final String llllllllllllllIIllIlllIIlIlllIIl = llllllllllllllIIllIlllIIlIlllIII.getValueText(llllllllllllllIIllIlllIIlIlllIII.getValue());
        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIlllIIlIlllllI)).append(": ").append(llllllllllllllIIllIlllIIlIlllIlI).append(llllllllllllllIIllIlllIIlIlllIIl));
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIllIlllIIlIlIIIlI) {
        if (llllllllllllllIIllIlllIIlIlIIIlI.enabled) {
            if (llllllllllllllIIllIlllIIlIlIIIlI.id < 200 && llllllllllllllIIllIlllIIlIlIIIlI instanceof GuiButtonShaderOption) {
                final GuiButtonShaderOption llllllllllllllIIllIlllIIlIlIlIlI = (GuiButtonShaderOption)llllllllllllllIIllIlllIIlIlIIIlI;
                final ShaderOption llllllllllllllIIllIlllIIlIlIlIIl = llllllllllllllIIllIlllIIlIlIlIlI.getShaderOption();
                if (llllllllllllllIIllIlllIIlIlIlIIl instanceof ShaderOptionScreen) {
                    final String llllllllllllllIIllIlllIIlIlIlIII = llllllllllllllIIllIlllIIlIlIlIIl.getName();
                    final GuiShaderOptions llllllllllllllIIllIlllIIlIlIIlll = new GuiShaderOptions(this, this.settings, llllllllllllllIIllIlllIIlIlIlIII);
                    this.mc.displayGuiScreen(llllllllllllllIIllIlllIIlIlIIlll);
                    return;
                }
                llllllllllllllIIllIlllIIlIlIlIIl.nextValue();
                this.updateAllButtons();
                this.changed = true;
            }
            if (llllllllllllllIIllIlllIIlIlIIIlI.id == 201) {
                final ShaderOption[] llllllllllllllIIllIlllIIlIlIIllI = Shaders.getChangedOptions(Shaders.getShaderPackOptions());
                for (int llllllllllllllIIllIlllIIlIlIIlIl = 0; llllllllllllllIIllIlllIIlIlIIlIl < llllllllllllllIIllIlllIIlIlIIllI.length; ++llllllllllllllIIllIlllIIlIlIIlIl) {
                    final ShaderOption llllllllllllllIIllIlllIIlIlIIlII = llllllllllllllIIllIlllIIlIlIIllI[llllllllllllllIIllIlllIIlIlIIlIl];
                    llllllllllllllIIllIlllIIlIlIIlII.resetValue();
                    this.changed = true;
                }
                this.updateAllButtons();
            }
            if (llllllllllllllIIllIlllIIlIlIIIlI.id == 200) {
                if (this.changed) {
                    Shaders.saveShaderPackOptions();
                    Shaders.uninit();
                }
                this.mc.displayGuiScreen(this.prevScreen);
            }
        }
    }
    
    private void drawTooltips(final int llllllllllllllIIllIlllIIIlIllIlI, final int llllllllllllllIIllIlllIIIlIllIIl, final List llllllllllllllIIllIlllIIIlIllIII) {
        final short llllllllllllllIIllIlllIIIlIlIlll = 700;
        if (System.currentTimeMillis() >= this.mouseStillTime + llllllllllllllIIllIlllIIIlIlIlll) {
            final int llllllllllllllIIllIlllIIIlIlIllI = this.width / 2 - 150;
            int llllllllllllllIIllIlllIIIlIlIlIl = this.height / 6 - 7;
            if (llllllllllllllIIllIlllIIIlIllIIl <= llllllllllllllIIllIlllIIIlIlIlIl + 98) {
                llllllllllllllIIllIlllIIIlIlIlIl += 105;
            }
            final int llllllllllllllIIllIlllIIIlIlIlII = llllllllllllllIIllIlllIIIlIlIllI + 150 + 150;
            final int llllllllllllllIIllIlllIIIlIlIIll = llllllllllllllIIllIlllIIIlIlIlIl + 84 + 10;
            final GuiButton llllllllllllllIIllIlllIIIlIlIIlI = this.getSelectedButton(llllllllllllllIIllIlllIIIlIllIlI, llllllllllllllIIllIlllIIIlIllIIl);
            if (llllllllllllllIIllIlllIIIlIlIIlI instanceof GuiButtonShaderOption) {
                final GuiButtonShaderOption llllllllllllllIIllIlllIIIlIlIIIl = (GuiButtonShaderOption)llllllllllllllIIllIlllIIIlIlIIlI;
                final ShaderOption llllllllllllllIIllIlllIIIlIlIIII = llllllllllllllIIllIlllIIIlIlIIIl.getShaderOption();
                final String[] llllllllllllllIIllIlllIIIlIIllll = this.makeTooltipLines(llllllllllllllIIllIlllIIIlIlIIII, llllllllllllllIIllIlllIIIlIlIlII - llllllllllllllIIllIlllIIIlIlIllI);
                if (llllllllllllllIIllIlllIIIlIIllll == null) {
                    return;
                }
                this.drawGradientRect(llllllllllllllIIllIlllIIIlIlIllI, llllllllllllllIIllIlllIIIlIlIlIl, llllllllllllllIIllIlllIIIlIlIlII, llllllllllllllIIllIlllIIIlIlIIll, -536870912, -536870912);
                for (int llllllllllllllIIllIlllIIIlIIlllI = 0; llllllllllllllIIllIlllIIIlIIlllI < llllllllllllllIIllIlllIIIlIIllll.length; ++llllllllllllllIIllIlllIIIlIIlllI) {
                    final String llllllllllllllIIllIlllIIIlIIllIl = llllllllllllllIIllIlllIIIlIIllll[llllllllllllllIIllIlllIIIlIIlllI];
                    int llllllllllllllIIllIlllIIIlIIllII = 14540253;
                    if (llllllllllllllIIllIlllIIIlIIllIl.endsWith("!")) {
                        llllllllllllllIIllIlllIIIlIIllII = 16719904;
                    }
                    this.fontRendererObj.drawStringWithShadow(llllllllllllllIIllIlllIIIlIIllIl, (float)(llllllllllllllIIllIlllIIIlIlIllI + 5), (float)(llllllllllllllIIllIlllIIIlIlIlIl + 5 + llllllllllllllIIllIlllIIIlIIlllI * 11), llllllllllllllIIllIlllIIIlIIllII);
                }
            }
        }
    }
    
    static {
        OPTION_REST = "*";
        OPTION_EMPTY = "<empty>";
        OPTION_PROFILE = "<profile>";
    }
    
    private String[] splitDescription(String llllllllllllllIIllIlllIIIIIlIIll) {
        if (llllllllllllllIIllIlllIIIIIlIIll.length() <= 0) {
            return new String[0];
        }
        llllllllllllllIIllIlllIIIIIlIIll = StrUtils.removePrefix(llllllllllllllIIllIlllIIIIIlIIll, "//");
        final String[] llllllllllllllIIllIlllIIIIIlIlIl = llllllllllllllIIllIlllIIIIIlIIll.split("\\. ");
        for (int llllllllllllllIIllIlllIIIIIlIlII = 0; llllllllllllllIIllIlllIIIIIlIlII < llllllllllllllIIllIlllIIIIIlIlIl.length; ++llllllllllllllIIllIlllIIIIIlIlII) {
            llllllllllllllIIllIlllIIIIIlIlIl[llllllllllllllIIllIlllIIIIIlIlII] = String.valueOf(new StringBuilder("- ").append(llllllllllllllIIllIlllIIIIIlIlIl[llllllllllllllIIllIlllIIIIIlIlII].trim()));
            llllllllllllllIIllIlllIIIIIlIlIl[llllllllllllllIIllIlllIIIIIlIlII] = StrUtils.removeSuffix(llllllllllllllIIllIlllIIIIIlIlIl[llllllllllllllIIllIlllIIIIIlIlII], ".");
        }
        return llllllllllllllIIllIlllIIIIIlIlIl;
    }
    
    public GuiShaderOptions(final GuiScreen llllllllllllllIIllIlllIlIIIIlIIl, final GameSettings llllllllllllllIIllIlllIlIIIIlIII, final String llllllllllllllIIllIlllIlIIIIIlll) {
        this(llllllllllllllIIllIlllIlIIIIlIIl, llllllllllllllIIllIlllIlIIIIlIII);
        this.screenName = llllllllllllllIIllIlllIlIIIIIlll;
        if (llllllllllllllIIllIlllIlIIIIIlll != null) {
            this.screenText = Shaders.translate(String.valueOf(new StringBuilder("screen.").append(llllllllllllllIIllIlllIlIIIIIlll)), llllllllllllllIIllIlllIlIIIIIlll);
        }
    }
    
    private String[] makeTooltipLines(final ShaderOption llllllllllllllIIllIlllIIIIllIIII, final int llllllllllllllIIllIlllIIIIlIIIll) {
        if (llllllllllllllIIllIlllIIIIllIIII instanceof ShaderOptionProfile) {
            return null;
        }
        final String llllllllllllllIIllIlllIIIIlIlllI = llllllllllllllIIllIlllIIIIllIIII.getNameText();
        final String llllllllllllllIIllIlllIIIIlIllIl = Config.normalize(llllllllllllllIIllIlllIIIIllIIII.getDescriptionText()).trim();
        final String[] llllllllllllllIIllIlllIIIIlIllII = this.splitDescription(llllllllllllllIIllIlllIIIIlIllIl);
        String llllllllllllllIIllIlllIIIIlIlIll = null;
        if (!llllllllllllllIIllIlllIIIIlIlllI.equals(llllllllllllllIIllIlllIIIIllIIII.getName())) {
            llllllllllllllIIllIlllIIIIlIlIll = String.valueOf(new StringBuilder(String.valueOf(Lang.get("of.general.id"))).append(": ").append(llllllllllllllIIllIlllIIIIllIIII.getName()));
        }
        String llllllllllllllIIllIlllIIIIlIlIlI = null;
        if (llllllllllllllIIllIlllIIIIllIIII.getPaths() != null) {
            llllllllllllllIIllIlllIIIIlIlIlI = String.valueOf(new StringBuilder(String.valueOf(Lang.get("of.general.from"))).append(": ").append(Config.arrayToString(llllllllllllllIIllIlllIIIIllIIII.getPaths())));
        }
        String llllllllllllllIIllIlllIIIIlIlIIl = null;
        if (llllllllllllllIIllIlllIIIIllIIII.getValueDefault() != null) {
            final String llllllllllllllIIllIlllIIIIlIlIII = llllllllllllllIIllIlllIIIIllIIII.isEnabled() ? llllllllllllllIIllIlllIIIIllIIII.getValueText(llllllllllllllIIllIlllIIIIllIIII.getValueDefault()) : Lang.get("of.general.ambiguous");
            llllllllllllllIIllIlllIIIIlIlIIl = String.valueOf(new StringBuilder(String.valueOf(Lang.getDefault())).append(": ").append(llllllllllllllIIllIlllIIIIlIlIII));
        }
        final ArrayList llllllllllllllIIllIlllIIIIlIIlll = new ArrayList();
        llllllllllllllIIllIlllIIIIlIIlll.add(llllllllllllllIIllIlllIIIIlIlllI);
        llllllllllllllIIllIlllIIIIlIIlll.addAll(Arrays.asList(llllllllllllllIIllIlllIIIIlIllII));
        if (llllllllllllllIIllIlllIIIIlIlIll != null) {
            llllllllllllllIIllIlllIIIIlIIlll.add(llllllllllllllIIllIlllIIIIlIlIll);
        }
        if (llllllllllllllIIllIlllIIIIlIlIlI != null) {
            llllllllllllllIIllIlllIIIIlIIlll.add(llllllllllllllIIllIlllIIIIlIlIlI);
        }
        if (llllllllllllllIIllIlllIIIIlIlIIl != null) {
            llllllllllllllIIllIlllIIIIlIIlll.add(llllllllllllllIIllIlllIIIIlIlIIl);
        }
        final String[] llllllllllllllIIllIlllIIIIlIIllI = this.makeTooltipLines(llllllllllllllIIllIlllIIIIlIIIll, llllllllllllllIIllIlllIIIIlIIlll);
        return llllllllllllllIIllIlllIIIIlIIllI;
    }
    
    private GuiButton getSelectedButton(final int llllllllllllllIIllIllIlllllIIlII, final int llllllllllllllIIllIllIlllllIlIlI) {
        for (int llllllllllllllIIllIllIlllllIlIIl = 0; llllllllllllllIIllIllIlllllIlIIl < this.buttonList.size(); ++llllllllllllllIIllIllIlllllIlIIl) {
            final GuiButton llllllllllllllIIllIllIlllllIlIII = this.buttonList.get(llllllllllllllIIllIllIlllllIlIIl);
            final int llllllllllllllIIllIllIlllllIIlll = GuiVideoSettings.getButtonWidth(llllllllllllllIIllIllIlllllIlIII);
            final int llllllllllllllIIllIllIlllllIIllI = GuiVideoSettings.getButtonHeight(llllllllllllllIIllIllIlllllIlIII);
            if (llllllllllllllIIllIllIlllllIIlII >= llllllllllllllIIllIllIlllllIlIII.xPosition && llllllllllllllIIllIllIlllllIlIlI >= llllllllllllllIIllIllIlllllIlIII.yPosition && llllllllllllllIIllIllIlllllIIlII < llllllllllllllIIllIllIlllllIlIII.xPosition + llllllllllllllIIllIllIlllllIIlll && llllllllllllllIIllIllIlllllIlIlI < llllllllllllllIIllIllIlllllIlIII.yPosition + llllllllllllllIIllIllIlllllIIllI) {
                return llllllllllllllIIllIllIlllllIlIII;
            }
        }
        return null;
    }
}
