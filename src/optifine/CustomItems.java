package optifine;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import java.io.*;
import net.minecraft.client.model.*;
import shadersmod.client.*;
import net.minecraft.entity.*;
import net.minecraft.client.resources.*;
import net.minecraft.potion.*;
import java.util.*;

public class CustomItems
{
    private static /* synthetic */ boolean useGlint;
    private static /* synthetic */ ItemModelGenerator itemModelGenerator;
    private static /* synthetic */ CustomItemProperties[][] enchantmentProperties;
    private static /* synthetic */ CustomItemProperties[][] itemProperties;
    private static final /* synthetic */ int[][] EMPTY_INT2_ARRAY;
    private static /* synthetic */ Map mapPotionIds;
    
    private static int[][] getEnchantmentIdLevels(final ItemStack lIllIIIIIIIlIll) {
        final Item lIllIIIIIIlIIlI = lIllIIIIIIIlIll.getItem();
        final NBTTagList lIllIIIIIIlIIIl = (lIllIIIIIIlIIlI == Items.enchanted_book) ? Items.enchanted_book.func_92110_g(lIllIIIIIIIlIll) : lIllIIIIIIIlIll.getEnchantmentTagList();
        if (lIllIIIIIIlIIIl != null && lIllIIIIIIlIIIl.tagCount() > 0) {
            final int[][] lIllIIIIIIlIIII = new int[lIllIIIIIIlIIIl.tagCount()][2];
            for (int lIllIIIIIIIllll = 0; lIllIIIIIIIllll < lIllIIIIIIlIIIl.tagCount(); ++lIllIIIIIIIllll) {
                final NBTTagCompound lIllIIIIIIIlllI = lIllIIIIIIlIIIl.getCompoundTagAt(lIllIIIIIIIllll);
                final short lIllIIIIIIIllIl = lIllIIIIIIIlllI.getShort("id");
                final short lIllIIIIIIIllII = lIllIIIIIIIlllI.getShort("lvl");
                lIllIIIIIIlIIII[lIllIIIIIIIllll][0] = lIllIIIIIIIllIl;
                lIllIIIIIIlIIII[lIllIIIIIIIllll][1] = lIllIIIIIIIllII;
            }
            return lIllIIIIIIlIIII;
        }
        return CustomItems.EMPTY_INT2_ARRAY;
    }
    
    public static boolean renderCustomEffect(final RenderItem lIlIlllllllIlIl, final ItemStack lIlIlllllllIlII, final IBakedModel lIlIlllllllIIll) {
        if (CustomItems.enchantmentProperties == null) {
            return false;
        }
        if (lIlIlllllllIlII == null) {
            return false;
        }
        final int[][] lIlIlllllllIIlI = getEnchantmentIdLevels(lIlIlllllllIlII);
        if (lIlIlllllllIIlI.length <= 0) {
            return false;
        }
        HashSet lIlIlllllllIIIl = null;
        boolean lIlIlllllllIIII = false;
        final TextureManager lIlIllllllIllll = Config.getTextureManager();
        for (int lIlIllllllIlllI = 0; lIlIllllllIlllI < lIlIlllllllIIlI.length; ++lIlIllllllIlllI) {
            final int lIlIllllllIllIl = lIlIlllllllIIlI[lIlIllllllIlllI][0];
            if (lIlIllllllIllIl >= 0 && lIlIllllllIllIl < CustomItems.enchantmentProperties.length) {
                final CustomItemProperties[] lIlIllllllIllII = CustomItems.enchantmentProperties[lIlIllllllIllIl];
                if (lIlIllllllIllII != null) {
                    for (int lIlIllllllIlIll = 0; lIlIllllllIlIll < lIlIllllllIllII.length; ++lIlIllllllIlIll) {
                        final CustomItemProperties lIlIllllllIlIlI = lIlIllllllIllII[lIlIllllllIlIll];
                        if (lIlIlllllllIIIl == null) {
                            lIlIlllllllIIIl = new HashSet();
                        }
                        if (lIlIlllllllIIIl.add(lIlIllllllIllIl) && matchesProperties(lIlIllllllIlIlI, lIlIlllllllIlII, lIlIlllllllIIlI) && lIlIllllllIlIlI.textureLocation != null) {
                            lIlIllllllIllll.bindTexture(lIlIllllllIlIlI.textureLocation);
                            final float lIlIllllllIlIIl = lIlIllllllIlIlI.getTextureWidth(lIlIllllllIllll);
                            if (!lIlIlllllllIIII) {
                                lIlIlllllllIIII = true;
                                GlStateManager.depthMask(false);
                                GlStateManager.depthFunc(514);
                                GlStateManager.disableLighting();
                                GlStateManager.matrixMode(5890);
                            }
                            Blender.setupBlend(lIlIllllllIlIlI.blend, 1.0f);
                            GlStateManager.pushMatrix();
                            GlStateManager.scale(lIlIllllllIlIIl / 2.0f, lIlIllllllIlIIl / 2.0f, lIlIllllllIlIIl / 2.0f);
                            final float lIlIllllllIlIII = lIlIllllllIlIlI.speed * (Minecraft.getSystemTime() % 3000L) / 3000.0f / 8.0f;
                            GlStateManager.translate(lIlIllllllIlIII, 0.0f, 0.0f);
                            GlStateManager.rotate(lIlIllllllIlIlI.rotation, 0.0f, 0.0f, 1.0f);
                            lIlIlllllllIlIl.func_175035_a(lIlIlllllllIIll, -1);
                            GlStateManager.popMatrix();
                        }
                    }
                }
            }
        }
        if (lIlIlllllllIIII) {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthFunc(515);
            GlStateManager.depthMask(true);
            lIlIllllllIllll.bindTexture(TextureMap.locationBlocksTexture);
        }
        return lIlIlllllllIIII;
    }
    
