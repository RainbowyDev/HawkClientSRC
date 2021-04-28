package net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraftforge.client.model.pipeline.*;
import optifine.*;

public class BakedQuad implements IVertexProducer
{
    private /* synthetic */ int[] vertexDataSingle;
    private /* synthetic */ TextureAtlasSprite sprite;
    protected /* synthetic */ int[] field_178215_a;
    protected final /* synthetic */ int field_178213_b;
    protected final /* synthetic */ EnumFacing face;
    
    public BakedQuad(final int[] lllIIllIIlIIlII, final int lllIIllIIIlllll, final EnumFacing lllIIllIIIllllI) {
        this.sprite = null;
        this.vertexDataSingle = null;
        this.field_178215_a = lllIIllIIlIIlII;
        this.field_178213_b = lllIIllIIIlllll;
        this.face = lllIIllIIIllllI;
        this.fixVertexData();
    }
    
    static {
        __OBFID = "CL_00002512";
    }
    
    private void fixVertexData() {
        if (Config.isShaders()) {
            if (this.field_178215_a.length == 28) {
                this.field_178215_a = expandVertexData(this.field_178215_a);
            }
        }
        else if (this.field_178215_a.length == 56) {
            this.field_178215_a = compactVertexData(this.field_178215_a);
        }
    }
    
    public boolean func_178212_b() {
        return this.field_178213_b != -1;
    }
    
