package net.minecraft.client.stream;

import tv.twitch.chat.*;
import tv.twitch.broadcast.*;
import tv.twitch.*;

public class NullStream implements IStream
{
    private final /* synthetic */ Throwable field_152938_a;
    
    @Override
    public AuthFailureReason func_152918_H() {
        return AuthFailureReason.ERROR;
    }
    
    @Override
    public void func_152935_j() {
    }
    
    @Override
    public boolean func_152934_n() {
        return false;
    }
    
    public NullStream(final Throwable lllllllllllllllIIIIlIIIlIlIllllI) {
        this.field_152938_a = lllllllllllllllIIIIlIIIlIlIllllI;
    }
    
    static {
        __OBFID = "CL_00001809";
    }
    
    @Override
    public void func_152933_r() {
    }
    
    @Override
    public void func_152931_p() {
    }
    
    @Override
    public void func_152917_b(final String lllllllllllllllIIIIlIIIlIIllllIl) {
    }
    
    @Override
    public void func_152914_u() {
    }
    
    @Override
    public int func_152920_A() {
        return 0;
    }
    
    @Override
    public void func_152911_a(final Metadata lllllllllllllllIIIIlIIIlIlIlIlII, final long lllllllllllllllIIIIlIIIlIlIlIIll) {
    }
    
    @Override
    public String func_152921_C() {
        return null;
    }
    
    @Override
    public boolean func_152927_B() {
        return false;
    }
    
    @Override
    public IngestServerTester func_152932_y() {
        return null;
    }
    
    @Override
    public boolean func_152908_z() {
        return false;
    }
    
    @Override
    public boolean isPaused() {
        return false;
    }
    
    @Override
    public void func_152915_s() {
    }
    
    @Override
    public void func_152930_t() {
    }
    
    @Override
    public ChatUserInfo func_152926_a(final String lllllllllllllllIIIIlIIIlIIllllll) {
        return null;
    }
    
    @Override
    public boolean func_152929_G() {
        return false;
    }
    
    @Override
    public boolean func_152936_l() {
        return false;
    }
    
    @Override
    public void func_176026_a(final Metadata lllllllllllllllIIIIlIIIlIlIlIIIl, final long lllllllllllllllIIIIlIIIlIlIlIIII, final long lllllllllllllllIIIIlIIIlIlIIllll) {
    }
    
    @Override
    public boolean func_152913_F() {
        return false;
    }
    
    public Throwable func_152937_a() {
        return this.field_152938_a;
    }
    
    @Override
    public void func_152916_q() {
    }
    
    @Override
    public void shutdownStream() {
    }
    
    @Override
    public boolean func_152928_D() {
        return false;
    }
    
    @Override
    public void func_152910_a(final boolean lllllllllllllllIIIIlIIIlIIlllIII) {
    }
    
    @Override
    public IngestServer[] func_152925_v() {
        return new IngestServer[0];
    }
    
    @Override
    public void func_152909_x() {
    }
    
    @Override
    public ErrorCode func_152912_E() {
        return null;
    }
    
    @Override
    public boolean func_152924_m() {
        return false;
    }
    
    @Override
    public void func_152922_k() {
    }
}
