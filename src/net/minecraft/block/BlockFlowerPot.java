package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockFlowerPot extends BlockContainer
{
    public static final /* synthetic */ PropertyInteger field_176444_a;
    public static final /* synthetic */ PropertyEnum field_176443_b;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIllIllIIlIIlIIllI) {
        return (int)lllllllllllllllIllIllIIlIIlIIllI.getValue(BlockFlowerPot.field_176444_a);
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        final float lllllllllllllllIllIllIIlllIIllIl = 0.375f;
        final float lllllllllllllllIllIllIIlllIIllII = lllllllllllllllIllIllIIlllIIllIl / 2.0f;
        this.setBlockBounds(0.5f - lllllllllllllllIllIllIIlllIIllII, 0.0f, 0.5f - lllllllllllllllIllIllIIlllIIllII, 0.5f + lllllllllllllllIllIllIIlllIIllII, lllllllllllllllIllIllIIlllIIllIl, 0.5f + lllllllllllllllIllIllIIlllIIllII);
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
    
    static {
        __OBFID = "CL_00000247";
        field_176444_a = PropertyInteger.create("legacy_data", 0, 15);
        field_176443_b = PropertyEnum.create("contents", EnumFlowerType.class);
    }
    
    public BlockFlowerPot() {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockFlowerPot.field_176443_b, EnumFlowerType.EMPTY).withProperty(BlockFlowerPot.field_176444_a, 0));
        this.setBlockBoundsForItemRender();
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIllIllIIlIlllIlll, final BlockPos lllllllllllllllIllIllIIlIlllIllI) {
        return super.canPlaceBlockAt(lllllllllllllllIllIllIIlIlllIlll, lllllllllllllllIllIllIIlIlllIllI) && World.doesBlockHaveSolidTopSurface(lllllllllllllllIllIllIIlIlllIlll, lllllllllllllllIllIllIIlIlllIllI.offsetDown());
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIllIllIIlIlIIIIll, final Random lllllllllllllllIllIllIIlIlIIIIlI, final int lllllllllllllllIllIllIIlIlIIIIIl) {
        return Items.flower_pot;
    }
    
    private boolean func_149928_a(final Block lllllllllllllllIllIllIIllIIllIII, final int lllllllllllllllIllIllIIllIIlIlIl) {
        return lllllllllllllllIllIllIIllIIllIII == Blocks.yellow_flower || lllllllllllllllIllIllIIllIIllIII == Blocks.red_flower || lllllllllllllllIllIllIIllIIllIII == Blocks.cactus || lllllllllllllllIllIllIIllIIllIII == Blocks.brown_mushroom || lllllllllllllllIllIllIIllIIllIII == Blocks.red_mushroom || lllllllllllllllIllIllIIllIIllIII == Blocks.sapling || lllllllllllllllIllIllIIllIIllIII == Blocks.deadbush || (lllllllllllllllIllIllIIllIIllIII == Blocks.tallgrass && lllllllllllllllIllIllIIllIIlIlIl == BlockTallGrass.EnumType.FERN.func_177044_a());
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllllIllIllIIlIIIllIlI, final IBlockAccess lllllllllllllllIllIllIIlIIIlIIII, final BlockPos lllllllllllllllIllIllIIlIIIIllll) {
        EnumFlowerType lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.EMPTY;
        final TileEntity lllllllllllllllIllIllIIlIIIlIllI = lllllllllllllllIllIllIIlIIIlIIII.getTileEntity(lllllllllllllllIllIllIIlIIIIllll);
        if (lllllllllllllllIllIllIIlIIIlIllI instanceof TileEntityFlowerPot) {
            final TileEntityFlowerPot lllllllllllllllIllIllIIlIIIlIlIl = (TileEntityFlowerPot)lllllllllllllllIllIllIIlIIIlIllI;
            final Item lllllllllllllllIllIllIIlIIIlIlII = lllllllllllllllIllIllIIlIIIlIlIl.getFlowerPotItem();
            if (lllllllllllllllIllIllIIlIIIlIlII instanceof ItemBlock) {
                final int lllllllllllllllIllIllIIlIIIlIIll = lllllllllllllllIllIllIIlIIIlIlIl.getFlowerPotData();
                final Block lllllllllllllllIllIllIIlIIIlIIlI = Block.getBlockFromItem(lllllllllllllllIllIllIIlIIIlIlII);
                if (lllllllllllllllIllIllIIlIIIlIIlI == Blocks.sapling) {
                    switch (SwitchEnumType.field_180353_a[BlockPlanks.EnumType.func_176837_a(lllllllllllllllIllIllIIlIIIlIIll).ordinal()]) {
                        case 1: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.OAK_SAPLING;
                            break;
                        }
                        case 2: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.SPRUCE_SAPLING;
                            break;
                        }
                        case 3: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.BIRCH_SAPLING;
                            break;
                        }
                        case 4: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.JUNGLE_SAPLING;
                            break;
                        }
                        case 5: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.ACACIA_SAPLING;
                            break;
                        }
                        case 6: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.DARK_OAK_SAPLING;
                            break;
                        }
                        default: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.EMPTY;
                            break;
                        }
                    }
                }
                else if (lllllllllllllllIllIllIIlIIIlIIlI == Blocks.tallgrass) {
                    switch (lllllllllllllllIllIllIIlIIIlIIll) {
                        case 0: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.DEAD_BUSH;
                            break;
                        }
                        case 2: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.FERN;
                            break;
                        }
                        default: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.EMPTY;
                            break;
                        }
                    }
                }
                else if (lllllllllllllllIllIllIIlIIIlIIlI == Blocks.yellow_flower) {
                    lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.DANDELION;
                }
                else if (lllllllllllllllIllIllIIlIIIlIIlI == Blocks.red_flower) {
                    switch (SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.func_176967_a(BlockFlower.EnumFlowerColor.RED, lllllllllllllllIllIllIIlIIIlIIll).ordinal()]) {
                        case 1: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.POPPY;
                            break;
                        }
                        case 2: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.BLUE_ORCHID;
                            break;
                        }
                        case 3: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.ALLIUM;
                            break;
                        }
                        case 4: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.HOUSTONIA;
                            break;
                        }
                        case 5: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.RED_TULIP;
                            break;
                        }
                        case 6: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.ORANGE_TULIP;
                            break;
                        }
                        case 7: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.WHITE_TULIP;
                            break;
                        }
                        case 8: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.PINK_TULIP;
                            break;
                        }
                        case 9: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.OXEYE_DAISY;
                            break;
                        }
                        default: {
                            lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.EMPTY;
                            break;
                        }
                    }
                }
                else if (lllllllllllllllIllIllIIlIIIlIIlI == Blocks.red_mushroom) {
                    lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.MUSHROOM_RED;
                }
                else if (lllllllllllllllIllIllIIlIIIlIIlI == Blocks.brown_mushroom) {
                    lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.MUSHROOM_BROWN;
                }
                else if (lllllllllllllllIllIllIIlIIIlIIlI == Blocks.deadbush) {
                    lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.DEAD_BUSH;
                }
                else if (lllllllllllllllIllIllIIlIIIlIIlI == Blocks.cactus) {
                    lllllllllllllllIllIllIIlIIIlIlll = EnumFlowerType.CACTUS;
                }
            }
        }
        return lllllllllllllllIllIllIIlIIIllIlI.withProperty(BlockFlowerPot.field_176443_b, lllllllllllllllIllIllIIlIIIlIlll);
    }
    
    private TileEntityFlowerPot func_176442_d(final World lllllllllllllllIllIllIIlIIlllIIl, final BlockPos lllllllllllllllIllIllIIlIIlllIII) {
        final TileEntity lllllllllllllllIllIllIIlIIlllIlI = lllllllllllllllIllIllIIlIIlllIIl.getTileEntity(lllllllllllllllIllIllIIlIIlllIII);
        return (lllllllllllllllIllIllIIlIIlllIlI instanceof TileEntityFlowerPot) ? ((TileEntityFlowerPot)lllllllllllllllIllIllIIlIIlllIlI) : null;
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public Item getItem(final World lllllllllllllllIllIllIIllIIIlIll, final BlockPos lllllllllllllllIllIllIIllIIIlIlI) {
        final TileEntityFlowerPot lllllllllllllllIllIllIIllIIIllIl = this.func_176442_d(lllllllllllllllIllIllIIllIIIlIll, lllllllllllllllIllIllIIllIIIlIlI);
        return (lllllllllllllllIllIllIIllIIIllIl != null && lllllllllllllllIllIllIIllIIIllIl.getFlowerPotItem() != null) ? lllllllllllllllIllIllIIllIIIllIl.getFlowerPotItem() : Items.flower_pot;
    }
    
    @Override
    public void onNeighborBlockChange(final World lllllllllllllllIllIllIIlIllIlIII, final BlockPos lllllllllllllllIllIllIIlIllIIlll, final IBlockState lllllllllllllllIllIllIIlIllIlIll, final Block lllllllllllllllIllIllIIlIllIlIlI) {
        if (!World.doesBlockHaveSolidTopSurface(lllllllllllllllIllIllIIlIllIlIII, lllllllllllllllIllIllIIlIllIIlll.offsetDown())) {
            this.dropBlockAsItem(lllllllllllllllIllIllIIlIllIlIII, lllllllllllllllIllIllIIlIllIIlll, lllllllllllllllIllIllIIlIllIlIll, 0);
            lllllllllllllllIllIllIIlIllIlIII.setBlockToAir(lllllllllllllllIllIllIIlIllIIlll);
        }
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllllIllIllIIlIlIIlIIl, final BlockPos lllllllllllllllIllIllIIlIlIIlllI, final IBlockState lllllllllllllllIllIllIIlIlIIllIl, final EntityPlayer lllllllllllllllIllIllIIlIlIIllII) {
        super.onBlockHarvested(lllllllllllllllIllIllIIlIlIIlIIl, lllllllllllllllIllIllIIlIlIIlllI, lllllllllllllllIllIllIIlIlIIllIl, lllllllllllllllIllIllIIlIlIIllII);
        if (lllllllllllllllIllIllIIlIlIIllII.capabilities.isCreativeMode) {
            final TileEntityFlowerPot lllllllllllllllIllIllIIlIlIIlIll = this.func_176442_d(lllllllllllllllIllIllIIlIlIIlIIl, lllllllllllllllIllIllIIlIlIIlllI);
            if (lllllllllllllllIllIllIIlIlIIlIll != null) {
                lllllllllllllllIllIllIIlIlIIlIll.func_145964_a(null, 0);
            }
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllllIllIllIIlIIllIIlI, final int lllllllllllllllIllIllIIlIIllIIIl) {
        Object lllllllllllllllIllIllIIlIIllIIII = null;
        int lllllllllllllllIllIllIIlIIlIllll = 0;
        switch (lllllllllllllllIllIllIIlIIllIIIl) {
            case 1: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.red_flower;
                lllllllllllllllIllIllIIlIIlIllll = BlockFlower.EnumFlowerType.POPPY.func_176968_b();
                break;
            }
            case 2: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.yellow_flower;
                break;
            }
            case 3: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.sapling;
                lllllllllllllllIllIllIIlIIlIllll = BlockPlanks.EnumType.OAK.func_176839_a();
                break;
            }
            case 4: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.sapling;
                lllllllllllllllIllIllIIlIIlIllll = BlockPlanks.EnumType.SPRUCE.func_176839_a();
                break;
            }
            case 5: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.sapling;
                lllllllllllllllIllIllIIlIIlIllll = BlockPlanks.EnumType.BIRCH.func_176839_a();
                break;
            }
            case 6: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.sapling;
                lllllllllllllllIllIllIIlIIlIllll = BlockPlanks.EnumType.JUNGLE.func_176839_a();
                break;
            }
            case 7: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.red_mushroom;
                break;
            }
            case 8: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.brown_mushroom;
                break;
            }
            case 9: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.cactus;
                break;
            }
            case 10: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.deadbush;
                break;
            }
            case 11: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.tallgrass;
                lllllllllllllllIllIllIIlIIlIllll = BlockTallGrass.EnumType.FERN.func_177044_a();
                break;
            }
            case 12: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.sapling;
                lllllllllllllllIllIllIIlIIlIllll = BlockPlanks.EnumType.ACACIA.func_176839_a();
                break;
            }
            case 13: {
                lllllllllllllllIllIllIIlIIllIIII = Blocks.sapling;
                lllllllllllllllIllIllIIlIIlIllll = BlockPlanks.EnumType.DARK_OAK.func_176839_a();
                break;
            }
        }
        return new TileEntityFlowerPot(Item.getItemFromBlock((Block)lllllllllllllllIllIllIIlIIllIIII), lllllllllllllllIllIllIIlIIlIllll);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public int colorMultiplier(final IBlockAccess lllllllllllllllIllIllIIllIlllIlI, final BlockPos lllllllllllllllIllIllIIllIlllllI, final int lllllllllllllllIllIllIIllIlllIII) {
        final TileEntity lllllllllllllllIllIllIIllIllllII = lllllllllllllllIllIllIIllIlllIlI.getTileEntity(lllllllllllllllIllIllIIllIlllllI);
        if (lllllllllllllllIllIllIIllIllllII instanceof TileEntityFlowerPot) {
            final Item lllllllllllllllIllIllIIllIlllIll = ((TileEntityFlowerPot)lllllllllllllllIllIllIIllIllllII).getFlowerPotItem();
            if (lllllllllllllllIllIllIIllIlllIll instanceof ItemBlock) {
                return Block.getBlockFromItem(lllllllllllllllIllIllIIllIlllIll).colorMultiplier(lllllllllllllllIllIllIIllIlllIlI, lllllllllllllllIllIllIIllIlllllI, lllllllllllllllIllIllIIllIlllIII);
            }
        }
        return 16777215;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockFlowerPot.field_176443_b, BlockFlowerPot.field_176444_a });
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIllIllIIllIlIIIIl, final BlockPos lllllllllllllllIllIllIIllIlIIIII, final IBlockState lllllllllllllllIllIllIIllIlIlIll, final EntityPlayer lllllllllllllllIllIllIIllIlIlIlI, final EnumFacing lllllllllllllllIllIllIIllIlIlIIl, final float lllllllllllllllIllIllIIllIlIlIII, final float lllllllllllllllIllIllIIllIlIIlll, final float lllllllllllllllIllIllIIllIlIIllI) {
        final ItemStack lllllllllllllllIllIllIIllIlIIlIl = lllllllllllllllIllIllIIllIlIlIlI.inventory.getCurrentItem();
        if (lllllllllllllllIllIllIIllIlIIlIl == null || !(lllllllllllllllIllIllIIllIlIIlIl.getItem() instanceof ItemBlock)) {
            return false;
        }
        final TileEntityFlowerPot lllllllllllllllIllIllIIllIlIIlII = this.func_176442_d(lllllllllllllllIllIllIIllIlIIIIl, lllllllllllllllIllIllIIllIlIIIII);
        if (lllllllllllllllIllIllIIllIlIIlII == null) {
            return false;
        }
        if (lllllllllllllllIllIllIIllIlIIlII.getFlowerPotItem() != null) {
            return false;
        }
        final Block lllllllllllllllIllIllIIllIlIIIll = Block.getBlockFromItem(lllllllllllllllIllIllIIllIlIIlIl.getItem());
        if (!this.func_149928_a(lllllllllllllllIllIllIIllIlIIIll, lllllllllllllllIllIllIIllIlIIlIl.getMetadata())) {
            return false;
        }
        lllllllllllllllIllIllIIllIlIIlII.func_145964_a(lllllllllllllllIllIllIIllIlIIlIl.getItem(), lllllllllllllllIllIllIIllIlIIlIl.getMetadata());
        lllllllllllllllIllIllIIllIlIIlII.markDirty();
        lllllllllllllllIllIllIIllIlIIIIl.markBlockForUpdate(lllllllllllllllIllIllIIllIlIIIII);
        if (!lllllllllllllllIllIllIIllIlIlIlI.capabilities.isCreativeMode) {
            final ItemStack itemStack = lllllllllllllllIllIllIIllIlIIlIl;
            if (--itemStack.stackSize <= 0) {
                lllllllllllllllIllIllIIllIlIlIlI.inventory.setInventorySlotContents(lllllllllllllllIllIllIIllIlIlIlI.inventory.currentItem, null);
            }
        }
        return true;
    }
    
    @Override
    public int getDamageValue(final World lllllllllllllllIllIllIIllIIIIIll, final BlockPos lllllllllllllllIllIllIIlIllllllI) {
        final TileEntityFlowerPot lllllllllllllllIllIllIIllIIIIIIl = this.func_176442_d(lllllllllllllllIllIllIIllIIIIIll, lllllllllllllllIllIllIIlIllllllI);
        return (lllllllllllllllIllIllIIllIIIIIIl != null && lllllllllllllllIllIllIIllIIIIIIl.getFlowerPotItem() != null) ? lllllllllllllllIllIllIIllIIIIIIl.getFlowerPotData() : 0;
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllIllIllIIlIlIllIlI, final BlockPos lllllllllllllllIllIllIIlIlIllllI, final IBlockState lllllllllllllllIllIllIIlIlIlllIl) {
        final TileEntityFlowerPot lllllllllllllllIllIllIIlIlIlllII = this.func_176442_d(lllllllllllllllIllIllIIlIlIllIlI, lllllllllllllllIllIllIIlIlIllllI);
        if (lllllllllllllllIllIllIIlIlIlllII != null && lllllllllllllllIllIllIIlIlIlllII.getFlowerPotItem() != null) {
            Block.spawnAsEntity(lllllllllllllllIllIllIIlIlIllIlI, lllllllllllllllIllIllIIlIlIllllI, new ItemStack(lllllllllllllllIllIllIIlIlIlllII.getFlowerPotItem(), 1, lllllllllllllllIllIllIIlIlIlllII.getFlowerPotData()));
        }
        super.breakBlock(lllllllllllllllIllIllIIlIlIllIlI, lllllllllllllllIllIllIIlIlIllllI, lllllllllllllllIllIllIIlIlIlllIl);
    }
    
    @Override
    public boolean isFlowerPot() {
        return true;
    }
    
    public enum EnumFlowerType implements IStringSerializable
    {
        WHITE_TULIP("WHITE_TULIP", 7, "WHITE_TULIP", 7, "white_tulip"), 
        MUSHROOM_BROWN("MUSHROOM_BROWN", 18, "MUSHROOM_BROWN", 18, "mushroom_brown"), 
        PINK_TULIP("PINK_TULIP", 8, "PINK_TULIP", 8, "pink_tulip"), 
        HOUSTONIA("HOUSTONIA", 4, "HOUSTONIA", 4, "houstonia"), 
        DARK_OAK_SAPLING("DARK_OAK_SAPLING", 16, "DARK_OAK_SAPLING", 16, "dark_oak_sapling"), 
        MUSHROOM_RED("MUSHROOM_RED", 17, "MUSHROOM_RED", 17, "mushroom_red"), 
        OAK_SAPLING("OAK_SAPLING", 11, "OAK_SAPLING", 11, "oak_sapling"), 
        SPRUCE_SAPLING("SPRUCE_SAPLING", 12, "SPRUCE_SAPLING", 12, "spruce_sapling"), 
        EMPTY("EMPTY", 0, "EMPTY", 0, "empty");
        
        private final /* synthetic */ String field_177006_w;
        
        DEAD_BUSH("DEAD_BUSH", 19, "DEAD_BUSH", 19, "dead_bush"), 
        BLUE_ORCHID("BLUE_ORCHID", 2, "BLUE_ORCHID", 2, "blue_orchid"), 
        BIRCH_SAPLING("BIRCH_SAPLING", 13, "BIRCH_SAPLING", 13, "birch_sapling"), 
        POPPY("POPPY", 1, "POPPY", 1, "rose"), 
        DANDELION("DANDELION", 10, "DANDELION", 10, "dandelion"), 
        ACACIA_SAPLING("ACACIA_SAPLING", 15, "ACACIA_SAPLING", 15, "acacia_sapling"), 
        OXEYE_DAISY("OXEYE_DAISY", 9, "OXEYE_DAISY", 9, "oxeye_daisy"), 
        ALLIUM("ALLIUM", 3, "ALLIUM", 3, "allium"), 
        RED_TULIP("RED_TULIP", 5, "RED_TULIP", 5, "red_tulip"), 
        CACTUS("CACTUS", 21, "CACTUS", 21, "cactus"), 
        JUNGLE_SAPLING("JUNGLE_SAPLING", 14, "JUNGLE_SAPLING", 14, "jungle_sapling"), 
        FERN("FERN", 20, "FERN", 20, "fern"), 
        ORANGE_TULIP("ORANGE_TULIP", 6, "ORANGE_TULIP", 6, "orange_tulip");
        
        @Override
        public String getName() {
            return this.field_177006_w;
        }
        
        static {
            __OBFID = "CL_00002115";
        }
        
        @Override
        public String toString() {
            return this.field_177006_w;
        }
        
        private EnumFlowerType(final String llllllllllllllllIIlIIIlllIIIlllI, final int llllllllllllllllIIlIIIlllIIIllIl, final String llllllllllllllllIIlIIIlllIIlIIlI, final int llllllllllllllllIIlIIIlllIIlIIIl, final String llllllllllllllllIIlIIIlllIIlIIII) {
            this.field_177006_w = llllllllllllllllIIlIIIlllIIlIIII;
        }
    }
    
    static final class SwitchEnumType
    {
        static final /* synthetic */ int[] field_180353_a;
        static final /* synthetic */ int[] field_180352_b;
        
        static {
            __OBFID = "CL_00002116";
            field_180352_b = new int[BlockFlower.EnumFlowerType.values().length];
            try {
                SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.POPPY.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.BLUE_ORCHID.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.ALLIUM.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.HOUSTONIA.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.RED_TULIP.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.ORANGE_TULIP.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.WHITE_TULIP.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.PINK_TULIP.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.OXEYE_DAISY.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            field_180353_a = new int[BlockPlanks.EnumType.values().length];
            try {
                SwitchEnumType.field_180353_a[BlockPlanks.EnumType.OAK.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            try {
                SwitchEnumType.field_180353_a[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError11) {}
            try {
                SwitchEnumType.field_180353_a[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError12) {}
            try {
                SwitchEnumType.field_180353_a[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError13) {}
            try {
                SwitchEnumType.field_180353_a[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError14) {}
            try {
                SwitchEnumType.field_180353_a[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError15) {}
        }
    }
}
