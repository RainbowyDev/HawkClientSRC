package net.minecraft.command;

import net.minecraft.server.*;

public class CommandSetPlayerTimeout extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandName() {
        return "setidletimeout";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIlIIllIIllIIIIlI, final String[] llllllllllllllIlIlIIllIIllIIIIIl) throws CommandException {
        if (llllllllllllllIlIlIIllIIllIIIIIl.length != 1) {
            throw new WrongUsageException("commands.setidletimeout.usage", new Object[0]);
        }
        final int llllllllllllllIlIlIIllIIllIIIIII = CommandBase.parseInt(llllllllllllllIlIlIIllIIllIIIIIl[0], 0);
        MinecraftServer.getServer().setPlayerIdleTimeout(llllllllllllllIlIlIIllIIllIIIIII);
        CommandBase.notifyOperators(llllllllllllllIlIlIIllIIllIIIIlI, this, "commands.setidletimeout.success", llllllllllllllIlIlIIllIIllIIIIII);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIlIIllIIllIIlIII) {
        return "commands.setidletimeout.usage";
    }
    
    static {
        __OBFID = "CL_00000999";
    }
}
