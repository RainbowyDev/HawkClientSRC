package net.minecraft.client.renderer.chunk;

import net.minecraft.util.*;
import java.util.*;
import optifine.*;

public class VisGraph
{
    private static final /* synthetic */ int field_178616_a;
    private final /* synthetic */ BitSet field_178612_d;
    private static final /* synthetic */ int field_178614_b;
    private static final /* synthetic */ int[] field_178613_e;
    private static final /* synthetic */ int field_178615_c;
    private /* synthetic */ int field_178611_f;
    
    private int func_178603_a(final int llllllllllllllIllIlIIlIlIIIlIIlI, final EnumFacing llllllllllllllIllIlIIlIlIIIIllll) {
        switch (SwitchEnumFacing.field_178617_a[llllllllllllllIllIlIIlIlIIIIllll.ordinal()]) {
            case 1: {
                if ((llllllllllllllIllIlIIlIlIIIlIIlI >> 8 & 0xF) == 0x0) {
                    return -1;
                }
                return llllllllllllllIllIlIIlIlIIIlIIlI - VisGraph.field_178615_c;
            }
            case 2: {
                if ((llllllllllllllIllIlIIlIlIIIlIIlI >> 8 & 0xF) == 0xF) {
                    return -1;
                }
                return llllllllllllllIllIlIIlIlIIIlIIlI + VisGraph.field_178615_c;
            }
            case 3: {
                if ((llllllllllllllIllIlIIlIlIIIlIIlI >> 4 & 0xF) == 0x0) {
                    return -1;
                }
                return llllllllllllllIllIlIIlIlIIIlIIlI - VisGraph.field_178614_b;
            }
            case 4: {
                if ((llllllllllllllIllIlIIlIlIIIlIIlI >> 4 & 0xF) == 0xF) {
                    return -1;
                }
                return llllllllllllllIllIlIIlIlIIIlIIlI + VisGraph.field_178614_b;
            }
            case 5: {
                if ((llllllllllllllIllIlIIlIlIIIlIIlI >> 0 & 0xF) == 0x0) {
                    return -1;
                }
                return llllllllllllllIllIlIIlIlIIIlIIlI - VisGraph.field_178616_a;
            }
            case 6: {
                if ((llllllllllllllIllIlIIlIlIIIlIIlI >> 0 & 0xF) == 0xF) {
                    return -1;
                }
                return llllllllllllllIllIlIIlIlIIIlIIlI + VisGraph.field_178616_a;
            }
            default: {
                return -1;
            }
        }
    }
    
    public VisGraph() {
        this.field_178612_d = new BitSet(4096);
        this.field_178611_f = 4096;
    }
    
    private void func_178610_a(final int llllllllllllllIllIlIIlIlIIIllIlI, final Set llllllllllllllIllIlIIlIlIIIllllI) {
        final int llllllllllllllIllIlIIlIlIIIlllIl = llllllllllllllIllIlIIlIlIIIllIlI >> 0 & 0xF;
        if (llllllllllllllIllIlIIlIlIIIlllIl == 0) {
            llllllllllllllIllIlIIlIlIIIllllI.add(EnumFacing.WEST);
        }
        else if (llllllllllllllIllIlIIlIlIIIlllIl == 15) {
            llllllllllllllIllIlIIlIlIIIllllI.add(EnumFacing.EAST);
        }
        final int llllllllllllllIllIlIIlIlIIIlllII = llllllllllllllIllIlIIlIlIIIllIlI >> 8 & 0xF;
        if (llllllllllllllIllIlIIlIlIIIlllII == 0) {
            llllllllllllllIllIlIIlIlIIIllllI.add(EnumFacing.DOWN);
        }
        else if (llllllllllllllIllIlIIlIlIIIlllII == 15) {
            llllllllllllllIllIlIIlIlIIIllllI.add(EnumFacing.UP);
        }
        final int llllllllllllllIllIlIIlIlIIIllIll = llllllllllllllIllIlIIlIlIIIllIlI >> 4 & 0xF;
        if (llllllllllllllIllIlIIlIlIIIllIll == 0) {
            llllllllllllllIllIlIIlIlIIIllllI.add(EnumFacing.NORTH);
        }
        else if (llllllllllllllIllIlIIlIlIIIllIll == 15) {
            llllllllllllllIllIlIIlIlIIIllllI.add(EnumFacing.SOUTH);
        }
    }
    
    public void func_178606_a(final BlockPos llllllllllllllIllIlIIlIllIIlIIIl) {
        this.field_178612_d.set(func_178608_c(llllllllllllllIllIlIIlIllIIlIIIl), true);
        --this.field_178611_f;
    }
    
    private static int func_178605_a(final int llllllllllllllIllIlIIlIllIIIlIII, final int llllllllllllllIllIlIIlIllIIIIlll, final int llllllllllllllIllIlIIlIllIIIIllI) {
        return llllllllllllllIllIlIIlIllIIIlIII << 0 | llllllllllllllIllIlIIlIllIIIIlll << 8 | llllllllllllllIllIlIIlIllIIIIllI << 4;
    }
    
