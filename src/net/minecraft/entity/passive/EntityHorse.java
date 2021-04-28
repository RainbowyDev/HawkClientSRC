package net.minecraft.entity.passive;

import com.google.common.base.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.block.material.*;
import net.minecraft.server.management.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.potion.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.ai.*;
import net.minecraft.inventory.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityHorse extends EntityAnimal implements IInvBasic
{
    private /* synthetic */ float prevHeadLean;
    public /* synthetic */ int field_110279_bq;
    private /* synthetic */ AnimalChest horseChest;
    private /* synthetic */ float rearingAmount;
    private /* synthetic */ float headLean;
    private static final /* synthetic */ IAttribute horseJumpStrength;
    private static final /* synthetic */ Predicate horseBreedingSelector;
    private /* synthetic */ String[] field_110280_bR;
    private /* synthetic */ boolean field_175508_bO;
    private /* synthetic */ int jumpRearingCounter;
    private /* synthetic */ boolean hasReproduced;
    protected /* synthetic */ float jumpPower;
    private static final /* synthetic */ String[] horseMarkingTextures;
    private /* synthetic */ boolean field_110294_bI;
    protected /* synthetic */ boolean horseJumping;
    protected /* synthetic */ int temper;
    private /* synthetic */ int openMouthCounter;
    private /* synthetic */ int eatingHaystackCounter;
    private /* synthetic */ float prevRearingAmount;
    private static final /* synthetic */ String[] horseTextures;
    private /* synthetic */ float mouthOpenness;
    private static final /* synthetic */ String[] field_110292_bC;
    public /* synthetic */ int field_110278_bp;
    private static final /* synthetic */ String[] field_110273_bx;
    private static final /* synthetic */ String[] horseArmorTextures;
    private /* synthetic */ String field_110286_bQ;
    private static final /* synthetic */ int[] armorValues;
    private /* synthetic */ float prevMouthOpenness;
    private /* synthetic */ int gallopTime;
    private static final /* synthetic */ String[] field_110269_bA;
    
    public boolean isRearing() {
        return this.getHorseWatchableBoolean(64);
    }
    
    public boolean isChested() {
        return this.getHorseWatchableBoolean(8);
    }
    
    public String getHorseTexture() {
        if (this.field_110286_bQ == null) {
            this.setHorseTexturePaths();
        }
        return this.field_110286_bQ;
    }
    
    public void setHorseJumping(final boolean lllllllllllllllIlllIlIIIIllIIIll) {
        this.horseJumping = lllllllllllllllIlllIlIIIIllIIIll;
    }
    
    @Override
    public int getTalkInterval() {
        return 400;
    }
    
    static {
        __OBFID = "CL_00001641";
        horseBreedingSelector = (Predicate)new Predicate() {
            public boolean func_179873_a(final Entity lllllllllllllllIIlIIIIIIIIlIIIIl) {
                return lllllllllllllllIIlIIIIIIIIlIIIIl instanceof EntityHorse && ((EntityHorse)lllllllllllllllIIlIIIIIIIIlIIIIl).func_110205_ce();
            }
            
            public boolean apply(final Object lllllllllllllllIIlIIIIIIIIIllIlI) {
                return this.func_179873_a((Entity)lllllllllllllllIIlIIIIIIIIIllIlI);
            }
            
            static {
                __OBFID = "CL_00001642";
            }
        };
        horseJumpStrength = new RangedAttribute(null, "horse.jumpStrength", 0.7, 0.0, 2.0).setDescription("Jump Strength").setShouldWatch(true);
        horseArmorTextures = new String[] { null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png" };
        field_110273_bx = new String[] { "", "meo", "goo", "dio" };
        armorValues = new int[] { 0, 5, 7, 11 };
        horseTextures = new String[] { "textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png" };
        field_110269_bA = new String[] { "hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb" };
        horseMarkingTextures = new String[] { null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png" };
        field_110292_bC = new String[] { "", "wo_", "wmo", "wdo", "bdo" };
    }
    
    @Override
    public boolean interact(final EntityPlayer lllllllllllllllIlllIIlllIIllIIll) {
        final ItemStack lllllllllllllllIlllIIlllIIllIIlI = lllllllllllllllIlllIIlllIIllIIll.inventory.getCurrentItem();
        if (lllllllllllllllIlllIIlllIIllIIlI != null && lllllllllllllllIlllIIlllIIllIIlI.getItem() == Items.spawn_egg) {
            return super.interact(lllllllllllllllIlllIIlllIIllIIll);
        }
        if (!this.isTame() && this.isUndead()) {
            return false;
        }
        if (this.isTame() && this.isAdultHorse() && lllllllllllllllIlllIIlllIIllIIll.isSneaking()) {
            this.openGUI(lllllllllllllllIlllIIlllIIllIIll);
            return true;
        }
        if (this.func_110253_bW() && this.riddenByEntity != null) {
            return super.interact(lllllllllllllllIlllIIlllIIllIIll);
        }
        if (lllllllllllllllIlllIIlllIIllIIlI != null) {
            boolean lllllllllllllllIlllIIlllIIllIIIl = false;
            if (this.canWearArmor()) {
                byte lllllllllllllllIlllIIlllIIllIIII = -1;
                if (lllllllllllllllIlllIIlllIIllIIlI.getItem() == Items.iron_horse_armor) {
                    lllllllllllllllIlllIIlllIIllIIII = 1;
                }
                else if (lllllllllllllllIlllIIlllIIllIIlI.getItem() == Items.golden_horse_armor) {
                    lllllllllllllllIlllIIlllIIllIIII = 2;
                }
                else if (lllllllllllllllIlllIIlllIIllIIlI.getItem() == Items.diamond_horse_armor) {
                    lllllllllllllllIlllIIlllIIllIIII = 3;
                }
                if (lllllllllllllllIlllIIlllIIllIIII >= 0) {
                    if (!this.isTame()) {
                        this.makeHorseRearWithSound();
                        return true;
                    }
                    this.openGUI(lllllllllllllllIlllIIlllIIllIIll);
                    return true;
                }
            }
            if (!lllllllllllllllIlllIIlllIIllIIIl && !this.isUndead()) {
                float lllllllllllllllIlllIIlllIIlIllll = 0.0f;
                short lllllllllllllllIlllIIlllIIlIlllI = 0;
                byte lllllllllllllllIlllIIlllIIlIllIl = 0;
                if (lllllllllllllllIlllIIlllIIllIIlI.getItem() == Items.wheat) {
                    lllllllllllllllIlllIIlllIIlIllll = 2.0f;
                    lllllllllllllllIlllIIlllIIlIlllI = 20;
                    lllllllllllllllIlllIIlllIIlIllIl = 3;
                }
                else if (lllllllllllllllIlllIIlllIIllIIlI.getItem() == Items.sugar) {
                    lllllllllllllllIlllIIlllIIlIllll = 1.0f;
                    lllllllllllllllIlllIIlllIIlIlllI = 30;
                    lllllllllllllllIlllIIlllIIlIllIl = 3;
                }
                else if (Block.getBlockFromItem(lllllllllllllllIlllIIlllIIllIIlI.getItem()) == Blocks.hay_block) {
                    lllllllllllllllIlllIIlllIIlIllll = 20.0f;
                    lllllllllllllllIlllIIlllIIlIlllI = 180;
                }
                else if (lllllllllllllllIlllIIlllIIllIIlI.getItem() == Items.apple) {
                    lllllllllllllllIlllIIlllIIlIllll = 3.0f;
                    lllllllllllllllIlllIIlllIIlIlllI = 60;
                    lllllllllllllllIlllIIlllIIlIllIl = 3;
                }
                else if (lllllllllllllllIlllIIlllIIllIIlI.getItem() == Items.golden_carrot) {
                    lllllllllllllllIlllIIlllIIlIllll = 4.0f;
                    lllllllllllllllIlllIIlllIIlIlllI = 60;
                    lllllllllllllllIlllIIlllIIlIllIl = 5;
                    if (this.isTame() && this.getGrowingAge() == 0) {
                        lllllllllllllllIlllIIlllIIllIIIl = true;
                        this.setInLove(lllllllllllllllIlllIIlllIIllIIll);
                    }
                }
                else if (lllllllllllllllIlllIIlllIIllIIlI.getItem() == Items.golden_apple) {
                    lllllllllllllllIlllIIlllIIlIllll = 10.0f;
                    lllllllllllllllIlllIIlllIIlIlllI = 240;
                    lllllllllllllllIlllIIlllIIlIllIl = 10;
                    if (this.isTame() && this.getGrowingAge() == 0) {
                        lllllllllllllllIlllIIlllIIllIIIl = true;
                        this.setInLove(lllllllllllllllIlllIIlllIIllIIll);
                    }
                }
                if (this.getHealth() < this.getMaxHealth() && lllllllllllllllIlllIIlllIIlIllll > 0.0f) {
                    this.heal(lllllllllllllllIlllIIlllIIlIllll);
                    lllllllllllllllIlllIIlllIIllIIIl = true;
                }
                if (!this.isAdultHorse() && lllllllllllllllIlllIIlllIIlIlllI > 0) {
                    this.addGrowth(lllllllllllllllIlllIIlllIIlIlllI);
                    lllllllllllllllIlllIIlllIIllIIIl = true;
                }
                if (lllllllllllllllIlllIIlllIIlIllIl > 0 && (lllllllllllllllIlllIIlllIIllIIIl || !this.isTame()) && lllllllllllllllIlllIIlllIIlIllIl < this.getMaxTemper()) {
                    lllllllllllllllIlllIIlllIIllIIIl = true;
                    this.increaseTemper(lllllllllllllllIlllIIlllIIlIllIl);
                }
                if (lllllllllllllllIlllIIlllIIllIIIl) {
                    this.func_110266_cB();
                }
            }
            if (!this.isTame() && !lllllllllllllllIlllIIlllIIllIIIl) {
                if (lllllllllllllllIlllIIlllIIllIIlI != null && lllllllllllllllIlllIIlllIIllIIlI.interactWithEntity(lllllllllllllllIlllIIlllIIllIIll, this)) {
                    return true;
                }
                this.makeHorseRearWithSound();
                return true;
            }
            else {
                if (!lllllllllllllllIlllIIlllIIllIIIl && this.canCarryChest() && !this.isChested() && lllllllllllllllIlllIIlllIIllIIlI.getItem() == Item.getItemFromBlock(Blocks.chest)) {
                    this.setChested(true);
                    this.playSound("mob.chickenplop", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
                    lllllllllllllllIlllIIlllIIllIIIl = true;
                    this.func_110226_cD();
                }
                if (!lllllllllllllllIlllIIlllIIllIIIl && this.func_110253_bW() && !this.isHorseSaddled() && lllllllllllllllIlllIIlllIIllIIlI.getItem() == Items.saddle) {
                    this.openGUI(lllllllllllllllIlllIIlllIIllIIll);
                    return true;
                }
                if (lllllllllllllllIlllIIlllIIllIIIl) {
                    if (!lllllllllllllllIlllIIlllIIllIIll.capabilities.isCreativeMode) {
                        final ItemStack itemStack = lllllllllllllllIlllIIlllIIllIIlI;
                        if (--itemStack.stackSize == 0) {
                            lllllllllllllllIlllIIlllIIllIIll.inventory.setInventorySlotContents(lllllllllllllllIlllIIlllIIllIIll.inventory.currentItem, null);
                        }
                    }
                    return true;
                }
            }
        }
        if (!this.func_110253_bW() || this.riddenByEntity != null) {
            return super.interact(lllllllllllllllIlllIIlllIIllIIll);
        }
        if (lllllllllllllllIlllIIlllIIllIIlI != null && lllllllllllllllIlllIIlllIIllIIlI.interactWithEntity(lllllllllllllllIlllIIlllIIllIIll, this)) {
            return true;
        }
        this.func_110237_h(lllllllllllllllIlllIIlllIIllIIll);
        return true;
    }
    
    public int func_110241_cb() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }
    
    public String[] getVariantTexturePaths() {
        if (this.field_110286_bQ == null) {
            this.setHorseTexturePaths();
        }
        return this.field_110280_bR;
    }
    
    @Override
    public String getName() {
        if (this.hasCustomName()) {
            return this.getCustomNameTag();
        }
        final int lllllllllllllllIlllIlIIIlIlIIlII = this.getHorseType();
        switch (lllllllllllllllIlllIlIIIlIlIIlII) {
            default: {
                return StatCollector.translateToLocal("entity.horse.name");
            }
            case 1: {
                return StatCollector.translateToLocal("entity.donkey.name");
            }
            case 2: {
                return StatCollector.translateToLocal("entity.mule.name");
            }
            case 3: {
                return StatCollector.translateToLocal("entity.zombiehorse.name");
            }
            case 4: {
                return StatCollector.translateToLocal("entity.skeletonhorse.name");
            }
        }
    }
    
    private void func_110230_cF() {
        this.field_110286_bQ = null;
    }
    
    public boolean isUndead() {
        final int lllllllllllllllIlllIIlllIIIlIIII = this.getHorseType();
        return lllllllllllllllIlllIIlllIIIlIIII == 3 || lllllllllllllllIlllIIlllIIIlIIII == 4;
    }
    
    public void setHorseVariant(final int lllllllllllllllIlllIlIIIlIlIlIll) {
        this.dataWatcher.updateObject(20, lllllllllllllllIlllIlIIIlIlIlIll);
        this.func_110230_cF();
    }
    
    public void setEatingHaystack(final boolean lllllllllllllllIlllIIllIlllIIlIl) {
        this.setEating(lllllllllllllllIlllIIllIlllIIlIl);
    }
    
    @Override
    protected String getLivingSound() {
        this.openHorseMouth();
        if (this.rand.nextInt(10) == 0 && !this.isMovementBlocked()) {
            this.makeHorseRear();
        }
        final int lllllllllllllllIlllIIlllIlllllll = this.getHorseType();
        return (lllllllllllllllIlllIIlllIlllllll == 3) ? "mob.horse.zombie.idle" : ((lllllllllllllllIlllIIlllIlllllll == 4) ? "mob.horse.skeleton.idle" : ((lllllllllllllllIlllIIlllIlllllll != 1 && lllllllllllllllIlllIIlllIlllllll != 2) ? "mob.horse.idle" : "mob.horse.donkey.idle"));
    }
    
    @Override
    public void setScaleForAge(final boolean lllllllllllllllIlllIlIIIIlllIIlI) {
        if (lllllllllllllllIlllIlIIIIlllIIlI) {
            this.setScale(this.getHorseSize());
        }
        else {
            this.setScale(1.0f);
        }
    }
    
    public int getHorseVariant() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIlllIIllIlIIlllII) {
        super.writeEntityToNBT(lllllllllllllllIlllIIllIlIIlllII);
        lllllllllllllllIlllIIllIlIIlllII.setBoolean("EatingHaystack", this.isEatingHaystack());
        lllllllllllllllIlllIIllIlIIlllII.setBoolean("ChestedHorse", this.isChested());
        lllllllllllllllIlllIIllIlIIlllII.setBoolean("HasReproduced", this.getHasReproduced());
        lllllllllllllllIlllIIllIlIIlllII.setBoolean("Bred", this.func_110205_ce());
        lllllllllllllllIlllIIllIlIIlllII.setInteger("Type", this.getHorseType());
        lllllllllllllllIlllIIllIlIIlllII.setInteger("Variant", this.getHorseVariant());
        lllllllllllllllIlllIIllIlIIlllII.setInteger("Temper", this.getTemper());
        lllllllllllllllIlllIIllIlIIlllII.setBoolean("Tame", this.isTame());
        lllllllllllllllIlllIIllIlIIlllII.setString("OwnerUUID", this.func_152119_ch());
        if (this.isChested()) {
            final NBTTagList lllllllllllllllIlllIIllIlIlIIIIl = new NBTTagList();
            for (int lllllllllllllllIlllIIllIlIlIIIII = 2; lllllllllllllllIlllIIllIlIlIIIII < this.horseChest.getSizeInventory(); ++lllllllllllllllIlllIIllIlIlIIIII) {
                final ItemStack lllllllllllllllIlllIIllIlIIlllll = this.horseChest.getStackInSlot(lllllllllllllllIlllIIllIlIlIIIII);
                if (lllllllllllllllIlllIIllIlIIlllll != null) {
                    final NBTTagCompound lllllllllllllllIlllIIllIlIIllllI = new NBTTagCompound();
                    lllllllllllllllIlllIIllIlIIllllI.setByte("Slot", (byte)lllllllllllllllIlllIIllIlIlIIIII);
                    lllllllllllllllIlllIIllIlIIlllll.writeToNBT(lllllllllllllllIlllIIllIlIIllllI);
                    lllllllllllllllIlllIIllIlIlIIIIl.appendTag(lllllllllllllllIlllIIllIlIIllllI);
                }
            }
            lllllllllllllllIlllIIllIlIIlllII.setTag("Items", lllllllllllllllIlllIIllIlIlIIIIl);
        }
        if (this.horseChest.getStackInSlot(1) != null) {
            lllllllllllllllIlllIIllIlIIlllII.setTag("ArmorItem", this.horseChest.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
        }
        if (this.horseChest.getStackInSlot(0) != null) {
            lllllllllllllllIlllIIllIlIIlllII.setTag("SaddleItem", this.horseChest.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
        }
    }
    
    public void func_110242_l(final boolean lllllllllllllllIlllIlIIIIIllIlll) {
        this.setHorseWatchableBoolean(16, lllllllllllllllIlllIlIIIIIllIlll);
    }
    
    private void func_110266_cB() {
        this.openHorseMouth();
        if (!this.isSlient()) {
            this.worldObj.playSoundAtEntity(this, "eating", 1.0f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f);
        }
    }
    
    public void setHorseArmorStack(final ItemStack lllllllllllllllIlllIlIIIIIllllIl) {
        this.dataWatcher.updateObject(22, this.getHorseArmorIndex(lllllllllllllllIlllIlIIIIIllllIl));
        this.func_110230_cF();
    }
    
    @Override
    protected String getHurtSound() {
        this.openHorseMouth();
        if (this.rand.nextInt(3) == 0) {
            this.makeHorseRear();
        }
        final int lllllllllllllllIlllIIllllIIIlIII = this.getHorseType();
        return (lllllllllllllllIlllIIllllIIIlIII == 3) ? "mob.horse.zombie.hit" : ((lllllllllllllllIlllIIllllIIIlIII == 4) ? "mob.horse.skeleton.hit" : ((lllllllllllllllIlllIIllllIIIlIII != 1 && lllllllllllllllIlllIIllllIIIlIII != 2) ? "mob.horse.hit" : "mob.horse.donkey.hit"));
    }
    
    public boolean func_110253_bW() {
        return this.isAdultHorse();
    }
    
    @Override
    protected String getDeathSound() {
        this.openHorseMouth();
        final int lllllllllllllllIlllIIllllIIlIlll = this.getHorseType();
        return (lllllllllllllllIlllIIllllIIlIlll == 3) ? "mob.horse.zombie.death" : ((lllllllllllllllIlllIIllllIIlIlll == 4) ? "mob.horse.skeleton.death" : ((lllllllllllllllIlllIIllllIIlIlll != 1 && lllllllllllllllIlllIIllllIIlIlll != 2) ? "mob.horse.death" : "mob.horse.donkey.death"));
    }
    
    public boolean func_110205_ce() {
        return this.getHorseWatchableBoolean(16);
    }
    
    public static boolean func_146085_a(final Item lllllllllllllllIlllIIlIlllIlllll) {
        return lllllllllllllllIlllIIlIlllIlllll == Items.iron_horse_armor || lllllllllllllllIlllIIlIlllIlllll == Items.golden_horse_armor || lllllllllllllllIlllIIlIlllIlllll == Items.diamond_horse_armor;
    }
    
    public boolean isSterile() {
        return this.isUndead() || this.getHorseType() == 2;
    }
    
    public String func_152119_ch() {
        return this.dataWatcher.getWatchableObjectString(21);
    }
    
    public boolean getHasReproduced() {
        return this.hasReproduced;
    }
    
    @Override
    public void fall(final float lllllllllllllllIlllIIllllllIlIII, final float lllllllllllllllIlllIIllllllIIlll) {
        if (lllllllllllllllIlllIIllllllIlIII > 1.0f) {
            this.playSound("mob.horse.land", 0.4f, 1.0f);
        }
        final int lllllllllllllllIlllIIllllllIIllI = MathHelper.ceiling_float_int((lllllllllllllllIlllIIllllllIlIII * 0.5f - 3.0f) * lllllllllllllllIlllIIllllllIIlll);
        if (lllllllllllllllIlllIIllllllIIllI > 0) {
            this.attackEntityFrom(DamageSource.fall, (float)lllllllllllllllIlllIIllllllIIllI);
            if (this.riddenByEntity != null) {
                this.riddenByEntity.attackEntityFrom(DamageSource.fall, (float)lllllllllllllllIlllIIllllllIIllI);
            }
            final Block lllllllllllllllIlllIIllllllIIlIl = this.worldObj.getBlockState(new BlockPos(this.posX, this.posY - 0.2 - this.prevRotationYaw, this.posZ)).getBlock();
            if (lllllllllllllllIlllIIllllllIIlIl.getMaterial() != Material.air && !this.isSlient()) {
                final Block.SoundType lllllllllllllllIlllIIllllllIIlII = lllllllllllllllIlllIIllllllIIlIl.stepSound;
                this.worldObj.playSoundAtEntity(this, lllllllllllllllIlllIIllllllIIlII.getStepSound(), lllllllllllllllIlllIIllllllIIlII.getVolume() * 0.5f, lllllllllllllllIlllIIllllllIIlII.getFrequency() * 0.75f);
            }
        }
    }
    
    @Override
    public boolean func_174820_d(final int lllllllllllllllIlllIIlIlllIIlllI, final ItemStack lllllllllllllllIlllIIlIlllIlIIlI) {
        if (lllllllllllllllIlllIIlIlllIIlllI == 499 && this.canCarryChest()) {
            if (lllllllllllllllIlllIIlIlllIlIIlI == null && this.isChested()) {
                this.setChested(false);
                this.func_110226_cD();
                return true;
            }
            if (lllllllllllllllIlllIIlIlllIlIIlI != null && lllllllllllllllIlllIIlIlllIlIIlI.getItem() == Item.getItemFromBlock(Blocks.chest) && !this.isChested()) {
                this.setChested(true);
                this.func_110226_cD();
                return true;
            }
        }
        final int lllllllllllllllIlllIIlIlllIlIIIl = lllllllllllllllIlllIIlIlllIIlllI - 400;
        if (lllllllllllllllIlllIIlIlllIlIIIl >= 0 && lllllllllllllllIlllIIlIlllIlIIIl < 2 && lllllllllllllllIlllIIlIlllIlIIIl < this.horseChest.getSizeInventory()) {
            if (lllllllllllllllIlllIIlIlllIlIIIl == 0 && lllllllllllllllIlllIIlIlllIlIIlI != null && lllllllllllllllIlllIIlIlllIlIIlI.getItem() != Items.saddle) {
                return false;
            }
            if (lllllllllllllllIlllIIlIlllIlIIIl == 1 && ((lllllllllllllllIlllIIlIlllIlIIlI != null && !func_146085_a(lllllllllllllllIlllIIlIlllIlIIlI.getItem())) || !this.canWearArmor())) {
                return false;
            }
            this.horseChest.setInventorySlotContents(lllllllllllllllIlllIIlIlllIlIIIl, lllllllllllllllIlllIIlIlllIlIIlI);
            this.func_110232_cE();
            return true;
        }
        else {
            final int lllllllllllllllIlllIIlIlllIlIIII = lllllllllllllllIlllIIlIlllIIlllI - 500 + 2;
            if (lllllllllllllllIlllIIlIlllIlIIII >= 2 && lllllllllllllllIlllIIlIlllIlIIII < this.horseChest.getSizeInventory()) {
                this.horseChest.setInventorySlotContents(lllllllllllllllIlllIIlIlllIlIIII, lllllllllllllllIlllIIlIlllIlIIlI);
                return true;
            }
            return false;
        }
    }
    
    public void setHorseType(final int lllllllllllllllIlllIlIIIlIllIlII) {
        this.dataWatcher.updateObject(19, (byte)lllllllllllllllIlllIlIIIlIllIlII);
        this.func_110230_cF();
    }
    
    @Override
    public void setEating(final boolean lllllllllllllllIlllIIllIlllIlIll) {
        this.setHorseWatchableBoolean(32, lllllllllllllllIlllIIllIlllIlIll);
    }
    
    public void dropChests() {
        if (!this.worldObj.isRemote && this.isChested()) {
            this.dropItem(Item.getItemFromBlock(Blocks.chest), 1);
            this.setChested(false);
        }
    }
    
    @Override
    public void handleHealthUpdate(final byte lllllllllllllllIlllIIlIllllllIll) {
        if (lllllllllllllllIlllIIlIllllllIll == 7) {
            this.spawnHorseParticles(true);
        }
        else if (lllllllllllllllIlllIIlIllllllIll == 6) {
            this.spawnHorseParticles(false);
        }
        else {
            super.handleHealthUpdate(lllllllllllllllIlllIIlIllllllIll);
        }
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.rand.nextInt(200) == 0) {
            this.func_110210_cH();
        }
        super.onLivingUpdate();
        if (!this.worldObj.isRemote) {
            if (this.rand.nextInt(900) == 0 && this.deathTime == 0) {
                this.heal(1.0f);
            }
            if (!this.isEatingHaystack() && this.riddenByEntity == null && this.rand.nextInt(300) == 0 && this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) - 1, MathHelper.floor_double(this.posZ))).getBlock() == Blocks.grass) {
                this.setEatingHaystack(true);
            }
            if (this.isEatingHaystack() && ++this.eatingHaystackCounter > 50) {
                this.eatingHaystackCounter = 0;
                this.setEatingHaystack(false);
            }
            if (this.func_110205_ce() && !this.isAdultHorse() && !this.isEatingHaystack()) {
                final EntityHorse lllllllllllllllIlllIIllIllllllII = this.getClosestHorse(this, 16.0);
                if (lllllllllllllllIlllIIllIllllllII != null && this.getDistanceSqToEntity(lllllllllllllllIlllIIllIllllllII) > 4.0) {
                    this.navigator.getPathToEntityLiving(lllllllllllllllIlllIIllIllllllII);
                }
            }
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIlllIlIIIIIIIIlll, final float lllllllllllllllIlllIlIIIIIIIIllI) {
        final Entity lllllllllllllllIlllIlIIIIIIIlIIl = lllllllllllllllIlllIlIIIIIIIIlll.getEntity();
        return (this.riddenByEntity == null || !this.riddenByEntity.equals(lllllllllllllllIlllIlIIIIIIIlIIl)) && super.attackEntityFrom(lllllllllllllllIlllIlIIIIIIIIlll, lllllllllllllllIlllIlIIIIIIIIllI);
    }
    
    private void func_110226_cD() {
        final AnimalChest lllllllllllllllIlllIIlllllIlIIIl = this.horseChest;
        this.horseChest = new AnimalChest("HorseChest", this.func_110225_cC());
        this.horseChest.func_110133_a(this.getName());
        if (lllllllllllllllIlllIIlllllIlIIIl != null) {
            lllllllllllllllIlllIIlllllIlIIIl.func_110132_b(this);
            for (int lllllllllllllllIlllIIlllllIlIIII = Math.min(lllllllllllllllIlllIIlllllIlIIIl.getSizeInventory(), this.horseChest.getSizeInventory()), lllllllllllllllIlllIIlllllIIllll = 0; lllllllllllllllIlllIIlllllIIllll < lllllllllllllllIlllIIlllllIlIIII; ++lllllllllllllllIlllIIlllllIIllll) {
                final ItemStack lllllllllllllllIlllIIlllllIIlllI = lllllllllllllllIlllIIlllllIlIIIl.getStackInSlot(lllllllllllllllIlllIIlllllIIllll);
                if (lllllllllllllllIlllIIlllllIIlllI != null) {
                    this.horseChest.setInventorySlotContents(lllllllllllllllIlllIIlllllIIllll, lllllllllllllllIlllIIlllllIIlllI.copy());
                }
            }
        }
        this.horseChest.func_110134_a(this);
        this.func_110232_cE();
    }
    
    public boolean func_110239_cn() {
        return this.getHorseType() == 0 || this.func_110241_cb() > 0;
    }
    
    @Override
    public void updateRiderPosition() {
        super.updateRiderPosition();
        if (this.prevRearingAmount > 0.0f) {
            final float lllllllllllllllIlllIIlIlllllIIlI = MathHelper.sin(this.renderYawOffset * 3.1415927f / 180.0f);
            final float lllllllllllllllIlllIIlIlllllIIIl = MathHelper.cos(this.renderYawOffset * 3.1415927f / 180.0f);
            final float lllllllllllllllIlllIIlIlllllIIII = 0.7f * this.prevRearingAmount;
            final float lllllllllllllllIlllIIlIllllIllll = 0.15f * this.prevRearingAmount;
            this.riddenByEntity.setPosition(this.posX + lllllllllllllllIlllIIlIlllllIIII * lllllllllllllllIlllIIlIlllllIIlI, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + lllllllllllllllIlllIIlIllllIllll, this.posZ - lllllllllllllllIlllIIlIlllllIIII * lllllllllllllllIlllIIlIlllllIIIl);
            if (this.riddenByEntity instanceof EntityLivingBase) {
                ((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset;
            }
        }
    }
    
    private void func_110210_cH() {
        this.field_110278_bp = 1;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(EntityHorse.horseJumpStrength);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(53.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22499999403953552);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIlllIIllIlIIIIIll) {
        super.readEntityFromNBT(lllllllllllllllIlllIIllIlIIIIIll);
        this.setEatingHaystack(lllllllllllllllIlllIIllIlIIIIIll.getBoolean("EatingHaystack"));
        this.func_110242_l(lllllllllllllllIlllIIllIlIIIIIll.getBoolean("Bred"));
        this.setChested(lllllllllllllllIlllIIllIlIIIIIll.getBoolean("ChestedHorse"));
        this.setHasReproduced(lllllllllllllllIlllIIllIlIIIIIll.getBoolean("HasReproduced"));
        this.setHorseType(lllllllllllllllIlllIIllIlIIIIIll.getInteger("Type"));
        this.setHorseVariant(lllllllllllllllIlllIIllIlIIIIIll.getInteger("Variant"));
        this.setTemper(lllllllllllllllIlllIIllIlIIIIIll.getInteger("Temper"));
        this.setHorseTamed(lllllllllllllllIlllIIllIlIIIIIll.getBoolean("Tame"));
        String lllllllllllllllIlllIIllIlIIIllIl = "";
        if (lllllllllllllllIlllIIllIlIIIIIll.hasKey("OwnerUUID", 8)) {
            lllllllllllllllIlllIIllIlIIIllIl = lllllllllllllllIlllIIllIlIIIIIll.getString("OwnerUUID");
        }
        else {
            final String lllllllllllllllIlllIIllIlIIIllII = lllllllllllllllIlllIIllIlIIIIIll.getString("Owner");
            lllllllllllllllIlllIIllIlIIIllIl = PreYggdrasilConverter.func_152719_a(lllllllllllllllIlllIIllIlIIIllII);
        }
        if (lllllllllllllllIlllIIllIlIIIllIl.length() > 0) {
            this.func_152120_b(lllllllllllllllIlllIIllIlIIIllIl);
        }
        final IAttributeInstance lllllllllllllllIlllIIllIlIIIlIll = this.getAttributeMap().getAttributeInstanceByName("Speed");
        if (lllllllllllllllIlllIIllIlIIIlIll != null) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(lllllllllllllllIlllIIllIlIIIlIll.getBaseValue() * 0.25);
        }
        if (this.isChested()) {
            final NBTTagList lllllllllllllllIlllIIllIlIIIlIlI = lllllllllllllllIlllIIllIlIIIIIll.getTagList("Items", 10);
            this.func_110226_cD();
            for (int lllllllllllllllIlllIIllIlIIIlIIl = 0; lllllllllllllllIlllIIllIlIIIlIIl < lllllllllllllllIlllIIllIlIIIlIlI.tagCount(); ++lllllllllllllllIlllIIllIlIIIlIIl) {
                final NBTTagCompound lllllllllllllllIlllIIllIlIIIlIII = lllllllllllllllIlllIIllIlIIIlIlI.getCompoundTagAt(lllllllllllllllIlllIIllIlIIIlIIl);
                final int lllllllllllllllIlllIIllIlIIIIlll = lllllllllllllllIlllIIllIlIIIlIII.getByte("Slot") & 0xFF;
                if (lllllllllllllllIlllIIllIlIIIIlll >= 2 && lllllllllllllllIlllIIllIlIIIIlll < this.horseChest.getSizeInventory()) {
                    this.horseChest.setInventorySlotContents(lllllllllllllllIlllIIllIlIIIIlll, ItemStack.loadItemStackFromNBT(lllllllllllllllIlllIIllIlIIIlIII));
                }
            }
        }
        if (lllllllllllllllIlllIIllIlIIIIIll.hasKey("ArmorItem", 10)) {
            final ItemStack lllllllllllllllIlllIIllIlIIIIllI = ItemStack.loadItemStackFromNBT(lllllllllllllllIlllIIllIlIIIIIll.getCompoundTag("ArmorItem"));
            if (lllllllllllllllIlllIIllIlIIIIllI != null && func_146085_a(lllllllllllllllIlllIIllIlIIIIllI.getItem())) {
                this.horseChest.setInventorySlotContents(1, lllllllllllllllIlllIIllIlIIIIllI);
            }
        }
        if (lllllllllllllllIlllIIllIlIIIIIll.hasKey("SaddleItem", 10)) {
            final ItemStack lllllllllllllllIlllIIllIlIIIIlIl = ItemStack.loadItemStackFromNBT(lllllllllllllllIlllIIllIlIIIIIll.getCompoundTag("SaddleItem"));
            if (lllllllllllllllIlllIIllIlIIIIlIl != null && lllllllllllllllIlllIIllIlIIIIlIl.getItem() == Items.saddle) {
                this.horseChest.setInventorySlotContents(0, lllllllllllllllIlllIIllIlIIIIlIl);
            }
        }
        else if (lllllllllllllllIlllIIllIlIIIIIll.getBoolean("Saddle")) {
            this.horseChest.setInventorySlotContents(0, new ItemStack(Items.saddle));
        }
        this.func_110232_cE();
    }
    
    @Override
    public boolean allowLeashing() {
        return !this.isUndead() && super.allowLeashing();
    }
    
    public float func_110201_q(final float lllllllllllllllIlllIIllIIIIlllII) {
        return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * lllllllllllllllIlllIIllIIIIlllII;
    }
    
    public boolean canCarryChest() {
        final int lllllllllllllllIlllIIlllIIIllIIl = this.getHorseType();
        return lllllllllllllllIlllIIlllIIIllIIl == 2 || lllllllllllllllIlllIIlllIIIllIIl == 1;
    }
    
    @Override
    public void moveEntityWithHeading(float lllllllllllllllIlllIIllIlIlIllll, float lllllllllllllllIlllIIllIlIlIlllI) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase && this.isHorseSaddled()) {
            final float rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationYaw = rotationYaw;
            this.prevRotationYaw = rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5f;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            final float rotationYaw2 = this.rotationYaw;
            this.renderYawOffset = rotationYaw2;
            this.rotationYawHead = rotationYaw2;
            lllllllllllllllIlllIIllIlIlIllll = (String)(((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5f);
            lllllllllllllllIlllIIllIlIlIlllI = ((EntityLivingBase)this.riddenByEntity).moveForward;
            if (lllllllllllllllIlllIIllIlIlIlllI <= 0.0f) {
                lllllllllllllllIlllIIllIlIlIlllI *= 0.25f;
                this.gallopTime = 0;
            }
            if (this.onGround && this.jumpPower == 0.0f && this.isRearing() && !this.field_110294_bI) {
                lllllllllllllllIlllIIllIlIlIllll = (String)0.0f;
                lllllllllllllllIlllIIllIlIlIlllI = 0.0f;
            }
            if (this.jumpPower > 0.0f && !this.isHorseJumping() && this.onGround) {
                this.motionY = this.getHorseJumpStrength() * this.jumpPower;
                if (this.isPotionActive(Potion.jump)) {
                    this.motionY += (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1f;
                }
                this.setHorseJumping(true);
                this.isAirBorne = true;
                if (lllllllllllllllIlllIIllIlIlIlllI > 0.0f) {
                    final float lllllllllllllllIlllIIllIlIllIlIl = MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f);
                    final float lllllllllllllllIlllIIllIlIllIlII = MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f);
                    this.motionX += -0.4f * lllllllllllllllIlllIIllIlIllIlIl * this.jumpPower;
                    this.motionZ += 0.4f * lllllllllllllllIlllIIllIlIllIlII * this.jumpPower;
                    this.playSound("mob.horse.jump", 0.4f, 1.0f);
                }
                this.jumpPower = 0.0f;
            }
            this.stepHeight = 1.0f;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1f;
            if (!this.worldObj.isRemote) {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                super.moveEntityWithHeading((float)lllllllllllllllIlllIIllIlIlIllll, lllllllllllllllIlllIIllIlIlIlllI);
            }
            if (this.onGround) {
                this.jumpPower = 0.0f;
                this.setHorseJumping(false);
            }
            this.prevLimbSwingAmount = this.limbSwingAmount;
            final double lllllllllllllllIlllIIllIlIllIIll = this.posX - this.prevPosX;
            final double lllllllllllllllIlllIIllIlIllIIlI = this.posZ - this.prevPosZ;
            float lllllllllllllllIlllIIllIlIllIIIl = MathHelper.sqrt_double(lllllllllllllllIlllIIllIlIllIIll * lllllllllllllllIlllIIllIlIllIIll + lllllllllllllllIlllIIllIlIllIIlI * lllllllllllllllIlllIIllIlIllIIlI) * 4.0f;
            if (lllllllllllllllIlllIIllIlIllIIIl > 1.0f) {
                lllllllllllllllIlllIIllIlIllIIIl = 1.0f;
            }
            this.limbSwingAmount += (lllllllllllllllIlllIIllIlIllIIIl - this.limbSwingAmount) * 0.4f;
            this.limbSwing += this.limbSwingAmount;
        }
        else {
            this.stepHeight = 0.5f;
            this.jumpMovementFactor = 0.02f;
            super.moveEntityWithHeading((float)lllllllllllllllIlllIIllIlIlIllll, lllllllllllllllIlllIIllIlIlIlllI);
        }
    }
    
    public void setTemper(final int lllllllllllllllIlllIlIIIIIIllIlI) {
        this.temper = lllllllllllllllIlllIlIIIIIIllIlI;
    }
    
    public int getHorseType() {
        return this.dataWatcher.getWatchableObjectByte(19);
    }
    
    public double getHorseJumpStrength() {
        return this.getEntityAttribute(EntityHorse.horseJumpStrength).getAttributeValue();
    }
    
    @Override
    public boolean getCanSpawnHere() {
        this.prepareChunkForSpawn();
        return super.getCanSpawnHere();
    }
    
    @Override
    public boolean canBePushed() {
        return this.riddenByEntity == null;
    }
    
    private void setHorseWatchableBoolean(final int lllllllllllllllIlllIlIIIlIIlIllI, final boolean lllllllllllllllIlllIlIIIlIIlIIIl) {
        final int lllllllllllllllIlllIlIIIlIIlIlII = this.dataWatcher.getWatchableObjectInt(16);
        if (lllllllllllllllIlllIlIIIlIIlIIIl) {
            this.dataWatcher.updateObject(16, lllllllllllllllIlllIlIIIlIIlIlII | lllllllllllllllIlllIlIIIlIIlIllI);
        }
        else {
            this.dataWatcher.updateObject(16, lllllllllllllllIlllIlIIIlIIlIlII & ~lllllllllllllllIlllIlIIIlIIlIllI);
        }
    }
    
    public float getRearingAmount(final float lllllllllllllllIlllIIllIIIlIIIlI) {
        return this.prevRearingAmount + (this.rearingAmount - this.prevRearingAmount) * lllllllllllllllIlllIIllIIIlIIIlI;
    }
    
    @Override
    public float getEyeHeight() {
        return this.height;
    }
    
    public boolean isAdultHorse() {
        return !this.isChild();
    }
    
    private void makeHorseRear() {
        if (!this.worldObj.isRemote) {
            this.jumpRearingCounter = 1;
            this.setRearing(true);
        }
    }
    
    public EntityHorse(final World lllllllllllllllIlllIlIIIlIllllIl) {
        super(lllllllllllllllIlllIlIIIlIllllIl);
        this.field_110280_bR = new String[3];
        this.field_175508_bO = false;
        this.setSize(1.4f, 1.6f);
        this.isImmuneToFire = false;
        this.setChested(false);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.2));
        this.tasks.addTask(1, new EntityAIRunAroundLikeCrazy(this, 1.2));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.0));
        this.tasks.addTask(6, new EntityAIWander(this, 0.7));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.func_110226_cD();
    }
    
    private double func_110203_cN() {
        return (0.44999998807907104 + this.rand.nextDouble() * 0.3 + this.rand.nextDouble() * 0.3 + this.rand.nextDouble() * 0.3) * 0.25;
    }
    
    public boolean isTame() {
        return this.getHorseWatchableBoolean(2);
    }
    
    public void func_152120_b(final String lllllllllllllllIlllIlIIIlIIIIIII) {
        this.dataWatcher.updateObject(21, lllllllllllllllIlllIlIIIlIIIIIII);
    }
    
    public void openGUI(final EntityPlayer lllllllllllllllIlllIIlllIIllllII) {
        if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == lllllllllllllllIlllIIlllIIllllII) && this.isTame()) {
            this.horseChest.func_110133_a(this.getName());
            lllllllllllllllIlllIIlllIIllllII.displayGUIHorse(this, this.horseChest);
        }
    }
    
    @Override
    public void onInventoryChanged(final InventoryBasic lllllllllllllllIlllIIlllllIIIIIl) {
        final int lllllllllllllllIlllIIlllllIIIIII = this.func_110241_cb();
        final boolean lllllllllllllllIlllIIllllIllllll = this.isHorseSaddled();
        this.func_110232_cE();
        if (this.ticksExisted > 20) {
            if (lllllllllllllllIlllIIlllllIIIIII == 0 && lllllllllllllllIlllIIlllllIIIIII != this.func_110241_cb()) {
                this.playSound("mob.horse.armor", 0.5f, 1.0f);
            }
            else if (lllllllllllllllIlllIIlllllIIIIII != this.func_110241_cb()) {
                this.playSound("mob.horse.armor", 0.5f, 1.0f);
            }
            if (!lllllllllllllllIlllIIllllIllllll && this.isHorseSaddled()) {
                this.playSound("mob.horse.leather", 0.5f, 1.0f);
            }
        }
    }
    
    @Override
    protected void func_180429_a(final BlockPos lllllllllllllllIlllIIlllIlllIIII, final Block lllllllllllllllIlllIIlllIllIlIlI) {
        Block.SoundType lllllllllllllllIlllIIlllIllIlllI = lllllllllllllllIlllIIlllIllIlIlI.stepSound;
        if (this.worldObj.getBlockState(lllllllllllllllIlllIIlllIlllIIII.offsetUp()).getBlock() == Blocks.snow_layer) {
            lllllllllllllllIlllIIlllIllIlllI = Blocks.snow_layer.stepSound;
        }
        if (!lllllllllllllllIlllIIlllIllIlIlI.getMaterial().isLiquid()) {
            final int lllllllllllllllIlllIIlllIllIllIl = this.getHorseType();
            if (this.riddenByEntity != null && lllllllllllllllIlllIIlllIllIllIl != 1 && lllllllllllllllIlllIIlllIllIllIl != 2) {
                ++this.gallopTime;
                if (this.gallopTime > 5 && this.gallopTime % 3 == 0) {
                    this.playSound("mob.horse.gallop", lllllllllllllllIlllIIlllIllIlllI.getVolume() * 0.15f, lllllllllllllllIlllIIlllIllIlllI.getFrequency());
                    if (lllllllllllllllIlllIIlllIllIllIl == 0 && this.rand.nextInt(10) == 0) {
                        this.playSound("mob.horse.breathe", lllllllllllllllIlllIIlllIllIlllI.getVolume() * 0.6f, lllllllllllllllIlllIIlllIllIlllI.getFrequency());
                    }
                }
                else if (this.gallopTime <= 5) {
                    this.playSound("mob.horse.wood", lllllllllllllllIlllIIlllIllIlllI.getVolume() * 0.15f, lllllllllllllllIlllIIlllIllIlllI.getFrequency());
                }
            }
            else if (lllllllllllllllIlllIIlllIllIlllI == Block.soundTypeWood) {
                this.playSound("mob.horse.wood", lllllllllllllllIlllIIlllIllIlllI.getVolume() * 0.15f, lllllllllllllllIlllIIlllIllIlllI.getFrequency());
            }
            else {
                this.playSound("mob.horse.soft", lllllllllllllllIlllIIlllIllIlllI.getVolume() * 0.15f, lllllllllllllllIlllIIlllIllIlllI.getFrequency());
            }
        }
    }
    
    @Override
    protected boolean isMovementBlocked() {
        return (this.riddenByEntity != null && this.isHorseSaddled()) || this.isEatingHaystack() || this.isRearing();
    }
    
    private int func_110225_cC() {
        final int lllllllllllllllIlllIIlllllIllIlI = this.getHorseType();
        return (this.isChested() && (lllllllllllllllIlllIIlllllIllIlI == 1 || lllllllllllllllIlllIIlllllIllIlI == 2)) ? 17 : 2;
    }
    
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance lllllllllllllllIlllIIllIIIllIIll, final IEntityLivingData lllllllllllllllIlllIIllIIIllllIl) {
        Object lllllllllllllllIlllIIllIIIllllII = super.func_180482_a(lllllllllllllllIlllIIllIIIllIIll, lllllllllllllllIlllIIllIIIllllIl);
        final boolean lllllllllllllllIlllIIllIIIlllIll = false;
        int lllllllllllllllIlllIIllIIIlllIlI = 0;
        int lllllllllllllllIlllIIllIIIllIlll = 0;
        if (lllllllllllllllIlllIIllIIIllllII instanceof GroupData) {
            final int lllllllllllllllIlllIIllIIIlllIIl = ((GroupData)lllllllllllllllIlllIIllIIIllllII).field_111107_a;
            lllllllllllllllIlllIIllIIIlllIlI = ((((GroupData)lllllllllllllllIlllIIllIIIllllII).field_111106_b & 0xFF) | this.rand.nextInt(5) << 8);
        }
        else {
            if (this.rand.nextInt(10) == 0) {
                final int lllllllllllllllIlllIIllIIIlllIII = 1;
            }
            else {
                final int lllllllllllllllIlllIIllIIIllIllI = this.rand.nextInt(7);
                final int lllllllllllllllIlllIIllIIIllIlIl = this.rand.nextInt(5);
                lllllllllllllllIlllIIllIIIllIlll = 0;
                lllllllllllllllIlllIIllIIIlllIlI = (lllllllllllllllIlllIIllIIIllIllI | lllllllllllllllIlllIIllIIIllIlIl << 8);
            }
            lllllllllllllllIlllIIllIIIllllII = new GroupData(lllllllllllllllIlllIIllIIIllIlll, lllllllllllllllIlllIIllIIIlllIlI);
        }
        this.setHorseType(lllllllllllllllIlllIIllIIIllIlll);
        this.setHorseVariant(lllllllllllllllIlllIIllIIIlllIlI);
        if (this.rand.nextInt(5) == 0) {
            this.setGrowingAge(-24000);
        }
        if (lllllllllllllllIlllIIllIIIllIlll != 4 && lllllllllllllllIlllIIllIIIllIlll != 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.func_110267_cL());
            if (lllllllllllllllIlllIIllIIIllIlll == 0) {
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.func_110203_cN());
            }
            else {
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.17499999701976776);
            }
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224);
        }
        if (lllllllllllllllIlllIIllIIIllIlll != 2 && lllllllllllllllIlllIIllIIIllIlll != 1) {
            this.getEntityAttribute(EntityHorse.horseJumpStrength).setBaseValue(this.func_110245_cM());
        }
        else {
            this.getEntityAttribute(EntityHorse.horseJumpStrength).setBaseValue(0.5);
        }
        this.setHealth(this.getMaxHealth());
        return (IEntityLivingData)lllllllllllllllIlllIIllIIIllllII;
    }
    
    public void setHasReproduced(final boolean lllllllllllllllIlllIlIIIIIlIlIll) {
        this.hasReproduced = lllllllllllllllIlllIlIIIIIlIlIll;
    }
    
    public boolean isHorseJumping() {
        return this.horseJumping;
    }
    
    @Override
    protected Item getDropItem() {
        final boolean lllllllllllllllIlllIIllllIIlIIII = this.rand.nextInt(4) == 0;
        final int lllllllllllllllIlllIIllllIIIllll = this.getHorseType();
        return (lllllllllllllllIlllIIllllIIIllll == 4) ? Items.bone : ((lllllllllllllllIlllIIllllIIIllll == 3) ? (lllllllllllllllIlllIIllllIIlIIII ? null : Items.rotten_flesh) : Items.leather);
    }
    
    public boolean canWearArmor() {
        return this.getHorseType() == 0;
    }
    
    private int getHorseArmorIndex(final ItemStack lllllllllllllllIlllIlIIIIlIlIIII) {
        if (lllllllllllllllIlllIlIIIIlIlIIII == null) {
            return 0;
        }
        final Item lllllllllllllllIlllIlIIIIlIIllll = lllllllllllllllIlllIlIIIIlIlIIII.getItem();
        return (lllllllllllllllIlllIlIIIIlIIllll == Items.iron_horse_armor) ? 1 : ((lllllllllllllllIlllIlIIIIlIIllll == Items.golden_horse_armor) ? 2 : ((lllllllllllllllIlllIlIIIIlIIllll == Items.diamond_horse_armor) ? 3 : 0));
    }
    
    @Override
    public boolean isOnLadder() {
        return false;
    }
    
    private boolean canMate() {
        return this.riddenByEntity == null && this.ridingEntity == null && this.isTame() && this.isAdultHorse() && !this.isSterile() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote && this.dataWatcher.hasObjectChanged()) {
            this.dataWatcher.func_111144_e();
            this.func_110230_cF();
        }
        if (this.openMouthCounter > 0 && ++this.openMouthCounter > 30) {
            this.openMouthCounter = 0;
            this.setHorseWatchableBoolean(128, false);
        }
        if (!this.worldObj.isRemote && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20) {
            this.jumpRearingCounter = 0;
            this.setRearing(false);
        }
        if (this.field_110278_bp > 0 && ++this.field_110278_bp > 8) {
            this.field_110278_bp = 0;
        }
        if (this.field_110279_bq > 0) {
            ++this.field_110279_bq;
            if (this.field_110279_bq > 300) {
                this.field_110279_bq = 0;
            }
        }
        this.prevHeadLean = this.headLean;
        if (this.isEatingHaystack()) {
            this.headLean += (1.0f - this.headLean) * 0.4f + 0.05f;
            if (this.headLean > 1.0f) {
                this.headLean = 1.0f;
            }
        }
        else {
            this.headLean += (0.0f - this.headLean) * 0.4f - 0.05f;
            if (this.headLean < 0.0f) {
                this.headLean = 0.0f;
            }
        }
        this.prevRearingAmount = this.rearingAmount;
        if (this.isRearing()) {
            final float n = 0.0f;
            this.headLean = n;
            this.prevHeadLean = n;
            this.rearingAmount += (1.0f - this.rearingAmount) * 0.4f + 0.05f;
            if (this.rearingAmount > 1.0f) {
                this.rearingAmount = 1.0f;
            }
        }
        else {
            this.field_110294_bI = false;
            this.rearingAmount += (0.8f * this.rearingAmount * this.rearingAmount * this.rearingAmount - this.rearingAmount) * 0.6f - 0.05f;
            if (this.rearingAmount < 0.0f) {
                this.rearingAmount = 0.0f;
            }
        }
        this.prevMouthOpenness = this.mouthOpenness;
        if (this.getHorseWatchableBoolean(128)) {
            this.mouthOpenness += (1.0f - this.mouthOpenness) * 0.7f + 0.05f;
            if (this.mouthOpenness > 1.0f) {
                this.mouthOpenness = 1.0f;
            }
        }
        else {
            this.mouthOpenness += (0.0f - this.mouthOpenness) * 0.7f - 0.05f;
            if (this.mouthOpenness < 0.0f) {
                this.mouthOpenness = 0.0f;
            }
        }
    }
    
    public boolean isHorseSaddled() {
        return this.getHorseWatchableBoolean(4);
    }
    
    public void setHorseTamed(final boolean lllllllllllllllIlllIlIIIIllIlIll) {
        this.setHorseWatchableBoolean(2, lllllllllllllllIlllIlIIIIllIlIll);
    }
    
    protected EntityHorse getClosestHorse(final Entity lllllllllllllllIlllIIllllIlIlllI, final double lllllllllllllllIlllIIllllIlIIlII) {
        double lllllllllllllllIlllIIllllIlIllII = Double.MAX_VALUE;
        Entity lllllllllllllllIlllIIllllIlIlIll = null;
        final List lllllllllllllllIlllIIllllIlIlIlI = this.worldObj.func_175674_a(lllllllllllllllIlllIIllllIlIlllI, lllllllllllllllIlllIIllllIlIlllI.getEntityBoundingBox().addCoord(lllllllllllllllIlllIIllllIlIIlII, lllllllllllllllIlllIIllllIlIIlII, lllllllllllllllIlllIIllllIlIIlII), EntityHorse.horseBreedingSelector);
        for (final Entity lllllllllllllllIlllIIllllIlIlIII : lllllllllllllllIlllIIllllIlIlIlI) {
            final double lllllllllllllllIlllIIllllIlIIlll = lllllllllllllllIlllIIllllIlIlIII.getDistanceSq(lllllllllllllllIlllIIllllIlIlllI.posX, lllllllllllllllIlllIIllllIlIlllI.posY, lllllllllllllllIlllIIllllIlIlllI.posZ);
            if (lllllllllllllllIlllIIllllIlIIlll < lllllllllllllllIlllIIllllIlIllII) {
                lllllllllllllllIlllIIllllIlIlIll = lllllllllllllllIlllIIllllIlIlIII;
                lllllllllllllllIlllIIllllIlIllII = lllllllllllllllIlllIIllllIlIIlll;
            }
        }
        return (EntityHorse)lllllllllllllllIlllIIllllIlIlIll;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
        this.dataWatcher.addObject(19, 0);
        this.dataWatcher.addObject(20, 0);
        this.dataWatcher.addObject(21, String.valueOf(""));
        this.dataWatcher.addObject(22, 0);
    }
    
    @Override
    public EntityAgeable createChild(final EntityAgeable lllllllllllllllIlllIIllIIllIIIIl) {
        final EntityHorse lllllllllllllllIlllIIllIIllIIIII = (EntityHorse)lllllllllllllllIlllIIllIIllIIIIl;
        final EntityHorse lllllllllllllllIlllIIllIIlIlllll = new EntityHorse(this.worldObj);
        final int lllllllllllllllIlllIIllIIlIllllI = this.getHorseType();
        final int lllllllllllllllIlllIIllIIlIlllIl = lllllllllllllllIlllIIllIIllIIIII.getHorseType();
        int lllllllllllllllIlllIIllIIlIlllII = 0;
        if (lllllllllllllllIlllIIllIIlIllllI == lllllllllllllllIlllIIllIIlIlllIl) {
            lllllllllllllllIlllIIllIIlIlllII = lllllllllllllllIlllIIllIIlIllllI;
        }
        else if ((lllllllllllllllIlllIIllIIlIllllI == 0 && lllllllllllllllIlllIIllIIlIlllIl == 1) || (lllllllllllllllIlllIIllIIlIllllI == 1 && lllllllllllllllIlllIIllIIlIlllIl == 0)) {
            lllllllllllllllIlllIIllIIlIlllII = 2;
        }
        if (lllllllllllllllIlllIIllIIlIlllII == 0) {
            final int lllllllllllllllIlllIIllIIlIllIll = this.rand.nextInt(9);
            int lllllllllllllllIlllIIllIIlIllIII = 0;
            if (lllllllllllllllIlllIIllIIlIllIll < 4) {
                final int lllllllllllllllIlllIIllIIlIllIlI = this.getHorseVariant() & 0xFF;
            }
            else if (lllllllllllllllIlllIIllIIlIllIll < 8) {
                final int lllllllllllllllIlllIIllIIlIllIIl = lllllllllllllllIlllIIllIIllIIIII.getHorseVariant() & 0xFF;
            }
            else {
                lllllllllllllllIlllIIllIIlIllIII = this.rand.nextInt(7);
            }
            final int lllllllllllllllIlllIIllIIlIlIlll = this.rand.nextInt(5);
            if (lllllllllllllllIlllIIllIIlIlIlll < 2) {
                lllllllllllllllIlllIIllIIlIllIII |= (this.getHorseVariant() & 0xFF00);
            }
            else if (lllllllllllllllIlllIIllIIlIlIlll < 4) {
                lllllllllllllllIlllIIllIIlIllIII |= (lllllllllllllllIlllIIllIIllIIIII.getHorseVariant() & 0xFF00);
            }
            else {
                lllllllllllllllIlllIIllIIlIllIII |= (this.rand.nextInt(5) << 8 & 0xFF00);
            }
            lllllllllllllllIlllIIllIIlIlllll.setHorseVariant(lllllllllllllllIlllIIllIIlIllIII);
        }
        lllllllllllllllIlllIIllIIlIlllll.setHorseType(lllllllllllllllIlllIIllIIlIlllII);
        final double lllllllllllllllIlllIIllIIlIlIllI = this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + lllllllllllllllIlllIIllIIllIIIIl.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + this.func_110267_cL();
        lllllllllllllllIlllIIllIIlIlllll.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(lllllllllllllllIlllIIllIIlIlIllI / 3.0);
        final double lllllllllllllllIlllIIllIIlIlIlIl = this.getEntityAttribute(EntityHorse.horseJumpStrength).getBaseValue() + lllllllllllllllIlllIIllIIllIIIIl.getEntityAttribute(EntityHorse.horseJumpStrength).getBaseValue() + this.func_110245_cM();
        lllllllllllllllIlllIIllIIlIlllll.getEntityAttribute(EntityHorse.horseJumpStrength).setBaseValue(lllllllllllllllIlllIIllIIlIlIlIl / 3.0);
        final double lllllllllllllllIlllIIllIIlIlIlII = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + lllllllllllllllIlllIIllIIllIIIIl.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + this.func_110203_cN();
        lllllllllllllllIlllIIllIIlIlllll.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(lllllllllllllllIlllIIllIIlIlIlII / 3.0);
        return lllllllllllllllIlllIIllIIlIlllll;
    }
    
    protected String getAngrySoundName() {
        this.openHorseMouth();
        this.makeHorseRear();
        final int lllllllllllllllIlllIIlllIllllIIl = this.getHorseType();
        return (lllllllllllllllIlllIIlllIllllIIl != 3 && lllllllllllllllIlllIIlllIllllIIl != 4) ? ((lllllllllllllllIlllIIlllIllllIIl != 1 && lllllllllllllllIlllIIlllIllllIIl != 2) ? "mob.horse.angry" : "mob.horse.donkey.angry") : null;
    }
    
    private void func_110237_h(final EntityPlayer lllllllllllllllIlllIIlllIIlIIIlI) {
        lllllllllllllllIlllIIlllIIlIIIlI.rotationYaw = this.rotationYaw;
        lllllllllllllllIlllIIlllIIlIIIlI.rotationPitch = this.rotationPitch;
        this.setEatingHaystack(false);
        this.setRearing(false);
        if (!this.worldObj.isRemote) {
            lllllllllllllllIlllIIlllIIlIIIlI.mountEntity(this);
        }
    }
    
    private float func_110267_cL() {
        return 15.0f + this.rand.nextInt(8) + this.rand.nextInt(9);
    }
    
    @Override
    protected void func_142017_o(final float lllllllllllllllIlllIlIIIIlIlllII) {
        if (lllllllllllllllIlllIlIIIIlIlllII > 6.0f && this.isEatingHaystack()) {
            this.setEatingHaystack(false);
        }
    }
    
    public void setHorseSaddled(final boolean lllllllllllllllIlllIlIIIIIlIIlIl) {
        this.setHorseWatchableBoolean(4, lllllllllllllllIlllIlIIIIIlIIlIl);
    }
    
    private void dropItemsInChest(final Entity lllllllllllllllIlllIIllIllIIllIl, final AnimalChest lllllllllllllllIlllIIllIllIIllII) {
        if (lllllllllllllllIlllIIllIllIIllII != null && !this.worldObj.isRemote) {
            for (int lllllllllllllllIlllIIllIllIIlIll = 0; lllllllllllllllIlllIIllIllIIlIll < lllllllllllllllIlllIIllIllIIllII.getSizeInventory(); ++lllllllllllllllIlllIIllIllIIlIll) {
                final ItemStack lllllllllllllllIlllIIllIllIIlIlI = lllllllllllllllIlllIIllIllIIllII.getStackInSlot(lllllllllllllllIlllIIllIllIIlIll);
                if (lllllllllllllllIlllIIllIllIIlIlI != null) {
                    this.entityDropItem(lllllllllllllllIlllIIllIllIIlIlI, 0.0f);
                }
            }
        }
    }
    
    public boolean isEatingHaystack() {
        return this.getHorseWatchableBoolean(32);
    }
    
    public void dropChestItems() {
        this.dropItemsInChest(this, this.horseChest);
        this.dropChests();
    }
    
    private boolean getHorseWatchableBoolean(final int lllllllllllllllIlllIlIIIlIIlllII) {
        return (this.dataWatcher.getWatchableObjectInt(16) & lllllllllllllllIlllIlIIIlIIlllII) != 0x0;
    }
    
    @Override
    public void onDeath(final DamageSource lllllllllllllllIlllIIlllIIIIIIlI) {
        super.onDeath(lllllllllllllllIlllIIlllIIIIIIlI);
        if (!this.worldObj.isRemote) {
            this.dropChestItems();
        }
    }
    
    private double func_110245_cM() {
        return 0.4000000059604645 + this.rand.nextDouble() * 0.2 + this.rand.nextDouble() * 0.2 + this.rand.nextDouble() * 0.2;
    }
    
    private void func_110232_cE() {
        if (!this.worldObj.isRemote) {
            this.setHorseSaddled(this.horseChest.getStackInSlot(0) != null);
            if (this.canWearArmor()) {
                this.setHorseArmorStack(this.horseChest.getStackInSlot(1));
            }
        }
    }
    
    public float getGrassEatingAmount(final float lllllllllllllllIlllIIllIIIlIlIII) {
        return this.prevHeadLean + (this.headLean - this.prevHeadLean) * lllllllllllllllIlllIIllIIIlIlIII;
    }
    
    @Override
    public int getMaxSpawnedInChunk() {
        return 6;
    }
    
    protected void spawnHorseParticles(final boolean lllllllllllllllIlllIIllIIIIIlIll) {
        final EnumParticleTypes lllllllllllllllIlllIIllIIIIIlIlI = lllllllllllllllIlllIIllIIIIIlIll ? EnumParticleTypes.HEART : EnumParticleTypes.SMOKE_NORMAL;
        for (int lllllllllllllllIlllIIllIIIIIlIIl = 0; lllllllllllllllIlllIIllIIIIIlIIl < 7; ++lllllllllllllllIlllIIllIIIIIlIIl) {
            final double lllllllllllllllIlllIIllIIIIIlIII = this.rand.nextGaussian() * 0.02;
            final double lllllllllllllllIlllIIllIIIIIIlll = this.rand.nextGaussian() * 0.02;
            final double lllllllllllllllIlllIIllIIIIIIllI = this.rand.nextGaussian() * 0.02;
            this.worldObj.spawnParticle(lllllllllllllllIlllIIllIIIIIlIlI, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, lllllllllllllllIlllIIllIIIIIlIII, lllllllllllllllIlllIIllIIIIIIlll, lllllllllllllllIlllIIllIIIIIIllI, new int[0]);
        }
    }
    
    public void setRearing(final boolean lllllllllllllllIlllIIllIlllIIIIl) {
        if (lllllllllllllllIlllIIllIlllIIIIl) {
            this.setEatingHaystack(false);
        }
        this.setHorseWatchableBoolean(64, lllllllllllllllIlllIIllIlllIIIIl);
    }
    
    @Override
    public int getTotalArmorValue() {
        return EntityHorse.armorValues[this.func_110241_cb()];
    }
    
    public boolean prepareChunkForSpawn() {
        final int lllllllllllllllIlllIIllllllllIlI = MathHelper.floor_double(this.posX);
        final int lllllllllllllllIlllIIllllllllIIl = MathHelper.floor_double(this.posZ);
        this.worldObj.getBiomeGenForCoords(new BlockPos(lllllllllllllllIlllIIllllllllIlI, 0, lllllllllllllllIlllIIllllllllIIl));
        return true;
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack lllllllllllllllIlllIIlllIIIIlIIl) {
        return false;
    }
    
    public float getHorseSize() {
        final int lllllllllllllllIlllIlIIIIllllIlI = this.getGrowingAge();
        return (lllllllllllllllIlllIlIIIIllllIlI >= 0) ? 1.0f : (0.5f + (-24000 - lllllllllllllllIlllIlIIIIllllIlI) / -24000.0f * 0.5f);
    }
    
    public int getTemper() {
        return this.temper;
    }
    
    public boolean setTamedBy(final EntityPlayer lllllllllllllllIlllIIllIllIIIIlI) {
        this.func_152120_b(lllllllllllllllIlllIIllIllIIIIlI.getUniqueID().toString());
        this.setHorseTamed(true);
        return true;
    }
    
    public int getMaxTemper() {
        return 100;
    }
    
    public void makeHorseRearWithSound() {
        this.makeHorseRear();
        final String lllllllllllllllIlllIIllIllIllIII = this.getAngrySoundName();
        if (lllllllllllllllIlllIIllIllIllIII != null) {
            this.playSound(lllllllllllllllIlllIIllIllIllIII, this.getSoundVolume(), this.getSoundPitch());
        }
    }
    
    private void setHorseTexturePaths() {
        this.field_110286_bQ = "horse/";
        this.field_110280_bR[0] = null;
        this.field_110280_bR[1] = null;
        this.field_110280_bR[2] = null;
        final int lllllllllllllllIlllIIlllIlIlIIIl = this.getHorseType();
        final int lllllllllllllllIlllIIlllIlIlIIII = this.getHorseVariant();
        if (lllllllllllllllIlllIIlllIlIlIIIl == 0) {
            final int lllllllllllllllIlllIIlllIlIIllll = lllllllllllllllIlllIIlllIlIlIIII & 0xFF;
            final int lllllllllllllllIlllIIlllIlIIllIl = (lllllllllllllllIlllIIlllIlIlIIII & 0xFF00) >> 8;
            if (lllllllllllllllIlllIIlllIlIIllll >= EntityHorse.horseTextures.length) {
                this.field_175508_bO = false;
                return;
            }
            this.field_110280_bR[0] = EntityHorse.horseTextures[lllllllllllllllIlllIIlllIlIIllll];
            this.field_110286_bQ = String.valueOf(new StringBuilder(String.valueOf(this.field_110286_bQ)).append(EntityHorse.field_110269_bA[lllllllllllllllIlllIIlllIlIIllll]));
            if (lllllllllllllllIlllIIlllIlIIllIl >= EntityHorse.horseMarkingTextures.length) {
                this.field_175508_bO = false;
                return;
            }
            this.field_110280_bR[1] = EntityHorse.horseMarkingTextures[lllllllllllllllIlllIIlllIlIIllIl];
            this.field_110286_bQ = String.valueOf(new StringBuilder(String.valueOf(this.field_110286_bQ)).append(EntityHorse.field_110292_bC[lllllllllllllllIlllIIlllIlIIllIl]));
        }
        else {
            this.field_110280_bR[0] = "";
            this.field_110286_bQ = String.valueOf(new StringBuilder(String.valueOf(this.field_110286_bQ)).append("_").append(lllllllllllllllIlllIIlllIlIlIIIl).append("_"));
        }
        final int lllllllllllllllIlllIIlllIlIIlllI = this.func_110241_cb();
        if (lllllllllllllllIlllIIlllIlIIlllI >= EntityHorse.horseArmorTextures.length) {
            this.field_175508_bO = false;
        }
        else {
            this.field_110280_bR[2] = EntityHorse.horseArmorTextures[lllllllllllllllIlllIIlllIlIIlllI];
            this.field_110286_bQ = String.valueOf(new StringBuilder(String.valueOf(this.field_110286_bQ)).append(EntityHorse.field_110273_bx[lllllllllllllllIlllIIlllIlIIlllI]));
            this.field_175508_bO = true;
        }
    }
    
    public void setJumpPower(int lllllllllllllllIlllIIllIIIIlIlII) {
        if (this.isHorseSaddled()) {
            if (lllllllllllllllIlllIIllIIIIlIlII < 0) {
                lllllllllllllllIlllIIllIIIIlIlII = 0;
            }
            else {
                this.field_110294_bI = true;
                this.makeHorseRear();
            }
            if (lllllllllllllllIlllIIllIIIIlIlII >= 90) {
                this.jumpPower = 1.0f;
            }
            else {
                this.jumpPower = 0.4f + 0.4f * lllllllllllllllIlllIIllIIIIlIlII / 90.0f;
            }
        }
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.8f;
    }
    
    public void setChested(final boolean lllllllllllllllIlllIlIIIIIlIllll) {
        this.setHorseWatchableBoolean(8, lllllllllllllllIlllIlIIIIIlIllll);
    }
    
    @Override
    public boolean canMateWith(final EntityAnimal lllllllllllllllIlllIIllIIlllIllI) {
        if (lllllllllllllllIlllIIllIIlllIllI == this) {
            return false;
        }
        if (lllllllllllllllIlllIIllIIlllIllI.getClass() != this.getClass()) {
            return false;
        }
        final EntityHorse lllllllllllllllIlllIIllIIlllIlIl = (EntityHorse)lllllllllllllllIlllIIllIIlllIllI;
        if (this.canMate() && lllllllllllllllIlllIIllIIlllIlIl.canMate()) {
            final int lllllllllllllllIlllIIllIIlllIlII = this.getHorseType();
            final int lllllllllllllllIlllIIllIIlllIIll = lllllllllllllllIlllIIllIIlllIlIl.getHorseType();
            return lllllllllllllllIlllIIllIIlllIlII == lllllllllllllllIlllIIllIIlllIIll || (lllllllllllllllIlllIIllIIlllIlII == 0 && lllllllllllllllIlllIIllIIlllIIll == 1) || (lllllllllllllllIlllIIllIIlllIlII == 1 && lllllllllllllllIlllIIllIIlllIIll == 0);
        }
        return false;
    }
    
    private void openHorseMouth() {
        if (!this.worldObj.isRemote) {
            this.openMouthCounter = 1;
            this.setHorseWatchableBoolean(128, true);
        }
    }
    
    public boolean func_175507_cI() {
        return this.field_175508_bO;
    }
    
    public int increaseTemper(final int lllllllllllllllIlllIlIIIIIIlIlIl) {
        final int lllllllllllllllIlllIlIIIIIIlIlII = MathHelper.clamp_int(this.getTemper() + lllllllllllllllIlllIlIIIIIIlIlIl, 0, this.getMaxTemper());
        this.setTemper(lllllllllllllllIlllIlIIIIIIlIlII);
        return lllllllllllllllIlllIlIIIIIIlIlII;
    }
    
    public static class GroupData implements IEntityLivingData
    {
        public /* synthetic */ int field_111106_b;
        public /* synthetic */ int field_111107_a;
        
        public GroupData(final int lIlIlIIIlII, final int lIlIlIIIIll) {
            this.field_111107_a = lIlIlIIIlII;
            this.field_111106_b = lIlIlIIIIll;
        }
        
        static {
            __OBFID = "CL_00001643";
        }
    }
}
