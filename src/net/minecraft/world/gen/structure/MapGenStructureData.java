package net.minecraft.world.gen.structure;

import net.minecraft.world.*;
import net.minecraft.nbt.*;

public class MapGenStructureData extends WorldSavedData
{
    private /* synthetic */ NBTTagCompound field_143044_a;
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIlIIIIllIllIIIIllI) {
        this.field_143044_a = llllllllllllllIlIIIIllIllIIIIllI.getCompoundTag("Features");
    }
    
    public MapGenStructureData(final String llllllllllllllIlIIIIllIllIIIlIlI) {
        super(llllllllllllllIlIIIIllIllIIIlIlI);
        this.field_143044_a = new NBTTagCompound();
    }
    
    public NBTTagCompound func_143041_a() {
        return this.field_143044_a;
    }
    
    static {
        __OBFID = "CL_00000510";
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllIlIIIIllIlIllllllI) {
        llllllllllllllIlIIIIllIlIllllllI.setTag("Features", this.field_143044_a);
    }
    
    public static String func_143042_b(final int llllllllllllllIlIIIIllIlIllIllIl, final int llllllllllllllIlIIIIllIlIllIllII) {
        return String.valueOf(new StringBuilder("[").append(llllllllllllllIlIIIIllIlIllIllIl).append(",").append(llllllllllllllIlIIIIllIlIllIllII).append("]"));
    }
    
    public void func_143043_a(final NBTTagCompound llllllllllllllIlIIIIllIlIllllIII, final int llllllllllllllIlIIIIllIlIlllIlll, final int llllllllllllllIlIIIIllIlIlllIllI) {
        this.field_143044_a.setTag(func_143042_b(llllllllllllllIlIIIIllIlIlllIlll, llllllllllllllIlIIIIllIlIlllIllI), llllllllllllllIlIIIIllIlIllllIII);
    }
}
