package net.minecraft.item;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.potion.*;
import net.minecraft.creativetab.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;

public class ItemPotion extends Item
{
    private /* synthetic */ Map effectCache;
    private static final /* synthetic */ Map field_77835_b;
    
    static {
        __OBFID = "CL_00000055";
        field_77835_b = Maps.newLinkedHashMap();
    }
    
    public List getEffects(final ItemStack llllllllllllllIIIlIIlIlllllIllII) {
        if (llllllllllllllIIIlIIlIlllllIllII.hasTagCompound() && llllllllllllllIIIlIIlIlllllIllII.getTagCompound().hasKey("CustomPotionEffects", 9)) {
            final ArrayList llllllllllllllIIIlIIlIlllllIlIll = Lists.newArrayList();
            final NBTTagList llllllllllllllIIIlIIlIlllllIlIlI = llllllllllllllIIIlIIlIlllllIllII.getTagCompound().getTagList("CustomPotionEffects", 10);
            for (int llllllllllllllIIIlIIlIlllllIlIIl = 0; llllllllllllllIIIlIIlIlllllIlIIl < llllllllllllllIIIlIIlIlllllIlIlI.tagCount(); ++llllllllllllllIIIlIIlIlllllIlIIl) {
                final NBTTagCompound llllllllllllllIIIlIIlIlllllIlIII = llllllllllllllIIIlIIlIlllllIlIlI.getCompoundTagAt(llllllllllllllIIIlIIlIlllllIlIIl);
                final PotionEffect llllllllllllllIIIlIIlIlllllIIlll = PotionEffect.readCustomPotionEffectFromNBT(llllllllllllllIIIlIIlIlllllIlIII);
                if (llllllllllllllIIIlIIlIlllllIIlll != null) {
                    llllllllllllllIIIlIIlIlllllIlIll.add(llllllllllllllIIIlIIlIlllllIIlll);
                }
            }
            return llllllllllllllIIIlIIlIlllllIlIll;
        }
        List llllllllllllllIIIlIIlIlllllIIllI = this.effectCache.get(llllllllllllllIIIlIIlIlllllIllII.getMetadata());
        if (llllllllllllllIIIlIIlIlllllIIllI == null) {
            llllllllllllllIIIlIIlIlllllIIllI = PotionHelper.getPotionEffects(llllllllllllllIIIlIIlIlllllIllII.getMetadata(), false);
            this.effectCache.put(llllllllllllllIIIlIIlIlllllIllII.getMetadata(), llllllllllllllIIIlIIlIlllllIIllI);
        }
        return llllllllllllllIIIlIIlIlllllIIllI;
    }
    
    @Override
    public ItemStack onItemUseFinish(final ItemStack llllllllllllllIIIlIIlIllllIIIllI, final World llllllllllllllIIIlIIlIllllIIIlIl, final EntityPlayer llllllllllllllIIIlIIlIllllIIlIll) {
        if (!llllllllllllllIIIlIIlIllllIIlIll.capabilities.isCreativeMode) {
            --llllllllllllllIIIlIIlIllllIIIllI.stackSize;
        }
        if (!llllllllllllllIIIlIIlIllllIIIlIl.isRemote) {
            final List llllllllllllllIIIlIIlIllllIIlIlI = this.getEffects(llllllllllllllIIIlIIlIllllIIIllI);
            if (llllllllllllllIIIlIIlIllllIIlIlI != null) {
                for (final PotionEffect llllllllllllllIIIlIIlIllllIIlIII : llllllllllllllIIIlIIlIllllIIlIlI) {
                    llllllllllllllIIIlIIlIllllIIlIll.addPotionEffect(new PotionEffect(llllllllllllllIIIlIIlIllllIIlIII));
                }
            }
        }
        llllllllllllllIIIlIIlIllllIIlIll.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        if (!llllllllllllllIIIlIIlIllllIIlIll.capabilities.isCreativeMode) {
            if (llllllllllllllIIIlIIlIllllIIIllI.stackSize <= 0) {
                return new ItemStack(Items.glass_bottle);
            }
            llllllllllllllIIIlIIlIllllIIlIll.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        }
        return llllllllllllllIIIlIIlIllllIIIllI;
    }
    
