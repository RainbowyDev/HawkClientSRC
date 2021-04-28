package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;

public class SlotFurnaceOutput extends Slot
{
    private /* synthetic */ int field_75228_b;
    private /* synthetic */ EntityPlayer thePlayer;
    
    @Override
    protected void onCrafting(final ItemStack llllllllllllllIIIllllIIIIlIIlIII) {
        llllllllllllllIIIllllIIIIlIIlIII.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field_75228_b);
        if (!this.thePlayer.worldObj.isRemote) {
            int llllllllllllllIIIllllIIIIlIIllIl = this.field_75228_b;
            final float llllllllllllllIIIllllIIIIlIIllII = FurnaceRecipes.instance().getSmeltingExperience(llllllllllllllIIIllllIIIIlIIlIII);
            if (llllllllllllllIIIllllIIIIlIIllII == 0.0f) {
                llllllllllllllIIIllllIIIIlIIllIl = 0;
            }
            else if (llllllllllllllIIIllllIIIIlIIllII < 1.0f) {
                int llllllllllllllIIIllllIIIIlIIlIll = MathHelper.floor_float(llllllllllllllIIIllllIIIIlIIllIl * llllllllllllllIIIllllIIIIlIIllII);
                if (llllllllllllllIIIllllIIIIlIIlIll < MathHelper.ceiling_float_int(llllllllllllllIIIllllIIIIlIIllIl * llllllllllllllIIIllllIIIIlIIllII) && Math.random() < llllllllllllllIIIllllIIIIlIIllIl * llllllllllllllIIIllllIIIIlIIllII - llllllllllllllIIIllllIIIIlIIlIll) {
                    ++llllllllllllllIIIllllIIIIlIIlIll;
                }
                llllllllllllllIIIllllIIIIlIIllIl = llllllllllllllIIIllllIIIIlIIlIll;
            }
            while (llllllllllllllIIIllllIIIIlIIllIl > 0) {
                final int llllllllllllllIIIllllIIIIlIIlIlI = EntityXPOrb.getXPSplit(llllllllllllllIIIllllIIIIlIIllIl);
                llllllllllllllIIIllllIIIIlIIllIl -= llllllllllllllIIIllllIIIIlIIlIlI;
                this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX, this.thePlayer.posY + 0.5, this.thePlayer.posZ + 0.5, llllllllllllllIIIllllIIIIlIIlIlI));
            }
        }
        this.field_75228_b = 0;
        if (llllllllllllllIIIllllIIIIlIIlIII.getItem() == Items.iron_ingot) {
            this.thePlayer.triggerAchievement(AchievementList.acquireIron);
        }
        if (llllllllllllllIIIllllIIIIlIIlIII.getItem() == Items.cooked_fish) {
            this.thePlayer.triggerAchievement(AchievementList.cookFish);
        }
    }
    
    @Override
    protected void onCrafting(final ItemStack llllllllllllllIIIllllIIIIlIlIllI, final int llllllllllllllIIIllllIIIIlIllIII) {
        this.field_75228_b += llllllllllllllIIIllllIIIIlIllIII;
        this.onCrafting(llllllllllllllIIIllllIIIIlIlIllI);
    }
    
    @Override
    public boolean isItemValid(final ItemStack llllllllllllllIIIllllIIIIllIllIl) {
        return false;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIIIllllIIIIllIIlll) {
        if (this.getHasStack()) {
            this.field_75228_b += Math.min(llllllllllllllIIIllllIIIIllIIlll, this.getStack().stackSize);
        }
        return super.decrStackSize(llllllllllllllIIIllllIIIIllIIlll);
    }
    
    static {
        __OBFID = "CL_00002183";
    }
    
    @Override
    public void onPickupFromSlot(final EntityPlayer llllllllllllllIIIllllIIIIllIIIlI, final ItemStack llllllllllllllIIIllllIIIIlIllllI) {
        this.onCrafting(llllllllllllllIIIllllIIIIlIllllI);
        super.onPickupFromSlot(llllllllllllllIIIllllIIIIllIIIlI, llllllllllllllIIIllllIIIIlIllllI);
    }
    
    public SlotFurnaceOutput(final EntityPlayer llllllllllllllIIIllllIIIIlllIIll, final IInventory llllllllllllllIIIllllIIIIllllIII, final int llllllllllllllIIIllllIIIIlllIIIl, final int llllllllllllllIIIllllIIIIlllIIII, final int llllllllllllllIIIllllIIIIlllIlIl) {
        super(llllllllllllllIIIllllIIIIllllIII, llllllllllllllIIIllllIIIIlllIIIl, llllllllllllllIIIllllIIIIlllIIII, llllllllllllllIIIllllIIIIlllIlIl);
        this.thePlayer = llllllllllllllIIIllllIIIIlllIIll;
    }
}
