package net.minecraft.client.renderer;

import java.awt.image.*;
import java.awt.*;

public class ImageBufferDownload implements IImageBuffer
{
    private /* synthetic */ int imageWidth;
    private /* synthetic */ int imageHeight;
    private /* synthetic */ int[] imageData;
    
    private void setAreaOpaque(final int lllllllllllllllIlIIIlIlIlllIllIl, final int lllllllllllllllIlIIIlIlIlllIllII, final int lllllllllllllllIlIIIlIlIlllIIlII, final int lllllllllllllllIlIIIlIlIlllIIIll) {
        for (int lllllllllllllllIlIIIlIlIlllIlIIl = lllllllllllllllIlIIIlIlIlllIllIl; lllllllllllllllIlIIIlIlIlllIlIIl < lllllllllllllllIlIIIlIlIlllIIlII; ++lllllllllllllllIlIIIlIlIlllIlIIl) {
            for (int lllllllllllllllIlIIIlIlIlllIlIII = lllllllllllllllIlIIIlIlIlllIllII; lllllllllllllllIlIIIlIlIlllIlIII < lllllllllllllllIlIIIlIlIlllIIIll; ++lllllllllllllllIlIIIlIlIlllIlIII) {
                final int[] imageData = this.imageData;
                final int n = lllllllllllllllIlIIIlIlIlllIlIIl + lllllllllllllllIlIIIlIlIlllIlIII * this.imageWidth;
                imageData[n] |= 0xFF000000;
            }
        }
    }
    
    private void setAreaTransparent(final int lllllllllllllllIlIIIlIlIlllllIll, final int lllllllllllllllIlIIIlIlIlllllIlI, final int lllllllllllllllIlIIIlIllIIIIIIII, final int lllllllllllllllIlIIIlIlIllllllll) {
        if (!this.hasTransparency(lllllllllllllllIlIIIlIlIlllllIll, lllllllllllllllIlIIIlIlIlllllIlI, lllllllllllllllIlIIIlIllIIIIIIII, lllllllllllllllIlIIIlIlIllllllll)) {
            for (int lllllllllllllllIlIIIlIlIlllllllI = lllllllllllllllIlIIIlIlIlllllIll; lllllllllllllllIlIIIlIlIlllllllI < lllllllllllllllIlIIIlIllIIIIIIII; ++lllllllllllllllIlIIIlIlIlllllllI) {
                for (int lllllllllllllllIlIIIlIlIllllllIl = lllllllllllllllIlIIIlIlIlllllIlI; lllllllllllllllIlIIIlIlIllllllIl < lllllllllllllllIlIIIlIlIllllllll; ++lllllllllllllllIlIIIlIlIllllllIl) {
                    final int[] imageData = this.imageData;
                    final int n = lllllllllllllllIlIIIlIlIlllllllI + lllllllllllllllIlIIIlIlIllllllIl * this.imageWidth;
                    imageData[n] &= 0xFFFFFF;
                }
            }
        }
    }
    
    @Override
    public void func_152634_a() {
    }
    
