package net.minecraft.world.gen.structure;

import com.google.common.collect.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import java.util.*;

public class MapGenNetherBridge extends MapGenStructure
{
    private /* synthetic */ List spawnList;
    
    public MapGenNetherBridge() {
        this.spawnList = Lists.newArrayList();
        this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntityBlaze.class, 10, 2, 3));
        this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, 5, 4, 4));
        this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
        this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntityMagmaCube.class, 3, 4, 4));
    }
    
    @Override
    protected StructureStart getStructureStart(final int llllllllllllllIllllIIlllIllIlIlI, final int llllllllllllllIllllIIlllIllIIllI) {
        return new Start(this.worldObj, this.rand, llllllllllllllIllllIIlllIllIlIlI, llllllllllllllIllllIIlllIllIIllI);
    }
    
    @Override
    public String getStructureName() {
        return "Fortress";
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int llllllllllllllIllllIIlllIlllIlll, final int llllllllllllllIllllIIlllIlllIIIl) {
        final int llllllllllllllIllllIIlllIlllIlIl = llllllllllllllIllllIIlllIlllIlll >> 4;
        final int llllllllllllllIllllIIlllIlllIlII = llllllllllllllIllllIIlllIlllIIIl >> 4;
        this.rand.setSeed((long)(llllllllllllllIllllIIlllIlllIlIl ^ llllllllllllllIllllIIlllIlllIlII << 4) ^ this.worldObj.getSeed());
        this.rand.nextInt();
        return this.rand.nextInt(3) == 0 && llllllllllllllIllllIIlllIlllIlll == (llllllllllllllIllllIIlllIlllIlIl << 4) + 4 + this.rand.nextInt(8) && llllllllllllllIllllIIlllIlllIIIl == (llllllllllllllIllllIIlllIlllIlII << 4) + 4 + this.rand.nextInt(8);
    }
    
    public List getSpawnList() {
        return this.spawnList;
    }
    
    static {
        __OBFID = "CL_00000451";
    }
    
    public static class Start extends StructureStart
    {
        public Start() {
        }
        
        public Start(final World llllllllllllllIlIIIlIlllIIIllllI, final Random llllllllllllllIlIIIlIlllIIIlIlII, final int llllllllllllllIlIIIlIlllIIIlIIll, final int llllllllllllllIlIIIlIlllIIIllIll) {
            super(llllllllllllllIlIIIlIlllIIIlIIll, llllllllllllllIlIIIlIlllIIIllIll);
            final StructureNetherBridgePieces.Start llllllllllllllIlIIIlIlllIIIllIlI = new StructureNetherBridgePieces.Start(llllllllllllllIlIIIlIlllIIIlIlII, (llllllllllllllIlIIIlIlllIIIlIIll << 4) + 2, (llllllllllllllIlIIIlIlllIIIllIll << 4) + 2);
            this.components.add(llllllllllllllIlIIIlIlllIIIllIlI);
            llllllllllllllIlIIIlIlllIIIllIlI.buildComponent(llllllllllllllIlIIIlIlllIIIllIlI, this.components, llllllllllllllIlIIIlIlllIIIlIlII);
            final List llllllllllllllIlIIIlIlllIIIllIIl = llllllllllllllIlIIIlIlllIIIllIlI.field_74967_d;
            while (!llllllllllllllIlIIIlIlllIIIllIIl.isEmpty()) {
                final int llllllllllllllIlIIIlIlllIIIllIII = llllllllllllllIlIIIlIlllIIIlIlII.nextInt(llllllllllllllIlIIIlIlllIIIllIIl.size());
                final StructureComponent llllllllllllllIlIIIlIlllIIIlIlll = llllllllllllllIlIIIlIlllIIIllIIl.remove(llllllllllllllIlIIIlIlllIIIllIII);
                llllllllllllllIlIIIlIlllIIIlIlll.buildComponent(llllllllllllllIlIIIlIlllIIIllIlI, this.components, llllllllllllllIlIIIlIlllIIIlIlII);
            }
            this.updateBoundingBox();
            this.setRandomHeight(llllllllllllllIlIIIlIlllIIIllllI, llllllllllllllIlIIIlIlllIIIlIlII, 48, 70);
        }
        
        static {
            __OBFID = "CL_00000452";
        }
    }
}
