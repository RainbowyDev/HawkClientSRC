package net.minecraft.client.resources;

import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.client.resources.data.*;
import java.io.*;
import com.google.gson.*;
import org.apache.commons.io.*;

public class SimpleResource implements IResource
{
    private final /* synthetic */ InputStream mcmetaInputStream;
    private final /* synthetic */ ResourceLocation srResourceLocation;
    private final /* synthetic */ IMetadataSerializer srMetadataSerializer;
    private /* synthetic */ JsonObject mcmetaJson;
    private final /* synthetic */ Map mapMetadataSections;
    private final /* synthetic */ InputStream resourceInputStream;
    private final /* synthetic */ String field_177242_b;
    private /* synthetic */ boolean mcmetaJsonChecked;
    
    public SimpleResource(final String llllllllllllllllIIIlllllIIlIllII, final ResourceLocation llllllllllllllllIIIlllllIIlIlIll, final InputStream llllllllllllllllIIIlllllIIlIlIlI, final InputStream llllllllllllllllIIIlllllIIlIIIll, final IMetadataSerializer llllllllllllllllIIIlllllIIlIIIlI) {
        this.mapMetadataSections = Maps.newHashMap();
        this.field_177242_b = llllllllllllllllIIIlllllIIlIllII;
        this.srResourceLocation = llllllllllllllllIIIlllllIIlIlIll;
        this.resourceInputStream = llllllllllllllllIIIlllllIIlIlIlI;
        this.mcmetaInputStream = llllllllllllllllIIIlllllIIlIIIll;
        this.srMetadataSerializer = llllllllllllllllIIIlllllIIlIIIlI;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllllIIIllllIllllllIl = (this.field_177242_b != null) ? this.field_177242_b.hashCode() : 0;
        llllllllllllllllIIIllllIllllllIl = 31 * llllllllllllllllIIIllllIllllllIl + ((this.srResourceLocation != null) ? this.srResourceLocation.hashCode() : 0);
        return llllllllllllllllIIIllllIllllllIl;
    }
    
    static {
        __OBFID = "CL_00001093";
    }
    
    @Override
    public ResourceLocation func_177241_a() {
        return this.srResourceLocation;
    }
    
    @Override
    public IMetadataSection getMetadata(final String llllllllllllllllIIIlllllIIIIllll) {
        if (!this.hasMetadata()) {
            return null;
        }
        if (this.mcmetaJson == null && !this.mcmetaJsonChecked) {
            this.mcmetaJsonChecked = true;
            BufferedReader llllllllllllllllIIIlllllIIIlIIlI = null;
            try {
                llllllllllllllllIIIlllllIIIlIIlI = new BufferedReader(new InputStreamReader(this.mcmetaInputStream));
                this.mcmetaJson = new JsonParser().parse((Reader)llllllllllllllllIIIlllllIIIlIIlI).getAsJsonObject();
            }
            finally {
                IOUtils.closeQuietly((Reader)llllllllllllllllIIIlllllIIIlIIlI);
            }
            IOUtils.closeQuietly((Reader)llllllllllllllllIIIlllllIIIlIIlI);
        }
        IMetadataSection llllllllllllllllIIIlllllIIIlIIIl = this.mapMetadataSections.get(llllllllllllllllIIIlllllIIIIllll);
        if (llllllllllllllllIIIlllllIIIlIIIl == null) {
            llllllllllllllllIIIlllllIIIlIIIl = this.srMetadataSerializer.parseMetadataSection(llllllllllllllllIIIlllllIIIIllll, this.mcmetaJson);
        }
        return llllllllllllllllIIIlllllIIIlIIIl;
    }
    
    @Override
    public String func_177240_d() {
        return this.field_177242_b;
    }
    
    @Override
    public InputStream getInputStream() {
        return this.resourceInputStream;
    }
    
    @Override
    public boolean hasMetadata() {
        return this.mcmetaInputStream != null;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIIlllllIIIIIlIl) {
        if (this == llllllllllllllllIIIlllllIIIIIlIl) {
            return true;
        }
        if (!(llllllllllllllllIIIlllllIIIIIlIl instanceof SimpleResource)) {
            return false;
        }
        final SimpleResource llllllllllllllllIIIlllllIIIIIlII = (SimpleResource)llllllllllllllllIIIlllllIIIIIlIl;
        if (this.srResourceLocation != null) {
            if (!this.srResourceLocation.equals(llllllllllllllllIIIlllllIIIIIlII.srResourceLocation)) {
                return false;
            }
        }
        else if (llllllllllllllllIIIlllllIIIIIlII.srResourceLocation != null) {
            return false;
        }
        if (this.field_177242_b != null) {
            if (!this.field_177242_b.equals(llllllllllllllllIIIlllllIIIIIlII.field_177242_b)) {
                return false;
            }
        }
        else if (llllllllllllllllIIIlllllIIIIIlII.field_177242_b != null) {
            return false;
        }
        return true;
    }
}
