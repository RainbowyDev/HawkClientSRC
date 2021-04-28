package net.minecraft.server.network;

import net.minecraft.network.login.*;
import net.minecraft.server.gui.*;
import java.util.concurrent.atomic.*;
import javax.crypto.*;
import net.minecraft.server.*;
import com.mojang.authlib.*;
import org.apache.commons.lang3.*;
import net.minecraft.network.*;
import org.apache.logging.log4j.*;
import io.netty.channel.*;
import io.netty.util.concurrent.*;
import net.minecraft.network.login.server.*;
import net.minecraft.network.login.client.*;
import net.minecraft.util.*;
import java.math.*;
import java.util.*;
import com.mojang.authlib.exceptions.*;
import java.security.*;
import com.google.common.base.*;

public class NetHandlerLoginServer implements INetHandlerLoginServer, IUpdatePlayerListBox
{
    private /* synthetic */ int connectionTimer;
    private static final /* synthetic */ Random RANDOM;
    private static final /* synthetic */ AtomicInteger AUTHENTICATOR_THREAD_ID;
    private /* synthetic */ SecretKey secretKey;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ MinecraftServer server;
    private /* synthetic */ GameProfile loginGameProfile;
    private final /* synthetic */ byte[] field_147330_e;
    private /* synthetic */ String serverId;
    private /* synthetic */ LoginState currentLoginState;
    public final /* synthetic */ NetworkManager networkManager;
    
    @Override
    public void processLoginStart(final C00PacketLoginStart llllllllllllllIllIIllIllIllIIllI) {
        Validate.validState(this.currentLoginState == LoginState.HELLO, "Unexpected hello packet", new Object[0]);
        this.loginGameProfile = llllllllllllllIllIIllIllIllIIllI.getProfile();
        if (this.server.isServerInOnlineMode() && !this.networkManager.isLocalChannel()) {
            this.currentLoginState = LoginState.KEY;
            this.networkManager.sendPacket(new S01PacketEncryptionRequest(this.serverId, this.server.getKeyPair().getPublic(), this.field_147330_e));
        }
        else {
            this.currentLoginState = LoginState.READY_TO_ACCEPT;
        }
    }
    
    public NetHandlerLoginServer(final MinecraftServer llllllllllllllIllIIllIlllIIIlIIl, final NetworkManager llllllllllllllIllIIllIlllIIIlIll) {
        this.field_147330_e = new byte[4];
        this.currentLoginState = LoginState.HELLO;
        this.serverId = "";
        this.server = llllllllllllllIllIIllIlllIIIlIIl;
        this.networkManager = llllllllllllllIllIIllIlllIIIlIll;
        NetHandlerLoginServer.RANDOM.nextBytes(this.field_147330_e);
    }
    
    static /* synthetic */ void access$6(final NetHandlerLoginServer llllllllllllllIllIIllIllIlIIIlll, final LoginState llllllllllllllIllIIllIllIlIIIllI) {
        llllllllllllllIllIIllIllIlIIIlll.currentLoginState = llllllllllllllIllIIllIllIlIIIllI;
    }
    
    public void closeConnection(final String llllllllllllllIllIIllIllIlllllII) {
        try {
            NetHandlerLoginServer.logger.info(String.valueOf(new StringBuilder("Disconnecting ").append(this.func_147317_d()).append(": ").append(llllllllllllllIllIIllIllIlllllII)));
            final ChatComponentText llllllllllllllIllIIllIllIlllllll = new ChatComponentText(llllllllllllllIllIIllIllIlllllII);
            this.networkManager.sendPacket(new S00PacketDisconnect(llllllllllllllIllIIllIllIlllllll));
            this.networkManager.closeChannel(llllllllllllllIllIIllIllIlllllll);
        }
        catch (Exception llllllllllllllIllIIllIllIllllllI) {
            NetHandlerLoginServer.logger.error("Error whilst disconnecting player", (Throwable)llllllllllllllIllIIllIllIllllllI);
        }
    }
    
    static /* synthetic */ void access$4(final NetHandlerLoginServer llllllllllllllIllIIllIllIlIIlIll, final GameProfile llllllllllllllIllIIllIllIlIIlIlI) {
        llllllllllllllIllIIllIllIlIIlIll.loginGameProfile = llllllllllllllIllIIllIllIlIIlIlI;
    }
    
