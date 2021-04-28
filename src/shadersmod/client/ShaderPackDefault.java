package shadersmod.client;

import java.io.*;

public class ShaderPackDefault implements IShaderPack
{
    @Override
    public String getName() {
        return Shaders.packNameDefault;
    }
    
    @Override
    public boolean hasDirectory(final String lllllllllllllllllllllIllIIlIlIll) {
        return false;
    }
    
    @Override
    public InputStream getResourceAsStream(final String lllllllllllllllllllllIllIIlIllll) {
        return ShaderPackDefault.class.getResourceAsStream(lllllllllllllllllllllIllIIlIllll);
    }
    
    @Override
    public void close() {
    }
}
