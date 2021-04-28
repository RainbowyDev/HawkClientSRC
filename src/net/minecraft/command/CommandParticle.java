package net.minecraft.command;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class CommandParticle extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllllllIlIllIIllIIll, final String[] lllllllllllllllllllIlIllIIllIIlI, final BlockPos lllllllllllllllllllIlIllIIlIllll) {
        return (lllllllllllllllllllIlIllIIllIIlI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllllIlIllIIllIIlI, EnumParticleTypes.func_179349_a()) : ((lllllllllllllllllllIlIllIIllIIlI.length > 1 && lllllllllllllllllllIlIllIIllIIlI.length <= 4) ? CommandBase.func_175771_a(lllllllllllllllllllIlIllIIllIIlI, 1, lllllllllllllllllllIlIllIIlIllll) : ((lllllllllllllllllllIlIllIIllIIlI.length == 9) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllllIlIllIIllIIlI, "normal", "force") : null));
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllllllIlIlllIIIIIIl) {
        return "commands.particle.usage";
    }
    
    @Override
    public String getCommandName() {
        return "particle";
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllllllIlIllIlIIllIl, final String[] lllllllllllllllllllIlIllIllIIllI) throws CommandException {
        if (lllllllllllllllllllIlIllIllIIllI.length < 8) {
            throw new WrongUsageException("commands.particle.usage", new Object[0]);
        }
        boolean lllllllllllllllllllIlIllIllIIlIl = false;
        EnumParticleTypes lllllllllllllllllllIlIllIllIIlII = null;
        for (final EnumParticleTypes lllllllllllllllllllIlIllIllIIIII : EnumParticleTypes.values()) {
            if (lllllllllllllllllllIlIllIllIIIII.func_179343_f()) {
                if (lllllllllllllllllllIlIllIllIIllI[0].startsWith(lllllllllllllllllllIlIllIllIIIII.func_179346_b())) {
                    lllllllllllllllllllIlIllIllIIlIl = true;
                    lllllllllllllllllllIlIllIllIIlII = lllllllllllllllllllIlIllIllIIIII;
                    break;
                }
            }
            else if (lllllllllllllllllllIlIllIllIIllI[0].equals(lllllllllllllllllllIlIllIllIIIII.func_179346_b())) {
                lllllllllllllllllllIlIllIllIIlIl = true;
                lllllllllllllllllllIlIllIllIIlII = lllllllllllllllllllIlIllIllIIIII;
                break;
            }
        }
        if (!lllllllllllllllllllIlIllIllIIlIl) {
            throw new CommandException("commands.particle.notFound", new Object[] { lllllllllllllllllllIlIllIllIIllI[0] });
        }
        final String lllllllllllllllllllIlIllIlIlllll = lllllllllllllllllllIlIllIllIIllI[0];
        final Vec3 lllllllllllllllllllIlIllIlIllllI = lllllllllllllllllllIlIllIlIIllIl.getPositionVector();
        final double lllllllllllllllllllIlIllIlIlllIl = (float)CommandBase.func_175761_b(lllllllllllllllllllIlIllIlIllllI.xCoord, lllllllllllllllllllIlIllIllIIllI[1], true);
        final double lllllllllllllllllllIlIllIlIlllII = (float)CommandBase.func_175761_b(lllllllllllllllllllIlIllIlIllllI.yCoord, lllllllllllllllllllIlIllIllIIllI[2], true);
        final double lllllllllllllllllllIlIllIlIllIll = (float)CommandBase.func_175761_b(lllllllllllllllllllIlIllIlIllllI.zCoord, lllllllllllllllllllIlIllIllIIllI[3], true);
        final double lllllllllllllllllllIlIllIlIllIlI = (float)CommandBase.parseDouble(lllllllllllllllllllIlIllIllIIllI[4]);
        final double lllllllllllllllllllIlIllIlIllIIl = (float)CommandBase.parseDouble(lllllllllllllllllllIlIllIllIIllI[5]);
        final double lllllllllllllllllllIlIllIlIllIII = (float)CommandBase.parseDouble(lllllllllllllllllllIlIllIllIIllI[6]);
        final double lllllllllllllllllllIlIllIlIlIlll = (float)CommandBase.parseDouble(lllllllllllllllllllIlIllIllIIllI[7]);
        int lllllllllllllllllllIlIllIlIlIllI = 0;
        if (lllllllllllllllllllIlIllIllIIllI.length > 8) {
            lllllllllllllllllllIlIllIlIlIllI = CommandBase.parseInt(lllllllllllllllllllIlIllIllIIllI[8], 0);
        }
        boolean lllllllllllllllllllIlIllIlIlIlIl = false;
        if (lllllllllllllllllllIlIllIllIIllI.length > 9 && "force".equals(lllllllllllllllllllIlIllIllIIllI[9])) {
            lllllllllllllllllllIlIllIlIlIlIl = true;
        }
        final World lllllllllllllllllllIlIllIlIlIlII = lllllllllllllllllllIlIllIlIIllIl.getEntityWorld();
        if (lllllllllllllllllllIlIllIlIlIlII instanceof WorldServer) {
            final WorldServer lllllllllllllllllllIlIllIlIlIIll = (WorldServer)lllllllllllllllllllIlIllIlIlIlII;
            final int[] lllllllllllllllllllIlIllIlIlIIlI = new int[lllllllllllllllllllIlIllIllIIlII.func_179345_d()];
            if (lllllllllllllllllllIlIllIllIIlII.func_179343_f()) {
                final String[] lllllllllllllllllllIlIllIlIlIIIl = lllllllllllllllllllIlIllIllIIllI[0].split("_", 3);
                for (int lllllllllllllllllllIlIllIlIlIIII = 1; lllllllllllllllllllIlIllIlIlIIII < lllllllllllllllllllIlIllIlIlIIIl.length; ++lllllllllllllllllllIlIllIlIlIIII) {
                    try {
                        lllllllllllllllllllIlIllIlIlIIlI[lllllllllllllllllllIlIllIlIlIIII - 1] = Integer.parseInt(lllllllllllllllllllIlIllIlIlIIIl[lllllllllllllllllllIlIllIlIlIIII]);
                    }
                    catch (NumberFormatException lllllllllllllllllllIlIllIlIIllll) {
                        throw new CommandException("commands.particle.notFound", new Object[] { lllllllllllllllllllIlIllIllIIllI[0] });
                    }
                }
            }
            lllllllllllllllllllIlIllIlIlIIll.func_180505_a(lllllllllllllllllllIlIllIllIIlII, lllllllllllllllllllIlIllIlIlIlIl, lllllllllllllllllllIlIllIlIlllIl, lllllllllllllllllllIlIllIlIlllII, lllllllllllllllllllIlIllIlIllIll, lllllllllllllllllllIlIllIlIlIllI, lllllllllllllllllllIlIllIlIllIlI, lllllllllllllllllllIlIllIlIllIIl, lllllllllllllllllllIlIllIlIllIII, lllllllllllllllllllIlIllIlIlIlll, lllllllllllllllllllIlIllIlIlIIlI);
            CommandBase.notifyOperators(lllllllllllllllllllIlIllIlIIllIl, this, "commands.particle.success", lllllllllllllllllllIlIllIlIlllll, Math.max(lllllllllllllllllllIlIllIlIlIllI, 1));
        }
    }
    
    static {
        __OBFID = "CL_00002341";
    }
}
