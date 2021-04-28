package shadersmod.client;

import net.minecraft.client.gui.*;
import java.net.*;
import java.io.*;
import org.lwjgl.*;
import net.minecraft.client.*;
import net.minecraft.client.settings.*;
import optifine.*;
import net.minecraft.client.resources.*;
import java.util.*;

public class GuiShaders extends GuiScreen
{
    private static /* synthetic */ float[] HAND_DEPTH_VALUES;
    private static /* synthetic */ String[] QUALITY_MULTIPLIER_NAMES;
    private /* synthetic */ int updateTimer;
    private static /* synthetic */ float[] QUALITY_MULTIPLIERS;
    protected /* synthetic */ String screenTitle;
    private /* synthetic */ GuiSlotShaders shaderList;
    private static /* synthetic */ String[] HAND_DEPTH_NAMES;
    protected /* synthetic */ GuiScreen parentGui;
    
    public static String toStringValue(final float lllllllllllllllIllIIlllllIlIIIll, final float[] lllllllllllllllIllIIlllllIlIIIlI, final String[] lllllllllllllllIllIIlllllIlIIIIl) {
        final int lllllllllllllllIllIIlllllIlIIIII = getValueIndex(lllllllllllllllIllIIlllllIlIIIll, lllllllllllllllIllIIlllllIlIIIlI);
        return lllllllllllllllIllIIlllllIlIIIIl[lllllllllllllllIllIIlllllIlIIIII];
    }
    
