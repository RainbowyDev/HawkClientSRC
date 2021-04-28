package net.minecraft.client.particle;

import com.google.common.collect.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import java.util.concurrent.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;

public class EffectRenderer
{
    private /* synthetic */ List[][] fxLayers;
    private /* synthetic */ TextureManager renderer;
    private /* synthetic */ Map field_178932_g;
    protected /* synthetic */ World worldObj;
    private static final /* synthetic */ ResourceLocation particleTextures;
    private /* synthetic */ List field_178933_d;
    private /* synthetic */ Random rand;
    
    public EffectRenderer(final World lllllllllllllllIIlIIlIlIllIlllII, final TextureManager lllllllllllllllIIlIIlIlIllIllIll) {
        this.fxLayers = new List[4][];
        this.field_178933_d = Lists.newArrayList();
        this.rand = new Random();
        this.field_178932_g = Maps.newHashMap();
        this.worldObj = lllllllllllllllIIlIIlIlIllIlllII;
        this.renderer = lllllllllllllllIIlIIlIlIllIllIll;
        for (int lllllllllllllllIIlIIlIlIllIllIlI = 0; lllllllllllllllIIlIIlIlIllIllIlI < 4; ++lllllllllllllllIIlIIlIlIllIllIlI) {
            this.fxLayers[lllllllllllllllIIlIIlIlIllIllIlI] = new List[2];
            for (int lllllllllllllllIIlIIlIlIllIllIIl = 0; lllllllllllllllIIlIIlIlIllIllIIl < 2; ++lllllllllllllllIIlIIlIlIllIllIIl) {
                this.fxLayers[lllllllllllllllIIlIIlIlIllIllIlI][lllllllllllllllIIlIIlIlIllIllIIl] = Lists.newArrayList();
            }
        }
        this.func_178930_c();
    }
    
    private void func_178924_a(final EntityFX lllllllllllllllIIlIIlIIllIIlIIlI, final int lllllllllllllllIIlIIlIIllIIIllII, final int lllllllllllllllIIlIIlIIllIIlIIII) {
        for (int lllllllllllllllIIlIIlIIllIIIllll = 0; lllllllllllllllIIlIIlIIllIIIllll < 4; ++lllllllllllllllIIlIIlIIllIIIllll) {
            if (this.fxLayers[lllllllllllllllIIlIIlIIllIIIllll][lllllllllllllllIIlIIlIIllIIIllII].contains(lllllllllllllllIIlIIlIIllIIlIIlI)) {
                this.fxLayers[lllllllllllllllIIlIIlIIllIIIllll][lllllllllllllllIIlIIlIIllIIIllII].remove(lllllllllllllllIIlIIlIIllIIlIIlI);
                this.fxLayers[lllllllllllllllIIlIIlIIllIIIllll][lllllllllllllllIIlIIlIIllIIlIIII].add(lllllllllllllllIIlIIlIIllIIlIIlI);
            }
        }
    }
    
    private void func_178925_a(final List lllllllllllllllIIlIIlIlIIlllIIII) {
        final ArrayList lllllllllllllllIIlIIlIlIIlllIlII = Lists.newArrayList();
        for (int lllllllllllllllIIlIIlIlIIlllIIll = 0; lllllllllllllllIIlIIlIlIIlllIIll < lllllllllllllllIIlIIlIlIIlllIIII.size(); ++lllllllllllllllIIlIIlIlIIlllIIll) {
            final EntityFX lllllllllllllllIIlIIlIlIIlllIIlI = lllllllllllllllIIlIIlIlIIlllIIII.get(lllllllllllllllIIlIIlIlIIlllIIll);
            this.func_178923_d(lllllllllllllllIIlIIlIlIIlllIIlI);
            if (lllllllllllllllIIlIIlIlIIlllIIlI.isDead) {
                lllllllllllllllIIlIIlIlIIlllIlII.add(lllllllllllllllIIlIIlIlIIlllIIlI);
            }
        }
        lllllllllllllllIIlIIlIlIIlllIIII.removeAll(lllllllllllllllIIlIIlIlIIlllIlII);
    }
    
    public EntityFX func_178927_a(final int lllllllllllllllIIlIIlIlIlIllIIlI, final double lllllllllllllllIIlIIlIlIlIlIIlIl, final double lllllllllllllllIIlIIlIlIlIlIIlII, final double lllllllllllllllIIlIIlIlIlIlIIIll, final double lllllllllllllllIIlIIlIlIlIlIIIlI, final double lllllllllllllllIIlIIlIlIlIlIIIIl, final double lllllllllllllllIIlIIlIlIlIlIllII, final int... lllllllllllllllIIlIIlIlIlIIlllll) {
        final IParticleFactory lllllllllllllllIIlIIlIlIlIlIlIlI = this.field_178932_g.get(lllllllllllllllIIlIIlIlIlIllIIlI);
        if (lllllllllllllllIIlIIlIlIlIlIlIlI != null) {
            final EntityFX lllllllllllllllIIlIIlIlIlIlIlIIl = lllllllllllllllIIlIIlIlIlIlIlIlI.func_178902_a(lllllllllllllllIIlIIlIlIlIllIIlI, this.worldObj, lllllllllllllllIIlIIlIlIlIlIIlIl, lllllllllllllllIIlIIlIlIlIlIIlII, lllllllllllllllIIlIIlIlIlIlIIIll, lllllllllllllllIIlIIlIlIlIlIIIlI, lllllllllllllllIIlIIlIlIlIlIIIIl, lllllllllllllllIIlIIlIlIlIlIllII, lllllllllllllllIIlIIlIlIlIIlllll);
            if (lllllllllllllllIIlIIlIlIlIlIlIIl != null) {
                this.addEffect(lllllllllllllllIIlIIlIlIlIlIlIIl);
                return lllllllllllllllIIlIIlIlIlIlIlIIl;
            }
        }
        return null;
    }
    
