package net.minecraft.world.gen.structure;

import com.google.common.collect.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;

public class StructureNetherBridgePieces
{
    private static final /* synthetic */ PieceWeight[] primaryComponents;
    private static final /* synthetic */ PieceWeight[] secondaryComponents;
    
    private static Piece func_175887_b(final PieceWeight llllllllllllllIlIllIlIlIlllIIllI, final List llllllllllllllIlIllIlIlIlllIIlIl, final Random llllllllllllllIlIllIlIlIllIlIlII, final int llllllllllllllIlIllIlIlIllIlIIlI, final int llllllllllllllIlIllIlIlIllIlIIIl, final int llllllllllllllIlIllIlIlIlllIIIII, final EnumFacing llllllllllllllIlIllIlIlIllIIlllI, final int llllllllllllllIlIllIlIlIllIllllI) {
        final Class llllllllllllllIlIllIlIlIllIlllII = llllllllllllllIlIllIlIlIlllIIllI.weightClass;
        Object llllllllllllllIlIllIlIlIllIllIlI = null;
        if (llllllllllllllIlIllIlIlIllIlllII == Straight.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Straight.func_175882_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Crossing3.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Crossing3.func_175885_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Crossing.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Crossing.func_175873_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Stairs.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Stairs.func_175872_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIllllI, llllllllllllllIlIllIlIlIllIIlllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Throne.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Throne.func_175874_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIllllI, llllllllllllllIlIllIlIlIllIIlllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Entrance.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Entrance.func_175881_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Corridor5.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Corridor5.func_175877_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Corridor2.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Corridor2.func_175876_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Corridor.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Corridor.func_175879_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Corridor3.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Corridor3.func_175883_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Corridor4.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Corridor4.func_175880_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == Crossing2.class) {
            llllllllllllllIlIllIlIlIllIllIlI = Crossing2.func_175878_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        else if (llllllllllllllIlIllIlIlIllIlllII == NetherStalkRoom.class) {
            llllllllllllllIlIllIlIlIllIllIlI = NetherStalkRoom.func_175875_a(llllllllllllllIlIllIlIlIlllIIlIl, llllllllllllllIlIllIlIlIllIlIlII, llllllllllllllIlIllIlIlIllIlIIlI, llllllllllllllIlIllIlIlIllIlIIIl, llllllllllllllIlIllIlIlIlllIIIII, llllllllllllllIlIllIlIlIllIIlllI, llllllllllllllIlIllIlIlIllIllllI);
        }
        return (Piece)llllllllllllllIlIllIlIlIllIllIlI;
    }
    
    public static void registerNetherFortressPieces() {
        MapGenStructureIO.registerStructureComponent(Crossing3.class, "NeBCr");
        MapGenStructureIO.registerStructureComponent(End.class, "NeBEF");
        MapGenStructureIO.registerStructureComponent(Straight.class, "NeBS");
        MapGenStructureIO.registerStructureComponent(Corridor3.class, "NeCCS");
        MapGenStructureIO.registerStructureComponent(Corridor4.class, "NeCTB");
        MapGenStructureIO.registerStructureComponent(Entrance.class, "NeCE");
        MapGenStructureIO.registerStructureComponent(Crossing2.class, "NeSCSC");
        MapGenStructureIO.registerStructureComponent(Corridor.class, "NeSCLT");
        MapGenStructureIO.registerStructureComponent(Corridor5.class, "NeSC");
        MapGenStructureIO.registerStructureComponent(Corridor2.class, "NeSCRT");
        MapGenStructureIO.registerStructureComponent(NetherStalkRoom.class, "NeCSR");
        MapGenStructureIO.registerStructureComponent(Throne.class, "NeMT");
        MapGenStructureIO.registerStructureComponent(Crossing.class, "NeRC");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "NeSR");
        MapGenStructureIO.registerStructureComponent(Start.class, "NeStart");
    }
    
    static {
        __OBFID = "CL_00000453";
        primaryComponents = new PieceWeight[] { new PieceWeight(Straight.class, 30, 0, true), new PieceWeight(Crossing3.class, 10, 4), new PieceWeight(Crossing.class, 10, 4), new PieceWeight(Stairs.class, 10, 3), new PieceWeight(Throne.class, 5, 2), new PieceWeight(Entrance.class, 5, 1) };
        secondaryComponents = new PieceWeight[] { new PieceWeight(Corridor5.class, 25, 0, true), new PieceWeight(Crossing2.class, 15, 5), new PieceWeight(Corridor2.class, 5, 10), new PieceWeight(Corridor.class, 5, 10), new PieceWeight(Corridor3.class, 10, 3, true), new PieceWeight(Corridor4.class, 7, 2), new PieceWeight(NetherStalkRoom.class, 5, 2) };
    }
    
    public static class Start extends Crossing3
    {
        public /* synthetic */ List primaryWeights;
        public /* synthetic */ List secondaryWeights;
        public /* synthetic */ List field_74967_d;
        public /* synthetic */ PieceWeight theNetherBridgePieceWeight;
        
        public Start() {
            this.field_74967_d = Lists.newArrayList();
        }
        
        static {
            __OBFID = "CL_00000470";
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIlllllIIlIlllllIll) {
            super.readStructureFromNBT(llllllllllllllIlllllIIlIlllllIll);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIlllllIIlIllllIlll) {
            super.writeStructureToNBT(llllllllllllllIlllllIIlIllllIlll);
        }
        
        public Start(final Random llllllllllllllIlllllIIllIIIIIlll, final int llllllllllllllIlllllIIllIIIIIllI, final int llllllllllllllIlllllIIllIIIIIlIl) {
            super(llllllllllllllIlllllIIllIIIIIlll, llllllllllllllIlllllIIllIIIIIllI, llllllllllllllIlllllIIllIIIIIlIl);
            this.field_74967_d = Lists.newArrayList();
            this.primaryWeights = Lists.newArrayList();
            for (final PieceWeight llllllllllllllIlllllIIllIIIIlIlI : StructureNetherBridgePieces.primaryComponents) {
                llllllllllllllIlllllIIllIIIIlIlI.field_78827_c = 0;
                this.primaryWeights.add(llllllllllllllIlllllIIllIIIIlIlI);
            }
            this.secondaryWeights = Lists.newArrayList();
            for (final PieceWeight llllllllllllllIlllllIIllIIIIlIIl : StructureNetherBridgePieces.secondaryComponents) {
                llllllllllllllIlllllIIllIIIIlIIl.field_78827_c = 0;
                this.secondaryWeights.add(llllllllllllllIlllllIIllIIIIlIIl);
            }
        }
    }
    
    static class PieceWeight
    {
        public /* synthetic */ Class weightClass;
        public /* synthetic */ boolean field_78825_e;
        public /* synthetic */ int field_78827_c;
        public final /* synthetic */ int field_78826_b;
        public /* synthetic */ int field_78824_d;
        
        public boolean func_78823_a() {
            return this.field_78824_d == 0 || this.field_78827_c < this.field_78824_d;
        }
        
        static {
            __OBFID = "CL_00000467";
        }
        
        public PieceWeight(final Class llIlIllIIIIlllI, final int llIlIllIIIIlIII, final int llIlIllIIIIllII, final boolean llIlIllIIIIlIll) {
            this.weightClass = llIlIllIIIIlllI;
            this.field_78826_b = llIlIllIIIIlIII;
            this.field_78824_d = llIlIllIIIIllII;
            this.field_78825_e = llIlIllIIIIlIll;
        }
        
        public boolean func_78822_a(final int llIlIlIllllIlll) {
            return this.field_78824_d == 0 || this.field_78827_c < this.field_78824_d;
        }
        
        public PieceWeight(final Class llIlIlIllllllII, final int llIlIlIlllllIll, final int llIlIlIlllllllI) {
            this(llIlIlIllllllII, llIlIlIlllllIll, llIlIlIlllllllI, false);
        }
    }
    
    public static class Crossing3 extends Piece
    {
        public static Crossing3 func_175885_a(final List lllllllllllllllIllIIlIIIllIllIlI, final Random lllllllllllllllIllIIlIIIllIllIIl, final int lllllllllllllllIllIIlIIIllIllIII, final int lllllllllllllllIllIIlIIIllIlllll, final int lllllllllllllllIllIIlIIIllIllllI, final EnumFacing lllllllllllllllIllIIlIIIllIlllIl, final int lllllllllllllllIllIIlIIIllIlIlII) {
            final StructureBoundingBox lllllllllllllllIllIIlIIIllIllIll = StructureBoundingBox.func_175897_a(lllllllllllllllIllIIlIIIllIllIII, lllllllllllllllIllIIlIIIllIlllll, lllllllllllllllIllIIlIIIllIllllI, -8, -3, 0, 19, 10, 19, lllllllllllllllIllIIlIIIllIlllIl);
            return (Piece.isAboveGround(lllllllllllllllIllIIlIIIllIllIll) && StructureComponent.findIntersecting(lllllllllllllllIllIIlIIIllIllIlI, lllllllllllllllIllIIlIIIllIllIll) == null) ? new Crossing3(lllllllllllllllIllIIlIIIllIlIlII, lllllllllllllllIllIIlIIIllIllIIl, lllllllllllllllIllIIlIIIllIllIll, lllllllllllllllIllIIlIIIllIlllIl) : null;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIllIIlIIIlllIllIl, final List lllllllllllllllIllIIlIIIlllIllII, final Random lllllllllllllllIllIIlIIIlllIlIll) {
            this.getNextComponentNormal((Start)lllllllllllllllIllIIlIIIlllIllIl, lllllllllllllllIllIIlIIIlllIllII, lllllllllllllllIllIIlIIIlllIlIll, 8, 3, false);
            this.getNextComponentX((Start)lllllllllllllllIllIIlIIIlllIllIl, lllllllllllllllIllIIlIIIlllIllII, lllllllllllllllIllIIlIIIlllIlIll, 3, 8, false);
            this.getNextComponentZ((Start)lllllllllllllllIllIIlIIIlllIllIl, lllllllllllllllIllIIlIIIlllIllII, lllllllllllllllIllIIlIIIlllIlIll, 3, 8, false);
        }
        
        public Crossing3(final int lllllllllllllllIllIIlIIlIIIIlIlI, final Random lllllllllllllllIllIIlIIlIIIIlIIl, final StructureBoundingBox lllllllllllllllIllIIlIIlIIIIIlII, final EnumFacing lllllllllllllllIllIIlIIlIIIIIlll) {
            super(lllllllllllllllIllIIlIIlIIIIlIlI);
            this.coordBaseMode = lllllllllllllllIllIIlIIlIIIIIlll;
            this.boundingBox = lllllllllllllllIllIIlIIlIIIIIlII;
        }
        
        protected Crossing3(final Random lllllllllllllllIllIIlIIIllllllIl, final int lllllllllllllllIllIIlIIIlllllIII, final int lllllllllllllllIllIIlIIIllllIlll) {
            super(0);
            this.coordBaseMode = EnumFacing.Plane.HORIZONTAL.random(lllllllllllllllIllIIlIIIllllllIl);
            switch (StructureNetherBridgePieces.SwitchEnumFacing.field_175888_a[this.coordBaseMode.ordinal()]) {
                case 1:
                case 2: {
                    this.boundingBox = new StructureBoundingBox(lllllllllllllllIllIIlIIIlllllIII, 64, lllllllllllllllIllIIlIIIllllIlll, lllllllllllllllIllIIlIIIlllllIII + 19 - 1, 73, lllllllllllllllIllIIlIIIllllIlll + 19 - 1);
                    break;
                }
                default: {
                    this.boundingBox = new StructureBoundingBox(lllllllllllllllIllIIlIIIlllllIII, 64, lllllllllllllllIllIIlIIIllllIlll, lllllllllllllllIllIIlIIIlllllIII + 19 - 1, 73, lllllllllllllllIllIIlIIIllllIlll + 19 - 1);
                    break;
                }
            }
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIllIIlIIIllIIllII, final Random lllllllllllllllIllIIlIIIllIIlIll, final StructureBoundingBox lllllllllllllllIllIIlIIIllIIlIlI) {
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 7, 3, 0, 11, 4, 18, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 0, 3, 7, 18, 4, 11, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 8, 5, 0, 10, 7, 18, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 0, 5, 8, 18, 7, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 7, 5, 0, 7, 5, 7, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 7, 5, 11, 7, 5, 18, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 11, 5, 0, 11, 5, 7, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 11, 5, 11, 11, 5, 18, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 0, 5, 7, 7, 5, 7, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 11, 5, 7, 18, 5, 7, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 0, 5, 11, 7, 5, 11, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 11, 5, 11, 18, 5, 11, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 7, 2, 0, 11, 2, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 7, 2, 13, 11, 2, 18, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 7, 0, 0, 11, 1, 3, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 7, 0, 15, 11, 1, 18, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (int lllllllllllllllIllIIlIIIllIIlIIl = 7; lllllllllllllllIllIIlIIIllIIlIIl <= 11; ++lllllllllllllllIllIIlIIIllIIlIIl) {
                for (int lllllllllllllllIllIIlIIIllIIlIII = 0; lllllllllllllllIllIIlIIIllIIlIII <= 2; ++lllllllllllllllIllIIlIIIllIIlIII) {
                    this.func_175808_b(lllllllllllllllIllIIlIIIllIIllII, Blocks.nether_brick.getDefaultState(), lllllllllllllllIllIIlIIIllIIlIIl, -1, lllllllllllllllIllIIlIIIllIIlIII, lllllllllllllllIllIIlIIIllIIlIlI);
                    this.func_175808_b(lllllllllllllllIllIIlIIIllIIllII, Blocks.nether_brick.getDefaultState(), lllllllllllllllIllIIlIIIllIIlIIl, -1, 18 - lllllllllllllllIllIIlIIIllIIlIII, lllllllllllllllIllIIlIIIllIIlIlI);
                }
            }
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 0, 2, 7, 5, 2, 11, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 13, 2, 7, 18, 2, 11, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 0, 0, 7, 3, 1, 11, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlIIIllIIllII, lllllllllllllllIllIIlIIIllIIlIlI, 15, 0, 7, 18, 1, 11, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (int lllllllllllllllIllIIlIIIllIIlIIl = 0; lllllllllllllllIllIIlIIIllIIlIIl <= 2; ++lllllllllllllllIllIIlIIIllIIlIIl) {
                for (int lllllllllllllllIllIIlIIIllIIIlll = 7; lllllllllllllllIllIIlIIIllIIIlll <= 11; ++lllllllllllllllIllIIlIIIllIIIlll) {
                    this.func_175808_b(lllllllllllllllIllIIlIIIllIIllII, Blocks.nether_brick.getDefaultState(), lllllllllllllllIllIIlIIIllIIlIIl, -1, lllllllllllllllIllIIlIIIllIIIlll, lllllllllllllllIllIIlIIIllIIlIlI);
                    this.func_175808_b(lllllllllllllllIllIIlIIIllIIllII, Blocks.nether_brick.getDefaultState(), 18 - lllllllllllllllIllIIlIIIllIIlIIl, -1, lllllllllllllllIllIIlIIIllIIIlll, lllllllllllllllIllIIlIIIllIIlIlI);
                }
            }
            return true;
        }
        
