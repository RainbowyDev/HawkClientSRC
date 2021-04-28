package net.minecraft.world.gen.structure;

import net.minecraft.world.biome.*;
import net.minecraft.entity.monster.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;

public class StructureOceanMonument extends MapGenStructure
{
    private static final /* synthetic */ List field_175803_h;
    private /* synthetic */ int field_175800_f;
    public static final /* synthetic */ List field_175802_d;
    private /* synthetic */ int field_175801_g;
    
    public StructureOceanMonument() {
        this.field_175800_f = 32;
        this.field_175801_g = 5;
    }
    
    @Override
    protected StructureStart getStructureStart(final int llIIIllIlllIIII, final int llIIIllIlllIIlI) {
        return new StartMonument(this.worldObj, this.rand, llIIIllIlllIIII, llIIIllIlllIIlI);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int llIIIllIlllllll, int llIIIllIllllllI) {
        final int llIIIlllIIIIllI = llIIIllIlllllll;
        final int llIIIlllIIIIlIl = llIIIllIllllllI;
        if (llIIIllIlllllll < 0) {
            llIIIllIlllllll -= this.field_175800_f - 1;
        }
        if (llIIIllIllllllI < 0) {
            llIIIllIllllllI -= this.field_175800_f - 1;
        }
        int llIIIlllIIIIlII = llIIIllIlllllll / this.field_175800_f;
        int llIIIlllIIIIIll = llIIIllIllllllI / this.field_175800_f;
        final Random llIIIlllIIIIIlI = this.worldObj.setRandomSeed(llIIIlllIIIIlII, llIIIlllIIIIIll, 10387313);
        llIIIlllIIIIlII *= this.field_175800_f;
        llIIIlllIIIIIll *= this.field_175800_f;
        llIIIlllIIIIlII += (llIIIlllIIIIIlI.nextInt(this.field_175800_f - this.field_175801_g) + llIIIlllIIIIIlI.nextInt(this.field_175800_f - this.field_175801_g)) / 2;
        llIIIlllIIIIIll += (llIIIlllIIIIIlI.nextInt(this.field_175800_f - this.field_175801_g) + llIIIlllIIIIIlI.nextInt(this.field_175800_f - this.field_175801_g)) / 2;
        if (llIIIlllIIIIllI == llIIIlllIIIIlII && llIIIlllIIIIlIl == llIIIlllIIIIIll) {
            if (this.worldObj.getWorldChunkManager().func_180300_a(new BlockPos(llIIIlllIIIIllI * 16 + 8, 64, llIIIlllIIIIlIl * 16 + 8), null) != BiomeGenBase.deepOcean) {
                return false;
            }
            final boolean llIIIlllIIIIIIl = this.worldObj.getWorldChunkManager().areBiomesViable(llIIIlllIIIIllI * 16 + 8, llIIIlllIIIIlIl * 16 + 8, 29, StructureOceanMonument.field_175802_d);
            if (llIIIlllIIIIIIl) {
                return true;
            }
        }
        return false;
    }
    
    public List func_175799_b() {
        return StructureOceanMonument.field_175803_h;
    }
    
    static {
        __OBFID = "CL_00001996";
        field_175802_d = Arrays.asList(BiomeGenBase.ocean, BiomeGenBase.deepOcean, BiomeGenBase.river, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver);
        (field_175803_h = Lists.newArrayList()).add(new BiomeGenBase.SpawnListEntry(EntityGuardian.class, 1, 2, 4));
    }
    
    public StructureOceanMonument(final Map llIIIlllIIllIlI) {
        this();
        for (final Map.Entry llIIIlllIIllIII : llIIIlllIIllIlI.entrySet()) {
            if (llIIIlllIIllIII.getKey().equals("spacing")) {
                this.field_175800_f = MathHelper.parseIntWithDefaultAndMax(llIIIlllIIllIII.getValue(), this.field_175800_f, 1);
            }
            else {
                if (!llIIIlllIIllIII.getKey().equals("separation")) {
                    continue;
                }
                this.field_175801_g = MathHelper.parseIntWithDefaultAndMax(llIIIlllIIllIII.getValue(), this.field_175801_g, 1);
            }
        }
    }
    
