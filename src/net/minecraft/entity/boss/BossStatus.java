package net.minecraft.entity.boss;

public final class BossStatus
{
    public static /* synthetic */ float healthScale;
    public static /* synthetic */ int statusBarTime;
    public static /* synthetic */ String bossName;
    public static /* synthetic */ boolean hasColorModifier;
    
    public static void setBossStatus(final IBossDisplayData llllllllllllllIlIIlIlIIlllIllIII, final boolean llllllllllllllIlIIlIlIIlllIllIIl) {
        BossStatus.healthScale = llllllllllllllIlIIlIlIIlllIllIII.getHealth() / llllllllllllllIlIIlIlIIlllIllIII.getMaxHealth();
        BossStatus.statusBarTime = 100;
        BossStatus.bossName = llllllllllllllIlIIlIlIIlllIllIII.getDisplayName().getFormattedText();
        BossStatus.hasColorModifier = llllllllllllllIlIIlIlIIlllIllIIl;
    }
    
    static {
        __OBFID = "CL_00000941";
    }
}
