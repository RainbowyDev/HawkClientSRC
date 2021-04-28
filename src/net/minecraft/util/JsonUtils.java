package net.minecraft.util;

import org.apache.commons.lang3.*;
import com.google.gson.*;

public class JsonUtils
{
    public static boolean getJsonObjectBooleanFieldValue(final JsonObject lllllllllllllllIlIIIIIIlllIllIIl, final String lllllllllllllllIlIIIIIIlllIllIII) {
        if (lllllllllllllllIlIIIIIIlllIllIIl.has(lllllllllllllllIlIIIIIIlllIllIII)) {
            return getJsonElementBooleanValue(lllllllllllllllIlIIIIIIlllIllIIl.get(lllllllllllllllIlIIIIIIlllIllIII), lllllllllllllllIlIIIIIIlllIllIII);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(lllllllllllllllIlIIIIIIlllIllIII).append(", expected to find a Boolean")));
    }
    
    public static boolean getJsonObjectBooleanFieldValueOrDefault(final JsonObject lllllllllllllllIlIIIIIIlllIlIlII, final String lllllllllllllllIlIIIIIIlllIlIIll, final boolean lllllllllllllllIlIIIIIIlllIlIIlI) {
        return lllllllllllllllIlIIIIIIlllIlIlII.has(lllllllllllllllIlIIIIIIlllIlIIll) ? getJsonElementBooleanValue(lllllllllllllllIlIIIIIIlllIlIlII.get(lllllllllllllllIlIIIIIIlllIlIIll), lllllllllllllllIlIIIIIIlllIlIIll) : lllllllllllllllIlIIIIIIlllIlIIlI;
    }
    
    public static boolean jsonObjectHasNamedField(final JsonObject lllllllllllllllIlIIIIIIllllllIlI, final String lllllllllllllllIlIIIIIIllllllIIl) {
        return lllllllllllllllIlIIIIIIllllllIlI != null && lllllllllllllllIlIIIIIIllllllIlI.get(lllllllllllllllIlIIIIIIllllllIIl) != null;
    }
    
    public static String getJsonObjectStringFieldValueOrDefault(final JsonObject lllllllllllllllIlIIIIIIllllIIllI, final String lllllllllllllllIlIIIIIIllllIIlIl, final String lllllllllllllllIlIIIIIIllllIIlII) {
        return lllllllllllllllIlIIIIIIllllIIllI.has(lllllllllllllllIlIIIIIIllllIIlIl) ? getJsonElementStringValue(lllllllllllllllIlIIIIIIllllIIllI.get(lllllllllllllllIlIIIIIIllllIIlIl), lllllllllllllllIlIIIIIIllllIIlIl) : lllllllllllllllIlIIIIIIllllIIlII;
    }
    
    public static String getJsonObjectStringFieldValue(final JsonObject lllllllllllllllIlIIIIIIlllllIIII, final String lllllllllllllllIlIIIIIIllllIllll) {
        if (lllllllllllllllIlIIIIIIlllllIIII.has(lllllllllllllllIlIIIIIIllllIllll)) {
            return getJsonElementStringValue(lllllllllllllllIlIIIIIIlllllIIII.get(lllllllllllllllIlIIIIIIllllIllll), lllllllllllllllIlIIIIIIllllIllll);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(lllllllllllllllIlIIIIIIllllIllll).append(", expected to find a string")));
    }
    
    public static boolean jsonObjectFieldTypeIsPrimitive(final JsonObject lllllllllllllllIlIIIIIlIIIIIIIlI, final String lllllllllllllllIlIIIIIIlllllllll) {
        return jsonObjectHasNamedField(lllllllllllllllIlIIIIIlIIIIIIIlI, lllllllllllllllIlIIIIIIlllllllll) && lllllllllllllllIlIIIIIlIIIIIIIlI.get(lllllllllllllllIlIIIIIIlllllllll).isJsonPrimitive();
    }
    
    public static String getJsonElementTypeDescription(final JsonElement lllllllllllllllIlIIIIIIlIlllIlll) {
        final String lllllllllllllllIlIIIIIIlIlllIllI = StringUtils.abbreviateMiddle(String.valueOf(lllllllllllllllIlIIIIIIlIlllIlll), "...", 10);
        if (lllllllllllllllIlIIIIIIlIlllIlll == null) {
            return "null (missing)";
        }
        if (lllllllllllllllIlIIIIIIlIlllIlll.isJsonNull()) {
            return "null (json)";
        }
        if (lllllllllllllllIlIIIIIIlIlllIlll.isJsonArray()) {
            return String.valueOf(new StringBuilder("an array (").append(lllllllllllllllIlIIIIIIlIlllIllI).append(")"));
        }
        if (lllllllllllllllIlIIIIIIlIlllIlll.isJsonObject()) {
            return String.valueOf(new StringBuilder("an object (").append(lllllllllllllllIlIIIIIIlIlllIllI).append(")"));
        }
        if (lllllllllllllllIlIIIIIIlIlllIlll.isJsonPrimitive()) {
            final JsonPrimitive lllllllllllllllIlIIIIIIlIlllIlIl = lllllllllllllllIlIIIIIIlIlllIlll.getAsJsonPrimitive();
            if (lllllllllllllllIlIIIIIIlIlllIlIl.isNumber()) {
                return String.valueOf(new StringBuilder("a number (").append(lllllllllllllllIlIIIIIIlIlllIllI).append(")"));
            }
            if (lllllllllllllllIlIIIIIIlIlllIlIl.isBoolean()) {
                return String.valueOf(new StringBuilder("a boolean (").append(lllllllllllllllIlIIIIIIlIlllIllI).append(")"));
            }
        }
        return lllllllllllllllIlIIIIIIlIlllIllI;
    }
    
    public static int getJsonObjectIntegerFieldValueOrDefault(final JsonObject lllllllllllllllIlIIIIIIllIlIIlll, final String lllllllllllllllIlIIIIIIllIlIlIIl, final int lllllllllllllllIlIIIIIIllIlIlIII) {
        return lllllllllllllllIlIIIIIIllIlIIlll.has(lllllllllllllllIlIIIIIIllIlIlIIl) ? getJsonElementIntegerValue(lllllllllllllllIlIIIIIIllIlIIlll.get(lllllllllllllllIlIIIIIIllIlIlIIl), lllllllllllllllIlIIIIIIllIlIlIIl) : lllllllllllllllIlIIIIIIllIlIlIII;
    }
    
    public static JsonObject getJsonObjectFieldOrDefault(final JsonObject lllllllllllllllIlIIIIIIllIIlIlIl, final String lllllllllllllllIlIIIIIIllIIlIIIl, final JsonObject lllllllllllllllIlIIIIIIllIIlIIll) {
        return lllllllllllllllIlIIIIIIllIIlIlIl.has(lllllllllllllllIlIIIIIIllIIlIIIl) ? getElementAsJsonObject(lllllllllllllllIlIIIIIIllIIlIlIl.get(lllllllllllllllIlIIIIIIllIIlIIIl), lllllllllllllllIlIIIIIIllIIlIIIl) : lllllllllllllllIlIIIIIIllIIlIIll;
    }
    
    public static String getJsonElementStringValue(final JsonElement lllllllllllllllIlIIIIIIlllllIllI, final String lllllllllllllllIlIIIIIIlllllIlIl) {
        if (lllllllllllllllIlIIIIIIlllllIllI.isJsonPrimitive()) {
            return lllllllllllllllIlIIIIIIlllllIllI.getAsString();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(lllllllllllllllIlIIIIIIlllllIlIl).append(" to be a string, was ").append(getJsonElementTypeDescription(lllllllllllllllIlIIIIIIlllllIllI))));
    }
    
    public static JsonObject getJsonObject(final JsonObject lllllllllllllllIlIIIIIIllIIllIlI, final String lllllllllllllllIlIIIIIIllIIllIIl) {
        if (lllllllllllllllIlIIIIIIllIIllIlI.has(lllllllllllllllIlIIIIIIllIIllIIl)) {
            return getElementAsJsonObject(lllllllllllllllIlIIIIIIllIIllIlI.get(lllllllllllllllIlIIIIIIllIIllIIl), lllllllllllllllIlIIIIIIllIIllIIl);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(lllllllllllllllIlIIIIIIllIIllIIl).append(", expected to find a JsonObject")));
    }
    
    public static float getJsonElementFloatValue(final JsonElement lllllllllllllllIlIIIIIIlllIIllII, final String lllllllllllllllIlIIIIIIlllIIlIIl) {
        if (lllllllllllllllIlIIIIIIlllIIllII.isJsonPrimitive() && lllllllllllllllIlIIIIIIlllIIllII.getAsJsonPrimitive().isNumber()) {
            return lllllllllllllllIlIIIIIIlllIIllII.getAsFloat();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(lllllllllllllllIlIIIIIIlllIIlIIl).append(" to be a Float, was ").append(getJsonElementTypeDescription(lllllllllllllllIlIIIIIIlllIIllII))));
    }
    
    public static boolean getJsonElementBooleanValue(final JsonElement lllllllllllllllIlIIIIIIlllIlllll, final String lllllllllllllllIlIIIIIIlllIllllI) {
        if (lllllllllllllllIlIIIIIIlllIlllll.isJsonPrimitive()) {
            return lllllllllllllllIlIIIIIIlllIlllll.getAsBoolean();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(lllllllllllllllIlIIIIIIlllIllllI).append(" to be a Boolean, was ").append(getJsonElementTypeDescription(lllllllllllllllIlIIIIIIlllIlllll))));
    }
    
    public static JsonArray getJsonElementAsJsonArray(final JsonElement lllllllllllllllIlIIIIIIllIIIllIl, final String lllllllllllllllIlIIIIIIllIIIlIlI) {
        if (lllllllllllllllIlIIIIIIllIIIllIl.isJsonArray()) {
            return lllllllllllllllIlIIIIIIllIIIllIl.getAsJsonArray();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(lllllllllllllllIlIIIIIIllIIIlIlI).append(" to be a JsonArray, was ").append(getJsonElementTypeDescription(lllllllllllllllIlIIIIIIllIIIllIl))));
    }
    
    public static int getJsonElementIntegerValue(final JsonElement lllllllllllllllIlIIIIIIllIllIlll, final String lllllllllllllllIlIIIIIIllIllIllI) {
        if (lllllllllllllllIlIIIIIIllIllIlll.isJsonPrimitive() && lllllllllllllllIlIIIIIIllIllIlll.getAsJsonPrimitive().isNumber()) {
            return lllllllllllllllIlIIIIIIllIllIlll.getAsInt();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(lllllllllllllllIlIIIIIIllIllIllI).append(" to be a Int, was ").append(getJsonElementTypeDescription(lllllllllllllllIlIIIIIIllIllIlll))));
    }
    
    public static boolean func_180199_c(final JsonObject lllllllllllllllIlIIIIIlIIIIIlllI, final String lllllllllllllllIlIIIIIlIIIIIllIl) {
        return jsonObjectFieldTypeIsPrimitive(lllllllllllllllIlIIIIIlIIIIIlllI, lllllllllllllllIlIIIIIlIIIIIllIl) && lllllllllllllllIlIIIIIlIIIIIlllI.getAsJsonPrimitive(lllllllllllllllIlIIIIIlIIIIIllIl).isBoolean();
    }
    
    public static boolean jsonElementTypeIsString(final JsonElement lllllllllllllllIlIIIIIlIIIIlIIIl) {
        return lllllllllllllllIlIIIIIlIIIIlIIIl.isJsonPrimitive() && lllllllllllllllIlIIIIIlIIIIlIIIl.getAsJsonPrimitive().isString();
    }
    
    public static float getJsonObjectFloatFieldValue(final JsonObject lllllllllllllllIlIIIIIIlllIIIllI, final String lllllllllllllllIlIIIIIIlllIIIlIl) {
        if (lllllllllllllllIlIIIIIIlllIIIllI.has(lllllllllllllllIlIIIIIIlllIIIlIl)) {
            return getJsonElementFloatValue(lllllllllllllllIlIIIIIIlllIIIllI.get(lllllllllllllllIlIIIIIIlllIIIlIl), lllllllllllllllIlIIIIIIlllIIIlIl);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(lllllllllllllllIlIIIIIIlllIIIlIl).append(", expected to find a Float")));
    }
    
    public static JsonArray getJsonObjectJsonArrayFieldOrDefault(final JsonObject lllllllllllllllIlIIIIIIlIlllllIl, final String lllllllllllllllIlIIIIIIlIlllllll, final JsonArray lllllllllllllllIlIIIIIIlIllllIll) {
        return lllllllllllllllIlIIIIIIlIlllllIl.has(lllllllllllllllIlIIIIIIlIlllllll) ? getJsonElementAsJsonArray(lllllllllllllllIlIIIIIIlIlllllIl.get(lllllllllllllllIlIIIIIIlIlllllll), lllllllllllllllIlIIIIIIlIlllllll) : lllllllllllllllIlIIIIIIlIllllIll;
    }
    
    public static JsonObject getElementAsJsonObject(final JsonElement lllllllllllllllIlIIIIIIllIlIIIII, final String lllllllllllllllIlIIIIIIllIIlllll) {
        if (lllllllllllllllIlIIIIIIllIlIIIII.isJsonObject()) {
            return lllllllllllllllIlIIIIIIllIlIIIII.getAsJsonObject();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(lllllllllllllllIlIIIIIIllIIlllll).append(" to be a JsonObject, was ").append(getJsonElementTypeDescription(lllllllllllllllIlIIIIIIllIlIIIII))));
    }
    
    public static int getJsonObjectIntegerFieldValue(final JsonObject lllllllllllllllIlIIIIIIllIlIllll, final String lllllllllllllllIlIIIIIIllIlIlllI) {
        if (lllllllllllllllIlIIIIIIllIlIllll.has(lllllllllllllllIlIIIIIIllIlIlllI)) {
            return getJsonElementIntegerValue(lllllllllllllllIlIIIIIIllIlIllll.get(lllllllllllllllIlIIIIIIllIlIlllI), lllllllllllllllIlIIIIIIllIlIlllI);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(lllllllllllllllIlIIIIIIllIlIlllI).append(", expected to find a Int")));
    }
    
    public static boolean jsonObjectFieldTypeIsArray(final JsonObject lllllllllllllllIlIIIIIlIIIIIIllI, final String lllllllllllllllIlIIIIIlIIIIIIlIl) {
        return jsonObjectHasNamedField(lllllllllllllllIlIIIIIlIIIIIIllI, lllllllllllllllIlIIIIIlIIIIIIlIl) && lllllllllllllllIlIIIIIlIIIIIIllI.get(lllllllllllllllIlIIIIIlIIIIIIlIl).isJsonArray();
    }
    
    static {
        __OBFID = "CL_00001484";
    }
    
    public static boolean jsonObjectFieldTypeIsString(final JsonObject lllllllllllllllIlIIIIIlIIIIlIlll, final String lllllllllllllllIlIIIIIlIIIIlIllI) {
        return jsonObjectFieldTypeIsPrimitive(lllllllllllllllIlIIIIIlIIIIlIlll, lllllllllllllllIlIIIIIlIIIIlIllI) && lllllllllllllllIlIIIIIlIIIIlIlll.getAsJsonPrimitive(lllllllllllllllIlIIIIIlIIIIlIllI).isString();
    }
    
    public static JsonArray getJsonObjectJsonArrayField(final JsonObject lllllllllllllllIlIIIIIIllIIIIlll, final String lllllllllllllllIlIIIIIIllIIIIlII) {
        if (lllllllllllllllIlIIIIIIllIIIIlll.has(lllllllllllllllIlIIIIIIllIIIIlII)) {
            return getJsonElementAsJsonArray(lllllllllllllllIlIIIIIIllIIIIlll.get(lllllllllllllllIlIIIIIIllIIIIlII), lllllllllllllllIlIIIIIIllIIIIlII);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(lllllllllllllllIlIIIIIIllIIIIlII).append(", expected to find a JsonArray")));
    }
    
    public static float getJsonObjectFloatFieldValueOrDefault(final JsonObject lllllllllllllllIlIIIIIIllIllllII, final String lllllllllllllllIlIIIIIIllIlllllI, final float lllllllllllllllIlIIIIIIllIllllIl) {
        return lllllllllllllllIlIIIIIIllIllllII.has(lllllllllllllllIlIIIIIIllIlllllI) ? getJsonElementFloatValue(lllllllllllllllIlIIIIIIllIllllII.get(lllllllllllllllIlIIIIIIllIlllllI), lllllllllllllllIlIIIIIIllIlllllI) : lllllllllllllllIlIIIIIIllIllllIl;
    }
}
