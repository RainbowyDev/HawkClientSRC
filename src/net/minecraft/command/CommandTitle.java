package net.minecraft.command;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;
import net.minecraft.network.play.server.*;
import org.apache.logging.log4j.*;

public class CommandTitle extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIIllIllIlIIlIllIl, final String[] lllllllllllllllIIllIllIlIIllllII) throws CommandException {
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
        //    10: ldc             "commands.title.usage"
        //    12: iconst_0       
        //    13: anewarray       Ljava/lang/Object;
        //    16: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    19: athrow         
        //    20: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //    21: arraylength    
        //    22: iconst_3       
        //    23: if_icmpge       87
        //    26: ldc             "title"
        //    28: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //    29: iconst_1       
        //    30: aaload         
        //    31: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    34: ifne            48
        //    37: ldc             "subtitle"
        //    39: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //    40: iconst_1       
        //    41: aaload         
        //    42: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    45: ifeq            62
        //    48: new             Lnet/minecraft/command/WrongUsageException;
        //    51: dup            
        //    52: ldc             "commands.title.usage.title"
        //    54: iconst_0       
        //    55: anewarray       Ljava/lang/Object;
        //    58: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    61: athrow         
        //    62: ldc             "times"
        //    64: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //    65: iconst_1       
        //    66: aaload         
        //    67: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    70: ifeq            87
        //    73: new             Lnet/minecraft/command/WrongUsageException;
        //    76: dup            
        //    77: ldc             "commands.title.usage.times"
        //    79: iconst_0       
        //    80: anewarray       Ljava/lang/Object;
        //    83: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    86: athrow         
        //    87: aload_1         /* lllllllllllllllIIllIllIlIIllllIl */
        //    88: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //    89: iconst_0       
        //    90: aaload         
        //    91: invokestatic    net/minecraft/command/CommandTitle.getPlayer:(Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)Lnet/minecraft/entity/player/EntityPlayerMP;
        //    94: astore_3        /* lllllllllllllllIIllIllIlIIlIlIll */
        //    95: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //    96: iconst_1       
        //    97: aaload         
        //    98: invokestatic    net/minecraft/network/play/server/S45PacketTitle$Type.func_179969_a:(Ljava/lang/String;)Lnet/minecraft/network/play/server/S45PacketTitle$Type;
        //   101: astore          lllllllllllllllIIllIllIlIIlllIlI
        //   103: aload           lllllllllllllllIIllIllIlIIlllIlI
        //   105: getstatic       net/minecraft/network/play/server/S45PacketTitle$Type.CLEAR:Lnet/minecraft/network/play/server/S45PacketTitle$Type;
        //   108: if_acmpeq       328
        //   111: aload           lllllllllllllllIIllIllIlIIlllIlI
        //   113: getstatic       net/minecraft/network/play/server/S45PacketTitle$Type.RESET:Lnet/minecraft/network/play/server/S45PacketTitle$Type;
        //   116: if_acmpeq       328
        //   119: aload           lllllllllllllllIIllIllIlIIlllIlI
        //   121: getstatic       net/minecraft/network/play/server/S45PacketTitle$Type.TIMES:Lnet/minecraft/network/play/server/S45PacketTitle$Type;
        //   124: if_acmpne       209
        //   127: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //   128: arraylength    
        //   129: iconst_5       
        //   130: if_icmpeq       147
        //   133: new             Lnet/minecraft/command/WrongUsageException;
        //   136: dup            
        //   137: ldc             "commands.title.usage"
        //   139: iconst_0       
        //   140: anewarray       Ljava/lang/Object;
        //   143: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   146: athrow         
        //   147: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //   148: iconst_2       
        //   149: aaload         
        //   150: invokestatic    net/minecraft/command/CommandTitle.parseInt:(Ljava/lang/String;)I
        //   153: istore          lllllllllllllllIIllIllIlIIlllIIl
        //   155: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //   156: iconst_3       
        //   157: aaload         
        //   158: invokestatic    net/minecraft/command/CommandTitle.parseInt:(Ljava/lang/String;)I
        //   161: istore          lllllllllllllllIIllIllIlIIlllIII
        //   163: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //   164: iconst_4       
        //   165: aaload         
        //   166: invokestatic    net/minecraft/command/CommandTitle.parseInt:(Ljava/lang/String;)I
        //   169: istore          lllllllllllllllIIllIllIlIIllIlll
        //   171: new             Lnet/minecraft/network/play/server/S45PacketTitle;
        //   174: dup            
        //   175: iload           lllllllllllllllIIllIllIlIIlllIIl
        //   177: iload           lllllllllllllllIIllIllIlIIlllIII
        //   179: iload           lllllllllllllllIIllIllIlIIllIlll
        //   181: invokespecial   net/minecraft/network/play/server/S45PacketTitle.<init>:(III)V
        //   184: astore          lllllllllllllllIIllIllIlIIllIllI
        //   186: aload_3         /* lllllllllllllllIIllIllIlIIlllIll */
        //   187: getfield        net/minecraft/entity/player/EntityPlayerMP.playerNetServerHandler:Lnet/minecraft/network/NetHandlerPlayServer;
        //   190: aload           lllllllllllllllIIllIllIlIIllIllI
        //   192: invokevirtual   net/minecraft/network/NetHandlerPlayServer.sendPacket:(Lnet/minecraft/network/Packet;)V
        //   195: aload_1         /* lllllllllllllllIIllIllIlIIllllIl */
        //   196: aload_0         /* lllllllllllllllIIllIllIlIIlIlllI */
        //   197: ldc             "commands.title.success"
        //   199: iconst_0       
        //   200: anewarray       Ljava/lang/Object;
        //   203: invokestatic    net/minecraft/command/CommandTitle.notifyOperators:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   206: goto            380
        //   209: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //   210: arraylength    
        //   211: iconst_3       
        //   212: if_icmpge       229
        //   215: new             Lnet/minecraft/command/WrongUsageException;
        //   218: dup            
        //   219: ldc             "commands.title.usage"
        //   221: iconst_0       
        //   222: anewarray       Ljava/lang/Object;
        //   225: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   228: athrow         
        //   229: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //   230: iconst_2       
        //   231: invokestatic    net/minecraft/command/CommandTitle.func_180529_a:([Ljava/lang/String;I)Ljava/lang/String;
        //   234: astore          lllllllllllllllIIllIllIlIIllIlIl
        //   236: aload           lllllllllllllllIIllIllIlIIllIlIl
        //   238: invokestatic    net/minecraft/util/IChatComponent$Serializer.jsonToComponent:(Ljava/lang/String;)Lnet/minecraft/util/IChatComponent;
        //   241: astore          lllllllllllllllIIllIllIlIIllIlII
        //   243: goto            287
        //   246: astore          lllllllllllllllIIllIllIlIIllIIlI
        //   248: aload           lllllllllllllllIIllIllIlIIllIIlI
        //   250: invokestatic    org/apache/commons/lang3/exception/ExceptionUtils.getRootCause:(Ljava/lang/Throwable;)Ljava/lang/Throwable;
        //   253: astore          lllllllllllllllIIllIllIlIIllIIIl
        //   255: new             Lnet/minecraft/command/SyntaxErrorException;
        //   258: dup            
        //   259: ldc             "commands.tellraw.jsonException"
        //   261: iconst_1       
        //   262: anewarray       Ljava/lang/Object;
        //   265: dup            
        //   266: iconst_0       
        //   267: aload           lllllllllllllllIIllIllIlIIllIIIl
        //   269: ifnonnull       277
        //   272: ldc             ""
        //   274: goto            282
        //   277: aload           lllllllllllllllIIllIllIlIIllIIIl
        //   279: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   282: aastore        
        //   283: invokespecial   net/minecraft/command/SyntaxErrorException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   286: athrow         
        //   287: new             Lnet/minecraft/network/play/server/S45PacketTitle;
        //   290: dup            
        //   291: aload           lllllllllllllllIIllIllIlIIlllIlI
        //   293: aload_1         /* lllllllllllllllIIllIllIlIIllllIl */
        //   294: aload           lllllllllllllllIIllIllIlIIllIIll
        //   296: aload_3         /* lllllllllllllllIIllIllIlIIlllIll */
        //   297: invokestatic    net/minecraft/util/ChatComponentProcessor.func_179985_a:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/util/IChatComponent;Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/IChatComponent;
        //   300: invokespecial   net/minecraft/network/play/server/S45PacketTitle.<init>:(Lnet/minecraft/network/play/server/S45PacketTitle$Type;Lnet/minecraft/util/IChatComponent;)V
        //   303: astore          lllllllllllllllIIllIllIlIIllIIII
        //   305: aload_3         /* lllllllllllllllIIllIllIlIIlllIll */
        //   306: getfield        net/minecraft/entity/player/EntityPlayerMP.playerNetServerHandler:Lnet/minecraft/network/NetHandlerPlayServer;
        //   309: aload           lllllllllllllllIIllIllIlIIllIIII
        //   311: invokevirtual   net/minecraft/network/NetHandlerPlayServer.sendPacket:(Lnet/minecraft/network/Packet;)V
        //   314: aload_1         /* lllllllllllllllIIllIllIlIIllllIl */
        //   315: aload_0         /* lllllllllllllllIIllIllIlIIlIlllI */
        //   316: ldc             "commands.title.success"
        //   318: iconst_0       
        //   319: anewarray       Ljava/lang/Object;
        //   322: invokestatic    net/minecraft/command/CommandTitle.notifyOperators:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   325: goto            380
        //   328: aload_2         /* lllllllllllllllIIllIllIlIIlIllII */
        //   329: arraylength    
        //   330: iconst_2       
        //   331: if_icmpeq       348
        //   334: new             Lnet/minecraft/command/WrongUsageException;
        //   337: dup            
        //   338: ldc             "commands.title.usage"
        //   340: iconst_0       
        //   341: anewarray       Ljava/lang/Object;
        //   344: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   347: athrow         
        //   348: new             Lnet/minecraft/network/play/server/S45PacketTitle;
        //   351: dup            
        //   352: aload           lllllllllllllllIIllIllIlIIlllIlI
        //   354: aconst_null    
        //   355: invokespecial   net/minecraft/network/play/server/S45PacketTitle.<init>:(Lnet/minecraft/network/play/server/S45PacketTitle$Type;Lnet/minecraft/util/IChatComponent;)V
        //   358: astore          lllllllllllllllIIllIllIlIIlIllll
        //   360: aload_3         /* lllllllllllllllIIllIllIlIIlllIll */
        //   361: getfield        net/minecraft/entity/player/EntityPlayerMP.playerNetServerHandler:Lnet/minecraft/network/NetHandlerPlayServer;
        //   364: aload           lllllllllllllllIIllIllIlIIlIllll
        //   366: invokevirtual   net/minecraft/network/NetHandlerPlayServer.sendPacket:(Lnet/minecraft/network/Packet;)V
        //   369: aload_1         /* lllllllllllllllIIllIllIlIIllllIl */
        //   370: aload_0         /* lllllllllllllllIIllIllIlIIlIlllI */
        //   371: ldc             "commands.title.success"
        //   373: iconst_0       
        //   374: anewarray       Ljava/lang/Object;
        //   377: invokestatic    net/minecraft/command/CommandTitle.notifyOperators:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   380: return         
        //    Exceptions:
        //  throws net.minecraft.command.CommandException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  236    243    246    287    Lcom/google/gson/JsonParseException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIIllIllIlIllIIlll) {
        return "commands.title.usage";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIIllIllIlIIIlIIll, final String[] lllllllllllllllIIllIllIlIIIIllIl, final BlockPos lllllllllllllllIIllIllIlIIIIllll) {
        return (lllllllllllllllIIllIllIlIIIIllIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIllIllIlIIIIllIl, MinecraftServer.getServer().getAllUsernames()) : ((lllllllllllllllIIllIllIlIIIIllIl.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIllIllIlIIIIllIl, S45PacketTitle.Type.func_179971_a()) : null);
    }
    
    static {
        __OBFID = "CL_00002338";
        field_175774_a = LogManager.getLogger();
    }
    
    @Override
    public String getCommandName() {
        return "title";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllIIllIllIlIIIIIlIl, final int lllllllllllllllIIllIllIlIIIIIIll) {
        return lllllllllllllllIIllIllIlIIIIIIll == 0;
    }
}
