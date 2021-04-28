package net.minecraft.world.gen.structure;

import net.minecraft.init.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.item.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.nbt.*;

public class StructureMineshaftPieces
{
    private static final /* synthetic */ List field_175893_a;
    
    private static StructureComponent func_175892_a(final List lllllllllllllllllIlIIIIIlllIIIIl, final Random lllllllllllllllllIlIIIIIllIlllll, final int lllllllllllllllllIlIIIIIllIIllll, final int lllllllllllllllllIlIIIIIllIllIll, final int lllllllllllllllllIlIIIIIllIllIIl, final EnumFacing lllllllllllllllllIlIIIIIllIllIII, final int lllllllllllllllllIlIIIIIllIlIlll) {
        final int lllllllllllllllllIlIIIIIllIlIllI = lllllllllllllllllIlIIIIIllIlllll.nextInt(100);
        if (lllllllllllllllllIlIIIIIllIlIllI >= 80) {
            final StructureBoundingBox lllllllllllllllllIlIIIIIllIlIlIl = Cross.func_175813_a(lllllllllllllllllIlIIIIIlllIIIIl, lllllllllllllllllIlIIIIIllIlllll, lllllllllllllllllIlIIIIIllIIllll, lllllllllllllllllIlIIIIIllIllIll, lllllllllllllllllIlIIIIIllIllIIl, lllllllllllllllllIlIIIIIllIllIII);
            if (lllllllllllllllllIlIIIIIllIlIlIl != null) {
                return new Cross(lllllllllllllllllIlIIIIIllIlIlll, lllllllllllllllllIlIIIIIllIlllll, lllllllllllllllllIlIIIIIllIlIlIl, lllllllllllllllllIlIIIIIllIllIII);
            }
        }
        else if (lllllllllllllllllIlIIIIIllIlIllI >= 70) {
            final StructureBoundingBox lllllllllllllllllIlIIIIIllIlIlII = Stairs.func_175812_a(lllllllllllllllllIlIIIIIlllIIIIl, lllllllllllllllllIlIIIIIllIlllll, lllllllllllllllllIlIIIIIllIIllll, lllllllllllllllllIlIIIIIllIllIll, lllllllllllllllllIlIIIIIllIllIIl, lllllllllllllllllIlIIIIIllIllIII);
            if (lllllllllllllllllIlIIIIIllIlIlII != null) {
                return new Stairs(lllllllllllllllllIlIIIIIllIlIlll, lllllllllllllllllIlIIIIIllIlllll, lllllllllllllllllIlIIIIIllIlIlII, lllllllllllllllllIlIIIIIllIllIII);
            }
        }
        else {
            final StructureBoundingBox lllllllllllllllllIlIIIIIllIlIIll = Corridor.func_175814_a(lllllllllllllllllIlIIIIIlllIIIIl, lllllllllllllllllIlIIIIIllIlllll, lllllllllllllllllIlIIIIIllIIllll, lllllllllllllllllIlIIIIIllIllIll, lllllllllllllllllIlIIIIIllIllIIl, lllllllllllllllllIlIIIIIllIllIII);
            if (lllllllllllllllllIlIIIIIllIlIIll != null) {
                return new Corridor(lllllllllllllllllIlIIIIIllIlIlll, lllllllllllllllllIlIIIIIllIlllll, lllllllllllllllllIlIIIIIllIlIIll, lllllllllllllllllIlIIIIIllIllIII);
            }
        }
        return null;
    }
    
