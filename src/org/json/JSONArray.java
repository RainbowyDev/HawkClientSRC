package org.json;

import java.io.*;
import java.lang.reflect.*;
import java.math.*;
import java.util.*;

public class JSONArray implements Iterable<Object>
{
    private final /* synthetic */ ArrayList<Object> myArrayList;
    
    public boolean isNull(final int lllllllllllllllIIIllIlIIlIIlllll) {
        return JSONObject.NULL.equals(this.opt(lllllllllllllllIIIllIlIIlIIlllll));
    }
    
    public JSONArray put(final Collection<?> lllllllllllllllIIIllIIlllIlIlIll) {
        return this.put(new JSONArray(lllllllllllllllIIIllIIlllIlIlIll));
    }
    
    public String optString(final int lllllllllllllllIIIllIIllllIIIlIl) {
        return this.optString(lllllllllllllllIIIllIIllllIIIlIl, "");
    }
    
    public BigInteger optBigInteger(final int lllllllllllllllIIIllIlIIIIIlIlII, final BigInteger lllllllllllllllIIIllIlIIIIIlIIll) {
        final Object lllllllllllllllIIIllIlIIIIIlIIlI = this.opt(lllllllllllllllIIIllIlIIIIIlIlII);
        return JSONObject.objectToBigInteger(lllllllllllllllIIIllIlIIIIIlIIlI, lllllllllllllllIIIllIlIIIIIlIIll);
    }
    
    public Writer write(final Writer lllllllllllllllIIIllIIlIllIlIlIl, final int lllllllllllllllIIIllIIlIllIlIIII, final int lllllllllllllllIIIllIIlIllIlIIll) throws JSONException {
        try {
            boolean lllllllllllllllIIIllIIlIllIllIIl = false;
            final int lllllllllllllllIIIllIIlIllIllIII = this.length();
            lllllllllllllllIIIllIIlIllIlIlIl.write(91);
            Label_0176: {
                if (lllllllllllllllIIIllIIlIllIllIII == 1) {
                    try {
                        JSONObject.writeValue(lllllllllllllllIIIllIIlIllIlIlIl, this.myArrayList.get(0), lllllllllllllllIIIllIIlIllIlIIII, lllllllllllllllIIIllIIlIllIlIIll);
                        break Label_0176;
                    }
                    catch (Exception lllllllllllllllIIIllIIlIllIlllIl) {
                        throw new JSONException("Unable to write JSONArray value at index: 0", lllllllllllllllIIIllIIlIllIlllIl);
                    }
                }
                if (lllllllllllllllIIIllIIlIllIllIII != 0) {
                    final int lllllllllllllllIIIllIIlIllIllIlI = lllllllllllllllIIIllIIlIllIlIIll + lllllllllllllllIIIllIIlIllIlIIII;
                    for (int lllllllllllllllIIIllIIlIllIllIll = 0; lllllllllllllllIIIllIIlIllIllIll < lllllllllllllllIIIllIIlIllIllIII; ++lllllllllllllllIIIllIIlIllIllIll) {
                        if (lllllllllllllllIIIllIIlIllIllIIl) {
                            lllllllllllllllIIIllIIlIllIlIlIl.write(44);
                        }
                        if (lllllllllllllllIIIllIIlIllIlIIII > 0) {
                            lllllllllllllllIIIllIIlIllIlIlIl.write(10);
                        }
                        JSONObject.indent(lllllllllllllllIIIllIIlIllIlIlIl, lllllllllllllllIIIllIIlIllIllIlI);
                        try {
                            JSONObject.writeValue(lllllllllllllllIIIllIIlIllIlIlIl, this.myArrayList.get(lllllllllllllllIIIllIIlIllIllIll), lllllllllllllllIIIllIIlIllIlIIII, lllllllllllllllIIIllIIlIllIllIlI);
                        }
                        catch (Exception lllllllllllllllIIIllIIlIllIlllII) {
                            throw new JSONException(String.valueOf(new StringBuilder().append("Unable to write JSONArray value at index: ").append(lllllllllllllllIIIllIIlIllIllIll)), lllllllllllllllIIIllIIlIllIlllII);
                        }
                        lllllllllllllllIIIllIIlIllIllIIl = true;
                    }
                    if (lllllllllllllllIIIllIIlIllIlIIII > 0) {
                        lllllllllllllllIIIllIIlIllIlIlIl.write(10);
                    }
                    JSONObject.indent(lllllllllllllllIIIllIIlIllIlIlIl, lllllllllllllllIIIllIIlIllIlIIll);
                }
            }
            lllllllllllllllIIIllIIlIllIlIlIl.write(93);
            return lllllllllllllllIIIllIIlIllIlIlIl;
        }
        catch (IOException lllllllllllllllIIIllIIlIllIlIlll) {
            throw new JSONException(lllllllllllllllIIIllIIlIllIlIlll);
        }
    }
    
    public String getString(final int lllllllllllllllIIIllIlIIlIlIIlII) throws JSONException {
        final Object lllllllllllllllIIIllIlIIlIlIIllI = this.get(lllllllllllllllIIIllIlIIlIlIIlII);
        if (lllllllllllllllIIIllIlIIlIlIIllI instanceof String) {
            return (String)lllllllllllllllIIIllIlIIlIlIIllI;
        }
        throw wrongValueFormatException(lllllllllllllllIIIllIlIIlIlIIlII, "String", null);
    }
    
