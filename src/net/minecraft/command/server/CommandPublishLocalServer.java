package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.world.*;
import net.minecraft.command.*;

public class CommandPublishLocalServer extends CommandBase
{
    @Override
    public String getCommandName() {
        return "publish";
    }
    
    static {
        __OBFID = "CL_00000799";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllllIIIlIlIIlIIllll) {
        return "commands.publish.usage";
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllllIIIlIlIIlIIIllI, final String[] lllllllllllllllllIIIlIlIIlIIlIIl) throws CommandException {
        final String lllllllllllllllllIIIlIlIIlIIlIII = MinecraftServer.getServer().shareToLAN(WorldSettings.GameType.SURVIVAL, false);
        if (lllllllllllllllllIIIlIlIIlIIlIII != null) {
            CommandBase.notifyOperators(lllllllllllllllllIIIlIlIIlIIIllI, this, "commands.publish.started", lllllllllllllllllIIIlIlIIlIIlIII);
        }
        else {
            CommandBase.notifyOperators(lllllllllllllllllIIIlIlIIlIIIllI, this, "commands.publish.failed", new Object[0]);
        }
    }
}
