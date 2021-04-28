package net.minecraft.client.renderer.block.model;

import org.apache.logging.log4j.*;
import java.lang.reflect.*;
import java.io.*;
import org.apache.commons.lang3.*;
import net.minecraft.util.*;
import com.google.gson.*;
import com.google.common.collect.*;
import java.util.*;

public class ModelBlock
{
    private static final /* synthetic */ Logger LOGGER;
    static final /* synthetic */ Gson SERIALIZER;
    protected /* synthetic */ ModelBlock parent;
    public /* synthetic */ String field_178317_b;
    private /* synthetic */ ItemCameraTransforms itemCameraTransforms;
    private final /* synthetic */ boolean ambientOcclusion;
    private final /* synthetic */ List elements;
    private final /* synthetic */ boolean field_178322_i;
    protected /* synthetic */ ResourceLocation parentLocation;
    protected final /* synthetic */ Map textures;
    
    static {
        __OBFID = "CL_00002503";
        LOGGER = LogManager.getLogger();
        SERIALIZER = new GsonBuilder().registerTypeAdapter((Type)ModelBlock.class, (Object)new Deserializer()).registerTypeAdapter((Type)BlockPart.class, (Object)new BlockPart.Deserializer()).registerTypeAdapter((Type)BlockPartFace.class, (Object)new BlockPartFace.Deserializer()).registerTypeAdapter((Type)BlockFaceUV.class, (Object)new BlockFaceUV.Deserializer()).registerTypeAdapter((Type)ItemTransformVec3f.class, (Object)new ItemTransformVec3f.Deserializer()).registerTypeAdapter((Type)ItemCameraTransforms.class, (Object)new ItemCameraTransforms.Deserializer()).create();
    }
    
    public boolean func_178309_b() {
        return this.hasParent() ? this.parent.func_178309_b() : this.field_178322_i;
    }
    
    private boolean hasParent() {
        return this.parent != null;
    }
    
    public ItemTransformVec3f getInGuiTransform() {
        return (this.parent != null && this.itemCameraTransforms.field_178354_e == ItemTransformVec3f.field_178366_a) ? this.parent.getInGuiTransform() : this.itemCameraTransforms.field_178354_e;
    }
    
    public ItemTransformVec3f getFirstPersonTransform() {
        return (this.parent != null && this.itemCameraTransforms.field_178356_c == ItemTransformVec3f.field_178366_a) ? this.parent.getFirstPersonTransform() : this.itemCameraTransforms.field_178356_c;
    }
    
    protected ModelBlock(final ResourceLocation llllllllllllllIlIlIIlIlIlllIIIll, final Map llllllllllllllIlIlIIlIlIllIlllII, final boolean llllllllllllllIlIlIIlIlIllIllIll, final boolean llllllllllllllIlIlIIlIlIllIllIlI, final ItemCameraTransforms llllllllllllllIlIlIIlIlIllIlllll) {
        this(llllllllllllllIlIlIIlIlIlllIIIll, Collections.emptyList(), llllllllllllllIlIlIIlIlIllIlllII, llllllllllllllIlIlIIlIlIllIllIll, llllllllllllllIlIlIIlIlIllIllIlI, llllllllllllllIlIlIIlIlIllIlllll);
    }
    
    public void getParentFromMap(final Map llllllllllllllIlIlIIlIlIlIIIlllI) {
        if (this.parentLocation != null) {
            this.parent = llllllllllllllIlIlIIlIlIlIIIlllI.get(this.parentLocation);
        }
    }
    
    public boolean isResolved() {
        return this.parentLocation == null || (this.parent != null && this.parent.isResolved());
    }
    
    public ModelBlock getRootModel() {
        return this.hasParent() ? this.parent.getRootModel() : this;
    }
    
    public String resolveTextureName(String llllllllllllllIlIlIIlIlIIlllIIlI) {
        if (!this.isTextureName((String)llllllllllllllIlIlIIlIlIIlllIIlI)) {
            llllllllllllllIlIlIIlIlIIlllIIlI = String.valueOf(new StringBuilder(String.valueOf('#')).append((String)llllllllllllllIlIlIIlIlIIlllIIlI));
        }
        return this.resolveTextureName((String)llllllllllllllIlIlIIlIlIIlllIIlI, new Bookkeep(null));
    }
    
