package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import com.mojang.authlib.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public class CommandOp extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIIlIIIlIIIllllIl, final String[] llllllllllllllIlIIlIIIlIIIllllII) throws CommandException {
        if (llllllllllllllIlIIlIIIlIIIllllII.length != 1 || llllllllllllllIlIIlIIIlIIIllllII[0].length() <= 0) {
            throw new WrongUsageException("commands.op.usage", new Object[0]);
        }
        final MinecraftServer llllllllllllllIlIIlIIIlIIIlllIll = MinecraftServer.getServer();
        final GameProfile llllllllllllllIlIIlIIIlIIIlllIlI = llllllllllllllIlIIlIIIlIIIlllIll.getPlayerProfileCache().getGameProfileForUsername(llllllllllllllIlIIlIIIlIIIllllII[0]);
        if (llllllllllllllIlIIlIIIlIIIlllIlI == null) {
            throw new CommandException("commands.op.failed", new Object[] { llllllllllllllIlIIlIIIlIIIllllII[0] });
        }
        llllllllllllllIlIIlIIIlIIIlllIll.getConfigurationManager().addOp(llllllllllllllIlIIlIIIlIIIlllIlI);
        CommandBase.notifyOperators(llllllllllllllIlIIlIIIlIIIllllIl, this, "commands.op.success", llllllllllllllIlIIlIIIlIIIllllII[0]);
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIlIIlIIIlIIIlIllII, final String[] llllllllllllllIlIIlIIIlIIIlIlIll, final BlockPos llllllllllllllIlIIlIIIlIIIlIlIlI) {
        if (llllllllllllllIlIIlIIIlIIIlIlIll.length == 1) {
            final String llllllllllllllIlIIlIIIlIIIlIlIIl = llllllllllllllIlIIlIIIlIIIlIlIll[llllllllllllllIlIIlIIIlIIIlIlIll.length - 1];
            final ArrayList llllllllllllllIlIIlIIIlIIIlIlIII = Lists.newArrayList();
            for (final GameProfile llllllllllllllIlIIlIIIlIIIlIIlII : MinecraftServer.getServer().getGameProfiles()) {
                if (!MinecraftServer.getServer().getConfigurationManager().canSendCommands(llllllllllllllIlIIlIIIlIIIlIIlII) && CommandBase.doesStringStartWith(llllllllllllllIlIIlIIIlIIIlIlIIl, llllllllllllllIlIIlIIIlIIIlIIlII.getName())) {
                    llllllllllllllIlIIlIIIlIIIlIlIII.add(llllllllllllllIlIIlIIIlIIIlIIlII.getName());
                }
            }
            return llllllllllllllIlIIlIIIlIIIlIlIII;
        }
        return null;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIIlIIIlIIlIIIlII) {
        return "commands.op.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandName() {
        return "op";
    }
    
    static {
        __OBFID = "CL_00000694";
    }
}
