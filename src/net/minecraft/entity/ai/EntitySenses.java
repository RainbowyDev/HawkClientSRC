package net.minecraft.entity.ai;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;

public class EntitySenses
{
    /* synthetic */ List seenEntities;
    /* synthetic */ EntityLiving entityObj;
    /* synthetic */ List unseenEntities;
    
    public EntitySenses(final EntityLiving llllllllllllllIIIlIlIlIlIlIlIlIl) {
        this.seenEntities = Lists.newArrayList();
        this.unseenEntities = Lists.newArrayList();
        this.entityObj = llllllllllllllIIIlIlIlIlIlIlIlIl;
    }
    
    public void clearSensingCache() {
        this.seenEntities.clear();
        this.unseenEntities.clear();
    }
    
    public boolean canSee(final Entity llllllllllllllIIIlIlIlIlIlIIllIl) {
        if (this.seenEntities.contains(llllllllllllllIIIlIlIlIlIlIIllIl)) {
            return true;
        }
        if (this.unseenEntities.contains(llllllllllllllIIIlIlIlIlIlIIllIl)) {
            return false;
        }
        this.entityObj.worldObj.theProfiler.startSection("canSee");
        final boolean llllllllllllllIIIlIlIlIlIlIIllII = this.entityObj.canEntityBeSeen(llllllllllllllIIIlIlIlIlIlIIllIl);
        this.entityObj.worldObj.theProfiler.endSection();
        if (llllllllllllllIIIlIlIlIlIlIIllII) {
            this.seenEntities.add(llllllllllllllIIIlIlIlIlIlIIllIl);
        }
        else {
            this.unseenEntities.add(llllllllllllllIIIlIlIlIlIlIIllIl);
        }
        return llllllllllllllIIIlIlIlIlIlIIllII;
    }
    
    static {
        __OBFID = "CL_00001628";
    }
}
