package net.minecraft.block.material;

public class MaterialLiquid extends Material
{
    public MaterialLiquid(final MapColor llllllllllllllIIIlIllIIlIIllllIl) {
        super(llllllllllllllIIIlIllIIlIIllllIl);
        this.setReplaceable();
        this.setNoPushMobility();
    }
    
    static {
        __OBFID = "CL_00000541";
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
    
    @Override
    public boolean isLiquid() {
        return true;
    }
    
    @Override
    public boolean blocksMovement() {
        return false;
    }
}
