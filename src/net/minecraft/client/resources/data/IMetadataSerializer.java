package net.minecraft.client.resources.data;

import java.lang.reflect.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class IMetadataSerializer
{
    private /* synthetic */ Gson gson;
    private final /* synthetic */ IRegistry metadataSectionSerializerRegistry;
    private final /* synthetic */ GsonBuilder gsonBuilder;
    
    public void registerMetadataSectionType(final IMetadataSectionSerializer llllllllllllllllllIlllIIIIIIlIll, final Class llllllllllllllllllIlllIIIIIIlIlI) {
        this.metadataSectionSerializerRegistry.putObject(llllllllllllllllllIlllIIIIIIlIll.getSectionName(), new Registration(llllllllllllllllllIlllIIIIIIlIll, llllllllllllllllllIlllIIIIIIlIlI, null));
        this.gsonBuilder.registerTypeAdapter((Type)llllllllllllllllllIlllIIIIIIlIlI, (Object)llllllllllllllllllIlllIIIIIIlIll);
        this.gson = null;
    }
    
    private Gson getGson() {
        if (this.gson == null) {
            this.gson = this.gsonBuilder.create();
        }
        return this.gson;
    }
    
    public IMetadataSerializer() {
        this.metadataSectionSerializerRegistry = new RegistrySimple();
        this.gsonBuilder = new GsonBuilder();
        this.gsonBuilder.registerTypeHierarchyAdapter((Class)IChatComponent.class, (Object)new IChatComponent.Serializer());
        this.gsonBuilder.registerTypeHierarchyAdapter((Class)ChatStyle.class, (Object)new ChatStyle.Serializer());
        this.gsonBuilder.registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory());
    }
    
    public IMetadataSection parseMetadataSection(final String llllllllllllllllllIlllIIIIIIIIIl, final JsonObject llllllllllllllllllIllIllllllllII) {
        if (llllllllllllllllllIlllIIIIIIIIIl == null) {
            throw new IllegalArgumentException("Metadata section name cannot be null");
        }
        if (!llllllllllllllllllIllIllllllllII.has(llllllllllllllllllIlllIIIIIIIIIl)) {
            return null;
        }
        if (!llllllllllllllllllIllIllllllllII.get(llllllllllllllllllIlllIIIIIIIIIl).isJsonObject()) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid metadata for '").append(llllllllllllllllllIlllIIIIIIIIIl).append("' - expected object, found ").append(llllllllllllllllllIllIllllllllII.get(llllllllllllllllllIlllIIIIIIIIIl))));
        }
        final Registration llllllllllllllllllIllIllllllllll = (Registration)this.metadataSectionSerializerRegistry.getObject(llllllllllllllllllIlllIIIIIIIIIl);
        if (llllllllllllllllllIllIllllllllll == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to handle metadata section '").append(llllllllllllllllllIlllIIIIIIIIIl).append("'")));
        }
        return (IMetadataSection)this.getGson().fromJson((JsonElement)llllllllllllllllllIllIllllllllII.getAsJsonObject(llllllllllllllllllIlllIIIIIIIIIl), llllllllllllllllllIllIllllllllll.field_110500_b);
    }
    
    static {
        __OBFID = "CL_00001101";
    }
    
    class Registration
    {
        final /* synthetic */ Class field_110500_b;
        final /* synthetic */ IMetadataSectionSerializer field_110502_a;
        
        private Registration(final IMetadataSectionSerializer llllllllllllllllllIlIIlllIlIIIll, final Class llllllllllllllllllIlIIlllIlIIllI) {
            this.field_110502_a = llllllllllllllllllIlIIlllIlIIIll;
            this.field_110500_b = llllllllllllllllllIlIIlllIlIIllI;
        }
        
        Registration(final IMetadataSerializer llllllllllllllllllIlIIlllIIllIII, final IMetadataSectionSerializer llllllllllllllllllIlIIlllIIlllII, final Class llllllllllllllllllIlIIlllIIllIll, final Object llllllllllllllllllIlIIlllIIllIlI) {
            this(llllllllllllllllllIlIIlllIIllIII, llllllllllllllllllIlIIlllIIlllII, llllllllllllllllllIlIIlllIIllIll);
        }
        
        static {
            __OBFID = "CL_00001103";
        }
    }
}
