package net.minecraft.command;

import net.minecraft.util.*;
import java.util.*;

public class CommandBlockData extends CommandBase
{
    @Override
    public String getCommandName() {
        return "blockdata";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIIlIIIlIlIIlllIl, final String[] llllllllllllllIlIIlIIIlIlIlIIlll) throws CommandException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: iconst_4       
        //     3: if_icmpge       20
        //     6: new             Lnet/minecraft/command/WrongUsageException;
        //     9: dup            
        //    10: ldc             "commands.blockdata.usage"
        //    12: iconst_0       
        //    13: anewarray       Ljava/lang/Object;
        //    16: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    19: athrow         
        //    20: aload_1         /* llllllllllllllIlIIlIIIlIlIlIlIII */
        //    21: getstatic       net/minecraft/command/CommandResultStats$Type.AFFECTED_BLOCKS:Lnet/minecraft/command/CommandResultStats$Type;
        //    24: iconst_0       
        //    25: invokeinterface net/minecraft/command/ICommandSender.func_174794_a:(Lnet/minecraft/command/CommandResultStats$Type;I)V
        //    30: aload_1         /* llllllllllllllIlIIlIIIlIlIlIlIII */
        //    31: aload_2         /* llllllllllllllIlIIlIIIlIlIIlllII */
        //    32: iconst_0       
        //    33: iconst_0       
        //    34: invokestatic    net/minecraft/command/CommandBlockData.func_175757_a:(Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;IZ)Lnet/minecraft/util/BlockPos;
        //    37: astore_3        /* llllllllllllllIlIIlIIIlIlIlIIllI */
        //    38: aload_1         /* llllllllllllllIlIIlIIIlIlIlIlIII */
        //    39: invokeinterface net/minecraft/command/ICommandSender.getEntityWorld:()Lnet/minecraft/world/World;
        //    44: astore          llllllllllllllIlIIlIIIlIlIlIIlIl
        //    46: aload           llllllllllllllIlIIlIIIlIlIlIIlIl
        //    48: aload_3         /* llllllllllllllIlIIlIIIlIlIlIIllI */
        //    49: invokevirtual   net/minecraft/world/World.isBlockLoaded:(Lnet/minecraft/util/BlockPos;)Z
        //    52: ifne            69
        //    55: new             Lnet/minecraft/command/CommandException;
        //    58: dup            
        //    59: ldc             "commands.blockdata.outOfWorld"
        //    61: iconst_0       
        //    62: anewarray       Ljava/lang/Object;
        //    65: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    68: athrow         
        //    69: aload           llllllllllllllIlIIlIIIlIlIlIIlIl
        //    71: aload_3         /* llllllllllllllIlIIlIIIlIlIlIIllI */
        //    72: invokevirtual   net/minecraft/world/World.getTileEntity:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/tileentity/TileEntity;
        //    75: astore          llllllllllllllIlIIlIIIlIlIlIIlII
        //    77: aload           llllllllllllllIlIIlIIIlIlIlIIlII
        //    79: ifnonnull       96
        //    82: new             Lnet/minecraft/command/CommandException;
        //    85: dup            
        //    86: ldc             "commands.blockdata.notValid"
        //    88: iconst_0       
        //    89: anewarray       Ljava/lang/Object;
        //    92: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    95: athrow         
        //    96: new             Lnet/minecraft/nbt/NBTTagCompound;
        //    99: dup            
        //   100: invokespecial   net/minecraft/nbt/NBTTagCompound.<init>:()V
        //   103: astore          llllllllllllllIlIIlIIIlIlIlIIIll
        //   105: aload           llllllllllllllIlIIlIIIlIlIlIIlII
        //   107: aload           llllllllllllllIlIIlIIIlIlIlIIIll
        //   109: invokevirtual   net/minecraft/tileentity/TileEntity.writeToNBT:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   112: aload           llllllllllllllIlIIlIIIlIlIlIIIll
        //   114: invokevirtual   net/minecraft/nbt/NBTTagCompound.copy:()Lnet/minecraft/nbt/NBTBase;
        //   117: checkcast       Lnet/minecraft/nbt/NBTTagCompound;
        //   120: astore          llllllllllllllIlIIlIIIlIlIlIIIlI
        //   122: aload_1         /* llllllllllllllIlIIlIIIlIlIlIlIII */
        //   123: aload_2         /* llllllllllllllIlIIlIIIlIlIIlllII */
        //   124: iconst_3       
        //   125: invokestatic    net/minecraft/command/CommandBlockData.getChatComponentFromNthArg:(Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;I)Lnet/minecraft/util/IChatComponent;
        //   128: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText:()Ljava/lang/String;
        //   133: invokestatic    net/minecraft/nbt/JsonToNBT.func_180713_a:(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;
        //   136: astore          llllllllllllllIlIIlIIIlIlIlIIIIl
        //   138: goto            165
        //   141: astore          llllllllllllllIlIIlIIIlIlIIlllll
        //   143: new             Lnet/minecraft/command/CommandException;
        //   146: dup            
        //   147: ldc             "commands.blockdata.tagError"
        //   149: iconst_1       
        //   150: anewarray       Ljava/lang/Object;
        //   153: dup            
        //   154: iconst_0       
        //   155: aload           llllllllllllllIlIIlIIIlIlIIlllll
        //   157: invokevirtual   net/minecraft/nbt/NBTException.getMessage:()Ljava/lang/String;
        //   160: aastore        
        //   161: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   164: athrow         
        //   165: aload           llllllllllllllIlIIlIIIlIlIlIIIll
        //   167: aload           llllllllllllllIlIIlIIIlIlIlIIIII
        //   169: invokevirtual   net/minecraft/nbt/NBTTagCompound.merge:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   172: aload           llllllllllllllIlIIlIIIlIlIlIIIll
        //   174: ldc             "x"
        //   176: aload_3         /* llllllllllllllIlIIlIIIlIlIlIIllI */
        //   177: invokevirtual   net/minecraft/util/BlockPos.getX:()I
        //   180: invokevirtual   net/minecraft/nbt/NBTTagCompound.setInteger:(Ljava/lang/String;I)V
        //   183: aload           llllllllllllllIlIIlIIIlIlIlIIIll
        //   185: ldc             "y"
        //   187: aload_3         /* llllllllllllllIlIIlIIIlIlIlIIllI */
        //   188: invokevirtual   net/minecraft/util/BlockPos.getY:()I
        //   191: invokevirtual   net/minecraft/nbt/NBTTagCompound.setInteger:(Ljava/lang/String;I)V
        //   194: aload           llllllllllllllIlIIlIIIlIlIlIIIll
        //   196: ldc             "z"
        //   198: aload_3         /* llllllllllllllIlIIlIIIlIlIlIIllI */
        //   199: invokevirtual   net/minecraft/util/BlockPos.getZ:()I
        //   202: invokevirtual   net/minecraft/nbt/NBTTagCompound.setInteger:(Ljava/lang/String;I)V
        //   205: aload           llllllllllllllIlIIlIIIlIlIlIIIll
        //   207: aload           llllllllllllllIlIIlIIIlIlIlIIIlI
        //   209: invokevirtual   net/minecraft/nbt/NBTTagCompound.equals:(Ljava/lang/Object;)Z
        //   212: ifeq            237
        //   215: new             Lnet/minecraft/command/CommandException;
        //   218: dup            
        //   219: ldc             "commands.blockdata.failed"
        //   221: iconst_1       
        //   222: anewarray       Ljava/lang/Object;
        //   225: dup            
        //   226: iconst_0       
        //   227: aload           llllllllllllllIlIIlIIIlIlIlIIIll
        //   229: invokevirtual   net/minecraft/nbt/NBTTagCompound.toString:()Ljava/lang/String;
        //   232: aastore        
        //   233: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   236: athrow         
        //   237: aload           llllllllllllllIlIIlIIIlIlIlIIlII
        //   239: aload           llllllllllllllIlIIlIIIlIlIlIIIll
        //   241: invokevirtual   net/minecraft/tileentity/TileEntity.readFromNBT:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   244: aload           llllllllllllllIlIIlIIIlIlIlIIlII
        //   246: invokevirtual   net/minecraft/tileentity/TileEntity.markDirty:()V
        //   249: aload           llllllllllllllIlIIlIIIlIlIlIIlIl
        //   251: aload_3         /* llllllllllllllIlIIlIIIlIlIlIIllI */
        //   252: invokevirtual   net/minecraft/world/World.markBlockForUpdate:(Lnet/minecraft/util/BlockPos;)V
        //   255: aload_1         /* llllllllllllllIlIIlIIIlIlIlIlIII */
        //   256: getstatic       net/minecraft/command/CommandResultStats$Type.AFFECTED_BLOCKS:Lnet/minecraft/command/CommandResultStats$Type;
        //   259: iconst_1       
        //   260: invokeinterface net/minecraft/command/ICommandSender.func_174794_a:(Lnet/minecraft/command/CommandResultStats$Type;I)V
        //   265: aload_1         /* llllllllllllllIlIIlIIIlIlIlIlIII */
        //   266: aload_0         /* llllllllllllllIlIIlIIIlIlIIllllI */
        //   267: ldc             "commands.blockdata.success"
        //   269: iconst_1       
        //   270: anewarray       Ljava/lang/Object;
        //   273: dup            
        //   274: iconst_0       
        //   275: aload           llllllllllllllIlIIlIIIlIlIlIIIll
        //   277: invokevirtual   net/minecraft/nbt/NBTTagCompound.toString:()Ljava/lang/String;
        //   280: aastore        
        //   281: invokestatic    net/minecraft/command/CommandBlockData.notifyOperators:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   284: return         
        //    Exceptions:
        //  throws net.minecraft.command.CommandException
        //    StackMapTable: 00 06 14 FD 00 30 07 00 6C 07 00 35 FC 00 1A 07 00 49 FF 00 2C 00 08 07 00 02 07 00 27 07 00 BA 07 00 6C 07 00 35 07 00 49 07 00 44 07 00 44 00 01 07 00 17 FC 00 17 07 00 44 FB 00 47
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  122    138    141    165    Lnet/minecraft/nbt/NBTException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIIlIIIlIlIllIlII) {
        return "commands.blockdata.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIlIIlIIIlIlIIlIIIl, final String[] llllllllllllllIlIIlIIIlIlIIIlllI, final BlockPos llllllllllllllIlIIlIIIlIlIIIllIl) {
        return (llllllllllllllIlIIlIIIlIlIIIlllI.length > 0 && llllllllllllllIlIIlIIIlIlIIIlllI.length <= 3) ? CommandBase.func_175771_a(llllllllllllllIlIIlIIIlIlIIIlllI, 0, llllllllllllllIlIIlIIIlIlIIIllIl) : null;
    }
    
    static {
        __OBFID = "CL_00002349";
    }
}
