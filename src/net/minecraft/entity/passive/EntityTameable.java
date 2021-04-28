package net.minecraft.entity.passive;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.server.management.*;
import net.minecraft.scoreboard.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;

public abstract class EntityTameable extends EntityAnimal implements IEntityOwnable
{
    protected /* synthetic */ EntityAISit aiSit;
    
    static {
        __OBFID = "CL_00001561";
    }
    
    public void setSitting(final boolean llllllllllllllllIIllllIIlllIlIll) {
        final byte llllllllllllllllIIllllIIlllIllIl = this.dataWatcher.getWatchableObjectByte(16);
        if (llllllllllllllllIIllllIIlllIlIll) {
            this.dataWatcher.updateObject(16, (byte)(llllllllllllllllIIllllIIlllIllIl | 0x1));
        }
        else {
            this.dataWatcher.updateObject(16, (byte)(llllllllllllllllIIllllIIlllIllIl & 0xFFFFFFFE));
        }
    }
    
    public boolean isSitting() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    @Override
    public String func_152113_b() {
        return this.dataWatcher.getWatchableObjectString(17);
    }
    
    public boolean func_152114_e(final EntityLivingBase llllllllllllllllIIllllIIllIlIlII) {
        return llllllllllllllllIIllllIIllIlIlII == this.func_180492_cm();
    }
    
    protected void playTameEffect(final boolean llllllllllllllllIIllllIlIIIIlllI) {
        EnumParticleTypes llllllllllllllllIIllllIlIIIlIlII = EnumParticleTypes.HEART;
        if (!llllllllllllllllIIllllIlIIIIlllI) {
            llllllllllllllllIIllllIlIIIlIlII = EnumParticleTypes.SMOKE_NORMAL;
        }
        for (int llllllllllllllllIIllllIlIIIlIIll = 0; llllllllllllllllIIllllIlIIIlIIll < 7; ++llllllllllllllllIIllllIlIIIlIIll) {
            final double llllllllllllllllIIllllIlIIIlIIlI = this.rand.nextGaussian() * 0.02;
            final double llllllllllllllllIIllllIlIIIlIIIl = this.rand.nextGaussian() * 0.02;
            final double llllllllllllllllIIllllIlIIIlIIII = this.rand.nextGaussian() * 0.02;
            this.worldObj.spawnParticle(llllllllllllllllIIllllIlIIIlIlII, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, llllllllllllllllIIllllIlIIIlIIlI, llllllllllllllllIIllllIlIIIlIIIl, llllllllllllllllIIllllIlIIIlIIII, new int[0]);
        }
    }
    
