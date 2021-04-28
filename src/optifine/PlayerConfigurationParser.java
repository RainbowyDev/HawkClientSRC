package optifine;

import net.minecraft.util.*;
import java.awt.image.*;
import net.minecraft.client.*;
import com.google.gson.*;
import javax.imageio.*;
import java.io.*;

public class PlayerConfigurationParser
{
    private /* synthetic */ String player;
    
    public PlayerConfiguration parsePlayerConfiguration(final JsonElement llllllllllllllIIlllIIIIlIIIlIllI) {
        if (llllllllllllllIIlllIIIIlIIIlIllI == null) {
            throw new JsonParseException(String.valueOf(new StringBuilder("JSON object is null, player: ").append(this.player)));
        }
        final JsonObject llllllllllllllIIlllIIIIlIIIlIlIl = (JsonObject)llllllllllllllIIlllIIIIlIIIlIllI;
        final PlayerConfiguration llllllllllllllIIlllIIIIlIIIlIlII = new PlayerConfiguration();
        final JsonArray llllllllllllllIIlllIIIIlIIIlIIll = (JsonArray)llllllllllllllIIlllIIIIlIIIlIlIl.get("items");
        if (llllllllllllllIIlllIIIIlIIIlIIll != null) {
            for (int llllllllllllllIIlllIIIIlIIIlIIlI = 0; llllllllllllllIIlllIIIIlIIIlIIlI < llllllllllllllIIlllIIIIlIIIlIIll.size(); ++llllllllllllllIIlllIIIIlIIIlIIlI) {
                final JsonObject llllllllllllllIIlllIIIIlIIIlIIIl = (JsonObject)llllllllllllllIIlllIIIIlIIIlIIll.get(llllllllllllllIIlllIIIIlIIIlIIlI);
                final boolean llllllllllllllIIlllIIIIlIIIlIIII = Json.getBoolean(llllllllllllllIIlllIIIIlIIIlIIIl, "active", true);
                if (llllllllllllllIIlllIIIIlIIIlIIII) {
                    final String llllllllllllllIIlllIIIIlIIIIllll = Json.getString(llllllllllllllIIlllIIIIlIIIlIIIl, "type");
                    if (llllllllllllllIIlllIIIIlIIIIllll == null) {
                        Config.warn(String.valueOf(new StringBuilder("Item type is null, player: ").append(this.player)));
                    }
                    else {
                        String llllllllllllllIIlllIIIIlIIIIlllI = Json.getString(llllllllllllllIIlllIIIIlIIIlIIIl, "model");
                        if (llllllllllllllIIlllIIIIlIIIIlllI == null) {
                            llllllllllllllIIlllIIIIlIIIIlllI = String.valueOf(new StringBuilder("items/").append(llllllllllllllIIlllIIIIlIIIIllll).append("/model.cfg"));
                        }
                        final PlayerItemModel llllllllllllllIIlllIIIIlIIIIllIl = this.downloadModel(llllllllllllllIIlllIIIIlIIIIlllI);
                        if (llllllllllllllIIlllIIIIlIIIIllIl != null) {
                            if (!llllllllllllllIIlllIIIIlIIIIllIl.isUsePlayerTexture()) {
                                String llllllllllllllIIlllIIIIlIIIIllII = Json.getString(llllllllllllllIIlllIIIIlIIIlIIIl, "texture");
                                if (llllllllllllllIIlllIIIIlIIIIllII == null) {
                                    llllllllllllllIIlllIIIIlIIIIllII = String.valueOf(new StringBuilder("items/").append(llllllllllllllIIlllIIIIlIIIIllll).append("/users/").append(this.player).append(".png"));
                                }
                                final BufferedImage llllllllllllllIIlllIIIIlIIIIlIll = this.downloadTextureImage(llllllllllllllIIlllIIIIlIIIIllII);
                                if (llllllllllllllIIlllIIIIlIIIIlIll == null) {
                                    continue;
                                }
                                llllllllllllllIIlllIIIIlIIIIllIl.setTextureImage(llllllllllllllIIlllIIIIlIIIIlIll);
                                final ResourceLocation llllllllllllllIIlllIIIIlIIIIlIlI = new ResourceLocation("optifine.net", llllllllllllllIIlllIIIIlIIIIllII);
                                llllllllllllllIIlllIIIIlIIIIllIl.setTextureLocation(llllllllllllllIIlllIIIIlIIIIlIlI);
                            }
                            llllllllllllllIIlllIIIIlIIIlIlII.addPlayerItemModel(llllllllllllllIIlllIIIIlIIIIllIl);
                        }
                    }
                }
            }
        }
        return llllllllllllllIIlllIIIIlIIIlIlII;
    }
    