    public boolean isEffectInstant(final int llllllllllllllIIIlIIlIlllIIlIlIl) {
        final List llllllllllllllIIIlIIlIlllIIllIIl = this.getEffects(llllllllllllllIIIlIIlIlllIIlIlIl);
        if (llllllllllllllIIIlIIlIlllIIllIIl != null && !llllllllllllllIIIlIIlIlllIIllIIl.isEmpty()) {
            for (final PotionEffect llllllllllllllIIIlIIlIlllIIlIlll : llllllllllllllIIIlIIlIlllIIllIIl) {
                if (Potion.potionTypes[llllllllllllllIIIlIIlIlllIIlIlll.getPotionID()].isInstant()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    public ItemPotion() {
        this.effectCache = Maps.newHashMap();
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabBrewing);
    }
    
    @Override
    public void getSubItems(final Item llllllllllllllIIIlIIlIlIIlIllIlI, final CreativeTabs llllllllllllllIIIlIIlIlIIlIIllII, final List llllllllllllllIIIlIIlIlIIlIllIII) {
        super.getSubItems(llllllllllllllIIIlIIlIlIIlIllIlI, llllllllllllllIIIlIIlIlIIlIIllII, llllllllllllllIIIlIIlIlIIlIllIII);
        if (ItemPotion.field_77835_b.isEmpty()) {
            for (int llllllllllllllIIIlIIlIlIIlIlIlIl = 0; llllllllllllllIIIlIIlIlIIlIlIlIl <= 15; ++llllllllllllllIIIlIIlIlIIlIlIlIl) {
                for (int llllllllllllllIIIlIIlIlIIlIlIlll = 0; llllllllllllllIIIlIIlIlIIlIlIlll <= 1; ++llllllllllllllIIIlIIlIlIIlIlIlll) {
                    int llllllllllllllIIIlIIlIlIIlIlIIll = 0;
                    if (llllllllllllllIIIlIIlIlIIlIlIlll == 0) {
                        final int llllllllllllllIIIlIIlIlIIlIlIlII = llllllllllllllIIIlIIlIlIIlIlIlIl | 0x2000;
                    }
                    else {
                        llllllllllllllIIIlIIlIlIIlIlIIll = (llllllllllllllIIIlIIlIlIIlIlIlIl | 0x4000);
                    }
                    for (int llllllllllllllIIIlIIlIlIIlIlIIlI = 0; llllllllllllllIIIlIIlIlIIlIlIIlI <= 2; ++llllllllllllllIIIlIIlIlIIlIlIIlI) {
                        int llllllllllllllIIIlIIlIlIIlIlIIIl = llllllllllllllIIIlIIlIlIIlIlIIll;
                        if (llllllllllllllIIIlIIlIlIIlIlIIlI != 0) {
                            if (llllllllllllllIIIlIIlIlIIlIlIIlI == 1) {
                                llllllllllllllIIIlIIlIlIIlIlIIIl = (llllllllllllllIIIlIIlIlIIlIlIIll | 0x20);
                            }
                            else if (llllllllllllllIIIlIIlIlIIlIlIIlI == 2) {
                                llllllllllllllIIIlIIlIlIIlIlIIIl = (llllllllllllllIIIlIIlIlIIlIlIIll | 0x40);
                            }
                        }
                        final List llllllllllllllIIIlIIlIlIIlIlIIII = PotionHelper.getPotionEffects(llllllllllllllIIIlIIlIlIIlIlIIIl, false);
                        if (llllllllllllllIIIlIIlIlIIlIlIIII != null && !llllllllllllllIIIlIIlIlIIlIlIIII.isEmpty()) {
                            ItemPotion.field_77835_b.put(llllllllllllllIIIlIIlIlIIlIlIIII, llllllllllllllIIIlIIlIlIIlIlIIIl);
                        }
                    }
                }
            }
        }
        for (final int llllllllllllllIIIlIIlIlIIlIlIllI : ItemPotion.field_77835_b.values()) {
            llllllllllllllIIIlIIlIlIIlIllIII.add(new ItemStack(llllllllllllllIIIlIIlIlIIlIllIlI, 1, llllllllllllllIIIlIIlIlIIlIlIllI));
        }
    }
    
    public static boolean isSplash(final int llllllllllllllIIIlIIlIlllIlIlllI) {
        return (llllllllllllllIIIlIIlIlllIlIlllI & 0x4000) != 0x0;
    }
    
    public List getEffects(final int llllllllllllllIIIlIIlIllllIlIlll) {
        List llllllllllllllIIIlIIlIllllIllIIl = this.effectCache.get(llllllllllllllIIIlIIlIllllIlIlll);
        if (llllllllllllllIIIlIIlIllllIllIIl == null) {
            llllllllllllllIIIlIIlIllllIllIIl = PotionHelper.getPotionEffects(llllllllllllllIIIlIIlIllllIlIlll, false);
            this.effectCache.put(llllllllllllllIIIlIIlIllllIlIlll, llllllllllllllIIIlIIlIllllIllIIl);
        }
        return llllllllllllllIIIlIIlIllllIllIIl;
    }
    
    public int getColorFromDamage(final int llllllllllllllIIIlIIlIlllIlIlIlI) {
        return PotionHelper.func_77915_a(llllllllllllllIIIlIIlIlllIlIlIlI, false);
    }
    
    @Override
    public void addInformation(final ItemStack llllllllllllllIIIlIIlIlIlIIlIIIl, final EntityPlayer llllllllllllllIIIlIIlIlIlIIlIIII, final List llllllllllllllIIIlIIlIlIIllllIlI, final boolean llllllllllllllIIIlIIlIlIlIIIlllI) {
        if (llllllllllllllIIIlIIlIlIlIIlIIIl.getMetadata() != 0) {
            final List llllllllllllllIIIlIIlIlIlIIIllIl = Items.potionitem.getEffects(llllllllllllllIIIlIIlIlIlIIlIIIl);
            final HashMultimap llllllllllllllIIIlIIlIlIlIIIllII = HashMultimap.create();
            if (llllllllllllllIIIlIIlIlIlIIIllIl != null && !llllllllllllllIIIlIIlIlIlIIIllIl.isEmpty()) {
                for (final PotionEffect llllllllllllllIIIlIIlIlIlIIIlIIl : llllllllllllllIIIlIIlIlIlIIIllIl) {
                    String llllllllllllllIIIlIIlIlIlIIIlIII = StatCollector.translateToLocal(llllllllllllllIIIlIIlIlIlIIIlIIl.getEffectName()).trim();
                    final Potion llllllllllllllIIIlIIlIlIlIIIIlll = Potion.potionTypes[llllllllllllllIIIlIIlIlIlIIIlIIl.getPotionID()];
                    final Map llllllllllllllIIIlIIlIlIlIIIIllI = llllllllllllllIIIlIIlIlIlIIIIlll.func_111186_k();
                    if (llllllllllllllIIIlIIlIlIlIIIIllI != null && llllllllllllllIIIlIIlIlIlIIIIllI.size() > 0) {
                        for (final Map.Entry llllllllllllllIIIlIIlIlIlIIIIlII : llllllllllllllIIIlIIlIlIlIIIIllI.entrySet()) {
                            final AttributeModifier llllllllllllllIIIlIIlIlIlIIIIIll = llllllllllllllIIIlIIlIlIlIIIIlII.getValue();
                            final AttributeModifier llllllllllllllIIIlIIlIlIlIIIIIlI = new AttributeModifier(llllllllllllllIIIlIIlIlIlIIIIIll.getName(), llllllllllllllIIIlIIlIlIlIIIIlll.func_111183_a(llllllllllllllIIIlIIlIlIlIIIlIIl.getAmplifier(), llllllllllllllIIIlIIlIlIlIIIIIll), llllllllllllllIIIlIIlIlIlIIIIIll.getOperation());
                            llllllllllllllIIIlIIlIlIlIIIllII.put((Object)llllllllllllllIIIlIIlIlIlIIIIlII.getKey().getAttributeUnlocalizedName(), (Object)llllllllllllllIIIlIIlIlIlIIIIIlI);
                        }
                    }
                    if (llllllllllllllIIIlIIlIlIlIIIlIIl.getAmplifier() > 0) {
                        llllllllllllllIIIlIIlIlIlIIIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIIlIlIlIIIlIII)).append(" ").append(StatCollector.translateToLocal(String.valueOf(new StringBuilder("potion.potency.").append(llllllllllllllIIIlIIlIlIlIIIlIIl.getAmplifier()))).trim()));
                    }
                    if (llllllllllllllIIIlIIlIlIlIIIlIIl.getDuration() > 20) {
                        llllllllllllllIIIlIIlIlIlIIIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIIlIlIlIIIlIII)).append(" (").append(Potion.getDurationString(llllllllllllllIIIlIIlIlIlIIIlIIl)).append(")"));
                    }
                    if (llllllllllllllIIIlIIlIlIlIIIIlll.isBadEffect()) {
                        llllllllllllllIIIlIIlIlIIllllIlI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append(llllllllllllllIIIlIIlIlIlIIIlIII)));
                    }
                    else {
                        llllllllllllllIIIlIIlIlIIllllIlI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append(llllllllllllllIIIlIIlIlIlIIIlIII)));
                    }
                }
            }
            else {
                final String llllllllllllllIIIlIIlIlIlIIIIIIl = StatCollector.translateToLocal("potion.empty").trim();
                llllllllllllllIIIlIIlIlIIllllIlI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append(llllllllllllllIIIlIIlIlIlIIIIIIl)));
            }
            if (!llllllllllllllIIIlIIlIlIlIIIllII.isEmpty()) {
                llllllllllllllIIIlIIlIlIIllllIlI.add("");
                llllllllllllllIIIlIIlIlIIllllIlI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_PURPLE).append(StatCollector.translateToLocal("potion.effects.whenDrank"))));
                for (final Map.Entry llllllllllllllIIIlIIlIlIlIIIIIII : llllllllllllllIIIlIIlIlIlIIIllII.entries()) {
                    final AttributeModifier llllllllllllllIIIlIIlIlIIlllllll = llllllllllllllIIIlIIlIlIlIIIIIII.getValue();
                    final double llllllllllllllIIIlIIlIlIIllllllI = llllllllllllllIIIlIIlIlIIlllllll.getAmount();
                    double llllllllllllllIIIlIIlIlIIlllllII = 0.0;
                    if (llllllllllllllIIIlIIlIlIIlllllll.getOperation() != 1 && llllllllllllllIIIlIIlIlIIlllllll.getOperation() != 2) {
                        final double llllllllllllllIIIlIIlIlIIlllllIl = llllllllllllllIIIlIIlIlIIlllllll.getAmount();
                    }
                    else {
                        llllllllllllllIIIlIIlIlIIlllllII = llllllllllllllIIIlIIlIlIIlllllll.getAmount() * 100.0;
                    }
                    if (llllllllllllllIIIlIIlIlIIllllllI > 0.0) {
                        llllllllllllllIIIlIIlIlIIllllIlI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.BLUE).append(StatCollector.translateToLocalFormatted(String.valueOf(new StringBuilder("attribute.modifier.plus.").append(llllllllllllllIIIlIIlIlIIlllllll.getOperation())), ItemStack.DECIMALFORMAT.format(llllllllllllllIIIlIIlIlIIlllllII), StatCollector.translateToLocal(String.valueOf(new StringBuilder("attribute.name.").append(llllllllllllllIIIlIIlIlIlIIIIIII.getKey())))))));
                    }
                    else {
                        if (llllllllllllllIIIlIIlIlIIllllllI >= 0.0) {
                            continue;
                        }
                        llllllllllllllIIIlIIlIlIIlllllII *= -1.0;
                        llllllllllllllIIIlIIlIlIIllllIlI.add(String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append(StatCollector.translateToLocalFormatted(String.valueOf(new StringBuilder("attribute.modifier.take.").append(llllllllllllllIIIlIIlIlIIlllllll.getOperation())), ItemStack.DECIMALFORMAT.format(llllllllllllllIIIlIIlIlIIlllllII), StatCollector.translateToLocal(String.valueOf(new StringBuilder("attribute.name.").append(llllllllllllllIIIlIIlIlIlIIIIIII.getKey())))))));
                    }
                }
            }
        }
    }
    
    @Override
    public int getColorFromItemStack(final ItemStack llllllllllllllIIIlIIlIlllIlIIIlI, final int llllllllllllllIIIlIIlIlllIlIIIIl) {
        return (llllllllllllllIIIlIIlIlllIlIIIIl > 0) ? 16777215 : this.getColorFromDamage(llllllllllllllIIIlIIlIlllIlIIIlI.getMetadata());
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack llllllllllllllIIIlIIlIlllIllllIl) {
        return EnumAction.DRINK;
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack llllllllllllllIIIlIIlIlllIIIlIll) {
        if (llllllllllllllIIIlIIlIlllIIIlIll.getMetadata() == 0) {
            return StatCollector.translateToLocal("item.emptyPotion.name").trim();
        }
        String llllllllllllllIIIlIIlIlllIIIlIlI = "";
        if (isSplash(llllllllllllllIIIlIIlIlllIIIlIll.getMetadata())) {
            llllllllllllllIIIlIIlIlllIIIlIlI = String.valueOf(new StringBuilder(String.valueOf(StatCollector.translateToLocal("potion.prefix.grenade").trim())).append(" "));
        }
        final List llllllllllllllIIIlIIlIlllIIIlIIl = Items.potionitem.getEffects(llllllllllllllIIIlIIlIlllIIIlIll);
        if (llllllllllllllIIIlIIlIlllIIIlIIl != null && !llllllllllllllIIIlIIlIlllIIIlIIl.isEmpty()) {
            String llllllllllllllIIIlIIlIlllIIIlIII = llllllllllllllIIIlIIlIlllIIIlIIl.get(0).getEffectName();
            llllllllllllllIIIlIIlIlllIIIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIIlIlllIIIlIII)).append(".postfix"));
            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIIlIlllIIIlIlI)).append(StatCollector.translateToLocal(llllllllllllllIIIlIIlIlllIIIlIII).trim()));
        }
        final String llllllllllllllIIIlIIlIlllIIIIlll = PotionHelper.func_77905_c(llllllllllllllIIIlIIlIlllIIIlIll.getMetadata());
        return String.valueOf(new StringBuilder(String.valueOf(StatCollector.translateToLocal(llllllllllllllIIIlIIlIlllIIIIlll).trim())).append(" ").append(super.getItemStackDisplayName(llllllllllllllIIIlIIlIlllIIIlIll)));
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack llllllllllllllIIIlIIlIlllIllllll) {
        return 32;
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllIIIlIIlIlllIllIIll, final World llllllllllllllIIIlIIlIlllIllIIlI, final EntityPlayer llllllllllllllIIIlIIlIlllIllIlIl) {
        if (isSplash(llllllllllllllIIIlIIlIlllIllIIll.getMetadata())) {
            if (!llllllllllllllIIIlIIlIlllIllIlIl.capabilities.isCreativeMode) {
                --llllllllllllllIIIlIIlIlllIllIIll.stackSize;
            }
            llllllllllllllIIIlIIlIlllIllIIlI.playSoundAtEntity(llllllllllllllIIIlIIlIlllIllIlIl, "random.bow", 0.5f, 0.4f / (ItemPotion.itemRand.nextFloat() * 0.4f + 0.8f));
            if (!llllllllllllllIIIlIIlIlllIllIIlI.isRemote) {
                llllllllllllllIIIlIIlIlllIllIIlI.spawnEntityInWorld(new EntityPotion(llllllllllllllIIIlIIlIlllIllIIlI, llllllllllllllIIIlIIlIlllIllIlIl, llllllllllllllIIIlIIlIlllIllIIll));
            }
            llllllllllllllIIIlIIlIlllIllIlIl.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
            return llllllllllllllIIIlIIlIlllIllIIll;
        }
        llllllllllllllIIIlIIlIlllIllIlIl.setItemInUse(llllllllllllllIIIlIIlIlllIllIIll, this.getMaxItemUseDuration(llllllllllllllIIIlIIlIlllIllIIll));
        return llllllllllllllIIIlIIlIlllIllIIll;
    }
    
    @Override
    public boolean hasEffect(final ItemStack llllllllllllllIIIlIIlIlIIllIIlll) {
        final List llllllllllllllIIIlIIlIlIIllIlIIl = this.getEffects(llllllllllllllIIIlIIlIlIIllIIlll);
        return llllllllllllllIIIlIIlIlIIllIlIIl != null && !llllllllllllllIIIlIIlIlIIllIlIIl.isEmpty();
    }
}