    public static int getOSType() {
        final String lllllllllllllllIllIIlllllIIIlIII = System.getProperty("os.name").toLowerCase();
        return lllllllllllllllIllIIlllllIIIlIII.contains("win") ? 1 : (lllllllllllllllIllIIlllllIIIlIII.contains("mac") ? 2 : (lllllllllllllllIllIIlllllIIIlIII.contains("solaris") ? 3 : (lllllllllllllllIllIIlllllIIIlIII.contains("sunos") ? 3 : (lllllllllllllllIllIIlllllIIIlIII.contains("linux") ? 4 : (lllllllllllllllIllIIlllllIIIlIII.contains("unix") ? 4 : 0)))));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIllIIlllllllIIIII) {
        if (lllllllllllllllIllIIlllllllIIIII.enabled) {
            if (lllllllllllllllIllIIlllllllIIIII instanceof GuiButtonEnumShaderOption) {
                final GuiButtonEnumShaderOption lllllllllllllllIllIIllllllllIllI = (GuiButtonEnumShaderOption)lllllllllllllllIllIIlllllllIIIII;
                switch (NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[lllllllllllllllIllIIllllllllIllI.getEnumShaderOption().ordinal()]) {
                    case 1: {
                        Shaders.nextAntialiasingLevel();
                        Shaders.uninit();
                        break;
                    }
                    case 2: {
                        Shaders.configNormalMap = !Shaders.configNormalMap;
                        this.mc.func_175603_A();
                        break;
                    }
                    case 3: {
                        Shaders.configSpecularMap = !Shaders.configSpecularMap;
                        this.mc.func_175603_A();
                        break;
                    }
                    case 4: {
                        final float lllllllllllllllIllIIlllllllIllll = Shaders.configRenderResMul;
                        final float[] lllllllllllllllIllIIlllllllIllII = GuiShaders.QUALITY_MULTIPLIERS;
                        final String[] lllllllllllllllIllIIllllllllIlIl = GuiShaders.QUALITY_MULTIPLIER_NAMES;
                        int lllllllllllllllIllIIllllllllIIlI = getValueIndex(lllllllllllllllIllIIlllllllIllll, lllllllllllllllIllIIlllllllIllII);
                        if (isShiftKeyDown()) {
                            if (--lllllllllllllllIllIIllllllllIIlI < 0) {
                                lllllllllllllllIllIIllllllllIIlI = lllllllllllllllIllIIlllllllIllII.length - 1;
                            }
                        }
                        else if (++lllllllllllllllIllIIllllllllIIlI >= lllllllllllllllIllIIlllllllIllII.length) {
                            lllllllllllllllIllIIllllllllIIlI = 0;
                        }
                        Shaders.configRenderResMul = lllllllllllllllIllIIlllllllIllII[lllllllllllllllIllIIllllllllIIlI];
                        Shaders.scheduleResize();
                        break;
                    }
                    case 5: {
                        final float lllllllllllllllIllIIlllllllIlllI = Shaders.configShadowResMul;
                        final float[] lllllllllllllllIllIIlllllllIlIll = GuiShaders.QUALITY_MULTIPLIERS;
                        final String[] lllllllllllllllIllIIllllllllIlII = GuiShaders.QUALITY_MULTIPLIER_NAMES;
                        int lllllllllllllllIllIIllllllllIIIl = getValueIndex(lllllllllllllllIllIIlllllllIlllI, lllllllllllllllIllIIlllllllIlIll);
                        if (isShiftKeyDown()) {
                            if (--lllllllllllllllIllIIllllllllIIIl < 0) {
                                lllllllllllllllIllIIllllllllIIIl = lllllllllllllllIllIIlllllllIlIll.length - 1;
                            }
                        }
                        else if (++lllllllllllllllIllIIllllllllIIIl >= lllllllllllllllIllIIlllllllIlIll.length) {
                            lllllllllllllllIllIIllllllllIIIl = 0;
                        }
                        Shaders.configShadowResMul = lllllllllllllllIllIIlllllllIlIll[lllllllllllllllIllIIllllllllIIIl];
                        Shaders.scheduleResizeShadow();
                        break;
                    }
                    case 6: {
                        final float lllllllllllllllIllIIlllllllIllIl = Shaders.configHandDepthMul;
                        final float[] lllllllllllllllIllIIlllllllIlIlI = GuiShaders.HAND_DEPTH_VALUES;
                        final String[] lllllllllllllllIllIIllllllllIIll = GuiShaders.HAND_DEPTH_NAMES;
                        int lllllllllllllllIllIIllllllllIIII = getValueIndex(lllllllllllllllIllIIlllllllIllIl, lllllllllllllllIllIIlllllllIlIlI);
                        if (isShiftKeyDown()) {
                            if (--lllllllllllllllIllIIllllllllIIII < 0) {
                                lllllllllllllllIllIIllllllllIIII = lllllllllllllllIllIIlllllllIlIlI.length - 1;
                            }
                        }
                        else if (++lllllllllllllllIllIIllllllllIIII >= lllllllllllllllIllIIlllllllIlIlI.length) {
                            lllllllllllllllIllIIllllllllIIII = 0;
                        }
                        Shaders.configHandDepthMul = lllllllllllllllIllIIlllllllIlIlI[lllllllllllllllIllIIllllllllIIII];
                        break;
                    }
                    case 7: {
                        Shaders.configCloudShadow = !Shaders.configCloudShadow;
                        break;
                    }
                    case 8: {
                        Shaders.configOldLighting.nextValue();
                        Shaders.updateBlockLightLevel();
                        this.mc.func_175603_A();
                        break;
                    }
                    case 9: {
                        Shaders.configTweakBlockDamage = !Shaders.configTweakBlockDamage;
                        break;
                    }
                    case 10: {
                        Shaders.configTexMinFilB = (Shaders.configTexMinFilB + 1) % 3;
                        Shaders.configTexMinFilN = (Shaders.configTexMinFilS = Shaders.configTexMinFilB);
                        lllllllllllllllIllIIlllllllIIIII.displayString = String.valueOf(new StringBuilder("Tex Min: ").append(Shaders.texMinFilDesc[Shaders.configTexMinFilB]));
                        ShadersTex.updateTextureMinMagFilter();
                        break;
                    }
                    case 11: {
                        Shaders.configTexMagFilN = (Shaders.configTexMagFilN + 1) % 2;
                        lllllllllllllllIllIIlllllllIIIII.displayString = String.valueOf(new StringBuilder("Tex_n Mag: ").append(Shaders.texMagFilDesc[Shaders.configTexMagFilN]));
                        ShadersTex.updateTextureMinMagFilter();
                        break;
                    }
                    case 12: {
                        Shaders.configTexMagFilS = (Shaders.configTexMagFilS + 1) % 2;
                        lllllllllllllllIllIIlllllllIIIII.displayString = String.valueOf(new StringBuilder("Tex_s Mag: ").append(Shaders.texMagFilDesc[Shaders.configTexMagFilS]));
                        ShadersTex.updateTextureMinMagFilter();
                        break;
                    }
                    case 13: {
                        Shaders.configShadowClipFrustrum = !Shaders.configShadowClipFrustrum;
                        lllllllllllllllIllIIlllllllIIIII.displayString = String.valueOf(new StringBuilder("ShadowClipFrustrum: ").append(toStringOnOff(Shaders.configShadowClipFrustrum)));
                        ShadersTex.updateTextureMinMagFilter();
                        break;
                    }
                }
                lllllllllllllllIllIIllllllllIllI.updateButtonText();
            }
            else {
                switch (lllllllllllllllIllIIlllllllIIIII.id) {
                    case 201: {
                        switch (getOSType()) {
                            case 1: {
                                final String lllllllllllllllIllIIlllllllIlIIl = String.format("cmd.exe /C start \"Open file\" \"%s\"", Shaders.shaderpacksdir.getAbsolutePath());
                                try {
                                    Runtime.getRuntime().exec(lllllllllllllllIllIIlllllllIlIIl);
                                    return;
                                }
                                catch (IOException lllllllllllllllIllIIlllllllIlIII) {
                                    lllllllllllllllIllIIlllllllIlIII.printStackTrace();
                                    break;
                                }
                            }
                            case 2: {
                                try {
                                    Runtime.getRuntime().exec(new String[] { "/usr/bin/open", Shaders.shaderpacksdir.getAbsolutePath() });
                                    return;
                                }
                                catch (IOException lllllllllllllllIllIIlllllllIIlll) {
                                    lllllllllllllllIllIIlllllllIIlll.printStackTrace();
                                }
                                break;
                            }
                        }
                        boolean lllllllllllllllIllIIlllllllIIllI = false;
                        try {
                            final Class lllllllllllllllIllIIlllllllIIlIl = Class.forName("java.awt.Desktop");
                            final Object lllllllllllllllIllIIlllllllIIlII = lllllllllllllllIllIIlllllllIIlIl.getMethod("getDesktop", (Class[])new Class[0]).invoke(null, new Object[0]);
                            lllllllllllllllIllIIlllllllIIlIl.getMethod("browse", URI.class).invoke(lllllllllllllllIllIIlllllllIIlII, new File(this.mc.mcDataDir, Shaders.shaderpacksdirname).toURI());
                        }
                        catch (Throwable lllllllllllllllIllIIlllllllIIIll) {
                            lllllllllllllllIllIIlllllllIIIll.printStackTrace();
                            lllllllllllllllIllIIlllllllIIllI = true;
                        }
                        if (lllllllllllllllIllIIlllllllIIllI) {
                            Config.dbg("Opening via system class!");
                            Sys.openURL(String.valueOf(new StringBuilder("file://").append(Shaders.shaderpacksdir.getAbsolutePath())));
                            break;
                        }
                        break;
                    }
                    case 202: {
                        new File(Shaders.shadersdir, "current.cfg");
                        try {
                            Shaders.storeConfig();
                        }
                        catch (Exception ex) {}
                        this.mc.displayGuiScreen(this.parentGui);
                        break;
                    }
                    case 203: {
                        final GuiShaderOptions lllllllllllllllIllIIlllllllIIIlI = new GuiShaderOptions(this, Config.getGameSettings());
                        Config.getMinecraft().displayGuiScreen(lllllllllllllllIllIIlllllllIIIlI);
                        break;
                    }
                    default: {
                        this.shaderList.actionPerformed(lllllllllllllllIllIIlllllllIIIII);
                        break;
                    }
                }
            }
        }
    }
    
