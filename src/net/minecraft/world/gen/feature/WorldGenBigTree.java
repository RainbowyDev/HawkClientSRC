package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import com.google.common.collect.*;
import net.minecraft.util.*;

public class WorldGenBigTree extends WorldGenAbstractTree
{
    private /* synthetic */ World field_175946_l;
    /* synthetic */ int field_175943_g;
    /* synthetic */ int field_175950_h;
    /* synthetic */ List field_175948_j;
    /* synthetic */ double leafDensity;
    /* synthetic */ double heightAttenuation;
    private /* synthetic */ BlockPos field_175947_m;
    /* synthetic */ double field_175945_e;
    private /* synthetic */ Random field_175949_k;
    /* synthetic */ double field_175944_d;
    /* synthetic */ int height;
    /* synthetic */ int heightLimit;
    /* synthetic */ int leafDistanceLimit;
    
    private BlockLog.EnumAxis func_175938_b(final BlockPos llIllIIlIllll, final BlockPos llIllIIlIlllI) {
        BlockLog.EnumAxis llIllIIllIIll = BlockLog.EnumAxis.Y;
        final int llIllIIllIIlI = Math.abs(llIllIIlIlllI.getX() - llIllIIlIllll.getX());
        final int llIllIIllIIIl = Math.abs(llIllIIlIlllI.getZ() - llIllIIlIllll.getZ());
        final int llIllIIllIIII = Math.max(llIllIIllIIlI, llIllIIllIIIl);
        if (llIllIIllIIII > 0) {
            if (llIllIIllIIlI == llIllIIllIIII) {
                llIllIIllIIll = BlockLog.EnumAxis.X;
            }
            else if (llIllIIllIIIl == llIllIIllIIII) {
                llIllIIllIIll = BlockLog.EnumAxis.Z;
            }
        }
        return llIllIIllIIll;
    }
    
    void func_175937_a(final BlockPos llIllIllIIIII, final BlockPos llIllIlIlIIll, final Block llIllIlIllllI) {
        final BlockPos llIllIlIlllIl = llIllIlIlIIll.add(-llIllIllIIIII.getX(), -llIllIllIIIII.getY(), -llIllIllIIIII.getZ());
        final int llIllIlIlllII = this.func_175935_b(llIllIlIlllIl);
        final float llIllIlIllIll = llIllIlIlllIl.getX() / (float)llIllIlIlllII;
        final float llIllIlIllIlI = llIllIlIlllIl.getY() / (float)llIllIlIlllII;
        final float llIllIlIllIIl = llIllIlIlllIl.getZ() / (float)llIllIlIlllII;
        for (int llIllIlIllIII = 0; llIllIlIllIII <= llIllIlIlllII; ++llIllIlIllIII) {
            final BlockPos llIllIlIlIlll = llIllIllIIIII.add(0.5f + llIllIlIllIII * llIllIlIllIll, 0.5f + llIllIlIllIII * llIllIlIllIlI, 0.5f + llIllIlIllIII * llIllIlIllIIl);
            final BlockLog.EnumAxis llIllIlIlIllI = this.func_175938_b(llIllIllIIIII, llIllIlIlIlll);
            this.func_175903_a(this.field_175946_l, llIllIlIlIlll, llIllIlIllllI.getDefaultState().withProperty(BlockLog.AXIS_PROP, llIllIlIlIllI));
        }
    }
    
    void func_175941_b() {
        for (final FoliageCoordinates llIllIIlIIlII : this.field_175948_j) {
            this.func_175940_a(llIllIIlIIlII);
        }
    }
    
    public WorldGenBigTree(final boolean llIllllIllIlI) {
        super(llIllllIllIlI);
        this.field_175947_m = BlockPos.ORIGIN;
        this.heightAttenuation = 0.618;
        this.field_175944_d = 0.381;
        this.field_175945_e = 1.0;
        this.leafDensity = 1.0;
        this.field_175943_g = 1;
        this.field_175950_h = 12;
        this.leafDistanceLimit = 4;
    }
    
