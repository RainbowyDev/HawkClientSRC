package net.minecraft.client.stream;

import com.google.gson.*;
import java.util.*;
import com.google.common.collect.*;
import com.google.common.base.*;

public class Metadata
{
    private /* synthetic */ String field_152813_c;
    private final /* synthetic */ String field_152812_b;
    private static final /* synthetic */ Gson field_152811_a;
    private /* synthetic */ Map field_152814_d;
    
    static {
        __OBFID = "CL_00001823";
        field_152811_a = new Gson();
    }
    
    public void func_152807_a(final String llllllllllllllIlIIIIllIlIIlIIIII) {
        this.field_152813_c = llllllllllllllIlIIIIllIlIIlIIIII;
    }
    
    public void func_152808_a(final String llllllllllllllIlIIIIllIlIIIlIllI, final String llllllllllllllIlIIIIllIlIIIlIIlI) {
        if (this.field_152814_d == null) {
            this.field_152814_d = Maps.newHashMap();
        }
        if (this.field_152814_d.size() > 50) {
            throw new IllegalArgumentException("Metadata payload is full, cannot add more to it!");
        }
        if (llllllllllllllIlIIIIllIlIIIlIllI == null) {
            throw new IllegalArgumentException("Metadata payload key cannot be null!");
        }
        if (llllllllllllllIlIIIIllIlIIIlIllI.length() > 255) {
            throw new IllegalArgumentException("Metadata payload key is too long!");
        }
        if (llllllllllllllIlIIIIllIlIIIlIIlI == null) {
            throw new IllegalArgumentException("Metadata payload value cannot be null!");
        }
        if (llllllllllllllIlIIIIllIlIIIlIIlI.length() > 255) {
            throw new IllegalArgumentException("Metadata payload value is too long!");
        }
        this.field_152814_d.put(llllllllllllllIlIIIIllIlIIIlIllI, llllllllllllllIlIIIIllIlIIIlIIlI);
    }
    
    public Metadata(final String llllllllllllllIlIIIIllIlIIlIlllI, final String llllllllllllllIlIIIIllIlIIlIlIlI) {
        this.field_152812_b = llllllllllllllIlIIIIllIlIIlIlllI;
        this.field_152813_c = llllllllllllllIlIIIIllIlIIlIlIlI;
    }
    
    public Metadata(final String llllllllllllllIlIIIIllIlIIlIIllI) {
        this(llllllllllllllIlIIIIllIlIIlIIllI, null);
    }
    
    public String func_152810_c() {
        return this.field_152812_b;
    }
    
    public String func_152806_b() {
        return (this.field_152814_d != null && !this.field_152814_d.isEmpty()) ? Metadata.field_152811_a.toJson((Object)this.field_152814_d) : null;
    }
    
    public String func_152809_a() {
        return (this.field_152813_c == null) ? this.field_152812_b : this.field_152813_c;
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper((Object)this).add("name", (Object)this.field_152812_b).add("description", (Object)this.field_152813_c).add("data", (Object)this.func_152806_b()).toString();
    }
}
