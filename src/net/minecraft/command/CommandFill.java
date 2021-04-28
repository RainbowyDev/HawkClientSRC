package net.minecraft.command;

import net.minecraft.util.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.inventory.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import java.util.*;

public class CommandFill extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIIIIIllllIIIIIIII, final String[] lllllllllllllllIIIIIlllIllllllll) throws CommandException {
        if (lllllllllllllllIIIIIlllIllllllll.length < 7) {
            throw new WrongUsageException("commands.fill.usage", new Object[0]);
        }
        lllllllllllllllIIIIIllllIIIIIIII.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos lllllllllllllllIIIIIlllIlllllllI = CommandBase.func_175757_a(lllllllllllllllIIIIIllllIIIIIIII, lllllllllllllllIIIIIlllIllllllll, 0, false);
        final BlockPos lllllllllllllllIIIIIlllIllllllIl = CommandBase.func_175757_a(lllllllllllllllIIIIIllllIIIIIIII, lllllllllllllllIIIIIlllIllllllll, 3, false);
        final Block lllllllllllllllIIIIIlllIllllllII = CommandBase.getBlockByText(lllllllllllllllIIIIIllllIIIIIIII, lllllllllllllllIIIIIlllIllllllll[6]);
        int lllllllllllllllIIIIIlllIlllllIll = 0;
        if (lllllllllllllllIIIIIlllIllllllll.length >= 8) {
            lllllllllllllllIIIIIlllIlllllIll = CommandBase.parseInt(lllllllllllllllIIIIIlllIllllllll[7], 0, 15);
        }
        final BlockPos lllllllllllllllIIIIIlllIlllllIlI = new BlockPos(Math.min(lllllllllllllllIIIIIlllIlllllllI.getX(), lllllllllllllllIIIIIlllIllllllIl.getX()), Math.min(lllllllllllllllIIIIIlllIlllllllI.getY(), lllllllllllllllIIIIIlllIllllllIl.getY()), Math.min(lllllllllllllllIIIIIlllIlllllllI.getZ(), lllllllllllllllIIIIIlllIllllllIl.getZ()));
        final BlockPos lllllllllllllllIIIIIlllIlllllIIl = new BlockPos(Math.max(lllllllllllllllIIIIIlllIlllllllI.getX(), lllllllllllllllIIIIIlllIllllllIl.getX()), Math.max(lllllllllllllllIIIIIlllIlllllllI.getY(), lllllllllllllllIIIIIlllIllllllIl.getY()), Math.max(lllllllllllllllIIIIIlllIlllllllI.getZ(), lllllllllllllllIIIIIlllIllllllIl.getZ()));
        int lllllllllllllllIIIIIlllIlllllIII = (lllllllllllllllIIIIIlllIlllllIIl.getX() - lllllllllllllllIIIIIlllIlllllIlI.getX() + 1) * (lllllllllllllllIIIIIlllIlllllIIl.getY() - lllllllllllllllIIIIIlllIlllllIlI.getY() + 1) * (lllllllllllllllIIIIIlllIlllllIIl.getZ() - lllllllllllllllIIIIIlllIlllllIlI.getZ() + 1);
        if (lllllllllllllllIIIIIlllIlllllIII > 32768) {
            throw new CommandException("commands.fill.tooManyBlocks", new Object[] { lllllllllllllllIIIIIlllIlllllIII, 32768 });
        }
        if (lllllllllllllllIIIIIlllIlllllIlI.getY() < 0 || lllllllllllllllIIIIIlllIlllllIIl.getY() >= 256) {
            throw new CommandException("commands.fill.outOfWorld", new Object[0]);
        }
        final World lllllllllllllllIIIIIlllIllllIlll = lllllllllllllllIIIIIllllIIIIIIII.getEntityWorld();
        for (int lllllllllllllllIIIIIlllIllllIllI = lllllllllllllllIIIIIlllIlllllIlI.getZ(); lllllllllllllllIIIIIlllIllllIllI < lllllllllllllllIIIIIlllIlllllIIl.getZ() + 16; lllllllllllllllIIIIIlllIllllIllI += 16) {
            for (int lllllllllllllllIIIIIlllIllllIlIl = lllllllllllllllIIIIIlllIlllllIlI.getX(); lllllllllllllllIIIIIlllIllllIlIl < lllllllllllllllIIIIIlllIlllllIIl.getX() + 16; lllllllllllllllIIIIIlllIllllIlIl += 16) {
                if (!lllllllllllllllIIIIIlllIllllIlll.isBlockLoaded(new BlockPos(lllllllllllllllIIIIIlllIllllIlIl, lllllllllllllllIIIIIlllIlllllIIl.getY() - lllllllllllllllIIIIIlllIlllllIlI.getY(), lllllllllllllllIIIIIlllIllllIllI))) {
                    throw new CommandException("commands.fill.outOfWorld", new Object[0]);
                }
            }
        }
        NBTTagCompound lllllllllllllllIIIIIlllIllllIlII = new NBTTagCompound();
        boolean lllllllllllllllIIIIIlllIllllIIll = false;
        if (lllllllllllllllIIIIIlllIllllllll.length >= 10 && lllllllllllllllIIIIIlllIllllllII.hasTileEntity()) {
            final String lllllllllllllllIIIIIlllIllllIIlI = CommandBase.getChatComponentFromNthArg(lllllllllllllllIIIIIllllIIIIIIII, lllllllllllllllIIIIIlllIllllllll, 9).getUnformattedText();
            try {
                lllllllllllllllIIIIIlllIllllIlII = JsonToNBT.func_180713_a(lllllllllllllllIIIIIlllIllllIIlI);
                lllllllllllllllIIIIIlllIllllIIll = true;
            }
            catch (NBTException lllllllllllllllIIIIIlllIllllIIIl) {
                throw new CommandException("commands.fill.tagError", new Object[] { lllllllllllllllIIIIIlllIllllIIIl.getMessage() });
            }
        }
        final ArrayList lllllllllllllllIIIIIlllIllllIIII = Lists.newArrayList();
        lllllllllllllllIIIIIlllIlllllIII = 0;
        for (int lllllllllllllllIIIIIlllIlllIllll = lllllllllllllllIIIIIlllIlllllIlI.getZ(); lllllllllllllllIIIIIlllIlllIllll <= lllllllllllllllIIIIIlllIlllllIIl.getZ(); ++lllllllllllllllIIIIIlllIlllIllll) {
            for (int lllllllllllllllIIIIIlllIlllIlllI = lllllllllllllllIIIIIlllIlllllIlI.getY(); lllllllllllllllIIIIIlllIlllIlllI <= lllllllllllllllIIIIIlllIlllllIIl.getY(); ++lllllllllllllllIIIIIlllIlllIlllI) {
                for (int lllllllllllllllIIIIIlllIlllIllIl = lllllllllllllllIIIIIlllIlllllIlI.getX(); lllllllllllllllIIIIIlllIlllIllIl <= lllllllllllllllIIIIIlllIlllllIIl.getX(); ++lllllllllllllllIIIIIlllIlllIllIl) {
                    final BlockPos lllllllllllllllIIIIIlllIlllIllII = new BlockPos(lllllllllllllllIIIIIlllIlllIllIl, lllllllllllllllIIIIIlllIlllIlllI, lllllllllllllllIIIIIlllIlllIllll);
                    if (lllllllllllllllIIIIIlllIllllllll.length >= 9) {
                        if (!lllllllllllllllIIIIIlllIllllllll[8].equals("outline") && !lllllllllllllllIIIIIlllIllllllll[8].equals("hollow")) {
                            if (lllllllllllllllIIIIIlllIllllllll[8].equals("destroy")) {
                                lllllllllllllllIIIIIlllIllllIlll.destroyBlock(lllllllllllllllIIIIIlllIlllIllII, true);
                            }
                            else if (lllllllllllllllIIIIIlllIllllllll[8].equals("keep")) {
                                if (!lllllllllllllllIIIIIlllIllllIlll.isAirBlock(lllllllllllllllIIIIIlllIlllIllII)) {
                                    continue;
                                }
                            }
                            else if (lllllllllllllllIIIIIlllIllllllll[8].equals("replace") && !lllllllllllllllIIIIIlllIllllllII.hasTileEntity()) {
                                if (lllllllllllllllIIIIIlllIllllllll.length > 9) {
                                    final Block lllllllllllllllIIIIIlllIlllIlIIl = CommandBase.getBlockByText(lllllllllllllllIIIIIllllIIIIIIII, lllllllllllllllIIIIIlllIllllllll[9]);
                                    if (lllllllllllllllIIIIIlllIllllIlll.getBlockState(lllllllllllllllIIIIIlllIlllIllII).getBlock() != lllllllllllllllIIIIIlllIlllIlIIl) {
                                        continue;
                                    }
                                }
                                if (lllllllllllllllIIIIIlllIllllllll.length > 10) {
                                    final int lllllllllllllllIIIIIlllIlllIlIII = CommandBase.parseInt(lllllllllllllllIIIIIlllIllllllll[10]);
                                    final IBlockState lllllllllllllllIIIIIlllIlllIlIll = lllllllllllllllIIIIIlllIllllIlll.getBlockState(lllllllllllllllIIIIIlllIlllIllII);
                                    if (lllllllllllllllIIIIIlllIlllIlIll.getBlock().getMetaFromState(lllllllllllllllIIIIIlllIlllIlIll) != lllllllllllllllIIIIIlllIlllIlIII) {
                                        continue;
                                    }
                                }
                            }
                        }
                        else if (lllllllllllllllIIIIIlllIlllIllIl != lllllllllllllllIIIIIlllIlllllIlI.getX() && lllllllllllllllIIIIIlllIlllIllIl != lllllllllllllllIIIIIlllIlllllIIl.getX() && lllllllllllllllIIIIIlllIlllIlllI != lllllllllllllllIIIIIlllIlllllIlI.getY() && lllllllllllllllIIIIIlllIlllIlllI != lllllllllllllllIIIIIlllIlllllIIl.getY() && lllllllllllllllIIIIIlllIlllIllll != lllllllllllllllIIIIIlllIlllllIlI.getZ() && lllllllllllllllIIIIIlllIlllIllll != lllllllllllllllIIIIIlllIlllllIIl.getZ()) {
                            if (lllllllllllllllIIIIIlllIllllllll[8].equals("hollow")) {
                                lllllllllllllllIIIIIlllIllllIlll.setBlockState(lllllllllllllllIIIIIlllIlllIllII, Blocks.air.getDefaultState(), 2);
                                lllllllllllllllIIIIIlllIllllIIII.add(lllllllllllllllIIIIIlllIlllIllII);
                            }
                            continue;
                        }
                    }
                    final TileEntity lllllllllllllllIIIIIlllIlllIIlll = lllllllllllllllIIIIIlllIllllIlll.getTileEntity(lllllllllllllllIIIIIlllIlllIllII);
                    if (lllllllllllllllIIIIIlllIlllIIlll != null) {
                        if (lllllllllllllllIIIIIlllIlllIIlll instanceof IInventory) {
                            ((IInventory)lllllllllllllllIIIIIlllIlllIIlll).clearInventory();
                        }
                        lllllllllllllllIIIIIlllIllllIlll.setBlockState(lllllllllllllllIIIIIlllIlllIllII, Blocks.barrier.getDefaultState(), (lllllllllllllllIIIIIlllIllllllII == Blocks.barrier) ? 2 : 4);
                    }
                    final IBlockState lllllllllllllllIIIIIlllIlllIlIlI = lllllllllllllllIIIIIlllIllllllII.getStateFromMeta(lllllllllllllllIIIIIlllIlllllIll);
                    if (lllllllllllllllIIIIIlllIllllIlll.setBlockState(lllllllllllllllIIIIIlllIlllIllII, lllllllllllllllIIIIIlllIlllIlIlI, 2)) {
                        lllllllllllllllIIIIIlllIllllIIII.add(lllllllllllllllIIIIIlllIlllIllII);
                        ++lllllllllllllllIIIIIlllIlllllIII;
                        if (lllllllllllllllIIIIIlllIllllIIll) {
                            final TileEntity lllllllllllllllIIIIIlllIlllIIllI = lllllllllllllllIIIIIlllIllllIlll.getTileEntity(lllllllllllllllIIIIIlllIlllIllII);
                            if (lllllllllllllllIIIIIlllIlllIIllI != null) {
                                lllllllllllllllIIIIIlllIllllIlII.setInteger("x", lllllllllllllllIIIIIlllIlllIllII.getX());
                                lllllllllllllllIIIIIlllIllllIlII.setInteger("y", lllllllllllllllIIIIIlllIlllIllII.getY());
                                lllllllllllllllIIIIIlllIllllIlII.setInteger("z", lllllllllllllllIIIIIlllIlllIllII.getZ());
                                lllllllllllllllIIIIIlllIlllIIllI.readFromNBT(lllllllllllllllIIIIIlllIllllIlII);
                            }
                        }
                    }
                }
            }
        }
        for (final BlockPos lllllllllllllllIIIIIlllIlllIIlII : lllllllllllllllIIIIIlllIllllIIII) {
            final Block lllllllllllllllIIIIIlllIlllIIIll = lllllllllllllllIIIIIlllIllllIlll.getBlockState(lllllllllllllllIIIIIlllIlllIIlII).getBlock();
            lllllllllllllllIIIIIlllIllllIlll.func_175722_b(lllllllllllllllIIIIIlllIlllIIlII, lllllllllllllllIIIIIlllIlllIIIll);
        }
        if (lllllllllllllllIIIIIlllIlllllIII <= 0) {
            throw new CommandException("commands.fill.failed", new Object[0]);
        }
        lllllllllllllllIIIIIllllIIIIIIII.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, lllllllllllllllIIIIIlllIlllllIII);
        CommandBase.notifyOperators(lllllllllllllllIIIIIllllIIIIIIII, this, "commands.fill.success", lllllllllllllllIIIIIlllIlllllIII);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIIIIIllllIIllllIl) {
        return "commands.fill.usage";
    }
    
    @Override
    public String getCommandName() {
        return "fill";
    }
    
    static {
        __OBFID = "CL_00002342";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIIIIIlllIllIIlIlI, final String[] lllllllllllllllIIIIIlllIllIIIlll, final BlockPos lllllllllllllllIIIIIlllIllIIlIII) {
        return (lllllllllllllllIIIIIlllIllIIIlll.length > 0 && lllllllllllllllIIIIIlllIllIIIlll.length <= 3) ? CommandBase.func_175771_a(lllllllllllllllIIIIIlllIllIIIlll, 0, lllllllllllllllIIIIIlllIllIIlIII) : ((lllllllllllllllIIIIIlllIllIIIlll.length > 3 && lllllllllllllllIIIIIlllIllIIIlll.length <= 6) ? CommandBase.func_175771_a(lllllllllllllllIIIIIlllIllIIIlll, 3, lllllllllllllllIIIIIlllIllIIlIII) : ((lllllllllllllllIIIIIlllIllIIIlll.length == 7) ? CommandBase.func_175762_a(lllllllllllllllIIIIIlllIllIIIlll, Block.blockRegistry.getKeys()) : ((lllllllllllllllIIIIIlllIllIIIlll.length == 9) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIIIIlllIllIIIlll, "replace", "destroy", "keep", "hollow", "outline") : null)));
    }
}
