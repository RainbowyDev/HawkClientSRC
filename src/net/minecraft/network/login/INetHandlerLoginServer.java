package net.minecraft.network.login;

import net.minecraft.network.*;
import net.minecraft.network.login.client.*;

public interface INetHandlerLoginServer extends INetHandler
{
    void processEncryptionResponse(final C01PacketEncryptionResponse p0);
    
    void processLoginStart(final C00PacketLoginStart p0);
}
