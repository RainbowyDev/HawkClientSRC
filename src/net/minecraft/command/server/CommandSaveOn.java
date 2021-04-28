package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import net.minecraft.world.*;

public class CommandSaveOn extends CommandBase
{
    @Override
    public String getCommandName() {
        return "save-on";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIllllIlIIIIllIII, final String[] llllllllllllllIlIllllIlIIIIllllI) throws CommandException {
        final MinecraftServer llllllllllllllIlIllllIlIIIIlllIl = MinecraftServer.getServer();
        boolean llllllllllllllIlIllllIlIIIIlllII = false;
        for (int llllllllllllllIlIllllIlIIIIllIll = 0; llllllllllllllIlIllllIlIIIIllIll < llllllllllllllIlIllllIlIIIIlllIl.worldServers.length; ++llllllllllllllIlIllllIlIIIIllIll) {
            if (llllllllllllllIlIllllIlIIIIlllIl.worldServers[llllllllllllllIlIllllIlIIIIllIll] != null) {
                final WorldServer llllllllllllllIlIllllIlIIIIllIlI = llllllllllllllIlIllllIlIIIIlllIl.worldServers[llllllllllllllIlIllllIlIIIIllIll];
                if (llllllllllllllIlIllllIlIIIIllIlI.disableLevelSaving) {
                    llllllllllllllIlIllllIlIIIIllIlI.disableLevelSaving = false;
                    llllllllllllllIlIllllIlIIIIlllII = true;
                }
            }
        }
        if (llllllllllllllIlIllllIlIIIIlllII) {
            CommandBase.notifyOperators(llllllllllllllIlIllllIlIIIIllIII, this, "commands.save.enabled", new Object[0]);
            return;
        }
        throw new CommandException("commands.save-on.alreadyOn", new Object[0]);
    }
    
    static {
        __OBFID = "CL_00000873";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIllllIlIIIlIIlll) {
        return "commands.save-on.usage";
    }
}
