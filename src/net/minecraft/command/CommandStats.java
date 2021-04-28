package net.minecraft.command;

import net.minecraft.util.*;
import net.minecraft.server.*;
import com.google.common.collect.*;
import net.minecraft.scoreboard.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;

public class CommandStats extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    static {
        __OBFID = "CL_00002339";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIllIIIIIlIIlIlIIll, final String[] llllllllllllllIllIIIIIlIIlIlIIlI, final BlockPos llllllllllllllIllIIIIIlIIlIlIIIl) {
        return (llllllllllllllIllIIIIIlIIlIlIIlI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllIIIIIlIIlIlIIlI, "entity", "block") : ((llllllllllllllIllIIIIIlIIlIlIIlI.length == 2 && llllllllllllllIllIIIIIlIIlIlIIlI[0].equals("entity")) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllIIIIIlIIlIlIIlI, this.func_175776_d()) : (((llllllllllllllIllIIIIIlIIlIlIIlI.length != 3 || !llllllllllllllIllIIIIIlIIlIlIIlI[0].equals("entity")) && (llllllllllllllIllIIIIIlIIlIlIIlI.length != 5 || !llllllllllllllIllIIIIIlIIlIlIIlI[0].equals("block"))) ? (((llllllllllllllIllIIIIIlIIlIlIIlI.length != 4 || !llllllllllllllIllIIIIIlIIlIlIIlI[0].equals("entity")) && (llllllllllllllIllIIIIIlIIlIlIIlI.length != 6 || !llllllllllllllIllIIIIIlIIlIlIIlI[0].equals("block"))) ? (((llllllllllllllIllIIIIIlIIlIlIIlI.length != 6 || !llllllllllllllIllIIIIIlIIlIlIIlI[0].equals("entity")) && (llllllllllllllIllIIIIIlIIlIlIIlI.length != 8 || !llllllllllllllIllIIIIIlIIlIlIIlI[0].equals("block"))) ? null : CommandBase.func_175762_a(llllllllllllllIllIIIIIlIIlIlIIlI, this.func_175777_e())) : CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllIIIIIlIIlIlIIlI, CommandResultStats.Type.func_179634_c())) : CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllIIIIIlIIlIlIIlI, "set", "clear")));
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIllIIIIIlIlIIIlIII) {
        return "commands.stats.usage";
    }
    
    @Override
    public String getCommandName() {
        return "stats";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIllIIIIIlIIIlllIll, final int llllllllllllllIllIIIIIlIIIllllII) {
        return llllllllllllllIllIIIIIlIIIlllIll.length > 0 && llllllllllllllIllIIIIIlIIIlllIll[0].equals("entity") && llllllllllllllIllIIIIIlIIIllllII == 1;
    }
    
    protected List func_175777_e() {
        final Collection llllllllllllllIllIIIIIlIIlIIlIII = MinecraftServer.getServer().worldServerForDimension(0).getScoreboard().getScoreObjectives();
        final ArrayList llllllllllllllIllIIIIIlIIlIIIlll = Lists.newArrayList();
        for (final ScoreObjective llllllllllllllIllIIIIIlIIlIIIlIl : llllllllllllllIllIIIIIlIIlIIlIII) {
            if (!llllllllllllllIllIIIIIlIIlIIIlIl.getCriteria().isReadOnly()) {
                llllllllllllllIllIIIIIlIIlIIIlll.add(llllllllllllllIllIIIIIlIIlIIIlIl.getName());
            }
        }
        return llllllllllllllIllIIIIIlIIlIIIlll;
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIllIIIIIlIIllllIII, final String[] llllllllllllllIllIIIIIlIIlllIlll) throws CommandException {
        if (llllllllllllllIllIIIIIlIIlllIlll.length < 1) {
            throw new WrongUsageException("commands.stats.usage", new Object[0]);
        }
        boolean llllllllllllllIllIIIIIlIIlllIlIl = false;
        if (llllllllllllllIllIIIIIlIIlllIlll[0].equals("entity")) {
            final boolean llllllllllllllIllIIIIIlIIlllIllI = false;
        }
        else {
            if (!llllllllllllllIllIIIIIlIIlllIlll[0].equals("block")) {
                throw new WrongUsageException("commands.stats.usage", new Object[0]);
            }
            llllllllllllllIllIIIIIlIIlllIlIl = true;
        }
        byte llllllllllllllIllIIIIIlIIlllIIll = 0;
        if (llllllllllllllIllIIIIIlIIlllIlIl) {
            if (llllllllllllllIllIIIIIlIIlllIlll.length < 5) {
                throw new WrongUsageException("commands.stats.block.usage", new Object[0]);
            }
            final byte llllllllllllllIllIIIIIlIIlllIlII = 4;
        }
        else {
            if (llllllllllllllIllIIIIIlIIlllIlll.length < 3) {
                throw new WrongUsageException("commands.stats.entity.usage", new Object[0]);
            }
            llllllllllllllIllIIIIIlIIlllIIll = 2;
        }
        int llllllllllllllIllIIIIIlIIlllIIlI = llllllllllllllIllIIIIIlIIlllIIll + 1;
        final String llllllllllllllIllIIIIIlIIlllIIIl = llllllllllllllIllIIIIIlIIlllIlll[llllllllllllllIllIIIIIlIIlllIIll];
        if ("set".equals(llllllllllllllIllIIIIIlIIlllIIIl)) {
            if (llllllllllllllIllIIIIIlIIlllIlll.length < llllllllllllllIllIIIIIlIIlllIIlI + 3) {
                if (llllllllllllllIllIIIIIlIIlllIIlI == 5) {
                    throw new WrongUsageException("commands.stats.block.set.usage", new Object[0]);
                }
                throw new WrongUsageException("commands.stats.entity.set.usage", new Object[0]);
            }
        }
        else {
            if (!"clear".equals(llllllllllllllIllIIIIIlIIlllIIIl)) {
                throw new WrongUsageException("commands.stats.usage", new Object[0]);
            }
            if (llllllllllllllIllIIIIIlIIlllIlll.length < llllllllllllllIllIIIIIlIIlllIIlI + 1) {
                if (llllllllllllllIllIIIIIlIIlllIIlI == 5) {
                    throw new WrongUsageException("commands.stats.block.clear.usage", new Object[0]);
                }
                throw new WrongUsageException("commands.stats.entity.clear.usage", new Object[0]);
            }
        }
        final CommandResultStats.Type llllllllllllllIllIIIIIlIIlllIIII = CommandResultStats.Type.func_179635_a(llllllllllllllIllIIIIIlIIlllIlll[llllllllllllllIllIIIIIlIIlllIIlI++]);
        if (llllllllllllllIllIIIIIlIIlllIIII == null) {
            throw new CommandException("commands.stats.failed", new Object[0]);
        }
        final World llllllllllllllIllIIIIIlIIllIllll = llllllllllllllIllIIIIIlIIllllIII.getEntityWorld();
        CommandResultStats llllllllllllllIllIIIIIlIIllIllII;
        if (llllllllllllllIllIIIIIlIIlllIlIl) {
            final BlockPos llllllllllllllIllIIIIIlIIllIlIll = CommandBase.func_175757_a(llllllllllllllIllIIIIIlIIllllIII, llllllllllllllIllIIIIIlIIlllIlll, 1, false);
            final TileEntity llllllllllllllIllIIIIIlIIllIlIIl = llllllllllllllIllIIIIIlIIllIllll.getTileEntity(llllllllllllllIllIIIIIlIIllIlIll);
            if (llllllllllllllIllIIIIIlIIllIlIIl == null) {
                throw new CommandException("commands.stats.noCompatibleBlock", new Object[] { llllllllllllllIllIIIIIlIIllIlIll.getX(), llllllllllllllIllIIIIIlIIllIlIll.getY(), llllllllllllllIllIIIIIlIIllIlIll.getZ() });
            }
            if (llllllllllllllIllIIIIIlIIllIlIIl instanceof TileEntityCommandBlock) {
                final CommandResultStats llllllllllllllIllIIIIIlIIllIlllI = ((TileEntityCommandBlock)llllllllllllllIllIIIIIlIIllIlIIl).func_175124_c();
            }
            else {
                if (!(llllllllllllllIllIIIIIlIIllIlIIl instanceof TileEntitySign)) {
                    throw new CommandException("commands.stats.noCompatibleBlock", new Object[] { llllllllllllllIllIIIIIlIIllIlIll.getX(), llllllllllllllIllIIIIIlIIllIlIll.getY(), llllllllllllllIllIIIIIlIIllIlIll.getZ() });
                }
                final CommandResultStats llllllllllllllIllIIIIIlIIllIllIl = ((TileEntitySign)llllllllllllllIllIIIIIlIIllIlIIl).func_174880_d();
            }
        }
        else {
            final Entity llllllllllllllIllIIIIIlIIllIIlll = CommandBase.func_175768_b(llllllllllllllIllIIIIIlIIllllIII, llllllllllllllIllIIIIIlIIlllIlll[1]);
            llllllllllllllIllIIIIIlIIllIllII = llllllllllllllIllIIIIIlIIllIIlll.func_174807_aT();
        }
        if ("set".equals(llllllllllllllIllIIIIIlIIlllIIIl)) {
            final String llllllllllllllIllIIIIIlIIllIIllI = llllllllllllllIllIIIIIlIIlllIlll[llllllllllllllIllIIIIIlIIlllIIlI++];
            final String llllllllllllllIllIIIIIlIIllIIlIl = llllllllllllllIllIIIIIlIIlllIlll[llllllllllllllIllIIIIIlIIlllIIlI];
            if (llllllllllllllIllIIIIIlIIllIIllI.length() == 0 || llllllllllllllIllIIIIIlIIllIIlIl.length() == 0) {
                throw new CommandException("commands.stats.failed", new Object[0]);
            }
            CommandResultStats.func_179667_a(llllllllllllllIllIIIIIlIIllIllII, llllllllllllllIllIIIIIlIIlllIIII, llllllllllllllIllIIIIIlIIllIIllI, llllllllllllllIllIIIIIlIIllIIlIl);
            CommandBase.notifyOperators(llllllllllllllIllIIIIIlIIllllIII, this, "commands.stats.success", llllllllllllllIllIIIIIlIIlllIIII.func_179637_b(), llllllllllllllIllIIIIIlIIllIIlIl, llllllllllllllIllIIIIIlIIllIIllI);
        }
        else if ("clear".equals(llllllllllllllIllIIIIIlIIlllIIIl)) {
            CommandResultStats.func_179667_a(llllllllllllllIllIIIIIlIIllIllII, llllllllllllllIllIIIIIlIIlllIIII, null, null);
            CommandBase.notifyOperators(llllllllllllllIllIIIIIlIIllllIII, this, "commands.stats.cleared", llllllllllllllIllIIIIIlIIlllIIII.func_179637_b());
        }
        if (llllllllllllllIllIIIIIlIIlllIlIl) {
            final BlockPos llllllllllllllIllIIIIIlIIllIlIlI = CommandBase.func_175757_a(llllllllllllllIllIIIIIlIIllllIII, llllllllllllllIllIIIIIlIIlllIlll, 1, false);
            final TileEntity llllllllllllllIllIIIIIlIIllIlIII = llllllllllllllIllIIIIIlIIllIllll.getTileEntity(llllllllllllllIllIIIIIlIIllIlIlI);
            llllllllllllllIllIIIIIlIIllIlIII.markDirty();
        }
    }
    
    protected String[] func_175776_d() {
        return MinecraftServer.getServer().getAllUsernames();
    }
}
