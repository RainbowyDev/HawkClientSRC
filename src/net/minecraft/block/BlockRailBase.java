package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import java.util.*;

public abstract class BlockRailBase extends Block
{
    protected final /* synthetic */ boolean isPowered;
    
    @Override
    public boolean canPlaceBlockAt(final World lIlIIlIIllIlI, final BlockPos lIlIIlIIllIIl) {
        return World.doesBlockHaveSolidTopSurface(lIlIIlIIllIlI, lIlIIlIIllIIl.offsetDown());
    }
    
    @Override
    public void onBlockAdded(final World lIlIIlIIIllll, final BlockPos lIlIIlIIlIIlI, IBlockState lIlIIlIIIllIl) {
        if (!lIlIIlIIIllll.isRemote) {
            lIlIIlIIIllIl = (boolean)this.func_176564_a(lIlIIlIIIllll, lIlIIlIIlIIlI, (IBlockState)lIlIIlIIIllIl, true);
            if (this.isPowered) {
                this.onNeighborBlockChange(lIlIIlIIIllll, lIlIIlIIlIIlI, (IBlockState)lIlIIlIIIllIl, this);
            }
        }
    }
    
    @Override
    public void breakBlock(final World lIlIIIlIllIII, final BlockPos lIlIIIlIlIlll, final IBlockState lIlIIIlIllIlI) {
        super.breakBlock(lIlIIIlIllIII, lIlIIIlIlIlll, lIlIIIlIllIlI);
        if (((EnumRailDirection)lIlIIIlIllIlI.getValue(this.func_176560_l())).func_177018_c()) {
            lIlIIIlIllIII.notifyNeighborsOfStateChange(lIlIIIlIlIlll.offsetUp(), this);
        }
        if (this.isPowered) {
            lIlIIIlIllIII.notifyNeighborsOfStateChange(lIlIIIlIlIlll, this);
            lIlIIIlIllIII.notifyNeighborsOfStateChange(lIlIIIlIlIlll.offsetDown(), this);
        }
    }
    
