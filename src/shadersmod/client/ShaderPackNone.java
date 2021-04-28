package shadersmod.client;

import java.io.*;

public class ShaderPackNone implements IShaderPack
{
    @Override
    public String getName() {
        return Shaders.packNameNone;
    }
    
    @Override
    public boolean hasDirectory(final String llllllllllllllllIlIIlllIlIlIIlII) {
        return false;
    }
    
    @Override
    public InputStream getResourceAsStream(final String llllllllllllllllIlIIlllIlIlIIllI) {
        return null;
    }
    
    @Override
    public void close() {
    }
}
