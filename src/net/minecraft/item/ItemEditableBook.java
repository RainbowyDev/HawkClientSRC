package net.minecraft.item;

import net.minecraft.command.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.stats.*;

public class ItemEditableBook extends Item
{
    static {
        __OBFID = "CL_00000077";
    }
    
    public static int func_179230_h(final ItemStack llllllllllllllIllIIlIlIlIIlIIIlI) {
        return llllllllllllllIllIIlIlIlIIlIIIlI.getTagCompound().getInteger("generation");
    }
    
    public static boolean validBookTagContents(final NBTTagCompound llllllllllllllIllIIlIlIlIIlIIlll) {
        if (!ItemWritableBook.validBookPageTagContents(llllllllllllllIllIIlIlIlIIlIIlll)) {
            return false;
        }
        if (!llllllllllllllIllIIlIlIlIIlIIlll.hasKey("title", 8)) {
            return false;
        }
        final String llllllllllllllIllIIlIlIlIIlIIllI = llllllllllllllIllIIlIlIlIIlIIlll.getString("title");
        return llllllllllllllIllIIlIlIlIIlIIllI != null && llllllllllllllIllIIlIlIlIIlIIllI.length() <= 32 && llllllllllllllIllIIlIlIlIIlIIlll.hasKey("author", 8);
    }
    
    private void func_179229_a(final ItemStack llllllllllllllIllIIlIlIIlllIIlIl, final EntityPlayer llllllllllllllIllIIlIlIIlllIIlII) {
        if (llllllllllllllIllIIlIlIIlllIIlIl != null && llllllllllllllIllIIlIlIIlllIIlIl.getTagCompound() != null) {
            final NBTTagCompound llllllllllllllIllIIlIlIIlllIlllI = llllllllllllllIllIIlIlIIlllIIlIl.getTagCompound();
            if (!llllllllllllllIllIIlIlIIlllIlllI.getBoolean("resolved")) {
                llllllllllllllIllIIlIlIIlllIlllI.setBoolean("resolved", true);
                if (validBookTagContents(llllllllllllllIllIIlIlIIlllIlllI)) {
                    final NBTTagList llllllllllllllIllIIlIlIIlllIllIl = llllllllllllllIllIIlIlIIlllIlllI.getTagList("pages", 8);
                    for (int llllllllllllllIllIIlIlIIlllIllII = 0; llllllllllllllIllIIlIlIIlllIllII < llllllllllllllIllIIlIlIIlllIllIl.tagCount(); ++llllllllllllllIllIIlIlIIlllIllII) {
                        final String llllllllllllllIllIIlIlIIlllIlIll = llllllllllllllIllIIlIlIIlllIllIl.getStringTagAt(llllllllllllllIllIIlIlIIlllIllII);
                        Object llllllllllllllIllIIlIlIIlllIlIIl = null;
                        try {
                            final IChatComponent llllllllllllllIllIIlIlIIlllIlIII = IChatComponent.Serializer.jsonToComponent(llllllllllllllIllIIlIlIIlllIlIll);
                            final Object llllllllllllllIllIIlIlIIlllIlIlI = ChatComponentProcessor.func_179985_a(llllllllllllllIllIIlIlIIlllIIlII, llllllllllllllIllIIlIlIIlllIlIII, llllllllllllllIllIIlIlIIlllIIlII);
                        }
                        catch (Exception llllllllllllllIllIIlIlIIlllIIlll) {
                            llllllllllllllIllIIlIlIIlllIlIIl = new ChatComponentText(llllllllllllllIllIIlIlIIlllIlIll);
                        }
                        llllllllllllllIllIIlIlIIlllIllIl.set(llllllllllllllIllIIlIlIIlllIllII, new NBTTagString(IChatComponent.Serializer.componentToJson((IChatComponent)llllllllllllllIllIIlIlIIlllIlIIl)));
                    }
                    llllllllllllllIllIIlIlIIlllIlllI.setTag("pages", llllllllllllllIllIIlIlIIlllIllIl);
                    if (llllllllllllllIllIIlIlIIlllIIlII instanceof EntityPlayerMP && llllllllllllllIllIIlIlIIlllIIlII.getCurrentEquippedItem() == llllllllllllllIllIIlIlIIlllIIlIl) {
                        final Slot llllllllllllllIllIIlIlIIlllIIllI = llllllllllllllIllIIlIlIIlllIIlII.openContainer.getSlotFromInventory(llllllllllllllIllIIlIlIIlllIIlII.inventory, llllllllllllllIllIIlIlIIlllIIlII.inventory.currentItem);
                        ((EntityPlayerMP)llllllllllllllIllIIlIlIIlllIIlII).playerNetServerHandler.sendPacket(new S2FPacketSetSlot(0, llllllllllllllIllIIlIlIIlllIIllI.slotNumber, llllllllllllllIllIIlIlIIlllIIlIl));
                    }
                }
            }
        }
    }
    
