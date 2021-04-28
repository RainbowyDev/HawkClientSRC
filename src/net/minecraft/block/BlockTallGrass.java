package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockTallGrass extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyEnum field_176497_a;
    
    @Override
    public boolean isReplaceable(final World lllllllllllllllllIIlIlIlIlIlllII, final BlockPos lllllllllllllllllIIlIlIlIlIllIll) {
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIIlIlIIllllIIlI) {
        return ((EnumType)lllllllllllllllllIIlIlIIllllIIlI.getValue(BlockTallGrass.field_176497_a)).func_177044_a();
    }
    
    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XYZ;
    }
    
    @Override
    public void harvestBlock(final World lllllllllllllllllIIlIlIlIIlIllll, final EntityPlayer lllllllllllllllllIIlIlIlIIlIlllI, final BlockPos lllllllllllllllllIIlIlIlIIllIIll, final IBlockState lllllllllllllllllIIlIlIlIIllIIlI, final TileEntity lllllllllllllllllIIlIlIlIIlIlIll) {
        if (!lllllllllllllllllIIlIlIlIIlIllll.isRemote && lllllllllllllllllIIlIlIlIIlIlllI.getCurrentEquippedItem() != null && lllllllllllllllllIIlIlIlIIlIlllI.getCurrentEquippedItem().getItem() == Items.shears) {
            lllllllllllllllllIIlIlIlIIlIlllI.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
            Block.spawnAsEntity(lllllllllllllllllIIlIlIlIIlIllll, lllllllllllllllllIIlIlIlIIllIIll, new ItemStack(Blocks.tallgrass, 1, ((EnumType)lllllllllllllllllIIlIlIlIIllIIlI.getValue(BlockTallGrass.field_176497_a)).func_177044_a()));
        }
        else {
            super.harvestBlock(lllllllllllllllllIIlIlIlIIlIllll, lllllllllllllllllIIlIlIlIIlIlllI, lllllllllllllllllIIlIlIlIIllIIll, lllllllllllllllllIIlIlIlIIllIIlI, lllllllllllllllllIIlIlIlIIlIlIll);
        }
    }
    
    static {
        __OBFID = "CL_00000321";
        field_176497_a = PropertyEnum.create("type", EnumType.class);
    }
    
    protected BlockTallGrass() {
        super(Material.vine);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockTallGrass.field_176497_a, EnumType.DEAD_BUSH));
        final float lllllllllllllllllIIlIlIlIllIlIll = 0.4f;
        this.setBlockBounds(0.5f - lllllllllllllllllIIlIlIlIllIlIll, 0.0f, 0.5f - lllllllllllllllllIIlIlIlIllIlIll, 0.5f + lllllllllllllllllIIlIlIlIllIlIll, 0.8f, 0.5f + lllllllllllllllllIIlIlIlIllIlIll);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIIlIlIIlllllIII) {
        return this.getDefaultState().withProperty(BlockTallGrass.field_176497_a, EnumType.func_177045_a(lllllllllllllllllIIlIlIIlllllIII));
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllllIIlIlIlIIIlllII, final CreativeTabs lllllllllllllllllIIlIlIlIIIllIll, final List lllllllllllllllllIIlIlIlIIIllIlI) {
        for (int lllllllllllllllllIIlIlIlIIIllIIl = 1; lllllllllllllllllIIlIlIlIIIllIIl < 3; ++lllllllllllllllllIIlIlIlIIIllIIl) {
            lllllllllllllllllIIlIlIlIIIllIlI.add(new ItemStack(lllllllllllllllllIIlIlIlIIIlllII, 1, lllllllllllllllllIIlIlIlIIIllIIl));
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllllIIlIlIlIlIIIlll, final Random lllllllllllllllllIIlIlIlIlIIIllI, final int lllllllllllllllllIIlIlIlIlIIIlIl) {
        return (lllllllllllllllllIIlIlIlIlIIIllI.nextInt(8) == 0) ? Items.wheat_seeds : null;
    }
    
    @Override
    public int getRenderColor(final IBlockState lllllllllllllllllIIlIlIlIlIlIllI) {
        if (lllllllllllllllllIIlIlIlIlIlIllI.getBlock() != this) {
            return super.getRenderColor(lllllllllllllllllIIlIlIlIlIlIllI);
        }
        final EnumType lllllllllllllllllIIlIlIlIlIlIlIl = (EnumType)lllllllllllllllllIIlIlIlIlIlIllI.getValue(BlockTallGrass.field_176497_a);
        return (lllllllllllllllllIIlIlIlIlIlIlIl == EnumType.DEAD_BUSH) ? 16777215 : ColorizerGrass.getGrassColor(0.5, 1.0);
    }
    
    @Override
    public int getBlockColor() {
        return ColorizerGrass.getGrassColor(0.5, 1.0);
    }
    
    @Override
    public int quantityDroppedWithBonus(final int lllllllllllllllllIIlIlIlIlIIIIII, final Random lllllllllllllllllIIlIlIlIIllllll) {
        return 1 + lllllllllllllllllIIlIlIlIIllllll.nextInt(lllllllllllllllllIIlIlIlIlIIIIII * 2 + 1);
    }
    
    @Override
    public int colorMultiplier(final IBlockAccess lllllllllllllllllIIlIlIlIlIIlllI, final BlockPos lllllllllllllllllIIlIlIlIlIIlIlI, final int lllllllllllllllllIIlIlIlIlIIllII) {
        return lllllllllllllllllIIlIlIlIlIIlllI.getBiomeGenForCoords(lllllllllllllllllIIlIlIlIlIIlIlI).func_180627_b(lllllllllllllllllIIlIlIlIlIIlIlI);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockTallGrass.field_176497_a });
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllllllllIIlIlIlIIIIllIl, final Random lllllllllllllllllIIlIlIlIIIIllII, final BlockPos lllllllllllllllllIIlIlIlIIIIlIll, final IBlockState lllllllllllllllllIIlIlIlIIIIlIlI) {
        return true;
    }
    
    @Override
    public void grow(final World lllllllllllllllllIIlIlIIllllllll, final Random lllllllllllllllllIIlIlIlIIIIIIll, final BlockPos lllllllllllllllllIIlIlIIlllllllI, final IBlockState lllllllllllllllllIIlIlIIllllllIl) {
        BlockDoublePlant.EnumPlantType lllllllllllllllllIIlIlIlIIIIIIII = BlockDoublePlant.EnumPlantType.GRASS;
        if (lllllllllllllllllIIlIlIIllllllIl.getValue(BlockTallGrass.field_176497_a) == EnumType.FERN) {
            lllllllllllllllllIIlIlIlIIIIIIII = BlockDoublePlant.EnumPlantType.FERN;
        }
        if (Blocks.double_plant.canPlaceBlockAt(lllllllllllllllllIIlIlIIllllllll, lllllllllllllllllIIlIlIIlllllllI)) {
            Blocks.double_plant.func_176491_a(lllllllllllllllllIIlIlIIllllllll, lllllllllllllllllIIlIlIIlllllllI, lllllllllllllllllIIlIlIlIIIIIIII, 2);
        }
    }
    
    @Override
    public boolean isStillGrowing(final World lllllllllllllllllIIlIlIlIIIlIIll, final BlockPos lllllllllllllllllIIlIlIlIIIlIIlI, final IBlockState lllllllllllllllllIIlIlIlIIIIllll, final boolean lllllllllllllllllIIlIlIlIIIlIIII) {
        return lllllllllllllllllIIlIlIlIIIIllll.getValue(BlockTallGrass.field_176497_a) != EnumType.DEAD_BUSH;
    }
    
    @Override
    public boolean canBlockStay(final World lllllllllllllllllIIlIlIlIllIIIll, final BlockPos lllllllllllllllllIIlIlIlIlIllllI, final IBlockState lllllllllllllllllIIlIlIlIllIIIIl) {
        return this.canPlaceBlockOn(lllllllllllllllllIIlIlIlIllIIIll.getBlockState(lllllllllllllllllIIlIlIlIlIllllI.offsetDown()).getBlock());
    }
    
    @Override
    public int getDamageValue(final World lllllllllllllllllIIlIlIlIIlIIllI, final BlockPos lllllllllllllllllIIlIlIlIIlIIIlI) {
        final IBlockState lllllllllllllllllIIlIlIlIIlIIlII = lllllllllllllllllIIlIlIlIIlIIllI.getBlockState(lllllllllllllllllIIlIlIlIIlIIIlI);
        return lllllllllllllllllIIlIlIlIIlIIlII.getBlock().getMetaFromState(lllllllllllllllllIIlIlIlIIlIIlII);
    }
    
    public enum EnumType implements IStringSerializable
    {
        FERN("FERN", 2, "FERN", 2, 2, "fern");
        
        private static final /* synthetic */ EnumType[] field_177048_d;
        
        DEAD_BUSH("DEAD_BUSH", 0, "DEAD_BUSH", 0, 0, "dead_bush");
        
        private final /* synthetic */ int field_177049_e;
        
        GRASS("GRASS", 1, "GRASS", 1, 1, "tall_grass");
        
        private final /* synthetic */ String field_177046_f;
        
        @Override
        public String getName() {
            return this.field_177046_f;
        }
        
        @Override
        public String toString() {
            return this.field_177046_f;
        }
        
        private EnumType(final String lllllllllllllllllllllllIlIIlllIl, final int lllllllllllllllllllllllIlIIlllII, final String lllllllllllllllllllllllIlIlIIIlI, final int lllllllllllllllllllllllIlIlIIIIl, final int lllllllllllllllllllllllIlIIllIll, final String lllllllllllllllllllllllIlIIllIlI) {
            this.field_177049_e = lllllllllllllllllllllllIlIIllIll;
            this.field_177046_f = lllllllllllllllllllllllIlIIllIlI;
        }
        
        public int func_177044_a() {
            return this.field_177049_e;
        }
        
        static {
            __OBFID = "CL_00002055";
            field_177048_d = new EnumType[values().length];
            for (final EnumType lllllllllllllllllllllllIlIlIllIl : values()) {
                EnumType.field_177048_d[lllllllllllllllllllllllIlIlIllIl.func_177044_a()] = lllllllllllllllllllllllIlIlIllIl;
            }
        }
        
        public static EnumType func_177045_a(int lllllllllllllllllllllllIlIIlIIIl) {
            if (lllllllllllllllllllllllIlIIlIIIl < 0 || lllllllllllllllllllllllIlIIlIIIl >= EnumType.field_177048_d.length) {
                lllllllllllllllllllllllIlIIlIIIl = 0;
            }
            return EnumType.field_177048_d[lllllllllllllllllllllllIlIIlIIIl];
        }
    }
}
