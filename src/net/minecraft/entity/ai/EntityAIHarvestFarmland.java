package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;

public class EntityAIHarvestFarmland extends EntityAIMoveToBlock
{
    private final /* synthetic */ EntityVillager field_179504_c;
    private /* synthetic */ boolean field_179503_e;
    private /* synthetic */ int field_179501_f;
    private /* synthetic */ boolean field_179502_d;
    
    @Override
    public void resetTask() {
        super.resetTask();
    }
    
    @Override
    public boolean continueExecuting() {
        return this.field_179501_f >= 0 && super.continueExecuting();
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.field_179496_a <= 0) {
            if (!this.field_179504_c.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                return false;
            }
            this.field_179501_f = -1;
            this.field_179502_d = this.field_179504_c.func_175556_cs();
            this.field_179503_e = this.field_179504_c.func_175557_cr();
        }
        return super.shouldExecute();
    }
    
    public EntityAIHarvestFarmland(final EntityVillager llllllllllllllIIlIlIIIIlllIIllIl, final double llllllllllllllIIlIlIIIIlllIIllll) {
        super(llllllllllllllIIlIlIIIIlllIIllIl, llllllllllllllIIlIlIIIIlllIIllll, 16);
        this.field_179504_c = llllllllllllllIIlIlIIIIlllIIllIl;
    }
    
    static {
        __OBFID = "CL_00002253";
    }
    
    @Override
    protected boolean func_179488_a(final World llllllllllllllIIlIlIIIIllIIllIIl, BlockPos llllllllllllllIIlIlIIIIllIIlllIl) {
        Block llllllllllllllIIlIlIIIIllIIlllII = llllllllllllllIIlIlIIIIllIIllIIl.getBlockState(llllllllllllllIIlIlIIIIllIIlllIl).getBlock();
        if (llllllllllllllIIlIlIIIIllIIlllII == Blocks.farmland) {
            llllllllllllllIIlIlIIIIllIIlllIl = llllllllllllllIIlIlIIIIllIIlllIl.offsetUp();
            final IBlockState llllllllllllllIIlIlIIIIllIIllIll = llllllllllllllIIlIlIIIIllIIllIIl.getBlockState(llllllllllllllIIlIlIIIIllIIlllIl);
            llllllllllllllIIlIlIIIIllIIlllII = llllllllllllllIIlIlIIIIllIIllIll.getBlock();
            if (llllllllllllllIIlIlIIIIllIIlllII instanceof BlockCrops && (int)llllllllllllllIIlIlIIIIllIIllIll.getValue(BlockCrops.AGE) == 7 && this.field_179503_e && (this.field_179501_f == 0 || this.field_179501_f < 0)) {
                this.field_179501_f = 0;
                return true;
            }
            if (llllllllllllllIIlIlIIIIllIIlllII == Blocks.air && this.field_179502_d && (this.field_179501_f == 1 || this.field_179501_f < 0)) {
                this.field_179501_f = 1;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void startExecuting() {
        super.startExecuting();
    }
    
    @Override
    public void updateTask() {
        super.updateTask();
        this.field_179504_c.getLookHelper().setLookPosition(this.field_179494_b.getX() + 0.5, this.field_179494_b.getY() + 1, this.field_179494_b.getZ() + 0.5, 10.0f, (float)this.field_179504_c.getVerticalFaceSpeed());
        if (this.func_179487_f()) {
            final World llllllllllllllIIlIlIIIIllIllIlIl = this.field_179504_c.worldObj;
            final BlockPos llllllllllllllIIlIlIIIIllIllIlII = this.field_179494_b.offsetUp();
            final IBlockState llllllllllllllIIlIlIIIIllIllIIll = llllllllllllllIIlIlIIIIllIllIlIl.getBlockState(llllllllllllllIIlIlIIIIllIllIlII);
            final Block llllllllllllllIIlIlIIIIllIllIIlI = llllllllllllllIIlIlIIIIllIllIIll.getBlock();
            if (this.field_179501_f == 0 && llllllllllllllIIlIlIIIIllIllIIlI instanceof BlockCrops && (int)llllllllllllllIIlIlIIIIllIllIIll.getValue(BlockCrops.AGE) == 7) {
                llllllllllllllIIlIlIIIIllIllIlIl.destroyBlock(llllllllllllllIIlIlIIIIllIllIlII, true);
            }
            else if (this.field_179501_f == 1 && llllllllllllllIIlIlIIIIllIllIIlI == Blocks.air) {
                final InventoryBasic llllllllllllllIIlIlIIIIllIllIIIl = this.field_179504_c.func_175551_co();
                int llllllllllllllIIlIlIIIIllIllIIII = 0;
                while (llllllllllllllIIlIlIIIIllIllIIII < llllllllllllllIIlIlIIIIllIllIIIl.getSizeInventory()) {
                    final ItemStack llllllllllllllIIlIlIIIIllIlIllll = llllllllllllllIIlIlIIIIllIllIIIl.getStackInSlot(llllllllllllllIIlIlIIIIllIllIIII);
                    boolean llllllllllllllIIlIlIIIIllIlIlllI = false;
                    if (llllllllllllllIIlIlIIIIllIlIllll != null) {
                        if (llllllllllllllIIlIlIIIIllIlIllll.getItem() == Items.wheat_seeds) {
                            llllllllllllllIIlIlIIIIllIllIlIl.setBlockState(llllllllllllllIIlIlIIIIllIllIlII, Blocks.wheat.getDefaultState(), 3);
                            llllllllllllllIIlIlIIIIllIlIlllI = true;
                        }
                        else if (llllllllllllllIIlIlIIIIllIlIllll.getItem() == Items.potato) {
                            llllllllllllllIIlIlIIIIllIllIlIl.setBlockState(llllllllllllllIIlIlIIIIllIllIlII, Blocks.potatoes.getDefaultState(), 3);
                            llllllllllllllIIlIlIIIIllIlIlllI = true;
                        }
                        else if (llllllllllllllIIlIlIIIIllIlIllll.getItem() == Items.carrot) {
                            llllllllllllllIIlIlIIIIllIllIlIl.setBlockState(llllllllllllllIIlIlIIIIllIllIlII, Blocks.carrots.getDefaultState(), 3);
                            llllllllllllllIIlIlIIIIllIlIlllI = true;
                        }
                    }
                    if (llllllllllllllIIlIlIIIIllIlIlllI) {
                        final ItemStack itemStack = llllllllllllllIIlIlIIIIllIlIllll;
                        --itemStack.stackSize;
                        if (llllllllllllllIIlIlIIIIllIlIllll.stackSize <= 0) {
                            llllllllllllllIIlIlIIIIllIllIIIl.setInventorySlotContents(llllllllllllllIIlIlIIIIllIllIIII, null);
                            break;
                        }
                        break;
                    }
                    else {
                        ++llllllllllllllIIlIlIIIIllIllIIII;
                    }
                }
            }
            this.field_179501_f = -1;
            this.field_179496_a = 10;
        }
    }
}
