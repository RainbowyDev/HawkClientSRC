package net.minecraft.client.resources;

import java.io.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.data.*;

public interface IResource
{
    boolean hasMetadata();
    
    InputStream getInputStream();
    
    String func_177240_d();
    
    ResourceLocation func_177241_a();
    
    IMetadataSection getMetadata(final String p0);
}