    public static int getValueIndex(final float lllllllllllllllIllIIlllllIIlIIll, final float[] lllllllllllllllIllIIlllllIIlIIlI) {
        for (int lllllllllllllllIllIIlllllIIlIlIl = 0; lllllllllllllllIllIIlllllIIlIlIl < lllllllllllllllIllIIlllllIIlIIlI.length; ++lllllllllllllllIllIIlllllIIlIlIl) {
            final float lllllllllllllllIllIIlllllIIlIlII = lllllllllllllllIllIIlllllIIlIIlI[lllllllllllllllIllIIlllllIIlIlIl];
            if (lllllllllllllllIllIIlllllIIlIlII >= lllllllllllllllIllIIlllllIIlIIll) {
                return lllllllllllllllIllIIlllllIIlIlIl;
            }
        }
        return lllllllllllllllIllIIlllllIIlIIlI.length - 1;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIllIIllllllIIllIl, final int lllllllllllllllIllIIllllllIlIIlI, final float lllllllllllllllIllIIllllllIlIIIl) {
        this.drawDefaultBackground();
        this.shaderList.drawScreen(lllllllllllllllIllIIllllllIIllIl, lllllllllllllllIllIIllllllIlIIlI, lllllllllllllllIllIIllllllIlIIIl);
        if (this.updateTimer <= 0) {
            this.shaderList.updateList();
            this.updateTimer += 20;
        }
        this.drawCenteredString(this.fontRendererObj, String.valueOf(new StringBuilder(String.valueOf(this.screenTitle)).append(" ")), this.width / 2, 15, 16777215);
        final String lllllllllllllllIllIIllllllIlIIII = String.valueOf(new StringBuilder("OpenGL: ").append(Shaders.glVersionString).append(", ").append(Shaders.glVendorString).append(", ").append(Shaders.glRendererString));
        final int lllllllllllllllIllIIllllllIIllll = this.fontRendererObj.getStringWidth(lllllllllllllllIllIIllllllIlIIII);
        if (lllllllllllllllIllIIllllllIIllll < this.width - 5) {
            this.drawCenteredString(this.fontRendererObj, lllllllllllllllIllIIllllllIlIIII, this.width / 2, this.height - 40, 8421504);
        }
        else {
            this.drawString(this.fontRendererObj, lllllllllllllllIllIIllllllIlIIII, 5, this.height - 40, 8421504);
        }
        super.drawScreen(lllllllllllllllIllIIllllllIIllIl, lllllllllllllllIllIIllllllIlIIlI, lllllllllllllllIllIIllllllIlIIIl);
    }
    
