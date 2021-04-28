package net.minecraft.client.renderer.entity;

import net.minecraft.client.settings.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.texture.*;
import com.google.common.collect.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.boss.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.effect.*;
import optifine.*;
import net.minecraft.client.entity.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import net.minecraft.client.renderer.culling.*;

public class RenderManager
{
    public /* synthetic */ double renderPosX;
    public /* synthetic */ GameSettings options;
    public /* synthetic */ double renderPosZ;
    private /* synthetic */ boolean field_178638_s;
    public /* synthetic */ double viewerPosY;
    public /* synthetic */ Entity livingPlayer;
    public /* synthetic */ double viewerPosZ;
    public /* synthetic */ float playerViewY;
    public /* synthetic */ double viewerPosX;
    private /* synthetic */ Map entityRenderMap;
    public /* synthetic */ World worldObj;
    private /* synthetic */ Map field_178636_l;
    private /* synthetic */ FontRenderer textRenderer;
    private /* synthetic */ boolean field_178639_r;
    public /* synthetic */ float playerViewX;
    private /* synthetic */ boolean debugBoundingBox;
    private /* synthetic */ RenderPlayer field_178637_m;
    public /* synthetic */ Entity field_147941_i;
    public /* synthetic */ double renderPosY;
    public /* synthetic */ TextureManager renderEngine;
    
    public void func_178630_b(final Entity lllllllllllllllIIIlIIllIIIIllIIl, final float lllllllllllllllIIIlIIllIIIIllIII) {
        final double lllllllllllllllIIIlIIllIIIIlIlll = lllllllllllllllIIIlIIllIIIIllIIl.lastTickPosX + (lllllllllllllllIIIlIIllIIIIllIIl.posX - lllllllllllllllIIIlIIllIIIIllIIl.lastTickPosX) * lllllllllllllllIIIlIIllIIIIllIII;
        final double lllllllllllllllIIIlIIllIIIIlIllI = lllllllllllllllIIIlIIllIIIIllIIl.lastTickPosY + (lllllllllllllllIIIlIIllIIIIllIIl.posY - lllllllllllllllIIIlIIllIIIIllIIl.lastTickPosY) * lllllllllllllllIIIlIIllIIIIllIII;
        final double lllllllllllllllIIIlIIllIIIIlIlIl = lllllllllllllllIIIlIIllIIIIllIIl.lastTickPosZ + (lllllllllllllllIIIlIIllIIIIllIIl.posZ - lllllllllllllllIIIlIIllIIIIllIIl.lastTickPosZ) * lllllllllllllllIIIlIIllIIIIllIII;
        final Render lllllllllllllllIIIlIIllIIIIlIlII = this.getEntityRenderObject(lllllllllllllllIIIlIIllIIIIllIIl);
        if (lllllllllllllllIIIlIIllIIIIlIlII != null && this.renderEngine != null) {
            final int lllllllllllllllIIIlIIllIIIIlIIll = lllllllllllllllIIIlIIllIIIIllIIl.getBrightnessForRender(lllllllllllllllIIIlIIllIIIIllIII);
            final int lllllllllllllllIIIlIIllIIIIlIIlI = lllllllllllllllIIIlIIllIIIIlIIll % 65536;
            final int lllllllllllllllIIIlIIllIIIIlIIIl = lllllllllllllllIIIlIIllIIIIlIIll / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lllllllllllllllIIIlIIllIIIIlIIlI / 1.0f, lllllllllllllllIIIlIIllIIIIlIIIl / 1.0f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            lllllllllllllllIIIlIIllIIIIlIlII.func_177067_a(lllllllllllllllIIIlIIllIIIIllIIl, lllllllllllllllIIIlIIllIIIIlIlll - this.renderPosX, lllllllllllllllIIIlIIllIIIIlIllI - this.renderPosY, lllllllllllllllIIIlIIllIIIIlIlIl - this.renderPosZ);
        }
    }
    
    public boolean func_178634_b() {
        return this.debugBoundingBox;
    }
    
    public FontRenderer getFontRenderer() {
        return this.textRenderer;
    }
    
