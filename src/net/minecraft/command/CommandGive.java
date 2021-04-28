package net.minecraft.command;

import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandGive extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIlIllIlIlIllIIlIII, final int llllllllllllllIlIllIlIlIllIIIlll) {
        return llllllllllllllIlIllIlIlIllIIIlll == 0;
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIllIlIlIllllIllI, final String[] llllllllllllllIlIllIlIlIllllIlIl) throws CommandException {
        if (llllllllllllllIlIllIlIlIllllIlIl.length < 2) {
            throw new WrongUsageException("commands.give.usage", new Object[0]);
        }
        final EntityPlayerMP llllllllllllllIlIllIlIllIIIIIIll = CommandBase.getPlayer(llllllllllllllIlIllIlIlIllllIllI, llllllllllllllIlIllIlIlIllllIlIl[0]);
        final Item llllllllllllllIlIllIlIllIIIIIIlI = CommandBase.getItemByText(llllllllllllllIlIllIlIlIllllIllI, llllllllllllllIlIllIlIlIllllIlIl[1]);
        final int llllllllllllllIlIllIlIllIIIIIIIl = (llllllllllllllIlIllIlIlIllllIlIl.length >= 3) ? CommandBase.parseInt(llllllllllllllIlIllIlIlIllllIlIl[2], 1, 64) : 1;
        final int llllllllllllllIlIllIlIllIIIIIIII = (llllllllllllllIlIllIlIlIllllIlIl.length >= 4) ? CommandBase.parseInt(llllllllllllllIlIllIlIlIllllIlIl[3]) : 0;
        final ItemStack llllllllllllllIlIllIlIlIllllllll = new ItemStack(llllllllllllllIlIllIlIllIIIIIIlI, llllllllllllllIlIllIlIllIIIIIIIl, llllllllllllllIlIllIlIllIIIIIIII);
        if (llllllllllllllIlIllIlIlIllllIlIl.length >= 5) {
            final String llllllllllllllIlIllIlIlIlllllllI = CommandBase.getChatComponentFromNthArg(llllllllllllllIlIllIlIlIllllIllI, llllllllllllllIlIllIlIlIllllIlIl, 4).getUnformattedText();
            try {
                llllllllllllllIlIllIlIlIllllllll.setTagCompound(JsonToNBT.func_180713_a(llllllllllllllIlIllIlIlIlllllllI));
            }
            catch (NBTException llllllllllllllIlIllIlIlIllllllIl) {
                throw new CommandException("commands.give.tagError", new Object[] { llllllllllllllIlIllIlIlIllllllIl.getMessage() });
            }
        }
        final boolean llllllllllllllIlIllIlIlIllllllII = llllllllllllllIlIllIlIllIIIIIIll.inventory.addItemStackToInventory(llllllllllllllIlIllIlIlIllllllll);
        if (llllllllllllllIlIllIlIlIllllllII) {
            llllllllllllllIlIllIlIllIIIIIIll.worldObj.playSoundAtEntity(llllllllllllllIlIllIlIllIIIIIIll, "random.pop", 0.2f, ((llllllllllllllIlIllIlIllIIIIIIll.getRNG().nextFloat() - llllllllllllllIlIllIlIllIIIIIIll.getRNG().nextFloat()) * 0.7f + 1.0f) * 2.0f);
            llllllllllllllIlIllIlIllIIIIIIll.inventoryContainer.detectAndSendChanges();
        }
        if (llllllllllllllIlIllIlIlIllllllII && llllllllllllllIlIllIlIlIllllllll.stackSize <= 0) {
            llllllllllllllIlIllIlIlIllllllll.stackSize = 1;
            llllllllllllllIlIllIlIlIllllIllI.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, llllllllllllllIlIllIlIllIIIIIIIl);
            final EntityItem llllllllllllllIlIllIlIlIlllllIll = llllllllllllllIlIllIlIllIIIIIIll.dropPlayerItemWithRandomChoice(llllllllllllllIlIllIlIlIllllllll, false);
            if (llllllllllllllIlIllIlIlIlllllIll != null) {
                llllllllllllllIlIllIlIlIlllllIll.func_174870_v();
            }
        }
        else {
            llllllllllllllIlIllIlIlIllllIllI.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, llllllllllllllIlIllIlIllIIIIIIIl - llllllllllllllIlIllIlIlIllllllll.stackSize);
            final EntityItem llllllllllllllIlIllIlIlIlllllIIl = llllllllllllllIlIllIlIllIIIIIIll.dropPlayerItemWithRandomChoice(llllllllllllllIlIllIlIlIllllllll, false);
            if (llllllllllllllIlIllIlIlIlllllIIl != null) {
                llllllllllllllIlIllIlIlIlllllIIl.setNoPickupDelay();
                llllllllllllllIlIllIlIlIlllllIIl.setOwner(llllllllllllllIlIllIlIllIIIIIIll.getName());
            }
        }
        CommandBase.notifyOperators(llllllllllllllIlIllIlIlIllllIllI, this, "commands.give.success", llllllllllllllIlIllIlIlIllllllll.getChatComponent(), llllllllllllllIlIllIlIllIIIIIIIl, llllllllllllllIlIllIlIllIIIIIIll.getName());
    }
    
    static {
        __OBFID = "CL_00000502";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    protected String[] getPlayers() {
        return MinecraftServer.getServer().getAllUsernames();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIllIlIllIIIlIIlI) {
        return "commands.give.usage";
    }
    
    @Override
    public String getCommandName() {
        return "give";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIlIllIlIlIllIllIll, final String[] llllllllllllllIlIllIlIlIllIlIIll, final BlockPos llllllllllllllIlIllIlIlIllIlIlll) {
        return (llllllllllllllIlIllIlIlIllIlIIll.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIllIlIlIllIlIIll, this.getPlayers()) : ((llllllllllllllIlIllIlIlIllIlIIll.length == 2) ? CommandBase.func_175762_a(llllllllllllllIlIllIlIlIllIlIIll, Item.itemRegistry.getKeys()) : null);
    }
}