    public Minecraft getMc() {
        return this.mc;
    }
    
    public void drawCenteredString(final String lllllllllllllllIllIIlllllIllIlll, final int lllllllllllllllIllIIlllllIllIllI, final int lllllllllllllllIllIIlllllIllIlIl, final int lllllllllllllllIllIIlllllIlllIIl) {
        this.drawCenteredString(this.fontRendererObj, lllllllllllllllIllIIlllllIllIlll, lllllllllllllllIllIIlllllIllIllI, lllllllllllllllIllIIlllllIllIlIl, lllllllllllllllIllIIlllllIlllIIl);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        --this.updateTimer;
    }
    
    public GuiShaders(final GuiScreen lllllllllllllllIllIlIIIIIIlIlIlI, final GameSettings lllllllllllllllIllIlIIIIIIlIlIIl) {
        this.screenTitle = "Shaders";
        this.updateTimer = -1;
        this.parentGui = lllllllllllllllIllIlIIIIIIlIlIlI;
    }
    
    public static String toStringAa(final int lllllllllllllllIllIIlllllIlIlIII) {
        return (lllllllllllllllIllIIlllllIlIlIII == 2) ? "FXAA 2x" : ((lllllllllllllllIllIIlllllIlIlIII == 4) ? "FXAA 4x" : Lang.getOff());
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.shaderList.func_178039_p();
    }
    
