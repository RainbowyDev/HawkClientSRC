package optifine;

import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.util.*;
import java.util.*;

public class DynamicLights
{
    private static /* synthetic */ long timeUpdateMs;
    private static /* synthetic */ Map<Integer, DynamicLight> mapDynamicLights;
    
    public static int getLightLevel(final Entity lIIIIIIllIIl) {
        if (lIIIIIIllIIl == Config.getMinecraft().func_175606_aa() && !Config.isDynamicHandLight()) {
            return 0;
        }
        if (lIIIIIIllIIl instanceof EntityPlayer) {
            final EntityPlayer lIIIIIIllIII = (EntityPlayer)lIIIIIIllIIl;
            if (lIIIIIIllIII.func_175149_v()) {
                return 0;
            }
        }
        if (lIIIIIIllIIl.isBurning()) {
            return 15;
        }
        if (lIIIIIIllIIl instanceof EntityFireball) {
            return 15;
        }
        if (lIIIIIIllIIl instanceof EntityTNTPrimed) {
            return 15;
        }
        if (lIIIIIIllIIl instanceof EntityBlaze) {
            final EntityBlaze lIIIIIIlIlll = (EntityBlaze)lIIIIIIllIIl;
            return lIIIIIIlIlll.func_70845_n() ? 15 : 10;
        }
        if (lIIIIIIllIIl instanceof EntityMagmaCube) {
            final EntityMagmaCube lIIIIIIlIllI = (EntityMagmaCube)lIIIIIIllIIl;
            return (lIIIIIIlIllI.squishFactor > 0.6) ? 13 : 8;
        }
        if (lIIIIIIllIIl instanceof EntityCreeper) {
            final EntityCreeper lIIIIIIlIlIl = (EntityCreeper)lIIIIIIllIIl;
            if (lIIIIIIlIlIl.getCreeperFlashIntensity(0.0f) > 0.001) {
                return 15;
            }
        }
        if (lIIIIIIllIIl instanceof EntityLivingBase) {
            final EntityLivingBase lIIIIIIlIIlI = (EntityLivingBase)lIIIIIIllIIl;
            final ItemStack lIIIIIIlIlII = lIIIIIIlIIlI.getHeldItem();
            final int lIIIIIIlIIIl = getLightLevel(lIIIIIIlIlII);
            final ItemStack lIIIIIIlIIII = lIIIIIIlIIlI.getEquipmentInSlot(4);
            final int lIIIIIIIllll = getLightLevel(lIIIIIIlIIII);
            return Math.max(lIIIIIIlIIIl, lIIIIIIIllll);
        }
        if (lIIIIIIllIIl instanceof EntityItem) {
            final EntityItem lIIIIIIIlllI = (EntityItem)lIIIIIIllIIl;
            final ItemStack lIIIIIIlIIll = getItemStack(lIIIIIIIlllI);
            return getLightLevel(lIIIIIIlIIll);
        }
        return 0;
    }
    
    public static void update(final RenderGlobal lIIIlIlIIIII) {
        final long lIIIlIlIIlIl = System.currentTimeMillis();
        if (lIIIlIlIIlIl >= DynamicLights.timeUpdateMs + 50L) {
            DynamicLights.timeUpdateMs = lIIIlIlIIlIl;
            final Map lIIIlIlIIlII = DynamicLights.mapDynamicLights;
            synchronized (DynamicLights.mapDynamicLights) {
                updateMapDynamicLights(lIIIlIlIIIII);
                if (DynamicLights.mapDynamicLights.size() > 0) {
                    final Collection lIIIlIlIIIll = DynamicLights.mapDynamicLights.values();
                    for (final DynamicLight lIIIlIlIIIIl : lIIIlIlIIIll) {
                        lIIIlIlIIIIl.update(lIIIlIlIIIII);
                    }
                }
            }
            // monitorexit(DynamicLights.mapDynamicLights)
        }
    }
    
