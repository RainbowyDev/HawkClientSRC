package net.minecraft.command;

import net.minecraft.world.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandGameRule extends CommandBase
{
    public static void func_175773_a(final GameRules llIIIIlIlllIll, final String llIIIIlIllllll) {
        if ("reducedDebugInfo".equals(llIIIIlIllllll)) {
            final int llIIIIlIlllllI = llIIIIlIlllIll.getGameRuleBooleanValue(llIIIIlIllllll) ? 22 : 23;
            for (final EntityPlayerMP llIIIIlIllllII : MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
                llIIIIlIllllII.playerNetServerHandler.sendPacket(new S19PacketEntityStatus(llIIIIlIllllII, (byte)llIIIIlIlllllI));
            }
        }
    }
    
    @Override
    public void processCommand(final ICommandSender llIIIIllIIlIll, final String[] llIIIIllIIlIlI) throws CommandException {
        final GameRules llIIIIllIlIIII = this.getGameRules();
        final String llIIIIllIIllll = (llIIIIllIIlIlI.length > 0) ? llIIIIllIIlIlI[0] : "";
        final String llIIIIllIIlllI = (llIIIIllIIlIlI.length > 1) ? CommandBase.func_180529_a(llIIIIllIIlIlI, 1) : "";
        switch (llIIIIllIIlIlI.length) {
            case 0: {
                llIIIIllIIlIll.addChatMessage(new ChatComponentText(CommandBase.joinNiceString(llIIIIllIlIIII.getRules())));
                break;
            }
            case 1: {
                if (!llIIIIllIlIIII.hasRule(llIIIIllIIllll)) {
                    throw new CommandException("commands.gamerule.norule", new Object[] { llIIIIllIIllll });
                }
                final String llIIIIllIIllIl = llIIIIllIlIIII.getGameRuleStringValue(llIIIIllIIllll);
                llIIIIllIIlIll.addChatMessage(new ChatComponentText(llIIIIllIIllll).appendText(" = ").appendText(llIIIIllIIllIl));
                llIIIIllIIlIll.func_174794_a(CommandResultStats.Type.QUERY_RESULT, llIIIIllIlIIII.getInt(llIIIIllIIllll));
                break;
            }
            default: {
                if (llIIIIllIlIIII.areSameType(llIIIIllIIllll, GameRules.ValueType.BOOLEAN_VALUE) && !"true".equals(llIIIIllIIlllI) && !"false".equals(llIIIIllIIlllI)) {
                    throw new CommandException("commands.generic.boolean.invalid", new Object[] { llIIIIllIIlllI });
                }
                llIIIIllIlIIII.setOrCreateGameRule(llIIIIllIIllll, llIIIIllIIlllI);
                func_175773_a(llIIIIllIlIIII, llIIIIllIIllll);
                CommandBase.notifyOperators(llIIIIllIIlIll, this, "commands.gamerule.success", new Object[0]);
                break;
            }
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llIIIIlIllIIlI, final String[] llIIIIlIlIllIl, final BlockPos llIIIIlIllIIII) {
        if (llIIIIlIlIllIl.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llIIIIlIlIllIl, this.getGameRules().getRules());
        }
        if (llIIIIlIlIllIl.length == 2) {
            final GameRules llIIIIlIlIllll = this.getGameRules();
            if (llIIIIlIlIllll.areSameType(llIIIIlIlIllIl[0], GameRules.ValueType.BOOLEAN_VALUE)) {
                return CommandBase.getListOfStringsMatchingLastWord(llIIIIlIlIllIl, "true", "false");
            }
        }
        return null;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llIIIIllIllIll) {
        return "commands.gamerule.usage";
    }
    
    private GameRules getGameRules() {
        return MinecraftServer.getServer().worldServerForDimension(0).getGameRules();
    }
    
    @Override
    public String getCommandName() {
        return "gamerule";
    }
    
    static {
        __OBFID = "CL_00000475";
    }
}
