package optifine;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.block.model.*;

public class CustomItemProperties
{
    public /* synthetic */ float duration;
    public /* synthetic */ int type;
    public /* synthetic */ int blend;
    public /* synthetic */ RangeListInt enchantmentLevels;
    public /* synthetic */ int layer;
    private /* synthetic */ int textureHeight;
    public /* synthetic */ float speed;
    public /* synthetic */ Map mapSprites;
    public /* synthetic */ IBakedModel model;
    public /* synthetic */ int damageMask;
    public /* synthetic */ boolean damagePercent;
    public /* synthetic */ float rotation;
    public /* synthetic */ RangeListInt enchantmentIds;
    public /* synthetic */ RangeListInt stackSize;
    public /* synthetic */ String texture;
    public /* synthetic */ int weight;
    public /* synthetic */ String name;
    public /* synthetic */ TextureAtlasSprite sprite;
    public /* synthetic */ RangeListInt damage;
    public /* synthetic */ String basePath;
    public /* synthetic */ Map<String, String> mapTextures;
    public /* synthetic */ int[] items;
    public /* synthetic */ Map mapTextureLocations;
    private /* synthetic */ int textureWidth;
    public /* synthetic */ Map<String, IBakedModel> mapModels;
    public /* synthetic */ NbtTagValue[] nbtTagValues;
    public /* synthetic */ ResourceLocation textureLocation;
    
    private static Map getMatchingProperties(final Properties llllllllllllllIIlIlIlIIIIlIlIlII, final String llllllllllllllIIlIlIlIIIIlIllIlI) {
        final LinkedHashMap llllllllllllllIIlIlIlIIIIlIllIIl = new LinkedHashMap();
        final Set llllllllllllllIIlIlIlIIIIlIllIII = llllllllllllllIIlIlIlIIIIlIlIlII.keySet();
        for (final String llllllllllllllIIlIlIlIIIIlIlIllI : llllllllllllllIIlIlIlIIIIlIllIII) {
            final String llllllllllllllIIlIlIlIIIIlIlIlIl = llllllllllllllIIlIlIlIIIIlIlIlII.getProperty(llllllllllllllIIlIlIlIIIIlIlIllI);
            if (llllllllllllllIIlIlIlIIIIlIlIllI.startsWith(llllllllllllllIIlIlIlIIIIlIllIlI)) {
                llllllllllllllIIlIlIlIIIIlIllIIl.put(llllllllllllllIIlIlIlIIIIlIlIllI, llllllllllllllIIlIlIlIIIIlIlIlIl);
            }
        }
        return llllllllllllllIIlIlIlIIIIlIllIIl;
    }
    
    private int[] parseItems(String llllllllllllllIIlIlIlIIlIIIlIIll, final String llllllllllllllIIlIlIlIIlIIIlIIlI) {
        if (llllllllllllllIIlIlIlIIlIIIlIIll == null) {
            llllllllllllllIIlIlIlIIlIIIlIIll = llllllllllllllIIlIlIlIIlIIIlIIlI;
        }
        if (llllllllllllllIIlIlIlIIlIIIlIIll == null) {
            return null;
        }
        llllllllllllllIIlIlIlIIlIIIlIIll = ((String)llllllllllllllIIlIlIlIIlIIIlIIll).trim();
        final TreeSet llllllllllllllIIlIlIlIIlIIlIIIll = new TreeSet();
        final String[] llllllllllllllIIlIlIlIIlIIlIIIlI = Config.tokenize((String)llllllllllllllIIlIlIlIIlIIIlIIll, " ");
        for (int llllllllllllllIIlIlIlIIlIIIlllll = 0; llllllllllllllIIlIlIlIIlIIIlllll < llllllllllllllIIlIlIlIIlIIlIIIlI.length; ++llllllllllllllIIlIlIlIIlIIIlllll) {
            final String llllllllllllllIIlIlIlIIlIIIllllI = llllllllllllllIIlIlIlIIlIIlIIIlI[llllllllllllllIIlIlIlIIlIIIlllll];
            final int llllllllllllllIIlIlIlIIlIIlIIIIl = Config.parseInt(llllllllllllllIIlIlIlIIlIIIllllI, -1);
            if (llllllllllllllIIlIlIlIIlIIlIIIIl >= 0) {
                llllllllllllllIIlIlIlIIlIIlIIIll.add(new Integer(llllllllllllllIIlIlIlIIlIIlIIIIl));
            }
            else {
                if (llllllllllllllIIlIlIlIIlIIIllllI.contains("-")) {
                    final String[] llllllllllllllIIlIlIlIIlIIIllIll = Config.tokenize(llllllllllllllIIlIlIlIIlIIIllllI, "-");
                    if (llllllllllllllIIlIlIlIIlIIIllIll.length == 2) {
                        final int llllllllllllllIIlIlIlIIlIIIlllIl = Config.parseInt(llllllllllllllIIlIlIlIIlIIIllIll[0], -1);
                        final int llllllllllllllIIlIlIlIIlIIIllIlI = Config.parseInt(llllllllllllllIIlIlIlIIlIIIllIll[1], -1);
                        if (llllllllllllllIIlIlIlIIlIIIlllIl >= 0 && llllllllllllllIIlIlIlIIlIIIllIlI >= 0) {
                            final int llllllllllllllIIlIlIlIIlIIIllIIl = Math.min(llllllllllllllIIlIlIlIIlIIIlllIl, llllllllllllllIIlIlIlIIlIIIllIlI);
                            for (int llllllllllllllIIlIlIlIIlIIIllIII = Math.max(llllllllllllllIIlIlIlIIlIIIlllIl, llllllllllllllIIlIlIlIIlIIIllIlI), llllllllllllllIIlIlIlIIlIIIlIlll = llllllllllllllIIlIlIlIIlIIIllIIl; llllllllllllllIIlIlIlIIlIIIlIlll <= llllllllllllllIIlIlIlIIlIIIllIII; ++llllllllllllllIIlIlIlIIlIIIlIlll) {
                                llllllllllllllIIlIlIlIIlIIlIIIll.add(new Integer(llllllllllllllIIlIlIlIIlIIIlIlll));
                            }
                            continue;
                        }
                    }
                }
                final Item llllllllllllllIIlIlIlIIlIIIlIllI = Item.getByNameOrId(llllllllllllllIIlIlIlIIlIIIllllI);
                if (llllllllllllllIIlIlIlIIlIIIlIllI == null) {
                    Config.warn(String.valueOf(new StringBuilder("Item not found: ").append(llllllllllllllIIlIlIlIIlIIIllllI)));
                }
                else {
                    final int llllllllllllllIIlIlIlIIlIIIlllII = Item.getIdFromItem(llllllllllllllIIlIlIlIIlIIIlIllI);
                    if (llllllllllllllIIlIlIlIIlIIIlllII < 0) {
                        Config.warn(String.valueOf(new StringBuilder("Item not found: ").append(llllllllllllllIIlIlIlIIlIIIllllI)));
                    }
                    else {
                        llllllllllllllIIlIlIlIIlIIlIIIll.add(new Integer(llllllllllllllIIlIlIlIIlIIIlllII));
                    }
                }
            }
        }
        final Integer[] llllllllllllllIIlIlIlIIlIIIlIlIl = (Integer[])llllllllllllllIIlIlIlIIlIIlIIIll.toArray(new Integer[llllllllllllllIIlIlIlIIlIIlIIIll.size()]);
        final int[] llllllllllllllIIlIlIlIIlIIIlIlII = new int[llllllllllllllIIlIlIlIIlIIIlIlIl.length];
        for (int llllllllllllllIIlIlIlIIlIIlIIIII = 0; llllllllllllllIIlIlIlIIlIIlIIIII < llllllllllllllIIlIlIlIIlIIIlIlII.length; ++llllllllllllllIIlIlIlIIlIIlIIIII) {
            llllllllllllllIIlIlIlIIlIIIlIlII[llllllllllllllIIlIlIlIIlIIlIIIII] = llllllllllllllIIlIlIlIIlIIIlIlIl[llllllllllllllIIlIlIlIIlIIlIIIII];
        }
        return llllllllllllllIIlIlIlIIlIIIlIlII;
    }
    
