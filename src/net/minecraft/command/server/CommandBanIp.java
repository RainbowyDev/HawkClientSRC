package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.*;
import java.util.regex.*;
import net.minecraft.entity.player.*;
import net.minecraft.server.management.*;
import net.minecraft.command.*;
import java.util.*;

public class CommandBanIp extends CommandBase
{
    public static final /* synthetic */ Pattern field_147211_a;
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllllIlllIIIIlIlIllIl, final String[] llllllllllllllllIlllIIIIlIlIlIII, final BlockPos llllllllllllllllIlllIIIIlIlIlIIl) {
        return (llllllllllllllllIlllIIIIlIlIlIII.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllIlllIIIIlIlIlIII, MinecraftServer.getServer().getAllUsernames()) : null;
    }
    
    @Override
    public String getCommandName() {
        return "ban-ip";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllllIlllIIIIllIIIlII, final String[] llllllllllllllllIlllIIIIlIlllIlI) throws CommandException {
        if (llllllllllllllllIlllIIIIlIlllIlI.length >= 1 && llllllllllllllllIlllIIIIlIlllIlI[0].length() > 1) {
            final IChatComponent llllllllllllllllIlllIIIIllIIIIlI = (llllllllllllllllIlllIIIIlIlllIlI.length >= 2) ? CommandBase.getChatComponentFromNthArg(llllllllllllllllIlllIIIIllIIIlII, llllllllllllllllIlllIIIIlIlllIlI, 1) : null;
            final Matcher llllllllllllllllIlllIIIIllIIIIIl = CommandBanIp.field_147211_a.matcher(llllllllllllllllIlllIIIIlIlllIlI[0]);
            if (llllllllllllllllIlllIIIIllIIIIIl.matches()) {
                this.func_147210_a(llllllllllllllllIlllIIIIllIIIlII, llllllllllllllllIlllIIIIlIlllIlI[0], (llllllllllllllllIlllIIIIllIIIIlI == null) ? null : llllllllllllllllIlllIIIIllIIIIlI.getUnformattedText());
            }
            else {
                final EntityPlayerMP llllllllllllllllIlllIIIIllIIIIII = MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(llllllllllllllllIlllIIIIlIlllIlI[0]);
                if (llllllllllllllllIlllIIIIllIIIIII == null) {
                    throw new PlayerNotFoundException("commands.banip.invalid", new Object[0]);
                }
                this.func_147210_a(llllllllllllllllIlllIIIIllIIIlII, llllllllllllllllIlllIIIIllIIIIII.getPlayerIP(), (llllllllllllllllIlllIIIIllIIIIlI == null) ? null : llllllllllllllllIlllIIIIllIIIIlI.getUnformattedText());
            }
            return;
        }
        throw new WrongUsageException("commands.banip.usage", new Object[0]);
    }
    
    protected void func_147210_a(final ICommandSender llllllllllllllllIlllIIIIlIIIIllI, final String llllllllllllllllIlllIIIIlIIIIlII, final String llllllllllllllllIlllIIIIIlllIllI) {
        final IPBanEntry llllllllllllllllIlllIIIIlIIIIIlI = new IPBanEntry(llllllllllllllllIlllIIIIlIIIIlII, null, llllllllllllllllIlllIIIIlIIIIllI.getName(), null, llllllllllllllllIlllIIIIIlllIllI);
        MinecraftServer.getServer().getConfigurationManager().getBannedIPs().addEntry(llllllllllllllllIlllIIIIlIIIIIlI);
        final List llllllllllllllllIlllIIIIlIIIIIII = MinecraftServer.getServer().getConfigurationManager().getPlayersMatchingAddress(llllllllllllllllIlllIIIIlIIIIlII);
        final String[] llllllllllllllllIlllIIIIIllllllI = new String[llllllllllllllllIlllIIIIlIIIIIII.size()];
        int llllllllllllllllIlllIIIIIlllllIl = 0;
        for (final EntityPlayerMP llllllllllllllllIlllIIIIIlllllII : llllllllllllllllIlllIIIIlIIIIIII) {
            llllllllllllllllIlllIIIIIlllllII.playerNetServerHandler.kickPlayerFromServer("You have been IP banned.");
            llllllllllllllllIlllIIIIIllllllI[llllllllllllllllIlllIIIIIlllllIl++] = llllllllllllllllIlllIIIIIlllllII.getName();
        }
        if (llllllllllllllllIlllIIIIlIIIIIII.isEmpty()) {
            CommandBase.notifyOperators(llllllllllllllllIlllIIIIlIIIIllI, this, "commands.banip.success", llllllllllllllllIlllIIIIlIIIIlII);
        }
        else {
            CommandBase.notifyOperators(llllllllllllllllIlllIIIIlIIIIllI, this, "commands.banip.success.players", llllllllllllllllIlllIIIIlIIIIlII, CommandBase.joinNiceString(llllllllllllllllIlllIIIIIllllllI));
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final ICommandSender llllllllllllllllIlllIIIIlllIIlIl) {
        return MinecraftServer.getServer().getConfigurationManager().getBannedIPs().isLanServer() && super.canCommandSenderUseCommand(llllllllllllllllIlllIIIIlllIIlIl);
    }
    
    static {
        __OBFID = "CL_00000139";
        field_147211_a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIlllIIIIllIllIll) {
        return "commands.banip.usage";
    }
}
