package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class BlockPortal extends BlockBreakable
{
    public static final /* synthetic */ PropertyEnum field_176550_a;
    
    @Override
    public IBlockState getStateFromMeta(final int lIlIlIIllIlIIII) {
        return this.getDefaultState().withProperty(BlockPortal.field_176550_a, ((lIlIlIIllIlIIII & 0x3) == 0x2) ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
    }
    
    public static int func_176549_a(final EnumFacing.Axis lIlIlIlIlIIlIll) {
        return (lIlIlIlIlIIlIll == EnumFacing.Axis.X) ? 1 : ((lIlIlIlIlIIlIll == EnumFacing.Axis.Z) ? 2 : 0);
    }
    
    public BlockPortal() {
        super(Material.portal, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPortal.field_176550_a, EnumFacing.Axis.X));
        this.setTickRandomly(true);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockPortal.field_176550_a });
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess lIlIlIlIIIlIIII, final BlockPos lIlIlIlIIIIllll, final EnumFacing lIlIlIlIIIIlllI) {
        EnumFacing.Axis lIlIlIlIIIllIIl = null;
        final IBlockState lIlIlIlIIIllIII = lIlIlIlIIIlIIII.getBlockState(lIlIlIlIIIIllll);
        if (lIlIlIlIIIlIIII.getBlockState(lIlIlIlIIIIllll).getBlock() == this) {
            lIlIlIlIIIllIIl = (EnumFacing.Axis)lIlIlIlIIIllIII.getValue(BlockPortal.field_176550_a);
            if (lIlIlIlIIIllIIl == null) {
                return false;
            }
            if (lIlIlIlIIIllIIl == EnumFacing.Axis.Z && lIlIlIlIIIIlllI != EnumFacing.EAST && lIlIlIlIIIIlllI != EnumFacing.WEST) {
                return false;
            }
            if (lIlIlIlIIIllIIl == EnumFacing.Axis.X && lIlIlIlIIIIlllI != EnumFacing.SOUTH && lIlIlIlIIIIlllI != EnumFacing.NORTH) {
                return false;
            }
        }
        final boolean lIlIlIlIIIlIlll = lIlIlIlIIIlIIII.getBlockState(lIlIlIlIIIIllll.offsetWest()).getBlock() == this && lIlIlIlIIIlIIII.getBlockState(lIlIlIlIIIIllll.offsetWest(2)).getBlock() != this;
        final boolean lIlIlIlIIIlIllI = lIlIlIlIIIlIIII.getBlockState(lIlIlIlIIIIllll.offsetEast()).getBlock() == this && lIlIlIlIIIlIIII.getBlockState(lIlIlIlIIIIllll.offsetEast(2)).getBlock() != this;
        final boolean lIlIlIlIIIlIlIl = lIlIlIlIIIlIIII.getBlockState(lIlIlIlIIIIllll.offsetNorth()).getBlock() == this && lIlIlIlIIIlIIII.getBlockState(lIlIlIlIIIIllll.offsetNorth(2)).getBlock() != this;
        final boolean lIlIlIlIIIlIlII = lIlIlIlIIIlIIII.getBlockState(lIlIlIlIIIIllll.offsetSouth()).getBlock() == this && lIlIlIlIIIlIIII.getBlockState(lIlIlIlIIIIllll.offsetSouth(2)).getBlock() != this;
        final boolean lIlIlIlIIIlIIll = lIlIlIlIIIlIlll || lIlIlIlIIIlIllI || lIlIlIlIIIllIIl == EnumFacing.Axis.X;
        final boolean lIlIlIlIIIlIIlI = lIlIlIlIIIlIlIl || lIlIlIlIIIlIlII || lIlIlIlIIIllIIl == EnumFacing.Axis.Z;
        return (lIlIlIlIIIlIIll && lIlIlIlIIIIlllI == EnumFacing.WEST) || (lIlIlIlIIIlIIll && lIlIlIlIIIIlllI == EnumFacing.EAST) || (lIlIlIlIIIlIIlI && lIlIlIlIIIIlllI == EnumFacing.NORTH) || (lIlIlIlIIIlIIlI && lIlIlIlIIIIlllI == EnumFacing.SOUTH);
    }
    
    @Override
    public void randomDisplayTick(final World lIlIlIIlllIIIII, final BlockPos lIlIlIIlllIllIl, final IBlockState lIlIlIIlllIllII, final Random lIlIlIIllIlllIl) {
        if (lIlIlIIllIlllIl.nextInt(100) == 0) {
            lIlIlIIlllIIIII.playSound(lIlIlIIlllIllIl.getX() + 0.5, lIlIlIIlllIllIl.getY() + 0.5, lIlIlIIlllIllIl.getZ() + 0.5, "portal.portal", 0.5f, lIlIlIIllIlllIl.nextFloat() * 0.4f + 0.8f, false);
        }
        for (int lIlIlIIlllIlIlI = 0; lIlIlIIlllIlIlI < 4; ++lIlIlIIlllIlIlI) {
            double lIlIlIIlllIlIIl = lIlIlIIlllIllIl.getX() + lIlIlIIllIlllIl.nextFloat();
            final double lIlIlIIlllIlIII = lIlIlIIlllIllIl.getY() + lIlIlIIllIlllIl.nextFloat();
            double lIlIlIIlllIIlll = lIlIlIIlllIllIl.getZ() + lIlIlIIllIlllIl.nextFloat();
            double lIlIlIIlllIIllI = (lIlIlIIllIlllIl.nextFloat() - 0.5) * 0.5;
            final double lIlIlIIlllIIlIl = (lIlIlIIllIlllIl.nextFloat() - 0.5) * 0.5;
            double lIlIlIIlllIIlII = (lIlIlIIllIlllIl.nextFloat() - 0.5) * 0.5;
            final int lIlIlIIlllIIIll = lIlIlIIllIlllIl.nextInt(2) * 2 - 1;
            if (lIlIlIIlllIIIII.getBlockState(lIlIlIIlllIllIl.offsetWest()).getBlock() != this && lIlIlIIlllIIIII.getBlockState(lIlIlIIlllIllIl.offsetEast()).getBlock() != this) {
                lIlIlIIlllIlIIl = lIlIlIIlllIllIl.getX() + 0.5 + 0.25 * lIlIlIIlllIIIll;
                lIlIlIIlllIIllI = lIlIlIIllIlllIl.nextFloat() * 2.0f * lIlIlIIlllIIIll;
            }
            else {
                lIlIlIIlllIIlll = lIlIlIIlllIllIl.getZ() + 0.5 + 0.25 * lIlIlIIlllIIIll;
                lIlIlIIlllIIlII = lIlIlIIllIlllIl.nextFloat() * 2.0f * lIlIlIIlllIIIll;
            }
            lIlIlIIlllIIIII.spawnParticle(EnumParticleTypes.PORTAL, lIlIlIIlllIlIIl, lIlIlIIlllIlIII, lIlIlIIlllIIlll, lIlIlIIlllIIllI, lIlIlIIlllIIlIl, lIlIlIIlllIIlII, new int[0]);
        }
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public int quantityDropped(final Random lIlIlIlIIIIIlII) {
        return 0;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lIlIlIlIIIIIIII, final BlockPos lIlIlIIllllllll, final IBlockState lIlIlIIlllllllI, final Entity lIlIlIIllllllIl) {
        if (lIlIlIIllllllIl.ridingEntity == null && lIlIlIIllllllIl.riddenByEntity == null) {
            lIlIlIIllllllIl.setInPortal();
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lIlIlIIllIIlIll) {
        return func_176549_a((EnumFacing.Axis)lIlIlIIllIIlIll.getValue(BlockPortal.field_176550_a));
    }
    
    public boolean func_176548_d(final World lIlIlIlIlIIIIll, final BlockPos lIlIlIlIlIIIIlI) {
        final Size lIlIlIlIlIIIIIl = new Size(lIlIlIlIlIIIIll, lIlIlIlIlIIIIlI, EnumFacing.Axis.X);
        if (lIlIlIlIlIIIIIl.func_150860_b() && lIlIlIlIlIIIIIl.field_150864_e == 0) {
            lIlIlIlIlIIIIIl.func_150859_c();
            return true;
        }
        final Size lIlIlIlIlIIIIII = new Size(lIlIlIlIlIIIIll, lIlIlIlIlIIIIlI, EnumFacing.Axis.Z);
        if (lIlIlIlIlIIIIII.func_150860_b() && lIlIlIlIlIIIIII.field_150864_e == 0) {
            lIlIlIlIlIIIIII.func_150859_c();
            return true;
        }
        return false;
    }
    
    @Override
    public void updateTick(final World lIlIlIlIllIlIIl, final BlockPos lIlIlIlIllIlIII, final IBlockState lIlIlIlIllIllll, final Random lIlIlIlIllIlllI) {
        super.updateTick(lIlIlIlIllIlIIl, lIlIlIlIllIlIII, lIlIlIlIllIllll, lIlIlIlIllIlllI);
        if (lIlIlIlIllIlIIl.provider.isSurfaceWorld() && lIlIlIlIllIlIIl.getGameRules().getGameRuleBooleanValue("doMobSpawning") && lIlIlIlIllIlllI.nextInt(2000) < lIlIlIlIllIlIIl.getDifficulty().getDifficultyId()) {
            final int lIlIlIlIllIllIl = lIlIlIlIllIlIII.getY();
            BlockPos lIlIlIlIllIllII;
            for (lIlIlIlIllIllII = lIlIlIlIllIlIII; !World.doesBlockHaveSolidTopSurface(lIlIlIlIllIlIIl, lIlIlIlIllIllII) && lIlIlIlIllIllII.getY() > 0; lIlIlIlIllIllII = lIlIlIlIllIllII.offsetDown()) {}
            if (lIlIlIlIllIllIl > 0 && !lIlIlIlIllIlIIl.getBlockState(lIlIlIlIllIllII.offsetUp()).getBlock().isNormalCube()) {
                final Entity lIlIlIlIllIlIll = ItemMonsterPlacer.spawnCreature(lIlIlIlIllIlIIl, 57, lIlIlIlIllIllII.getX() + 0.5, lIlIlIlIllIllII.getY() + 1.1, lIlIlIlIllIllII.getZ() + 0.5);
                if (lIlIlIlIllIlIll != null) {
                    lIlIlIlIllIlIll.timeUntilPortal = lIlIlIlIllIlIll.getPortalCooldown();
                }
            }
        }
    }
    
    @Override
    public void onNeighborBlockChange(final World lIlIlIlIIlIlllI, final BlockPos lIlIlIlIIlIllIl, final IBlockState lIlIlIlIIllIIll, final Block lIlIlIlIIllIIlI) {
        final EnumFacing.Axis lIlIlIlIIllIIIl = (EnumFacing.Axis)lIlIlIlIIllIIll.getValue(BlockPortal.field_176550_a);
        if (lIlIlIlIIllIIIl == EnumFacing.Axis.X) {
            final Size lIlIlIlIIllIIII = new Size(lIlIlIlIIlIlllI, lIlIlIlIIlIllIl, EnumFacing.Axis.X);
            if (!lIlIlIlIIllIIII.func_150860_b() || lIlIlIlIIllIIII.field_150864_e < lIlIlIlIIllIIII.field_150868_h * lIlIlIlIIllIIII.field_150862_g) {
                lIlIlIlIIlIlllI.setBlockState(lIlIlIlIIlIllIl, Blocks.air.getDefaultState());
            }
        }
        else if (lIlIlIlIIllIIIl == EnumFacing.Axis.Z) {
            final Size lIlIlIlIIlIllll = new Size(lIlIlIlIIlIlllI, lIlIlIlIIlIllIl, EnumFacing.Axis.Z);
            if (!lIlIlIlIIlIllll.func_150860_b() || lIlIlIlIIlIllll.field_150864_e < lIlIlIlIIlIllll.field_150868_h * lIlIlIlIIlIllll.field_150862_g) {
                lIlIlIlIIlIlllI.setBlockState(lIlIlIlIIlIllIl, Blocks.air.getDefaultState());
            }
        }
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lIlIlIlIlIlIIIl, final BlockPos lIlIlIlIlIlIllI) {
        final EnumFacing.Axis lIlIlIlIlIlIlIl = (EnumFacing.Axis)lIlIlIlIlIlIIIl.getBlockState(lIlIlIlIlIlIllI).getValue(BlockPortal.field_176550_a);
        float lIlIlIlIlIlIlII = 0.125f;
        float lIlIlIlIlIlIIll = 0.125f;
        if (lIlIlIlIlIlIlIl == EnumFacing.Axis.X) {
            lIlIlIlIlIlIlII = 0.5f;
        }
        if (lIlIlIlIlIlIlIl == EnumFacing.Axis.Z) {
            lIlIlIlIlIlIIll = 0.5f;
        }
        this.setBlockBounds(0.5f - lIlIlIlIlIlIlII, 0.0f, 0.5f - lIlIlIlIlIlIIll, 0.5f + lIlIlIlIlIlIlII, 1.0f, 0.5f + lIlIlIlIlIlIIll);
    }
    
    static {
        __OBFID = "CL_00000284";
        field_176550_a = PropertyEnum.create("axis", EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lIlIlIlIllIIIIl, final BlockPos lIlIlIlIllIIIII, final IBlockState lIlIlIlIlIlllll) {
        return null;
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
    
    @Override
    public Item getItem(final World lIlIlIIllIlIlIl, final BlockPos lIlIlIIllIlIlII) {
        return null;
    }
    
    public static class Size
    {
        private final /* synthetic */ EnumFacing field_150866_c;
        private final /* synthetic */ EnumFacing field_150863_d;
        private /* synthetic */ int field_150868_h;
        private /* synthetic */ int field_150864_e;
        private final /* synthetic */ EnumFacing.Axis field_150865_b;
        private final /* synthetic */ World field_150867_a;
        private /* synthetic */ int field_150862_g;
        private /* synthetic */ BlockPos field_150861_f;
        
        static {
            __OBFID = "CL_00000285";
        }
        
        protected int func_150858_a() {
            this.field_150862_g = 0;
        Label_0181:
            while (this.field_150862_g < 21) {
                for (int llllllllllllllIIlIlIllllIIllIIIl = 0; llllllllllllllIIlIlIllllIIllIIIl < this.field_150868_h; ++llllllllllllllIIlIlIllllIIllIIIl) {
                    final BlockPos llllllllllllllIIlIlIllllIIlIllll = this.field_150861_f.offset(this.field_150866_c, llllllllllllllIIlIlIllllIIllIIIl).offsetUp(this.field_150862_g);
                    Block llllllllllllllIIlIlIllllIIlIlllI = this.field_150867_a.getBlockState(llllllllllllllIIlIlIllllIIlIllll).getBlock();
                    if (!this.func_150857_a(llllllllllllllIIlIlIllllIIlIlllI)) {
                        break Label_0181;
                    }
                    if (llllllllllllllIIlIlIllllIIlIlllI == Blocks.portal) {
                        ++this.field_150864_e;
                    }
                    if (llllllllllllllIIlIlIllllIIllIIIl == 0) {
                        llllllllllllllIIlIlIllllIIlIlllI = this.field_150867_a.getBlockState(llllllllllllllIIlIlIllllIIlIllll.offset(this.field_150863_d)).getBlock();
                        if (llllllllllllllIIlIlIllllIIlIlllI != Blocks.obsidian) {
                            break Label_0181;
                        }
                    }
                    else if (llllllllllllllIIlIlIllllIIllIIIl == this.field_150868_h - 1) {
                        llllllllllllllIIlIlIllllIIlIlllI = this.field_150867_a.getBlockState(llllllllllllllIIlIlIllllIIlIllll.offset(this.field_150866_c)).getBlock();
                        if (llllllllllllllIIlIlIllllIIlIlllI != Blocks.obsidian) {
                            break Label_0181;
                        }
                    }
                }
                ++this.field_150862_g;
            }
            for (int llllllllllllllIIlIlIllllIIllIIII = 0; llllllllllllllIIlIlIllllIIllIIII < this.field_150868_h; ++llllllllllllllIIlIlIllllIIllIIII) {
                if (this.field_150867_a.getBlockState(this.field_150861_f.offset(this.field_150866_c, llllllllllllllIIlIlIllllIIllIIII).offsetUp(this.field_150862_g)).getBlock() != Blocks.obsidian) {
                    this.field_150862_g = 0;
                    break;
                }
            }
            if (this.field_150862_g <= 21 && this.field_150862_g >= 3) {
                return this.field_150862_g;
            }
            this.field_150861_f = null;
            this.field_150868_h = 0;
            this.field_150862_g = 0;
            return 0;
        }
        
        protected int func_180120_a(final BlockPos llllllllllllllIIlIlIllllIIlllIlI, final EnumFacing llllllllllllllIIlIlIllllIIlllIIl) {
            int llllllllllllllIIlIlIllllIIlllllI;
            for (llllllllllllllIIlIlIllllIIlllllI = 0; llllllllllllllIIlIlIllllIIlllllI < 22; ++llllllllllllllIIlIlIllllIIlllllI) {
                final BlockPos llllllllllllllIIlIlIllllIIllllIl = llllllllllllllIIlIlIllllIIlllIlI.offset(llllllllllllllIIlIlIllllIIlllIIl, llllllllllllllIIlIlIllllIIlllllI);
                if (!this.func_150857_a(this.field_150867_a.getBlockState(llllllllllllllIIlIlIllllIIllllIl).getBlock())) {
                    break;
                }
                if (this.field_150867_a.getBlockState(llllllllllllllIIlIlIllllIIllllIl.offsetDown()).getBlock() != Blocks.obsidian) {
                    break;
                }
            }
            final Block llllllllllllllIIlIlIllllIIllllII = this.field_150867_a.getBlockState(llllllllllllllIIlIlIllllIIlllIlI.offset(llllllllllllllIIlIlIllllIIlllIIl, llllllllllllllIIlIlIllllIIlllllI)).getBlock();
            return (llllllllllllllIIlIlIllllIIllllII == Blocks.obsidian) ? llllllllllllllIIlIlIllllIIlllllI : 0;
        }
        
        protected boolean func_150857_a(final Block llllllllllllllIIlIlIllllIIlIIlll) {
            return llllllllllllllIIlIlIllllIIlIIlll.blockMaterial == Material.air || llllllllllllllIIlIlIllllIIlIIlll == Blocks.fire || llllllllllllllIIlIlIllllIIlIIlll == Blocks.portal;
        }
        
        public Size(final World llllllllllllllIIlIlIllllIlIIlIlI, BlockPos llllllllllllllIIlIlIllllIlIIlIIl, final EnumFacing.Axis llllllllllllllIIlIlIllllIlIIlllI) {
            this.field_150864_e = 0;
            this.field_150867_a = llllllllllllllIIlIlIllllIlIIlIlI;
            this.field_150865_b = llllllllllllllIIlIlIllllIlIIlllI;
            if (llllllllllllllIIlIlIllllIlIIlllI == EnumFacing.Axis.X) {
                this.field_150863_d = EnumFacing.EAST;
                this.field_150866_c = EnumFacing.WEST;
            }
            else {
                this.field_150863_d = EnumFacing.NORTH;
                this.field_150866_c = EnumFacing.SOUTH;
            }
            for (BlockPos llllllllllllllIIlIlIllllIlIIllIl = llllllllllllllIIlIlIllllIlIIlIIl; llllllllllllllIIlIlIllllIlIIlIIl.getY() > llllllllllllllIIlIlIllllIlIIllIl.getY() - 21 && llllllllllllllIIlIlIllllIlIIlIIl.getY() > 0 && this.func_150857_a(llllllllllllllIIlIlIllllIlIIlIlI.getBlockState(llllllllllllllIIlIlIllllIlIIlIIl.offsetDown()).getBlock()); llllllllllllllIIlIlIllllIlIIlIIl = llllllllllllllIIlIlIllllIlIIlIIl.offsetDown()) {}
            final int llllllllllllllIIlIlIllllIlIIllII = this.func_180120_a(llllllllllllllIIlIlIllllIlIIlIIl, this.field_150863_d) - 1;
            if (llllllllllllllIIlIlIllllIlIIllII >= 0) {
                this.field_150861_f = llllllllllllllIIlIlIllllIlIIlIIl.offset(this.field_150863_d, llllllllllllllIIlIlIllllIlIIllII);
                this.field_150868_h = this.func_180120_a(this.field_150861_f, this.field_150866_c);
                if (this.field_150868_h < 2 || this.field_150868_h > 21) {
                    this.field_150861_f = null;
                    this.field_150868_h = 0;
                }
            }
            if (this.field_150861_f != null) {
                this.field_150862_g = this.func_150858_a();
            }
        }
        
        public void func_150859_c() {
            for (int llllllllllllllIIlIlIllllIIIlllIl = 0; llllllllllllllIIlIlIllllIIIlllIl < this.field_150868_h; ++llllllllllllllIIlIlIllllIIIlllIl) {
                final BlockPos llllllllllllllIIlIlIllllIIIlllII = this.field_150861_f.offset(this.field_150866_c, llllllllllllllIIlIlIllllIIIlllIl);
                for (int llllllllllllllIIlIlIllllIIIllIll = 0; llllllllllllllIIlIlIllllIIIllIll < this.field_150862_g; ++llllllllllllllIIlIlIllllIIIllIll) {
                    this.field_150867_a.setBlockState(llllllllllllllIIlIlIllllIIIlllII.offsetUp(llllllllllllllIIlIlIllllIIIllIll), Blocks.portal.getDefaultState().withProperty(BlockPortal.field_176550_a, this.field_150865_b), 2);
                }
            }
        }
        
        public boolean func_150860_b() {
            return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
        }
    }
}