    public static int getLightLevel(final ItemStack lIIIIIlIIIll) {
        if (lIIIIIlIIIll == null) {
            return 0;
        }
        final Item lIIIIIlIIllI = lIIIIIlIIIll.getItem();
        if (lIIIIIlIIllI instanceof ItemBlock) {
            final ItemBlock lIIIIIlIIlIl = (ItemBlock)lIIIIIlIIllI;
            final Block lIIIIIlIIlII = lIIIIIlIIlIl.getBlock();
            if (lIIIIIlIIlII != null) {
                return lIIIIIlIIlII.getLightValue();
            }
        }
        return (lIIIIIlIIllI == Items.lava_bucket) ? Blocks.lava.getLightValue() : ((lIIIIIlIIllI != Items.blaze_rod && lIIIIIlIIllI != Items.blaze_powder) ? ((lIIIIIlIIllI == Items.glowstone_dust) ? 8 : ((lIIIIIlIIllI == Items.prismarine_crystals) ? 8 : ((lIIIIIlIIllI == Items.magma_cream) ? 8 : ((lIIIIIlIIllI == Items.nether_star) ? (Blocks.beacon.getLightValue() / 2) : 0)))) : 10);
    }
    
    public static void entityAdded(final Entity lIIIlIllllIl, final RenderGlobal lIIIlIllllII) {
    }
    
    public static int getCombinedLight(final double lIIIIllIIlIl, int lIIIIllIIlII) {
        if (lIIIIllIIlIl > 0.0) {
            final int lIIIIllIIlll = (int)(lIIIIllIIlIl * 16.0);
            final int lIIIIllIIllI = lIIIIllIIlII & 0xFF;
            if (lIIIIllIIlll > lIIIIllIIllI) {
                lIIIIllIIlII &= 0xFFFFFF00;
                lIIIIllIIlII |= lIIIIllIIlll;
            }
        }
        return lIIIIllIIlII;
    }
    
    private static void updateMapDynamicLights(final RenderGlobal lIIIlIIIIlll) {
        final WorldClient lIIIlIIlIIII = lIIIlIIIIlll.getWorld();
        if (lIIIlIIlIIII != null) {
            final List lIIIlIIIllll = lIIIlIIlIIII.getLoadedEntityList();
            for (final Entity lIIIlIIIllIl : lIIIlIIIllll) {
                final int lIIIlIIIllII = getLightLevel(lIIIlIIIllIl);
                if (lIIIlIIIllII > 0) {
                    final Integer lIIIlIIIlIll = IntegerCache.valueOf(lIIIlIIIllIl.getEntityId());
                    DynamicLight lIIIlIIIlIIl = DynamicLights.mapDynamicLights.get(lIIIlIIIlIll);
                    if (lIIIlIIIlIIl != null) {
                        continue;
                    }
                    lIIIlIIIlIIl = new DynamicLight(lIIIlIIIllIl);
                    DynamicLights.mapDynamicLights.put(lIIIlIIIlIll, lIIIlIIIlIIl);
                }
                else {
                    final Integer lIIIlIIIlIlI = IntegerCache.valueOf(lIIIlIIIllIl.getEntityId());
                    final DynamicLight lIIIlIIIlIII = DynamicLights.mapDynamicLights.remove(lIIIlIIIlIlI);
                    if (lIIIlIIIlIII == null) {
                        continue;
                    }
                    lIIIlIIIlIII.updateLitChunks(lIIIlIIIIlll);
                }
            }
        }
    }
    
    public static int getCount() {
        final Map llllllIllll = DynamicLights.mapDynamicLights;
        synchronized (DynamicLights.mapDynamicLights) {
            // monitorexit(DynamicLights.mapDynamicLights)
            return DynamicLights.mapDynamicLights.size();
        }
    }
    
    public static void removeLights(final RenderGlobal lIIIIIIIIIIl) {
        final Map lIIIIIIIIIII = DynamicLights.mapDynamicLights;
        synchronized (DynamicLights.mapDynamicLights) {
            final Collection lllllllllll = DynamicLights.mapDynamicLights.values();
            final Iterator llllllllllI = lllllllllll.iterator();
            while (llllllllllI.hasNext()) {
                final DynamicLight lllllllllIl = llllllllllI.next();
                llllllllllI.remove();
                lllllllllIl.updateLitChunks(lIIIIIIIIIIl);
            }
        }
        // monitorexit(DynamicLights.mapDynamicLights)
    }
    
