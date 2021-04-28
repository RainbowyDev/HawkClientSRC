package net.minecraft.entity;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.util.*;
import net.minecraft.village.*;
import net.minecraft.item.*;

public class NpcMerchant implements IMerchant
{
    private /* synthetic */ IChatComponent field_175548_d;
    private /* synthetic */ EntityPlayer customer;
    private /* synthetic */ MerchantRecipeList recipeList;
    private /* synthetic */ InventoryMerchant theMerchantInventory;
    
    @Override
    public IChatComponent getDisplayName() {
        return (this.field_175548_d != null) ? this.field_175548_d : new ChatComponentTranslation("entity.Villager.name", new Object[0]);
    }
    
    @Override
    public MerchantRecipeList getRecipes(final EntityPlayer lIIllIlIIlIIlll) {
        return this.recipeList;
    }
    
    static {
        __OBFID = "CL_00001705";
    }
    
    @Override
    public void setRecipes(final MerchantRecipeList lIIllIlIIlIIIlI) {
        this.recipeList = lIIllIlIIlIIIlI;
    }
    
    @Override
    public void useRecipe(final MerchantRecipe lIIllIlIIIlllIl) {
        lIIllIlIIIlllIl.incrementToolUses();
    }
    
    @Override
    public void setCustomer(final EntityPlayer lIIllIlIIlIlIlI) {
    }
    
    public NpcMerchant(final EntityPlayer lIIllIlIIllIIll, final IChatComponent lIIllIlIIllIIlI) {
        this.customer = lIIllIlIIllIIll;
        this.field_175548_d = lIIllIlIIllIIlI;
        this.theMerchantInventory = new InventoryMerchant(lIIllIlIIllIIll, this);
    }
    
    @Override
    public EntityPlayer getCustomer() {
        return this.customer;
    }
    
    @Override
    public void verifySellingItem(final ItemStack lIIllIlIIIllIlI) {
    }
}