    @Override
    public void func_175904_e() {
        this.leafDistanceLimit = 5;
    }
    
    void func_175940_a(final BlockPos llIllIllIllll) {
        for (int llIllIlllIIIl = 0; llIllIlllIIIl < this.leafDistanceLimit; ++llIllIlllIIIl) {
            this.func_180712_a(llIllIllIllll.offsetUp(llIllIlllIIIl), this.leafSize(llIllIlllIIIl), Blocks.leaves);
        }
    }
    
    int func_175936_a(final BlockPos llIlIlllIlIlI, final BlockPos llIlIlllIlIIl) {
        final BlockPos llIlIllllIIlI = llIlIlllIlIIl.add(-llIlIlllIlIlI.getX(), -llIlIlllIlIlI.getY(), -llIlIlllIlIlI.getZ());
        final int llIlIllllIIIl = this.func_175935_b(llIlIllllIIlI);
        final float llIlIllllIIII = llIlIllllIIlI.getX() / (float)llIlIllllIIIl;
        final float llIlIlllIllll = llIlIllllIIlI.getY() / (float)llIlIllllIIIl;
        final float llIlIlllIlllI = llIlIllllIIlI.getZ() / (float)llIlIllllIIIl;
        if (llIlIllllIIIl == 0) {
            return -1;
        }
        for (int llIlIlllIllIl = 0; llIlIlllIllIl <= llIlIllllIIIl; ++llIlIlllIllIl) {
            final BlockPos llIlIlllIllII = llIlIlllIlIlI.add(0.5f + llIlIlllIllIl * llIlIllllIIII, 0.5f + llIlIlllIllIl * llIlIlllIllll, 0.5f + llIlIlllIllIl * llIlIlllIlllI);
            if (!this.func_150523_a(this.field_175946_l.getBlockState(llIlIlllIllII).getBlock())) {
                return llIlIlllIllIl;
            }
        }
        return -1;
    }
    
