package net.minecraft.util;

import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.projectile.*;

public class DamageSource
{
    private /* synthetic */ boolean explosion;
    public static /* synthetic */ DamageSource fall;
    public static /* synthetic */ DamageSource magic;
    private /* synthetic */ boolean isDamageAllowedInCreativeMode;
    private /* synthetic */ boolean projectile;
    public static /* synthetic */ DamageSource anvil;
    public static /* synthetic */ DamageSource starve;
    private /* synthetic */ float hungerDamage;
    public static /* synthetic */ DamageSource onFire;
    private /* synthetic */ boolean fireDamage;
    private /* synthetic */ boolean isUnblockable;
    public static /* synthetic */ DamageSource drown;
    public static /* synthetic */ DamageSource inFire;
    private /* synthetic */ boolean magicDamage;
    private /* synthetic */ boolean damageIsAbsolute;
    public static /* synthetic */ DamageSource generic;
    public static /* synthetic */ DamageSource field_180137_b;
    public static /* synthetic */ DamageSource inWall;
    public static /* synthetic */ DamageSource wither;
    public /* synthetic */ String damageType;
    public static /* synthetic */ DamageSource lava;
    public static /* synthetic */ DamageSource cactus;
    private /* synthetic */ boolean difficultyScaled;
    public static /* synthetic */ DamageSource fallingBlock;
    public static /* synthetic */ DamageSource outOfWorld;
    
    public float getHungerDamage() {
        return this.hungerDamage;
    }
    
    public static DamageSource causeFireballDamage(final EntityFireball lllllllllllllllIIlIIIlllIllIlIIl, final Entity lllllllllllllllIIlIIIlllIllIIllI) {
        return (lllllllllllllllIIlIIIlllIllIIllI == null) ? new EntityDamageSourceIndirect("onFire", lllllllllllllllIIlIIIlllIllIlIIl, lllllllllllllllIIlIIIlllIllIlIIl).setFireDamage().setProjectile() : new EntityDamageSourceIndirect("fireball", lllllllllllllllIIlIIIlllIllIlIIl, lllllllllllllllIIlIIIlllIllIIllI).setFireDamage().setProjectile();
    }
    
    protected DamageSource setDamageBypassesArmor() {
        this.isUnblockable = true;
        this.hungerDamage = 0.0f;
        return this;
    }
    
    public DamageSource setExplosion() {
        this.explosion = true;
        return this;
    }
    
    public boolean func_180136_u() {
        final Entity lllllllllllllllIIlIIIlllIIIIIIIl = this.getEntity();
        return lllllllllllllllIIlIIIlllIIIIIIIl instanceof EntityPlayer && ((EntityPlayer)lllllllllllllllIIlIIIlllIIIIIIIl).capabilities.isCreativeMode;
    }
    
    public boolean isMagicDamage() {
        return this.magicDamage;
    }
    
