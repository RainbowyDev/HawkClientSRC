package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.nbt.*;

public class BlockJukebox extends BlockContainer
{
    public static final /* synthetic */ PropertyBool HAS_RECORD;
    
    private void dropRecord(final World llllllllllllllIIIIIlllllIllllIlI, final BlockPos llllllllllllllIIIIIllllllIIIIlIl, final IBlockState llllllllllllllIIIIIllllllIIIIlII) {
        if (!llllllllllllllIIIIIlllllIllllIlI.isRemote) {
            final TileEntity llllllllllllllIIIIIllllllIIIIIll = llllllllllllllIIIIIlllllIllllIlI.getTileEntity(llllllllllllllIIIIIllllllIIIIlIl);
            if (llllllllllllllIIIIIllllllIIIIIll instanceof TileEntityJukebox) {
                final TileEntityJukebox llllllllllllllIIIIIllllllIIIIIlI = (TileEntityJukebox)llllllllllllllIIIIIllllllIIIIIll;
                final ItemStack llllllllllllllIIIIIllllllIIIIIIl = llllllllllllllIIIIIllllllIIIIIlI.getRecord();
                if (llllllllllllllIIIIIllllllIIIIIIl != null) {
                    llllllllllllllIIIIIlllllIllllIlI.playAuxSFX(1005, llllllllllllllIIIIIllllllIIIIlIl, 0);
                    llllllllllllllIIIIIlllllIllllIlI.func_175717_a(llllllllllllllIIIIIllllllIIIIlIl, null);
                    llllllllllllllIIIIIllllllIIIIIlI.setRecord(null);
                    final float llllllllllllllIIIIIllllllIIIIIII = 0.7f;
                    final double llllllllllllllIIIIIlllllIlllllll = llllllllllllllIIIIIlllllIllllIlI.rand.nextFloat() * llllllllllllllIIIIIllllllIIIIIII + (1.0f - llllllllllllllIIIIIllllllIIIIIII) * 0.5;
                    final double llllllllllllllIIIIIlllllIllllllI = llllllllllllllIIIIIlllllIllllIlI.rand.nextFloat() * llllllllllllllIIIIIllllllIIIIIII + (1.0f - llllllllllllllIIIIIllllllIIIIIII) * 0.2 + 0.6;
                    final double llllllllllllllIIIIIlllllIlllllIl = llllllllllllllIIIIIlllllIllllIlI.rand.nextFloat() * llllllllllllllIIIIIllllllIIIIIII + (1.0f - llllllllllllllIIIIIllllllIIIIIII) * 0.5;
                    final ItemStack llllllllllllllIIIIIlllllIlllllII = llllllllllllllIIIIIllllllIIIIIIl.copy();
                    final EntityItem llllllllllllllIIIIIlllllIllllIll = new EntityItem(llllllllllllllIIIIIlllllIllllIlI, llllllllllllllIIIIIllllllIIIIlIl.getX() + llllllllllllllIIIIIlllllIlllllll, llllllllllllllIIIIIllllllIIIIlIl.getY() + llllllllllllllIIIIIlllllIllllllI, llllllllllllllIIIIIllllllIIIIlIl.getZ() + llllllllllllllIIIIIlllllIlllllIl, llllllllllllllIIIIIlllllIlllllII);
                    llllllllllllllIIIIIlllllIllllIll.setDefaultPickupDelay();
                    llllllllllllllIIIIIlllllIllllIlI.spawnEntityInWorld(llllllllllllllIIIIIlllllIllllIll);
                }
            }
        }
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIIIIIlllllIlIlIIlI, final int llllllllllllllIIIIIlllllIlIlIIIl) {
        return new TileEntityJukebox();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockJukebox.HAS_RECORD });
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIIIIIlllllIllIlIlI, final BlockPos llllllllllllllIIIIIlllllIllIlIIl, final IBlockState llllllllllllllIIIIIlllllIllIlIII) {
        this.dropRecord(llllllllllllllIIIIIlllllIllIlIlI, llllllllllllllIIIIIlllllIllIlIIl, llllllllllllllIIIIIlllllIllIlIII);
        super.breakBlock(llllllllllllllIIIIIlllllIllIlIlI, llllllllllllllIIIIIlllllIllIlIIl, llllllllllllllIIIIIlllllIllIlIII);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIIIlllllIIlllIII) {
        return ((boolean)llllllllllllllIIIIIlllllIIlllIII.getValue(BlockJukebox.HAS_RECORD)) ? 1 : 0;
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    @Override
    public int getComparatorInputOverride(final World llllllllllllllIIIIIlllllIlIIlIlI, final BlockPos llllllllllllllIIIIIlllllIlIIlIIl) {
        final TileEntity llllllllllllllIIIIIlllllIlIIlIII = llllllllllllllIIIIIlllllIlIIlIlI.getTileEntity(llllllllllllllIIIIIlllllIlIIlIIl);
        if (llllllllllllllIIIIIlllllIlIIlIII instanceof TileEntityJukebox) {
            final ItemStack llllllllllllllIIIIIlllllIlIIIlll = ((TileEntityJukebox)llllllllllllllIIIIIlllllIlIIlIII).getRecord();
            if (llllllllllllllIIIIIlllllIlIIIlll != null) {
                return Item.getIdFromItem(llllllllllllllIIIIIlllllIlIIIlll.getItem()) + 1 - Item.getIdFromItem(Items.record_13);
            }
        }
        return 0;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIIIIllllllIlIlllI, final BlockPos llllllllllllllIIIIIllllllIlIIlII, IBlockState llllllllllllllIIIIIllllllIlIllII, final EntityPlayer llllllllllllllIIIIIllllllIlIlIll, final EnumFacing llllllllllllllIIIIIllllllIlIlIlI, final float llllllllllllllIIIIIllllllIlIlIIl, final float llllllllllllllIIIIIllllllIlIlIII, final float llllllllllllllIIIIIllllllIlIIlll) {
        if (llllllllllllllIIIIIllllllIlIllII.getValue(BlockJukebox.HAS_RECORD)) {
            this.dropRecord(llllllllllllllIIIIIllllllIlIlllI, llllllllllllllIIIIIllllllIlIIlII, llllllllllllllIIIIIllllllIlIllII);
            llllllllllllllIIIIIllllllIlIllII = llllllllllllllIIIIIllllllIlIllII.withProperty(BlockJukebox.HAS_RECORD, false);
            llllllllllllllIIIIIllllllIlIlllI.setBlockState(llllllllllllllIIIIIllllllIlIIlII, llllllllllllllIIIIIllllllIlIllII, 2);
            return true;
        }
        return false;
    }
    
    protected BlockJukebox() {
        super(Material.wood);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockJukebox.HAS_RECORD, false));
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    static {
        __OBFID = "CL_00000260";
        HAS_RECORD = PropertyBool.create("has_record");
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIIIlllllIIlllllI) {
        return this.getDefaultState().withProperty(BlockJukebox.HAS_RECORD, llllllllllllllIIIIIlllllIIlllllI > 0);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIIIIlllllIlIlllIl, final BlockPos llllllllllllllIIIIIlllllIlIlIllI, final IBlockState llllllllllllllIIIIIlllllIlIlIlIl, final float llllllllllllllIIIIIlllllIlIlIlII, final int llllllllllllllIIIIIlllllIlIllIIl) {
        if (!llllllllllllllIIIIIlllllIlIlllIl.isRemote) {
            super.dropBlockAsItemWithChance(llllllllllllllIIIIIlllllIlIlllIl, llllllllllllllIIIIIlllllIlIlIllI, llllllllllllllIIIIIlllllIlIlIlIl, llllllllllllllIIIIIlllllIlIlIlII, 0);
        }
    }
    
    public void insertRecord(final World llllllllllllllIIIIIllllllIIlllII, final BlockPos llllllllllllllIIIIIllllllIIlIllI, final IBlockState llllllllllllllIIIIIllllllIIlIlIl, final ItemStack llllllllllllllIIIIIllllllIIllIIl) {
        if (!llllllllllllllIIIIIllllllIIlllII.isRemote) {
            final TileEntity llllllllllllllIIIIIllllllIIllIII = llllllllllllllIIIIIllllllIIlllII.getTileEntity(llllllllllllllIIIIIllllllIIlIllI);
            if (llllllllllllllIIIIIllllllIIllIII instanceof TileEntityJukebox) {
                ((TileEntityJukebox)llllllllllllllIIIIIllllllIIllIII).setRecord(new ItemStack(llllllllllllllIIIIIllllllIIllIIl.getItem(), 1, llllllllllllllIIIIIllllllIIllIIl.getMetadata()));
                llllllllllllllIIIIIllllllIIlllII.setBlockState(llllllllllllllIIIIIllllllIIlIllI, llllllllllllllIIIIIllllllIIlIlIl.withProperty(BlockJukebox.HAS_RECORD, true), 2);
            }
        }
    }
    
    public static class TileEntityJukebox extends TileEntity
    {
        private /* synthetic */ ItemStack record;
        
        @Override
        public void readFromNBT(final NBTTagCompound llllllllllllllIlIIIllIIlIllllIIl) {
            super.readFromNBT(llllllllllllllIlIIIllIIlIllllIIl);
            if (llllllllllllllIlIIIllIIlIllllIIl.hasKey("RecordItem", 10)) {
                this.setRecord(ItemStack.loadItemStackFromNBT(llllllllllllllIlIIIllIIlIllllIIl.getCompoundTag("RecordItem")));
            }
            else if (llllllllllllllIlIIIllIIlIllllIIl.getInteger("Record") > 0) {
                this.setRecord(new ItemStack(Item.getItemById(llllllllllllllIlIIIllIIlIllllIIl.getInteger("Record")), 1, 0));
            }
        }
        
        public ItemStack getRecord() {
            return this.record;
        }
        
        static {
            __OBFID = "CL_00000261";
        }
        
        public void setRecord(final ItemStack llllllllllllllIlIIIllIIlIllIlIlI) {
            this.record = llllllllllllllIlIIIllIIlIllIlIlI;
            this.markDirty();
        }
        
        @Override
        public void writeToNBT(final NBTTagCompound llllllllllllllIlIIIllIIlIlllIlIl) {
            super.writeToNBT(llllllllllllllIlIIIllIIlIlllIlIl);
            if (this.getRecord() != null) {
                llllllllllllllIlIIIllIIlIlllIlIl.setTag("RecordItem", this.getRecord().writeToNBT(new NBTTagCompound()));
            }
        }
    }
}