    private boolean hasTransparency(final int lllllllllllllllIlIIIlIlIllIlIlII, final int lllllllllllllllIlIIIlIlIllIlIIlI, final int lllllllllllllllIlIIIlIlIllIlIIII, final int lllllllllllllllIlIIIlIlIllIIlllI) {
        for (int lllllllllllllllIlIIIlIlIllIIllII = lllllllllllllllIlIIIlIlIllIlIlII; lllllllllllllllIlIIIlIlIllIIllII < lllllllllllllllIlIIIlIlIllIlIIII; ++lllllllllllllllIlIIIlIlIllIIllII) {
            for (int lllllllllllllllIlIIIlIlIllIIlIlI = lllllllllllllllIlIIIlIlIllIlIIlI; lllllllllllllllIlIIIlIlIllIIlIlI < lllllllllllllllIlIIIlIlIllIIlllI; ++lllllllllllllllIlIIIlIlIllIIlIlI) {
                final int lllllllllllllllIlIIIlIlIllIIlIIl = this.imageData[lllllllllllllllIlIIIlIlIllIIllII + lllllllllllllllIlIIIlIlIllIIlIlI * this.imageWidth];
                if ((lllllllllllllllIlIIIlIlIllIIlIIl >> 24 & 0xFF) < 128) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public BufferedImage parseUserSkin(final BufferedImage lllllllllllllllIlIIIlIllIIIlIIIl) {
        if (lllllllllllllllIlIIIlIllIIIlIIIl == null) {
            return null;
        }
        this.imageWidth = 64;
        this.imageHeight = 64;
        final int lllllllllllllllIlIIIlIllIIIlIlll = lllllllllllllllIlIIIlIllIIIlIIIl.getWidth();
        final int lllllllllllllllIlIIIlIllIIIlIllI = lllllllllllllllIlIIIlIllIIIlIIIl.getHeight();
        int lllllllllllllllIlIIIlIllIIIlIlIl = 1;
        while (this.imageWidth < lllllllllllllllIlIIIlIllIIIlIlll || this.imageHeight < lllllllllllllllIlIIIlIllIIIlIllI) {
            this.imageWidth *= 2;
            this.imageHeight *= 2;
            lllllllllllllllIlIIIlIllIIIlIlIl *= 2;
        }
        final BufferedImage lllllllllllllllIlIIIlIllIIIlIlII = new BufferedImage(this.imageWidth, this.imageHeight, 2);
        final Graphics lllllllllllllllIlIIIlIllIIIlIIll = lllllllllllllllIlIIIlIllIIIlIlII.getGraphics();
        lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIIIl, 0, 0, null);
        if (lllllllllllllllIlIIIlIllIIIlIIIl.getHeight() == 32 * lllllllllllllllIlIIIlIllIIIlIlIl) {
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 24 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 4 * lllllllllllllllIlIIIlIllIIIlIlIl, 16 * lllllllllllllllIlIIIlIllIIIlIlIl, 8 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 28 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 24 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 8 * lllllllllllllllIlIIIlIllIIIlIlIl, 16 * lllllllllllllllIlIIIlIllIIIlIlIl, 12 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 16 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 8 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 12 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 24 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 4 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 8 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 28 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 24 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 0 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 4 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 28 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 12 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 16 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 40 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 36 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 44 * lllllllllllllllIlIIIlIllIIIlIlIl, 16 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 44 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 40 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 16 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 36 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 40 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 36 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 44 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 44 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 40 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 40 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 44 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
            lllllllllllllllIlIIIlIllIIIlIIll.drawImage(lllllllllllllllIlIIIlIllIIIlIlII, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 44 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 52 * lllllllllllllllIlIIIlIllIIIlIlIl, 20 * lllllllllllllllIlIIIlIllIIIlIlIl, 56 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, null);
        }
        lllllllllllllllIlIIIlIllIIIlIIll.dispose();
        this.imageData = ((DataBufferInt)lllllllllllllllIlIIIlIllIIIlIlII.getRaster().getDataBuffer()).getData();
        this.setAreaOpaque(0, 0, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, 16 * lllllllllllllllIlIIIlIllIIIlIlIl);
        this.setAreaTransparent(32 * lllllllllllllllIlIIIlIllIIIlIlIl, 0, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl);
        this.setAreaOpaque(0, 16 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl);
        this.setAreaTransparent(0, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, 16 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl);
        this.setAreaTransparent(16 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, 40 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl);
        this.setAreaTransparent(40 * lllllllllllllllIlIIIlIllIIIlIlIl, 32 * lllllllllllllllIlIIIlIllIIIlIlIl, 56 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl);
        this.setAreaTransparent(0, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 16 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl);
        this.setAreaOpaque(16 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl);
        this.setAreaTransparent(48 * lllllllllllllllIlIIIlIllIIIlIlIl, 48 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl, 64 * lllllllllllllllIlIIIlIllIIIlIlIl);
        return lllllllllllllllIlIIIlIllIIIlIlII;
    }
}
