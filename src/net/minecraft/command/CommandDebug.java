package net.minecraft.command;

import net.minecraft.server.*;
import java.text.*;
import java.io.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.profiler.*;

public class CommandDebug extends CommandBase
{
    private /* synthetic */ int field_147207_c;
    private /* synthetic */ long field_147206_b;
    private static final /* synthetic */ Logger logger;
    
    private String func_147204_b(final long lllllllllllllllIIlIlllIlllllIlII, final int lllllllllllllllIIlIlllIlllllIIll) {
        final StringBuilder lllllllllllllllIIlIlllIlllllIIlI = new StringBuilder();
        lllllllllllllllIIlIlllIlllllIIlI.append("---- Minecraft Profiler Results ----\n");
        lllllllllllllllIIlIlllIlllllIIlI.append("// ");
        lllllllllllllllIIlIlllIlllllIIlI.append(func_147203_d());
        lllllllllllllllIIlIlllIlllllIIlI.append("\n\n");
        lllllllllllllllIIlIlllIlllllIIlI.append("Time span: ").append(lllllllllllllllIIlIlllIlllllIlII).append(" ms\n");
        lllllllllllllllIIlIlllIlllllIIlI.append("Tick span: ").append(lllllllllllllllIIlIlllIlllllIIll).append(" ticks\n");
        lllllllllllllllIIlIlllIlllllIIlI.append("// This is approximately ").append(String.format("%.2f", lllllllllllllllIIlIlllIlllllIIll / (lllllllllllllllIIlIlllIlllllIlII / 1000.0f))).append(" ticks per second. It should be ").append(20).append(" ticks per second\n\n");
        lllllllllllllllIIlIlllIlllllIIlI.append("--- BEGIN PROFILE DUMP ---\n\n");
        this.func_147202_a(0, "root", lllllllllllllllIIlIlllIlllllIIlI);
        lllllllllllllllIIlIlllIlllllIIlI.append("--- END PROFILE DUMP ---\n\n");
        return String.valueOf(lllllllllllllllIIlIlllIlllllIIlI);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIIlIllllIIlIIIIlI) {
        return "commands.debug.usage";
    }
    
