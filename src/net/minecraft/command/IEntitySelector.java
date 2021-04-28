package net.minecraft.command;

import com.google.common.base.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;

public final class IEntitySelector
{
    static {
        __OBFID = "CL_00002257";
        selectAnything = (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00001541";
            }
            
            public boolean func_180131_a(final Entity lllllllllllllllIIIIIllIlllIIIlIl) {
                return lllllllllllllllIIIIIllIlllIIIlIl.isEntityAlive();
            }
            
            public boolean apply(final Object lllllllllllllllIIIIIllIllIllllll) {
                return this.func_180131_a((Entity)lllllllllllllllIIIIIllIllIllllll);
            }
        };
        field_152785_b = (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00001542";
            }
            
            public boolean apply(final Object llllllllllllllllllIlllIlIIIIIlII) {
                return this.func_180130_a((Entity)llllllllllllllllllIlllIlIIIIIlII);
            }
            
            public boolean func_180130_a(final Entity llllllllllllllllllIlllIlIIIIlIll) {
                return llllllllllllllllllIlllIlIIIIlIll.isEntityAlive() && llllllllllllllllllIlllIlIIIIlIll.riddenByEntity == null && llllllllllllllllllIlllIlIIIIlIll.ridingEntity == null;
            }
        };
        selectInventories = (Predicate)new Predicate() {
            public boolean apply(final Object llllllllllllllIlIIIIIIlIIIIIlIIl) {
                return this.func_180102_a((Entity)llllllllllllllIlIIIIIIlIIIIIlIIl);
            }
            
            static {
                __OBFID = "CL_00001867";
            }
            
            public boolean func_180102_a(final Entity llllllllllllllIlIIIIIIlIIIIIllll) {
                return llllllllllllllIlIIIIIIlIIIIIllll instanceof IInventory && llllllllllllllIlIIIIIIlIIIIIllll.isEntityAlive();
            }
        };
        field_180132_d = (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00002256";
            }
            
            public boolean apply(final Object llllllllllllllIIlIlIlllIllIIIllI) {
                return this.func_180103_a((Entity)llllllllllllllIIlIlIlllIllIIIllI);
            }
            
            public boolean func_180103_a(final Entity llllllllllllllIIlIlIlllIllIIllII) {
                return !(llllllllllllllIIlIlIlllIllIIllII instanceof EntityPlayer) || !((EntityPlayer)llllllllllllllIIlIlIlllIllIIllII).func_175149_v();
            }
        };
    }
    
    public static class ArmoredMob implements Predicate
    {
        private final /* synthetic */ ItemStack field_96567_c;
        
        public ArmoredMob(final ItemStack lllllllllllllllIIIIllIllIIllIlII) {
            this.field_96567_c = lllllllllllllllIIIIllIllIIllIlII;
        }
        
        static {
            __OBFID = "CL_00001543";
        }
        
        public boolean func_180100_a(final Entity lllllllllllllllIIIIllIllIIlIlIlI) {
            if (!lllllllllllllllIIIIllIllIIlIlIlI.isEntityAlive()) {
                return false;
            }
            if (!(lllllllllllllllIIIIllIllIIlIlIlI instanceof EntityLivingBase)) {
                return false;
            }
            final EntityLivingBase lllllllllllllllIIIIllIllIIlIllII = (EntityLivingBase)lllllllllllllllIIIIllIllIIlIlIlI;
            return lllllllllllllllIIIIllIllIIlIllII.getEquipmentInSlot(EntityLiving.getArmorPosition(this.field_96567_c)) == null && ((lllllllllllllllIIIIllIllIIlIllII instanceof EntityLiving) ? ((EntityLiving)lllllllllllllllIIIIllIllIIlIllII).canPickUpLoot() : (lllllllllllllllIIIIllIllIIlIllII instanceof EntityArmorStand || lllllllllllllllIIIIllIllIIlIllII instanceof EntityPlayer));
        }
        
        public boolean apply(final Object lllllllllllllllIIIIllIllIIlIIlIl) {
            return this.func_180100_a((Entity)lllllllllllllllIIIIllIllIIlIIlIl);
        }
    }
}