    private static int[] getPotionIds(final int lIllIIIllIlllIl) {
        return new int[] { lIllIIIllIlllIl, lIllIIIllIlllIl + 16, lIllIIIllIlllIl + 32, lIllIIIllIlllIl + 48 };
    }
    
    public static IBakedModel getCustomItemModel(final ItemStack lIllIIIlIIIIIlI, final IBakedModel lIllIIIlIIIIIIl, final ModelResourceLocation lIllIIIlIIIIIII) {
        if (lIllIIIlIIIIIIl.isAmbientOcclusionEnabled()) {
            return lIllIIIlIIIIIIl;
        }
        if (CustomItems.itemProperties == null) {
            return lIllIIIlIIIIIIl;
        }
        final CustomItemProperties lIllIIIlIIIIIll = getCustomItemProperties(lIllIIIlIIIIIlI, 1);
        return (lIllIIIlIIIIIll == null) ? lIllIIIlIIIIIIl : lIllIIIlIIIIIll.getModel(lIllIIIlIIIIIII);
    }
    
    private static List makePropertyList(final CustomItemProperties[][] lIllIIIlIllllll) {
        final ArrayList lIllIIIllIIIIll = new ArrayList();
        if (lIllIIIlIllllll != null) {
            for (int lIllIIIllIIIIlI = 0; lIllIIIllIIIIlI < lIllIIIlIllllll.length; ++lIllIIIllIIIIlI) {
                final CustomItemProperties[] lIllIIIllIIIIIl = lIllIIIlIllllll[lIllIIIllIIIIlI];
                ArrayList lIllIIIllIIIIII = null;
                if (lIllIIIllIIIIIl != null) {
                    lIllIIIllIIIIII = new ArrayList((Collection<? extends E>)Arrays.asList(lIllIIIllIIIIIl));
                }
                lIllIIIllIIIIll.add(lIllIIIllIIIIII);
            }
        }
        return lIllIIIllIIIIll;
    }
    
    private static ResourceLocation getCustomArmorLocation(final ItemStack lIllIIIIllIlIII, final int lIllIIIIllIIlll, final String lIllIIIIlIlllII) {
        final CustomItemProperties lIllIIIIllIIlIl = getCustomItemProperties(lIllIIIIllIlIII, 3);
        if (lIllIIIIllIIlIl == null) {
            return null;
        }
        if (lIllIIIIllIIlIl.mapTextureLocations == null) {
            return null;
        }
        final Item lIllIIIIllIIlII = lIllIIIIllIlIII.getItem();
        if (!(lIllIIIIllIIlII instanceof ItemArmor)) {
            return null;
        }
        final ItemArmor lIllIIIIllIIIll = (ItemArmor)lIllIIIIllIIlII;
        final String lIllIIIIllIIIlI = lIllIIIIllIIIll.getArmorMaterial().func_179242_c();
        final StringBuffer lIllIIIIllIIIIl = new StringBuffer();
        lIllIIIIllIIIIl.append("texture.");
        lIllIIIIllIIIIl.append(lIllIIIIllIIIlI);
        lIllIIIIllIIIIl.append("_layer_");
        lIllIIIIllIIIIl.append(lIllIIIIllIIlll);
        if (lIllIIIIlIlllII != null) {
            lIllIIIIllIIIIl.append("_");
            lIllIIIIllIIIIl.append(lIllIIIIlIlllII);
        }
        final String lIllIIIIllIIIII = lIllIIIIllIIIIl.toString();
        final ResourceLocation lIllIIIIlIlllll = lIllIIIIllIIlIl.mapTextureLocations.get(lIllIIIIllIIIII);
        return lIllIIIIlIlllll;
    }
    
    private static void readCitProperties(final String lIllIIlIllIlIIl) {
        try {
            final ResourceLocation lIllIIlIllIlllI = new ResourceLocation(lIllIIlIllIlIIl);
            final InputStream lIllIIlIllIllIl = Config.getResourceStream(lIllIIlIllIlllI);
            if (lIllIIlIllIllIl == null) {
                return;
            }
            Config.dbg(String.valueOf(new StringBuilder("CustomItems: Loading ").append(lIllIIlIllIlIIl)));
            final Properties lIllIIlIllIllII = new Properties();
            lIllIIlIllIllII.load(lIllIIlIllIllIl);
            lIllIIlIllIllIl.close();
            CustomItems.useGlint = Config.parseBoolean(lIllIIlIllIllII.getProperty("useGlint"), true);
        }
        catch (FileNotFoundException lIllIIlIllIlIll) {}
        catch (IOException lIllIIlIllIlIlI) {
            lIllIIlIllIlIlI.printStackTrace();
        }
    }
    
