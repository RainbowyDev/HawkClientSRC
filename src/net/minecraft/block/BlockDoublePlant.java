package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;

public class BlockDoublePlant extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyEnum VARIANT_PROP;
    public static final /* synthetic */ PropertyEnum HALF_PROP;
    
    static {
        __OBFID = "CL_00000231";
        VARIANT_PROP = PropertyEnum.create("variant", EnumPlantType.class);
        HALF_PROP = PropertyEnum.create("half", EnumBlockHalf.class);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIlIlIIlIllIIllllI) {
        return ((llllllllllllllIIlIlIIlIllIIllllI & 0x8) > 0) ? this.getDefaultState().withProperty(BlockDoublePlant.HALF_PROP, EnumBlockHalf.UPPER) : this.getDefaultState().withProperty(BlockDoublePlant.HALF_PROP, EnumBlockHalf.LOWER).withProperty(BlockDoublePlant.VARIANT_PROP, EnumPlantType.func_176938_a(llllllllllllllIIlIlIIlIllIIllllI & 0x7));
    }
    
    public BlockDoublePlant() {
        super(Material.vine);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockDoublePlant.VARIANT_PROP, EnumPlantType.SUNFLOWER).withProperty(BlockDoublePlant.HALF_PROP, EnumBlockHalf.LOWER));
        this.setHardness(0.0f);
        this.setStepSound(BlockDoublePlant.soundTypeGrass);
        this.setUnlocalizedName("doublePlant");
    }
    
    @Override
    public boolean canUseBonemeal(final World llllllllllllllIIlIlIIlIllIllIIlI, final Random llllllllllllllIIlIlIIlIllIllIIIl, final BlockPos llllllllllllllIIlIlIIlIllIllIIII, final IBlockState llllllllllllllIIlIlIIlIllIlIllll) {
        return true;
    }
    
    public EnumPlantType func_176490_e(final IBlockAccess llllllllllllllIIlIlIIllIlIIlllII, final BlockPos llllllllllllllIIlIlIIllIlIIllIll) {
        IBlockState llllllllllllllIIlIlIIllIlIIllIlI = llllllllllllllIIlIlIIllIlIIlllII.getBlockState(llllllllllllllIIlIlIIllIlIIllIll);
        if (llllllllllllllIIlIlIIllIlIIllIlI.getBlock() == this) {
            llllllllllllllIIlIlIIllIlIIllIlI = this.getActualState(llllllllllllllIIlIlIIllIlIIllIlI, llllllllllllllIIlIlIIllIlIIlllII, llllllllllllllIIlIlIIllIlIIllIll);
            return (EnumPlantType)llllllllllllllIIlIlIIllIlIIllIlI.getValue(BlockDoublePlant.VARIANT_PROP);
        }
        return EnumPlantType.FERN;
    }
    
    @Override
    public int colorMultiplier(final IBlockAccess llllllllllllllIIlIlIIllIIIlllIII, final BlockPos llllllllllllllIIlIlIIllIIIllllII, final int llllllllllllllIIlIlIIllIIIlllIll) {
        final EnumPlantType llllllllllllllIIlIlIIllIIIlllIlI = this.func_176490_e(llllllllllllllIIlIlIIllIIIlllIII, llllllllllllllIIlIlIIllIIIllllII);
        return (llllllllllllllIIlIlIIllIIIlllIlI != EnumPlantType.GRASS && llllllllllllllIIlIlIIllIIIlllIlI != EnumPlantType.FERN) ? 16777215 : BiomeColorHelper.func_180286_a(llllllllllllllIIlIlIIllIIIlllIII, llllllllllllllIIlIlIIllIIIllllII);
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllIIlIlIIlIlllIlIIII, final CreativeTabs llllllllllllllIIlIlIIlIlllIlIllI, final List llllllllllllllIIlIlIIlIlllIIllll) {
        for (final EnumPlantType llllllllllllllIIlIlIIlIlllIlIIIl : EnumPlantType.values()) {
            llllllllllllllIIlIlIIlIlllIIllll.add(new ItemStack(llllllllllllllIIlIlIIlIlllIlIIII, 1, llllllllllllllIIlIlIIlIlllIlIIIl.func_176936_a()));
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIIlIlIIllIlIIIlllI, final BlockPos llllllllllllllIIlIlIIllIlIIlIIII) {
        return super.canPlaceBlockAt(llllllllllllllIIlIlIIllIlIIIlllI, llllllllllllllIIlIlIIllIlIIlIIII) && llllllllllllllIIlIlIIllIlIIIlllI.isAirBlock(llllllllllllllIIlIlIIllIlIIlIIII.offsetUp());
    }
    
    @Override
    public boolean canBlockStay(final World llllllllllllllIIlIlIIllIIlIlIlll, final BlockPos llllllllllllllIIlIlIIllIIlIlIllI, final IBlockState llllllllllllllIIlIlIIllIIlIlIlIl) {
        if (llllllllllllllIIlIlIIllIIlIlIlIl.getValue(BlockDoublePlant.HALF_PROP) == EnumBlockHalf.UPPER) {
            return llllllllllllllIIlIlIIllIIlIlIlll.getBlockState(llllllllllllllIIlIlIIllIIlIlIllI.offsetDown()).getBlock() == this;
        }
        final IBlockState llllllllllllllIIlIlIIllIIlIllIIl = llllllllllllllIIlIlIIllIIlIlIlll.getBlockState(llllllllllllllIIlIlIIllIIlIlIllI.offsetUp());
        return llllllllllllllIIlIlIIllIIlIllIIl.getBlock() == this && super.canBlockStay(llllllllllllllIIlIlIIllIIlIlIlll, llllllllllllllIIlIlIIllIIlIlIllI, llllllllllllllIIlIlIIllIIlIllIIl);
    }
    
    @Override
    public int getDamageValue(final World llllllllllllllIIlIlIIlIlllIIIllI, final BlockPos llllllllllllllIIlIlIIlIlllIIIlIl) {
        return this.func_176490_e(llllllllllllllIIlIlIIlIlllIIIllI, llllllllllllllIIlIlIIlIlllIIIlIl).func_176936_a();
    }
    
    @Override
    public void harvestBlock(final World llllllllllllllIIlIlIIllIIIIIllIl, final EntityPlayer llllllllllllllIIlIlIIllIIIIIllII, final BlockPos llllllllllllllIIlIlIIllIIIIlIIIl, final IBlockState llllllllllllllIIlIlIIllIIIIlIIII, final TileEntity llllllllllllllIIlIlIIllIIIIIlIIl) {
        if (llllllllllllllIIlIlIIllIIIIIllIl.isRemote || llllllllllllllIIlIlIIllIIIIIllII.getCurrentEquippedItem() == null || llllllllllllllIIlIlIIllIIIIIllII.getCurrentEquippedItem().getItem() != Items.shears || llllllllllllllIIlIlIIllIIIIlIIII.getValue(BlockDoublePlant.HALF_PROP) != EnumBlockHalf.LOWER || !this.func_176489_b(llllllllllllllIIlIlIIllIIIIIllIl, llllllllllllllIIlIlIIllIIIIlIIIl, llllllllllllllIIlIlIIllIIIIlIIII, llllllllllllllIIlIlIIllIIIIIllII)) {
            super.harvestBlock(llllllllllllllIIlIlIIllIIIIIllIl, llllllllllllllIIlIlIIllIIIIIllII, llllllllllllllIIlIlIIllIIIIlIIIl, llllllllllllllIIlIlIIllIIIIlIIII, llllllllllllllIIlIlIIllIIIIIlIIl);
        }
    }
    
    public void func_176491_a(final World llllllllllllllIIlIlIIllIIIlIlIlI, final BlockPos llllllllllllllIIlIlIIllIIIlIlllI, final EnumPlantType llllllllllllllIIlIlIIllIIIlIllIl, final int llllllllllllllIIlIlIIllIIIlIIlll) {
        llllllllllllllIIlIlIIllIIIlIlIlI.setBlockState(llllllllllllllIIlIlIIllIIIlIlllI, this.getDefaultState().withProperty(BlockDoublePlant.HALF_PROP, EnumBlockHalf.LOWER).withProperty(BlockDoublePlant.VARIANT_PROP, llllllllllllllIIlIlIIllIIIlIllIl), llllllllllllllIIlIlIIllIIIlIIlll);
        llllllllllllllIIlIlIIllIIIlIlIlI.setBlockState(llllllllllllllIIlIlIIllIIIlIlllI.offsetUp(), this.getDefaultState().withProperty(BlockDoublePlant.HALF_PROP, EnumBlockHalf.UPPER), llllllllllllllIIlIlIIllIIIlIIlll);
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIIlIlIIllIlIlIIlII, final BlockPos llllllllllllllIIlIlIIllIlIlIIIll) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIIlIlIIllIIIIlllII, final BlockPos llllllllllllllIIlIlIIllIIIIllIll, final IBlockState llllllllllllllIIlIlIIllIIIlIIIII, final EntityLivingBase llllllllllllllIIlIlIIllIIIIlllll, final ItemStack llllllllllllllIIlIlIIllIIIIllllI) {
        llllllllllllllIIlIlIIllIIIIlllII.setBlockState(llllllllllllllIIlIlIIllIIIIllIll.offsetUp(), this.getDefaultState().withProperty(BlockDoublePlant.HALF_PROP, EnumBlockHalf.UPPER), 2);
    }
    
    @Override
    public boolean isReplaceable(final World llllllllllllllIIlIlIIllIlIIIIllI, final BlockPos llllllllllllllIIlIlIIllIlIIIIIII) {
        final IBlockState llllllllllllllIIlIlIIllIlIIIIlII = llllllllllllllIIlIlIIllIlIIIIllI.getBlockState(llllllllllllllIIlIlIIllIlIIIIIII);
        if (llllllllllllllIIlIlIIllIlIIIIlII.getBlock() != this) {
            return true;
        }
        final EnumPlantType llllllllllllllIIlIlIIllIlIIIIIll = (EnumPlantType)this.getActualState(llllllllllllllIIlIlIIllIlIIIIlII, llllllllllllllIIlIlIIllIlIIIIllI, llllllllllllllIIlIlIIllIlIIIIIII).getValue(BlockDoublePlant.VARIANT_PROP);
        return llllllllllllllIIlIlIIllIlIIIIIll == EnumPlantType.FERN || llllllllllllllIIlIlIIllIlIIIIIll == EnumPlantType.GRASS;
    }
    
    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XZ;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIlIlIIllIIlIIlllI, final Random llllllllllllllIIlIlIIllIIlIIllIl, final int llllllllllllllIIlIlIIllIIlIIllII) {
        if (llllllllllllllIIlIlIIllIIlIIlllI.getValue(BlockDoublePlant.HALF_PROP) == EnumBlockHalf.UPPER) {
            return null;
        }
        final EnumPlantType llllllllllllllIIlIlIIllIIlIIlIll = (EnumPlantType)llllllllllllllIIlIlIIllIIlIIlllI.getValue(BlockDoublePlant.VARIANT_PROP);
        return (llllllllllllllIIlIlIIllIIlIIlIll == EnumPlantType.FERN) ? null : ((llllllllllllllIIlIlIIllIIlIIlIll == EnumPlantType.GRASS) ? ((llllllllllllllIIlIlIIllIIlIIllIl.nextInt(8) == 0) ? Items.wheat_seeds : null) : Item.getItemFromBlock(this));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIlIlIIlIllIIIllII) {
        return (llllllllllllllIIlIlIIlIllIIIllII.getValue(BlockDoublePlant.HALF_PROP) == EnumBlockHalf.UPPER) ? 8 : ((EnumPlantType)llllllllllllllIIlIlIIlIllIIIllII.getValue(BlockDoublePlant.VARIANT_PROP)).func_176936_a();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockDoublePlant.HALF_PROP, BlockDoublePlant.VARIANT_PROP });
    }
    
    @Override
    public void grow(final World llllllllllllllIIlIlIIlIllIlIIlIl, final Random llllllllllllllIIlIlIIlIllIlIlIIl, final BlockPos llllllllllllllIIlIlIIlIllIlIIlII, final IBlockState llllllllllllllIIlIlIIlIllIlIIlll) {
        Block.spawnAsEntity(llllllllllllllIIlIlIIlIllIlIIlIl, llllllllllllllIIlIlIIlIllIlIIlII, new ItemStack(this, 1, this.func_176490_e(llllllllllllllIIlIlIIlIllIlIIlIl, llllllllllllllIIlIlIIlIllIlIIlII).func_176936_a()));
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIIlIlIIllIIlIIIlII) {
        return (llllllllllllllIIlIlIIllIIlIIIlII.getValue(BlockDoublePlant.HALF_PROP) != EnumBlockHalf.UPPER && llllllllllllllIIlIlIIllIIlIIIlII.getValue(BlockDoublePlant.VARIANT_PROP) != EnumPlantType.GRASS) ? ((EnumPlantType)llllllllllllllIIlIlIIllIIlIIIlII.getValue(BlockDoublePlant.VARIANT_PROP)).func_176936_a() : 0;
    }
    
    @Override
    protected void func_176475_e(final World llllllllllllllIIlIlIIllIIlllIIll, final BlockPos llllllllllllllIIlIlIIllIIlllIIlI, final IBlockState llllllllllllllIIlIlIIllIIllIlIII) {
        if (!this.canBlockStay(llllllllllllllIIlIlIIllIIlllIIll, llllllllllllllIIlIlIIllIIlllIIlI, llllllllllllllIIlIlIIllIIllIlIII)) {
            final boolean llllllllllllllIIlIlIIllIIlllIIII = llllllllllllllIIlIlIIllIIllIlIII.getValue(BlockDoublePlant.HALF_PROP) == EnumBlockHalf.UPPER;
            final BlockPos llllllllllllllIIlIlIIllIIllIllll = llllllllllllllIIlIlIIllIIlllIIII ? llllllllllllllIIlIlIIllIIlllIIlI : llllllllllllllIIlIlIIllIIlllIIlI.offsetUp();
            final BlockPos llllllllllllllIIlIlIIllIIllIlllI = llllllllllllllIIlIlIIllIIlllIIII ? llllllllllllllIIlIlIIllIIlllIIlI.offsetDown() : llllllllllllllIIlIlIIllIIlllIIlI;
            final Object llllllllllllllIIlIlIIllIIllIllIl = llllllllllllllIIlIlIIllIIlllIIII ? this : llllllllllllllIIlIlIIllIIlllIIll.getBlockState(llllllllllllllIIlIlIIllIIllIllll).getBlock();
            final Object llllllllllllllIIlIlIIllIIllIllII = llllllllllllllIIlIlIIllIIlllIIII ? llllllllllllllIIlIlIIllIIlllIIll.getBlockState(llllllllllllllIIlIlIIllIIllIlllI).getBlock() : this;
            if (llllllllllllllIIlIlIIllIIllIllIl == this) {
                llllllllllllllIIlIlIIllIIlllIIll.setBlockState(llllllllllllllIIlIlIIllIIllIllll, Blocks.air.getDefaultState(), 3);
            }
            if (llllllllllllllIIlIlIIllIIllIllII == this) {
                llllllllllllllIIlIlIIllIIlllIIll.setBlockState(llllllllllllllIIlIlIIllIIllIlllI, Blocks.air.getDefaultState(), 3);
                if (!llllllllllllllIIlIlIIllIIlllIIII) {
                    this.dropBlockAsItem(llllllllllllllIIlIlIIllIIlllIIll, llllllllllllllIIlIlIIllIIllIlllI, llllllllllllllIIlIlIIllIIllIlIII, 0);
                }
            }
        }
    }
    
    @Override
    public IBlockState getActualState(IBlockState llllllllllllllIIlIlIIlIllIIlIIlI, final IBlockAccess llllllllllllllIIlIlIIlIllIIlIllI, final BlockPos llllllllllllllIIlIlIIlIllIIlIlIl) {
        if (llllllllllllllIIlIlIIlIllIIlIIlI.getValue(BlockDoublePlant.HALF_PROP) == EnumBlockHalf.UPPER) {
            final IBlockState llllllllllllllIIlIlIIlIllIIlIlII = llllllllllllllIIlIlIIlIllIIlIllI.getBlockState(llllllllllllllIIlIlIIlIllIIlIlIl.offsetDown());
            if (llllllllllllllIIlIlIIlIllIIlIlII.getBlock() == this) {
                llllllllllllllIIlIlIIlIllIIlIIlI = llllllllllllllIIlIlIIlIllIIlIIlI.withProperty(BlockDoublePlant.VARIANT_PROP, llllllllllllllIIlIlIIlIllIIlIlII.getValue(BlockDoublePlant.VARIANT_PROP));
            }
        }
        return llllllllllllllIIlIlIIlIllIIlIIlI;
    }
    
    private boolean func_176489_b(final World llllllllllllllIIlIlIIlIllllIlIll, final BlockPos llllllllllllllIIlIlIIlIllllIlIlI, final IBlockState llllllllllllllIIlIlIIlIllllIlIIl, final EntityPlayer llllllllllllllIIlIlIIlIllllIIIIl) {
        final EnumPlantType llllllllllllllIIlIlIIlIllllIIlll = (EnumPlantType)llllllllllllllIIlIlIIlIllllIlIIl.getValue(BlockDoublePlant.VARIANT_PROP);
        if (llllllllllllllIIlIlIIlIllllIIlll != EnumPlantType.FERN && llllllllllllllIIlIlIIlIllllIIlll != EnumPlantType.GRASS) {
            return false;
        }
        llllllllllllllIIlIlIIlIllllIIIIl.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
        final int llllllllllllllIIlIlIIlIllllIIllI = ((llllllllllllllIIlIlIIlIllllIIlll == EnumPlantType.GRASS) ? BlockTallGrass.EnumType.GRASS : BlockTallGrass.EnumType.FERN).func_177044_a();
        Block.spawnAsEntity(llllllllllllllIIlIlIIlIllllIlIll, llllllllllllllIIlIlIIlIllllIlIlI, new ItemStack(Blocks.tallgrass, 2, llllllllllllllIIlIlIIlIllllIIllI));
        return true;
    }
    
    @Override
    public void onBlockHarvested(final World llllllllllllllIIlIlIIllIIIIIIIII, final BlockPos llllllllllllllIIlIlIIlIlllllllll, final IBlockState llllllllllllllIIlIlIIlIlllllIlll, final EntityPlayer llllllllllllllIIlIlIIlIlllllllIl) {
        if (llllllllllllllIIlIlIIlIlllllIlll.getValue(BlockDoublePlant.HALF_PROP) == EnumBlockHalf.UPPER) {
            if (llllllllllllllIIlIlIIllIIIIIIIII.getBlockState(llllllllllllllIIlIlIIlIlllllllll.offsetDown()).getBlock() == this) {
                if (!llllllllllllllIIlIlIIlIlllllllIl.capabilities.isCreativeMode) {
                    final IBlockState llllllllllllllIIlIlIIlIlllllllII = llllllllllllllIIlIlIIllIIIIIIIII.getBlockState(llllllllllllllIIlIlIIlIlllllllll.offsetDown());
                    final EnumPlantType llllllllllllllIIlIlIIlIllllllIll = (EnumPlantType)llllllllllllllIIlIlIIlIlllllllII.getValue(BlockDoublePlant.VARIANT_PROP);
                    if (llllllllllllllIIlIlIIlIllllllIll != EnumPlantType.FERN && llllllllllllllIIlIlIIlIllllllIll != EnumPlantType.GRASS) {
                        llllllllllllllIIlIlIIllIIIIIIIII.destroyBlock(llllllllllllllIIlIlIIlIlllllllll.offsetDown(), true);
                    }
                    else if (!llllllllllllllIIlIlIIllIIIIIIIII.isRemote) {
                        if (llllllllllllllIIlIlIIlIlllllllIl.getCurrentEquippedItem() != null && llllllllllllllIIlIlIIlIlllllllIl.getCurrentEquippedItem().getItem() == Items.shears) {
                            this.func_176489_b(llllllllllllllIIlIlIIllIIIIIIIII, llllllllllllllIIlIlIIlIlllllllll, llllllllllllllIIlIlIIlIlllllllII, llllllllllllllIIlIlIIlIlllllllIl);
                            llllllllllllllIIlIlIIllIIIIIIIII.setBlockToAir(llllllllllllllIIlIlIIlIlllllllll.offsetDown());
                        }
                        else {
                            llllllllllllllIIlIlIIllIIIIIIIII.destroyBlock(llllllllllllllIIlIlIIlIlllllllll.offsetDown(), true);
                        }
                    }
                    else {
                        llllllllllllllIIlIlIIllIIIIIIIII.setBlockToAir(llllllllllllllIIlIlIIlIlllllllll.offsetDown());
                    }
                }
                else {
                    llllllllllllllIIlIlIIllIIIIIIIII.setBlockToAir(llllllllllllllIIlIlIIlIlllllllll.offsetDown());
                }
            }
        }
        else if (llllllllllllllIIlIlIIlIlllllllIl.capabilities.isCreativeMode && llllllllllllllIIlIlIIllIIIIIIIII.getBlockState(llllllllllllllIIlIlIIlIlllllllll.offsetUp()).getBlock() == this) {
            llllllllllllllIIlIlIIllIIIIIIIII.setBlockState(llllllllllllllIIlIlIIlIlllllllll.offsetUp(), Blocks.air.getDefaultState(), 2);
        }
        super.onBlockHarvested(llllllllllllllIIlIlIIllIIIIIIIII, llllllllllllllIIlIlIIlIlllllllll, llllllllllllllIIlIlIIlIlllllIlll, llllllllllllllIIlIlIIlIlllllllIl);
    }
    
    @Override
    public boolean isStillGrowing(final World llllllllllllllIIlIlIIlIllIllllII, final BlockPos llllllllllllllIIlIlIIlIllIllIlIl, final IBlockState llllllllllllllIIlIlIIlIllIlllIlI, final boolean llllllllllllllIIlIlIIlIllIlllIIl) {
        final EnumPlantType llllllllllllllIIlIlIIlIllIlllIII = this.func_176490_e(llllllllllllllIIlIlIIlIllIllllII, llllllllllllllIIlIlIIlIllIllIlIl);
        return llllllllllllllIIlIlIIlIllIlllIII != EnumPlantType.GRASS && llllllllllllllIIlIlIIlIllIlllIII != EnumPlantType.FERN;
    }
    
    enum EnumBlockHalf implements IStringSerializable
    {
        UPPER("UPPER", 0, "UPPER", 0), 
        LOWER("LOWER", 1, "LOWER", 1);
        
        @Override
        public String toString() {
            return this.getName();
        }
        
        @Override
        public String getName() {
            return (this == EnumBlockHalf.UPPER) ? "upper" : "lower";
        }
        
        static {
            __OBFID = "CL_00002122";
        }
        
        private EnumBlockHalf(final String lllllllllllllllIIllIIlIIIlIlllll, final int lllllllllllllllIIllIIlIIIlIllllI, final String lllllllllllllllIIllIIlIIIllIIIlI, final int lllllllllllllllIIllIIlIIIllIIIIl) {
        }
    }
    
    public enum EnumPlantType implements IStringSerializable
    {
        private final /* synthetic */ String field_176950_i;
        
        GRASS("GRASS", 2, "GRASS", 2, 2, "double_grass", "grass");
        
        private final /* synthetic */ int field_176949_h;
        
        SUNFLOWER("SUNFLOWER", 0, "SUNFLOWER", 0, 0, "sunflower"), 
        SYRINGA("SYRINGA", 1, "SYRINGA", 1, 1, "syringa"), 
        PAEONIA("PAEONIA", 5, "PAEONIA", 5, 5, "paeonia"), 
        FERN("FERN", 3, "FERN", 3, 3, "double_fern", "fern");
        
        private static final /* synthetic */ EnumPlantType[] field_176941_g;
        
        ROSE("ROSE", 4, "ROSE", 4, 4, "double_rose", "rose");
        
        private final /* synthetic */ String field_176947_j;
        
        static {
            __OBFID = "CL_00002121";
            field_176941_g = new EnumPlantType[values().length];
            for (final EnumPlantType llllllllllllllIlllIlllIlIlllllII : values()) {
                EnumPlantType.field_176941_g[llllllllllllllIlllIlllIlIlllllII.func_176936_a()] = llllllllllllllIlllIlllIlIlllllII;
            }
        }
        
        @Override
        public String getName() {
            return this.field_176950_i;
        }
        
        public int func_176936_a() {
            return this.field_176949_h;
        }
        
        public static EnumPlantType func_176938_a(int llllllllllllllIlllIlllIlIlIIlIlI) {
            if (llllllllllllllIlllIlllIlIlIIlIlI < 0 || llllllllllllllIlllIlllIlIlIIlIlI >= EnumPlantType.field_176941_g.length) {
                llllllllllllllIlllIlllIlIlIIlIlI = 0;
            }
            return EnumPlantType.field_176941_g[llllllllllllllIlllIlllIlIlIIlIlI];
        }
        
        private EnumPlantType(final String llllllllllllllIlllIlllIlIllIlIlI, final int llllllllllllllIlllIlllIlIllIlIIl, final String llllllllllllllIlllIlllIlIllIlIII, final int llllllllllllllIlllIlllIlIllIlllI, final int llllllllllllllIlllIlllIlIllIllIl, final String llllllllllllllIlllIlllIlIllIIlIl) {
            this(llllllllllllllIlllIlllIlIllIlIlI, llllllllllllllIlllIlllIlIllIlIIl, llllllllllllllIlllIlllIlIllIlIII, llllllllllllllIlllIlllIlIllIlllI, llllllllllllllIlllIlllIlIllIllIl, llllllllllllllIlllIlllIlIllIIlIl, llllllllllllllIlllIlllIlIllIIlIl);
        }
        
        public String func_176939_c() {
            return this.field_176947_j;
        }
        
        @Override
        public String toString() {
            return this.field_176950_i;
        }
        
        private EnumPlantType(final String llllllllllllllIlllIlllIlIlIlIlll, final int llllllllllllllIlllIlllIlIlIlIllI, final String llllllllllllllIlllIlllIlIlIlllIl, final int llllllllllllllIlllIlllIlIlIlllII, final int llllllllllllllIlllIlllIlIlIllIll, final String llllllllllllllIlllIlllIlIlIllIlI, final String llllllllllllllIlllIlllIlIlIllIIl) {
            this.field_176949_h = llllllllllllllIlllIlllIlIlIllIll;
            this.field_176950_i = llllllllllllllIlllIlllIlIlIllIlI;
            this.field_176947_j = llllllllllllllIlllIlllIlIlIllIIl;
        }
    }
}
