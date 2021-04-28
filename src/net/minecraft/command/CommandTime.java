package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.world.*;

public class CommandTime extends CommandBase
{
    protected void setTime(final ICommandSender llllllllllllllIIlIlIlllIIlIIIIIl, final int llllllllllllllIIlIlIlllIIlIIIIII) {
        for (int llllllllllllllIIlIlIlllIIIllllll = 0; llllllllllllllIIlIlIlllIIIllllll < MinecraftServer.getServer().worldServers.length; ++llllllllllllllIIlIlIlllIIIllllll) {
            MinecraftServer.getServer().worldServers[llllllllllllllIIlIlIlllIIIllllll].setWorldTime(llllllllllllllIIlIlIlllIIlIIIIII);
        }
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIIlIlIlllIIlIIlIII, final String[] llllllllllllllIIlIlIlllIIlIIIlIl, final BlockPos llllllllllllllIIlIlIlllIIlIIIllI) {
        return (llllllllllllllIIlIlIlllIIlIIIlIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIlIlllIIlIIIlIl, "set", "add", "query") : ((llllllllllllllIIlIlIlllIIlIIIlIl.length == 2 && llllllllllllllIIlIlIlllIIlIIIlIl[0].equals("set")) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIlIlllIIlIIIlIl, "day", "night") : ((llllllllllllllIIlIlIlllIIlIIIlIl.length == 2 && llllllllllllllIIlIlIlllIIlIIIlIl[0].equals("query")) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIlIlllIIlIIIlIl, "daytime", "gametime") : null));
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlIlIlllIIlIllllI) {
        return "commands.time.usage";
    }
    
    static {
        __OBFID = "CL_00001183";
    }
    
    protected void addTime(final ICommandSender llllllllllllllIIlIlIlllIIIlllIII, final int llllllllllllllIIlIlIlllIIIllIlll) {
        for (int llllllllllllllIIlIlIlllIIIllIllI = 0; llllllllllllllIIlIlIlllIIIllIllI < MinecraftServer.getServer().worldServers.length; ++llllllllllllllIIlIlIlllIIIllIllI) {
            final WorldServer llllllllllllllIIlIlIlllIIIllIlIl = MinecraftServer.getServer().worldServers[llllllllllllllIIlIlIlllIIIllIllI];
            llllllllllllllIIlIlIlllIIIllIlIl.setWorldTime(llllllllllllllIIlIlIlllIIIllIlIl.getWorldTime() + llllllllllllllIIlIlIlllIIIllIlll);
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "time";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIIlIlIlllIIlIIllIl, final String[] llllllllllllllIIlIlIlllIIlIlIlIl) throws CommandException {
        if (llllllllllllllIIlIlIlllIIlIlIlIl.length > 1) {
            if (llllllllllllllIIlIlIlllIIlIlIlIl[0].equals("set")) {
                int llllllllllllllIIlIlIlllIIlIlIIlI = 0;
                if (llllllllllllllIIlIlIlllIIlIlIlIl[1].equals("day")) {
                    final int llllllllllllllIIlIlIlllIIlIlIlII = 1000;
                }
                else if (llllllllllllllIIlIlIlllIIlIlIlIl[1].equals("night")) {
                    final int llllllllllllllIIlIlIlllIIlIlIIll = 13000;
                }
                else {
                    llllllllllllllIIlIlIlllIIlIlIIlI = CommandBase.parseInt(llllllllllllllIIlIlIlllIIlIlIlIl[1], 0);
                }
                this.setTime(llllllllllllllIIlIlIlllIIlIIllIl, llllllllllllllIIlIlIlllIIlIlIIlI);
                CommandBase.notifyOperators(llllllllllllllIIlIlIlllIIlIIllIl, this, "commands.time.set", llllllllllllllIIlIlIlllIIlIlIIlI);
                return;
            }
            if (llllllllllllllIIlIlIlllIIlIlIlIl[0].equals("add")) {
                final int llllllllllllllIIlIlIlllIIlIlIIIl = CommandBase.parseInt(llllllllllllllIIlIlIlllIIlIlIlIl[1], 0);
                this.addTime(llllllllllllllIIlIlIlllIIlIIllIl, llllllllllllllIIlIlIlllIIlIlIIIl);
                CommandBase.notifyOperators(llllllllllllllIIlIlIlllIIlIIllIl, this, "commands.time.added", llllllllllllllIIlIlIlllIIlIlIIIl);
                return;
            }
            if (llllllllllllllIIlIlIlllIIlIlIlIl[0].equals("query")) {
                if (llllllllllllllIIlIlIlllIIlIlIlIl[1].equals("daytime")) {
                    final int llllllllllllllIIlIlIlllIIlIlIIII = (int)(llllllllllllllIIlIlIlllIIlIIllIl.getEntityWorld().getWorldTime() % 2147483647L);
                    llllllllllllllIIlIlIlllIIlIIllIl.func_174794_a(CommandResultStats.Type.QUERY_RESULT, llllllllllllllIIlIlIlllIIlIlIIII);
                    CommandBase.notifyOperators(llllllllllllllIIlIlIlllIIlIIllIl, this, "commands.time.query", llllllllllllllIIlIlIlllIIlIlIIII);
                    return;
                }
                if (llllllllllllllIIlIlIlllIIlIlIlIl[1].equals("gametime")) {
                    final int llllllllllllllIIlIlIlllIIlIIllll = (int)(llllllllllllllIIlIlIlllIIlIIllIl.getEntityWorld().getTotalWorldTime() % 2147483647L);
                    llllllllllllllIIlIlIlllIIlIIllIl.func_174794_a(CommandResultStats.Type.QUERY_RESULT, llllllllllllllIIlIlIlllIIlIIllll);
                    CommandBase.notifyOperators(llllllllllllllIIlIlIlllIIlIIllIl, this, "commands.time.query", llllllllllllllIIlIlIlllIIlIIllll);
                    return;
                }
            }
        }
        throw new WrongUsageException("commands.time.usage", new Object[0]);
    }
}
