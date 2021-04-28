package net.minecraft.block;

import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.stats.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.world.*;

public class BlockIce extends BlockBreakable
{
    @Override
    public void harvestBlock(final World lllllllllllllllIlllIIlIIlllIIIIl, final EntityPlayer lllllllllllllllIlllIIlIIllIlIlll, final BlockPos lllllllllllllllIlllIIlIIllIlllll, final IBlockState lllllllllllllllIlllIIlIIllIlIlIl, final TileEntity lllllllllllllllIlllIIlIIllIlllIl) {
        lllllllllllllllIlllIIlIIllIlIlll.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
        lllllllllllllllIlllIIlIIllIlIlll.addExhaustion(0.025f);
        if (this.canSilkHarvest() && EnchantmentHelper.getSilkTouchModifier(lllllllllllllllIlllIIlIIllIlIlll)) {
            final ItemStack lllllllllllllllIlllIIlIIllIlllII = this.createStackedBlock(lllllllllllllllIlllIIlIIllIlIlIl);
            if (lllllllllllllllIlllIIlIIllIlllII != null) {
                Block.spawnAsEntity(lllllllllllllllIlllIIlIIlllIIIIl, lllllllllllllllIlllIIlIIllIlllll, lllllllllllllllIlllIIlIIllIlllII);
            }
        }
        else {
            if (lllllllllllllllIlllIIlIIlllIIIIl.provider.func_177500_n()) {
                lllllllllllllllIlllIIlIIlllIIIIl.setBlockToAir(lllllllllllllllIlllIIlIIllIlllll);
                return;
            }
            final int lllllllllllllllIlllIIlIIllIllIll = EnchantmentHelper.getFortuneModifier(lllllllllllllllIlllIIlIIllIlIlll);
            this.dropBlockAsItem(lllllllllllllllIlllIIlIIlllIIIIl, lllllllllllllllIlllIIlIIllIlllll, lllllllllllllllIlllIIlIIllIlIlIl, lllllllllllllllIlllIIlIIllIllIll);
            final Material lllllllllllllllIlllIIlIIllIllIlI = lllllllllllllllIlllIIlIIlllIIIIl.getBlockState(lllllllllllllllIlllIIlIIllIlllll.offsetDown()).getBlock().getMaterial();
            if (lllllllllllllllIlllIIlIIllIllIlI.blocksMovement() || lllllllllllllllIlllIIlIIllIllIlI.isLiquid()) {
                lllllllllllllllIlllIIlIIlllIIIIl.setBlockState(lllllllllllllllIlllIIlIIllIlllll, Blocks.flowing_water.getDefaultState());
            }
        }
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
    
    static {
        __OBFID = "CL_00000259";
    }
    
    public BlockIce() {
        super(Material.ice, false);
        this.slipperiness = 0.98f;
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllIlllIIlIIllIlIIIl) {
        return 0;
    }
    
    @Override
    public void updateTick(final World lllllllllllllllIlllIIlIIllIIIlll, final BlockPos lllllllllllllllIlllIIlIIllIIlIll, final IBlockState lllllllllllllllIlllIIlIIllIIlIlI, final Random lllllllllllllllIlllIIlIIllIIlIIl) {
        if (lllllllllllllllIlllIIlIIllIIIlll.getLightFor(EnumSkyBlock.BLOCK, lllllllllllllllIlllIIlIIllIIlIll) > 11 - this.getLightOpacity()) {
            if (lllllllllllllllIlllIIlIIllIIIlll.provider.func_177500_n()) {
                lllllllllllllllIlllIIlIIllIIIlll.setBlockToAir(lllllllllllllllIlllIIlIIllIIlIll);
            }
            else {
                this.dropBlockAsItem(lllllllllllllllIlllIIlIIllIIIlll, lllllllllllllllIlllIIlIIllIIlIll, lllllllllllllllIlllIIlIIllIIIlll.getBlockState(lllllllllllllllIlllIIlIIllIIlIll), 0);
                lllllllllllllllIlllIIlIIllIIIlll.setBlockState(lllllllllllllllIlllIIlIIllIIlIll, Blocks.water.getDefaultState());
            }
        }
    }
    
    @Override
    public int getMobilityFlag() {
        return 0;
    }
}
