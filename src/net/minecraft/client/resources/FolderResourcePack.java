package net.minecraft.client.resources;

import com.google.common.collect.*;
import org.apache.commons.io.filefilter.*;
import java.io.*;
import java.util.*;

public class FolderResourcePack extends AbstractResourcePack
{
    static {
        __OBFID = "CL_00001076";
    }
    
    @Override
    protected boolean hasResourceName(final String lIlIlllIIlllIII) {
        return new File(this.resourcePackFile, lIlIlllIIlllIII).isFile();
    }
    
    @Override
    protected InputStream getInputStreamByName(final String lIlIlllIIllllII) throws IOException {
        return new BufferedInputStream(new FileInputStream(new File(this.resourcePackFile, lIlIlllIIllllII)));
    }
    
    @Override
    public Set getResourceDomains() {
        final HashSet lIlIlllIIlIllII = Sets.newHashSet();
        final File lIlIlllIIlIlIll = new File(this.resourcePackFile, "assets/");
        if (lIlIlllIIlIlIll.isDirectory()) {
            for (final File lIlIlllIIlIIlll : lIlIlllIIlIlIll.listFiles((FileFilter)DirectoryFileFilter.DIRECTORY)) {
                final String lIlIlllIIlIIllI = AbstractResourcePack.getRelativeName(lIlIlllIIlIlIll, lIlIlllIIlIIlll);
                if (!lIlIlllIIlIIllI.equals(lIlIlllIIlIIllI.toLowerCase())) {
                    this.logNameNotLowercase(lIlIlllIIlIIllI);
                }
                else {
                    lIlIlllIIlIllII.add(lIlIlllIIlIIllI.substring(0, lIlIlllIIlIIllI.length() - 1));
                }
            }
        }
        return lIlIlllIIlIllII;
    }
    
    public FolderResourcePack(final File lIlIlllIlIIIIlI) {
        super(lIlIlllIlIIIIlI);
    }
}
