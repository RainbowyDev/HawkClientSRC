package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.server.management.*;
import net.minecraft.command.*;
import com.mojang.authlib.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandBanPlayer extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender llllllllllllllIllIlllIIlllllIIll, final String[] llllllllllllllIllIlllIIlllllIIlI) throws CommandException {
        if (llllllllllllllIllIlllIIlllllIIlI.length < 1 || llllllllllllllIllIlllIIlllllIIlI[0].length() <= 0) {
            throw new WrongUsageException("commands.ban.usage", new Object[0]);
        }
        final MinecraftServer llllllllllllllIllIlllIIllllllIIl = MinecraftServer.getServer();
        final GameProfile llllllllllllllIllIlllIIllllllIII = llllllllllllllIllIlllIIllllllIIl.getPlayerProfileCache().getGameProfileForUsername(llllllllllllllIllIlllIIlllllIIlI[0]);
        if (llllllllllllllIllIlllIIllllllIII == null) {
            throw new CommandException("commands.ban.failed", new Object[] { llllllllllllllIllIlllIIlllllIIlI[0] });
        }
        String llllllllllllllIllIlllIIlllllIlll = null;
        if (llllllllllllllIllIlllIIlllllIIlI.length >= 2) {
            llllllllllllllIllIlllIIlllllIlll = CommandBase.getChatComponentFromNthArg(llllllllllllllIllIlllIIlllllIIll, llllllllllllllIllIlllIIlllllIIlI, 1).getUnformattedText();
        }
        final UserListBansEntry llllllllllllllIllIlllIIlllllIllI = new UserListBansEntry(llllllllllllllIllIlllIIllllllIII, null, llllllllllllllIllIlllIIlllllIIll.getName(), null, llllllllllllllIllIlllIIlllllIlll);
        llllllllllllllIllIlllIIllllllIIl.getConfigurationManager().getBannedPlayers().addEntry(llllllllllllllIllIlllIIlllllIllI);
        final EntityPlayerMP llllllllllllllIllIlllIIlllllIlIl = llllllllllllllIllIlllIIllllllIIl.getConfigurationManager().getPlayerByUsername(llllllllllllllIllIlllIIlllllIIlI[0]);
        if (llllllllllllllIllIlllIIlllllIlIl != null) {
            llllllllllllllIllIlllIIlllllIlIl.playerNetServerHandler.kickPlayerFromServer("You are banned from this server.");
        }
        CommandBase.notifyOperators(llllllllllllllIllIlllIIlllllIIll, this, "commands.ban.success", llllllllllllllIllIlllIIlllllIIlI[0]);
    }
    
    static {
        __OBFID = "CL_00000165";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandName() {
        return "ban";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIllIlllIIllllIlIlI, final String[] llllllllllllllIllIlllIIllllIlIIl, final BlockPos llllllllllllllIllIlllIIllllIlIII) {
        return (llllllllllllllIllIlllIIllllIlIIl.length >= 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllIlllIIllllIlIIl, MinecraftServer.getServer().getAllUsernames()) : null;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final ICommandSender llllllllllllllIllIlllIlIIIIIIlIl) {
        return MinecraftServer.getServer().getConfigurationManager().getBannedPlayers().isLanServer() && super.canCommandSenderUseCommand(llllllllllllllIllIlllIlIIIIIIlIl);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIllIlllIlIIIIIlIll) {
        return "commands.ban.usage";
    }
}
