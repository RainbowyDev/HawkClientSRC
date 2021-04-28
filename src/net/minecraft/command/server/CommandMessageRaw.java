package net.minecraft.command.server;

import net.minecraft.entity.*;
import org.apache.commons.lang3.exception.*;
import com.google.gson.*;
import net.minecraft.entity.player.*;
import net.minecraft.command.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;

public class CommandMessageRaw extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllllIllIIIllIIlllIlI, final int llllllllllllllllIllIIIllIIlllIIl) {
        return llllllllllllllllIllIIIllIIlllIIl == 0;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIllIIIllIlIlIlll) {
        return "commands.tellraw.usage";
    }
    
    @Override
    public String getCommandName() {
        return "tellraw";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    static {
        __OBFID = "CL_00000667";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllllIllIIIllIlIIllll, final String[] llllllllllllllllIllIIIllIlIIlllI) throws CommandException {
        if (llllllllllllllllIllIIIllIlIIlllI.length < 2) {
            throw new WrongUsageException("commands.tellraw.usage", new Object[0]);
        }
        final EntityPlayerMP llllllllllllllllIllIIIllIlIIllIl = CommandBase.getPlayer(llllllllllllllllIllIIIllIlIIllll, llllllllllllllllIllIIIllIlIIlllI[0]);
        final String llllllllllllllllIllIIIllIlIIllII = CommandBase.func_180529_a(llllllllllllllllIllIIIllIlIIlllI, 1);
        try {
            final IChatComponent llllllllllllllllIllIIIllIlIIlIll = IChatComponent.Serializer.jsonToComponent(llllllllllllllllIllIIIllIlIIllII);
            llllllllllllllllIllIIIllIlIIllIl.addChatMessage(ChatComponentProcessor.func_179985_a(llllllllllllllllIllIIIllIlIIllll, llllllllllllllllIllIIIllIlIIlIll, llllllllllllllllIllIIIllIlIIllIl));
        }
        catch (JsonParseException llllllllllllllllIllIIIllIlIIlIlI) {
            final Throwable llllllllllllllllIllIIIllIlIIlIIl = ExceptionUtils.getRootCause((Throwable)llllllllllllllllIllIIIllIlIIlIlI);
            throw new SyntaxErrorException("commands.tellraw.jsonException", new Object[] { (llllllllllllllllIllIIIllIlIIlIIl == null) ? "" : llllllllllllllllIllIIIllIlIIlIIl.getMessage() });
        }
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllllIllIIIllIlIIIIII, final String[] llllllllllllllllIllIIIllIIllllll, final BlockPos llllllllllllllllIllIIIllIIlllllI) {
        return (llllllllllllllllIllIIIllIIllllll.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllIllIIIllIIllllll, MinecraftServer.getServer().getAllUsernames()) : null;
    }
}
