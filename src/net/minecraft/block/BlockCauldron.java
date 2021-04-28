package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.block.state.*;

public class BlockCauldron extends Block
{
    public static final /* synthetic */ PropertyInteger field_176591_a;
    
    @Override
    public void fillWithRain(final World llllllllllllllIIIIllIIlllIllIlII, final BlockPos llllllllllllllIIIIllIIlllIllIIll) {
        if (llllllllllllllIIIIllIIlllIllIlII.rand.nextInt(20) == 1) {
            final IBlockState llllllllllllllIIIIllIIlllIllIlIl = llllllllllllllIIIIllIIlllIllIlII.getBlockState(llllllllllllllIIIIllIIlllIllIIll);
            if ((int)llllllllllllllIIIIllIIlllIllIlIl.getValue(BlockCauldron.field_176591_a) < 3) {
                llllllllllllllIIIIllIIlllIllIlII.setBlockState(llllllllllllllIIIIllIIlllIllIIll, llllllllllllllIIIIllIIlllIllIlIl.cycleProperty(BlockCauldron.field_176591_a), 2);
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIIllIIlllIIllIIl) {
        return (int)llllllllllllllIIIIllIIlllIIllIIl.getValue(BlockCauldron.field_176591_a);
    }
    
    public BlockCauldron() {
        super(Material.iron);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockCauldron.field_176591_a, 0));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIIllIIlllIIlllll) {
        return this.getDefaultState().withProperty(BlockCauldron.field_176591_a, llllllllllllllIIIIllIIlllIIlllll);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllllIIIIllIIllllllIIll, final BlockPos llllllllllllllIIIIllIIlllllllIIl, final IBlockState llllllllllllllIIIIllIIlllllllIII, final Entity llllllllllllllIIIIllIIllllllIIII) {
        final int llllllllllllllIIIIllIIllllllIllI = (int)llllllllllllllIIIIllIIlllllllIII.getValue(BlockCauldron.field_176591_a);
        final float llllllllllllllIIIIllIIllllllIlIl = llllllllllllllIIIIllIIlllllllIIl.getY() + (6.0f + 3 * llllllllllllllIIIIllIIllllllIllI) / 16.0f;
        if (!llllllllllllllIIIIllIIllllllIIll.isRemote && llllllllllllllIIIIllIIllllllIIII.isBurning() && llllllllllllllIIIIllIIllllllIllI > 0 && llllllllllllllIIIIllIIllllllIIII.getEntityBoundingBox().minY <= llllllllllllllIIIIllIIllllllIlIl) {
            llllllllllllllIIIIllIIllllllIIII.extinguish();
            this.func_176590_a(llllllllllllllIIIIllIIllllllIIll, llllllllllllllIIIIllIIlllllllIIl, llllllllllllllIIIIllIIlllllllIII, llllllllllllllIIIIllIIllllllIllI - 1);
        }
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIIIllIIlllllIIIlI, final BlockPos llllllllllllllIIIIllIIllllIlIIlI, final IBlockState llllllllllllllIIIIllIIllllIlIIIl, final EntityPlayer llllllllllllllIIIIllIIllllIlIIII, final EnumFacing llllllllllllllIIIIllIIllllIllllI, final float llllllllllllllIIIIllIIllllIlllIl, final float llllllllllllllIIIIllIIllllIlllII, final float llllllllllllllIIIIllIIllllIllIll) {
        if (llllllllllllllIIIIllIIlllllIIIlI.isRemote) {
            return true;
        }
        final ItemStack llllllllllllllIIIIllIIllllIllIlI = llllllllllllllIIIIllIIllllIlIIII.inventory.getCurrentItem();
        if (llllllllllllllIIIIllIIllllIllIlI == null) {
            return true;
        }
        final int llllllllllllllIIIIllIIllllIllIIl = (int)llllllllllllllIIIIllIIllllIlIIIl.getValue(BlockCauldron.field_176591_a);
        final Item llllllllllllllIIIIllIIllllIllIII = llllllllllllllIIIIllIIllllIllIlI.getItem();
        if (llllllllllllllIIIIllIIllllIllIII == Items.water_bucket) {
            if (llllllllllllllIIIIllIIllllIllIIl < 3) {
                if (!llllllllllllllIIIIllIIllllIlIIII.capabilities.isCreativeMode) {
                    llllllllllllllIIIIllIIllllIlIIII.inventory.setInventorySlotContents(llllllllllllllIIIIllIIllllIlIIII.inventory.currentItem, new ItemStack(Items.bucket));
                }
                this.func_176590_a(llllllllllllllIIIIllIIlllllIIIlI, llllllllllllllIIIIllIIllllIlIIlI, llllllllllllllIIIIllIIllllIlIIIl, 3);
            }
            return true;
        }
        if (llllllllllllllIIIIllIIllllIllIII == Items.glass_bottle) {
            if (llllllllllllllIIIIllIIllllIllIIl > 0) {
                if (!llllllllllllllIIIIllIIllllIlIIII.capabilities.isCreativeMode) {
                    final ItemStack llllllllllllllIIIIllIIllllIlIlll = new ItemStack(Items.potionitem, 1, 0);
                    if (!llllllllllllllIIIIllIIllllIlIIII.inventory.addItemStackToInventory(llllllllllllllIIIIllIIllllIlIlll)) {
                        llllllllllllllIIIIllIIlllllIIIlI.spawnEntityInWorld(new EntityItem(llllllllllllllIIIIllIIlllllIIIlI, llllllllllllllIIIIllIIllllIlIIlI.getX() + 0.5, llllllllllllllIIIIllIIllllIlIIlI.getY() + 1.5, llllllllllllllIIIIllIIllllIlIIlI.getZ() + 0.5, llllllllllllllIIIIllIIllllIlIlll));
                    }
                    else if (llllllllllllllIIIIllIIllllIlIIII instanceof EntityPlayerMP) {
                        ((EntityPlayerMP)llllllllllllllIIIIllIIllllIlIIII).sendContainerToPlayer(llllllllllllllIIIIllIIllllIlIIII.inventoryContainer);
                    }
                    final ItemStack itemStack = llllllllllllllIIIIllIIllllIllIlI;
                    --itemStack.stackSize;
                    if (llllllllllllllIIIIllIIllllIllIlI.stackSize <= 0) {
                        llllllllllllllIIIIllIIllllIlIIII.inventory.setInventorySlotContents(llllllllllllllIIIIllIIllllIlIIII.inventory.currentItem, null);
                    }
                }
                this.func_176590_a(llllllllllllllIIIIllIIlllllIIIlI, llllllllllllllIIIIllIIllllIlIIlI, llllllllllllllIIIIllIIllllIlIIIl, llllllllllllllIIIIllIIllllIllIIl - 1);
            }
            return true;
        }
        if (llllllllllllllIIIIllIIllllIllIIl > 0 && llllllllllllllIIIIllIIllllIllIII instanceof ItemArmor) {
            final ItemArmor llllllllllllllIIIIllIIllllIlIlIl = (ItemArmor)llllllllllllllIIIIllIIllllIllIII;
            if (llllllllllllllIIIIllIIllllIlIlIl.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER && llllllllllllllIIIIllIIllllIlIlIl.hasColor(llllllllllllllIIIIllIIllllIllIlI)) {
                llllllllllllllIIIIllIIllllIlIlIl.removeColor(llllllllllllllIIIIllIIllllIllIlI);
                this.func_176590_a(llllllllllllllIIIIllIIlllllIIIlI, llllllllllllllIIIIllIIllllIlIIlI, llllllllllllllIIIIllIIllllIlIIIl, llllllllllllllIIIIllIIllllIllIIl - 1);
                return true;
            }
        }
        if (llllllllllllllIIIIllIIllllIllIIl > 0 && llllllllllllllIIIIllIIllllIllIII instanceof ItemBanner && TileEntityBanner.func_175113_c(llllllllllllllIIIIllIIllllIllIlI) > 0) {
            final ItemStack llllllllllllllIIIIllIIllllIlIllI = llllllllllllllIIIIllIIllllIllIlI.copy();
            llllllllllllllIIIIllIIllllIlIllI.stackSize = 1;
            TileEntityBanner.func_175117_e(llllllllllllllIIIIllIIllllIlIllI);
            if (llllllllllllllIIIIllIIllllIllIlI.stackSize <= 1 && !llllllllllllllIIIIllIIllllIlIIII.capabilities.isCreativeMode) {
                llllllllllllllIIIIllIIllllIlIIII.inventory.setInventorySlotContents(llllllllllllllIIIIllIIllllIlIIII.inventory.currentItem, llllllllllllllIIIIllIIllllIlIllI);
            }
            else {
                if (!llllllllllllllIIIIllIIllllIlIIII.inventory.addItemStackToInventory(llllllllllllllIIIIllIIllllIlIllI)) {
                    llllllllllllllIIIIllIIlllllIIIlI.spawnEntityInWorld(new EntityItem(llllllllllllllIIIIllIIlllllIIIlI, llllllllllllllIIIIllIIllllIlIIlI.getX() + 0.5, llllllllllllllIIIIllIIllllIlIIlI.getY() + 1.5, llllllllllllllIIIIllIIllllIlIIlI.getZ() + 0.5, llllllllllllllIIIIllIIllllIlIllI));
                }
                else if (llllllllllllllIIIIllIIllllIlIIII instanceof EntityPlayerMP) {
                    ((EntityPlayerMP)llllllllllllllIIIIllIIllllIlIIII).sendContainerToPlayer(llllllllllllllIIIIllIIllllIlIIII.inventoryContainer);
                }
                if (!llllllllllllllIIIIllIIllllIlIIII.capabilities.isCreativeMode) {
                    final ItemStack itemStack2 = llllllllllllllIIIIllIIllllIllIlI;
                    --itemStack2.stackSize;
                }
            }
            if (!llllllllllllllIIIIllIIllllIlIIII.capabilities.isCreativeMode) {
                this.func_176590_a(llllllllllllllIIIIllIIlllllIIIlI, llllllllllllllIIIIllIIllllIlIIlI, llllllllllllllIIIIllIIllllIlIIIl, llllllllllllllIIIIllIIllllIllIIl - 1);
            }
            return true;
        }
        return false;
    }
    
