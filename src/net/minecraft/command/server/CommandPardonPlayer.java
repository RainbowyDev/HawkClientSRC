package net.minecraft.command.server;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;
import net.minecraft.command.*;
import com.mojang.authlib.*;

public class CommandPardonPlayer extends CommandBase
{
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIllIllllIIlIIIlll, final String[] lllllllllllllllIllIllllIIlIIIllI, final BlockPos lllllllllllllllIllIllllIIlIIIlIl) {
        return (lllllllllllllllIllIllllIIlIIIllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIllIllllIIlIIIllI, MinecraftServer.getServer().getConfigurationManager().getBannedPlayers().getKeys()) : null;
    }
    
    static {
        __OBFID = "CL_00000747";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIllIllllIIlIlllll) {
        return "commands.unban.usage";
    }
    
    @Override
    public String getCommandName() {
        return "pardon";
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIllIllllIIlIlIIlI, final String[] lllllllllllllllIllIllllIIlIIllII) throws CommandException {
        if (lllllllllllllllIllIllllIIlIIllII.length != 1 || lllllllllllllllIllIllllIIlIIllII[0].length() <= 0) {
            throw new WrongUsageException("commands.unban.usage", new Object[0]);
        }
        final MinecraftServer lllllllllllllllIllIllllIIlIlIIII = MinecraftServer.getServer();
        final GameProfile lllllllllllllllIllIllllIIlIIllll = lllllllllllllllIllIllllIIlIlIIII.getConfigurationManager().getBannedPlayers().isUsernameBanned(lllllllllllllllIllIllllIIlIIllII[0]);
        if (lllllllllllllllIllIllllIIlIIllll == null) {
            throw new CommandException("commands.unban.failed", new Object[] { lllllllllllllllIllIllllIIlIIllII[0] });
        }
        lllllllllllllllIllIllllIIlIlIIII.getConfigurationManager().getBannedPlayers().removeEntry(lllllllllllllllIllIllllIIlIIllll);
        CommandBase.notifyOperators(lllllllllllllllIllIllllIIlIlIIlI, this, "commands.unban.success", lllllllllllllllIllIllllIIlIIllII[0]);
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final ICommandSender lllllllllllllllIllIllllIIlIllIll) {
        return MinecraftServer.getServer().getConfigurationManager().getBannedPlayers().isLanServer() && super.canCommandSenderUseCommand(lllllllllllllllIllIllllIIlIllIll);
    }
}
