package net.minecraft.util;

import net.minecraft.entity.*;
import net.minecraft.item.*;

public class EntityDamageSourceIndirect extends EntityDamageSource
{
    private /* synthetic */ Entity indirectEntity;
    
    static {
        __OBFID = "CL_00001523";
    }
    
    @Override
    public IChatComponent getDeathMessage(final EntityLivingBase lllllllllllllllIIIIlIllIIIlllIlI) {
        final IChatComponent lllllllllllllllIIIIlIllIIIlllIIl = (this.indirectEntity == null) ? this.damageSourceEntity.getDisplayName() : this.indirectEntity.getDisplayName();
        final ItemStack lllllllllllllllIIIIlIllIIIlllIII = (this.indirectEntity instanceof EntityLivingBase) ? ((EntityLivingBase)this.indirectEntity).getHeldItem() : null;
        final String lllllllllllllllIIIIlIllIIIllIlll = String.valueOf(new StringBuilder("death.attack.").append(this.damageType));
        final String lllllllllllllllIIIIlIllIIIllIllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIIlIllIIIllIlll)).append(".item"));
        return (lllllllllllllllIIIIlIllIIIlllIII != null && lllllllllllllllIIIIlIllIIIlllIII.hasDisplayName() && StatCollector.canTranslate(lllllllllllllllIIIIlIllIIIllIllI)) ? new ChatComponentTranslation(lllllllllllllllIIIIlIllIIIllIllI, new Object[] { lllllllllllllllIIIIlIllIIIlllIlI.getDisplayName(), lllllllllllllllIIIIlIllIIIlllIIl, lllllllllllllllIIIIlIllIIIlllIII.getChatComponent() }) : new ChatComponentTranslation(lllllllllllllllIIIIlIllIIIllIlll, new Object[] { lllllllllllllllIIIIlIllIIIlllIlI.getDisplayName(), lllllllllllllllIIIIlIllIIIlllIIl });
    }
    
    @Override
    public Entity getSourceOfDamage() {
        return this.damageSourceEntity;
    }
    
    @Override
    public Entity getEntity() {
        return this.indirectEntity;
    }
    
    public EntityDamageSourceIndirect(final String lllllllllllllllIIIIlIllIIlIIlllI, final Entity lllllllllllllllIIIIlIllIIlIIlIIl, final Entity lllllllllllllllIIIIlIllIIlIIllII) {
        super(lllllllllllllllIIIIlIllIIlIIlllI, lllllllllllllllIIIIlIllIIlIIlIIl);
        this.indirectEntity = lllllllllllllllIIIIlIllIIlIIllII;
    }
}