    private static CustomItemProperties[][] propertyListToArray(final List lIllIIIlIllIIII) {
        final CustomItemProperties[][] lIllIIIlIllIlII = new CustomItemProperties[lIllIIIlIllIIII.size()][];
        for (int lIllIIIlIllIIll = 0; lIllIIIlIllIIll < lIllIIIlIllIIII.size(); ++lIllIIIlIllIIll) {
            final List lIllIIIlIllIIlI = lIllIIIlIllIIII.get(lIllIIIlIllIIll);
            if (lIllIIIlIllIIlI != null) {
                final CustomItemProperties[] lIllIIIlIllIIIl = lIllIIIlIllIIlI.toArray(new CustomItemProperties[lIllIIIlIllIIlI.size()]);
                Arrays.sort(lIllIIIlIllIIIl, new CustomItemsComparator());
                lIllIIIlIllIlII[lIllIIIlIllIIll] = lIllIIIlIllIIIl;
            }
        }
        return lIllIIIlIllIlII;
    }
    
    public static boolean renderCustomArmorEffect(final EntityLivingBase lIlIllllIlIlllI, final ItemStack lIlIlllllIIIIll, final ModelBase lIlIllllIlIllII, final float lIlIllllIlIlIll, final float lIlIllllIlIlIlI, final float lIlIllllIllllll, final float lIlIllllIlllllI, final float lIlIllllIllllIl, final float lIlIllllIlIIlll, final float lIlIllllIlIIllI) {
        if (CustomItems.enchantmentProperties == null) {
            return false;
        }
        if (Config.isShaders() && Shaders.isShadowPass) {
            return false;
        }
        if (lIlIlllllIIIIll == null) {
            return false;
        }
        final int[][] lIlIllllIlllIlI = getEnchantmentIdLevels(lIlIlllllIIIIll);
        if (lIlIllllIlllIlI.length <= 0) {
            return false;
        }
        HashSet lIlIllllIlllIIl = null;
        boolean lIlIllllIlllIII = false;
        final TextureManager lIlIllllIllIlll = Config.getTextureManager();
        for (int lIlIllllIllIllI = 0; lIlIllllIllIllI < lIlIllllIlllIlI.length; ++lIlIllllIllIllI) {
            final int lIlIllllIllIlIl = lIlIllllIlllIlI[lIlIllllIllIllI][0];
            if (lIlIllllIllIlIl >= 0 && lIlIllllIllIlIl < CustomItems.enchantmentProperties.length) {
                final CustomItemProperties[] lIlIllllIllIlII = CustomItems.enchantmentProperties[lIlIllllIllIlIl];
                if (lIlIllllIllIlII != null) {
                    for (int lIlIllllIllIIll = 0; lIlIllllIllIIll < lIlIllllIllIlII.length; ++lIlIllllIllIIll) {
                        final CustomItemProperties lIlIllllIllIIlI = lIlIllllIllIlII[lIlIllllIllIIll];
                        if (lIlIllllIlllIIl == null) {
                            lIlIllllIlllIIl = new HashSet();
                        }
                        if (lIlIllllIlllIIl.add(lIlIllllIllIlIl) && matchesProperties(lIlIllllIllIIlI, lIlIlllllIIIIll, lIlIllllIlllIlI) && lIlIllllIllIIlI.textureLocation != null) {
                            lIlIllllIllIlll.bindTexture(lIlIllllIllIIlI.textureLocation);
                            final float lIlIllllIllIIIl = lIlIllllIllIIlI.getTextureWidth(lIlIllllIllIlll);
                            if (!lIlIllllIlllIII) {
                                lIlIllllIlllIII = true;
                                if (Config.isShaders()) {
                                    ShadersRender.layerArmorBaseDrawEnchantedGlintBegin();
                                }
                                GlStateManager.enableBlend();
                                GlStateManager.depthFunc(514);
                                GlStateManager.depthMask(false);
                            }
                            Blender.setupBlend(lIlIllllIllIIlI.blend, 1.0f);
                            GlStateManager.disableLighting();
                            GlStateManager.matrixMode(5890);
                            GlStateManager.loadIdentity();
                            GlStateManager.rotate(lIlIllllIllIIlI.rotation, 0.0f, 0.0f, 1.0f);
                            final float lIlIllllIllIIII = lIlIllllIllIIIl / 8.0f;
                            GlStateManager.scale(lIlIllllIllIIII, lIlIllllIllIIII / 2.0f, lIlIllllIllIIII);
                            final float lIlIllllIlIllll = lIlIllllIllIIlI.speed * (Minecraft.getSystemTime() % 3000L) / 3000.0f / 8.0f;
                            GlStateManager.translate(0.0f, lIlIllllIlIllll, 0.0f);
                            GlStateManager.matrixMode(5888);
                            lIlIllllIlIllII.render(lIlIllllIlIlllI, lIlIllllIlIlIll, lIlIllllIlIlIlI, lIlIllllIlllllI, lIlIllllIllllIl, lIlIllllIlIIlll, lIlIllllIlIIllI);
                        }
                    }
                }
            }
        }
        if (lIlIllllIlllIII) {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthMask(true);
            GlStateManager.depthFunc(515);
            GlStateManager.disableBlend();
            if (Config.isShaders()) {
                ShadersRender.layerArmorBaseDrawEnchantedGlintEnd();
            }
        }
        return lIlIllllIlllIII;
    }
    
