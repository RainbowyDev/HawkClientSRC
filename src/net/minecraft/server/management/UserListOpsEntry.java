package net.minecraft.server.management;

import com.google.gson.*;
import com.mojang.authlib.*;

public class UserListOpsEntry extends UserListEntry
{
    private final /* synthetic */ int field_152645_a;
    
    static {
        __OBFID = "CL_00001878";
    }
    
    @Override
    protected void onSerialization(final JsonObject llllllllllllllIlIIllIlIlIlllllII) {
        if (this.getValue() != null) {
            llllllllllllllIlIIllIlIlIlllllII.addProperty("uuid", (((GameProfile)this.getValue()).getId() == null) ? "" : ((GameProfile)this.getValue()).getId().toString());
            llllllllllllllIlIIllIlIlIlllllII.addProperty("name", ((GameProfile)this.getValue()).getName());
            super.onSerialization(llllllllllllllIlIIllIlIlIlllllII);
            llllllllllllllIlIIllIlIlIlllllII.addProperty("level", (Number)this.field_152645_a);
        }
    }
    
    public UserListOpsEntry(final JsonObject llllllllllllllIlIIllIlIllIIIIIll) {
        super(func_152643_b(llllllllllllllIlIIllIlIllIIIIIll), llllllllllllllIlIIllIlIllIIIIIll);
        this.field_152645_a = (llllllllllllllIlIIllIlIllIIIIIll.has("level") ? llllllllllllllIlIIllIlIllIIIIIll.get("level").getAsInt() : 0);
    }
    
    public UserListOpsEntry(final GameProfile llllllllllllllIlIIllIlIllIIIlIlI, final int llllllllllllllIlIIllIlIllIIIlIIl) {
        super(llllllllllllllIlIIllIlIllIIIlIlI);
        this.field_152645_a = llllllllllllllIlIIllIlIllIIIlIIl;
    }
    
    public int func_152644_a() {
        return this.field_152645_a;
    }
    
    private static GameProfile func_152643_b(final JsonObject llllllllllllllIlIIllIlIlIlllIlIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "uuid"
        //     3: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //     6: ifeq            57
        //     9: aload_0         /* llllllllllllllIlIIllIlIlIlllIIII */
        //    10: ldc             "name"
        //    12: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //    15: ifeq            57
        //    18: aload_0         /* llllllllllllllIlIIllIlIlIlllIIII */
        //    19: ldc             "uuid"
        //    21: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    24: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    27: astore_1        /* llllllllllllllIlIIllIlIlIlllIlII */
        //    28: aload_1         /* llllllllllllllIlIIllIlIlIlllIlII */
        //    29: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
        //    32: astore_2        /* llllllllllllllIlIIllIlIlIlllIIll */
        //    33: goto            39
        //    36: astore_3        /* llllllllllllllIlIIllIlIlIlllIIIl */
        //    37: aconst_null    
        //    38: areturn        
        //    39: new             Lcom/mojang/authlib/GameProfile;
        //    42: dup            
        //    43: aload_2         /* llllllllllllllIlIIllIlIlIlllIIlI */
        //    44: aload_0         /* llllllllllllllIlIIllIlIlIlllIIII */
        //    45: ldc             "name"
        //    47: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    50: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    53: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
        //    56: areturn        
        //    57: aconst_null    
        //    58: areturn        
        //    StackMapTable: 00 03 FF 00 24 00 02 07 00 26 07 00 46 00 01 07 00 74 FC 00 02 07 00 20 F9 00 11
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
}
