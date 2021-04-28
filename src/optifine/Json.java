package optifine;

import com.google.gson.*;

public class Json
{
    public static int[] parseIntArray(final JsonElement llIlIIIlllIII, final int llIlIIIllIlll, final int[] llIlIIIllIllI) {
        if (llIlIIIlllIII == null) {
            return llIlIIIllIllI;
        }
        final JsonArray llIlIIIllIlIl = llIlIIIlllIII.getAsJsonArray();
        if (llIlIIIllIlIl.size() != llIlIIIllIlll) {
            throw new JsonParseException(String.valueOf(new StringBuilder("Wrong array length: ").append(llIlIIIllIlIl.size()).append(", should be: ").append(llIlIIIllIlll).append(", array: ").append(llIlIIIllIlIl)));
        }
        final int[] llIlIIIllIlII = new int[llIlIIIllIlIl.size()];
        for (int llIlIIIllIIll = 0; llIlIIIllIIll < llIlIIIllIlII.length; ++llIlIIIllIIll) {
            llIlIIIllIlII[llIlIIIllIIll] = llIlIIIllIlIl.get(llIlIIIllIIll).getAsInt();
        }
        return llIlIIIllIlII;
    }
    
    public static float[] parseFloatArray(final JsonElement llIlIIlIlIIII, final int llIlIIlIIlIIl, final float[] llIlIIlIIlIII) {
        if (llIlIIlIlIIII == null) {
            return llIlIIlIIlIII;
        }
        final JsonArray llIlIIlIIllIl = llIlIIlIlIIII.getAsJsonArray();
        if (llIlIIlIIllIl.size() != llIlIIlIIlIIl) {
            throw new JsonParseException(String.valueOf(new StringBuilder("Wrong array length: ").append(llIlIIlIIllIl.size()).append(", should be: ").append(llIlIIlIIlIIl).append(", array: ").append(llIlIIlIIllIl)));
        }
        final float[] llIlIIlIIllII = new float[llIlIIlIIllIl.size()];
        for (int llIlIIlIIlIll = 0; llIlIIlIIlIll < llIlIIlIIllII.length; ++llIlIIlIIlIll) {
            llIlIIlIIllII[llIlIIlIIlIll] = llIlIIlIIllIl.get(llIlIIlIIlIll).getAsFloat();
        }
        return llIlIIlIIllII;
    }
    
    public static boolean getBoolean(final JsonObject llIlIIlllIllI, final String llIlIIlllIIIl, final boolean llIlIIlllIlII) {
        final JsonElement llIlIIlllIIll = llIlIIlllIllI.get(llIlIIlllIIIl);
        return (llIlIIlllIIll == null) ? llIlIIlllIlII : llIlIIlllIIll.getAsBoolean();
    }
    
    public static int[] parseIntArray(final JsonElement llIlIIlIIIIII, final int llIlIIlIIIIIl) {
        return parseIntArray(llIlIIlIIIIII, llIlIIlIIIIIl, null);
    }
    
    public static float getFloat(final JsonObject llIlIlIIIIIlI, final String llIlIIlllllIl, final float llIlIlIIIIIII) {
        final JsonElement llIlIIlllllll = llIlIlIIIIIlI.get(llIlIIlllllIl);
        return (llIlIIlllllll == null) ? llIlIlIIIIIII : llIlIIlllllll.getAsFloat();
    }
    
    public static String getString(final JsonObject llIlIIllIIlII, final String llIlIIllIIIll, final String llIlIIlIllllI) {
        final JsonElement llIlIIllIIIIl = llIlIIllIIlII.get(llIlIIllIIIll);
        return (llIlIIllIIIIl == null) ? llIlIIlIllllI : llIlIIllIIIIl.getAsString();
    }
    
    public static String getString(final JsonObject llIlIIllIlIlI, final String llIlIIllIlIll) {
        return getString(llIlIIllIlIlI, llIlIIllIlIll, null);
    }
    
    public static float[] parseFloatArray(final JsonElement llIlIIlIllIII, final int llIlIIlIllIIl) {
        return parseFloatArray(llIlIIlIllIII, llIlIIlIllIIl, null);
    }
}
