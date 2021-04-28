package net.minecraft.client.renderer.texture;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.client.resources.*;
import java.io.*;
import org.apache.logging.log4j.*;

public class LayeredColorMaskTexture extends AbstractTexture
{
    private final /* synthetic */ ResourceLocation field_174948_g;
    private final /* synthetic */ List field_174950_i;
    private final /* synthetic */ List field_174949_h;
    
    public LayeredColorMaskTexture(final ResourceLocation llllllllllllllIlIlIlllIIlIlIIlII, final List llllllllllllllIlIlIlllIIlIlIIlll, final List llllllllllllllIlIlIlllIIlIlIIIlI) {
        this.field_174948_g = llllllllllllllIlIlIlllIIlIlIIlII;
        this.field_174949_h = llllllllllllllIlIlIlllIIlIlIIlll;
        this.field_174950_i = llllllllllllllIlIlIlllIIlIlIIIlI;
    }
    
    @Override
    public void loadTexture(final IResourceManager llllllllllllllIlIlIlllIIIlllllII) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/texture/LayeredColorMaskTexture.deleteGlTexture:()V
        //     4: aload_1         /* llllllllllllllIlIlIlllIIlIIIllll */
        //     5: aload_0         /* llllllllllllllIlIlIlllIIIlllllIl */
        //     6: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.field_174948_g:Lnet/minecraft/util/ResourceLocation;
        //     9: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //    14: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    19: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.func_177053_a:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    22: astore_3        /* llllllllllllllIlIlIlllIIlIIIllII */
        //    23: aload_3         /* llllllllllllllIlIlIlllIIlIIIllII */
        //    24: invokevirtual   java/awt/image/BufferedImage.getType:()I
        //    27: istore          llllllllllllllIlIlIlllIIlIIIlIll
        //    29: iload           llllllllllllllIlIlIlllIIlIIIlIll
        //    31: ifne            38
        //    34: bipush          6
        //    36: istore          llllllllllllllIlIlIlllIIlIIIlIll
        //    38: new             Ljava/awt/image/BufferedImage;
        //    41: dup            
        //    42: aload_3         /* llllllllllllllIlIlIlllIIlIIIllII */
        //    43: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    46: aload_3         /* llllllllllllllIlIlIlllIIlIIIllII */
        //    47: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    50: iload           llllllllllllllIlIlIlllIIlIIIlIll
        //    52: invokespecial   java/awt/image/BufferedImage.<init>:(III)V
        //    55: astore_2        /* llllllllllllllIlIlIlllIIIllllIll */
        //    56: aload_2         /* llllllllllllllIlIlIlllIIlIIIlllI */
        //    57: invokevirtual   java/awt/image/BufferedImage.getGraphics:()Ljava/awt/Graphics;
        //    60: astore          llllllllllllllIlIlIlllIIlIIIlIlI
        //    62: aload           llllllllllllllIlIlIlllIIlIIIlIlI
        //    64: aload_3         /* llllllllllllllIlIlIlllIIlIIIllII */
        //    65: iconst_0       
        //    66: iconst_0       
        //    67: aconst_null    
        //    68: invokevirtual   java/awt/Graphics.drawImage:(Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
        //    71: pop            
        //    72: iconst_0       
        //    73: istore          llllllllllllllIlIlIlllIIlIIIlIIl
        //    75: goto            306
        //    78: aload_0         /* llllllllllllllIlIlIlllIIIlllllIl */
        //    79: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.field_174949_h:Ljava/util/List;
        //    82: iload           llllllllllllllIlIlIlllIIlIIIlIIl
        //    84: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //    89: checkcast       Ljava/lang/String;
        //    92: astore          llllllllllllllIlIlIlllIIlIIIlIII
        //    94: aload_0         /* llllllllllllllIlIlIlllIIIlllllIl */
        //    95: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.field_174950_i:Ljava/util/List;
        //    98: iload           llllllllllllllIlIlIlllIIlIIIlIIl
        //   100: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   105: checkcast       Lnet/minecraft/item/EnumDyeColor;
        //   108: invokevirtual   net/minecraft/item/EnumDyeColor.func_176768_e:()Lnet/minecraft/block/material/MapColor;
        //   111: astore          llllllllllllllIlIlIlllIIlIIIIlll
        //   113: aload           llllllllllllllIlIlIlllIIlIIIlIII
        //   115: ifnull          303
        //   118: aload_1         /* llllllllllllllIlIlIlllIIlIIIllll */
        //   119: new             Lnet/minecraft/util/ResourceLocation;
        //   122: dup            
        //   123: aload           llllllllllllllIlIlIlllIIlIIIlIII
        //   125: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
        //   128: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //   133: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //   138: astore          llllllllllllllIlIlIlllIIlIIIIllI
        //   140: aload           llllllllllllllIlIlIlllIIlIIIIllI
        //   142: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.func_177053_a:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //   145: astore          llllllllllllllIlIlIlllIIlIIIIlIl
        //   147: aload           llllllllllllllIlIlIlllIIlIIIIlIl
        //   149: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   152: aload_2         /* llllllllllllllIlIlIlllIIlIIIlllI */
        //   153: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   156: if_icmpne       303
        //   159: aload           llllllllllllllIlIlIlllIIlIIIIlIl
        //   161: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   164: aload_2         /* llllllllllllllIlIlIlllIIlIIIlllI */
        //   165: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   168: if_icmpne       303
        //   171: aload           llllllllllllllIlIlIlllIIlIIIIlIl
        //   173: invokevirtual   java/awt/image/BufferedImage.getType:()I
        //   176: bipush          6
        //   178: if_icmpne       303
        //   181: iconst_0       
        //   182: istore          llllllllllllllIlIlIlllIIlIIIIlII
        //   184: goto            280
        //   187: iconst_0       
        //   188: istore          llllllllllllllIlIlIlllIIlIIIIIll
        //   190: goto            267
        //   193: aload           llllllllllllllIlIlIlllIIlIIIIlIl
        //   195: iload           llllllllllllllIlIlIlllIIlIIIIIll
        //   197: iload           llllllllllllllIlIlIlllIIlIIIIlII
        //   199: invokevirtual   java/awt/image/BufferedImage.getRGB:(II)I
        //   202: istore          llllllllllllllIlIlIlllIIlIIIIIlI
        //   204: iload           llllllllllllllIlIlIlllIIlIIIIIlI
        //   206: ldc             -16777216
        //   208: iand           
        //   209: ifeq            264
        //   212: iload           llllllllllllllIlIlIlllIIlIIIIIlI
        //   214: ldc             16711680
        //   216: iand           
        //   217: bipush          8
        //   219: ishl           
        //   220: ldc             -16777216
        //   222: iand           
        //   223: istore          llllllllllllllIlIlIlllIIlIIIIIIl
        //   225: aload_3         /* llllllllllllllIlIlIlllIIlIIIllII */
        //   226: iload           llllllllllllllIlIlIlllIIlIIIIIll
        //   228: iload           llllllllllllllIlIlIlllIIlIIIIlII
        //   230: invokevirtual   java/awt/image/BufferedImage.getRGB:(II)I
        //   233: istore          llllllllllllllIlIlIlllIIlIIIIIII
        //   235: iload           llllllllllllllIlIlIlllIIlIIIIIII
        //   237: aload           llllllllllllllIlIlIlllIIlIIIIlll
        //   239: getfield        net/minecraft/block/material/MapColor.colorValue:I
        //   242: invokestatic    net/minecraft/util/MathHelper.func_180188_d:(II)I
        //   245: ldc             16777215
        //   247: iand           
        //   248: istore          llllllllllllllIlIlIlllIIIlllllll
        //   250: aload           llllllllllllllIlIlIlllIIlIIIIlIl
        //   252: iload           llllllllllllllIlIlIlllIIlIIIIIll
        //   254: iload           llllllllllllllIlIlIlllIIlIIIIlII
        //   256: iload           llllllllllllllIlIlIlllIIlIIIIIIl
        //   258: iload           llllllllllllllIlIlIlllIIIlllllll
        //   260: ior            
        //   261: invokevirtual   java/awt/image/BufferedImage.setRGB:(III)V
        //   264: iinc            llllllllllllllIlIlIlllIIlIIIIIll, 1
        //   267: iload           llllllllllllllIlIlIlllIIlIIIIIll
        //   269: aload           llllllllllllllIlIlIlllIIlIIIIlIl
        //   271: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   274: if_icmplt       193
        //   277: iinc            llllllllllllllIlIlIlllIIlIIIIlII, 1
        //   280: iload           llllllllllllllIlIlIlllIIlIIIIlII
        //   282: aload           llllllllllllllIlIlIlllIIlIIIIlIl
        //   284: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   287: if_icmplt       187
        //   290: aload_2         /* llllllllllllllIlIlIlllIIlIIIlllI */
        //   291: invokevirtual   java/awt/image/BufferedImage.getGraphics:()Ljava/awt/Graphics;
        //   294: aload           llllllllllllllIlIlIlllIIlIIIIlIl
        //   296: iconst_0       
        //   297: iconst_0       
        //   298: aconst_null    
        //   299: invokevirtual   java/awt/Graphics.drawImage:(Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
        //   302: pop            
        //   303: iinc            llllllllllllllIlIlIlllIIlIIIlIIl, 1
        //   306: iload           llllllllllllllIlIlIlllIIlIIIlIIl
        //   308: aload_0         /* llllllllllllllIlIlIlllIIIlllllIl */
        //   309: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.field_174949_h:Ljava/util/List;
        //   312: invokeinterface java/util/List.size:()I
        //   317: if_icmpge       350
        //   320: iload           llllllllllllllIlIlIlllIIlIIIlIIl
        //   322: aload_0         /* llllllllllllllIlIlIlllIIIlllllIl */
        //   323: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.field_174950_i:Ljava/util/List;
        //   326: invokeinterface java/util/List.size:()I
        //   331: if_icmplt       78
        //   334: goto            350
        //   337: astore_3        /* llllllllllllllIlIlIlllIIIllllllI */
        //   338: getstatic       net/minecraft/client/renderer/texture/LayeredColorMaskTexture.field_174947_f:Lorg/apache/logging/log4j/Logger;
        //   341: ldc             "Couldn't load layered image"
        //   343: aload_3         /* llllllllllllllIlIlIlllIIIllllllI */
        //   344: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   349: return         
        //   350: aload_0         /* llllllllllllllIlIlIlllIIIlllllIl */
        //   351: invokevirtual   net/minecraft/client/renderer/texture/LayeredColorMaskTexture.getGlTextureId:()I
        //   354: aload_2         /* llllllllllllllIlIlIlllIIlIIIllIl */
        //   355: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.uploadTextureImage:(ILjava/awt/image/BufferedImage;)I
        //   358: pop            
        //   359: return         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 0B FE 00 26 00 07 00 3E 01 FF 00 27 00 07 07 00 02 07 00 2C 07 00 3E 07 00 3E 01 07 00 51 01 00 00 FF 00 6C 00 0C 07 00 02 07 00 2C 07 00 3E 07 00 3E 01 07 00 51 01 07 00 5D 07 00 70 07 00 C2 07 00 3E 01 00 00 FC 00 05 01 FC 00 46 01 FA 00 02 FA 00 0C F8 00 16 F9 00 02 FF 00 1E 00 02 07 00 02 07 00 2C 00 01 07 00 27 FF 00 0C 00 07 07 00 02 07 00 2C 07 00 3E 07 00 3E 01 07 00 51 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      334    337    350    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        __OBFID = "CL_00002404";
        field_174947_f = LogManager.getLogger();
    }
}
