package net.minecraft.command.server;

import net.minecraft.entity.player.*;
import net.minecraft.server.*;
import net.minecraft.command.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandEmote extends CommandBase
{
    @Override
    public String getCommandName() {
        return "me";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lIlIllIllIlIlII) {
        return "commands.me.usage";
    }
    
    @Override
    public void processCommand(final ICommandSender lIlIllIllIIllll, final String[] lIlIllIllIIlllI) throws CommandException {
        if (lIlIllIllIIlllI.length <= 0) {
            throw new WrongUsageException("commands.me.usage", new Object[0]);
        }
        final IChatComponent lIlIllIllIIllIl = CommandBase.getChatComponentFromNthArg(lIlIllIllIIllll, lIlIllIllIIlllI, 0, !(lIlIllIllIIllll instanceof EntityPlayer));
        MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentTranslation("chat.type.emote", new Object[] { lIlIllIllIIllll.getDisplayName(), lIlIllIllIIllIl }));
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    static {
        __OBFID = "CL_00000351";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lIlIllIllIIIlll, final String[] lIlIllIllIIIlII, final BlockPos lIlIllIllIIIlIl) {
        return CommandBase.getListOfStringsMatchingLastWord(lIlIllIllIIIlII, MinecraftServer.getServer().getAllUsernames());
    }
}
