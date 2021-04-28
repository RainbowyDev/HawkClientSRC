package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandBroadcast extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender llllllllllllllIllllIlIIlIIIIIllI, final String[] llllllllllllllIllllIlIIlIIIIIlIl) throws CommandException {
        if (llllllllllllllIllllIlIIlIIIIIlIl.length > 0 && llllllllllllllIllllIlIIlIIIIIlIl[0].length() > 0) {
            final IChatComponent llllllllllllllIllllIlIIlIIIIIlII = CommandBase.getChatComponentFromNthArg(llllllllllllllIllllIlIIlIIIIIllI, llllllllllllllIllllIlIIlIIIIIlIl, 0, true);
            MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentTranslation("chat.type.announcement", new Object[] { llllllllllllllIllllIlIIlIIIIIllI.getDisplayName(), llllllllllllllIllllIlIIlIIIIIlII }));
            return;
        }
        throw new WrongUsageException("commands.say.usage", new Object[0]);
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIllllIlIIIlllllllI, final String[] llllllllllllllIllllIlIIIlllllIll, final BlockPos llllllllllllllIllllIlIIIllllllII) {
        return (llllllllllllllIllllIlIIIlllllIll.length >= 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllllIlIIIlllllIll, MinecraftServer.getServer().getAllUsernames()) : null;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 1;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIllllIlIIlIIIIlIll) {
        return "commands.say.usage";
    }
    
    @Override
    public String getCommandName() {
        return "say";
    }
    
    static {
        __OBFID = "CL_00000191";
    }
}
