package net.minecraft.entity.item;

import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.crash.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class EntityFallingBlock extends Entity
{
    private /* synthetic */ boolean field_145808_f;
    private /* synthetic */ IBlockState field_175132_d;
    public /* synthetic */ boolean shouldDropItem;
    private /* synthetic */ float fallHurtAmount;
    public /* synthetic */ int fallTime;
    public /* synthetic */ NBTTagCompound tileEntityData;
    private /* synthetic */ int fallHurtMax;
    private /* synthetic */ boolean hurtEntities;
    
    public EntityFallingBlock(final World lllllllllllllllIlIIlIIIllllIIlIl) {
        super(lllllllllllllllIlIIlIIIllllIIlIl);
        this.shouldDropItem = true;
        this.fallHurtMax = 40;
        this.fallHurtAmount = 2.0f;
    }
    
    @Override
    public void addEntityCrashInfo(final CrashReportCategory lllllllllllllllIlIIlIIIlIllIlllI) {
        super.addEntityCrashInfo(lllllllllllllllIlIIlIIIlIllIlllI);
        if (this.field_175132_d != null) {
            final Block lllllllllllllllIlIIlIIIlIlllIIII = this.field_175132_d.getBlock();
            lllllllllllllllIlIIlIIIlIllIlllI.addCrashSection("Immitating block ID", Block.getIdFromBlock(lllllllllllllllIlIIlIIIlIlllIIII));
            lllllllllllllllIlIIlIIIlIllIlllI.addCrashSection("Immitating block data", lllllllllllllllIlIIlIIIlIlllIIII.getMetaFromState(this.field_175132_d));
        }
    }
    
    public EntityFallingBlock(final World lllllllllllllllIlIIlIIIlllIlllIl, final double lllllllllllllllIlIIlIIIlllIlIllI, final double lllllllllllllllIlIIlIIIlllIllIll, final double lllllllllllllllIlIIlIIIlllIllIlI, final IBlockState lllllllllllllllIlIIlIIIlllIllIIl) {
        super(lllllllllllllllIlIIlIIIlllIlllIl);
        this.shouldDropItem = true;
        this.fallHurtMax = 40;
        this.fallHurtAmount = 2.0f;
        this.field_175132_d = lllllllllllllllIlIIlIIIlllIllIIl;
        this.preventEntitySpawning = true;
        this.setSize(0.98f, 0.98f);
        this.setPosition(lllllllllllllllIlIIlIIIlllIlIllI, lllllllllllllllIlIIlIIIlllIllIll, lllllllllllllllIlIIlIIIlllIllIlI);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = lllllllllllllllIlIIlIIIlllIlIllI;
        this.prevPosY = lllllllllllllllIlIIlIIIlllIllIll;
        this.prevPosZ = lllllllllllllllIlIIlIIIlllIllIlI;
    }
    
    public World getWorldObj() {
        return this.worldObj;
    }
    
    @Override
    protected void entityInit() {
    }
    
    public void setHurtEntities(final boolean lllllllllllllllIlIIlIIIlIlllIlll) {
        this.hurtEntities = lllllllllllllllIlIIlIIIlIlllIlll;
    }
    
    public IBlockState getBlock() {
        return this.field_175132_d;
    }
    
    static {
        __OBFID = "CL_00001668";
    }
    
    @Override
    public void fall(final float lllllllllllllllIlIIlIIIllIlIlIlI, final float lllllllllllllllIlIIlIIIllIlIlIIl) {
        final Block lllllllllllllllIlIIlIIIllIlIlIII = this.field_175132_d.getBlock();
        if (this.hurtEntities) {
            final int lllllllllllllllIlIIlIIIllIlIIlll = MathHelper.ceiling_float_int(lllllllllllllllIlIIlIIIllIlIlIlI - 1.0f);
            if (lllllllllllllllIlIIlIIIllIlIIlll > 0) {
                final ArrayList lllllllllllllllIlIIlIIIllIlIIllI = Lists.newArrayList((Iterable)this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox()));
                final boolean lllllllllllllllIlIIlIIIllIlIIlIl = lllllllllllllllIlIIlIIIllIlIlIII == Blocks.anvil;
                final DamageSource lllllllllllllllIlIIlIIIllIlIIlII = lllllllllllllllIlIIlIIIllIlIIlIl ? DamageSource.anvil : DamageSource.fallingBlock;
                for (final Entity lllllllllllllllIlIIlIIIllIlIIIlI : lllllllllllllllIlIIlIIIllIlIIllI) {
                    lllllllllllllllIlIIlIIIllIlIIIlI.attackEntityFrom(lllllllllllllllIlIIlIIIllIlIIlII, (float)Math.min(MathHelper.floor_float(lllllllllllllllIlIIlIIIllIlIIlll * this.fallHurtAmount), this.fallHurtMax));
                }
                if (lllllllllllllllIlIIlIIIllIlIIlIl && this.rand.nextFloat() < 0.05000000074505806 + lllllllllllllllIlIIlIIIllIlIIlll * 0.05) {
                    int lllllllllllllllIlIIlIIIllIlIIIIl = (int)this.field_175132_d.getValue(BlockAnvil.DAMAGE);
                    if (++lllllllllllllllIlIIlIIIllIlIIIIl > 2) {
                        this.field_145808_f = true;
                    }
                    else {
                        this.field_175132_d = this.field_175132_d.withProperty(BlockAnvil.DAMAGE, lllllllllllllllIlIIlIIIllIlIIIIl);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllllIlIIlIIIllIIIIIlI) {
        final int lllllllllllllllIlIIlIIIllIIIIlIl = lllllllllllllllIlIIlIIIllIIIIIlI.getByte("Data") & 0xFF;
        if (lllllllllllllllIlIIlIIIllIIIIIlI.hasKey("Block", 8)) {
            this.field_175132_d = Block.getBlockFromName(lllllllllllllllIlIIlIIIllIIIIIlI.getString("Block")).getStateFromMeta(lllllllllllllllIlIIlIIIllIIIIlIl);
        }
        else if (lllllllllllllllIlIIlIIIllIIIIIlI.hasKey("TileID", 99)) {
            this.field_175132_d = Block.getBlockById(lllllllllllllllIlIIlIIIllIIIIIlI.getInteger("TileID")).getStateFromMeta(lllllllllllllllIlIIlIIIllIIIIlIl);
        }
        else {
            this.field_175132_d = Block.getBlockById(lllllllllllllllIlIIlIIIllIIIIIlI.getByte("Tile") & 0xFF).getStateFromMeta(lllllllllllllllIlIIlIIIllIIIIlIl);
        }
        this.fallTime = (lllllllllllllllIlIIlIIIllIIIIIlI.getByte("Time") & 0xFF);
        final Block lllllllllllllllIlIIlIIIllIIIIlII = this.field_175132_d.getBlock();
        if (lllllllllllllllIlIIlIIIllIIIIIlI.hasKey("HurtEntities", 99)) {
            this.hurtEntities = lllllllllllllllIlIIlIIIllIIIIIlI.getBoolean("HurtEntities");
            this.fallHurtAmount = lllllllllllllllIlIIlIIIllIIIIIlI.getFloat("FallHurtAmount");
            this.fallHurtMax = lllllllllllllllIlIIlIIIllIIIIIlI.getInteger("FallHurtMax");
        }
        else if (lllllllllllllllIlIIlIIIllIIIIlII == Blocks.anvil) {
            this.hurtEntities = true;
        }
        if (lllllllllllllllIlIIlIIIllIIIIIlI.hasKey("DropItem", 99)) {
            this.shouldDropItem = lllllllllllllllIlIIlIIIllIIIIIlI.getBoolean("DropItem");
        }
        if (lllllllllllllllIlIIlIIIllIIIIIlI.hasKey("TileEntityData", 10)) {
            this.tileEntityData = lllllllllllllllIlIIlIIIllIIIIIlI.getCompoundTag("TileEntityData");
        }
        if (lllllllllllllllIlIIlIIIllIIIIlII == null || lllllllllllllllIlIIlIIIllIIIIlII.getMaterial() == Material.air) {
            this.field_175132_d = Blocks.sand.getDefaultState();
        }
    }
    
    @Override
    public void onUpdate() {
        final Block lllllllllllllllIlIIlIIIlllIIIlII = this.field_175132_d.getBlock();
        if (lllllllllllllllIlIIlIIIlllIIIlII.getMaterial() == Material.air) {
            this.setDead();
        }
        else {
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            if (this.fallTime++ == 0) {
                final BlockPos lllllllllllllllIlIIlIIIlllIIIIll = new BlockPos(this);
                if (this.worldObj.getBlockState(lllllllllllllllIlIIlIIIlllIIIIll).getBlock() == lllllllllllllllIlIIlIIIlllIIIlII) {
                    this.worldObj.setBlockToAir(lllllllllllllllIlIIlIIIlllIIIIll);
                }
                else if (!this.worldObj.isRemote) {
                    this.setDead();
                    return;
                }
            }
            this.motionY -= 0.03999999910593033;
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.9800000190734863;
            this.motionY *= 0.9800000190734863;
            this.motionZ *= 0.9800000190734863;
            if (!this.worldObj.isRemote) {
                final BlockPos lllllllllllllllIlIIlIIIlllIIIIlI = new BlockPos(this);
                if (this.onGround) {
                    this.motionX *= 0.699999988079071;
                    this.motionZ *= 0.699999988079071;
                    this.motionY *= -0.5;
                    if (this.worldObj.getBlockState(lllllllllllllllIlIIlIIIlllIIIIlI).getBlock() != Blocks.piston_extension) {
                        this.setDead();
                        if (!this.field_145808_f && this.worldObj.canBlockBePlaced(lllllllllllllllIlIIlIIIlllIIIlII, lllllllllllllllIlIIlIIIlllIIIIlI, true, EnumFacing.UP, null, null) && !BlockFalling.canFallInto(this.worldObj, lllllllllllllllIlIIlIIIlllIIIIlI.offsetDown()) && this.worldObj.setBlockState(lllllllllllllllIlIIlIIIlllIIIIlI, this.field_175132_d, 3)) {
                            if (lllllllllllllllIlIIlIIIlllIIIlII instanceof BlockFalling) {
                                ((BlockFalling)lllllllllllllllIlIIlIIIlllIIIlII).onEndFalling(this.worldObj, lllllllllllllllIlIIlIIIlllIIIIlI);
                            }
                            if (this.tileEntityData != null && lllllllllllllllIlIIlIIIlllIIIlII instanceof ITileEntityProvider) {
                                final TileEntity lllllllllllllllIlIIlIIIlllIIIIIl = this.worldObj.getTileEntity(lllllllllllllllIlIIlIIIlllIIIIlI);
                                if (lllllllllllllllIlIIlIIIlllIIIIIl != null) {
                                    final NBTTagCompound lllllllllllllllIlIIlIIIlllIIIIII = new NBTTagCompound();
                                    lllllllllllllllIlIIlIIIlllIIIIIl.writeToNBT(lllllllllllllllIlIIlIIIlllIIIIII);
                                    for (final String lllllllllllllllIlIIlIIIllIlllllI : this.tileEntityData.getKeySet()) {
                                        final NBTBase lllllllllllllllIlIIlIIIllIllllIl = this.tileEntityData.getTag(lllllllllllllllIlIIlIIIllIlllllI);
                                        if (!lllllllllllllllIlIIlIIIllIlllllI.equals("x") && !lllllllllllllllIlIIlIIIllIlllllI.equals("y") && !lllllllllllllllIlIIlIIIllIlllllI.equals("z")) {
                                            lllllllllllllllIlIIlIIIlllIIIIII.setTag(lllllllllllllllIlIIlIIIllIlllllI, lllllllllllllllIlIIlIIIllIllllIl.copy());
                                        }
                                    }
                                    lllllllllllllllIlIIlIIIlllIIIIIl.readFromNBT(lllllllllllllllIlIIlIIIlllIIIIII);
                                    lllllllllllllllIlIIlIIIlllIIIIIl.markDirty();
                                }
                            }
                        }
                        else if (this.shouldDropItem && !this.field_145808_f && this.worldObj.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
                            this.entityDropItem(new ItemStack(lllllllllllllllIlIIlIIIlllIIIlII, 1, lllllllllllllllIlIIlIIIlllIIIlII.damageDropped(this.field_175132_d)), 0.0f);
                        }
                    }
                }
                else if ((this.fallTime > 100 && !this.worldObj.isRemote && (lllllllllllllllIlIIlIIIlllIIIIlI.getY() < 1 || lllllllllllllllIlIIlIIIlllIIIIlI.getY() > 256)) || this.fallTime > 600) {
                    if (this.shouldDropItem && this.worldObj.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
                        this.entityDropItem(new ItemStack(lllllllllllllllIlIIlIIIlllIIIlII, 1, lllllllllllllllIlIIlIIIlllIIIlII.damageDropped(this.field_175132_d)), 0.0f);
                    }
                    this.setDead();
                }
            }
        }
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllllIlIIlIIIllIIIlllI) {
        final Block lllllllllllllllIlIIlIIIllIIlIIIl = (this.field_175132_d != null) ? this.field_175132_d.getBlock() : Blocks.air;
        final ResourceLocation lllllllllllllllIlIIlIIIllIIlIIII = (ResourceLocation)Block.blockRegistry.getNameForObject(lllllllllllllllIlIIlIIIllIIlIIIl);
        lllllllllllllllIlIIlIIIllIIIlllI.setString("Block", (lllllllllllllllIlIIlIIIllIIlIIII == null) ? "" : lllllllllllllllIlIIlIIIllIIlIIII.toString());
        lllllllllllllllIlIIlIIIllIIIlllI.setByte("Data", (byte)lllllllllllllllIlIIlIIIllIIlIIIl.getMetaFromState(this.field_175132_d));
        lllllllllllllllIlIIlIIIllIIIlllI.setByte("Time", (byte)this.fallTime);
        lllllllllllllllIlIIlIIIllIIIlllI.setBoolean("DropItem", this.shouldDropItem);
        lllllllllllllllIlIIlIIIllIIIlllI.setBoolean("HurtEntities", this.hurtEntities);
        lllllllllllllllIlIIlIIIllIIIlllI.setFloat("FallHurtAmount", this.fallHurtAmount);
        lllllllllllllllIlIIlIIIllIIIlllI.setInteger("FallHurtMax", this.fallHurtMax);
        if (this.tileEntityData != null) {
            lllllllllllllllIlIIlIIIllIIIlllI.setTag("TileEntityData", this.tileEntityData);
        }
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public boolean canRenderOnFire() {
        return false;
    }
}
