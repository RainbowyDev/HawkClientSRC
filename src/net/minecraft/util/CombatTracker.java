package net.minecraft.util;

import net.minecraft.entity.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class CombatTracker
{
    private final /* synthetic */ EntityLivingBase fighter;
    private /* synthetic */ String field_94551_f;
    private /* synthetic */ int field_94555_c;
    private /* synthetic */ boolean field_94553_e;
    private /* synthetic */ int field_152775_d;
    private /* synthetic */ int field_152776_e;
    private /* synthetic */ boolean field_94552_d;
    private final /* synthetic */ List combatEntries;
    
    public void func_94549_h() {
        final int lIIIIllIlllllll = this.field_94552_d ? 300 : 100;
        if (this.field_94553_e && (!this.fighter.isEntityAlive() || this.fighter.ticksExisted - this.field_94555_c > lIIIIllIlllllll)) {
            final boolean lIIIIllIllllllI = this.field_94552_d;
            this.field_94553_e = false;
            this.field_94552_d = false;
            this.field_152776_e = this.fighter.ticksExisted;
            if (lIIIIllIllllllI) {
                this.fighter.func_152112_bu();
            }
            this.combatEntries.clear();
        }
    }
    
    public int func_180134_f() {
        return this.field_94552_d ? (this.fighter.ticksExisted - this.field_152775_d) : (this.field_152776_e - this.field_152775_d);
    }
    
    private CombatEntry func_94544_f() {
        CombatEntry lIIIIlllIIlllII = null;
        CombatEntry lIIIIlllIIllIll = null;
        final byte lIIIIlllIIllIlI = 0;
        float lIIIIlllIIllIIl = 0.0f;
        for (int lIIIIlllIIllIII = 0; lIIIIlllIIllIII < this.combatEntries.size(); ++lIIIIlllIIllIII) {
            final CombatEntry lIIIIlllIIlIlll = this.combatEntries.get(lIIIIlllIIllIII);
            final CombatEntry lIIIIlllIIlIllI = (lIIIIlllIIllIII > 0) ? this.combatEntries.get(lIIIIlllIIllIII - 1) : null;
            if ((lIIIIlllIIlIlll.getDamageSrc() == DamageSource.fall || lIIIIlllIIlIlll.getDamageSrc() == DamageSource.outOfWorld) && lIIIIlllIIlIlll.func_94561_i() > 0.0f && (lIIIIlllIIlllII == null || lIIIIlllIIlIlll.func_94561_i() > lIIIIlllIIllIIl)) {
                if (lIIIIlllIIllIII > 0) {
                    lIIIIlllIIlllII = lIIIIlllIIlIllI;
                }
                else {
                    lIIIIlllIIlllII = lIIIIlllIIlIlll;
                }
                lIIIIlllIIllIIl = lIIIIlllIIlIlll.func_94561_i();
            }
            if (lIIIIlllIIlIlll.func_94562_g() != null && (lIIIIlllIIllIll == null || lIIIIlllIIlIlll.func_94563_c() > lIIIIlllIIllIlI)) {
                lIIIIlllIIllIll = lIIIIlllIIlIlll;
            }
        }
        if (lIIIIlllIIllIIl > 5.0f && lIIIIlllIIlllII != null) {
            return lIIIIlllIIlllII;
        }
        if (lIIIIlllIIllIlI > 5 && lIIIIlllIIllIll != null) {
            return lIIIIlllIIllIll;
        }
        return null;
    }
    
    public IChatComponent func_151521_b() {
        if (this.combatEntries.size() == 0) {
            return new ChatComponentTranslation("death.attack.generic", new Object[] { this.fighter.getDisplayName() });
        }
        final CombatEntry lIIIIllllIlIIlI = this.func_94544_f();
        final CombatEntry lIIIIllllIlIIIl = this.combatEntries.get(this.combatEntries.size() - 1);
        final IChatComponent lIIIIllllIlIIII = lIIIIllllIlIIIl.func_151522_h();
        final Entity lIIIIllllIIllll = lIIIIllllIlIIIl.getDamageSrc().getEntity();
        Object lIIIIllllIIlIII = null;
        if (lIIIIllllIlIIlI != null && lIIIIllllIlIIIl.getDamageSrc() == DamageSource.fall) {
            final IChatComponent lIIIIllllIIIlll = lIIIIllllIlIIlI.func_151522_h();
            if (lIIIIllllIlIIlI.getDamageSrc() != DamageSource.fall && lIIIIllllIlIIlI.getDamageSrc() != DamageSource.outOfWorld) {
                if (lIIIIllllIIIlll != null && (lIIIIllllIlIIII == null || !lIIIIllllIIIlll.equals(lIIIIllllIlIIII))) {
                    final Entity lIIIIllllIIIllI = lIIIIllllIlIIlI.getDamageSrc().getEntity();
                    final ItemStack lIIIIllllIIIlIl = (lIIIIllllIIIllI instanceof EntityLivingBase) ? ((EntityLivingBase)lIIIIllllIIIllI).getHeldItem() : null;
                    if (lIIIIllllIIIlIl != null && lIIIIllllIIIlIl.hasDisplayName()) {
                        final Object lIIIIllllIIlllI = new ChatComponentTranslation("death.fell.assist.item", new Object[] { this.fighter.getDisplayName(), lIIIIllllIIIlll, lIIIIllllIIIlIl.getChatComponent() });
                    }
                    else {
                        final Object lIIIIllllIIllIl = new ChatComponentTranslation("death.fell.assist", new Object[] { this.fighter.getDisplayName(), lIIIIllllIIIlll });
                    }
                }
                else if (lIIIIllllIlIIII != null) {
                    final ItemStack lIIIIllllIIIlII = (lIIIIllllIIllll instanceof EntityLivingBase) ? ((EntityLivingBase)lIIIIllllIIllll).getHeldItem() : null;
                    if (lIIIIllllIIIlII != null && lIIIIllllIIIlII.hasDisplayName()) {
                        final Object lIIIIllllIIllII = new ChatComponentTranslation("death.fell.finish.item", new Object[] { this.fighter.getDisplayName(), lIIIIllllIlIIII, lIIIIllllIIIlII.getChatComponent() });
                    }
                    else {
                        final Object lIIIIllllIIlIll = new ChatComponentTranslation("death.fell.finish", new Object[] { this.fighter.getDisplayName(), lIIIIllllIlIIII });
                    }
                }
                else {
                    final Object lIIIIllllIIlIlI = new ChatComponentTranslation("death.fell.killer", new Object[] { this.fighter.getDisplayName() });
                }
            }
            else {
                final Object lIIIIllllIIlIIl = new ChatComponentTranslation(String.valueOf(new StringBuilder("death.fell.accident.").append(this.func_94548_b(lIIIIllllIlIIlI))), new Object[] { this.fighter.getDisplayName() });
            }
        }
        else {
            lIIIIllllIIlIII = lIIIIllllIlIIIl.getDamageSrc().getDeathMessage(this.fighter);
        }
        return (IChatComponent)lIIIIllllIIlIII;
    }
    
    public CombatTracker(final EntityLivingBase lIIIIllllllIlII) {
        this.combatEntries = Lists.newArrayList();
        this.fighter = lIIIIllllllIlII;
    }
    
    public void func_94547_a(final DamageSource lIIIIlllllIIlIl, final float lIIIIllllIlllll, final float lIIIIllllIllllI) {
        this.func_94549_h();
        this.func_94545_a();
        final CombatEntry lIIIIlllllIIIlI = new CombatEntry(lIIIIlllllIIlIl, this.fighter.ticksExisted, lIIIIllllIlllll, lIIIIllllIllllI, this.field_94551_f, this.fighter.fallDistance);
        this.combatEntries.add(lIIIIlllllIIIlI);
        this.field_94555_c = this.fighter.ticksExisted;
        this.field_94553_e = true;
        if (lIIIIlllllIIIlI.func_94559_f() && !this.field_94552_d && this.fighter.isEntityAlive()) {
            this.field_94552_d = true;
            this.field_152775_d = this.fighter.ticksExisted;
            this.field_152776_e = this.field_152775_d;
            this.fighter.func_152111_bt();
        }
    }
    
    public void func_94545_a() {
        this.func_94542_g();
        if (this.fighter.isOnLadder()) {
            final Block lIIIIlllllIlllI = this.fighter.worldObj.getBlockState(new BlockPos(this.fighter.posX, this.fighter.getEntityBoundingBox().minY, this.fighter.posZ)).getBlock();
            if (lIIIIlllllIlllI == Blocks.ladder) {
                this.field_94551_f = "ladder";
            }
            else if (lIIIIlllllIlllI == Blocks.vine) {
                this.field_94551_f = "vines";
            }
        }
        else if (this.fighter.isInWater()) {
            this.field_94551_f = "water";
        }
    }
    
    public EntityLivingBase func_180135_h() {
        return this.fighter;
    }
    
    private String func_94548_b(final CombatEntry lIIIIlllIIIlIll) {
        return (lIIIIlllIIIlIll.func_94562_g() == null) ? "generic" : lIIIIlllIIIlIll.func_94562_g();
    }
    
    private void func_94542_g() {
        this.field_94551_f = null;
    }
    
    public EntityLivingBase func_94550_c() {
        EntityLivingBase lIIIIlllIllIIlI = null;
        EntityPlayer lIIIIlllIllIIIl = null;
        float lIIIIlllIllIIII = 0.0f;
        float lIIIIlllIlIllll = 0.0f;
        for (final CombatEntry lIIIIlllIlIllIl : this.combatEntries) {
            if (lIIIIlllIlIllIl.getDamageSrc().getEntity() instanceof EntityPlayer && (lIIIIlllIllIIIl == null || lIIIIlllIlIllIl.func_94563_c() > lIIIIlllIlIllll)) {
                lIIIIlllIlIllll = lIIIIlllIlIllIl.func_94563_c();
                lIIIIlllIllIIIl = (EntityPlayer)lIIIIlllIlIllIl.getDamageSrc().getEntity();
            }
            if (lIIIIlllIlIllIl.getDamageSrc().getEntity() instanceof EntityLivingBase && (lIIIIlllIllIIlI == null || lIIIIlllIlIllIl.func_94563_c() > lIIIIlllIllIIII)) {
                lIIIIlllIllIIII = lIIIIlllIlIllIl.func_94563_c();
                lIIIIlllIllIIlI = (EntityLivingBase)lIIIIlllIlIllIl.getDamageSrc().getEntity();
            }
        }
        if (lIIIIlllIllIIIl != null && lIIIIlllIlIllll >= lIIIIlllIllIIII / 3.0f) {
            return lIIIIlllIllIIIl;
        }
        return lIIIIlllIllIIlI;
    }
    
    static {
        __OBFID = "CL_00001520";
    }
}