    public void func_176590_a(final World llllllllllllllIIIIllIIllllIIIlII, final BlockPos llllllllllllllIIIIllIIlllIlllllI, final IBlockState llllllllllllllIIIIllIIlllIllllIl, final int llllllllllllllIIIIllIIllllIIIIIl) {
        llllllllllllllIIIIllIIllllIIIlII.setBlockState(llllllllllllllIIIIllIIlllIlllllI, llllllllllllllIIIIllIIlllIllllIl.withProperty(BlockCauldron.field_176591_a, MathHelper.clamp_int(llllllllllllllIIIIllIIllllIIIIIl, 0, 3)), 2);
        llllllllllllllIIIIllIIllllIIIlII.updateComparatorOutputLevel(llllllllllllllIIIIllIIlllIlllllI, this);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIIIllIIlllIllIIII, final Random llllllllllllllIIIIllIIlllIlIllll, final int llllllllllllllIIIIllIIlllIlIlllI) {
        return Items.cauldron;
    }
    
    @Override
    public void addCollisionBoxesToList(final World llllllllllllllIIIIllIlIIIIIlIllI, final BlockPos llllllllllllllIIIIllIlIIIIIlIlIl, final IBlockState llllllllllllllIIIIllIlIIIIIIllII, final AxisAlignedBB llllllllllllllIIIIllIlIIIIIlIIll, final List llllllllllllllIIIIllIlIIIIIIlIlI, final Entity llllllllllllllIIIIllIlIIIIIlIIIl) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.3125f, 1.0f);
        super.addCollisionBoxesToList(llllllllllllllIIIIllIlIIIIIlIllI, llllllllllllllIIIIllIlIIIIIlIlIl, llllllllllllllIIIIllIlIIIIIIllII, llllllllllllllIIIIllIlIIIIIlIIll, llllllllllllllIIIIllIlIIIIIIlIlI, llllllllllllllIIIIllIlIIIIIlIIIl);
        final float llllllllllllllIIIIllIlIIIIIlIIII = 0.125f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, llllllllllllllIIIIllIlIIIIIlIIII, 1.0f, 1.0f);
        super.addCollisionBoxesToList(llllllllllllllIIIIllIlIIIIIlIllI, llllllllllllllIIIIllIlIIIIIlIlIl, llllllllllllllIIIIllIlIIIIIIllII, llllllllllllllIIIIllIlIIIIIlIIll, llllllllllllllIIIIllIlIIIIIIlIlI, llllllllllllllIIIIllIlIIIIIlIIIl);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, llllllllllllllIIIIllIlIIIIIlIIII);
        super.addCollisionBoxesToList(llllllllllllllIIIIllIlIIIIIlIllI, llllllllllllllIIIIllIlIIIIIlIlIl, llllllllllllllIIIIllIlIIIIIIllII, llllllllllllllIIIIllIlIIIIIlIIll, llllllllllllllIIIIllIlIIIIIIlIlI, llllllllllllllIIIIllIlIIIIIlIIIl);
        this.setBlockBounds(1.0f - llllllllllllllIIIIllIlIIIIIlIIII, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(llllllllllllllIIIIllIlIIIIIlIllI, llllllllllllllIIIIllIlIIIIIlIlIl, llllllllllllllIIIIllIlIIIIIIllII, llllllllllllllIIIIllIlIIIIIlIIll, llllllllllllllIIIIllIlIIIIIIlIlI, llllllllllllllIIIIllIlIIIIIlIIIl);
        this.setBlockBounds(0.0f, 0.0f, 1.0f - llllllllllllllIIIIllIlIIIIIlIIII, 1.0f, 1.0f, 1.0f);
        super.addCollisionBoxesToList(llllllllllllllIIIIllIlIIIIIlIllI, llllllllllllllIIIIllIlIIIIIlIlIl, llllllllllllllIIIIllIlIIIIIIllII, llllllllllllllIIIIllIlIIIIIlIIll, llllllllllllllIIIIllIlIIIIIIlIlI, llllllllllllllIIIIllIlIIIIIlIIIl);
        this.setBlockBoundsForItemRender();
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public Item getItem(final World llllllllllllllIIIIllIIlllIlIllII, final BlockPos llllllllllllllIIIIllIIlllIlIlIll) {
        return Items.cauldron;
    }
    
    static {
        __OBFID = "CL_00000213";
        field_176591_a = PropertyInteger.create("level", 0, 3);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockCauldron.field_176591_a });
    }
    
    @Override
    public int getComparatorInputOverride(final World llllllllllllllIIIIllIIlllIlIIllI, final BlockPos llllllllllllllIIIIllIIlllIlIIlIl) {
        return (int)llllllllllllllIIIIllIIlllIlIIllI.getBlockState(llllllllllllllIIIIllIIlllIlIIlIl).getValue(BlockCauldron.field_176591_a);
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
}