    public String getStatistics() {
        int lllllllllllllllIIlIIlIIllIIIIlII = 0;
        for (int lllllllllllllllIIlIIlIIllIIIIIll = 0; lllllllllllllllIIlIIlIIllIIIIIll < 4; ++lllllllllllllllIIlIIlIIllIIIIIll) {
            for (int lllllllllllllllIIlIIlIIllIIIIIlI = 0; lllllllllllllllIIlIIlIIllIIIIIlI < 2; ++lllllllllllllllIIlIIlIIllIIIIIlI) {
                lllllllllllllllIIlIIlIIllIIIIlII += this.fxLayers[lllllllllllllllIIlIIlIIllIIIIIll][lllllllllllllllIIlIIlIIllIIIIIlI].size();
            }
        }
        return String.valueOf(new StringBuilder().append(lllllllllllllllIIlIIlIIllIIIIlII));
    }
    
    private boolean reuseBarrierParticle(final EntityFX lllllllllllllllIIlIIlIIlIllllIII, final List<EntityFX> lllllllllllllllIIlIIlIIlIlllIIll) {
        for (final EntityFX lllllllllllllllIIlIIlIIlIlllIlIl : lllllllllllllllIIlIIlIIlIlllIIll) {
            if (lllllllllllllllIIlIIlIIlIlllIlIl instanceof Barrier && lllllllllllllllIIlIIlIIlIllllIII.posX == lllllllllllllllIIlIIlIIlIlllIlIl.posX && lllllllllllllllIIlIIlIIlIllllIII.posY == lllllllllllllllIIlIIlIIlIlllIlIl.posY && lllllllllllllllIIlIIlIIlIllllIII.posZ == lllllllllllllllIIlIIlIIlIlllIlIl.posZ) {
                lllllllllllllllIIlIIlIIlIlllIlIl.particleAge = 0;
                return true;
            }
        }
        return false;
    }
    
