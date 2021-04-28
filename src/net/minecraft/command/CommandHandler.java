package net.minecraft.command;

import org.apache.logging.log4j.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.*;
import com.google.common.collect.*;

public class CommandHandler implements ICommandManager
{
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ Map commandMap;
    private final /* synthetic */ Set commandSet;
    
    static {
        __OBFID = "CL_00001765";
        logger = LogManager.getLogger();
    }
    
    @Override
    public int executeCommand(final ICommandSender lIlIIIlIlIl, String lIlIIIIIllI) {
        lIlIIIIIllI = lIlIIIIIllI.trim();
        if (lIlIIIIIllI.startsWith("/")) {
            lIlIIIIIllI = lIlIIIIIllI.substring(1);
        }
        String[] lIlIIIlIIll = lIlIIIIIllI.split(" ");
        final String lIlIIIlIIlI = lIlIIIlIIll[0];
        lIlIIIlIIll = dropFirstString(lIlIIIlIIll);
        final ICommand lIlIIIlIIIl = this.commandMap.get(lIlIIIlIIlI);
        final int lIlIIIlIIII = this.getUsernameIndex(lIlIIIlIIIl, lIlIIIlIIll);
        int lIlIIIIllll = 0;
        if (lIlIIIlIIIl == null) {
            final ChatComponentTranslation lIlIIIIlllI = new ChatComponentTranslation("commands.generic.notFound", new Object[0]);
            lIlIIIIlllI.getChatStyle().setColor(EnumChatFormatting.RED);
            lIlIIIlIlIl.addChatMessage(lIlIIIIlllI);
        }
        else if (lIlIIIlIIIl.canCommandSenderUseCommand(lIlIIIlIlIl)) {
            if (lIlIIIlIIII > -1) {
                final List lIlIIIIllII = PlayerSelector.func_179656_b(lIlIIIlIlIl, lIlIIIlIIll[lIlIIIlIIII], Entity.class);
                final String lIlIIIIlIll = lIlIIIlIIll[lIlIIIlIIII];
                lIlIIIlIlIl.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, lIlIIIIllII.size());
                for (final Entity lIlIIIIlIIl : lIlIIIIllII) {
                    lIlIIIlIIll[lIlIIIlIIII] = lIlIIIIlIIl.getUniqueID().toString();
                    if (this.func_175786_a(lIlIIIlIlIl, lIlIIIlIIll, lIlIIIlIIIl, lIlIIIIIllI)) {
                        ++lIlIIIIllll;
                    }
                }
                lIlIIIlIIll[lIlIIIlIIII] = lIlIIIIlIll;
            }
            else {
                lIlIIIlIlIl.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, 1);
                if (this.func_175786_a(lIlIIIlIlIl, lIlIIIlIIll, lIlIIIlIIIl, lIlIIIIIllI)) {
                    ++lIlIIIIllll;
                }
            }
        }
        else {
            final ChatComponentTranslation lIlIIIIllIl = new ChatComponentTranslation("commands.generic.permission", new Object[0]);
            lIlIIIIllIl.getChatStyle().setColor(EnumChatFormatting.RED);
            lIlIIIlIlIl.addChatMessage(lIlIIIIllIl);
        }
        lIlIIIlIlIl.func_174794_a(CommandResultStats.Type.SUCCESS_COUNT, lIlIIIIllll);
        return lIlIIIIllll;
    }
    
    @Override
    public List getPossibleCommands(final ICommandSender lIIlIlIllIl) {
        final ArrayList lIIlIlIllII = Lists.newArrayList();
        for (final ICommand lIIlIlIlIlI : this.commandSet) {
            if (lIIlIlIlIlI.canCommandSenderUseCommand(lIIlIlIllIl)) {
                lIIlIlIllII.add(lIIlIlIlIlI);
            }
        }
        return lIIlIlIllII;
    }
    
    @Override
    public List getTabCompletionOptions(final ICommandSender lIIllIIIlIl, final String lIIllIIIlII, final BlockPos lIIllIIIIll) {
        final String[] lIIllIIIIlI = lIIllIIIlII.split(" ", -1);
        final String lIIllIIIIIl = lIIllIIIIlI[0];
        if (lIIllIIIIlI.length == 1) {
            final ArrayList lIIllIIIIII = Lists.newArrayList();
            for (final Map.Entry lIIlIlllllI : this.commandMap.entrySet()) {
                if (CommandBase.doesStringStartWith(lIIllIIIIIl, lIIlIlllllI.getKey()) && lIIlIlllllI.getValue().canCommandSenderUseCommand(lIIllIIIlIl)) {
                    lIIllIIIIII.add(lIIlIlllllI.getKey());
                }
            }
            return lIIllIIIIII;
        }
        if (lIIllIIIIlI.length > 1) {
            final ICommand lIIlIllllIl = this.commandMap.get(lIIllIIIIIl);
            if (lIIlIllllIl != null && lIIlIllllIl.canCommandSenderUseCommand(lIIllIIIlIl)) {
                return lIIlIllllIl.addTabCompletionOptions(lIIllIIIlIl, dropFirstString(lIIllIIIIlI), lIIllIIIIll);
            }
        }
        return null;
    }
    
    public CommandHandler() {
        this.commandMap = Maps.newHashMap();
        this.commandSet = Sets.newHashSet();
    }
    
    private int getUsernameIndex(final ICommand lIIlIIllIlI, final String[] lIIlIIlllII) {
        if (lIIlIIllIlI == null) {
            return -1;
        }
        for (int lIIlIIllIll = 0; lIIlIIllIll < lIIlIIlllII.length; ++lIIlIIllIll) {
            if (lIIlIIllIlI.isUsernameIndex(lIIlIIlllII, lIIlIIllIll) && PlayerSelector.matchesMultiplePlayers(lIIlIIlllII[lIIlIIllIll])) {
                return lIIlIIllIll;
            }
        }
        return -1;
    }
    
    public ICommand registerCommand(final ICommand lIIllIllllI) {
        this.commandMap.put(lIIllIllllI.getCommandName(), lIIllIllllI);
        this.commandSet.add(lIIllIllllI);
        for (final String lIIllIlllII : lIIllIllllI.getCommandAliases()) {
            final ICommand lIIllIllIll = this.commandMap.get(lIIllIlllII);
            if (lIIllIllIll == null || !lIIllIllIll.getCommandName().equals(lIIllIlllII)) {
                this.commandMap.put(lIIllIlllII, lIIllIllllI);
            }
        }
        return lIIllIllllI;
    }
    
    protected boolean func_175786_a(final ICommandSender lIIlllIlIlI, final String[] lIIllllIIll, final ICommand lIIllllIIlI, final String lIIlllIIlll) {
        try {
            lIIllllIIlI.processCommand(lIIlllIlIlI, lIIllllIIll);
            return true;
        }
        catch (WrongUsageException lIIlllIllIl) {
            final ChatComponentTranslation lIIllllIIII = new ChatComponentTranslation("commands.generic.usage", new Object[] { new ChatComponentTranslation(lIIlllIllIl.getMessage(), lIIlllIllIl.getErrorOjbects()) });
            lIIllllIIII.getChatStyle().setColor(EnumChatFormatting.RED);
            lIIlllIlIlI.addChatMessage(lIIllllIIII);
        }
        catch (CommandException lIIlllIllII) {
            final ChatComponentTranslation lIIlllIllll = new ChatComponentTranslation(lIIlllIllII.getMessage(), lIIlllIllII.getErrorOjbects());
            lIIlllIllll.getChatStyle().setColor(EnumChatFormatting.RED);
            lIIlllIlIlI.addChatMessage(lIIlllIllll);
        }
        catch (Throwable lIIlllIlIll) {
            final ChatComponentTranslation lIIlllIlllI = new ChatComponentTranslation("commands.generic.exception", new Object[0]);
            lIIlllIlllI.getChatStyle().setColor(EnumChatFormatting.RED);
            lIIlllIlIlI.addChatMessage(lIIlllIlllI);
            CommandHandler.logger.error(String.valueOf(new StringBuilder("Couldn't process command: '").append(lIIlllIIlll).append("'")), lIIlllIlIll);
        }
        return false;
    }
    
    @Override
    public Map getCommands() {
        return this.commandMap;
    }
    
    private static String[] dropFirstString(final String[] lIIllIlIIll) {
        final String[] lIIllIlIIlI = new String[lIIllIlIIll.length - 1];
        System.arraycopy(lIIllIlIIll, 1, lIIllIlIIlI, 0, lIIllIlIIll.length - 1);
        return lIIllIlIIlI;
    }
}
