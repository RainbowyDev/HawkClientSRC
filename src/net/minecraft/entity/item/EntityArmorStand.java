package net.minecraft.entity.item;

import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class EntityArmorStand extends EntityLivingBase
{
    private /* synthetic */ Rotations leftLegRotation;
    private /* synthetic */ int disabledSlots;
    private /* synthetic */ Rotations leftArmRotation;
    private static final /* synthetic */ Rotations DEFAULT_RIGHTLEG_ROTATION;
    private final /* synthetic */ ItemStack[] contents;
    private static final /* synthetic */ Rotations DEFAULT_LEFTLEG_ROTATION;
    private /* synthetic */ long field_175437_i;
    private /* synthetic */ Rotations rightArmRotation;
    private static final /* synthetic */ Rotations DEFAULT_HEAD_ROTATION;
    private static final /* synthetic */ Rotations DEFAULT_BODY_ROTATION;
    private /* synthetic */ Rotations bodyRotation;
    private /* synthetic */ Rotations headRotation;
    private /* synthetic */ boolean canInteract;
    private static final /* synthetic */ Rotations DEFAULT_LEFTARM_ROTATION;
    private /* synthetic */ Rotations rightLegRotation;
    private static final /* synthetic */ Rotations DEFAULT_RIGHTARM_ROTATION;
    
    private void setSmall(final boolean lllllllllllllllllllIIllIlIlIIIll) {
        byte lllllllllllllllllllIIllIlIlIIlIl = this.dataWatcher.getWatchableObjectByte(10);
        if (lllllllllllllllllllIIllIlIlIIIll) {
            lllllllllllllllllllIIllIlIlIIlIl |= 0x1;
        }
        else {
            lllllllllllllllllllIIllIlIlIIlIl &= 0xFFFFFFFE;
        }
        this.dataWatcher.updateObject(10, lllllllllllllllllllIIllIlIlIIlIl);
    }
    
    @Override
    public void moveEntityWithHeading(final float lllllllllllllllllllIIllIllIlIllI, final float lllllllllllllllllllIIllIllIlIIlI) {
        if (!this.hasNoGravity()) {
            super.moveEntityWithHeading(lllllllllllllllllllIIllIllIlIllI, lllllllllllllllllllIIllIllIlIIlI);
        }
    }
    
    public Rotations getLeftLegRotation() {
        return this.leftLegRotation;
    }
    
    private void func_175422_a(final EntityPlayer lllllllllllllllllllIIlllIIIIllIl, final int lllllllllllllllllllIIlllIIIIllII) {
        final ItemStack lllllllllllllllllllIIlllIIIlIIll = this.contents[lllllllllllllllllllIIlllIIIIllII];
        if ((lllllllllllllllllllIIlllIIIlIIll == null || (this.disabledSlots & 1 << lllllllllllllllllllIIlllIIIIllII + 8) == 0x0) && (lllllllllllllllllllIIlllIIIlIIll != null || (this.disabledSlots & 1 << lllllllllllllllllllIIlllIIIIllII + 16) == 0x0)) {
            final int lllllllllllllllllllIIlllIIIlIIlI = lllllllllllllllllllIIlllIIIIllIl.inventory.currentItem;
            final ItemStack lllllllllllllllllllIIlllIIIlIIIl = lllllllllllllllllllIIlllIIIIllIl.inventory.getStackInSlot(lllllllllllllllllllIIlllIIIlIIlI);
            if (lllllllllllllllllllIIlllIIIIllIl.capabilities.isCreativeMode && (lllllllllllllllllllIIlllIIIlIIll == null || lllllllllllllllllllIIlllIIIlIIll.getItem() == Item.getItemFromBlock(Blocks.air)) && lllllllllllllllllllIIlllIIIlIIIl != null) {
                final ItemStack lllllllllllllllllllIIlllIIIlIIII = lllllllllllllllllllIIlllIIIlIIIl.copy();
                lllllllllllllllllllIIlllIIIlIIII.stackSize = 1;
                this.setCurrentItemOrArmor(lllllllllllllllllllIIlllIIIIllII, lllllllllllllllllllIIlllIIIlIIII);
            }
            else if (lllllllllllllllllllIIlllIIIlIIIl != null && lllllllllllllllllllIIlllIIIlIIIl.stackSize > 1) {
                if (lllllllllllllllllllIIlllIIIlIIll == null) {
                    final ItemStack lllllllllllllllllllIIlllIIIIllll = lllllllllllllllllllIIlllIIIlIIIl.copy();
                    lllllllllllllllllllIIlllIIIIllll.stackSize = 1;
                    this.setCurrentItemOrArmor(lllllllllllllllllllIIlllIIIIllII, lllllllllllllllllllIIlllIIIIllll);
                    final ItemStack itemStack = lllllllllllllllllllIIlllIIIlIIIl;
                    --itemStack.stackSize;
                }
            }
            else {
                this.setCurrentItemOrArmor(lllllllllllllllllllIIlllIIIIllII, lllllllllllllllllllIIlllIIIlIIIl);
                lllllllllllllllllllIIlllIIIIllIl.inventory.setInventorySlotContents(lllllllllllllllllllIIlllIIIlIIlI, lllllllllllllllllllIIlllIIIlIIll);
            }
        }
    }
    
    public boolean hasNoGravity() {
        return (this.dataWatcher.getWatchableObjectByte(10) & 0x2) != 0x0;
    }
    
    public boolean isSmall() {
        return (this.dataWatcher.getWatchableObjectByte(10) & 0x1) != 0x0;
    }
    
    @Override
    public boolean func_174825_a(final EntityPlayer lllllllllllllllllllIIlllIIlIlIlI, final Vec3 lllllllllllllllllllIIlllIIlllIII) {
        if (this.worldObj.isRemote || lllllllllllllllllllIIlllIIlIlIlI.func_175149_v()) {
            return true;
        }
        byte lllllllllllllllllllIIlllIIllIlll = 0;
        final ItemStack lllllllllllllllllllIIlllIIllIllI = lllllllllllllllllllIIlllIIlIlIlI.getCurrentEquippedItem();
        final boolean lllllllllllllllllllIIlllIIllIlIl = lllllllllllllllllllIIlllIIllIllI != null;
        if (lllllllllllllllllllIIlllIIllIlIl && lllllllllllllllllllIIlllIIllIllI.getItem() instanceof ItemArmor) {
            final ItemArmor lllllllllllllllllllIIlllIIllIlII = (ItemArmor)lllllllllllllllllllIIlllIIllIllI.getItem();
            if (lllllllllllllllllllIIlllIIllIlII.armorType == 3) {
                lllllllllllllllllllIIlllIIllIlll = 1;
            }
            else if (lllllllllllllllllllIIlllIIllIlII.armorType == 2) {
                lllllllllllllllllllIIlllIIllIlll = 2;
            }
            else if (lllllllllllllllllllIIlllIIllIlII.armorType == 1) {
                lllllllllllllllllllIIlllIIllIlll = 3;
            }
            else if (lllllllllllllllllllIIlllIIllIlII.armorType == 0) {
                lllllllllllllllllllIIlllIIllIlll = 4;
            }
        }
        if (lllllllllllllllllllIIlllIIllIlIl && (lllllllllllllllllllIIlllIIllIllI.getItem() == Items.skull || lllllllllllllllllllIIlllIIllIllI.getItem() == Item.getItemFromBlock(Blocks.pumpkin))) {
            lllllllllllllllllllIIlllIIllIlll = 4;
        }
        final double lllllllllllllllllllIIlllIIllIIll = 0.1;
        final double lllllllllllllllllllIIlllIIllIIlI = 0.9;
        final double lllllllllllllllllllIIlllIIllIIIl = 0.4;
        final double lllllllllllllllllllIIlllIIllIIII = 1.6;
        byte lllllllllllllllllllIIlllIIlIllll = 0;
        final boolean lllllllllllllllllllIIlllIIlIlllI = this.isSmall();
        final double lllllllllllllllllllIIlllIIlIllIl = lllllllllllllllllllIIlllIIlIlllI ? (lllllllllllllllllllIIlllIIlllIII.yCoord * 2.0) : lllllllllllllllllllIIlllIIlllIII.yCoord;
        if (lllllllllllllllllllIIlllIIlIllIl >= 0.1 && lllllllllllllllllllIIlllIIlIllIl < 0.1 + (lllllllllllllllllllIIlllIIlIlllI ? 0.8 : 0.45) && this.contents[1] != null) {
            lllllllllllllllllllIIlllIIlIllll = 1;
        }
        else if (lllllllllllllllllllIIlllIIlIllIl >= 0.9 + (lllllllllllllllllllIIlllIIlIlllI ? 0.3 : 0.0) && lllllllllllllllllllIIlllIIlIllIl < 0.9 + (lllllllllllllllllllIIlllIIlIlllI ? 1.0 : 0.7) && this.contents[3] != null) {
            lllllllllllllllllllIIlllIIlIllll = 3;
        }
        else if (lllllllllllllllllllIIlllIIlIllIl >= 0.4 && lllllllllllllllllllIIlllIIlIllIl < 0.4 + (lllllllllllllllllllIIlllIIlIlllI ? 1.0 : 0.8) && this.contents[2] != null) {
            lllllllllllllllllllIIlllIIlIllll = 2;
        }
        else if (lllllllllllllllllllIIlllIIlIllIl >= 1.6 && this.contents[4] != null) {
            lllllllllllllllllllIIlllIIlIllll = 4;
        }
        final boolean lllllllllllllllllllIIlllIIlIllII = this.contents[lllllllllllllllllllIIlllIIlIllll] != null;
        if ((this.disabledSlots & 1 << lllllllllllllllllllIIlllIIlIllll) != 0x0 || (this.disabledSlots & 1 << lllllllllllllllllllIIlllIIllIlll) != 0x0) {
            lllllllllllllllllllIIlllIIlIllll = lllllllllllllllllllIIlllIIllIlll;
            if ((this.disabledSlots & 1 << lllllllllllllllllllIIlllIIllIlll) != 0x0) {
                if ((this.disabledSlots & 0x1) != 0x0) {
                    return true;
                }
                lllllllllllllllllllIIlllIIlIllll = 0;
            }
        }
        if (lllllllllllllllllllIIlllIIllIlIl && lllllllllllllllllllIIlllIIllIlll == 0 && !this.getShowArms()) {
            return true;
        }
        if (lllllllllllllllllllIIlllIIllIlIl) {
            this.func_175422_a(lllllllllllllllllllIIlllIIlIlIlI, lllllllllllllllllllIIlllIIllIlll);
        }
        else if (lllllllllllllllllllIIlllIIlIllII) {
            this.func_175422_a(lllllllllllllllllllIIlllIIlIlIlI, lllllllllllllllllllIIlllIIlIllll);
        }
        return true;
    }
    
    public void setBodyRotation(final Rotations lllllllllllllllllllIIllIIlllIIIl) {
        this.bodyRotation = lllllllllllllllllllIIllIIlllIIIl;
        this.dataWatcher.updateObject(12, lllllllllllllllllllIIllIIlllIIIl);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(10, 0);
        this.dataWatcher.addObject(11, EntityArmorStand.DEFAULT_HEAD_ROTATION);
        this.dataWatcher.addObject(12, EntityArmorStand.DEFAULT_BODY_ROTATION);
        this.dataWatcher.addObject(13, EntityArmorStand.DEFAULT_LEFTARM_ROTATION);
        this.dataWatcher.addObject(14, EntityArmorStand.DEFAULT_RIGHTARM_ROTATION);
        this.dataWatcher.addObject(15, EntityArmorStand.DEFAULT_LEFTLEG_ROTATION);
        this.dataWatcher.addObject(16, EntityArmorStand.DEFAULT_RIGHTLEG_ROTATION);
    }
    
    @Override
    public ItemStack[] getInventory() {
        return this.contents;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllllllIIllllIIIIllI) {
        super.writeEntityToNBT(lllllllllllllllllllIIllllIIIIllI);
        final NBTTagList lllllllllllllllllllIIllllIIIlIlI = new NBTTagList();
        for (int lllllllllllllllllllIIllllIIIlIIl = 0; lllllllllllllllllllIIllllIIIlIIl < this.contents.length; ++lllllllllllllllllllIIllllIIIlIIl) {
            final NBTTagCompound lllllllllllllllllllIIllllIIIlIII = new NBTTagCompound();
            if (this.contents[lllllllllllllllllllIIllllIIIlIIl] != null) {
                this.contents[lllllllllllllllllllIIllllIIIlIIl].writeToNBT(lllllllllllllllllllIIllllIIIlIII);
            }
            lllllllllllllllllllIIllllIIIlIlI.appendTag(lllllllllllllllllllIIllllIIIlIII);
        }
        lllllllllllllllllllIIllllIIIIllI.setTag("Equipment", lllllllllllllllllllIIllllIIIlIlI);
        if (this.getAlwaysRenderNameTag() && (this.getCustomNameTag() == null || this.getCustomNameTag().length() == 0)) {
            lllllllllllllllllllIIllllIIIIllI.setBoolean("CustomNameVisible", this.getAlwaysRenderNameTag());
        }
        lllllllllllllllllllIIllllIIIIllI.setBoolean("Invisible", this.isInvisible());
        lllllllllllllllllllIIllllIIIIllI.setBoolean("Small", this.isSmall());
        lllllllllllllllllllIIllllIIIIllI.setBoolean("ShowArms", this.getShowArms());
        lllllllllllllllllllIIllllIIIIllI.setInteger("DisabledSlots", this.disabledSlots);
        lllllllllllllllllllIIllllIIIIllI.setBoolean("NoGravity", this.hasNoGravity());
        lllllllllllllllllllIIllllIIIIllI.setBoolean("NoBasePlate", this.hasNoBasePlate());
        lllllllllllllllllllIIllllIIIIllI.setTag("Pose", this.readPoseFromNBT());
    }
    
    @Override
    protected void collideWithNearbyEntities() {
        final List lllllllllllllllllllIIlllIlIIllll = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());
        if (lllllllllllllllllllIIlllIlIIllll != null && !lllllllllllllllllllIIlllIlIIllll.isEmpty()) {
            for (int lllllllllllllllllllIIlllIlIIlllI = 0; lllllllllllllllllllIIlllIlIIlllI < lllllllllllllllllllIIlllIlIIllll.size(); ++lllllllllllllllllllIIlllIlIIlllI) {
                final Entity lllllllllllllllllllIIlllIlIIllIl = lllllllllllllllllllIIlllIlIIllll.get(lllllllllllllllllllIIlllIlIIlllI);
                if (lllllllllllllllllllIIlllIlIIllIl instanceof EntityMinecart && ((EntityMinecart)lllllllllllllllllllIIlllIlIIllIl).func_180456_s() == EntityMinecart.EnumMinecartType.RIDEABLE && this.getDistanceSqToEntity(lllllllllllllllllllIIlllIlIIllIl) <= 0.2) {
                    lllllllllllllllllllIIlllIlIIllIl.applyEntityCollision(this);
                }
            }
        }
    }
    
    public Rotations getLeftArmRotation() {
        return this.leftArmRotation;
    }
    
    private void dropBlock() {
        Block.spawnAsEntity(this.worldObj, new BlockPos(this), new ItemStack(Items.armor_stand));
        this.dropContents();
    }
    
    @Override
    public boolean func_174820_d(final int lllllllllllllllllllIIllllIIllIIl, final ItemStack lllllllllllllllllllIIllllIIllIII) {
        int lllllllllllllllllllIIllllIIlIllI = 0;
        if (lllllllllllllllllllIIllllIIllIIl == 99) {
            final int lllllllllllllllllllIIllllIIlIlll = 0;
        }
        else {
            lllllllllllllllllllIIllllIIlIllI = lllllllllllllllllllIIllllIIllIIl - 100 + 1;
            if (lllllllllllllllllllIIllllIIlIllI < 0 || lllllllllllllllllllIIllllIIlIllI >= this.contents.length) {
                return false;
            }
        }
        if (lllllllllllllllllllIIllllIIllIII != null && EntityLiving.getArmorPosition(lllllllllllllllllllIIllllIIllIII) != lllllllllllllllllllIIllllIIlIllI && (lllllllllllllllllllIIllllIIlIllI != 4 || !(lllllllllllllllllllIIllllIIllIII.getItem() instanceof ItemBlock))) {
            return false;
        }
        this.setCurrentItemOrArmor(lllllllllllllllllllIIllllIIlIllI, lllllllllllllllllllIIllllIIllIII);
        return true;
    }
    
    @Override
    protected void func_175135_B() {
        this.setInvisible(this.canInteract);
    }
    
    private void writePoseToNBT(final NBTTagCompound lllllllllllllllllllIIlllIllIIlII) {
        final NBTTagList lllllllllllllllllllIIlllIllIlIll = lllllllllllllllllllIIlllIllIIlII.getTagList("Head", 5);
        if (lllllllllllllllllllIIlllIllIlIll.tagCount() > 0) {
            this.setHeadRotation(new Rotations(lllllllllllllllllllIIlllIllIlIll));
        }
        else {
            this.setHeadRotation(EntityArmorStand.DEFAULT_HEAD_ROTATION);
        }
        final NBTTagList lllllllllllllllllllIIlllIllIlIlI = lllllllllllllllllllIIlllIllIIlII.getTagList("Body", 5);
        if (lllllllllllllllllllIIlllIllIlIlI.tagCount() > 0) {
            this.setBodyRotation(new Rotations(lllllllllllllllllllIIlllIllIlIlI));
        }
        else {
            this.setBodyRotation(EntityArmorStand.DEFAULT_BODY_ROTATION);
        }
        final NBTTagList lllllllllllllllllllIIlllIllIlIIl = lllllllllllllllllllIIlllIllIIlII.getTagList("LeftArm", 5);
        if (lllllllllllllllllllIIlllIllIlIIl.tagCount() > 0) {
            this.setLeftArmRotation(new Rotations(lllllllllllllllllllIIlllIllIlIIl));
        }
        else {
            this.setLeftArmRotation(EntityArmorStand.DEFAULT_LEFTARM_ROTATION);
        }
        final NBTTagList lllllllllllllllllllIIlllIllIlIII = lllllllllllllllllllIIlllIllIIlII.getTagList("RightArm", 5);
        if (lllllllllllllllllllIIlllIllIlIII.tagCount() > 0) {
            this.setRightArmRotation(new Rotations(lllllllllllllllllllIIlllIllIlIII));
        }
        else {
            this.setRightArmRotation(EntityArmorStand.DEFAULT_RIGHTARM_ROTATION);
        }
        final NBTTagList lllllllllllllllllllIIlllIllIIlll = lllllllllllllllllllIIlllIllIIlII.getTagList("LeftLeg", 5);
        if (lllllllllllllllllllIIlllIllIIlll.tagCount() > 0) {
            this.setLeftLegRotation(new Rotations(lllllllllllllllllllIIlllIllIIlll));
        }
        else {
            this.setLeftLegRotation(EntityArmorStand.DEFAULT_LEFTLEG_ROTATION);
        }
        final NBTTagList lllllllllllllllllllIIlllIllIIllI = lllllllllllllllllllIIlllIllIIlII.getTagList("RightLeg", 5);
        if (lllllllllllllllllllIIlllIllIIllI.tagCount() > 0) {
            this.setRightLegRotation(new Rotations(lllllllllllllllllllIIlllIllIIllI));
        }
        else {
            this.setRightLegRotation(EntityArmorStand.DEFAULT_RIGHTLEG_ROTATION);
        }
    }
    
    private void dropContents() {
        for (int lllllllllllllllllllIIllIlllIIlIl = 0; lllllllllllllllllllIIllIlllIIlIl < this.contents.length; ++lllllllllllllllllllIIllIlllIIlIl) {
            if (this.contents[lllllllllllllllllllIIllIlllIIlIl] != null && this.contents[lllllllllllllllllllIIllIlllIIlIl].stackSize > 0) {
                if (this.contents[lllllllllllllllllllIIllIlllIIlIl] != null) {
                    Block.spawnAsEntity(this.worldObj, new BlockPos(this).offsetUp(), this.contents[lllllllllllllllllllIIllIlllIIlIl]);
                }
                this.contents[lllllllllllllllllllIIllIlllIIlIl] = null;
            }
        }
    }
    
    public Rotations getHeadRotation() {
        return this.headRotation;
    }
    
    @Override
    public boolean func_180427_aV() {
        return this.isInvisible();
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        final Rotations lllllllllllllllllllIIllIllIIlIIl = this.dataWatcher.getWatchableObjectRotations(11);
        if (!this.headRotation.equals(lllllllllllllllllllIIllIllIIlIIl)) {
            this.setHeadRotation(lllllllllllllllllllIIllIllIIlIIl);
        }
        final Rotations lllllllllllllllllllIIllIllIIlIII = this.dataWatcher.getWatchableObjectRotations(12);
        if (!this.bodyRotation.equals(lllllllllllllllllllIIllIllIIlIII)) {
            this.setBodyRotation(lllllllllllllllllllIIllIllIIlIII);
        }
        final Rotations lllllllllllllllllllIIllIllIIIlll = this.dataWatcher.getWatchableObjectRotations(13);
        if (!this.leftArmRotation.equals(lllllllllllllllllllIIllIllIIIlll)) {
            this.setLeftArmRotation(lllllllllllllllllllIIllIllIIIlll);
        }
        final Rotations lllllllllllllllllllIIllIllIIIllI = this.dataWatcher.getWatchableObjectRotations(14);
        if (!this.rightArmRotation.equals(lllllllllllllllllllIIllIllIIIllI)) {
            this.setRightArmRotation(lllllllllllllllllllIIllIllIIIllI);
        }
        final Rotations lllllllllllllllllllIIllIllIIIlIl = this.dataWatcher.getWatchableObjectRotations(15);
        if (!this.leftLegRotation.equals(lllllllllllllllllllIIllIllIIIlIl)) {
            this.setLeftLegRotation(lllllllllllllllllllIIllIllIIIlIl);
        }
        final Rotations lllllllllllllllllllIIllIllIIIlII = this.dataWatcher.getWatchableObjectRotations(16);
        if (!this.rightLegRotation.equals(lllllllllllllllllllIIllIllIIIlII)) {
            this.setRightLegRotation(lllllllllllllllllllIIllIllIIIlII);
        }
    }
    
    public Rotations getRightArmRotation() {
        return this.rightArmRotation;
    }
    
    @Override
    public float getEyeHeight() {
        return this.isChild() ? (this.height * 0.5f) : (this.height * 0.9f);
    }
    
    private void setNoGravity(final boolean lllllllllllllllllllIIllIlIIlIlll) {
        byte lllllllllllllllllllIIllIlIIllIIl = this.dataWatcher.getWatchableObjectByte(10);
        if (lllllllllllllllllllIIllIlIIlIlll) {
            lllllllllllllllllllIIllIlIIllIIl |= 0x2;
        }
        else {
            lllllllllllllllllllIIllIlIIllIIl &= 0xFFFFFFFD;
        }
        this.dataWatcher.updateObject(10, lllllllllllllllllllIIllIlIIllIIl);
    }
    
    public void setRightLegRotation(final Rotations lllllllllllllllllllIIllIIlIllIIl) {
        this.rightLegRotation = lllllllllllllllllllIIllIIlIllIIl;
        this.dataWatcher.updateObject(16, lllllllllllllllllllIIllIIlIllIIl);
    }
    
    private void setNoBasePlate(final boolean lllllllllllllllllllIIllIlIIIIIlI) {
        byte lllllllllllllllllllIIllIlIIIIIIl = this.dataWatcher.getWatchableObjectByte(10);
        if (lllllllllllllllllllIIllIlIIIIIlI) {
            lllllllllllllllllllIIllIlIIIIIIl |= 0x8;
        }
        else {
            lllllllllllllllllllIIllIlIIIIIIl &= 0xFFFFFFF7;
        }
        this.dataWatcher.updateObject(10, lllllllllllllllllllIIllIlIIIIIIl);
    }
    
    @Override
    public void setInvisible(final boolean lllllllllllllllllllIIllIlIllIlII) {
        this.canInteract = lllllllllllllllllllIIllIlIllIlII;
        super.setInvisible(lllllllllllllllllllIIllIlIllIlII);
    }
    
    public void setRightArmRotation(final Rotations lllllllllllllllllllIIllIIllIIlIl) {
        this.rightArmRotation = lllllllllllllllllllIIllIIllIIlIl;
        this.dataWatcher.updateObject(14, lllllllllllllllllllIIllIIllIIlIl);
    }
    
    @Override
    public ItemStack getCurrentArmor(final int lllllllllllllllllllIIllllIlIllIl) {
        return this.contents[lllllllllllllllllllIIllllIlIllIl + 1];
    }
    
    public void setHeadRotation(final Rotations lllllllllllllllllllIIllIIlllIlll) {
        this.headRotation = lllllllllllllllllllIIllIIlllIlll;
        this.dataWatcher.updateObject(11, lllllllllllllllllllIIllIIlllIlll);
    }
    
    @Override
    public boolean canBePushed() {
        return false;
    }
    
    @Override
    public ItemStack getEquipmentInSlot(final int lllllllllllllllllllIIllllIllIIIl) {
        return this.contents[lllllllllllllllllllIIllllIllIIIl];
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllllllIIlllIllllIII) {
        super.readEntityFromNBT(lllllllllllllllllllIIlllIllllIII);
        if (lllllllllllllllllllIIlllIllllIII.hasKey("Equipment", 9)) {
            final NBTTagList lllllllllllllllllllIIlllIlllllII = lllllllllllllllllllIIlllIllllIII.getTagList("Equipment", 10);
            for (int lllllllllllllllllllIIlllIllllIll = 0; lllllllllllllllllllIIlllIllllIll < this.contents.length; ++lllllllllllllllllllIIlllIllllIll) {
                this.contents[lllllllllllllllllllIIlllIllllIll] = ItemStack.loadItemStackFromNBT(lllllllllllllllllllIIlllIlllllII.getCompoundTagAt(lllllllllllllllllllIIlllIllllIll));
            }
        }
        this.setInvisible(lllllllllllllllllllIIlllIllllIII.getBoolean("Invisible"));
        this.setSmall(lllllllllllllllllllIIlllIllllIII.getBoolean("Small"));
        this.setShowArms(lllllllllllllllllllIIlllIllllIII.getBoolean("ShowArms"));
        this.disabledSlots = lllllllllllllllllllIIlllIllllIII.getInteger("DisabledSlots");
        this.setNoGravity(lllllllllllllllllllIIlllIllllIII.getBoolean("NoGravity"));
        this.setNoBasePlate(lllllllllllllllllllIIlllIllllIII.getBoolean("NoBasePlate"));
        this.noClip = this.hasNoGravity();
        final NBTTagCompound lllllllllllllllllllIIlllIllllIlI = lllllllllllllllllllIIlllIllllIII.getCompoundTag("Pose");
        this.writePoseToNBT(lllllllllllllllllllIIlllIllllIlI);
    }
    
    private NBTTagCompound readPoseFromNBT() {
        final NBTTagCompound lllllllllllllllllllIIlllIlIllIlI = new NBTTagCompound();
        if (!EntityArmorStand.DEFAULT_HEAD_ROTATION.equals(this.headRotation)) {
            lllllllllllllllllllIIlllIlIllIlI.setTag("Head", this.headRotation.func_179414_a());
        }
        if (!EntityArmorStand.DEFAULT_BODY_ROTATION.equals(this.bodyRotation)) {
            lllllllllllllllllllIIlllIlIllIlI.setTag("Body", this.bodyRotation.func_179414_a());
        }
        if (!EntityArmorStand.DEFAULT_LEFTARM_ROTATION.equals(this.leftArmRotation)) {
            lllllllllllllllllllIIlllIlIllIlI.setTag("LeftArm", this.leftArmRotation.func_179414_a());
        }
        if (!EntityArmorStand.DEFAULT_RIGHTARM_ROTATION.equals(this.rightArmRotation)) {
            lllllllllllllllllllIIlllIlIllIlI.setTag("RightArm", this.rightArmRotation.func_179414_a());
        }
        if (!EntityArmorStand.DEFAULT_LEFTLEG_ROTATION.equals(this.leftLegRotation)) {
            lllllllllllllllllllIIlllIlIllIlI.setTag("LeftLeg", this.leftLegRotation.func_179414_a());
        }
        if (!EntityArmorStand.DEFAULT_RIGHTLEG_ROTATION.equals(this.rightLegRotation)) {
            lllllllllllllllllllIIlllIlIllIlI.setTag("RightLeg", this.rightLegRotation.func_179414_a());
        }
        return lllllllllllllllllllIIlllIlIllIlI;
    }
    
    public EntityArmorStand(final World lllllllllllllllllllIIlllllIIllll) {
        super(lllllllllllllllllllIIlllllIIllll);
        this.contents = new ItemStack[5];
        this.headRotation = EntityArmorStand.DEFAULT_HEAD_ROTATION;
        this.bodyRotation = EntityArmorStand.DEFAULT_BODY_ROTATION;
        this.leftArmRotation = EntityArmorStand.DEFAULT_LEFTARM_ROTATION;
        this.rightArmRotation = EntityArmorStand.DEFAULT_RIGHTARM_ROTATION;
        this.leftLegRotation = EntityArmorStand.DEFAULT_LEFTLEG_ROTATION;
        this.rightLegRotation = EntityArmorStand.DEFAULT_RIGHTLEG_ROTATION;
        this.func_174810_b(true);
        this.noClip = this.hasNoGravity();
        this.setSize(0.5f, 1.975f);
    }
    
    private void setShowArms(final boolean lllllllllllllllllllIIllIlIIIlIll) {
        byte lllllllllllllllllllIIllIlIIIllIl = this.dataWatcher.getWatchableObjectByte(10);
        if (lllllllllllllllllllIIllIlIIIlIll) {
            lllllllllllllllllllIIllIlIIIllIl |= 0x4;
        }
        else {
            lllllllllllllllllllIIllIlIIIllIl &= 0xFFFFFFFB;
        }
        this.dataWatcher.updateObject(10, lllllllllllllllllllIIllIlIIIllIl);
    }
    
    @Override
    public void setCurrentItemOrArmor(final int lllllllllllllllllllIIllllIlIIllI, final ItemStack lllllllllllllllllllIIllllIlIIIlI) {
        this.contents[lllllllllllllllllllIIllllIlIIllI] = lllllllllllllllllllIIllllIlIIIlI;
    }
    
    public boolean hasNoBasePlate() {
        return (this.dataWatcher.getWatchableObjectByte(10) & 0x8) != 0x0;
    }
    
    @Override
    public void func_174812_G() {
        this.setDead();
    }
    
    private void func_175406_a(final float lllllllllllllllllllIIllIlllIllIl) {
        float lllllllllllllllllllIIllIlllIllll = this.getHealth();
        lllllllllllllllllllIIllIlllIllll -= lllllllllllllllllllIIllIlllIllIl;
        if (lllllllllllllllllllIIllIlllIllll <= 0.5f) {
            this.dropContents();
            this.setDead();
        }
        else {
            this.setHealth(lllllllllllllllllllIIllIlllIllll);
        }
    }
    
    @Override
    protected float func_110146_f(final float lllllllllllllllllllIIllIlllIIIII, final float lllllllllllllllllllIIllIllIlllll) {
        this.prevRenderYawOffset = this.prevRotationYaw;
        this.renderYawOffset = this.rotationYaw;
        return 0.0f;
    }
    
    public EntityArmorStand(final World lllllllllllllllllllIIlllllIIlIII, final double lllllllllllllllllllIIlllllIIIIlI, final double lllllllllllllllllllIIlllllIIIllI, final double lllllllllllllllllllIIlllllIIIIII) {
        this(lllllllllllllllllllIIlllllIIlIII);
        this.setPosition(lllllllllllllllllllIIlllllIIIIlI, lllllllllllllllllllIIlllllIIIllI, lllllllllllllllllllIIlllllIIIIII);
    }
    
    public void setLeftLegRotation(final Rotations lllllllllllllllllllIIllIIlIlllll) {
        this.leftLegRotation = lllllllllllllllllllIIllIIlIlllll;
        this.dataWatcher.updateObject(15, lllllllllllllllllllIIllIIlIlllll);
    }
    
    public void setLeftArmRotation(final Rotations lllllllllllllllllllIIllIIllIlIll) {
        this.leftArmRotation = lllllllllllllllllllIIllIIllIlIll;
        this.dataWatcher.updateObject(13, lllllllllllllllllllIIllIIllIlIll);
    }
    
    @Override
    public boolean isChild() {
        return this.isSmall();
    }
    
    @Override
    public ItemStack getHeldItem() {
        return this.contents[0];
    }
    
    public boolean getShowArms() {
        return (this.dataWatcher.getWatchableObjectByte(10) & 0x4) != 0x0;
    }
    
    public Rotations getBodyRotation() {
        return this.bodyRotation;
    }
    
    public Rotations getRightLegRotation() {
        return this.rightLegRotation;
    }
    
    static {
        __OBFID = "CL_00002228";
        DEFAULT_HEAD_ROTATION = new Rotations(0.0f, 0.0f, 0.0f);
        DEFAULT_BODY_ROTATION = new Rotations(0.0f, 0.0f, 0.0f);
        DEFAULT_LEFTARM_ROTATION = new Rotations(-10.0f, 0.0f, -10.0f);
        DEFAULT_RIGHTARM_ROTATION = new Rotations(-15.0f, 0.0f, 10.0f);
        DEFAULT_LEFTLEG_ROTATION = new Rotations(-1.0f, 0.0f, -1.0f);
        DEFAULT_RIGHTLEG_ROTATION = new Rotations(1.0f, 0.0f, 1.0f);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllllllIIlllIIIIIIIl, final float lllllllllllllllllllIIlllIIIIIIII) {
        if (this.worldObj.isRemote || this.canInteract) {
            return false;
        }
        if (DamageSource.outOfWorld.equals(lllllllllllllllllllIIlllIIIIIIIl)) {
            this.setDead();
            return false;
        }
        if (this.func_180431_b(lllllllllllllllllllIIlllIIIIIIIl)) {
            return false;
        }
        if (lllllllllllllllllllIIlllIIIIIIIl.isExplosion()) {
            this.dropContents();
            this.setDead();
            return false;
        }
        if (DamageSource.inFire.equals(lllllllllllllllllllIIlllIIIIIIIl)) {
            if (!this.isBurning()) {
                this.setFire(5);
            }
            else {
                this.func_175406_a(0.15f);
            }
            return false;
        }
        if (DamageSource.onFire.equals(lllllllllllllllllllIIlllIIIIIIIl) && this.getHealth() > 0.5f) {
            this.func_175406_a(4.0f);
            return false;
        }
        final boolean lllllllllllllllllllIIllIllllllll = "arrow".equals(lllllllllllllllllllIIlllIIIIIIIl.getDamageType());
        final boolean lllllllllllllllllllIIllIlllllllI = "player".equals(lllllllllllllllllllIIlllIIIIIIIl.getDamageType());
        if (!lllllllllllllllllllIIllIlllllllI && !lllllllllllllllllllIIllIllllllll) {
            return false;
        }
        if (lllllllllllllllllllIIlllIIIIIIIl.getSourceOfDamage() instanceof EntityArrow) {
            lllllllllllllllllllIIlllIIIIIIIl.getSourceOfDamage().setDead();
        }
        if (lllllllllllllllllllIIlllIIIIIIIl.getEntity() instanceof EntityPlayer && !((EntityPlayer)lllllllllllllllllllIIlllIIIIIIIl.getEntity()).capabilities.allowEdit) {
            return false;
        }
        if (lllllllllllllllllllIIlllIIIIIIIl.func_180136_u()) {
            this.playParticles();
            this.setDead();
            return false;
        }
        final long lllllllllllllllllllIIllIllllllIl = this.worldObj.getTotalWorldTime();
        if (lllllllllllllllllllIIllIllllllIl - this.field_175437_i > 5L && !lllllllllllllllllllIIllIllllllll) {
            this.field_175437_i = lllllllllllllllllllIIllIllllllIl;
        }
        else {
            this.dropBlock();
            this.playParticles();
            this.setDead();
        }
        return false;
    }
    
    private void playParticles() {
        if (this.worldObj instanceof WorldServer) {
            ((WorldServer)this.worldObj).func_175739_a(EnumParticleTypes.BLOCK_DUST, this.posX, this.posY + this.height / 1.5, this.posZ, 10, this.width / 4.0f, this.height / 4.0f, this.width / 4.0f, 0.05, Block.getStateId(Blocks.planks.getDefaultState()));
        }
    }
    
    @Override
    public boolean isServerWorld() {
        return super.isServerWorld() && !this.hasNoGravity();
    }
    
    @Override
    protected void collideWithEntity(final Entity lllllllllllllllllllIIlllIlIlIlIl) {
    }
}