    private static Map makeAutoImageProperties(final IResourcePack lIllIIlIIlIIlIl) {
        final HashMap lIllIIlIIlIIlII = new HashMap();
        lIllIIlIIlIIlII.putAll(makePotionImageProperties(lIllIIlIIlIIlIl, false));
        lIllIIlIIlIIlII.putAll(makePotionImageProperties(lIllIIlIIlIIlIl, true));
        return lIllIIlIIlIIlII;
    }
    
    private static Comparator getPropertiesComparator() {
        final Comparator lIllIIlIIlllIII = new Comparator() {
            @Override
            public int compare(final Object llllllllllllllIIlllIIIIIIlIIllII, final Object llllllllllllllIIlllIIIIIIlIIllll) {
                final CustomItemProperties llllllllllllllIIlllIIIIIIlIIlllI = (CustomItemProperties)llllllllllllllIIlllIIIIIIlIIllII;
                final CustomItemProperties llllllllllllllIIlllIIIIIIlIIllIl = (CustomItemProperties)llllllllllllllIIlllIIIIIIlIIllll;
                return (llllllllllllllIIlllIIIIIIlIIlllI.layer != llllllllllllllIIlllIIIIIIlIIllIl.layer) ? (llllllllllllllIIlllIIIIIIlIIlllI.layer - llllllllllllllIIlllIIIIIIlIIllIl.layer) : ((llllllllllllllIIlllIIIIIIlIIlllI.weight != llllllllllllllIIlllIIIIIIlIIllIl.weight) ? (llllllllllllllIIlllIIIIIIlIIllIl.weight - llllllllllllllIIlllIIIIIIlIIlllI.weight) : (llllllllllllllIIlllIIIIIIlIIlllI.basePath.equals(llllllllllllllIIlllIIIIIIlIIllIl.basePath) ? llllllllllllllIIlllIIIIIIlIIlllI.name.compareTo(llllllllllllllIIlllIIIIIIlIIllIl.name) : llllllllllllllIIlllIIIIIIlIIlllI.basePath.compareTo(llllllllllllllIIlllIIIIIIlIIllIl.basePath)));
            }
        };
        return lIllIIlIIlllIII;
    }
    
    private static void addToList(final CustomItemProperties lIllIIIlIIIlllI, final List lIllIIIlIIIllIl, final int lIllIIIlIIlIIII) {
        while (lIllIIIlIIlIIII >= lIllIIIlIIIllIl.size()) {
            lIllIIIlIIIllIl.add(null);
        }
        Object lIllIIIlIIIllll = lIllIIIlIIIllIl.get(lIllIIIlIIlIIII);
        if (lIllIIIlIIIllll == null) {
            lIllIIIlIIIllll = new ArrayList();
            lIllIIIlIIIllIl.set(lIllIIIlIIlIIII, lIllIIIlIIIllll);
        }
        ((List)lIllIIIlIIIllll).add(lIllIIIlIIIlllI);
    }
    
    private static void updateIcons(final TextureMap lIllIIlIlIIIlIl, final IResourcePack lIllIIlIlIllIII) {
        String[] lIllIIlIlIlIlll = ResUtils.collectFiles(lIllIIlIlIllIII, "mcpatcher/cit/", ".properties", null);
        final Map lIllIIlIlIlIllI = makeAutoImageProperties(lIllIIlIlIllIII);
        if (lIllIIlIlIlIllI.size() > 0) {
            final Set lIllIIlIlIlIlIl = lIllIIlIlIlIllI.keySet();
            final String[] lIllIIlIlIlIlII = lIllIIlIlIlIlIl.toArray(new String[lIllIIlIlIlIlIl.size()]);
            lIllIIlIlIlIlll = (String[])Config.addObjectsToArray(lIllIIlIlIlIlll, lIllIIlIlIlIlII);
        }
        Arrays.sort(lIllIIlIlIlIlll);
        final List lIllIIlIlIlIIll = makePropertyList(CustomItems.itemProperties);
        final List lIllIIlIlIlIIlI = makePropertyList(CustomItems.enchantmentProperties);
        for (int lIllIIlIlIlIIIl = 0; lIllIIlIlIlIIIl < lIllIIlIlIlIlll.length; ++lIllIIlIlIlIIIl) {
            final String lIllIIlIlIlIIII = lIllIIlIlIlIlll[lIllIIlIlIlIIIl];
            Config.dbg(String.valueOf(new StringBuilder("CustomItems: ").append(lIllIIlIlIlIIII)));
            try {
                CustomItemProperties lIllIIlIlIIllll = null;
                if (lIllIIlIlIlIllI.containsKey(lIllIIlIlIlIIII)) {
                    lIllIIlIlIIllll = lIllIIlIlIlIllI.get(lIllIIlIlIlIIII);
                }
                if (lIllIIlIlIIllll == null) {
                    final ResourceLocation lIllIIlIlIIlllI = new ResourceLocation(lIllIIlIlIlIIII);
                    final InputStream lIllIIlIlIIllIl = lIllIIlIlIllIII.getInputStream(lIllIIlIlIIlllI);
                    if (lIllIIlIlIIllIl == null) {
                        Config.warn(String.valueOf(new StringBuilder("CustomItems file not found: ").append(lIllIIlIlIlIIII)));
                        continue;
                    }
                    final Properties lIllIIlIlIIllII = new Properties();
                    lIllIIlIlIIllII.load(lIllIIlIlIIllIl);
                    lIllIIlIlIIllll = new CustomItemProperties(lIllIIlIlIIllII, lIllIIlIlIlIIII);
                }
                if (lIllIIlIlIIllll.isValid(lIllIIlIlIlIIII)) {
                    lIllIIlIlIIllll.updateIcons(lIllIIlIlIIIlIl);
                    addToItemList(lIllIIlIlIIllll, lIllIIlIlIlIIll);
                    addToEnchantmentList(lIllIIlIlIIllll, lIllIIlIlIlIIlI);
                }
            }
            catch (FileNotFoundException lIllIIlIlIIlIll) {
                Config.warn(String.valueOf(new StringBuilder("CustomItems file not found: ").append(lIllIIlIlIlIIII)));
            }
            catch (Exception lIllIIlIlIIlIlI) {
                lIllIIlIlIIlIlI.printStackTrace();
            }
        }
        CustomItems.itemProperties = propertyListToArray(lIllIIlIlIlIIll);
        CustomItems.enchantmentProperties = propertyListToArray(lIllIIlIlIlIIlI);
        final Comparator lIllIIlIlIIlIIl = getPropertiesComparator();
        for (int lIllIIlIlIIlIII = 0; lIllIIlIlIIlIII < CustomItems.itemProperties.length; ++lIllIIlIlIIlIII) {
            final CustomItemProperties[] lIllIIlIlIIIlll = CustomItems.itemProperties[lIllIIlIlIIlIII];
            if (lIllIIlIlIIIlll != null) {
                Arrays.sort(lIllIIlIlIIIlll, lIllIIlIlIIlIIl);
            }
        }
        for (int lIllIIlIlIIlIII = 0; lIllIIlIlIIlIII < CustomItems.enchantmentProperties.length; ++lIllIIlIlIIlIII) {
            final CustomItemProperties[] lIllIIlIlIIIllI = CustomItems.enchantmentProperties[lIllIIlIlIIlIII];
            if (lIllIIlIlIIIllI != null) {
                Arrays.sort(lIllIIlIlIIIllI, lIllIIlIlIIlIIl);
            }
        }
    }
    
