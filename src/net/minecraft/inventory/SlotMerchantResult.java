package net.minecraft.inventory;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.stats.*;
import net.minecraft.village.*;

public class SlotMerchantResult extends Slot
{
    private final /* synthetic */ IMerchant theMerchant;
    private /* synthetic */ int field_75231_g;
    private /* synthetic */ EntityPlayer thePlayer;
    private final /* synthetic */ InventoryMerchant theMerchantInventory;
    
    @Override
    public boolean isItemValid(final ItemStack llllllllllllllIIIIIIIlIIIIIllllI) {
        return false;
    }
    
    @Override
    protected void onCrafting(final ItemStack llllllllllllllIIIIIIIlIIIIIIlIll) {
        llllllllllllllIIIIIIIlIIIIIIlIll.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field_75231_g);
        this.field_75231_g = 0;
    }
    
    static {
        __OBFID = "CL_00001758";
    }
    
    @Override
    public void onPickupFromSlot(final EntityPlayer llllllllllllllIIIIIIIlIIIIIIIIIl, final ItemStack llllllllllllllIIIIIIIlIIIIIIIIII) {
        this.onCrafting(llllllllllllllIIIIIIIlIIIIIIIIII);
        final MerchantRecipe llllllllllllllIIIIIIIIllllllllll = this.theMerchantInventory.getCurrentRecipe();
        if (llllllllllllllIIIIIIIIllllllllll != null) {
            ItemStack llllllllllllllIIIIIIIIlllllllllI = this.theMerchantInventory.getStackInSlot(0);
            ItemStack llllllllllllllIIIIIIIIllllllllIl = this.theMerchantInventory.getStackInSlot(1);
            if (this.doTrade(llllllllllllllIIIIIIIIllllllllll, llllllllllllllIIIIIIIIlllllllllI, llllllllllllllIIIIIIIIllllllllIl) || this.doTrade(llllllllllllllIIIIIIIIllllllllll, llllllllllllllIIIIIIIIllllllllIl, llllllllllllllIIIIIIIIlllllllllI)) {
                this.theMerchant.useRecipe(llllllllllllllIIIIIIIIllllllllll);
                llllllllllllllIIIIIIIlIIIIIIIIIl.triggerAchievement(StatList.timesTradedWithVillagerStat);
                if (llllllllllllllIIIIIIIIlllllllllI != null && llllllllllllllIIIIIIIIlllllllllI.stackSize <= 0) {
                    llllllllllllllIIIIIIIIlllllllllI = null;
                }
                if (llllllllllllllIIIIIIIIllllllllIl != null && llllllllllllllIIIIIIIIllllllllIl.stackSize <= 0) {
                    llllllllllllllIIIIIIIIllllllllIl = null;
                }
                this.theMerchantInventory.setInventorySlotContents(0, llllllllllllllIIIIIIIIlllllllllI);
                this.theMerchantInventory.setInventorySlotContents(1, llllllllllllllIIIIIIIIllllllllIl);
            }
        }
    }
    
    public SlotMerchantResult(final EntityPlayer llllllllllllllIIIIIIIlIIIIlIllII, final IMerchant llllllllllllllIIIIIIIlIIIIlIlIll, final InventoryMerchant llllllllllllllIIIIIIIlIIIIlIIIll, final int llllllllllllllIIIIIIIlIIIIlIlIIl, final int llllllllllllllIIIIIIIlIIIIlIIIIl, final int llllllllllllllIIIIIIIlIIIIlIIlll) {
        super(llllllllllllllIIIIIIIlIIIIlIIIll, llllllllllllllIIIIIIIlIIIIlIlIIl, llllllllllllllIIIIIIIlIIIIlIIIIl, llllllllllllllIIIIIIIlIIIIlIIlll);
        this.thePlayer = llllllllllllllIIIIIIIlIIIIlIllII;
        this.theMerchant = llllllllllllllIIIIIIIlIIIIlIlIll;
        this.theMerchantInventory = llllllllllllllIIIIIIIlIIIIlIIIll;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIIIIIIIlIIIIIllIlI) {
        if (this.getHasStack()) {
            this.field_75231_g += Math.min(llllllllllllllIIIIIIIlIIIIIllIlI, this.getStack().stackSize);
        }
        return super.decrStackSize(llllllllllllllIIIIIIIlIIIIIllIlI);
    }
    
    @Override
    protected void onCrafting(final ItemStack llllllllllllllIIIIIIIlIIIIIlIIll, final int llllllllllllllIIIIIIIlIIIIIlIIlI) {
        this.field_75231_g += llllllllllllllIIIIIIIlIIIIIlIIlI;
        this.onCrafting(llllllllllllllIIIIIIIlIIIIIlIIll);
    }
    
    private boolean doTrade(final MerchantRecipe llllllllllllllIIIIIIIIlllllIlIll, final ItemStack llllllllllllllIIIIIIIIlllllIllll, final ItemStack llllllllllllllIIIIIIIIlllllIlllI) {
        final ItemStack llllllllllllllIIIIIIIIlllllIllIl = llllllllllllllIIIIIIIIlllllIlIll.getItemToBuy();
        final ItemStack llllllllllllllIIIIIIIIlllllIllII = llllllllllllllIIIIIIIIlllllIlIll.getSecondItemToBuy();
        if (llllllllllllllIIIIIIIIlllllIllll != null && llllllllllllllIIIIIIIIlllllIllll.getItem() == llllllllllllllIIIIIIIIlllllIllIl.getItem()) {
            if (llllllllllllllIIIIIIIIlllllIllII != null && llllllllllllllIIIIIIIIlllllIlllI != null && llllllllllllllIIIIIIIIlllllIllII.getItem() == llllllllllllllIIIIIIIIlllllIlllI.getItem()) {
                llllllllllllllIIIIIIIIlllllIllll.stackSize -= llllllllllllllIIIIIIIIlllllIllIl.stackSize;
                llllllllllllllIIIIIIIIlllllIlllI.stackSize -= llllllllllllllIIIIIIIIlllllIllII.stackSize;
                return true;
            }
            if (llllllllllllllIIIIIIIIlllllIllII == null && llllllllllllllIIIIIIIIlllllIlllI == null) {
                llllllllllllllIIIIIIIIlllllIllll.stackSize -= llllllllllllllIIIIIIIIlllllIllIl.stackSize;
                return true;
            }
        }
        return false;
    }
}
