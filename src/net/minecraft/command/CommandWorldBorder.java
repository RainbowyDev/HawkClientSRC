package net.minecraft.command;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.border.*;
import net.minecraft.server.*;

public class CommandWorldBorder extends CommandBase
{
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIlIIlIlllIIlIllIlI, final String[] llllllllllllllIlIIlIlllIIlIllIIl, final BlockPos llllllllllllllIlIIlIlllIIlIllIII) {
        return (llllllllllllllIlIIlIlllIIlIllIIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIIlIlllIIlIllIIl, "set", "center", "damage", "warning", "add", "get") : ((llllllllllllllIlIIlIlllIIlIllIIl.length == 2 && llllllllllllllIlIIlIlllIIlIllIIl[0].equals("damage")) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIIlIlllIIlIllIIl, "buffer", "amount") : ((llllllllllllllIlIIlIlllIIlIllIIl.length == 2 && llllllllllllllIlIIlIlllIIlIllIIl[0].equals("warning")) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlIIlIlllIIlIllIIl, "time", "distance") : null));
    }
    
    @Override
    public String getCommandName() {
        return "worldborder";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlIIlIlllIIllIIllI, final String[] llllllllllllllIlIIlIlllIIllIIlIl) throws CommandException {
        if (llllllllllllllIlIIlIlllIIllIIlIl.length < 1) {
            throw new WrongUsageException("commands.worldborder.usage", new Object[0]);
        }
        final WorldBorder llllllllllllllIlIIlIlllIIllllIIl = this.getWorldBorder();
        if (llllllllllllllIlIIlIlllIIllIIlIl[0].equals("set")) {
            if (llllllllllllllIlIIlIlllIIllIIlIl.length != 2 && llllllllllllllIlIIlIlllIIllIIlIl.length != 3) {
                throw new WrongUsageException("commands.worldborder.set.usage", new Object[0]);
            }
            final double llllllllllllllIlIIlIlllIIllllIII = llllllllllllllIlIIlIlllIIllllIIl.getTargetSize();
            final double llllllllllllllIlIIlIlllIIlllIIll = CommandBase.parseDouble(llllllllllllllIlIIlIlllIIllIIlIl[1], 1.0, 6.0E7);
            final long llllllllllllllIlIIlIlllIIllIllll = (llllllllllllllIlIIlIlllIIllIIlIl.length > 2) ? (CommandBase.parseLong(llllllllllllllIlIIlIlllIIllIIlIl[2], 0L, 9223372036854775L) * 1000L) : 0L;
            if (llllllllllllllIlIIlIlllIIllIllll > 0L) {
                llllllllllllllIlIIlIlllIIllllIIl.setTransition(llllllllllllllIlIIlIlllIIllllIII, llllllllllllllIlIIlIlllIIlllIIll, llllllllllllllIlIIlIlllIIllIllll);
                if (llllllllllllllIlIIlIlllIIllllIII > llllllllllllllIlIIlIlllIIlllIIll) {
                    CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.setSlowly.shrink.success", String.format("%.1f", llllllllllllllIlIIlIlllIIlllIIll), String.format("%.1f", llllllllllllllIlIIlIlllIIllllIII), Long.toString(llllllllllllllIlIIlIlllIIllIllll / 1000L));
                }
                else {
                    CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.setSlowly.grow.success", String.format("%.1f", llllllllllllllIlIIlIlllIIlllIIll), String.format("%.1f", llllllllllllllIlIIlIlllIIllllIII), Long.toString(llllllllllllllIlIIlIlllIIllIllll / 1000L));
                }
            }
            else {
                llllllllllllllIlIIlIlllIIllllIIl.setTransition(llllllllllllllIlIIlIlllIIlllIIll);
                CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.set.success", String.format("%.1f", llllllllllllllIlIIlIlllIIlllIIll), String.format("%.1f", llllllllllllllIlIIlIlllIIllllIII));
            }
        }
        else if (llllllllllllllIlIIlIlllIIllIIlIl[0].equals("add")) {
            if (llllllllllllllIlIIlIlllIIllIIlIl.length != 2 && llllllllllllllIlIIlIlllIIllIIlIl.length != 3) {
                throw new WrongUsageException("commands.worldborder.add.usage", new Object[0]);
            }
            final double llllllllllllllIlIIlIlllIIlllIlll = llllllllllllllIlIIlIlllIIllllIIl.getDiameter();
            final double llllllllllllllIlIIlIlllIIlllIIlI = llllllllllllllIlIIlIlllIIlllIlll + CommandBase.parseDouble(llllllllllllllIlIIlIlllIIllIIlIl[1], -llllllllllllllIlIIlIlllIIlllIlll, 6.0E7 - llllllllllllllIlIIlIlllIIlllIlll);
            final long llllllllllllllIlIIlIlllIIllIlllI = llllllllllllllIlIIlIlllIIllllIIl.getTimeUntilTarget() + ((llllllllllllllIlIIlIlllIIllIIlIl.length > 2) ? (CommandBase.parseLong(llllllllllllllIlIIlIlllIIllIIlIl[2], 0L, 9223372036854775L) * 1000L) : 0L);
            if (llllllllllllllIlIIlIlllIIllIlllI > 0L) {
                llllllllllllllIlIIlIlllIIllllIIl.setTransition(llllllllllllllIlIIlIlllIIlllIlll, llllllllllllllIlIIlIlllIIlllIIlI, llllllllllllllIlIIlIlllIIllIlllI);
                if (llllllllllllllIlIIlIlllIIlllIlll > llllllllllllllIlIIlIlllIIlllIIlI) {
                    CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.setSlowly.shrink.success", String.format("%.1f", llllllllllllllIlIIlIlllIIlllIIlI), String.format("%.1f", llllllllllllllIlIIlIlllIIlllIlll), Long.toString(llllllllllllllIlIIlIlllIIllIlllI / 1000L));
                }
                else {
                    CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.setSlowly.grow.success", String.format("%.1f", llllllllllllllIlIIlIlllIIlllIIlI), String.format("%.1f", llllllllllllllIlIIlIlllIIlllIlll), Long.toString(llllllllllllllIlIIlIlllIIllIlllI / 1000L));
                }
            }
            else {
                llllllllllllllIlIIlIlllIIllllIIl.setTransition(llllllllllllllIlIIlIlllIIlllIIlI);
                CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.set.success", String.format("%.1f", llllllllllllllIlIIlIlllIIlllIIlI), String.format("%.1f", llllllllllllllIlIIlIlllIIlllIlll));
            }
        }
        else if (llllllllllllllIlIIlIlllIIllIIlIl[0].equals("center")) {
            if (llllllllllllllIlIIlIlllIIllIIlIl.length != 3) {
                throw new WrongUsageException("commands.worldborder.center.usage", new Object[0]);
            }
            final BlockPos llllllllllllllIlIIlIlllIIllIllIl = llllllllllllllIlIIlIlllIIllIIllI.getPosition();
            final double llllllllllllllIlIIlIlllIIllIllII = CommandBase.func_175761_b(llllllllllllllIlIIlIlllIIllIllIl.getX() + 0.5, llllllllllllllIlIIlIlllIIllIIlIl[1], true);
            final double llllllllllllllIlIIlIlllIIllIlIll = CommandBase.func_175761_b(llllllllllllllIlIIlIlllIIllIllIl.getZ() + 0.5, llllllllllllllIlIIlIlllIIllIIlIl[2], true);
            llllllllllllllIlIIlIlllIIllllIIl.setCenter(llllllllllllllIlIIlIlllIIllIllII, llllllllllllllIlIIlIlllIIllIlIll);
            CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.center.success", llllllllllllllIlIIlIlllIIllIllII, llllllllllllllIlIIlIlllIIllIlIll);
        }
        else if (llllllllllllllIlIIlIlllIIllIIlIl[0].equals("damage")) {
            if (llllllllllllllIlIIlIlllIIllIIlIl.length < 2) {
                throw new WrongUsageException("commands.worldborder.damage.usage", new Object[0]);
            }
            if (llllllllllllllIlIIlIlllIIllIIlIl[1].equals("buffer")) {
                if (llllllllllllllIlIIlIlllIIllIIlIl.length != 3) {
                    throw new WrongUsageException("commands.worldborder.damage.buffer.usage", new Object[0]);
                }
                final double llllllllllllllIlIIlIlllIIlllIllI = CommandBase.parseDouble(llllllllllllllIlIIlIlllIIllIIlIl[2], 0.0);
                final double llllllllllllllIlIIlIlllIIlllIIIl = llllllllllllllIlIIlIlllIIllllIIl.getDamageBuffer();
                llllllllllllllIlIIlIlllIIllllIIl.setDamageBuffer(llllllllllllllIlIIlIlllIIlllIllI);
                CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.damage.buffer.success", String.format("%.1f", llllllllllllllIlIIlIlllIIlllIllI), String.format("%.1f", llllllllllllllIlIIlIlllIIlllIIIl));
            }
            else if (llllllllllllllIlIIlIlllIIllIIlIl[1].equals("amount")) {
                if (llllllllllllllIlIIlIlllIIllIIlIl.length != 3) {
                    throw new WrongUsageException("commands.worldborder.damage.amount.usage", new Object[0]);
                }
                final double llllllllllllllIlIIlIlllIIlllIlIl = CommandBase.parseDouble(llllllllllllllIlIIlIlllIIllIIlIl[2], 0.0);
                final double llllllllllllllIlIIlIlllIIlllIIII = llllllllllllllIlIIlIlllIIllllIIl.func_177727_n();
                llllllllllllllIlIIlIlllIIllllIIl.func_177744_c(llllllllllllllIlIIlIlllIIlllIlIl);
                CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.damage.amount.success", String.format("%.2f", llllllllllllllIlIIlIlllIIlllIlIl), String.format("%.2f", llllllllllllllIlIIlIlllIIlllIIII));
            }
        }
        else if (llllllllllllllIlIIlIlllIIllIIlIl[0].equals("warning")) {
            if (llllllllllllllIlIIlIlllIIllIIlIl.length < 2) {
                throw new WrongUsageException("commands.worldborder.warning.usage", new Object[0]);
            }
            final int llllllllllllllIlIIlIlllIIllIlIlI = CommandBase.parseInt(llllllllllllllIlIIlIlllIIllIIlIl[2], 0);
            if (llllllllllllllIlIIlIlllIIllIIlIl[1].equals("time")) {
                if (llllllllllllllIlIIlIlllIIllIIlIl.length != 3) {
                    throw new WrongUsageException("commands.worldborder.warning.time.usage", new Object[0]);
                }
                final int llllllllllllllIlIIlIlllIIllIlIIl = llllllllllllllIlIIlIlllIIllllIIl.getWarningTime();
                llllllllllllllIlIIlIlllIIllllIIl.setWarningTime(llllllllllllllIlIIlIlllIIllIlIlI);
                CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.warning.time.success", llllllllllllllIlIIlIlllIIllIlIlI, llllllllllllllIlIIlIlllIIllIlIIl);
            }
            else if (llllllllllllllIlIIlIlllIIllIIlIl[1].equals("distance")) {
                if (llllllllllllllIlIIlIlllIIllIIlIl.length != 3) {
                    throw new WrongUsageException("commands.worldborder.warning.distance.usage", new Object[0]);
                }
                final int llllllllllllllIlIIlIlllIIllIlIII = llllllllllllllIlIIlIlllIIllllIIl.getWarningDistance();
                llllllllllllllIlIIlIlllIIllllIIl.setWarningDistance(llllllllllllllIlIIlIlllIIllIlIlI);
                CommandBase.notifyOperators(llllllllllllllIlIIlIlllIIllIIllI, this, "commands.worldborder.warning.distance.success", llllllllllllllIlIIlIlllIIllIlIlI, llllllllllllllIlIIlIlllIIllIlIII);
            }
        }
        else if (llllllllllllllIlIIlIlllIIllIIlIl[0].equals("get")) {
            final double llllllllllllllIlIIlIlllIIlllIlII = llllllllllllllIlIIlIlllIIllllIIl.getDiameter();
            llllllllllllllIlIIlIlllIIllIIllI.func_174794_a(CommandResultStats.Type.QUERY_RESULT, MathHelper.floor_double(llllllllllllllIlIIlIlllIIlllIlII + 0.5));
            llllllllllllllIlIIlIlllIIllIIllI.addChatMessage(new ChatComponentTranslation("commands.worldborder.get.success", new Object[] { String.format("%.0f", llllllllllllllIlIIlIlllIIlllIlII) }));
        }
    }
    
    protected WorldBorder getWorldBorder() {
        return MinecraftServer.getServer().worldServers[0].getWorldBorder();
    }
    
    static {
        __OBFID = "CL_00002336";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlIIlIlllIlIllIlII) {
        return "commands.worldborder.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
