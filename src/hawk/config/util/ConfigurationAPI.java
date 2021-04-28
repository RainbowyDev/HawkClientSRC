package hawk.config.util;

import org.apache.commons.io.*;
import org.json.*;
import java.io.*;

public class ConfigurationAPI
{
    public static Configuration newConfiguration(final File llllllllllllllIIllIIIlIIlIlIllll) {
        return new Configuration(llllllllllllllIIllIIIlIIlIlIllll);
    }
    
    public static Configuration loadExistingConfiguration(final File llllllllllllllIIllIIIlIIlIllIlIl) throws IOException {
        final JSONObject llllllllllllllIIllIIIlIIlIllIlII = new JSONObject(FileUtils.readFileToString(llllllllllllllIIllIIIlIIlIllIlIl, Charsets.UTF_8));
        return new Configuration(llllllllllllllIIllIIIlIIlIllIlIl, llllllllllllllIIllIIIlIIlIllIlII.toMap());
    }
}
