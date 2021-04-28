package net.minecraft.client.main;

import java.io.*;
import java.net.*;
import com.mojang.authlib.properties.*;
import net.minecraft.util.*;

public class GameConfiguration
{
    public final /* synthetic */ UserInformation field_178745_a;
    public final /* synthetic */ FolderInformation field_178744_c;
    public final /* synthetic */ ServerInformation field_178742_e;
    public final /* synthetic */ GameInformation field_178741_d;
    public final /* synthetic */ DisplayInformation field_178743_b;
    
    static {
        __OBFID = "CL_00001918";
    }
    
    public GameConfiguration(final UserInformation lllllllllllllllIIlIIlllllllIIlII, final DisplayInformation lllllllllllllllIIlIIllllllIlllIl, final FolderInformation lllllllllllllllIIlIIllllllIlllII, final GameInformation lllllllllllllllIIlIIllllllIllIll, final ServerInformation lllllllllllllllIIlIIllllllIllIlI) {
        this.field_178745_a = lllllllllllllllIIlIIlllllllIIlII;
        this.field_178743_b = lllllllllllllllIIlIIllllllIlllIl;
        this.field_178744_c = lllllllllllllllIIlIIllllllIlllII;
        this.field_178741_d = lllllllllllllllIIlIIllllllIllIll;
        this.field_178742_e = lllllllllllllllIIlIIllllllIllIlI;
    }
    
    public static class FolderInformation
    {
        public final /* synthetic */ String field_178757_d;
        public final /* synthetic */ File field_178759_c;
        public final /* synthetic */ File field_178760_a;
        public final /* synthetic */ File field_178758_b;
        
        public FolderInformation(final File lllllllllllllllllIIIllIllIIIIIIl, final File lllllllllllllllllIIIllIllIIIIIII, final File lllllllllllllllllIIIllIlIllllIlI, final String lllllllllllllllllIIIllIlIllllIIl) {
            this.field_178760_a = lllllllllllllllllIIIllIllIIIIIIl;
            this.field_178758_b = lllllllllllllllllIIIllIllIIIIIII;
            this.field_178759_c = lllllllllllllllllIIIllIlIllllIlI;
            this.field_178757_d = lllllllllllllllllIIIllIlIllllIIl;
        }
        
        static {
            __OBFID = "CL_00001916";
        }
    }
    
    public static class ServerInformation
    {
        public final /* synthetic */ String field_178754_a;
        public final /* synthetic */ int field_178753_b;
        
        static {
            __OBFID = "CL_00001914";
        }
        
        public ServerInformation(final String lllllllllllllllIlllIlllIlIlIlllI, final int lllllllllllllllIlllIlllIlIlIlIlI) {
            this.field_178754_a = lllllllllllllllIlllIlllIlIlIlllI;
            this.field_178753_b = lllllllllllllllIlllIlllIlIlIlIlI;
        }
    }
    
    public static class DisplayInformation
    {
        public final /* synthetic */ int field_178762_b;
        public final /* synthetic */ boolean field_178761_d;
        public final /* synthetic */ boolean field_178763_c;
        public final /* synthetic */ int field_178764_a;
        
        public DisplayInformation(final int lllllllllllllllllIllIlIIllIlIlll, final int lllllllllllllllllIllIlIIllIlIllI, final boolean lllllllllllllllllIllIlIIllIllIlI, final boolean lllllllllllllllllIllIlIIllIllIIl) {
            this.field_178764_a = lllllllllllllllllIllIlIIllIlIlll;
            this.field_178762_b = lllllllllllllllllIllIlIIllIlIllI;
            this.field_178763_c = lllllllllllllllllIllIlIIllIllIlI;
            this.field_178761_d = lllllllllllllllllIllIlIIllIllIIl;
        }
        
        static {
            __OBFID = "CL_00001917";
        }
    }
    
    public static class UserInformation
    {
        public final /* synthetic */ Proxy field_178751_c;
        public final /* synthetic */ PropertyMap field_178750_b;
        public final /* synthetic */ Session field_178752_a;
        
        static {
            __OBFID = "CL_00001913";
        }
        
        public UserInformation(final Session llllllllllllllIlIIIlIlllIIlllIll, final PropertyMap llllllllllllllIlIIIlIlllIIlllIlI, final Proxy llllllllllllllIlIIIlIlllIIllllIl) {
            this.field_178752_a = llllllllllllllIlIIIlIlllIIlllIll;
            this.field_178750_b = llllllllllllllIlIIIlIlllIIlllIlI;
            this.field_178751_c = llllllllllllllIlIIIlIlllIIllllIl;
        }
    }
    
    public static class GameInformation
    {
        public final /* synthetic */ String field_178755_b;
        public final /* synthetic */ boolean field_178756_a;
        
        static {
            __OBFID = "CL_00001915";
        }
        
        public GameInformation(final boolean lllllllllllllllIlIlIlIlIIIIlIIII, final String lllllllllllllllIlIlIlIlIIIIIllII) {
            this.field_178756_a = lllllllllllllllIlIlIlIlIIIIlIIII;
            this.field_178755_b = lllllllllllllllIlIlIlIlIIIIIllII;
        }
    }
}