    public boolean isTamed() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x4) != 0x0;
    }
    
    @Override
    public Entity getOwner() {
        return this.func_180492_cm();
    }
    
    public EntityTameable(final World llllllllllllllllIIllllIlIIllIIll) {
        super(llllllllllllllllIIllllIlIIllIIll);
        this.aiSit = new EntityAISit(this);
        this.func_175544_ck();
    }
    
    public void setTamed(final boolean llllllllllllllllIIllllIIlllllIll) {
        final byte llllllllllllllllIIllllIIlllllIlI = this.dataWatcher.getWatchableObjectByte(16);
        if (llllllllllllllllIIllllIIlllllIll) {
            this.dataWatcher.updateObject(16, (byte)(llllllllllllllllIIllllIIlllllIlI | 0x4));
        }
        else {
            this.dataWatcher.updateObject(16, (byte)(llllllllllllllllIIllllIIlllllIlI & 0xFFFFFFFB));
        }
        this.func_175544_ck();
    }
    
    @Override
    public boolean isOnSameTeam(final EntityLivingBase llllllllllllllllIIllllIIllIIIIll) {
        if (this.isTamed()) {
            final EntityLivingBase llllllllllllllllIIllllIIllIIIIlI = this.func_180492_cm();
            if (llllllllllllllllIIllllIIllIIIIll == llllllllllllllllIIllllIIllIIIIlI) {
                return true;
            }
            if (llllllllllllllllIIllllIIllIIIIlI != null) {
                return llllllllllllllllIIllllIIllIIIIlI.isOnSameTeam(llllllllllllllllIIllllIIllIIIIll);
            }
        }
        return super.isOnSameTeam(llllllllllllllllIIllllIIllIIIIll);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIIllllIlIIlIIIII) {
        super.readEntityFromNBT(llllllllllllllllIIllllIlIIlIIIII);
        String llllllllllllllllIIllllIlIIlIIIll = "";
        if (llllllllllllllllIIllllIlIIlIIIII.hasKey("OwnerUUID", 8)) {
            llllllllllllllllIIllllIlIIlIIIll = llllllllllllllllIIllllIlIIlIIIII.getString("OwnerUUID");
        }
        else {
            final String llllllllllllllllIIllllIlIIlIIIlI = llllllllllllllllIIllllIlIIlIIIII.getString("Owner");
            llllllllllllllllIIllllIlIIlIIIll = PreYggdrasilConverter.func_152719_a(llllllllllllllllIIllllIlIIlIIIlI);
        }
        if (llllllllllllllllIIllllIlIIlIIIll.length() > 0) {
            this.func_152115_b(llllllllllllllllIIllllIlIIlIIIll);
            this.setTamed(true);
        }
        this.aiSit.setSitting(llllllllllllllllIIllllIlIIlIIIII.getBoolean("Sitting"));
        this.setSitting(llllllllllllllllIIllllIlIIlIIIII.getBoolean("Sitting"));
    }
    
    @Override
    public Team getTeam() {
        if (this.isTamed()) {
            final EntityLivingBase llllllllllllllllIIllllIIllIIlIlI = this.func_180492_cm();
            if (llllllllllllllllIIllllIIllIIlIlI != null) {
                return llllllllllllllllIIllllIIllIIlIlI.getTeam();
            }
        }
        return super.getTeam();
    }
    
    public void func_152115_b(final String llllllllllllllllIIllllIIlllIIIll) {
        this.dataWatcher.updateObject(17, llllllllllllllllIIllllIIlllIIIll);
    }
    
    public EntityLivingBase func_180492_cm() {
        try {
            final UUID llllllllllllllllIIllllIIllIlllIl = UUID.fromString(this.func_152113_b());
            return (llllllllllllllllIIllllIIllIlllIl == null) ? null : this.worldObj.getPlayerEntityByUUID(llllllllllllllllIIllllIIllIlllIl);
        }
        catch (IllegalArgumentException llllllllllllllllIIllllIIllIlllII) {
            return null;
        }
    }
    
    protected void func_175544_ck() {
    }
    
    public EntityAISit getAISit() {
        return this.aiSit;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
        this.dataWatcher.addObject(17, "");
    }
    
    public boolean func_142018_a(final EntityLivingBase llllllllllllllllIIllllIIllIIllll, final EntityLivingBase llllllllllllllllIIllllIIllIIlllI) {
        return true;
    }
    
    @Override
    public void handleHealthUpdate(final byte llllllllllllllllIIllllIlIIIIIIll) {
        if (llllllllllllllllIIllllIlIIIIIIll == 7) {
            this.playTameEffect(true);
        }
        else if (llllllllllllllllIIllllIlIIIIIIll == 6) {
            this.playTameEffect(false);
        }
        else {
            super.handleHealthUpdate(llllllllllllllllIIllllIlIIIIIIll);
        }
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIIllllIlIIlIlIlI) {
        super.writeEntityToNBT(llllllllllllllllIIllllIlIIlIlIlI);
        if (this.func_152113_b() == null) {
            llllllllllllllllIIllllIlIIlIlIlI.setString("OwnerUUID", "");
        }
        else {
            llllllllllllllllIIllllIlIIlIlIlI.setString("OwnerUUID", this.func_152113_b());
        }
        llllllllllllllllIIllllIlIIlIlIlI.setBoolean("Sitting", this.isSitting());
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllllIIllllIIlIlllIll) {
        if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("showDeathMessages") && this.hasCustomName() && this.func_180492_cm() instanceof EntityPlayerMP) {
            ((EntityPlayerMP)this.func_180492_cm()).addChatMessage(this.getCombatTracker().func_151521_b());
        }
        super.onDeath(llllllllllllllllIIllllIIlIlllIll);
    }
}
