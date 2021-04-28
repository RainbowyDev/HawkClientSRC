package net.minecraft.command;

import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class CommandKill extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIlllIllIIIIIIIlIll, final int llllllllllllllIlllIllIIIIIIIlIlI) {
        return llllllllllllllIlllIllIIIIIIIlIlI == 0;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlllIllIIIIIlIlIll) {
        return "commands.kill.usage";
    }
    
    @Override
    public String getCommandName() {
        return "kill";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlllIllIIIIIIlIIll, final String[] llllllllllllllIlllIllIIIIIIllIII) throws CommandException {
        if (llllllllllllllIlllIllIIIIIIllIII.length == 0) {
            final EntityPlayerMP llllllllllllllIlllIllIIIIIIlIlll = CommandBase.getCommandSenderAsPlayer(llllllllllllllIlllIllIIIIIIlIIll);
            llllllllllllllIlllIllIIIIIIlIlll.func_174812_G();
            CommandBase.notifyOperators(llllllllllllllIlllIllIIIIIIlIIll, this, "commands.kill.successful", llllllllllllllIlllIllIIIIIIlIlll.getDisplayName());
        }
        else {
            final Entity llllllllllllllIlllIllIIIIIIlIllI = CommandBase.func_175768_b(llllllllllllllIlllIllIIIIIIlIIll, llllllllllllllIlllIllIIIIIIllIII[0]);
            llllllllllllllIlllIllIIIIIIlIllI.func_174812_G();
            CommandBase.notifyOperators(llllllllllllllIlllIllIIIIIIlIIll, this, "commands.kill.successful", llllllllllllllIlllIllIIIIIIlIllI.getDisplayName());
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    static {
        __OBFID = "CL_00000570";
    }
}
