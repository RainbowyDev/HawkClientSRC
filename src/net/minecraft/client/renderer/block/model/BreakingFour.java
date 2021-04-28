package net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.util.*;

public class BreakingFour extends BakedQuad
{
    private final /* synthetic */ TextureAtlasSprite texture;
    
    public BreakingFour(final BakedQuad llllllllllllllIIlIlllIlllIIlllll, final TextureAtlasSprite llllllllllllllIIlIlllIlllIIllllI) {
        super(Arrays.copyOf(llllllllllllllIIlIlllIlllIIlllll.func_178209_a(), llllllllllllllIIlIlllIlllIIlllll.func_178209_a().length), llllllllllllllIIlIlllIlllIIlllll.field_178213_b, FaceBakery.func_178410_a(llllllllllllllIIlIlllIlllIIlllll.func_178209_a()));
        this.texture = llllllllllllllIIlIlllIlllIIllllI;
        this.func_178217_e();
    }
    
    private void func_178217_e() {
        for (int llllllllllllllIIlIlllIlllIIlIlll = 0; llllllllllllllIIlIlllIlllIIlIlll < 4; ++llllllllllllllIIlIlllIlllIIlIlll) {
            this.func_178216_a(llllllllllllllIIlIlllIlllIIlIlll);
        }
    }
    
    private void func_178216_a(final int llllllllllllllIIlIlllIlllIIIIIIl) {
        final int llllllllllllllIIlIlllIlllIIIlIIl = this.field_178215_a.length / 4;
        final int llllllllllllllIIlIlllIlllIIIlIII = llllllllllllllIIlIlllIlllIIIlIIl * llllllllllllllIIlIlllIlllIIIIIIl;
        final float llllllllllllllIIlIlllIlllIIIIlll = Float.intBitsToFloat(this.field_178215_a[llllllllllllllIIlIlllIlllIIIlIII]);
        final float llllllllllllllIIlIlllIlllIIIIllI = Float.intBitsToFloat(this.field_178215_a[llllllllllllllIIlIlllIlllIIIlIII + 1]);
        final float llllllllllllllIIlIlllIlllIIIIlIl = Float.intBitsToFloat(this.field_178215_a[llllllllllllllIIlIlllIlllIIIlIII + 2]);
        float llllllllllllllIIlIlllIlllIIIIlII = 0.0f;
        float llllllllllllllIIlIlllIlllIIIIIll = 0.0f;
        switch (SwitchEnumFacing.field_178419_a[this.face.ordinal()]) {
            case 1: {
                llllllllllllllIIlIlllIlllIIIIlII = llllllllllllllIIlIlllIlllIIIIlll * 16.0f;
                llllllllllllllIIlIlllIlllIIIIIll = (1.0f - llllllllllllllIIlIlllIlllIIIIlIl) * 16.0f;
                break;
            }
            case 2: {
                llllllllllllllIIlIlllIlllIIIIlII = llllllllllllllIIlIlllIlllIIIIlll * 16.0f;
                llllllllllllllIIlIlllIlllIIIIIll = llllllllllllllIIlIlllIlllIIIIlIl * 16.0f;
                break;
            }
            case 3: {
                llllllllllllllIIlIlllIlllIIIIlII = (1.0f - llllllllllllllIIlIlllIlllIIIIlll) * 16.0f;
                llllllllllllllIIlIlllIlllIIIIIll = (1.0f - llllllllllllllIIlIlllIlllIIIIllI) * 16.0f;
                break;
            }
            case 4: {
                llllllllllllllIIlIlllIlllIIIIlII = llllllllllllllIIlIlllIlllIIIIlll * 16.0f;
                llllllllllllllIIlIlllIlllIIIIIll = (1.0f - llllllllllllllIIlIlllIlllIIIIllI) * 16.0f;
                break;
            }
            case 5: {
                llllllllllllllIIlIlllIlllIIIIlII = llllllllllllllIIlIlllIlllIIIIlIl * 16.0f;
                llllllllllllllIIlIlllIlllIIIIIll = (1.0f - llllllllllllllIIlIlllIlllIIIIllI) * 16.0f;
                break;
            }
            case 6: {
                llllllllllllllIIlIlllIlllIIIIlII = (1.0f - llllllllllllllIIlIlllIlllIIIIlIl) * 16.0f;
                llllllllllllllIIlIlllIlllIIIIIll = (1.0f - llllllllllllllIIlIlllIlllIIIIllI) * 16.0f;
                break;
            }
        }
        this.field_178215_a[llllllllllllllIIlIlllIlllIIIlIII + 4] = Float.floatToRawIntBits(this.texture.getInterpolatedU(llllllllllllllIIlIlllIlllIIIIlII));
        this.field_178215_a[llllllllllllllIIlIlllIlllIIIlIII + 4 + 1] = Float.floatToRawIntBits(this.texture.getInterpolatedV(llllllllllllllIIlIlllIlllIIIIIll));
    }
    
    static {
        __OBFID = "CL_00002492";
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_178419_a;
        
        static {
            __OBFID = "CL_00002491";
            field_178419_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_178419_a[EnumFacing.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_178419_a[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_178419_a[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_178419_a[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_178419_a[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.field_178419_a[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
