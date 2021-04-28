package shadersmod.client;

import java.io.*;

public interface IShaderPack
{
    boolean hasDirectory(final String p0);
    
    void close();
    
    String getName();
    
    InputStream getResourceAsStream(final String p0);
}
