package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.command.*;

public class CommandSaveAll extends CommandBase
{
    @Override
    public String getCommandName() {
        return "save-all";
    }
    
    static {
        __OBFID = "CL_00000826";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIllIIlllIlIIIIlI, final String[] llllllllllllllIlIllIIlllIIllIlll) throws CommandException {
        final MinecraftServer llllllllllllllIlIllIIlllIlIIIIII = MinecraftServer.getServer();
        llllllllllllllIlIllIIlllIlIIIIlI.addChatMessage(new ChatComponentTranslation("commands.save.start", new Object[0]));
        if (llllllllllllllIlIllIIlllIlIIIIII.getConfigurationManager() != null) {
            llllllllllllllIlIllIIlllIlIIIIII.getConfigurationManager().saveAllPlayerData();
        }
        try {
            for (int llllllllllllllIlIllIIlllIIllllll = 0; llllllllllllllIlIllIIlllIIllllll < llllllllllllllIlIllIIlllIlIIIIII.worldServers.length; ++llllllllllllllIlIllIIlllIIllllll) {
                if (llllllllllllllIlIllIIlllIlIIIIII.worldServers[llllllllllllllIlIllIIlllIIllllll] != null) {
                    final WorldServer llllllllllllllIlIllIIlllIIlllllI = llllllllllllllIlIllIIlllIlIIIIII.worldServers[llllllllllllllIlIllIIlllIIllllll];
                    final boolean llllllllllllllIlIllIIlllIIllllII = llllllllllllllIlIllIIlllIIlllllI.disableLevelSaving;
                    llllllllllllllIlIllIIlllIIlllllI.disableLevelSaving = false;
                    llllllllllllllIlIllIIlllIIlllllI.saveAllChunks(true, null);
                    llllllllllllllIlIllIIlllIIlllllI.disableLevelSaving = llllllllllllllIlIllIIlllIIllllII;
                }
            }
            if (llllllllllllllIlIllIIlllIIllIlll.length > 0 && "flush".equals(llllllllllllllIlIllIIlllIIllIlll[0])) {
                llllllllllllllIlIllIIlllIlIIIIlI.addChatMessage(new ChatComponentTranslation("commands.save.flushStart", new Object[0]));
                for (int llllllllllllllIlIllIIlllIIllllll = 0; llllllllllllllIlIllIIlllIIllllll < llllllllllllllIlIllIIlllIlIIIIII.worldServers.length; ++llllllllllllllIlIllIIlllIIllllll) {
                    if (llllllllllllllIlIllIIlllIlIIIIII.worldServers[llllllllllllllIlIllIIlllIIllllll] != null) {
                        final WorldServer llllllllllllllIlIllIIlllIIllllIl = llllllllllllllIlIllIIlllIlIIIIII.worldServers[llllllllllllllIlIllIIlllIIllllll];
                        final boolean llllllllllllllIlIllIIlllIIlllIll = llllllllllllllIlIllIIlllIIllllIl.disableLevelSaving;
                        llllllllllllllIlIllIIlllIIllllIl.disableLevelSaving = false;
                        llllllllllllllIlIllIIlllIIllllIl.saveChunkData();
                        llllllllllllllIlIllIIlllIIllllIl.disableLevelSaving = llllllllllllllIlIllIIlllIIlllIll;
                    }
                }
                llllllllllllllIlIllIIlllIlIIIIlI.addChatMessage(new ChatComponentTranslation("commands.save.flushEnd", new Object[0]));
            }
        }
        catch (MinecraftException llllllllllllllIlIllIIlllIIlllIlI) {
            CommandBase.notifyOperators(llllllllllllllIlIllIIlllIlIIIIlI, this, "commands.save.failed", llllllllllllllIlIllIIlllIIlllIlI.getMessage());
            return;
        }
        CommandBase.notifyOperators(llllllllllllllIlIllIIlllIlIIIIlI, this, "commands.save.success", new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIllIIlllIlIIlIll) {
        return "commands.save.usage";
    }
}
