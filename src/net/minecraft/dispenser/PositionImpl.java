package net.minecraft.dispenser;

public class PositionImpl implements IPosition
{
    protected final /* synthetic */ double z;
    protected final /* synthetic */ double x;
    protected final /* synthetic */ double y;
    
    public PositionImpl(final double llllllllllllllIllIlIlIlIIlllllIl, final double llllllllllllllIllIlIlIlIlIIIIIII, final double llllllllllllllIllIlIlIlIIlllllll) {
        this.x = llllllllllllllIllIlIlIlIIlllllIl;
        this.y = llllllllllllllIllIlIlIlIlIIIIIII;
        this.z = llllllllllllllIllIlIlIlIIlllllll;
    }
    
    @Override
    public double getY() {
        return this.y;
    }
    
    static {
        __OBFID = "CL_00001208";
    }
    
    @Override
    public double getX() {
        return this.x;
    }
    
    @Override
    public double getZ() {
        return this.z;
    }
}
