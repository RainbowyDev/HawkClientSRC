package net.minecraft.client.resources.data;

import net.minecraft.util.*;

public class PackMetadataSection implements IMetadataSection
{
    private final /* synthetic */ int packFormat;
    private final /* synthetic */ IChatComponent packDescription;
    
    public PackMetadataSection(final IChatComponent llllllllllllllIIlIIIIIlIIllllIII, final int llllllllllllllIIlIIIIIlIIlllIlll) {
        this.packDescription = llllllllllllllIIlIIIIIlIIllllIII;
        this.packFormat = llllllllllllllIIlIIIIIlIIlllIlll;
    }
    
    public int getPackFormat() {
        return this.packFormat;
    }
    
    public IChatComponent func_152805_a() {
        return this.packDescription;
    }
    
    static {
        __OBFID = "CL_00001112";
    }
}
