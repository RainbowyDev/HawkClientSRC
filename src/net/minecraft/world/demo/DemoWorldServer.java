package net.minecraft.world.demo;

import net.minecraft.world.*;
import net.minecraft.server.*;
import net.minecraft.world.storage.*;
import net.minecraft.profiler.*;

public class DemoWorldServer extends WorldServer
{
    public static final /* synthetic */ WorldSettings demoWorldSettings;
    private static final /* synthetic */ long demoWorldSeed;
    
    static {
        __OBFID = "CL_00001428";
        demoWorldSeed = "North Carolina".hashCode();
        demoWorldSettings = new WorldSettings(DemoWorldServer.demoWorldSeed, WorldSettings.GameType.SURVIVAL, true, false, WorldType.DEFAULT).enableBonusChest();
    }
    
    public DemoWorldServer(final MinecraftServer llllllllllllllllIIIlIIllIIIlllll, final ISaveHandler llllllllllllllllIIIlIIllIIlIIlII, final WorldInfo llllllllllllllllIIIlIIllIIlIIIll, final int llllllllllllllllIIIlIIllIIlIIIlI, final Profiler llllllllllllllllIIIlIIllIIlIIIIl) {
        super(llllllllllllllllIIIlIIllIIIlllll, llllllllllllllllIIIlIIllIIlIIlII, llllllllllllllllIIIlIIllIIlIIIll, llllllllllllllllIIIlIIllIIlIIIlI, llllllllllllllllIIIlIIllIIlIIIIl);
        this.worldInfo.populateFromWorldSettings(DemoWorldServer.demoWorldSettings);
    }
}
