package net.minecraft.world.gen.structure;

import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import java.util.*;

public class ComponentScatteredFeaturePieces
{
    static {
        __OBFID = "CL_00000473";
    }
    
    public static void registerScatteredFeaturePieces() {
        MapGenStructureIO.registerStructureComponent(DesertPyramid.class, "TeDP");
        MapGenStructureIO.registerStructureComponent(JunglePyramid.class, "TeJP");
        MapGenStructureIO.registerStructureComponent(SwampHut.class, "TeSH");
    }
    
    abstract static class Feature extends StructureComponent
    {
        protected /* synthetic */ int scatteredFeatureSizeZ;
        protected /* synthetic */ int scatteredFeatureSizeY;
        protected /* synthetic */ int field_74936_d;
        protected /* synthetic */ int scatteredFeatureSizeX;
        
        protected Feature(final Random llllllllllllllIllllIIllIIlIIllII, final int llllllllllllllIllllIIllIIlIIIIll, final int llllllllllllllIllllIIllIIlIIIIlI, final int llllllllllllllIllllIIllIIlIIIIIl, final int llllllllllllllIllllIIllIIlIIlIII, final int llllllllllllllIllllIIllIIIllllll, final int llllllllllllllIllllIIllIIIlllllI) {
            super(0);
            this.field_74936_d = -1;
            this.scatteredFeatureSizeX = llllllllllllllIllllIIllIIlIIlIII;
            this.scatteredFeatureSizeY = llllllllllllllIllllIIllIIIllllll;
            this.scatteredFeatureSizeZ = llllllllllllllIllllIIllIIIlllllI;
            this.coordBaseMode = EnumFacing.Plane.HORIZONTAL.random(llllllllllllllIllllIIllIIlIIllII);
            switch (ComponentScatteredFeaturePieces.SwitchEnumFacing.field_175956_a[this.coordBaseMode.ordinal()]) {
                case 1:
                case 2: {
                    this.boundingBox = new StructureBoundingBox(llllllllllllllIllllIIllIIlIIIIll, llllllllllllllIllllIIllIIlIIIIlI, llllllllllllllIllllIIllIIlIIIIIl, llllllllllllllIllllIIllIIlIIIIll + llllllllllllllIllllIIllIIlIIlIII - 1, llllllllllllllIllllIIllIIlIIIIlI + llllllllllllllIllllIIllIIIllllll - 1, llllllllllllllIllllIIllIIlIIIIIl + llllllllllllllIllllIIllIIIlllllI - 1);
                    break;
                }
                default: {
                    this.boundingBox = new StructureBoundingBox(llllllllllllllIllllIIllIIlIIIIll, llllllllllllllIllllIIllIIlIIIIlI, llllllllllllllIllllIIllIIlIIIIIl, llllllllllllllIllllIIllIIlIIIIll + llllllllllllllIllllIIllIIIlllllI - 1, llllllllllllllIllllIIllIIlIIIIlI + llllllllllllllIllllIIllIIIllllll - 1, llllllllllllllIllllIIllIIlIIIIIl + llllllllllllllIllllIIllIIlIIlIII - 1);
                    break;
                }
            }
        }
        
        static {
            __OBFID = "CL_00000479";
        }
        
        protected boolean func_74935_a(final World llllllllllllllIllllIIllIIIIllllI, final StructureBoundingBox llllllllllllllIllllIIllIIIIlllIl, final int llllllllllllllIllllIIllIIIIlllII) {
            if (this.field_74936_d >= 0) {
                return true;
            }
            int llllllllllllllIllllIIllIIIlIIlII = 0;
            int llllllllllllllIllllIIllIIIlIIIll = 0;
            for (int llllllllllllllIllllIIllIIIlIIIlI = this.boundingBox.minZ; llllllllllllllIllllIIllIIIlIIIlI <= this.boundingBox.maxZ; ++llllllllllllllIllllIIllIIIlIIIlI) {
                for (int llllllllllllllIllllIIllIIIlIIIIl = this.boundingBox.minX; llllllllllllllIllllIIllIIIlIIIIl <= this.boundingBox.maxX; ++llllllllllllllIllllIIllIIIlIIIIl) {
                    final BlockPos llllllllllllllIllllIIllIIIlIIIII = new BlockPos(llllllllllllllIllllIIllIIIlIIIIl, 64, llllllllllllllIllllIIllIIIlIIIlI);
                    if (llllllllllllllIllllIIllIIIIlllIl.func_175898_b(llllllllllllllIllllIIllIIIlIIIII)) {
                        llllllllllllllIllllIIllIIIlIIlII += Math.max(llllllllllllllIllllIIllIIIIllllI.func_175672_r(llllllllllllllIllllIIllIIIlIIIII).getY(), llllllllllllllIllllIIllIIIIllllI.provider.getAverageGroundLevel());
                        ++llllllllllllllIllllIIllIIIlIIIll;
                    }
                }
            }
            if (llllllllllllllIllllIIllIIIlIIIll == 0) {
                return false;
            }
            this.field_74936_d = llllllllllllllIllllIIllIIIlIIlII / llllllllllllllIllllIIllIIIlIIIll;
            this.boundingBox.offset(0, this.field_74936_d - this.boundingBox.minY + llllllllllllllIllllIIllIIIIlllII, 0);
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIllllIIllIIIllIIlI) {
            this.scatteredFeatureSizeX = llllllllllllllIllllIIllIIIllIIlI.getInteger("Width");
            this.scatteredFeatureSizeY = llllllllllllllIllllIIllIIIllIIlI.getInteger("Height");
            this.scatteredFeatureSizeZ = llllllllllllllIllllIIllIIIllIIlI.getInteger("Depth");
            this.field_74936_d = llllllllllllllIllllIIllIIIllIIlI.getInteger("HPos");
        }
        
