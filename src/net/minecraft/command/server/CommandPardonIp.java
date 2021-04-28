package net.minecraft.command.server;

import net.minecraft.server.*;
import java.util.regex.*;
import net.minecraft.command.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandPardonIp extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender llllllllllllllIIlllIlIllllllIlll, final String[] llllllllllllllIIlllIlIllllllIllI) throws CommandException {
        if (llllllllllllllIIlllIlIllllllIllI.length != 1 || llllllllllllllIIlllIlIllllllIllI[0].length() <= 1) {
            throw new WrongUsageException("commands.unbanip.usage", new Object[0]);
        }
        final Matcher llllllllllllllIIlllIlIllllllIlIl = CommandBanIp.field_147211_a.matcher(llllllllllllllIIlllIlIllllllIllI[0]);
        if (llllllllllllllIIlllIlIllllllIlIl.matches()) {
            MinecraftServer.getServer().getConfigurationManager().getBannedIPs().removeEntry(llllllllllllllIIlllIlIllllllIllI[0]);
            CommandBase.notifyOperators(llllllllllllllIIlllIlIllllllIlll, this, "commands.unbanip.success", llllllllllllllIIlllIlIllllllIllI[0]);
            return;
        }
        throw new SyntaxErrorException("commands.unbanip.invalid", new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlllIlIllllllllIl) {
        return "commands.unbanip.usage";
    }
    
    @Override
    public String getCommandName() {
        return "pardon-ip";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIIlllIlIlllllIlllI, final String[] llllllllllllllIIlllIlIlllllIllIl, final BlockPos llllllllllllllIIlllIlIlllllIllII) {
        return (llllllllllllllIIlllIlIlllllIllIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlllIlIlllllIllIl, MinecraftServer.getServer().getConfigurationManager().getBannedIPs().getKeys()) : null;
    }
    
    static {
        __OBFID = "CL_00000720";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final ICommandSender llllllllllllllIIlllIllIIIIIIIIIl) {
        return MinecraftServer.getServer().getConfigurationManager().getBannedIPs().isLanServer() && super.canCommandSenderUseCommand(llllllllllllllIIlllIllIIIIIIIIIl);
    }
}