    private void func_147205_a(final long lllllllllllllllIIlIllllIIIIIIIll, final int lllllllllllllllIIlIllllIIIIIIIlI) {
        final File lllllllllllllllIIlIllllIIIIIIIIl = new File(MinecraftServer.getServer().getFile("debug"), String.valueOf(new StringBuilder("profile-results-").append(new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date())).append(".txt")));
        lllllllllllllllIIlIllllIIIIIIIIl.getParentFile().mkdirs();
        try {
            final FileWriter lllllllllllllllIIlIllllIIIIIIIII = new FileWriter(lllllllllllllllIIlIllllIIIIIIIIl);
            lllllllllllllllIIlIllllIIIIIIIII.write(this.func_147204_b(lllllllllllllllIIlIllllIIIIIIIll, lllllllllllllllIIlIllllIIIIIIIlI));
            lllllllllllllllIIlIllllIIIIIIIII.close();
        }
        catch (Throwable lllllllllllllllIIlIlllIlllllllll) {
            CommandDebug.logger.error(String.valueOf(new StringBuilder("Could not save profiler results to ").append(lllllllllllllllIIlIllllIIIIIIIIl)), lllllllllllllllIIlIlllIlllllllll);
        }
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIIlIllllIIIIlIIIl, final String[] lllllllllllllllIIlIllllIIIIIllll) throws CommandException {
        if (lllllllllllllllIIlIllllIIIIIllll.length < 1) {
            throw new WrongUsageException("commands.debug.usage", new Object[0]);
        }
        if (lllllllllllllllIIlIllllIIIIIllll[0].equals("start")) {
            if (lllllllllllllllIIlIllllIIIIIllll.length != 1) {
                throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }
            CommandBase.notifyOperators(lllllllllllllllIIlIllllIIIIlIIIl, this, "commands.debug.start", new Object[0]);
            MinecraftServer.getServer().enableProfiling();
            this.field_147206_b = MinecraftServer.getCurrentTimeMillis();
            this.field_147207_c = MinecraftServer.getServer().getTickCounter();
        }
        else if (lllllllllllllllIIlIllllIIIIIllll[0].equals("stop")) {
            if (lllllllllllllllIIlIllllIIIIIllll.length != 1) {
                throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }
            if (!MinecraftServer.getServer().theProfiler.profilingEnabled) {
                throw new CommandException("commands.debug.notStarted", new Object[0]);
            }
            final long lllllllllllllllIIlIllllIIIIllIll = MinecraftServer.getCurrentTimeMillis();
            final int lllllllllllllllIIlIllllIIIIllIIl = MinecraftServer.getServer().getTickCounter();
            final long lllllllllllllllIIlIllllIIIIlIlll = lllllllllllllllIIlIllllIIIIllIll - this.field_147206_b;
            final int lllllllllllllllIIlIllllIIIIlIlIl = lllllllllllllllIIlIllllIIIIllIIl - this.field_147207_c;
            this.func_147205_a(lllllllllllllllIIlIllllIIIIlIlll, lllllllllllllllIIlIllllIIIIlIlIl);
            MinecraftServer.getServer().theProfiler.profilingEnabled = false;
            CommandBase.notifyOperators(lllllllllllllllIIlIllllIIIIlIIIl, this, "commands.debug.stop", lllllllllllllllIIlIllllIIIIlIlll / 1000.0f, lllllllllllllllIIlIllllIIIIlIlIl);
        }
        else if (lllllllllllllllIIlIllllIIIIIllll[0].equals("chunk")) {
            if (lllllllllllllllIIlIllllIIIIIllll.length != 4) {
                throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }
            CommandBase.func_175757_a(lllllllllllllllIIlIllllIIIIlIIIl, lllllllllllllllIIlIllllIIIIIllll, 1, true);
        }
    }
    
    private static String func_147203_d() {
        final String[] lllllllllllllllIIlIlllIlllIlIIlI = { "Shiny numbers!", "Am I not running fast enough? :(", "I'm working as hard as I can!", "Will I ever be good enough for you? :(", "Speedy. Zoooooom!", "Hello world", "40% better than a crash report.", "Now with extra numbers", "Now with less numbers", "Now with the same numbers", "You should add flames to things, it makes them go faster!", "Do you feel the need for... optimization?", "*cracks redstone whip*", "Maybe if you treated it better then it'll have more motivation to work faster! Poor server." };
        try {
            return lllllllllllllllIIlIlllIlllIlIIlI[(int)(System.nanoTime() % lllllllllllllllIIlIlllIlllIlIIlI.length)];
        }
        catch (Throwable lllllllllllllllIIlIlllIlllIlIIIl) {
            return "Witty comment unavailable :(";
        }
    }
    
    static {
        __OBFID = "CL_00000270";
        logger = LogManager.getLogger();
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIIlIlllIlllIIllII, final String[] lllllllllllllllIIlIlllIlllIIlIIl, final BlockPos lllllllllllllllIIlIlllIlllIIlIlI) {
        return (lllllllllllllllIIlIlllIlllIIlIIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIlIlllIlllIIlIIl, "start", "stop") : null;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandName() {
        return "debug";
    }
    
    private void func_147202_a(final int lllllllllllllllIIlIlllIllllIIlII, final String lllllllllllllllIIlIlllIllllIIIll, final StringBuilder lllllllllllllllIIlIlllIllllIIIlI) {
        final List lllllllllllllllIIlIlllIllllIIIIl = MinecraftServer.getServer().theProfiler.getProfilingData(lllllllllllllllIIlIlllIllllIIIll);
        if (lllllllllllllllIIlIlllIllllIIIIl != null && lllllllllllllllIIlIlllIllllIIIIl.size() >= 3) {
            for (int lllllllllllllllIIlIlllIllllIIIII = 1; lllllllllllllllIIlIlllIllllIIIII < lllllllllllllllIIlIlllIllllIIIIl.size(); ++lllllllllllllllIIlIlllIllllIIIII) {
                final Profiler.Result lllllllllllllllIIlIlllIlllIlllll = lllllllllllllllIIlIlllIllllIIIIl.get(lllllllllllllllIIlIlllIllllIIIII);
                lllllllllllllllIIlIlllIllllIIIlI.append(String.format("[%02d] ", lllllllllllllllIIlIlllIllllIIlII));
                for (int lllllllllllllllIIlIlllIlllIllllI = 0; lllllllllllllllIIlIlllIlllIllllI < lllllllllllllllIIlIlllIllllIIlII; ++lllllllllllllllIIlIlllIlllIllllI) {
                    lllllllllllllllIIlIlllIllllIIIlI.append(" ");
                }
                lllllllllllllllIIlIlllIllllIIIlI.append(lllllllllllllllIIlIlllIlllIlllll.field_76331_c).append(" - ").append(String.format("%.2f", lllllllllllllllIIlIlllIlllIlllll.field_76332_a)).append("%/").append(String.format("%.2f", lllllllllllllllIIlIlllIlllIlllll.field_76330_b)).append("%\n");
                if (!lllllllllllllllIIlIlllIlllIlllll.field_76331_c.equals("unspecified")) {
                    try {
                        this.func_147202_a(lllllllllllllllIIlIlllIllllIIlII + 1, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIlIlllIllllIIIll)).append(".").append(lllllllllllllllIIlIlllIlllIlllll.field_76331_c)), lllllllllllllllIIlIlllIllllIIIlI);
                    }
                    catch (Exception lllllllllllllllIIlIlllIlllIlllIl) {
                        lllllllllllllllIIlIlllIllllIIIlI.append("[[ EXCEPTION ").append(lllllllllllllllIIlIlllIlllIlllIl).append(" ]]");
                    }
                }
            }
        }
    }
}
