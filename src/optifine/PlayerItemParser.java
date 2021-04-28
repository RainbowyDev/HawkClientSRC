package optifine;

import net.minecraft.util.*;
import java.awt.*;
import com.google.gson.*;
import java.util.*;
import net.minecraft.client.model.*;

public class PlayerItemParser
{
    private static /* synthetic */ JsonParser jsonParser;
    
    private static ResourceLocation makeResourceLocation(final String llllllllllllllIllIllIllIIIlllIlI) {
        final int llllllllllllllIllIllIllIIIllllIl = llllllllllllllIllIllIllIIIlllIlI.indexOf(58);
        if (llllllllllllllIllIllIllIIIllllIl < 0) {
            return new ResourceLocation(llllllllllllllIllIllIllIIIlllIlI);
        }
        final String llllllllllllllIllIllIllIIIllllII = llllllllllllllIllIllIllIIIlllIlI.substring(0, llllllllllllllIllIllIllIIIllllIl);
        final String llllllllllllllIllIllIllIIIlllIll = llllllllllllllIllIllIllIIIlllIlI.substring(llllllllllllllIllIllIllIIIllllIl + 1);
        return new ResourceLocation(llllllllllllllIllIllIllIIIllllII, llllllllllllllIllIllIllIIIlllIll);
    }
    
    public static PlayerItemModel parseItemModel(final JsonObject llllllllllllllIllIllIllIIllIlIIl) {
        final String llllllllllllllIllIllIllIIllIlIII = Json.getString(llllllllllllllIllIllIllIIllIlIIl, "type");
        if (!Config.equals(llllllllllllllIllIllIllIIllIlIII, "PlayerItem")) {
            throw new JsonParseException(String.valueOf(new StringBuilder("Unknown model type: ").append(llllllllllllllIllIllIllIIllIlIII)));
        }
        final int[] llllllllllllllIllIllIllIIllIIlll = Json.parseIntArray(llllllllllllllIllIllIllIIllIlIIl.get("textureSize"), 2);
        checkNull(llllllllllllllIllIllIllIIllIIlll, "Missing texture size");
        final Dimension llllllllllllllIllIllIllIIllIIllI = new Dimension(llllllllllllllIllIllIllIIllIIlll[0], llllllllllllllIllIllIllIIllIIlll[1]);
        final boolean llllllllllllllIllIllIllIIllIIlIl = Json.getBoolean(llllllllllllllIllIllIllIIllIlIIl, "usePlayerTexture", false);
        final JsonArray llllllllllllllIllIllIllIIllIIlII = (JsonArray)llllllllllllllIllIllIllIIllIlIIl.get("models");
        checkNull(llllllllllllllIllIllIllIIllIIlII, "Missing elements");
        final HashMap llllllllllllllIllIllIllIIllIIIll = new HashMap();
        final ArrayList llllllllllllllIllIllIllIIllIIIlI = new ArrayList();
        new ArrayList();
        for (int llllllllllllllIllIllIllIIllIIIIl = 0; llllllllllllllIllIllIllIIllIIIIl < llllllllllllllIllIllIllIIllIIlII.size(); ++llllllllllllllIllIllIllIIllIIIIl) {
            final JsonObject llllllllllllllIllIllIllIIllIIIII = (JsonObject)llllllllllllllIllIllIllIIllIIlII.get(llllllllllllllIllIllIllIIllIIIIl);
            final String llllllllllllllIllIllIllIIlIlllll = Json.getString(llllllllllllllIllIllIllIIllIIIII, "baseId");
            if (llllllllllllllIllIllIllIIlIlllll != null) {
                final JsonObject llllllllllllllIllIllIllIIlIllllI = llllllllllllllIllIllIllIIllIIIll.get(llllllllllllllIllIllIllIIlIlllll);
                if (llllllllllllllIllIllIllIIlIllllI == null) {
                    Config.warn(String.valueOf(new StringBuilder("BaseID not found: ").append(llllllllllllllIllIllIllIIlIlllll)));
                    continue;
                }
                final Set llllllllllllllIllIllIllIIlIlllIl = llllllllllllllIllIllIllIIlIllllI.entrySet();
                for (final Map.Entry llllllllllllllIllIllIllIIlIllIll : llllllllllllllIllIllIllIIlIlllIl) {
                    if (!llllllllllllllIllIllIllIIllIIIII.has((String)llllllllllllllIllIllIllIIlIllIll.getKey())) {
                        llllllllllllllIllIllIllIIllIIIII.add((String)llllllllllllllIllIllIllIIlIllIll.getKey(), (JsonElement)llllllllllllllIllIllIllIIlIllIll.getValue());
                    }
                }
            }
            final String llllllllllllllIllIllIllIIlIllIlI = Json.getString(llllllllllllllIllIllIllIIllIIIII, "id");
            if (llllllllllllllIllIllIllIIlIllIlI != null) {
                if (!llllllllllllllIllIllIllIIllIIIll.containsKey(llllllllllllllIllIllIllIIlIllIlI)) {
                    llllllllllllllIllIllIllIIllIIIll.put(llllllllllllllIllIllIllIIlIllIlI, llllllllllllllIllIllIllIIllIIIII);
                }
                else {
                    Config.warn(String.valueOf(new StringBuilder("Duplicate model ID: ").append(llllllllllllllIllIllIllIIlIllIlI)));
                }
            }
            final PlayerItemRenderer llllllllllllllIllIllIllIIlIllIIl = parseItemRenderer(llllllllllllllIllIllIllIIllIIIII, llllllllllllllIllIllIllIIllIIllI);
            if (llllllllllllllIllIllIllIIlIllIIl != null) {
                llllllllllllllIllIllIllIIllIIIlI.add(llllllllllllllIllIllIllIIlIllIIl);
            }
        }
        final PlayerItemRenderer[] llllllllllllllIllIllIllIIlIllIII = llllllllllllllIllIllIllIIllIIIlI.toArray(new PlayerItemRenderer[llllllllllllllIllIllIllIIllIIIlI.size()]);
        return new PlayerItemModel(llllllllllllllIllIllIllIIllIIllI, llllllllllllllIllIllIllIIllIIlIl, llllllllllllllIllIllIllIIlIllIII);
    }
    
