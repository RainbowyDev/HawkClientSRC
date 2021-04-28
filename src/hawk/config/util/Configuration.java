package hawk.config.util;

import java.util.*;
import org.json.*;
import java.io.*;

public class Configuration
{
    public /* synthetic */ Map<String, Object> options;
    private /* synthetic */ File file;
    
    public void set(final String lllllllllllllllIIIIIlIIlIIIIIIll, final Object lllllllllllllllIIIIIlIIlIIIIIIlI) {
        this.options.put(lllllllllllllllIIIIIlIIlIIIIIIll, lllllllllllllllIIIIIlIIlIIIIIIlI);
    }
    
    public Object get(final String lllllllllllllllIIIIIlIIlIIIIlIlI) {
        return this.options.get(lllllllllllllllIIIIIlIIlIIIIlIlI);
    }
    
    public Configuration(final File lllllllllllllllIIIIIlIIlIIIIlllI) {
        this.file = lllllllllllllllIIIIIlIIlIIIIlllI;
        this.options = new HashMap<String, Object>();
    }
    
    public File getFile() {
        return this.file;
    }
    
    public void save() throws IOException {
        final JSONObject lllllllllllllllIIIIIlIIIlllllIlI = new JSONObject(this.options);
        this.file.createNewFile();
        final FileWriter lllllllllllllllIIIIIlIIIlllllIIl = new FileWriter(this.file);
        lllllllllllllllIIIIIlIIIlllllIIl.write(lllllllllllllllIIIIIlIIIlllllIlI.toString());
        lllllllllllllllIIIIIlIIIlllllIIl.flush();
        lllllllllllllllIIIIIlIIIlllllIIl.close();
    }
    
    public Configuration(final File lllllllllllllllIIIIIlIIlIIIlIllI, final Map<String, Object> lllllllllllllllIIIIIlIIlIIIllIlI) {
        this.file = lllllllllllllllIIIIIlIIlIIIlIllI;
        this.options = lllllllllllllllIIIIIlIIlIIIllIlI;
    }
}
