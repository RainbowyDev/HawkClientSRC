package net.minecraft.util;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class EntityDamageSource extends DamageSource
{
    protected /* synthetic */ Entity damageSourceEntity;
    private /* synthetic */ boolean field_180140_r;
    
    public EntityDamageSource(final String llllllllllllllIIIlIlIIIIllIlIlIl, final Entity llllllllllllllIIIlIlIIIIllIlIlII) {
        super(llllllllllllllIIIlIlIIIIllIlIlIl);
        this.field_180140_r = false;
        this.damageSourceEntity = llllllllllllllIIIlIlIIIIllIlIlII;
    }
    
    @Override
    public boolean isDifficultyScaled() {
        return this.damageSourceEntity != null && this.damageSourceEntity instanceof EntityLivingBase && !(this.damageSourceEntity instanceof EntityPlayer);
    }
    
    public boolean func_180139_w() {
        return this.field_180140_r;
    }
    
    static {
        __OBFID = "CL_00001522";
    }
    
    public EntityDamageSource func_180138_v() {
        this.field_180140_r = true;
        return this;
    }
    
    @Override
    public IChatComponent getDeathMessage(final EntityLivingBase llllllllllllllIIIlIlIIIIlIllllII) {
        final ItemStack llllllllllllllIIIlIlIIIIllIIIIII = (this.damageSourceEntity instanceof EntityLivingBase) ? ((EntityLivingBase)this.damageSourceEntity).getHeldItem() : null;
        final String llllllllllllllIIIlIlIIIIlIllllll = String.valueOf(new StringBuilder("death.attack.").append(this.damageType));
        final String llllllllllllllIIIlIlIIIIlIlllllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIlIIIIlIllllll)).append(".item"));
        return (llllllllllllllIIIlIlIIIIllIIIIII != null && llllllllllllllIIIlIlIIIIllIIIIII.hasDisplayName() && StatCollector.canTranslate(llllllllllllllIIIlIlIIIIlIlllllI)) ? new ChatComponentTranslation(llllllllllllllIIIlIlIIIIlIlllllI, new Object[] { llllllllllllllIIIlIlIIIIlIllllII.getDisplayName(), this.damageSourceEntity.getDisplayName(), llllllllllllllIIIlIlIIIIllIIIIII.getChatComponent() }) : new ChatComponentTranslation(llllllllllllllIIIlIlIIIIlIllllll, new Object[] { llllllllllllllIIIlIlIIIIlIllllII.getDisplayName(), this.damageSourceEntity.getDisplayName() });
    }
    
    @Override
    public Entity getEntity() {
        return this.damageSourceEntity;
    }
}
