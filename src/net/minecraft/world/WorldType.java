package net.minecraft.world;

public class WorldType
{
    public static final /* synthetic */ WorldType DEFAULT;
    private /* synthetic */ boolean canBeCreated;
    private final /* synthetic */ int generatorVersion;
    private /* synthetic */ boolean isWorldTypeVersioned;
    private final /* synthetic */ int worldTypeId;
    private final /* synthetic */ String worldType;
    public static final /* synthetic */ WorldType DEFAULT_1_1;
    private /* synthetic */ boolean hasNotificationData;
    public static final /* synthetic */ WorldType[] worldTypes;
    
    private WorldType(final int llllllllllllllllIIIIllllllllIlIl, final String llllllllllllllllIIIIllllllllIIII, final int llllllllllllllllIIIIlllllllIllll) {
        this.worldType = llllllllllllllllIIIIllllllllIIII;
        this.generatorVersion = llllllllllllllllIIIIlllllllIllll;
        this.canBeCreated = true;
        this.worldTypeId = llllllllllllllllIIIIllllllllIlIl;
        WorldType.worldTypes[llllllllllllllllIIIIllllllllIlIl] = this;
    }
    
    public String func_151359_c() {
        return String.valueOf(new StringBuilder(String.valueOf(this.getTranslateName())).append(".info"));
    }
    
    public WorldType getWorldTypeForGeneratorVersion(final int llllllllllllllllIIIIllllllIlllIl) {
        return (this == WorldType.DEFAULT && llllllllllllllllIIIIllllllIlllIl == 0) ? WorldType.DEFAULT_1_1 : this;
    }
    
    public boolean getCanBeCreated() {
        return this.canBeCreated;
    }
    
    static {
        __OBFID = "CL_00000150";
        worldTypes = new WorldType[16];
        DEFAULT = new WorldType(0, "default", 1).setVersioned();
        FLAT = new WorldType(1, "flat");
        LARGE_BIOMES = new WorldType(2, "largeBiomes");
        AMPLIFIED = new WorldType(3, "amplified").setNotificationData();
        CUSTOMIZED = new WorldType(4, "customized");
        DEBUG_WORLD = new WorldType(5, "debug_all_block_states");
        DEFAULT_1_1 = new WorldType(8, "default_1_1", 0).setCanBeCreated(false);
    }
    
    public boolean isVersioned() {
        return this.isWorldTypeVersioned;
    }
    
    private WorldType setNotificationData() {
        this.hasNotificationData = true;
        return this;
    }
    
    public String getWorldTypeName() {
        return this.worldType;
    }
    
    public String getTranslateName() {
        return String.valueOf(new StringBuilder("generator.").append(this.worldType));
    }
    
    public static WorldType parseWorldType(final String llllllllllllllllIIIIllllllIIlIIl) {
        for (int llllllllllllllllIIIIllllllIIlIlI = 0; llllllllllllllllIIIIllllllIIlIlI < WorldType.worldTypes.length; ++llllllllllllllllIIIIllllllIIlIlI) {
            if (WorldType.worldTypes[llllllllllllllllIIIIllllllIIlIlI] != null && WorldType.worldTypes[llllllllllllllllIIIIllllllIIlIlI].worldType.equalsIgnoreCase(llllllllllllllllIIIIllllllIIlIIl)) {
                return WorldType.worldTypes[llllllllllllllllIIIIllllllIIlIlI];
            }
        }
        return null;
    }
    
    private WorldType setVersioned() {
        this.isWorldTypeVersioned = true;
        return this;
    }
    
    public int getGeneratorVersion() {
        return this.generatorVersion;
    }
    
    public boolean showWorldInfoNotice() {
        return this.hasNotificationData;
    }
    
    private WorldType(final int llllllllllllllllIIIIllllllllllll, final String llllllllllllllllIIIIlllllllllIll) {
        this(llllllllllllllllIIIIllllllllllll, llllllllllllllllIIIIlllllllllIll, 0);
    }
    
    private WorldType setCanBeCreated(final boolean llllllllllllllllIIIIllllllIllIIl) {
        this.canBeCreated = llllllllllllllllIIIIllllllIllIIl;
        return this;
    }
    
    public int getWorldTypeID() {
        return this.worldTypeId;
    }
}
