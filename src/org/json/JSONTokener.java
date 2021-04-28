package org.json;

import java.io.*;

public class JSONTokener
{
    private /* synthetic */ long index;
    private /* synthetic */ char previous;
    private /* synthetic */ boolean eof;
    private /* synthetic */ long line;
    private final /* synthetic */ Reader reader;
    private /* synthetic */ long characterPreviousLine;
    private /* synthetic */ boolean usePrevious;
    private /* synthetic */ long character;
    
    public JSONTokener(final InputStream llllllllllllllllIIlIIlIIlIlIIlII) {
        this(new InputStreamReader(llllllllllllllllIIlIIlIIlIlIIlII));
    }
    
    public boolean end() {
        return this.eof && !this.usePrevious;
    }
    
    public String nextTo(final String llllllllllllllllIIlIIlIIIIlllllI) throws JSONException {
        final StringBuilder llllllllllllllllIIlIIlIIIIllllII = new StringBuilder();
        char llllllllllllllllIIlIIlIIIIllllIl;
        while (true) {
            llllllllllllllllIIlIIlIIIIllllIl = this.next();
            if (llllllllllllllllIIlIIlIIIIlllllI.indexOf(llllllllllllllllIIlIIlIIIIllllIl) >= 0 || llllllllllllllllIIlIIlIIIIllllIl == '\0' || llllllllllllllllIIlIIlIIIIllllIl == '\n' || llllllllllllllllIIlIIlIIIIllllIl == '\r') {
                break;
            }
            llllllllllllllllIIlIIlIIIIllllII.append(llllllllllllllllIIlIIlIIIIllllIl);
        }
        if (llllllllllllllllIIlIIlIIIIllllIl != '\0') {
            this.back();
        }
        return String.valueOf(llllllllllllllllIIlIIlIIIIllllII).trim();
    }
    
    private void decrementIndexes() {
        --this.index;
        if (this.previous == '\r' || this.previous == '\n') {
            --this.line;
            this.character = this.characterPreviousLine;
        }
        else if (this.character > 0L) {
            --this.character;
        }
    }
    
