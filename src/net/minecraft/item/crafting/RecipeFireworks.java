package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import net.minecraft.item.*;
import java.util.*;

public class RecipeFireworks implements IRecipe
{
    private /* synthetic */ ItemStack field_92102_a;
    
    @Override
    public boolean matches(final InventoryCrafting lllllllllllllllIllIIlIIllllIIIII, final World lllllllllllllllIllIIlIIlllIlllll) {
        this.field_92102_a = null;
        int lllllllllllllllIllIIlIIlllIllllI = 0;
        int lllllllllllllllIllIIlIIlllIlllIl = 0;
        int lllllllllllllllIllIIlIIlllIlllII = 0;
        int lllllllllllllllIllIIlIIlllIllIll = 0;
        int lllllllllllllllIllIIlIIlllIllIlI = 0;
        int lllllllllllllllIllIIlIIlllIllIIl = 0;
        for (int lllllllllllllllIllIIlIIlllIllIII = 0; lllllllllllllllIllIIlIIlllIllIII < lllllllllllllllIllIIlIIllllIIIII.getSizeInventory(); ++lllllllllllllllIllIIlIIlllIllIII) {
            final ItemStack lllllllllllllllIllIIlIIlllIlIlll = lllllllllllllllIllIIlIIllllIIIII.getStackInSlot(lllllllllllllllIllIIlIIlllIllIII);
            if (lllllllllllllllIllIIlIIlllIlIlll != null) {
                if (lllllllllllllllIllIIlIIlllIlIlll.getItem() == Items.gunpowder) {
                    ++lllllllllllllllIllIIlIIlllIlllIl;
                }
                else if (lllllllllllllllIllIIlIIlllIlIlll.getItem() == Items.firework_charge) {
                    ++lllllllllllllllIllIIlIIlllIllIll;
                }
                else if (lllllllllllllllIllIIlIIlllIlIlll.getItem() == Items.dye) {
                    ++lllllllllllllllIllIIlIIlllIlllII;
                }
                else if (lllllllllllllllIllIIlIIlllIlIlll.getItem() == Items.paper) {
                    ++lllllllllllllllIllIIlIIlllIllllI;
                }
                else if (lllllllllllllllIllIIlIIlllIlIlll.getItem() == Items.glowstone_dust) {
                    ++lllllllllllllllIllIIlIIlllIllIlI;
                }
                else if (lllllllllllllllIllIIlIIlllIlIlll.getItem() == Items.diamond) {
                    ++lllllllllllllllIllIIlIIlllIllIlI;
                }
                else if (lllllllllllllllIllIIlIIlllIlIlll.getItem() == Items.fire_charge) {
                    ++lllllllllllllllIllIIlIIlllIllIIl;
                }
                else if (lllllllllllllllIllIIlIIlllIlIlll.getItem() == Items.feather) {
                    ++lllllllllllllllIllIIlIIlllIllIIl;
                }
                else if (lllllllllllllllIllIIlIIlllIlIlll.getItem() == Items.gold_nugget) {
                    ++lllllllllllllllIllIIlIIlllIllIIl;
                }
                else {
                    if (lllllllllllllllIllIIlIIlllIlIlll.getItem() != Items.skull) {
                        return false;
                    }
                    ++lllllllllllllllIllIIlIIlllIllIIl;
                }
            }
        }
        lllllllllllllllIllIIlIIlllIllIlI += lllllllllllllllIllIIlIIlllIlllII + lllllllllllllllIllIIlIIlllIllIIl;
        if (lllllllllllllllIllIIlIIlllIlllIl > 3 || lllllllllllllllIllIIlIIlllIllllI > 1) {
            return false;
        }
        if (lllllllllllllllIllIIlIIlllIlllIl >= 1 && lllllllllllllllIllIIlIIlllIllllI == 1 && lllllllllllllllIllIIlIIlllIllIlI == 0) {
            this.field_92102_a = new ItemStack(Items.fireworks);
            if (lllllllllllllllIllIIlIIlllIllIll > 0) {
                final NBTTagCompound lllllllllllllllIllIIlIIlllIlIllI = new NBTTagCompound();
                final NBTTagCompound lllllllllllllllIllIIlIIlllIlIlII = new NBTTagCompound();
                final NBTTagList lllllllllllllllIllIIlIIlllIlIIlI = new NBTTagList();
                for (int lllllllllllllllIllIIlIIlllIlIIIl = 0; lllllllllllllllIllIIlIIlllIlIIIl < lllllllllllllllIllIIlIIllllIIIII.getSizeInventory(); ++lllllllllllllllIllIIlIIlllIlIIIl) {
                    final ItemStack lllllllllllllllIllIIlIIlllIlIIII = lllllllllllllllIllIIlIIllllIIIII.getStackInSlot(lllllllllllllllIllIIlIIlllIlIIIl);
                    if (lllllllllllllllIllIIlIIlllIlIIII != null && lllllllllllllllIllIIlIIlllIlIIII.getItem() == Items.firework_charge && lllllllllllllllIllIIlIIlllIlIIII.hasTagCompound() && lllllllllllllllIllIIlIIlllIlIIII.getTagCompound().hasKey("Explosion", 10)) {
                        lllllllllllllllIllIIlIIlllIlIIlI.appendTag(lllllllllllllllIllIIlIIlllIlIIII.getTagCompound().getCompoundTag("Explosion"));
                    }
                }
                lllllllllllllllIllIIlIIlllIlIlII.setTag("Explosions", lllllllllllllllIllIIlIIlllIlIIlI);
                lllllllllllllllIllIIlIIlllIlIlII.setByte("Flight", (byte)lllllllllllllllIllIIlIIlllIlllIl);
                lllllllllllllllIllIIlIIlllIlIllI.setTag("Fireworks", lllllllllllllllIllIIlIIlllIlIlII);
                this.field_92102_a.setTagCompound(lllllllllllllllIllIIlIIlllIlIllI);
            }
            return true;
        }
        if (lllllllllllllllIllIIlIIlllIlllIl == 1 && lllllllllllllllIllIIlIIlllIllllI == 0 && lllllllllllllllIllIIlIIlllIllIll == 0 && lllllllllllllllIllIIlIIlllIlllII > 0 && lllllllllllllllIllIIlIIlllIllIIl <= 1) {
            this.field_92102_a = new ItemStack(Items.firework_charge);
            final NBTTagCompound lllllllllllllllIllIIlIIlllIlIlIl = new NBTTagCompound();
            final NBTTagCompound lllllllllllllllIllIIlIIlllIlIIll = new NBTTagCompound();
            byte lllllllllllllllIllIIlIIlllIIllll = 0;
            final ArrayList lllllllllllllllIllIIlIIlllIIlllI = Lists.newArrayList();
            for (int lllllllllllllllIllIIlIIlllIIllIl = 0; lllllllllllllllIllIIlIIlllIIllIl < lllllllllllllllIllIIlIIllllIIIII.getSizeInventory(); ++lllllllllllllllIllIIlIIlllIIllIl) {
                final ItemStack lllllllllllllllIllIIlIIlllIIllII = lllllllllllllllIllIIlIIllllIIIII.getStackInSlot(lllllllllllllllIllIIlIIlllIIllIl);
                if (lllllllllllllllIllIIlIIlllIIllII != null) {
                    if (lllllllllllllllIllIIlIIlllIIllII.getItem() == Items.dye) {
                        lllllllllllllllIllIIlIIlllIIlllI.add(ItemDye.dyeColors[lllllllllllllllIllIIlIIlllIIllII.getMetadata() & 0xF]);
                    }
                    else if (lllllllllllllllIllIIlIIlllIIllII.getItem() == Items.glowstone_dust) {
                        lllllllllllllllIllIIlIIlllIlIIll.setBoolean("Flicker", true);
                    }
                    else if (lllllllllllllllIllIIlIIlllIIllII.getItem() == Items.diamond) {
                        lllllllllllllllIllIIlIIlllIlIIll.setBoolean("Trail", true);
                    }
                    else if (lllllllllllllllIllIIlIIlllIIllII.getItem() == Items.fire_charge) {
                        lllllllllllllllIllIIlIIlllIIllll = 1;
                    }
                    else if (lllllllllllllllIllIIlIIlllIIllII.getItem() == Items.feather) {
                        lllllllllllllllIllIIlIIlllIIllll = 4;
                    }
                    else if (lllllllllllllllIllIIlIIlllIIllII.getItem() == Items.gold_nugget) {
                        lllllllllllllllIllIIlIIlllIIllll = 2;
                    }
                    else if (lllllllllllllllIllIIlIIlllIIllII.getItem() == Items.skull) {
                        lllllllllllllllIllIIlIIlllIIllll = 3;
                    }
                }
            }
            final int[] lllllllllllllllIllIIlIIlllIIlIll = new int[lllllllllllllllIllIIlIIlllIIlllI.size()];
            for (int lllllllllllllllIllIIlIIlllIIlIlI = 0; lllllllllllllllIllIIlIIlllIIlIlI < lllllllllllllllIllIIlIIlllIIlIll.length; ++lllllllllllllllIllIIlIIlllIIlIlI) {
                lllllllllllllllIllIIlIIlllIIlIll[lllllllllllllllIllIIlIIlllIIlIlI] = lllllllllllllllIllIIlIIlllIIlllI.get(lllllllllllllllIllIIlIIlllIIlIlI);
            }
            lllllllllllllllIllIIlIIlllIlIIll.setIntArray("Colors", lllllllllllllllIllIIlIIlllIIlIll);
            lllllllllllllllIllIIlIIlllIlIIll.setByte("Type", lllllllllllllllIllIIlIIlllIIllll);
            lllllllllllllllIllIIlIIlllIlIlIl.setTag("Explosion", lllllllllllllllIllIIlIIlllIlIIll);
            this.field_92102_a.setTagCompound(lllllllllllllllIllIIlIIlllIlIlIl);
            return true;
        }
        if (lllllllllllllllIllIIlIIlllIlllIl != 0 || lllllllllllllllIllIIlIIlllIllllI != 0 || lllllllllllllllIllIIlIIlllIllIll != 1 || lllllllllllllllIllIIlIIlllIlllII <= 0 || lllllllllllllllIllIIlIIlllIlllII != lllllllllllllllIllIIlIIlllIllIlI) {
            return false;
        }
        final ArrayList lllllllllllllllIllIIlIIlllIIlIIl = Lists.newArrayList();
        for (int lllllllllllllllIllIIlIIlllIIlIII = 0; lllllllllllllllIllIIlIIlllIIlIII < lllllllllllllllIllIIlIIllllIIIII.getSizeInventory(); ++lllllllllllllllIllIIlIIlllIIlIII) {
            final ItemStack lllllllllllllllIllIIlIIlllIIIlll = lllllllllllllllIllIIlIIllllIIIII.getStackInSlot(lllllllllllllllIllIIlIIlllIIlIII);
            if (lllllllllllllllIllIIlIIlllIIIlll != null) {
                if (lllllllllllllllIllIIlIIlllIIIlll.getItem() == Items.dye) {
                    lllllllllllllllIllIIlIIlllIIlIIl.add(ItemDye.dyeColors[lllllllllllllllIllIIlIIlllIIIlll.getMetadata() & 0xF]);
                }
                else if (lllllllllllllllIllIIlIIlllIIIlll.getItem() == Items.firework_charge) {
                    this.field_92102_a = lllllllllllllllIllIIlIIlllIIIlll.copy();
                    this.field_92102_a.stackSize = 1;
                }
            }
        }
        final int[] lllllllllllllllIllIIlIIlllIIIllI = new int[lllllllllllllllIllIIlIIlllIIlIIl.size()];
        for (int lllllllllllllllIllIIlIIlllIIIlIl = 0; lllllllllllllllIllIIlIIlllIIIlIl < lllllllllllllllIllIIlIIlllIIIllI.length; ++lllllllllllllllIllIIlIIlllIIIlIl) {
            lllllllllllllllIllIIlIIlllIIIllI[lllllllllllllllIllIIlIIlllIIIlIl] = lllllllllllllllIllIIlIIlllIIlIIl.get(lllllllllllllllIllIIlIIlllIIIlIl);
        }
        if (this.field_92102_a == null || !this.field_92102_a.hasTagCompound()) {
            return false;
        }
        final NBTTagCompound lllllllllllllllIllIIlIIlllIIIlII = this.field_92102_a.getTagCompound().getCompoundTag("Explosion");
        if (lllllllllllllllIllIIlIIlllIIIlII == null) {
            return false;
        }
        lllllllllllllllIllIIlIIlllIIIlII.setIntArray("FadeColors", lllllllllllllllIllIIlIIlllIIIllI);
        return true;
    }
    
