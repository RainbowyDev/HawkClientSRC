package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.network.*;
import com.mojang.authlib.properties.*;
import java.io.*;
import com.mojang.authlib.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class S38PacketPlayerListItem implements Packet
{
    private /* synthetic */ Action field_179770_a;
    private final /* synthetic */ List field_179769_b;
    
    public void func_180743_a(final INetHandlerPlayClient llllllllllllllIlIIIlIIllIIIllIlI) {
        llllllllllllllIlIIIlIIllIIIllIlI.handlePlayerListItem(this);
    }
    
    static {
        __OBFID = "CL_00001318";
    }
    
    @Override
    public void processPacket(final INetHandler llllllllllllllIlIIIlIIllIIIIlllI) {
        this.func_180743_a((INetHandlerPlayClient)llllllllllllllIlIIIlIIllIIIIlllI);
    }
    
    public S38PacketPlayerListItem() {
        this.field_179769_b = Lists.newArrayList();
    }
    
    public List func_179767_a() {
        return this.field_179769_b;
    }
    
    public S38PacketPlayerListItem(final Action llllllllllllllIlIIIlIIllIllIlIII, final EntityPlayerMP... llllllllllllllIlIIIlIIllIllIlllI) {
        this.field_179769_b = Lists.newArrayList();
        this.field_179770_a = llllllllllllllIlIIIlIIllIllIlIII;
        final EntityPlayerMP[] llllllllllllllIlIIIlIIllIllIllIl = llllllllllllllIlIIIlIIllIllIlllI;
        for (int llllllllllllllIlIIIlIIllIllIllII = llllllllllllllIlIIIlIIllIllIlllI.length, llllllllllllllIlIIIlIIllIllIlIll = 0; llllllllllllllIlIIIlIIllIllIlIll < llllllllllllllIlIIIlIIllIllIllII; ++llllllllllllllIlIIIlIIllIllIlIll) {
            final EntityPlayerMP llllllllllllllIlIIIlIIllIllIlIlI = llllllllllllllIlIIIlIIllIllIllIl[llllllllllllllIlIIIlIIllIllIlIll];
            this.field_179769_b.add(new AddPlayerData(llllllllllllllIlIIIlIIllIllIlIlI.getGameProfile(), llllllllllllllIlIIIlIIllIllIlIlI.ping, llllllllllllllIlIIIlIIllIllIlIlI.theItemInWorldManager.getGameType(), llllllllllllllIlIIIlIIllIllIlIlI.func_175396_E()));
        }
    }
    
    public S38PacketPlayerListItem(final Action llllllllllllllIlIIIlIIllIlIlIlll, final Iterable llllllllllllllIlIIIlIIllIlIlIllI) {
        this.field_179769_b = Lists.newArrayList();
        this.field_179770_a = llllllllllllllIlIIIlIIllIlIlIlll;
        for (final EntityPlayerMP llllllllllllllIlIIIlIIllIlIllIIl : llllllllllllllIlIIIlIIllIlIlIllI) {
            this.field_179769_b.add(new AddPlayerData(llllllllllllllIlIIIlIIllIlIllIIl.getGameProfile(), llllllllllllllIlIIIlIIllIlIllIIl.ping, llllllllllllllIlIIIlIIllIlIllIIl.theItemInWorldManager.getGameType(), llllllllllllllIlIIIlIIllIlIllIIl.func_175396_E()));
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIIlIIllIIlIlIII) throws IOException {
        llllllllllllllIlIIIlIIllIIlIlIII.writeEnumValue(this.field_179770_a);
        llllllllllllllIlIIIlIIllIIlIlIII.writeVarIntToBuffer(this.field_179769_b.size());
        for (final AddPlayerData llllllllllllllIlIIIlIIllIIlIIllI : this.field_179769_b) {
            switch (SwitchAction.field_179938_a[this.field_179770_a.ordinal()]) {
                case 1: {
                    llllllllllllllIlIIIlIIllIIlIlIII.writeUuid(llllllllllllllIlIIIlIIllIIlIIllI.func_179962_a().getId());
                    llllllllllllllIlIIIlIIllIIlIlIII.writeString(llllllllllllllIlIIIlIIllIIlIIllI.func_179962_a().getName());
                    llllllllllllllIlIIIlIIllIIlIlIII.writeVarIntToBuffer(llllllllllllllIlIIIlIIllIIlIIllI.func_179962_a().getProperties().size());
                    for (final Property llllllllllllllIlIIIlIIllIIlIIlII : llllllllllllllIlIIIlIIllIIlIIllI.func_179962_a().getProperties().values()) {
                        llllllllllllllIlIIIlIIllIIlIlIII.writeString(llllllllllllllIlIIIlIIllIIlIIlII.getName());
                        llllllllllllllIlIIIlIIllIIlIlIII.writeString(llllllllllllllIlIIIlIIllIIlIIlII.getValue());
                        if (llllllllllllllIlIIIlIIllIIlIIlII.hasSignature()) {
                            llllllllllllllIlIIIlIIllIIlIlIII.writeBoolean(true);
                            llllllllllllllIlIIIlIIllIIlIlIII.writeString(llllllllllllllIlIIIlIIllIIlIIlII.getSignature());
                        }
                        else {
                            llllllllllllllIlIIIlIIllIIlIlIII.writeBoolean(false);
                        }
                    }
                    llllllllllllllIlIIIlIIllIIlIlIII.writeVarIntToBuffer(llllllllllllllIlIIIlIIllIIlIIllI.func_179960_c().getID());
                    llllllllllllllIlIIIlIIllIIlIlIII.writeVarIntToBuffer(llllllllllllllIlIIIlIIllIIlIIllI.func_179963_b());
                    if (llllllllllllllIlIIIlIIllIIlIIllI.func_179961_d() == null) {
                        llllllllllllllIlIIIlIIllIIlIlIII.writeBoolean(false);
                        continue;
                    }
                    llllllllllllllIlIIIlIIllIIlIlIII.writeBoolean(true);
                    llllllllllllllIlIIIlIIllIIlIlIII.writeChatComponent(llllllllllllllIlIIIlIIllIIlIIllI.func_179961_d());
                    continue;
                }
                case 4: {
                    llllllllllllllIlIIIlIIllIIlIlIII.writeUuid(llllllllllllllIlIIIlIIllIIlIIllI.func_179962_a().getId());
                    if (llllllllllllllIlIIIlIIllIIlIIllI.func_179961_d() == null) {
                        llllllllllllllIlIIIlIIllIIlIlIII.writeBoolean(false);
                        continue;
                    }
                    llllllllllllllIlIIIlIIllIIlIlIII.writeBoolean(true);
                    llllllllllllllIlIIIlIIllIIlIlIII.writeChatComponent(llllllllllllllIlIIIlIIllIIlIIllI.func_179961_d());
                    continue;
                }
                default: {
                    continue;
                }
                case 2: {
                    llllllllllllllIlIIIlIIllIIlIlIII.writeUuid(llllllllllllllIlIIIlIIllIIlIIllI.func_179962_a().getId());
                    llllllllllllllIlIIIlIIllIIlIlIII.writeVarIntToBuffer(llllllllllllllIlIIIlIIllIIlIIllI.func_179960_c().getID());
                    continue;
                }
                case 3: {
                    llllllllllllllIlIIIlIIllIIlIlIII.writeUuid(llllllllllllllIlIIIlIIllIIlIIllI.func_179962_a().getId());
                    llllllllllllllIlIIIlIIllIIlIlIII.writeVarIntToBuffer(llllllllllllllIlIIIlIIllIIlIIllI.func_179963_b());
                    continue;
                }
                case 5: {
                    llllllllllllllIlIIIlIIllIIlIlIII.writeUuid(llllllllllllllIlIIIlIIllIIlIIllI.func_179962_a().getId());
                    continue;
                }
            }
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIIlIIllIIlllIlI) throws IOException {
        this.field_179770_a = (Action)llllllllllllllIlIIIlIIllIIlllIlI.readEnumValue(Action.class);
        for (int llllllllllllllIlIIIlIIllIlIIIlIl = llllllllllllllIlIIIlIIllIIlllIlI.readVarIntFromBuffer(), llllllllllllllIlIIIlIIllIlIIIlII = 0; llllllllllllllIlIIIlIIllIlIIIlII < llllllllllllllIlIIIlIIllIlIIIlIl; ++llllllllllllllIlIIIlIIllIlIIIlII) {
            GameProfile llllllllllllllIlIIIlIIllIlIIIIll = null;
            int llllllllllllllIlIIIlIIllIlIIIIlI = 0;
            WorldSettings.GameType llllllllllllllIlIIIlIIllIlIIIIIl = null;
            IChatComponent llllllllllllllIlIIIlIIllIlIIIIII = null;
            switch (SwitchAction.field_179938_a[this.field_179770_a.ordinal()]) {
                case 1: {
                    llllllllllllllIlIIIlIIllIlIIIIll = new GameProfile(llllllllllllllIlIIIlIIllIIlllIlI.readUuid(), llllllllllllllIlIIIlIIllIIlllIlI.readStringFromBuffer(16));
                    for (int llllllllllllllIlIIIlIIllIIllllll = llllllllllllllIlIIIlIIllIIlllIlI.readVarIntFromBuffer(), llllllllllllllIlIIIlIIllIIlllllI = 0; llllllllllllllIlIIIlIIllIIlllllI < llllllllllllllIlIIIlIIllIIllllll; ++llllllllllllllIlIIIlIIllIIlllllI) {
                        final String llllllllllllllIlIIIlIIllIIllllIl = llllllllllllllIlIIIlIIllIIlllIlI.readStringFromBuffer(32767);
                        final String llllllllllllllIlIIIlIIllIIllllII = llllllllllllllIlIIIlIIllIIlllIlI.readStringFromBuffer(32767);
                        if (llllllllllllllIlIIIlIIllIIlllIlI.readBoolean()) {
                            llllllllllllllIlIIIlIIllIlIIIIll.getProperties().put((Object)llllllllllllllIlIIIlIIllIIllllIl, (Object)new Property(llllllllllllllIlIIIlIIllIIllllIl, llllllllllllllIlIIIlIIllIIllllII, llllllllllllllIlIIIlIIllIIlllIlI.readStringFromBuffer(32767)));
                        }
                        else {
                            llllllllllllllIlIIIlIIllIlIIIIll.getProperties().put((Object)llllllllllllllIlIIIlIIllIIllllIl, (Object)new Property(llllllllllllllIlIIIlIIllIIllllIl, llllllllllllllIlIIIlIIllIIllllII));
                        }
                    }
                    llllllllllllllIlIIIlIIllIlIIIIIl = WorldSettings.GameType.getByID(llllllllllllllIlIIIlIIllIIlllIlI.readVarIntFromBuffer());
                    llllllllllllllIlIIIlIIllIlIIIIlI = llllllllllllllIlIIIlIIllIIlllIlI.readVarIntFromBuffer();
                    if (llllllllllllllIlIIIlIIllIIlllIlI.readBoolean()) {
                        llllllllllllllIlIIIlIIllIlIIIIII = llllllllllllllIlIIIlIIllIIlllIlI.readChatComponent();
                        break;
                    }
                    break;
                }
                case 2: {
                    llllllllllllllIlIIIlIIllIlIIIIll = new GameProfile(llllllllllllllIlIIIlIIllIIlllIlI.readUuid(), (String)null);
                    llllllllllllllIlIIIlIIllIlIIIIIl = WorldSettings.GameType.getByID(llllllllllllllIlIIIlIIllIIlllIlI.readVarIntFromBuffer());
                    break;
                }
                case 3: {
                    llllllllllllllIlIIIlIIllIlIIIIll = new GameProfile(llllllllllllllIlIIIlIIllIIlllIlI.readUuid(), (String)null);
                    llllllllllllllIlIIIlIIllIlIIIIlI = llllllllllllllIlIIIlIIllIIlllIlI.readVarIntFromBuffer();
                    break;
                }
                case 4: {
                    llllllllllllllIlIIIlIIllIlIIIIll = new GameProfile(llllllllllllllIlIIIlIIllIIlllIlI.readUuid(), (String)null);
                    if (llllllllllllllIlIIIlIIllIIlllIlI.readBoolean()) {
                        llllllllllllllIlIIIlIIllIlIIIIII = llllllllllllllIlIIIlIIllIIlllIlI.readChatComponent();
                        break;
                    }
                    break;
                }
                case 5: {
                    llllllllllllllIlIIIlIIllIlIIIIll = new GameProfile(llllllllllllllIlIIIlIIllIIlllIlI.readUuid(), (String)null);
                    break;
                }
            }
            this.field_179769_b.add(new AddPlayerData(llllllllllllllIlIIIlIIllIlIIIIll, llllllllllllllIlIIIlIIllIlIIIIlI, llllllllllllllIlIIIlIIllIlIIIIIl, llllllllllllllIlIIIlIIllIlIIIIII));
        }
    }
    
    public Action func_179768_b() {
        return this.field_179770_a;
    }
    
    public enum Action
    {
        UPDATE_LATENCY("UPDATE_LATENCY", 2, "UPDATE_LATENCY", 2), 
        REMOVE_PLAYER("REMOVE_PLAYER", 4, "REMOVE_PLAYER", 4), 
        UPDATE_GAME_MODE("UPDATE_GAME_MODE", 1, "UPDATE_GAME_MODE", 1), 
        UPDATE_DISPLAY_NAME("UPDATE_DISPLAY_NAME", 3, "UPDATE_DISPLAY_NAME", 3), 
        ADD_PLAYER("ADD_PLAYER", 0, "ADD_PLAYER", 0);
        
        private Action(final String lllllllllllllllIIlIlllIlIIIIlIII, final int lllllllllllllllIIlIlllIlIIIIIlll, final String lllllllllllllllIIlIlllIlIIIIlIll, final int lllllllllllllllIIlIlllIlIIIIlIlI) {
        }
        
        static {
            __OBFID = "CL_00002295";
        }
    }
    
    static final class SwitchAction
    {
        static final /* synthetic */ int[] field_179938_a;
        
        static {
            __OBFID = "CL_00002296";
            field_179938_a = new int[Action.values().length];
            try {
                SwitchAction.field_179938_a[Action.ADD_PLAYER.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchAction.field_179938_a[Action.UPDATE_GAME_MODE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchAction.field_179938_a[Action.UPDATE_LATENCY.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchAction.field_179938_a[Action.UPDATE_DISPLAY_NAME.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchAction.field_179938_a[Action.REMOVE_PLAYER.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
        }
    }
    
    public class AddPlayerData
    {
        private final /* synthetic */ WorldSettings.GameType field_179967_c;
        private final /* synthetic */ int field_179966_b;
        private final /* synthetic */ IChatComponent field_179965_e;
        private final /* synthetic */ GameProfile field_179964_d;
        
        public WorldSettings.GameType func_179960_c() {
            return this.field_179967_c;
        }
        
        public GameProfile func_179962_a() {
            return this.field_179964_d;
        }
        
        public IChatComponent func_179961_d() {
            return this.field_179965_e;
        }
        
        public int func_179963_b() {
            return this.field_179966_b;
        }
        
        static {
            __OBFID = "CL_00002294";
        }
        
        public AddPlayerData(final GameProfile lllllllllllllllIIlIllIIIlIllIIll, final int lllllllllllllllIIlIllIIIlIllIIlI, final WorldSettings.GameType lllllllllllllllIIlIllIIIlIllIlll, final IChatComponent lllllllllllllllIIlIllIIIlIllIllI) {
            this.field_179964_d = lllllllllllllllIIlIllIIIlIllIIll;
            this.field_179966_b = lllllllllllllllIIlIllIIIlIllIIlI;
            this.field_179967_c = lllllllllllllllIIlIllIIIlIllIlll;
            this.field_179965_e = lllllllllllllllIIlIllIIIlIllIllI;
        }
    }
}