    public static void registerStructurePieces() {
        MapGenStructureIO.registerStructureComponent(Corridor.class, "MSCorridor");
        MapGenStructureIO.registerStructureComponent(Cross.class, "MSCrossing");
        MapGenStructureIO.registerStructureComponent(Room.class, "MSRoom");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "MSStairs");
    }
    
    static {
        __OBFID = "CL_00000444";
        field_175893_a = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.redstone, 0, 4, 9, 5), new WeightedRandomChestContent(Items.dye, EnumDyeColor.BLUE.getDyeColorDamage(), 4, 9, 5), new WeightedRandomChestContent(Items.diamond, 0, 1, 2, 3), new WeightedRandomChestContent(Items.coal, 0, 3, 8, 10), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 1), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.rail), 0, 4, 8, 1), new WeightedRandomChestContent(Items.melon_seeds, 0, 2, 4, 10), new WeightedRandomChestContent(Items.pumpkin_seeds, 0, 2, 4, 10), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1) });
    }
    
    private static StructureComponent func_175890_b(final StructureComponent lllllllllllllllllIlIIIIIlIlIllIl, final List lllllllllllllllllIlIIIIIlIllIlIl, final Random lllllllllllllllllIlIIIIIlIllIlII, final int lllllllllllllllllIlIIIIIlIllIIll, final int lllllllllllllllllIlIIIIIlIllIIlI, final int lllllllllllllllllIlIIIIIlIlIlIII, final EnumFacing lllllllllllllllllIlIIIIIlIllIIII, final int lllllllllllllllllIlIIIIIlIlIllll) {
        if (lllllllllllllllllIlIIIIIlIlIllll > 8) {
            return null;
        }
        if (Math.abs(lllllllllllllllllIlIIIIIlIllIIll - lllllllllllllllllIlIIIIIlIlIllIl.getBoundingBox().minX) <= 80 && Math.abs(lllllllllllllllllIlIIIIIlIlIlIII - lllllllllllllllllIlIIIIIlIlIllIl.getBoundingBox().minZ) <= 80) {
            final StructureComponent lllllllllllllllllIlIIIIIlIlIlllI = func_175892_a(lllllllllllllllllIlIIIIIlIllIlIl, lllllllllllllllllIlIIIIIlIllIlII, lllllllllllllllllIlIIIIIlIllIIll, lllllllllllllllllIlIIIIIlIllIIlI, lllllllllllllllllIlIIIIIlIlIlIII, lllllllllllllllllIlIIIIIlIllIIII, lllllllllllllllllIlIIIIIlIlIllll + 1);
            if (lllllllllllllllllIlIIIIIlIlIlllI != null) {
                lllllllllllllllllIlIIIIIlIllIlIl.add(lllllllllllllllllIlIIIIIlIlIlllI);
                lllllllllllllllllIlIIIIIlIlIlllI.buildComponent(lllllllllllllllllIlIIIIIlIlIllIl, lllllllllllllllllIlIIIIIlIllIlIl, lllllllllllllllllIlIIIIIlIllIlII);
            }
            return lllllllllllllllllIlIIIIIlIlIlllI;
        }
        return null;
    }
    
    public static class Corridor extends StructureComponent
    {
        private /* synthetic */ boolean hasSpiders;
        private /* synthetic */ boolean spawnerPlaced;
        private /* synthetic */ int sectionCount;
        private /* synthetic */ boolean hasRails;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIlIllIIIIIllIlIII) {
            this.hasRails = lllllllllllllllIlIllIIIIIllIlIII.getBoolean("hr");
            this.hasSpiders = lllllllllllllllIlIllIIIIIllIlIII.getBoolean("sc");
            this.spawnerPlaced = lllllllllllllllIlIllIIIIIllIlIII.getBoolean("hps");
            this.sectionCount = lllllllllllllllIlIllIIIIIllIlIII.getInteger("Num");
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIlIllIIIIIIlIlIlI, final List lllllllllllllllIlIllIIIIIIllIIll, final Random lllllllllllllllIlIllIIIIIIlIlIII) {
            final int lllllllllllllllIlIllIIIIIIllIIIl = this.getComponentType();
            final int lllllllllllllllIlIllIIIIIIllIIII = lllllllllllllllIlIllIIIIIIlIlIII.nextInt(4);
            if (this.coordBaseMode != null) {
                switch (StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        if (lllllllllllllllIlIllIIIIIIllIIII <= 1) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.minZ - 1, this.coordBaseMode, lllllllllllllllIlIllIIIIIIllIIIl);
                            break;
                        }
                        if (lllllllllllllllIlIllIIIIIIllIIII == 2) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.minZ, EnumFacing.WEST, lllllllllllllllIlIllIIIIIIllIIIl);
                            break;
                        }
                        func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.minZ, EnumFacing.EAST, lllllllllllllllIlIllIIIIIIllIIIl);
                        break;
                    }
                    case 2: {
                        if (lllllllllllllllIlIllIIIIIIllIIII <= 1) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.maxZ + 1, this.coordBaseMode, lllllllllllllllIlIllIIIIIIllIIIl);
                            break;
                        }
                        if (lllllllllllllllIlIllIIIIIIllIIII == 2) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.maxZ - 3, EnumFacing.WEST, lllllllllllllllIlIllIIIIIIllIIIl);
                            break;
                        }
                        func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.maxZ - 3, EnumFacing.EAST, lllllllllllllllIlIllIIIIIIllIIIl);
                        break;
                    }
                    case 3: {
                        if (lllllllllllllllIlIllIIIIIIllIIII <= 1) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.minZ, this.coordBaseMode, lllllllllllllllIlIllIIIIIIllIIIl);
                            break;
                        }
                        if (lllllllllllllllIlIllIIIIIIllIIII == 2) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllllIlIllIIIIIIllIIIl);
                            break;
                        }
                        func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllllIlIllIIIIIIllIIIl);
                        break;
                    }
                    case 4: {
                        if (lllllllllllllllIlIllIIIIIIllIIII <= 1) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.minZ, this.coordBaseMode, lllllllllllllllIlIllIIIIIIllIIIl);
                            break;
                        }
                        if (lllllllllllllllIlIllIIIIIIllIIII == 2) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllllIlIllIIIIIIllIIIl);
                            break;
                        }
                        func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + lllllllllllllllIlIllIIIIIIlIlIII.nextInt(3), this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllllIlIllIIIIIIllIIIl);
                        break;
                    }
                }
            }
            if (lllllllllllllllIlIllIIIIIIllIIIl < 8) {
                if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.SOUTH) {
                    for (int lllllllllllllllIlIllIIIIIIlIllll = this.boundingBox.minX + 3; lllllllllllllllIlIllIIIIIIlIllll + 3 <= this.boundingBox.maxX; lllllllllllllllIlIllIIIIIIlIllll += 5) {
                        final int lllllllllllllllIlIllIIIIIIlIllIl = lllllllllllllllIlIllIIIIIIlIlIII.nextInt(5);
                        if (lllllllllllllllIlIllIIIIIIlIllIl == 0) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, lllllllllllllllIlIllIIIIIIlIllll, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllllIlIllIIIIIIllIIIl + 1);
                        }
                        else if (lllllllllllllllIlIllIIIIIIlIllIl == 1) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, lllllllllllllllIlIllIIIIIIlIllll, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllllIlIllIIIIIIllIIIl + 1);
                        }
                    }
                }
                else {
                    for (int lllllllllllllllIlIllIIIIIIlIlllI = this.boundingBox.minZ + 3; lllllllllllllllIlIllIIIIIIlIlllI + 3 <= this.boundingBox.maxZ; lllllllllllllllIlIllIIIIIIlIlllI += 5) {
                        final int lllllllllllllllIlIllIIIIIIlIllII = lllllllllllllllIlIllIIIIIIlIlIII.nextInt(5);
                        if (lllllllllllllllIlIllIIIIIIlIllII == 0) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.minX - 1, this.boundingBox.minY, lllllllllllllllIlIllIIIIIIlIlllI, EnumFacing.WEST, lllllllllllllllIlIllIIIIIIllIIIl + 1);
                        }
                        else if (lllllllllllllllIlIllIIIIIIlIllII == 1) {
                            func_175890_b(lllllllllllllllIlIllIIIIIIlIlIlI, lllllllllllllllIlIllIIIIIIllIIll, lllllllllllllllIlIllIIIIIIlIlIII, this.boundingBox.maxX + 1, this.boundingBox.minY, lllllllllllllllIlIllIIIIIIlIlllI, EnumFacing.EAST, lllllllllllllllIlIllIIIIIIllIIIl + 1);
                        }
                    }
                }
            }
        }
        
        static {
            __OBFID = "CL_00000445";
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIlIlIllllllIllIIl, final Random lllllllllllllllIlIlIllllllIllIII, final StructureBoundingBox lllllllllllllllIlIlIllllllIlIlll) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll)) {
                return false;
            }
            final boolean lllllllllllllllIlIlIlllllllIlIll = false;
            final boolean lllllllllllllllIlIlIlllllllIlIlI = true;
            final boolean lllllllllllllllIlIlIlllllllIlIIl = false;
            final boolean lllllllllllllllIlIlIlllllllIlIII = true;
            final int lllllllllllllllIlIlIlllllllIIlll = this.sectionCount * 5 - 1;
            this.func_175804_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, 0, 0, 0, 2, 1, lllllllllllllllIlIlIlllllllIIlll, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175805_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.8f, 0, 2, 0, 2, 2, lllllllllllllllIlIlIlllllllIIlll, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            if (this.hasSpiders) {
                this.func_175805_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.6f, 0, 0, 0, 2, 1, lllllllllllllllIlIlIlllllllIIlll, Blocks.web.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            for (int lllllllllllllllIlIlIlllllllIIllI = 0; lllllllllllllllIlIlIlllllllIIllI < this.sectionCount; ++lllllllllllllllIlIlIlllllllIIllI) {
                final int lllllllllllllllIlIlIlllllllIIlIl = 2 + lllllllllllllllIlIlIlllllllIIllI * 5;
                this.func_175804_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, 0, 0, lllllllllllllllIlIlIlllllllIIlIl, 0, 1, lllllllllllllllIlIlIlllllllIIlIl, Blocks.oak_fence.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.func_175804_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, 2, 0, lllllllllllllllIlIlIlllllllIIlIl, 2, 1, lllllllllllllllIlIlIlllllllIIlIl, Blocks.oak_fence.getDefaultState(), Blocks.air.getDefaultState(), false);
                if (lllllllllllllllIlIlIllllllIllIII.nextInt(4) == 0) {
                    this.func_175804_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, 0, 2, lllllllllllllllIlIlIlllllllIIlIl, 0, 2, lllllllllllllllIlIlIlllllllIIlIl, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
                    this.func_175804_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, 2, 2, lllllllllllllllIlIlIlllllllIIlIl, 2, 2, lllllllllllllllIlIlIlllllllIIlIl, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
                }
                else {
                    this.func_175804_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, 0, 2, lllllllllllllllIlIlIlllllllIIlIl, 2, 2, lllllllllllllllIlIlIlllllllIIlIl, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
                }
                this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.1f, 0, 2, lllllllllllllllIlIlIlllllllIIlIl - 1, Blocks.web.getDefaultState());
                this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.1f, 2, 2, lllllllllllllllIlIlIlllllllIIlIl - 1, Blocks.web.getDefaultState());
                this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.1f, 0, 2, lllllllllllllllIlIlIlllllllIIlIl + 1, Blocks.web.getDefaultState());
                this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.1f, 2, 2, lllllllllllllllIlIlIlllllllIIlIl + 1, Blocks.web.getDefaultState());
                this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.05f, 0, 2, lllllllllllllllIlIlIlllllllIIlIl - 2, Blocks.web.getDefaultState());
                this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.05f, 2, 2, lllllllllllllllIlIlIlllllllIIlIl - 2, Blocks.web.getDefaultState());
                this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.05f, 0, 2, lllllllllllllllIlIlIlllllllIIlIl + 2, Blocks.web.getDefaultState());
                this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.05f, 2, 2, lllllllllllllllIlIlIlllllllIIlIl + 2, Blocks.web.getDefaultState());
                this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.05f, 1, 2, lllllllllllllllIlIlIlllllllIIlIl - 1, Blocks.torch.getStateFromMeta(EnumFacing.UP.getIndex()));
                this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.05f, 1, 2, lllllllllllllllIlIlIlllllllIIlIl + 1, Blocks.torch.getStateFromMeta(EnumFacing.UP.getIndex()));
                if (lllllllllllllllIlIlIllllllIllIII.nextInt(100) == 0) {
                    this.func_180778_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 2, 0, lllllllllllllllIlIlIlllllllIIlIl - 1, WeightedRandomChestContent.func_177629_a(StructureMineshaftPieces.field_175893_a, Items.enchanted_book.getRandomEnchantedBook(lllllllllllllllIlIlIllllllIllIII)), 3 + lllllllllllllllIlIlIllllllIllIII.nextInt(4));
                }
                if (lllllllllllllllIlIlIllllllIllIII.nextInt(100) == 0) {
                    this.func_180778_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0, 0, lllllllllllllllIlIlIlllllllIIlIl + 1, WeightedRandomChestContent.func_177629_a(StructureMineshaftPieces.field_175893_a, Items.enchanted_book.getRandomEnchantedBook(lllllllllllllllIlIlIllllllIllIII)), 3 + lllllllllllllllIlIlIllllllIllIII.nextInt(4));
                }
                if (this.hasSpiders && !this.spawnerPlaced) {
                    final int lllllllllllllllIlIlIlllllllIIIll = this.getYWithOffset(0);
                    int lllllllllllllllIlIlIlllllllIIIlI = lllllllllllllllIlIlIlllllllIIlIl - 1 + lllllllllllllllIlIlIllllllIllIII.nextInt(3);
                    final int lllllllllllllllIlIlIlllllllIIIIl = this.getXWithOffset(1, lllllllllllllllIlIlIlllllllIIIlI);
                    lllllllllllllllIlIlIlllllllIIIlI = this.getZWithOffset(1, lllllllllllllllIlIlIlllllllIIIlI);
                    final BlockPos lllllllllllllllIlIlIlllllllIIIII = new BlockPos(lllllllllllllllIlIlIlllllllIIIIl, lllllllllllllllIlIlIlllllllIIIll, lllllllllllllllIlIlIlllllllIIIlI);
                    if (lllllllllllllllIlIlIllllllIlIlll.func_175898_b(lllllllllllllllIlIlIlllllllIIIII)) {
                        this.spawnerPlaced = true;
                        lllllllllllllllIlIlIllllllIllIIl.setBlockState(lllllllllllllllIlIlIlllllllIIIII, Blocks.mob_spawner.getDefaultState(), 2);
                        final TileEntity lllllllllllllllIlIlIllllllIlllll = lllllllllllllllIlIlIllllllIllIIl.getTileEntity(lllllllllllllllIlIlIlllllllIIIII);
                        if (lllllllllllllllIlIlIllllllIlllll instanceof TileEntityMobSpawner) {
                            ((TileEntityMobSpawner)lllllllllllllllIlIlIllllllIlllll).getSpawnerBaseLogic().setEntityName("CaveSpider");
                        }
                    }
                }
            }
            for (int lllllllllllllllIlIlIlllllllIIllI = 0; lllllllllllllllIlIlIlllllllIIllI <= 2; ++lllllllllllllllIlIlIlllllllIIllI) {
                for (int lllllllllllllllIlIlIlllllllIIlII = 0; lllllllllllllllIlIlIlllllllIIlII <= lllllllllllllllIlIlIlllllllIIlll; ++lllllllllllllllIlIlIlllllllIIlII) {
                    final byte lllllllllllllllIlIlIllllllIllllI = -1;
                    final IBlockState lllllllllllllllIlIlIllllllIlllIl = this.func_175807_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIlllllllIIllI, lllllllllllllllIlIlIllllllIllllI, lllllllllllllllIlIlIlllllllIIlII, lllllllllllllllIlIlIllllllIlIlll);
                    if (lllllllllllllllIlIlIllllllIlllIl.getBlock().getMaterial() == Material.air) {
                        final byte lllllllllllllllIlIlIllllllIlllII = -1;
                        this.func_175811_a(lllllllllllllllIlIlIllllllIllIIl, Blocks.planks.getDefaultState(), lllllllllllllllIlIlIlllllllIIllI, lllllllllllllllIlIlIllllllIlllII, lllllllllllllllIlIlIlllllllIIlII, lllllllllllllllIlIlIllllllIlIlll);
                    }
                }
            }
            if (this.hasRails) {
                for (int lllllllllllllllIlIlIlllllllIIllI = 0; lllllllllllllllIlIlIlllllllIIllI <= lllllllllllllllIlIlIlllllllIIlll; ++lllllllllllllllIlIlIlllllllIIllI) {
                    final IBlockState lllllllllllllllIlIlIllllllIllIll = this.func_175807_a(lllllllllllllllIlIlIllllllIllIIl, 1, -1, lllllllllllllllIlIlIlllllllIIllI, lllllllllllllllIlIlIllllllIlIlll);
                    if (lllllllllllllllIlIlIllllllIllIll.getBlock().getMaterial() != Material.air && lllllllllllllllIlIlIllllllIllIll.getBlock().isFullBlock()) {
                        this.func_175809_a(lllllllllllllllIlIlIllllllIllIIl, lllllllllllllllIlIlIllllllIlIlll, lllllllllllllllIlIlIllllllIllIII, 0.7f, 1, 0, lllllllllllllllIlIlIlllllllIIllI, Blocks.rail.getStateFromMeta(this.getMetadataWithOffset(Blocks.rail, 0)));
                    }
                }
            }
            return true;
        }
        
        public Corridor(final int lllllllllllllllIlIllIIIIIllIIIIl, final Random lllllllllllllllIlIllIIIIIllIIIII, final StructureBoundingBox lllllllllllllllIlIllIIIIIlIllIlI, final EnumFacing lllllllllllllllIlIllIIIIIlIllIIl) {
            super(lllllllllllllllIlIllIIIIIllIIIIl);
            this.coordBaseMode = lllllllllllllllIlIllIIIIIlIllIIl;
            this.boundingBox = lllllllllllllllIlIllIIIIIlIllIlI;
            this.hasRails = (lllllllllllllllIlIllIIIIIllIIIII.nextInt(3) == 0);
            this.hasSpiders = (!this.hasRails && lllllllllllllllIlIllIIIIIllIIIII.nextInt(23) == 0);
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.SOUTH) {
                this.sectionCount = lllllllllllllllIlIllIIIIIlIllIlI.getXSize() / 5;
            }
            else {
                this.sectionCount = lllllllllllllllIlIllIIIIIlIllIlI.getZSize() / 5;
            }
        }
        
        public static StructureBoundingBox func_175814_a(final List lllllllllllllllIlIllIIIIIlIIllll, final Random lllllllllllllllIlIllIIIIIlIIIlIl, final int lllllllllllllllIlIllIIIIIlIIllIl, final int lllllllllllllllIlIllIIIIIlIIIIll, final int lllllllllllllllIlIllIIIIIlIIIIlI, final EnumFacing lllllllllllllllIlIllIIIIIlIIlIlI) {
            final StructureBoundingBox lllllllllllllllIlIllIIIIIlIIlIIl = new StructureBoundingBox(lllllllllllllllIlIllIIIIIlIIllIl, lllllllllllllllIlIllIIIIIlIIIIll, lllllllllllllllIlIllIIIIIlIIIIlI, lllllllllllllllIlIllIIIIIlIIllIl, lllllllllllllllIlIllIIIIIlIIIIll + 2, lllllllllllllllIlIllIIIIIlIIIIlI);
            int lllllllllllllllIlIllIIIIIlIIlIII;
            for (lllllllllllllllIlIllIIIIIlIIlIII = lllllllllllllllIlIllIIIIIlIIIlIl.nextInt(3) + 2; lllllllllllllllIlIllIIIIIlIIlIII > 0; --lllllllllllllllIlIllIIIIIlIIlIII) {
                final int lllllllllllllllIlIllIIIIIlIIIlll = lllllllllllllllIlIllIIIIIlIIlIII * 5;
                switch (StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[lllllllllllllllIlIllIIIIIlIIlIlI.ordinal()]) {
                    case 1: {
                        lllllllllllllllIlIllIIIIIlIIlIIl.maxX = lllllllllllllllIlIllIIIIIlIIllIl + 2;
                        lllllllllllllllIlIllIIIIIlIIlIIl.minZ = lllllllllllllllIlIllIIIIIlIIIIlI - (lllllllllllllllIlIllIIIIIlIIIlll - 1);
                        break;
                    }
                    case 2: {
                        lllllllllllllllIlIllIIIIIlIIlIIl.maxX = lllllllllllllllIlIllIIIIIlIIllIl + 2;
                        lllllllllllllllIlIllIIIIIlIIlIIl.maxZ = lllllllllllllllIlIllIIIIIlIIIIlI + (lllllllllllllllIlIllIIIIIlIIIlll - 1);
                        break;
                    }
                    case 3: {
                        lllllllllllllllIlIllIIIIIlIIlIIl.minX = lllllllllllllllIlIllIIIIIlIIllIl - (lllllllllllllllIlIllIIIIIlIIIlll - 1);
                        lllllllllllllllIlIllIIIIIlIIlIIl.maxZ = lllllllllllllllIlIllIIIIIlIIIIlI + 2;
                        break;
                    }
                    case 4: {
                        lllllllllllllllIlIllIIIIIlIIlIIl.maxX = lllllllllllllllIlIllIIIIIlIIllIl + (lllllllllllllllIlIllIIIIIlIIIlll - 1);
                        lllllllllllllllIlIllIIIIIlIIlIIl.maxZ = lllllllllllllllIlIllIIIIIlIIIIlI + 2;
                        break;
                    }
                }
                if (StructureComponent.findIntersecting(lllllllllllllllIlIllIIIIIlIIllll, lllllllllllllllIlIllIIIIIlIIlIIl) == null) {
                    break;
                }
            }
            return (lllllllllllllllIlIllIIIIIlIIlIII > 0) ? lllllllllllllllIlIllIIIIIlIIlIIl : null;
        }
        
        @Override
        protected boolean func_180778_a(final World lllllllllllllllIlIllIIIIIIIlIllI, final StructureBoundingBox lllllllllllllllIlIllIIIIIIIlIlIl, final Random lllllllllllllllIlIllIIIIIIIIlIII, final int lllllllllllllllIlIllIIIIIIIlIIll, final int lllllllllllllllIlIllIIIIIIIIIllI, final int lllllllllllllllIlIllIIIIIIIIIlIl, final List lllllllllllllllIlIllIIIIIIIIIlII, final int lllllllllllllllIlIllIIIIIIIIllll) {
            final BlockPos lllllllllllllllIlIllIIIIIIIIlllI = new BlockPos(this.getXWithOffset(lllllllllllllllIlIllIIIIIIIlIIll, lllllllllllllllIlIllIIIIIIIIIlIl), this.getYWithOffset(lllllllllllllllIlIllIIIIIIIIIllI), this.getZWithOffset(lllllllllllllllIlIllIIIIIIIlIIll, lllllllllllllllIlIllIIIIIIIIIlIl));
            if (lllllllllllllllIlIllIIIIIIIlIlIl.func_175898_b(lllllllllllllllIlIllIIIIIIIIlllI) && lllllllllllllllIlIllIIIIIIIlIllI.getBlockState(lllllllllllllllIlIllIIIIIIIIlllI).getBlock().getMaterial() == Material.air) {
                final int lllllllllllllllIlIllIIIIIIIIllIl = lllllllllllllllIlIllIIIIIIIIlIII.nextBoolean() ? 1 : 0;
                lllllllllllllllIlIllIIIIIIIlIllI.setBlockState(lllllllllllllllIlIllIIIIIIIIlllI, Blocks.rail.getStateFromMeta(this.getMetadataWithOffset(Blocks.rail, lllllllllllllllIlIllIIIIIIIIllIl)), 2);
                final EntityMinecartChest lllllllllllllllIlIllIIIIIIIIllII = new EntityMinecartChest(lllllllllllllllIlIllIIIIIIIlIllI, lllllllllllllllIlIllIIIIIIIIlllI.getX() + 0.5f, lllllllllllllllIlIllIIIIIIIIlllI.getY() + 0.5f, lllllllllllllllIlIllIIIIIIIIlllI.getZ() + 0.5f);
                WeightedRandomChestContent.generateChestContents(lllllllllllllllIlIllIIIIIIIIlIII, lllllllllllllllIlIllIIIIIIIIIlII, lllllllllllllllIlIllIIIIIIIIllII, lllllllllllllllIlIllIIIIIIIIllll);
                lllllllllllllllIlIllIIIIIIIlIllI.spawnEntityInWorld(lllllllllllllllIlIllIIIIIIIIllII);
                return true;
            }
            return false;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIlIllIIIIIlllIIII) {
            lllllllllllllllIlIllIIIIIlllIIII.setBoolean("hr", this.hasRails);
            lllllllllllllllIlIllIIIIIlllIIII.setBoolean("sc", this.hasSpiders);
            lllllllllllllllIlIllIIIIIlllIIII.setBoolean("hps", this.spawnerPlaced);
            lllllllllllllllIlIllIIIIIlllIIII.setInteger("Num", this.sectionCount);
        }
        
        public Corridor() {
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_175894_a;
        
        static {
            __OBFID = "CL_00001998";
            field_175894_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_175894_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_175894_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_175894_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_175894_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
    
    public static class Cross extends StructureComponent
    {
        private /* synthetic */ EnumFacing corridorDirection;
        private /* synthetic */ boolean isMultipleFloors;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIIIlIllllIIIIllll) {
            this.isMultipleFloors = lllllllllllllllIIIlIllllIIIIllll.getBoolean("tf");
            this.corridorDirection = EnumFacing.getHorizontal(lllllllllllllllIIIlIllllIIIIllll.getInteger("D"));
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIIIlIlllIllIIllll, final Random lllllllllllllllIIIlIlllIllIlIlII, final StructureBoundingBox lllllllllllllllIIIlIlllIllIlIIll) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll)) {
                return false;
            }
            if (this.isMultipleFloors) {
                this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ - 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.minX + 1, this.boundingBox.maxY - 2, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.minX, this.boundingBox.maxY - 2, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.minX + 1, this.boundingBox.minY + 3, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.minY + 3, this.boundingBox.maxZ - 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            else {
                this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.minX + 1, this.boundingBox.maxY, this.boundingBox.minZ + 1, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.minX + 1, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.minZ + 1, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIll, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
            for (int lllllllllllllllIIIlIlllIllIlIIlI = this.boundingBox.minX; lllllllllllllllIIIlIlllIllIlIIlI <= this.boundingBox.maxX; ++lllllllllllllllIIIlIlllIllIlIIlI) {
                for (int lllllllllllllllIIIlIlllIllIlIIIl = this.boundingBox.minZ; lllllllllllllllIIIlIlllIllIlIIIl <= this.boundingBox.maxZ; ++lllllllllllllllIIIlIlllIllIlIIIl) {
                    if (this.func_175807_a(lllllllllllllllIIIlIlllIllIIllll, lllllllllllllllIIIlIlllIllIlIIlI, this.boundingBox.minY - 1, lllllllllllllllIIIlIlllIllIlIIIl, lllllllllllllllIIIlIlllIllIlIIll).getBlock().getMaterial() == Material.air) {
                        this.func_175811_a(lllllllllllllllIIIlIlllIllIIllll, Blocks.planks.getDefaultState(), lllllllllllllllIIIlIlllIllIlIIlI, this.boundingBox.minY - 1, lllllllllllllllIIIlIlllIllIlIIIl, lllllllllllllllIIIlIlllIllIlIIll);
                    }
                }
            }
            return true;
        }
        
        static {
            __OBFID = "CL_00000446";
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIIIlIllllIIIlIIll) {
            lllllllllllllllIIIlIllllIIIlIIll.setBoolean("tf", this.isMultipleFloors);
            lllllllllllllllIIIlIllllIIIlIIll.setInteger("D", this.corridorDirection.getHorizontalIndex());
        }
        
        public Cross() {
        }
        
        public static StructureBoundingBox func_175813_a(final List lllllllllllllllIIIlIlllIllllIIIl, final Random lllllllllllllllIIIlIlllIllllIIII, final int lllllllllllllllIIIlIlllIllllIllI, final int lllllllllllllllIIIlIlllIllllIlIl, final int lllllllllllllllIIIlIlllIllllIlII, final EnumFacing lllllllllllllllIIIlIlllIlllIllII) {
            final StructureBoundingBox lllllllllllllllIIIlIlllIllllIIlI = new StructureBoundingBox(lllllllllllllllIIIlIlllIllllIllI, lllllllllllllllIIIlIlllIllllIlIl, lllllllllllllllIIIlIlllIllllIlII, lllllllllllllllIIIlIlllIllllIllI, lllllllllllllllIIIlIlllIllllIlIl + 2, lllllllllllllllIIIlIlllIllllIlII);
            if (lllllllllllllllIIIlIlllIllllIIII.nextInt(4) == 0) {
                final StructureBoundingBox structureBoundingBox = lllllllllllllllIIIlIlllIllllIIlI;
                structureBoundingBox.maxY += 4;
            }
            switch (StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[lllllllllllllllIIIlIlllIlllIllII.ordinal()]) {
                case 1: {
                    lllllllllllllllIIIlIlllIllllIIlI.minX = lllllllllllllllIIIlIlllIllllIllI - 1;
                    lllllllllllllllIIIlIlllIllllIIlI.maxX = lllllllllllllllIIIlIlllIllllIllI + 3;
                    lllllllllllllllIIIlIlllIllllIIlI.minZ = lllllllllllllllIIIlIlllIllllIlII - 4;
                    break;
                }
                case 2: {
                    lllllllllllllllIIIlIlllIllllIIlI.minX = lllllllllllllllIIIlIlllIllllIllI - 1;
                    lllllllllllllllIIIlIlllIllllIIlI.maxX = lllllllllllllllIIIlIlllIllllIllI + 3;
                    lllllllllllllllIIIlIlllIllllIIlI.maxZ = lllllllllllllllIIIlIlllIllllIlII + 4;
                    break;
                }
                case 3: {
                    lllllllllllllllIIIlIlllIllllIIlI.minX = lllllllllllllllIIIlIlllIllllIllI - 4;
                    lllllllllllllllIIIlIlllIllllIIlI.minZ = lllllllllllllllIIIlIlllIllllIlII - 1;
                    lllllllllllllllIIIlIlllIllllIIlI.maxZ = lllllllllllllllIIIlIlllIllllIlII + 3;
                    break;
                }
                case 4: {
                    lllllllllllllllIIIlIlllIllllIIlI.maxX = lllllllllllllllIIIlIlllIllllIllI + 4;
                    lllllllllllllllIIIlIlllIllllIIlI.minZ = lllllllllllllllIIIlIlllIllllIlII - 1;
                    lllllllllllllllIIIlIlllIllllIIlI.maxZ = lllllllllllllllIIIlIlllIllllIlII + 3;
                    break;
                }
            }
            return (StructureComponent.findIntersecting(lllllllllllllllIIIlIlllIllllIIIl, lllllllllllllllIIIlIlllIllllIIlI) != null) ? null : lllllllllllllllIIIlIlllIllllIIlI;
        }
        
        public Cross(final int lllllllllllllllIIIlIllllIIIIIlll, final Random lllllllllllllllIIIlIllllIIIIIllI, final StructureBoundingBox lllllllllllllllIIIlIllllIIIIIIIl, final EnumFacing lllllllllllllllIIIlIllllIIIIIlII) {
            super(lllllllllllllllIIIlIllllIIIIIlll);
            this.corridorDirection = lllllllllllllllIIIlIllllIIIIIlII;
            this.boundingBox = lllllllllllllllIIIlIllllIIIIIIIl;
            this.isMultipleFloors = (lllllllllllllllIIIlIllllIIIIIIIl.getYSize() > 3);
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIIIlIlllIlllIIlII, final List lllllllllllllllIIIlIlllIllIllllI, final Random lllllllllllllllIIIlIlllIlllIIIlI) {
            final int lllllllllllllllIIIlIlllIlllIIIIl = this.getComponentType();
            switch (StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[this.corridorDirection.ordinal()]) {
                case 1: {
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllllIIIlIlllIlllIIIIl);
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, lllllllllllllllIIIlIlllIlllIIIIl);
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, lllllllllllllllIIIlIlllIlllIIIIl);
                    break;
                }
                case 2: {
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllllIIIlIlllIlllIIIIl);
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, lllllllllllllllIIIlIlllIlllIIIIl);
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, lllllllllllllllIIIlIlllIlllIIIIl);
                    break;
                }
                case 3: {
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllllIIIlIlllIlllIIIIl);
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllllIIIlIlllIlllIIIIl);
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, lllllllllllllllIIIlIlllIlllIIIIl);
                    break;
                }
                case 4: {
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllllIIIlIlllIlllIIIIl);
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllllIIIlIlllIlllIIIIl);
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, lllllllllllllllIIIlIlllIlllIIIIl);
                    break;
                }
            }
            if (this.isMultipleFloors) {
                if (lllllllllllllllIIIlIlllIlllIIIlI.nextBoolean()) {
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllllIIIlIlllIlllIIIIl);
                }
                if (lllllllllllllllIIIlIlllIlllIIIlI.nextBoolean()) {
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX - 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, EnumFacing.WEST, lllllllllllllllIIIlIlllIlllIIIIl);
                }
                if (lllllllllllllllIIIlIlllIlllIIIlI.nextBoolean()) {
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, EnumFacing.EAST, lllllllllllllllIIIlIlllIlllIIIIl);
                }
                if (lllllllllllllllIIIlIlllIlllIIIlI.nextBoolean()) {
                    func_175890_b(lllllllllllllllIIIlIlllIlllIIlII, lllllllllllllllIIIlIlllIllIllllI, lllllllllllllllIIIlIlllIlllIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllllIIIlIlllIlllIIIIl);
                }
            }
        }
    }
    
    public static class Room extends StructureComponent
    {
        private /* synthetic */ List roomsLinkedToTheRoom;
        
        public Room() {
            this.roomsLinkedToTheRoom = Lists.newLinkedList();
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllllIIlllIIIIlIllIl, final Random lllllllllllllllllIIlllIIIIllIIlI, final StructureBoundingBox lllllllllllllllllIIlllIIIIlIllII) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllllIIlllIIIIlIllIl, lllllllllllllllllIIlllIIIIlIllII)) {
                return false;
            }
            this.func_175804_a(lllllllllllllllllIIlllIIIIlIllIl, lllllllllllllllllIIlllIIIIlIllII, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.minY, this.boundingBox.maxZ, Blocks.dirt.getDefaultState(), Blocks.air.getDefaultState(), true);
            this.func_175804_a(lllllllllllllllllIIlllIIIIlIllIl, lllllllllllllllllIIlllIIIIlIllII, this.boundingBox.minX, this.boundingBox.minY + 1, this.boundingBox.minZ, this.boundingBox.maxX, Math.min(this.boundingBox.minY + 3, this.boundingBox.maxY), this.boundingBox.maxZ, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            for (final StructureBoundingBox lllllllllllllllllIIlllIIIIlIllll : this.roomsLinkedToTheRoom) {
                this.func_175804_a(lllllllllllllllllIIlllIIIIlIllIl, lllllllllllllllllIIlllIIIIlIllII, lllllllllllllllllIIlllIIIIlIllll.minX, lllllllllllllllllIIlllIIIIlIllll.maxY - 2, lllllllllllllllllIIlllIIIIlIllll.minZ, lllllllllllllllllIIlllIIIIlIllll.maxX, lllllllllllllllllIIlllIIIIlIllll.maxY, lllllllllllllllllIIlllIIIIlIllll.maxZ, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            this.func_180777_a(lllllllllllllllllIIlllIIIIlIllIl, lllllllllllllllllIIlllIIIIlIllII, this.boundingBox.minX, this.boundingBox.minY + 4, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air.getDefaultState(), false);
            return true;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllllIIlllIIIIIllllI) {
            final NBTTagList lllllllllllllllllIIlllIIIIlIIIlI = new NBTTagList();
            for (final StructureBoundingBox lllllllllllllllllIIlllIIIIlIIIII : this.roomsLinkedToTheRoom) {
                lllllllllllllllllIIlllIIIIlIIIlI.appendTag(lllllllllllllllllIIlllIIIIlIIIII.func_151535_h());
            }
            lllllllllllllllllIIlllIIIIIllllI.setTag("Entrances", lllllllllllllllllIIlllIIIIlIIIlI);
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllllIIlllIIIlIIIIIl, final List lllllllllllllllllIIlllIIIlIIIIII, final Random lllllllllllllllllIIlllIIIlIIlllI) {
            final int lllllllllllllllllIIlllIIIlIIllIl = this.getComponentType();
            int lllllllllllllllllIIlllIIIlIIllII = this.boundingBox.getYSize() - 3 - 1;
            if (lllllllllllllllllIIlllIIIlIIllII <= 0) {
                lllllllllllllllllIIlllIIIlIIllII = 1;
            }
            for (int lllllllllllllllllIIlllIIIlIIlIll = 0; lllllllllllllllllIIlllIIIlIIlIll < this.boundingBox.getXSize(); lllllllllllllllllIIlllIIIlIIlIll += 4) {
                lllllllllllllllllIIlllIIIlIIlIll += lllllllllllllllllIIlllIIIlIIlllI.nextInt(this.boundingBox.getXSize());
                if (lllllllllllllllllIIlllIIIlIIlIll + 3 > this.boundingBox.getXSize()) {
                    break;
                }
                final StructureComponent lllllllllllllllllIIlllIIIlIIlIlI = func_175890_b(lllllllllllllllllIIlllIIIlIIIIIl, lllllllllllllllllIIlllIIIlIIIIII, lllllllllllllllllIIlllIIIlIIlllI, this.boundingBox.minX + lllllllllllllllllIIlllIIIlIIlIll, this.boundingBox.minY + lllllllllllllllllIIlllIIIlIIlllI.nextInt(lllllllllllllllllIIlllIIIlIIllII) + 1, this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllllllIIlllIIIlIIllIl);
                if (lllllllllllllllllIIlllIIIlIIlIlI != null) {
                    final StructureBoundingBox lllllllllllllllllIIlllIIIlIIIllI = lllllllllllllllllIIlllIIIlIIlIlI.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(lllllllllllllllllIIlllIIIlIIIllI.minX, lllllllllllllllllIIlllIIIlIIIllI.minY, this.boundingBox.minZ, lllllllllllllllllIIlllIIIlIIIllI.maxX, lllllllllllllllllIIlllIIIlIIIllI.maxY, this.boundingBox.minZ + 1));
                }
            }
            for (int lllllllllllllllllIIlllIIIlIIlIll = 0; lllllllllllllllllIIlllIIIlIIlIll < this.boundingBox.getXSize(); lllllllllllllllllIIlllIIIlIIlIll += 4) {
                lllllllllllllllllIIlllIIIlIIlIll += lllllllllllllllllIIlllIIIlIIlllI.nextInt(this.boundingBox.getXSize());
                if (lllllllllllllllllIIlllIIIlIIlIll + 3 > this.boundingBox.getXSize()) {
                    break;
                }
                final StructureComponent lllllllllllllllllIIlllIIIlIIlIIl = func_175890_b(lllllllllllllllllIIlllIIIlIIIIIl, lllllllllllllllllIIlllIIIlIIIIII, lllllllllllllllllIIlllIIIlIIlllI, this.boundingBox.minX + lllllllllllllllllIIlllIIIlIIlIll, this.boundingBox.minY + lllllllllllllllllIIlllIIIlIIlllI.nextInt(lllllllllllllllllIIlllIIIlIIllII) + 1, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllllllIIlllIIIlIIllIl);
                if (lllllllllllllllllIIlllIIIlIIlIIl != null) {
                    final StructureBoundingBox lllllllllllllllllIIlllIIIlIIIlIl = lllllllllllllllllIIlllIIIlIIlIIl.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(lllllllllllllllllIIlllIIIlIIIlIl.minX, lllllllllllllllllIIlllIIIlIIIlIl.minY, this.boundingBox.maxZ - 1, lllllllllllllllllIIlllIIIlIIIlIl.maxX, lllllllllllllllllIIlllIIIlIIIlIl.maxY, this.boundingBox.maxZ));
                }
            }
            for (int lllllllllllllllllIIlllIIIlIIlIll = 0; lllllllllllllllllIIlllIIIlIIlIll < this.boundingBox.getZSize(); lllllllllllllllllIIlllIIIlIIlIll += 4) {
                lllllllllllllllllIIlllIIIlIIlIll += lllllllllllllllllIIlllIIIlIIlllI.nextInt(this.boundingBox.getZSize());
                if (lllllllllllllllllIIlllIIIlIIlIll + 3 > this.boundingBox.getZSize()) {
                    break;
                }
                final StructureComponent lllllllllllllllllIIlllIIIlIIlIII = func_175890_b(lllllllllllllllllIIlllIIIlIIIIIl, lllllllllllllllllIIlllIIIlIIIIII, lllllllllllllllllIIlllIIIlIIlllI, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllllllIIlllIIIlIIlllI.nextInt(lllllllllllllllllIIlllIIIlIIllII) + 1, this.boundingBox.minZ + lllllllllllllllllIIlllIIIlIIlIll, EnumFacing.WEST, lllllllllllllllllIIlllIIIlIIllIl);
                if (lllllllllllllllllIIlllIIIlIIlIII != null) {
                    final StructureBoundingBox lllllllllllllllllIIlllIIIlIIIlII = lllllllllllllllllIIlllIIIlIIlIII.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.minX, lllllllllllllllllIIlllIIIlIIIlII.minY, lllllllllllllllllIIlllIIIlIIIlII.minZ, this.boundingBox.minX + 1, lllllllllllllllllIIlllIIIlIIIlII.maxY, lllllllllllllllllIIlllIIIlIIIlII.maxZ));
                }
            }
            for (int lllllllllllllllllIIlllIIIlIIlIll = 0; lllllllllllllllllIIlllIIIlIIlIll < this.boundingBox.getZSize(); lllllllllllllllllIIlllIIIlIIlIll += 4) {
                lllllllllllllllllIIlllIIIlIIlIll += lllllllllllllllllIIlllIIIlIIlllI.nextInt(this.boundingBox.getZSize());
                if (lllllllllllllllllIIlllIIIlIIlIll + 3 > this.boundingBox.getZSize()) {
                    break;
                }
                final StructureComponent lllllllllllllllllIIlllIIIlIIIlll = func_175890_b(lllllllllllllllllIIlllIIIlIIIIIl, lllllllllllllllllIIlllIIIlIIIIII, lllllllllllllllllIIlllIIIlIIlllI, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllllllIIlllIIIlIIlllI.nextInt(lllllllllllllllllIIlllIIIlIIllII) + 1, this.boundingBox.minZ + lllllllllllllllllIIlllIIIlIIlIll, EnumFacing.EAST, lllllllllllllllllIIlllIIIlIIllIl);
                if (lllllllllllllllllIIlllIIIlIIIlll != null) {
                    final StructureBoundingBox lllllllllllllllllIIlllIIIlIIIIll = lllllllllllllllllIIlllIIIlIIIlll.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.maxX - 1, lllllllllllllllllIIlllIIIlIIIIll.minY, lllllllllllllllllIIlllIIIlIIIIll.minZ, this.boundingBox.maxX, lllllllllllllllllIIlllIIIlIIIIll.maxY, lllllllllllllllllIIlllIIIlIIIIll.maxZ));
                }
            }
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllllIIlllIIIIIlIlIl) {
            final NBTTagList lllllllllllllllllIIlllIIIIIlIlII = lllllllllllllllllIIlllIIIIIlIlIl.getTagList("Entrances", 11);
            for (int lllllllllllllllllIIlllIIIIIlIIll = 0; lllllllllllllllllIIlllIIIIIlIIll < lllllllllllllllllIIlllIIIIIlIlII.tagCount(); ++lllllllllllllllllIIlllIIIIIlIIll) {
                this.roomsLinkedToTheRoom.add(new StructureBoundingBox(lllllllllllllllllIIlllIIIIIlIlII.getIntArray(lllllllllllllllllIIlllIIIIIlIIll)));
            }
        }
        
        public Room(final int lllllllllllllllllIIlllIIIllIIIll, final Random lllllllllllllllllIIlllIIIlIlllIl, final int lllllllllllllllllIIlllIIIllIIIIl, final int lllllllllllllllllIIlllIIIlIllIll) {
            super(lllllllllllllllllIIlllIIIllIIIll);
            this.roomsLinkedToTheRoom = Lists.newLinkedList();
            this.boundingBox = new StructureBoundingBox(lllllllllllllllllIIlllIIIllIIIIl, 50, lllllllllllllllllIIlllIIIlIllIll, lllllllllllllllllIIlllIIIllIIIIl + 7 + lllllllllllllllllIIlllIIIlIlllIl.nextInt(6), 54 + lllllllllllllllllIIlllIIIlIlllIl.nextInt(6), lllllllllllllllllIIlllIIIlIllIll + 7 + lllllllllllllllllIIlllIIIlIlllIl.nextInt(6));
        }
        
        static {
            __OBFID = "CL_00000447";
        }
    }
    
    public static class Stairs extends StructureComponent
    {
        public static StructureBoundingBox func_175812_a(final List lllllllllllllllIIIIIlllIIlIIllIl, final Random lllllllllllllllIIIIIlllIIlIIllII, final int lllllllllllllllIIIIIlllIIlIIlIll, final int lllllllllllllllIIIIIlllIIlIIlIlI, final int lllllllllllllllIIIIIlllIIlIIIIll, final EnumFacing lllllllllllllllIIIIIlllIIlIIIIlI) {
            final StructureBoundingBox lllllllllllllllIIIIIlllIIlIIIlll = new StructureBoundingBox(lllllllllllllllIIIIIlllIIlIIlIll, lllllllllllllllIIIIIlllIIlIIlIlI - 5, lllllllllllllllIIIIIlllIIlIIIIll, lllllllllllllllIIIIIlllIIlIIlIll, lllllllllllllllIIIIIlllIIlIIlIlI + 2, lllllllllllllllIIIIIlllIIlIIIIll);
            switch (StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[lllllllllllllllIIIIIlllIIlIIIIlI.ordinal()]) {
                case 1: {
                    lllllllllllllllIIIIIlllIIlIIIlll.maxX = lllllllllllllllIIIIIlllIIlIIlIll + 2;
                    lllllllllllllllIIIIIlllIIlIIIlll.minZ = lllllllllllllllIIIIIlllIIlIIIIll - 8;
                    break;
                }
                case 2: {
                    lllllllllllllllIIIIIlllIIlIIIlll.maxX = lllllllllllllllIIIIIlllIIlIIlIll + 2;
                    lllllllllllllllIIIIIlllIIlIIIlll.maxZ = lllllllllllllllIIIIIlllIIlIIIIll + 8;
                    break;
                }
                case 3: {
                    lllllllllllllllIIIIIlllIIlIIIlll.minX = lllllllllllllllIIIIIlllIIlIIlIll - 8;
                    lllllllllllllllIIIIIlllIIlIIIlll.maxZ = lllllllllllllllIIIIIlllIIlIIIIll + 2;
                    break;
                }
                case 4: {
                    lllllllllllllllIIIIIlllIIlIIIlll.maxX = lllllllllllllllIIIIIlllIIlIIlIll + 8;
                    lllllllllllllllIIIIIlllIIlIIIlll.maxZ = lllllllllllllllIIIIIlllIIlIIIIll + 2;
                    break;
                }
            }
            return (StructureComponent.findIntersecting(lllllllllllllllIIIIIlllIIlIIllIl, lllllllllllllllIIIIIlllIIlIIIlll) != null) ? null : lllllllllllllllIIIIIlllIIlIIIlll;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIIIIIlllIIIllIlIl, final List lllllllllllllllIIIIIlllIIIllIlII, final Random lllllllllllllllIIIIIlllIIIllIIll) {
            final int lllllllllllllllIIIIIlllIIIllIlll = this.getComponentType();
            if (this.coordBaseMode != null) {
                switch (StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        func_175890_b(lllllllllllllllIIIIIlllIIIllIlIl, lllllllllllllllIIIIIlllIIIllIlII, lllllllllllllllIIIIIlllIIIllIIll, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllllIIIIIlllIIIllIlll);
                        break;
                    }
                    case 2: {
                        func_175890_b(lllllllllllllllIIIIIlllIIIllIlIl, lllllllllllllllIIIIIlllIIIllIlII, lllllllllllllllIIIIIlllIIIllIIll, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllllIIIIIlllIIIllIlll);
                        break;
                    }
                    case 3: {
                        func_175890_b(lllllllllllllllIIIIIlllIIIllIlIl, lllllllllllllllIIIIIlllIIIllIlII, lllllllllllllllIIIIIlllIIIllIIll, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.WEST, lllllllllllllllIIIIIlllIIIllIlll);
                        break;
                    }
                    case 4: {
                        func_175890_b(lllllllllllllllIIIIIlllIIIllIlIl, lllllllllllllllIIIIIlllIIIllIlII, lllllllllllllllIIIIIlllIIIllIIll, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.EAST, lllllllllllllllIIIIIlllIIIllIlll);
                        break;
                    }
                }
            }
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIIIIIlllIIIlIIlll, final Random lllllllllllllllIIIIIlllIIIlIlIll, final StructureBoundingBox lllllllllllllllIIIIIlllIIIlIIllI) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllIIIIIlllIIIlIIlll, lllllllllllllllIIIIIlllIIIlIIllI)) {
                return false;
            }
            this.func_175804_a(lllllllllllllllIIIIIlllIIIlIIlll, lllllllllllllllIIIIIlllIIIlIIllI, 0, 5, 0, 2, 7, 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIIIIIlllIIIlIIlll, lllllllllllllllIIIIIlllIIIlIIllI, 0, 0, 7, 2, 2, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            for (int lllllllllllllllIIIIIlllIIIlIlIIl = 0; lllllllllllllllIIIIIlllIIIlIlIIl < 5; ++lllllllllllllllIIIIIlllIIIlIlIIl) {
                this.func_175804_a(lllllllllllllllIIIIIlllIIIlIIlll, lllllllllllllllIIIIIlllIIIlIIllI, 0, 5 - lllllllllllllllIIIIIlllIIIlIlIIl - ((lllllllllllllllIIIIIlllIIIlIlIIl < 4) ? 1 : 0), 2 + lllllllllllllllIIIIIlllIIIlIlIIl, 2, 7 - lllllllllllllllIIIIIlllIIIlIlIIl, 2 + lllllllllllllllIIIIIlllIIIlIlIIl, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            return true;
        }
        
        public Stairs() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIIIIIlllIIlIlIllI) {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIIIIIlllIIlIlIlII) {
        }
        
        static {
            __OBFID = "CL_00000449";
        }
        
        public Stairs(final int lllllllllllllllIIIIIlllIIlIlllll, final Random lllllllllllllllIIIIIlllIIlIllllI, final StructureBoundingBox lllllllllllllllIIIIIlllIIlIlllIl, final EnumFacing lllllllllllllllIIIIIlllIIlIlllII) {
            super(lllllllllllllllIIIIIlllIIlIlllll);
            this.coordBaseMode = lllllllllllllllIIIIIlllIIlIlllII;
            this.boundingBox = lllllllllllllllIIIIIlllIIlIlllIl;
        }
    }
}
