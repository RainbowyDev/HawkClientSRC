package net.minecraft.tileentity;

import net.minecraft.server.gui.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;
import net.minecraft.potion.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.stats.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;

public class TileEntityBeacon extends TileEntityLockable implements IUpdatePlayerListBox, IInventory
{
    private /* synthetic */ float field_146014_j;
    private /* synthetic */ ItemStack payment;
    private /* synthetic */ boolean isComplete;
    private /* synthetic */ int primaryEffect;
    private /* synthetic */ int secondaryEffect;
    private /* synthetic */ int levels;
    private final /* synthetic */ List field_174909_f;
    private /* synthetic */ long field_146016_i;
    private /* synthetic */ String field_146008_p;
    
    public float shouldBeamRender() {
        if (!this.isComplete) {
            return 0.0f;
        }
        final int lllllllIIIIllIl = (int)(this.worldObj.getTotalWorldTime() - this.field_146016_i);
        this.field_146016_i = this.worldObj.getTotalWorldTime();
        if (lllllllIIIIllIl > 1) {
            this.field_146014_j -= lllllllIIIIllIl / 40.0f;
            if (this.field_146014_j < 0.0f) {
                this.field_146014_j = 0.0f;
            }
        }
        this.field_146014_j += 0.025f;
        if (this.field_146014_j > 1.0f) {
            this.field_146014_j = 1.0f;
        }
        return this.field_146014_j;
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllIlIlIIlll, final ItemStack llllllIlIlIIllI) {
        return llllllIlIlIIllI.getItem() == Items.emerald || llllllIlIlIIllI.getItem() == Items.diamond || llllllIlIlIIllI.getItem() == Items.gold_ingot || llllllIlIlIIllI.getItem() == Items.iron_ingot;
    }
    
    static {
        __OBFID = "CL_00000339";
        effectsList = new Potion[][] { { Potion.moveSpeed, Potion.digSpeed }, { Potion.resistance, Potion.jump }, { Potion.damageBoost }, { Potion.regeneration } };
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllIlIllIIlI) {
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllIlllIIlll, final int llllllIlllIIllI) {
        if (llllllIlllIIlll != 0 || this.payment == null) {
            return null;
        }
        if (llllllIlllIIllI >= this.payment.stackSize) {
            final ItemStack llllllIlllIlIIl = this.payment;
            this.payment = null;
            return llllllIlllIlIIl;
        }
        final ItemStack payment = this.payment;
        payment.stackSize -= llllllIlllIIllI;
        return new ItemStack(this.payment.getItem(), llllllIlllIIllI, this.payment.getMetadata());
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(final int llllllIllIlllIl) {
        if (llllllIllIlllIl == 0 && this.payment != null) {
            final ItemStack llllllIllIlllll = this.payment;
            this.payment = null;
            return llllllIllIlllll;
        }
        return null;
    }
    
    public List func_174907_n() {
        return this.field_174909_f;
    }
    
    public void func_145999_a(final String llllllIllIIIlll) {
        this.field_146008_p = llllllIllIIIlll;
    }
    
    public TileEntityBeacon() {
        this.field_174909_f = Lists.newArrayList();
        this.levels = -1;
    }
    
    @Override
    public void update() {
        if (this.worldObj.getTotalWorldTime() % 80L == 0L) {
            this.func_174908_m();
        }
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllIIIIIIII) {
        super.readFromNBT(lllllllIIIIIIII);
        this.primaryEffect = lllllllIIIIIIII.getInteger("Primary");
        this.secondaryEffect = lllllllIIIIIIII.getInteger("Secondary");
        this.levels = lllllllIIIIIIII.getInteger("Levels");
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 1;
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_146008_p : "container.beacon";
    }
    
    @Override
    public void setField(final int llllllIIllllIll, final int llllllIIlllllIl) {
        switch (llllllIIllllIll) {
            case 0: {
                this.levels = llllllIIlllllIl;
                break;
            }
            case 1: {
                this.primaryEffect = llllllIIlllllIl;
                break;
            }
            case 2: {
                this.secondaryEffect = llllllIIlllllIl;
                break;
            }
        }
    }
    
    @Override
    public void clearInventory() {
        this.payment = null;
    }
    
    @Override
    public int getField(final int llllllIlIIIIlll) {
        switch (llllllIlIIIIlll) {
            case 0: {
                return this.levels;
            }
            case 1: {
                return this.primaryEffect;
            }
            case 2: {
                return this.secondaryEffect;
            }
            default: {
                return 0;
            }
        }
    }
    
    @Override
    public void setInventorySlotContents(final int llllllIllIlIlll, final ItemStack llllllIllIlIllI) {
        if (llllllIllIlIlll == 0) {
            this.payment = llllllIllIlIllI;
        }
    }
    
    @Override
    public boolean receiveClientEvent(final int llllllIIllIlllI, final int llllllIIlllIIII) {
        if (llllllIIllIlllI == 1) {
            this.func_174908_m();
            return true;
        }
        return super.receiveClientEvent(llllllIIllIlllI, llllllIIlllIIII);
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllIlllllIII) {
        super.writeToNBT(llllllIlllllIII);
        llllllIlllllIII.setInteger("Primary", this.primaryEffect);
        llllllIlllllIII.setInteger("Secondary", this.secondaryEffect);
        llllllIlllllIII.setInteger("Levels", this.levels);
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllIlIlIllIl) {
    }
    
    private void func_146000_x() {
        if (this.isComplete && this.levels > 0 && !this.worldObj.isRemote && this.primaryEffect > 0) {
            final double lllllllIlIlIlII = this.levels * 10 + 10;
            byte lllllllIlIlIIll = 0;
            if (this.levels >= 4 && this.primaryEffect == this.secondaryEffect) {
                lllllllIlIlIIll = 1;
            }
            final int lllllllIlIlIIlI = this.pos.getX();
            final int lllllllIlIlIIIl = this.pos.getY();
            final int lllllllIlIlIIII = this.pos.getZ();
            final AxisAlignedBB lllllllIlIIllll = new AxisAlignedBB(lllllllIlIlIIlI, lllllllIlIlIIIl, lllllllIlIlIIII, lllllllIlIlIIlI + 1, lllllllIlIlIIIl + 1, lllllllIlIlIIII + 1).expand(lllllllIlIlIlII, lllllllIlIlIlII, lllllllIlIlIlII).addCoord(0.0, this.worldObj.getHeight(), 0.0);
            final List lllllllIlIIlllI = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, lllllllIlIIllll);
            for (final EntityPlayer lllllllIlIIllII : lllllllIlIIlllI) {
                lllllllIlIIllII.addPotionEffect(new PotionEffect(this.primaryEffect, 180, lllllllIlIlIIll, true, true));
            }
            if (this.levels >= 4 && this.primaryEffect != this.secondaryEffect && this.secondaryEffect > 0) {
                for (final EntityPlayer lllllllIlIIlIll : lllllllIlIIlllI) {
                    lllllllIlIIlIll.addPotionEffect(new PotionEffect(this.secondaryEffect, 180, 0, true, true));
                }
            }
        }
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllIlIIlIllI, final EntityPlayer llllllIlIIllIlI) {
        return new ContainerBeacon(llllllIlIIlIllI, this);
    }
    
