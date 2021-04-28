package net.minecraft.command.server;

import java.util.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.command.*;

public class CommandListBans extends CommandBase
{
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIlIllllIllIIlIllll, final String[] llllllllllllllIlIllllIllIIlIlllI, final BlockPos llllllllllllllIlIllllIllIIlIllIl) {
        return (llllllllllllllIlIllllIllIIlIlllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIllllIllIIlIlllI, "players", "ips") : null;
    }
    
    static {
        __OBFID = "CL_00000596";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIllllIllIIllIIll, final String[] llllllllllllllIlIllllIllIIllIlII) throws CommandException {
        if (llllllllllllllIlIllllIllIIllIlII.length >= 1 && llllllllllllllIlIllllIllIIllIlII[0].equalsIgnoreCase("ips")) {
            llllllllllllllIlIllllIllIIllIIll.addChatMessage(new ChatComponentTranslation("commands.banlist.ips", new Object[] { MinecraftServer.getServer().getConfigurationManager().getBannedIPs().getKeys().length }));
            llllllllllllllIlIllllIllIIllIIll.addChatMessage(new ChatComponentText(CommandBase.joinNiceString(MinecraftServer.getServer().getConfigurationManager().getBannedIPs().getKeys())));
        }
        else {
            llllllllllllllIlIllllIllIIllIIll.addChatMessage(new ChatComponentTranslation("commands.banlist.players", new Object[] { MinecraftServer.getServer().getConfigurationManager().getBannedPlayers().getKeys().length }));
            llllllllllllllIlIllllIllIIllIIll.addChatMessage(new ChatComponentText(CommandBase.joinNiceString(MinecraftServer.getServer().getConfigurationManager().getBannedPlayers().getKeys())));
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIllllIllIIlllIIl) {
        return "commands.banlist.usage";
    }
    
    @Override
    public String getCommandName() {
        return "banlist";
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final ICommandSender llllllllllllllIlIllllIllIIllllIl) {
        return (MinecraftServer.getServer().getConfigurationManager().getBannedIPs().isLanServer() || MinecraftServer.getServer().getConfigurationManager().getBannedPlayers().isLanServer()) && super.canCommandSenderUseCommand(llllllllllllllIlIllllIllIIllllIl);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
}
