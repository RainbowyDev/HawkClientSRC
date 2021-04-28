package net.minecraft.command.server;

import net.minecraft.util.*;
import net.minecraft.server.*;
import java.util.*;
import net.minecraft.stats.*;
import net.minecraft.command.*;
import com.google.common.base.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;

public class CommandAchievement extends CommandBase
{
    static {
        __OBFID = "CL_00000113";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIlIlIlIIlIlIIlIIIl, final String[] llllllllllllllIlIlIlIIlIlIIlIIII, final BlockPos llllllllllllllIlIlIlIIlIlIIIllll) {
        if (llllllllllllllIlIlIlIIlIlIIlIIII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIlIlIIlIlIIlIIII, "give", "take");
        }
        if (llllllllllllllIlIlIlIIlIlIIlIIII.length != 2) {
            return (llllllllllllllIlIlIlIIlIlIIlIIII.length == 3) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIlIlIIlIlIIlIIII, MinecraftServer.getServer().getAllUsernames()) : null;
        }
        final ArrayList llllllllllllllIlIlIlIIlIlIIIlllI = Lists.newArrayList();
        for (final StatBase llllllllllllllIlIlIlIIlIlIIIllII : StatList.allStats) {
            llllllllllllllIlIlIlIIlIlIIIlllI.add(llllllllllllllIlIlIlIIlIlIIIllII.statId);
        }
        return CommandBase.func_175762_a(llllllllllllllIlIlIlIIlIlIIlIIII, llllllllllllllIlIlIlIIlIlIIIlllI);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIlIlIIlIlIllllll) {
        return "commands.achievement.usage";
    }
    
    @Override
    public String getCommandName() {
        return "achievement";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIlIlIlIIlIlIIIIlIl, final int llllllllllllllIlIlIlIIlIlIIIIlII) {
        return llllllllllllllIlIlIlIIlIlIIIIlII == 2;
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIlIlIIlIlIlIIIII, final String[] llllllllllllllIlIlIlIIlIlIllIIIl) throws CommandException {
        if (llllllllllllllIlIlIlIIlIlIllIIIl.length < 2) {
            throw new WrongUsageException("commands.achievement.usage", new Object[0]);
        }
        final StatBase llllllllllllllIlIlIlIIlIlIllIIII = StatList.getOneShotStat(llllllllllllllIlIlIlIIlIlIllIIIl[1]);
        if (llllllllllllllIlIlIlIIlIlIllIIII == null && !llllllllllllllIlIlIlIIlIlIllIIIl[1].equals("*")) {
            throw new CommandException("commands.achievement.unknownAchievement", new Object[] { llllllllllllllIlIlIlIIlIlIllIIIl[1] });
        }
        final EntityPlayerMP llllllllllllllIlIlIlIIlIlIlIllll = (llllllllllllllIlIlIlIIlIlIllIIIl.length >= 3) ? CommandBase.getPlayer(llllllllllllllIlIlIlIIlIlIlIIIII, llllllllllllllIlIlIlIIlIlIllIIIl[2]) : CommandBase.getCommandSenderAsPlayer(llllllllllllllIlIlIlIIlIlIlIIIII);
        final boolean llllllllllllllIlIlIlIIlIlIlIlllI = llllllllllllllIlIlIlIIlIlIllIIIl[0].equalsIgnoreCase("give");
        final boolean llllllllllllllIlIlIlIIlIlIlIllIl = llllllllllllllIlIlIlIIlIlIllIIIl[0].equalsIgnoreCase("take");
        if (llllllllllllllIlIlIlIIlIlIlIlllI || llllllllllllllIlIlIlIIlIlIlIllIl) {
            if (llllllllllllllIlIlIlIIlIlIllIIII == null) {
                if (llllllllllllllIlIlIlIIlIlIlIlllI) {
                    for (final Achievement llllllllllllllIlIlIlIIlIlIlIlIlI : AchievementList.achievementList) {
                        llllllllllllllIlIlIlIIlIlIlIllll.triggerAchievement(llllllllllllllIlIlIlIIlIlIlIlIlI);
                    }
                    CommandBase.notifyOperators(llllllllllllllIlIlIlIIlIlIlIIIII, this, "commands.achievement.give.success.all", llllllllllllllIlIlIlIIlIlIlIllll.getName());
                }
                else if (llllllllllllllIlIlIlIIlIlIlIllIl) {
                    for (final Achievement llllllllllllllIlIlIlIIlIlIlIlIIl : Lists.reverse(AchievementList.achievementList)) {
                        llllllllllllllIlIlIlIIlIlIlIllll.func_175145_a(llllllllllllllIlIlIlIIlIlIlIlIIl);
                    }
                    CommandBase.notifyOperators(llllllllllllllIlIlIlIIlIlIlIIIII, this, "commands.achievement.take.success.all", llllllllllllllIlIlIlIIlIlIlIllll.getName());
                }
            }
            else {
                if (llllllllllllllIlIlIlIIlIlIllIIII instanceof Achievement) {
                    Achievement llllllllllllllIlIlIlIIlIlIlIlIII = (Achievement)llllllllllllllIlIlIlIIlIlIllIIII;
                    if (llllllllllllllIlIlIlIIlIlIlIlllI) {
                        if (llllllllllllllIlIlIlIIlIlIlIllll.getStatFile().hasAchievementUnlocked(llllllllllllllIlIlIlIIlIlIlIlIII)) {
                            throw new CommandException("commands.achievement.alreadyHave", new Object[] { llllllllllllllIlIlIlIIlIlIlIllll.getName(), llllllllllllllIlIlIlIIlIlIllIIII.func_150955_j() });
                        }
                        final ArrayList llllllllllllllIlIlIlIIlIlIlIIlll = Lists.newArrayList();
                        while (llllllllllllllIlIlIlIIlIlIlIlIII.parentAchievement != null && !llllllllllllllIlIlIlIIlIlIlIllll.getStatFile().hasAchievementUnlocked(llllllllllllllIlIlIlIIlIlIlIlIII.parentAchievement)) {
                            llllllllllllllIlIlIlIIlIlIlIIlll.add(llllllllllllllIlIlIlIIlIlIlIlIII.parentAchievement);
                            llllllllllllllIlIlIlIIlIlIlIlIII = llllllllllllllIlIlIlIIlIlIlIlIII.parentAchievement;
                        }
                        for (final Achievement llllllllllllllIlIlIlIIlIlIlIIIll : Lists.reverse((List)llllllllllllllIlIlIlIIlIlIlIIlll)) {
                            llllllllllllllIlIlIlIIlIlIlIllll.triggerAchievement(llllllllllllllIlIlIlIIlIlIlIIIll);
                        }
                    }
                    else if (llllllllllllllIlIlIlIIlIlIlIllIl) {
                        if (!llllllllllllllIlIlIlIIlIlIlIllll.getStatFile().hasAchievementUnlocked(llllllllllllllIlIlIlIIlIlIlIlIII)) {
                            throw new CommandException("commands.achievement.dontHave", new Object[] { llllllllllllllIlIlIlIIlIlIlIllll.getName(), llllllllllllllIlIlIlIIlIlIllIIII.func_150955_j() });
                        }
                        final ArrayList llllllllllllllIlIlIlIIlIlIlIIllI = Lists.newArrayList((Iterator)Iterators.filter((Iterator)AchievementList.achievementList.iterator(), (Predicate)new Predicate() {
                            public boolean func_179605_a(final Achievement llllllllllllllllIlIlIIlIllIIllIl) {
                                return llllllllllllllIlIlIlIIlIlIlIllll.getStatFile().hasAchievementUnlocked(llllllllllllllllIlIlIIlIllIIllIl) && llllllllllllllllIlIlIIlIllIIllIl != llllllllllllllIlIlIlIIlIlIllIIII;
                            }
                            
                            static {
                                __OBFID = "CL_00002350";
                            }
                            
                            public boolean apply(final Object llllllllllllllllIlIlIIlIllIIIlll) {
                                return this.func_179605_a((Achievement)llllllllllllllllIlIlIIlIllIIIlll);
                            }
                        }));
                        while (llllllllllllllIlIlIlIIlIlIlIlIII.parentAchievement != null && llllllllllllllIlIlIlIIlIlIlIllll.getStatFile().hasAchievementUnlocked(llllllllllllllIlIlIlIIlIlIlIlIII.parentAchievement)) {
                            llllllllllllllIlIlIlIIlIlIlIIllI.remove(llllllllllllllIlIlIlIIlIlIlIlIII.parentAchievement);
                            llllllllllllllIlIlIlIIlIlIlIlIII = llllllllllllllIlIlIlIIlIlIlIlIII.parentAchievement;
                        }
                        for (final Achievement llllllllllllllIlIlIlIIlIlIlIIIlI : llllllllllllllIlIlIlIIlIlIlIIllI) {
                            llllllllllllllIlIlIlIIlIlIlIllll.func_175145_a(llllllllllllllIlIlIlIIlIlIlIIIlI);
                        }
                    }
                }
                if (llllllllllllllIlIlIlIIlIlIlIlllI) {
                    llllllllllllllIlIlIlIIlIlIlIllll.triggerAchievement(llllllllllllllIlIlIlIIlIlIllIIII);
                    CommandBase.notifyOperators(llllllllllllllIlIlIlIIlIlIlIIIII, this, "commands.achievement.give.success.one", llllllllllllllIlIlIlIIlIlIlIllll.getName(), llllllllllllllIlIlIlIIlIlIllIIII.func_150955_j());
                }
                else if (llllllllllllllIlIlIlIIlIlIlIllIl) {
                    llllllllllllllIlIlIlIIlIlIlIllll.func_175145_a(llllllllllllllIlIlIlIIlIlIllIIII);
                    CommandBase.notifyOperators(llllllllllllllIlIlIlIIlIlIlIIIII, this, "commands.achievement.take.success.one", llllllllllllllIlIlIlIIlIlIllIIII.func_150955_j(), llllllllllllllIlIlIlIIlIlIlIllll.getName());
                }
            }
        }
    }
}
