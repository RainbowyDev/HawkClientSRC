package net.minecraft.client.gui.inventory;

import net.minecraft.client.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;
import java.util.*;

public class CreativeCrafting implements ICrafting
{
    private final /* synthetic */ Minecraft mc;
    
    static {
        __OBFID = "CL_00000751";
    }
    
    @Override
    public void sendSlotContents(final Container llllllllllllllllIlIIIIlllIlIllll, final int llllllllllllllllIlIIIIlllIlIlIll, final ItemStack llllllllllllllllIlIIIIlllIlIlIlI) {
        this.mc.playerController.sendSlotPacket(llllllllllllllllIlIIIIlllIlIlIlI, llllllllllllllllIlIIIIlllIlIlIll);
    }
    
    @Override
    public void func_175173_a(final Container llllllllllllllllIlIIIIlllIlIIlII, final IInventory llllllllllllllllIlIIIIlllIlIIIll) {
    }
    
    @Override
    public void sendProgressBarUpdate(final Container llllllllllllllllIlIIIIlllIlIlIII, final int llllllllllllllllIlIIIIlllIlIIlll, final int llllllllllllllllIlIIIIlllIlIIllI) {
    }
    
    @Override
    public void updateCraftingInventory(final Container llllllllllllllllIlIIIIlllIllIlIl, final List llllllllllllllllIlIIIIlllIllIlII) {
    }
    
    public CreativeCrafting(final Minecraft llllllllllllllllIlIIIIlllIllIlll) {
        this.mc = llllllllllllllllIlIIIIlllIllIlll;
    }
}
