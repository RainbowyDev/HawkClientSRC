package net.minecraft.village;

import net.minecraft.nbt.*;
import net.minecraft.item.*;

public class MerchantRecipe
{
    private /* synthetic */ ItemStack itemToSell;
    private /* synthetic */ ItemStack secondItemToBuy;
    private /* synthetic */ boolean field_180323_f;
    private /* synthetic */ ItemStack itemToBuy;
    private /* synthetic */ int toolUses;
    private /* synthetic */ int maxTradeUses;
    
    static {
        __OBFID = "CL_00000126";
    }
    
    public NBTTagCompound writeToTags() {
        final NBTTagCompound llllllllllllllIlIIIIIlllIIIIIllI = new NBTTagCompound();
        llllllllllllllIlIIIIIlllIIIIIllI.setTag("buy", this.itemToBuy.writeToNBT(new NBTTagCompound()));
        llllllllllllllIlIIIIIlllIIIIIllI.setTag("sell", this.itemToSell.writeToNBT(new NBTTagCompound()));
        if (this.secondItemToBuy != null) {
            llllllllllllllIlIIIIIlllIIIIIllI.setTag("buyB", this.secondItemToBuy.writeToNBT(new NBTTagCompound()));
        }
        llllllllllllllIlIIIIIlllIIIIIllI.setInteger("uses", this.toolUses);
        llllllllllllllIlIIIIIlllIIIIIllI.setInteger("maxUses", this.maxTradeUses);
        llllllllllllllIlIIIIIlllIIIIIllI.setBoolean("rewardExp", this.field_180323_f);
        return llllllllllllllIlIIIIIlllIIIIIllI;
    }
    
    public ItemStack getItemToBuy() {
        return this.itemToBuy;
    }
    
    public boolean func_180322_j() {
        return this.field_180323_f;
    }
    
    public ItemStack getItemToSell() {
        return this.itemToSell;
    }
    
    public ItemStack getSecondItemToBuy() {
        return this.secondItemToBuy;
    }
    
    public void readFromTags(final NBTTagCompound llllllllllllllIlIIIIIlllIIIIllII) {
        final NBTTagCompound llllllllllllllIlIIIIIlllIIIIllll = llllllllllllllIlIIIIIlllIIIIllII.getCompoundTag("buy");
        this.itemToBuy = ItemStack.loadItemStackFromNBT(llllllllllllllIlIIIIIlllIIIIllll);
        final NBTTagCompound llllllllllllllIlIIIIIlllIIIIlllI = llllllllllllllIlIIIIIlllIIIIllII.getCompoundTag("sell");
        this.itemToSell = ItemStack.loadItemStackFromNBT(llllllllllllllIlIIIIIlllIIIIlllI);
        if (llllllllllllllIlIIIIIlllIIIIllII.hasKey("buyB", 10)) {
            this.secondItemToBuy = ItemStack.loadItemStackFromNBT(llllllllllllllIlIIIIIlllIIIIllII.getCompoundTag("buyB"));
        }
        if (llllllllllllllIlIIIIIlllIIIIllII.hasKey("uses", 99)) {
            this.toolUses = llllllllllllllIlIIIIIlllIIIIllII.getInteger("uses");
        }
        if (llllllllllllllIlIIIIIlllIIIIllII.hasKey("maxUses", 99)) {
            this.maxTradeUses = llllllllllllllIlIIIIIlllIIIIllII.getInteger("maxUses");
        }
        else {
            this.maxTradeUses = 7;
        }
        if (llllllllllllllIlIIIIIlllIIIIllII.hasKey("rewardExp", 1)) {
            this.field_180323_f = llllllllllllllIlIIIIIlllIIIIllII.getBoolean("rewardExp");
        }
        else {
            this.field_180323_f = true;
        }
    }
    
    public void incrementToolUses() {
        ++this.toolUses;
    }
    
    public void func_82785_h() {
        this.toolUses = this.maxTradeUses;
    }
    
    public MerchantRecipe(final NBTTagCompound llllllllllllllIlIIIIIlllIllIlIlI) {
        this.readFromTags(llllllllllllllIlIIIIIlllIllIlIlI);
    }
    
    public void func_82783_a(final int llllllllllllllIlIIIIIlllIIIlllll) {
        this.maxTradeUses += llllllllllllllIlIIIIIlllIIIlllll;
    }
    
    public MerchantRecipe(final ItemStack llllllllllllllIlIIIIIlllIlIlIIII, final ItemStack llllllllllllllIlIIIIIlllIlIlIlIl, final ItemStack llllllllllllllIlIIIIIlllIlIIlllI, final int llllllllllllllIlIIIIIlllIlIlIIll, final int llllllllllllllIlIIIIIlllIlIIllII) {
        this.itemToBuy = llllllllllllllIlIIIIIlllIlIlIIII;
        this.secondItemToBuy = llllllllllllllIlIIIIIlllIlIlIlIl;
        this.itemToSell = llllllllllllllIlIIIIIlllIlIIlllI;
        this.toolUses = llllllllllllllIlIIIIIlllIlIlIIll;
        this.maxTradeUses = llllllllllllllIlIIIIIlllIlIIllII;
        this.field_180323_f = true;
    }
    
    public int func_180321_e() {
        return this.toolUses;
    }
    
    public MerchantRecipe(final ItemStack llllllllllllllIlIIIIIlllIIlllllI, final Item llllllllllllllIlIIIIIlllIIlllIlI) {
        this(llllllllllllllIlIIIIIlllIIlllllI, new ItemStack(llllllllllllllIlIIIIIlllIIlllIlI));
    }
    
    public boolean isRecipeDisabled() {
        return this.toolUses >= this.maxTradeUses;
    }
    
    public boolean hasSecondItemToBuy() {
        return this.secondItemToBuy != null;
    }
    
    public int func_180320_f() {
        return this.maxTradeUses;
    }
    
    public MerchantRecipe(final ItemStack llllllllllllllIlIIIIIlllIlIIIlll, final ItemStack llllllllllllllIlIIIIIlllIlIIIllI) {
        this(llllllllllllllIlIIIIIlllIlIIIlll, null, llllllllllllllIlIIIIIlllIlIIIllI);
    }
    
    public MerchantRecipe(final ItemStack llllllllllllllIlIIIIIlllIllIIIII, final ItemStack llllllllllllllIlIIIIIlllIllIIIll, final ItemStack llllllllllllllIlIIIIIlllIllIIIlI) {
        this(llllllllllllllIlIIIIIlllIllIIIII, llllllllllllllIlIIIIIlllIllIIIll, llllllllllllllIlIIIIIlllIllIIIlI, 0, 7);
    }
}
