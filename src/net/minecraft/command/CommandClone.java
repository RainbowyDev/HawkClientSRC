package net.minecraft.command;

import net.minecraft.block.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import java.util.*;

public class CommandClone extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIIlllIllIIIllIlIII, final String[] llllllllllllllIIlllIllIIIllIIlll, final BlockPos llllllllllllllIIlllIllIIIllIIllI) {
        return (llllllllllllllIIlllIllIIIllIIlll.length > 0 && llllllllllllllIIlllIllIIIllIIlll.length <= 3) ? CommandBase.func_175771_a(llllllllllllllIIlllIllIIIllIIlll, 0, llllllllllllllIIlllIllIIIllIIllI) : ((llllllllllllllIIlllIllIIIllIIlll.length > 3 && llllllllllllllIIlllIllIIIllIIlll.length <= 6) ? CommandBase.func_175771_a(llllllllllllllIIlllIllIIIllIIlll, 3, llllllllllllllIIlllIllIIIllIIllI) : ((llllllllllllllIIlllIllIIIllIIlll.length > 6 && llllllllllllllIIlllIllIIIllIIlll.length <= 9) ? CommandBase.func_175771_a(llllllllllllllIIlllIllIIIllIIlll, 6, llllllllllllllIIlllIllIIIllIIllI) : ((llllllllllllllIIlllIllIIIllIIlll.length == 10) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlllIllIIIllIIlll, "replace", "masked", "filtered") : ((llllllllllllllIIlllIllIIIllIIlll.length == 11) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlllIllIIIllIIlll, "normal", "force", "move") : ((llllllllllllllIIlllIllIIIllIIlll.length == 12 && "filtered".equals(llllllllllllllIIlllIllIIIllIIlll[9])) ? CommandBase.func_175762_a(llllllllllllllIIlllIllIIIllIIlll, Block.blockRegistry.getKeys()) : null)))));
    }
    
    static {
        __OBFID = "CL_00002348";
    }
    
    @Override
    public String getCommandName() {
        return "clone";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIIlllIllIIlIllIIlI, final String[] llllllllllllllIIlllIllIIlIllIIIl) throws CommandException {
        if (llllllllllllllIIlllIllIIlIllIIIl.length < 9) {
            throw new WrongUsageException("commands.clone.usage", new Object[0]);
        }
        llllllllllllllIIlllIllIIlIllIIlI.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos llllllllllllllIIlllIllIIlIllIIII = CommandBase.func_175757_a(llllllllllllllIIlllIllIIlIllIIlI, llllllllllllllIIlllIllIIlIllIIIl, 0, false);
        final BlockPos llllllllllllllIIlllIllIIlIlIllll = CommandBase.func_175757_a(llllllllllllllIIlllIllIIlIllIIlI, llllllllllllllIIlllIllIIlIllIIIl, 3, false);
        final BlockPos llllllllllllllIIlllIllIIlIlIlllI = CommandBase.func_175757_a(llllllllllllllIIlllIllIIlIllIIlI, llllllllllllllIIlllIllIIlIllIIIl, 6, false);
        final StructureBoundingBox llllllllllllllIIlllIllIIlIlIllIl = new StructureBoundingBox(llllllllllllllIIlllIllIIlIllIIII, llllllllllllllIIlllIllIIlIlIllll);
        final StructureBoundingBox llllllllllllllIIlllIllIIlIlIllII = new StructureBoundingBox(llllllllllllllIIlllIllIIlIlIlllI, llllllllllllllIIlllIllIIlIlIlllI.add(llllllllllllllIIlllIllIIlIlIllIl.func_175896_b()));
        int llllllllllllllIIlllIllIIlIlIlIll = llllllllllllllIIlllIllIIlIlIllIl.getXSize() * llllllllllllllIIlllIllIIlIlIllIl.getYSize() * llllllllllllllIIlllIllIIlIlIllIl.getZSize();
        if (llllllllllllllIIlllIllIIlIlIlIll > 32768) {
            throw new CommandException("commands.clone.tooManyBlocks", new Object[] { llllllllllllllIIlllIllIIlIlIlIll, 32768 });
        }
        boolean llllllllllllllIIlllIllIIlIlIlIlI = false;
        Block llllllllllllllIIlllIllIIlIlIlIIl = null;
        int llllllllllllllIIlllIllIIlIlIlIII = -1;
        if ((llllllllllllllIIlllIllIIlIllIIIl.length < 11 || (!llllllllllllllIIlllIllIIlIllIIIl[10].equals("force") && !llllllllllllllIIlllIllIIlIllIIIl[10].equals("move"))) && llllllllllllllIIlllIllIIlIlIllIl.intersectsWith(llllllllllllllIIlllIllIIlIlIllII)) {
            throw new CommandException("commands.clone.noOverlap", new Object[0]);
        }
        if (llllllllllllllIIlllIllIIlIllIIIl.length >= 11 && llllllllllllllIIlllIllIIlIllIIIl[10].equals("move")) {
            llllllllllllllIIlllIllIIlIlIlIlI = true;
        }
        if (llllllllllllllIIlllIllIIlIlIllIl.minY < 0 || llllllllllllllIIlllIllIIlIlIllIl.maxY >= 256 || llllllllllllllIIlllIllIIlIlIllII.minY < 0 || llllllllllllllIIlllIllIIlIlIllII.maxY >= 256) {
            throw new CommandException("commands.clone.outOfWorld", new Object[0]);
        }
        final World llllllllllllllIIlllIllIIlIlIIlll = llllllllllllllIIlllIllIIlIllIIlI.getEntityWorld();
        if (!llllllllllllllIIlllIllIIlIlIIlll.isAreaLoaded(llllllllllllllIIlllIllIIlIlIllIl) || !llllllllllllllIIlllIllIIlIlIIlll.isAreaLoaded(llllllllllllllIIlllIllIIlIlIllII)) {
            throw new CommandException("commands.clone.outOfWorld", new Object[0]);
        }
        boolean llllllllllllllIIlllIllIIlIlIIllI = false;
        if (llllllllllllllIIlllIllIIlIllIIIl.length >= 10) {
            if (llllllllllllllIIlllIllIIlIllIIIl[9].equals("masked")) {
                llllllllllllllIIlllIllIIlIlIIllI = true;
            }
            else if (llllllllllllllIIlllIllIIlIllIIIl[9].equals("filtered")) {
                if (llllllllllllllIIlllIllIIlIllIIIl.length < 12) {
                    throw new WrongUsageException("commands.clone.usage", new Object[0]);
                }
                llllllllllllllIIlllIllIIlIlIlIIl = CommandBase.getBlockByText(llllllllllllllIIlllIllIIlIllIIlI, llllllllllllllIIlllIllIIlIllIIIl[11]);
                if (llllllllllllllIIlllIllIIlIllIIIl.length >= 13) {
                    llllllllllllllIIlllIllIIlIlIlIII = CommandBase.parseInt(llllllllllllllIIlllIllIIlIllIIIl[12], 0, 15);
                }
            }
        }
        final ArrayList llllllllllllllIIlllIllIIlIlIIlIl = Lists.newArrayList();
        final ArrayList llllllllllllllIIlllIllIIlIlIIlII = Lists.newArrayList();
        final ArrayList llllllllllllllIIlllIllIIlIlIIIll = Lists.newArrayList();
        final LinkedList llllllllllllllIIlllIllIIlIlIIIlI = Lists.newLinkedList();
        final BlockPos llllllllllllllIIlllIllIIlIlIIIIl = new BlockPos(llllllllllllllIIlllIllIIlIlIllII.minX - llllllllllllllIIlllIllIIlIlIllIl.minX, llllllllllllllIIlllIllIIlIlIllII.minY - llllllllllllllIIlllIllIIlIlIllIl.minY, llllllllllllllIIlllIllIIlIlIllII.minZ - llllllllllllllIIlllIllIIlIlIllIl.minZ);
        for (int llllllllllllllIIlllIllIIlIlIIIII = llllllllllllllIIlllIllIIlIlIllIl.minZ; llllllllllllllIIlllIllIIlIlIIIII <= llllllllllllllIIlllIllIIlIlIllIl.maxZ; ++llllllllllllllIIlllIllIIlIlIIIII) {
            for (int llllllllllllllIIlllIllIIlIIlllll = llllllllllllllIIlllIllIIlIlIllIl.minY; llllllllllllllIIlllIllIIlIIlllll <= llllllllllllllIIlllIllIIlIlIllIl.maxY; ++llllllllllllllIIlllIllIIlIIlllll) {
                for (int llllllllllllllIIlllIllIIlIIllllI = llllllllllllllIIlllIllIIlIlIllIl.minX; llllllllllllllIIlllIllIIlIIllllI <= llllllllllllllIIlllIllIIlIlIllIl.maxX; ++llllllllllllllIIlllIllIIlIIllllI) {
                    final BlockPos llllllllllllllIIlllIllIIlIIlllIl = new BlockPos(llllllllllllllIIlllIllIIlIIllllI, llllllllllllllIIlllIllIIlIIlllll, llllllllllllllIIlllIllIIlIlIIIII);
                    final BlockPos llllllllllllllIIlllIllIIlIIlllII = llllllllllllllIIlllIllIIlIIlllIl.add(llllllllllllllIIlllIllIIlIlIIIIl);
                    final IBlockState llllllllllllllIIlllIllIIlIIllIll = llllllllllllllIIlllIllIIlIlIIlll.getBlockState(llllllllllllllIIlllIllIIlIIlllIl);
                    if ((!llllllllllllllIIlllIllIIlIlIIllI || llllllllllllllIIlllIllIIlIIllIll.getBlock() != Blocks.air) && (llllllllllllllIIlllIllIIlIlIlIIl == null || (llllllllllllllIIlllIllIIlIIllIll.getBlock() == llllllllllllllIIlllIllIIlIlIlIIl && (llllllllllllllIIlllIllIIlIlIlIII < 0 || llllllllllllllIIlllIllIIlIIllIll.getBlock().getMetaFromState(llllllllllllllIIlllIllIIlIIllIll) == llllllllllllllIIlllIllIIlIlIlIII)))) {
                        final TileEntity llllllllllllllIIlllIllIIlIIllIlI = llllllllllllllIIlllIllIIlIlIIlll.getTileEntity(llllllllllllllIIlllIllIIlIIlllIl);
                        if (llllllllllllllIIlllIllIIlIIllIlI != null) {
                            final NBTTagCompound llllllllllllllIIlllIllIIlIIllIIl = new NBTTagCompound();
                            llllllllllllllIIlllIllIIlIIllIlI.writeToNBT(llllllllllllllIIlllIllIIlIIllIIl);
                            llllllllllllllIIlllIllIIlIlIIlII.add(new StaticCloneData(llllllllllllllIIlllIllIIlIIlllII, llllllllllllllIIlllIllIIlIIllIll, llllllllllllllIIlllIllIIlIIllIIl));
                            llllllllllllllIIlllIllIIlIlIIIlI.addLast(llllllllllllllIIlllIllIIlIIlllIl);
                        }
                        else if (!llllllllllllllIIlllIllIIlIIllIll.getBlock().isFullBlock() && !llllllllllllllIIlllIllIIlIIllIll.getBlock().isFullCube()) {
                            llllllllllllllIIlllIllIIlIlIIIll.add(new StaticCloneData(llllllllllllllIIlllIllIIlIIlllII, llllllllllllllIIlllIllIIlIIllIll, null));
                            llllllllllllllIIlllIllIIlIlIIIlI.addFirst(llllllllllllllIIlllIllIIlIIlllIl);
                        }
                        else {
                            llllllllllllllIIlllIllIIlIlIIlIl.add(new StaticCloneData(llllllllllllllIIlllIllIIlIIlllII, llllllllllllllIIlllIllIIlIIllIll, null));
                            llllllllllllllIIlllIllIIlIlIIIlI.addLast(llllllllllllllIIlllIllIIlIIlllIl);
                        }
                    }
                }
            }
        }
        if (llllllllllllllIIlllIllIIlIlIlIlI) {
            for (final BlockPos llllllllllllllIIlllIllIIlIIlIlll : llllllllllllllIIlllIllIIlIlIIIlI) {
                final TileEntity llllllllllllllIIlllIllIIlIIlIlIl = llllllllllllllIIlllIllIIlIlIIlll.getTileEntity(llllllllllllllIIlllIllIIlIIlIlll);
                if (llllllllllllllIIlllIllIIlIIlIlIl instanceof IInventory) {
                    ((IInventory)llllllllllllllIIlllIllIIlIIlIlIl).clearInventory();
                }
                llllllllllllllIIlllIllIIlIlIIlll.setBlockState(llllllllllllllIIlllIllIIlIIlIlll, Blocks.barrier.getDefaultState(), 2);
            }
            for (final BlockPos llllllllllllllIIlllIllIIlIIlIllI : llllllllllllllIIlllIllIIlIlIIIlI) {
                llllllllllllllIIlllIllIIlIlIIlll.setBlockState(llllllllllllllIIlllIllIIlIIlIllI, Blocks.air.getDefaultState(), 3);
            }
        }
        final ArrayList llllllllllllllIIlllIllIIlIIlIlII = Lists.newArrayList();
        llllllllllllllIIlllIllIIlIIlIlII.addAll(llllllllllllllIIlllIllIIlIlIIlIl);
        llllllllllllllIIlllIllIIlIIlIlII.addAll(llllllllllllllIIlllIllIIlIlIIlII);
        llllllllllllllIIlllIllIIlIIlIlII.addAll(llllllllllllllIIlllIllIIlIlIIIll);
        final List llllllllllllllIIlllIllIIlIIlIIll = Lists.reverse((List)llllllllllllllIIlllIllIIlIIlIlII);
        for (final StaticCloneData llllllllllllllIIlllIllIIlIIlIIIl : llllllllllllllIIlllIllIIlIIlIIll) {
            final TileEntity llllllllllllllIIlllIllIIlIIIllIl = llllllllllllllIIlllIllIIlIlIIlll.getTileEntity(llllllllllllllIIlllIllIIlIIlIIIl.field_179537_a);
            if (llllllllllllllIIlllIllIIlIIIllIl instanceof IInventory) {
                ((IInventory)llllllllllllllIIlllIllIIlIIIllIl).clearInventory();
            }
            llllllllllllllIIlllIllIIlIlIIlll.setBlockState(llllllllllllllIIlllIllIIlIIlIIIl.field_179537_a, Blocks.barrier.getDefaultState(), 2);
        }
        llllllllllllllIIlllIllIIlIlIlIll = 0;
        for (final StaticCloneData llllllllllllllIIlllIllIIlIIlIIII : llllllllllllllIIlllIllIIlIIlIlII) {
            if (llllllllllllllIIlllIllIIlIlIIlll.setBlockState(llllllllllllllIIlllIllIIlIIlIIII.field_179537_a, llllllllllllllIIlllIllIIlIIlIIII.field_179535_b, 2)) {
                ++llllllllllllllIIlllIllIIlIlIlIll;
            }
        }
        for (final StaticCloneData llllllllllllllIIlllIllIIlIIIllll : llllllllllllllIIlllIllIIlIlIIlII) {
            final TileEntity llllllllllllllIIlllIllIIlIIIllII = llllllllllllllIIlllIllIIlIlIIlll.getTileEntity(llllllllllllllIIlllIllIIlIIIllll.field_179537_a);
            if (llllllllllllllIIlllIllIIlIIIllll.field_179536_c != null && llllllllllllllIIlllIllIIlIIIllII != null) {
                llllllllllllllIIlllIllIIlIIIllll.field_179536_c.setInteger("x", llllllllllllllIIlllIllIIlIIIllll.field_179537_a.getX());
                llllllllllllllIIlllIllIIlIIIllll.field_179536_c.setInteger("y", llllllllllllllIIlllIllIIlIIIllll.field_179537_a.getY());
                llllllllllllllIIlllIllIIlIIIllll.field_179536_c.setInteger("z", llllllllllllllIIlllIllIIlIIIllll.field_179537_a.getZ());
                llllllllllllllIIlllIllIIlIIIllII.readFromNBT(llllllllllllllIIlllIllIIlIIIllll.field_179536_c);
                llllllllllllllIIlllIllIIlIIIllII.markDirty();
            }
            llllllllllllllIIlllIllIIlIlIIlll.setBlockState(llllllllllllllIIlllIllIIlIIIllll.field_179537_a, llllllllllllllIIlllIllIIlIIIllll.field_179535_b, 2);
        }
        for (final StaticCloneData llllllllllllllIIlllIllIIlIIIlllI : llllllllllllllIIlllIllIIlIIlIIll) {
            llllllllllllllIIlllIllIIlIlIIlll.func_175722_b(llllllllllllllIIlllIllIIlIIIlllI.field_179537_a, llllllllllllllIIlllIllIIlIIIlllI.field_179535_b.getBlock());
        }
        final List llllllllllllllIIlllIllIIlIIIlIll = llllllllllllllIIlllIllIIlIlIIlll.func_175712_a(llllllllllllllIIlllIllIIlIlIllIl, false);
        if (llllllllllllllIIlllIllIIlIIIlIll != null) {
            for (final NextTickListEntry llllllllllllllIIlllIllIIlIIIlIIl : llllllllllllllIIlllIllIIlIIIlIll) {
                if (llllllllllllllIIlllIllIIlIlIllIl.func_175898_b(llllllllllllllIIlllIllIIlIIIlIIl.field_180282_a)) {
                    final BlockPos llllllllllllllIIlllIllIIlIIIlIII = llllllllllllllIIlllIllIIlIIIlIIl.field_180282_a.add(llllllllllllllIIlllIllIIlIlIIIIl);
                    llllllllllllllIIlllIllIIlIlIIlll.func_180497_b(llllllllllllllIIlllIllIIlIIIlIII, llllllllllllllIIlllIllIIlIIIlIIl.func_151351_a(), (int)(llllllllllllllIIlllIllIIlIIIlIIl.scheduledTime - llllllllllllllIIlllIllIIlIlIIlll.getWorldInfo().getWorldTotalTime()), llllllllllllllIIlllIllIIlIIIlIIl.priority);
                }
            }
        }
        if (llllllllllllllIIlllIllIIlIlIlIll <= 0) {
            throw new CommandException("commands.clone.failed", new Object[0]);
        }
        llllllllllllllIIlllIllIIlIllIIlI.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, llllllllllllllIIlllIllIIlIlIlIll);
        CommandBase.notifyOperators(llllllllllllllIIlllIllIIlIllIIlI, this, "commands.clone.success", llllllllllllllIIlllIllIIlIlIlIll);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlllIllIIllIlIIII) {
        return "commands.clone.usage";
    }
    
    static class StaticCloneData
    {
        public final /* synthetic */ NBTTagCompound field_179536_c;
        public final /* synthetic */ IBlockState field_179535_b;
        public final /* synthetic */ BlockPos field_179537_a;
        
        static {
            __OBFID = "CL_00002347";
        }
        
        public StaticCloneData(final BlockPos llllllllllllllllIIIllIIlIIlIlIIl, final IBlockState llllllllllllllllIIIllIIlIIlIllII, final NBTTagCompound llllllllllllllllIIIllIIlIIlIIlll) {
            this.field_179537_a = llllllllllllllllIIIllIIlIIlIlIIl;
            this.field_179535_b = llllllllllllllllIIIllIIlIIlIllII;
            this.field_179536_c = llllllllllllllllIIIllIIlIIlIIlll;
        }
    }
}