        public Crossing3() {
        }
        
        static {
            __OBFID = "CL_00000454";
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_175888_a;
        
        static {
            __OBFID = "CL_00001997";
            field_175888_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_175888_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_175888_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_175888_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_175888_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
    
    abstract static class Piece extends StructureComponent
    {
        protected static final /* synthetic */ List field_111019_a;
        
        public Piece() {
        }
        
        protected StructureComponent getNextComponentX(final Start lllllllllllllllIIlIIlIllllIllIII, final List lllllllllllllllIIlIIlIllllIlIlll, final Random lllllllllllllllIIlIIlIllllIIllll, final int lllllllllllllllIIlIIlIllllIIlllI, final int lllllllllllllllIIlIIlIllllIIllIl, final boolean lllllllllllllllIIlIIlIllllIlIIll) {
            if (this.coordBaseMode != null) {
                switch (StructureNetherBridgePieces.SwitchEnumFacing.field_175888_a[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIllllIllIII, lllllllllllllllIIlIIlIllllIlIlll, lllllllllllllllIIlIIlIllllIIllll, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllllIIlIIlIllllIIlllI, this.boundingBox.minZ + lllllllllllllllIIlIIlIllllIIllIl, EnumFacing.WEST, this.getComponentType(), lllllllllllllllIIlIIlIllllIlIIll);
                    }
                    case 2: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIllllIllIII, lllllllllllllllIIlIIlIllllIlIlll, lllllllllllllllIIlIIlIllllIIllll, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllllIIlIIlIllllIIlllI, this.boundingBox.minZ + lllllllllllllllIIlIIlIllllIIllIl, EnumFacing.WEST, this.getComponentType(), lllllllllllllllIIlIIlIllllIlIIll);
                    }
                    case 3: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIllllIllIII, lllllllllllllllIIlIIlIllllIlIlll, lllllllllllllllIIlIIlIllllIIllll, this.boundingBox.minX + lllllllllllllllIIlIIlIllllIIllIl, this.boundingBox.minY + lllllllllllllllIIlIIlIllllIIlllI, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), lllllllllllllllIIlIIlIllllIlIIll);
                    }
                    case 4: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIllllIllIII, lllllllllllllllIIlIIlIllllIlIlll, lllllllllllllllIIlIIlIllllIIllll, this.boundingBox.minX + lllllllllllllllIIlIIlIllllIIllIl, this.boundingBox.minY + lllllllllllllllIIlIIlIllllIIlllI, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), lllllllllllllllIIlIIlIllllIlIIll);
                    }
                }
            }
            return null;
        }
        
        protected Piece(final int lllllllllllllllIIlIIllIIIllIIIIl) {
            super(lllllllllllllllIIlIIllIIIllIIIIl);
        }
        
        private Piece func_175871_a(final Start lllllllllllllllIIlIIllIIIIlllIlI, final List lllllllllllllllIIlIIllIIIIlllIIl, final List lllllllllllllllIIlIIllIIIIlIIlll, final Random lllllllllllllllIIlIIllIIIIlIIllI, final int lllllllllllllllIIlIIllIIIIllIllI, final int lllllllllllllllIIlIIllIIIIllIlIl, final int lllllllllllllllIIlIIllIIIIllIlII, final EnumFacing lllllllllllllllIIlIIllIIIIllIIll, final int lllllllllllllllIIlIIllIIIIllIIlI) {
            final int lllllllllllllllIIlIIllIIIIllIIIl = this.getTotalWeight(lllllllllllllllIIlIIllIIIIlllIIl);
            final boolean lllllllllllllllIIlIIllIIIIllIIII = lllllllllllllllIIlIIllIIIIllIIIl > 0 && lllllllllllllllIIlIIllIIIIllIIlI <= 30;
            int lllllllllllllllIIlIIllIIIIlIllll = 0;
            while (lllllllllllllllIIlIIllIIIIlIllll < 5 && lllllllllllllllIIlIIllIIIIllIIII) {
                ++lllllllllllllllIIlIIllIIIIlIllll;
                int lllllllllllllllIIlIIllIIIIlIlllI = lllllllllllllllIIlIIllIIIIlIIllI.nextInt(lllllllllllllllIIlIIllIIIIllIIIl);
                for (final PieceWeight lllllllllllllllIIlIIllIIIIlIllII : lllllllllllllllIIlIIllIIIIlllIIl) {
                    lllllllllllllllIIlIIllIIIIlIlllI -= lllllllllllllllIIlIIllIIIIlIllII.field_78826_b;
                    if (lllllllllllllllIIlIIllIIIIlIlllI < 0) {
                        if (!lllllllllllllllIIlIIllIIIIlIllII.func_78822_a(lllllllllllllllIIlIIllIIIIllIIlI)) {
                            break;
                        }
                        if (lllllllllllllllIIlIIllIIIIlIllII == lllllllllllllllIIlIIllIIIIlllIlI.theNetherBridgePieceWeight && !lllllllllllllllIIlIIllIIIIlIllII.field_78825_e) {
                            break;
                        }
                        final Piece lllllllllllllllIIlIIllIIIIlIlIll = func_175887_b(lllllllllllllllIIlIIllIIIIlIllII, lllllllllllllllIIlIIllIIIIlIIlll, lllllllllllllllIIlIIllIIIIlIIllI, lllllllllllllllIIlIIllIIIIllIllI, lllllllllllllllIIlIIllIIIIllIlIl, lllllllllllllllIIlIIllIIIIllIlII, lllllllllllllllIIlIIllIIIIllIIll, lllllllllllllllIIlIIllIIIIllIIlI);
                        if (lllllllllllllllIIlIIllIIIIlIlIll != null) {
                            final PieceWeight pieceWeight = lllllllllllllllIIlIIllIIIIlIllII;
                            ++pieceWeight.field_78827_c;
                            lllllllllllllllIIlIIllIIIIlllIlI.theNetherBridgePieceWeight = lllllllllllllllIIlIIllIIIIlIllII;
                            if (!lllllllllllllllIIlIIllIIIIlIllII.func_78823_a()) {
                                lllllllllllllllIIlIIllIIIIlllIIl.remove(lllllllllllllllIIlIIllIIIIlIllII);
                            }
                            return lllllllllllllllIIlIIllIIIIlIlIll;
                        }
                        continue;
                    }
                }
            }
            return End.func_175884_a(lllllllllllllllIIlIIllIIIIlIIlll, lllllllllllllllIIlIIllIIIIlIIllI, lllllllllllllllIIlIIllIIIIllIllI, lllllllllllllllIIlIIllIIIIllIlIl, lllllllllllllllIIlIIllIIIIllIlII, lllllllllllllllIIlIIllIIIIllIIll, lllllllllllllllIIlIIllIIIIllIIlI);
        }
        
        protected static boolean isAboveGround(final StructureBoundingBox lllllllllllllllIIlIIlIlllIllIlIl) {
            return lllllllllllllllIIlIIlIlllIllIlIl != null && lllllllllllllllIIlIIlIlllIllIlIl.minY > 10;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIIlIIllIIIlIlllIl) {
        }
        
        protected StructureComponent getNextComponentNormal(final Start lllllllllllllllIIlIIlIlllllIllIl, final List lllllllllllllllIIlIIlIlllllIIlIl, final Random lllllllllllllllIIlIIlIlllllIIlII, final int lllllllllllllllIIlIIlIlllllIlIlI, final int lllllllllllllllIIlIIlIlllllIlIIl, final boolean lllllllllllllllIIlIIlIlllllIIIIl) {
            if (this.coordBaseMode != null) {
                switch (StructureNetherBridgePieces.SwitchEnumFacing.field_175888_a[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIlllllIllIl, lllllllllllllllIIlIIlIlllllIIlIl, lllllllllllllllIIlIIlIlllllIIlII, this.boundingBox.minX + lllllllllllllllIIlIIlIlllllIlIlI, this.boundingBox.minY + lllllllllllllllIIlIIlIlllllIlIIl, this.boundingBox.minZ - 1, this.coordBaseMode, this.getComponentType(), lllllllllllllllIIlIIlIlllllIIIIl);
                    }
                    case 2: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIlllllIllIl, lllllllllllllllIIlIIlIlllllIIlIl, lllllllllllllllIIlIIlIlllllIIlII, this.boundingBox.minX + lllllllllllllllIIlIIlIlllllIlIlI, this.boundingBox.minY + lllllllllllllllIIlIIlIlllllIlIIl, this.boundingBox.maxZ + 1, this.coordBaseMode, this.getComponentType(), lllllllllllllllIIlIIlIlllllIIIIl);
                    }
                    case 3: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIlllllIllIl, lllllllllllllllIIlIIlIlllllIIlIl, lllllllllllllllIIlIIlIlllllIIlII, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllllIIlIIlIlllllIlIIl, this.boundingBox.minZ + lllllllllllllllIIlIIlIlllllIlIlI, this.coordBaseMode, this.getComponentType(), lllllllllllllllIIlIIlIlllllIIIIl);
                    }
                    case 4: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIlllllIllIl, lllllllllllllllIIlIIlIlllllIIlIl, lllllllllllllllIIlIIlIlllllIIlII, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllllIIlIIlIlllllIlIIl, this.boundingBox.minZ + lllllllllllllllIIlIIlIlllllIlIlI, this.coordBaseMode, this.getComponentType(), lllllllllllllllIIlIIlIlllllIIIIl);
                    }
                }
            }
            return null;
        }
        
        static {
            __OBFID = "CL_00000466";
            field_111019_a = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 5), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 5), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 15), new WeightedRandomChestContent(Items.golden_sword, 0, 1, 1, 5), new WeightedRandomChestContent(Items.golden_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent(Items.flint_and_steel, 0, 1, 1, 5), new WeightedRandomChestContent(Items.nether_wart, 0, 3, 7, 5), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 10), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 8), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 3), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.obsidian), 0, 2, 4, 2) });
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIIlIIllIIIlIlllll) {
        }
        
        private int getTotalWeight(final List lllllllllllllllIIlIIllIIIlIlIIIl) {
            boolean lllllllllllllllIIlIIllIIIlIlIlIl = false;
            int lllllllllllllllIIlIIllIIIlIlIlII = 0;
            for (final PieceWeight lllllllllllllllIIlIIllIIIlIlIIll : lllllllllllllllIIlIIllIIIlIlIIIl) {
                if (lllllllllllllllIIlIIllIIIlIlIIll.field_78824_d > 0 && lllllllllllllllIIlIIllIIIlIlIIll.field_78827_c < lllllllllllllllIIlIIllIIIlIlIIll.field_78824_d) {
                    lllllllllllllllIIlIIllIIIlIlIlIl = true;
                }
                lllllllllllllllIIlIIllIIIlIlIlII += lllllllllllllllIIlIIllIIIlIlIIll.field_78826_b;
            }
            return lllllllllllllllIIlIIllIIIlIlIlIl ? lllllllllllllllIIlIIllIIIlIlIlII : -1;
        }
        
        private StructureComponent func_175870_a(final Start lllllllllllllllIIlIIllIIIIIIIIII, final List lllllllllllllllIIlIIllIIIIIIlIll, final Random lllllllllllllllIIlIIllIIIIIIlIlI, final int lllllllllllllllIIlIIlIllllllllIl, final int lllllllllllllllIIlIIllIIIIIIlIII, final int lllllllllllllllIIlIIlIlllllllIll, final EnumFacing lllllllllllllllIIlIIlIlllllllIlI, final int lllllllllllllllIIlIIlIlllllllIIl, final boolean lllllllllllllllIIlIIllIIIIIIIlII) {
            if (Math.abs(lllllllllllllllIIlIIlIllllllllIl - lllllllllllllllIIlIIllIIIIIIIIII.getBoundingBox().minX) <= 112 && Math.abs(lllllllllllllllIIlIIlIlllllllIll - lllllllllllllllIIlIIllIIIIIIIIII.getBoundingBox().minZ) <= 112) {
                List lllllllllllllllIIlIIllIIIIIIIIll = lllllllllllllllIIlIIllIIIIIIIIII.primaryWeights;
                if (lllllllllllllllIIlIIllIIIIIIIlII) {
                    lllllllllllllllIIlIIllIIIIIIIIll = lllllllllllllllIIlIIllIIIIIIIIII.secondaryWeights;
                }
                final Piece lllllllllllllllIIlIIllIIIIIIIIlI = this.func_175871_a(lllllllllllllllIIlIIllIIIIIIIIII, lllllllllllllllIIlIIllIIIIIIIIll, lllllllllllllllIIlIIllIIIIIIlIll, lllllllllllllllIIlIIllIIIIIIlIlI, lllllllllllllllIIlIIlIllllllllIl, lllllllllllllllIIlIIllIIIIIIlIII, lllllllllllllllIIlIIlIlllllllIll, lllllllllllllllIIlIIlIlllllllIlI, lllllllllllllllIIlIIlIlllllllIIl + 1);
                if (lllllllllllllllIIlIIllIIIIIIIIlI != null) {
                    lllllllllllllllIIlIIllIIIIIIlIll.add(lllllllllllllllIIlIIllIIIIIIIIlI);
                    lllllllllllllllIIlIIllIIIIIIIIII.field_74967_d.add(lllllllllllllllIIlIIllIIIIIIIIlI);
                }
                return lllllllllllllllIIlIIllIIIIIIIIlI;
            }
            return End.func_175884_a(lllllllllllllllIIlIIllIIIIIIlIll, lllllllllllllllIIlIIllIIIIIIlIlI, lllllllllllllllIIlIIlIllllllllIl, lllllllllllllllIIlIIllIIIIIIlIII, lllllllllllllllIIlIIlIlllllllIll, lllllllllllllllIIlIIlIlllllllIlI, lllllllllllllllIIlIIlIlllllllIIl);
        }
        
        protected StructureComponent getNextComponentZ(final Start lllllllllllllllIIlIIlIlllIllllII, final List lllllllllllllllIIlIIlIllllIIIIlI, final Random lllllllllllllllIIlIIlIlllIlllIlI, final int lllllllllllllllIIlIIlIllllIIIIII, final int lllllllllllllllIIlIIlIlllIllllll, final boolean lllllllllllllllIIlIIlIlllIllIlll) {
            if (this.coordBaseMode != null) {
                switch (StructureNetherBridgePieces.SwitchEnumFacing.field_175888_a[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIlllIllllII, lllllllllllllllIIlIIlIllllIIIIlI, lllllllllllllllIIlIIlIlllIlllIlI, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllllIIlIIlIllllIIIIII, this.boundingBox.minZ + lllllllllllllllIIlIIlIlllIllllll, EnumFacing.EAST, this.getComponentType(), lllllllllllllllIIlIIlIlllIllIlll);
                    }
                    case 2: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIlllIllllII, lllllllllllllllIIlIIlIllllIIIIlI, lllllllllllllllIIlIIlIlllIlllIlI, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllllIIlIIlIllllIIIIII, this.boundingBox.minZ + lllllllllllllllIIlIIlIlllIllllll, EnumFacing.EAST, this.getComponentType(), lllllllllllllllIIlIIlIlllIllIlll);
                    }
                    case 3: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIlllIllllII, lllllllllllllllIIlIIlIllllIIIIlI, lllllllllllllllIIlIIlIlllIlllIlI, this.boundingBox.minX + lllllllllllllllIIlIIlIlllIllllll, this.boundingBox.minY + lllllllllllllllIIlIIlIllllIIIIII, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), lllllllllllllllIIlIIlIlllIllIlll);
                    }
                    case 4: {
                        return this.func_175870_a(lllllllllllllllIIlIIlIlllIllllII, lllllllllllllllIIlIIlIllllIIIIlI, lllllllllllllllIIlIIlIlllIlllIlI, this.boundingBox.minX + lllllllllllllllIIlIIlIlllIllllll, this.boundingBox.minY + lllllllllllllllIIlIIlIllllIIIIII, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), lllllllllllllllIIlIIlIlllIllIlll);
                    }
                }
            }
            return null;
        }
    }
    
    public static class End extends Piece
    {
        private /* synthetic */ int fillSeed;
        
        static {
            __OBFID = "CL_00000455";
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIlllIIIllIlIIIIIll) {
            super.writeStructureToNBT(llllllllllllllIlllIIIllIlIIIIIll);
            llllllllllllllIlllIIIllIlIIIIIll.setInteger("Seed", this.fillSeed);
        }
        
        public End() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIlllIIIllIlIIIIlll) {
            super.readStructureFromNBT(llllllllllllllIlllIIIllIlIIIIlll);
            this.fillSeed = llllllllllllllIlllIIIllIlIIIIlll.getInteger("Seed");
        }
        
        public End(final int llllllllllllllIlllIIIllIlIlIlIII, final Random llllllllllllllIlllIIIllIlIlIIlll, final StructureBoundingBox llllllllllllllIlllIIIllIlIlIlIll, final EnumFacing llllllllllllllIlllIIIllIlIlIlIlI) {
            super(llllllllllllllIlllIIIllIlIlIlIII);
            this.coordBaseMode = llllllllllllllIlllIIIllIlIlIlIlI;
            this.boundingBox = llllllllllllllIlllIIIllIlIlIlIll;
            this.fillSeed = llllllllllllllIlllIIIllIlIlIIlll.nextInt();
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlllIIIllIIllIllIl, final Random llllllllllllllIlllIIIllIIlllIlll, final StructureBoundingBox llllllllllllllIlllIIIllIIllIllII) {
            final Random llllllllllllllIlllIIIllIIlllIlIl = new Random(this.fillSeed);
            for (int llllllllllllllIlllIIIllIIlllIlII = 0; llllllllllllllIlllIIIllIIlllIlII <= 4; ++llllllllllllllIlllIIIllIIlllIlII) {
                for (int llllllllllllllIlllIIIllIIlllIIll = 3; llllllllllllllIlllIIIllIIlllIIll <= 4; ++llllllllllllllIlllIIIllIIlllIIll) {
                    final int llllllllllllllIlllIIIllIIlllIIII = llllllllllllllIlllIIIllIIlllIlIl.nextInt(8);
                    this.func_175804_a(llllllllllllllIlllIIIllIIllIllIl, llllllllllllllIlllIIIllIIllIllII, llllllllllllllIlllIIIllIIlllIlII, llllllllllllllIlllIIIllIIlllIIll, 0, llllllllllllllIlllIIIllIIlllIlII, llllllllllllllIlllIIIllIIlllIIll, llllllllllllllIlllIIIllIIlllIIII, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
                }
            }
            int llllllllllllllIlllIIIllIIlllIlII = llllllllllllllIlllIIIllIIlllIlIl.nextInt(8);
            this.func_175804_a(llllllllllllllIlllIIIllIIllIllIl, llllllllllllllIlllIIIllIIllIllII, 0, 5, 0, 0, 5, llllllllllllllIlllIIIllIIlllIlII, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            llllllllllllllIlllIIIllIIlllIlII = llllllllllllllIlllIIIllIIlllIlIl.nextInt(8);
            this.func_175804_a(llllllllllllllIlllIIIllIIllIllIl, llllllllllllllIlllIIIllIIllIllII, 4, 5, 0, 4, 5, llllllllllllllIlllIIIllIIlllIlII, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (llllllllllllllIlllIIIllIIlllIlII = 0; llllllllllllllIlllIIIllIIlllIlII <= 4; ++llllllllllllllIlllIIIllIIlllIlII) {
                final int llllllllllllllIlllIIIllIIlllIIlI = llllllllllllllIlllIIIllIIlllIlIl.nextInt(5);
                this.func_175804_a(llllllllllllllIlllIIIllIIllIllIl, llllllllllllllIlllIIIllIIllIllII, llllllllllllllIlllIIIllIIlllIlII, 2, 0, llllllllllllllIlllIIIllIIlllIlII, 2, llllllllllllllIlllIIIllIIlllIIlI, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            }
            for (llllllllllllllIlllIIIllIIlllIlII = 0; llllllllllllllIlllIIIllIIlllIlII <= 4; ++llllllllllllllIlllIIIllIIlllIlII) {
                for (int llllllllllllllIlllIIIllIIlllIIIl = 0; llllllllllllllIlllIIIllIIlllIIIl <= 1; ++llllllllllllllIlllIIIllIIlllIIIl) {
                    final int llllllllllllllIlllIIIllIIllIllll = llllllllllllllIlllIIIllIIlllIlIl.nextInt(3);
                    this.func_175804_a(llllllllllllllIlllIIIllIIllIllIl, llllllllllllllIlllIIIllIIllIllII, llllllllllllllIlllIIIllIIlllIlII, llllllllllllllIlllIIIllIIlllIIIl, 0, llllllllllllllIlllIIIllIIlllIlII, llllllllllllllIlllIIIllIIlllIIIl, llllllllllllllIlllIIIllIIllIllll, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
                }
            }
            return true;
        }
        
        public static End func_175884_a(final List llllllllllllllIlllIIIllIlIIlIlII, final Random llllllllllllllIlllIIIllIlIIlIIll, final int llllllllllllllIlllIIIllIlIIlIIlI, final int llllllllllllllIlllIIIllIlIIlIIIl, final int llllllllllllllIlllIIIllIlIIlIIII, final EnumFacing llllllllllllllIlllIIIllIlIIlIlll, final int llllllllllllllIlllIIIllIlIIIlllI) {
            final StructureBoundingBox llllllllllllllIlllIIIllIlIIlIlIl = StructureBoundingBox.func_175897_a(llllllllllllllIlllIIIllIlIIlIIlI, llllllllllllllIlllIIIllIlIIlIIIl, llllllllllllllIlllIIIllIlIIlIIII, -1, -3, 0, 5, 10, 8, llllllllllllllIlllIIIllIlIIlIlll);
            return (Piece.isAboveGround(llllllllllllllIlllIIIllIlIIlIlIl) && StructureComponent.findIntersecting(llllllllllllllIlllIIIllIlIIlIlII, llllllllllllllIlllIIIllIlIIlIlIl) == null) ? new End(llllllllllllllIlllIIIllIlIIIlllI, llllllllllllllIlllIIIllIlIIlIIll, llllllllllllllIlllIIIllIlIIlIlIl, llllllllllllllIlllIIIllIlIIlIlll) : null;
        }
    }
    
    public static class Straight extends Piece
    {
        public static Straight func_175882_a(final List llllllllllllllIlIlIllllIIIIlIIII, final Random llllllllllllllIlIlIllllIIIIllIIl, final int llllllllllllllIlIlIllllIIIIllIII, final int llllllllllllllIlIlIllllIIIIlIlll, final int llllllllllllllIlIlIllllIIIIlIllI, final EnumFacing llllllllllllllIlIlIllllIIIIlIlII, final int llllllllllllllIlIlIllllIIIIIIllI) {
            final StructureBoundingBox llllllllllllllIlIlIllllIIIIlIIIl = StructureBoundingBox.func_175897_a(llllllllllllllIlIlIllllIIIIllIII, llllllllllllllIlIlIllllIIIIlIlll, llllllllllllllIlIlIllllIIIIlIllI, -1, -3, 0, 5, 10, 19, llllllllllllllIlIlIllllIIIIlIlII);
            return (Piece.isAboveGround(llllllllllllllIlIlIllllIIIIlIIIl) && StructureComponent.findIntersecting(llllllllllllllIlIlIllllIIIIlIIII, llllllllllllllIlIlIllllIIIIlIIIl) == null) ? new Straight(llllllllllllllIlIlIllllIIIIIIllI, llllllllllllllIlIlIllllIIIIllIIl, llllllllllllllIlIlIllllIIIIlIIIl, llllllllllllllIlIlIllllIIIIlIlII) : null;
        }
        
        public Straight(final int llllllllllllllIlIlIllllIIlIIllIl, final Random llllllllllllllIlIlIllllIIlIIllII, final StructureBoundingBox llllllllllllllIlIlIllllIIlIIIlll, final EnumFacing llllllllllllllIlIlIllllIIlIIlIlI) {
            super(llllllllllllllIlIlIllllIIlIIllIl);
            this.coordBaseMode = llllllllllllllIlIlIllllIIlIIlIlI;
            this.boundingBox = llllllllllllllIlIlIllllIIlIIIlll;
        }
        
        public Straight() {
        }
        
        static {
            __OBFID = "CL_00000456";
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIlIlllIllllllIII, final Random llllllllllllllIlIlIlllIlllllllIl, final StructureBoundingBox llllllllllllllIlIlIlllIlllllllII) {
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 0, 3, 0, 4, 4, 18, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 1, 5, 0, 3, 7, 18, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 0, 5, 0, 0, 5, 18, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 4, 5, 0, 4, 5, 18, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 0, 2, 0, 4, 2, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 0, 2, 13, 4, 2, 18, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 0, 0, 0, 4, 1, 3, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 0, 0, 15, 4, 1, 18, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (int llllllllllllllIlIlIlllIllllllIll = 0; llllllllllllllIlIlIlllIllllllIll <= 4; ++llllllllllllllIlIlIlllIllllllIll) {
                for (int llllllllllllllIlIlIlllIllllllIlI = 0; llllllllllllllIlIlIlllIllllllIlI <= 2; ++llllllllllllllIlIlIlllIllllllIlI) {
                    this.func_175808_b(llllllllllllllIlIlIlllIllllllIII, Blocks.nether_brick.getDefaultState(), llllllllllllllIlIlIlllIllllllIll, -1, llllllllllllllIlIlIlllIllllllIlI, llllllllllllllIlIlIlllIlllllllII);
                    this.func_175808_b(llllllllllllllIlIlIlllIllllllIII, Blocks.nether_brick.getDefaultState(), llllllllllllllIlIlIlllIllllllIll, -1, 18 - llllllllllllllIlIlIlllIllllllIlI, llllllllllllllIlIlIlllIlllllllII);
                }
            }
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 0, 1, 1, 0, 4, 1, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 0, 3, 4, 0, 4, 4, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 0, 3, 14, 0, 4, 14, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 0, 1, 17, 0, 4, 17, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 4, 1, 1, 4, 4, 1, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 4, 3, 4, 4, 4, 4, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 4, 3, 14, 4, 4, 14, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIlIlllIllllllIII, llllllllllllllIlIlIlllIlllllllII, 4, 1, 17, 4, 4, 17, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIlIlIllllIIIllIIII, final List llllllllllllllIlIlIllllIIIllIlIl, final Random llllllllllllllIlIlIllllIIIllIIll) {
            this.getNextComponentNormal((Start)llllllllllllllIlIlIllllIIIllIIII, llllllllllllllIlIlIllllIIIllIlIl, llllllllllllllIlIlIllllIIIllIIll, 1, 3, false);
        }
    }
    
    public static class Corridor3 extends Piece
    {
        @Override
        public void buildComponent(final StructureComponent llllllllllllllllIlIIIIlIlIIlllII, final List llllllllllllllllIlIIIIlIlIIlllll, final Random llllllllllllllllIlIIIIlIlIIllllI) {
            this.getNextComponentNormal((Start)llllllllllllllllIlIIIIlIlIIlllII, llllllllllllllllIlIIIIlIlIIlllll, llllllllllllllllIlIIIIlIlIIllllI, 1, 0, true);
        }
        
        public Corridor3(final int llllllllllllllllIlIIIIlIlIlIllIl, final Random llllllllllllllllIlIIIIlIlIlIllII, final StructureBoundingBox llllllllllllllllIlIIIIlIlIlIIlll, final EnumFacing llllllllllllllllIlIIIIlIlIlIlIlI) {
            super(llllllllllllllllIlIIIIlIlIlIllIl);
            this.coordBaseMode = llllllllllllllllIlIIIIlIlIlIlIlI;
            this.boundingBox = llllllllllllllllIlIIIIlIlIlIIlll;
        }
        
        public static Corridor3 func_175883_a(final List llllllllllllllllIlIIIIlIlIIlIIIl, final Random llllllllllllllllIlIIIIlIlIIlIIII, final int llllllllllllllllIlIIIIlIlIIIIlll, final int llllllllllllllllIlIIIIlIlIIIIllI, final int llllllllllllllllIlIIIIlIlIIIIlIl, final EnumFacing llllllllllllllllIlIIIIlIlIIIllII, final int llllllllllllllllIlIIIIlIlIIIIIll) {
            final StructureBoundingBox llllllllllllllllIlIIIIlIlIIIlIlI = StructureBoundingBox.func_175897_a(llllllllllllllllIlIIIIlIlIIIIlll, llllllllllllllllIlIIIIlIlIIIIllI, llllllllllllllllIlIIIIlIlIIIIlIl, -1, -7, 0, 5, 14, 10, llllllllllllllllIlIIIIlIlIIIllII);
            return (Piece.isAboveGround(llllllllllllllllIlIIIIlIlIIIlIlI) && StructureComponent.findIntersecting(llllllllllllllllIlIIIIlIlIIlIIIl, llllllllllllllllIlIIIIlIlIIIlIlI) == null) ? new Corridor3(llllllllllllllllIlIIIIlIlIIIIIll, llllllllllllllllIlIIIIlIlIIlIIII, llllllllllllllllIlIIIIlIlIIIlIlI, llllllllllllllllIlIIIIlIlIIIllII) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIlIIIIlIIllIllIl, final Random llllllllllllllllIlIIIIlIIlllIllI, final StructureBoundingBox llllllllllllllllIlIIIIlIIlllIlIl) {
            final int llllllllllllllllIlIIIIlIIlllIlII = this.getMetadataWithOffset(Blocks.nether_brick_stairs, 2);
            for (int llllllllllllllllIlIIIIlIIlllIIll = 0; llllllllllllllllIlIIIIlIIlllIIll <= 9; ++llllllllllllllllIlIIIIlIIlllIIll) {
                final int llllllllllllllllIlIIIIlIIlllIIlI = Math.max(1, 7 - llllllllllllllllIlIIIIlIIlllIIll);
                final int llllllllllllllllIlIIIIlIIlllIIIl = Math.min(Math.max(llllllllllllllllIlIIIIlIIlllIIlI + 5, 14 - llllllllllllllllIlIIIIlIIlllIIll), 13);
                final int llllllllllllllllIlIIIIlIIlllIIII = llllllllllllllllIlIIIIlIIlllIIll;
                this.func_175804_a(llllllllllllllllIlIIIIlIIllIllIl, llllllllllllllllIlIIIIlIIlllIlIl, 0, 0, llllllllllllllllIlIIIIlIIlllIIll, 4, llllllllllllllllIlIIIIlIIlllIIlI, llllllllllllllllIlIIIIlIIlllIIll, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
                this.func_175804_a(llllllllllllllllIlIIIIlIIllIllIl, llllllllllllllllIlIIIIlIIlllIlIl, 1, llllllllllllllllIlIIIIlIIlllIIlI + 1, llllllllllllllllIlIIIIlIIlllIIll, 3, llllllllllllllllIlIIIIlIIlllIIIl - 1, llllllllllllllllIlIIIIlIIlllIIll, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                if (llllllllllllllllIlIIIIlIIlllIIll <= 6) {
                    this.func_175811_a(llllllllllllllllIlIIIIlIIllIllIl, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIlIIIIlIIlllIlII), 1, llllllllllllllllIlIIIIlIIlllIIlI + 1, llllllllllllllllIlIIIIlIIlllIIll, llllllllllllllllIlIIIIlIIlllIlIl);
                    this.func_175811_a(llllllllllllllllIlIIIIlIIllIllIl, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIlIIIIlIIlllIlII), 2, llllllllllllllllIlIIIIlIIlllIIlI + 1, llllllllllllllllIlIIIIlIIlllIIll, llllllllllllllllIlIIIIlIIlllIlIl);
                    this.func_175811_a(llllllllllllllllIlIIIIlIIllIllIl, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIlIIIIlIIlllIlII), 3, llllllllllllllllIlIIIIlIIlllIIlI + 1, llllllllllllllllIlIIIIlIIlllIIll, llllllllllllllllIlIIIIlIIlllIlIl);
                }
                this.func_175804_a(llllllllllllllllIlIIIIlIIllIllIl, llllllllllllllllIlIIIIlIIlllIlIl, 0, llllllllllllllllIlIIIIlIIlllIIIl, llllllllllllllllIlIIIIlIIlllIIll, 4, llllllllllllllllIlIIIIlIIlllIIIl, llllllllllllllllIlIIIIlIIlllIIll, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
                this.func_175804_a(llllllllllllllllIlIIIIlIIllIllIl, llllllllllllllllIlIIIIlIIlllIlIl, 0, llllllllllllllllIlIIIIlIIlllIIlI + 1, llllllllllllllllIlIIIIlIIlllIIll, 0, llllllllllllllllIlIIIIlIIlllIIIl - 1, llllllllllllllllIlIIIIlIIlllIIll, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
                this.func_175804_a(llllllllllllllllIlIIIIlIIllIllIl, llllllllllllllllIlIIIIlIIlllIlIl, 4, llllllllllllllllIlIIIIlIIlllIIlI + 1, llllllllllllllllIlIIIIlIIlllIIll, 4, llllllllllllllllIlIIIIlIIlllIIIl - 1, llllllllllllllllIlIIIIlIIlllIIll, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
                if ((llllllllllllllllIlIIIIlIIlllIIll & 0x1) == 0x0) {
                    this.func_175804_a(llllllllllllllllIlIIIIlIIllIllIl, llllllllllllllllIlIIIIlIIlllIlIl, 0, llllllllllllllllIlIIIIlIIlllIIlI + 2, llllllllllllllllIlIIIIlIIlllIIll, 0, llllllllllllllllIlIIIIlIIlllIIlI + 3, llllllllllllllllIlIIIIlIIlllIIll, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                    this.func_175804_a(llllllllllllllllIlIIIIlIIllIllIl, llllllllllllllllIlIIIIlIIlllIlIl, 4, llllllllllllllllIlIIIIlIIlllIIlI + 2, llllllllllllllllIlIIIIlIIlllIIll, 4, llllllllllllllllIlIIIIlIIlllIIlI + 3, llllllllllllllllIlIIIIlIIlllIIll, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                }
                for (int llllllllllllllllIlIIIIlIIllIllll = 0; llllllllllllllllIlIIIIlIIllIllll <= 4; ++llllllllllllllllIlIIIIlIIllIllll) {
                    this.func_175808_b(llllllllllllllllIlIIIIlIIllIllIl, Blocks.nether_brick.getDefaultState(), llllllllllllllllIlIIIIlIIllIllll, -1, llllllllllllllllIlIIIIlIIlllIIII, llllllllllllllllIlIIIIlIIlllIlIl);
                }
            }
            return true;
        }
        
        static {
            __OBFID = "CL_00000457";
        }
        
        public Corridor3() {
        }
    }
    
    public static class NetherStalkRoom extends Piece
    {
        @Override
        public void buildComponent(final StructureComponent llllllllllllllllIIllIIllIlIlIlll, final List llllllllllllllllIIllIIllIlIllIlI, final Random llllllllllllllllIIllIIllIlIlIlIl) {
            this.getNextComponentNormal((Start)llllllllllllllllIIllIIllIlIlIlll, llllllllllllllllIIllIIllIlIllIlI, llllllllllllllllIIllIIllIlIlIlIl, 5, 3, true);
            this.getNextComponentNormal((Start)llllllllllllllllIIllIIllIlIlIlll, llllllllllllllllIIllIIllIlIllIlI, llllllllllllllllIIllIIllIlIlIlIl, 5, 11, true);
        }
        
        static {
            __OBFID = "CL_00000464";
        }
        
        public NetherStalkRoom() {
        }
        
        public static NetherStalkRoom func_175875_a(final List llllllllllllllllIIllIIllIlIIllII, final Random llllllllllllllllIIllIIllIlIIlIll, final int llllllllllllllllIIllIIllIlIIIIlI, final int llllllllllllllllIIllIIllIlIIlIIl, final int llllllllllllllllIIllIIllIlIIIIII, final EnumFacing llllllllllllllllIIllIIllIlIIIlll, final int llllllllllllllllIIllIIllIlIIIllI) {
            final StructureBoundingBox llllllllllllllllIIllIIllIlIIIlIl = StructureBoundingBox.func_175897_a(llllllllllllllllIIllIIllIlIIIIlI, llllllllllllllllIIllIIllIlIIlIIl, llllllllllllllllIIllIIllIlIIIIII, -5, -3, 0, 13, 14, 13, llllllllllllllllIIllIIllIlIIIlll);
            return (Piece.isAboveGround(llllllllllllllllIIllIIllIlIIIlIl) && StructureComponent.findIntersecting(llllllllllllllllIIllIIllIlIIllII, llllllllllllllllIIllIIllIlIIIlIl) == null) ? new NetherStalkRoom(llllllllllllllllIIllIIllIlIIIllI, llllllllllllllllIIllIIllIlIIlIll, llllllllllllllllIIllIIllIlIIIlIl, llllllllllllllllIIllIIllIlIIIlll) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIIllIIllIIllIIll, final Random llllllllllllllllIIllIIllIIllIIlI, final StructureBoundingBox llllllllllllllllIIllIIllIIlIIllI) {
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 0, 3, 0, 12, 4, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 0, 5, 0, 12, 13, 12, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 0, 5, 0, 1, 12, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 11, 5, 0, 12, 12, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 2, 5, 11, 4, 12, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 8, 5, 11, 10, 12, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 5, 9, 11, 7, 12, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 2, 5, 0, 4, 12, 1, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 8, 5, 0, 10, 12, 1, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 5, 9, 0, 7, 12, 1, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 2, 11, 2, 10, 12, 10, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (int llllllllllllllllIIllIIllIIllIIII = 1; llllllllllllllllIIllIIllIIllIIII <= 11; llllllllllllllllIIllIIllIIllIIII += 2) {
                this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, llllllllllllllllIIllIIllIIllIIII, 10, 0, llllllllllllllllIIllIIllIIllIIII, 11, 0, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, llllllllllllllllIIllIIllIIllIIII, 10, 12, llllllllllllllllIIllIIllIIllIIII, 11, 12, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 0, 10, llllllllllllllllIIllIIllIIllIIII, 0, 11, llllllllllllllllIIllIIllIIllIIII, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 12, 10, llllllllllllllllIIllIIllIIllIIII, 12, 11, llllllllllllllllIIllIIllIIllIIII, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick.getDefaultState(), llllllllllllllllIIllIIllIIllIIII, 13, 0, llllllllllllllllIIllIIllIIlIIllI);
                this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick.getDefaultState(), llllllllllllllllIIllIIllIIllIIII, 13, 12, llllllllllllllllIIllIIllIIlIIllI);
                this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick.getDefaultState(), 0, 13, llllllllllllllllIIllIIllIIllIIII, llllllllllllllllIIllIIllIIlIIllI);
                this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick.getDefaultState(), 12, 13, llllllllllllllllIIllIIllIIllIIII, llllllllllllllllIIllIIllIIlIIllI);
                this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_fence.getDefaultState(), llllllllllllllllIIllIIllIIllIIII + 1, 13, 0, llllllllllllllllIIllIIllIIlIIllI);
                this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_fence.getDefaultState(), llllllllllllllllIIllIIllIIllIIII + 1, 13, 12, llllllllllllllllIIllIIllIIlIIllI);
                this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_fence.getDefaultState(), 0, 13, llllllllllllllllIIllIIllIIllIIII + 1, llllllllllllllllIIllIIllIIlIIllI);
                this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_fence.getDefaultState(), 12, 13, llllllllllllllllIIllIIllIIllIIII + 1, llllllllllllllllIIllIIllIIlIIllI);
            }
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_fence.getDefaultState(), 0, 13, 0, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_fence.getDefaultState(), 0, 13, 12, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_fence.getDefaultState(), 0, 13, 0, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_fence.getDefaultState(), 12, 13, 0, llllllllllllllllIIllIIllIIlIIllI);
            for (int llllllllllllllllIIllIIllIIllIIII = 3; llllllllllllllllIIllIIllIIllIIII <= 9; llllllllllllllllIIllIIllIIllIIII += 2) {
                this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 1, 7, llllllllllllllllIIllIIllIIllIIII, 1, 8, llllllllllllllllIIllIIllIIllIIII, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 11, 7, llllllllllllllllIIllIIllIIllIIII, 11, 8, llllllllllllllllIIllIIllIIllIIII, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            }
            int llllllllllllllllIIllIIllIIllIIII = this.getMetadataWithOffset(Blocks.nether_brick_stairs, 3);
            for (int llllllllllllllllIIllIIllIIlIllll = 0; llllllllllllllllIIllIIllIIlIllll <= 6; ++llllllllllllllllIIllIIllIIlIllll) {
                final int llllllllllllllllIIllIIllIIlIlllI = llllllllllllllllIIllIIllIIlIllll + 4;
                for (int llllllllllllllllIIllIIllIIlIllII = 5; llllllllllllllllIIllIIllIIlIllII <= 7; ++llllllllllllllllIIllIIllIIlIllII) {
                    this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIIllIIllIIllIIII), llllllllllllllllIIllIIllIIlIllII, 5 + llllllllllllllllIIllIIllIIlIllll, llllllllllllllllIIllIIllIIlIlllI, llllllllllllllllIIllIIllIIlIIllI);
                }
                if (llllllllllllllllIIllIIllIIlIlllI >= 5 && llllllllllllllllIIllIIllIIlIlllI <= 8) {
                    this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 5, 5, llllllllllllllllIIllIIllIIlIlllI, 7, llllllllllllllllIIllIIllIIlIllll + 4, llllllllllllllllIIllIIllIIlIlllI, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
                }
                else if (llllllllllllllllIIllIIllIIlIlllI >= 9 && llllllllllllllllIIllIIllIIlIlllI <= 10) {
                    this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 5, 8, llllllllllllllllIIllIIllIIlIlllI, 7, llllllllllllllllIIllIIllIIlIllll + 4, llllllllllllllllIIllIIllIIlIlllI, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
                }
                if (llllllllllllllllIIllIIllIIlIllll >= 1) {
                    this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 5, 6 + llllllllllllllllIIllIIllIIlIllll, llllllllllllllllIIllIIllIIlIlllI, 7, 9 + llllllllllllllllIIllIIllIIlIllll, llllllllllllllllIIllIIllIIlIlllI, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                }
            }
            for (int llllllllllllllllIIllIIllIIlIllll = 5; llllllllllllllllIIllIIllIIlIllll <= 7; ++llllllllllllllllIIllIIllIIlIllll) {
                this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIIllIIllIIllIIII), llllllllllllllllIIllIIllIIlIllll, 12, 11, llllllllllllllllIIllIIllIIlIIllI);
            }
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 5, 6, 7, 5, 7, 7, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 7, 6, 7, 7, 7, 7, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 5, 13, 12, 7, 13, 12, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 2, 5, 2, 3, 5, 3, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 2, 5, 9, 3, 5, 10, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 2, 5, 4, 2, 5, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 9, 5, 2, 10, 5, 3, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 9, 5, 9, 10, 5, 10, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 10, 5, 4, 10, 5, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            int llllllllllllllllIIllIIllIIlIllll = this.getMetadataWithOffset(Blocks.nether_brick_stairs, 0);
            final int llllllllllllllllIIllIIllIIlIllIl = this.getMetadataWithOffset(Blocks.nether_brick_stairs, 1);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIIllIIllIIlIllIl), 4, 5, 2, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIIllIIllIIlIllIl), 4, 5, 3, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIIllIIllIIlIllIl), 4, 5, 9, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIIllIIllIIlIllIl), 4, 5, 10, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIIllIIllIIlIllll), 8, 5, 2, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIIllIIllIIlIllll), 8, 5, 3, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIIllIIllIIlIllll), 8, 5, 9, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175811_a(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick_stairs.getStateFromMeta(llllllllllllllllIIllIIllIIlIllll), 8, 5, 10, llllllllllllllllIIllIIllIIlIIllI);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 3, 4, 4, 4, 4, 8, Blocks.soul_sand.getDefaultState(), Blocks.soul_sand.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 8, 4, 4, 9, 4, 8, Blocks.soul_sand.getDefaultState(), Blocks.soul_sand.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 3, 5, 4, 4, 5, 8, Blocks.nether_wart.getDefaultState(), Blocks.nether_wart.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 8, 5, 4, 9, 5, 8, Blocks.nether_wart.getDefaultState(), Blocks.nether_wart.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 4, 2, 0, 8, 2, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 0, 2, 4, 12, 2, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 4, 0, 0, 8, 1, 3, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 4, 0, 9, 8, 1, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 0, 0, 4, 3, 1, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIllIIllIIllIIll, llllllllllllllllIIllIIllIIlIIllI, 9, 0, 4, 12, 1, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (int llllllllllllllllIIllIIllIIlIlIll = 4; llllllllllllllllIIllIIllIIlIlIll <= 8; ++llllllllllllllllIIllIIllIIlIlIll) {
                for (int llllllllllllllllIIllIIllIIlIlIlI = 0; llllllllllllllllIIllIIllIIlIlIlI <= 2; ++llllllllllllllllIIllIIllIIlIlIlI) {
                    this.func_175808_b(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick.getDefaultState(), llllllllllllllllIIllIIllIIlIlIll, -1, llllllllllllllllIIllIIllIIlIlIlI, llllllllllllllllIIllIIllIIlIIllI);
                    this.func_175808_b(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick.getDefaultState(), llllllllllllllllIIllIIllIIlIlIll, -1, 12 - llllllllllllllllIIllIIllIIlIlIlI, llllllllllllllllIIllIIllIIlIIllI);
                }
            }
            for (int llllllllllllllllIIllIIllIIlIlIll = 0; llllllllllllllllIIllIIllIIlIlIll <= 2; ++llllllllllllllllIIllIIllIIlIlIll) {
                for (int llllllllllllllllIIllIIllIIlIlIIl = 4; llllllllllllllllIIllIIllIIlIlIIl <= 8; ++llllllllllllllllIIllIIllIIlIlIIl) {
                    this.func_175808_b(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick.getDefaultState(), llllllllllllllllIIllIIllIIlIlIll, -1, llllllllllllllllIIllIIllIIlIlIIl, llllllllllllllllIIllIIllIIlIIllI);
                    this.func_175808_b(llllllllllllllllIIllIIllIIllIIll, Blocks.nether_brick.getDefaultState(), 12 - llllllllllllllllIIllIIllIIlIlIll, -1, llllllllllllllllIIllIIllIIlIlIIl, llllllllllllllllIIllIIllIIlIIllI);
                }
            }
            return true;
        }
        
        public NetherStalkRoom(final int llllllllllllllllIIllIIllIllIIIll, final Random llllllllllllllllIIllIIllIllIIlll, final StructureBoundingBox llllllllllllllllIIllIIllIllIIllI, final EnumFacing llllllllllllllllIIllIIllIllIIlIl) {
            super(llllllllllllllllIIllIIllIllIIIll);
            this.coordBaseMode = llllllllllllllllIIllIIllIllIIlIl;
            this.boundingBox = llllllllllllllllIIllIIllIllIIllI;
        }
    }
    
    public static class Corridor4 extends Piece
    {
        @Override
        public boolean addComponentParts(final World llllllllllllllllllIlllIIIlIlIlIl, final Random llllllllllllllllllIlllIIIlIlIlII, final StructureBoundingBox llllllllllllllllllIlllIIIlIIlllI) {
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 0, 0, 0, 8, 1, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 0, 2, 0, 8, 5, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 0, 6, 0, 8, 6, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 0, 2, 0, 2, 5, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 6, 2, 0, 8, 5, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 1, 3, 0, 1, 4, 0, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 7, 3, 0, 7, 4, 0, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 0, 2, 4, 8, 2, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 1, 1, 4, 2, 2, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 6, 1, 4, 7, 2, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 0, 3, 8, 8, 3, 8, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 0, 3, 6, 0, 3, 7, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 8, 3, 6, 8, 3, 7, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 0, 3, 4, 0, 5, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 8, 3, 4, 8, 5, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 1, 3, 5, 2, 5, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 6, 3, 5, 7, 5, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 1, 4, 5, 1, 5, 5, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllllIlllIIIlIlIlIl, llllllllllllllllllIlllIIIlIIlllI, 7, 4, 5, 7, 5, 5, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            for (int llllllllllllllllllIlllIIIlIlIIlI = 0; llllllllllllllllllIlllIIIlIlIIlI <= 5; ++llllllllllllllllllIlllIIIlIlIIlI) {
                for (int llllllllllllllllllIlllIIIlIlIIIl = 0; llllllllllllllllllIlllIIIlIlIIIl <= 8; ++llllllllllllllllllIlllIIIlIlIIIl) {
                    this.func_175808_b(llllllllllllllllllIlllIIIlIlIlIl, Blocks.nether_brick.getDefaultState(), llllllllllllllllllIlllIIIlIlIIIl, -1, llllllllllllllllllIlllIIIlIlIIlI, llllllllllllllllllIlllIIIlIIlllI);
                }
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllllllIlllIIlIllIllI, final List llllllllllllllllllIlllIIlIllIIII, final Random llllllllllllllllllIlllIIlIlIllll) {
            byte llllllllllllllllllIlllIIlIllIIll = 1;
            if (this.coordBaseMode == EnumFacing.WEST || this.coordBaseMode == EnumFacing.NORTH) {
                llllllllllllllllllIlllIIlIllIIll = 5;
            }
            this.getNextComponentX((Start)llllllllllllllllllIlllIIlIllIllI, llllllllllllllllllIlllIIlIllIIII, llllllllllllllllllIlllIIlIlIllll, 0, llllllllllllllllllIlllIIlIllIIll, llllllllllllllllllIlllIIlIlIllll.nextInt(8) > 0);
            this.getNextComponentZ((Start)llllllllllllllllllIlllIIlIllIllI, llllllllllllllllllIlllIIlIllIIII, llllllllllllllllllIlllIIlIlIllll, 0, llllllllllllllllllIlllIIlIllIIll, llllllllllllllllllIlllIIlIlIllll.nextInt(8) > 0);
        }
        
        public Corridor4(final int llllllllllllllllllIlllIIllIIlllI, final Random llllllllllllllllllIlllIIllIIllIl, final StructureBoundingBox llllllllllllllllllIlllIIllIIlIll, final EnumFacing llllllllllllllllllIlllIIllIIlIIl) {
            super(llllllllllllllllllIlllIIllIIlllI);
            this.coordBaseMode = llllllllllllllllllIlllIIllIIlIIl;
            this.boundingBox = llllllllllllllllllIlllIIllIIlIll;
        }
        
        public static Corridor4 func_175880_a(final List llllllllllllllllllIlllIIlIIIIlll, final Random llllllllllllllllllIlllIIlIIIIlIl, final int llllllllllllllllllIlllIIlIIlIIll, final int llllllllllllllllllIlllIIlIIlIIIl, final int llllllllllllllllllIlllIIlIIIIIIl, final EnumFacing llllllllllllllllllIlllIIlIIIllIl, final int llllllllllllllllllIlllIIIlllllll) {
            final StructureBoundingBox llllllllllllllllllIlllIIlIIIlIIl = StructureBoundingBox.func_175897_a(llllllllllllllllllIlllIIlIIlIIll, llllllllllllllllllIlllIIlIIlIIIl, llllllllllllllllllIlllIIlIIIIIIl, -3, 0, 0, 9, 7, 9, llllllllllllllllllIlllIIlIIIllIl);
            return (Piece.isAboveGround(llllllllllllllllllIlllIIlIIIlIIl) && StructureComponent.findIntersecting(llllllllllllllllllIlllIIlIIIIlll, llllllllllllllllllIlllIIlIIIlIIl) == null) ? new Corridor4(llllllllllllllllllIlllIIIlllllll, llllllllllllllllllIlllIIlIIIIlIl, llllllllllllllllllIlllIIlIIIlIIl, llllllllllllllllllIlllIIlIIIllIl) : null;
        }
        
        static {
            __OBFID = "CL_00000458";
        }
        
        public Corridor4() {
        }
    }
    
    public static class Crossing extends Piece
    {
        public Crossing(final int llllllllllllllllIlllllIlIlIlIIII, final Random llllllllllllllllIlllllIlIlIIllll, final StructureBoundingBox llllllllllllllllIlllllIlIlIIlllI, final EnumFacing llllllllllllllllIlllllIlIlIIllIl) {
            super(llllllllllllllllIlllllIlIlIlIIII);
            this.coordBaseMode = llllllllllllllllIlllllIlIlIIllIl;
            this.boundingBox = llllllllllllllllIlllllIlIlIIlllI;
        }
        
        static {
            __OBFID = "CL_00000468";
        }
        
        public static Crossing func_175873_a(final List llllllllllllllllIlllllIlIIlIllII, final Random llllllllllllllllIlllllIlIIlIlIll, final int llllllllllllllllIlllllIlIIllIIlI, final int llllllllllllllllIlllllIlIIllIIIl, final int llllllllllllllllIlllllIlIIlIlIII, final EnumFacing llllllllllllllllIlllllIlIIlIllll, final int llllllllllllllllIlllllIlIIlIIllI) {
            final StructureBoundingBox llllllllllllllllIlllllIlIIlIllIl = StructureBoundingBox.func_175897_a(llllllllllllllllIlllllIlIIllIIlI, llllllllllllllllIlllllIlIIllIIIl, llllllllllllllllIlllllIlIIlIlIII, -2, 0, 0, 7, 9, 7, llllllllllllllllIlllllIlIIlIllll);
            return (Piece.isAboveGround(llllllllllllllllIlllllIlIIlIllIl) && StructureComponent.findIntersecting(llllllllllllllllIlllllIlIIlIllII, llllllllllllllllIlllllIlIIlIllIl) == null) ? new Crossing(llllllllllllllllIlllllIlIIlIIllI, llllllllllllllllIlllllIlIIlIlIll, llllllllllllllllIlllllIlIIlIllIl, llllllllllllllllIlllllIlIIlIllll) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIlllllIlIIIllIII, final Random llllllllllllllllIlllllIlIIIlllIl, final StructureBoundingBox llllllllllllllllIlllllIlIIIlIlll) {
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 0, 0, 0, 6, 1, 6, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 0, 2, 0, 6, 7, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 0, 2, 0, 1, 6, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 0, 2, 6, 1, 6, 6, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 5, 2, 0, 6, 6, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 5, 2, 6, 6, 6, 6, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 0, 2, 0, 0, 6, 1, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 0, 2, 5, 0, 6, 6, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 6, 2, 0, 6, 6, 1, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 6, 2, 5, 6, 6, 6, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 2, 6, 0, 4, 6, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 2, 5, 0, 4, 5, 0, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 2, 6, 6, 4, 6, 6, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 2, 5, 6, 4, 5, 6, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 0, 6, 2, 0, 6, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 0, 5, 2, 0, 5, 4, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 6, 6, 2, 6, 6, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIlllllIlIIIllIII, llllllllllllllllIlllllIlIIIlIlll, 6, 5, 2, 6, 5, 4, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            for (int llllllllllllllllIlllllIlIIIllIll = 0; llllllllllllllllIlllllIlIIIllIll <= 6; ++llllllllllllllllIlllllIlIIIllIll) {
                for (int llllllllllllllllIlllllIlIIIllIlI = 0; llllllllllllllllIlllllIlIIIllIlI <= 6; ++llllllllllllllllIlllllIlIIIllIlI) {
                    this.func_175808_b(llllllllllllllllIlllllIlIIIllIII, Blocks.nether_brick.getDefaultState(), llllllllllllllllIlllllIlIIIllIll, -1, llllllllllllllllIlllllIlIIIllIlI, llllllllllllllllIlllllIlIIIlIlll);
                }
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllllIlllllIlIIllllll, final List llllllllllllllllIlllllIlIlIIIIlI, final Random llllllllllllllllIlllllIlIIllllIl) {
            this.getNextComponentNormal((Start)llllllllllllllllIlllllIlIIllllll, llllllllllllllllIlllllIlIlIIIIlI, llllllllllllllllIlllllIlIIllllIl, 2, 0, false);
            this.getNextComponentX((Start)llllllllllllllllIlllllIlIIllllll, llllllllllllllllIlllllIlIlIIIIlI, llllllllllllllllIlllllIlIIllllIl, 0, 2, false);
            this.getNextComponentZ((Start)llllllllllllllllIlllllIlIIllllll, llllllllllllllllIlllllIlIlIIIIlI, llllllllllllllllIlllllIlIIllllIl, 0, 2, false);
        }
        
        public Crossing() {
        }
    }
    
    public static class Entrance extends Piece
    {
        public static Entrance func_175881_a(final List llIIlIIlllIlIII, final Random llIIlIIlllIllll, final int llIIlIIlllIIllI, final int llIIlIIlllIllIl, final int llIIlIIlllIllII, final EnumFacing llIIlIIlllIlIll, final int llIIlIIlllIlIlI) {
            final StructureBoundingBox llIIlIIlllIlIIl = StructureBoundingBox.func_175897_a(llIIlIIlllIIllI, llIIlIIlllIllIl, llIIlIIlllIllII, -5, -3, 0, 13, 14, 13, llIIlIIlllIlIll);
            return (Piece.isAboveGround(llIIlIIlllIlIIl) && StructureComponent.findIntersecting(llIIlIIlllIlIII, llIIlIIlllIlIIl) == null) ? new Entrance(llIIlIIlllIlIlI, llIIlIIlllIllll, llIIlIIlllIlIIl, llIIlIIlllIlIll) : null;
        }
        
        @Override
        public void buildComponent(final StructureComponent llIIlIIllllllll, final List llIIlIIlllllllI, final Random llIIlIIllllllIl) {
            this.getNextComponentNormal((Start)llIIlIIllllllll, llIIlIIlllllllI, llIIlIIllllllIl, 5, 3, true);
        }
        
        public Entrance() {
        }
        
        public Entrance(final int llIIlIlIIIIllII, final Random llIIlIlIIIIlIll, final StructureBoundingBox llIIlIlIIIIIllI, final EnumFacing llIIlIlIIIIIlIl) {
            super(llIIlIlIIIIllII);
            this.coordBaseMode = llIIlIlIIIIIlIl;
            this.boundingBox = llIIlIlIIIIIllI;
        }
        
        @Override
        public boolean addComponentParts(final World llIIlIIllIlIIII, final Random llIIlIIllIlIlll, final StructureBoundingBox llIIlIIllIlIllI) {
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 0, 3, 0, 12, 4, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 0, 5, 0, 12, 13, 12, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 0, 5, 0, 1, 12, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 11, 5, 0, 12, 12, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 2, 5, 11, 4, 12, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 8, 5, 11, 10, 12, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 5, 9, 11, 7, 12, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 2, 5, 0, 4, 12, 1, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 8, 5, 0, 10, 12, 1, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 5, 9, 0, 7, 12, 1, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 2, 11, 2, 10, 12, 10, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 5, 8, 0, 7, 8, 0, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            for (int llIIlIIllIlIlIl = 1; llIIlIIllIlIlIl <= 11; llIIlIIllIlIlIl += 2) {
                this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, llIIlIIllIlIlIl, 10, 0, llIIlIIllIlIlIl, 11, 0, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, llIIlIIllIlIlIl, 10, 12, llIIlIIllIlIlIl, 11, 12, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 0, 10, llIIlIIllIlIlIl, 0, 11, llIIlIIllIlIlIl, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 12, 10, llIIlIIllIlIlIl, 12, 11, llIIlIIllIlIlIl, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick.getDefaultState(), llIIlIIllIlIlIl, 13, 0, llIIlIIllIlIllI);
                this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick.getDefaultState(), llIIlIIllIlIlIl, 13, 12, llIIlIIllIlIllI);
                this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick.getDefaultState(), 0, 13, llIIlIIllIlIlIl, llIIlIIllIlIllI);
                this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick.getDefaultState(), 12, 13, llIIlIIllIlIlIl, llIIlIIllIlIllI);
                this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick_fence.getDefaultState(), llIIlIIllIlIlIl + 1, 13, 0, llIIlIIllIlIllI);
                this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick_fence.getDefaultState(), llIIlIIllIlIlIl + 1, 13, 12, llIIlIIllIlIllI);
                this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick_fence.getDefaultState(), 0, 13, llIIlIIllIlIlIl + 1, llIIlIIllIlIllI);
                this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick_fence.getDefaultState(), 12, 13, llIIlIIllIlIlIl + 1, llIIlIIllIlIllI);
            }
            this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick_fence.getDefaultState(), 0, 13, 0, llIIlIIllIlIllI);
            this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick_fence.getDefaultState(), 0, 13, 12, llIIlIIllIlIllI);
            this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick_fence.getDefaultState(), 0, 13, 0, llIIlIIllIlIllI);
            this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick_fence.getDefaultState(), 12, 13, 0, llIIlIIllIlIllI);
            for (int llIIlIIllIlIlIl = 3; llIIlIIllIlIlIl <= 9; llIIlIIllIlIlIl += 2) {
                this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 1, 7, llIIlIIllIlIlIl, 1, 8, llIIlIIllIlIlIl, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
                this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 11, 7, llIIlIIllIlIlIl, 11, 8, llIIlIIllIlIlIl, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            }
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 4, 2, 0, 8, 2, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 0, 2, 4, 12, 2, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 4, 0, 0, 8, 1, 3, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 4, 0, 9, 8, 1, 12, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 0, 0, 4, 3, 1, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 9, 0, 4, 12, 1, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (int llIIlIIllIlIlIl = 4; llIIlIIllIlIlIl <= 8; ++llIIlIIllIlIlIl) {
                for (int llIIlIIllIlIlII = 0; llIIlIIllIlIlII <= 2; ++llIIlIIllIlIlII) {
                    this.func_175808_b(llIIlIIllIlIIII, Blocks.nether_brick.getDefaultState(), llIIlIIllIlIlIl, -1, llIIlIIllIlIlII, llIIlIIllIlIllI);
                    this.func_175808_b(llIIlIIllIlIIII, Blocks.nether_brick.getDefaultState(), llIIlIIllIlIlIl, -1, 12 - llIIlIIllIlIlII, llIIlIIllIlIllI);
                }
            }
            for (int llIIlIIllIlIlIl = 0; llIIlIIllIlIlIl <= 2; ++llIIlIIllIlIlIl) {
                for (int llIIlIIllIlIIll = 4; llIIlIIllIlIIll <= 8; ++llIIlIIllIlIIll) {
                    this.func_175808_b(llIIlIIllIlIIII, Blocks.nether_brick.getDefaultState(), llIIlIIllIlIlIl, -1, llIIlIIllIlIIll, llIIlIIllIlIllI);
                    this.func_175808_b(llIIlIIllIlIIII, Blocks.nether_brick.getDefaultState(), 12 - llIIlIIllIlIlIl, -1, llIIlIIllIlIIll, llIIlIIllIlIllI);
                }
            }
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 5, 5, 5, 7, 5, 7, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llIIlIIllIlIIII, llIIlIIllIlIllI, 6, 1, 6, 6, 4, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175811_a(llIIlIIllIlIIII, Blocks.nether_brick.getDefaultState(), 6, 0, 6, llIIlIIllIlIllI);
            this.func_175811_a(llIIlIIllIlIIII, Blocks.flowing_lava.getDefaultState(), 6, 5, 6, llIIlIIllIlIllI);
            final BlockPos llIIlIIllIlIIlI = new BlockPos(this.getXWithOffset(6, 6), this.getYWithOffset(5), this.getZWithOffset(6, 6));
            if (llIIlIIllIlIllI.func_175898_b(llIIlIIllIlIIlI)) {
                llIIlIIllIlIIII.func_175637_a(Blocks.flowing_lava, llIIlIIllIlIIlI, llIIlIIllIlIlll);
            }
            return true;
        }
        
        static {
            __OBFID = "CL_00000459";
        }
    }
    
    public static class Throne extends Piece
    {
        private /* synthetic */ boolean hasSpawner;
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIllIIIlIlIIIlIll, final Random llllllllllllllIlIllIIIlIlIIlIIlI, final StructureBoundingBox llllllllllllllIlIllIIIlIlIIlIIIl) {
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 0, 2, 0, 6, 7, 7, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 1, 0, 0, 5, 1, 7, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 1, 2, 1, 5, 2, 7, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 1, 3, 2, 5, 3, 7, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 1, 4, 3, 5, 4, 7, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 1, 2, 0, 1, 4, 2, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 5, 2, 0, 5, 4, 2, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 1, 5, 2, 1, 5, 3, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 5, 5, 2, 5, 5, 3, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 0, 5, 3, 0, 5, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 6, 5, 3, 6, 5, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 1, 5, 8, 5, 5, 8, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIlIllIIIlIlIIIlIll, Blocks.nether_brick_fence.getDefaultState(), 1, 6, 3, llllllllllllllIlIllIIIlIlIIlIIIl);
            this.func_175811_a(llllllllllllllIlIllIIIlIlIIIlIll, Blocks.nether_brick_fence.getDefaultState(), 5, 6, 3, llllllllllllllIlIllIIIlIlIIlIIIl);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 0, 6, 3, 0, 6, 8, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 6, 6, 3, 6, 6, 8, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 1, 6, 8, 5, 7, 8, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIIlIlIIIlIll, llllllllllllllIlIllIIIlIlIIlIIIl, 2, 8, 8, 4, 8, 8, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            if (!this.hasSpawner) {
                final BlockPos llllllllllllllIlIllIIIlIlIIlIIII = new BlockPos(this.getXWithOffset(3, 5), this.getYWithOffset(5), this.getZWithOffset(3, 5));
                if (llllllllllllllIlIllIIIlIlIIlIIIl.func_175898_b(llllllllllllllIlIllIIIlIlIIlIIII)) {
                    this.hasSpawner = true;
                    llllllllllllllIlIllIIIlIlIIIlIll.setBlockState(llllllllllllllIlIllIIIlIlIIlIIII, Blocks.mob_spawner.getDefaultState(), 2);
                    final TileEntity llllllllllllllIlIllIIIlIlIIIllll = llllllllllllllIlIllIIIlIlIIIlIll.getTileEntity(llllllllllllllIlIllIIIlIlIIlIIII);
                    if (llllllllllllllIlIllIIIlIlIIIllll instanceof TileEntityMobSpawner) {
                        ((TileEntityMobSpawner)llllllllllllllIlIllIIIlIlIIIllll).getSpawnerBaseLogic().setEntityName("Blaze");
                    }
                }
            }
            for (int llllllllllllllIlIllIIIlIlIIIlllI = 0; llllllllllllllIlIllIIIlIlIIIlllI <= 6; ++llllllllllllllIlIllIIIlIlIIIlllI) {
                for (int llllllllllllllIlIllIIIlIlIIIllIl = 0; llllllllllllllIlIllIIIlIlIIIllIl <= 6; ++llllllllllllllIlIllIIIlIlIIIllIl) {
                    this.func_175808_b(llllllllllllllIlIllIIIlIlIIIlIll, Blocks.nether_brick.getDefaultState(), llllllllllllllIlIllIIIlIlIIIlllI, -1, llllllllllllllIlIllIIIlIlIIIllIl, llllllllllllllIlIllIIIlIlIIlIIIl);
                }
            }
            return true;
        }
        
        public Throne(final int llllllllllllllIlIllIIIlIllIIIIII, final Random llllllllllllllIlIllIIIlIllIIIlII, final StructureBoundingBox llllllllllllllIlIllIIIlIllIIIIll, final EnumFacing llllllllllllllIlIllIIIlIllIIIIlI) {
            super(llllllllllllllIlIllIIIlIllIIIIII);
            this.coordBaseMode = llllllllllllllIlIllIIIlIllIIIIlI;
            this.boundingBox = llllllllllllllIlIllIIIlIllIIIIll;
        }
        
        public Throne() {
        }
        
        public static Throne func_175874_a(final List llllllllllllllIlIllIIIlIlIlIlIIl, final Random llllllllllllllIlIllIIIlIlIlIlIII, final int llllllllllllllIlIllIIIlIlIIlllll, final int llllllllllllllIlIllIIIlIlIlIIllI, final int llllllllllllllIlIllIIIlIlIlIIlIl, final int llllllllllllllIlIllIIIlIlIIlllII, final EnumFacing llllllllllllllIlIllIIIlIlIIllIll) {
            final StructureBoundingBox llllllllllllllIlIllIIIlIlIlIIIlI = StructureBoundingBox.func_175897_a(llllllllllllllIlIllIIIlIlIIlllll, llllllllllllllIlIllIIIlIlIlIIllI, llllllllllllllIlIllIIIlIlIlIIlIl, -2, 0, 0, 7, 8, 9, llllllllllllllIlIllIIIlIlIIllIll);
            return (Piece.isAboveGround(llllllllllllllIlIllIIIlIlIlIIIlI) && StructureComponent.findIntersecting(llllllllllllllIlIllIIIlIlIlIlIIl, llllllllllllllIlIllIIIlIlIlIIIlI) == null) ? new Throne(llllllllllllllIlIllIIIlIlIIlllII, llllllllllllllIlIllIIIlIlIlIlIII, llllllllllllllIlIllIIIlIlIlIIIlI, llllllllllllllIlIllIIIlIlIIllIll) : null;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIlIllIIIlIlIlllIlI) {
            super.readStructureFromNBT(llllllllllllllIlIllIIIlIlIlllIlI);
            this.hasSpawner = llllllllllllllIlIllIIIlIlIlllIlI.getBoolean("Mob");
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIlIllIIIlIlIllIIlI) {
            super.writeStructureToNBT(llllllllllllllIlIllIIIlIlIllIIlI);
            llllllllllllllIlIllIIIlIlIllIIlI.setBoolean("Mob", this.hasSpawner);
        }
        
        static {
            __OBFID = "CL_00000465";
        }
    }
    
    public static class Crossing2 extends Piece
    {
        @Override
        public boolean addComponentParts(final World lllllllllllllllIllIlIllIllIllIlI, final Random lllllllllllllllIllIlIllIllIllIIl, final StructureBoundingBox lllllllllllllllIllIlIllIllIlIIll) {
            this.func_175804_a(lllllllllllllllIllIlIllIllIllIlI, lllllllllllllllIllIlIllIllIlIIll, 0, 0, 0, 4, 1, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIlIllIllIllIlI, lllllllllllllllIllIlIllIllIlIIll, 0, 2, 0, 4, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIlIllIllIllIlI, lllllllllllllllIllIlIllIllIlIIll, 0, 2, 0, 0, 5, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIlIllIllIllIlI, lllllllllllllllIllIlIllIllIlIIll, 4, 2, 0, 4, 5, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIlIllIllIllIlI, lllllllllllllllIllIlIllIllIlIIll, 0, 2, 4, 0, 5, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIlIllIllIllIlI, lllllllllllllllIllIlIllIllIlIIll, 4, 2, 4, 4, 5, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIlIllIllIllIlI, lllllllllllllllIllIlIllIllIlIIll, 0, 6, 0, 4, 6, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (int lllllllllllllllIllIlIllIllIlIlll = 0; lllllllllllllllIllIlIllIllIlIlll <= 4; ++lllllllllllllllIllIlIllIllIlIlll) {
                for (int lllllllllllllllIllIlIllIllIlIllI = 0; lllllllllllllllIllIlIllIllIlIllI <= 4; ++lllllllllllllllIllIlIllIllIlIllI) {
                    this.func_175808_b(lllllllllllllllIllIlIllIllIllIlI, Blocks.nether_brick.getDefaultState(), lllllllllllllllIllIlIllIllIlIlll, -1, lllllllllllllllIllIlIllIllIlIllI, lllllllllllllllIllIlIllIllIlIIll);
                }
            }
            return true;
        }
        
        public Crossing2() {
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIllIlIllIlllllIll, final List lllllllllllllllIllIlIllIlllllIlI, final Random lllllllllllllllIllIlIllIllllllIl) {
            this.getNextComponentNormal((Start)lllllllllllllllIllIlIllIlllllIll, lllllllllllllllIllIlIllIlllllIlI, lllllllllllllllIllIlIllIllllllIl, 1, 0, true);
            this.getNextComponentX((Start)lllllllllllllllIllIlIllIlllllIll, lllllllllllllllIllIlIllIlllllIlI, lllllllllllllllIllIlIllIllllllIl, 0, 1, true);
            this.getNextComponentZ((Start)lllllllllllllllIllIlIllIlllllIll, lllllllllllllllIllIlIllIlllllIlI, lllllllllllllllIllIlIllIllllllIl, 0, 1, true);
        }
        
        public static Crossing2 func_175878_a(final List lllllllllllllllIllIlIllIllllIIII, final Random lllllllllllllllIllIlIllIlllIllll, final int lllllllllllllllIllIlIllIlllIIllI, final int lllllllllllllllIllIlIllIlllIllIl, final int lllllllllllllllIllIlIllIlllIllII, final EnumFacing lllllllllllllllIllIlIllIlllIlIll, final int lllllllllllllllIllIlIllIlllIlIlI) {
            final StructureBoundingBox lllllllllllllllIllIlIllIlllIlIIl = StructureBoundingBox.func_175897_a(lllllllllllllllIllIlIllIlllIIllI, lllllllllllllllIllIlIllIlllIllIl, lllllllllllllllIllIlIllIlllIllII, -1, 0, 0, 5, 7, 5, lllllllllllllllIllIlIllIlllIlIll);
            return (Piece.isAboveGround(lllllllllllllllIllIlIllIlllIlIIl) && StructureComponent.findIntersecting(lllllllllllllllIllIlIllIllllIIII, lllllllllllllllIllIlIllIlllIlIIl) == null) ? new Crossing2(lllllllllllllllIllIlIllIlllIlIlI, lllllllllllllllIllIlIllIlllIllll, lllllllllllllllIllIlIllIlllIlIIl, lllllllllllllllIllIlIllIlllIlIll) : null;
        }
        
        public Crossing2(final int lllllllllllllllIllIlIlllIIIIIlll, final Random lllllllllllllllIllIlIlllIIIIlIll, final StructureBoundingBox lllllllllllllllIllIlIlllIIIIlIlI, final EnumFacing lllllllllllllllIllIlIlllIIIIlIIl) {
            super(lllllllllllllllIllIlIlllIIIIIlll);
            this.coordBaseMode = lllllllllllllllIllIlIlllIIIIlIIl;
            this.boundingBox = lllllllllllllllIllIlIlllIIIIlIlI;
        }
        
        static {
            __OBFID = "CL_00000460";
        }
    }
    
    public static class Stairs extends Piece
    {
        static {
            __OBFID = "CL_00000469";
        }
        
        public Stairs() {
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIIlIIlIIIIIIlIIIIl, final List llllllllllllllIIlIIlIIIIIIIlllII, final Random llllllllllllllIIlIIlIIIIIIIllIll) {
            this.getNextComponentZ((Start)llllllllllllllIIlIIlIIIIIIlIIIIl, llllllllllllllIIlIIlIIIIIIIlllII, llllllllllllllIIlIIlIIIIIIIllIll, 6, 2, false);
        }
        
        public static Stairs func_175872_a(final List llllllllllllllIIlIIlIIIIIIIlIIlI, final Random llllllllllllllIIlIIlIIIIIIIlIIIl, final int llllllllllllllIIlIIlIIIIIIIIlIII, final int llllllllllllllIIlIIlIIIIIIIIIlll, final int llllllllllllllIIlIIlIIIIIIIIIllI, final int llllllllllllllIIlIIlIIIIIIIIllIl, final EnumFacing llllllllllllllIIlIIlIIIIIIIIIlII) {
            final StructureBoundingBox llllllllllllllIIlIIlIIIIIIIIlIll = StructureBoundingBox.func_175897_a(llllllllllllllIIlIIlIIIIIIIIlIII, llllllllllllllIIlIIlIIIIIIIIIlll, llllllllllllllIIlIIlIIIIIIIIIllI, -2, 0, 0, 7, 11, 7, llllllllllllllIIlIIlIIIIIIIIIlII);
            return (Piece.isAboveGround(llllllllllllllIIlIIlIIIIIIIIlIll) && StructureComponent.findIntersecting(llllllllllllllIIlIIlIIIIIIIlIIlI, llllllllllllllIIlIIlIIIIIIIIlIll) == null) ? new Stairs(llllllllllllllIIlIIlIIIIIIIIllIl, llllllllllllllIIlIIlIIIIIIIlIIIl, llllllllllllllIIlIIlIIIIIIIIlIll, llllllllllllllIIlIIlIIIIIIIIIlII) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlIIIllllllllIllI, final Random llllllllllllllIIlIIIlllllllllIll, final StructureBoundingBox llllllllllllllIIlIIIllllllllIlIl) {
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 0, 0, 0, 6, 1, 6, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 0, 2, 0, 6, 10, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 0, 2, 0, 1, 8, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 5, 2, 0, 6, 8, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 0, 2, 1, 0, 8, 6, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 6, 2, 1, 6, 8, 6, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 1, 2, 6, 5, 8, 6, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 0, 3, 2, 0, 5, 4, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 6, 3, 2, 6, 5, 2, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 6, 3, 4, 6, 5, 4, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIIlIIIllllllllIllI, Blocks.nether_brick.getDefaultState(), 5, 2, 5, llllllllllllllIIlIIIllllllllIlIl);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 4, 2, 5, 4, 3, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 3, 2, 5, 3, 4, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 2, 2, 5, 2, 5, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 1, 2, 5, 1, 6, 5, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 1, 7, 1, 5, 7, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 6, 8, 2, 6, 8, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 2, 6, 0, 4, 8, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlIIIllllllllIllI, llllllllllllllIIlIIIllllllllIlIl, 2, 5, 0, 4, 5, 0, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            for (int llllllllllllllIIlIIIlllllllllIIl = 0; llllllllllllllIIlIIIlllllllllIIl <= 6; ++llllllllllllllIIlIIIlllllllllIIl) {
                for (int llllllllllllllIIlIIIlllllllllIII = 0; llllllllllllllIIlIIIlllllllllIII <= 6; ++llllllllllllllIIlIIIlllllllllIII) {
                    this.func_175808_b(llllllllllllllIIlIIIllllllllIllI, Blocks.nether_brick.getDefaultState(), llllllllllllllIIlIIIlllllllllIIl, -1, llllllllllllllIIlIIIlllllllllIII, llllllllllllllIIlIIIllllllllIlIl);
                }
            }
            return true;
        }
        
        public Stairs(final int llllllllllllllIIlIIlIIIIIIlIlIIl, final Random llllllllllllllIIlIIlIIIIIIlIllIl, final StructureBoundingBox llllllllllllllIIlIIlIIIIIIlIllII, final EnumFacing llllllllllllllIIlIIlIIIIIIlIlIll) {
            super(llllllllllllllIIlIIlIIIIIIlIlIIl);
            this.coordBaseMode = llllllllllllllIIlIIlIIIIIIlIlIll;
            this.boundingBox = llllllllllllllIIlIIlIIIIIIlIllII;
        }
    }
    
    public static class Corridor2 extends Piece
    {
        private /* synthetic */ boolean field_111020_b;
        
        public static Corridor2 func_175876_a(final List lllllllllllllllIllllllIlIIIlIllI, final Random lllllllllllllllIllllllIlIIIlIlIl, final int lllllllllllllllIllllllIlIIIlllII, final int lllllllllllllllIllllllIlIIIllIll, final int lllllllllllllllIllllllIlIIIllIlI, final EnumFacing lllllllllllllllIllllllIlIIIllIIl, final int lllllllllllllllIllllllIlIIIlIIII) {
            final StructureBoundingBox lllllllllllllllIllllllIlIIIlIlll = StructureBoundingBox.func_175897_a(lllllllllllllllIllllllIlIIIlllII, lllllllllllllllIllllllIlIIIllIll, lllllllllllllllIllllllIlIIIllIlI, -1, 0, 0, 5, 7, 5, lllllllllllllllIllllllIlIIIllIIl);
            return (Piece.isAboveGround(lllllllllllllllIllllllIlIIIlIlll) && StructureComponent.findIntersecting(lllllllllllllllIllllllIlIIIlIllI, lllllllllllllllIllllllIlIIIlIlll) == null) ? new Corridor2(lllllllllllllllIllllllIlIIIlIIII, lllllllllllllllIllllllIlIIIlIlIl, lllllllllllllllIllllllIlIIIlIlll, lllllllllllllllIllllllIlIIIllIIl) : null;
        }
        
        public Corridor2(final int lllllllllllllllIllllllIlIlIIIlll, final Random lllllllllllllllIllllllIlIlIIIllI, final StructureBoundingBox lllllllllllllllIllllllIlIlIIIIII, final EnumFacing lllllllllllllllIllllllIlIlIIIlII) {
            super(lllllllllllllllIllllllIlIlIIIlll);
            this.coordBaseMode = lllllllllllllllIllllllIlIlIIIlII;
            this.boundingBox = lllllllllllllllIllllllIlIlIIIIII;
            this.field_111020_b = (lllllllllllllllIllllllIlIlIIIllI.nextInt(3) == 0);
        }
        
        public Corridor2() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIllllllIlIIllIIll) {
            super.writeStructureToNBT(lllllllllllllllIllllllIlIIllIIll);
            lllllllllllllllIllllllIlIIllIIll.setBoolean("Chest", this.field_111020_b);
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIllllllIlIIlIlIIl, final List lllllllllllllllIllllllIlIIlIllII, final Random lllllllllllllllIllllllIlIIlIIlll) {
            this.getNextComponentZ((Start)lllllllllllllllIllllllIlIIlIlIIl, lllllllllllllllIllllllIlIIlIllII, lllllllllllllllIllllllIlIIlIIlll, 0, 1, true);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIllllllIlIIIIIlll, final Random lllllllllllllllIllllllIlIIIIIIII, final StructureBoundingBox lllllllllllllllIllllllIlIIIIIlIl) {
            this.func_175804_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, 0, 0, 0, 4, 1, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, 0, 2, 0, 4, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, 0, 2, 0, 0, 5, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, 0, 3, 1, 0, 4, 1, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, 0, 3, 3, 0, 4, 3, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, 4, 2, 0, 4, 5, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, 1, 2, 4, 4, 5, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, 1, 3, 4, 1, 4, 4, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, 3, 3, 4, 3, 4, 4, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            if (this.field_111020_b && lllllllllllllllIllllllIlIIIIIlIl.func_175898_b(new BlockPos(this.getXWithOffset(1, 3), this.getYWithOffset(2), this.getZWithOffset(1, 3)))) {
                this.field_111020_b = false;
                this.func_180778_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, lllllllllllllllIllllllIlIIIIIIII, 1, 2, 3, Corridor2.field_111019_a, 2 + lllllllllllllllIllllllIlIIIIIIII.nextInt(4));
            }
            this.func_175804_a(lllllllllllllllIllllllIlIIIIIlll, lllllllllllllllIllllllIlIIIIIlIl, 0, 6, 0, 4, 6, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (int lllllllllllllllIllllllIlIIIIIlII = 0; lllllllllllllllIllllllIlIIIIIlII <= 4; ++lllllllllllllllIllllllIlIIIIIlII) {
                for (int lllllllllllllllIllllllIlIIIIIIll = 0; lllllllllllllllIllllllIlIIIIIIll <= 4; ++lllllllllllllllIllllllIlIIIIIIll) {
                    this.func_175808_b(lllllllllllllllIllllllIlIIIIIlll, Blocks.nether_brick.getDefaultState(), lllllllllllllllIllllllIlIIIIIlII, -1, lllllllllllllllIllllllIlIIIIIIll, lllllllllllllllIllllllIlIIIIIlIl);
                }
            }
            return true;
        }
        
        static {
            __OBFID = "CL_00000463";
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIllllllIlIIlllIll) {
            super.readStructureFromNBT(lllllllllllllllIllllllIlIIlllIll);
            this.field_111020_b = lllllllllllllllIllllllIlIIlllIll.getBoolean("Chest");
        }
    }
    
    public static class Corridor extends Piece
    {
        private /* synthetic */ boolean field_111021_b;
        
        public Corridor(final int llllllllllllllIlIIlIIIllIllIIIII, final Random llllllllllllllIlIIlIIIllIlIlllll, final StructureBoundingBox llllllllllllllIlIIlIIIllIlIllIIl, final EnumFacing llllllllllllllIlIIlIIIllIlIllIII) {
            super(llllllllllllllIlIIlIIIllIllIIIII);
            this.coordBaseMode = llllllllllllllIlIIlIIIllIlIllIII;
            this.boundingBox = llllllllllllllIlIIlIIIllIlIllIIl;
            this.field_111021_b = (llllllllllllllIlIIlIIIllIlIlllll.nextInt(3) == 0);
        }
        
        public static Corridor func_175879_a(final List llllllllllllllIlIIlIIIllIIlIllll, final Random llllllllllllllIlIIlIIIllIIlIlllI, final int llllllllllllllIlIIlIIIllIIlIllIl, final int llllllllllllllIlIIlIIIllIIlIllII, final int llllllllllllllIlIIlIIIllIIlIlIll, final EnumFacing llllllllllllllIlIIlIIIllIIlIlIlI, final int llllllllllllllIlIIlIIIllIIllIIIl) {
            final StructureBoundingBox llllllllllllllIlIIlIIIllIIllIIII = StructureBoundingBox.func_175897_a(llllllllllllllIlIIlIIIllIIlIllIl, llllllllllllllIlIIlIIIllIIlIllII, llllllllllllllIlIIlIIIllIIlIlIll, -1, 0, 0, 5, 7, 5, llllllllllllllIlIIlIIIllIIlIlIlI);
            return (Piece.isAboveGround(llllllllllllllIlIIlIIIllIIllIIII) && StructureComponent.findIntersecting(llllllllllllllIlIIlIIIllIIlIllll, llllllllllllllIlIIlIIIllIIllIIII) == null) ? new Corridor(llllllllllllllIlIIlIIIllIIllIIIl, llllllllllllllIlIIlIIIllIIlIlllI, llllllllllllllIlIIlIIIllIIllIIII, llllllllllllllIlIIlIIIllIIlIlIlI) : null;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIlIIlIIIllIlIlIlII) {
            super.readStructureFromNBT(llllllllllllllIlIIlIIIllIlIlIlII);
            this.field_111021_b = llllllllllllllIlIIlIIIllIlIlIlII.getBoolean("Chest");
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIlIIlIIIllIlIIIIlI, final List llllllllllllllIlIIlIIIllIlIIIlIl, final Random llllllllllllllIlIIlIIIllIlIIIlII) {
            this.getNextComponentX((Start)llllllllllllllIlIIlIIIllIlIIIIlI, llllllllllllllIlIIlIIIllIlIIIlIl, llllllllllllllIlIIlIIIllIlIIIlII, 0, 1, true);
        }
        
        static {
            __OBFID = "CL_00000461";
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIlIIlIIIllIlIIlllI) {
            super.writeStructureToNBT(llllllllllllllIlIIlIIIllIlIIlllI);
            llllllllllllllIlIIlIIIllIlIIlllI.setBoolean("Chest", this.field_111021_b);
        }
        
        public Corridor() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIIlIIIllIIlIIIII, final Random llllllllllllllIlIIlIIIllIIIlllll, final StructureBoundingBox llllllllllllllIlIIlIIIllIIIllllI) {
            this.func_175804_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, 0, 0, 0, 4, 1, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, 0, 2, 0, 4, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, 4, 2, 0, 4, 5, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, 4, 3, 1, 4, 4, 1, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, 4, 3, 3, 4, 4, 3, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, 0, 2, 0, 0, 5, 0, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, 0, 2, 4, 3, 5, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, 1, 3, 4, 1, 4, 4, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, 3, 3, 4, 3, 4, 4, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            if (this.field_111021_b && llllllllllllllIlIIlIIIllIIIllllI.func_175898_b(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3)))) {
                this.field_111021_b = false;
                this.func_180778_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, llllllllllllllIlIIlIIIllIIIlllll, 3, 2, 3, Corridor.field_111019_a, 2 + llllllllllllllIlIIlIIIllIIIlllll.nextInt(4));
            }
            this.func_175804_a(llllllllllllllIlIIlIIIllIIlIIIII, llllllllllllllIlIIlIIIllIIIllllI, 0, 6, 0, 4, 6, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (int llllllllllllllIlIIlIIIllIIIlllIl = 0; llllllllllllllIlIIlIIIllIIIlllIl <= 4; ++llllllllllllllIlIIlIIIllIIIlllIl) {
                for (int llllllllllllllIlIIlIIIllIIIlllII = 0; llllllllllllllIlIIlIIIllIIIlllII <= 4; ++llllllllllllllIlIIlIIIllIIIlllII) {
                    this.func_175808_b(llllllllllllllIlIIlIIIllIIlIIIII, Blocks.nether_brick.getDefaultState(), llllllllllllllIlIIlIIIllIIIlllIl, -1, llllllllllllllIlIIlIIIllIIIlllII, llllllllllllllIlIIlIIIllIIIllllI);
                }
            }
            return true;
        }
    }
    
    public static class Corridor5 extends Piece
    {
        static {
            __OBFID = "CL_00000462";
        }
        
        public Corridor5(final int llllllllllllllIlllIllIIIlllIIIll, final Random llllllllllllllIlllIllIIIlllIIlll, final StructureBoundingBox llllllllllllllIlllIllIIIlllIIIlI, final EnumFacing llllllllllllllIlllIllIIIlllIIlIl) {
            super(llllllllllllllIlllIllIIIlllIIIll);
            this.coordBaseMode = llllllllllllllIlllIllIIIlllIIlIl;
            this.boundingBox = llllllllllllllIlllIllIIIlllIIIlI;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIlllIllIIIllIlIlll, final List llllllllllllllIlllIllIIIllIlIllI, final Random llllllllllllllIlllIllIIIllIlIlIl) {
            this.getNextComponentNormal((Start)llllllllllllllIlllIllIIIllIlIlll, llllllllllllllIlllIllIIIllIlIllI, llllllllllllllIlllIllIIIllIlIlIl, 1, 0, true);
        }
        
        public static Corridor5 func_175877_a(final List llllllllllllllIlllIllIIIllIIllII, final Random llllllllllllllIlllIllIIIllIIlIll, final int llllllllllllllIlllIllIIIllIIIIlI, final int llllllllllllllIlllIllIIIllIIIIIl, final int llllllllllllllIlllIllIIIllIIlIII, final EnumFacing llllllllllllllIlllIllIIIllIIIlll, final int llllllllllllllIlllIllIIIlIlllllI) {
            final StructureBoundingBox llllllllllllllIlllIllIIIllIIIlIl = StructureBoundingBox.func_175897_a(llllllllllllllIlllIllIIIllIIIIlI, llllllllllllllIlllIllIIIllIIIIIl, llllllllllllllIlllIllIIIllIIlIII, -1, 0, 0, 5, 7, 5, llllllllllllllIlllIllIIIllIIIlll);
            return (Piece.isAboveGround(llllllllllllllIlllIllIIIllIIIlIl) && StructureComponent.findIntersecting(llllllllllllllIlllIllIIIllIIllII, llllllllllllllIlllIllIIIllIIIlIl) == null) ? new Corridor5(llllllllllllllIlllIllIIIlIlllllI, llllllllllllllIlllIllIIIllIIlIll, llllllllllllllIlllIllIIIllIIIlIl, llllllllllllllIlllIllIIIllIIIlll) : null;
        }
        
        public Corridor5() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlllIllIIIlIllIllI, final Random llllllllllllllIlllIllIIIlIllIlIl, final StructureBoundingBox llllllllllllllIlllIllIIIlIlIllll) {
            this.func_175804_a(llllllllllllllIlllIllIIIlIllIllI, llllllllllllllIlllIllIIIlIlIllll, 0, 0, 0, 4, 1, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllIllIIIlIllIllI, llllllllllllllIlllIllIIIlIlIllll, 0, 2, 0, 4, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllIllIIIlIllIllI, llllllllllllllIlllIllIIIlIlIllll, 0, 2, 0, 0, 5, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllIllIIIlIllIllI, llllllllllllllIlllIllIIIlIlIllll, 4, 2, 0, 4, 5, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllIllIIIlIllIllI, llllllllllllllIlllIllIIIlIlIllll, 0, 3, 1, 0, 4, 1, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllIllIIIlIllIllI, llllllllllllllIlllIllIIIlIlIllll, 0, 3, 3, 0, 4, 3, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllIllIIIlIllIllI, llllllllllllllIlllIllIIIlIlIllll, 4, 3, 1, 4, 4, 1, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllIllIIIlIllIllI, llllllllllllllIlllIllIIIlIlIllll, 4, 3, 3, 4, 4, 3, Blocks.nether_brick_fence.getDefaultState(), Blocks.nether_brick_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllIllIIIlIllIllI, llllllllllllllIlllIllIIIlIlIllll, 0, 6, 0, 4, 6, 4, Blocks.nether_brick.getDefaultState(), Blocks.nether_brick.getDefaultState(), false);
            for (int llllllllllllllIlllIllIIIlIllIIll = 0; llllllllllllllIlllIllIIIlIllIIll <= 4; ++llllllllllllllIlllIllIIIlIllIIll) {
                for (int llllllllllllllIlllIllIIIlIllIIlI = 0; llllllllllllllIlllIllIIIlIllIIlI <= 4; ++llllllllllllllIlllIllIIIlIllIIlI) {
                    this.func_175808_b(llllllllllllllIlllIllIIIlIllIllI, Blocks.nether_brick.getDefaultState(), llllllllllllllIlllIllIIIlIllIIll, -1, llllllllllllllIlllIllIIIlIllIIlI, llllllllllllllIlllIllIIIlIlIllll);
                }
            }
            return true;
        }
    }
}
