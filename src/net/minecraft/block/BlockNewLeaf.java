package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import java.util.*;

public class BlockNewLeaf extends BlockLeaves
{
    public static final /* synthetic */ PropertyEnum field_176240_P;
    
    public BlockNewLeaf() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockNewLeaf.field_176240_P, BlockPlanks.EnumType.ACACIA).withProperty(BlockNewLeaf.field_176236_b, true).withProperty(BlockNewLeaf.field_176237_a, true));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llIllllllIlllII) {
        final byte llIllllllIllIll = 0;
        int llIllllllIllIlI = llIllllllIllIll | ((BlockPlanks.EnumType)llIllllllIlllII.getValue(BlockNewLeaf.field_176240_P)).func_176839_a() - 4;
        if (!(boolean)llIllllllIlllII.getValue(BlockNewLeaf.field_176237_a)) {
            llIllllllIllIlI |= 0x4;
        }
        if (llIllllllIlllII.getValue(BlockNewLeaf.field_176236_b)) {
            llIllllllIllIlI |= 0x8;
        }
        return llIllllllIllIlI;
    }
    
    @Override
    public void harvestBlock(final World llIllllllIIlIII, final EntityPlayer llIllllllIIIIIl, final BlockPos llIllllllIIIllI, final IBlockState llIlllllIllllll, final TileEntity llIllllllIIIlII) {
        if (!llIllllllIIlIII.isRemote && llIllllllIIIIIl.getCurrentEquippedItem() != null && llIllllllIIIIIl.getCurrentEquippedItem().getItem() == Items.shears) {
            llIllllllIIIIIl.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
            Block.spawnAsEntity(llIllllllIIlIII, llIllllllIIIllI, new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPlanks.EnumType)llIlllllIllllll.getValue(BlockNewLeaf.field_176240_P)).func_176839_a() - 4));
        }
        else {
            super.harvestBlock(llIllllllIIlIII, llIllllllIIIIIl, llIllllllIIIllI, llIlllllIllllll, llIllllllIIIlII);
        }
    }
    
    @Override
    protected ItemStack createStackedBlock(final IBlockState llIlllllllIIlll) {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPlanks.EnumType)llIlllllllIIlll.getValue(BlockNewLeaf.field_176240_P)).func_176839_a() - 4);
    }
    
    static {
        __OBFID = "CL_00000276";
        field_176240_P = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (Predicate)new Predicate() {
            public boolean apply(final Object lIlIIlIIlIll) {
                return this.func_180195_a((BlockPlanks.EnumType)lIlIIlIIlIll);
            }
            
            public boolean func_180195_a(final BlockPlanks.EnumType lIlIIlIlIIIl) {
                return lIlIIlIlIIIl.func_176839_a() >= 4;
            }
            
            static {
                __OBFID = "CL_00002090";
            }
        });
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockNewLeaf.field_176240_P, BlockNewLeaf.field_176236_b, BlockNewLeaf.field_176237_a });
    }
    
    @Override
    public int damageDropped(final IBlockState lllIIIIIIIIIIII) {
        return ((BlockPlanks.EnumType)lllIIIIIIIIIIII.getValue(BlockNewLeaf.field_176240_P)).func_176839_a();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llIlllllllIIIll) {
        return this.getDefaultState().withProperty(BlockNewLeaf.field_176240_P, this.func_176233_b(llIlllllllIIIll)).withProperty(BlockNewLeaf.field_176237_a, (llIlllllllIIIll & 0x4) == 0x0).withProperty(BlockNewLeaf.field_176236_b, (llIlllllllIIIll & 0x8) > 0);
    }
    
    @Override
    public BlockPlanks.EnumType func_176233_b(final int llIllllllIlIlII) {
        return BlockPlanks.EnumType.func_176837_a((llIllllllIlIlII & 0x3) + 4);
    }
    
    @Override
    protected void func_176234_a(final World lllIIIIIIIIlIlI, final BlockPos lllIIIIIIIIIlIl, final IBlockState lllIIIIIIIIIlII, final int lllIIIIIIIIIIll) {
        if (lllIIIIIIIIIlII.getValue(BlockNewLeaf.field_176240_P) == BlockPlanks.EnumType.DARK_OAK && lllIIIIIIIIlIlI.rand.nextInt(lllIIIIIIIIIIll) == 0) {
            Block.spawnAsEntity(lllIIIIIIIIlIlI, lllIIIIIIIIIlIl, new ItemStack(Items.apple, 1, 0));
        }
    }
    
    @Override
    public int getDamageValue(final World llIlllllllllIlI, final BlockPos llIllllllllIllI) {
        final IBlockState llIlllllllllIII = llIlllllllllIlI.getBlockState(llIllllllllIllI);
        return llIlllllllllIII.getBlock().getMetaFromState(llIlllllllllIII) & 0x3;
    }
    
    @Override
    public void getSubBlocks(final Item llIllllllllIIIl, final CreativeTabs llIllllllllIIII, final List llIlllllllIllll) {
        llIlllllllIllll.add(new ItemStack(llIllllllllIIIl, 1, 0));
        llIlllllllIllll.add(new ItemStack(llIllllllllIIIl, 1, 1));
    }
}
