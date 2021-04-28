package net.minecraft.client.network;

import net.minecraft.util.*;
import com.mojang.authlib.*;
import net.minecraft.world.*;
import com.google.common.base.*;
import net.minecraft.network.play.server.*;
import net.minecraft.scoreboard.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import com.mojang.authlib.minecraft.*;

public class NetworkPlayerInfo
{
    private /* synthetic */ long field_178871_k;
    private /* synthetic */ boolean field_178864_d;
    private /* synthetic */ int responseTime;
    private /* synthetic */ long field_178868_l;
    private /* synthetic */ int field_178870_j;
    private /* synthetic */ IChatComponent field_178872_h;
    private /* synthetic */ int field_178873_i;
    private /* synthetic */ ResourceLocation field_178865_e;
    private final /* synthetic */ GameProfile field_178867_a;
    private /* synthetic */ String field_178863_g;
    private /* synthetic */ WorldSettings.GameType gameType;
    private /* synthetic */ long field_178869_m;
    private /* synthetic */ ResourceLocation field_178862_f;
    
    public WorldSettings.GameType getGameType() {
        return this.gameType;
    }
    
    public void func_178843_c(final long llllllllllllllIIlIlIIlIIlIllIIIl) {
        this.field_178869_m = llllllllllllllIIlIlIIlIIlIllIIIl;
    }
    
    static {
        __OBFID = "CL_00000888";
    }
    
    public ResourceLocation func_178837_g() {
        if (this.field_178865_e == null) {
            this.func_178841_j();
        }
        return (ResourceLocation)Objects.firstNonNull((Object)this.field_178865_e, (Object)DefaultPlayerSkin.func_177334_a(this.field_178867_a.getId()));
    }
    
    public long func_178858_o() {
        return this.field_178868_l;
    }
    
    public int getResponseTime() {
        return this.responseTime;
    }
    
    public void func_178857_c(final int llllllllllllllIIlIlIIlIIllIlllll) {
        this.field_178870_j = llllllllllllllIIlIlIIlIIllIlllll;
    }
    
    public int func_178835_l() {
        return this.field_178873_i;
    }
    
    public boolean func_178856_e() {
        return this.field_178865_e != null;
    }
    
    public void func_178844_b(final long llllllllllllllIIlIlIIlIIllIIIIII) {
        this.field_178868_l = llllllllllllllIIlIlIIlIIllIIIIII;
    }
    
    protected void func_178838_a(final int llllllllllllllIIlIlIIlIlIIllIlll) {
        this.responseTime = llllllllllllllIIlIlIIlIlIIllIlll;
    }
    
    public ResourceLocation func_178861_h() {
        if (this.field_178862_f == null) {
            this.func_178841_j();
        }
        return this.field_178862_f;
    }
    
    static /* synthetic */ void access$0(final NetworkPlayerInfo llllllllllllllIIlIlIIlIIlIlIlllI, final ResourceLocation llllllllllllllIIlIlIIlIIlIlIllIl) {
        llllllllllllllIIlIlIIlIIlIlIlllI.field_178865_e = llllllllllllllIIlIlIIlIIlIlIllIl;
    }
    
    public long func_178847_n() {
        return this.field_178871_k;
    }
    
    public NetworkPlayerInfo(final S38PacketPlayerListItem.AddPlayerData llllllllllllllIIlIlIIlIlIlIIllIl) {
        this.field_178864_d = false;
        this.field_178873_i = 0;
        this.field_178870_j = 0;
        this.field_178871_k = 0L;
        this.field_178868_l = 0L;
        this.field_178869_m = 0L;
        this.field_178867_a = llllllllllllllIIlIlIIlIlIlIIllIl.func_179962_a();
        this.gameType = llllllllllllllIIlIlIIlIlIlIIllIl.func_179960_c();
        this.responseTime = llllllllllllllIIlIlIIlIlIlIIllIl.func_179963_b();
    }
    
    public IChatComponent func_178854_k() {
        return this.field_178872_h;
    }
    
    public long func_178855_p() {
        return this.field_178869_m;
    }
    
