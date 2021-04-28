package net.minecraft.client.stream;

import tv.twitch.chat.*;
import tv.twitch.broadcast.*;
import tv.twitch.*;

public interface IStream
{
    boolean func_152913_F();
    
    void func_176026_a(final Metadata p0, final long p1, final long p2);
    
    boolean func_152927_B();
    
    ChatUserInfo func_152926_a(final String p0);
    
    void func_152914_u();
    
    int func_152920_A();
    
    IngestServerTester func_152932_y();
    
    boolean func_152928_D();
    
    boolean isPaused();
    
    void func_152915_s();
    
    void func_152933_r();
    
    boolean func_152924_m();
    
    void func_152909_x();
    
    IngestServer[] func_152925_v();
    
    void func_152922_k();
    
    boolean func_152936_l();
    
    boolean func_152934_n();
    
    void func_152931_p();
    
    boolean func_152929_G();
    
    void func_152930_t();
    
    void func_152911_a(final Metadata p0, final long p1);
    
    void func_152910_a(final boolean p0);
    
    boolean func_152908_z();
    
    void func_152916_q();
    
    void func_152935_j();
    
    ErrorCode func_152912_E();
    
    AuthFailureReason func_152918_H();
    
    void func_152917_b(final String p0);
    
    void shutdownStream();
    
    String func_152921_C();
    
    public enum AuthFailureReason
    {
        ERROR("ERROR", 0, "ERROR", 0), 
        INVALID_TOKEN("INVALID_TOKEN", 1, "INVALID_TOKEN", 1);
        
        private AuthFailureReason(final String llllllllllllllIlllIIIlIIlIlIlIlI, final int llllllllllllllIlllIIIlIIlIlIlIIl, final String llllllllllllllIlllIIIlIIlIlIllIl, final int llllllllllllllIlllIIIlIIlIlIllII) {
        }
        
        static {
            __OBFID = "CL_00001813";
        }
    }
}