    private void func_178930_c() {
        this.func_178929_a(EnumParticleTypes.EXPLOSION_NORMAL.func_179348_c(), new EntityExplodeFX.Factory());
        this.func_178929_a(EnumParticleTypes.WATER_BUBBLE.func_179348_c(), new EntityBubbleFX.Factory());
        this.func_178929_a(EnumParticleTypes.WATER_SPLASH.func_179348_c(), new EntitySplashFX.Factory());
        this.func_178929_a(EnumParticleTypes.WATER_WAKE.func_179348_c(), new EntityFishWakeFX.Factory());
        this.func_178929_a(EnumParticleTypes.WATER_DROP.func_179348_c(), new EntityRainFX.Factory());
        this.func_178929_a(EnumParticleTypes.SUSPENDED.func_179348_c(), new EntitySuspendFX.Factory());
        this.func_178929_a(EnumParticleTypes.SUSPENDED_DEPTH.func_179348_c(), new EntityAuraFX.Factory());
        this.func_178929_a(EnumParticleTypes.CRIT.func_179348_c(), new EntityCrit2FX.Factory());
        this.func_178929_a(EnumParticleTypes.CRIT_MAGIC.func_179348_c(), new EntityCrit2FX.MagicFactory());
        this.func_178929_a(EnumParticleTypes.SMOKE_NORMAL.func_179348_c(), new EntitySmokeFX.Factory());
        this.func_178929_a(EnumParticleTypes.SMOKE_LARGE.func_179348_c(), new EntityCritFX.Factory());
        this.func_178929_a(EnumParticleTypes.SPELL.func_179348_c(), new EntitySpellParticleFX.Factory());
        this.func_178929_a(EnumParticleTypes.SPELL_INSTANT.func_179348_c(), new EntitySpellParticleFX.InstantFactory());
        this.func_178929_a(EnumParticleTypes.SPELL_MOB.func_179348_c(), new EntitySpellParticleFX.MobFactory());
        this.func_178929_a(EnumParticleTypes.SPELL_MOB_AMBIENT.func_179348_c(), new EntitySpellParticleFX.AmbientMobFactory());
        this.func_178929_a(EnumParticleTypes.SPELL_WITCH.func_179348_c(), new EntitySpellParticleFX.WitchFactory());
        this.func_178929_a(EnumParticleTypes.DRIP_WATER.func_179348_c(), new EntityDropParticleFX.WaterFactory());
        this.func_178929_a(EnumParticleTypes.DRIP_LAVA.func_179348_c(), new EntityDropParticleFX.LavaFactory());
        this.func_178929_a(EnumParticleTypes.VILLAGER_ANGRY.func_179348_c(), new EntityHeartFX.AngryVillagerFactory());
        this.func_178929_a(EnumParticleTypes.VILLAGER_HAPPY.func_179348_c(), new EntityAuraFX.HappyVillagerFactory());
        this.func_178929_a(EnumParticleTypes.TOWN_AURA.func_179348_c(), new EntityAuraFX.Factory());
        this.func_178929_a(EnumParticleTypes.NOTE.func_179348_c(), new EntityNoteFX.Factory());
        this.func_178929_a(EnumParticleTypes.PORTAL.func_179348_c(), new EntityPortalFX.Factory());
        this.func_178929_a(EnumParticleTypes.ENCHANTMENT_TABLE.func_179348_c(), new EntityEnchantmentTableParticleFX.EnchantmentTable());
        this.func_178929_a(EnumParticleTypes.FLAME.func_179348_c(), new EntityFlameFX.Factory());
        this.func_178929_a(EnumParticleTypes.LAVA.func_179348_c(), new EntityLavaFX.Factory());
        this.func_178929_a(EnumParticleTypes.FOOTSTEP.func_179348_c(), new EntityFootStepFX.Factory());
        this.func_178929_a(EnumParticleTypes.CLOUD.func_179348_c(), new EntityCloudFX.Factory());
        this.func_178929_a(EnumParticleTypes.REDSTONE.func_179348_c(), new EntityReddustFX.Factory());
        this.func_178929_a(EnumParticleTypes.SNOWBALL.func_179348_c(), new EntityBreakingFX.SnowballFactory());
        this.func_178929_a(EnumParticleTypes.SNOW_SHOVEL.func_179348_c(), new EntitySnowShovelFX.Factory());
        this.func_178929_a(EnumParticleTypes.SLIME.func_179348_c(), new EntityBreakingFX.SlimeFactory());
        this.func_178929_a(EnumParticleTypes.HEART.func_179348_c(), new EntityHeartFX.Factory());
        this.func_178929_a(EnumParticleTypes.BARRIER.func_179348_c(), new Barrier.Factory());
        this.func_178929_a(EnumParticleTypes.ITEM_CRACK.func_179348_c(), new EntityBreakingFX.Factory());
        this.func_178929_a(EnumParticleTypes.BLOCK_CRACK.func_179348_c(), new EntityDiggingFX.Factory());
        this.func_178929_a(EnumParticleTypes.BLOCK_DUST.func_179348_c(), new EntityBlockDustFX.Factory());
        this.func_178929_a(EnumParticleTypes.EXPLOSION_HUGE.func_179348_c(), new EntityHugeExplodeFX.Factory());
        this.func_178929_a(EnumParticleTypes.EXPLOSION_LARGE.func_179348_c(), new EntityLargeExplodeFX.Factory());
        this.func_178929_a(EnumParticleTypes.FIREWORKS_SPARK.func_179348_c(), new EntityFireworkStarterFX_Factory());
        this.func_178929_a(EnumParticleTypes.MOB_APPEARANCE.func_179348_c(), new MobAppearance.Factory());
    }
    
    public void addBlockHitEffects(final BlockPos lllllllllllllllIIlIIlIIlIllIlIlI, final MovingObjectPosition lllllllllllllllIIlIIlIIlIllIlIIl) {
        final Block lllllllllllllllIIlIIlIIlIllIlIII = this.worldObj.getBlockState(lllllllllllllllIIlIIlIIlIllIlIlI).getBlock();
        final boolean lllllllllllllllIIlIIlIIlIllIIlll = Reflector.callBoolean(lllllllllllllllIIlIIlIIlIllIlIII, Reflector.ForgeBlock_addHitEffects, this.worldObj, lllllllllllllllIIlIIlIIlIllIlIIl, this);
        if (lllllllllllllllIIlIIlIIlIllIlIII != null && !lllllllllllllllIIlIIlIIlIllIIlll) {
            this.func_180532_a(lllllllllllllllIIlIIlIIlIllIlIlI, lllllllllllllllIIlIIlIIlIllIlIIl.field_178784_b);
        }
    }
    
    private void func_178922_a(final int lllllllllllllllIIlIIlIlIIlllllIl) {
        for (int lllllllllllllllIIlIIlIlIIlllllll = 0; lllllllllllllllIIlIIlIlIIlllllll < 2; ++lllllllllllllllIIlIIlIlIIlllllll) {
            this.func_178925_a(this.fxLayers[lllllllllllllllIIlIIlIlIIlllllIl][lllllllllllllllIIlIIlIlIIlllllll]);
        }
    }
    
