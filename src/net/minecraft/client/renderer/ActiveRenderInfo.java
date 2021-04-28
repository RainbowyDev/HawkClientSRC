package net.minecraft.client.renderer;

import java.nio.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.*;
import net.minecraft.util.*;

public class ActiveRenderInfo
{
    private static final /* synthetic */ FloatBuffer field_178810_d;
    private static /* synthetic */ float rotationXY;
    private static /* synthetic */ float rotationYZ;
    private static final /* synthetic */ FloatBuffer field_178812_b;
    private static final /* synthetic */ FloatBuffer field_178813_c;
    private static /* synthetic */ float rotationZ;
    private static /* synthetic */ Vec3 field_178811_e;
    private static final /* synthetic */ IntBuffer field_178814_a;
    private static /* synthetic */ float rotationXZ;
    private static /* synthetic */ float rotationX;
    
    public static float func_178808_b() {
        return ActiveRenderInfo.rotationX;
    }
    
    static {
        __OBFID = "CL_00000626";
        field_178814_a = GLAllocation.createDirectIntBuffer(16);
        field_178812_b = GLAllocation.createDirectFloatBuffer(16);
        field_178813_c = GLAllocation.createDirectFloatBuffer(16);
        field_178810_d = GLAllocation.createDirectFloatBuffer(3);
        ActiveRenderInfo.field_178811_e = new Vec3(0.0, 0.0, 0.0);
    }
    
    public static Vec3 func_178806_a(final Entity llllllllllllllIlIIIlllIIIlIIIIII, final double llllllllllllllIlIIIlllIIIIllllll) {
        final double llllllllllllllIlIIIlllIIIIlllllI = llllllllllllllIlIIIlllIIIlIIIIII.prevPosX + (llllllllllllllIlIIIlllIIIlIIIIII.posX - llllllllllllllIlIIIlllIIIlIIIIII.prevPosX) * llllllllllllllIlIIIlllIIIIllllll;
        final double llllllllllllllIlIIIlllIIIIllllIl = llllllllllllllIlIIIlllIIIlIIIIII.prevPosY + (llllllllllllllIlIIIlllIIIlIIIIII.posY - llllllllllllllIlIIIlllIIIlIIIIII.prevPosY) * llllllllllllllIlIIIlllIIIIllllll;
        final double llllllllllllllIlIIIlllIIIIllllII = llllllllllllllIlIIIlllIIIlIIIIII.prevPosZ + (llllllllllllllIlIIIlllIIIlIIIIII.posZ - llllllllllllllIlIIIlllIIIlIIIIII.prevPosZ) * llllllllllllllIlIIIlllIIIIllllll;
        final double llllllllllllllIlIIIlllIIIIlllIll = llllllllllllllIlIIIlllIIIIlllllI + ActiveRenderInfo.field_178811_e.xCoord;
        final double llllllllllllllIlIIIlllIIIIlllIlI = llllllllllllllIlIIIlllIIIIllllIl + ActiveRenderInfo.field_178811_e.yCoord;
        final double llllllllllllllIlIIIlllIIIIlllIIl = llllllllllllllIlIIIlllIIIIllllII + ActiveRenderInfo.field_178811_e.zCoord;
        return new Vec3(llllllllllllllIlIIIlllIIIIlllIll, llllllllllllllIlIIIlllIIIIlllIlI, llllllllllllllIlIIIlllIIIIlllIIl);
    }
    
    public static float func_178805_e() {
        return ActiveRenderInfo.rotationYZ;
    }
    
    public static Block func_180786_a(final World llllllllllllllIlIIIlllIIIIIllllI, final Entity llllllllllllllIlIIIlllIIIIIlllIl, final float llllllllllllllIlIIIlllIIIIIlllII) {
        final Vec3 llllllllllllllIlIIIlllIIIIlIIlII = func_178806_a(llllllllllllllIlIIIlllIIIIIlllIl, llllllllllllllIlIIIlllIIIIIlllII);
        final BlockPos llllllllllllllIlIIIlllIIIIlIIIll = new BlockPos(llllllllllllllIlIIIlllIIIIlIIlII);
        final IBlockState llllllllllllllIlIIIlllIIIIlIIIlI = llllllllllllllIlIIIlllIIIIIllllI.getBlockState(llllllllllllllIlIIIlllIIIIlIIIll);
        Block llllllllllllllIlIIIlllIIIIlIIIIl = llllllllllllllIlIIIlllIIIIlIIIlI.getBlock();
        if (llllllllllllllIlIIIlllIIIIlIIIIl.getMaterial().isLiquid()) {
            float llllllllllllllIlIIIlllIIIIlIIIII = 0.0f;
            if (llllllllllllllIlIIIlllIIIIlIIIlI.getBlock() instanceof BlockLiquid) {
                llllllllllllllIlIIIlllIIIIlIIIII = BlockLiquid.getLiquidHeightPercent((int)llllllllllllllIlIIIlllIIIIlIIIlI.getValue(BlockLiquid.LEVEL)) - 0.11111111f;
            }
            final float llllllllllllllIlIIIlllIIIIIlllll = llllllllllllllIlIIIlllIIIIlIIIll.getY() + 1 - llllllllllllllIlIIIlllIIIIlIIIII;
            if (llllllllllllllIlIIIlllIIIIlIIlII.yCoord >= llllllllllllllIlIIIlllIIIIIlllll) {
                llllllllllllllIlIIIlllIIIIlIIIIl = llllllllllllllIlIIIlllIIIIIllllI.getBlockState(llllllllllllllIlIIIlllIIIIlIIIll.offsetUp()).getBlock();
            }
        }
        return llllllllllllllIlIIIlllIIIIlIIIIl;
    }
    