    public RenderManager(final TextureManager lllllllllllllllIIIlIIllIlllIllII, final RenderItem lllllllllllllllIIIlIIllIlllIIlIl) {
        this.entityRenderMap = Maps.newHashMap();
        this.field_178636_l = Maps.newHashMap();
        this.field_178639_r = false;
        this.field_178638_s = true;
        this.debugBoundingBox = false;
        this.renderEngine = lllllllllllllllIIIlIIllIlllIllII;
        this.entityRenderMap.put(EntityCaveSpider.class, new RenderCaveSpider(this));
        this.entityRenderMap.put(EntitySpider.class, new RenderSpider(this));
        this.entityRenderMap.put(EntityPig.class, new RenderPig(this, new ModelPig(), 0.7f));
        this.entityRenderMap.put(EntitySheep.class, new RenderSheep(this, new ModelSheep2(), 0.7f));
        this.entityRenderMap.put(EntityCow.class, new RenderCow(this, new ModelCow(), 0.7f));
        this.entityRenderMap.put(EntityMooshroom.class, new RenderMooshroom(this, new ModelCow(), 0.7f));
        this.entityRenderMap.put(EntityWolf.class, new RenderWolf(this, new ModelWolf(), 0.5f));
        this.entityRenderMap.put(EntityChicken.class, new RenderChicken(this, new ModelChicken(), 0.3f));
        this.entityRenderMap.put(EntityOcelot.class, new RenderOcelot(this, new ModelOcelot(), 0.4f));
        this.entityRenderMap.put(EntityRabbit.class, new RenderRabbit(this, new ModelRabbit(), 0.3f));
        this.entityRenderMap.put(EntitySilverfish.class, new RenderSilverfish(this));
        this.entityRenderMap.put(EntityEndermite.class, new RenderEndermite(this));
        this.entityRenderMap.put(EntityCreeper.class, new RenderCreeper(this));
        this.entityRenderMap.put(EntityEnderman.class, new RenderEnderman(this));
        this.entityRenderMap.put(EntitySnowman.class, new RenderSnowMan(this));
        this.entityRenderMap.put(EntitySkeleton.class, new RenderSkeleton(this));
        this.entityRenderMap.put(EntityWitch.class, new RenderWitch(this));
        this.entityRenderMap.put(EntityBlaze.class, new RenderBlaze(this));
        this.entityRenderMap.put(EntityPigZombie.class, new RenderPigZombie(this));
        this.entityRenderMap.put(EntityZombie.class, new RenderZombie(this));
        this.entityRenderMap.put(EntitySlime.class, new RenderSlime(this, new ModelSlime(16), 0.25f));
        this.entityRenderMap.put(EntityMagmaCube.class, new RenderMagmaCube(this));
        this.entityRenderMap.put(EntityGiantZombie.class, new RenderGiantZombie(this, new ModelZombie(), 0.5f, 6.0f));
        this.entityRenderMap.put(EntityGhast.class, new RenderGhast(this));
        this.entityRenderMap.put(EntitySquid.class, new RenderSquid(this, new ModelSquid(), 0.7f));
        this.entityRenderMap.put(EntityVillager.class, new RenderVillager(this));
        this.entityRenderMap.put(EntityIronGolem.class, new RenderIronGolem(this));
        this.entityRenderMap.put(EntityBat.class, new RenderBat(this));
        this.entityRenderMap.put(EntityGuardian.class, new RenderGuardian(this));
        this.entityRenderMap.put(EntityDragon.class, new RenderDragon(this));
        this.entityRenderMap.put(EntityEnderCrystal.class, new RenderEnderCrystal(this));
        this.entityRenderMap.put(EntityWither.class, new RenderWither(this));
        this.entityRenderMap.put(Entity.class, new RenderEntity(this));
        this.entityRenderMap.put(EntityPainting.class, new RenderPainting(this));
        this.entityRenderMap.put(EntityItemFrame.class, new RenderItemFrame(this, lllllllllllllllIIIlIIllIlllIIlIl));
        this.entityRenderMap.put(EntityLeashKnot.class, new RenderLeashKnot(this));
        this.entityRenderMap.put(EntityArrow.class, new RenderArrow(this));
        this.entityRenderMap.put(EntitySnowball.class, new RenderSnowball(this, Items.snowball, lllllllllllllllIIIlIIllIlllIIlIl));
        this.entityRenderMap.put(EntityEnderPearl.class, new RenderSnowball(this, Items.ender_pearl, lllllllllllllllIIIlIIllIlllIIlIl));
        this.entityRenderMap.put(EntityEnderEye.class, new RenderSnowball(this, Items.ender_eye, lllllllllllllllIIIlIIllIlllIIlIl));
        this.entityRenderMap.put(EntityEgg.class, new RenderSnowball(this, Items.egg, lllllllllllllllIIIlIIllIlllIIlIl));
        this.entityRenderMap.put(EntityPotion.class, new RenderPotion(this, lllllllllllllllIIIlIIllIlllIIlIl));
        this.entityRenderMap.put(EntityExpBottle.class, new RenderSnowball(this, Items.experience_bottle, lllllllllllllllIIIlIIllIlllIIlIl));
        this.entityRenderMap.put(EntityFireworkRocket.class, new RenderSnowball(this, Items.fireworks, lllllllllllllllIIIlIIllIlllIIlIl));
        this.entityRenderMap.put(EntityLargeFireball.class, new RenderFireball(this, 2.0f));
        this.entityRenderMap.put(EntitySmallFireball.class, new RenderFireball(this, 0.5f));
        this.entityRenderMap.put(EntityWitherSkull.class, new RenderWitherSkull(this));
        this.entityRenderMap.put(EntityItem.class, new RenderEntityItem(this, lllllllllllllllIIIlIIllIlllIIlIl));
        this.entityRenderMap.put(EntityXPOrb.class, new RenderXPOrb(this));
        this.entityRenderMap.put(EntityTNTPrimed.class, new RenderTNTPrimed(this));
        this.entityRenderMap.put(EntityFallingBlock.class, new RenderFallingBlock(this));
        this.entityRenderMap.put(EntityArmorStand.class, new ArmorStandRenderer(this));
        this.entityRenderMap.put(EntityMinecartTNT.class, new RenderTntMinecart(this));
        this.entityRenderMap.put(EntityMinecartMobSpawner.class, new RenderMinecartMobSpawner(this));
        this.entityRenderMap.put(EntityMinecart.class, new RenderMinecart(this));
        this.entityRenderMap.put(EntityBoat.class, new RenderBoat(this));
        this.entityRenderMap.put(EntityFishHook.class, new RenderFish(this));
        this.entityRenderMap.put(EntityHorse.class, new RenderHorse(this, new ModelHorse(), 0.75f));
        this.entityRenderMap.put(EntityLightningBolt.class, new RenderLightningBolt(this));
        this.field_178637_m = new RenderPlayer(this);
        this.field_178636_l.put("default", this.field_178637_m);
        this.field_178636_l.put("slim", new RenderPlayer(this, true));
        PlayerItemsLayer.register(this.field_178636_l);
        if (Reflector.RenderingRegistry_loadEntityRenderers.exists()) {
            Reflector.call(Reflector.RenderingRegistry_loadEntityRenderers, this, this.entityRenderMap);
        }
    }
    
