package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.entity.item.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import com.google.common.base.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class BlockAnvil extends BlockFalling
{
    public static final /* synthetic */ PropertyInteger DAMAGE;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllIIlIIlIIlIlllllIlI, final BlockPos llllllllllllllIIlIIlIIlIlllllIIl) {
        final EnumFacing llllllllllllllIIlIIlIIlIlllllIII = (EnumFacing)llllllllllllllIIlIIlIIlIlllllIlI.getBlockState(llllllllllllllIIlIIlIIlIlllllIIl).getValue(BlockAnvil.FACING);
        if (llllllllllllllIIlIIlIIlIlllllIII.getAxis() == EnumFacing.Axis.X) {
            this.setBlockBounds(0.0f, 0.0f, 0.125f, 1.0f, 1.0f, 0.875f);
        }
        else {
            this.setBlockBounds(0.125f, 0.0f, 0.0f, 0.875f, 1.0f, 1.0f);
        }
    }
    
    @Override
    protected void onStartFalling(final EntityFallingBlock llllllllllllllIIlIIlIIlIlllIlIII) {
        llllllllllllllIIlIIlIIlIlllIlIII.setHurtEntities(true);
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllIIlIIlIIlIlllIllIl, final CreativeTabs llllllllllllllIIlIIlIIlIlllIllll, final List llllllllllllllIIlIIlIIlIlllIlllI) {
        llllllllllllllIIlIIlIIlIlllIlllI.add(new ItemStack(llllllllllllllIIlIIlIIlIlllIllIl, 1, 0));
        llllllllllllllIIlIIlIIlIlllIlllI.add(new ItemStack(llllllllllllllIIlIIlIIlIlllIllIl, 1, 1));
        llllllllllllllIIlIIlIIlIlllIlllI.add(new ItemStack(llllllllllllllIIlIIlIIlIlllIllIl, 1, 2));
    }
    
    @Override
    public IBlockState getStateForEntityRender(final IBlockState llllllllllllllIIlIIlIIlIllIllIlI) {
        return this.getDefaultState().withProperty(BlockAnvil.FACING, EnumFacing.SOUTH);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllIIlIIlIIlIllIlllll, final BlockPos llllllllllllllIIlIIlIIlIllIllllI, final EnumFacing llllllllllllllIIlIIlIIlIllIlllIl) {
        return true;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public void onEndFalling(final World llllllllllllllIIlIIlIIlIlllIIlII, final BlockPos llllllllllllllIIlIIlIIlIlllIIIll) {
        llllllllllllllIIlIIlIIlIlllIIlII.playAuxSFX(1022, llllllllllllllIIlIIlIIlIlllIIIll, 0);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000192";
        FACING = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
        DAMAGE = PropertyInteger.create("damage", 0, 2);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIlIIlIIlIllIIlIll) {
        final byte llllllllllllllIIlIIlIIlIllIIllIl = 0;
        int llllllllllllllIIlIIlIIlIllIIllII = llllllllllllllIIlIIlIIlIllIIllIl | ((EnumFacing)llllllllllllllIIlIIlIIlIllIIlIll.getValue(BlockAnvil.FACING)).getHorizontalIndex();
        llllllllllllllIIlIIlIIlIllIIllII |= (int)llllllllllllllIIlIIlIIlIllIIlIll.getValue(BlockAnvil.DAMAGE) << 2;
        return llllllllllllllIIlIIlIIlIllIIllII;
    }
    
    protected BlockAnvil() {
        super(Material.anvil);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockAnvil.FACING, EnumFacing.NORTH).withProperty(BlockAnvil.DAMAGE, 0));
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockAnvil.FACING, BlockAnvil.DAMAGE });
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIlIIlIIllIIIIlllI, final BlockPos llllllllllllllIIlIIlIIllIIIIIlIl, final IBlockState llllllllllllllIIlIIlIIllIIIIllII, final EntityPlayer llllllllllllllIIlIIlIIllIIIIIlII, final EnumFacing llllllllllllllIIlIIlIIllIIIIlIlI, final float llllllllllllllIIlIIlIIllIIIIlIIl, final float llllllllllllllIIlIIlIIllIIIIlIII, final float llllllllllllllIIlIIlIIllIIIIIlll) {
        if (!llllllllllllllIIlIIlIIllIIIIlllI.isRemote) {
            llllllllllllllIIlIIlIIllIIIIIlII.displayGui(new Anvil(llllllllllllllIIlIIlIIllIIIIlllI, llllllllllllllIIlIIlIIllIIIIIlIl));
        }
        return true;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIlIIlIIlIllIlIlIl) {
        return this.getDefaultState().withProperty(BlockAnvil.FACING, EnumFacing.getHorizontal(llllllllllllllIIlIIlIIlIllIlIlIl & 0x3)).withProperty(BlockAnvil.DAMAGE, (llllllllllllllIIlIIlIIlIllIlIlIl & 0xF) >> 2);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIIlIIlIIllIIIIIIIl) {
        return (int)llllllllllllllIIlIIlIIllIIIIIIIl.getValue(BlockAnvil.DAMAGE);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIIlIIlIIllIIIllIll, final BlockPos llllllllllllllIIlIIlIIllIIlIIlII, final EnumFacing llllllllllllllIIlIIlIIllIIlIIIll, final float llllllllllllllIIlIIlIIllIIIllIII, final float llllllllllllllIIlIIlIIllIIIlIlll, final float llllllllllllllIIlIIlIIllIIIlIllI, final int llllllllllllllIIlIIlIIllIIIlIlIl, final EntityLivingBase llllllllllllllIIlIIlIIllIIIlIlII) {
        final EnumFacing llllllllllllllIIlIIlIIllIIIlllIl = llllllllllllllIIlIIlIIllIIIlIlII.func_174811_aO().rotateY();
        return super.onBlockPlaced(llllllllllllllIIlIIlIIllIIIllIll, llllllllllllllIIlIIlIIllIIlIIlII, llllllllllllllIIlIIlIIllIIlIIIll, llllllllllllllIIlIIlIIllIIIllIII, llllllllllllllIIlIIlIIllIIIlIlll, llllllllllllllIIlIIlIIllIIIlIllI, llllllllllllllIIlIIlIIllIIIlIlIl, llllllllllllllIIlIIlIIllIIIlIlII).withProperty(BlockAnvil.FACING, llllllllllllllIIlIIlIIllIIIlllIl).withProperty(BlockAnvil.DAMAGE, llllllllllllllIIlIIlIIllIIIlIlIl >> 2);
    }
    
    public static class Anvil implements IInteractionObject
    {
        private final /* synthetic */ World world;
        private final /* synthetic */ BlockPos position;
        
        @Override
        public String getGuiID() {
            return "minecraft:anvil";
        }
        
        public Anvil(final World lllllllllllllllIlllIIIIIllIllIlI, final BlockPos lllllllllllllllIlllIIIIIllIllIIl) {
            this.world = lllllllllllllllIlllIIIIIllIllIlI;
            this.position = lllllllllllllllIlllIIIIIllIllIIl;
        }
        
        @Override
        public boolean hasCustomName() {
            return false;
        }
        
        @Override
        public Container createContainer(final InventoryPlayer lllllllllllllllIlllIIIIIllIIlllI, final EntityPlayer lllllllllllllllIlllIIIIIllIlIIII) {
            return new ContainerRepair(lllllllllllllllIlllIIIIIllIIlllI, this.world, this.position, lllllllllllllllIlllIIIIIllIlIIII);
        }
        
        @Override
        public IChatComponent getDisplayName() {
            return new ChatComponentTranslation(String.valueOf(new StringBuilder(String.valueOf(Blocks.anvil.getUnlocalizedName())).append(".name")), new Object[0]);
        }
        
        static {
            __OBFID = "CL_00002144";
        }
        
        @Override
        public String getName() {
            return "anvil";
        }
    }
}