    void func_180712_a(final BlockPos llIlllIIlIIll, final float llIlllIIllIll, final Block llIlllIIlIIIl) {
        for (int llIlllIIllIIl = (int)(llIlllIIllIll + 0.618), llIlllIIllIII = -llIlllIIllIIl; llIlllIIllIII <= llIlllIIllIIl; ++llIlllIIllIII) {
            for (int llIlllIIlIlll = -llIlllIIllIIl; llIlllIIlIlll <= llIlllIIllIIl; ++llIlllIIlIlll) {
                if (Math.pow(Math.abs(llIlllIIllIII) + 0.5, 2.0) + Math.pow(Math.abs(llIlllIIlIlll) + 0.5, 2.0) <= llIlllIIllIll * llIlllIIllIll) {
                    final BlockPos llIlllIIlIllI = llIlllIIlIIll.add(llIlllIIllIII, 0, llIlllIIlIlll);
                    final Material llIlllIIlIlIl = this.field_175946_l.getBlockState(llIlllIIlIllI).getBlock().getMaterial();
                    if (llIlllIIlIlIl == Material.air || llIlllIIlIlIl == Material.leaves) {
                        this.func_175905_a(this.field_175946_l, llIlllIIlIllI, llIlllIIlIIIl, 0);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean generate(final World llIlIllIllIIl, final Random llIlIllIllIII, final BlockPos llIlIllIlIIll) {
        this.field_175946_l = llIlIllIllIIl;
        this.field_175947_m = llIlIllIlIIll;
        this.field_175949_k = new Random(llIlIllIllIII.nextLong());
        if (this.heightLimit == 0) {
            this.heightLimit = 5 + this.field_175949_k.nextInt(this.field_175950_h);
        }
        if (!this.validTreeLocation()) {
            return false;
        }
        this.generateLeafNodeList();
        this.func_175941_b();
        this.func_175942_c();
        this.func_175939_d();
        return true;
    }
    
    float leafSize(final int llIllIlllIlll) {
        return (llIllIlllIlll >= 0 && llIllIlllIlll < this.leafDistanceLimit) ? ((llIllIlllIlll != 0 && llIllIlllIlll != this.leafDistanceLimit - 1) ? 3.0f : 2.0f) : -1.0f;
    }
    
    private boolean validTreeLocation() {
        final Block llIlIllIIlllI = this.field_175946_l.getBlockState(this.field_175947_m.offsetDown()).getBlock();
        if (llIlIllIIlllI != Blocks.dirt && llIlIllIIlllI != Blocks.grass && llIlIllIIlllI != Blocks.farmland) {
            return false;
        }
        final int llIlIllIIllIl = this.func_175936_a(this.field_175947_m, this.field_175947_m.offsetUp(this.heightLimit - 1));
        if (llIlIllIIllIl == -1) {
            return true;
        }
        if (llIlIllIIllIl < 6) {
            return false;
        }
        this.heightLimit = llIlIllIIllIl;
        return true;
    }
    
    void func_175942_c() {
        final BlockPos llIllIIIlIlIl = this.field_175947_m;
        final BlockPos llIllIIIlIlII = this.field_175947_m.offsetUp(this.height);
        final Block llIllIIIlIIll = Blocks.log;
        this.func_175937_a(llIllIIIlIlIl, llIllIIIlIlII, llIllIIIlIIll);
        if (this.field_175943_g == 2) {
            this.func_175937_a(llIllIIIlIlIl.offsetEast(), llIllIIIlIlII.offsetEast(), llIllIIIlIIll);
            this.func_175937_a(llIllIIIlIlIl.offsetEast().offsetSouth(), llIllIIIlIlII.offsetEast().offsetSouth(), llIllIIIlIIll);
            this.func_175937_a(llIllIIIlIlIl.offsetSouth(), llIllIIIlIlII.offsetSouth(), llIllIIIlIIll);
        }
    }
    
    void generateLeafNodeList() {
        this.height = (int)(this.heightLimit * this.heightAttenuation);
        if (this.height >= this.heightLimit) {
            this.height = this.heightLimit - 1;
        }
        int llIllllIIIlll = (int)(1.382 + Math.pow(this.leafDensity * this.heightLimit / 13.0, 2.0));
        if (llIllllIIIlll < 1) {
            llIllllIIIlll = 1;
        }
        final int llIllllIIIllI = this.field_175947_m.getY() + this.height;
        int llIllllIIIlIl = this.heightLimit - this.leafDistanceLimit;
        this.field_175948_j = Lists.newArrayList();
        this.field_175948_j.add(new FoliageCoordinates(this.field_175947_m.offsetUp(llIllllIIIlIl), llIllllIIIllI));
        while (llIllllIIIlIl >= 0) {
            final float llIllllIIIlII = this.layerSize(llIllllIIIlIl);
            if (llIllllIIIlII >= 0.0f) {
                for (int llIllllIIIIll = 0; llIllllIIIIll < llIllllIIIlll; ++llIllllIIIIll) {
                    final double llIllllIIIIlI = this.field_175945_e * llIllllIIIlII * (this.field_175949_k.nextFloat() + 0.328);
                    final double llIllllIIIIIl = this.field_175949_k.nextFloat() * 2.0f * 3.141592653589793;
                    final double llIllllIIIIII = llIllllIIIIlI * Math.sin(llIllllIIIIIl) + 0.5;
                    final double llIlllIllllll = llIllllIIIIlI * Math.cos(llIllllIIIIIl) + 0.5;
                    final BlockPos llIlllIlllllI = this.field_175947_m.add(llIllllIIIIII, llIllllIIIlIl - 1, llIlllIllllll);
                    final BlockPos llIlllIllllIl = llIlllIlllllI.offsetUp(this.leafDistanceLimit);
                    if (this.func_175936_a(llIlllIlllllI, llIlllIllllIl) == -1) {
                        final int llIlllIllllII = this.field_175947_m.getX() - llIlllIlllllI.getX();
                        final int llIlllIlllIll = this.field_175947_m.getZ() - llIlllIlllllI.getZ();
                        final double llIlllIlllIlI = llIlllIlllllI.getY() - Math.sqrt(llIlllIllllII * llIlllIllllII + llIlllIlllIll * llIlllIlllIll) * this.field_175944_d;
                        final int llIlllIlllIIl = (llIlllIlllIlI > llIllllIIIllI) ? llIllllIIIllI : ((int)llIlllIlllIlI);
                        final BlockPos llIlllIlllIII = new BlockPos(this.field_175947_m.getX(), llIlllIlllIIl, this.field_175947_m.getZ());
                        if (this.func_175936_a(llIlllIlllIII, llIlllIlllllI) == -1) {
                            this.field_175948_j.add(new FoliageCoordinates(llIlllIlllllI, llIlllIlllIII.getY()));
                        }
                    }
                }
            }
            --llIllllIIIlIl;
        }
    }
    
    static {
        __OBFID = "CL_00000400";
    }
    
    private int func_175935_b(final BlockPos llIllIlIIIlII) {
        final int llIllIlIIIIll = MathHelper.abs_int(llIllIlIIIlII.getX());
        final int llIllIlIIIIlI = MathHelper.abs_int(llIllIlIIIlII.getY());
        final int llIllIlIIIIIl = MathHelper.abs_int(llIllIlIIIlII.getZ());
        return (llIllIlIIIIIl > llIllIlIIIIll && llIllIlIIIIIl > llIllIlIIIIlI) ? llIllIlIIIIIl : ((llIllIlIIIIlI > llIllIlIIIIll) ? llIllIlIIIIlI : llIllIlIIIIll);
    }
    
    float layerSize(final int llIlllIIIIlIl) {
        if (llIlllIIIIlIl < this.heightLimit * 0.3f) {
            return -1.0f;
        }
        final float llIlllIIIIlII = this.heightLimit / 2.0f;
        final float llIlllIIIIIll = llIlllIIIIlII - llIlllIIIIlIl;
        float llIlllIIIIIlI = MathHelper.sqrt_float(llIlllIIIIlII * llIlllIIIIlII - llIlllIIIIIll * llIlllIIIIIll);
        if (llIlllIIIIIll == 0.0f) {
            llIlllIIIIIlI = llIlllIIIIlII;
        }
        else if (Math.abs(llIlllIIIIIll) >= llIlllIIIIlII) {
            return 0.0f;
        }
        return llIlllIIIIIlI * 0.5f;
    }
    
    void func_175939_d() {
        for (final FoliageCoordinates llIllIIIIIlll : this.field_175948_j) {
            final int llIllIIIIIllI = llIllIIIIIlll.func_177999_q();
            final BlockPos llIllIIIIIlIl = new BlockPos(this.field_175947_m.getX(), llIllIIIIIllI, this.field_175947_m.getZ());
            if (this.leafNodeNeedsBase(llIllIIIIIllI - this.field_175947_m.getY())) {
                this.func_175937_a(llIllIIIIIlIl, llIllIIIIIlll, Blocks.log);
            }
        }
    }
    
    boolean leafNodeNeedsBase(final int llIllIIIlllIl) {
        return llIllIIIlllIl >= this.heightLimit * 0.2;
    }
    
    static class FoliageCoordinates extends BlockPos
    {
        private final /* synthetic */ int field_178000_b;
        
        static {
            __OBFID = "CL_00002001";
        }
        
        public FoliageCoordinates(final BlockPos lllllllllllllllIIIIIIIlIlIIlIllI, final int lllllllllllllllIIIIIIIlIlIIlIlIl) {
            super(lllllllllllllllIIIIIIIlIlIIlIllI.getX(), lllllllllllllllIIIIIIIlIlIIlIllI.getY(), lllllllllllllllIIIIIIIlIlIIlIllI.getZ());
            this.field_178000_b = lllllllllllllllIIIIIIIlIlIIlIlIl;
        }
        
        public int func_177999_q() {
            return this.field_178000_b;
        }
    }
}
