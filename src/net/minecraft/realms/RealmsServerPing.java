package net.minecraft.realms;

public class RealmsServerPing
{
    public volatile /* synthetic */ long lastPingSnapshot;
    public volatile /* synthetic */ String nrOfPlayers;
    
    static {
        __OBFID = "CL_00002328";
    }
    
    public RealmsServerPing() {
        this.nrOfPlayers = "0";
        this.lastPingSnapshot = 0L;
    }
}
