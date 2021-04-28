package net.minecraft.network;

import net.minecraft.util.*;

public class PacketThreadUtil
{
    static {
        __OBFID = "CL_00002306";
    }
    
    public static void func_180031_a(final Packet llllllllllllllIIlIllllIIIIIlIlIl, final INetHandler llllllllllllllIIlIllllIIIIIlIlII, final IThreadListener llllllllllllllIIlIllllIIIIIlIllI) {
        if (!llllllllllllllIIlIllllIIIIIlIllI.isCallingFromMinecraftThread()) {
            llllllllllllllIIlIllllIIIIIlIllI.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    llllllllllllllIIlIllllIIIIIlIlIl.processPacket(llllllllllllllIIlIllllIIIIIlIlII);
                }
                
                static {
                    __OBFID = "CL_00002305";
                }
            });
            throw ThreadQuickExitException.field_179886_a;
        }
    }
}
