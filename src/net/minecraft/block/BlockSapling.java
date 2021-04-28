package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.feature.*;

public class BlockSapling extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyInteger STAGE_PROP;
    public static final /* synthetic */ PropertyEnum TYPE_PROP;
    
    @Override
    public void updateTick(final World lllllllllllllllllIIlIllIIIIlIIll, final BlockPos lllllllllllllllllIIlIllIIIIlIIlI, final IBlockState lllllllllllllllllIIlIllIIIIlIllI, final Random lllllllllllllllllIIlIllIIIIlIlIl) {
        if (!lllllllllllllllllIIlIllIIIIlIIll.isRemote) {
            super.updateTick(lllllllllllllllllIIlIllIIIIlIIll, lllllllllllllllllIIlIllIIIIlIIlI, lllllllllllllllllIIlIllIIIIlIllI, lllllllllllllllllIIlIllIIIIlIlIl);
            if (lllllllllllllllllIIlIllIIIIlIIll.getLightFromNeighbors(lllllllllllllllllIIlIllIIIIlIIlI.offsetUp()) >= 9 && lllllllllllllllllIIlIllIIIIlIlIl.nextInt(7) == 0) {
                this.func_176478_d(lllllllllllllllllIIlIllIIIIlIIll, lllllllllllllllllIIlIllIIIIlIIlI, lllllllllllllllllIIlIllIIIIlIllI, lllllllllllllllllIIlIllIIIIlIlIl);
            }
        }
    }
    
    protected BlockSapling() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSapling.TYPE_PROP, BlockPlanks.EnumType.OAK).withProperty(BlockSapling.STAGE_PROP, 0));
        final float lllllllllllllllllIIlIllIIIlIIIIl = 0.4f;
        this.setBlockBounds(0.5f - lllllllllllllllllIIlIllIIIlIIIIl, 0.0f, 0.5f - lllllllllllllllllIIlIllIIIlIIIIl, 0.5f + lllllllllllllllllIIlIllIIIlIIIIl, lllllllllllllllllIIlIllIIIlIIIIl * 2.0f, 0.5f + lllllllllllllllllIIlIllIIIlIIIIl);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllllIIlIlIlllIIIIIl, final CreativeTabs lllllllllllllllllIIlIlIlllIIIlll, final List lllllllllllllllllIIlIlIlllIIIllI) {
        for (final BlockPlanks.EnumType lllllllllllllllllIIlIlIlllIIIIlI : BlockPlanks.EnumType.values()) {
            lllllllllllllllllIIlIlIlllIIIllI.add(new ItemStack(lllllllllllllllllIIlIlIlllIIIIIl, 1, lllllllllllllllllIIlIlIlllIIIIlI.func_176839_a()));
        }
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllllllllIIlIlIllIllIlII, final Random lllllllllllllllllIIlIlIllIllIIll, final BlockPos lllllllllllllllllIIlIlIllIllIIlI, final IBlockState lllllllllllllllllIIlIlIllIllIIIl) {
        return lllllllllllllllllIIlIlIllIllIlII.rand.nextFloat() < 0.45;
    }
    
    @Override
    public void grow(final World lllllllllllllllllIIlIlIllIlIIlII, final Random lllllllllllllllllIIlIlIllIlIlIII, final BlockPos lllllllllllllllllIIlIlIllIlIIIlI, final IBlockState lllllllllllllllllIIlIlIllIlIIIIl) {
        this.func_176478_d(lllllllllllllllllIIlIlIllIlIIlII, lllllllllllllllllIIlIlIllIlIIIlI, lllllllllllllllllIIlIlIllIlIIIIl, lllllllllllllllllIIlIlIllIlIlIII);
    }
    
    @Override
    public boolean isStillGrowing(final World lllllllllllllllllIIlIlIllIlllIlI, final BlockPos lllllllllllllllllIIlIlIllIlllIIl, final IBlockState lllllllllllllllllIIlIlIllIlllIII, final boolean lllllllllllllllllIIlIlIllIllIlll) {
        return true;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockSapling.TYPE_PROP, BlockSapling.STAGE_PROP });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIIlIlIllIIllIll) {
        return this.getDefaultState().withProperty(BlockSapling.TYPE_PROP, BlockPlanks.EnumType.func_176837_a(lllllllllllllllllIIlIlIllIIllIll & 0x7)).withProperty(BlockSapling.STAGE_PROP, (lllllllllllllllllIIlIlIllIIllIll & 0x8) >> 3);
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllllIIlIlIlllIlIIII) {
        return ((BlockPlanks.EnumType)lllllllllllllllllIIlIlIlllIlIIII.getValue(BlockSapling.TYPE_PROP)).func_176839_a();
    }
    
    public void func_176478_d(final World lllllllllllllllllIIlIllIIIIIlIIl, final BlockPos lllllllllllllllllIIlIllIIIIIIIll, final IBlockState lllllllllllllllllIIlIllIIIIIIIlI, final Random lllllllllllllllllIIlIllIIIIIIllI) {
        if ((int)lllllllllllllllllIIlIllIIIIIIIlI.getValue(BlockSapling.STAGE_PROP) == 0) {
            lllllllllllllllllIIlIllIIIIIlIIl.setBlockState(lllllllllllllllllIIlIllIIIIIIIll, lllllllllllllllllIIlIllIIIIIIIlI.cycleProperty(BlockSapling.STAGE_PROP), 4);
        }
        else {
            this.func_176476_e(lllllllllllllllllIIlIllIIIIIlIIl, lllllllllllllllllIIlIllIIIIIIIll, lllllllllllllllllIIlIllIIIIIIIlI, lllllllllllllllllIIlIllIIIIIIllI);
        }
    }
    
    public boolean func_176477_a(final World lllllllllllllllllIIlIlIlllIlIlll, final BlockPos lllllllllllllllllIIlIlIlllIllIll, final BlockPlanks.EnumType lllllllllllllllllIIlIlIlllIlIlIl) {
        final IBlockState lllllllllllllllllIIlIlIlllIllIIl = lllllllllllllllllIIlIlIlllIlIlll.getBlockState(lllllllllllllllllIIlIlIlllIllIll);
        return lllllllllllllllllIIlIlIlllIllIIl.getBlock() == this && lllllllllllllllllIIlIlIlllIllIIl.getValue(BlockSapling.TYPE_PROP) == lllllllllllllllllIIlIlIlllIlIlIl;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIIlIlIllIIlIllI) {
        final byte lllllllllllllllllIIlIlIllIIlIlIl = 0;
        int lllllllllllllllllIIlIlIllIIlIlII = lllllllllllllllllIIlIlIllIIlIlIl | ((BlockPlanks.EnumType)lllllllllllllllllIIlIlIllIIlIllI.getValue(BlockSapling.TYPE_PROP)).func_176839_a();
        lllllllllllllllllIIlIlIllIIlIlII |= (int)lllllllllllllllllIIlIlIllIIlIllI.getValue(BlockSapling.STAGE_PROP) << 3;
        return lllllllllllllllllIIlIlIllIIlIlII;
    }
    
    static {
        __OBFID = "CL_00000305";
        TYPE_PROP = PropertyEnum.create("type", BlockPlanks.EnumType.class);
        STAGE_PROP = PropertyInteger.create("stage", 0, 1);
    }
    
    public void func_176476_e(final World lllllllllllllllllIIlIlIllllIlIll, final BlockPos lllllllllllllllllIIlIlIllllIlIlI, final IBlockState lllllllllllllllllIIlIlIllllIlIIl, final Random lllllllllllllllllIIlIlIlllllIIlI) {
        Object lllllllllllllllllIIlIlIlllllIIIl = (lllllllllllllllllIIlIlIlllllIIlI.nextInt(10) == 0) ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int lllllllllllllllllIIlIlIlllllIIII = 0;
        int lllllllllllllllllIIlIlIllllIllll = 0;
        boolean lllllllllllllllllIIlIlIllllIlllI = false;
        switch (SwitchEnumType.field_177065_a[((BlockPlanks.EnumType)lllllllllllllllllIIlIlIllllIlIIl.getValue(BlockSapling.TYPE_PROP)).ordinal()]) {
            case 1: {
            Label_0235:
                for (lllllllllllllllllIIlIlIlllllIIII = 0; lllllllllllllllllIIlIlIlllllIIII >= -1; --lllllllllllllllllIIlIlIlllllIIII) {
                    for (lllllllllllllllllIIlIlIllllIllll = 0; lllllllllllllllllIIlIlIllllIllll >= -1; --lllllllllllllllllIIlIlIllllIllll) {
                        if (this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll), BlockPlanks.EnumType.SPRUCE) && this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII + 1, 0, lllllllllllllllllIIlIlIllllIllll), BlockPlanks.EnumType.SPRUCE) && this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll + 1), BlockPlanks.EnumType.SPRUCE) && this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII + 1, 0, lllllllllllllllllIIlIlIllllIllll + 1), BlockPlanks.EnumType.SPRUCE)) {
                            lllllllllllllllllIIlIlIlllllIIIl = new WorldGenMegaPineTree(false, lllllllllllllllllIIlIlIlllllIIlI.nextBoolean());
                            lllllllllllllllllIIlIlIllllIlllI = true;
                            break Label_0235;
                        }
                    }
                }
                if (!lllllllllllllllllIIlIlIllllIlllI) {
                    lllllllllllllllllIIlIlIllllIllll = 0;
                    lllllllllllllllllIIlIlIlllllIIII = 0;
                    lllllllllllllllllIIlIlIlllllIIIl = new WorldGenTaiga2(true);
                    break;
                }
                break;
            }
            case 2: {
                lllllllllllllllllIIlIlIlllllIIIl = new WorldGenForest(true, false);
                break;
            }
            case 3: {
            Label_0423:
                for (lllllllllllllllllIIlIlIlllllIIII = 0; lllllllllllllllllIIlIlIlllllIIII >= -1; --lllllllllllllllllIIlIlIlllllIIII) {
                    for (lllllllllllllllllIIlIlIllllIllll = 0; lllllllllllllllllIIlIlIllllIllll >= -1; --lllllllllllllllllIIlIlIllllIllll) {
                        if (this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll), BlockPlanks.EnumType.JUNGLE) && this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII + 1, 0, lllllllllllllllllIIlIlIllllIllll), BlockPlanks.EnumType.JUNGLE) && this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll + 1), BlockPlanks.EnumType.JUNGLE) && this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII + 1, 0, lllllllllllllllllIIlIlIllllIllll + 1), BlockPlanks.EnumType.JUNGLE)) {
                            lllllllllllllllllIIlIlIlllllIIIl = new WorldGenMegaJungle(true, 10, 20, BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.JUNGLE.func_176839_a());
                            lllllllllllllllllIIlIlIllllIlllI = true;
                            break Label_0423;
                        }
                    }
                }
                if (!lllllllllllllllllIIlIlIllllIlllI) {
                    lllllllllllllllllIIlIlIllllIllll = 0;
                    lllllllllllllllllIIlIlIlllllIIII = 0;
                    lllllllllllllllllIIlIlIlllllIIIl = new WorldGenTrees(true, 4 + lllllllllllllllllIIlIlIlllllIIlI.nextInt(7), BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.JUNGLE.func_176839_a(), false);
                    break;
                }
                break;
            }
            case 4: {
                lllllllllllllllllIIlIlIlllllIIIl = new WorldGenSavannaTree(true);
                break;
            }
            case 5: {
            Label_0616:
                for (lllllllllllllllllIIlIlIlllllIIII = 0; lllllllllllllllllIIlIlIlllllIIII >= -1; --lllllllllllllllllIIlIlIlllllIIII) {
                    for (lllllllllllllllllIIlIlIllllIllll = 0; lllllllllllllllllIIlIlIllllIllll >= -1; --lllllllllllllllllIIlIlIllllIllll) {
                        if (this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll), BlockPlanks.EnumType.DARK_OAK) && this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII + 1, 0, lllllllllllllllllIIlIlIllllIllll), BlockPlanks.EnumType.DARK_OAK) && this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll + 1), BlockPlanks.EnumType.DARK_OAK) && this.func_176477_a(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII + 1, 0, lllllllllllllllllIIlIlIllllIllll + 1), BlockPlanks.EnumType.DARK_OAK)) {
                            lllllllllllllllllIIlIlIlllllIIIl = new WorldGenCanopyTree(true);
                            lllllllllllllllllIIlIlIllllIlllI = true;
                            break Label_0616;
                        }
                    }
                }
                if (!lllllllllllllllllIIlIlIllllIlllI) {
                    return;
                }
                break;
            }
        }
        final IBlockState lllllllllllllllllIIlIlIllllIllIl = Blocks.air.getDefaultState();
        if (lllllllllllllllllIIlIlIllllIlllI) {
            lllllllllllllllllIIlIlIllllIlIll.setBlockState(lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll), lllllllllllllllllIIlIlIllllIllIl, 4);
            lllllllllllllllllIIlIlIllllIlIll.setBlockState(lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII + 1, 0, lllllllllllllllllIIlIlIllllIllll), lllllllllllllllllIIlIlIllllIllIl, 4);
            lllllllllllllllllIIlIlIllllIlIll.setBlockState(lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll + 1), lllllllllllllllllIIlIlIllllIllIl, 4);
            lllllllllllllllllIIlIlIllllIlIll.setBlockState(lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII + 1, 0, lllllllllllllllllIIlIlIllllIllll + 1), lllllllllllllllllIIlIlIllllIllIl, 4);
        }
        else {
            lllllllllllllllllIIlIlIllllIlIll.setBlockState(lllllllllllllllllIIlIlIllllIlIlI, lllllllllllllllllIIlIlIllllIllIl, 4);
        }
        if (!((WorldGenerator)lllllllllllllllllIIlIlIlllllIIIl).generate(lllllllllllllllllIIlIlIllllIlIll, lllllllllllllllllIIlIlIlllllIIlI, lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll))) {
            if (lllllllllllllllllIIlIlIllllIlllI) {
                lllllllllllllllllIIlIlIllllIlIll.setBlockState(lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll), lllllllllllllllllIIlIlIllllIlIIl, 4);
                lllllllllllllllllIIlIlIllllIlIll.setBlockState(lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII + 1, 0, lllllllllllllllllIIlIlIllllIllll), lllllllllllllllllIIlIlIllllIlIIl, 4);
                lllllllllllllllllIIlIlIllllIlIll.setBlockState(lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII, 0, lllllllllllllllllIIlIlIllllIllll + 1), lllllllllllllllllIIlIlIllllIlIIl, 4);
                lllllllllllllllllIIlIlIllllIlIll.setBlockState(lllllllllllllllllIIlIlIllllIlIlI.add(lllllllllllllllllIIlIlIlllllIIII + 1, 0, lllllllllllllllllIIlIlIllllIllll + 1), lllllllllllllllllIIlIlIllllIlIIl, 4);
            }
            else {
                lllllllllllllllllIIlIlIllllIlIll.setBlockState(lllllllllllllllllIIlIlIllllIlIlI, lllllllllllllllllIIlIlIllllIlIIl, 4);
            }
        }
    }
    
    static final class SwitchEnumType
    {
        static final /* synthetic */ int[] field_177065_a;
        
        static {
            __OBFID = "CL_00002067";
            field_177065_a = new int[BlockPlanks.EnumType.values().length];
            try {
                SwitchEnumType.field_177065_a[BlockPlanks.EnumType.SPRUCE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumType.field_177065_a[BlockPlanks.EnumType.BIRCH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumType.field_177065_a[BlockPlanks.EnumType.JUNGLE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumType.field_177065_a[BlockPlanks.EnumType.ACACIA.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumType.field_177065_a[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumType.field_177065_a[BlockPlanks.EnumType.OAK.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
