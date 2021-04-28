package net.minecraft.block;

import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockPane extends Block
{
    public static final /* synthetic */ PropertyBool EAST;
    private final /* synthetic */ boolean field_150099_b;
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ PropertyBool NORTH;
    public static final /* synthetic */ PropertyBool WEST;
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess llllllllllllllllIlIIlIIIIlIlllll, final BlockPos llllllllllllllllIlIIlIIIIlIllllI) {
        float llllllllllllllllIlIIlIIIIlIlllIl = 0.4375f;
        float llllllllllllllllIlIIlIIIIlIlllII = 0.5625f;
        float llllllllllllllllIlIIlIIIIlIllIll = 0.4375f;
        float llllllllllllllllIlIIlIIIIlIllIlI = 0.5625f;
        final boolean llllllllllllllllIlIIlIIIIlIllIIl = this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIIlIlllll.getBlockState(llllllllllllllllIlIIlIIIIlIllllI.offsetNorth()).getBlock());
        final boolean llllllllllllllllIlIIlIIIIlIllIII = this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIIlIlllll.getBlockState(llllllllllllllllIlIIlIIIIlIllllI.offsetSouth()).getBlock());
        final boolean llllllllllllllllIlIIlIIIIlIlIlll = this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIIlIlllll.getBlockState(llllllllllllllllIlIIlIIIIlIllllI.offsetWest()).getBlock());
        final boolean llllllllllllllllIlIIlIIIIlIlIllI = this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIIlIlllll.getBlockState(llllllllllllllllIlIIlIIIIlIllllI.offsetEast()).getBlock());
        if ((!llllllllllllllllIlIIlIIIIlIlIlll || !llllllllllllllllIlIIlIIIIlIlIllI) && (llllllllllllllllIlIIlIIIIlIlIlll || llllllllllllllllIlIIlIIIIlIlIllI || llllllllllllllllIlIIlIIIIlIllIIl || llllllllllllllllIlIIlIIIIlIllIII)) {
            if (llllllllllllllllIlIIlIIIIlIlIlll) {
                llllllllllllllllIlIIlIIIIlIlllIl = 0.0f;
            }
            else if (llllllllllllllllIlIIlIIIIlIlIllI) {
                llllllllllllllllIlIIlIIIIlIlllII = 1.0f;
            }
        }
        else {
            llllllllllllllllIlIIlIIIIlIlllIl = 0.0f;
            llllllllllllllllIlIIlIIIIlIlllII = 1.0f;
        }
        if ((!llllllllllllllllIlIIlIIIIlIllIIl || !llllllllllllllllIlIIlIIIIlIllIII) && (llllllllllllllllIlIIlIIIIlIlIlll || llllllllllllllllIlIIlIIIIlIlIllI || llllllllllllllllIlIIlIIIIlIllIIl || llllllllllllllllIlIIlIIIIlIllIII)) {
            if (llllllllllllllllIlIIlIIIIlIllIIl) {
                llllllllllllllllIlIIlIIIIlIllIll = 0.0f;
            }
            else if (llllllllllllllllIlIIlIIIIlIllIII) {
                llllllllllllllllIlIIlIIIIlIllIlI = 1.0f;
            }
        }
        else {
            llllllllllllllllIlIIlIIIIlIllIll = 0.0f;
            llllllllllllllllIlIIlIIIIlIllIlI = 1.0f;
        }
        this.setBlockBounds(llllllllllllllllIlIIlIIIIlIlllIl, 0.0f, llllllllllllllllIlIIlIIIIlIllIll, llllllllllllllllIlIIlIIIIlIlllII, 1.0f, llllllllllllllllIlIIlIIIIlIllIlI);
    }
    
    public final boolean canPaneConnectToBlock(final Block llllllllllllllllIlIIlIIIIlIIIlIl) {
        return llllllllllllllllIlIIlIIIIlIIIlIl.isFullBlock() || llllllllllllllllIlIIlIIIIlIIIlIl == this || llllllllllllllllIlIIlIIIIlIIIlIl == Blocks.glass || llllllllllllllllIlIIlIIIIlIIIlIl == Blocks.stained_glass || llllllllllllllllIlIIlIIIIlIIIlIl == Blocks.stained_glass_pane || llllllllllllllllIlIIlIIIIlIIIlIl instanceof BlockPane;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000322";
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
    }
    
    protected BlockPane(final Material llllllllllllllllIlIIlIIIlIllllIl, final boolean llllllllllllllllIlIIlIIIlIllllII) {
        super(llllllllllllllllIlIIlIIIlIllllIl);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPane.NORTH, false).withProperty(BlockPane.EAST, false).withProperty(BlockPane.SOUTH, false).withProperty(BlockPane.WEST, false));
        this.field_150099_b = llllllllllllllllIlIIlIIIlIllllII;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllllIlIIlIIIIlIIIIIl) {
        return 0;
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllllIlIIlIIIlIlIIlll, final Random llllllllllllllllIlIIlIIIlIlIIllI, final int llllllllllllllllIlIIlIIIlIlIIIIl) {
        return this.field_150099_b ? super.getItemDropped(llllllllllllllllIlIIlIIIlIlIIlll, llllllllllllllllIlIIlIIIlIlIIllI, llllllllllllllllIlIIlIIIlIlIIIIl) : null;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllllIlIIlIIIlIIlIlIl, final BlockPos llllllllllllllllIlIIlIIIlIIlIlII, final EnumFacing llllllllllllllllIlIIlIIIlIIlIlll) {
        return llllllllllllllllIlIIlIIIlIIlIlIl.getBlockState(llllllllllllllllIlIIlIIIlIIlIlII).getBlock() != this && super.shouldSideBeRendered(llllllllllllllllIlIIlIIIlIIlIlIl, llllllllllllllllIlIIlIIIlIIlIlII, llllllllllllllllIlIIlIIIlIIlIlll);
    }
    
    @Override
    public void addCollisionBoxesToList(final World llllllllllllllllIlIIlIIIlIIIIllI, final BlockPos llllllllllllllllIlIIlIIIIllllIlI, final IBlockState llllllllllllllllIlIIlIIIlIIIIlII, final AxisAlignedBB llllllllllllllllIlIIlIIIlIIIIIll, final List llllllllllllllllIlIIlIIIIlllIlll, final Entity llllllllllllllllIlIIlIIIIlllIllI) {
        final boolean llllllllllllllllIlIIlIIIlIIIIIII = this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIlIIIIllI.getBlockState(llllllllllllllllIlIIlIIIIllllIlI.offsetNorth()).getBlock());
        final boolean llllllllllllllllIlIIlIIIIlllllll = this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIlIIIIllI.getBlockState(llllllllllllllllIlIIlIIIIllllIlI.offsetSouth()).getBlock());
        final boolean llllllllllllllllIlIIlIIIIllllllI = this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIlIIIIllI.getBlockState(llllllllllllllllIlIIlIIIIllllIlI.offsetWest()).getBlock());
        final boolean llllllllllllllllIlIIlIIIIlllllIl = this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIlIIIIllI.getBlockState(llllllllllllllllIlIIlIIIIllllIlI.offsetEast()).getBlock());
        if ((!llllllllllllllllIlIIlIIIIllllllI || !llllllllllllllllIlIIlIIIIlllllIl) && (llllllllllllllllIlIIlIIIIllllllI || llllllllllllllllIlIIlIIIIlllllIl || llllllllllllllllIlIIlIIIlIIIIIII || llllllllllllllllIlIIlIIIIlllllll)) {
            if (llllllllllllllllIlIIlIIIIllllllI) {
                this.setBlockBounds(0.0f, 0.0f, 0.4375f, 0.5f, 1.0f, 0.5625f);
                super.addCollisionBoxesToList(llllllllllllllllIlIIlIIIlIIIIllI, llllllllllllllllIlIIlIIIIllllIlI, llllllllllllllllIlIIlIIIlIIIIlII, llllllllllllllllIlIIlIIIlIIIIIll, llllllllllllllllIlIIlIIIIlllIlll, llllllllllllllllIlIIlIIIIlllIllI);
            }
            else if (llllllllllllllllIlIIlIIIIlllllIl) {
                this.setBlockBounds(0.5f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
                super.addCollisionBoxesToList(llllllllllllllllIlIIlIIIlIIIIllI, llllllllllllllllIlIIlIIIIllllIlI, llllllllllllllllIlIIlIIIlIIIIlII, llllllllllllllllIlIIlIIIlIIIIIll, llllllllllllllllIlIIlIIIIlllIlll, llllllllllllllllIlIIlIIIIlllIllI);
            }
        }
        else {
            this.setBlockBounds(0.0f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
            super.addCollisionBoxesToList(llllllllllllllllIlIIlIIIlIIIIllI, llllllllllllllllIlIIlIIIIllllIlI, llllllllllllllllIlIIlIIIlIIIIlII, llllllllllllllllIlIIlIIIlIIIIIll, llllllllllllllllIlIIlIIIIlllIlll, llllllllllllllllIlIIlIIIIlllIllI);
        }
        if ((!llllllllllllllllIlIIlIIIlIIIIIII || !llllllllllllllllIlIIlIIIIlllllll) && (llllllllllllllllIlIIlIIIIllllllI || llllllllllllllllIlIIlIIIIlllllIl || llllllllllllllllIlIIlIIIlIIIIIII || llllllllllllllllIlIIlIIIIlllllll)) {
            if (llllllllllllllllIlIIlIIIlIIIIIII) {
                this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 0.5f);
                super.addCollisionBoxesToList(llllllllllllllllIlIIlIIIlIIIIllI, llllllllllllllllIlIIlIIIIllllIlI, llllllllllllllllIlIIlIIIlIIIIlII, llllllllllllllllIlIIlIIIlIIIIIll, llllllllllllllllIlIIlIIIIlllIlll, llllllllllllllllIlIIlIIIIlllIllI);
            }
            else if (llllllllllllllllIlIIlIIIIlllllll) {
                this.setBlockBounds(0.4375f, 0.0f, 0.5f, 0.5625f, 1.0f, 1.0f);
                super.addCollisionBoxesToList(llllllllllllllllIlIIlIIIlIIIIllI, llllllllllllllllIlIIlIIIIllllIlI, llllllllllllllllIlIIlIIIlIIIIlII, llllllllllllllllIlIIlIIIlIIIIIll, llllllllllllllllIlIIlIIIIlllIlll, llllllllllllllllIlIIlIIIIlllIllI);
            }
        }
        else {
            this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 1.0f);
            super.addCollisionBoxesToList(llllllllllllllllIlIIlIIIlIIIIllI, llllllllllllllllIlIIlIIIIllllIlI, llllllllllllllllIlIIlIIIlIIIIlII, llllllllllllllllIlIIlIIIlIIIIIll, llllllllllllllllIlIIlIIIIlllIlll, llllllllllllllllIlIIlIIIIlllIllI);
        }
    }
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllllllIlIIlIIIlIllIIll, final IBlockAccess llllllllllllllllIlIIlIIIlIlIlllI, final BlockPos llllllllllllllllIlIIlIIIlIlIllIl) {
        return llllllllllllllllIlIIlIIIlIllIIll.withProperty(BlockPane.NORTH, this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIlIlIlllI.getBlockState(llllllllllllllllIlIIlIIIlIlIllIl.offsetNorth()).getBlock())).withProperty(BlockPane.SOUTH, this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIlIlIlllI.getBlockState(llllllllllllllllIlIIlIIIlIlIllIl.offsetSouth()).getBlock())).withProperty(BlockPane.WEST, this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIlIlIlllI.getBlockState(llllllllllllllllIlIIlIIIlIlIllIl.offsetWest()).getBlock())).withProperty(BlockPane.EAST, this.canPaneConnectToBlock(llllllllllllllllIlIIlIIIlIlIlllI.getBlockState(llllllllllllllllIlIIlIIIlIlIllIl.offsetEast()).getBlock()));
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockPane.NORTH, BlockPane.EAST, BlockPane.WEST, BlockPane.SOUTH });
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }
}
