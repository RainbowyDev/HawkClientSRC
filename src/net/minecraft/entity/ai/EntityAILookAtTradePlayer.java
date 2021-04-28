package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class EntityAILookAtTradePlayer extends EntityAIWatchClosest
{
    private final /* synthetic */ EntityVillager theMerchant;
    
    @Override
    public boolean shouldExecute() {
        if (this.theMerchant.isTrading()) {
            this.closestEntity = this.theMerchant.getCustomer();
            return true;
        }
        return false;
    }
    
    public EntityAILookAtTradePlayer(final EntityVillager llllllllllllllIIlllIllIlIlllIIll) {
        super(llllllllllllllIIlllIllIlIlllIIll, EntityPlayer.class, 8.0f);
        this.theMerchant = llllllllllllllIIlllIllIlIlllIIll;
    }
    
    static {
        __OBFID = "CL_00001593";
    }
}