    private static String parseName(final String llllllllllllllIIlIlIlIIlIlIIIIIl) {
        String llllllllllllllIIlIlIlIIlIlIIIlII = llllllllllllllIIlIlIlIIlIlIIIIIl;
        final int llllllllllllllIIlIlIlIIlIlIIIIll = llllllllllllllIIlIlIlIIlIlIIIIIl.lastIndexOf(47);
        if (llllllllllllllIIlIlIlIIlIlIIIIll >= 0) {
            llllllllllllllIIlIlIlIIlIlIIIlII = llllllllllllllIIlIlIlIIlIlIIIIIl.substring(llllllllllllllIIlIlIlIIlIlIIIIll + 1);
        }
        final int llllllllllllllIIlIlIlIIlIlIIIIlI = llllllllllllllIIlIlIlIIlIlIIIlII.lastIndexOf(46);
        if (llllllllllllllIIlIlIlIIlIlIIIIlI >= 0) {
            llllllllllllllIIlIlIlIIlIlIIIlII = llllllllllllllIIlIlIlIIlIlIIIlII.substring(0, llllllllllllllIIlIlIlIIlIlIIIIlI);
        }
        return llllllllllllllIIlIlIlIIlIlIIIlII;
    }
    
    private RangeInt parseRangeInt(String llllllllllllllIIlIlIlIIIlIIlIIIl) {
        if (llllllllllllllIIlIlIlIIIlIIlIIIl == null) {
            return null;
        }
        llllllllllllllIIlIlIlIIIlIIlIIIl = llllllllllllllIIlIlIlIIIlIIlIIIl.trim();
        final int llllllllllllllIIlIlIlIIIlIIlIIII = llllllllllllllIIlIlIlIIIlIIlIIIl.length() - llllllllllllllIIlIlIlIIIlIIlIIIl.replace("-", "").length();
        if (llllllllllllllIIlIlIlIIIlIIlIIII > 1) {
            Config.warn(String.valueOf(new StringBuilder("Invalid range: ").append(llllllllllllllIIlIlIlIIIlIIlIIIl)));
            return null;
        }
        final String[] llllllllllllllIIlIlIlIIIlIIIllll = Config.tokenize(llllllllllllllIIlIlIlIIIlIIlIIIl, "- ");
        final int[] llllllllllllllIIlIlIlIIIlIIIlllI = new int[llllllllllllllIIlIlIlIIIlIIIllll.length];
        for (int llllllllllllllIIlIlIlIIIlIIIllIl = 0; llllllllllllllIIlIlIlIIIlIIIllIl < llllllllllllllIIlIlIlIIIlIIIllll.length; ++llllllllllllllIIlIlIlIIIlIIIllIl) {
            final String llllllllllllllIIlIlIlIIIlIIIllII = llllllllllllllIIlIlIlIIIlIIIllll[llllllllllllllIIlIlIlIIIlIIIllIl];
            final int llllllllllllllIIlIlIlIIIlIIIlIll = Config.parseInt(llllllllllllllIIlIlIlIIIlIIIllII, -1);
            if (llllllllllllllIIlIlIlIIIlIIIlIll < 0) {
                Config.warn(String.valueOf(new StringBuilder("Invalid range: ").append(llllllllllllllIIlIlIlIIIlIIlIIIl)));
                return null;
            }
            llllllllllllllIIlIlIlIIIlIIIlllI[llllllllllllllIIlIlIlIIIlIIIllIl] = llllllllllllllIIlIlIlIIIlIIIlIll;
        }
        if (llllllllllllllIIlIlIlIIIlIIIlllI.length == 1) {
            final int llllllllllllllIIlIlIlIIIlIIIllIl = llllllllllllllIIlIlIlIIIlIIIlllI[0];
            if (llllllllllllllIIlIlIlIIIlIIlIIIl.startsWith("-")) {
                return new RangeInt(0, llllllllllllllIIlIlIlIIIlIIIllIl);
            }
            if (llllllllllllllIIlIlIlIIIlIIlIIIl.endsWith("-")) {
                return new RangeInt(llllllllllllllIIlIlIlIIIlIIIllIl, 255);
            }
            return new RangeInt(llllllllllllllIIlIlIlIIIlIIIllIl, llllllllllllllIIlIlIlIIIlIIIllIl);
        }
        else {
            if (llllllllllllllIIlIlIlIIIlIIIlllI.length == 2) {
                final int llllllllllllllIIlIlIlIIIlIIIllIl = Math.min(llllllllllllllIIlIlIlIIIlIIIlllI[0], llllllllllllllIIlIlIlIIIlIIIlllI[1]);
                final int llllllllllllllIIlIlIlIIIlIIIlIlI = Math.max(llllllllllllllIIlIlIlIIIlIIIlllI[0], llllllllllllllIIlIlIlIIIlIIIlllI[1]);
                return new RangeInt(llllllllllllllIIlIlIlIIIlIIIllIl, llllllllllllllIIlIlIlIIIlIIIlIlI);
            }
            Config.warn(String.valueOf(new StringBuilder("Invalid range: ").append(llllllllllllllIIlIlIlIIIlIIlIIIl)));
            return null;
        }
    }
    
