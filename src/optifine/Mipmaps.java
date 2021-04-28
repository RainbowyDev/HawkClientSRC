package optifine;

import java.nio.*;
import java.awt.*;
import java.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class Mipmaps
{
    private /* synthetic */ IntBuffer[] mipmapBuffers;
    private final /* synthetic */ boolean direct;
    private final /* synthetic */ String iconName;
    private /* synthetic */ Dimension[] mipmapDimensions;
    private final /* synthetic */ int width;
    private /* synthetic */ int[][] mipmapDatas;
    private final /* synthetic */ int height;
    private final /* synthetic */ int[] data;
    
    public static int[][] generateMipMapData(final int[] llllllllllllllIIllIIllIIIIlllIIl, final int llllllllllllllIIllIIllIIIIlllIII, final int llllllllllllllIIllIIllIIIIllIlll, final Dimension[] llllllllllllllIIllIIllIIIIllIllI) {
        int[] llllllllllllllIIllIIllIIIIllIlIl = llllllllllllllIIllIIllIIIIlllIIl;
        int llllllllllllllIIllIIllIIIIllIlII = llllllllllllllIIllIIllIIIIlllIII;
        boolean llllllllllllllIIllIIllIIIIllIIll = true;
        final int[][] llllllllllllllIIllIIllIIIIllIIlI = new int[llllllllllllllIIllIIllIIIIllIllI.length][];
        for (int llllllllllllllIIllIIllIIIIllIIIl = 0; llllllllllllllIIllIIllIIIIllIIIl < llllllllllllllIIllIIllIIIIllIllI.length; ++llllllllllllllIIllIIllIIIIllIIIl) {
            final Dimension llllllllllllllIIllIIllIIIIllIIII = llllllllllllllIIllIIllIIIIllIllI[llllllllllllllIIllIIllIIIIllIIIl];
            final int llllllllllllllIIllIIllIIIIlIllll = llllllllllllllIIllIIllIIIIllIIII.width;
            final int llllllllllllllIIllIIllIIIIlIlllI = llllllllllllllIIllIIllIIIIllIIII.height;
            final int[] llllllllllllllIIllIIllIIIIlIllIl = new int[llllllllllllllIIllIIllIIIIlIllll * llllllllllllllIIllIIllIIIIlIlllI];
            llllllllllllllIIllIIllIIIIllIIlI[llllllllllllllIIllIIllIIIIllIIIl] = llllllllllllllIIllIIllIIIIlIllIl;
            final int llllllllllllllIIllIIllIIIIlIllII = llllllllllllllIIllIIllIIIIllIIIl + 1;
            if (llllllllllllllIIllIIllIIIIllIIll) {
                for (int llllllllllllllIIllIIllIIIIlIlIll = 0; llllllllllllllIIllIIllIIIIlIlIll < llllllllllllllIIllIIllIIIIlIllll; ++llllllllllllllIIllIIllIIIIlIlIll) {
                    for (int llllllllllllllIIllIIllIIIIlIlIlI = 0; llllllllllllllIIllIIllIIIIlIlIlI < llllllllllllllIIllIIllIIIIlIlllI; ++llllllllllllllIIllIIllIIIIlIlIlI) {
                        final int llllllllllllllIIllIIllIIIIlIlIIl = llllllllllllllIIllIIllIIIIllIlIl[llllllllllllllIIllIIllIIIIlIlIll * 2 + 0 + (llllllllllllllIIllIIllIIIIlIlIlI * 2 + 0) * llllllllllllllIIllIIllIIIIllIlII];
                        final int llllllllllllllIIllIIllIIIIlIlIII = llllllllllllllIIllIIllIIIIllIlIl[llllllllllllllIIllIIllIIIIlIlIll * 2 + 1 + (llllllllllllllIIllIIllIIIIlIlIlI * 2 + 0) * llllllllllllllIIllIIllIIIIllIlII];
                        final int llllllllllllllIIllIIllIIIIlIIlll = llllllllllllllIIllIIllIIIIllIlIl[llllllllllllllIIllIIllIIIIlIlIll * 2 + 1 + (llllllllllllllIIllIIllIIIIlIlIlI * 2 + 1) * llllllllllllllIIllIIllIIIIllIlII];
                        final int llllllllllllllIIllIIllIIIIlIIllI = llllllllllllllIIllIIllIIIIllIlIl[llllllllllllllIIllIIllIIIIlIlIll * 2 + 0 + (llllllllllllllIIllIIllIIIIlIlIlI * 2 + 1) * llllllllllllllIIllIIllIIIIllIlII];
                        final int llllllllllllllIIllIIllIIIIlIIlIl = alphaBlend(llllllllllllllIIllIIllIIIIlIlIIl, llllllllllllllIIllIIllIIIIlIlIII, llllllllllllllIIllIIllIIIIlIIlll, llllllllllllllIIllIIllIIIIlIIllI);
                        llllllllllllllIIllIIllIIIIlIllIl[llllllllllllllIIllIIllIIIIlIlIll + llllllllllllllIIllIIllIIIIlIlIlI * llllllllllllllIIllIIllIIIIlIllll] = llllllllllllllIIllIIllIIIIlIIlIl;
                    }
                }
            }
            llllllllllllllIIllIIllIIIIllIlIl = llllllllllllllIIllIIllIIIIlIllIl;
            llllllllllllllIIllIIllIIIIllIlII = llllllllllllllIIllIIllIIIIlIllll;
            if (llllllllllllllIIllIIllIIIIlIllll <= 1 || llllllllllllllIIllIIllIIIIlIlllI <= 1) {
                llllllllllllllIIllIIllIIIIllIIll = false;
            }
        }
        return llllllllllllllIIllIIllIIIIllIIlI;
    }
    
    public static Dimension[] makeMipmapDimensions(final int llllllllllllllIIllIIllIIIllIIIlI, final int llllllllllllllIIllIIllIIIlIlIllI, final String llllllllllllllIIllIIllIIIlIlIlIl) {
        final int llllllllllllllIIllIIllIIIlIlllll = TextureUtils.ceilPowerOfTwo(llllllllllllllIIllIIllIIIllIIIlI);
        final int llllllllllllllIIllIIllIIIlIllllI = TextureUtils.ceilPowerOfTwo(llllllllllllllIIllIIllIIIlIlIllI);
        if (llllllllllllllIIllIIllIIIlIlllll == llllllllllllllIIllIIllIIIllIIIlI && llllllllllllllIIllIIllIIIlIllllI == llllllllllllllIIllIIllIIIlIlIllI) {
            final ArrayList llllllllllllllIIllIIllIIIlIlllIl = new ArrayList();
            int llllllllllllllIIllIIllIIIlIlllII = llllllllllllllIIllIIllIIIlIlllll;
            int llllllllllllllIIllIIllIIIlIllIll = llllllllllllllIIllIIllIIIlIllllI;
            while (true) {
                llllllllllllllIIllIIllIIIlIlllII /= 2;
                llllllllllllllIIllIIllIIIlIllIll /= 2;
                if (llllllllllllllIIllIIllIIIlIlllII <= 0 && llllllllllllllIIllIIllIIIlIllIll <= 0) {
                    break;
                }
                if (llllllllllllllIIllIIllIIIlIlllII <= 0) {
                    llllllllllllllIIllIIllIIIlIlllII = 1;
                }
                if (llllllllllllllIIllIIllIIIlIllIll <= 0) {
                    llllllllllllllIIllIIllIIIlIllIll = 1;
                }
                final int llllllllllllllIIllIIllIIIlIllIIl = llllllllllllllIIllIIllIIIlIlllII * llllllllllllllIIllIIllIIIlIllIll * 4;
                final Dimension llllllllllllllIIllIIllIIIlIllIII = new Dimension(llllllllllllllIIllIIllIIIlIlllII, llllllllllllllIIllIIllIIIlIllIll);
                llllllllllllllIIllIIllIIIlIlllIl.add(llllllllllllllIIllIIllIIIlIllIII);
            }
            final Dimension[] llllllllllllllIIllIIllIIIlIllIlI = llllllllllllllIIllIIllIIIlIlllIl.toArray(new Dimension[llllllllllllllIIllIIllIIIlIlllIl.size()]);
            return llllllllllllllIIllIIllIIIlIllIlI;
        }
        Config.warn(String.valueOf(new StringBuilder("Mipmaps not possible (power of 2 dimensions needed), texture: ").append(llllllllllllllIIllIIllIIIlIlIlIl).append(", dim: ").append(llllllllllllllIIllIIllIIIllIIIlI).append("x").append(llllllllllllllIIllIIllIIIlIlIllI)));
        return new Dimension[0];
    }
    
    private static int alphaBlend(int llllllllllllllIIllIIlIllllIlllll, int llllllllllllllIIllIIlIllllIllllI) {
        int llllllllllllllIIllIIlIlllllIlIll = (int)((llllllllllllllIIllIIlIllllIlllll & 0xFF000000) >> 24 & 0xFF);
        int llllllllllllllIIllIIlIlllllIlIlI = (llllllllllllllIIllIIlIllllIllllI & 0xFF000000) >> 24 & 0xFF;
        int llllllllllllllIIllIIlIlllllIlIIl = (llllllllllllllIIllIIlIlllllIlIll + llllllllllllllIIllIIlIlllllIlIlI) / 2;
        if (llllllllllllllIIllIIlIlllllIlIll == 0 && llllllllllllllIIllIIlIlllllIlIlI == 0) {
            llllllllllllllIIllIIlIlllllIlIll = 1;
            llllllllllllllIIllIIlIlllllIlIlI = 1;
        }
        else {
            if (llllllllllllllIIllIIlIlllllIlIll == 0) {
                llllllllllllllIIllIIlIllllIlllll = llllllllllllllIIllIIlIllllIllllI;
                llllllllllllllIIllIIlIlllllIlIIl /= 2;
            }
            if (llllllllllllllIIllIIlIlllllIlIlI == 0) {
                llllllllllllllIIllIIlIllllIllllI = (int)llllllllllllllIIllIIlIllllIlllll;
                llllllllllllllIIllIIlIlllllIlIIl /= 2;
            }
        }
        final int llllllllllllllIIllIIlIlllllIlIII = (int)((llllllllllllllIIllIIlIllllIlllll >> 16 & 0xFF) * llllllllllllllIIllIIlIlllllIlIll);
        final int llllllllllllllIIllIIlIlllllIIlll = (int)((llllllllllllllIIllIIlIllllIlllll >> 8 & 0xFF) * llllllllllllllIIllIIlIlllllIlIll);
        final int llllllllllllllIIllIIlIlllllIIllI = (int)((llllllllllllllIIllIIlIllllIlllll & 0xFF) * llllllllllllllIIllIIlIlllllIlIll);
        final int llllllllllllllIIllIIlIlllllIIlIl = (llllllllllllllIIllIIlIllllIllllI >> 16 & 0xFF) * llllllllllllllIIllIIlIlllllIlIlI;
        final int llllllllllllllIIllIIlIlllllIIlII = (llllllllllllllIIllIIlIllllIllllI >> 8 & 0xFF) * llllllllllllllIIllIIlIlllllIlIlI;
        final int llllllllllllllIIllIIlIlllllIIIll = (llllllllllllllIIllIIlIllllIllllI & 0xFF) * llllllllllllllIIllIIlIlllllIlIlI;
        final int llllllllllllllIIllIIlIlllllIIIlI = (llllllllllllllIIllIIlIlllllIlIII + llllllllllllllIIllIIlIlllllIIlIl) / (llllllllllllllIIllIIlIlllllIlIll + llllllllllllllIIllIIlIlllllIlIlI);
        final int llllllllllllllIIllIIlIlllllIIIIl = (llllllllllllllIIllIIlIlllllIIlll + llllllllllllllIIllIIlIlllllIIlII) / (llllllllllllllIIllIIlIlllllIlIll + llllllllllllllIIllIIlIlllllIlIlI);
        final int llllllllllllllIIllIIlIlllllIIIII = (llllllllllllllIIllIIlIlllllIIllI + llllllllllllllIIllIIlIlllllIIIll) / (llllllllllllllIIllIIlIlllllIlIll + llllllllllllllIIllIIlIlllllIlIlI);
        return llllllllllllllIIllIIlIlllllIlIIl << 24 | llllllllllllllIIllIIlIlllllIIIlI << 16 | llllllllllllllIIllIIlIlllllIIIIl << 8 | llllllllllllllIIllIIlIlllllIIIII;
    }
    
    private int averageColor(final int llllllllllllllIIllIIlIllllIIllII, final int llllllllllllllIIllIIlIllllIIIlll) {
        final int llllllllllllllIIllIIlIllllIIlIlI = (llllllllllllllIIllIIlIllllIIllII & 0xFF000000) >> 24 & 0xFF;
        final int llllllllllllllIIllIIlIllllIIlIIl = (llllllllllllllIIllIIlIllllIIIlll & 0xFF000000) >> 24 & 0xFF;
        return (llllllllllllllIIllIIlIllllIIlIlI + llllllllllllllIIllIIlIllllIIlIIl >> 1 << 24) + ((llllllllllllllIIllIIlIllllIIllII & 0xFEFEFE) + (llllllllllllllIIllIIlIllllIIIlll & 0xFEFEFE) >> 1);
    }
    
    public static int alphaBlend(final int llllllllllllllIIllIIllIIIIIIlIIl, final int llllllllllllllIIllIIllIIIIIIIIIl, final int llllllllllllllIIllIIllIIIIIIIIII, final int llllllllllllllIIllIIllIIIIIIIllI) {
        final int llllllllllllllIIllIIllIIIIIIIlIl = alphaBlend(llllllllllllllIIllIIllIIIIIIlIIl, llllllllllllllIIllIIllIIIIIIIIIl);
        final int llllllllllllllIIllIIllIIIIIIIlII = alphaBlend(llllllllllllllIIllIIllIIIIIIIIII, llllllllllllllIIllIIllIIIIIIIllI);
        final int llllllllllllllIIllIIllIIIIIIIIll = alphaBlend(llllllllllllllIIllIIllIIIIIIIlIl, llllllllllllllIIllIIllIIIIIIIlII);
        return llllllllllllllIIllIIllIIIIIIIIll;
    }
    
    public static void allocateMipmapTextures(final int llllllllllllllIIllIIlIlllIlIIIll, final int llllllllllllllIIllIIlIlllIlIIIlI, final String llllllllllllllIIllIIlIlllIlIIIIl) {
        final Dimension[] llllllllllllllIIllIIlIlllIlIIIII = makeMipmapDimensions(llllllllllllllIIllIIlIlllIlIIIll, llllllllllllllIIllIIlIlllIlIIIlI, llllllllllllllIIllIIlIlllIlIIIIl);
        for (int llllllllllllllIIllIIlIlllIIlllll = 0; llllllllllllllIIllIIlIlllIIlllll < llllllllllllllIIllIIlIlllIlIIIII.length; ++llllllllllllllIIllIIlIlllIIlllll) {
            final Dimension llllllllllllllIIllIIlIlllIIllllI = llllllllllllllIIllIIlIlllIlIIIII[llllllllllllllIIllIIlIlllIIlllll];
            final int llllllllllllllIIllIIlIlllIIlllIl = llllllllllllllIIllIIlIlllIIllllI.width;
            final int llllllllllllllIIllIIlIlllIIlllII = llllllllllllllIIllIIlIlllIIllllI.height;
            final int llllllllllllllIIllIIlIlllIIllIll = llllllllllllllIIllIIlIlllIIlllll + 1;
            GL11.glTexImage2D(3553, llllllllllllllIIllIIlIlllIIllIll, 6408, llllllllllllllIIllIIlIlllIIlllIl, llllllllllllllIIllIIlIlllIIlllII, 0, 32993, 33639, (IntBuffer)null);
        }
    }
    
    public Mipmaps(final String llllllllllllllIIllIIllIIIlllIIIl, final int llllllllllllllIIllIIllIIIlllIllI, final int llllllllllllllIIllIIllIIIllIllll, final int[] llllllllllllllIIllIIllIIIlllIlII, final boolean llllllllllllllIIllIIllIIIllIllIl) {
        this.iconName = llllllllllllllIIllIIllIIIlllIIIl;
        this.width = llllllllllllllIIllIIllIIIlllIllI;
        this.height = llllllllllllllIIllIIllIIIllIllll;
        this.data = llllllllllllllIIllIIllIIIlllIlII;
        this.direct = llllllllllllllIIllIIllIIIllIllIl;
        this.mipmapDimensions = makeMipmapDimensions(llllllllllllllIIllIIllIIIlllIllI, llllllllllllllIIllIIllIIIllIllll, llllllllllllllIIllIIllIIIlllIIIl);
        this.mipmapDatas = generateMipMapData(llllllllllllllIIllIIllIIIlllIlII, llllllllllllllIIllIIllIIIlllIllI, llllllllllllllIIllIIllIIIllIllll, this.mipmapDimensions);
        if (llllllllllllllIIllIIllIIIllIllIl) {
            this.mipmapBuffers = makeMipmapBuffers(this.mipmapDimensions, this.mipmapDatas);
        }
    }
    
    public static IntBuffer[] makeMipmapBuffers(final Dimension[] llllllllllllllIIllIIlIlllIllIlII, final int[][] llllllllllllllIIllIIlIlllIllIIll) {
        if (llllllllllllllIIllIIlIlllIllIlII == null) {
            return null;
        }
        final IntBuffer[] llllllllllllllIIllIIlIlllIlllIlI = new IntBuffer[llllllllllllllIIllIIlIlllIllIlII.length];
        for (int llllllllllllllIIllIIlIlllIlllIIl = 0; llllllllllllllIIllIIlIlllIlllIIl < llllllllllllllIIllIIlIlllIllIlII.length; ++llllllllllllllIIllIIlIlllIlllIIl) {
            final Dimension llllllllllllllIIllIIlIlllIlllIII = llllllllllllllIIllIIlIlllIllIlII[llllllllllllllIIllIIlIlllIlllIIl];
            final int llllllllllllllIIllIIlIlllIllIlll = llllllllllllllIIllIIlIlllIlllIII.width * llllllllllllllIIllIIlIlllIlllIII.height;
            final IntBuffer llllllllllllllIIllIIlIlllIllIllI = GLAllocation.createDirectIntBuffer(llllllllllllllIIllIIlIlllIllIlll);
            final int[] llllllllllllllIIllIIlIlllIllIlIl = llllllllllllllIIllIIlIlllIllIIll[llllllllllllllIIllIIlIlllIlllIIl];
            llllllllllllllIIllIIlIlllIllIllI.clear();
            llllllllllllllIIllIIlIlllIllIllI.put(llllllllllllllIIllIIlIlllIllIlIl);
            llllllllllllllIIllIIlIlllIllIllI.clear();
            llllllllllllllIIllIIlIlllIlllIlI[llllllllllllllIIllIIlIlllIlllIIl] = llllllllllllllIIllIIlIlllIllIllI;
        }
        return llllllllllllllIIllIIlIlllIlllIlI;
    }
}
