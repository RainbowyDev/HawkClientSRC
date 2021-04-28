package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.renderer.texture.*;
import hawk.modules.player.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import org.apache.commons.io.*;
import java.io.*;
import optifine.*;
import org.lwjgl.opengl.*;
import com.ibm.icu.text.*;
import net.minecraft.client.resources.*;
import java.util.*;

public class FontRenderer implements IResourceManagerReloadListener
{
    public /* synthetic */ float offsetBold;
    private /* synthetic */ float posY;
    public /* synthetic */ ResourceLocation locationFontTextureBase;
    public /* synthetic */ int FONT_HEIGHT;
    private /* synthetic */ boolean bidiFlag;
    private /* synthetic */ boolean strikethroughStyle;
    private /* synthetic */ float green;
    private /* synthetic */ float blue;
    public /* synthetic */ GameSettings gameSettings;
    private final /* synthetic */ TextureManager renderEngine;
    private /* synthetic */ byte[] glyphWidth;
    private /* synthetic */ float[] charWidth;
    private /* synthetic */ boolean underlineStyle;
    private /* synthetic */ boolean randomStyle;
    private /* synthetic */ float posX;
    private /* synthetic */ ResourceLocation locationFontTexture;
    public /* synthetic */ boolean enabled;
    private /* synthetic */ int[] colorCode;
    private static final /* synthetic */ ResourceLocation[] unicodePageLocations;
    private /* synthetic */ boolean italicStyle;
    private /* synthetic */ float alpha;
    private /* synthetic */ float red;
    private /* synthetic */ boolean unicodeFlag;
    public /* synthetic */ Random fontRandom;
    private /* synthetic */ int textColor;
    private /* synthetic */ boolean boldStyle;
    
    private void renderStringAtPos(String llIllIlIIIlIlIl, final boolean llIllIlIIlIIlIl) {
        if (NameProtect.isEnabled && Minecraft.getMinecraft().thePlayer.getName() != null && llIllIlIIIlIlIl.contains(Minecraft.getMinecraft().thePlayer.getName())) {
            llIllIlIIIlIlIl = llIllIlIIIlIlIl.replace(Minecraft.getMinecraft().thePlayer.getName(), NameProtect.getNewName());
        }
        for (int llIllIlIIlIIlII = 0; llIllIlIIlIIlII < llIllIlIIIlIlIl.length(); ++llIllIlIIlIIlII) {
            final char llIllIlIIlIIIll = llIllIlIIIlIlIl.charAt(llIllIlIIlIIlII);
            if (llIllIlIIlIIIll == '§' && llIllIlIIlIIlII + 1 < llIllIlIIIlIlIl.length()) {
                int llIllIlIIlIIIlI = "0123456789abcdefklmnor".indexOf(llIllIlIIIlIlIl.toLowerCase().charAt(llIllIlIIlIIlII + 1));
                if (llIllIlIIlIIIlI < 16) {
                    this.randomStyle = false;
                    this.boldStyle = false;
                    this.strikethroughStyle = false;
                    this.underlineStyle = false;
                    this.italicStyle = false;
                    if (llIllIlIIlIIIlI < 0 || llIllIlIIlIIIlI > 15) {
                        llIllIlIIlIIIlI = 15;
                    }
                    if (llIllIlIIlIIlIl) {
                        llIllIlIIlIIIlI += 16;
                    }
                    int llIllIlIIlIIIII = this.colorCode[llIllIlIIlIIIlI];
                    if (Config.isCustomColors()) {
                        llIllIlIIlIIIII = CustomColors.getTextColor(llIllIlIIlIIIlI, llIllIlIIlIIIII);
                    }
                    this.textColor = llIllIlIIlIIIII;
                    this.setColor((llIllIlIIlIIIII >> 16) / 255.0f, (llIllIlIIlIIIII >> 8 & 0xFF) / 255.0f, (llIllIlIIlIIIII & 0xFF) / 255.0f, this.alpha);
                }
                else if (llIllIlIIlIIIlI == 16) {
                    this.randomStyle = true;
                }
                else if (llIllIlIIlIIIlI == 17) {
                    this.boldStyle = true;
                }
                else if (llIllIlIIlIIIlI == 18) {
                    this.strikethroughStyle = true;
                }
                else if (llIllIlIIlIIIlI == 19) {
                    this.underlineStyle = true;
                }
                else if (llIllIlIIlIIIlI == 20) {
                    this.italicStyle = true;
                }
                else if (llIllIlIIlIIIlI == 21) {
                    this.randomStyle = false;
                    this.boldStyle = false;
                    this.strikethroughStyle = false;
                    this.underlineStyle = false;
                    this.italicStyle = false;
                    this.setColor(this.red, this.blue, this.green, this.alpha);
                }
                ++llIllIlIIlIIlII;
            }
            else {
                int llIllIlIIlIIIIl = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8£\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1ªº¿®¬½¼¡«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f²\u25a0\u0000".indexOf(llIllIlIIlIIIll);
                if (this.randomStyle && llIllIlIIlIIIIl != -1) {
                    int llIllIlIIIlllll;
                    do {
                        llIllIlIIIlllll = this.fontRandom.nextInt(this.charWidth.length);
                    } while ((int)this.charWidth[llIllIlIIlIIIIl] != (int)this.charWidth[llIllIlIIIlllll]);
                    llIllIlIIlIIIIl = llIllIlIIIlllll;
                }
                final float llIllIlIIIllllI = (llIllIlIIlIIIIl != -1 && !this.unicodeFlag) ? this.offsetBold : 0.5f;
                final boolean llIllIlIIIlllIl = (llIllIlIIlIIIll == '\0' || llIllIlIIlIIIIl == -1 || this.unicodeFlag) && llIllIlIIlIIlIl;
                if (llIllIlIIIlllIl) {
                    this.posX -= llIllIlIIIllllI;
                    this.posY -= llIllIlIIIllllI;
                }
                float llIllIlIIIlllII = this.renderCharAtPos(llIllIlIIlIIIIl, llIllIlIIlIIIll, this.italicStyle);
                if (llIllIlIIIlllIl) {
                    this.posX += llIllIlIIIllllI;
                    this.posY += llIllIlIIIllllI;
                }
                if (this.boldStyle) {
                    this.posX += llIllIlIIIllllI;
                    if (llIllIlIIIlllIl) {
                        this.posX -= llIllIlIIIllllI;
                        this.posY -= llIllIlIIIllllI;
                    }
                    this.renderCharAtPos(llIllIlIIlIIIIl, llIllIlIIlIIIll, this.italicStyle);
                    this.posX -= llIllIlIIIllllI;
                    if (llIllIlIIIlllIl) {
                        this.posX += llIllIlIIIllllI;
                        this.posY += llIllIlIIIllllI;
                    }
                    llIllIlIIIlllII += llIllIlIIIllllI;
                }
                if (this.strikethroughStyle) {
                    final Tessellator llIllIlIIIllIll = Tessellator.getInstance();
                    final WorldRenderer llIllIlIIIllIIl = llIllIlIIIllIll.getWorldRenderer();
                    GlStateManager.func_179090_x();
                    llIllIlIIIllIIl.startDrawingQuads();
                    llIllIlIIIllIIl.addVertex(this.posX, this.posY + this.FONT_HEIGHT / 2, 0.0);
                    llIllIlIIIllIIl.addVertex(this.posX + llIllIlIIIlllII, this.posY + this.FONT_HEIGHT / 2, 0.0);
                    llIllIlIIIllIIl.addVertex(this.posX + llIllIlIIIlllII, this.posY + this.FONT_HEIGHT / 2 - 1.0f, 0.0);
                    llIllIlIIIllIIl.addVertex(this.posX, this.posY + this.FONT_HEIGHT / 2 - 1.0f, 0.0);
                    llIllIlIIIllIll.draw();
                    GlStateManager.func_179098_w();
                }
                if (this.underlineStyle) {
                    final Tessellator llIllIlIIIllIlI = Tessellator.getInstance();
                    final WorldRenderer llIllIlIIIllIII = llIllIlIIIllIlI.getWorldRenderer();
                    GlStateManager.func_179090_x();
                    llIllIlIIIllIII.startDrawingQuads();
                    final int llIllIlIIIlIlll = this.underlineStyle ? -1 : 0;
                    llIllIlIIIllIII.addVertex(this.posX + llIllIlIIIlIlll, this.posY + this.FONT_HEIGHT, 0.0);
                    llIllIlIIIllIII.addVertex(this.posX + llIllIlIIIlllII, this.posY + this.FONT_HEIGHT, 0.0);
                    llIllIlIIIllIII.addVertex(this.posX + llIllIlIIIlllII, this.posY + this.FONT_HEIGHT - 1.0f, 0.0);
                    llIllIlIIIllIII.addVertex(this.posX + llIllIlIIIlIlll, this.posY + this.FONT_HEIGHT - 1.0f, 0.0);
                    llIllIlIIIllIlI.draw();
                    GlStateManager.func_179098_w();
                }
                this.posX += llIllIlIIIlllII;
            }
        }
    }
    
