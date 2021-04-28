package net.minecraft.command;

import java.util.*;
import net.minecraft.util.*;

public interface ICommandManager
{
    Map getCommands();
    
    int executeCommand(final ICommandSender p0, final String p1);
    
    List getPossibleCommands(final ICommandSender p0);
    
    List getTabCompletionOptions(final ICommandSender p0, final String p1, final BlockPos p2);
}
