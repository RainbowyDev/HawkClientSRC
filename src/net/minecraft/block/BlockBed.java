package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.util.*;

public class BlockBed extends BlockDirectional
{
    public static final /* synthetic */ PropertyEnum PART_PROP;
    public static final /* synthetic */ PropertyBool OCCUPIED_PROP;
    
    @Override
    public int getMobilityFlag() {
        return 1;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllIlIllllllllllIIIl, final BlockPos lllllllllllllllIlIllllllllllIIII) {
        this.setBedBounds();
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockBed.AGE, BlockBed.PART_PROP, BlockBed.OCCUPIED_PROP });
    }
    
    @Override
    public Item getItem(final World lllllllllllllllIlIlllllllIIIllll, final BlockPos lllllllllllllllIlIlllllllIIIlllI) {
        return Items.bed;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIllIIIIIIIIIlIIll, BlockPos lllllllllllllllIllIIIIIIIIIIIllI, IBlockState lllllllllllllllIllIIIIIIIIIIIlIl, final EntityPlayer lllllllllllllllIllIIIIIIIIIIIlII, final EnumFacing lllllllllllllllIllIIIIIIIIIIllll, final float lllllllllllllllIllIIIIIIIIIIlllI, final float lllllllllllllllIllIIIIIIIIIIllIl, final float lllllllllllllllIllIIIIIIIIIIllII) {
        if (lllllllllllllllIllIIIIIIIIIlIIll.isRemote) {
            return true;
        }
        if (lllllllllllllllIllIIIIIIIIIIIlIl.getValue(BlockBed.PART_PROP) != EnumPartType.HEAD) {
            lllllllllllllllIllIIIIIIIIIIIllI = (Comparable<Float>)((BlockPos)lllllllllllllllIllIIIIIIIIIIIllI).offset((EnumFacing)lllllllllllllllIllIIIIIIIIIIIlIl.getValue(BlockBed.AGE));
            lllllllllllllllIllIIIIIIIIIIIlIl = lllllllllllllllIllIIIIIIIIIlIIll.getBlockState((BlockPos)lllllllllllllllIllIIIIIIIIIIIllI);
            if (lllllllllllllllIllIIIIIIIIIIIlIl.getBlock() != this) {
                return true;
            }
        }
        if (!lllllllllllllllIllIIIIIIIIIlIIll.provider.canRespawnHere() || lllllllllllllllIllIIIIIIIIIlIIll.getBiomeGenForCoords((BlockPos)lllllllllllllllIllIIIIIIIIIIIllI) == BiomeGenBase.hell) {
            lllllllllllllllIllIIIIIIIIIlIIll.setBlockToAir((BlockPos)lllllllllllllllIllIIIIIIIIIIIllI);
            final BlockPos lllllllllllllllIllIIIIIIIIIIlIIl = ((BlockPos)lllllllllllllllIllIIIIIIIIIIIllI).offset(((EnumFacing)lllllllllllllllIllIIIIIIIIIIIlIl.getValue(BlockBed.AGE)).getOpposite());
            if (lllllllllllllllIllIIIIIIIIIlIIll.getBlockState(lllllllllllllllIllIIIIIIIIIIlIIl).getBlock() == this) {
                lllllllllllllllIllIIIIIIIIIlIIll.setBlockToAir(lllllllllllllllIllIIIIIIIIIIlIIl);
            }
            lllllllllllllllIllIIIIIIIIIlIIll.newExplosion(null, ((Vec3i)lllllllllllllllIllIIIIIIIIIIIllI).getX() + 0.5, ((Vec3i)lllllllllllllllIllIIIIIIIIIIIllI).getY() + 0.5, ((Vec3i)lllllllllllllllIllIIIIIIIIIIIllI).getZ() + 0.5, 5.0f, true, true);
            return true;
        }
        if (lllllllllllllllIllIIIIIIIIIIIlIl.getValue(BlockBed.OCCUPIED_PROP)) {
            final EntityPlayer lllllllllllllllIllIIIIIIIIIIlIll = this.func_176470_e(lllllllllllllllIllIIIIIIIIIlIIll, (BlockPos)lllllllllllllllIllIIIIIIIIIIIllI);
            if (lllllllllllllllIllIIIIIIIIIIlIll != null) {
                lllllllllllllllIllIIIIIIIIIIIlII.addChatComponentMessage(new ChatComponentTranslation("tile.bed.occupied", new Object[0]));
                return true;
            }
            lllllllllllllllIllIIIIIIIIIIIlIl = lllllllllllllllIllIIIIIIIIIIIlIl.withProperty(BlockBed.OCCUPIED_PROP, false);
            lllllllllllllllIllIIIIIIIIIlIIll.setBlockState((BlockPos)lllllllllllllllIllIIIIIIIIIIIllI, lllllllllllllllIllIIIIIIIIIIIlIl, 4);
        }
        final EntityPlayer.EnumStatus lllllllllllllllIllIIIIIIIIIIlIlI = lllllllllllllllIllIIIIIIIIIIIlII.func_180469_a((BlockPos)lllllllllllllllIllIIIIIIIIIIIllI);
        if (lllllllllllllllIllIIIIIIIIIIlIlI == EntityPlayer.EnumStatus.OK) {
            lllllllllllllllIllIIIIIIIIIIIlIl = lllllllllllllllIllIIIIIIIIIIIlIl.withProperty(BlockBed.OCCUPIED_PROP, true);
            lllllllllllllllIllIIIIIIIIIlIIll.setBlockState((BlockPos)lllllllllllllllIllIIIIIIIIIIIllI, lllllllllllllllIllIIIIIIIIIIIlIl, 4);
            return true;
        }
        if (lllllllllllllllIllIIIIIIIIIIlIlI == EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW) {
            lllllllllllllllIllIIIIIIIIIIIlII.addChatComponentMessage(new ChatComponentTranslation("tile.bed.noSleep", new Object[0]));
        }
        else if (lllllllllllllllIllIIIIIIIIIIlIlI == EntityPlayer.EnumStatus.NOT_SAFE) {
            lllllllllllllllIllIIIIIIIIIIIlII.addChatComponentMessage(new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
        }
        return true;
    }
    
    protected static boolean func_176469_d(final World lllllllllllllllIlIlllllllIlIIllI, final BlockPos lllllllllllllllIlIlllllllIlIIIll) {
        return World.doesBlockHaveSolidTopSurface(lllllllllllllllIlIlllllllIlIIllI, lllllllllllllllIlIlllllllIlIIIll.offsetDown()) && !lllllllllllllllIlIlllllllIlIIllI.getBlockState(lllllllllllllllIlIlllllllIlIIIll).getBlock().getMaterial().isSolid() && !lllllllllllllllIlIlllllllIlIIllI.getBlockState(lllllllllllllllIlIlllllllIlIIIll.offsetUp()).getBlock().getMaterial().isSolid();
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllllIlIllllllIllIIlll, final IBlockAccess lllllllllllllllIlIllllllIllIlIll, final BlockPos lllllllllllllllIlIllllllIllIIlIl) {
        if (((IBlockState)lllllllllllllllIlIllllllIllIIlll).getValue(BlockBed.PART_PROP) == EnumPartType.FOOT) {
            final IBlockState lllllllllllllllIlIllllllIllIlIIl = lllllllllllllllIlIllllllIllIlIll.getBlockState(lllllllllllllllIlIllllllIllIIlIl.offset((EnumFacing)((IBlockState)lllllllllllllllIlIllllllIllIIlll).getValue(BlockBed.AGE)));
            if (lllllllllllllllIlIllllllIllIlIIl.getBlock() == this) {
                lllllllllllllllIlIllllllIllIIlll = ((IBlockState)lllllllllllllllIlIllllllIllIIlll).withProperty(BlockBed.OCCUPIED_PROP, lllllllllllllllIlIllllllIllIlIIl.getValue(BlockBed.OCCUPIED_PROP));
            }
        }
        return (IBlockState)lllllllllllllllIlIllllllIllIIlll;
    }
    
    public static BlockPos getSafeExitLocation(final World lllllllllllllllIlIlllllllIllIlll, final BlockPos lllllllllllllllIlIlllllllIllIllI, int lllllllllllllllIlIlllllllIllIlIl) {
        final EnumFacing lllllllllllllllIlIllllllllIIIIll = (EnumFacing)lllllllllllllllIlIlllllllIllIlll.getBlockState(lllllllllllllllIlIlllllllIllIllI).getValue(BlockBed.AGE);
        final int lllllllllllllllIlIllllllllIIIIlI = lllllllllllllllIlIlllllllIllIllI.getX();
        final int lllllllllllllllIlIllllllllIIIIIl = lllllllllllllllIlIlllllllIllIllI.getY();
        final int lllllllllllllllIlIllllllllIIIIII = lllllllllllllllIlIlllllllIllIllI.getZ();
        for (int lllllllllllllllIlIlllllllIllllll = 0; lllllllllllllllIlIlllllllIllllll <= 1; ++lllllllllllllllIlIlllllllIllllll) {
            final int lllllllllllllllIlIlllllllIlllllI = lllllllllllllllIlIllllllllIIIIlI - lllllllllllllllIlIllllllllIIIIll.getFrontOffsetX() * lllllllllllllllIlIlllllllIllllll - 1;
            final int lllllllllllllllIlIlllllllIllllIl = lllllllllllllllIlIllllllllIIIIII - lllllllllllllllIlIllllllllIIIIll.getFrontOffsetZ() * lllllllllllllllIlIlllllllIllllll - 1;
            final int lllllllllllllllIlIlllllllIllllII = lllllllllllllllIlIlllllllIlllllI + 2;
            final int lllllllllllllllIlIlllllllIlllIll = lllllllllllllllIlIlllllllIllllIl + 2;
            for (int lllllllllllllllIlIlllllllIlllIlI = lllllllllllllllIlIlllllllIlllllI; lllllllllllllllIlIlllllllIlllIlI <= lllllllllllllllIlIlllllllIllllII; ++lllllllllllllllIlIlllllllIlllIlI) {
                for (int lllllllllllllllIlIlllllllIlllIIl = lllllllllllllllIlIlllllllIllllIl; lllllllllllllllIlIlllllllIlllIIl <= lllllllllllllllIlIlllllllIlllIll; ++lllllllllllllllIlIlllllllIlllIIl) {
                    final BlockPos lllllllllllllllIlIlllllllIlllIII = new BlockPos(lllllllllllllllIlIlllllllIlllIlI, lllllllllllllllIlIllllllllIIIIIl, lllllllllllllllIlIlllllllIlllIIl);
                    if (func_176469_d(lllllllllllllllIlIlllllllIllIlll, lllllllllllllllIlIlllllllIlllIII)) {
                        if (lllllllllllllllIlIlllllllIllIlIl <= 0) {
                            return lllllllllllllllIlIlllllllIlllIII;
                        }
                        --lllllllllllllllIlIlllllllIllIlIl;
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllllIlIlllllllIIIIIII, final BlockPos lllllllllllllllIlIllllllIlllllll, final IBlockState lllllllllllllllIlIllllllIllllllI, final EntityPlayer lllllllllllllllIlIlllllllIIIIIll) {
        if (lllllllllllllllIlIlllllllIIIIIll.capabilities.isCreativeMode && lllllllllllllllIlIllllllIllllllI.getValue(BlockBed.PART_PROP) == EnumPartType.HEAD) {
            final BlockPos lllllllllllllllIlIlllllllIIIIIlI = lllllllllllllllIlIllllllIlllllll.offset(((EnumFacing)lllllllllllllllIlIllllllIllllllI.getValue(BlockBed.AGE)).getOpposite());
            if (lllllllllllllllIlIlllllllIIIIIII.getBlockState(lllllllllllllllIlIlllllllIIIIIlI).getBlock() == this) {
                lllllllllllllllIlIlllllllIIIIIII.setBlockToAir(lllllllllllllllIlIlllllllIIIIIlI);
            }
        }
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllllIlIlllllllIIlIllI, final BlockPos lllllllllllllllIlIlllllllIIlIlIl, final IBlockState lllllllllllllllIlIlllllllIIlIlII, final float lllllllllllllllIlIlllllllIIllIIl, final int lllllllllllllllIlIlllllllIIllIII) {
        if (lllllllllllllllIlIlllllllIIlIlII.getValue(BlockBed.PART_PROP) == EnumPartType.FOOT) {
            super.dropBlockAsItemWithChance(lllllllllllllllIlIlllllllIIlIllI, lllllllllllllllIlIlllllllIIlIlIl, lllllllllllllllIlIlllllllIIlIlII, lllllllllllllllIlIlllllllIIllIIl, 0);
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlIllllllIlllIlII) {
        final EnumFacing lllllllllllllllIlIllllllIlllIllI = EnumFacing.getHorizontal(lllllllllllllllIlIllllllIlllIlII);
        return ((lllllllllllllllIlIllllllIlllIlII & 0x8) > 0) ? this.getDefaultState().withProperty(BlockBed.PART_PROP, EnumPartType.HEAD).withProperty(BlockBed.AGE, lllllllllllllllIlIllllllIlllIllI).withProperty(BlockBed.OCCUPIED_PROP, (lllllllllllllllIlIllllllIlllIlII & 0x4) > 0) : this.getDefaultState().withProperty(BlockBed.PART_PROP, EnumPartType.FOOT).withProperty(BlockBed.AGE, lllllllllllllllIlIllllllIlllIllI);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlIllllllllIllIIl, final Random lllllllllllllllIlIllllllllIllIll, final int lllllllllllllllIlIllllllllIllIlI) {
        return (lllllllllllllllIlIllllllllIllIIl.getValue(BlockBed.PART_PROP) == EnumPartType.HEAD) ? null : Items.bed;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    public BlockBed() {
        super(Material.cloth);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockBed.PART_PROP, EnumPartType.FOOT).withProperty(BlockBed.OCCUPIED_PROP, false));
        this.setBedBounds();
    }
    
    static {
        __OBFID = "CL_00000198";
        PART_PROP = PropertyEnum.create("part", EnumPartType.class);
        OCCUPIED_PROP = PropertyBool.create("occupied");
    }
    
    private void setBedBounds() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5625f, 1.0f);
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllIlIlllllllllIlIII, final BlockPos lllllllllllllllIlIlllllllllIIIIl, final IBlockState lllllllllllllllIlIlllllllllIIllI, final Block lllllllllllllllIlIlllllllllIIlIl) {
        final EnumFacing lllllllllllllllIlIlllllllllIIlII = (EnumFacing)lllllllllllllllIlIlllllllllIIllI.getValue(BlockBed.AGE);
        if (lllllllllllllllIlIlllllllllIIllI.getValue(BlockBed.PART_PROP) == EnumPartType.HEAD) {
            if (lllllllllllllllIlIlllllllllIlIII.getBlockState(lllllllllllllllIlIlllllllllIIIIl.offset(lllllllllllllllIlIlllllllllIIlII.getOpposite())).getBlock() != this) {
                lllllllllllllllIlIlllllllllIlIII.setBlockToAir(lllllllllllllllIlIlllllllllIIIIl);
            }
        }
        else if (lllllllllllllllIlIlllllllllIlIII.getBlockState(lllllllllllllllIlIlllllllllIIIIl.offset(lllllllllllllllIlIlllllllllIIlII)).getBlock() != this) {
            lllllllllllllllIlIlllllllllIlIII.setBlockToAir(lllllllllllllllIlIlllllllllIIIIl);
            if (!lllllllllllllllIlIlllllllllIlIII.isRemote) {
                this.dropBlockAsItem(lllllllllllllllIlIlllllllllIlIII, lllllllllllllllIlIlllllllllIIIIl, lllllllllllllllIlIlllllllllIIllI, 0);
            }
        }
    }
    
    private EntityPlayer func_176470_e(final World lllllllllllllllIlIllllllllllllIl, final BlockPos lllllllllllllllIlIlllllllllllIII) {
        for (final EntityPlayer lllllllllllllllIlIlllllllllllIlI : lllllllllllllllIlIllllllllllllIl.playerEntities) {
            if (lllllllllllllllIlIlllllllllllIlI.isPlayerSleeping() && lllllllllllllllIlIlllllllllllIlI.playerLocation.equals(lllllllllllllllIlIlllllllllllIII)) {
                return lllllllllllllllIlIlllllllllllIlI;
            }
        }
        return null;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlIllllllIlIlllll) {
        final byte lllllllllllllllIlIllllllIlIllllI = 0;
        int lllllllllllllllIlIllllllIlIlllIl = lllllllllllllllIlIllllllIlIllllI | ((EnumFacing)lllllllllllllllIlIllllllIlIlllll.getValue(BlockBed.AGE)).getHorizontalIndex();
        if (lllllllllllllllIlIllllllIlIlllll.getValue(BlockBed.PART_PROP) == EnumPartType.HEAD) {
            lllllllllllllllIlIllllllIlIlllIl |= 0x8;
            if (lllllllllllllllIlIllllllIlIlllll.getValue(BlockBed.OCCUPIED_PROP)) {
                lllllllllllllllIlIllllllIlIlllIl |= 0x4;
            }
        }
        return lllllllllllllllIlIllllllIlIlllIl;
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    public enum EnumPartType implements IStringSerializable
    {
        private final /* synthetic */ String field_177036_c;
        
        FOOT("FOOT", 1, "FOOT", 1, "foot"), 
        HEAD("HEAD", 0, "HEAD", 0, "head");
        
        @Override
        public String toString() {
            return this.field_177036_c;
        }
        
        @Override
        public String getName() {
            return this.field_177036_c;
        }
        
        static {
            __OBFID = "CL_00002134";
        }
        
        private EnumPartType(final String llllllllllllllIllIIIIIlIllIlIlIl, final int llllllllllllllIllIIIIIlIllIlIlII, final String llllllllllllllIllIIIIIlIllIllIIl, final int llllllllllllllIllIIIIIlIllIllIII, final String llllllllllllllIllIIIIIlIllIlIlll) {
            this.field_177036_c = llllllllllllllIllIIIIIlIllIlIlll;
        }
    }
}
