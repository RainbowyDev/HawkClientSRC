package net.minecraft.command;

import net.minecraft.entity.player.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandXP extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIlIIIllIlIIlllll, final String[] llllllllllllllIlIlIIIllIlIIlIllI) throws CommandException {
        if (llllllllllllllIlIlIIIllIlIIlIllI.length <= 0) {
            throw new WrongUsageException("commands.xp.usage", new Object[0]);
        }
        String llllllllllllllIlIlIIIllIlIIlllIl = llllllllllllllIlIlIIIllIlIIlIllI[0];
        final boolean llllllllllllllIlIlIIIllIlIIlllII = llllllllllllllIlIlIIIllIlIIlllIl.endsWith("l") || llllllllllllllIlIlIIIllIlIIlllIl.endsWith("L");
        if (llllllllllllllIlIlIIIllIlIIlllII && llllllllllllllIlIlIIIllIlIIlllIl.length() > 1) {
            llllllllllllllIlIlIIIllIlIIlllIl = llllllllllllllIlIlIIIllIlIIlllIl.substring(0, llllllllllllllIlIlIIIllIlIIlllIl.length() - 1);
        }
        int llllllllllllllIlIlIIIllIlIIllIll = CommandBase.parseInt(llllllllllllllIlIlIIIllIlIIlllIl);
        final boolean llllllllllllllIlIlIIIllIlIIllIlI = llllllllllllllIlIlIIIllIlIIllIll < 0;
        if (llllllllllllllIlIlIIIllIlIIllIlI) {
            llllllllllllllIlIlIIIllIlIIllIll *= -1;
        }
        final EntityPlayerMP llllllllllllllIlIlIIIllIlIIllIIl = (llllllllllllllIlIlIIIllIlIIlIllI.length > 1) ? CommandBase.getPlayer(llllllllllllllIlIlIIIllIlIIlllll, llllllllllllllIlIlIIIllIlIIlIllI[1]) : CommandBase.getCommandSenderAsPlayer(llllllllllllllIlIlIIIllIlIIlllll);
        if (llllllllllllllIlIlIIIllIlIIlllII) {
            llllllllllllllIlIlIIIllIlIIlllll.func_174794_a(CommandResultStats.Type.QUERY_RESULT, llllllllllllllIlIlIIIllIlIIllIIl.experienceLevel);
            if (llllllllllllllIlIlIIIllIlIIllIlI) {
                llllllllllllllIlIlIIIllIlIIllIIl.addExperienceLevel(-llllllllllllllIlIlIIIllIlIIllIll);
                CommandBase.notifyOperators(llllllllllllllIlIlIIIllIlIIlllll, this, "commands.xp.success.negative.levels", llllllllllllllIlIlIIIllIlIIllIll, llllllllllllllIlIlIIIllIlIIllIIl.getName());
            }
            else {
                llllllllllllllIlIlIIIllIlIIllIIl.addExperienceLevel(llllllllllllllIlIlIIIllIlIIllIll);
                CommandBase.notifyOperators(llllllllllllllIlIlIIIllIlIIlllll, this, "commands.xp.success.levels", llllllllllllllIlIlIIIllIlIIllIll, llllllllllllllIlIlIIIllIlIIllIIl.getName());
            }
        }
        else {
            llllllllllllllIlIlIIIllIlIIlllll.func_174794_a(CommandResultStats.Type.QUERY_RESULT, llllllllllllllIlIlIIIllIlIIllIIl.experienceTotal);
            if (llllllllllllllIlIlIIIllIlIIllIlI) {
                throw new CommandException("commands.xp.failure.widthdrawXp", new Object[0]);
            }
            llllllllllllllIlIlIIIllIlIIllIIl.addExperience(llllllllllllllIlIlIIIllIlIIllIll);
            CommandBase.notifyOperators(llllllllllllllIlIlIIIllIlIIlllll, this, "commands.xp.success", llllllllllllllIlIlIIIllIlIIllIll, llllllllllllllIlIlIIIllIlIIllIIl.getName());
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "xp";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIlIlIIIllIlIIIIlIl, final int llllllllllllllIlIlIIIllIlIIIIIll) {
        return llllllllllllllIlIlIIIllIlIIIIIll == 1;
    }
    
    protected String[] getAllUsernames() {
        return MinecraftServer.getServer().getAllUsernames();
    }
    
    static {
        __OBFID = "CL_00000398";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIlIIIllIlIlIlIIl) {
        return "commands.xp.usage";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIlIlIIIllIlIIIllIl, final String[] llllllllllllllIlIlIIIllIlIIIlIIl, final BlockPos llllllllllllllIlIlIIIllIlIIIlIll) {
        return (llllllllllllllIlIlIIIllIlIIIlIIl.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIlIIIllIlIIIlIIl, this.getAllUsernames()) : null;
    }
}