    private static PlayerItemRenderer parseItemRenderer(final JsonObject llllllllllllllIllIllIllIIIlIIIIl, final Dimension llllllllllllllIllIllIllIIIlIIIII) {
        final String llllllllllllllIllIllIllIIIlIlIII = Json.getString(llllllllllllllIllIllIllIIIlIIIIl, "type");
        if (!Config.equals(llllllllllllllIllIllIllIIIlIlIII, "ModelBox")) {
            Config.warn(String.valueOf(new StringBuilder("Unknown model type: ").append(llllllllllllllIllIllIllIIIlIlIII)));
            return null;
        }
        final String llllllllllllllIllIllIllIIIlIIlll = Json.getString(llllllllllllllIllIllIllIIIlIIIIl, "attachTo");
        final int llllllllllllllIllIllIllIIIlIIllI = parseAttachModel(llllllllllllllIllIllIllIIIlIIlll);
        final float llllllllllllllIllIllIllIIIlIIlIl = Json.getFloat(llllllllllllllIllIllIllIIIlIIIIl, "scale", 1.0f);
        final ModelPlayerItem llllllllllllllIllIllIllIIIlIIlII = new ModelPlayerItem();
        llllllllllllllIllIllIllIIIlIIlII.textureWidth = llllllllllllllIllIllIllIIIlIIIII.width;
        llllllllllllllIllIllIllIIIlIIlII.textureHeight = llllllllllllllIllIllIllIIIlIIIII.height;
        final ModelRenderer llllllllllllllIllIllIllIIIlIIIll = parseModelRenderer(llllllllllllllIllIllIllIIIlIIIIl, llllllllllllllIllIllIllIIIlIIlII);
        final PlayerItemRenderer llllllllllllllIllIllIllIIIlIIIlI = new PlayerItemRenderer(llllllllllllllIllIllIllIIIlIIllI, llllllllllllllIllIllIllIIIlIIlIl, llllllllllllllIllIllIllIIIlIIIll);
        return llllllllllllllIllIllIllIIIlIIIlI;
    }
    
    static {
        MODEL_SPRITES = "sprites";
        MODEL_BOXES = "boxes";
        ITEM_TYPE_MODEL = "PlayerItem";
        MODEL_TYPE_BOX = "ModelBox";
        ITEM_TYPE = "type";
        ITEM_TEXTURE_SIZE = "textureSize";
        MODEL_ROTATE = "rotate";
        MODEL_SUBMODEL = "submodel";
        ITEM_MODELS = "models";
        MODEL_ATTACH_TO = "attachTo";
        MODEL_BASE_ID = "baseId";
        MODEL_TRANSLATE = "translate";
        MODEL_SCALE = "scale";
        MODEL_MIRROR_TEXTURE = "mirrorTexture";
        MODEL_SUBMODELS = "submodels";
        ITEM_USE_PLAYER_TEXTURE = "usePlayerTexture";
        MODEL_ID = "id";
        MODEL_TYPE = "type";
        BOX_SIZE_ADD = "sizeAdd";
        MODEL_INVERT_AXIS = "invertAxis";
        BOX_COORDINATES = "coordinates";
        BOX_TEXTURE_OFFSET = "textureOffset";
        PlayerItemParser.jsonParser = new JsonParser();
    }
    
