package net.minecraft.client.gui;

import net.minecraft.client.renderer.texture.*;
import java.util.concurrent.atomic.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import java.util.*;
import java.io.*;
import net.minecraft.client.*;
import org.lwjgl.util.glu.*;
import java.net.*;
import net.minecraft.world.demo.*;
import alts.*;
import hawk.access.*;
import net.minecraft.world.storage.*;
import net.minecraft.realms.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;

public class GuiMainMenu extends GuiScreen implements GuiYesNoCallback
{
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ int field_92024_r;
    private /* synthetic */ int field_92023_s;
    private static final /* synthetic */ ResourceLocation[] titlePanoramaPaths;
    private /* synthetic */ int field_92019_w;
    private static final /* synthetic */ ResourceLocation minecraftTitleTextures;
    private /* synthetic */ float updateCounter;
    private /* synthetic */ ResourceLocation field_110351_G;
    private /* synthetic */ GuiButton buttonResetDemo;
    private /* synthetic */ DynamicTexture viewportTexture;
    private /* synthetic */ String splashText;
    private /* synthetic */ String field_146972_A;
    private /* synthetic */ int field_92022_t;
    private /* synthetic */ String field_104024_v;
    private /* synthetic */ int field_92021_u;
    private /* synthetic */ String field_92025_p;
    private final /* synthetic */ Object field_104025_t;
    private /* synthetic */ GuiButton field_175372_K;
    private /* synthetic */ int panoramaTimer;
    private /* synthetic */ int field_92020_v;
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    private void renderSkybox(final int lllIIIIllll, final int lllIIIIlllI, final float lllIIIllIII) {
        this.mc.getFramebuffer().unbindFramebuffer();
        GlStateManager.viewport(0, 0, 256, 256);
        this.drawPanorama(lllIIIIllll, lllIIIIlllI, lllIIIllIII);
        this.rotateAndBlurSkybox(lllIIIllIII);
        this.rotateAndBlurSkybox(lllIIIllIII);
        this.rotateAndBlurSkybox(lllIIIllIII);
        this.rotateAndBlurSkybox(lllIIIllIII);
        this.rotateAndBlurSkybox(lllIIIllIII);
        this.rotateAndBlurSkybox(lllIIIllIII);
        this.rotateAndBlurSkybox(lllIIIllIII);
        this.mc.getFramebuffer().bindFramebuffer(true);
        GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        final Tessellator lllIIIlIlll = Tessellator.getInstance();
        final WorldRenderer lllIIIlIllI = lllIIIlIlll.getWorldRenderer();
        lllIIIlIllI.startDrawingQuads();
        final float lllIIIlIlIl = (this.width > this.height) ? (120.0f / this.width) : (120.0f / this.height);
        final float lllIIIlIlII = this.height * lllIIIlIlIl / 256.0f;
        final float lllIIIlIIll = this.width * lllIIIlIlIl / 256.0f;
        lllIIIlIllI.func_178960_a(1.0f, 1.0f, 1.0f, 1.0f);
        final int lllIIIlIIlI = this.width;
        final int lllIIIlIIIl = this.height;
        lllIIIlIllI.addVertexWithUV(0.0, lllIIIlIIIl, this.zLevel, 0.5f - lllIIIlIlII, 0.5f + lllIIIlIIll);
        lllIIIlIllI.addVertexWithUV(lllIIIlIIlI, lllIIIlIIIl, this.zLevel, 0.5f - lllIIIlIlII, 0.5f - lllIIIlIIll);
        lllIIIlIllI.addVertexWithUV(lllIIIlIIlI, 0.0, this.zLevel, 0.5f + lllIIIlIlII, 0.5f - lllIIIlIIll);
        lllIIIlIllI.addVertexWithUV(0.0, 0.0, this.zLevel, 0.5f + lllIIIlIlII, 0.5f + lllIIIlIIll);
        lllIIIlIlll.draw();
    }
    
