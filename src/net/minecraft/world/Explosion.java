package net.minecraft.world;

import net.minecraft.block.material.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.block.*;

public class Explosion
{
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ float explosionSize;
    private final /* synthetic */ double explosionY;
    private final /* synthetic */ Map field_77288_k;
    private final /* synthetic */ Random explosionRNG;
    private final /* synthetic */ List affectedBlockPositions;
    private final /* synthetic */ boolean isFlaming;
    private final /* synthetic */ double explosionZ;
    private final /* synthetic */ Entity exploder;
    private final /* synthetic */ double explosionX;
    private final /* synthetic */ boolean isSmoking;
    
    public void doExplosionA() {
        final HashSet llllllllllllllIIIllllIlIIIIllIlI = Sets.newHashSet();
        final boolean llllllllllllllIIIllllIlIIIIllIIl = true;
        for (int llllllllllllllIIIllllIlIIIIlIlII = 0; llllllllllllllIIIllllIlIIIIlIlII < 16; ++llllllllllllllIIIllllIlIIIIlIlII) {
            for (int llllllllllllllIIIllllIlIIIIllIII = 0; llllllllllllllIIIllllIlIIIIllIII < 16; ++llllllllllllllIIIllllIlIIIIllIII) {
                for (int llllllllllllllIIIllllIlIIIIlIllI = 0; llllllllllllllIIIllllIlIIIIlIllI < 16; ++llllllllllllllIIIllllIlIIIIlIllI) {
                    if (llllllllllllllIIIllllIlIIIIlIlII == 0 || llllllllllllllIIIllllIlIIIIlIlII == 15 || llllllllllllllIIIllllIlIIIIllIII == 0 || llllllllllllllIIIllllIlIIIIllIII == 15 || llllllllllllllIIIllllIlIIIIlIllI == 0 || llllllllllllllIIIllllIlIIIIlIllI == 15) {
                        double llllllllllllllIIIllllIlIIIIlIIll = llllllllllllllIIIllllIlIIIIlIlII / 15.0f * 2.0f - 1.0f;
                        double llllllllllllllIIIllllIlIIIIlIIlI = llllllllllllllIIIllllIlIIIIllIII / 15.0f * 2.0f - 1.0f;
                        double llllllllllllllIIIllllIlIIIIlIIIl = llllllllllllllIIIllllIlIIIIlIllI / 15.0f * 2.0f - 1.0f;
                        final double llllllllllllllIIIllllIlIIIIlIIII = Math.sqrt(llllllllllllllIIIllllIlIIIIlIIll * llllllllllllllIIIllllIlIIIIlIIll + llllllllllllllIIIllllIlIIIIlIIlI * llllllllllllllIIIllllIlIIIIlIIlI + llllllllllllllIIIllllIlIIIIlIIIl * llllllllllllllIIIllllIlIIIIlIIIl);
                        llllllllllllllIIIllllIlIIIIlIIll /= llllllllllllllIIIllllIlIIIIlIIII;
                        llllllllllllllIIIllllIlIIIIlIIlI /= llllllllllllllIIIllllIlIIIIlIIII;
                        llllllllllllllIIIllllIlIIIIlIIIl /= llllllllllllllIIIllllIlIIIIlIIII;
                        float llllllllllllllIIIllllIlIIIIIllll = this.explosionSize * (0.7f + this.worldObj.rand.nextFloat() * 0.6f);
                        double llllllllllllllIIIllllIlIIIIIlllI = this.explosionX;
                        double llllllllllllllIIIllllIlIIIIIllIl = this.explosionY;
                        double llllllllllllllIIIllllIlIIIIIllII = this.explosionZ;
                        final float llllllllllllllIIIllllIlIIIIIlIll = 0.3f;
                        while (llllllllllllllIIIllllIlIIIIIllll > 0.0f) {
                            final BlockPos llllllllllllllIIIllllIlIIIIIlIlI = new BlockPos(llllllllllllllIIIllllIlIIIIIlllI, llllllllllllllIIIllllIlIIIIIllIl, llllllllllllllIIIllllIlIIIIIllII);
                            final IBlockState llllllllllllllIIIllllIlIIIIIlIIl = this.worldObj.getBlockState(llllllllllllllIIIllllIlIIIIIlIlI);
                            if (llllllllllllllIIIllllIlIIIIIlIIl.getBlock().getMaterial() != Material.air) {
                                final float llllllllllllllIIIllllIlIIIIIlIII = (this.exploder != null) ? this.exploder.getExplosionResistance(this, this.worldObj, llllllllllllllIIIllllIlIIIIIlIlI, llllllllllllllIIIllllIlIIIIIlIIl) : llllllllllllllIIIllllIlIIIIIlIIl.getBlock().getExplosionResistance(null);
                                llllllllllllllIIIllllIlIIIIIllll -= (llllllllllllllIIIllllIlIIIIIlIII + 0.3f) * 0.3f;
                            }
                            if (llllllllllllllIIIllllIlIIIIIllll > 0.0f && (this.exploder == null || this.exploder.func_174816_a(this, this.worldObj, llllllllllllllIIIllllIlIIIIIlIlI, llllllllllllllIIIllllIlIIIIIlIIl, llllllllllllllIIIllllIlIIIIIllll))) {
                                llllllllllllllIIIllllIlIIIIllIlI.add(llllllllllllllIIIllllIlIIIIIlIlI);
                            }
                            llllllllllllllIIIllllIlIIIIIlllI += llllllllllllllIIIllllIlIIIIlIIll * 0.30000001192092896;
                            llllllllllllllIIIllllIlIIIIIllIl += llllllllllllllIIIllllIlIIIIlIIlI * 0.30000001192092896;
                            llllllllllllllIIIllllIlIIIIIllII += llllllllllllllIIIllllIlIIIIlIIIl * 0.30000001192092896;
                            llllllllllllllIIIllllIlIIIIIllll -= 0.22500001f;
                        }
                    }
                }
            }
        }
        this.affectedBlockPositions.addAll(llllllllllllllIIIllllIlIIIIllIlI);
        final float llllllllllllllIIIllllIlIIIIIIlll = this.explosionSize * 2.0f;
        final int llllllllllllllIIIllllIlIIIIlIlll = MathHelper.floor_double(this.explosionX - llllllllllllllIIIllllIlIIIIIIlll - 1.0);
        final int llllllllllllllIIIllllIlIIIIlIlIl = MathHelper.floor_double(this.explosionX + llllllllllllllIIIllllIlIIIIIIlll + 1.0);
        final int llllllllllllllIIIllllIlIIIIIIllI = MathHelper.floor_double(this.explosionY - llllllllllllllIIIllllIlIIIIIIlll - 1.0);
        final int llllllllllllllIIIllllIlIIIIIIlIl = MathHelper.floor_double(this.explosionY + llllllllllllllIIIllllIlIIIIIIlll + 1.0);
        final int llllllllllllllIIIllllIlIIIIIIlII = MathHelper.floor_double(this.explosionZ - llllllllllllllIIIllllIlIIIIIIlll - 1.0);
        final int llllllllllllllIIIllllIlIIIIIIIll = MathHelper.floor_double(this.explosionZ + llllllllllllllIIIllllIlIIIIIIlll + 1.0);
        final List llllllllllllllIIIllllIlIIIIIIIlI = this.worldObj.getEntitiesWithinAABBExcludingEntity(this.exploder, new AxisAlignedBB(llllllllllllllIIIllllIlIIIIlIlll, llllllllllllllIIIllllIlIIIIIIllI, llllllllllllllIIIllllIlIIIIIIlII, llllllllllllllIIIllllIlIIIIlIlIl, llllllllllllllIIIllllIlIIIIIIlIl, llllllllllllllIIIllllIlIIIIIIIll));
        final Vec3 llllllllllllllIIIllllIlIIIIIIIIl = new Vec3(this.explosionX, this.explosionY, this.explosionZ);
        for (int llllllllllllllIIIllllIlIIIIIIIII = 0; llllllllllllllIIIllllIlIIIIIIIII < llllllllllllllIIIllllIlIIIIIIIlI.size(); ++llllllllllllllIIIllllIlIIIIIIIII) {
            final Entity llllllllllllllIIIllllIIlllllllll = llllllllllllllIIIllllIlIIIIIIIlI.get(llllllllllllllIIIllllIlIIIIIIIII);
            if (!llllllllllllllIIIllllIIlllllllll.func_180427_aV()) {
                final double llllllllllllllIIIllllIIllllllllI = llllllllllllllIIIllllIIlllllllll.getDistance(this.explosionX, this.explosionY, this.explosionZ) / llllllllllllllIIIllllIlIIIIIIlll;
                if (llllllllllllllIIIllllIIllllllllI <= 1.0) {
                    double llllllllllllllIIIllllIIlllllllIl = llllllllllllllIIIllllIIlllllllll.posX - this.explosionX;
                    double llllllllllllllIIIllllIIlllllllII = llllllllllllllIIIllllIIlllllllll.posY + llllllllllllllIIIllllIIlllllllll.getEyeHeight() - this.explosionY;
                    double llllllllllllllIIIllllIIllllllIll = llllllllllllllIIIllllIIlllllllll.posZ - this.explosionZ;
                    final double llllllllllllllIIIllllIIllllllIlI = MathHelper.sqrt_double(llllllllllllllIIIllllIIlllllllIl * llllllllllllllIIIllllIIlllllllIl + llllllllllllllIIIllllIIlllllllII * llllllllllllllIIIllllIIlllllllII + llllllllllllllIIIllllIIllllllIll * llllllllllllllIIIllllIIllllllIll);
                    if (llllllllllllllIIIllllIIllllllIlI != 0.0) {
                        llllllllllllllIIIllllIIlllllllIl /= llllllllllllllIIIllllIIllllllIlI;
                        llllllllllllllIIIllllIIlllllllII /= llllllllllllllIIIllllIIllllllIlI;
                        llllllllllllllIIIllllIIllllllIll /= llllllllllllllIIIllllIIllllllIlI;
                        final double llllllllllllllIIIllllIIllllllIIl = this.worldObj.getBlockDensity(llllllllllllllIIIllllIlIIIIIIIIl, llllllllllllllIIIllllIIlllllllll.getEntityBoundingBox());
                        final double llllllllllllllIIIllllIIllllllIII = (1.0 - llllllllllllllIIIllllIIllllllllI) * llllllllllllllIIIllllIIllllllIIl;
                        llllllllllllllIIIllllIIlllllllll.attackEntityFrom(DamageSource.setExplosionSource(this), (float)(int)((llllllllllllllIIIllllIIllllllIII * llllllllllllllIIIllllIIllllllIII + llllllllllllllIIIllllIIllllllIII) / 2.0 * 8.0 * llllllllllllllIIIllllIlIIIIIIlll + 1.0));
                        final double llllllllllllllIIIllllIIlllllIlll = EnchantmentProtection.func_92092_a(llllllllllllllIIIllllIIlllllllll, llllllllllllllIIIllllIIllllllIII);
                        final Entity entity = llllllllllllllIIIllllIIlllllllll;
                        entity.motionX += llllllllllllllIIIllllIIlllllllIl * llllllllllllllIIIllllIIlllllIlll;
                        final Entity entity2 = llllllllllllllIIIllllIIlllllllll;
                        entity2.motionY += llllllllllllllIIIllllIIlllllllII * llllllllllllllIIIllllIIlllllIlll;
                        final Entity entity3 = llllllllllllllIIIllllIIlllllllll;
                        entity3.motionZ += llllllllllllllIIIllllIIllllllIll * llllllllllllllIIIllllIIlllllIlll;
                        if (llllllllllllllIIIllllIIlllllllll instanceof EntityPlayer) {
                            this.field_77288_k.put(llllllllllllllIIIllllIIlllllllll, new Vec3(llllllllllllllIIIllllIIlllllllIl * llllllllllllllIIIllllIIllllllIII, llllllllllllllIIIllllIIlllllllII * llllllllllllllIIIllllIIllllllIII, llllllllllllllIIIllllIIllllllIll * llllllllllllllIIIllllIIllllllIII));
                        }
                    }
                }
            }
        }
    }
    
