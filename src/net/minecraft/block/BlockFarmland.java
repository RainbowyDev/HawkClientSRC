package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public class BlockFarmland extends Block
{
    public static final /* synthetic */ PropertyInteger field_176531_a;
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockFarmland.field_176531_a });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlllllllIlIIIlIIIll) {
        return this.getDefaultState().withProperty(BlockFarmland.field_176531_a, lllllllllllllIlllllllIlIIIlIIIll & 0x7);
    }
    
    protected BlockFarmland() {
        super(Material.ground);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockFarmland.field_176531_a, 0));
        this.setTickRandomly(true);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.9375f, 1.0f);
        this.setLightOpacity(255);
    }
    
    static {
        __OBFID = "CL_00000241";
        field_176531_a = PropertyInteger.create("moisture", 0, 7);
    }
    
    private boolean func_176530_e(final World lllllllllllllIlllllllIlIIlIIIlII, final BlockPos lllllllllllllIlllllllIlIIlIIIlll) {
        for (final BlockPos.MutableBlockPos lllllllllllllIlllllllIlIIlIIIlIl : BlockPos.getAllInBoxMutable(lllllllllllllIlllllllIlIIlIIIlll.add(-4, 0, -4), lllllllllllllIlllllllIlIIlIIIlll.add(4, 1, 4))) {
            if (lllllllllllllIlllllllIlIIlIIIlII.getBlockState(lllllllllllllIlllllllIlIIlIIIlIl).getBlock().getMaterial() == Material.water) {
                return true;
            }
        }
        return false;
    }
    
    private boolean func_176529_d(final World lllllllllllllIlllllllIlIIlIlIIll, final BlockPos lllllllllllllIlllllllIlIIlIlIIlI) {
        final Block lllllllllllllIlllllllIlIIlIlIIIl = lllllllllllllIlllllllIlIIlIlIIll.getBlockState(lllllllllllllIlllllllIlIIlIlIIlI.offsetUp()).getBlock();
        return lllllllllllllIlllllllIlIIlIlIIIl instanceof BlockCrops || lllllllllllllIlllllllIlIIlIlIIIl instanceof BlockStem;
    }
    
    @Override
    public Item getItem(final World lllllllllllllIlllllllIlIIIlIlIII, final BlockPos lllllllllllllIlllllllIlIIIlIIlll) {
        return Item.getItemFromBlock(Blocks.dirt);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlllllllIlIIIlIlllI, final Random lllllllllllllIlllllllIlIIIlIllIl, final int lllllllllllllIlllllllIlIIIlIlIlI) {
        return Blocks.dirt.getItemDropped(Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), lllllllllllllIlllllllIlIIIlIllIl, lllllllllllllIlllllllIlIIIlIlIlI);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllIlllllllIlIIIlllIlI, final BlockPos lllllllllllllIlllllllIlIIIlllIIl, final IBlockState lllllllllllllIlllllllIlIIIlllIII, final Block lllllllllllllIlllllllIlIIIllIIlI) {
        super.onNeighborBlockChange(lllllllllllllIlllllllIlIIIlllIlI, lllllllllllllIlllllllIlIIIlllIIl, lllllllllllllIlllllllIlIIIlllIII, lllllllllllllIlllllllIlIIIllIIlI);
        if (lllllllllllllIlllllllIlIIIlllIlI.getBlockState(lllllllllllllIlllllllIlIIIlllIIl.offsetUp()).getBlock().getMaterial().isSolid()) {
            lllllllllllllIlllllllIlIIIlllIlI.setBlockState(lllllllllllllIlllllllIlIIIlllIIl, Blocks.dirt.getDefaultState());
        }
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllIlllllllIlIIlllllII, final BlockPos lllllllllllllIlllllllIlIIllllIIl, final IBlockState lllllllllllllIlllllllIlIIllllIlI) {
        return new AxisAlignedBB(lllllllllllllIlllllllIlIIllllIIl.getX(), lllllllllllllIlllllllIlIIllllIIl.getY(), lllllllllllllIlllllllIlIIllllIIl.getZ(), lllllllllllllIlllllllIlIIllllIIl.getX() + 1, lllllllllllllIlllllllIlIIllllIIl.getY() + 1, lllllllllllllIlllllllIlIIllllIIl.getZ() + 1);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public void updateTick(final World lllllllllllllIlllllllIlIIllIlIlI, final BlockPos lllllllllllllIlllllllIlIIllIllll, final IBlockState lllllllllllllIlllllllIlIIllIlIII, final Random lllllllllllllIlllllllIlIIllIllIl) {
        final int lllllllllllllIlllllllIlIIllIllII = (int)lllllllllllllIlllllllIlIIllIlIII.getValue(BlockFarmland.field_176531_a);
        if (!this.func_176530_e(lllllllllllllIlllllllIlIIllIlIlI, lllllllllllllIlllllllIlIIllIllll) && !lllllllllllllIlllllllIlIIllIlIlI.func_175727_C(lllllllllllllIlllllllIlIIllIllll.offsetUp())) {
            if (lllllllllllllIlllllllIlIIllIllII > 0) {
                lllllllllllllIlllllllIlIIllIlIlI.setBlockState(lllllllllllllIlllllllIlIIllIllll, lllllllllllllIlllllllIlIIllIlIII.withProperty(BlockFarmland.field_176531_a, lllllllllllllIlllllllIlIIllIllII - 1), 2);
            }
            else if (!this.func_176529_d(lllllllllllllIlllllllIlIIllIlIlI, lllllllllllllIlllllllIlIIllIllll)) {
                lllllllllllllIlllllllIlIIllIlIlI.setBlockState(lllllllllllllIlllllllIlIIllIllll, Blocks.dirt.getDefaultState());
            }
        }
        else if (lllllllllllllIlllllllIlIIllIllII < 7) {
            lllllllllllllIlllllllIlIIllIlIlI.setBlockState(lllllllllllllIlllllllIlIIllIllll, lllllllllllllIlllllllIlIIllIlIII.withProperty(BlockFarmland.field_176531_a, 7), 2);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlllllllIlIIIIllllI) {
        return (int)lllllllllllllIlllllllIlIIIIllllI.getValue(BlockFarmland.field_176531_a);
    }
    
    @Override
    public void onFallenUpon(final World lllllllllllllIlllllllIlIIlIllIll, final BlockPos lllllllllllllIlllllllIlIIlIlllll, final Entity lllllllllllllIlllllllIlIIlIllIIl, final float lllllllllllllIlllllllIlIIlIlllIl) {
        if (lllllllllllllIlllllllIlIIlIllIIl instanceof EntityLivingBase) {
            if (!lllllllllllllIlllllllIlIIlIllIll.isRemote && lllllllllllllIlllllllIlIIlIllIll.rand.nextFloat() < lllllllllllllIlllllllIlIIlIlllIl - 0.5f) {
                if (!(lllllllllllllIlllllllIlIIlIllIIl instanceof EntityPlayer) && !lllllllllllllIlllllllIlIIlIllIll.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                    return;
                }
                lllllllllllllIlllllllIlIIlIllIll.setBlockState(lllllllllllllIlllllllIlIIlIlllll, Blocks.dirt.getDefaultState());
            }
            super.onFallenUpon(lllllllllllllIlllllllIlIIlIllIll, lllllllllllllIlllllllIlIIlIlllll, lllllllllllllIlllllllIlIIlIllIIl, lllllllllllllIlllllllIlIIlIlllIl);
        }
    }
}
