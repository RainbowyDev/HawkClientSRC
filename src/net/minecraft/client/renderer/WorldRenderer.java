package net.minecraft.client.renderer;

import net.minecraft.client.renderer.texture.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.util.*;
import java.nio.*;
import java.util.*;
import optifine.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;

public class WorldRenderer
{
    private /* synthetic */ boolean needsUpdate;
    public /* synthetic */ IntBuffer rawIntBuffer;
    public /* synthetic */ int rawBufferIndex;
    private /* synthetic */ TextureAtlasSprite[] quadSprites;
    private /* synthetic */ int bufferSize;
    private /* synthetic */ VertexFormat vertexFormat;
    private /* synthetic */ int field_179012_p;
    private /* synthetic */ double field_178998_e;
    private /* synthetic */ double xOffset;
    private /* synthetic */ double yOffset;
    private /* synthetic */ boolean isDrawing;
    private /* synthetic */ ByteBuffer byteBuffer;
    private /* synthetic */ TextureAtlasSprite[] quadSpritesPrev;
    private /* synthetic */ TextureAtlasSprite quadSprite;
    private /* synthetic */ int field_179007_h;
    private /* synthetic */ double field_178995_f;
    private /* synthetic */ int field_178996_g;
    public /* synthetic */ int vertexCount;
    private /* synthetic */ boolean[] drawnIcons;
    private /* synthetic */ EnumWorldBlockLayer blockLayer;
    private /* synthetic */ int field_179003_o;
    private /* synthetic */ double zOffset;
    public /* synthetic */ int drawMode;
    public /* synthetic */ FloatBuffer rawFloatBuffer;
    
    public void addVertex(final double lllllllllllllllIlllllllIlIllllll, final double lllllllllllllllIlllllllIlIllIlII, final double lllllllllllllllIlllllllIlIllIIll) {
        if (Config.isShaders()) {
            SVertexBuilder.beginAddVertex(this);
        }
        if (this.rawBufferIndex >= this.bufferSize - this.vertexFormat.func_177338_f()) {
            this.growBuffer(2097152);
        }
        final List lllllllllllllllIlllllllIlIllllII = this.vertexFormat.func_177343_g();
        for (int lllllllllllllllIlllllllIlIlllIll = lllllllllllllllIlllllllIlIllllII.size(), lllllllllllllllIlllllllIlIlllIlI = 0; lllllllllllllllIlllllllIlIlllIlI < lllllllllllllllIlllllllIlIlllIll; ++lllllllllllllllIlllllllIlIlllIlI) {
            final VertexFormatElement lllllllllllllllIlllllllIlIlllIIl = lllllllllllllllIlllllllIlIllllII.get(lllllllllllllllIlllllllIlIlllIlI);
            final int lllllllllllllllIlllllllIlIlllIII = lllllllllllllllIlllllllIlIlllIIl.func_177373_a() >> 2;
            final int lllllllllllllllIlllllllIlIllIlll = this.rawBufferIndex + lllllllllllllllIlllllllIlIlllIII;
            switch (SwitchEnumUseage.field_178959_a[lllllllllllllllIlllllllIlIlllIIl.func_177375_c().ordinal()]) {
                case 1: {
                    this.rawIntBuffer.put(lllllllllllllllIlllllllIlIllIlll, Float.floatToRawIntBits((float)(lllllllllllllllIlllllllIlIllllll + this.xOffset)));
                    this.rawIntBuffer.put(lllllllllllllllIlllllllIlIllIlll + 1, Float.floatToRawIntBits((float)(lllllllllllllllIlllllllIlIllIlII + this.yOffset)));
                    this.rawIntBuffer.put(lllllllllllllllIlllllllIlIllIlll + 2, Float.floatToRawIntBits((float)(lllllllllllllllIlllllllIlIllIIll + this.zOffset)));
                    break;
                }
                case 2: {
                    this.rawIntBuffer.put(lllllllllllllllIlllllllIlIllIlll, this.field_179007_h);
                    break;
                }
                case 3: {
                    if (lllllllllllllllIlllllllIlIlllIIl.func_177369_e() == 0) {
                        this.rawIntBuffer.put(lllllllllllllllIlllllllIlIllIlll, Float.floatToRawIntBits((float)this.field_178998_e));
                        this.rawIntBuffer.put(lllllllllllllllIlllllllIlIllIlll + 1, Float.floatToRawIntBits((float)this.field_178995_f));
                        break;
                    }
                    this.rawIntBuffer.put(lllllllllllllllIlllllllIlIllIlll, this.field_178996_g);
                    break;
                }
                case 4: {
                    this.rawIntBuffer.put(lllllllllllllllIlllllllIlIllIlll, this.field_179003_o);
                    break;
                }
            }
        }
        this.rawBufferIndex += this.vertexFormat.func_177338_f() >> 2;
        ++this.vertexCount;
        if (Config.isShaders()) {
            SVertexBuilder.endAddVertex(this);
        }
    }
    
