package net.minecraft.client.util;

import com.google.gson.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;

public class JsonBlendingMode
{
    private final /* synthetic */ int field_148116_b;
    private final /* synthetic */ boolean field_148113_g;
    private static /* synthetic */ JsonBlendingMode field_148118_a;
    private final /* synthetic */ int field_148117_c;
    private final /* synthetic */ int field_148115_e;
    private final /* synthetic */ boolean field_148119_h;
    private final /* synthetic */ int field_148114_d;
    private final /* synthetic */ int field_148112_f;
    
    public static JsonBlendingMode func_148110_a(final JsonObject llllllllllllllllIIIIIIlllllIllIl) {
        if (llllllllllllllllIIIIIIlllllIllIl == null) {
            return new JsonBlendingMode();
        }
        int llllllllllllllllIIIIIIlllllIllII = 32774;
        int llllllllllllllllIIIIIIlllllIlIll = 1;
        int llllllllllllllllIIIIIIlllllIlIlI = 0;
        int llllllllllllllllIIIIIIlllllIlIIl = 1;
        int llllllllllllllllIIIIIIlllllIlIII = 0;
        boolean llllllllllllllllIIIIIIlllllIIlll = true;
        boolean llllllllllllllllIIIIIIlllllIIllI = false;
        if (JsonUtils.jsonObjectFieldTypeIsString(llllllllllllllllIIIIIIlllllIllIl, "func")) {
            llllllllllllllllIIIIIIlllllIllII = func_148108_a(llllllllllllllllIIIIIIlllllIllIl.get("func").getAsString());
            if (llllllllllllllllIIIIIIlllllIllII != 32774) {
                llllllllllllllllIIIIIIlllllIIlll = false;
            }
        }
        if (JsonUtils.jsonObjectFieldTypeIsString(llllllllllllllllIIIIIIlllllIllIl, "srcrgb")) {
            llllllllllllllllIIIIIIlllllIlIll = func_148107_b(llllllllllllllllIIIIIIlllllIllIl.get("srcrgb").getAsString());
            if (llllllllllllllllIIIIIIlllllIlIll != 1) {
                llllllllllllllllIIIIIIlllllIIlll = false;
            }
        }
        if (JsonUtils.jsonObjectFieldTypeIsString(llllllllllllllllIIIIIIlllllIllIl, "dstrgb")) {
            llllllllllllllllIIIIIIlllllIlIlI = func_148107_b(llllllllllllllllIIIIIIlllllIllIl.get("dstrgb").getAsString());
            if (llllllllllllllllIIIIIIlllllIlIlI != 0) {
                llllllllllllllllIIIIIIlllllIIlll = false;
            }
        }
        if (JsonUtils.jsonObjectFieldTypeIsString(llllllllllllllllIIIIIIlllllIllIl, "srcalpha")) {
            llllllllllllllllIIIIIIlllllIlIIl = func_148107_b(llllllllllllllllIIIIIIlllllIllIl.get("srcalpha").getAsString());
            if (llllllllllllllllIIIIIIlllllIlIIl != 1) {
                llllllllllllllllIIIIIIlllllIIlll = false;
            }
            llllllllllllllllIIIIIIlllllIIllI = true;
        }
        if (JsonUtils.jsonObjectFieldTypeIsString(llllllllllllllllIIIIIIlllllIllIl, "dstalpha")) {
            llllllllllllllllIIIIIIlllllIlIII = func_148107_b(llllllllllllllllIIIIIIlllllIllIl.get("dstalpha").getAsString());
            if (llllllllllllllllIIIIIIlllllIlIII != 0) {
                llllllllllllllllIIIIIIlllllIIlll = false;
            }
            llllllllllllllllIIIIIIlllllIIllI = true;
        }
        return llllllllllllllllIIIIIIlllllIIlll ? new JsonBlendingMode() : (llllllllllllllllIIIIIIlllllIIllI ? new JsonBlendingMode(llllllllllllllllIIIIIIlllllIlIll, llllllllllllllllIIIIIIlllllIlIlI, llllllllllllllllIIIIIIlllllIlIIl, llllllllllllllllIIIIIIlllllIlIII, llllllllllllllllIIIIIIlllllIllII) : new JsonBlendingMode(llllllllllllllllIIIIIIlllllIlIll, llllllllllllllllIIIIIIlllllIlIlI, llllllllllllllllIIIIIIlllllIllII));
    }
    