    public static float func_178803_d() {
        return ActiveRenderInfo.rotationZ;
    }
    
    public static float func_178809_c() {
        return ActiveRenderInfo.rotationXZ;
    }
    
    public static Vec3 func_178804_a() {
        return ActiveRenderInfo.field_178811_e;
    }
    
    public static float func_178807_f() {
        return ActiveRenderInfo.rotationXY;
    }
    
    public static void updateRenderInfo(final EntityPlayer llllllllllllllIlIIIlllIIIlIlIllI, final boolean llllllllllllllIlIIIlllIIIlIlIlIl) {
        GlStateManager.getFloat(2982, ActiveRenderInfo.field_178812_b);
        GlStateManager.getFloat(2983, ActiveRenderInfo.field_178813_c);
        GL11.glGetInteger(2978, ActiveRenderInfo.field_178814_a);
        final float llllllllllllllIlIIIlllIIIlIlIlII = (float)((ActiveRenderInfo.field_178814_a.get(0) + ActiveRenderInfo.field_178814_a.get(2)) / 2);
        final float llllllllllllllIlIIIlllIIIlIlIIll = (float)((ActiveRenderInfo.field_178814_a.get(1) + ActiveRenderInfo.field_178814_a.get(3)) / 2);
        GLU.gluUnProject(llllllllllllllIlIIIlllIIIlIlIlII, llllllllllllllIlIIIlllIIIlIlIIll, 0.0f, ActiveRenderInfo.field_178812_b, ActiveRenderInfo.field_178813_c, ActiveRenderInfo.field_178814_a, ActiveRenderInfo.field_178810_d);
        ActiveRenderInfo.field_178811_e = new Vec3(ActiveRenderInfo.field_178810_d.get(0), ActiveRenderInfo.field_178810_d.get(1), ActiveRenderInfo.field_178810_d.get(2));
        final int llllllllllllllIlIIIlllIIIlIlIIlI = llllllllllllllIlIIIlllIIIlIlIlIl ? 1 : 0;
        final float llllllllllllllIlIIIlllIIIlIlIIIl = llllllllllllllIlIIIlllIIIlIlIllI.rotationPitch;
        final float llllllllllllllIlIIIlllIIIlIlIIII = llllllllllllllIlIIIlllIIIlIlIllI.rotationYaw;
        ActiveRenderInfo.rotationX = MathHelper.cos(llllllllllllllIlIIIlllIIIlIlIIII * 3.1415927f / 180.0f) * (1 - llllllllllllllIlIIIlllIIIlIlIIlI * 2);
        ActiveRenderInfo.rotationZ = MathHelper.sin(llllllllllllllIlIIIlllIIIlIlIIII * 3.1415927f / 180.0f) * (1 - llllllllllllllIlIIIlllIIIlIlIIlI * 2);
        ActiveRenderInfo.rotationYZ = -ActiveRenderInfo.rotationZ * MathHelper.sin(llllllllllllllIlIIIlllIIIlIlIIIl * 3.1415927f / 180.0f) * (1 - llllllllllllllIlIIIlllIIIlIlIIlI * 2);
        ActiveRenderInfo.rotationXY = ActiveRenderInfo.rotationX * MathHelper.sin(llllllllllllllIlIIIlllIIIlIlIIIl * 3.1415927f / 180.0f) * (1 - llllllllllllllIlIIIlllIIIlIlIIlI * 2);
        ActiveRenderInfo.rotationXZ = MathHelper.cos(llllllllllllllIlIIIlllIIIlIlIIIl * 3.1415927f / 180.0f);
    }
}