    @Override
    public void addInformation(final ItemStack llllllllllllllIllIIlIlIlIIIIllll, final EntityPlayer llllllllllllllIllIIlIlIlIIIIlllI, final List llllllllllllllIllIIlIlIlIIIIllIl, final boolean llllllllllllllIllIIlIlIlIIIIllII) {
        if (llllllllllllllIllIIlIlIlIIIIllll.hasTagCompound()) {
            final NBTTagCompound llllllllllllllIllIIlIlIlIIIIlIll = llllllllllllllIllIIlIlIlIIIIllll.getTagCompound();
            final String llllllllllllllIllIIlIlIlIIIIlIlI = llllllllllllllIllIIlIlIlIIIIlIll.getString("author");
            if (!StringUtils.isNullOrEmpty(llllllllllllllIllIIlIlIlIIIIlIlI)) {
                llllllllllllllIllIIlIlIlIIIIllIl.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append(StatCollector.translateToLocalFormatted("book.byAuthor", llllllllllllllIllIIlIlIlIIIIlIlI))));
            }
            llllllllllllllIllIIlIlIlIIIIllIl.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append(StatCollector.translateToLocal(String.valueOf(new StringBuilder("book.generation.").append(llllllllllllllIllIIlIlIlIIIIlIll.getInteger("generation")))))));
        }
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack llllllllllllllIllIIlIlIlIIIllIll) {
        if (llllllllllllllIllIIlIlIlIIIllIll.hasTagCompound()) {
            final NBTTagCompound llllllllllllllIllIIlIlIlIIIllIlI = llllllllllllllIllIIlIlIlIIIllIll.getTagCompound();
            final String llllllllllllllIllIIlIlIlIIIllIIl = llllllllllllllIllIIlIlIlIIIllIlI.getString("title");
            if (!StringUtils.isNullOrEmpty(llllllllllllllIllIIlIlIlIIIllIIl)) {
                return llllllllllllllIllIIlIlIlIIIllIIl;
            }
        }
        return super.getItemStackDisplayName(llllllllllllllIllIIlIlIlIIIllIll);
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllIllIIlIlIlIIIIIIII, final World llllllllllllllIllIIlIlIIllllllll, final EntityPlayer llllllllllllllIllIIlIlIIlllllllI) {
        if (!llllllllllllllIllIIlIlIIllllllll.isRemote) {
            this.func_179229_a(llllllllllllllIllIIlIlIlIIIIIIII, llllllllllllllIllIIlIlIIlllllllI);
        }
        llllllllllllllIllIIlIlIIlllllllI.displayGUIBook(llllllllllllllIllIIlIlIlIIIIIIII);
        llllllllllllllIllIIlIlIIlllllllI.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return llllllllllllllIllIIlIlIlIIIIIIII;
    }
    
    public ItemEditableBook() {
        this.setMaxStackSize(1);
    }
    
    @Override
    public boolean hasEffect(final ItemStack llllllllllllllIllIIlIlIIllIlllII) {
        return true;
    }
}