    private static ModelRenderer parseModelRenderer(final JsonObject llllllllllllllIllIllIlIllllIIlIl, final ModelBase llllllllllllllIllIllIlIllllIIlII) {
        final ModelRenderer llllllllllllllIllIllIllIIIIIIIlI = new ModelRenderer(llllllllllllllIllIllIlIllllIIlII);
        final String llllllllllllllIllIllIllIIIIIIIIl = Json.getString(llllllllllllllIllIllIlIllllIIlIl, "invertAxis", "").toLowerCase();
        final boolean llllllllllllllIllIllIllIIIIIIIII = llllllllllllllIllIllIllIIIIIIIIl.contains("x");
        final boolean llllllllllllllIllIllIlIlllllllll = llllllllllllllIllIllIllIIIIIIIIl.contains("y");
        final boolean llllllllllllllIllIllIlIllllllllI = llllllllllllllIllIllIllIIIIIIIIl.contains("z");
        final float[] llllllllllllllIllIllIlIlllllllIl = Json.parseFloatArray(llllllllllllllIllIllIlIllllIIlIl.get("translate"), 3, new float[3]);
        if (llllllllllllllIllIllIllIIIIIIIII) {
            llllllllllllllIllIllIlIlllllllIl[0] = -llllllllllllllIllIllIlIlllllllIl[0];
        }
        if (llllllllllllllIllIllIlIlllllllll) {
            llllllllllllllIllIllIlIlllllllIl[1] = -llllllllllllllIllIllIlIlllllllIl[1];
        }
        if (llllllllllllllIllIllIlIllllllllI) {
            llllllllllllllIllIllIlIlllllllIl[2] = -llllllllllllllIllIllIlIlllllllIl[2];
        }
        final float[] llllllllllllllIllIllIlIlllllllII = Json.parseFloatArray(llllllllllllllIllIllIlIllllIIlIl.get("rotate"), 3, new float[3]);
        for (int llllllllllllllIllIllIlIllllllIll = 0; llllllllllllllIllIllIlIllllllIll < llllllllllllllIllIllIlIlllllllII.length; ++llllllllllllllIllIllIlIllllllIll) {
            llllllllllllllIllIllIlIlllllllII[llllllllllllllIllIllIlIllllllIll] = llllllllllllllIllIllIlIlllllllII[llllllllllllllIllIllIlIllllllIll] / 180.0f * 3.1415927f;
        }
        if (llllllllllllllIllIllIllIIIIIIIII) {
            llllllllllllllIllIllIlIlllllllII[0] = -llllllllllllllIllIllIlIlllllllII[0];
        }
        if (llllllllllllllIllIllIlIlllllllll) {
            llllllllllllllIllIllIlIlllllllII[1] = -llllllllllllllIllIllIlIlllllllII[1];
        }
        if (llllllllllllllIllIllIlIllllllllI) {
            llllllllllllllIllIllIlIlllllllII[2] = -llllllllllllllIllIllIlIlllllllII[2];
        }
        llllllllllllllIllIllIllIIIIIIIlI.setRotationPoint(llllllllllllllIllIllIlIlllllllIl[0], llllllllllllllIllIllIlIlllllllIl[1], llllllllllllllIllIllIlIlllllllIl[2]);
        llllllllllllllIllIllIllIIIIIIIlI.rotateAngleX = llllllllllllllIllIllIlIlllllllII[0];
        llllllllllllllIllIllIllIIIIIIIlI.rotateAngleY = llllllllllllllIllIllIlIlllllllII[1];
        llllllllllllllIllIllIllIIIIIIIlI.rotateAngleZ = llllllllllllllIllIllIlIlllllllII[2];
        final String llllllllllllllIllIllIlIllllllIlI = Json.getString(llllllllllllllIllIllIlIllllIIlIl, "mirrorTexture", "").toLowerCase();
        final boolean llllllllllllllIllIllIlIllllllIIl = llllllllllllllIllIllIlIllllllIlI.contains("u");
        final boolean llllllllllllllIllIllIlIllllllIII = llllllllllllllIllIllIlIllllllIlI.contains("v");
        if (llllllllllllllIllIllIlIllllllIIl) {
            llllllllllllllIllIllIllIIIIIIIlI.mirror = true;
        }
        if (llllllllllllllIllIllIlIllllllIII) {
            llllllllllllllIllIllIllIIIIIIIlI.mirrorV = true;
        }
        final JsonArray llllllllllllllIllIllIlIlllllIlll = llllllllllllllIllIllIlIllllIIlIl.getAsJsonArray("boxes");
        if (llllllllllllllIllIllIlIlllllIlll != null) {
            for (int llllllllllllllIllIllIlIlllllIlII = 0; llllllllllllllIllIllIlIlllllIlII < llllllllllllllIllIllIlIlllllIlll.size(); ++llllllllllllllIllIllIlIlllllIlII) {
                final JsonObject llllllllllllllIllIllIlIlllllIllI = llllllllllllllIllIllIlIlllllIlll.get(llllllllllllllIllIllIlIlllllIlII).getAsJsonObject();
                final int[] llllllllllllllIllIllIlIlllllIIll = Json.parseIntArray(llllllllllllllIllIllIlIlllllIllI.get("textureOffset"), 2);
                if (llllllllllllllIllIllIlIlllllIIll == null) {
                    throw new JsonParseException("Texture offset not specified");
                }
                final float[] llllllllllllllIllIllIlIlllllIIlI = Json.parseFloatArray(llllllllllllllIllIllIlIlllllIllI.get("coordinates"), 6);
                if (llllllllllllllIllIllIlIlllllIIlI == null) {
                    throw new JsonParseException("Coordinates not specified");
                }
                if (llllllllllllllIllIllIllIIIIIIIII) {
                    llllllllllllllIllIllIlIlllllIIlI[0] = -llllllllllllllIllIllIlIlllllIIlI[0] - llllllllllllllIllIllIlIlllllIIlI[3];
                }
                if (llllllllllllllIllIllIlIlllllllll) {
                    llllllllllllllIllIllIlIlllllIIlI[1] = -llllllllllllllIllIllIlIlllllIIlI[1] - llllllllllllllIllIllIlIlllllIIlI[4];
                }
                if (llllllllllllllIllIllIlIllllllllI) {
                    llllllllllllllIllIllIlIlllllIIlI[2] = -llllllllllllllIllIllIlIlllllIIlI[2] - llllllllllllllIllIllIlIlllllIIlI[5];
                }
                final float llllllllllllllIllIllIlIlllllIIIl = Json.getFloat(llllllllllllllIllIllIlIlllllIllI, "sizeAdd", 0.0f);
                llllllllllllllIllIllIllIIIIIIIlI.setTextureOffset(llllllllllllllIllIllIlIlllllIIll[0], llllllllllllllIllIllIlIlllllIIll[1]);
                llllllllllllllIllIllIllIIIIIIIlI.addBox(llllllllllllllIllIllIlIlllllIIlI[0], llllllllllllllIllIllIlIlllllIIlI[1], llllllllllllllIllIllIlIlllllIIlI[2], (int)llllllllllllllIllIllIlIlllllIIlI[3], (int)llllllllllllllIllIllIlIlllllIIlI[4], (int)llllllllllllllIllIllIlIlllllIIlI[5], llllllllllllllIllIllIlIlllllIIIl);
            }
        }
        final JsonArray llllllllllllllIllIllIlIlllllIIII = llllllllllllllIllIllIlIllllIIlIl.getAsJsonArray("sprites");
        if (llllllllllllllIllIllIlIlllllIIII != null) {
            for (int llllllllllllllIllIllIlIllllIllll = 0; llllllllllllllIllIllIlIllllIllll < llllllllllllllIllIllIlIlllllIIII.size(); ++llllllllllllllIllIllIlIllllIllll) {
                final JsonObject llllllllllllllIllIllIlIllllIlllI = llllllllllllllIllIllIlIlllllIIII.get(llllllllllllllIllIllIlIllllIllll).getAsJsonObject();
                final int[] llllllllllllllIllIllIlIllllIllIl = Json.parseIntArray(llllllllllllllIllIllIlIllllIlllI.get("textureOffset"), 2);
                if (llllllllllllllIllIllIlIllllIllIl == null) {
                    throw new JsonParseException("Texture offset not specified");
                }
                final float[] llllllllllllllIllIllIlIllllIllII = Json.parseFloatArray(llllllllllllllIllIllIlIllllIlllI.get("coordinates"), 6);
                if (llllllllllllllIllIllIlIllllIllII == null) {
                    throw new JsonParseException("Coordinates not specified");
                }
                if (llllllllllllllIllIllIllIIIIIIIII) {
                    llllllllllllllIllIllIlIllllIllII[0] = -llllllllllllllIllIllIlIllllIllII[0] - llllllllllllllIllIllIlIllllIllII[3];
                }
                if (llllllllllllllIllIllIlIlllllllll) {
                    llllllllllllllIllIllIlIllllIllII[1] = -llllllllllllllIllIllIlIllllIllII[1] - llllllllllllllIllIllIlIllllIllII[4];
                }
                if (llllllllllllllIllIllIlIllllllllI) {
                    llllllllllllllIllIllIlIllllIllII[2] = -llllllllllllllIllIllIlIllllIllII[2] - llllllllllllllIllIllIlIllllIllII[5];
                }
                final float llllllllllllllIllIllIlIllllIlIll = Json.getFloat(llllllllllllllIllIllIlIllllIlllI, "sizeAdd", 0.0f);
                llllllllllllllIllIllIllIIIIIIIlI.setTextureOffset(llllllllllllllIllIllIlIllllIllIl[0], llllllllllllllIllIllIlIllllIllIl[1]);
                llllllllllllllIllIllIllIIIIIIIlI.addSprite(llllllllllllllIllIllIlIllllIllII[0], llllllllllllllIllIllIlIllllIllII[1], llllllllllllllIllIllIlIllllIllII[2], (int)llllllllllllllIllIllIlIllllIllII[3], (int)llllllllllllllIllIllIlIllllIllII[4], (int)llllllllllllllIllIllIlIllllIllII[5], llllllllllllllIllIllIlIllllIlIll);
            }
        }
        final JsonObject llllllllllllllIllIllIlIlllllIlIl = (JsonObject)llllllllllllllIllIllIlIllllIIlIl.get("submodel");
        if (llllllllllllllIllIllIlIlllllIlIl != null) {
            final ModelRenderer llllllllllllllIllIllIlIllllIlIlI = parseModelRenderer(llllllllllllllIllIllIlIlllllIlIl, llllllllllllllIllIllIlIllllIIlII);
            llllllllllllllIllIllIllIIIIIIIlI.addChild(llllllllllllllIllIllIlIllllIlIlI);
        }
        final JsonArray llllllllllllllIllIllIlIllllIlIIl = (JsonArray)llllllllllllllIllIllIlIllllIIlIl.get("submodels");
        if (llllllllllllllIllIllIlIllllIlIIl != null) {
            for (int llllllllllllllIllIllIlIllllIlIII = 0; llllllllllllllIllIllIlIllllIlIII < llllllllllllllIllIllIlIllllIlIIl.size(); ++llllllllllllllIllIllIlIllllIlIII) {
                final JsonObject llllllllllllllIllIllIlIllllIIlll = (JsonObject)llllllllllllllIllIllIlIllllIlIIl.get(llllllllllllllIllIllIlIllllIlIII);
                final ModelRenderer llllllllllllllIllIllIlIllllIIllI = parseModelRenderer(llllllllllllllIllIllIlIllllIIlll, llllllllllllllIllIllIlIllllIIlII);
                llllllllllllllIllIllIllIIIIIIIlI.addChild(llllllllllllllIllIllIlIllllIIllI);
            }
        }
        return llllllllllllllIllIllIllIIIIIIIlI;
    }
    
