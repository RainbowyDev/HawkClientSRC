package org.json;

import java.util.regex.*;
import java.lang.annotation.*;
import java.math.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class JSONObject
{
    public static final /* synthetic */ Object NULL;
    private final /* synthetic */ Map<String, Object> map;
    
    private static <A extends Annotation> A getAnnotation(final Method llllllllllllllIIlllllIIIIlIIlIlI, final Class<A> llllllllllllllIIlllllIIIIlIIIllI) {
        if (llllllllllllllIIlllllIIIIlIIlIlI == null || llllllllllllllIIlllllIIIIlIIIllI == null) {
            return null;
        }
        if (llllllllllllllIIlllllIIIIlIIlIlI.isAnnotationPresent(llllllllllllllIIlllllIIIIlIIIllI)) {
            return llllllllllllllIIlllllIIIIlIIlIlI.getAnnotation(llllllllllllllIIlllllIIIIlIIIllI);
        }
        final Class<?> llllllllllllllIIlllllIIIIlIIlIII = llllllllllllllIIlllllIIIIlIIlIlI.getDeclaringClass();
        if (llllllllllllllIIlllllIIIIlIIlIII.getSuperclass() == null) {
            return null;
        }
        final long llllllllllllllIIlllllIIIIlIIIlII = (Object)llllllllllllllIIlllllIIIIlIIlIII.getInterfaces();
        final byte llllllllllllllIIlllllIIIIlIIIIll = (byte)llllllllllllllIIlllllIIIIlIIIlII.length;
        for (char llllllllllllllIIlllllIIIIlIIIIlI = '\0'; llllllllllllllIIlllllIIIIlIIIIlI < llllllllllllllIIlllllIIIIlIIIIll; ++llllllllllllllIIlllllIIIIlIIIIlI) {
            final Class<?> llllllllllllllIIlllllIIIIlIIllIl = llllllllllllllIIlllllIIIIlIIIlII[llllllllllllllIIlllllIIIIlIIIIlI];
            try {
                final Method llllllllllllllIIlllllIIIIlIlIIII = llllllllllllllIIlllllIIIIlIIllIl.getMethod(llllllllllllllIIlllllIIIIlIIlIlI.getName(), llllllllllllllIIlllllIIIIlIIlIlI.getParameterTypes());
                return (A)getAnnotation(llllllllllllllIIlllllIIIIlIlIIII, (Class<Annotation>)llllllllllllllIIlllllIIIIlIIIllI);
            }
            catch (SecurityException llllllllllllllIIlllllIIIIlIIllll) {}
            catch (NoSuchMethodException llllllllllllllIIlllllIIIIlIIlllI) {}
        }
        try {
            return (A)getAnnotation(llllllllllllllIIlllllIIIIlIIlIII.getSuperclass().getMethod(llllllllllllllIIlllllIIIIlIIlIlI.getName(), llllllllllllllIIlllllIIIIlIIlIlI.getParameterTypes()), (Class<Annotation>)llllllllllllllIIlllllIIIIlIIIllI);
        }
        catch (SecurityException llllllllllllllIIlllllIIIIlIIllII) {
            return null;
        }
        catch (NoSuchMethodException llllllllllllllIIlllllIIIIlIIlIll) {
            return null;
        }
    }
    
    public static Object stringToValue(final String llllllllllllllIIllllIlllIlIllIll) {
        if ("".equals(llllllllllllllIIllllIlllIlIllIll)) {
            return llllllllllllllIIllllIlllIlIllIll;
        }
        if ("true".equalsIgnoreCase(llllllllllllllIIllllIlllIlIllIll)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(llllllllllllllIIllllIlllIlIllIll)) {
            return Boolean.FALSE;
        }
        if ("null".equalsIgnoreCase(llllllllllllllIIllllIlllIlIllIll)) {
            return JSONObject.NULL;
        }
        final char llllllllllllllIIllllIlllIlIlllII = llllllllllllllIIllllIlllIlIllIll.charAt(0);
        if (llllllllllllllIIllllIlllIlIlllII < '0' || llllllllllllllIIllllIlllIlIlllII > '9') {
            if (llllllllllllllIIllllIlllIlIlllII != '-') {
                return llllllllllllllIIllllIlllIlIllIll;
            }
        }
        try {
            if (isDecimalNotation(llllllllllllllIIllllIlllIlIllIll)) {
                final Double llllllllllllllIIllllIlllIllIIIII = Double.valueOf(llllllllllllllIIllllIlllIlIllIll);
                if (!llllllllllllllIIllllIlllIllIIIII.isInfinite() && !llllllllllllllIIllllIlllIllIIIII.isNaN()) {
                    return llllllllllllllIIllllIlllIllIIIII;
                }
            }
            else {
                final Long llllllllllllllIIllllIlllIlIlllll = Long.valueOf(llllllllllllllIIllllIlllIlIllIll);
                if (llllllllllllllIIllllIlllIlIllIll.equals(llllllllllllllIIllllIlllIlIlllll.toString())) {
                    if (llllllllllllllIIllllIlllIlIlllll == llllllllllllllIIllllIlllIlIlllll.intValue()) {
                        return llllllllllllllIIllllIlllIlIlllll.intValue();
                    }
                    return llllllllllllllIIllllIlllIlIlllll;
                }
            }
        }
        catch (Exception ex) {}
        return llllllllllllllIIllllIlllIlIllIll;
    }
    
    public <E extends Enum<E>> E optEnum(final Class<E> llllllllllllllIIlllllIIlIllIIIlI, final String llllllllllllllIIlllllIIlIllIIlIl, final E llllllllllllllIIlllllIIlIllIIIII) {
        try {
            final Object llllllllllllllIIlllllIIlIllIlIlI = this.opt(llllllllllllllIIlllllIIlIllIIlIl);
            if (JSONObject.NULL.equals(llllllllllllllIIlllllIIlIllIlIlI)) {
                return llllllllllllllIIlllllIIlIllIIIII;
            }
            if (llllllllllllllIIlllllIIlIllIIIlI.isAssignableFrom(llllllllllllllIIlllllIIlIllIlIlI.getClass())) {
                final E llllllllllllllIIlllllIIlIllIlIll = (E)llllllllllllllIIlllllIIlIllIlIlI;
                return llllllllllllllIIlllllIIlIllIlIll;
            }
            return Enum.valueOf(llllllllllllllIIlllllIIlIllIIIlI, llllllllllllllIIlllllIIlIllIlIlI.toString());
        }
        catch (IllegalArgumentException llllllllllllllIIlllllIIlIllIlIIl) {
            return llllllllllllllIIlllllIIlIllIIIII;
        }
        catch (NullPointerException llllllllllllllIIlllllIIlIllIlIII) {
            return llllllllllllllIIlllllIIlIllIIIII;
        }
    }
    
    public int optInt(final String llllllllllllllIIlllllIIIlllIIllI, final int llllllllllllllIIlllllIIIlllIIIIl) {
        final Number llllllllllllllIIlllllIIIlllIIlII = this.optNumber(llllllllllllllIIlllllIIIlllIIllI, null);
        if (llllllllllllllIIlllllIIIlllIIlII == null) {
            return llllllllllllllIIlllllIIIlllIIIIl;
        }
        return llllllllllllllIIlllllIIIlllIIlII.intValue();
    }
    
    public String toString(final int llllllllllllllIIllllIlllIIlllIlI) throws JSONException {
        final StringWriter llllllllllllllIIllllIlllIIllllII = new StringWriter();
        synchronized (llllllllllllllIIllllIlllIIllllII.getBuffer()) {
            return this.write(llllllllllllllIIllllIlllIIllllII, llllllllllllllIIllllIlllIIlllIlI, 0).toString();
        }
    }
    
    public boolean getBoolean(final String llllllllllllllIIlllllIlIIIllIIll) throws JSONException {
        final Object llllllllllllllIIlllllIlIIIllIlIl = this.get(llllllllllllllIIlllllIlIIIllIIll);
        if (llllllllllllllIIlllllIlIIIllIlIl.equals(Boolean.FALSE) || (llllllllllllllIIlllllIlIIIllIlIl instanceof String && ((String)llllllllllllllIIlllllIlIIIllIlIl).equalsIgnoreCase("false"))) {
            return false;
        }
        if (llllllllllllllIIlllllIlIIIllIlIl.equals(Boolean.TRUE) || (llllllllllllllIIlllllIlIIIllIlIl instanceof String && ((String)llllllllllllllIIlllllIlIIIllIlIl).equalsIgnoreCase("true"))) {
            return true;
        }
        throw wrongValueFormatException(llllllllllllllIIlllllIlIIIllIIll, "Boolean", null);
    }
    
    public double optDouble(final String llllllllllllllIIlllllIIlIIIllIII) {
        return this.optDouble(llllllllllllllIIlllllIIlIIIllIII, Double.NaN);
    }
    
    public Number getNumber(final String llllllllllllllIIlllllIIllllllIII) throws JSONException {
        final Object llllllllllllllIIlllllIIllllllIlI = this.get(llllllllllllllIIlllllIIllllllIII);
        try {
            if (llllllllllllllIIlllllIIllllllIlI instanceof Number) {
                return (Number)llllllllllllllIIlllllIIllllllIlI;
            }
            return stringToNumber(llllllllllllllIIlllllIIllllllIlI.toString());
        }
        catch (Exception llllllllllllllIIlllllIIlllllllIl) {
            throw wrongValueFormatException(llllllllllllllIIlllllIIllllllIII, "number", llllllllllllllIIlllllIIlllllllIl);
        }
    }
    
    public JSONObject(final JSONTokener llllllllllllllIIlllllIlIllIIlIlI) throws JSONException {
        this();
        if (llllllllllllllIIlllllIlIllIIlIlI.nextClean() != '{') {
            throw llllllllllllllIIlllllIlIllIIlIlI.syntaxError("A JSONObject text must begin with '{'");
        }
        while (true) {
            char llllllllllllllIIlllllIlIllIIllIl = llllllllllllllIIlllllIlIllIIlIlI.nextClean();
            switch (llllllllllllllIIlllllIlIllIIllIl) {
                case '\0': {
                    throw llllllllllllllIIlllllIlIllIIlIlI.syntaxError("A JSONObject text must end with '}'");
                }
                case '}': {}
                default: {
                    llllllllllllllIIlllllIlIllIIlIlI.back();
                    final String llllllllllllllIIlllllIlIllIIllII = llllllllllllllIIlllllIlIllIIlIlI.nextValue().toString();
                    llllllllllllllIIlllllIlIllIIllIl = llllllllllllllIIlllllIlIllIIlIlI.nextClean();
                    if (llllllllllllllIIlllllIlIllIIllIl != ':') {
                        throw llllllllllllllIIlllllIlIllIIlIlI.syntaxError("Expected a ':' after a key");
                    }
                    if (llllllllllllllIIlllllIlIllIIllII != null) {
                        if (this.opt(llllllllllllllIIlllllIlIllIIllII) != null) {
                            throw llllllllllllllIIlllllIlIllIIlIlI.syntaxError(String.valueOf(new StringBuilder().append("Duplicate key \"").append(llllllllllllllIIlllllIlIllIIllII).append("\"")));
                        }
                        final Object llllllllllllllIIlllllIlIllIlIIII = llllllllllllllIIlllllIlIllIIlIlI.nextValue();
                        if (llllllllllllllIIlllllIlIllIlIIII != null) {
                            this.put(llllllllllllllIIlllllIlIllIIllII, llllllllllllllIIlllllIlIllIlIIII);
                        }
                    }
                    switch (llllllllllllllIIlllllIlIllIIlIlI.nextClean()) {
                        case ',':
                        case ';': {
                            if (llllllllllllllIIlllllIlIllIIlIlI.nextClean() == '}') {
                                return;
                            }
                            llllllllllllllIIlllllIlIllIIlIlI.back();
                            continue;
                        }
                        case '}': {
                            return;
                        }
                        default: {
                            throw llllllllllllllIIlllllIlIllIIlIlI.syntaxError("Expected a ',' or '}'");
                        }
                    }
                    break;
                }
            }
        }
    }
    
    static final Writer writeValue(final Writer llllllllllllllIIllllIlllIIIlIIIl, final Object llllllllllllllIIllllIlllIIIlIlII, final int llllllllllllllIIllllIlllIIIlIIll, final int llllllllllllllIIllllIlllIIIlIIlI) throws JSONException, IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnull          12
        //     4: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //     5: aconst_null    
        //     6: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //     9: ifeq            21
        //    12: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //    13: ldc             "null"
        //    15: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //    18: goto            315
        //    21: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //    22: instanceof      Lorg/json/JSONString;
        //    25: ifeq            81
        //    28: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //    29: checkcast       Lorg/json/JSONString;
        //    32: invokeinterface org/json/JSONString.toJSONString:()Ljava/lang/String;
        //    37: astore          llllllllllllllIIllllIlllIIIllIlI
        //    39: goto            54
        //    42: astore          llllllllllllllIIllllIlllIIIllIll
        //    44: new             Lorg/json/JSONException;
        //    47: dup            
        //    48: aload           llllllllllllllIIllllIlllIIIllIll
        //    50: invokespecial   org/json/JSONException.<init>:(Ljava/lang/Throwable;)V
        //    53: athrow         
        //    54: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //    55: aload           llllllllllllllIIllllIlllIIIllIIl
        //    57: ifnull          68
        //    60: aload           llllllllllllllIIllllIlllIIIllIIl
        //    62: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    65: goto            75
        //    68: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //    69: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    72: invokestatic    org/json/JSONObject.quote:(Ljava/lang/String;)Ljava/lang/String;
        //    75: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //    78: goto            315
        //    81: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //    82: instanceof      Ljava/lang/Number;
        //    85: ifeq            130
        //    88: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //    89: checkcast       Ljava/lang/Number;
        //    92: invokestatic    org/json/JSONObject.numberToString:(Ljava/lang/Number;)Ljava/lang/String;
        //    95: astore          llllllllllllllIIllllIlllIIIllIII
        //    97: getstatic       org/json/JSONObject.NUMBER_PATTERN:Ljava/util/regex/Pattern;
        //   100: aload           llllllllllllllIIllllIlllIIIllIII
        //   102: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //   105: invokevirtual   java/util/regex/Matcher.matches:()Z
        //   108: ifeq            120
        //   111: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   112: aload           llllllllllllllIIllllIlllIIIllIII
        //   114: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //   117: goto            127
        //   120: aload           llllllllllllllIIllllIlllIIIllIII
        //   122: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   123: invokestatic    org/json/JSONObject.quote:(Ljava/lang/String;Ljava/io/Writer;)Ljava/io/Writer;
        //   126: pop            
        //   127: goto            315
        //   130: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   131: instanceof      Ljava/lang/Boolean;
        //   134: ifeq            148
        //   137: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   138: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   139: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   142: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //   145: goto            315
        //   148: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   149: instanceof      Ljava/lang/Enum;
        //   152: ifeq            172
        //   155: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   156: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   157: checkcast       Ljava/lang/Enum;
        //   160: invokevirtual   java/lang/Enum.name:()Ljava/lang/String;
        //   163: invokestatic    org/json/JSONObject.quote:(Ljava/lang/String;)Ljava/lang/String;
        //   166: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //   169: goto            315
        //   172: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   173: instanceof      Lorg/json/JSONObject;
        //   176: ifeq            193
        //   179: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   180: checkcast       Lorg/json/JSONObject;
        //   183: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   184: iload_2         /* llllllllllllllIIllllIlllIIIIllll */
        //   185: iload_3         /* llllllllllllllIIllllIlllIIIIlllI */
        //   186: invokevirtual   org/json/JSONObject.write:(Ljava/io/Writer;II)Ljava/io/Writer;
        //   189: pop            
        //   190: goto            315
        //   193: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   194: instanceof      Lorg/json/JSONArray;
        //   197: ifeq            214
        //   200: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   201: checkcast       Lorg/json/JSONArray;
        //   204: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   205: iload_2         /* llllllllllllllIIllllIlllIIIIllll */
        //   206: iload_3         /* llllllllllllllIIllllIlllIIIIlllI */
        //   207: invokevirtual   org/json/JSONArray.write:(Ljava/io/Writer;II)Ljava/io/Writer;
        //   210: pop            
        //   211: goto            315
        //   214: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   215: instanceof      Ljava/util/Map;
        //   218: ifeq            246
        //   221: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   222: checkcast       Ljava/util/Map;
        //   225: astore          llllllllllllllIIllllIlllIIIlIlll
        //   227: new             Lorg/json/JSONObject;
        //   230: dup            
        //   231: aload           llllllllllllllIIllllIlllIIIlIlll
        //   233: invokespecial   org/json/JSONObject.<init>:(Ljava/util/Map;)V
        //   236: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   237: iload_2         /* llllllllllllllIIllllIlllIIIIllll */
        //   238: iload_3         /* llllllllllllllIIllllIlllIIIIlllI */
        //   239: invokevirtual   org/json/JSONObject.write:(Ljava/io/Writer;II)Ljava/io/Writer;
        //   242: pop            
        //   243: goto            315
        //   246: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   247: instanceof      Ljava/util/Collection;
        //   250: ifeq            278
        //   253: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   254: checkcast       Ljava/util/Collection;
        //   257: astore          llllllllllllllIIllllIlllIIIlIllI
        //   259: new             Lorg/json/JSONArray;
        //   262: dup            
        //   263: aload           llllllllllllllIIllllIlllIIIlIllI
        //   265: invokespecial   org/json/JSONArray.<init>:(Ljava/util/Collection;)V
        //   268: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   269: iload_2         /* llllllllllllllIIllllIlllIIIIllll */
        //   270: iload_3         /* llllllllllllllIIllllIlllIIIIlllI */
        //   271: invokevirtual   org/json/JSONArray.write:(Ljava/io/Writer;II)Ljava/io/Writer;
        //   274: pop            
        //   275: goto            315
        //   278: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   279: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   282: invokevirtual   java/lang/Class.isArray:()Z
        //   285: ifeq            306
        //   288: new             Lorg/json/JSONArray;
        //   291: dup            
        //   292: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   293: invokespecial   org/json/JSONArray.<init>:(Ljava/lang/Object;)V
        //   296: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   297: iload_2         /* llllllllllllllIIllllIlllIIIIllll */
        //   298: iload_3         /* llllllllllllllIIllllIlllIIIIlllI */
        //   299: invokevirtual   org/json/JSONArray.write:(Ljava/io/Writer;II)Ljava/io/Writer;
        //   302: pop            
        //   303: goto            315
        //   306: aload_1         /* llllllllllllllIIllllIlllIIIlIIII */
        //   307: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   310: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   311: invokestatic    org/json/JSONObject.quote:(Ljava/lang/String;Ljava/io/Writer;)Ljava/io/Writer;
        //   314: pop            
        //   315: aload_0         /* llllllllllllllIIllllIlllIIIlIlIl */
        //   316: areturn        
        //    Exceptions:
        //  throws org.json.JSONException
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  28     39     42     54     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public BigInteger optBigInteger(final String llllllllllllllIIlllllIIlIIlIllIl, final BigInteger llllllllllllllIIlllllIIlIIlIlIII) {
        final Object llllllllllllllIIlllllIIlIIlIlIll = this.opt(llllllllllllllIIlllllIIlIIlIllIl);
        return objectToBigInteger(llllllllllllllIIlllllIIlIIlIlIll, llllllllllllllIIlllllIIlIIlIlIII);
    }
    
    public static Writer quote(final String llllllllllllllIIllllIllllIIlIIlI, final Writer llllllllllllllIIllllIllllIIlIIIl) throws IOException {
        if (llllllllllllllIIllllIllllIIlIIlI == null || llllllllllllllIIllllIllllIIlIIlI.isEmpty()) {
            llllllllllllllIIllllIllllIIlIIIl.write("\"\"");
            return llllllllllllllIIllllIllllIIlIIIl;
        }
        char llllllllllllllIIllllIllllIIlIlIl = '\0';
        final int llllllllllllllIIllllIllllIIlIIll = llllllllllllllIIllllIllllIIlIIlI.length();
        llllllllllllllIIllllIllllIIlIIIl.write(34);
        for (int llllllllllllllIIllllIllllIIlIlII = 0; llllllllllllllIIllllIllllIIlIlII < llllllllllllllIIllllIllllIIlIIll; ++llllllllllllllIIllllIllllIIlIlII) {
            final char llllllllllllllIIllllIllllIIllIII = llllllllllllllIIllllIllllIIlIlIl;
            llllllllllllllIIllllIllllIIlIlIl = llllllllllllllIIllllIllllIIlIIlI.charAt(llllllllllllllIIllllIllllIIlIlII);
            switch (llllllllllllllIIllllIllllIIlIlIl) {
                case '\"':
                case '\\': {
                    llllllllllllllIIllllIllllIIlIIIl.write(92);
                    llllllllllllllIIllllIllllIIlIIIl.write(llllllllllllllIIllllIllllIIlIlIl);
                    break;
                }
                case '/': {
                    if (llllllllllllllIIllllIllllIIllIII == '<') {
                        llllllllllllllIIllllIllllIIlIIIl.write(92);
                    }
                    llllllllllllllIIllllIllllIIlIIIl.write(llllllllllllllIIllllIllllIIlIlIl);
                    break;
                }
                case '\b': {
                    llllllllllllllIIllllIllllIIlIIIl.write("\\b");
                    break;
                }
                case '\t': {
                    llllllllllllllIIllllIllllIIlIIIl.write("\\t");
                    break;
                }
                case '\n': {
                    llllllllllllllIIllllIllllIIlIIIl.write("\\n");
                    break;
                }
                case '\f': {
                    llllllllllllllIIllllIllllIIlIIIl.write("\\f");
                    break;
                }
                case '\r': {
                    llllllllllllllIIllllIllllIIlIIIl.write("\\r");
                    break;
                }
                default: {
                    if (llllllllllllllIIllllIllllIIlIlIl < ' ' || (llllllllllllllIIllllIllllIIlIlIl >= '\u0080' && llllllllllllllIIllllIllllIIlIlIl < ' ') || (llllllllllllllIIllllIllllIIlIlIl >= '\u2000' && llllllllllllllIIllllIllllIIlIlIl < '\u2100')) {
                        llllllllllllllIIllllIllllIIlIIIl.write("\\u");
                        final String llllllllllllllIIllllIllllIIllIIl = Integer.toHexString(llllllllllllllIIllllIllllIIlIlIl);
                        llllllllllllllIIllllIllllIIlIIIl.write("0000", 0, 4 - llllllllllllllIIllllIllllIIllIIl.length());
                        llllllllllllllIIllllIllllIIlIIIl.write(llllllllllllllIIllllIllllIIllIIl);
                        break;
                    }
                    llllllllllllllIIllllIllllIIlIIIl.write(llllllllllllllIIllllIllllIIlIlIl);
                    break;
                }
            }
        }
        llllllllllllllIIllllIllllIIlIIIl.write(34);
        return llllllllllllllIIllllIllllIIlIIIl;
    }
    
    static BigDecimal objectToBigDecimal(final Object llllllllllllllIIlllllIIlIIllIlll, final BigDecimal llllllllllllllIIlllllIIlIIllIlII) {
        if (JSONObject.NULL.equals(llllllllllllllIIlllllIIlIIllIlll)) {
            return llllllllllllllIIlllllIIlIIllIlII;
        }
        if (llllllllllllllIIlllllIIlIIllIlll instanceof BigDecimal) {
            return (BigDecimal)llllllllllllllIIlllllIIlIIllIlll;
        }
        if (llllllllllllllIIlllllIIlIIllIlll instanceof BigInteger) {
            return new BigDecimal((BigInteger)llllllllllllllIIlllllIIlIIllIlll);
        }
        if (llllllllllllllIIlllllIIlIIllIlll instanceof Double || llllllllllllllIIlllllIIlIIllIlll instanceof Float) {
            final double llllllllllllllIIlllllIIlIIlllIIl = ((Number)llllllllllllllIIlllllIIlIIllIlll).doubleValue();
            if (Double.isNaN(llllllllllllllIIlllllIIlIIlllIIl)) {
                return llllllllllllllIIlllllIIlIIllIlII;
            }
            return new BigDecimal(((Number)llllllllllllllIIlllllIIlIIllIlll).doubleValue());
        }
        else {
            if (llllllllllllllIIlllllIIlIIllIlll instanceof Long || llllllllllllllIIlllllIIlIIllIlll instanceof Integer || llllllllllllllIIlllllIIlIIllIlll instanceof Short || llllllllllllllIIlllllIIlIIllIlll instanceof Byte) {
                return new BigDecimal(((Number)llllllllllllllIIlllllIIlIIllIlll).longValue());
            }
            try {
                return new BigDecimal(llllllllllllllIIlllllIIlIIllIlll.toString());
            }
            catch (Exception llllllllllllllIIlllllIIlIIlllIII) {
                return llllllllllllllIIlllllIIlIIllIlII;
            }
        }
    }
    
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    
    public JSONObject put(final String llllllllllllllIIlllllIIIIIIIIIII, final float llllllllllllllIIlllllIIIIIIIIIlI) throws JSONException {
        return this.put(llllllllllllllIIlllllIIIIIIIIIII, (Object)llllllllllllllIIlllllIIIIIIIIIlI);
    }
    
    public boolean has(final String llllllllllllllIIlllllIIllIlIlIlI) {
        return this.map.containsKey(llllllllllllllIIlllllIIllIlIlIlI);
    }
    
    public static String[] getNames(final JSONObject llllllllllllllIIlllllIIlllIIlIIl) {
        if (llllllllllllllIIlllllIIlllIIlIIl.isEmpty()) {
            return null;
        }
        return llllllllllllllIIlllllIIlllIIlIIl.keySet().toArray(new String[llllllllllllllIIlllllIIlllIIlIIl.length()]);
    }
    
    public Set<String> keySet() {
        return this.map.keySet();
    }
    
    public JSONObject getJSONObject(final String llllllllllllllIIlllllIIlllIlllII) throws JSONException {
        final Object llllllllllllllIIlllllIIlllIllIll = this.get(llllllllllllllIIlllllIIlllIlllII);
        if (llllllllllllllIIlllllIIlllIllIll instanceof JSONObject) {
            return (JSONObject)llllllllllllllIIlllllIIlllIllIll;
        }
        throw wrongValueFormatException(llllllllllllllIIlllllIIlllIlllII, "JSONObject", null);
    }
    
    public int optInt(final String llllllllllllllIIlllllIIIlllIlllI) {
        return this.optInt(llllllllllllllIIlllllIIIlllIlllI, 0);
    }
    
    public Object optQuery(final JSONPointer llllllllllllllIIllllIllllIllIIIl) {
        try {
            return llllllllllllllIIllllIllllIllIIIl.queryFrom(this);
        }
        catch (JSONPointerException llllllllllllllIIllllIllllIllIIll) {
            return null;
        }
    }
    
    public boolean isNull(final String llllllllllllllIIlllllIIllIIllIll) {
        return JSONObject.NULL.equals(this.opt(llllllllllllllIIlllllIIllIIllIll));
    }
    
    public JSONObject put(final String llllllllllllllIIllllIlllllllIlll, final int llllllllllllllIIllllIlllllllIllI) throws JSONException {
        return this.put(llllllllllllllIIllllIlllllllIlll, (Object)llllllllllllllIIllllIlllllllIllI);
    }
    
    public BigDecimal getBigDecimal(final String llllllllllllllIIlllllIlIIIIlllII) throws JSONException {
        final Object llllllllllllllIIlllllIlIIIIlllll = this.get(llllllllllllllIIlllllIlIIIIlllII);
        final BigDecimal llllllllllllllIIlllllIlIIIIllllI = objectToBigDecimal(llllllllllllllIIlllllIlIIIIlllll, null);
        if (llllllllllllllIIlllllIlIIIIllllI != null) {
            return llllllllllllllIIlllllIlIIIIllllI;
        }
        throw wrongValueFormatException(llllllllllllllIIlllllIlIIIIlllII, "BigDecimal", llllllllllllllIIlllllIlIIIIlllll, null);
    }
    
    public Object query(final String llllllllllllllIIllllIlllllIIIlIl) {
        return this.query(new JSONPointer(llllllllllllllIIllllIlllllIIIlIl));
    }
    
    public JSONObject increment(final String llllllllllllllIIlllllIIllIlIIIII) throws JSONException {
        final Object llllllllllllllIIlllllIIllIlIIIlI = this.opt(llllllllllllllIIlllllIIllIlIIIII);
        if (llllllllllllllIIlllllIIllIlIIIlI == null) {
            this.put(llllllllllllllIIlllllIIllIlIIIII, 1);
        }
        else if (llllllllllllllIIlllllIIllIlIIIlI instanceof Integer) {
            this.put(llllllllllllllIIlllllIIllIlIIIII, (int)llllllllllllllIIlllllIIllIlIIIlI + 1);
        }
        else if (llllllllllllllIIlllllIIllIlIIIlI instanceof Long) {
            this.put(llllllllllllllIIlllllIIllIlIIIII, (long)llllllllllllllIIlllllIIllIlIIIlI + 1L);
        }
        else if (llllllllllllllIIlllllIIllIlIIIlI instanceof BigInteger) {
            this.put(llllllllllllllIIlllllIIllIlIIIII, ((BigInteger)llllllllllllllIIlllllIIllIlIIIlI).add(BigInteger.ONE));
        }
        else if (llllllllllllllIIlllllIIllIlIIIlI instanceof Float) {
            this.put(llllllllllllllIIlllllIIllIlIIIII, (float)llllllllllllllIIlllllIIllIlIIIlI + 1.0f);
        }
        else if (llllllllllllllIIlllllIIllIlIIIlI instanceof Double) {
            this.put(llllllllllllllIIlllllIIllIlIIIII, (double)llllllllllllllIIlllllIIllIlIIIlI + 1.0);
        }
        else {
            if (!(llllllllllllllIIlllllIIllIlIIIlI instanceof BigDecimal)) {
                throw new JSONException(String.valueOf(new StringBuilder().append("Unable to increment [").append(quote(llllllllllllllIIlllllIIllIlIIIII)).append("].")));
            }
            this.put(llllllllllllllIIlllllIIllIlIIIII, ((BigDecimal)llllllllllllllIIlllllIIllIlIIIlI).add(BigDecimal.ONE));
        }
        return this;
    }
    
    static BigInteger objectToBigInteger(final Object llllllllllllllIIlllllIIlIIlIIIII, final BigInteger llllllllllllllIIlllllIIlIIIlllIl) {
        if (JSONObject.NULL.equals(llllllllllllllIIlllllIIlIIlIIIII)) {
            return llllllllllllllIIlllllIIlIIIlllIl;
        }
        if (llllllllllllllIIlllllIIlIIlIIIII instanceof BigInteger) {
            return (BigInteger)llllllllllllllIIlllllIIlIIlIIIII;
        }
        if (llllllllllllllIIlllllIIlIIlIIIII instanceof BigDecimal) {
            return ((BigDecimal)llllllllllllllIIlllllIIlIIlIIIII).toBigInteger();
        }
        if (llllllllllllllIIlllllIIlIIlIIIII instanceof Double || llllllllllllllIIlllllIIlIIlIIIII instanceof Float) {
            final double llllllllllllllIIlllllIIlIIlIIIll = ((Number)llllllllllllllIIlllllIIlIIlIIIII).doubleValue();
            if (Double.isNaN(llllllllllllllIIlllllIIlIIlIIIll)) {
                return llllllllllllllIIlllllIIlIIIlllIl;
            }
            return new BigDecimal(llllllllllllllIIlllllIIlIIlIIIll).toBigInteger();
        }
        else {
            if (llllllllllllllIIlllllIIlIIlIIIII instanceof Long || llllllllllllllIIlllllIIlIIlIIIII instanceof Integer || llllllllllllllIIlllllIIlIIlIIIII instanceof Short || llllllllllllllIIlllllIIlIIlIIIII instanceof Byte) {
                return BigInteger.valueOf(((Number)llllllllllllllIIlllllIIlIIlIIIII).longValue());
            }
            try {
                final String llllllllllllllIIlllllIIlIIlIIIlI = llllllllllllllIIlllllIIlIIlIIIII.toString();
                if (isDecimalNotation(llllllllllllllIIlllllIIlIIlIIIlI)) {
                    return new BigDecimal(llllllllllllllIIlllllIIlIIlIIIlI).toBigInteger();
                }
                return new BigInteger(llllllllllllllIIlllllIIlIIlIIIlI);
            }
            catch (Exception llllllllllllllIIlllllIIlIIlIIIIl) {
                return llllllllllllllIIlllllIIlIIIlllIl;
            }
        }
    }
    
    public Writer write(final Writer llllllllllllllIIllllIllIlllIllII, final int llllllllllllllIIllllIllIlllIIlll, final int llllllllllllllIIllllIllIlllIlIlI) throws JSONException {
        try {
            boolean llllllllllllllIIllllIllIllllIIII = false;
            final int llllllllllllllIIllllIllIlllIllll = this.length();
            llllllllllllllIIllllIllIlllIllII.write(123);
            if (llllllllllllllIIllllIllIlllIllll == 1) {
                final Map.Entry<String, ?> llllllllllllllIIllllIllIllllIllI = this.entrySet().iterator().next();
                final String llllllllllllllIIllllIllIllllIlIl = llllllllllllllIIllllIllIllllIllI.getKey();
                llllllllllllllIIllllIllIlllIllII.write(quote(llllllllllllllIIllllIllIllllIlIl));
                llllllllllllllIIllllIllIlllIllII.write(58);
                if (llllllllllllllIIllllIllIlllIIlll > 0) {
                    llllllllllllllIIllllIllIlllIllII.write(32);
                }
                try {
                    writeValue(llllllllllllllIIllllIllIlllIllII, llllllllllllllIIllllIllIllllIllI.getValue(), llllllllllllllIIllllIllIlllIIlll, llllllllllllllIIllllIllIlllIlIlI);
                }
                catch (Exception llllllllllllllIIllllIllIllllIlll) {
                    throw new JSONException(String.valueOf(new StringBuilder().append("Unable to write JSONObject value for key: ").append(llllllllllllllIIllllIllIllllIlIl)), llllllllllllllIIllllIllIllllIlll);
                }
            }
            else if (llllllllllllllIIllllIllIlllIllll != 0) {
                final int llllllllllllllIIllllIllIllllIIIl = llllllllllllllIIllllIllIlllIlIlI + llllllllllllllIIllllIllIlllIIlll;
                for (final Map.Entry<String, ?> llllllllllllllIIllllIllIllllIIlI : this.entrySet()) {
                    if (llllllllllllllIIllllIllIllllIIII) {
                        llllllllllllllIIllllIllIlllIllII.write(44);
                    }
                    if (llllllllllllllIIllllIllIlllIIlll > 0) {
                        llllllllllllllIIllllIllIlllIllII.write(10);
                    }
                    indent(llllllllllllllIIllllIllIlllIllII, llllllllllllllIIllllIllIllllIIIl);
                    final String llllllllllllllIIllllIllIllllIIll = llllllllllllllIIllllIllIllllIIlI.getKey();
                    llllllllllllllIIllllIllIlllIllII.write(quote(llllllllllllllIIllllIllIllllIIll));
                    llllllllllllllIIllllIllIlllIllII.write(58);
                    if (llllllllllllllIIllllIllIlllIIlll > 0) {
                        llllllllllllllIIllllIllIlllIllII.write(32);
                    }
                    try {
                        writeValue(llllllllllllllIIllllIllIlllIllII, llllllllllllllIIllllIllIllllIIlI.getValue(), llllllllllllllIIllllIllIlllIIlll, llllllllllllllIIllllIllIllllIIIl);
                    }
                    catch (Exception llllllllllllllIIllllIllIllllIlII) {
                        throw new JSONException(String.valueOf(new StringBuilder().append("Unable to write JSONObject value for key: ").append(llllllllllllllIIllllIllIllllIIll)), llllllllllllllIIllllIllIllllIlII);
                    }
                    llllllllllllllIIllllIllIllllIIII = true;
                }
                if (llllllllllllllIIllllIllIlllIIlll > 0) {
                    llllllllllllllIIllllIllIlllIllII.write(10);
                }
                indent(llllllllllllllIIllllIllIlllIllII, llllllllllllllIIllllIllIlllIlIlI);
            }
            llllllllllllllIIllllIllIlllIllII.write(125);
            return llllllllllllllIIllllIllIlllIllII;
        }
        catch (IOException llllllllllllllIIllllIllIlllIlllI) {
            throw new JSONException(llllllllllllllIIllllIllIlllIlllI);
        }
    }
    
    public static String[] getNames(final Object llllllllllllllIIlllllIIllIllllII) {
        if (llllllllllllllIIlllllIIllIllllII == null) {
            return null;
        }
        final Class<?> llllllllllllllIIlllllIIlllIIIIII = llllllllllllllIIlllllIIllIllllII.getClass();
        final Field[] llllllllllllllIIlllllIIllIllllll = llllllllllllllIIlllllIIlllIIIIII.getFields();
        final int llllllllllllllIIlllllIIllIlllllI = llllllllllllllIIlllllIIllIllllll.length;
        if (llllllllllllllIIlllllIIllIlllllI == 0) {
            return null;
        }
        final String[] llllllllllllllIIlllllIIllIllllIl = new String[llllllllllllllIIlllllIIllIlllllI];
        for (int llllllllllllllIIlllllIIlllIIIIlI = 0; llllllllllllllIIlllllIIlllIIIIlI < llllllllllllllIIlllllIIllIlllllI; ++llllllllllllllIIlllllIIlllIIIIlI) {
            llllllllllllllIIlllllIIllIllllIl[llllllllllllllIIlllllIIlllIIIIlI] = llllllllllllllIIlllllIIllIllllll[llllllllllllllIIlllllIIlllIIIIlI].getName();
        }
        return llllllllllllllIIlllllIIllIllllIl;
    }
    
    public long optLong(final String llllllllllllllIIlllllIIIllIIIIlI, final long llllllllllllllIIlllllIIIllIIIIIl) {
        final Number llllllllllllllIIlllllIIIllIIIIII = this.optNumber(llllllllllllllIIlllllIIIllIIIIlI, null);
        if (llllllllllllllIIlllllIIIllIIIIII == null) {
            return llllllllllllllIIlllllIIIllIIIIIl;
        }
        return llllllllllllllIIlllllIIIllIIIIII.longValue();
    }
    
    public JSONObject(final JSONObject llllllllllllllIIlllllIlIllIllIIl, final String... llllllllllllllIIlllllIlIllIllIll) {
        this(llllllllllllllIIlllllIlIllIllIll.length);
        for (int llllllllllllllIIlllllIlIllIllllI = 0; llllllllllllllIIlllllIlIllIllllI < llllllllllllllIIlllllIlIllIllIll.length; ++llllllllllllllIIlllllIlIllIllllI) {
            try {
                this.putOnce(llllllllllllllIIlllllIlIllIllIll[llllllllllllllIIlllllIlIllIllllI], llllllllllllllIIlllllIlIllIllIIl.opt(llllllllllllllIIlllllIlIllIllIll[llllllllllllllIIlllllIlIllIllllI]));
            }
            catch (Exception ex) {}
        }
    }
    
    public Object query(final JSONPointer llllllllllllllIIllllIllllIllllll) {
        return llllllllllllllIIllllIllllIllllll.queryFrom(this);
    }
    
    private static boolean isValidMethodName(final String llllllllllllllIIlllllIIIIllIlIll) {
        return !"getClass".equals(llllllllllllllIIlllllIIIIllIlIll) && !"getDeclaringClass".equals(llllllllllllllIIlllllIIIIllIlIll);
    }
    
    public Number optNumber(final String llllllllllllllIIlllllIIIlIlllIII) {
        return this.optNumber(llllllllllllllIIlllllIIIlIlllIII, null);
    }
    
    public long optLong(final String llllllllllllllIIlllllIIIllIIlIlI) {
        return this.optLong(llllllllllllllIIlllllIIIllIIlIlI, 0L);
    }
    
    protected JSONObject(final int llllllllllllllIIlllllIlIIlllIIII) {
        this.map = new HashMap<String, Object>(llllllllllllllIIlllllIlIIlllIIII);
    }
    
    public JSONObject put(final String llllllllllllllIIllllIlllllllIIIl, final long llllllllllllllIIllllIllllllIllIl) throws JSONException {
        return this.put(llllllllllllllIIllllIlllllllIIIl, (Object)llllllllllllllIIllllIllllllIllIl);
    }
    
    public Object optQuery(final String llllllllllllllIIllllIllllIlllIIl) {
        return this.optQuery(new JSONPointer(llllllllllllllIIllllIllllIlllIIl));
    }
    
    public JSONObject put(final String llllllllllllllIIlllllIIIIIIllllI, final boolean llllllllllllllIIlllllIIIIIIllIlI) throws JSONException {
        return this.put(llllllllllllllIIlllllIIIIIIllllI, llllllllllllllIIlllllIIIIIIllIlI ? Boolean.TRUE : Boolean.FALSE);
    }
    
    public JSONObject putOpt(final String llllllllllllllIIllllIlllllIIllIl, final Object llllllllllllllIIllllIlllllIIlIIl) throws JSONException {
        if (llllllllllllllIIllllIlllllIIllIl != null && llllllllllllllIIllllIlllllIIlIIl != null) {
            return this.put(llllllllllllllIIllllIlllllIIllIl, llllllllllllllIIllllIlllllIIlIIl);
        }
        return this;
    }
    
    static {
        NUMBER_PATTERN = Pattern.compile("-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?");
        NULL = new Null();
    }
    
    private static JSONException wrongValueFormatException(final String llllllllllllllIIllllIllIllIIIIII, final String llllllllllllllIIllllIllIlIlllIll, final Object llllllllllllllIIllllIllIlIlllIlI, final Throwable llllllllllllllIIllllIllIlIllllIl) {
        return new JSONException(String.valueOf(new StringBuilder().append("JSONObject[").append(quote(llllllllllllllIIllllIllIllIIIIII)).append("] is not a ").append(llllllllllllllIIllllIllIlIlllIll).append(" (").append(llllllllllllllIIllllIllIlIlllIlI).append(").")), llllllllllllllIIllllIllIlIllllIl);
    }
    
    public Iterator<String> keys() {
        return this.keySet().iterator();
    }
    
    public float getFloat(final String llllllllllllllIIlllllIlIIIIIIlII) throws JSONException {
        final Object llllllllllllllIIlllllIlIIIIIIllI = this.get(llllllllllllllIIlllllIlIIIIIIlII);
        if (llllllllllllllIIlllllIlIIIIIIllI instanceof Number) {
            return ((Number)llllllllllllllIIlllllIlIIIIIIllI).floatValue();
        }
        try {
            return Float.parseFloat(llllllllllllllIIlllllIlIIIIIIllI.toString());
        }
        catch (Exception llllllllllllllIIlllllIlIIIIIlIIl) {
            throw wrongValueFormatException(llllllllllllllIIlllllIlIIIIIIlII, "float", llllllllllllllIIlllllIlIIIIIlIIl);
        }
    }
    
    public JSONArray names() {
        if (this.map.isEmpty()) {
            return null;
        }
        return new JSONArray(this.map.keySet());
    }
    
    public BigInteger getBigInteger(final String llllllllllllllIIlllllIlIIIlIlIII) throws JSONException {
        final Object llllllllllllllIIlllllIlIIIlIlIll = this.get(llllllllllllllIIlllllIlIIIlIlIII);
        final BigInteger llllllllllllllIIlllllIlIIIlIlIlI = objectToBigInteger(llllllllllllllIIlllllIlIIIlIlIll, null);
        if (llllllllllllllIIlllllIlIIIlIlIlI != null) {
            return llllllllllllllIIlllllIlIIIlIlIlI;
        }
        throw wrongValueFormatException(llllllllllllllIIlllllIlIIIlIlIII, "BigInteger", llllllllllllllIIlllllIlIIIlIlIll, null);
    }
    
    public JSONObject put(final String llllllllllllllIIllllIllllllIlIII, final Map<?, ?> llllllllllllllIIllllIllllllIIlll) throws JSONException {
        return this.put(llllllllllllllIIllllIllllllIlIII, new JSONObject(llllllllllllllIIllllIllllllIIlll));
    }
    
    public double optDouble(final String llllllllllllllIIlllllIIlIIIIllll, final double llllllllllllllIIlllllIIlIIIIlllI) {
        final Number llllllllllllllIIlllllIIlIIIIllIl = this.optNumber(llllllllllllllIIlllllIIlIIIIllll);
        if (llllllllllllllIIlllllIIlIIIIllIl == null) {
            return llllllllllllllIIlllllIIlIIIIlllI;
        }
        final double llllllllllllllIIlllllIIlIIIIllII = llllllllllllllIIlllllIIlIIIIllIl.doubleValue();
        return llllllllllllllIIlllllIIlIIIIllII;
    }
    
    public JSONArray getJSONArray(final String llllllllllllllIIlllllIIllllIIlIl) throws JSONException {
        final Object llllllllllllllIIlllllIIllllIIlII = this.get(llllllllllllllIIlllllIIllllIIlIl);
        if (llllllllllllllIIlllllIIllllIIlII instanceof JSONArray) {
            return (JSONArray)llllllllllllllIIlllllIIllllIIlII;
        }
        throw wrongValueFormatException(llllllllllllllIIlllllIIllllIIlIl, "JSONArray", null);
    }
    
    public static String numberToString(final Number llllllllllllllIIlllllIIllIIIIlII) throws JSONException {
        if (llllllllllllllIIlllllIIllIIIIlII == null) {
            throw new JSONException("Null pointer");
        }
        testValidity(llllllllllllllIIlllllIIllIIIIlII);
        String llllllllllllllIIlllllIIllIIIIIll = llllllllllllllIIlllllIIllIIIIlII.toString();
        if (llllllllllllllIIlllllIIllIIIIIll.indexOf(46) > 0 && llllllllllllllIIlllllIIllIIIIIll.indexOf(101) < 0 && llllllllllllllIIlllllIIllIIIIIll.indexOf(69) < 0) {
            while (llllllllllllllIIlllllIIllIIIIIll.endsWith("0")) {
                llllllllllllllIIlllllIIllIIIIIll = llllllllllllllIIlllllIIllIIIIIll.substring(0, llllllllllllllIIlllllIIllIIIIIll.length() - 1);
            }
            if (llllllllllllllIIlllllIIllIIIIIll.endsWith(".")) {
                llllllllllllllIIlllllIIllIIIIIll = llllllllllllllIIlllllIIllIIIIIll.substring(0, llllllllllllllIIlllllIIllIIIIIll.length() - 1);
            }
        }
        return llllllllllllllIIlllllIIllIIIIIll;
    }
    
    protected Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }
    
    public JSONObject(final Map<?, ?> llllllllllllllIIlllllIlIlIllllII) {
        if (llllllllllllllIIlllllIlIlIllllII == null) {
            this.map = new HashMap<String, Object>();
        }
        else {
            this.map = new HashMap<String, Object>(llllllllllllllIIlllllIlIlIllllII.size());
            for (final Map.Entry<?, ?> llllllllllllllIIlllllIlIllIIIIII : llllllllllllllIIlllllIlIlIllllII.entrySet()) {
                if (llllllllllllllIIlllllIlIllIIIIII.getKey() == null) {
                    throw new NullPointerException("Null key.");
                }
                final Object llllllllllllllIIlllllIlIllIIIIIl = llllllllllllllIIlllllIlIllIIIIII.getValue();
                if (llllllllllllllIIlllllIlIllIIIIIl == null) {
                    continue;
                }
                this.map.put(String.valueOf(llllllllllllllIIlllllIlIllIIIIII.getKey()), wrap(llllllllllllllIIlllllIlIllIIIIIl));
            }
        }
    }
    
    public JSONObject() {
        this.map = new HashMap<String, Object>();
    }
    
    static final void indent(final Writer llllllllllllllIIllllIlllIIIIIlIl, final int llllllllllllllIIllllIlllIIIIIllI) throws IOException {
        for (int llllllllllllllIIllllIlllIIIIlIII = 0; llllllllllllllIIllllIlllIIIIlIII < llllllllllllllIIllllIlllIIIIIllI; ++llllllllllllllIIllllIlllIIIIlIII) {
            llllllllllllllIIllllIlllIIIIIlIl.write(32);
        }
    }
    
    public JSONObject(final Object llllllllllllllIIlllllIlIlIlIIIll, final String... llllllllllllllIIlllllIlIlIlIIIlI) {
        this(llllllllllllllIIlllllIlIlIlIIIlI.length);
        final Class<?> llllllllllllllIIlllllIlIlIlIIlIl = llllllllllllllIIlllllIlIlIlIIIll.getClass();
        for (int llllllllllllllIIlllllIlIlIlIlIIl = 0; llllllllllllllIIlllllIlIlIlIlIIl < llllllllllllllIIlllllIlIlIlIIIlI.length; ++llllllllllllllIIlllllIlIlIlIlIIl) {
            final String llllllllllllllIIlllllIlIlIlIlIlI = llllllllllllllIIlllllIlIlIlIIIlI[llllllllllllllIIlllllIlIlIlIlIIl];
            try {
                this.putOpt(llllllllllllllIIlllllIlIlIlIlIlI, llllllllllllllIIlllllIlIlIlIIlIl.getField(llllllllllllllIIlllllIlIlIlIlIlI).get(llllllllllllllIIlllllIlIlIlIIIll));
            }
            catch (Exception ex) {}
        }
    }
    
    public boolean similar(final Object llllllllllllllIIllllIlllIlllIllI) {
        try {
            if (!(llllllllllllllIIllllIlllIlllIllI instanceof JSONObject)) {
                return false;
            }
            if (!this.keySet().equals(((JSONObject)llllllllllllllIIllllIlllIlllIllI).keySet())) {
                return false;
            }
            for (final Map.Entry<String, ?> llllllllllllllIIllllIlllIllllIll : this.entrySet()) {
                final String llllllllllllllIIllllIlllIllllllI = llllllllllllllIIllllIlllIllllIll.getKey();
                final Object llllllllllllllIIllllIlllIlllllIl = llllllllllllllIIllllIlllIllllIll.getValue();
                final Object llllllllllllllIIllllIlllIlllllII = ((JSONObject)llllllllllllllIIllllIlllIlllIllI).get(llllllllllllllIIllllIlllIllllllI);
                if (llllllllllllllIIllllIlllIlllllIl == llllllllllllllIIllllIlllIlllllII) {
                    continue;
                }
                if (llllllllllllllIIllllIlllIlllllIl == null) {
                    return false;
                }
                if (llllllllllllllIIllllIlllIlllllIl instanceof JSONObject) {
                    if (!((JSONObject)llllllllllllllIIllllIlllIlllllIl).similar(llllllllllllllIIllllIlllIlllllII)) {
                        return false;
                    }
                    continue;
                }
                else if (llllllllllllllIIllllIlllIlllllIl instanceof JSONArray) {
                    if (!((JSONArray)llllllllllllllIIllllIlllIlllllIl).similar(llllllllllllllIIllllIlllIlllllII)) {
                        return false;
                    }
                    continue;
                }
                else {
                    if (!llllllllllllllIIllllIlllIlllllIl.equals(llllllllllllllIIllllIlllIlllllII)) {
                        return false;
                    }
                    continue;
                }
            }
            return true;
        }
        catch (Throwable llllllllllllllIIllllIlllIllllIlI) {
            return false;
        }
    }
    
    public JSONArray toJSONArray(final JSONArray llllllllllllllIIllllIlllIlIIllll) throws JSONException {
        if (llllllllllllllIIllllIlllIlIIllll == null || llllllllllllllIIllllIlllIlIIllll.isEmpty()) {
            return null;
        }
        final JSONArray llllllllllllllIIllllIlllIlIIlllI = new JSONArray();
        for (int llllllllllllllIIllllIlllIlIlIIIl = 0; llllllllllllllIIllllIlllIlIlIIIl < llllllllllllllIIllllIlllIlIIllll.length(); ++llllllllllllllIIllllIlllIlIlIIIl) {
            llllllllllllllIIllllIlllIlIIlllI.put(this.opt(llllllllllllllIIllllIlllIlIIllll.getString(llllllllllllllIIllllIlllIlIlIIIl)));
        }
        return llllllllllllllIIllllIlllIlIIlllI;
    }
    
    public JSONObject put(final String llllllllllllllIIlllllIIIIIIIllII, final double llllllllllllllIIlllllIIIIIIIlIll) throws JSONException {
        return this.put(llllllllllllllIIlllllIIIIIIIllII, (Object)llllllllllllllIIlllllIIIIIIIlIll);
    }
    
    public static String doubleToString(final double llllllllllllllIIlllllIlIIlIlIIll) {
        if (Double.isInfinite(llllllllllllllIIlllllIlIIlIlIIll) || Double.isNaN(llllllllllllllIIlllllIlIIlIlIIll)) {
            return "null";
        }
        String llllllllllllllIIlllllIlIIlIlIIlI = Double.toString(llllllllllllllIIlllllIlIIlIlIIll);
        if (llllllllllllllIIlllllIlIIlIlIIlI.indexOf(46) > 0 && llllllllllllllIIlllllIlIIlIlIIlI.indexOf(101) < 0 && llllllllllllllIIlllllIlIIlIlIIlI.indexOf(69) < 0) {
            while (llllllllllllllIIlllllIlIIlIlIIlI.endsWith("0")) {
                llllllllllllllIIlllllIlIIlIlIIlI = llllllllllllllIIlllllIlIIlIlIIlI.substring(0, llllllllllllllIIlllllIlIIlIlIIlI.length() - 1);
            }
            if (llllllllllllllIIlllllIlIIlIlIIlI.endsWith(".")) {
                llllllllllllllIIlllllIlIIlIlIIlI = llllllllllllllIIlllllIlIIlIlIIlI.substring(0, llllllllllllllIIlllllIlIIlIlIIlI.length() - 1);
            }
        }
        return llllllllllllllIIlllllIlIIlIlIIlI;
    }
    
    private void populateMap(final Object llllllllllllllIIlllllIIIIllllllI) {
        final Class<?> llllllllllllllIIlllllIIIIlllllIl = llllllllllllllIIlllllIIIIllllllI.getClass();
        final boolean llllllllllllllIIlllllIIIIlllllII = llllllllllllllIIlllllIIIIlllllIl.getClassLoader() != null;
        final String llllllllllllllIIlllllIIIIlllIlIl;
        final Method[] llllllllllllllIIlllllIIIIllllIll = (Object)(llllllllllllllIIlllllIIIIlllIlIl = (String)(Object)(llllllllllllllIIlllllIIIIlllllII ? llllllllllllllIIlllllIIIIlllllIl.getMethods() : llllllllllllllIIlllllIIIIlllllIl.getDeclaredMethods()));
        final short llllllllllllllIIlllllIIIIlllIlII = (short)llllllllllllllIIlllllIIIIlllIlIl.length;
        for (double llllllllllllllIIlllllIIIIlllIIll = 0; llllllllllllllIIlllllIIIIlllIIll < llllllllllllllIIlllllIIIIlllIlII; ++llllllllllllllIIlllllIIIIlllIIll) {
            final Method llllllllllllllIIlllllIIIlIIIIIII = llllllllllllllIIlllllIIIIlllIlIl[llllllllllllllIIlllllIIIIlllIIll];
            final int llllllllllllllIIlllllIIIlIIIIIIl = llllllllllllllIIlllllIIIlIIIIIII.getModifiers();
            if (Modifier.isPublic(llllllllllllllIIlllllIIIlIIIIIIl) && !Modifier.isStatic(llllllllllllllIIlllllIIIlIIIIIIl) && llllllllllllllIIlllllIIIlIIIIIII.getParameterTypes().length == 0 && !llllllllllllllIIlllllIIIlIIIIIII.isBridge() && llllllllllllllIIlllllIIIlIIIIIII.getReturnType() != Void.TYPE && isValidMethodName(llllllllllllllIIlllllIIIlIIIIIII.getName())) {
                final String llllllllllllllIIlllllIIIlIIIIIlI = getKeyNameFromMethod(llllllllllllllIIlllllIIIlIIIIIII);
                if (llllllllllllllIIlllllIIIlIIIIIlI != null && !llllllllllllllIIlllllIIIlIIIIIlI.isEmpty()) {
                    try {
                        final Object llllllllllllllIIlllllIIIlIIIIllI = llllllllllllllIIlllllIIIlIIIIIII.invoke(llllllllllllllIIlllllIIIIllllllI, new Object[0]);
                        if (llllllllllllllIIlllllIIIlIIIIllI != null) {
                            this.map.put(llllllllllllllIIlllllIIIlIIIIIlI, wrap(llllllllllllllIIlllllIIIlIIIIllI));
                            if (llllllllllllllIIlllllIIIlIIIIllI instanceof Closeable) {
                                try {
                                    ((Closeable)llllllllllllllIIlllllIIIlIIIIllI).close();
                                }
                                catch (IOException ex) {}
                            }
                        }
                    }
                    catch (IllegalAccessException llllllllllllllIIlllllIIIlIIIIlIl) {}
                    catch (IllegalArgumentException llllllllllllllIIlllllIIIlIIIIlII) {}
                    catch (InvocationTargetException ex2) {}
                }
            }
        }
    }
    
    public JSONObject append(final String llllllllllllllIIlllllIlIIlIlllII, final Object llllllllllllllIIlllllIlIIlIllIll) throws JSONException {
        testValidity(llllllllllllllIIlllllIlIIlIllIll);
        final Object llllllllllllllIIlllllIlIIlIllIlI = this.opt(llllllllllllllIIlllllIlIIlIlllII);
        if (llllllllllllllIIlllllIlIIlIllIlI == null) {
            this.put(llllllllllllllIIlllllIlIIlIlllII, new JSONArray().put(llllllllllllllIIlllllIlIIlIllIll));
        }
        else {
            if (!(llllllllllllllIIlllllIlIIlIllIlI instanceof JSONArray)) {
                throw wrongValueFormatException(llllllllllllllIIlllllIlIIlIlllII, "JSONArray", null, null);
            }
            this.put(llllllllllllllIIlllllIlIIlIlllII, ((JSONArray)llllllllllllllIIlllllIlIIlIllIlI).put(llllllllllllllIIlllllIlIIlIllIll));
        }
        return this;
    }
    
    public JSONObject put(final String llllllllllllllIIllllIlllllIlllII, final Object llllllllllllllIIllllIlllllIllIll) throws JSONException {
        if (llllllllllllllIIllllIlllllIlllII == null) {
            throw new NullPointerException("Null key.");
        }
        if (llllllllllllllIIllllIlllllIllIll != null) {
            testValidity(llllllllllllllIIllllIlllllIllIll);
            this.map.put(llllllllllllllIIllllIlllllIlllII, llllllllllllllIIllllIlllllIllIll);
        }
        else {
            this.remove(llllllllllllllIIllllIlllllIlllII);
        }
        return this;
    }
    
    public JSONObject putOnce(final String llllllllllllllIIllllIlllllIlIllI, final Object llllllllllllllIIllllIlllllIlIlIl) throws JSONException {
        if (llllllllllllllIIllllIlllllIlIllI == null || llllllllllllllIIllllIlllllIlIlIl == null) {
            return this;
        }
        if (this.opt(llllllllllllllIIllllIlllllIlIllI) != null) {
            throw new JSONException(String.valueOf(new StringBuilder().append("Duplicate key \"").append(llllllllllllllIIllllIlllllIlIllI).append("\"")));
        }
        return this.put(llllllllllllllIIllllIlllllIlIllI, llllllllllllllIIllllIlllllIlIlIl);
    }
    
    public double getDouble(final String llllllllllllllIIlllllIlIIIIlIIll) throws JSONException {
        final Object llllllllllllllIIlllllIlIIIIlIIlI = this.get(llllllllllllllIIlllllIlIIIIlIIll);
        if (llllllllllllllIIlllllIlIIIIlIIlI instanceof Number) {
            return ((Number)llllllllllllllIIlllllIlIIIIlIIlI).doubleValue();
        }
        try {
            return Double.parseDouble(llllllllllllllIIlllllIlIIIIlIIlI.toString());
        }
        catch (Exception llllllllllllllIIlllllIlIIIIlIlIl) {
            throw wrongValueFormatException(llllllllllllllIIlllllIlIIIIlIIll, "double", llllllllllllllIIlllllIlIIIIlIlIl);
        }
    }
    
    public int getInt(final String llllllllllllllIIlllllIIllllIllll) throws JSONException {
        final Object llllllllllllllIIlllllIIllllIlllI = this.get(llllllllllllllIIlllllIIllllIllll);
        if (llllllllllllllIIlllllIIllllIlllI instanceof Number) {
            return ((Number)llllllllllllllIIlllllIIllllIlllI).intValue();
        }
        try {
            return Integer.parseInt(llllllllllllllIIlllllIIllllIlllI.toString());
        }
        catch (Exception llllllllllllllIIlllllIIlllllIIIl) {
            throw wrongValueFormatException(llllllllllllllIIlllllIIllllIllll, "int", llllllllllllllIIlllllIIlllllIIIl);
        }
    }
    
    public <E extends Enum<E>> E getEnum(final Class<E> llllllllllllllIIlllllIlIIIllllIl, final String llllllllllllllIIlllllIlIIlIIIIII) throws JSONException {
        final E llllllllllllllIIlllllIlIIIllllll = (E)this.optEnum((Class<Enum>)llllllllllllllIIlllllIlIIIllllIl, llllllllllllllIIlllllIlIIlIIIIII);
        if (llllllllllllllIIlllllIlIIIllllll == null) {
            throw wrongValueFormatException(llllllllllllllIIlllllIlIIlIIIIII, String.valueOf(new StringBuilder().append("enum of type ").append(quote(llllllllllllllIIlllllIlIIIllllIl.getSimpleName()))), null);
        }
        return llllllllllllllIIlllllIlIIIllllll;
    }
    
    public JSONObject put(final String llllllllllllllIIlllllIIIIIIlIIlI, final Collection<?> llllllllllllllIIlllllIIIIIIlIlII) throws JSONException {
        return this.put(llllllllllllllIIlllllIIIIIIlIIlI, new JSONArray(llllllllllllllIIlllllIIIIIIlIlII));
    }
    
    private static String getKeyNameFromMethod(final Method llllllllllllllIIlllllIIIIlIlllIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           Lorg/json/JSONPropertyIgnore;.class
        //     4: invokestatic    org/json/JSONObject.getAnnotationDepth:(Ljava/lang/reflect/Method;Ljava/lang/Class;)I
        //     7: istore_1        /* llllllllllllllIIlllllIIIIllIIIIl */
        //     8: iload_1         /* llllllllllllllIIlllllIIIIllIIIIl */
        //     9: ifle            31
        //    12: aload_0         /* llllllllllllllIIlllllIIIIllIIIlI */
        //    13: ldc_w           Lorg/json/JSONPropertyName;.class
        //    16: invokestatic    org/json/JSONObject.getAnnotationDepth:(Ljava/lang/reflect/Method;Ljava/lang/Class;)I
        //    19: istore_2        /* llllllllllllllIIlllllIIIIllIIlIl */
        //    20: iload_2         /* llllllllllllllIIlllllIIIIllIIlIl */
        //    21: iflt            29
        //    24: iload_1         /* llllllllllllllIIlllllIIIIllIIIIl */
        //    25: iload_2         /* llllllllllllllIIlllllIIIIllIIlIl */
        //    26: if_icmpgt       31
        //    29: aconst_null    
        //    30: areturn        
        //    31: aload_0         /* llllllllllllllIIlllllIIIIllIIIlI */
        //    32: ldc_w           Lorg/json/JSONPropertyName;.class
        //    35: invokestatic    org/json/JSONObject.getAnnotation:(Ljava/lang/reflect/Method;Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
        //    38: checkcast       Lorg/json/JSONPropertyName;
        //    41: astore_2        /* llllllllllllllIIlllllIIIIllIIIII */
        //    42: aload_2         /* llllllllllllllIIlllllIIIIllIIIII */
        //    43: ifnull          74
        //    46: aload_2         /* llllllllllllllIIlllllIIIIllIIIII */
        //    47: invokeinterface org/json/JSONPropertyName.value:()Ljava/lang/String;
        //    52: ifnull          74
        //    55: aload_2         /* llllllllllllllIIlllllIIIIllIIIII */
        //    56: invokeinterface org/json/JSONPropertyName.value:()Ljava/lang/String;
        //    61: invokevirtual   java/lang/String.isEmpty:()Z
        //    64: ifne            74
        //    67: aload_2         /* llllllllllllllIIlllllIIIIllIIIII */
        //    68: invokeinterface org/json/JSONPropertyName.value:()Ljava/lang/String;
        //    73: areturn        
        //    74: aload_0         /* llllllllllllllIIlllllIIIIllIIIlI */
        //    75: invokevirtual   java/lang/reflect/Method.getName:()Ljava/lang/String;
        //    78: astore          llllllllllllllIIlllllIIIIlIllllI
        //    80: aload           llllllllllllllIIlllllIIIIlIllllI
        //    82: ldc_w           "get"
        //    85: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    88: ifeq            110
        //    91: aload           llllllllllllllIIlllllIIIIlIllllI
        //    93: invokevirtual   java/lang/String.length:()I
        //    96: iconst_3       
        //    97: if_icmple       110
        //   100: aload           llllllllllllllIIlllllIIIIlIllllI
        //   102: iconst_3       
        //   103: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   106: astore_3        /* llllllllllllllIIlllllIIIIllIIlII */
        //   107: goto            142
        //   110: aload           llllllllllllllIIlllllIIIIlIllllI
        //   112: ldc_w           "is"
        //   115: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   118: ifeq            140
        //   121: aload           llllllllllllllIIlllllIIIIlIllllI
        //   123: invokevirtual   java/lang/String.length:()I
        //   126: iconst_2       
        //   127: if_icmple       140
        //   130: aload           llllllllllllllIIlllllIIIIlIllllI
        //   132: iconst_2       
        //   133: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   136: astore_3        /* llllllllllllllIIlllllIIIIllIIIll */
        //   137: goto            142
        //   140: aconst_null    
        //   141: areturn        
        //   142: aload_3         /* llllllllllllllIIlllllIIIIlIlllll */
        //   143: iconst_0       
        //   144: invokevirtual   java/lang/String.charAt:(I)C
        //   147: invokestatic    java/lang/Character.isLowerCase:(C)Z
        //   150: ifeq            155
        //   153: aconst_null    
        //   154: areturn        
        //   155: aload_3         /* llllllllllllllIIlllllIIIIlIlllll */
        //   156: invokevirtual   java/lang/String.length:()I
        //   159: iconst_1       
        //   160: if_icmpne       174
        //   163: aload_3         /* llllllllllllllIIlllllIIIIlIlllll */
        //   164: getstatic       java/util/Locale.ROOT:Ljava/util/Locale;
        //   167: invokevirtual   java/lang/String.toLowerCase:(Ljava/util/Locale;)Ljava/lang/String;
        //   170: astore_3        /* llllllllllllllIIlllllIIIIlIlllll */
        //   171: goto            219
        //   174: aload_3         /* llllllllllllllIIlllllIIIIlIlllll */
        //   175: iconst_1       
        //   176: invokevirtual   java/lang/String.charAt:(I)C
        //   179: invokestatic    java/lang/Character.isUpperCase:(C)Z
        //   182: ifne            219
        //   185: new             Ljava/lang/StringBuilder;
        //   188: dup            
        //   189: invokespecial   java/lang/StringBuilder.<init>:()V
        //   192: aload_3         /* llllllllllllllIIlllllIIIIlIlllll */
        //   193: iconst_0       
        //   194: iconst_1       
        //   195: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   198: getstatic       java/util/Locale.ROOT:Ljava/util/Locale;
        //   201: invokevirtual   java/lang/String.toLowerCase:(Ljava/util/Locale;)Ljava/lang/String;
        //   204: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   207: aload_3         /* llllllllllllllIIlllllIIIIlIlllll */
        //   208: iconst_1       
        //   209: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   212: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   215: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   218: astore_3        /* llllllllllllllIIlllllIIIIlIlllll */
        //   219: aload_3         /* llllllllllllllIIlllllIIIIlIlllll */
        //   220: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException
        //     at java.util.Collections$1.remove(Unknown Source)
        //     at java.util.AbstractCollection.removeAll(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2968)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    protected static boolean isDecimalNotation(final String llllllllllllllIIllllIlllIllIlllI) {
        return llllllllllllllIIllllIlllIllIlllI.indexOf(46) > -1 || llllllllllllllIIllllIlllIllIlllI.indexOf(101) > -1 || llllllllllllllIIllllIlllIllIlllI.indexOf(69) > -1 || "-0".equals(llllllllllllllIIllllIlllIllIlllI);
    }
    
    public static void testValidity(final Object llllllllllllllIIllllIlllIlIlIlll) throws JSONException {
        if (llllllllllllllIIllllIlllIlIlIlll != null) {
            if (llllllllllllllIIllllIlllIlIlIlll instanceof Double) {
                if (((Double)llllllllllllllIIllllIlllIlIlIlll).isInfinite() || ((Double)llllllllllllllIIllllIlllIlIlIlll).isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            }
            else if (llllllllllllllIIllllIlllIlIlIlll instanceof Float && (((Float)llllllllllllllIIllllIlllIlIlIlll).isInfinite() || ((Float)llllllllllllllIIllllIlllIlIlIlll).isNaN())) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }
    
    public JSONObject(final Object llllllllllllllIIlllllIlIlIllIlIl) {
        this();
        this.populateMap(llllllllllllllIIlllllIlIlIllIlIl);
    }
    
    public Object get(final String llllllllllllllIIlllllIlIIlIIlIll) throws JSONException {
        if (llllllllllllllIIlllllIlIIlIIlIll == null) {
            throw new JSONException("Null key.");
        }
        final Object llllllllllllllIIlllllIlIIlIIlIlI = this.opt(llllllllllllllIIlllllIlIIlIIlIll);
        if (llllllllllllllIIlllllIlIIlIIlIlI == null) {
            throw new JSONException(String.valueOf(new StringBuilder().append("JSONObject[").append(quote(llllllllllllllIIlllllIlIIlIIlIll)).append("] not found.")));
        }
        return llllllllllllllIIlllllIlIIlIIlIlI;
    }
    
    public Writer write(final Writer llllllllllllllIIllllIlllIIlIIIlI) throws JSONException {
        return this.write(llllllllllllllIIllllIlllIIlIIIlI, 0, 0);
    }
    
    public String getString(final String llllllllllllllIIlllllIIllIlIllll) throws JSONException {
        final Object llllllllllllllIIlllllIIllIllIIIl = this.get(llllllllllllllIIlllllIIllIlIllll);
        if (llllllllllllllIIlllllIIllIllIIIl instanceof String) {
            return (String)llllllllllllllIIlllllIIllIllIIIl;
        }
        throw wrongValueFormatException(llllllllllllllIIlllllIIllIlIllll, "string", null);
    }
    
    public BigDecimal optBigDecimal(final String llllllllllllllIIlllllIIlIIllllll, final BigDecimal llllllllllllllIIlllllIIlIlIIIIlI) {
        final Object llllllllllllllIIlllllIIlIlIIIIIl = this.opt(llllllllllllllIIlllllIIlIIllllll);
        return objectToBigDecimal(llllllllllllllIIlllllIIlIlIIIIIl, llllllllllllllIIlllllIIlIlIIIIlI);
    }
    
    public JSONArray optJSONArray(final String llllllllllllllIIlllllIIIllIllIll) {
        final Object llllllllllllllIIlllllIIIllIllIlI = this.opt(llllllllllllllIIlllllIIIllIllIll);
        return (llllllllllllllIIlllllIIIllIllIlI instanceof JSONArray) ? ((JSONArray)llllllllllllllIIlllllIIIllIllIlI) : null;
    }
    
    public float optFloat(final String llllllllllllllIIlllllIIIllllIlIl, final float llllllllllllllIIlllllIIIlllllIIl) {
        final Number llllllllllllllIIlllllIIIlllllIII = this.optNumber(llllllllllllllIIlllllIIIllllIlIl);
        if (llllllllllllllIIlllllIIIlllllIII == null) {
            return llllllllllllllIIlllllIIIlllllIIl;
        }
        final float llllllllllllllIIlllllIIIllllIlll = llllllllllllllIIlllllIIIlllllIII.floatValue();
        return llllllllllllllIIlllllIIIllllIlll;
    }
    
    public String optString(final String llllllllllllllIIlllllIIIlIIllIll, final String llllllllllllllIIlllllIIIlIIlIllI) {
        final Object llllllllllllllIIlllllIIIlIIllIIl = this.opt(llllllllllllllIIlllllIIIlIIllIll);
        return JSONObject.NULL.equals(llllllllllllllIIlllllIIIlIIllIIl) ? llllllllllllllIIlllllIIIlIIlIllI : llllllllllllllIIlllllIIIlIIllIIl.toString();
    }
    
    public JSONObject(final String llllllllllllllIIlllllIlIlIIllIlI) throws JSONException {
        this(new JSONTokener(llllllllllllllIIlllllIlIlIIllIlI));
    }
    
    private static JSONException wrongValueFormatException(final String llllllllllllllIIllllIllIllIIIlll, final String llllllllllllllIIllllIllIllIIIllI, final Throwable llllllllllllllIIllllIllIllIIlIII) {
        return new JSONException(String.valueOf(new StringBuilder().append("JSONObject[").append(quote(llllllllllllllIIllllIllIllIIIlll)).append("] is not a ").append(llllllllllllllIIllllIllIllIIIllI).append(".")), llllllllllllllIIllllIllIllIIlIII);
    }
    
    public Object opt(final String llllllllllllllIIlllllIIlIlllllIl) {
        return (llllllllllllllIIlllllIIlIlllllIl == null) ? null : this.map.get(llllllllllllllIIlllllIIlIlllllIl);
    }
    
    public Map<String, Object> toMap() {
        final Map<String, Object> llllllllllllllIIllllIllIllIlIIll = new HashMap<String, Object>();
        for (final Map.Entry<String, Object> llllllllllllllIIllllIllIllIlIlIl : this.entrySet()) {
            Object llllllllllllllIIllllIllIllIlIllI = null;
            if (llllllllllllllIIllllIllIllIlIlIl.getValue() == null || JSONObject.NULL.equals(llllllllllllllIIllllIllIllIlIlIl.getValue())) {
                final Object llllllllllllllIIllllIllIllIllIIl = null;
            }
            else if (llllllllllllllIIllllIllIllIlIlIl.getValue() instanceof JSONObject) {
                final Object llllllllllllllIIllllIllIllIllIII = llllllllllllllIIllllIllIllIlIlIl.getValue().toMap();
            }
            else if (llllllllllllllIIllllIllIllIlIlIl.getValue() instanceof JSONArray) {
                final Object llllllllllllllIIllllIllIllIlIlll = llllllllllllllIIllllIllIllIlIlIl.getValue().toList();
            }
            else {
                llllllllllllllIIllllIllIllIlIllI = llllllllllllllIIllllIllIllIlIlIl.getValue();
            }
            llllllllllllllIIllllIllIllIlIIll.put(llllllllllllllIIllllIllIllIlIlIl.getKey(), llllllllllllllIIllllIllIllIlIllI);
        }
        return llllllllllllllIIllllIllIllIlIIll;
    }
    
    public Object remove(final String llllllllllllllIIllllIllllIIIIllI) {
        return this.map.remove(llllllllllllllIIllllIllllIIIIllI);
    }
    
    public Number optNumber(final String llllllllllllllIIlllllIIIlIlIlllI, final Number llllllllllllllIIlllllIIIlIlIlIIl) {
        final Object llllllllllllllIIlllllIIIlIlIllII = this.opt(llllllllllllllIIlllllIIIlIlIlllI);
        if (JSONObject.NULL.equals(llllllllllllllIIlllllIIIlIlIllII)) {
            return llllllllllllllIIlllllIIIlIlIlIIl;
        }
        if (llllllllllllllIIlllllIIIlIlIllII instanceof Number) {
            return (Number)llllllllllllllIIlllllIIIlIlIllII;
        }
        try {
            return stringToNumber(llllllllllllllIIlllllIIIlIlIllII.toString());
        }
        catch (Exception llllllllllllllIIlllllIIIlIllIIII) {
            return llllllllllllllIIlllllIIIlIlIlIIl;
        }
    }
    
    public long getLong(final String llllllllllllllIIlllllIIlllIIlllI) throws JSONException {
        final Object llllllllllllllIIlllllIIlllIlIIII = this.get(llllllllllllllIIlllllIIlllIIlllI);
        if (llllllllllllllIIlllllIIlllIlIIII instanceof Number) {
            return ((Number)llllllllllllllIIlllllIIlllIlIIII).longValue();
        }
        try {
            return Long.parseLong(llllllllllllllIIlllllIIlllIlIIII.toString());
        }
        catch (Exception llllllllllllllIIlllllIIlllIlIIll) {
            throw wrongValueFormatException(llllllllllllllIIlllllIIlllIIlllI, "long", llllllllllllllIIlllllIIlllIlIIll);
        }
    }
    
    public int length() {
        return this.map.size();
    }
    
    protected static Number stringToNumber(final String llllllllllllllIIllllIlllIllIIllI) throws NumberFormatException {
        final char llllllllllllllIIllllIlllIllIIlll = llllllllllllllIIllllIlllIllIIllI.charAt(0);
        if ((llllllllllllllIIllllIlllIllIIlll < '0' || llllllllllllllIIllllIlllIllIIlll > '9') && llllllllllllllIIllllIlllIllIIlll != '-') {
            throw new NumberFormatException(String.valueOf(new StringBuilder().append("val [").append(llllllllllllllIIllllIlllIllIIllI).append("] is not a valid number.")));
        }
        if (isDecimalNotation(llllllllllllllIIllllIlllIllIIllI)) {
            if (llllllllllllllIIllllIlllIllIIllI.length() > 14) {
                return new BigDecimal(llllllllllllllIIllllIlllIllIIllI);
            }
            final Double llllllllllllllIIllllIlllIllIlIlI = Double.valueOf(llllllllllllllIIllllIlllIllIIllI);
            if (llllllllllllllIIllllIlllIllIlIlI.isInfinite() || llllllllllllllIIllllIlllIllIlIlI.isNaN()) {
                return new BigDecimal(llllllllllllllIIllllIlllIllIIllI);
            }
            return llllllllllllllIIllllIlllIllIlIlI;
        }
        else {
            final BigInteger llllllllllllllIIllllIlllIllIlIIl = new BigInteger(llllllllllllllIIllllIlllIllIIllI);
            if (llllllllllllllIIllllIlllIllIlIIl.bitLength() <= 31) {
                return llllllllllllllIIllllIlllIllIlIIl.intValue();
            }
            if (llllllllllllllIIllllIlllIllIlIIl.bitLength() <= 63) {
                return llllllllllllllIIllllIlllIllIlIIl.longValue();
            }
            return llllllllllllllIIllllIlllIllIlIIl;
        }
    }
    
    public static Object wrap(final Object llllllllllllllIIllllIlllIIlIlIll) {
        try {
            if (llllllllllllllIIllllIlllIIlIlIll == null) {
                return JSONObject.NULL;
            }
            if (llllllllllllllIIllllIlllIIlIlIll instanceof JSONObject || llllllllllllllIIllllIlllIIlIlIll instanceof JSONArray || JSONObject.NULL.equals(llllllllllllllIIllllIlllIIlIlIll) || llllllllllllllIIllllIlllIIlIlIll instanceof JSONString || llllllllllllllIIllllIlllIIlIlIll instanceof Byte || llllllllllllllIIllllIlllIIlIlIll instanceof Character || llllllllllllllIIllllIlllIIlIlIll instanceof Short || llllllllllllllIIllllIlllIIlIlIll instanceof Integer || llllllllllllllIIllllIlllIIlIlIll instanceof Long || llllllllllllllIIllllIlllIIlIlIll instanceof Boolean || llllllllllllllIIllllIlllIIlIlIll instanceof Float || llllllllllllllIIllllIlllIIlIlIll instanceof Double || llllllllllllllIIllllIlllIIlIlIll instanceof String || llllllllllllllIIllllIlllIIlIlIll instanceof BigInteger || llllllllllllllIIllllIlllIIlIlIll instanceof BigDecimal || llllllllllllllIIllllIlllIIlIlIll instanceof Enum) {
                return llllllllllllllIIllllIlllIIlIlIll;
            }
            if (llllllllllllllIIllllIlllIIlIlIll instanceof Collection) {
                final Collection<?> llllllllllllllIIllllIlllIIllIIII = (Collection<?>)llllllllllllllIIllllIlllIIlIlIll;
                return new JSONArray(llllllllllllllIIllllIlllIIllIIII);
            }
            if (llllllllllllllIIllllIlllIIlIlIll.getClass().isArray()) {
                return new JSONArray(llllllllllllllIIllllIlllIIlIlIll);
            }
            if (llllllllllllllIIllllIlllIIlIlIll instanceof Map) {
                final Map<?, ?> llllllllllllllIIllllIlllIIlIllll = (Map<?, ?>)llllllllllllllIIllllIlllIIlIlIll;
                return new JSONObject(llllllllllllllIIllllIlllIIlIllll);
            }
            final Package llllllllllllllIIllllIlllIIlIlllI = llllllllllllllIIllllIlllIIlIlIll.getClass().getPackage();
            final String llllllllllllllIIllllIlllIIlIllIl = (llllllllllllllIIllllIlllIIlIlllI != null) ? llllllllllllllIIllllIlllIIlIlllI.getName() : "";
            if (llllllllllllllIIllllIlllIIlIllIl.startsWith("java.") || llllllllllllllIIllllIlllIIlIllIl.startsWith("javax.") || llllllllllllllIIllllIlllIIlIlIll.getClass().getClassLoader() == null) {
                return llllllllllllllIIllllIlllIIlIlIll.toString();
            }
            return new JSONObject(llllllllllllllIIllllIlllIIlIlIll);
        }
        catch (Exception llllllllllllllIIllllIlllIIlIllII) {
            return null;
        }
    }
    
    public float optFloat(final String llllllllllllllIIlllllIIlIIIIIIll) {
        return this.optFloat(llllllllllllllIIlllllIIlIIIIIIll, Float.NaN);
    }
    
    public String optString(final String llllllllllllllIIlllllIIIlIlIIIIl) {
        return this.optString(llllllllllllllIIlllllIIIlIlIIIIl, "");
    }
    
    public <E extends Enum<E>> E optEnum(final Class<E> llllllllllllllIIlllllIIlIlllIllI, final String llllllllllllllIIlllllIIlIlllIIlI) {
        return this.optEnum(llllllllllllllIIlllllIIlIlllIllI, llllllllllllllIIlllllIIlIlllIIlI, (E)null);
    }
    
    public boolean optBoolean(final String llllllllllllllIIlllllIIlIlIIllII, final boolean llllllllllllllIIlllllIIlIlIIllll) {
        final Object llllllllllllllIIlllllIIlIlIIlllI = this.opt(llllllllllllllIIlllllIIlIlIIllII);
        if (JSONObject.NULL.equals(llllllllllllllIIlllllIIlIlIIlllI)) {
            return llllllllllllllIIlllllIIlIlIIllll;
        }
        if (llllllllllllllIIlllllIIlIlIIlllI instanceof Boolean) {
            return (boolean)llllllllllllllIIlllllIIlIlIIlllI;
        }
        try {
            return this.getBoolean(llllllllllllllIIlllllIIlIlIIllII);
        }
        catch (Exception llllllllllllllIIlllllIIlIlIlIIlI) {
            return llllllllllllllIIlllllIIlIlIIllll;
        }
    }
    
    public static String valueToString(final Object llllllllllllllIIllllIlllIIllIlIl) throws JSONException {
        return JSONWriter.valueToString(llllllllllllllIIllllIlllIIllIlIl);
    }
    
    private static int getAnnotationDepth(final Method llllllllllllllIIlllllIIIIIlIlIll, final Class<? extends Annotation> llllllllllllllIIlllllIIIIIlIlIlI) {
        if (llllllllllllllIIlllllIIIIIlIlIll == null || llllllllllllllIIlllllIIIIIlIlIlI == null) {
            return -1;
        }
        if (llllllllllllllIIlllllIIIIIlIlIll.isAnnotationPresent(llllllllllllllIIlllllIIIIIlIlIlI)) {
            return 1;
        }
        final Class<?> llllllllllllllIIlllllIIIIIlIllII = llllllllllllllIIlllllIIIIIlIlIll.getDeclaringClass();
        if (llllllllllllllIIlllllIIIIIlIllII.getSuperclass() == null) {
            return -1;
        }
        final Class<?>[] interfaces = llllllllllllllIIlllllIIIIIlIllII.getInterfaces();
        for (short llllllllllllllIIlllllIIIIIlIIlll = (short)interfaces.length, llllllllllllllIIlllllIIIIIlIIllI = 0; llllllllllllllIIlllllIIIIIlIIllI < llllllllllllllIIlllllIIIIIlIIlll; ++llllllllllllllIIlllllIIIIIlIIllI) {
            final Class<?> llllllllllllllIIlllllIIIIIllIIlI = interfaces[llllllllllllllIIlllllIIIIIlIIllI];
            try {
                final Method llllllllllllllIIlllllIIIIIllIllI = llllllllllllllIIlllllIIIIIllIIlI.getMethod(llllllllllllllIIlllllIIIIIlIlIll.getName(), llllllllllllllIIlllllIIIIIlIlIll.getParameterTypes());
                final int llllllllllllllIIlllllIIIIIllIlIl = getAnnotationDepth(llllllllllllllIIlllllIIIIIllIllI, llllllllllllllIIlllllIIIIIlIlIlI);
                if (llllllllllllllIIlllllIIIIIllIlIl > 0) {
                    return llllllllllllllIIlllllIIIIIllIlIl + 1;
                }
            }
            catch (SecurityException llllllllllllllIIlllllIIIIIllIlII) {}
            catch (NoSuchMethodException llllllllllllllIIlllllIIIIIllIIll) {}
        }
        try {
            final int llllllllllllllIIlllllIIIIIllIIIl = getAnnotationDepth(llllllllllllllIIlllllIIIIIlIllII.getSuperclass().getMethod(llllllllllllllIIlllllIIIIIlIlIll.getName(), llllllllllllllIIlllllIIIIIlIlIll.getParameterTypes()), llllllllllllllIIlllllIIIIIlIlIlI);
            if (llllllllllllllIIlllllIIIIIllIIIl > 0) {
                return llllllllllllllIIlllllIIIIIllIIIl + 1;
            }
            return -1;
        }
        catch (SecurityException llllllllllllllIIlllllIIIIIllIIII) {
            return -1;
        }
        catch (NoSuchMethodException llllllllllllllIIlllllIIIIIlIllll) {
            return -1;
        }
    }
    
    @Override
    public String toString() {
        try {
            return this.toString(0);
        }
        catch (Exception llllllllllllllIIllllIlllIlIIIlll) {
            return null;
        }
    }
    
    public JSONObject accumulate(final String llllllllllllllIIlllllIlIIllIlIII, final Object llllllllllllllIIlllllIlIIllIIlll) throws JSONException {
        testValidity(llllllllllllllIIlllllIlIIllIIlll);
        final Object llllllllllllllIIlllllIlIIllIIllI = this.opt(llllllllllllllIIlllllIlIIllIlIII);
        if (llllllllllllllIIlllllIlIIllIIllI == null) {
            this.put(llllllllllllllIIlllllIlIIllIlIII, (llllllllllllllIIlllllIlIIllIIlll instanceof JSONArray) ? new JSONArray().put(llllllllllllllIIlllllIlIIllIIlll) : llllllllllllllIIlllllIlIIllIIlll);
        }
        else if (llllllllllllllIIlllllIlIIllIIllI instanceof JSONArray) {
            ((JSONArray)llllllllllllllIIlllllIlIIllIIllI).put(llllllllllllllIIlllllIlIIllIIlll);
        }
        else {
            this.put(llllllllllllllIIlllllIlIIllIlIII, new JSONArray().put(llllllllllllllIIlllllIlIIllIIllI).put(llllllllllllllIIlllllIlIIllIIlll));
        }
        return this;
    }
    
    public static String quote(final String llllllllllllllIIllllIllllIlIIlll) {
        final StringWriter llllllllllllllIIllllIllllIlIIllI = new StringWriter();
        synchronized (llllllllllllllIIllllIllllIlIIllI.getBuffer()) {
            try {
                return quote(llllllllllllllIIllllIllllIlIIlll, llllllllllllllIIllllIllllIlIIllI).toString();
            }
            catch (IOException llllllllllllllIIllllIllllIlIlIII) {
                return "";
            }
        }
    }
    
    public JSONObject optJSONObject(final String llllllllllllllIIlllllIIIllIIllll) {
        final Object llllllllllllllIIlllllIIIllIlIIIl = this.opt(llllllllllllllIIlllllIIIllIIllll);
        return (llllllllllllllIIlllllIIIllIlIIIl instanceof JSONObject) ? ((JSONObject)llllllllllllllIIlllllIIIllIlIIIl) : null;
    }
    
    public boolean optBoolean(final String llllllllllllllIIlllllIIlIlIllIII) {
        return this.optBoolean(llllllllllllllIIlllllIIlIlIllIII, false);
    }
    
    public JSONObject(final String llllllllllllllIIlllllIlIlIIIIIll, final Locale llllllllllllllIIlllllIlIlIIIIIlI) throws JSONException {
        this();
        final ResourceBundle llllllllllllllIIlllllIlIlIIIIIIl = ResourceBundle.getBundle(llllllllllllllIIlllllIlIlIIIIIll, llllllllllllllIIlllllIlIlIIIIIlI, Thread.currentThread().getContextClassLoader());
        final Enumeration<String> llllllllllllllIIlllllIlIlIIIIIII = llllllllllllllIIlllllIlIlIIIIIIl.getKeys();
        while (llllllllllllllIIlllllIlIlIIIIIII.hasMoreElements()) {
            final Object llllllllllllllIIlllllIlIlIIIIlIl = llllllllllllllIIlllllIlIlIIIIIII.nextElement();
            if (llllllllllllllIIlllllIlIlIIIIlIl != null) {
                final String[] llllllllllllllIIlllllIlIlIIIlIII = ((String)llllllllllllllIIlllllIlIlIIIIlIl).split("\\.");
                final int llllllllllllllIIlllllIlIlIIIIlll = llllllllllllllIIlllllIlIlIIIlIII.length - 1;
                JSONObject llllllllllllllIIlllllIlIlIIIIllI = this;
                for (final String llllllllllllllIIlllllIlIlIIIlIll : llllllllllllllIIlllllIlIlIIIlIII) {
                    JSONObject llllllllllllllIIlllllIlIlIIIlIlI = llllllllllllllIIlllllIlIlIIIIllI.optJSONObject(llllllllllllllIIlllllIlIlIIIlIll);
                    if (llllllllllllllIIlllllIlIlIIIlIlI == null) {
                        llllllllllllllIIlllllIlIlIIIlIlI = new JSONObject();
                        llllllllllllllIIlllllIlIlIIIIllI.put(llllllllllllllIIlllllIlIlIIIlIll, llllllllllllllIIlllllIlIlIIIlIlI);
                    }
                    llllllllllllllIIlllllIlIlIIIIllI = llllllllllllllIIlllllIlIlIIIlIlI;
                }
                llllllllllllllIIlllllIlIlIIIIllI.put(llllllllllllllIIlllllIlIlIIIlIII[llllllllllllllIIlllllIlIlIIIIlll], llllllllllllllIIlllllIlIlIIIIIIl.getString((String)llllllllllllllIIlllllIlIlIIIIlIl));
            }
        }
    }
    
    private static final class Null
    {
        @Override
        protected final Object clone() {
            return this;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIlIIIlIIIlIllIlIlI) {
            return llllllllllllllIlIIIlIIIlIllIlIlI == null || llllllllllllllIlIIIlIIIlIllIlIlI == this;
        }
        
        @Override
        public String toString() {
            return "null";
        }
    }
}
