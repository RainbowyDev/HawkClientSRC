package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import java.util.*;
import com.google.common.collect.*;

public class ItemFishFood extends ItemFood
{
    private final /* synthetic */ boolean cooked;
    
    @Override
    public float getSaturationModifier(final ItemStack lllllllllllllllIIllIlIlIlIIIlIll) {
        final FishType lllllllllllllllIIllIlIlIlIIIllIl = FishType.getFishTypeForItemStack(lllllllllllllllIIllIlIlIlIIIlIll);
        return (this.cooked && lllllllllllllllIIllIlIlIlIIIllIl.getCookable()) ? lllllllllllllllIIllIlIlIlIIIllIl.getCookedSaturationModifier() : lllllllllllllllIIllIlIlIlIIIllIl.getUncookedSaturationModifier();
    }
    
    @Override
    public void getSubItems(final Item lllllllllllllllIIllIlIlIIlIlIllI, final CreativeTabs lllllllllllllllIIllIlIlIIlIlIlII, final List lllllllllllllllIIllIlIlIIlIIllII) {
        for (final FishType lllllllllllllllIIllIlIlIIlIIlllI : FishType.values()) {
            if (!this.cooked || lllllllllllllllIIllIlIlIIlIIlllI.getCookable()) {
                lllllllllllllllIIllIlIlIIlIIllII.add(new ItemStack(this, 1, lllllllllllllllIIllIlIlIIlIIlllI.getItemDamage()));
            }
        }
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllllIIllIlIlIIIllllII) {
        final FishType lllllllllllllllIIllIlIlIIIlllIlI = FishType.getFishTypeForItemStack(lllllllllllllllIIllIlIlIIIllllII);
        return String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".").append(lllllllllllllllIIllIlIlIIIlllIlI.getUnlocalizedNamePart()).append(".").append((this.cooked && lllllllllllllllIIllIlIlIIIlllIlI.getCookable()) ? "cooked" : "raw"));
    }
    
    @Override
    protected void onFoodEaten(final ItemStack lllllllllllllllIIllIlIlIIllIllII, final World lllllllllllllllIIllIlIlIIllllIlI, final EntityPlayer lllllllllllllllIIllIlIlIIllIlIlI) {
        final FishType lllllllllllllllIIllIlIlIIllIllll = FishType.getFishTypeForItemStack(lllllllllllllllIIllIlIlIIllIllII);
        if (lllllllllllllllIIllIlIlIIllIllll == FishType.PUFFERFISH) {
            lllllllllllllllIIllIlIlIIllIlIlI.addPotionEffect(new PotionEffect(Potion.poison.id, 1200, 3));
            lllllllllllllllIIllIlIlIIllIlIlI.addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 2));
            lllllllllllllllIIllIlIlIIllIlIlI.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 1));
        }
        super.onFoodEaten(lllllllllllllllIIllIlIlIIllIllII, lllllllllllllllIIllIlIlIIllllIlI, lllllllllllllllIIllIlIlIIllIlIlI);
    }
    
    static {
        __OBFID = "CL_00000032";
    }
    
    @Override
    public int getHealAmount(final ItemStack lllllllllllllllIIllIlIlIlIIlIlII) {
        final FishType lllllllllllllllIIllIlIlIlIIlIllI = FishType.getFishTypeForItemStack(lllllllllllllllIIllIlIlIlIIlIlII);
        return (this.cooked && lllllllllllllllIIllIlIlIlIIlIllI.getCookable()) ? lllllllllllllllIIllIlIlIlIIlIllI.getCookedHealAmount() : lllllllllllllllIIllIlIlIlIIlIllI.getUncookedHealAmount();
    }
    
    public ItemFishFood(final boolean lllllllllllllllIIllIlIlIlIIllllI) {
        super(0, 0.0f, false);
        this.cooked = lllllllllllllllIIllIlIlIlIIllllI;
    }
    
    @Override
    public String getPotionEffect(final ItemStack lllllllllllllllIIllIlIlIlIIIIllI) {
        return (FishType.getFishTypeForItemStack(lllllllllllllllIIllIlIlIlIIIIllI) == FishType.PUFFERFISH) ? PotionHelper.field_151423_m : null;
    }
    
    public enum FishType
    {
        CLOWNFISH("CLOWNFISH", 2, "CLOWNFISH", 2, 2, "clownfish", 1, 0.1f), 
        PUFFERFISH("PUFFERFISH", 3, "PUFFERFISH", 3, 3, "pufferfish", 1, 0.1f), 
        SALMON("SALMON", 1, "SALMON", 1, 1, "salmon", 2, 0.1f, 6, 0.8f);
        
        private final /* synthetic */ int itemDamage;
        private final /* synthetic */ String unlocalizedNamePart;
        private final /* synthetic */ int cookedHealAmount;
        private final /* synthetic */ float cookedSaturationModifier;
        
        COD("COD", 0, "COD", 0, 0, "cod", 2, 0.1f, 5, 0.6f);
        
        private static final /* synthetic */ Map itemDamageToFishTypeMap;
        private /* synthetic */ boolean cookable;
        private final /* synthetic */ float uncookedSaturationModifier;
        private final /* synthetic */ int uncookedHealAmount;
        
        public int getItemDamage() {
            return this.itemDamage;
        }
        
        public static FishType getFishTypeForItemDamage(final int llllllllllllllIIlIlllIIlIIIIIIlI) {
            final FishType llllllllllllllIIlIlllIIlIIIIIIIl = FishType.itemDamageToFishTypeMap.get(llllllllllllllIIlIlllIIlIIIIIIlI);
            return (llllllllllllllIIlIlllIIlIIIIIIIl == null) ? FishType.COD : llllllllllllllIIlIlllIIlIIIIIIIl;
        }
        
        public static FishType getFishTypeForItemStack(final ItemStack llllllllllllllIIlIlllIIIllllllII) {
            return (llllllllllllllIIlIlllIIIllllllII.getItem() instanceof ItemFishFood) ? getFishTypeForItemDamage(llllllllllllllIIlIlllIIIllllllII.getMetadata()) : FishType.COD;
        }
        
        public float getCookedSaturationModifier() {
            return this.cookedSaturationModifier;
        }
        
        public float getUncookedSaturationModifier() {
            return this.uncookedSaturationModifier;
        }
        
        public int getUncookedHealAmount() {
            return this.uncookedHealAmount;
        }
        
        static {
            __OBFID = "CL_00000033";
            itemDamageToFishTypeMap = Maps.newHashMap();
            for (final FishType llllllllllllllIIlIlllIIlIlIIlllI : values()) {
                FishType.itemDamageToFishTypeMap.put(llllllllllllllIIlIlllIIlIlIIlllI.getItemDamage(), llllllllllllllIIlIlllIIlIlIIlllI);
            }
        }
        
        public boolean getCookable() {
            return this.cookable;
        }
        
        private FishType(final String llllllllllllllIIlIlllIIlIIllIllI, final int llllllllllllllIIlIlllIIlIIllIlIl, final String llllllllllllllIIlIlllIIlIIllllll, final int llllllllllllllIIlIlllIIlIIlllllI, final int llllllllllllllIIlIlllIIlIIllllIl, final String llllllllllllllIIlIlllIIlIIllllII, final int llllllllllllllIIlIlllIIlIIlllIll, final float llllllllllllllIIlIlllIIlIIllIIIl, final int llllllllllllllIIlIlllIIlIIllIIII, final float llllllllllllllIIlIlllIIlIIlllIII) {
            this.cookable = false;
            this.itemDamage = llllllllllllllIIlIlllIIlIIllllIl;
            this.unlocalizedNamePart = llllllllllllllIIlIlllIIlIIllllII;
            this.uncookedHealAmount = llllllllllllllIIlIlllIIlIIlllIll;
            this.uncookedSaturationModifier = llllllllllllllIIlIlllIIlIIllIIIl;
            this.cookedHealAmount = llllllllllllllIIlIlllIIlIIllIIII;
            this.cookedSaturationModifier = llllllllllllllIIlIlllIIlIIlllIII;
            this.cookable = true;
        }
        
        public int getCookedHealAmount() {
            return this.cookedHealAmount;
        }
        
        public String getUnlocalizedNamePart() {
            return this.unlocalizedNamePart;
        }
        
        private FishType(final String llllllllllllllIIlIlllIIlIIIlllll, final int llllllllllllllIIlIlllIIlIIIllllI, final String llllllllllllllIIlIlllIIlIIlIIllI, final int llllllllllllllIIlIlllIIlIIlIIlIl, final int llllllllllllllIIlIlllIIlIIIlllIl, final String llllllllllllllIIlIlllIIlIIIlllII, final int llllllllllllllIIlIlllIIlIIIllIll, final float llllllllllllllIIlIlllIIlIIlIIIIl) {
            this.cookable = false;
            this.itemDamage = llllllllllllllIIlIlllIIlIIIlllIl;
            this.unlocalizedNamePart = llllllllllllllIIlIlllIIlIIIlllII;
            this.uncookedHealAmount = llllllllllllllIIlIlllIIlIIIllIll;
            this.uncookedSaturationModifier = llllllllllllllIIlIlllIIlIIlIIIIl;
            this.cookedHealAmount = 0;
            this.cookedSaturationModifier = 0.0f;
            this.cookable = false;
        }
    }
}
