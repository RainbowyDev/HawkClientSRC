package net.minecraft.server.management;

import com.mojang.authlib.*;
import com.google.gson.*;

public class UserListWhitelistEntry extends UserListEntry
{
    public UserListWhitelistEntry(final GameProfile llllllllllllllllIlIllllIlIIlIIlI) {
        super(llllllllllllllllIlIllllIlIIlIIlI);
    }
    
    public UserListWhitelistEntry(final JsonObject llllllllllllllllIlIllllIlIIIlIlI) {
        super(func_152646_b(llllllllllllllllIlIllllIlIIIlIlI), llllllllllllllllIlIllllIlIIIlIlI);
    }
    
    static {
        __OBFID = "CL_00001870";
    }
    
    @Override
    protected void onSerialization(final JsonObject llllllllllllllllIlIllllIlIIIIlII) {
        if (this.getValue() != null) {
            llllllllllllllllIlIllllIlIIIIlII.addProperty("uuid", (((GameProfile)this.getValue()).getId() == null) ? "" : ((GameProfile)this.getValue()).getId().toString());
            llllllllllllllllIlIllllIlIIIIlII.addProperty("name", ((GameProfile)this.getValue()).getName());
            super.onSerialization(llllllllllllllllIlIllllIlIIIIlII);
        }
    }
    
    private static GameProfile func_152646_b(final JsonObject llllllllllllllllIlIllllIIlllllll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "uuid"
        //     3: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //     6: ifeq            57
        //     9: aload_0         /* llllllllllllllllIlIllllIIllllIlI */
        //    10: ldc             "name"
        //    12: invokevirtual   com/google/gson/JsonObject.has:(Ljava/lang/String;)Z
        //    15: ifeq            57
        //    18: aload_0         /* llllllllllllllllIlIllllIIllllIlI */
        //    19: ldc             "uuid"
        //    21: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    24: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    27: astore_1        /* llllllllllllllllIlIllllIIllllllI */
        //    28: aload_1         /* llllllllllllllllIlIllllIIllllllI */
        //    29: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
        //    32: astore_2        /* llllllllllllllllIlIllllIIlllllIl */
        //    33: goto            39
        //    36: astore_3        /* llllllllllllllllIlIllllIIllllIll */
        //    37: aconst_null    
        //    38: areturn        
        //    39: new             Lcom/mojang/authlib/GameProfile;
        //    42: dup            
        //    43: aload_2         /* llllllllllllllllIlIllllIIlllllII */
        //    44: aload_0         /* llllllllllllllllIlIllllIIllllIlI */
        //    45: ldc             "name"
        //    47: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
        //    50: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
        //    53: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
        //    56: areturn        
        //    57: aconst_null    
        //    58: areturn        
        //    StackMapTable: 00 03 FF 00 24 00 02 07 00 3F 07 00 51 00 01 07 00 53 FC 00 02 07 00 39 F9 00 11
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  28     33     36     39     Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
