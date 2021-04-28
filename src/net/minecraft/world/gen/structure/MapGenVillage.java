package net.minecraft.world.gen.structure;

import net.minecraft.world.biome.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;

public class MapGenVillage extends MapGenStructure
{
    public static final /* synthetic */ List villageSpawnBiomes;
    private /* synthetic */ int field_82666_h;
    private /* synthetic */ int field_82665_g;
    private /* synthetic */ int terrainType;
    
    static {
        __OBFID = "CL_00000514";
        villageSpawnBiomes = Arrays.asList(BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.savanna);
    }
    
    public MapGenVillage() {
        this.field_82665_g = 32;
        this.field_82666_h = 8;
    }
    
    public MapGenVillage(final Map llllllllllllllIlIllllIIlIlllIIIl) {
        this();
        for (final Map.Entry llllllllllllllIlIllllIIlIlllIIll : llllllllllllllIlIllllIIlIlllIIIl.entrySet()) {
            if (llllllllllllllIlIllllIIlIlllIIll.getKey().equals("size")) {
                this.terrainType = MathHelper.parseIntWithDefaultAndMax(llllllllllllllIlIllllIIlIlllIIll.getValue(), this.terrainType, 0);
            }
            else {
                if (!llllllllllllllIlIllllIIlIlllIIll.getKey().equals("distance")) {
                    continue;
                }
                this.field_82665_g = MathHelper.parseIntWithDefaultAndMax(llllllllllllllIlIllllIIlIlllIIll.getValue(), this.field_82665_g, this.field_82666_h + 1);
            }
        }
    }
    
    @Override
    protected StructureStart getStructureStart(final int llllllllllllllIlIllllIIlIlIIlllI, final int llllllllllllllIlIllllIIlIlIIllIl) {
        return new Start(this.worldObj, this.rand, llllllllllllllIlIllllIIlIlIIlllI, llllllllllllllIlIllllIIlIlIIllIl, this.terrainType);
    }
    
    @Override
    public String getStructureName() {
        return "Village";
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int llllllllllllllIlIllllIIlIlIllIlI, int llllllllllllllIlIllllIIlIlIllIIl) {
        final int llllllllllllllIlIllllIIlIllIIIIl = llllllllllllllIlIllllIIlIlIllIlI;
        final int llllllllllllllIlIllllIIlIllIIIII = llllllllllllllIlIllllIIlIlIllIIl;
        if (llllllllllllllIlIllllIIlIlIllIlI < 0) {
            llllllllllllllIlIllllIIlIlIllIlI -= this.field_82665_g - 1;
        }
        if (llllllllllllllIlIllllIIlIlIllIIl < 0) {
            llllllllllllllIlIllllIIlIlIllIIl -= this.field_82665_g - 1;
        }
        int llllllllllllllIlIllllIIlIlIlllll = llllllllllllllIlIllllIIlIlIllIlI / this.field_82665_g;
        int llllllllllllllIlIllllIIlIlIllllI = llllllllllllllIlIllllIIlIlIllIIl / this.field_82665_g;
        final Random llllllllllllllIlIllllIIlIlIlllIl = this.worldObj.setRandomSeed(llllllllllllllIlIllllIIlIlIlllll, llllllllllllllIlIllllIIlIlIllllI, 10387312);
        llllllllllllllIlIllllIIlIlIlllll *= this.field_82665_g;
        llllllllllllllIlIllllIIlIlIllllI *= this.field_82665_g;
        llllllllllllllIlIllllIIlIlIlllll += llllllllllllllIlIllllIIlIlIlllIl.nextInt(this.field_82665_g - this.field_82666_h);
        llllllllllllllIlIllllIIlIlIllllI += llllllllllllllIlIllllIIlIlIlllIl.nextInt(this.field_82665_g - this.field_82666_h);
        if (llllllllllllllIlIllllIIlIllIIIIl == llllllllllllllIlIllllIIlIlIlllll && llllllllllllllIlIllllIIlIllIIIII == llllllllllllllIlIllllIIlIlIllllI) {
            final boolean llllllllllllllIlIllllIIlIlIlllII = this.worldObj.getWorldChunkManager().areBiomesViable(llllllllllllllIlIllllIIlIllIIIIl * 16 + 8, llllllllllllllIlIllllIIlIllIIIII * 16 + 8, 0, MapGenVillage.villageSpawnBiomes);
            if (llllllllllllllIlIllllIIlIlIlllII) {
                return true;
            }
        }
        return false;
    }
    
    public static class Start extends StructureStart
    {
        private /* synthetic */ boolean hasMoreThanTwoComponents;
        
        static {
            __OBFID = "CL_00000515";
        }
        
