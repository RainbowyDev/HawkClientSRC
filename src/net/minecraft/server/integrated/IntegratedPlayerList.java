package net.minecraft.server.integrated;

import net.minecraft.server.management.*;
import net.minecraft.nbt.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import java.net.*;
import com.mojang.authlib.*;

public class IntegratedPlayerList extends ServerConfigurationManager
{
    private /* synthetic */ NBTTagCompound hostPlayerData;
    
    public IntegratedPlayerList(final IntegratedServer llllllllllllllIlIIIlIlIllIlllIlI) {
        super(llllllllllllllIlIIIlIlIllIlllIlI);
        this.setViewDistance(10);
    }
    
    @Override
    protected void writePlayerData(final EntityPlayerMP llllllllllllllIlIIIlIlIllIllIlII) {
        if (llllllllllllllIlIIIlIlIllIllIlII.getName().equals(this.func_180603_b().getServerOwner())) {
            this.hostPlayerData = new NBTTagCompound();
            llllllllllllllIlIIIlIlIllIllIlII.writeToNBT(this.hostPlayerData);
        }
        super.writePlayerData(llllllllllllllIlIIIlIlIllIllIlII);
    }
    
    @Override
    public MinecraftServer getServerInstance() {
        return this.func_180603_b();
    }
    
    static {
        __OBFID = "CL_00001128";
    }
    
    public IntegratedServer func_180603_b() {
        return (IntegratedServer)super.getServerInstance();
    }
    
    @Override
    public NBTTagCompound getHostPlayerData() {
        return this.hostPlayerData;
    }
    
    @Override
    public String allowUserToConnect(final SocketAddress llllllllllllllIlIIIlIlIllIlIllII, final GameProfile llllllllllllllIlIIIlIlIllIlIlllI) {
        return (llllllllllllllIlIIIlIlIllIlIlllI.getName().equalsIgnoreCase(this.func_180603_b().getServerOwner()) && this.getPlayerByUsername(llllllllllllllIlIIIlIlIllIlIlllI.getName()) != null) ? "That name is already taken." : super.allowUserToConnect(llllllllllllllIlIIIlIlIllIlIllII, llllllllllllllIlIIIlIlIllIlIlllI);
    }
}
