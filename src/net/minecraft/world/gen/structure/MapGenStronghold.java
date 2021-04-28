package net.minecraft.world.gen.structure;

import com.google.common.collect.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.world.*;

public class MapGenStronghold extends MapGenStructure
{
    private /* synthetic */ boolean ranBiomeCheck;
    private /* synthetic */ List field_151546_e;
    private /* synthetic */ double field_82671_h;
    private /* synthetic */ int field_82672_i;
    private /* synthetic */ ChunkCoordIntPair[] structureCoords;
    
    public MapGenStronghold() {
        this.structureCoords = new ChunkCoordIntPair[3];
        this.field_82671_h = 32.0;
        this.field_82672_i = 3;
        this.field_151546_e = Lists.newArrayList();
        for (final BiomeGenBase llllllllllllllIlIlllIIIIlIllllIl : BiomeGenBase.getBiomeGenArray()) {
            if (llllllllllllllIlIlllIIIIlIllllIl != null && llllllllllllllIlIlllIIIIlIllllIl.minHeight > 0.0f) {
                this.field_151546_e.add(llllllllllllllIlIlllIIIIlIllllIl);
            }
        }
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int llllllllllllllIlIlllIIIIlIIIlllI, final int llllllllllllllIlIlllIIIIlIIIllIl) {
        if (!this.ranBiomeCheck) {
            final Random llllllllllllllIlIlllIIIIlIIllIll = new Random();
            llllllllllllllIlIlllIIIIlIIllIll.setSeed(this.worldObj.getSeed());
            double llllllllllllllIlIlllIIIIlIIllIlI = llllllllllllllIlIlllIIIIlIIllIll.nextDouble() * 3.141592653589793 * 2.0;
            int llllllllllllllIlIlllIIIIlIIllIIl = 1;
            for (int llllllllllllllIlIlllIIIIlIIllIII = 0; llllllllllllllIlIlllIIIIlIIllIII < this.structureCoords.length; ++llllllllllllllIlIlllIIIIlIIllIII) {
                final double llllllllllllllIlIlllIIIIlIIlIlll = (1.25 * llllllllllllllIlIlllIIIIlIIllIIl + llllllllllllllIlIlllIIIIlIIllIll.nextDouble()) * this.field_82671_h * llllllllllllllIlIlllIIIIlIIllIIl;
                int llllllllllllllIlIlllIIIIlIIlIllI = (int)Math.round(Math.cos(llllllllllllllIlIlllIIIIlIIllIlI) * llllllllllllllIlIlllIIIIlIIlIlll);
                int llllllllllllllIlIlllIIIIlIIlIlIl = (int)Math.round(Math.sin(llllllllllllllIlIlllIIIIlIIllIlI) * llllllllllllllIlIlllIIIIlIIlIlll);
                final BlockPos llllllllllllllIlIlllIIIIlIIlIlII = this.worldObj.getWorldChunkManager().findBiomePosition((llllllllllllllIlIlllIIIIlIIlIllI << 4) + 8, (llllllllllllllIlIlllIIIIlIIlIlIl << 4) + 8, 112, this.field_151546_e, llllllllllllllIlIlllIIIIlIIllIll);
                if (llllllllllllllIlIlllIIIIlIIlIlII != null) {
                    llllllllllllllIlIlllIIIIlIIlIllI = llllllllllllllIlIlllIIIIlIIlIlII.getX() >> 4;
                    llllllllllllllIlIlllIIIIlIIlIlIl = llllllllllllllIlIlllIIIIlIIlIlII.getZ() >> 4;
                }
                this.structureCoords[llllllllllllllIlIlllIIIIlIIllIII] = new ChunkCoordIntPair(llllllllllllllIlIlllIIIIlIIlIllI, llllllllllllllIlIlllIIIIlIIlIlIl);
                llllllllllllllIlIlllIIIIlIIllIlI += 6.283185307179586 * llllllllllllllIlIlllIIIIlIIllIIl / this.field_82672_i;
                if (llllllllllllllIlIlllIIIIlIIllIII == this.field_82672_i) {
                    llllllllllllllIlIlllIIIIlIIllIIl += 2 + llllllllllllllIlIlllIIIIlIIllIll.nextInt(5);
                    this.field_82672_i += 1 + llllllllllllllIlIlllIIIIlIIllIll.nextInt(2);
                }
            }
            this.ranBiomeCheck = true;
        }
        for (final ChunkCoordIntPair llllllllllllllIlIlllIIIIlIIlIIII : this.structureCoords) {
            if (llllllllllllllIlIlllIIIIlIIIlllI == llllllllllllllIlIlllIIIIlIIlIIII.chunkXPos && llllllllllllllIlIlllIIIIlIIIllIl == llllllllllllllIlIlllIIIIlIIlIIII.chunkZPos) {
                return true;
            }
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00000481";
    }
    
    public MapGenStronghold(final Map llllllllllllllIlIlllIIIIlIlIlllI) {
        this();
        for (final Map.Entry llllllllllllllIlIlllIIIIlIllIIII : llllllllllllllIlIlllIIIIlIlIlllI.entrySet()) {
            if (llllllllllllllIlIlllIIIIlIllIIII.getKey().equals("distance")) {
                this.field_82671_h = MathHelper.parseDoubleWithDefaultAndMax(llllllllllllllIlIlllIIIIlIllIIII.getValue(), this.field_82671_h, 1.0);
            }
            else if (llllllllllllllIlIlllIIIIlIllIIII.getKey().equals("count")) {
                this.structureCoords = new ChunkCoordIntPair[MathHelper.parseIntWithDefaultAndMax(llllllllllllllIlIlllIIIIlIllIIII.getValue(), this.structureCoords.length, 1)];
            }
            else {
                if (!llllllllllllllIlIlllIIIIlIllIIII.getKey().equals("spread")) {
                    continue;
                }
                this.field_82672_i = MathHelper.parseIntWithDefaultAndMax(llllllllllllllIlIlllIIIIlIllIIII.getValue(), this.field_82672_i, 1);
            }
        }
    }
    
    @Override
    public String getStructureName() {
        return "Stronghold";
    }
    
    @Override
    protected List getCoordList() {
        final ArrayList llllllllllllllIlIlllIIIIIlllllII = Lists.newArrayList();
        for (final ChunkCoordIntPair llllllllllllllIlIlllIIIIIllllIII : this.structureCoords) {
            if (llllllllllllllIlIlllIIIIIllllIII != null) {
                llllllllllllllIlIlllIIIIIlllllII.add(llllllllllllllIlIlllIIIIIllllIII.getCenterBlock(64));
            }
        }
        return llllllllllllllIlIlllIIIIIlllllII;
    }
    
    @Override
    protected StructureStart getStructureStart(final int llllllllllllllIlIlllIIIIIllIllII, final int llllllllllllllIlIlllIIIIIllIIlll) {
        Start llllllllllllllIlIlllIIIIIllIlIlI;
        for (llllllllllllllIlIlllIIIIIllIlIlI = new Start(this.worldObj, this.rand, llllllllllllllIlIlllIIIIIllIllII, llllllllllllllIlIlllIIIIIllIIlll); llllllllllllllIlIlllIIIIIllIlIlI.getComponents().isEmpty() || llllllllllllllIlIlllIIIIIllIlIlI.getComponents().get(0).strongholdPortalRoom == null; llllllllllllllIlIlllIIIIIllIlIlI = new Start(this.worldObj, this.rand, llllllllllllllIlIlllIIIIIllIllII, llllllllllllllIlIlllIIIIIllIIlll)) {}
        return llllllllllllllIlIlllIIIIIllIlIlI;
    }
    
    public static class Start extends StructureStart
    {
        public Start() {
        }
        
        static {
            __OBFID = "CL_00000482";
        }
        
        public Start(final World lllllllllllllllIllIlIlIllIlllIIl, final Random lllllllllllllllIllIlIlIlllIIIIIl, final int lllllllllllllllIllIlIlIlllIIIIII, final int lllllllllllllllIllIlIlIllIllllll) {
            super(lllllllllllllllIllIlIlIlllIIIIII, lllllllllllllllIllIlIlIllIllllll);
            StructureStrongholdPieces.prepareStructurePieces();
            final StructureStrongholdPieces.Stairs2 lllllllllllllllIllIlIlIllIlllllI = new StructureStrongholdPieces.Stairs2(0, lllllllllllllllIllIlIlIlllIIIIIl, (lllllllllllllllIllIlIlIlllIIIIII << 4) + 2, (lllllllllllllllIllIlIlIllIllllll << 4) + 2);
            this.components.add(lllllllllllllllIllIlIlIllIlllllI);
            lllllllllllllllIllIlIlIllIlllllI.buildComponent(lllllllllllllllIllIlIlIllIlllllI, this.components, lllllllllllllllIllIlIlIlllIIIIIl);
            final List lllllllllllllllIllIlIlIllIllllIl = lllllllllllllllIllIlIlIllIlllllI.field_75026_c;
            while (!lllllllllllllllIllIlIlIllIllllIl.isEmpty()) {
                final int lllllllllllllllIllIlIlIllIllllII = lllllllllllllllIllIlIlIlllIIIIIl.nextInt(lllllllllllllllIllIlIlIllIllllIl.size());
                final StructureComponent lllllllllllllllIllIlIlIllIlllIll = lllllllllllllllIllIlIlIllIllllIl.remove(lllllllllllllllIllIlIlIllIllllII);
                lllllllllllllllIllIlIlIllIlllIll.buildComponent(lllllllllllllllIllIlIlIllIlllllI, this.components, lllllllllllllllIllIlIlIlllIIIIIl);
            }
            this.updateBoundingBox();
            this.markAvailableHeight(lllllllllllllllIllIlIlIllIlllIIl, lllllllllllllllIllIlIlIlllIIIIIl, 10);
        }
    }
}
