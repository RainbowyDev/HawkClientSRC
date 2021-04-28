package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.world.storage.*;

public class CommandToggleDownfall extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender lIIlIlIIllIll, final String[] lIIlIlIIllIlI) throws CommandException {
        this.toggleDownfall();
        CommandBase.notifyOperators(lIIlIlIIllIll, this, "commands.downfall.success", new Object[0]);
    }
    
    protected void toggleDownfall() {
        final WorldInfo lIIlIlIIlIlIl = MinecraftServer.getServer().worldServers[0].getWorldInfo();
        lIIlIlIIlIlIl.setRaining(!lIIlIlIIlIlIl.isRaining());
    }
    
    static {
        __OBFID = "CL_00001184";
    }
    
    @Override
    public String getCommandName() {
        return "toggledownfall";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lIIlIlIIlllll) {
        return "commands.downfall.usage";
    }
}