    static {
        __OBFID = "CL_00001038";
        JsonBlendingMode.field_148118_a = null;
    }
    
    public JsonBlendingMode(final int llllllllllllllllIIIIIlIIIIIlIlIl, final int llllllllllllllllIIIIIlIIIIIlIlII, final int llllllllllllllllIIIIIlIIIIIlIIll, final int llllllllllllllllIIIIIlIIIIIIllII, final int llllllllllllllllIIIIIlIIIIIIlIll) {
        this(true, false, llllllllllllllllIIIIIlIIIIIlIlIl, llllllllllllllllIIIIIlIIIIIlIlII, llllllllllllllllIIIIIlIIIIIlIIll, llllllllllllllllIIIIIlIIIIIIllII, llllllllllllllllIIIIIlIIIIIIlIll);
    }
    
    public void func_148109_a() {
        if (!this.equals(JsonBlendingMode.field_148118_a)) {
            if (JsonBlendingMode.field_148118_a == null || this.field_148119_h != JsonBlendingMode.field_148118_a.func_148111_b()) {
                JsonBlendingMode.field_148118_a = this;
                if (this.field_148119_h) {
                    GlStateManager.disableBlend();
                    return;
                }
                GlStateManager.enableBlend();
            }
            GL14.glBlendEquation(this.field_148112_f);
            if (this.field_148113_g) {
                GlStateManager.tryBlendFuncSeparate(this.field_148116_b, this.field_148114_d, this.field_148117_c, this.field_148115_e);
            }
            else {
                GlStateManager.blendFunc(this.field_148116_b, this.field_148114_d);
            }
        }
    }
    
    public JsonBlendingMode() {
        this(false, true, 1, 0, 1, 0, 32774);
    }
    
    private JsonBlendingMode(final boolean llllllllllllllllIIIIIlIIIIllIIlI, final boolean llllllllllllllllIIIIIlIIIIlllIIl, final int llllllllllllllllIIIIIlIIIIlllIII, final int llllllllllllllllIIIIIlIIIIlIllll, final int llllllllllllllllIIIIIlIIIIlIlllI, final int llllllllllllllllIIIIIlIIIIllIlIl, final int llllllllllllllllIIIIIlIIIIlIllII) {
        this.field_148113_g = llllllllllllllllIIIIIlIIIIllIIlI;
        this.field_148116_b = llllllllllllllllIIIIIlIIIIlllIII;
        this.field_148114_d = llllllllllllllllIIIIIlIIIIlIllll;
        this.field_148117_c = llllllllllllllllIIIIIlIIIIlIlllI;
        this.field_148115_e = llllllllllllllllIIIIIlIIIIllIlIl;
        this.field_148119_h = llllllllllllllllIIIIIlIIIIlllIIl;
        this.field_148112_f = llllllllllllllllIIIIIlIIIIlIllII;
    }
    
    private static int func_148108_a(final String llllllllllllllllIIIIIIllllIllIll) {
        final String llllllllllllllllIIIIIIllllIllIlI = llllllllllllllllIIIIIIllllIllIll.trim().toLowerCase();
        return llllllllllllllllIIIIIIllllIllIlI.equals("add") ? 32774 : (llllllllllllllllIIIIIIllllIllIlI.equals("subtract") ? 32778 : (llllllllllllllllIIIIIIllllIllIlI.equals("reversesubtract") ? 32779 : (llllllllllllllllIIIIIIllllIllIlI.equals("reverse_subtract") ? 32779 : (llllllllllllllllIIIIIIllllIllIlI.equals("min") ? 32775 : (llllllllllllllllIIIIIIllllIllIlI.equals("max") ? 32776 : 32774)))));
    }
    
