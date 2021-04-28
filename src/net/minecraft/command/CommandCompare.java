package net.minecraft.command;

import net.minecraft.world.gen.structure.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import java.util.*;

public class CommandCompare extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIlIIlllIllIlIIll, final String[] llllllllllllllIlIlIIlllIlllIlIIl) throws CommandException {
        if (llllllllllllllIlIlIIlllIlllIlIIl.length < 9) {
            throw new WrongUsageException("commands.compare.usage", new Object[0]);
        }
        llllllllllllllIlIlIIlllIllIlIIll.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos llllllllllllllIlIlIIlllIlllIlIII = CommandBase.func_175757_a(llllllllllllllIlIlIIlllIllIlIIll, llllllllllllllIlIlIIlllIlllIlIIl, 0, false);
        final BlockPos llllllllllllllIlIlIIlllIlllIIlll = CommandBase.func_175757_a(llllllllllllllIlIlIIlllIllIlIIll, llllllllllllllIlIlIIlllIlllIlIIl, 3, false);
        final BlockPos llllllllllllllIlIlIIlllIlllIIllI = CommandBase.func_175757_a(llllllllllllllIlIlIIlllIllIlIIll, llllllllllllllIlIlIIlllIlllIlIIl, 6, false);
        final StructureBoundingBox llllllllllllllIlIlIIlllIlllIIlIl = new StructureBoundingBox(llllllllllllllIlIlIIlllIlllIlIII, llllllllllllllIlIlIIlllIlllIIlll);
        final StructureBoundingBox llllllllllllllIlIlIIlllIlllIIlII = new StructureBoundingBox(llllllllllllllIlIlIIlllIlllIIllI, llllllllllllllIlIlIIlllIlllIIllI.add(llllllllllllllIlIlIIlllIlllIIlIl.func_175896_b()));
        int llllllllllllllIlIlIIlllIlllIIIll = llllllllllllllIlIlIIlllIlllIIlIl.getXSize() * llllllllllllllIlIlIIlllIlllIIlIl.getYSize() * llllllllllllllIlIlIIlllIlllIIlIl.getZSize();
        if (llllllllllllllIlIlIIlllIlllIIIll > 524288) {
            throw new CommandException("commands.compare.tooManyBlocks", new Object[] { llllllllllllllIlIlIIlllIlllIIIll, 524288 });
        }
        if (llllllllllllllIlIlIIlllIlllIIlIl.minY < 0 || llllllllllllllIlIlIIlllIlllIIlIl.maxY >= 256 || llllllllllllllIlIlIIlllIlllIIlII.minY < 0 || llllllllllllllIlIlIIlllIlllIIlII.maxY >= 256) {
            throw new CommandException("commands.compare.outOfWorld", new Object[0]);
        }
        final World llllllllllllllIlIlIIlllIlllIIIlI = llllllllllllllIlIlIIlllIllIlIIll.getEntityWorld();
        if (llllllllllllllIlIlIIlllIlllIIIlI.isAreaLoaded(llllllllllllllIlIlIIlllIlllIIlIl) && llllllllllllllIlIlIIlllIlllIIIlI.isAreaLoaded(llllllllllllllIlIlIIlllIlllIIlII)) {
            boolean llllllllllllllIlIlIIlllIlllIIIIl = false;
            if (llllllllllllllIlIlIIlllIlllIlIIl.length > 9 && llllllllllllllIlIlIIlllIlllIlIIl[9].equals("masked")) {
                llllllllllllllIlIlIIlllIlllIIIIl = true;
            }
            llllllllllllllIlIlIIlllIlllIIIll = 0;
            final BlockPos llllllllllllllIlIlIIlllIlllIIIII = new BlockPos(llllllllllllllIlIlIIlllIlllIIlII.minX - llllllllllllllIlIlIIlllIlllIIlIl.minX, llllllllllllllIlIlIIlllIlllIIlII.minY - llllllllllllllIlIlIIlllIlllIIlIl.minY, llllllllllllllIlIlIIlllIlllIIlII.minZ - llllllllllllllIlIlIIlllIlllIIlIl.minZ);
            for (int llllllllllllllIlIlIIlllIllIlllll = llllllllllllllIlIlIIlllIlllIIlIl.minZ; llllllllllllllIlIlIIlllIllIlllll <= llllllllllllllIlIlIIlllIlllIIlIl.maxZ; ++llllllllllllllIlIlIIlllIllIlllll) {
                for (int llllllllllllllIlIlIIlllIllIllllI = llllllllllllllIlIlIIlllIlllIIlIl.minY; llllllllllllllIlIlIIlllIllIllllI <= llllllllllllllIlIlIIlllIlllIIlIl.maxY; ++llllllllllllllIlIlIIlllIllIllllI) {
                    for (int llllllllllllllIlIlIIlllIllIlllIl = llllllllllllllIlIlIIlllIlllIIlIl.minX; llllllllllllllIlIlIIlllIllIlllIl <= llllllllllllllIlIlIIlllIlllIIlIl.maxX; ++llllllllllllllIlIlIIlllIllIlllIl) {
                        final BlockPos llllllllllllllIlIlIIlllIllIlllII = new BlockPos(llllllllllllllIlIlIIlllIllIlllIl, llllllllllllllIlIlIIlllIllIllllI, llllllllllllllIlIlIIlllIllIlllll);
                        final BlockPos llllllllllllllIlIlIIlllIllIllIll = llllllllllllllIlIlIIlllIllIlllII.add(llllllllllllllIlIlIIlllIlllIIIII);
                        boolean llllllllllllllIlIlIIlllIllIllIlI = false;
                        final IBlockState llllllllllllllIlIlIIlllIllIllIIl = llllllllllllllIlIlIIlllIlllIIIlI.getBlockState(llllllllllllllIlIlIIlllIllIlllII);
                        if (!llllllllllllllIlIlIIlllIlllIIIIl || llllllllllllllIlIlIIlllIllIllIIl.getBlock() != Blocks.air) {
                            if (llllllllllllllIlIlIIlllIllIllIIl == llllllllllllllIlIlIIlllIlllIIIlI.getBlockState(llllllllllllllIlIlIIlllIllIllIll)) {
                                final TileEntity llllllllllllllIlIlIIlllIllIllIII = llllllllllllllIlIlIIlllIlllIIIlI.getTileEntity(llllllllllllllIlIlIIlllIllIlllII);
                                final TileEntity llllllllllllllIlIlIIlllIllIlIlll = llllllllllllllIlIlIIlllIlllIIIlI.getTileEntity(llllllllllllllIlIlIIlllIllIllIll);
                                if (llllllllllllllIlIlIIlllIllIllIII != null && llllllllllllllIlIlIIlllIllIlIlll != null) {
                                    final NBTTagCompound llllllllllllllIlIlIIlllIllIlIllI = new NBTTagCompound();
                                    llllllllllllllIlIlIIlllIllIllIII.writeToNBT(llllllllllllllIlIlIIlllIllIlIllI);
                                    llllllllllllllIlIlIIlllIllIlIllI.removeTag("x");
                                    llllllllllllllIlIlIIlllIllIlIllI.removeTag("y");
                                    llllllllllllllIlIlIIlllIllIlIllI.removeTag("z");
                                    final NBTTagCompound llllllllllllllIlIlIIlllIllIlIlIl = new NBTTagCompound();
                                    llllllllllllllIlIlIIlllIllIlIlll.writeToNBT(llllllllllllllIlIlIIlllIllIlIlIl);
                                    llllllllllllllIlIlIIlllIllIlIlIl.removeTag("x");
                                    llllllllllllllIlIlIIlllIllIlIlIl.removeTag("y");
                                    llllllllllllllIlIlIIlllIllIlIlIl.removeTag("z");
                                    if (!llllllllllllllIlIlIIlllIllIlIllI.equals(llllllllllllllIlIlIIlllIllIlIlIl)) {
                                        llllllllllllllIlIlIIlllIllIllIlI = true;
                                    }
                                }
                                else if (llllllllllllllIlIlIIlllIllIllIII != null) {
                                    llllllllllllllIlIlIIlllIllIllIlI = true;
                                }
                            }
                            else {
                                llllllllllllllIlIlIIlllIllIllIlI = true;
                            }
                            ++llllllllllllllIlIlIIlllIlllIIIll;
                            if (llllllllllllllIlIlIIlllIllIllIlI) {
                                throw new CommandException("commands.compare.failed", new Object[0]);
                            }
                        }
                    }
                }
            }
            llllllllllllllIlIlIIlllIllIlIIll.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, llllllllllllllIlIlIIlllIlllIIIll);
            CommandBase.notifyOperators(llllllllllllllIlIlIIlllIllIlIIll, this, "commands.compare.success", llllllllllllllIlIlIIlllIlllIIIll);
            return;
        }
        throw new CommandException("commands.compare.outOfWorld", new Object[0]);
    }
    
    static {
        __OBFID = "CL_00002346";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIlIIllllIIIIIIll) {
        return "commands.compare.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "testforblocks";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIlIlIIlllIlIlllIlI, final String[] llllllllllllllIlIlIIlllIlIllIlll, final BlockPos llllllllllllllIlIlIIlllIlIlllIII) {
        return (llllllllllllllIlIlIIlllIlIllIlll.length > 0 && llllllllllllllIlIlIIlllIlIllIlll.length <= 3) ? CommandBase.func_175771_a(llllllllllllllIlIlIIlllIlIllIlll, 0, llllllllllllllIlIlIIlllIlIlllIII) : ((llllllllllllllIlIlIIlllIlIllIlll.length > 3 && llllllllllllllIlIlIIlllIlIllIlll.length <= 6) ? CommandBase.func_175771_a(llllllllllllllIlIlIIlllIlIllIlll, 3, llllllllllllllIlIlIIlllIlIlllIII) : ((llllllllllllllIlIlIIlllIlIllIlll.length > 6 && llllllllllllllIlIlIIlllIlIllIlll.length <= 9) ? CommandBase.func_175771_a(llllllllllllllIlIlIIlllIlIllIlll, 6, llllllllllllllIlIlIIlllIlIlllIII) : ((llllllllllllllIlIlIIlllIlIllIlll.length == 10) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIlIIlllIlIllIlll, "masked", "all") : null)));
    }
}
