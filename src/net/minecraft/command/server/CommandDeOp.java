package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import com.mojang.authlib.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandDeOp extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender llllllllllllllllllllIIlllllIIIlI, final String[] llllllllllllllllllllIIlllllIlIII) throws CommandException {
        if (llllllllllllllllllllIIlllllIlIII.length != 1 || llllllllllllllllllllIIlllllIlIII[0].length() <= 0) {
            throw new WrongUsageException("commands.deop.usage", new Object[0]);
        }
        final MinecraftServer llllllllllllllllllllIIlllllIIllI = MinecraftServer.getServer();
        final GameProfile llllllllllllllllllllIIlllllIIlIl = llllllllllllllllllllIIlllllIIllI.getConfigurationManager().getOppedPlayers().getGameProfileFromName(llllllllllllllllllllIIlllllIlIII[0]);
        if (llllllllllllllllllllIIlllllIIlIl == null) {
            throw new CommandException("commands.deop.failed", new Object[] { llllllllllllllllllllIIlllllIlIII[0] });
        }
        llllllllllllllllllllIIlllllIIllI.getConfigurationManager().removeOp(llllllllllllllllllllIIlllllIIlIl);
        CommandBase.notifyOperators(llllllllllllllllllllIIlllllIIIlI, this, "commands.deop.success", llllllllllllllllllllIIlllllIlIII[0]);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllllllIIlllllllIlI) {
        return "commands.deop.usage";
    }
    
    static {
        __OBFID = "CL_00000244";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllllllllIIllllIlllII, final String[] llllllllllllllllllllIIllllIlIlll, final BlockPos llllllllllllllllllllIIllllIllIIl) {
        return (llllllllllllllllllllIIllllIlIlll.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllllllIIllllIlIlll, MinecraftServer.getServer().getConfigurationManager().getOppedPlayerNames()) : null;
    }
    
    @Override
    public String getCommandName() {
        return "deop";
    }
}
