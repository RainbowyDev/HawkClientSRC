package net.minecraft.command.server;

import net.minecraft.util.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.command.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;

public class CommandTestForBlock extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIllIlIlIIIIllIIll) {
        return "commands.testforblock.usage";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIllIlIIlllIIllIlI, final String[] lllllllllllllllIllIlIIlllIIllIIl, final BlockPos lllllllllllllllIllIlIIlllIIllIII) {
        return (lllllllllllllllIllIlIIlllIIllIIl.length > 0 && lllllllllllllllIllIlIIlllIIllIIl.length <= 3) ? CommandBase.func_175771_a(lllllllllllllllIllIlIIlllIIllIIl, 0, lllllllllllllllIllIlIIlllIIllIII) : ((lllllllllllllllIllIlIIlllIIllIIl.length == 4) ? CommandBase.func_175762_a(lllllllllllllllIllIlIIlllIIllIIl, Block.blockRegistry.getKeys()) : null);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "testforblock";
    }
    
    static {
        __OBFID = "CL_00001181";
    }
    
    public static boolean func_175775_a(final NBTBase lllllllllllllllIllIlIIlllIllIlII, final NBTBase lllllllllllllllIllIlIIlllIlIIlIl, final boolean lllllllllllllllIllIlIIlllIlIIlII) {
        if (lllllllllllllllIllIlIIlllIllIlII == lllllllllllllllIllIlIIlllIlIIlIl) {
            return true;
        }
        if (lllllllllllllllIllIlIIlllIllIlII == null) {
            return true;
        }
        if (lllllllllllllllIllIlIIlllIlIIlIl == null) {
            return false;
        }
        if (!lllllllllllllllIllIlIIlllIllIlII.getClass().equals(lllllllllllllllIllIlIIlllIlIIlIl.getClass())) {
            return false;
        }
        if (lllllllllllllllIllIlIIlllIllIlII instanceof NBTTagCompound) {
            final NBTTagCompound lllllllllllllllIllIlIIlllIllIIIl = (NBTTagCompound)lllllllllllllllIllIlIIlllIllIlII;
            final NBTTagCompound lllllllllllllllIllIlIIlllIllIIII = (NBTTagCompound)lllllllllllllllIllIlIIlllIlIIlIl;
            for (final String lllllllllllllllIllIlIIlllIlIlllI : lllllllllllllllIllIlIIlllIllIIIl.getKeySet()) {
                final NBTBase lllllllllllllllIllIlIIlllIlIllIl = lllllllllllllllIllIlIIlllIllIIIl.getTag(lllllllllllllllIllIlIIlllIlIlllI);
                if (!func_175775_a(lllllllllllllllIllIlIIlllIlIllIl, lllllllllllllllIllIlIIlllIllIIII.getTag(lllllllllllllllIllIlIIlllIlIlllI), lllllllllllllllIllIlIIlllIlIIlII)) {
                    return false;
                }
            }
            return true;
        }
        if (!(lllllllllllllllIllIlIIlllIllIlII instanceof NBTTagList) || !lllllllllllllllIllIlIIlllIlIIlII) {
            return lllllllllllllllIllIlIIlllIllIlII.equals(lllllllllllllllIllIlIIlllIlIIlIl);
        }
        final NBTTagList lllllllllllllllIllIlIIlllIlIllII = (NBTTagList)lllllllllllllllIllIlIIlllIllIlII;
        final NBTTagList lllllllllllllllIllIlIIlllIlIlIll = (NBTTagList)lllllllllllllllIllIlIIlllIlIIlIl;
        if (lllllllllllllllIllIlIIlllIlIllII.tagCount() == 0) {
            return lllllllllllllllIllIlIIlllIlIlIll.tagCount() == 0;
        }
        for (int lllllllllllllllIllIlIIlllIlIlIlI = 0; lllllllllllllllIllIlIIlllIlIlIlI < lllllllllllllllIllIlIIlllIlIllII.tagCount(); ++lllllllllllllllIllIlIIlllIlIlIlI) {
            final NBTBase lllllllllllllllIllIlIIlllIlIlIIl = lllllllllllllllIllIlIIlllIlIllII.get(lllllllllllllllIllIlIIlllIlIlIlI);
            boolean lllllllllllllllIllIlIIlllIlIlIII = false;
            for (int lllllllllllllllIllIlIIlllIlIIlll = 0; lllllllllllllllIllIlIIlllIlIIlll < lllllllllllllllIllIlIIlllIlIlIll.tagCount(); ++lllllllllllllllIllIlIIlllIlIIlll) {
                if (func_175775_a(lllllllllllllllIllIlIIlllIlIlIIl, lllllllllllllllIllIlIIlllIlIlIll.get(lllllllllllllllIllIlIIlllIlIIlll), lllllllllllllllIllIlIIlllIlIIlII)) {
                    lllllllllllllllIllIlIIlllIlIlIII = true;
                    break;
                }
            }
            if (!lllllllllllllllIllIlIIlllIlIlIII) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIllIlIIlllllIIIll, final String[] lllllllllllllllIllIlIIlllllIIIIl) throws CommandException {
        if (lllllllllllllllIllIlIIlllllIIIIl.length < 4) {
            throw new WrongUsageException("commands.testforblock.usage", new Object[0]);
        }
        lllllllllllllllIllIlIIlllllIIIll.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos lllllllllllllllIllIlIIlllllllIII = CommandBase.func_175757_a(lllllllllllllllIllIlIIlllllIIIll, lllllllllllllllIllIlIIlllllIIIIl, 0, false);
        final Block lllllllllllllllIllIlIIllllllIllI = Block.getBlockFromName(lllllllllllllllIllIlIIlllllIIIIl[3]);
        if (lllllllllllllllIllIlIIllllllIllI == null) {
            throw new NumberInvalidException("commands.setblock.notFound", new Object[] { lllllllllllllllIllIlIIlllllIIIIl[3] });
        }
        int lllllllllllllllIllIlIIllllllIlII = -1;
        if (lllllllllllllllIllIlIIlllllIIIIl.length >= 5) {
            lllllllllllllllIllIlIIllllllIlII = CommandBase.parseInt(lllllllllllllllIllIlIIlllllIIIIl[4], -1, 15);
        }
        final World lllllllllllllllIllIlIIllllllIIlI = lllllllllllllllIllIlIIlllllIIIll.getEntityWorld();
        if (!lllllllllllllllIllIlIIllllllIIlI.isBlockLoaded(lllllllllllllllIllIlIIlllllllIII)) {
            throw new CommandException("commands.testforblock.outOfWorld", new Object[0]);
        }
        NBTTagCompound lllllllllllllllIllIlIIllllllIIII = new NBTTagCompound();
        boolean lllllllllllllllIllIlIIlllllIlllI = false;
        if (lllllllllllllllIllIlIIlllllIIIIl.length >= 6 && lllllllllllllllIllIlIIllllllIllI.hasTileEntity()) {
            final String lllllllllllllllIllIlIIlllllIllII = CommandBase.getChatComponentFromNthArg(lllllllllllllllIllIlIIlllllIIIll, lllllllllllllllIllIlIIlllllIIIIl, 5).getUnformattedText();
            try {
                lllllllllllllllIllIlIIllllllIIII = JsonToNBT.func_180713_a(lllllllllllllllIllIlIIlllllIllII);
                lllllllllllllllIllIlIIlllllIlllI = true;
            }
            catch (NBTException lllllllllllllllIllIlIIlllllIlIlI) {
                throw new CommandException("commands.setblock.tagError", new Object[] { lllllllllllllllIllIlIIlllllIlIlI.getMessage() });
            }
        }
        final IBlockState lllllllllllllllIllIlIIlllllIlIIl = lllllllllllllllIllIlIIllllllIIlI.getBlockState(lllllllllllllllIllIlIIlllllllIII);
        final Block lllllllllllllllIllIlIIlllllIlIII = lllllllllllllllIllIlIIlllllIlIIl.getBlock();
        if (lllllllllllllllIllIlIIlllllIlIII != lllllllllllllllIllIlIIllllllIllI) {
            throw new CommandException("commands.testforblock.failed.tile", new Object[] { lllllllllllllllIllIlIIlllllllIII.getX(), lllllllllllllllIllIlIIlllllllIII.getY(), lllllllllllllllIllIlIIlllllllIII.getZ(), lllllllllllllllIllIlIIlllllIlIII.getLocalizedName(), lllllllllllllllIllIlIIllllllIllI.getLocalizedName() });
        }
        if (lllllllllllllllIllIlIIllllllIlII > -1) {
            final int lllllllllllllllIllIlIIlllllIIlll = lllllllllllllllIllIlIIlllllIlIIl.getBlock().getMetaFromState(lllllllllllllllIllIlIIlllllIlIIl);
            if (lllllllllllllllIllIlIIlllllIIlll != lllllllllllllllIllIlIIllllllIlII) {
                throw new CommandException("commands.testforblock.failed.data", new Object[] { lllllllllllllllIllIlIIlllllllIII.getX(), lllllllllllllllIllIlIIlllllllIII.getY(), lllllllllllllllIllIlIIlllllllIII.getZ(), lllllllllllllllIllIlIIlllllIIlll, lllllllllllllllIllIlIIllllllIlII });
            }
        }
        if (lllllllllllllllIllIlIIlllllIlllI) {
            final TileEntity lllllllllllllllIllIlIIlllllIIllI = lllllllllllllllIllIlIIllllllIIlI.getTileEntity(lllllllllllllllIllIlIIlllllllIII);
            if (lllllllllllllllIllIlIIlllllIIllI == null) {
                throw new CommandException("commands.testforblock.failed.tileEntity", new Object[] { lllllllllllllllIllIlIIlllllllIII.getX(), lllllllllllllllIllIlIIlllllllIII.getY(), lllllllllllllllIllIlIIlllllllIII.getZ() });
            }
            final NBTTagCompound lllllllllllllllIllIlIIlllllIIlIl = new NBTTagCompound();
            lllllllllllllllIllIlIIlllllIIllI.writeToNBT(lllllllllllllllIllIlIIlllllIIlIl);
            if (!func_175775_a(lllllllllllllllIllIlIIllllllIIII, lllllllllllllllIllIlIIlllllIIlIl, true)) {
                throw new CommandException("commands.testforblock.failed.nbt", new Object[] { lllllllllllllllIllIlIIlllllllIII.getX(), lllllllllllllllIllIlIIlllllllIII.getY(), lllllllllllllllIllIlIIlllllllIII.getZ() });
            }
        }
        lllllllllllllllIllIlIIlllllIIIll.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 1);
        CommandBase.notifyOperators(lllllllllllllllIllIlIIlllllIIIll, this, "commands.testforblock.success", lllllllllllllllIllIlIIlllllllIII.getX(), lllllllllllllllIllIlIIlllllllIII.getY(), lllllllllllllllIllIlIIlllllllIII.getZ());
    }
}
