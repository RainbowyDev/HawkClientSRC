package net.minecraft.client.renderer;

import net.minecraft.world.*;
import net.minecraft.client.renderer.chunk.*;
import net.minecraft.util.*;

public class ViewFrustum
{
    protected /* synthetic */ int field_178168_c;
    protected /* synthetic */ int field_178165_d;
    public /* synthetic */ RenderChunk[] field_178164_f;
    protected final /* synthetic */ World field_178167_b;
    protected final /* synthetic */ RenderGlobal field_178169_a;
    protected /* synthetic */ int field_178166_e;
    
    public ViewFrustum(final World lllllllllllllllIIlIIlIIlIIIIllll, final int lllllllllllllllIIlIIlIIlIIIIlllI, final RenderGlobal lllllllllllllllIIlIIlIIlIIIIllIl, final IRenderChunkFactory lllllllllllllllIIlIIlIIlIIIIIlll) {
        this.field_178169_a = lllllllllllllllIIlIIlIIlIIIIllIl;
        this.field_178167_b = lllllllllllllllIIlIIlIIlIIIIllll;
        this.func_178159_a(lllllllllllllllIIlIIlIIlIIIIlllI);
        this.func_178158_a(lllllllllllllllIIlIIlIIlIIIIIlll);
    }
    
    public void func_178163_a(final double lllllllllllllllIIlIIlIIIlIllIlII, final double lllllllllllllllIIlIIlIIIllIIIIlI) {
        final int lllllllllllllllIIlIIlIIIllIIIIIl = MathHelper.floor_double(lllllllllllllllIIlIIlIIIlIllIlII) - 8;
        final int lllllllllllllllIIlIIlIIIllIIIIII = MathHelper.floor_double(lllllllllllllllIIlIIlIIIllIIIIlI) - 8;
        final int lllllllllllllllIIlIIlIIIlIllllll = this.field_178165_d * 16;
        for (int lllllllllllllllIIlIIlIIIlIlllllI = 0; lllllllllllllllIIlIIlIIIlIlllllI < this.field_178165_d; ++lllllllllllllllIIlIIlIIIlIlllllI) {
            final int lllllllllllllllIIlIIlIIIlIllllIl = this.func_178157_a(lllllllllllllllIIlIIlIIIllIIIIIl, lllllllllllllllIIlIIlIIIlIllllll, lllllllllllllllIIlIIlIIIlIlllllI);
            for (int lllllllllllllllIIlIIlIIIlIllllII = 0; lllllllllllllllIIlIIlIIIlIllllII < this.field_178166_e; ++lllllllllllllllIIlIIlIIIlIllllII) {
                final int lllllllllllllllIIlIIlIIIlIlllIll = this.func_178157_a(lllllllllllllllIIlIIlIIIllIIIIII, lllllllllllllllIIlIIlIIIlIllllll, lllllllllllllllIIlIIlIIIlIllllII);
                for (int lllllllllllllllIIlIIlIIIlIlllIlI = 0; lllllllllllllllIIlIIlIIIlIlllIlI < this.field_178168_c; ++lllllllllllllllIIlIIlIIIlIlllIlI) {
                    final int lllllllllllllllIIlIIlIIIlIlllIIl = lllllllllllllllIIlIIlIIIlIlllIlI * 16;
                    final RenderChunk lllllllllllllllIIlIIlIIIlIlllIII = this.field_178164_f[(lllllllllllllllIIlIIlIIIlIllllII * this.field_178168_c + lllllllllllllllIIlIIlIIIlIlllIlI) * this.field_178165_d + lllllllllllllllIIlIIlIIIlIlllllI];
                    final BlockPos lllllllllllllllIIlIIlIIIlIllIlll = lllllllllllllllIIlIIlIIIlIlllIII.func_178568_j();
                    if (lllllllllllllllIIlIIlIIIlIllIlll.getX() != lllllllllllllllIIlIIlIIIlIllllIl || lllllllllllllllIIlIIlIIIlIllIlll.getY() != lllllllllllllllIIlIIlIIIlIlllIIl || lllllllllllllllIIlIIlIIIlIllIlll.getZ() != lllllllllllllllIIlIIlIIIlIlllIll) {
                        final BlockPos lllllllllllllllIIlIIlIIIlIllIllI = new BlockPos(lllllllllllllllIIlIIlIIIlIllllIl, lllllllllllllllIIlIIlIIIlIlllIIl, lllllllllllllllIIlIIlIIIlIlllIll);
                        if (!lllllllllllllllIIlIIlIIIlIllIllI.equals(lllllllllllllllIIlIIlIIIlIlllIII.func_178568_j())) {
                            lllllllllllllllIIlIIlIIIlIlllIII.func_178576_a(lllllllllllllllIIlIIlIIIlIllIllI);
                        }
                    }
                }
            }
        }
    }
    
