package net.minecraft.server.management;

import com.mojang.authlib.*;
import java.util.*;
import com.google.gson.*;

public class UserListBansEntry extends BanEntry
{
    public UserListBansEntry(final GameProfile llllllllllllllllIlIlllIIIIIlllII) {
        this(llllllllllllllllIlIlllIIIIIlllII, null, null, null, null);
    }
    
    private static GameProfile func_152648_b(final JsonObject llllllllllllllllIlIllIlllllllIll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "uuid"
        //     3: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //     6: ifeq            57
        //     9: aload_0         /* llllllllllllllllIlIllIllllllIllI */
        //    10: ldc             "name"
        //    12: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //    15: ifeq            57
        //    18: aload_0         /* llllllllllllllllIlIllIllllllIllI */
        //    19: ldc             "uuid"
        //    21: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    24: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    27: astore_1        /* llllllllllllllllIlIllIlllllllIlI */
        //    28: aload_1         /* llllllllllllllllIlIllIlllllllIlI */
        //    29: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
        //    32: astore_2        /* llllllllllllllllIlIllIllllllIlII */
        //    33: goto            39
        //    36: astore_3        /* llllllllllllllllIlIllIllllllIIll */
        //    37: aconst_null    
        //    38: areturn        
        //    39: new             Lcom/mojang/authlib/GameProfile;
        //    42: dup            
        //    43: aload_2         /* llllllllllllllllIlIllIlllllllIII */
        //    44: aload_0         /* llllllllllllllllIlIllIllllllIllI */
        //    45: ldc             "name"
        //    47: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    50: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    53: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
        //    56: areturn        
        //    57: aconst_null    
        //    58: areturn        
        //    StackMapTable: 00 03 FF 00 24 00 02 07 00 1A 07 00 46 00 01 07 00 16 FC 00 02 07 00 2C F9 00 11
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  28     33     36     39     Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public UserListBansEntry(final GameProfile llllllllllllllllIlIlllIIIIIIllll, final Date llllllllllllllllIlIlllIIIIIlIlII, final String llllllllllllllllIlIlllIIIIIlIIll, final Date llllllllllllllllIlIlllIIIIIlIIlI, final String llllllllllllllllIlIlllIIIIIIllII) {
        super(llllllllllllllllIlIlllIIIIIIllll, llllllllllllllllIlIlllIIIIIlIIlI, llllllllllllllllIlIlllIIIIIlIIll, llllllllllllllllIlIlllIIIIIlIIlI, llllllllllllllllIlIlllIIIIIIllII);
    }
    
    static {
        __OBFID = "CL_00001872";
    }
    
    public UserListBansEntry(final JsonObject llllllllllllllllIlIlllIIIIIIIllI) {
        super(func_152648_b(llllllllllllllllIlIlllIIIIIIIllI), llllllllllllllllIlIlllIIIIIIIllI);
    }
    
    @Override
    protected void onSerialization(final JsonObject llllllllllllllllIlIlllIIIIIIIIII) {
        if (this.getValue() != null) {
            llllllllllllllllIlIlllIIIIIIIIII.addProperty("uuid", (((GameProfile)this.getValue()).getId() == null) ? "" : ((GameProfile)this.getValue()).getId().toString());
            llllllllllllllllIlIlllIIIIIIIIII.addProperty("name", ((GameProfile)this.getValue()).getName());
            super.onSerialization(llllllllllllllllIlIlllIIIIIIIIII);
        }
    }
}
