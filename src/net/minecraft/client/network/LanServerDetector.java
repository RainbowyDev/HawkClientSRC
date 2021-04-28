package net.minecraft.client.network;

import java.util.concurrent.atomic.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.client.multiplayer.*;
import java.util.*;
import net.minecraft.client.*;
import java.io.*;
import java.net.*;

public class LanServerDetector
{
    private static final /* synthetic */ AtomicInteger field_148551_a;
    private static final /* synthetic */ Logger logger;
    
    static {
        __OBFID = "CL_00001133";
        field_148551_a = new AtomicInteger(0);
        logger = LogManager.getLogger();
    }
    
    public static class LanServerList
    {
        /* synthetic */ boolean wasUpdated;
        private /* synthetic */ List listOfLanServers;
        
        public synchronized boolean getWasUpdated() {
            return this.wasUpdated;
        }
        
        public synchronized List getLanServers() {
            return Collections.unmodifiableList((List<?>)this.listOfLanServers);
        }
        
        public LanServerList() {
            this.listOfLanServers = Lists.newArrayList();
        }
        
        static {
            __OBFID = "CL_00001136";
        }
        
        public synchronized void func_77551_a(final String llllllllllllllIlIIlllIIllIIIIIll, final InetAddress llllllllllllllIlIIlllIIlIllllIlI) {
            final String llllllllllllllIlIIlllIIllIIIIIIl = ThreadLanServerPing.getMotdFromPingResponse(llllllllllllllIlIIlllIIllIIIIIll);
            String llllllllllllllIlIIlllIIllIIIIIII = ThreadLanServerPing.getAdFromPingResponse(llllllllllllllIlIIlllIIllIIIIIll);
            if (llllllllllllllIlIIlllIIllIIIIIII != null) {
                llllllllllllllIlIIlllIIllIIIIIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIlllIIlIllllIlI.getHostAddress())).append(":").append(llllllllllllllIlIIlllIIllIIIIIII));
                boolean llllllllllllllIlIIlllIIlIlllllll = false;
                for (final LanServer llllllllllllllIlIIlllIIlIlllllIl : this.listOfLanServers) {
                    if (llllllllllllllIlIIlllIIlIlllllIl.getServerIpPort().equals(llllllllllllllIlIIlllIIllIIIIIII)) {
                        llllllllllllllIlIIlllIIlIlllllIl.updateLastSeen();
                        llllllllllllllIlIIlllIIlIlllllll = true;
                        break;
                    }
                }
                if (!llllllllllllllIlIIlllIIlIlllllll) {
                    this.listOfLanServers.add(new LanServer(llllllllllllllIlIIlllIIllIIIIIIl, llllllllllllllIlIIlllIIllIIIIIII));
                    this.wasUpdated = true;
                }
            }
        }
        
        public synchronized void setWasNotUpdated() {
            this.wasUpdated = false;
        }
    }
    
    public static class LanServer
    {
        private /* synthetic */ String lanServerMotd;
        private /* synthetic */ String lanServerIpPort;
        private /* synthetic */ long timeLastSeen;
        
        public LanServer(final String lllllllllllllllIlIIlIIIIIIIlllll, final String lllllllllllllllIlIIlIIIIIIlIIIIl) {
            this.lanServerMotd = lllllllllllllllIlIIlIIIIIIIlllll;
            this.lanServerIpPort = lllllllllllllllIlIIlIIIIIIlIIIIl;
            this.timeLastSeen = Minecraft.getSystemTime();
        }
        
        public void updateLastSeen() {
            this.timeLastSeen = Minecraft.getSystemTime();
        }
        
        public String getServerIpPort() {
            return this.lanServerIpPort;
        }
        
        public String getServerMotd() {
            return this.lanServerMotd;
        }
        
        static {
            __OBFID = "CL_00001134";
        }
    }
    
    public static class ThreadLanServerFind extends Thread
    {
        private final /* synthetic */ InetAddress broadcastAddress;
        private final /* synthetic */ MulticastSocket socket;
        private final /* synthetic */ LanServerList localServerList;
        
        static {
            __OBFID = "CL_00001135";
        }
        
        public ThreadLanServerFind(final LanServerList llllllllllllllIlllllllIIIIllIIII) throws IOException {
            super(String.valueOf(new StringBuilder("LanServerDetector #").append(LanServerDetector.field_148551_a.incrementAndGet())));
            this.localServerList = llllllllllllllIlllllllIIIIllIIII;
            this.setDaemon(true);
            this.socket = new MulticastSocket(4445);
            this.broadcastAddress = InetAddress.getByName("224.0.2.60");
            this.socket.setSoTimeout(5000);
            this.socket.joinGroup(this.broadcastAddress);
        }
        
        @Override
        public void run() {
            final byte[] llllllllllllllIlllllllIIIIIlIIII = new byte[1024];
            while (!this.isInterrupted()) {
                final DatagramPacket llllllllllllllIlllllllIIIIIIlllI = new DatagramPacket(llllllllllllllIlllllllIIIIIlIIII, llllllllllllllIlllllllIIIIIlIIII.length);
                try {
                    this.socket.receive(llllllllllllllIlllllllIIIIIIlllI);
                }
                catch (SocketTimeoutException llllllllllllllIlllllllIIIIIIllII) {
                    continue;
                }
                catch (IOException llllllllllllllIlllllllIIIIIIlIlI) {
                    LanServerDetector.logger.error("Couldn't ping server", (Throwable)llllllllllllllIlllllllIIIIIIlIlI);
                    break;
                }
                final String llllllllllllllIlllllllIIIIIIlIII = new String(llllllllllllllIlllllllIIIIIIlllI.getData(), llllllllllllllIlllllllIIIIIIlllI.getOffset(), llllllllllllllIlllllllIIIIIIlllI.getLength());
                LanServerDetector.logger.debug(String.valueOf(new StringBuilder().append(llllllllllllllIlllllllIIIIIIlllI.getAddress()).append(": ").append(llllllllllllllIlllllllIIIIIIlIII)));
                this.localServerList.func_77551_a(llllllllllllllIlllllllIIIIIIlIII, llllllllllllllIlllllllIIIIIIlllI.getAddress());
            }
            try {
                this.socket.leaveGroup(this.broadcastAddress);
            }
            catch (IOException ex) {}
            this.socket.close();
        }
    }
}
