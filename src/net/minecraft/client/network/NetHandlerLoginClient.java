package net.minecraft.client.network;

import net.minecraft.network.login.*;
import net.minecraft.client.*;
import com.mojang.authlib.*;
import java.math.*;
import net.minecraft.util.*;
import com.mojang.authlib.exceptions.*;
import net.minecraft.network.login.client.*;
import javax.crypto.*;
import io.netty.util.concurrent.*;
import net.minecraft.network.*;
import java.security.*;
import com.mojang.authlib.minecraft.*;
import net.minecraft.network.login.server.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.gui.*;

public class NetHandlerLoginClient implements INetHandlerLoginClient
{
    private final /* synthetic */ NetworkManager field_147393_d;
    private final /* synthetic */ Minecraft field_147394_b;
    private final /* synthetic */ GuiScreen field_147395_c;
    private /* synthetic */ GameProfile field_175091_e;
    
    @Override
    public void handleLoginSuccess(final S02PacketLoginSuccess llllllllllllllllIlIlIIlllIlIllII) {
        this.field_175091_e = llllllllllllllllIlIlIIlllIlIllII.func_179730_a();
        this.field_147393_d.setConnectionState(EnumConnectionState.PLAY);
        this.field_147393_d.setNetHandler(new NetHandlerPlayClient(this.field_147394_b, this.field_147395_c, this.field_147393_d, this.field_175091_e));
    }
    
    @Override
    public void handleEncryptionRequest(final S01PacketEncryptionRequest llllllllllllllllIlIlIIllllIIIIIl) {
        final SecretKey llllllllllllllllIlIlIIllllIIIIII = CryptManager.createNewSharedKey();
        final String llllllllllllllllIlIlIIlllIllllll = llllllllllllllllIlIlIIllllIIIIIl.func_149609_c();
        final PublicKey llllllllllllllllIlIlIIlllIlllllI = llllllllllllllllIlIlIIllllIIIIIl.func_149608_d();
        final String llllllllllllllllIlIlIIlllIllllIl = new BigInteger(CryptManager.getServerIdHash(llllllllllllllllIlIlIIlllIllllll, llllllllllllllllIlIlIIlllIlllllI, llllllllllllllllIlIlIIllllIIIIII)).toString(16);
        try {
            this.func_147391_c().joinServer(this.field_147394_b.getSession().getProfile(), this.field_147394_b.getSession().getToken(), llllllllllllllllIlIlIIlllIllllIl);
        }
        catch (AuthenticationUnavailableException llllllllllllllllIlIlIIlllIllllII) {
            this.field_147393_d.closeChannel(new ChatComponentTranslation("disconnect.loginFailedInfo", new Object[] { new ChatComponentTranslation("disconnect.loginFailedInfo.serversUnavailable", new Object[0]) }));
            return;
        }
        catch (InvalidCredentialsException llllllllllllllllIlIlIIlllIlllIll) {
            this.field_147393_d.closeChannel(new ChatComponentTranslation("disconnect.loginFailedInfo", new Object[] { new ChatComponentTranslation("disconnect.loginFailedInfo.invalidSession", new Object[0]) }));
            return;
        }
        catch (AuthenticationException llllllllllllllllIlIlIIlllIlllIlI) {
            this.field_147393_d.closeChannel(new ChatComponentTranslation("disconnect.loginFailedInfo", new Object[] { llllllllllllllllIlIlIIlllIlllIlI.getMessage() }));
            return;
        }
        this.field_147393_d.sendPacket(new C01PacketEncryptionResponse(llllllllllllllllIlIlIIllllIIIIII, llllllllllllllllIlIlIIlllIlllllI, llllllllllllllllIlIlIIllllIIIIIl.func_149607_e()), (GenericFutureListener)new GenericFutureListener() {
            static {
                __OBFID = "CL_00000877";
            }
            
            public void operationComplete(final Future llllllllllllllllllllIIlIIIIllIIl) {
                NetHandlerLoginClient.this.field_147393_d.enableEncryption(llllllllllllllllIlIlIIllllIIIIII);
            }
        }, new GenericFutureListener[0]);
    }
    
    @Override
    public void func_180464_a(final S03PacketEnableCompression llllllllllllllllIlIlIIlllIIllIII) {
        if (!this.field_147393_d.isLocalChannel()) {
            this.field_147393_d.setCompressionTreshold(llllllllllllllllIlIlIIlllIIllIII.func_179731_a());
        }
    }
    
    public NetHandlerLoginClient(final NetworkManager llllllllllllllllIlIlIIllllIlIIII, final Minecraft llllllllllllllllIlIlIIllllIIllll, final GuiScreen llllllllllllllllIlIlIIllllIIlllI) {
        this.field_147393_d = llllllllllllllllIlIlIIllllIlIIII;
        this.field_147394_b = llllllllllllllllIlIlIIllllIIllll;
        this.field_147395_c = llllllllllllllllIlIlIIllllIIlllI;
    }
    
    private MinecraftSessionService func_147391_c() {
        return this.field_147394_b.getSessionService();
    }
    
    @Override
    public void handleDisconnect(final S00PacketDisconnect llllllllllllllllIlIlIIlllIIllllI) {
        this.field_147393_d.closeChannel(llllllllllllllllIlIlIIlllIIllllI.func_149603_c());
    }
    
    static {
        __OBFID = "CL_00000876";
        logger = LogManager.getLogger();
    }
    
    @Override
    public void onDisconnect(final IChatComponent llllllllllllllllIlIlIIlllIlIIlII) {
        this.field_147394_b.displayGuiScreen(new GuiDisconnected(this.field_147395_c, "connect.failed", llllllllllllllllIlIlIIlllIlIIlII));
    }
}
