package net.minecraft.block.material;

public class MaterialTransparent extends Material
{
    public MaterialTransparent(final MapColor llllllllllllllllIlIIIlIIlIllIIlI) {
        super(llllllllllllllllIlIIIlIIlIllIIlI);
        this.setReplaceable();
    }
    
    @Override
    public boolean blocksMovement() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000540";
    }
    
    @Override
    public boolean blocksLight() {
        return false;
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
}
