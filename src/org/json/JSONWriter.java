package org.json;

import java.io.*;

public class JSONWriter
{
    private /* synthetic */ boolean comma;
    private final /* synthetic */ JSONObject[] stack;
    private /* synthetic */ int top;
    protected /* synthetic */ Appendable writer;
    protected /* synthetic */ char mode;
    
    public JSONWriter key(final String llllllllllllllIlllllllIlllIIIlll) throws JSONException {
        if (llllllllllllllIlllllllIlllIIIlll == null) {
            throw new JSONException("Null key.");
        }
        if (this.mode == 'k') {
            try {
                final JSONObject llllllllllllllIlllllllIlllIIllII = this.stack[this.top - 1];
                if (llllllllllllllIlllllllIlllIIllII.has(llllllllllllllIlllllllIlllIIIlll)) {
                    throw new JSONException(String.valueOf(new StringBuilder().append("Duplicate key \"").append(llllllllllllllIlllllllIlllIIIlll).append("\"")));
                }
                llllllllllllllIlllllllIlllIIllII.put(llllllllllllllIlllllllIlllIIIlll, true);
                if (this.comma) {
                    this.writer.append(',');
                }
                this.writer.append(JSONObject.quote(llllllllllllllIlllllllIlllIIIlll));
                this.writer.append(':');
                this.comma = false;
                this.mode = 'o';
                return this;
            }
            catch (IOException llllllllllllllIlllllllIlllIIlIll) {
                throw new JSONException(llllllllllllllIlllllllIlllIIlIll);
            }
        }
        throw new JSONException("Misplaced key.");
    }
    