    public void clearEffects(final World lllllllllllllllIIlIIlIIllllIlllI) {
        this.worldObj = lllllllllllllllIIlIIlIIllllIlllI;
        for (int lllllllllllllllIIlIIlIIlllllIIIl = 0; lllllllllllllllIIlIIlIIlllllIIIl < 4; ++lllllllllllllllIIlIIlIIlllllIIIl) {
            for (int lllllllllllllllIIlIIlIIlllllIIII = 0; lllllllllllllllIIlIIlIIlllllIIII < 2; ++lllllllllllllllIIlIIlIIlllllIIII) {
                this.fxLayers[lllllllllllllllIIlIIlIIlllllIIIl][lllllllllllllllIIlIIlIIlllllIIII].clear();
            }
        }
        this.field_178933_d.clear();
    }
    
    static {
        __OBFID = "CL_00000915";
        particleTextures = new ResourceLocation("textures/particle/particles.png");
    }
    
    public void func_178929_a(final int lllllllllllllllIIlIIlIlIllIIllII, final IParticleFactory lllllllllllllllIIlIIlIlIllIIlIII) {
        this.field_178932_g.put(lllllllllllllllIIlIIlIlIllIIllII, lllllllllllllllIIlIIlIlIllIIlIII);
    }
    
    public void renderLitParticles(final Entity lllllllllllllllIIlIIlIlIIIIIIlIl, final float lllllllllllllllIIlIIlIlIIIIIIlII) {
        final float lllllllllllllllIIlIIlIlIIIIlIIlI = 0.017453292f;
        final float lllllllllllllllIIlIIlIlIIIIlIIIl = MathHelper.cos(lllllllllllllllIIlIIlIlIIIIIIlIl.rotationYaw * 0.017453292f);
        final float lllllllllllllllIIlIIlIlIIIIlIIII = MathHelper.sin(lllllllllllllllIIlIIlIlIIIIIIlIl.rotationYaw * 0.017453292f);
        final float lllllllllllllllIIlIIlIlIIIIIllll = -lllllllllllllllIIlIIlIlIIIIlIIII * MathHelper.sin(lllllllllllllllIIlIIlIlIIIIIIlIl.rotationPitch * 0.017453292f);
        final float lllllllllllllllIIlIIlIlIIIIIlllI = lllllllllllllllIIlIIlIlIIIIlIIIl * MathHelper.sin(lllllllllllllllIIlIIlIlIIIIIIlIl.rotationPitch * 0.017453292f);
        final float lllllllllllllllIIlIIlIlIIIIIllIl = MathHelper.cos(lllllllllllllllIIlIIlIlIIIIIIlIl.rotationPitch * 0.017453292f);
        for (int lllllllllllllllIIlIIlIlIIIIIllII = 0; lllllllllllllllIIlIIlIlIIIIIllII < 2; ++lllllllllllllllIIlIIlIlIIIIIllII) {
            final List lllllllllllllllIIlIIlIlIIIIIlIll = this.fxLayers[3][lllllllllllllllIIlIIlIlIIIIIllII];
            if (!lllllllllllllllIIlIIlIlIIIIIlIll.isEmpty()) {
                final Tessellator lllllllllllllllIIlIIlIlIIIIIlIlI = Tessellator.getInstance();
                final WorldRenderer lllllllllllllllIIlIIlIlIIIIIlIIl = lllllllllllllllIIlIIlIlIIIIIlIlI.getWorldRenderer();
                for (int lllllllllllllllIIlIIlIlIIIIIlIII = 0; lllllllllllllllIIlIIlIlIIIIIlIII < lllllllllllllllIIlIIlIlIIIIIlIll.size(); ++lllllllllllllllIIlIIlIlIIIIIlIII) {
                    final EntityFX lllllllllllllllIIlIIlIlIIIIIIlll = lllllllllllllllIIlIIlIlIIIIIlIll.get(lllllllllllllllIIlIIlIlIIIIIlIII);
                    lllllllllllllllIIlIIlIlIIIIIlIIl.func_178963_b(lllllllllllllllIIlIIlIlIIIIIIlll.getBrightnessForRender(lllllllllllllllIIlIIlIlIIIIIIlII));
                    lllllllllllllllIIlIIlIlIIIIIIlll.func_180434_a(lllllllllllllllIIlIIlIlIIIIIlIIl, lllllllllllllllIIlIIlIlIIIIIIlIl, lllllllllllllllIIlIIlIlIIIIIIlII, lllllllllllllllIIlIIlIlIIIIlIIIl, lllllllllllllllIIlIIlIlIIIIIllIl, lllllllllllllllIIlIIlIlIIIIlIIII, lllllllllllllllIIlIIlIlIIIIIllll, lllllllllllllllIIlIIlIlIIIIIlllI);
                }
            }
        }
    }
    
