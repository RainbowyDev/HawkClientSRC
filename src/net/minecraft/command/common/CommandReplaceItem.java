package net.minecraft.command.common;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.command.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.server.*;
import java.util.*;
import com.google.common.collect.*;

public class CommandReplaceItem extends CommandBase
{
    private static final /* synthetic */ Map field_175785_a;
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIIIIIllIIlIIlllIll, final String[] llllllllllllllIIIIIllIIlIIlllIlI) throws CommandException {
        if (llllllllllllllIIIIIllIIlIIlllIlI.length < 1) {
            throw new WrongUsageException("commands.replaceitem.usage", new Object[0]);
        }
        boolean llllllllllllllIIIIIllIIlIlIIlllI = false;
        if (llllllllllllllIIIIIllIIlIIlllIlI[0].equals("entity")) {
            final boolean llllllllllllllIIIIIllIIlIlIIllll = false;
        }
        else {
            if (!llllllllllllllIIIIIllIIlIIlllIlI[0].equals("block")) {
                throw new WrongUsageException("commands.replaceitem.usage", new Object[0]);
            }
            llllllllllllllIIIIIllIIlIlIIlllI = true;
        }
        byte llllllllllllllIIIIIllIIlIlIIllII = 0;
        if (llllllllllllllIIIIIllIIlIlIIlllI) {
            if (llllllllllllllIIIIIllIIlIIlllIlI.length < 6) {
                throw new WrongUsageException("commands.replaceitem.block.usage", new Object[0]);
            }
            final byte llllllllllllllIIIIIllIIlIlIIllIl = 4;
        }
        else {
            if (llllllllllllllIIIIIllIIlIIlllIlI.length < 4) {
                throw new WrongUsageException("commands.replaceitem.entity.usage", new Object[0]);
            }
            llllllllllllllIIIIIllIIlIlIIllII = 2;
        }
        int llllllllllllllIIIIIllIIlIlIIlIll = llllllllllllllIIIIIllIIlIlIIllII + 1;
        final int llllllllllllllIIIIIllIIlIlIIlIlI = this.func_175783_e(llllllllllllllIIIIIllIIlIIlllIlI[llllllllllllllIIIIIllIIlIlIIllII]);
        Item llllllllllllllIIIIIllIIlIlIIlIII = null;
        try {
            final Item llllllllllllllIIIIIllIIlIlIIlIIl = CommandBase.getItemByText(llllllllllllllIIIIIllIIlIIlllIll, llllllllllllllIIIIIllIIlIIlllIlI[llllllllllllllIIIIIllIIlIlIIlIll]);
        }
        catch (NumberInvalidException llllllllllllllIIIIIllIIlIlIIIlll) {
            if (Block.getBlockFromName(llllllllllllllIIIIIllIIlIIlllIlI[llllllllllllllIIIIIllIIlIlIIlIll]) != Blocks.air) {
                throw llllllllllllllIIIIIllIIlIlIIIlll;
            }
            llllllllllllllIIIIIllIIlIlIIlIII = null;
        }
        ++llllllllllllllIIIIIllIIlIlIIlIll;
        final int llllllllllllllIIIIIllIIlIlIIIllI = (llllllllllllllIIIIIllIIlIIlllIlI.length > llllllllllllllIIIIIllIIlIlIIlIll) ? CommandBase.parseInt(llllllllllllllIIIIIllIIlIIlllIlI[llllllllllllllIIIIIllIIlIlIIlIll++], 1, 64) : 1;
        final int llllllllllllllIIIIIllIIlIlIIIlIl = (llllllllllllllIIIIIllIIlIIlllIlI.length > llllllllllllllIIIIIllIIlIlIIlIll) ? CommandBase.parseInt(llllllllllllllIIIIIllIIlIIlllIlI[llllllllllllllIIIIIllIIlIlIIlIll++]) : 0;
        ItemStack llllllllllllllIIIIIllIIlIlIIIlII = new ItemStack(llllllllllllllIIIIIllIIlIlIIlIII, llllllllllllllIIIIIllIIlIlIIIllI, llllllllllllllIIIIIllIIlIlIIIlIl);
        if (llllllllllllllIIIIIllIIlIIlllIlI.length > llllllllllllllIIIIIllIIlIlIIlIll) {
            final String llllllllllllllIIIIIllIIlIlIIIIll = CommandBase.getChatComponentFromNthArg(llllllllllllllIIIIIllIIlIIlllIll, llllllllllllllIIIIIllIIlIIlllIlI, llllllllllllllIIIIIllIIlIlIIlIll).getUnformattedText();
            try {
                llllllllllllllIIIIIllIIlIlIIIlII.setTagCompound(JsonToNBT.func_180713_a(llllllllllllllIIIIIllIIlIlIIIIll));
            }
            catch (NBTException llllllllllllllIIIIIllIIlIlIIIIlI) {
                throw new CommandException("commands.replaceitem.tagError", new Object[] { llllllllllllllIIIIIllIIlIlIIIIlI.getMessage() });
            }
        }
        if (llllllllllllllIIIIIllIIlIlIIIlII.getItem() == null) {
            llllllllllllllIIIIIllIIlIlIIIlII = null;
        }
        if (llllllllllllllIIIIIllIIlIlIIlllI) {
            llllllllllllllIIIIIllIIlIIlllIll.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, 0);
            final BlockPos llllllllllllllIIIIIllIIlIlIIIIIl = CommandBase.func_175757_a(llllllllllllllIIIIIllIIlIIlllIll, llllllllllllllIIIIIllIIlIIlllIlI, 1, false);
            final World llllllllllllllIIIIIllIIlIlIIIIII = llllllllllllllIIIIIllIIlIIlllIll.getEntityWorld();
            final TileEntity llllllllllllllIIIIIllIIlIIllllll = llllllllllllllIIIIIllIIlIlIIIIII.getTileEntity(llllllllllllllIIIIIllIIlIlIIIIIl);
            if (llllllllllllllIIIIIllIIlIIllllll == null || !(llllllllllllllIIIIIllIIlIIllllll instanceof IInventory)) {
                throw new CommandException("commands.replaceitem.noContainer", new Object[] { llllllllllllllIIIIIllIIlIlIIIIIl.getX(), llllllllllllllIIIIIllIIlIlIIIIIl.getY(), llllllllllllllIIIIIllIIlIlIIIIIl.getZ() });
            }
            final IInventory llllllllllllllIIIIIllIIlIIlllllI = (IInventory)llllllllllllllIIIIIllIIlIIllllll;
            if (llllllllllllllIIIIIllIIlIlIIlIlI >= 0 && llllllllllllllIIIIIllIIlIlIIlIlI < llllllllllllllIIIIIllIIlIIlllllI.getSizeInventory()) {
                llllllllllllllIIIIIllIIlIIlllllI.setInventorySlotContents(llllllllllllllIIIIIllIIlIlIIlIlI, llllllllllllllIIIIIllIIlIlIIIlII);
            }
        }
        else {
            final Entity llllllllllllllIIIIIllIIlIIllllIl = CommandBase.func_175768_b(llllllllllllllIIIIIllIIlIIlllIll, llllllllllllllIIIIIllIIlIIlllIlI[1]);
            llllllllllllllIIIIIllIIlIIlllIll.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, 0);
            if (llllllllllllllIIIIIllIIlIIllllIl instanceof EntityPlayer) {
                ((EntityPlayer)llllllllllllllIIIIIllIIlIIllllIl).inventoryContainer.detectAndSendChanges();
            }
            if (!llllllllllllllIIIIIllIIlIIllllIl.func_174820_d(llllllllllllllIIIIIllIIlIlIIlIlI, llllllllllllllIIIIIllIIlIlIIIlII)) {
                throw new CommandException("commands.replaceitem.failed", new Object[] { llllllllllllllIIIIIllIIlIlIIlIlI, llllllllllllllIIIIIllIIlIlIIIllI, (llllllllllllllIIIIIllIIlIlIIIlII == null) ? "Air" : llllllllllllllIIIIIllIIlIlIIIlII.getChatComponent() });
            }
            if (llllllllllllllIIIIIllIIlIIllllIl instanceof EntityPlayer) {
                ((EntityPlayer)llllllllllllllIIIIIllIIlIIllllIl).inventoryContainer.detectAndSendChanges();
            }
        }
        llllllllllllllIIIIIllIIlIIlllIll.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, llllllllllllllIIIIIllIIlIlIIIllI);
        CommandBase.notifyOperators(llllllllllllllIIIIIllIIlIIlllIll, this, "commands.replaceitem.success", llllllllllllllIIIIIllIIlIlIIlIlI, llllllllllllllIIIIIllIIlIlIIIllI, (llllllllllllllIIIIIllIIlIlIIIlII == null) ? "Air" : llllllllllllllIIIIIllIIlIlIIIlII.getChatComponent());
    }
    
    protected String[] func_175784_d() {
        return MinecraftServer.getServer().getAllUsernames();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIIIIllIIlIllIIIlI) {
        return "commands.replaceitem.usage";
    }
    
    @Override
    public String getCommandName() {
        return "replaceitem";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIIIIIllIIlIIlIIllI, final String[] llllllllllllllIIIIIllIIlIIlIIIlI, final BlockPos llllllllllllllIIIIIllIIlIIlIIlII) {
        return (llllllllllllllIIIIIllIIlIIlIIIlI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIIIIllIIlIIlIIIlI, "entity", "block") : ((llllllllllllllIIIIIllIIlIIlIIIlI.length == 2 && llllllllllllllIIIIIllIIlIIlIIIlI[0].equals("entity")) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIIIIllIIlIIlIIIlI, this.func_175784_d()) : (((llllllllllllllIIIIIllIIlIIlIIIlI.length != 3 || !llllllllllllllIIIIIllIIlIIlIIIlI[0].equals("entity")) && (llllllllllllllIIIIIllIIlIIlIIIlI.length != 5 || !llllllllllllllIIIIIllIIlIIlIIIlI[0].equals("block"))) ? (((llllllllllllllIIIIIllIIlIIlIIIlI.length != 4 || !llllllllllllllIIIIIllIIlIIlIIIlI[0].equals("entity")) && (llllllllllllllIIIIIllIIlIIlIIIlI.length != 6 || !llllllllllllllIIIIIllIIlIIlIIIlI[0].equals("block"))) ? null : CommandBase.func_175762_a(llllllllllllllIIIIIllIIlIIlIIIlI, Item.itemRegistry.getKeys())) : CommandBase.func_175762_a(llllllllllllllIIIIIllIIlIIlIIIlI, CommandReplaceItem.field_175785_a.keySet())));
    }
    
    private int func_175783_e(final String llllllllllllllIIIIIllIIlIIlIlIlI) throws CommandException {
        if (!CommandReplaceItem.field_175785_a.containsKey(llllllllllllllIIIIIllIIlIIlIlIlI)) {
            throw new CommandException("commands.generic.parameter.invalid", new Object[] { llllllllllllllIIIIIllIIlIIlIlIlI });
        }
        return CommandReplaceItem.field_175785_a.get(llllllllllllllIIIIIllIIlIIlIlIlI);
    }
    
    static {
        __OBFID = "CL_00002340";
        field_175785_a = Maps.newHashMap();
        for (int llllllllllllllIIIIIllIIlIllIlIlI = 0; llllllllllllllIIIIIllIIlIllIlIlI < 54; ++llllllllllllllIIIIIllIIlIllIlIlI) {
            CommandReplaceItem.field_175785_a.put(String.valueOf(new StringBuilder("slot.container.").append(llllllllllllllIIIIIllIIlIllIlIlI)), llllllllllllllIIIIIllIIlIllIlIlI);
        }
        for (int llllllllllllllIIIIIllIIlIllIlIlI = 0; llllllllllllllIIIIIllIIlIllIlIlI < 9; ++llllllllllllllIIIIIllIIlIllIlIlI) {
            CommandReplaceItem.field_175785_a.put(String.valueOf(new StringBuilder("slot.hotbar.").append(llllllllllllllIIIIIllIIlIllIlIlI)), llllllllllllllIIIIIllIIlIllIlIlI);
        }
        for (int llllllllllllllIIIIIllIIlIllIlIlI = 0; llllllllllllllIIIIIllIIlIllIlIlI < 27; ++llllllllllllllIIIIIllIIlIllIlIlI) {
            CommandReplaceItem.field_175785_a.put(String.valueOf(new StringBuilder("slot.inventory.").append(llllllllllllllIIIIIllIIlIllIlIlI)), 9 + llllllllllllllIIIIIllIIlIllIlIlI);
        }
        for (int llllllllllllllIIIIIllIIlIllIlIlI = 0; llllllllllllllIIIIIllIIlIllIlIlI < 27; ++llllllllllllllIIIIIllIIlIllIlIlI) {
            CommandReplaceItem.field_175785_a.put(String.valueOf(new StringBuilder("slot.enderchest.").append(llllllllllllllIIIIIllIIlIllIlIlI)), 200 + llllllllllllllIIIIIllIIlIllIlIlI);
        }
        for (int llllllllllllllIIIIIllIIlIllIlIlI = 0; llllllllllllllIIIIIllIIlIllIlIlI < 8; ++llllllllllllllIIIIIllIIlIllIlIlI) {
            CommandReplaceItem.field_175785_a.put(String.valueOf(new StringBuilder("slot.villager.").append(llllllllllllllIIIIIllIIlIllIlIlI)), 300 + llllllllllllllIIIIIllIIlIllIlIlI);
        }
        for (int llllllllllllllIIIIIllIIlIllIlIlI = 0; llllllllllllllIIIIIllIIlIllIlIlI < 15; ++llllllllllllllIIIIIllIIlIllIlIlI) {
            CommandReplaceItem.field_175785_a.put(String.valueOf(new StringBuilder("slot.horse.").append(llllllllllllllIIIIIllIIlIllIlIlI)), 500 + llllllllllllllIIIIIllIIlIllIlIlI);
        }
        CommandReplaceItem.field_175785_a.put("slot.weapon", 99);
        CommandReplaceItem.field_175785_a.put("slot.armor.head", 103);
        CommandReplaceItem.field_175785_a.put("slot.armor.chest", 102);
        CommandReplaceItem.field_175785_a.put("slot.armor.legs", 101);
        CommandReplaceItem.field_175785_a.put("slot.armor.feet", 100);
        CommandReplaceItem.field_175785_a.put("slot.horse.saddle", 400);
        CommandReplaceItem.field_175785_a.put("slot.horse.armor", 401);
        CommandReplaceItem.field_175785_a.put("slot.horse.chest", 499);
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIIIIIllIIlIIIlllIl, final int llllllllllllllIIIIIllIIlIIIllIlI) {
        return llllllllllllllIIIIIllIIlIIIlllIl.length > 0 && llllllllllllllIIIIIllIIlIIIlllIl[0].equals("entity") && llllllllllllllIIIIIllIIlIIIllIlI == 1;
    }
}