    private float getCharWidthFloat(final char llIllIIlIlllllI) {
        if (llIllIIlIlllllI == '§') {
            return -1.0f;
        }
        if (llIllIIlIlllllI == ' ') {
            return this.charWidth[32];
        }
        final int llIllIIlIllllIl = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8£\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1ªº¿®¬½¼¡«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f²\u25a0\u0000".indexOf(llIllIIlIlllllI);
        if (llIllIIlIlllllI > '\0' && llIllIIlIllllIl != -1 && !this.unicodeFlag) {
            return this.charWidth[llIllIIlIllllIl];
        }
        if (this.glyphWidth[llIllIIlIlllllI] != 0) {
            int llIllIIlIllllII = this.glyphWidth[llIllIIlIlllllI] >>> 4;
            int llIllIIlIlllIll = this.glyphWidth[llIllIIlIlllllI] & 0xF;
            llIllIIlIllllII &= 0xF;
            return (float)((++llIllIIlIlllIll - llIllIIlIllllII) / 2 + 1);
        }
        return 0.0f;
    }
    
    static {
        __OBFID = "CL_00000660";
        unicodePageLocations = new ResourceLocation[256];
    }
    
    protected void setColor(final float llIlIlllIIIlIIl, final float llIlIlllIIIllII, final float llIlIlllIIIIlll, final float llIlIlllIIIIllI) {
        GlStateManager.color(llIlIlllIIIlIIl, llIlIlllIIIllII, llIlIlllIIIIlll, llIlIlllIIIIllI);
    }
    
