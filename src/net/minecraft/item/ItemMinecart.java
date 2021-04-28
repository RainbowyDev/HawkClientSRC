package net.minecraft.item;

import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.dispenser.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class ItemMinecart extends Item
{
    private static final /* synthetic */ IBehaviorDispenseItem dispenserMinecartBehavior;
    private final /* synthetic */ EntityMinecart.EnumMinecartType minecartType;
    
    @Override
    public boolean onItemUse(final ItemStack llllllllllllllIIIIIlIIllIIIIIIll, final EntityPlayer llllllllllllllIIIIIlIIllIIIIIIlI, final World llllllllllllllIIIIIlIIlIllllIlIl, final BlockPos llllllllllllllIIIIIlIIlIllllIlII, final EnumFacing llllllllllllllIIIIIlIIlIllllllll, final float llllllllllllllIIIIIlIIlIlllllllI, final float llllllllllllllIIIIIlIIlIllllllIl, final float llllllllllllllIIIIIlIIlIllllllII) {
        final IBlockState llllllllllllllIIIIIlIIlIlllllIll = llllllllllllllIIIIIlIIlIllllIlIl.getBlockState(llllllllllllllIIIIIlIIlIllllIlII);
        if (BlockRailBase.func_176563_d(llllllllllllllIIIIIlIIlIlllllIll)) {
            if (!llllllllllllllIIIIIlIIlIllllIlIl.isRemote) {
                final BlockRailBase.EnumRailDirection llllllllllllllIIIIIlIIlIlllllIlI = (BlockRailBase.EnumRailDirection)((llllllllllllllIIIIIlIIlIlllllIll.getBlock() instanceof BlockRailBase) ? llllllllllllllIIIIIlIIlIlllllIll.getValue(((BlockRailBase)llllllllllllllIIIIIlIIlIlllllIll.getBlock()).func_176560_l()) : BlockRailBase.EnumRailDirection.NORTH_SOUTH);
                double llllllllllllllIIIIIlIIlIlllllIIl = 0.0;
                if (llllllllllllllIIIIIlIIlIlllllIlI.func_177018_c()) {
                    llllllllllllllIIIIIlIIlIlllllIIl = 0.5;
                }
                final EntityMinecart llllllllllllllIIIIIlIIlIlllllIII = EntityMinecart.func_180458_a(llllllllllllllIIIIIlIIlIllllIlIl, llllllllllllllIIIIIlIIlIllllIlII.getX() + 0.5, llllllllllllllIIIIIlIIlIllllIlII.getY() + 0.0625 + llllllllllllllIIIIIlIIlIlllllIIl, llllllllllllllIIIIIlIIlIllllIlII.getZ() + 0.5, this.minecartType);
                if (llllllllllllllIIIIIlIIllIIIIIIll.hasDisplayName()) {
                    llllllllllllllIIIIIlIIlIlllllIII.setCustomNameTag(llllllllllllllIIIIIlIIllIIIIIIll.getDisplayName());
                }
                llllllllllllllIIIIIlIIlIllllIlIl.spawnEntityInWorld(llllllllllllllIIIIIlIIlIlllllIII);
            }
            --llllllllllllllIIIIIlIIllIIIIIIll.stackSize;
            return true;
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00000049";
        dispenserMinecartBehavior = new BehaviorDefaultDispenseItem() {
            private final /* synthetic */ BehaviorDefaultDispenseItem behaviourDefaultDispenseItem = new BehaviorDefaultDispenseItem();
            
            public ItemStack dispenseStack(final IBlockSource lllllllllllllllIIlIlIlllllIIlIIl, final ItemStack lllllllllllllllIIlIlIlllllIllIlI) {
                final EnumFacing lllllllllllllllIIlIlIlllllIllIIl = BlockDispenser.getFacing(lllllllllllllllIIlIlIlllllIIlIIl.getBlockMetadata());
                final World lllllllllllllllIIlIlIlllllIllIII = lllllllllllllllIIlIlIlllllIIlIIl.getWorld();
                final double lllllllllllllllIIlIlIlllllIlIlll = lllllllllllllllIIlIlIlllllIIlIIl.getX() + lllllllllllllllIIlIlIlllllIllIIl.getFrontOffsetX() * 1.125;
                final double lllllllllllllllIIlIlIlllllIlIllI = Math.floor(lllllllllllllllIIlIlIlllllIIlIIl.getY()) + lllllllllllllllIIlIlIlllllIllIIl.getFrontOffsetY();
                final double lllllllllllllllIIlIlIlllllIlIlIl = lllllllllllllllIIlIlIlllllIIlIIl.getZ() + lllllllllllllllIIlIlIlllllIllIIl.getFrontOffsetZ() * 1.125;
                final BlockPos lllllllllllllllIIlIlIlllllIlIlII = lllllllllllllllIIlIlIlllllIIlIIl.getBlockPos().offset(lllllllllllllllIIlIlIlllllIllIIl);
                final IBlockState lllllllllllllllIIlIlIlllllIlIIll = lllllllllllllllIIlIlIlllllIllIII.getBlockState(lllllllllllllllIIlIlIlllllIlIlII);
                final BlockRailBase.EnumRailDirection lllllllllllllllIIlIlIlllllIlIIlI = (BlockRailBase.EnumRailDirection)((lllllllllllllllIIlIlIlllllIlIIll.getBlock() instanceof BlockRailBase) ? lllllllllllllllIIlIlIlllllIlIIll.getValue(((BlockRailBase)lllllllllllllllIIlIlIlllllIlIIll.getBlock()).func_176560_l()) : BlockRailBase.EnumRailDirection.NORTH_SOUTH);
                double lllllllllllllllIIlIlIlllllIIlllI = 0.0;
                if (BlockRailBase.func_176563_d(lllllllllllllllIIlIlIlllllIlIIll)) {
                    if (lllllllllllllllIIlIlIlllllIlIIlI.func_177018_c()) {
                        final double lllllllllllllllIIlIlIlllllIlIIIl = 0.6;
                    }
                    else {
                        final double lllllllllllllllIIlIlIlllllIlIIII = 0.1;
                    }
                }
                else {
                    if (lllllllllllllllIIlIlIlllllIlIIll.getBlock().getMaterial() != Material.air || !BlockRailBase.func_176563_d(lllllllllllllllIIlIlIlllllIllIII.getBlockState(lllllllllllllllIIlIlIlllllIlIlII.offsetDown()))) {
                        return this.behaviourDefaultDispenseItem.dispense(lllllllllllllllIIlIlIlllllIIlIIl, lllllllllllllllIIlIlIlllllIllIlI);
                    }
                    final IBlockState lllllllllllllllIIlIlIlllllIIllIl = lllllllllllllllIIlIlIlllllIllIII.getBlockState(lllllllllllllllIIlIlIlllllIlIlII.offsetDown());
                    final BlockRailBase.EnumRailDirection lllllllllllllllIIlIlIlllllIIllII = (BlockRailBase.EnumRailDirection)((lllllllllllllllIIlIlIlllllIIllIl.getBlock() instanceof BlockRailBase) ? lllllllllllllllIIlIlIlllllIIllIl.getValue(((BlockRailBase)lllllllllllllllIIlIlIlllllIIllIl.getBlock()).func_176560_l()) : BlockRailBase.EnumRailDirection.NORTH_SOUTH);
                    if (lllllllllllllllIIlIlIlllllIllIIl != EnumFacing.DOWN && lllllllllllllllIIlIlIlllllIIllII.func_177018_c()) {
                        final double lllllllllllllllIIlIlIlllllIIllll = -0.4;
                    }
                    else {
                        lllllllllllllllIIlIlIlllllIIlllI = -0.9;
                    }
                }
                final EntityMinecart lllllllllllllllIIlIlIlllllIIlIll = EntityMinecart.func_180458_a(lllllllllllllllIIlIlIlllllIllIII, lllllllllllllllIIlIlIlllllIlIlll, lllllllllllllllIIlIlIlllllIlIllI + lllllllllllllllIIlIlIlllllIIlllI, lllllllllllllllIIlIlIlllllIlIlIl, ((ItemMinecart)lllllllllllllllIIlIlIlllllIllIlI.getItem()).minecartType);
                if (lllllllllllllllIIlIlIlllllIllIlI.hasDisplayName()) {
                    lllllllllllllllIIlIlIlllllIIlIll.setCustomNameTag(lllllllllllllllIIlIlIlllllIllIlI.getDisplayName());
                }
                lllllllllllllllIIlIlIlllllIllIII.spawnEntityInWorld(lllllllllllllllIIlIlIlllllIIlIll);
                lllllllllllllllIIlIlIlllllIllIlI.splitStack(1);
                return lllllllllllllllIIlIlIlllllIllIlI;
            }
            
            static {
                __OBFID = "CL_00000050";
            }
            
            @Override
            protected void playDispenseSound(final IBlockSource lllllllllllllllIIlIlIllllIlllIIl) {
                lllllllllllllllIIlIlIllllIlllIIl.getWorld().playAuxSFX(1000, lllllllllllllllIIlIlIllllIlllIIl.getBlockPos(), 0);
            }
        };
    }
    
    public ItemMinecart(final EntityMinecart.EnumMinecartType llllllllllllllIIIIIlIIllIIIIllll) {
        this.maxStackSize = 1;
        this.minecartType = llllllllllllllIIIIIlIIllIIIIllll;
        this.setCreativeTab(CreativeTabs.tabTransport);
        BlockDispenser.dispenseBehaviorRegistry.putObject(this, ItemMinecart.dispenserMinecartBehavior);
    }
}
