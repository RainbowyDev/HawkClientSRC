package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.command.*;

public class CommandListPlayers extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllllllIlIllllllllll) {
        return "commands.players.usage";
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllllllIlIlllllllIll, final String[] lllllllllllllllllllIlIlllllllIlI) throws CommandException {
        final int lllllllllllllllllllIlIlllllllIIl = MinecraftServer.getServer().getCurrentPlayerCount();
        lllllllllllllllllllIlIlllllllIll.addChatMessage(new ChatComponentTranslation("commands.players.list", new Object[] { lllllllllllllllllllIlIlllllllIIl, MinecraftServer.getServer().getMaxPlayers() }));
        lllllllllllllllllllIlIlllllllIll.addChatMessage(new ChatComponentText(MinecraftServer.getServer().getConfigurationManager().func_180602_f()));
        lllllllllllllllllllIlIlllllllIll.func_174794_a(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllllllIlIlllllllIIl);
    }
    
    @Override
    public String getCommandName() {
        return "list";
    }
    
    static {
        __OBFID = "CL_00000615";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
