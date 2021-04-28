package net.minecraft.world.gen.structure;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import com.google.common.collect.*;
import java.util.*;

public class StructureOceanMonumentPieces
{
    static {
        __OBFID = "CL_00001994";
    }
    
    public static void func_175970_a() {
        MapGenStructureIO.registerStructureComponent(MonumentBuilding.class, "OMB");
        MapGenStructureIO.registerStructureComponent(MonumentCoreRoom.class, "OMCR");
        MapGenStructureIO.registerStructureComponent(DoubleXRoom.class, "OMDXR");
        MapGenStructureIO.registerStructureComponent(DoubleXYRoom.class, "OMDXYR");
        MapGenStructureIO.registerStructureComponent(DoubleYRoom.class, "OMDYR");
        MapGenStructureIO.registerStructureComponent(DoubleYZRoom.class, "OMDYZR");
        MapGenStructureIO.registerStructureComponent(DoubleZRoom.class, "OMDZR");
        MapGenStructureIO.registerStructureComponent(EntryRoom.class, "OMEntry");
        MapGenStructureIO.registerStructureComponent(Penthouse.class, "OMPenthouse");
        MapGenStructureIO.registerStructureComponent(SimpleRoom.class, "OMSimple");
        MapGenStructureIO.registerStructureComponent(SimpleTopRoom.class, "OMSimpleT");
    }
    
    public static class Penthouse extends Piece
    {
        public Penthouse(final EnumFacing llllllllllllllllIIlIIlllIIlIIIll, final StructureBoundingBox llllllllllllllllIIlIIlllIIlIIlIl) {
            super(llllllllllllllllIIlIIlllIIlIIIll, llllllllllllllllIIlIIlllIIlIIlIl);
        }
        