    public boolean renderEntitySimple(final Entity lllllllllllllllIIIlIIllIIlIlllll, final float lllllllllllllllIIIlIIllIIlIllllI) {
        return this.renderEntityStatic(lllllllllllllllIIIlIIllIIlIlllll, lllllllllllllllIIIlIIllIIlIllllI, false);
    }
    
    public double getDistanceToCamera(final double lllllllllllllllIIIlIIlIllIIlIlIl, final double lllllllllllllllIIIlIIlIllIIlIlII, final double lllllllllllllllIIIlIIlIllIIIllII) {
        final double lllllllllllllllIIIlIIlIllIIlIIlI = lllllllllllllllIIIlIIlIllIIlIlIl - this.viewerPosX;
        final double lllllllllllllllIIIlIIlIllIIlIIIl = lllllllllllllllIIIlIIlIllIIlIlII - this.viewerPosY;
        final double lllllllllllllllIIIlIIlIllIIlIIII = lllllllllllllllIIIlIIlIllIIIllII - this.viewerPosZ;
        return lllllllllllllllIIIlIIlIllIIlIIlI * lllllllllllllllIIIlIIlIllIIlIIlI + lllllllllllllllIIIlIIlIllIIlIIIl * lllllllllllllllIIIlIIlIllIIlIIIl + lllllllllllllllIIIlIIlIllIIlIIII * lllllllllllllllIIIlIIlIllIIlIIII;
    }
    
    public Render getEntityRenderObject(final Entity lllllllllllllllIIIlIIllIlIlIlIlI) {
        if (lllllllllllllllIIIlIIllIlIlIlIlI instanceof AbstractClientPlayer) {
            final String lllllllllllllllIIIlIIllIlIlIllIl = ((AbstractClientPlayer)lllllllllllllllIIIlIIllIlIlIlIlI).func_175154_l();
            final RenderPlayer lllllllllllllllIIIlIIllIlIlIllII = this.field_178636_l.get(lllllllllllllllIIIlIIllIlIlIllIl);
            return (lllllllllllllllIIIlIIllIlIlIllII != null) ? lllllllllllllllIIIlIIllIlIlIllII : this.field_178637_m;
        }
        return this.getEntityClassRenderObject(lllllllllllllllIIIlIIllIlIlIlIlI.getClass());
    }
    
    public boolean func_178627_a() {
        return this.field_178638_s;
    }
    
