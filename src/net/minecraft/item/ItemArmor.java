package net.minecraft.item;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.dispenser.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.command.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;

public class ItemArmor extends Item
{
    private static final /* synthetic */ IBehaviorDispenseItem dispenserBehavior;
    private static final /* synthetic */ int[] maxDamageArray;
    public final /* synthetic */ int armorType;
    private final /* synthetic */ ArmorMaterial material;
    public final /* synthetic */ int damageReduceAmount;
    public final /* synthetic */ int renderIndex;
    
    public ArmorMaterial getArmorMaterial() {
        return this.material;
    }
    
    public void func_82813_b(final ItemStack lllllllllllllllIIIlIIIlIlllIIIll, final int lllllllllllllllIIIlIIIlIlllIIIlI) {
        if (this.material != ArmorMaterial.LEATHER) {
            throw new UnsupportedOperationException("Can't dye non-leather!");
        }
        NBTTagCompound lllllllllllllllIIIlIIIlIlllIIIIl = lllllllllllllllIIIlIIIlIlllIIIll.getTagCompound();
        if (lllllllllllllllIIIlIIIlIlllIIIIl == null) {
            lllllllllllllllIIIlIIIlIlllIIIIl = new NBTTagCompound();
            lllllllllllllllIIIlIIIlIlllIIIll.setTagCompound(lllllllllllllllIIIlIIIlIlllIIIIl);
        }
        final NBTTagCompound lllllllllllllllIIIlIIIlIlllIIIII = lllllllllllllllIIIlIIIlIlllIIIIl.getCompoundTag("display");
        if (!lllllllllllllllIIIlIIIlIlllIIIIl.hasKey("display", 10)) {
            lllllllllllllllIIIlIIIlIlllIIIIl.setTag("display", lllllllllllllllIIIlIIIlIlllIIIII);
        }
        lllllllllllllllIIIlIIIlIlllIIIII.setInteger("color", lllllllllllllllIIIlIIIlIlllIIIlI);
    }
    
    @Override
    public boolean getIsRepairable(final ItemStack lllllllllllllllIIIlIIIlIllIlIllI, final ItemStack lllllllllllllllIIIlIIIlIllIlIIlI) {
        return this.material.getBaseItemForRepair() == lllllllllllllllIIIlIIIlIllIlIIlI.getItem() || super.getIsRepairable(lllllllllllllllIIIlIIIlIllIlIllI, lllllllllllllllIIIlIIIlIllIlIIlI);
    }
    
    @Override
    public int getColorFromItemStack(final ItemStack lllllllllllllllIIIlIIIllIIIlIlII, final int lllllllllllllllIIIlIIIllIIIlIIll) {
        if (lllllllllllllllIIIlIIIllIIIlIIll > 0) {
            return 16777215;
        }
        int lllllllllllllllIIIlIIIllIIIlIIlI = this.getColor(lllllllllllllllIIIlIIIllIIIlIlII);
        if (lllllllllllllllIIIlIIIllIIIlIIlI < 0) {
            lllllllllllllllIIIlIIIllIIIlIIlI = 16777215;
        }
        return lllllllllllllllIIIlIIIllIIIlIIlI;
    }
    
    @Override
    public int getItemEnchantability() {
        return this.material.getEnchantability();
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack lllllllllllllllIIIlIIIlIllIIIlll, final World lllllllllllllllIIIlIIIlIllIIlIll, final EntityPlayer lllllllllllllllIIIlIIIlIllIIIllI) {
        final int lllllllllllllllIIIlIIIlIllIIlIIl = EntityLiving.getArmorPosition(lllllllllllllllIIIlIIIlIllIIIlll) - 1;
        final ItemStack lllllllllllllllIIIlIIIlIllIIlIII = lllllllllllllllIIIlIIIlIllIIIllI.getCurrentArmor(lllllllllllllllIIIlIIIlIllIIlIIl);
        if (lllllllllllllllIIIlIIIlIllIIlIII == null) {
            lllllllllllllllIIIlIIIlIllIIIllI.setCurrentItemOrArmor(lllllllllllllllIIIlIIIlIllIIlIIl, lllllllllllllllIIIlIIIlIllIIIlll.copy());
            lllllllllllllllIIIlIIIlIllIIIlll.stackSize = 0;
        }
        return lllllllllllllllIIIlIIIlIllIIIlll;
    }
    