    @Override
    public ItemStack[] func_179532_b(final InventoryCrafting lllllllllllllllIllIIlIIllIlIIlII) {
        final ItemStack[] lllllllllllllllIllIIlIIllIlIIlll = new ItemStack[lllllllllllllllIllIIlIIllIlIIlII.getSizeInventory()];
        for (int lllllllllllllllIllIIlIIllIlIIllI = 0; lllllllllllllllIllIIlIIllIlIIllI < lllllllllllllllIllIIlIIllIlIIlll.length; ++lllllllllllllllIllIIlIIllIlIIllI) {
            final ItemStack lllllllllllllllIllIIlIIllIlIIlIl = lllllllllllllllIllIIlIIllIlIIlII.getStackInSlot(lllllllllllllllIllIIlIIllIlIIllI);
            if (lllllllllllllllIllIIlIIllIlIIlIl != null && lllllllllllllllIllIIlIIllIlIIlIl.getItem().hasContainerItem()) {
                lllllllllllllllIllIIlIIllIlIIlll[lllllllllllllllIllIIlIIllIlIIllI] = new ItemStack(lllllllllllllllIllIIlIIllIlIIlIl.getItem().getContainerItem());
            }
        }
        return lllllllllllllllIllIIlIIllIlIIlll;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllllIllIIlIIllIllIIll) {
        return this.field_92102_a.copy();
    }
    
    static {
        __OBFID = "CL_00000083";
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return this.field_92102_a;
    }
    
    @Override
    public int getRecipeSize() {
        return 10;
    }
}
