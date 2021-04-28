package net.minecraft.block.material;

public class MaterialLogic extends Material
{
    @Override
    public boolean blocksLight() {
        return false;
    }
    
    public MaterialLogic(final MapColor lIlllllIIlIlI) {
        super(lIlllllIIlIlI);
        this.setAdventureModeExempt();
    }
    
    static {
        __OBFID = "CL_00000539";
    }
    
    @Override
    public boolean blocksMovement() {
        return false;
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
}