    public char skipTo(final char llllllllllllllllIIlIIlIIIIlIIIII) throws JSONException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        org/json/JSONTokener.index:J
        //     4: lstore_3        /* llllllllllllllllIIlIIlIIIIlIIlIl */
        //     5: aload_0         /* llllllllllllllllIIlIIlIIIIIlllIl */
        //     6: getfield        org/json/JSONTokener.character:J
        //     9: lstore          llllllllllllllllIIlIIlIIIIlIIlII
        //    11: aload_0         /* llllllllllllllllIIlIIlIIIIIlllIl */
        //    12: getfield        org/json/JSONTokener.line:J
        //    15: lstore          llllllllllllllllIIlIIlIIIIlIIIll
        //    17: aload_0         /* llllllllllllllllIIlIIlIIIIIlllIl */
        //    18: getfield        org/json/JSONTokener.reader:Ljava/io/Reader;
        //    21: ldc             1000000
        //    23: invokevirtual   java/io/Reader.mark:(I)V
        //    26: aload_0         /* llllllllllllllllIIlIIlIIIIIlllIl */
        //    27: invokevirtual   org/json/JSONTokener.next:()C
        //    30: istore_2        /* llllllllllllllllIIlIIlIIIIIllIll */
        //    31: iload_2         /* llllllllllllllllIIlIIlIIIIIlllll */
        //    32: ifne            61
        //    35: aload_0         /* llllllllllllllllIIlIIlIIIIIlllIl */
        //    36: getfield        org/json/JSONTokener.reader:Ljava/io/Reader;
        //    39: invokevirtual   java/io/Reader.reset:()V
        //    42: aload_0         /* llllllllllllllllIIlIIlIIIIIlllIl */
        //    43: lload_3         /* llllllllllllllllIIlIIlIIIIlIIlIl */
        //    44: putfield        org/json/JSONTokener.index:J
        //    47: aload_0         /* llllllllllllllllIIlIIlIIIIIlllIl */
        //    48: lload           llllllllllllllllIIlIIlIIIIlIIlII
        //    50: putfield        org/json/JSONTokener.character:J
        //    53: aload_0         /* llllllllllllllllIIlIIlIIIIIlllIl */
        //    54: lload           llllllllllllllllIIlIIlIIIIlIIIll
        //    56: putfield        org/json/JSONTokener.line:J
        //    59: iconst_0       
        //    60: ireturn        
        //    61: iload_2         /* llllllllllllllllIIlIIlIIIIIlllll */
        //    62: iload_1         /* llllllllllllllllIIlIIlIIIIIlllII */
        //    63: if_icmpne       26
        //    66: aload_0         /* llllllllllllllllIIlIIlIIIIIlllIl */
        //    67: getfield        org/json/JSONTokener.reader:Ljava/io/Reader;
        //    70: iconst_1       
        //    71: invokevirtual   java/io/Reader.mark:(I)V
        //    74: goto            87
        //    77: astore_3        /* llllllllllllllllIIlIIlIIIIlIIIlI */
        //    78: new             Lorg/json/JSONException;
        //    81: dup            
        //    82: aload_3         /* llllllllllllllllIIlIIlIIIIlIIIlI */
        //    83: invokespecial   org/json/JSONException.<init>:(Ljava/lang/Throwable;)V
        //    86: athrow         
        //    87: aload_0         /* llllllllllllllllIIlIIlIIIIIlllIl */
        //    88: invokevirtual   org/json/JSONTokener.back:()V
        //    91: iload_2         /* llllllllllllllllIIlIIlIIIIIllllI */
        //    92: ireturn        
        //    Exceptions:
        //  throws org.json.JSONException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      60     77     87     Ljava/io/IOException;
        //  61     74     77     87     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static int dehexchar(final char llllllllllllllllIIlIIlIIlIIlIllI) {
        if (llllllllllllllllIIlIIlIIlIIlIllI >= '0' && llllllllllllllllIIlIIlIIlIIlIllI <= '9') {
            return llllllllllllllllIIlIIlIIlIIlIllI - '0';
        }
        if (llllllllllllllllIIlIIlIIlIIlIllI >= 'A' && llllllllllllllllIIlIIlIIlIIlIllI <= 'F') {
            return llllllllllllllllIIlIIlIIlIIlIllI - '7';
        }
        if (llllllllllllllllIIlIIlIIlIIlIllI >= 'a' && llllllllllllllllIIlIIlIIlIIlIllI <= 'f') {
            return llllllllllllllllIIlIIlIIlIIlIllI - 'W';
        }
        return -1;
    }
    
    public JSONTokener(final Reader llllllllllllllllIIlIIlIIlIlIlIlI) {
        this.reader = (llllllllllllllllIIlIIlIIlIlIlIlI.markSupported() ? llllllllllllllllIIlIIlIIlIlIlIlI : new BufferedReader(llllllllllllllllIIlIIlIIlIlIlIlI));
        this.eof = false;
        this.usePrevious = false;
        this.previous = '\0';
        this.index = 0L;
        this.character = 1L;
        this.characterPreviousLine = 0L;
        this.line = 1L;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(" at ").append(this.index).append(" [character ").append(this.character).append(" line ").append(this.line).append("]"));
    }
    
    public String nextString(final char llllllllllllllllIIlIIlIIIlIlIIll) throws JSONException {
        final StringBuilder llllllllllllllllIIlIIlIIIlIlIlIl = new StringBuilder();
        while (true) {
            char llllllllllllllllIIlIIlIIIlIlIllI = this.next();
            switch (llllllllllllllllIIlIIlIIIlIlIllI) {
                case '\0':
                case '\n':
                case '\r': {
                    throw this.syntaxError("Unterminated string");
                }
                case '\\': {
                    llllllllllllllllIIlIIlIIIlIlIllI = this.next();
                    switch (llllllllllllllllIIlIIlIIIlIlIllI) {
                        case 'b': {
                            llllllllllllllllIIlIIlIIIlIlIlIl.append('\b');
                            continue;
                        }
                        case 't': {
                            llllllllllllllllIIlIIlIIIlIlIlIl.append('\t');
                            continue;
                        }
                        case 'n': {
                            llllllllllllllllIIlIIlIIIlIlIlIl.append('\n');
                            continue;
                        }
                        case 'f': {
                            llllllllllllllllIIlIIlIIIlIlIlIl.append('\f');
                            continue;
                        }
                        case 'r': {
                            llllllllllllllllIIlIIlIIIlIlIlIl.append('\r');
                            continue;
                        }
                        case 'u': {
                            try {
                                llllllllllllllllIIlIIlIIIlIlIlIl.append((char)Integer.parseInt(this.next(4), 16));
                                continue;
                            }
                            catch (NumberFormatException llllllllllllllllIIlIIlIIIlIllIIl) {
                                throw this.syntaxError("Illegal escape.", llllllllllllllllIIlIIlIIIlIllIIl);
                            }
                        }
                        case '\"':
                        case '\'':
                        case '/':
                        case '\\': {
                            llllllllllllllllIIlIIlIIIlIlIlIl.append(llllllllllllllllIIlIIlIIIlIlIllI);
                            continue;
                        }
                        default: {
                            throw this.syntaxError("Illegal escape.");
                        }
                    }
                    break;
                }
                default: {
                    if (llllllllllllllllIIlIIlIIIlIlIllI == llllllllllllllllIIlIIlIIIlIlIIll) {
                        return String.valueOf(llllllllllllllllIIlIIlIIIlIlIlIl);
                    }
                    llllllllllllllllIIlIIlIIIlIlIlIl.append(llllllllllllllllIIlIIlIIIlIlIllI);
                    continue;
                }
            }
        }
    }
    
    public String nextTo(final char llllllllllllllllIIlIIlIIIlIIIllI) throws JSONException {
        final StringBuilder llllllllllllllllIIlIIlIIIlIIlIII = new StringBuilder();
        char llllllllllllllllIIlIIlIIIlIIlIll;
        while (true) {
            llllllllllllllllIIlIIlIIIlIIlIll = this.next();
            if (llllllllllllllllIIlIIlIIIlIIlIll == llllllllllllllllIIlIIlIIIlIIIllI || llllllllllllllllIIlIIlIIIlIIlIll == '\0' || llllllllllllllllIIlIIlIIIlIIlIll == '\n' || llllllllllllllllIIlIIlIIIlIIlIll == '\r') {
                break;
            }
            llllllllllllllllIIlIIlIIIlIIlIII.append(llllllllllllllllIIlIIlIIIlIIlIll);
        }
        if (llllllllllllllllIIlIIlIIIlIIlIll != '\0') {
            this.back();
        }
        return String.valueOf(llllllllllllllllIIlIIlIIIlIIlIII).trim();
    }
    
    public boolean more() throws JSONException {
        if (this.usePrevious) {
            return true;
        }
        try {
            this.reader.mark(1);
        }
        catch (IOException llllllllllllllllIIlIIlIIlIIIllll) {
            throw new JSONException("Unable to preserve stream position", llllllllllllllllIIlIIlIIlIIIllll);
        }
        try {
            if (this.reader.read() <= 0) {
                this.eof = true;
                return false;
            }
            this.reader.reset();
        }
        catch (IOException llllllllllllllllIIlIIlIIlIIIlllI) {
            throw new JSONException("Unable to read the next character from the stream", llllllllllllllllIIlIIlIIlIIIlllI);
        }
        return true;
    }
    
    public char next() throws JSONException {
        if (this.usePrevious) {
            this.usePrevious = false;
            final int llllllllllllllllIIlIIlIIlIIIIlll = this.previous;
        }
        else {
            try {
                final int llllllllllllllllIIlIIlIIlIIIIlII = this.reader.read();
            }
            catch (IOException llllllllllllllllIIlIIlIIlIIIIllI) {
                throw new JSONException(llllllllllllllllIIlIIlIIlIIIIllI);
            }
        }
        final int llllllllllllllllIIlIIlIIlIIIIIll;
        if (llllllllllllllllIIlIIlIIlIIIIIll <= 0) {
            this.eof = true;
            return '\0';
        }
        this.incrementIndexes(llllllllllllllllIIlIIlIIlIIIIIll);
        this.previous = (char)llllllllllllllllIIlIIlIIlIIIIIll;
        return this.previous;
    }
    
    public JSONException syntaxError(final String llllllllllllllllIIlIIlIIIIIlIIlI) {
        return new JSONException(String.valueOf(new StringBuilder().append(llllllllllllllllIIlIIlIIIIIlIIlI).append(this.toString())));
    }
    
    public Object nextValue() throws JSONException {
        char llllllllllllllllIIlIIlIIIIllIIlI = this.nextClean();
        switch (llllllllllllllllIIlIIlIIIIllIIlI) {
            case '\"':
            case '\'': {
                return this.nextString(llllllllllllllllIIlIIlIIIIllIIlI);
            }
            case '{': {
                this.back();
                return new JSONObject(this);
            }
            case '[': {
                this.back();
                return new JSONArray(this);
            }
            default: {
                final StringBuilder llllllllllllllllIIlIIlIIIIllIIII = new StringBuilder();
                while (llllllllllllllllIIlIIlIIIIllIIlI >= ' ' && ",:]}/\\\"[{;=#".indexOf(llllllllllllllllIIlIIlIIIIllIIlI) < 0) {
                    llllllllllllllllIIlIIlIIIIllIIII.append(llllllllllllllllIIlIIlIIIIllIIlI);
                    llllllllllllllllIIlIIlIIIIllIIlI = this.next();
                }
                if (!this.eof) {
                    this.back();
                }
                final String llllllllllllllllIIlIIlIIIIllIIIl = String.valueOf(llllllllllllllllIIlIIlIIIIllIIII).trim();
                if ("".equals(llllllllllllllllIIlIIlIIIIllIIIl)) {
                    throw this.syntaxError("Missing value");
                }
                return JSONObject.stringToValue(llllllllllllllllIIlIIlIIIIllIIIl);
            }
        }
    }
    
    public char next(final char llllllllllllllllIIlIIlIIIlllIlIl) throws JSONException {
        final char llllllllllllllllIIlIIlIIIlllIlII = this.next();
        if (llllllllllllllllIIlIIlIIIlllIlII == llllllllllllllllIIlIIlIIIlllIlIl) {
            return llllllllllllllllIIlIIlIIIlllIlII;
        }
        if (llllllllllllllllIIlIIlIIIlllIlII > '\0') {
            throw this.syntaxError(String.valueOf(new StringBuilder().append("Expected '").append(llllllllllllllllIIlIIlIIIlllIlIl).append("' and instead saw '").append(llllllllllllllllIIlIIlIIIlllIlII).append("'")));
        }
        throw this.syntaxError(String.valueOf(new StringBuilder().append("Expected '").append(llllllllllllllllIIlIIlIIIlllIlIl).append("' and instead saw ''")));
    }
    
    public JSONException syntaxError(final String llllllllllllllllIIlIIlIIIIIIlIlI, final Throwable llllllllllllllllIIlIIlIIIIIIllII) {
        return new JSONException(String.valueOf(new StringBuilder().append(llllllllllllllllIIlIIlIIIIIIlIlI).append(this.toString())), llllllllllllllllIIlIIlIIIIIIllII);
    }
    
    public char nextClean() throws JSONException {
        char llllllllllllllllIIlIIlIIIllIIIlI;
        do {
            llllllllllllllllIIlIIlIIIllIIIlI = this.next();
        } while (llllllllllllllllIIlIIlIIIllIIIlI != '\0' && llllllllllllllllIIlIIlIIIllIIIlI <= ' ');
        return llllllllllllllllIIlIIlIIIllIIIlI;
    }
    
    public JSONTokener(final String llllllllllllllllIIlIIlIIlIIllllI) {
        this(new StringReader(llllllllllllllllIIlIIlIIlIIllllI));
    }
    
    private void incrementIndexes(final int llllllllllllllllIIlIIlIIIlllllII) {
        if (llllllllllllllllIIlIIlIIIlllllII > 0) {
            ++this.index;
            if (llllllllllllllllIIlIIlIIIlllllII == 13) {
                ++this.line;
                this.characterPreviousLine = this.character;
                this.character = 0L;
            }
            else if (llllllllllllllllIIlIIlIIIlllllII == 10) {
                if (this.previous != '\r') {
                    ++this.line;
                    this.characterPreviousLine = this.character;
                }
                this.character = 0L;
            }
            else {
                ++this.character;
            }
        }
    }
    
    public String next(final int llllllllllllllllIIlIIlIIIllIlIll) throws JSONException {
        if (llllllllllllllllIIlIIlIIIllIlIll == 0) {
            return "";
        }
        final char[] llllllllllllllllIIlIIlIIIllIlIlI = new char[llllllllllllllllIIlIIlIIIllIlIll];
        for (int llllllllllllllllIIlIIlIIIllIlIIl = 0; llllllllllllllllIIlIIlIIIllIlIIl < llllllllllllllllIIlIIlIIIllIlIll; ++llllllllllllllllIIlIIlIIIllIlIIl) {
            llllllllllllllllIIlIIlIIIllIlIlI[llllllllllllllllIIlIIlIIIllIlIIl] = this.next();
            if (this.end()) {
                throw this.syntaxError("Substring bounds error");
            }
        }
        return new String(llllllllllllllllIIlIIlIIIllIlIlI);
    }
    
    public void back() throws JSONException {
        if (this.usePrevious || this.index <= 0L) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.decrementIndexes();
        this.usePrevious = true;
        this.eof = false;
    }
}
