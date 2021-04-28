package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import net.minecraft.world.*;

public class CommandSaveOff extends CommandBase
{
    static {
        __OBFID = "CL_00000847";
    }
    
    @Override
    public String getCommandName() {
        return "save-off";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllllIlllIIllIlIlIIll, final String[] llllllllllllllllIlllIIllIlIlIIlI) throws CommandException {
        final MinecraftServer llllllllllllllllIlllIIllIlIlIIIl = MinecraftServer.getServer();
        boolean llllllllllllllllIlllIIllIlIIllll = false;
        for (int llllllllllllllllIlllIIllIlIIllIl = 0; llllllllllllllllIlllIIllIlIIllIl < llllllllllllllllIlllIIllIlIlIIIl.worldServers.length; ++llllllllllllllllIlllIIllIlIIllIl) {
            if (llllllllllllllllIlllIIllIlIlIIIl.worldServers[llllllllllllllllIlllIIllIlIIllIl] != null) {
                final WorldServer llllllllllllllllIlllIIllIlIIlIll = llllllllllllllllIlllIIllIlIlIIIl.worldServers[llllllllllllllllIlllIIllIlIIllIl];
                if (!llllllllllllllllIlllIIllIlIIlIll.disableLevelSaving) {
                    llllllllllllllllIlllIIllIlIIlIll.disableLevelSaving = true;
                    llllllllllllllllIlllIIllIlIIllll = true;
                }
            }
        }
        if (llllllllllllllllIlllIIllIlIIllll) {
            CommandBase.notifyOperators(llllllllllllllllIlllIIllIlIlIIll, this, "commands.save.disabled", new Object[0]);
            return;
        }
        throw new CommandException("commands.save-off.alreadyOff", new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIlllIIllIllIIIII) {
        return "commands.save-off.usage";
    }
}
