package net.minecraft.world;

import net.minecraft.util.*;

public class DifficultyInstance
{
    private final /* synthetic */ float field_180171_b;
    private final /* synthetic */ EnumDifficulty field_180172_a;
    
    public float func_180170_c() {
        return (this.field_180171_b < 2.0f) ? 0.0f : ((this.field_180171_b > 4.0f) ? 1.0f : ((this.field_180171_b - 2.0f) / 2.0f));
    }
    
    public DifficultyInstance(final EnumDifficulty lllllllllllllllllIIllllIIlIIllII, final long lllllllllllllllllIIllllIIlIIlIll, final long lllllllllllllllllIIllllIIlIIIlIl, final float lllllllllllllllllIIllllIIlIIlIIl) {
        this.field_180172_a = lllllllllllllllllIIllllIIlIIllII;
        this.field_180171_b = this.func_180169_a(lllllllllllllllllIIllllIIlIIllII, lllllllllllllllllIIllllIIlIIlIll, lllllllllllllllllIIllllIIlIIIlIl, lllllllllllllllllIIllllIIlIIlIIl);
    }
    
    static {
        __OBFID = "CL_00002261";
    }
    
    public float func_180168_b() {
        return this.field_180171_b;
    }
    
    private float func_180169_a(final EnumDifficulty lllllllllllllllllIIllllIIIllIlII, final long lllllllllllllllllIIllllIIIllIIll, final long lllllllllllllllllIIllllIIIllIIlI, final float lllllllllllllllllIIllllIIIllIIIl) {
        if (lllllllllllllllllIIllllIIIllIlII == EnumDifficulty.PEACEFUL) {
            return 0.0f;
        }
        final boolean lllllllllllllllllIIllllIIIllIIII = lllllllllllllllllIIllllIIIllIlII == EnumDifficulty.HARD;
        float lllllllllllllllllIIllllIIIlIllll = 0.75f;
        final float lllllllllllllllllIIllllIIIlIlllI = MathHelper.clamp_float((lllllllllllllllllIIllllIIIllIIll - 72000.0f) / 1440000.0f, 0.0f, 1.0f) * 0.25f;
        lllllllllllllllllIIllllIIIlIllll += lllllllllllllllllIIllllIIIlIlllI;
        float lllllllllllllllllIIllllIIIlIllIl = 0.0f;
        lllllllllllllllllIIllllIIIlIllIl += MathHelper.clamp_float(lllllllllllllllllIIllllIIIllIIlI / 3600000.0f, 0.0f, 1.0f) * (lllllllllllllllllIIllllIIIllIIII ? 1.0f : 0.75f);
        lllllllllllllllllIIllllIIIlIllIl += MathHelper.clamp_float(lllllllllllllllllIIllllIIIllIIIl * 0.25f, 0.0f, lllllllllllllllllIIllllIIIlIlllI);
        if (lllllllllllllllllIIllllIIIllIlII == EnumDifficulty.EASY) {
            lllllllllllllllllIIllllIIIlIllIl *= 0.5f;
        }
        lllllllllllllllllIIllllIIIlIllll += lllllllllllllllllIIllllIIIlIllIl;
        return lllllllllllllllllIIllllIIIllIlII.getDifficultyId() * lllllllllllllllllIIllllIIIlIllll;
    }
}
