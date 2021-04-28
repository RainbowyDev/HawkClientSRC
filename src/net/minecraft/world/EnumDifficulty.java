package net.minecraft.world;

public enum EnumDifficulty
{
    PEACEFUL("PEACEFUL", 0, "PEACEFUL", 0, 0, "options.difficulty.peaceful");
    
    private final /* synthetic */ String difficultyResourceKey;
    
    HARD("HARD", 3, "HARD", 3, 3, "options.difficulty.hard");
    
    private final /* synthetic */ int difficultyId;
    
    EASY("EASY", 1, "EASY", 1, 1, "options.difficulty.easy"), 
    NORMAL("NORMAL", 2, "NORMAL", 2, 2, "options.difficulty.normal");
    
    private static final /* synthetic */ EnumDifficulty[] difficultyEnums;
    
    private EnumDifficulty(final String llllllllllllllIllllIllllIIIllIII, final int llllllllllllllIllllIllllIIIlIlll, final String llllllllllllllIllllIllllIIIlllIl, final int llllllllllllllIllllIllllIIIlllII, final int llllllllllllllIllllIllllIIIlIllI, final String llllllllllllllIllllIllllIIIlIlIl) {
        this.difficultyId = llllllllllllllIllllIllllIIIlIllI;
        this.difficultyResourceKey = llllllllllllllIllllIllllIIIlIlIl;
    }
    
    public String getDifficultyResourceKey() {
        return this.difficultyResourceKey;
    }
    
    static {
        __OBFID = "CL_00001510";
        difficultyEnums = new EnumDifficulty[values().length];
        for (final EnumDifficulty llllllllllllllIllllIllllIIlIlIII : values()) {
            EnumDifficulty.difficultyEnums[llllllllllllllIllllIllllIIlIlIII.difficultyId] = llllllllllllllIllllIllllIIlIlIII;
        }
    }
    
    public int getDifficultyId() {
        return this.difficultyId;
    }
    
    public static EnumDifficulty getDifficultyEnum(final int llllllllllllllIllllIllllIIIlIIII) {
        return EnumDifficulty.difficultyEnums[llllllllllllllIllllIllllIIIlIIII % EnumDifficulty.difficultyEnums.length];
    }
}
