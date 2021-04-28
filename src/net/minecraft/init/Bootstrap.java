package net.minecraft.init;

import net.minecraft.world.*;
import net.minecraft.dispenser.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.item.*;
import com.mojang.authlib.*;
import java.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import java.io.*;
import org.apache.logging.log4j.*;

public class Bootstrap
{
    private static final /* synthetic */ PrintStream SYSOUT;
    private static final /* synthetic */ Logger LOGGER;
    private static /* synthetic */ boolean alreadyRegistered;
    
    static void registerDispenserBehaviors() {
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.arrow, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World llllllllllllllIIIIIlIIlIllIlIIlI, final IPosition llllllllllllllIIIIIlIIlIllIlIIIl) {
                final EntityArrow llllllllllllllIIIIIlIIlIllIlIIll = new EntityArrow(llllllllllllllIIIIIlIIlIllIlIIlI, llllllllllllllIIIIIlIIlIllIlIIIl.getX(), llllllllllllllIIIIIlIIlIllIlIIIl.getY(), llllllllllllllIIIIIlIIlIllIlIIIl.getZ());
                llllllllllllllIIIIIlIIlIllIlIIll.canBePickedUp = 1;
                return llllllllllllllIIIIIlIIlIllIlIIll;
            }
            
            static {
                __OBFID = "CL_00001398";
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.egg, new BehaviorProjectileDispense() {
            static {
                __OBFID = "CL_00001404";
            }
            
            @Override
            protected IProjectile getProjectileEntity(final World lllllllllllllIllllllllllllIlIIlI, final IPosition lllllllllllllIllllllllllllIlIIIl) {
                return new EntityEgg(lllllllllllllIllllllllllllIlIIlI, lllllllllllllIllllllllllllIlIIIl.getX(), lllllllllllllIllllllllllllIlIIIl.getY(), lllllllllllllIllllllllllllIlIIIl.getZ());
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.snowball, new BehaviorProjectileDispense() {
            static {
                __OBFID = "CL_00001405";
            }
            
            @Override
            protected IProjectile getProjectileEntity(final World llllllllllllllIIlIIIIlIIIlIlIIII, final IPosition llllllllllllllIIlIIIIlIIIlIIllll) {
                return new EntitySnowball(llllllllllllllIIlIIIIlIIIlIlIIII, llllllllllllllIIlIIIIlIIIlIIllll.getX(), llllllllllllllIIlIIIIlIIIlIIllll.getY(), llllllllllllllIIlIIIIlIIIlIIllll.getZ());
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.experience_bottle, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World llllllllllllllIIIIIlIIIllIlIIlII, final IPosition llllllllllllllIIIIIlIIIllIlIIIIl) {
                return new EntityExpBottle(llllllllllllllIIIIIlIIIllIlIIlII, llllllllllllllIIIIIlIIIllIlIIIIl.getX(), llllllllllllllIIIIIlIIIllIlIIIIl.getY(), llllllllllllllIIIIIlIIIllIlIIIIl.getZ());
            }
            
            @Override
            protected float func_82500_b() {
                return super.func_82500_b() * 1.25f;
            }
            
            static {
                __OBFID = "CL_00001406";
            }
            
            @Override
            protected float func_82498_a() {
                return super.func_82498_a() * 0.5f;
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.potionitem, new IBehaviorDispenseItem() {
            private final /* synthetic */ BehaviorDefaultDispenseItem field_150843_b = new BehaviorDefaultDispenseItem();
            
            @Override
            public ItemStack dispense(final IBlockSource llllllllllllllIIIIIlllIlIIIlIIll, final ItemStack llllllllllllllIIIIIlllIlIIIlIIlI) {
                return ItemPotion.isSplash(llllllllllllllIIIIIlllIlIIIlIIlI.getMetadata()) ? new BehaviorProjectileDispense() {
                    static {
                        __OBFID = "CL_00001408";
                    }
                    
                    @Override
                    protected IProjectile getProjectileEntity(final World llIIlIIIlIlIlII, final IPosition llIIlIIIlIlIIll) {
                        return new EntityPotion(llIIlIIIlIlIlII, llIIlIIIlIlIIll.getX(), llIIlIIIlIlIIll.getY(), llIIlIIIlIlIIll.getZ(), llllllllllllllIIIIIlllIlIIIlIIlI.copy());
                    }
                    
                    @Override
                    protected float func_82498_a() {
                        return super.func_82498_a() * 0.5f;
                    }
                    
                    @Override
                    protected float func_82500_b() {
                        return super.func_82500_b() * 1.25f;
                    }
                }.dispense(llllllllllllllIIIIIlllIlIIIlIIll, llllllllllllllIIIIIlllIlIIIlIIlI) : this.field_150843_b.dispense(llllllllllllllIIIIIlllIlIIIlIIll, llllllllllllllIIIIIlllIlIIIlIIlI);
            }
            
            static {
                __OBFID = "CL_00001407";
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.spawn_egg, new BehaviorDefaultDispenseItem() {
            static {
                __OBFID = "CL_00001410";
            }
            
            public ItemStack dispenseStack(final IBlockSource llllllllllllllIIIIlIlIlllIllIlIl, final ItemStack llllllllllllllIIIIlIlIlllIllIlII) {
                final EnumFacing llllllllllllllIIIIlIlIlllIllIIll = BlockDispenser.getFacing(llllllllllllllIIIIlIlIlllIllIlIl.getBlockMetadata());
                final double llllllllllllllIIIIlIlIlllIllIIlI = llllllllllllllIIIIlIlIlllIllIlIl.getX() + llllllllllllllIIIIlIlIlllIllIIll.getFrontOffsetX();
                final double llllllllllllllIIIIlIlIlllIllIIIl = llllllllllllllIIIIlIlIlllIllIlIl.getBlockPos().getY() + 0.2f;
                final double llllllllllllllIIIIlIlIlllIllIIII = llllllllllllllIIIIlIlIlllIllIlIl.getZ() + llllllllllllllIIIIlIlIlllIllIIll.getFrontOffsetZ();
                final Entity llllllllllllllIIIIlIlIlllIlIllll = ItemMonsterPlacer.spawnCreature(llllllllllllllIIIIlIlIlllIllIlIl.getWorld(), llllllllllllllIIIIlIlIlllIllIlII.getMetadata(), llllllllllllllIIIIlIlIlllIllIIlI, llllllllllllllIIIIlIlIlllIllIIIl, llllllllllllllIIIIlIlIlllIllIIII);
                if (llllllllllllllIIIIlIlIlllIlIllll instanceof EntityLivingBase && llllllllllllllIIIIlIlIlllIllIlII.hasDisplayName()) {
                    ((EntityLiving)llllllllllllllIIIIlIlIlllIlIllll).setCustomNameTag(llllllllllllllIIIIlIlIlllIllIlII.getDisplayName());
                }
                llllllllllllllIIIIlIlIlllIllIlII.splitStack(1);
                return llllllllllllllIIIIlIlIlllIllIlII;
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.fireworks, new BehaviorDefaultDispenseItem() {
            public ItemStack dispenseStack(final IBlockSource llllllllllllllIIllIlllIllllIllll, final ItemStack llllllllllllllIIllIlllIlllllIlIl) {
                final EnumFacing llllllllllllllIIllIlllIlllllIlII = BlockDispenser.getFacing(llllllllllllllIIllIlllIllllIllll.getBlockMetadata());
                final double llllllllllllllIIllIlllIlllllIIll = llllllllllllllIIllIlllIllllIllll.getX() + llllllllllllllIIllIlllIlllllIlII.getFrontOffsetX();
                final double llllllllllllllIIllIlllIlllllIIlI = llllllllllllllIIllIlllIllllIllll.getBlockPos().getY() + 0.2f;
                final double llllllllllllllIIllIlllIlllllIIIl = llllllllllllllIIllIlllIllllIllll.getZ() + llllllllllllllIIllIlllIlllllIlII.getFrontOffsetZ();
                final EntityFireworkRocket llllllllllllllIIllIlllIlllllIIII = new EntityFireworkRocket(llllllllllllllIIllIlllIllllIllll.getWorld(), llllllllllllllIIllIlllIlllllIIll, llllllllllllllIIllIlllIlllllIIlI, llllllllllllllIIllIlllIlllllIIIl, llllllllllllllIIllIlllIlllllIlIl);
                llllllllllllllIIllIlllIllllIllll.getWorld().spawnEntityInWorld(llllllllllllllIIllIlllIlllllIIII);
                llllllllllllllIIllIlllIlllllIlIl.splitStack(1);
                return llllllllllllllIIllIlllIlllllIlIl;
            }
            
            static {
                __OBFID = "CL_00001411";
            }
            
            @Override
            protected void playDispenseSound(final IBlockSource llllllllllllllIIllIlllIllllIIlIl) {
                llllllllllllllIIllIlllIllllIIlIl.getWorld().playAuxSFX(1002, llllllllllllllIIllIlllIllllIIlIl.getBlockPos(), 0);
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.fire_charge, new BehaviorDefaultDispenseItem() {
            @Override
            protected void playDispenseSound(final IBlockSource llllllllllllllIIlIIlIIlIIlIIlllI) {
                llllllllllllllIIlIIlIIlIIlIIlllI.getWorld().playAuxSFX(1009, llllllllllllllIIlIIlIIlIIlIIlllI.getBlockPos(), 0);
            }
            
            static {
                __OBFID = "CL_00001412";
            }
            
            public ItemStack dispenseStack(final IBlockSource llllllllllllllIIlIIlIIlIIlIlllII, final ItemStack llllllllllllllIIlIIlIIlIIlIllIlI) {
                final EnumFacing llllllllllllllIIlIIlIIlIIllIIllI = BlockDispenser.getFacing(llllllllllllllIIlIIlIIlIIlIlllII.getBlockMetadata());
                final IPosition llllllllllllllIIlIIlIIlIIllIIlIl = BlockDispenser.getDispensePosition(llllllllllllllIIlIIlIIlIIlIlllII);
                final double llllllllllllllIIlIIlIIlIIllIIlII = llllllllllllllIIlIIlIIlIIllIIlIl.getX() + llllllllllllllIIlIIlIIlIIllIIllI.getFrontOffsetX() * 0.3f;
                final double llllllllllllllIIlIIlIIlIIllIIIll = llllllllllllllIIlIIlIIlIIllIIlIl.getY() + llllllllllllllIIlIIlIIlIIllIIllI.getFrontOffsetX() * 0.3f;
                final double llllllllllllllIIlIIlIIlIIllIIIlI = llllllllllllllIIlIIlIIlIIllIIlIl.getZ() + llllllllllllllIIlIIlIIlIIllIIllI.getFrontOffsetZ() * 0.3f;
                final World llllllllllllllIIlIIlIIlIIllIIIIl = llllllllllllllIIlIIlIIlIIlIlllII.getWorld();
                final Random llllllllllllllIIlIIlIIlIIllIIIII = llllllllllllllIIlIIlIIlIIllIIIIl.rand;
                final double llllllllllllllIIlIIlIIlIIlIlllll = llllllllllllllIIlIIlIIlIIllIIIII.nextGaussian() * 0.05 + llllllllllllllIIlIIlIIlIIllIIllI.getFrontOffsetX();
                final double llllllllllllllIIlIIlIIlIIlIllllI = llllllllllllllIIlIIlIIlIIllIIIII.nextGaussian() * 0.05 + llllllllllllllIIlIIlIIlIIllIIllI.getFrontOffsetY();
                final double llllllllllllllIIlIIlIIlIIlIlllIl = llllllllllllllIIlIIlIIlIIllIIIII.nextGaussian() * 0.05 + llllllllllllllIIlIIlIIlIIllIIllI.getFrontOffsetZ();
                llllllllllllllIIlIIlIIlIIllIIIIl.spawnEntityInWorld(new EntitySmallFireball(llllllllllllllIIlIIlIIlIIllIIIIl, llllllllllllllIIlIIlIIlIIllIIlII, llllllllllllllIIlIIlIIlIIllIIIll, llllllllllllllIIlIIlIIlIIllIIIlI, llllllllllllllIIlIIlIIlIIlIlllll, llllllllllllllIIlIIlIIlIIlIllllI, llllllllllllllIIlIIlIIlIIlIlllIl));
                llllllllllllllIIlIIlIIlIIlIllIlI.splitStack(1);
                return llllllllllllllIIlIIlIIlIIlIllIlI;
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.boat, new BehaviorDefaultDispenseItem() {
            private final /* synthetic */ BehaviorDefaultDispenseItem field_150842_b = new BehaviorDefaultDispenseItem();
            
            public ItemStack dispenseStack(final IBlockSource lllllllllllllllIIIIIlIlllllIlIll, final ItemStack lllllllllllllllIIIIIlIllllIlllIl) {
                final EnumFacing lllllllllllllllIIIIIlIlllllIlIIl = BlockDispenser.getFacing(lllllllllllllllIIIIIlIlllllIlIll.getBlockMetadata());
                final World lllllllllllllllIIIIIlIlllllIlIII = lllllllllllllllIIIIIlIlllllIlIll.getWorld();
                final double lllllllllllllllIIIIIlIlllllIIlll = lllllllllllllllIIIIIlIlllllIlIll.getX() + lllllllllllllllIIIIIlIlllllIlIIl.getFrontOffsetX() * 1.125f;
                final double lllllllllllllllIIIIIlIlllllIIllI = lllllllllllllllIIIIIlIlllllIlIll.getY() + lllllllllllllllIIIIIlIlllllIlIIl.getFrontOffsetY() * 1.125f;
                final double lllllllllllllllIIIIIlIlllllIIlIl = lllllllllllllllIIIIIlIlllllIlIll.getZ() + lllllllllllllllIIIIIlIlllllIlIIl.getFrontOffsetZ() * 1.125f;
                final BlockPos lllllllllllllllIIIIIlIlllllIIlII = lllllllllllllllIIIIIlIlllllIlIll.getBlockPos().offset(lllllllllllllllIIIIIlIlllllIlIIl);
                final Material lllllllllllllllIIIIIlIlllllIIIll = lllllllllllllllIIIIIlIlllllIlIII.getBlockState(lllllllllllllllIIIIIlIlllllIIlII).getBlock().getMaterial();
                double lllllllllllllllIIIIIlIlllllIIIIl = 0.0;
                if (Material.water.equals(lllllllllllllllIIIIIlIlllllIIIll)) {
                    final double lllllllllllllllIIIIIlIlllllIIIlI = 1.0;
                }
                else {
                    if (!Material.air.equals(lllllllllllllllIIIIIlIlllllIIIll) || !Material.water.equals(lllllllllllllllIIIIIlIlllllIlIII.getBlockState(lllllllllllllllIIIIIlIlllllIIlII.offsetDown()).getBlock().getMaterial())) {
                        return this.field_150842_b.dispense(lllllllllllllllIIIIIlIlllllIlIll, lllllllllllllllIIIIIlIllllIlllIl);
                    }
                    lllllllllllllllIIIIIlIlllllIIIIl = 0.0;
                }
                final EntityBoat lllllllllllllllIIIIIlIlllllIIIII = new EntityBoat(lllllllllllllllIIIIIlIlllllIlIII, lllllllllllllllIIIIIlIlllllIIlll, lllllllllllllllIIIIIlIlllllIIllI + lllllllllllllllIIIIIlIlllllIIIIl, lllllllllllllllIIIIIlIlllllIIlIl);
                lllllllllllllllIIIIIlIlllllIlIII.spawnEntityInWorld(lllllllllllllllIIIIIlIlllllIIIII);
                lllllllllllllllIIIIIlIllllIlllIl.splitStack(1);
                return lllllllllllllllIIIIIlIllllIlllIl;
            }
            
            @Override
            protected void playDispenseSound(final IBlockSource lllllllllllllllIIIIIlIllllIlIIII) {
                lllllllllllllllIIIIIlIllllIlIIII.getWorld().playAuxSFX(1000, lllllllllllllllIIIIIlIllllIlIIII.getBlockPos(), 0);
            }
            
            static {
                __OBFID = "CL_00001413";
            }
        });
        final BehaviorDefaultDispenseItem llllllllllllllllIIIIlIlllIIlllIl = new BehaviorDefaultDispenseItem() {
            private final /* synthetic */ BehaviorDefaultDispenseItem field_150841_b = new BehaviorDefaultDispenseItem();
            
            static {
                __OBFID = "CL_00001399";
            }
            
            public ItemStack dispenseStack(final IBlockSource llllllllllllllllIllIIIlIIlIIllII, final ItemStack llllllllllllllllIllIIIlIIlIIlIll) {
                final ItemBucket llllllllllllllllIllIIIlIIlIIlIlI = (ItemBucket)llllllllllllllllIllIIIlIIlIIlIll.getItem();
                final BlockPos llllllllllllllllIllIIIlIIlIIlIIl = llllllllllllllllIllIIIlIIlIIllII.getBlockPos().offset(BlockDispenser.getFacing(llllllllllllllllIllIIIlIIlIIllII.getBlockMetadata()));
                if (llllllllllllllllIllIIIlIIlIIlIlI.func_180616_a(llllllllllllllllIllIIIlIIlIIllII.getWorld(), llllllllllllllllIllIIIlIIlIIlIIl)) {
                    llllllllllllllllIllIIIlIIlIIlIll.setItem(Items.bucket);
                    llllllllllllllllIllIIIlIIlIIlIll.stackSize = 1;
                    return llllllllllllllllIllIIIlIIlIIlIll;
                }
                return this.field_150841_b.dispense(llllllllllllllllIllIIIlIIlIIllII, llllllllllllllllIllIIIlIIlIIlIll);
            }
        };
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.lava_bucket, llllllllllllllllIIIIlIlllIIlllIl);
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.water_bucket, llllllllllllllllIIIIlIlllIIlllIl);
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.bucket, new BehaviorDefaultDispenseItem() {
            private final /* synthetic */ BehaviorDefaultDispenseItem field_150840_b = new BehaviorDefaultDispenseItem();
            
            static {
                __OBFID = "CL_00001400";
            }
            
            public ItemStack dispenseStack(final IBlockSource llllllllllllllIlIIlllIlIlIlllIIl, final ItemStack llllllllllllllIlIIlllIlIlIlllIII) {
                final World llllllllllllllIlIIlllIlIlIllIlll = llllllllllllllIlIIlllIlIlIlllIIl.getWorld();
                final BlockPos llllllllllllllIlIIlllIlIlIllIllI = llllllllllllllIlIIlllIlIlIlllIIl.getBlockPos().offset(BlockDispenser.getFacing(llllllllllllllIlIIlllIlIlIlllIIl.getBlockMetadata()));
                final IBlockState llllllllllllllIlIIlllIlIlIllIlIl = llllllllllllllIlIIlllIlIlIllIlll.getBlockState(llllllllllllllIlIIlllIlIlIllIllI);
                final Block llllllllllllllIlIIlllIlIlIllIlII = llllllllllllllIlIIlllIlIlIllIlIl.getBlock();
                final Material llllllllllllllIlIIlllIlIlIllIIll = llllllllllllllIlIIlllIlIlIllIlII.getMaterial();
                Item llllllllllllllIlIIlllIlIlIllIIIl = null;
                if (Material.water.equals(llllllllllllllIlIIlllIlIlIllIIll) && llllllllllllllIlIIlllIlIlIllIlII instanceof BlockLiquid && (int)llllllllllllllIlIIlllIlIlIllIlIl.getValue(BlockLiquid.LEVEL) == 0) {
                    final Item llllllllllllllIlIIlllIlIlIllIIlI = Items.water_bucket;
                }
                else {
                    if (!Material.lava.equals(llllllllllllllIlIIlllIlIlIllIIll) || !(llllllllllllllIlIIlllIlIlIllIlII instanceof BlockLiquid) || (int)llllllllllllllIlIIlllIlIlIllIlIl.getValue(BlockLiquid.LEVEL) != 0) {
                        return super.dispenseStack(llllllllllllllIlIIlllIlIlIlllIIl, llllllllllllllIlIIlllIlIlIlllIII);
                    }
                    llllllllllllllIlIIlllIlIlIllIIIl = Items.lava_bucket;
                }
                llllllllllllllIlIIlllIlIlIllIlll.setBlockToAir(llllllllllllllIlIIlllIlIlIllIllI);
                final int stackSize = llllllllllllllIlIIlllIlIlIlllIII.stackSize - 1;
                llllllllllllllIlIIlllIlIlIlllIII.stackSize = stackSize;
                if (stackSize == 0) {
                    llllllllllllllIlIIlllIlIlIlllIII.setItem(llllllllllllllIlIIlllIlIlIllIIIl);
                    llllllllllllllIlIIlllIlIlIlllIII.stackSize = 1;
                }
                else if (((TileEntityDispenser)llllllllllllllIlIIlllIlIlIlllIIl.getBlockTileEntity()).func_146019_a(new ItemStack(llllllllllllllIlIIlllIlIlIllIIIl)) < 0) {
                    this.field_150840_b.dispense(llllllllllllllIlIIlllIlIlIlllIIl, new ItemStack(llllllllllllllIlIIlllIlIlIllIIIl));
                }
                return llllllllllllllIlIIlllIlIlIlllIII;
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.flint_and_steel, new BehaviorDefaultDispenseItem() {
            private /* synthetic */ boolean field_150839_b = true;
            
            @Override
            protected void playDispenseSound(final IBlockSource lllIlllIIIIIIlI) {
                if (this.field_150839_b) {
                    lllIlllIIIIIIlI.getWorld().playAuxSFX(1000, lllIlllIIIIIIlI.getBlockPos(), 0);
                }
                else {
                    lllIlllIIIIIIlI.getWorld().playAuxSFX(1001, lllIlllIIIIIIlI.getBlockPos(), 0);
                }
            }
            
            @Override
            protected ItemStack dispenseStack(final IBlockSource lllIlllIIIlIIIl, final ItemStack lllIlllIIIlIIII) {
                final World lllIlllIIIlIlIl = lllIlllIIIlIIIl.getWorld();
                final BlockPos lllIlllIIIlIIll = lllIlllIIIlIIIl.getBlockPos().offset(BlockDispenser.getFacing(lllIlllIIIlIIIl.getBlockMetadata()));
                if (lllIlllIIIlIlIl.isAirBlock(lllIlllIIIlIIll)) {
                    lllIlllIIIlIlIl.setBlockState(lllIlllIIIlIIll, Blocks.fire.getDefaultState());
                    if (lllIlllIIIlIIII.attemptDamageItem(1, lllIlllIIIlIlIl.rand)) {
                        lllIlllIIIlIIII.stackSize = 0;
                    }
                }
                else if (lllIlllIIIlIlIl.getBlockState(lllIlllIIIlIIll).getBlock() == Blocks.tnt) {
                    Blocks.tnt.onBlockDestroyedByPlayer(lllIlllIIIlIlIl, lllIlllIIIlIIll, Blocks.tnt.getDefaultState().withProperty(BlockTNT.field_176246_a, true));
                    lllIlllIIIlIlIl.setBlockToAir(lllIlllIIIlIIll);
                }
                else {
                    this.field_150839_b = false;
                }
                return lllIlllIIIlIIII;
            }
            
            static {
                __OBFID = "CL_00001401";
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.dye, new BehaviorDefaultDispenseItem() {
            private /* synthetic */ boolean field_150838_b = true;
            
            static {
                __OBFID = "CL_00001402";
            }
            
            @Override
            protected ItemStack dispenseStack(final IBlockSource llllllllllllllIllIIllIIIlIIllIlI, final ItemStack llllllllllllllIllIIllIIIlIIllllI) {
                if (EnumDyeColor.WHITE == EnumDyeColor.func_176766_a(llllllllllllllIllIIllIIIlIIllllI.getMetadata())) {
                    final World llllllllllllllIllIIllIIIlIIlllIl = llllllllllllllIllIIllIIIlIIllIlI.getWorld();
                    final BlockPos llllllllllllllIllIIllIIIlIIlllII = llllllllllllllIllIIllIIIlIIllIlI.getBlockPos().offset(BlockDispenser.getFacing(llllllllllllllIllIIllIIIlIIllIlI.getBlockMetadata()));
                    if (ItemDye.func_179234_a(llllllllllllllIllIIllIIIlIIllllI, llllllllllllllIllIIllIIIlIIlllIl, llllllllllllllIllIIllIIIlIIlllII)) {
                        if (!llllllllllllllIllIIllIIIlIIlllIl.isRemote) {
                            llllllllllllllIllIIllIIIlIIlllIl.playAuxSFX(2005, llllllllllllllIllIIllIIIlIIlllII, 0);
                        }
                    }
                    else {
                        this.field_150838_b = false;
                    }
                    return llllllllllllllIllIIllIIIlIIllllI;
                }
                return super.dispenseStack(llllllllllllllIllIIllIIIlIIllIlI, llllllllllllllIllIIllIIIlIIllllI);
            }
            
            @Override
            protected void playDispenseSound(final IBlockSource llllllllllllllIllIIllIIIlIIlIIIl) {
                if (this.field_150838_b) {
                    llllllllllllllIllIIllIIIlIIlIIIl.getWorld().playAuxSFX(1000, llllllllllllllIllIIllIIIlIIlIIIl.getBlockPos(), 0);
                }
                else {
                    llllllllllllllIllIIllIIIlIIlIIIl.getWorld().playAuxSFX(1001, llllllllllllllIllIIllIIIlIIlIIIl.getBlockPos(), 0);
                }
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Item.getItemFromBlock(Blocks.tnt), new BehaviorDefaultDispenseItem() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource llllllllllllllllIlllIlIlIIIlllII, final ItemStack llllllllllllllllIlllIlIlIIIllIll) {
                final World llllllllllllllllIlllIlIlIIIllIlI = llllllllllllllllIlllIlIlIIIlllII.getWorld();
                final BlockPos llllllllllllllllIlllIlIlIIIllIIl = llllllllllllllllIlllIlIlIIIlllII.getBlockPos().offset(BlockDispenser.getFacing(llllllllllllllllIlllIlIlIIIlllII.getBlockMetadata()));
                final EntityTNTPrimed llllllllllllllllIlllIlIlIIIllIII = new EntityTNTPrimed(llllllllllllllllIlllIlIlIIIllIlI, llllllllllllllllIlllIlIlIIIllIIl.getX() + 0.5, llllllllllllllllIlllIlIlIIIllIIl.getY(), llllllllllllllllIlllIlIlIIIllIIl.getZ() + 0.5, null);
                llllllllllllllllIlllIlIlIIIllIlI.spawnEntityInWorld(llllllllllllllllIlllIlIlIIIllIII);
                llllllllllllllllIlllIlIlIIIllIlI.playSoundAtEntity(llllllllllllllllIlllIlIlIIIllIII, "game.tnt.primed", 1.0f, 1.0f);
                --llllllllllllllllIlllIlIlIIIllIll.stackSize;
                return llllllllllllllllIlllIlIlIIIllIll;
            }
            
            static {
                __OBFID = "CL_00001403";
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Items.skull, new BehaviorDefaultDispenseItem() {
            private /* synthetic */ boolean field_179240_b = true;
            
            @Override
            protected ItemStack dispenseStack(final IBlockSource lllllllllllllllllIIlIIIlllIIIlll, final ItemStack lllllllllllllllllIIlIIIlllIlIIII) {
                final World lllllllllllllllllIIlIIIlllIIllll = lllllllllllllllllIIlIIIlllIIIlll.getWorld();
                final EnumFacing lllllllllllllllllIIlIIIlllIIlllI = BlockDispenser.getFacing(lllllllllllllllllIIlIIIlllIIIlll.getBlockMetadata());
                final BlockPos lllllllllllllllllIIlIIIlllIIllIl = lllllllllllllllllIIlIIIlllIIIlll.getBlockPos().offset(lllllllllllllllllIIlIIIlllIIlllI);
                final BlockSkull lllllllllllllllllIIlIIIlllIIllII = Blocks.skull;
                if (lllllllllllllllllIIlIIIlllIIllll.isAirBlock(lllllllllllllllllIIlIIIlllIIllIl) && lllllllllllllllllIIlIIIlllIIllII.func_176415_b(lllllllllllllllllIIlIIIlllIIllll, lllllllllllllllllIIlIIIlllIIllIl, lllllllllllllllllIIlIIIlllIlIIII)) {
                    if (!lllllllllllllllllIIlIIIlllIIllll.isRemote) {
                        lllllllllllllllllIIlIIIlllIIllll.setBlockState(lllllllllllllllllIIlIIIlllIIllIl, lllllllllllllllllIIlIIIlllIIllII.getDefaultState().withProperty(BlockSkull.field_176418_a, EnumFacing.UP), 3);
                        final TileEntity lllllllllllllllllIIlIIIlllIIlIll = lllllllllllllllllIIlIIIlllIIllll.getTileEntity(lllllllllllllllllIIlIIIlllIIllIl);
                        if (lllllllllllllllllIIlIIIlllIIlIll instanceof TileEntitySkull) {
                            if (lllllllllllllllllIIlIIIlllIlIIII.getMetadata() == 3) {
                                GameProfile lllllllllllllllllIIlIIIlllIIlIlI = null;
                                if (lllllllllllllllllIIlIIIlllIlIIII.hasTagCompound()) {
                                    final NBTTagCompound lllllllllllllllllIIlIIIlllIIlIIl = lllllllllllllllllIIlIIIlllIlIIII.getTagCompound();
                                    if (lllllllllllllllllIIlIIIlllIIlIIl.hasKey("SkullOwner", 10)) {
                                        lllllllllllllllllIIlIIIlllIIlIlI = NBTUtil.readGameProfileFromNBT(lllllllllllllllllIIlIIIlllIIlIIl.getCompoundTag("SkullOwner"));
                                    }
                                    else if (lllllllllllllllllIIlIIIlllIIlIIl.hasKey("SkullOwner", 8)) {
                                        lllllllllllllllllIIlIIIlllIIlIlI = new GameProfile((UUID)null, lllllllllllllllllIIlIIIlllIIlIIl.getString("SkullOwner"));
                                    }
                                }
                                ((TileEntitySkull)lllllllllllllllllIIlIIIlllIIlIll).setPlayerProfile(lllllllllllllllllIIlIIIlllIIlIlI);
                            }
                            else {
                                ((TileEntitySkull)lllllllllllllllllIIlIIIlllIIlIll).setType(lllllllllllllllllIIlIIIlllIlIIII.getMetadata());
                            }
                            ((TileEntitySkull)lllllllllllllllllIIlIIIlllIIlIll).setSkullRotation(lllllllllllllllllIIlIIIlllIIlllI.getOpposite().getHorizontalIndex() * 4);
                            Blocks.skull.func_180679_a(lllllllllllllllllIIlIIIlllIIllll, lllllllllllllllllIIlIIIlllIIllIl, (TileEntitySkull)lllllllllllllllllIIlIIIlllIIlIll);
                        }
                        --lllllllllllllllllIIlIIIlllIlIIII.stackSize;
                    }
                }
                else {
                    this.field_179240_b = false;
                }
                return lllllllllllllllllIIlIIIlllIlIIII;
            }
            
            static {
                __OBFID = "CL_00002278";
            }
            
            @Override
            protected void playDispenseSound(final IBlockSource lllllllllllllllllIIlIIIllIlllIIl) {
                if (this.field_179240_b) {
                    lllllllllllllllllIIlIIIllIlllIIl.getWorld().playAuxSFX(1000, lllllllllllllllllIIlIIIllIlllIIl.getBlockPos(), 0);
                }
                else {
                    lllllllllllllllllIIlIIIllIlllIIl.getWorld().playAuxSFX(1001, lllllllllllllllllIIlIIIllIlllIIl.getBlockPos(), 0);
                }
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Item.getItemFromBlock(Blocks.pumpkin), new BehaviorDefaultDispenseItem() {
            private /* synthetic */ boolean field_179241_b = true;
            
            @Override
            protected void playDispenseSound(final IBlockSource llllllllllllllIlIlllIllIIIIIlIll) {
                if (this.field_179241_b) {
                    llllllllllllllIlIlllIllIIIIIlIll.getWorld().playAuxSFX(1000, llllllllllllllIlIlllIllIIIIIlIll.getBlockPos(), 0);
                }
                else {
                    llllllllllllllIlIlllIllIIIIIlIll.getWorld().playAuxSFX(1001, llllllllllllllIlIlllIllIIIIIlIll.getBlockPos(), 0);
                }
            }
            
            static {
                __OBFID = "CL_00002277";
            }
            
            @Override
            protected ItemStack dispenseStack(final IBlockSource llllllllllllllIlIlllIllIIIIllIIl, final ItemStack llllllllllllllIlIlllIllIIIIlIIlI) {
                final World llllllllllllllIlIlllIllIIIIlIlll = llllllllllllllIlIlllIllIIIIllIIl.getWorld();
                final BlockPos llllllllllllllIlIlllIllIIIIlIllI = llllllllllllllIlIlllIllIIIIllIIl.getBlockPos().offset(BlockDispenser.getFacing(llllllllllllllIlIlllIllIIIIllIIl.getBlockMetadata()));
                final BlockPumpkin llllllllllllllIlIlllIllIIIIlIlIl = (BlockPumpkin)Blocks.pumpkin;
                if (llllllllllllllIlIlllIllIIIIlIlll.isAirBlock(llllllllllllllIlIlllIllIIIIlIllI) && llllllllllllllIlIlllIllIIIIlIlIl.func_176390_d(llllllllllllllIlIlllIllIIIIlIlll, llllllllllllllIlIlllIllIIIIlIllI)) {
                    if (!llllllllllllllIlIlllIllIIIIlIlll.isRemote) {
                        llllllllllllllIlIlllIllIIIIlIlll.setBlockState(llllllllllllllIlIlllIllIIIIlIllI, llllllllllllllIlIlllIllIIIIlIlIl.getDefaultState(), 3);
                    }
                    --llllllllllllllIlIlllIllIIIIlIIlI.stackSize;
                }
                else {
                    this.field_179241_b = false;
                }
                return llllllllllllllIlIlllIllIIIIlIIlI;
            }
        });
        BlockDispenser.dispenseBehaviorRegistry.putObject(Item.getItemFromBlock(Blocks.command_block), new BehaviorDefaultDispenseItem() {
            @Override
            protected void playDispenseSound(final IBlockSource lIllllIIlIllII) {
            }
            
            @Override
            protected ItemStack dispenseStack(final IBlockSource lIllllIIllIlll, final ItemStack lIllllIIllIIIl) {
                final World lIllllIIllIlIl = lIllllIIllIlll.getWorld();
                final BlockPos lIllllIIllIlII = lIllllIIllIlll.getBlockPos().offset(BlockDispenser.getFacing(lIllllIIllIlll.getBlockMetadata()));
                if (lIllllIIllIlIl.isAirBlock(lIllllIIllIlII)) {
                    if (!lIllllIIllIlIl.isRemote) {
                        final IBlockState lIllllIIllIIll = Blocks.command_block.getDefaultState().withProperty(BlockCommandBlock.TRIGGERED_PROP, false);
                        lIllllIIllIlIl.setBlockState(lIllllIIllIlII, lIllllIIllIIll, 3);
                        ItemBlock.setTileEntityNBT(lIllllIIllIlIl, lIllllIIllIlII, lIllllIIllIIIl);
                        lIllllIIllIlIl.notifyNeighborsOfStateChange(lIllllIIllIlll.getBlockPos(), lIllllIIllIlll.getBlock());
                    }
                    --lIllllIIllIIIl.stackSize;
                }
                return lIllllIIllIIIl;
            }
            
            @Override
            protected void spawnDispenseParticles(final IBlockSource lIllllIIlIlIlI, final EnumFacing lIllllIIlIlIIl) {
            }
            
            static {
                __OBFID = "CL_00002276";
            }
        });
    }
    
    public static void func_179870_a(final String llllllllllllllllIIIIlIlllIIllIIl) {
        Bootstrap.SYSOUT.println(llllllllllllllllIIIIlIlllIIllIIl);
    }
    
    public static void register() {
        if (!Bootstrap.alreadyRegistered) {
            Bootstrap.alreadyRegistered = true;
            if (Bootstrap.LOGGER.isDebugEnabled()) {
                redirectOutputToLog();
            }
            Block.registerBlocks();
            BlockFire.func_149843_e();
            Item.registerItems();
            StatList.func_151178_a();
            registerDispenserBehaviors();
        }
    }
    
    private static void redirectOutputToLog() {
        System.setErr(new LoggingPrintStream("STDERR", System.err));
        System.setOut(new LoggingPrintStream("STDOUT", Bootstrap.SYSOUT));
    }
    
    static {
        __OBFID = "CL_00001397";
        SYSOUT = System.out;
        Bootstrap.alreadyRegistered = false;
        LOGGER = LogManager.getLogger();
    }
    
    public static boolean isRegistered() {
        return Bootstrap.alreadyRegistered;
    }
}