    static {
        __OBFID = "CL_00001458";
        AUTHENTICATOR_THREAD_ID = new AtomicInteger(0);
        logger = LogManager.getLogger();
        RANDOM = new Random();
    }
    
    public void func_147326_c() {
        if (!this.loginGameProfile.isComplete()) {
            this.loginGameProfile = this.getOfflineProfile(this.loginGameProfile);
        }
        final String llllllllllllllIllIIllIllIlllIlll = this.server.getConfigurationManager().allowUserToConnect(this.networkManager.getRemoteAddress(), this.loginGameProfile);
        if (llllllllllllllIllIIllIllIlllIlll != null) {
            this.closeConnection(llllllllllllllIllIIllIllIlllIlll);
        }
        else {
            this.currentLoginState = LoginState.ACCEPTED;
            if (this.server.getNetworkCompressionTreshold() >= 0 && !this.networkManager.isLocalChannel()) {
                this.networkManager.sendPacket(new S03PacketEnableCompression(this.server.getNetworkCompressionTreshold()), (GenericFutureListener)new ChannelFutureListener() {
                    public void operationComplete(final ChannelFuture llllllllllllllllIIIIIllIIIIIlllI) {
                        NetHandlerLoginServer.this.networkManager.setCompressionTreshold(NetHandlerLoginServer.this.server.getNetworkCompressionTreshold());
                    }
                    
                    static {
                        __OBFID = "CL_00001459";
                    }
                }, new GenericFutureListener[0]);
            }
            this.networkManager.sendPacket(new S02PacketLoginSuccess(this.loginGameProfile));
            this.server.getConfigurationManager().initializeConnectionToPlayer(this.networkManager, this.server.getConfigurationManager().createPlayerForUser(this.loginGameProfile));
        }
    }
    
    @Override
    public void processEncryptionResponse(final C01PacketEncryptionResponse llllllllllllllIllIIllIllIllIIIIl) {
        Validate.validState(this.currentLoginState == LoginState.KEY, "Unexpected key packet", new Object[0]);
        final PrivateKey llllllllllllllIllIIllIllIllIIIII = this.server.getKeyPair().getPrivate();
        if (!Arrays.equals(this.field_147330_e, llllllllllllllIllIIllIllIllIIIIl.func_149299_b(llllllllllllllIllIIllIllIllIIIII))) {
            throw new IllegalStateException("Invalid nonce!");
        }
        this.secretKey = llllllllllllllIllIIllIllIllIIIIl.func_149300_a(llllllllllllllIllIIllIllIllIIIII);
        this.currentLoginState = LoginState.AUTHENTICATING;
        this.networkManager.enableEncryption(this.secretKey);
        new Thread(String.valueOf(new StringBuilder("User Authenticator #").append(NetHandlerLoginServer.AUTHENTICATOR_THREAD_ID.incrementAndGet()))) {
            @Override
            public void run() {
                final GameProfile llllllllllllllIllIlIIlIIIIllIIll = NetHandlerLoginServer.this.loginGameProfile;
                try {
                    final String llllllllllllllIllIlIIlIIIIllIIlI = new BigInteger(CryptManager.getServerIdHash(NetHandlerLoginServer.this.serverId, NetHandlerLoginServer.this.server.getKeyPair().getPublic(), NetHandlerLoginServer.this.secretKey)).toString(16);
                    NetHandlerLoginServer.access$4(NetHandlerLoginServer.this, NetHandlerLoginServer.this.server.getMinecraftSessionService().hasJoinedServer(new GameProfile((UUID)null, llllllllllllllIllIlIIlIIIIllIIll.getName()), llllllllllllllIllIlIIlIIIIllIIlI));
                    if (NetHandlerLoginServer.this.loginGameProfile != null) {
                        NetHandlerLoginServer.logger.info(String.valueOf(new StringBuilder("UUID of player ").append(NetHandlerLoginServer.this.loginGameProfile.getName()).append(" is ").append(NetHandlerLoginServer.this.loginGameProfile.getId())));
                        NetHandlerLoginServer.access$6(NetHandlerLoginServer.this, LoginState.READY_TO_ACCEPT);
                    }
                    else if (NetHandlerLoginServer.this.server.isSinglePlayer()) {
                        NetHandlerLoginServer.logger.warn("Failed to verify username but will let them in anyway!");
                        NetHandlerLoginServer.access$4(NetHandlerLoginServer.this, NetHandlerLoginServer.this.getOfflineProfile(llllllllllllllIllIlIIlIIIIllIIll));
                        NetHandlerLoginServer.access$6(NetHandlerLoginServer.this, LoginState.READY_TO_ACCEPT);
                    }
                    else {
                        NetHandlerLoginServer.this.closeConnection("Failed to verify username!");
                        NetHandlerLoginServer.logger.error(String.valueOf(new StringBuilder("Username '").append(NetHandlerLoginServer.this.loginGameProfile.getName()).append("' tried to join with an invalid session")));
                    }
                }
                catch (AuthenticationUnavailableException llllllllllllllIllIlIIlIIIIllIIIl) {
                    if (NetHandlerLoginServer.this.server.isSinglePlayer()) {
                        NetHandlerLoginServer.logger.warn("Authentication servers are down but will let them in anyway!");
                        NetHandlerLoginServer.access$4(NetHandlerLoginServer.this, NetHandlerLoginServer.this.getOfflineProfile(llllllllllllllIllIlIIlIIIIllIIll));
                        NetHandlerLoginServer.access$6(NetHandlerLoginServer.this, LoginState.READY_TO_ACCEPT);
                    }
                    else {
                        NetHandlerLoginServer.this.closeConnection("Authentication servers are down. Please try again later, sorry!");
                        NetHandlerLoginServer.logger.error("Couldn't verify username because servers are unavailable");
                    }
                }
            }
            
            static {
                __OBFID = "CL_00002268";
            }
        }.start();
    }
    