    public IChatComponent getDeathMessage(final EntityLivingBase lllllllllllllllIIlIIIlllIIIlllll) {
        final EntityLivingBase lllllllllllllllIIlIIIlllIIIllllI = lllllllllllllllIIlIIIlllIIIlllll.func_94060_bK();
        final String lllllllllllllllIIlIIIlllIIIlllIl = String.valueOf(new StringBuilder("death.attack.").append(this.damageType));
        final String lllllllllllllllIIlIIIlllIIIlllII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIlIIIlllIIIlllIl)).append(".player"));
        return (lllllllllllllllIIlIIIlllIIIllllI != null && StatCollector.canTranslate(lllllllllllllllIIlIIIlllIIIlllII)) ? new ChatComponentTranslation(lllllllllllllllIIlIIIlllIIIlllII, new Object[] { lllllllllllllllIIlIIIlllIIIlllll.getDisplayName(), lllllllllllllllIIlIIIlllIIIllllI.getDisplayName() }) : new ChatComponentTranslation(lllllllllllllllIIlIIIlllIIIlllIl, new Object[] { lllllllllllllllIIlIIIlllIIIlllll.getDisplayName() });
    }
    
    public DamageSource setDifficultyScaled() {
        this.difficultyScaled = true;
        return this;
    }
    
    public static DamageSource causeMobDamage(final EntityLivingBase lllllllllllllllIIlIIIlllIlllIllI) {
        return new EntityDamageSource("mob", lllllllllllllllIIlIIIlllIlllIllI);
    }
    
    public boolean isProjectile() {
        return this.projectile;
    }
    
    public boolean isUnblockable() {
        return this.isUnblockable;
    }
    
    public static DamageSource causePlayerDamage(final EntityPlayer lllllllllllllllIIlIIIlllIlllIIlI) {
        return new EntityDamageSource("player", lllllllllllllllIIlIIIlllIlllIIlI);
    }
    
    public static DamageSource setExplosionSource(final Explosion lllllllllllllllIIlIIIlllIlIlIlII) {
        return (lllllllllllllllIIlIIIlllIlIlIlII != null && lllllllllllllllIIlIIIlllIlIlIlII.getExplosivePlacedBy() != null) ? new EntityDamageSource("explosion.player", lllllllllllllllIIlIIIlllIlIlIlII.getExplosivePlacedBy()).setDifficultyScaled().setExplosion() : new DamageSource("explosion").setDifficultyScaled().setExplosion();
    }
    
    public boolean canHarmInCreative() {
        return this.isDamageAllowedInCreativeMode;
    }
    
    public Entity getSourceOfDamage() {
        return this.getEntity();
    }
    
    public boolean isDamageAbsolute() {
        return this.damageIsAbsolute;
    }
    
    public boolean isExplosion() {
        return this.explosion;
    }
    
    public static DamageSource causeIndirectMagicDamage(final Entity lllllllllllllllIIlIIIlllIlIlllIl, final Entity lllllllllllllllIIlIIIlllIlIllIlI) {
        return new EntityDamageSourceIndirect("indirectMagic", lllllllllllllllIIlIIIlllIlIlllIl, lllllllllllllllIIlIIIlllIlIllIlI).setDamageBypassesArmor().setMagicDamage();
    }
    
    public static DamageSource causeThornsDamage(final Entity lllllllllllllllIIlIIIlllIlIlIlll) {
        return new EntityDamageSource("thorns", lllllllllllllllIIlIIIlllIlIlIlll).func_180138_v().setMagicDamage();
    }
    
    static {
        __OBFID = "CL_00001521";
        DamageSource.inFire = new DamageSource("inFire").setFireDamage();
        DamageSource.field_180137_b = new DamageSource("lightningBolt");
        DamageSource.onFire = new DamageSource("onFire").setDamageBypassesArmor().setFireDamage();
        DamageSource.lava = new DamageSource("lava").setFireDamage();
        DamageSource.inWall = new DamageSource("inWall").setDamageBypassesArmor();
        DamageSource.drown = new DamageSource("drown").setDamageBypassesArmor();
        DamageSource.starve = new DamageSource("starve").setDamageBypassesArmor().setDamageIsAbsolute();
        DamageSource.cactus = new DamageSource("cactus");
        DamageSource.fall = new DamageSource("fall").setDamageBypassesArmor();
        DamageSource.outOfWorld = new DamageSource("outOfWorld").setDamageBypassesArmor().setDamageAllowedInCreativeMode();
        DamageSource.generic = new DamageSource("generic").setDamageBypassesArmor();
        DamageSource.magic = new DamageSource("magic").setDamageBypassesArmor().setMagicDamage();
        DamageSource.wither = new DamageSource("wither").setDamageBypassesArmor();
        DamageSource.anvil = new DamageSource("anvil");
        DamageSource.fallingBlock = new DamageSource("fallingBlock");
    }
    
    protected DamageSource setFireDamage() {
        this.fireDamage = true;
        return this;
    }
    
    protected DamageSource(final String lllllllllllllllIIlIIIlllIIllIllI) {
        this.hungerDamage = 0.3f;
        this.damageType = lllllllllllllllIIlIIIlllIIllIllI;
    }
    
    public static DamageSource causeArrowDamage(final EntityArrow lllllllllllllllIIlIIIlllIllIllll, final Entity lllllllllllllllIIlIIIlllIllIlllI) {
        return new EntityDamageSourceIndirect("arrow", lllllllllllllllIIlIIIlllIllIllll, lllllllllllllllIIlIIIlllIllIlllI).setProjectile();
    }
    
    public boolean isFireDamage() {
        return this.fireDamage;
    }
    
    public static DamageSource causeThrownDamage(final Entity lllllllllllllllIIlIIIlllIllIIIIl, final Entity lllllllllllllllIIlIIIlllIllIIIlI) {
        return new EntityDamageSourceIndirect("thrown", lllllllllllllllIIlIIIlllIllIIIIl, lllllllllllllllIIlIIIlllIllIIIlI).setProjectile();
    }
    
    public String getDamageType() {
        return this.damageType;
    }
    
    public Entity getEntity() {
        return null;
    }
    
    protected DamageSource setDamageIsAbsolute() {
        this.damageIsAbsolute = true;
        this.hungerDamage = 0.0f;
        return this;
    }
    
    protected DamageSource setDamageAllowedInCreativeMode() {
        this.isDamageAllowedInCreativeMode = true;
        return this;
    }
    
    public DamageSource setMagicDamage() {
        this.magicDamage = true;
        return this;
    }
    
    public DamageSource setProjectile() {
        this.projectile = true;
        return this;
    }
    
    public boolean isDifficultyScaled() {
        return this.difficultyScaled;
    }
}