        public Feature() {
            this.field_74936_d = -1;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIllllIIllIIIlllIII) {
            llllllllllllllIllllIIllIIIlllIII.setInteger("Width", this.scatteredFeatureSizeX);
            llllllllllllllIllllIIllIIIlllIII.setInteger("Height", this.scatteredFeatureSizeY);
            llllllllllllllIllllIIllIIIlllIII.setInteger("Depth", this.scatteredFeatureSizeZ);
            llllllllllllllIllllIIllIIIlllIII.setInteger("HPos", this.field_74936_d);
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_175956_a;
        
        static {
            __OBFID = "CL_00001971";
            field_175956_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_175956_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_175956_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
        }
    }
    
    public static class SwampHut extends Feature
    {
        private /* synthetic */ boolean hasWitch;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIIIllIlIIIIIIIIIII) {
            super.writeStructureToNBT(llllllllllllllIIIllIlIIIIIIIIIII);
            llllllllllllllIIIllIlIIIIIIIIIII.setBoolean("Witch", this.hasWitch);
        }
        
        public SwampHut() {
        }
        
        public SwampHut(final Random llllllllllllllIIIllIlIIIIIIIllII, final int llllllllllllllIIIllIlIIIIIIIIlll, final int llllllllllllllIIIllIlIIIIIIIIllI) {
            super(llllllllllllllIIIllIlIIIIIIIllII, llllllllllllllIIIllIlIIIIIIIIlll, 64, llllllllllllllIIIllIlIIIIIIIIllI, 7, 5, 9);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIIIllIIlllllllllII) {
            super.readStructureFromNBT(llllllllllllllIIIllIIlllllllllII);
            this.hasWitch = llllllllllllllIIIllIIlllllllllII.getBoolean("Witch");
        }
        
