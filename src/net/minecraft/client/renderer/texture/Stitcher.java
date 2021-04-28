package net.minecraft.client.renderer.texture;

import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import java.util.*;

public class Stitcher
{
    private final /* synthetic */ int maxWidth;
    private final /* synthetic */ int maxTileDimension;
    private final /* synthetic */ int maxHeight;
    private final /* synthetic */ List stitchSlots;
    private /* synthetic */ int currentWidth;
    private /* synthetic */ int currentHeight;
    private final /* synthetic */ int mipmapLevelStitcher;
    private final /* synthetic */ Set setStitchHolders;
    private final /* synthetic */ boolean forcePowerOf2;
    
    public Stitcher(final int lllllllllllllllIlllIllIlIIllIllI, final int lllllllllllllllIlllIllIlIIlIllll, final boolean lllllllllllllllIlllIllIlIIlIlllI, final int lllllllllllllllIlllIllIlIIllIIll, final int lllllllllllllllIlllIllIlIIlIllII) {
        this.setStitchHolders = Sets.newHashSetWithExpectedSize(256);
        this.stitchSlots = Lists.newArrayListWithCapacity(256);
        this.mipmapLevelStitcher = lllllllllllllllIlllIllIlIIlIllII;
        this.maxWidth = lllllllllllllllIlllIllIlIIllIllI;
        this.maxHeight = lllllllllllllllIlllIllIlIIlIllll;
        this.forcePowerOf2 = lllllllllllllllIlllIllIlIIlIlllI;
        this.maxTileDimension = lllllllllllllllIlllIllIlIIllIIll;
    }
    