    public static String valueToString(final Object llllllllllllllIlllllllIllIlIlIIl) throws JSONException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnull          12
        //     4: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //     5: aconst_null    
        //     6: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //     9: ifeq            15
        //    12: ldc             "null"
        //    14: areturn        
        //    15: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //    16: instanceof      Lorg/json/JSONString;
        //    19: ifeq            78
        //    22: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //    23: checkcast       Lorg/json/JSONString;
        //    26: invokeinterface org/json/JSONString.toJSONString:()Ljava/lang/String;
        //    31: astore_1        /* llllllllllllllIlllllllIllIlIllll */
        //    32: goto            45
        //    35: astore_2        /* llllllllllllllIlllllllIllIllIIII */
        //    36: new             Lorg/json/JSONException;
        //    39: dup            
        //    40: aload_2         /* llllllllllllllIlllllllIllIllIIII */
        //    41: invokespecial   org/json/JSONException.<init>:(Ljava/lang/Throwable;)V
        //    44: athrow         
        //    45: aload_1         /* llllllllllllllIlllllllIllIlIlllI */
        //    46: ifnull          51
        //    49: aload_1         /* llllllllllllllIlllllllIllIlIlllI */
        //    50: areturn        
        //    51: new             Lorg/json/JSONException;
        //    54: dup            
        //    55: new             Ljava/lang/StringBuilder;
        //    58: dup            
        //    59: invokespecial   java/lang/StringBuilder.<init>:()V
        //    62: ldc             "Bad value from toJSONString: "
        //    64: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    67: aload_1         /* llllllllllllllIlllllllIllIlIlllI */
        //    68: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    71: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    74: invokespecial   org/json/JSONException.<init>:(Ljava/lang/String;)V
        //    77: athrow         
        //    78: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //    79: instanceof      Ljava/lang/Number;
        //    82: ifeq            113
        //    85: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //    86: checkcast       Ljava/lang/Number;
        //    89: invokestatic    org/json/JSONObject.numberToString:(Ljava/lang/Number;)Ljava/lang/String;
        //    92: astore_1        /* llllllllllllllIlllllllIllIlIllIl */
        //    93: getstatic       org/json/JSONObject.NUMBER_PATTERN:Ljava/util/regex/Pattern;
        //    96: aload_1         /* llllllllllllllIlllllllIllIlIllIl */
        //    97: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //   100: invokevirtual   java/util/regex/Matcher.matches:()Z
        //   103: ifeq            108
        //   106: aload_1         /* llllllllllllllIlllllllIllIlIllIl */
        //   107: areturn        
        //   108: aload_1         /* llllllllllllllIlllllllIllIlIllIl */
        //   109: invokestatic    org/json/JSONObject.quote:(Ljava/lang/String;)Ljava/lang/String;
        //   112: areturn        
        //   113: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   114: instanceof      Ljava/lang/Boolean;
        //   117: ifne            134
        //   120: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   121: instanceof      Lorg/json/JSONObject;
        //   124: ifne            134
        //   127: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   128: instanceof      Lorg/json/JSONArray;
        //   131: ifeq            139
        //   134: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   135: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   138: areturn        
        //   139: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   140: instanceof      Ljava/util/Map;
        //   143: ifeq            163
        //   146: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   147: checkcast       Ljava/util/Map;
        //   150: astore_1        /* llllllllllllllIlllllllIllIlIllII */
        //   151: new             Lorg/json/JSONObject;
        //   154: dup            
        //   155: aload_1         /* llllllllllllllIlllllllIllIlIllII */
        //   156: invokespecial   org/json/JSONObject.<init>:(Ljava/util/Map;)V
        //   159: invokevirtual   org/json/JSONObject.toString:()Ljava/lang/String;
        //   162: areturn        
        //   163: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   164: instanceof      Ljava/util/Collection;
        //   167: ifeq            187
        //   170: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   171: checkcast       Ljava/util/Collection;
        //   174: astore_1        /* llllllllllllllIlllllllIllIlIlIll */
        //   175: new             Lorg/json/JSONArray;
        //   178: dup            
        //   179: aload_1         /* llllllllllllllIlllllllIllIlIlIll */
        //   180: invokespecial   org/json/JSONArray.<init>:(Ljava/util/Collection;)V
        //   183: invokevirtual   org/json/JSONArray.toString:()Ljava/lang/String;
        //   186: areturn        
        //   187: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   188: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   191: invokevirtual   java/lang/Class.isArray:()Z
        //   194: ifeq            209
        //   197: new             Lorg/json/JSONArray;
        //   200: dup            
        //   201: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   202: invokespecial   org/json/JSONArray.<init>:(Ljava/lang/Object;)V
        //   205: invokevirtual   org/json/JSONArray.toString:()Ljava/lang/String;
        //   208: areturn        
        //   209: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   210: instanceof      Ljava/lang/Enum;
        //   213: ifeq            227
        //   216: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   217: checkcast       Ljava/lang/Enum;
        //   220: invokevirtual   java/lang/Enum.name:()Ljava/lang/String;
        //   223: invokestatic    org/json/JSONObject.quote:(Ljava/lang/String;)Ljava/lang/String;
        //   226: areturn        
        //   227: aload_0         /* llllllllllllllIlllllllIllIlIlIlI */
        //   228: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   231: invokestatic    org/json/JSONObject.quote:(Ljava/lang/String;)Ljava/lang/String;
        //   234: areturn        
        //    Exceptions:
        //  throws org.json.JSONException
        //    StackMapTable: 00 0E 0C 02 53 07 00 62 FC 00 09 07 00 36 05 FA 00 1A FC 00 1D 07 00 36 FA 00 04 14 04 17 17 15 11
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  22     32     35     45     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public JSONWriter array() throws JSONException {
        if (this.mode == 'i' || this.mode == 'o' || this.mode == 'a') {
            this.push(null);
            this.append("[");
            this.comma = false;
            return this;
        }
        throw new JSONException("Misplaced array.");
    }
    
    public JSONWriter endObject() throws JSONException {
        return this.end('k', '}');
    }
    
