package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.village.*;
import net.minecraft.entity.item.*;
import net.minecraft.pathfinding.*;
import com.google.common.base.*;
import net.minecraft.nbt.*;
import net.minecraft.stats.*;
import net.minecraft.potion.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.enchantment.*;

public class EntityVillager extends EntityAgeable implements IMerchant, INpc
{
    private /* synthetic */ boolean isPlaying;
    private /* synthetic */ EntityPlayer buyingPlayer;
    private /* synthetic */ int field_175563_bv;
    private /* synthetic */ int timeUntilReset;
    /* synthetic */ Village villageObj;
    private /* synthetic */ boolean isLookingForHome;
    private /* synthetic */ InventoryBasic field_175560_bz;
    private /* synthetic */ int wealth;
    private /* synthetic */ MerchantRecipeList buyingList;
    private /* synthetic */ boolean field_175565_bs;
    private /* synthetic */ int field_175562_bw;
    private /* synthetic */ int randomTickDivider;
    private /* synthetic */ boolean isMating;
    private /* synthetic */ boolean field_175564_by;
    private /* synthetic */ boolean needsInitilization;
    private /* synthetic */ String lastBuyingPlayer;
    private static final /* synthetic */ ITradeList[][][][] field_175561_bA;
    
    static {
        __OBFID = "CL_00001707";
        field_175561_bA = new ITradeList[][][][] { { { { new EmeraldForItems(Items.wheat, new PriceInfo(18, 22)), new EmeraldForItems(Items.potato, new PriceInfo(15, 19)), new EmeraldForItems(Items.carrot, new PriceInfo(15, 19)), new ListItemForEmeralds(Items.bread, new PriceInfo(-4, -2)) }, { new EmeraldForItems(Item.getItemFromBlock(Blocks.pumpkin), new PriceInfo(8, 13)), new ListItemForEmeralds(Items.pumpkin_pie, new PriceInfo(-3, -2)) }, { new EmeraldForItems(Item.getItemFromBlock(Blocks.melon_block), new PriceInfo(7, 12)), new ListItemForEmeralds(Items.apple, new PriceInfo(-5, -7)) }, { new ListItemForEmeralds(Items.cookie, new PriceInfo(-6, -10)), new ListItemForEmeralds(Items.cake, new PriceInfo(1, 1)) } }, { { new EmeraldForItems(Items.string, new PriceInfo(15, 20)), new EmeraldForItems(Items.coal, new PriceInfo(16, 24)), new ItemAndEmeraldToItem(Items.fish, new PriceInfo(6, 6), Items.cooked_fish, new PriceInfo(6, 6)) }, { new ListEnchantedItemForEmeralds(Items.fishing_rod, new PriceInfo(7, 8)) } }, { { new EmeraldForItems(Item.getItemFromBlock(Blocks.wool), new PriceInfo(16, 22)), new ListItemForEmeralds(Items.shears, new PriceInfo(3, 4)) }, { new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 0), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 1), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 2), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 3), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 4), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 5), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 6), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 7), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 8), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 9), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 10), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 11), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 12), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 13), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 14), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 15), new PriceInfo(1, 2)) } }, { { new EmeraldForItems(Items.string, new PriceInfo(15, 20)), new ListItemForEmeralds(Items.arrow, new PriceInfo(-12, -8)) }, { new ListItemForEmeralds(Items.bow, new PriceInfo(2, 3)), new ItemAndEmeraldToItem(Item.getItemFromBlock(Blocks.gravel), new PriceInfo(10, 10), Items.flint, new PriceInfo(6, 10)) } } }, { { { new EmeraldForItems(Items.paper, new PriceInfo(24, 36)), new ListEnchantedBookForEmeralds() }, { new EmeraldForItems(Items.book, new PriceInfo(8, 10)), new ListItemForEmeralds(Items.compass, new PriceInfo(10, 12)), new ListItemForEmeralds(Item.getItemFromBlock(Blocks.bookshelf), new PriceInfo(3, 4)) }, { new EmeraldForItems(Items.written_book, new PriceInfo(2, 2)), new ListItemForEmeralds(Items.clock, new PriceInfo(10, 12)), new ListItemForEmeralds(Item.getItemFromBlock(Blocks.glass), new PriceInfo(-5, -3)) }, { new ListEnchantedBookForEmeralds() }, { new ListEnchantedBookForEmeralds() }, { new ListItemForEmeralds(Items.name_tag, new PriceInfo(20, 22)) } } }, { { { new EmeraldForItems(Items.rotten_flesh, new PriceInfo(36, 40)), new EmeraldForItems(Items.gold_ingot, new PriceInfo(8, 10)) }, { new ListItemForEmeralds(Items.redstone, new PriceInfo(-4, -1)), new ListItemForEmeralds(new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeColorDamage()), new PriceInfo(-2, -1)) }, { new ListItemForEmeralds(Items.ender_eye, new PriceInfo(7, 11)), new ListItemForEmeralds(Item.getItemFromBlock(Blocks.glowstone), new PriceInfo(-3, -1)) }, { new ListItemForEmeralds(Items.experience_bottle, new PriceInfo(3, 11)) } } }, { { { new EmeraldForItems(Items.coal, new PriceInfo(16, 24)), new ListItemForEmeralds(Items.iron_helmet, new PriceInfo(4, 6)) }, { new EmeraldForItems(Items.iron_ingot, new PriceInfo(7, 9)), new ListItemForEmeralds(Items.iron_chestplate, new PriceInfo(10, 14)) }, { new EmeraldForItems(Items.diamond, new PriceInfo(3, 4)), new ListEnchantedItemForEmeralds(Items.diamond_chestplate, new PriceInfo(16, 19)) }, { new ListItemForEmeralds(Items.chainmail_boots, new PriceInfo(5, 7)), new ListItemForEmeralds(Items.chainmail_leggings, new PriceInfo(9, 11)), new ListItemForEmeralds(Items.chainmail_helmet, new PriceInfo(5, 7)), new ListItemForEmeralds(Items.chainmail_chestplate, new PriceInfo(11, 15)) } }, { { new EmeraldForItems(Items.coal, new PriceInfo(16, 24)), new ListItemForEmeralds(Items.iron_axe, new PriceInfo(6, 8)) }, { new EmeraldForItems(Items.iron_ingot, new PriceInfo(7, 9)), new ListEnchantedItemForEmeralds(Items.iron_sword, new PriceInfo(9, 10)) }, { new EmeraldForItems(Items.diamond, new PriceInfo(3, 4)), new ListEnchantedItemForEmeralds(Items.diamond_sword, new PriceInfo(12, 15)), new ListEnchantedItemForEmeralds(Items.diamond_axe, new PriceInfo(9, 12)) } }, { { new EmeraldForItems(Items.coal, new PriceInfo(16, 24)), new ListEnchantedItemForEmeralds(Items.iron_shovel, new PriceInfo(5, 7)) }, { new EmeraldForItems(Items.iron_ingot, new PriceInfo(7, 9)), new ListEnchantedItemForEmeralds(Items.iron_pickaxe, new PriceInfo(9, 11)) }, { new EmeraldForItems(Items.diamond, new PriceInfo(3, 4)), new ListEnchantedItemForEmeralds(Items.diamond_pickaxe, new PriceInfo(12, 15)) } } }, { { { new EmeraldForItems(Items.porkchop, new PriceInfo(14, 18)), new EmeraldForItems(Items.chicken, new PriceInfo(14, 18)) }, { new EmeraldForItems(Items.coal, new PriceInfo(16, 24)), new ListItemForEmeralds(Items.cooked_porkchop, new PriceInfo(-7, -5)), new ListItemForEmeralds(Items.cooked_chicken, new PriceInfo(-8, -6)) } }, { { new EmeraldForItems(Items.leather, new PriceInfo(9, 12)), new ListItemForEmeralds(Items.leather_leggings, new PriceInfo(2, 4)) }, { new ListEnchantedItemForEmeralds(Items.leather_chestplate, new PriceInfo(7, 12)) }, { new ListItemForEmeralds(Items.saddle, new PriceInfo(8, 10)) } } } };
    }
    
    @Override
    public EntityPlayer getCustomer() {
        return this.buyingPlayer;
    }
    
    public InventoryBasic func_175551_co() {
        return this.field_175560_bz;
    }
    
    @Override
    protected void func_175445_a(final EntityItem llllllllllllllIIlIIllIIIIlIIIIlI) {
        final ItemStack llllllllllllllIIlIIllIIIIlIIIIIl = llllllllllllllIIlIIllIIIIlIIIIlI.getEntityItem();
        final Item llllllllllllllIIlIIllIIIIlIIIIII = llllllllllllllIIlIIllIIIIlIIIIIl.getItem();
        if (this.func_175558_a(llllllllllllllIIlIIllIIIIlIIIIII)) {
            final ItemStack llllllllllllllIIlIIllIIIIIllllll = this.field_175560_bz.func_174894_a(llllllllllllllIIlIIllIIIIlIIIIIl);
            if (llllllllllllllIIlIIllIIIIIllllll == null) {
                llllllllllllllIIlIIllIIIIlIIIIlI.setDead();
            }
            else {
                llllllllllllllIIlIIllIIIIlIIIIIl.stackSize = llllllllllllllIIlIIllIIIIIllllll.stackSize;
            }
        }
    }
    
    public void setPlaying(final boolean llllllllllllllIIlIIllIIIllllllIl) {
        this.isPlaying = llllllllllllllIIlIIllIIIllllllIl;
    }
    
    public boolean func_175553_cp() {
        return this.func_175559_s(1);
    }
    
    @Override
    public void useRecipe(final MerchantRecipe llllllllllllllIIlIIllIIIlIllllll) {
        llllllllllllllIIlIIllIIIlIllllll.incrementToolUses();
        this.livingSoundTime = -this.getTalkInterval();
        this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
        int llllllllllllllIIlIIllIIIlIlllllI = 3 + this.rand.nextInt(4);
        if (llllllllllllllIIlIIllIIIlIllllll.func_180321_e() == 1 || this.rand.nextInt(5) == 0) {
            this.timeUntilReset = 40;
            this.needsInitilization = true;
            this.field_175565_bs = true;
            if (this.buyingPlayer != null) {
                this.lastBuyingPlayer = this.buyingPlayer.getName();
            }
            else {
                this.lastBuyingPlayer = null;
            }
            llllllllllllllIIlIIllIIIlIlllllI += 5;
        }
        if (llllllllllllllIIlIIllIIIlIllllll.getItemToBuy().getItem() == Items.emerald) {
            this.wealth += llllllllllllllIIlIIllIIIlIllllll.getItemToBuy().stackSize;
        }
        if (llllllllllllllIIlIIllIIIlIllllll.func_180322_j()) {
            this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY + 0.5, this.posZ, llllllllllllllIIlIIllIIIlIlllllI));
        }
    }
    
    private void func_175554_cu() {
        final ITradeList[][][] llllllllllllllIIlIIllIIIlIlIIlIl = EntityVillager.field_175561_bA[this.getProfession()];
        if (this.field_175563_bv != 0 && this.field_175562_bw != 0) {
            ++this.field_175562_bw;
        }
        else {
            this.field_175563_bv = this.rand.nextInt(llllllllllllllIIlIIllIIIlIlIIlIl.length) + 1;
            this.field_175562_bw = 1;
        }
        if (this.buyingList == null) {
            this.buyingList = new MerchantRecipeList();
        }
        final int llllllllllllllIIlIIllIIIlIlIIlII = this.field_175563_bv - 1;
        final int llllllllllllllIIlIIllIIIlIlIIIll = this.field_175562_bw - 1;
        final ITradeList[][] llllllllllllllIIlIIllIIIlIlIIIlI = llllllllllllllIIlIIllIIIlIlIIlIl[llllllllllllllIIlIIllIIIlIlIIlII];
        if (llllllllllllllIIlIIllIIIlIlIIIll < llllllllllllllIIlIIllIIIlIlIIIlI.length) {
            final ITradeList[] llllllllllllllIIlIIllIIIlIlIIIII;
            final ITradeList[] llllllllllllllIIlIIllIIIlIlIIIIl = llllllllllllllIIlIIllIIIlIlIIIII = llllllllllllllIIlIIllIIIlIlIIIlI[llllllllllllllIIlIIllIIIlIlIIIll];
            for (int llllllllllllllIIlIIllIIIlIIlllll = llllllllllllllIIlIIllIIIlIlIIIIl.length, llllllllllllllIIlIIllIIIlIIllllI = 0; llllllllllllllIIlIIllIIIlIIllllI < llllllllllllllIIlIIllIIIlIIlllll; ++llllllllllllllIIlIIllIIIlIIllllI) {
                final ITradeList llllllllllllllIIlIIllIIIlIIlllIl = llllllllllllllIIlIIllIIIlIlIIIII[llllllllllllllIIlIIllIIIlIIllllI];
                llllllllllllllIIlIIllIIIlIIlllIl.func_179401_a(this.buyingList, this.rand);
            }
        }
    }
    
    public EntityVillager(final World llllllllllllllIIlIIllIIlIlIllllI, final int llllllllllllllIIlIIllIIlIllIIIII) {
        super(llllllllllllllIIlIIllIIlIlIllllI);
        this.field_175560_bz = new InventoryBasic("Items", false, 8);
        this.setProfession(llllllllllllllIIlIIllIIlIllIIIII);
        this.setSize(0.6f, 1.8f);
        ((PathNavigateGround)this.getNavigator()).func_179688_b(true);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, (Predicate)new Predicate() {
            public boolean func_179530_a(final Entity lllllllllllllllIlllIIIIIIllIlIlI) {
                return lllllllllllllllIlllIIIIIIllIlIlI instanceof EntityZombie;
            }
            
            public boolean apply(final Object lllllllllllllllIlllIIIIIIllIIIll) {
                return this.func_179530_a((Entity)lllllllllllllllIlllIIIIIIllIIIll);
            }
            
            static {
                __OBFID = "CL_00002195";
            }
        }, 8.0f, 0.6, 0.6));
        this.tasks.addTask(1, new EntityAITradePlayer(this));
        this.tasks.addTask(1, new EntityAILookAtTradePlayer(this));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6));
        this.tasks.addTask(6, new EntityAIVillagerMate(this));
        this.tasks.addTask(7, new EntityAIFollowGolem(this));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0f, 1.0f));
        this.tasks.addTask(9, new EntityAIVillagerInteract(this));
        this.tasks.addTask(9, new EntityAIWander(this, 0.6));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f));
        this.setCanPickUpLoot(true);
    }
    
    public boolean func_175557_cr() {
        final boolean llllllllllllllIIlIIllIIIIIlIllII = this.getProfession() == 0;
        return llllllllllllllIIlIIllIIIIIlIllII ? (!this.func_175559_s(5)) : (!this.func_175559_s(1));
    }
    
    @Override
    public void setRecipes(final MerchantRecipeList llllllllllllllIIlIIllIIIlIIlIIIl) {
    }
    
    @Override
    protected boolean canDespawn() {
        return false;
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllIIlIIllIIIlllIIlll) {
        if (this.villageObj != null) {
            final Entity llllllllllllllIIlIIllIIIlllIlIlI = llllllllllllllIIlIIllIIIlllIIlll.getEntity();
            if (llllllllllllllIIlIIllIIIlllIlIlI != null) {
                if (llllllllllllllIIlIIllIIIlllIlIlI instanceof EntityPlayer) {
                    this.villageObj.setReputationForPlayer(llllllllllllllIIlIIllIIIlllIlIlI.getName(), -2);
                }
                else if (llllllllllllllIIlIIllIIIlllIlIlI instanceof IMob) {
                    this.villageObj.endMatingSeason();
                }
            }
            else {
                final EntityPlayer llllllllllllllIIlIIllIIIlllIlIIl = this.worldObj.getClosestPlayerToEntity(this, 16.0);
                if (llllllllllllllIIlIIllIIIlllIlIIl != null) {
                    this.villageObj.endMatingSeason();
                }
            }
        }
        super.onDeath(llllllllllllllIIlIIllIIIlllIIlll);
    }
    
    @Override
    public EntityAgeable createChild(final EntityAgeable llllllllllllllIIlIIllIIIIIIIIIII) {
        return this.func_180488_b(llllllllllllllIIlIIllIIIIIIIIIII);
    }
    
    private boolean func_175558_a(final Item llllllllllllllIIlIIllIIIIIllIlll) {
        return llllllllllllllIIlIIllIIIIIllIlll == Items.bread || llllllllllllllIIlIIllIIIIIllIlll == Items.potato || llllllllllllllIIlIIllIIIIIllIlll == Items.carrot || llllllllllllllIIlIIllIIIIIllIlll == Items.wheat || llllllllllllllIIlIIllIIIIIllIlll == Items.wheat_seeds;
    }
    
    public boolean func_175550_n(final boolean llllllllllllllIIlIIllIIIllIIllIl) {
        if (!this.field_175565_bs && llllllllllllllIIlIIllIIIllIIllIl && this.func_175553_cp()) {
            boolean llllllllllllllIIlIIllIIIllIlIIIl = false;
            for (int llllllllllllllIIlIIllIIIllIlIIII = 0; llllllllllllllIIlIIllIIIllIlIIII < this.field_175560_bz.getSizeInventory(); ++llllllllllllllIIlIIllIIIllIlIIII) {
                final ItemStack llllllllllllllIIlIIllIIIllIIllll = this.field_175560_bz.getStackInSlot(llllllllllllllIIlIIllIIIllIlIIII);
                if (llllllllllllllIIlIIllIIIllIIllll != null) {
                    if (llllllllllllllIIlIIllIIIllIIllll.getItem() == Items.bread && llllllllllllllIIlIIllIIIllIIllll.stackSize >= 3) {
                        llllllllllllllIIlIIllIIIllIlIIIl = true;
                        this.field_175560_bz.decrStackSize(llllllllllllllIIlIIllIIIllIlIIII, 3);
                    }
                    else if ((llllllllllllllIIlIIllIIIllIIllll.getItem() == Items.potato || llllllllllllllIIlIIllIIIllIIllll.getItem() == Items.carrot) && llllllllllllllIIlIIllIIIllIIllll.stackSize >= 12) {
                        llllllllllllllIIlIIllIIIllIlIIIl = true;
                        this.field_175560_bz.decrStackSize(llllllllllllllIIlIIllIIIllIlIIII, 12);
                    }
                }
                if (llllllllllllllIIlIIllIIIllIlIIIl) {
                    this.worldObj.setEntityState(this, (byte)18);
                    this.field_175565_bs = true;
                    break;
                }
            }
        }
        return this.field_175565_bs;
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.villager.death";
    }
    
    public boolean isTrading() {
        return this.buyingPlayer != null;
    }
    
    private boolean func_175559_s(final int llllllllllllllIIlIIllIIIIIIllllI) {
        final boolean llllllllllllllIIlIIllIIIIIlIIIlI = this.getProfession() == 0;
        for (int llllllllllllllIIlIIllIIIIIlIIIIl = 0; llllllllllllllIIlIIllIIIIIlIIIIl < this.field_175560_bz.getSizeInventory(); ++llllllllllllllIIlIIllIIIIIlIIIIl) {
            final ItemStack llllllllllllllIIlIIllIIIIIlIIIII = this.field_175560_bz.getStackInSlot(llllllllllllllIIlIIllIIIIIlIIIIl);
            if (llllllllllllllIIlIIllIIIIIlIIIII != null) {
                if ((llllllllllllllIIlIIllIIIIIlIIIII.getItem() == Items.bread && llllllllllllllIIlIIllIIIIIlIIIII.stackSize >= 3 * llllllllllllllIIlIIllIIIIIIllllI) || (llllllllllllllIIlIIllIIIIIlIIIII.getItem() == Items.potato && llllllllllllllIIlIIllIIIIIlIIIII.stackSize >= 12 * llllllllllllllIIlIIllIIIIIIllllI) || (llllllllllllllIIlIIllIIIIIlIIIII.getItem() == Items.carrot && llllllllllllllIIlIIllIIIIIlIIIII.stackSize >= 12 * llllllllllllllIIlIIllIIIIIIllllI)) {
                    return true;
                }
                if (llllllllllllllIIlIIllIIIIIlIIIlI && llllllllllllllIIlIIllIIIIIlIIIII.getItem() == Items.wheat && llllllllllllllIIlIIllIIIIIlIIIII.stackSize >= 9 * llllllllllllllIIlIIllIIIIIIllllI) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean func_174820_d(final int llllllllllllllIIlIIllIIIIIIIllII, final ItemStack llllllllllllllIIlIIllIIIIIIIIlll) {
        if (super.func_174820_d(llllllllllllllIIlIIllIIIIIIIllII, llllllllllllllIIlIIllIIIIIIIIlll)) {
            return true;
        }
        final int llllllllllllllIIlIIllIIIIIIIlIlI = llllllllllllllIIlIIllIIIIIIIllII - 300;
        if (llllllllllllllIIlIIllIIIIIIIlIlI >= 0 && llllllllllllllIIlIIllIIIIIIIlIlI < this.field_175560_bz.getSizeInventory()) {
            this.field_175560_bz.setInventorySlotContents(llllllllllllllIIlIIllIIIIIIIlIlI, llllllllllllllIIlIIllIIIIIIIIlll);
            return true;
        }
        return false;
    }
    
    @Override
    public void setCustomer(final EntityPlayer llllllllllllllIIlIIllIIIllIlllll) {
        this.buyingPlayer = llllllllllllllIIlIIllIIIllIlllll;
    }
    
    public void setProfession(final int llllllllllllllIIlIIllIIlIIIIllll) {
        this.dataWatcher.updateObject(16, llllllllllllllIIlIIllIIlIIIIllll);
    }
    
    public boolean func_175556_cs() {
        for (int llllllllllllllIIlIIllIIIIIIlIllI = 0; llllllllllllllIIlIIllIIIIIIlIllI < this.field_175560_bz.getSizeInventory(); ++llllllllllllllIIlIIllIIIIIIlIllI) {
            final ItemStack llllllllllllllIIlIIllIIIIIIlIlIl = this.field_175560_bz.getStackInSlot(llllllllllllllIIlIIllIIIIIIlIllI);
            if (llllllllllllllIIlIIllIIIIIIlIlIl != null && (llllllllllllllIIlIIllIIIIIIlIlIl.getItem() == Items.wheat_seeds || llllllllllllllIIlIIllIIIIIIlIlIl.getItem() == Items.potato || llllllllllllllIIlIIllIIIIIIlIlIl.getItem() == Items.carrot)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIlIIllIIlIIllIIll) {
        super.writeEntityToNBT(llllllllllllllIIlIIllIIlIIllIIll);
        llllllllllllllIIlIIllIIlIIllIIll.setInteger("Profession", this.getProfession());
        llllllllllllllIIlIIllIIlIIllIIll.setInteger("Riches", this.wealth);
        llllllllllllllIIlIIllIIlIIllIIll.setInteger("Career", this.field_175563_bv);
        llllllllllllllIIlIIllIIlIIllIIll.setInteger("CareerLevel", this.field_175562_bw);
        llllllllllllllIIlIIllIIlIIllIIll.setBoolean("Willing", this.field_175565_bs);
        if (this.buyingList != null) {
            llllllllllllllIIlIIllIIlIIllIIll.setTag("Offers", this.buyingList.getRecipiesAsTags());
        }
        final NBTTagList llllllllllllllIIlIIllIIlIIllIIlI = new NBTTagList();
        for (int llllllllllllllIIlIIllIIlIIllIIIl = 0; llllllllllllllIIlIIllIIlIIllIIIl < this.field_175560_bz.getSizeInventory(); ++llllllllllllllIIlIIllIIlIIllIIIl) {
            final ItemStack llllllllllllllIIlIIllIIlIIllIIII = this.field_175560_bz.getStackInSlot(llllllllllllllIIlIIllIIlIIllIIIl);
            if (llllllllllllllIIlIIllIIlIIllIIII != null) {
                llllllllllllllIIlIIllIIlIIllIIlI.appendTag(llllllllllllllIIlIIllIIlIIllIIII.writeToNBT(new NBTTagCompound()));
            }
        }
        llllllllllllllIIlIIllIIlIIllIIll.setTag("Inventory", llllllllllllllIIlIIllIIlIIllIIlI);
    }
    
    @Override
    public boolean interact(final EntityPlayer llllllllllllllIIlIIllIIlIIllllll) {
        final ItemStack llllllllllllllIIlIIllIIlIlIIIIlI = llllllllllllllIIlIIllIIlIIllllll.inventory.getCurrentItem();
        final boolean llllllllllllllIIlIIllIIlIlIIIIIl = llllllllllllllIIlIIllIIlIlIIIIlI != null && llllllllllllllIIlIIllIIlIlIIIIlI.getItem() == Items.spawn_egg;
        if (!llllllllllllllIIlIIllIIlIlIIIIIl && this.isEntityAlive() && !this.isTrading() && !this.isChild()) {
            if (!this.worldObj.isRemote && (this.buyingList == null || this.buyingList.size() > 0)) {
                this.setCustomer(llllllllllllllIIlIIllIIlIIllllll);
                llllllllllllllIIlIIllIIlIIllllll.displayVillagerTradeGui(this);
            }
            llllllllllllllIIlIIllIIlIIllllll.triggerAchievement(StatList.timesTalkedToVillagerStat);
            return true;
        }
        return super.interact(llllllllllllllIIlIIllIIlIIllllll);
    }
    
    @Override
    protected String getLivingSound() {
        return this.isTrading() ? "mob.villager.haggle" : "mob.villager.idle";
    }
    
    @Override
    public boolean allowLeashing() {
        return false;
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.villager.hit";
    }
    
    @Override
    public float getEyeHeight() {
        float llllllllllllllIIlIIllIIIlIIIIIIl = 1.62f;
        if (this.isChild()) {
            llllllllllllllIIlIIllIIIlIIIIIIl -= (float)0.81;
        }
        return llllllllllllllIIlIIllIIIlIIIIIIl;
    }
    
    public boolean isMating() {
        return this.isMating;
    }
    
    @Override
    protected void updateAITasks() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            final BlockPos llllllllllllllIIlIIllIIlIlIIllll = new BlockPos(this);
            this.worldObj.getVillageCollection().func_176060_a(llllllllllllllIIlIIllIIlIlIIllll);
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.getVillageCollection().func_176056_a(llllllllllllllIIlIIllIIlIlIIllll, 32);
            if (this.villageObj == null) {
                this.detachHome();
            }
            else {
                final BlockPos llllllllllllllIIlIIllIIlIlIIlllI = this.villageObj.func_180608_a();
                this.func_175449_a(llllllllllllllIIlIIllIIlIlIIlllI, (int)(this.villageObj.getVillageRadius() * 1.0f));
                if (this.isLookingForHome) {
                    this.isLookingForHome = false;
                    this.villageObj.setDefaultPlayerReputation(5);
                }
            }
        }
        if (!this.isTrading() && this.timeUntilReset > 0) {
            --this.timeUntilReset;
            if (this.timeUntilReset <= 0) {
                if (this.needsInitilization) {
                    for (final MerchantRecipe llllllllllllllIIlIIllIIlIlIIllII : this.buyingList) {
                        if (llllllllllllllIIlIIllIIlIlIIllII.isRecipeDisabled()) {
                            llllllllllllllIIlIIllIIlIlIIllII.func_82783_a(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                        }
                    }
                    this.func_175554_cu();
                    this.needsInitilization = false;
                    if (this.villageObj != null && this.lastBuyingPlayer != null) {
                        this.worldObj.setEntityState(this, (byte)14);
                        this.villageObj.setReputationForPlayer(this.lastBuyingPlayer, 1);
                    }
                }
                this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
            }
        }
        super.updateAITasks();
    }
    
    private void func_175552_ct() {
        if (!this.field_175564_by) {
            this.field_175564_by = true;
            if (this.isChild()) {
                this.tasks.addTask(8, new EntityAIPlay(this, 0.32));
            }
            else if (this.getProfession() == 0) {
                this.tasks.addTask(6, new EntityAIHarvestFarmland(this, 0.6));
            }
        }
    }
    
    public void func_175549_o(final boolean llllllllllllllIIlIIllIIIllIIIlII) {
        this.field_175565_bs = llllllllllllllIIlIIllIIIllIIIlII;
    }
    
    private void func_180489_a(final EnumParticleTypes llllllllllllllIIlIIllIIIIllIlIll) {
        for (int llllllllllllllIIlIIllIIIIlllIIII = 0; llllllllllllllIIlIIllIIIIlllIIII < 5; ++llllllllllllllIIlIIllIIIIlllIIII) {
            final double llllllllllllllIIlIIllIIIIllIllll = this.rand.nextGaussian() * 0.02;
            final double llllllllllllllIIlIIllIIIIllIlllI = this.rand.nextGaussian() * 0.02;
            final double llllllllllllllIIlIIllIIIIllIllIl = this.rand.nextGaussian() * 0.02;
            this.worldObj.spawnParticle(llllllllllllllIIlIIllIIIIllIlIll, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 1.0 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, llllllllllllllIIlIIllIIIIllIllll, llllllllllllllIIlIIllIIIIllIlllI, llllllllllllllIIlIIllIIIIllIllIl, new int[0]);
        }
    }
    
    public boolean func_175555_cq() {
        return this.func_175559_s(2);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
    }
    
    @Override
    public void verifySellingItem(final ItemStack llllllllllllllIIlIIllIIIlIllIlll) {
        if (!this.worldObj.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            if (llllllllllllllIIlIIllIIIlIllIlll != null) {
                this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
            }
            else {
                this.playSound("mob.villager.no", this.getSoundVolume(), this.getSoundPitch());
            }
        }
    }
    
    @Override
    public IChatComponent getDisplayName() {
        final String llllllllllllllIIlIIllIIIlIIIlIll = this.getCustomNameTag();
        if (llllllllllllllIIlIIllIIIlIIIlIll != null && llllllllllllllIIlIIllIIIlIIIlIll.length() > 0) {
            return new ChatComponentText(llllllllllllllIIlIIllIIIlIIIlIll);
        }
        if (this.buyingList == null) {
            this.func_175554_cu();
        }
        String llllllllllllllIIlIIllIIIlIIIlIlI = null;
        switch (this.getProfession()) {
            case 0: {
                if (this.field_175563_bv == 1) {
                    llllllllllllllIIlIIllIIIlIIIlIlI = "farmer";
                    break;
                }
                if (this.field_175563_bv == 2) {
                    llllllllllllllIIlIIllIIIlIIIlIlI = "fisherman";
                    break;
                }
                if (this.field_175563_bv == 3) {
                    llllllllllllllIIlIIllIIIlIIIlIlI = "shepherd";
                    break;
                }
                if (this.field_175563_bv == 4) {
                    llllllllllllllIIlIIllIIIlIIIlIlI = "fletcher";
                    break;
                }
                break;
            }
            case 1: {
                llllllllllllllIIlIIllIIIlIIIlIlI = "librarian";
                break;
            }
            case 2: {
                llllllllllllllIIlIIllIIIlIIIlIlI = "cleric";
                break;
            }
            case 3: {
                if (this.field_175563_bv == 1) {
                    llllllllllllllIIlIIllIIIlIIIlIlI = "armor";
                    break;
                }
                if (this.field_175563_bv == 2) {
                    llllllllllllllIIlIIllIIIlIIIlIlI = "weapon";
                    break;
                }
                if (this.field_175563_bv == 3) {
                    llllllllllllllIIlIIllIIIlIIIlIlI = "tool";
                    break;
                }
                break;
            }
            case 4: {
                if (this.field_175563_bv == 1) {
                    llllllllllllllIIlIIllIIIlIIIlIlI = "butcher";
                    break;
                }
                if (this.field_175563_bv == 2) {
                    llllllllllllllIIlIIllIIIlIIIlIlI = "leather";
                    break;
                }
                break;
            }
        }
        if (llllllllllllllIIlIIllIIIlIIIlIlI != null) {
            final ChatComponentTranslation llllllllllllllIIlIIllIIIlIIIlIIl = new ChatComponentTranslation(String.valueOf(new StringBuilder("entity.Villager.").append(llllllllllllllIIlIIllIIIlIIIlIlI)), new Object[0]);
            llllllllllllllIIlIIllIIIlIIIlIIl.getChatStyle().setChatHoverEvent(this.func_174823_aP());
            llllllllllllllIIlIIllIIIlIIIlIIl.getChatStyle().setInsertion(this.getUniqueID().toString());
            return llllllllllllllIIlIIllIIIlIIIlIIl;
        }
        return super.getDisplayName();
    }
    
    public int getProfession() {
        return Math.max(this.dataWatcher.getWatchableObjectInt(16) % 5, 0);
    }
    
    public EntityVillager func_180488_b(final EntityAgeable llllllllllllllIIlIIllIIIIlIlIlll) {
        final EntityVillager llllllllllllllIIlIIllIIIIlIlIllI = new EntityVillager(this.worldObj);
        llllllllllllllIIlIIllIIIIlIlIllI.func_180482_a(this.worldObj.getDifficultyForLocation(new BlockPos(llllllllllllllIIlIIllIIIIlIlIllI)), null);
        return llllllllllllllIIlIIllIIIIlIlIllI;
    }
    
    public void setLookingForHome() {
        this.isLookingForHome = true;
    }
    
    public boolean isPlaying() {
        return this.isPlaying;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIlIIllIIlIIlIIlII) {
        super.readEntityFromNBT(llllllllllllllIIlIIllIIlIIlIIlII);
        this.setProfession(llllllllllllllIIlIIllIIlIIlIIlII.getInteger("Profession"));
        this.wealth = llllllllllllllIIlIIllIIlIIlIIlII.getInteger("Riches");
        this.field_175563_bv = llllllllllllllIIlIIllIIlIIlIIlII.getInteger("Career");
        this.field_175562_bw = llllllllllllllIIlIIllIIlIIlIIlII.getInteger("CareerLevel");
        this.field_175565_bs = llllllllllllllIIlIIllIIlIIlIIlII.getBoolean("Willing");
        if (llllllllllllllIIlIIllIIlIIlIIlII.hasKey("Offers", 10)) {
            final NBTTagCompound llllllllllllllIIlIIllIIlIIlIIIll = llllllllllllllIIlIIllIIlIIlIIlII.getCompoundTag("Offers");
            this.buyingList = new MerchantRecipeList(llllllllllllllIIlIIllIIlIIlIIIll);
        }
        final NBTTagList llllllllllllllIIlIIllIIlIIlIIIlI = llllllllllllllIIlIIllIIlIIlIIlII.getTagList("Inventory", 10);
        for (int llllllllllllllIIlIIllIIlIIlIIIIl = 0; llllllllllllllIIlIIllIIlIIlIIIIl < llllllllllllllIIlIIllIIlIIlIIIlI.tagCount(); ++llllllllllllllIIlIIllIIlIIlIIIIl) {
            final ItemStack llllllllllllllIIlIIllIIlIIlIIIII = ItemStack.loadItemStackFromNBT(llllllllllllllIIlIIllIIlIIlIIIlI.getCompoundTagAt(llllllllllllllIIlIIllIIlIIlIIIIl));
            if (llllllllllllllIIlIIllIIlIIlIIIII != null) {
                this.field_175560_bz.func_174894_a(llllllllllllllIIlIIllIIlIIlIIIII);
            }
        }
        this.setCanPickUpLoot(true);
        this.func_175552_ct();
    }
    
    @Override
    public MerchantRecipeList getRecipes(final EntityPlayer llllllllllllllIIlIIllIIIlIllIIlI) {
        if (this.buyingList == null) {
            this.func_175554_cu();
        }
        return this.buyingList;
    }
    
    @Override
    public IEntityLivingData func_180482_a(final DifficultyInstance llllllllllllllIIlIIllIIIIllIIIlI, IEntityLivingData llllllllllllllIIlIIllIIIIlIllllI) {
        llllllllllllllIIlIIllIIIIlIllllI = super.func_180482_a(llllllllllllllIIlIIllIIIIllIIIlI, llllllllllllllIIlIIllIIIIlIllllI);
        this.setProfession(this.worldObj.rand.nextInt(5));
        this.func_175552_ct();
        return llllllllllllllIIlIIllIIIIlIllllI;
    }
    
    public EntityVillager(final World llllllllllllllIIlIIllIIlIllIIllI) {
        this(llllllllllllllIIlIIllIIlIllIIllI, 0);
    }
    
    @Override
    public void onStruckByLightning(final EntityLightningBolt llllllllllllllIIlIIllIIIIlIIllll) {
        if (!this.worldObj.isRemote) {
            final EntityWitch llllllllllllllIIlIIllIIIIlIIlllI = new EntityWitch(this.worldObj);
            llllllllllllllIIlIIllIIIIlIIlllI.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            llllllllllllllIIlIIllIIIIlIIlllI.func_180482_a(this.worldObj.getDifficultyForLocation(new BlockPos(llllllllllllllIIlIIllIIIIlIIlllI)), null);
            this.worldObj.spawnEntityInWorld(llllllllllllllIIlIIllIIIIlIIlllI);
            this.setDead();
        }
    }
    
    @Override
    public void setRevengeTarget(final EntityLivingBase llllllllllllllIIlIIllIIIllllIIlI) {
        super.setRevengeTarget(llllllllllllllIIlIIllIIIllllIIlI);
        if (this.villageObj != null && llllllllllllllIIlIIllIIIllllIIlI != null) {
            this.villageObj.addOrRenewAgressor(llllllllllllllIIlIIllIIIllllIIlI);
            if (llllllllllllllIIlIIllIIIllllIIlI instanceof EntityPlayer) {
                byte llllllllllllllIIlIIllIIIllllIlII = -1;
                if (this.isChild()) {
                    llllllllllllllIIlIIllIIIllllIlII = -3;
                }
                this.villageObj.setReputationForPlayer(llllllllllllllIIlIIllIIIllllIIlI.getName(), llllllllllllllIIlIIllIIIllllIlII);
                if (this.isEntityAlive()) {
                    this.worldObj.setEntityState(this, (byte)13);
                }
            }
        }
    }
    
    @Override
    public void handleHealthUpdate(final byte llllllllllllllIIlIIllIIIIllllIIl) {
        if (llllllllllllllIIlIIllIIIIllllIIl == 12) {
            this.func_180489_a(EnumParticleTypes.HEART);
        }
        else if (llllllllllllllIIlIIllIIIIllllIIl == 13) {
            this.func_180489_a(EnumParticleTypes.VILLAGER_ANGRY);
        }
        else if (llllllllllllllIIlIIllIIIIllllIIl == 14) {
            this.func_180489_a(EnumParticleTypes.VILLAGER_HAPPY);
        }
        else {
            super.handleHealthUpdate(llllllllllllllIIlIIllIIIIllllIIl);
        }
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
    }
    
    public void setMating(final boolean llllllllllllllIIlIIllIIlIIIIIlIl) {
        this.isMating = llllllllllllllIIlIIllIIlIIIIIlIl;
    }
    
    @Override
    protected void func_175500_n() {
        if (this.getProfession() == 0) {
            this.tasks.addTask(8, new EntityAIHarvestFarmland(this, 0.6));
        }
        super.func_175500_n();
    }
    
    static class ListEnchantedItemForEmeralds implements ITradeList
    {
        public /* synthetic */ ItemStack field_179407_a;
        public /* synthetic */ PriceInfo field_179406_b;
        
        public ListEnchantedItemForEmeralds(final Item lllllllllllllllIIlIlIIIIIIlIIIII, final PriceInfo lllllllllllllllIIlIlIIIIIIIlllII) {
            this.field_179407_a = new ItemStack(lllllllllllllllIIlIlIIIIIIlIIIII);
            this.field_179406_b = lllllllllllllllIIlIlIIIIIIIlllII;
        }
        
        static {
            __OBFID = "CL_00002192";
        }
        
        @Override
        public void func_179401_a(final MerchantRecipeList lllllllllllllllIIlIlIIIIIIIIlllI, final Random lllllllllllllllIIlIlIIIIIIIIllIl) {
            int lllllllllllllllIIlIlIIIIIIIlIIlI = 1;
            if (this.field_179406_b != null) {
                lllllllllllllllIIlIlIIIIIIIlIIlI = this.field_179406_b.func_179412_a(lllllllllllllllIIlIlIIIIIIIIllIl);
            }
            final ItemStack lllllllllllllllIIlIlIIIIIIIlIIIl = new ItemStack(Items.emerald, lllllllllllllllIIlIlIIIIIIIlIIlI, 0);
            ItemStack lllllllllllllllIIlIlIIIIIIIlIIII = new ItemStack(this.field_179407_a.getItem(), 1, this.field_179407_a.getMetadata());
            lllllllllllllllIIlIlIIIIIIIlIIII = EnchantmentHelper.addRandomEnchantment(lllllllllllllllIIlIlIIIIIIIIllIl, lllllllllllllllIIlIlIIIIIIIlIIII, 5 + lllllllllllllllIIlIlIIIIIIIIllIl.nextInt(15));
            lllllllllllllllIIlIlIIIIIIIIlllI.add(new MerchantRecipe(lllllllllllllllIIlIlIIIIIIIlIIIl, lllllllllllllllIIlIlIIIIIIIlIIII));
        }
    }
    
    interface ITradeList
    {
        void func_179401_a(final MerchantRecipeList p0, final Random p1);
    }
    
    static class PriceInfo extends Tuple
    {
        public PriceInfo(final int lllllllllllllllIIllllIIIlllIlIII, final int lllllllllllllllIIllllIIIlllIIlll) {
            super(lllllllllllllllIIllllIIIlllIlIII, lllllllllllllllIIllllIIIlllIIlll);
        }
        
        static {
            __OBFID = "CL_00002189";
        }
        
        public int func_179412_a(final Random lllllllllllllllIIllllIIIlllIIIIl) {
            return (int)(((int)this.getFirst() >= (int)this.getSecond()) ? this.getFirst() : ((int)this.getFirst() + lllllllllllllllIIllllIIIlllIIIIl.nextInt((int)this.getSecond() - (int)this.getFirst() + 1)));
        }
    }
    
    static class ListEnchantedBookForEmeralds implements ITradeList
    {
        static {
            __OBFID = "CL_00002193";
        }
        
        @Override
        public void func_179401_a(final MerchantRecipeList llllllllllllllIIIIIlIllllIIIllll, final Random llllllllllllllIIIIIlIllllIIIlIII) {
            final Enchantment llllllllllllllIIIIIlIllllIIIllIl = Enchantment.enchantmentsList[llllllllllllllIIIIIlIllllIIIlIII.nextInt(Enchantment.enchantmentsList.length)];
            final int llllllllllllllIIIIIlIllllIIIllII = MathHelper.getRandomIntegerInRange(llllllllllllllIIIIIlIllllIIIlIII, llllllllllllllIIIIIlIllllIIIllIl.getMinLevel(), llllllllllllllIIIIIlIllllIIIllIl.getMaxLevel());
            final ItemStack llllllllllllllIIIIIlIllllIIIlIll = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(llllllllllllllIIIIIlIllllIIIllIl, llllllllllllllIIIIIlIllllIIIllII));
            int llllllllllllllIIIIIlIllllIIIlIlI = 2 + llllllllllllllIIIIIlIllllIIIlIII.nextInt(5 + llllllllllllllIIIIIlIllllIIIllII * 10) + 3 * llllllllllllllIIIIIlIllllIIIllII;
            if (llllllllllllllIIIIIlIllllIIIlIlI > 64) {
                llllllllllllllIIIIIlIllllIIIlIlI = 64;
            }
            llllllllllllllIIIIIlIllllIIIllll.add(new MerchantRecipe(new ItemStack(Items.book), new ItemStack(Items.emerald, llllllllllllllIIIIIlIllllIIIlIlI), llllllllllllllIIIIIlIllllIIIlIll));
        }
    }
    
    static class ItemAndEmeraldToItem implements ITradeList
    {
        public /* synthetic */ ItemStack field_179410_c;
        public /* synthetic */ ItemStack field_179411_a;
        public /* synthetic */ PriceInfo field_179408_d;
        public /* synthetic */ PriceInfo field_179409_b;
        
        static {
            __OBFID = "CL_00002191";
        }
        
        public ItemAndEmeraldToItem(final Item lllllllllllllllIIllIIlllIllIlIIl, final PriceInfo lllllllllllllllIIllIIlllIllIlIII, final Item lllllllllllllllIIllIIlllIllIllII, final PriceInfo lllllllllllllllIIllIIlllIllIlIll) {
            this.field_179411_a = new ItemStack(lllllllllllllllIIllIIlllIllIlIIl);
            this.field_179409_b = lllllllllllllllIIllIIlllIllIlIII;
            this.field_179410_c = new ItemStack(lllllllllllllllIIllIIlllIllIllII);
            this.field_179408_d = lllllllllllllllIIllIIlllIllIlIll;
        }
        
        @Override
        public void func_179401_a(final MerchantRecipeList lllllllllllllllIIllIIlllIlIlllll, final Random lllllllllllllllIIllIIlllIlIllIIl) {
            int lllllllllllllllIIllIIlllIlIlllIl = 1;
            if (this.field_179409_b != null) {
                lllllllllllllllIIllIIlllIlIlllIl = this.field_179409_b.func_179412_a(lllllllllllllllIIllIIlllIlIllIIl);
            }
            int lllllllllllllllIIllIIlllIlIlllII = 1;
            if (this.field_179408_d != null) {
                lllllllllllllllIIllIIlllIlIlllII = this.field_179408_d.func_179412_a(lllllllllllllllIIllIIlllIlIllIIl);
            }
            lllllllllllllllIIllIIlllIlIlllll.add(new MerchantRecipe(new ItemStack(this.field_179411_a.getItem(), lllllllllllllllIIllIIlllIlIlllIl, this.field_179411_a.getMetadata()), new ItemStack(Items.emerald), new ItemStack(this.field_179410_c.getItem(), lllllllllllllllIIllIIlllIlIlllII, this.field_179410_c.getMetadata())));
        }
    }
    
    static class ListItemForEmeralds implements ITradeList
    {
        public /* synthetic */ PriceInfo field_179402_b;
        public /* synthetic */ ItemStack field_179403_a;
        
        public ListItemForEmeralds(final Item llllllllllllllIlIlIIlIIIlIIlIlII, final PriceInfo llllllllllllllIlIlIIlIIIlIIlIIlI) {
            this.field_179403_a = new ItemStack(llllllllllllllIlIlIIlIIIlIIlIlII);
            this.field_179402_b = llllllllllllllIlIlIIlIIIlIIlIIlI;
        }
        
        @Override
        public void func_179401_a(final MerchantRecipeList llllllllllllllIlIlIIlIIIIlIlIlll, final Random llllllllllllllIlIlIIlIIIIllIIIll) {
            int llllllllllllllIlIlIIlIIIIllIIIIl = 1;
            if (this.field_179402_b != null) {
                llllllllllllllIlIlIIlIIIIllIIIIl = this.field_179402_b.func_179412_a(llllllllllllllIlIlIIlIIIIllIIIll);
            }
            ItemStack llllllllllllllIlIlIIlIIIIlIlllIl = null;
            ItemStack llllllllllllllIlIlIIlIIIIlIllIll = null;
            if (llllllllllllllIlIlIIlIIIIllIIIIl < 0) {
                final ItemStack llllllllllllllIlIlIIlIIIIlIlllll = new ItemStack(Items.emerald, 1, 0);
                final ItemStack llllllllllllllIlIlIIlIIIIlIlllII = new ItemStack(this.field_179403_a.getItem(), -llllllllllllllIlIlIIlIIIIllIIIIl, this.field_179403_a.getMetadata());
            }
            else {
                llllllllllllllIlIlIIlIIIIlIlllIl = new ItemStack(Items.emerald, llllllllllllllIlIlIIlIIIIllIIIIl, 0);
                llllllllllllllIlIlIIlIIIIlIllIll = new ItemStack(this.field_179403_a.getItem(), 1, this.field_179403_a.getMetadata());
            }
            llllllllllllllIlIlIIlIIIIlIlIlll.add(new MerchantRecipe(llllllllllllllIlIlIIlIIIIlIlllIl, llllllllllllllIlIlIIlIIIIlIllIll));
        }
        
        public ListItemForEmeralds(final ItemStack llllllllllllllIlIlIIlIIIlIIIIIlI, final PriceInfo llllllllllllllIlIlIIlIIIlIIIIIIl) {
            this.field_179403_a = llllllllllllllIlIlIIlIIIlIIIIIlI;
            this.field_179402_b = llllllllllllllIlIlIIlIIIlIIIIIIl;
        }
        
        static {
            __OBFID = "CL_00002190";
        }
    }
    
    static class EmeraldForItems implements ITradeList
    {
        public /* synthetic */ PriceInfo field_179404_b;
        public /* synthetic */ Item field_179405_a;
        
        static {
            __OBFID = "CL_00002194";
        }
        
        public EmeraldForItems(final Item lllllllllllllllIIllIIIllIlllIlll, final PriceInfo lllllllllllllllIIllIIIllIlllIllI) {
            this.field_179405_a = lllllllllllllllIIllIIIllIlllIlll;
            this.field_179404_b = lllllllllllllllIIllIIIllIlllIllI;
        }
        
        @Override
        public void func_179401_a(final MerchantRecipeList lllllllllllllllIIllIIIllIllIlIIl, final Random lllllllllllllllIIllIIIllIllIllII) {
            int lllllllllllllllIIllIIIllIllIlIll = 1;
            if (this.field_179404_b != null) {
                lllllllllllllllIIllIIIllIllIlIll = this.field_179404_b.func_179412_a(lllllllllllllllIIllIIIllIllIllII);
            }
            lllllllllllllllIIllIIIllIllIlIIl.add(new MerchantRecipe(new ItemStack(this.field_179405_a, lllllllllllllllIIllIIIllIllIlIll, 0), Items.emerald));
        }
    }
}
