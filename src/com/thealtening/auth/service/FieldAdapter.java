package com.thealtening.auth.service;

import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.*;

public final class FieldAdapter
{
    private static /* synthetic */ Field MODIFIERS;
    private final /* synthetic */ HashMap<String, MethodHandle> fields;
    private static final /* synthetic */ MethodHandles.Lookup LOOKUP;
    
    public FieldAdapter(final String llllllllllllllIllllIIlIlllIIIIlI) {
        this.fields = new HashMap<String, MethodHandle>();
        try {
            final Class llllllllllllllIllllIIlIlllIIIIIl = Class.forName(llllllllllllllIllllIIlIlllIIIIlI);
            final Field llllllllllllllIllllIIlIlllIIIIII = FieldAdapter.MODIFIERS;
            final byte llllllllllllllIllllIIlIllIllIIll;
            final long llllllllllllllIllllIIlIllIllIlII = ((Field[])(Object)(llllllllllllllIllllIIlIllIllIIll = (byte)(Object)llllllllllllllIllllIIlIlllIIIIIl.getDeclaredFields())).length;
            for (String llllllllllllllIllllIIlIllIllIlIl = (String)0; llllllllllllllIllllIIlIllIllIlIl < llllllllllllllIllllIIlIllIllIlII; ++llllllllllllllIllllIIlIllIllIlIl) {
                final Field llllllllllllllIllllIIlIllIllllll = llllllllllllllIllllIIlIllIllIIll[llllllllllllllIllllIIlIllIllIlIl];
                llllllllllllllIllllIIlIllIllllll.setAccessible(true);
                final int llllllllllllllIllllIIlIllIlllllI = llllllllllllllIllllIIlIllIllllll.getModifiers();
                if (Modifier.isFinal(llllllllllllllIllllIIlIllIlllllI)) {
                    llllllllllllllIllllIIlIlllIIIIII.setInt(llllllllllllllIllllIIlIllIllllll, llllllllllllllIllllIIlIllIlllllI & 0xFFFFFFEF);
                }
                MethodHandle llllllllllllllIllllIIlIllIllllIl = FieldAdapter.LOOKUP.unreflectSetter(llllllllllllllIllllIIlIllIllllll);
                llllllllllllllIllllIIlIllIllllIl = llllllllllllllIllllIIlIllIllllIl.asType(llllllllllllllIllllIIlIllIllllIl.type().generic().changeReturnType(Void.TYPE));
                this.fields.put(llllllllllllllIllllIIlIllIllllll.getName(), llllllllllllllIllllIIlIllIllllIl);
            }
        }
        catch (ClassNotFoundException llllllllllllllIllllIIlIllIllllII) {
            throw new RuntimeException("Couldn't load/find the specified class");
        }
        catch (Exception llllllllllllllIllllIIlIllIlllIll) {
            throw new RuntimeException("Couldn't create a method handler for the field");
        }
    }
    
    public void updateFieldIfPresent(final String llllllllllllllIllllIIlIllIlIllII, final Object llllllllllllllIllllIIlIllIlIlIll) {
        Optional.ofNullable(this.fields.get(llllllllllllllIllllIIlIllIlIllII)).ifPresent(llllllllllllllIllllIIlIllIlIIIIl -> {
            try {
                llllllllllllllIllllIIlIllIlIIIIl.invokeExact(llllllllllllllIllllIIlIllIlIlIll);
            }
            catch (Throwable llllllllllllllIllllIIlIllIlIIIll) {
                llllllllllllllIllllIIlIllIlIIIll.printStackTrace();
            }
        });
    }
    
    static {
        try {
            (FieldAdapter.MODIFIERS = Field.class.getDeclaredField("modifiers")).setAccessible(true);
        }
        catch (NoSuchFieldException llllllllllllllIllllIIlIlllIlIlII) {
            llllllllllllllIllllIIlIlllIlIlII.printStackTrace();
        }
        MethodHandles.Lookup llllllllllllllIllllIIlIlllIlIIlI = null;
        try {
            final Field llllllllllllllIllllIIlIlllIlIIIl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            llllllllllllllIllllIIlIlllIlIIIl.setAccessible(true);
            final MethodHandles.Lookup llllllllllllllIllllIIlIlllIlIIll = (MethodHandles.Lookup)llllllllllllllIllllIIlIlllIlIIIl.get(null);
        }
        catch (ReflectiveOperationException llllllllllllllIllllIIlIlllIlIIII) {
            llllllllllllllIllllIIlIlllIlIIlI = MethodHandles.lookup();
        }
        LOOKUP = llllllllllllllIllllIIlIlllIlIIlI;
    }
}