    private static int parseAttachModel(final String llllllllllllllIllIllIllIIIllIlII) {
        if (llllllllllllllIllIllIllIIIllIlII == null) {
            return 0;
        }
        if (llllllllllllllIllIllIllIIIllIlII.equals("body")) {
            return 0;
        }
        if (llllllllllllllIllIllIllIIIllIlII.equals("head")) {
            return 1;
        }
        if (llllllllllllllIllIllIllIIIllIlII.equals("leftArm")) {
            return 2;
        }
        if (llllllllllllllIllIllIllIIIllIlII.equals("rightArm")) {
            return 3;
        }
        if (llllllllllllllIllIllIllIIIllIlII.equals("leftLeg")) {
            return 4;
        }
        if (llllllllllllllIllIllIllIIIllIlII.equals("rightLeg")) {
            return 5;
        }
        if (llllllllllllllIllIllIllIIIllIlII.equals("cape")) {
            return 6;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown attachModel: ").append(llllllllllllllIllIllIllIIIllIlII)));
        return 0;
    }
    
    private static void checkNull(final Object llllllllllllllIllIllIllIIlIIIllI, final String llllllllllllllIllIllIllIIlIIIIll) {
        if (llllllllllllllIllIllIllIIlIIIllI == null) {
            throw new JsonParseException(llllllllllllllIllIllIllIIlIIIIll);
        }
    }
}