    public void func_178631_a(final float lllllllllllllllIIIlIIllIIlllIllI) {
        this.playerViewY = lllllllllllllllIIIlIIllIIlllIllI;
    }
    
    public Map getEntityRenderMap() {
        return this.entityRenderMap;
    }
    
    public void setEntityRenderMap(final Map lllllllllllllllIIIlIIlIlIllllIIl) {
        this.entityRenderMap = lllllllllllllllIIIlIIlIlIllllIIl;
    }
    
    public Render getEntityClassRenderObject(final Class lllllllllllllllIIIlIIllIllIIIlIl) {
        Render lllllllllllllllIIIlIIllIllIIIIll = (Render)this.entityRenderMap.get(lllllllllllllllIIIlIIllIllIIIlIl);
        if (lllllllllllllllIIIlIIllIllIIIIll == null && lllllllllllllllIIIlIIllIllIIIlIl != Entity.class) {
            lllllllllllllllIIIlIIllIllIIIIll = this.getEntityClassRenderObject(lllllllllllllllIIIlIIllIllIIIlIl.getSuperclass());
            this.entityRenderMap.put(lllllllllllllllIIIlIIllIllIIIlIl, lllllllllllllllIIIlIIllIllIIIIll);
        }
        return lllllllllllllllIIIlIIllIllIIIIll;
    }
    
    public boolean renderEntityWithPosYaw(final Entity lllllllllllllllIIIlIIlIllllllllI, final double lllllllllllllllIIIlIIlIlllllllIl, final double lllllllllllllllIIIlIIlIlllllllII, final double lllllllllllllllIIIlIIlIllllllIll, final float lllllllllllllllIIIlIIlIllllllIlI, final float lllllllllllllllIIIlIIlIlllllIIlI) {
        return this.doRenderEntity(lllllllllllllllIIIlIIlIllllllllI, lllllllllllllllIIIlIIlIlllllllIl, lllllllllllllllIIIlIIlIlllllllII, lllllllllllllllIIIlIIlIllllllIll, lllllllllllllllIIIlIIlIllllllIlI, lllllllllllllllIIIlIIlIlllllIIlI, false);
    }
    
    public boolean renderEntityStatic(final Entity lllllllllllllllIIIlIIllIIIlIlllI, final float lllllllllllllllIIIlIIllIIIlllIII, final boolean lllllllllllllllIIIlIIllIIIllIlll) {
        if (lllllllllllllllIIIlIIllIIIlIlllI.ticksExisted == 0) {
            lllllllllllllllIIIlIIllIIIlIlllI.lastTickPosX = lllllllllllllllIIIlIIllIIIlIlllI.posX;
            lllllllllllllllIIIlIIllIIIlIlllI.lastTickPosY = lllllllllllllllIIIlIIllIIIlIlllI.posY;
            lllllllllllllllIIIlIIllIIIlIlllI.lastTickPosZ = lllllllllllllllIIIlIIllIIIlIlllI.posZ;
        }
        final double lllllllllllllllIIIlIIllIIIllIllI = lllllllllllllllIIIlIIllIIIlIlllI.lastTickPosX + (lllllllllllllllIIIlIIllIIIlIlllI.posX - lllllllllllllllIIIlIIllIIIlIlllI.lastTickPosX) * lllllllllllllllIIIlIIllIIIlllIII;
        final double lllllllllllllllIIIlIIllIIIllIlIl = lllllllllllllllIIIlIIllIIIlIlllI.lastTickPosY + (lllllllllllllllIIIlIIllIIIlIlllI.posY - lllllllllllllllIIIlIIllIIIlIlllI.lastTickPosY) * lllllllllllllllIIIlIIllIIIlllIII;
        final double lllllllllllllllIIIlIIllIIIllIlII = lllllllllllllllIIIlIIllIIIlIlllI.lastTickPosZ + (lllllllllllllllIIIlIIllIIIlIlllI.posZ - lllllllllllllllIIIlIIllIIIlIlllI.lastTickPosZ) * lllllllllllllllIIIlIIllIIIlllIII;
        final float lllllllllllllllIIIlIIllIIIllIIll = lllllllllllllllIIIlIIllIIIlIlllI.prevRotationYaw + (lllllllllllllllIIIlIIllIIIlIlllI.rotationYaw - lllllllllllllllIIIlIIllIIIlIlllI.prevRotationYaw) * lllllllllllllllIIIlIIllIIIlllIII;
        int lllllllllllllllIIIlIIllIIIllIIlI = lllllllllllllllIIIlIIllIIIlIlllI.getBrightnessForRender(lllllllllllllllIIIlIIllIIIlllIII);
        if (lllllllllllllllIIIlIIllIIIlIlllI.isBurning()) {
            lllllllllllllllIIIlIIllIIIllIIlI = 15728880;
        }
        final int lllllllllllllllIIIlIIllIIIllIIIl = lllllllllllllllIIIlIIllIIIllIIlI % 65536;
        final int lllllllllllllllIIIlIIllIIIllIIII = lllllllllllllllIIIlIIllIIIllIIlI / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lllllllllllllllIIIlIIllIIIllIIIl / 1.0f, lllllllllllllllIIIlIIllIIIllIIII / 1.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        return this.doRenderEntity(lllllllllllllllIIIlIIllIIIlIlllI, lllllllllllllllIIIlIIllIIIllIllI - this.renderPosX, lllllllllllllllIIIlIIllIIIllIlIl - this.renderPosY, lllllllllllllllIIIlIIllIIIllIlII - this.renderPosZ, lllllllllllllllIIIlIIllIIIllIIll, lllllllllllllllIIIlIIllIIIlllIII, lllllllllllllllIIIlIIllIIIllIlll);
    }
    