    private void pop(final char llllllllllllllIlllllllIllIlllllI) throws JSONException {
        if (this.top <= 0) {
            throw new JSONException("Nesting error.");
        }
        final char llllllllllllllIlllllllIllIllllIl = (this.stack[this.top - 1] == null) ? 'a' : 'k';
        if (llllllllllllllIlllllllIllIllllIl != llllllllllllllIlllllllIllIlllllI) {
            throw new JSONException("Nesting error.");
        }
        --this.top;
        this.mode = ((this.top == 0) ? 'd' : ((this.stack[this.top - 1] == null) ? 'a' : 'k'));
    }
    
    private void push(final JSONObject llllllllllllllIlllllllIllIllIllI) throws JSONException {
        if (this.top >= 200) {
            throw new JSONException("Nesting too deep.");
        }
        this.stack[this.top] = llllllllllllllIlllllllIllIllIllI;
        this.mode = ((llllllllllllllIlllllllIllIllIllI == null) ? 'a' : 'k');
        ++this.top;
    }
    
    private JSONWriter end(final char llllllllllllllIlllllllIlllIllIII, final char llllllllllllllIlllllllIlllIllIlI) throws JSONException {
        if (this.mode != llllllllllllllIlllllllIlllIllIII) {
            throw new JSONException((llllllllllllllIlllllllIlllIllIII == 'a') ? "Misplaced endArray." : "Misplaced endObject.");
        }
        this.pop(llllllllllllllIlllllllIlllIllIII);
        try {
            this.writer.append(llllllllllllllIlllllllIlllIllIlI);
        }
        catch (IOException llllllllllllllIlllllllIlllIlllIl) {
            throw new JSONException(llllllllllllllIlllllllIlllIlllIl);
        }
        this.comma = true;
        return this;
    }
    
    public JSONWriter value(final double llllllllllllllIlllllllIllIIllIll) throws JSONException {
        return this.value((Object)llllllllllllllIlllllllIllIIllIll);
    }
    
    public JSONWriter value(final boolean llllllllllllllIlllllllIllIlIIIll) throws JSONException {
        return this.append(llllllllllllllIlllllllIllIlIIIll ? "true" : "false");
    }
    
    static {
        maxdepth = 200;
    }
    
    private JSONWriter append(final String llllllllllllllIlllllllIllllIlIII) throws JSONException {
        if (llllllllllllllIlllllllIllllIlIII == null) {
            throw new JSONException("Null pointer");
        }
        if (this.mode != 'o') {
            if (this.mode != 'a') {
                throw new JSONException("Value out of sequence.");
            }
        }
        try {
            if (this.comma && this.mode == 'a') {
                this.writer.append(',');
            }
            this.writer.append(llllllllllllllIlllllllIllllIlIII);
        }
        catch (IOException llllllllllllllIlllllllIllllIlIlI) {
            throw new JSONException(llllllllllllllIlllllllIllllIlIlI);
        }
        if (this.mode == 'o') {
            this.mode = 'k';
        }
        this.comma = true;
        return this;
    }
    
    public JSONWriter(final Appendable llllllllllllllIlllllllIlllllIIII) {
        this.comma = false;
        this.mode = 'i';
        this.stack = new JSONObject[200];
        this.top = 0;
        this.writer = llllllllllllllIlllllllIlllllIIII;
    }
    
    public JSONWriter object() throws JSONException {
        if (this.mode == 'i') {
            this.mode = 'o';
        }
        if (this.mode == 'o' || this.mode == 'a') {
            this.append("{");
            this.push(new JSONObject());
            this.comma = false;
            return this;
        }
        throw new JSONException("Misplaced object.");
    }
    
    public JSONWriter value(final Object llllllllllllllIlllllllIllIIlIIIl) throws JSONException {
        return this.append(valueToString(llllllllllllllIlllllllIllIIlIIIl));
    }
    
    public JSONWriter endArray() throws JSONException {
        return this.end('a', ']');
    }
    
    public JSONWriter value(final long llllllllllllllIlllllllIllIIlIlIl) throws JSONException {
        return this.append(Long.toString(llllllllllllllIlllllllIllIIlIlIl));
    }
}