    public void func_180533_a(final BlockPos lllllllllllllllIIlIIlIIlllIlllll, IBlockState lllllllllllllllIIlIIlIIlllIllllI) {
        boolean lllllllllllllllIIlIIlIIlllIlllII = false;
        if (Reflector.ForgeBlock_addDestroyEffects.exists() && Reflector.ForgeBlock_isAir.exists()) {
            final Block lllllllllllllllIIlIIlIIlllIllIll = lllllllllllllllIIlIIlIIlllIllllI.getBlock();
            Reflector.callBoolean(lllllllllllllllIIlIIlIIlllIllIll, Reflector.ForgeBlock_isAir, this.worldObj, lllllllllllllllIIlIIlIIlllIlllll);
            final boolean lllllllllllllllIIlIIlIIlllIlllIl = !Reflector.callBoolean(lllllllllllllllIIlIIlIIlllIllIll, Reflector.ForgeBlock_isAir, this.worldObj, lllllllllllllllIIlIIlIIlllIlllll) && !Reflector.callBoolean(lllllllllllllllIIlIIlIIlllIllIll, Reflector.ForgeBlock_addDestroyEffects, this.worldObj, lllllllllllllllIIlIIlIIlllIlllll, this);
        }
        else {
            lllllllllllllllIIlIIlIIlllIlllII = (lllllllllllllllIIlIIlIIlllIllllI.getBlock().getMaterial() != Material.air);
        }
        if (lllllllllllllllIIlIIlIIlllIlllII) {
            lllllllllllllllIIlIIlIIlllIllllI = lllllllllllllllIIlIIlIIlllIllllI.getBlock().getActualState(lllllllllllllllIIlIIlIIlllIllllI, this.worldObj, lllllllllllllllIIlIIlIIlllIlllll);
            final byte lllllllllllllllIIlIIlIIlllIllIlI = 4;
            for (int lllllllllllllllIIlIIlIIlllIllIIl = 0; lllllllllllllllIIlIIlIIlllIllIIl < lllllllllllllllIIlIIlIIlllIllIlI; ++lllllllllllllllIIlIIlIIlllIllIIl) {
                for (int lllllllllllllllIIlIIlIIlllIllIII = 0; lllllllllllllllIIlIIlIIlllIllIII < lllllllllllllllIIlIIlIIlllIllIlI; ++lllllllllllllllIIlIIlIIlllIllIII) {
                    for (int lllllllllllllllIIlIIlIIlllIlIlll = 0; lllllllllllllllIIlIIlIIlllIlIlll < lllllllllllllllIIlIIlIIlllIllIlI; ++lllllllllllllllIIlIIlIIlllIlIlll) {
                        final double lllllllllllllllIIlIIlIIlllIlIllI = lllllllllllllllIIlIIlIIlllIlllll.getX() + (lllllllllllllllIIlIIlIIlllIllIIl + 0.5) / lllllllllllllllIIlIIlIIlllIllIlI;
                        final double lllllllllllllllIIlIIlIIlllIlIlIl = lllllllllllllllIIlIIlIIlllIlllll.getY() + (lllllllllllllllIIlIIlIIlllIllIII + 0.5) / lllllllllllllllIIlIIlIIlllIllIlI;
                        final double lllllllllllllllIIlIIlIIlllIlIlII = lllllllllllllllIIlIIlIIlllIlllll.getZ() + (lllllllllllllllIIlIIlIIlllIlIlll + 0.5) / lllllllllllllllIIlIIlIIlllIllIlI;
                        this.addEffect(new EntityDiggingFX(this.worldObj, lllllllllllllllIIlIIlIIlllIlIllI, lllllllllllllllIIlIIlIIlllIlIlIl, lllllllllllllllIIlIIlIIlllIlIlII, lllllllllllllllIIlIIlIIlllIlIllI - lllllllllllllllIIlIIlIIlllIlllll.getX() - 0.5, lllllllllllllllIIlIIlIIlllIlIlIl - lllllllllllllllIIlIIlIIlllIlllll.getY() - 0.5, lllllllllllllllIIlIIlIIlllIlIlII - lllllllllllllllIIlIIlIIlllIlllll.getZ() - 0.5, lllllllllllllllIIlIIlIIlllIllllI).func_174846_a(lllllllllllllllIIlIIlIIlllIlllll));
                    }
                }
            }
        }
    }
    
    public void func_178926_a(final Entity lllllllllllllllIIlIIlIlIllIIIIII, final EnumParticleTypes lllllllllllllllIIlIIlIlIlIllllll) {
        this.field_178933_d.add(new EntityParticleEmitter(this.worldObj, lllllllllllllllIIlIIlIlIllIIIIII, lllllllllllllllIIlIIlIlIlIllllll));
    }
    
    public void func_178928_b(final EntityFX lllllllllllllllIIlIIlIIllIlIIIIl) {
        this.func_178924_a(lllllllllllllllIIlIIlIIllIlIIIIl, 1, 0);
    }
    
    public void func_178931_c(final EntityFX lllllllllllllllIIlIIlIIllIIllIll) {
        this.func_178924_a(lllllllllllllllIIlIIlIIllIIllIll, 0, 1);
    }
    
