package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;

public class EntityAIOcelotSit extends EntityAIMoveToBlock
{
    private final /* synthetic */ EntityOcelot field_151493_a;
    
    @Override
    public boolean continueExecuting() {
        return super.continueExecuting();
    }
    
    public EntityAIOcelotSit(final EntityOcelot llllllllllllllllIIllllIlllllllll, final double llllllllllllllllIIllllIllllllllI) {
        super(llllllllllllllllIIllllIlllllllll, llllllllllllllllIIllllIllllllllI, 8);
        this.field_151493_a = llllllllllllllllIIllllIlllllllll;
    }
    
    @Override
    public void startExecuting() {
        super.startExecuting();
        this.field_151493_a.getAISit().setSitting(false);
    }
    
    @Override
    public boolean shouldExecute() {
        return this.field_151493_a.isTamed() && !this.field_151493_a.isSitting() && super.shouldExecute();
    }
    
    static {
        __OBFID = "CL_00001601";
    }
    
    @Override
    protected boolean func_179488_a(final World llllllllllllllllIIllllIllllIIIII, final BlockPos llllllllllllllllIIllllIllllIIlII) {
        if (!llllllllllllllllIIllllIllllIIIII.isAirBlock(llllllllllllllllIIllllIllllIIlII.offsetUp())) {
            return false;
        }
        final IBlockState llllllllllllllllIIllllIllllIIIll = llllllllllllllllIIllllIllllIIIII.getBlockState(llllllllllllllllIIllllIllllIIlII);
        final Block llllllllllllllllIIllllIllllIIIlI = llllllllllllllllIIllllIllllIIIll.getBlock();
        if (llllllllllllllllIIllllIllllIIIlI == Blocks.chest) {
            final TileEntity llllllllllllllllIIllllIllllIIIIl = llllllllllllllllIIllllIllllIIIII.getTileEntity(llllllllllllllllIIllllIllllIIlII);
            if (llllllllllllllllIIllllIllllIIIIl instanceof TileEntityChest && ((TileEntityChest)llllllllllllllllIIllllIllllIIIIl).numPlayersUsing < 1) {
                return true;
            }
        }
        else {
            if (llllllllllllllllIIllllIllllIIIlI == Blocks.lit_furnace) {
                return true;
            }
            if (llllllllllllllllIIllllIllllIIIlI == Blocks.bed && llllllllllllllllIIllllIllllIIIll.getValue(BlockBed.PART_PROP) != BlockBed.EnumPartType.HEAD) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void resetTask() {
        super.resetTask();
        this.field_151493_a.setSitting(false);
    }
    
    @Override
    public void updateTask() {
        super.updateTask();
        this.field_151493_a.getAISit().setSitting(false);
        if (!this.func_179487_f()) {
            this.field_151493_a.setSitting(false);
        }
        else if (!this.field_151493_a.isSitting()) {
            this.field_151493_a.setSitting(true);
        }
    }
}
