package net.minecraft.item;

import net.minecraft.entity.item.*;
import net.minecraft.block.*;
import java.text.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.attributes.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.*;
import net.minecraft.event.*;

public final class ItemStack
{
    private /* synthetic */ NBTTagCompound stackTagCompound;
    private /* synthetic */ int itemDamage;
    private /* synthetic */ boolean canDestroyCacheResult;
    private /* synthetic */ EntityItemFrame itemFrame;
    public /* synthetic */ int animationsToGo;
    private /* synthetic */ Block canPlaceOnCacheBlock;
    private /* synthetic */ Block canDestroyCacheBlock;
    public static final /* synthetic */ DecimalFormat DECIMALFORMAT;
    private /* synthetic */ boolean canPlaceOnCacheResult;
    public /* synthetic */ int stackSize;
    private /* synthetic */ Item item;
    
    public ItemStack(final Block lllllllllllllllIlIlllIIIIIlIlIll, final int lllllllllllllllIlIlllIIIIIlIlIlI, final int lllllllllllllllIlIlllIIIIIlIlIIl) {
        this(Item.getItemFromBlock(lllllllllllllllIlIlllIIIIIlIlIll), lllllllllllllllIlIlllIIIIIlIlIlI, lllllllllllllllIlIlllIIIIIlIlIIl);
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllllIlIllIlllllIIIIIl) {
        final ResourceLocation lllllllllllllllIlIllIlllllIIIIII = (ResourceLocation)Item.itemRegistry.getNameForObject(this.item);
        lllllllllllllllIlIllIlllllIIIIIl.setString("id", (lllllllllllllllIlIllIlllllIIIIII == null) ? "minecraft:air" : lllllllllllllllIlIllIlllllIIIIII.toString());
        lllllllllllllllIlIllIlllllIIIIIl.setByte("Count", (byte)this.stackSize);
        lllllllllllllllIlIllIlllllIIIIIl.setShort("Damage", (short)this.itemDamage);
        if (this.stackTagCompound != null) {
            lllllllllllllllIlIllIlllllIIIIIl.setTag("tag", this.stackTagCompound);
        }
        return lllllllllllllllIlIllIlllllIIIIIl;
    }
    
    public EnumRarity getRarity() {
        return this.getItem().getRarity(this);
    }
    
    public int getItemDamage() {
        return this.itemDamage;
    }
    
    public boolean isItemDamaged() {
        return this.isItemStackDamageable() && this.itemDamage > 0;
    }
    
    public boolean isItemEnchanted() {
        return this.stackTagCompound != null && this.stackTagCompound.hasKey("ench", 9);
    }
    
    public void setItemDamage(final int lllllllllllllllIlIllIllllIIlIlll) {
        this.itemDamage = lllllllllllllllIlIllIllllIIlIlll;
        if (this.itemDamage < 0) {
            this.itemDamage = 0;
        }
    }
    
