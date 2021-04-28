package net.minecraft.world.gen.structure;

import com.google.common.collect.*;
import java.util.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class StructureVillagePieces
{
    static {
        __OBFID = "CL_00000516";
    }
    
    private static StructureComponent func_176066_d(final Start llllllllllllllIlIlIIllllllllllIl, final List llllllllllllllIlIlIlIIIIIIIIlIlI, final Random llllllllllllllIlIlIlIIIIIIIIlIIl, final int llllllllllllllIlIlIlIIIIIIIIlIII, final int llllllllllllllIlIlIIlllllllllIIl, final int llllllllllllllIlIlIIlllllllllIII, final EnumFacing llllllllllllllIlIlIlIIIIIIIIIlIl, final int llllllllllllllIlIlIlIIIIIIIIIlII) {
        if (llllllllllllllIlIlIlIIIIIIIIIlII > 50) {
            return null;
        }
        if (Math.abs(llllllllllllllIlIlIlIIIIIIIIlIII - llllllllllllllIlIlIIllllllllllIl.getBoundingBox().minX) <= 112 && Math.abs(llllllllllllllIlIlIIlllllllllIII - llllllllllllllIlIlIIllllllllllIl.getBoundingBox().minZ) <= 112) {
            final Village llllllllllllllIlIlIlIIIIIIIIIIll = func_176067_c(llllllllllllllIlIlIIllllllllllIl, llllllllllllllIlIlIlIIIIIIIIlIlI, llllllllllllllIlIlIlIIIIIIIIlIIl, llllllllllllllIlIlIlIIIIIIIIlIII, llllllllllllllIlIlIIlllllllllIIl, llllllllllllllIlIlIIlllllllllIII, llllllllllllllIlIlIlIIIIIIIIIlIl, llllllllllllllIlIlIlIIIIIIIIIlII + 1);
            if (llllllllllllllIlIlIlIIIIIIIIIIll != null) {
                final int llllllllllllllIlIlIlIIIIIIIIIIlI = (llllllllllllllIlIlIlIIIIIIIIIIll.boundingBox.minX + llllllllllllllIlIlIlIIIIIIIIIIll.boundingBox.maxX) / 2;
                final int llllllllllllllIlIlIlIIIIIIIIIIIl = (llllllllllllllIlIlIlIIIIIIIIIIll.boundingBox.minZ + llllllllllllllIlIlIlIIIIIIIIIIll.boundingBox.maxZ) / 2;
                final int llllllllllllllIlIlIlIIIIIIIIIIII = llllllllllllllIlIlIlIIIIIIIIIIll.boundingBox.maxX - llllllllllllllIlIlIlIIIIIIIIIIll.boundingBox.minX;
                final int llllllllllllllIlIlIIllllllllllll = llllllllllllllIlIlIlIIIIIIIIIIll.boundingBox.maxZ - llllllllllllllIlIlIlIIIIIIIIIIll.boundingBox.minZ;
                final int llllllllllllllIlIlIIlllllllllllI = (llllllllllllllIlIlIlIIIIIIIIIIII > llllllllllllllIlIlIIllllllllllll) ? llllllllllllllIlIlIlIIIIIIIIIIII : llllllllllllllIlIlIIllllllllllll;
                if (llllllllllllllIlIlIIllllllllllIl.getWorldChunkManager().areBiomesViable(llllllllllllllIlIlIlIIIIIIIIIIlI, llllllllllllllIlIlIlIIIIIIIIIIIl, llllllllllllllIlIlIIlllllllllllI / 2 + 4, MapGenVillage.villageSpawnBiomes)) {
                    llllllllllllllIlIlIlIIIIIIIIlIlI.add(llllllllllllllIlIlIlIIIIIIIIIIll);
                    llllllllllllllIlIlIIllllllllllIl.field_74932_i.add(llllllllllllllIlIlIlIIIIIIIIIIll);
                    return llllllllllllllIlIlIlIIIIIIIIIIll;
                }
            }
            return null;
        }
        return null;
    }
    
    private static Village func_176065_a(final Start llllllllllllllIlIlIlIIIIIlIllIlI, final PieceWeight llllllllllllllIlIlIlIIIIIlIllIIl, final List llllllllllllllIlIlIlIIIIIlIllIII, final Random llllllllllllllIlIlIlIIIIIlIlIlll, final int llllllllllllllIlIlIlIIIIIlIlIllI, final int llllllllllllllIlIlIlIIIIIlIIlIlI, final int llllllllllllllIlIlIlIIIIIlIlIlII, final EnumFacing llllllllllllllIlIlIlIIIIIlIIlIII, final int llllllllllllllIlIlIlIIIIIlIIIlll) {
        final Class llllllllllllllIlIlIlIIIIIlIlIIIl = llllllllllllllIlIlIlIIIIIlIllIIl.villagePieceClass;
        Object llllllllllllllIlIlIlIIIIIlIlIIII = null;
        if (llllllllllllllIlIlIlIIIIIlIlIIIl == House4Garden.class) {
            llllllllllllllIlIlIlIIIIIlIlIIII = House4Garden.func_175858_a(llllllllllllllIlIlIlIIIIIlIllIlI, llllllllllllllIlIlIlIIIIIlIllIII, llllllllllllllIlIlIlIIIIIlIlIlll, llllllllllllllIlIlIlIIIIIlIlIllI, llllllllllllllIlIlIlIIIIIlIIlIlI, llllllllllllllIlIlIlIIIIIlIlIlII, llllllllllllllIlIlIlIIIIIlIIlIII, llllllllllllllIlIlIlIIIIIlIIIlll);
        }
        else if (llllllllllllllIlIlIlIIIIIlIlIIIl == Church.class) {
            llllllllllllllIlIlIlIIIIIlIlIIII = Church.func_175854_a(llllllllllllllIlIlIlIIIIIlIllIlI, llllllllllllllIlIlIlIIIIIlIllIII, llllllllllllllIlIlIlIIIIIlIlIlll, llllllllllllllIlIlIlIIIIIlIlIllI, llllllllllllllIlIlIlIIIIIlIIlIlI, llllllllllllllIlIlIlIIIIIlIlIlII, llllllllllllllIlIlIlIIIIIlIIlIII, llllllllllllllIlIlIlIIIIIlIIIlll);
        }
        else if (llllllllllllllIlIlIlIIIIIlIlIIIl == House1.class) {
            llllllllllllllIlIlIlIIIIIlIlIIII = House1.func_175850_a(llllllllllllllIlIlIlIIIIIlIllIlI, llllllllllllllIlIlIlIIIIIlIllIII, llllllllllllllIlIlIlIIIIIlIlIlll, llllllllllllllIlIlIlIIIIIlIlIllI, llllllllllllllIlIlIlIIIIIlIIlIlI, llllllllllllllIlIlIlIIIIIlIlIlII, llllllllllllllIlIlIlIIIIIlIIlIII, llllllllllllllIlIlIlIIIIIlIIIlll);
        }
        else if (llllllllllllllIlIlIlIIIIIlIlIIIl == WoodHut.class) {
            llllllllllllllIlIlIlIIIIIlIlIIII = WoodHut.func_175853_a(llllllllllllllIlIlIlIIIIIlIllIlI, llllllllllllllIlIlIlIIIIIlIllIII, llllllllllllllIlIlIlIIIIIlIlIlll, llllllllllllllIlIlIlIIIIIlIlIllI, llllllllllllllIlIlIlIIIIIlIIlIlI, llllllllllllllIlIlIlIIIIIlIlIlII, llllllllllllllIlIlIlIIIIIlIIlIII, llllllllllllllIlIlIlIIIIIlIIIlll);
        }
        else if (llllllllllllllIlIlIlIIIIIlIlIIIl == Hall.class) {
            llllllllllllllIlIlIlIIIIIlIlIIII = Hall.func_175857_a(llllllllllllllIlIlIlIIIIIlIllIlI, llllllllllllllIlIlIlIIIIIlIllIII, llllllllllllllIlIlIlIIIIIlIlIlll, llllllllllllllIlIlIlIIIIIlIlIllI, llllllllllllllIlIlIlIIIIIlIIlIlI, llllllllllllllIlIlIlIIIIIlIlIlII, llllllllllllllIlIlIlIIIIIlIIlIII, llllllllllllllIlIlIlIIIIIlIIIlll);
        }
        else if (llllllllllllllIlIlIlIIIIIlIlIIIl == Field1.class) {
            llllllllllllllIlIlIlIIIIIlIlIIII = Field1.func_175851_a(llllllllllllllIlIlIlIIIIIlIllIlI, llllllllllllllIlIlIlIIIIIlIllIII, llllllllllllllIlIlIlIIIIIlIlIlll, llllllllllllllIlIlIlIIIIIlIlIllI, llllllllllllllIlIlIlIIIIIlIIlIlI, llllllllllllllIlIlIlIIIIIlIlIlII, llllllllllllllIlIlIlIIIIIlIIlIII, llllllllllllllIlIlIlIIIIIlIIIlll);
        }
        else if (llllllllllllllIlIlIlIIIIIlIlIIIl == Field2.class) {
            llllllllllllllIlIlIlIIIIIlIlIIII = Field2.func_175852_a(llllllllllllllIlIlIlIIIIIlIllIlI, llllllllllllllIlIlIlIIIIIlIllIII, llllllllllllllIlIlIlIIIIIlIlIlll, llllllllllllllIlIlIlIIIIIlIlIllI, llllllllllllllIlIlIlIIIIIlIIlIlI, llllllllllllllIlIlIlIIIIIlIlIlII, llllllllllllllIlIlIlIIIIIlIIlIII, llllllllllllllIlIlIlIIIIIlIIIlll);
        }
        else if (llllllllllllllIlIlIlIIIIIlIlIIIl == House2.class) {
            llllllllllllllIlIlIlIIIIIlIlIIII = House2.func_175855_a(llllllllllllllIlIlIlIIIIIlIllIlI, llllllllllllllIlIlIlIIIIIlIllIII, llllllllllllllIlIlIlIIIIIlIlIlll, llllllllllllllIlIlIlIIIIIlIlIllI, llllllllllllllIlIlIlIIIIIlIIlIlI, llllllllllllllIlIlIlIIIIIlIlIlII, llllllllllllllIlIlIlIIIIIlIIlIII, llllllllllllllIlIlIlIIIIIlIIIlll);
        }
        else if (llllllllllllllIlIlIlIIIIIlIlIIIl == House3.class) {
            llllllllllllllIlIlIlIIIIIlIlIIII = House3.func_175849_a(llllllllllllllIlIlIlIIIIIlIllIlI, llllllllllllllIlIlIlIIIIIlIllIII, llllllllllllllIlIlIlIIIIIlIlIlll, llllllllllllllIlIlIlIIIIIlIlIllI, llllllllllllllIlIlIlIIIIIlIIlIlI, llllllllllllllIlIlIlIIIIIlIlIlII, llllllllllllllIlIlIlIIIIIlIIlIII, llllllllllllllIlIlIlIIIIIlIIIlll);
        }
        return (Village)llllllllllllllIlIlIlIIIIIlIlIIII;
    }
    
    public static void registerVillagePieces() {
        MapGenStructureIO.registerStructureComponent(House1.class, "ViBH");
        MapGenStructureIO.registerStructureComponent(Field1.class, "ViDF");
        MapGenStructureIO.registerStructureComponent(Field2.class, "ViF");
        MapGenStructureIO.registerStructureComponent(Torch.class, "ViL");
        MapGenStructureIO.registerStructureComponent(Hall.class, "ViPH");
        MapGenStructureIO.registerStructureComponent(House4Garden.class, "ViSH");
        MapGenStructureIO.registerStructureComponent(WoodHut.class, "ViSmH");
        MapGenStructureIO.registerStructureComponent(Church.class, "ViST");
        MapGenStructureIO.registerStructureComponent(House2.class, "ViS");
        MapGenStructureIO.registerStructureComponent(Start.class, "ViStart");
        MapGenStructureIO.registerStructureComponent(Path.class, "ViSR");
        MapGenStructureIO.registerStructureComponent(House3.class, "ViTRH");
        MapGenStructureIO.registerStructureComponent(Well.class, "ViW");
    }
    
    public static List getStructureVillageWeightedPieceList(final Random llllllllllllllIlIlIlIIIIIllllIII, final int llllllllllllllIlIlIlIIIIIlllIlll) {
        final ArrayList llllllllllllllIlIlIlIIIIIllllIlI = Lists.newArrayList();
        llllllllllllllIlIlIlIIIIIllllIlI.add(new PieceWeight(House4Garden.class, 4, MathHelper.getRandomIntegerInRange(llllllllllllllIlIlIlIIIIIllllIII, 2 + llllllllllllllIlIlIlIIIIIlllIlll, 4 + llllllllllllllIlIlIlIIIIIlllIlll * 2)));
        llllllllllllllIlIlIlIIIIIllllIlI.add(new PieceWeight(Church.class, 20, MathHelper.getRandomIntegerInRange(llllllllllllllIlIlIlIIIIIllllIII, 0 + llllllllllllllIlIlIlIIIIIlllIlll, 1 + llllllllllllllIlIlIlIIIIIlllIlll)));
        llllllllllllllIlIlIlIIIIIllllIlI.add(new PieceWeight(House1.class, 20, MathHelper.getRandomIntegerInRange(llllllllllllllIlIlIlIIIIIllllIII, 0 + llllllllllllllIlIlIlIIIIIlllIlll, 2 + llllllllllllllIlIlIlIIIIIlllIlll)));
        llllllllllllllIlIlIlIIIIIllllIlI.add(new PieceWeight(WoodHut.class, 3, MathHelper.getRandomIntegerInRange(llllllllllllllIlIlIlIIIIIllllIII, 2 + llllllllllllllIlIlIlIIIIIlllIlll, 5 + llllllllllllllIlIlIlIIIIIlllIlll * 3)));
        llllllllllllllIlIlIlIIIIIllllIlI.add(new PieceWeight(Hall.class, 15, MathHelper.getRandomIntegerInRange(llllllllllllllIlIlIlIIIIIllllIII, 0 + llllllllllllllIlIlIlIIIIIlllIlll, 2 + llllllllllllllIlIlIlIIIIIlllIlll)));
        llllllllllllllIlIlIlIIIIIllllIlI.add(new PieceWeight(Field1.class, 3, MathHelper.getRandomIntegerInRange(llllllllllllllIlIlIlIIIIIllllIII, 1 + llllllllllllllIlIlIlIIIIIlllIlll, 4 + llllllllllllllIlIlIlIIIIIlllIlll)));
        llllllllllllllIlIlIlIIIIIllllIlI.add(new PieceWeight(Field2.class, 3, MathHelper.getRandomIntegerInRange(llllllllllllllIlIlIlIIIIIllllIII, 2 + llllllllllllllIlIlIlIIIIIlllIlll, 4 + llllllllllllllIlIlIlIIIIIlllIlll * 2)));
        llllllllllllllIlIlIlIIIIIllllIlI.add(new PieceWeight(House2.class, 15, MathHelper.getRandomIntegerInRange(llllllllllllllIlIlIlIIIIIllllIII, 0, 1 + llllllllllllllIlIlIlIIIIIlllIlll)));
        llllllllllllllIlIlIlIIIIIllllIlI.add(new PieceWeight(House3.class, 8, MathHelper.getRandomIntegerInRange(llllllllllllllIlIlIlIIIIIllllIII, 0 + llllllllllllllIlIlIlIIIIIlllIlll, 3 + llllllllllllllIlIlIlIIIIIlllIlll * 2)));
        final Iterator llllllllllllllIlIlIlIIIIIllllIIl = llllllllllllllIlIlIlIIIIIllllIlI.iterator();
        while (llllllllllllllIlIlIlIIIIIllllIIl.hasNext()) {
            if (llllllllllllllIlIlIlIIIIIllllIIl.next().villagePiecesLimit == 0) {
                llllllllllllllIlIlIlIIIIIllllIIl.remove();
            }
        }
        return llllllllllllllIlIlIlIIIIIllllIlI;
    }
    
    private static Village func_176067_c(final Start llllllllllllllIlIlIlIIIIIIlIIlll, final List llllllllllllllIlIlIlIIIIIIlIIllI, final Random llllllllllllllIlIlIlIIIIIIlIIlIl, final int llllllllllllllIlIlIlIIIIIIlIIlII, final int llllllllllllllIlIlIlIIIIIIllIIlI, final int llllllllllllllIlIlIlIIIIIIlIIIlI, final EnumFacing llllllllllllllIlIlIlIIIIIIlIIIIl, final int llllllllllllllIlIlIlIIIIIIlIllll) {
        final int llllllllllllllIlIlIlIIIIIIlIlllI = func_75079_a(llllllllllllllIlIlIlIIIIIIlIIlll.structureVillageWeightedPieceList);
        if (llllllllllllllIlIlIlIIIIIIlIlllI <= 0) {
            return null;
        }
        int llllllllllllllIlIlIlIIIIIIlIllIl = 0;
        while (llllllllllllllIlIlIlIIIIIIlIllIl < 5) {
            ++llllllllllllllIlIlIlIIIIIIlIllIl;
            int llllllllllllllIlIlIlIIIIIIlIllII = llllllllllllllIlIlIlIIIIIIlIIlIl.nextInt(llllllllllllllIlIlIlIIIIIIlIlllI);
            for (final PieceWeight llllllllllllllIlIlIlIIIIIIlIlIlI : llllllllllllllIlIlIlIIIIIIlIIlll.structureVillageWeightedPieceList) {
                llllllllllllllIlIlIlIIIIIIlIllII -= llllllllllllllIlIlIlIIIIIIlIlIlI.villagePieceWeight;
                if (llllllllllllllIlIlIlIIIIIIlIllII < 0) {
                    if (!llllllllllllllIlIlIlIIIIIIlIlIlI.canSpawnMoreVillagePiecesOfType(llllllllllllllIlIlIlIIIIIIlIllll)) {
                        break;
                    }
                    if (llllllllllllllIlIlIlIIIIIIlIlIlI == llllllllllllllIlIlIlIIIIIIlIIlll.structVillagePieceWeight && llllllllllllllIlIlIlIIIIIIlIIlll.structureVillageWeightedPieceList.size() > 1) {
                        break;
                    }
                    final Village llllllllllllllIlIlIlIIIIIIlIlIIl = func_176065_a(llllllllllllllIlIlIlIIIIIIlIIlll, llllllllllllllIlIlIlIIIIIIlIlIlI, llllllllllllllIlIlIlIIIIIIlIIllI, llllllllllllllIlIlIlIIIIIIlIIlIl, llllllllllllllIlIlIlIIIIIIlIIlII, llllllllllllllIlIlIlIIIIIIllIIlI, llllllllllllllIlIlIlIIIIIIlIIIlI, llllllllllllllIlIlIlIIIIIIlIIIIl, llllllllllllllIlIlIlIIIIIIlIllll);
                    if (llllllllllllllIlIlIlIIIIIIlIlIIl != null) {
                        final PieceWeight pieceWeight = llllllllllllllIlIlIlIIIIIIlIlIlI;
                        ++pieceWeight.villagePiecesSpawned;
                        llllllllllllllIlIlIlIIIIIIlIIlll.structVillagePieceWeight = llllllllllllllIlIlIlIIIIIIlIlIlI;
                        if (!llllllllllllllIlIlIlIIIIIIlIlIlI.canSpawnMoreVillagePieces()) {
                            llllllllllllllIlIlIlIIIIIIlIIlll.structureVillageWeightedPieceList.remove(llllllllllllllIlIlIlIIIIIIlIlIlI);
                        }
                        return llllllllllllllIlIlIlIIIIIIlIlIIl;
                    }
                    continue;
                }
            }
        }
        final StructureBoundingBox llllllllllllllIlIlIlIIIIIIlIlIII = Torch.func_175856_a(llllllllllllllIlIlIlIIIIIIlIIlll, llllllllllllllIlIlIlIIIIIIlIIllI, llllllllllllllIlIlIlIIIIIIlIIlIl, llllllllllllllIlIlIlIIIIIIlIIlII, llllllllllllllIlIlIlIIIIIIllIIlI, llllllllllllllIlIlIlIIIIIIlIIIlI, llllllllllllllIlIlIlIIIIIIlIIIIl);
        if (llllllllllllllIlIlIlIIIIIIlIlIII != null) {
            return new Torch(llllllllllllllIlIlIlIIIIIIlIIlll, llllllllllllllIlIlIlIIIIIIlIllll, llllllllllllllIlIlIlIIIIIIlIIlIl, llllllllllllllIlIlIlIIIIIIlIlIII, llllllllllllllIlIlIlIIIIIIlIIIIl);
        }
        return null;
    }
    
    private static StructureComponent func_176069_e(final Start llllllllllllllIlIlIIlllllllIIIII, final List llllllllllllllIlIlIIllllllIlllll, final Random llllllllllllllIlIlIIllllllIIllll, final int llllllllllllllIlIlIIllllllIIlllI, final int llllllllllllllIlIlIIllllllIlllII, final int llllllllllllllIlIlIIllllllIllIll, final EnumFacing llllllllllllllIlIlIIllllllIIlIll, final int llllllllllllllIlIlIIllllllIllIIl) {
        if (llllllllllllllIlIlIIllllllIllIIl > 3 + llllllllllllllIlIlIIlllllllIIIII.terrainType) {
            return null;
        }
        if (Math.abs(llllllllllllllIlIlIIllllllIIlllI - llllllllllllllIlIlIIlllllllIIIII.getBoundingBox().minX) <= 112 && Math.abs(llllllllllllllIlIlIIllllllIllIll - llllllllllllllIlIlIIlllllllIIIII.getBoundingBox().minZ) <= 112) {
            final StructureBoundingBox llllllllllllllIlIlIIllllllIllIII = Path.func_175848_a(llllllllllllllIlIlIIlllllllIIIII, llllllllllllllIlIlIIllllllIlllll, llllllllllllllIlIlIIllllllIIllll, llllllllllllllIlIlIIllllllIIlllI, llllllllllllllIlIlIIllllllIlllII, llllllllllllllIlIlIIllllllIllIll, llllllllllllllIlIlIIllllllIIlIll);
            if (llllllllllllllIlIlIIllllllIllIII != null && llllllllllllllIlIlIIllllllIllIII.minY > 10) {
                final Path llllllllllllllIlIlIIllllllIlIlll = new Path(llllllllllllllIlIlIIlllllllIIIII, llllllllllllllIlIlIIllllllIllIIl, llllllllllllllIlIlIIllllllIIllll, llllllllllllllIlIlIIllllllIllIII, llllllllllllllIlIlIIllllllIIlIll);
                final int llllllllllllllIlIlIIllllllIlIllI = (llllllllllllllIlIlIIllllllIlIlll.boundingBox.minX + llllllllllllllIlIlIIllllllIlIlll.boundingBox.maxX) / 2;
                final int llllllllllllllIlIlIIllllllIlIlIl = (llllllllllllllIlIlIIllllllIlIlll.boundingBox.minZ + llllllllllllllIlIlIIllllllIlIlll.boundingBox.maxZ) / 2;
                final int llllllllllllllIlIlIIllllllIlIlII = llllllllllllllIlIlIIllllllIlIlll.boundingBox.maxX - llllllllllllllIlIlIIllllllIlIlll.boundingBox.minX;
                final int llllllllllllllIlIlIIllllllIlIIll = llllllllllllllIlIlIIllllllIlIlll.boundingBox.maxZ - llllllllllllllIlIlIIllllllIlIlll.boundingBox.minZ;
                final int llllllllllllllIlIlIIllllllIlIIlI = (llllllllllllllIlIlIIllllllIlIlII > llllllllllllllIlIlIIllllllIlIIll) ? llllllllllllllIlIlIIllllllIlIlII : llllllllllllllIlIlIIllllllIlIIll;
                if (llllllllllllllIlIlIIlllllllIIIII.getWorldChunkManager().areBiomesViable(llllllllllllllIlIlIIllllllIlIllI, llllllllllllllIlIlIIllllllIlIlIl, llllllllllllllIlIlIIllllllIlIIlI / 2 + 4, MapGenVillage.villageSpawnBiomes)) {
                    llllllllllllllIlIlIIllllllIlllll.add(llllllllllllllIlIlIIllllllIlIlll);
                    llllllllllllllIlIlIIlllllllIIIII.field_74930_j.add(llllllllllllllIlIlIIllllllIlIlll);
                    return llllllllllllllIlIlIIllllllIlIlll;
                }
            }
            return null;
        }
        return null;
    }
    
    private static int func_75079_a(final List llllllllllllllIlIlIlIIIIIllIlIlI) {
        boolean llllllllllllllIlIlIlIIIIIllIlllI = false;
        int llllllllllllllIlIlIlIIIIIllIllIl = 0;
        for (final PieceWeight llllllllllllllIlIlIlIIIIIllIllII : llllllllllllllIlIlIlIIIIIllIlIlI) {
            if (llllllllllllllIlIlIlIIIIIllIllII.villagePiecesLimit > 0 && llllllllllllllIlIlIlIIIIIllIllII.villagePiecesSpawned < llllllllllllllIlIlIlIIIIIllIllII.villagePiecesLimit) {
                llllllllllllllIlIlIlIIIIIllIlllI = true;
            }
            llllllllllllllIlIlIlIIIIIllIllIl += llllllllllllllIlIlIlIIIIIllIllII.villagePieceWeight;
        }
        return llllllllllllllIlIlIlIIIIIllIlllI ? llllllllllllllIlIlIlIIIIIllIllIl : -1;
    }
    
    public abstract static class Road extends Village
    {
        public Road() {
        }
        
        protected Road(final Start lllllllllllllIlllllllIllIIlIllIl, final int lllllllllllllIlllllllIllIIlIllII) {
            super(lllllllllllllIlllllllIllIIlIllIl, lllllllllllllIlllllllIllIIlIllII);
        }
        
        static {
            __OBFID = "CL_00000532";
        }
    }
    
    public static class Start extends Well
    {
        public /* synthetic */ WorldChunkManager worldChunkMngr;
        public /* synthetic */ int terrainType;
        public /* synthetic */ PieceWeight structVillagePieceWeight;
        public /* synthetic */ List structureVillageWeightedPieceList;
        public /* synthetic */ List field_74930_j;
        public /* synthetic */ List field_74932_i;
        public /* synthetic */ boolean inDesert;
        
        static {
            __OBFID = "CL_00000527";
        }
        
        public WorldChunkManager getWorldChunkManager() {
            return this.worldChunkMngr;
        }
        
        public Start() {
            this.field_74932_i = Lists.newArrayList();
            this.field_74930_j = Lists.newArrayList();
        }
        
        public Start(final WorldChunkManager llllllllllllllIlIllIIIIIllIlIlIl, final int llllllllllllllIlIllIIIIIllIlllIl, final Random llllllllllllllIlIllIIIIIllIlIlII, final int llllllllllllllIlIllIIIIIllIlIIll, final int llllllllllllllIlIllIIIIIllIllIlI, final List llllllllllllllIlIllIIIIIllIllIIl, final int llllllllllllllIlIllIIIIIllIlIIII) {
            super(null, 0, llllllllllllllIlIllIIIIIllIlIlII, llllllllllllllIlIllIIIIIllIlIIll, llllllllllllllIlIllIIIIIllIllIlI);
            this.field_74932_i = Lists.newArrayList();
            this.field_74930_j = Lists.newArrayList();
            this.worldChunkMngr = llllllllllllllIlIllIIIIIllIlIlIl;
            this.structureVillageWeightedPieceList = llllllllllllllIlIllIIIIIllIllIIl;
            this.terrainType = llllllllllllllIlIllIIIIIllIlIIII;
            final BiomeGenBase llllllllllllllIlIllIIIIIllIlIlll = llllllllllllllIlIllIIIIIllIlIlIl.func_180300_a(new BlockPos(llllllllllllllIlIllIIIIIllIlIIll, 0, llllllllllllllIlIllIIIIIllIllIlI), BiomeGenBase.field_180279_ad);
            this.inDesert = (llllllllllllllIlIllIIIIIllIlIlll == BiomeGenBase.desert || llllllllllllllIlIllIIIIIllIlIlll == BiomeGenBase.desertHills);
            this.func_175846_a(this.inDesert);
        }
    }
    
    public static class Well extends Village
    {
        public Well() {
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIIIIIIllIlIIIlllII, final List llllllllllllllIIIIIIllIlIIIllIll, final Random llllllllllllllIIIIIIllIlIIIllIlI) {
            func_176069_e((Start)llllllllllllllIIIIIIllIlIIIlllII, llllllllllllllIIIIIIllIlIIIllIll, llllllllllllllIIIIIIllIlIIIllIlI, this.boundingBox.minX - 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, EnumFacing.WEST, this.getComponentType());
            func_176069_e((Start)llllllllllllllIIIIIIllIlIIIlllII, llllllllllllllIIIIIIllIlIIIllIll, llllllllllllllIIIIIIllIlIIIllIlI, this.boundingBox.maxX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, EnumFacing.EAST, this.getComponentType());
            func_176069_e((Start)llllllllllllllIIIIIIllIlIIIlllII, llllllllllllllIIIIIIllIlIIIllIll, llllllllllllllIIIIIIllIlIIIllIlI, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
            func_176069_e((Start)llllllllllllllIIIIIIllIlIIIlllII, llllllllllllllIIIIIIllIlIIIllIll, llllllllllllllIIIIIIllIlIIIllIlI, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
        }
        
        public Well(final Start llllllllllllllIIIIIIllIlIIlIIllI, final int llllllllllllllIIIIIIllIlIIlIlIll, final Random llllllllllllllIIIIIIllIlIIlIlIlI, final int llllllllllllllIIIIIIllIlIIlIlIIl, final int llllllllllllllIIIIIIllIlIIlIIIlI) {
            super(llllllllllllllIIIIIIllIlIIlIIllI, llllllllllllllIIIIIIllIlIIlIlIll);
            this.coordBaseMode = EnumFacing.Plane.HORIZONTAL.random(llllllllllllllIIIIIIllIlIIlIlIlI);
            switch (StructureVillagePieces.SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()]) {
                case 1:
                case 2: {
                    this.boundingBox = new StructureBoundingBox(llllllllllllllIIIIIIllIlIIlIlIIl, 64, llllllllllllllIIIIIIllIlIIlIIIlI, llllllllllllllIIIIIIllIlIIlIlIIl + 6 - 1, 78, llllllllllllllIIIIIIllIlIIlIIIlI + 6 - 1);
                    break;
                }
                default: {
                    this.boundingBox = new StructureBoundingBox(llllllllllllllIIIIIIllIlIIlIlIIl, 64, llllllllllllllIIIIIIllIlIIlIIIlI, llllllllllllllIIIIIIllIlIIlIlIIl + 6 - 1, 78, llllllllllllllIIIIIIllIlIIlIIIlI + 6 - 1);
                    break;
                }
            }
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIIIIIllIlIIIIllll, final Random llllllllllllllIIIIIIllIlIIIIlllI, final StructureBoundingBox llllllllllllllIIIIIIllIlIIIIllIl) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(llllllllllllllIIIIIIllIlIIIIllll, llllllllllllllIIIIIIllIlIIIIllIl);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 3, 0);
            }
            this.func_175804_a(llllllllllllllIIIIIIllIlIIIIllll, llllllllllllllIIIIIIllIlIIIIllIl, 1, 0, 1, 4, 12, 4, Blocks.cobblestone.getDefaultState(), Blocks.flowing_water.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.air.getDefaultState(), 2, 12, 2, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.air.getDefaultState(), 3, 12, 2, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.air.getDefaultState(), 2, 12, 3, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.air.getDefaultState(), 3, 12, 3, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.oak_fence.getDefaultState(), 1, 13, 1, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.oak_fence.getDefaultState(), 1, 14, 1, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.oak_fence.getDefaultState(), 4, 13, 1, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.oak_fence.getDefaultState(), 4, 14, 1, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.oak_fence.getDefaultState(), 1, 13, 4, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.oak_fence.getDefaultState(), 1, 14, 4, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.oak_fence.getDefaultState(), 4, 13, 4, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.oak_fence.getDefaultState(), 4, 14, 4, llllllllllllllIIIIIIllIlIIIIllIl);
            this.func_175804_a(llllllllllllllIIIIIIllIlIIIIllll, llllllllllllllIIIIIIllIlIIIIllIl, 1, 15, 1, 4, 15, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            for (int llllllllllllllIIIIIIllIlIIIIllII = 0; llllllllllllllIIIIIIllIlIIIIllII <= 5; ++llllllllllllllIIIIIIllIlIIIIllII) {
                for (int llllllllllllllIIIIIIllIlIIIIlIll = 0; llllllllllllllIIIIIIllIlIIIIlIll <= 5; ++llllllllllllllIIIIIIllIlIIIIlIll) {
                    if (llllllllllllllIIIIIIllIlIIIIlIll == 0 || llllllllllllllIIIIIIllIlIIIIlIll == 5 || llllllllllllllIIIIIIllIlIIIIllII == 0 || llllllllllllllIIIIIIllIlIIIIllII == 5) {
                        this.func_175811_a(llllllllllllllIIIIIIllIlIIIIllll, Blocks.gravel.getDefaultState(), llllllllllllllIIIIIIllIlIIIIlIll, 11, llllllllllllllIIIIIIllIlIIIIllII, llllllllllllllIIIIIIllIlIIIIllIl);
                        this.clearCurrentPositionBlocksUpwards(llllllllllllllIIIIIIllIlIIIIllll, llllllllllllllIIIIIIllIlIIIIlIll, 12, llllllllllllllIIIIIIllIlIIIIllII, llllllllllllllIIIIIIllIlIIIIllIl);
                    }
                }
            }
            return true;
        }
        
        static {
            __OBFID = "CL_00000533";
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_176064_a;
        
        static {
            __OBFID = "CL_00001968";
            field_176064_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_176064_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_176064_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_176064_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_176064_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
    
    abstract static class Village extends StructureComponent
    {
        private /* synthetic */ int villagersSpawned;
        private /* synthetic */ boolean field_143014_b;
        protected /* synthetic */ int field_143015_k;
        
        protected int getAverageGroundLevel(final World llIllIIIlIlIII, final StructureBoundingBox llIllIIIlIIlll) {
            int llIllIIIlIIllI = 0;
            int llIllIIIlIIlIl = 0;
            for (int llIllIIIlIIlII = this.boundingBox.minZ; llIllIIIlIIlII <= this.boundingBox.maxZ; ++llIllIIIlIIlII) {
                for (int llIllIIIlIIIll = this.boundingBox.minX; llIllIIIlIIIll <= this.boundingBox.maxX; ++llIllIIIlIIIll) {
                    final BlockPos llIllIIIlIIIlI = new BlockPos(llIllIIIlIIIll, 64, llIllIIIlIIlII);
                    if (llIllIIIlIIlll.func_175898_b(llIllIIIlIIIlI)) {
                        llIllIIIlIIllI += Math.max(llIllIIIlIlIII.func_175672_r(llIllIIIlIIIlI).getY(), llIllIIIlIlIII.provider.getAverageGroundLevel());
                        ++llIllIIIlIIlIl;
                    }
                }
            }
            if (llIllIIIlIIlIl == 0) {
                return -1;
            }
            return llIllIIIlIIllI / llIllIIIlIIlIl;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llIllIIlIlllII) {
            llIllIIlIlllII.setInteger("HPos", this.field_143015_k);
            llIllIIlIlllII.setInteger("VCount", this.villagersSpawned);
            llIllIIlIlllII.setBoolean("Desert", this.field_143014_b);
        }
        
        public Village() {
            this.field_143015_k = -1;
        }
        
        static {
            __OBFID = "CL_00000531";
        }
        
        protected void func_175846_a(final boolean llIlIlIlIIlIII) {
            this.field_143014_b = llIlIlIlIIlIII;
        }
        
        protected Village(final Start llIllIIllIIIll, final int llIllIIllIIlIl) {
            super(llIllIIllIIlIl);
            this.field_143015_k = -1;
            if (llIllIIllIIIll != null) {
                this.field_143014_b = llIllIIllIIIll.inDesert;
            }
        }
        
        @Override
        protected void func_175808_b(final World llIlIlIlIlllII, final IBlockState llIlIlIlIllIll, final int llIlIlIlIlIIlI, final int llIlIlIlIlIIIl, final int llIlIlIlIllIII, final StructureBoundingBox llIlIlIlIlIlll) {
            final IBlockState llIlIlIlIlIllI = this.func_175847_a(llIlIlIlIllIll);
            super.func_175808_b(llIlIlIlIlllII, llIlIlIlIlIllI, llIlIlIlIlIIlI, llIlIlIlIlIIIl, llIlIlIlIllIII, llIlIlIlIlIlll);
        }
        
        protected StructureComponent getNextComponentPP(final Start llIllIIIllIllI, final List llIllIIIlllIll, final Random llIllIIIlllIlI, final int llIllIIIlllIIl, final int llIllIIIlllIII) {
            if (this.coordBaseMode != null) {
                switch (StructureVillagePieces.SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        return func_176066_d(llIllIIIllIllI, llIllIIIlllIll, llIllIIIlllIlI, this.boundingBox.maxX + 1, this.boundingBox.minY + llIllIIIlllIIl, this.boundingBox.minZ + llIllIIIlllIII, EnumFacing.EAST, this.getComponentType());
                    }
                    case 2: {
                        return func_176066_d(llIllIIIllIllI, llIllIIIlllIll, llIllIIIlllIlI, this.boundingBox.maxX + 1, this.boundingBox.minY + llIllIIIlllIIl, this.boundingBox.minZ + llIllIIIlllIII, EnumFacing.EAST, this.getComponentType());
                    }
                    case 3: {
                        return func_176066_d(llIllIIIllIllI, llIllIIIlllIll, llIllIIIlllIlI, this.boundingBox.minX + llIllIIIlllIII, this.boundingBox.minY + llIllIIIlllIIl, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                    case 4: {
                        return func_176066_d(llIllIIIllIllI, llIllIIIlllIll, llIllIIIlllIlI, this.boundingBox.minX + llIllIIIlllIII, this.boundingBox.minY + llIllIIIlllIIl, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        protected int func_180779_c(final int llIlIlllIIlllI, final int llIlIlllIIllIl) {
            return llIlIlllIIllIl;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llIllIIlIllIII) {
            this.field_143015_k = llIllIIlIllIII.getInteger("HPos");
            this.villagersSpawned = llIllIIlIllIII.getInteger("VCount");
            this.field_143014_b = llIllIIlIllIII.getBoolean("Desert");
        }
        
        @Override
        protected void func_175804_a(final World llIlIllIIIIIII, final StructureBoundingBox llIlIlIlllIIIl, final int llIlIlIlllIIII, final int llIlIlIllIllll, final int llIlIlIlllllII, final int llIlIlIllIllIl, final int llIlIlIllIllII, final int llIlIlIllllIIl, final IBlockState llIlIlIllllIII, final IBlockState llIlIlIlllIlll, final boolean llIlIlIllIlIII) {
            final IBlockState llIlIlIlllIlIl = this.func_175847_a(llIlIlIllllIII);
            final IBlockState llIlIlIlllIlII = this.func_175847_a(llIlIlIlllIlll);
            super.func_175804_a(llIlIllIIIIIII, llIlIlIlllIIIl, llIlIlIlllIIII, llIlIlIllIllll, llIlIlIlllllII, llIlIlIllIllIl, llIlIlIllIllII, llIlIlIllllIIl, llIlIlIlllIlIl, llIlIlIlllIlII, llIlIlIllIlIII);
        }
        
        @Override
        protected void func_175811_a(final World llIlIllIIllllI, final IBlockState llIlIllIlIlIlI, final int llIlIllIIllIlI, final int llIlIllIlIIlll, final int llIlIllIIlIllI, final StructureBoundingBox llIlIllIlIIlII) {
            final IBlockState llIlIllIlIIIlI = this.func_175847_a(llIlIllIlIlIlI);
            super.func_175811_a(llIlIllIIllllI, llIlIllIlIIIlI, llIlIllIIllIlI, llIlIllIlIIlll, llIlIllIIlIllI, llIlIllIlIIlII);
        }
        
        protected IBlockState func_175847_a(final IBlockState llIlIllIllIllI) {
            if (this.field_143014_b) {
                if (llIlIllIllIllI.getBlock() == Blocks.log || llIlIllIllIllI.getBlock() == Blocks.log2) {
                    return Blocks.sandstone.getDefaultState();
                }
                if (llIlIllIllIllI.getBlock() == Blocks.cobblestone) {
                    return Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.DEFAULT.func_176675_a());
                }
                if (llIlIllIllIllI.getBlock() == Blocks.planks) {
                    return Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.func_176675_a());
                }
                if (llIlIllIllIllI.getBlock() == Blocks.oak_stairs) {
                    return Blocks.sandstone_stairs.getDefaultState().withProperty(BlockStairs.FACING, llIlIllIllIllI.getValue(BlockStairs.FACING));
                }
                if (llIlIllIllIllI.getBlock() == Blocks.stone_stairs) {
                    return Blocks.sandstone_stairs.getDefaultState().withProperty(BlockStairs.FACING, llIlIllIllIllI.getValue(BlockStairs.FACING));
                }
                if (llIlIllIllIllI.getBlock() == Blocks.gravel) {
                    return Blocks.sandstone.getDefaultState();
                }
            }
            return llIlIllIllIllI;
        }
        
        protected void spawnVillagers(final World llIlIlllIlllIl, final StructureBoundingBox llIlIlllllIIII, final int llIlIlllIllIll, final int llIlIllllIllII, final int llIlIlllIllIIl, final int llIlIlllIllIII) {
            if (this.villagersSpawned < llIlIlllIllIII) {
                for (int llIlIllllIIllI = this.villagersSpawned; llIlIllllIIllI < llIlIlllIllIII; ++llIlIllllIIllI) {
                    final int llIlIllllIIlII = this.getXWithOffset(llIlIlllIllIll + llIlIllllIIllI, llIlIlllIllIIl);
                    final int llIlIllllIIIlI = this.getYWithOffset(llIlIllllIllII);
                    final int llIlIllllIIIII = this.getZWithOffset(llIlIlllIllIll + llIlIllllIIllI, llIlIlllIllIIl);
                    if (!llIlIlllllIIII.func_175898_b(new BlockPos(llIlIllllIIlII, llIlIllllIIIlI, llIlIllllIIIII))) {
                        break;
                    }
                    ++this.villagersSpawned;
                    final EntityVillager llIlIlllIlllll = new EntityVillager(llIlIlllIlllIl);
                    llIlIlllIlllll.setLocationAndAngles(llIlIllllIIlII + 0.5, llIlIllllIIIlI, llIlIllllIIIII + 0.5, 0.0f, 0.0f);
                    llIlIlllIlllll.func_180482_a(llIlIlllIlllIl.getDifficultyForLocation(new BlockPos(llIlIlllIlllll)), null);
                    llIlIlllIlllll.setProfession(this.func_180779_c(llIlIllllIIllI, llIlIlllIlllll.getProfession()));
                    llIlIlllIlllIl.spawnEntityInWorld(llIlIlllIlllll);
                }
            }
        }
        
        protected static boolean canVillageGoDeeper(final StructureBoundingBox llIllIIIIlIlll) {
            return llIllIIIIlIlll != null && llIllIIIIlIlll.minY > 10;
        }
        
        protected StructureComponent getNextComponentNN(final Start llIllIIlIIlIII, final List llIllIIlIIIlll, final Random llIllIIlIIllII, final int llIllIIlIIlIll, final int llIllIIlIIlIlI) {
            if (this.coordBaseMode != null) {
                switch (StructureVillagePieces.SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        return func_176066_d(llIllIIlIIlIII, llIllIIlIIIlll, llIllIIlIIllII, this.boundingBox.minX - 1, this.boundingBox.minY + llIllIIlIIlIll, this.boundingBox.minZ + llIllIIlIIlIlI, EnumFacing.WEST, this.getComponentType());
                    }
                    case 2: {
                        return func_176066_d(llIllIIlIIlIII, llIllIIlIIIlll, llIllIIlIIllII, this.boundingBox.minX - 1, this.boundingBox.minY + llIllIIlIIlIll, this.boundingBox.minZ + llIllIIlIIlIlI, EnumFacing.WEST, this.getComponentType());
                    }
                    case 3: {
                        return func_176066_d(llIllIIlIIlIII, llIllIIlIIIlll, llIllIIlIIllII, this.boundingBox.minX + llIllIIlIIlIlI, this.boundingBox.minY + llIllIIlIIlIll, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                    case 4: {
                        return func_176066_d(llIllIIlIIlIII, llIllIIlIIIlll, llIllIIlIIllII, this.boundingBox.minX + llIllIIlIIlIlI, this.boundingBox.minY + llIllIIlIIlIll, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                }
            }
            return null;
        }
    }
    
    public static class PieceWeight
    {
        public final /* synthetic */ int villagePieceWeight;
        public /* synthetic */ Class villagePieceClass;
        public /* synthetic */ int villagePiecesSpawned;
        public /* synthetic */ int villagePiecesLimit;
        
        public boolean canSpawnMoreVillagePieces() {
            return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
        }
        
        public boolean canSpawnMoreVillagePiecesOfType(final int llllllllllllllIllIIIIllIIIIllllI) {
            return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
        }
        
        static {
            __OBFID = "CL_00000521";
        }
        
        public PieceWeight(final Class llllllllllllllIllIIIIllIIIlIIIll, final int llllllllllllllIllIIIIllIIIlIIllI, final int llllllllllllllIllIIIIllIIIlIIIIl) {
            this.villagePieceClass = llllllllllllllIllIIIIllIIIlIIIll;
            this.villagePieceWeight = llllllllllllllIllIIIIllIIIlIIllI;
            this.villagePiecesLimit = llllllllllllllIllIIIIllIIIlIIIIl;
        }
    }
    
    public static class Field2 extends Village
    {
        private /* synthetic */ Block cropTypeB;
        private /* synthetic */ Block cropTypeA;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIlllllIllIlIllIllI) {
            super.writeStructureToNBT(llllllllllllllIlllllIllIlIllIllI);
            llllllllllllllIlllllIllIlIllIllI.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
            llllllllllllllIlllllIllIlIllIllI.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
        }
        
        public Field2(final Start llllllllllllllIlllllIllIllIIIIII, final int llllllllllllllIlllllIllIllIIIlIl, final Random llllllllllllllIlllllIllIllIIIlII, final StructureBoundingBox llllllllllllllIlllllIllIllIIIIll, final EnumFacing llllllllllllllIlllllIllIllIIIIlI) {
            super(llllllllllllllIlllllIllIllIIIIII, llllllllllllllIlllllIllIllIIIlIl);
            this.coordBaseMode = llllllllllllllIlllllIllIllIIIIlI;
            this.boundingBox = llllllllllllllIlllllIllIllIIIIll;
            this.cropTypeA = this.func_151560_a(llllllllllllllIlllllIllIllIIIlII);
            this.cropTypeB = this.func_151560_a(llllllllllllllIlllllIllIllIIIlII);
        }
        
        public Field2() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIlllllIllIlIllIIlI) {
            super.readStructureFromNBT(llllllllllllllIlllllIllIlIllIIlI);
            this.cropTypeA = Block.getBlockById(llllllllllllllIlllllIllIlIllIIlI.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(llllllllllllllIlllllIllIlIllIIlI.getInteger("CB"));
        }
        
        static {
            __OBFID = "CL_00000519";
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlllllIllIlIIIlIIl, final Random llllllllllllllIlllllIllIlIIIlIII, final StructureBoundingBox llllllllllllllIlllllIllIlIIIIIIl) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(llllllllllllllIlllllIllIlIIIlIIl, llllllllllllllIlllllIllIlIIIIIIl);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
            }
            this.func_175804_a(llllllllllllllIlllllIllIlIIIlIIl, llllllllllllllIlllllIllIlIIIIIIl, 0, 1, 0, 6, 4, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllllIllIlIIIlIIl, llllllllllllllIlllllIllIlIIIIIIl, 1, 0, 1, 2, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllllIllIlIIIlIIl, llllllllllllllIlllllIllIlIIIIIIl, 4, 0, 1, 5, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllllIllIlIIIlIIl, llllllllllllllIlllllIllIlIIIIIIl, 0, 0, 0, 0, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllllIllIlIIIlIIl, llllllllllllllIlllllIllIlIIIIIIl, 6, 0, 0, 6, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllllIllIlIIIlIIl, llllllllllllllIlllllIllIlIIIIIIl, 1, 0, 0, 5, 0, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllllIllIlIIIlIIl, llllllllllllllIlllllIllIlIIIIIIl, 1, 0, 8, 5, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlllllIllIlIIIlIIl, llllllllllllllIlllllIllIlIIIIIIl, 3, 0, 1, 3, 0, 7, Blocks.water.getDefaultState(), Blocks.water.getDefaultState(), false);
            for (int llllllllllllllIlllllIllIlIIIIllI = 1; llllllllllllllIlllllIllIlIIIIllI <= 7; ++llllllllllllllIlllllIllIlIIIIllI) {
                this.func_175811_a(llllllllllllllIlllllIllIlIIIlIIl, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(llllllllllllllIlllllIllIlIIIlIII, 2, 7)), 1, 1, llllllllllllllIlllllIllIlIIIIllI, llllllllllllllIlllllIllIlIIIIIIl);
                this.func_175811_a(llllllllllllllIlllllIllIlIIIlIIl, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(llllllllllllllIlllllIllIlIIIlIII, 2, 7)), 2, 1, llllllllllllllIlllllIllIlIIIIllI, llllllllllllllIlllllIllIlIIIIIIl);
                this.func_175811_a(llllllllllllllIlllllIllIlIIIlIIl, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(llllllllllllllIlllllIllIlIIIlIII, 2, 7)), 4, 1, llllllllllllllIlllllIllIlIIIIllI, llllllllllllllIlllllIllIlIIIIIIl);
                this.func_175811_a(llllllllllllllIlllllIllIlIIIlIIl, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(llllllllllllllIlllllIllIlIIIlIII, 2, 7)), 5, 1, llllllllllllllIlllllIllIlIIIIllI, llllllllllllllIlllllIllIlIIIIIIl);
            }
            for (int llllllllllllllIlllllIllIlIIIIllI = 0; llllllllllllllIlllllIllIlIIIIllI < 9; ++llllllllllllllIlllllIllIlIIIIllI) {
                for (int llllllllllllllIlllllIllIlIIIIlIl = 0; llllllllllllllIlllllIllIlIIIIlIl < 7; ++llllllllllllllIlllllIllIlIIIIlIl) {
                    this.clearCurrentPositionBlocksUpwards(llllllllllllllIlllllIllIlIIIlIIl, llllllllllllllIlllllIllIlIIIIlIl, 4, llllllllllllllIlllllIllIlIIIIllI, llllllllllllllIlllllIllIlIIIIIIl);
                    this.func_175808_b(llllllllllllllIlllllIllIlIIIlIIl, Blocks.dirt.getDefaultState(), llllllllllllllIlllllIllIlIIIIlIl, -1, llllllllllllllIlllllIllIlIIIIllI, llllllllllllllIlllllIllIlIIIIIIl);
                }
            }
            return true;
        }
        
        private Block func_151560_a(final Random llllllllllllllIlllllIllIlIlIllII) {
            switch (llllllllllllllIlllllIllIlIlIllII.nextInt(5)) {
                case 0: {
                    return Blocks.carrots;
                }
                case 1: {
                    return Blocks.potatoes;
                }
                default: {
                    return Blocks.wheat;
                }
            }
        }
        
        public static Field2 func_175852_a(final Start llllllllllllllIlllllIllIlIlIIIlI, final List llllllllllllllIlllllIllIlIlIIIIl, final Random llllllllllllllIlllllIllIlIIlIlll, final int llllllllllllllIlllllIllIlIIlIllI, final int llllllllllllllIlllllIllIlIIlIlIl, final int llllllllllllllIlllllIllIlIIlIlII, final EnumFacing llllllllllllllIlllllIllIlIIlllII, final int llllllllllllllIlllllIllIlIIlIIlI) {
            final StructureBoundingBox llllllllllllllIlllllIllIlIIllIlI = StructureBoundingBox.func_175897_a(llllllllllllllIlllllIllIlIIlIllI, llllllllllllllIlllllIllIlIIlIlIl, llllllllllllllIlllllIllIlIIlIlII, 0, 0, 0, 7, 4, 9, llllllllllllllIlllllIllIlIIlllII);
            return (Village.canVillageGoDeeper(llllllllllllllIlllllIllIlIIllIlI) && StructureComponent.findIntersecting(llllllllllllllIlllllIllIlIlIIIIl, llllllllllllllIlllllIllIlIIllIlI) == null) ? new Field2(llllllllllllllIlllllIllIlIlIIIlI, llllllllllllllIlllllIllIlIIlIIlI, llllllllllllllIlllllIllIlIIlIlll, llllllllllllllIlllllIllIlIIllIlI, llllllllllllllIlllllIllIlIIlllII) : null;
        }
    }
    
    public static class House2 extends Village
    {
        private static final /* synthetic */ List villageBlacksmithChestContents;
        private /* synthetic */ boolean hasMadeChest;
        
        public static House2 func_175855_a(final Start llllllllllllllllIIlIlllIIlIIIIII, final List llllllllllllllllIIlIlllIIIllllll, final Random llllllllllllllllIIlIlllIIIlllllI, final int llllllllllllllllIIlIlllIIIllIlII, final int llllllllllllllllIIlIlllIIIllllII, final int llllllllllllllllIIlIlllIIIlllIll, final EnumFacing llllllllllllllllIIlIlllIIIllIIIl, final int llllllllllllllllIIlIlllIIIlllIIl) {
            final StructureBoundingBox llllllllllllllllIIlIlllIIIlllIII = StructureBoundingBox.func_175897_a(llllllllllllllllIIlIlllIIIllIlII, llllllllllllllllIIlIlllIIIllllII, llllllllllllllllIIlIlllIIIlllIll, 0, 0, 0, 10, 6, 7, llllllllllllllllIIlIlllIIIllIIIl);
            return (Village.canVillageGoDeeper(llllllllllllllllIIlIlllIIIlllIII) && StructureComponent.findIntersecting(llllllllllllllllIIlIlllIIIllllll, llllllllllllllllIIlIlllIIIlllIII) == null) ? new House2(llllllllllllllllIIlIlllIIlIIIIII, llllllllllllllllIIlIlllIIIlllIIl, llllllllllllllllIIlIlllIIIlllllI, llllllllllllllllIIlIlllIIIlllIII, llllllllllllllllIIlIlllIIIllIIIl) : null;
        }
        
        public House2(final Start llllllllllllllllIIlIlllIIlIIllIl, final int llllllllllllllllIIlIlllIIlIIllII, final Random llllllllllllllllIIlIlllIIlIlIIIl, final StructureBoundingBox llllllllllllllllIIlIlllIIlIlIIII, final EnumFacing llllllllllllllllIIlIlllIIlIIllll) {
            super(llllllllllllllllIIlIlllIIlIIllIl, llllllllllllllllIIlIlllIIlIIllII);
            this.coordBaseMode = llllllllllllllllIIlIlllIIlIIllll;
            this.boundingBox = llllllllllllllllIIlIlllIIlIlIIII;
        }
        
        static {
            __OBFID = "CL_00000526";
            villageBlacksmithChestContents = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_helmet, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_leggings, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_boots, 0, 1, 1, 5), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.obsidian), 0, 3, 7, 5), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.sapling), 0, 3, 7, 5), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1) });
        }
        
        public House2() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllllIIlIlllIIIlIlIll) {
            super.writeStructureToNBT(llllllllllllllllIIlIlllIIIlIlIll);
            llllllllllllllllIIlIlllIIIlIlIll.setBoolean("Chest", this.hasMadeChest);
        }
        
        @Override
        protected int func_180779_c(final int llllllllllllllllIIlIlllIIIIIllll, final int llllllllllllllllIIlIlllIIIIIlllI) {
            return 3;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIIlIlllIIIIlIlIl, final Random llllllllllllllllIIlIlllIIIIlIlII, final StructureBoundingBox llllllllllllllllIIlIlllIIIIllIIl) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
            }
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 0, 1, 0, 9, 4, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 0, 0, 0, 9, 0, 6, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 0, 4, 0, 9, 4, 6, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 0, 5, 0, 9, 5, 6, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 1, 5, 1, 8, 5, 5, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 1, 1, 0, 2, 3, 0, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 0, 1, 0, 0, 4, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 3, 1, 0, 3, 4, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 0, 1, 6, 0, 4, 6, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.planks.getDefaultState(), 3, 3, 1, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 3, 1, 2, 3, 3, 2, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 4, 1, 3, 5, 3, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 0, 1, 1, 0, 3, 5, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 1, 1, 6, 5, 3, 6, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 5, 1, 0, 5, 3, 0, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 9, 1, 0, 9, 3, 0, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 6, 1, 4, 9, 4, 6, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.flowing_lava.getDefaultState(), 7, 1, 5, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.flowing_lava.getDefaultState(), 8, 1, 5, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.iron_bars.getDefaultState(), 9, 2, 5, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.iron_bars.getDefaultState(), 9, 2, 4, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175804_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 7, 2, 4, 8, 2, 5, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.cobblestone.getDefaultState(), 6, 1, 3, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.furnace.getDefaultState(), 6, 2, 3, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.furnace.getDefaultState(), 6, 3, 3, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.double_stone_slab.getDefaultState(), 8, 1, 1, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.glass_pane.getDefaultState(), 0, 2, 2, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.glass_pane.getDefaultState(), 0, 2, 4, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.glass_pane.getDefaultState(), 2, 2, 6, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.glass_pane.getDefaultState(), 4, 2, 6, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.oak_fence.getDefaultState(), 2, 1, 4, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.wooden_pressure_plate.getDefaultState(), 2, 2, 4, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.planks.getDefaultState(), 1, 1, 5, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.oak_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.oak_stairs, 3)), 2, 1, 5, llllllllllllllllIIlIlllIIIIllIIl);
            this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.oak_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.oak_stairs, 1)), 1, 1, 4, llllllllllllllllIIlIlllIIIIllIIl);
            if (!this.hasMadeChest && llllllllllllllllIIlIlllIIIIllIIl.func_175898_b(new BlockPos(this.getXWithOffset(5, 5), this.getYWithOffset(1), this.getZWithOffset(5, 5)))) {
                this.hasMadeChest = true;
                this.func_180778_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, llllllllllllllllIIlIlllIIIIlIlII, 5, 1, 5, House2.villageBlacksmithChestContents, 3 + llllllllllllllllIIlIlllIIIIlIlII.nextInt(6));
            }
            for (int llllllllllllllllIIlIlllIIIIllIII = 6; llllllllllllllllIIlIlllIIIIllIII <= 8; ++llllllllllllllllIIlIlllIIIIllIII) {
                if (this.func_175807_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIII, 0, -1, llllllllllllllllIIlIlllIIIIllIIl).getBlock().getMaterial() == Material.air && this.func_175807_a(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIII, -1, -1, llllllllllllllllIIlIlllIIIIllIIl).getBlock().getMaterial() != Material.air) {
                    this.func_175811_a(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), llllllllllllllllIIlIlllIIIIllIII, 0, -1, llllllllllllllllIIlIlllIIIIllIIl);
                }
            }
            for (int llllllllllllllllIIlIlllIIIIllIII = 0; llllllllllllllllIIlIlllIIIIllIII < 7; ++llllllllllllllllIIlIlllIIIIllIII) {
                for (int llllllllllllllllIIlIlllIIIIlIlll = 0; llllllllllllllllIIlIlllIIIIlIlll < 10; ++llllllllllllllllIIlIlllIIIIlIlll) {
                    this.clearCurrentPositionBlocksUpwards(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIlIlll, 6, llllllllllllllllIIlIlllIIIIllIII, llllllllllllllllIIlIlllIIIIllIIl);
                    this.func_175808_b(llllllllllllllllIIlIlllIIIIlIlIl, Blocks.cobblestone.getDefaultState(), llllllllllllllllIIlIlllIIIIlIlll, -1, llllllllllllllllIIlIlllIIIIllIII, llllllllllllllllIIlIlllIIIIllIIl);
                }
            }
            this.spawnVillagers(llllllllllllllllIIlIlllIIIIlIlIl, llllllllllllllllIIlIlllIIIIllIIl, 7, 1, 1, 1);
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllllIIlIlllIIIlIIIll) {
            super.readStructureFromNBT(llllllllllllllllIIlIlllIIIlIIIll);
            this.hasMadeChest = llllllllllllllllIIlIlllIIIlIIIll.getBoolean("Chest");
        }
    }
    
    public static class Church extends Village
    {
        public Church(final Start llllllllllllllllIllIIIIllIllIIII, final int llllllllllllllllIllIIIIllIlIllll, final Random llllllllllllllllIllIIIIllIlIlllI, final StructureBoundingBox llllllllllllllllIllIIIIllIlIlIII, final EnumFacing llllllllllllllllIllIIIIllIlIllII) {
            super(llllllllllllllllIllIIIIllIllIIII, llllllllllllllllIllIIIIllIlIllll);
            this.coordBaseMode = llllllllllllllllIllIIIIllIlIllII;
            this.boundingBox = llllllllllllllllIllIIIIllIlIlIII;
        }
        
        static {
            __OBFID = "CL_00000525";
        }
        
        @Override
        protected int func_180779_c(final int llllllllllllllllIllIIIIlIlllIlIl, final int llllllllllllllllIllIIIIlIlllIlII) {
            return 2;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIllIIIIllIIIIIll, final Random llllllllllllllllIllIIIIlIllllIll, final StructureBoundingBox llllllllllllllllIllIIIIllIIIIIIl) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 12 - 1, 0);
            }
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 1, 1, 1, 3, 3, 7, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 1, 5, 1, 3, 9, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 1, 0, 0, 3, 0, 8, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 1, 1, 0, 3, 10, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 0, 1, 1, 0, 10, 3, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 4, 1, 1, 4, 10, 3, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 0, 0, 4, 0, 4, 7, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 4, 0, 4, 4, 4, 7, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 1, 1, 8, 3, 4, 8, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 1, 5, 4, 3, 10, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 1, 5, 5, 3, 5, 7, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 0, 9, 0, 4, 9, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 0, 4, 0, 4, 4, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.cobblestone.getDefaultState(), 0, 11, 2, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.cobblestone.getDefaultState(), 4, 11, 2, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.cobblestone.getDefaultState(), 2, 11, 0, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.cobblestone.getDefaultState(), 2, 11, 4, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.cobblestone.getDefaultState(), 1, 1, 6, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.cobblestone.getDefaultState(), 1, 1, 7, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.cobblestone.getDefaultState(), 2, 1, 7, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.cobblestone.getDefaultState(), 3, 1, 6, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.cobblestone.getDefaultState(), 3, 1, 7, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 1, 1, 5, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 2, 1, 6, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 3, 1, 5, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 1)), 1, 2, 7, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 0)), 3, 2, 7, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 0, 2, 2, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 0, 3, 2, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 4, 2, 2, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 4, 3, 2, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 0, 6, 2, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 0, 7, 2, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 4, 6, 2, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 4, 7, 2, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 2, 6, 0, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 2, 7, 0, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 2, 6, 4, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 2, 7, 4, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 0, 3, 6, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 4, 3, 6, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.glass_pane.getDefaultState(), 2, 3, 8, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode.getOpposite()), 2, 4, 7, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode.rotateY()), 1, 4, 6, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode.rotateYCCW()), 3, 4, 6, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode), 2, 4, 5, llllllllllllllllIllIIIIllIIIIIIl);
            final int llllllllllllllllIllIIIIllIIIIIII = this.getMetadataWithOffset(Blocks.ladder, 4);
            for (int llllllllllllllllIllIIIIlIlllllll = 1; llllllllllllllllIllIIIIlIlllllll <= 9; ++llllllllllllllllIllIIIIlIlllllll) {
                this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.ladder.getStateFromMeta(llllllllllllllllIllIIIIllIIIIIII), 3, llllllllllllllllIllIIIIlIlllllll, 3, llllllllllllllllIllIIIIllIIIIIIl);
            }
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.air.getDefaultState(), 2, 1, 0, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.air.getDefaultState(), 2, 2, 0, llllllllllllllllIllIIIIllIIIIIIl);
            this.func_175810_a(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, llllllllllllllllIllIIIIlIllllIll, 2, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            if (this.func_175807_a(llllllllllllllllIllIIIIllIIIIIll, 2, 0, -1, llllllllllllllllIllIIIIllIIIIIIl).getBlock().getMaterial() == Material.air && this.func_175807_a(llllllllllllllllIllIIIIllIIIIIll, 2, -1, -1, llllllllllllllllIllIIIIllIIIIIIl).getBlock().getMaterial() != Material.air) {
                this.func_175811_a(llllllllllllllllIllIIIIllIIIIIll, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 2, 0, -1, llllllllllllllllIllIIIIllIIIIIIl);
            }
            for (int llllllllllllllllIllIIIIlIlllllll = 0; llllllllllllllllIllIIIIlIlllllll < 9; ++llllllllllllllllIllIIIIlIlllllll) {
                for (int llllllllllllllllIllIIIIlIllllllI = 0; llllllllllllllllIllIIIIlIllllllI < 5; ++llllllllllllllllIllIIIIlIllllllI) {
                    this.clearCurrentPositionBlocksUpwards(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIlIllllllI, 12, llllllllllllllllIllIIIIlIlllllll, llllllllllllllllIllIIIIllIIIIIIl);
                    this.func_175808_b(llllllllllllllllIllIIIIllIIIIIll, Blocks.cobblestone.getDefaultState(), llllllllllllllllIllIIIIlIllllllI, -1, llllllllllllllllIllIIIIlIlllllll, llllllllllllllllIllIIIIllIIIIIIl);
                }
            }
            this.spawnVillagers(llllllllllllllllIllIIIIllIIIIIll, llllllllllllllllIllIIIIllIIIIIIl, 2, 1, 2, 1);
            return true;
        }
        
        public Church() {
        }
        
        public static Church func_175854_a(final Start llllllllllllllllIllIIIIllIIlIlII, final List llllllllllllllllIllIIIIllIIlllII, final Random llllllllllllllllIllIIIIllIIllIll, final int llllllllllllllllIllIIIIllIIllIlI, final int llllllllllllllllIllIIIIllIIllIIl, final int llllllllllllllllIllIIIIllIIIllll, final EnumFacing llllllllllllllllIllIIIIllIIlIlll, final int llllllllllllllllIllIIIIllIIlIllI) {
            final StructureBoundingBox llllllllllllllllIllIIIIllIIlIlIl = StructureBoundingBox.func_175897_a(llllllllllllllllIllIIIIllIIllIlI, llllllllllllllllIllIIIIllIIllIIl, llllllllllllllllIllIIIIllIIIllll, 0, 0, 0, 5, 12, 9, llllllllllllllllIllIIIIllIIlIlll);
            return (Village.canVillageGoDeeper(llllllllllllllllIllIIIIllIIlIlIl) && StructureComponent.findIntersecting(llllllllllllllllIllIIIIllIIlllII, llllllllllllllllIllIIIIllIIlIlIl) == null) ? new Church(llllllllllllllllIllIIIIllIIlIlII, llllllllllllllllIllIIIIllIIlIllI, llllllllllllllllIllIIIIllIIllIll, llllllllllllllllIllIIIIllIIlIlIl, llllllllllllllllIllIIIIllIIlIlll) : null;
        }
    }
    
    public static class House1 extends Village
    {
        public House1() {
        }
        
        public static House1 func_175850_a(final Start lllllllllllllllIlIIlIIIIllllIlll, final List lllllllllllllllIlIIlIIIIlllIllIl, final Random lllllllllllllllIlIIlIIIIlllIllII, final int lllllllllllllllIlIIlIIIIllllIlII, final int lllllllllllllllIlIIlIIIIlllIlIlI, final int lllllllllllllllIlIIlIIIIlllIlIIl, final EnumFacing lllllllllllllllIlIIlIIIIlllIlIII, final int lllllllllllllllIlIIlIIIIllllIIII) {
            final StructureBoundingBox lllllllllllllllIlIIlIIIIlllIllll = StructureBoundingBox.func_175897_a(lllllllllllllllIlIIlIIIIllllIlII, lllllllllllllllIlIIlIIIIlllIlIlI, lllllllllllllllIlIIlIIIIlllIlIIl, 0, 0, 0, 9, 9, 6, lllllllllllllllIlIIlIIIIlllIlIII);
            return (Village.canVillageGoDeeper(lllllllllllllllIlIIlIIIIlllIllll) && StructureComponent.findIntersecting(lllllllllllllllIlIIlIIIIlllIllIl, lllllllllllllllIlIIlIIIIlllIllll) == null) ? new House1(lllllllllllllllIlIIlIIIIllllIlll, lllllllllllllllIlIIlIIIIllllIIII, lllllllllllllllIlIIlIIIIlllIllII, lllllllllllllllIlIIlIIIIlllIllll, lllllllllllllllIlIIlIIIIlllIlIII) : null;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIlIIlIIIIllIllIll, final Random lllllllllllllllIlIIlIIIIllIlIIII, final StructureBoundingBox lllllllllllllllIlIIlIIIIllIIllll) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 9 - 1, 0);
            }
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 1, 1, 1, 7, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 0, 0, 0, 8, 0, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 0, 5, 0, 8, 5, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 0, 6, 1, 8, 6, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 0, 7, 2, 8, 7, 3, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            final int lllllllllllllllIlIIlIIIIllIllIII = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            final int lllllllllllllllIlIIlIIIIllIlIlll = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
            for (int lllllllllllllllIlIIlIIIIllIlIllI = -1; lllllllllllllllIlIIlIIIIllIlIllI <= 2; ++lllllllllllllllIlIIlIIIIllIlIllI) {
                for (int lllllllllllllllIlIIlIIIIllIlIlIl = 0; lllllllllllllllIlIIlIIIIllIlIlIl <= 8; ++lllllllllllllllIlIIlIIIIllIlIlIl) {
                    this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIlIIlIIIIllIllIII), lllllllllllllllIlIIlIIIIllIlIlIl, 6 + lllllllllllllllIlIIlIIIIllIlIllI, lllllllllllllllIlIIlIIIIllIlIllI, lllllllllllllllIlIIlIIIIllIIllll);
                    this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIlIIlIIIIllIlIlll), lllllllllllllllIlIIlIIIIllIlIlIl, 6 + lllllllllllllllIlIIlIIIIllIlIllI, 5 - lllllllllllllllIlIIlIIIIllIlIllI, lllllllllllllllIlIIlIIIIllIIllll);
                }
            }
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 0, 1, 0, 0, 1, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 1, 1, 5, 8, 1, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 8, 1, 0, 8, 1, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 2, 1, 0, 7, 1, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 0, 2, 0, 0, 4, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 0, 2, 5, 0, 4, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 8, 2, 5, 8, 4, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 8, 2, 0, 8, 4, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 0, 2, 1, 0, 4, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 1, 2, 5, 7, 4, 5, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 8, 2, 1, 8, 4, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 1, 2, 0, 7, 4, 0, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 4, 2, 0, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 5, 2, 0, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 6, 2, 0, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 4, 3, 0, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 5, 3, 0, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 6, 3, 0, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 0, 2, 2, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 0, 2, 3, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 0, 3, 2, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 0, 3, 3, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 8, 2, 2, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 8, 2, 3, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 8, 3, 2, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 8, 3, 3, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 2, 2, 5, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 3, 2, 5, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 5, 2, 5, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.glass_pane.getDefaultState(), 6, 2, 5, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 1, 4, 1, 7, 4, 1, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 1, 4, 4, 7, 4, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 1, 3, 4, 7, 3, 4, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.planks.getDefaultState(), 7, 1, 4, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.oak_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.oak_stairs, 0)), 7, 1, 3, lllllllllllllllIlIIlIIIIllIIllll);
            int lllllllllllllllIlIIlIIIIllIlIllI = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIlIIlIIIIllIlIllI), 6, 1, 4, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIlIIlIIIIllIlIllI), 5, 1, 4, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIlIIlIIIIllIlIllI), 4, 1, 4, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIlIIlIIIIllIlIllI), 3, 1, 4, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.oak_fence.getDefaultState(), 6, 1, 3, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.wooden_pressure_plate.getDefaultState(), 6, 2, 3, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.oak_fence.getDefaultState(), 4, 1, 3, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.wooden_pressure_plate.getDefaultState(), 4, 2, 3, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.crafting_table.getDefaultState(), 7, 1, 1, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.air.getDefaultState(), 1, 1, 0, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.air.getDefaultState(), 1, 2, 0, lllllllllllllllIlIIlIIIIllIIllll);
            this.func_175810_a(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, lllllllllllllllIlIIlIIIIllIlIIII, 1, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            if (this.func_175807_a(lllllllllllllllIlIIlIIIIllIllIll, 1, 0, -1, lllllllllllllllIlIIlIIIIllIIllll).getBlock().getMaterial() == Material.air && this.func_175807_a(lllllllllllllllIlIIlIIIIllIllIll, 1, -1, -1, lllllllllllllllIlIIlIIIIllIIllll).getBlock().getMaterial() != Material.air) {
                this.func_175811_a(lllllllllllllllIlIIlIIIIllIllIll, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 1, 0, -1, lllllllllllllllIlIIlIIIIllIIllll);
            }
            for (int lllllllllllllllIlIIlIIIIllIlIlII = 0; lllllllllllllllIlIIlIIIIllIlIlII < 6; ++lllllllllllllllIlIIlIIIIllIlIlII) {
                for (int lllllllllllllllIlIIlIIIIllIlIIll = 0; lllllllllllllllIlIIlIIIIllIlIIll < 9; ++lllllllllllllllIlIIlIIIIllIlIIll) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIlIIll, 9, lllllllllllllllIlIIlIIIIllIlIlII, lllllllllllllllIlIIlIIIIllIIllll);
                    this.func_175808_b(lllllllllllllllIlIIlIIIIllIllIll, Blocks.cobblestone.getDefaultState(), lllllllllllllllIlIIlIIIIllIlIIll, -1, lllllllllllllllIlIIlIIIIllIlIlII, lllllllllllllllIlIIlIIIIllIIllll);
                }
            }
            this.spawnVillagers(lllllllllllllllIlIIlIIIIllIllIll, lllllllllllllllIlIIlIIIIllIIllll, 2, 1, 2, 1);
            return true;
        }
        
        static {
            __OBFID = "CL_00000517";
        }
        
        @Override
        protected int func_180779_c(final int lllllllllllllllIlIIlIIIIllIIlIII, final int lllllllllllllllIlIIlIIIIllIIIlll) {
            return 1;
        }
        
        public House1(final Start lllllllllllllllIlIIlIIIlIIIIIlII, final int lllllllllllllllIlIIlIIIlIIIIlIIl, final Random lllllllllllllllIlIIlIIIlIIIIlIII, final StructureBoundingBox lllllllllllllllIlIIlIIIlIIIIIIlI, final EnumFacing lllllllllllllllIlIIlIIIlIIIIIllI) {
            super(lllllllllllllllIlIIlIIIlIIIIIlII, lllllllllllllllIlIIlIIIlIIIIlIIl);
            this.coordBaseMode = lllllllllllllllIlIIlIIIlIIIIIllI;
            this.boundingBox = lllllllllllllllIlIIlIIIlIIIIIIlI;
        }
    }
    
    public static class House4Garden extends Village
    {
        private /* synthetic */ boolean isRoofAccessible;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIIlllIllIlIIllIlIl) {
            super.writeStructureToNBT(llllllllllllllIIlllIllIlIIllIlIl);
            llllllllllllllIIlllIllIlIIllIlIl.setBoolean("Terrace", this.isRoofAccessible);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIIlllIllIlIIllIIIl) {
            super.readStructureFromNBT(llllllllllllllIIlllIllIlIIllIIIl);
            this.isRoofAccessible = llllllllllllllIIlllIllIlIIllIIIl.getBoolean("Terrace");
        }
        
        public House4Garden(final Start llllllllllllllIIlllIllIlIIllllll, final int llllllllllllllIIlllIllIlIIlllllI, final Random llllllllllllllIIlllIllIlIlIIIIll, final StructureBoundingBox llllllllllllllIIlllIllIlIIllllII, final EnumFacing llllllllllllllIIlllIllIlIIlllIll) {
            super(llllllllllllllIIlllIllIlIIllllll, llllllllllllllIIlllIllIlIIlllllI);
            this.coordBaseMode = llllllllllllllIIlllIllIlIIlllIll;
            this.boundingBox = llllllllllllllIIlllIllIlIIllllII;
            this.isRoofAccessible = llllllllllllllIIlllIllIlIlIIIIll.nextBoolean();
        }
        
        static {
            __OBFID = "CL_00000523";
        }
        
        public static House4Garden func_175858_a(final Start llllllllllllllIIlllIllIlIIIlllII, final List llllllllllllllIIlllIllIlIIlIIlII, final Random llllllllllllllIIlllIllIlIIIllIlI, final int llllllllllllllIIlllIllIlIIIllIIl, final int llllllllllllllIIlllIllIlIIIllIII, final int llllllllllllllIIlllIllIlIIlIIIII, final EnumFacing llllllllllllllIIlllIllIlIIIlllll, final int llllllllllllllIIlllIllIlIIIllllI) {
            final StructureBoundingBox llllllllllllllIIlllIllIlIIIlllIl = StructureBoundingBox.func_175897_a(llllllllllllllIIlllIllIlIIIllIIl, llllllllllllllIIlllIllIlIIIllIII, llllllllllllllIIlllIllIlIIlIIIII, 0, 0, 0, 5, 6, 5, llllllllllllllIIlllIllIlIIIlllll);
            return (StructureComponent.findIntersecting(llllllllllllllIIlllIllIlIIlIIlII, llllllllllllllIIlllIllIlIIIlllIl) != null) ? null : new House4Garden(llllllllllllllIIlllIllIlIIIlllII, llllllllllllllIIlllIllIlIIIllllI, llllllllllllllIIlllIllIlIIIllIlI, llllllllllllllIIlllIllIlIIIlllIl, llllllllllllllIIlllIllIlIIIlllll);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlllIllIlIIIIllIl, final Random llllllllllllllIIlllIllIlIIIIllII, final StructureBoundingBox llllllllllllllIIlllIllIlIIIIIlIl) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(llllllllllllllIIlllIllIlIIIIllIl, llllllllllllllIIlllIllIlIIIIIlIl);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
            }
            this.func_175804_a(llllllllllllllIIlllIllIlIIIIllIl, llllllllllllllIIlllIllIlIIIIIlIl, 0, 0, 0, 4, 0, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlllIllIlIIIIllIl, llllllllllllllIIlllIllIlIIIIIlIl, 0, 4, 0, 4, 4, 4, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlllIllIlIIIIllIl, llllllllllllllIIlllIllIlIIIIIlIl, 1, 4, 1, 3, 4, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 0, 1, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 0, 2, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 0, 3, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 4, 1, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 4, 2, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 4, 3, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 0, 1, 4, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 0, 2, 4, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 0, 3, 4, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 4, 1, 4, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 4, 2, 4, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), 4, 3, 4, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175804_a(llllllllllllllIIlllIllIlIIIIllIl, llllllllllllllIIlllIllIlIIIIIlIl, 0, 1, 1, 0, 3, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlllIllIlIIIIllIl, llllllllllllllIIlllIllIlIIIIIlIl, 4, 1, 1, 4, 3, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIlllIllIlIIIIllIl, llllllllllllllIIlllIllIlIIIIIlIl, 1, 1, 4, 3, 3, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.glass_pane.getDefaultState(), 0, 2, 2, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.glass_pane.getDefaultState(), 2, 2, 4, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.glass_pane.getDefaultState(), 4, 2, 2, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.planks.getDefaultState(), 1, 1, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.planks.getDefaultState(), 1, 2, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.planks.getDefaultState(), 1, 3, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.planks.getDefaultState(), 2, 3, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.planks.getDefaultState(), 3, 3, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.planks.getDefaultState(), 3, 2, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.planks.getDefaultState(), 3, 1, 0, llllllllllllllIIlllIllIlIIIIIlIl);
            if (this.func_175807_a(llllllllllllllIIlllIllIlIIIIllIl, 2, 0, -1, llllllllllllllIIlllIllIlIIIIIlIl).getBlock().getMaterial() == Material.air && this.func_175807_a(llllllllllllllIIlllIllIlIIIIllIl, 2, -1, -1, llllllllllllllIIlllIllIlIIIIIlIl).getBlock().getMaterial() != Material.air) {
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 2, 0, -1, llllllllllllllIIlllIllIlIIIIIlIl);
            }
            this.func_175804_a(llllllllllllllIIlllIllIlIIIIllIl, llllllllllllllIIlllIllIlIIIIIlIl, 1, 1, 1, 3, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            if (this.isRoofAccessible) {
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 0, 5, 0, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 1, 5, 0, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 2, 5, 0, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 3, 5, 0, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 4, 5, 0, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 0, 5, 4, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 1, 5, 4, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 2, 5, 4, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 3, 5, 4, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 4, 5, 4, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 4, 5, 1, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 4, 5, 2, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 4, 5, 3, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 0, 5, 1, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 0, 5, 2, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.oak_fence.getDefaultState(), 0, 5, 3, llllllllllllllIIlllIllIlIIIIIlIl);
            }
            if (this.isRoofAccessible) {
                final int llllllllllllllIIlllIllIlIIIIlIlI = this.getMetadataWithOffset(Blocks.ladder, 3);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlllIllIlIIIIlIlI), 3, 1, 3, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlllIllIlIIIIlIlI), 3, 2, 3, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlllIllIlIIIIlIlI), 3, 3, 3, llllllllllllllIIlllIllIlIIIIIlIl);
                this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.ladder.getStateFromMeta(llllllllllllllIIlllIllIlIIIIlIlI), 3, 4, 3, llllllllllllllIIlllIllIlIIIIIlIl);
            }
            this.func_175811_a(llllllllllllllIIlllIllIlIIIIllIl, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode), 2, 3, 1, llllllllllllllIIlllIllIlIIIIIlIl);
            for (int llllllllllllllIIlllIllIlIIIIlIIl = 0; llllllllllllllIIlllIllIlIIIIlIIl < 5; ++llllllllllllllIIlllIllIlIIIIlIIl) {
                for (int llllllllllllllIIlllIllIlIIIIlIII = 0; llllllllllllllIIlllIllIlIIIIlIII < 5; ++llllllllllllllIIlllIllIlIIIIlIII) {
                    this.clearCurrentPositionBlocksUpwards(llllllllllllllIIlllIllIlIIIIllIl, llllllllllllllIIlllIllIlIIIIlIII, 6, llllllllllllllIIlllIllIlIIIIlIIl, llllllllllllllIIlllIllIlIIIIIlIl);
                    this.func_175808_b(llllllllllllllIIlllIllIlIIIIllIl, Blocks.cobblestone.getDefaultState(), llllllllllllllIIlllIllIlIIIIlIII, -1, llllllllllllllIIlllIllIlIIIIlIIl, llllllllllllllIIlllIllIlIIIIIlIl);
                }
            }
            this.spawnVillagers(llllllllllllllIIlllIllIlIIIIllIl, llllllllllllllIIlllIllIlIIIIIlIl, 1, 1, 2, 1);
            return true;
        }
        
        public House4Garden() {
        }
    }
    
    public static class Torch extends Village
    {
        public Torch() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIIIlIlIIIlIlllII, final Random llllllllllllllIlIIIlIlIIIlIllIll, final StructureBoundingBox llllllllllllllIlIIIlIlIIIlIlIllI) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(llllllllllllllIlIIIlIlIIIlIlllII, llllllllllllllIlIIIlIlIIIlIlIllI);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
            }
            this.func_175804_a(llllllllllllllIlIIIlIlIIIlIlllII, llllllllllllllIlIIIlIlIIIlIlIllI, 0, 0, 0, 2, 3, 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIlIIIlIlIIIlIlllII, Blocks.oak_fence.getDefaultState(), 1, 0, 0, llllllllllllllIlIIIlIlIIIlIlIllI);
            this.func_175811_a(llllllllllllllIlIIIlIlIIIlIlllII, Blocks.oak_fence.getDefaultState(), 1, 1, 0, llllllllllllllIlIIIlIlIIIlIlIllI);
            this.func_175811_a(llllllllllllllIlIIIlIlIIIlIlllII, Blocks.oak_fence.getDefaultState(), 1, 2, 0, llllllllllllllIlIIIlIlIIIlIlIllI);
            this.func_175811_a(llllllllllllllIlIIIlIlIIIlIlllII, Blocks.wool.getStateFromMeta(EnumDyeColor.WHITE.getDyeColorDamage()), 1, 3, 0, llllllllllllllIlIIIlIlIIIlIlIllI);
            final boolean llllllllllllllIlIIIlIlIIIlIllIIl = this.coordBaseMode == EnumFacing.EAST || this.coordBaseMode == EnumFacing.NORTH;
            this.func_175811_a(llllllllllllllIlIIIlIlIIIlIlllII, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode.rotateY()), llllllllllllllIlIIIlIlIIIlIllIIl ? 2 : 0, 3, 0, llllllllllllllIlIIIlIlIIIlIlIllI);
            this.func_175811_a(llllllllllllllIlIIIlIlIIIlIlllII, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode), 1, 3, 1, llllllllllllllIlIIIlIlIIIlIlIllI);
            this.func_175811_a(llllllllllllllIlIIIlIlIIIlIlllII, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode.rotateYCCW()), llllllllllllllIlIIIlIlIIIlIllIIl ? 0 : 2, 3, 0, llllllllllllllIlIIIlIlIIIlIlIllI);
            this.func_175811_a(llllllllllllllIlIIIlIlIIIlIlllII, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode.getOpposite()), 1, 3, -1, llllllllllllllIlIIIlIlIIIlIlIllI);
            return true;
        }
        
        static {
            __OBFID = "CL_00000520";
        }
        
        public static StructureBoundingBox func_175856_a(final Start llllllllllllllIlIIIlIlIIIllIllll, final List llllllllllllllIlIIIlIlIIIllIIlll, final Random llllllllllllllIlIIIlIlIIIllIllIl, final int llllllllllllllIlIIIlIlIIIllIllII, final int llllllllllllllIlIIIlIlIIIllIlIll, final int llllllllllllllIlIIIlIlIIIllIIlII, final EnumFacing llllllllllllllIlIIIlIlIIIllIIIll) {
            final StructureBoundingBox llllllllllllllIlIIIlIlIIIllIlIII = StructureBoundingBox.func_175897_a(llllllllllllllIlIIIlIlIIIllIllII, llllllllllllllIlIIIlIlIIIllIlIll, llllllllllllllIlIIIlIlIIIllIIlII, 0, 0, 0, 3, 4, 2, llllllllllllllIlIIIlIlIIIllIIIll);
            return (StructureComponent.findIntersecting(llllllllllllllIlIIIlIlIIIllIIlll, llllllllllllllIlIIIlIlIIIllIlIII) != null) ? null : llllllllllllllIlIIIlIlIIIllIlIII;
        }
        
        public Torch(final Start llllllllllllllIlIIIlIlIIIllllIIl, final int llllllllllllllIlIIIlIlIIIllllllI, final Random llllllllllllllIlIIIlIlIIIlllllIl, final StructureBoundingBox llllllllllllllIlIIIlIlIIIlllIlll, final EnumFacing llllllllllllllIlIIIlIlIIIlllIllI) {
            super(llllllllllllllIlIIIlIlIIIllllIIl, llllllllllllllIlIIIlIlIIIllllllI);
            this.coordBaseMode = llllllllllllllIlIIIlIlIIIlllIllI;
            this.boundingBox = llllllllllllllIlIIIlIlIIIlllIlll;
        }
    }
    
    public static class Path extends Road
    {
        private /* synthetic */ int averageGroundLevel;
        
        static {
            __OBFID = "CL_00000528";
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllllllllIIIlIlIllII, final List lllllllllllllllllllllIIIlIlIlIll, final Random lllllllllllllllllllllIIIlIlIIIlI) {
            boolean lllllllllllllllllllllIIIlIlIlIIl = false;
            for (int lllllllllllllllllllllIIIlIlIlIII = lllllllllllllllllllllIIIlIlIIIlI.nextInt(5); lllllllllllllllllllllIIIlIlIlIII < this.averageGroundLevel - 8; lllllllllllllllllllllIIIlIlIlIII += 2 + lllllllllllllllllllllIIIlIlIIIlI.nextInt(5)) {
                final StructureComponent lllllllllllllllllllllIIIlIlIIlll = this.getNextComponentNN((Start)lllllllllllllllllllllIIIlIlIllII, lllllllllllllllllllllIIIlIlIlIll, lllllllllllllllllllllIIIlIlIIIlI, 0, lllllllllllllllllllllIIIlIlIlIII);
                if (lllllllllllllllllllllIIIlIlIIlll != null) {
                    lllllllllllllllllllllIIIlIlIlIII += Math.max(lllllllllllllllllllllIIIlIlIIlll.boundingBox.getXSize(), lllllllllllllllllllllIIIlIlIIlll.boundingBox.getZSize());
                    lllllllllllllllllllllIIIlIlIlIIl = true;
                }
            }
            for (int lllllllllllllllllllllIIIlIlIlIII = lllllllllllllllllllllIIIlIlIIIlI.nextInt(5); lllllllllllllllllllllIIIlIlIlIII < this.averageGroundLevel - 8; lllllllllllllllllllllIIIlIlIlIII += 2 + lllllllllllllllllllllIIIlIlIIIlI.nextInt(5)) {
                final StructureComponent lllllllllllllllllllllIIIlIlIIllI = this.getNextComponentPP((Start)lllllllllllllllllllllIIIlIlIllII, lllllllllllllllllllllIIIlIlIlIll, lllllllllllllllllllllIIIlIlIIIlI, 0, lllllllllllllllllllllIIIlIlIlIII);
                if (lllllllllllllllllllllIIIlIlIIllI != null) {
                    lllllllllllllllllllllIIIlIlIlIII += Math.max(lllllllllllllllllllllIIIlIlIIllI.boundingBox.getXSize(), lllllllllllllllllllllIIIlIlIIllI.boundingBox.getZSize());
                    lllllllllllllllllllllIIIlIlIlIIl = true;
                }
            }
            if (lllllllllllllllllllllIIIlIlIlIIl && lllllllllllllllllllllIIIlIlIIIlI.nextInt(3) > 0 && this.coordBaseMode != null) {
                switch (StructureVillagePieces.SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        func_176069_e((Start)lllllllllllllllllllllIIIlIlIllII, lllllllllllllllllllllIIIlIlIlIll, lllllllllllllllllllllIIIlIlIIIlI, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.WEST, this.getComponentType());
                        break;
                    }
                    case 2: {
                        func_176069_e((Start)lllllllllllllllllllllIIIlIlIllII, lllllllllllllllllllllIIIlIlIlIll, lllllllllllllllllllllIIIlIlIIIlI, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, EnumFacing.WEST, this.getComponentType());
                        break;
                    }
                    case 3: {
                        func_176069_e((Start)lllllllllllllllllllllIIIlIlIllII, lllllllllllllllllllllIIIlIlIlIll, lllllllllllllllllllllIIIlIlIIIlI, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                        break;
                    }
                    case 4: {
                        func_176069_e((Start)lllllllllllllllllllllIIIlIlIllII, lllllllllllllllllllllIIIlIlIlIll, lllllllllllllllllllllIIIlIlIIIlI, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                        break;
                    }
                }
            }
            if (lllllllllllllllllllllIIIlIlIlIIl && lllllllllllllllllllllIIIlIlIIIlI.nextInt(3) > 0 && this.coordBaseMode != null) {
                switch (StructureVillagePieces.SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()]) {
                    case 1: {
                        func_176069_e((Start)lllllllllllllllllllllIIIlIlIllII, lllllllllllllllllllllIIIlIlIlIll, lllllllllllllllllllllIIIlIlIIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.EAST, this.getComponentType());
                        break;
                    }
                    case 2: {
                        func_176069_e((Start)lllllllllllllllllllllIIIlIlIllII, lllllllllllllllllllllIIIlIlIlIll, lllllllllllllllllllllIIIlIlIIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, EnumFacing.EAST, this.getComponentType());
                        break;
                    }
                    case 3: {
                        func_176069_e((Start)lllllllllllllllllllllIIIlIlIllII, lllllllllllllllllllllIIIlIlIlIll, lllllllllllllllllllllIIIlIlIIIlI, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                        break;
                    }
                    case 4: {
                        func_176069_e((Start)lllllllllllllllllllllIIIlIlIllII, lllllllllllllllllllllIIIlIlIlIll, lllllllllllllllllllllIIIlIlIIIlI, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                        break;
                    }
                }
            }
        }
        
        public Path(final Start lllllllllllllllllllllIIIllIIlIlI, final int lllllllllllllllllllllIIIllIIIIll, final Random lllllllllllllllllllllIIIllIIlIII, final StructureBoundingBox lllllllllllllllllllllIIIllIIIlll, final EnumFacing lllllllllllllllllllllIIIllIIIllI) {
            super(lllllllllllllllllllllIIIllIIlIlI, lllllllllllllllllllllIIIllIIIIll);
            this.coordBaseMode = lllllllllllllllllllllIIIllIIIllI;
            this.boundingBox = lllllllllllllllllllllIIIllIIIlll;
            this.averageGroundLevel = Math.max(lllllllllllllllllllllIIIllIIIlll.getXSize(), lllllllllllllllllllllIIIllIIIlll.getZSize());
        }
        
        public Path() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllllllllIIIIlllllII, final Random lllllllllllllllllllllIIIIllllIll, final StructureBoundingBox lllllllllllllllllllllIIIIlllIIlI) {
            final IBlockState lllllllllllllllllllllIIIIllllIIl = this.func_175847_a(Blocks.gravel.getDefaultState());
            final IBlockState lllllllllllllllllllllIIIIllllIII = this.func_175847_a(Blocks.cobblestone.getDefaultState());
            for (int lllllllllllllllllllllIIIIlllIlll = this.boundingBox.minX; lllllllllllllllllllllIIIIlllIlll <= this.boundingBox.maxX; ++lllllllllllllllllllllIIIIlllIlll) {
                for (int lllllllllllllllllllllIIIIlllIllI = this.boundingBox.minZ; lllllllllllllllllllllIIIIlllIllI <= this.boundingBox.maxZ; ++lllllllllllllllllllllIIIIlllIllI) {
                    BlockPos lllllllllllllllllllllIIIIlllIlIl = new BlockPos(lllllllllllllllllllllIIIIlllIlll, 64, lllllllllllllllllllllIIIIlllIllI);
                    if (lllllllllllllllllllllIIIIlllIIlI.func_175898_b(lllllllllllllllllllllIIIIlllIlIl)) {
                        lllllllllllllllllllllIIIIlllIlIl = lllllllllllllllllllllIIIIlllllII.func_175672_r(lllllllllllllllllllllIIIIlllIlIl).offsetDown();
                        lllllllllllllllllllllIIIIlllllII.setBlockState(lllllllllllllllllllllIIIIlllIlIl, lllllllllllllllllllllIIIIllllIIl, 2);
                        lllllllllllllllllllllIIIIlllllII.setBlockState(lllllllllllllllllllllIIIIlllIlIl.offsetDown(), lllllllllllllllllllllIIIIllllIII, 2);
                    }
                }
            }
            return true;
        }
        
        public static StructureBoundingBox func_175848_a(final Start lllllllllllllllllllllIIIlIIlIllI, final List lllllllllllllllllllllIIIlIIIllIl, final Random lllllllllllllllllllllIIIlIIIllII, final int lllllllllllllllllllllIIIlIIlIIll, final int lllllllllllllllllllllIIIlIIlIIlI, final int lllllllllllllllllllllIIIlIIIlIIl, final EnumFacing lllllllllllllllllllllIIIlIIIlIII) {
            for (int lllllllllllllllllllllIIIlIIIllll = 7 * MathHelper.getRandomIntegerInRange(lllllllllllllllllllllIIIlIIIllII, 3, 5); lllllllllllllllllllllIIIlIIIllll >= 7; lllllllllllllllllllllIIIlIIIllll -= 7) {
                final StructureBoundingBox lllllllllllllllllllllIIIlIIIlllI = StructureBoundingBox.func_175897_a(lllllllllllllllllllllIIIlIIlIIll, lllllllllllllllllllllIIIlIIlIIlI, lllllllllllllllllllllIIIlIIIlIIl, 0, 0, 0, 3, 3, lllllllllllllllllllllIIIlIIIllll, lllllllllllllllllllllIIIlIIIlIII);
                if (StructureComponent.findIntersecting(lllllllllllllllllllllIIIlIIIllIl, lllllllllllllllllllllIIIlIIIlllI) == null) {
                    return lllllllllllllllllllllIIIlIIIlllI;
                }
            }
            return null;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllllllllIIIlIllIlIl) {
            super.readStructureFromNBT(lllllllllllllllllllllIIIlIllIlIl);
            this.averageGroundLevel = lllllllllllllllllllllIIIlIllIlIl.getInteger("Length");
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllllllllIIIlIllllIl) {
            super.writeStructureToNBT(lllllllllllllllllllllIIIlIllllIl);
            lllllllllllllllllllllIIIlIllllIl.setInteger("Length", this.averageGroundLevel);
        }
    }
    
    public static class House3 extends Village
    {
        static {
            __OBFID = "CL_00000530";
        }
        
        public House3(final Start lllllllllllllllIllIIIIllIlIlllII, final int lllllllllllllllIllIIIIllIlIllIlI, final Random lllllllllllllllIllIIIIllIllIIlII, final StructureBoundingBox lllllllllllllllIllIIIIllIlIllIII, final EnumFacing lllllllllllllllIllIIIIllIlIlIllI) {
            super(lllllllllllllllIllIIIIllIlIlllII, lllllllllllllllIllIIIIllIlIllIlI);
            this.coordBaseMode = lllllllllllllllIllIIIIllIlIlIllI;
            this.boundingBox = lllllllllllllllIllIIIIllIlIllIII;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIllIIIIllIIIlIlll, final Random lllllllllllllllIllIIIIllIIIlIllI, final StructureBoundingBox lllllllllllllllIllIIIIllIIIlIlIl) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 7 - 1, 0);
            }
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 1, 1, 1, 7, 4, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 2, 1, 6, 8, 4, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 2, 0, 5, 8, 0, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 1, 0, 1, 7, 0, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 0, 0, 0, 0, 3, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 8, 0, 0, 8, 3, 10, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 1, 0, 0, 7, 2, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 1, 0, 5, 2, 1, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 2, 0, 6, 2, 3, 10, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 3, 0, 10, 7, 3, 10, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 1, 2, 0, 7, 3, 0, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 1, 2, 5, 2, 3, 5, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 0, 4, 1, 8, 4, 1, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 0, 4, 4, 3, 4, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 0, 5, 2, 8, 5, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.planks.getDefaultState(), 0, 4, 2, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.planks.getDefaultState(), 0, 4, 3, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.planks.getDefaultState(), 8, 4, 2, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.planks.getDefaultState(), 8, 4, 3, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.planks.getDefaultState(), 8, 4, 4, lllllllllllllllIllIIIIllIIIlIlIl);
            final int lllllllllllllllIllIIIIllIIlIIIlI = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            final int lllllllllllllllIllIIIIllIIlIIIIl = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
            for (int lllllllllllllllIllIIIIllIIlIIIII = -1; lllllllllllllllIllIIIIllIIlIIIII <= 2; ++lllllllllllllllIllIIIIllIIlIIIII) {
                for (int lllllllllllllllIllIIIIllIIIlllll = 0; lllllllllllllllIllIIIIllIIIlllll <= 8; ++lllllllllllllllIllIIIIllIIIlllll) {
                    this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIllIIIIllIIlIIIlI), lllllllllllllllIllIIIIllIIIlllll, 4 + lllllllllllllllIllIIIIllIIlIIIII, lllllllllllllllIllIIIIllIIlIIIII, lllllllllllllllIllIIIIllIIIlIlIl);
                    if ((lllllllllllllllIllIIIIllIIlIIIII > -1 || lllllllllllllllIllIIIIllIIIlllll <= 1) && (lllllllllllllllIllIIIIllIIlIIIII > 0 || lllllllllllllllIllIIIIllIIIlllll <= 3) && (lllllllllllllllIllIIIIllIIlIIIII > 1 || lllllllllllllllIllIIIIllIIIlllll <= 4 || lllllllllllllllIllIIIIllIIIlllll >= 6)) {
                        this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIllIIIIllIIlIIIIl), lllllllllllllllIllIIIIllIIIlllll, 4 + lllllllllllllllIllIIIIllIIlIIIII, 5 - lllllllllllllllIllIIIIllIIlIIIII, lllllllllllllllIllIIIIllIIIlIlIl);
                    }
                }
            }
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 3, 4, 5, 3, 4, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 7, 4, 2, 7, 4, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 4, 5, 4, 4, 5, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 6, 5, 4, 6, 5, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 5, 6, 3, 5, 6, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            int lllllllllllllllIllIIIIllIIlIIIII = this.getMetadataWithOffset(Blocks.oak_stairs, 0);
            for (int lllllllllllllllIllIIIIllIIIllllI = 4; lllllllllllllllIllIIIIllIIIllllI >= 1; --lllllllllllllllIllIIIIllIIIllllI) {
                this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.planks.getDefaultState(), lllllllllllllllIllIIIIllIIIllllI, 2 + lllllllllllllllIllIIIIllIIIllllI, 7 - lllllllllllllllIllIIIIllIIIllllI, lllllllllllllllIllIIIIllIIIlIlIl);
                for (int lllllllllllllllIllIIIIllIIIlllIl = 8 - lllllllllllllllIllIIIIllIIIllllI; lllllllllllllllIllIIIIllIIIlllIl <= 10; ++lllllllllllllllIllIIIIllIIIlllIl) {
                    this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIllIIIIllIIlIIIII), lllllllllllllllIllIIIIllIIIllllI, 2 + lllllllllllllllIllIIIIllIIIllllI, lllllllllllllllIllIIIIllIIIlllIl, lllllllllllllllIllIIIIllIIIlIlIl);
                }
            }
            int lllllllllllllllIllIIIIllIIIllllI = this.getMetadataWithOffset(Blocks.oak_stairs, 1);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.planks.getDefaultState(), 6, 6, 3, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.planks.getDefaultState(), 7, 5, 4, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIllIIIIllIIIllllI), 6, 6, 4, lllllllllllllllIllIIIIllIIIlIlIl);
            for (int lllllllllllllllIllIIIIllIIIlllII = 6; lllllllllllllllIllIIIIllIIIlllII <= 8; ++lllllllllllllllIllIIIIllIIIlllII) {
                for (int lllllllllllllllIllIIIIllIIIllIll = 5; lllllllllllllllIllIIIIllIIIllIll <= 10; ++lllllllllllllllIllIIIIllIIIllIll) {
                    this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.oak_stairs.getStateFromMeta(lllllllllllllllIllIIIIllIIIllllI), lllllllllllllllIllIIIIllIIIlllII, 12 - lllllllllllllllIllIIIIllIIIlllII, lllllllllllllllIllIIIIllIIIllIll, lllllllllllllllIllIIIIllIIIlIlIl);
                }
            }
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 0, 2, 1, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 0, 2, 4, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.glass_pane.getDefaultState(), 0, 2, 2, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.glass_pane.getDefaultState(), 0, 2, 3, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 4, 2, 0, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.glass_pane.getDefaultState(), 5, 2, 0, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 6, 2, 0, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 8, 2, 1, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.glass_pane.getDefaultState(), 8, 2, 2, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.glass_pane.getDefaultState(), 8, 2, 3, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 8, 2, 4, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.planks.getDefaultState(), 8, 2, 5, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 8, 2, 6, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.glass_pane.getDefaultState(), 8, 2, 7, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.glass_pane.getDefaultState(), 8, 2, 8, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 8, 2, 9, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 2, 2, 6, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.glass_pane.getDefaultState(), 2, 2, 7, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.glass_pane.getDefaultState(), 2, 2, 8, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 2, 2, 9, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 4, 4, 10, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.glass_pane.getDefaultState(), 5, 4, 10, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.log.getDefaultState(), 6, 4, 10, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.planks.getDefaultState(), 5, 5, 10, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.air.getDefaultState(), 2, 1, 0, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.air.getDefaultState(), 2, 2, 0, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode), 2, 3, 1, lllllllllllllllIllIIIIllIIIlIlIl);
            this.func_175810_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, lllllllllllllllIllIIIIllIIIlIllI, 2, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            this.func_175804_a(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 1, 0, -1, 3, 2, -1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            if (this.func_175807_a(lllllllllllllllIllIIIIllIIIlIlll, 2, 0, -1, lllllllllllllllIllIIIIllIIIlIlIl).getBlock().getMaterial() == Material.air && this.func_175807_a(lllllllllllllllIllIIIIllIIIlIlll, 2, -1, -1, lllllllllllllllIllIIIIllIIIlIlIl).getBlock().getMaterial() != Material.air) {
                this.func_175811_a(lllllllllllllllIllIIIIllIIIlIlll, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 2, 0, -1, lllllllllllllllIllIIIIllIIIlIlIl);
            }
            for (int lllllllllllllllIllIIIIllIIIlllII = 0; lllllllllllllllIllIIIIllIIIlllII < 5; ++lllllllllllllllIllIIIIllIIIlllII) {
                for (int lllllllllllllllIllIIIIllIIIllIlI = 0; lllllllllllllllIllIIIIllIIIllIlI < 9; ++lllllllllllllllIllIIIIllIIIllIlI) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIllIlI, 7, lllllllllllllllIllIIIIllIIIlllII, lllllllllllllllIllIIIIllIIIlIlIl);
                    this.func_175808_b(lllllllllllllllIllIIIIllIIIlIlll, Blocks.cobblestone.getDefaultState(), lllllllllllllllIllIIIIllIIIllIlI, -1, lllllllllllllllIllIIIIllIIIlllII, lllllllllllllllIllIIIIllIIIlIlIl);
                }
            }
            for (int lllllllllllllllIllIIIIllIIIlllII = 5; lllllllllllllllIllIIIIllIIIlllII < 11; ++lllllllllllllllIllIIIIllIIIlllII) {
                for (int lllllllllllllllIllIIIIllIIIllIIl = 2; lllllllllllllllIllIIIIllIIIllIIl < 9; ++lllllllllllllllIllIIIIllIIIllIIl) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIllIIl, 7, lllllllllllllllIllIIIIllIIIlllII, lllllllllllllllIllIIIIllIIIlIlIl);
                    this.func_175808_b(lllllllllllllllIllIIIIllIIIlIlll, Blocks.cobblestone.getDefaultState(), lllllllllllllllIllIIIIllIIIllIIl, -1, lllllllllllllllIllIIIIllIIIlllII, lllllllllllllllIllIIIIllIIIlIlIl);
                }
            }
            this.spawnVillagers(lllllllllllllllIllIIIIllIIIlIlll, lllllllllllllllIllIIIIllIIIlIlIl, 4, 1, 2, 2);
            return true;
        }
        
        public static House3 func_175849_a(final Start lllllllllllllllIllIIIIllIlIIIlIl, final List lllllllllllllllIllIIIIllIIlllIII, final Random lllllllllllllllIllIIIIllIIllIlll, final int lllllllllllllllIllIIIIllIIllIllI, final int lllllllllllllllIllIIIIllIIllIlIl, final int lllllllllllllllIllIIIIllIIllIlII, final EnumFacing lllllllllllllllIllIIIIllIIllllII, final int lllllllllllllllIllIIIIllIIlllIll) {
            final StructureBoundingBox lllllllllllllllIllIIIIllIIlllIlI = StructureBoundingBox.func_175897_a(lllllllllllllllIllIIIIllIIllIllI, lllllllllllllllIllIIIIllIIllIlIl, lllllllllllllllIllIIIIllIIllIlII, 0, 0, 0, 9, 7, 12, lllllllllllllllIllIIIIllIIllllII);
            return (Village.canVillageGoDeeper(lllllllllllllllIllIIIIllIIlllIlI) && StructureComponent.findIntersecting(lllllllllllllllIllIIIIllIIlllIII, lllllllllllllllIllIIIIllIIlllIlI) == null) ? new House3(lllllllllllllllIllIIIIllIlIIIlIl, lllllllllllllllIllIIIIllIIlllIll, lllllllllllllllIllIIIIllIIllIlll, lllllllllllllllIllIIIIllIIlllIlI, lllllllllllllllIllIIIIllIIllllII) : null;
        }
        
        public House3() {
        }
    }
    
    public static class WoodHut extends Village
    {
        private /* synthetic */ boolean isTallHouse;
        private /* synthetic */ int tablePosition;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIlIllIIllIllIllIlI) {
            super.writeStructureToNBT(llllllllllllllIlIllIIllIllIllIlI);
            llllllllllllllIlIllIIllIllIllIlI.setInteger("T", this.tablePosition);
            llllllllllllllIlIllIIllIllIllIlI.setBoolean("C", this.isTallHouse);
        }
        
        static {
            __OBFID = "CL_00000524";
        }
        
        public WoodHut() {
        }
        
        public WoodHut(final Start llllllllllllllIlIllIIllIlllIIIlI, final int llllllllllllllIlIllIIllIlllIIlll, final Random llllllllllllllIlIllIIllIlllIIIII, final StructureBoundingBox llllllllllllllIlIllIIllIllIlllll, final EnumFacing llllllllllllllIlIllIIllIlllIIlII) {
            super(llllllllllllllIlIllIIllIlllIIIlI, llllllllllllllIlIllIIllIlllIIlll);
            this.coordBaseMode = llllllllllllllIlIllIIllIlllIIlII;
            this.boundingBox = llllllllllllllIlIllIIllIllIlllll;
            this.isTallHouse = llllllllllllllIlIllIIllIlllIIIII.nextBoolean();
            this.tablePosition = llllllllllllllIlIllIIllIlllIIIII.nextInt(3);
        }
        
        public static WoodHut func_175853_a(final Start llllllllllllllIlIllIIllIllIIlIII, final List llllllllllllllIlIllIIllIlIlllllI, final Random llllllllllllllIlIllIIllIlIllllIl, final int llllllllllllllIlIllIIllIlIllllII, final int llllllllllllllIlIllIIllIllIIIlII, final int llllllllllllllIlIllIIllIlIlllIlI, final EnumFacing llllllllllllllIlIllIIllIlIlllIIl, final int llllllllllllllIlIllIIllIllIIIIIl) {
            final StructureBoundingBox llllllllllllllIlIllIIllIllIIIIII = StructureBoundingBox.func_175897_a(llllllllllllllIlIllIIllIlIllllII, llllllllllllllIlIllIIllIllIIIlII, llllllllllllllIlIllIIllIlIlllIlI, 0, 0, 0, 4, 6, 5, llllllllllllllIlIllIIllIlIlllIIl);
            return (Village.canVillageGoDeeper(llllllllllllllIlIllIIllIllIIIIII) && StructureComponent.findIntersecting(llllllllllllllIlIllIIllIlIlllllI, llllllllllllllIlIllIIllIllIIIIII) == null) ? new WoodHut(llllllllllllllIlIllIIllIllIIlIII, llllllllllllllIlIllIIllIllIIIIIl, llllllllllllllIlIllIIllIlIllllIl, llllllllllllllIlIllIIllIllIIIIII, llllllllllllllIlIllIIllIlIlllIIl) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIllIIllIlIlIlIIl, final Random llllllllllllllIlIllIIllIlIlIlllI, final StructureBoundingBox llllllllllllllIlIllIIllIlIlIIlll) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
            }
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 1, 1, 1, 3, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 0, 0, 0, 3, 0, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 1, 0, 1, 2, 0, 3, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
            if (this.isTallHouse) {
                this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 1, 4, 1, 2, 4, 3, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            }
            else {
                this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 1, 5, 1, 2, 5, 3, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            }
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.log.getDefaultState(), 1, 4, 0, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.log.getDefaultState(), 2, 4, 0, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.log.getDefaultState(), 1, 4, 4, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.log.getDefaultState(), 2, 4, 4, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.log.getDefaultState(), 0, 4, 1, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.log.getDefaultState(), 0, 4, 2, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.log.getDefaultState(), 0, 4, 3, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.log.getDefaultState(), 3, 4, 1, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.log.getDefaultState(), 3, 4, 2, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.log.getDefaultState(), 3, 4, 3, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 0, 1, 0, 0, 3, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 3, 1, 0, 3, 3, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 0, 1, 4, 0, 3, 4, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 3, 1, 4, 3, 3, 4, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 0, 1, 1, 0, 3, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 3, 1, 1, 3, 3, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 1, 1, 0, 2, 3, 0, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 1, 1, 4, 2, 3, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.glass_pane.getDefaultState(), 0, 2, 2, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.glass_pane.getDefaultState(), 3, 2, 2, llllllllllllllIlIllIIllIlIlIIlll);
            if (this.tablePosition > 0) {
                this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.oak_fence.getDefaultState(), this.tablePosition, 1, 3, llllllllllllllIlIllIIllIlIlIIlll);
                this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.wooden_pressure_plate.getDefaultState(), this.tablePosition, 2, 3, llllllllllllllIlIllIIllIlIlIIlll);
            }
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.air.getDefaultState(), 1, 1, 0, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.air.getDefaultState(), 1, 2, 0, llllllllllllllIlIllIIllIlIlIIlll);
            this.func_175810_a(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, llllllllllllllIlIllIIllIlIlIlllI, 1, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            if (this.func_175807_a(llllllllllllllIlIllIIllIlIlIlIIl, 1, 0, -1, llllllllllllllIlIllIIllIlIlIIlll).getBlock().getMaterial() == Material.air && this.func_175807_a(llllllllllllllIlIllIIllIlIlIlIIl, 1, -1, -1, llllllllllllllIlIllIIllIlIlIIlll).getBlock().getMaterial() != Material.air) {
                this.func_175811_a(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 1, 0, -1, llllllllllllllIlIllIIllIlIlIIlll);
            }
            for (int llllllllllllllIlIllIIllIlIlIllII = 0; llllllllllllllIlIllIIllIlIlIllII < 5; ++llllllllllllllIlIllIIllIlIlIllII) {
                for (int llllllllllllllIlIllIIllIlIlIlIll = 0; llllllllllllllIlIllIIllIlIlIlIll < 4; ++llllllllllllllIlIllIIllIlIlIlIll) {
                    this.clearCurrentPositionBlocksUpwards(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIlIll, 6, llllllllllllllIlIllIIllIlIlIllII, llllllllllllllIlIllIIllIlIlIIlll);
                    this.func_175808_b(llllllllllllllIlIllIIllIlIlIlIIl, Blocks.cobblestone.getDefaultState(), llllllllllllllIlIllIIllIlIlIlIll, -1, llllllllllllllIlIllIIllIlIlIllII, llllllllllllllIlIllIIllIlIlIIlll);
                }
            }
            this.spawnVillagers(llllllllllllllIlIllIIllIlIlIlIIl, llllllllllllllIlIllIIllIlIlIIlll, 1, 1, 2, 1);
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIlIllIIllIllIlIIlI) {
            super.readStructureFromNBT(llllllllllllllIlIllIIllIllIlIIlI);
            this.tablePosition = llllllllllllllIlIllIIllIllIlIIlI.getInteger("T");
            this.isTallHouse = llllllllllllllIlIllIIllIllIlIIlI.getBoolean("C");
        }
    }
    
    public static class Field1 extends Village
    {
        private /* synthetic */ Block cropTypeD;
        private /* synthetic */ Block cropTypeA;
        private /* synthetic */ Block cropTypeB;
        private /* synthetic */ Block cropTypeC;
        
        private Block func_151559_a(final Random lllllllllllllllllIlIIIIIIIllIIlI) {
            switch (lllllllllllllllllIlIIIIIIIllIIlI.nextInt(5)) {
                case 0: {
                    return Blocks.carrots;
                }
                case 1: {
                    return Blocks.potatoes;
                }
                default: {
                    return Blocks.wheat;
                }
            }
        }
        
        static {
            __OBFID = "CL_00000518";
        }
        
        public Field1() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllllIlIIIIIIIlllllI) {
            super.writeStructureToNBT(lllllllllllllllllIlIIIIIIIlllllI);
            lllllllllllllllllIlIIIIIIIlllllI.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
            lllllllllllllllllIlIIIIIIIlllllI.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
            lllllllllllllllllIlIIIIIIIlllllI.setInteger("CC", Block.blockRegistry.getIDForObject(this.cropTypeC));
            lllllllllllllllllIlIIIIIIIlllllI.setInteger("CD", Block.blockRegistry.getIDForObject(this.cropTypeD));
        }
        
        public static Field1 func_175851_a(final Start lllllllllllllllllIlIIIIIIIlIlIII, final List lllllllllllllllllIlIIIIIIIIllllI, final Random lllllllllllllllllIlIIIIIIIlIIllI, final int lllllllllllllllllIlIIIIIIIIlllII, final int lllllllllllllllllIlIIIIIIIIllIll, final int lllllllllllllllllIlIIIIIIIIllIlI, final EnumFacing lllllllllllllllllIlIIIIIIIlIIIlI, final int lllllllllllllllllIlIIIIIIIlIIIIl) {
            final StructureBoundingBox lllllllllllllllllIlIIIIIIIlIIIII = StructureBoundingBox.func_175897_a(lllllllllllllllllIlIIIIIIIIlllII, lllllllllllllllllIlIIIIIIIIllIll, lllllllllllllllllIlIIIIIIIIllIlI, 0, 0, 0, 13, 4, 9, lllllllllllllllllIlIIIIIIIlIIIlI);
            return (Village.canVillageGoDeeper(lllllllllllllllllIlIIIIIIIlIIIII) && StructureComponent.findIntersecting(lllllllllllllllllIlIIIIIIIIllllI, lllllllllllllllllIlIIIIIIIlIIIII) == null) ? new Field1(lllllllllllllllllIlIIIIIIIlIlIII, lllllllllllllllllIlIIIIIIIlIIIIl, lllllllllllllllllIlIIIIIIIlIIllI, lllllllllllllllllIlIIIIIIIlIIIII, lllllllllllllllllIlIIIIIIIlIIIlI) : null;
        }
        
        public Field1(final Start lllllllllllllllllIlIIIIIIlIIIllI, final int lllllllllllllllllIlIIIIIIlIIIlIl, final Random lllllllllllllllllIlIIIIIIlIIlIlI, final StructureBoundingBox lllllllllllllllllIlIIIIIIlIIlIIl, final EnumFacing lllllllllllllllllIlIIIIIIlIIlIII) {
            super(lllllllllllllllllIlIIIIIIlIIIllI, lllllllllllllllllIlIIIIIIlIIIlIl);
            this.coordBaseMode = lllllllllllllllllIlIIIIIIlIIlIII;
            this.boundingBox = lllllllllllllllllIlIIIIIIlIIlIIl;
            this.cropTypeA = this.func_151559_a(lllllllllllllllllIlIIIIIIlIIlIlI);
            this.cropTypeB = this.func_151559_a(lllllllllllllllllIlIIIIIIlIIlIlI);
            this.cropTypeC = this.func_151559_a(lllllllllllllllllIlIIIIIIlIIlIlI);
            this.cropTypeD = this.func_151559_a(lllllllllllllllllIlIIIIIIlIIlIlI);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllllIlIIIIIIIIIllll, final Random lllllllllllllllllIlIIIIIIIIIlllI, final StructureBoundingBox lllllllllllllllllIlIIIIIIIIIllIl) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
            }
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 0, 1, 0, 12, 4, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 1, 0, 1, 2, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 4, 0, 1, 5, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 7, 0, 1, 8, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 10, 0, 1, 11, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 0, 0, 0, 0, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 6, 0, 0, 6, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 12, 0, 0, 12, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 1, 0, 0, 11, 0, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 1, 0, 8, 11, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 3, 0, 1, 3, 0, 7, Blocks.water.getDefaultState(), Blocks.water.getDefaultState(), false);
            this.func_175804_a(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIllIl, 9, 0, 1, 9, 0, 7, Blocks.water.getDefaultState(), Blocks.water.getDefaultState(), false);
            for (int lllllllllllllllllIlIIIIIIIIIllII = 1; lllllllllllllllllIlIIIIIIIIIllII <= 7; ++lllllllllllllllllIlIIIIIIIIIllII) {
                this.func_175811_a(lllllllllllllllllIlIIIIIIIIIllll, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(lllllllllllllllllIlIIIIIIIIIlllI, 2, 7)), 1, 1, lllllllllllllllllIlIIIIIIIIIllII, lllllllllllllllllIlIIIIIIIIIllIl);
                this.func_175811_a(lllllllllllllllllIlIIIIIIIIIllll, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(lllllllllllllllllIlIIIIIIIIIlllI, 2, 7)), 2, 1, lllllllllllllllllIlIIIIIIIIIllII, lllllllllllllllllIlIIIIIIIIIllIl);
                this.func_175811_a(lllllllllllllllllIlIIIIIIIIIllll, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(lllllllllllllllllIlIIIIIIIIIlllI, 2, 7)), 4, 1, lllllllllllllllllIlIIIIIIIIIllII, lllllllllllllllllIlIIIIIIIIIllIl);
                this.func_175811_a(lllllllllllllllllIlIIIIIIIIIllll, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(lllllllllllllllllIlIIIIIIIIIlllI, 2, 7)), 5, 1, lllllllllllllllllIlIIIIIIIIIllII, lllllllllllllllllIlIIIIIIIIIllIl);
                this.func_175811_a(lllllllllllllllllIlIIIIIIIIIllll, this.cropTypeC.getStateFromMeta(MathHelper.getRandomIntegerInRange(lllllllllllllllllIlIIIIIIIIIlllI, 2, 7)), 7, 1, lllllllllllllllllIlIIIIIIIIIllII, lllllllllllllllllIlIIIIIIIIIllIl);
                this.func_175811_a(lllllllllllllllllIlIIIIIIIIIllll, this.cropTypeC.getStateFromMeta(MathHelper.getRandomIntegerInRange(lllllllllllllllllIlIIIIIIIIIlllI, 2, 7)), 8, 1, lllllllllllllllllIlIIIIIIIIIllII, lllllllllllllllllIlIIIIIIIIIllIl);
                this.func_175811_a(lllllllllllllllllIlIIIIIIIIIllll, this.cropTypeD.getStateFromMeta(MathHelper.getRandomIntegerInRange(lllllllllllllllllIlIIIIIIIIIlllI, 2, 7)), 10, 1, lllllllllllllllllIlIIIIIIIIIllII, lllllllllllllllllIlIIIIIIIIIllIl);
                this.func_175811_a(lllllllllllllllllIlIIIIIIIIIllll, this.cropTypeD.getStateFromMeta(MathHelper.getRandomIntegerInRange(lllllllllllllllllIlIIIIIIIIIlllI, 2, 7)), 11, 1, lllllllllllllllllIlIIIIIIIIIllII, lllllllllllllllllIlIIIIIIIIIllIl);
            }
            for (int lllllllllllllllllIlIIIIIIIIIllII = 0; lllllllllllllllllIlIIIIIIIIIllII < 9; ++lllllllllllllllllIlIIIIIIIIIllII) {
                for (int lllllllllllllllllIlIIIIIIIIIlIll = 0; lllllllllllllllllIlIIIIIIIIIlIll < 13; ++lllllllllllllllllIlIIIIIIIIIlIll) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllllllIlIIIIIIIIIllll, lllllllllllllllllIlIIIIIIIIIlIll, 4, lllllllllllllllllIlIIIIIIIIIllII, lllllllllllllllllIlIIIIIIIIIllIl);
                    this.func_175808_b(lllllllllllllllllIlIIIIIIIIIllll, Blocks.dirt.getDefaultState(), lllllllllllllllllIlIIIIIIIIIlIll, -1, lllllllllllllllllIlIIIIIIIIIllII, lllllllllllllllllIlIIIIIIIIIllIl);
                }
            }
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllllIlIIIIIIIlllIII) {
            super.readStructureFromNBT(lllllllllllllllllIlIIIIIIIlllIII);
            this.cropTypeA = Block.getBlockById(lllllllllllllllllIlIIIIIIIlllIII.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(lllllllllllllllllIlIIIIIIIlllIII.getInteger("CB"));
            this.cropTypeC = Block.getBlockById(lllllllllllllllllIlIIIIIIIlllIII.getInteger("CC"));
            this.cropTypeD = Block.getBlockById(lllllllllllllllllIlIIIIIIIlllIII.getInteger("CD"));
        }
    }
    
    public static class Hall extends Village
    {
        public Hall(final Start llllllllllllllIIIlllIllIIIlIIIIl, final int llllllllllllllIIIlllIllIIIIlIIll, final Random llllllllllllllIIIlllIllIIIIlllIl, final StructureBoundingBox llllllllllllllIIIlllIllIIIIlIIIl, final EnumFacing llllllllllllllIIIlllIllIIIIIllll) {
            super(llllllllllllllIIIlllIllIIIlIIIIl, llllllllllllllIIIlllIllIIIIlIIll);
            this.coordBaseMode = llllllllllllllIIIlllIllIIIIIllll;
            this.boundingBox = llllllllllllllIIIlllIllIIIIlIIIl;
        }
        
        public Hall() {
        }
        
        public static Hall func_175857_a(final Start llllllllllllllIIIlllIlIllllIlIIl, final List llllllllllllllIIIlllIlIlllllIIIl, final Random llllllllllllllIIIlllIlIllllIIlll, final int llllllllllllllIIIlllIlIllllIllll, final int llllllllllllllIIIlllIlIllllIIlII, final int llllllllllllllIIIlllIlIllllIIIlI, final EnumFacing llllllllllllllIIIlllIlIllllIllII, final int llllllllllllllIIIlllIlIlllIlllll) {
            final StructureBoundingBox llllllllllllllIIIlllIlIllllIlIlI = StructureBoundingBox.func_175897_a(llllllllllllllIIIlllIlIllllIllll, llllllllllllllIIIlllIlIllllIIlII, llllllllllllllIIIlllIlIllllIIIlI, 0, 0, 0, 9, 7, 11, llllllllllllllIIIlllIlIllllIllII);
            return (Village.canVillageGoDeeper(llllllllllllllIIIlllIlIllllIlIlI) && StructureComponent.findIntersecting(llllllllllllllIIIlllIlIlllllIIIl, llllllllllllllIIIlllIlIllllIlIlI) == null) ? new Hall(llllllllllllllIIIlllIlIllllIlIIl, llllllllllllllIIIlllIlIlllIlllll, llllllllllllllIIIlllIlIllllIIlll, llllllllllllllIIIlllIlIllllIlIlI, llllllllllllllIIIlllIlIllllIllII) : null;
        }
        
        @Override
        protected int func_180779_c(final int llllllllllllllIIIlllIlIlIlIlIlII, final int llllllllllllllIIIlllIlIlIlIlIIlI) {
            return (llllllllllllllIIIlllIlIlIlIlIlII == 0) ? 4 : super.func_180779_c(llllllllllllllIIIlllIlIlIlIlIlII, llllllllllllllIIIlllIlIlIlIlIIlI);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIIlllIlIlIllIlIII, final Random llllllllllllllIIIlllIlIlIllllIII, final StructureBoundingBox llllllllllllllIIIlllIlIlIlllIllI) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 7 - 1, 0);
            }
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 1, 1, 1, 7, 4, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 2, 1, 6, 8, 4, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 2, 0, 6, 8, 0, 10, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.cobblestone.getDefaultState(), 6, 0, 6, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 2, 1, 6, 2, 1, 10, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 8, 1, 6, 8, 1, 10, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 3, 1, 10, 7, 1, 10, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 1, 0, 1, 7, 0, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 0, 0, 0, 0, 3, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 8, 0, 0, 8, 3, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 1, 0, 0, 7, 1, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 1, 0, 5, 7, 1, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 1, 2, 0, 7, 3, 0, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 1, 2, 5, 7, 3, 5, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 0, 4, 1, 8, 4, 1, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 0, 4, 4, 8, 4, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 0, 5, 2, 8, 5, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.planks.getDefaultState(), 0, 4, 2, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.planks.getDefaultState(), 0, 4, 3, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.planks.getDefaultState(), 8, 4, 2, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.planks.getDefaultState(), 8, 4, 3, llllllllllllllIIIlllIlIlIlllIllI);
            final int llllllllllllllIIIlllIlIlIlllIlII = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            final int llllllllllllllIIIlllIlIlIlllIIlI = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
            for (int llllllllllllllIIIlllIlIlIlllIIII = -1; llllllllllllllIIIlllIlIlIlllIIII <= 2; ++llllllllllllllIIIlllIlIlIlllIIII) {
                for (int llllllllllllllIIIlllIlIlIllIlllI = 0; llllllllllllllIIIlllIlIlIllIlllI <= 8; ++llllllllllllllIIIlllIlIlIllIlllI) {
                    this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.oak_stairs.getStateFromMeta(llllllllllllllIIIlllIlIlIlllIlII), llllllllllllllIIIlllIlIlIllIlllI, 4 + llllllllllllllIIIlllIlIlIlllIIII, llllllllllllllIIIlllIlIlIlllIIII, llllllllllllllIIIlllIlIlIlllIllI);
                    this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.oak_stairs.getStateFromMeta(llllllllllllllIIIlllIlIlIlllIIlI), llllllllllllllIIIlllIlIlIllIlllI, 4 + llllllllllllllIIIlllIlIlIlllIIII, 5 - llllllllllllllIIIlllIlIlIlllIIII, llllllllllllllIIIlllIlIlIlllIllI);
                }
            }
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.log.getDefaultState(), 0, 2, 1, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.log.getDefaultState(), 0, 2, 4, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.log.getDefaultState(), 8, 2, 1, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.log.getDefaultState(), 8, 2, 4, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.glass_pane.getDefaultState(), 0, 2, 2, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.glass_pane.getDefaultState(), 0, 2, 3, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.glass_pane.getDefaultState(), 8, 2, 2, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.glass_pane.getDefaultState(), 8, 2, 3, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.glass_pane.getDefaultState(), 2, 2, 5, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.glass_pane.getDefaultState(), 3, 2, 5, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.glass_pane.getDefaultState(), 5, 2, 0, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.glass_pane.getDefaultState(), 6, 2, 5, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.oak_fence.getDefaultState(), 2, 1, 3, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.wooden_pressure_plate.getDefaultState(), 2, 2, 3, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.planks.getDefaultState(), 1, 1, 4, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.oak_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.oak_stairs, 3)), 2, 1, 4, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.oak_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.oak_stairs, 1)), 1, 1, 3, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175804_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 5, 0, 1, 7, 0, 3, Blocks.double_stone_slab.getDefaultState(), Blocks.double_stone_slab.getDefaultState(), false);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.double_stone_slab.getDefaultState(), 6, 1, 1, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.double_stone_slab.getDefaultState(), 6, 1, 2, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.air.getDefaultState(), 2, 1, 0, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.air.getDefaultState(), 2, 2, 0, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode), 2, 3, 1, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175810_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, llllllllllllllIIIlllIlIlIllllIII, 2, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            if (this.func_175807_a(llllllllllllllIIIlllIlIlIllIlIII, 2, 0, -1, llllllllllllllIIIlllIlIlIlllIllI).getBlock().getMaterial() == Material.air && this.func_175807_a(llllllllllllllIIIlllIlIlIllIlIII, 2, -1, -1, llllllllllllllIIIlllIlIlIlllIllI).getBlock().getMaterial() != Material.air) {
                this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 2, 0, -1, llllllllllllllIIIlllIlIlIlllIllI);
            }
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.air.getDefaultState(), 6, 1, 5, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.air.getDefaultState(), 6, 2, 5, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175811_a(llllllllllllllIIIlllIlIlIllIlIII, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING_PROP, this.coordBaseMode.getOpposite()), 6, 3, 4, llllllllllllllIIIlllIlIlIlllIllI);
            this.func_175810_a(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, llllllllllllllIIIlllIlIlIllllIII, 6, 1, 5, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            for (int llllllllllllllIIIlllIlIlIlllIIII = 0; llllllllllllllIIIlllIlIlIlllIIII < 5; ++llllllllllllllIIIlllIlIlIlllIIII) {
                for (int llllllllllllllIIIlllIlIlIllIllII = 0; llllllllllllllIIIlllIlIlIllIllII < 9; ++llllllllllllllIIIlllIlIlIllIllII) {
                    this.clearCurrentPositionBlocksUpwards(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIllIllII, 7, llllllllllllllIIIlllIlIlIlllIIII, llllllllllllllIIIlllIlIlIlllIllI);
                    this.func_175808_b(llllllllllllllIIIlllIlIlIllIlIII, Blocks.cobblestone.getDefaultState(), llllllllllllllIIIlllIlIlIllIllII, -1, llllllllllllllIIIlllIlIlIlllIIII, llllllllllllllIIIlllIlIlIlllIllI);
                }
            }
            this.spawnVillagers(llllllllllllllIIIlllIlIlIllIlIII, llllllllllllllIIIlllIlIlIlllIllI, 4, 1, 2, 2);
            return true;
        }
        
        static {
            __OBFID = "CL_00000522";
        }
    }
}