    private void readFontTexture() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* llIllIllllllIll */
        //     2: getfield        net/minecraft/client/gui/FontRenderer.locationFontTexture:Lnet/minecraft/util/ResourceLocation;
        //     5: invokevirtual   net/minecraft/client/gui/FontRenderer.getResourceInputStream:(Lnet/minecraft/util/ResourceLocation;)Ljava/io/InputStream;
        //     8: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.func_177053_a:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    11: astore_1        /* llIllIllllllIlI */
        //    12: goto            25
        //    15: astore_2        /* llIllIllllllIII */
        //    16: new             Ljava/lang/RuntimeException;
        //    19: dup            
        //    20: aload_2         /* llIllIllllllIII */
        //    21: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    24: athrow         
        //    25: aload_0         /* llIllIllllllIll */
        //    26: getfield        net/minecraft/client/gui/FontRenderer.locationFontTexture:Lnet/minecraft/util/ResourceLocation;
        //    29: invokestatic    optifine/FontUtils.readFontProperties:(Lnet/minecraft/util/ResourceLocation;)Ljava/util/Properties;
        //    32: astore_2        /* llIllIlllllIlll */
        //    33: aload_1         /* llIllIllllllIIl */
        //    34: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    37: istore_3        /* llIllIllllIIIII */
        //    38: aload_1         /* llIllIllllllIIl */
        //    39: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    42: istore          llIllIlllllIlIl
        //    44: iload_3         /* llIllIlllllIllI */
        //    45: bipush          16
        //    47: idiv           
        //    48: istore          llIllIlllllIlII
        //    50: iload           llIllIlllllIlIl
        //    52: bipush          16
        //    54: idiv           
        //    55: istore          llIllIlllllIIll
        //    57: iload_3         /* llIllIlllllIllI */
        //    58: i2f            
        //    59: ldc_w           128.0
        //    62: fdiv           
        //    63: fstore          llIllIlllllIIlI
        //    65: fload           llIllIlllllIIlI
        //    67: fconst_1       
        //    68: fconst_2       
        //    69: invokestatic    optifine/Config.limit:(FFF)F
        //    72: fstore          llIllIlllllIIIl
        //    74: aload_0         /* llIllIllllllIll */
        //    75: fconst_1       
        //    76: fload           llIllIlllllIIIl
        //    78: fdiv           
        //    79: putfield        net/minecraft/client/gui/FontRenderer.offsetBold:F
        //    82: aload_2         /* llIllIlllllIlll */
        //    83: ldc_w           "offsetBold"
        //    86: ldc             -1.0
        //    88: invokestatic    optifine/FontUtils.readFloat:(Ljava/util/Properties;Ljava/lang/String;F)F
        //    91: fstore          llIllIlllllIIII
        //    93: fload           llIllIlllllIIII
        //    95: fconst_0       
        //    96: fcmpl          
        //    97: iflt            106
        //   100: aload_0         /* llIllIllllllIll */
        //   101: fload           llIllIlllllIIII
        //   103: putfield        net/minecraft/client/gui/FontRenderer.offsetBold:F
        //   106: iload_3         /* llIllIlllllIllI */
        //   107: iload           llIllIlllllIlIl
        //   109: imul           
        //   110: newarray        I
        //   112: astore          llIllIllllIllll
        //   114: aload_1         /* llIllIllllllIIl */
        //   115: iconst_0       
        //   116: iconst_0       
        //   117: iload_3         /* llIllIlllllIllI */
        //   118: iload           llIllIlllllIlIl
        //   120: aload           llIllIllllIllll
        //   122: iconst_0       
        //   123: iload_3         /* llIllIlllllIllI */
        //   124: invokevirtual   java/awt/image/BufferedImage.getRGB:(IIII[III)[I
        //   127: pop            
        //   128: iconst_0       
        //   129: istore          llIllIllllIlllI
        //   131: goto            314
        //   134: iload           llIllIllllIlllI
        //   136: bipush          16
        //   138: irem           
        //   139: istore          llIllIllllIllIl
        //   141: iload           llIllIllllIlllI
        //   143: bipush          16
        //   145: idiv           
        //   146: istore          llIllIllllIllII
        //   148: iconst_0       
        //   149: istore          llIllIllllIlIll
        //   151: iload           llIllIlllllIlII
        //   153: iconst_1       
        //   154: isub           
        //   155: istore          llIllIllllIlIlI
        //   157: iload           llIllIllllIlIlI
        //   159: iflt            250
        //   162: iload           llIllIllllIllIl
        //   164: iload           llIllIlllllIlII
        //   166: imul           
        //   167: iload           llIllIllllIlIlI
        //   169: iadd           
        //   170: istore          llIllIllllIlIIl
        //   172: iconst_1       
        //   173: istore          llIllIllllIlIII
        //   175: iconst_0       
        //   176: istore          llIllIllllIIlll
        //   178: goto            227
        //   181: iload           llIllIllllIllII
        //   183: iload           llIllIlllllIIll
        //   185: imul           
        //   186: iload           llIllIllllIIlll
        //   188: iadd           
        //   189: iload_3         /* llIllIlllllIllI */
        //   190: imul           
        //   191: istore          llIllIllllIIllI
        //   193: aload           llIllIllllIllll
        //   195: iload           llIllIllllIlIIl
        //   197: iload           llIllIllllIIllI
        //   199: iadd           
        //   200: iaload         
        //   201: istore          llIllIllllIIlIl
        //   203: iload           llIllIllllIIlIl
        //   205: bipush          24
        //   207: ishr           
        //   208: sipush          255
        //   211: iand           
        //   212: istore          llIllIllllIIlII
        //   214: iload           llIllIllllIIlII
        //   216: bipush          16
        //   218: if_icmple       224
        //   221: iconst_0       
        //   222: istore          llIllIllllIlIII
        //   224: iinc            llIllIllllIIlll, 1
        //   227: iload           llIllIllllIIlll
        //   229: iload           llIllIlllllIIll
        //   231: if_icmpge       239
        //   234: iload           llIllIllllIlIII
        //   236: ifne            181
        //   239: iload           llIllIllllIlIII
        //   241: ifeq            250
        //   244: iinc            llIllIllllIlIlI, -1
        //   247: goto            157
        //   250: iload           llIllIllllIlllI
        //   252: bipush          65
        //   254: if_icmpne       261
        //   257: iload           llIllIllllIlllI
        //   259: istore          llIllIllllIlllI
        //   261: iload           llIllIllllIlllI
        //   263: bipush          32
        //   265: if_icmpne       294
        //   268: iload           llIllIlllllIlII
        //   270: bipush          8
        //   272: if_icmpgt       285
        //   275: fconst_2       
        //   276: fload           llIllIlllllIIlI
        //   278: fmul           
        //   279: f2i            
        //   280: istore          llIllIllllIlIlI
        //   282: goto            294
        //   285: ldc_w           1.5
        //   288: fload           llIllIlllllIIlI
        //   290: fmul           
        //   291: f2i            
        //   292: istore          llIllIllllIlIlI
        //   294: aload_0         /* llIllIllllllIll */
        //   295: getfield        net/minecraft/client/gui/FontRenderer.charWidth:[F
        //   298: iload           llIllIllllIlllI
        //   300: iload           llIllIllllIlIlI
        //   302: iconst_1       
        //   303: iadd           
        //   304: i2f            
        //   305: fload           llIllIlllllIIlI
        //   307: fdiv           
        //   308: fconst_1       
        //   309: fadd           
        //   310: fastore        
        //   311: iinc            llIllIllllIlllI, 1
        //   314: iload           llIllIllllIlllI
        //   316: sipush          256
        //   319: if_icmplt       134
        //   322: aload_2         /* llIllIlllllIlll */
        //   323: aload_0         /* llIllIllllllIll */
        //   324: getfield        net/minecraft/client/gui/FontRenderer.charWidth:[F
        //   327: invokestatic    optifine/FontUtils.readCustomCharWidths:(Ljava/util/Properties;[F)V
        //   330: return         
        //    StackMapTable: 00 0E 4F 07 01 10 FC 00 09 07 01 2A FF 00 50 00 0A 07 00 02 07 01 2A 07 01 76 01 01 01 01 02 02 02 00 00 FD 00 1B 07 01 77 01 FF 00 16 00 10 07 00 02 07 01 2A 07 01 76 01 01 01 01 02 02 02 07 01 77 01 01 01 01 01 00 00 FE 00 17 01 01 01 FE 00 2A 01 01 01 F8 00 02 0B F8 00 0A 0A 17 08 FF 00 13 00 0C 07 00 02 07 01 2A 07 01 76 01 01 01 01 02 02 02 07 01 77 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      12     15     25     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void drawSplitString(String llIllIIIlIlIlIl, final int llIllIIIlIlIlII, final int llIllIIIlllIlIl, final int llIllIIIlIlIIlI, final int llIllIIIlIlIIIl) {
        this.resetStyles();
        this.textColor = llIllIIIlIlIIIl;
        llIllIIIlIlIlIl = this.trimStringNewline(llIllIIIlIlIlIl);
        this.renderSplitString(llIllIIIlIlIlIl, llIllIIIlIlIlII, llIllIIIlllIlIl, llIllIIIlIlIIlI, false);
    }
    
    public int getCharWidth(final char llIllIIllIIIlll) {
        return Math.round(this.getCharWidthFloat(llIllIIllIIIlll));
    }
    
    private void readGlyphSizes() {
        InputStream llIllIlllIIlIII = null;
        try {
            llIllIlllIIlIII = this.getResourceInputStream(new ResourceLocation("font/glyph_sizes.bin"));
            llIllIlllIIlIII.read(this.glyphWidth);
        }
        catch (IOException llIllIlllIIIlll) {
            throw new RuntimeException(llIllIlllIIIlll);
        }
        finally {
            IOUtils.closeQuietly(llIllIlllIIlIII);
        }
        IOUtils.closeQuietly(llIllIlllIIlIII);
    }
    
    private ResourceLocation getUnicodePageLocation(final int llIllIllIIllllI) {
        if (FontRenderer.unicodePageLocations[llIllIllIIllllI] == null) {
            FontRenderer.unicodePageLocations[llIllIllIIllllI] = new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", llIllIllIIllllI));
            FontRenderer.unicodePageLocations[llIllIllIIllllI] = FontUtils.getHdFontLocation(FontRenderer.unicodePageLocations[llIllIllIIllllI]);
        }
        return FontRenderer.unicodePageLocations[llIllIllIIllllI];
    }
    
    public int func_175065_a(final String llIllIlIlIIllIl, final float llIllIlIlIIllII, final float llIllIlIlIIlIll, final int llIllIlIlIIIIlI, final boolean llIllIlIlIIlIIl) {
        this.enableAlpha();
        this.resetStyles();
        int llIllIlIlIIIlll = 0;
        if (llIllIlIlIIlIIl) {
            int llIllIlIlIIlIII = this.func_180455_b(llIllIlIlIIllIl, llIllIlIlIIllII + 1.0f, llIllIlIlIIlIll + 1.0f, llIllIlIlIIIIlI, true);
            llIllIlIlIIlIII = Math.max(llIllIlIlIIlIII, this.func_180455_b(llIllIlIlIIllIl, llIllIlIlIIllII, llIllIlIlIIlIll, llIllIlIlIIIIlI, false));
        }
        else {
            llIllIlIlIIIlll = this.func_180455_b(llIllIlIlIIllIl, llIllIlIlIIllII, llIllIlIlIIlIll, llIllIlIlIIIIlI, false);
        }
        return llIllIlIlIIIlll;
    }
    
    public int drawString(final String llIllIlIlIllIIl, final double llIllIlIlIlllIl, final double llIllIlIlIlllII, final int llIllIlIlIlIllI) {
        return this.enabled ? this.func_175065_a(llIllIlIlIllIIl, (float)llIllIlIlIlllIl, (float)llIllIlIlIlllII, llIllIlIlIlIllI, false) : 0;
    }
    
    private static boolean isFormatColor(final char llIlIlllIllIlIl) {
        return (llIlIlllIllIlIl >= '0' && llIlIlllIllIlIl <= '9') || (llIlIlllIllIlIl >= 'a' && llIlIlllIllIlIl <= 'f') || (llIlIlllIllIlIl >= 'A' && llIlIlllIllIlIl <= 'F');
    }
    
    public List listFormattedStringToWidth(final String llIlIllllllIIlI, final int llIlIllllllIlII) {
        return Arrays.asList(this.wrapFormattedStringToWidth(llIlIllllllIIlI, llIlIllllllIlII).split("\n"));
    }
    
    public String trimStringToWidth(final String llIllIIlIlIlllI, final int llIllIIlIllIIII) {
        return this.trimStringToWidth(llIllIIlIlIlllI, llIllIIlIllIIII, false);
    }
    
    private String trimStringNewline(String llIllIIlIIIIIlI) {
        while (llIllIIlIIIIIlI != null && ((String)llIllIIlIIIIIlI).endsWith("\n")) {
            llIllIIlIIIIIlI = ((String)llIllIIlIIIIIlI).substring(0, ((String)llIllIIlIIIIIlI).length() - 1);
        }
        return (String)llIllIIlIIIIIlI;
    }
    
    private int renderStringAligned(final String llIllIIlllllIII, int llIllIIllllllll, final int llIllIIllllIllI, final int llIllIIllllIlIl, final int llIllIIllllllII, final boolean llIllIIllllIIll) {
        if (this.bidiFlag) {
            final int llIllIIlllllIlI = this.getStringWidth(this.bidiReorder(llIllIIlllllIII));
            llIllIIllllllll = llIllIIllllllll + llIllIIllllIlIl - llIllIIlllllIlI;
        }
        return this.func_180455_b(llIllIIlllllIII, (float)llIllIIllllllll, (float)llIllIIllllIllI, llIllIIllllllII, llIllIIllllIIll);
    }
    
    private int sizeStringToWidth(final String llIlIlllIllllll, final int llIlIllllIIlIII) {
        final int llIlIllllIIIlll = llIlIlllIllllll.length();
        float llIlIllllIIIllI = 0.0f;
        int llIlIllllIIIlIl = 0;
        int llIlIllllIIIlII = -1;
        boolean llIlIllllIIIIll = false;
        while (llIlIllllIIIlIl < llIlIllllIIIlll) {
            final char llIlIllllIIIIlI = llIlIlllIllllll.charAt(llIlIllllIIIlIl);
            Label_0163: {
                switch (llIlIllllIIIIlI) {
                    case '\n': {
                        --llIlIllllIIIlIl;
                        break Label_0163;
                    }
                    case '§': {
                        if (llIlIllllIIIlIl >= llIlIllllIIIlll - 1) {
                            break Label_0163;
                        }
                        ++llIlIllllIIIlIl;
                        final char llIlIllllIIIIIl = llIlIlllIllllll.charAt(llIlIllllIIIlIl);
                        if (llIlIllllIIIIIl == 'l' || llIlIllllIIIIIl == 'L') {
                            llIlIllllIIIIll = true;
                            break Label_0163;
                        }
                        if (llIlIllllIIIIIl == 'r' || llIlIllllIIIIIl == 'R' || isFormatColor(llIlIllllIIIIIl)) {
                            llIlIllllIIIIll = false;
                        }
                        break Label_0163;
                    }
                    case ' ': {
                        llIlIllllIIIlII = llIlIllllIIIlIl;
                        break;
                    }
                }
                llIlIllllIIIllI += this.getCharWidthFloat(llIlIllllIIIIlI);
                if (llIlIllllIIIIll) {
                    ++llIlIllllIIIllI;
                }
            }
            if (llIlIllllIIIIlI == '\n') {
                llIlIllllIIIlII = ++llIlIllllIIIlIl;
                break;
            }
            if (llIlIllllIIIllI > llIlIllllIIlIII) {
                break;
            }
            ++llIlIllllIIIlIl;
        }
        return (llIlIllllIIIlIl != llIlIllllIIIlll && llIlIllllIIIlII != -1 && llIlIllllIIIlII < llIlIllllIIIlIl) ? llIlIllllIIIlII : llIlIllllIIIlIl;
    }
    
    private int func_180455_b(String llIllIIlllIIlII, final float llIllIIlllIlIIl, final float llIllIIlllIlIII, int llIllIIlllIIIIl, final boolean llIllIIlllIIIII) {
        if (llIllIIlllIIlII == null) {
            return 0;
        }
        if (this.bidiFlag) {
            llIllIIlllIIlII = this.bidiReorder(llIllIIlllIIlII);
        }
        if ((llIllIIlllIIIIl & 0xFC000000) == 0x0) {
            llIllIIlllIIIIl |= 0xFF000000;
        }
        if (llIllIIlllIIIII) {
            llIllIIlllIIIIl = ((llIllIIlllIIIIl & 0xFCFCFC) >> 2 | (llIllIIlllIIIIl & 0xFF000000));
        }
        this.red = (llIllIIlllIIIIl >> 16 & 0xFF) / 255.0f;
        this.blue = (llIllIIlllIIIIl >> 8 & 0xFF) / 255.0f;
        this.green = (llIllIIlllIIIIl & 0xFF) / 255.0f;
        this.alpha = (llIllIIlllIIIIl >> 24 & 0xFF) / 255.0f;
        this.setColor(this.red, this.blue, this.green, this.alpha);
        this.posX = llIllIIlllIlIIl;
        this.posY = llIllIIlllIlIII;
        this.renderStringAtPos(llIllIIlllIIlII, llIllIIlllIIIII);
        return (int)this.posX;
    }
    
    public static String getFormatFromString(final String llIlIlllIlIlIll) {
        String llIlIlllIlIlIlI = "";
        int llIlIlllIlIlIIl = -1;
        final int llIlIlllIlIlIII = llIlIlllIlIlIll.length();
        while ((llIlIlllIlIlIIl = llIlIlllIlIlIll.indexOf(167, llIlIlllIlIlIIl + 1)) != -1) {
            if (llIlIlllIlIlIIl < llIlIlllIlIlIII - 1) {
                final char llIlIlllIlIIlll = llIlIlllIlIlIll.charAt(llIlIlllIlIlIIl + 1);
                if (isFormatColor(llIlIlllIlIIlll)) {
                    llIlIlllIlIlIlI = String.valueOf(new StringBuilder("§").append(llIlIlllIlIIlll));
                }
                else {
                    if (!isFormatSpecial(llIlIlllIlIIlll)) {
                        continue;
                    }
                    llIlIlllIlIlIlI = String.valueOf(new StringBuilder(String.valueOf(llIlIlllIlIlIlI)).append("§").append(llIlIlllIlIIlll));
                }
            }
        }
        return llIlIlllIlIlIlI;
    }
    
    protected void enableAlpha() {
        GlStateManager.enableAlpha();
    }
    
    String wrapFormattedStringToWidth(final String llIlIllllIllIll, final int llIlIllllIllIlI) {
        final int llIlIlllllIIIIl = this.sizeStringToWidth(llIlIllllIllIll, llIlIllllIllIlI);
        if (llIlIllllIllIll.length() <= llIlIlllllIIIIl) {
            return llIlIllllIllIll;
        }
        final String llIlIlllllIIIII = llIlIllllIllIll.substring(0, llIlIlllllIIIIl);
        final char llIlIllllIlllll = llIlIllllIllIll.charAt(llIlIlllllIIIIl);
        final boolean llIlIllllIllllI = llIlIllllIlllll == ' ' || llIlIllllIlllll == '\n';
        final String llIlIllllIlllIl = String.valueOf(new StringBuilder(String.valueOf(getFormatFromString(llIlIlllllIIIII))).append(llIlIllllIllIll.substring(llIlIlllllIIIIl + (llIlIllllIllllI ? 1 : 0))));
        return String.valueOf(new StringBuilder(String.valueOf(llIlIlllllIIIII)).append("\n").append(this.wrapFormattedStringToWidth(llIlIllllIlllIl, llIlIllllIllIlI)));
    }
    
    private float renderUnicodeChar(final char llIllIllIIIlIlI, final boolean llIllIllIIIlIIl) {
        if (this.glyphWidth[llIllIllIIIlIlI] == 0) {
            return 0.0f;
        }
        final int llIllIllIIIlIII = llIllIllIIIlIlI / '\u0100';
        this.loadGlyphTexture(llIllIllIIIlIII);
        int llIllIllIIIIlll = this.glyphWidth[llIllIllIIIlIlI] >>> 4;
        final int llIllIllIIIIllI = this.glyphWidth[llIllIllIIIlIlI] & 0xF;
        llIllIllIIIIlll &= 0xF;
        final float llIllIllIIIIlIl = (float)llIllIllIIIIlll;
        final float llIllIllIIIIlII = (float)(llIllIllIIIIllI + 1);
        final float llIllIllIIIIIll = llIllIllIIIlIlI % '\u0010' * 16 + llIllIllIIIIlIl;
        final float llIllIllIIIIIlI = (float)((llIllIllIIIlIlI & '\u00ff') / 16 * 16);
        final float llIllIllIIIIIIl = llIllIllIIIIlII - llIllIllIIIIlIl - 0.02f;
        final float llIllIllIIIIIII = llIllIllIIIlIIl ? 1.0f : 0.0f;
        GL11.glBegin(5);
        GL11.glTexCoord2f(llIllIllIIIIIll / 256.0f, llIllIllIIIIIlI / 256.0f);
        GL11.glVertex3f(this.posX + llIllIllIIIIIII, this.posY, 0.0f);
        GL11.glTexCoord2f(llIllIllIIIIIll / 256.0f, (llIllIllIIIIIlI + 15.98f) / 256.0f);
        GL11.glVertex3f(this.posX - llIllIllIIIIIII, this.posY + 7.99f, 0.0f);
        GL11.glTexCoord2f((llIllIllIIIIIll + llIllIllIIIIIIl) / 256.0f, llIllIllIIIIIlI / 256.0f);
        GL11.glVertex3f(this.posX + llIllIllIIIIIIl / 2.0f + llIllIllIIIIIII, this.posY, 0.0f);
        GL11.glTexCoord2f((llIllIllIIIIIll + llIllIllIIIIIIl) / 256.0f, (llIllIllIIIIIlI + 15.98f) / 256.0f);
        GL11.glVertex3f(this.posX + llIllIllIIIIIIl / 2.0f - llIllIllIIIIIII, this.posY + 7.99f, 0.0f);
        GL11.glEnd();
        return (llIllIllIIIIlII - llIllIllIIIIlIl) / 2.0f + 1.0f;
    }
    
    private float renderCharAtPos(final int llIllIllIllllIl, final char llIllIllIlllIII, final boolean llIllIllIlllIll) {
        return (llIllIllIlllIII == ' ') ? (this.unicodeFlag ? 4.0f : this.charWidth[llIllIllIlllIII]) : ((llIllIllIlllIII == ' ') ? 4.0f : (("\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8£\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1ªº¿®¬½¼¡«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f²\u25a0\u0000".indexOf(llIllIllIlllIII) != -1 && !this.unicodeFlag) ? this.renderDefaultChar(llIllIllIllllIl, llIllIllIlllIll) : this.renderUnicodeChar(llIllIllIlllIII, llIllIllIlllIll)));
    }
    
    private static boolean isFormatSpecial(final char llIlIlllIllIIIl) {
        return (llIlIlllIllIIIl >= 'k' && llIlIlllIllIIIl <= 'o') || (llIlIlllIllIIIl >= 'K' && llIlIlllIllIIIl <= 'O') || llIlIlllIllIIIl == 'r' || llIlIlllIllIIIl == 'R';
    }
    
    protected void bindTexture(final ResourceLocation llIlIlllIIIIIIl) {
        this.renderEngine.bindTexture(llIlIlllIIIIIIl);
    }
    
    private void loadGlyphTexture(final int llIllIllIIllIII) {
        this.bindTexture(this.getUnicodePageLocation(llIllIllIIllIII));
    }
    
    public boolean getBidiFlag() {
        return this.bidiFlag;
    }
    
    protected InputStream getResourceInputStream(final ResourceLocation llIlIllIllllIll) throws IOException {
        return Minecraft.getMinecraft().getResourceManager().getResource(llIlIllIllllIll).getInputStream();
    }
    
    private String bidiReorder(final String llIllIlIIlllIIl) {
        try {
            final Bidi llIllIlIIlllIll = new Bidi(new ArabicShaping(8).shape(llIllIlIIlllIIl), 127);
            llIllIlIIlllIll.setReorderingMode(0);
            return llIllIlIIlllIll.writeReordered(2);
        }
        catch (ArabicShapingException llIllIlIIlllIlI) {
            return llIllIlIIlllIIl;
        }
    }
    
    public int getStringWidth(final String llIllIIllIlIIII) {
        if (llIllIIllIlIIII == null) {
            return 0;
        }
        float llIllIIllIlIllI = 0.0f;
        boolean llIllIIllIlIlIl = false;
        for (int llIllIIllIlIlII = 0; llIllIIllIlIlII < llIllIIllIlIIII.length(); ++llIllIIllIlIlII) {
            char llIllIIllIlIIll = llIllIIllIlIIII.charAt(llIllIIllIlIlII);
            float llIllIIllIlIIlI = this.getCharWidthFloat(llIllIIllIlIIll);
            if (llIllIIllIlIIlI < 0.0f && llIllIIllIlIlII < llIllIIllIlIIII.length() - 1) {
                ++llIllIIllIlIlII;
                llIllIIllIlIIll = llIllIIllIlIIII.charAt(llIllIIllIlIlII);
                if (llIllIIllIlIIll != 'l' && llIllIIllIlIIll != 'L') {
                    if (llIllIIllIlIIll == 'r' || llIllIIllIlIIll == 'R') {
                        llIllIIllIlIlIl = false;
                    }
                }
                else {
                    llIllIIllIlIlIl = true;
                }
                llIllIIllIlIIlI = 0.0f;
            }
            llIllIIllIlIllI += llIllIIllIlIIlI;
            if (llIllIIllIlIlIl && llIllIIllIlIIlI > 0.0f) {
                llIllIIllIlIllI += (this.unicodeFlag ? 1.0f : this.offsetBold);
            }
        }
        return (int)llIllIIllIlIllI;
    }
    
    public void setBidiFlag(final boolean llIllIIIIIIIllI) {
        this.bidiFlag = llIllIIIIIIIllI;
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llIlllIIIIlIlIl) {
        this.locationFontTexture = FontUtils.getHdFontLocation(this.locationFontTextureBase);
        for (int llIlllIIIIlIlII = 0; llIlllIIIIlIlII < FontRenderer.unicodePageLocations.length; ++llIlllIIIIlIlII) {
            FontRenderer.unicodePageLocations[llIlllIIIIlIlII] = null;
        }
        this.readFontTexture();
        this.readGlyphSizes();
    }
    
    private void resetStyles() {
        this.randomStyle = false;
        this.boldStyle = false;
        this.italicStyle = false;
        this.underlineStyle = false;
        this.strikethroughStyle = false;
    }
    
    public int splitStringWidth(final String llIllIIIIlIIlIl, final int llIllIIIIlIIlII) {
        return this.FONT_HEIGHT * this.listFormattedStringToWidth(llIllIIIIlIIlIl, llIllIIIIlIIlII).size();
    }
    
    private float renderDefaultChar(final int llIllIllIlIIlll, final boolean llIllIllIlIIllI) {
        final float llIllIllIlIllII = (float)(llIllIllIlIIlll % 16 * 8);
        final float llIllIllIlIlIll = (float)(llIllIllIlIIlll / 16 * 8);
        final float llIllIllIlIlIlI = llIllIllIlIIllI ? 1.0f : 0.0f;
        this.bindTexture(this.locationFontTexture);
        final float llIllIllIlIlIIl = 7.99f;
        GL11.glBegin(5);
        GL11.glTexCoord2f(llIllIllIlIllII / 128.0f, llIllIllIlIlIll / 128.0f);
        GL11.glVertex3f(this.posX + llIllIllIlIlIlI, this.posY, 0.0f);
        GL11.glTexCoord2f(llIllIllIlIllII / 128.0f, (llIllIllIlIlIll + 7.99f) / 128.0f);
        GL11.glVertex3f(this.posX - llIllIllIlIlIlI, this.posY + 7.99f, 0.0f);
        GL11.glTexCoord2f((llIllIllIlIllII + llIllIllIlIlIIl - 1.0f) / 128.0f, llIllIllIlIlIll / 128.0f);
        GL11.glVertex3f(this.posX + llIllIllIlIlIIl - 1.0f + llIllIllIlIlIlI, this.posY, 0.0f);
        GL11.glTexCoord2f((llIllIllIlIllII + llIllIllIlIlIIl - 1.0f) / 128.0f, (llIllIllIlIlIll + 7.99f) / 128.0f);
        GL11.glVertex3f(this.posX + llIllIllIlIlIIl - 1.0f - llIllIllIlIlIlI, this.posY + 7.99f, 0.0f);
        GL11.glEnd();
        return this.charWidth[llIllIllIlIIlll];
    }
    
    public void setUnicodeFlag(final boolean llIllIIIIIlllIl) {
        this.unicodeFlag = llIllIIIIIlllIl;
    }
    
    public int func_175064_b(final char llIlIlllIIllIIl) {
        final int llIlIlllIIllIII = "0123456789abcdef".indexOf(llIlIlllIIllIIl);
        if (llIlIlllIIllIII >= 0 && llIlIlllIIllIII < this.colorCode.length) {
            int llIlIlllIIlIlll = this.colorCode[llIlIlllIIllIII];
            if (Config.isCustomColors()) {
                llIlIlllIIlIlll = CustomColors.getTextColor(llIlIlllIIllIII, llIlIlllIIlIlll);
            }
            return llIlIlllIIlIlll;
        }
        return 16777215;
    }
    
    public int drawStringWithShadow(final String llIllIlIllIlIII, final double llIllIlIllIIlll, final double llIllIlIllIlIll, final int llIllIlIllIlIlI) {
        return this.func_175065_a(llIllIlIllIlIII, (float)llIllIlIllIIlll, (float)llIllIlIllIlIll, llIllIlIllIlIlI, true);
    }
    
    public boolean getUnicodeFlag() {
        return this.unicodeFlag;
    }
    
    public FontRenderer(final GameSettings llIlllIIIllIIIl, final ResourceLocation llIlllIIIllIIII, final TextureManager llIlllIIIlIllll, final boolean llIlllIIIlIlllI) {
        this.charWidth = new float[256];
        this.FONT_HEIGHT = 9;
        this.fontRandom = new Random();
        this.glyphWidth = new byte[65536];
        this.colorCode = new int[32];
        this.enabled = true;
        this.offsetBold = 1.0f;
        this.gameSettings = llIlllIIIllIIIl;
        this.locationFontTextureBase = llIlllIIIllIIII;
        this.locationFontTexture = llIlllIIIllIIII;
        this.renderEngine = llIlllIIIlIllll;
        this.unicodeFlag = llIlllIIIlIlllI;
        this.locationFontTexture = FontUtils.getHdFontLocation(this.locationFontTextureBase);
        this.bindTexture(this.locationFontTexture);
        for (int llIlllIIIlIllIl = 0; llIlllIIIlIllIl < 32; ++llIlllIIIlIllIl) {
            final int llIlllIIIlIllII = (llIlllIIIlIllIl >> 3 & 0x1) * 85;
            int llIlllIIIlIlIll = (llIlllIIIlIllIl >> 2 & 0x1) * 170 + llIlllIIIlIllII;
            int llIlllIIIlIlIlI = (llIlllIIIlIllIl >> 1 & 0x1) * 170 + llIlllIIIlIllII;
            int llIlllIIIlIlIIl = (llIlllIIIlIllIl >> 0 & 0x1) * 170 + llIlllIIIlIllII;
            if (llIlllIIIlIllIl == 6) {
                llIlllIIIlIlIll += 85;
            }
            if (llIlllIIIllIIIl.anaglyph) {
                final int llIlllIIIlIlIII = (llIlllIIIlIlIll * 30 + llIlllIIIlIlIlI * 59 + llIlllIIIlIlIIl * 11) / 100;
                final int llIlllIIIlIIlll = (llIlllIIIlIlIll * 30 + llIlllIIIlIlIlI * 70) / 100;
                final int llIlllIIIlIIllI = (llIlllIIIlIlIll * 30 + llIlllIIIlIlIIl * 70) / 100;
                llIlllIIIlIlIll = llIlllIIIlIlIII;
                llIlllIIIlIlIlI = llIlllIIIlIIlll;
                llIlllIIIlIlIIl = llIlllIIIlIIllI;
            }
            if (llIlllIIIlIllIl >= 16) {
                llIlllIIIlIlIll /= 4;
                llIlllIIIlIlIlI /= 4;
                llIlllIIIlIlIIl /= 4;
            }
            this.colorCode[llIlllIIIlIllIl] = ((llIlllIIIlIlIll & 0xFF) << 16 | (llIlllIIIlIlIlI & 0xFF) << 8 | (llIlllIIIlIlIIl & 0xFF));
        }
        this.readGlyphSizes();
    }
    
    private void renderSplitString(final String llIllIIIIllIIIl, final int llIllIIIIllIIII, int llIllIIIIlIllll, final int llIllIIIIlllIII, final boolean llIllIIIIllIllI) {
        final List llIllIIIIllIlIl = this.listFormattedStringToWidth(llIllIIIIllIIIl, llIllIIIIlllIII);
        for (final String llIllIIIIllIIll : llIllIIIIllIlIl) {
            this.renderStringAligned(llIllIIIIllIIll, llIllIIIIllIIII, (int)llIllIIIIlIllll, llIllIIIIlllIII, this.textColor, llIllIIIIllIllI);
            llIllIIIIlIllll += this.FONT_HEIGHT;
        }
    }
    
    public String trimStringToWidth(final String llIllIIlIIllllI, final int llIllIIlIIlllIl, final boolean llIllIIlIIIllll) {
        final StringBuilder llIllIIlIIllIll = new StringBuilder();
        float llIllIIlIIllIlI = 0.0f;
        final int llIllIIlIIllIIl = llIllIIlIIIllll ? (llIllIIlIIllllI.length() - 1) : 0;
        final int llIllIIlIIllIII = llIllIIlIIIllll ? -1 : 1;
        boolean llIllIIlIIlIlll = false;
        boolean llIllIIlIIlIllI = false;
        for (int llIllIIlIIlIlIl = llIllIIlIIllIIl; llIllIIlIIlIlIl >= 0 && llIllIIlIIlIlIl < llIllIIlIIllllI.length() && llIllIIlIIllIlI < llIllIIlIIlllIl; llIllIIlIIlIlIl += llIllIIlIIllIII) {
            final char llIllIIlIIlIlII = llIllIIlIIllllI.charAt(llIllIIlIIlIlIl);
            final float llIllIIlIIlIIll = this.getCharWidthFloat(llIllIIlIIlIlII);
            if (llIllIIlIIlIlll) {
                llIllIIlIIlIlll = false;
                if (llIllIIlIIlIlII != 'l' && llIllIIlIIlIlII != 'L') {
                    if (llIllIIlIIlIlII == 'r' || llIllIIlIIlIlII == 'R') {
                        llIllIIlIIlIllI = false;
                    }
                }
                else {
                    llIllIIlIIlIllI = true;
                }
            }
            else if (llIllIIlIIlIIll < 0.0f) {
                llIllIIlIIlIlll = true;
            }
            else {
                llIllIIlIIllIlI += llIllIIlIIlIIll;
                if (llIllIIlIIlIllI) {
                    ++llIllIIlIIllIlI;
                }
            }
            if (llIllIIlIIllIlI > llIllIIlIIlllIl) {
                break;
            }
            if (llIllIIlIIIllll) {
                llIllIIlIIllIll.insert(0, llIllIIlIIlIlII);
            }
            else {
                llIllIIlIIllIll.append(llIllIIlIIlIlII);
            }
        }
        return String.valueOf(llIllIIlIIllIll);
    }
}
