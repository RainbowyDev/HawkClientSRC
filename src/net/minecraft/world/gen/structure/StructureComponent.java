package net.minecraft.world.gen.structure;

import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public abstract class StructureComponent
{
    protected /* synthetic */ StructureBoundingBox boundingBox;
    protected /* synthetic */ int componentType;
    protected /* synthetic */ EnumFacing coordBaseMode;
    
    protected void fillWithRandomizedBlocks(final World lllllllllllllllIIIlIlIllIlIllIlI, final StructureBoundingBox lllllllllllllllIIIlIlIllIlIllIIl, final int lllllllllllllllIIIlIlIllIlIIlIIl, final int lllllllllllllllIIIlIlIllIlIIlIII, final int lllllllllllllllIIIlIlIllIlIlIllI, final int lllllllllllllllIIIlIlIllIlIIIllI, final int lllllllllllllllIIIlIlIllIlIlIlII, final int lllllllllllllllIIIlIlIllIlIlIIll, final boolean lllllllllllllllIIIlIlIllIlIlIIlI, final Random lllllllllllllllIIIlIlIllIlIlIIIl, final BlockSelector lllllllllllllllIIIlIlIllIlIIIIIl) {
        for (int lllllllllllllllIIIlIlIllIlIIllll = lllllllllllllllIIIlIlIllIlIIlIII; lllllllllllllllIIIlIlIllIlIIllll <= lllllllllllllllIIIlIlIllIlIlIlII; ++lllllllllllllllIIIlIlIllIlIIllll) {
            for (int lllllllllllllllIIIlIlIllIlIIlllI = lllllllllllllllIIIlIlIllIlIIlIIl; lllllllllllllllIIIlIlIllIlIIlllI <= lllllllllllllllIIIlIlIllIlIIIllI; ++lllllllllllllllIIIlIlIllIlIIlllI) {
                for (int lllllllllllllllIIIlIlIllIlIIllIl = lllllllllllllllIIIlIlIllIlIlIllI; lllllllllllllllIIIlIlIllIlIIllIl <= lllllllllllllllIIIlIlIllIlIlIIll; ++lllllllllllllllIIIlIlIllIlIIllIl) {
                    if (!lllllllllllllllIIIlIlIllIlIlIIlI || this.func_175807_a(lllllllllllllllIIIlIlIllIlIllIlI, lllllllllllllllIIIlIlIllIlIIlllI, lllllllllllllllIIIlIlIllIlIIllll, lllllllllllllllIIIlIlIllIlIIllIl, lllllllllllllllIIIlIlIllIlIllIIl).getBlock().getMaterial() != Material.air) {
                        lllllllllllllllIIIlIlIllIlIIIIIl.selectBlocks(lllllllllllllllIIIlIlIllIlIlIIIl, lllllllllllllllIIIlIlIllIlIIlllI, lllllllllllllllIIIlIlIllIlIIllll, lllllllllllllllIIIlIlIllIlIIllIl, lllllllllllllllIIIlIlIllIlIIllll == lllllllllllllllIIIlIlIllIlIIlIII || lllllllllllllllIIIlIlIllIlIIllll == lllllllllllllllIIIlIlIllIlIlIlII || lllllllllllllllIIIlIlIllIlIIlllI == lllllllllllllllIIIlIlIllIlIIlIIl || lllllllllllllllIIIlIlIllIlIIlllI == lllllllllllllllIIIlIlIllIlIIIllI || lllllllllllllllIIIlIlIllIlIIllIl == lllllllllllllllIIIlIlIllIlIlIllI || lllllllllllllllIIIlIlIllIlIIllIl == lllllllllllllllIIIlIlIllIlIlIIll);
                        this.func_175811_a(lllllllllllllllIIIlIlIllIlIllIlI, lllllllllllllllIIIlIlIllIlIIIIIl.func_180780_a(), lllllllllllllllIIIlIlIllIlIIlllI, lllllllllllllllIIIlIlIllIlIIllll, lllllllllllllllIIIlIlIllIlIIllIl, lllllllllllllllIIIlIlIllIlIllIIl);
                    }
                }
            }
        }
    }
    
    public StructureComponent() {
    }
    
    protected void func_175809_a(final World lllllllllllllllIIIlIlIllIIIIIIII, final StructureBoundingBox lllllllllllllllIIIlIlIlIllllllll, final Random lllllllllllllllIIIlIlIlIllllIlIl, final float lllllllllllllllIIIlIlIlIllllIlII, final int lllllllllllllllIIIlIlIlIllllllII, final int lllllllllllllllIIIlIlIlIllllIIlI, final int lllllllllllllllIIIlIlIlIllllIIIl, final IBlockState lllllllllllllllIIIlIlIlIllllIIII) {
        if (lllllllllllllllIIIlIlIlIllllIlIl.nextFloat() < lllllllllllllllIIIlIlIlIllllIlII) {
            this.func_175811_a(lllllllllllllllIIIlIlIllIIIIIIII, lllllllllllllllIIIlIlIlIllllIIII, lllllllllllllllIIIlIlIlIllllllII, lllllllllllllllIIIlIlIlIllllIIlI, lllllllllllllllIIIlIlIlIllllIIIl, lllllllllllllllIIIlIlIlIllllllll);
        }
    }
    
    protected IBlockState func_175807_a(final World lllllllllllllllIIIlIlIlllllllllI, final int lllllllllllllllIIIlIlIllllllllIl, final int lllllllllllllllIIIlIllIIIIIIIlIl, final int lllllllllllllllIIIlIlIlllllllIll, final StructureBoundingBox lllllllllllllllIIIlIllIIIIIIIIll) {
        final int lllllllllllllllIIIlIllIIIIIIIIlI = this.getXWithOffset(lllllllllllllllIIIlIlIllllllllIl, lllllllllllllllIIIlIlIlllllllIll);
        final int lllllllllllllllIIIlIllIIIIIIIIIl = this.getYWithOffset(lllllllllllllllIIIlIllIIIIIIIlIl);
        final int lllllllllllllllIIIlIllIIIIIIIIII = this.getZWithOffset(lllllllllllllllIIIlIlIllllllllIl, lllllllllllllllIIIlIlIlllllllIll);
        return lllllllllllllllIIIlIllIIIIIIIIll.func_175898_b(new BlockPos(lllllllllllllllIIIlIllIIIIIIIIlI, lllllllllllllllIIIlIllIIIIIIIIIl, lllllllllllllllIIIlIllIIIIIIIIII)) ? lllllllllllllllIIIlIlIlllllllllI.getBlockState(new BlockPos(lllllllllllllllIIIlIllIIIIIIIIlI, lllllllllllllllIIIlIllIIIIIIIIIl, lllllllllllllllIIIlIllIIIIIIIIII)) : Blocks.air.getDefaultState();
    }
    
    protected boolean isLiquidInStructureBoundingBox(final World lllllllllllllllIIIlIllIIIlIlIlll, final StructureBoundingBox lllllllllllllllIIIlIllIIIllIIIll) {
        final int lllllllllllllllIIIlIllIIIllIIIlI = Math.max(this.boundingBox.minX - 1, lllllllllllllllIIIlIllIIIllIIIll.minX);
        final int lllllllllllllllIIIlIllIIIllIIIIl = Math.max(this.boundingBox.minY - 1, lllllllllllllllIIIlIllIIIllIIIll.minY);
        final int lllllllllllllllIIIlIllIIIllIIIII = Math.max(this.boundingBox.minZ - 1, lllllllllllllllIIIlIllIIIllIIIll.minZ);
        final int lllllllllllllllIIIlIllIIIlIlllll = Math.min(this.boundingBox.maxX + 1, lllllllllllllllIIIlIllIIIllIIIll.maxX);
        final int lllllllllllllllIIIlIllIIIlIllllI = Math.min(this.boundingBox.maxY + 1, lllllllllllllllIIIlIllIIIllIIIll.maxY);
        final int lllllllllllllllIIIlIllIIIlIlllIl = Math.min(this.boundingBox.maxZ + 1, lllllllllllllllIIIlIllIIIllIIIll.maxZ);
        for (int lllllllllllllllIIIlIllIIIlIlllII = lllllllllllllllIIIlIllIIIllIIIlI; lllllllllllllllIIIlIllIIIlIlllII <= lllllllllllllllIIIlIllIIIlIlllll; ++lllllllllllllllIIIlIllIIIlIlllII) {
            for (int lllllllllllllllIIIlIllIIIlIllIll = lllllllllllllllIIIlIllIIIllIIIII; lllllllllllllllIIIlIllIIIlIllIll <= lllllllllllllllIIIlIllIIIlIlllIl; ++lllllllllllllllIIIlIllIIIlIllIll) {
                if (lllllllllllllllIIIlIllIIIlIlIlll.getBlockState(new BlockPos(lllllllllllllllIIIlIllIIIlIlllII, lllllllllllllllIIIlIllIIIllIIIIl, lllllllllllllllIIIlIllIIIlIllIll)).getBlock().getMaterial().isLiquid()) {
                    return true;
                }
                if (lllllllllllllllIIIlIllIIIlIlIlll.getBlockState(new BlockPos(lllllllllllllllIIIlIllIIIlIlllII, lllllllllllllllIIIlIllIIIlIllllI, lllllllllllllllIIIlIllIIIlIllIll)).getBlock().getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        for (int lllllllllllllllIIIlIllIIIlIlllII = lllllllllllllllIIIlIllIIIllIIIlI; lllllllllllllllIIIlIllIIIlIlllII <= lllllllllllllllIIIlIllIIIlIlllll; ++lllllllllllllllIIIlIllIIIlIlllII) {
            for (int lllllllllllllllIIIlIllIIIlIllIlI = lllllllllllllllIIIlIllIIIllIIIIl; lllllllllllllllIIIlIllIIIlIllIlI <= lllllllllllllllIIIlIllIIIlIllllI; ++lllllllllllllllIIIlIllIIIlIllIlI) {
                if (lllllllllllllllIIIlIllIIIlIlIlll.getBlockState(new BlockPos(lllllllllllllllIIIlIllIIIlIlllII, lllllllllllllllIIIlIllIIIlIllIlI, lllllllllllllllIIIlIllIIIllIIIII)).getBlock().getMaterial().isLiquid()) {
                    return true;
                }
                if (lllllllllllllllIIIlIllIIIlIlIlll.getBlockState(new BlockPos(lllllllllllllllIIIlIllIIIlIlllII, lllllllllllllllIIIlIllIIIlIllIlI, lllllllllllllllIIIlIllIIIlIlllIl)).getBlock().getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        for (int lllllllllllllllIIIlIllIIIlIlllII = lllllllllllllllIIIlIllIIIllIIIII; lllllllllllllllIIIlIllIIIlIlllII <= lllllllllllllllIIIlIllIIIlIlllIl; ++lllllllllllllllIIIlIllIIIlIlllII) {
            for (int lllllllllllllllIIIlIllIIIlIllIIl = lllllllllllllllIIIlIllIIIllIIIIl; lllllllllllllllIIIlIllIIIlIllIIl <= lllllllllllllllIIIlIllIIIlIllllI; ++lllllllllllllllIIIlIllIIIlIllIIl) {
                if (lllllllllllllllIIIlIllIIIlIlIlll.getBlockState(new BlockPos(lllllllllllllllIIIlIllIIIllIIIlI, lllllllllllllllIIIlIllIIIlIllIIl, lllllllllllllllIIIlIllIIIlIlllII)).getBlock().getMaterial().isLiquid()) {
                    return true;
                }
                if (lllllllllllllllIIIlIllIIIlIlIlll.getBlockState(new BlockPos(lllllllllllllllIIIlIllIIIlIlllll, lllllllllllllllIIIlIllIIIlIllIIl, lllllllllllllllIIIlIllIIIlIlllII)).getBlock().getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected void func_180777_a(final World lllllllllllllllIIIlIlIlIllIIIIII, final StructureBoundingBox lllllllllllllllIIIlIlIlIllIlIllI, final int lllllllllllllllIIIlIlIlIllIlIlIl, final int lllllllllllllllIIIlIlIlIllIlIlII, final int lllllllllllllllIIIlIlIlIlIllllII, final int lllllllllllllllIIIlIlIlIlIlllIll, final int lllllllllllllllIIIlIlIlIllIlIIIl, final int lllllllllllllllIIIlIlIlIllIlIIII, final IBlockState lllllllllllllllIIIlIlIlIllIIllll, final boolean lllllllllllllllIIIlIlIlIllIIlllI) {
        final float lllllllllllllllIIIlIlIlIllIIllIl = (float)(lllllllllllllllIIIlIlIlIlIlllIll - lllllllllllllllIIIlIlIlIllIlIlIl + 1);
        final float lllllllllllllllIIIlIlIlIllIIllII = (float)(lllllllllllllllIIIlIlIlIllIlIIIl - lllllllllllllllIIIlIlIlIllIlIlII + 1);
        final float lllllllllllllllIIIlIlIlIllIIlIll = (float)(lllllllllllllllIIIlIlIlIllIlIIII - lllllllllllllllIIIlIlIlIlIllllII + 1);
        final float lllllllllllllllIIIlIlIlIllIIlIlI = lllllllllllllllIIIlIlIlIllIlIlIl + lllllllllllllllIIIlIlIlIllIIllIl / 2.0f;
        final float lllllllllllllllIIIlIlIlIllIIlIIl = lllllllllllllllIIIlIlIlIlIllllII + lllllllllllllllIIIlIlIlIllIIlIll / 2.0f;
        for (int lllllllllllllllIIIlIlIlIllIIlIII = lllllllllllllllIIIlIlIlIllIlIlII; lllllllllllllllIIIlIlIlIllIIlIII <= lllllllllllllllIIIlIlIlIllIlIIIl; ++lllllllllllllllIIIlIlIlIllIIlIII) {
            final float lllllllllllllllIIIlIlIlIllIIIlll = (lllllllllllllllIIIlIlIlIllIIlIII - lllllllllllllllIIIlIlIlIllIlIlII) / lllllllllllllllIIIlIlIlIllIIllII;
            for (int lllllllllllllllIIIlIlIlIllIIIllI = lllllllllllllllIIIlIlIlIllIlIlIl; lllllllllllllllIIIlIlIlIllIIIllI <= lllllllllllllllIIIlIlIlIlIlllIll; ++lllllllllllllllIIIlIlIlIllIIIllI) {
                final float lllllllllllllllIIIlIlIlIllIIIlIl = (lllllllllllllllIIIlIlIlIllIIIllI - lllllllllllllllIIIlIlIlIllIIlIlI) / (lllllllllllllllIIIlIlIlIllIIllIl * 0.5f);
                for (int lllllllllllllllIIIlIlIlIllIIIlII = lllllllllllllllIIIlIlIlIlIllllII; lllllllllllllllIIIlIlIlIllIIIlII <= lllllllllllllllIIIlIlIlIllIlIIII; ++lllllllllllllllIIIlIlIlIllIIIlII) {
                    final float lllllllllllllllIIIlIlIlIllIIIIll = (lllllllllllllllIIIlIlIlIllIIIlII - lllllllllllllllIIIlIlIlIllIIlIIl) / (lllllllllllllllIIIlIlIlIllIIlIll * 0.5f);
                    if (!lllllllllllllllIIIlIlIlIllIIlllI || this.func_175807_a(lllllllllllllllIIIlIlIlIllIIIIII, lllllllllllllllIIIlIlIlIllIIIllI, lllllllllllllllIIIlIlIlIllIIlIII, lllllllllllllllIIIlIlIlIllIIIlII, lllllllllllllllIIIlIlIlIllIlIllI).getBlock().getMaterial() != Material.air) {
                        final float lllllllllllllllIIIlIlIlIllIIIIlI = lllllllllllllllIIIlIlIlIllIIIlIl * lllllllllllllllIIIlIlIlIllIIIlIl + lllllllllllllllIIIlIlIlIllIIIlll * lllllllllllllllIIIlIlIlIllIIIlll + lllllllllllllllIIIlIlIlIllIIIIll * lllllllllllllllIIIlIlIlIllIIIIll;
                        if (lllllllllllllllIIIlIlIlIllIIIIlI <= 1.05f) {
                            this.func_175811_a(lllllllllllllllIIIlIlIlIllIIIIII, lllllllllllllllIIIlIlIlIllIIllll, lllllllllllllllIIIlIlIlIllIIIllI, lllllllllllllllIIIlIlIlIllIIlIII, lllllllllllllllIIIlIlIlIllIIIlII, lllllllllllllllIIIlIlIlIllIlIllI);
                        }
                    }
                }
            }
        }
    }
    
    protected int getXWithOffset(final int lllllllllllllllIIIlIllIIIlIIIllI, final int lllllllllllllllIIIlIllIIIlIIlIII) {
        if (this.coordBaseMode == null) {
            return lllllllllllllllIIIlIllIIIlIIIllI;
        }
        switch (SwitchEnumFacing.field_176100_a[this.coordBaseMode.ordinal()]) {
            case 1:
            case 2: {
                return this.boundingBox.minX + lllllllllllllllIIIlIllIIIlIIIllI;
            }
            case 3: {
                return this.boundingBox.maxX - lllllllllllllllIIIlIllIIIlIIlIII;
            }
            case 4: {
                return this.boundingBox.minX + lllllllllllllllIIIlIllIIIlIIlIII;
            }
            default: {
                return lllllllllllllllIIIlIllIIIlIIIllI;
            }
        }
    }
    
    protected void func_175808_b(final World lllllllllllllllIIIlIlIlIlIIIlIlI, final IBlockState lllllllllllllllIIIlIlIlIlIIIlIIl, final int lllllllllllllllIIIlIlIlIlIIIlIII, final int lllllllllllllllIIIlIlIlIIlllllIl, final int lllllllllllllllIIIlIlIlIlIIIIllI, final StructureBoundingBox lllllllllllllllIIIlIlIlIlIIIIlIl) {
        final int lllllllllllllllIIIlIlIlIlIIIIlII = this.getXWithOffset(lllllllllllllllIIIlIlIlIlIIIlIII, lllllllllllllllIIIlIlIlIlIIIIllI);
        int lllllllllllllllIIIlIlIlIlIIIIIll = this.getYWithOffset(lllllllllllllllIIIlIlIlIIlllllIl);
        final int lllllllllllllllIIIlIlIlIlIIIIIlI = this.getZWithOffset(lllllllllllllllIIIlIlIlIlIIIlIII, lllllllllllllllIIIlIlIlIlIIIIllI);
        if (lllllllllllllllIIIlIlIlIlIIIIlIl.func_175898_b(new BlockPos(lllllllllllllllIIIlIlIlIlIIIIlII, lllllllllllllllIIIlIlIlIlIIIIIll, lllllllllllllllIIIlIlIlIlIIIIIlI))) {
            while ((lllllllllllllllIIIlIlIlIlIIIlIlI.isAirBlock(new BlockPos(lllllllllllllllIIIlIlIlIlIIIIlII, lllllllllllllllIIIlIlIlIlIIIIIll, lllllllllllllllIIIlIlIlIlIIIIIlI)) || lllllllllllllllIIIlIlIlIlIIIlIlI.getBlockState(new BlockPos(lllllllllllllllIIIlIlIlIlIIIIlII, lllllllllllllllIIIlIlIlIlIIIIIll, lllllllllllllllIIIlIlIlIlIIIIIlI)).getBlock().getMaterial().isLiquid()) && lllllllllllllllIIIlIlIlIlIIIIIll > 1) {
                lllllllllllllllIIIlIlIlIlIIIlIlI.setBlockState(new BlockPos(lllllllllllllllIIIlIlIlIlIIIIlII, lllllllllllllllIIIlIlIlIlIIIIIll, lllllllllllllllIIIlIlIlIlIIIIIlI), lllllllllllllllIIIlIlIlIlIIIlIIl, 2);
                --lllllllllllllllIIIlIlIlIlIIIIIll;
            }
        }
    }
    
    public static StructureComponent findIntersecting(final List lllllllllllllllIIIlIllIIIllllIll, final StructureBoundingBox lllllllllllllllIIIlIllIIIllllIlI) {
        for (final StructureComponent lllllllllllllllIIIlIllIIIllllIII : lllllllllllllllIIIlIllIIIllllIll) {
            if (lllllllllllllllIIIlIllIIIllllIII.getBoundingBox() != null && lllllllllllllllIIIlIllIIIllllIII.getBoundingBox().intersectsWith(lllllllllllllllIIIlIllIIIllllIlI)) {
                return lllllllllllllllIIIlIllIIIllllIII;
            }
        }
        return null;
    }
    
    public void buildComponent(final StructureComponent lllllllllllllllIIIlIllIIlIIIlIII, final List lllllllllllllllIIIlIllIIlIIIIlll, final Random lllllllllllllllIIIlIllIIlIIIIllI) {
    }
    
    public BlockPos func_180776_a() {
        return new BlockPos(this.boundingBox.func_180717_f());
    }
    
    static {
        __OBFID = "CL_00000511";
    }
    
    protected void func_175805_a(final World lllllllllllllllIIIlIlIllIIIllIlI, final StructureBoundingBox lllllllllllllllIIIlIlIllIIlIlIlI, final Random lllllllllllllllIIIlIlIllIIlIlIIl, final float lllllllllllllllIIIlIlIllIIlIlIII, final int lllllllllllllllIIIlIlIllIIlIIlll, final int lllllllllllllllIIIlIlIllIIIlIlIl, final int lllllllllllllllIIIlIlIllIIIlIlII, final int lllllllllllllllIIIlIlIllIIlIIlII, final int lllllllllllllllIIIlIlIllIIIlIIlI, final int lllllllllllllllIIIlIlIllIIlIIIlI, final IBlockState lllllllllllllllIIIlIlIllIIIlIIII, final IBlockState lllllllllllllllIIIlIlIllIIlIIIII, final boolean lllllllllllllllIIIlIlIllIIIlllll) {
        for (int lllllllllllllllIIIlIlIllIIIllllI = lllllllllllllllIIIlIlIllIIIlIlIl; lllllllllllllllIIIlIlIllIIIllllI <= lllllllllllllllIIIlIlIllIIIlIIlI; ++lllllllllllllllIIIlIlIllIIIllllI) {
            for (int lllllllllllllllIIIlIlIllIIIlllIl = lllllllllllllllIIIlIlIllIIlIIlll; lllllllllllllllIIIlIlIllIIIlllIl <= lllllllllllllllIIIlIlIllIIlIIlII; ++lllllllllllllllIIIlIlIllIIIlllIl) {
                for (int lllllllllllllllIIIlIlIllIIIlllII = lllllllllllllllIIIlIlIllIIIlIlII; lllllllllllllllIIIlIlIllIIIlllII <= lllllllllllllllIIIlIlIllIIlIIIlI; ++lllllllllllllllIIIlIlIllIIIlllII) {
                    if (lllllllllllllllIIIlIlIllIIlIlIIl.nextFloat() <= lllllllllllllllIIIlIlIllIIlIlIII && (!lllllllllllllllIIIlIlIllIIIlllll || this.func_175807_a(lllllllllllllllIIIlIlIllIIIllIlI, lllllllllllllllIIIlIlIllIIIlllIl, lllllllllllllllIIIlIlIllIIIllllI, lllllllllllllllIIIlIlIllIIIlllII, lllllllllllllllIIIlIlIllIIlIlIlI).getBlock().getMaterial() != Material.air)) {
                        if (lllllllllllllllIIIlIlIllIIIllllI != lllllllllllllllIIIlIlIllIIIlIlIl && lllllllllllllllIIIlIlIllIIIllllI != lllllllllllllllIIIlIlIllIIIlIIlI && lllllllllllllllIIIlIlIllIIIlllIl != lllllllllllllllIIIlIlIllIIlIIlll && lllllllllllllllIIIlIlIllIIIlllIl != lllllllllllllllIIIlIlIllIIlIIlII && lllllllllllllllIIIlIlIllIIIlllII != lllllllllllllllIIIlIlIllIIIlIlII && lllllllllllllllIIIlIlIllIIIlllII != lllllllllllllllIIIlIlIllIIlIIIlI) {
                            this.func_175811_a(lllllllllllllllIIIlIlIllIIIllIlI, lllllllllllllllIIIlIlIllIIlIIIII, lllllllllllllllIIIlIlIllIIIlllIl, lllllllllllllllIIIlIlIllIIIllllI, lllllllllllllllIIIlIlIllIIIlllII, lllllllllllllllIIIlIlIllIIlIlIlI);
                        }
                        else {
                            this.func_175811_a(lllllllllllllllIIIlIlIllIIIllIlI, lllllllllllllllIIIlIlIllIIIlIIII, lllllllllllllllIIIlIlIllIIIlllIl, lllllllllllllllIIIlIlIllIIIllllI, lllllllllllllllIIIlIlIllIIIlllII, lllllllllllllllIIIlIlIllIIlIlIlI);
                        }
                    }
                }
            }
        }
    }
    
    public StructureBoundingBox getBoundingBox() {
        return this.boundingBox;
    }
    
    public void func_143009_a(final World lllllllllllllllIIIlIllIIlIIIllll, final NBTTagCompound lllllllllllllllIIIlIllIIlIIIlllI) {
        if (lllllllllllllllIIIlIllIIlIIIlllI.hasKey("BB")) {
            this.boundingBox = new StructureBoundingBox(lllllllllllllllIIIlIllIIlIIIlllI.getIntArray("BB"));
        }
        final int lllllllllllllllIIIlIllIIlIIIllIl = lllllllllllllllIIIlIllIIlIIIlllI.getInteger("O");
        this.coordBaseMode = ((lllllllllllllllIIIlIllIIlIIIllIl == -1) ? null : EnumFacing.getHorizontal(lllllllllllllllIIIlIllIIlIIIllIl));
        this.componentType = lllllllllllllllIIIlIllIIlIIIlllI.getInteger("GD");
        this.readStructureFromNBT(lllllllllllllllIIIlIllIIlIIIlllI);
    }
    
    protected abstract void readStructureFromNBT(final NBTTagCompound p0);
    
    protected boolean func_180778_a(final World lllllllllllllllIIIlIlIlIIlIllllI, final StructureBoundingBox lllllllllllllllIIIlIlIlIIllIlIIl, final Random lllllllllllllllIIIlIlIlIIlIlllII, final int lllllllllllllllIIIlIlIlIIllIIlll, final int lllllllllllllllIIIlIlIlIIllIIllI, final int lllllllllllllllIIIlIlIlIIllIIlIl, final List lllllllllllllllIIIlIlIlIIllIIlII, final int lllllllllllllllIIIlIlIlIIlIlIlll) {
        final BlockPos lllllllllllllllIIIlIlIlIIllIIIlI = new BlockPos(this.getXWithOffset(lllllllllllllllIIIlIlIlIIllIIlll, lllllllllllllllIIIlIlIlIIllIIlIl), this.getYWithOffset(lllllllllllllllIIIlIlIlIIllIIllI), this.getZWithOffset(lllllllllllllllIIIlIlIlIIllIIlll, lllllllllllllllIIIlIlIlIIllIIlIl));
        if (lllllllllllllllIIIlIlIlIIllIlIIl.func_175898_b(lllllllllllllllIIIlIlIlIIllIIIlI) && lllllllllllllllIIIlIlIlIIlIllllI.getBlockState(lllllllllllllllIIIlIlIlIIllIIIlI).getBlock() != Blocks.chest) {
            final IBlockState lllllllllllllllIIIlIlIlIIllIIIIl = Blocks.chest.getDefaultState();
            lllllllllllllllIIIlIlIlIIlIllllI.setBlockState(lllllllllllllllIIIlIlIlIIllIIIlI, Blocks.chest.func_176458_f(lllllllllllllllIIIlIlIlIIlIllllI, lllllllllllllllIIIlIlIlIIllIIIlI, lllllllllllllllIIIlIlIlIIllIIIIl), 2);
            final TileEntity lllllllllllllllIIIlIlIlIIllIIIII = lllllllllllllllIIIlIlIlIIlIllllI.getTileEntity(lllllllllllllllIIIlIlIlIIllIIIlI);
            if (lllllllllllllllIIIlIlIlIIllIIIII instanceof TileEntityChest) {
                WeightedRandomChestContent.generateChestContents(lllllllllllllllIIIlIlIlIIlIlllII, lllllllllllllllIIIlIlIlIIllIIlII, (IInventory)lllllllllllllllIIIlIlIlIIllIIIII, lllllllllllllllIIIlIlIlIIlIlIlll);
            }
            return true;
        }
        return false;
    }
    
    protected int getYWithOffset(final int lllllllllllllllIIIlIllIIIlIIIIIl) {
        return (this.coordBaseMode == null) ? lllllllllllllllIIIlIllIIIlIIIIIl : (lllllllllllllllIIIlIllIIIlIIIIIl + this.boundingBox.minY);
    }
    
    public int getComponentType() {
        return this.componentType;
    }
    
    protected void clearCurrentPositionBlocksUpwards(final World lllllllllllllllIIIlIlIlIlIlIIIlI, final int lllllllllllllllIIIlIlIlIlIlIIIIl, final int lllllllllllllllIIIlIlIlIlIlIIIII, final int lllllllllllllllIIIlIlIlIlIIlllll, final StructureBoundingBox lllllllllllllllIIIlIlIlIlIIlIlll) {
        BlockPos lllllllllllllllIIIlIlIlIlIIlllIl = new BlockPos(this.getXWithOffset(lllllllllllllllIIIlIlIlIlIlIIIIl, lllllllllllllllIIIlIlIlIlIIlllll), this.getYWithOffset(lllllllllllllllIIIlIlIlIlIlIIIII), this.getZWithOffset(lllllllllllllllIIIlIlIlIlIlIIIIl, lllllllllllllllIIIlIlIlIlIIlllll));
        if (lllllllllllllllIIIlIlIlIlIIlIlll.func_175898_b(lllllllllllllllIIIlIlIlIlIIlllIl)) {
            while (!lllllllllllllllIIIlIlIlIlIlIIIlI.isAirBlock(lllllllllllllllIIIlIlIlIlIIlllIl) && lllllllllllllllIIIlIlIlIlIIlllIl.getY() < 255) {
                lllllllllllllllIIIlIlIlIlIlIIIlI.setBlockState(lllllllllllllllIIIlIlIlIlIIlllIl, Blocks.air.getDefaultState(), 2);
                lllllllllllllllIIIlIlIlIlIIlllIl = lllllllllllllllIIIlIlIlIlIIlllIl.offsetUp();
            }
        }
    }
    
    public NBTTagCompound func_143010_b() {
        final NBTTagCompound lllllllllllllllIIIlIllIIlIIlIllI = new NBTTagCompound();
        lllllllllllllllIIIlIllIIlIIlIllI.setString("id", MapGenStructureIO.func_143036_a(this));
        lllllllllllllllIIIlIllIIlIIlIllI.setTag("BB", this.boundingBox.func_151535_h());
        lllllllllllllllIIIlIllIIlIIlIllI.setInteger("O", (this.coordBaseMode == null) ? -1 : this.coordBaseMode.getHorizontalIndex());
        lllllllllllllllIIIlIllIIlIIlIllI.setInteger("GD", this.componentType);
        this.writeStructureToNBT(lllllllllllllllIIIlIllIIlIIlIllI);
        return lllllllllllllllIIIlIllIIlIIlIllI;
    }
    
    protected int getZWithOffset(final int lllllllllllllllIIIlIllIIIIlllIlI, final int lllllllllllllllIIIlIllIIIIlllIIl) {
        if (this.coordBaseMode == null) {
            return lllllllllllllllIIIlIllIIIIlllIIl;
        }
        switch (SwitchEnumFacing.field_176100_a[this.coordBaseMode.ordinal()]) {
            case 1: {
                return this.boundingBox.maxZ - lllllllllllllllIIIlIllIIIIlllIIl;
            }
            case 2: {
                return this.boundingBox.minZ + lllllllllllllllIIIlIllIIIIlllIIl;
            }
            case 3:
            case 4: {
                return this.boundingBox.minZ + lllllllllllllllIIIlIllIIIIlllIlI;
            }
            default: {
                return lllllllllllllllIIIlIllIIIIlllIIl;
            }
        }
    }
    
    protected boolean func_175806_a(final World lllllllllllllllIIIlIlIlIIIlllIlI, final StructureBoundingBox lllllllllllllllIIIlIlIlIIlIIIlIl, final Random lllllllllllllllIIIlIlIlIIIlllIII, final int lllllllllllllllIIIlIlIlIIlIIIIll, final int lllllllllllllllIIIlIlIlIIlIIIIlI, final int lllllllllllllllIIIlIlIlIIIllIlIl, final int lllllllllllllllIIIlIlIlIIIllIlII, final List lllllllllllllllIIIlIlIlIIIllIIll, final int lllllllllllllllIIIlIlIlIIIlllllI) {
        final BlockPos lllllllllllllllIIIlIlIlIIIllllIl = new BlockPos(this.getXWithOffset(lllllllllllllllIIIlIlIlIIlIIIIll, lllllllllllllllIIIlIlIlIIIllIlIl), this.getYWithOffset(lllllllllllllllIIIlIlIlIIlIIIIlI), this.getZWithOffset(lllllllllllllllIIIlIlIlIIlIIIIll, lllllllllllllllIIIlIlIlIIIllIlIl));
        if (lllllllllllllllIIIlIlIlIIlIIIlIl.func_175898_b(lllllllllllllllIIIlIlIlIIIllllIl) && lllllllllllllllIIIlIlIlIIIlllIlI.getBlockState(lllllllllllllllIIIlIlIlIIIllllIl).getBlock() != Blocks.dispenser) {
            lllllllllllllllIIIlIlIlIIIlllIlI.setBlockState(lllllllllllllllIIIlIlIlIIIllllIl, Blocks.dispenser.getStateFromMeta(this.getMetadataWithOffset(Blocks.dispenser, lllllllllllllllIIIlIlIlIIIllIlII)), 2);
            final TileEntity lllllllllllllllIIIlIlIlIIIllllII = lllllllllllllllIIIlIlIlIIIlllIlI.getTileEntity(lllllllllllllllIIIlIlIlIIIllllIl);
            if (lllllllllllllllIIIlIlIlIIIllllII instanceof TileEntityDispenser) {
                WeightedRandomChestContent.func_177631_a(lllllllllllllllIIIlIlIlIIIlllIII, lllllllllllllllIIIlIlIlIIIllIIll, (TileEntityDispenser)lllllllllllllllIIIlIlIlIIIllllII, lllllllllllllllIIIlIlIlIIIlllllI);
            }
            return true;
        }
        return false;
    }
    
    protected void func_175804_a(final World lllllllllllllllIIIlIlIlllIlIIIII, final StructureBoundingBox lllllllllllllllIIIlIlIlllIIIlIIl, final int lllllllllllllllIIIlIlIlllIIIlIII, final int lllllllllllllllIIIlIlIlllIIllIlI, final int lllllllllllllllIIIlIlIlllIIIIlIl, final int lllllllllllllllIIIlIlIlllIIIIIll, final int lllllllllllllllIIIlIlIlllIIIIIIl, final int lllllllllllllllIIIlIlIlllIIIIIII, final IBlockState lllllllllllllllIIIlIlIllIlllllll, final IBlockState lllllllllllllllIIIlIlIlllIIlIIII, final boolean lllllllllllllllIIIlIlIlllIIIllll) {
        for (int lllllllllllllllIIIlIlIlllIIIlllI = lllllllllllllllIIIlIlIlllIIllIlI; lllllllllllllllIIIlIlIlllIIIlllI <= lllllllllllllllIIIlIlIlllIIIIIIl; ++lllllllllllllllIIIlIlIlllIIIlllI) {
            for (int lllllllllllllllIIIlIlIlllIIIllIl = lllllllllllllllIIIlIlIlllIIIlIII; lllllllllllllllIIIlIlIlllIIIllIl <= lllllllllllllllIIIlIlIlllIIIIIll; ++lllllllllllllllIIIlIlIlllIIIllIl) {
                for (int lllllllllllllllIIIlIlIlllIIIllII = lllllllllllllllIIIlIlIlllIIIIlIl; lllllllllllllllIIIlIlIlllIIIllII <= lllllllllllllllIIIlIlIlllIIIIIII; ++lllllllllllllllIIIlIlIlllIIIllII) {
                    if (!lllllllllllllllIIIlIlIlllIIIllll || this.func_175807_a(lllllllllllllllIIIlIlIlllIlIIIII, lllllllllllllllIIIlIlIlllIIIllIl, lllllllllllllllIIIlIlIlllIIIlllI, lllllllllllllllIIIlIlIlllIIIllII, lllllllllllllllIIIlIlIlllIIIlIIl).getBlock().getMaterial() != Material.air) {
                        if (lllllllllllllllIIIlIlIlllIIIlllI != lllllllllllllllIIIlIlIlllIIllIlI && lllllllllllllllIIIlIlIlllIIIlllI != lllllllllllllllIIIlIlIlllIIIIIIl && lllllllllllllllIIIlIlIlllIIIllIl != lllllllllllllllIIIlIlIlllIIIlIII && lllllllllllllllIIIlIlIlllIIIllIl != lllllllllllllllIIIlIlIlllIIIIIll && lllllllllllllllIIIlIlIlllIIIllII != lllllllllllllllIIIlIlIlllIIIIlIl && lllllllllllllllIIIlIlIlllIIIllII != lllllllllllllllIIIlIlIlllIIIIIII) {
                            this.func_175811_a(lllllllllllllllIIIlIlIlllIlIIIII, lllllllllllllllIIIlIlIlllIIlIIII, lllllllllllllllIIIlIlIlllIIIllIl, lllllllllllllllIIIlIlIlllIIIlllI, lllllllllllllllIIIlIlIlllIIIllII, lllllllllllllllIIIlIlIlllIIIlIIl);
                        }
                        else {
                            this.func_175811_a(lllllllllllllllIIIlIlIlllIlIIIII, lllllllllllllllIIIlIlIllIlllllll, lllllllllllllllIIIlIlIlllIIIllIl, lllllllllllllllIIIlIlIlllIIIlllI, lllllllllllllllIIIlIlIlllIIIllII, lllllllllllllllIIIlIlIlllIIIlIIl);
                        }
                    }
                }
            }
        }
    }
    
    protected StructureComponent(final int lllllllllllllllIIIlIllIIlIIlllII) {
        this.componentType = lllllllllllllllIIIlIllIIlIIlllII;
    }
    
    protected int getMetadataWithOffset(final Block lllllllllllllllIIIlIllIIIIlIllII, final int lllllllllllllllIIIlIllIIIIlIllll) {
        if (lllllllllllllllIIIlIllIIIIlIllII == Blocks.rail) {
            if (this.coordBaseMode == EnumFacing.WEST || this.coordBaseMode == EnumFacing.EAST) {
                if (lllllllllllllllIIIlIllIIIIlIllll == 1) {
                    return 0;
                }
                return 1;
            }
        }
        else if (lllllllllllllllIIIlIllIIIIlIllII instanceof BlockDoor) {
            if (this.coordBaseMode == EnumFacing.SOUTH) {
                if (lllllllllllllllIIIlIllIIIIlIllll == 0) {
                    return 2;
                }
                if (lllllllllllllllIIIlIllIIIIlIllll == 2) {
                    return 0;
                }
            }
            else {
                if (this.coordBaseMode == EnumFacing.WEST) {
                    return lllllllllllllllIIIlIllIIIIlIllll + 1 & 0x3;
                }
                if (this.coordBaseMode == EnumFacing.EAST) {
                    return lllllllllllllllIIIlIllIIIIlIllll + 3 & 0x3;
                }
            }
        }
        else if (lllllllllllllllIIIlIllIIIIlIllII != Blocks.stone_stairs && lllllllllllllllIIIlIllIIIIlIllII != Blocks.oak_stairs && lllllllllllllllIIIlIllIIIIlIllII != Blocks.nether_brick_stairs && lllllllllllllllIIIlIllIIIIlIllII != Blocks.stone_brick_stairs && lllllllllllllllIIIlIllIIIIlIllII != Blocks.sandstone_stairs) {
            if (lllllllllllllllIIIlIllIIIIlIllII == Blocks.ladder) {
                if (this.coordBaseMode == EnumFacing.SOUTH) {
                    if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.NORTH.getIndex()) {
                        return EnumFacing.SOUTH.getIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.SOUTH.getIndex()) {
                        return EnumFacing.NORTH.getIndex();
                    }
                }
                else if (this.coordBaseMode == EnumFacing.WEST) {
                    if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.NORTH.getIndex()) {
                        return EnumFacing.WEST.getIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.SOUTH.getIndex()) {
                        return EnumFacing.EAST.getIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.WEST.getIndex()) {
                        return EnumFacing.NORTH.getIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.EAST.getIndex()) {
                        return EnumFacing.SOUTH.getIndex();
                    }
                }
                else if (this.coordBaseMode == EnumFacing.EAST) {
                    if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.NORTH.getIndex()) {
                        return EnumFacing.EAST.getIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.SOUTH.getIndex()) {
                        return EnumFacing.WEST.getIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.WEST.getIndex()) {
                        return EnumFacing.NORTH.getIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.EAST.getIndex()) {
                        return EnumFacing.SOUTH.getIndex();
                    }
                }
            }
            else if (lllllllllllllllIIIlIllIIIIlIllII == Blocks.stone_button) {
                if (this.coordBaseMode == EnumFacing.SOUTH) {
                    if (lllllllllllllllIIIlIllIIIIlIllll == 3) {
                        return 4;
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == 4) {
                        return 3;
                    }
                }
                else if (this.coordBaseMode == EnumFacing.WEST) {
                    if (lllllllllllllllIIIlIllIIIIlIllll == 3) {
                        return 1;
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == 4) {
                        return 2;
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == 2) {
                        return 3;
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == 1) {
                        return 4;
                    }
                }
                else if (this.coordBaseMode == EnumFacing.EAST) {
                    if (lllllllllllllllIIIlIllIIIIlIllll == 3) {
                        return 2;
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == 4) {
                        return 1;
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == 2) {
                        return 3;
                    }
                    if (lllllllllllllllIIIlIllIIIIlIllll == 1) {
                        return 4;
                    }
                }
            }
            else if (lllllllllllllllIIIlIllIIIIlIllII != Blocks.tripwire_hook && !(lllllllllllllllIIIlIllIIIIlIllII instanceof BlockDirectional)) {
                if (lllllllllllllllIIIlIllIIIIlIllII == Blocks.piston || lllllllllllllllIIIlIllIIIIlIllII == Blocks.sticky_piston || lllllllllllllllIIIlIllIIIIlIllII == Blocks.lever || lllllllllllllllIIIlIllIIIIlIllII == Blocks.dispenser) {
                    if (this.coordBaseMode == EnumFacing.SOUTH) {
                        if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.NORTH.getIndex() || lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.SOUTH.getIndex()) {
                            return EnumFacing.getFront(lllllllllllllllIIIlIllIIIIlIllll).getOpposite().getIndex();
                        }
                    }
                    else if (this.coordBaseMode == EnumFacing.WEST) {
                        if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.NORTH.getIndex()) {
                            return EnumFacing.WEST.getIndex();
                        }
                        if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.SOUTH.getIndex()) {
                            return EnumFacing.EAST.getIndex();
                        }
                        if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.WEST.getIndex()) {
                            return EnumFacing.NORTH.getIndex();
                        }
                        if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.EAST.getIndex()) {
                            return EnumFacing.SOUTH.getIndex();
                        }
                    }
                    else if (this.coordBaseMode == EnumFacing.EAST) {
                        if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.NORTH.getIndex()) {
                            return EnumFacing.EAST.getIndex();
                        }
                        if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.SOUTH.getIndex()) {
                            return EnumFacing.WEST.getIndex();
                        }
                        if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.WEST.getIndex()) {
                            return EnumFacing.NORTH.getIndex();
                        }
                        if (lllllllllllllllIIIlIllIIIIlIllll == EnumFacing.EAST.getIndex()) {
                            return EnumFacing.SOUTH.getIndex();
                        }
                    }
                }
            }
            else {
                final EnumFacing lllllllllllllllIIIlIllIIIIlIlllI = EnumFacing.getHorizontal(lllllllllllllllIIIlIllIIIIlIllll);
                if (this.coordBaseMode == EnumFacing.SOUTH) {
                    if (lllllllllllllllIIIlIllIIIIlIlllI == EnumFacing.SOUTH || lllllllllllllllIIIlIllIIIIlIlllI == EnumFacing.NORTH) {
                        return lllllllllllllllIIIlIllIIIIlIlllI.getOpposite().getHorizontalIndex();
                    }
                }
                else if (this.coordBaseMode == EnumFacing.WEST) {
                    if (lllllllllllllllIIIlIllIIIIlIlllI == EnumFacing.NORTH) {
                        return EnumFacing.WEST.getHorizontalIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIlllI == EnumFacing.SOUTH) {
                        return EnumFacing.EAST.getHorizontalIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIlllI == EnumFacing.WEST) {
                        return EnumFacing.NORTH.getHorizontalIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIlllI == EnumFacing.EAST) {
                        return EnumFacing.SOUTH.getHorizontalIndex();
                    }
                }
                else if (this.coordBaseMode == EnumFacing.EAST) {
                    if (lllllllllllllllIIIlIllIIIIlIlllI == EnumFacing.NORTH) {
                        return EnumFacing.EAST.getHorizontalIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIlllI == EnumFacing.SOUTH) {
                        return EnumFacing.WEST.getHorizontalIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIlllI == EnumFacing.WEST) {
                        return EnumFacing.NORTH.getHorizontalIndex();
                    }
                    if (lllllllllllllllIIIlIllIIIIlIlllI == EnumFacing.EAST) {
                        return EnumFacing.SOUTH.getHorizontalIndex();
                    }
                }
            }
        }
        else if (this.coordBaseMode == EnumFacing.SOUTH) {
            if (lllllllllllllllIIIlIllIIIIlIllll == 2) {
                return 3;
            }
            if (lllllllllllllllIIIlIllIIIIlIllll == 3) {
                return 2;
            }
        }
        else if (this.coordBaseMode == EnumFacing.WEST) {
            if (lllllllllllllllIIIlIllIIIIlIllll == 0) {
                return 2;
            }
            if (lllllllllllllllIIIlIllIIIIlIllll == 1) {
                return 3;
            }
            if (lllllllllllllllIIIlIllIIIIlIllll == 2) {
                return 0;
            }
            if (lllllllllllllllIIIlIllIIIIlIllll == 3) {
                return 1;
            }
        }
        else if (this.coordBaseMode == EnumFacing.EAST) {
            if (lllllllllllllllIIIlIllIIIIlIllll == 0) {
                return 2;
            }
            if (lllllllllllllllIIIlIllIIIIlIllll == 1) {
                return 3;
            }
            if (lllllllllllllllIIIlIllIIIIlIllll == 2) {
                return 1;
            }
            if (lllllllllllllllIIIlIllIIIIlIllll == 3) {
                return 0;
            }
        }
        return lllllllllllllllIIIlIllIIIIlIllll;
    }
    
    protected abstract void writeStructureToNBT(final NBTTagCompound p0);
    
    protected void fillWithAir(final World lllllllllllllllIIIlIlIllllIllIlI, final StructureBoundingBox lllllllllllllllIIIlIlIlllllIlIII, final int lllllllllllllllIIIlIlIllllIllIII, final int lllllllllllllllIIIlIlIlllllIIlIl, final int lllllllllllllllIIIlIlIlllllIIIll, final int lllllllllllllllIIIlIlIlllllIIIlI, final int lllllllllllllllIIIlIlIllllIlIIIl, final int lllllllllllllllIIIlIlIllllIlIIII) {
        for (int lllllllllllllllIIIlIlIllllIllllI = lllllllllllllllIIIlIlIlllllIIlIl; lllllllllllllllIIIlIlIllllIllllI <= lllllllllllllllIIIlIlIllllIlIIIl; ++lllllllllllllllIIIlIlIllllIllllI) {
            for (int lllllllllllllllIIIlIlIllllIlllIl = lllllllllllllllIIIlIlIllllIllIII; lllllllllllllllIIIlIlIllllIlllIl <= lllllllllllllllIIIlIlIlllllIIIlI; ++lllllllllllllllIIIlIlIllllIlllIl) {
                for (int lllllllllllllllIIIlIlIllllIlllII = lllllllllllllllIIIlIlIlllllIIIll; lllllllllllllllIIIlIlIllllIlllII <= lllllllllllllllIIIlIlIllllIlIIII; ++lllllllllllllllIIIlIlIllllIlllII) {
                    this.func_175811_a(lllllllllllllllIIIlIlIllllIllIlI, Blocks.air.getDefaultState(), lllllllllllllllIIIlIlIllllIlllIl, lllllllllllllllIIIlIlIllllIllllI, lllllllllllllllIIIlIlIllllIlllII, lllllllllllllllIIIlIlIlllllIlIII);
                }
            }
        }
    }
    
    public abstract boolean addComponentParts(final World p0, final Random p1, final StructureBoundingBox p2);
    
    protected void func_175811_a(final World lllllllllllllllIIIlIllIIIIIllIII, final IBlockState lllllllllllllllIIIlIllIIIIIlllll, final int lllllllllllllllIIIlIllIIIIIllllI, final int lllllllllllllllIIIlIllIIIIIlIlIl, final int lllllllllllllllIIIlIllIIIIIlIlII, final StructureBoundingBox lllllllllllllllIIIlIllIIIIIlIIll) {
        final BlockPos lllllllllllllllIIIlIllIIIIIllIlI = new BlockPos(this.getXWithOffset(lllllllllllllllIIIlIllIIIIIllllI, lllllllllllllllIIIlIllIIIIIlIlII), this.getYWithOffset(lllllllllllllllIIIlIllIIIIIlIlIl), this.getZWithOffset(lllllllllllllllIIIlIllIIIIIllllI, lllllllllllllllIIIlIllIIIIIlIlII));
        if (lllllllllllllllIIIlIllIIIIIlIIll.func_175898_b(lllllllllllllllIIIlIllIIIIIllIlI)) {
            lllllllllllllllIIIlIllIIIIIllIII.setBlockState(lllllllllllllllIIIlIllIIIIIllIlI, lllllllllllllllIIIlIllIIIIIlllll, 2);
        }
    }
    
    protected void func_175810_a(final World lllllllllllllllIIIlIlIlIIIlIIllI, final StructureBoundingBox lllllllllllllllIIIlIlIlIIIlIIlIl, final Random lllllllllllllllIIIlIlIlIIIlIIlII, final int lllllllllllllllIIIlIlIlIIIlIIIll, final int lllllllllllllllIIIlIlIlIIIlIIIlI, final int lllllllllllllllIIIlIlIlIIIlIIIIl, final EnumFacing lllllllllllllllIIIlIlIlIIIIllIII) {
        final BlockPos lllllllllllllllIIIlIlIlIIIIlllll = new BlockPos(this.getXWithOffset(lllllllllllllllIIIlIlIlIIIlIIIll, lllllllllllllllIIIlIlIlIIIlIIIIl), this.getYWithOffset(lllllllllllllllIIIlIlIlIIIlIIIlI), this.getZWithOffset(lllllllllllllllIIIlIlIlIIIlIIIll, lllllllllllllllIIIlIlIlIIIlIIIIl));
        if (lllllllllllllllIIIlIlIlIIIlIIlIl.func_175898_b(lllllllllllllllIIIlIlIlIIIIlllll)) {
            ItemDoor.func_179235_a(lllllllllllllllIIIlIlIlIIIlIIllI, lllllllllllllllIIIlIlIlIIIIlllll, lllllllllllllllIIIlIlIlIIIIllIII.rotateYCCW(), Blocks.oak_door);
        }
    }
    
    public abstract static class BlockSelector
    {
        protected /* synthetic */ IBlockState field_151562_a;
        
        protected BlockSelector() {
            this.field_151562_a = Blocks.air.getDefaultState();
        }
        
        public IBlockState func_180780_a() {
            return this.field_151562_a;
        }
        
        static {
            __OBFID = "CL_00000512";
        }
        
        public abstract void selectBlocks(final Random p0, final int p1, final int p2, final int p3, final boolean p4);
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_176100_a;
        
        static {
            __OBFID = "CL_00001969";
            field_176100_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_176100_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_176100_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_176100_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_176100_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
