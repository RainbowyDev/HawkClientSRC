package net.minecraft.command;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;

public class CommandEntityData extends CommandBase
{
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIlIIIlIlIIllIIllll, final String[] llllllllllllllIlIIIlIlIIllIIlllI, final BlockPos llllllllllllllIlIIIlIlIIllIIllIl) {
        return (llllllllllllllIlIIIlIlIIllIIlllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIIIlIlIIllIIlllI, MinecraftServer.getServer().getAllUsernames()) : null;
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIIIlIlIIllIllIII, final String[] llllllllllllllIlIIIlIlIIllIlIlll) throws CommandException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: iconst_2       
        //     3: if_icmpge       20
        //     6: new             Lnet/minecraft/command/WrongUsageException;
        //     9: dup            
        //    10: ldc             "commands.entitydata.usage"
        //    12: iconst_0       
        //    13: anewarray       Ljava/lang/Object;
        //    16: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    19: athrow         
        //    20: aload_1         /* llllllllllllllIlIIIlIlIIlllIIIIl */
        //    21: aload_2         /* llllllllllllllIlIIIlIlIIlllIIIII */
        //    22: iconst_0       
        //    23: aaload         
        //    24: invokestatic    net/minecraft/command/CommandEntityData.func_175768_b:(Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)Lnet/minecraft/entity/Entity;
        //    27: astore_3        /* llllllllllllllIlIIIlIlIIllIlIllI */
        //    28: aload_3         /* llllllllllllllIlIIIlIlIIllIlllll */
        //    29: instanceof      Lnet/minecraft/entity/player/EntityPlayer;
        //    32: ifeq            56
        //    35: new             Lnet/minecraft/command/CommandException;
        //    38: dup            
        //    39: ldc             "commands.entitydata.noPlayers"
        //    41: iconst_1       
        //    42: anewarray       Ljava/lang/Object;
        //    45: dup            
        //    46: iconst_0       
        //    47: aload_3         /* llllllllllllllIlIIIlIlIIllIlllll */
        //    48: invokevirtual   net/minecraft/entity/Entity.getDisplayName:()Lnet/minecraft/util/IChatComponent;
        //    51: aastore        
        //    52: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    55: athrow         
        //    56: new             Lnet/minecraft/nbt/NBTTagCompound;
        //    59: dup            
        //    60: invokespecial   net/minecraft/nbt/NBTTagCompound.<init>:()V
        //    63: astore          llllllllllllllIlIIIlIlIIllIllllI
        //    65: aload_3         /* llllllllllllllIlIIIlIlIIllIlllll */
        //    66: aload           llllllllllllllIlIIIlIlIIllIllllI
        //    68: invokevirtual   net/minecraft/entity/Entity.writeToNBT:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //    71: aload           llllllllllllllIlIIIlIlIIllIllllI
        //    73: invokevirtual   net/minecraft/nbt/NBTTagCompound.copy:()Lnet/minecraft/nbt/NBTBase;
        //    76: checkcast       Lnet/minecraft/nbt/NBTTagCompound;
        //    79: astore          llllllllllllllIlIIIlIlIIllIlllIl
        //    81: aload_1         /* llllllllllllllIlIIIlIlIIlllIIIIl */
        //    82: aload_2         /* llllllllllllllIlIIIlIlIIlllIIIII */
        //    83: iconst_1       
        //    84: invokestatic    net/minecraft/command/CommandEntityData.getChatComponentFromNthArg:(Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;I)Lnet/minecraft/util/IChatComponent;
        //    87: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText:()Ljava/lang/String;
        //    92: invokestatic    net/minecraft/nbt/JsonToNBT.func_180713_a:(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;
        //    95: astore          llllllllllllllIlIIIlIlIIllIlllII
        //    97: goto            124
        //   100: astore          llllllllllllllIlIIIlIlIIllIllIlI
        //   102: new             Lnet/minecraft/command/CommandException;
        //   105: dup            
        //   106: ldc             "commands.entitydata.tagError"
        //   108: iconst_1       
        //   109: anewarray       Ljava/lang/Object;
        //   112: dup            
        //   113: iconst_0       
        //   114: aload           llllllllllllllIlIIIlIlIIllIllIlI
        //   116: invokevirtual   net/minecraft/nbt/NBTException.getMessage:()Ljava/lang/String;
        //   119: aastore        
        //   120: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   123: athrow         
        //   124: aload           llllllllllllllIlIIIlIlIIllIllIll
        //   126: ldc             "UUIDMost"
        //   128: invokevirtual   net/minecraft/nbt/NBTTagCompound.removeTag:(Ljava/lang/String;)V
        //   131: aload           llllllllllllllIlIIIlIlIIllIllIll
        //   133: ldc             "UUIDLeast"
        //   135: invokevirtual   net/minecraft/nbt/NBTTagCompound.removeTag:(Ljava/lang/String;)V
        //   138: aload           llllllllllllllIlIIIlIlIIllIllllI
        //   140: aload           llllllllllllllIlIIIlIlIIllIllIll
        //   142: invokevirtual   net/minecraft/nbt/NBTTagCompound.merge:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   145: aload           llllllllllllllIlIIIlIlIIllIllllI
        //   147: aload           llllllllllllllIlIIIlIlIIllIlllIl
        //   149: invokevirtual   net/minecraft/nbt/NBTTagCompound.equals:(Ljava/lang/Object;)Z
        //   152: ifeq            177
        //   155: new             Lnet/minecraft/command/CommandException;
        //   158: dup            
        //   159: ldc             "commands.entitydata.failed"
        //   161: iconst_1       
        //   162: anewarray       Ljava/lang/Object;
        //   165: dup            
        //   166: iconst_0       
        //   167: aload           llllllllllllllIlIIIlIlIIllIllllI
        //   169: invokevirtual   net/minecraft/nbt/NBTTagCompound.toString:()Ljava/lang/String;
        //   172: aastore        
        //   173: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   176: athrow         
        //   177: aload_3         /* llllllllllllllIlIIIlIlIIllIlllll */
        //   178: aload           llllllllllllllIlIIIlIlIIllIllllI
        //   180: invokevirtual   net/minecraft/entity/Entity.readFromNBT:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   183: aload_1         /* llllllllllllllIlIIIlIlIIlllIIIIl */
        //   184: aload_0         /* llllllllllllllIlIIIlIlIIllIllIIl */
        //   185: ldc             "commands.entitydata.success"
        //   187: iconst_1       
        //   188: anewarray       Ljava/lang/Object;
        //   191: dup            
        //   192: iconst_0       
        //   193: aload           llllllllllllllIlIIIlIlIIllIllllI
        //   195: invokevirtual   net/minecraft/nbt/NBTTagCompound.toString:()Ljava/lang/String;
        //   198: aastore        
        //   199: invokestatic    net/minecraft/command/CommandEntityData.notifyOperators:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   202: return         
        //    Exceptions:
        //  throws net.minecraft.command.CommandException
        //    StackMapTable: 00 05 14 FC 00 23 07 00 3C FF 00 2B 00 06 07 00 02 07 00 9C 07 00 9D 07 00 3C 07 00 43 07 00 43 00 01 07 00 28 FC 00 17 07 00 43 34
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  81     97     100    124    Lnet/minecraft/nbt/NBTException;
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
    
    @Override
    public String getCommandName() {
        return "entitydata";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIlIIIlIlIIllIIlIIl, final int llllllllllllllIlIIIlIlIIllIIIlll) {
        return llllllllllllllIlIIIlIlIIllIIIlll == 0;
    }
    
    static {
        __OBFID = "CL_00002345";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIIIlIlIIlllIlIll) {
        return "commands.entitydata.usage";
    }
}