    private static Properties makePotionProperties(final String lIllIIIllllIIlI, final boolean lIllIIIlllIIlIl, final String lIllIIIlllIIlII) {
        if (StrUtils.endsWith(lIllIIIllllIIlI, new String[] { "_n", "_s" })) {
            return null;
        }
        if (lIllIIIllllIIlI.equals("empty") && !lIllIIIlllIIlIl) {
            final int lIllIIIlllIllll = Item.getIdFromItem(Items.glass_bottle);
            final Properties lIllIIIlllIllIl = new Properties();
            ((Hashtable<String, String>)lIllIIIlllIllIl).put("type", "item");
            ((Hashtable<String, String>)lIllIIIlllIllIl).put("items", String.valueOf(new StringBuilder().append(lIllIIIlllIllll)));
            return lIllIIIlllIllIl;
        }
        final int lIllIIIlllIlllI = Item.getIdFromItem(Items.potionitem);
        final int[] lIllIIIlllIllII = getMapPotionIds().get(lIllIIIllllIIlI);
        if (lIllIIIlllIllII == null) {
            Config.warn(String.valueOf(new StringBuilder("Potion not found for image: ").append(lIllIIIlllIIlII)));
            return null;
        }
        final StringBuffer lIllIIIlllIlIll = new StringBuffer();
        for (int lIllIIIlllIlIlI = 0; lIllIIIlllIlIlI < lIllIIIlllIllII.length; ++lIllIIIlllIlIlI) {
            int lIllIIIlllIlIIl = lIllIIIlllIllII[lIllIIIlllIlIlI];
            if (lIllIIIlllIIlIl) {
                lIllIIIlllIlIIl |= 0x4000;
            }
            if (lIllIIIlllIlIlI > 0) {
                lIllIIIlllIlIll.append(" ");
            }
            lIllIIIlllIlIll.append(lIllIIIlllIlIIl);
        }
        final short lIllIIIlllIlIII = 16447;
        final Properties lIllIIIlllIIlll = new Properties();
        ((Hashtable<String, String>)lIllIIIlllIIlll).put("type", "item");
        ((Hashtable<String, String>)lIllIIIlllIIlll).put("items", String.valueOf(new StringBuilder().append(lIllIIIlllIlllI)));
        ((Hashtable<String, String>)lIllIIIlllIIlll).put("damage", String.valueOf(new StringBuilder().append(lIllIIIlllIlIll.toString())));
        ((Hashtable<String, String>)lIllIIIlllIIlll).put("damageMask", String.valueOf(new StringBuilder().append(lIllIIIlllIlIII)));
        if (lIllIIIlllIIlIl) {
            ((Hashtable<String, String>)lIllIIIlllIIlll).put("texture.potion_bottle_splash", lIllIIIllllIIlI);
        }
        else {
            ((Hashtable<String, String>)lIllIIIlllIIlll).put("texture.potion_bottle_drinkable", lIllIIIllllIIlI);
        }
        return lIllIIIlllIIlll;
    }
    
