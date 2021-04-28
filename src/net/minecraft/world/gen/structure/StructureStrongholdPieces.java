package net.minecraft.world.gen.structure;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class StructureStrongholdPieces
{
    private static final /* synthetic */ PieceWeight[] pieceWeightArray;
    private static /* synthetic */ Class strongComponentType;
    private static final /* synthetic */ Stones strongholdStones;
    private static /* synthetic */ List structurePieceList;
    static /* synthetic */ int totalWeight;
    
    static {
        __OBFID = "CL_00000483";
        pieceWeightArray = new PieceWeight[] { new PieceWeight(Straight.class, 40, 0), new PieceWeight(Prison.class, 5, 5), new PieceWeight(LeftTurn.class, 20, 0), new PieceWeight(RightTurn.class, 20, 0), new PieceWeight(RoomCrossing.class, 10, 6), new PieceWeight(StairsStraight.class, 5, 5), new PieceWeight(Stairs.class, 5, 5), new PieceWeight(Crossing.class, 5, 4), new PieceWeight(ChestCorridor.class, 5, 4), new PieceWeight(10, 2) {
                static {
                    __OBFID = "CL_00000484";
                }
                
                @Override
                public boolean canSpawnMoreStructuresOfType(final int llllllllllllllllIllIlIlIllIIIlII) {
                    return super.canSpawnMoreStructuresOfType(llllllllllllllllIllIlIlIllIIIlII) && llllllllllllllllIllIlIlIllIIIlII > 4;
                }
            }, new PieceWeight(20, 1) {
                static {
                    __OBFID = "CL_00000485";
                }
                
                @Override
                public boolean canSpawnMoreStructuresOfType(final int llllllllllllllIlIlIIIlIlllIIlIlI) {
                    return super.canSpawnMoreStructuresOfType(llllllllllllllIlIlIIIlIlllIIlIlI) && llllllllllllllIlIlIIIlIlllIIlIlI > 5;
                }
            } };
        strongholdStones = new Stones(null);
    }
    
    static /* synthetic */ void access$2(final Class llllllllllllllIIIlIllIIIlIllIlII) {
        StructureStrongholdPieces.strongComponentType = llllllllllllllIIIlIllIIIlIllIlII;
    }
    
    private static Stronghold func_175954_a(final Class llllllllllllllIIIlIllIIlIIIIIIlI, final List llllllllllllllIIIlIllIIlIIIIlIlI, final Random llllllllllllllIIIlIllIIlIIIIlIIl, final int llllllllllllllIIIlIllIIlIIIIlIII, final int llllllllllllllIIIlIllIIIlllllllI, final int llllllllllllllIIIlIllIIlIIIIIllI, final EnumFacing llllllllllllllIIIlIllIIIllllllII, final int llllllllllllllIIIlIllIIlIIIIIlII) {
        Object llllllllllllllIIIlIllIIlIIIIIIll = null;
        if (llllllllllllllIIIlIllIIlIIIIIIlI == Straight.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = Straight.func_175862_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        else if (llllllllllllllIIIlIllIIlIIIIIIlI == Prison.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = Prison.func_175860_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        else if (llllllllllllllIIIlIllIIlIIIIIIlI == LeftTurn.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = LeftTurn.func_175867_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        else if (llllllllllllllIIIlIllIIlIIIIIIlI == RightTurn.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = LeftTurn.func_175867_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        else if (llllllllllllllIIIlIllIIlIIIIIIlI == RoomCrossing.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = RoomCrossing.func_175859_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        else if (llllllllllllllIIIlIllIIlIIIIIIlI == StairsStraight.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = StairsStraight.func_175861_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        else if (llllllllllllllIIIlIllIIlIIIIIIlI == Stairs.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = Stairs.func_175863_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        else if (llllllllllllllIIIlIllIIlIIIIIIlI == Crossing.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = Crossing.func_175866_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        else if (llllllllllllllIIIlIllIIlIIIIIIlI == ChestCorridor.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = ChestCorridor.func_175868_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        else if (llllllllllllllIIIlIllIIlIIIIIIlI == Library.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = Library.func_175864_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        else if (llllllllllllllIIIlIllIIlIIIIIIlI == PortalRoom.class) {
            llllllllllllllIIIlIllIIlIIIIIIll = PortalRoom.func_175865_a(llllllllllllllIIIlIllIIlIIIIlIlI, llllllllllllllIIIlIllIIlIIIIlIIl, llllllllllllllIIIlIllIIlIIIIlIII, llllllllllllllIIIlIllIIIlllllllI, llllllllllllllIIIlIllIIlIIIIIllI, llllllllllllllIIIlIllIIIllllllII, llllllllllllllIIIlIllIIlIIIIIlII);
        }
        return (Stronghold)llllllllllllllIIIlIllIIlIIIIIIll;
    }
    
    public static void registerStrongholdPieces() {
        MapGenStructureIO.registerStructureComponent(ChestCorridor.class, "SHCC");
        MapGenStructureIO.registerStructureComponent(Corridor.class, "SHFC");
        MapGenStructureIO.registerStructureComponent(Crossing.class, "SH5C");
        MapGenStructureIO.registerStructureComponent(LeftTurn.class, "SHLT");
        MapGenStructureIO.registerStructureComponent(Library.class, "SHLi");
        MapGenStructureIO.registerStructureComponent(PortalRoom.class, "SHPR");
        MapGenStructureIO.registerStructureComponent(Prison.class, "SHPH");
        MapGenStructureIO.registerStructureComponent(RightTurn.class, "SHRT");
        MapGenStructureIO.registerStructureComponent(RoomCrossing.class, "SHRC");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "SHSD");
        MapGenStructureIO.registerStructureComponent(Stairs2.class, "SHStart");
        MapGenStructureIO.registerStructureComponent(Straight.class, "SHS");
        MapGenStructureIO.registerStructureComponent(StairsStraight.class, "SHSSD");
    }
    
    private static boolean canAddStructurePieces() {
        boolean llllllllllllllIIIlIllIIlIIIllIlI = false;
        StructureStrongholdPieces.totalWeight = 0;
        for (final PieceWeight llllllllllllllIIIlIllIIlIIIllIIl : StructureStrongholdPieces.structurePieceList) {
            if (llllllllllllllIIIlIllIIlIIIllIIl.instancesLimit > 0 && llllllllllllllIIIlIllIIlIIIllIIl.instancesSpawned < llllllllllllllIIIlIllIIlIIIllIIl.instancesLimit) {
                llllllllllllllIIIlIllIIlIIIllIlI = true;
            }
            StructureStrongholdPieces.totalWeight += llllllllllllllIIIlIllIIlIIIllIIl.pieceWeight;
        }
        return llllllllllllllIIIlIllIIlIIIllIlI;
    }
    
    public static void prepareStructurePieces() {
        StructureStrongholdPieces.structurePieceList = Lists.newArrayList();
        for (final PieceWeight llllllllllllllIIIlIllIIlIIlIIIlI : StructureStrongholdPieces.pieceWeightArray) {
            llllllllllllllIIIlIllIIlIIlIIIlI.instancesSpawned = 0;
            StructureStrongholdPieces.structurePieceList.add(llllllllllllllIIIlIllIIlIIlIIIlI);
        }
        StructureStrongholdPieces.strongComponentType = null;
    }
    
    private static StructureComponent func_175953_c(final Stairs2 llllllllllllllIIIlIllIIIllIIIlll, final List llllllllllllllIIIlIllIIIlIllllIl, final Random llllllllllllllIIIlIllIIIlIllllII, final int llllllllllllllIIIlIllIIIlIlllIll, final int llllllllllllllIIIlIllIIIllIIIIll, final int llllllllllllllIIIlIllIIIlIlllIIl, final EnumFacing llllllllllllllIIIlIllIIIllIIIIIl, final int llllllllllllllIIIlIllIIIllIIIIII) {
        if (llllllllllllllIIIlIllIIIllIIIIII > 50) {
            return null;
        }
        if (Math.abs(llllllllllllllIIIlIllIIIlIlllIll - llllllllllllllIIIlIllIIIllIIIlll.getBoundingBox().minX) <= 112 && Math.abs(llllllllllllllIIIlIllIIIlIlllIIl - llllllllllllllIIIlIllIIIllIIIlll.getBoundingBox().minZ) <= 112) {
            final Stronghold llllllllllllllIIIlIllIIIlIllllll = func_175955_b(llllllllllllllIIIlIllIIIllIIIlll, llllllllllllllIIIlIllIIIlIllllIl, llllllllllllllIIIlIllIIIlIllllII, llllllllllllllIIIlIllIIIlIlllIll, llllllllllllllIIIlIllIIIllIIIIll, llllllllllllllIIIlIllIIIlIlllIIl, llllllllllllllIIIlIllIIIllIIIIIl, llllllllllllllIIIlIllIIIllIIIIII + 1);
            if (llllllllllllllIIIlIllIIIlIllllll != null) {
                llllllllllllllIIIlIllIIIlIllllIl.add(llllllllllllllIIIlIllIIIlIllllll);
                llllllllllllllIIIlIllIIIllIIIlll.field_75026_c.add(llllllllllllllIIIlIllIIIlIllllll);
            }
            return llllllllllllllIIIlIllIIIlIllllll;
        }
        return null;
    }
    
    private static Stronghold func_175955_b(final Stairs2 llllllllllllllIIIlIllIIIllIlllIl, final List llllllllllllllIIIlIllIIIllIlllII, final Random llllllllllllllIIIlIllIIIllIllIll, final int llllllllllllllIIIlIllIIIllIllIlI, final int llllllllllllllIIIlIllIIIllIllIIl, final int llllllllllllllIIIlIllIIIllIllIII, final EnumFacing llllllllllllllIIIlIllIIIlllIIllI, final int llllllllllllllIIIlIllIIIllIlIllI) {
        if (!canAddStructurePieces()) {
            return null;
        }
        if (StructureStrongholdPieces.strongComponentType != null) {
            final Stronghold llllllllllllllIIIlIllIIIlllIIlII = func_175954_a(StructureStrongholdPieces.strongComponentType, llllllllllllllIIIlIllIIIllIlllII, llllllllllllllIIIlIllIIIllIllIll, llllllllllllllIIIlIllIIIllIllIlI, llllllllllllllIIIlIllIIIllIllIIl, llllllllllllllIIIlIllIIIllIllIII, llllllllllllllIIIlIllIIIlllIIllI, llllllllllllllIIIlIllIIIllIlIllI);
            StructureStrongholdPieces.strongComponentType = null;
            if (llllllllllllllIIIlIllIIIlllIIlII != null) {
                return llllllllllllllIIIlIllIIIlllIIlII;
            }
        }
        int llllllllllllllIIIlIllIIIlllIIIll = 0;
        while (llllllllllllllIIIlIllIIIlllIIIll < 5) {
            ++llllllllllllllIIIlIllIIIlllIIIll;
            int llllllllllllllIIIlIllIIIlllIIIlI = llllllllllllllIIIlIllIIIllIllIll.nextInt(StructureStrongholdPieces.totalWeight);
            for (final PieceWeight llllllllllllllIIIlIllIIIlllIIIII : StructureStrongholdPieces.structurePieceList) {
                llllllllllllllIIIlIllIIIlllIIIlI -= llllllllllllllIIIlIllIIIlllIIIII.pieceWeight;
                if (llllllllllllllIIIlIllIIIlllIIIlI < 0) {
                    if (!llllllllllllllIIIlIllIIIlllIIIII.canSpawnMoreStructuresOfType(llllllllllllllIIIlIllIIIllIlIllI)) {
                        break;
                    }
                    if (llllllllllllllIIIlIllIIIlllIIIII == llllllllllllllIIIlIllIIIllIlllIl.strongholdPieceWeight) {
                        break;
                    }
                    final Stronghold llllllllllllllIIIlIllIIIllIlllll = func_175954_a(llllllllllllllIIIlIllIIIlllIIIII.pieceClass, llllllllllllllIIIlIllIIIllIlllII, llllllllllllllIIIlIllIIIllIllIll, llllllllllllllIIIlIllIIIllIllIlI, llllllllllllllIIIlIllIIIllIllIIl, llllllllllllllIIIlIllIIIllIllIII, llllllllllllllIIIlIllIIIlllIIllI, llllllllllllllIIIlIllIIIllIlIllI);
                    if (llllllllllllllIIIlIllIIIllIlllll != null) {
                        final PieceWeight pieceWeight = llllllllllllllIIIlIllIIIlllIIIII;
                        ++pieceWeight.instancesSpawned;
                        llllllllllllllIIIlIllIIIllIlllIl.strongholdPieceWeight = llllllllllllllIIIlIllIIIlllIIIII;
                        if (!llllllllllllllIIIlIllIIIlllIIIII.canSpawnMoreStructures()) {
                            StructureStrongholdPieces.structurePieceList.remove(llllllllllllllIIIlIllIIIlllIIIII);
                        }
                        return llllllllllllllIIIlIllIIIllIlllll;
                    }
                    continue;
                }
            }
        }
        final StructureBoundingBox llllllllllllllIIIlIllIIIllIllllI = Corridor.func_175869_a(llllllllllllllIIIlIllIIIllIlllII, llllllllllllllIIIlIllIIIllIllIll, llllllllllllllIIIlIllIIIllIllIlI, llllllllllllllIIIlIllIIIllIllIIl, llllllllllllllIIIlIllIIIllIllIII, llllllllllllllIIIlIllIIIlllIIllI);
        if (llllllllllllllIIIlIllIIIllIllllI != null && llllllllllllllIIIlIllIIIllIllllI.minY > 1) {
            return new Corridor(llllllllllllllIIIlIllIIIllIlIllI, llllllllllllllIIIlIllIIIllIllIll, llllllllllllllIIIlIllIIIllIllllI, llllllllllllllIIIlIllIIIlllIIllI);
        }
        return null;
    }
    
    public static class Stairs2 extends Stairs
    {
        public /* synthetic */ PortalRoom strongholdPortalRoom;
        public /* synthetic */ PieceWeight strongholdPieceWeight;
        public /* synthetic */ List field_75026_c;
        
        @Override
        public BlockPos func_180776_a() {
            return (this.strongholdPortalRoom != null) ? this.strongholdPortalRoom.func_180776_a() : super.func_180776_a();
        }
        
        public Stairs2(final int lIIIIllllIlII, final Random lIIIIllllIIll, final int lIIIIlllIlllI, final int lIIIIlllIllIl) {
            super(0, lIIIIllllIIll, lIIIIlllIlllI, lIIIIlllIllIl);
            this.field_75026_c = Lists.newArrayList();
        }
        
        static {
            __OBFID = "CL_00000499";
        }
        
        public Stairs2() {
            this.field_75026_c = Lists.newArrayList();
        }
    }
    
    static class PieceWeight
    {
        public final /* synthetic */ int pieceWeight;
        public /* synthetic */ Class pieceClass;
        public /* synthetic */ int instancesLimit;
        public /* synthetic */ int instancesSpawned;
        
        public boolean canSpawnMoreStructuresOfType(final int lllllllllllllllIIIllllIllIlIIlIl) {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }
        
        public PieceWeight(final Class lllllllllllllllIIIllllIllIlIlIlI, final int lllllllllllllllIIIllllIllIlIllIl, final int lllllllllllllllIIIllllIllIlIllII) {
            this.pieceClass = lllllllllllllllIIIllllIllIlIlIlI;
            this.pieceWeight = lllllllllllllllIIIllllIllIlIllIl;
            this.instancesLimit = lllllllllllllllIIIllllIllIlIllII;
        }
        
        static {
            __OBFID = "CL_00000492";
        }
        
        public boolean canSpawnMoreStructures() {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }
    }
    
    public static class PortalRoom extends Stronghold
    {
        private /* synthetic */ boolean hasSpawner;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIllIIlllIlIllIIll) {
            super.writeStructureToNBT(lllllllllllllllIllIIlllIlIllIIll);
            lllllllllllllllIllIIlllIlIllIIll.setBoolean("Mob", this.hasSpawner);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIllIIlllIIlllIIIl, final Random lllllllllllllllIllIIlllIIlllIIII, final StructureBoundingBox lllllllllllllllIllIIlllIIlllllII) {
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 0, 0, 0, 10, 7, 15, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllIIII, lllllllllllllllIllIIlllIIlllllII, Door.GRATES, 4, 1, 0);
            final byte lllllllllllllllIllIIlllIIllllIll = 6;
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 1, lllllllllllllllIllIIlllIIllllIll, 1, 1, lllllllllllllllIllIIlllIIllllIll, 14, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 9, lllllllllllllllIllIIlllIIllllIll, 1, 9, lllllllllllllllIllIIlllIIllllIll, 14, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 2, lllllllllllllllIllIIlllIIllllIll, 1, 8, lllllllllllllllIllIIlllIIllllIll, 2, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 2, lllllllllllllllIllIIlllIIllllIll, 14, 8, lllllllllllllllIllIIlllIIllllIll, 14, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 1, 1, 1, 2, 1, 4, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 8, 1, 1, 9, 1, 4, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            this.func_175804_a(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 1, 1, 1, 1, 1, 3, Blocks.flowing_lava.getDefaultState(), Blocks.flowing_lava.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 9, 1, 1, 9, 1, 3, Blocks.flowing_lava.getDefaultState(), Blocks.flowing_lava.getDefaultState(), false);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 3, 1, 8, 7, 1, 12, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            this.func_175804_a(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 4, 1, 9, 6, 1, 11, Blocks.flowing_lava.getDefaultState(), Blocks.flowing_lava.getDefaultState(), false);
            for (int lllllllllllllllIllIIlllIIllllIlI = 3; lllllllllllllllIllIIlllIIllllIlI < 14; lllllllllllllllIllIIlllIIllllIlI += 2) {
                this.func_175804_a(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 0, 3, lllllllllllllllIllIIlllIIllllIlI, 0, 4, lllllllllllllllIllIIlllIIllllIlI, Blocks.iron_bars.getDefaultState(), Blocks.iron_bars.getDefaultState(), false);
                this.func_175804_a(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 10, 3, lllllllllllllllIllIIlllIIllllIlI, 10, 4, lllllllllllllllIllIIlllIIllllIlI, Blocks.iron_bars.getDefaultState(), Blocks.iron_bars.getDefaultState(), false);
            }
            for (int lllllllllllllllIllIIlllIIllllIlI = 2; lllllllllllllllIllIIlllIIllllIlI < 9; lllllllllllllllIllIIlllIIllllIlI += 2) {
                this.func_175804_a(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, lllllllllllllllIllIIlllIIllllIlI, 3, 15, lllllllllllllllIllIIlllIIllllIlI, 4, 15, Blocks.iron_bars.getDefaultState(), Blocks.iron_bars.getDefaultState(), false);
            }
            int lllllllllllllllIllIIlllIIllllIlI = this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 4, 1, 5, 6, 1, 7, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 4, 2, 6, 6, 2, 7, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIIlllIIlllIIIl, lllllllllllllllIllIIlllIIlllllII, 4, 3, 7, 6, 3, 7, false, lllllllllllllllIllIIlllIIlllIIII, StructureStrongholdPieces.strongholdStones);
            for (int lllllllllllllllIllIIlllIIllllIIl = 4; lllllllllllllllIllIIlllIIllllIIl <= 6; ++lllllllllllllllIllIIlllIIllllIIl) {
                this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.stone_brick_stairs.getStateFromMeta(lllllllllllllllIllIIlllIIllllIlI), lllllllllllllllIllIIlllIIllllIIl, 1, 4, lllllllllllllllIllIIlllIIlllllII);
                this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.stone_brick_stairs.getStateFromMeta(lllllllllllllllIllIIlllIIllllIlI), lllllllllllllllIllIIlllIIllllIIl, 2, 5, lllllllllllllllIllIIlllIIlllllII);
                this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.stone_brick_stairs.getStateFromMeta(lllllllllllllllIllIIlllIIllllIlI), lllllllllllllllIllIIlllIIllllIIl, 3, 6, lllllllllllllllIllIIlllIIlllllII);
            }
            int lllllllllllllllIllIIlllIIllllIIl = EnumFacing.NORTH.getHorizontalIndex();
            int lllllllllllllllIllIIlllIIllllIII = EnumFacing.SOUTH.getHorizontalIndex();
            int lllllllllllllllIllIIlllIIlllIlll = EnumFacing.EAST.getHorizontalIndex();
            int lllllllllllllllIllIIlllIIlllIllI = EnumFacing.WEST.getHorizontalIndex();
            if (this.coordBaseMode != null) {
                switch (StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.coordBaseMode.ordinal()]) {
                    case 2: {
                        lllllllllllllllIllIIlllIIllllIIl = EnumFacing.SOUTH.getHorizontalIndex();
                        lllllllllllllllIllIIlllIIllllIII = EnumFacing.NORTH.getHorizontalIndex();
                        break;
                    }
                    case 3: {
                        lllllllllllllllIllIIlllIIllllIIl = EnumFacing.WEST.getHorizontalIndex();
                        lllllllllllllllIllIIlllIIllllIII = EnumFacing.EAST.getHorizontalIndex();
                        lllllllllllllllIllIIlllIIlllIlll = EnumFacing.SOUTH.getHorizontalIndex();
                        lllllllllllllllIllIIlllIIlllIllI = EnumFacing.NORTH.getHorizontalIndex();
                        break;
                    }
                    case 4: {
                        lllllllllllllllIllIIlllIIllllIIl = EnumFacing.EAST.getHorizontalIndex();
                        lllllllllllllllIllIIlllIIllllIII = EnumFacing.WEST.getHorizontalIndex();
                        lllllllllllllllIllIIlllIIlllIlll = EnumFacing.SOUTH.getHorizontalIndex();
                        lllllllllllllllIllIIlllIIlllIllI = EnumFacing.NORTH.getHorizontalIndex();
                        break;
                    }
                }
            }
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIllllIIl).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 4, 3, 8, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIllllIIl).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 5, 3, 8, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIllllIIl).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 6, 3, 8, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIllllIII).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 4, 3, 12, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIllllIII).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 5, 3, 12, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIllllIII).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 6, 3, 12, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIlllIlll).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 3, 3, 9, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIlllIlll).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 3, 3, 10, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIlllIlll).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 3, 3, 11, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIlllIllI).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 7, 3, 9, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIlllIllI).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 7, 3, 10, lllllllllllllllIllIIlllIIlllllII);
            this.func_175811_a(lllllllllllllllIllIIlllIIlllIIIl, Blocks.end_portal_frame.getStateFromMeta(lllllllllllllllIllIIlllIIlllIllI).withProperty(BlockEndPortalFrame.field_176507_b, lllllllllllllllIllIIlllIIlllIIII.nextFloat() > 0.9f), 7, 3, 11, lllllllllllllllIllIIlllIIlllllII);
            if (!this.hasSpawner) {
                final int lllllllllllllllIllIIlllIIlllIlIl = this.getYWithOffset(3);
                final BlockPos lllllllllllllllIllIIlllIIlllIlII = new BlockPos(this.getXWithOffset(5, 6), lllllllllllllllIllIIlllIIlllIlIl, this.getZWithOffset(5, 6));
                if (lllllllllllllllIllIIlllIIlllllII.func_175898_b(lllllllllllllllIllIIlllIIlllIlII)) {
                    this.hasSpawner = true;
                    lllllllllllllllIllIIlllIIlllIIIl.setBlockState(lllllllllllllllIllIIlllIIlllIlII, Blocks.mob_spawner.getDefaultState(), 2);
                    final TileEntity lllllllllllllllIllIIlllIIlllIIll = lllllllllllllllIllIIlllIIlllIIIl.getTileEntity(lllllllllllllllIllIIlllIIlllIlII);
                    if (lllllllllllllllIllIIlllIIlllIIll instanceof TileEntityMobSpawner) {
                        ((TileEntityMobSpawner)lllllllllllllllIllIIlllIIlllIIll).getSpawnerBaseLogic().setEntityName("Silverfish");
                    }
                }
            }
            return true;
        }
        
        public static PortalRoom func_175865_a(final List lllllllllllllllIllIIlllIlIIlllII, final Random lllllllllllllllIllIIlllIlIIlIIll, final int lllllllllllllllIllIIlllIlIIllIlI, final int lllllllllllllllIllIIlllIlIIlIIIl, final int lllllllllllllllIllIIlllIlIIllIII, final EnumFacing lllllllllllllllIllIIlllIlIIIllll, final int lllllllllllllllIllIIlllIlIIIlllI) {
            final StructureBoundingBox lllllllllllllllIllIIlllIlIIlIlIl = StructureBoundingBox.func_175897_a(lllllllllllllllIllIIlllIlIIllIlI, lllllllllllllllIllIIlllIlIIlIIIl, lllllllllllllllIllIIlllIlIIllIII, -4, -1, 0, 11, 8, 16, lllllllllllllllIllIIlllIlIIIllll);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllllIllIIlllIlIIlIlIl) && StructureComponent.findIntersecting(lllllllllllllllIllIIlllIlIIlllII, lllllllllllllllIllIIlllIlIIlIlIl) == null) ? new PortalRoom(lllllllllllllllIllIIlllIlIIIlllI, lllllllllllllllIllIIlllIlIIlIIll, lllllllllllllllIllIIlllIlIIlIlIl, lllllllllllllllIllIIlllIlIIIllll) : null;
        }
        
        public PortalRoom(final int lllllllllllllllIllIIlllIlIlllIll, final Random lllllllllllllllIllIIlllIlIllllll, final StructureBoundingBox lllllllllllllllIllIIlllIlIlllIlI, final EnumFacing lllllllllllllllIllIIlllIlIllllIl) {
            super(lllllllllllllllIllIIlllIlIlllIll);
            this.coordBaseMode = lllllllllllllllIllIIlllIlIllllIl;
            this.boundingBox = lllllllllllllllIllIIlllIlIlllIlI;
        }
        
        static {
            __OBFID = "CL_00000493";
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIllIIlllIlIlIlIIl, final List lllllllllllllllIllIIlllIlIlIlIII, final Random lllllllllllllllIllIIlllIlIlIIlll) {
            if (lllllllllllllllIllIIlllIlIlIlIIl != null) {
                ((Stairs2)lllllllllllllllIllIIlllIlIlIlIIl).strongholdPortalRoom = this;
            }
        }
        
        public PortalRoom() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIllIIlllIlIlIllll) {
            super.readStructureFromNBT(lllllllllllllllIllIIlllIlIlIllll);
            this.hasSpawner = lllllllllllllllIllIIlllIlIlIllll.getBoolean("Mob");
        }
    }
    
    abstract static class Stronghold extends StructureComponent
    {
        protected /* synthetic */ Door field_143013_d;
        
        public Stronghold() {
            this.field_143013_d = Door.OPENING;
        }
        
        protected Stronghold(final int lllllllllllllllIIIIIlIIlIIlIlIlI) {
            super(lllllllllllllllIIIIIlIIlIIlIlIlI);
            this.field_143013_d = Door.OPENING;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIIIIIlIIlIIlIIIlI) {
            lllllllllllllllIIIIIlIIlIIlIIIlI.setString("EntryDoor", this.field_143013_d.name());
        }
        
        protected StructureComponent getNextComponentX(final Stairs2 lllllllllllllllIIIIIlIIIlIllIllI, final List lllllllllllllllIIIIIlIIIlIllIlIl, final Random lllllllllllllllIIIIIlIIIlIllIlII, final int lllllllllllllllIIIIIlIIIlIllIIll, final int lllllllllllllllIIIIIlIIIlIlllIII) {
            if (this.coordBaseMode != null) {
                switch (StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIlIllIllI, lllllllllllllllIIIIIlIIIlIllIlIl, lllllllllllllllIIIIIlIIIlIllIlII, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllllIIIIIlIIIlIllIIll, this.boundingBox.minZ + lllllllllllllllIIIIIlIIIlIlllIII, EnumFacing.WEST, this.getComponentType());
                    }
                    case 2: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIlIllIllI, lllllllllllllllIIIIIlIIIlIllIlIl, lllllllllllllllIIIIIlIIIlIllIlII, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllllIIIIIlIIIlIllIIll, this.boundingBox.minZ + lllllllllllllllIIIIIlIIIlIlllIII, EnumFacing.WEST, this.getComponentType());
                    }
                    case 3: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIlIllIllI, lllllllllllllllIIIIIlIIIlIllIlIl, lllllllllllllllIIIIIlIIIlIllIlII, this.boundingBox.minX + lllllllllllllllIIIIIlIIIlIlllIII, this.boundingBox.minY + lllllllllllllllIIIIIlIIIlIllIIll, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                    case 4: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIlIllIllI, lllllllllllllllIIIIIlIIIlIllIlIl, lllllllllllllllIIIIIlIIIlIllIlII, this.boundingBox.minX + lllllllllllllllIIIIIlIIIlIlllIII, this.boundingBox.minY + lllllllllllllllIIIIIlIIIlIllIIll, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        protected Door getRandomDoor(final Random lllllllllllllllIIIIIlIIIllIllIIl) {
            final int lllllllllllllllIIIIIlIIIllIllIII = lllllllllllllllIIIIIlIIIllIllIIl.nextInt(5);
            switch (lllllllllllllllIIIIIlIIIllIllIII) {
                default: {
                    return Door.OPENING;
                }
                case 2: {
                    return Door.WOOD_DOOR;
                }
                case 3: {
                    return Door.GRATES;
                }
                case 4: {
                    return Door.IRON_DOOR;
                }
            }
        }
        
        protected StructureComponent getNextComponentNormal(final Stairs2 lllllllllllllllIIIIIlIIIllIIlIII, final List lllllllllllllllIIIIIlIIIllIIIlll, final Random lllllllllllllllIIIIIlIIIllIIllII, final int lllllllllllllllIIIIIlIIIllIIlIll, final int lllllllllllllllIIIIIlIIIllIIlIlI) {
            if (this.coordBaseMode != null) {
                switch (StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIllIIlIII, lllllllllllllllIIIIIlIIIllIIIlll, lllllllllllllllIIIIIlIIIllIIllII, this.boundingBox.minX + lllllllllllllllIIIIIlIIIllIIlIll, this.boundingBox.minY + lllllllllllllllIIIIIlIIIllIIlIlI, this.boundingBox.minZ - 1, this.coordBaseMode, this.getComponentType());
                    }
                    case 2: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIllIIlIII, lllllllllllllllIIIIIlIIIllIIIlll, lllllllllllllllIIIIIlIIIllIIllII, this.boundingBox.minX + lllllllllllllllIIIIIlIIIllIIlIll, this.boundingBox.minY + lllllllllllllllIIIIIlIIIllIIlIlI, this.boundingBox.maxZ + 1, this.coordBaseMode, this.getComponentType());
                    }
                    case 3: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIllIIlIII, lllllllllllllllIIIIIlIIIllIIIlll, lllllllllllllllIIIIIlIIIllIIllII, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllllIIIIIlIIIllIIlIlI, this.boundingBox.minZ + lllllllllllllllIIIIIlIIIllIIlIll, this.coordBaseMode, this.getComponentType());
                    }
                    case 4: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIllIIlIII, lllllllllllllllIIIIIlIIIllIIIlll, lllllllllllllllIIIIIlIIIllIIllII, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllllIIIIIlIIIllIIlIlI, this.boundingBox.minZ + lllllllllllllllIIIIIlIIIllIIlIll, this.coordBaseMode, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        protected StructureComponent getNextComponentZ(final Stairs2 lllllllllllllllIIIIIlIIIlIIlIlll, final List lllllllllllllllIIIIIlIIIlIIlllII, final Random lllllllllllllllIIIIIlIIIlIIllIll, final int lllllllllllllllIIIIIlIIIlIIllIlI, final int lllllllllllllllIIIIIlIIIlIIllIIl) {
            if (this.coordBaseMode != null) {
                switch (StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIlIIlIlll, lllllllllllllllIIIIIlIIIlIIlllII, lllllllllllllllIIIIIlIIIlIIllIll, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllllIIIIIlIIIlIIllIlI, this.boundingBox.minZ + lllllllllllllllIIIIIlIIIlIIllIIl, EnumFacing.EAST, this.getComponentType());
                    }
                    case 2: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIlIIlIlll, lllllllllllllllIIIIIlIIIlIIlllII, lllllllllllllllIIIIIlIIIlIIllIll, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllllIIIIIlIIIlIIllIlI, this.boundingBox.minZ + lllllllllllllllIIIIIlIIIlIIllIIl, EnumFacing.EAST, this.getComponentType());
                    }
                    case 3: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIlIIlIlll, lllllllllllllllIIIIIlIIIlIIlllII, lllllllllllllllIIIIIlIIIlIIllIll, this.boundingBox.minX + lllllllllllllllIIIIIlIIIlIIllIIl, this.boundingBox.minY + lllllllllllllllIIIIIlIIIlIIllIlI, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                    case 4: {
                        return func_175953_c(lllllllllllllllIIIIIlIIIlIIlIlll, lllllllllllllllIIIIIlIIIlIIlllII, lllllllllllllllIIIIIlIIIlIIllIll, this.boundingBox.minX + lllllllllllllllIIIIIlIIIlIIllIIl, this.boundingBox.minY + lllllllllllllllIIIIIlIIIlIIllIlI, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        static {
            __OBFID = "CL_00000503";
        }
        
        protected static boolean canStrongholdGoDeeper(final StructureBoundingBox lllllllllllllllIIIIIlIIIlIIIlIII) {
            return lllllllllllllllIIIIIlIIIlIIIlIII != null && lllllllllllllllIIIIIlIIIlIIIlIII.minY > 10;
        }
        
        protected void placeDoor(final World lllllllllllllllIIIIIlIIIlllIlIlI, final Random lllllllllllllllIIIIIlIIIlllIlIIl, final StructureBoundingBox lllllllllllllllIIIIIlIIIlllIlIII, final Door lllllllllllllllIIIIIlIIIlllIIlll, final int lllllllllllllllIIIIIlIIIllIlllll, final int lllllllllllllllIIIIIlIIIlllIIlIl, final int lllllllllllllllIIIIIlIIIlllIIlII) {
            switch (StructureStrongholdPieces.SwitchEnumFacing.doorEnum[lllllllllllllllIIIIIlIIIlllIIlll.ordinal()]) {
                default: {
                    this.func_175804_a(lllllllllllllllIIIIIlIIIlllIlIlI, lllllllllllllllIIIIIlIIIlllIlIII, lllllllllllllllIIIIIlIIIllIlllll, lllllllllllllllIIIIIlIIIlllIIlIl, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIllIlllll + 3 - 1, lllllllllllllllIIIIIlIIIlllIIlIl + 3 - 1, lllllllllllllllIIIIIlIIIlllIIlII, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                    break;
                }
                case 2: {
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll, lllllllllllllllIIIIIlIIIlllIIlIl, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll, lllllllllllllllIIIIIlIIIlllIIlIl + 2, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 1, lllllllllllllllIIIIIlIIIlllIIlIl + 2, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl + 2, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.oak_door.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 1, lllllllllllllllIIIIIlIIIlllIIlIl, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.oak_door.getStateFromMeta(8), lllllllllllllllIIIIIlIIIllIlllll + 1, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    break;
                }
                case 3: {
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.air.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 1, lllllllllllllllIIIIIlIIIlllIIlIl, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.air.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 1, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.iron_bars.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll, lllllllllllllllIIIIIlIIIlllIIlIl, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.iron_bars.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.iron_bars.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll, lllllllllllllllIIIIIlIIIlllIIlIl + 2, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.iron_bars.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 1, lllllllllllllllIIIIIlIIIlllIIlIl + 2, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.iron_bars.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl + 2, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.iron_bars.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.iron_bars.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    break;
                }
                case 4: {
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll, lllllllllllllllIIIIIlIIIlllIIlIl, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll, lllllllllllllllIIIIIlIIIlllIIlIl + 2, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 1, lllllllllllllllIIIIIlIIIlllIIlIl + 2, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl + 2, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stonebrick.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.iron_door.getDefaultState(), lllllllllllllllIIIIIlIIIllIlllll + 1, lllllllllllllllIIIIIlIIIlllIIlIl, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.iron_door.getStateFromMeta(8), lllllllllllllllIIIIIlIIIllIlllll + 1, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stone_button.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_button, 4)), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII + 1, lllllllllllllllIIIIIlIIIlllIlIII);
                    this.func_175811_a(lllllllllllllllIIIIIlIIIlllIlIlI, Blocks.stone_button.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_button, 3)), lllllllllllllllIIIIIlIIIllIlllll + 2, lllllllllllllllIIIIIlIIIlllIIlIl + 1, lllllllllllllllIIIIIlIIIlllIIlII - 1, lllllllllllllllIIIIIlIIIlllIlIII);
                    break;
                }
            }
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIIIIIlIIlIIIllIIl) {
            this.field_143013_d = Door.valueOf(lllllllllllllllIIIIIlIIlIIIllIIl.getString("EntryDoor"));
        }
        
        public enum Door
        {
            WOOD_DOOR("WOOD_DOOR", 1, "WOOD_DOOR", 1), 
            GRATES("GRATES", 2, "GRATES", 2), 
            IRON_DOOR("IRON_DOOR", 3, "IRON_DOOR", 3), 
            OPENING("OPENING", 0, "OPENING", 0);
            
            private Door(final String llllllllllllllIIIIIlIIlIlIlIllII, final int llllllllllllllIIIIIlIIlIlIlIlIll, final String llllllllllllllIIIIIlIIlIlIlIllll, final int llllllllllllllIIIIIlIIlIlIlIlllI) {
            }
            
            static {
                __OBFID = "CL_00000504";
            }
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_175951_b;
        static final /* synthetic */ int[] doorEnum;
        
        static {
            __OBFID = "CL_00001970";
            field_175951_b = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_175951_b[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_175951_b[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_175951_b[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_175951_b[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            doorEnum = new int[Stronghold.Door.values().length];
            try {
                SwitchEnumFacing.doorEnum[Stronghold.Door.OPENING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.doorEnum[Stronghold.Door.WOOD_DOOR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                SwitchEnumFacing.doorEnum[Stronghold.Door.GRATES.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                SwitchEnumFacing.doorEnum[Stronghold.Door.IRON_DOOR.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
        }
    }
    
    static class Stones extends StructureComponent.BlockSelector
    {
        private Stones() {
        }
        
        @Override
        public void selectBlocks(final Random llllllllllllllIlllIIIIllIIlIIlll, final int llllllllllllllIlllIIIIllIIlIllIl, final int llllllllllllllIlllIIIIllIIlIllII, final int llllllllllllllIlllIIIIllIIlIlIll, final boolean llllllllllllllIlllIIIIllIIlIlIlI) {
            if (llllllllllllllIlllIIIIllIIlIlIlI) {
                final float llllllllllllllIlllIIIIllIIlIlIIl = llllllllllllllIlllIIIIllIIlIIlll.nextFloat();
                if (llllllllllllllIlllIIIIllIIlIlIIl < 0.2f) {
                    this.field_151562_a = Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.CRACKED_META);
                }
                else if (llllllllllllllIlllIIIIllIIlIlIIl < 0.5f) {
                    this.field_151562_a = Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.MOSSY_META);
                }
                else if (llllllllllllllIlllIIIIllIIlIlIIl < 0.55f) {
                    this.field_151562_a = Blocks.monster_egg.getStateFromMeta(BlockSilverfish.EnumType.STONEBRICK.func_176881_a());
                }
                else {
                    this.field_151562_a = Blocks.stonebrick.getDefaultState();
                }
            }
            else {
                this.field_151562_a = Blocks.air.getDefaultState();
            }
        }
        
        static {
            __OBFID = "CL_00000497";
        }
        
        Stones(final Object llllllllllllllIlllIIIIllIIlIIIlI) {
            this();
        }
    }
    
    public static class Stairs extends Stronghold
    {
        private /* synthetic */ boolean field_75024_a;
        
        static {
            __OBFID = "CL_00000498";
        }
        
        public Stairs(final int llllllllllllllllIllIIIlIIIIlllII, final Random llllllllllllllllIllIIIlIIIIlIllI, final StructureBoundingBox llllllllllllllllIllIIIlIIIIlIlIl, final EnumFacing llllllllllllllllIllIIIlIIIIllIIl) {
            super(llllllllllllllllIllIIIlIIIIlllII);
            this.field_75024_a = false;
            this.coordBaseMode = llllllllllllllllIllIIIlIIIIllIIl;
            this.field_143013_d = this.getRandomDoor(llllllllllllllllIllIIIlIIIIlIllI);
            this.boundingBox = llllllllllllllllIllIIIlIIIIlIlIl;
        }
        
        public Stairs(final int llllllllllllllllIllIIIlIIIlIIllI, final Random llllllllllllllllIllIIIlIIIlIIlIl, final int llllllllllllllllIllIIIlIIIlIlIIl, final int llllllllllllllllIllIIIlIIIlIlIII) {
            super(llllllllllllllllIllIIIlIIIlIIllI);
            this.field_75024_a = true;
            this.coordBaseMode = EnumFacing.Plane.HORIZONTAL.random(llllllllllllllllIllIIIlIIIlIIlIl);
            this.field_143013_d = Door.OPENING;
            switch (StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.coordBaseMode.ordinal()]) {
                case 1:
                case 2: {
                    this.boundingBox = new StructureBoundingBox(llllllllllllllllIllIIIlIIIlIlIIl, 64, llllllllllllllllIllIIIlIIIlIlIII, llllllllllllllllIllIIIlIIIlIlIIl + 5 - 1, 74, llllllllllllllllIllIIIlIIIlIlIII + 5 - 1);
                    break;
                }
                default: {
                    this.boundingBox = new StructureBoundingBox(llllllllllllllllIllIIIlIIIlIlIIl, 64, llllllllllllllllIllIIIlIIIlIlIII, llllllllllllllllIllIIIlIIIlIlIIl + 5 - 1, 74, llllllllllllllllIllIIIlIIIlIlIII + 5 - 1);
                    break;
                }
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllllIllIIIlIIIIIlllI) {
            super.writeStructureToNBT(llllllllllllllllIllIIIlIIIIIlllI);
            llllllllllllllllIllIIIlIIIIIlllI.setBoolean("Source", this.field_75024_a);
        }
        
        public static Stairs func_175863_a(final List llllllllllllllllIllIIIIlllllIIll, final Random llllllllllllllllIllIIIIllllIlIlI, final int llllllllllllllllIllIIIIllllIlIIl, final int llllllllllllllllIllIIIIllllIlIII, final int llllllllllllllllIllIIIIllllIllll, final EnumFacing llllllllllllllllIllIIIIllllIIllI, final int llllllllllllllllIllIIIIllllIllIl) {
            final StructureBoundingBox llllllllllllllllIllIIIIllllIllII = StructureBoundingBox.func_175897_a(llllllllllllllllIllIIIIllllIlIIl, llllllllllllllllIllIIIIllllIlIII, llllllllllllllllIllIIIIllllIllll, -1, -7, 0, 5, 11, 5, llllllllllllllllIllIIIIllllIIllI);
            return (Stronghold.canStrongholdGoDeeper(llllllllllllllllIllIIIIllllIllII) && StructureComponent.findIntersecting(llllllllllllllllIllIIIIlllllIIll, llllllllllllllllIllIIIIllllIllII) == null) ? new Stairs(llllllllllllllllIllIIIIllllIllIl, llllllllllllllllIllIIIIllllIlIlI, llllllllllllllllIllIIIIllllIllII, llllllllllllllllIllIIIIllllIIllI) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIllIIIIlllIllllI, final Random llllllllllllllllIllIIIIlllIlllIl, final StructureBoundingBox llllllllllllllllIllIIIIlllIlllII) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllllllIllIIIIlllIllllI, llllllllllllllllIllIIIIlllIlllII)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllllllllllIllIIIIlllIllllI, llllllllllllllllIllIIIIlllIlllII, 0, 0, 0, 4, 10, 4, true, llllllllllllllllIllIIIIlllIlllIl, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(llllllllllllllllIllIIIIlllIllllI, llllllllllllllllIllIIIIlllIlllIl, llllllllllllllllIllIIIIlllIlllII, this.field_143013_d, 1, 7, 0);
            this.placeDoor(llllllllllllllllIllIIIIlllIllllI, llllllllllllllllIllIIIIlllIlllIl, llllllllllllllllIllIIIIlllIlllII, Door.OPENING, 1, 1, 4);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 2, 6, 1, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 1, 5, 1, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.func_176624_a()), 1, 6, 1, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 1, 5, 2, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 1, 4, 3, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.func_176624_a()), 1, 5, 3, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 2, 4, 3, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 3, 3, 3, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.func_176624_a()), 3, 4, 3, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 3, 3, 2, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 3, 2, 1, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.func_176624_a()), 3, 3, 1, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 2, 2, 1, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 1, 1, 1, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.func_176624_a()), 1, 2, 1, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stonebrick.getDefaultState(), 1, 1, 2, llllllllllllllllIllIIIIlllIlllII);
            this.func_175811_a(llllllllllllllllIllIIIIlllIllllI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.STONE.func_176624_a()), 1, 1, 3, llllllllllllllllIllIIIIlllIlllII);
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllllIllIIIlIIIIIlIII) {
            super.readStructureFromNBT(llllllllllllllllIllIIIlIIIIIlIII);
            this.field_75024_a = llllllllllllllllIllIIIlIIIIIlIII.getBoolean("Source");
        }
        
        public Stairs() {
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllllIllIIIIllllllllI, final List llllllllllllllllIllIIIIlllllllIl, final Random llllllllllllllllIllIIIlIIIIIIIII) {
            if (this.field_75024_a) {
                StructureStrongholdPieces.access$2(Crossing.class);
            }
            this.getNextComponentNormal((Stairs2)llllllllllllllllIllIIIIllllllllI, llllllllllllllllIllIIIIlllllllIl, llllllllllllllllIllIIIlIIIIIIIII, 1, 1);
        }
    }
    
    public static class Crossing extends Stronghold
    {
        private /* synthetic */ boolean field_74999_h;
        private /* synthetic */ boolean field_74997_c;
        private /* synthetic */ boolean field_74995_d;
        private /* synthetic */ boolean field_74996_b;
        
        public static Crossing func_175866_a(final List lllllllllllllllIllIllIIIIIlIIlll, final Random lllllllllllllllIllIllIIIIIlIIllI, final int lllllllllllllllIllIllIIIIIlIllIl, final int lllllllllllllllIllIllIIIIIlIIlII, final int lllllllllllllllIllIllIIIIIlIIIll, final EnumFacing lllllllllllllllIllIllIIIIIlIlIlI, final int lllllllllllllllIllIllIIIIIlIlIIl) {
            final StructureBoundingBox lllllllllllllllIllIllIIIIIlIlIII = StructureBoundingBox.func_175897_a(lllllllllllllllIllIllIIIIIlIllIl, lllllllllllllllIllIllIIIIIlIIlII, lllllllllllllllIllIllIIIIIlIIIll, -4, -3, 0, 10, 9, 11, lllllllllllllllIllIllIIIIIlIlIlI);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllllIllIllIIIIIlIlIII) && StructureComponent.findIntersecting(lllllllllllllllIllIllIIIIIlIIlll, lllllllllllllllIllIllIIIIIlIlIII) == null) ? new Crossing(lllllllllllllllIllIllIIIIIlIlIIl, lllllllllllllllIllIllIIIIIlIIllI, lllllllllllllllIllIllIIIIIlIlIII, lllllllllllllllIllIllIIIIIlIlIlI) : null;
        }
        
        public Crossing(final int lllllllllllllllIllIllIIIIllIIllI, final Random lllllllllllllllIllIllIIIIllIlllI, final StructureBoundingBox lllllllllllllllIllIllIIIIllIllII, final EnumFacing lllllllllllllllIllIllIIIIllIlIlI) {
            super(lllllllllllllllIllIllIIIIllIIllI);
            this.coordBaseMode = lllllllllllllllIllIllIIIIllIlIlI;
            this.field_143013_d = this.getRandomDoor(lllllllllllllllIllIllIIIIllIlllI);
            this.boundingBox = lllllllllllllllIllIllIIIIllIllII;
            this.field_74996_b = lllllllllllllllIllIllIIIIllIlllI.nextBoolean();
            this.field_74997_c = lllllllllllllllIllIllIIIIllIlllI.nextBoolean();
            this.field_74995_d = lllllllllllllllIllIllIIIIllIlllI.nextBoolean();
            this.field_74999_h = (lllllllllllllllIllIllIIIIllIlllI.nextInt(3) > 0);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIllIllIIIIlIlIlIl) {
            super.writeStructureToNBT(lllllllllllllllIllIllIIIIlIlIlIl);
            lllllllllllllllIllIllIIIIlIlIlIl.setBoolean("leftLow", this.field_74996_b);
            lllllllllllllllIllIllIIIIlIlIlIl.setBoolean("leftHigh", this.field_74997_c);
            lllllllllllllllIllIllIIIIlIlIlIl.setBoolean("rightLow", this.field_74995_d);
            lllllllllllllllIllIllIIIIlIlIlIl.setBoolean("rightHigh", this.field_74999_h);
        }
        
        static {
            __OBFID = "CL_00000489";
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIllIllIIIIlIIIIlI, final List lllllllllllllllIllIllIIIIlIIIIIl, final Random lllllllllllllllIllIllIIIIIlllIlI) {
            int lllllllllllllllIllIllIIIIIllllll = 3;
            int lllllllllllllllIllIllIIIIIlllllI = 5;
            if (this.coordBaseMode == EnumFacing.WEST || this.coordBaseMode == EnumFacing.NORTH) {
                lllllllllllllllIllIllIIIIIllllll = 8 - lllllllllllllllIllIllIIIIIllllll;
                lllllllllllllllIllIllIIIIIlllllI = 8 - lllllllllllllllIllIllIIIIIlllllI;
            }
            this.getNextComponentNormal((Stairs2)lllllllllllllllIllIllIIIIlIIIIlI, lllllllllllllllIllIllIIIIlIIIIIl, lllllllllllllllIllIllIIIIIlllIlI, 5, 1);
            if (this.field_74996_b) {
                this.getNextComponentX((Stairs2)lllllllllllllllIllIllIIIIlIIIIlI, lllllllllllllllIllIllIIIIlIIIIIl, lllllllllllllllIllIllIIIIIlllIlI, lllllllllllllllIllIllIIIIIllllll, 1);
            }
            if (this.field_74997_c) {
                this.getNextComponentX((Stairs2)lllllllllllllllIllIllIIIIlIIIIlI, lllllllllllllllIllIllIIIIlIIIIIl, lllllllllllllllIllIllIIIIIlllIlI, lllllllllllllllIllIllIIIIIlllllI, 7);
            }
            if (this.field_74995_d) {
                this.getNextComponentZ((Stairs2)lllllllllllllllIllIllIIIIlIIIIlI, lllllllllllllllIllIllIIIIlIIIIIl, lllllllllllllllIllIllIIIIIlllIlI, lllllllllllllllIllIllIIIIIllllll, 1);
            }
            if (this.field_74999_h) {
                this.getNextComponentZ((Stairs2)lllllllllllllllIllIllIIIIlIIIIlI, lllllllllllllllIllIllIIIIlIIIIIl, lllllllllllllllIllIllIIIIIlllIlI, lllllllllllllllIllIllIIIIIlllllI, 7);
            }
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIllIllIIIIlIIlIlI) {
            super.readStructureFromNBT(lllllllllllllllIllIllIIIIlIIlIlI);
            this.field_74996_b = lllllllllllllllIllIllIIIIlIIlIlI.getBoolean("leftLow");
            this.field_74997_c = lllllllllllllllIllIllIIIIlIIlIlI.getBoolean("leftHigh");
            this.field_74995_d = lllllllllllllllIllIllIIIIlIIlIlI.getBoolean("rightLow");
            this.field_74999_h = lllllllllllllllIllIllIIIIlIIlIlI.getBoolean("rightHigh");
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIllIllIIIIIIllIlI, final Random lllllllllllllllIllIllIIIIIIllIIl, final StructureBoundingBox lllllllllllllllIllIllIIIIIIllIII) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 0, 0, 0, 9, 8, 10, true, lllllllllllllllIllIllIIIIIIllIIl, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIIl, lllllllllllllllIllIllIIIIIIllIII, this.field_143013_d, 4, 3, 0);
            if (this.field_74996_b) {
                this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 0, 3, 1, 0, 5, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            if (this.field_74995_d) {
                this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 9, 3, 1, 9, 5, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            if (this.field_74997_c) {
                this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 0, 5, 7, 0, 7, 9, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            if (this.field_74999_h) {
                this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 9, 5, 7, 9, 7, 9, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 5, 1, 10, 7, 3, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 1, 2, 1, 8, 2, 6, false, lllllllllllllllIllIllIIIIIIllIIl, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 4, 1, 5, 4, 4, 9, false, lllllllllllllllIllIllIIIIIIllIIl, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 8, 1, 5, 8, 4, 9, false, lllllllllllllllIllIllIIIIIIllIIl, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 1, 4, 7, 3, 4, 9, false, lllllllllllllllIllIllIIIIIIllIIl, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 1, 3, 5, 3, 3, 6, false, lllllllllllllllIllIllIIIIIIllIIl, StructureStrongholdPieces.strongholdStones);
            this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 1, 3, 4, 3, 3, 4, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 1, 4, 6, 3, 4, 6, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.fillWithRandomizedBlocks(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 5, 1, 7, 7, 1, 8, false, lllllllllllllllIllIllIIIIIIllIIl, StructureStrongholdPieces.strongholdStones);
            this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 5, 1, 9, 7, 1, 9, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 5, 2, 7, 7, 2, 7, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 4, 5, 7, 4, 5, 9, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 8, 5, 7, 8, 5, 9, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIllIIIIIIllIlI, lllllllllllllllIllIllIIIIIIllIII, 5, 5, 7, 7, 5, 9, Blocks.double_stone_slab.getDefaultState(), Blocks.double_stone_slab.getDefaultState(), false);
            this.func_175811_a(lllllllllllllllIllIllIIIIIIllIlI, Blocks.torch.getDefaultState(), 6, 5, 6, lllllllllllllllIllIllIIIIIIllIII);
            return true;
        }
        
        public Crossing() {
        }
    }
    
    public static class ChestCorridor extends Stronghold
    {
        private static final /* synthetic */ List strongholdChestContents;
        private /* synthetic */ boolean hasMadeChest;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIlllIlIllllIllIll) {
            super.writeStructureToNBT(lllllllllllllllIlllIlIllllIllIll);
            lllllllllllllllIlllIlIllllIllIll.setBoolean("Chest", this.hasMadeChest);
        }
        
        public ChestCorridor() {
        }
        
        public ChestCorridor(final int lllllllllllllllIlllIlIlllllIIlII, final Random lllllllllllllllIlllIlIlllllIIIll, final StructureBoundingBox lllllllllllllllIlllIlIlllllIIIlI, final EnumFacing lllllllllllllllIlllIlIlllllIIllI) {
            super(lllllllllllllllIlllIlIlllllIIlII);
            this.coordBaseMode = lllllllllllllllIlllIlIlllllIIllI;
            this.field_143013_d = this.getRandomDoor(lllllllllllllllIlllIlIlllllIIIll);
            this.boundingBox = lllllllllllllllIlllIlIlllllIIIlI;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIlllIlIllllIIllll, final List lllllllllllllllIlllIlIllllIIlllI, final Random lllllllllllllllIlllIlIllllIIllIl) {
            this.getNextComponentNormal((Stairs2)lllllllllllllllIlllIlIllllIIllll, lllllllllllllllIlllIlIllllIIlllI, lllllllllllllllIlllIlIllllIIllIl, 1, 1);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIlllIlIlllIlIlIlI, final Random lllllllllllllllIlllIlIlllIlIlIIl, final StructureBoundingBox lllllllllllllllIlllIlIlllIlIlIII) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllIlllIlIlllIlIlIlI, lllllllllllllllIlllIlIlllIlIlIII)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllllIlllIlIlllIlIlIlI, lllllllllllllllIlllIlIlllIlIlIII, 0, 0, 0, 4, 4, 6, true, lllllllllllllllIlllIlIlllIlIlIIl, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(lllllllllllllllIlllIlIlllIlIlIlI, lllllllllllllllIlllIlIlllIlIlIIl, lllllllllllllllIlllIlIlllIlIlIII, this.field_143013_d, 1, 1, 0);
            this.placeDoor(lllllllllllllllIlllIlIlllIlIlIlI, lllllllllllllllIlllIlIlllIlIlIIl, lllllllllllllllIlllIlIlllIlIlIII, Door.OPENING, 1, 1, 6);
            this.func_175804_a(lllllllllllllllIlllIlIlllIlIlIlI, lllllllllllllllIlllIlIlllIlIlIII, 3, 1, 2, 3, 1, 4, Blocks.stonebrick.getDefaultState(), Blocks.stonebrick.getDefaultState(), false);
            this.func_175811_a(lllllllllllllllIlllIlIlllIlIlIlI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), 3, 1, 1, lllllllllllllllIlllIlIlllIlIlIII);
            this.func_175811_a(lllllllllllllllIlllIlIlllIlIlIlI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), 3, 1, 5, lllllllllllllllIlllIlIlllIlIlIII);
            this.func_175811_a(lllllllllllllllIlllIlIlllIlIlIlI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), 3, 2, 2, lllllllllllllllIlllIlIlllIlIlIII);
            this.func_175811_a(lllllllllllllllIlllIlIlllIlIlIlI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), 3, 2, 4, lllllllllllllllIlllIlIlllIlIlIII);
            for (int lllllllllllllllIlllIlIlllIlIIlll = 2; lllllllllllllllIlllIlIlllIlIIlll <= 4; ++lllllllllllllllIlllIlIlllIlIIlll) {
                this.func_175811_a(lllllllllllllllIlllIlIlllIlIlIlI, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), 2, 1, lllllllllllllllIlllIlIlllIlIIlll, lllllllllllllllIlllIlIlllIlIlIII);
            }
            if (!this.hasMadeChest && lllllllllllllllIlllIlIlllIlIlIII.func_175898_b(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3)))) {
                this.hasMadeChest = true;
                this.func_180778_a(lllllllllllllllIlllIlIlllIlIlIlI, lllllllllllllllIlllIlIlllIlIlIII, lllllllllllllllIlllIlIlllIlIlIIl, 3, 2, 3, WeightedRandomChestContent.func_177629_a(ChestCorridor.strongholdChestContents, Items.enchanted_book.getRandomEnchantedBook(lllllllllllllllIlllIlIlllIlIlIIl)), 2 + lllllllllllllllIlllIlIlllIlIlIIl.nextInt(2));
            }
            return true;
        }
        
        public static ChestCorridor func_175868_a(final List lllllllllllllllIlllIlIllllIIIIII, final Random lllllllllllllllIlllIlIlllIllIlll, final int lllllllllllllllIlllIlIlllIllIllI, final int lllllllllllllllIlllIlIlllIllIlIl, final int lllllllllllllllIlllIlIlllIllIlII, final EnumFacing lllllllllllllllIlllIlIlllIlllIll, final int lllllllllllllllIlllIlIlllIllIIlI) {
            final StructureBoundingBox lllllllllllllllIlllIlIlllIlllIIl = StructureBoundingBox.func_175897_a(lllllllllllllllIlllIlIlllIllIllI, lllllllllllllllIlllIlIlllIllIlIl, lllllllllllllllIlllIlIlllIllIlII, -1, -1, 0, 5, 5, 7, lllllllllllllllIlllIlIlllIlllIll);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllllIlllIlIlllIlllIIl) && StructureComponent.findIntersecting(lllllllllllllllIlllIlIllllIIIIII, lllllllllllllllIlllIlIlllIlllIIl) == null) ? new ChestCorridor(lllllllllllllllIlllIlIlllIllIIlI, lllllllllllllllIlllIlIlllIllIlll, lllllllllllllllIlllIlIlllIlllIIl, lllllllllllllllIlllIlIlllIlllIll) : null;
        }
        
        static {
            __OBFID = "CL_00000487";
            strongholdChestContents = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.ender_pearl, 0, 1, 1, 10), new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.redstone, 0, 4, 9, 5), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_helmet, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_leggings, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_boots, 0, 1, 1, 5), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 1), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 1), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1) });
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIlllIlIllllIlIlll) {
            super.readStructureFromNBT(lllllllllllllllIlllIlIllllIlIlll);
            this.hasMadeChest = lllllllllllllllIlllIlIllllIlIlll.getBoolean("Chest");
        }
    }
    
    public static class Corridor extends Stronghold
    {
        private /* synthetic */ int field_74993_a;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIlllIlIIlIIlIIIll) {
            super.readStructureFromNBT(lllllllllllllllIlllIlIIlIIlIIIll);
            this.field_74993_a = lllllllllllllllIlllIlIIlIIlIIIll.getInteger("Steps");
        }
        
        public Corridor(final int lllllllllllllllIlllIlIIlIIllIllI, final Random lllllllllllllllIlllIlIIlIIllIlIl, final StructureBoundingBox lllllllllllllllIlllIlIIlIIllIlII, final EnumFacing lllllllllllllllIlllIlIIlIIlIllll) {
            super(lllllllllllllllIlllIlIIlIIllIllI);
            this.coordBaseMode = lllllllllllllllIlllIlIIlIIlIllll;
            this.boundingBox = lllllllllllllllIlllIlIIlIIllIlII;
            this.field_74993_a = ((lllllllllllllllIlllIlIIlIIlIllll != EnumFacing.NORTH && lllllllllllllllIlllIlIIlIIlIllll != EnumFacing.SOUTH) ? lllllllllllllllIlllIlIIlIIllIlII.getXSize() : lllllllllllllllIlllIlIIlIIllIlII.getZSize());
        }
        
        public Corridor() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIlllIlIIlIIIIIIII, final Random lllllllllllllllIlllIlIIIllllllll, final StructureBoundingBox lllllllllllllllIlllIlIIIlllllIIl) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllIlllIlIIlIIIIIIII, lllllllllllllllIlllIlIIIlllllIIl)) {
                return false;
            }
            for (int lllllllllllllllIlllIlIIIllllllIl = 0; lllllllllllllllIlllIlIIIllllllIl < this.field_74993_a; ++lllllllllllllllIlllIlIIIllllllIl) {
                this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 0, 0, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 1, 0, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 2, 0, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 3, 0, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 4, 0, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                for (int lllllllllllllllIlllIlIIIllllllII = 1; lllllllllllllllIlllIlIIIllllllII <= 3; ++lllllllllllllllIlllIlIIIllllllII) {
                    this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 0, lllllllllllllllIlllIlIIIllllllII, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                    this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.air.getDefaultState(), 1, lllllllllllllllIlllIlIIIllllllII, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                    this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.air.getDefaultState(), 2, lllllllllllllllIlllIlIIIllllllII, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                    this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.air.getDefaultState(), 3, lllllllllllllllIlllIlIIIllllllII, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                    this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 4, lllllllllllllllIlllIlIIIllllllII, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                }
                this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 0, 4, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 1, 4, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 2, 4, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 3, 4, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
                this.func_175811_a(lllllllllllllllIlllIlIIlIIIIIIII, Blocks.stonebrick.getDefaultState(), 4, 4, lllllllllllllllIlllIlIIIllllllIl, lllllllllllllllIlllIlIIIlllllIIl);
            }
            return true;
        }
        
        public static StructureBoundingBox func_175869_a(final List lllllllllllllllIlllIlIIlIIIllIIl, final Random lllllllllllllllIlllIlIIlIIIllIII, final int lllllllllllllllIlllIlIIlIIIlIlll, final int lllllllllllllllIlllIlIIlIIIIllIl, final int lllllllllllllllIlllIlIIlIIIIllII, final EnumFacing lllllllllllllllIlllIlIIlIIIlIlII) {
            final boolean lllllllllllllllIlllIlIIlIIIlIIll = true;
            StructureBoundingBox lllllllllllllllIlllIlIIlIIIlIIlI = StructureBoundingBox.func_175897_a(lllllllllllllllIlllIlIIlIIIlIlll, lllllllllllllllIlllIlIIlIIIIllIl, lllllllllllllllIlllIlIIlIIIIllII, -1, -1, 0, 5, 5, 4, lllllllllllllllIlllIlIIlIIIlIlII);
            final StructureComponent lllllllllllllllIlllIlIIlIIIlIIIl = StructureComponent.findIntersecting(lllllllllllllllIlllIlIIlIIIllIIl, lllllllllllllllIlllIlIIlIIIlIIlI);
            if (lllllllllllllllIlllIlIIlIIIlIIIl == null) {
                return null;
            }
            if (lllllllllllllllIlllIlIIlIIIlIIIl.getBoundingBox().minY == lllllllllllllllIlllIlIIlIIIlIIlI.minY) {
                for (int lllllllllllllllIlllIlIIlIIIlIIII = 3; lllllllllllllllIlllIlIIlIIIlIIII >= 1; --lllllllllllllllIlllIlIIlIIIlIIII) {
                    lllllllllllllllIlllIlIIlIIIlIIlI = StructureBoundingBox.func_175897_a(lllllllllllllllIlllIlIIlIIIlIlll, lllllllllllllllIlllIlIIlIIIIllIl, lllllllllllllllIlllIlIIlIIIIllII, -1, -1, 0, 5, 5, lllllllllllllllIlllIlIIlIIIlIIII - 1, lllllllllllllllIlllIlIIlIIIlIlII);
                    if (!lllllllllllllllIlllIlIIlIIIlIIIl.getBoundingBox().intersectsWith(lllllllllllllllIlllIlIIlIIIlIIlI)) {
                        return StructureBoundingBox.func_175897_a(lllllllllllllllIlllIlIIlIIIlIlll, lllllllllllllllIlllIlIIlIIIIllIl, lllllllllllllllIlllIlIIlIIIIllII, -1, -1, 0, 5, 5, lllllllllllllllIlllIlIIlIIIlIIII, lllllllllllllllIlllIlIIlIIIlIlII);
                    }
                }
            }
            return null;
        }
        
        static {
            __OBFID = "CL_00000488";
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIlllIlIIlIIlIlIll) {
            super.writeStructureToNBT(lllllllllllllllIlllIlIIlIIlIlIll);
            lllllllllllllllIlllIlIIlIIlIlIll.setInteger("Steps", this.field_74993_a);
        }
    }
    
    public static class RightTurn extends LeftTurn
    {
        static {
            __OBFID = "CL_00000495";
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlIIIIlIIlIllIlIl, final Random llllllllllllllIIlIIIIlIIlIlllIIl, final StructureBoundingBox llllllllllllllIIlIIIIlIIlIllIIlI) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllllIIlIIIIlIIlIllIlIl, llllllllllllllIIlIIIIlIIlIllIIlI)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllllllllIIlIIIIlIIlIllIlIl, llllllllllllllIIlIIIIlIIlIllIIlI, 0, 0, 0, 4, 4, 4, true, llllllllllllllIIlIIIIlIIlIlllIIl, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(llllllllllllllIIlIIIIlIIlIllIlIl, llllllllllllllIIlIIIIlIIlIlllIIl, llllllllllllllIIlIIIIlIIlIllIIlI, this.field_143013_d, 1, 1, 0);
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.EAST) {
                this.func_175804_a(llllllllllllllIIlIIIIlIIlIllIlIl, llllllllllllllIIlIIIIlIIlIllIIlI, 0, 1, 1, 0, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            else {
                this.func_175804_a(llllllllllllllIIlIIIIlIIlIllIlIl, llllllllllllllIIlIIIIlIIlIllIIlI, 4, 1, 1, 4, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIIlIIIIlIIllIlIllI, final List llllllllllllllIIlIIIIlIIllIlIlII, final Random llllllllllllllIIlIIIIlIIllIlIIlI) {
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.EAST) {
                this.getNextComponentX((Stairs2)llllllllllllllIIlIIIIlIIllIlIllI, llllllllllllllIIlIIIIlIIllIlIlII, llllllllllllllIIlIIIIlIIllIlIIlI, 1, 1);
            }
            else {
                this.getNextComponentZ((Stairs2)llllllllllllllIIlIIIIlIIllIlIllI, llllllllllllllIIlIIIIlIIllIlIlII, llllllllllllllIIlIIIIlIIllIlIIlI, 1, 1);
            }
        }
    }
    
    public static class LeftTurn extends Stronghold
    {
        public static LeftTurn func_175867_a(final List lllllllllllllllllllllIlIIIIlIIIl, final Random lllllllllllllllllllllIlIIIIIlIII, final int lllllllllllllllllllllIlIIIIIllll, final int lllllllllllllllllllllIlIIIIIlllI, final int lllllllllllllllllllllIlIIIIIIlIl, final EnumFacing lllllllllllllllllllllIlIIIIIllII, final int lllllllllllllllllllllIlIIIIIIIll) {
            final StructureBoundingBox lllllllllllllllllllllIlIIIIIlIlI = StructureBoundingBox.func_175897_a(lllllllllllllllllllllIlIIIIIllll, lllllllllllllllllllllIlIIIIIlllI, lllllllllllllllllllllIlIIIIIIlIl, -1, -1, 0, 5, 5, 5, lllllllllllllllllllllIlIIIIIllII);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllllllllllIlIIIIIlIlI) && StructureComponent.findIntersecting(lllllllllllllllllllllIlIIIIlIIIl, lllllllllllllllllllllIlIIIIIlIlI) == null) ? new LeftTurn(lllllllllllllllllllllIlIIIIIIIll, lllllllllllllllllllllIlIIIIIlIII, lllllllllllllllllllllIlIIIIIlIlI, lllllllllllllllllllllIlIIIIIllII) : null;
        }
        
        static {
            __OBFID = "CL_00000490";
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllllllllIlIIIlIIIII, final List lllllllllllllllllllllIlIIIIlllll, final Random lllllllllllllllllllllIlIIIIllllI) {
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.EAST) {
                this.getNextComponentZ((Stairs2)lllllllllllllllllllllIlIIIlIIIII, lllllllllllllllllllllIlIIIIlllll, lllllllllllllllllllllIlIIIIllllI, 1, 1);
            }
            else {
                this.getNextComponentX((Stairs2)lllllllllllllllllllllIlIIIlIIIII, lllllllllllllllllllllIlIIIIlllll, lllllllllllllllllllllIlIIIIllllI, 1, 1);
            }
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllllllllIIllllllIII, final Random lllllllllllllllllllllIIlllllIlll, final StructureBoundingBox lllllllllllllllllllllIIllllllIlI) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllllllllIIllllllIII, lllllllllllllllllllllIIllllllIlI)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllllllllllIIllllllIII, lllllllllllllllllllllIIllllllIlI, 0, 0, 0, 4, 4, 4, true, lllllllllllllllllllllIIlllllIlll, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(lllllllllllllllllllllIIllllllIII, lllllllllllllllllllllIIlllllIlll, lllllllllllllllllllllIIllllllIlI, this.field_143013_d, 1, 1, 0);
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.EAST) {
                this.func_175804_a(lllllllllllllllllllllIIllllllIII, lllllllllllllllllllllIIllllllIlI, 4, 1, 1, 4, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            else {
                this.func_175804_a(lllllllllllllllllllllIIllllllIII, lllllllllllllllllllllIIllllllIlI, 0, 1, 1, 0, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            return true;
        }
        
        public LeftTurn() {
        }
        
        public LeftTurn(final int lllllllllllllllllllllIlIIIlIlIIl, final Random lllllllllllllllllllllIlIIIlIlIII, final StructureBoundingBox lllllllllllllllllllllIlIIIlIllII, final EnumFacing lllllllllllllllllllllIlIIIlIlIll) {
            super(lllllllllllllllllllllIlIIIlIlIIl);
            this.coordBaseMode = lllllllllllllllllllllIlIIIlIlIll;
            this.field_143013_d = this.getRandomDoor(lllllllllllllllllllllIlIIIlIlIII);
            this.boundingBox = lllllllllllllllllllllIlIIIlIllII;
        }
    }
    
    public static class Straight extends Stronghold
    {
        private /* synthetic */ boolean expandsX;
        private /* synthetic */ boolean expandsZ;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIllIllIlIlIlllIIII) {
            super.readStructureFromNBT(llllllllllllllIllIllIlIlIlllIIII);
            this.expandsX = llllllllllllllIllIllIlIlIlllIIII.getBoolean("Left");
            this.expandsZ = llllllllllllllIllIllIlIlIlllIIII.getBoolean("Right");
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIllIllIlIlIllIIllI, final List llllllllllllllIllIllIlIlIllIlIIl, final Random llllllllllllllIllIllIlIlIllIlIII) {
            this.getNextComponentNormal((Stairs2)llllllllllllllIllIllIlIlIllIIllI, llllllllllllllIllIllIlIlIllIlIIl, llllllllllllllIllIllIlIlIllIlIII, 1, 1);
            if (this.expandsX) {
                this.getNextComponentX((Stairs2)llllllllllllllIllIllIlIlIllIIllI, llllllllllllllIllIllIlIlIllIlIIl, llllllllllllllIllIllIlIlIllIlIII, 1, 2);
            }
            if (this.expandsZ) {
                this.getNextComponentZ((Stairs2)llllllllllllllIllIllIlIlIllIIllI, llllllllllllllIllIllIlIlIllIlIIl, llllllllllllllIllIllIlIlIllIlIII, 1, 2);
            }
        }
        
        public static Straight func_175862_a(final List llllllllllllllIllIllIlIlIlIllIll, final Random llllllllllllllIllIllIlIlIlIllIlI, final int llllllllllllllIllIllIlIlIlIlIIIl, final int llllllllllllllIllIllIlIlIlIllIII, final int llllllllllllllIllIllIlIlIlIlIlll, final EnumFacing llllllllllllllIllIllIlIlIlIIlllI, final int llllllllllllllIllIllIlIlIlIIllIl) {
            final StructureBoundingBox llllllllllllllIllIllIlIlIlIlIlII = StructureBoundingBox.func_175897_a(llllllllllllllIllIllIlIlIlIlIIIl, llllllllllllllIllIllIlIlIlIllIII, llllllllllllllIllIllIlIlIlIlIlll, -1, -1, 0, 5, 5, 7, llllllllllllllIllIllIlIlIlIIlllI);
            return (Stronghold.canStrongholdGoDeeper(llllllllllllllIllIllIlIlIlIlIlII) && StructureComponent.findIntersecting(llllllllllllllIllIllIlIlIlIllIll, llllllllllllllIllIllIlIlIlIlIlII) == null) ? new Straight(llllllllllllllIllIllIlIlIlIIllIl, llllllllllllllIllIllIlIlIlIllIlI, llllllllllllllIllIllIlIlIlIlIlII, llllllllllllllIllIllIlIlIlIIlllI) : null;
        }
        
        public Straight() {
        }
        
        static {
            __OBFID = "CL_00000500";
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIllIllIlIlIlIIIllI, final Random llllllllllllllIllIllIlIlIlIIIIIl, final StructureBoundingBox llllllllllllllIllIllIlIlIlIIIlII) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllllIllIllIlIlIlIIIllI, llllllllllllllIllIllIlIlIlIIIlII)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllllllllIllIllIlIlIlIIIllI, llllllllllllllIllIllIlIlIlIIIlII, 0, 0, 0, 4, 4, 6, true, llllllllllllllIllIllIlIlIlIIIIIl, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(llllllllllllllIllIllIlIlIlIIIllI, llllllllllllllIllIllIlIlIlIIIIIl, llllllllllllllIllIllIlIlIlIIIlII, this.field_143013_d, 1, 1, 0);
            this.placeDoor(llllllllllllllIllIllIlIlIlIIIllI, llllllllllllllIllIllIlIlIlIIIIIl, llllllllllllllIllIllIlIlIlIIIlII, Door.OPENING, 1, 1, 6);
            this.func_175809_a(llllllllllllllIllIllIlIlIlIIIllI, llllllllllllllIllIllIlIlIlIIIlII, llllllllllllllIllIllIlIlIlIIIIIl, 0.1f, 1, 2, 1, Blocks.torch.getDefaultState());
            this.func_175809_a(llllllllllllllIllIllIlIlIlIIIllI, llllllllllllllIllIllIlIlIlIIIlII, llllllllllllllIllIllIlIlIlIIIIIl, 0.1f, 3, 2, 1, Blocks.torch.getDefaultState());
            this.func_175809_a(llllllllllllllIllIllIlIlIlIIIllI, llllllllllllllIllIllIlIlIlIIIlII, llllllllllllllIllIllIlIlIlIIIIIl, 0.1f, 1, 2, 5, Blocks.torch.getDefaultState());
            this.func_175809_a(llllllllllllllIllIllIlIlIlIIIllI, llllllllllllllIllIllIlIlIlIIIlII, llllllllllllllIllIllIlIlIlIIIIIl, 0.1f, 3, 2, 5, Blocks.torch.getDefaultState());
            if (this.expandsX) {
                this.func_175804_a(llllllllllllllIllIllIlIlIlIIIllI, llllllllllllllIllIllIlIlIlIIIlII, 0, 1, 2, 0, 3, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            if (this.expandsZ) {
                this.func_175804_a(llllllllllllllIllIllIlIlIlIIIllI, llllllllllllllIllIllIlIlIlIIIlII, 4, 1, 2, 4, 3, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            return true;
        }
        
        public Straight(final int llllllllllllllIllIllIlIlIlllllll, final Random llllllllllllllIllIllIlIlIllllllI, final StructureBoundingBox llllllllllllllIllIllIlIllIIIIIlI, final EnumFacing llllllllllllllIllIllIlIlIlllllII) {
            super(llllllllllllllIllIllIlIlIlllllll);
            this.coordBaseMode = llllllllllllllIllIllIlIlIlllllII;
            this.field_143013_d = this.getRandomDoor(llllllllllllllIllIllIlIlIllllllI);
            this.boundingBox = llllllllllllllIllIllIlIllIIIIIlI;
            this.expandsX = (llllllllllllllIllIllIlIlIllllllI.nextInt(2) == 0);
            this.expandsZ = (llllllllllllllIllIllIlIlIllllllI.nextInt(2) == 0);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIllIllIlIlIllllIII) {
            super.writeStructureToNBT(llllllllllllllIllIllIlIlIllllIII);
            llllllllllllllIllIllIlIlIllllIII.setBoolean("Left", this.expandsX);
            llllllllllllllIllIllIlIlIllllIII.setBoolean("Right", this.expandsZ);
        }
    }
    
    public static class RoomCrossing extends Stronghold
    {
        private static final /* synthetic */ List strongholdRoomCrossingChestContents;
        protected /* synthetic */ int roomType;
        
        @Override
        public void buildComponent(final StructureComponent lllllllllIIllII, final List lllllllllIIIlll, final Random lllllllllIIlIlI) {
            this.getNextComponentNormal((Stairs2)lllllllllIIllII, lllllllllIIIlll, lllllllllIIlIlI, 4, 1);
            this.getNextComponentX((Stairs2)lllllllllIIllII, lllllllllIIIlll, lllllllllIIlIlI, 1, 4);
            this.getNextComponentZ((Stairs2)lllllllllIIllII, lllllllllIIIlll, lllllllllIIlIlI, 1, 4);
        }
        
        static {
            __OBFID = "CL_00000496";
            strongholdRoomCrossingChestContents = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.redstone, 0, 4, 9, 5), new WeightedRandomChestContent(Items.coal, 0, 3, 8, 10), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 1) });
        }
        
        public static RoomCrossing func_175859_a(final List llllllllIllllIl, final Random llllllllIllIlII, final int llllllllIllIIll, final int llllllllIllIIlI, final int llllllllIlllIIl, final EnumFacing llllllllIlllIII, final int llllllllIlIllll) {
            final StructureBoundingBox llllllllIllIllI = StructureBoundingBox.func_175897_a(llllllllIllIIll, llllllllIllIIlI, llllllllIlllIIl, -4, -1, 0, 11, 7, 11, llllllllIlllIII);
            return (Stronghold.canStrongholdGoDeeper(llllllllIllIllI) && StructureComponent.findIntersecting(llllllllIllllIl, llllllllIllIllI) == null) ? new RoomCrossing(llllllllIlIllll, llllllllIllIlII, llllllllIllIllI, llllllllIlllIII) : null;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllIllIlI) {
            super.writeStructureToNBT(lllllllllIllIlI);
            lllllllllIllIlI.setInteger("Type", this.roomType);
        }
        
        public RoomCrossing(final int llllllllllIIllI, final Random llllllllllIIlIl, final StructureBoundingBox llllllllllIIlII, final EnumFacing lllllllllIllllI) {
            super(llllllllllIIllI);
            this.coordBaseMode = lllllllllIllllI;
            this.field_143013_d = this.getRandomDoor(llllllllllIIlIl);
            this.boundingBox = llllllllllIIlII;
            this.roomType = llllllllllIIlIl.nextInt(5);
        }
        
        public RoomCrossing() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllIlIlII) {
            super.readStructureFromNBT(lllllllllIlIlII);
            this.roomType = lllllllllIlIlII.getInteger("Type");
        }
        
        @Override
        public boolean addComponentParts(final World llllllllIlIIIIl, final Random llllllllIlIIIII, final StructureBoundingBox llllllllIlIIlIl) {
            if (this.isLiquidInStructureBoundingBox(llllllllIlIIIIl, llllllllIlIIlIl)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllIlIIIIl, llllllllIlIIlIl, 0, 0, 0, 10, 6, 10, true, llllllllIlIIIII, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(llllllllIlIIIIl, llllllllIlIIIII, llllllllIlIIlIl, this.field_143013_d, 4, 1, 0);
            this.func_175804_a(llllllllIlIIIIl, llllllllIlIIlIl, 4, 1, 10, 6, 3, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllIlIIIIl, llllllllIlIIlIl, 0, 1, 4, 0, 3, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllIlIIIIl, llllllllIlIIlIl, 10, 1, 4, 10, 3, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            switch (this.roomType) {
                case 0: {
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stonebrick.getDefaultState(), 5, 1, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stonebrick.getDefaultState(), 5, 2, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stonebrick.getDefaultState(), 5, 3, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.torch.getDefaultState(), 4, 3, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.torch.getDefaultState(), 6, 3, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.torch.getDefaultState(), 5, 3, 4, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.torch.getDefaultState(), 5, 3, 6, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stone_slab.getDefaultState(), 4, 1, 4, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stone_slab.getDefaultState(), 4, 1, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stone_slab.getDefaultState(), 4, 1, 6, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stone_slab.getDefaultState(), 6, 1, 4, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stone_slab.getDefaultState(), 6, 1, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stone_slab.getDefaultState(), 6, 1, 6, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stone_slab.getDefaultState(), 5, 1, 4, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stone_slab.getDefaultState(), 5, 1, 6, llllllllIlIIlIl);
                    break;
                }
                case 1: {
                    for (int llllllllIlIIlII = 0; llllllllIlIIlII < 5; ++llllllllIlIIlII) {
                        this.func_175811_a(llllllllIlIIIIl, Blocks.stonebrick.getDefaultState(), 3, 1, 3 + llllllllIlIIlII, llllllllIlIIlIl);
                        this.func_175811_a(llllllllIlIIIIl, Blocks.stonebrick.getDefaultState(), 7, 1, 3 + llllllllIlIIlII, llllllllIlIIlIl);
                        this.func_175811_a(llllllllIlIIIIl, Blocks.stonebrick.getDefaultState(), 3 + llllllllIlIIlII, 1, 3, llllllllIlIIlIl);
                        this.func_175811_a(llllllllIlIIIIl, Blocks.stonebrick.getDefaultState(), 3 + llllllllIlIIlII, 1, 7, llllllllIlIIlIl);
                    }
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stonebrick.getDefaultState(), 5, 1, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stonebrick.getDefaultState(), 5, 2, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.stonebrick.getDefaultState(), 5, 3, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.flowing_water.getDefaultState(), 5, 4, 5, llllllllIlIIlIl);
                    break;
                }
                case 2: {
                    for (int llllllllIlIIIll = 1; llllllllIlIIIll <= 9; ++llllllllIlIIIll) {
                        this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 1, 3, llllllllIlIIIll, llllllllIlIIlIl);
                        this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 9, 3, llllllllIlIIIll, llllllllIlIIlIl);
                    }
                    for (int llllllllIlIIIll = 1; llllllllIlIIIll <= 9; ++llllllllIlIIIll) {
                        this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), llllllllIlIIIll, 3, 1, llllllllIlIIlIl);
                        this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), llllllllIlIIIll, 3, 9, llllllllIlIIlIl);
                    }
                    this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 5, 1, 4, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 5, 1, 6, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 5, 3, 4, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 5, 3, 6, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 4, 1, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 6, 1, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 4, 3, 5, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 6, 3, 5, llllllllIlIIlIl);
                    for (int llllllllIlIIIll = 1; llllllllIlIIIll <= 3; ++llllllllIlIIIll) {
                        this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 4, llllllllIlIIIll, 4, llllllllIlIIlIl);
                        this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 6, llllllllIlIIIll, 4, llllllllIlIIlIl);
                        this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 4, llllllllIlIIIll, 6, llllllllIlIIlIl);
                        this.func_175811_a(llllllllIlIIIIl, Blocks.cobblestone.getDefaultState(), 6, llllllllIlIIIll, 6, llllllllIlIIlIl);
                    }
                    this.func_175811_a(llllllllIlIIIIl, Blocks.torch.getDefaultState(), 5, 3, 5, llllllllIlIIlIl);
                    for (int llllllllIlIIIll = 2; llllllllIlIIIll <= 8; ++llllllllIlIIIll) {
                        this.func_175811_a(llllllllIlIIIIl, Blocks.planks.getDefaultState(), 2, 3, llllllllIlIIIll, llllllllIlIIlIl);
                        this.func_175811_a(llllllllIlIIIIl, Blocks.planks.getDefaultState(), 3, 3, llllllllIlIIIll, llllllllIlIIlIl);
                        if (llllllllIlIIIll <= 3 || llllllllIlIIIll >= 7) {
                            this.func_175811_a(llllllllIlIIIIl, Blocks.planks.getDefaultState(), 4, 3, llllllllIlIIIll, llllllllIlIIlIl);
                            this.func_175811_a(llllllllIlIIIIl, Blocks.planks.getDefaultState(), 5, 3, llllllllIlIIIll, llllllllIlIIlIl);
                            this.func_175811_a(llllllllIlIIIIl, Blocks.planks.getDefaultState(), 6, 3, llllllllIlIIIll, llllllllIlIIlIl);
                        }
                        this.func_175811_a(llllllllIlIIIIl, Blocks.planks.getDefaultState(), 7, 3, llllllllIlIIIll, llllllllIlIIlIl);
                        this.func_175811_a(llllllllIlIIIIl, Blocks.planks.getDefaultState(), 8, 3, llllllllIlIIIll, llllllllIlIIlIl);
                    }
                    this.func_175811_a(llllllllIlIIIIl, Blocks.ladder.getStateFromMeta(this.getMetadataWithOffset(Blocks.ladder, EnumFacing.WEST.getIndex())), 9, 1, 3, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.ladder.getStateFromMeta(this.getMetadataWithOffset(Blocks.ladder, EnumFacing.WEST.getIndex())), 9, 2, 3, llllllllIlIIlIl);
                    this.func_175811_a(llllllllIlIIIIl, Blocks.ladder.getStateFromMeta(this.getMetadataWithOffset(Blocks.ladder, EnumFacing.WEST.getIndex())), 9, 3, 3, llllllllIlIIlIl);
                    this.func_180778_a(llllllllIlIIIIl, llllllllIlIIlIl, llllllllIlIIIII, 3, 4, 8, WeightedRandomChestContent.func_177629_a(RoomCrossing.strongholdRoomCrossingChestContents, Items.enchanted_book.getRandomEnchantedBook(llllllllIlIIIII)), 1 + llllllllIlIIIII.nextInt(4));
                    break;
                }
            }
            return true;
        }
    }
    
    public static class Prison extends Stronghold
    {
        public Prison() {
        }
        
        public Prison(final int lllllllllllllllllllllIIlllIlIlll, final Random lllllllllllllllllllllIIlllIlIIIl, final StructureBoundingBox lllllllllllllllllllllIIlllIlIlIl, final EnumFacing lllllllllllllllllllllIIlllIIllll) {
            super(lllllllllllllllllllllIIlllIlIlll);
            this.coordBaseMode = lllllllllllllllllllllIIlllIIllll;
            this.field_143013_d = this.getRandomDoor(lllllllllllllllllllllIIlllIlIIIl);
            this.boundingBox = lllllllllllllllllllllIIlllIlIlIl;
        }
        
        public static Prison func_175860_a(final List lllllllllllllllllllllIIllIlllIlI, final Random lllllllllllllllllllllIIllIllIIIl, final int lllllllllllllllllllllIIllIlllIII, final int lllllllllllllllllllllIIllIlIllll, final int lllllllllllllllllllllIIllIlIlllI, final EnumFacing lllllllllllllllllllllIIllIllIlIl, final int lllllllllllllllllllllIIllIllIlII) {
            final StructureBoundingBox lllllllllllllllllllllIIllIllIIll = StructureBoundingBox.func_175897_a(lllllllllllllllllllllIIllIlllIII, lllllllllllllllllllllIIllIlIllll, lllllllllllllllllllllIIllIlIlllI, -1, -1, 0, 9, 5, 11, lllllllllllllllllllllIIllIllIlIl);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllllllllllIIllIllIIll) && StructureComponent.findIntersecting(lllllllllllllllllllllIIllIlllIlI, lllllllllllllllllllllIIllIllIIll) == null) ? new Prison(lllllllllllllllllllllIIllIllIlII, lllllllllllllllllllllIIllIllIIIl, lllllllllllllllllllllIIllIllIIll, lllllllllllllllllllllIIllIllIlIl) : null;
        }
        
        static {
            __OBFID = "CL_00000494";
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllllllllIIllIlIIlIl, final Random lllllllllllllllllllllIIllIlIIlII, final StructureBoundingBox lllllllllllllllllllllIIllIIlllll) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIIlllll)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIIlllll, 0, 0, 0, 8, 4, 10, true, lllllllllllllllllllllIIllIlIIlII, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIlIIlII, lllllllllllllllllllllIIllIIlllll, this.field_143013_d, 1, 1, 0);
            this.func_175804_a(lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIIlllll, 1, 1, 10, 3, 3, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithRandomizedBlocks(lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIIlllll, 4, 1, 1, 4, 3, 1, false, lllllllllllllllllllllIIllIlIIlII, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIIlllll, 4, 1, 3, 4, 3, 3, false, lllllllllllllllllllllIIllIlIIlII, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIIlllll, 4, 1, 7, 4, 3, 7, false, lllllllllllllllllllllIIllIlIIlII, StructureStrongholdPieces.strongholdStones);
            this.fillWithRandomizedBlocks(lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIIlllll, 4, 1, 9, 4, 3, 9, false, lllllllllllllllllllllIIllIlIIlII, StructureStrongholdPieces.strongholdStones);
            this.func_175804_a(lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIIlllll, 4, 1, 4, 4, 3, 6, Blocks.iron_bars.getDefaultState(), Blocks.iron_bars.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIIlllll, 5, 1, 5, 7, 3, 5, Blocks.iron_bars.getDefaultState(), Blocks.iron_bars.getDefaultState(), false);
            this.func_175811_a(lllllllllllllllllllllIIllIlIIlIl, Blocks.iron_bars.getDefaultState(), 4, 3, 2, lllllllllllllllllllllIIllIIlllll);
            this.func_175811_a(lllllllllllllllllllllIIllIlIIlIl, Blocks.iron_bars.getDefaultState(), 4, 3, 8, lllllllllllllllllllllIIllIIlllll);
            this.func_175811_a(lllllllllllllllllllllIIllIlIIlIl, Blocks.iron_door.getStateFromMeta(this.getMetadataWithOffset(Blocks.iron_door, 3)), 4, 1, 2, lllllllllllllllllllllIIllIIlllll);
            this.func_175811_a(lllllllllllllllllllllIIllIlIIlIl, Blocks.iron_door.getStateFromMeta(this.getMetadataWithOffset(Blocks.iron_door, 3) + 8), 4, 2, 2, lllllllllllllllllllllIIllIIlllll);
            this.func_175811_a(lllllllllllllllllllllIIllIlIIlIl, Blocks.iron_door.getStateFromMeta(this.getMetadataWithOffset(Blocks.iron_door, 3)), 4, 1, 8, lllllllllllllllllllllIIllIIlllll);
            this.func_175811_a(lllllllllllllllllllllIIllIlIIlIl, Blocks.iron_door.getStateFromMeta(this.getMetadataWithOffset(Blocks.iron_door, 3) + 8), 4, 2, 8, lllllllllllllllllllllIIllIIlllll);
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllllllllIIlllIIlIIl, final List lllllllllllllllllllllIIlllIIlIII, final Random lllllllllllllllllllllIIlllIIIIll) {
            this.getNextComponentNormal((Stairs2)lllllllllllllllllllllIIlllIIlIIl, lllllllllllllllllllllIIlllIIlIII, lllllllllllllllllllllIIlllIIIIll, 1, 1);
        }
    }
    
    public static class Library extends Stronghold
    {
        private static final /* synthetic */ List strongholdLibraryChestContents;
        private /* synthetic */ boolean isLargeRoom;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIIlIIlIIIIlllIllIl) {
            super.writeStructureToNBT(llllllllllllllIIlIIlIIIIlllIllIl);
            llllllllllllllIIlIIlIIIIlllIllIl.setBoolean("Tall", this.isLargeRoom);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIIlIIlIIIIlllIIlIl) {
            super.readStructureFromNBT(llllllllllllllIIlIIlIIIIlllIIlIl);
            this.isLargeRoom = llllllllllllllIIlIIlIIIIlllIIlIl.getBoolean("Tall");
        }
        
        public Library(final int llllllllllllllIIlIIlIIIIllllIlII, final Random llllllllllllllIIlIIlIIIIllllIIll, final StructureBoundingBox llllllllllllllIIlIIlIIIIllllIlll, final EnumFacing llllllllllllllIIlIIlIIIIllllIllI) {
            super(llllllllllllllIIlIIlIIIIllllIlII);
            this.coordBaseMode = llllllllllllllIIlIIlIIIIllllIllI;
            this.field_143013_d = this.getRandomDoor(llllllllllllllIIlIIlIIIIllllIIll);
            this.boundingBox = llllllllllllllIIlIIlIIIIllllIlll;
            this.isLargeRoom = (llllllllllllllIIlIIlIIIIllllIlll.getYSize() > 6);
        }
        
        public static Library func_175864_a(final List llllllllllllllIIlIIlIIIIllIlllII, final Random llllllllllllllIIlIIlIIIIllIllIll, final int llllllllllllllIIlIIlIIIIllIllIlI, final int llllllllllllllIIlIIlIIIIllIllIIl, final int llllllllllllllIIlIIlIIIIllIllIII, final EnumFacing llllllllllllllIIlIIlIIIIllIlIlll, final int llllllllllllllIIlIIlIIIIllIlIllI) {
            StructureBoundingBox llllllllllllllIIlIIlIIIIllIlIlIl = StructureBoundingBox.func_175897_a(llllllllllllllIIlIIlIIIIllIllIlI, llllllllllllllIIlIIlIIIIllIllIIl, llllllllllllllIIlIIlIIIIllIllIII, -4, -1, 0, 14, 11, 15, llllllllllllllIIlIIlIIIIllIlIlll);
            if (!Stronghold.canStrongholdGoDeeper(llllllllllllllIIlIIlIIIIllIlIlIl) || StructureComponent.findIntersecting(llllllllllllllIIlIIlIIIIllIlllII, llllllllllllllIIlIIlIIIIllIlIlIl) != null) {
                llllllllllllllIIlIIlIIIIllIlIlIl = StructureBoundingBox.func_175897_a(llllllllllllllIIlIIlIIIIllIllIlI, llllllllllllllIIlIIlIIIIllIllIIl, llllllllllllllIIlIIlIIIIllIllIII, -4, -1, 0, 14, 6, 15, llllllllllllllIIlIIlIIIIllIlIlll);
                if (!Stronghold.canStrongholdGoDeeper(llllllllllllllIIlIIlIIIIllIlIlIl) || StructureComponent.findIntersecting(llllllllllllllIIlIIlIIIIllIlllII, llllllllllllllIIlIIlIIIIllIlIlIl) != null) {
                    return null;
                }
            }
            return new Library(llllllllllllllIIlIIlIIIIllIlIllI, llllllllllllllIIlIIlIIIIllIllIll, llllllllllllllIIlIIlIIIIllIlIlIl, llllllllllllllIIlIIlIIIIllIlIlll);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlIIlIIIIllIIIIIl, final Random llllllllllllllIIlIIlIIIIllIIIIII, final StructureBoundingBox llllllllllllllIIlIIlIIIIlIllIlIl) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl)) {
                return false;
            }
            byte llllllllllllllIIlIIlIIIIlIlllllI = 11;
            if (!this.isLargeRoom) {
                llllllllllllllIIlIIlIIIIlIlllllI = 6;
            }
            this.fillWithRandomizedBlocks(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 0, 0, 0, 13, llllllllllllllIIlIIlIIIIlIlllllI - 1, 14, true, llllllllllllllIIlIIlIIIIllIIIIII, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIllIIIIII, llllllllllllllIIlIIlIIIIlIllIlIl, this.field_143013_d, 4, 1, 0);
            this.func_175805_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, llllllllllllllIIlIIlIIIIllIIIIII, 0.07f, 2, 1, 1, 11, 4, 13, Blocks.web.getDefaultState(), Blocks.web.getDefaultState(), false);
            final boolean llllllllllllllIIlIIlIIIIlIllllIl = true;
            final boolean llllllllllllllIIlIIlIIIIlIllllII = true;
            for (int llllllllllllllIIlIIlIIIIlIlllIll = 1; llllllllllllllIIlIIlIIIIlIlllIll <= 13; ++llllllllllllllIIlIIlIIIIlIlllIll) {
                if ((llllllllllllllIIlIIlIIIIlIlllIll - 1) % 4 == 0) {
                    this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 1, 1, llllllllllllllIIlIIlIIIIlIlllIll, 1, 4, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                    this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 12, 1, llllllllllllllIIlIIlIIIIlIlllIll, 12, 4, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                    this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.torch.getDefaultState(), 2, 3, llllllllllllllIIlIIlIIIIlIlllIll, llllllllllllllIIlIIlIIIIlIllIlIl);
                    this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.torch.getDefaultState(), 11, 3, llllllllllllllIIlIIlIIIIlIlllIll, llllllllllllllIIlIIlIIIIlIllIlIl);
                    if (this.isLargeRoom) {
                        this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 1, 6, llllllllllllllIIlIIlIIIIlIlllIll, 1, 9, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                        this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 12, 6, llllllllllllllIIlIIlIIIIlIlllIll, 12, 9, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                    }
                }
                else {
                    this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 1, 1, llllllllllllllIIlIIlIIIIlIlllIll, 1, 4, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                    this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 12, 1, llllllllllllllIIlIIlIIIIlIlllIll, 12, 4, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                    if (this.isLargeRoom) {
                        this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 1, 6, llllllllllllllIIlIIlIIIIlIlllIll, 1, 9, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                        this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 12, 6, llllllllllllllIIlIIlIIIIlIlllIll, 12, 9, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                    }
                }
            }
            for (int llllllllllllllIIlIIlIIIIlIlllIll = 3; llllllllllllllIIlIIlIIIIlIlllIll < 12; llllllllllllllIIlIIlIIIIlIlllIll += 2) {
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 3, 1, llllllllllllllIIlIIlIIIIlIlllIll, 4, 3, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 6, 1, llllllllllllllIIlIIlIIIIlIlllIll, 7, 3, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 9, 1, llllllllllllllIIlIIlIIIIlIlllIll, 10, 3, llllllllllllllIIlIIlIIIIlIlllIll, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
            }
            if (this.isLargeRoom) {
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 1, 5, 1, 3, 5, 13, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 10, 5, 1, 12, 5, 13, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 4, 5, 1, 9, 5, 2, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 4, 5, 12, 9, 5, 13, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.planks.getDefaultState(), 9, 5, 11, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.planks.getDefaultState(), 8, 5, 11, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.planks.getDefaultState(), 9, 5, 10, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 3, 6, 2, 3, 6, 12, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 10, 6, 2, 10, 6, 10, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 4, 6, 2, 9, 6, 2, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
                this.func_175804_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, 4, 6, 12, 8, 6, 12, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), 9, 6, 11, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), 8, 6, 11, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), 9, 6, 10, llllllllllllllIIlIIlIIIIlIllIlIl);
                final int llllllllllllllIIlIIlIIIIlIlllIll = this.getMetadataWithOffset(Blocks.ladder, 3);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlIIlIIIIlIlllIll), 10, 1, 13, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlIIlIIIIlIlllIll), 10, 2, 13, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlIIlIIIIlIlllIll), 10, 3, 13, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlIIlIIIIlIlllIll), 10, 4, 13, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlIIlIIIIlIlllIll), 10, 5, 13, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlIIlIIIIlIlllIll), 10, 6, 13, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlIIlIIIIlIlllIll), 10, 7, 13, llllllllllllllIIlIIlIIIIlIllIlIl);
                final byte llllllllllllllIIlIIlIIIIlIlllIlI = 7;
                final byte llllllllllllllIIlIIlIIIIlIlllIIl = 7;
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI - 1, 9, llllllllllllllIIlIIlIIIIlIlllIIl, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI, 9, llllllllllllllIIlIIlIIIIlIlllIIl, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI - 1, 8, llllllllllllllIIlIIlIIIIlIlllIIl, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI, 8, llllllllllllllIIlIIlIIIIlIlllIIl, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI - 1, 7, llllllllllllllIIlIIlIIIIlIlllIIl, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI, 7, llllllllllllllIIlIIlIIIIlIlllIIl, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI - 2, 7, llllllllllllllIIlIIlIIIIlIlllIIl, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI + 1, 7, llllllllllllllIIlIIlIIIIlIlllIIl, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI - 1, 7, llllllllllllllIIlIIlIIIIlIlllIIl - 1, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI - 1, 7, llllllllllllllIIlIIlIIIIlIlllIIl + 1, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI, 7, llllllllllllllIIlIIlIIIIlIlllIIl - 1, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.oak_fence.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI, 7, llllllllllllllIIlIIlIIIIlIlllIIl + 1, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.torch.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI - 2, 8, llllllllllllllIIlIIlIIIIlIlllIIl, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.torch.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI + 1, 8, llllllllllllllIIlIIlIIIIlIlllIIl, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.torch.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI - 1, 8, llllllllllllllIIlIIlIIIIlIlllIIl - 1, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.torch.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI - 1, 8, llllllllllllllIIlIIlIIIIlIlllIIl + 1, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.torch.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI, 8, llllllllllllllIIlIIlIIIIlIlllIIl - 1, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.torch.getDefaultState(), llllllllllllllIIlIIlIIIIlIlllIlI, 8, llllllllllllllIIlIIlIIIIlIlllIIl + 1, llllllllllllllIIlIIlIIIIlIllIlIl);
            }
            this.func_180778_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, llllllllllllllIIlIIlIIIIllIIIIII, 3, 3, 5, WeightedRandomChestContent.func_177629_a(Library.strongholdLibraryChestContents, Items.enchanted_book.func_92112_a(llllllllllllllIIlIIlIIIIllIIIIII, 1, 5, 2)), 1 + llllllllllllllIIlIIlIIIIllIIIIII.nextInt(4));
            if (this.isLargeRoom) {
                this.func_175811_a(llllllllllllllIIlIIlIIIIllIIIIIl, Blocks.air.getDefaultState(), 12, 9, 1, llllllllllllllIIlIIlIIIIlIllIlIl);
                this.func_180778_a(llllllllllllllIIlIIlIIIIllIIIIIl, llllllllllllllIIlIIlIIIIlIllIlIl, llllllllllllllIIlIIlIIIIllIIIIII, 12, 8, 1, WeightedRandomChestContent.func_177629_a(Library.strongholdLibraryChestContents, Items.enchanted_book.func_92112_a(llllllllllllllIIlIIlIIIIllIIIIII, 1, 5, 2)), 1 + llllllllllllllIIlIIlIIIIllIIIIII.nextInt(4));
            }
            return true;
        }
        
        public Library() {
        }
        
        static {
            __OBFID = "CL_00000491";
            strongholdLibraryChestContents = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.book, 0, 1, 3, 20), new WeightedRandomChestContent(Items.paper, 0, 2, 7, 20), new WeightedRandomChestContent(Items.map, 0, 1, 1, 1), new WeightedRandomChestContent(Items.compass, 0, 1, 1, 1) });
        }
    }
    
    public static class StairsStraight extends Stronghold
    {
        public StairsStraight(final int llllllllllllllIlIlIlllIlllIIIlll, final Random llllllllllllllIlIlIlllIlllIIIllI, final StructureBoundingBox llllllllllllllIlIlIlllIlllIIIlIl, final EnumFacing llllllllllllllIlIlIlllIlllIIIlII) {
            super(llllllllllllllIlIlIlllIlllIIIlll);
            this.coordBaseMode = llllllllllllllIlIlIlllIlllIIIlII;
            this.field_143013_d = this.getRandomDoor(llllllllllllllIlIlIlllIlllIIIllI);
            this.boundingBox = llllllllllllllIlIlIlllIlllIIIlIl;
        }
        
        public StairsStraight() {
        }
        
        public static StairsStraight func_175861_a(final List llllllllllllllIlIlIlllIllIlIlIlI, final Random llllllllllllllIlIlIlllIllIlIIIIl, final int llllllllllllllIlIlIlllIllIlIIIII, final int llllllllllllllIlIlIlllIllIIlllll, final int llllllllllllllIlIlIlllIllIIllllI, final EnumFacing llllllllllllllIlIlIlllIllIlIIlIl, final int llllllllllllllIlIlIlllIllIIlllII) {
            final StructureBoundingBox llllllllllllllIlIlIlllIllIlIIIll = StructureBoundingBox.func_175897_a(llllllllllllllIlIlIlllIllIlIIIII, llllllllllllllIlIlIlllIllIIlllll, llllllllllllllIlIlIlllIllIIllllI, -1, -7, 0, 5, 11, 8, llllllllllllllIlIlIlllIllIlIIlIl);
            return (Stronghold.canStrongholdGoDeeper(llllllllllllllIlIlIlllIllIlIIIll) && StructureComponent.findIntersecting(llllllllllllllIlIlIlllIllIlIlIlI, llllllllllllllIlIlIlllIllIlIIIll) == null) ? new StairsStraight(llllllllllllllIlIlIlllIllIIlllII, llllllllllllllIlIlIlllIllIlIIIIl, llllllllllllllIlIlIlllIllIlIIIll, llllllllllllllIlIlIlllIllIlIIlIl) : null;
        }
        
        static {
            __OBFID = "CL_00000501";
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIlIlllIllIIIllIl, final Random llllllllllllllIlIlIlllIllIIlIIlI, final StructureBoundingBox llllllllllllllIlIlIlllIllIIIlIll) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllllIlIlIlllIllIIIllIl, llllllllllllllIlIlIlllIllIIIlIll)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllllllllIlIlIlllIllIIIllIl, llllllllllllllIlIlIlllIllIIIlIll, 0, 0, 0, 4, 10, 7, true, llllllllllllllIlIlIlllIllIIlIIlI, StructureStrongholdPieces.strongholdStones);
            this.placeDoor(llllllllllllllIlIlIlllIllIIIllIl, llllllllllllllIlIlIlllIllIIlIIlI, llllllllllllllIlIlIlllIllIIIlIll, this.field_143013_d, 1, 7, 0);
            this.placeDoor(llllllllllllllIlIlIlllIllIIIllIl, llllllllllllllIlIlIlllIllIIlIIlI, llllllllllllllIlIlIlllIllIIIlIll, Door.OPENING, 1, 1, 7);
            final int llllllllllllllIlIlIlllIllIIlIIII = this.getMetadataWithOffset(Blocks.stone_stairs, 2);
            for (int llllllllllllllIlIlIlllIllIIIllll = 0; llllllllllllllIlIlIlllIllIIIllll < 6; ++llllllllllllllIlIlIlllIllIIIllll) {
                this.func_175811_a(llllllllllllllIlIlIlllIllIIIllIl, Blocks.stone_stairs.getStateFromMeta(llllllllllllllIlIlIlllIllIIlIIII), 1, 6 - llllllllllllllIlIlIlllIllIIIllll, 1 + llllllllllllllIlIlIlllIllIIIllll, llllllllllllllIlIlIlllIllIIIlIll);
                this.func_175811_a(llllllllllllllIlIlIlllIllIIIllIl, Blocks.stone_stairs.getStateFromMeta(llllllllllllllIlIlIlllIllIIlIIII), 2, 6 - llllllllllllllIlIlIlllIllIIIllll, 1 + llllllllllllllIlIlIlllIllIIIllll, llllllllllllllIlIlIlllIllIIIlIll);
                this.func_175811_a(llllllllllllllIlIlIlllIllIIIllIl, Blocks.stone_stairs.getStateFromMeta(llllllllllllllIlIlIlllIllIIlIIII), 3, 6 - llllllllllllllIlIlIlllIllIIIllll, 1 + llllllllllllllIlIlIlllIllIIIllll, llllllllllllllIlIlIlllIllIIIlIll);
                if (llllllllllllllIlIlIlllIllIIIllll < 5) {
                    this.func_175811_a(llllllllllllllIlIlIlllIllIIIllIl, Blocks.stonebrick.getDefaultState(), 1, 5 - llllllllllllllIlIlIlllIllIIIllll, 1 + llllllllllllllIlIlIlllIllIIIllll, llllllllllllllIlIlIlllIllIIIlIll);
                    this.func_175811_a(llllllllllllllIlIlIlllIllIIIllIl, Blocks.stonebrick.getDefaultState(), 2, 5 - llllllllllllllIlIlIlllIllIIIllll, 1 + llllllllllllllIlIlIlllIllIIIllll, llllllllllllllIlIlIlllIllIIIlIll);
                    this.func_175811_a(llllllllllllllIlIlIlllIllIIIllIl, Blocks.stonebrick.getDefaultState(), 3, 5 - llllllllllllllIlIlIlllIllIIIllll, 1 + llllllllllllllIlIlIlllIllIIIllll, llllllllllllllIlIlIlllIllIIIlIll);
                }
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIlIlIlllIllIllIlIl, final List llllllllllllllIlIlIlllIllIlllIII, final Random llllllllllllllIlIlIlllIllIllIlll) {
            this.getNextComponentNormal((Stairs2)llllllllllllllIlIlIlllIllIllIlIl, llllllllllllllIlIlIlllIllIlllIII, llllllllllllllIlIlIlllIllIllIlll, 1, 1);
        }
    }
}
