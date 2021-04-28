package net.minecraft.block.material;

public class Material
{
    private final /* synthetic */ MapColor materialMapColor;
    private /* synthetic */ boolean isTranslucent;
    private /* synthetic */ boolean replaceable;
    private /* synthetic */ boolean canBurn;
    private /* synthetic */ int mobilityFlag;
    private /* synthetic */ boolean isAdventureModeExempt;
    private /* synthetic */ boolean requiresNoTool;
    
    public boolean isSolid() {
        return true;
    }
    
    public Material setReplaceable() {
        this.replaceable = true;
        return this;
    }
    
    static {
        __OBFID = "CL_00000542";
        air = new MaterialTransparent(MapColor.airColor);
        grass = new Material(MapColor.grassColor);
        ground = new Material(MapColor.dirtColor);
        wood = new Material(MapColor.woodColor).setBurning();
        rock = new Material(MapColor.stoneColor).setRequiresTool();
        iron = new Material(MapColor.ironColor).setRequiresTool();
        anvil = new Material(MapColor.ironColor).setRequiresTool().setImmovableMobility();
        water = new MaterialLiquid(MapColor.waterColor).setNoPushMobility();
        lava = new MaterialLiquid(MapColor.tntColor).setNoPushMobility();
        leaves = new Material(MapColor.foliageColor).setBurning().setTranslucent().setNoPushMobility();
        plants = new MaterialLogic(MapColor.foliageColor).setNoPushMobility();
        vine = new MaterialLogic(MapColor.foliageColor).setBurning().setNoPushMobility().setReplaceable();
        sponge = new Material(MapColor.clothColor);
        cloth = new Material(MapColor.clothColor).setBurning();
        fire = new MaterialTransparent(MapColor.airColor).setNoPushMobility();
        sand = new Material(MapColor.sandColor);
        circuits = new MaterialLogic(MapColor.airColor).setNoPushMobility();
        carpet = new MaterialLogic(MapColor.clothColor).setBurning();
        glass = new Material(MapColor.airColor).setTranslucent().setAdventureModeExempt();
        redstoneLight = new Material(MapColor.airColor).setAdventureModeExempt();
        tnt = new Material(MapColor.tntColor).setBurning().setTranslucent();
        coral = new Material(MapColor.foliageColor).setNoPushMobility();
        ice = new Material(MapColor.iceColor).setTranslucent().setAdventureModeExempt();
        packedIce = new Material(MapColor.iceColor).setAdventureModeExempt();
        snow = new MaterialLogic(MapColor.snowColor).setReplaceable().setTranslucent().setRequiresTool().setNoPushMobility();
        craftedSnow = new Material(MapColor.snowColor).setRequiresTool();
        cactus = new Material(MapColor.foliageColor).setTranslucent().setNoPushMobility();
        clay = new Material(MapColor.clayColor);
        gourd = new Material(MapColor.foliageColor).setNoPushMobility();
        dragonEgg = new Material(MapColor.foliageColor).setNoPushMobility();
        portal = new MaterialPortal(MapColor.airColor).setImmovableMobility();
        cake = new Material(MapColor.airColor).setNoPushMobility();
        web = new Material() {
            @Override
            public boolean blocksMovement() {
                return false;
            }
            
            static {
                __OBFID = "CL_00000543";
            }
        }.setRequiresTool().setNoPushMobility();
        piston = new Material(MapColor.stoneColor).setImmovableMobility();
        barrier = new Material(MapColor.airColor).setRequiresTool().setImmovableMobility();
    }
    
    protected Material setNoPushMobility() {
        this.mobilityFlag = 1;
        return this;
    }
    
    protected Material setBurning() {
        this.canBurn = true;
        return this;
    }
    
    public boolean blocksMovement() {
        return true;
    }
    
    private Material setTranslucent() {
        this.isTranslucent = true;
        return this;
    }
    
    public boolean isToolNotRequired() {
        return this.requiresNoTool;
    }
    
    public boolean isOpaque() {
        return !this.isTranslucent && this.blocksMovement();
    }
    
    protected Material setAdventureModeExempt() {
        this.isAdventureModeExempt = true;
        return this;
    }
    
    protected Material setRequiresTool() {
        this.requiresNoTool = false;
        return this;
    }
    
    public boolean isReplaceable() {
        return this.replaceable;
    }
    
    public boolean blocksLight() {
        return true;
    }
    
    public boolean isLiquid() {
        return false;
    }
    
    public MapColor getMaterialMapColor() {
        return this.materialMapColor;
    }
    
    protected Material setImmovableMobility() {
        this.mobilityFlag = 2;
        return this;
    }
    
    public Material(final MapColor lllllllllllllllIIllIllIIlIIIlIII) {
        this.requiresNoTool = true;
        this.materialMapColor = lllllllllllllllIIllIllIIlIIIlIII;
    }
    
    public boolean getCanBurn() {
        return this.canBurn;
    }
    
    public int getMaterialMobility() {
        return this.mobilityFlag;
    }
}
