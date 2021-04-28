package net.minecraft.client.resources.model;

import java.util.*;
import net.minecraftforge.client.model.*;
import net.minecraft.util.*;
import javax.vecmath.*;
import optifine.*;
import com.google.common.collect.*;

public enum ModelRotation implements IModelState, ITransformation
{
    private static final /* synthetic */ Map field_177546_q;
    
    X0_Y270("X0_Y270", 3, "X0_Y270", 3, 0, 270), 
    X0_Y180("X0_Y180", 2, "X0_Y180", 2, 0, 180), 
    X180_Y180("X180_Y180", 10, "X180_Y180", 10, 180, 180);
    
    private final /* synthetic */ Matrix4d field_177544_s;
    
    X270_Y270("X270_Y270", 15, "X270_Y270", 15, 270, 270), 
    X90_Y0("X90_Y0", 4, "X90_Y0", 4, 90, 0), 
    X90_Y180("X90_Y180", 6, "X90_Y180", 6, 90, 180);
    
    private final /* synthetic */ int field_177545_r;
    
    X270_Y90("X270_Y90", 13, "X270_Y90", 13, 270, 90);
    
    private final /* synthetic */ int field_177542_u;
    
    X180_Y90("X180_Y90", 9, "X180_Y90", 9, 180, 90), 
    X270_Y180("X270_Y180", 14, "X270_Y180", 14, 270, 180), 
    X270_Y0("X270_Y0", 12, "X270_Y0", 12, 270, 0), 
    X0_Y90("X0_Y90", 1, "X0_Y90", 1, 0, 90), 
    X180_Y0("X180_Y0", 8, "X180_Y0", 8, 180, 0), 
    X180_Y270("X180_Y270", 11, "X180_Y270", 11, 180, 270), 
    X0_Y0("X0_Y0", 0, "X0_Y0", 0, 0, 0), 
    X90_Y90("X90_Y90", 5, "X90_Y90", 5, 90, 90);
    
    private final /* synthetic */ int field_177543_t;
    
    X90_Y270("X90_Y270", 7, "X90_Y270", 7, 90, 270);
    
    @Override
    public TRSRTransformation apply(final IModelPart llllllllllllllIlIIIlIIllllIllllI) {
        return new TRSRTransformation(this.getMatrix());
    }
    
    @Override
    public int rotate(final EnumFacing llllllllllllllIlIIIlIIllllIIllll, final int llllllllllllllIlIIIlIIllllIIlllI) {
        return this.func_177520_a(llllllllllllllIlIIIlIIllllIIllll, llllllllllllllIlIIIlIIllllIIlllI);
    }
    
    private ModelRotation(final String llllllllllllllIlIIIlIlIIIIIIllIl, final int llllllllllllllIlIIIlIlIIIIIIllII, final String llllllllllllllIlIIIlIlIIIIIlIlII, final int llllllllllllllIlIIIlIlIIIIIlIIll, final int llllllllllllllIlIIIlIlIIIIIIlIll, final int llllllllllllllIlIIIlIlIIIIIIlIlI) {
        this.field_177545_r = func_177521_b(llllllllllllllIlIIIlIlIIIIIIlIll, llllllllllllllIlIIIlIlIIIIIIlIlI);
        this.field_177544_s = new Matrix4d();
        final Matrix4d llllllllllllllIlIIIlIlIIIIIlIIII = new Matrix4d();
        llllllllllllllIlIIIlIlIIIIIlIIII.setIdentity();
        llllllllllllllIlIIIlIlIIIIIlIIII.setRotation(new AxisAngle4d(1.0, 0.0, 0.0, (double)(-llllllllllllllIlIIIlIlIIIIIIlIll * 0.017453292f)));
        this.field_177543_t = MathHelper.abs_int(llllllllllllllIlIIIlIlIIIIIIlIll / 90);
        final Matrix4d llllllllllllllIlIIIlIlIIIIIIllll = new Matrix4d();
        llllllllllllllIlIIIlIlIIIIIIllll.setIdentity();
        llllllllllllllIlIIIlIlIIIIIIllll.setRotation(new AxisAngle4d(0.0, 1.0, 0.0, (double)(-llllllllllllllIlIIIlIlIIIIIIlIlI * 0.017453292f)));
        this.field_177542_u = MathHelper.abs_int(llllllllllllllIlIIIlIlIIIIIIlIlI / 90);
        this.field_177544_s.mul(llllllllllllllIlIIIlIlIIIIIIllll, llllllllllllllIlIIIlIlIIIIIlIIII);
    }
    