    public PlayerConfigurationParser(final String llllllllllllllIIlllIIIIlIIlIlIII) {
        this.player = null;
        this.player = llllllllllllllIIlllIIIIlIIlIlIII;
    }
    
    static {
        ITEM_ACTIVE = "active";
        ITEM_TYPE = "type";
        CONFIG_ITEMS = "items";
    }
    
    private PlayerItemModel downloadModel(final String llllllllllllllIIlllIIIIIlllIIlII) {
        final String llllllllllllllIIlllIIIIIlllIIIll = String.valueOf(new StringBuilder("http://s.optifine.net/").append(llllllllllllllIIlllIIIIIlllIIlII));
        try {
            final byte[] llllllllllllllIIlllIIIIIlllIIIlI = HttpPipeline.get(llllllllllllllIIlllIIIIIlllIIIll, Minecraft.getMinecraft().getProxy());
            final String llllllllllllllIIlllIIIIIlllIIIIl = new String(llllllllllllllIIlllIIIIIlllIIIlI, "ASCII");
            final JsonParser llllllllllllllIIlllIIIIIlllIIIII = new JsonParser();
            final JsonObject llllllllllllllIIlllIIIIIllIlllll = (JsonObject)llllllllllllllIIlllIIIIIlllIIIII.parse(llllllllllllllIIlllIIIIIlllIIIIl);
            final PlayerItemParser llllllllllllllIIlllIIIIIllIllllI = new PlayerItemParser();
            final PlayerItemModel llllllllllllllIIlllIIIIIllIlllIl = PlayerItemParser.parseItemModel(llllllllllllllIIlllIIIIIllIlllll);
            return llllllllllllllIIlllIIIIIllIlllIl;
        }
        catch (Exception llllllllllllllIIlllIIIIIllIlllII) {
            Config.warn(String.valueOf(new StringBuilder("Error loading item model ").append(llllllllllllllIIlllIIIIIlllIIlII).append(": ").append(llllllllllllllIIlllIIIIIllIlllII.getClass().getName()).append(": ").append(llllllllllllllIIlllIIIIIllIlllII.getMessage())));
            return null;
        }
    }
    
    private BufferedImage downloadTextureImage(final String llllllllllllllIIlllIIIIIllllIIIl) {
        final String llllllllllllllIIlllIIIIIllllIlIl = String.valueOf(new StringBuilder("http://s.optifine.net/").append(llllllllllllllIIlllIIIIIllllIIIl));
        try {
            final byte[] llllllllllllllIIlllIIIIIllllIlII = HttpPipeline.get(llllllllllllllIIlllIIIIIllllIlIl, Minecraft.getMinecraft().getProxy());
            final BufferedImage llllllllllllllIIlllIIIIIllllIIll = ImageIO.read(new ByteArrayInputStream(llllllllllllllIIlllIIIIIllllIlII));
            return llllllllllllllIIlllIIIIIllllIIll;
        }
        catch (IOException llllllllllllllIIlllIIIIIllllIIlI) {
            Config.warn(String.valueOf(new StringBuilder("Error loading item texture ").append(llllllllllllllIIlllIIIIIllllIIIl).append(": ").append(llllllllllllllIIlllIIIIIllllIIlI.getClass().getName()).append(": ").append(llllllllllllllIIlllIIIIIllllIIlI.getMessage())));
            return null;
        }
    }
}
