package net.minecraft.village;

import java.util.*;
import net.minecraft.network.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import java.io.*;

public class MerchantRecipeList extends ArrayList
{
    public MerchantRecipeList() {
    }
    
    public void readRecipiesFromTags(final NBTTagCompound lllllllllllllllIlllIlllIIIIlIlII) {
        final NBTTagList lllllllllllllllIlllIlllIIIIlIIll = lllllllllllllllIlllIlllIIIIlIlII.getTagList("Recipes", 10);
        for (int lllllllllllllllIlllIlllIIIIlIIlI = 0; lllllllllllllllIlllIlllIIIIlIIlI < lllllllllllllllIlllIlllIIIIlIIll.tagCount(); ++lllllllllllllllIlllIlllIIIIlIIlI) {
            final NBTTagCompound lllllllllllllllIlllIlllIIIIlIIIl = lllllllllllllllIlllIlllIIIIlIIll.getCompoundTagAt(lllllllllllllllIlllIlllIIIIlIIlI);
            this.add(new MerchantRecipe(lllllllllllllllIlllIlllIIIIlIIIl));
        }
    }
    
    public void func_151391_a(final PacketBuffer lllllllllllllllIlllIlllIIlIIIlII) {
        lllllllllllllllIlllIlllIIlIIIlII.writeByte((byte)(this.size() & 0xFF));
        for (int lllllllllllllllIlllIlllIIlIIIIll = 0; lllllllllllllllIlllIlllIIlIIIIll < this.size(); ++lllllllllllllllIlllIlllIIlIIIIll) {
            final MerchantRecipe lllllllllllllllIlllIlllIIlIIIIlI = this.get(lllllllllllllllIlllIlllIIlIIIIll);
            lllllllllllllllIlllIlllIIlIIIlII.writeItemStackToBuffer(lllllllllllllllIlllIlllIIlIIIIlI.getItemToBuy());
            lllllllllllllllIlllIlllIIlIIIlII.writeItemStackToBuffer(lllllllllllllllIlllIlllIIlIIIIlI.getItemToSell());
            final ItemStack lllllllllllllllIlllIlllIIlIIIIIl = lllllllllllllllIlllIlllIIlIIIIlI.getSecondItemToBuy();
            lllllllllllllllIlllIlllIIlIIIlII.writeBoolean(lllllllllllllllIlllIlllIIlIIIIIl != null);
            if (lllllllllllllllIlllIlllIIlIIIIIl != null) {
                lllllllllllllllIlllIlllIIlIIIlII.writeItemStackToBuffer(lllllllllllllllIlllIlllIIlIIIIIl);
            }
            lllllllllllllllIlllIlllIIlIIIlII.writeBoolean(lllllllllllllllIlllIlllIIlIIIIlI.isRecipeDisabled());
            lllllllllllllllIlllIlllIIlIIIlII.writeInt(lllllllllllllllIlllIlllIIlIIIIlI.func_180321_e());
            lllllllllllllllIlllIlllIIlIIIlII.writeInt(lllllllllllllllIlllIlllIIlIIIIlI.func_180320_f());
        }
    }
    
    public MerchantRecipe canRecipeBeUsed(final ItemStack lllllllllllllllIlllIlllIIlIIllll, final ItemStack lllllllllllllllIlllIlllIIlIlIlIl, final int lllllllllllllllIlllIlllIIlIIllIl) {
        if (lllllllllllllllIlllIlllIIlIIllIl > 0 && lllllllllllllllIlllIlllIIlIIllIl < this.size()) {
            final MerchantRecipe lllllllllllllllIlllIlllIIlIlIIll = this.get(lllllllllllllllIlllIlllIIlIIllIl);
            return (ItemStack.areItemsEqual(lllllllllllllllIlllIlllIIlIIllll, lllllllllllllllIlllIlllIIlIlIIll.getItemToBuy()) && ((lllllllllllllllIlllIlllIIlIlIlIl == null && !lllllllllllllllIlllIlllIIlIlIIll.hasSecondItemToBuy()) || (lllllllllllllllIlllIlllIIlIlIIll.hasSecondItemToBuy() && ItemStack.areItemsEqual(lllllllllllllllIlllIlllIIlIlIlIl, lllllllllllllllIlllIlllIIlIlIIll.getSecondItemToBuy()))) && lllllllllllllllIlllIlllIIlIIllll.stackSize >= lllllllllllllllIlllIlllIIlIlIIll.getItemToBuy().stackSize && (!lllllllllllllllIlllIlllIIlIlIIll.hasSecondItemToBuy() || lllllllllllllllIlllIlllIIlIlIlIl.stackSize >= lllllllllllllllIlllIlllIIlIlIIll.getSecondItemToBuy().stackSize)) ? lllllllllllllllIlllIlllIIlIlIIll : null;
        }
        for (int lllllllllllllllIlllIlllIIlIlIIlI = 0; lllllllllllllllIlllIlllIIlIlIIlI < this.size(); ++lllllllllllllllIlllIlllIIlIlIIlI) {
            final MerchantRecipe lllllllllllllllIlllIlllIIlIlIIIl = this.get(lllllllllllllllIlllIlllIIlIlIIlI);
            if (ItemStack.areItemsEqual(lllllllllllllllIlllIlllIIlIIllll, lllllllllllllllIlllIlllIIlIlIIIl.getItemToBuy()) && lllllllllllllllIlllIlllIIlIIllll.stackSize >= lllllllllllllllIlllIlllIIlIlIIIl.getItemToBuy().stackSize && ((!lllllllllllllllIlllIlllIIlIlIIIl.hasSecondItemToBuy() && lllllllllllllllIlllIlllIIlIlIlIl == null) || (lllllllllllllllIlllIlllIIlIlIIIl.hasSecondItemToBuy() && ItemStack.areItemsEqual(lllllllllllllllIlllIlllIIlIlIlIl, lllllllllllllllIlllIlllIIlIlIIIl.getSecondItemToBuy()) && lllllllllllllllIlllIlllIIlIlIlIl.stackSize >= lllllllllllllllIlllIlllIIlIlIIIl.getSecondItemToBuy().stackSize))) {
                return lllllllllllllllIlllIlllIIlIlIIIl;
            }
        }
        return null;
    }
    