    public void func_178632_c(final boolean lllllllllllllllIIIlIIlIllIIIIIII) {
        this.field_178639_r = lllllllllllllllIIIlIIlIllIIIIIII;
    }
    
    public void func_180597_a(final World lllllllllllllllIIIlIIllIlIIIIlIl, final FontRenderer lllllllllllllllIIIlIIllIlIIlIIII, final Entity lllllllllllllllIIIlIIllIlIIIllll, final Entity lllllllllllllllIIIlIIllIlIIIIIlI, final GameSettings lllllllllllllllIIIlIIllIlIIIIIIl, final float lllllllllllllllIIIlIIllIlIIIllII) {
        this.worldObj = lllllllllllllllIIIlIIllIlIIIIlIl;
        this.options = lllllllllllllllIIIlIIllIlIIIIIIl;
        this.livingPlayer = lllllllllllllllIIIlIIllIlIIIllll;
        this.field_147941_i = lllllllllllllllIIIlIIllIlIIIIIlI;
        this.textRenderer = lllllllllllllllIIIlIIllIlIIlIIII;
        if (lllllllllllllllIIIlIIllIlIIIllll instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllllIIIlIIllIlIIIllll).isPlayerSleeping()) {
            final IBlockState lllllllllllllllIIIlIIllIlIIIlIll = lllllllllllllllIIIlIIllIlIIIIlIl.getBlockState(new BlockPos(lllllllllllllllIIIlIIllIlIIIllll));
            final Block lllllllllllllllIIIlIIllIlIIIlIlI = lllllllllllllllIIIlIIllIlIIIlIll.getBlock();
            if (Reflector.callBoolean(Reflector.ForgeBlock_isBed, lllllllllllllllIIIlIIllIlIIIIlIl, new BlockPos(lllllllllllllllIIIlIIllIlIIIllll), (EntityLivingBase)lllllllllllllllIIIlIIllIlIIIllll)) {
                final EnumFacing lllllllllllllllIIIlIIllIlIIIlIIl = (EnumFacing)Reflector.call(lllllllllllllllIIIlIIllIlIIIlIlI, Reflector.ForgeBlock_getBedDirection, lllllllllllllllIIIlIIllIlIIIIlIl, new BlockPos(lllllllllllllllIIIlIIllIlIIIllll));
                final int lllllllllllllllIIIlIIllIlIIIlIII = lllllllllllllllIIIlIIllIlIIIlIIl.getHorizontalIndex();
                this.playerViewY = (float)(lllllllllllllllIIIlIIllIlIIIlIII * 90 + 180);
                this.playerViewX = 0.0f;
            }
            else if (lllllllllllllllIIIlIIllIlIIIlIlI == Blocks.bed) {
                final int lllllllllllllllIIIlIIllIlIIIIlll = ((EnumFacing)lllllllllllllllIIIlIIllIlIIIlIll.getValue(BlockBed.AGE)).getHorizontalIndex();
                this.playerViewY = (float)(lllllllllllllllIIIlIIllIlIIIIlll * 90 + 180);
                this.playerViewX = 0.0f;
            }
        }
        else {
            this.playerViewY = lllllllllllllllIIIlIIllIlIIIllll.prevRotationYaw + (lllllllllllllllIIIlIIllIlIIIllll.rotationYaw - lllllllllllllllIIIlIIllIlIIIllll.prevRotationYaw) * lllllllllllllllIIIlIIllIlIIIllII;
            this.playerViewX = lllllllllllllllIIIlIIllIlIIIllll.prevRotationPitch + (lllllllllllllllIIIlIIllIlIIIllll.rotationPitch - lllllllllllllllIIIlIIllIlIIIllll.prevRotationPitch) * lllllllllllllllIIIlIIllIlIIIllII;
        }
        if (lllllllllllllllIIIlIIllIlIIIIIIl.thirdPersonView == 2) {
            this.playerViewY += 180.0f;
        }
        this.viewerPosX = lllllllllllllllIIIlIIllIlIIIllll.lastTickPosX + (lllllllllllllllIIIlIIllIlIIIllll.posX - lllllllllllllllIIIlIIllIlIIIllll.lastTickPosX) * lllllllllllllllIIIlIIllIlIIIllII;
        this.viewerPosY = lllllllllllllllIIIlIIllIlIIIllll.lastTickPosY + (lllllllllllllllIIIlIIllIlIIIllll.posY - lllllllllllllllIIIlIIllIlIIIllll.lastTickPosY) * lllllllllllllllIIIlIIllIlIIIllII;
        this.viewerPosZ = lllllllllllllllIIIlIIllIlIIIllll.lastTickPosZ + (lllllllllllllllIIIlIIllIlIIIllll.posZ - lllllllllllllllIIIlIIllIlIIIllll.lastTickPosZ) * lllllllllllllllIIIlIIllIlIIIllII;
    }
    
    public void func_178633_a(final boolean lllllllllllllllIIIlIIllIIllIllIl) {
        this.field_178638_s = lllllllllllllllIIIlIIllIIllIllIl;
    }
    
    public Map<String, RenderPlayer> getSkinMap() {
        return Collections.unmodifiableMap((Map<? extends String, ? extends RenderPlayer>)this.field_178636_l);
    }
    
    private void renderDebugBoundingBox(final Entity lllllllllllllllIIIlIIlIllIlllIll, final double lllllllllllllllIIIlIIlIllIlIllIl, final double lllllllllllllllIIIlIIlIllIlllIIl, final double lllllllllllllllIIIlIIlIllIlIlIll, final float lllllllllllllllIIIlIIlIllIllIlll, final float lllllllllllllllIIIlIIlIllIllIllI) {
        GlStateManager.depthMask(false);
        GlStateManager.func_179090_x();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.disableBlend();
        final float lllllllllllllllIIIlIIlIllIllIlIl = lllllllllllllllIIIlIIlIllIlllIll.width / 2.0f;
        final AxisAlignedBB lllllllllllllllIIIlIIlIllIllIlII = lllllllllllllllIIIlIIlIllIlllIll.getEntityBoundingBox();
        final AxisAlignedBB lllllllllllllllIIIlIIlIllIllIIll = new AxisAlignedBB(lllllllllllllllIIIlIIlIllIllIlII.minX - lllllllllllllllIIIlIIlIllIlllIll.posX + lllllllllllllllIIIlIIlIllIlIllIl, lllllllllllllllIIIlIIlIllIllIlII.minY - lllllllllllllllIIIlIIlIllIlllIll.posY + lllllllllllllllIIIlIIlIllIlllIIl, lllllllllllllllIIIlIIlIllIllIlII.minZ - lllllllllllllllIIIlIIlIllIlllIll.posZ + lllllllllllllllIIIlIIlIllIlIlIll, lllllllllllllllIIIlIIlIllIllIlII.maxX - lllllllllllllllIIIlIIlIllIlllIll.posX + lllllllllllllllIIIlIIlIllIlIllIl, lllllllllllllllIIIlIIlIllIllIlII.maxY - lllllllllllllllIIIlIIlIllIlllIll.posY + lllllllllllllllIIIlIIlIllIlllIIl, lllllllllllllllIIIlIIlIllIllIlII.maxZ - lllllllllllllllIIIlIIlIllIlllIll.posZ + lllllllllllllllIIIlIIlIllIlIlIll);
        RenderGlobal.drawOutlinedBoundingBox(lllllllllllllllIIIlIIlIllIllIIll, 16777215);
        if (lllllllllllllllIIIlIIlIllIlllIll instanceof EntityLivingBase) {
            final float lllllllllllllllIIIlIIlIllIllIIlI = 0.01f;
            RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(lllllllllllllllIIIlIIlIllIlIllIl - lllllllllllllllIIIlIIlIllIllIlIl, lllllllllllllllIIIlIIlIllIlllIIl + lllllllllllllllIIIlIIlIllIlllIll.getEyeHeight() - 0.009999999776482582, lllllllllllllllIIIlIIlIllIlIlIll - lllllllllllllllIIIlIIlIllIllIlIl, lllllllllllllllIIIlIIlIllIlIllIl + lllllllllllllllIIIlIIlIllIllIlIl, lllllllllllllllIIIlIIlIllIlllIIl + lllllllllllllllIIIlIIlIllIlllIll.getEyeHeight() + 0.009999999776482582, lllllllllllllllIIIlIIlIllIlIlIll + lllllllllllllllIIIlIIlIllIllIlIl), 16711680);
        }
        final Tessellator lllllllllllllllIIIlIIlIllIllIIIl = Tessellator.getInstance();
        final WorldRenderer lllllllllllllllIIIlIIlIllIllIIII = lllllllllllllllIIIlIIlIllIllIIIl.getWorldRenderer();
        final Vec3 lllllllllllllllIIIlIIlIllIlIllll = lllllllllllllllIIIlIIlIllIlllIll.getLook(lllllllllllllllIIIlIIlIllIllIllI);
        lllllllllllllllIIIlIIlIllIllIIII.startDrawing(3);
        lllllllllllllllIIIlIIlIllIllIIII.func_178991_c(255);
        lllllllllllllllIIIlIIlIllIllIIII.addVertex(lllllllllllllllIIIlIIlIllIlIllIl, lllllllllllllllIIIlIIlIllIlllIIl + lllllllllllllllIIIlIIlIllIlllIll.getEyeHeight(), lllllllllllllllIIIlIIlIllIlIlIll);
        lllllllllllllllIIIlIIlIllIllIIII.addVertex(lllllllllllllllIIIlIIlIllIlIllIl + lllllllllllllllIIIlIIlIllIlIllll.xCoord * 2.0, lllllllllllllllIIIlIIlIllIlllIIl + lllllllllllllllIIIlIIlIllIlllIll.getEyeHeight() + lllllllllllllllIIIlIIlIllIlIllll.yCoord * 2.0, lllllllllllllllIIIlIIlIllIlIlIll + lllllllllllllllIIIlIIlIllIlIllll.zCoord * 2.0);
        lllllllllllllllIIIlIIlIllIllIIIl.draw();
        GlStateManager.func_179098_w();
        GlStateManager.enableLighting();
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
    }
    
    public boolean doRenderEntity(final Entity lllllllllllllllIIIlIIlIlllIlIIll, final double lllllllllllllllIIIlIIlIlllIlIIlI, final double lllllllllllllllIIIlIIlIllllIIIIl, final double lllllllllllllllIIIlIIlIlllIlIIII, final float lllllllllllllllIIIlIIlIlllIlllll, final float lllllllllllllllIIIlIIlIlllIIlllI, final boolean lllllllllllllllIIIlIIlIlllIIllIl) {
        Render lllllllllllllllIIIlIIlIlllIlllII = null;
        try {
            lllllllllllllllIIIlIIlIlllIlllII = this.getEntityRenderObject(lllllllllllllllIIIlIIlIlllIlIIll);
            if (lllllllllllllllIIIlIIlIlllIlllII != null && this.renderEngine != null) {
                try {
                    if (lllllllllllllllIIIlIIlIlllIlllII instanceof RendererLivingEntity) {
                        ((RendererLivingEntity)lllllllllllllllIIIlIIlIlllIlllII).func_177086_a(this.field_178639_r);
                    }
                    lllllllllllllllIIIlIIlIlllIlllII.doRender(lllllllllllllllIIIlIIlIlllIlIIll, lllllllllllllllIIIlIIlIlllIlIIlI, lllllllllllllllIIIlIIlIllllIIIIl, lllllllllllllllIIIlIIlIlllIlIIII, lllllllllllllllIIIlIIlIlllIlllll, lllllllllllllllIIIlIIlIlllIIlllI);
                }
                catch (Throwable lllllllllllllllIIIlIIlIlllIllIll) {
                    throw new ReportedException(CrashReport.makeCrashReport(lllllllllllllllIIIlIIlIlllIllIll, "Rendering entity in world"));
                }
                try {
                    if (!this.field_178639_r) {
                        lllllllllllllllIIIlIIlIlllIlllII.doRenderShadowAndFire(lllllllllllllllIIIlIIlIlllIlIIll, lllllllllllllllIIIlIIlIlllIlIIlI, lllllllllllllllIIIlIIlIllllIIIIl, lllllllllllllllIIIlIIlIlllIlIIII, lllllllllllllllIIIlIIlIlllIlllll, lllllllllllllllIIIlIIlIlllIIlllI);
                    }
                }
                catch (Throwable lllllllllllllllIIIlIIlIlllIllIlI) {
                    throw new ReportedException(CrashReport.makeCrashReport(lllllllllllllllIIIlIIlIlllIllIlI, "Post-rendering entity in world"));
                }
                if (!this.debugBoundingBox || lllllllllllllllIIIlIIlIlllIlIIll.isInvisible() || lllllllllllllllIIIlIIlIlllIIllIl) {
                    return true;
                }
                try {
                    this.renderDebugBoundingBox(lllllllllllllllIIIlIIlIlllIlIIll, lllllllllllllllIIIlIIlIlllIlIIlI, lllllllllllllllIIIlIIlIllllIIIIl, lllllllllllllllIIIlIIlIlllIlIIII, lllllllllllllllIIIlIIlIlllIlllll, lllllllllllllllIIIlIIlIlllIIlllI);
                    return true;
                }
                catch (Throwable lllllllllllllllIIIlIIlIlllIllIIl) {
                    throw new ReportedException(CrashReport.makeCrashReport(lllllllllllllllIIIlIIlIlllIllIIl, "Rendering entity hitbox in world"));
                }
            }
            if (this.renderEngine != null) {
                return false;
            }
            return true;
        }
        catch (Throwable lllllllllllllllIIIlIIlIlllIllIII) {
            final CrashReport lllllllllllllllIIIlIIlIlllIlIlll = CrashReport.makeCrashReport(lllllllllllllllIIIlIIlIlllIllIII, "Rendering entity in world");
            final CrashReportCategory lllllllllllllllIIIlIIlIlllIlIllI = lllllllllllllllIIIlIIlIlllIlIlll.makeCategory("Entity being rendered");
            lllllllllllllllIIIlIIlIlllIlIIll.addEntityCrashInfo(lllllllllllllllIIIlIIlIlllIlIllI);
            final CrashReportCategory lllllllllllllllIIIlIIlIlllIlIlIl = lllllllllllllllIIIlIIlIlllIlIlll.makeCategory("Renderer details");
            lllllllllllllllIIIlIIlIlllIlIlIl.addCrashSection("Assigned renderer", lllllllllllllllIIIlIIlIlllIlllII);
            lllllllllllllllIIIlIIlIlllIlIlIl.addCrashSection("Location", CrashReportCategory.getCoordinateInfo(lllllllllllllllIIIlIIlIlllIlIIlI, lllllllllllllllIIIlIIlIllllIIIIl, lllllllllllllllIIIlIIlIlllIlIIII));
            lllllllllllllllIIIlIIlIlllIlIlIl.addCrashSection("Rotation", lllllllllllllllIIIlIIlIlllIlllll);
            lllllllllllllllIIIlIIlIlllIlIlIl.addCrashSection("Delta", lllllllllllllllIIIlIIlIlllIIlllI);
            throw new ReportedException(lllllllllllllllIIIlIIlIlllIlIlll);
        }
    }
    
    public void set(final World lllllllllllllllIIIlIIlIllIlIIIII) {
        this.worldObj = lllllllllllllllIIIlIIlIllIlIIIII;
    }
    
    public boolean func_178635_a(final Entity lllllllllllllllIIIlIIllIIlIIlIll, final ICamera lllllllllllllllIIIlIIllIIlIIlIlI, final double lllllllllllllllIIIlIIllIIlIlIIII, final double lllllllllllllllIIIlIIllIIlIIllll, final double lllllllllllllllIIIlIIllIIlIIIlll) {
        final Render lllllllllllllllIIIlIIllIIlIIllIl = this.getEntityRenderObject(lllllllllllllllIIIlIIllIIlIIlIll);
        return lllllllllllllllIIIlIIllIIlIIllIl != null && lllllllllllllllIIIlIIllIIlIIllIl.func_177071_a(lllllllllllllllIIIlIIllIIlIIlIll, lllllllllllllllIIIlIIllIIlIIlIlI, lllllllllllllllIIIlIIllIIlIlIIII, lllllllllllllllIIIlIIllIIlIIllll, lllllllllllllllIIIlIIllIIlIIIlll);
    }
    
    public void func_178628_a(final double lllllllllllllllIIIlIIllIllIlIIll, final double lllllllllllllllIIIlIIllIllIlIIIl, final double lllllllllllllllIIIlIIllIllIIllll) {
        this.renderPosX = lllllllllllllllIIIlIIllIllIlIIll;
        this.renderPosY = lllllllllllllllIIIlIIllIllIlIIIl;
        this.renderPosZ = lllllllllllllllIIIlIIllIllIIllll;
    }
    
    static {
        __OBFID = "CL_00000991";
    }
    
    public void func_178629_b(final boolean lllllllllllllllIIIlIIllIIllIlIIl) {
        this.debugBoundingBox = lllllllllllllllIIIlIIllIIllIlIIl;
    }
}
