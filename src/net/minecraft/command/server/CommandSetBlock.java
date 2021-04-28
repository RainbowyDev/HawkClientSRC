package net.minecraft.command.server;

import net.minecraft.util.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.command.*;
import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;

public class CommandSetBlock extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIIIlIIlllIlIlIIl) {
        return "commands.setblock.usage";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllllIIIlIIllIlllllll, final String[] llllllllllllllllIIIlIIllIllllllI, final BlockPos llllllllllllllllIIIlIIllIllllIll) {
        return (llllllllllllllllIIIlIIllIllllllI.length > 0 && llllllllllllllllIIIlIIllIllllllI.length <= 3) ? CommandBase.func_175771_a(llllllllllllllllIIIlIIllIllllllI, 0, llllllllllllllllIIIlIIllIllllIll) : ((llllllllllllllllIIIlIIllIllllllI.length == 4) ? CommandBase.func_175762_a(llllllllllllllllIIIlIIllIllllllI, Block.blockRegistry.getKeys()) : ((llllllllllllllllIIIlIIllIllllllI.length == 6) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllIIIlIIllIllllllI, "replace", "destroy", "keep") : null));
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "setblock";
    }
    
    static {
        __OBFID = "CL_00000949";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllllIIIlIIlllIIIllIl, final String[] llllllllllllllllIIIlIIlllIIllIlI) throws CommandException {
        if (llllllllllllllllIIIlIIlllIIllIlI.length < 4) {
            throw new WrongUsageException("commands.setblock.usage", new Object[0]);
        }
        llllllllllllllllIIIlIIlllIIIllIl.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos llllllllllllllllIIIlIIlllIIllIIl = CommandBase.func_175757_a(llllllllllllllllIIIlIIlllIIIllIl, llllllllllllllllIIIlIIlllIIllIlI, 0, false);
        final Block llllllllllllllllIIIlIIlllIIllIII = CommandBase.getBlockByText(llllllllllllllllIIIlIIlllIIIllIl, llllllllllllllllIIIlIIlllIIllIlI[3]);
        int llllllllllllllllIIIlIIlllIIlIlll = 0;
        if (llllllllllllllllIIIlIIlllIIllIlI.length >= 5) {
            llllllllllllllllIIIlIIlllIIlIlll = CommandBase.parseInt(llllllllllllllllIIIlIIlllIIllIlI[4], 0, 15);
        }
        final World llllllllllllllllIIIlIIlllIIlIllI = llllllllllllllllIIIlIIlllIIIllIl.getEntityWorld();
        if (!llllllllllllllllIIIlIIlllIIlIllI.isBlockLoaded(llllllllllllllllIIIlIIlllIIllIIl)) {
            throw new CommandException("commands.setblock.outOfWorld", new Object[0]);
        }
        NBTTagCompound llllllllllllllllIIIlIIlllIIlIlIl = new NBTTagCompound();
        boolean llllllllllllllllIIIlIIlllIIlIlII = false;
        if (llllllllllllllllIIIlIIlllIIllIlI.length >= 7 && llllllllllllllllIIIlIIlllIIllIII.hasTileEntity()) {
            final String llllllllllllllllIIIlIIlllIIlIIll = CommandBase.getChatComponentFromNthArg(llllllllllllllllIIIlIIlllIIIllIl, llllllllllllllllIIIlIIlllIIllIlI, 6).getUnformattedText();
            try {
                llllllllllllllllIIIlIIlllIIlIlIl = JsonToNBT.func_180713_a(llllllllllllllllIIIlIIlllIIlIIll);
                llllllllllllllllIIIlIIlllIIlIlII = true;
            }
            catch (NBTException llllllllllllllllIIIlIIlllIIlIIlI) {
                throw new CommandException("commands.setblock.tagError", new Object[] { llllllllllllllllIIIlIIlllIIlIIlI.getMessage() });
            }
        }
        if (llllllllllllllllIIIlIIlllIIllIlI.length >= 6) {
            if (llllllllllllllllIIIlIIlllIIllIlI[5].equals("destroy")) {
                llllllllllllllllIIIlIIlllIIlIllI.destroyBlock(llllllllllllllllIIIlIIlllIIllIIl, true);
                if (llllllllllllllllIIIlIIlllIIllIII == Blocks.air) {
                    CommandBase.notifyOperators(llllllllllllllllIIIlIIlllIIIllIl, this, "commands.setblock.success", new Object[0]);
                    return;
                }
            }
            else if (llllllllllllllllIIIlIIlllIIllIlI[5].equals("keep") && !llllllllllllllllIIIlIIlllIIlIllI.isAirBlock(llllllllllllllllIIIlIIlllIIllIIl)) {
                throw new CommandException("commands.setblock.noChange", new Object[0]);
            }
        }
        final TileEntity llllllllllllllllIIIlIIlllIIlIIIl = llllllllllllllllIIIlIIlllIIlIllI.getTileEntity(llllllllllllllllIIIlIIlllIIllIIl);
        if (llllllllllllllllIIIlIIlllIIlIIIl != null) {
            if (llllllllllllllllIIIlIIlllIIlIIIl instanceof IInventory) {
                ((IInventory)llllllllllllllllIIIlIIlllIIlIIIl).clearInventory();
            }
            llllllllllllllllIIIlIIlllIIlIllI.setBlockState(llllllllllllllllIIIlIIlllIIllIIl, Blocks.air.getDefaultState(), (llllllllllllllllIIIlIIlllIIllIII == Blocks.air) ? 2 : 4);
        }
        final IBlockState llllllllllllllllIIIlIIlllIIlIIII = llllllllllllllllIIIlIIlllIIllIII.getStateFromMeta(llllllllllllllllIIIlIIlllIIlIlll);
        if (!llllllllllllllllIIIlIIlllIIlIllI.setBlockState(llllllllllllllllIIIlIIlllIIllIIl, llllllllllllllllIIIlIIlllIIlIIII, 2)) {
            throw new CommandException("commands.setblock.noChange", new Object[0]);
        }
        if (llllllllllllllllIIIlIIlllIIlIlII) {
            final TileEntity llllllllllllllllIIIlIIlllIIIllll = llllllllllllllllIIIlIIlllIIlIllI.getTileEntity(llllllllllllllllIIIlIIlllIIllIIl);
            if (llllllllllllllllIIIlIIlllIIIllll != null) {
                llllllllllllllllIIIlIIlllIIlIlIl.setInteger("x", llllllllllllllllIIIlIIlllIIllIIl.getX());
                llllllllllllllllIIIlIIlllIIlIlIl.setInteger("y", llllllllllllllllIIIlIIlllIIllIIl.getY());
                llllllllllllllllIIIlIIlllIIlIlIl.setInteger("z", llllllllllllllllIIIlIIlllIIllIIl.getZ());
                llllllllllllllllIIIlIIlllIIIllll.readFromNBT(llllllllllllllllIIIlIIlllIIlIlIl);
            }
        }
        llllllllllllllllIIIlIIlllIIlIllI.func_175722_b(llllllllllllllllIIIlIIlllIIllIIl, llllllllllllllllIIIlIIlllIIlIIII.getBlock());
        llllllllllllllllIIIlIIlllIIIllIl.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 1);
        CommandBase.notifyOperators(llllllllllllllllIIIlIIlllIIIllIl, this, "commands.setblock.success", new Object[0]);
    }
}