    private boolean expandAndAllocateSlot(final Holder lllllllllllllllIlllIllIIlIllllIl) {
        final int lllllllllllllllIlllIllIIllIlIIII = Math.min(lllllllllllllllIlllIllIIlIllllIl.getWidth(), lllllllllllllllIlllIllIIlIllllIl.getHeight());
        final boolean lllllllllllllllIlllIllIIllIIllll = this.currentWidth == 0 && this.currentHeight == 0;
        boolean lllllllllllllllIlllIllIIllIIllII;
        if (this.forcePowerOf2) {
            final int lllllllllllllllIlllIllIIllIIlIll = MathHelper.roundUpToPowerOfTwo(this.currentWidth);
            final int lllllllllllllllIlllIllIIllIIlIIl = MathHelper.roundUpToPowerOfTwo(this.currentHeight);
            final int lllllllllllllllIlllIllIIllIIlIII = MathHelper.roundUpToPowerOfTwo(this.currentWidth + lllllllllllllllIlllIllIIllIlIIII);
            final int lllllllllllllllIlllIllIIllIIIlll = MathHelper.roundUpToPowerOfTwo(this.currentHeight + lllllllllllllllIlllIllIIllIlIIII);
            final boolean lllllllllllllllIlllIllIIllIIIllI = lllllllllllllllIlllIllIIllIIlIII <= this.maxWidth;
            final boolean lllllllllllllllIlllIllIIllIIIlIl = lllllllllllllllIlllIllIIllIIIlll <= this.maxHeight;
            if (!lllllllllllllllIlllIllIIllIIIllI && !lllllllllllllllIlllIllIIllIIIlIl) {
                return false;
            }
            final boolean lllllllllllllllIlllIllIIllIIIlII = lllllllllllllllIlllIllIIllIIlIll != lllllllllllllllIlllIllIIllIIlIII;
            final boolean lllllllllllllllIlllIllIIllIIIIll = lllllllllllllllIlllIllIIllIIlIIl != lllllllllllllllIlllIllIIllIIIlll;
            if (lllllllllllllllIlllIllIIllIIIlII ^ lllllllllllllllIlllIllIIllIIIIll) {
                final boolean lllllllllllllllIlllIllIIllIIlllI = !lllllllllllllllIlllIllIIllIIIlII;
            }
            else {
                final boolean lllllllllllllllIlllIllIIllIIllIl = lllllllllllllllIlllIllIIllIIIllI && lllllllllllllllIlllIllIIllIIlIll <= lllllllllllllllIlllIllIIllIIlIIl;
            }
        }
        else {
            final boolean lllllllllllllllIlllIllIIllIIIIlI = this.currentWidth + lllllllllllllllIlllIllIIllIlIIII <= this.maxWidth;
            final boolean lllllllllllllllIlllIllIIllIIIIIl = this.currentHeight + lllllllllllllllIlllIllIIllIlIIII <= this.maxHeight;
            if (!lllllllllllllllIlllIllIIllIIIIlI && !lllllllllllllllIlllIllIIllIIIIIl) {
                return false;
            }
            lllllllllllllllIlllIllIIllIIllII = (lllllllllllllllIlllIllIIllIIIIlI && (lllllllllllllllIlllIllIIllIIllll || this.currentWidth <= this.currentHeight));
        }
        final int lllllllllllllllIlllIllIIllIIlIlI = Math.max(lllllllllllllllIlllIllIIlIllllIl.getWidth(), lllllllllllllllIlllIllIIlIllllIl.getHeight());
        if (MathHelper.roundUpToPowerOfTwo((lllllllllllllllIlllIllIIllIIllII ? this.currentWidth : this.currentHeight) + lllllllllllllllIlllIllIIllIIlIlI) > (lllllllllllllllIlllIllIIllIIllII ? this.maxWidth : this.maxHeight)) {
            return false;
        }
        Slot lllllllllllllllIlllIllIIlIllllll = null;
        if (lllllllllllllllIlllIllIIllIIllII) {
            if (lllllllllllllllIlllIllIIlIllllIl.getWidth() > lllllllllllllllIlllIllIIlIllllIl.getHeight()) {
                lllllllllllllllIlllIllIIlIllllIl.rotate();
            }
            if (this.currentHeight == 0) {
                this.currentHeight = lllllllllllllllIlllIllIIlIllllIl.getHeight();
            }
            final Slot lllllllllllllllIlllIllIIllIIIIII = new Slot(this.currentWidth, 0, lllllllllllllllIlllIllIIlIllllIl.getWidth(), this.currentHeight);
            this.currentWidth += lllllllllllllllIlllIllIIlIllllIl.getWidth();
        }
        else {
            lllllllllllllllIlllIllIIlIllllll = new Slot(0, this.currentHeight, this.currentWidth, lllllllllllllllIlllIllIIlIllllIl.getHeight());
            this.currentHeight += lllllllllllllllIlllIllIIlIllllIl.getHeight();
        }
        lllllllllllllllIlllIllIIlIllllll.addSlot(lllllllllllllllIlllIllIIlIllllIl);
        this.stitchSlots.add(lllllllllllllllIlllIllIIlIllllll);
        return true;
    }
    
    public int getCurrentWidth() {
        return this.currentWidth;
    }
    
    public void doStitch() {
        final Holder[] lllllllllllllllIlllIllIlIIIlIlII = this.setStitchHolders.toArray(new Holder[this.setStitchHolders.size()]);
        Arrays.sort(lllllllllllllllIlllIllIlIIIlIlII);
        final Holder[] lllllllllllllllIlllIllIlIIIlIIll = lllllllllllllllIlllIllIlIIIlIlII;
        for (int lllllllllllllllIlllIllIlIIIlIIlI = lllllllllllllllIlllIllIlIIIlIlII.length, lllllllllllllllIlllIllIlIIIlIIIl = 0; lllllllllllllllIlllIllIlIIIlIIIl < lllllllllllllllIlllIllIlIIIlIIlI; ++lllllllllllllllIlllIllIlIIIlIIIl) {
            final Holder lllllllllllllllIlllIllIlIIIlIIII = lllllllllllllllIlllIllIlIIIlIIll[lllllllllllllllIlllIllIlIIIlIIIl];
            if (!this.allocateSlot(lllllllllllllllIlllIllIlIIIlIIII)) {
                final String lllllllllllllllIlllIllIlIIIIllll = String.format("Unable to fit: %s, size: %dx%d, atlas: %dx%d, atlasMax: %dx%d - Maybe try a lower resolution resourcepack?", lllllllllllllllIlllIllIlIIIlIIII.getAtlasSprite().getIconName(), lllllllllllllllIlllIllIlIIIlIIII.getAtlasSprite().getIconWidth(), lllllllllllllllIlllIllIlIIIlIIII.getAtlasSprite().getIconHeight(), this.currentWidth, this.currentHeight, this.maxWidth, this.maxHeight);
                throw new StitcherException(lllllllllllllllIlllIllIlIIIlIIII, lllllllllllllllIlllIllIlIIIIllll);
            }
        }
        if (this.forcePowerOf2) {
            this.currentWidth = MathHelper.roundUpToPowerOfTwo(this.currentWidth);
            this.currentHeight = MathHelper.roundUpToPowerOfTwo(this.currentHeight);
        }
    }
    
