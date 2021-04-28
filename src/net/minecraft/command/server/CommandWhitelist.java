package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import com.mojang.authlib.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandWhitelist extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllllIIIIIlIlIlIIlIlI, final String[] llllllllllllllllIIIIIlIlIlIIlIIl) throws CommandException {
        if (llllllllllllllllIIIIIlIlIlIIlIIl.length < 1) {
            throw new WrongUsageException("commands.whitelist.usage", new Object[0]);
        }
        final MinecraftServer llllllllllllllllIIIIIlIlIlIIllll = MinecraftServer.getServer();
        if (llllllllllllllllIIIIIlIlIlIIlIIl[0].equals("on")) {
            llllllllllllllllIIIIIlIlIlIIllll.getConfigurationManager().setWhiteListEnabled(true);
            CommandBase.notifyOperators(llllllllllllllllIIIIIlIlIlIIlIlI, this, "commands.whitelist.enabled", new Object[0]);
        }
        else if (llllllllllllllllIIIIIlIlIlIIlIIl[0].equals("off")) {
            llllllllllllllllIIIIIlIlIlIIllll.getConfigurationManager().setWhiteListEnabled(false);
            CommandBase.notifyOperators(llllllllllllllllIIIIIlIlIlIIlIlI, this, "commands.whitelist.disabled", new Object[0]);
        }
        else if (llllllllllllllllIIIIIlIlIlIIlIIl[0].equals("list")) {
            llllllllllllllllIIIIIlIlIlIIlIlI.addChatMessage(new ChatComponentTranslation("commands.whitelist.list", new Object[] { llllllllllllllllIIIIIlIlIlIIllll.getConfigurationManager().getWhitelistedPlayerNames().length, llllllllllllllllIIIIIlIlIlIIllll.getConfigurationManager().getAvailablePlayerDat().length }));
            final String[] llllllllllllllllIIIIIlIlIlIIlllI = llllllllllllllllIIIIIlIlIlIIllll.getConfigurationManager().getWhitelistedPlayerNames();
            llllllllllllllllIIIIIlIlIlIIlIlI.addChatMessage(new ChatComponentText(CommandBase.joinNiceString(llllllllllllllllIIIIIlIlIlIIlllI)));
        }
        else if (llllllllllllllllIIIIIlIlIlIIlIIl[0].equals("add")) {
            if (llllllllllllllllIIIIIlIlIlIIlIIl.length < 2) {
                throw new WrongUsageException("commands.whitelist.add.usage", new Object[0]);
            }
            final GameProfile llllllllllllllllIIIIIlIlIlIIllIl = llllllllllllllllIIIIIlIlIlIIllll.getPlayerProfileCache().getGameProfileForUsername(llllllllllllllllIIIIIlIlIlIIlIIl[1]);
            if (llllllllllllllllIIIIIlIlIlIIllIl == null) {
                throw new CommandException("commands.whitelist.add.failed", new Object[] { llllllllllllllllIIIIIlIlIlIIlIIl[1] });
            }
            llllllllllllllllIIIIIlIlIlIIllll.getConfigurationManager().addWhitelistedPlayer(llllllllllllllllIIIIIlIlIlIIllIl);
            CommandBase.notifyOperators(llllllllllllllllIIIIIlIlIlIIlIlI, this, "commands.whitelist.add.success", llllllllllllllllIIIIIlIlIlIIlIIl[1]);
        }
        else if (llllllllllllllllIIIIIlIlIlIIlIIl[0].equals("remove")) {
            if (llllllllllllllllIIIIIlIlIlIIlIIl.length < 2) {
                throw new WrongUsageException("commands.whitelist.remove.usage", new Object[0]);
            }
            final GameProfile llllllllllllllllIIIIIlIlIlIIllII = llllllllllllllllIIIIIlIlIlIIllll.getConfigurationManager().getWhitelistedPlayers().func_152706_a(llllllllllllllllIIIIIlIlIlIIlIIl[1]);
            if (llllllllllllllllIIIIIlIlIlIIllII == null) {
                throw new CommandException("commands.whitelist.remove.failed", new Object[] { llllllllllllllllIIIIIlIlIlIIlIIl[1] });
            }
            llllllllllllllllIIIIIlIlIlIIllll.getConfigurationManager().removePlayerFromWhitelist(llllllllllllllllIIIIIlIlIlIIllII);
            CommandBase.notifyOperators(llllllllllllllllIIIIIlIlIlIIlIlI, this, "commands.whitelist.remove.success", llllllllllllllllIIIIIlIlIlIIlIIl[1]);
        }
        else if (llllllllllllllllIIIIIlIlIlIIlIIl[0].equals("reload")) {
            llllllllllllllllIIIIIlIlIlIIllll.getConfigurationManager().loadWhiteList();
            CommandBase.notifyOperators(llllllllllllllllIIIIIlIlIlIIlIlI, this, "commands.whitelist.reloaded", new Object[0]);
        }
    }
    
    @Override
    public String getCommandName() {
        return "whitelist";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIIIIIlIlIlIllIII) {
        return "commands.whitelist.usage";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllllIIIIIlIlIlIIIlII, final String[] llllllllllllllllIIIIIlIlIlIIIIIl, final BlockPos llllllllllllllllIIIIIlIlIlIIIIlI) {
        if (llllllllllllllllIIIIIlIlIlIIIIIl.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllIIIIIlIlIlIIIIIl, "on", "off", "list", "add", "remove", "reload");
        }
        if (llllllllllllllllIIIIIlIlIlIIIIIl.length == 2) {
            if (llllllllllllllllIIIIIlIlIlIIIIIl[0].equals("remove")) {
                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllIIIIIlIlIlIIIIIl, MinecraftServer.getServer().getConfigurationManager().getWhitelistedPlayerNames());
            }
            if (llllllllllllllllIIIIIlIlIlIIIIIl[0].equals("add")) {
                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllIIIIIlIlIlIIIIIl, MinecraftServer.getServer().getPlayerProfileCache().func_152654_a());
            }
        }
        return null;
    }
    
    static {
        __OBFID = "CL_00001186";
    }
}