    private void func_178923_d(final EntityFX lllllllllllllllIIlIIlIlIIlIlllll) {
        try {
            lllllllllllllllIIlIIlIlIIlIlllll.onUpdate();
        }
        catch (Throwable lllllllllllllllIIlIIlIlIIllIIlII) {
            final CrashReport lllllllllllllllIIlIIlIlIIllIIIll = CrashReport.makeCrashReport(lllllllllllllllIIlIIlIlIIllIIlII, "Ticking Particle");
            final CrashReportCategory lllllllllllllllIIlIIlIlIIllIIIlI = lllllllllllllllIIlIIlIlIIllIIIll.makeCategory("Particle being ticked");
            final int lllllllllllllllIIlIIlIlIIllIIIIl = lllllllllllllllIIlIIlIlIIlIlllll.getFXLayer();
            lllllllllllllllIIlIIlIlIIllIIIlI.addCrashSectionCallable("Particle", new Callable() {
                static {
                    __OBFID = "CL_00000916";
                }
                
                @Override
                public String call() {
                    return lllllllllllllllIIlIIlIlIIlIlllll.toString();
                }
            });
            lllllllllllllllIIlIIlIlIIllIIIlI.addCrashSectionCallable("Particle Type", new Callable() {
                static {
                    __OBFID = "CL_00000917";
                }
                
                @Override
                public String call() {
                    return (lllllllllllllllIIlIIlIlIIllIIIIl == 0) ? "MISC_TEXTURE" : ((lllllllllllllllIIlIIlIlIIllIIIIl == 1) ? "TERRAIN_TEXTURE" : ((lllllllllllllllIIlIIlIlIIllIIIIl == 3) ? "ENTITY_PARTICLE_TEXTURE" : String.valueOf(new StringBuilder("Unknown - ").append(lllllllllllllllIIlIIlIlIIllIIIIl))));
                }
            });
            throw new ReportedException(lllllllllllllllIIlIIlIlIIllIIIll);
        }
    }
    
    public void updateEffects() {
        for (int lllllllllllllllIIlIIlIlIlIIIllII = 0; lllllllllllllllIIlIIlIlIlIIIllII < 4; ++lllllllllllllllIIlIIlIlIlIIIllII) {
            this.func_178922_a(lllllllllllllllIIlIIlIlIlIIIllII);
        }
        final ArrayList lllllllllllllllIIlIIlIlIlIIIlIll = Lists.newArrayList();
        for (final EntityParticleEmitter lllllllllllllllIIlIIlIlIlIIIlIIl : this.field_178933_d) {
            lllllllllllllllIIlIIlIlIlIIIlIIl.onUpdate();
            if (lllllllllllllllIIlIIlIlIlIIIlIIl.isDead) {
                lllllllllllllllIIlIIlIlIlIIIlIll.add(lllllllllllllllIIlIIlIlIlIIIlIIl);
            }
        }
        this.field_178933_d.removeAll(lllllllllllllllIIlIIlIlIlIIIlIll);
    }
    
    public void func_180532_a(final BlockPos lllllllllllllllIIlIIlIIllIlllIll, final EnumFacing lllllllllllllllIIlIIlIIllIlIlllI) {
        final IBlockState lllllllllllllllIIlIIlIIllIlllIIl = this.worldObj.getBlockState(lllllllllllllllIIlIIlIIllIlllIll);
        final Block lllllllllllllllIIlIIlIIllIlllIII = lllllllllllllllIIlIIlIIllIlllIIl.getBlock();
        if (lllllllllllllllIIlIIlIIllIlllIII.getRenderType() != -1) {
            final int lllllllllllllllIIlIIlIIllIllIlll = lllllllllllllllIIlIIlIIllIlllIll.getX();
            final int lllllllllllllllIIlIIlIIllIllIllI = lllllllllllllllIIlIIlIIllIlllIll.getY();
            final int lllllllllllllllIIlIIlIIllIllIlIl = lllllllllllllllIIlIIlIIllIlllIll.getZ();
            final float lllllllllllllllIIlIIlIIllIllIlII = 0.1f;
            double lllllllllllllllIIlIIlIIllIllIIll = lllllllllllllllIIlIIlIIllIllIlll + this.rand.nextDouble() * (lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMaxX() - lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMinX() - lllllllllllllllIIlIIlIIllIllIlII * 2.0f) + lllllllllllllllIIlIIlIIllIllIlII + lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMinX();
            double lllllllllllllllIIlIIlIIllIllIIlI = lllllllllllllllIIlIIlIIllIllIllI + this.rand.nextDouble() * (lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMaxY() - lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMinY() - lllllllllllllllIIlIIlIIllIllIlII * 2.0f) + lllllllllllllllIIlIIlIIllIllIlII + lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMinY();
            double lllllllllllllllIIlIIlIIllIllIIIl = lllllllllllllllIIlIIlIIllIllIlIl + this.rand.nextDouble() * (lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMaxZ() - lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMinZ() - lllllllllllllllIIlIIlIIllIllIlII * 2.0f) + lllllllllllllllIIlIIlIIllIllIlII + lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMinZ();
            if (lllllllllllllllIIlIIlIIllIlIlllI == EnumFacing.DOWN) {
                lllllllllllllllIIlIIlIIllIllIIlI = lllllllllllllllIIlIIlIIllIllIllI + lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMinY() - lllllllllllllllIIlIIlIIllIllIlII;
            }
            if (lllllllllllllllIIlIIlIIllIlIlllI == EnumFacing.UP) {
                lllllllllllllllIIlIIlIIllIllIIlI = lllllllllllllllIIlIIlIIllIllIllI + lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMaxY() + lllllllllllllllIIlIIlIIllIllIlII;
            }
            if (lllllllllllllllIIlIIlIIllIlIlllI == EnumFacing.NORTH) {
                lllllllllllllllIIlIIlIIllIllIIIl = lllllllllllllllIIlIIlIIllIllIlIl + lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMinZ() - lllllllllllllllIIlIIlIIllIllIlII;
            }
            if (lllllllllllllllIIlIIlIIllIlIlllI == EnumFacing.SOUTH) {
                lllllllllllllllIIlIIlIIllIllIIIl = lllllllllllllllIIlIIlIIllIllIlIl + lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMaxZ() + lllllllllllllllIIlIIlIIllIllIlII;
            }
            if (lllllllllllllllIIlIIlIIllIlIlllI == EnumFacing.WEST) {
                lllllllllllllllIIlIIlIIllIllIIll = lllllllllllllllIIlIIlIIllIllIlll + lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMinX() - lllllllllllllllIIlIIlIIllIllIlII;
            }
            if (lllllllllllllllIIlIIlIIllIlIlllI == EnumFacing.EAST) {
                lllllllllllllllIIlIIlIIllIllIIll = lllllllllllllllIIlIIlIIllIllIlll + lllllllllllllllIIlIIlIIllIlllIII.getBlockBoundsMaxX() + lllllllllllllllIIlIIlIIllIllIlII;
            }
            this.addEffect(new EntityDiggingFX(this.worldObj, lllllllllllllllIIlIIlIIllIllIIll, lllllllllllllllIIlIIlIIllIllIIlI, lllllllllllllllIIlIIlIIllIllIIIl, 0.0, 0.0, 0.0, lllllllllllllllIIlIIlIIllIlllIIl).func_174846_a(lllllllllllllllIIlIIlIIllIlllIll).multiplyVelocity(0.2f).multipleParticleScaleBy(0.6f));
        }
    }
    
