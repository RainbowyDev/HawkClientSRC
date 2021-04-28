package net.minecraft.block;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.block.state.*;

public class BlockTNT extends Block
{
    public static final /* synthetic */ PropertyBool field_176246_a;
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIlIllIIllIIIIIllIl, final BlockPos llllllllllllllIlIllIIllIIIIIllII, final IBlockState llllllllllllllIlIllIIllIIIIIlIll, final EntityPlayer llllllllllllllIlIllIIllIIIIIlIlI, final EnumFacing llllllllllllllIlIllIIllIIIIlIIll, final float llllllllllllllIlIllIIllIIIIlIIlI, final float llllllllllllllIlIllIIllIIIIlIIIl, final float llllllllllllllIlIllIIllIIIIIIllI) {
        if (llllllllllllllIlIllIIllIIIIIlIlI.getCurrentEquippedItem() != null) {
            final Item llllllllllllllIlIllIIllIIIIIllll = llllllllllllllIlIllIIllIIIIIlIlI.getCurrentEquippedItem().getItem();
            if (llllllllllllllIlIllIIllIIIIIllll == Items.flint_and_steel || llllllllllllllIlIllIIllIIIIIllll == Items.fire_charge) {
                this.func_180692_a(llllllllllllllIlIllIIllIIIIIllIl, llllllllllllllIlIllIIllIIIIIllII, llllllllllllllIlIllIIllIIIIIlIll.withProperty(BlockTNT.field_176246_a, true), llllllllllllllIlIllIIllIIIIIlIlI);
                llllllllllllllIlIllIIllIIIIIllIl.setBlockToAir(llllllllllllllIlIllIIllIIIIIllII);
                if (llllllllllllllIlIllIIllIIIIIllll == Items.flint_and_steel) {
                    llllllllllllllIlIllIIllIIIIIlIlI.getCurrentEquippedItem().damageItem(1, llllllllllllllIlIllIIllIIIIIlIlI);
                }
                else if (!llllllllllllllIlIllIIllIIIIIlIlI.capabilities.isCreativeMode) {
                    final ItemStack currentEquippedItem = llllllllllllllIlIllIIllIIIIIlIlI.getCurrentEquippedItem();
                    --currentEquippedItem.stackSize;
                }
                return true;
            }
        }
        return super.onBlockActivated(llllllllllllllIlIllIIllIIIIIllIl, llllllllllllllIlIllIIllIIIIIllII, llllllllllllllIlIllIIllIIIIIlIll, llllllllllllllIlIllIIllIIIIIlIlI, llllllllllllllIlIllIIllIIIIlIIll, llllllllllllllIlIllIIllIIIIlIIlI, llllllllllllllIlIllIIllIIIIlIIIl, llllllllllllllIlIllIIllIIIIIIllI);
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World llllllllllllllIlIllIIllIIIlllIIl, final BlockPos llllllllllllllIlIllIIllIIIllIlII, final IBlockState llllllllllllllIlIllIIllIIIllIlll) {
        this.func_180692_a(llllllllllllllIlIllIIllIIIlllIIl, llllllllllllllIlIllIIllIIIllIlII, llllllllllllllIlIllIIllIIIllIlll, null);
    }
    
    static {
        __OBFID = "CL_00000324";
        field_176246_a = PropertyBool.create("explode");
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIllIIlIllllIlIlI) {
        return ((boolean)llllllllllllllIlIllIIlIllllIlIlI.getValue(BlockTNT.field_176246_a)) ? 1 : 0;
    }
    
    public BlockTNT() {
        super(Material.tnt);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockTNT.field_176246_a, false));
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }
    
    @Override
    public void onBlockDestroyedByExplosion(final World llllllllllllllIlIllIIllIIlIIIllI, final BlockPos llllllllllllllIlIllIIllIIlIIIlIl, final Explosion llllllllllllllIlIllIIllIIlIIIIII) {
        if (!llllllllllllllIlIllIIllIIlIIIllI.isRemote) {
            final EntityTNTPrimed llllllllllllllIlIllIIllIIlIIIIll = new EntityTNTPrimed(llllllllllllllIlIllIIllIIlIIIllI, llllllllllllllIlIllIIllIIlIIIlIl.getX() + 0.5f, llllllllllllllIlIllIIllIIlIIIlIl.getY() + 0.5f, llllllllllllllIlIllIIllIIlIIIlIl.getZ() + 0.5f, llllllllllllllIlIllIIllIIlIIIIII.getExplosivePlacedBy());
            llllllllllllllIlIllIIllIIlIIIIll.fuse = llllllllllllllIlIllIIllIIlIIIllI.rand.nextInt(llllllllllllllIlIllIIllIIlIIIIll.fuse / 4) + llllllllllllllIlIllIIllIIlIIIIll.fuse / 8;
            llllllllllllllIlIllIIllIIlIIIllI.spawnEntityInWorld(llllllllllllllIlIllIIllIIlIIIIll);
        }
    }
    
    @Override
    public void onNeighborBlockChange(final World llllllllllllllIlIllIIllIIlIlIIll, final BlockPos llllllllllllllIlIllIIllIIlIIllIl, final IBlockState llllllllllllllIlIllIIllIIlIIllII, final Block llllllllllllllIlIllIIllIIlIlIIII) {
        if (llllllllllllllIlIllIIllIIlIlIIll.isBlockPowered(llllllllllllllIlIllIIllIIlIIllIl)) {
            this.onBlockDestroyedByPlayer(llllllllllllllIlIllIIllIIlIlIIll, llllllllllllllIlIllIIllIIlIIllIl, llllllllllllllIlIllIIllIIlIIllII.withProperty(BlockTNT.field_176246_a, true));
            llllllllllllllIlIllIIllIIlIlIIll.setBlockToAir(llllllllllllllIlIllIIllIIlIIllIl);
        }
    }
    
    @Override
    public boolean canDropFromExplosion(final Explosion llllllllllllllIlIllIIlIlllllIIll) {
        return false;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllllIlIllIIlIllllllllI, final BlockPos llllllllllllllIlIllIIlIlllllIlll, final IBlockState llllllllllllllIlIllIIlIlllllllII, final Entity llllllllllllllIlIllIIlIllllllIll) {
        if (!llllllllllllllIlIllIIlIllllllllI.isRemote && llllllllllllllIlIllIIlIllllllIll instanceof EntityArrow) {
            final EntityArrow llllllllllllllIlIllIIlIllllllIlI = (EntityArrow)llllllllllllllIlIllIIlIllllllIll;
            if (llllllllllllllIlIllIIlIllllllIlI.isBurning()) {
                this.func_180692_a(llllllllllllllIlIllIIlIllllllllI, llllllllllllllIlIllIIlIlllllIlll, llllllllllllllIlIllIIlIllllllllI.getBlockState(llllllllllllllIlIllIIlIlllllIlll).withProperty(BlockTNT.field_176246_a, true), (llllllllllllllIlIllIIlIllllllIlI.shootingEntity instanceof EntityLivingBase) ? ((EntityLivingBase)llllllllllllllIlIllIIlIllllllIlI.shootingEntity) : null);
                llllllllllllllIlIllIIlIllllllllI.setBlockToAir(llllllllllllllIlIllIIlIlllllIlll);
            }
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockTNT.field_176246_a });
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIlIllIIllIIlIllIll, final BlockPos llllllllllllllIlIllIIllIIlIllllI, final IBlockState llllllllllllllIlIllIIllIIlIllIIl) {
        super.onBlockAdded(llllllllllllllIlIllIIllIIlIllIll, llllllllllllllIlIllIIllIIlIllllI, llllllllllllllIlIllIIllIIlIllIIl);
        if (llllllllllllllIlIllIIllIIlIllIll.isBlockPowered(llllllllllllllIlIllIIllIIlIllllI)) {
            this.onBlockDestroyedByPlayer(llllllllllllllIlIllIIllIIlIllIll, llllllllllllllIlIllIIllIIlIllllI, llllllllllllllIlIllIIllIIlIllIIl.withProperty(BlockTNT.field_176246_a, true));
            llllllllllllllIlIllIIllIIlIllIll.setBlockToAir(llllllllllllllIlIllIIllIIlIllllI);
        }
    }
    
    public void func_180692_a(final World llllllllllllllIlIllIIllIIIlIIlll, final BlockPos llllllllllllllIlIllIIllIIIlIIllI, final IBlockState llllllllllllllIlIllIIllIIIlIIlIl, final EntityLivingBase llllllllllllllIlIllIIllIIIlIIlII) {
        if (!llllllllllllllIlIllIIllIIIlIIlll.isRemote && (boolean)llllllllllllllIlIllIIllIIIlIIlIl.getValue(BlockTNT.field_176246_a)) {
            final EntityTNTPrimed llllllllllllllIlIllIIllIIIlIlIII = new EntityTNTPrimed(llllllllllllllIlIllIIllIIIlIIlll, llllllllllllllIlIllIIllIIIlIIllI.getX() + 0.5f, llllllllllllllIlIllIIllIIIlIIllI.getY() + 0.5f, llllllllllllllIlIllIIllIIIlIIllI.getZ() + 0.5f, llllllllllllllIlIllIIllIIIlIIlII);
            llllllllllllllIlIllIIllIIIlIIlll.spawnEntityInWorld(llllllllllllllIlIllIIllIIIlIlIII);
            llllllllllllllIlIllIIllIIIlIIlll.playSoundAtEntity(llllllllllllllIlIllIIllIIIlIlIII, "game.tnt.primed", 1.0f, 1.0f);
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIllIIlIllllIllll) {
        return this.getDefaultState().withProperty(BlockTNT.field_176246_a, (llllllllllllllIlIllIIlIllllIllll & 0x1) > 0);
    }
}
