package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import com.google.gson.*;
import java.io.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.texture.*;

public class ResourcePackListEntryDefault extends ResourcePackListEntry
{
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ IResourcePack field_148320_d;
    private final /* synthetic */ ResourceLocation field_148321_e;
    
    @Override
    protected void func_148313_c() {
        this.field_148317_a.getTextureManager().bindTexture(this.field_148321_e);
    }
    
    @Override
    protected String func_148312_b() {
        return "Default";
    }
    
    @Override
    protected boolean func_148310_d() {
        return false;
    }
    
    @Override
    protected boolean func_148307_h() {
        return false;
    }
    
    @Override
    protected boolean func_148314_g() {
        return false;
    }
    
    @Override
    protected String func_148311_a() {
        try {
            final PackMetadataSection llllllllllllllllIIIIlIlIlIIllIlI = (PackMetadataSection)this.field_148320_d.getPackMetadata(this.field_148317_a.getResourcePackRepository().rprMetadataSerializer, "pack");
            if (llllllllllllllllIIIIlIlIlIIllIlI != null) {
                return llllllllllllllllIIIIlIlIlIIllIlI.func_152805_a().getFormattedText();
            }
        }
        catch (JsonParseException llllllllllllllllIIIIlIlIlIIllIIl) {
            ResourcePackListEntryDefault.logger.error("Couldn't load metadata info", (Throwable)llllllllllllllllIIIIlIlIlIIllIIl);
        }
        catch (IOException llllllllllllllllIIIIlIlIlIIllIII) {
            ResourcePackListEntryDefault.logger.error("Couldn't load metadata info", (Throwable)llllllllllllllllIIIIlIlIlIIllIII);
        }
        return String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Missing ").append("pack.mcmeta").append(" :("));
    }
    
    static {
        __OBFID = "CL_00000822";
        logger = LogManager.getLogger();
    }
    
    @Override
    protected boolean func_148309_e() {
        return false;
    }
    
    public ResourcePackListEntryDefault(final GuiScreenResourcePacks llllllllllllllllIIIIlIlIlIlIIIII) {
        super(llllllllllllllllIIIIlIlIlIlIIIII);
        this.field_148320_d = this.field_148317_a.getResourcePackRepository().rprDefaultResourcePack;
        DynamicTexture llllllllllllllllIIIIlIlIlIlIIIll = null;
        try {
            final DynamicTexture llllllllllllllllIIIIlIlIlIlIIlII = new DynamicTexture(this.field_148320_d.getPackImage());
        }
        catch (IOException llllllllllllllllIIIIlIlIlIlIIIlI) {
            llllllllllllllllIIIIlIlIlIlIIIll = TextureUtil.missingTexture;
        }
        this.field_148321_e = this.field_148317_a.getTextureManager().getDynamicTextureLocation("texturepackicon", llllllllllllllllIIIIlIlIlIlIIIll);
    }
    
    @Override
    protected boolean func_148308_f() {
        return false;
    }
}