    public void addSprite(final TextureAtlasSprite lllllllllllllllIlllIllIlIIlIIIIl) {
        final Holder lllllllllllllllIlllIllIlIIlIIIII = new Holder(lllllllllllllllIlllIllIlIIlIIIIl, this.mipmapLevelStitcher);
        if (this.maxTileDimension > 0) {
            lllllllllllllllIlllIllIlIIlIIIII.setNewDimension(this.maxTileDimension);
        }
        this.setStitchHolders.add(lllllllllllllllIlllIllIlIIlIIIII);
    }
    
    static {
        __OBFID = "CL_00001054";
    }
    
    private boolean allocateSlot(final Holder lllllllllllllllIlllIllIIlllIIIIl) {
        for (int lllllllllllllllIlllIllIIlllIIIll = 0; lllllllllllllllIlllIllIIlllIIIll < this.stitchSlots.size(); ++lllllllllllllllIlllIllIIlllIIIll) {
            if (this.stitchSlots.get(lllllllllllllllIlllIllIIlllIIIll).addSlot(lllllllllllllllIlllIllIIlllIIIIl)) {
                return true;
            }
            lllllllllllllllIlllIllIIlllIIIIl.rotate();
            if (this.stitchSlots.get(lllllllllllllllIlllIllIIlllIIIll).addSlot(lllllllllllllllIlllIllIIlllIIIIl)) {
                return true;
            }
            lllllllllllllllIlllIllIIlllIIIIl.rotate();
        }
        return this.expandAndAllocateSlot(lllllllllllllllIlllIllIIlllIIIIl);
    }
    
    public List getStichSlots() {
        final ArrayList lllllllllllllllIlllIllIIlllllllI = Lists.newArrayList();
        for (final Slot lllllllllllllllIlllIllIIllllllII : this.stitchSlots) {
            lllllllllllllllIlllIllIIllllllII.getAllStitchSlots(lllllllllllllllIlllIllIIlllllllI);
        }
        final ArrayList lllllllllllllllIlllIllIIlllllIll = Lists.newArrayList();
        for (final Slot lllllllllllllllIlllIllIIlllllIIl : lllllllllllllllIlllIllIIlllllllI) {
            final Holder lllllllllllllllIlllIllIIlllllIII = lllllllllllllllIlllIllIIlllllIIl.getStitchHolder();
            final TextureAtlasSprite lllllllllllllllIlllIllIIllllIlll = lllllllllllllllIlllIllIIlllllIII.getAtlasSprite();
            lllllllllllllllIlllIllIIllllIlll.initSprite(this.currentWidth, this.currentHeight, lllllllllllllllIlllIllIIlllllIIl.getOriginX(), lllllllllllllllIlllIllIIlllllIIl.getOriginY(), lllllllllllllllIlllIllIIlllllIII.isRotated());
            lllllllllllllllIlllIllIIlllllIll.add(lllllllllllllllIlllIllIIllllIlll);
        }
        return lllllllllllllllIlllIllIIlllllIll;
    }
    
    private static int getMipmapDimension(final int lllllllllllllllIlllIllIIlllIlIlI, final int lllllllllllllllIlllIllIIlllIlIIl) {
        return (lllllllllllllllIlllIllIIlllIlIlI >> lllllllllllllllIlllIllIIlllIlIIl) + (((lllllllllllllllIlllIllIIlllIlIlI & (1 << lllllllllllllllIlllIllIIlllIlIIl) - 1) != 0x0) ? 1 : 0) << lllllllllllllllIlllIllIIlllIlIIl;
    }
    
