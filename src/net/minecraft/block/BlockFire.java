package net.minecraft.block;

import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public class BlockFire extends Block
{
    public static final /* synthetic */ PropertyInteger field_176542_R;
    public static final /* synthetic */ PropertyBool field_176541_P;
    private final /* synthetic */ Map field_149849_a;
    public static final /* synthetic */ PropertyBool field_176540_b;
    public static final /* synthetic */ PropertyBool field_176546_O;
    public static final /* synthetic */ PropertyBool field_176544_M;
    public static final /* synthetic */ PropertyBool field_176545_N;
    private final /* synthetic */ Map field_149848_b;
    public static final /* synthetic */ PropertyInteger field_176543_a;
    public static final /* synthetic */ PropertyBool field_176539_Q;
    
    private void func_176536_a(final World llllllllllllllIIIllIIIIIlIlIlIll, final BlockPos llllllllllllllIIIllIIIIIlIlIlIlI, final int llllllllllllllIIIllIIIIIlIllIIlI, final Random llllllllllllllIIIllIIIIIlIlIlIII, final int llllllllllllllIIIllIIIIIlIlIIlll) {
        final int llllllllllllllIIIllIIIIIlIlIllll = this.func_176532_c(llllllllllllllIIIllIIIIIlIlIlIll.getBlockState(llllllllllllllIIIllIIIIIlIlIlIlI).getBlock());
        if (llllllllllllllIIIllIIIIIlIlIlIII.nextInt(llllllllllllllIIIllIIIIIlIllIIlI) < llllllllllllllIIIllIIIIIlIlIllll) {
            final IBlockState llllllllllllllIIIllIIIIIlIlIlllI = llllllllllllllIIIllIIIIIlIlIlIll.getBlockState(llllllllllllllIIIllIIIIIlIlIlIlI);
            if (llllllllllllllIIIllIIIIIlIlIlIII.nextInt(llllllllllllllIIIllIIIIIlIlIIlll + 10) < 5 && !llllllllllllllIIIllIIIIIlIlIlIll.func_175727_C(llllllllllllllIIIllIIIIIlIlIlIlI)) {
                int llllllllllllllIIIllIIIIIlIlIllIl = llllllllllllllIIIllIIIIIlIlIIlll + llllllllllllllIIIllIIIIIlIlIlIII.nextInt(5) / 4;
                if (llllllllllllllIIIllIIIIIlIlIllIl > 15) {
                    llllllllllllllIIIllIIIIIlIlIllIl = 15;
                }
                llllllllllllllIIIllIIIIIlIlIlIll.setBlockState(llllllllllllllIIIllIIIIIlIlIlIlI, this.getDefaultState().withProperty(BlockFire.field_176543_a, llllllllllllllIIIllIIIIIlIlIllIl), 3);
            }
            else {
                llllllllllllllIIIllIIIIIlIlIlIll.setBlockToAir(llllllllllllllIIIllIIIIIlIlIlIlI);
            }
            if (llllllllllllllIIIllIIIIIlIlIlllI.getBlock() == Blocks.tnt) {
                Blocks.tnt.onBlockDestroyedByPlayer(llllllllllllllIIIllIIIIIlIlIlIll, llllllllllllllIIIllIIIIIlIlIlIlI, llllllllllllllIIIllIIIIIlIlIlllI.withProperty(BlockTNT.field_176246_a, true));
            }
        }
    }
    
    protected boolean func_176537_d(final World llllllllllllllIIIllIIIIIllIlIIll, final BlockPos llllllllllllllIIIllIIIIIllIlIIlI) {
        return llllllllllllllIIIllIIIIIllIlIIll.func_175727_C(llllllllllllllIIIllIIIIIllIlIIlI) || llllllllllllllIIIllIIIIIllIlIIll.func_175727_C(llllllllllllllIIIllIIIIIllIlIIlI.offsetWest()) || llllllllllllllIIIllIIIIIllIlIIll.func_175727_C(llllllllllllllIIIllIIIIIllIlIIlI.offsetEast()) || llllllllllllllIIIllIIIIIllIlIIll.func_175727_C(llllllllllllllIIIllIIIIIllIlIIlI.offsetNorth()) || llllllllllllllIIIllIIIIIllIlIIll.func_175727_C(llllllllllllllIIIllIIIIIllIlIIlI.offsetSouth());
    }
    
    private boolean func_176533_e(final World llllllllllllllIIIllIIIIIlIIllIll, final BlockPos llllllllllllllIIIllIIIIIlIIlIIll) {
        for (final EnumFacing llllllllllllllIIIllIIIIIlIIlIllI : EnumFacing.values()) {
            if (this.func_176535_e(llllllllllllllIIIllIIIIIlIIllIll, llllllllllllllIIIllIIIIIlIIlIIll.offset(llllllllllllllIIIllIIIIIlIIlIllI))) {
                return true;
            }
        }
        return false;
    }
    
    private int func_176534_d(final Block llllllllllllllIIIllIIIIIllIIIIll) {
        final Integer llllllllllllllIIIllIIIIIllIIIIlI = this.field_149849_a.get(llllllllllllllIIIllIIIIIllIIIIll);
        return (llllllllllllllIIIllIIIIIllIIIIlI == null) ? 0 : llllllllllllllIIIllIIIIIllIIIIlI;
    }
    
    static {
        __OBFID = "CL_00000245";
        field_176543_a = PropertyInteger.create("age", 0, 15);
        field_176540_b = PropertyBool.create("flip");
        field_176544_M = PropertyBool.create("alt");
        field_176545_N = PropertyBool.create("north");
        field_176546_O = PropertyBool.create("east");
        field_176541_P = PropertyBool.create("south");
        field_176539_Q = PropertyBool.create("west");
        field_176542_R = PropertyInteger.create("upper", 0, 2);
    }
    
    public void func_180686_a(final Block llllllllllllllIIIllIIIIlIIIlllll, final int llllllllllllllIIIllIIIIlIIIllllI, final int llllllllllllllIIIllIIIIlIIIlllIl) {
        this.field_149849_a.put(llllllllllllllIIIllIIIIlIIIlllll, llllllllllllllIIIllIIIIlIIIllllI);
        this.field_149848_b.put(llllllllllllllIIIllIIIIlIIIlllll, llllllllllllllIIIllIIIIlIIIlllIl);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World llllllllllllllIIIllIIIIlIIIlIlll, final BlockPos llllllllllllllIIIllIIIIlIIIlIllI, final IBlockState llllllllllllllIIIllIIIIlIIIlIlIl) {
        return null;
    }
    
    @Override
    public void randomDisplayTick(final World llllllllllllllIIIllIIIIIIIlIlIlI, final BlockPos llllllllllllllIIIllIIIIIIlIIIlIl, final IBlockState llllllllllllllIIIllIIIIIIlIIIlII, final Random llllllllllllllIIIllIIIIIIlIIIIll) {
        if (llllllllllllllIIIllIIIIIIlIIIIll.nextInt(24) == 0) {
            llllllllllllllIIIllIIIIIIIlIlIlI.playSound(llllllllllllllIIIllIIIIIIlIIIlIl.getX() + 0.5f, llllllllllllllIIIllIIIIIIlIIIlIl.getY() + 0.5f, llllllllllllllIIIllIIIIIIlIIIlIl.getZ() + 0.5f, "fire.fire", 1.0f + llllllllllllllIIIllIIIIIIlIIIIll.nextFloat(), llllllllllllllIIIllIIIIIIlIIIIll.nextFloat() * 0.7f + 0.3f, false);
        }
        if (!World.doesBlockHaveSolidTopSurface(llllllllllllllIIIllIIIIIIIlIlIlI, llllllllllllllIIIllIIIIIIlIIIlIl.offsetDown()) && !Blocks.fire.func_176535_e(llllllllllllllIIIllIIIIIIIlIlIlI, llllllllllllllIIIllIIIIIIlIIIlIl.offsetDown())) {
            if (Blocks.fire.func_176535_e(llllllllllllllIIIllIIIIIIIlIlIlI, llllllllllllllIIIllIIIIIIlIIIlIl.offsetWest())) {
                for (int llllllllllllllIIIllIIIIIIlIIIIlI = 0; llllllllllllllIIIllIIIIIIlIIIIlI < 2; ++llllllllllllllIIIllIIIIIIlIIIIlI) {
                    final double llllllllllllllIIIllIIIIIIIllllII = llllllllllllllIIIllIIIIIIlIIIlIl.getX() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble() * 0.10000000149011612;
                    final double llllllllllllllIIIllIIIIIIIllIllI = llllllllllllllIIIllIIIIIIlIIIlIl.getY() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                    final double llllllllllllllIIIllIIIIIIIllIIII = llllllllllllllIIIllIIIIIIlIIIlIl.getZ() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                    llllllllllllllIIIllIIIIIIIlIlIlI.spawnParticle(EnumParticleTypes.SMOKE_LARGE, llllllllllllllIIIllIIIIIIIllllII, llllllllllllllIIIllIIIIIIIllIllI, llllllllllllllIIIllIIIIIIIllIIII, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.fire.func_176535_e(llllllllllllllIIIllIIIIIIIlIlIlI, llllllllllllllIIIllIIIIIIlIIIlIl.offsetEast())) {
                for (int llllllllllllllIIIllIIIIIIlIIIIIl = 0; llllllllllllllIIIllIIIIIIlIIIIIl < 2; ++llllllllllllllIIIllIIIIIIlIIIIIl) {
                    final double llllllllllllllIIIllIIIIIIIlllIll = llllllllllllllIIIllIIIIIIlIIIlIl.getX() + 1 - llllllllllllllIIIllIIIIIIlIIIIll.nextDouble() * 0.10000000149011612;
                    final double llllllllllllllIIIllIIIIIIIllIlIl = llllllllllllllIIIllIIIIIIlIIIlIl.getY() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                    final double llllllllllllllIIIllIIIIIIIlIllll = llllllllllllllIIIllIIIIIIlIIIlIl.getZ() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                    llllllllllllllIIIllIIIIIIIlIlIlI.spawnParticle(EnumParticleTypes.SMOKE_LARGE, llllllllllllllIIIllIIIIIIIlllIll, llllllllllllllIIIllIIIIIIIllIlIl, llllllllllllllIIIllIIIIIIIlIllll, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.fire.func_176535_e(llllllllllllllIIIllIIIIIIIlIlIlI, llllllllllllllIIIllIIIIIIlIIIlIl.offsetNorth())) {
                for (int llllllllllllllIIIllIIIIIIlIIIIII = 0; llllllllllllllIIIllIIIIIIlIIIIII < 2; ++llllllllllllllIIIllIIIIIIlIIIIII) {
                    final double llllllllllllllIIIllIIIIIIIlllIlI = llllllllllllllIIIllIIIIIIlIIIlIl.getX() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                    final double llllllllllllllIIIllIIIIIIIllIlII = llllllllllllllIIIllIIIIIIlIIIlIl.getY() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                    final double llllllllllllllIIIllIIIIIIIlIlllI = llllllllllllllIIIllIIIIIIlIIIlIl.getZ() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble() * 0.10000000149011612;
                    llllllllllllllIIIllIIIIIIIlIlIlI.spawnParticle(EnumParticleTypes.SMOKE_LARGE, llllllllllllllIIIllIIIIIIIlllIlI, llllllllllllllIIIllIIIIIIIllIlII, llllllllllllllIIIllIIIIIIIlIlllI, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.fire.func_176535_e(llllllllllllllIIIllIIIIIIIlIlIlI, llllllllllllllIIIllIIIIIIlIIIlIl.offsetSouth())) {
                for (int llllllllllllllIIIllIIIIIIIllllll = 0; llllllllllllllIIIllIIIIIIIllllll < 2; ++llllllllllllllIIIllIIIIIIIllllll) {
                    final double llllllllllllllIIIllIIIIIIIlllIIl = llllllllllllllIIIllIIIIIIlIIIlIl.getX() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                    final double llllllllllllllIIIllIIIIIIIllIIll = llllllllllllllIIIllIIIIIIlIIIlIl.getY() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                    final double llllllllllllllIIIllIIIIIIIlIllIl = llllllllllllllIIIllIIIIIIlIIIlIl.getZ() + 1 - llllllllllllllIIIllIIIIIIlIIIIll.nextDouble() * 0.10000000149011612;
                    llllllllllllllIIIllIIIIIIIlIlIlI.spawnParticle(EnumParticleTypes.SMOKE_LARGE, llllllllllllllIIIllIIIIIIIlllIIl, llllllllllllllIIIllIIIIIIIllIIll, llllllllllllllIIIllIIIIIIIlIllIl, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.fire.func_176535_e(llllllllllllllIIIllIIIIIIIlIlIlI, llllllllllllllIIIllIIIIIIlIIIlIl.offsetUp())) {
                for (int llllllllllllllIIIllIIIIIIIlllllI = 0; llllllllllllllIIIllIIIIIIIlllllI < 2; ++llllllllllllllIIIllIIIIIIIlllllI) {
                    final double llllllllllllllIIIllIIIIIIIlllIII = llllllllllllllIIIllIIIIIIlIIIlIl.getX() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                    final double llllllllllllllIIIllIIIIIIIllIIlI = llllllllllllllIIIllIIIIIIlIIIlIl.getY() + 1 - llllllllllllllIIIllIIIIIIlIIIIll.nextDouble() * 0.10000000149011612;
                    final double llllllllllllllIIIllIIIIIIIlIllII = llllllllllllllIIIllIIIIIIlIIIlIl.getZ() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                    llllllllllllllIIIllIIIIIIIlIlIlI.spawnParticle(EnumParticleTypes.SMOKE_LARGE, llllllllllllllIIIllIIIIIIIlllIII, llllllllllllllIIIllIIIIIIIllIIlI, llllllllllllllIIIllIIIIIIIlIllII, 0.0, 0.0, 0.0, new int[0]);
                }
            }
        }
        else {
            for (int llllllllllllllIIIllIIIIIIIllllIl = 0; llllllllllllllIIIllIIIIIIIllllIl < 3; ++llllllllllllllIIIllIIIIIIIllllIl) {
                final double llllllllllllllIIIllIIIIIIIllIlll = llllllllllllllIIIllIIIIIIlIIIlIl.getX() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                final double llllllllllllllIIIllIIIIIIIllIIIl = llllllllllllllIIIllIIIIIIlIIIlIl.getY() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble() * 0.5 + 0.5;
                final double llllllllllllllIIIllIIIIIIIlIlIll = llllllllllllllIIIllIIIIIIlIIIlIl.getZ() + llllllllllllllIIIllIIIIIIlIIIIll.nextDouble();
                llllllllllllllIIIllIIIIIIIlIlIlI.spawnParticle(EnumParticleTypes.SMOKE_LARGE, llllllllllllllIIIllIIIIIIIllIlll, llllllllllllllIIIllIIIIIIIllIIIl, llllllllllllllIIIllIIIIIIIlIlIll, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIIllIIIIIlllIlIIl, final BlockPos llllllllllllllIIIllIIIIIlllIlIII, IBlockState llllllllllllllIIIllIIIIIlllIIlll, final Random llllllllllllllIIIllIIIIIlllIIllI) {
        if (llllllllllllllIIIllIIIIIlllIlIIl.getGameRules().getGameRuleBooleanValue("doFireTick")) {
            if (!this.canPlaceBlockAt(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII)) {
                llllllllllllllIIIllIIIIIlllIlIIl.setBlockToAir(llllllllllllllIIIllIIIIIlllIlIII);
            }
            final Block llllllllllllllIIIllIIIIIllllIlll = llllllllllllllIIIllIIIIIlllIlIIl.getBlockState(llllllllllllllIIIllIIIIIlllIlIII.offsetDown()).getBlock();
            boolean llllllllllllllIIIllIIIIIllllIllI = llllllllllllllIIIllIIIIIllllIlll == Blocks.netherrack;
            if (llllllllllllllIIIllIIIIIlllIlIIl.provider instanceof WorldProviderEnd && llllllllllllllIIIllIIIIIllllIlll == Blocks.bedrock) {
                llllllllllllllIIIllIIIIIllllIllI = true;
            }
            if (!llllllllllllllIIIllIIIIIllllIllI && llllllllllllllIIIllIIIIIlllIlIIl.isRaining() && this.func_176537_d(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII)) {
                llllllllllllllIIIllIIIIIlllIlIIl.setBlockToAir(llllllllllllllIIIllIIIIIlllIlIII);
            }
            else {
                final int llllllllllllllIIIllIIIIIllllIlIl = (int)((IBlockState)llllllllllllllIIIllIIIIIlllIIlll).getValue(BlockFire.field_176543_a);
                if (llllllllllllllIIIllIIIIIllllIlIl < 15) {
                    llllllllllllllIIIllIIIIIlllIIlll = ((IBlockState)llllllllllllllIIIllIIIIIlllIIlll).withProperty(BlockFire.field_176543_a, llllllllllllllIIIllIIIIIllllIlIl + llllllllllllllIIIllIIIIIlllIIllI.nextInt(3) / 2);
                    llllllllllllllIIIllIIIIIlllIlIIl.setBlockState(llllllllllllllIIIllIIIIIlllIlIII, (IBlockState)llllllllllllllIIIllIIIIIlllIIlll, 4);
                }
                llllllllllllllIIIllIIIIIlllIlIIl.scheduleUpdate(llllllllllllllIIIllIIIIIlllIlIII, this, this.tickRate(llllllllllllllIIIllIIIIIlllIlIIl) + llllllllllllllIIIllIIIIIlllIIllI.nextInt(10));
                if (!llllllllllllllIIIllIIIIIllllIllI) {
                    if (!this.func_176533_e(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII)) {
                        if (!World.doesBlockHaveSolidTopSurface(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII.offsetDown()) || llllllllllllllIIIllIIIIIllllIlIl > 3) {
                            llllllllllllllIIIllIIIIIlllIlIIl.setBlockToAir(llllllllllllllIIIllIIIIIlllIlIII);
                        }
                        return;
                    }
                    if (!this.func_176535_e(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII.offsetDown()) && llllllllllllllIIIllIIIIIllllIlIl == 15 && llllllllllllllIIIllIIIIIlllIIllI.nextInt(4) == 0) {
                        llllllllllllllIIIllIIIIIlllIlIIl.setBlockToAir(llllllllllllllIIIllIIIIIlllIlIII);
                        return;
                    }
                }
                final boolean llllllllllllllIIIllIIIIIllllIlII = llllllllllllllIIIllIIIIIlllIlIIl.func_180502_D(llllllllllllllIIIllIIIIIlllIlIII);
                byte llllllllllllllIIIllIIIIIllllIIll = 0;
                if (llllllllllllllIIIllIIIIIllllIlII) {
                    llllllllllllllIIIllIIIIIllllIIll = -50;
                }
                this.func_176536_a(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII.offsetEast(), 300 + llllllllllllllIIIllIIIIIllllIIll, llllllllllllllIIIllIIIIIlllIIllI, llllllllllllllIIIllIIIIIllllIlIl);
                this.func_176536_a(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII.offsetWest(), 300 + llllllllllllllIIIllIIIIIllllIIll, llllllllllllllIIIllIIIIIlllIIllI, llllllllllllllIIIllIIIIIllllIlIl);
                this.func_176536_a(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII.offsetDown(), 250 + llllllllllllllIIIllIIIIIllllIIll, llllllllllllllIIIllIIIIIlllIIllI, llllllllllllllIIIllIIIIIllllIlIl);
                this.func_176536_a(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII.offsetUp(), 250 + llllllllllllllIIIllIIIIIllllIIll, llllllllllllllIIIllIIIIIlllIIllI, llllllllllllllIIIllIIIIIllllIlIl);
                this.func_176536_a(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII.offsetNorth(), 300 + llllllllllllllIIIllIIIIIllllIIll, llllllllllllllIIIllIIIIIlllIIllI, llllllllllllllIIIllIIIIIllllIlIl);
                this.func_176536_a(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlIII.offsetSouth(), 300 + llllllllllllllIIIllIIIIIllllIIll, llllllllllllllIIIllIIIIIlllIIllI, llllllllllllllIIIllIIIIIllllIlIl);
                for (int llllllllllllllIIIllIIIIIllllIIlI = -1; llllllllllllllIIIllIIIIIllllIIlI <= 1; ++llllllllllllllIIIllIIIIIllllIIlI) {
                    for (int llllllllllllllIIIllIIIIIllllIIIl = -1; llllllllllllllIIIllIIIIIllllIIIl <= 1; ++llllllllllllllIIIllIIIIIllllIIIl) {
                        for (int llllllllllllllIIIllIIIIIllllIIII = -1; llllllllllllllIIIllIIIIIllllIIII <= 4; ++llllllllllllllIIIllIIIIIllllIIII) {
                            if (llllllllllllllIIIllIIIIIllllIIlI != 0 || llllllllllllllIIIllIIIIIllllIIII != 0 || llllllllllllllIIIllIIIIIllllIIIl != 0) {
                                int llllllllllllllIIIllIIIIIlllIllll = 100;
                                if (llllllllllllllIIIllIIIIIllllIIII > 1) {
                                    llllllllllllllIIIllIIIIIlllIllll += (llllllllllllllIIIllIIIIIllllIIII - 1) * 100;
                                }
                                final BlockPos llllllllllllllIIIllIIIIIlllIlllI = llllllllllllllIIIllIIIIIlllIlIII.add(llllllllllllllIIIllIIIIIllllIIlI, llllllllllllllIIIllIIIIIllllIIII, llllllllllllllIIIllIIIIIllllIIIl);
                                final int llllllllllllllIIIllIIIIIlllIllIl = this.func_176538_m(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlllI);
                                if (llllllllllllllIIIllIIIIIlllIllIl > 0) {
                                    int llllllllllllllIIIllIIIIIlllIllII = (llllllllllllllIIIllIIIIIlllIllIl + 40 + llllllllllllllIIIllIIIIIlllIlIIl.getDifficulty().getDifficultyId() * 7) / (llllllllllllllIIIllIIIIIllllIlIl + 30);
                                    if (llllllllllllllIIIllIIIIIllllIlII) {
                                        llllllllllllllIIIllIIIIIlllIllII /= 2;
                                    }
                                    if (llllllllllllllIIIllIIIIIlllIllII > 0 && llllllllllllllIIIllIIIIIlllIIllI.nextInt(llllllllllllllIIIllIIIIIlllIllll) <= llllllllllllllIIIllIIIIIlllIllII && (!llllllllllllllIIIllIIIIIlllIlIIl.isRaining() || !this.func_176537_d(llllllllllllllIIIllIIIIIlllIlIIl, llllllllllllllIIIllIIIIIlllIlllI))) {
                                        int llllllllllllllIIIllIIIIIlllIlIll = llllllllllllllIIIllIIIIIllllIlIl + llllllllllllllIIIllIIIIIlllIIllI.nextInt(5) / 4;
                                        if (llllllllllllllIIIllIIIIIlllIlIll > 15) {
                                            llllllllllllllIIIllIIIIIlllIlIll = 15;
                                        }
                                        llllllllllllllIIIllIIIIIlllIlIIl.setBlockState(llllllllllllllIIIllIIIIIlllIlllI, ((IBlockState)llllllllllllllIIIllIIIIIlllIIlll).withProperty((IProperty)BlockFire.field_176543_a, (Comparable)llllllllllllllIIIllIIIIIlllIlIll), 3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public boolean requiresUpdates() {
        return false;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockFire.field_176543_a, BlockFire.field_176545_N, BlockFire.field_176546_O, BlockFire.field_176541_P, BlockFire.field_176539_Q, BlockFire.field_176542_R, BlockFire.field_176540_b, BlockFire.field_176544_M });
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIIIllIIIIIIllIIlIl, final BlockPos llllllllllllllIIIllIIIIIIllIIlII) {
        return World.doesBlockHaveSolidTopSurface(llllllllllllllIIIllIIIIIIllIIlIl, llllllllllllllIIIllIIIIIIllIIlII.offsetDown()) || this.func_176533_e(llllllllllllllIIIllIIIIIIllIIlIl, llllllllllllllIIIllIIIIIIllIIlII);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIllIIIIIIIIllIll) {
        return this.getDefaultState().withProperty(BlockFire.field_176543_a, llllllllllllllIIIllIIIIIIIIllIll);
    }
    
    protected BlockFire() {
        super(Material.fire);
        this.field_149849_a = Maps.newIdentityHashMap();
        this.field_149848_b = Maps.newIdentityHashMap();
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockFire.field_176543_a, 0).withProperty(BlockFire.field_176540_b, false).withProperty(BlockFire.field_176544_M, false).withProperty(BlockFire.field_176545_N, false).withProperty(BlockFire.field_176546_O, false).withProperty(BlockFire.field_176541_P, false).withProperty(BlockFire.field_176539_Q, false).withProperty(BlockFire.field_176542_R, 0));
        this.setTickRandomly(true);
    }
    
    private int func_176538_m(final World llllllllllllllIIIllIIIIIlIIIIlIl, final BlockPos llllllllllllllIIIllIIIIIlIIIIlII) {
        if (!llllllllllllllIIIllIIIIIlIIIIlIl.isAirBlock(llllllllllllllIIIllIIIIIlIIIIlII)) {
            return 0;
        }
        int llllllllllllllIIIllIIIIIlIIIIIll = 0;
        for (final EnumFacing llllllllllllllIIIllIIIIIIlllllll : EnumFacing.values()) {
            llllllllllllllIIIllIIIIIlIIIIIll = Math.max(this.func_176534_d(llllllllllllllIIIllIIIIIlIIIIlIl.getBlockState(llllllllllllllIIIllIIIIIlIIIIlII.offset(llllllllllllllIIIllIIIIIIlllllll)).getBlock()), llllllllllllllIIIllIIIIIlIIIIIll);
        }
        return llllllllllllllIIIllIIIIIlIIIIIll;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllllIIIllIIIIlIIllIIII, final IBlockAccess llllllllllllllIIIllIIIIlIIlIllll, final BlockPos llllllllllllllIIIllIIIIlIIlllIII) {
        final int llllllllllllllIIIllIIIIlIIllIlll = llllllllllllllIIIllIIIIlIIlllIII.getX();
        final int llllllllllllllIIIllIIIIlIIllIllI = llllllllllllllIIIllIIIIlIIlllIII.getY();
        final int llllllllllllllIIIllIIIIlIIllIlIl = llllllllllllllIIIllIIIIlIIlllIII.getZ();
        if (!World.doesBlockHaveSolidTopSurface(llllllllllllllIIIllIIIIlIIlIllll, llllllllllllllIIIllIIIIlIIlllIII.offsetDown()) && !Blocks.fire.func_176535_e(llllllllllllllIIIllIIIIlIIlIllll, llllllllllllllIIIllIIIIlIIlllIII.offsetDown())) {
            final boolean llllllllllllllIIIllIIIIlIIllIlII = (llllllllllllllIIIllIIIIlIIllIlll + llllllllllllllIIIllIIIIlIIllIllI + llllllllllllllIIIllIIIIlIIllIlIl & 0x1) == 0x1;
            final boolean llllllllllllllIIIllIIIIlIIllIIll = (llllllllllllllIIIllIIIIlIIllIlll / 2 + llllllllllllllIIIllIIIIlIIllIllI / 2 + llllllllllllllIIIllIIIIlIIllIlIl / 2 & 0x1) == 0x1;
            int llllllllllllllIIIllIIIIlIIllIIlI = 0;
            if (this.func_176535_e(llllllllllllllIIIllIIIIlIIlIllll, llllllllllllllIIIllIIIIlIIlllIII.offsetUp())) {
                llllllllllllllIIIllIIIIlIIllIIlI = (llllllllllllllIIIllIIIIlIIllIlII ? 1 : 2);
            }
            return llllllllllllllIIIllIIIIlIIllIIII.withProperty(BlockFire.field_176545_N, this.func_176535_e(llllllllllllllIIIllIIIIlIIlIllll, llllllllllllllIIIllIIIIlIIlllIII.offsetNorth())).withProperty(BlockFire.field_176546_O, this.func_176535_e(llllllllllllllIIIllIIIIlIIlIllll, llllllllllllllIIIllIIIIlIIlllIII.offsetEast())).withProperty(BlockFire.field_176541_P, this.func_176535_e(llllllllllllllIIIllIIIIlIIlIllll, llllllllllllllIIIllIIIIlIIlllIII.offsetSouth())).withProperty(BlockFire.field_176539_Q, this.func_176535_e(llllllllllllllIIIllIIIIlIIlIllll, llllllllllllllIIIllIIIIlIIlllIII.offsetWest())).withProperty(BlockFire.field_176542_R, llllllllllllllIIIllIIIIlIIllIIlI).withProperty(BlockFire.field_176540_b, llllllllllllllIIIllIIIIlIIllIIll).withProperty(BlockFire.field_176544_M, llllllllllllllIIIllIIIIlIIllIlII);
        }
        return this.getDefaultState();
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIIIllIIIIIIlIlllll, final BlockPos llllllllllllllIIIllIIIIIIlIllllI, final IBlockState llllllllllllllIIIllIIIIIIlIlllIl, final Block llllllllllllllIIIllIIIIIIlIlllII) {
        if (!World.doesBlockHaveSolidTopSurface(llllllllllllllIIIllIIIIIIlIlllll, llllllllllllllIIIllIIIIIIlIllllI.offsetDown()) && !this.func_176533_e(llllllllllllllIIIllIIIIIIlIlllll, llllllllllllllIIIllIIIIIIlIllllI)) {
            llllllllllllllIIIllIIIIIIlIlllll.setBlockToAir(llllllllllllllIIIllIIIIIIlIllllI);
        }
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIIIllIIIIIIIlIIIlI) {
        return MapColor.tntColor;
    }
    
    @Override
    public boolean isCollidable() {
        return false;
    }
    
    public boolean func_176535_e(final IBlockAccess llllllllllllllIIIllIIIIIIlllIIIl, final BlockPos llllllllllllllIIIllIIIIIIllIllIl) {
        return this.func_176534_d(llllllllllllllIIIllIIIIIIlllIIIl.getBlockState(llllllllllllllIIIllIIIIIIllIllIl).getBlock()) > 0;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIIIllIIIIlIIIlIIIl) {
        return 0;
    }
    
    @Override
    public int tickRate(final World llllllllllllllIIIllIIIIlIIIIllll) {
        return 30;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    private int func_176532_c(final Block llllllllllllllIIIllIIIIIllIIllII) {
        final Integer llllllllllllllIIIllIIIIIllIIlIll = this.field_149848_b.get(llllllllllllllIIIllIIIIIllIIllII);
        return (llllllllllllllIIIllIIIIIllIIlIll == null) ? 0 : llllllllllllllIIIllIIIIIllIIlIll;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIIIllIIIIIIlIlIlII, final BlockPos llllllllllllllIIIllIIIIIIlIIllll, final IBlockState llllllllllllllIIIllIIIIIIlIlIIlI) {
        if (llllllllllllllIIIllIIIIIIlIlIlII.provider.getDimensionId() > 0 || !Blocks.portal.func_176548_d(llllllllllllllIIIllIIIIIIlIlIlII, llllllllllllllIIIllIIIIIIlIIllll)) {
            if (!World.doesBlockHaveSolidTopSurface(llllllllllllllIIIllIIIIIIlIlIlII, llllllllllllllIIIllIIIIIIlIIllll.offsetDown()) && !this.func_176533_e(llllllllllllllIIIllIIIIIIlIlIlII, llllllllllllllIIIllIIIIIIlIIllll)) {
                llllllllllllllIIIllIIIIIIlIlIlII.setBlockToAir(llllllllllllllIIIllIIIIIIlIIllll);
            }
            else {
                llllllllllllllIIIllIIIIIIlIlIlII.scheduleUpdate(llllllllllllllIIIllIIIIIIlIIllll, this, this.tickRate(llllllllllllllIIIllIIIIIIlIlIlII) + llllllllllllllIIIllIIIIIIlIlIlII.rand.nextInt(10));
            }
        }
    }
    
    public static void func_149843_e() {
        Blocks.fire.func_180686_a(Blocks.planks, 5, 20);
        Blocks.fire.func_180686_a(Blocks.double_wooden_slab, 5, 20);
        Blocks.fire.func_180686_a(Blocks.wooden_slab, 5, 20);
        Blocks.fire.func_180686_a(Blocks.oak_fence_gate, 5, 20);
        Blocks.fire.func_180686_a(Blocks.spruce_fence_gate, 5, 20);
        Blocks.fire.func_180686_a(Blocks.birch_fence_gate, 5, 20);
        Blocks.fire.func_180686_a(Blocks.jungle_fence_gate, 5, 20);
        Blocks.fire.func_180686_a(Blocks.dark_oak_fence_gate, 5, 20);
        Blocks.fire.func_180686_a(Blocks.acacia_fence_gate, 5, 20);
        Blocks.fire.func_180686_a(Blocks.oak_fence, 5, 20);
        Blocks.fire.func_180686_a(Blocks.spruce_fence, 5, 20);
        Blocks.fire.func_180686_a(Blocks.birch_fence, 5, 20);
        Blocks.fire.func_180686_a(Blocks.jungle_fence, 5, 20);
        Blocks.fire.func_180686_a(Blocks.dark_oak_fence, 5, 20);
        Blocks.fire.func_180686_a(Blocks.acacia_fence, 5, 20);
        Blocks.fire.func_180686_a(Blocks.oak_stairs, 5, 20);
        Blocks.fire.func_180686_a(Blocks.birch_stairs, 5, 20);
        Blocks.fire.func_180686_a(Blocks.spruce_stairs, 5, 20);
        Blocks.fire.func_180686_a(Blocks.jungle_stairs, 5, 20);
        Blocks.fire.func_180686_a(Blocks.log, 5, 5);
        Blocks.fire.func_180686_a(Blocks.log2, 5, 5);
        Blocks.fire.func_180686_a(Blocks.leaves, 30, 60);
        Blocks.fire.func_180686_a(Blocks.leaves2, 30, 60);
        Blocks.fire.func_180686_a(Blocks.bookshelf, 30, 20);
        Blocks.fire.func_180686_a(Blocks.tnt, 15, 100);
        Blocks.fire.func_180686_a(Blocks.tallgrass, 60, 100);
        Blocks.fire.func_180686_a(Blocks.double_plant, 60, 100);
        Blocks.fire.func_180686_a(Blocks.yellow_flower, 60, 100);
        Blocks.fire.func_180686_a(Blocks.red_flower, 60, 100);
        Blocks.fire.func_180686_a(Blocks.deadbush, 60, 100);
        Blocks.fire.func_180686_a(Blocks.wool, 30, 60);
        Blocks.fire.func_180686_a(Blocks.vine, 15, 100);
        Blocks.fire.func_180686_a(Blocks.coal_block, 5, 5);
        Blocks.fire.func_180686_a(Blocks.hay_block, 60, 20);
        Blocks.fire.func_180686_a(Blocks.carpet, 60, 20);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIllIIIIIIIIlIlll) {
        return (int)llllllllllllllIIIllIIIIIIIIlIlll.getValue(BlockFire.field_176543_a);
    }
}
