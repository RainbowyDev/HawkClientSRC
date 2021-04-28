package net.minecraft.command;

import java.util.*;
import net.minecraft.util.*;

public interface ICommand extends Comparable
{
    boolean canCommandSenderUseCommand(final ICommandSender p0);
    
    List getCommandAliases();
    
    String getCommandUsage(final ICommandSender p0);
    
    void processCommand(final ICommandSender p0, final String[] p1) throws CommandException;
    
    String getCommandName();
    
    boolean isUsernameIndex(final String[] p0, final int p1);
    
    List addTabCompletionOptions(final ICommandSender p0, final String[] p1, final BlockPos p2);
}
