package net.minecraft.command;

import net.minecraft.util.*;
import net.minecraft.server.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.scoreboard.*;

public class CommandTrigger extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public String getCommandName() {
        return "trigger";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIIlIllIIllIlIllIll, final String[] llllllllllllllIIlIllIIllIlIlIlII, final BlockPos llllllllllllllIIlIllIIllIlIllIIl) {
        if (llllllllllllllIIlIllIIllIlIlIlII.length == 1) {
            final Scoreboard llllllllllllllIIlIllIIllIlIllIII = MinecraftServer.getServer().worldServerForDimension(0).getScoreboard();
            final ArrayList llllllllllllllIIlIllIIllIlIlIlll = Lists.newArrayList();
            for (final ScoreObjective llllllllllllllIIlIllIIllIlIlIlIl : llllllllllllllIIlIllIIllIlIllIII.getScoreObjectives()) {
                if (llllllllllllllIIlIllIIllIlIlIlIl.getCriteria() == IScoreObjectiveCriteria.field_178791_c) {
                    llllllllllllllIIlIllIIllIlIlIlll.add(llllllllllllllIIlIllIIllIlIlIlIl.getName());
                }
            }
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIllIIllIlIlIlII, (String[])llllllllllllllIIlIllIIllIlIlIlll.toArray(new String[llllllllllllllIIlIllIIllIlIlIlll.size()]));
        }
        return (llllllllllllllIIlIllIIllIlIlIlII.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIllIIllIlIlIlII, "add", "set") : null;
    }
    
    static {
        __OBFID = "CL_00002337";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIIlIllIIllIllIlIII, final String[] llllllllllllllIIlIllIIllIlllIIIl) throws CommandException {
        if (llllllllllllllIIlIllIIllIlllIIIl.length < 3) {
            throw new WrongUsageException("commands.trigger.usage", new Object[0]);
        }
        EntityPlayerMP llllllllllllllIIlIllIIllIllIllll = null;
        if (llllllllllllllIIlIllIIllIllIlIII instanceof EntityPlayerMP) {
            final EntityPlayerMP llllllllllllllIIlIllIIllIlllIIII = (EntityPlayerMP)llllllllllllllIIlIllIIllIllIlIII;
        }
        else {
            final Entity llllllllllllllIIlIllIIllIllIlllI = llllllllllllllIIlIllIIllIllIlIII.getCommandSenderEntity();
            if (!(llllllllllllllIIlIllIIllIllIlllI instanceof EntityPlayerMP)) {
                throw new CommandException("commands.trigger.invalidPlayer", new Object[0]);
            }
            llllllllllllllIIlIllIIllIllIllll = (EntityPlayerMP)llllllllllllllIIlIllIIllIllIlllI;
        }
        final Scoreboard llllllllllllllIIlIllIIllIllIllIl = MinecraftServer.getServer().worldServerForDimension(0).getScoreboard();
        final ScoreObjective llllllllllllllIIlIllIIllIllIllII = llllllllllllllIIlIllIIllIllIllIl.getObjective(llllllllllllllIIlIllIIllIlllIIIl[0]);
        if (llllllllllllllIIlIllIIllIllIllII == null || llllllllllllllIIlIllIIllIllIllII.getCriteria() != IScoreObjectiveCriteria.field_178791_c) {
            throw new CommandException("commands.trigger.invalidObjective", new Object[] { llllllllllllllIIlIllIIllIlllIIIl[0] });
        }
        final int llllllllllllllIIlIllIIllIllIlIll = CommandBase.parseInt(llllllllllllllIIlIllIIllIlllIIIl[2]);
        if (!llllllllllllllIIlIllIIllIllIllIl.func_178819_b(llllllllllllllIIlIllIIllIllIllll.getName(), llllllllllllllIIlIllIIllIllIllII)) {
            throw new CommandException("commands.trigger.invalidObjective", new Object[] { llllllllllllllIIlIllIIllIlllIIIl[0] });
        }
        final Score llllllllllllllIIlIllIIllIllIlIlI = llllllllllllllIIlIllIIllIllIllIl.getValueFromObjective(llllllllllllllIIlIllIIllIllIllll.getName(), llllllllllllllIIlIllIIllIllIllII);
        if (llllllllllllllIIlIllIIllIllIlIlI.func_178816_g()) {
            throw new CommandException("commands.trigger.disabled", new Object[] { llllllllllllllIIlIllIIllIlllIIIl[0] });
        }
        if ("set".equals(llllllllllllllIIlIllIIllIlllIIIl[1])) {
            llllllllllllllIIlIllIIllIllIlIlI.setScorePoints(llllllllllllllIIlIllIIllIllIlIll);
        }
        else {
            if (!"add".equals(llllllllllllllIIlIllIIllIlllIIIl[1])) {
                throw new CommandException("commands.trigger.invalidMode", new Object[] { llllllllllllllIIlIllIIllIlllIIIl[1] });
            }
            llllllllllllllIIlIllIIllIllIlIlI.increseScore(llllllllllllllIIlIllIIllIllIlIll);
        }
        llllllllllllllIIlIllIIllIllIlIlI.func_178815_a(true);
        if (llllllllllllllIIlIllIIllIllIllll.theItemInWorldManager.isCreative()) {
            CommandBase.notifyOperators(llllllllllllllIIlIllIIllIllIlIII, this, "commands.trigger.success", llllllllllllllIIlIllIIllIlllIIIl[0], llllllllllllllIIlIllIIllIlllIIIl[1], llllllllllllllIIlIllIIllIlllIIIl[2]);
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlIllIIllIlllllII) {
        return "commands.trigger.usage";
    }
}