    public NetworkPlayerInfo(final GameProfile llllllllllllllIIlIlIIlIlIlIlIIll) {
        this.field_178864_d = false;
        this.field_178873_i = 0;
        this.field_178870_j = 0;
        this.field_178871_k = 0L;
        this.field_178868_l = 0L;
        this.field_178869_m = 0L;
        this.field_178867_a = llllllllllllllIIlIlIIlIlIlIlIIll;
    }
    
    public String func_178851_f() {
        return (this.field_178863_g == null) ? DefaultPlayerSkin.func_177332_b(this.field_178867_a.getId()) : this.field_178863_g;
    }
    
    public ScorePlayerTeam func_178850_i() {
        return Minecraft.getMinecraft().theWorld.getScoreboard().getPlayersTeam(this.func_178845_a().getName());
    }
    
    public int func_178860_m() {
        return this.field_178870_j;
    }
    
    public void func_178846_a(final long llllllllllllllIIlIlIIlIIllIlIIIl) {
        this.field_178871_k = llllllllllllllIIlIlIIlIIllIlIIIl;
    }
    
    protected void func_178839_a(final WorldSettings.GameType llllllllllllllIIlIlIIlIlIIlllIll) {
        this.gameType = llllllllllllllIIlIlIIlIlIIlllIll;
    }
    
    public GameProfile func_178845_a() {
        return this.field_178867_a;
    }
    
    protected void func_178841_j() {
        final float llllllllllllllIIlIlIIlIlIIIlIIIl = (float)this;
        synchronized (this) {
            if (!this.field_178864_d) {
                this.field_178864_d = true;
                Minecraft.getMinecraft().getSkinManager().func_152790_a(this.field_178867_a, new SkinManager.SkinAvailableCallback() {
                    static {
                        __OBFID = "CL_00002619";
                    }
                    
                    @Override
                    public void func_180521_a(final MinecraftProfileTexture.Type lIlIIIIIlllIl, final ResourceLocation lIlIIIIIlllII, final MinecraftProfileTexture lIlIIIIIllIll) {
                        switch (SwitchType.field_178875_a[lIlIIIIIlllIl.ordinal()]) {
                            case 1: {
                                NetworkPlayerInfo.access$0(NetworkPlayerInfo.this, lIlIIIIIlllII);
                                NetworkPlayerInfo.access$1(NetworkPlayerInfo.this, lIlIIIIIllIll.getMetadata("model"));
                                if (NetworkPlayerInfo.this.field_178863_g == null) {
                                    NetworkPlayerInfo.access$1(NetworkPlayerInfo.this, "default");
                                    break;
                                }
                                break;
                            }
                            case 2: {
                                NetworkPlayerInfo.access$3(NetworkPlayerInfo.this, lIlIIIIIlllII);
                                break;
                            }
                        }
                    }
                }, true);
            }
        }
    }
    
    public void func_178836_b(final int llllllllllllllIIlIlIIlIIllllIIII) {
        this.field_178873_i = llllllllllllllIIlIlIIlIIllllIIII;
    }
    
    static /* synthetic */ void access$1(final NetworkPlayerInfo llllllllllllllIIlIlIIlIIlIlIIllI, final String llllllllllllllIIlIlIIlIIlIlIIlII) {
        llllllllllllllIIlIlIIlIIlIlIIllI.field_178863_g = llllllllllllllIIlIlIIlIIlIlIIlII;
    }
    
    static /* synthetic */ void access$3(final NetworkPlayerInfo llllllllllllllIIlIlIIlIIlIIllIII, final ResourceLocation llllllllllllllIIlIlIIlIIlIIlIllI) {
        llllllllllllllIIlIlIIlIIlIIllIII.field_178862_f = llllllllllllllIIlIlIIlIIlIIlIllI;
    }
    
    public void func_178859_a(final IChatComponent llllllllllllllIIlIlIIlIlIIIIlIll) {
        this.field_178872_h = llllllllllllllIIlIlIIlIlIIIIlIll;
    }
    
    static final class SwitchType
    {
        static final /* synthetic */ int[] field_178875_a;
        
        static {
            __OBFID = "CL_00002618";
            field_178875_a = new int[MinecraftProfileTexture.Type.values().length];
            try {
                SwitchType.field_178875_a[MinecraftProfileTexture.Type.SKIN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchType.field_178875_a[MinecraftProfileTexture.Type.CAPE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
        }
    }
}