    public Map func_77277_b() {
        return this.field_77288_k;
    }
    
    public Explosion(final World llllllllllllllIIIllllIlIIlllIllI, final Entity llllllllllllllIIIllllIlIIlllIlIl, final double llllllllllllllIIIllllIlIIlllllII, final double llllllllllllllIIIllllIlIIlllIIll, final double llllllllllllllIIIllllIlIIlllIIlI, final float llllllllllllllIIIllllIlIIllllIIl, final List llllllllllllllIIIllllIlIIllllIII) {
        this(llllllllllllllIIIllllIlIIlllIllI, llllllllllllllIIIllllIlIIlllIlIl, llllllllllllllIIIllllIlIIlllllII, llllllllllllllIIIllllIlIIlllIIll, llllllllllllllIIIllllIlIIlllIIlI, llllllllllllllIIIllllIlIIllllIIl, false, true, llllllllllllllIIIllllIlIIllllIII);
    }
    
    static {
        __OBFID = "CL_00000134";
    }
    
    public List func_180343_e() {
        return this.affectedBlockPositions;
    }
    
    public Explosion(final World llllllllllllllIIIllllIlIIIlllllI, final Entity llllllllllllllIIIllllIlIIIllllIl, final double llllllllllllllIIIllllIlIIIllllII, final double llllllllllllllIIIllllIlIIlIIIlII, final double llllllllllllllIIIllllIlIIIlllIlI, final float llllllllllllllIIIllllIlIIlIIIIlI, final boolean llllllllllllllIIIllllIlIIlIIIIIl, final boolean llllllllllllllIIIllllIlIIIllIlll) {
        this.explosionRNG = new Random();
        this.affectedBlockPositions = Lists.newArrayList();
        this.field_77288_k = Maps.newHashMap();
        this.worldObj = llllllllllllllIIIllllIlIIIlllllI;
        this.exploder = llllllllllllllIIIllllIlIIIllllIl;
        this.explosionSize = llllllllllllllIIIllllIlIIlIIIIlI;
        this.explosionX = llllllllllllllIIIllllIlIIIllllII;
        this.explosionY = llllllllllllllIIIllllIlIIlIIIlII;
        this.explosionZ = llllllllllllllIIIllllIlIIIlllIlI;
        this.isFlaming = llllllllllllllIIIllllIlIIlIIIIIl;
        this.isSmoking = llllllllllllllIIIllllIlIIIllIlll;
    }
    
