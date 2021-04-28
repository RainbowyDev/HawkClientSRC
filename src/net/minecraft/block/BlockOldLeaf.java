package net.minecraft.block;

import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;

public class BlockOldLeaf extends BlockLeaves
{
    public static final /* synthetic */ PropertyEnum VARIANT_PROP;
    
    @Override
    public int colorMultiplier(final IBlockAccess llllIlIllIlIll, final BlockPos llllIlIllIlIlI, final int llllIlIllIlIIl) {
        final IBlockState llllIlIllIlllI = llllIlIllIlIll.getBlockState(llllIlIllIlIlI);
        if (llllIlIllIlllI.getBlock() == this) {
            final BlockPlanks.EnumType llllIlIllIllIl = (BlockPlanks.EnumType)llllIlIllIlllI.getValue(BlockOldLeaf.VARIANT_PROP);
            if (llllIlIllIllIl == BlockPlanks.EnumType.SPRUCE) {
                return ColorizerFoliage.getFoliageColorPine();
            }
            if (llllIlIllIllIl == BlockPlanks.EnumType.BIRCH) {
                return ColorizerFoliage.getFoliageColorBirch();
            }
        }
        return super.colorMultiplier(llllIlIllIlIll, llllIlIllIlIlI, llllIlIllIlIIl);
    }
    
    @Override
    public int damageDropped(final IBlockState llllIlIIlIlIll) {
        return ((BlockPlanks.EnumType)llllIlIIlIlIll.getValue(BlockOldLeaf.VARIANT_PROP)).func_176839_a();
    }
    
    @Override
    protected int func_176232_d(final IBlockState llllIlIlIlIllI) {
        return (llllIlIlIlIllI.getValue(BlockOldLeaf.VARIANT_PROP) == BlockPlanks.EnumType.JUNGLE) ? 40 : super.func_176232_d(llllIlIlIlIllI);
    }
    
    static {
        __OBFID = "CL_00000280";
        VARIANT_PROP = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (Predicate)new Predicate() {
            public boolean apply(final Object llllllllllllllllllIIIIIlIlIlllII) {
                return this.func_180202_a((BlockPlanks.EnumType)llllllllllllllllllIIIIIlIlIlllII);
            }
            
            public boolean func_180202_a(final BlockPlanks.EnumType llllllllllllllllllIIIIIlIllIIIll) {
                return llllllllllllllllllIIIIIlIllIIIll.func_176839_a() < 4;
            }
            
            static {
                __OBFID = "CL_00002085";
            }
        });
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockOldLeaf.VARIANT_PROP, BlockOldLeaf.field_176236_b, BlockOldLeaf.field_176237_a });
    }
    
    @Override
    public void getSubBlocks(final Item llllIlIlIlIIII, final CreativeTabs llllIlIlIIllll, final List llllIlIlIIllII) {
        llllIlIlIIllII.add(new ItemStack(llllIlIlIlIIII, 1, BlockPlanks.EnumType.OAK.func_176839_a()));
        llllIlIlIIllII.add(new ItemStack(llllIlIlIlIIII, 1, BlockPlanks.EnumType.SPRUCE.func_176839_a()));
        llllIlIlIIllII.add(new ItemStack(llllIlIlIlIIII, 1, BlockPlanks.EnumType.BIRCH.func_176839_a()));
        llllIlIlIIllII.add(new ItemStack(llllIlIlIlIIII, 1, BlockPlanks.EnumType.JUNGLE.func_176839_a()));
    }
    
    @Override
    public void harvestBlock(final World llllIlIIIlllIl, final EntityPlayer llllIlIIlIIIlI, final BlockPos llllIlIIIllIll, final IBlockState llllIlIIIllIlI, final TileEntity llllIlIIIlllll) {
        if (!llllIlIIIlllIl.isRemote && llllIlIIlIIIlI.getCurrentEquippedItem() != null && llllIlIIlIIIlI.getCurrentEquippedItem().getItem() == Items.shears) {
            llllIlIIlIIIlI.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
            Block.spawnAsEntity(llllIlIIIlllIl, llllIlIIIllIll, new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPlanks.EnumType)llllIlIIIllIlI.getValue(BlockOldLeaf.VARIANT_PROP)).func_176839_a()));
        }
        else {
            super.harvestBlock(llllIlIIIlllIl, llllIlIIlIIIlI, llllIlIIIllIll, llllIlIIIllIlI, llllIlIIIlllll);
        }
    }
    
    @Override
    public int getRenderColor(final IBlockState llllIlIlllllIl) {
        if (llllIlIlllllIl.getBlock() != this) {
            return super.getRenderColor(llllIlIlllllIl);
        }
        final BlockPlanks.EnumType llllIlIlllllII = (BlockPlanks.EnumType)llllIlIlllllIl.getValue(BlockOldLeaf.VARIANT_PROP);
        return (llllIlIlllllII == BlockPlanks.EnumType.SPRUCE) ? ColorizerFoliage.getFoliageColorPine() : ((llllIlIlllllII == BlockPlanks.EnumType.BIRCH) ? ColorizerFoliage.getFoliageColorBirch() : super.getRenderColor(llllIlIlllllIl));
    }
    
    public BlockOldLeaf() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockOldLeaf.VARIANT_PROP, BlockPlanks.EnumType.OAK).withProperty(BlockOldLeaf.field_176236_b, true).withProperty(BlockOldLeaf.field_176237_a, true));
    }
    
    @Override
    protected ItemStack createStackedBlock(final IBlockState llllIlIlIIIllI) {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPlanks.EnumType)llllIlIlIIIllI.getValue(BlockOldLeaf.VARIANT_PROP)).func_176839_a());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllIlIlIIIIII) {
        return this.getDefaultState().withProperty(BlockOldLeaf.VARIANT_PROP, this.func_176233_b(llllIlIlIIIIII)).withProperty(BlockOldLeaf.field_176237_a, (llllIlIlIIIIII & 0x4) == 0x0).withProperty(BlockOldLeaf.field_176236_b, (llllIlIlIIIIII & 0x8) > 0);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllIlIIlllIll) {
        final byte llllIlIIlllIlI = 0;
        int llllIlIIlllIIl = llllIlIIlllIlI | ((BlockPlanks.EnumType)llllIlIIlllIll.getValue(BlockOldLeaf.VARIANT_PROP)).func_176839_a();
        if (!(boolean)llllIlIIlllIll.getValue(BlockOldLeaf.field_176237_a)) {
            llllIlIIlllIIl |= 0x4;
        }
        if (llllIlIIlllIll.getValue(BlockOldLeaf.field_176236_b)) {
            llllIlIIlllIIl |= 0x8;
        }
        return llllIlIIlllIIl;
    }
    
    @Override
    public BlockPlanks.EnumType func_176233_b(final int llllIlIIllIIll) {
        return BlockPlanks.EnumType.func_176837_a((llllIlIIllIIll & 0x3) % 4);
    }
    
    @Override
    protected void func_176234_a(final World llllIlIllIIIIl, final BlockPos llllIlIllIIIII, final IBlockState llllIlIlIllIll, final int llllIlIlIllllI) {
        if (llllIlIlIllIll.getValue(BlockOldLeaf.VARIANT_PROP) == BlockPlanks.EnumType.OAK && llllIlIllIIIIl.rand.nextInt(llllIlIlIllllI) == 0) {
            Block.spawnAsEntity(llllIlIllIIIIl, llllIlIllIIIII, new ItemStack(Items.apple, 1, 0));
        }
    }
}
