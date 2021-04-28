package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import net.minecraft.util.*;
import java.io.*;
import java.util.*;
import java.awt.image.*;

public interface IResourcePack
{
    IMetadataSection getPackMetadata(final IMetadataSerializer p0, final String p1) throws IOException;
    
    boolean resourceExists(final ResourceLocation p0);
    
    InputStream getInputStream(final ResourceLocation p0) throws IOException;
    
    String getPackName();
    
    Set getResourceDomains();
    
    BufferedImage getPackImage() throws IOException;
}
