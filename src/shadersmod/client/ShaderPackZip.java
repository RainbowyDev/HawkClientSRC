package shadersmod.client;

import optifine.*;
import java.util.zip.*;
import java.io.*;

public class ShaderPackZip implements IShaderPack
{
    protected /* synthetic */ ZipFile packZipFile;
    protected /* synthetic */ File packFile;
    
    @Override
    public String getName() {
        return this.packFile.getName();
    }
    
    @Override
    public boolean hasDirectory(final String llllllllllllllllIllIllIllIlIIllI) {
        try {
            if (this.packZipFile == null) {
                this.packZipFile = new ZipFile(this.packFile);
            }
            final String llllllllllllllllIllIllIllIlIlIlI = StrUtils.removePrefix(llllllllllllllllIllIllIllIlIIllI, "/");
            final ZipEntry llllllllllllllllIllIllIllIlIlIIl = this.packZipFile.getEntry(llllllllllllllllIllIllIllIlIlIlI);
            return llllllllllllllllIllIllIllIlIlIIl != null;
        }
        catch (IOException llllllllllllllllIllIllIllIlIlIII) {
            return false;
        }
    }
    
    @Override
    public InputStream getResourceAsStream(final String llllllllllllllllIllIllIllIllIIll) {
        try {
            if (this.packZipFile == null) {
                this.packZipFile = new ZipFile(this.packFile);
            }
            final String llllllllllllllllIllIllIllIllIlll = StrUtils.removePrefix(llllllllllllllllIllIllIllIllIIll, "/");
            final ZipEntry llllllllllllllllIllIllIllIllIllI = this.packZipFile.getEntry(llllllllllllllllIllIllIllIllIlll);
            return (llllllllllllllllIllIllIllIllIllI == null) ? null : this.packZipFile.getInputStream(llllllllllllllllIllIllIllIllIllI);
        }
        catch (Exception llllllllllllllllIllIllIllIllIlIl) {
            return null;
        }
    }
    
    @Override
    public void close() {
        if (this.packZipFile != null) {
            try {
                this.packZipFile.close();
            }
            catch (Exception ex) {}
            this.packZipFile = null;
        }
    }
    
    public ShaderPackZip(final String llllllllllllllllIllIllIlllIIIllI, final File llllllllllllllllIllIllIlllIIIIll) {
        this.packFile = llllllllllllllllIllIllIlllIIIIll;
        this.packZipFile = null;
    }
}