    protected BlockRailBase(final boolean lIlIIllIIIllI) {
        super(Material.circuits);
        this.isPowered = lIlIIllIIIllI;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.setCreativeTab(CreativeTabs.tabTransport);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lIlIIlIlIIlII, final BlockPos lIlIIlIlIIIll) {
        final IBlockState lIlIIlIlIIlll = lIlIIlIlIIlII.getBlockState(lIlIIlIlIIIll);
        final EnumRailDirection lIlIIlIlIIllI = (lIlIIlIlIIlll.getBlock() == this) ? ((EnumRailDirection)lIlIIlIlIIlll.getValue(this.func_176560_l())) : null;
        if (lIlIIlIlIIllI != null && lIlIIlIlIIllI.func_177018_c()) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        }
        else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        }
    }
    
    protected IBlockState func_176564_a(final World lIlIIIllIIlll, final BlockPos lIlIIIllIIllI, final IBlockState lIlIIIllIlIlI, final boolean lIlIIIllIlIIl) {
        return lIlIIIllIIlll.isRemote ? lIlIIIllIlIlI : new Rail(lIlIIIllIIlll, lIlIIIllIIllI, lIlIIIllIlIlI).func_180364_a(lIlIIIllIIlll.isBlockPowered(lIlIIIllIIllI), lIlIIIllIlIIl).func_180362_b();
    }
    
    @Override
    public void onNeighborBlockChange(final World lIlIIIlllllIl, final BlockPos lIlIIlIIIIIll, final IBlockState lIlIIIllllIll, final Block lIlIIIllllIlI) {
        if (!lIlIIIlllllIl.isRemote) {
            final EnumRailDirection lIlIIlIIIIIII = (EnumRailDirection)lIlIIIllllIll.getValue(this.func_176560_l());
            boolean lIlIIIlllllll = false;
            if (!World.doesBlockHaveSolidTopSurface(lIlIIIlllllIl, lIlIIlIIIIIll.offsetDown())) {
                lIlIIIlllllll = true;
            }
            if (lIlIIlIIIIIII == EnumRailDirection.ASCENDING_EAST && !World.doesBlockHaveSolidTopSurface(lIlIIIlllllIl, lIlIIlIIIIIll.offsetEast())) {
                lIlIIIlllllll = true;
            }
            else if (lIlIIlIIIIIII == EnumRailDirection.ASCENDING_WEST && !World.doesBlockHaveSolidTopSurface(lIlIIIlllllIl, lIlIIlIIIIIll.offsetWest())) {
                lIlIIIlllllll = true;
            }
            else if (lIlIIlIIIIIII == EnumRailDirection.ASCENDING_NORTH && !World.doesBlockHaveSolidTopSurface(lIlIIIlllllIl, lIlIIlIIIIIll.offsetNorth())) {
                lIlIIIlllllll = true;
            }
            else if (lIlIIlIIIIIII == EnumRailDirection.ASCENDING_SOUTH && !World.doesBlockHaveSolidTopSurface(lIlIIIlllllIl, lIlIIlIIIIIll.offsetSouth())) {
                lIlIIIlllllll = true;
            }
            if (lIlIIIlllllll) {
                this.dropBlockAsItem(lIlIIIlllllIl, lIlIIlIIIIIll, lIlIIIllllIll, 0);
                lIlIIIlllllIl.setBlockToAir(lIlIIlIIIIIll);
            }
            else {
                this.func_176561_b(lIlIIIlllllIl, lIlIIlIIIIIll, lIlIIIllllIll, lIlIIIllllIlI);
            }
        }
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lIlIIllIIIIlI, final BlockPos lIlIIllIIIIIl, final IBlockState lIlIIllIIIIII) {
        return null;
    }
    
    public abstract IProperty func_176560_l();
    
    static {
        __OBFID = "CL_00000195";
    }
    
    public static boolean func_176562_d(final World lIlIIllIlIIll, final BlockPos lIlIIllIlIIlI) {
        return func_176563_d(lIlIIllIlIIll.getBlockState(lIlIIllIlIIlI));
    }
    
    @Override
    public int getMobilityFlag() {
        return 0;
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    protected void func_176561_b(final World lIlIIIlllIllI, final BlockPos lIlIIIlllIlIl, final IBlockState lIlIIIlllIlII, final Block lIlIIIlllIIll) {
    }
    
    @Override
    public MovingObjectPosition collisionRayTrace(final World lIlIIlIllIIll, final BlockPos lIlIIlIllIIlI, final Vec3 lIlIIlIllIIIl, final Vec3 lIlIIlIllIIII) {
        this.setBlockBoundsBasedOnState(lIlIIlIllIIll, lIlIIlIllIIlI);
        return super.collisionRayTrace(lIlIIlIllIIll, lIlIIlIllIIlI, lIlIIlIllIIIl, lIlIIlIllIIII);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    public static boolean func_176563_d(final IBlockState lIlIIllIIlIll) {
        final Block lIlIIllIIllII = lIlIIllIIlIll.getBlock();
        return lIlIIllIIllII == Blocks.rail || lIlIIllIIllII == Blocks.golden_rail || lIlIIllIIllII == Blocks.detector_rail || lIlIIllIIllII == Blocks.activator_rail;
    }
    
    public enum EnumRailDirection implements IStringSerializable
    {
        EAST_WEST("EAST_WEST", 1, "EAST_WEST", 1, 1, "east_west"), 
        ASCENDING_WEST("ASCENDING_WEST", 3, "ASCENDING_WEST", 3, 3, "ascending_west"), 
        ASCENDING_EAST("ASCENDING_EAST", 2, "ASCENDING_EAST", 2, 2, "ascending_east"), 
        ASCENDING_SOUTH("ASCENDING_SOUTH", 5, "ASCENDING_SOUTH", 5, 5, "ascending_south"), 
        NORTH_SOUTH("NORTH_SOUTH", 0, "NORTH_SOUTH", 0, 0, "north_south"), 
        NORTH_WEST("NORTH_WEST", 8, "NORTH_WEST", 8, 8, "north_west");
        
        private final /* synthetic */ int field_177027_l;
        
        SOUTH_WEST("SOUTH_WEST", 7, "SOUTH_WEST", 7, 7, "south_west"), 
        NORTH_EAST("NORTH_EAST", 9, "NORTH_EAST", 9, 9, "north_east"), 
        ASCENDING_NORTH("ASCENDING_NORTH", 4, "ASCENDING_NORTH", 4, 4, "ascending_north"), 
        SOUTH_EAST("SOUTH_EAST", 6, "SOUTH_EAST", 6, 6, "south_east");
        
        private final /* synthetic */ String field_177028_m;
        private static final /* synthetic */ EnumRailDirection[] field_177030_k;
        
        private EnumRailDirection(final String lllllllllllllllIIllllIIllllIlIlI, final int lllllllllllllllIIllllIIllllIlIIl, final String lllllllllllllllIIllllIIllllIllll, final int lllllllllllllllIIllllIIllllIlllI, final int lllllllllllllllIIllllIIllllIllIl, final String lllllllllllllllIIllllIIllllIIlll) {
            this.field_177027_l = lllllllllllllllIIllllIIllllIllIl;
            this.field_177028_m = lllllllllllllllIIllllIIllllIIlll;
        }
        
        static {
            __OBFID = "CL_00002137";
            field_177030_k = new EnumRailDirection[values().length];
            for (final EnumRailDirection lllllllllllllllIIllllIIllllllIlI : values()) {
                EnumRailDirection.field_177030_k[lllllllllllllllIIllllIIllllllIlI.func_177015_a()] = lllllllllllllllIIllllIIllllllIlI;
            }
        }
        
        @Override
        public String toString() {
            return this.field_177028_m;
        }
        
        public int func_177015_a() {
            return this.field_177027_l;
        }
        
        public boolean func_177018_c() {
            return this == EnumRailDirection.ASCENDING_NORTH || this == EnumRailDirection.ASCENDING_EAST || this == EnumRailDirection.ASCENDING_SOUTH || this == EnumRailDirection.ASCENDING_WEST;
        }
        
        @Override
        public String getName() {
            return this.field_177028_m;
        }
        
        public static EnumRailDirection func_177016_a(int lllllllllllllllIIllllIIlllIllIll) {
            if (lllllllllllllllIIllllIIlllIllIll < 0 || lllllllllllllllIIllllIIlllIllIll >= EnumRailDirection.field_177030_k.length) {
                lllllllllllllllIIllllIIlllIllIll = 0;
            }
            return EnumRailDirection.field_177030_k[lllllllllllllllIIllllIIlllIllIll];
        }
    }
    
    public class Rail
    {
        private final /* synthetic */ List field_150657_g;
        private final /* synthetic */ boolean field_150656_f;
        private final /* synthetic */ BlockPos field_180367_c;
        private final /* synthetic */ World field_150660_b;
        private final /* synthetic */ BlockRailBase field_180365_d;
        private /* synthetic */ IBlockState field_180366_e;
        
        private boolean func_180359_a(final BlockPos llllllllllllllllllllIIIIIIllIlII) {
            return BlockRailBase.func_176562_d(this.field_150660_b, llllllllllllllllllllIIIIIIllIlII) || BlockRailBase.func_176562_d(this.field_150660_b, llllllllllllllllllllIIIIIIllIlII.offsetUp()) || BlockRailBase.func_176562_d(this.field_150660_b, llllllllllllllllllllIIIIIIllIlII.offsetDown());
        }
        
        private boolean func_180363_c(final BlockPos llllllllllllllllllllIIIIIIIlllII) {
            for (int llllllllllllllllllllIIIIIIIllIll = 0; llllllllllllllllllllIIIIIIIllIll < this.field_150657_g.size(); ++llllllllllllllllllllIIIIIIIllIll) {
                final BlockPos llllllllllllllllllllIIIIIIIllIlI = this.field_150657_g.get(llllllllllllllllllllIIIIIIIllIll);
                if (llllllllllllllllllllIIIIIIIllIlI.getX() == llllllllllllllllllllIIIIIIIlllII.getX() && llllllllllllllllllllIIIIIIIllIlI.getZ() == llllllllllllllllllllIIIIIIIlllII.getZ()) {
                    return true;
                }
            }
            return false;
        }
        
        private boolean func_150649_b(final Rail llllllllllllllllllllIIIIIIIIIlII) {
            return this.func_150653_a(llllllllllllllllllllIIIIIIIIIlII) || this.field_150657_g.size() != 2;
        }
        
        private void func_150645_c(final Rail lllllllllllllllllllIlllllllIllII) {
            this.field_150657_g.add(lllllllllllllllllllIlllllllIllII.field_180367_c);
            final BlockPos lllllllllllllllllllIllllllllIllI = this.field_180367_c.offsetNorth();
            final BlockPos lllllllllllllllllllIllllllllIlIl = this.field_180367_c.offsetSouth();
            final BlockPos lllllllllllllllllllIllllllllIlII = this.field_180367_c.offsetWest();
            final BlockPos lllllllllllllllllllIllllllllIIll = this.field_180367_c.offsetEast();
            final boolean lllllllllllllllllllIllllllllIIlI = this.func_180363_c(lllllllllllllllllllIllllllllIllI);
            final boolean lllllllllllllllllllIllllllllIIIl = this.func_180363_c(lllllllllllllllllllIllllllllIlIl);
            final boolean lllllllllllllllllllIllllllllIIII = this.func_180363_c(lllllllllllllllllllIllllllllIlII);
            final boolean lllllllllllllllllllIlllllllIllll = this.func_180363_c(lllllllllllllllllllIllllllllIIll);
            EnumRailDirection lllllllllllllllllllIlllllllIlllI = null;
            if (lllllllllllllllllllIllllllllIIlI || lllllllllllllllllllIllllllllIIIl) {
                lllllllllllllllllllIlllllllIlllI = EnumRailDirection.NORTH_SOUTH;
            }
            if (lllllllllllllllllllIllllllllIIII || lllllllllllllllllllIlllllllIllll) {
                lllllllllllllllllllIlllllllIlllI = EnumRailDirection.EAST_WEST;
            }
            if (!this.field_150656_f) {
                if (lllllllllllllllllllIllllllllIIIl && lllllllllllllllllllIlllllllIllll && !lllllllllllllllllllIllllllllIIlI && !lllllllllllllllllllIllllllllIIII) {
                    lllllllllllllllllllIlllllllIlllI = EnumRailDirection.SOUTH_EAST;
                }
                if (lllllllllllllllllllIllllllllIIIl && lllllllllllllllllllIllllllllIIII && !lllllllllllllllllllIllllllllIIlI && !lllllllllllllllllllIlllllllIllll) {
                    lllllllllllllllllllIlllllllIlllI = EnumRailDirection.SOUTH_WEST;
                }
                if (lllllllllllllllllllIllllllllIIlI && lllllllllllllllllllIllllllllIIII && !lllllllllllllllllllIllllllllIIIl && !lllllllllllllllllllIlllllllIllll) {
                    lllllllllllllllllllIlllllllIlllI = EnumRailDirection.NORTH_WEST;
                }
                if (lllllllllllllllllllIllllllllIIlI && lllllllllllllllllllIlllllllIllll && !lllllllllllllllllllIllllllllIIIl && !lllllllllllllllllllIllllllllIIII) {
                    lllllllllllllllllllIlllllllIlllI = EnumRailDirection.NORTH_EAST;
                }
            }
            if (lllllllllllllllllllIlllllllIlllI == EnumRailDirection.NORTH_SOUTH) {
                if (BlockRailBase.func_176562_d(this.field_150660_b, lllllllllllllllllllIllllllllIllI.offsetUp())) {
                    lllllllllllllllllllIlllllllIlllI = EnumRailDirection.ASCENDING_NORTH;
                }
                if (BlockRailBase.func_176562_d(this.field_150660_b, lllllllllllllllllllIllllllllIlIl.offsetUp())) {
                    lllllllllllllllllllIlllllllIlllI = EnumRailDirection.ASCENDING_SOUTH;
                }
            }
            if (lllllllllllllllllllIlllllllIlllI == EnumRailDirection.EAST_WEST) {
                if (BlockRailBase.func_176562_d(this.field_150660_b, lllllllllllllllllllIllllllllIIll.offsetUp())) {
                    lllllllllllllllllllIlllllllIlllI = EnumRailDirection.ASCENDING_EAST;
                }
                if (BlockRailBase.func_176562_d(this.field_150660_b, lllllllllllllllllllIllllllllIlII.offsetUp())) {
                    lllllllllllllllllllIlllllllIlllI = EnumRailDirection.ASCENDING_WEST;
                }
            }
            if (lllllllllllllllllllIlllllllIlllI == null) {
                lllllllllllllllllllIlllllllIlllI = EnumRailDirection.NORTH_SOUTH;
            }
            this.field_180366_e = this.field_180366_e.withProperty(this.field_180365_d.func_176560_l(), lllllllllllllllllllIlllllllIlllI);
            this.field_150660_b.setBlockState(this.field_180367_c, this.field_180366_e, 3);
        }
        
        private boolean func_180361_d(final BlockPos lllllllllllllllllllIllllllIllIll) {
            final Rail lllllllllllllllllllIllllllIlllIl = this.func_180697_b(lllllllllllllllllllIllllllIllIll);
            if (lllllllllllllllllllIllllllIlllIl == null) {
                return false;
            }
            lllllllllllllllllllIllllllIlllIl.func_150651_b();
            return lllllllllllllllllllIllllllIlllIl.func_150649_b(this);
        }
        
        static {
            __OBFID = "CL_00000196";
        }
        
        public Rail func_180364_a(final boolean lllllllllllllllllllIlllllIllllII, final boolean lllllllllllllllllllIllllllIIlIIl) {
            final BlockPos lllllllllllllllllllIllllllIIlIII = this.field_180367_c.offsetNorth();
            final BlockPos lllllllllllllllllllIllllllIIIlll = this.field_180367_c.offsetSouth();
            final BlockPos lllllllllllllllllllIllllllIIIllI = this.field_180367_c.offsetWest();
            final BlockPos lllllllllllllllllllIllllllIIIlIl = this.field_180367_c.offsetEast();
            final boolean lllllllllllllllllllIllllllIIIlII = this.func_180361_d(lllllllllllllllllllIllllllIIlIII);
            final boolean lllllllllllllllllllIllllllIIIIll = this.func_180361_d(lllllllllllllllllllIllllllIIIlll);
            final boolean lllllllllllllllllllIllllllIIIIlI = this.func_180361_d(lllllllllllllllllllIllllllIIIllI);
            final boolean lllllllllllllllllllIllllllIIIIIl = this.func_180361_d(lllllllllllllllllllIllllllIIIlIl);
            EnumRailDirection lllllllllllllllllllIllllllIIIIII = null;
            if ((lllllllllllllllllllIllllllIIIlII || lllllllllllllllllllIllllllIIIIll) && !lllllllllllllllllllIllllllIIIIlI && !lllllllllllllllllllIllllllIIIIIl) {
                lllllllllllllllllllIllllllIIIIII = EnumRailDirection.NORTH_SOUTH;
            }
            if ((lllllllllllllllllllIllllllIIIIlI || lllllllllllllllllllIllllllIIIIIl) && !lllllllllllllllllllIllllllIIIlII && !lllllllllllllllllllIllllllIIIIll) {
                lllllllllllllllllllIllllllIIIIII = EnumRailDirection.EAST_WEST;
            }
            if (!this.field_150656_f) {
                if (lllllllllllllllllllIllllllIIIIll && lllllllllllllllllllIllllllIIIIIl && !lllllllllllllllllllIllllllIIIlII && !lllllllllllllllllllIllllllIIIIlI) {
                    lllllllllllllllllllIllllllIIIIII = EnumRailDirection.SOUTH_EAST;
                }
                if (lllllllllllllllllllIllllllIIIIll && lllllllllllllllllllIllllllIIIIlI && !lllllllllllllllllllIllllllIIIlII && !lllllllllllllllllllIllllllIIIIIl) {
                    lllllllllllllllllllIllllllIIIIII = EnumRailDirection.SOUTH_WEST;
                }
                if (lllllllllllllllllllIllllllIIIlII && lllllllllllllllllllIllllllIIIIlI && !lllllllllllllllllllIllllllIIIIll && !lllllllllllllllllllIllllllIIIIIl) {
                    lllllllllllllllllllIllllllIIIIII = EnumRailDirection.NORTH_WEST;
                }
                if (lllllllllllllllllllIllllllIIIlII && lllllllllllllllllllIllllllIIIIIl && !lllllllllllllllllllIllllllIIIIll && !lllllllllllllllllllIllllllIIIIlI) {
                    lllllllllllllllllllIllllllIIIIII = EnumRailDirection.NORTH_EAST;
                }
            }
            if (lllllllllllllllllllIllllllIIIIII == null) {
                if (lllllllllllllllllllIllllllIIIlII || lllllllllllllllllllIllllllIIIIll) {
                    lllllllllllllllllllIllllllIIIIII = EnumRailDirection.NORTH_SOUTH;
                }
                if (lllllllllllllllllllIllllllIIIIlI || lllllllllllllllllllIllllllIIIIIl) {
                    lllllllllllllllllllIllllllIIIIII = EnumRailDirection.EAST_WEST;
                }
                if (!this.field_150656_f) {
                    if (lllllllllllllllllllIlllllIllllII) {
                        if (lllllllllllllllllllIllllllIIIIll && lllllllllllllllllllIllllllIIIIIl) {
                            lllllllllllllllllllIllllllIIIIII = EnumRailDirection.SOUTH_EAST;
                        }
                        if (lllllllllllllllllllIllllllIIIIlI && lllllllllllllllllllIllllllIIIIll) {
                            lllllllllllllllllllIllllllIIIIII = EnumRailDirection.SOUTH_WEST;
                        }
                        if (lllllllllllllllllllIllllllIIIIIl && lllllllllllllllllllIllllllIIIlII) {
                            lllllllllllllllllllIllllllIIIIII = EnumRailDirection.NORTH_EAST;
                        }
                        if (lllllllllllllllllllIllllllIIIlII && lllllllllllllllllllIllllllIIIIlI) {
                            lllllllllllllllllllIllllllIIIIII = EnumRailDirection.NORTH_WEST;
                        }
                    }
                    else {
                        if (lllllllllllllllllllIllllllIIIlII && lllllllllllllllllllIllllllIIIIlI) {
                            lllllllllllllllllllIllllllIIIIII = EnumRailDirection.NORTH_WEST;
                        }
                        if (lllllllllllllllllllIllllllIIIIIl && lllllllllllllllllllIllllllIIIlII) {
                            lllllllllllllllllllIllllllIIIIII = EnumRailDirection.NORTH_EAST;
                        }
                        if (lllllllllllllllllllIllllllIIIIlI && lllllllllllllllllllIllllllIIIIll) {
                            lllllllllllllllllllIllllllIIIIII = EnumRailDirection.SOUTH_WEST;
                        }
                        if (lllllllllllllllllllIllllllIIIIll && lllllllllllllllllllIllllllIIIIIl) {
                            lllllllllllllllllllIllllllIIIIII = EnumRailDirection.SOUTH_EAST;
                        }
                    }
                }
            }
            if (lllllllllllllllllllIllllllIIIIII == EnumRailDirection.NORTH_SOUTH) {
                if (BlockRailBase.func_176562_d(this.field_150660_b, lllllllllllllllllllIllllllIIlIII.offsetUp())) {
                    lllllllllllllllllllIllllllIIIIII = EnumRailDirection.ASCENDING_NORTH;
                }
                if (BlockRailBase.func_176562_d(this.field_150660_b, lllllllllllllllllllIllllllIIIlll.offsetUp())) {
                    lllllllllllllllllllIllllllIIIIII = EnumRailDirection.ASCENDING_SOUTH;
                }
            }
            if (lllllllllllllllllllIllllllIIIIII == EnumRailDirection.EAST_WEST) {
                if (BlockRailBase.func_176562_d(this.field_150660_b, lllllllllllllllllllIllllllIIIlIl.offsetUp())) {
                    lllllllllllllllllllIllllllIIIIII = EnumRailDirection.ASCENDING_EAST;
                }
                if (BlockRailBase.func_176562_d(this.field_150660_b, lllllllllllllllllllIllllllIIIllI.offsetUp())) {
                    lllllllllllllllllllIllllllIIIIII = EnumRailDirection.ASCENDING_WEST;
                }
            }
            if (lllllllllllllllllllIllllllIIIIII == null) {
                lllllllllllllllllllIllllllIIIIII = EnumRailDirection.NORTH_SOUTH;
            }
            this.func_180360_a(lllllllllllllllllllIllllllIIIIII);
            this.field_180366_e = this.field_180366_e.withProperty(this.field_180365_d.func_176560_l(), lllllllllllllllllllIllllllIIIIII);
            if (lllllllllllllllllllIllllllIIlIIl || this.field_150660_b.getBlockState(this.field_180367_c) != this.field_180366_e) {
                this.field_150660_b.setBlockState(this.field_180367_c, this.field_180366_e, 3);
                for (int lllllllllllllllllllIlllllIllllll = 0; lllllllllllllllllllIlllllIllllll < this.field_150657_g.size(); ++lllllllllllllllllllIlllllIllllll) {
                    final Rail lllllllllllllllllllIlllllIlllllI = this.func_180697_b(this.field_150657_g.get(lllllllllllllllllllIlllllIllllll));
                    if (lllllllllllllllllllIlllllIlllllI != null) {
                        lllllllllllllllllllIlllllIlllllI.func_150651_b();
                        if (lllllllllllllllllllIlllllIlllllI.func_150649_b(this)) {
                            lllllllllllllllllllIlllllIlllllI.func_150645_c(this);
                        }
                    }
                }
            }
            return this;
        }
        
        private boolean func_150653_a(final Rail llllllllllllllllllllIIIIIIlIIlII) {
            return this.func_180363_c(llllllllllllllllllllIIIIIIlIIlII.field_180367_c);
        }
        
        private void func_180360_a(final EnumRailDirection llllllllllllllllllllIIIIIlIIIlIl) {
            this.field_150657_g.clear();
            switch (SwitchEnumRailDirection.field_180371_a[llllllllllllllllllllIIIIIlIIIlIl.ordinal()]) {
                case 1: {
                    this.field_150657_g.add(this.field_180367_c.offsetNorth());
                    this.field_150657_g.add(this.field_180367_c.offsetSouth());
                    break;
                }
                case 2: {
                    this.field_150657_g.add(this.field_180367_c.offsetWest());
                    this.field_150657_g.add(this.field_180367_c.offsetEast());
                    break;
                }
                case 3: {
                    this.field_150657_g.add(this.field_180367_c.offsetWest());
                    this.field_150657_g.add(this.field_180367_c.offsetEast().offsetUp());
                    break;
                }
                case 4: {
                    this.field_150657_g.add(this.field_180367_c.offsetWest().offsetUp());
                    this.field_150657_g.add(this.field_180367_c.offsetEast());
                    break;
                }
                case 5: {
                    this.field_150657_g.add(this.field_180367_c.offsetNorth().offsetUp());
                    this.field_150657_g.add(this.field_180367_c.offsetSouth());
                    break;
                }
                case 6: {
                    this.field_150657_g.add(this.field_180367_c.offsetNorth());
                    this.field_150657_g.add(this.field_180367_c.offsetSouth().offsetUp());
                    break;
                }
                case 7: {
                    this.field_150657_g.add(this.field_180367_c.offsetEast());
                    this.field_150657_g.add(this.field_180367_c.offsetSouth());
                    break;
                }
                case 8: {
                    this.field_150657_g.add(this.field_180367_c.offsetWest());
                    this.field_150657_g.add(this.field_180367_c.offsetSouth());
                    break;
                }
                case 9: {
                    this.field_150657_g.add(this.field_180367_c.offsetWest());
                    this.field_150657_g.add(this.field_180367_c.offsetNorth());
                    break;
                }
                case 10: {
                    this.field_150657_g.add(this.field_180367_c.offsetEast());
                    this.field_150657_g.add(this.field_180367_c.offsetNorth());
                    break;
                }
            }
        }
        
        private void func_150651_b() {
            for (int llllllllllllllllllllIIIIIIlllllI = 0; llllllllllllllllllllIIIIIIlllllI < this.field_150657_g.size(); ++llllllllllllllllllllIIIIIIlllllI) {
                final Rail llllllllllllllllllllIIIIIIllllIl = this.func_180697_b(this.field_150657_g.get(llllllllllllllllllllIIIIIIlllllI));
                if (llllllllllllllllllllIIIIIIllllIl != null && llllllllllllllllllllIIIIIIllllIl.func_150653_a(this)) {
                    this.field_150657_g.set(llllllllllllllllllllIIIIIIlllllI, llllllllllllllllllllIIIIIIllllIl.field_180367_c);
                }
                else {
                    this.field_150657_g.remove(llllllllllllllllllllIIIIIIlllllI--);
                }
            }
        }
        
        public IBlockState func_180362_b() {
            return this.field_180366_e;
        }
        
        private Rail func_180697_b(final BlockPos llllllllllllllllllllIIIIIIlIlllI) {
            IBlockState llllllllllllllllllllIIIIIIlIllIl = this.field_150660_b.getBlockState(llllllllllllllllllllIIIIIIlIlllI);
            if (BlockRailBase.func_176563_d(llllllllllllllllllllIIIIIIlIllIl)) {
                return new Rail(this.field_150660_b, llllllllllllllllllllIIIIIIlIlllI, llllllllllllllllllllIIIIIIlIllIl);
            }
            BlockPos llllllllllllllllllllIIIIIIlIllII = llllllllllllllllllllIIIIIIlIlllI.offsetUp();
            llllllllllllllllllllIIIIIIlIllIl = this.field_150660_b.getBlockState(llllllllllllllllllllIIIIIIlIllII);
            if (BlockRailBase.func_176563_d(llllllllllllllllllllIIIIIIlIllIl)) {
                return new Rail(this.field_150660_b, llllllllllllllllllllIIIIIIlIllII, llllllllllllllllllllIIIIIIlIllIl);
            }
            llllllllllllllllllllIIIIIIlIllII = llllllllllllllllllllIIIIIIlIlllI.offsetDown();
            llllllllllllllllllllIIIIIIlIllIl = this.field_150660_b.getBlockState(llllllllllllllllllllIIIIIIlIllII);
            return BlockRailBase.func_176563_d(llllllllllllllllllllIIIIIIlIllIl) ? new Rail(this.field_150660_b, llllllllllllllllllllIIIIIIlIllII, llllllllllllllllllllIIIIIIlIllIl) : null;
        }
        
        public Rail(final World llllllllllllllllllllIIIIIlIIllII, final BlockPos llllllllllllllllllllIIIIIlIIlIll, final IBlockState llllllllllllllllllllIIIIIlIlIIII) {
            this.field_150657_g = Lists.newArrayList();
            this.field_150660_b = llllllllllllllllllllIIIIIlIIllII;
            this.field_180367_c = llllllllllllllllllllIIIIIlIIlIll;
            this.field_180366_e = llllllllllllllllllllIIIIIlIlIIII;
            this.field_180365_d = (BlockRailBase)llllllllllllllllllllIIIIIlIlIIII.getBlock();
            final EnumRailDirection llllllllllllllllllllIIIIIlIIllll = (EnumRailDirection)llllllllllllllllllllIIIIIlIlIIII.getValue(BlockRailBase.this.func_176560_l());
            this.field_150656_f = this.field_180365_d.isPowered;
            this.func_180360_a(llllllllllllllllllllIIIIIlIIllll);
        }
        
        protected int countAdjacentRails() {
            int llllllllllllllllllllIIIIIIIlIIII = 0;
            for (final EnumFacing llllllllllllllllllllIIIIIIIIlllI : EnumFacing.Plane.HORIZONTAL) {
                if (this.func_180359_a(this.field_180367_c.offset(llllllllllllllllllllIIIIIIIIlllI))) {
                    ++llllllllllllllllllllIIIIIIIlIIII;
                }
            }
            return llllllllllllllllllllIIIIIIIlIIII;
        }
    }
    
    static final class SwitchEnumRailDirection
    {
        static final /* synthetic */ int[] field_180371_a;
        
        static {
            __OBFID = "CL_00002138";
            field_180371_a = new int[EnumRailDirection.values().length];
            try {
                SwitchEnumRailDirection.field_180371_a[EnumRailDirection.NORTH_SOUTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumRailDirection.field_180371_a[EnumRailDirection.EAST_WEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumRailDirection.field_180371_a[EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumRailDirection.field_180371_a[EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumRailDirection.field_180371_a[EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumRailDirection.field_180371_a[EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchEnumRailDirection.field_180371_a[EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchEnumRailDirection.field_180371_a[EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchEnumRailDirection.field_180371_a[EnumRailDirection.NORTH_WEST.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                SwitchEnumRailDirection.field_180371_a[EnumRailDirection.NORTH_EAST.ordinal()] = 10;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
        }
    }
}