    public static double getLightLevel(final BlockPos lIIIIIllllIl) {
        double lIIIIlIIlllI = 0.0;
        final Map lIIIIlIIllIl = DynamicLights.mapDynamicLights;
        synchronized (DynamicLights.mapDynamicLights) {
            final Collection lIIIIlIIllII = DynamicLights.mapDynamicLights.values();
            for (final DynamicLight lIIIIlIIlIlI : lIIIIlIIllII) {
                int lIIIIlIIlIIl = lIIIIlIIlIlI.getLastLightLevel();
                if (lIIIIlIIlIIl > 0) {
                    final double lIIIIlIIlIII = lIIIIlIIlIlI.getLastPosX();
                    final double lIIIIlIIIlll = lIIIIlIIlIlI.getLastPosY();
                    final double lIIIIlIIIllI = lIIIIlIIlIlI.getLastPosZ();
                    final double lIIIIlIIIlIl = lIIIIIllllIl.getX() - lIIIIlIIlIII;
                    final double lIIIIlIIIlII = lIIIIIllllIl.getY() - lIIIIlIIIlll;
                    final double lIIIIlIIIIll = lIIIIIllllIl.getZ() - lIIIIlIIIllI;
                    double lIIIIlIIIIlI = lIIIIlIIIlIl * lIIIIlIIIlIl + lIIIIlIIIlII * lIIIIlIIIlII + lIIIIlIIIIll * lIIIIlIIIIll;
                    if (lIIIIlIIlIlI.isUnderwater() && !Config.isClearWater()) {
                        lIIIIlIIlIIl = Config.limit(lIIIIlIIlIIl - 2, 0, 15);
                        lIIIIlIIIIlI *= 2.0;
                    }
                    if (lIIIIlIIIIlI > 56.25) {
                        continue;
                    }
                    final double lIIIIlIIIIIl = Math.sqrt(lIIIIlIIIIlI);
                    final double lIIIIlIIIIII = 1.0 - lIIIIlIIIIIl / 7.5;
                    final double lIIIIIllllll = lIIIIlIIIIII * lIIIIlIIlIIl;
                    if (lIIIIIllllll <= lIIIIlIIlllI) {
                        continue;
                    }
                    lIIIIlIIlllI = lIIIIIllllll;
                }
            }
        }
        // monitorexit(DynamicLights.mapDynamicLights)
        final double lIIIIIlllllI = Config.limit(lIIIIlIIlllI, 0.0, 15.0);
        return lIIIIIlllllI;
    }
    
    static {
        LIGHT_LEVEL_MAGMA_CUBE_CORE = 13;
        LIGHT_LEVEL_GLOWSTONE_DUST = 8;
        LIGHT_LEVEL_MAX = 15;
        LIGHT_LEVEL_FIRE = 15;
        LIGHT_LEVEL_PRISMARINE_CRYSTALS = 8;
        LIGHT_LEVEL_BLAZE = 10;
        LIGHT_LEVEL_MAGMA_CUBE = 8;
        DynamicLights.mapDynamicLights = new HashMap<Integer, DynamicLight>();
        DynamicLights.timeUpdateMs = 0L;
    }
    
    public static void clear() {
        final Map lllllllIlII = DynamicLights.mapDynamicLights;
        synchronized (DynamicLights.mapDynamicLights) {
            DynamicLights.mapDynamicLights.clear();
        }
        // monitorexit(DynamicLights.mapDynamicLights)
    }
    
    public static void entityRemoved(final Entity lIIIlIllIllI, final RenderGlobal lIIIlIllIIIl) {
        final Map lIIIlIllIlII = DynamicLights.mapDynamicLights;
        synchronized (DynamicLights.mapDynamicLights) {
            final DynamicLight lIIIlIllIIll = DynamicLights.mapDynamicLights.remove(IntegerCache.valueOf(lIIIlIllIllI.getEntityId()));
            if (lIIIlIllIIll != null) {
                lIIIlIllIIll.updateLitChunks(lIIIlIllIIIl);
            }
        }
        // monitorexit(DynamicLights.mapDynamicLights)
    }
    
    public static int getCombinedLight(final Entity lIIIIlllIIII, int lIIIIllIllll) {
        final double lIIIIlllIIIl = getLightLevel(lIIIIlllIIII);
        lIIIIllIllll = getCombinedLight(lIIIIlllIIIl, lIIIIllIllll);
        return lIIIIllIllll;
    }
    
    public static int getCombinedLight(final BlockPos lIIIIlllllII, int lIIIIllllIII) {
        final double lIIIIllllIlI = getLightLevel(lIIIIlllllII);
        lIIIIllllIII = (getCombinedLight(lIIIIllllIlI, lIIIIllllIII ? 1 : 0) != 0);
        return lIIIIllllIII ? 1 : 0;
    }
    
    public static ItemStack getItemStack(final EntityItem llllllIlIII) {
        final ItemStack llllllIlIIl = llllllIlIII.getDataWatcher().getWatchableObjectItemStack(10);
        return llllllIlIIl;
    }
}