    private static Map makePotionImageProperties(final IResourcePack lIllIIlIIIIIlll, final boolean lIllIIlIIIIIllI) {
        final HashMap lIllIIlIIIlIIlI = new HashMap();
        final String lIllIIlIIIlIIIl = lIllIIlIIIIIllI ? "splash/" : "normal/";
        final String[] lIllIIlIIIlIIII = { String.valueOf(new StringBuilder("mcpatcher/cit/potion/").append(lIllIIlIIIlIIIl)), String.valueOf(new StringBuilder("mcpatcher/cit/Potion/").append(lIllIIlIIIlIIIl)) };
        final String[] lIllIIlIIIIllll = { ".png" };
        final String[] lIllIIlIIIIlllI = ResUtils.collectFiles(lIllIIlIIIIIlll, lIllIIlIIIlIIII, lIllIIlIIIIllll);
        for (int lIllIIlIIIIllIl = 0; lIllIIlIIIIllIl < lIllIIlIIIIlllI.length; ++lIllIIlIIIIllIl) {
            final String lIllIIlIIIIllII = lIllIIlIIIIlllI[lIllIIlIIIIllIl];
            final String lIllIIlIIIIlIll = StrUtils.removePrefixSuffix(lIllIIlIIIIllII, lIllIIlIIIlIIII, lIllIIlIIIIllll);
            final Properties lIllIIlIIIIlIlI = makePotionProperties(lIllIIlIIIIlIll, lIllIIlIIIIIllI, lIllIIlIIIIllII);
            if (lIllIIlIIIIlIlI != null) {
                final String lIllIIlIIIIlIIl = String.valueOf(new StringBuilder(String.valueOf(StrUtils.removeSuffix(lIllIIlIIIIllII, lIllIIlIIIIllll))).append(".properties"));
                final CustomItemProperties lIllIIlIIIIlIII = new CustomItemProperties(lIllIIlIIIIlIlI, lIllIIlIIIIlIIl);
                lIllIIlIIIlIIlI.put(lIllIIlIIIIlIIl, lIllIIlIIIIlIII);
            }
        }
        return lIllIIlIIIlIIlI;
    }
    
    public static void updateModels() {
        if (CustomItems.itemProperties != null) {
            for (int lIllIIlIIllIIIl = 0; lIllIIlIIllIIIl < CustomItems.itemProperties.length; ++lIllIIlIIllIIIl) {
                final CustomItemProperties[] lIllIIlIIllIIII = CustomItems.itemProperties[lIllIIlIIllIIIl];
                if (lIllIIlIIllIIII != null) {
                    for (int lIllIIlIIlIllll = 0; lIllIIlIIlIllll < lIllIIlIIllIIII.length; ++lIllIIlIIlIllll) {
                        final CustomItemProperties lIllIIlIIlIlllI = lIllIIlIIllIIII[lIllIIlIIlIllll];
                        if (lIllIIlIIlIlllI != null && lIllIIlIIlIlllI.type == 1) {
                            final TextureMap lIllIIlIIlIllIl = Minecraft.getMinecraft().getTextureMapBlocks();
                            lIllIIlIIlIlllI.updateModel(lIllIIlIIlIllIl, CustomItems.itemModelGenerator);
                        }
                    }
                }
            }
        }
    }
    
    private static Map getMapPotionIds() {
        if (CustomItems.mapPotionIds == null) {
            (CustomItems.mapPotionIds = new LinkedHashMap()).put("water", new int[1]);
            CustomItems.mapPotionIds.put("awkward", new int[] { 16 });
            CustomItems.mapPotionIds.put("thick", new int[] { 32 });
            CustomItems.mapPotionIds.put("potent", new int[] { 48 });
            CustomItems.mapPotionIds.put("regeneration", getPotionIds(1));
            CustomItems.mapPotionIds.put("moveSpeed", getPotionIds(2));
            CustomItems.mapPotionIds.put("fireResistance", getPotionIds(3));
            CustomItems.mapPotionIds.put("poison", getPotionIds(4));
            CustomItems.mapPotionIds.put("heal", getPotionIds(5));
            CustomItems.mapPotionIds.put("nightVision", getPotionIds(6));
            CustomItems.mapPotionIds.put("clear", getPotionIds(7));
            CustomItems.mapPotionIds.put("bungling", getPotionIds(23));
            CustomItems.mapPotionIds.put("charming", getPotionIds(39));
            CustomItems.mapPotionIds.put("rank", getPotionIds(55));
            CustomItems.mapPotionIds.put("weakness", getPotionIds(8));
            CustomItems.mapPotionIds.put("damageBoost", getPotionIds(9));
            CustomItems.mapPotionIds.put("moveSlowdown", getPotionIds(10));
            CustomItems.mapPotionIds.put("diffuse", getPotionIds(11));
            CustomItems.mapPotionIds.put("smooth", getPotionIds(27));
            CustomItems.mapPotionIds.put("refined", getPotionIds(43));
            CustomItems.mapPotionIds.put("acrid", getPotionIds(59));
            CustomItems.mapPotionIds.put("harm", getPotionIds(12));
            CustomItems.mapPotionIds.put("waterBreathing", getPotionIds(13));
            CustomItems.mapPotionIds.put("invisibility", getPotionIds(14));
            CustomItems.mapPotionIds.put("thin", getPotionIds(15));
            CustomItems.mapPotionIds.put("debonair", getPotionIds(31));
            CustomItems.mapPotionIds.put("sparkling", getPotionIds(47));
            CustomItems.mapPotionIds.put("stinky", getPotionIds(63));
        }
        return CustomItems.mapPotionIds;
    }
    
