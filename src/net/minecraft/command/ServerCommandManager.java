package net.minecraft.command;

import net.minecraft.command.common.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.command.server.*;
import java.util.*;

public class ServerCommandManager extends CommandHandler implements IAdminCommand
{
    static {
        __OBFID = "CL_00000922";
    }
    
    public ServerCommandManager() {
        this.registerCommand(new CommandTime());
        this.registerCommand(new CommandGameMode());
        this.registerCommand(new CommandDifficulty());
        this.registerCommand(new CommandDefaultGameMode());
        this.registerCommand(new CommandKill());
        this.registerCommand(new CommandToggleDownfall());
        this.registerCommand(new CommandWeather());
        this.registerCommand(new CommandXP());
        this.registerCommand(new CommandTeleport());
        this.registerCommand(new CommandGive());
        this.registerCommand(new CommandReplaceItem());
        this.registerCommand(new CommandStats());
        this.registerCommand(new CommandEffect());
        this.registerCommand(new CommandEnchant());
        this.registerCommand(new CommandParticle());
        this.registerCommand(new CommandEmote());
        this.registerCommand(new CommandShowSeed());
        this.registerCommand(new CommandHelp());
        this.registerCommand(new CommandDebug());
        this.registerCommand(new CommandMessage());
        this.registerCommand(new CommandBroadcast());
        this.registerCommand(new CommandSetSpawnpoint());
        this.registerCommand(new CommandSetDefaultSpawnpoint());
        this.registerCommand(new CommandGameRule());
        this.registerCommand(new CommandClearInventory());
        this.registerCommand(new CommandTestFor());
        this.registerCommand(new CommandSpreadPlayers());
        this.registerCommand(new CommandPlaySound());
        this.registerCommand(new CommandScoreboard());
        this.registerCommand(new CommandExecuteAt());
        this.registerCommand(new CommandTrigger());
        this.registerCommand(new CommandAchievement());
        this.registerCommand(new CommandSummon());
        this.registerCommand(new CommandSetBlock());
        this.registerCommand(new CommandFill());
        this.registerCommand(new CommandClone());
        this.registerCommand(new CommandCompare());
        this.registerCommand(new CommandBlockData());
        this.registerCommand(new CommandTestForBlock());
        this.registerCommand(new CommandMessageRaw());
        this.registerCommand(new CommandWorldBorder());
        this.registerCommand(new CommandTitle());
        this.registerCommand(new CommandEntityData());
        if (MinecraftServer.getServer().isDedicatedServer()) {
            this.registerCommand(new CommandOp());
            this.registerCommand(new CommandDeOp());
            this.registerCommand(new CommandStop());
            this.registerCommand(new CommandSaveAll());
            this.registerCommand(new CommandSaveOff());
            this.registerCommand(new CommandSaveOn());
            this.registerCommand(new CommandBanIp());
            this.registerCommand(new CommandPardonIp());
            this.registerCommand(new CommandBanPlayer());
            this.registerCommand(new CommandListBans());
            this.registerCommand(new CommandPardonPlayer());
            this.registerCommand(new CommandServerKick());
            this.registerCommand(new CommandListPlayers());
            this.registerCommand(new CommandWhitelist());
            this.registerCommand(new CommandSetPlayerTimeout());
        }
        else {
            this.registerCommand(new CommandPublishLocalServer());
        }
        CommandBase.setAdminCommander(this);
    }
    
    @Override
    public void notifyOperators(final ICommandSender lllllllllllllllllllllIllIIIlllII, final ICommand lllllllllllllllllllllIllIIIllIll, final int lllllllllllllllllllllIllIIIIllll, final String lllllllllllllllllllllIllIIIIlllI, final Object... lllllllllllllllllllllIllIIIllIII) {
        boolean lllllllllllllllllllllIllIIIlIlll = true;
        final MinecraftServer lllllllllllllllllllllIllIIIlIllI = MinecraftServer.getServer();
        if (!lllllllllllllllllllllIllIIIlllII.sendCommandFeedback()) {
            lllllllllllllllllllllIllIIIlIlll = false;
        }
        final ChatComponentTranslation lllllllllllllllllllllIllIIIlIlIl = new ChatComponentTranslation("chat.type.admin", new Object[] { lllllllllllllllllllllIllIIIlllII.getName(), new ChatComponentTranslation(lllllllllllllllllllllIllIIIIlllI, lllllllllllllllllllllIllIIIllIII) });
        lllllllllllllllllllllIllIIIlIlIl.getChatStyle().setColor(EnumChatFormatting.GRAY);
        lllllllllllllllllllllIllIIIlIlIl.getChatStyle().setItalic(true);
        if (lllllllllllllllllllllIllIIIlIlll) {
            for (final EntityPlayer lllllllllllllllllllllIllIIIlIIll : lllllllllllllllllllllIllIIIlIllI.getConfigurationManager().playerEntityList) {
                if (lllllllllllllllllllllIllIIIlIIll != lllllllllllllllllllllIllIIIlllII && lllllllllllllllllllllIllIIIlIllI.getConfigurationManager().canSendCommands(lllllllllllllllllllllIllIIIlIIll.getGameProfile()) && lllllllllllllllllllllIllIIIllIll.canCommandSenderUseCommand(lllllllllllllllllllllIllIIIlllII)) {
                    lllllllllllllllllllllIllIIIlIIll.addChatMessage(lllllllllllllllllllllIllIIIlIlIl);
                }
            }
        }
        if (lllllllllllllllllllllIllIIIlllII != lllllllllllllllllllllIllIIIlIllI && lllllllllllllllllllllIllIIIlIllI.worldServers[0].getGameRules().getGameRuleBooleanValue("logAdminCommands")) {
            lllllllllllllllllllllIllIIIlIllI.addChatMessage(lllllllllllllllllllllIllIIIlIlIl);
        }
        boolean lllllllllllllllllllllIllIIIlIIlI = lllllllllllllllllllllIllIIIlIllI.worldServers[0].getGameRules().getGameRuleBooleanValue("sendCommandFeedback");
        if (lllllllllllllllllllllIllIIIlllII instanceof CommandBlockLogic) {
            lllllllllllllllllllllIllIIIlIIlI = ((CommandBlockLogic)lllllllllllllllllllllIllIIIlllII).func_175571_m();
        }
        if ((lllllllllllllllllllllIllIIIIllll & 0x1) != 0x1 && lllllllllllllllllllllIllIIIlIIlI) {
            lllllllllllllllllllllIllIIIlllII.addChatMessage(new ChatComponentTranslation(lllllllllllllllllllllIllIIIIlllI, lllllllllllllllllllllIllIIIllIII));
        }
    }
}
