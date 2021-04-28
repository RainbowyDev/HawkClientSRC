package net.minecraft.client.resources;

import java.io.*;

public class ResourcePackFileNotFoundException extends FileNotFoundException
{
    static {
        __OBFID = "CL_00001086";
    }
    
    public ResourcePackFileNotFoundException(final File lllllllllllllllIlllIllllIIIllIII, final String lllllllllllllllIlllIllllIIIlIlll) {
        super(String.format("'%s' in ResourcePack '%s'", lllllllllllllllIlllIllllIIIlIlll, lllllllllllllllIlllIllllIIIllIII));
    }
}