    public boolean canDestroy(final Block lllllllllllllllIlIllIlIlllIIlIII) {
        if (lllllllllllllllIlIllIlIlllIIlIII == this.canDestroyCacheBlock) {
            return this.canDestroyCacheResult;
        }
        this.canDestroyCacheBlock = lllllllllllllllIlIllIlIlllIIlIII;
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("CanDestroy", 9)) {
            final NBTTagList lllllllllllllllIlIllIlIlllIIIlll = this.stackTagCompound.getTagList("CanDestroy", 8);
            for (int lllllllllllllllIlIllIlIlllIIIllI = 0; lllllllllllllllIlIllIlIlllIIIllI < lllllllllllllllIlIllIlIlllIIIlll.tagCount(); ++lllllllllllllllIlIllIlIlllIIIllI) {
                final Block lllllllllllllllIlIllIlIlllIIIlIl = Block.getBlockFromName(lllllllllllllllIlIllIlIlllIIIlll.getStringTagAt(lllllllllllllllIlIllIlIlllIIIllI));
                if (lllllllllllllllIlIllIlIlllIIIlIl == lllllllllllllllIlIllIlIlllIIlIII) {
                    this.canDestroyCacheResult = true;
                    return true;
                }
            }
        }
        this.canDestroyCacheResult = false;
        return false;
    }
    
    public void hitEntity(final EntityLivingBase lllllllllllllllIlIllIlllIlIlIIlI, final EntityPlayer lllllllllllllllIlIllIlllIlIlIIII) {
        final boolean lllllllllllllllIlIllIlllIlIlIlIl = this.item.hitEntity(this, lllllllllllllllIlIllIlllIlIlIIlI, lllllllllllllllIlIllIlllIlIlIIII);
        if (lllllllllllllllIlIllIlllIlIlIlIl) {
            lllllllllllllllIlIllIlllIlIlIIII.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this.item)]);
        }
    }
    
    public boolean interactWithEntity(final EntityPlayer lllllllllllllllIlIllIlllIIIlIlIl, final EntityLivingBase lllllllllllllllIlIllIlllIIIlIIll) {
        return this.item.itemInteractionForEntity(this, lllllllllllllllIlIllIlllIIIlIlIl, lllllllllllllllIlIllIlllIIIlIIll);
    }
    
    public ItemStack useItemRightClick(final World lllllllllllllllIlIllIlllllIlIIII, final EntityPlayer lllllllllllllllIlIllIlllllIlIIlI) {
        return this.getItem().onItemRightClick(this, lllllllllllllllIlIllIlllllIlIIII, lllllllllllllllIlIllIlllllIlIIlI);
    }
    
    public boolean getHasSubtypes() {
        return this.item.getHasSubtypes();
    }
    
    public boolean onItemUse(final EntityPlayer lllllllllllllllIlIllIllllllIIlIl, final World lllllllllllllllIlIllIllllllIllIl, final BlockPos lllllllllllllllIlIllIllllllIllII, final EnumFacing lllllllllllllllIlIllIllllllIlIll, final float lllllllllllllllIlIllIllllllIIIIl, final float lllllllllllllllIlIllIllllllIlIIl, final float lllllllllllllllIlIllIllllllIlIII) {
        final boolean lllllllllllllllIlIllIllllllIIlll = this.getItem().onItemUse(this, lllllllllllllllIlIllIllllllIIlIl, lllllllllllllllIlIllIllllllIllIl, lllllllllllllllIlIllIllllllIllII, lllllllllllllllIlIllIllllllIlIll, lllllllllllllllIlIllIllllllIIIIl, lllllllllllllllIlIllIllllllIlIIl, lllllllllllllllIlIllIllllllIlIII);
        if (lllllllllllllllIlIllIllllllIIlll) {
            lllllllllllllllIlIllIllllllIIlIl.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this.item)]);
        }
        return lllllllllllllllIlIllIllllllIIlll;
    }
    
    public boolean isItemStackDamageable() {
        return this.item != null && this.item.getMaxDamage() > 0 && (!this.hasTagCompound() || !this.getTagCompound().getBoolean("Unbreakable"));
    }
    
    public ItemStack splitStack(final int lllllllllllllllIlIllIlllllllllIl) {
        final ItemStack lllllllllllllllIlIllIlllllllllll = new ItemStack(this.item, lllllllllllllllIlIllIlllllllllIl, this.itemDamage);
        if (this.stackTagCompound != null) {
            lllllllllllllllIlIllIlllllllllll.stackTagCompound = (NBTTagCompound)this.stackTagCompound.copy();
        }
        this.stackSize -= lllllllllllllllIlIllIlllllllllIl;
        return lllllllllllllllIlIllIlllllllllll;
    }
    
    public boolean hasDisplayName() {
        return this.stackTagCompound != null && this.stackTagCompound.hasKey("display", 10) && this.stackTagCompound.getCompoundTag("display").hasKey("Name", 8);
    }
    
    public void addEnchantment(final Enchantment lllllllllllllllIlIllIllIIIlIIIII, final int lllllllllllllllIlIllIllIIIIllIlI) {
        if (this.stackTagCompound == null) {
            this.setTagCompound(new NBTTagCompound());
        }
        if (!this.stackTagCompound.hasKey("ench", 9)) {
            this.stackTagCompound.setTag("ench", new NBTTagList());
        }
        final NBTTagList lllllllllllllllIlIllIllIIIIllllI = this.stackTagCompound.getTagList("ench", 10);
        final NBTTagCompound lllllllllllllllIlIllIllIIIIlllIl = new NBTTagCompound();
        lllllllllllllllIlIllIllIIIIlllIl.setShort("id", (short)lllllllllllllllIlIllIllIIIlIIIII.effectId);
        lllllllllllllllIlIllIllIIIIlllIl.setShort("lvl", (byte)lllllllllllllllIlIllIllIIIIllIlI);
        lllllllllllllllIlIllIllIIIIllllI.appendTag(lllllllllllllllIlIllIllIIIIlllIl);
    }
    
    public Item getItem() {
        return this.item;
    }
    
    private boolean isItemStackEqual(final ItemStack lllllllllllllllIlIllIllIlllIIlIl) {
        return this.stackSize == lllllllllllllllIlIllIllIlllIIlIl.stackSize && this.item == lllllllllllllllIlIllIllIlllIIlIl.item && this.itemDamage == lllllllllllllllIlIllIllIlllIIlIl.itemDamage && (this.stackTagCompound != null || lllllllllllllllIlIllIllIlllIIlIl.stackTagCompound == null) && (this.stackTagCompound == null || this.stackTagCompound.equals(lllllllllllllllIlIllIllIlllIIlIl.stackTagCompound));
    }
    
    public static ItemStack copyItemStack(final ItemStack lllllllllllllllIlIllIllIllIlIIIl) {
        return (lllllllllllllllIlIllIllIllIlIIIl == null) ? null : lllllllllllllllIlIllIllIllIlIIIl.copy();
    }
    
    public void setRepairCost(final int lllllllllllllllIlIllIlIlllllIllI) {
        if (!this.hasTagCompound()) {
            this.stackTagCompound = new NBTTagCompound();
        }
        this.stackTagCompound.setInteger("RepairCost", lllllllllllllllIlIllIlIlllllIllI);
    }
    
    public EntityItemFrame getItemFrame() {
        return this.itemFrame;
    }
    
    public int getMaxDamage() {
        return this.item.getMaxDamage();
    }
    
    public int getMetadata() {
        return this.itemDamage;
    }
    
    public void onPlayerStoppedUsing(final World lllllllllllllllIlIllIllIlIIlllIl, final EntityPlayer lllllllllllllllIlIllIllIlIIlllII, final int lllllllllllllllIlIllIllIlIIllIll) {
        this.getItem().onPlayerStoppedUsing(this, lllllllllllllllIlIllIllIlIIlllIl, lllllllllllllllIlIllIllIlIIlllII, lllllllllllllllIlIllIllIlIIllIll);
    }
    
    public boolean isItemEnchantable() {
        return this.getItem().isItemTool(this) && !this.isItemEnchanted();
    }
    
    public boolean canHarvestBlock(final Block lllllllllllllllIlIllIlllIIlIIlIl) {
        return this.item.canHarvestBlock(lllllllllllllllIlIllIlllIIlIIlIl);
    }
    
    public void clearCustomName() {
        if (this.stackTagCompound != null && this.stackTagCompound.hasKey("display", 10)) {
            final NBTTagCompound lllllllllllllllIlIllIllIIllIllIl = this.stackTagCompound.getCompoundTag("display");
            lllllllllllllllIlIllIllIIllIllIl.removeTag("Name");
            if (lllllllllllllllIlIllIllIIllIllIl.hasNoTags()) {
                this.stackTagCompound.removeTag("display");
                if (this.stackTagCompound.hasNoTags()) {
                    this.setTagCompound(null);
                }
            }
        }
    }
    
    public ItemStack onItemUseFinish(final World lllllllllllllllIlIllIlllllIIlIlI, final EntityPlayer lllllllllllllllIlIllIlllllIIlIIl) {
        return this.getItem().onItemUseFinish(this, lllllllllllllllIlIllIlllllIIlIlI, lllllllllllllllIlIllIlllllIIlIIl);
    }
    
    public static boolean areItemStacksEqual(final ItemStack lllllllllllllllIlIllIllIlllIllII, final ItemStack lllllllllllllllIlIllIllIlllIlIll) {
        return (lllllllllllllllIlIllIllIlllIllII == null && lllllllllllllllIlIllIllIlllIlIll == null) || (lllllllllllllllIlIllIllIlllIllII != null && lllllllllllllllIlIllIllIlllIlIll != null && lllllllllllllllIlIllIllIlllIllII.isItemStackEqual(lllllllllllllllIlIllIllIlllIlIll));
    }
    
    public ItemStack copy() {
        final ItemStack lllllllllllllllIlIllIlllIIIIlIll = new ItemStack(this.item, this.stackSize, this.itemDamage);
        if (this.stackTagCompound != null) {
            lllllllllllllllIlIllIlllIIIIlIll.stackTagCompound = (NBTTagCompound)this.stackTagCompound.copy();
        }
        return lllllllllllllllIlIllIlllIIIIlIll;
    }
    
    public ItemStack(final Item lllllllllllllllIlIlllIIIIIlIIlIl) {
        this(lllllllllllllllIlIlllIIIIIlIIlIl, 1);
    }
    
    public NBTTagList getEnchantmentTagList() {
        return (this.stackTagCompound == null) ? null : this.stackTagCompound.getTagList("ench", 10);
    }
    
    public boolean hasEffect() {
        return this.getItem().hasEffect(this);
    }
    
    public Multimap getAttributeModifiers() {
        Object lllllllllllllllIlIllIlIllllIlIll = null;
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("AttributeModifiers", 9)) {
            final Object lllllllllllllllIlIllIlIllllIllII = HashMultimap.create();
            final NBTTagList lllllllllllllllIlIllIlIllllIlIlI = this.stackTagCompound.getTagList("AttributeModifiers", 10);
            for (int lllllllllllllllIlIllIlIllllIlIIl = 0; lllllllllllllllIlIllIlIllllIlIIl < lllllllllllllllIlIllIlIllllIlIlI.tagCount(); ++lllllllllllllllIlIllIlIllllIlIIl) {
                final NBTTagCompound lllllllllllllllIlIllIlIllllIlIII = lllllllllllllllIlIllIlIllllIlIlI.getCompoundTagAt(lllllllllllllllIlIllIlIllllIlIIl);
                final AttributeModifier lllllllllllllllIlIllIlIllllIIlll = SharedMonsterAttributes.readAttributeModifierFromNBT(lllllllllllllllIlIllIlIllllIlIII);
                if (lllllllllllllllIlIllIlIllllIIlll != null && lllllllllllllllIlIllIlIllllIIlll.getID().getLeastSignificantBits() != 0L && lllllllllllllllIlIllIlIllllIIlll.getID().getMostSignificantBits() != 0L) {
                    ((Multimap)lllllllllllllllIlIllIlIllllIllII).put((Object)lllllllllllllllIlIllIlIllllIlIII.getString("AttributeName"), (Object)lllllllllllllllIlIllIlIllllIIlll);
                }
            }
        }
        else {
            lllllllllllllllIlIllIlIllllIlIll = this.getItem().getItemAttributeModifiers();
        }
        return (Multimap)lllllllllllllllIlIllIlIllllIlIll;
    }
    
    public String getUnlocalizedName() {
        return this.item.getUnlocalizedName(this);
    }
    
    public int getRepairCost() {
        return (this.hasTagCompound() && this.stackTagCompound.hasKey("RepairCost", 3)) ? this.stackTagCompound.getInteger("RepairCost") : 0;
    }
    
    public boolean canEditBlocks() {
        return this.getItem().canItemEditBlocks();
    }
    
    public boolean canPlaceOn(final Block lllllllllllllllIlIllIlIllIllIlII) {
        if (lllllllllllllllIlIllIlIllIllIlII == this.canPlaceOnCacheBlock) {
            return this.canPlaceOnCacheResult;
        }
        this.canPlaceOnCacheBlock = lllllllllllllllIlIllIlIllIllIlII;
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("CanPlaceOn", 9)) {
            final NBTTagList lllllllllllllllIlIllIlIllIlllIII = this.stackTagCompound.getTagList("CanPlaceOn", 8);
            for (int lllllllllllllllIlIllIlIllIllIlll = 0; lllllllllllllllIlIllIlIllIllIlll < lllllllllllllllIlIllIlIllIlllIII.tagCount(); ++lllllllllllllllIlIllIlIllIllIlll) {
                final Block lllllllllllllllIlIllIlIllIllIllI = Block.getBlockFromName(lllllllllllllllIlIllIlIllIlllIII.getStringTagAt(lllllllllllllllIlIllIlIllIllIlll));
                if (lllllllllllllllIlIllIlIllIllIllI == lllllllllllllllIlIllIlIllIllIlII) {
                    this.canPlaceOnCacheResult = true;
                    return true;
                }
            }
        }
        this.canPlaceOnCacheResult = false;
        return false;
    }
    
    public void updateAnimation(final World lllllllllllllllIlIllIllIllIIIIlI, final Entity lllllllllllllllIlIllIllIllIIIIIl, final int lllllllllllllllIlIllIllIllIIIlIl, final boolean lllllllllllllllIlIllIllIllIIIlII) {
        if (this.animationsToGo > 0) {
            --this.animationsToGo;
        }
        this.item.onUpdate(this, lllllllllllllllIlIllIllIllIIIIlI, lllllllllllllllIlIllIllIllIIIIIl, lllllllllllllllIlIllIllIllIIIlIl, lllllllllllllllIlIllIllIllIIIlII);
    }
    
    public void setItem(final Item lllllllllllllllIlIllIlIlllIllIll) {
        this.item = lllllllllllllllIlIllIlIlllIllIll;
    }
    
    public void onCrafting(final World lllllllllllllllIlIllIllIlIlllIIl, final EntityPlayer lllllllllllllllIlIllIllIlIlllIII, final int lllllllllllllllIlIllIllIlIllIIll) {
        lllllllllllllllIlIllIllIlIlllIII.addStat(StatList.objectCraftStats[Item.getIdFromItem(this.item)], lllllllllllllllIlIllIllIlIllIIll);
        this.item.onCreated(this, lllllllllllllllIlIllIllIlIlllIIl, lllllllllllllllIlIllIllIlIlllIII);
    }
    
    public List getTooltip(final EntityPlayer lllllllllllllllIlIllIllIIIllllII, final boolean lllllllllllllllIlIllIllIIlIlIlll) {
        final ArrayList lllllllllllllllIlIllIllIIlIlIllI = Lists.newArrayList();
        String lllllllllllllllIlIllIllIIlIlIlIl = this.getDisplayName();
        if (this.hasDisplayName()) {
            lllllllllllllllIlIllIllIIlIlIlIl = String.valueOf(new StringBuilder().append(EnumChatFormatting.ITALIC).append(lllllllllllllllIlIllIllIIlIlIlIl));
        }
        lllllllllllllllIlIllIllIIlIlIlIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIllIllIIlIlIlIl)).append(EnumChatFormatting.RESET));
        if (lllllllllllllllIlIllIllIIlIlIlll) {
            String lllllllllllllllIlIllIllIIlIlIlII = "";
            if (lllllllllllllllIlIllIllIIlIlIlIl.length() > 0) {
                lllllllllllllllIlIllIllIIlIlIlIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIllIllIIlIlIlIl)).append(" ("));
                lllllllllllllllIlIllIllIIlIlIlII = ")";
            }
            final int lllllllllllllllIlIllIllIIlIlIIll = Item.getIdFromItem(this.item);
            if (this.getHasSubtypes()) {
                lllllllllllllllIlIllIllIIlIlIlIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIllIllIIlIlIlIl)).append(String.format("#%04d/%d%s", lllllllllllllllIlIllIllIIlIlIIll, this.itemDamage, lllllllllllllllIlIllIllIIlIlIlII)));
            }
            else {
                lllllllllllllllIlIllIllIIlIlIlIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIllIllIIlIlIlIl)).append(String.format("#%04d%s", lllllllllllllllIlIllIllIIlIlIIll, lllllllllllllllIlIllIllIIlIlIlII)));
            }
        }
        else if (!this.hasDisplayName() && this.item == Items.filled_map) {
            lllllllllllllllIlIllIllIIlIlIlIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIllIllIIlIlIlIl)).append(" #").append(this.itemDamage));
        }
        lllllllllllllllIlIllIllIIlIlIllI.add(lllllllllllllllIlIllIllIIlIlIlIl);
        int lllllllllllllllIlIllIllIIlIlIIlI = 0;
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("HideFlags", 99)) {
            lllllllllllllllIlIllIllIIlIlIIlI = this.stackTagCompound.getInteger("HideFlags");
        }
        if ((lllllllllllllllIlIllIllIIlIlIIlI & 0x20) == 0x0) {
            this.item.addInformation(this, lllllllllllllllIlIllIllIIIllllII, lllllllllllllllIlIllIllIIlIlIllI, lllllllllllllllIlIllIllIIlIlIlll);
        }
        if (this.hasTagCompound()) {
            if ((lllllllllllllllIlIllIllIIlIlIIlI & 0x1) == 0x0) {
                final NBTTagList lllllllllllllllIlIllIllIIlIIlIll = this.getEnchantmentTagList();
                if (lllllllllllllllIlIllIllIIlIIlIll != null) {
                    for (int lllllllllllllllIlIllIllIIlIIlIlI = 0; lllllllllllllllIlIllIllIIlIIlIlI < lllllllllllllllIlIllIllIIlIIlIll.tagCount(); ++lllllllllllllllIlIllIllIIlIIlIlI) {
                        final short lllllllllllllllIlIllIllIIlIIlIIl = lllllllllllllllIlIllIllIIlIIlIll.getCompoundTagAt(lllllllllllllllIlIllIllIIlIIlIlI).getShort("id");
                        final short lllllllllllllllIlIllIllIIlIIlIII = lllllllllllllllIlIllIllIIlIIlIll.getCompoundTagAt(lllllllllllllllIlIllIllIIlIIlIlI).getShort("lvl");
                        if (Enchantment.func_180306_c(lllllllllllllllIlIllIllIIlIIlIIl) != null) {
                            lllllllllllllllIlIllIllIIlIlIllI.add(Enchantment.func_180306_c(lllllllllllllllIlIllIllIIlIIlIIl).getTranslatedName(lllllllllllllllIlIllIllIIlIIlIII));
                        }
                    }
                }
            }
            if (this.stackTagCompound.hasKey("display", 10)) {
                final NBTTagCompound lllllllllllllllIlIllIllIIlIIIlll = this.stackTagCompound.getCompoundTag("display");
                if (lllllllllllllllIlIllIllIIlIIIlll.hasKey("color", 3)) {
                    if (lllllllllllllllIlIllIllIIlIlIlll) {
                        lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder("Color: #").append(Integer.toHexString(lllllllllllllllIlIllIllIIlIIIlll.getInteger("color")).toUpperCase())));
                    }
                    else {
                        lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.ITALIC).append(StatCollector.translateToLocal("item.dyed"))));
                    }
                }
                if (lllllllllllllllIlIllIllIIlIIIlll.getTagType("Lore") == 9) {
                    final NBTTagList lllllllllllllllIlIllIllIIlIlIIIl = lllllllllllllllIlIllIllIIlIIIlll.getTagList("Lore", 8);
                    if (lllllllllllllllIlIllIllIIlIlIIIl.tagCount() > 0) {
                        for (int lllllllllllllllIlIllIllIIlIIlllI = 0; lllllllllllllllIlIllIllIIlIIlllI < lllllllllllllllIlIllIllIIlIlIIIl.tagCount(); ++lllllllllllllllIlIllIllIIlIIlllI) {
                            lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_PURPLE).append(EnumChatFormatting.ITALIC).append(lllllllllllllllIlIllIllIIlIlIIIl.getStringTagAt(lllllllllllllllIlIllIllIIlIIlllI))));
                        }
                    }
                }
            }
        }
        final Multimap lllllllllllllllIlIllIllIIlIIIllI = this.getAttributeModifiers();
        if (!lllllllllllllllIlIllIllIIlIIIllI.isEmpty() && (lllllllllllllllIlIllIllIIlIlIIlI & 0x2) == 0x0) {
            lllllllllllllllIlIllIllIIlIlIllI.add("");
            for (final Map.Entry lllllllllllllllIlIllIllIIlIIIlII : lllllllllllllllIlIllIllIIlIIIllI.entries()) {
                final AttributeModifier lllllllllllllllIlIllIllIIlIIIIll = lllllllllllllllIlIllIllIIlIIIlII.getValue();
                double lllllllllllllllIlIllIllIIlIIIIlI = lllllllllllllllIlIllIllIIlIIIIll.getAmount();
                if (lllllllllllllllIlIllIllIIlIIIIll.getID() == Item.itemModifierUUID) {
                    lllllllllllllllIlIllIllIIlIIIIlI += EnchantmentHelper.func_152377_a(this, EnumCreatureAttribute.UNDEFINED);
                }
                double lllllllllllllllIlIllIllIIlIIIIII = 0.0;
                if (lllllllllllllllIlIllIllIIlIIIIll.getOperation() != 1 && lllllllllllllllIlIllIllIIlIIIIll.getOperation() != 2) {
                    final double lllllllllllllllIlIllIllIIlIIIIIl = lllllllllllllllIlIllIllIIlIIIIlI;
                }
                else {
                    lllllllllllllllIlIllIllIIlIIIIII = lllllllllllllllIlIllIllIIlIIIIlI * 100.0;
                }
                if (lllllllllllllllIlIllIllIIlIIIIlI > 0.0) {
                    lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.BLUE).append(StatCollector.translateToLocalFormatted(String.valueOf(new StringBuilder("attribute.modifier.plus.").append(lllllllllllllllIlIllIllIIlIIIIll.getOperation())), ItemStack.DECIMALFORMAT.format(lllllllllllllllIlIllIllIIlIIIIII), StatCollector.translateToLocal(String.valueOf(new StringBuilder("attribute.name.").append(lllllllllllllllIlIllIllIIlIIIlII.getKey())))))));
                }
                else {
                    if (lllllllllllllllIlIllIllIIlIIIIlI >= 0.0) {
                        continue;
                    }
                    lllllllllllllllIlIllIllIIlIIIIII *= -1.0;
                    lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append(StatCollector.translateToLocalFormatted(String.valueOf(new StringBuilder("attribute.modifier.take.").append(lllllllllllllllIlIllIllIIlIIIIll.getOperation())), ItemStack.DECIMALFORMAT.format(lllllllllllllllIlIllIllIIlIIIIII), StatCollector.translateToLocal(String.valueOf(new StringBuilder("attribute.name.").append(lllllllllllllllIlIllIllIIlIIIlII.getKey())))))));
                }
            }
        }
        if (this.hasTagCompound() && this.getTagCompound().getBoolean("Unbreakable") && (lllllllllllllllIlIllIllIIlIlIIlI & 0x4) == 0x0) {
            lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.BLUE).append(StatCollector.translateToLocal("item.unbreakable"))));
        }
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("CanDestroy", 9) && (lllllllllllllllIlIllIllIIlIlIIlI & 0x8) == 0x0) {
            final NBTTagList lllllllllllllllIlIllIllIIlIlIIII = this.stackTagCompound.getTagList("CanDestroy", 8);
            if (lllllllllllllllIlIllIllIIlIlIIII.tagCount() > 0) {
                lllllllllllllllIlIllIllIIlIlIllI.add("");
                lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append(StatCollector.translateToLocal("item.canBreak"))));
                for (int lllllllllllllllIlIllIllIIlIIllIl = 0; lllllllllllllllIlIllIllIIlIIllIl < lllllllllllllllIlIllIllIIlIlIIII.tagCount(); ++lllllllllllllllIlIllIllIIlIIllIl) {
                    final Block lllllllllllllllIlIllIllIIIllllll = Block.getBlockFromName(lllllllllllllllIlIllIllIIlIlIIII.getStringTagAt(lllllllllllllllIlIllIllIIlIIllIl));
                    if (lllllllllllllllIlIllIllIIIllllll != null) {
                        lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_GRAY).append(lllllllllllllllIlIllIllIIIllllll.getLocalizedName())));
                    }
                    else {
                        lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_GRAY).append("missingno")));
                    }
                }
            }
        }
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("CanPlaceOn", 9) && (lllllllllllllllIlIllIllIIlIlIIlI & 0x10) == 0x0) {
            final NBTTagList lllllllllllllllIlIllIllIIlIIllll = this.stackTagCompound.getTagList("CanPlaceOn", 8);
            if (lllllllllllllllIlIllIllIIlIIllll.tagCount() > 0) {
                lllllllllllllllIlIllIllIIlIlIllI.add("");
                lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append(StatCollector.translateToLocal("item.canPlace"))));
                for (int lllllllllllllllIlIllIllIIlIIllII = 0; lllllllllllllllIlIllIllIIlIIllII < lllllllllllllllIlIllIllIIlIIllll.tagCount(); ++lllllllllllllllIlIllIllIIlIIllII) {
                    final Block lllllllllllllllIlIllIllIIIlllllI = Block.getBlockFromName(lllllllllllllllIlIllIllIIlIIllll.getStringTagAt(lllllllllllllllIlIllIllIIlIIllII));
                    if (lllllllllllllllIlIllIllIIIlllllI != null) {
                        lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_GRAY).append(lllllllllllllllIlIllIllIIIlllllI.getLocalizedName())));
                    }
                    else {
                        lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_GRAY).append("missingno")));
                    }
                }
            }
        }
        if (lllllllllllllllIlIllIllIIlIlIlll) {
            if (this.isItemDamaged()) {
                lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder("Durability: ").append(this.getMaxDamage() - this.getItemDamage()).append(" / ").append(this.getMaxDamage())));
            }
            lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_GRAY).append(((ResourceLocation)Item.itemRegistry.getNameForObject(this.item)).toString())));
            if (this.hasTagCompound()) {
                lllllllllllllllIlIllIllIIlIlIllI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_GRAY).append("NBT: ").append(this.getTagCompound().getKeySet().size()).append(" tag(s)")));
            }
        }
        return lllllllllllllllIlIllIllIIlIlIllI;
    }
    
    public ItemStack(final Item lllllllllllllllIlIlllIIIIIIlIIII, final int lllllllllllllllIlIlllIIIIIIIllll, final int lllllllllllllllIlIlllIIIIIIIlllI) {
        this.canDestroyCacheBlock = null;
        this.canDestroyCacheResult = false;
        this.canPlaceOnCacheBlock = null;
        this.canPlaceOnCacheResult = false;
        this.item = lllllllllllllllIlIlllIIIIIIlIIII;
        this.stackSize = lllllllllllllllIlIlllIIIIIIIllll;
        this.itemDamage = lllllllllllllllIlIlllIIIIIIIlllI;
        if (this.itemDamage < 0) {
            this.itemDamage = 0;
        }
    }
    
    public int getMaxStackSize() {
        return this.getItem().getItemStackLimit();
    }
    
    public boolean attemptDamageItem(int lllllllllllllllIlIllIllllIIIIIlI, final Random lllllllllllllllIlIllIllllIIIlIII) {
        if (!this.isItemStackDamageable()) {
            return false;
        }
        if (lllllllllllllllIlIllIllllIIIIIlI > 0) {
            final int lllllllllllllllIlIllIllllIIIIlll = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, this);
            int lllllllllllllllIlIllIllllIIIIllI = 0;
            for (int lllllllllllllllIlIllIllllIIIIlIl = 0; lllllllllllllllIlIllIllllIIIIlll > 0 && lllllllllllllllIlIllIllllIIIIlIl < lllllllllllllllIlIllIllllIIIIIlI; ++lllllllllllllllIlIllIllllIIIIlIl) {
                if (EnchantmentDurability.negateDamage(this, lllllllllllllllIlIllIllllIIIIlll, lllllllllllllllIlIllIllllIIIlIII)) {
                    ++lllllllllllllllIlIllIllllIIIIllI;
                }
            }
            lllllllllllllllIlIllIllllIIIIIlI -= lllllllllllllllIlIllIllllIIIIllI;
            if (lllllllllllllllIlIllIllllIIIIIlI <= 0) {
                return false;
            }
        }
        this.itemDamage += lllllllllllllllIlIllIllllIIIIIlI;
        return this.itemDamage > this.getMaxDamage();
    }
    
    public IChatComponent getChatComponent() {
        final ChatComponentText lllllllllllllllIlIllIlIlllIlIlIl = new ChatComponentText(this.getDisplayName());
        if (this.hasDisplayName()) {
            lllllllllllllllIlIllIlIlllIlIlIl.getChatStyle().setItalic(true);
        }
        final IChatComponent lllllllllllllllIlIllIlIlllIlIlII = new ChatComponentText("[").appendSibling(lllllllllllllllIlIllIlIlllIlIlIl).appendText("]");
        if (this.item != null) {
            final NBTTagCompound lllllllllllllllIlIllIlIlllIlIIll = new NBTTagCompound();
            this.writeToNBT(lllllllllllllllIlIllIlIlllIlIIll);
            lllllllllllllllIlIllIlIlllIlIlII.getChatStyle().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new ChatComponentText(lllllllllllllllIlIllIlIlllIlIIll.toString())));
            lllllllllllllllIlIllIlIlllIlIlII.getChatStyle().setColor(this.getRarity().rarityColor);
        }
        return lllllllllllllllIlIllIlIlllIlIlII;
    }
    
    private ItemStack() {
        this.canDestroyCacheBlock = null;
        this.canDestroyCacheResult = false;
        this.canPlaceOnCacheBlock = null;
        this.canPlaceOnCacheResult = false;
    }
    
    public static boolean areItemsEqual(final ItemStack lllllllllllllllIlIllIllIllIllllI, final ItemStack lllllllllllllllIlIllIllIllIlllIl) {
        return (lllllllllllllllIlIllIllIllIllllI == null && lllllllllllllllIlIllIllIllIlllIl == null) || (lllllllllllllllIlIllIllIllIllllI != null && lllllllllllllllIlIllIllIllIlllIl != null && lllllllllllllllIlIllIllIllIllllI.isItemEqual(lllllllllllllllIlIllIllIllIlllIl));
    }
    
    public void setTagCompound(final NBTTagCompound lllllllllllllllIlIllIllIlIIIIIII) {
        this.stackTagCompound = lllllllllllllllIlIllIllIlIIIIIII;
    }
    
    public static boolean areItemStackTagsEqual(final ItemStack lllllllllllllllIlIllIllIlllllIlI, final ItemStack lllllllllllllllIlIllIllIlllllIIl) {
        return (lllllllllllllllIlIllIllIlllllIlI == null && lllllllllllllllIlIllIllIlllllIIl == null) || (lllllllllllllllIlIllIllIlllllIlI != null && lllllllllllllllIlIllIllIlllllIIl != null && (lllllllllllllllIlIllIllIlllllIlI.stackTagCompound != null || lllllllllllllllIlIllIllIlllllIIl.stackTagCompound == null) && (lllllllllllllllIlIllIllIlllllIlI.stackTagCompound == null || lllllllllllllllIlIllIllIlllllIlI.stackTagCompound.equals(lllllllllllllllIlIllIllIlllllIIl.stackTagCompound)));
    }
    
    public boolean getIsItemStackEqual(final ItemStack lllllllllllllllIlIllIllIlIlIllll) {
        return this.isItemStackEqual(lllllllllllllllIlIllIllIlIlIllll);
    }
    
    public NBTTagCompound getTagCompound() {
        return this.stackTagCompound;
    }
    
    public EnumAction getItemUseAction() {
        return this.getItem().getItemUseAction(this);
    }
    
    public void readFromNBT(final NBTTagCompound lllllllllllllllIlIllIllllIlllIIl) {
        if (lllllllllllllllIlIllIllllIlllIIl.hasKey("id", 8)) {
            this.item = Item.getByNameOrId(lllllllllllllllIlIllIllllIlllIIl.getString("id"));
        }
        else {
            this.item = Item.getItemById(lllllllllllllllIlIllIllllIlllIIl.getShort("id"));
        }
        this.stackSize = lllllllllllllllIlIllIllllIlllIIl.getByte("Count");
        this.itemDamage = lllllllllllllllIlIllIllllIlllIIl.getShort("Damage");
        if (this.itemDamage < 0) {
            this.itemDamage = 0;
        }
        if (lllllllllllllllIlIllIllllIlllIIl.hasKey("tag", 10)) {
            this.stackTagCompound = lllllllllllllllIlIllIllllIlllIIl.getCompoundTag("tag");
            if (this.item != null) {
                this.item.updateItemStackNBT(this.stackTagCompound);
            }
        }
    }
    
    public NBTTagCompound getSubCompound(final String lllllllllllllllIlIllIllIlIIIlIll, final boolean lllllllllllllllIlIllIllIlIIIlllI) {
        if (this.stackTagCompound != null && this.stackTagCompound.hasKey(lllllllllllllllIlIllIllIlIIIlIll, 10)) {
            return this.stackTagCompound.getCompoundTag(lllllllllllllllIlIllIllIlIIIlIll);
        }
        if (lllllllllllllllIlIllIllIlIIIlllI) {
            final NBTTagCompound lllllllllllllllIlIllIllIlIIIllIl = new NBTTagCompound();
            this.setTagInfo(lllllllllllllllIlIllIllIlIIIlIll, lllllllllllllllIlIllIllIlIIIllIl);
            return lllllllllllllllIlIllIllIlIIIllIl;
        }
        return null;
    }
    
    public int getMaxItemUseDuration() {
        return this.getItem().getMaxItemUseDuration(this);
    }
    
    public boolean isItemEqual(final ItemStack lllllllllllllllIlIllIllIllIlIlll) {
        return lllllllllllllllIlIllIllIllIlIlll != null && this.item == lllllllllllllllIlIllIllIllIlIlll.item && this.itemDamage == lllllllllllllllIlIllIllIllIlIlll.itemDamage;
    }
    
    public boolean hasTagCompound() {
        return this.stackTagCompound != null;
    }
    
    public void onBlockDestroyed(final World lllllllllllllllIlIllIlllIIllIlll, final Block lllllllllllllllIlIllIlllIIllllll, final BlockPos lllllllllllllllIlIllIlllIIllIIll, final EntityPlayer lllllllllllllllIlIllIlllIIllIIIl) {
        final boolean lllllllllllllllIlIllIlllIIlllIll = this.item.onBlockDestroyed(this, lllllllllllllllIlIllIlllIIllIlll, lllllllllllllllIlIllIlllIIllllll, lllllllllllllllIlIllIlllIIllIIll, lllllllllllllllIlIllIlllIIllIIIl);
        if (lllllllllllllllIlIllIlllIIlllIll) {
            lllllllllllllllIlIllIlllIIllIIIl.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this.item)]);
        }
    }
    
    public ItemStack(final Item lllllllllllllllIlIlllIIIIIIllllI, final int lllllllllllllllIlIlllIIIIIIlllIl) {
        this(lllllllllllllllIlIlllIIIIIIllllI, lllllllllllllllIlIlllIIIIIIlllIl, 0);
    }
    
    public boolean isOnItemFrame() {
        return this.itemFrame != null;
    }
    
    public ItemStack(final Block lllllllllllllllIlIlllIIIIIllIllI, final int lllllllllllllllIlIlllIIIIIlllIII) {
        this(lllllllllllllllIlIlllIIIIIllIllI, lllllllllllllllIlIlllIIIIIlllIII, 0);
    }
    
    public void setTagInfo(final String lllllllllllllllIlIllIllIIIIlIIII, final NBTBase lllllllllllllllIlIllIllIIIIIllll) {
        if (this.stackTagCompound == null) {
            this.setTagCompound(new NBTTagCompound());
        }
        this.stackTagCompound.setTag(lllllllllllllllIlIllIllIIIIlIIII, lllllllllllllllIlIllIllIIIIIllll);
    }
    
    public String getDisplayName() {
        String lllllllllllllllIlIllIllIIllllIll = this.getItem().getItemStackDisplayName(this);
        if (this.stackTagCompound != null && this.stackTagCompound.hasKey("display", 10)) {
            final NBTTagCompound lllllllllllllllIlIllIllIIllllIlI = this.stackTagCompound.getCompoundTag("display");
            if (lllllllllllllllIlIllIllIIllllIlI.hasKey("Name", 8)) {
                lllllllllllllllIlIllIllIIllllIll = lllllllllllllllIlIllIllIIllllIlI.getString("Name");
            }
        }
        return lllllllllllllllIlIllIllIIllllIll;
    }
    
    public void damageItem(final int lllllllllllllllIlIllIlllIllIllIl, final EntityLivingBase lllllllllllllllIlIllIlllIllIlIll) {
        if ((!(lllllllllllllllIlIllIlllIllIlIll instanceof EntityPlayer) || !((EntityPlayer)lllllllllllllllIlIllIlllIllIlIll).capabilities.isCreativeMode) && this.isItemStackDamageable() && this.attemptDamageItem(lllllllllllllllIlIllIlllIllIllIl, lllllllllllllllIlIllIlllIllIlIll.getRNG())) {
            lllllllllllllllIlIllIlllIllIlIll.renderBrokenItemStack(this);
            --this.stackSize;
            if (lllllllllllllllIlIllIlllIllIlIll instanceof EntityPlayer) {
                final EntityPlayer lllllllllllllllIlIllIlllIllIlIlI = (EntityPlayer)lllllllllllllllIlIllIlllIllIlIll;
                lllllllllllllllIlIllIlllIllIlIlI.triggerAchievement(StatList.objectBreakStats[Item.getIdFromItem(this.item)]);
                if (this.stackSize == 0 && this.getItem() instanceof ItemBow) {
                    lllllllllllllllIlIllIlllIllIlIlI.destroyCurrentEquippedItem();
                }
            }
            if (this.stackSize < 0) {
                this.stackSize = 0;
            }
            this.itemDamage = 0;
        }
    }
    
    public boolean isStackable() {
        return this.getMaxStackSize() > 1 && (!this.isItemStackDamageable() || !this.isItemDamaged());
    }
    
    public static ItemStack loadItemStackFromNBT(final NBTTagCompound lllllllllllllllIlIlllIIIIIIIlIll) {
        final ItemStack lllllllllllllllIlIlllIIIIIIIlIlI = new ItemStack();
        lllllllllllllllIlIlllIIIIIIIlIlI.readFromNBT(lllllllllllllllIlIlllIIIIIIIlIll);
        return (lllllllllllllllIlIlllIIIIIIIlIlI.getItem() != null) ? lllllllllllllllIlIlllIIIIIIIlIlI : null;
    }
    
    public void setItemFrame(final EntityItemFrame lllllllllllllllIlIllIllIIIIIIIlI) {
        this.itemFrame = lllllllllllllllIlIllIllIIIIIIIlI;
    }
    
    public ItemStack(final Block lllllllllllllllIlIlllIIIIIlllllI) {
        this(lllllllllllllllIlIlllIIIIIlllllI, 1);
    }
    
    public ItemStack setStackDisplayName(final String lllllllllllllllIlIllIllIIlllIIIl) {
        if (this.stackTagCompound == null) {
            this.stackTagCompound = new NBTTagCompound();
        }
        if (!this.stackTagCompound.hasKey("display", 10)) {
            this.stackTagCompound.setTag("display", new NBTTagCompound());
        }
        this.stackTagCompound.getCompoundTag("display").setString("Name", lllllllllllllllIlIllIllIIlllIIIl);
        return this;
    }
    
    public float getStrVsBlock(final Block lllllllllllllllIlIllIlllllIllIlI) {
        return this.getItem().getStrVsBlock(this, lllllllllllllllIlIllIlllllIllIlI);
    }
    
    static {
        __OBFID = "CL_00000043";
        DECIMALFORMAT = new DecimalFormat("#.###");
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.stackSize)).append("x").append(this.item.getUnlocalizedName()).append("@").append(this.itemDamage));
    }
}