    public void addEffect(final EntityFX lllllllllllllllIIlIIlIlIlIIllIII) {
        if (lllllllllllllllIIlIIlIlIlIIllIII != null && (!(lllllllllllllllIIlIIlIlIlIIllIII instanceof EntityFireworkSparkFX) || Config.isFireworkParticles())) {
            final int lllllllllllllllIIlIIlIlIlIIlIlll = lllllllllllllllIIlIIlIlIlIIllIII.getFXLayer();
            final int lllllllllllllllIIlIIlIlIlIIlIllI = (lllllllllllllllIIlIIlIlIlIIllIII.func_174838_j() == 1.0f) ? 1 : 0;
            if (this.fxLayers[lllllllllllllllIIlIIlIlIlIIlIlll][lllllllllllllllIIlIIlIlIlIIlIllI].size() >= 4000) {
                this.fxLayers[lllllllllllllllIIlIIlIlIlIIlIlll][lllllllllllllllIIlIIlIlIlIIlIllI].remove(0);
            }
            if (!(lllllllllllllllIIlIIlIlIlIIllIII instanceof Barrier) || !this.reuseBarrierParticle(lllllllllllllllIIlIIlIlIlIIllIII, this.fxLayers[lllllllllllllllIIlIIlIlIlIIlIlll][lllllllllllllllIIlIIlIlIlIIlIllI])) {
                this.fxLayers[lllllllllllllllIIlIIlIlIlIIlIlll][lllllllllllllllIIlIIlIlIlIIlIllI].add(lllllllllllllllIIlIIlIlIlIIllIII);
            }
        }
    }
    