    @Override
    public String getStructureName() {
        return "Monument";
    }
    
    public static class StartMonument extends StructureStart
    {
        private /* synthetic */ Set field_175791_c;
        private /* synthetic */ boolean field_175790_d;
        
        @Override
        public void generateStructure(final World llllllllllllllIIIlIIlIIIIllIIIII, final Random llllllllllllllIIIlIIlIIIIlIlllll, final StructureBoundingBox llllllllllllllIIIlIIlIIIIlIllllI) {
            if (!this.field_175790_d) {
                this.components.clear();
                this.func_175789_b(llllllllllllllIIIlIIlIIIIllIIIII, llllllllllllllIIIlIIlIIIIlIlllll, this.func_143019_e(), this.func_143018_f());
            }
            super.generateStructure(llllllllllllllIIIlIIlIIIIllIIIII, llllllllllllllIIIlIIlIIIIlIlllll, llllllllllllllIIIlIIlIIIIlIllllI);
        }
        
        public StartMonument(final World llllllllllllllIIIlIIlIIIlIIIllIl, final Random llllllllllllllIIIlIIlIIIlIIlIIIl, final int llllllllllllllIIIlIIlIIIlIIIlIll, final int llllllllllllllIIIlIIlIIIlIIIlIlI) {
            super(llllllllllllllIIIlIIlIIIlIIIlIll, llllllllllllllIIIlIIlIIIlIIIlIlI);
            this.field_175791_c = Sets.newHashSet();
            this.func_175789_b(llllllllllllllIIIlIIlIIIlIIIllIl, llllllllllllllIIIlIIlIIIlIIlIIIl, llllllllllllllIIIlIIlIIIlIIIlIll, llllllllllllllIIIlIIlIIIlIIIlIlI);
        }
        
        @Override
        public void func_143017_b(final NBTTagCompound llllllllllllllIIIlIIlIIIIIllIlIl) {
            super.func_143017_b(llllllllllllllIIIlIIlIIIIIllIlIl);
            if (llllllllllllllIIIlIIlIIIIIllIlIl.hasKey("Processed", 9)) {
                final NBTTagList llllllllllllllIIIlIIlIIIIIllIlII = llllllllllllllIIIlIIlIIIIIllIlIl.getTagList("Processed", 10);
                for (int llllllllllllllIIIlIIlIIIIIllIIll = 0; llllllllllllllIIIlIIlIIIIIllIIll < llllllllllllllIIIlIIlIIIIIllIlII.tagCount(); ++llllllllllllllIIIlIIlIIIIIllIIll) {
                    final NBTTagCompound llllllllllllllIIIlIIlIIIIIllIIlI = llllllllllllllIIIlIIlIIIIIllIlII.getCompoundTagAt(llllllllllllllIIIlIIlIIIIIllIIll);
                    this.field_175791_c.add(new ChunkCoordIntPair(llllllllllllllIIIlIIlIIIIIllIIlI.getInteger("X"), llllllllllllllIIIlIIlIIIIIllIIlI.getInteger("Z")));
                }
            }
        }
        
        @Override
        public void func_175787_b(final ChunkCoordIntPair llllllllllllllIIIlIIlIIIIlIlIIII) {
            super.func_175787_b(llllllllllllllIIIlIIlIIIIlIlIIII);
            this.field_175791_c.add(llllllllllllllIIIlIIlIIIIlIlIIII);
        }
        