    static {
        __OBFID = "CL_00000127";
    }
    
    public MerchantRecipeList(final NBTTagCompound lllllllllllllllIlllIlllIIllIIIII) {
        this.readRecipiesFromTags(lllllllllllllllIlllIlllIIllIIIII);
    }
    
    public NBTTagCompound getRecipiesAsTags() {
        final NBTTagCompound lllllllllllllllIlllIlllIIIIIIlIl = new NBTTagCompound();
        final NBTTagList lllllllllllllllIlllIlllIIIIIIlII = new NBTTagList();
        for (int lllllllllllllllIlllIlllIIIIIIIll = 0; lllllllllllllllIlllIlllIIIIIIIll < this.size(); ++lllllllllllllllIlllIlllIIIIIIIll) {
            final MerchantRecipe lllllllllllllllIlllIlllIIIIIIIlI = this.get(lllllllllllllllIlllIlllIIIIIIIll);
            lllllllllllllllIlllIlllIIIIIIlII.appendTag(lllllllllllllllIlllIlllIIIIIIIlI.writeToTags());
        }
        lllllllllllllllIlllIlllIIIIIIlIl.setTag("Recipes", lllllllllllllllIlllIlllIIIIIIlII);
        return lllllllllllllllIlllIlllIIIIIIlIl;
    }
    
    public static MerchantRecipeList func_151390_b(final PacketBuffer lllllllllllllllIlllIlllIIIllIIII) throws IOException {
        final MerchantRecipeList lllllllllllllllIlllIlllIIIlIllll = new MerchantRecipeList();
        for (int lllllllllllllllIlllIlllIIIlIlllI = lllllllllllllllIlllIlllIIIllIIII.readByte() & 0xFF, lllllllllllllllIlllIlllIIIlIllIl = 0; lllllllllllllllIlllIlllIIIlIllIl < lllllllllllllllIlllIlllIIIlIlllI; ++lllllllllllllllIlllIlllIIIlIllIl) {
            final ItemStack lllllllllllllllIlllIlllIIIlIllII = lllllllllllllllIlllIlllIIIllIIII.readItemStackFromBuffer();
            final ItemStack lllllllllllllllIlllIlllIIIlIlIll = lllllllllllllllIlllIlllIIIllIIII.readItemStackFromBuffer();
            ItemStack lllllllllllllllIlllIlllIIIlIlIlI = null;
            if (lllllllllllllllIlllIlllIIIllIIII.readBoolean()) {
                lllllllllllllllIlllIlllIIIlIlIlI = lllllllllllllllIlllIlllIIIllIIII.readItemStackFromBuffer();
            }
            final boolean lllllllllllllllIlllIlllIIIlIlIIl = lllllllllllllllIlllIlllIIIllIIII.readBoolean();
            final int lllllllllllllllIlllIlllIIIlIlIII = lllllllllllllllIlllIlllIIIllIIII.readInt();
            final int lllllllllllllllIlllIlllIIIlIIlll = lllllllllllllllIlllIlllIIIllIIII.readInt();
            final MerchantRecipe lllllllllllllllIlllIlllIIIlIIllI = new MerchantRecipe(lllllllllllllllIlllIlllIIIlIllII, lllllllllllllllIlllIlllIIIlIlIlI, lllllllllllllllIlllIlllIIIlIlIll, lllllllllllllllIlllIlllIIIlIlIII, lllllllllllllllIlllIlllIIIlIIlll);
            if (lllllllllllllllIlllIlllIIIlIlIIl) {
                lllllllllllllllIlllIlllIIIlIIllI.func_82785_h();
            }
            lllllllllllllllIlllIlllIIIlIllll.add(lllllllllllllllIlllIlllIIIlIIllI);
        }
        return lllllllllllllllIlllIlllIIIlIllll;
    }
}