    private void func_146003_y() {
        final int lllllllIIllIIlI = this.levels;
        final int lllllllIIllIIIl = this.pos.getX();
        final int lllllllIIllIIII = this.pos.getY();
        final int lllllllIIlIllll = this.pos.getZ();
        this.levels = 0;
        this.field_174909_f.clear();
        this.isComplete = true;
        BeamSegment lllllllIIlIlllI = new BeamSegment(EntitySheep.func_175513_a(EnumDyeColor.WHITE));
        this.field_174909_f.add(lllllllIIlIlllI);
        boolean lllllllIIlIllIl = true;
        for (int lllllllIIlIllII = lllllllIIllIIII + 1; lllllllIIlIllII < this.worldObj.getActualHeight(); ++lllllllIIlIllII) {
            final BlockPos lllllllIIlIlIll = new BlockPos(lllllllIIllIIIl, lllllllIIlIllII, lllllllIIlIllll);
            final IBlockState lllllllIIlIlIlI = this.worldObj.getBlockState(lllllllIIlIlIll);
            float[] lllllllIIlIlIII = null;
            if (lllllllIIlIlIlI.getBlock() == Blocks.stained_glass) {
                final float[] lllllllIIlIlIIl = EntitySheep.func_175513_a((EnumDyeColor)lllllllIIlIlIlI.getValue(BlockStainedGlass.field_176547_a));
            }
            else if (lllllllIIlIlIlI.getBlock() != Blocks.stained_glass_pane) {
                if (lllllllIIlIlIlI.getBlock().getLightOpacity() >= 15) {
                    this.isComplete = false;
                    this.field_174909_f.clear();
                    break;
                }
                lllllllIIlIlllI.func_177262_a();
                continue;
            }
            else {
                lllllllIIlIlIII = EntitySheep.func_175513_a((EnumDyeColor)lllllllIIlIlIlI.getValue(BlockStainedGlassPane.field_176245_a));
            }
            if (!lllllllIIlIllIl) {
                lllllllIIlIlIII = new float[] { (lllllllIIlIlllI.func_177263_b()[0] + lllllllIIlIlIII[0]) / 2.0f, (lllllllIIlIlllI.func_177263_b()[1] + lllllllIIlIlIII[1]) / 2.0f, (lllllllIIlIlllI.func_177263_b()[2] + lllllllIIlIlIII[2]) / 2.0f };
            }
            if (Arrays.equals(lllllllIIlIlIII, lllllllIIlIlllI.func_177263_b())) {
                lllllllIIlIlllI.func_177262_a();
            }
            else {
                lllllllIIlIlllI = new BeamSegment(lllllllIIlIlIII);
                this.field_174909_f.add(lllllllIIlIlllI);
            }
            lllllllIIlIllIl = false;
        }
        if (this.isComplete) {
            for (int lllllllIIlIllII = 1; lllllllIIlIllII <= 4; this.levels = lllllllIIlIllII++) {
                final int lllllllIIlIIlll = lllllllIIllIIII - lllllllIIlIllII;
                if (lllllllIIlIIlll < 0) {
                    break;
                }
                boolean lllllllIIlIIllI = true;
                for (int lllllllIIlIIlIl = lllllllIIllIIIl - lllllllIIlIllII; lllllllIIlIIlIl <= lllllllIIllIIIl + lllllllIIlIllII && lllllllIIlIIllI; ++lllllllIIlIIlIl) {
                    for (int lllllllIIlIIlII = lllllllIIlIllll - lllllllIIlIllII; lllllllIIlIIlII <= lllllllIIlIllll + lllllllIIlIllII; ++lllllllIIlIIlII) {
                        final Block lllllllIIlIIIll = this.worldObj.getBlockState(new BlockPos(lllllllIIlIIlIl, lllllllIIlIIlll, lllllllIIlIIlII)).getBlock();
                        if (lllllllIIlIIIll != Blocks.emerald_block && lllllllIIlIIIll != Blocks.gold_block && lllllllIIlIIIll != Blocks.diamond_block && lllllllIIlIIIll != Blocks.iron_block) {
                            lllllllIIlIIllI = false;
                            break;
                        }
                    }
                }
                if (!lllllllIIlIIllI) {
                    break;
                }
            }
            if (this.levels == 0) {
                this.isComplete = false;
            }
        }
        if (!this.worldObj.isRemote && this.levels == 4 && lllllllIIllIIlI < this.levels) {
            for (final EntityPlayer lllllllIIlIIIIl : this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(lllllllIIllIIIl, lllllllIIllIIII, lllllllIIlIllll, lllllllIIllIIIl, lllllllIIllIIII - 4, lllllllIIlIllll).expand(10.0, 5.0, 10.0))) {
                lllllllIIlIIIIl.triggerAchievement(AchievementList.fullBeacon);
            }
        }
    }
    
    @Override
    public boolean hasCustomName() {
        return this.field_146008_p != null && this.field_146008_p.length() > 0;
    }
    
    @Override
    public int getSizeInventory() {
        return 1;
    }
    
    @Override
    public int getFieldCount() {
        return 3;
    }
    
    @Override
    public boolean isUseableByPlayer(final EntityPlayer llllllIlIlllIll) {
        return this.worldObj.getTileEntity(this.pos) == this && llllllIlIlllIll.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public Packet getDescriptionPacket() {
        final NBTTagCompound lllllllIIIIIlll = new NBTTagCompound();
        this.writeToNBT(lllllllIIIIIlll);
        return new S35PacketUpdateTileEntity(this.pos, 3, lllllllIIIIIlll);
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllIllllIIll) {
        return (llllllIllllIIll == 0) ? this.payment : null;
    }
    
    public void func_174908_m() {
        this.func_146003_y();
        this.func_146000_x();
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:beacon";
    }
    
    @Override
    public double getMaxRenderDistanceSquared() {
        return 65536.0;
    }
    
    public static class BeamSegment
    {
        private /* synthetic */ int field_177265_b;
        private final /* synthetic */ float[] field_177266_a;
        
        public BeamSegment(final float[] llllllllllllllIIIIIlIIIIllIllIII) {
            this.field_177266_a = llllllllllllllIIIIIlIIIIllIllIII;
            this.field_177265_b = 1;
        }
        
        public int func_177264_c() {
            return this.field_177265_b;
        }
        
        protected void func_177262_a() {
            ++this.field_177265_b;
        }
        
        public float[] func_177263_b() {
            return this.field_177266_a;
        }
        
        static {
            __OBFID = "CL_00002042";
        }
    }
}
