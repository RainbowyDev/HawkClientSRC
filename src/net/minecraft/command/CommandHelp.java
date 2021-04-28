package net.minecraft.command;

import net.minecraft.util.*;
import net.minecraft.server.*;
import java.util.*;

public class CommandHelp extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lIlIIlllIIIIIlI, final String[] lIlIIllIlllllIl, final BlockPos lIlIIlllIIIIIII) {
        if (lIlIIllIlllllIl.length == 1) {
            final Set lIlIIllIlllllll = this.getCommands().keySet();
            return CommandBase.getListOfStringsMatchingLastWord(lIlIIllIlllllIl, (String[])lIlIIllIlllllll.toArray(new String[lIlIIllIlllllll.size()]));
        }
        return null;
    }
    
    protected List getSortedPossibleCommands(final ICommandSender lIlIIlllIIIlIll) {
        final List lIlIIlllIIIlIlI = MinecraftServer.getServer().getCommandManager().getPossibleCommands(lIlIIlllIIIlIll);
        Collections.sort((List<Comparable>)lIlIIlllIIIlIlI);
        return lIlIIlllIIIlIlI;
    }
    
    static {
        __OBFID = "CL_00000529";
    }
    
    @Override
    public String getCommandName() {
        return "help";
    }
    
    @Override
    public void processCommand(final ICommandSender lIlIIlllIIllIlI, final String[] lIlIIlllIIllIIl) throws CommandException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* lIlIIlllIlIllII */
        //     2: invokevirtual   net/minecraft/command/CommandHelp.getSortedPossibleCommands:(Lnet/minecraft/command/ICommandSender;)Ljava/util/List;
        //     5: astore_3        /* lIlIIlllIlIlIlI */
        //     6: iconst_1       
        //     7: istore          lIlIIlllIlIlIIl
        //     9: aload_3         /* lIlIIlllIlIlIlI */
        //    10: invokeinterface java/util/List.size:()I
        //    15: iconst_1       
        //    16: isub           
        //    17: bipush          7
        //    19: idiv           
        //    20: istore          lIlIIlllIlIlIII
        //    22: iconst_0       
        //    23: istore          lIlIIlllIlIIlll
        //    25: aload_2         /* lIlIIlllIlIlIll */
        //    26: arraylength    
        //    27: ifne            34
        //    30: iconst_0       
        //    31: goto            47
        //    34: aload_2         /* lIlIIlllIlIlIll */
        //    35: iconst_0       
        //    36: aaload         
        //    37: iconst_1       
        //    38: iload           lIlIIlllIlIlIII
        //    40: iconst_1       
        //    41: iadd           
        //    42: invokestatic    net/minecraft/command/CommandHelp.parseInt:(Ljava/lang/String;II)I
        //    45: iconst_1       
        //    46: isub           
        //    47: istore          lIlIIlllIlIIllI
        //    49: goto            122
        //    52: astore          lIlIIlllIlIIlII
        //    54: aload_0         /* lIlIIlllIIllIll */
        //    55: invokevirtual   net/minecraft/command/CommandHelp.getCommands:()Ljava/util/Map;
        //    58: astore          lIlIIlllIlIIIll
        //    60: aload           lIlIIlllIlIIIll
        //    62: aload_2         /* lIlIIlllIlIlIll */
        //    63: iconst_0       
        //    64: aaload         
        //    65: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    70: checkcast       Lnet/minecraft/command/ICommand;
        //    73: astore          lIlIIlllIlIIIlI
        //    75: aload           lIlIIlllIlIIIlI
        //    77: ifnull          100
        //    80: new             Lnet/minecraft/command/WrongUsageException;
        //    83: dup            
        //    84: aload           lIlIIlllIlIIIlI
        //    86: aload_1         /* lIlIIlllIlIllII */
        //    87: invokeinterface net/minecraft/command/ICommand.getCommandUsage:(Lnet/minecraft/command/ICommandSender;)Ljava/lang/String;
        //    92: iconst_0       
        //    93: anewarray       Ljava/lang/Object;
        //    96: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    99: athrow         
        //   100: aload_2         /* lIlIIlllIlIlIll */
        //   101: iconst_0       
        //   102: aaload         
        //   103: iconst_m1      
        //   104: invokestatic    net/minecraft/util/MathHelper.parseIntWithDefault:(Ljava/lang/String;I)I
        //   107: iconst_m1      
        //   108: if_icmpeq       114
        //   111: aload           lIlIIlllIlIIlII
        //   113: athrow         
        //   114: new             Lnet/minecraft/command/CommandNotFoundException;
        //   117: dup            
        //   118: invokespecial   net/minecraft/command/CommandNotFoundException.<init>:()V
        //   121: athrow         
        //   122: iload           lIlIIlllIlIIlIl
        //   124: iconst_1       
        //   125: iadd           
        //   126: bipush          7
        //   128: imul           
        //   129: aload_3         /* lIlIIlllIlIlIlI */
        //   130: invokeinterface java/util/List.size:()I
        //   135: invokestatic    java/lang/Math.min:(II)I
        //   138: istore          lIlIIlllIlIIIIl
        //   140: new             Lnet/minecraft/util/ChatComponentTranslation;
        //   143: dup            
        //   144: ldc             "commands.help.header"
        //   146: iconst_2       
        //   147: anewarray       Ljava/lang/Object;
        //   150: dup            
        //   151: iconst_0       
        //   152: iload           lIlIIlllIlIIlIl
        //   154: iconst_1       
        //   155: iadd           
        //   156: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   159: aastore        
        //   160: dup            
        //   161: iconst_1       
        //   162: iload           lIlIIlllIlIlIII
        //   164: iconst_1       
        //   165: iadd           
        //   166: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   169: aastore        
        //   170: invokespecial   net/minecraft/util/ChatComponentTranslation.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   173: astore          lIlIIlllIlIIIII
        //   175: aload           lIlIIlllIlIIIII
        //   177: invokevirtual   net/minecraft/util/ChatComponentTranslation.getChatStyle:()Lnet/minecraft/util/ChatStyle;
        //   180: getstatic       net/minecraft/util/EnumChatFormatting.DARK_GREEN:Lnet/minecraft/util/EnumChatFormatting;
        //   183: invokevirtual   net/minecraft/util/ChatStyle.setColor:(Lnet/minecraft/util/EnumChatFormatting;)Lnet/minecraft/util/ChatStyle;
        //   186: pop            
        //   187: aload_1         /* lIlIIlllIlIllII */
        //   188: aload           lIlIIlllIlIIIII
        //   190: invokeinterface net/minecraft/command/ICommandSender.addChatMessage:(Lnet/minecraft/util/IChatComponent;)V
        //   195: iload           lIlIIlllIlIIlIl
        //   197: bipush          7
        //   199: imul           
        //   200: istore          lIlIIlllIIlllll
        //   202: goto            296
        //   205: aload_3         /* lIlIIlllIlIlIlI */
        //   206: iload           lIlIIlllIIlllll
        //   208: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   213: checkcast       Lnet/minecraft/command/ICommand;
        //   216: astore          lIlIIlllIIllllI
        //   218: new             Lnet/minecraft/util/ChatComponentTranslation;
        //   221: dup            
        //   222: aload           lIlIIlllIIllllI
        //   224: aload_1         /* lIlIIlllIlIllII */
        //   225: invokeinterface net/minecraft/command/ICommand.getCommandUsage:(Lnet/minecraft/command/ICommandSender;)Ljava/lang/String;
        //   230: iconst_0       
        //   231: anewarray       Ljava/lang/Object;
        //   234: invokespecial   net/minecraft/util/ChatComponentTranslation.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   237: astore          lIlIIlllIIlllIl
        //   239: aload           lIlIIlllIIlllIl
        //   241: invokevirtual   net/minecraft/util/ChatComponentTranslation.getChatStyle:()Lnet/minecraft/util/ChatStyle;
        //   244: new             Lnet/minecraft/event/ClickEvent;
        //   247: dup            
        //   248: getstatic       net/minecraft/event/ClickEvent$Action.SUGGEST_COMMAND:Lnet/minecraft/event/ClickEvent$Action;
        //   251: new             Ljava/lang/StringBuilder;
        //   254: dup            
        //   255: ldc             "/"
        //   257: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   260: aload           lIlIIlllIIllllI
        //   262: invokeinterface net/minecraft/command/ICommand.getCommandName:()Ljava/lang/String;
        //   267: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   270: ldc             " "
        //   272: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   275: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   278: invokespecial   net/minecraft/event/ClickEvent.<init>:(Lnet/minecraft/event/ClickEvent$Action;Ljava/lang/String;)V
        //   281: invokevirtual   net/minecraft/util/ChatStyle.setChatClickEvent:(Lnet/minecraft/event/ClickEvent;)Lnet/minecraft/util/ChatStyle;
        //   284: pop            
        //   285: aload_1         /* lIlIIlllIlIllII */
        //   286: aload           lIlIIlllIIlllIl
        //   288: invokeinterface net/minecraft/command/ICommandSender.addChatMessage:(Lnet/minecraft/util/IChatComponent;)V
        //   293: iinc            lIlIIlllIIlllll, 1
        //   296: iload           lIlIIlllIIlllll
        //   298: iload           lIlIIlllIlIIIIl
        //   300: if_icmplt       205
        //   303: iload           lIlIIlllIlIIlIl
        //   305: ifne            350
        //   308: aload_1         /* lIlIIlllIlIllII */
        //   309: instanceof      Lnet/minecraft/entity/player/EntityPlayer;
        //   312: ifeq            350
        //   315: new             Lnet/minecraft/util/ChatComponentTranslation;
        //   318: dup            
        //   319: ldc             "commands.help.footer"
        //   321: iconst_0       
        //   322: anewarray       Ljava/lang/Object;
        //   325: invokespecial   net/minecraft/util/ChatComponentTranslation.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   328: astore          lIlIIlllIIlllII
        //   330: aload           lIlIIlllIIlllII
        //   332: invokevirtual   net/minecraft/util/ChatComponentTranslation.getChatStyle:()Lnet/minecraft/util/ChatStyle;
        //   335: getstatic       net/minecraft/util/EnumChatFormatting.GREEN:Lnet/minecraft/util/EnumChatFormatting;
        //   338: invokevirtual   net/minecraft/util/ChatStyle.setColor:(Lnet/minecraft/util/EnumChatFormatting;)Lnet/minecraft/util/ChatStyle;
        //   341: pop            
        //   342: aload_1         /* lIlIIlllIlIllII */
        //   343: aload           lIlIIlllIIlllII
        //   345: invokeinterface net/minecraft/command/ICommandSender.addChatMessage:(Lnet/minecraft/util/IChatComponent;)V
        //   350: return         
        //    Exceptions:
        //  throws net.minecraft.command.CommandException
        //    StackMapTable: 00 09 FF 00 22 00 07 07 00 02 07 00 B1 07 00 28 07 00 6D 01 01 01 00 00 4C 01 44 07 00 69 FF 00 2F 00 0B 07 00 02 07 00 B1 07 00 28 07 00 6D 01 01 01 00 07 00 69 07 00 17 07 00 78 00 00 0D FF 00 07 00 08 07 00 02 07 00 B1 07 00 28 07 00 6D 01 01 01 01 00 00 FE 00 52 01 07 00 96 01 FB 00 5A FA 00 35
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                          
        //  -----  -----  -----  -----  ----------------------------------------------
        //  25     49     52     122    Lnet/minecraft/command/NumberInvalidException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lIlIIlllIllllII) {
        return "commands.help.usage";
    }
    
    @Override
    public List getCommandAliases() {
        return Arrays.asList("?");
    }
    
    protected Map getCommands() {
        return MinecraftServer.getServer().getCommandManager().getCommands();
    }
}
