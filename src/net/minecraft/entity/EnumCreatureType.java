package net.minecraft.entity;

import net.minecraft.block.material.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;

public enum EnumCreatureType
{
    private final /* synthetic */ boolean isAnimal;
    private final /* synthetic */ Material creatureMaterial;
    
    WATER_CREATURE("WATER_CREATURE", 3, "WATER_CREATURE", 3, (Class)EntityWaterMob.class, 5, Material.water, true, false), 
    MONSTER("MONSTER", 0, "MONSTER", 0, (Class)IMob.class, 70, Material.air, false, false);
    
    private final /* synthetic */ boolean isPeacefulCreature;
    
    AMBIENT("AMBIENT", 2, "AMBIENT", 2, (Class)EntityAmbientCreature.class, 15, Material.air, true, false);
    
    private final /* synthetic */ Class creatureClass;
    private final /* synthetic */ int maxNumberOfCreature;
    
    CREATURE("CREATURE", 1, "CREATURE", 1, (Class)EntityAnimal.class, 10, Material.air, true, true);
    
    static {
        __OBFID = "CL_00001551";
    }
    
    public boolean getAnimal() {
        return this.isAnimal;
    }
    
    public int getMaxNumberOfCreature() {
        return this.maxNumberOfCreature;
    }
    
    public Class getCreatureClass() {
        return this.creatureClass;
    }
    
    private EnumCreatureType(final String llllllllllllllIIIIlIllIIIIIlIIIl, final int llllllllllllllIIIIlIllIIIIIlIIII, final String llllllllllllllIIIIlIllIIIIIllIIl, final int llllllllllllllIIIIlIllIIIIIllIII, final Class llllllllllllllIIIIlIllIIIIIIllll, final int llllllllllllllIIIIlIllIIIIIIlllI, final Material llllllllllllllIIIIlIllIIIIIlIlIl, final boolean llllllllllllllIIIIlIllIIIIIlIlII, final boolean llllllllllllllIIIIlIllIIIIIlIIll) {
        this.creatureClass = llllllllllllllIIIIlIllIIIIIIllll;
        this.maxNumberOfCreature = llllllllllllllIIIIlIllIIIIIIlllI;
        this.creatureMaterial = llllllllllllllIIIIlIllIIIIIlIlIl;
        this.isPeacefulCreature = llllllllllllllIIIIlIllIIIIIlIlII;
        this.isAnimal = llllllllllllllIIIIlIllIIIIIlIIll;
    }
    
    public boolean getPeacefulCreature() {
        return this.isPeacefulCreature;
    }
}
