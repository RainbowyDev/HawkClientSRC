package net.minecraft.command.server;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;
import net.minecraft.nbt.*;
import net.minecraft.command.*;
import net.minecraft.entity.*;

public class CommandTestFor extends CommandBase
{
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIIlIIlIIlllIlllIII, final String[] llllllllllllllIIlIIlIIlllIllIlll, final BlockPos llllllllllllllIIlIIlIIlllIllIllI) {
        return (llllllllllllllIIlIIlIIlllIllIlll.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlIIlIIlllIllIlll, MinecraftServer.getServer().getAllUsernames()) : null;
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIIlIIlIIllllIIIlII, final String[] llllllllllllllIIlIIlIIllllIIlIlI) throws CommandException {
        if (llllllllllllllIIlIIlIIllllIIlIlI.length < 1) {
            throw new WrongUsageException("commands.testfor.usage", new Object[0]);
        }
        final Entity llllllllllllllIIlIIlIIllllIIlIIl = CommandBase.func_175768_b(llllllllllllllIIlIIlIIllllIIIlII, llllllllllllllIIlIIlIIllllIIlIlI[0]);
        NBTTagCompound llllllllllllllIIlIIlIIllllIIlIII = null;
        if (llllllllllllllIIlIIlIIllllIIlIlI.length >= 2) {
            try {
                llllllllllllllIIlIIlIIllllIIlIII = JsonToNBT.func_180713_a(CommandBase.func_180529_a(llllllllllllllIIlIIlIIllllIIlIlI, 1));
            }
            catch (NBTException llllllllllllllIIlIIlIIllllIIIlll) {
                throw new CommandException("commands.testfor.tagError", new Object[] { llllllllllllllIIlIIlIIllllIIIlll.getMessage() });
            }
        }
        if (llllllllllllllIIlIIlIIllllIIlIII != null) {
            final NBTTagCompound llllllllllllllIIlIIlIIllllIIIllI = new NBTTagCompound();
            llllllllllllllIIlIIlIIllllIIlIIl.writeToNBT(llllllllllllllIIlIIlIIllllIIIllI);
            if (!CommandTestForBlock.func_175775_a(llllllllllllllIIlIIlIIllllIIlIII, llllllllllllllIIlIIlIIllllIIIllI, true)) {
                throw new CommandException("commands.testfor.failure", new Object[] { llllllllllllllIIlIIlIIllllIIlIIl.getName() });
            }
        }
        CommandBase.notifyOperators(llllllllllllllIIlIIlIIllllIIIlII, this, "commands.testfor.success", llllllllllllllIIlIIlIIllllIIlIIl.getName());
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlIIlIIllllIlIIll) {
        return "commands.testfor.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    static {
        __OBFID = "CL_00001182";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIIlIIlIIlllIllllIl, final int llllllllllllllIIlIIlIIlllIlllIll) {
        return llllllllllllllIIlIIlIIlllIlllIll == 0;
    }
    
    @Override
    public String getCommandName() {
        return "testfor";
    }
}
