package net.minecraft.entity.item;

import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.world.storage.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;

public class EntityItemFrame extends EntityHanging
{
    private /* synthetic */ float itemDropChance;
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lIIlIIllIlIIll) {
        if (this.getDisplayedItem() != null) {
            lIIlIIllIlIIll.setTag("Item", this.getDisplayedItem().writeToNBT(new NBTTagCompound()));
            lIIlIIllIlIIll.setByte("ItemRotation", (byte)this.getRotation());
            lIIlIIllIlIIll.setFloat("ItemDropChance", this.itemDropChance);
        }
        super.writeEntityToNBT(lIIlIIllIlIIll);
    }
    
    @Override
    public int getHeightPixels() {
        return 12;
    }
    
    public int func_174866_q() {
        return (this.getDisplayedItem() == null) ? 0 : (this.getRotation() % 8 + 1);
    }
    
    private void removeFrameFromMap(final ItemStack lIIlIIllllllll) {
        if (lIIlIIllllllll != null) {
            if (lIIlIIllllllll.getItem() == Items.filled_map) {
                final MapData lIIlIIlllllllI = ((ItemMap)lIIlIIllllllll.getItem()).getMapData(lIIlIIllllllll, this.worldObj);
                lIIlIIlllllllI.playersVisibleOnMap.remove(String.valueOf(new StringBuilder("frame-").append(this.getEntityId())));
            }
            lIIlIIllllllll.setItemFrame(null);
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lIIlIIllIIllII) {
        final NBTTagCompound lIIlIIllIIlIll = lIIlIIllIIllII.getCompoundTag("Item");
        if (lIIlIIllIIlIll != null && !lIIlIIllIIlIll.hasNoTags()) {
            this.func_174864_a(ItemStack.loadItemStackFromNBT(lIIlIIllIIlIll), false);
            this.func_174865_a(lIIlIIllIIllII.getByte("ItemRotation"), false);
            if (lIIlIIllIIllII.hasKey("ItemDropChance", 99)) {
                this.itemDropChance = lIIlIIllIIllII.getFloat("ItemDropChance");
            }
            if (lIIlIIllIIllII.hasKey("Direction")) {
                this.func_174865_a(this.getRotation() * 2, false);
            }
        }
        super.readEntityFromNBT(lIIlIIllIIllII);
    }
    
    @Override
    protected void entityInit() {
        this.getDataWatcher().addObjectByDataType(8, 5);
        this.getDataWatcher().addObject(9, 0);
    }
    
    public int getRotation() {
        return this.getDataWatcher().getWatchableObjectByte(9);
    }
    
    @Override
    public void onBroken(final Entity lIIlIlIIIlIIll) {
        this.func_146065_b(lIIlIlIIIlIIll, true);
    }
    
    private void func_174864_a(ItemStack lIIlIIlllIlIlI, final boolean lIIlIIlllIllII) {
        if (lIIlIIlllIlIlI != null) {
            lIIlIIlllIlIlI = lIIlIIlllIlIlI.copy();
            lIIlIIlllIlIlI.stackSize = 1;
            lIIlIIlllIlIlI.setItemFrame(this);
        }
        this.getDataWatcher().updateObject(8, lIIlIIlllIlIlI);
        this.getDataWatcher().setObjectWatched(8);
        if (lIIlIIlllIllII && this.field_174861_a != null) {
            this.worldObj.updateComparatorOutputLevel(this.field_174861_a, Blocks.air);
        }
    }
    
    public EntityItemFrame(final World lIIlIlIIllIlll, final BlockPos lIIlIlIIllIIlI, final EnumFacing lIIlIlIIllIIIl) {
        super(lIIlIlIIllIlll, lIIlIlIIllIIlI);
        this.itemDropChance = 1.0f;
        this.func_174859_a(lIIlIlIIllIIIl);
    }
    
    public ItemStack getDisplayedItem() {
        return this.getDataWatcher().getWatchableObjectItemStack(8);
    }
    
    public void setItemRotation(final int lIIlIIlllIIIlI) {
        this.func_174865_a(lIIlIIlllIIIlI, true);
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lIIlIlIIIlllIl) {
        double lIIlIlIIIlllII = 16.0;
        lIIlIlIIIlllII *= 64.0 * this.renderDistanceWeight;
        return lIIlIlIIIlllIl < lIIlIlIIIlllII * lIIlIlIIIlllII;
    }
    
    public void setDisplayedItem(final ItemStack lIIlIIllllIlII) {
        this.func_174864_a(lIIlIIllllIlII, true);
    }
    
    @Override
    public float getCollisionBorderSize() {
        return 0.0f;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lIIlIlIIlIIlIl, final float lIIlIlIIlIIlII) {
        if (this.func_180431_b(lIIlIlIIlIIlIl)) {
            return false;
        }
        if (!lIIlIlIIlIIlIl.isExplosion() && this.getDisplayedItem() != null) {
            if (!this.worldObj.isRemote) {
                this.func_146065_b(lIIlIlIIlIIlIl.getEntity(), false);
                this.setDisplayedItem(null);
            }
            return true;
        }
        return super.attackEntityFrom(lIIlIlIIlIIlIl, lIIlIlIIlIIlII);
    }
    
    @Override
    public boolean interactFirst(final EntityPlayer lIIlIIllIIIIll) {
        if (this.getDisplayedItem() == null) {
            final ItemStack lIIlIIllIIIIlI = lIIlIIllIIIIll.getHeldItem();
            if (lIIlIIllIIIIlI != null && !this.worldObj.isRemote) {
                this.setDisplayedItem(lIIlIIllIIIIlI);
                if (!lIIlIIllIIIIll.capabilities.isCreativeMode) {
                    final ItemStack itemStack = lIIlIIllIIIIlI;
                    if (--itemStack.stackSize <= 0) {
                        lIIlIIllIIIIll.inventory.setInventorySlotContents(lIIlIIllIIIIll.inventory.currentItem, null);
                    }
                }
            }
        }
        else if (!this.worldObj.isRemote) {
            this.setItemRotation(this.getRotation() + 1);
        }
        return true;
    }
    
    private void func_174865_a(final int lIIlIIllIllIII, final boolean lIIlIIllIlIlll) {
        this.getDataWatcher().updateObject(9, (byte)(lIIlIIllIllIII % 8));
        if (lIIlIIllIlIlll && this.field_174861_a != null) {
            this.worldObj.updateComparatorOutputLevel(this.field_174861_a, Blocks.air);
        }
    }
    
    static {
        __OBFID = "CL_00001547";
    }
    
    @Override
    public int getWidthPixels() {
        return 12;
    }
    
    public void func_146065_b(final Entity lIIlIlIIIIllII, final boolean lIIlIlIIIIIllI) {
        if (this.worldObj.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
            ItemStack lIIlIlIIIIlIlI = this.getDisplayedItem();
            if (lIIlIlIIIIllII instanceof EntityPlayer) {
                final EntityPlayer lIIlIlIIIIlIIl = (EntityPlayer)lIIlIlIIIIllII;
                if (lIIlIlIIIIlIIl.capabilities.isCreativeMode) {
                    this.removeFrameFromMap(lIIlIlIIIIlIlI);
                    return;
                }
            }
            if (lIIlIlIIIIIllI) {
                this.entityDropItem(new ItemStack(Items.item_frame), 0.0f);
            }
            if (lIIlIlIIIIlIlI != null && this.rand.nextFloat() < this.itemDropChance) {
                lIIlIlIIIIlIlI = lIIlIlIIIIlIlI.copy();
                this.removeFrameFromMap(lIIlIlIIIIlIlI);
                this.entityDropItem(lIIlIlIIIIlIlI, 0.0f);
            }
        }
    }
    
    public EntityItemFrame(final World lIIlIlIIllllIl) {
        super(lIIlIlIIllllIl);
        this.itemDropChance = 1.0f;
    }
}
