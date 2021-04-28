package net.minecraft.realms;

import net.minecraft.client.*;
import com.mojang.util.*;
import com.mojang.authlib.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import java.net.*;

public class Realms
{
    public static String uuidToName(final String llllllllllllllllllIIIIlIllllIIIl) {
        return Minecraft.getMinecraft().getSessionService().fillProfileProperties(new GameProfile(UUIDTypeAdapter.fromString(llllllllllllllllllIIIIlIllllIIIl), (String)null), false).getName();
    }
    
    public static int creativeId() {
        return WorldSettings.GameType.CREATIVE.getID();
    }
    
    public static String userName() {
        final Session llllllllllllllllllIIIIlIllllIlII = Minecraft.getMinecraft().getSession();
        return (llllllllllllllllllIIIIlIllllIlII == null) ? null : llllllllllllllllllIIIIlIllllIlII.getUsername();
    }
    
    public static boolean isTouchScreen() {
        return Minecraft.getMinecraft().gameSettings.touchscreen;
    }
    
    public static String getSessionId() {
        return Minecraft.getMinecraft().getSession().getSessionID();
    }
    
    public static void setScreen(final RealmsScreen llllllllllllllllllIIIIlIlllIllIl) {
        Minecraft.getMinecraft().displayGuiScreen(llllllllllllllllllIIIIlIlllIllIl.getProxy());
    }
    
    static {
        __OBFID = "CL_00001892";
    }
    
    public static String getName() {
        return Minecraft.getMinecraft().getSession().getUsername();
    }
    
    public static int adventureId() {
        return WorldSettings.GameType.ADVENTURE.getID();
    }
    
    public static Proxy getProxy() {
        return Minecraft.getMinecraft().getProxy();
    }
    
    public static String sessionId() {
        final Session llllllllllllllllllIIIIlIllllIlll = Minecraft.getMinecraft().getSession();
        return (llllllllllllllllllIIIIlIllllIlll == null) ? null : llllllllllllllllllIIIIlIllllIlll.getSessionID();
    }
    
    public static String getGameDirectoryPath() {
        return Minecraft.getMinecraft().mcDataDir.getAbsolutePath();
    }
    
    public static long currentTimeMillis() {
        return Minecraft.getSystemTime();
    }
    
    public static int survivalId() {
        return WorldSettings.GameType.SURVIVAL.getID();
    }
}
