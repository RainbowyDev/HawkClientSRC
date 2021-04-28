package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;

public class SlotCrafting extends Slot
{
    private final /* synthetic */ InventoryCrafting craftMatrix;
    private final /* synthetic */ EntityPlayer thePlayer;
    private /* synthetic */ int amountCrafted;
    
    @Override
    protected void onCrafting(final ItemStack llllllllllllllIIIlIIIllIlllIIlll) {
        if (this.amountCrafted > 0) {
            llllllllllllllIIIlIIIllIlllIIlll.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.amountCrafted);
        }
        this.amountCrafted = 0;
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() == Item.getItemFromBlock(Blocks.crafting_table)) {
            this.thePlayer.triggerAchievement(AchievementList.buildWorkBench);
        }
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() instanceof ItemPickaxe) {
            this.thePlayer.triggerAchievement(AchievementList.buildPickaxe);
        }
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() == Item.getItemFromBlock(Blocks.furnace)) {
            this.thePlayer.triggerAchievement(AchievementList.buildFurnace);
        }
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() instanceof ItemHoe) {
            this.thePlayer.triggerAchievement(AchievementList.buildHoe);
        }
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() == Items.bread) {
            this.thePlayer.triggerAchievement(AchievementList.makeBread);
        }
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() == Items.cake) {
            this.thePlayer.triggerAchievement(AchievementList.bakeCake);
        }
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() instanceof ItemPickaxe && ((ItemPickaxe)llllllllllllllIIIlIIIllIlllIIlll.getItem()).getToolMaterial() != Item.ToolMaterial.WOOD) {
            this.thePlayer.triggerAchievement(AchievementList.buildBetterPickaxe);
        }
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() instanceof ItemSword) {
            this.thePlayer.triggerAchievement(AchievementList.buildSword);
        }
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() == Item.getItemFromBlock(Blocks.enchanting_table)) {
            this.thePlayer.triggerAchievement(AchievementList.enchantments);
        }
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() == Item.getItemFromBlock(Blocks.bookshelf)) {
            this.thePlayer.triggerAchievement(AchievementList.bookcase);
        }
        if (llllllllllllllIIIlIIIllIlllIIlll.getItem() == Items.golden_apple && llllllllllllllIIIlIIIllIlllIIlll.getMetadata() == 1) {
            this.thePlayer.triggerAchievement(AchievementList.overpowered);
        }
    }
    
    static {
        __OBFID = "CL_00001761";
    }
    
    @Override
    public boolean isItemValid(final ItemStack llllllllllllllIIIlIIIllIllllllII) {
        return false;
    }
    
    @Override
    public void onPickupFromSlot(final EntityPlayer llllllllllllllIIIlIIIllIllIllllI, final ItemStack llllllllllllllIIIlIIIllIllIlllIl) {
        this.onCrafting(llllllllllllllIIIlIIIllIllIlllIl);
        final ItemStack[] llllllllllllllIIIlIIIllIllIlllII = CraftingManager.getInstance().func_180303_b(this.craftMatrix, llllllllllllllIIIlIIIllIllIllllI.worldObj);
        for (int llllllllllllllIIIlIIIllIllIllIll = 0; llllllllllllllIIIlIIIllIllIllIll < llllllllllllllIIIlIIIllIllIlllII.length; ++llllllllllllllIIIlIIIllIllIllIll) {
            final ItemStack llllllllllllllIIIlIIIllIllIllIlI = this.craftMatrix.getStackInSlot(llllllllllllllIIIlIIIllIllIllIll);
            final ItemStack llllllllllllllIIIlIIIllIllIllIIl = llllllllllllllIIIlIIIllIllIlllII[llllllllllllllIIIlIIIllIllIllIll];
            if (llllllllllllllIIIlIIIllIllIllIlI != null) {
                this.craftMatrix.decrStackSize(llllllllllllllIIIlIIIllIllIllIll, 1);
            }
            if (llllllllllllllIIIlIIIllIllIllIIl != null) {
                if (this.craftMatrix.getStackInSlot(llllllllllllllIIIlIIIllIllIllIll) == null) {
                    this.craftMatrix.setInventorySlotContents(llllllllllllllIIIlIIIllIllIllIll, llllllllllllllIIIlIIIllIllIllIIl);
                }
                else if (!this.thePlayer.inventory.addItemStackToInventory(llllllllllllllIIIlIIIllIllIllIIl)) {
                    this.thePlayer.dropPlayerItemWithRandomChoice(llllllllllllllIIIlIIIllIllIllIIl, false);
                }
            }
        }
    }
    
    @Override
    protected void onCrafting(final ItemStack llllllllllllllIIIlIIIllIllllIIIl, final int llllllllllllllIIIlIIIllIllllIIII) {
        this.amountCrafted += llllllllllllllIIIlIIIllIllllIIII;
        this.onCrafting(llllllllllllllIIIlIIIllIllllIIIl);
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIIIlIIIllIlllllIII) {
        if (this.getHasStack()) {
            this.amountCrafted += Math.min(llllllllllllllIIIlIIIllIlllllIII, this.getStack().stackSize);
        }
        return super.decrStackSize(llllllllllllllIIIlIIIllIlllllIII);
    }
    
    public SlotCrafting(final EntityPlayer llllllllllllllIIIlIIIlllIIIIlIlI, final InventoryCrafting llllllllllllllIIIlIIIlllIIIIIIlI, final IInventory llllllllllllllIIIlIIIlllIIIIlIII, final int llllllllllllllIIIlIIIlllIIIIIIII, final int llllllllllllllIIIlIIIlllIIIIIllI, final int llllllllllllllIIIlIIIllIlllllllI) {
        super(llllllllllllllIIIlIIIlllIIIIlIII, llllllllllllllIIIlIIIlllIIIIIIII, llllllllllllllIIIlIIIlllIIIIIllI, llllllllllllllIIIlIIIllIlllllllI);
        this.thePlayer = llllllllllllllIIIlIIIlllIIIIlIlI;
        this.craftMatrix = llllllllllllllIIIlIIIlllIIIIIIlI;
    }
}
