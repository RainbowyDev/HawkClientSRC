package net.minecraft.client.util;

import java.util.*;
import com.google.common.collect.*;
import java.io.*;
import org.apache.commons.lang3.*;

public class JsonException extends IOException
{
    private final /* synthetic */ String field_151382_b;
    private final /* synthetic */ List field_151383_a;
    
    static {
        __OBFID = "CL_00001414";
    }
    
    public JsonException(final String lllllllllllllllIllIlIIllIIIlIlIl, final Throwable lllllllllllllllIllIlIIllIIIlIlII) {
        super(lllllllllllllllIllIlIIllIIIlIlII);
        this.field_151383_a = Lists.newArrayList();
        this.field_151383_a.add(new Entry(null));
        this.field_151382_b = lllllllllllllllIllIlIIllIIIlIlIl;
    }
    
    public static JsonException func_151379_a(final Exception lllllllllllllllIllIlIIllIIIIIIlI) {
        if (lllllllllllllllIllIlIIllIIIIIIlI instanceof JsonException) {
            return (JsonException)lllllllllllllllIllIlIIllIIIIIIlI;
        }
        String lllllllllllllllIllIlIIllIIIIIIIl = lllllllllllllllIllIlIIllIIIIIIlI.getMessage();
        if (lllllllllllllllIllIlIIllIIIIIIlI instanceof FileNotFoundException) {
            lllllllllllllllIllIlIIllIIIIIIIl = "File not found";
        }
        return new JsonException(lllllllllllllllIllIlIIllIIIIIIIl, lllllllllllllllIllIlIIllIIIIIIlI);
    }
    
    @Override
    public String getMessage() {
        return String.valueOf(new StringBuilder("Invalid ").append(this.field_151383_a.get(this.field_151383_a.size() - 1).toString()).append(": ").append(this.field_151382_b));
    }
    
    public void func_151380_a(final String lllllllllllllllIllIlIIllIIIlIIII) {
        this.field_151383_a.get(0).func_151373_a(lllllllllllllllIllIlIIllIIIlIIII);
    }
    
    public void func_151381_b(final String lllllllllllllllIllIlIIllIIIIlIII) {
        Entry.access$1(this.field_151383_a.get(0), lllllllllllllllIllIlIIllIIIIlIII);
        this.field_151383_a.add(0, new Entry(null));
    }
    
    public JsonException(final String lllllllllllllllIllIlIIllIIIlllIl) {
        this.field_151383_a = Lists.newArrayList();
        this.field_151383_a.add(new Entry(null));
        this.field_151382_b = lllllllllllllllIllIlIIllIIIlllIl;
    }
    
    public static class Entry
    {
        private final /* synthetic */ List field_151375_b;
        private /* synthetic */ String field_151376_a;
        
        private void func_151373_a(final String lllllllllllllllIIllIlIllIlIIlllI) {
            this.field_151375_b.add(0, lllllllllllllllIIllIlIllIlIIlllI);
        }
        
        static {
            __OBFID = "CL_00001416";
        }
        
        Entry(final Object lllllllllllllllIIllIlIllIlIIIlIl) {
            this();
        }
        
        @Override
        public String toString() {
            return (this.field_151376_a != null) ? (this.field_151375_b.isEmpty() ? this.field_151376_a : String.valueOf(new StringBuilder(String.valueOf(this.field_151376_a)).append(" ").append(this.func_151372_b()))) : (this.field_151375_b.isEmpty() ? "(Unknown file)" : String.valueOf(new StringBuilder("(Unknown file) ").append(this.func_151372_b())));
        }
        
        static /* synthetic */ void access$1(final Entry lllllllllllllllIIllIlIllIIllllIl, final String lllllllllllllllIIllIlIllIIllllII) {
            lllllllllllllllIIllIlIllIIllllIl.field_151376_a = lllllllllllllllIIllIlIllIIllllII;
        }
        
        private Entry() {
            this.field_151376_a = null;
            this.field_151375_b = Lists.newArrayList();
        }
        
        public String func_151372_b() {
            return StringUtils.join((Iterable)this.field_151375_b, "->");
        }
    }
}