    public ItemTransformVec3f getThirdPersonTransform() {
        return (this.parent != null && this.itemCameraTransforms.field_178355_b == ItemTransformVec3f.field_178366_a) ? this.parent.getThirdPersonTransform() : this.itemCameraTransforms.field_178355_b;
    }
    
    public List getElements() {
        return this.hasParent() ? this.parent.getElements() : this.elements;
    }
    
    public static ModelBlock deserialize(final Reader llllllllllllllIlIlIIlIllIIIIIIIl) {
        return (ModelBlock)ModelBlock.SERIALIZER.fromJson(llllllllllllllIlIlIIlIllIIIIIIIl, (Class)ModelBlock.class);
    }
    
    private boolean isTextureName(final String llllllllllllllIlIlIIlIlIIlIlIIII) {
        return llllllllllllllIlIlIIlIlIIlIlIIII.charAt(0) == '#';
    }
    
    private ModelBlock(final ResourceLocation llllllllllllllIlIlIIlIlIlIlllIlI, final List llllllllllllllIlIlIIlIlIllIIIlll, final Map llllllllllllllIlIlIIlIlIlIlllIII, final boolean llllllllllllllIlIlIIlIlIlIllIllI, final boolean llllllllllllllIlIlIIlIlIllIIIIIl, final ItemCameraTransforms llllllllllllllIlIlIIlIlIllIIIIII) {
        this.field_178317_b = "";
        this.elements = llllllllllllllIlIlIIlIlIllIIIlll;
        this.field_178322_i = llllllllllllllIlIlIIlIlIlIllIllI;
        this.ambientOcclusion = llllllllllllllIlIlIIlIlIllIIIIIl;
        this.textures = llllllllllllllIlIlIIlIlIlIlllIII;
        this.parentLocation = llllllllllllllIlIlIIlIlIlIlllIlI;
        this.itemCameraTransforms = llllllllllllllIlIlIIlIlIllIIIIII;
    }
    
    public ItemTransformVec3f getHeadTransform() {
        return (this.parent != null && this.itemCameraTransforms.field_178353_d == ItemTransformVec3f.field_178366_a) ? this.parent.getHeadTransform() : this.itemCameraTransforms.field_178353_d;
    }
    
