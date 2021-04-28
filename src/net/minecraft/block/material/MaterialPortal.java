package net.minecraft.block.material;

public class MaterialPortal extends Material
{
    @Override
    public boolean blocksLight() {
        return false;
    }
    
    public MaterialPortal(final MapColor llllllllllllllIIlIlIIIIllllIIlll) {
        super(llllllllllllllIIlIlIIIIllllIIlll);
    }
    
    @Override
    public boolean blocksMovement() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000545";
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
}
