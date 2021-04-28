package net.minecraft.util;

import net.minecraft.entity.*;

public class CombatEntry
{
    private final /* synthetic */ DamageSource damageSrc;
    private final /* synthetic */ float field_94564_f;
    private final /* synthetic */ int field_94567_b;
    private final /* synthetic */ float field_94565_d;
    private final /* synthetic */ String field_94566_e;
    private final /* synthetic */ float field_94568_c;
    
    public CombatEntry(final DamageSource lllllllllllllllllIllIIlllIlIlIIl, final int lllllllllllllllllIllIIlllIlIlIII, final float lllllllllllllllllIllIIlllIlIlllI, final float lllllllllllllllllIllIIlllIlIIllI, final String lllllllllllllllllIllIIlllIlIIlIl, final float lllllllllllllllllIllIIlllIlIIlII) {
        this.damageSrc = lllllllllllllllllIllIIlllIlIlIIl;
        this.field_94567_b = lllllllllllllllllIllIIlllIlIlIII;
        this.field_94568_c = lllllllllllllllllIllIIlllIlIIllI;
        this.field_94565_d = lllllllllllllllllIllIIlllIlIlllI;
        this.field_94566_e = lllllllllllllllllIllIIlllIlIIlIl;
        this.field_94564_f = lllllllllllllllllIllIIlllIlIIlII;
    }
    
    public IChatComponent func_151522_h() {
        return (this.getDamageSrc().getEntity() == null) ? null : this.getDamageSrc().getEntity().getDisplayName();
    }
    
    static {
        __OBFID = "CL_00001519";
    }
    
    public float func_94563_c() {
        return this.field_94568_c;
    }
    
    public boolean func_94559_f() {
        return this.damageSrc.getEntity() instanceof EntityLivingBase;
    }
    
    public DamageSource getDamageSrc() {
        return this.damageSrc;
    }
    
    public String func_94562_g() {
        return this.field_94566_e;
    }
    
    public float func_94561_i() {
        return (this.damageSrc == DamageSource.outOfWorld) ? Float.MAX_VALUE : this.field_94564_f;
    }
}
