package net.minecraft.client.renderer.vertex;

import org.apache.logging.log4j.*;
import java.util.*;
import com.google.common.collect.*;

public class VertexFormat
{
    private /* synthetic */ List field_177351_f;
    private final /* synthetic */ List field_177355_b;
    private final /* synthetic */ List field_177356_c;
    private /* synthetic */ int field_177352_g;
    private /* synthetic */ int field_177354_e;
    private /* synthetic */ int field_177353_d;
    private static final /* synthetic */ Logger field_177357_a;
    
    public VertexFormatElement func_177348_c(final int llllllllllllllIllllIlllIIlIlllII) {
        return this.field_177355_b.get(llllllllllllllIllllIlllIIlIlllII);
    }
    
    public boolean func_177347_a(final int llllllllllllllIllllIlllIlIIIlIII) {
        return this.field_177351_f.size() - 1 >= llllllllllllllIllllIlllIlIIIlIII;
    }
    
    public boolean func_177350_b() {
        return this.field_177352_g >= 0;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIllllIlllIIlIlIlII) {
        if (this == llllllllllllllIllllIlllIIlIlIlII) {
            return true;
        }
        if (llllllllllllllIllllIlllIIlIlIlII != null && this.getClass() == llllllllllllllIllllIlllIIlIlIlII.getClass()) {
            final VertexFormat llllllllllllllIllllIlllIIlIlIllI = (VertexFormat)llllllllllllllIllllIlllIIlIlIlII;
            return this.field_177353_d == llllllllllllllIllllIlllIIlIlIllI.field_177353_d && this.field_177355_b.equals(llllllllllllllIllllIlllIIlIlIllI.field_177355_b) && this.field_177356_c.equals(llllllllllllllIllllIlllIIlIlIllI.field_177356_c);
        }
        return false;
    }
    
    public int func_177342_c() {
        return this.field_177352_g;
    }
    
    static {
        __OBFID = "CL_00002401";
        field_177357_a = LogManager.getLogger();
    }
    
    public VertexFormat(final VertexFormat llllllllllllllIllllIlllIlIlIlIII) {
        this();
        for (int llllllllllllllIllllIlllIlIlIIlll = 0; llllllllllllllIllllIlllIlIlIIlll < llllllllllllllIllllIlllIlIlIlIII.func_177345_h(); ++llllllllllllllIllllIlllIlIlIIlll) {
            this.func_177349_a(llllllllllllllIllllIlllIlIlIlIII.func_177348_c(llllllllllllllIllllIlllIlIlIIlll));
        }
        this.field_177353_d = llllllllllllllIllllIlllIlIlIlIII.func_177338_f();
    }
    
    private boolean func_177341_i() {
        for (final VertexFormatElement llllllllllllllIllllIlllIIllIlllI : this.field_177355_b) {
            if (llllllllllllllIllllIlllIIllIlllI.func_177374_g()) {
                return true;
            }
        }
        return false;
    }
    
    public int func_177345_h() {
        return this.field_177355_b.size();
    }
    
    public void clear() {
        this.field_177355_b.clear();
        this.field_177356_c.clear();
        this.field_177354_e = -1;
        this.field_177351_f.clear();
        this.field_177352_g = -1;
        this.field_177353_d = 0;
    }
    
    public int func_177340_e() {
        return this.field_177354_e;
    }
    
    @Override
    public String toString() {
        String llllllllllllllIllllIlllIIllllIlI = String.valueOf(new StringBuilder("format: ").append(this.field_177355_b.size()).append(" elements: "));
        for (int llllllllllllllIllllIlllIIllllIIl = 0; llllllllllllllIllllIlllIIllllIIl < this.field_177355_b.size(); ++llllllllllllllIllllIlllIIllllIIl) {
            llllllllllllllIllllIlllIIllllIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllllIlllIIllllIlI)).append(this.field_177355_b.get(llllllllllllllIllllIlllIIllllIIl).toString()));
            if (llllllllllllllIllllIlllIIllllIIl != this.field_177355_b.size() - 1) {
                llllllllllllllIllllIlllIIllllIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllllIlllIIllllIlI)).append(" "));
            }
        }
        return llllllllllllllIllllIlllIIllllIlI;
    }
    
    public boolean func_177346_d() {
        return this.field_177354_e >= 0;
    }
    
    public VertexFormat() {
        this.field_177355_b = Lists.newArrayList();
        this.field_177356_c = Lists.newArrayList();
        this.field_177353_d = 0;
        this.field_177354_e = -1;
        this.field_177351_f = Lists.newArrayList();
        this.field_177352_g = -1;
    }
    
    public int func_177344_b(final int llllllllllllllIllllIlllIlIIIIIII) {
        return this.field_177351_f.get(llllllllllllllIllllIlllIlIIIIIII);
    }
    
    public void func_177349_a(final VertexFormatElement llllllllllllllIllllIlllIlIIllIlI) {
        if (llllllllllllllIllllIlllIlIIllIlI.func_177374_g() && this.func_177341_i()) {
            VertexFormat.field_177357_a.warn("VertexFormat error: Trying to add a position VertexFormatElement when one already exists, ignoring.");
        }
        else {
            this.field_177355_b.add(llllllllllllllIllllIlllIlIIllIlI);
            this.field_177356_c.add(this.field_177353_d);
            llllllllllllllIllllIlllIlIIllIlI.func_177371_a(this.field_177353_d);
            this.field_177353_d += llllllllllllllIllllIlllIlIIllIlI.func_177368_f();
            switch (SwitchEnumUseage.field_177382_a[llllllllllllllIllllIlllIlIIllIlI.func_177375_c().ordinal()]) {
                case 1: {
                    this.field_177352_g = llllllllllllllIllllIlllIlIIllIlI.func_177373_a();
                    break;
                }
                case 2: {
                    this.field_177354_e = llllllllllllllIllllIlllIlIIllIlI.func_177373_a();
                    break;
                }
                case 3: {
                    this.field_177351_f.add(llllllllllllllIllllIlllIlIIllIlI.func_177369_e(), llllllllllllllIllllIlllIlIIllIlI.func_177373_a());
                    break;
                }
            }
        }
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIllllIlllIIlIIllll = this.field_177355_b.hashCode();
        llllllllllllllIllllIlllIIlIIllll = 31 * llllllllllllllIllllIlllIIlIIllll + this.field_177356_c.hashCode();
        llllllllllllllIllllIlllIIlIIllll = 31 * llllllllllllllIllllIlllIIlIIllll + this.field_177353_d;
        return llllllllllllllIllllIlllIIlIIllll;
    }
    
    public List func_177343_g() {
        return this.field_177355_b;
    }
    
    public int func_177338_f() {
        return this.field_177353_d;
    }
    
    static final class SwitchEnumUseage
    {
        static final /* synthetic */ int[] field_177382_a;
        
        static {
            __OBFID = "CL_00002400";
            field_177382_a = new int[VertexFormatElement.EnumUseage.values().length];
            try {
                SwitchEnumUseage.field_177382_a[VertexFormatElement.EnumUseage.NORMAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumUseage.field_177382_a[VertexFormatElement.EnumUseage.COLOR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumUseage.field_177382_a[VertexFormatElement.EnumUseage.UV.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
        }
    }
}
