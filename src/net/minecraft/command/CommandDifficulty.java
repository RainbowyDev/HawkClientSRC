package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;

public class CommandDifficulty extends CommandBase
{
    static {
        __OBFID = "CL_00000422";
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIllIlIlllIlllIIIl, final String[] lllllllllllllllIllIlIlllIlllIIII) throws CommandException {
        if (lllllllllllllllIllIlIlllIlllIIII.length <= 0) {
            throw new WrongUsageException("commands.difficulty.usage", new Object[0]);
        }
        final EnumDifficulty lllllllllllllllIllIlIlllIlllIIll = this.func_180531_e(lllllllllllllllIllIlIlllIlllIIII[0]);
        MinecraftServer.getServer().setDifficultyForAllWorlds(lllllllllllllllIllIlIlllIlllIIll);
        CommandBase.notifyOperators(lllllllllllllllIllIlIlllIlllIIIl, this, "commands.difficulty.success", new ChatComponentTranslation(lllllllllllllllIllIlIlllIlllIIll.getDifficultyResourceKey(), new Object[0]));
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIllIlIlllIllIlIII, final String[] lllllllllllllllIllIlIlllIllIIlIl, final BlockPos lllllllllllllllIllIlIlllIllIIllI) {
        return (lllllllllllllllIllIlIlllIllIIlIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIllIlIlllIllIIlIl, "peaceful", "easy", "normal", "hard") : null;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIllIlIlllIllllIll) {
        return "commands.difficulty.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "difficulty";
    }
    
    protected EnumDifficulty func_180531_e(final String lllllllllllllllIllIlIlllIllIlIll) throws CommandException {
        return (!lllllllllllllllIllIlIlllIllIlIll.equalsIgnoreCase("peaceful") && !lllllllllllllllIllIlIlllIllIlIll.equalsIgnoreCase("p")) ? ((!lllllllllllllllIllIlIlllIllIlIll.equalsIgnoreCase("easy") && !lllllllllllllllIllIlIlllIllIlIll.equalsIgnoreCase("e")) ? ((!lllllllllllllllIllIlIlllIllIlIll.equalsIgnoreCase("normal") && !lllllllllllllllIllIlIlllIllIlIll.equalsIgnoreCase("n")) ? ((!lllllllllllllllIllIlIlllIllIlIll.equalsIgnoreCase("hard") && !lllllllllllllllIllIlIlllIllIlIll.equalsIgnoreCase("h")) ? EnumDifficulty.getDifficultyEnum(CommandBase.parseInt(lllllllllllllllIllIlIlllIllIlIll, 0, 3)) : EnumDifficulty.HARD) : EnumDifficulty.NORMAL) : EnumDifficulty.EASY) : EnumDifficulty.PEACEFUL;
    }
}
