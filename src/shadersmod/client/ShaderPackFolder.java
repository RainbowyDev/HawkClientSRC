package shadersmod.client;

import optifine.*;
import java.io.*;

public class ShaderPackFolder implements IShaderPack
{
    protected /* synthetic */ File packFile;
    
    @Override
    public boolean hasDirectory(final String llllllllllllllIIIIIlIIIIlIIIIIlI) {
        final File llllllllllllllIIIIIlIIIIlIIIIIIl = new File(this.packFile, llllllllllllllIIIIIlIIIIlIIIIIlI.substring(1));
        return llllllllllllllIIIIIlIIIIlIIIIIIl.exists() && llllllllllllllIIIIIlIIIIlIIIIIIl.isDirectory();
    }
    
    @Override
    public void close() {
    }
    
    public ShaderPackFolder(final String llllllllllllllIIIIIlIIIIlIIllIII, final File llllllllllllllIIIIIlIIIIlIIlIlll) {
        this.packFile = llllllllllllllIIIIIlIIIIlIIlIlll;
    }
    
    @Override
    public InputStream getResourceAsStream(final String llllllllllllllIIIIIlIIIIlIIIlIIl) {
        try {
            final String llllllllllllllIIIIIlIIIIlIIIllIl = StrUtils.removePrefixSuffix(llllllllllllllIIIIIlIIIIlIIIlIIl, "/", "/");
            final File llllllllllllllIIIIIlIIIIlIIIllII = new File(this.packFile, llllllllllllllIIIIIlIIIIlIIIllIl);
            InputStream inputStream;
            if (!llllllllllllllIIIIIlIIIIlIIIllII.exists()) {
                inputStream = null;
            }
            else {
                final FileInputStream fileInputStream;
                inputStream = new BufferedInputStream(fileInputStream);
                fileInputStream = new FileInputStream(llllllllllllllIIIIIlIIIIlIIIllII);
            }
            return inputStream;
        }
        catch (Exception llllllllllllllIIIIIlIIIIlIIIlIll) {
            return null;
        }
    }
    
    @Override
    public String getName() {
        return this.packFile.getName();
    }
}
