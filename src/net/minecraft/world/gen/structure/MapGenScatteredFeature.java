package net.minecraft.world.gen.structure;

import net.minecraft.world.biome.*;
import com.google.common.collect.*;
import net.minecraft.entity.monster.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class MapGenScatteredFeature extends MapGenStructure
{
    private static final /* synthetic */ List biomelist;
    private /* synthetic */ int minDistanceBetweenScatteredFeatures;
    private /* synthetic */ List scatteredFeatureSpawnList;
    private /* synthetic */ int maxDistanceBetweenScatteredFeatures;
    
    @Override
    protected boolean canSpawnStructureAtCoords(int llllllllllllllllllIlIIIllllIIllI, int llllllllllllllllllIlIIIlllIllIlI) {
        final int llllllllllllllllllIlIIIllllIIlII = llllllllllllllllllIlIIIllllIIllI;
        final int llllllllllllllllllIlIIIllllIIIll = (int)llllllllllllllllllIlIIIlllIllIlI;
        if (llllllllllllllllllIlIIIllllIIllI < 0) {
            llllllllllllllllllIlIIIllllIIllI -= this.maxDistanceBetweenScatteredFeatures - 1;
        }
        if (llllllllllllllllllIlIIIlllIllIlI < 0) {
            llllllllllllllllllIlIIIlllIllIlI -= this.maxDistanceBetweenScatteredFeatures - 1;
        }
        int llllllllllllllllllIlIIIllllIIIlI = llllllllllllllllllIlIIIllllIIllI / this.maxDistanceBetweenScatteredFeatures;
        int llllllllllllllllllIlIIIllllIIIIl = (int)(llllllllllllllllllIlIIIlllIllIlI / this.maxDistanceBetweenScatteredFeatures);
        final Random llllllllllllllllllIlIIIllllIIIII = this.worldObj.setRandomSeed(llllllllllllllllllIlIIIllllIIIlI, llllllllllllllllllIlIIIllllIIIIl, 14357617);
        llllllllllllllllllIlIIIllllIIIlI *= this.maxDistanceBetweenScatteredFeatures;
        llllllllllllllllllIlIIIllllIIIIl *= this.maxDistanceBetweenScatteredFeatures;
        llllllllllllllllllIlIIIllllIIIlI += llllllllllllllllllIlIIIllllIIIII.nextInt(this.maxDistanceBetweenScatteredFeatures - this.minDistanceBetweenScatteredFeatures);
        llllllllllllllllllIlIIIllllIIIIl += llllllllllllllllllIlIIIllllIIIII.nextInt(this.maxDistanceBetweenScatteredFeatures - this.minDistanceBetweenScatteredFeatures);
        if (llllllllllllllllllIlIIIllllIIlII == llllllllllllllllllIlIIIllllIIIlI && llllllllllllllllllIlIIIllllIIIll == llllllllllllllllllIlIIIllllIIIIl) {
            final BiomeGenBase llllllllllllllllllIlIIIlllIlllll = this.worldObj.getWorldChunkManager().func_180631_a(new BlockPos(llllllllllllllllllIlIIIllllIIlII * 16 + 8, 0, llllllllllllllllllIlIIIllllIIIll * 16 + 8));
            if (llllllllllllllllllIlIIIlllIlllll == null) {
                return false;
            }
            for (final BiomeGenBase llllllllllllllllllIlIIIlllIlllIl : MapGenScatteredFeature.biomelist) {
                if (llllllllllllllllllIlIIIlllIlllll == llllllllllllllllllIlIIIlllIlllIl) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public List getScatteredFeatureSpawnList() {
        return this.scatteredFeatureSpawnList;
    }
    
    @Override
    protected StructureStart getStructureStart(final int llllllllllllllllllIlIIIlllIIlIlI, final int llllllllllllllllllIlIIIlllIIllII) {
        return new Start(this.worldObj, this.rand, llllllllllllllllllIlIIIlllIIlIlI, llllllllllllllllllIlIIIlllIIllII);
    }
    
    public boolean func_175798_a(final BlockPos llllllllllllllllllIlIIIlllIIIIll) {
        final StructureStart llllllllllllllllllIlIIIlllIIIIlI = this.func_175797_c(llllllllllllllllllIlIIIlllIIIIll);
        if (llllllllllllllllllIlIIIlllIIIIlI != null && llllllllllllllllllIlIIIlllIIIIlI instanceof Start && !llllllllllllllllllIlIIIlllIIIIlI.components.isEmpty()) {
            final StructureComponent llllllllllllllllllIlIIIlllIIIIIl = llllllllllllllllllIlIIIlllIIIIlI.components.getFirst();
            return llllllllllllllllllIlIIIlllIIIIIl instanceof ComponentScatteredFeaturePieces.SwampHut;
        }
        return false;
    }
    
    @Override
    public String getStructureName() {
        return "Temple";
    }
    
    public MapGenScatteredFeature() {
        this.scatteredFeatureSpawnList = Lists.newArrayList();
        this.maxDistanceBetweenScatteredFeatures = 32;
        this.minDistanceBetweenScatteredFeatures = 8;
        this.scatteredFeatureSpawnList.add(new BiomeGenBase.SpawnListEntry(EntityWitch.class, 1, 1, 1));
    }
    
    static {
        __OBFID = "CL_00000471";
        biomelist = Arrays.asList(BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.swampland);
    }
    
    public MapGenScatteredFeature(final Map llllllllllllllllllIlIIIllllllIlI) {
        this();
        for (final Map.Entry llllllllllllllllllIlIIIllllllIII : llllllllllllllllllIlIIIllllllIlI.entrySet()) {
            if (llllllllllllllllllIlIIIllllllIII.getKey().equals("distance")) {
                this.maxDistanceBetweenScatteredFeatures = MathHelper.parseIntWithDefaultAndMax(llllllllllllllllllIlIIIllllllIII.getValue(), this.maxDistanceBetweenScatteredFeatures, this.minDistanceBetweenScatteredFeatures + 1);
            }
        }
    }
    
    public static class Start extends StructureStart
    {
        static {
            __OBFID = "CL_00000472";
        }
        
        public Start() {
        }
        
        public Start(final World llllllllllllllllIIlIllIIlIIlllll, final Random llllllllllllllllIIlIllIIlIIllllI, final int llllllllllllllllIIlIllIIlIIlIlII, final int llllllllllllllllIIlIllIIlIIlIIll) {
            super(llllllllllllllllIIlIllIIlIIlIlII, llllllllllllllllIIlIllIIlIIlIIll);
            final BiomeGenBase llllllllllllllllIIlIllIIlIIllIll = llllllllllllllllIIlIllIIlIIlllll.getBiomeGenForCoords(new BlockPos(llllllllllllllllIIlIllIIlIIlIlII * 16 + 8, 0, llllllllllllllllIIlIllIIlIIlIIll * 16 + 8));
            if (llllllllllllllllIIlIllIIlIIllIll != BiomeGenBase.jungle && llllllllllllllllIIlIllIIlIIllIll != BiomeGenBase.jungleHills) {
                if (llllllllllllllllIIlIllIIlIIllIll == BiomeGenBase.swampland) {
                    final ComponentScatteredFeaturePieces.SwampHut llllllllllllllllIIlIllIIlIIllIlI = new ComponentScatteredFeaturePieces.SwampHut(llllllllllllllllIIlIllIIlIIllllI, llllllllllllllllIIlIllIIlIIlIlII * 16, llllllllllllllllIIlIllIIlIIlIIll * 16);
                    this.components.add(llllllllllllllllIIlIllIIlIIllIlI);
                }
                else if (llllllllllllllllIIlIllIIlIIllIll == BiomeGenBase.desert || llllllllllllllllIIlIllIIlIIllIll == BiomeGenBase.desertHills) {
                    final ComponentScatteredFeaturePieces.DesertPyramid llllllllllllllllIIlIllIIlIIllIIl = new ComponentScatteredFeaturePieces.DesertPyramid(llllllllllllllllIIlIllIIlIIllllI, llllllllllllllllIIlIllIIlIIlIlII * 16, llllllllllllllllIIlIllIIlIIlIIll * 16);
                    this.components.add(llllllllllllllllIIlIllIIlIIllIIl);
                }
            }
            else {
                final ComponentScatteredFeaturePieces.JunglePyramid llllllllllllllllIIlIllIIlIIllIII = new ComponentScatteredFeaturePieces.JunglePyramid(llllllllllllllllIIlIllIIlIIllllI, llllllllllllllllIIlIllIIlIIlIlII * 16, llllllllllllllllIIlIllIIlIIlIIll * 16);
                this.components.add(llllllllllllllllIIlIllIIlIIllIII);
            }
            this.updateBoundingBox();
        }
    }
}