    private static CustomItemProperties getCustomItemProperties(final ItemStack lIllIIIIlIIllIl, final int lIllIIIIlIIIlIl) {
        if (CustomItems.itemProperties == null) {
            return null;
        }
        if (lIllIIIIlIIllIl == null) {
            return null;
        }
        final Item lIllIIIIlIIlIll = lIllIIIIlIIllIl.getItem();
        final int lIllIIIIlIIlIlI = Item.getIdFromItem(lIllIIIIlIIlIll);
        if (lIllIIIIlIIlIlI >= 0 && lIllIIIIlIIlIlI < CustomItems.itemProperties.length) {
            final CustomItemProperties[] lIllIIIIlIIlIIl = CustomItems.itemProperties[lIllIIIIlIIlIlI];
            if (lIllIIIIlIIlIIl != null) {
                for (int lIllIIIIlIIlIII = 0; lIllIIIIlIIlIII < lIllIIIIlIIlIIl.length; ++lIllIIIIlIIlIII) {
                    final CustomItemProperties lIllIIIIlIIIlll = lIllIIIIlIIlIIl[lIllIIIIlIIlIII];
                    if (lIllIIIIlIIIlll.type == lIllIIIIlIIIlIl && matchesProperties(lIllIIIIlIIIlll, lIllIIIIlIIllIl, null)) {
                        return lIllIIIIlIIIlll;
                    }
                }
            }
        }
        return null;
    }
    
    public static boolean isUseGlint() {
        return CustomItems.useGlint;
    }
    
    private static void addToItemList(final CustomItemProperties lIllIIIlIlIIlll, final List lIllIIIlIlIIIlI) {
        if (lIllIIIlIlIIlll.items != null) {
            for (int lIllIIIlIlIIlIl = 0; lIllIIIlIlIIlIl < lIllIIIlIlIIlll.items.length; ++lIllIIIlIlIIlIl) {
                final int lIllIIIlIlIIlII = lIllIIIlIlIIlll.items[lIllIIIlIlIIlIl];
                if (lIllIIIlIlIIlII <= 0) {
                    Config.warn(String.valueOf(new StringBuilder("Invalid item ID: ").append(lIllIIIlIlIIlII)));
                }
                else {
                    addToList(lIllIIIlIlIIlll, lIllIIIlIlIIIlI, lIllIIIlIlIIlII);
                }
            }
        }
    }
    
    public static boolean bindCustomArmorTexture(final ItemStack lIllIIIIllllIlI, final int lIllIIIIlllIlIl, final String lIllIIIIlllIlII) {
        if (CustomItems.itemProperties == null) {
            return false;
        }
        final ResourceLocation lIllIIIIlllIlll = getCustomArmorLocation(lIllIIIIllllIlI, lIllIIIIlllIlIl, lIllIIIIlllIlII);
        if (lIllIIIIlllIlll == null) {
            return false;
        }
        Config.getTextureManager().bindTexture(lIllIIIIlllIlll);
        return true;
    }
    
    static {
        DEFAULT_TEXTURE_SPLASH = "items/potion_bottle_splash";
        MASK_POTION_NAME = 63;
        DEFAULT_TEXTURE_OVERLAY = "items/potion_overlay";
        KEY_TEXTURE_OVERLAY = "texture.potion_overlay";
        KEY_TEXTURE_SPLASH = "texture.potion_bottle_splash";
        DEFAULT_TEXTURE_DRINKABLE = "items/potion_bottle_drinkable";
        MASK_POTION_SPLASH = 16384;
        KEY_TEXTURE_DRINKABLE = "texture.potion_bottle_drinkable";
        CustomItems.itemProperties = null;
        CustomItems.enchantmentProperties = null;
        CustomItems.mapPotionIds = null;
        CustomItems.itemModelGenerator = new ItemModelGenerator();
        CustomItems.useGlint = true;
        EMPTY_INT_ARRAY = new int[0];
        EMPTY_INT2_ARRAY = new int[0][];
    }
    
    private static int getPotionNameDamage(final String lIllIIIllIlIlIl) {
        final String lIllIIIllIlIlII = String.valueOf(new StringBuilder("potion.").append(lIllIIIllIlIlIl));
        final Potion[] lIllIIIllIlIIll = Potion.potionTypes;
        for (int lIllIIIllIlIIlI = 0; lIllIIIllIlIIlI < lIllIIIllIlIIll.length; ++lIllIIIllIlIIlI) {
            final Potion lIllIIIllIlIIIl = lIllIIIllIlIIll[lIllIIIllIlIIlI];
            if (lIllIIIllIlIIIl != null) {
                final String lIllIIIllIlIIII = lIllIIIllIlIIIl.getName();
                if (lIllIIIllIlIlII.equals(lIllIIIllIlIIII)) {
                    return lIllIIIllIlIIIl.getId();
                }
            }
        }
        return -1;
    }
    
