package net.minecraft.command;

import net.minecraft.world.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;

public class CommandDefaultGameMode extends CommandGameMode
{
    protected void setGameType(final WorldSettings.GameType lIIlIIIlIllllI) {
        final MinecraftServer lIIlIIIlIlllIl = MinecraftServer.getServer();
        lIIlIIIlIlllIl.setGameType(lIIlIIIlIllllI);
        if (lIIlIIIlIlllIl.getForceGamemode()) {
            for (final EntityPlayerMP lIIlIIIlIlllII : MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
                lIIlIIIlIlllII.setGameType(lIIlIIIlIllllI);
                lIIlIIIlIlllII.fallDistance = 0.0f;
            }
        }
    }
    
    @Override
    public String getCommandName() {
        return "defaultgamemode";
    }
    
    @Override
    public void processCommand(final ICommandSender lIIlIIIllIlIlI, final String[] lIIlIIIllIlIIl) throws CommandException {
        if (lIIlIIIllIlIIl.length <= 0) {
            throw new WrongUsageException("commands.defaultgamemode.usage", new Object[0]);
        }
        final WorldSettings.GameType lIIlIIIllIlIII = this.getGameModeFromCommand(lIIlIIIllIlIlI, lIIlIIIllIlIIl[0]);
        this.setGameType(lIIlIIIllIlIII);
        CommandBase.notifyOperators(lIIlIIIllIlIlI, this, "commands.defaultgamemode.success", new ChatComponentTranslation(String.valueOf(new StringBuilder("gameMode.").append(lIIlIIIllIlIII.getName())), new Object[0]));
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lIIlIIIlllIIII) {
        return "commands.defaultgamemode.usage";
    }
    
    static {
        __OBFID = "CL_00000296";
    }
}
