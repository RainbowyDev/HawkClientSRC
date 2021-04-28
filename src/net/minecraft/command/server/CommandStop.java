package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;

public class CommandStop extends CommandBase
{
    static {
        __OBFID = "CL_00001132";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIIllIlIIIIIlIIllI) {
        return "commands.stop.usage";
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIIllIlIIIIIlIIIlI, final String[] lllllllllllllllIIllIlIIIIIlIIIIl) throws CommandException {
        if (MinecraftServer.getServer().worldServers != null) {
            CommandBase.notifyOperators(lllllllllllllllIIllIlIIIIIlIIIlI, this, "commands.stop.start", new Object[0]);
        }
        MinecraftServer.getServer().initiateShutdown();
    }
    
    @Override
    public String getCommandName() {
        return "stop";
    }
}
