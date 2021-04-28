package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.ai.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;

public class EntitySheep extends EntityAnimal
{
    private /* synthetic */ EntityAIEatGrass entityAIEatGrass;
    private static final /* synthetic */ Map field_175514_bm;
    private final /* synthetic */ InventoryCrafting inventoryCrafting;
    private /* synthetic */ int sheepTimer;
    
    @Override
    public void onLivingUpdate() {
        if (this.worldObj.isRemote) {
            this.sheepTimer = Math.max(0, this.sheepTimer - 1);
        }
        super.onLivingUpdate();
    }
    
    @Override
    public boolean interact(final EntityPlayer lllllllllllllllIIIIIllIIlIlIlIll) {
        final ItemStack lllllllllllllllIIIIIllIIlIlIlIlI = lllllllllllllllIIIIIllIIlIlIlIll.inventory.getCurrentItem();
        if (lllllllllllllllIIIIIllIIlIlIlIlI != null && lllllllllllllllIIIIIllIIlIlIlIlI.getItem() == Items.shears && !this.getSheared() && !this.isChild()) {
            if (!this.worldObj.isRemote) {
                this.setSheared(true);
                for (int lllllllllllllllIIIIIllIIlIlIlIIl = 1 + this.rand.nextInt(3), lllllllllllllllIIIIIllIIlIlIlIII = 0; lllllllllllllllIIIIIllIIlIlIlIII < lllllllllllllllIIIIIllIIlIlIlIIl; ++lllllllllllllllIIIIIllIIlIlIlIII) {
                    final EntityItem entityDropItem;
                    final EntityItem lllllllllllllllIIIIIllIIlIlIIlll = entityDropItem = this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, this.func_175509_cj().func_176765_a()), 1.0f);
                    entityDropItem.motionY += this.rand.nextFloat() * 0.05f;
                    final EntityItem entityItem = lllllllllllllllIIIIIllIIlIlIIlll;
                    entityItem.motionX += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f;
                    final EntityItem entityItem2 = lllllllllllllllIIIIIllIIlIlIIlll;
                    entityItem2.motionZ += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f;
                }
            }
            lllllllllllllllIIIIIllIIlIlIlIlI.damageItem(1, lllllllllllllllIIIIIllIIlIlIlIll);
            this.playSound("mob.sheep.shear", 1.0f, 1.0f);
        }
        return super.interact(lllllllllllllllIIIIIllIIlIlIlIll);
    }
    
    private EnumDyeColor func_175511_a(final EntityAnimal lllllllllllllllIIIIIllIIIlIIlllI, final EntityAnimal lllllllllllllllIIIIIllIIIlIIllIl) {
        final int lllllllllllllllIIIIIllIIIlIIllII = ((EntitySheep)lllllllllllllllIIIIIllIIIlIIlllI).func_175509_cj().getDyeColorDamage();
        final int lllllllllllllllIIIIIllIIIlIIlIll = ((EntitySheep)lllllllllllllllIIIIIllIIIlIIllIl).func_175509_cj().getDyeColorDamage();
        this.inventoryCrafting.getStackInSlot(0).setItemDamage(lllllllllllllllIIIIIllIIIlIIllII);
        this.inventoryCrafting.getStackInSlot(1).setItemDamage(lllllllllllllllIIIIIllIIIlIIlIll);
        final ItemStack lllllllllllllllIIIIIllIIIlIIlIlI = CraftingManager.getInstance().findMatchingRecipe(this.inventoryCrafting, ((EntitySheep)lllllllllllllllIIIIIllIIIlIIlllI).worldObj);
        int lllllllllllllllIIIIIllIIIlIIlIII = 0;
        if (lllllllllllllllIIIIIllIIIlIIlIlI != null && lllllllllllllllIIIIIllIIIlIIlIlI.getItem() == Items.dye) {
            final int lllllllllllllllIIIIIllIIIlIIlIIl = lllllllllllllllIIIIIllIIIlIIlIlI.getMetadata();
        }
        else {
            lllllllllllllllIIIIIllIIIlIIlIII = (this.worldObj.rand.nextBoolean() ? lllllllllllllllIIIIIllIIIlIIllII : lllllllllllllllIIIIIllIIIlIIlIll);
        }
        return EnumDyeColor.func_176766_a(lllllllllllllllIIIIIllIIIlIIlIII);
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.sheep.say";
    }
    
    @Override
    protected void func_180429_a(final BlockPos lllllllllllllllIIIIIllIIlIIIllll, final Block lllllllllllllllIIIIIllIIlIIIlllI) {
        this.playSound("mob.sheep.step", 0.15f, 1.0f);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513);
    }
    
    @Override
    public EntityAgeable createChild(final EntityAgeable lllllllllllllllIIIIIllIIIIlllIII) {
        return this.func_180491_b(lllllllllllllllIIIIIllIIIIlllIII);
    }
    
    public EntitySheep func_180491_b(final EntityAgeable lllllllllllllllIIIIIllIIIllIlIIl) {
        final EntitySheep lllllllllllllllIIIIIllIIIllIlIII = (EntitySheep)lllllllllllllllIIIIIllIIIllIlIIl;
        final EntitySheep lllllllllllllllIIIIIllIIIllIIlll = new EntitySheep(this.worldObj);
        lllllllllllllllIIIIIllIIIllIIlll.func_175512_b(this.func_175511_a(this, lllllllllllllllIIIIIllIIIllIlIII));
        return lllllllllllllllIIIIIllIIIllIIlll;
    }
    
    @Override
    protected void dropFewItems(final boolean lllllllllllllllIIIIIllIIllIlIIII, final int lllllllllllllllIIIIIllIIllIIllll) {
        if (!this.getSheared()) {
            this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, this.func_175509_cj().func_176765_a()), 0.0f);
        }
        for (int lllllllllllllllIIIIIllIIllIIlllI = this.rand.nextInt(2) + 1 + this.rand.nextInt(1 + lllllllllllllllIIIIIllIIllIIllll), lllllllllllllllIIIIIllIIllIIllIl = 0; lllllllllllllllIIIIIllIIllIIllIl < lllllllllllllllIIIIIllIIllIIlllI; ++lllllllllllllllIIIIIllIIllIIllIl) {
            if (this.isBurning()) {
                this.dropItem(Items.cooked_mutton, 1);
            }
            else {
                this.dropItem(Items.mutton, 1);
            }
        }
    }
    
    @Override
    protected void updateAITasks() {
        this.sheepTimer = this.entityAIEatGrass.getEatingGrassTimer();
        super.updateAITasks();
    }
    
    @Override
    protected Item getDropItem() {
        return Item.getItemFromBlock(Blocks.wool);
    }
    
    public float getHeadRotationPointY(final float lllllllllllllllIIIIIllIIlIllllII) {
        return (this.sheepTimer <= 0) ? 0.0f : ((this.sheepTimer >= 4 && this.sheepTimer <= 36) ? 1.0f : ((this.sheepTimer < 4) ? ((this.sheepTimer - lllllllllllllllIIIIIllIIlIllllII) / 4.0f) : (-(this.sheepTimer - 40 - lllllllllllllllIIIIIllIIlIllllII) / 4.0f)));
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIIIIllIIlIIlllIl) {
        super.writeEntityToNBT(lllllllllllllllIIIIIllIIlIIlllIl);
        lllllllllllllllIIIIIllIIlIIlllIl.setBoolean("Sheared", this.getSheared());
        lllllllllllllllIIIIIllIIlIIlllIl.setByte("Color", (byte)this.func_175509_cj().func_176765_a());
    }
    
    public void setSheared(final boolean lllllllllllllllIIIIIllIIIlllIllI) {
        final byte lllllllllllllllIIIIIllIIIllllIII = this.dataWatcher.getWatchableObjectByte(16);
        if (lllllllllllllllIIIIIllIIIlllIllI) {
            this.dataWatcher.updateObject(16, (byte)(lllllllllllllllIIIIIllIIIllllIII | 0x10));
        }
        else {
            this.dataWatcher.updateObject(16, (byte)(lllllllllllllllIIIIIllIIIllllIII & 0xFFFFFFEF));
        }
    }
    
    public EnumDyeColor func_175509_cj() {
        return EnumDyeColor.func_176764_b(this.dataWatcher.getWatchableObjectByte(16) & 0xF);
    }
    
    @Override
    public void handleHealthUpdate(final byte lllllllllllllllIIIIIllIIllIIIIlI) {
        if (lllllllllllllllIIIIIllIIllIIIIlI == 10) {
            this.sheepTimer = 40;
        }
        else {
            super.handleHealthUpdate(lllllllllllllllIIIIIllIIllIIIIlI);
        }
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.sheep.say";
    }
    
    public EntitySheep(final World lllllllllllllllIIIIIllIIlllIIlII) {
        super(lllllllllllllllIIIIIllIIlllIIlII);
        this.inventoryCrafting = new InventoryCrafting(new Container() {
            static {
                __OBFID = "CL_00001649";
            }
            
            @Override
            public boolean canInteractWith(final EntityPlayer lllllllllllllllIlIIIllllIIlllIIl) {
                return false;
            }
        }, 2, 1);
        this.entityAIEatGrass = new EntityAIEatGrass(this);
        this.setSize(0.9f, 1.3f);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0));
        this.tasks.addTask(3, new EntityAITempt(this, 1.1, Items.wheat, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1));
        this.tasks.addTask(5, this.entityAIEatGrass);
        this.tasks.addTask(6, new EntityAIWander(this, 1.0));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.inventoryCrafting.setInventorySlotContents(0, new ItemStack(Items.dye, 1, 0));
        this.inventoryCrafting.setInventorySlotContents(1, new ItemStack(Items.dye, 1, 0));
    }
    
    static {
        __OBFID = "CL_00001648";
        (field_175514_bm = Maps.newEnumMap((Class)EnumDyeColor.class)).put(EnumDyeColor.WHITE, new float[] { 1.0f, 1.0f, 1.0f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.ORANGE, new float[] { 0.85f, 0.5f, 0.2f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.MAGENTA, new float[] { 0.7f, 0.3f, 0.85f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.LIGHT_BLUE, new float[] { 0.4f, 0.6f, 0.85f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.YELLOW, new float[] { 0.9f, 0.9f, 0.2f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.LIME, new float[] { 0.5f, 0.8f, 0.1f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.PINK, new float[] { 0.95f, 0.5f, 0.65f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.GRAY, new float[] { 0.3f, 0.3f, 0.3f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.SILVER, new float[] { 0.6f, 0.6f, 0.6f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.CYAN, new float[] { 0.3f, 0.5f, 0.6f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.PURPLE, new float[] { 0.5f, 0.25f, 0.7f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.BLUE, new float[] { 0.2f, 0.3f, 0.7f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.BROWN, new float[] { 0.4f, 0.3f, 0.2f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.GREEN, new float[] { 0.4f, 0.5f, 0.2f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.RED, new float[] { 0.6f, 0.2f, 0.2f });
        EntitySheep.field_175514_bm.put(EnumDyeColor.BLACK, new float[] { 0.1f, 0.1f, 0.1f });
    }
    
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance lllllllllllllllIIIIIllIIIlIllIll, IEntityLivingData lllllllllllllllIIIIIllIIIlIlIlll) {
        lllllllllllllllIIIIIllIIIlIlIlll = super.func_180482_a(lllllllllllllllIIIIIllIIIlIllIll, lllllllllllllllIIIIIllIIIlIlIlll);
        this.func_175512_b(func_175510_a(this.worldObj.rand));
        return lllllllllllllllIIIIIllIIIlIlIlll;
    }
    
    public void func_175512_b(final EnumDyeColor lllllllllllllllIIIIIllIIlIIIIIlI) {
        final byte lllllllllllllllIIIIIllIIlIIIIlII = this.dataWatcher.getWatchableObjectByte(16);
        this.dataWatcher.updateObject(16, (byte)((lllllllllllllllIIIIIllIIlIIIIlII & 0xF0) | (lllllllllllllllIIIIIllIIlIIIIIlI.func_176765_a() & 0xF)));
    }
    
    @Override
    public float getEyeHeight() {
        return 0.95f * this.height;
    }
    
    public static EnumDyeColor func_175510_a(final Random lllllllllllllllIIIIIllIIIlllIIII) {
        final int lllllllllllllllIIIIIllIIIlllIIIl = lllllllllllllllIIIIIllIIIlllIIII.nextInt(100);
        return (lllllllllllllllIIIIIllIIIlllIIIl < 5) ? EnumDyeColor.BLACK : ((lllllllllllllllIIIIIllIIIlllIIIl < 10) ? EnumDyeColor.GRAY : ((lllllllllllllllIIIIIllIIIlllIIIl < 15) ? EnumDyeColor.SILVER : ((lllllllllllllllIIIIIllIIIlllIIIl < 18) ? EnumDyeColor.BROWN : ((lllllllllllllllIIIIIllIIIlllIIII.nextInt(500) == 0) ? EnumDyeColor.PINK : EnumDyeColor.WHITE))));
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.sheep.say";
    }
    
    public static float[] func_175513_a(final EnumDyeColor lllllllllllllllIIIIIllIIlllIlIIl) {
        return EntitySheep.field_175514_bm.get(lllllllllllllllIIIIIllIIlllIlIIl);
    }
    
    public boolean getSheared() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x10) != 0x0;
    }
    
    @Override
    public void eatGrassBonus() {
        this.setSheared(false);
        if (this.isChild()) {
            this.addGrowth(60);
        }
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
    
    public float getHeadRotationAngleX(final float lllllllllllllllIIIIIllIIlIllIlII) {
        if (this.sheepTimer > 4 && this.sheepTimer <= 36) {
            final float lllllllllllllllIIIIIllIIlIllIllI = (this.sheepTimer - 4 - lllllllllllllllIIIIIllIIlIllIlII) / 32.0f;
            return 0.62831855f + 0.2199115f * MathHelper.sin(lllllllllllllllIIIIIllIIlIllIllI * 28.7f);
        }
        return (this.sheepTimer > 0) ? 0.62831855f : (this.rotationPitch / 57.295776f);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIIIIllIIlIIlIlIl) {
        super.readEntityFromNBT(lllllllllllllllIIIIIllIIlIIlIlIl);
        this.setSheared(lllllllllllllllIIIIIllIIlIIlIlIl.getBoolean("Sheared"));
        this.func_175512_b(EnumDyeColor.func_176764_b(lllllllllllllllIIIIIllIIlIIlIlIl.getByte("Color")));
    }
}
