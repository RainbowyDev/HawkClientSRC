package optifine;

import java.util.*;
import java.io.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.block.model.*;

public class NaturalTextures
{
    private static /* synthetic */ NaturalProperties[] propertiesByIndex;
    
    static {
        NaturalTextures.propertiesByIndex = new NaturalProperties[0];
    }
    
    public static void update() {
        NaturalTextures.propertiesByIndex = new NaturalProperties[0];
        if (Config.isNaturalTextures()) {
            final String llIIIlIlllIII = "optifine/natural.properties";
            try {
                final ResourceLocation llIIIlIllIlll = new ResourceLocation(llIIIlIlllIII);
                if (!Config.hasResource(llIIIlIllIlll)) {
                    Config.dbg(String.valueOf(new StringBuilder("NaturalTextures: configuration \"").append(llIIIlIlllIII).append("\" not found")));
                    return;
                }
                final boolean llIIIlIllIllI = Config.isFromDefaultResourcePack(llIIIlIllIlll);
                final InputStream llIIIlIllIlIl = Config.getResourceStream(llIIIlIllIlll);
                final ArrayList llIIIlIllIlII = new ArrayList(256);
                final String llIIIlIllIIll = Config.readInputStream(llIIIlIllIlIl);
                llIIIlIllIlIl.close();
                final String[] llIIIlIllIIlI = Config.tokenize(llIIIlIllIIll, "\n\r");
                if (llIIIlIllIllI) {
                    Config.dbg(String.valueOf(new StringBuilder("Natural Textures: Parsing default configuration \"").append(llIIIlIlllIII).append("\"")));
                    Config.dbg("Natural Textures: Valid only for textures from default resource pack");
                }
                else {
                    Config.dbg(String.valueOf(new StringBuilder("Natural Textures: Parsing configuration \"").append(llIIIlIlllIII).append("\"")));
                }
                final TextureMap llIIIlIllIIIl = TextureUtils.getTextureMapBlocks();
                for (int llIIIlIllIIII = 0; llIIIlIllIIII < llIIIlIllIIlI.length; ++llIIIlIllIIII) {
                    final String llIIIlIlIllll = llIIIlIllIIlI[llIIIlIllIIII].trim();
                    if (!llIIIlIlIllll.startsWith("#")) {
                        final String[] llIIIlIlIlllI = Config.tokenize(llIIIlIlIllll, "=");
                        if (llIIIlIlIlllI.length != 2) {
                            Config.warn(String.valueOf(new StringBuilder("Natural Textures: Invalid \"").append(llIIIlIlllIII).append("\" line: ").append(llIIIlIlIllll)));
                        }
                        else {
                            final String llIIIlIlIllIl = llIIIlIlIlllI[0].trim();
                            final String llIIIlIlIllII = llIIIlIlIlllI[1].trim();
                            final TextureAtlasSprite llIIIlIlIlIll = llIIIlIllIIIl.getSpriteSafe(String.valueOf(new StringBuilder("minecraft:blocks/").append(llIIIlIlIllIl)));
                            if (llIIIlIlIlIll == null) {
                                Config.warn(String.valueOf(new StringBuilder("Natural Textures: Texture not found: \"").append(llIIIlIlllIII).append("\" line: ").append(llIIIlIlIllll)));
                            }
                            else {
                                final int llIIIlIlIlIlI = llIIIlIlIlIll.getIndexInMap();
                                if (llIIIlIlIlIlI < 0) {
                                    Config.warn(String.valueOf(new StringBuilder("Natural Textures: Invalid \"").append(llIIIlIlllIII).append("\" line: ").append(llIIIlIlIllll)));
                                }
                                else {
                                    if (llIIIlIllIllI && !Config.isFromDefaultResourcePack(new ResourceLocation(String.valueOf(new StringBuilder("textures/blocks/").append(llIIIlIlIllIl).append(".png"))))) {
                                        return;
                                    }
                                    final NaturalProperties llIIIlIlIlIIl = new NaturalProperties(llIIIlIlIllII);
                                    if (llIIIlIlIlIIl.isValid()) {
                                        while (llIIIlIllIlII.size() <= llIIIlIlIlIlI) {
                                            llIIIlIllIlII.add(null);
                                        }
                                        llIIIlIllIlII.set(llIIIlIlIlIlI, llIIIlIlIlIIl);
                                        Config.dbg(String.valueOf(new StringBuilder("NaturalTextures: ").append(llIIIlIlIllIl).append(" = ").append(llIIIlIlIllII)));
                                    }
                                }
                            }
                        }
                    }
                }
                NaturalTextures.propertiesByIndex = llIIIlIllIlII.toArray(new NaturalProperties[llIIIlIllIlII.size()]);
            }
            catch (FileNotFoundException llIIIlIlIlIII) {
                Config.warn(String.valueOf(new StringBuilder("NaturalTextures: configuration \"").append(llIIIlIlllIII).append("\" not found")));
            }
            catch (Exception llIIIlIlIIlll) {
                llIIIlIlIIlll.printStackTrace();
            }
        }
    }
    
    public static NaturalProperties getNaturalProperties(final TextureAtlasSprite llIIIIllllIII) {
        if (!(llIIIIllllIII instanceof TextureAtlasSprite)) {
            return null;
        }
        final int llIIIIllllIlI = llIIIIllllIII.getIndexInMap();
        if (llIIIIllllIlI >= 0 && llIIIIllllIlI < NaturalTextures.propertiesByIndex.length) {
            final NaturalProperties llIIIIllllIIl = NaturalTextures.propertiesByIndex[llIIIIllllIlI];
            return llIIIIllllIIl;
        }
        return null;
    }
    
    public static BakedQuad getNaturalTexture(final BlockPos llIIIlIIIIllI, final BakedQuad llIIIlIIIIlIl) {
        final TextureAtlasSprite llIIIlIIIllII = llIIIlIIIIlIl.getSprite();
        if (llIIIlIIIllII == null) {
            return llIIIlIIIIlIl;
        }
        final NaturalProperties llIIIlIIIlIll = getNaturalProperties(llIIIlIIIllII);
        if (llIIIlIIIlIll == null) {
            return llIIIlIIIIlIl;
        }
        final int llIIIlIIIlIlI = ConnectedTextures.getSide(llIIIlIIIIlIl.getFace());
        final int llIIIlIIIlIIl = Config.getRandom(llIIIlIIIIllI, llIIIlIIIlIlI);
        int llIIIlIIIlIII = 0;
        boolean llIIIlIIIIlll = false;
        if (llIIIlIIIlIll.rotation > 1) {
            llIIIlIIIlIII = (llIIIlIIIlIIl & 0x3);
        }
        if (llIIIlIIIlIll.rotation == 2) {
            llIIIlIIIlIII = llIIIlIIIlIII / 2 * 2;
        }
        if (llIIIlIIIlIll.flip) {
            llIIIlIIIIlll = ((llIIIlIIIlIIl & 0x4) != 0x0);
        }
        return llIIIlIIIlIll.getQuad(llIIIlIIIIlIl, llIIIlIIIlIII, llIIIlIIIIlll);
    }
}
