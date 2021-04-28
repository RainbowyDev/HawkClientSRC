package net.minecraft.command.server;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.command.*;

public class CommandSummon extends CommandBase
{
    @Override
    public String getCommandName() {
        return "summon";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIIIIlIlllIIllIIlIl, final String[] llllllllllllllIIIIlIlllIIllIIlII, final BlockPos llllllllllllllIIIIlIlllIIllIIIIl) {
        return (llllllllllllllIIIIlIlllIIllIIlII.length == 1) ? CommandBase.func_175762_a(llllllllllllllIIIIlIlllIIllIIlII, EntityList.func_180124_b()) : ((llllllllllllllIIIIlIlllIIllIIlII.length > 1 && llllllllllllllIIIIlIlllIIllIIlII.length <= 4) ? CommandBase.func_175771_a(llllllllllllllIIIIlIlllIIllIIlII, 1, llllllllllllllIIIIlIlllIIllIIIIl) : null);
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIIIIlIlllIlIIIlIll, final String[] llllllllllllllIIIIlIlllIIlllIllI) throws CommandException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: iconst_1       
        //     3: if_icmpge       20
        //     6: new             Lnet/minecraft/command/WrongUsageException;
        //     9: dup            
        //    10: ldc             "commands.summon.usage"
        //    12: iconst_0       
        //    13: anewarray       Ljava/lang/Object;
        //    16: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    19: athrow         
        //    20: aload_2         /* llllllllllllllIIIIlIlllIlIIIlIlI */
        //    21: iconst_0       
        //    22: aaload         
        //    23: astore_3        /* llllllllllllllIIIIlIlllIlIIIlIIl */
        //    24: aload_1         /* llllllllllllllIIIIlIlllIIlllIlll */
        //    25: invokeinterface net/minecraft/command/ICommandSender.getPosition:()Lnet/minecraft/util/BlockPos;
        //    30: astore          llllllllllllllIIIIlIlllIlIIIlIII
        //    32: aload_1         /* llllllllllllllIIIIlIlllIIlllIlll */
        //    33: invokeinterface net/minecraft/command/ICommandSender.getPositionVector:()Lnet/minecraft/util/Vec3;
        //    38: astore          llllllllllllllIIIIlIlllIlIIIIlll
        //    40: aload           llllllllllllllIIIIlIlllIlIIIIlll
        //    42: getfield        net/minecraft/util/Vec3.xCoord:D
        //    45: dstore          llllllllllllllIIIIlIlllIlIIIIllI
        //    47: aload           llllllllllllllIIIIlIlllIlIIIIlll
        //    49: getfield        net/minecraft/util/Vec3.yCoord:D
        //    52: dstore          llllllllllllllIIIIlIlllIlIIIIlIl
        //    54: aload           llllllllllllllIIIIlIlllIlIIIIlll
        //    56: getfield        net/minecraft/util/Vec3.zCoord:D
        //    59: dstore          llllllllllllllIIIIlIlllIlIIIIlII
        //    61: aload_2         /* llllllllllllllIIIIlIlllIlIIIlIlI */
        //    62: arraylength    
        //    63: iconst_4       
        //    64: if_icmplt       115
        //    67: dload           llllllllllllllIIIIlIlllIlIIIIllI
        //    69: aload_2         /* llllllllllllllIIIIlIlllIlIIIlIlI */
        //    70: iconst_1       
        //    71: aaload         
        //    72: iconst_1       
        //    73: invokestatic    net/minecraft/command/server/CommandSummon.func_175761_b:(DLjava/lang/String;Z)D
        //    76: dstore          llllllllllllllIIIIlIlllIlIIIIllI
        //    78: dload           llllllllllllllIIIIlIlllIlIIIIlIl
        //    80: aload_2         /* llllllllllllllIIIIlIlllIlIIIlIlI */
        //    81: iconst_2       
        //    82: aaload         
        //    83: iconst_0       
        //    84: invokestatic    net/minecraft/command/server/CommandSummon.func_175761_b:(DLjava/lang/String;Z)D
        //    87: dstore          llllllllllllllIIIIlIlllIlIIIIlIl
        //    89: dload           llllllllllllllIIIIlIlllIlIIIIlII
        //    91: aload_2         /* llllllllllllllIIIIlIlllIlIIIlIlI */
        //    92: iconst_3       
        //    93: aaload         
        //    94: iconst_1       
        //    95: invokestatic    net/minecraft/command/server/CommandSummon.func_175761_b:(DLjava/lang/String;Z)D
        //    98: dstore          llllllllllllllIIIIlIlllIlIIIIlII
        //   100: new             Lnet/minecraft/util/BlockPos;
        //   103: dup            
        //   104: dload           llllllllllllllIIIIlIlllIlIIIIllI
        //   106: dload           llllllllllllllIIIIlIlllIlIIIIlIl
        //   108: dload           llllllllllllllIIIIlIlllIlIIIIlII
        //   110: invokespecial   net/minecraft/util/BlockPos.<init>:(DDD)V
        //   113: astore          llllllllllllllIIIIlIlllIlIIIlIII
        //   115: aload_1         /* llllllllllllllIIIIlIlllIIlllIlll */
        //   116: invokeinterface net/minecraft/command/ICommandSender.getEntityWorld:()Lnet/minecraft/world/World;
        //   121: astore          llllllllllllllIIIIlIlllIlIIIIIll
        //   123: aload           llllllllllllllIIIIlIlllIlIIIIIll
        //   125: aload           llllllllllllllIIIIlIlllIlIIIlIII
        //   127: invokevirtual   net/minecraft/world/World.isBlockLoaded:(Lnet/minecraft/util/BlockPos;)Z
        //   130: ifne            147
        //   133: new             Lnet/minecraft/command/CommandException;
        //   136: dup            
        //   137: ldc             "commands.summon.outOfWorld"
        //   139: iconst_0       
        //   140: anewarray       Ljava/lang/Object;
        //   143: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   146: athrow         
        //   147: ldc             "LightningBolt"
        //   149: aload_3         /* llllllllllllllIIIIlIlllIlIIIlIIl */
        //   150: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   153: ifeq            191
        //   156: aload           llllllllllllllIIIIlIlllIlIIIIIll
        //   158: new             Lnet/minecraft/entity/effect/EntityLightningBolt;
        //   161: dup            
        //   162: aload           llllllllllllllIIIIlIlllIlIIIIIll
        //   164: dload           llllllllllllllIIIIlIlllIlIIIIllI
        //   166: dload           llllllllllllllIIIIlIlllIlIIIIlIl
        //   168: dload           llllllllllllllIIIIlIlllIlIIIIlII
        //   170: invokespecial   net/minecraft/entity/effect/EntityLightningBolt.<init>:(Lnet/minecraft/world/World;DDD)V
        //   173: invokevirtual   net/minecraft/world/World.addWeatherEffect:(Lnet/minecraft/entity/Entity;)Z
        //   176: pop            
        //   177: aload_1         /* llllllllllllllIIIIlIlllIIlllIlll */
        //   178: aload_0         /* llllllllllllllIIIIlIlllIlIIIllII */
        //   179: ldc             "commands.summon.success"
        //   181: iconst_0       
        //   182: anewarray       Ljava/lang/Object;
        //   185: invokestatic    net/minecraft/command/server/CommandSummon.notifyOperators:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   188: goto            487
        //   191: new             Lnet/minecraft/nbt/NBTTagCompound;
        //   194: dup            
        //   195: invokespecial   net/minecraft/nbt/NBTTagCompound.<init>:()V
        //   198: astore          llllllllllllllIIIIlIlllIlIIIIIlI
        //   200: iconst_0       
        //   201: istore          llllllllllllllIIIIlIlllIlIIIIIIl
        //   203: aload_2         /* llllllllllllllIIIIlIlllIlIIIlIlI */
        //   204: arraylength    
        //   205: iconst_5       
        //   206: if_icmplt       259
        //   209: aload_1         /* llllllllllllllIIIIlIlllIIlllIlll */
        //   210: aload_2         /* llllllllllllllIIIIlIlllIlIIIlIlI */
        //   211: iconst_4       
        //   212: invokestatic    net/minecraft/command/server/CommandSummon.getChatComponentFromNthArg:(Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;I)Lnet/minecraft/util/IChatComponent;
        //   215: astore          llllllllllllllIIIIlIlllIlIIIIIII
        //   217: aload           llllllllllllllIIIIlIlllIlIIIIIII
        //   219: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText:()Ljava/lang/String;
        //   224: invokestatic    net/minecraft/nbt/JsonToNBT.func_180713_a:(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;
        //   227: astore          llllllllllllllIIIIlIlllIlIIIIIlI
        //   229: iconst_1       
        //   230: istore          llllllllllllllIIIIlIlllIlIIIIIIl
        //   232: goto            259
        //   235: astore          llllllllllllllIIIIlIlllIIlllllll
        //   237: new             Lnet/minecraft/command/CommandException;
        //   240: dup            
        //   241: ldc             "commands.summon.tagError"
        //   243: iconst_1       
        //   244: anewarray       Ljava/lang/Object;
        //   247: dup            
        //   248: iconst_0       
        //   249: aload           llllllllllllllIIIIlIlllIIlllllll
        //   251: invokevirtual   net/minecraft/nbt/NBTException.getMessage:()Ljava/lang/String;
        //   254: aastore        
        //   255: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   258: athrow         
        //   259: aload           llllllllllllllIIIIlIlllIlIIIIIlI
        //   261: ldc             "id"
        //   263: aload_3         /* llllllllllllllIIIIlIlllIlIIIlIIl */
        //   264: invokevirtual   net/minecraft/nbt/NBTTagCompound.setString:(Ljava/lang/String;Ljava/lang/String;)V
        //   267: aload           llllllllllllllIIIIlIlllIlIIIIIlI
        //   269: aload           llllllllllllllIIIIlIlllIlIIIIIll
        //   271: invokestatic    net/minecraft/entity/EntityList.createEntityFromNBT:(Lnet/minecraft/nbt/NBTTagCompound;Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
        //   274: astore          llllllllllllllIIIIlIlllIIllllllI
        //   276: goto            295
        //   279: astore          llllllllllllllIIIIlIlllIIlllllII
        //   281: new             Lnet/minecraft/command/CommandException;
        //   284: dup            
        //   285: ldc             "commands.summon.failed"
        //   287: iconst_0       
        //   288: anewarray       Ljava/lang/Object;
        //   291: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   294: athrow         
        //   295: aload           llllllllllllllIIIIlIlllIIlllllIl
        //   297: ifnonnull       314
        //   300: new             Lnet/minecraft/command/CommandException;
        //   303: dup            
        //   304: ldc             "commands.summon.failed"
        //   306: iconst_0       
        //   307: anewarray       Ljava/lang/Object;
        //   310: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   313: athrow         
        //   314: aload           llllllllllllllIIIIlIlllIIlllllIl
        //   316: dload           llllllllllllllIIIIlIlllIlIIIIllI
        //   318: dload           llllllllllllllIIIIlIlllIlIIIIlIl
        //   320: dload           llllllllllllllIIIIlIlllIlIIIIlII
        //   322: aload           llllllllllllllIIIIlIlllIIlllllIl
        //   324: getfield        net/minecraft/entity/Entity.rotationYaw:F
        //   327: aload           llllllllllllllIIIIlIlllIIlllllIl
        //   329: getfield        net/minecraft/entity/Entity.rotationPitch:F
        //   332: invokevirtual   net/minecraft/entity/Entity.setLocationAndAngles:(DDDFF)V
        //   335: iload           llllllllllllllIIIIlIlllIlIIIIIIl
        //   337: ifne            372
        //   340: aload           llllllllllllllIIIIlIlllIIlllllIl
        //   342: instanceof      Lnet/minecraft/entity/EntityLiving;
        //   345: ifeq            372
        //   348: aload           llllllllllllllIIIIlIlllIIlllllIl
        //   350: checkcast       Lnet/minecraft/entity/EntityLiving;
        //   353: aload           llllllllllllllIIIIlIlllIlIIIIIll
        //   355: new             Lnet/minecraft/util/BlockPos;
        //   358: dup            
        //   359: aload           llllllllllllllIIIIlIlllIIlllllIl
        //   361: invokespecial   net/minecraft/util/BlockPos.<init>:(Lnet/minecraft/entity/Entity;)V
        //   364: invokevirtual   net/minecraft/world/World.getDifficultyForLocation:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/world/DifficultyInstance;
        //   367: aconst_null    
        //   368: invokevirtual   net/minecraft/entity/EntityLiving.func_180482_a:(Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/entity/IEntityLivingData;)Lnet/minecraft/entity/IEntityLivingData;
        //   371: pop            
        //   372: aload           llllllllllllllIIIIlIlllIlIIIIIll
        //   374: aload           llllllllllllllIIIIlIlllIIlllllIl
        //   376: invokevirtual   net/minecraft/world/World.spawnEntityInWorld:(Lnet/minecraft/entity/Entity;)Z
        //   379: pop            
        //   380: aload           llllllllllllllIIIIlIlllIIlllllIl
        //   382: astore          llllllllllllllIIIIlIlllIIllllIll
        //   384: aload           llllllllllllllIIIIlIlllIlIIIIIlI
        //   386: astore          llllllllllllllIIIIlIlllIIllllIlI
        //   388: goto            459
        //   391: aload           llllllllllllllIIIIlIlllIIllllIlI
        //   393: ldc             "Riding"
        //   395: invokevirtual   net/minecraft/nbt/NBTTagCompound.getCompoundTag:(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;
        //   398: aload           llllllllllllllIIIIlIlllIlIIIIIll
        //   400: invokestatic    net/minecraft/entity/EntityList.createEntityFromNBT:(Lnet/minecraft/nbt/NBTTagCompound;Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
        //   403: astore          llllllllllllllIIIIlIlllIIllllIIl
        //   405: aload           llllllllllllllIIIIlIlllIIllllIIl
        //   407: ifnull          446
        //   410: aload           llllllllllllllIIIIlIlllIIllllIIl
        //   412: dload           llllllllllllllIIIIlIlllIlIIIIllI
        //   414: dload           llllllllllllllIIIIlIlllIlIIIIlIl
        //   416: dload           llllllllllllllIIIIlIlllIlIIIIlII
        //   418: aload           llllllllllllllIIIIlIlllIIllllIIl
        //   420: getfield        net/minecraft/entity/Entity.rotationYaw:F
        //   423: aload           llllllllllllllIIIIlIlllIIllllIIl
        //   425: getfield        net/minecraft/entity/Entity.rotationPitch:F
        //   428: invokevirtual   net/minecraft/entity/Entity.setLocationAndAngles:(DDDFF)V
        //   431: aload           llllllllllllllIIIIlIlllIlIIIIIll
        //   433: aload           llllllllllllllIIIIlIlllIIllllIIl
        //   435: invokevirtual   net/minecraft/world/World.spawnEntityInWorld:(Lnet/minecraft/entity/Entity;)Z
        //   438: pop            
        //   439: aload           llllllllllllllIIIIlIlllIIllllIll
        //   441: aload           llllllllllllllIIIIlIlllIIllllIIl
        //   443: invokevirtual   net/minecraft/entity/Entity.mountEntity:(Lnet/minecraft/entity/Entity;)V
        //   446: aload           llllllllllllllIIIIlIlllIIllllIIl
        //   448: astore          llllllllllllllIIIIlIlllIIllllIll
        //   450: aload           llllllllllllllIIIIlIlllIIllllIlI
        //   452: ldc             "Riding"
        //   454: invokevirtual   net/minecraft/nbt/NBTTagCompound.getCompoundTag:(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;
        //   457: astore          llllllllllllllIIIIlIlllIIllllIlI
        //   459: aload           llllllllllllllIIIIlIlllIIllllIll
        //   461: ifnull          476
        //   464: aload           llllllllllllllIIIIlIlllIIllllIlI
        //   466: ldc             "Riding"
        //   468: bipush          10
        //   470: invokevirtual   net/minecraft/nbt/NBTTagCompound.hasKey:(Ljava/lang/String;I)Z
        //   473: ifne            391
        //   476: aload_1         /* llllllllllllllIIIIlIlllIIlllIlll */
        //   477: aload_0         /* llllllllllllllIIIIlIlllIlIIIllII */
        //   478: ldc             "commands.summon.success"
        //   480: iconst_0       
        //   481: anewarray       Ljava/lang/Object;
        //   484: invokestatic    net/minecraft/command/server/CommandSummon.notifyOperators:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   487: return         
        //    Exceptions:
        //  throws net.minecraft.command.CommandException
        //    StackMapTable: 00 0F 14 FF 00 5E 00 09 07 00 02 07 00 3B 07 00 FC 07 00 69 07 00 55 07 00 45 03 03 03 00 00 FC 00 1F 07 00 5E 2B FF 00 2B 00 0D 07 00 02 07 00 3B 07 00 FC 07 00 69 07 00 55 07 00 45 03 03 03 07 00 5E 07 00 7E 01 07 00 87 00 01 07 00 2D FA 00 17 53 07 00 2F FC 00 0F 07 00 A3 12 39 FD 00 12 07 00 A3 07 00 7E FC 00 36 07 00 A3 FA 00 0C 10 FF 00 0A 00 0A 07 00 02 07 00 3B 07 00 FC 07 00 69 07 00 55 07 00 45 03 03 03 07 00 5E 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  217    232    235    259    Lnet/minecraft/nbt/NBTException;
        //  267    276    279    295    Ljava/lang/RuntimeException;
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
    
    static {
        __OBFID = "CL_00001158";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIIIlIlllIlIIlllIl) {
        return "commands.summon.usage";
    }
}