    private int func_178157_a(final int lllllllllllllllIIlIIlIIIlIIllIll, final int lllllllllllllllIIlIIlIIIlIIlllll, final int lllllllllllllllIIlIIlIIIlIIllIIl) {
        final int lllllllllllllllIIlIIlIIIlIIlllIl = lllllllllllllllIIlIIlIIIlIIllIIl * 16;
        int lllllllllllllllIIlIIlIIIlIIlllII = lllllllllllllllIIlIIlIIIlIIlllIl - lllllllllllllllIIlIIlIIIlIIllIll + lllllllllllllllIIlIIlIIIlIIlllll / 2;
        if (lllllllllllllllIIlIIlIIIlIIlllII < 0) {
            lllllllllllllllIIlIIlIIIlIIlllII -= lllllllllllllllIIlIIlIIIlIIlllll - 1;
        }
        return lllllllllllllllIIlIIlIIIlIIlllIl - lllllllllllllllIIlIIlIIIlIIlllII / lllllllllllllllIIlIIlIIIlIIlllll * lllllllllllllllIIlIIlIIIlIIlllll;
    }
    
    protected void func_178159_a(final int lllllllllllllllIIlIIlIIIllIlIlIl) {
        final int lllllllllllllllIIlIIlIIIllIlIlll = lllllllllllllllIIlIIlIIIllIlIlIl * 2 + 1;
        this.field_178165_d = lllllllllllllllIIlIIlIIIllIlIlll;
        this.field_178168_c = 16;
        this.field_178166_e = lllllllllllllllIIlIIlIIIllIlIlll;
    }
    
    protected RenderChunk func_178161_a(final BlockPos lllllllllllllllIIlIIlIIIIlIlIIII) {
        int lllllllllllllllIIlIIlIIIIlIIllll = MathHelper.bucketInt(lllllllllllllllIIlIIlIIIIlIlIIII.getX(), 16);
        final int lllllllllllllllIIlIIlIIIIlIIlllI = MathHelper.bucketInt(lllllllllllllllIIlIIlIIIIlIlIIII.getY(), 16);
        int lllllllllllllllIIlIIlIIIIlIIllIl = MathHelper.bucketInt(lllllllllllllllIIlIIlIIIIlIlIIII.getZ(), 16);
        if (lllllllllllllllIIlIIlIIIIlIIlllI >= 0 && lllllllllllllllIIlIIlIIIIlIIlllI < this.field_178168_c) {
            lllllllllllllllIIlIIlIIIIlIIllll %= this.field_178165_d;
            if (lllllllllllllllIIlIIlIIIIlIIllll < 0) {
                lllllllllllllllIIlIIlIIIIlIIllll += this.field_178165_d;
            }
            lllllllllllllllIIlIIlIIIIlIIllIl %= this.field_178166_e;
            if (lllllllllllllllIIlIIlIIIIlIIllIl < 0) {
                lllllllllllllllIIlIIlIIIIlIIllIl += this.field_178166_e;
            }
            final int lllllllllllllllIIlIIlIIIIlIIllII = (lllllllllllllllIIlIIlIIIIlIIllIl * this.field_178168_c + lllllllllllllllIIlIIlIIIIlIIlllI) * this.field_178165_d + lllllllllllllllIIlIIlIIIIlIIllll;
            return this.field_178164_f[lllllllllllllllIIlIIlIIIIlIIllII];
        }
        return null;
    }
    
    public void func_178160_a() {
        for (final RenderChunk lllllllllllllllIIlIIlIIIlllIIIlI : this.field_178164_f) {
            lllllllllllllllIIlIIlIIIlllIIIlI.func_178566_a();
        }
    }
    
