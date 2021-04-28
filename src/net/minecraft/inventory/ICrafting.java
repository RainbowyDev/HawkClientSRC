package net.minecraft.inventory;

import net.minecraft.item.*;
import java.util.*;

public interface ICrafting
{
    void func_175173_a(final Container p0, final IInventory p1);
    
    void sendProgressBarUpdate(final Container p0, final int p1, final int p2);
    
    void sendSlotContents(final Container p0, final int p1, final ItemStack p2);
    
    void updateCraftingInventory(final Container p0, final List p1);
}