    static {
        __OBFID = "CL_00001766";
        maxDamageArray = new int[] { 11, 16, 15, 13 };
        EMPTY_SLOT_NAMES = new String[] { "minecraft:items/empty_armor_slot_helmet", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_boots" };
        dispenserBehavior = new BehaviorDefaultDispenseItem() {
            static {
                __OBFID = "CL_00001767";
            }
            
            @Override
            protected ItemStack dispenseStack(final IBlockSource lllllllllllllllIllIllIIllllllllI, final ItemStack lllllllllllllllIllIllIIlllllllIl) {
                final BlockPos lllllllllllllllIllIllIIlllllllII = lllllllllllllllIllIllIIllllllllI.getBlockPos().offset(BlockDispenser.getFacing(lllllllllllllllIllIllIIllllllllI.getBlockMetadata()));
                final int lllllllllllllllIllIllIIllllllIll = lllllllllllllllIllIllIIlllllllII.getX();
                final int lllllllllllllllIllIllIIllllllIlI = lllllllllllllllIllIllIIlllllllII.getY();
                final int lllllllllllllllIllIllIIllllllIIl = lllllllllllllllIllIllIIlllllllII.getZ();
                final AxisAlignedBB lllllllllllllllIllIllIIllllllIII = new AxisAlignedBB(lllllllllllllllIllIllIIllllllIll, lllllllllllllllIllIllIIllllllIlI, lllllllllllllllIllIllIIllllllIIl, lllllllllllllllIllIllIIllllllIll + 1, lllllllllllllllIllIllIIllllllIlI + 1, lllllllllllllllIllIllIIllllllIIl + 1);
                final List lllllllllllllllIllIllIIlllllIlll = lllllllllllllllIllIllIIllllllllI.getWorld().func_175647_a(EntityLivingBase.class, lllllllllllllllIllIllIIllllllIII, Predicates.and(IEntitySelector.field_180132_d, (Predicate)new IEntitySelector.ArmoredMob(lllllllllllllllIllIllIIlllllllIl)));
                if (lllllllllllllllIllIllIIlllllIlll.size() > 0) {
                    final EntityLivingBase lllllllllllllllIllIllIIlllllIllI = lllllllllllllllIllIllIIlllllIlll.get(0);
                    final int lllllllllllllllIllIllIIlllllIlIl = (lllllllllllllllIllIllIIlllllIllI instanceof EntityPlayer) ? 1 : 0;
                    final int lllllllllllllllIllIllIIlllllIlII = EntityLiving.getArmorPosition(lllllllllllllllIllIllIIlllllllIl);
                    final ItemStack lllllllllllllllIllIllIIlllllIIll = lllllllllllllllIllIllIIlllllllIl.copy();
                    lllllllllllllllIllIllIIlllllIIll.stackSize = 1;
                    lllllllllllllllIllIllIIlllllIllI.setCurrentItemOrArmor(lllllllllllllllIllIllIIlllllIlII - lllllllllllllllIllIllIIlllllIlIl, lllllllllllllllIllIllIIlllllIIll);
                    if (lllllllllllllllIllIllIIlllllIllI instanceof EntityLiving) {
                        ((EntityLiving)lllllllllllllllIllIllIIlllllIllI).setEquipmentDropChance(lllllllllllllllIllIllIIlllllIlII, 2.0f);
                    }
                    --lllllllllllllllIllIllIIlllllllIl.stackSize;
                    return lllllllllllllllIllIllIIlllllllIl;
                }
                return super.dispenseStack(lllllllllllllllIllIllIIllllllllI, lllllllllllllllIllIllIIlllllllIl);
            }
        };
    }
    
    public void removeColor(final ItemStack lllllllllllllllIIIlIIIlIllllIIII) {
        if (this.material == ArmorMaterial.LEATHER) {
            final NBTTagCompound lllllllllllllllIIIlIIIlIlllIllll = lllllllllllllllIIIlIIIlIllllIIII.getTagCompound();
            if (lllllllllllllllIIIlIIIlIlllIllll != null) {
                final NBTTagCompound lllllllllllllllIIIlIIIlIlllIlllI = lllllllllllllllIIIlIIIlIlllIllll.getCompoundTag("display");
                if (lllllllllllllllIIIlIIIlIlllIlllI.hasKey("color")) {
                    lllllllllllllllIIIlIIIlIlllIlllI.removeTag("color");
                }
            }
        }
    }
    
    public int getColor(final ItemStack lllllllllllllllIIIlIIIlIlllllIII) {
        if (this.material != ArmorMaterial.LEATHER) {
            return -1;
        }
        final NBTTagCompound lllllllllllllllIIIlIIIlIlllllIll = lllllllllllllllIIIlIIIlIlllllIII.getTagCompound();
        if (lllllllllllllllIIIlIIIlIlllllIll != null) {
            final NBTTagCompound lllllllllllllllIIIlIIIlIlllllIlI = lllllllllllllllIIIlIIIlIlllllIll.getCompoundTag("display");
            if (lllllllllllllllIIIlIIIlIlllllIlI != null && lllllllllllllllIIIlIIIlIlllllIlI.hasKey("color", 3)) {
                return lllllllllllllllIIIlIIIlIlllllIlI.getInteger("color");
            }
        }
        return 10511680;
    }
    
    public boolean hasColor(final ItemStack lllllllllllllllIIIlIIIllIIIIIlII) {
        return this.material == ArmorMaterial.LEATHER && lllllllllllllllIIIlIIIllIIIIIlII.hasTagCompound() && lllllllllllllllIIIlIIIllIIIIIlII.getTagCompound().hasKey("display", 10) && lllllllllllllllIIIlIIIllIIIIIlII.getTagCompound().getCompoundTag("display").hasKey("color", 3);
    }
    
    public ItemArmor(final ArmorMaterial lllllllllllllllIIIlIIIllIIIlllII, final int lllllllllllllllIIIlIIIllIIIlllll, final int lllllllllllllllIIIlIIIllIIIllllI) {
        this.material = lllllllllllllllIIIlIIIllIIIlllII;
        this.armorType = lllllllllllllllIIIlIIIllIIIllllI;
        this.renderIndex = lllllllllllllllIIIlIIIllIIIlllll;
        this.damageReduceAmount = lllllllllllllllIIIlIIIllIIIlllII.getDamageReductionAmount(lllllllllllllllIIIlIIIllIIIllllI);
        this.setMaxDamage(lllllllllllllllIIIlIIIllIIIlllII.getDurability(lllllllllllllllIIIlIIIllIIIllllI));
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabCombat);
        BlockDispenser.dispenseBehaviorRegistry.putObject(this, ItemArmor.dispenserBehavior);
    }
    
