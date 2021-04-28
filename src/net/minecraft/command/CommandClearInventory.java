package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;

public class CommandClearInventory extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllIlIlIIllIIIIIIIll, final int lllllllllllllllIlIlIIllIIIIIIIIl) {
        return lllllllllllllllIlIlIIllIIIIIIIIl == 0;
    }
    
    @Override
    public String getCommandName() {
        return "clear";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    static {
        __OBFID = "CL_00000218";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIlIlIIllIIIlIllII) {
        return "commands.clear.usage";
    }
    
    protected String[] func_147209_d() {
        return MinecraftServer.getServer().getAllUsernames();
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIlIlIIllIIIIIlIll, final String[] lllllllllllllllIlIlIIllIIIIIIlll, final BlockPos lllllllllllllllIlIlIIllIIIIIlIIl) {
        return (lllllllllllllllIlIlIIllIIIIIIlll.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIlIlIIllIIIIIIlll, this.func_147209_d()) : ((lllllllllllllllIlIlIIllIIIIIIlll.length == 2) ? CommandBase.func_175762_a(lllllllllllllllIlIlIIllIIIIIIlll, Item.itemRegistry.getKeys()) : null);
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIlIlIIllIIIlIIIII, final String[] lllllllllllllllIlIlIIllIIIIlllll) throws CommandException {
        final EntityPlayerMP lllllllllllllllIlIlIIllIIIIllllI = (lllllllllllllllIlIlIIllIIIIlllll.length == 0) ? CommandBase.getCommandSenderAsPlayer(lllllllllllllllIlIlIIllIIIlIIIII) : CommandBase.getPlayer(lllllllllllllllIlIlIIllIIIlIIIII, lllllllllllllllIlIlIIllIIIIlllll[0]);
        final Item lllllllllllllllIlIlIIllIIIIlllIl = (lllllllllllllllIlIlIIllIIIIlllll.length >= 2) ? CommandBase.getItemByText(lllllllllllllllIlIlIIllIIIlIIIII, lllllllllllllllIlIlIIllIIIIlllll[1]) : null;
        final int lllllllllllllllIlIlIIllIIIIlllII = (lllllllllllllllIlIlIIllIIIIlllll.length >= 3) ? CommandBase.parseInt(lllllllllllllllIlIlIIllIIIIlllll[2], -1) : -1;
        final int lllllllllllllllIlIlIIllIIIIllIll = (lllllllllllllllIlIlIIllIIIIlllll.length >= 4) ? CommandBase.parseInt(lllllllllllllllIlIlIIllIIIIlllll[3], -1) : -1;
        NBTTagCompound lllllllllllllllIlIlIIllIIIIllIlI = null;
        if (lllllllllllllllIlIlIIllIIIIlllll.length >= 5) {
            try {
                lllllllllllllllIlIlIIllIIIIllIlI = JsonToNBT.func_180713_a(CommandBase.func_180529_a(lllllllllllllllIlIlIIllIIIIlllll, 4));
            }
            catch (NBTException lllllllllllllllIlIlIIllIIIIllIIl) {
                throw new CommandException("commands.clear.tagError", new Object[] { lllllllllllllllIlIlIIllIIIIllIIl.getMessage() });
            }
        }
        if (lllllllllllllllIlIlIIllIIIIlllll.length >= 2 && lllllllllllllllIlIlIIllIIIIlllIl == null) {
            throw new CommandException("commands.clear.failure", new Object[] { lllllllllllllllIlIlIIllIIIIllllI.getName() });
        }
        final int lllllllllllllllIlIlIIllIIIIllIII = lllllllllllllllIlIlIIllIIIIllllI.inventory.func_174925_a(lllllllllllllllIlIlIIllIIIIlllIl, lllllllllllllllIlIlIIllIIIIlllII, lllllllllllllllIlIlIIllIIIIllIll, lllllllllllllllIlIlIIllIIIIllIlI);
        lllllllllllllllIlIlIIllIIIIllllI.inventoryContainer.detectAndSendChanges();
        if (!lllllllllllllllIlIlIIllIIIIllllI.capabilities.isCreativeMode) {
            lllllllllllllllIlIlIIllIIIIllllI.updateHeldItem();
        }
        lllllllllllllllIlIlIIllIIIlIIIII.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, lllllllllllllllIlIlIIllIIIIllIII);
        if (lllllllllllllllIlIlIIllIIIIllIII == 0) {
            throw new CommandException("commands.clear.failure", new Object[] { lllllllllllllllIlIlIIllIIIIllllI.getName() });
        }
        if (lllllllllllllllIlIlIIllIIIIllIll == 0) {
            lllllllllllllllIlIlIIllIIIlIIIII.addChatMessage(new ChatComponentTranslation("commands.clear.testing", new Object[] { lllllllllllllllIlIlIIllIIIIllllI.getName(), lllllllllllllllIlIlIIllIIIIllIII }));
        }
        else {
            CommandBase.notifyOperators(lllllllllllllllIlIlIIllIIIlIIIII, this, "commands.clear.success", lllllllllllllllIlIlIIllIIIIllllI.getName(), lllllllllllllllIlIlIIllIIIIllIII);
        }
    }
}