        static {
            __OBFID = "CL_00001977";
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIIlIIlllIIIllIlI, final Random llllllllllllllllIIlIIlllIIIllIIl, final StructureBoundingBox llllllllllllllllIIlIIlllIIIllIII) {
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 2, -1, 2, 11, -1, 11, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 0, -1, 0, 1, -1, 11, Penthouse.field_175828_a, Penthouse.field_175828_a, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 12, -1, 0, 13, -1, 11, Penthouse.field_175828_a, Penthouse.field_175828_a, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 2, -1, 0, 11, -1, 1, Penthouse.field_175828_a, Penthouse.field_175828_a, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 2, -1, 12, 11, -1, 13, Penthouse.field_175828_a, Penthouse.field_175828_a, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 0, 0, 0, 0, 0, 13, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 13, 0, 0, 13, 0, 13, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 1, 0, 0, 12, 0, 0, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 1, 0, 13, 12, 0, 13, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
            for (int llllllllllllllllIIlIIlllIIIlIlll = 2; llllllllllllllllIIlIIlllIIIlIlll <= 11; llllllllllllllllIIlIIlllIIIlIlll += 3) {
                this.func_175811_a(llllllllllllllllIIlIIlllIIIllIlI, Penthouse.field_175825_e, 0, 0, llllllllllllllllIIlIIlllIIIlIlll, llllllllllllllllIIlIIlllIIIllIII);
                this.func_175811_a(llllllllllllllllIIlIIlllIIIllIlI, Penthouse.field_175825_e, 13, 0, llllllllllllllllIIlIIlllIIIlIlll, llllllllllllllllIIlIIlllIIIllIII);
                this.func_175811_a(llllllllllllllllIIlIIlllIIIllIlI, Penthouse.field_175825_e, llllllllllllllllIIlIIlllIIIlIlll, 0, 0, llllllllllllllllIIlIIlllIIIllIII);
            }
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 2, 0, 3, 4, 0, 9, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 9, 0, 3, 11, 0, 9, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 4, 0, 9, 9, 0, 11, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
            this.func_175811_a(llllllllllllllllIIlIIlllIIIllIlI, Penthouse.field_175826_b, 5, 0, 8, llllllllllllllllIIlIIlllIIIllIII);
            this.func_175811_a(llllllllllllllllIIlIIlllIIIllIlI, Penthouse.field_175826_b, 8, 0, 8, llllllllllllllllIIlIIlllIIIllIII);
            this.func_175811_a(llllllllllllllllIIlIIlllIIIllIlI, Penthouse.field_175826_b, 10, 0, 10, llllllllllllllllIIlIIlllIIIllIII);
            this.func_175811_a(llllllllllllllllIIlIIlllIIIllIlI, Penthouse.field_175826_b, 3, 0, 10, llllllllllllllllIIlIIlllIIIllIII);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 3, 0, 3, 3, 0, 7, Penthouse.field_175827_c, Penthouse.field_175827_c, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 10, 0, 3, 10, 0, 7, Penthouse.field_175827_c, Penthouse.field_175827_c, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 6, 0, 10, 7, 0, 10, Penthouse.field_175827_c, Penthouse.field_175827_c, false);
            byte llllllllllllllllIIlIIlllIIIlIllI = 3;
            for (int llllllllllllllllIIlIIlllIIIlIlIl = 0; llllllllllllllllIIlIIlllIIIlIlIl < 2; ++llllllllllllllllIIlIIlllIIIlIlIl) {
                for (int llllllllllllllllIIlIIlllIIIlIlII = 2; llllllllllllllllIIlIIlllIIIlIlII <= 8; llllllllllllllllIIlIIlllIIIlIlII += 3) {
                    this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, llllllllllllllllIIlIIlllIIIlIllI, 0, llllllllllllllllIIlIIlllIIIlIlII, llllllllllllllllIIlIIlllIIIlIllI, 2, llllllllllllllllIIlIIlllIIIlIlII, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
                }
                llllllllllllllllIIlIIlllIIIlIllI = 10;
            }
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 5, 0, 10, 5, 2, 10, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 8, 0, 10, 8, 2, 10, Penthouse.field_175826_b, Penthouse.field_175826_b, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 6, -1, 7, 7, -1, 8, Penthouse.field_175827_c, Penthouse.field_175827_c, false);
            this.func_175804_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 6, -1, 3, 7, -1, 4, Penthouse.field_175822_f, Penthouse.field_175822_f, false);
            this.func_175817_a(llllllllllllllllIIlIIlllIIIllIlI, llllllllllllllllIIlIIlllIIIllIII, 6, 1, 6);
            return true;
        }
        
        public Penthouse() {
        }
    }
    
    public abstract static class Piece extends StructureComponent
    {
        protected /* synthetic */ RoomDefinition field_175830_k;
        protected static final /* synthetic */ int field_175831_h;
        protected static final /* synthetic */ IBlockState field_175822_f;
        protected static final /* synthetic */ IBlockState field_175825_e;
        protected static final /* synthetic */ int field_175823_g;
        protected static final /* synthetic */ int field_175829_j;
        protected static final /* synthetic */ IBlockState field_175827_c;
        protected static final /* synthetic */ IBlockState field_175826_b;
        protected static final /* synthetic */ IBlockState field_175824_d;
        protected static final /* synthetic */ int field_175832_i;
        protected static final /* synthetic */ IBlockState field_175828_a;
        
        protected Piece(final int llllllllllllllIllIIllIIIIIlllIll, final EnumFacing llllllllllllllIllIIllIIIIIlllIlI, final RoomDefinition llllllllllllllIllIIllIIIIIlIlllI, final int llllllllllllllIllIIllIIIIIlllIII, final int llllllllllllllIllIIllIIIIIlIllII, final int llllllllllllllIllIIllIIIIIlIlIll) {
            super(llllllllllllllIllIIllIIIIIlllIll);
            this.coordBaseMode = llllllllllllllIllIIllIIIIIlllIlI;
            this.field_175830_k = llllllllllllllIllIIllIIIIIlIlllI;
            final int llllllllllllllIllIIllIIIIIllIlIl = llllllllllllllIllIIllIIIIIlIlllI.field_175967_a;
            final int llllllllllllllIllIIllIIIIIllIlII = llllllllllllllIllIIllIIIIIllIlIl % 5;
            final int llllllllllllllIllIIllIIIIIllIIll = llllllllllllllIllIIllIIIIIllIlIl / 5 % 5;
            final int llllllllllllllIllIIllIIIIIllIIlI = llllllllllllllIllIIllIIIIIllIlIl / 25;
            if (llllllllllllllIllIIllIIIIIlllIlI != EnumFacing.NORTH && llllllllllllllIllIIllIIIIIlllIlI != EnumFacing.SOUTH) {
                this.boundingBox = new StructureBoundingBox(0, 0, 0, llllllllllllllIllIIllIIIIIlIlIll * 8 - 1, llllllllllllllIllIIllIIIIIlIllII * 4 - 1, llllllllllllllIllIIllIIIIIlllIII * 8 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(0, 0, 0, llllllllllllllIllIIllIIIIIlllIII * 8 - 1, llllllllllllllIllIIllIIIIIlIllII * 4 - 1, llllllllllllllIllIIllIIIIIlIlIll * 8 - 1);
            }
            switch (StructureOceanMonumentPieces.SwitchEnumFacing.field_175971_a[llllllllllllllIllIIllIIIIIlllIlI.ordinal()]) {
                case 1: {
                    this.boundingBox.offset(llllllllllllllIllIIllIIIIIllIlII * 8, llllllllllllllIllIIllIIIIIllIIlI * 4, -(llllllllllllllIllIIllIIIIIllIIll + llllllllllllllIllIIllIIIIIlIlIll) * 8 + 1);
                    break;
                }
                case 2: {
                    this.boundingBox.offset(llllllllllllllIllIIllIIIIIllIlII * 8, llllllllllllllIllIIllIIIIIllIIlI * 4, llllllllllllllIllIIllIIIIIllIIll * 8);
                    break;
                }
                case 3: {
                    this.boundingBox.offset(-(llllllllllllllIllIIllIIIIIllIIll + llllllllllllllIllIIllIIIIIlIlIll) * 8 + 1, llllllllllllllIllIIllIIIIIllIIlI * 4, llllllllllllllIllIIllIIIIIllIlII * 8);
                    break;
                }
                default: {
                    this.boundingBox.offset(llllllllllllllIllIIllIIIIIllIIll * 8, llllllllllllllIllIIllIIIIIllIIlI * 4, llllllllllllllIllIIllIIIIIllIlII * 8);
                    break;
                }
            }
        }
        
        public Piece(final int llllllllllllllIllIIllIIIIlIlIIIl) {
            super(llllllllllllllIllIIllIIIIlIlIIIl);
        }
        
        protected static final int func_175820_a(final int llllllllllllllIllIIllIIIIlIlllII, final int llllllllllllllIllIIllIIIIlIllllI, final int llllllllllllllIllIIllIIIIlIllIlI) {
            return llllllllllllllIllIIllIIIIlIllllI * 25 + llllllllllllllIllIIllIIIIlIllIlI * 5 + llllllllllllllIllIIllIIIIlIlllII;
        }
        
        protected void func_175821_a(final World llllllllllllllIllIIllIIIIIIllIll, final StructureBoundingBox llllllllllllllIllIIllIIIIIIllIlI, final int llllllllllllllIllIIllIIIIIIllIIl, final int llllllllllllllIllIIllIIIIIIllIII, final boolean llllllllllllllIllIIllIIIIIIlIlll) {
            if (llllllllllllllIllIIllIIIIIIlIlll) {
                this.func_175804_a(llllllllllllllIllIIllIIIIIIllIll, llllllllllllllIllIIllIIIIIIllIlI, llllllllllllllIllIIllIIIIIIllIIl + 0, 0, llllllllllllllIllIIllIIIIIIllIII + 0, llllllllllllllIllIIllIIIIIIllIIl + 2, 0, llllllllllllllIllIIllIIIIIIllIII + 8 - 1, Piece.field_175828_a, Piece.field_175828_a, false);
                this.func_175804_a(llllllllllllllIllIIllIIIIIIllIll, llllllllllllllIllIIllIIIIIIllIlI, llllllllllllllIllIIllIIIIIIllIIl + 5, 0, llllllllllllllIllIIllIIIIIIllIII + 0, llllllllllllllIllIIllIIIIIIllIIl + 8 - 1, 0, llllllllllllllIllIIllIIIIIIllIII + 8 - 1, Piece.field_175828_a, Piece.field_175828_a, false);
                this.func_175804_a(llllllllllllllIllIIllIIIIIIllIll, llllllllllllllIllIIllIIIIIIllIlI, llllllllllllllIllIIllIIIIIIllIIl + 3, 0, llllllllllllllIllIIllIIIIIIllIII + 0, llllllllllllllIllIIllIIIIIIllIIl + 4, 0, llllllllllllllIllIIllIIIIIIllIII + 2, Piece.field_175828_a, Piece.field_175828_a, false);
                this.func_175804_a(llllllllllllllIllIIllIIIIIIllIll, llllllllllllllIllIIllIIIIIIllIlI, llllllllllllllIllIIllIIIIIIllIIl + 3, 0, llllllllllllllIllIIllIIIIIIllIII + 5, llllllllllllllIllIIllIIIIIIllIIl + 4, 0, llllllllllllllIllIIllIIIIIIllIII + 8 - 1, Piece.field_175828_a, Piece.field_175828_a, false);
                this.func_175804_a(llllllllllllllIllIIllIIIIIIllIll, llllllllllllllIllIIllIIIIIIllIlI, llllllllllllllIllIIllIIIIIIllIIl + 3, 0, llllllllllllllIllIIllIIIIIIllIII + 2, llllllllllllllIllIIllIIIIIIllIIl + 4, 0, llllllllllllllIllIIllIIIIIIllIII + 2, Piece.field_175826_b, Piece.field_175826_b, false);
                this.func_175804_a(llllllllllllllIllIIllIIIIIIllIll, llllllllllllllIllIIllIIIIIIllIlI, llllllllllllllIllIIllIIIIIIllIIl + 3, 0, llllllllllllllIllIIllIIIIIIllIII + 5, llllllllllllllIllIIllIIIIIIllIIl + 4, 0, llllllllllllllIllIIllIIIIIIllIII + 5, Piece.field_175826_b, Piece.field_175826_b, false);
                this.func_175804_a(llllllllllllllIllIIllIIIIIIllIll, llllllllllllllIllIIllIIIIIIllIlI, llllllllllllllIllIIllIIIIIIllIIl + 2, 0, llllllllllllllIllIIllIIIIIIllIII + 3, llllllllllllllIllIIllIIIIIIllIIl + 2, 0, llllllllllllllIllIIllIIIIIIllIII + 4, Piece.field_175826_b, Piece.field_175826_b, false);
                this.func_175804_a(llllllllllllllIllIIllIIIIIIllIll, llllllllllllllIllIIllIIIIIIllIlI, llllllllllllllIllIIllIIIIIIllIIl + 5, 0, llllllllllllllIllIIllIIIIIIllIII + 3, llllllllllllllIllIIllIIIIIIllIIl + 5, 0, llllllllllllllIllIIllIIIIIIllIII + 4, Piece.field_175826_b, Piece.field_175826_b, false);
            }
            else {
                this.func_175804_a(llllllllllllllIllIIllIIIIIIllIll, llllllllllllllIllIIllIIIIIIllIlI, llllllllllllllIllIIllIIIIIIllIIl + 0, 0, llllllllllllllIllIIllIIIIIIllIII + 0, llllllllllllllIllIIllIIIIIIllIIl + 8 - 1, 0, llllllllllllllIllIIllIIIIIIllIII + 8 - 1, Piece.field_175828_a, Piece.field_175828_a, false);
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIllIIllIIIIIlIIlIl) {
        }
        
        public Piece() {
            super(0);
        }
        
        protected void func_175819_a(final World llllllllllllllIllIIlIlllllllIlIl, final StructureBoundingBox llllllllllllllIllIIllIIIIIIIIIIl, final int llllllllllllllIllIIlIlllllllIIll, final int llllllllllllllIllIIlIlllllllIIlI, final int llllllllllllllIllIIlIllllllllllI, final int llllllllllllllIllIIlIlllllllllIl, final int llllllllllllllIllIIlIllllllIllll, final int llllllllllllllIllIIlIllllllIlllI, final IBlockState llllllllllllllIllIIlIllllllIllIl) {
            for (int llllllllllllllIllIIlIllllllllIIl = llllllllllllllIllIIlIlllllllIIlI; llllllllllllllIllIIlIllllllllIIl <= llllllllllllllIllIIlIllllllIllll; ++llllllllllllllIllIIlIllllllllIIl) {
                for (int llllllllllllllIllIIlIllllllllIII = llllllllllllllIllIIlIlllllllIIll; llllllllllllllIllIIlIllllllllIII <= llllllllllllllIllIIlIlllllllllIl; ++llllllllllllllIllIIlIllllllllIII) {
                    for (int llllllllllllllIllIIlIlllllllIlll = llllllllllllllIllIIlIllllllllllI; llllllllllllllIllIIlIlllllllIlll <= llllllllllllllIllIIlIllllllIlllI; ++llllllllllllllIllIIlIlllllllIlll) {
                        if (this.func_175807_a(llllllllllllllIllIIlIlllllllIlIl, llllllllllllllIllIIlIllllllllIII, llllllllllllllIllIIlIllllllllIIl, llllllllllllllIllIIlIlllllllIlll, llllllllllllllIllIIllIIIIIIIIIIl) == Piece.field_175822_f) {
                            this.func_175811_a(llllllllllllllIllIIlIlllllllIlIl, llllllllllllllIllIIlIllllllIllIl, llllllllllllllIllIIlIllllllllIII, llllllllllllllIllIIlIllllllllIIl, llllllllllllllIllIIlIlllllllIlll, llllllllllllllIllIIllIIIIIIIIIIl);
                        }
                    }
                }
            }
        }
        
        protected boolean func_175818_a(final StructureBoundingBox llllllllllllllIllIIlIlllllIlIlII, final int llllllllllllllIllIIlIlllllIlllIl, final int llllllllllllllIllIIlIlllllIlllII, final int llllllllllllllIllIIlIlllllIlIIIl, final int llllllllllllllIllIIlIlllllIlIIII) {
            final int llllllllllllllIllIIlIlllllIllIIl = this.getXWithOffset(llllllllllllllIllIIlIlllllIlllIl, llllllllllllllIllIIlIlllllIlllII);
            final int llllllllllllllIllIIlIlllllIllIII = this.getZWithOffset(llllllllllllllIllIIlIlllllIlllIl, llllllllllllllIllIIlIlllllIlllII);
            final int llllllllllllllIllIIlIlllllIlIlll = this.getXWithOffset(llllllllllllllIllIIlIlllllIlIIIl, llllllllllllllIllIIlIlllllIlIIII);
            final int llllllllllllllIllIIlIlllllIlIllI = this.getZWithOffset(llllllllllllllIllIIlIlllllIlIIIl, llllllllllllllIllIIlIlllllIlIIII);
            return llllllllllllllIllIIlIlllllIlIlII.intersectsWith(Math.min(llllllllllllllIllIIlIlllllIllIIl, llllllllllllllIllIIlIlllllIlIlll), Math.min(llllllllllllllIllIIlIlllllIllIII, llllllllllllllIllIIlIlllllIlIllI), Math.max(llllllllllllllIllIIlIlllllIllIIl, llllllllllllllIllIIlIlllllIlIlll), Math.max(llllllllllllllIllIIlIlllllIllIII, llllllllllllllIllIIlIlllllIlIllI));
        }
        
        public Piece(final EnumFacing llllllllllllllIllIIllIIIIlIIlIIl, final StructureBoundingBox llllllllllllllIllIIllIIIIlIIlIll) {
            super(1);
            this.coordBaseMode = llllllllllllllIllIIllIIIIlIIlIIl;
            this.boundingBox = llllllllllllllIllIIllIIIIlIIlIll;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIllIIllIIIIIlIIIll) {
        }
        
        protected boolean func_175817_a(final World llllllllllllllIllIIlIlllllIIIIII, final StructureBoundingBox llllllllllllllIllIIlIllllIllIlIl, final int llllllllllllllIllIIlIllllIllIlII, final int llllllllllllllIllIIlIllllIllllIl, final int llllllllllllllIllIIlIllllIllIIlI) {
            final int llllllllllllllIllIIlIllllIlllIll = this.getXWithOffset(llllllllllllllIllIIlIllllIllIlII, llllllllllllllIllIIlIllllIllIIlI);
            final int llllllllllllllIllIIlIllllIlllIlI = this.getYWithOffset(llllllllllllllIllIIlIllllIllllIl);
            final int llllllllllllllIllIIlIllllIlllIIl = this.getZWithOffset(llllllllllllllIllIIlIllllIllIlII, llllllllllllllIllIIlIllllIllIIlI);
            if (llllllllllllllIllIIlIllllIllIlIl.func_175898_b(new BlockPos(llllllllllllllIllIIlIllllIlllIll, llllllllllllllIllIIlIllllIlllIlI, llllllllllllllIllIIlIllllIlllIIl))) {
                final EntityGuardian llllllllllllllIllIIlIllllIlllIII = new EntityGuardian(llllllllllllllIllIIlIlllllIIIIII);
                llllllllllllllIllIIlIllllIlllIII.func_175467_a(true);
                llllllllllllllIllIIlIllllIlllIII.heal(llllllllllllllIllIIlIllllIlllIII.getMaxHealth());
                llllllllllllllIllIIlIllllIlllIII.setLocationAndAngles(llllllllllllllIllIIlIllllIlllIll + 0.5, llllllllllllllIllIIlIllllIlllIlI, llllllllllllllIllIIlIllllIlllIIl + 0.5, 0.0f, 0.0f);
                llllllllllllllIllIIlIllllIlllIII.func_180482_a(llllllllllllllIllIIlIlllllIIIIII.getDifficultyForLocation(new BlockPos(llllllllllllllIllIIlIllllIlllIII)), null);
                llllllllllllllIllIIlIlllllIIIIII.spawnEntityInWorld(llllllllllllllIllIIlIllllIlllIII);
                return true;
            }
            return false;
        }
        
        static {
            __OBFID = "CL_00001976";
            field_175828_a = Blocks.prismarine.getStateFromMeta(BlockPrismarine.ROUGHMETA);
            field_175826_b = Blocks.prismarine.getStateFromMeta(BlockPrismarine.BRICKSMETA);
            field_175827_c = Blocks.prismarine.getStateFromMeta(BlockPrismarine.DARKMETA);
            field_175824_d = Piece.field_175826_b;
            field_175825_e = Blocks.sea_lantern.getDefaultState();
            field_175822_f = Blocks.water.getDefaultState();
            field_175823_g = func_175820_a(2, 0, 0);
            field_175831_h = func_175820_a(2, 2, 0);
            field_175832_i = func_175820_a(0, 1, 0);
            field_175829_j = func_175820_a(4, 1, 0);
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_175971_a;
        
        static {
            __OBFID = "CL_00001993";
            field_175971_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_175971_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_175971_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_175971_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
        }
    }
    
    static class RoomDefinition
    {
        /* synthetic */ boolean field_175964_e;
        /* synthetic */ int field_175962_f;
        /* synthetic */ RoomDefinition[] field_175965_b;
        /* synthetic */ boolean field_175963_d;
        /* synthetic */ int field_175967_a;
        /* synthetic */ boolean[] field_175966_c;
        
        public void func_175957_a(final EnumFacing llllllllllllllIlIlIlllllIllllIll, final RoomDefinition llllllllllllllIlIlIlllllIllllIlI) {
            this.field_175965_b[llllllllllllllIlIlIlllllIllllIll.getIndex()] = llllllllllllllIlIlIlllllIllllIlI;
            llllllllllllllIlIlIlllllIllllIlI.field_175965_b[llllllllllllllIlIlIlllllIllllIll.getOpposite().getIndex()] = this;
        }
        
        public void func_175958_a() {
            for (int llllllllllllllIlIlIlllllIlllIllI = 0; llllllllllllllIlIlIlllllIlllIllI < 6; ++llllllllllllllIlIlIlllllIlllIllI) {
                this.field_175966_c[llllllllllllllIlIlIlllllIlllIllI] = (this.field_175965_b[llllllllllllllIlIlIlllllIlllIllI] != null);
            }
        }
        
        static {
            __OBFID = "CL_00001972";
        }
        
        public boolean func_175961_b() {
            return this.field_175967_a >= 75;
        }
        
        public boolean func_175959_a(final int llllllllllllllIlIlIlllllIllIllll) {
            if (this.field_175964_e) {
                return true;
            }
            this.field_175962_f = llllllllllllllIlIlIlllllIllIllll;
            for (int llllllllllllllIlIlIlllllIllIlllI = 0; llllllllllllllIlIlIlllllIllIlllI < 6; ++llllllllllllllIlIlIlllllIllIlllI) {
                if (this.field_175965_b[llllllllllllllIlIlIlllllIllIlllI] != null && this.field_175966_c[llllllllllllllIlIlIlllllIllIlllI] && this.field_175965_b[llllllllllllllIlIlIlllllIllIlllI].field_175962_f != llllllllllllllIlIlIlllllIllIllll && this.field_175965_b[llllllllllllllIlIlIlllllIllIlllI].func_175959_a(llllllllllllllIlIlIlllllIllIllll)) {
                    return true;
                }
            }
            return false;
        }
        
        public RoomDefinition(final int llllllllllllllIlIlIllllllIIIIIll) {
            this.field_175965_b = new RoomDefinition[6];
            this.field_175966_c = new boolean[6];
            this.field_175967_a = llllllllllllllIlIlIllllllIIIIIll;
        }
        
        public int func_175960_c() {
            int llllllllllllllIlIlIlllllIllIIIll = 0;
            for (int llllllllllllllIlIlIlllllIllIIIlI = 0; llllllllllllllIlIlIlllllIllIIIlI < 6; ++llllllllllllllIlIlIlllllIllIIIlI) {
                if (this.field_175966_c[llllllllllllllIlIlIlllllIllIIIlI]) {
                    ++llllllllllllllIlIlIlllllIllIIIll;
                }
            }
            return llllllllllllllIlIlIlllllIllIIIll;
        }
    }
    
    public static class DoubleXYRoom extends Piece
    {
        public DoubleXYRoom() {
        }
        
        static {
            __OBFID = "CL_00001982";
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIIIIIllIlIIlIIIII, final Random lllllllllllllllIIIIIllIlIIlIlIIl, final StructureBoundingBox lllllllllllllllIIIIIllIlIIlIlIII) {
            final RoomDefinition lllllllllllllllIIIIIllIlIIlIIlll = this.field_175830_k.field_175965_b[EnumFacing.EAST.getIndex()];
            final RoomDefinition lllllllllllllllIIIIIllIlIIlIIllI = this.field_175830_k;
            final RoomDefinition lllllllllllllllIIIIIllIlIIlIIlIl = lllllllllllllllIIIIIllIlIIlIIllI.field_175965_b[EnumFacing.UP.getIndex()];
            final RoomDefinition lllllllllllllllIIIIIllIlIIlIIlII = lllllllllllllllIIIIIllIlIIlIIlll.field_175965_b[EnumFacing.UP.getIndex()];
            if (this.field_175830_k.field_175967_a / 25 > 0) {
                this.func_175821_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 8, 0, lllllllllllllllIIIIIllIlIIlIIlll.field_175966_c[EnumFacing.DOWN.getIndex()]);
                this.func_175821_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 0, 0, lllllllllllllllIIIIIllIlIIlIIllI.field_175966_c[EnumFacing.DOWN.getIndex()]);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlIl.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 1, 8, 1, 7, 8, 6, DoubleXYRoom.field_175828_a);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlII.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 8, 8, 1, 14, 8, 6, DoubleXYRoom.field_175828_a);
            }
            for (int lllllllllllllllIIIIIllIlIIlIIIll = 1; lllllllllllllllIIIIIllIlIIlIIIll <= 7; ++lllllllllllllllIIIIIllIlIIlIIIll) {
                IBlockState lllllllllllllllIIIIIllIlIIlIIIlI = DoubleXYRoom.field_175826_b;
                if (lllllllllllllllIIIIIllIlIIlIIIll == 2 || lllllllllllllllIIIIIllIlIIlIIIll == 6) {
                    lllllllllllllllIIIIIllIlIIlIIIlI = DoubleXYRoom.field_175828_a;
                }
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 0, lllllllllllllllIIIIIllIlIIlIIIll, 0, 0, lllllllllllllllIIIIIllIlIIlIIIll, 7, lllllllllllllllIIIIIllIlIIlIIIlI, lllllllllllllllIIIIIllIlIIlIIIlI, false);
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 15, lllllllllllllllIIIIIllIlIIlIIIll, 0, 15, lllllllllllllllIIIIIllIlIIlIIIll, 7, lllllllllllllllIIIIIllIlIIlIIIlI, lllllllllllllllIIIIIllIlIIlIIIlI, false);
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 1, lllllllllllllllIIIIIllIlIIlIIIll, 0, 15, lllllllllllllllIIIIIllIlIIlIIIll, 0, lllllllllllllllIIIIIllIlIIlIIIlI, lllllllllllllllIIIIIllIlIIlIIIlI, false);
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 1, lllllllllllllllIIIIIllIlIIlIIIll, 7, 14, lllllllllllllllIIIIIllIlIIlIIIll, 7, lllllllllllllllIIIIIllIlIIlIIIlI, lllllllllllllllIIIIIllIlIIlIIIlI, false);
            }
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 2, 1, 3, 2, 7, 4, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 3, 1, 2, 4, 7, 2, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 3, 1, 5, 4, 7, 5, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 13, 1, 3, 13, 7, 4, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 11, 1, 2, 12, 7, 2, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 11, 1, 5, 12, 7, 5, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 5, 1, 3, 5, 3, 4, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 10, 1, 3, 10, 3, 4, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 5, 7, 2, 10, 7, 5, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 5, 5, 2, 5, 7, 2, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 10, 5, 2, 10, 7, 2, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 5, 5, 5, 5, 7, 5, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 10, 5, 5, 10, 7, 5, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175811_a(lllllllllllllllIIIIIllIlIIlIIIII, DoubleXYRoom.field_175826_b, 6, 6, 2, lllllllllllllllIIIIIllIlIIlIlIII);
            this.func_175811_a(lllllllllllllllIIIIIllIlIIlIIIII, DoubleXYRoom.field_175826_b, 9, 6, 2, lllllllllllllllIIIIIllIlIIlIlIII);
            this.func_175811_a(lllllllllllllllIIIIIllIlIIlIIIII, DoubleXYRoom.field_175826_b, 6, 6, 5, lllllllllllllllIIIIIllIlIIlIlIII);
            this.func_175811_a(lllllllllllllllIIIIIllIlIIlIIIII, DoubleXYRoom.field_175826_b, 9, 6, 5, lllllllllllllllIIIIIllIlIIlIlIII);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 5, 4, 3, 6, 4, 4, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 9, 4, 3, 10, 4, 4, DoubleXYRoom.field_175826_b, DoubleXYRoom.field_175826_b, false);
            this.func_175811_a(lllllllllllllllIIIIIllIlIIlIIIII, DoubleXYRoom.field_175825_e, 5, 4, 2, lllllllllllllllIIIIIllIlIIlIlIII);
            this.func_175811_a(lllllllllllllllIIIIIllIlIIlIIIII, DoubleXYRoom.field_175825_e, 5, 4, 5, lllllllllllllllIIIIIllIlIIlIlIII);
            this.func_175811_a(lllllllllllllllIIIIIllIlIIlIIIII, DoubleXYRoom.field_175825_e, 10, 4, 2, lllllllllllllllIIIIIllIlIIlIlIII);
            this.func_175811_a(lllllllllllllllIIIIIllIlIIlIIIII, DoubleXYRoom.field_175825_e, 10, 4, 5, lllllllllllllllIIIIIllIlIIlIlIII);
            if (lllllllllllllllIIIIIllIlIIlIIllI.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 3, 1, 0, 4, 2, 0, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIllI.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 3, 1, 7, 4, 2, 7, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIllI.field_175966_c[EnumFacing.WEST.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 0, 1, 3, 0, 2, 4, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlll.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 11, 1, 0, 12, 2, 0, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlll.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 11, 1, 7, 12, 2, 7, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlll.field_175966_c[EnumFacing.EAST.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 15, 1, 3, 15, 2, 4, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlIl.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 3, 5, 0, 4, 6, 0, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlIl.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 3, 5, 7, 4, 6, 7, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlIl.field_175966_c[EnumFacing.WEST.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 0, 5, 3, 0, 6, 4, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlII.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 11, 5, 0, 12, 6, 0, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlII.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 11, 5, 7, 12, 6, 7, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllIlIIlIIlII.field_175966_c[EnumFacing.EAST.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllIlIIlIIIII, lllllllllllllllIIIIIllIlIIlIlIII, 15, 5, 3, 15, 6, 4, DoubleXYRoom.field_175822_f, DoubleXYRoom.field_175822_f, false);
            }
            return true;
        }
        
        public DoubleXYRoom(final EnumFacing lllllllllllllllIIIIIllIlIIlllIlI, final RoomDefinition lllllllllllllllIIIIIllIlIIllIlIl, final Random lllllllllllllllIIIIIllIlIIlllIII) {
            super(1, lllllllllllllllIIIIIllIlIIlllIlI, lllllllllllllllIIIIIllIlIIllIlIl, 2, 2, 1);
        }
    }
    
    static class YZDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        private YZDoubleRoomFitHelper() {
        }
        
        @Override
        public Piece func_175968_a(final EnumFacing lllllllllllllllllIllIlIIlIIlIIlI, final RoomDefinition lllllllllllllllllIllIlIIlIIlIIIl, final Random lllllllllllllllllIllIlIIlIIlIIII) {
            lllllllllllllllllIllIlIIlIIlIIIl.field_175963_d = true;
            lllllllllllllllllIllIlIIlIIlIIIl.field_175965_b[EnumFacing.NORTH.getIndex()].field_175963_d = true;
            lllllllllllllllllIllIlIIlIIlIIIl.field_175965_b[EnumFacing.UP.getIndex()].field_175963_d = true;
            lllllllllllllllllIllIlIIlIIlIIIl.field_175965_b[EnumFacing.NORTH.getIndex()].field_175965_b[EnumFacing.UP.getIndex()].field_175963_d = true;
            return new DoubleYZRoom(lllllllllllllllllIllIlIIlIIlIIlI, lllllllllllllllllIllIlIIlIIlIIIl, lllllllllllllllllIllIlIIlIIlIIII);
        }
        
        static {
            __OBFID = "CL_00001989";
        }
        
        @Override
        public boolean func_175969_a(final RoomDefinition lllllllllllllllllIllIlIIlIIllIlI) {
            if (lllllllllllllllllIllIlIIlIIllIlI.field_175966_c[EnumFacing.NORTH.getIndex()] && !lllllllllllllllllIllIlIIlIIllIlI.field_175965_b[EnumFacing.NORTH.getIndex()].field_175963_d && lllllllllllllllllIllIlIIlIIllIlI.field_175966_c[EnumFacing.UP.getIndex()] && !lllllllllllllllllIllIlIIlIIllIlI.field_175965_b[EnumFacing.UP.getIndex()].field_175963_d) {
                final RoomDefinition lllllllllllllllllIllIlIIlIIllIIl = lllllllllllllllllIllIlIIlIIllIlI.field_175965_b[EnumFacing.NORTH.getIndex()];
                return lllllllllllllllllIllIlIIlIIllIIl.field_175966_c[EnumFacing.UP.getIndex()] && !lllllllllllllllllIllIlIIlIIllIIl.field_175965_b[EnumFacing.UP.getIndex()].field_175963_d;
            }
            return false;
        }
        
        YZDoubleRoomFitHelper(final SwitchEnumFacing lllllllllllllllllIllIlIIlIIIlIlI) {
            this();
        }
    }
    
    public static class DoubleYZRoom extends Piece
    {
        public DoubleYZRoom(final EnumFacing llllllllllllllIlIIIlIIIlIlIIlIIl, final RoomDefinition llllllllllllllIlIIIlIIIlIlIIIlII, final Random llllllllllllllIlIIIlIIIlIlIIIlll) {
            super(1, llllllllllllllIlIIIlIIIlIlIIlIIl, llllllllllllllIlIIIlIIIlIlIIIlII, 1, 2, 2);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIIIlIIIlIIlllIIl, final Random llllllllllllllIlIIIlIIIlIIlllIII, final StructureBoundingBox llllllllllllllIlIIIlIIIlIIllIlll) {
            final RoomDefinition llllllllllllllIlIIIlIIIlIIllIllI = this.field_175830_k.field_175965_b[EnumFacing.NORTH.getIndex()];
            final RoomDefinition llllllllllllllIlIIIlIIIlIIllIlIl = this.field_175830_k;
            final RoomDefinition llllllllllllllIlIIIlIIIlIIllIlII = llllllllllllllIlIIIlIIIlIIllIllI.field_175965_b[EnumFacing.UP.getIndex()];
            final RoomDefinition llllllllllllllIlIIIlIIIlIIllIIll = llllllllllllllIlIIIlIIIlIIllIlIl.field_175965_b[EnumFacing.UP.getIndex()];
            if (this.field_175830_k.field_175967_a / 25 > 0) {
                this.func_175821_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 0, 8, llllllllllllllIlIIIlIIIlIIllIllI.field_175966_c[EnumFacing.DOWN.getIndex()]);
                this.func_175821_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 0, 0, llllllllllllllIlIIIlIIIlIIllIlIl.field_175966_c[EnumFacing.DOWN.getIndex()]);
            }
            if (llllllllllllllIlIIIlIIIlIIllIIll.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 1, 8, 1, 6, 8, 7, DoubleYZRoom.field_175828_a);
            }
            if (llllllllllllllIlIIIlIIIlIIllIlII.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 1, 8, 8, 6, 8, 14, DoubleYZRoom.field_175828_a);
            }
            for (int llllllllllllllIlIIIlIIIlIIllIIlI = 1; llllllllllllllIlIIIlIIIlIIllIIlI <= 7; ++llllllllllllllIlIIIlIIIlIIllIIlI) {
                IBlockState llllllllllllllIlIIIlIIIlIIllIIIl = DoubleYZRoom.field_175826_b;
                if (llllllllllllllIlIIIlIIIlIIllIIlI == 2 || llllllllllllllIlIIIlIIIlIIllIIlI == 6) {
                    llllllllllllllIlIIIlIIIlIIllIIIl = DoubleYZRoom.field_175828_a;
                }
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 0, llllllllllllllIlIIIlIIIlIIllIIlI, 0, 0, llllllllllllllIlIIIlIIIlIIllIIlI, 15, llllllllllllllIlIIIlIIIlIIllIIIl, llllllllllllllIlIIIlIIIlIIllIIIl, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 7, llllllllllllllIlIIIlIIIlIIllIIlI, 0, 7, llllllllllllllIlIIIlIIIlIIllIIlI, 15, llllllllllllllIlIIIlIIIlIIllIIIl, llllllllllllllIlIIIlIIIlIIllIIIl, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 1, llllllllllllllIlIIIlIIIlIIllIIlI, 0, 6, llllllllllllllIlIIIlIIIlIIllIIlI, 0, llllllllllllllIlIIIlIIIlIIllIIIl, llllllllllllllIlIIIlIIIlIIllIIIl, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 1, llllllllllllllIlIIIlIIIlIIllIIlI, 15, 6, llllllllllllllIlIIIlIIIlIIllIIlI, 15, llllllllllllllIlIIIlIIIlIIllIIIl, llllllllllllllIlIIIlIIIlIIllIIIl, false);
            }
            for (int llllllllllllllIlIIIlIIIlIIllIIlI = 1; llllllllllllllIlIIIlIIIlIIllIIlI <= 7; ++llllllllllllllIlIIIlIIIlIIllIIlI) {
                IBlockState llllllllllllllIlIIIlIIIlIIllIIII = DoubleYZRoom.field_175827_c;
                if (llllllllllllllIlIIIlIIIlIIllIIlI == 2 || llllllllllllllIlIIIlIIIlIIllIIlI == 6) {
                    llllllllllllllIlIIIlIIIlIIllIIII = DoubleYZRoom.field_175825_e;
                }
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 3, llllllllllllllIlIIIlIIIlIIllIIlI, 7, 4, llllllllllllllIlIIIlIIIlIIllIIlI, 8, llllllllllllllIlIIIlIIIlIIllIIII, llllllllllllllIlIIIlIIIlIIllIIII, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIlIl.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 3, 1, 0, 4, 2, 0, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIlIl.field_175966_c[EnumFacing.EAST.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 7, 1, 3, 7, 2, 4, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIlIl.field_175966_c[EnumFacing.WEST.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 0, 1, 3, 0, 2, 4, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIllI.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 3, 1, 15, 4, 2, 15, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIllI.field_175966_c[EnumFacing.WEST.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 0, 1, 11, 0, 2, 12, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIllI.field_175966_c[EnumFacing.EAST.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 7, 1, 11, 7, 2, 12, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIIll.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 3, 5, 0, 4, 6, 0, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIIll.field_175966_c[EnumFacing.EAST.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 7, 5, 3, 7, 6, 4, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 5, 4, 2, 6, 4, 5, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 6, 1, 2, 6, 3, 2, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 6, 1, 5, 6, 3, 5, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIIll.field_175966_c[EnumFacing.WEST.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 0, 5, 3, 0, 6, 4, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 1, 4, 2, 2, 4, 5, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 1, 1, 2, 1, 3, 2, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 1, 1, 5, 1, 3, 5, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIlII.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 3, 5, 15, 4, 6, 15, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIlII.field_175966_c[EnumFacing.WEST.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 0, 5, 11, 0, 6, 12, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 1, 4, 10, 2, 4, 13, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 1, 1, 10, 1, 3, 10, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 1, 1, 13, 1, 3, 13, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
            }
            if (llllllllllllllIlIIIlIIIlIIllIlII.field_175966_c[EnumFacing.EAST.getIndex()]) {
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 7, 5, 11, 7, 6, 12, DoubleYZRoom.field_175822_f, DoubleYZRoom.field_175822_f, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 5, 4, 10, 6, 4, 13, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 6, 1, 10, 6, 3, 10, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIlIIIlIIIlIIlllIIl, llllllllllllllIlIIIlIIIlIIllIlll, 6, 1, 13, 6, 3, 13, DoubleYZRoom.field_175826_b, DoubleYZRoom.field_175826_b, false);
            }
            return true;
        }
        
        static {
            __OBFID = "CL_00001980";
        }
        
        public DoubleYZRoom() {
        }
    }
    
    interface MonumentRoomFitHelper
    {
        boolean func_175969_a(final RoomDefinition p0);
        
        Piece func_175968_a(final EnumFacing p0, final RoomDefinition p1, final Random p2);
    }
    
    static class FitSimpleRoomTopHelper implements MonumentRoomFitHelper
    {
        FitSimpleRoomTopHelper(final SwitchEnumFacing lllllllllllllllIIIIlIIlIlIIlIlII) {
            this();
        }
        
        static {
            __OBFID = "CL_00001986";
        }
        
        @Override
        public boolean func_175969_a(final RoomDefinition lllllllllllllllIIIIlIIlIlIlIIIlI) {
            return !lllllllllllllllIIIIlIIlIlIlIIIlI.field_175966_c[EnumFacing.WEST.getIndex()] && !lllllllllllllllIIIIlIIlIlIlIIIlI.field_175966_c[EnumFacing.EAST.getIndex()] && !lllllllllllllllIIIIlIIlIlIlIIIlI.field_175966_c[EnumFacing.NORTH.getIndex()] && !lllllllllllllllIIIIlIIlIlIlIIIlI.field_175966_c[EnumFacing.SOUTH.getIndex()] && !lllllllllllllllIIIIlIIlIlIlIIIlI.field_175966_c[EnumFacing.UP.getIndex()];
        }
        
        private FitSimpleRoomTopHelper() {
        }
        
        @Override
        public Piece func_175968_a(final EnumFacing lllllllllllllllIIIIlIIlIlIIllIIl, final RoomDefinition lllllllllllllllIIIIlIIlIlIIllIll, final Random lllllllllllllllIIIIlIIlIlIIllIlI) {
            lllllllllllllllIIIIlIIlIlIIllIll.field_175963_d = true;
            return new SimpleTopRoom(lllllllllllllllIIIIlIIlIlIIllIIl, lllllllllllllllIIIIlIIlIlIIllIll, lllllllllllllllIIIIlIIlIlIIllIlI);
        }
    }
    
    public static class SimpleTopRoom extends Piece
    {
        public SimpleTopRoom() {
        }
        
        static {
            __OBFID = "CL_00001974";
        }
        
        public SimpleTopRoom(final EnumFacing lllllllllllllllIllIIIlIllIIllIlI, final RoomDefinition lllllllllllllllIllIIIlIllIIlIlIl, final Random lllllllllllllllIllIIIlIllIIllIII) {
            super(1, lllllllllllllllIllIIIlIllIIllIlI, lllllllllllllllIllIIIlIllIIlIlIl, 1, 1, 1);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIllIIIlIllIIIIlIl, final Random lllllllllllllllIllIIIlIllIIIlIll, final StructureBoundingBox lllllllllllllllIllIIIlIllIIIlIlI) {
            if (this.field_175830_k.field_175967_a / 25 > 0) {
                this.func_175821_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 0, 0, this.field_175830_k.field_175966_c[EnumFacing.DOWN.getIndex()]);
            }
            if (this.field_175830_k.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 1, 4, 1, 6, 4, 6, SimpleTopRoom.field_175828_a);
            }
            for (int lllllllllllllllIllIIIlIllIIIlIIl = 1; lllllllllllllllIllIIIlIllIIIlIIl <= 6; ++lllllllllllllllIllIIIlIllIIIlIIl) {
                for (int lllllllllllllllIllIIIlIllIIIlIII = 1; lllllllllllllllIllIIIlIllIIIlIII <= 6; ++lllllllllllllllIllIIIlIllIIIlIII) {
                    if (lllllllllllllllIllIIIlIllIIIlIll.nextInt(3) != 0) {
                        final int lllllllllllllllIllIIIlIllIIIIlll = 2 + ((lllllllllllllllIllIIIlIllIIIlIll.nextInt(4) != 0) ? 1 : 0);
                        this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, lllllllllllllllIllIIIlIllIIIlIIl, lllllllllllllllIllIIIlIllIIIIlll, lllllllllllllllIllIIIlIllIIIlIII, lllllllllllllllIllIIIlIllIIIlIIl, 3, lllllllllllllllIllIIIlIllIIIlIII, Blocks.sponge.getStateFromMeta(1), Blocks.sponge.getStateFromMeta(1), false);
                    }
                }
            }
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 0, 1, 0, 0, 1, 7, SimpleTopRoom.field_175826_b, SimpleTopRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 7, 1, 0, 7, 1, 7, SimpleTopRoom.field_175826_b, SimpleTopRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 1, 1, 0, 6, 1, 0, SimpleTopRoom.field_175826_b, SimpleTopRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 1, 1, 7, 6, 1, 7, SimpleTopRoom.field_175826_b, SimpleTopRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 0, 2, 0, 0, 2, 7, SimpleTopRoom.field_175827_c, SimpleTopRoom.field_175827_c, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 7, 2, 0, 7, 2, 7, SimpleTopRoom.field_175827_c, SimpleTopRoom.field_175827_c, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 1, 2, 0, 6, 2, 0, SimpleTopRoom.field_175827_c, SimpleTopRoom.field_175827_c, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 1, 2, 7, 6, 2, 7, SimpleTopRoom.field_175827_c, SimpleTopRoom.field_175827_c, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 0, 3, 0, 0, 3, 7, SimpleTopRoom.field_175826_b, SimpleTopRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 7, 3, 0, 7, 3, 7, SimpleTopRoom.field_175826_b, SimpleTopRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 1, 3, 0, 6, 3, 0, SimpleTopRoom.field_175826_b, SimpleTopRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 1, 3, 7, 6, 3, 7, SimpleTopRoom.field_175826_b, SimpleTopRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 0, 1, 3, 0, 2, 4, SimpleTopRoom.field_175827_c, SimpleTopRoom.field_175827_c, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 7, 1, 3, 7, 2, 4, SimpleTopRoom.field_175827_c, SimpleTopRoom.field_175827_c, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 3, 1, 0, 4, 2, 0, SimpleTopRoom.field_175827_c, SimpleTopRoom.field_175827_c, false);
            this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 3, 1, 7, 4, 2, 7, SimpleTopRoom.field_175827_c, SimpleTopRoom.field_175827_c, false);
            if (this.field_175830_k.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIllIIIlIllIIIIlIl, lllllllllllllllIllIIIlIllIIIlIlI, 3, 1, 0, 4, 2, 0, SimpleTopRoom.field_175822_f, SimpleTopRoom.field_175822_f, false);
            }
            return true;
        }
    }
    
    public static class SimpleRoom extends Piece
    {
        private /* synthetic */ int field_175833_o;
        
        public SimpleRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIIIllIIIIIlIlllII, final Random lllllllllllllllIIIllIIIIIlIlIllI, final StructureBoundingBox lllllllllllllllIIIllIIIIIlIlIlIl) {
            if (this.field_175830_k.field_175967_a / 25 > 0) {
                this.func_175821_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 0, this.field_175830_k.field_175966_c[EnumFacing.DOWN.getIndex()]);
            }
            if (this.field_175830_k.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 4, 1, 6, 4, 6, SimpleRoom.field_175828_a);
            }
            final boolean lllllllllllllllIIIllIIIIIlIllIIl = this.field_175833_o != 0 && lllllllllllllllIIIllIIIIIlIlIllI.nextBoolean() && !this.field_175830_k.field_175966_c[EnumFacing.DOWN.getIndex()] && !this.field_175830_k.field_175966_c[EnumFacing.UP.getIndex()] && this.field_175830_k.func_175960_c() > 1;
            if (this.field_175833_o == 0) {
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 0, 2, 1, 2, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 3, 0, 2, 3, 2, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 2, 0, 0, 2, 2, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 2, 0, 2, 2, 0, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175825_e, 1, 2, 1, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 5, 1, 0, 7, 1, 2, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 5, 3, 0, 7, 3, 2, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 2, 0, 7, 2, 2, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 5, 2, 0, 6, 2, 0, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175825_e, 6, 2, 1, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 5, 2, 1, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 3, 5, 2, 3, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 2, 5, 0, 2, 7, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 2, 7, 2, 2, 7, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175825_e, 1, 2, 6, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 5, 1, 5, 7, 1, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 5, 3, 5, 7, 3, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 2, 5, 7, 2, 7, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 5, 2, 7, 6, 2, 7, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175825_e, 6, 2, 6, lllllllllllllllIIIllIIIIIlIlIlIl);
                if (this.field_175830_k.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 3, 0, 4, 3, 0, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
                else {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 3, 0, 4, 3, 1, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 2, 0, 4, 2, 0, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 1, 0, 4, 1, 1, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
                if (this.field_175830_k.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 3, 7, 4, 3, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
                else {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 3, 6, 4, 3, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 2, 7, 4, 2, 7, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 1, 6, 4, 1, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
                if (this.field_175830_k.field_175966_c[EnumFacing.WEST.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 3, 3, 0, 3, 4, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
                else {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 3, 3, 1, 3, 4, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 2, 3, 0, 2, 4, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 3, 1, 1, 4, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
                if (this.field_175830_k.field_175966_c[EnumFacing.EAST.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 3, 3, 7, 3, 4, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
                else {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 6, 3, 3, 7, 3, 4, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 2, 3, 7, 2, 4, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 6, 1, 3, 7, 1, 4, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
            }
            else if (this.field_175833_o == 1) {
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 2, 1, 2, 2, 3, 2, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 2, 1, 5, 2, 3, 5, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 5, 1, 5, 5, 3, 5, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 5, 1, 2, 5, 3, 2, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175825_e, 2, 2, 2, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175825_e, 2, 2, 5, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175825_e, 5, 2, 5, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175825_e, 5, 2, 2, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 0, 1, 3, 0, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 1, 0, 3, 1, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 7, 1, 3, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 6, 0, 3, 6, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 6, 1, 7, 7, 3, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 1, 6, 7, 3, 6, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 6, 1, 0, 7, 3, 0, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 1, 1, 7, 3, 1, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175828_a, 1, 2, 0, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175828_a, 0, 2, 1, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175828_a, 1, 2, 7, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175828_a, 0, 2, 6, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175828_a, 6, 2, 7, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175828_a, 7, 2, 6, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175828_a, 6, 2, 0, lllllllllllllllIIIllIIIIIlIlIlIl);
                this.func_175811_a(lllllllllllllllIIIllIIIIIlIlllII, SimpleRoom.field_175828_a, 7, 2, 1, lllllllllllllllIIIllIIIIIlIlIlIl);
                if (!this.field_175830_k.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 3, 0, 6, 3, 0, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 2, 0, 6, 2, 0, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 1, 0, 6, 1, 0, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
                if (!this.field_175830_k.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 3, 7, 6, 3, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 2, 7, 6, 2, 7, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 1, 7, 6, 1, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
                if (!this.field_175830_k.field_175966_c[EnumFacing.WEST.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 3, 1, 0, 3, 6, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 2, 1, 0, 2, 6, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 1, 0, 1, 6, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
                if (!this.field_175830_k.field_175966_c[EnumFacing.EAST.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 3, 1, 7, 3, 6, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 2, 1, 7, 2, 6, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 1, 1, 7, 1, 6, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                }
            }
            else if (this.field_175833_o == 2) {
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 0, 0, 1, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 1, 0, 7, 1, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 1, 0, 6, 1, 0, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 1, 7, 6, 1, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 2, 0, 0, 2, 7, SimpleRoom.field_175827_c, SimpleRoom.field_175827_c, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 2, 0, 7, 2, 7, SimpleRoom.field_175827_c, SimpleRoom.field_175827_c, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 2, 0, 6, 2, 0, SimpleRoom.field_175827_c, SimpleRoom.field_175827_c, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 2, 7, 6, 2, 7, SimpleRoom.field_175827_c, SimpleRoom.field_175827_c, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 3, 0, 0, 3, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 3, 0, 7, 3, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 3, 0, 6, 3, 0, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 1, 3, 7, 6, 3, 7, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 3, 0, 2, 4, SimpleRoom.field_175827_c, SimpleRoom.field_175827_c, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 1, 3, 7, 2, 4, SimpleRoom.field_175827_c, SimpleRoom.field_175827_c, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 1, 0, 4, 2, 0, SimpleRoom.field_175827_c, SimpleRoom.field_175827_c, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 1, 7, 4, 2, 7, SimpleRoom.field_175827_c, SimpleRoom.field_175827_c, false);
                if (this.field_175830_k.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 1, 0, 4, 2, 0, SimpleRoom.field_175822_f, SimpleRoom.field_175822_f, false);
                }
                if (this.field_175830_k.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 1, 7, 4, 2, 7, SimpleRoom.field_175822_f, SimpleRoom.field_175822_f, false);
                }
                if (this.field_175830_k.field_175966_c[EnumFacing.WEST.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 0, 1, 3, 0, 2, 4, SimpleRoom.field_175822_f, SimpleRoom.field_175822_f, false);
                }
                if (this.field_175830_k.field_175966_c[EnumFacing.EAST.getIndex()]) {
                    this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 7, 1, 3, 7, 2, 4, SimpleRoom.field_175822_f, SimpleRoom.field_175822_f, false);
                }
            }
            if (lllllllllllllllIIIllIIIIIlIllIIl) {
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 1, 3, 4, 1, 4, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 2, 3, 4, 2, 4, SimpleRoom.field_175828_a, SimpleRoom.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIIIllIIIIIlIlllII, lllllllllllllllIIIllIIIIIlIlIlIl, 3, 3, 3, 4, 3, 4, SimpleRoom.field_175826_b, SimpleRoom.field_175826_b, false);
            }
            return true;
        }
        
        static {
            __OBFID = "CL_00001975";
        }
        
        public SimpleRoom(final EnumFacing lllllllllllllllIIIllIIIIIllIIlIl, final RoomDefinition lllllllllllllllIIIllIIIIIllIIlII, final Random lllllllllllllllIIIllIIIIIllIIIll) {
            super(1, lllllllllllllllIIIllIIIIIllIIlIl, lllllllllllllllIIIllIIIIIllIIlII, 1, 1, 1);
            this.field_175833_o = lllllllllllllllIIIllIIIIIllIIIll.nextInt(3);
        }
    }
    
    static class FitSimpleRoomHelper implements MonumentRoomFitHelper
    {
        @Override
        public Piece func_175968_a(final EnumFacing lIIlllllIIllI, final RoomDefinition lIIlllllIIIlI, final Random lIIlllllIIlII) {
            lIIlllllIIIlI.field_175963_d = true;
            return new SimpleRoom(lIIlllllIIllI, lIIlllllIIIlI, lIIlllllIIlII);
        }
        
        static {
            __OBFID = "CL_00001987";
        }
        
        FitSimpleRoomHelper(final SwitchEnumFacing lIIllllIllllI) {
            this();
        }
        
        private FitSimpleRoomHelper() {
        }
        
        @Override
        public boolean func_175969_a(final RoomDefinition lIIlllllIlIll) {
            return true;
        }
    }
    
    public static class DoubleYRoom extends Piece
    {
        public DoubleYRoom(final EnumFacing llllllllllllllIlllIIllIIIIIllIll, final RoomDefinition llllllllllllllIlllIIllIIIIIllIlI, final Random llllllllllllllIlllIIllIIIIIlllIl) {
            super(1, llllllllllllllIlllIIllIIIIIllIll, llllllllllllllIlllIIllIIIIIllIlI, 1, 2, 1);
        }
        
        public DoubleYRoom() {
        }
        
        static {
            __OBFID = "CL_00001981";
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlllIIllIIIIIlIIII, final Random llllllllllllllIlllIIllIIIIIIllll, final StructureBoundingBox llllllllllllllIlllIIllIIIIIIlllI) {
            if (this.field_175830_k.field_175967_a / 25 > 0) {
                this.func_175821_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 0, 0, this.field_175830_k.field_175966_c[EnumFacing.DOWN.getIndex()]);
            }
            final RoomDefinition llllllllllllllIlllIIllIIIIIIllIl = this.field_175830_k.field_175965_b[EnumFacing.UP.getIndex()];
            if (llllllllllllllIlllIIllIIIIIIllIl.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 1, 8, 1, 6, 8, 6, DoubleYRoom.field_175828_a);
            }
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 0, 4, 0, 0, 4, 7, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 7, 4, 0, 7, 4, 7, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 1, 4, 0, 6, 4, 0, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 1, 4, 7, 6, 4, 7, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 2, 4, 1, 2, 4, 2, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 1, 4, 2, 1, 4, 2, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 5, 4, 1, 5, 4, 2, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 6, 4, 2, 6, 4, 2, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 2, 4, 5, 2, 4, 6, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 1, 4, 5, 1, 4, 5, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 5, 4, 5, 5, 4, 6, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 6, 4, 5, 6, 4, 5, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
            RoomDefinition llllllllllllllIlllIIllIIIIIIllII = this.field_175830_k;
            for (int llllllllllllllIlllIIllIIIIIIlIll = 1; llllllllllllllIlllIIllIIIIIIlIll <= 5; llllllllllllllIlllIIllIIIIIIlIll += 4) {
                byte llllllllllllllIlllIIllIIIIIIlIlI = 0;
                if (llllllllllllllIlllIIllIIIIIIllII.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 2, llllllllllllllIlllIIllIIIIIIlIll, llllllllllllllIlllIIllIIIIIIlIlI, 2, llllllllllllllIlllIIllIIIIIIlIll + 2, llllllllllllllIlllIIllIIIIIIlIlI, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 5, llllllllllllllIlllIIllIIIIIIlIll, llllllllllllllIlllIIllIIIIIIlIlI, 5, llllllllllllllIlllIIllIIIIIIlIll + 2, llllllllllllllIlllIIllIIIIIIlIlI, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 3, llllllllllllllIlllIIllIIIIIIlIll + 2, llllllllllllllIlllIIllIIIIIIlIlI, 4, llllllllllllllIlllIIllIIIIIIlIll + 2, llllllllllllllIlllIIllIIIIIIlIlI, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                }
                else {
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 0, llllllllllllllIlllIIllIIIIIIlIll, llllllllllllllIlllIIllIIIIIIlIlI, 7, llllllllllllllIlllIIllIIIIIIlIll + 2, llllllllllllllIlllIIllIIIIIIlIlI, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 0, llllllllllllllIlllIIllIIIIIIlIll + 1, llllllllllllllIlllIIllIIIIIIlIlI, 7, llllllllllllllIlllIIllIIIIIIlIll + 1, llllllllllllllIlllIIllIIIIIIlIlI, DoubleYRoom.field_175828_a, DoubleYRoom.field_175828_a, false);
                }
                llllllllllllllIlllIIllIIIIIIlIlI = 7;
                if (llllllllllllllIlllIIllIIIIIIllII.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 2, llllllllllllllIlllIIllIIIIIIlIll, llllllllllllllIlllIIllIIIIIIlIlI, 2, llllllllllllllIlllIIllIIIIIIlIll + 2, llllllllllllllIlllIIllIIIIIIlIlI, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 5, llllllllllllllIlllIIllIIIIIIlIll, llllllllllllllIlllIIllIIIIIIlIlI, 5, llllllllllllllIlllIIllIIIIIIlIll + 2, llllllllllllllIlllIIllIIIIIIlIlI, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 3, llllllllllllllIlllIIllIIIIIIlIll + 2, llllllllllllllIlllIIllIIIIIIlIlI, 4, llllllllllllllIlllIIllIIIIIIlIll + 2, llllllllllllllIlllIIllIIIIIIlIlI, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                }
                else {
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 0, llllllllllllllIlllIIllIIIIIIlIll, llllllllllllllIlllIIllIIIIIIlIlI, 7, llllllllllllllIlllIIllIIIIIIlIll + 2, llllllllllllllIlllIIllIIIIIIlIlI, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, 0, llllllllllllllIlllIIllIIIIIIlIll + 1, llllllllllllllIlllIIllIIIIIIlIlI, 7, llllllllllllllIlllIIllIIIIIIlIll + 1, llllllllllllllIlllIIllIIIIIIlIlI, DoubleYRoom.field_175828_a, DoubleYRoom.field_175828_a, false);
                }
                byte llllllllllllllIlllIIllIIIIIIlIIl = 0;
                if (llllllllllllllIlllIIllIIIIIIllII.field_175966_c[EnumFacing.WEST.getIndex()]) {
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll, 2, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 2, 2, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll, 5, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 2, 5, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 2, 3, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 2, 4, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                }
                else {
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll, 0, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 2, 7, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 1, 0, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 1, 7, DoubleYRoom.field_175828_a, DoubleYRoom.field_175828_a, false);
                }
                llllllllllllllIlllIIllIIIIIIlIIl = 7;
                if (llllllllllllllIlllIIllIIIIIIllII.field_175966_c[EnumFacing.EAST.getIndex()]) {
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll, 2, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 2, 2, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll, 5, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 2, 5, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 2, 3, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 2, 4, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                }
                else {
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll, 0, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 2, 7, DoubleYRoom.field_175826_b, DoubleYRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIlllIIllIIIIIlIIII, llllllllllllllIlllIIllIIIIIIlllI, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 1, 0, llllllllllllllIlllIIllIIIIIIlIIl, llllllllllllllIlllIIllIIIIIIlIll + 1, 7, DoubleYRoom.field_175828_a, DoubleYRoom.field_175828_a, false);
                }
                llllllllllllllIlllIIllIIIIIIllII = llllllllllllllIlllIIllIIIIIIllIl;
            }
            return true;
        }
    }
    
    public static class EntryRoom extends Piece
    {
        @Override
        public boolean addComponentParts(final World llllllllllllllIllllllIIlIlllIIII, final Random llllllllllllllIllllllIIlIllIlllI, final StructureBoundingBox llllllllllllllIllllllIIlIllIllII) {
            this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 0, 3, 0, 2, 3, 7, EntryRoom.field_175826_b, EntryRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 5, 3, 0, 7, 3, 7, EntryRoom.field_175826_b, EntryRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 0, 2, 0, 1, 2, 7, EntryRoom.field_175826_b, EntryRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 6, 2, 0, 7, 2, 7, EntryRoom.field_175826_b, EntryRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 0, 1, 0, 0, 1, 7, EntryRoom.field_175826_b, EntryRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 7, 1, 0, 7, 1, 7, EntryRoom.field_175826_b, EntryRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 0, 1, 7, 7, 3, 7, EntryRoom.field_175826_b, EntryRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 1, 1, 0, 2, 3, 0, EntryRoom.field_175826_b, EntryRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 5, 1, 0, 6, 3, 0, EntryRoom.field_175826_b, EntryRoom.field_175826_b, false);
            if (this.field_175830_k.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 3, 1, 7, 4, 2, 7, EntryRoom.field_175822_f, EntryRoom.field_175822_f, false);
            }
            if (this.field_175830_k.field_175966_c[EnumFacing.WEST.getIndex()]) {
                this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 0, 1, 3, 1, 2, 4, EntryRoom.field_175822_f, EntryRoom.field_175822_f, false);
            }
            if (this.field_175830_k.field_175966_c[EnumFacing.EAST.getIndex()]) {
                this.func_175804_a(llllllllllllllIllllllIIlIlllIIII, llllllllllllllIllllllIIlIllIllII, 6, 1, 3, 7, 2, 4, EntryRoom.field_175822_f, EntryRoom.field_175822_f, false);
            }
            return true;
        }
        
        public EntryRoom(final EnumFacing llllllllllllllIllllllIIlIlllllII, final RoomDefinition llllllllllllllIllllllIIlIllllllI) {
            super(1, llllllllllllllIllllllIIlIlllllII, llllllllllllllIllllllIIlIllllllI, 1, 1, 1);
        }
        
        public EntryRoom() {
        }
        
        static {
            __OBFID = "CL_00001978";
        }
    }
    
    static class YDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        YDoubleRoomFitHelper(final SwitchEnumFacing llllllllllllllIIIlllIllIIllIllIl) {
            this();
        }
        
        @Override
        public boolean func_175969_a(final RoomDefinition llllllllllllllIIIlllIllIIllllIlI) {
            return llllllllllllllIIIlllIllIIllllIlI.field_175966_c[EnumFacing.UP.getIndex()] && !llllllllllllllIIIlllIllIIllllIlI.field_175965_b[EnumFacing.UP.getIndex()].field_175963_d;
        }
        
        private YDoubleRoomFitHelper() {
        }
        
        static {
            __OBFID = "CL_00001990";
        }
        
        @Override
        public Piece func_175968_a(final EnumFacing llllllllllllllIIIlllIllIIlllIIlI, final RoomDefinition llllllllllllllIIIlllIllIIlllIlII, final Random llllllllllllllIIIlllIllIIlllIIll) {
            llllllllllllllIIIlllIllIIlllIlII.field_175963_d = true;
            llllllllllllllIIIlllIllIIlllIlII.field_175965_b[EnumFacing.UP.getIndex()].field_175963_d = true;
            return new DoubleYRoom(llllllllllllllIIIlllIllIIlllIIlI, llllllllllllllIIIlllIllIIlllIlII, llllllllllllllIIIlllIllIIlllIIll);
        }
    }
    
    static class XYDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        static {
            __OBFID = "CL_00001991";
        }
        
        @Override
        public Piece func_175968_a(final EnumFacing llllllllllllllIlIlIIllIlIIIlIIIl, final RoomDefinition llllllllllllllIlIlIIllIlIIIlIIII, final Random llllllllllllllIlIlIIllIlIIIIllII) {
            llllllllllllllIlIlIIllIlIIIlIIII.field_175963_d = true;
            llllllllllllllIlIlIIllIlIIIlIIII.field_175965_b[EnumFacing.EAST.getIndex()].field_175963_d = true;
            llllllllllllllIlIlIIllIlIIIlIIII.field_175965_b[EnumFacing.UP.getIndex()].field_175963_d = true;
            llllllllllllllIlIlIIllIlIIIlIIII.field_175965_b[EnumFacing.EAST.getIndex()].field_175965_b[EnumFacing.UP.getIndex()].field_175963_d = true;
            return new DoubleXYRoom(llllllllllllllIlIlIIllIlIIIlIIIl, llllllllllllllIlIlIIllIlIIIlIIII, llllllllllllllIlIlIIllIlIIIIllII);
        }
        
        @Override
        public boolean func_175969_a(final RoomDefinition llllllllllllllIlIlIIllIlIIIllIIl) {
            if (llllllllllllllIlIlIIllIlIIIllIIl.field_175966_c[EnumFacing.EAST.getIndex()] && !llllllllllllllIlIlIIllIlIIIllIIl.field_175965_b[EnumFacing.EAST.getIndex()].field_175963_d && llllllllllllllIlIlIIllIlIIIllIIl.field_175966_c[EnumFacing.UP.getIndex()] && !llllllllllllllIlIlIIllIlIIIllIIl.field_175965_b[EnumFacing.UP.getIndex()].field_175963_d) {
                final RoomDefinition llllllllllllllIlIlIIllIlIIIllIII = llllllllllllllIlIlIIllIlIIIllIIl.field_175965_b[EnumFacing.EAST.getIndex()];
                return llllllllllllllIlIlIIllIlIIIllIII.field_175966_c[EnumFacing.UP.getIndex()] && !llllllllllllllIlIlIIllIlIIIllIII.field_175965_b[EnumFacing.UP.getIndex()].field_175963_d;
            }
            return false;
        }
        
        XYDoubleRoomFitHelper(final SwitchEnumFacing llllllllllllllIlIlIIllIlIIIIlIIl) {
            this();
        }
        
        private XYDoubleRoomFitHelper() {
        }
    }
    
    public static class DoubleXRoom extends Piece
    {
        public DoubleXRoom(final EnumFacing lllllllllllllllIIIIIllllIlIIIIII, final RoomDefinition lllllllllllllllIIIIIllllIIlllllI, final Random lllllllllllllllIIIIIllllIIllllII) {
            super(1, lllllllllllllllIIIIIllllIlIIIIII, lllllllllllllllIIIIIllllIIlllllI, 2, 1, 1);
        }
        
        static {
            __OBFID = "CL_00001983";
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIIIIIllllIIlIllII, final Random lllllllllllllllIIIIIllllIIllIIIl, final StructureBoundingBox lllllllllllllllIIIIIllllIIllIIII) {
            final RoomDefinition lllllllllllllllIIIIIllllIIlIllll = this.field_175830_k.field_175965_b[EnumFacing.EAST.getIndex()];
            final RoomDefinition lllllllllllllllIIIIIllllIIlIlllI = this.field_175830_k;
            if (this.field_175830_k.field_175967_a / 25 > 0) {
                this.func_175821_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 8, 0, lllllllllllllllIIIIIllllIIlIllll.field_175966_c[EnumFacing.DOWN.getIndex()]);
                this.func_175821_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 0, 0, lllllllllllllllIIIIIllllIIlIlllI.field_175966_c[EnumFacing.DOWN.getIndex()]);
            }
            if (lllllllllllllllIIIIIllllIIlIlllI.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 1, 4, 1, 7, 4, 6, DoubleXRoom.field_175828_a);
            }
            if (lllllllllllllllIIIIIllllIIlIllll.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 8, 4, 1, 14, 4, 6, DoubleXRoom.field_175828_a);
            }
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 0, 3, 0, 0, 3, 7, DoubleXRoom.field_175826_b, DoubleXRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 15, 3, 0, 15, 3, 7, DoubleXRoom.field_175826_b, DoubleXRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 1, 3, 0, 15, 3, 0, DoubleXRoom.field_175826_b, DoubleXRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 1, 3, 7, 14, 3, 7, DoubleXRoom.field_175826_b, DoubleXRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 0, 2, 0, 0, 2, 7, DoubleXRoom.field_175828_a, DoubleXRoom.field_175828_a, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 15, 2, 0, 15, 2, 7, DoubleXRoom.field_175828_a, DoubleXRoom.field_175828_a, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 1, 2, 0, 15, 2, 0, DoubleXRoom.field_175828_a, DoubleXRoom.field_175828_a, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 1, 2, 7, 14, 2, 7, DoubleXRoom.field_175828_a, DoubleXRoom.field_175828_a, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 0, 1, 0, 0, 1, 7, DoubleXRoom.field_175826_b, DoubleXRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 15, 1, 0, 15, 1, 7, DoubleXRoom.field_175826_b, DoubleXRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 1, 1, 0, 15, 1, 0, DoubleXRoom.field_175826_b, DoubleXRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 1, 1, 7, 14, 1, 7, DoubleXRoom.field_175826_b, DoubleXRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 5, 1, 0, 10, 1, 4, DoubleXRoom.field_175826_b, DoubleXRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 6, 2, 0, 9, 2, 3, DoubleXRoom.field_175828_a, DoubleXRoom.field_175828_a, false);
            this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 5, 3, 0, 10, 3, 4, DoubleXRoom.field_175826_b, DoubleXRoom.field_175826_b, false);
            this.func_175811_a(lllllllllllllllIIIIIllllIIlIllII, DoubleXRoom.field_175825_e, 6, 2, 3, lllllllllllllllIIIIIllllIIllIIII);
            this.func_175811_a(lllllllllllllllIIIIIllllIIlIllII, DoubleXRoom.field_175825_e, 9, 2, 3, lllllllllllllllIIIIIllllIIllIIII);
            if (lllllllllllllllIIIIIllllIIlIlllI.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 3, 1, 0, 4, 2, 0, DoubleXRoom.field_175822_f, DoubleXRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllllIIlIlllI.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 3, 1, 7, 4, 2, 7, DoubleXRoom.field_175822_f, DoubleXRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllllIIlIlllI.field_175966_c[EnumFacing.WEST.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 0, 1, 3, 0, 2, 4, DoubleXRoom.field_175822_f, DoubleXRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllllIIlIllll.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 11, 1, 0, 12, 2, 0, DoubleXRoom.field_175822_f, DoubleXRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllllIIlIllll.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 11, 1, 7, 12, 2, 7, DoubleXRoom.field_175822_f, DoubleXRoom.field_175822_f, false);
            }
            if (lllllllllllllllIIIIIllllIIlIllll.field_175966_c[EnumFacing.EAST.getIndex()]) {
                this.func_175804_a(lllllllllllllllIIIIIllllIIlIllII, lllllllllllllllIIIIIllllIIllIIII, 15, 1, 3, 15, 2, 4, DoubleXRoom.field_175822_f, DoubleXRoom.field_175822_f, false);
            }
            return true;
        }
        
        public DoubleXRoom() {
        }
    }
    
    public static class MonumentBuilding extends Piece
    {
        private /* synthetic */ RoomDefinition field_175844_p;
        private /* synthetic */ List field_175843_q;
        private /* synthetic */ RoomDefinition field_175845_o;
        
        private void func_175842_f(final World lllllllllllllllIlllIIIlIlIIIlIIl, final Random lllllllllllllllIlllIIIlIlIIIllll, final StructureBoundingBox lllllllllllllllIlllIIIlIlIIIlllI) {
            if (this.func_175818_a(lllllllllllllllIlllIIIlIlIIIlllI, 7, 21, 13, 50)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 7, 0, 21, 13, 0, 50, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 7, 1, 21, 13, 10, 50, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 11, 8, 21, 13, 8, 53, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                for (int lllllllllllllllIlllIIIlIlIIIllIl = 0; lllllllllllllllIlllIIIlIlIIIllIl < 4; ++lllllllllllllllIlllIIIlIlIIIllIl) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, lllllllllllllllIlllIIIlIlIIIllIl + 7, lllllllllllllllIlllIIIlIlIIIllIl + 5, 21, lllllllllllllllIlllIIIlIlIIIllIl + 7, lllllllllllllllIlllIIIlIlIIIllIl + 5, 54, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
                for (int lllllllllllllllIlllIIIlIlIIIllIl = 21; lllllllllllllllIlllIIIlIlIIIllIl <= 45; lllllllllllllllIlllIIIlIlIIIllIl += 3) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, 12, 9, lllllllllllllllIlllIIIlIlIIIllIl, lllllllllllllllIlllIIIlIlIIIlllI);
                }
            }
            if (this.func_175818_a(lllllllllllllllIlllIIIlIlIIIlllI, 44, 21, 50, 54)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 44, 0, 21, 50, 0, 50, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 44, 1, 21, 50, 10, 50, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 44, 8, 21, 46, 8, 53, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                for (int lllllllllllllllIlllIIIlIlIIIllII = 0; lllllllllllllllIlllIIIlIlIIIllII < 4; ++lllllllllllllllIlllIIIlIlIIIllII) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 50 - lllllllllllllllIlllIIIlIlIIIllII, lllllllllllllllIlllIIIlIlIIIllII + 5, 21, 50 - lllllllllllllllIlllIIIlIlIIIllII, lllllllllllllllIlllIIIlIlIIIllII + 5, 54, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
                for (int lllllllllllllllIlllIIIlIlIIIllII = 21; lllllllllllllllIlllIIIlIlIIIllII <= 45; lllllllllllllllIlllIIIlIlIIIllII += 3) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, 45, 9, lllllllllllllllIlllIIIlIlIIIllII, lllllllllllllllIlllIIIlIlIIIlllI);
                }
            }
            if (this.func_175818_a(lllllllllllllllIlllIIIlIlIIIlllI, 8, 44, 49, 54)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 14, 0, 44, 43, 0, 50, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 14, 1, 44, 43, 10, 50, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                for (int lllllllllllllllIlllIIIlIlIIIlIll = 12; lllllllllllllllIlllIIIlIlIIIlIll <= 45; lllllllllllllllIlllIIIlIlIIIlIll += 3) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 9, 45, lllllllllllllllIlllIIIlIlIIIlllI);
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 9, 52, lllllllllllllllIlllIIIlIlIIIlllI);
                    if (lllllllllllllllIlllIIIlIlIIIlIll == 12 || lllllllllllllllIlllIIIlIlIIIlIll == 18 || lllllllllllllllIlllIIIlIlIIIlIll == 24 || lllllllllllllllIlllIIIlIlIIIlIll == 33 || lllllllllllllllIlllIIIlIlIIIlIll == 39 || lllllllllllllllIlllIIIlIlIIIlIll == 45) {
                        this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 9, 47, lllllllllllllllIlllIIIlIlIIIlllI);
                        this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 9, 50, lllllllllllllllIlllIIIlIlIIIlllI);
                        this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 10, 45, lllllllllllllllIlllIIIlIlIIIlllI);
                        this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 10, 46, lllllllllllllllIlllIIIlIlIIIlllI);
                        this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 10, 51, lllllllllllllllIlllIIIlIlIIIlllI);
                        this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 10, 52, lllllllllllllllIlllIIIlIlIIIlllI);
                        this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 11, 47, lllllllllllllllIlllIIIlIlIIIlllI);
                        this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 11, 50, lllllllllllllllIlllIIIlIlIIIlllI);
                        this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 12, 48, lllllllllllllllIlllIIIlIlIIIlllI);
                        this.func_175811_a(lllllllllllllllIlllIIIlIlIIIlIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIlIIIlIll, 12, 49, lllllllllllllllIlllIIIlIlIIIlllI);
                    }
                }
                for (int lllllllllllllllIlllIIIlIlIIIlIll = 0; lllllllllllllllIlllIIIlIlIIIlIll < 3; ++lllllllllllllllIlllIIIlIlIIIlIll) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 8 + lllllllllllllllIlllIIIlIlIIIlIll, 5 + lllllllllllllllIlllIIIlIlIIIlIll, 54, 49 - lllllllllllllllIlllIIIlIlIIIlIll, 5 + lllllllllllllllIlllIIIlIlIIIlIll, 54, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                }
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 11, 8, 54, 46, 8, 54, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIlIIl, lllllllllllllllIlllIIIlIlIIIlllI, 14, 8, 44, 43, 8, 53, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
            }
        }
        
        private void func_175841_d(final World lllllllllllllllIlllIIIlIlIlIllII, final Random lllllllllllllllIlllIIIlIlIlIlIll, final StructureBoundingBox lllllllllllllllIlllIIIlIlIlIIllI) {
            if (this.func_175818_a(lllllllllllllllIlllIIIlIlIlIIllI, 21, 21, 36, 36)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 21, 0, 22, 36, 0, 36, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 21, 1, 22, 36, 23, 36, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                for (int lllllllllllllllIlllIIIlIlIlIlIIl = 0; lllllllllllllllIlllIIIlIlIlIlIIl < 4; ++lllllllllllllllIlllIIIlIlIlIlIIl) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 21 + lllllllllllllllIlllIIIlIlIlIlIIl, 13 + lllllllllllllllIlllIIIlIlIlIlIIl, 21 + lllllllllllllllIlllIIIlIlIlIlIIl, 36 - lllllllllllllllIlllIIIlIlIlIlIIl, 13 + lllllllllllllllIlllIIIlIlIlIlIIl, 21 + lllllllllllllllIlllIIIlIlIlIlIIl, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 21 + lllllllllllllllIlllIIIlIlIlIlIIl, 13 + lllllllllllllllIlllIIIlIlIlIlIIl, 36 - lllllllllllllllIlllIIIlIlIlIlIIl, 36 - lllllllllllllllIlllIIIlIlIlIlIIl, 13 + lllllllllllllllIlllIIIlIlIlIlIIl, 36 - lllllllllllllllIlllIIIlIlIlIlIIl, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 21 + lllllllllllllllIlllIIIlIlIlIlIIl, 13 + lllllllllllllllIlllIIIlIlIlIlIIl, 22 + lllllllllllllllIlllIIIlIlIlIlIIl, 21 + lllllllllllllllIlllIIIlIlIlIlIIl, 13 + lllllllllllllllIlllIIIlIlIlIlIIl, 35 - lllllllllllllllIlllIIIlIlIlIlIIl, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 36 - lllllllllllllllIlllIIIlIlIlIlIIl, 13 + lllllllllllllllIlllIIIlIlIlIlIIl, 22 + lllllllllllllllIlllIIIlIlIlIlIIl, 36 - lllllllllllllllIlllIIIlIlIlIlIIl, 13 + lllllllllllllllIlllIIIlIlIlIlIIl, 35 - lllllllllllllllIlllIIIlIlIlIlIIl, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 25, 16, 25, 32, 16, 32, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 25, 17, 25, 25, 19, 25, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 32, 17, 25, 32, 19, 25, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 25, 17, 32, 25, 19, 32, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 32, 17, 32, 32, 19, 32, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175826_b, 26, 20, 26, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175826_b, 27, 21, 27, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175825_e, 27, 20, 27, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175826_b, 26, 20, 31, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175826_b, 27, 21, 30, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175825_e, 27, 20, 30, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175826_b, 31, 20, 31, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175826_b, 30, 21, 30, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175825_e, 30, 20, 30, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175826_b, 31, 20, 26, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175826_b, 30, 21, 27, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIlIllII, MonumentBuilding.field_175825_e, 30, 20, 27, lllllllllllllllIlllIIIlIlIlIIllI);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 28, 21, 27, 29, 21, 27, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 27, 21, 28, 27, 21, 29, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 28, 21, 30, 29, 21, 30, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIIllI, 30, 21, 28, 30, 21, 29, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
            }
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIlllIIIlIllllllll, final Random lllllllllllllllIlllIIIlIlllllllI, final StructureBoundingBox lllllllllllllllIlllIIIlIllllIIIl) {
            this.func_175840_a(false, 0, lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIlllllllI, lllllllllllllllIlllIIIlIllllIIIl);
            this.func_175840_a(true, 33, lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIlllllllI, lllllllllllllllIlllIIIlIllllIIIl);
            this.func_175839_b(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIlllllllI, lllllllllllllllIlllIIIlIllllIIIl);
            this.func_175837_c(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIlllllllI, lllllllllllllllIlllIIIlIllllIIIl);
            this.func_175841_d(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIlllllllI, lllllllllllllllIlllIIIlIllllIIIl);
            this.func_175835_e(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIlllllllI, lllllllllllllllIlllIIIlIllllIIIl);
            this.func_175842_f(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIlllllllI, lllllllllllllllIlllIIIlIllllIIIl);
            this.func_175838_g(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIlllllllI, lllllllllllllllIlllIIIlIllllIIIl);
            for (int lllllllllllllllIlllIIIlIllllllII = 0; lllllllllllllllIlllIIIlIllllllII < 7; ++lllllllllllllllIlllIIIlIllllllII) {
                int lllllllllllllllIlllIIIlIlllllIll = 0;
                while (lllllllllllllllIlllIIIlIlllllIll < 7) {
                    if (lllllllllllllllIlllIIIlIlllllIll == 0 && lllllllllllllllIlllIIIlIllllllII == 3) {
                        lllllllllllllllIlllIIIlIlllllIll = 6;
                    }
                    final int lllllllllllllllIlllIIIlIlllllIlI = lllllllllllllllIlllIIIlIllllllII * 9;
                    final int lllllllllllllllIlllIIIlIlllllIIl = lllllllllllllllIlllIIIlIlllllIll * 9;
                    for (int lllllllllllllllIlllIIIlIlllllIII = 0; lllllllllllllllIlllIIIlIlllllIII < 4; ++lllllllllllllllIlllIIIlIlllllIII) {
                        for (int lllllllllllllllIlllIIIlIllllIlll = 0; lllllllllllllllIlllIIIlIllllIlll < 4; ++lllllllllllllllIlllIIIlIllllIlll) {
                            this.func_175811_a(lllllllllllllllIlllIIIlIllllllll, MonumentBuilding.field_175826_b, lllllllllllllllIlllIIIlIlllllIlI + lllllllllllllllIlllIIIlIlllllIII, 0, lllllllllllllllIlllIIIlIlllllIIl + lllllllllllllllIlllIIIlIllllIlll, lllllllllllllllIlllIIIlIllllIIIl);
                            this.func_175808_b(lllllllllllllllIlllIIIlIllllllll, MonumentBuilding.field_175826_b, lllllllllllllllIlllIIIlIlllllIlI + lllllllllllllllIlllIIIlIlllllIII, -1, lllllllllllllllIlllIIIlIlllllIIl + lllllllllllllllIlllIIIlIllllIlll, lllllllllllllllIlllIIIlIllllIIIl);
                        }
                    }
                    if (lllllllllllllllIlllIIIlIllllllII != 0 && lllllllllllllllIlllIIIlIllllllII != 6) {
                        lllllllllllllllIlllIIIlIlllllIll += 6;
                    }
                    else {
                        ++lllllllllllllllIlllIIIlIlllllIll;
                    }
                }
            }
            for (int lllllllllllllllIlllIIIlIllllllII = 0; lllllllllllllllIlllIIIlIllllllII < 5; ++lllllllllllllllIlllIIIlIllllllII) {
                this.func_175804_a(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIllllIIIl, -1 - lllllllllllllllIlllIIIlIllllllII, 0 + lllllllllllllllIlllIIIlIllllllII * 2, -1 - lllllllllllllllIlllIIIlIllllllII, -1 - lllllllllllllllIlllIIIlIllllllII, 23, 58 + lllllllllllllllIlllIIIlIllllllII, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIllllIIIl, 58 + lllllllllllllllIlllIIIlIllllllII, 0 + lllllllllllllllIlllIIIlIllllllII * 2, -1 - lllllllllllllllIlllIIIlIllllllII, 58 + lllllllllllllllIlllIIIlIllllllII, 23, 58 + lllllllllllllllIlllIIIlIllllllII, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIllllIIIl, 0 - lllllllllllllllIlllIIIlIllllllII, 0 + lllllllllllllllIlllIIIlIllllllII * 2, -1 - lllllllllllllllIlllIIIlIllllllII, 57 + lllllllllllllllIlllIIIlIllllllII, 23, -1 - lllllllllllllllIlllIIIlIllllllII, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIllllIIIl, 0 - lllllllllllllllIlllIIIlIllllllII, 0 + lllllllllllllllIlllIIIlIllllllII * 2, 58 + lllllllllllllllIlllIIIlIllllllII, 57 + lllllllllllllllIlllIIIlIllllllII, 23, 58 + lllllllllllllllIlllIIIlIllllllII, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
            }
            for (final Piece lllllllllllllllIlllIIIlIllllIlIl : this.field_175843_q) {
                if (lllllllllllllllIlllIIIlIllllIlIl.getBoundingBox().intersectsWith(lllllllllllllllIlllIIIlIllllIIIl)) {
                    lllllllllllllllIlllIIIlIllllIlIl.addComponentParts(lllllllllllllllIlllIIIlIllllllll, lllllllllllllllIlllIIIlIlllllllI, lllllllllllllllIlllIIIlIllllIIIl);
                }
            }
            return true;
        }
        
        private void func_175839_b(final World lllllllllllllllIlllIIIlIllIIIIIl, final Random lllllllllllllllIlllIIIlIllIIIlIl, final StructureBoundingBox lllllllllllllllIlllIIIlIllIIIIII) {
            if (this.func_175818_a(lllllllllllllllIlllIIIlIllIIIIII, 22, 5, 35, 17)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIllIIIIIl, lllllllllllllllIlllIIIlIllIIIIII, 25, 0, 0, 32, 8, 20, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                for (int lllllllllllllllIlllIIIlIllIIIIll = 0; lllllllllllllllIlllIIIlIllIIIIll < 4; ++lllllllllllllllIlllIIIlIllIIIIll) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIIIIIl, lllllllllllllllIlllIIIlIllIIIIII, 24, 2, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, 24, 4, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIIIIIl, lllllllllllllllIlllIIIlIllIIIIII, 22, 4, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, 23, 4, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175811_a(lllllllllllllllIlllIIIlIllIIIIIl, MonumentBuilding.field_175826_b, 25, 5, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, lllllllllllllllIlllIIIlIllIIIIII);
                    this.func_175811_a(lllllllllllllllIlllIIIlIllIIIIIl, MonumentBuilding.field_175826_b, 26, 6, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, lllllllllllllllIlllIIIlIllIIIIII);
                    this.func_175811_a(lllllllllllllllIlllIIIlIllIIIIIl, MonumentBuilding.field_175825_e, 26, 5, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, lllllllllllllllIlllIIIlIllIIIIII);
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIIIIIl, lllllllllllllllIlllIIIlIllIIIIII, 33, 2, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, 33, 4, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIIIIIl, lllllllllllllllIlllIIIlIllIIIIII, 34, 4, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, 35, 4, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175811_a(lllllllllllllllIlllIIIlIllIIIIIl, MonumentBuilding.field_175826_b, 32, 5, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, lllllllllllllllIlllIIIlIllIIIIII);
                    this.func_175811_a(lllllllllllllllIlllIIIlIllIIIIIl, MonumentBuilding.field_175826_b, 31, 6, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, lllllllllllllllIlllIIIlIllIIIIII);
                    this.func_175811_a(lllllllllllllllIlllIIIlIllIIIIIl, MonumentBuilding.field_175825_e, 31, 5, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, lllllllllllllllIlllIIIlIllIIIIII);
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIIIIIl, lllllllllllllllIlllIIIlIllIIIIII, 27, 6, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, 30, 6, 5 + lllllllllllllllIlllIIIlIllIIIIll * 4, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                }
            }
        }
        
        private void func_175837_c(final World lllllllllllllllIlllIIIlIlIllIlII, final Random lllllllllllllllIlllIIIlIlIlllIII, final StructureBoundingBox lllllllllllllllIlllIIIlIlIllIIll) {
            if (this.func_175818_a(lllllllllllllllIlllIIIlIlIllIIll, 15, 20, 42, 21)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 15, 0, 21, 42, 0, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 26, 1, 21, 31, 3, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 21, 12, 21, 36, 12, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 17, 11, 21, 40, 11, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 16, 10, 21, 41, 10, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 15, 7, 21, 42, 9, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 16, 6, 21, 41, 6, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 17, 5, 21, 40, 5, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 21, 4, 21, 36, 4, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 22, 3, 21, 26, 3, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 31, 3, 21, 35, 3, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 23, 2, 21, 25, 2, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 32, 2, 21, 34, 2, 21, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 28, 4, 20, 29, 4, 21, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175826_b, 27, 3, 21, lllllllllllllllIlllIIIlIlIllIIll);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175826_b, 30, 3, 21, lllllllllllllllIlllIIIlIlIllIIll);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175826_b, 26, 2, 21, lllllllllllllllIlllIIIlIlIllIIll);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175826_b, 31, 2, 21, lllllllllllllllIlllIIIlIlIllIIll);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175826_b, 25, 1, 21, lllllllllllllllIlllIIIlIlIllIIll);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175826_b, 32, 1, 21, lllllllllllllllIlllIIIlIlIllIIll);
                for (int lllllllllllllllIlllIIIlIlIllIllI = 0; lllllllllllllllIlllIIIlIlIllIllI < 7; ++lllllllllllllllIlllIIIlIlIllIllI) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175827_c, 28 - lllllllllllllllIlllIIIlIlIllIllI, 6 + lllllllllllllllIlllIIIlIlIllIllI, 21, lllllllllllllllIlllIIIlIlIllIIll);
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175827_c, 29 + lllllllllllllllIlllIIIlIlIllIllI, 6 + lllllllllllllllIlllIIIlIlIllIllI, 21, lllllllllllllllIlllIIIlIlIllIIll);
                }
                for (int lllllllllllllllIlllIIIlIlIllIllI = 0; lllllllllllllllIlllIIIlIlIllIllI < 4; ++lllllllllllllllIlllIIIlIlIllIllI) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175827_c, 28 - lllllllllllllllIlllIIIlIlIllIllI, 9 + lllllllllllllllIlllIIIlIlIllIllI, 21, lllllllllllllllIlllIIIlIlIllIIll);
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175827_c, 29 + lllllllllllllllIlllIIIlIlIllIllI, 9 + lllllllllllllllIlllIIIlIlIllIllI, 21, lllllllllllllllIlllIIIlIlIllIIll);
                }
                this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175827_c, 28, 12, 21, lllllllllllllllIlllIIIlIlIllIIll);
                this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175827_c, 29, 12, 21, lllllllllllllllIlllIIIlIlIllIIll);
                for (int lllllllllllllllIlllIIIlIlIllIllI = 0; lllllllllllllllIlllIIIlIlIllIllI < 3; ++lllllllllllllllIlllIIIlIlIllIllI) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175827_c, 22 - lllllllllllllllIlllIIIlIlIllIllI * 2, 8, 21, lllllllllllllllIlllIIIlIlIllIIll);
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175827_c, 22 - lllllllllllllllIlllIIIlIlIllIllI * 2, 9, 21, lllllllllllllllIlllIIIlIlIllIIll);
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175827_c, 35 + lllllllllllllllIlllIIIlIlIllIllI * 2, 8, 21, lllllllllllllllIlllIIIlIlIllIIll);
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIllIlII, MonumentBuilding.field_175827_c, 35 + lllllllllllllllIlllIIIlIlIllIllI * 2, 9, 21, lllllllllllllllIlllIIIlIlIllIIll);
                }
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 15, 13, 21, 42, 15, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 15, 1, 21, 15, 6, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 16, 1, 21, 16, 5, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 17, 1, 21, 20, 4, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 21, 1, 21, 21, 3, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 22, 1, 21, 22, 2, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 23, 1, 21, 24, 1, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 42, 1, 21, 42, 6, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 41, 1, 21, 41, 5, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 37, 1, 21, 40, 4, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 36, 1, 21, 36, 3, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 35, 1, 21, 35, 2, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIllIlII, lllllllllllllllIlllIIIlIlIllIIll, 33, 1, 21, 34, 1, 21, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
            }
        }
        
        private void func_175838_g(final World lllllllllllllllIlllIIIlIlIIIIIIl, final Random lllllllllllllllIlllIIIlIlIIIIIII, final StructureBoundingBox lllllllllllllllIlllIIIlIIlllllll) {
            if (this.func_175818_a(lllllllllllllllIlllIIIlIIlllllll, 14, 21, 20, 43)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 14, 0, 21, 20, 0, 43, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 14, 1, 22, 20, 14, 43, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 18, 12, 22, 20, 12, 39, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 18, 12, 21, 20, 12, 21, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                for (int lllllllllllllllIlllIIIlIIllllllI = 0; lllllllllllllllIlllIIIlIIllllllI < 4; ++lllllllllllllllIlllIIIlIIllllllI) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, lllllllllllllllIlllIIIlIIllllllI + 14, lllllllllllllllIlllIIIlIIllllllI + 9, 21, lllllllllllllllIlllIIIlIIllllllI + 14, lllllllllllllllIlllIIIlIIllllllI + 9, 43 - lllllllllllllllIlllIIIlIIllllllI, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
                for (int lllllllllllllllIlllIIIlIIllllllI = 23; lllllllllllllllIlllIIIlIIllllllI <= 39; lllllllllllllllIlllIIIlIIllllllI += 3) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIIIIIIl, MonumentBuilding.field_175824_d, 19, 13, lllllllllllllllIlllIIIlIIllllllI, lllllllllllllllIlllIIIlIIlllllll);
                }
            }
            if (this.func_175818_a(lllllllllllllllIlllIIIlIIlllllll, 37, 21, 43, 43)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 37, 0, 21, 43, 0, 43, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 37, 1, 22, 43, 14, 43, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 37, 12, 22, 39, 12, 39, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 37, 12, 21, 39, 12, 21, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                for (int lllllllllllllllIlllIIIlIIlllllIl = 0; lllllllllllllllIlllIIIlIIlllllIl < 4; ++lllllllllllllllIlllIIIlIIlllllIl) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 43 - lllllllllllllllIlllIIIlIIlllllIl, lllllllllllllllIlllIIIlIIlllllIl + 9, 21, 43 - lllllllllllllllIlllIIIlIIlllllIl, lllllllllllllllIlllIIIlIIlllllIl + 9, 43 - lllllllllllllllIlllIIIlIIlllllIl, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
                for (int lllllllllllllllIlllIIIlIIlllllIl = 23; lllllllllllllllIlllIIIlIIlllllIl <= 39; lllllllllllllllIlllIIIlIIlllllIl += 3) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIIIIIIl, MonumentBuilding.field_175824_d, 38, 13, lllllllllllllllIlllIIIlIIlllllIl, lllllllllllllllIlllIIIlIIlllllll);
                }
            }
            if (this.func_175818_a(lllllllllllllllIlllIIIlIIlllllll, 15, 37, 42, 43)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 21, 0, 37, 36, 0, 43, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 21, 1, 37, 36, 14, 43, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 21, 12, 37, 36, 12, 39, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                for (int lllllllllllllllIlllIIIlIIlllllII = 0; lllllllllllllllIlllIIIlIIlllllII < 4; ++lllllllllllllllIlllIIIlIIlllllII) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIIIIIIl, lllllllllllllllIlllIIIlIIlllllll, 15 + lllllllllllllllIlllIIIlIIlllllII, lllllllllllllllIlllIIIlIIlllllII + 9, 43 - lllllllllllllllIlllIIIlIIlllllII, 42 - lllllllllllllllIlllIIIlIIlllllII, lllllllllllllllIlllIIIlIIlllllII + 9, 43 - lllllllllllllllIlllIIIlIIlllllII, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
                for (int lllllllllllllllIlllIIIlIIlllllII = 21; lllllllllllllllIlllIIIlIIlllllII <= 36; lllllllllllllllIlllIIIlIIlllllII += 3) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIIIIIIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIIlllllII, 13, 38, lllllllllllllllIlllIIIlIIlllllll);
                }
            }
        }
        
        public MonumentBuilding(final Random lllllllllllllllIlllIIIllIllIlIlI, final int lllllllllllllllIlllIIIllIllIlIIl, final int lllllllllllllllIlllIIIllIlllllII, final EnumFacing lllllllllllllllIlllIIIllIllllIll) {
            super(0);
            this.field_175843_q = Lists.newArrayList();
            this.coordBaseMode = lllllllllllllllIlllIIIllIllllIll;
            switch (StructureOceanMonumentPieces.SwitchEnumFacing.field_175971_a[this.coordBaseMode.ordinal()]) {
                case 1:
                case 2: {
                    this.boundingBox = new StructureBoundingBox(lllllllllllllllIlllIIIllIllIlIIl, 39, lllllllllllllllIlllIIIllIlllllII, lllllllllllllllIlllIIIllIllIlIIl + 58 - 1, 61, lllllllllllllllIlllIIIllIlllllII + 58 - 1);
                    break;
                }
                default: {
                    this.boundingBox = new StructureBoundingBox(lllllllllllllllIlllIIIllIllIlIIl, 39, lllllllllllllllIlllIIIllIlllllII, lllllllllllllllIlllIIIllIllIlIIl + 58 - 1, 61, lllllllllllllllIlllIIIllIlllllII + 58 - 1);
                    break;
                }
            }
            final List lllllllllllllllIlllIIIllIllllIlI = this.func_175836_a(lllllllllllllllIlllIIIllIllIlIlI);
            this.field_175845_o.field_175963_d = true;
            this.field_175843_q.add(new EntryRoom(this.coordBaseMode, this.field_175845_o));
            this.field_175843_q.add(new MonumentCoreRoom(this.coordBaseMode, this.field_175844_p, lllllllllllllllIlllIIIllIllIlIlI));
            final ArrayList lllllllllllllllIlllIIIllIllllIIl = Lists.newArrayList();
            lllllllllllllllIlllIIIllIllllIIl.add(new XYDoubleRoomFitHelper(null));
            lllllllllllllllIlllIIIllIllllIIl.add(new YZDoubleRoomFitHelper(null));
            lllllllllllllllIlllIIIllIllllIIl.add(new ZDoubleRoomFitHelper(null));
            lllllllllllllllIlllIIIllIllllIIl.add(new XDoubleRoomFitHelper(null));
            lllllllllllllllIlllIIIllIllllIIl.add(new YDoubleRoomFitHelper(null));
            lllllllllllllllIlllIIIllIllllIIl.add(new FitSimpleRoomTopHelper(null));
            lllllllllllllllIlllIIIllIllllIIl.add(new FitSimpleRoomHelper(null));
            for (final RoomDefinition lllllllllllllllIlllIIIllIlllIlll : lllllllllllllllIlllIIIllIllllIlI) {
                if (!lllllllllllllllIlllIIIllIlllIlll.field_175963_d && !lllllllllllllllIlllIIIllIlllIlll.func_175961_b()) {
                    for (final MonumentRoomFitHelper lllllllllllllllIlllIIIllIlllIlIl : lllllllllllllllIlllIIIllIllllIIl) {
                        if (lllllllllllllllIlllIIIllIlllIlIl.func_175969_a(lllllllllllllllIlllIIIllIlllIlll)) {
                            this.field_175843_q.add(lllllllllllllllIlllIIIllIlllIlIl.func_175968_a(this.coordBaseMode, lllllllllllllllIlllIIIllIlllIlll, lllllllllllllllIlllIIIllIllIlIlI));
                            break;
                        }
                    }
                }
            }
            final int lllllllllllllllIlllIIIllIlllIlII = this.boundingBox.minY;
            final int lllllllllllllllIlllIIIllIlllIIll = this.getXWithOffset(9, 22);
            final int lllllllllllllllIlllIIIllIlllIIlI = this.getZWithOffset(9, 22);
            for (final Piece lllllllllllllllIlllIIIllIlllIIII : this.field_175843_q) {
                lllllllllllllllIlllIIIllIlllIIII.getBoundingBox().offset(lllllllllllllllIlllIIIllIlllIIll, lllllllllllllllIlllIIIllIlllIlII, lllllllllllllllIlllIIIllIlllIIlI);
            }
            final StructureBoundingBox lllllllllllllllIlllIIIllIllIllll = StructureBoundingBox.func_175899_a(this.getXWithOffset(1, 1), this.getYWithOffset(1), this.getZWithOffset(1, 1), this.getXWithOffset(23, 21), this.getYWithOffset(8), this.getZWithOffset(23, 21));
            final StructureBoundingBox lllllllllllllllIlllIIIllIllIlllI = StructureBoundingBox.func_175899_a(this.getXWithOffset(34, 1), this.getYWithOffset(1), this.getZWithOffset(34, 1), this.getXWithOffset(56, 21), this.getYWithOffset(8), this.getZWithOffset(56, 21));
            final StructureBoundingBox lllllllllllllllIlllIIIllIllIllIl = StructureBoundingBox.func_175899_a(this.getXWithOffset(22, 22), this.getYWithOffset(13), this.getZWithOffset(22, 22), this.getXWithOffset(35, 35), this.getYWithOffset(17), this.getZWithOffset(35, 35));
            int lllllllllllllllIlllIIIllIllIllII = lllllllllllllllIlllIIIllIllIlIlI.nextInt();
            this.field_175843_q.add(new WingRoom(this.coordBaseMode, lllllllllllllllIlllIIIllIllIllll, lllllllllllllllIlllIIIllIllIllII++));
            this.field_175843_q.add(new WingRoom(this.coordBaseMode, lllllllllllllllIlllIIIllIllIlllI, lllllllllllllllIlllIIIllIllIllII++));
            this.field_175843_q.add(new Penthouse(this.coordBaseMode, lllllllllllllllIlllIIIllIllIllIl));
        }
        
        private List func_175836_a(final Random lllllllllllllllIlllIIIllIlIIIlIl) {
            final RoomDefinition[] lllllllllllllllIlllIIIllIlIIIlII = new RoomDefinition[75];
            for (int lllllllllllllllIlllIIIllIlIIIIll = 0; lllllllllllllllIlllIIIllIlIIIIll < 5; ++lllllllllllllllIlllIIIllIlIIIIll) {
                for (int lllllllllllllllIlllIIIllIlIIIIlI = 0; lllllllllllllllIlllIIIllIlIIIIlI < 4; ++lllllllllllllllIlllIIIllIlIIIIlI) {
                    final byte lllllllllllllllIlllIIIllIIlllllI = 0;
                    final int lllllllllllllllIlllIIIllIIlllIll = Piece.func_175820_a(lllllllllllllllIlllIIIllIlIIIIll, lllllllllllllllIlllIIIllIIlllllI, lllllllllllllllIlllIIIllIlIIIIlI);
                    lllllllllllllllIlllIIIllIlIIIlII[lllllllllllllllIlllIIIllIIlllIll] = new RoomDefinition(lllllllllllllllIlllIIIllIIlllIll);
                }
            }
            for (int lllllllllllllllIlllIIIllIlIIIIll = 0; lllllllllllllllIlllIIIllIlIIIIll < 5; ++lllllllllllllllIlllIIIllIlIIIIll) {
                for (int lllllllllllllllIlllIIIllIlIIIIIl = 0; lllllllllllllllIlllIIIllIlIIIIIl < 4; ++lllllllllllllllIlllIIIllIlIIIIIl) {
                    final byte lllllllllllllllIlllIIIllIIllllIl = 1;
                    final int lllllllllllllllIlllIIIllIIlllIlI = Piece.func_175820_a(lllllllllllllllIlllIIIllIlIIIIll, lllllllllllllllIlllIIIllIIllllIl, lllllllllllllllIlllIIIllIlIIIIIl);
                    lllllllllllllllIlllIIIllIlIIIlII[lllllllllllllllIlllIIIllIIlllIlI] = new RoomDefinition(lllllllllllllllIlllIIIllIIlllIlI);
                }
            }
            for (int lllllllllllllllIlllIIIllIlIIIIll = 1; lllllllllllllllIlllIIIllIlIIIIll < 4; ++lllllllllllllllIlllIIIllIlIIIIll) {
                for (int lllllllllllllllIlllIIIllIlIIIIII = 0; lllllllllllllllIlllIIIllIlIIIIII < 2; ++lllllllllllllllIlllIIIllIlIIIIII) {
                    final byte lllllllllllllllIlllIIIllIIllllII = 2;
                    final int lllllllllllllllIlllIIIllIIlllIIl = Piece.func_175820_a(lllllllllllllllIlllIIIllIlIIIIll, lllllllllllllllIlllIIIllIIllllII, lllllllllllllllIlllIIIllIlIIIIII);
                    lllllllllllllllIlllIIIllIlIIIlII[lllllllllllllllIlllIIIllIIlllIIl] = new RoomDefinition(lllllllllllllllIlllIIIllIIlllIIl);
                }
            }
            this.field_175845_o = lllllllllllllllIlllIIIllIlIIIlII[MonumentBuilding.field_175823_g];
            for (int lllllllllllllllIlllIIIllIlIIIIll = 0; lllllllllllllllIlllIIIllIlIIIIll < 5; ++lllllllllllllllIlllIIIllIlIIIIll) {
                for (int lllllllllllllllIlllIIIllIIllllll = 0; lllllllllllllllIlllIIIllIIllllll < 5; ++lllllllllllllllIlllIIIllIIllllll) {
                    for (int lllllllllllllllIlllIIIllIIlIllIl = 0; lllllllllllllllIlllIIIllIIlIllIl < 3; ++lllllllllllllllIlllIIIllIIlIllIl) {
                        final int lllllllllllllllIlllIIIllIIlllIII = Piece.func_175820_a(lllllllllllllllIlllIIIllIlIIIIll, lllllllllllllllIlllIIIllIIlIllIl, lllllllllllllllIlllIIIllIIllllll);
                        if (lllllllllllllllIlllIIIllIlIIIlII[lllllllllllllllIlllIIIllIIlllIII] != null) {
                            for (final EnumFacing lllllllllllllllIlllIIIllIIlIlIll : EnumFacing.values()) {
                                final int lllllllllllllllIlllIIIllIIllIIll = lllllllllllllllIlllIIIllIlIIIIll + lllllllllllllllIlllIIIllIIlIlIll.getFrontOffsetX();
                                final int lllllllllllllllIlllIIIllIIllIIIl = lllllllllllllllIlllIIIllIIlIllIl + lllllllllllllllIlllIIIllIIlIlIll.getFrontOffsetY();
                                final int lllllllllllllllIlllIIIllIIlIllll = lllllllllllllllIlllIIIllIIllllll + lllllllllllllllIlllIIIllIIlIlIll.getFrontOffsetZ();
                                if (lllllllllllllllIlllIIIllIIllIIll >= 0 && lllllllllllllllIlllIIIllIIllIIll < 5 && lllllllllllllllIlllIIIllIIlIllll >= 0 && lllllllllllllllIlllIIIllIIlIllll < 5 && lllllllllllllllIlllIIIllIIllIIIl >= 0 && lllllllllllllllIlllIIIllIIllIIIl < 3) {
                                    final int lllllllllllllllIlllIIIllIIlIlIlI = Piece.func_175820_a(lllllllllllllllIlllIIIllIIllIIll, lllllllllllllllIlllIIIllIIllIIIl, lllllllllllllllIlllIIIllIIlIllll);
                                    if (lllllllllllllllIlllIIIllIlIIIlII[lllllllllllllllIlllIIIllIIlIlIlI] != null) {
                                        if (lllllllllllllllIlllIIIllIIlIllll != lllllllllllllllIlllIIIllIIllllll) {
                                            lllllllllllllllIlllIIIllIlIIIlII[lllllllllllllllIlllIIIllIIlllIII].func_175957_a(lllllllllllllllIlllIIIllIIlIlIll.getOpposite(), lllllllllllllllIlllIIIllIlIIIlII[lllllllllllllllIlllIIIllIIlIlIlI]);
                                        }
                                        else {
                                            lllllllllllllllIlllIIIllIlIIIlII[lllllllllllllllIlllIIIllIIlllIII].func_175957_a(lllllllllllllllIlllIIIllIIlIlIll, lllllllllllllllIlllIIIllIlIIIlII[lllllllllllllllIlllIIIllIIlIlIlI]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final RoomDefinition lllllllllllllllIlllIIIllIIlIlIIl;
            lllllllllllllllIlllIIIllIlIIIlII[MonumentBuilding.field_175831_h].func_175957_a(EnumFacing.UP, lllllllllllllllIlllIIIllIIlIlIIl = new RoomDefinition(1003));
            final RoomDefinition lllllllllllllllIlllIIIllIIlIlIII;
            lllllllllllllllIlllIIIllIlIIIlII[MonumentBuilding.field_175832_i].func_175957_a(EnumFacing.SOUTH, lllllllllllllllIlllIIIllIIlIlIII = new RoomDefinition(1001));
            final RoomDefinition lllllllllllllllIlllIIIllIIlIIlll;
            lllllllllllllllIlllIIIllIlIIIlII[MonumentBuilding.field_175829_j].func_175957_a(EnumFacing.SOUTH, lllllllllllllllIlllIIIllIIlIIlll = new RoomDefinition(1002));
            lllllllllllllllIlllIIIllIIlIlIIl.field_175963_d = true;
            lllllllllllllllIlllIIIllIIlIlIII.field_175963_d = true;
            lllllllllllllllIlllIIIllIIlIIlll.field_175963_d = true;
            this.field_175845_o.field_175964_e = true;
            this.field_175844_p = lllllllllllllllIlllIIIllIlIIIlII[Piece.func_175820_a(lllllllllllllllIlllIIIllIlIIIlIl.nextInt(4), 0, 2)];
            this.field_175844_p.field_175963_d = true;
            this.field_175844_p.field_175965_b[EnumFacing.EAST.getIndex()].field_175963_d = true;
            this.field_175844_p.field_175965_b[EnumFacing.NORTH.getIndex()].field_175963_d = true;
            this.field_175844_p.field_175965_b[EnumFacing.EAST.getIndex()].field_175965_b[EnumFacing.NORTH.getIndex()].field_175963_d = true;
            this.field_175844_p.field_175965_b[EnumFacing.UP.getIndex()].field_175963_d = true;
            this.field_175844_p.field_175965_b[EnumFacing.EAST.getIndex()].field_175965_b[EnumFacing.UP.getIndex()].field_175963_d = true;
            this.field_175844_p.field_175965_b[EnumFacing.NORTH.getIndex()].field_175965_b[EnumFacing.UP.getIndex()].field_175963_d = true;
            this.field_175844_p.field_175965_b[EnumFacing.EAST.getIndex()].field_175965_b[EnumFacing.NORTH.getIndex()].field_175965_b[EnumFacing.UP.getIndex()].field_175963_d = true;
            final ArrayList lllllllllllllllIlllIIIllIIlIIllI = Lists.newArrayList();
            final RoomDefinition[] lllllllllllllllIlllIIIllIIlIIlIl = lllllllllllllllIlllIIIllIlIIIlII;
            for (int lllllllllllllllIlllIIIllIIllIllI = lllllllllllllllIlllIIIllIlIIIlII.length, lllllllllllllllIlllIIIllIIllIlII = 0; lllllllllllllllIlllIIIllIIllIlII < lllllllllllllllIlllIIIllIIllIllI; ++lllllllllllllllIlllIIIllIIllIlII) {
                final RoomDefinition lllllllllllllllIlllIIIllIIlIIlII = lllllllllllllllIlllIIIllIIlIIlIl[lllllllllllllllIlllIIIllIIllIlII];
                if (lllllllllllllllIlllIIIllIIlIIlII != null) {
                    lllllllllllllllIlllIIIllIIlIIlII.func_175958_a();
                    lllllllllllllllIlllIIIllIIlIIllI.add(lllllllllllllllIlllIIIllIIlIIlII);
                }
            }
            lllllllllllllllIlllIIIllIIlIlIIl.func_175958_a();
            Collections.shuffle(lllllllllllllllIlllIIIllIIlIIllI, lllllllllllllllIlllIIIllIlIIIlIl);
            int lllllllllllllllIlllIIIllIIlIIIll = 1;
            for (final RoomDefinition lllllllllllllllIlllIIIllIIlIIIIl : lllllllllllllllIlllIIIllIIlIIllI) {
                int lllllllllllllllIlllIIIllIIlIIIII = 0;
                int lllllllllllllllIlllIIIllIIllIIlI = 0;
                while (lllllllllllllllIlllIIIllIIlIIIII < 2 && lllllllllllllllIlllIIIllIIllIIlI < 5) {
                    ++lllllllllllllllIlllIIIllIIllIIlI;
                    final int lllllllllllllllIlllIIIllIIllIIII = lllllllllllllllIlllIIIllIlIIIlIl.nextInt(6);
                    if (lllllllllllllllIlllIIIllIIlIIIIl.field_175966_c[lllllllllllllllIlllIIIllIIllIIII]) {
                        final int lllllllllllllllIlllIIIllIIlIlllI = EnumFacing.getFront(lllllllllllllllIlllIIIllIIllIIII).getOpposite().getIndex();
                        lllllllllllllllIlllIIIllIIlIIIIl.field_175966_c[lllllllllllllllIlllIIIllIIllIIII] = false;
                        lllllllllllllllIlllIIIllIIlIIIIl.field_175965_b[lllllllllllllllIlllIIIllIIllIIII].field_175966_c[lllllllllllllllIlllIIIllIIlIlllI] = false;
                        if (lllllllllllllllIlllIIIllIIlIIIIl.func_175959_a(lllllllllllllllIlllIIIllIIlIIIll++) && lllllllllllllllIlllIIIllIIlIIIIl.field_175965_b[lllllllllllllllIlllIIIllIIllIIII].func_175959_a(lllllllllllllllIlllIIIllIIlIIIll++)) {
                            ++lllllllllllllllIlllIIIllIIlIIIII;
                        }
                        else {
                            lllllllllllllllIlllIIIllIIlIIIIl.field_175966_c[lllllllllllllllIlllIIIllIIllIIII] = true;
                            lllllllllllllllIlllIIIllIIlIIIIl.field_175965_b[lllllllllllllllIlllIIIllIIllIIII].field_175966_c[lllllllllllllllIlllIIIllIIlIlllI] = true;
                        }
                    }
                }
            }
            lllllllllllllllIlllIIIllIIlIIllI.add(lllllllllllllllIlllIIIllIIlIlIIl);
            lllllllllllllllIlllIIIllIIlIIllI.add(lllllllllllllllIlllIIIllIIlIlIII);
            lllllllllllllllIlllIIIllIIlIIllI.add(lllllllllllllllIlllIIIllIIlIIlll);
            return lllllllllllllllIlllIIIllIIlIIllI;
        }
        
        private void func_175835_e(final World lllllllllllllllIlllIIIlIlIIlllll, final Random lllllllllllllllIlllIIIlIlIIllllI, final StructureBoundingBox lllllllllllllllIlllIIIlIlIIlIlll) {
            if (this.func_175818_a(lllllllllllllllIlllIIIlIlIIlIlll, 0, 21, 6, 58)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 0, 0, 21, 6, 0, 57, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 0, 1, 21, 6, 7, 57, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 4, 4, 21, 6, 4, 53, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                for (int lllllllllllllllIlllIIIlIlIIlllII = 0; lllllllllllllllIlllIIIlIlIIlllII < 4; ++lllllllllllllllIlllIIIlIlIIlllII) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, lllllllllllllllIlllIIIlIlIIlllII, lllllllllllllllIlllIIIlIlIIlllII + 1, 21, lllllllllllllllIlllIIIlIlIIlllII, lllllllllllllllIlllIIIlIlIIlllII + 1, 57 - lllllllllllllllIlllIIIlIlIIlllII, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
                for (int lllllllllllllllIlllIIIlIlIIlllII = 23; lllllllllllllllIlllIIIlIlIIlllII < 53; lllllllllllllllIlllIIIlIlIIlllII += 3) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIIlllll, MonumentBuilding.field_175824_d, 5, 5, lllllllllllllllIlllIIIlIlIIlllII, lllllllllllllllIlllIIIlIlIIlIlll);
                }
                this.func_175811_a(lllllllllllllllIlllIIIlIlIIlllll, MonumentBuilding.field_175824_d, 5, 5, 52, lllllllllllllllIlllIIIlIlIIlIlll);
                for (int lllllllllllllllIlllIIIlIlIIlllII = 0; lllllllllllllllIlllIIIlIlIIlllII < 4; ++lllllllllllllllIlllIIIlIlIIlllII) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, lllllllllllllllIlllIIIlIlIIlllII, lllllllllllllllIlllIIIlIlIIlllII + 1, 21, lllllllllllllllIlllIIIlIlIIlllII, lllllllllllllllIlllIIIlIlIIlllII + 1, 57 - lllllllllllllllIlllIIIlIlIIlllII, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 4, 1, 52, 6, 3, 52, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 5, 1, 51, 5, 3, 53, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
            }
            if (this.func_175818_a(lllllllllllllllIlllIIIlIlIIlIlll, 51, 21, 58, 58)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 51, 0, 21, 57, 0, 57, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 51, 1, 21, 57, 7, 57, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 51, 4, 21, 53, 4, 53, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                for (int lllllllllllllllIlllIIIlIlIIllIll = 0; lllllllllllllllIlllIIIlIlIIllIll < 4; ++lllllllllllllllIlllIIIlIlIIllIll) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 57 - lllllllllllllllIlllIIIlIlIIllIll, lllllllllllllllIlllIIIlIlIIllIll + 1, 21, 57 - lllllllllllllllIlllIIIlIlIIllIll, lllllllllllllllIlllIIIlIlIIllIll + 1, 57 - lllllllllllllllIlllIIIlIlIIllIll, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
                for (int lllllllllllllllIlllIIIlIlIIllIll = 23; lllllllllllllllIlllIIIlIlIIllIll < 53; lllllllllllllllIlllIIIlIlIIllIll += 3) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIlIIlllll, MonumentBuilding.field_175824_d, 52, 5, lllllllllllllllIlllIIIlIlIIllIll, lllllllllllllllIlllIIIlIlIIlIlll);
                }
                this.func_175811_a(lllllllllllllllIlllIIIlIlIIlllll, MonumentBuilding.field_175824_d, 52, 5, 52, lllllllllllllllIlllIIIlIlIIlIlll);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 51, 1, 52, 53, 3, 52, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 52, 1, 51, 52, 3, 53, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
            }
            if (this.func_175818_a(lllllllllllllllIlllIIIlIlIIlIlll, 0, 51, 57, 57)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 7, 0, 51, 50, 0, 57, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, 7, 1, 51, 50, 10, 57, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                for (int lllllllllllllllIlllIIIlIlIIllIlI = 0; lllllllllllllllIlllIIIlIlIIllIlI < 4; ++lllllllllllllllIlllIIIlIlIIllIlI) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIlIIlllll, lllllllllllllllIlllIIIlIlIIlIlll, lllllllllllllllIlllIIIlIlIIllIlI + 1, lllllllllllllllIlllIIIlIlIIllIlI + 1, 57 - lllllllllllllllIlllIIIlIlIIllIlI, 56 - lllllllllllllllIlllIIIlIlIIllIlI, lllllllllllllllIlllIIIlIlIIllIlI + 1, 57 - lllllllllllllllIlllIIIlIlIIllIlI, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
            }
        }
        
        private void func_175840_a(final boolean lllllllllllllllIlllIIIlIllIlIlII, final int lllllllllllllllIlllIIIlIllIlIIll, final World lllllllllllllllIlllIIIlIllIlllIl, final Random lllllllllllllllIlllIIIlIllIlllII, final StructureBoundingBox lllllllllllllllIlllIIIlIllIllIll) {
            final boolean lllllllllllllllIlllIIIlIllIllIlI = true;
            if (this.func_175818_a(lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll, 0, lllllllllllllllIlllIIIlIllIlIIll + 23, 20)) {
                this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + 0, 0, 0, lllllllllllllllIlllIIIlIllIlIIll + 24, 0, 20, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + 0, 1, 0, lllllllllllllllIlllIIIlIllIlIIll + 24, 10, 20, MonumentBuilding.field_175822_f, MonumentBuilding.field_175822_f, false);
                for (int lllllllllllllllIlllIIIlIllIllIIl = 0; lllllllllllllllIlllIIIlIllIllIIl < 4; ++lllllllllllllllIlllIIIlIllIllIIl) {
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIllIIl + 1, lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIlIIll + lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIllIIl + 1, 20, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + lllllllllllllllIlllIIIlIllIllIIl + 7, lllllllllllllllIlllIIIlIllIllIIl + 5, lllllllllllllllIlllIIIlIllIllIIl + 7, lllllllllllllllIlllIIIlIllIlIIll + lllllllllllllllIlllIIIlIllIllIIl + 7, lllllllllllllllIlllIIIlIllIllIIl + 5, 20, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + 17 - lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIllIIl + 5, lllllllllllllllIlllIIIlIllIllIIl + 7, lllllllllllllllIlllIIIlIllIlIIll + 17 - lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIllIIl + 5, 20, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + 24 - lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIllIIl + 1, lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIlIIll + 24 - lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIllIIl + 1, 20, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + lllllllllllllllIlllIIIlIllIllIIl + 1, lllllllllllllllIlllIIIlIllIllIIl + 1, lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIlIIll + 23 - lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIllIIl + 1, lllllllllllllllIlllIIIlIllIllIIl, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                    this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + lllllllllllllllIlllIIIlIllIllIIl + 8, lllllllllllllllIlllIIIlIllIllIIl + 5, lllllllllllllllIlllIIIlIllIllIIl + 7, lllllllllllllllIlllIIIlIllIlIIll + 16 - lllllllllllllllIlllIIIlIllIllIIl, lllllllllllllllIlllIIIlIllIllIIl + 5, lllllllllllllllIlllIIIlIllIllIIl + 7, MonumentBuilding.field_175826_b, MonumentBuilding.field_175826_b, false);
                }
                this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + 4, 4, 4, lllllllllllllllIlllIIIlIllIlIIll + 6, 4, 20, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + 7, 4, 4, lllllllllllllllIlllIIIlIllIlIIll + 17, 4, 6, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + 18, 4, 4, lllllllllllllllIlllIIIlIllIlIIll + 20, 4, 20, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + 11, 8, 11, lllllllllllllllIlllIIIlIllIlIIll + 13, 8, 20, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175811_a(lllllllllllllllIlllIIIlIllIlllIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIllIlIIll + 12, 9, 12, lllllllllllllllIlllIIIlIllIllIll);
                this.func_175811_a(lllllllllllllllIlllIIIlIllIlllIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIllIlIIll + 12, 9, 15, lllllllllllllllIlllIIIlIllIllIll);
                this.func_175811_a(lllllllllllllllIlllIIIlIllIlllIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIllIlIIll + 12, 9, 18, lllllllllllllllIlllIIIlIllIllIll);
                int lllllllllllllllIlllIIIlIllIllIIl = lllllllllllllllIlllIIIlIllIlIlII ? (lllllllllllllllIlllIIIlIllIlIIll + 19) : (lllllllllllllllIlllIIIlIllIlIIll + 5);
                final int lllllllllllllllIlllIIIlIllIllIII = lllllllllllllllIlllIIIlIllIlIlII ? (lllllllllllllllIlllIIIlIllIlIIll + 5) : (lllllllllllllllIlllIIIlIllIlIIll + 19);
                for (int lllllllllllllllIlllIIIlIllIlIlll = 20; lllllllllllllllIlllIIIlIllIlIlll >= 5; lllllllllllllllIlllIIIlIllIlIlll -= 3) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIllIlllIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIllIllIIl, 5, lllllllllllllllIlllIIIlIllIlIlll, lllllllllllllllIlllIIIlIllIllIll);
                }
                for (int lllllllllllllllIlllIIIlIllIlIlll = 19; lllllllllllllllIlllIIIlIllIlIlll >= 7; lllllllllllllllIlllIIIlIllIlIlll -= 3) {
                    this.func_175811_a(lllllllllllllllIlllIIIlIllIlllIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIllIllIII, 5, lllllllllllllllIlllIIIlIllIlIlll, lllllllllllllllIlllIIIlIllIllIll);
                }
                for (int lllllllllllllllIlllIIIlIllIlIlll = 0; lllllllllllllllIlllIIIlIllIlIlll < 4; ++lllllllllllllllIlllIIIlIllIlIlll) {
                    final int lllllllllllllllIlllIIIlIllIlIllI = lllllllllllllllIlllIIIlIllIlIlII ? (lllllllllllllllIlllIIIlIllIlIIll + (24 - (17 - lllllllllllllllIlllIIIlIllIlIlll * 3))) : (lllllllllllllllIlllIIIlIllIlIIll + 17 - lllllllllllllllIlllIIIlIllIlIlll * 3);
                    this.func_175811_a(lllllllllllllllIlllIIIlIllIlllIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIllIlIllI, 5, 5, lllllllllllllllIlllIIIlIllIllIll);
                }
                this.func_175811_a(lllllllllllllllIlllIIIlIllIlllIl, MonumentBuilding.field_175824_d, lllllllllllllllIlllIIIlIllIllIII, 5, 5, lllllllllllllllIlllIIIlIllIllIll);
                this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + 11, 1, 12, lllllllllllllllIlllIIIlIllIlIIll + 13, 7, 12, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
                this.func_175804_a(lllllllllllllllIlllIIIlIllIlllIl, lllllllllllllllIlllIIIlIllIllIll, lllllllllllllllIlllIIIlIllIlIIll + 12, 1, 11, lllllllllllllllIlllIIIlIllIlIIll + 12, 7, 13, MonumentBuilding.field_175828_a, MonumentBuilding.field_175828_a, false);
            }
        }
        
        public MonumentBuilding() {
            this.field_175843_q = Lists.newArrayList();
        }
        
        static {
            __OBFID = "CL_00001985";
        }
    }
    
    static class XDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        static {
            __OBFID = "CL_00001992";
        }
        
        @Override
        public boolean func_175969_a(final RoomDefinition llllllllllllllIlIIIIIIlIIlllllll) {
            return llllllllllllllIlIIIIIIlIIlllllll.field_175966_c[EnumFacing.EAST.getIndex()] && !llllllllllllllIlIIIIIIlIIlllllll.field_175965_b[EnumFacing.EAST.getIndex()].field_175963_d;
        }
        
        private XDoubleRoomFitHelper() {
        }
        
        XDoubleRoomFitHelper(final SwitchEnumFacing llllllllllllllIlIIIIIIlIIlllIIlI) {
            this();
        }
        
        @Override
        public Piece func_175968_a(final EnumFacing llllllllllllllIlIIIIIIlIIlllIlll, final RoomDefinition llllllllllllllIlIIIIIIlIIllllIIl, final Random llllllllllllllIlIIIIIIlIIlllIlIl) {
            llllllllllllllIlIIIIIIlIIllllIIl.field_175963_d = true;
            llllllllllllllIlIIIIIIlIIllllIIl.field_175965_b[EnumFacing.EAST.getIndex()].field_175963_d = true;
            return new DoubleXRoom(llllllllllllllIlIIIIIIlIIlllIlll, llllllllllllllIlIIIIIIlIIllllIIl, llllllllllllllIlIIIIIIlIIlllIlIl);
        }
    }
    
    public static class WingRoom extends Piece
    {
        private /* synthetic */ int field_175834_o;
        
        public WingRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIIlllIIIIIlIIIIlI, final Random llllllllllllllIIIlllIIIIIlIIIIIl, final StructureBoundingBox llllllllllllllIIIlllIIIIIlIIIIII) {
            if (this.field_175834_o == 0) {
                for (int llllllllllllllIIIlllIIIIIIllllll = 0; llllllllllllllIIIlllIIIIIIllllll < 4; ++llllllllllllllIIIlllIIIIIIllllll) {
                    this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 10 - llllllllllllllIIIlllIIIIIIllllll, 3 - llllllllllllllIIIlllIIIIIIllllll, 20 - llllllllllllllIIIlllIIIIIIllllll, 12 + llllllllllllllIIIlllIIIIIIllllll, 3 - llllllllllllllIIIlllIIIIIIllllll, 20, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                }
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 7, 0, 6, 15, 0, 16, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 6, 0, 6, 6, 3, 20, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 16, 0, 6, 16, 3, 20, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 7, 1, 7, 7, 1, 20, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 15, 1, 7, 15, 1, 20, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 7, 1, 6, 9, 3, 6, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 13, 1, 6, 15, 3, 6, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 8, 1, 7, 9, 1, 7, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 13, 1, 7, 14, 1, 7, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 9, 0, 5, 13, 0, 5, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 10, 0, 7, 12, 0, 7, WingRoom.field_175827_c, WingRoom.field_175827_c, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 8, 0, 10, 8, 0, 12, WingRoom.field_175827_c, WingRoom.field_175827_c, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 14, 0, 10, 14, 0, 12, WingRoom.field_175827_c, WingRoom.field_175827_c, false);
                for (int llllllllllllllIIIlllIIIIIIllllll = 18; llllllllllllllIIIlllIIIIIIllllll >= 7; llllllllllllllIIIlllIIIIIIllllll -= 3) {
                    this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 6, 3, llllllllllllllIIIlllIIIIIIllllll, llllllllllllllIIIlllIIIIIlIIIIII);
                    this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 16, 3, llllllllllllllIIIlllIIIIIIllllll, llllllllllllllIIIlllIIIIIlIIIIII);
                }
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 10, 0, 10, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 12, 0, 10, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 10, 0, 12, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 12, 0, 12, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 8, 3, 6, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 14, 3, 6, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, 4, 2, 4, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 4, 1, 4, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, 4, 0, 4, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, 18, 2, 4, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 18, 1, 4, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, 18, 0, 4, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, 4, 2, 18, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 4, 1, 18, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, 4, 0, 18, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, 18, 2, 18, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, 18, 1, 18, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, 18, 0, 18, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, 9, 7, 20, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, 13, 7, 20, llllllllllllllIIIlllIIIIIlIIIIII);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 6, 0, 21, 7, 4, 21, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 15, 0, 21, 16, 4, 21, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175817_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 11, 2, 16);
            }
            else if (this.field_175834_o == 1) {
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 9, 3, 18, 13, 3, 20, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 9, 0, 18, 9, 2, 18, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 13, 0, 18, 13, 2, 18, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                byte llllllllllllllIIIlllIIIIIIlllllI = 9;
                final byte llllllllllllllIIIlllIIIIIIllllIl = 20;
                final byte llllllllllllllIIIlllIIIIIIllllII = 5;
                for (int llllllllllllllIIIlllIIIIIIlllIll = 0; llllllllllllllIIIlllIIIIIIlllIll < 2; ++llllllllllllllIIIlllIIIIIIlllIll) {
                    this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, llllllllllllllIIIlllIIIIIIlllllI, llllllllllllllIIIlllIIIIIIllllII + 1, llllllllllllllIIIlllIIIIIIllllIl, llllllllllllllIIIlllIIIIIlIIIIII);
                    this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, llllllllllllllIIIlllIIIIIIlllllI, llllllllllllllIIIlllIIIIIIllllII, llllllllllllllIIIlllIIIIIIllllIl, llllllllllllllIIIlllIIIIIlIIIIII);
                    this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175826_b, llllllllllllllIIIlllIIIIIIlllllI, llllllllllllllIIIlllIIIIIIllllII - 1, llllllllllllllIIIlllIIIIIIllllIl, llllllllllllllIIIlllIIIIIlIIIIII);
                    llllllllllllllIIIlllIIIIIIlllllI = 13;
                }
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 7, 3, 7, 15, 3, 14, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                llllllllllllllIIIlllIIIIIIlllllI = 10;
                for (int llllllllllllllIIIlllIIIIIIlllIll = 0; llllllllllllllIIIlllIIIIIIlllIll < 2; ++llllllllllllllIIIlllIIIIIIlllIll) {
                    this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, llllllllllllllIIIlllIIIIIIlllllI, 0, 10, llllllllllllllIIIlllIIIIIIlllllI, 6, 10, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, llllllllllllllIIIlllIIIIIIlllllI, 0, 12, llllllllllllllIIIlllIIIIIIlllllI, 6, 12, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                    this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, llllllllllllllIIIlllIIIIIIlllllI, 0, 10, llllllllllllllIIIlllIIIIIlIIIIII);
                    this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, llllllllllllllIIIlllIIIIIIlllllI, 0, 12, llllllllllllllIIIlllIIIIIlIIIIII);
                    this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, llllllllllllllIIIlllIIIIIIlllllI, 4, 10, llllllllllllllIIIlllIIIIIlIIIIII);
                    this.func_175811_a(llllllllllllllIIIlllIIIIIlIIIIlI, WingRoom.field_175825_e, llllllllllllllIIIlllIIIIIIlllllI, 4, 12, llllllllllllllIIIlllIIIIIlIIIIII);
                    llllllllllllllIIIlllIIIIIIlllllI = 12;
                }
                llllllllllllllIIIlllIIIIIIlllllI = 8;
                for (int llllllllllllllIIIlllIIIIIIlllIll = 0; llllllllllllllIIIlllIIIIIIlllIll < 2; ++llllllllllllllIIIlllIIIIIIlllIll) {
                    this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, llllllllllllllIIIlllIIIIIIlllllI, 0, 7, llllllllllllllIIIlllIIIIIIlllllI, 2, 7, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                    this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, llllllllllllllIIIlllIIIIIIlllllI, 0, 14, llllllllllllllIIIlllIIIIIIlllllI, 2, 14, WingRoom.field_175826_b, WingRoom.field_175826_b, false);
                    llllllllllllllIIIlllIIIIIIlllllI = 14;
                }
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 8, 3, 8, 8, 3, 13, WingRoom.field_175827_c, WingRoom.field_175827_c, false);
                this.func_175804_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 14, 3, 8, 14, 3, 13, WingRoom.field_175827_c, WingRoom.field_175827_c, false);
                this.func_175817_a(llllllllllllllIIIlllIIIIIlIIIIlI, llllllllllllllIIIlllIIIIIlIIIIII, 11, 5, 13);
            }
            return true;
        }
        
        public WingRoom(final EnumFacing llllllllllllllIIIlllIIIIIlIlIIIl, final StructureBoundingBox llllllllllllllIIIlllIIIIIlIIllII, final int llllllllllllllIIIlllIIIIIlIIllll) {
            super(llllllllllllllIIIlllIIIIIlIlIIIl, llllllllllllllIIIlllIIIIIlIIllII);
            this.field_175834_o = (llllllllllllllIIIlllIIIIIlIIllll & 0x1);
        }
        
        static {
            __OBFID = "CL_00001973";
        }
    }
    
    public static class MonumentCoreRoom extends Piece
    {
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIIIIIIlIlllIIlll, final Random llllllllllllllIlIIIIIIlIlllIIllI, final StructureBoundingBox llllllllllllllIlIIIIIIlIllIlllIl) {
            this.func_175819_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 1, 8, 0, 14, 8, 14, MonumentCoreRoom.field_175828_a);
            final byte llllllllllllllIlIIIIIIlIlllIIlII = 7;
            IBlockState llllllllllllllIlIIIIIIlIlllIIIll = MonumentCoreRoom.field_175826_b;
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 0, llllllllllllllIlIIIIIIlIlllIIlII, 0, 0, llllllllllllllIlIIIIIIlIlllIIlII, 15, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 15, llllllllllllllIlIIIIIIlIlllIIlII, 0, 15, llllllllllllllIlIIIIIIlIlllIIlII, 15, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 1, llllllllllllllIlIIIIIIlIlllIIlII, 0, 15, llllllllllllllIlIIIIIIlIlllIIlII, 0, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 1, llllllllllllllIlIIIIIIlIlllIIlII, 15, 14, llllllllllllllIlIIIIIIlIlllIIlII, 15, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
            for (int llllllllllllllIlIIIIIIlIlllIIIlI = 1; llllllllllllllIlIIIIIIlIlllIIIlI <= 6; ++llllllllllllllIlIIIIIIlIlllIIIlI) {
                llllllllllllllIlIIIIIIlIlllIIIll = MonumentCoreRoom.field_175826_b;
                if (llllllllllllllIlIIIIIIlIlllIIIlI == 2 || llllllllllllllIlIIIIIIlIlllIIIlI == 6) {
                    llllllllllllllIlIIIIIIlIlllIIIll = MonumentCoreRoom.field_175828_a;
                }
                for (int llllllllllllllIlIIIIIIlIlllIIIIl = 0; llllllllllllllIlIIIIIIlIlllIIIIl <= 15; llllllllllllllIlIIIIIIlIlllIIIIl += 15) {
                    this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, llllllllllllllIlIIIIIIlIlllIIIIl, llllllllllllllIlIIIIIIlIlllIIIlI, 0, llllllllllllllIlIIIIIIlIlllIIIIl, llllllllllllllIlIIIIIIlIlllIIIlI, 1, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
                    this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, llllllllllllllIlIIIIIIlIlllIIIIl, llllllllllllllIlIIIIIIlIlllIIIlI, 6, llllllllllllllIlIIIIIIlIlllIIIIl, llllllllllllllIlIIIIIIlIlllIIIlI, 9, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
                    this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, llllllllllllllIlIIIIIIlIlllIIIIl, llllllllllllllIlIIIIIIlIlllIIIlI, 14, llllllllllllllIlIIIIIIlIlllIIIIl, llllllllllllllIlIIIIIIlIlllIIIlI, 15, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
                }
                this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 1, llllllllllllllIlIIIIIIlIlllIIIlI, 0, 1, llllllllllllllIlIIIIIIlIlllIIIlI, 0, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
                this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 6, llllllllllllllIlIIIIIIlIlllIIIlI, 0, 9, llllllllllllllIlIIIIIIlIlllIIIlI, 0, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
                this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 14, llllllllllllllIlIIIIIIlIlllIIIlI, 0, 14, llllllllllllllIlIIIIIIlIlllIIIlI, 0, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
                this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 1, llllllllllllllIlIIIIIIlIlllIIIlI, 15, 14, llllllllllllllIlIIIIIIlIlllIIIlI, 15, llllllllllllllIlIIIIIIlIlllIIIll, llllllllllllllIlIIIIIIlIlllIIIll, false);
            }
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 6, 3, 6, 9, 6, 9, MonumentCoreRoom.field_175827_c, MonumentCoreRoom.field_175827_c, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 7, 4, 7, 8, 5, 8, Blocks.gold_block.getDefaultState(), Blocks.gold_block.getDefaultState(), false);
            for (int llllllllllllllIlIIIIIIlIlllIIIlI = 3; llllllllllllllIlIIIIIIlIlllIIIlI <= 6; llllllllllllllIlIIIIIIlIlllIIIlI += 3) {
                for (int llllllllllllllIlIIIIIIlIlllIIIII = 6; llllllllllllllIlIIIIIIlIlllIIIII <= 9; llllllllllllllIlIIIIIIlIlllIIIII += 3) {
                    this.func_175811_a(llllllllllllllIlIIIIIIlIlllIIlll, MonumentCoreRoom.field_175825_e, llllllllllllllIlIIIIIIlIlllIIIII, llllllllllllllIlIIIIIIlIlllIIIlI, 6, llllllllllllllIlIIIIIIlIllIlllIl);
                    this.func_175811_a(llllllllllllllIlIIIIIIlIlllIIlll, MonumentCoreRoom.field_175825_e, llllllllllllllIlIIIIIIlIlllIIIII, llllllllllllllIlIIIIIIlIlllIIIlI, 9, llllllllllllllIlIIIIIIlIllIlllIl);
                }
            }
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 5, 1, 6, 5, 2, 6, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 5, 1, 9, 5, 2, 9, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 10, 1, 6, 10, 2, 6, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 10, 1, 9, 10, 2, 9, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 6, 1, 5, 6, 2, 5, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 9, 1, 5, 9, 2, 5, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 6, 1, 10, 6, 2, 10, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 9, 1, 10, 9, 2, 10, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 5, 2, 5, 5, 6, 5, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 5, 2, 10, 5, 6, 10, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 10, 2, 5, 10, 6, 5, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 10, 2, 10, 10, 6, 10, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 5, 7, 1, 5, 7, 6, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 10, 7, 1, 10, 7, 6, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 5, 7, 9, 5, 7, 14, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 10, 7, 9, 10, 7, 14, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 1, 7, 5, 6, 7, 5, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 1, 7, 10, 6, 7, 10, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 9, 7, 5, 14, 7, 5, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 9, 7, 10, 14, 7, 10, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 2, 1, 2, 2, 1, 3, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 3, 1, 2, 3, 1, 2, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 13, 1, 2, 13, 1, 3, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 12, 1, 2, 12, 1, 2, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 2, 1, 12, 2, 1, 13, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 3, 1, 13, 3, 1, 13, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 13, 1, 12, 13, 1, 13, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            this.func_175804_a(llllllllllllllIlIIIIIIlIlllIIlll, llllllllllllllIlIIIIIIlIllIlllIl, 12, 1, 13, 12, 1, 13, MonumentCoreRoom.field_175826_b, MonumentCoreRoom.field_175826_b, false);
            return true;
        }
        
        public MonumentCoreRoom() {
        }
        
        public MonumentCoreRoom(final EnumFacing llllllllllllllIlIIIIIIlIllllIlIl, final RoomDefinition llllllllllllllIlIIIIIIlIllllIIII, final Random llllllllllllllIlIIIIIIlIllllIIll) {
            super(1, llllllllllllllIlIIIIIIlIllllIlIl, llllllllllllllIlIIIIIIlIllllIIII, 2, 2, 2);
        }
        
        static {
            __OBFID = "CL_00001984";
        }
    }
    
    static class ZDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        @Override
        public boolean func_175969_a(final RoomDefinition lIlIIIllIlIIII) {
            return lIlIIIllIlIIII.field_175966_c[EnumFacing.NORTH.getIndex()] && !lIlIIIllIlIIII.field_175965_b[EnumFacing.NORTH.getIndex()].field_175963_d;
        }
        
        private ZDoubleRoomFitHelper() {
        }
        
        static {
            __OBFID = "CL_00001988";
        }
        
        ZDoubleRoomFitHelper(final SwitchEnumFacing lIlIIIlIllllll) {
            this();
        }
        
        @Override
        public Piece func_175968_a(final EnumFacing lIlIIIllIIlIIl, final RoomDefinition lIlIIIllIIlIII, final Random lIlIIIllIIIIll) {
            RoomDefinition lIlIIIllIIIllI = lIlIIIllIIlIII;
            if (!lIlIIIllIIlIII.field_175966_c[EnumFacing.NORTH.getIndex()] || lIlIIIllIIlIII.field_175965_b[EnumFacing.NORTH.getIndex()].field_175963_d) {
                lIlIIIllIIIllI = lIlIIIllIIlIII.field_175965_b[EnumFacing.SOUTH.getIndex()];
            }
            lIlIIIllIIIllI.field_175963_d = true;
            lIlIIIllIIIllI.field_175965_b[EnumFacing.NORTH.getIndex()].field_175963_d = true;
            return new DoubleZRoom(lIlIIIllIIlIIl, lIlIIIllIIIllI, lIlIIIllIIIIll);
        }
    }
    
    public static class DoubleZRoom extends Piece
    {
        public DoubleZRoom(final EnumFacing lllllllllllllllIllIlIllIlIlIIlIl, final RoomDefinition lllllllllllllllIllIlIllIlIlIIIII, final Random lllllllllllllllIllIlIllIlIlIIIll) {
            super(1, lllllllllllllllIllIlIllIlIlIIlIl, lllllllllllllllIllIlIllIlIlIIIII, 1, 1, 2);
        }
        
        public DoubleZRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIllIlIllIlIIllIIl, final Random lllllllllllllllIllIlIllIlIIllIII, final StructureBoundingBox lllllllllllllllIllIlIllIlIIlIIlI) {
            final RoomDefinition lllllllllllllllIllIlIllIlIIlIllI = this.field_175830_k.field_175965_b[EnumFacing.NORTH.getIndex()];
            final RoomDefinition lllllllllllllllIllIlIllIlIIlIlIl = this.field_175830_k;
            if (this.field_175830_k.field_175967_a / 25 > 0) {
                this.func_175821_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 0, 8, lllllllllllllllIllIlIllIlIIlIllI.field_175966_c[EnumFacing.DOWN.getIndex()]);
                this.func_175821_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 0, 0, lllllllllllllllIllIlIllIlIIlIlIl.field_175966_c[EnumFacing.DOWN.getIndex()]);
            }
            if (lllllllllllllllIllIlIllIlIIlIlIl.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 4, 1, 6, 4, 7, DoubleZRoom.field_175828_a);
            }
            if (lllllllllllllllIllIlIllIlIIlIllI.field_175965_b[EnumFacing.UP.getIndex()] == null) {
                this.func_175819_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 4, 8, 6, 4, 14, DoubleZRoom.field_175828_a);
            }
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 0, 3, 0, 0, 3, 15, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 7, 3, 0, 7, 3, 15, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 3, 0, 7, 3, 0, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 3, 15, 6, 3, 15, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 0, 2, 0, 0, 2, 15, DoubleZRoom.field_175828_a, DoubleZRoom.field_175828_a, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 7, 2, 0, 7, 2, 15, DoubleZRoom.field_175828_a, DoubleZRoom.field_175828_a, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 2, 0, 7, 2, 0, DoubleZRoom.field_175828_a, DoubleZRoom.field_175828_a, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 2, 15, 6, 2, 15, DoubleZRoom.field_175828_a, DoubleZRoom.field_175828_a, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 0, 1, 0, 0, 1, 15, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 7, 1, 0, 7, 1, 15, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 1, 0, 7, 1, 0, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 1, 15, 6, 1, 15, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 1, 1, 1, 1, 2, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 6, 1, 1, 6, 1, 2, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 3, 1, 1, 3, 2, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 6, 3, 1, 6, 3, 2, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 1, 13, 1, 1, 14, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 6, 1, 13, 6, 1, 14, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 1, 3, 13, 1, 3, 14, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 6, 3, 13, 6, 3, 14, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 2, 1, 6, 2, 3, 6, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 5, 1, 6, 5, 3, 6, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 2, 1, 9, 2, 3, 9, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 5, 1, 9, 5, 3, 9, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 3, 2, 6, 4, 2, 6, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 3, 2, 9, 4, 2, 9, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 2, 2, 7, 2, 2, 8, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 5, 2, 7, 5, 2, 8, DoubleZRoom.field_175826_b, DoubleZRoom.field_175826_b, false);
            this.func_175811_a(lllllllllllllllIllIlIllIlIIllIIl, DoubleZRoom.field_175825_e, 2, 2, 5, lllllllllllllllIllIlIllIlIIlIIlI);
            this.func_175811_a(lllllllllllllllIllIlIllIlIIllIIl, DoubleZRoom.field_175825_e, 5, 2, 5, lllllllllllllllIllIlIllIlIIlIIlI);
            this.func_175811_a(lllllllllllllllIllIlIllIlIIllIIl, DoubleZRoom.field_175825_e, 2, 2, 10, lllllllllllllllIllIlIllIlIIlIIlI);
            this.func_175811_a(lllllllllllllllIllIlIllIlIIllIIl, DoubleZRoom.field_175825_e, 5, 2, 10, lllllllllllllllIllIlIllIlIIlIIlI);
            this.func_175811_a(lllllllllllllllIllIlIllIlIIllIIl, DoubleZRoom.field_175826_b, 2, 3, 5, lllllllllllllllIllIlIllIlIIlIIlI);
            this.func_175811_a(lllllllllllllllIllIlIllIlIIllIIl, DoubleZRoom.field_175826_b, 5, 3, 5, lllllllllllllllIllIlIllIlIIlIIlI);
            this.func_175811_a(lllllllllllllllIllIlIllIlIIllIIl, DoubleZRoom.field_175826_b, 2, 3, 10, lllllllllllllllIllIlIllIlIIlIIlI);
            this.func_175811_a(lllllllllllllllIllIlIllIlIIllIIl, DoubleZRoom.field_175826_b, 5, 3, 10, lllllllllllllllIllIlIllIlIIlIIlI);
            if (lllllllllllllllIllIlIllIlIIlIlIl.field_175966_c[EnumFacing.SOUTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 3, 1, 0, 4, 2, 0, DoubleZRoom.field_175822_f, DoubleZRoom.field_175822_f, false);
            }
            if (lllllllllllllllIllIlIllIlIIlIlIl.field_175966_c[EnumFacing.EAST.getIndex()]) {
                this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 7, 1, 3, 7, 2, 4, DoubleZRoom.field_175822_f, DoubleZRoom.field_175822_f, false);
            }
            if (lllllllllllllllIllIlIllIlIIlIlIl.field_175966_c[EnumFacing.WEST.getIndex()]) {
                this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 0, 1, 3, 0, 2, 4, DoubleZRoom.field_175822_f, DoubleZRoom.field_175822_f, false);
            }
            if (lllllllllllllllIllIlIllIlIIlIllI.field_175966_c[EnumFacing.NORTH.getIndex()]) {
                this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 3, 1, 15, 4, 2, 15, DoubleZRoom.field_175822_f, DoubleZRoom.field_175822_f, false);
            }
            if (lllllllllllllllIllIlIllIlIIlIllI.field_175966_c[EnumFacing.WEST.getIndex()]) {
                this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 0, 1, 11, 0, 2, 12, DoubleZRoom.field_175822_f, DoubleZRoom.field_175822_f, false);
            }
            if (lllllllllllllllIllIlIllIlIIlIllI.field_175966_c[EnumFacing.EAST.getIndex()]) {
                this.func_175804_a(lllllllllllllllIllIlIllIlIIllIIl, lllllllllllllllIllIlIllIlIIlIIlI, 7, 1, 11, 7, 2, 12, DoubleZRoom.field_175822_f, DoubleZRoom.field_175822_f, false);
            }
            return true;
        }
        
        static {
            __OBFID = "CL_00001979";
        }
    }
}