    public String func_147317_d() {
        return (this.loginGameProfile != null) ? String.valueOf(new StringBuilder(String.valueOf(this.loginGameProfile.toString())).append(" (").append(this.networkManager.getRemoteAddress().toString()).append(")")) : String.valueOf(this.networkManager.getRemoteAddress());
    }
    
    protected GameProfile getOfflineProfile(final GameProfile llllllllllllllIllIIllIllIlIlIlll) {
        final UUID llllllllllllllIllIIllIllIlIllIII = UUID.nameUUIDFromBytes(String.valueOf(new StringBuilder("OfflinePlayer:").append(llllllllllllllIllIIllIllIlIlIlll.getName())).getBytes(Charsets.UTF_8));
        return new GameProfile(llllllllllllllIllIIllIllIlIllIII, llllllllllllllIllIIllIllIlIlIlll.getName());
    }
    
    @Override
    public void onDisconnect(final IChatComponent llllllllllllllIllIIllIllIllIllll) {
        NetHandlerLoginServer.logger.info(String.valueOf(new StringBuilder(String.valueOf(this.func_147317_d())).append(" lost connection: ").append(llllllllllllllIllIIllIllIllIllll.getUnformattedText())));
    }
    
    @Override
    public void update() {
        if (this.currentLoginState == LoginState.READY_TO_ACCEPT) {
            this.func_147326_c();
        }
        if (this.connectionTimer++ == 600) {
            this.closeConnection("Took too long to log in");
        }
    }
    
    enum LoginState
    {
        KEY("KEY", 1, "KEY", 1), 
        READY_TO_ACCEPT("READY_TO_ACCEPT", 3, "READY_TO_ACCEPT", 3), 
        AUTHENTICATING("AUTHENTICATING", 2, "AUTHENTICATING", 2), 
        HELLO("HELLO", 0, "HELLO", 0), 
        ACCEPTED("ACCEPTED", 4, "ACCEPTED", 4);
        
        static {
            __OBFID = "CL_00001463";
        }
        
        private LoginState(final String llllllllllllllIlIIlllllIIlllIIII, final int llllllllllllllIlIIlllllIIllIllll, final String llllllllllllllIlIIlllllIIlllIIll, final int llllllllllllllIlIIlllllIIlllIIlI) {
        }
    }
}