    private static boolean matchesProperties(final CustomItemProperties lIllIIIIIlIIlIl, final ItemStack lIllIIIIIlIIlII, final int[][] lIllIIIIIlIIIll) {
        final Item lIllIIIIIllIIlI = lIllIIIIIlIIlII.getItem();
        if (lIllIIIIIlIIlIl.damage != null) {
            int lIllIIIIIllIIIl = lIllIIIIIlIIlII.getItemDamage();
            if (lIllIIIIIlIIlIl.damageMask != 0) {
                lIllIIIIIllIIIl &= lIllIIIIIlIIlIl.damageMask;
            }
            if (lIllIIIIIlIIlIl.damagePercent) {
                final int lIllIIIIIllIIII = lIllIIIIIllIIlI.getMaxDamage();
                lIllIIIIIllIIIl = (int)(lIllIIIIIllIIIl * 100 / (double)lIllIIIIIllIIII);
            }
            if (!lIllIIIIIlIIlIl.damage.isInRange(lIllIIIIIllIIIl)) {
                return false;
            }
        }
        if (lIllIIIIIlIIlIl.stackSize != null && !lIllIIIIIlIIlIl.stackSize.isInRange(lIllIIIIIlIIlII.stackSize)) {
            return false;
        }
        int[][] lIllIIIIIlIllll = lIllIIIIIlIIIll;
        if (lIllIIIIIlIIlIl.enchantmentIds != null) {
            if (lIllIIIIIlIIIll == null) {
                lIllIIIIIlIllll = getEnchantmentIdLevels(lIllIIIIIlIIlII);
            }
            boolean lIllIIIIIlIlIIl = false;
            for (int lIllIIIIIlIlllI = 0; lIllIIIIIlIlllI < lIllIIIIIlIllll.length; ++lIllIIIIIlIlllI) {
                final int lIllIIIIIlIlIll = lIllIIIIIlIllll[lIllIIIIIlIlllI][0];
                if (lIllIIIIIlIIlIl.enchantmentIds.isInRange(lIllIIIIIlIlIll)) {
                    lIllIIIIIlIlIIl = true;
                    break;
                }
            }
            if (!lIllIIIIIlIlIIl) {
                return false;
            }
        }
        if (lIllIIIIIlIIlIl.enchantmentLevels != null) {
            if (lIllIIIIIlIllll == null) {
                lIllIIIIIlIllll = getEnchantmentIdLevels(lIllIIIIIlIIlII);
            }
            boolean lIllIIIIIlIlIII = false;
            for (int lIllIIIIIlIllIl = 0; lIllIIIIIlIllIl < lIllIIIIIlIllll.length; ++lIllIIIIIlIllIl) {
                final int lIllIIIIIlIlIlI = lIllIIIIIlIllll[lIllIIIIIlIllIl][1];
                if (lIllIIIIIlIIlIl.enchantmentLevels.isInRange(lIllIIIIIlIlIlI)) {
                    lIllIIIIIlIlIII = true;
                    break;
                }
            }
            if (!lIllIIIIIlIlIII) {
                return false;
            }
        }
        if (lIllIIIIIlIIlIl.nbtTagValues != null) {
            final NBTTagCompound lIllIIIIIlIIlll = lIllIIIIIlIIlII.getTagCompound();
            for (int lIllIIIIIlIllII = 0; lIllIIIIIlIllII < lIllIIIIIlIIlIl.nbtTagValues.length; ++lIllIIIIIlIllII) {
                final NbtTagValue lIllIIIIIlIIllI = lIllIIIIIlIIlIl.nbtTagValues[lIllIIIIIlIllII];
                if (!lIllIIIIIlIIllI.matches(lIllIIIIIlIIlll)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void updateIcons(final TextureMap lIllIIlIlllIlll) {
        CustomItems.itemProperties = null;
        CustomItems.enchantmentProperties = null;
        CustomItems.useGlint = true;
        if (Config.isCustomItems()) {
            readCitProperties("mcpatcher/cit.properties");
            final IResourcePack[] lIllIIlIllllIlI = Config.getResourcePacks();
            for (int lIllIIlIllllIIl = lIllIIlIllllIlI.length - 1; lIllIIlIllllIIl >= 0; --lIllIIlIllllIIl) {
                final IResourcePack lIllIIlIllllIII = lIllIIlIllllIlI[lIllIIlIllllIIl];
                updateIcons(lIllIIlIlllIlll, lIllIIlIllllIII);
            }
            updateIcons(lIllIIlIlllIlll, Config.getDefaultResourcePack());
            if (CustomItems.itemProperties.length <= 0) {
                CustomItems.itemProperties = null;
            }
            if (CustomItems.enchantmentProperties.length <= 0) {
                CustomItems.enchantmentProperties = null;
            }
        }
    }
    
    private static void addToEnchantmentList(final CustomItemProperties lIllIIIlIIllIIl, final List lIllIIIlIIllIll) {
        if (lIllIIIlIIllIIl.type == 2 && lIllIIIlIIllIIl.enchantmentIds != null) {
            for (int lIllIIIlIIllIlI = 0; lIllIIIlIIllIlI < 256; ++lIllIIIlIIllIlI) {
                if (lIllIIIlIIllIIl.enchantmentIds.isInRange(lIllIIIlIIllIlI)) {
                    addToList(lIllIIIlIIllIIl, lIllIIIlIIllIll, lIllIIIlIIllIlI);
                }
            }
        }
    }
}