    public void func_178162_a(final int lllllllllllllllIIlIIlIIIlIIIIIII, final int lllllllllllllllIIlIIlIIIIllIlIlI, final int lllllllllllllllIIlIIlIIIIllllllI, final int lllllllllllllllIIlIIlIIIIllIlIII, final int lllllllllllllllIIlIIlIIIIllIIlll, final int lllllllllllllllIIlIIlIIIIllIIllI) {
        final int lllllllllllllllIIlIIlIIIIllllIlI = MathHelper.bucketInt(lllllllllllllllIIlIIlIIIlIIIIIII, 16);
        final int lllllllllllllllIIlIIlIIIIllllIIl = MathHelper.bucketInt(lllllllllllllllIIlIIlIIIIllIlIlI, 16);
        final int lllllllllllllllIIlIIlIIIIllllIII = MathHelper.bucketInt(lllllllllllllllIIlIIlIIIIllllllI, 16);
        final int lllllllllllllllIIlIIlIIIIlllIlll = MathHelper.bucketInt(lllllllllllllllIIlIIlIIIIllIlIII, 16);
        final int lllllllllllllllIIlIIlIIIIlllIllI = MathHelper.bucketInt(lllllllllllllllIIlIIlIIIIllIIlll, 16);
        final int lllllllllllllllIIlIIlIIIIlllIlIl = MathHelper.bucketInt(lllllllllllllllIIlIIlIIIIllIIllI, 16);
        for (int lllllllllllllllIIlIIlIIIIlllIlII = lllllllllllllllIIlIIlIIIIllllIlI; lllllllllllllllIIlIIlIIIIlllIlII <= lllllllllllllllIIlIIlIIIIlllIlll; ++lllllllllllllllIIlIIlIIIIlllIlII) {
            int lllllllllllllllIIlIIlIIIIlllIIll = lllllllllllllllIIlIIlIIIIlllIlII % this.field_178165_d;
            if (lllllllllllllllIIlIIlIIIIlllIIll < 0) {
                lllllllllllllllIIlIIlIIIIlllIIll += this.field_178165_d;
            }
            for (int lllllllllllllllIIlIIlIIIIlllIIlI = lllllllllllllllIIlIIlIIIIllllIIl; lllllllllllllllIIlIIlIIIIlllIIlI <= lllllllllllllllIIlIIlIIIIlllIllI; ++lllllllllllllllIIlIIlIIIIlllIIlI) {
                int lllllllllllllllIIlIIlIIIIlllIIIl = lllllllllllllllIIlIIlIIIIlllIIlI % this.field_178168_c;
                if (lllllllllllllllIIlIIlIIIIlllIIIl < 0) {
                    lllllllllllllllIIlIIlIIIIlllIIIl += this.field_178168_c;
                }
                for (int lllllllllllllllIIlIIlIIIIlllIIII = lllllllllllllllIIlIIlIIIIllllIII; lllllllllllllllIIlIIlIIIIlllIIII <= lllllllllllllllIIlIIlIIIIlllIlIl; ++lllllllllllllllIIlIIlIIIIlllIIII) {
                    int lllllllllllllllIIlIIlIIIIllIllll = lllllllllllllllIIlIIlIIIIlllIIII % this.field_178166_e;
                    if (lllllllllllllllIIlIIlIIIIllIllll < 0) {
                        lllllllllllllllIIlIIlIIIIllIllll += this.field_178166_e;
                    }
                    final int lllllllllllllllIIlIIlIIIIllIlllI = (lllllllllllllllIIlIIlIIIIllIllll * this.field_178168_c + lllllllllllllllIIlIIlIIIIlllIIIl) * this.field_178165_d + lllllllllllllllIIlIIlIIIIlllIIll;
                    final RenderChunk lllllllllllllllIIlIIlIIIIllIllIl = this.field_178164_f[lllllllllllllllIIlIIlIIIIllIlllI];
                    lllllllllllllllIIlIIlIIIIllIllIl.func_178575_a(true);
                }
            }
        }
    }
    
    protected void func_178158_a(final IRenderChunkFactory lllllllllllllllIIlIIlIIIllllIIll) {
        final int lllllllllllllllIIlIIlIIIlllllIll = this.field_178165_d * this.field_178168_c * this.field_178166_e;
        this.field_178164_f = new RenderChunk[lllllllllllllllIIlIIlIIIlllllIll];
        int lllllllllllllllIIlIIlIIIlllllIlI = 0;
        for (int lllllllllllllllIIlIIlIIIlllllIIl = 0; lllllllllllllllIIlIIlIIIlllllIIl < this.field_178165_d; ++lllllllllllllllIIlIIlIIIlllllIIl) {
            for (int lllllllllllllllIIlIIlIIIlllllIII = 0; lllllllllllllllIIlIIlIIIlllllIII < this.field_178168_c; ++lllllllllllllllIIlIIlIIIlllllIII) {
                for (int lllllllllllllllIIlIIlIIIllllIlll = 0; lllllllllllllllIIlIIlIIIllllIlll < this.field_178166_e; ++lllllllllllllllIIlIIlIIIllllIlll) {
                    final int lllllllllllllllIIlIIlIIIllllIllI = (lllllllllllllllIIlIIlIIIllllIlll * this.field_178168_c + lllllllllllllllIIlIIlIIIlllllIII) * this.field_178165_d + lllllllllllllllIIlIIlIIIlllllIIl;
                    final BlockPos lllllllllllllllIIlIIlIIIllllIlIl = new BlockPos(lllllllllllllllIIlIIlIIIlllllIIl * 16, lllllllllllllllIIlIIlIIIlllllIII * 16, lllllllllllllllIIlIIlIIIllllIlll * 16);
                    this.field_178164_f[lllllllllllllllIIlIIlIIIllllIllI] = lllllllllllllllIIlIIlIIIllllIIll.func_178602_a(this.field_178167_b, this.field_178169_a, lllllllllllllllIIlIIlIIIllllIlIl, lllllllllllllllIIlIIlIIIlllllIlI++);
                }
            }
        }
    }
}