    private static int func_148107_b(final String llllllllllllllllIIIIIIllllIlIIll) {
        String llllllllllllllllIIIIIIllllIlIlII = llllllllllllllllIIIIIIllllIlIIll.trim().toLowerCase();
        llllllllllllllllIIIIIIllllIlIlII = llllllllllllllllIIIIIIllllIlIlII.replaceAll("_", "");
        llllllllllllllllIIIIIIllllIlIlII = llllllllllllllllIIIIIIllllIlIlII.replaceAll("one", "1");
        llllllllllllllllIIIIIIllllIlIlII = llllllllllllllllIIIIIIllllIlIlII.replaceAll("zero", "0");
        llllllllllllllllIIIIIIllllIlIlII = llllllllllllllllIIIIIIllllIlIlII.replaceAll("minus", "-");
        return llllllllllllllllIIIIIIllllIlIlII.equals("0") ? 0 : (llllllllllllllllIIIIIIllllIlIlII.equals("1") ? 1 : (llllllllllllllllIIIIIIllllIlIlII.equals("srccolor") ? 768 : (llllllllllllllllIIIIIIllllIlIlII.equals("1-srccolor") ? 769 : (llllllllllllllllIIIIIIllllIlIlII.equals("dstcolor") ? 774 : (llllllllllllllllIIIIIIllllIlIlII.equals("1-dstcolor") ? 775 : (llllllllllllllllIIIIIIllllIlIlII.equals("srcalpha") ? 770 : (llllllllllllllllIIIIIIllllIlIlII.equals("1-srcalpha") ? 771 : (llllllllllllllllIIIIIIllllIlIlII.equals("dstalpha") ? 772 : (llllllllllllllllIIIIIIllllIlIlII.equals("1-dstalpha") ? 773 : -1)))))))));
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIIIIlIIIIIIIIII) {
        if (this == llllllllllllllllIIIIIlIIIIIIIIII) {
            return true;
        }
        if (!(llllllllllllllllIIIIIlIIIIIIIIII instanceof JsonBlendingMode)) {
            return false;
        }
        final JsonBlendingMode llllllllllllllllIIIIIlIIIIIIIIlI = (JsonBlendingMode)llllllllllllllllIIIIIlIIIIIIIIII;
        return this.field_148112_f == llllllllllllllllIIIIIlIIIIIIIIlI.field_148112_f && this.field_148115_e == llllllllllllllllIIIIIlIIIIIIIIlI.field_148115_e && this.field_148114_d == llllllllllllllllIIIIIlIIIIIIIIlI.field_148114_d && this.field_148119_h == llllllllllllllllIIIIIlIIIIIIIIlI.field_148119_h && this.field_148113_g == llllllllllllllllIIIIIlIIIIIIIIlI.field_148113_g && this.field_148117_c == llllllllllllllllIIIIIlIIIIIIIIlI.field_148117_c && this.field_148116_b == llllllllllllllllIIIIIlIIIIIIIIlI.field_148116_b;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllllIIIIIIlllllllIll = this.field_148116_b;
        llllllllllllllllIIIIIIlllllllIll = 31 * llllllllllllllllIIIIIIlllllllIll + this.field_148117_c;
        llllllllllllllllIIIIIIlllllllIll = 31 * llllllllllllllllIIIIIIlllllllIll + this.field_148114_d;
        llllllllllllllllIIIIIIlllllllIll = 31 * llllllllllllllllIIIIIIlllllllIll + this.field_148115_e;
        llllllllllllllllIIIIIIlllllllIll = 31 * llllllllllllllllIIIIIIlllllllIll + this.field_148112_f;
        llllllllllllllllIIIIIIlllllllIll = 31 * llllllllllllllllIIIIIIlllllllIll + (this.field_148113_g ? 1 : 0);
        llllllllllllllllIIIIIIlllllllIll = 31 * llllllllllllllllIIIIIIlllllllIll + (this.field_148119_h ? 1 : 0);
        return llllllllllllllllIIIIIIlllllllIll;
    }
    
    public JsonBlendingMode(final int llllllllllllllllIIIIIlIIIIIlllll, final int llllllllllllllllIIIIIlIIIIIllllI, final int llllllllllllllllIIIIIlIIIIlIIIIl) {
        this(false, false, llllllllllllllllIIIIIlIIIIIlllll, llllllllllllllllIIIIIlIIIIIllllI, llllllllllllllllIIIIIlIIIIIlllll, llllllllllllllllIIIIIlIIIIIllllI, llllllllllllllllIIIIIlIIIIlIIIIl);
    }
    
    public boolean func_148111_b() {
        return this.field_148119_h;
    }
}
