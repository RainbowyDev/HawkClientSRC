package net.minecraft.realms;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import java.lang.reflect.*;
import org.apache.logging.log4j.*;

public class RealmsBridge extends RealmsScreen
{
    private /* synthetic */ GuiScreen previousScreen;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public void init() {
        Minecraft.getMinecraft().displayGuiScreen(this.previousScreen);
    }
    
    public void switchToRealms(final GuiScreen llllllllllllllIIllllIIIIlIllIIII) {
        this.previousScreen = llllllllllllllIIllllIIIIlIllIIII;
        try {
            final Class llllllllllllllIIllllIIIIlIlllIlI = Class.forName("com.mojang.realmsclient.RealmsMainScreen");
            final Constructor llllllllllllllIIllllIIIIlIlllIII = llllllllllllllIIllllIIIIlIlllIlI.getDeclaredConstructor(RealmsScreen.class);
            llllllllllllllIIllllIIIIlIlllIII.setAccessible(true);
            final Object llllllllllllllIIllllIIIIlIllIllI = llllllllllllllIIllllIIIIlIlllIII.newInstance(this);
            Minecraft.getMinecraft().displayGuiScreen(((RealmsScreen)llllllllllllllIIllllIIIIlIllIllI).getProxy());
        }
        catch (Exception llllllllllllllIIllllIIIIlIllIlII) {
            RealmsBridge.LOGGER.error("Realms module missing", (Throwable)llllllllllllllIIllllIIIIlIllIlII);
        }
    }
    
    static {
        __OBFID = "CL_00001869";
        LOGGER = LogManager.getLogger();
    }
}