    public void setTextureUV(final double lllllllllllllllIllllllllllIllIll, final double lllllllllllllllIllllllllllIllIlI) {
        if (!this.vertexFormat.func_177347_a(0) && !this.vertexFormat.func_177347_a(1)) {
            final VertexFormatElement lllllllllllllllIllllllllllIlllIl = new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.UV, 2);
            this.vertexFormat.func_177349_a(lllllllllllllllIllllllllllIlllIl);
        }
        this.field_178998_e = lllllllllllllllIllllllllllIllIll;
        this.field_178995_f = lllllllllllllllIllllllllllIllIlI;
    }
    
    public void func_178974_a(final int lllllllllllllllIlllllllIlIIlIllI, final int lllllllllllllllIlllllllIlIIIllll) {
        final int lllllllllllllllIlllllllIlIIlIlII = lllllllllllllllIlllllllIlIIlIllI >> 16 & 0xFF;
        final int lllllllllllllllIlllllllIlIIlIIll = lllllllllllllllIlllllllIlIIlIllI >> 8 & 0xFF;
        final int lllllllllllllllIlllllllIlIIlIIlI = lllllllllllllllIlllllllIlIIlIllI & 0xFF;
        this.func_178961_b(lllllllllllllllIlllllllIlIIlIlII, lllllllllllllllIlllllllIlIIlIIll, lllllllllllllllIlllllllIlIIlIIlI, lllllllllllllllIlllllllIlIIIllll);
    }
    
    public void startDrawingQuads() {
        this.startDrawing(7);
    }
    
    public void func_178960_a(final float lllllllllllllllIlllllllllIlllIII, final float lllllllllllllllIlllllllllIllIlll, final float lllllllllllllllIlllllllllIllIllI, final float lllllllllllllllIlllllllllIlllIlI) {
        this.func_178961_b((int)(lllllllllllllllIlllllllllIlllIII * 255.0f), (int)(lllllllllllllllIlllllllllIllIlll * 255.0f), (int)(lllllllllllllllIlllllllllIllIllI * 255.0f), (int)(lllllllllllllllIlllllllllIlllIlI * 255.0f));
    }
    
    private int getBufferQuadSize() {
        final int lllllllllllllllIllllllIlllIIIlII = this.rawIntBuffer.capacity() * 4 / (this.vertexFormat.func_177338_f() * 4);
        return lllllllllllllllIllllllIlllIIIlII;
    }
    
    public State getVertexState(final float llllllllllllllllIIIIIIIIIIIIIIlI, final float llllllllllllllllIIIIIIIIIIIIlllI, final float llllllllllllllllIIIIIIIIIIIIllIl) {
        final int[] llllllllllllllllIIIIIIIIIIIIllII = new int[this.rawBufferIndex];
        final PriorityQueue llllllllllllllllIIIIIIIIIIIIlIll = new PriorityQueue(this.rawBufferIndex, new QuadComparator(this.rawFloatBuffer, (float)(llllllllllllllllIIIIIIIIIIIIIIlI + this.xOffset), (float)(llllllllllllllllIIIIIIIIIIIIlllI + this.yOffset), (float)(llllllllllllllllIIIIIIIIIIIIllIl + this.zOffset), this.vertexFormat.func_177338_f() / 4));
        final int llllllllllllllllIIIIIIIIIIIIlIlI = this.vertexFormat.func_177338_f();
        TextureAtlasSprite[] llllllllllllllllIIIIIIIIIIIIlIIl = null;
        final int llllllllllllllllIIIIIIIIIIIIlIII = this.vertexFormat.func_177338_f() / 4 * 4;
        if (this.quadSprites != null) {
            llllllllllllllllIIIIIIIIIIIIlIIl = new TextureAtlasSprite[this.vertexCount / 4];
        }
        for (int llllllllllllllllIIIIIIIIIIIIIlll = 0; llllllllllllllllIIIIIIIIIIIIIlll < this.rawBufferIndex; llllllllllllllllIIIIIIIIIIIIIlll += llllllllllllllllIIIIIIIIIIIIlIlI) {
            llllllllllllllllIIIIIIIIIIIIlIll.add(llllllllllllllllIIIIIIIIIIIIIlll);
        }
        int llllllllllllllllIIIIIIIIIIIIIlll = 0;
        while (!llllllllllllllllIIIIIIIIIIIIlIll.isEmpty()) {
            final int llllllllllllllllIIIIIIIIIIIIIllI = (int)llllllllllllllllIIIIIIIIIIIIlIll.remove();
            for (int llllllllllllllllIIIIIIIIIIIIIlIl = 0; llllllllllllllllIIIIIIIIIIIIIlIl < llllllllllllllllIIIIIIIIIIIIlIlI; ++llllllllllllllllIIIIIIIIIIIIIlIl) {
                llllllllllllllllIIIIIIIIIIIIllII[llllllllllllllllIIIIIIIIIIIIIlll + llllllllllllllllIIIIIIIIIIIIIlIl] = this.rawIntBuffer.get(llllllllllllllllIIIIIIIIIIIIIllI + llllllllllllllllIIIIIIIIIIIIIlIl);
            }
            if (llllllllllllllllIIIIIIIIIIIIlIIl != null) {
                final int llllllllllllllllIIIIIIIIIIIIIlIl = llllllllllllllllIIIIIIIIIIIIIllI / llllllllllllllllIIIIIIIIIIIIlIII;
                final int llllllllllllllllIIIIIIIIIIIIIlII = llllllllllllllllIIIIIIIIIIIIIlll / llllllllllllllllIIIIIIIIIIIIlIII;
                llllllllllllllllIIIIIIIIIIIIlIIl[llllllllllllllllIIIIIIIIIIIIIlII] = this.quadSprites[llllllllllllllllIIIIIIIIIIIIIlIl];
            }
            llllllllllllllllIIIIIIIIIIIIIlll += llllllllllllllllIIIIIIIIIIIIlIlI;
        }
        this.rawIntBuffer.clear();
        this.rawIntBuffer.put(llllllllllllllllIIIIIIIIIIIIllII);
        if (this.quadSprites != null) {
            System.arraycopy(llllllllllllllllIIIIIIIIIIIIlIIl, 0, this.quadSprites, 0, llllllllllllllllIIIIIIIIIIIIlIIl.length);
        }
        return new State(llllllllllllllllIIIIIIIIIIIIllII, this.rawBufferIndex, this.vertexCount, new VertexFormat(this.vertexFormat), llllllllllllllllIIIIIIIIIIIIlIIl);
    }
    
    static {
        __OBFID = "CL_00000942";
    }
    
    public VertexFormat func_178973_g() {
        return this.vertexFormat;
    }
    
    public void func_178961_b(int lllllllllllllllIlllllllIllllllII, int lllllllllllllllIlllllllIlllllIll, int lllllllllllllllIlllllllIlllllIlI, int lllllllllllllllIlllllllIllllllll) {
        if (!this.needsUpdate) {
            if (lllllllllllllllIlllllllIllllllII > 255) {
                lllllllllllllllIlllllllIllllllII = 255;
            }
            if (lllllllllllllllIlllllllIlllllIll > 255) {
                lllllllllllllllIlllllllIlllllIll = 255;
            }
            if (lllllllllllllllIlllllllIlllllIlI > 255) {
                lllllllllllllllIlllllllIlllllIlI = 255;
            }
            if (lllllllllllllllIlllllllIllllllll > 255) {
                lllllllllllllllIlllllllIllllllll = 255;
            }
            if (lllllllllllllllIlllllllIllllllII < 0) {
                lllllllllllllllIlllllllIllllllII = 0;
            }
            if (lllllllllllllllIlllllllIlllllIll < 0) {
                lllllllllllllllIlllllllIlllllIll = 0;
            }
            if (lllllllllllllllIlllllllIlllllIlI < 0) {
                lllllllllllllllIlllllllIlllllIlI = 0;
            }
            if (lllllllllllllllIlllllllIllllllll < 0) {
                lllllllllllllllIlllllllIllllllll = 0;
            }
            if (!this.vertexFormat.func_177346_d()) {
                final VertexFormatElement lllllllllllllllIlllllllIlllllllI = new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUseage.COLOR, 4);
                this.vertexFormat.func_177349_a(lllllllllllllllIlllllllIlllllllI);
            }
            if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                this.field_179007_h = (lllllllllllllllIlllllllIllllllll << 24 | lllllllllllllllIlllllllIlllllIlI << 16 | lllllllllllllllIlllllllIlllllIll << 8 | lllllllllllllllIlllllllIllllllII);
            }
            else {
                this.field_179007_h = (lllllllllllllllIlllllllIllllllII << 24 | lllllllllllllllIlllllllIlllllIll << 16 | lllllllllllllllIlllllllIlllllIlI << 8 | lllllllllllllllIlllllllIllllllll);
            }
        }
    }
    
    public void setPosition(final int lllllllllllllllIlllllllllIlIlIll, final int lllllllllllllllIlllllllllIlIlllI, final int lllllllllllllllIlllllllllIlIllIl) {
        this.func_178961_b(lllllllllllllllIlllllllllIlIlIll, lllllllllllllllIlllllllllIlIlllI, lllllllllllllllIlllllllllIlIllIl, 255);
    }
    
    public int func_178989_h() {
        return this.vertexCount;
    }
    
    public void checkAndGrow() {
        if (this.rawBufferIndex >= this.bufferSize - this.vertexFormat.func_177338_f()) {
            this.growBuffer(2097152);
        }
    }
    
    public boolean isColorDisabled() {
        return this.needsUpdate;
    }
    
    public void drawMultiTexture() {
        if (this.quadSprites != null) {
            final int lllllllllllllllIlllllllIIIIIIllI = Config.getMinecraft().getTextureMapBlocks().getCountRegisteredSprites();
            if (this.drawnIcons.length <= lllllllllllllllIlllllllIIIIIIllI) {
                this.drawnIcons = new boolean[lllllllllllllllIlllllllIIIIIIllI + 1];
            }
            Arrays.fill(this.drawnIcons, false);
            int lllllllllllllllIlllllllIIIIIIlIl = 0;
            int lllllllllllllllIlllllllIIIIIIlII = -1;
            for (int lllllllllllllllIlllllllIIIIIIIll = this.vertexCount / 4, lllllllllllllllIlllllllIIIIIIIlI = 0; lllllllllllllllIlllllllIIIIIIIlI < lllllllllllllllIlllllllIIIIIIIll; ++lllllllllllllllIlllllllIIIIIIIlI) {
                final TextureAtlasSprite lllllllllllllllIlllllllIIIIIIIIl = this.quadSprites[lllllllllllllllIlllllllIIIIIIIlI];
                if (lllllllllllllllIlllllllIIIIIIIIl != null) {
                    final int lllllllllllllllIlllllllIIIIIIIII = lllllllllllllllIlllllllIIIIIIIIl.getIndexInMap();
                    if (!this.drawnIcons[lllllllllllllllIlllllllIIIIIIIII]) {
                        if (lllllllllllllllIlllllllIIIIIIIIl == TextureUtils.iconGrassSideOverlay) {
                            if (lllllllllllllllIlllllllIIIIIIlII < 0) {
                                lllllllllllllllIlllllllIIIIIIlII = lllllllllllllllIlllllllIIIIIIIlI;
                            }
                        }
                        else {
                            lllllllllllllllIlllllllIIIIIIIlI = this.drawForIcon(lllllllllllllllIlllllllIIIIIIIIl, lllllllllllllllIlllllllIIIIIIIlI) - 1;
                            ++lllllllllllllllIlllllllIIIIIIlIl;
                            if (this.blockLayer != EnumWorldBlockLayer.TRANSLUCENT) {
                                this.drawnIcons[lllllllllllllllIlllllllIIIIIIIII] = true;
                            }
                        }
                    }
                }
            }
            if (lllllllllllllllIlllllllIIIIIIlII >= 0) {
                this.drawForIcon(TextureUtils.iconGrassSideOverlay, lllllllllllllllIlllllllIIIIIIlII);
                ++lllllllllllllllIlllllllIIIIIIlIl;
            }
            if (lllllllllllllllIlllllllIIIIIIlIl > 0) {}
        }
    }
    
    public void func_178975_e(final float lllllllllllllllIlllllllIIlIlllll, final float lllllllllllllllIlllllllIIllIIlll, final float lllllllllllllllIlllllllIIlIlllIl) {
        final byte lllllllllllllllIlllllllIIllIIlIl = (byte)(lllllllllllllllIlllllllIIlIlllll * 127.0f);
        final byte lllllllllllllllIlllllllIIllIIlII = (byte)(lllllllllllllllIlllllllIIllIIlll * 127.0f);
        final byte lllllllllllllllIlllllllIIllIIIll = (byte)(lllllllllllllllIlllllllIIlIlllIl * 127.0f);
        final int lllllllllllllllIlllllllIIllIIIlI = this.vertexFormat.func_177338_f() >> 2;
        final int lllllllllllllllIlllllllIIllIIIIl = (this.vertexCount - 4) * lllllllllllllllIlllllllIIllIIIlI + this.vertexFormat.func_177342_c() / 4;
        this.field_179003_o = ((lllllllllllllllIlllllllIIllIIlIl & 0xFF) | (lllllllllllllllIlllllllIIllIIlII & 0xFF) << 8 | (lllllllllllllllIlllllllIIllIIIll & 0xFF) << 16);
        this.rawIntBuffer.put(lllllllllllllllIlllllllIIllIIIIl, this.field_179003_o);
        this.rawIntBuffer.put(lllllllllllllllIlllllllIIllIIIIl + lllllllllllllllIlllllllIIllIIIlI, this.field_179003_o);
        this.rawIntBuffer.put(lllllllllllllllIlllllllIIllIIIIl + lllllllllllllllIlllllllIIllIIIlI * 2, this.field_179003_o);
        this.rawIntBuffer.put(lllllllllllllllIlllllllIIllIIIIl + lllllllllllllllIlllllllIIllIIIlI * 3, this.field_179003_o);
    }
    
    public void func_178968_d(final int lllllllllllllllIlllllllIIIllIIlI) {
        for (int lllllllllllllllIlllllllIIIllIlII = 0; lllllllllllllllIlllllllIIIllIlII < 4; ++lllllllllllllllIlllllllIIIllIlII) {
            this.func_178988_b(lllllllllllllllIlllllllIIIllIIlI, lllllllllllllllIlllllllIIIllIlII + 1);
        }
    }
    
    public void setSprite(final TextureAtlasSprite lllllllllllllllIlllllllIIIIlIIll) {
        if (this.quadSprites != null) {
            this.quadSprite = lllllllllllllllIlllllllIIIIlIIll;
        }
    }
    
    private void growBuffer(int llllllllllllllllIIIIIIIIIIlIIIIl) {
        if (Config.isShaders()) {
            llllllllllllllllIIIIIIIIIIlIIIIl *= 2;
        }
        LogManager.getLogger().warn(String.valueOf(new StringBuilder("Needed to grow BufferBuilder buffer: Old size ").append(this.bufferSize * 4).append(" bytes, new size ").append((int)(this.bufferSize * 4 + llllllllllllllllIIIIIIIIIIlIIIIl)).append(" bytes.")));
        this.bufferSize += (int)(llllllllllllllllIIIIIIIIIIlIIIIl / 4);
        final ByteBuffer llllllllllllllllIIIIIIIIIIlIIlIl = GLAllocation.createDirectByteBuffer(this.bufferSize * 4);
        this.rawIntBuffer.position(0);
        llllllllllllllllIIIIIIIIIIlIIlIl.asIntBuffer().put(this.rawIntBuffer);
        this.byteBuffer = llllllllllllllllIIIIIIIIIIlIIlIl;
        this.rawIntBuffer = this.byteBuffer.asIntBuffer();
        this.rawFloatBuffer = this.byteBuffer.asFloatBuffer();
        if (this.quadSprites != null) {
            final TextureAtlasSprite[] llllllllllllllllIIIIIIIIIIlIIlII = this.quadSprites;
            final int llllllllllllllllIIIIIIIIIIlIIIll = this.getBufferQuadSize();
            this.quadSprites = new TextureAtlasSprite[llllllllllllllllIIIIIIIIIIlIIIll];
            System.arraycopy(llllllllllllllllIIIIIIIIIIlIIlII, 0, this.quadSprites, 0, Math.min(llllllllllllllllIIIIIIIIIIlIIlII.length, this.quadSprites.length));
            this.quadSpritesPrev = null;
        }
    }
    
    public void func_178994_b(final float lllllllllllllllIllllllllIIlIIIll, final float lllllllllllllllIllllllllIIlIIIlI, final float lllllllllllllllIllllllllIIlIIIIl, final int lllllllllllllllIllllllllIIlIlIIl) {
        final int lllllllllllllllIllllllllIIlIlIII = this.getGLCallListForPass(lllllllllllllllIllllllllIIlIlIIl);
        final int lllllllllllllllIllllllllIIlIIlll = MathHelper.clamp_int((int)(lllllllllllllllIllllllllIIlIIIll * 255.0f), 0, 255);
        final int lllllllllllllllIllllllllIIlIIllI = MathHelper.clamp_int((int)(lllllllllllllllIllllllllIIlIIIlI * 255.0f), 0, 255);
        final int lllllllllllllllIllllllllIIlIIlIl = MathHelper.clamp_int((int)(lllllllllllllllIllllllllIIlIIIIl * 255.0f), 0, 255);
        this.func_178972_a(lllllllllllllllIllllllllIIlIlIII, lllllllllllllllIllllllllIIlIIlll, lllllllllllllllIllllllllIIlIIllI, lllllllllllllllIllllllllIIlIIlIl, 255);
    }
    
    public void func_178990_f(final float lllllllllllllllIlllllllIIIlIlIlI, final float lllllllllllllllIlllllllIIIlIIlII, final float lllllllllllllllIlllllllIIIlIlIII) {
        for (int lllllllllllllllIlllllllIIIlIIlll = 0; lllllllllllllllIlllllllIIIlIIlll < 4; ++lllllllllllllllIlllllllIIIlIIlll) {
            this.func_178994_b(lllllllllllllllIlllllllIIIlIlIlI, lllllllllllllllIlllllllIIIlIIlII, lllllllllllllllIlllllllIIIlIlIII, lllllllllllllllIlllllllIIIlIIlll + 1);
        }
    }
    
    public void markDirty() {
        this.needsUpdate = true;
    }
    
    private void func_178988_b(final int lllllllllllllllIllllllllIlIIIlIl, final int lllllllllllllllIllllllllIlIIIlII) {
        final int lllllllllllllllIllllllllIlIIIIll = this.getGLCallListForPass(lllllllllllllllIllllllllIlIIIlII);
        final int lllllllllllllllIllllllllIlIIIIlI = lllllllllllllllIllllllllIlIIIlIl >> 16 & 0xFF;
        final int lllllllllllllllIllllllllIlIIIIIl = lllllllllllllllIllllllllIlIIIlIl >> 8 & 0xFF;
        final int lllllllllllllllIllllllllIlIIIIII = lllllllllllllllIllllllllIlIIIlIl & 0xFF;
        final int lllllllllllllllIllllllllIIllllll = lllllllllllllllIllllllllIlIIIlIl >> 24 & 0xFF;
        this.func_178972_a(lllllllllllllllIllllllllIlIIIIll, lllllllllllllllIllllllllIlIIIIlI, lllllllllllllllIllllllllIlIIIIIl, lllllllllllllllIllllllllIlIIIIII, lllllllllllllllIllllllllIIllllll);
    }
    
    public void func_178980_d(final float lllllllllllllllIlllllllIlIIIIIII, final float lllllllllllllllIlllllllIIlllIlll, final float lllllllllllllllIlllllllIIlllIllI) {
        if (!this.vertexFormat.func_177350_b()) {
            final VertexFormatElement lllllllllllllllIlllllllIIlllllIl = new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.NORMAL, 3);
            this.vertexFormat.func_177349_a(lllllllllllllllIlllllllIIlllllIl);
            this.vertexFormat.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUseage.PADDING, 1));
        }
        final byte lllllllllllllllIlllllllIIlllllII = (byte)(lllllllllllllllIlllllllIlIIIIIII * 127.0f);
        final byte lllllllllllllllIlllllllIIllllIll = (byte)(lllllllllllllllIlllllllIIlllIlll * 127.0f);
        final byte lllllllllllllllIlllllllIIllllIlI = (byte)(lllllllllllllllIlllllllIIlllIllI * 127.0f);
        this.field_179003_o = ((lllllllllllllllIlllllllIIlllllII & 0xFF) | (lllllllllllllllIlllllllIIllllIll & 0xFF) << 8 | (lllllllllllllllIlllllllIIllllIlI & 0xFF) << 16);
    }
    
    public void func_178963_b(final int lllllllllllllllIllllllllllIlIIIl) {
        if (!this.vertexFormat.func_177347_a(1)) {
            if (!this.vertexFormat.func_177347_a(0)) {
                this.vertexFormat.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.UV, 2));
            }
            final VertexFormatElement lllllllllllllllIllllllllllIlIIll = new VertexFormatElement(1, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.UV, 2);
            this.vertexFormat.func_177349_a(lllllllllllllllIllllllllllIlIIll);
        }
        this.field_178996_g = lllllllllllllllIllllllllllIlIIIl;
    }
    
    public void startDrawing(final int lllllllllllllllIlllllllllllIIlIl) {
        if (this.isDrawing) {
            throw new IllegalStateException("Already building!");
        }
        this.isDrawing = true;
        this.reset();
        this.drawMode = lllllllllllllllIlllllllllllIIlIl;
        this.needsUpdate = false;
    }
    
    public void func_178972_a(final int lllllllllllllllIllllllllIIIlIlII, final int lllllllllllllllIllllllllIIIIllIl, final int lllllllllllllllIllllllllIIIIllII, final int lllllllllllllllIllllllllIIIIlIll, final int lllllllllllllllIllllllllIIIIlIlI) {
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this.rawIntBuffer.put(lllllllllllllllIllllllllIIIlIlII, lllllllllllllllIllllllllIIIIlIlI << 24 | lllllllllllllllIllllllllIIIIlIll << 16 | lllllllllllllllIllllllllIIIIllII << 8 | lllllllllllllllIllllllllIIIIllIl);
        }
        else {
            this.rawIntBuffer.put(lllllllllllllllIllllllllIIIlIlII, lllllllllllllllIllllllllIIIIllIl << 24 | lllllllllllllllIllllllllIIIIllII << 16 | lllllllllllllllIllllllllIIIIlIll << 8 | lllllllllllllllIllllllllIIIIlIlI);
        }
    }
    
    public void setVertexFormat(final VertexFormat lllllllllllllllIlllllllIllIlIllI) {
        this.vertexFormat = new VertexFormat(lllllllllllllllIlllllllIllIlIllI);
        if (Config.isShaders()) {
            SVertexBuilder.endSetVertexFormat(this);
        }
    }
    
    public void func_178978_a(final float lllllllllllllllIllllllllIlIlIlll, final float lllllllllllllllIllllllllIllIIIll, final float lllllllllllllllIllllllllIlIlIlIl, final int lllllllllllllllIllllllllIlIlIlII) {
        final int lllllllllllllllIllllllllIllIIIII = this.getGLCallListForPass(lllllllllllllllIllllllllIlIlIlII);
        int lllllllllllllllIllllllllIlIlllll = this.rawIntBuffer.get(lllllllllllllllIllllllllIllIIIII);
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            final int lllllllllllllllIllllllllIlIllllI = (int)((lllllllllllllllIllllllllIlIlllll & 0xFF) * lllllllllllllllIllllllllIlIlIlll);
            final int lllllllllllllllIllllllllIlIlllII = (int)((lllllllllllllllIllllllllIlIlllll >> 8 & 0xFF) * lllllllllllllllIllllllllIllIIIll);
            final int lllllllllllllllIllllllllIlIllIlI = (int)((lllllllllllllllIllllllllIlIlllll >> 16 & 0xFF) * lllllllllllllllIllllllllIlIlIlIl);
            lllllllllllllllIllllllllIlIlllll &= 0xFF000000;
            lllllllllllllllIllllllllIlIlllll |= (lllllllllllllllIllllllllIlIllIlI << 16 | lllllllllllllllIllllllllIlIlllII << 8 | lllllllllllllllIllllllllIlIllllI);
        }
        else {
            final int lllllllllllllllIllllllllIlIlllIl = (int)((this.field_179007_h >> 24 & 0xFF) * lllllllllllllllIllllllllIlIlIlll);
            final int lllllllllllllllIllllllllIlIllIll = (int)((this.field_179007_h >> 16 & 0xFF) * lllllllllllllllIllllllllIllIIIll);
            final int lllllllllllllllIllllllllIlIllIIl = (int)((this.field_179007_h >> 8 & 0xFF) * lllllllllllllllIllllllllIlIlIlIl);
            lllllllllllllllIllllllllIlIlllll &= 0xFF;
            lllllllllllllllIllllllllIlIlllll |= (lllllllllllllllIllllllllIlIlllIl << 24 | lllllllllllllllIllllllllIlIllIll << 16 | lllllllllllllllIllllllllIlIllIIl << 8);
        }
        if (this.needsUpdate) {
            lllllllllllllllIllllllllIlIlllll = -1;
        }
        this.rawIntBuffer.put(lllllllllllllllIllllllllIllIIIII, lllllllllllllllIllllllllIlIlllll);
    }
    
    public void addVertexWithUV(final double lllllllllllllllIlllllllIllIllllI, final double lllllllllllllllIlllllllIlllIIIll, final double lllllllllllllllIlllllllIlllIIIlI, double lllllllllllllllIlllllllIllIllIll, double lllllllllllllllIlllllllIllIllIlI) {
        if (this.quadSprite != null && this.quadSprites != null) {
            lllllllllllllllIlllllllIllIllIll = this.quadSprite.toSingleU((float)lllllllllllllllIlllllllIllIllIll);
            lllllllllllllllIlllllllIllIllIlI = this.quadSprite.toSingleV((float)lllllllllllllllIlllllllIllIllIlI);
            this.quadSprites[this.vertexCount / 4] = this.quadSprite;
        }
        this.setTextureUV(lllllllllllllllIlllllllIllIllIll, lllllllllllllllIlllllllIllIllIlI);
        this.addVertex(lllllllllllllllIlllllllIllIllllI, lllllllllllllllIlllllllIlllIIIll, lllllllllllllllIlllllllIlllIIIlI);
    }
    
    public void func_178982_a(final byte lllllllllllllllIlllllllIllllIIlI, final byte lllllllllllllllIlllllllIllllIIIl, final byte lllllllllllllllIlllllllIllllIIII) {
        this.setPosition(lllllllllllllllIlllllllIllllIIlI & 0xFF, lllllllllllllllIlllllllIllllIIIl & 0xFF, lllllllllllllllIlllllllIllllIIII & 0xFF);
    }
    
    public void func_178986_b(final float lllllllllllllllIllllllllllIIIllI, final float lllllllllllllllIllllllllllIIlIIl, final float lllllllllllllllIllllllllllIIIlII) {
        this.setPosition((int)(lllllllllllllllIllllllllllIIIllI * 255.0f), (int)(lllllllllllllllIllllllllllIIlIIl * 255.0f), (int)(lllllllllllllllIllllllllllIIIlII * 255.0f));
    }
    
    public void setBlockLayer(final EnumWorldBlockLayer lllllllllllllllIllllllIlllIIlIlI) {
        this.blockLayer = lllllllllllllllIllllllIlllIIlIlI;
        if (lllllllllllllllIllllllIlllIIlIlI == null) {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
            this.quadSprite = null;
        }
    }
    
    public boolean isMultiTexture() {
        return this.quadSprites != null;
    }
    
    public int getDrawMode() {
        return this.drawMode;
    }
    
    public void reset() {
        this.vertexCount = 0;
        this.rawBufferIndex = 0;
        this.vertexFormat.clear();
        this.vertexFormat.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.POSITION, 3));
        if (this.blockLayer != null && Config.isMultiTexture()) {
            if (this.quadSprites == null) {
                this.quadSprites = this.quadSpritesPrev;
            }
            if (this.quadSprites == null || this.quadSprites.length < this.getBufferQuadSize()) {
                this.quadSprites = new TextureAtlasSprite[this.getBufferQuadSize()];
            }
        }
        else {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
        }
        this.quadSprite = null;
    }
    
    public void func_178981_a(final int[] lllllllllllllllIlllllllIllIIllll) {
        if (Config.isShaders()) {
            SVertexBuilder.beginAddVertexData(this, lllllllllllllllIlllllllIllIIllll);
        }
        final int lllllllllllllllIlllllllIllIIlllI = this.vertexFormat.func_177338_f() / 4;
        this.vertexCount += lllllllllllllllIlllllllIllIIllll.length / lllllllllllllllIlllllllIllIIlllI;
        this.rawIntBuffer.position(this.rawBufferIndex);
        this.rawIntBuffer.put(lllllllllllllllIlllllllIllIIllll);
        this.rawBufferIndex += lllllllllllllllIlllllllIllIIllll.length;
        if (Config.isShaders()) {
            SVertexBuilder.endAddVertexData(this);
        }
    }
    
    public int draw() {
        if (!this.isDrawing) {
            throw new IllegalStateException("Not building!");
        }
        this.isDrawing = false;
        if (this.vertexCount > 0) {
            this.byteBuffer.position(0);
            this.byteBuffer.limit(this.rawBufferIndex * 4);
        }
        this.field_179012_p = this.rawBufferIndex * 4;
        return this.field_179012_p;
    }
    
    public int func_178976_e() {
        return this.field_179012_p;
    }
    
    public void func_178991_c(final int lllllllllllllllIlllllllIlIlIIIIl) {
        final int lllllllllllllllIlllllllIlIlIIlIl = lllllllllllllllIlllllllIlIlIIIIl >> 16 & 0xFF;
        final int lllllllllllllllIlllllllIlIlIIlII = lllllllllllllllIlllllllIlIlIIIIl >> 8 & 0xFF;
        final int lllllllllllllllIlllllllIlIlIIIll = lllllllllllllllIlllllllIlIlIIIIl & 0xFF;
        this.setPosition(lllllllllllllllIlllllllIlIlIIlIl, lllllllllllllllIlllllllIlIlIIlII, lllllllllllllllIlllllllIlIlIIIll);
    }
    
    public int getGLCallListForPass(final int lllllllllllllllIllllllllIlllIIlI) {
        return ((this.vertexCount - lllllllllllllllIllllllllIlllIIlI) * this.vertexFormat.func_177338_f() + this.vertexFormat.func_177340_e()) / 4;
    }
    
    private int drawForIcon(final TextureAtlasSprite lllllllllllllllIllllllIllllIIllI, final int lllllllllllllllIllllllIllllIIlIl) {
        GL11.glBindTexture(3553, lllllllllllllllIllllllIllllIIllI.glSpriteTextureId);
        int lllllllllllllllIllllllIllllIllII = -1;
        int lllllllllllllllIllllllIllllIlIll = -1;
        final int lllllllllllllllIllllllIllllIlIlI = this.vertexCount / 4;
        for (int lllllllllllllllIllllllIllllIlIIl = lllllllllllllllIllllllIllllIIlIl; lllllllllllllllIllllllIllllIlIIl < lllllllllllllllIllllllIllllIlIlI; ++lllllllllllllllIllllllIllllIlIIl) {
            final TextureAtlasSprite lllllllllllllllIllllllIllllIlIII = this.quadSprites[lllllllllllllllIllllllIllllIlIIl];
            if (lllllllllllllllIllllllIllllIlIII == lllllllllllllllIllllllIllllIIllI) {
                if (lllllllllllllllIllllllIllllIlIll < 0) {
                    lllllllllllllllIllllllIllllIlIll = lllllllllllllllIllllllIllllIlIIl;
                }
            }
            else if (lllllllllllllllIllllllIllllIlIll >= 0) {
                this.draw(lllllllllllllllIllllllIllllIlIll, lllllllllllllllIllllllIllllIlIIl);
                if (this.blockLayer == EnumWorldBlockLayer.TRANSLUCENT) {
                    return lllllllllllllllIllllllIllllIlIIl;
                }
                lllllllllllllllIllllllIllllIlIll = -1;
                if (lllllllllllllllIllllllIllllIllII < 0) {
                    lllllllllllllllIllllllIllllIllII = lllllllllllllllIllllllIllllIlIIl;
                }
            }
        }
        if (lllllllllllllllIllllllIllllIlIll >= 0) {
            this.draw(lllllllllllllllIllllllIllllIlIll, lllllllllllllllIllllllIllllIlIlI);
        }
        if (lllllllllllllllIllllllIllllIllII < 0) {
            lllllllllllllllIllllllIllllIllII = lllllllllllllllIllllllIllllIlIlI;
        }
        return lllllllllllllllIllllllIllllIllII;
    }
    
    public ByteBuffer func_178966_f() {
        return this.byteBuffer;
    }
    
    public WorldRenderer(int llllllllllllllllIIIIIIIIIIlIllll) {
        this.blockLayer = null;
        this.drawnIcons = new boolean[256];
        this.quadSprites = null;
        this.quadSpritesPrev = null;
        this.quadSprite = null;
        if (Config.isShaders()) {
            llllllllllllllllIIIIIIIIIIlIllll *= 2;
        }
        this.bufferSize = llllllllllllllllIIIIIIIIIIlIllll;
        this.byteBuffer = GLAllocation.createDirectByteBuffer(llllllllllllllllIIIIIIIIIIlIllll * 4);
        this.rawIntBuffer = this.byteBuffer.asIntBuffer();
        this.rawFloatBuffer = this.byteBuffer.asFloatBuffer();
        this.vertexFormat = new VertexFormat();
        this.vertexFormat.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.POSITION, 3));
        SVertexBuilder.initVertexBuilder(this);
    }
    
    public void func_178962_a(final int lllllllllllllllIlllllllllIIllIIl, final int lllllllllllllllIlllllllllIIllIII, final int lllllllllllllllIlllllllllIIllllI, final int lllllllllllllllIlllllllllIIlllIl) {
        final int lllllllllllllllIlllllllllIIlllII = (this.vertexCount - 4) * (this.vertexFormat.func_177338_f() / 4) + this.vertexFormat.func_177344_b(1) / 4;
        final int lllllllllllllllIlllllllllIIllIll = this.vertexFormat.func_177338_f() >> 2;
        this.rawIntBuffer.put(lllllllllllllllIlllllllllIIlllII, lllllllllllllllIlllllllllIIllIIl);
        this.rawIntBuffer.put(lllllllllllllllIlllllllllIIlllII + lllllllllllllllIlllllllllIIllIll, lllllllllllllllIlllllllllIIllIII);
        this.rawIntBuffer.put(lllllllllllllllIlllllllllIIlllII + lllllllllllllllIlllllllllIIllIll * 2, lllllllllllllllIlllllllllIIllllI);
        this.rawIntBuffer.put(lllllllllllllllIlllllllllIIlllII + lllllllllllllllIlllllllllIIllIll * 3, lllllllllllllllIlllllllllIIlllIl);
    }
    
    private void draw(final int lllllllllllllllIllllllIlllIlIIlI, final int lllllllllllllllIllllllIlllIlIlll) {
        final int lllllllllllllllIllllllIlllIlIllI = lllllllllllllllIllllllIlllIlIlll - lllllllllllllllIllllllIlllIlIIlI;
        if (lllllllllllllllIllllllIlllIlIllI > 0) {
            final int lllllllllllllllIllllllIlllIlIlIl = lllllllllllllllIllllllIlllIlIIlI * 4;
            final int lllllllllllllllIllllllIlllIlIlII = lllllllllllllllIllllllIlllIlIllI * 4;
            GL11.glDrawArrays(this.drawMode, lllllllllllllllIllllllIlllIlIlIl, lllllllllllllllIllllllIlllIlIlII);
        }
    }
    
    public void setTranslation(final double lllllllllllllllIlllllllIIlIIlllI, final double lllllllllllllllIlllllllIIlIIllIl, final double lllllllllllllllIlllllllIIlIIllII) {
        this.xOffset = lllllllllllllllIlllllllIIlIIlllI;
        this.yOffset = lllllllllllllllIlllllllIIlIIllIl;
        this.zOffset = lllllllllllllllIlllllllIIlIIllII;
    }
    
    public void putSprite(final TextureAtlasSprite lllllllllllllllIlllllllIIIIllIlI) {
        if (this.quadSprites != null) {
            final int lllllllllllllllIlllllllIIIIlllII = this.vertexCount / 4;
            this.quadSprites[lllllllllllllllIlllllllIIIIlllII - 1] = lllllllllllllllIlllllllIIIIllIlI;
        }
    }
    
    public void func_178987_a(final double lllllllllllllllIlllllllllIIIlIII, final double lllllllllllllllIlllllllllIIIIlll, final double lllllllllllllllIlllllllllIIIIllI) {
        if (this.rawBufferIndex >= this.bufferSize - this.vertexFormat.func_177338_f()) {
            this.growBuffer(2097152);
        }
        final int lllllllllllllllIlllllllllIIIIlIl = this.vertexFormat.func_177338_f() / 4;
        final int lllllllllllllllIlllllllllIIIIlII = (this.vertexCount - 4) * lllllllllllllllIlllllllllIIIIlIl;
        for (int lllllllllllllllIlllllllllIIIIIll = 0; lllllllllllllllIlllllllllIIIIIll < 4; ++lllllllllllllllIlllllllllIIIIIll) {
            final int lllllllllllllllIlllllllllIIIIIlI = lllllllllllllllIlllllllllIIIIlII + lllllllllllllllIlllllllllIIIIIll * lllllllllllllllIlllllllllIIIIlIl;
            final int lllllllllllllllIlllllllllIIIIIIl = lllllllllllllllIlllllllllIIIIIlI + 1;
            final int lllllllllllllllIlllllllllIIIIIII = lllllllllllllllIlllllllllIIIIIIl + 1;
            this.rawIntBuffer.put(lllllllllllllllIlllllllllIIIIIlI, Float.floatToRawIntBits((float)(lllllllllllllllIlllllllllIIIlIII + this.xOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(lllllllllllllllIlllllllllIIIIIlI))));
            this.rawIntBuffer.put(lllllllllllllllIlllllllllIIIIIIl, Float.floatToRawIntBits((float)(lllllllllllllllIlllllllllIIIIlll + this.yOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(lllllllllllllllIlllllllllIIIIIIl))));
            this.rawIntBuffer.put(lllllllllllllllIlllllllllIIIIIII, Float.floatToRawIntBits((float)(lllllllllllllllIlllllllllIIIIllI + this.zOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(lllllllllllllllIlllllllllIIIIIII))));
        }
    }
    
    public void setVertexState(final State lllllllllllllllIllllllllllllIIIl) {
        if (lllllllllllllllIllllllllllllIIIl.func_179013_a().length > this.rawIntBuffer.capacity()) {
            this.growBuffer(2097152);
        }
        this.rawIntBuffer.clear();
        this.rawIntBuffer.put(lllllllllllllllIllllllllllllIIIl.func_179013_a());
        this.rawBufferIndex = lllllllllllllllIllllllllllllIIIl.getRawBufferIndex();
        this.vertexCount = lllllllllllllllIllllllllllllIIIl.getVertexCount();
        this.vertexFormat = new VertexFormat(lllllllllllllllIllllllllllllIIIl.func_179016_d());
        if (lllllllllllllllIllllllllllllIIIl.stateQuadSprites != null) {
            if (this.quadSprites == null) {
                this.quadSprites = this.quadSpritesPrev;
            }
            if (this.quadSprites == null || this.quadSprites.length < this.getBufferQuadSize()) {
                this.quadSprites = new TextureAtlasSprite[this.getBufferQuadSize()];
            }
            System.arraycopy(lllllllllllllllIllllllllllllIIIl.stateQuadSprites, 0, this.quadSprites, 0, lllllllllllllllIllllllllllllIIIl.stateQuadSprites.length);
        }
        else {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
        }
    }
    
    public class State
    {
        private final /* synthetic */ int field_179020_c;
        private final /* synthetic */ int field_179017_d;
        private final /* synthetic */ VertexFormat field_179018_e;
        public /* synthetic */ TextureAtlasSprite[] stateQuadSprites;
        private final /* synthetic */ int[] field_179019_b;
        
        public int[] func_179013_a() {
            return this.field_179019_b;
        }
        
        public int getRawBufferIndex() {
            return this.field_179020_c;
        }
        
        public State(final int[] lllIIlIIlIIIIIl, final int lllIIlIIIlllIlI, final int lllIIlIIIlllIIl, final VertexFormat lllIIlIIIlllllI) {
            this.field_179019_b = lllIIlIIlIIIIIl;
            this.field_179020_c = lllIIlIIIlllIlI;
            this.field_179017_d = lllIIlIIIlllIIl;
            this.field_179018_e = lllIIlIIIlllllI;
        }
        
        public VertexFormat func_179016_d() {
            return this.field_179018_e;
        }
        
        public State(final int[] lllIIlIIlIlIlII, final int lllIIlIIlIlIIll, final int lllIIlIIlIIlIll, final VertexFormat lllIIlIIlIIlIlI, final TextureAtlasSprite[] lllIIlIIlIlIIII) {
            this.field_179019_b = lllIIlIIlIlIlII;
            this.field_179020_c = lllIIlIIlIlIIll;
            this.field_179017_d = lllIIlIIlIIlIll;
            this.field_179018_e = lllIIlIIlIIlIlI;
            this.stateQuadSprites = lllIIlIIlIlIIII;
        }
        
        public int getVertexCount() {
            return this.field_179017_d;
        }
        
        static {
            __OBFID = "CL_00002568";
        }
    }
    
    static final class SwitchEnumUseage
    {
        static final /* synthetic */ int[] field_178959_a;
        
        static {
            field_178959_a = new int[VertexFormatElement.EnumUseage.values().length];
            try {
                SwitchEnumUseage.field_178959_a[VertexFormatElement.EnumUseage.POSITION.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumUseage.field_178959_a[VertexFormatElement.EnumUseage.COLOR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumUseage.field_178959_a[VertexFormatElement.EnumUseage.UV.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumUseage.field_178959_a[VertexFormatElement.EnumUseage.NORMAL.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