    private int parseType(final String llllllllllllllIIlIlIlIIlIIllIlIl) {
        if (llllllllllllllIIlIlIlIIlIIllIlIl == null) {
            return 1;
        }
        if (llllllllllllllIIlIlIlIIlIIllIlIl.equals("item")) {
            return 1;
        }
        if (llllllllllllllIIlIlIlIIlIIllIlIl.equals("enchantment")) {
            return 2;
        }
        if (llllllllllllllIIlIlIlIIlIIllIlIl.equals("armor")) {
            return 3;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown method: ").append(llllllllllllllIIlIlIlIIlIIllIlIl)));
        return 0;
    }
    
    private ResourceLocation getTextureLocation(final String llllllllllllllIIlIlIlIIIIIlIIIll) {
        if (llllllllllllllIIlIlIlIIIIIlIIIll == null) {
            return null;
        }
        final ResourceLocation llllllllllllllIIlIlIlIIIIIlIIIlI = new ResourceLocation(llllllllllllllIIlIlIlIIIIIlIIIll);
        final String llllllllllllllIIlIlIlIIIIIlIIIIl = llllllllllllllIIlIlIlIIIIIlIIIlI.getResourceDomain();
        String llllllllllllllIIlIlIlIIIIIlIIIII = llllllllllllllIIlIlIlIIIIIlIIIlI.getResourcePath();
        if (!llllllllllllllIIlIlIlIIIIIlIIIII.contains("/")) {
            llllllllllllllIIlIlIlIIIIIlIIIII = String.valueOf(new StringBuilder("textures/blocks/").append(llllllllllllllIIlIlIlIIIIIlIIIII));
        }
        final String llllllllllllllIIlIlIlIIIIIIlllll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIlIlIIIIIlIIIII)).append(".png"));
        final ResourceLocation llllllllllllllIIlIlIlIIIIIIllllI = new ResourceLocation(llllllllllllllIIlIlIlIIIIIlIIIIl, llllllllllllllIIlIlIlIIIIIIlllll);
        final boolean llllllllllllllIIlIlIlIIIIIIlllIl = Config.hasResource(llllllllllllllIIlIlIlIIIIIIllllI);
        if (!llllllllllllllIIlIlIlIIIIIIlllIl) {
            Config.warn(String.valueOf(new StringBuilder("File not found: ").append(llllllllllllllIIlIlIlIIIIIIlllll)));
        }
        return llllllllllllllIIlIlIlIIIIIIllllI;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.basePath).append("/").append(this.name).append(", type: ").append(this.type).append(", items: [").append(Config.arrayToString(this.items)).append("], textture: ").append(this.texture));
    }
    
    private static IBakedModel bakeModel(final TextureMap llllllllllllllIIlIlIIlllIlllllIl, final ModelBlock llllllllllllllIIlIlIIlllIlllllII, final boolean llllllllllllllIIlIlIIllllIIIlIIl) {
        final ModelRotation llllllllllllllIIlIlIIllllIIIlIII = ModelRotation.X0_Y0;
        final boolean llllllllllllllIIlIlIIllllIIIIlll = false;
        final TextureAtlasSprite llllllllllllllIIlIlIIllllIIIIllI = llllllllllllllIIlIlIIlllIlllllIl.getSpriteSafe(llllllllllllllIIlIlIIlllIlllllII.resolveTextureName("particle"));
        final SimpleBakedModel.Builder llllllllllllllIIlIlIIllllIIIIlIl = new SimpleBakedModel.Builder(llllllllllllllIIlIlIIlllIlllllII).func_177646_a(llllllllllllllIIlIlIIllllIIIIllI);
        for (final BlockPart llllllllllllllIIlIlIIllllIIIIIll : llllllllllllllIIlIlIIlllIlllllII.getElements()) {
            for (final EnumFacing llllllllllllllIIlIlIIllllIIIIIIl : llllllllllllllIIlIlIIllllIIIIIll.field_178240_c.keySet()) {
                BlockPartFace llllllllllllllIIlIlIIllllIIIIIII = llllllllllllllIIlIlIIllllIIIIIll.field_178240_c.get(llllllllllllllIIlIlIIllllIIIIIIl);
                if (!llllllllllllllIIlIlIIllllIIIlIIl) {
                    llllllllllllllIIlIlIIllllIIIIIII = new BlockPartFace(llllllllllllllIIlIlIIllllIIIIIII.field_178244_b, -1, llllllllllllllIIlIlIIllllIIIIIII.field_178242_d, llllllllllllllIIlIlIIllllIIIIIII.field_178243_e);
                }
                final TextureAtlasSprite llllllllllllllIIlIlIIlllIlllllll = llllllllllllllIIlIlIIlllIlllllIl.getSpriteSafe(llllllllllllllIIlIlIIlllIlllllII.resolveTextureName(llllllllllllllIIlIlIIllllIIIIIII.field_178242_d));
                final BakedQuad llllllllllllllIIlIlIIlllIllllllI = makeBakedQuad(llllllllllllllIIlIlIIllllIIIIIll, llllllllllllllIIlIlIIllllIIIIIII, llllllllllllllIIlIlIIlllIlllllll, llllllllllllllIIlIlIIllllIIIIIIl, llllllllllllllIIlIlIIllllIIIlIII, llllllllllllllIIlIlIIllllIIIIlll);
                if (llllllllllllllIIlIlIIllllIIIIIII.field_178244_b == null) {
                    llllllllllllllIIlIlIIllllIIIIlIl.func_177648_a(llllllllllllllIIlIlIIlllIllllllI);
                }
                else {
                    llllllllllllllIIlIlIIllllIIIIlIl.func_177650_a(llllllllllllllIIlIlIIllllIIIlIII.func_177523_a(llllllllllllllIIlIlIIllllIIIIIII.field_178244_b), llllllllllllllIIlIlIIlllIllllllI);
                }
            }
        }
        return llllllllllllllIIlIlIIllllIIIIlIl.func_177645_b();
    }
    
    private NbtTagValue[] parseNbtTagValues(final Properties llllllllllllllIIlIlIlIIIIllIllII) {
        final String llllllllllllllIIlIlIlIIIIlllIllI = "nbt.";
        final Map llllllllllllllIIlIlIlIIIIlllIlIl = getMatchingProperties(llllllllllllllIIlIlIlIIIIllIllII, llllllllllllllIIlIlIlIIIIlllIllI);
        if (llllllllllllllIIlIlIlIIIIlllIlIl.size() <= 0) {
            return null;
        }
        final ArrayList llllllllllllllIIlIlIlIIIIlllIlII = new ArrayList();
        final Set llllllllllllllIIlIlIlIIIIlllIIll = llllllllllllllIIlIlIlIIIIlllIlIl.keySet();
        for (final String llllllllllllllIIlIlIlIIIIlllIIIl : llllllllllllllIIlIlIlIIIIlllIIll) {
            final String llllllllllllllIIlIlIlIIIIlllIIII = llllllllllllllIIlIlIlIIIIlllIlIl.get(llllllllllllllIIlIlIlIIIIlllIIIl);
            final String llllllllllllllIIlIlIlIIIIllIllll = llllllllllllllIIlIlIlIIIIlllIIIl.substring(llllllllllllllIIlIlIlIIIIlllIllI.length());
            final NbtTagValue llllllllllllllIIlIlIlIIIIllIlllI = new NbtTagValue(llllllllllllllIIlIlIlIIIIllIllll, llllllllllllllIIlIlIlIIIIlllIIII);
            llllllllllllllIIlIlIlIIIIlllIlII.add(llllllllllllllIIlIlIlIIIIllIlllI);
        }
        final NbtTagValue[] llllllllllllllIIlIlIlIIIIllIllIl = llllllllllllllIIlIlIlIIIIlllIlII.toArray(new NbtTagValue[llllllllllllllIIlIlIlIIIIlllIlII.size()]);
        return llllllllllllllIIlIlIlIIIIllIllIl;
    }
    
    private static String parseBasePath(final String llllllllllllllIIlIlIlIIlIIlllIll) {
        final int llllllllllllllIIlIlIlIIlIIlllIlI = llllllllllllllIIlIlIlIIlIIlllIll.lastIndexOf(47);
        return (llllllllllllllIIlIlIlIIlIIlllIlI < 0) ? "" : llllllllllllllIIlIlIlIIlIIlllIll.substring(0, llllllllllllllIIlIlIlIIlIIlllIlI);
    }
    
    public boolean isValid(final String llllllllllllllIIlIlIlIIIIlIIlIII) {
        if (this.name == null || this.name.length() <= 0) {
            Config.warn(String.valueOf(new StringBuilder("No name found: ").append(llllllllllllllIIlIlIlIIIIlIIlIII)));
            return false;
        }
        if (this.basePath == null) {
            Config.warn(String.valueOf(new StringBuilder("No base path found: ").append(llllllllllllllIIlIlIlIIIIlIIlIII)));
            return false;
        }
        if (this.type == 0) {
            Config.warn(String.valueOf(new StringBuilder("No type defined: ").append(llllllllllllllIIlIlIlIIIIlIIlIII)));
            return false;
        }
        if ((this.type == 1 || this.type == 3) && this.items == null) {
            Config.warn(String.valueOf(new StringBuilder("No items defined: ").append(llllllllllllllIIlIlIlIIIIlIIlIII)));
            return false;
        }
        if (this.texture == null && this.mapTextures == null) {
            Config.warn(String.valueOf(new StringBuilder("No texture specified: ").append(llllllllllllllIIlIlIlIIIIlIIlIII)));
            return false;
        }
        if (this.type == 2 && this.enchantmentIds == null) {
            Config.warn(String.valueOf(new StringBuilder("No enchantmentIDs specified: ").append(llllllllllllllIIlIlIlIIIIlIIlIII)));
            return false;
        }
        return true;
    }
    
    public void updateModel(final TextureMap llllllllllllllIIlIlIIlllllllIIlI, final ItemModelGenerator llllllllllllllIIlIlIIlllllllIIIl) {
        final String[] llllllllllllllIIlIlIIlllllllllII = this.getModelTextures();
        final boolean llllllllllllllIIlIlIIllllllllIll = this.isUseTint();
        this.model = makeBakedModel(llllllllllllllIIlIlIIlllllllIIlI, llllllllllllllIIlIlIIlllllllIIIl, llllllllllllllIIlIlIIlllllllllII, llllllllllllllIIlIlIIllllllllIll);
        if (this.type == 1 && this.mapTextures != null) {
            final Set llllllllllllllIIlIlIIllllllllIlI = this.mapTextures.keySet();
            for (final String llllllllllllllIIlIlIIllllllllIII : llllllllllllllIIlIlIIllllllllIlI) {
                final String llllllllllllllIIlIlIIlllllllIlll = this.mapTextures.get(llllllllllllllIIlIlIIllllllllIII);
                final String llllllllllllllIIlIlIIlllllllIllI = StrUtils.removePrefix(llllllllllllllIIlIlIIllllllllIII, "texture.");
                if (llllllllllllllIIlIlIIlllllllIllI.startsWith("bow") || llllllllllllllIIlIlIIlllllllIllI.startsWith("fishing_rod")) {
                    final String[] llllllllllllllIIlIlIIlllllllIlIl = { llllllllllllllIIlIlIIlllllllIlll };
                    final IBakedModel llllllllllllllIIlIlIIlllllllIlII = makeBakedModel(llllllllllllllIIlIlIIlllllllIIlI, llllllllllllllIIlIlIIlllllllIIIl, llllllllllllllIIlIlIIlllllllIlIl, llllllllllllllIIlIlIIllllllllIll);
                    if (this.mapModels == null) {
                        this.mapModels = new HashMap<String, IBakedModel>();
                    }
                    this.mapModels.put(llllllllllllllIIlIlIIlllllllIllI, llllllllllllllIIlIlIIlllllllIlII);
                }
            }
        }
    }
    
    public CustomItemProperties(final Properties llllllllllllllIIlIlIlIIlIlIlIIII, final String llllllllllllllIIlIlIlIIlIlIIllll) {
        this.name = null;
        this.basePath = null;
        this.type = 1;
        this.items = null;
        this.texture = null;
        this.mapTextures = null;
        this.damage = null;
        this.damagePercent = false;
        this.damageMask = 0;
        this.stackSize = null;
        this.enchantmentIds = null;
        this.enchantmentLevels = null;
        this.nbtTagValues = null;
        this.blend = 1;
        this.speed = 0.0f;
        this.rotation = 0.0f;
        this.layer = 0;
        this.duration = 1.0f;
        this.weight = 0;
        this.textureLocation = null;
        this.mapTextureLocations = null;
        this.sprite = null;
        this.mapSprites = null;
        this.model = null;
        this.mapModels = null;
        this.textureWidth = 0;
        this.textureHeight = 0;
        this.name = parseName(llllllllllllllIIlIlIlIIlIlIIllll);
        this.basePath = parseBasePath(llllllllllllllIIlIlIlIIlIlIIllll);
        this.type = this.parseType(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("type"));
        this.items = this.parseItems(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("items"), llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("matchItems"));
        this.mapTextures = (Map<String, String>)parseTextures(llllllllllllllIIlIlIlIIlIlIlIIII, this.basePath);
        this.texture = parseTexture(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("texture"), llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("tile"), llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("source"), llllllllllllllIIlIlIlIIlIlIIllll, this.basePath, this.type, this.mapTextures);
        final String llllllllllllllIIlIlIlIIlIlIIlllI = llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("damage");
        if (llllllllllllllIIlIlIlIIlIlIIlllI != null) {
            this.damagePercent = llllllllllllllIIlIlIlIIlIlIIlllI.contains("%");
            llllllllllllllIIlIlIlIIlIlIIlllI.replace("%", "");
            this.damage = this.parseRangeListInt(llllllllllllllIIlIlIlIIlIlIIlllI);
            this.damageMask = this.parseInt(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("damageMask"), 0);
        }
        this.stackSize = this.parseRangeListInt(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("stackSize"));
        this.enchantmentIds = this.parseRangeListInt(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("enchantmentIDs"));
        this.enchantmentLevels = this.parseRangeListInt(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("enchantmentLevels"));
        this.nbtTagValues = this.parseNbtTagValues(llllllllllllllIIlIlIlIIlIlIlIIII);
        this.blend = Blender.parseBlend(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("blend"));
        this.speed = this.parseFloat(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("speed"), 0.0f);
        this.rotation = this.parseFloat(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("rotation"), 0.0f);
        this.layer = this.parseInt(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("layer"), 0);
        this.weight = this.parseInt(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("weight"), 0);
        this.duration = this.parseFloat(llllllllllllllIIlIlIlIIlIlIlIIII.getProperty("duration"), 1.0f);
    }
    
    static {
        TYPE_ENCHANTMENT = 2;
        TYPE_UNKNOWN = 0;
        TYPE_ITEM = 1;
        TYPE_ARMOR = 3;
    }
    
    private static Map parseTextures(final Properties llllllllllllllIIlIlIlIIIllIlllIl, final String llllllllllllllIIlIlIlIIIllIlIIll) {
        final String llllllllllllllIIlIlIlIIIllIllIll = "texture.";
        final Map llllllllllllllIIlIlIlIIIllIllIlI = getMatchingProperties(llllllllllllllIIlIlIlIIIllIlllIl, llllllllllllllIIlIlIlIIIllIllIll);
        if (llllllllllllllIIlIlIlIIIllIllIlI.size() <= 0) {
            return null;
        }
        final Set llllllllllllllIIlIlIlIIIllIllIIl = llllllllllllllIIlIlIlIIIllIllIlI.keySet();
        final LinkedHashMap llllllllllllllIIlIlIlIIIllIllIII = new LinkedHashMap();
        for (final String llllllllllllllIIlIlIlIIIllIlIllI : llllllllllllllIIlIlIlIIIllIllIIl) {
            String llllllllllllllIIlIlIlIIIllIlIlIl = llllllllllllllIIlIlIlIIIllIllIlI.get(llllllllllllllIIlIlIlIIIllIlIllI);
            llllllllllllllIIlIlIlIIIllIlIlIl = fixTextureName(llllllllllllllIIlIlIlIIIllIlIlIl, llllllllllllllIIlIlIlIIIllIlIIll);
            llllllllllllllIIlIlIlIIIllIllIII.put(llllllllllllllIIlIlIlIIIllIlIllI, llllllllllllllIIlIlIlIIIllIlIlIl);
        }
        return llllllllllllllIIlIlIlIIIllIllIII;
    }
    
    public IBakedModel getModel(final ModelResourceLocation llllllllllllllIIlIlIIlllIIllIIII) {
        if (llllllllllllllIIlIlIIlllIIllIIII != null && this.mapTextures != null) {
            final String llllllllllllllIIlIlIIlllIIllIIll = llllllllllllllIIlIlIIlllIIllIIII.getResourcePath();
            if (this.mapModels != null) {
                final IBakedModel llllllllllllllIIlIlIIlllIIllIIlI = this.mapModels.get(llllllllllllllIIlIlIIlllIIllIIll);
                if (llllllllllllllIIlIlIIlllIIllIIlI != null) {
                    return llllllllllllllIIlIlIIlllIIllIIlI;
                }
            }
        }
        return this.model;
    }
    
    private boolean isUseTint() {
        return true;
    }
    
    private static IBakedModel makeBakedModel(final TextureMap llllllllllllllIIlIlIIlllllIlllll, final ItemModelGenerator llllllllllllllIIlIlIIlllllIllllI, final String[] llllllllllllllIIlIlIIlllllIlllIl, final boolean llllllllllllllIIlIlIIlllllIlllII) {
        final ModelBlock llllllllllllllIIlIlIIlllllIllIll = makeModelBlock(llllllllllllllIIlIlIIlllllIlllIl);
        final ModelBlock llllllllllllllIIlIlIIlllllIllIlI = llllllllllllllIIlIlIIlllllIllllI.func_178392_a(llllllllllllllIIlIlIIlllllIlllll, llllllllllllllIIlIlIIlllllIllIll);
        final IBakedModel llllllllllllllIIlIlIIlllllIllIIl = bakeModel(llllllllllllllIIlIlIIlllllIlllll, llllllllllllllIIlIlIIlllllIllIlI, llllllllllllllIIlIlIIlllllIlllII);
        return llllllllllllllIIlIlIIlllllIllIIl;
    }
    
    private static String parseTexture(String llllllllllllllIIlIlIlIIIllllIIII, final String llllllllllllllIIlIlIlIIIlllllIll, final String llllllllllllllIIlIlIlIIIlllllIlI, final String llllllllllllllIIlIlIlIIIlllllIIl, final String llllllllllllllIIlIlIlIIIlllllIII, final int llllllllllllllIIlIlIlIIIllllIlll, final Map<String, String> llllllllllllllIIlIlIlIIIlllIlIlI) {
        if (llllllllllllllIIlIlIlIIIllllIIII == null) {
            llllllllllllllIIlIlIlIIIllllIIII = llllllllllllllIIlIlIlIIIlllllIll;
        }
        if (llllllllllllllIIlIlIlIIIllllIIII == null) {
            llllllllllllllIIlIlIlIIIllllIIII = llllllllllllllIIlIlIlIIIlllllIlI;
        }
        if (llllllllllllllIIlIlIlIIIllllIIII != null) {
            final String llllllllllllllIIlIlIlIIIllllIlIl = ".png";
            if (llllllllllllllIIlIlIlIIIllllIIII.endsWith(llllllllllllllIIlIlIlIIIllllIlIl)) {
                llllllllllllllIIlIlIlIIIllllIIII = llllllllllllllIIlIlIlIIIllllIIII.substring(0, llllllllllllllIIlIlIlIIIllllIIII.length() - llllllllllllllIIlIlIlIIIllllIlIl.length());
            }
            llllllllllllllIIlIlIlIIIllllIIII = fixTextureName(llllllllllllllIIlIlIlIIIllllIIII, llllllllllllllIIlIlIlIIIlllllIII);
            return llllllllllllllIIlIlIlIIIllllIIII;
        }
        if (llllllllllllllIIlIlIlIIIllllIlll == 3) {
            return null;
        }
        if (llllllllllllllIIlIlIlIIIlllIlIlI != null) {
            final String llllllllllllllIIlIlIlIIIllllIlII = llllllllllllllIIlIlIlIIIlllIlIlI.get("texture.bow_standby");
            if (llllllllllllllIIlIlIlIIIllllIlII != null) {
                return llllllllllllllIIlIlIlIIIllllIlII;
            }
        }
        String llllllllllllllIIlIlIlIIIllllIIll = llllllllllllllIIlIlIlIIIlllllIIl;
        final int llllllllllllllIIlIlIlIIIllllIIlI = llllllllllllllIIlIlIlIIIlllllIIl.lastIndexOf(47);
        if (llllllllllllllIIlIlIlIIIllllIIlI >= 0) {
            llllllllllllllIIlIlIlIIIllllIIll = llllllllllllllIIlIlIlIIIlllllIIl.substring(llllllllllllllIIlIlIlIIIllllIIlI + 1);
        }
        final int llllllllllllllIIlIlIlIIIllllIIIl = llllllllllllllIIlIlIlIIIllllIIll.lastIndexOf(46);
        if (llllllllllllllIIlIlIlIIIllllIIIl >= 0) {
            llllllllllllllIIlIlIlIIIllllIIll = llllllllllllllIIlIlIlIIIllllIIll.substring(0, llllllllllllllIIlIlIlIIIllllIIIl);
        }
        llllllllllllllIIlIlIlIIIllllIIll = fixTextureName(llllllllllllllIIlIlIlIIIllllIIll, llllllllllllllIIlIlIlIIIlllllIII);
        return llllllllllllllIIlIlIlIIIllllIIll;
    }
    
    public float getTextureHeight(final TextureManager llllllllllllllIIlIlIIlllIlIIIIlI) {
        if (this.textureHeight <= 0) {
            if (this.textureLocation != null) {
                final ITextureObject llllllllllllllIIlIlIIlllIlIIIIIl = llllllllllllllIIlIlIIlllIlIIIIlI.getTexture(this.textureLocation);
                final int llllllllllllllIIlIlIIlllIlIIIIII = llllllllllllllIIlIlIIlllIlIIIIIl.getGlTextureId();
                final int llllllllllllllIIlIlIIlllIIllllll = GlStateManager.getBoundTexture();
                GlStateManager.func_179144_i(llllllllllllllIIlIlIIlllIlIIIIII);
                this.textureHeight = GL11.glGetTexLevelParameteri(3553, 0, 4097);
                GlStateManager.func_179144_i(llllllllllllllIIlIlIIlllIIllllll);
            }
            if (this.textureHeight <= 0) {
                this.textureHeight = 16;
            }
        }
        return (float)this.textureHeight;
    }
    
    private int parseInt(String llllllllllllllIIlIlIlIIIlIlllllI, final int llllllllllllllIIlIlIlIIIlIlllIlI) {
        if (llllllllllllllIIlIlIlIIIlIlllllI == null) {
            return llllllllllllllIIlIlIlIIIlIlllIlI;
        }
        llllllllllllllIIlIlIlIIIlIlllllI = llllllllllllllIIlIlIlIIIlIlllllI.trim();
        final int llllllllllllllIIlIlIlIIIlIllllII = Config.parseInt(llllllllllllllIIlIlIlIIIlIlllllI, Integer.MIN_VALUE);
        if (llllllllllllllIIlIlIlIIIlIllllII == Integer.MIN_VALUE) {
            Config.warn(String.valueOf(new StringBuilder("Invalid integer: ").append(llllllllllllllIIlIlIlIIIlIlllllI)));
            return llllllllllllllIIlIlIlIIIlIlllIlI;
        }
        return llllllllllllllIIlIlIlIIIlIllllII;
    }
    
    public float getTextureWidth(final TextureManager llllllllllllllIIlIlIIlllIlIIllII) {
        if (this.textureWidth <= 0) {
            if (this.textureLocation != null) {
                final ITextureObject llllllllllllllIIlIlIIlllIlIlIIII = llllllllllllllIIlIlIIlllIlIIllII.getTexture(this.textureLocation);
                final int llllllllllllllIIlIlIIlllIlIIllll = llllllllllllllIIlIlIIlllIlIlIIII.getGlTextureId();
                final int llllllllllllllIIlIlIIlllIlIIlllI = GlStateManager.getBoundTexture();
                GlStateManager.func_179144_i(llllllllllllllIIlIlIIlllIlIIllll);
                this.textureWidth = GL11.glGetTexLevelParameteri(3553, 0, 4096);
                GlStateManager.func_179144_i(llllllllllllllIIlIlIIlllIlIIlllI);
            }
            if (this.textureWidth <= 0) {
                this.textureWidth = 16;
            }
        }
        return (float)this.textureWidth;
    }
    
    private RangeListInt parseRangeListInt(final String llllllllllllllIIlIlIlIIIlIlIIllI) {
        if (llllllllllllllIIlIlIlIIIlIlIIllI == null) {
            return null;
        }
        final String[] llllllllllllllIIlIlIlIIIlIlIIlIl = Config.tokenize(llllllllllllllIIlIlIlIIIlIlIIllI, " ");
        final RangeListInt llllllllllllllIIlIlIlIIIlIlIIlII = new RangeListInt();
        for (int llllllllllllllIIlIlIlIIIlIlIIIll = 0; llllllllllllllIIlIlIlIIIlIlIIIll < llllllllllllllIIlIlIlIIIlIlIIlIl.length; ++llllllllllllllIIlIlIlIIIlIlIIIll) {
            final String llllllllllllllIIlIlIlIIIlIlIIIlI = llllllllllllllIIlIlIlIIIlIlIIlIl[llllllllllllllIIlIlIlIIIlIlIIIll];
            final RangeInt llllllllllllllIIlIlIlIIIlIlIIIIl = this.parseRangeInt(llllllllllllllIIlIlIlIIIlIlIIIlI);
            if (llllllllllllllIIlIlIlIIIlIlIIIIl == null) {
                Config.warn(String.valueOf(new StringBuilder("Invalid range list: ").append(llllllllllllllIIlIlIlIIIlIlIIllI)));
                return null;
            }
            llllllllllllllIIlIlIlIIIlIlIIlII.addRange(llllllllllllllIIlIlIlIIIlIlIIIIl);
        }
        return llllllllllllllIIlIlIlIIIlIlIIlII;
    }
    
    private float parseFloat(String llllllllllllllIIlIlIlIIIlIllIIIl, final float llllllllllllllIIlIlIlIIIlIllIIII) {
        if (llllllllllllllIIlIlIlIIIlIllIIIl == null) {
            return llllllllllllllIIlIlIlIIIlIllIIII;
        }
        llllllllllllllIIlIlIlIIIlIllIIIl = llllllllllllllIIlIlIlIIIlIllIIIl.trim();
        final float llllllllllllllIIlIlIlIIIlIllIIlI = Config.parseFloat(llllllllllllllIIlIlIlIIIlIllIIIl, Float.MIN_VALUE);
        if (llllllllllllllIIlIlIlIIIlIllIIlI == Float.MIN_VALUE) {
            Config.warn(String.valueOf(new StringBuilder("Invalid float: ").append(llllllllllllllIIlIlIlIIIlIllIIIl)));
            return llllllllllllllIIlIlIlIIIlIllIIII;
        }
        return llllllllllllllIIlIlIlIIIlIllIIlI;
    }
    
    private ResourceLocation getSpriteLocation(final ResourceLocation llllllllllllllIIlIlIlIIIIIIIlllI) {
        String llllllllllllllIIlIlIlIIIIIIlIIII = llllllllllllllIIlIlIlIIIIIIIlllI.getResourcePath();
        llllllllllllllIIlIlIlIIIIIIlIIII = StrUtils.removePrefix(llllllllllllllIIlIlIlIIIIIIlIIII, "textures/");
        llllllllllllllIIlIlIlIIIIIIlIIII = StrUtils.removeSuffix(llllllllllllllIIlIlIlIIIIIIlIIII, ".png");
        final ResourceLocation llllllllllllllIIlIlIlIIIIIIIllll = new ResourceLocation(llllllllllllllIIlIlIlIIIIIIIlllI.getResourceDomain(), llllllllllllllIIlIlIlIIIIIIlIIII);
        return llllllllllllllIIlIlIlIIIIIIIllll;
    }
    
    private static ModelBlock makeModelBlock(final String[] llllllllllllllIIlIlIIllllIIlllIl) {
        final StringBuffer llllllllllllllIIlIlIIllllIlIIIlI = new StringBuffer();
        llllllllllllllIIlIlIIllllIlIIIlI.append("{\"parent\": \"builtin/generated\",\"textures\": {");
        for (int llllllllllllllIIlIlIIllllIlIIIIl = 0; llllllllllllllIIlIlIIllllIlIIIIl < llllllllllllllIIlIlIIllllIIlllIl.length; ++llllllllllllllIIlIlIIllllIlIIIIl) {
            final String llllllllllllllIIlIlIIllllIlIIIII = llllllllllllllIIlIlIIllllIIlllIl[llllllllllllllIIlIlIIllllIlIIIIl];
            if (llllllllllllllIIlIlIIllllIlIIIIl > 0) {
                llllllllllllllIIlIlIIllllIlIIIlI.append(", ");
            }
            llllllllllllllIIlIlIIllllIlIIIlI.append(String.valueOf(new StringBuilder("\"layer").append(llllllllllllllIIlIlIIllllIlIIIIl).append("\": \"").append(llllllllllllllIIlIlIIllllIlIIIII).append("\"")));
        }
        llllllllllllllIIlIlIIllllIlIIIlI.append("}}");
        final String llllllllllllllIIlIlIIllllIIlllll = llllllllllllllIIlIlIIllllIlIIIlI.toString();
        final ModelBlock llllllllllllllIIlIlIIllllIIllllI = ModelBlock.deserialize(llllllllllllllIIlIlIIllllIIlllll);
        return llllllllllllllIIlIlIIllllIIllllI;
    }
    
    private String[] getModelTextures() {
        if (this.type == 1 && this.items.length == 1) {
            final Item llllllllllllllIIlIlIIlllllIIlIII = Item.getItemById(this.items[0]);
            if (llllllllllllllIIlIlIIlllllIIlIII == Items.potionitem && this.damage != null && this.damage.getCountRanges() > 0) {
                final RangeInt llllllllllllllIIlIlIIlllllIIIIll = this.damage.getRange(0);
                final int llllllllllllllIIlIlIIlllllIIIIlI = llllllllllllllIIlIlIIlllllIIIIll.getMin();
                final boolean llllllllllllllIIlIlIIlllllIIIIIl = (llllllllllllllIIlIlIIlllllIIIIlI & 0x4000) != 0x0;
                final String llllllllllllllIIlIlIIlllllIIIlll = this.getMapTexture(this.mapTextures, "texture.potion_overlay", "items/potion_overlay");
                String llllllllllllllIIlIlIIlllllIIIlIl = null;
                if (llllllllllllllIIlIlIIlllllIIIIIl) {
                    llllllllllllllIIlIlIIlllllIIIlIl = this.getMapTexture(this.mapTextures, "texture.potion_bottle_splash", "items/potion_bottle_splash");
                }
                else {
                    llllllllllllllIIlIlIIlllllIIIlIl = this.getMapTexture(this.mapTextures, "texture.potion_bottle_drinkable", "items/potion_bottle_drinkable");
                }
                return new String[] { llllllllllllllIIlIlIIlllllIIIlll, llllllllllllllIIlIlIIlllllIIIlIl };
            }
            if (llllllllllllllIIlIlIIlllllIIlIII instanceof ItemArmor) {
                final ItemArmor llllllllllllllIIlIlIIlllllIIIIII = (ItemArmor)llllllllllllllIIlIlIIlllllIIlIII;
                if (llllllllllllllIIlIlIIlllllIIIIII.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER) {
                    final String llllllllllllllIIlIlIIllllIllllll = "leather";
                    String llllllllllllllIIlIlIIllllIlllllI = "helmet";
                    if (llllllllllllllIIlIlIIlllllIIIIII.armorType == 0) {
                        llllllllllllllIIlIlIIllllIlllllI = "helmet";
                    }
                    if (llllllllllllllIIlIlIIlllllIIIIII.armorType == 1) {
                        llllllllllllllIIlIlIIllllIlllllI = "chestplate";
                    }
                    if (llllllllllllllIIlIlIIlllllIIIIII.armorType == 2) {
                        llllllllllllllIIlIlIIllllIlllllI = "leggings";
                    }
                    if (llllllllllllllIIlIlIIlllllIIIIII.armorType == 3) {
                        llllllllllllllIIlIlIIllllIlllllI = "boots";
                    }
                    final String llllllllllllllIIlIlIIlllllIIIllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIlIIllllIllllll)).append("_").append(llllllllllllllIIlIlIIllllIlllllI));
                    final String llllllllllllllIIlIlIIlllllIIIlII = this.getMapTexture(this.mapTextures, String.valueOf(new StringBuilder("texture.").append(llllllllllllllIIlIlIIlllllIIIllI)), String.valueOf(new StringBuilder("items/").append(llllllllllllllIIlIlIIlllllIIIllI)));
                    final String llllllllllllllIIlIlIIllllIllllIl = this.getMapTexture(this.mapTextures, String.valueOf(new StringBuilder("texture.").append(llllllllllllllIIlIlIIlllllIIIllI).append("_overlay")), String.valueOf(new StringBuilder("items/").append(llllllllllllllIIlIlIIlllllIIIllI).append("_overlay")));
                    return new String[] { llllllllllllllIIlIlIIlllllIIIlII, llllllllllllllIIlIlIIllllIllllIl };
                }
            }
        }
        return new String[] { this.texture };
    }
    
    public void updateIcons(final TextureMap llllllllllllllIIlIlIlIIIIIllIIll) {
        if (this.texture != null) {
            this.textureLocation = this.getTextureLocation(this.texture);
            if (this.type == 1) {
                final ResourceLocation llllllllllllllIIlIlIlIIIIIllllII = this.getSpriteLocation(this.textureLocation);
                this.sprite = llllllllllllllIIlIlIlIIIIIllIIll.func_174942_a(llllllllllllllIIlIlIlIIIIIllllII);
            }
        }
        if (this.mapTextures != null) {
            this.mapTextureLocations = new HashMap();
            this.mapSprites = new HashMap();
            final Set llllllllllllllIIlIlIlIIIIIlllIll = this.mapTextures.keySet();
            for (final String llllllllllllllIIlIlIlIIIIIlllIIl : llllllllllllllIIlIlIlIIIIIlllIll) {
                final String llllllllllllllIIlIlIlIIIIIlllIII = this.mapTextures.get(llllllllllllllIIlIlIlIIIIIlllIIl);
                final ResourceLocation llllllllllllllIIlIlIlIIIIIllIlll = this.getTextureLocation(llllllllllllllIIlIlIlIIIIIlllIII);
                this.mapTextureLocations.put(llllllllllllllIIlIlIlIIIIIlllIIl, llllllllllllllIIlIlIlIIIIIllIlll);
                if (this.type == 1) {
                    final ResourceLocation llllllllllllllIIlIlIlIIIIIllIllI = this.getSpriteLocation(llllllllllllllIIlIlIlIIIIIllIlll);
                    final TextureAtlasSprite llllllllllllllIIlIlIlIIIIIllIlIl = llllllllllllllIIlIlIlIIIIIllIIll.func_174942_a(llllllllllllllIIlIlIlIIIIIllIllI);
                    this.mapSprites.put(llllllllllllllIIlIlIlIIIIIlllIIl, llllllllllllllIIlIlIlIIIIIllIlIl);
                }
            }
        }
    }
    
    private String getMapTexture(final Map<String, String> llllllllllllllIIlIlIIllllIlIllll, final String llllllllllllllIIlIlIIllllIlIlIlI, final String llllllllllllllIIlIlIIllllIlIllIl) {
        if (llllllllllllllIIlIlIIllllIlIllll == null) {
            return llllllllllllllIIlIlIIllllIlIllIl;
        }
        final String llllllllllllllIIlIlIIllllIlIllII = llllllllllllllIIlIlIIllllIlIllll.get(llllllllllllllIIlIlIIllllIlIlIlI);
        return (llllllllllllllIIlIlIIllllIlIllII == null) ? llllllllllllllIIlIlIIllllIlIllIl : llllllllllllllIIlIlIIllllIlIllII;
    }
    
    private static String fixTextureName(String llllllllllllllIIlIlIlIIIllIIIlIl, final String llllllllllllllIIlIlIlIIIllIIIlII) {
        llllllllllllllIIlIlIlIIIllIIIlIl = (Exception)TextureUtils.fixResourcePath((String)llllllllllllllIIlIlIlIIIllIIIlIl, llllllllllllllIIlIlIlIIIllIIIlII);
        if (!((String)llllllllllllllIIlIlIlIIIllIIIlIl).startsWith(llllllllllllllIIlIlIlIIIllIIIlII) && !((String)llllllllllllllIIlIlIlIIIllIIIlIl).startsWith("textures/") && !((String)llllllllllllllIIlIlIlIIIllIIIlIl).startsWith("mcpatcher/")) {
            llllllllllllllIIlIlIlIIIllIIIlIl = (Exception)String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIlIlIIIllIIIlII)).append("/").append((String)llllllllllllllIIlIlIlIIIllIIIlIl));
        }
        if (((String)llllllllllllllIIlIlIlIIIllIIIlIl).endsWith(".png")) {
            llllllllllllllIIlIlIlIIIllIIIlIl = (Exception)((String)llllllllllllllIIlIlIlIIIllIIIlIl).substring(0, ((String)llllllllllllllIIlIlIlIIIllIIIlIl).length() - 4);
        }
        final String llllllllllllllIIlIlIlIIIllIIIllI = "textures/blocks/";
        if (((String)llllllllllllllIIlIlIlIIIllIIIlIl).startsWith(llllllllllllllIIlIlIlIIIllIIIllI)) {
            llllllllllllllIIlIlIlIIIllIIIlIl = (Exception)((String)llllllllllllllIIlIlIlIIIllIIIlIl).substring(llllllllllllllIIlIlIlIIIllIIIllI.length());
        }
        if (((String)llllllllllllllIIlIlIlIIIllIIIlIl).startsWith("/")) {
            llllllllllllllIIlIlIlIIIllIIIlIl = (Exception)((String)llllllllllllllIIlIlIlIIIllIIIlIl).substring(1);
        }
        return (String)llllllllllllllIIlIlIlIIIllIIIlIl;
    }
    
    private static BakedQuad makeBakedQuad(final BlockPart llllllllllllllIIlIlIIlllIllIlIII, final BlockPartFace llllllllllllllIIlIlIIlllIllIIIII, final TextureAtlasSprite llllllllllllllIIlIlIIlllIllIIllI, final EnumFacing llllllllllllllIIlIlIIlllIllIIlIl, final ModelRotation llllllllllllllIIlIlIIlllIllIIlII, final boolean llllllllllllllIIlIlIIlllIlIlllII) {
        final FaceBakery llllllllllllllIIlIlIIlllIllIIIlI = new FaceBakery();
        return llllllllllllllIIlIlIIlllIllIIIlI.func_178414_a(llllllllllllllIIlIlIIlllIllIlIII.field_178241_a, llllllllllllllIIlIlIIlllIllIlIII.field_178239_b, llllllllllllllIIlIlIIlllIllIIIII, llllllllllllllIIlIlIIlllIllIIllI, llllllllllllllIIlIlIIlllIllIIlIl, llllllllllllllIIlIlIIlllIllIIlII, llllllllllllllIIlIlIIlllIllIlIII.field_178237_d, llllllllllllllIIlIlIIlllIlIlllII, llllllllllllllIIlIlIIlllIllIlIII.field_178238_e);
    }
}
