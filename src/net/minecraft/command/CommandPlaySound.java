package net.minecraft.command;

import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;

public class CommandPlaySound extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender lllllllllllllllllIlIIlIIIIIlllIl, final String[] lllllllllllllllllIlIIlIIIIllIIII) throws CommandException {
        if (lllllllllllllllllIlIIlIIIIllIIII.length < 2) {
            throw new WrongUsageException(this.getCommandUsage(lllllllllllllllllIlIIlIIIIIlllIl), new Object[0]);
        }
        final byte lllllllllllllllllIlIIlIIIIlIllll = 0;
        int lllllllllllllllllIlIIlIIIIlIlllI = lllllllllllllllllIlIIlIIIIlIllll + 1;
        final String lllllllllllllllllIlIIlIIIIlIllIl = lllllllllllllllllIlIIlIIIIllIIII[lllllllllllllllllIlIIlIIIIlIllll];
        final EntityPlayerMP lllllllllllllllllIlIIlIIIIlIllII = CommandBase.getPlayer(lllllllllllllllllIlIIlIIIIIlllIl, lllllllllllllllllIlIIlIIIIllIIII[lllllllllllllllllIlIIlIIIIlIlllI++]);
        final Vec3 lllllllllllllllllIlIIlIIIIlIlIll = lllllllllllllllllIlIIlIIIIIlllIl.getPositionVector();
        double lllllllllllllllllIlIIlIIIIlIlIlI = lllllllllllllllllIlIIlIIIIlIlIll.xCoord;
        if (lllllllllllllllllIlIIlIIIIllIIII.length > lllllllllllllllllIlIIlIIIIlIlllI) {
            lllllllllllllllllIlIIlIIIIlIlIlI = CommandBase.func_175761_b(lllllllllllllllllIlIIlIIIIlIlIlI, lllllllllllllllllIlIIlIIIIllIIII[lllllllllllllllllIlIIlIIIIlIlllI++], true);
        }
        double lllllllllllllllllIlIIlIIIIlIlIIl = lllllllllllllllllIlIIlIIIIlIlIll.yCoord;
        if (lllllllllllllllllIlIIlIIIIllIIII.length > lllllllllllllllllIlIIlIIIIlIlllI) {
            lllllllllllllllllIlIIlIIIIlIlIIl = CommandBase.func_175769_b(lllllllllllllllllIlIIlIIIIlIlIIl, lllllllllllllllllIlIIlIIIIllIIII[lllllllllllllllllIlIIlIIIIlIlllI++], 0, 0, false);
        }
        double lllllllllllllllllIlIIlIIIIlIlIII = lllllllllllllllllIlIIlIIIIlIlIll.zCoord;
        if (lllllllllllllllllIlIIlIIIIllIIII.length > lllllllllllllllllIlIIlIIIIlIlllI) {
            lllllllllllllllllIlIIlIIIIlIlIII = CommandBase.func_175761_b(lllllllllllllllllIlIIlIIIIlIlIII, lllllllllllllllllIlIIlIIIIllIIII[lllllllllllllllllIlIIlIIIIlIlllI++], true);
        }
        double lllllllllllllllllIlIIlIIIIlIIlll = 1.0;
        if (lllllllllllllllllIlIIlIIIIllIIII.length > lllllllllllllllllIlIIlIIIIlIlllI) {
            lllllllllllllllllIlIIlIIIIlIIlll = CommandBase.parseDouble(lllllllllllllllllIlIIlIIIIllIIII[lllllllllllllllllIlIIlIIIIlIlllI++], 0.0, 3.4028234663852886E38);
        }
        double lllllllllllllllllIlIIlIIIIlIIllI = 1.0;
        if (lllllllllllllllllIlIIlIIIIllIIII.length > lllllllllllllllllIlIIlIIIIlIlllI) {
            lllllllllllllllllIlIIlIIIIlIIllI = CommandBase.parseDouble(lllllllllllllllllIlIIlIIIIllIIII[lllllllllllllllllIlIIlIIIIlIlllI++], 0.0, 2.0);
        }
        double lllllllllllllllllIlIIlIIIIlIIlIl = 0.0;
        if (lllllllllllllllllIlIIlIIIIllIIII.length > lllllllllllllllllIlIIlIIIIlIlllI) {
            lllllllllllllllllIlIIlIIIIlIIlIl = CommandBase.parseDouble(lllllllllllllllllIlIIlIIIIllIIII[lllllllllllllllllIlIIlIIIIlIlllI], 0.0, 1.0);
        }
        final double lllllllllllllllllIlIIlIIIIlIIlII = (lllllllllllllllllIlIIlIIIIlIIlll > 1.0) ? (lllllllllllllllllIlIIlIIIIlIIlll * 16.0) : 16.0;
        final double lllllllllllllllllIlIIlIIIIlIIIll = lllllllllllllllllIlIIlIIIIlIllII.getDistance(lllllllllllllllllIlIIlIIIIlIlIlI, lllllllllllllllllIlIIlIIIIlIlIIl, lllllllllllllllllIlIIlIIIIlIlIII);
        if (lllllllllllllllllIlIIlIIIIlIIIll > lllllllllllllllllIlIIlIIIIlIIlII) {
            if (lllllllllllllllllIlIIlIIIIlIIlIl <= 0.0) {
                throw new CommandException("commands.playsound.playerTooFar", new Object[] { lllllllllllllllllIlIIlIIIIlIllII.getName() });
            }
            final double lllllllllllllllllIlIIlIIIIlIIIlI = lllllllllllllllllIlIIlIIIIlIlIlI - lllllllllllllllllIlIIlIIIIlIllII.posX;
            final double lllllllllllllllllIlIIlIIIIlIIIIl = lllllllllllllllllIlIIlIIIIlIlIIl - lllllllllllllllllIlIIlIIIIlIllII.posY;
            final double lllllllllllllllllIlIIlIIIIlIIIII = lllllllllllllllllIlIIlIIIIlIlIII - lllllllllllllllllIlIIlIIIIlIllII.posZ;
            final double lllllllllllllllllIlIIlIIIIIlllll = Math.sqrt(lllllllllllllllllIlIIlIIIIlIIIlI * lllllllllllllllllIlIIlIIIIlIIIlI + lllllllllllllllllIlIIlIIIIlIIIIl * lllllllllllllllllIlIIlIIIIlIIIIl + lllllllllllllllllIlIIlIIIIlIIIII * lllllllllllllllllIlIIlIIIIlIIIII);
            if (lllllllllllllllllIlIIlIIIIIlllll > 0.0) {
                lllllllllllllllllIlIIlIIIIlIlIlI = lllllllllllllllllIlIIlIIIIlIllII.posX + lllllllllllllllllIlIIlIIIIlIIIlI / lllllllllllllllllIlIIlIIIIIlllll * 2.0;
                lllllllllllllllllIlIIlIIIIlIlIIl = lllllllllllllllllIlIIlIIIIlIllII.posY + lllllllllllllllllIlIIlIIIIlIIIIl / lllllllllllllllllIlIIlIIIIIlllll * 2.0;
                lllllllllllllllllIlIIlIIIIlIlIII = lllllllllllllllllIlIIlIIIIlIllII.posZ + lllllllllllllllllIlIIlIIIIlIIIII / lllllllllllllllllIlIIlIIIIIlllll * 2.0;
            }
            lllllllllllllllllIlIIlIIIIlIIlll = lllllllllllllllllIlIIlIIIIlIIlIl;
        }
        lllllllllllllllllIlIIlIIIIlIllII.playerNetServerHandler.sendPacket(new S29PacketSoundEffect(lllllllllllllllllIlIIlIIIIlIllIl, lllllllllllllllllIlIIlIIIIlIlIlI, lllllllllllllllllIlIIlIIIIlIlIIl, lllllllllllllllllIlIIlIIIIlIlIII, (float)lllllllllllllllllIlIIlIIIIlIIlll, (float)lllllllllllllllllIlIIlIIIIlIIllI));
        CommandBase.notifyOperators(lllllllllllllllllIlIIlIIIIIlllIl, this, "commands.playsound.success", lllllllllllllllllIlIIlIIIIlIllIl, lllllllllllllllllIlIIlIIIIlIllII.getName());
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllllIlIIlIIIlIIIlll) {
        return "commands.playsound.usage";
    }
    
    static {
        __OBFID = "CL_00000774";
    }
    
    @Override
    public String getCommandName() {
        return "playsound";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllllIlIIIlllllllIlI, final String[] lllllllllllllllllIlIIIlllllllIII, final BlockPos lllllllllllllllllIlIIIllllllIllI) {
        return (lllllllllllllllllIlIIIlllllllIII.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllIlIIIlllllllIII, MinecraftServer.getServer().getAllUsernames()) : ((lllllllllllllllllIlIIIlllllllIII.length > 2 && lllllllllllllllllIlIIIlllllllIII.length <= 5) ? CommandBase.func_175771_a(lllllllllllllllllIlIIIlllllllIII, 2, lllllllllllllllllIlIIIllllllIllI) : null);
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllllIlIIIlllllIlIII, final int lllllllllllllllllIlIIIlllllIIlII) {
        return lllllllllllllllllIlIIIlllllIIlII == 1;
    }
}
