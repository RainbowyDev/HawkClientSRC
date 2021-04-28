package net.minecraft.command.server;

import java.util.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.command.*;

public class CommandMessage extends CommandBase
{
    static {
        __OBFID = "CL_00000641";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public List getCommandAliases() {
        return Arrays.asList("w", "msg");
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllIlllIlIllIIlllllI, final int lllllllllllllllIlllIlIllIIllllIl) {
        return lllllllllllllllIlllIlIllIIllllIl == 0;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIlllIlIllIlIIIlII, final String[] lllllllllllllllIlllIlIllIlIIIIIl, final BlockPos lllllllllllllllIlllIlIllIlIIIIlI) {
        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlllIlIllIlIIIIIl, MinecraftServer.getServer().getAllUsernames());
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIlllIlIllIlIllIlI) {
        return "commands.message.usage";
    }
    
    @Override
    public String getCommandName() {
        return "tell";
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIlllIlIllIlIlIIlI, final String[] lllllllllllllllIlllIlIllIlIlIIIl) throws CommandException {
        if (lllllllllllllllIlllIlIllIlIlIIIl.length < 2) {
            throw new WrongUsageException("commands.message.usage", new Object[0]);
        }
        final EntityPlayerMP lllllllllllllllIlllIlIllIlIlIIII = CommandBase.getPlayer(lllllllllllllllIlllIlIllIlIlIIlI, lllllllllllllllIlllIlIllIlIlIIIl[0]);
        if (lllllllllllllllIlllIlIllIlIlIIII == lllllllllllllllIlllIlIllIlIlIIlI) {
            throw new PlayerNotFoundException("commands.message.sameTarget", new Object[0]);
        }
        final IChatComponent lllllllllllllllIlllIlIllIlIIllll = CommandBase.getChatComponentFromNthArg(lllllllllllllllIlllIlIllIlIlIIlI, lllllllllllllllIlllIlIllIlIlIIIl, 1, !(lllllllllllllllIlllIlIllIlIlIIlI instanceof EntityPlayer));
        final ChatComponentTranslation lllllllllllllllIlllIlIllIlIIlllI = new ChatComponentTranslation("commands.message.display.incoming", new Object[] { lllllllllllllllIlllIlIllIlIlIIlI.getDisplayName(), lllllllllllllllIlllIlIllIlIIllll.createCopy() });
        final ChatComponentTranslation lllllllllllllllIlllIlIllIlIIllIl = new ChatComponentTranslation("commands.message.display.outgoing", new Object[] { lllllllllllllllIlllIlIllIlIlIIII.getDisplayName(), lllllllllllllllIlllIlIllIlIIllll.createCopy() });
        lllllllllllllllIlllIlIllIlIIlllI.getChatStyle().setColor(EnumChatFormatting.GRAY).setItalic(true);
        lllllllllllllllIlllIlIllIlIIllIl.getChatStyle().setColor(EnumChatFormatting.GRAY).setItalic(true);
        lllllllllllllllIlllIlIllIlIlIIII.addChatMessage(lllllllllllllllIlllIlIllIlIIlllI);
        lllllllllllllllIlllIlIllIlIlIIlI.addChatMessage(lllllllllllllllIlllIlIllIlIIllIl);
    }
}