    public EntityLivingBase getExplosivePlacedBy() {
        return (this.exploder == null) ? null : ((this.exploder instanceof EntityTNTPrimed) ? ((EntityTNTPrimed)this.exploder).getTntPlacedBy() : ((this.exploder instanceof EntityLivingBase) ? ((EntityLivingBase)this.exploder) : null));
    }
    
    public void doExplosionB(final boolean llllllllllllllIIIllllIIlllIIllIl) {
        this.worldObj.playSoundEffect(this.explosionX, this.explosionY, this.explosionZ, "random.explode", 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
        if (this.explosionSize >= 2.0f && this.isSmoking) {
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.explosionX, this.explosionY, this.explosionZ, 1.0, 0.0, 0.0, new int[0]);
        }
        else {
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.explosionX, this.explosionY, this.explosionZ, 1.0, 0.0, 0.0, new int[0]);
        }
        if (this.isSmoking) {
            for (final BlockPos llllllllllllllIIIllllIIlllIIlIlI : this.affectedBlockPositions) {
                final Block llllllllllllllIIIllllIIlllIIlIII = this.worldObj.getBlockState(llllllllllllllIIIllllIIlllIIlIlI).getBlock();
                if (llllllllllllllIIIllllIIlllIIllIl) {
                    final double llllllllllllllIIIllllIIlllIIIlll = llllllllllllllIIIllllIIlllIIlIlI.getX() + this.worldObj.rand.nextFloat();
                    final double llllllllllllllIIIllllIIlllIIIllI = llllllllllllllIIIllllIIlllIIlIlI.getY() + this.worldObj.rand.nextFloat();
                    final double llllllllllllllIIIllllIIlllIIIlIl = llllllllllllllIIIllllIIlllIIlIlI.getZ() + this.worldObj.rand.nextFloat();
                    double llllllllllllllIIIllllIIlllIIIlII = llllllllllllllIIIllllIIlllIIIlll - this.explosionX;
                    double llllllllllllllIIIllllIIlllIIIIll = llllllllllllllIIIllllIIlllIIIllI - this.explosionY;
                    double llllllllllllllIIIllllIIlllIIIIlI = llllllllllllllIIIllllIIlllIIIlIl - this.explosionZ;
                    final double llllllllllllllIIIllllIIlllIIIIIl = MathHelper.sqrt_double(llllllllllllllIIIllllIIlllIIIlII * llllllllllllllIIIllllIIlllIIIlII + llllllllllllllIIIllllIIlllIIIIll * llllllllllllllIIIllllIIlllIIIIll + llllllllllllllIIIllllIIlllIIIIlI * llllllllllllllIIIllllIIlllIIIIlI);
                    llllllllllllllIIIllllIIlllIIIlII /= llllllllllllllIIIllllIIlllIIIIIl;
                    llllllllllllllIIIllllIIlllIIIIll /= llllllllllllllIIIllllIIlllIIIIIl;
                    llllllllllllllIIIllllIIlllIIIIlI /= llllllllllllllIIIllllIIlllIIIIIl;
                    double llllllllllllllIIIllllIIlllIIIIII = 0.5 / (llllllllllllllIIIllllIIlllIIIIIl / this.explosionSize + 0.1);
                    llllllllllllllIIIllllIIlllIIIIII *= this.worldObj.rand.nextFloat() * this.worldObj.rand.nextFloat() + 0.3f;
                    llllllllllllllIIIllllIIlllIIIlII *= llllllllllllllIIIllllIIlllIIIIII;
                    llllllllllllllIIIllllIIlllIIIIll *= llllllllllllllIIIllllIIlllIIIIII;
                    llllllllllllllIIIllllIIlllIIIIlI *= llllllllllllllIIIllllIIlllIIIIII;
                    this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, (llllllllllllllIIIllllIIlllIIIlll + this.explosionX * 1.0) / 2.0, (llllllllllllllIIIllllIIlllIIIllI + this.explosionY * 1.0) / 2.0, (llllllllllllllIIIllllIIlllIIIlIl + this.explosionZ * 1.0) / 2.0, llllllllllllllIIIllllIIlllIIIlII, llllllllllllllIIIllllIIlllIIIIll, llllllllllllllIIIllllIIlllIIIIlI, new int[0]);
                    this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllllIIIllllIIlllIIIlll, llllllllllllllIIIllllIIlllIIIllI, llllllllllllllIIIllllIIlllIIIlIl, llllllllllllllIIIllllIIlllIIIlII, llllllllllllllIIIllllIIlllIIIIll, llllllllllllllIIIllllIIlllIIIIlI, new int[0]);
                }
                if (llllllllllllllIIIllllIIlllIIlIII.getMaterial() != Material.air) {
                    if (llllllllllllllIIIllllIIlllIIlIII.canDropFromExplosion(this)) {
                        llllllllllllllIIIllllIIlllIIlIII.dropBlockAsItemWithChance(this.worldObj, llllllllllllllIIIllllIIlllIIlIlI, this.worldObj.getBlockState(llllllllllllllIIIllllIIlllIIlIlI), 1.0f / this.explosionSize, 0);
                    }
                    this.worldObj.setBlockState(llllllllllllllIIIllllIIlllIIlIlI, Blocks.air.getDefaultState(), 3);
                    llllllllllllllIIIllllIIlllIIlIII.onBlockDestroyedByExplosion(this.worldObj, llllllllllllllIIIllllIIlllIIlIlI, this);
                }
            }
        }
        if (this.isFlaming) {
            for (final BlockPos llllllllllllllIIIllllIIlllIIlIIl : this.affectedBlockPositions) {
                if (this.worldObj.getBlockState(llllllllllllllIIIllllIIlllIIlIIl).getBlock().getMaterial() == Material.air && this.worldObj.getBlockState(llllllllllllllIIIllllIIlllIIlIIl.offsetDown()).getBlock().isFullBlock() && this.explosionRNG.nextInt(3) == 0) {
                    this.worldObj.setBlockState(llllllllllllllIIIllllIIlllIIlIIl, Blocks.fire.getDefaultState());
                }
            }
        }
    }
    
    public Explosion(final World llllllllllllllIIIllllIlIIlIllIlI, final Entity llllllllllllllIIIllllIlIIllIIIll, final double llllllllllllllIIIllllIlIIllIIIlI, final double llllllllllllllIIIllllIlIIllIIIIl, final double llllllllllllllIIIllllIlIIlIlIllI, final float llllllllllllllIIIllllIlIIlIlIlIl, final boolean llllllllllllllIIIllllIlIIlIlIlII, final boolean llllllllllllllIIIllllIlIIlIlllIl, final List llllllllllllllIIIllllIlIIlIlllII) {
        this(llllllllllllllIIIllllIlIIlIllIlI, llllllllllllllIIIllllIlIIllIIIll, llllllllllllllIIIllllIlIIllIIIlI, llllllllllllllIIIllllIlIIllIIIIl, llllllllllllllIIIllllIlIIlIlIllI, llllllllllllllIIIllllIlIIlIlIlIl, llllllllllllllIIIllllIlIIlIlIlII, llllllllllllllIIIllllIlIIlIlllIl);
        this.affectedBlockPositions.addAll(llllllllllllllIIIllllIlIIlIlllII);
    }
    
    public void func_180342_d() {
        this.affectedBlockPositions.clear();
    }
}