    public int getCurrentHeight() {
        return this.currentHeight;
    }
    
    public static class Holder implements Comparable
    {
        private final /* synthetic */ int height;
        private /* synthetic */ float scaleFactor;
        private final /* synthetic */ int width;
        private final /* synthetic */ TextureAtlasSprite theTexture;
        private /* synthetic */ boolean rotated;
        private final /* synthetic */ int mipmapLevelHolder;
        
        public void setNewDimension(final int lllllllllllllllllIlllIIlIllIlllI) {
            if (this.width > lllllllllllllllllIlllIIlIllIlllI && this.height > lllllllllllllllllIlllIIlIllIlllI) {
                this.scaleFactor = lllllllllllllllllIlllIIlIllIlllI / (float)Math.min(this.width, this.height);
            }
        }
        
        public Holder(final TextureAtlasSprite lllllllllllllllllIlllIIllIIIIIlI, final int lllllllllllllllllIlllIIllIIIIlII) {
            this.scaleFactor = 1.0f;
            this.theTexture = lllllllllllllllllIlllIIllIIIIIlI;
            this.width = lllllllllllllllllIlllIIllIIIIIlI.getIconWidth();
            this.height = lllllllllllllllllIlllIIllIIIIIlI.getIconHeight();
            this.mipmapLevelHolder = lllllllllllllllllIlllIIllIIIIlII;
            this.rotated = (getMipmapDimension(this.height, lllllllllllllllllIlllIIllIIIIlII) > getMipmapDimension(this.width, lllllllllllllllllIlllIIllIIIIlII));
        }
        
        public int compareTo(final Holder lllllllllllllllllIlllIIlIllIIIII) {
            int lllllllllllllllllIlllIIlIllIIIlI = 0;
            if (this.getHeight() == lllllllllllllllllIlllIIlIllIIIII.getHeight()) {
                if (this.getWidth() == lllllllllllllllllIlllIIlIllIIIII.getWidth()) {
                    if (this.theTexture.getIconName() == null) {
                        return (lllllllllllllllllIlllIIlIllIIIII.theTexture.getIconName() == null) ? 0 : -1;
                    }
                    return this.theTexture.getIconName().compareTo(lllllllllllllllllIlllIIlIllIIIII.theTexture.getIconName());
                }
                else {
                    final int lllllllllllllllllIlllIIlIllIIIll = (this.getWidth() < lllllllllllllllllIlllIIlIllIIIII.getWidth()) ? 1 : -1;
                }
            }
            else {
                lllllllllllllllllIlllIIlIllIIIlI = ((this.getHeight() < lllllllllllllllllIlllIIlIllIIIII.getHeight()) ? 1 : -1);
            }
            return lllllllllllllllllIlllIIlIllIIIlI;
        }
        
        public TextureAtlasSprite getAtlasSprite() {
            return this.theTexture;
        }
        
        public int getHeight() {
            return this.rotated ? getMipmapDimension((int)(this.width * this.scaleFactor), this.mipmapLevelHolder) : getMipmapDimension((int)(this.height * this.scaleFactor), this.mipmapLevelHolder);
        }
        
        @Override
        public int compareTo(final Object lllllllllllllllllIlllIIlIlIllIIl) {
            return this.compareTo((Holder)lllllllllllllllllIlllIIlIlIllIIl);
        }
        
        public boolean isRotated() {
            return this.rotated;
        }
        
        static {
            __OBFID = "CL_00001055";
        }
        
        public int getWidth() {
            return this.rotated ? getMipmapDimension((int)(this.height * this.scaleFactor), this.mipmapLevelHolder) : getMipmapDimension((int)(this.width * this.scaleFactor), this.mipmapLevelHolder);
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder("Holder{width=").append(this.width).append(", height=").append(this.height).append(", name=").append(this.theTexture.getIconName()).append('}'));
        }
        