    public int length() {
        return this.myArrayList.size();
    }
    
    public <E extends Enum<E>> E getEnum(final Class<E> lllllllllllllllIIIllIlIIllllIIII, final int lllllllllllllllIIIllIlIIlllIllll) throws JSONException {
        final E lllllllllllllllIIIllIlIIllllIIlI = (E)this.optEnum((Class<Enum>)lllllllllllllllIIIllIlIIllllIIII, lllllllllllllllIIIllIlIIlllIllll);
        if (lllllllllllllllIIIllIlIIllllIIlI == null) {
            throw wrongValueFormatException(lllllllllllllllIIIllIlIIlllIllll, String.valueOf(new StringBuilder().append("enum of type ").append(JSONObject.quote(lllllllllllllllIIIllIlIIllllIIII.getSimpleName()))), null);
        }
        return lllllllllllllllIIIllIlIIllllIIlI;
    }
    
    public JSONArray put(final float lllllllllllllllIIIllIIlllIIlllll) throws JSONException {
        return this.put((Object)lllllllllllllllIIIllIIlllIIlllll);
    }
    
    public Number getNumber(final int lllllllllllllllIIIllIlIIllllllII) throws JSONException {
        final Object lllllllllllllllIIIllIlIIlllllllI = this.get(lllllllllllllllIIIllIlIIllllllII);
        try {
            if (lllllllllllllllIIIllIlIIlllllllI instanceof Number) {
                return (Number)lllllllllllllllIIIllIlIIlllllllI;
            }
            return JSONObject.stringToNumber(lllllllllllllllIIIllIlIIlllllllI.toString());
        }
        catch (Exception lllllllllllllllIIIllIlIlIIIIIIIl) {
            throw wrongValueFormatException(lllllllllllllllIIIllIlIIllllllII, "number", lllllllllllllllIIIllIlIlIIIIIIIl);
        }
    }
    