        private void func_175789_b(final World llllllllllllllIIIlIIlIIIIlllllII, final Random llllllllllllllIIIlIIlIIIIllllIll, final int llllllllllllllIIIlIIlIIIIllllIlI, final int llllllllllllllIIIlIIlIIIIllIllIl) {
            llllllllllllllIIIlIIlIIIIllllIll.setSeed(llllllllllllllIIIlIIlIIIIlllllII.getSeed());
            final long llllllllllllllIIIlIIlIIIIllllIII = llllllllllllllIIIlIIlIIIIllllIll.nextLong();
            final long llllllllllllllIIIlIIlIIIIlllIlll = llllllllllllllIIIlIIlIIIIllllIll.nextLong();
            final long llllllllllllllIIIlIIlIIIIlllIllI = llllllllllllllIIIlIIlIIIIllllIlI * llllllllllllllIIIlIIlIIIIllllIII;
            final long llllllllllllllIIIlIIlIIIIlllIlIl = llllllllllllllIIIlIIlIIIIllIllIl * llllllllllllllIIIlIIlIIIIlllIlll;
            llllllllllllllIIIlIIlIIIIllllIll.setSeed(llllllllllllllIIIlIIlIIIIlllIllI ^ llllllllllllllIIIlIIlIIIIlllIlIl ^ llllllllllllllIIIlIIlIIIIlllllII.getSeed());
            final int llllllllllllllIIIlIIlIIIIlllIlII = llllllllllllllIIIlIIlIIIIllllIlI * 16 + 8 - 29;
            final int llllllllllllllIIIlIIlIIIIlllIIll = llllllllllllllIIIlIIlIIIIllIllIl * 16 + 8 - 29;
            final EnumFacing llllllllllllllIIIlIIlIIIIlllIIlI = EnumFacing.Plane.HORIZONTAL.random(llllllllllllllIIIlIIlIIIIllllIll);
            this.components.add(new StructureOceanMonumentPieces.MonumentBuilding(llllllllllllllIIIlIIlIIIIllllIll, llllllllllllllIIIlIIlIIIIlllIlII, llllllllllllllIIIlIIlIIIIlllIIll, llllllllllllllIIIlIIlIIIIlllIIlI));
            this.updateBoundingBox();
            this.field_175790_d = true;
        }
        
        @Override
        public void func_143022_a(final NBTTagCompound llllllllllllllIIIlIIlIIIIlIIIIII) {
            super.func_143022_a(llllllllllllllIIIlIIlIIIIlIIIIII);
            final NBTTagList llllllllllllllIIIlIIlIIIIlIIIlIl = new NBTTagList();
            for (final ChunkCoordIntPair llllllllllllllIIIlIIlIIIIlIIIIll : this.field_175791_c) {
                final NBTTagCompound llllllllllllllIIIlIIlIIIIlIIIIlI = new NBTTagCompound();
                llllllllllllllIIIlIIlIIIIlIIIIlI.setInteger("X", llllllllllllllIIIlIIlIIIIlIIIIll.chunkXPos);
                llllllllllllllIIIlIIlIIIIlIIIIlI.setInteger("Z", llllllllllllllIIIlIIlIIIIlIIIIll.chunkZPos);
                llllllllllllllIIIlIIlIIIIlIIIlIl.appendTag(llllllllllllllIIIlIIlIIIIlIIIIlI);
            }
            llllllllllllllIIIlIIlIIIIlIIIIII.setTag("Processed", llllllllllllllIIIlIIlIIIIlIIIlIl);
        }
        
        public StartMonument() {
            this.field_175791_c = Sets.newHashSet();
        }
        
        @Override
        public boolean func_175788_a(final ChunkCoordIntPair llllllllllllllIIIlIIlIIIIlIlIlII) {
            return !this.field_175791_c.contains(llllllllllllllIIIlIIlIIIIlIlIlII) && super.func_175788_a(llllllllllllllIIIlIIlIIIIlIlIlII);
        }
        
        static {
            __OBFID = "CL_00001995";
        }
    }
}
