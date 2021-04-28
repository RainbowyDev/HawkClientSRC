package net.minecraft.world;

import net.minecraft.world.storage.*;
import net.minecraft.entity.player.*;

public final class WorldSettings
{
    private final /* synthetic */ boolean hardcoreEnabled;
    private /* synthetic */ boolean commandsAllowed;
    private final /* synthetic */ GameType theGameType;
    private /* synthetic */ String worldName;
    private /* synthetic */ boolean bonusChestEnabled;
    private final /* synthetic */ boolean mapFeaturesEnabled;
    private final /* synthetic */ long seed;
    private final /* synthetic */ WorldType terrainType;
    
    public boolean isMapFeaturesEnabled() {
        return this.mapFeaturesEnabled;
    }
    
    public WorldType getTerrainType() {
        return this.terrainType;
    }
    
    public boolean getHardcoreEnabled() {
        return this.hardcoreEnabled;
    }
    
    public WorldSettings enableBonusChest() {
        this.bonusChestEnabled = true;
        return this;
    }
    
    public GameType getGameType() {
        return this.theGameType;
    }
    
    public String getWorldName() {
        return this.worldName;
    }
    
    public long getSeed() {
        return this.seed;
    }
    
    public WorldSettings enableCommands() {
        this.commandsAllowed = true;
        return this;
    }
    
    public WorldSettings(final long lllllllllllllllIllIlIlIIlIIlIlII, final GameType lllllllllllllllIllIlIlIIlIIIllIl, final boolean lllllllllllllllIllIlIlIIlIIIllII, final boolean lllllllllllllllIllIlIlIIlIIlIIIl, final WorldType lllllllllllllllIllIlIlIIlIIIlIlI) {
        this.worldName = "";
        this.seed = lllllllllllllllIllIlIlIIlIIlIlII;
        this.theGameType = lllllllllllllllIllIlIlIIlIIIllIl;
        this.mapFeaturesEnabled = lllllllllllllllIllIlIlIIlIIIllII;
        this.hardcoreEnabled = lllllllllllllllIllIlIlIIlIIlIIIl;
        this.terrainType = lllllllllllllllIllIlIlIIlIIIlIlI;
    }
    
    public static GameType getGameTypeById(final int lllllllllllllllIllIlIlIIIllIIIIl) {
        return GameType.getByID(lllllllllllllllIllIlIlIIIllIIIIl);
    }
    
    public WorldSettings(final WorldInfo lllllllllllllllIllIlIlIIlIIIIlII) {
        this(lllllllllllllllIllIlIlIIlIIIIlII.getSeed(), lllllllllllllllIllIlIlIIlIIIIlII.getGameType(), lllllllllllllllIllIlIlIIlIIIIlII.isMapFeaturesEnabled(), lllllllllllllllIllIlIlIIlIIIIlII.isHardcoreModeEnabled(), lllllllllllllllIllIlIlIIlIIIIlII.getTerrainType());
    }
    
    public WorldSettings setWorldName(final String lllllllllllllllIllIlIlIIIllllIII) {
        this.worldName = lllllllllllllllIllIlIlIIIllllIII;
        return this;
    }
    
    static {
        __OBFID = "CL_00000147";
    }
    
    public boolean areCommandsAllowed() {
        return this.commandsAllowed;
    }
    
    public boolean isBonusChestEnabled() {
        return this.bonusChestEnabled;
    }
    
    public enum GameType
    {
        NOT_SET("NOT_SET", 0, "NOT_SET", 0, -1, ""), 
        ADVENTURE("ADVENTURE", 3, "ADVENTURE", 3, 2, "adventure");
        
        /* synthetic */ String name;
        
        CREATIVE("CREATIVE", 2, "CREATIVE", 2, 1, "creative"), 
        SPECTATOR("SPECTATOR", 4, "SPECTATOR", 4, 3, "spectator"), 
        SURVIVAL("SURVIVAL", 1, "SURVIVAL", 1, 0, "survival");
        
        /* synthetic */ int id;
        
        private GameType(final String llllllllllllllllIlIllIIIlIlIIlIl, final int llllllllllllllllIlIllIIIlIlIIlII, final String llllllllllllllllIlIllIIIlIlIlIlI, final int llllllllllllllllIlIllIIIlIlIlIIl, final int llllllllllllllllIlIllIIIlIlIIIll, final String llllllllllllllllIlIllIIIlIlIIIlI) {
            this.id = llllllllllllllllIlIllIIIlIlIIIll;
            this.name = llllllllllllllllIlIllIIIlIlIIIlI;
        }
        
        public static GameType getByName(final String llllllllllllllllIlIllIIIIlllIIll) {
            for (final GameType llllllllllllllllIlIllIIIIlllIlII : values()) {
                if (llllllllllllllllIlIllIIIIlllIlII.name.equals(llllllllllllllllIlIllIIIIlllIIll)) {
                    return llllllllllllllllIlIllIIIIlllIlII;
                }
            }
            return GameType.SURVIVAL;
        }
        
        public boolean isCreative() {
            return this == GameType.CREATIVE;
        }
        
        static {
            __OBFID = "CL_00000148";
        }
        
        public void configurePlayerCapabilities(final PlayerCapabilities llllllllllllllllIlIllIIIlIIllIII) {
            if (this == GameType.CREATIVE) {
                llllllllllllllllIlIllIIIlIIllIII.allowFlying = true;
                llllllllllllllllIlIllIIIlIIllIII.isCreativeMode = true;
                llllllllllllllllIlIllIIIlIIllIII.disableDamage = true;
            }
            else if (this == GameType.SPECTATOR) {
                llllllllllllllllIlIllIIIlIIllIII.allowFlying = true;
                llllllllllllllllIlIllIIIlIIllIII.isCreativeMode = false;
                llllllllllllllllIlIllIIIlIIllIII.disableDamage = true;
                llllllllllllllllIlIllIIIlIIllIII.isFlying = true;
            }
            else {
                llllllllllllllllIlIllIIIlIIllIII.allowFlying = false;
                llllllllllllllllIlIllIIIlIIllIII.isCreativeMode = false;
                llllllllllllllllIlIllIIIlIIllIII.disableDamage = false;
                llllllllllllllllIlIllIIIlIIllIII.isFlying = false;
            }
            llllllllllllllllIlIllIIIlIIllIII.allowEdit = !this.isAdventure();
        }
        
        public int getID() {
            return this.id;
        }
        
        public boolean isSurvivalOrAdventure() {
            return this == GameType.SURVIVAL || this == GameType.ADVENTURE;
        }
        
        public boolean isAdventure() {
            return this == GameType.ADVENTURE || this == GameType.SPECTATOR;
        }
        
        public static GameType getByID(final int llllllllllllllllIlIllIIIlIIIIIlI) {
            for (final GameType llllllllllllllllIlIllIIIlIIIIIll : values()) {
                if (llllllllllllllllIlIllIIIlIIIIIll.id == llllllllllllllllIlIllIIIlIIIIIlI) {
                    return llllllllllllllllIlIllIIIlIIIIIll;
                }
            }
            return GameType.SURVIVAL;
        }
        
        public String getName() {
            return this.name;
        }
    }
}
