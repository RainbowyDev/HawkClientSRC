package net.minecraft.command.server;

import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.command.*;
import net.minecraft.scoreboard.*;
import net.minecraft.util.*;
import net.minecraft.server.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class CommandScoreboard extends CommandBase
{
    @Override
    public String getCommandName() {
        return "scoreboard";
    }
    
    protected void setPlayer(final ICommandSender lllllllllllllllIlIllllIlIIlIIlIl, final String[] lllllllllllllllIlIllllIlIIIlIlIl, int lllllllllllllllIlIllllIlIIIlIlII) throws CommandException {
        final String lllllllllllllllIlIllllIlIIlIIIlI = lllllllllllllllIlIllllIlIIIlIlIl[lllllllllllllllIlIllllIlIIIlIlII - 1];
        final int lllllllllllllllIlIllllIlIIlIIIIl = lllllllllllllllIlIllllIlIIIlIlII;
        final String lllllllllllllllIlIllllIlIIlIIIII = CommandBase.func_175758_e(lllllllllllllllIlIllllIlIIlIIlIl, lllllllllllllllIlIllllIlIIIlIlIl[lllllllllllllllIlIllllIlIIIlIlII++]);
        final ScoreObjective lllllllllllllllIlIllllIlIIIlllll = this.func_147189_a(lllllllllllllllIlIllllIlIIIlIlIl[lllllllllllllllIlIllllIlIIIlIlII++], true);
        final int lllllllllllllllIlIllllIlIIIllllI = lllllllllllllllIlIllllIlIIlIIIlI.equalsIgnoreCase("set") ? CommandBase.parseInt(lllllllllllllllIlIllllIlIIIlIlIl[lllllllllllllllIlIllllIlIIIlIlII++]) : CommandBase.parseInt(lllllllllllllllIlIllllIlIIIlIlIl[lllllllllllllllIlIllllIlIIIlIlII++], 0);
        if (lllllllllllllllIlIllllIlIIIlIlIl.length > lllllllllllllllIlIllllIlIIIlIlII) {
            final Entity lllllllllllllllIlIllllIlIIIlllIl = CommandBase.func_175768_b(lllllllllllllllIlIllllIlIIlIIlIl, lllllllllllllllIlIllllIlIIIlIlIl[lllllllllllllllIlIllllIlIIlIIIIl]);
            try {
                final NBTTagCompound lllllllllllllllIlIllllIlIIIlllII = JsonToNBT.func_180713_a(CommandBase.func_180529_a(lllllllllllllllIlIllllIlIIIlIlIl, lllllllllllllllIlIllllIlIIIlIlII));
                final NBTTagCompound lllllllllllllllIlIllllIlIIIllIll = new NBTTagCompound();
                lllllllllllllllIlIllllIlIIIlllIl.writeToNBT(lllllllllllllllIlIllllIlIIIllIll);
                if (!CommandTestForBlock.func_175775_a(lllllllllllllllIlIllllIlIIIlllII, lllllllllllllllIlIllllIlIIIllIll, true)) {
                    throw new CommandException("commands.scoreboard.players.set.tagMismatch", new Object[] { lllllllllllllllIlIllllIlIIlIIIII });
                }
            }
            catch (NBTException lllllllllllllllIlIllllIlIIIllIlI) {
                throw new CommandException("commands.scoreboard.players.set.tagError", new Object[] { lllllllllllllllIlIllllIlIIIllIlI.getMessage() });
            }
        }
        final Scoreboard lllllllllllllllIlIllllIlIIIllIIl = this.getScoreboard();
        final Score lllllllllllllllIlIllllIlIIIllIII = lllllllllllllllIlIllllIlIIIllIIl.getValueFromObjective(lllllllllllllllIlIllllIlIIlIIIII, lllllllllllllllIlIllllIlIIIlllll);
        if (lllllllllllllllIlIllllIlIIlIIIlI.equalsIgnoreCase("set")) {
            lllllllllllllllIlIllllIlIIIllIII.setScorePoints(lllllllllllllllIlIllllIlIIIllllI);
        }
        else if (lllllllllllllllIlIllllIlIIlIIIlI.equalsIgnoreCase("add")) {
            lllllllllllllllIlIllllIlIIIllIII.increseScore(lllllllllllllllIlIllllIlIIIllllI);
        }
        else {
            lllllllllllllllIlIllllIlIIIllIII.decreaseScore(lllllllllllllllIlIllllIlIIIllllI);
        }
        CommandBase.notifyOperators(lllllllllllllllIlIllllIlIIlIIlIl, this, "commands.scoreboard.players.set.success", lllllllllllllllIlIllllIlIIIlllll.getName(), lllllllllllllllIlIllllIlIIlIIIII, lllllllllllllllIlIllllIlIIIllIII.getScorePoints());
    }
    
    protected void addTeam(final ICommandSender lllllllllllllllIlIlllllIIlIIllll, final String[] lllllllllllllllIlIlllllIIlIIlllI, int lllllllllllllllIlIlllllIIlIIIllI) throws CommandException {
        final String lllllllllllllllIlIlllllIIlIIllII = lllllllllllllllIlIlllllIIlIIlllI[lllllllllllllllIlIlllllIIlIIIllI++];
        final Scoreboard lllllllllllllllIlIlllllIIlIIlIll = this.getScoreboard();
        if (lllllllllllllllIlIlllllIIlIIlIll.getTeam(lllllllllllllllIlIlllllIIlIIllII) != null) {
            throw new CommandException("commands.scoreboard.teams.add.alreadyExists", new Object[] { lllllllllllllllIlIlllllIIlIIllII });
        }
        if (lllllllllllllllIlIlllllIIlIIllII.length() > 16) {
            throw new SyntaxErrorException("commands.scoreboard.teams.add.tooLong", new Object[] { lllllllllllllllIlIlllllIIlIIllII, 16 });
        }
        if (lllllllllllllllIlIlllllIIlIIllII.length() == 0) {
            throw new WrongUsageException("commands.scoreboard.teams.add.usage", new Object[0]);
        }
        if (lllllllllllllllIlIlllllIIlIIlllI.length > lllllllllllllllIlIlllllIIlIIIllI) {
            final String lllllllllllllllIlIlllllIIlIIlIlI = CommandBase.getChatComponentFromNthArg(lllllllllllllllIlIlllllIIlIIllll, lllllllllllllllIlIlllllIIlIIlllI, lllllllllllllllIlIlllllIIlIIIllI).getUnformattedText();
            if (lllllllllllllllIlIlllllIIlIIlIlI.length() > 32) {
                throw new SyntaxErrorException("commands.scoreboard.teams.add.displayTooLong", new Object[] { lllllllllllllllIlIlllllIIlIIlIlI, 32 });
            }
            if (lllllllllllllllIlIlllllIIlIIlIlI.length() > 0) {
                lllllllllllllllIlIlllllIIlIIlIll.createTeam(lllllllllllllllIlIlllllIIlIIllII).setTeamName(lllllllllllllllIlIlllllIIlIIlIlI);
            }
            else {
                lllllllllllllllIlIlllllIIlIIlIll.createTeam(lllllllllllllllIlIlllllIIlIIllII);
            }
        }
        else {
            lllllllllllllllIlIlllllIIlIIlIll.createTeam(lllllllllllllllIlIlllllIIlIIllII);
        }
        CommandBase.notifyOperators(lllllllllllllllIlIlllllIIlIIllll, this, "commands.scoreboard.teams.add.success", lllllllllllllllIlIlllllIIlIIllII);
    }
    
    protected void func_175779_n(final ICommandSender lllllllllllllllIlIllllIIlllIllIl, final String[] lllllllllllllllIlIllllIIlllIIlII, int lllllllllllllllIlIllllIIlllIIIll) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIIlllIlIlI = this.getScoreboard();
        final String lllllllllllllllIlIllllIIlllIlIIl = CommandBase.getPlayerName(lllllllllllllllIlIllllIIlllIllIl, lllllllllllllllIlIllllIIlllIIlII[lllllllllllllllIlIllllIIlllIIIll++]);
        final ScoreObjective lllllllllllllllIlIllllIIlllIlIII = this.func_147189_a(lllllllllllllllIlIllllIIlllIIlII[lllllllllllllllIlIllllIIlllIIIll], false);
        if (lllllllllllllllIlIllllIIlllIlIII.getCriteria() != IScoreObjectiveCriteria.field_178791_c) {
            throw new CommandException("commands.scoreboard.players.enable.noTrigger", new Object[] { lllllllllllllllIlIllllIIlllIlIII.getName() });
        }
        final Score lllllllllllllllIlIllllIIlllIIlll = lllllllllllllllIlIllllIIlllIlIlI.getValueFromObjective(lllllllllllllllIlIllllIIlllIlIIl, lllllllllllllllIlIllllIIlllIlIII);
        lllllllllllllllIlIllllIIlllIIlll.func_178815_a(false);
        CommandBase.notifyOperators(lllllllllllllllIlIllllIIlllIllIl, this, "commands.scoreboard.players.enable.success", lllllllllllllllIlIllllIIlllIlIII.getName(), lllllllllllllllIlIllllIIlllIlIIl);
    }
    
    protected void emptyTeam(final ICommandSender lllllllllllllllIlIllllIllIIlllll, final String[] lllllllllllllllIlIllllIllIIlIlIl, final int lllllllllllllllIlIllllIllIIlllIl) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIllIIlllII = this.getScoreboard();
        final ScorePlayerTeam lllllllllllllllIlIllllIllIIllIll = this.func_147183_a(lllllllllllllllIlIllllIllIIlIlIl[lllllllllllllllIlIllllIllIIlllIl]);
        if (lllllllllllllllIlIllllIllIIllIll != null) {
            final ArrayList lllllllllllllllIlIllllIllIIllIlI = Lists.newArrayList((Iterable)lllllllllllllllIlIllllIllIIllIll.getMembershipCollection());
            lllllllllllllllIlIllllIllIIlllll.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllllIlIllllIllIIllIlI.size());
            if (lllllllllllllllIlIllllIllIIllIlI.isEmpty()) {
                throw new CommandException("commands.scoreboard.teams.empty.alreadyEmpty", new Object[] { lllllllllllllllIlIllllIllIIllIll.getRegisteredName() });
            }
            for (final String lllllllllllllllIlIllllIllIIllIII : lllllllllllllllIlIllllIllIIllIlI) {
                lllllllllllllllIlIllllIllIIlllII.removePlayerFromTeam(lllllllllllllllIlIllllIllIIllIII, lllllllllllllllIlIllllIllIIllIll);
            }
            CommandBase.notifyOperators(lllllllllllllllIlIllllIllIIlllll, this, "commands.scoreboard.teams.empty.success", lllllllllllllllIlIllllIllIIllIlI.size(), lllllllllllllllIlIllllIllIIllIll.getRegisteredName());
        }
    }
    
    protected void setObjectiveDisplay(final ICommandSender lllllllllllllllIlIllllIlIlIllIIl, final String[] lllllllllllllllIlIllllIlIlIllIII, int lllllllllllllllIlIllllIlIlIlIlll) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIlIlIllllI = this.getScoreboard();
        final String lllllllllllllllIlIllllIlIlIlllIl = lllllllllllllllIlIllllIlIlIllIII[lllllllllllllllIlIllllIlIlIlIlll++];
        final int lllllllllllllllIlIllllIlIlIlllII = Scoreboard.getObjectiveDisplaySlotNumber(lllllllllllllllIlIllllIlIlIlllIl);
        ScoreObjective lllllllllllllllIlIllllIlIlIllIll = null;
        if (lllllllllllllllIlIllllIlIlIllIII.length == 4) {
            lllllllllllllllIlIllllIlIlIllIll = this.func_147189_a(lllllllllllllllIlIllllIlIlIllIII[lllllllllllllllIlIllllIlIlIlIlll], false);
        }
        if (lllllllllllllllIlIllllIlIlIlllII < 0) {
            throw new CommandException("commands.scoreboard.objectives.setdisplay.invalidSlot", new Object[] { lllllllllllllllIlIllllIlIlIlllIl });
        }
        lllllllllllllllIlIllllIlIlIllllI.setObjectiveInDisplaySlot(lllllllllllllllIlIllllIlIlIlllII, lllllllllllllllIlIllllIlIlIllIll);
        if (lllllllllllllllIlIllllIlIlIllIll != null) {
            CommandBase.notifyOperators(lllllllllllllllIlIllllIlIlIllIIl, this, "commands.scoreboard.objectives.setdisplay.successSet", Scoreboard.getObjectiveDisplaySlot(lllllllllllllllIlIllllIlIlIlllII), lllllllllllllllIlIllllIlIlIllIll.getName());
        }
        else {
            CommandBase.notifyOperators(lllllllllllllllIlIllllIlIlIllIIl, this, "commands.scoreboard.objectives.setdisplay.successCleared", Scoreboard.getObjectiveDisplaySlot(lllllllllllllllIlIllllIlIlIlllII));
        }
    }
    
    private boolean func_175780_b(final ICommandSender lllllllllllllllIlIlllllIlIIllIII, final String[] lllllllllllllllIlIlllllIlIIlIlll) throws CommandException {
        int lllllllllllllllIlIlllllIlIlIIIlI = -1;
        for (int lllllllllllllllIlIlllllIlIlIIIIl = 0; lllllllllllllllIlIlllllIlIlIIIIl < lllllllllllllllIlIlllllIlIIlIlll.length; ++lllllllllllllllIlIlllllIlIlIIIIl) {
            if (this.isUsernameIndex(lllllllllllllllIlIlllllIlIIlIlll, lllllllllllllllIlIlllllIlIlIIIIl) && "*".equals(lllllllllllllllIlIlllllIlIIlIlll[lllllllllllllllIlIlllllIlIlIIIIl])) {
                if (lllllllllllllllIlIlllllIlIlIIIlI >= 0) {
                    throw new CommandException("commands.scoreboard.noMultiWildcard", new Object[0]);
                }
                lllllllllllllllIlIlllllIlIlIIIlI = lllllllllllllllIlIlllllIlIlIIIIl;
            }
        }
        if (lllllllllllllllIlIlllllIlIlIIIlI < 0) {
            return false;
        }
        final ArrayList lllllllllllllllIlIlllllIlIlIIIII = Lists.newArrayList((Iterable)this.getScoreboard().getObjectiveNames());
        final String lllllllllllllllIlIlllllIlIIlllll = lllllllllllllllIlIlllllIlIIlIlll[lllllllllllllllIlIlllllIlIlIIIlI];
        final ArrayList lllllllllllllllIlIlllllIlIIllllI = Lists.newArrayList();
        for (final String lllllllllllllllIlIlllllIlIIlllII : lllllllllllllllIlIlllllIlIlIIIII) {
            lllllllllllllllIlIlllllIlIIlIlll[lllllllllllllllIlIlllllIlIlIIIlI] = lllllllllllllllIlIlllllIlIIlllII;
            try {
                this.processCommand(lllllllllllllllIlIlllllIlIIllIII, lllllllllllllllIlIlllllIlIIlIlll);
                lllllllllllllllIlIlllllIlIIllllI.add(lllllllllllllllIlIlllllIlIIlllII);
            }
            catch (CommandException lllllllllllllllIlIlllllIlIIllIll) {
                final ChatComponentTranslation lllllllllllllllIlIlllllIlIIllIlI = new ChatComponentTranslation(lllllllllllllllIlIlllllIlIIllIll.getMessage(), lllllllllllllllIlIlllllIlIIllIll.getErrorOjbects());
                lllllllllllllllIlIlllllIlIIllIlI.getChatStyle().setColor(EnumChatFormatting.RED);
                lllllllllllllllIlIlllllIlIIllIII.addChatMessage(lllllllllllllllIlIlllllIlIIllIlI);
            }
        }
        lllllllllllllllIlIlllllIlIIlIlll[lllllllllllllllIlIlllllIlIlIIIlI] = lllllllllllllllIlIlllllIlIIlllll;
        lllllllllllllllIlIlllllIlIIllIII.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllllIlIlllllIlIIllllI.size());
        if (lllllllllllllllIlIlllllIlIIllllI.size() == 0) {
            throw new WrongUsageException("commands.scoreboard.allMatchesFailed", new Object[0]);
        }
        return true;
    }
    
    protected void setTeamOption(final ICommandSender lllllllllllllllIlIlllllIIIlIllll, final String[] lllllllllllllllIlIlllllIIIlllIII, int lllllllllllllllIlIlllllIIIlIllIl) throws CommandException {
        final ScorePlayerTeam lllllllllllllllIlIlllllIIIllIllI = this.func_147183_a(lllllllllllllllIlIlllllIIIlllIII[lllllllllllllllIlIlllllIIIlIllIl++]);
        if (lllllllllllllllIlIlllllIIIllIllI != null) {
            final String lllllllllllllllIlIlllllIIIllIlIl = lllllllllllllllIlIlllllIIIlllIII[lllllllllllllllIlIlllllIIIlIllIl++].toLowerCase();
            if (!lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("color") && !lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("friendlyfire") && !lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("seeFriendlyInvisibles") && !lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("nametagVisibility") && !lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("deathMessageVisibility")) {
                throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
            }
            if (lllllllllllllllIlIlllllIIIlllIII.length == 4) {
                if (lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("color")) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllIlIlllllIIIllIlIl, CommandBase.joinNiceStringFromCollection(EnumChatFormatting.getValidValues(true, false)) });
                }
                if (lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("friendlyfire") || lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("seeFriendlyInvisibles")) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllIlIlllllIIIllIlIl, CommandBase.joinNiceStringFromCollection(Arrays.asList("true", "false")) });
                }
                if (!lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("nametagVisibility") && !lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("deathMessageVisibility")) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
                }
                throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllIlIlllllIIIllIlIl, CommandBase.joinNiceString(Team.EnumVisible.func_178825_a()) });
            }
            else {
                final String lllllllllllllllIlIlllllIIIllIlII = lllllllllllllllIlIlllllIIIlllIII[lllllllllllllllIlIlllllIIIlIllIl];
                if (lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("color")) {
                    final EnumChatFormatting lllllllllllllllIlIlllllIIIllIIll = EnumChatFormatting.getValueByName(lllllllllllllllIlIlllllIIIllIlII);
                    if (lllllllllllllllIlIlllllIIIllIIll == null || lllllllllllllllIlIlllllIIIllIIll.isFancyStyling()) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllIlIlllllIIIllIlIl, CommandBase.joinNiceStringFromCollection(EnumChatFormatting.getValidValues(true, false)) });
                    }
                    lllllllllllllllIlIlllllIIIllIllI.func_178774_a(lllllllllllllllIlIlllllIIIllIIll);
                    lllllllllllllllIlIlllllIIIllIllI.setNamePrefix(lllllllllllllllIlIlllllIIIllIIll.toString());
                    lllllllllllllllIlIlllllIIIllIllI.setNameSuffix(EnumChatFormatting.RESET.toString());
                }
                else if (lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("friendlyfire")) {
                    if (!lllllllllllllllIlIlllllIIIllIlII.equalsIgnoreCase("true") && !lllllllllllllllIlIlllllIIIllIlII.equalsIgnoreCase("false")) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllIlIlllllIIIllIlIl, CommandBase.joinNiceStringFromCollection(Arrays.asList("true", "false")) });
                    }
                    lllllllllllllllIlIlllllIIIllIllI.setAllowFriendlyFire(lllllllllllllllIlIlllllIIIllIlII.equalsIgnoreCase("true"));
                }
                else if (lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("seeFriendlyInvisibles")) {
                    if (!lllllllllllllllIlIlllllIIIllIlII.equalsIgnoreCase("true") && !lllllllllllllllIlIlllllIIIllIlII.equalsIgnoreCase("false")) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllIlIlllllIIIllIlIl, CommandBase.joinNiceStringFromCollection(Arrays.asList("true", "false")) });
                    }
                    lllllllllllllllIlIlllllIIIllIllI.setSeeFriendlyInvisiblesEnabled(lllllllllllllllIlIlllllIIIllIlII.equalsIgnoreCase("true"));
                }
                else if (lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("nametagVisibility")) {
                    final Team.EnumVisible lllllllllllllllIlIlllllIIIllIIlI = Team.EnumVisible.func_178824_a(lllllllllllllllIlIlllllIIIllIlII);
                    if (lllllllllllllllIlIlllllIIIllIIlI == null) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllIlIlllllIIIllIlIl, CommandBase.joinNiceString(Team.EnumVisible.func_178825_a()) });
                    }
                    lllllllllllllllIlIlllllIIIllIllI.func_178772_a(lllllllllllllllIlIlllllIIIllIIlI);
                }
                else if (lllllllllllllllIlIlllllIIIllIlIl.equalsIgnoreCase("deathMessageVisibility")) {
                    final Team.EnumVisible lllllllllllllllIlIlllllIIIllIIIl = Team.EnumVisible.func_178824_a(lllllllllllllllIlIlllllIIIllIlII);
                    if (lllllllllllllllIlIlllllIIIllIIIl == null) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { lllllllllllllllIlIlllllIIIllIlIl, CommandBase.joinNiceString(Team.EnumVisible.func_178825_a()) });
                    }
                    lllllllllllllllIlIlllllIIIllIllI.func_178773_b(lllllllllllllllIlIlllllIIIllIIIl);
                }
                CommandBase.notifyOperators(lllllllllllllllIlIlllllIIIlIllll, this, "commands.scoreboard.teams.option.success", lllllllllllllllIlIlllllIIIllIlIl, lllllllllllllllIlIlllllIIIllIllI.getRegisteredName(), lllllllllllllllIlIlllllIIIllIlII);
            }
        }
    }
    
    protected void listTeams(final ICommandSender lllllllllllllllIlIlllllIIIIIllII, final String[] lllllllllllllllIlIllllIlllllllll, final int lllllllllllllllIlIllllIllllllllI) throws CommandException {
        final Scoreboard lllllllllllllllIlIlllllIIIIIlIIl = this.getScoreboard();
        if (lllllllllllllllIlIllllIlllllllll.length > lllllllllllllllIlIllllIllllllllI) {
            final ScorePlayerTeam lllllllllllllllIlIlllllIIIIIlIII = this.func_147183_a(lllllllllllllllIlIllllIlllllllll[lllllllllllllllIlIllllIllllllllI]);
            if (lllllllllllllllIlIlllllIIIIIlIII == null) {
                return;
            }
            final Collection lllllllllllllllIlIlllllIIIIIIlll = lllllllllllllllIlIlllllIIIIIlIII.getMembershipCollection();
            lllllllllllllllIlIlllllIIIIIllII.func_174794_a(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllIlIlllllIIIIIIlll.size());
            if (lllllllllllllllIlIlllllIIIIIIlll.size() <= 0) {
                throw new CommandException("commands.scoreboard.teams.list.player.empty", new Object[] { lllllllllllllllIlIlllllIIIIIlIII.getRegisteredName() });
            }
            final ChatComponentTranslation lllllllllllllllIlIlllllIIIIIIllI = new ChatComponentTranslation("commands.scoreboard.teams.list.player.count", new Object[] { lllllllllllllllIlIlllllIIIIIIlll.size(), lllllllllllllllIlIlllllIIIIIlIII.getRegisteredName() });
            lllllllllllllllIlIlllllIIIIIIllI.getChatStyle().setColor(EnumChatFormatting.DARK_GREEN);
            lllllllllllllllIlIlllllIIIIIllII.addChatMessage(lllllllllllllllIlIlllllIIIIIIllI);
            lllllllllllllllIlIlllllIIIIIllII.addChatMessage(new ChatComponentText(CommandBase.joinNiceString(lllllllllllllllIlIlllllIIIIIIlll.toArray())));
        }
        else {
            final Collection lllllllllllllllIlIlllllIIIIIIlIl = lllllllllllllllIlIlllllIIIIIlIIl.getTeams();
            lllllllllllllllIlIlllllIIIIIllII.func_174794_a(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllIlIlllllIIIIIIlIl.size());
            if (lllllllllllllllIlIlllllIIIIIIlIl.size() <= 0) {
                throw new CommandException("commands.scoreboard.teams.list.empty", new Object[0]);
            }
            final ChatComponentTranslation lllllllllllllllIlIlllllIIIIIIlII = new ChatComponentTranslation("commands.scoreboard.teams.list.count", new Object[] { lllllllllllllllIlIlllllIIIIIIlIl.size() });
            lllllllllllllllIlIlllllIIIIIIlII.getChatStyle().setColor(EnumChatFormatting.DARK_GREEN);
            lllllllllllllllIlIlllllIIIIIllII.addChatMessage(lllllllllllllllIlIlllllIIIIIIlII);
            for (final ScorePlayerTeam lllllllllllllllIlIlllllIIIIIIIlI : lllllllllllllllIlIlllllIIIIIIlIl) {
                lllllllllllllllIlIlllllIIIIIllII.addChatMessage(new ChatComponentTranslation("commands.scoreboard.teams.list.entry", new Object[] { lllllllllllllllIlIlllllIIIIIIIlI.getRegisteredName(), lllllllllllllllIlIlllllIIIIIIIlI.func_96669_c(), lllllllllllllllIlIlllllIIIIIIIlI.getMembershipCollection().size() }));
            }
        }
    }
    
    protected void resetPlayers(final ICommandSender lllllllllllllllIlIllllIlIIIIIIll, final String[] lllllllllllllllIlIllllIlIIIIIIlI, int lllllllllllllllIlIllllIlIIIIIIIl) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIlIIIIIIII = this.getScoreboard();
        final String lllllllllllllllIlIllllIIllllllll = CommandBase.func_175758_e(lllllllllllllllIlIllllIlIIIIIIll, lllllllllllllllIlIllllIlIIIIIIlI[lllllllllllllllIlIllllIlIIIIIIIl++]);
        if (lllllllllllllllIlIllllIlIIIIIIlI.length > lllllllllllllllIlIllllIlIIIIIIIl) {
            final ScoreObjective lllllllllllllllIlIllllIIlllllllI = this.func_147189_a(lllllllllllllllIlIllllIlIIIIIIlI[lllllllllllllllIlIllllIlIIIIIIIl++], false);
            lllllllllllllllIlIllllIlIIIIIIII.func_178822_d(lllllllllllllllIlIllllIIllllllll, lllllllllllllllIlIllllIIlllllllI);
            CommandBase.notifyOperators(lllllllllllllllIlIllllIlIIIIIIll, this, "commands.scoreboard.players.resetscore.success", lllllllllllllllIlIllllIIlllllllI.getName(), lllllllllllllllIlIllllIIllllllll);
        }
        else {
            lllllllllllllllIlIllllIlIIIIIIII.func_178822_d(lllllllllllllllIlIllllIIllllllll, null);
            CommandBase.notifyOperators(lllllllllllllllIlIllllIlIIIIIIll, this, "commands.scoreboard.players.reset.success", lllllllllllllllIlIllllIIllllllll);
        }
    }
    
    protected List func_147184_a(final boolean lllllllllllllllIlIllllIIlIIIIIIl) {
        final Collection lllllllllllllllIlIllllIIlIIIIllI = this.getScoreboard().getScoreObjectives();
        final ArrayList lllllllllllllllIlIllllIIlIIIIlIl = Lists.newArrayList();
        for (final ScoreObjective lllllllllllllllIlIllllIIlIIIIIll : lllllllllllllllIlIllllIIlIIIIllI) {
            if (!lllllllllllllllIlIllllIIlIIIIIIl || !lllllllllllllllIlIllllIIlIIIIIll.getCriteria().isReadOnly()) {
                lllllllllllllllIlIllllIIlIIIIlIl.add(lllllllllllllllIlIllllIIlIIIIIll.getName());
            }
        }
        return lllllllllllllllIlIllllIIlIIIIlIl;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    protected List func_175782_e() {
        final Collection lllllllllllllllIlIllllIIIlllIllI = this.getScoreboard().getScoreObjectives();
        final ArrayList lllllllllllllllIlIllllIIIlllIlIl = Lists.newArrayList();
        for (final ScoreObjective lllllllllllllllIlIllllIIIlllIIll : lllllllllllllllIlIllllIIIlllIllI) {
            if (lllllllllllllllIlIllllIIIlllIIll.getCriteria() == IScoreObjectiveCriteria.field_178791_c) {
                lllllllllllllllIlIllllIIIlllIlIl.add(lllllllllllllllIlIllllIIIlllIIll.getName());
            }
        }
        return lllllllllllllllIlIllllIIIlllIlIl;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIlIllllIIlIIlIlIl, final String[] lllllllllllllllIlIllllIIlIIlIIII, final BlockPos lllllllllllllllIlIllllIIlIIlIIll) {
        if (lllllllllllllllIlIllllIIlIIlIIII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, "objectives", "players", "teams");
        }
        if (lllllllllllllllIlIllllIIlIIlIIII[0].equalsIgnoreCase("objectives")) {
            if (lllllllllllllllIlIllllIIlIIlIIII.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, "list", "add", "remove", "setdisplay");
            }
            if (lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("add")) {
                if (lllllllllllllllIlIllllIIlIIlIIII.length == 4) {
                    final Set lllllllllllllllIlIllllIIlIIlIIlI = IScoreObjectiveCriteria.INSTANCES.keySet();
                    return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, lllllllllllllllIlIllllIIlIIlIIlI);
                }
            }
            else if (lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("remove")) {
                if (lllllllllllllllIlIllllIIlIIlIIII.length == 3) {
                    return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.func_147184_a(false));
                }
            }
            else if (lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("setdisplay")) {
                if (lllllllllllllllIlIllllIIlIIlIIII.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, Scoreboard.func_178821_h());
                }
                if (lllllllllllllllIlIllllIIlIIlIIII.length == 4) {
                    return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.func_147184_a(false));
                }
            }
        }
        else if (lllllllllllllllIlIllllIIlIIlIIII[0].equalsIgnoreCase("players")) {
            if (lllllllllllllllIlIllllIIlIIlIIII.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, "set", "add", "remove", "reset", "list", "enable", "test", "operation");
            }
            if (!lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("set") && !lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("add") && !lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("remove") && !lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("reset")) {
                if (lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("enable")) {
                    if (lllllllllllllllIlIllllIIlIIlIIII.length == 3) {
                        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, MinecraftServer.getServer().getAllUsernames());
                    }
                    if (lllllllllllllllIlIllllIIlIIlIIII.length == 4) {
                        return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.func_175782_e());
                    }
                }
                else if (!lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("list") && !lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("test")) {
                    if (lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("operation")) {
                        if (lllllllllllllllIlIllllIIlIIlIIII.length == 3) {
                            return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.getScoreboard().getObjectiveNames());
                        }
                        if (lllllllllllllllIlIllllIIlIIlIIII.length == 4) {
                            return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.func_147184_a(true));
                        }
                        if (lllllllllllllllIlIllllIIlIIlIIII.length == 5) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, "+=", "-=", "*=", "/=", "%=", "=", "<", ">", "><");
                        }
                        if (lllllllllllllllIlIllllIIlIIlIIII.length == 6) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, MinecraftServer.getServer().getAllUsernames());
                        }
                        if (lllllllllllllllIlIllllIIlIIlIIII.length == 7) {
                            return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.func_147184_a(false));
                        }
                    }
                }
                else {
                    if (lllllllllllllllIlIllllIIlIIlIIII.length == 3) {
                        return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.getScoreboard().getObjectiveNames());
                    }
                    if (lllllllllllllllIlIllllIIlIIlIIII.length == 4 && lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("test")) {
                        return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.func_147184_a(false));
                    }
                }
            }
            else {
                if (lllllllllllllllIlIllllIIlIIlIIII.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, MinecraftServer.getServer().getAllUsernames());
                }
                if (lllllllllllllllIlIllllIIlIIlIIII.length == 4) {
                    return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.func_147184_a(true));
                }
            }
        }
        else if (lllllllllllllllIlIllllIIlIIlIIII[0].equalsIgnoreCase("teams")) {
            if (lllllllllllllllIlIllllIIlIIlIIII.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, "add", "remove", "join", "leave", "empty", "list", "option");
            }
            if (lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("join")) {
                if (lllllllllllllllIlIllllIIlIIlIIII.length == 3) {
                    return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.getScoreboard().getTeamNames());
                }
                if (lllllllllllllllIlIllllIIlIIlIIII.length >= 4) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, MinecraftServer.getServer().getAllUsernames());
                }
            }
            else {
                if (lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("leave")) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, MinecraftServer.getServer().getAllUsernames());
                }
                if (!lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("empty") && !lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("list") && !lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("remove")) {
                    if (lllllllllllllllIlIllllIIlIIlIIII[1].equalsIgnoreCase("option")) {
                        if (lllllllllllllllIlIllllIIlIIlIIII.length == 3) {
                            return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.getScoreboard().getTeamNames());
                        }
                        if (lllllllllllllllIlIllllIIlIIlIIII.length == 4) {
                            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, "color", "friendlyfire", "seeFriendlyInvisibles", "nametagVisibility", "deathMessageVisibility");
                        }
                        if (lllllllllllllllIlIllllIIlIIlIIII.length == 5) {
                            if (lllllllllllllllIlIllllIIlIIlIIII[3].equalsIgnoreCase("color")) {
                                return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, EnumChatFormatting.getValidValues(true, false));
                            }
                            if (lllllllllllllllIlIllllIIlIIlIIII[3].equalsIgnoreCase("nametagVisibility") || lllllllllllllllIlIllllIIlIIlIIII[3].equalsIgnoreCase("deathMessageVisibility")) {
                                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, Team.EnumVisible.func_178825_a());
                            }
                            if (lllllllllllllllIlIllllIIlIIlIIII[3].equalsIgnoreCase("friendlyfire") || lllllllllllllllIlIllllIIlIIlIIII[3].equalsIgnoreCase("seeFriendlyInvisibles")) {
                                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIllllIIlIIlIIII, "true", "false");
                            }
                        }
                    }
                }
                else if (lllllllllllllllIlIllllIIlIIlIIII.length == 3) {
                    return CommandBase.func_175762_a(lllllllllllllllIlIllllIIlIIlIIII, this.getScoreboard().getTeamNames());
                }
            }
        }
        return null;
    }
    
    protected ScoreObjective func_147189_a(final String lllllllllllllllIlIlllllIlIIIIIlI, final boolean lllllllllllllllIlIlllllIlIIIIllI) throws CommandException {
        final Scoreboard lllllllllllllllIlIlllllIlIIIIlIl = this.getScoreboard();
        final ScoreObjective lllllllllllllllIlIlllllIlIIIIlII = lllllllllllllllIlIlllllIlIIIIlIl.getObjective(lllllllllllllllIlIlllllIlIIIIIlI);
        if (lllllllllllllllIlIlllllIlIIIIlII == null) {
            throw new CommandException("commands.scoreboard.objectiveNotFound", new Object[] { lllllllllllllllIlIlllllIlIIIIIlI });
        }
        if (lllllllllllllllIlIlllllIlIIIIllI && lllllllllllllllIlIlllllIlIIIIlII.getCriteria().isReadOnly()) {
            throw new CommandException("commands.scoreboard.objectiveReadOnly", new Object[] { lllllllllllllllIlIlllllIlIIIIIlI });
        }
        return lllllllllllllllIlIlllllIlIIIIlII;
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllIlIllllIIIllIlIlI, final int lllllllllllllllIlIllllIIIllIlIIl) {
        return lllllllllllllllIlIllllIIIllIlIlI[0].equalsIgnoreCase("players") ? ((lllllllllllllllIlIllllIIIllIlIlI.length > 1 && lllllllllllllllIlIllllIIIllIlIlI[1].equalsIgnoreCase("operation")) ? (lllllllllllllllIlIllllIIIllIlIIl == 2 || lllllllllllllllIlIllllIIIllIlIIl == 5) : (lllllllllllllllIlIllllIIIllIlIIl == 2)) : (lllllllllllllllIlIllllIIIllIlIlI[0].equalsIgnoreCase("teams") && lllllllllllllllIlIllllIIIllIlIIl == 2);
    }
    
    protected void listObjectives(final ICommandSender lllllllllllllllIlIllllIlIlllIlll) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIlIlllIllI = this.getScoreboard();
        final Collection lllllllllllllllIlIllllIlIlllIlIl = lllllllllllllllIlIllllIlIlllIllI.getScoreObjectives();
        if (lllllllllllllllIlIllllIlIlllIlIl.size() <= 0) {
            throw new CommandException("commands.scoreboard.objectives.list.empty", new Object[0]);
        }
        final ChatComponentTranslation lllllllllllllllIlIllllIlIlllIlII = new ChatComponentTranslation("commands.scoreboard.objectives.list.count", new Object[] { lllllllllllllllIlIllllIlIlllIlIl.size() });
        lllllllllllllllIlIllllIlIlllIlII.getChatStyle().setColor(EnumChatFormatting.DARK_GREEN);
        lllllllllllllllIlIllllIlIlllIlll.addChatMessage(lllllllllllllllIlIllllIlIlllIlII);
        for (final ScoreObjective lllllllllllllllIlIllllIlIlllIIlI : lllllllllllllllIlIllllIlIlllIlIl) {
            lllllllllllllllIlIllllIlIlllIlll.addChatMessage(new ChatComponentTranslation("commands.scoreboard.objectives.list.entry", new Object[] { lllllllllllllllIlIllllIlIlllIIlI.getName(), lllllllllllllllIlIllllIlIlllIIlI.getDisplayName(), lllllllllllllllIlIllllIlIlllIIlI.getCriteria().getName() }));
        }
    }
    
    protected void joinTeam(final ICommandSender lllllllllllllllIlIllllIllllIlIlI, final String[] lllllllllllllllIlIllllIlllIllIlI, int lllllllllllllllIlIllllIllllIlIII) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIllllIIlll = this.getScoreboard();
        final String lllllllllllllllIlIllllIllllIIllI = lllllllllllllllIlIllllIlllIllIlI[lllllllllllllllIlIllllIllllIlIII++];
        final HashSet lllllllllllllllIlIllllIllllIIlIl = Sets.newHashSet();
        final HashSet lllllllllllllllIlIllllIllllIIlII = Sets.newHashSet();
        if (lllllllllllllllIlIllllIllllIlIlI instanceof EntityPlayer && lllllllllllllllIlIllllIllllIlIII == lllllllllllllllIlIllllIlllIllIlI.length) {
            final String lllllllllllllllIlIllllIllllIIIll = CommandBase.getCommandSenderAsPlayer(lllllllllllllllIlIllllIllllIlIlI).getName();
            if (lllllllllllllllIlIllllIllllIIlll.func_151392_a(lllllllllllllllIlIllllIllllIIIll, lllllllllllllllIlIllllIllllIIllI)) {
                lllllllllllllllIlIllllIllllIIlIl.add(lllllllllllllllIlIllllIllllIIIll);
            }
            else {
                lllllllllllllllIlIllllIllllIIlII.add(lllllllllllllllIlIllllIllllIIIll);
            }
        }
        else {
            while (lllllllllllllllIlIllllIllllIlIII < lllllllllllllllIlIllllIlllIllIlI.length) {
                final String lllllllllllllllIlIllllIllllIIIlI = lllllllllllllllIlIllllIlllIllIlI[lllllllllllllllIlIllllIllllIlIII++];
                if (lllllllllllllllIlIllllIllllIIIlI.startsWith("@")) {
                    final List lllllllllllllllIlIllllIllllIIIIl = CommandBase.func_175763_c(lllllllllllllllIlIllllIllllIlIlI, lllllllllllllllIlIllllIllllIIIlI);
                    for (final Entity lllllllllllllllIlIllllIlllIlllll : lllllllllllllllIlIllllIllllIIIIl) {
                        final String lllllllllllllllIlIllllIlllIllllI = CommandBase.func_175758_e(lllllllllllllllIlIllllIllllIlIlI, lllllllllllllllIlIllllIlllIlllll.getUniqueID().toString());
                        if (lllllllllllllllIlIllllIllllIIlll.func_151392_a(lllllllllllllllIlIllllIlllIllllI, lllllllllllllllIlIllllIllllIIllI)) {
                            lllllllllllllllIlIllllIllllIIlIl.add(lllllllllllllllIlIllllIlllIllllI);
                        }
                        else {
                            lllllllllllllllIlIllllIllllIIlII.add(lllllllllllllllIlIllllIlllIllllI);
                        }
                    }
                }
                else {
                    final String lllllllllllllllIlIllllIlllIlllIl = CommandBase.func_175758_e(lllllllllllllllIlIllllIllllIlIlI, lllllllllllllllIlIllllIllllIIIlI);
                    if (lllllllllllllllIlIllllIllllIIlll.func_151392_a(lllllllllllllllIlIllllIlllIlllIl, lllllllllllllllIlIllllIllllIIllI)) {
                        lllllllllllllllIlIllllIllllIIlIl.add(lllllllllllllllIlIllllIlllIlllIl);
                    }
                    else {
                        lllllllllllllllIlIllllIllllIIlII.add(lllllllllllllllIlIllllIlllIlllIl);
                    }
                }
            }
        }
        if (!lllllllllllllllIlIllllIllllIIlIl.isEmpty()) {
            lllllllllllllllIlIllllIllllIlIlI.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllllIlIllllIllllIIlIl.size());
            CommandBase.notifyOperators(lllllllllllllllIlIllllIllllIlIlI, this, "commands.scoreboard.teams.join.success", lllllllllllllllIlIllllIllllIIlIl.size(), lllllllllllllllIlIllllIllllIIllI, CommandBase.joinNiceString(lllllllllllllllIlIllllIllllIIlIl.toArray(new String[0])));
        }
        if (!lllllllllllllllIlIllllIllllIIlII.isEmpty()) {
            throw new CommandException("commands.scoreboard.teams.join.failure", new Object[] { lllllllllllllllIlIllllIllllIIlII.size(), lllllllllllllllIlIllllIllllIIllI, CommandBase.joinNiceString(lllllllllllllllIlIllllIllllIIlII.toArray(new String[0])) });
        }
    }
    
    protected void leaveTeam(final ICommandSender lllllllllllllllIlIllllIlllIIIIlI, final String[] lllllllllllllllIlIllllIllIllIIll, int lllllllllllllllIlIllllIllIllIIlI) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIllIllllll = this.getScoreboard();
        final HashSet lllllllllllllllIlIllllIllIlllllI = Sets.newHashSet();
        final HashSet lllllllllllllllIlIllllIllIllllIl = Sets.newHashSet();
        if (lllllllllllllllIlIllllIlllIIIIlI instanceof EntityPlayer && lllllllllllllllIlIllllIllIllIIlI == lllllllllllllllIlIllllIllIllIIll.length) {
            final String lllllllllllllllIlIllllIllIllllII = CommandBase.getCommandSenderAsPlayer(lllllllllllllllIlIllllIlllIIIIlI).getName();
            if (lllllllllllllllIlIllllIllIllllll.removePlayerFromTeams(lllllllllllllllIlIllllIllIllllII)) {
                lllllllllllllllIlIllllIllIlllllI.add(lllllllllllllllIlIllllIllIllllII);
            }
            else {
                lllllllllllllllIlIllllIllIllllIl.add(lllllllllllllllIlIllllIllIllllII);
            }
        }
        else {
            while (lllllllllllllllIlIllllIllIllIIlI < lllllllllllllllIlIllllIllIllIIll.length) {
                final String lllllllllllllllIlIllllIllIlllIll = lllllllllllllllIlIllllIllIllIIll[lllllllllllllllIlIllllIllIllIIlI++];
                if (lllllllllllllllIlIllllIllIlllIll.startsWith("@")) {
                    final List lllllllllllllllIlIllllIllIlllIlI = CommandBase.func_175763_c(lllllllllllllllIlIllllIlllIIIIlI, lllllllllllllllIlIllllIllIlllIll);
                    for (final Entity lllllllllllllllIlIllllIllIlllIII : lllllllllllllllIlIllllIllIlllIlI) {
                        final String lllllllllllllllIlIllllIllIllIlll = CommandBase.func_175758_e(lllllllllllllllIlIllllIlllIIIIlI, lllllllllllllllIlIllllIllIlllIII.getUniqueID().toString());
                        if (lllllllllllllllIlIllllIllIllllll.removePlayerFromTeams(lllllllllllllllIlIllllIllIllIlll)) {
                            lllllllllllllllIlIllllIllIlllllI.add(lllllllllllllllIlIllllIllIllIlll);
                        }
                        else {
                            lllllllllllllllIlIllllIllIllllIl.add(lllllllllllllllIlIllllIllIllIlll);
                        }
                    }
                }
                else {
                    final String lllllllllllllllIlIllllIllIllIllI = CommandBase.func_175758_e(lllllllllllllllIlIllllIlllIIIIlI, lllllllllllllllIlIllllIllIlllIll);
                    if (lllllllllllllllIlIllllIllIllllll.removePlayerFromTeams(lllllllllllllllIlIllllIllIllIllI)) {
                        lllllllllllllllIlIllllIllIlllllI.add(lllllllllllllllIlIllllIllIllIllI);
                    }
                    else {
                        lllllllllllllllIlIllllIllIllllIl.add(lllllllllllllllIlIllllIllIllIllI);
                    }
                }
            }
        }
        if (!lllllllllllllllIlIllllIllIlllllI.isEmpty()) {
            lllllllllllllllIlIllllIlllIIIIlI.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllllIlIllllIllIlllllI.size());
            CommandBase.notifyOperators(lllllllllllllllIlIllllIlllIIIIlI, this, "commands.scoreboard.teams.leave.success", lllllllllllllllIlIllllIllIlllllI.size(), CommandBase.joinNiceString(lllllllllllllllIlIllllIllIlllllI.toArray(new String[0])));
        }
        if (!lllllllllllllllIlIllllIllIllllIl.isEmpty()) {
            throw new CommandException("commands.scoreboard.teams.leave.failure", new Object[] { lllllllllllllllIlIllllIllIllllIl.size(), CommandBase.joinNiceString(lllllllllllllllIlIllllIllIllllIl.toArray(new String[0])) });
        }
    }
    
    protected Scoreboard getScoreboard() {
        return MinecraftServer.getServer().worldServerForDimension(0).getScoreboard();
    }
    
    protected void removeTeam(final ICommandSender lllllllllllllllIlIlllllIIIIllIll, final String[] lllllllllllllllIlIlllllIIIIllIlI, final int lllllllllllllllIlIlllllIIIIllIIl) throws CommandException {
        final Scoreboard lllllllllllllllIlIlllllIIIIllllI = this.getScoreboard();
        final ScorePlayerTeam lllllllllllllllIlIlllllIIIIlllIl = this.func_147183_a(lllllllllllllllIlIlllllIIIIllIlI[lllllllllllllllIlIlllllIIIIllIIl]);
        if (lllllllllllllllIlIlllllIIIIlllIl != null) {
            lllllllllllllllIlIlllllIIIIllllI.removeTeam(lllllllllllllllIlIlllllIIIIlllIl);
            CommandBase.notifyOperators(lllllllllllllllIlIlllllIIIIllIll, this, "commands.scoreboard.teams.remove.success", lllllllllllllllIlIlllllIIIIlllIl.getRegisteredName());
        }
    }
    
    protected void func_175781_o(final ICommandSender lllllllllllllllIlIllllIIllIlIIll, final String[] lllllllllllllllIlIllllIIllIIlIII, int lllllllllllllllIlIllllIIllIIIlll) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIIllIlIIII = this.getScoreboard();
        final String lllllllllllllllIlIllllIIllIIllll = CommandBase.func_175758_e(lllllllllllllllIlIllllIIllIlIIll, lllllllllllllllIlIllllIIllIIlIII[lllllllllllllllIlIllllIIllIIIlll++]);
        final ScoreObjective lllllllllllllllIlIllllIIllIIlllI = this.func_147189_a(lllllllllllllllIlIllllIIllIIlIII[lllllllllllllllIlIllllIIllIIIlll++], false);
        if (!lllllllllllllllIlIllllIIllIlIIII.func_178819_b(lllllllllllllllIlIllllIIllIIllll, lllllllllllllllIlIllllIIllIIlllI)) {
            throw new CommandException("commands.scoreboard.players.test.notFound", new Object[] { lllllllllllllllIlIllllIIllIIlllI.getName(), lllllllllllllllIlIllllIIllIIllll });
        }
        final int lllllllllllllllIlIllllIIllIIllIl = lllllllllllllllIlIllllIIllIIlIII[lllllllllllllllIlIllllIIllIIIlll].equals("*") ? Integer.MIN_VALUE : CommandBase.parseInt(lllllllllllllllIlIllllIIllIIlIII[lllllllllllllllIlIllllIIllIIIlll]);
        final int lllllllllllllllIlIllllIIllIIllII = (++lllllllllllllllIlIllllIIllIIIlll < lllllllllllllllIlIllllIIllIIlIII.length && !lllllllllllllllIlIllllIIllIIlIII[lllllllllllllllIlIllllIIllIIIlll].equals("*")) ? CommandBase.parseInt(lllllllllllllllIlIllllIIllIIlIII[lllllllllllllllIlIllllIIllIIIlll], lllllllllllllllIlIllllIIllIIllIl) : Integer.MAX_VALUE;
        final Score lllllllllllllllIlIllllIIllIIlIll = lllllllllllllllIlIllllIIllIlIIII.getValueFromObjective(lllllllllllllllIlIllllIIllIIllll, lllllllllllllllIlIllllIIllIIlllI);
        if (lllllllllllllllIlIllllIIllIIlIll.getScorePoints() >= lllllllllllllllIlIllllIIllIIllIl && lllllllllllllllIlIllllIIllIIlIll.getScorePoints() <= lllllllllllllllIlIllllIIllIIllII) {
            CommandBase.notifyOperators(lllllllllllllllIlIllllIIllIlIIll, this, "commands.scoreboard.players.test.success", lllllllllllllllIlIllllIIllIIlIll.getScorePoints(), lllllllllllllllIlIllllIIllIIllIl, lllllllllllllllIlIllllIIllIIllII);
            return;
        }
        throw new CommandException("commands.scoreboard.players.test.failed", new Object[] { lllllllllllllllIlIllllIIllIIlIll.getScorePoints(), lllllllllllllllIlIllllIIllIIllIl, lllllllllllllllIlIllllIIllIIllII });
    }
    
    protected void func_175778_p(final ICommandSender lllllllllllllllIlIllllIIlIllIIlI, final String[] lllllllllllllllIlIllllIIlIllIIIl, int lllllllllllllllIlIllllIIlIllIIII) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIIlIlIllll = this.getScoreboard();
        final String lllllllllllllllIlIllllIIlIlIlllI = CommandBase.func_175758_e(lllllllllllllllIlIllllIIlIllIIlI, lllllllllllllllIlIllllIIlIllIIIl[lllllllllllllllIlIllllIIlIllIIII++]);
        final ScoreObjective lllllllllllllllIlIllllIIlIlIllIl = this.func_147189_a(lllllllllllllllIlIllllIIlIllIIIl[lllllllllllllllIlIllllIIlIllIIII++], true);
        final String lllllllllllllllIlIllllIIlIlIllII = lllllllllllllllIlIllllIIlIllIIIl[lllllllllllllllIlIllllIIlIllIIII++];
        final String lllllllllllllllIlIllllIIlIlIlIll = CommandBase.func_175758_e(lllllllllllllllIlIllllIIlIllIIlI, lllllllllllllllIlIllllIIlIllIIIl[lllllllllllllllIlIllllIIlIllIIII++]);
        final ScoreObjective lllllllllllllllIlIllllIIlIlIlIlI = this.func_147189_a(lllllllllllllllIlIllllIIlIllIIIl[lllllllllllllllIlIllllIIlIllIIII], false);
        final Score lllllllllllllllIlIllllIIlIlIlIIl = lllllllllllllllIlIllllIIlIlIllll.getValueFromObjective(lllllllllllllllIlIllllIIlIlIlllI, lllllllllllllllIlIllllIIlIlIllIl);
        if (!lllllllllllllllIlIllllIIlIlIllll.func_178819_b(lllllllllllllllIlIllllIIlIlIlIll, lllllllllllllllIlIllllIIlIlIlIlI)) {
            throw new CommandException("commands.scoreboard.players.operation.notFound", new Object[] { lllllllllllllllIlIllllIIlIlIlIlI.getName(), lllllllllllllllIlIllllIIlIlIlIll });
        }
        final Score lllllllllllllllIlIllllIIlIlIlIII = lllllllllllllllIlIllllIIlIlIllll.getValueFromObjective(lllllllllllllllIlIllllIIlIlIlIll, lllllllllllllllIlIllllIIlIlIlIlI);
        if (lllllllllllllllIlIllllIIlIlIllII.equals("+=")) {
            lllllllllllllllIlIllllIIlIlIlIIl.setScorePoints(lllllllllllllllIlIllllIIlIlIlIIl.getScorePoints() + lllllllllllllllIlIllllIIlIlIlIII.getScorePoints());
        }
        else if (lllllllllllllllIlIllllIIlIlIllII.equals("-=")) {
            lllllllllllllllIlIllllIIlIlIlIIl.setScorePoints(lllllllllllllllIlIllllIIlIlIlIIl.getScorePoints() - lllllllllllllllIlIllllIIlIlIlIII.getScorePoints());
        }
        else if (lllllllllllllllIlIllllIIlIlIllII.equals("*=")) {
            lllllllllllllllIlIllllIIlIlIlIIl.setScorePoints(lllllllllllllllIlIllllIIlIlIlIIl.getScorePoints() * lllllllllllllllIlIllllIIlIlIlIII.getScorePoints());
        }
        else if (lllllllllllllllIlIllllIIlIlIllII.equals("/=")) {
            if (lllllllllllllllIlIllllIIlIlIlIII.getScorePoints() != 0) {
                lllllllllllllllIlIllllIIlIlIlIIl.setScorePoints(lllllllllllllllIlIllllIIlIlIlIIl.getScorePoints() / lllllllllllllllIlIllllIIlIlIlIII.getScorePoints());
            }
        }
        else if (lllllllllllllllIlIllllIIlIlIllII.equals("%=")) {
            if (lllllllllllllllIlIllllIIlIlIlIII.getScorePoints() != 0) {
                lllllllllllllllIlIllllIIlIlIlIIl.setScorePoints(lllllllllllllllIlIllllIIlIlIlIIl.getScorePoints() % lllllllllllllllIlIllllIIlIlIlIII.getScorePoints());
            }
        }
        else if (lllllllllllllllIlIllllIIlIlIllII.equals("=")) {
            lllllllllllllllIlIllllIIlIlIlIIl.setScorePoints(lllllllllllllllIlIllllIIlIlIlIII.getScorePoints());
        }
        else if (lllllllllllllllIlIllllIIlIlIllII.equals("<")) {
            lllllllllllllllIlIllllIIlIlIlIIl.setScorePoints(Math.min(lllllllllllllllIlIllllIIlIlIlIIl.getScorePoints(), lllllllllllllllIlIllllIIlIlIlIII.getScorePoints()));
        }
        else if (lllllllllllllllIlIllllIIlIlIllII.equals(">")) {
            lllllllllllllllIlIllllIIlIlIlIIl.setScorePoints(Math.max(lllllllllllllllIlIllllIIlIlIlIIl.getScorePoints(), lllllllllllllllIlIllllIIlIlIlIII.getScorePoints()));
        }
        else {
            if (!lllllllllllllllIlIllllIIlIlIllII.equals("><")) {
                throw new CommandException("commands.scoreboard.players.operation.invalidOperation", new Object[] { lllllllllllllllIlIllllIIlIlIllII });
            }
            final int lllllllllllllllIlIllllIIlIlIIlll = lllllllllllllllIlIllllIIlIlIlIIl.getScorePoints();
            lllllllllllllllIlIllllIIlIlIlIIl.setScorePoints(lllllllllllllllIlIllllIIlIlIlIII.getScorePoints());
            lllllllllllllllIlIllllIIlIlIlIII.setScorePoints(lllllllllllllllIlIllllIIlIlIIlll);
        }
        CommandBase.notifyOperators(lllllllllllllllIlIllllIIlIllIIlI, this, "commands.scoreboard.players.operation.success", new Object[0]);
    }
    
    protected void addObjective(final ICommandSender lllllllllllllllIlIlllllIIllIlIII, final String[] lllllllllllllllIlIlllllIIlIllllI, int lllllllllllllllIlIlllllIIlIlllIl) throws CommandException {
        final String lllllllllllllllIlIlllllIIllIIlIl = lllllllllllllllIlIlllllIIlIllllI[lllllllllllllllIlIlllllIIlIlllIl++];
        final String lllllllllllllllIlIlllllIIllIIlII = lllllllllllllllIlIlllllIIlIllllI[lllllllllllllllIlIlllllIIlIlllIl++];
        final Scoreboard lllllllllllllllIlIlllllIIllIIIll = this.getScoreboard();
        final IScoreObjectiveCriteria lllllllllllllllIlIlllllIIllIIIlI = IScoreObjectiveCriteria.INSTANCES.get(lllllllllllllllIlIlllllIIllIIlII);
        if (lllllllllllllllIlIlllllIIllIIIlI == null) {
            throw new WrongUsageException("commands.scoreboard.objectives.add.wrongType", new Object[] { lllllllllllllllIlIlllllIIllIIlII });
        }
        if (lllllllllllllllIlIlllllIIllIIIll.getObjective(lllllllllllllllIlIlllllIIllIIlIl) != null) {
            throw new CommandException("commands.scoreboard.objectives.add.alreadyExists", new Object[] { lllllllllllllllIlIlllllIIllIIlIl });
        }
        if (lllllllllllllllIlIlllllIIllIIlIl.length() > 16) {
            throw new SyntaxErrorException("commands.scoreboard.objectives.add.tooLong", new Object[] { lllllllllllllllIlIlllllIIllIIlIl, 16 });
        }
        if (lllllllllllllllIlIlllllIIllIIlIl.length() == 0) {
            throw new WrongUsageException("commands.scoreboard.objectives.add.usage", new Object[0]);
        }
        if (lllllllllllllllIlIlllllIIlIllllI.length > lllllllllllllllIlIlllllIIlIlllIl) {
            final String lllllllllllllllIlIlllllIIllIIIIl = CommandBase.getChatComponentFromNthArg(lllllllllllllllIlIlllllIIllIlIII, lllllllllllllllIlIlllllIIlIllllI, lllllllllllllllIlIlllllIIlIlllIl).getUnformattedText();
            if (lllllllllllllllIlIlllllIIllIIIIl.length() > 32) {
                throw new SyntaxErrorException("commands.scoreboard.objectives.add.displayTooLong", new Object[] { lllllllllllllllIlIlllllIIllIIIIl, 32 });
            }
            if (lllllllllllllllIlIlllllIIllIIIIl.length() > 0) {
                lllllllllllllllIlIlllllIIllIIIll.addScoreObjective(lllllllllllllllIlIlllllIIllIIlIl, lllllllllllllllIlIlllllIIllIIIlI).setDisplayName(lllllllllllllllIlIlllllIIllIIIIl);
            }
            else {
                lllllllllllllllIlIlllllIIllIIIll.addScoreObjective(lllllllllllllllIlIlllllIIllIIlIl, lllllllllllllllIlIlllllIIllIIIlI);
            }
        }
        else {
            lllllllllllllllIlIlllllIIllIIIll.addScoreObjective(lllllllllllllllIlIlllllIIllIIlIl, lllllllllllllllIlIlllllIIllIIIlI);
        }
        CommandBase.notifyOperators(lllllllllllllllIlIlllllIIllIlIII, this, "commands.scoreboard.objectives.add.success", lllllllllllllllIlIlllllIIllIIlIl);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIlIlllllIlIlllIlI) {
        return "commands.scoreboard.usage";
    }
    
    protected void removeObjective(final ICommandSender lllllllllllllllIlIllllIllIIIlIII, final String lllllllllllllllIlIllllIllIIIIIlI) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIllIIIIllI = this.getScoreboard();
        final ScoreObjective lllllllllllllllIlIllllIllIIIIlIl = this.func_147189_a(lllllllllllllllIlIllllIllIIIIIlI, false);
        lllllllllllllllIlIllllIllIIIIllI.func_96519_k(lllllllllllllllIlIllllIllIIIIlIl);
        CommandBase.notifyOperators(lllllllllllllllIlIllllIllIIIlIII, this, "commands.scoreboard.objectives.remove.success", lllllllllllllllIlIllllIllIIIIIlI);
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIlIlllllIlIllIlIl, final String[] lllllllllllllllIlIlllllIlIllIIIl) throws CommandException {
        if (!this.func_175780_b(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl)) {
            if (lllllllllllllllIlIlllllIlIllIIIl.length < 1) {
                throw new WrongUsageException("commands.scoreboard.usage", new Object[0]);
            }
            if (lllllllllllllllIlIlllllIlIllIIIl[0].equalsIgnoreCase("objectives")) {
                if (lllllllllllllllIlIlllllIlIllIIIl.length == 1) {
                    throw new WrongUsageException("commands.scoreboard.objectives.usage", new Object[0]);
                }
                if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("list")) {
                    this.listObjectives(lllllllllllllllIlIlllllIlIllIlIl);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("add")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length < 4) {
                        throw new WrongUsageException("commands.scoreboard.objectives.add.usage", new Object[0]);
                    }
                    this.addObjective(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("remove")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length != 3) {
                        throw new WrongUsageException("commands.scoreboard.objectives.remove.usage", new Object[0]);
                    }
                    this.removeObjective(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl[2]);
                }
                else {
                    if (!lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("setdisplay")) {
                        throw new WrongUsageException("commands.scoreboard.objectives.usage", new Object[0]);
                    }
                    if (lllllllllllllllIlIlllllIlIllIIIl.length != 3 && lllllllllllllllIlIlllllIlIllIIIl.length != 4) {
                        throw new WrongUsageException("commands.scoreboard.objectives.setdisplay.usage", new Object[0]);
                    }
                    this.setObjectiveDisplay(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
            }
            else if (lllllllllllllllIlIlllllIlIllIIIl[0].equalsIgnoreCase("players")) {
                if (lllllllllllllllIlIlllllIlIllIIIl.length == 1) {
                    throw new WrongUsageException("commands.scoreboard.players.usage", new Object[0]);
                }
                if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("list")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length > 3) {
                        throw new WrongUsageException("commands.scoreboard.players.list.usage", new Object[0]);
                    }
                    this.listPlayers(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("add")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length < 5) {
                        throw new WrongUsageException("commands.scoreboard.players.add.usage", new Object[0]);
                    }
                    this.setPlayer(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("remove")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length < 5) {
                        throw new WrongUsageException("commands.scoreboard.players.remove.usage", new Object[0]);
                    }
                    this.setPlayer(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("set")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length < 5) {
                        throw new WrongUsageException("commands.scoreboard.players.set.usage", new Object[0]);
                    }
                    this.setPlayer(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("reset")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length != 3 && lllllllllllllllIlIlllllIlIllIIIl.length != 4) {
                        throw new WrongUsageException("commands.scoreboard.players.reset.usage", new Object[0]);
                    }
                    this.resetPlayers(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("enable")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length != 4) {
                        throw new WrongUsageException("commands.scoreboard.players.enable.usage", new Object[0]);
                    }
                    this.func_175779_n(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("test")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length != 5 && lllllllllllllllIlIlllllIlIllIIIl.length != 6) {
                        throw new WrongUsageException("commands.scoreboard.players.test.usage", new Object[0]);
                    }
                    this.func_175781_o(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else {
                    if (!lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("operation")) {
                        throw new WrongUsageException("commands.scoreboard.players.usage", new Object[0]);
                    }
                    if (lllllllllllllllIlIlllllIlIllIIIl.length != 7) {
                        throw new WrongUsageException("commands.scoreboard.players.operation.usage", new Object[0]);
                    }
                    this.func_175778_p(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
            }
            else if (lllllllllllllllIlIlllllIlIllIIIl[0].equalsIgnoreCase("teams")) {
                if (lllllllllllllllIlIlllllIlIllIIIl.length == 1) {
                    throw new WrongUsageException("commands.scoreboard.teams.usage", new Object[0]);
                }
                if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("list")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length > 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.list.usage", new Object[0]);
                    }
                    this.listTeams(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("add")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length < 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.add.usage", new Object[0]);
                    }
                    this.addTeam(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("remove")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length != 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.remove.usage", new Object[0]);
                    }
                    this.removeTeam(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("empty")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length != 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.empty.usage", new Object[0]);
                    }
                    this.emptyTeam(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("join")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length < 4 && (lllllllllllllllIlIlllllIlIllIIIl.length != 3 || !(lllllllllllllllIlIlllllIlIllIlIl instanceof EntityPlayer))) {
                        throw new WrongUsageException("commands.scoreboard.teams.join.usage", new Object[0]);
                    }
                    this.joinTeam(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else if (lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("leave")) {
                    if (lllllllllllllllIlIlllllIlIllIIIl.length < 3 && !(lllllllllllllllIlIlllllIlIllIlIl instanceof EntityPlayer)) {
                        throw new WrongUsageException("commands.scoreboard.teams.leave.usage", new Object[0]);
                    }
                    this.leaveTeam(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
                else {
                    if (!lllllllllllllllIlIlllllIlIllIIIl[1].equalsIgnoreCase("option")) {
                        throw new WrongUsageException("commands.scoreboard.teams.usage", new Object[0]);
                    }
                    if (lllllllllllllllIlIlllllIlIllIIIl.length != 4 && lllllllllllllllIlIlllllIlIllIIIl.length != 5) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
                    }
                    this.setTeamOption(lllllllllllllllIlIlllllIlIllIlIl, lllllllllllllllIlIlllllIlIllIIIl, 2);
                }
            }
        }
    }
    
    protected ScorePlayerTeam func_147183_a(final String lllllllllllllllIlIlllllIIllllIIl) throws CommandException {
        final Scoreboard lllllllllllllllIlIlllllIIllllIII = this.getScoreboard();
        final ScorePlayerTeam lllllllllllllllIlIlllllIIlllIlll = lllllllllllllllIlIlllllIIllllIII.getTeam(lllllllllllllllIlIlllllIIllllIIl);
        if (lllllllllllllllIlIlllllIIlllIlll == null) {
            throw new CommandException("commands.scoreboard.teamNotFound", new Object[] { lllllllllllllllIlIlllllIIllllIIl });
        }
        return lllllllllllllllIlIlllllIIlllIlll;
    }
    
    static {
        __OBFID = "CL_00000896";
    }
    
    protected void listPlayers(final ICommandSender lllllllllllllllIlIllllIlIlIIIlll, final String[] lllllllllllllllIlIllllIlIIlllIlI, final int lllllllllllllllIlIllllIlIlIIIlIl) throws CommandException {
        final Scoreboard lllllllllllllllIlIllllIlIlIIIlII = this.getScoreboard();
        if (lllllllllllllllIlIllllIlIIlllIlI.length > lllllllllllllllIlIllllIlIlIIIlIl) {
            final String lllllllllllllllIlIllllIlIlIIIIll = CommandBase.func_175758_e(lllllllllllllllIlIllllIlIlIIIlll, lllllllllllllllIlIllllIlIIlllIlI[lllllllllllllllIlIllllIlIlIIIlIl]);
            final Map lllllllllllllllIlIllllIlIlIIIIlI = lllllllllllllllIlIllllIlIlIIIlII.func_96510_d(lllllllllllllllIlIllllIlIlIIIIll);
            lllllllllllllllIlIllllIlIlIIIlll.func_174794_a(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllIlIllllIlIlIIIIlI.size());
            if (lllllllllllllllIlIllllIlIlIIIIlI.size() <= 0) {
                throw new CommandException("commands.scoreboard.players.list.player.empty", new Object[] { lllllllllllllllIlIllllIlIlIIIIll });
            }
            final ChatComponentTranslation lllllllllllllllIlIllllIlIlIIIIIl = new ChatComponentTranslation("commands.scoreboard.players.list.player.count", new Object[] { lllllllllllllllIlIllllIlIlIIIIlI.size(), lllllllllllllllIlIllllIlIlIIIIll });
            lllllllllllllllIlIllllIlIlIIIIIl.getChatStyle().setColor(EnumChatFormatting.DARK_GREEN);
            lllllllllllllllIlIllllIlIlIIIlll.addChatMessage(lllllllllllllllIlIllllIlIlIIIIIl);
            for (final Score lllllllllllllllIlIllllIlIIllllll : lllllllllllllllIlIllllIlIlIIIIlI.values()) {
                lllllllllllllllIlIllllIlIlIIIlll.addChatMessage(new ChatComponentTranslation("commands.scoreboard.players.list.player.entry", new Object[] { lllllllllllllllIlIllllIlIIllllll.getScorePoints(), lllllllllllllllIlIllllIlIIllllll.getObjective().getDisplayName(), lllllllllllllllIlIllllIlIIllllll.getObjective().getName() }));
            }
        }
        else {
            final Collection lllllllllllllllIlIllllIlIIlllllI = lllllllllllllllIlIllllIlIlIIIlII.getObjectiveNames();
            lllllllllllllllIlIllllIlIlIIIlll.func_174794_a(CommandResultStats.Type.QUERY_RESULT, lllllllllllllllIlIllllIlIIlllllI.size());
            if (lllllllllllllllIlIllllIlIIlllllI.size() <= 0) {
                throw new CommandException("commands.scoreboard.players.list.empty", new Object[0]);
            }
            final ChatComponentTranslation lllllllllllllllIlIllllIlIIllllIl = new ChatComponentTranslation("commands.scoreboard.players.list.count", new Object[] { lllllllllllllllIlIllllIlIIlllllI.size() });
            lllllllllllllllIlIllllIlIIllllIl.getChatStyle().setColor(EnumChatFormatting.DARK_GREEN);
            lllllllllllllllIlIllllIlIlIIIlll.addChatMessage(lllllllllllllllIlIllllIlIIllllIl);
            lllllllllllllllIlIllllIlIlIIIlll.addChatMessage(new ChatComponentText(CommandBase.joinNiceString(lllllllllllllllIlIllllIlIIlllllI.toArray())));
        }
    }
}
