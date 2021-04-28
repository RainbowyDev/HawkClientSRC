package net.minecraft.dispenser;

import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;

public class BehaviorDefaultDispenseItem implements IBehaviorDispenseItem
{
    protected void playDispenseSound(final IBlockSource llllllllllllllllIlIllIIllIIlllIl) {
        llllllllllllllllIlIllIIllIIlllIl.getWorld().playAuxSFX(1000, llllllllllllllllIlIllIIllIIlllIl.getBlockPos(), 0);
    }
    
    public static void doDispense(final World llllllllllllllllIlIllIIllIllIlII, final ItemStack llllllllllllllllIlIllIIllIlIlIIl, final int llllllllllllllllIlIllIIllIlIlIII, final EnumFacing llllllllllllllllIlIllIIllIlIIlll, final IPosition llllllllllllllllIlIllIIllIllIIII) {
        final double llllllllllllllllIlIllIIllIlIllll = llllllllllllllllIlIllIIllIllIIII.getX();
        double llllllllllllllllIlIllIIllIlIlllI = llllllllllllllllIlIllIIllIllIIII.getY();
        final double llllllllllllllllIlIllIIllIlIllIl = llllllllllllllllIlIllIIllIllIIII.getZ();
        if (llllllllllllllllIlIllIIllIlIIlll.getAxis() == EnumFacing.Axis.Y) {
            llllllllllllllllIlIllIIllIlIlllI -= 0.125;
        }
        else {
            llllllllllllllllIlIllIIllIlIlllI -= 0.15625;
        }
        final EntityItem llllllllllllllllIlIllIIllIlIllII = new EntityItem(llllllllllllllllIlIllIIllIllIlII, llllllllllllllllIlIllIIllIlIllll, llllllllllllllllIlIllIIllIlIlllI, llllllllllllllllIlIllIIllIlIllIl, llllllllllllllllIlIllIIllIlIlIIl);
        final double llllllllllllllllIlIllIIllIlIlIll = llllllllllllllllIlIllIIllIllIlII.rand.nextDouble() * 0.1 + 0.2;
        llllllllllllllllIlIllIIllIlIllII.motionX = llllllllllllllllIlIllIIllIlIIlll.getFrontOffsetX() * llllllllllllllllIlIllIIllIlIlIll;
        llllllllllllllllIlIllIIllIlIllII.motionY = 0.20000000298023224;
        llllllllllllllllIlIllIIllIlIllII.motionZ = llllllllllllllllIlIllIIllIlIIlll.getFrontOffsetZ() * llllllllllllllllIlIllIIllIlIlIll;
        final EntityItem entityItem = llllllllllllllllIlIllIIllIlIllII;
        entityItem.motionX += llllllllllllllllIlIllIIllIllIlII.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllllIlIllIIllIlIlIII;
        final EntityItem entityItem2 = llllllllllllllllIlIllIIllIlIllII;
        entityItem2.motionY += llllllllllllllllIlIllIIllIllIlII.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllllIlIllIIllIlIlIII;
        final EntityItem entityItem3 = llllllllllllllllIlIllIIllIlIllII;
        entityItem3.motionZ += llllllllllllllllIlIllIIllIllIlII.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllllIlIllIIllIlIlIII;
        llllllllllllllllIlIllIIllIllIlII.spawnEntityInWorld(llllllllllllllllIlIllIIllIlIllII);
    }
    
    protected ItemStack dispenseStack(final IBlockSource llllllllllllllllIlIllIIlllIIlIII, final ItemStack llllllllllllllllIlIllIIlllIIIIlI) {
        final EnumFacing llllllllllllllllIlIllIIlllIIIllI = BlockDispenser.getFacing(llllllllllllllllIlIllIIlllIIlIII.getBlockMetadata());
        final IPosition llllllllllllllllIlIllIIlllIIIlIl = BlockDispenser.getDispensePosition(llllllllllllllllIlIllIIlllIIlIII);
        final ItemStack llllllllllllllllIlIllIIlllIIIlII = llllllllllllllllIlIllIIlllIIIIlI.splitStack(1);
        doDispense(llllllllllllllllIlIllIIlllIIlIII.getWorld(), llllllllllllllllIlIllIIlllIIIlII, 6, llllllllllllllllIlIllIIlllIIIllI, llllllllllllllllIlIllIIlllIIIlIl);
        return llllllllllllllllIlIllIIlllIIIIlI;
    }
    
    @Override
    public final ItemStack dispense(final IBlockSource llllllllllllllllIlIllIIlllIlIIIl, final ItemStack llllllllllllllllIlIllIIlllIlIlII) {
        final ItemStack llllllllllllllllIlIllIIlllIlIIll = this.dispenseStack(llllllllllllllllIlIllIIlllIlIIIl, llllllllllllllllIlIllIIlllIlIlII);
        this.playDispenseSound(llllllllllllllllIlIllIIlllIlIIIl);
        this.spawnDispenseParticles(llllllllllllllllIlIllIIlllIlIIIl, BlockDispenser.getFacing(llllllllllllllllIlIllIIlllIlIIIl.getBlockMetadata()));
        return llllllllllllllllIlIllIIlllIlIIll;
    }
    
    static {
        __OBFID = "CL_00001195";
    }
    
    private int func_82488_a(final EnumFacing llllllllllllllllIlIllIIllIIlIIII) {
        return llllllllllllllllIlIllIIllIIlIIII.getFrontOffsetX() + 1 + (llllllllllllllllIlIllIIllIIlIIII.getFrontOffsetZ() + 1) * 3;
    }
    
    protected void spawnDispenseParticles(final IBlockSource llllllllllllllllIlIllIIllIIllIII, final EnumFacing llllllllllllllllIlIllIIllIIlIlll) {
        llllllllllllllllIlIllIIllIIllIII.getWorld().playAuxSFX(2000, llllllllllllllllIlIllIIllIIllIII.getBlockPos(), this.func_82488_a(llllllllllllllllIlIllIIllIIlIlll));
    }
}
