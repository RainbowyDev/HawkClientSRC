package hawk.config;

import hawk.*;
import hawk.modules.*;
import hawk.settings.*;
import com.lukflug.panelstudio.settings.*;
import hawk.config.util.*;
import java.io.*;

public class Config
{
    public static boolean load() {
        try {
            final Configuration llllllllllllllIllIIlIIlIllIIIlII = ConfigurationAPI.loadExistingConfiguration(new File("HawkConfig.json"));
            for (final Module llllllllllllllIllIIlIIlIllIIIIll : Client.modules) {
                if (llllllllllllllIllIIlIIlIllIIIlII.get(llllllllllllllIllIIlIIlIllIIIIll.name) instanceof Boolean) {
                    llllllllllllllIllIIlIIlIllIIIIll.setEnabled((boolean)llllllllllllllIllIIlIIlIllIIIlII.get(llllllllllllllIllIIlIIlIllIIIIll.name));
                }
                for (final Setting llllllllllllllIllIIlIIlIllIIIIlI : llllllllllllllIllIIlIIlIllIIIIll.settings) {
                    if (llllllllllllllIllIIlIIlIllIIIIlI instanceof BooleanSetting && llllllllllllllIllIIlIIlIllIIIlII.get(llllllllllllllIllIIlIIlIllIIIIlI.name) instanceof Boolean) {
                        ((BooleanSetting)llllllllllllllIllIIlIIlIllIIIIlI).setEnabled((boolean)llllllllllllllIllIIlIIlIllIIIlII.get(llllllllllllllIllIIlIIlIllIIIIlI.name));
                    }
                    if (llllllllllllllIllIIlIIlIllIIIIlI instanceof ModeSetting && llllllllllllllIllIIlIIlIllIIIlII.get(llllllllllllllIllIIlIIlIllIIIIlI.name) instanceof String) {
                        ((ModeSetting)llllllllllllllIllIIlIIlIllIIIIlI).setMode((String)llllllllllllllIllIIlIIlIllIIIlII.get(llllllllllllllIllIIlIIlIllIIIIlI.name));
                    }
                    if (llllllllllllllIllIIlIIlIllIIIIlI instanceof NumberSetting && llllllllllllllIllIIlIIlIllIIIlII.get(llllllllllllllIllIIlIIlIllIIIIlI.name) instanceof Double) {
                        ((NumberSetting)llllllllllllllIllIIlIIlIllIIIIlI).setValue((double)llllllllllllllIllIIlIIlIllIIIlII.get(llllllllllllllIllIIlIIlIllIIIIlI.name));
                    }
                    if (llllllllllllllIllIIlIIlIllIIIIlI instanceof KeybindSetting && llllllllllllllIllIIlIIlIllIIIlII.get(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIlIIlIllIIIIll.name)).append(" key"))) instanceof Integer) {
                        ((KeybindSetting)llllllllllllllIllIIlIIlIllIIIIlI).setKey((int)llllllllllllllIllIIlIIlIllIIIlII.get(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIlIIlIllIIIIll.name)).append(" key"))));
                    }
                }
            }
        }
        catch (Exception llllllllllllllIllIIlIIlIllIIIIIl) {
            llllllllllllllIllIIlIIlIllIIIIIl.printStackTrace();
        }
        return true;
    }
    
    public static void save() {
        final Configuration llllllllllllllIllIIlIIlIllIlIIlI = ConfigurationAPI.newConfiguration(new File("HawkConfig.json"));
        for (final Module llllllllllllllIllIIlIIlIllIlIIIl : Client.modules) {
            llllllllllllllIllIIlIIlIllIlIIlI.set(llllllllllllllIllIIlIIlIllIlIIIl.name, llllllllllllllIllIIlIIlIllIlIIIl.toggled);
            for (final Setting llllllllllllllIllIIlIIlIllIlIIII : llllllllllllllIllIIlIIlIllIlIIIl.settings) {
                if (llllllllllllllIllIIlIIlIllIlIIII instanceof BooleanSetting) {
                    llllllllllllllIllIIlIIlIllIlIIlI.set(llllllllllllllIllIIlIIlIllIlIIII.name, ((BooleanSetting)llllllllllllllIllIIlIIlIllIlIIII).isEnabled());
                }
                if (llllllllllllllIllIIlIIlIllIlIIII instanceof ModeSetting) {
                    llllllllllllllIllIIlIIlIllIlIIlI.set(llllllllllllllIllIIlIIlIllIlIIII.name, ((ModeSetting)llllllllllllllIllIIlIIlIllIlIIII).getMode());
                }
                if (llllllllllllllIllIIlIIlIllIlIIII instanceof NumberSetting) {
                    llllllllllllllIllIIlIIlIllIlIIlI.set(llllllllllllllIllIIlIIlIllIlIIII.name, ((NumberSetting)llllllllllllllIllIIlIIlIllIlIIII).getValue());
                }
                if (llllllllllllllIllIIlIIlIllIlIIII instanceof KeybindSetting) {
                    llllllllllllllIllIIlIIlIllIlIIlI.set(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIlIIlIllIlIIIl.name)).append(" key")), ((KeybindSetting)llllllllllllllIllIIlIIlIllIlIIII).getKey());
                }
            }
        }
        try {
            llllllllllllllIllIIlIIlIllIlIIlI.save();
        }
        catch (IOException llllllllllllllIllIIlIIlIllIIllll) {
            llllllllllllllIllIIlIIlIllIIllll.printStackTrace();
        }
    }
}
