package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.command.server.*;
import net.minecraft.block.material.*;

public class BlockCommandBlock extends BlockContainer
{
    public static final /* synthetic */ PropertyBool TRIGGERED_PROP;
    
    @Override
    public TileEntity createNewTileEntity(final World lIIllIllIlII, final int lIIllIllIIll) {
        return new TileEntityCommandBlock();
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lIIlIlIIlIll, final BlockPos lIIlIlIIlIlI, final EnumFacing lIIlIlIIlIIl, final float lIIlIlIIlIII, final float lIIlIlIIIlll, final float lIIlIlIIIllI, final int lIIlIlIIIlIl, final EntityLivingBase lIIlIlIIIlII) {
        return this.getDefaultState().withProperty(BlockCommandBlock.TRIGGERED_PROP, false);
    }
    
    @Override
    public int getComparatorInputOverride(final World lIIlIlllIlIl, final BlockPos lIIlIlllIlll) {
        final TileEntity lIIlIlllIllI = lIIlIlllIlIl.getTileEntity(lIIlIlllIlll);
        return (lIIlIlllIllI instanceof TileEntityCommandBlock) ? ((TileEntityCommandBlock)lIIlIlllIllI).getCommandBlockLogic().getSuccessCount() : 0;
    }
    
    @Override
    public int quantityDropped(final Random lIIlIlIlllll) {
        return 0;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockCommandBlock.TRIGGERED_PROP });
    }
    
    @Override
    public boolean onBlockActivated(final World lIIllIIIlIlI, final BlockPos lIIllIIIIIII, final IBlockState lIIllIIIlIII, final EntityPlayer lIIllIIIIlll, final EnumFacing lIIllIIIIllI, final float lIIllIIIIlIl, final float lIIllIIIIlII, final float lIIllIIIIIll) {
        final TileEntity lIIllIIIIIlI = lIIllIIIlIlI.getTileEntity(lIIllIIIIIII);
        return lIIllIIIIIlI instanceof TileEntityCommandBlock && ((TileEntityCommandBlock)lIIllIIIIIlI).getCommandBlockLogic().func_175574_a(lIIllIIIIlll);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIlIlIllIlI) {
        return this.getDefaultState().withProperty(BlockCommandBlock.TRIGGERED_PROP, (lIIlIlIllIlI & 0x1) > 0);
    }
    
    @Override
    public void updateTick(final World lIIllIIllIlI, final BlockPos lIIllIIlIIll, final IBlockState lIIllIIllIII, final Random lIIllIIlIlll) {
        final TileEntity lIIllIIlIllI = lIIllIIllIlI.getTileEntity(lIIllIIlIIll);
        if (lIIllIIlIllI instanceof TileEntityCommandBlock) {
            ((TileEntityCommandBlock)lIIllIIlIllI).getCommandBlockLogic().trigger(lIIllIIllIlI);
            lIIllIIllIlI.updateComparatorOutputLevel(lIIllIIlIIll, this);
        }
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lIIlIlIlIlII) {
        int lIIlIlIlIIll = 0;
        if (lIIlIlIlIlII.getValue(BlockCommandBlock.TRIGGERED_PROP)) {
            lIIlIlIlIIll |= 0x1;
        }
        return lIIlIlIlIIll;
    }
    
    @Override
    public void onNeighborBlockChange(final World lIIllIlIIlII, final BlockPos lIIllIlIIIll, final IBlockState lIIllIlIIIlI, final Block lIIllIlIlIII) {
        if (!lIIllIlIIlII.isRemote) {
            final boolean lIIllIlIIlll = lIIllIlIIlII.isBlockPowered(lIIllIlIIIll);
            final boolean lIIllIlIIllI = (boolean)lIIllIlIIIlI.getValue(BlockCommandBlock.TRIGGERED_PROP);
            if (lIIllIlIIlll && !lIIllIlIIllI) {
                lIIllIlIIlII.setBlockState(lIIllIlIIIll, lIIllIlIIIlI.withProperty(BlockCommandBlock.TRIGGERED_PROP, true), 4);
                lIIllIlIIlII.scheduleUpdate(lIIllIlIIIll, this, this.tickRate(lIIllIlIIlII));
            }
            else if (!lIIllIlIIlll && lIIllIlIIllI) {
                lIIllIlIIlII.setBlockState(lIIllIlIIIll, lIIllIlIIIlI.withProperty(BlockCommandBlock.TRIGGERED_PROP, false), 4);
            }
        }
    }
    
    static {
        __OBFID = "CL_00000219";
        TRIGGERED_PROP = PropertyBool.create("triggered");
    }
    
    @Override
    public int tickRate(final World lIIllIIlIIII) {
        return 1;
    }
    
    @Override
    public void onBlockPlacedBy(final World lIIlIllIllII, final BlockPos lIIlIllIlIll, final IBlockState lIIlIllIlIlI, final EntityLivingBase lIIlIllIlIIl, final ItemStack lIIlIllIIIll) {
        final TileEntity lIIlIllIIlll = lIIlIllIllII.getTileEntity(lIIlIllIlIll);
        if (lIIlIllIIlll instanceof TileEntityCommandBlock) {
            final CommandBlockLogic lIIlIllIIllI = ((TileEntityCommandBlock)lIIlIllIIlll).getCommandBlockLogic();
            if (lIIlIllIIIll.hasDisplayName()) {
                lIIlIllIIllI.func_145754_b(lIIlIllIIIll.getDisplayName());
            }
            if (!lIIlIllIllII.isRemote) {
                lIIlIllIIllI.func_175573_a(lIIlIllIllII.getGameRules().getGameRuleBooleanValue("sendCommandFeedback"));
            }
        }
    }
    
    public BlockCommandBlock() {
        super(Material.iron);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockCommandBlock.TRIGGERED_PROP, false));
    }
}