    public static void func_178312_b(final Map llllllllllllllIlIlIIlIlIIIllIIlI) {
        for (final ModelBlock llllllllllllllIlIlIIlIlIIIllIlIl : llllllllllllllIlIlIIlIlIIIllIIlI.values()) {
            try {
                for (ModelBlock llllllllllllllIlIlIIlIlIIIllIlII = llllllllllllllIlIlIIlIlIIIllIlIl.parent, llllllllllllllIlIlIIlIlIIIllIIll = llllllllllllllIlIlIIlIlIIIllIlII.parent; llllllllllllllIlIlIIlIlIIIllIlII != llllllllllllllIlIlIIlIlIIIllIIll; llllllllllllllIlIlIIlIlIIIllIlII = llllllllllllllIlIlIIlIlIIIllIlII.parent, llllllllllllllIlIlIIlIlIIIllIIll = llllllllllllllIlIlIIlIlIIIllIIll.parent.parent) {}
                throw new LoopException();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    public boolean isAmbientOcclusionEnabled() {
        return this.ambientOcclusion;
    }
    
    public ResourceLocation getParentLocation() {
        return this.parentLocation;
    }
    
    public static ModelBlock deserialize(final String llllllllllllllIlIlIIlIlIllllllIl) {
        return deserialize(new StringReader(llllllllllllllIlIlIIlIlIllllllIl));
    }
    
    private String resolveTextureName(final String llllllllllllllIlIlIIlIlIIllIIIIl, final Bookkeep llllllllllllllIlIlIIlIlIIlIllIIl) {
        if (!this.isTextureName(llllllllllllllIlIlIIlIlIIllIIIIl)) {
            return llllllllllllllIlIlIIlIlIIllIIIIl;
        }
        if (this == llllllllllllllIlIlIIlIlIIlIllIIl.field_178323_b) {
            ModelBlock.LOGGER.warn(String.valueOf(new StringBuilder("Unable to resolve texture due to upward reference: ").append(llllllllllllllIlIlIIlIlIIllIIIIl).append(" in ").append(this.field_178317_b)));
            return "missingno";
        }
        String llllllllllllllIlIlIIlIlIIlIlllIl = this.textures.get(llllllllllllllIlIlIIlIlIIllIIIIl.substring(1));
        if (llllllllllllllIlIlIIlIlIIlIlllIl == null && this.hasParent()) {
            llllllllllllllIlIlIIlIlIIlIlllIl = this.parent.resolveTextureName(llllllllllllllIlIlIIlIlIIllIIIIl, llllllllllllllIlIlIIlIlIIlIllIIl);
        }
        llllllllllllllIlIlIIlIlIIlIllIIl.field_178323_b = this;
        if (llllllllllllllIlIlIIlIlIIlIlllIl != null && this.isTextureName(llllllllllllllIlIlIIlIlIIlIlllIl)) {
            llllllllllllllIlIlIIlIlIIlIlllIl = llllllllllllllIlIlIIlIlIIlIllIIl.model.resolveTextureName(llllllllllllllIlIlIIlIlIIlIlllIl, llllllllllllllIlIlIIlIlIIlIllIIl);
        }
        return (llllllllllllllIlIlIIlIlIIlIlllIl != null && !this.isTextureName(llllllllllllllIlIlIIlIlIIlIlllIl)) ? llllllllllllllIlIlIIlIlIIlIlllIl : "missingno";
    }
    
    public boolean isTexturePresent(final String llllllllllllllIlIlIIlIlIlIIIIlll) {
        return !"missingno".equals(this.resolveTextureName(llllllllllllllIlIlIIlIlIlIIIIlll));
    }
    
    protected ModelBlock(final List llllllllllllllIlIlIIlIlIlllIllll, final Map llllllllllllllIlIlIIlIlIlllIlllI, final boolean llllllllllllllIlIlIIlIlIllllIIll, final boolean llllllllllllllIlIlIIlIlIlllIllII, final ItemCameraTransforms llllllllllllllIlIlIIlIlIlllIlIll) {
        this(null, llllllllllllllIlIlIIlIlIlllIllll, llllllllllllllIlIlIIlIlIlllIlllI, llllllllllllllIlIlIIlIlIllllIIll, llllllllllllllIlIlIIlIlIlllIllII, llllllllllllllIlIlIIlIlIlllIlIll);
    }
    
    public static class LoopException extends RuntimeException
    {
        static {
            __OBFID = "CL_00002499";
        }
    }
    
    final class Bookkeep
    {
        public final /* synthetic */ ModelBlock model;
        public /* synthetic */ ModelBlock field_178323_b;
        
        private Bookkeep() {
        }
        
        Bookkeep(final ModelBlock llllllllllllllllIlIIIlIIIlIlIIII, final Object llllllllllllllllIlIIIlIIIlIlIIlI) {
            this(llllllllllllllllIlIIIlIIIlIlIIII);
        }
        
        static {
            __OBFID = "CL_00002501";
        }
    }
    
    public static class Deserializer implements JsonDeserializer
    {
        public ModelBlock func_178327_a(final JsonElement llllllllllllllIlllllllIlIIlIIlIl, final Type llllllllllllllIlllllllIlIIllIIIl, final JsonDeserializationContext llllllllllllllIlllllllIlIIlIIlII) {
            final JsonObject llllllllllllllIlllllllIlIIlIllll = llllllllllllllIlllllllIlIIlIIlIl.getAsJsonObject();
            final List llllllllllllllIlllllllIlIIlIlllI = this.getModelElements(llllllllllllllIlllllllIlIIlIIlII, llllllllllllllIlllllllIlIIlIllll);
            final String llllllllllllllIlllllllIlIIlIllIl = this.getParent(llllllllllllllIlllllllIlIIlIllll);
            final boolean llllllllllllllIlllllllIlIIlIllII = StringUtils.isEmpty((CharSequence)llllllllllllllIlllllllIlIIlIllIl);
            final boolean llllllllllllllIlllllllIlIIlIlIll = llllllllllllllIlllllllIlIIlIlllI.isEmpty();
            if (llllllllllllllIlllllllIlIIlIlIll && llllllllllllllIlllllllIlIIlIllII) {
                throw new JsonParseException("BlockModel requires either elements or parent, found neither");
            }
            if (!llllllllllllllIlllllllIlIIlIllII && !llllllllllllllIlllllllIlIIlIlIll) {
                throw new JsonParseException("BlockModel requires either elements or parent, found both");
            }
            final Map llllllllllllllIlllllllIlIIlIlIlI = this.getTextures(llllllllllllllIlllllllIlIIlIllll);
            final boolean llllllllllllllIlllllllIlIIlIlIIl = this.getAmbientOcclusionEnabled(llllllllllllllIlllllllIlIIlIllll);
            ItemCameraTransforms llllllllllllllIlllllllIlIIlIlIII = ItemCameraTransforms.field_178357_a;
            if (llllllllllllllIlllllllIlIIlIllll.has("display")) {
                final JsonObject llllllllllllllIlllllllIlIIlIIlll = JsonUtils.getJsonObject(llllllllllllllIlllllllIlIIlIllll, "display");
                llllllllllllllIlllllllIlIIlIlIII = (ItemCameraTransforms)llllllllllllllIlllllllIlIIlIIlII.deserialize((JsonElement)llllllllllllllIlllllllIlIIlIIlll, (Type)ItemCameraTransforms.class);
            }
            return llllllllllllllIlllllllIlIIlIlIll ? new ModelBlock(new ResourceLocation(llllllllllllllIlllllllIlIIlIllIl), llllllllllllllIlllllllIlIIlIlIlI, llllllllllllllIlllllllIlIIlIlIIl, true, llllllllllllllIlllllllIlIIlIlIII) : new ModelBlock(llllllllllllllIlllllllIlIIlIlllI, llllllllllllllIlllllllIlIIlIlIlI, llllllllllllllIlllllllIlIIlIlIIl, true, llllllllllllllIlllllllIlIIlIlIII);
        }
        
        static {
            __OBFID = "CL_00002500";
        }
        
        protected List getModelElements(final JsonDeserializationContext llllllllllllllIlllllllIIllllllII, final JsonObject llllllllllllllIlllllllIIlllllIll) {
            final ArrayList llllllllllllllIlllllllIIlllllIlI = Lists.newArrayList();
            if (llllllllllllllIlllllllIIlllllIll.has("elements")) {
                for (final JsonElement llllllllllllllIlllllllIIlllllIII : JsonUtils.getJsonObjectJsonArrayField(llllllllllllllIlllllllIIlllllIll, "elements")) {
                    llllllllllllllIlllllllIIlllllIlI.add(llllllllllllllIlllllllIIllllllII.deserialize(llllllllllllllIlllllllIIlllllIII, (Type)BlockPart.class));
                }
            }
            return llllllllllllllIlllllllIIlllllIlI;
        }
        
        public Object deserialize(final JsonElement llllllllllllllIlllllllIIlllIllIl, final Type llllllllllllllIlllllllIIlllIllII, final JsonDeserializationContext llllllllllllllIlllllllIIlllIIlll) {
            return this.func_178327_a(llllllllllllllIlllllllIIlllIllIl, llllllllllllllIlllllllIIlllIllII, llllllllllllllIlllllllIIlllIIlll);
        }
        
        protected boolean getAmbientOcclusionEnabled(final JsonObject llllllllllllllIlllllllIlIIIIIlII) {
            return JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllIlllllllIlIIIIIlII, "ambientocclusion", true);
        }
        
        private Map getTextures(final JsonObject llllllllllllllIlllllllIlIIIlIlII) {
            final HashMap llllllllllllllIlllllllIlIIIlIIll = Maps.newHashMap();
            if (llllllllllllllIlllllllIlIIIlIlII.has("textures")) {
                final JsonObject llllllllllllllIlllllllIlIIIlIIlI = llllllllllllllIlllllllIlIIIlIlII.getAsJsonObject("textures");
                for (final Map.Entry llllllllllllllIlllllllIlIIIlIIII : llllllllllllllIlllllllIlIIIlIIlI.entrySet()) {
                    llllllllllllllIlllllllIlIIIlIIll.put(llllllllllllllIlllllllIlIIIlIIII.getKey(), llllllllllllllIlllllllIlIIIlIIII.getValue().getAsString());
                }
            }
            return llllllllllllllIlllllllIlIIIlIIll;
        }
        
        private String getParent(final JsonObject llllllllllllllIlllllllIlIIIIIlll) {
            return JsonUtils.getJsonObjectStringFieldValueOrDefault(llllllllllllllIlllllllIlIIIIIlll, "parent", "");
        }
    }
}
