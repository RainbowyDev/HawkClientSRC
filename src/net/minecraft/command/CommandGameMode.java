package net.minecraft.command;

import net.minecraft.world.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandGameMode extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllIIlIllllIllIllllI, final int lllllllllllllllIIlIllllIllIlllIl) {
        return lllllllllllllllIIlIllllIllIlllIl == 1;
    }
    
    protected WorldSettings.GameType getGameModeFromCommand(final ICommandSender lllllllllllllllIIlIllllIlllIllII, final String lllllllllllllllIIlIllllIlllIlIll) throws CommandException {
        return (!lllllllllllllllIIlIllllIlllIlIll.equalsIgnoreCase(WorldSettings.GameType.SURVIVAL.getName()) && !lllllllllllllllIIlIllllIlllIlIll.equalsIgnoreCase("s")) ? ((!lllllllllllllllIIlIllllIlllIlIll.equalsIgnoreCase(WorldSettings.GameType.CREATIVE.getName()) && !lllllllllllllllIIlIllllIlllIlIll.equalsIgnoreCase("c")) ? ((!lllllllllllllllIIlIllllIlllIlIll.equalsIgnoreCase(WorldSettings.GameType.ADVENTURE.getName()) && !lllllllllllllllIIlIllllIlllIlIll.equalsIgnoreCase("a")) ? ((!lllllllllllllllIIlIllllIlllIlIll.equalsIgnoreCase(WorldSettings.GameType.SPECTATOR.getName()) && !lllllllllllllllIIlIllllIlllIlIll.equalsIgnoreCase("sp")) ? WorldSettings.getGameTypeById(CommandBase.parseInt(lllllllllllllllIIlIllllIlllIlIll, 0, WorldSettings.GameType.values().length - 2)) : WorldSettings.GameType.SPECTATOR) : WorldSettings.GameType.ADVENTURE) : WorldSettings.GameType.CREATIVE) : WorldSettings.GameType.SURVIVAL;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    protected String[] getListOfPlayerUsernames() {
        return MinecraftServer.getServer().getAllUsernames();
    }
    
    @Override
    public String getCommandName() {
        return "gamemode";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIIlIlllllIIIIIIIl) {
        return "commands.gamemode.usage";
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIIlIllllIlllllIIl, final String[] lllllllllllllllIIlIllllIllllIIlI) throws CommandException {
        if (lllllllllllllllIIlIllllIllllIIlI.length <= 0) {
            throw new WrongUsageException("commands.gamemode.usage", new Object[0]);
        }
        final WorldSettings.GameType lllllllllllllllIIlIllllIllllIlll = this.getGameModeFromCommand(lllllllllllllllIIlIllllIlllllIIl, lllllllllllllllIIlIllllIllllIIlI[0]);
        final EntityPlayerMP lllllllllllllllIIlIllllIllllIllI = (lllllllllllllllIIlIllllIllllIIlI.length >= 2) ? CommandBase.getPlayer(lllllllllllllllIIlIllllIlllllIIl, lllllllllllllllIIlIllllIllllIIlI[1]) : CommandBase.getCommandSenderAsPlayer(lllllllllllllllIIlIllllIlllllIIl);
        lllllllllllllllIIlIllllIllllIllI.setGameType(lllllllllllllllIIlIllllIllllIlll);
        lllllllllllllllIIlIllllIllllIllI.fallDistance = 0.0f;
        if (lllllllllllllllIIlIllllIlllllIIl.getEntityWorld().getGameRules().getGameRuleBooleanValue("sendCommandFeedback")) {
            lllllllllllllllIIlIllllIllllIllI.addChatMessage(new ChatComponentTranslation("gameMode.changed", new Object[0]));
        }
        final ChatComponentTranslation lllllllllllllllIIlIllllIllllIlIl = new ChatComponentTranslation(String.valueOf(new StringBuilder("gameMode.").append(lllllllllllllllIIlIllllIllllIlll.getName())), new Object[0]);
        if (lllllllllllllllIIlIllllIllllIllI != lllllllllllllllIIlIllllIlllllIIl) {
            CommandBase.notifyOperators(lllllllllllllllIIlIllllIlllllIIl, this, 1, "commands.gamemode.success.other", lllllllllllllllIIlIllllIllllIllI.getName(), lllllllllllllllIIlIllllIllllIlIl);
        }
        else {
            CommandBase.notifyOperators(lllllllllllllllIIlIllllIlllllIIl, this, 1, "commands.gamemode.success.self", lllllllllllllllIIlIllllIllllIlIl);
        }
    }
    
    static {
        __OBFID = "CL_00000448";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIIlIllllIlllIIllI, final String[] lllllllllllllllIIlIllllIlllIIIlI, final BlockPos lllllllllllllllIIlIllllIlllIIlII) {
        return (lllllllllllllllIIlIllllIlllIIIlI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIlIllllIlllIIIlI, "survival", "creative", "adventure", "spectator") : ((lllllllllllllllIIlIllllIlllIIIlI.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIlIllllIlllIIIlI, this.getListOfPlayerUsernames()) : null);
    }
}