    public void renderParticles(final Entity lllllllllllllllIIlIIlIlIIlIIIlll, final float lllllllllllllllIIlIIlIlIIlIIIllI) {
        final float lllllllllllllllIIlIIlIlIIlIIIlIl = ActiveRenderInfo.func_178808_b();
        final float lllllllllllllllIIlIIlIlIIlIIIlII = ActiveRenderInfo.func_178803_d();
        final float lllllllllllllllIIlIIlIlIIlIIIIll = ActiveRenderInfo.func_178805_e();
        final float lllllllllllllllIIlIIlIlIIlIIIIlI = ActiveRenderInfo.func_178807_f();
        final float lllllllllllllllIIlIIlIlIIlIIIIIl = ActiveRenderInfo.func_178809_c();
        EntityFX.interpPosX = lllllllllllllllIIlIIlIlIIlIIIlll.lastTickPosX + (lllllllllllllllIIlIIlIlIIlIIIlll.posX - lllllllllllllllIIlIIlIlIIlIIIlll.lastTickPosX) * lllllllllllllllIIlIIlIlIIlIIIllI;
        EntityFX.interpPosY = lllllllllllllllIIlIIlIlIIlIIIlll.lastTickPosY + (lllllllllllllllIIlIIlIlIIlIIIlll.posY - lllllllllllllllIIlIIlIlIIlIIIlll.lastTickPosY) * lllllllllllllllIIlIIlIlIIlIIIllI;
        EntityFX.interpPosZ = lllllllllllllllIIlIIlIlIIlIIIlll.lastTickPosZ + (lllllllllllllllIIlIIlIlIIlIIIlll.posZ - lllllllllllllllIIlIIlIlIIlIIIlll.lastTickPosZ) * lllllllllllllllIIlIIlIlIIlIIIllI;
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.alphaFunc(516, 0.003921569f);
        for (int lllllllllllllllIIlIIlIlIIlIIIIII = 0; lllllllllllllllIIlIIlIlIIlIIIIII < 3; ++lllllllllllllllIIlIIlIlIIlIIIIII) {
            final int lllllllllllllllIIlIIlIlIIIllllll = lllllllllllllllIIlIIlIlIIlIIIIII;
            for (int lllllllllllllllIIlIIlIlIIIlllllI = 0; lllllllllllllllIIlIIlIlIIIlllllI < 2; ++lllllllllllllllIIlIIlIlIIIlllllI) {
                if (!this.fxLayers[lllllllllllllllIIlIIlIlIIIllllll][lllllllllllllllIIlIIlIlIIIlllllI].isEmpty()) {
                    switch (lllllllllllllllIIlIIlIlIIIlllllI) {
                        case 0: {
                            GlStateManager.depthMask(false);
                            break;
                        }
                        case 1: {
                            GlStateManager.depthMask(true);
                            break;
                        }
                    }
                    switch (lllllllllllllllIIlIIlIlIIIllllll) {
                        default: {
                            this.renderer.bindTexture(EffectRenderer.particleTextures);
                            break;
                        }
                        case 1: {
                            this.renderer.bindTexture(TextureMap.locationBlocksTexture);
                            break;
                        }
                    }
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    final Tessellator lllllllllllllllIIlIIlIlIIIllllIl = Tessellator.getInstance();
                    final WorldRenderer lllllllllllllllIIlIIlIlIIIllllII = lllllllllllllllIIlIIlIlIIIllllIl.getWorldRenderer();
                    lllllllllllllllIIlIIlIlIIIllllII.startDrawingQuads();
                    for (int lllllllllllllllIIlIIlIlIIIlllIll = 0; lllllllllllllllIIlIIlIlIIIlllIll < this.fxLayers[lllllllllllllllIIlIIlIlIIIllllll][lllllllllllllllIIlIIlIlIIIlllllI].size(); ++lllllllllllllllIIlIIlIlIIIlllIll) {
                        final EntityFX lllllllllllllllIIlIIlIlIIIlllIlI = this.fxLayers[lllllllllllllllIIlIIlIlIIIllllll][lllllllllllllllIIlIIlIlIIIlllllI].get(lllllllllllllllIIlIIlIlIIIlllIll);
                        lllllllllllllllIIlIIlIlIIIllllII.func_178963_b(lllllllllllllllIIlIIlIlIIIlllIlI.getBrightnessForRender(lllllllllllllllIIlIIlIlIIlIIIllI));
                        try {
                            lllllllllllllllIIlIIlIlIIIlllIlI.func_180434_a(lllllllllllllllIIlIIlIlIIIllllII, lllllllllllllllIIlIIlIlIIlIIIlll, lllllllllllllllIIlIIlIlIIlIIIllI, lllllllllllllllIIlIIlIlIIlIIIlIl, lllllllllllllllIIlIIlIlIIlIIIIIl, lllllllllllllllIIlIIlIlIIlIIIlII, lllllllllllllllIIlIIlIlIIlIIIIll, lllllllllllllllIIlIIlIlIIlIIIIlI);
                        }
                        catch (Throwable lllllllllllllllIIlIIlIlIIIlllIIl) {
                            final CrashReport lllllllllllllllIIlIIlIlIIIlllIII = CrashReport.makeCrashReport(lllllllllllllllIIlIIlIlIIIlllIIl, "Rendering Particle");
                            final CrashReportCategory lllllllllllllllIIlIIlIlIIIllIlll = lllllllllllllllIIlIIlIlIIIlllIII.makeCategory("Particle being rendered");
                            lllllllllllllllIIlIIlIlIIIllIlll.addCrashSectionCallable("Particle", new Callable() {
                                static {
                                    __OBFID = "CL_00000918";
                                }
                                
                                @Override
                                public String call() {
                                    return lllllllllllllllIIlIIlIlIIIlllIlI.toString();
                                }
                            });
                            lllllllllllllllIIlIIlIlIIIllIlll.addCrashSectionCallable("Particle Type", new Callable() {
                                static {
                                    __OBFID = "CL_00000919";
                                }
                                
                                @Override
                                public String call() {
                                    return (lllllllllllllllIIlIIlIlIIIllllll == 0) ? "MISC_TEXTURE" : ((lllllllllllllllIIlIIlIlIIIllllll == 1) ? "TERRAIN_TEXTURE" : ((lllllllllllllllIIlIIlIlIIIllllll == 3) ? "ENTITY_PARTICLE_TEXTURE" : String.valueOf(new StringBuilder("Unknown - ").append(lllllllllllllllIIlIIlIlIIIllllll))));
                                }
                            });
                            throw new ReportedException(lllllllllllllllIIlIIlIlIIIlllIII);
                        }
                    }
                    lllllllllllllllIIlIIlIlIIIllllIl.draw();
                }
            }
        }
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.alphaFunc(516, 0.1f);
    }
}
