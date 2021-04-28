package net.minecraft.command.server;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.command.*;

public class CommandSetDefaultSpawnpoint extends CommandBase
{
    @Override
    public String getCommandName() {
        return "setworldspawn";
    }
    
    static {
        __OBFID = "CL_00000973";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIIIIllllIIlIlllIl, final String[] lllllllllllllllIIIIllllIIlIllIlI, final BlockPos lllllllllllllllIIIIllllIIlIllIll) {
        return (lllllllllllllllIIIIllllIIlIllIlI.length > 0 && lllllllllllllllIIIIllllIIlIllIlI.length <= 3) ? CommandBase.func_175771_a(lllllllllllllllIIIIllllIIlIllIlI, 0, lllllllllllllllIIIIllllIIlIllIll) : null;
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIIIIllllIIllIlIII, final String[] lllllllllllllllIIIIllllIIllIIlll) throws CommandException {
        BlockPos lllllllllllllllIIIIllllIIllIIlIl = null;
        if (lllllllllllllllIIIIllllIIllIIlll.length == 0) {
            final BlockPos lllllllllllllllIIIIllllIIllIIllI = CommandBase.getCommandSenderAsPlayer(lllllllllllllllIIIIllllIIllIlIII).getPosition();
        }
        else {
            if (lllllllllllllllIIIIllllIIllIIlll.length != 3 || lllllllllllllllIIIIllllIIllIlIII.getEntityWorld() == null) {
                throw new WrongUsageException("commands.setworldspawn.usage", new Object[0]);
            }
            lllllllllllllllIIIIllllIIllIIlIl = CommandBase.func_175757_a(lllllllllllllllIIIIllllIIllIlIII, lllllllllllllllIIIIllllIIllIIlll, 0, true);
        }
        lllllllllllllllIIIIllllIIllIlIII.getEntityWorld().setSpawnLocation(lllllllllllllllIIIIllllIIllIIlIl);
        MinecraftServer.getServer().getConfigurationManager().sendPacketToAllPlayers(new S05PacketSpawnPosition(lllllllllllllllIIIIllllIIllIIlIl));
        CommandBase.notifyOperators(lllllllllllllllIIIIllllIIllIlIII, this, "commands.setworldspawn.success", lllllllllllllllIIIIllllIIllIIlIl.getX(), lllllllllllllllIIIIllllIIllIIlIl.getY(), lllllllllllllllIIIIllllIIllIIlIl.getZ());
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIIIIllllIIllIlllI) {
        return "commands.setworldspawn.usage";
    }
}