    public enum ArmorMaterial
    {
        GOLD("GOLD", 3, "GOLD", 3, "gold", 7, new int[] { 2, 5, 3, 1 }, 25), 
        LEATHER("LEATHER", 0, "LEATHER", 0, "leather", 5, new int[] { 1, 3, 2, 1 }, 15), 
        CHAIN("CHAIN", 1, "CHAIN", 1, "chainmail", 15, new int[] { 2, 5, 4, 1 }, 12);
        
        private final /* synthetic */ String field_179243_f;
        
        IRON("IRON", 2, "IRON", 2, "iron", 15, new int[] { 2, 6, 5, 2 }, 9);
        
        private final /* synthetic */ int enchantability;
        private final /* synthetic */ int maxDamageFactor;
        
        DIAMOND("DIAMOND", 4, "DIAMOND", 4, "diamond", 33, new int[] { 3, 8, 6, 3 }, 10);
        
        private final /* synthetic */ int[] damageReductionAmountArray;
        
        private ArmorMaterial(final String llllllllllllllIlllIIllIIlIIIIIll, final int llllllllllllllIlllIIllIIlIIIIIlI, final String llllllllllllllIlllIIllIIlIIIlIlI, final int llllllllllllllIlllIIllIIlIIIlIIl, final String llllllllllllllIlllIIllIIlIIIlIII, final int llllllllllllllIlllIIllIIlIIIIlll, final int[] llllllllllllllIlllIIllIIlIIIIllI, final int llllllllllllllIlllIIllIIlIIIIlIl) {
            this.field_179243_f = llllllllllllllIlllIIllIIlIIIlIII;
            this.maxDamageFactor = llllllllllllllIlllIIllIIlIIIIlll;
            this.damageReductionAmountArray = llllllllllllllIlllIIllIIlIIIIllI;
            this.enchantability = llllllllllllllIlllIIllIIlIIIIlIl;
        }
        
        public int getDurability(final int llllllllllllllIlllIIllIIIllllIlI) {
            return ItemArmor.maxDamageArray[llllllllllllllIlllIIllIIIllllIlI] * this.maxDamageFactor;
        }
        
        public int getDamageReductionAmount(final int llllllllllllllIlllIIllIIIlllIlII) {
            return this.damageReductionAmountArray[llllllllllllllIlllIIllIIIlllIlII];
        }
        
        public int getEnchantability() {
            return this.enchantability;
        }
        
        public Item getBaseItemForRepair() {
            return (this == ArmorMaterial.LEATHER) ? Items.leather : ((this == ArmorMaterial.CHAIN) ? Items.iron_ingot : ((this == ArmorMaterial.GOLD) ? Items.gold_ingot : ((this == ArmorMaterial.IRON) ? Items.iron_ingot : ((this == ArmorMaterial.DIAMOND) ? Items.diamond : null))));
        }
        
        public String func_179242_c() {
            return this.field_179243_f;
        }
        
        static {
            __OBFID = "CL_00001768";
        }
    }
}
