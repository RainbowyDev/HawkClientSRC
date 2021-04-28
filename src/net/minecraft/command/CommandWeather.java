package net.minecraft.command;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;

public class CommandWeather extends CommandBase
{
    @Override
    public String getCommandName() {
        return "weather";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIIlllIIlIlIIIllIIl, final String[] llllllllllllllIIlllIIlIlIIIlIllI, final BlockPos llllllllllllllIIlllIIlIlIIIlIlll) {
        return (llllllllllllllIIlllIIlIlIIIlIllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIlllIIlIlIIIlIllI, "clear", "rain", "thunder") : null;
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIIlllIIlIlIIlIIIII, final String[] llllllllllllllIIlllIIlIlIIIlllll) throws CommandException {
        if (llllllllllllllIIlllIIlIlIIIlllll.length >= 1 && llllllllllllllIIlllIIlIlIIIlllll.length <= 2) {
            int llllllllllllllIIlllIIlIlIIlIIlII = (300 + new Random().nextInt(600)) * 20;
            if (llllllllllllllIIlllIIlIlIIIlllll.length >= 2) {
                llllllllllllllIIlllIIlIlIIlIIlII = CommandBase.parseInt(llllllllllllllIIlllIIlIlIIIlllll[1], 1, 1000000) * 20;
            }
            final WorldServer llllllllllllllIIlllIIlIlIIlIIIll = MinecraftServer.getServer().worldServers[0];
            final WorldInfo llllllllllllllIIlllIIlIlIIlIIIlI = llllllllllllllIIlllIIlIlIIlIIIll.getWorldInfo();
            if ("clear".equalsIgnoreCase(llllllllllllllIIlllIIlIlIIIlllll[0])) {
                llllllllllllllIIlllIIlIlIIlIIIlI.func_176142_i(llllllllllllllIIlllIIlIlIIlIIlII);
                llllllllllllllIIlllIIlIlIIlIIIlI.setRainTime(0);
                llllllllllllllIIlllIIlIlIIlIIIlI.setThunderTime(0);
                llllllllllllllIIlllIIlIlIIlIIIlI.setRaining(false);
                llllllllllllllIIlllIIlIlIIlIIIlI.setThundering(false);
                CommandBase.notifyOperators(llllllllllllllIIlllIIlIlIIlIIIII, this, "commands.weather.clear", new Object[0]);
            }
            else if ("rain".equalsIgnoreCase(llllllllllllllIIlllIIlIlIIIlllll[0])) {
                llllllllllllllIIlllIIlIlIIlIIIlI.func_176142_i(0);
                llllllllllllllIIlllIIlIlIIlIIIlI.setRainTime(llllllllllllllIIlllIIlIlIIlIIlII);
                llllllllllllllIIlllIIlIlIIlIIIlI.setThunderTime(llllllllllllllIIlllIIlIlIIlIIlII);
                llllllllllllllIIlllIIlIlIIlIIIlI.setRaining(true);
                llllllllllllllIIlllIIlIlIIlIIIlI.setThundering(false);
                CommandBase.notifyOperators(llllllllllllllIIlllIIlIlIIlIIIII, this, "commands.weather.rain", new Object[0]);
            }
            else {
                if (!"thunder".equalsIgnoreCase(llllllllllllllIIlllIIlIlIIIlllll[0])) {
                    throw new WrongUsageException("commands.weather.usage", new Object[0]);
                }
                llllllllllllllIIlllIIlIlIIlIIIlI.func_176142_i(0);
                llllllllllllllIIlllIIlIlIIlIIIlI.setRainTime(llllllllllllllIIlllIIlIlIIlIIlII);
                llllllllllllllIIlllIIlIlIIlIIIlI.setThunderTime(llllllllllllllIIlllIIlIlIIlIIlII);
                llllllllllllllIIlllIIlIlIIlIIIlI.setRaining(true);
                llllllllllllllIIlllIIlIlIIlIIIlI.setThundering(true);
                CommandBase.notifyOperators(llllllllllllllIIlllIIlIlIIlIIIII, this, "commands.weather.thunder", new Object[0]);
            }
            return;
        }
        throw new WrongUsageException("commands.weather.usage", new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIlllIIlIlIIlIlllI) {
        return "commands.weather.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    static {
        __OBFID = "CL_00001185";
    }
}
