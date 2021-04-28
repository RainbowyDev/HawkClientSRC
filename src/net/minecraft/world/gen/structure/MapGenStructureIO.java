package net.minecraft.world.gen.structure;

import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;

public class MapGenStructureIO
{
    private static /* synthetic */ Map field_143038_b;
    private static /* synthetic */ Map field_143037_d;
    private static /* synthetic */ Map field_143040_a;
    private static final /* synthetic */ Logger logger;
    private static /* synthetic */ Map field_143039_c;
    
    static void registerStructureComponent(final Class llllllllllllllIlIIIIllIIIIIllIlI, final String llllllllllllllIlIIIIllIIIIIllIIl) {
        MapGenStructureIO.field_143039_c.put(llllllllllllllIlIIIIllIIIIIllIIl, llllllllllllllIlIIIIllIIIIIllIlI);
        MapGenStructureIO.field_143037_d.put(llllllllllllllIlIIIIllIIIIIllIlI, llllllllllllllIlIIIIllIIIIIllIIl);
    }
    
    public static StructureStart func_143035_a(final NBTTagCompound llllllllllllllIlIIIIllIIIIIIIlll, final World llllllllllllllIlIIIIllIIIIIIlIll) {
        StructureStart llllllllllllllIlIIIIllIIIIIIlIlI = null;
        try {
            final Class llllllllllllllIlIIIIllIIIIIIlIIl = MapGenStructureIO.field_143040_a.get(llllllllllllllIlIIIIllIIIIIIIlll.getString("id"));
            if (llllllllllllllIlIIIIllIIIIIIlIIl != null) {
                llllllllllllllIlIIIIllIIIIIIlIlI = llllllllllllllIlIIIIllIIIIIIlIIl.newInstance();
            }
        }
        catch (Exception llllllllllllllIlIIIIllIIIIIIlIII) {
            MapGenStructureIO.logger.warn(String.valueOf(new StringBuilder("Failed Start with id ").append(llllllllllllllIlIIIIllIIIIIIIlll.getString("id"))));
            llllllllllllllIlIIIIllIIIIIIlIII.printStackTrace();
        }
        if (llllllllllllllIlIIIIllIIIIIIlIlI != null) {
            llllllllllllllIlIIIIllIIIIIIlIlI.func_143020_a(llllllllllllllIlIIIIllIIIIIIlIll, llllllllllllllIlIIIIllIIIIIIIlll);
        }
        else {
            MapGenStructureIO.logger.warn(String.valueOf(new StringBuilder("Skipping Structure with id ").append(llllllllllllllIlIIIIllIIIIIIIlll.getString("id"))));
        }
        return llllllllllllllIlIIIIllIIIIIIlIlI;
    }
    
    private static void registerStructure(final Class llllllllllllllIlIIIIllIIIIIllllI, final String llllllllllllllIlIIIIllIIIIIlllll) {
        MapGenStructureIO.field_143040_a.put(llllllllllllllIlIIIIllIIIIIlllll, llllllllllllllIlIIIIllIIIIIllllI);
        MapGenStructureIO.field_143038_b.put(llllllllllllllIlIIIIllIIIIIllllI, llllllllllllllIlIIIIllIIIIIlllll);
    }
    
    public static String func_143036_a(final StructureComponent llllllllllllllIlIIIIllIIIIIlIIlI) {
        return MapGenStructureIO.field_143037_d.get(llllllllllllllIlIIIIllIIIIIlIIlI.getClass());
    }
    
    public static StructureComponent func_143032_b(final NBTTagCompound llllllllllllllIlIIIIlIlllllllIlI, final World llllllllllllllIlIIIIlIlllllllIIl) {
        StructureComponent llllllllllllllIlIIIIlIllllllllIl = null;
        try {
            final Class llllllllllllllIlIIIIlIllllllllII = MapGenStructureIO.field_143039_c.get(llllllllllllllIlIIIIlIlllllllIlI.getString("id"));
            if (llllllllllllllIlIIIIlIllllllllII != null) {
                llllllllllllllIlIIIIlIllllllllIl = llllllllllllllIlIIIIlIllllllllII.newInstance();
            }
        }
        catch (Exception llllllllllllllIlIIIIlIlllllllIll) {
            MapGenStructureIO.logger.warn(String.valueOf(new StringBuilder("Failed Piece with id ").append(llllllllllllllIlIIIIlIlllllllIlI.getString("id"))));
            llllllllllllllIlIIIIlIlllllllIll.printStackTrace();
        }
        if (llllllllllllllIlIIIIlIllllllllIl != null) {
            llllllllllllllIlIIIIlIllllllllIl.func_143009_a(llllllllllllllIlIIIIlIlllllllIIl, llllllllllllllIlIIIIlIlllllllIlI);
        }
        else {
            MapGenStructureIO.logger.warn(String.valueOf(new StringBuilder("Skipping Piece with id ").append(llllllllllllllIlIIIIlIlllllllIlI.getString("id"))));
        }
        return llllllllllllllIlIIIIlIllllllllIl;
    }
    
    static {
        __OBFID = "CL_00000509";
        logger = LogManager.getLogger();
        MapGenStructureIO.field_143040_a = Maps.newHashMap();
        MapGenStructureIO.field_143038_b = Maps.newHashMap();
        MapGenStructureIO.field_143039_c = Maps.newHashMap();
        MapGenStructureIO.field_143037_d = Maps.newHashMap();
        registerStructure(StructureMineshaftStart.class, "Mineshaft");
        registerStructure(MapGenVillage.Start.class, "Village");
        registerStructure(MapGenNetherBridge.Start.class, "Fortress");
        registerStructure(MapGenStronghold.Start.class, "Stronghold");
        registerStructure(MapGenScatteredFeature.Start.class, "Temple");
        registerStructure(StructureOceanMonument.StartMonument.class, "Monument");
        StructureMineshaftPieces.registerStructurePieces();
        StructureVillagePieces.registerVillagePieces();
        StructureNetherBridgePieces.registerNetherFortressPieces();
        StructureStrongholdPieces.registerStrongholdPieces();
        ComponentScatteredFeaturePieces.registerScatteredFeaturePieces();
        StructureOceanMonumentPieces.func_175970_a();
    }
    
    public static String func_143033_a(final StructureStart llllllllllllllIlIIIIllIIIIIlIlIl) {
        return MapGenStructureIO.field_143038_b.get(llllllllllllllIlIIIIllIIIIIlIlIl.getClass());
    }
}
