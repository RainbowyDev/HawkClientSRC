package net.minecraft.dispenser;

import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public abstract class BehaviorProjectileDispense extends BehaviorDefaultDispenseItem
{
    public ItemStack dispenseStack(final IBlockSource llllllllllllllllIlIllIlllIlIlllI, final ItemStack llllllllllllllllIlIllIlllIlIllIl) {
        final World llllllllllllllllIlIllIlllIllIIll = llllllllllllllllIlIllIlllIlIlllI.getWorld();
        final IPosition llllllllllllllllIlIllIlllIllIIlI = BlockDispenser.getDispensePosition(llllllllllllllllIlIllIlllIlIlllI);
        final EnumFacing llllllllllllllllIlIllIlllIllIIIl = BlockDispenser.getFacing(llllllllllllllllIlIllIlllIlIlllI.getBlockMetadata());
        final IProjectile llllllllllllllllIlIllIlllIllIIII = this.getProjectileEntity(llllllllllllllllIlIllIlllIllIIll, llllllllllllllllIlIllIlllIllIIlI);
        llllllllllllllllIlIllIlllIllIIII.setThrowableHeading(llllllllllllllllIlIllIlllIllIIIl.getFrontOffsetX(), llllllllllllllllIlIllIlllIllIIIl.getFrontOffsetY() + 0.1f, llllllllllllllllIlIllIlllIllIIIl.getFrontOffsetZ(), this.func_82500_b(), this.func_82498_a());
        llllllllllllllllIlIllIlllIllIIll.spawnEntityInWorld((Entity)llllllllllllllllIlIllIlllIllIIII);
        llllllllllllllllIlIllIlllIlIllIl.splitStack(1);
        return llllllllllllllllIlIllIlllIlIllIl;
    }
    
    protected float func_82498_a() {
        return 6.0f;
    }
    
    @Override
    protected void playDispenseSound(final IBlockSource llllllllllllllllIlIllIlllIIlllll) {
        llllllllllllllllIlIllIlllIIlllll.getWorld().playAuxSFX(1002, llllllllllllllllIlIllIlllIIlllll.getBlockPos(), 0);
    }
    
    protected float func_82500_b() {
        return 1.1f;
    }
    
    static {
        __OBFID = "CL_00001394";
    }
    
    protected abstract IProjectile getProjectileEntity(final World p0, final IPosition p1);
}