        static {
            __OBFID = "CL_00000480";
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIIllIIllllllIIIII, final Random llllllllllllllIIIllIIllllllIllII, final StructureBoundingBox llllllllllllllIIIllIIllllllIlIll) {
            if (!this.func_74935_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 0)) {
                return false;
            }
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 1, 1, 1, 5, 1, 7, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 1, 4, 2, 5, 4, 7, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 2, 1, 0, 4, 1, 0, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 2, 2, 2, 3, 3, 2, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 1, 2, 3, 1, 3, 6, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 5, 2, 3, 5, 3, 6, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 2, 2, 7, 4, 3, 7, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.func_176839_a()), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 1, 0, 2, 1, 3, 2, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 5, 0, 2, 5, 3, 2, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 1, 0, 7, 1, 3, 7, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 5, 0, 7, 5, 3, 7, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIIIllIIllllllIIIII, Blocks.oak_fence.getDefaultState(), 2, 3, 2, llllllllllllllIIIllIIllllllIlIll);
            this.func_175811_a(llllllllllllllIIIllIIllllllIIIII, Blocks.oak_fence.getDefaultState(), 3, 3, 7, llllllllllllllIIIllIIllllllIlIll);
            this.func_175811_a(llllllllllllllIIIllIIllllllIIIII, Blocks.air.getDefaultState(), 1, 3, 4, llllllllllllllIIIllIIllllllIlIll);
            this.func_175811_a(llllllllllllllIIIllIIllllllIIIII, Blocks.air.getDefaultState(), 5, 3, 4, llllllllllllllIIIllIIllllllIlIll);
            this.func_175811_a(llllllllllllllIIIllIIllllllIIIII, Blocks.air.getDefaultState(), 5, 3, 5, llllllllllllllIIIllIIllllllIlIll);
            this.func_175811_a(llllllllllllllIIIllIIllllllIIIII, Blocks.flower_pot.getDefaultState().withProperty(BlockFlowerPot.field_176443_b, BlockFlowerPot.EnumFlowerType.MUSHROOM_RED), 1, 3, 5, llllllllllllllIIIllIIllllllIlIll);
            this.func_175811_a(llllllllllllllIIIllIIllllllIIIII, Blocks.crafting_table.getDefaultState(), 3, 2, 6, llllllllllllllIIIllIIllllllIlIll);
            this.func_175811_a(llllllllllllllIIIllIIllllllIIIII, Blocks.cauldron.getDefaultState(), 4, 2, 6, llllllllllllllIIIllIIllllllIlIll);
            this.func_175811_a(llllllllllllllIIIllIIllllllIIIII, Blocks.oak_fence.getDefaultState(), 1, 2, 1, llllllllllllllIIIllIIllllllIlIll);
            this.func_175811_a(llllllllllllllIIIllIIllllllIIIII, Blocks.oak_fence.getDefaultState(), 5, 2, 1, llllllllllllllIIIllIIllllllIlIll);
            final int llllllllllllllIIIllIIllllllIlIlI = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            final int llllllllllllllIIIllIIllllllIlIIl = this.getMetadataWithOffset(Blocks.oak_stairs, 1);
            final int llllllllllllllIIIllIIllllllIlIII = this.getMetadataWithOffset(Blocks.oak_stairs, 0);
            final int llllllllllllllIIIllIIllllllIIlll = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 0, 4, 1, 6, 4, 1, Blocks.spruce_stairs.getStateFromMeta(llllllllllllllIIIllIIllllllIlIlI), Blocks.spruce_stairs.getStateFromMeta(llllllllllllllIIIllIIllllllIlIlI), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 0, 4, 2, 0, 4, 7, Blocks.spruce_stairs.getStateFromMeta(llllllllllllllIIIllIIllllllIlIII), Blocks.spruce_stairs.getStateFromMeta(llllllllllllllIIIllIIllllllIlIII), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 6, 4, 2, 6, 4, 7, Blocks.spruce_stairs.getStateFromMeta(llllllllllllllIIIllIIllllllIlIIl), Blocks.spruce_stairs.getStateFromMeta(llllllllllllllIIIllIIllllllIlIIl), false);
            this.func_175804_a(llllllllllllllIIIllIIllllllIIIII, llllllllllllllIIIllIIllllllIlIll, 0, 4, 8, 6, 4, 8, Blocks.spruce_stairs.getStateFromMeta(llllllllllllllIIIllIIllllllIIlll), Blocks.spruce_stairs.getStateFromMeta(llllllllllllllIIIllIIllllllIIlll), false);
            for (int llllllllllllllIIIllIIllllllIIllI = 2; llllllllllllllIIIllIIllllllIIllI <= 7; llllllllllllllIIIllIIllllllIIllI += 5) {
                for (int llllllllllllllIIIllIIllllllIIlIl = 1; llllllllllllllIIIllIIllllllIIlIl <= 5; llllllllllllllIIIllIIllllllIIlIl += 4) {
                    this.func_175808_b(llllllllllllllIIIllIIllllllIIIII, Blocks.log.getDefaultState(), llllllllllllllIIIllIIllllllIIlIl, -1, llllllllllllllIIIllIIllllllIIllI, llllllllllllllIIIllIIllllllIlIll);
                }
            }
            if (!this.hasWitch) {
                final int llllllllllllllIIIllIIllllllIIllI = this.getXWithOffset(2, 5);
                final int llllllllllllllIIIllIIllllllIIlII = this.getYWithOffset(2);
                final int llllllllllllllIIIllIIllllllIIIll = this.getZWithOffset(2, 5);
                if (llllllllllllllIIIllIIllllllIlIll.func_175898_b(new BlockPos(llllllllllllllIIIllIIllllllIIllI, llllllllllllllIIIllIIllllllIIlII, llllllllllllllIIIllIIllllllIIIll))) {
                    this.hasWitch = true;
                    final EntityWitch llllllllllllllIIIllIIllllllIIIlI = new EntityWitch(llllllllllllllIIIllIIllllllIIIII);
                    llllllllllllllIIIllIIllllllIIIlI.setLocationAndAngles(llllllllllllllIIIllIIllllllIIllI + 0.5, llllllllllllllIIIllIIllllllIIlII, llllllllllllllIIIllIIllllllIIIll + 0.5, 0.0f, 0.0f);
                    llllllllllllllIIIllIIllllllIIIlI.func_180482_a(llllllllllllllIIIllIIllllllIIIII.getDifficultyForLocation(new BlockPos(llllllllllllllIIIllIIllllllIIllI, llllllllllllllIIIllIIllllllIIlII, llllllllllllllIIIllIIllllllIIIll)), null);
                    llllllllllllllIIIllIIllllllIIIII.spawnEntityInWorld(llllllllllllllIIIllIIllllllIIIlI);
                }
            }
            return true;
        }
    }
    
    public static class JunglePyramid extends Feature
    {
        private static final /* synthetic */ List field_175816_i;
        private /* synthetic */ boolean field_74948_i;
        private static final /* synthetic */ List field_175815_j;
        private /* synthetic */ boolean field_74947_h;
        private /* synthetic */ boolean field_74945_j;
        private /* synthetic */ boolean field_74946_k;
        private static /* synthetic */ Stones junglePyramidsRandomScatteredStones;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllllIIlllIlllIIllllI) {
            super.writeStructureToNBT(llllllllllllllllIIlllIlllIIllllI);
            llllllllllllllllIIlllIlllIIllllI.setBoolean("placedMainChest", this.field_74947_h);
            llllllllllllllllIIlllIlllIIllllI.setBoolean("placedHiddenChest", this.field_74948_i);
            llllllllllllllllIIlllIlllIIllllI.setBoolean("placedTrap1", this.field_74945_j);
            llllllllllllllllIIlllIlllIIllllI.setBoolean("placedTrap2", this.field_74946_k);
        }
        
        public JunglePyramid() {
        }
        
        public JunglePyramid(final Random llllllllllllllllIIlllIlllIlIIlII, final int llllllllllllllllIIlllIlllIlIIIll, final int llllllllllllllllIIlllIlllIlIIIlI) {
            super(llllllllllllllllIIlllIlllIlIIlII, llllllllllllllllIIlllIlllIlIIIll, 64, llllllllllllllllIIlllIlllIlIIIlI, 12, 10, 15);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllllIIlllIlllIIlIllI) {
            super.readStructureFromNBT(llllllllllllllllIIlllIlllIIlIllI);
            this.field_74947_h = llllllllllllllllIIlllIlllIIlIllI.getBoolean("placedMainChest");
            this.field_74948_i = llllllllllllllllIIlllIlllIIlIllI.getBoolean("placedHiddenChest");
            this.field_74945_j = llllllllllllllllIIlllIlllIIlIllI.getBoolean("placedTrap1");
            this.field_74946_k = llllllllllllllllIIlllIlllIIlIllI.getBoolean("placedTrap2");
        }
        
        static {
            __OBFID = "CL_00000477";
            field_175816_i = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 2, 7, 15), new WeightedRandomChestContent(Items.emerald, 0, 1, 3, 2), new WeightedRandomChestContent(Items.bone, 0, 4, 6, 20), new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 7, 16), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1) });
            field_175815_j = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.arrow, 0, 2, 7, 30) });
            JunglePyramid.junglePyramidsRandomScatteredStones = new Stones(null);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIIlllIlllIIIlIlI, final Random llllllllllllllllIIlllIllIlllllll, final StructureBoundingBox llllllllllllllllIIlllIlllIIIlIII) {
            if (!this.func_74935_a(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 0)) {
                return false;
            }
            final int llllllllllllllllIIlllIlllIIIIlll = this.getMetadataWithOffset(Blocks.stone_stairs, 3);
            final int llllllllllllllllIIlllIlllIIIIllI = this.getMetadataWithOffset(Blocks.stone_stairs, 2);
            final int llllllllllllllllIIlllIlllIIIIlIl = this.getMetadataWithOffset(Blocks.stone_stairs, 0);
            final int llllllllllllllllIIlllIlllIIIIlII = this.getMetadataWithOffset(Blocks.stone_stairs, 1);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 0, -4, 0, this.scatteredFeatureSizeX - 1, 0, this.scatteredFeatureSizeZ - 1, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 2, 1, 2, 9, 2, 2, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 2, 1, 12, 9, 2, 12, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 2, 1, 3, 2, 2, 11, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 9, 1, 3, 9, 2, 11, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 1, 3, 1, 10, 6, 1, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 1, 3, 13, 10, 6, 13, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 1, 3, 2, 1, 6, 12, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 10, 3, 2, 10, 6, 12, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 2, 3, 2, 9, 3, 12, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 2, 6, 2, 9, 6, 12, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 3, 7, 3, 8, 7, 11, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 4, 8, 4, 7, 8, 10, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 3, 1, 3, 8, 2, 11);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 4, 3, 6, 7, 3, 9);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 2, 4, 2, 9, 5, 12);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 4, 6, 5, 7, 6, 9);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 5, 7, 6, 6, 7, 8);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 5, 1, 2, 6, 2, 2);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 5, 2, 12, 6, 2, 12);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 5, 5, 1, 6, 5, 1);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 5, 5, 13, 6, 5, 13);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.air.getDefaultState(), 1, 5, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.air.getDefaultState(), 10, 5, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.air.getDefaultState(), 1, 5, 9, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.air.getDefaultState(), 10, 5, 9, llllllllllllllllIIlllIlllIIIlIII);
            for (int llllllllllllllllIIlllIlllIIIIIll = 0; llllllllllllllllIIlllIlllIIIIIll <= 14; llllllllllllllllIIlllIlllIIIIIll += 14) {
                this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 2, 4, llllllllllllllllIIlllIlllIIIIIll, 2, 5, llllllllllllllllIIlllIlllIIIIIll, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 4, 4, llllllllllllllllIIlllIlllIIIIIll, 4, 5, llllllllllllllllIIlllIlllIIIIIll, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 7, 4, llllllllllllllllIIlllIlllIIIIIll, 7, 5, llllllllllllllllIIlllIlllIIIIIll, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 9, 4, llllllllllllllllIIlllIlllIIIIIll, 9, 5, llllllllllllllllIIlllIlllIIIIIll, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 5, 6, 0, 6, 6, 0, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            for (int llllllllllllllllIIlllIlllIIIIIll = 0; llllllllllllllllIIlllIlllIIIIIll <= 11; llllllllllllllllIIlllIlllIIIIIll += 11) {
                for (int llllllllllllllllIIlllIlllIIIIIlI = 2; llllllllllllllllIIlllIlllIIIIIlI <= 12; llllllllllllllllIIlllIlllIIIIIlI += 2) {
                    this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, llllllllllllllllIIlllIlllIIIIIll, 4, llllllllllllllllIIlllIlllIIIIIlI, llllllllllllllllIIlllIlllIIIIIll, 5, llllllllllllllllIIlllIlllIIIIIlI, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
                }
                this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, llllllllllllllllIIlllIlllIIIIIll, 6, 5, llllllllllllllllIIlllIlllIIIIIll, 6, 5, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, llllllllllllllllIIlllIlllIIIIIll, 6, 9, llllllllllllllllIIlllIlllIIIIIll, 6, 9, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 2, 7, 2, 2, 9, 2, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 9, 7, 2, 9, 9, 2, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 2, 7, 12, 2, 9, 12, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 9, 7, 12, 9, 9, 12, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 4, 9, 4, 4, 9, 4, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 7, 9, 4, 7, 9, 4, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 4, 9, 10, 4, 9, 10, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 7, 9, 10, 7, 9, 10, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 5, 9, 7, 6, 9, 7, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 5, 9, 6, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 6, 9, 6, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIllI), 5, 9, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIllI), 6, 9, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 4, 0, 0, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 5, 0, 0, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 6, 0, 0, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 7, 0, 0, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 4, 1, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 4, 2, 9, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 4, 3, 10, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 7, 1, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 7, 2, 9, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlll), 7, 3, 10, llllllllllllllllIIlllIlllIIIlIII);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 4, 1, 9, 4, 1, 9, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 7, 1, 9, 7, 1, 9, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 4, 1, 10, 7, 2, 10, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 5, 4, 5, 6, 4, 5, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlIl), 4, 4, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIlII), 7, 4, 5, llllllllllllllllIIlllIlllIIIlIII);
            for (int llllllllllllllllIIlllIlllIIIIIll = 0; llllllllllllllllIIlllIlllIIIIIll < 4; ++llllllllllllllllIIlllIlllIIIIIll) {
                this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIllI), 5, 0 - llllllllllllllllIIlllIlllIIIIIll, 6 + llllllllllllllllIIlllIlllIIIIIll, llllllllllllllllIIlllIlllIIIlIII);
                this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stone_stairs.getStateFromMeta(llllllllllllllllIIlllIlllIIIIllI), 6, 0 - llllllllllllllllIIlllIlllIIIIIll, 6 + llllllllllllllllIIlllIlllIIIIIll, llllllllllllllllIIlllIlllIIIlIII);
                this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 5, 0 - llllllllllllllllIIlllIlllIIIIIll, 7 + llllllllllllllllIIlllIlllIIIIIll, 6, 0 - llllllllllllllllIIlllIlllIIIIIll, 9 + llllllllllllllllIIlllIlllIIIIIll);
            }
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 1, -3, 12, 10, -1, 13);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 1, -3, 1, 3, -1, 13);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 1, -3, 1, 9, -1, 5);
            for (int llllllllllllllllIIlllIlllIIIIIll = 1; llllllllllllllllIIlllIlllIIIIIll <= 13; llllllllllllllllIIlllIlllIIIIIll += 2) {
                this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 1, -3, llllllllllllllllIIlllIlllIIIIIll, 1, -2, llllllllllllllllIIlllIlllIIIIIll, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            for (int llllllllllllllllIIlllIlllIIIIIll = 2; llllllllllllllllIIlllIlllIIIIIll <= 12; llllllllllllllllIIlllIlllIIIIIll += 2) {
                this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 1, -1, llllllllllllllllIIlllIlllIIIIIll, 3, -1, llllllllllllllllIIlllIlllIIIIIll, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 2, -2, 1, 5, -2, 1, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 7, -2, 1, 9, -2, 1, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 6, -3, 1, 6, -3, 1, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 6, -1, 1, 6, -1, 1, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.tripwire_hook.getStateFromMeta(this.getMetadataWithOffset(Blocks.tripwire_hook, EnumFacing.EAST.getHorizontalIndex())).withProperty(BlockTripWireHook.field_176265_M, true), 1, -3, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.tripwire_hook.getStateFromMeta(this.getMetadataWithOffset(Blocks.tripwire_hook, EnumFacing.WEST.getHorizontalIndex())).withProperty(BlockTripWireHook.field_176265_M, true), 4, -3, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.tripwire.getDefaultState().withProperty(BlockTripWire.field_176294_M, true), 2, -3, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.tripwire.getDefaultState().withProperty(BlockTripWire.field_176294_M, true), 3, -3, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 5, -3, 7, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 5, -3, 6, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 5, -3, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 5, -3, 4, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 5, -3, 3, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 5, -3, 2, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 5, -3, 1, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 4, -3, 1, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 3, -3, 1, llllllllllllllllIIlllIlllIIIlIII);
            if (!this.field_74945_j) {
                this.field_74945_j = this.func_175806_a(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, llllllllllllllllIIlllIllIlllllll, 3, -2, 1, EnumFacing.NORTH.getIndex(), JunglePyramid.field_175815_j, 2);
            }
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.vine.getStateFromMeta(15), 3, -2, 2, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.tripwire_hook.getStateFromMeta(this.getMetadataWithOffset(Blocks.tripwire_hook, EnumFacing.NORTH.getHorizontalIndex())).withProperty(BlockTripWireHook.field_176265_M, true), 7, -3, 1, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.tripwire_hook.getStateFromMeta(this.getMetadataWithOffset(Blocks.tripwire_hook, EnumFacing.SOUTH.getHorizontalIndex())).withProperty(BlockTripWireHook.field_176265_M, true), 7, -3, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.tripwire.getDefaultState().withProperty(BlockTripWire.field_176294_M, true), 7, -3, 2, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.tripwire.getDefaultState().withProperty(BlockTripWire.field_176294_M, true), 7, -3, 3, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.tripwire.getDefaultState().withProperty(BlockTripWire.field_176294_M, true), 7, -3, 4, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 8, -3, 6, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 9, -3, 6, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 9, -3, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 9, -3, 4, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 9, -2, 4, llllllllllllllllIIlllIlllIIIlIII);
            if (!this.field_74946_k) {
                this.field_74946_k = this.func_175806_a(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, llllllllllllllllIIlllIllIlllllll, 9, -2, 3, EnumFacing.WEST.getIndex(), JunglePyramid.field_175815_j, 2);
            }
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.vine.getStateFromMeta(15), 8, -1, 3, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.vine.getStateFromMeta(15), 8, -2, 3, llllllllllllllllIIlllIlllIIIlIII);
            if (!this.field_74947_h) {
                this.field_74947_h = this.func_180778_a(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, llllllllllllllllIIlllIllIlllllll, 8, -3, 3, WeightedRandomChestContent.func_177629_a(JunglePyramid.field_175816_i, Items.enchanted_book.getRandomEnchantedBook(llllllllllllllllIIlllIllIlllllll)), 2 + llllllllllllllllIIlllIllIlllllll.nextInt(5));
            }
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 9, -3, 2, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 8, -3, 1, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 4, -3, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 5, -2, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 5, -1, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 6, -3, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 7, -2, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 7, -1, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 8, -3, 5, llllllllllllllllIIlllIlllIIIlIII);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 9, -1, 1, 9, -1, 5, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithAir(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 8, -3, 8, 10, -1, 10);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.CHISELED_META), 8, -2, 11, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.CHISELED_META), 9, -2, 11, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.CHISELED_META), 10, -2, 11, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.lever.getStateFromMeta(BlockLever.func_176357_a(EnumFacing.getFront(this.getMetadataWithOffset(Blocks.lever, EnumFacing.NORTH.getIndex())))), 8, -2, 12, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.lever.getStateFromMeta(BlockLever.func_176357_a(EnumFacing.getFront(this.getMetadataWithOffset(Blocks.lever, EnumFacing.NORTH.getIndex())))), 9, -2, 12, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.lever.getStateFromMeta(BlockLever.func_176357_a(EnumFacing.getFront(this.getMetadataWithOffset(Blocks.lever, EnumFacing.NORTH.getIndex())))), 10, -2, 12, llllllllllllllllIIlllIlllIIIlIII);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 8, -3, 8, 8, -3, 10, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, 10, -3, 8, 10, -3, 10, false, llllllllllllllllIIlllIllIlllllll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.mossy_cobblestone.getDefaultState(), 10, -2, 9, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 8, -2, 9, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 8, -2, 10, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.redstone_wire.getDefaultState(), 10, -1, 9, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.sticky_piston.getStateFromMeta(EnumFacing.UP.getIndex()), 9, -2, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.sticky_piston.getStateFromMeta(this.getMetadataWithOffset(Blocks.sticky_piston, EnumFacing.WEST.getIndex())), 10, -2, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.sticky_piston.getStateFromMeta(this.getMetadataWithOffset(Blocks.sticky_piston, EnumFacing.WEST.getIndex())), 10, -1, 8, llllllllllllllllIIlllIlllIIIlIII);
            this.func_175811_a(llllllllllllllllIIlllIlllIIIlIlI, Blocks.unpowered_repeater.getStateFromMeta(this.getMetadataWithOffset(Blocks.unpowered_repeater, EnumFacing.NORTH.getHorizontalIndex())), 10, -2, 10, llllllllllllllllIIlllIlllIIIlIII);
            if (!this.field_74948_i) {
                this.field_74948_i = this.func_180778_a(llllllllllllllllIIlllIlllIIIlIlI, llllllllllllllllIIlllIlllIIIlIII, llllllllllllllllIIlllIllIlllllll, 9, -3, 10, WeightedRandomChestContent.func_177629_a(JunglePyramid.field_175816_i, Items.enchanted_book.getRandomEnchantedBook(llllllllllllllllIIlllIllIlllllll)), 2 + llllllllllllllllIIlllIllIlllllll.nextInt(5));
            }
            return true;
        }
        
        static class Stones extends BlockSelector
        {
            static {
                __OBFID = "CL_00000478";
            }
            
            Stones(final ComponentScatteredFeaturePieces.SwitchEnumFacing lllIIIllIllIllI) {
                this();
            }
            
            @Override
            public void selectBlocks(final Random lllIIIllIlllIIl, final int lllIIIllIlllllI, final int lllIIIllIllllIl, final int lllIIIllIllllII, final boolean lllIIIllIlllIll) {
                if (lllIIIllIlllIIl.nextFloat() < 0.4f) {
                    this.field_151562_a = Blocks.cobblestone.getDefaultState();
                }
                else {
                    this.field_151562_a = Blocks.mossy_cobblestone.getDefaultState();
                }
            }
            
            private Stones() {
            }
        }
    }
    
    public static class DesertPyramid extends Feature
    {
        private /* synthetic */ boolean[] field_74940_h;
        private static final /* synthetic */ List itemsToGenerateInTemple;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIlIIIlIIlIlIIlIllI) {
            super.readStructureFromNBT(llllllllllllllIlIIIlIIlIlIIlIllI);
            this.field_74940_h[0] = llllllllllllllIlIIIlIIlIlIIlIllI.getBoolean("hasPlacedChest0");
            this.field_74940_h[1] = llllllllllllllIlIIIlIIlIlIIlIllI.getBoolean("hasPlacedChest1");
            this.field_74940_h[2] = llllllllllllllIlIIIlIIlIlIIlIllI.getBoolean("hasPlacedChest2");
            this.field_74940_h[3] = llllllllllllllIlIIIlIIlIlIIlIllI.getBoolean("hasPlacedChest3");
        }
        
        public DesertPyramid() {
            this.field_74940_h = new boolean[4];
        }
        
        static {
            __OBFID = "CL_00000476";
            itemsToGenerateInTemple = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 2, 7, 15), new WeightedRandomChestContent(Items.emerald, 0, 1, 3, 2), new WeightedRandomChestContent(Items.bone, 0, 4, 6, 20), new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 7, 16), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1) });
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIlIIIlIIlIlIIllllI) {
            super.writeStructureToNBT(llllllllllllllIlIIIlIIlIlIIllllI);
            llllllllllllllIlIIIlIIlIlIIllllI.setBoolean("hasPlacedChest0", this.field_74940_h[0]);
            llllllllllllllIlIIIlIIlIlIIllllI.setBoolean("hasPlacedChest1", this.field_74940_h[1]);
            llllllllllllllIlIIIlIIlIlIIllllI.setBoolean("hasPlacedChest2", this.field_74940_h[2]);
            llllllllllllllIlIIIlIIlIlIIllllI.setBoolean("hasPlacedChest3", this.field_74940_h[3]);
        }
        
        public DesertPyramid(final Random llllllllllllllIlIIIlIIlIlIlIlIII, final int llllllllllllllIlIIIlIIlIlIlIIlll, final int llllllllllllllIlIIIlIIlIlIlIIllI) {
            super(llllllllllllllIlIIIlIIlIlIlIlIII, llllllllllllllIlIIIlIIlIlIlIIlll, 64, llllllllllllllIlIIIlIIlIlIlIIllI, 21, 15, 21);
            this.field_74940_h = new boolean[4];
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIIIlIIlIIlllIlII, final Random llllllllllllllIlIIIlIIlIlIIIIlII, final StructureBoundingBox llllllllllllllIlIIIlIIlIIlllIIlI) {
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 0, -4, 0, this.scatteredFeatureSizeX - 1, 0, this.scatteredFeatureSizeZ - 1, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            for (int llllllllllllllIlIIIlIIlIlIIIIIlI = 1; llllllllllllllIlIIIlIIlIlIIIIIlI <= 9; ++llllllllllllllIlIIIlIIlIlIIIIIlI) {
                this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, llllllllllllllIlIIIlIIlIlIIIIIlI, llllllllllllllIlIIIlIIlIlIIIIIlI, llllllllllllllIlIIIlIIlIlIIIIIlI, this.scatteredFeatureSizeX - 1 - llllllllllllllIlIIIlIIlIlIIIIIlI, llllllllllllllIlIIIlIIlIlIIIIIlI, this.scatteredFeatureSizeZ - 1 - llllllllllllllIlIIIlIIlIlIIIIIlI, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
                this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, llllllllllllllIlIIIlIIlIlIIIIIlI + 1, llllllllllllllIlIIIlIIlIlIIIIIlI, llllllllllllllIlIIIlIIlIlIIIIIlI + 1, this.scatteredFeatureSizeX - 2 - llllllllllllllIlIIIlIIlIlIIIIIlI, llllllllllllllIlIIIlIIlIlIIIIIlI, this.scatteredFeatureSizeZ - 2 - llllllllllllllIlIIIlIIlIlIIIIIlI, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            for (int llllllllllllllIlIIIlIIlIlIIIIIlI = 0; llllllllllllllIlIIIlIIlIlIIIIIlI < this.scatteredFeatureSizeX; ++llllllllllllllIlIIIlIIlIlIIIIIlI) {
                for (int llllllllllllllIlIIIlIIlIlIIIIIIl = 0; llllllllllllllIlIIIlIIlIlIIIIIIl < this.scatteredFeatureSizeZ; ++llllllllllllllIlIIIlIIlIlIIIIIIl) {
                    final byte llllllllllllllIlIIIlIIlIIlllllll = -5;
                    this.func_175808_b(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getDefaultState(), llllllllllllllIlIIIlIIlIlIIIIIlI, llllllllllllllIlIIIlIIlIIlllllll, llllllllllllllIlIIIlIIlIlIIIIIIl, llllllllllllllIlIIIlIIlIIlllIIlI);
                }
            }
            int llllllllllllllIlIIIlIIlIlIIIIIlI = this.getMetadataWithOffset(Blocks.sandstone_stairs, 3);
            final int llllllllllllllIlIIIlIIlIlIIIIIII = this.getMetadataWithOffset(Blocks.sandstone_stairs, 2);
            final int llllllllllllllIlIIIlIIlIIllllllI = this.getMetadataWithOffset(Blocks.sandstone_stairs, 0);
            final int llllllllllllllIlIIIlIIlIIlllllIl = this.getMetadataWithOffset(Blocks.sandstone_stairs, 1);
            final int llllllllllllllIlIIIlIIlIIlllllII = ~EnumDyeColor.ORANGE.getDyeColorDamage() & 0xF;
            final int llllllllllllllIlIIIlIIlIIllllIll = ~EnumDyeColor.BLUE.getDyeColorDamage() & 0xF;
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 0, 0, 0, 4, 9, 4, Blocks.sandstone.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 1, 10, 1, 3, 10, 3, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIlIIIIIlI), 2, 10, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIlIIIIIII), 2, 10, 4, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIIllllllI), 0, 10, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllIl), 4, 10, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, this.scatteredFeatureSizeX - 5, 0, 0, this.scatteredFeatureSizeX - 1, 9, 4, Blocks.sandstone.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, this.scatteredFeatureSizeX - 4, 10, 1, this.scatteredFeatureSizeX - 2, 10, 3, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIlIIIIIlI), this.scatteredFeatureSizeX - 3, 10, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIlIIIIIII), this.scatteredFeatureSizeX - 3, 10, 4, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIIllllllI), this.scatteredFeatureSizeX - 5, 10, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllIl), this.scatteredFeatureSizeX - 1, 10, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 8, 0, 0, 12, 4, 4, Blocks.sandstone.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 9, 1, 0, 11, 3, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 9, 1, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 9, 2, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 9, 3, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 10, 3, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 11, 3, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 11, 2, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 11, 1, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 4, 1, 1, 8, 3, 3, Blocks.sandstone.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 4, 1, 2, 8, 2, 2, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 12, 1, 1, 16, 3, 3, Blocks.sandstone.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 12, 1, 2, 16, 2, 2, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 5, 4, 5, this.scatteredFeatureSizeX - 6, 4, this.scatteredFeatureSizeZ - 6, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 9, 4, 9, 11, 4, 11, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 8, 1, 8, 8, 3, 8, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 12, 1, 8, 12, 3, 8, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 8, 1, 12, 8, 3, 12, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 12, 1, 12, 12, 3, 12, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 1, 1, 5, 4, 4, 11, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, this.scatteredFeatureSizeX - 5, 1, 5, this.scatteredFeatureSizeX - 2, 4, 11, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 6, 7, 9, 6, 7, 11, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, this.scatteredFeatureSizeX - 7, 7, 9, this.scatteredFeatureSizeX - 7, 7, 11, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 5, 5, 9, 5, 7, 11, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, this.scatteredFeatureSizeX - 6, 5, 9, this.scatteredFeatureSizeX - 6, 7, 11, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), false);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 5, 5, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 5, 6, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 6, 6, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), this.scatteredFeatureSizeX - 6, 5, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), this.scatteredFeatureSizeX - 6, 6, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), this.scatteredFeatureSizeX - 7, 6, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 2, 4, 4, 2, 6, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, this.scatteredFeatureSizeX - 3, 4, 4, this.scatteredFeatureSizeX - 3, 6, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIlIIIIIlI), 2, 4, 5, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIlIIIIIlI), 2, 3, 4, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIlIIIIIlI), this.scatteredFeatureSizeX - 3, 4, 5, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIlIIIIIlI), this.scatteredFeatureSizeX - 3, 3, 4, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 1, 1, 3, 2, 2, 3, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, this.scatteredFeatureSizeX - 3, 1, 3, this.scatteredFeatureSizeX - 2, 2, 3, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getDefaultState(), 1, 1, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getDefaultState(), this.scatteredFeatureSizeX - 2, 1, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SAND.func_176624_a()), 1, 2, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SAND.func_176624_a()), this.scatteredFeatureSizeX - 2, 2, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllIl), 2, 1, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone_stairs.getStateFromMeta(llllllllllllllIlIIIlIIlIIllllllI), this.scatteredFeatureSizeX - 3, 1, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 4, 3, 5, 4, 3, 18, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, this.scatteredFeatureSizeX - 5, 3, 5, this.scatteredFeatureSizeX - 5, 3, 17, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 3, 1, 5, 4, 2, 16, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, this.scatteredFeatureSizeX - 6, 1, 5, this.scatteredFeatureSizeX - 5, 2, 16, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            for (int llllllllllllllIlIIIlIIlIIllllIlI = 5; llllllllllllllIlIIIlIIlIIllllIlI <= 17; llllllllllllllIlIIIlIIlIIllllIlI += 2) {
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 4, 1, llllllllllllllIlIIIlIIlIIllllIlI, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), 4, 2, llllllllllllllIlIIIlIIlIIllllIlI, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), this.scatteredFeatureSizeX - 5, 1, llllllllllllllIlIIIlIIlIIllllIlI, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), this.scatteredFeatureSizeX - 5, 2, llllllllllllllIlIIIlIIlIIllllIlI, llllllllllllllIlIIIlIIlIIlllIIlI);
            }
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 10, 0, 7, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 10, 0, 8, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 9, 0, 9, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 11, 0, 9, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 8, 0, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 12, 0, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 7, 0, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 13, 0, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 9, 0, 11, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 11, 0, 11, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 10, 0, 12, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 10, 0, 13, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIllllIll), 10, 0, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            for (int llllllllllllllIlIIIlIIlIIllllIlI = 0; llllllllllllllIlIIIlIIlIIllllIlI <= this.scatteredFeatureSizeX - 1; llllllllllllllIlIIIlIIlIIllllIlI += this.scatteredFeatureSizeX - 1) {
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 2, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 2, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 2, 3, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 3, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 3, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 3, 3, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 4, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 4, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 4, 3, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 5, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 5, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 5, 3, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 6, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 6, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 6, 3, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 7, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 7, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 7, 3, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 8, 1, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 8, 2, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 8, 3, llllllllllllllIlIIIlIIlIIlllIIlI);
            }
            for (int llllllllllllllIlIIIlIIlIIllllIlI = 2; llllllllllllllIlIIIlIIlIIllllIlI <= this.scatteredFeatureSizeX - 3; llllllllllllllIlIIIlIIlIIllllIlI += this.scatteredFeatureSizeX - 3 - 2) {
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI - 1, 2, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 2, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI + 1, 2, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI - 1, 3, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 3, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI + 1, 3, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI - 1, 4, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 4, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI + 1, 4, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI - 1, 5, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 5, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI + 1, 5, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI - 1, 6, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 6, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI + 1, 6, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI - 1, 7, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI, 7, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), llllllllllllllIlIIIlIIlIIllllIlI + 1, 7, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI - 1, 8, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI, 8, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
                this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), llllllllllllllIlIIIlIIlIIllllIlI + 1, 8, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
            }
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 8, 4, 0, 12, 6, 0, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), false);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 8, 6, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 12, 6, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 9, 5, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), 10, 5, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stained_hardened_clay.getStateFromMeta(llllllllllllllIlIIIlIIlIIlllllII), 11, 5, 0, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 8, -14, 8, 12, -11, 12, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 8, -10, 8, 12, -10, 12, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 8, -9, 8, 12, -9, 12, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 8, -8, 8, 12, -1, 12, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 9, -11, 9, 11, -1, 11, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.stone_pressure_plate.getDefaultState(), 10, -11, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175804_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, 9, -13, 9, 11, -13, 11, Blocks.tnt.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 8, -11, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 8, -10, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), 7, -10, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 7, -11, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 12, -11, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 12, -10, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), 13, -10, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 13, -11, 10, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 10, -11, 8, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 10, -10, 8, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), 10, -10, 7, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 10, -11, 7, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 10, -11, 12, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.air.getDefaultState(), 10, -10, 12, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.func_176675_a()), 10, -10, 13, llllllllllllllIlIIIlIIlIIlllIIlI);
            this.func_175811_a(llllllllllllllIlIIIlIIlIIlllIlII, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a()), 10, -11, 13, llllllllllllllIlIIIlIIlIIlllIIlI);
            for (final EnumFacing llllllllllllllIlIIIlIIlIIllllIII : EnumFacing.Plane.HORIZONTAL) {
                if (!this.field_74940_h[llllllllllllllIlIIIlIIlIIllllIII.getHorizontalIndex()]) {
                    final int llllllllllllllIlIIIlIIlIIlllIlll = llllllllllllllIlIIIlIIlIIllllIII.getFrontOffsetX() * 2;
                    final int llllllllllllllIlIIIlIIlIIlllIllI = llllllllllllllIlIIIlIIlIIllllIII.getFrontOffsetZ() * 2;
                    this.field_74940_h[llllllllllllllIlIIIlIIlIIllllIII.getHorizontalIndex()] = this.func_180778_a(llllllllllllllIlIIIlIIlIIlllIlII, llllllllllllllIlIIIlIIlIIlllIIlI, llllllllllllllIlIIIlIIlIlIIIIlII, 10 + llllllllllllllIlIIIlIIlIIlllIlll, -11, 10 + llllllllllllllIlIIIlIIlIIlllIllI, WeightedRandomChestContent.func_177629_a(DesertPyramid.itemsToGenerateInTemple, Items.enchanted_book.getRandomEnchantedBook(llllllllllllllIlIIIlIIlIlIIIIlII)), 2 + llllllllllllllIlIIIlIIlIlIIIIlII.nextInt(5));
                }
            }
            return true;
        }
    }
}
