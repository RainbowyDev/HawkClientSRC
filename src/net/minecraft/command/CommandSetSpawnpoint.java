package net.minecraft.command;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;

public class CommandSetSpawnpoint extends CommandBase
{
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIllIlIllIIlIlIlII, final String[] lllllllllllllllIllIlIllIIlIlIIlI, final BlockPos lllllllllllllllIllIlIllIIlIlIIII) {
        return (lllllllllllllllIllIlIllIIlIlIIlI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIllIlIllIIlIlIIlI, MinecraftServer.getServer().getAllUsernames()) : ((lllllllllllllllIllIlIllIIlIlIIlI.length > 1 && lllllllllllllllIllIlIllIIlIlIIlI.length <= 4) ? CommandBase.func_175771_a(lllllllllllllllIllIlIllIIlIlIIlI, 1, lllllllllllllllIllIlIllIIlIlIIII) : null);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIllIlIllIIlllIllI) {
        return "commands.spawnpoint.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllIllIlIllIIlIIIlIl, final int lllllllllllllllIllIlIllIIlIIIIll) {
        return lllllllllllllllIllIlIllIIlIIIIll == 0;
    }
    
    @Override
    public String getCommandName() {
        return "spawnpoint";
    }
    
    static {
        __OBFID = "CL_00001026";
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIllIlIllIIllIllIl, final String[] lllllllllllllllIllIlIllIIllIIIll) throws CommandException {
        if (lllllllllllllllIllIlIllIIllIIIll.length > 0 && lllllllllllllllIllIlIllIIllIIIll.length < 4) {
            throw new WrongUsageException("commands.spawnpoint.usage", new Object[0]);
        }
        final EntityPlayerMP lllllllllllllllIllIlIllIIllIlIIl = (lllllllllllllllIllIlIllIIllIIIll.length > 0) ? CommandBase.getPlayer(lllllllllllllllIllIlIllIIllIllIl, lllllllllllllllIllIlIllIIllIIIll[0]) : CommandBase.getCommandSenderAsPlayer(lllllllllllllllIllIlIllIIllIllIl);
        final BlockPos lllllllllllllllIllIlIllIIllIIlll = (lllllllllllllllIllIlIllIIllIIIll.length > 3) ? CommandBase.func_175757_a(lllllllllllllllIllIlIllIIllIllIl, lllllllllllllllIllIlIllIIllIIIll, 1, true) : lllllllllllllllIllIlIllIIllIlIIl.getPosition();
        if (lllllllllllllllIllIlIllIIllIlIIl.worldObj != null) {
            lllllllllllllllIllIlIllIIllIlIIl.func_180473_a(lllllllllllllllIllIlIllIIllIIlll, true);
            CommandBase.notifyOperators(lllllllllllllllIllIlIllIIllIllIl, this, "commands.spawnpoint.success", lllllllllllllllIllIlIllIIllIlIIl.getName(), lllllllllllllllIllIlIllIIllIIlll.getX(), lllllllllllllllIllIlIllIIllIIlll.getY(), lllllllllllllllIllIlIllIIllIIlll.getZ());
        }
    }
}
