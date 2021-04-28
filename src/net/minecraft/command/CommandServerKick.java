package net.minecraft.command;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;

public class CommandServerKick extends CommandBase
{
    @Override
    public String getCommandName() {
        return "kick";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllllllllIIlIIllIlIlI, final String[] llllllllllllllllllllIIlIIllIlIIl, final BlockPos llllllllllllllllllllIIlIIllIlIII) {
        return (llllllllllllllllllllIIlIIllIlIIl.length >= 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllllllIIlIIllIlIIl, MinecraftServer.getServer().getAllUsernames()) : null;
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllllllllIIlIIlllIlll, final String[] llllllllllllllllllllIIlIIlllIIII) throws CommandException {
        if (llllllllllllllllllllIIlIIlllIIII.length <= 0 || llllllllllllllllllllIIlIIlllIIII[0].length() <= 1) {
            throw new WrongUsageException("commands.kick.usage", new Object[0]);
        }
        final EntityPlayerMP llllllllllllllllllllIIlIIlllIlIl = MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(llllllllllllllllllllIIlIIlllIIII[0]);
        String llllllllllllllllllllIIlIIlllIlII = "Kicked by an operator.";
        boolean llllllllllllllllllllIIlIIlllIIll = false;
        if (llllllllllllllllllllIIlIIlllIlIl == null) {
            throw new PlayerNotFoundException();
        }
        if (llllllllllllllllllllIIlIIlllIIII.length >= 2) {
            llllllllllllllllllllIIlIIlllIlII = CommandBase.getChatComponentFromNthArg(llllllllllllllllllllIIlIIlllIlll, llllllllllllllllllllIIlIIlllIIII, 1).getUnformattedText();
            llllllllllllllllllllIIlIIlllIIll = true;
        }
        llllllllllllllllllllIIlIIlllIlIl.playerNetServerHandler.kickPlayerFromServer(llllllllllllllllllllIIlIIlllIlII);
        if (llllllllllllllllllllIIlIIlllIIll) {
            CommandBase.notifyOperators(llllllllllllllllllllIIlIIlllIlll, this, "commands.kick.success.reason", llllllllllllllllllllIIlIIlllIlIl.getName(), llllllllllllllllllllIIlIIlllIlII);
        }
        else {
            CommandBase.notifyOperators(llllllllllllllllllllIIlIIlllIlll, this, "commands.kick.success", llllllllllllllllllllIIlIIlllIlIl.getName());
        }
    }
    
    static {
        __OBFID = "CL_00000550";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllllllIIlIIlllllll) {
        return "commands.kick.usage";
    }
}