    private static int func_178608_c(final BlockPos llllllllllllllIllIlIIlIllIIIllII) {
        return func_178605_a(llllllllllllllIllIlIIlIllIIIllII.getX() & 0xF, llllllllllllllIllIlIIlIllIIIllII.getY() & 0xF, llllllllllllllIllIlIIlIllIIIllII.getZ() & 0xF);
    }
    
    public Set func_178609_b(final BlockPos llllllllllllllIllIlIIlIlIllIIlll) {
        return this.func_178604_a(func_178608_c(llllllllllllllIllIlIIlIlIllIIlll));
    }
    
    private Set func_178604_a(final int llllllllllllllIllIlIIlIlIIllIIII) {
        final EnumSet llllllllllllllIllIlIIlIlIIllllIl = EnumSet.noneOf(EnumFacing.class);
        final ArrayDeque llllllllllllllIllIlIIlIlIIlllIll = new ArrayDeque(384);
        llllllllllllllIllIlIIlIlIIlllIll.add(IntegerCache.valueOf(llllllllllllllIllIlIIlIlIIllIIII));
        this.field_178612_d.set(llllllllllllllIllIlIIlIlIIllIIII, true);
        while (!llllllllllllllIllIlIIlIlIIlllIll.isEmpty()) {
            final int llllllllllllllIllIlIIlIlIIlllIlI = llllllllllllllIllIlIIlIlIIlllIll.poll();
            this.func_178610_a(llllllllllllllIllIlIIlIlIIlllIlI, llllllllllllllIllIlIIlIlIIllllIl);
            for (final EnumFacing llllllllllllllIllIlIIlIlIIllIlIl : EnumFacing.VALUES) {
                final int llllllllllllllIllIlIIlIlIIllIlII = this.func_178603_a(llllllllllllllIllIlIIlIlIIlllIlI, llllllllllllllIllIlIIlIlIIllIlIl);
                if (llllllllllllllIllIlIIlIlIIllIlII >= 0 && !this.field_178612_d.get(llllllllllllllIllIlIIlIlIIllIlII)) {
                    this.field_178612_d.set(llllllllllllllIllIlIIlIlIIllIlII, true);
                    llllllllllllllIllIlIIlIlIIlllIll.add(IntegerCache.valueOf(llllllllllllllIllIlIIlIlIIllIlII));
                }
            }
        }
        return llllllllllllllIllIlIIlIlIIllllIl;
    }
    
    static {
        __OBFID = "CL_00002450";
        field_178616_a = (int)Math.pow(16.0, 0.0);
        field_178614_b = (int)Math.pow(16.0, 1.0);
        field_178615_c = (int)Math.pow(16.0, 2.0);
        field_178613_e = new int[1352];
        final boolean llllllllllllllIllIlIIlIllIlIIIll = false;
        final boolean llllllllllllllIllIlIIlIllIlIIIlI = true;
        int llllllllllllllIllIlIIlIllIlIIIIl = 0;
        for (int llllllllllllllIllIlIIlIllIlIIIII = 0; llllllllllllllIllIlIIlIllIlIIIII < 16; ++llllllllllllllIllIlIIlIllIlIIIII) {
            for (int llllllllllllllIllIlIIlIllIIlllll = 0; llllllllllllllIllIlIIlIllIIlllll < 16; ++llllllllllllllIllIlIIlIllIIlllll) {
                for (int llllllllllllllIllIlIIlIllIIllllI = 0; llllllllllllllIllIlIIlIllIIllllI < 16; ++llllllllllllllIllIlIIlIllIIllllI) {
                    if (llllllllllllllIllIlIIlIllIlIIIII == 0 || llllllllllllllIllIlIIlIllIlIIIII == 15 || llllllllllllllIllIlIIlIllIIlllll == 0 || llllllllllllllIllIlIIlIllIIlllll == 15 || llllllllllllllIllIlIIlIllIIllllI == 0 || llllllllllllllIllIlIIlIllIIllllI == 15) {
                        VisGraph.field_178613_e[llllllllllllllIllIlIIlIllIlIIIIl++] = func_178605_a(llllllllllllllIllIlIIlIllIlIIIII, llllllllllllllIllIlIIlIllIIlllll, llllllllllllllIllIlIIlIllIIllllI);
                    }
                }
            }
        }
    }
    
    public SetVisibility func_178607_a() {
        final SetVisibility llllllllllllllIllIlIIlIlIlllIlIl = new SetVisibility();
        if (4096 - this.field_178611_f < 256) {
            llllllllllllllIllIlIIlIlIlllIlIl.func_178618_a(true);
        }
        else if (this.field_178611_f == 0) {
            llllllllllllllIllIlIIlIlIlllIlIl.func_178618_a(false);
        }
        else {
            for (final int llllllllllllllIllIlIIlIlIlllIIIl : VisGraph.field_178613_e) {
                if (!this.field_178612_d.get(llllllllllllllIllIlIIlIlIlllIIIl)) {
                    llllllllllllllIllIlIIlIlIlllIlIl.func_178620_a(this.func_178604_a(llllllllllllllIllIlIIlIlIlllIIIl));
                }
            }
        }
        return llllllllllllllIllIlIIlIlIlllIlIl;
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_178617_a;
        
        static {
            __OBFID = "CL_00002449";
            field_178617_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_178617_a[EnumFacing.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_178617_a[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_178617_a[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_178617_a[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_178617_a[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.field_178617_a[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