    @Override
    public void initGui() {
        this.screenTitle = I18n.format("of.options.shadersTitle", new Object[0]);
        if (Shaders.shadersConfig == null) {
            Shaders.loadConfig();
        }
        final byte lllllllllllllllIllIlIIIIIIIlllIl = 120;
        final byte lllllllllllllllIllIlIIIIIIIlllII = 20;
        final int lllllllllllllllIllIlIIIIIIIllIll = this.width - lllllllllllllllIllIlIIIIIIIlllIl - 10;
        final byte lllllllllllllllIllIlIIIIIIIllIlI = 30;
        final byte lllllllllllllllIllIlIIIIIIIllIIl = 20;
        final int lllllllllllllllIllIlIIIIIIIllIII = this.width - lllllllllllllllIllIlIIIIIIIlllIl - 20;
        this.shaderList = new GuiSlotShaders(this, lllllllllllllllIllIlIIIIIIIllIII, this.height, lllllllllllllllIllIlIIIIIIIllIlI, this.height - 50, 16);
        this.shaderList.registerScrollButtons(7, 8);
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.ANTIALIASING, lllllllllllllllIllIlIIIIIIIllIll, 0 * lllllllllllllllIllIlIIIIIIIllIIl + lllllllllllllllIllIlIIIIIIIllIlI, lllllllllllllllIllIlIIIIIIIlllIl, lllllllllllllllIllIlIIIIIIIlllII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.NORMAL_MAP, lllllllllllllllIllIlIIIIIIIllIll, 1 * lllllllllllllllIllIlIIIIIIIllIIl + lllllllllllllllIllIlIIIIIIIllIlI, lllllllllllllllIllIlIIIIIIIlllIl, lllllllllllllllIllIlIIIIIIIlllII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.SPECULAR_MAP, lllllllllllllllIllIlIIIIIIIllIll, 2 * lllllllllllllllIllIlIIIIIIIllIIl + lllllllllllllllIllIlIIIIIIIllIlI, lllllllllllllllIllIlIIIIIIIlllIl, lllllllllllllllIllIlIIIIIIIlllII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.RENDER_RES_MUL, lllllllllllllllIllIlIIIIIIIllIll, 3 * lllllllllllllllIllIlIIIIIIIllIIl + lllllllllllllllIllIlIIIIIIIllIlI, lllllllllllllllIllIlIIIIIIIlllIl, lllllllllllllllIllIlIIIIIIIlllII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.SHADOW_RES_MUL, lllllllllllllllIllIlIIIIIIIllIll, 4 * lllllllllllllllIllIlIIIIIIIllIIl + lllllllllllllllIllIlIIIIIIIllIlI, lllllllllllllllIllIlIIIIIIIlllIl, lllllllllllllllIllIlIIIIIIIlllII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.HAND_DEPTH_MUL, lllllllllllllllIllIlIIIIIIIllIll, 5 * lllllllllllllllIllIlIIIIIIIllIIl + lllllllllllllllIllIlIIIIIIIllIlI, lllllllllllllllIllIlIIIIIIIlllIl, lllllllllllllllIllIlIIIIIIIlllII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.OLD_LIGHTING, lllllllllllllllIllIlIIIIIIIllIll, 6 * lllllllllllllllIllIlIIIIIIIllIIl + lllllllllllllllIllIlIIIIIIIllIlI, lllllllllllllllIllIlIIIIIIIlllIl, lllllllllllllllIllIlIIIIIIIlllII));
        final int lllllllllllllllIllIlIIIIIIIlIlll = Math.min(150, lllllllllllllllIllIlIIIIIIIllIII / 2 - 10);
        this.buttonList.add(new GuiButton(201, lllllllllllllllIllIlIIIIIIIllIII / 4 - lllllllllllllllIllIlIIIIIIIlIlll / 2, this.height - 25, lllllllllllllllIllIlIIIIIIIlIlll, lllllllllllllllIllIlIIIIIIIlllII, Lang.get("of.options.shaders.shadersFolder")));
        this.buttonList.add(new GuiButton(202, lllllllllllllllIllIlIIIIIIIllIII / 4 * 3 - lllllllllllllllIllIlIIIIIIIlIlll / 2, this.height - 25, lllllllllllllllIllIlIIIIIIIlIlll, lllllllllllllllIllIlIIIIIIIlllII, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(new GuiButton(203, lllllllllllllllIllIlIIIIIIIllIll, this.height - 25, lllllllllllllllIllIlIIIIIIIlllIl, lllllllllllllllIllIlIIIIIIIlllII, Lang.get("of.options.shaders.shaderOptions")));
        this.updateButtons();
    }
    
    public static String toStringQuality(final float lllllllllllllllIllIIlllllIIIlllI) {
        return toStringValue(lllllllllllllllIllIIlllllIIIlllI, GuiShaders.QUALITY_MULTIPLIERS, GuiShaders.QUALITY_MULTIPLIER_NAMES);
    }
    
    public static String toStringOnOff(final boolean lllllllllllllllIllIIlllllIllIIII) {
        final String lllllllllllllllIllIIlllllIlIllll = Lang.getOn();
        final String lllllllllllllllIllIIlllllIlIlllI = Lang.getOff();
        return lllllllllllllllIllIIlllllIllIIII ? lllllllllllllllIllIIlllllIlIllll : lllllllllllllllIllIIlllllIlIlllI;
    }
    
    public static String toStringHandDepth(final float lllllllllllllllIllIIlllllIIIlIlI) {
        return toStringValue(lllllllllllllllIllIIlllllIIIlIlI, GuiShaders.HAND_DEPTH_VALUES, GuiShaders.HAND_DEPTH_NAMES);
    }
    
    public void updateButtons() {
        final boolean lllllllllllllllIllIlIIIIIIIIlIIl = Config.isShaders();
        for (final GuiButton lllllllllllllllIllIlIIIIIIIIIlll : this.buttonList) {
            if (lllllllllllllllIllIlIIIIIIIIIlll.id != 201 && lllllllllllllllIllIlIIIIIIIIIlll.id != 202 && lllllllllllllllIllIlIIIIIIIIIlll.id != EnumShaderOption.ANTIALIASING.ordinal()) {
                lllllllllllllllIllIlIIIIIIIIIlll.enabled = lllllllllllllllIllIlIIIIIIIIlIIl;
            }
        }
    }
    
    static {
        EnumOS_WINDOWS = 1;
        EnumOS_OSX = 2;
        EnumOS_UNKNOWN = 0;
        EnumOS_SOLARIS = 3;
        EnumOS_LINUX = 4;
        GuiShaders.QUALITY_MULTIPLIERS = new float[] { 0.5f, 0.70710677f, 1.0f, 1.4142135f, 2.0f };
        GuiShaders.QUALITY_MULTIPLIER_NAMES = new String[] { "0.5x", "0.7x", "1x", "1.5x", "2x" };
        GuiShaders.HAND_DEPTH_VALUES = new float[] { 0.0625f, 0.125f, 0.25f };
        GuiShaders.HAND_DEPTH_NAMES = new String[] { "0.5x", "1x", "2x" };
    }
    
    static class NamelessClass1647571870
    {
        static final /* synthetic */ int[] $SwitchMap$shadersmod$client$EnumShaderOption;
        
        static {
            $SwitchMap$shadersmod$client$EnumShaderOption = new int[EnumShaderOption.values().length];
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.ANTIALIASING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.NORMAL_MAP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.SPECULAR_MAP.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.RENDER_RES_MUL.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.SHADOW_RES_MUL.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.HAND_DEPTH_MUL.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.CLOUD_SHADOW.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.OLD_LIGHTING.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TWEAK_BLOCK_DAMAGE.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TEX_MIN_FIL_B.ordinal()] = 10;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TEX_MAG_FIL_N.ordinal()] = 11;
            }
            catch (NoSuchFieldError noSuchFieldError11) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TEX_MAG_FIL_S.ordinal()] = 12;
            }
            catch (NoSuchFieldError noSuchFieldError12) {}
            try {
                NamelessClass1647571870.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.SHADOW_CLIP_FRUSTRUM.ordinal()] = 13;
            }
            catch (NoSuchFieldError noSuchFieldError13) {}
        }
    }
}