    public int[] getVertexDataSingle() {
        if (this.vertexDataSingle == null) {
            this.vertexDataSingle = makeVertexDataSingle(this.func_178209_a(), this.getSprite());
        }
        return this.vertexDataSingle;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("vertex: ").append(this.field_178215_a.length / 7).append(", tint: ").append(this.field_178213_b).append(", facing: ").append(this.face).append(", sprite: ").append(this.sprite));
    }
    
    private static int[] compactVertexData(final int[] lllIIlIlIlIIlll) {
        final int lllIIlIlIlIlIll = lllIIlIlIlIIlll.length / 4;
        final int lllIIlIlIlIlIlI = lllIIlIlIlIlIll / 2;
        final int[] lllIIlIlIlIlIIl = new int[lllIIlIlIlIlIlI * 4];
        for (int lllIIlIlIlIlIII = 0; lllIIlIlIlIlIII < 4; ++lllIIlIlIlIlIII) {
            System.arraycopy(lllIIlIlIlIIlll, lllIIlIlIlIlIII * lllIIlIlIlIlIll, lllIIlIlIlIlIIl, lllIIlIlIlIlIII * lllIIlIlIlIlIlI, lllIIlIlIlIlIlI);
        }
        return lllIIlIlIlIlIIl;
    }
    
    public EnumFacing getFace() {
        return this.face;
    }
    
    private static int[] makeVertexDataSingle(final int[] lllIIllIIIIIIlI, final TextureAtlasSprite lllIIllIIIIIIIl) {
        final int[] lllIIllIIIIIIII = lllIIllIIIIIIlI.clone();
        final int lllIIlIllllllll = lllIIllIIIIIIIl.sheetWidth / lllIIllIIIIIIIl.getIconWidth();
        final int lllIIlIlllllllI = lllIIllIIIIIIIl.sheetHeight / lllIIllIIIIIIIl.getIconHeight();
        final int lllIIlIllllllIl = lllIIllIIIIIIII.length / 4;
        for (int lllIIlIllllllII = 0; lllIIlIllllllII < 4; ++lllIIlIllllllII) {
            final int lllIIlIlllllIll = lllIIlIllllllII * lllIIlIllllllIl;
            final float lllIIlIlllllIlI = Float.intBitsToFloat(lllIIllIIIIIIII[lllIIlIlllllIll + 4]);
            final float lllIIlIlllllIIl = Float.intBitsToFloat(lllIIllIIIIIIII[lllIIlIlllllIll + 4 + 1]);
            final float lllIIlIlllllIII = lllIIllIIIIIIIl.toSingleU(lllIIlIlllllIlI);
            final float lllIIlIllllIlll = lllIIllIIIIIIIl.toSingleV(lllIIlIlllllIIl);
            lllIIllIIIIIIII[lllIIlIlllllIll + 4] = Float.floatToRawIntBits(lllIIlIlllllIII);
            lllIIllIIIIIIII[lllIIlIlllllIll + 4 + 1] = Float.floatToRawIntBits(lllIIlIllllIlll);
        }
        return lllIIllIIIIIIII;
    }
    
    public BakedQuad(final int[] lllIIllIIlllIII, final int lllIIllIIllIlll, final EnumFacing lllIIllIIllIIIl, final TextureAtlasSprite lllIIllIIllIlIl) {
        this.sprite = null;
        this.vertexDataSingle = null;
        this.field_178215_a = lllIIllIIlllIII;
        this.field_178213_b = lllIIllIIllIlll;
        this.face = lllIIllIIllIIIl;
        this.sprite = lllIIllIIllIlIl;
        this.fixVertexData();
    }
    
    public TextureAtlasSprite getSprite() {
        if (this.sprite == null) {
            this.sprite = getSpriteByUv(this.func_178209_a());
        }
        return this.sprite;
    }
    
    public int func_178211_c() {
        return this.field_178213_b;
    }
    
    private static TextureAtlasSprite getSpriteByUv(final int[] lllIIlIllIllIlI) {
        float lllIIlIllIllIIl = 1.0f;
        float lllIIlIllIllIII = 1.0f;
        float lllIIlIllIlIlll = 0.0f;
        float lllIIlIllIlIllI = 0.0f;
        final int lllIIlIllIlIlIl = lllIIlIllIllIlI.length / 4;
        for (int lllIIlIllIlIlII = 0; lllIIlIllIlIlII < 4; ++lllIIlIllIlIlII) {
            final int lllIIlIllIlIIll = lllIIlIllIlIlII * lllIIlIllIlIlIl;
            final float lllIIlIllIlIIlI = Float.intBitsToFloat(lllIIlIllIllIlI[lllIIlIllIlIIll + 4]);
            final float lllIIlIllIlIIIl = Float.intBitsToFloat(lllIIlIllIllIlI[lllIIlIllIlIIll + 4 + 1]);
            lllIIlIllIllIIl = Math.min(lllIIlIllIllIIl, lllIIlIllIlIIlI);
            lllIIlIllIllIII = Math.min(lllIIlIllIllIII, lllIIlIllIlIIIl);
            lllIIlIllIlIlll = Math.max(lllIIlIllIlIlll, lllIIlIllIlIIlI);
            lllIIlIllIlIllI = Math.max(lllIIlIllIlIllI, lllIIlIllIlIIIl);
        }
        final float lllIIlIllIlIIII = (lllIIlIllIllIIl + lllIIlIllIlIlll) / 2.0f;
        final float lllIIlIllIIllll = (lllIIlIllIllIII + lllIIlIllIlIllI) / 2.0f;
        final TextureAtlasSprite lllIIlIllIIlllI = Minecraft.getMinecraft().getTextureMapBlocks().getIconByUV(lllIIlIllIlIIII, lllIIlIllIIllll);
        return lllIIlIllIIlllI;
    }
    
    @Override
    public void pipe(final IVertexConsumer lllIIlIlllIIlll) {
        Reflector.callVoid(Reflector.LightUtil_putBakedQuad, lllIIlIlllIIlll, this);
    }
    
    private static int[] expandVertexData(final int[] lllIIlIlIlllIll) {
        final int lllIIlIlIlllIlI = lllIIlIlIlllIll.length / 4;
        final int lllIIlIlIlllIIl = lllIIlIlIlllIlI * 2;
        final int[] lllIIlIlIlllIII = new int[lllIIlIlIlllIIl * 4];
        for (int lllIIlIlIllIlll = 0; lllIIlIlIllIlll < 4; ++lllIIlIlIllIlll) {
            System.arraycopy(lllIIlIlIlllIll, lllIIlIlIllIlll * lllIIlIlIlllIlI, lllIIlIlIlllIII, lllIIlIlIllIlll * lllIIlIlIlllIIl, lllIIlIlIlllIlI);
        }
        return lllIIlIlIlllIII;
    }
    
    public int[] func_178209_a() {
        this.fixVertexData();
        return this.field_178215_a;
    }
}