    public static ModelRotation func_177524_a(final int llllllllllllllIlIIIlIIlllllIIIlI, final int llllllllllllllIlIIIlIIlllllIIIll) {
        return ModelRotation.field_177546_q.get(func_177521_b(MathHelper.func_180184_b(llllllllllllllIlIIIlIIlllllIIIlI, 360), MathHelper.func_180184_b(llllllllllllllIlIIIlIIlllllIIIll, 360)));
    }
    
    public int func_177520_a(final EnumFacing llllllllllllllIlIIIlIIlllllIlIll, final int llllllllllllllIlIIIlIIllllllIIII) {
        int llllllllllllllIlIIIlIIlllllIllll = llllllllllllllIlIIIlIIllllllIIII;
        if (llllllllllllllIlIIIlIIlllllIlIll.getAxis() == EnumFacing.Axis.X) {
            llllllllllllllIlIIIlIIlllllIllll = (llllllllllllllIlIIIlIIllllllIIII + this.field_177543_t) % 4;
        }
        EnumFacing llllllllllllllIlIIIlIIlllllIlllI = llllllllllllllIlIIIlIIlllllIlIll;
        for (int llllllllllllllIlIIIlIIlllllIllIl = 0; llllllllllllllIlIIIlIIlllllIllIl < this.field_177543_t; ++llllllllllllllIlIIIlIIlllllIllIl) {
            llllllllllllllIlIIIlIIlllllIlllI = llllllllllllllIlIIIlIIlllllIlllI.rotateAround(EnumFacing.Axis.X);
        }
        if (llllllllllllllIlIIIlIIlllllIlllI.getAxis() == EnumFacing.Axis.Y) {
            llllllllllllllIlIIIlIIlllllIllll = (llllllllllllllIlIIIlIIlllllIllll + this.field_177542_u) % 4;
        }
        return llllllllllllllIlIIIlIIlllllIllll;
    }
    
    private static int func_177521_b(final int llllllllllllllIlIIIlIlIIIIIllllI, final int llllllllllllllIlIIIlIlIIIIIlllll) {
        return llllllllllllllIlIIIlIlIIIIIllllI * 360 + llllllllllllllIlIIIlIlIIIIIlllll;
    }
    
    public Matrix4d func_177525_a() {
        return this.field_177544_s;
    }
    
    public EnumFacing func_177523_a(final EnumFacing llllllllllllllIlIIIlIIlllllllIll) {
        EnumFacing llllllllllllllIlIIIlIIlllllllllI = llllllllllllllIlIIIlIIlllllllIll;
        for (int llllllllllllllIlIIIlIIllllllllIl = 0; llllllllllllllIlIIIlIIllllllllIl < this.field_177543_t; ++llllllllllllllIlIIIlIIllllllllIl) {
            llllllllllllllIlIIIlIIlllllllllI = llllllllllllllIlIIIlIIlllllllllI.rotateAround(EnumFacing.Axis.X);
        }
        if (llllllllllllllIlIIIlIIlllllllllI.getAxis() != EnumFacing.Axis.Y) {
            for (int llllllllllllllIlIIIlIIllllllllIl = 0; llllllllllllllIlIIIlIIllllllllIl < this.field_177542_u; ++llllllllllllllIlIIIlIIllllllllIl) {
                llllllllllllllIlIIIlIIlllllllllI = llllllllllllllIlIIIlIIlllllllllI.rotateAround(EnumFacing.Axis.Y);
            }
        }
        return llllllllllllllIlIIIlIIlllllllllI;
    }
    
    @Override
    public Matrix4f getMatrix() {
        return (Matrix4f)(Reflector.ForgeHooksClient_getMatrix.exists() ? Reflector.call(Reflector.ForgeHooksClient_getMatrix, this) : new Matrix4f(this.func_177525_a()));
    }
    
    @Override
    public EnumFacing rotate(final EnumFacing llllllllllllllIlIIIlIIllllIlIlII) {
        return this.func_177523_a(llllllllllllllIlIIIlIIllllIlIlII);
    }
    
    static {
        __OBFID = "CL_00002393";
        field_177546_q = Maps.newHashMap();
        for (final ModelRotation llllllllllllllIlIIIlIlIIIIlIIlll : values()) {
            ModelRotation.field_177546_q.put(llllllllllllllIlIIIlIlIIIIlIIlll.field_177545_r, llllllllllllllIlIIIlIlIIIIlIIlll);
        }
    }
}