        public void rotate() {
            this.rotated = !this.rotated;
        }
    }
    
    public static class Slot
    {
        private final /* synthetic */ int width;
        private final /* synthetic */ int originX;
        private final /* synthetic */ int height;
        private final /* synthetic */ int originY;
        private /* synthetic */ List subSlots;
        private /* synthetic */ Holder holder;
        
        static {
            __OBFID = "CL_00001056";
        }
        
        public int getOriginX() {
            return this.originX;
        }
        
        public Slot(final int lIlIlIIllIIIIl, final int lIlIlIIllIIlIl, final int lIlIlIIllIIlII, final int lIlIlIIlIllllI) {
            this.originX = lIlIlIIllIIIIl;
            this.originY = lIlIlIIllIIlIl;
            this.width = lIlIlIIllIIlII;
            this.height = lIlIlIIlIllllI;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder("Slot{originX=").append(this.originX).append(", originY=").append(this.originY).append(", width=").append(this.width).append(", height=").append(this.height).append(", texture=").append(this.holder).append(", subSlots=").append(this.subSlots).append('}'));
        }
        
        public void getAllStitchSlots(final List lIlIlIIIllIIIl) {
            if (this.holder != null) {
                lIlIlIIIllIIIl.add(this);
            }
            else if (this.subSlots != null) {
                for (final Slot lIlIlIIIllIIll : this.subSlots) {
                    lIlIlIIIllIIll.getAllStitchSlots(lIlIlIIIllIIIl);
                }
            }
        }
        
        public Holder getStitchHolder() {
            return this.holder;
        }
        
        public boolean addSlot(final Holder lIlIlIIlIIIIIl) {
            if (this.holder != null) {
                return false;
            }
            final int lIlIlIIlIIlIlI = lIlIlIIlIIIIIl.getWidth();
            final int lIlIlIIlIIlIIl = lIlIlIIlIIIIIl.getHeight();
            if (lIlIlIIlIIlIlI > this.width || lIlIlIIlIIlIIl > this.height) {
                return false;
            }
            if (lIlIlIIlIIlIlI == this.width && lIlIlIIlIIlIIl == this.height) {
                this.holder = lIlIlIIlIIIIIl;
                return true;
            }
            if (this.subSlots == null) {
                this.subSlots = Lists.newArrayListWithCapacity(1);
                this.subSlots.add(new Slot(this.originX, this.originY, lIlIlIIlIIlIlI, lIlIlIIlIIlIIl));
                final int lIlIlIIlIIlIII = this.width - lIlIlIIlIIlIlI;
                final int lIlIlIIlIIIlll = this.height - lIlIlIIlIIlIIl;
                if (lIlIlIIlIIIlll > 0 && lIlIlIIlIIlIII > 0) {
                    final int lIlIlIIlIIIllI = Math.max(this.height, lIlIlIIlIIlIII);
                    final int lIlIlIIlIIIlIl = Math.max(this.width, lIlIlIIlIIIlll);
                    if (lIlIlIIlIIIllI >= lIlIlIIlIIIlIl) {
                        this.subSlots.add(new Slot(this.originX, this.originY + lIlIlIIlIIlIIl, lIlIlIIlIIlIlI, lIlIlIIlIIIlll));
                        this.subSlots.add(new Slot(this.originX + lIlIlIIlIIlIlI, this.originY, lIlIlIIlIIlIII, this.height));
                    }
                    else {
                        this.subSlots.add(new Slot(this.originX + lIlIlIIlIIlIlI, this.originY, lIlIlIIlIIlIII, lIlIlIIlIIlIIl));
                        this.subSlots.add(new Slot(this.originX, this.originY + lIlIlIIlIIlIIl, this.width, lIlIlIIlIIIlll));
                    }
                }
                else if (lIlIlIIlIIlIII == 0) {
                    this.subSlots.add(new Slot(this.originX, this.originY + lIlIlIIlIIlIIl, lIlIlIIlIIlIlI, lIlIlIIlIIIlll));
                }
                else if (lIlIlIIlIIIlll == 0) {
                    this.subSlots.add(new Slot(this.originX + lIlIlIIlIIlIlI, this.originY, lIlIlIIlIIlIII, lIlIlIIlIIlIIl));
                }
            }
            for (final Slot lIlIlIIlIIIIll : this.subSlots) {
                if (lIlIlIIlIIIIll.addSlot(lIlIlIIlIIIIIl)) {
                    return true;
                }
            }
            return false;
        }
        
        public int getOriginY() {
            return this.originY;
        }
    }
}