    public boolean similar(final Object lllllllllllllllIIIllIIllIIIlIIII) {
        if (!(lllllllllllllllIIIllIIllIIIlIIII instanceof JSONArray)) {
            return false;
        }
        final int lllllllllllllllIIIllIIllIIIlIIlI = this.length();
        if (lllllllllllllllIIIllIIllIIIlIIlI != ((JSONArray)lllllllllllllllIIIllIIllIIIlIIII).length()) {
            return false;
        }
        for (int lllllllllllllllIIIllIIllIIIlIlIl = 0; lllllllllllllllIIIllIIllIIIlIlIl < lllllllllllllllIIIllIIllIIIlIIlI; ++lllllllllllllllIIIllIIllIIIlIlIl) {
            final Object lllllllllllllllIIIllIIllIIIlIlll = this.myArrayList.get(lllllllllllllllIIIllIIllIIIlIlIl);
            final Object lllllllllllllllIIIllIIllIIIlIllI = ((JSONArray)lllllllllllllllIIIllIIllIIIlIIII).myArrayList.get(lllllllllllllllIIIllIIllIIIlIlIl);
            if (lllllllllllllllIIIllIIllIIIlIlll != lllllllllllllllIIIllIIllIIIlIllI) {
                if (lllllllllllllllIIIllIIllIIIlIlll == null) {
                    return false;
                }
                if (lllllllllllllllIIIllIIllIIIlIlll instanceof JSONObject) {
                    if (!((JSONObject)lllllllllllllllIIIllIIllIIIlIlll).similar(lllllllllllllllIIIllIIllIIIlIllI)) {
                        return false;
                    }
                }
                else if (lllllllllllllllIIIllIIllIIIlIlll instanceof JSONArray) {
                    if (!((JSONArray)lllllllllllllllIIIllIIllIIIlIlll).similar(lllllllllllllllIIIllIIllIIIlIllI)) {
                        return false;
                    }
                }
                else if (!lllllllllllllllIIIllIIllIIIlIlll.equals(lllllllllllllllIIIllIIllIIIlIllI)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Object get(final int lllllllllllllllIIIllIlIlIIlIlIII) throws JSONException {
        final Object lllllllllllllllIIIllIlIlIIlIlIlI = this.opt(lllllllllllllllIIIllIlIlIIlIlIII);
        if (lllllllllllllllIIIllIlIlIIlIlIlI == null) {
            throw new JSONException(String.valueOf(new StringBuilder().append("JSONArray[").append(lllllllllllllllIIIllIlIlIIlIlIII).append("] not found.")));
        }
        return lllllllllllllllIIIllIlIlIIlIlIlI;
    }
    
    public float getFloat(final int lllllllllllllllIIIllIlIlIIIIlIll) throws JSONException {
        final Object lllllllllllllllIIIllIlIlIIIIlIlI = this.get(lllllllllllllllIIIllIlIlIIIIlIll);
        if (lllllllllllllllIIIllIlIlIIIIlIlI instanceof Number) {
            return (float)lllllllllllllllIIIllIlIlIIIIlIlI;
        }
        try {
            return Float.parseFloat(lllllllllllllllIIIllIlIlIIIIlIlI.toString());
        }
        catch (Exception lllllllllllllllIIIllIlIlIIIIllIl) {
            throw wrongValueFormatException(lllllllllllllllIIIllIlIlIIIIlIll, "float", lllllllllllllllIIIllIlIlIIIIllIl);
        }
    }
    
    public JSONArray put(final int lllllllllllllllIIIllIIllIlIIIIII, final Object lllllllllllllllIIIllIIllIIllllll) throws JSONException {
        if (lllllllllllllllIIIllIIllIlIIIIII < 0) {
            throw new JSONException(String.valueOf(new StringBuilder().append("JSONArray[").append(lllllllllllllllIIIllIIllIlIIIIII).append("] not found.")));
        }
        if (lllllllllllllllIIIllIIllIlIIIIII < this.length()) {
            JSONObject.testValidity(lllllllllllllllIIIllIIllIIllllll);
            this.myArrayList.set(lllllllllllllllIIIllIIllIlIIIIII, lllllllllllllllIIIllIIllIIllllll);
            return this;
        }
        if (lllllllllllllllIIIllIIllIlIIIIII == this.length()) {
            return this.put(lllllllllllllllIIIllIIllIIllllll);
        }
        this.myArrayList.ensureCapacity(lllllllllllllllIIIllIIllIlIIIIII + 1);
        while (lllllllllllllllIIIllIIllIlIIIIII != this.length()) {
            this.myArrayList.add(JSONObject.NULL);
        }
        return this.put(lllllllllllllllIIIllIIllIIllllll);
    }
    
    public JSONArray put(final int lllllllllllllllIIIllIIllIlllllll, final boolean lllllllllllllllIIIllIIllIllllllI) throws JSONException {
        return this.put(lllllllllllllllIIIllIIllIlllllll, lllllllllllllllIIIllIIllIllllllI ? Boolean.TRUE : Boolean.FALSE);
    }
    
    public Object optQuery(final JSONPointer lllllllllllllllIIIllIIllIIlIIlll) {
        try {
            return lllllllllllllllIIIllIIllIIlIIlll.queryFrom(this);
        }
        catch (JSONPointerException lllllllllllllllIIIllIIllIIlIlIIl) {
            return null;
        }
    }
    
    public JSONObject toJSONObject(final JSONArray lllllllllllllllIIIllIIllIIIIIlIl) throws JSONException {
        if (lllllllllllllllIIIllIIllIIIIIlIl == null || lllllllllllllllIIIllIIllIIIIIlIl.isEmpty() || this.isEmpty()) {
            return null;
        }
        final JSONObject lllllllllllllllIIIllIIllIIIIIlII = new JSONObject(lllllllllllllllIIIllIIllIIIIIlIl.length());
        for (int lllllllllllllllIIIllIIllIIIIIlll = 0; lllllllllllllllIIIllIIllIIIIIlll < lllllllllllllllIIIllIIllIIIIIlIl.length(); ++lllllllllllllllIIIllIIllIIIIIlll) {
            lllllllllllllllIIIllIIllIIIIIlII.put(lllllllllllllllIIIllIIllIIIIIlIl.getString(lllllllllllllllIIIllIIllIIIIIlll), this.opt(lllllllllllllllIIIllIIllIIIIIlll));
        }
        return lllllllllllllllIIIllIIllIIIIIlII;
    }
    
    public JSONArray put(final int lllllllllllllllIIIllIIllIlllIllI, final Collection<?> lllllllllllllllIIIllIIllIllllIII) throws JSONException {
        return this.put(lllllllllllllllIIIllIIllIlllIllI, new JSONArray(lllllllllllllllIIIllIIllIllllIII));
    }
    
    public BigInteger getBigInteger(final int lllllllllllllllIIIllIlIIllIllIII) throws JSONException {
        final Object lllllllllllllllIIIllIlIIllIllIll = this.get(lllllllllllllllIIIllIlIIllIllIII);
        final BigInteger lllllllllllllllIIIllIlIIllIllIlI = JSONObject.objectToBigInteger(lllllllllllllllIIIllIlIIllIllIll, null);
        if (lllllllllllllllIIIllIlIIllIllIlI == null) {
            throw wrongValueFormatException(lllllllllllllllIIIllIlIIllIllIII, "BigInteger", lllllllllllllllIIIllIlIIllIllIll, null);
        }
        return lllllllllllllllIIIllIlIIllIllIlI;
    }
    
    public boolean optBoolean(final int lllllllllllllllIIIllIlIIIllllIII, final boolean lllllllllllllllIIIllIlIIIlllIlII) {
        try {
            return this.getBoolean(lllllllllllllllIIIllIlIIIllllIII);
        }
        catch (Exception lllllllllllllllIIIllIlIIIllllIlI) {
            return lllllllllllllllIIIllIlIIIlllIlII;
        }
    }
    
    public JSONArray put(final int lllllllllllllllIIIllIIllIllIllIl, final double lllllllllllllllIIIllIIllIllIllII) throws JSONException {
        return this.put(lllllllllllllllIIIllIIllIllIllIl, (Object)lllllllllllllllIIIllIIllIllIllII);
    }
    
    public long optLong(final int lllllllllllllllIIIllIIlllllIIlII, final long lllllllllllllllIIIllIIlllllIIIll) {
        final Number lllllllllllllllIIIllIIlllllIIIlI = this.optNumber(lllllllllllllllIIIllIIlllllIIlII, null);
        if (lllllllllllllllIIIllIIlllllIIIlI == null) {
            return lllllllllllllllIIIllIIlllllIIIll;
        }
        return lllllllllllllllIIIllIIlllllIIIlI.longValue();
    }
    
    public int optInt(final int lllllllllllllllIIIllIlIIIlIIIIll) {
        return this.optInt(lllllllllllllllIIIllIlIIIlIIIIll, 0);
    }
    
    public long optLong(final int lllllllllllllllIIIllIIlllllIllII) {
        return this.optLong(lllllllllllllllIIIllIIlllllIllII, 0L);
    }
    
    public JSONArray(final JSONTokener lllllllllllllllIIIllIlIlIlIlIIIl) throws JSONException {
        this();
        if (lllllllllllllllIIIllIlIlIlIlIIIl.nextClean() != '[') {
            throw lllllllllllllllIIIllIlIlIlIlIIIl.syntaxError("A JSONArray text must start with '['");
        }
        char lllllllllllllllIIIllIlIlIlIlIIll = lllllllllllllllIIIllIlIlIlIlIIIl.nextClean();
        if (lllllllllllllllIIIllIlIlIlIlIIll == '\0') {
            throw lllllllllllllllIIIllIlIlIlIlIIIl.syntaxError("Expected a ',' or ']'");
        }
        if (lllllllllllllllIIIllIlIlIlIlIIll == ']') {
            return;
        }
        lllllllllllllllIIIllIlIlIlIlIIIl.back();
        while (true) {
            if (lllllllllllllllIIIllIlIlIlIlIIIl.nextClean() == ',') {
                lllllllllllllllIIIllIlIlIlIlIIIl.back();
                this.myArrayList.add(JSONObject.NULL);
            }
            else {
                lllllllllllllllIIIllIlIlIlIlIIIl.back();
                this.myArrayList.add(lllllllllllllllIIIllIlIlIlIlIIIl.nextValue());
            }
            switch (lllllllllllllllIIIllIlIlIlIlIIIl.nextClean()) {
                case '\0': {
                    throw lllllllllllllllIIIllIlIlIlIlIIIl.syntaxError("Expected a ',' or ']'");
                }
                case ',': {
                    lllllllllllllllIIIllIlIlIlIlIIll = lllllllllllllllIIIllIlIlIlIlIIIl.nextClean();
                    if (lllllllllllllllIIIllIlIlIlIlIIll == '\0') {
                        throw lllllllllllllllIIIllIlIlIlIlIIIl.syntaxError("Expected a ',' or ']'");
                    }
                    if (lllllllllllllllIIIllIlIlIlIlIIll == ']') {
                        return;
                    }
                    lllllllllllllllIIIllIlIlIlIlIIIl.back();
                    continue;
                }
                case ']': {}
                default: {
                    throw lllllllllllllllIIIllIlIlIlIlIIIl.syntaxError("Expected a ',' or ']'");
                }
            }
        }
    }
    
    public JSONArray put(final Map<?, ?> lllllllllllllllIIIllIIlllIIIllll) {
        return this.put(new JSONObject(lllllllllllllllIIIllIIlllIIIllll));
    }
    
    public String toString(final int lllllllllllllllIIIllIIlIllllIIII) throws JSONException {
        final StringWriter lllllllllllllllIIIllIIlIllllIIlI = new StringWriter();
        synchronized (lllllllllllllllIIIllIIlIllllIIlI.getBuffer()) {
            return this.write(lllllllllllllllIIIllIIlIllllIIlI, lllllllllllllllIIIllIIlIllllIIII, 0).toString();
        }
    }
    
    public JSONArray(final Object lllllllllllllllIIIllIlIlIIllIlll) throws JSONException {
        this();
        if (lllllllllllllllIIIllIlIlIIllIlll.getClass().isArray()) {
            final int lllllllllllllllIIIllIlIlIIlllIIl = Array.getLength(lllllllllllllllIIIllIlIlIIllIlll);
            this.myArrayList.ensureCapacity(lllllllllllllllIIIllIlIlIIlllIIl);
            for (int lllllllllllllllIIIllIlIlIIlllIlI = 0; lllllllllllllllIIIllIlIlIIlllIlI < lllllllllllllllIIIllIlIlIIlllIIl; ++lllllllllllllllIIIllIlIlIIlllIlI) {
                this.put(JSONObject.wrap(Array.get(lllllllllllllllIIIllIlIlIIllIlll, lllllllllllllllIIIllIlIlIIlllIlI)));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }
    
    public boolean isEmpty() {
        return this.myArrayList.isEmpty();
    }
    
    public JSONArray put(final int lllllllllllllllIIIllIIlllIIllIIl) {
        return this.put((Object)lllllllllllllllIIIllIIlllIIllIIl);
    }
    
    public JSONArray optJSONArray(final int lllllllllllllllIIIllIIlllllllIlI) {
        final Object lllllllllllllllIIIllIIllllllllII = this.opt(lllllllllllllllIIIllIIlllllllIlI);
        return (lllllllllllllllIIIllIIllllllllII instanceof JSONArray) ? ((JSONArray)lllllllllllllllIIIllIIllllllllII) : null;
    }
    
    public long getLong(final int lllllllllllllllIIIllIlIIlIlIlllI) throws JSONException {
        final Object lllllllllllllllIIIllIlIIlIllIIII = this.get(lllllllllllllllIIIllIlIIlIlIlllI);
        if (lllllllllllllllIIIllIlIIlIllIIII instanceof Number) {
            return ((Number)lllllllllllllllIIIllIlIIlIllIIII).longValue();
        }
        try {
            return Long.parseLong(lllllllllllllllIIIllIlIIlIllIIII.toString());
        }
        catch (Exception lllllllllllllllIIIllIlIIlIllIIll) {
            throw wrongValueFormatException(lllllllllllllllIIIllIlIIlIlIlllI, "long", lllllllllllllllIIIllIlIIlIllIIll);
        }
    }
    
    public <E extends Enum<E>> E optEnum(final Class<E> lllllllllllllllIIIllIlIIIIIllllI, final int lllllllllllllllIIIllIlIIIIlIIIIl, final E lllllllllllllllIIIllIlIIIIIlllII) {
        try {
            final Object lllllllllllllllIIIllIlIIIIlIIllI = this.opt(lllllllllllllllIIIllIlIIIIlIIIIl);
            if (JSONObject.NULL.equals(lllllllllllllllIIIllIlIIIIlIIllI)) {
                return lllllllllllllllIIIllIlIIIIIlllII;
            }
            if (lllllllllllllllIIIllIlIIIIIllllI.isAssignableFrom(lllllllllllllllIIIllIlIIIIlIIllI.getClass())) {
                final E lllllllllllllllIIIllIlIIIIlIIlll = (E)lllllllllllllllIIIllIlIIIIlIIllI;
                return lllllllllllllllIIIllIlIIIIlIIlll;
            }
            return Enum.valueOf(lllllllllllllllIIIllIlIIIIIllllI, lllllllllllllllIIIllIlIIIIlIIllI.toString());
        }
        catch (IllegalArgumentException lllllllllllllllIIIllIlIIIIlIIlIl) {
            return lllllllllllllllIIIllIlIIIIIlllII;
        }
        catch (NullPointerException lllllllllllllllIIIllIlIIIIlIIlII) {
            return lllllllllllllllIIIllIlIIIIIlllII;
        }
    }
    
    public Object query(final JSONPointer lllllllllllllllIIIllIIllIIllIIll) {
        return lllllllllllllllIIIllIIllIIllIIll.queryFrom(this);
    }
    
    public JSONArray put(final double lllllllllllllllIIIllIIlllIlIIlll) throws JSONException {
        return this.put((Object)lllllllllllllllIIIllIIlllIlIIlll);
    }
    
    public boolean getBoolean(final int lllllllllllllllIIIllIlIlIIlIIIlI) throws JSONException {
        final Object lllllllllllllllIIIllIlIlIIlIIIIl = this.get(lllllllllllllllIIIllIlIlIIlIIIlI);
        if (lllllllllllllllIIIllIlIlIIlIIIIl.equals(Boolean.FALSE) || (lllllllllllllllIIIllIlIlIIlIIIIl instanceof String && ((String)lllllllllllllllIIIllIlIlIIlIIIIl).equalsIgnoreCase("false"))) {
            return false;
        }
        if (lllllllllllllllIIIllIlIlIIlIIIIl.equals(Boolean.TRUE) || (lllllllllllllllIIIllIlIlIIlIIIIl instanceof String && ((String)lllllllllllllllIIIllIlIlIIlIIIIl).equalsIgnoreCase("true"))) {
            return true;
        }
        throw wrongValueFormatException(lllllllllllllllIIIllIlIlIIlIIIlI, "boolean", null);
    }
    
    public double optDouble(final int lllllllllllllllIIIllIlIIIllIIIIl, final double lllllllllllllllIIIllIlIIIllIIIII) {
        final Number lllllllllllllllIIIllIlIIIllIIlII = this.optNumber(lllllllllllllllIIIllIlIIIllIIIIl, null);
        if (lllllllllllllllIIIllIlIIIllIIlII == null) {
            return lllllllllllllllIIIllIlIIIllIIIII;
        }
        final double lllllllllllllllIIIllIlIIIllIIIll = lllllllllllllllIIIllIlIIIllIIlII.doubleValue();
        return lllllllllllllllIIIllIlIIIllIIIll;
    }
    
    public Object remove(final int lllllllllllllllIIIllIIllIIlIIIII) {
        return (lllllllllllllllIIIllIIllIIlIIIII >= 0 && lllllllllllllllIIIllIIllIIlIIIII < this.length()) ? this.myArrayList.remove(lllllllllllllllIIIllIIllIIlIIIII) : null;
    }
    
    private static JSONException wrongValueFormatException(final int lllllllllllllllIIIllIIlIlIlllIII, final String lllllllllllllllIIIllIIlIlIllIlII, final Throwable lllllllllllllllIIIllIIlIlIllIIll) {
        return new JSONException(String.valueOf(new StringBuilder().append("JSONArray[").append(lllllllllllllllIIIllIIlIlIlllIII).append("] is not a ").append(lllllllllllllllIIIllIIlIlIllIlII).append(".")), lllllllllllllllIIIllIIlIlIllIIll);
    }
    
    public JSONArray put(final int lllllllllllllllIIIllIIllIlIlIIlI, final long lllllllllllllllIIIllIIllIlIlIlII) throws JSONException {
        return this.put(lllllllllllllllIIIllIIllIlIlIIlI, (Object)lllllllllllllllIIIllIIllIlIlIlII);
    }
    
    public JSONArray put(final boolean lllllllllllllllIIIllIIlllIllIIIl) {
        return this.put(lllllllllllllllIIIllIIlllIllIIIl ? Boolean.TRUE : Boolean.FALSE);
    }
    
    public String optString(final int lllllllllllllllIIIllIIlllIlllIIl, final String lllllllllllllllIIIllIIlllIlllIII) {
        final Object lllllllllllllllIIIllIIlllIlllIll = this.opt(lllllllllllllllIIIllIIlllIlllIIl);
        return JSONObject.NULL.equals(lllllllllllllllIIIllIIlllIlllIll) ? lllllllllllllllIIIllIIlllIlllIII : lllllllllllllllIIIllIIlllIlllIll.toString();
    }
    
    public JSONArray put(final Object lllllllllllllllIIIllIIlllIIIIlll) {
        JSONObject.testValidity(lllllllllllllllIIIllIIlllIIIIlll);
        this.myArrayList.add(lllllllllllllllIIIllIIlllIIIIlll);
        return this;
    }
    
    public Writer write(final Writer lllllllllllllllIIIllIIlIlllIIlll) throws JSONException {
        return this.write(lllllllllllllllIIIllIIlIlllIIlll, 0, 0);
    }
    
    public BigDecimal getBigDecimal(final int lllllllllllllllIIIllIlIIlllIIlII) throws JSONException {
        final Object lllllllllllllllIIIllIlIIlllIIlll = this.get(lllllllllllllllIIIllIlIIlllIIlII);
        final BigDecimal lllllllllllllllIIIllIlIIlllIIllI = JSONObject.objectToBigDecimal(lllllllllllllllIIIllIlIIlllIIlll, null);
        if (lllllllllllllllIIIllIlIIlllIIllI == null) {
            throw wrongValueFormatException(lllllllllllllllIIIllIlIIlllIIlII, "BigDecimal", lllllllllllllllIIIllIlIIlllIIlll, null);
        }
        return lllllllllllllllIIIllIlIIlllIIllI;
    }
    
    public JSONArray getJSONArray(final int lllllllllllllllIIIllIlIIllIIIlIl) throws JSONException {
        final Object lllllllllllllllIIIllIlIIllIIIlII = this.get(lllllllllllllllIIIllIlIIllIIIlIl);
        if (lllllllllllllllIIIllIlIIllIIIlII instanceof JSONArray) {
            return (JSONArray)lllllllllllllllIIIllIlIIllIIIlII;
        }
        throw wrongValueFormatException(lllllllllllllllIIIllIlIIllIIIlIl, "JSONArray", null);
    }
    
    public double optDouble(final int lllllllllllllllIIIllIlIIIllIllIl) {
        return this.optDouble(lllllllllllllllIIIllIlIIIllIllIl, Double.NaN);
    }
    
    private static JSONException wrongValueFormatException(final int lllllllllllllllIIIllIIlIlIlIlIlI, final String lllllllllllllllIIIllIIlIlIlIlIIl, final Object lllllllllllllllIIIllIIlIlIlIlIII, final Throwable lllllllllllllllIIIllIIlIlIlIIlll) {
        return new JSONException(String.valueOf(new StringBuilder().append("JSONArray[").append(lllllllllllllllIIIllIIlIlIlIlIlI).append("] is not a ").append(lllllllllllllllIIIllIIlIlIlIlIIl).append(" (").append(lllllllllllllllIIIllIIlIlIlIlIII).append(").")), lllllllllllllllIIIllIIlIlIlIIlll);
    }
    
    public JSONArray put(final int lllllllllllllllIIIllIIllIlIIlIIl, final Map<?, ?> lllllllllllllllIIIllIIllIlIIlIll) throws JSONException {
        this.put(lllllllllllllllIIIllIIllIlIIlIIl, new JSONObject(lllllllllllllllIIIllIIllIlIIlIll));
        return this;
    }
    
    public JSONArray put(final long lllllllllllllllIIIllIIlllIIlIIll) {
        return this.put((Object)lllllllllllllllIIIllIIlllIIlIIll);
    }
    
    public int optInt(final int lllllllllllllllIIIllIlIIIIllllIl, final int lllllllllllllllIIIllIlIIIIlllIII) {
        final Number lllllllllllllllIIIllIlIIIIlllIll = this.optNumber(lllllllllllllllIIIllIlIIIIllllIl, null);
        if (lllllllllllllllIIIllIlIIIIlllIll == null) {
            return lllllllllllllllIIIllIlIIIIlllIII;
        }
        return lllllllllllllllIIIllIlIIIIlllIll.intValue();
    }
    
    public JSONArray put(final int lllllllllllllllIIIllIIllIllIIlll, final float lllllllllllllllIIIllIIllIllIIIll) throws JSONException {
        return this.put(lllllllllllllllIIIllIIllIllIIlll, (Object)lllllllllllllllIIIllIIllIllIIIll);
    }
    
    public JSONArray(final Collection<?> lllllllllllllllIIIllIlIlIlIIIIll) {
        if (lllllllllllllllIIIllIlIlIlIIIIll == null) {
            this.myArrayList = new ArrayList<Object>();
        }
        else {
            this.myArrayList = new ArrayList<Object>(lllllllllllllllIIIllIlIlIlIIIIll.size());
            for (final Object lllllllllllllllIIIllIlIlIlIIIlIl : lllllllllllllllIIIllIlIlIlIIIIll) {
                this.myArrayList.add(JSONObject.wrap(lllllllllllllllIIIllIlIlIlIIIlIl));
            }
        }
    }
    
    public double getDouble(final int lllllllllllllllIIIllIlIlIIIlIlll) throws JSONException {
        final Object lllllllllllllllIIIllIlIlIIIlIllI = this.get(lllllllllllllllIIIllIlIlIIIlIlll);
        if (lllllllllllllllIIIllIlIlIIIlIllI instanceof Number) {
            return ((Number)lllllllllllllllIIIllIlIlIIIlIllI).doubleValue();
        }
        try {
            return Double.parseDouble(lllllllllllllllIIIllIlIlIIIlIllI.toString());
        }
        catch (Exception lllllllllllllllIIIllIlIlIIIllIIl) {
            throw wrongValueFormatException(lllllllllllllllIIIllIlIlIIIlIlll, "double", lllllllllllllllIIIllIlIlIIIllIIl);
        }
    }
    
    public boolean optBoolean(final int lllllllllllllllIIIllIlIIlIIIIIIl) {
        return this.optBoolean(lllllllllllllllIIIllIlIIlIIIIIIl, false);
    }
    
    public float optFloat(final int lllllllllllllllIIIllIlIIIlIlIIIl, final float lllllllllllllllIIIllIlIIIlIlIIII) {
        final Number lllllllllllllllIIIllIlIIIlIIllll = this.optNumber(lllllllllllllllIIIllIlIIIlIlIIIl, null);
        if (lllllllllllllllIIIllIlIIIlIIllll == null) {
            return lllllllllllllllIIIllIlIIIlIlIIII;
        }
        final float lllllllllllllllIIIllIlIIIlIIlllI = lllllllllllllllIIIllIlIIIlIIllll.floatValue();
        return lllllllllllllllIIIllIlIIIlIIlllI;
    }
    
    public List<Object> toList() {
        final List<Object> lllllllllllllllIIIllIIlIllIIIIll = new ArrayList<Object>(this.myArrayList.size());
        for (final Object lllllllllllllllIIIllIIlIllIIIlIl : this.myArrayList) {
            if (lllllllllllllllIIIllIIlIllIIIlIl == null || JSONObject.NULL.equals(lllllllllllllllIIIllIIlIllIIIlIl)) {
                lllllllllllllllIIIllIIlIllIIIIll.add(null);
            }
            else if (lllllllllllllllIIIllIIlIllIIIlIl instanceof JSONArray) {
                lllllllllllllllIIIllIIlIllIIIIll.add(((JSONArray)lllllllllllllllIIIllIIlIllIIIlIl).toList());
            }
            else if (lllllllllllllllIIIllIIlIllIIIlIl instanceof JSONObject) {
                lllllllllllllllIIIllIIlIllIIIIll.add(((JSONObject)lllllllllllllllIIIllIIlIllIIIlIl).toMap());
            }
            else {
                lllllllllllllllIIIllIIlIllIIIIll.add(lllllllllllllllIIIllIIlIllIIIlIl);
            }
        }
        return lllllllllllllllIIIllIIlIllIIIIll;
    }
    
    public BigDecimal optBigDecimal(final int lllllllllllllllIIIllIlIIIIIIlIII, final BigDecimal lllllllllllllllIIIllIlIIIIIIIlll) {
        final Object lllllllllllllllIIIllIlIIIIIIIllI = this.opt(lllllllllllllllIIIllIlIIIIIIlIII);
        return JSONObject.objectToBigDecimal(lllllllllllllllIIIllIlIIIIIIIllI, lllllllllllllllIIIllIlIIIIIIIlll);
    }
    
    public JSONArray put(final int lllllllllllllllIIIllIIllIlIllllI, final int lllllllllllllllIIIllIIllIlIlllIl) throws JSONException {
        return this.put(lllllllllllllllIIIllIIllIlIllllI, (Object)lllllllllllllllIIIllIIllIlIlllIl);
    }
    
    public String join(final String lllllllllllllllIIIllIlIIlIIlIlIl) throws JSONException {
        final int lllllllllllllllIIIllIlIIlIIlIlII = this.length();
        if (lllllllllllllllIIIllIlIIlIIlIlII == 0) {
            return "";
        }
        final StringBuilder lllllllllllllllIIIllIlIIlIIlIIll = new StringBuilder(JSONObject.valueToString(this.myArrayList.get(0)));
        for (int lllllllllllllllIIIllIlIIlIIlIlll = 1; lllllllllllllllIIIllIlIIlIIlIlll < lllllllllllllllIIIllIlIIlIIlIlII; ++lllllllllllllllIIIllIlIIlIIlIlll) {
            lllllllllllllllIIIllIlIIlIIlIIll.append(lllllllllllllllIIIllIlIIlIIlIlIl).append(JSONObject.valueToString(this.myArrayList.get(lllllllllllllllIIIllIlIIlIIlIlll)));
        }
        return String.valueOf(lllllllllllllllIIIllIlIIlIIlIIll);
    }
    
    public Object query(final String lllllllllllllllIIIllIIllIIlllIll) {
        return this.query(new JSONPointer(lllllllllllllllIIIllIIllIIlllIll));
    }
    
    public JSONArray(final String lllllllllllllllIIIllIlIlIlIIlIlI) throws JSONException {
        this(new JSONTokener(lllllllllllllllIIIllIlIlIlIIlIlI));
    }
    
    @Override
    public Iterator<Object> iterator() {
        return this.myArrayList.iterator();
    }
    
    public float optFloat(final int lllllllllllllllIIIllIlIIIlIllIII) {
        return this.optFloat(lllllllllllllllIIIllIlIIIlIllIII, Float.NaN);
    }
    
    public Object opt(final int lllllllllllllllIIIllIlIIlIIIIlll) {
        return (lllllllllllllllIIIllIlIIlIIIIlll < 0 || lllllllllllllllIIIllIlIIlIIIIlll >= this.length()) ? null : this.myArrayList.get(lllllllllllllllIIIllIlIIlIIIIlll);
    }
    
    public int getInt(final int lllllllllllllllIIIllIlIIllIIllII) throws JSONException {
        final Object lllllllllllllllIIIllIlIIllIIlllI = this.get(lllllllllllllllIIIllIlIIllIIllII);
        if (lllllllllllllllIIIllIlIIllIIlllI instanceof Number) {
            return ((Number)lllllllllllllllIIIllIlIIllIIlllI).intValue();
        }
        try {
            return Integer.parseInt(lllllllllllllllIIIllIlIIllIIlllI.toString());
        }
        catch (Exception lllllllllllllllIIIllIlIIllIlIIIl) {
            throw wrongValueFormatException(lllllllllllllllIIIllIlIIllIIllII, "int", lllllllllllllllIIIllIlIIllIlIIIl);
        }
    }
    
    public Number optNumber(final int lllllllllllllllIIIllIIllllIIllII, final Number lllllllllllllllIIIllIIllllIIlIll) {
        final Object lllllllllllllllIIIllIIllllIIlllI = this.opt(lllllllllllllllIIIllIIllllIIllII);
        if (JSONObject.NULL.equals(lllllllllllllllIIIllIIllllIIlllI)) {
            return lllllllllllllllIIIllIIllllIIlIll;
        }
        if (lllllllllllllllIIIllIIllllIIlllI instanceof Number) {
            return (Number)lllllllllllllllIIIllIIllllIIlllI;
        }
        if (lllllllllllllllIIIllIIllllIIlllI instanceof String) {
            try {
                return JSONObject.stringToNumber((String)lllllllllllllllIIIllIIllllIIlllI);
            }
            catch (Exception lllllllllllllllIIIllIIllllIlIIlI) {
                return lllllllllllllllIIIllIIllllIIlIll;
            }
        }
        return lllllllllllllllIIIllIIllllIIlIll;
    }
    
    public JSONArray() {
        this.myArrayList = new ArrayList<Object>();
    }
    
    public JSONObject getJSONObject(final int lllllllllllllllIIIllIlIIlIlllIIl) throws JSONException {
        final Object lllllllllllllllIIIllIlIIlIlllIll = this.get(lllllllllllllllIIIllIlIIlIlllIIl);
        if (lllllllllllllllIIIllIlIIlIlllIll instanceof JSONObject) {
            return (JSONObject)lllllllllllllllIIIllIlIIlIlllIll;
        }
        throw wrongValueFormatException(lllllllllllllllIIIllIlIIlIlllIIl, "JSONObject", null);
    }
    
    public JSONObject optJSONObject(final int lllllllllllllllIIIllIIllllllIIIl) {
        final Object lllllllllllllllIIIllIIllllllIIll = this.opt(lllllllllllllllIIIllIIllllllIIIl);
        return (lllllllllllllllIIIllIIllllllIIll instanceof JSONObject) ? ((JSONObject)lllllllllllllllIIIllIIllllllIIll) : null;
    }
    
    @Override
    public String toString() {
        try {
            return this.toString(0);
        }
        catch (Exception lllllllllllllllIIIllIIlIllllllIl) {
            return null;
        }
    }
    
    public <E extends Enum<E>> E optEnum(final Class<E> lllllllllllllllIIIllIlIIIIlIllll, final int lllllllllllllllIIIllIlIIIIllIIIl) {
        return this.optEnum(lllllllllllllllIIIllIlIIIIlIllll, lllllllllllllllIIIllIlIIIIllIIIl, (E)null);
    }
    
    public Object optQuery(final String lllllllllllllllIIIllIIllIIlIllll) {
        return this.optQuery(new JSONPointer(lllllllllllllllIIIllIIllIIlIllll));
    }
    
    public Number optNumber(final int lllllllllllllllIIIllIIllllIllIlI) {
        return this.optNumber(lllllllllllllllIIIllIIllllIllIlI, null);
    }
}
