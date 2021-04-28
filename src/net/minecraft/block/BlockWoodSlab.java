package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public abstract class BlockWoodSlab extends BlockSlab
{
    public static final /* synthetic */ PropertyEnum field_176557_b;
    
    static {
        __OBFID = "CL_00000337";
        field_176557_b = PropertyEnum.create("variant", BlockPlanks.EnumType.class);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllllIllIIllllIIllIll) {
        IBlockState llllllllllllllllIllIIllllIIlllIl = this.getDefaultState().withProperty(BlockWoodSlab.field_176557_b, BlockPlanks.EnumType.func_176837_a(llllllllllllllllIllIIllllIIllIll & 0x7));
        if (!this.isDouble()) {
            llllllllllllllllIllIIllllIIlllIl = llllllllllllllllIllIIllllIIlllIl.withProperty(BlockWoodSlab.HALF_PROP, ((llllllllllllllllIllIIllllIIllIll & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return llllllllllllllllIllIIllllIIlllIl;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllllIllIIllllIIlIlII) {
        final byte llllllllllllllllIllIIllllIIlIIll = 0;
        int llllllllllllllllIllIIllllIIlIIlI = llllllllllllllllIllIIllllIIlIIll | ((BlockPlanks.EnumType)llllllllllllllllIllIIllllIIlIlII.getValue(BlockWoodSlab.field_176557_b)).func_176839_a();
        if (!this.isDouble() && llllllllllllllllIllIIllllIIlIlII.getValue(BlockWoodSlab.HALF_PROP) == EnumBlockHalf.TOP) {
            llllllllllllllllIllIIllllIIlIIlI |= 0x8;
        }
        return llllllllllllllllIllIIllllIIlIIlI;
    }
    
    @Override
    public Object func_176553_a(final ItemStack llllllllllllllllIllIIllllIlllIII) {
        return BlockPlanks.EnumType.func_176837_a(llllllllllllllllIllIIllllIlllIII.getMetadata() & 0x7);
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllllIllIIllllIlIlIII, final CreativeTabs llllllllllllllllIllIIllllIlIlllI, final List llllllllllllllllIllIIllllIlIIlll) {
        if (llllllllllllllllIllIIllllIlIlIII != Item.getItemFromBlock(Blocks.double_wooden_slab)) {
            for (final BlockPlanks.EnumType llllllllllllllllIllIIllllIlIlIIl : BlockPlanks.EnumType.values()) {
                llllllllllllllllIllIIllllIlIIlll.add(new ItemStack(llllllllllllllllIllIIllllIlIlIII, 1, llllllllllllllllIllIIllllIlIlIIl.func_176839_a()));
            }
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return this.isDouble() ? new BlockState(this, new IProperty[] { BlockWoodSlab.field_176557_b }) : new BlockState(this, new IProperty[] { BlockWoodSlab.HALF_PROP, BlockWoodSlab.field_176557_b });
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllllIllIIllllIIIlIII) {
        return ((BlockPlanks.EnumType)llllllllllllllllIllIIllllIIIlIII.getValue(BlockWoodSlab.field_176557_b)).func_176839_a();
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllllIllIIlllllIIIlll, final Random llllllllllllllllIllIIlllllIIIllI, final int llllllllllllllllIllIIlllllIIIlIl) {
        return Item.getItemFromBlock(Blocks.wooden_slab);
    }
    
    @Override
    public String getFullSlabName(final int llllllllllllllllIllIIllllIlllllI) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(BlockPlanks.EnumType.func_176837_a(llllllllllllllllIllIIllllIlllllI).func_176840_c()));
    }
    
    @Override
    public Item getItem(final World llllllllllllllllIllIIlllllIIIIll, final BlockPos llllllllllllllllIllIIlllllIIIIlI) {
        return Item.getItemFromBlock(Blocks.wooden_slab);
    }
    
    @Override
    public IProperty func_176551_l() {
        return BlockWoodSlab.field_176557_b;
    }
    
    public BlockWoodSlab() {
        super(Material.wood);
        IBlockState llllllllllllllllIllIIlllllIIlIll = this.blockState.getBaseState();
        if (!this.isDouble()) {
            llllllllllllllllIllIIlllllIIlIll = llllllllllllllllIllIIlllllIIlIll.withProperty(BlockWoodSlab.HALF_PROP, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(llllllllllllllllIllIIlllllIIlIll.withProperty(BlockWoodSlab.field_176557_b, BlockPlanks.EnumType.OAK));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
}