    public GuiMainMenu() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   net/minecraft/client/gui/GuiScreen.<init>:()V
        //     4: aload_0         /* lllllIIIIIl */
        //     5: iconst_1       
        //     6: putfield        net/minecraft/client/gui/GuiMainMenu.field_175375_v:Z
        //     9: aload_0         /* lllllIIIIIl */
        //    10: new             Ljava/lang/Object;
        //    13: dup            
        //    14: invokespecial   java/lang/Object.<init>:()V
        //    17: putfield        net/minecraft/client/gui/GuiMainMenu.field_104025_t:Ljava/lang/Object;
        //    20: aload_0         /* lllllIIIIIl */
        //    21: getstatic       net/minecraft/client/gui/GuiMainMenu.field_96138_a:Ljava/lang/String;
        //    24: putfield        net/minecraft/client/gui/GuiMainMenu.field_146972_A:Ljava/lang/String;
        //    27: aload_0         /* lllllIIIIIl */
        //    28: ldc             "missingno"
        //    30: putfield        net/minecraft/client/gui/GuiMainMenu.splashText:Ljava/lang/String;
        //    33: aconst_null    
        //    34: astore_1        /* lllllIIIIII */
        //    35: invokestatic    com/google/common/collect/Lists.newArrayList:()Ljava/util/ArrayList;
        //    38: astore_2        /* lllllIIIlII */
        //    39: new             Ljava/io/BufferedReader;
        //    42: dup            
        //    43: new             Ljava/io/InputStreamReader;
        //    46: dup            
        //    47: invokestatic    net/minecraft/client/Minecraft.getMinecraft:()Lnet/minecraft/client/Minecraft;
        //    50: invokevirtual   net/minecraft/client/Minecraft.getResourceManager:()Lnet/minecraft/client/resources/IResourceManager;
        //    53: getstatic       net/minecraft/client/gui/GuiMainMenu.splashTexts:Lnet/minecraft/util/ResourceLocation;
        //    56: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //    61: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    66: getstatic       org/apache/commons/io/Charsets.UTF_8:Ljava/nio/charset/Charset;
        //    69: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //    72: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    75: astore_1        /* lllllIIIlIl */
        //    76: goto            97
        //    79: aload_3         /* lllllIIIIll */
        //    80: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //    83: astore_3        /* lllllIIIIll */
        //    84: aload_3         /* lllllIIIIll */
        //    85: invokevirtual   java/lang/String.isEmpty:()Z
        //    88: ifne            97
        //    91: aload_2         /* lllllIIIlII */
        //    92: aload_3         /* lllllIIIIll */
        //    93: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //    96: pop            
        //    97: aload_1         /* lllllIIIlIl */
        //    98: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   101: dup            
        //   102: astore_3        /* llllIlllllI */
        //   103: ifnonnull       79
        //   106: aload_2         /* lllllIIIlII */
        //   107: invokevirtual   java/util/ArrayList.isEmpty:()Z
        //   110: ifne            185
        //   113: aload_0         /* lllllIIIIIl */
        //   114: aload_2         /* lllllIIIlII */
        //   115: getstatic       net/minecraft/client/gui/GuiMainMenu.field_175374_h:Ljava/util/Random;
        //   118: aload_2         /* lllllIIIlII */
        //   119: invokevirtual   java/util/ArrayList.size:()I
        //   122: invokevirtual   java/util/Random.nextInt:(I)I
        //   125: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //   128: checkcast       Ljava/lang/String;
        //   131: putfield        net/minecraft/client/gui/GuiMainMenu.splashText:Ljava/lang/String;
        //   134: aload_0         /* lllllIIIIIl */
        //   135: getfield        net/minecraft/client/gui/GuiMainMenu.splashText:Ljava/lang/String;
        //   138: invokevirtual   java/lang/String.hashCode:()I
        //   141: ldc_w           125780783
        //   144: if_icmpeq       113
        //   147: goto            185
        //   150: astore_2       
        //   151: aload_1         /* lllllIIIlIl */
        //   152: ifnull          198
        //   155: aload_1         /* lllllIIIlIl */
        //   156: invokevirtual   java/io/BufferedReader.close:()V
        //   159: goto            198
        //   162: astore          llllIllllII
        //   164: goto            198
        //   167: astore          llllIllllIl
        //   169: aload_1         /* lllllIIIlIl */
        //   170: ifnull          182
        //   173: aload_1         /* lllllIIIlIl */
        //   174: invokevirtual   java/io/BufferedReader.close:()V
        //   177: goto            182
        //   180: astore          llllIllllII
        //   182: aload           llllIllllIl
        //   184: athrow         
        //   185: aload_1         /* lllllIIIlIl */
        //   186: ifnull          198
        //   189: aload_1         /* lllllIIIlIl */
        //   190: invokevirtual   java/io/BufferedReader.close:()V
        //   193: goto            198
        //   196: astore          llllIllllII
        //   198: aload_0         /* lllllIIIIIl */
        //   199: getstatic       net/minecraft/client/gui/GuiMainMenu.field_175374_h:Ljava/util/Random;
        //   202: invokevirtual   java/util/Random.nextFloat:()F
        //   205: putfield        net/minecraft/client/gui/GuiMainMenu.updateCounter:F
        //   208: aload_0         /* lllllIIIIIl */
        //   209: ldc_w           ""
        //   212: putfield        net/minecraft/client/gui/GuiMainMenu.field_92025_p:Ljava/lang/String;
        //   215: invokestatic    org/lwjgl/opengl/GLContext.getCapabilities:()Lorg/lwjgl/opengl/ContextCapabilities;
        //   218: getfield        org/lwjgl/opengl/ContextCapabilities.OpenGL20:Z
        //   221: ifne            265
        //   224: invokestatic    net/minecraft/client/renderer/OpenGlHelper.areShadersSupported:()Z
        //   227: ifne            265
        //   230: aload_0         /* lllllIIIIIl */
        //   231: ldc_w           "title.oldgl1"
        //   234: iconst_0       
        //   235: anewarray       Ljava/lang/Object;
        //   238: invokestatic    net/minecraft/client/resources/I18n.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   241: putfield        net/minecraft/client/gui/GuiMainMenu.field_92025_p:Ljava/lang/String;
        //   244: aload_0         /* lllllIIIIIl */
        //   245: ldc_w           "title.oldgl2"
        //   248: iconst_0       
        //   249: anewarray       Ljava/lang/Object;
        //   252: invokestatic    net/minecraft/client/resources/I18n.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   255: putfield        net/minecraft/client/gui/GuiMainMenu.field_146972_A:Ljava/lang/String;
        //   258: aload_0         /* lllllIIIIIl */
        //   259: ldc_w           "https://help.mojang.com/customer/portal/articles/325948?ref=game"
        //   262: putfield        net/minecraft/client/gui/GuiMainMenu.field_104024_v:Ljava/lang/String;
        //   265: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  35     147    150    167    Ljava/io/IOException;
        //  155    159    162    167    Ljava/io/IOException;
        //  35     151    167    185    Any
        //  173    177    180    182    Ljava/io/IOException;
        //  189    193    196    198    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void initGui() {
        this.viewportTexture = new DynamicTexture(256, 256);
        this.field_110351_G = this.mc.getTextureManager().getDynamicTextureLocation("background", this.viewportTexture);
        final Calendar llllIlIllII = Calendar.getInstance();
        llllIlIllII.setTime(new Date());
        if (llllIlIllII.get(2) + 1 == 11 && llllIlIllII.get(5) == 9) {
            this.splashText = "Happy birthday, ez!";
        }
        else if (llllIlIllII.get(2) + 1 == 6 && llllIlIllII.get(5) == 1) {
            this.splashText = "Happy birthday, Notch!";
        }
        else if (llllIlIllII.get(2) + 1 == 12 && llllIlIllII.get(5) == 24) {
            this.splashText = "Merry X-mas!";
        }
        else if (llllIlIllII.get(2) + 1 == 1 && llllIlIllII.get(5) == 1) {
            this.splashText = "Happy new year!";
        }
        else if (llllIlIllII.get(2) + 1 == 10 && llllIlIllII.get(5) == 31) {
            this.splashText = "OOoooOOOoooo! Spooky!";
        }
        final boolean llllIlIlIll = true;
        final int llllIlIlIlI = this.height / 4 + 48;
        if (this.mc.isDemo()) {
            this.addDemoButtons(llllIlIlIlI, 24);
        }
        else {
            this.addSingleplayerMultiplayerButtons(llllIlIlIlI, 24);
        }
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, llllIlIlIlI + 72 + 12, 98, 20, I18n.format("menu.options", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 2, llllIlIlIlI + 72 + 12, 98, 20, I18n.format("menu.quit", new Object[0])));
        this.buttonList.add(new GuiButtonLanguage(5, this.width / 2 - 124, llllIlIlIlI + 72 + 12));
        final Object llllIlIlIIl = this.field_104025_t;
        synchronized (this.field_104025_t) {
            this.field_92023_s = this.fontRendererObj.getStringWidth(this.field_92025_p);
            this.field_92024_r = this.fontRendererObj.getStringWidth(this.field_146972_A);
            final int llllIlIlIII = Math.max(this.field_92023_s, this.field_92024_r);
            this.field_92022_t = (this.width - llllIlIlIII) / 2;
            this.field_92021_u = this.buttonList.get(0).yPosition - 24;
            this.field_92020_v = this.field_92022_t + llllIlIlIII;
            this.field_92019_w = this.field_92021_u + 24;
        }
        // monitorexit(this.field_104025_t)
    }
    
    @Override
    public void updateScreen() {
        ++this.panoramaTimer;
    }
    
    private void addSingleplayerMultiplayerButtons(final int llllIIlllII, final int llllIIllIll) {
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, llllIIlllII, I18n.format("menu.singleplayer", new Object[0])));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, llllIIlllII + llllIIllIll * 1, I18n.format("menu.multiplayer", new Object[0])));
        final List buttonList = this.buttonList;
        final GuiButton field_175372_K = new GuiButton(500, this.width / 2 - 100, llllIIlllII + llllIIllIll * 2, "Alt manager");
        this.field_175372_K = field_175372_K;
        buttonList.add(field_175372_K);
    }
    
    @Override
    protected void mouseClicked(final int llIllIllIIl, final int llIllIllIII, final int llIllIlIIIl) throws IOException {
        super.mouseClicked(llIllIllIIl, llIllIllIII, llIllIlIIIl);
        final Object llIllIlIllI = this.field_104025_t;
        synchronized (this.field_104025_t) {
            if (this.field_92025_p.length() > 0 && llIllIllIIl >= this.field_92022_t && llIllIllIIl <= this.field_92020_v && llIllIllIII >= this.field_92021_u && llIllIllIII <= this.field_92019_w) {
                final GuiConfirmOpenLink llIllIlIlIl = new GuiConfirmOpenLink(this, this.field_104024_v, 13, true);
                llIllIlIlIl.disableSecurityWarning();
                this.mc.displayGuiScreen(llIllIlIlIl);
            }
        }
        // monitorexit(this.field_104025_t)
    }
    
    @Override
    public void drawScreen(final int llIlllllIII, final int llIllllIlll, final float llIlllIlIlI) {
        GlStateManager.disableAlpha();
        this.renderSkybox(llIlllllIII, llIllllIlll, llIlllIlIlI);
        GlStateManager.enableAlpha();
        final Tessellator llIllllIlIl = Tessellator.getInstance();
        final WorldRenderer llIllllIlII = llIllllIlIl.getWorldRenderer();
        final short llIllllIIll = 274;
        final int llIllllIIlI = this.width / 2 - llIllllIIll / 2;
        final byte llIllllIIIl = 30;
        this.drawGradientRect(0, 0, this.width, this.height, -2130706433, 16777215);
        this.drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);
        this.mc.getTextureManager().bindTexture(GuiMainMenu.minecraftTitleTextures);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.updateCounter < 1.0E-4) {
            this.drawTexturedModalRect(llIllllIIlI + 0, llIllllIIIl + 0, 0, 0, 99, 44);
            this.drawTexturedModalRect(llIllllIIlI + 99, llIllllIIIl + 0, 129, 0, 27, 44);
            this.drawTexturedModalRect(llIllllIIlI + 99 + 26, llIllllIIIl + 0, 126, 0, 3, 44);
            this.drawTexturedModalRect(llIllllIIlI + 99 + 26 + 3, llIllllIIIl + 0, 99, 0, 26, 44);
            this.drawTexturedModalRect(llIllllIIlI + 155, llIllllIIIl + 0, 0, 45, 155, 44);
        }
        else {
            this.drawTexturedModalRect(llIllllIIlI + 0, llIllllIIIl + 0, 0, 0, 155, 44);
            this.drawTexturedModalRect(llIllllIIlI + 155, llIllllIIIl + 0, 0, 45, 155, 44);
        }
        llIllllIlII.func_178991_c(-1);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(this.width / 2 + 90), 70.0f, 0.0f);
        GlStateManager.rotate(-20.0f, 0.0f, 0.0f, 1.0f);
        float llIllllIIII = 1.8f - MathHelper.abs(MathHelper.sin(Minecraft.getSystemTime() % 1000L / 1000.0f * 3.1415927f * 2.0f) * 0.1f);
        llIllllIIII = llIllllIIII * 100.0f / (this.fontRendererObj.getStringWidth(this.splashText) + 32);
        GlStateManager.scale(llIllllIIII, llIllllIIII, llIllllIIII);
        this.drawCenteredString(this.fontRendererObj, this.splashText, 0, -8, -256);
        GlStateManager.popMatrix();
        String llIlllIllll = "Minecraft 1.8";
        if (this.mc.isDemo()) {
            llIlllIllll = String.valueOf(new StringBuilder(String.valueOf(llIlllIllll)).append(" Demo"));
        }
        this.drawString(this.fontRendererObj, llIlllIllll, 2, this.height - 10, -1);
        final String llIlllIlllI = "Copyright Mojang AB. Do not distribute!";
        this.drawString(this.fontRendererObj, llIlllIlllI, this.width - this.fontRendererObj.getStringWidth(llIlllIlllI) - 2, this.height - 10, -1);
        if (this.field_92025_p != null && this.field_92025_p.length() > 0) {
            Gui.drawRect(this.field_92022_t - 2, this.field_92021_u - 2, this.field_92020_v + 2, this.field_92019_w - 1, 1428160512);
            this.drawString(this.fontRendererObj, this.field_92025_p, this.field_92022_t, this.field_92021_u, -1);
            this.drawString(this.fontRendererObj, this.field_146972_A, (this.width - this.field_92024_r) / 2, this.buttonList.get(0).yPosition - 12, -1);
        }
        super.drawScreen(llIlllllIII, llIllllIlll, llIlllIlIlI);
    }
    
    private void drawPanorama(final int lllIlIlIllI, final int lllIlIlIlIl, final float lllIlIIlIIl) {
        final Tessellator lllIlIlIIll = Tessellator.getInstance();
        final WorldRenderer lllIlIlIIlI = lllIlIlIIll.getWorldRenderer();
        GlStateManager.matrixMode(5889);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        Project.gluPerspective(120.0f, 1.0f, 0.05f, 10.0f);
        GlStateManager.matrixMode(5888);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.disableCull();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        final byte lllIlIlIIIl = 8;
        for (int lllIlIlIIII = 0; lllIlIlIIII < lllIlIlIIIl * lllIlIlIIIl; ++lllIlIlIIII) {
            GlStateManager.pushMatrix();
            final float lllIlIIllll = (lllIlIlIIII % lllIlIlIIIl / (float)lllIlIlIIIl - 0.5f) / 64.0f;
            final float lllIlIIlllI = (lllIlIlIIII / lllIlIlIIIl / (float)lllIlIlIIIl - 0.5f) / 64.0f;
            final float lllIlIIllIl = 0.0f;
            GlStateManager.translate(lllIlIIllll, lllIlIIlllI, lllIlIIllIl);
            GlStateManager.rotate(MathHelper.sin((this.panoramaTimer + lllIlIIlIIl) / 400.0f) * 25.0f + 20.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(-(this.panoramaTimer + lllIlIIlIIl) * 0.1f, 0.0f, 1.0f, 0.0f);
            for (int lllIlIIllII = 0; lllIlIIllII < 6; ++lllIlIIllII) {
                GlStateManager.pushMatrix();
                if (lllIlIIllII == 1) {
                    GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
                }
                if (lllIlIIllII == 2) {
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                }
                if (lllIlIIllII == 3) {
                    GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
                }
                if (lllIlIIllII == 4) {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (lllIlIIllII == 5) {
                    GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                }
                this.mc.getTextureManager().bindTexture(GuiMainMenu.titlePanoramaPaths[lllIlIIllII]);
                lllIlIlIIlI.startDrawingQuads();
                lllIlIlIIlI.func_178974_a(16777215, 255 / (lllIlIlIIII + 1));
                final float lllIlIIlIll = 0.0f;
                lllIlIlIIlI.addVertexWithUV(-1.0, -1.0, 1.0, 0.0f + lllIlIIlIll, 0.0f + lllIlIIlIll);
                lllIlIlIIlI.addVertexWithUV(1.0, -1.0, 1.0, 1.0f - lllIlIIlIll, 0.0f + lllIlIIlIll);
                lllIlIlIIlI.addVertexWithUV(1.0, 1.0, 1.0, 1.0f - lllIlIIlIll, 1.0f - lllIlIIlIll);
                lllIlIlIIlI.addVertexWithUV(-1.0, 1.0, 1.0, 0.0f + lllIlIIlIll, 1.0f - lllIlIIlIll);
                lllIlIlIIll.draw();
                GlStateManager.popMatrix();
            }
            GlStateManager.popMatrix();
            GlStateManager.colorMask(true, true, true, false);
        }
        lllIlIlIIlI.setTranslation(0.0, 0.0, 0.0);
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.matrixMode(5889);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.enableDepth();
    }
    
    @Override
    public void confirmClicked(final boolean lllIllIIllI, final int lllIllIIlIl) {
        if (lllIllIIllI && lllIllIIlIl == 12) {
            final ISaveFormat lllIllIlIll = this.mc.getSaveLoader();
            lllIllIlIll.flushCache();
            lllIllIlIll.deleteWorldDirectory("Demo_World");
            this.mc.displayGuiScreen(this);
        }
        else if (lllIllIIlIl == 13) {
            if (lllIllIIllI) {
                try {
                    final Class lllIllIlIlI = Class.forName("java.awt.Desktop");
                    final Object lllIllIlIIl = lllIllIlIlI.getMethod("getDesktop", (Class[])new Class[0]).invoke(null, new Object[0]);
                    lllIllIlIlI.getMethod("browse", URI.class).invoke(lllIllIlIIl, new URI(this.field_104024_v));
                }
                catch (Throwable lllIllIlIII) {
                    GuiMainMenu.logger.error("Couldn't open link", lllIllIlIII);
                }
            }
            this.mc.displayGuiScreen(this);
        }
    }
    
    @Override
    protected void keyTyped(final char llllIllIllI, final int llllIllIlIl) throws IOException {
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllIlllllIl) throws IOException {
        if (lllIlllllIl.id == 0) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }
        if (lllIlllllIl.id == 5) {
            this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
        }
        if (lllIlllllIl.id == 1) {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if (lllIlllllIl.id == 2) {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if (lllIlllllIl.id == 14 && this.field_175372_K.visible) {
            this.switchToRealms();
        }
        if (lllIlllllIl.id == 4) {
            this.mc.shutdown();
        }
        if (lllIlllllIl.id == 11) {
            this.mc.launchIntegratedServer("Demo_World", "Demo_World", DemoWorldServer.demoWorldSettings);
        }
        if (lllIlllllIl.id == 12) {
            final ISaveFormat llllIIIIIIl = this.mc.getSaveLoader();
            final WorldInfo llllIIIIIII = llllIIIIIIl.getWorldInfo("Demo_World");
            if (llllIIIIIII != null) {
                final GuiYesNo lllIlllllll = GuiSelectWorld.func_152129_a(this, llllIIIIIII.getWorldName(), 12);
                this.mc.displayGuiScreen(lllIlllllll);
            }
        }
        if (lllIlllllIl.id == 500) {
            this.mc.displayGuiScreen(new GuiAltManager());
        }
        if (lllIlllllIl.id == 600) {
            new DisplayOnScreen();
        }
    }
    
    private void switchToRealms() {
        final RealmsBridge lllIlllIllI = new RealmsBridge();
        lllIlllIllI.switchToRealms(this);
    }
    
    static {
        __OBFID = "CL_00001154";
        field_175373_f = new AtomicInteger(0);
        logger = LogManager.getLogger();
        field_175374_h = new Random();
        splashTexts = new ResourceLocation("texts/splashes.txt");
        minecraftTitleTextures = new ResourceLocation("textures/gui/title/minecraft.png");
        titlePanoramaPaths = new ResourceLocation[] { new ResourceLocation("textures/gui/title/background/panorama_0.png"), new ResourceLocation("textures/gui/title/background/panorama_1.png"), new ResourceLocation("textures/gui/title/background/panorama_2.png"), new ResourceLocation("textures/gui/title/background/panorama_3.png"), new ResourceLocation("textures/gui/title/background/panorama_4.png"), new ResourceLocation("textures/gui/title/background/panorama_5.png") };
        field_96138_a = String.valueOf(new StringBuilder("Please click ").append(EnumChatFormatting.UNDERLINE).append("here").append(EnumChatFormatting.RESET).append(" for more information."));
    }
    
    private void addDemoButtons(final int llllIIIllII, final int llllIIIlIll) {
        this.buttonList.add(new GuiButton(11, this.width / 2 - 100, llllIIIllII, I18n.format("menu.playdemo", new Object[0])));
        final List buttonList = this.buttonList;
        final GuiButton buttonResetDemo = new GuiButton(12, this.width / 2 - 100, llllIIIllII + llllIIIlIll * 1, I18n.format("menu.resetdemo", new Object[0]));
        this.buttonResetDemo = buttonResetDemo;
        buttonList.add(buttonResetDemo);
        final ISaveFormat llllIIIllll = this.mc.getSaveLoader();
        final WorldInfo llllIIIlllI = llllIIIllll.getWorldInfo("Demo_World");
        if (llllIIIlllI == null) {
            this.buttonResetDemo.enabled = false;
        }
    }
    
    private void rotateAndBlurSkybox(final float lllIIllIllI) {
        this.mc.getTextureManager().bindTexture(this.field_110351_G);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.colorMask(true, true, true, false);
        final Tessellator lllIIllIlIl = Tessellator.getInstance();
        final WorldRenderer lllIIllIlII = lllIIllIlIl.getWorldRenderer();
        lllIIllIlII.startDrawingQuads();
        GlStateManager.disableAlpha();
        final byte lllIIllIIll = 3;
        for (int lllIIllIIlI = 0; lllIIllIIlI < lllIIllIIll; ++lllIIllIIlI) {
            lllIIllIlII.func_178960_a(1.0f, 1.0f, 1.0f, 1.0f / (lllIIllIIlI + 1));
            final int lllIIllIIIl = this.width;
            final int lllIIllIIII = this.height;
            final float lllIIlIllll = (lllIIllIIlI - lllIIllIIll / 2) / 256.0f;
            lllIIllIlII.addVertexWithUV(lllIIllIIIl, lllIIllIIII, this.zLevel, 0.0f + lllIIlIllll, 1.0);
            lllIIllIlII.addVertexWithUV(lllIIllIIIl, 0.0, this.zLevel, 1.0f + lllIIlIllll, 1.0);
            lllIIllIlII.addVertexWithUV(0.0, 0.0, this.zLevel, 1.0f + lllIIlIllll, 0.0);
            lllIIllIlII.addVertexWithUV(0.0, lllIIllIIII, this.zLevel, 0.0f + lllIIlIllll, 0.0);
        }
        lllIIllIlIl.draw();
        GlStateManager.enableAlpha();
        GlStateManager.colorMask(true, true, true, true);
    }
}
