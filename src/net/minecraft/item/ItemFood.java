package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.potion.*;
import net.minecraft.creativetab.*;

public class ItemFood extends Item
{
    public final /* synthetic */ int itemUseDuration;
    private /* synthetic */ int potionAmplifier;
    private final /* synthetic */ int healAmount;
    private final /* synthetic */ float saturationModifier;
    private /* synthetic */ int potionId;
    private /* synthetic */ float potionEffectProbability;
    private /* synthetic */ boolean alwaysEdible;
    private /* synthetic */ int potionDuration;
    private final /* synthetic */ boolean isWolfsFavoriteMeat;
    
    @Override
    public ItemStack onItemUseFinish(final ItemStack llllllllllllllIllIlIlllllIlllIII, final World llllllllllllllIllIlIlllllIllIlll, final EntityPlayer llllllllllllllIllIlIlllllIllIllI) {
        --llllllllllllllIllIlIlllllIlllIII.stackSize;
        llllllllllllllIllIlIlllllIllIllI.getFoodStats().addStats(this, llllllllllllllIllIlIlllllIlllIII);
        llllllllllllllIllIlIlllllIllIlll.playSoundAtEntity(llllllllllllllIllIlIlllllIllIllI, "random.burp", 0.5f, llllllllllllllIllIlIlllllIllIlll.rand.nextFloat() * 0.1f + 0.9f);
        this.onFoodEaten(llllllllllllllIllIlIlllllIlllIII, llllllllllllllIllIlIlllllIllIlll, llllllllllllllIllIlIlllllIllIllI);
        llllllllllllllIllIlIlllllIllIllI.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return llllllllllllllIllIlIlllllIlllIII;
    }
    
    public ItemFood setPotionEffect(final int llllllllllllllIllIlIlllllIIIIIll, final int llllllllllllllIllIlIlllllIIIIlll, final int llllllllllllllIllIlIlllllIIIIIIl, final float llllllllllllllIllIlIlllllIIIIlIl) {
        this.potionId = llllllllllllllIllIlIlllllIIIIIll;
        this.potionDuration = llllllllllllllIllIlIlllllIIIIlll;
        this.potionAmplifier = llllllllllllllIllIlIlllllIIIIIIl;
        this.potionEffectProbability = llllllllllllllIllIlIlllllIIIIlIl;
        return this;
    }
    
    public float getSaturationModifier(final ItemStack llllllllllllllIllIlIlllllIIlIIll) {
        return this.saturationModifier;
    }
    
    public boolean isWolfsFavoriteMeat() {
        return this.isWolfsFavoriteMeat;
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack llllllllllllllIllIlIlllllIlIIllI) {
        return 32;
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack llllllllllllllIllIlIlllllIlIIlII) {
        return EnumAction.EAT;
    }
    
    protected void onFoodEaten(final ItemStack llllllllllllllIllIlIlllllIlIllIl, final World llllllllllllllIllIlIlllllIlIlIIl, final EntityPlayer llllllllllllllIllIlIlllllIlIlIII) {
        if (!llllllllllllllIllIlIlllllIlIlIIl.isRemote && this.potionId > 0 && llllllllllllllIllIlIlllllIlIlIIl.rand.nextFloat() < this.potionEffectProbability) {
            llllllllllllllIllIlIlllllIlIlIII.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
        }
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllIllIlIlllllIIllIll, final World llllllllllllllIllIlIlllllIIllllI, final EntityPlayer llllllllllllllIllIlIlllllIIllIlI) {
        if (llllllllllllllIllIlIlllllIIllIlI.canEat(this.alwaysEdible)) {
            llllllllllllllIllIlIlllllIIllIlI.setItemInUse(llllllllllllllIllIlIlllllIIllIll, this.getMaxItemUseDuration(llllllllllllllIllIlIlllllIIllIll));
        }
        return llllllllllllllIllIlIlllllIIllIll;
    }
    
    static {
        __OBFID = "CL_00000036";
    }
    
    public int getHealAmount(final ItemStack llllllllllllllIllIlIlllllIIlIlll) {
        return this.healAmount;
    }
    
    public ItemFood setAlwaysEdible() {
        this.alwaysEdible = true;
        return this;
    }
    
    public ItemFood(final int llllllllllllllIllIlIllllllIIlIIl, final float llllllllllllllIllIlIllllllIIlIII, final boolean llllllllllllllIllIlIllllllIIIlll) {
        this.itemUseDuration = 32;
        this.healAmount = llllllllllllllIllIlIllllllIIlIIl;
        this.isWolfsFavoriteMeat = llllllllllllllIllIlIllllllIIIlll;
        this.saturationModifier = llllllllllllllIllIlIllllllIIlIII;
        this.setCreativeTab(CreativeTabs.tabFood);
    }
    
    public ItemFood(final int llllllllllllllIllIlIlllllIllllll, final boolean llllllllllllllIllIlIllllllIIIIIl) {
        this(llllllllllllllIllIlIlllllIllllll, 0.6f, llllllllllllllIllIlIllllllIIIIIl);
    }
}