        public Start() {
        }
        
        @Override
        public void func_143017_b(final NBTTagCompound llllllllllllllIlIlllIlIllIllllIl) {
            super.func_143017_b(llllllllllllllIlIlllIlIllIllllIl);
            this.hasMoreThanTwoComponents = llllllllllllllIlIlllIlIllIllllIl.getBoolean("Valid");
        }
        
        @Override
        public boolean isSizeableStructure() {
            return this.hasMoreThanTwoComponents;
        }
        
        @Override
        public void func_143022_a(final NBTTagCompound llllllllllllllIlIlllIlIlllIIIIll) {
            super.func_143022_a(llllllllllllllIlIlllIlIlllIIIIll);
            llllllllllllllIlIlllIlIlllIIIIll.setBoolean("Valid", this.hasMoreThanTwoComponents);
        }
        
        public Start(final World llllllllllllllIlIlllIlIlllIlIlIl, final Random llllllllllllllIlIlllIlIlllIlIlII, final int llllllllllllllIlIlllIlIlllIlIIll, final int llllllllllllllIlIlllIlIllllIIIll, final int llllllllllllllIlIlllIlIlllIlIIIl) {
            super(llllllllllllllIlIlllIlIlllIlIIll, llllllllllllllIlIlllIlIllllIIIll);
            final List llllllllllllllIlIlllIlIllllIIIIl = StructureVillagePieces.getStructureVillageWeightedPieceList(llllllllllllllIlIlllIlIlllIlIlII, llllllllllllllIlIlllIlIlllIlIIIl);
            final StructureVillagePieces.Start llllllllllllllIlIlllIlIllllIIIII = new StructureVillagePieces.Start(llllllllllllllIlIlllIlIlllIlIlIl.getWorldChunkManager(), 0, llllllllllllllIlIlllIlIlllIlIlII, (llllllllllllllIlIlllIlIlllIlIIll << 4) + 2, (llllllllllllllIlIlllIlIllllIIIll << 4) + 2, llllllllllllllIlIlllIlIllllIIIIl, llllllllllllllIlIlllIlIlllIlIIIl);
            this.components.add(llllllllllllllIlIlllIlIllllIIIII);
            llllllllllllllIlIlllIlIllllIIIII.buildComponent(llllllllllllllIlIlllIlIllllIIIII, this.components, llllllllllllllIlIlllIlIlllIlIlII);
            final List llllllllllllllIlIlllIlIlllIlllll = llllllllllllllIlIlllIlIllllIIIII.field_74930_j;
            final List llllllllllllllIlIlllIlIlllIllllI = llllllllllllllIlIlllIlIllllIIIII.field_74932_i;
            while (!llllllllllllllIlIlllIlIlllIlllll.isEmpty() || !llllllllllllllIlIlllIlIlllIllllI.isEmpty()) {
                if (llllllllllllllIlIlllIlIlllIlllll.isEmpty()) {
                    final int llllllllllllllIlIlllIlIlllIlllIl = llllllllllllllIlIlllIlIlllIlIlII.nextInt(llllllllllllllIlIlllIlIlllIllllI.size());
                    final StructureComponent llllllllllllllIlIlllIlIlllIllIlI = llllllllllllllIlIlllIlIlllIllllI.remove(llllllllllllllIlIlllIlIlllIlllIl);
                    llllllllllllllIlIlllIlIlllIllIlI.buildComponent(llllllllllllllIlIlllIlIllllIIIII, this.components, llllllllllllllIlIlllIlIlllIlIlII);
                }
                else {
                    final int llllllllllllllIlIlllIlIlllIlllII = llllllllllllllIlIlllIlIlllIlIlII.nextInt(llllllllllllllIlIlllIlIlllIlllll.size());
                    final StructureComponent llllllllllllllIlIlllIlIlllIllIIl = llllllllllllllIlIlllIlIlllIlllll.remove(llllllllllllllIlIlllIlIlllIlllII);
                    llllllllllllllIlIlllIlIlllIllIIl.buildComponent(llllllllllllllIlIlllIlIllllIIIII, this.components, llllllllllllllIlIlllIlIlllIlIlII);
                }
            }
            this.updateBoundingBox();
            int llllllllllllllIlIlllIlIlllIllIll = 0;
            for (final StructureComponent llllllllllllllIlIlllIlIlllIlIlll : this.components) {
                if (!(llllllllllllllIlIlllIlIlllIlIlll instanceof StructureVillagePieces.Road)) {
                    ++llllllllllllllIlIlllIlIlllIllIll;
                }
            }
            this.hasMoreThanTwoComponents = (llllllllllllllIlIlllIlIlllIllIll > 2);
        }
    }
}
