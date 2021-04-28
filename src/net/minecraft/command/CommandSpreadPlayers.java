package net.minecraft.command;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.scoreboard.*;
import com.google.common.collect.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;

public class CommandSpreadPlayers extends CommandBase
{
    private double func_110671_a(final List lllllllllllllllIIlIllIIllIIllllI, final World lllllllllllllllIIlIllIIllIlIllII, final Position[] lllllllllllllllIIlIllIIllIIlllII, final boolean lllllllllllllllIIlIllIIllIIllIll) {
        double lllllllllllllllIIlIllIIllIlIlIIl = 0.0;
        int lllllllllllllllIIlIllIIllIlIlIII = 0;
        final HashMap lllllllllllllllIIlIllIIllIlIIlll = Maps.newHashMap();
        for (int lllllllllllllllIIlIllIIllIlIIllI = 0; lllllllllllllllIIlIllIIllIlIIllI < lllllllllllllllIIlIllIIllIIllllI.size(); ++lllllllllllllllIIlIllIIllIlIIllI) {
            final Entity lllllllllllllllIIlIllIIllIlIIlIl = lllllllllllllllIIlIllIIllIIllllI.get(lllllllllllllllIIlIllIIllIlIIllI);
            Position lllllllllllllllIIlIllIIllIlIIIll = null;
            if (lllllllllllllllIIlIllIIllIIllIll) {
                final Team lllllllllllllllIIlIllIIllIlIIIlI = (lllllllllllllllIIlIllIIllIlIIlIl instanceof EntityPlayer) ? ((EntityPlayer)lllllllllllllllIIlIllIIllIlIIlIl).getTeam() : null;
                if (!lllllllllllllllIIlIllIIllIlIIlll.containsKey(lllllllllllllllIIlIllIIllIlIIIlI)) {
                    lllllllllllllllIIlIllIIllIlIIlll.put(lllllllllllllllIIlIllIIllIlIIIlI, lllllllllllllllIIlIllIIllIIlllII[lllllllllllllllIIlIllIIllIlIlIII++]);
                }
                final Position lllllllllllllllIIlIllIIllIlIIlII = lllllllllllllllIIlIllIIllIlIIlll.get(lllllllllllllllIIlIllIIllIlIIIlI);
            }
            else {
                lllllllllllllllIIlIllIIllIlIIIll = lllllllllllllllIIlIllIIllIIlllII[lllllllllllllllIIlIllIIllIlIlIII++];
            }
            lllllllllllllllIIlIllIIllIlIIlIl.setPositionAndUpdate(MathHelper.floor_double(lllllllllllllllIIlIllIIllIlIIIll.field_111101_a) + 0.5f, lllllllllllllllIIlIllIIllIlIIIll.func_111092_a(lllllllllllllllIIlIllIIllIlIllII), MathHelper.floor_double(lllllllllllllllIIlIllIIllIlIIIll.field_111100_b) + 0.5);
            double lllllllllllllllIIlIllIIllIlIIIIl = Double.MAX_VALUE;
            for (int lllllllllllllllIIlIllIIllIlIIIII = 0; lllllllllllllllIIlIllIIllIlIIIII < lllllllllllllllIIlIllIIllIIlllII.length; ++lllllllllllllllIIlIllIIllIlIIIII) {
                if (lllllllllllllllIIlIllIIllIlIIIll != lllllllllllllllIIlIllIIllIIlllII[lllllllllllllllIIlIllIIllIlIIIII]) {
                    final double lllllllllllllllIIlIllIIllIIlllll = lllllllllllllllIIlIllIIllIlIIIll.func_111099_a(lllllllllllllllIIlIllIIllIIlllII[lllllllllllllllIIlIllIIllIlIIIII]);
                    lllllllllllllllIIlIllIIllIlIIIIl = Math.min(lllllllllllllllIIlIllIIllIIlllll, lllllllllllllllIIlIllIIllIlIIIIl);
                }
            }
            lllllllllllllllIIlIllIIllIlIlIIl += lllllllllllllllIIlIllIIllIlIIIIl;
        }
        lllllllllllllllIIlIllIIllIlIlIIl /= lllllllllllllllIIlIllIIllIIllllI.size();
        return lllllllllllllllIIlIllIIllIlIlIIl;
    }
    
    private int func_110667_a(final List lllllllllllllllIIlIllIlIIIIIIlIl) {
        final HashSet lllllllllllllllIIlIllIlIIIIIIlII = Sets.newHashSet();
        for (final Entity lllllllllllllllIIlIllIlIIIIIIIlI : lllllllllllllllIIlIllIlIIIIIIlIl) {
            if (lllllllllllllllIIlIllIlIIIIIIIlI instanceof EntityPlayer) {
                lllllllllllllllIIlIllIlIIIIIIlII.add(((EntityPlayer)lllllllllllllllIIlIllIlIIIIIIIlI).getTeam());
            }
            else {
                lllllllllllllllIIlIllIlIIIIIIlII.add(null);
            }
        }
        return lllllllllllllllIIlIllIlIIIIIIlII.size();
    }
    
    private Position[] func_110670_a(final Random lllllllllllllllIIlIllIIlIllllllI, final int lllllllllllllllIIlIllIIlIlllllIl, final double lllllllllllllllIIlIllIIlIlllllII, final double lllllllllllllllIIlIllIIlIllllIll, final double lllllllllllllllIIlIllIIlIllllIlI, final double lllllllllllllllIIlIllIIllIIIIIlI) {
        final Position[] lllllllllllllllIIlIllIIllIIIIIIl = new Position[lllllllllllllllIIlIllIIlIlllllIl];
        for (int lllllllllllllllIIlIllIIllIIIIIII = 0; lllllllllllllllIIlIllIIllIIIIIII < lllllllllllllllIIlIllIIllIIIIIIl.length; ++lllllllllllllllIIlIllIIllIIIIIII) {
            final Position lllllllllllllllIIlIllIIlIlllllll = new Position();
            lllllllllllllllIIlIllIIlIlllllll.func_111097_a(lllllllllllllllIIlIllIIlIllllllI, lllllllllllllllIIlIllIIlIlllllII, lllllllllllllllIIlIllIIlIllllIll, lllllllllllllllIIlIllIIlIllllIlI, lllllllllllllllIIlIllIIllIIIIIlI);
            lllllllllllllllIIlIllIIllIIIIIIl[lllllllllllllllIIlIllIIllIIIIIII] = lllllllllllllllIIlIllIIlIlllllll;
        }
        return lllllllllllllllIIlIllIIllIIIIIIl;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    static {
        __OBFID = "CL_00001080";
    }
    
    private void func_110669_a(final ICommandSender lllllllllllllllIIlIllIlIIIlIlIIl, final List lllllllllllllllIIlIllIlIIIIllIII, final Position lllllllllllllllIIlIllIlIIIIlIlll, final double lllllllllllllllIIlIllIlIIIlIIllI, final double lllllllllllllllIIlIllIlIIIIlIlIl, final World lllllllllllllllIIlIllIlIIIIlIlII, final boolean lllllllllllllllIIlIllIlIIIlIIIll) throws CommandException {
        final Random lllllllllllllllIIlIllIlIIIlIIIlI = new Random();
        final double lllllllllllllllIIlIllIlIIIlIIIIl = lllllllllllllllIIlIllIlIIIIlIlll.field_111101_a - lllllllllllllllIIlIllIlIIIIlIlIl;
        final double lllllllllllllllIIlIllIlIIIlIIIII = lllllllllllllllIIlIllIlIIIIlIlll.field_111100_b - lllllllllllllllIIlIllIlIIIIlIlIl;
        final double lllllllllllllllIIlIllIlIIIIlllll = lllllllllllllllIIlIllIlIIIIlIlll.field_111101_a + lllllllllllllllIIlIllIlIIIIlIlIl;
        final double lllllllllllllllIIlIllIlIIIIllllI = lllllllllllllllIIlIllIlIIIIlIlll.field_111100_b + lllllllllllllllIIlIllIlIIIIlIlIl;
        final Position[] lllllllllllllllIIlIllIlIIIIlllIl = this.func_110670_a(lllllllllllllllIIlIllIlIIIlIIIlI, lllllllllllllllIIlIllIlIIIlIIIll ? this.func_110667_a(lllllllllllllllIIlIllIlIIIIllIII) : lllllllllllllllIIlIllIlIIIIllIII.size(), lllllllllllllllIIlIllIlIIIlIIIIl, lllllllllllllllIIlIllIlIIIlIIIII, lllllllllllllllIIlIllIlIIIIlllll, lllllllllllllllIIlIllIlIIIIllllI);
        final int lllllllllllllllIIlIllIlIIIIlllII = this.func_110668_a(lllllllllllllllIIlIllIlIIIIlIlll, lllllllllllllllIIlIllIlIIIlIIllI, lllllllllllllllIIlIllIlIIIIlIlII, lllllllllllllllIIlIllIlIIIlIIIlI, lllllllllllllllIIlIllIlIIIlIIIIl, lllllllllllllllIIlIllIlIIIlIIIII, lllllllllllllllIIlIllIlIIIIlllll, lllllllllllllllIIlIllIlIIIIllllI, lllllllllllllllIIlIllIlIIIIlllIl, lllllllllllllllIIlIllIlIIIlIIIll);
        final double lllllllllllllllIIlIllIlIIIIllIll = this.func_110671_a(lllllllllllllllIIlIllIlIIIIllIII, lllllllllllllllIIlIllIlIIIIlIlII, lllllllllllllllIIlIllIlIIIIlllIl, lllllllllllllllIIlIllIlIIIlIIIll);
        CommandBase.notifyOperators(lllllllllllllllIIlIllIlIIIlIlIIl, this, String.valueOf(new StringBuilder("commands.spreadplayers.success.").append(lllllllllllllllIIlIllIlIIIlIIIll ? "teams" : "players")), lllllllllllllllIIlIllIlIIIIlllIl.length, lllllllllllllllIIlIllIlIIIIlIlll.field_111101_a, lllllllllllllllIIlIllIlIIIIlIlll.field_111100_b);
        if (lllllllllllllllIIlIllIlIIIIlllIl.length > 1) {
            lllllllllllllllIIlIllIlIIIlIlIIl.addChatMessage(new ChatComponentTranslation(String.valueOf(new StringBuilder("commands.spreadplayers.info.").append(lllllllllllllllIIlIllIlIIIlIIIll ? "teams" : "players")), new Object[] { String.format("%.2f", lllllllllllllllIIlIllIlIIIIllIll), lllllllllllllllIIlIllIlIIIIlllII }));
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIIlIllIlIIllIlIIl) {
        return "commands.spreadplayers.usage";
    }
    
    @Override
    public String getCommandName() {
        return "spreadplayers";
    }
    
    private int func_110668_a(final Position lllllllllllllllIIlIllIIllllIlIII, final double lllllllllllllllIIlIllIIlllIIlllI, final World lllllllllllllllIIlIllIIllllIIllI, final Random lllllllllllllllIIlIllIIllllIIlIl, final double lllllllllllllllIIlIllIIlllIIlIll, final double lllllllllllllllIIlIllIIlllIIlIlI, final double lllllllllllllllIIlIllIIlllIIlIIl, final double lllllllllllllllIIlIllIIlllIIlIII, final Position[] lllllllllllllllIIlIllIIlllIIIlll, final boolean lllllllllllllllIIlIllIIlllIIIllI) throws CommandException {
        boolean lllllllllllllllIIlIllIIlllIllllI = true;
        double lllllllllllllllIIlIllIIlllIlllIl = 3.4028234663852886E38;
        int lllllllllllllllIIlIllIIlllIlllII;
        for (lllllllllllllllIIlIllIIlllIlllII = 0; lllllllllllllllIIlIllIIlllIlllII < 10000 && lllllllllllllllIIlIllIIlllIllllI; ++lllllllllllllllIIlIllIIlllIlllII) {
            lllllllllllllllIIlIllIIlllIllllI = false;
            lllllllllllllllIIlIllIIlllIlllIl = 3.4028234663852886E38;
            for (int lllllllllllllllIIlIllIIlllIlIlll = 0; lllllllllllllllIIlIllIIlllIlIlll < lllllllllllllllIIlIllIIlllIIIlll.length; ++lllllllllllllllIIlIllIIlllIlIlll) {
                final Position lllllllllllllllIIlIllIIlllIlIllI = lllllllllllllllIIlIllIIlllIIIlll[lllllllllllllllIIlIllIIlllIlIlll];
                int lllllllllllllllIIlIllIIlllIllIll = 0;
                final Position lllllllllllllllIIlIllIIlllIllIIl = new Position();
                for (int lllllllllllllllIIlIllIIlllIlIlIl = 0; lllllllllllllllIIlIllIIlllIlIlIl < lllllllllllllllIIlIllIIlllIIIlll.length; ++lllllllllllllllIIlIllIIlllIlIlIl) {
                    if (lllllllllllllllIIlIllIIlllIlIlll != lllllllllllllllIIlIllIIlllIlIlIl) {
                        final Position lllllllllllllllIIlIllIIlllIlIlII = lllllllllllllllIIlIllIIlllIIIlll[lllllllllllllllIIlIllIIlllIlIlIl];
                        final double lllllllllllllllIIlIllIIlllIlIIll = lllllllllllllllIIlIllIIlllIlIllI.func_111099_a(lllllllllllllllIIlIllIIlllIlIlII);
                        lllllllllllllllIIlIllIIlllIlllIl = Math.min(lllllllllllllllIIlIllIIlllIlIIll, lllllllllllllllIIlIllIIlllIlllIl);
                        if (lllllllllllllllIIlIllIIlllIlIIll < lllllllllllllllIIlIllIIlllIIlllI) {
                            ++lllllllllllllllIIlIllIIlllIllIll;
                            final Position position = lllllllllllllllIIlIllIIlllIllIIl;
                            position.field_111101_a += lllllllllllllllIIlIllIIlllIlIlII.field_111101_a - lllllllllllllllIIlIllIIlllIlIllI.field_111101_a;
                            final Position position2 = lllllllllllllllIIlIllIIlllIllIIl;
                            position2.field_111100_b += lllllllllllllllIIlIllIIlllIlIlII.field_111100_b - lllllllllllllllIIlIllIIlllIlIllI.field_111100_b;
                        }
                    }
                }
                if (lllllllllllllllIIlIllIIlllIllIll > 0) {
                    final Position position3 = lllllllllllllllIIlIllIIlllIllIIl;
                    position3.field_111101_a /= lllllllllllllllIIlIllIIlllIllIll;
                    final Position position4 = lllllllllllllllIIlIllIIlllIllIIl;
                    position4.field_111100_b /= lllllllllllllllIIlIllIIlllIllIll;
                    final double lllllllllllllllIIlIllIIlllIlIIlI = lllllllllllllllIIlIllIIlllIllIIl.func_111096_b();
                    if (lllllllllllllllIIlIllIIlllIlIIlI > 0.0) {
                        lllllllllllllllIIlIllIIlllIllIIl.func_111095_a();
                        lllllllllllllllIIlIllIIlllIlIllI.func_111094_b(lllllllllllllllIIlIllIIlllIllIIl);
                    }
                    else {
                        lllllllllllllllIIlIllIIlllIlIllI.func_111097_a(lllllllllllllllIIlIllIIllllIIlIl, lllllllllllllllIIlIllIIlllIIlIll, lllllllllllllllIIlIllIIlllIIlIlI, lllllllllllllllIIlIllIIlllIIlIIl, lllllllllllllllIIlIllIIlllIIlIII);
                    }
                    lllllllllllllllIIlIllIIlllIllllI = true;
                }
                if (lllllllllllllllIIlIllIIlllIlIllI.func_111093_a(lllllllllllllllIIlIllIIlllIIlIll, lllllllllllllllIIlIllIIlllIIlIlI, lllllllllllllllIIlIllIIlllIIlIIl, lllllllllllllllIIlIllIIlllIIlIII)) {
                    lllllllllllllllIIlIllIIlllIllllI = true;
                }
            }
            if (!lllllllllllllllIIlIllIIlllIllllI) {
                final Position[] lllllllllllllllIIlIllIIlllIlIIIl = lllllllllllllllIIlIllIIlllIIIlll;
                for (int lllllllllllllllIIlIllIIlllIlIIII = lllllllllllllllIIlIllIIlllIIIlll.length, lllllllllllllllIIlIllIIlllIllIlI = 0; lllllllllllllllIIlIllIIlllIllIlI < lllllllllllllllIIlIllIIlllIlIIII; ++lllllllllllllllIIlIllIIlllIllIlI) {
                    final Position lllllllllllllllIIlIllIIlllIllIII = lllllllllllllllIIlIllIIlllIlIIIl[lllllllllllllllIIlIllIIlllIllIlI];
                    if (!lllllllllllllllIIlIllIIlllIllIII.func_111098_b(lllllllllllllllIIlIllIIllllIIllI)) {
                        lllllllllllllllIIlIllIIlllIllIII.func_111097_a(lllllllllllllllIIlIllIIllllIIlIl, lllllllllllllllIIlIllIIlllIIlIll, lllllllllllllllIIlIllIIlllIIlIlI, lllllllllllllllIIlIllIIlllIIlIIl, lllllllllllllllIIlIllIIlllIIlIII);
                        lllllllllllllllIIlIllIIlllIllllI = true;
                    }
                }
            }
        }
        if (lllllllllllllllIIlIllIIlllIlllII >= 10000) {
            throw new CommandException(String.valueOf(new StringBuilder("commands.spreadplayers.failure.").append(lllllllllllllllIIlIllIIlllIIIllI ? "teams" : "players")), new Object[] { lllllllllllllllIIlIllIIlllIIIlll.length, lllllllllllllllIIlIllIIllllIlIII.field_111101_a, lllllllllllllllIIlIllIIllllIlIII.field_111100_b, String.format("%.2f", lllllllllllllllIIlIllIIlllIlllIl) });
        }
        return lllllllllllllllIIlIllIIlllIlllII;
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIIlIllIlIIlIIlIII, final String[] lllllllllllllllIIlIllIlIIlIIIlll) throws CommandException {
        if (lllllllllllllllIIlIllIlIIlIIIlll.length < 6) {
            throw new WrongUsageException("commands.spreadplayers.usage", new Object[0]);
        }
        final byte lllllllllllllllIIlIllIlIIlIlIllI = 0;
        final BlockPos lllllllllllllllIIlIllIlIIlIlIlIl = lllllllllllllllIIlIllIlIIlIIlIII.getPosition();
        final double lllllllllllllllIIlIllIlIIlIlIlII = lllllllllllllllIIlIllIlIIlIlIlIl.getX();
        int lllllllllllllllIIlIllIlIIlIlIIll = lllllllllllllllIIlIllIlIIlIlIllI + 1;
        final double lllllllllllllllIIlIllIlIIlIlIIlI = CommandBase.func_175761_b(lllllllllllllllIIlIllIlIIlIlIlII, lllllllllllllllIIlIllIlIIlIIIlll[lllllllllllllllIIlIllIlIIlIlIllI], true);
        final double lllllllllllllllIIlIllIlIIlIlIIIl = CommandBase.func_175761_b(lllllllllllllllIIlIllIlIIlIlIlIl.getZ(), lllllllllllllllIIlIllIlIIlIIIlll[lllllllllllllllIIlIllIlIIlIlIIll++], true);
        final double lllllllllllllllIIlIllIlIIlIlIIII = CommandBase.parseDouble(lllllllllllllllIIlIllIlIIlIIIlll[lllllllllllllllIIlIllIlIIlIlIIll++], 0.0);
        final double lllllllllllllllIIlIllIlIIlIIllll = CommandBase.parseDouble(lllllllllllllllIIlIllIlIIlIIIlll[lllllllllllllllIIlIllIlIIlIlIIll++], lllllllllllllllIIlIllIlIIlIlIIII + 1.0);
        final boolean lllllllllllllllIIlIllIlIIlIIlllI = CommandBase.parseBoolean(lllllllllllllllIIlIllIlIIlIIIlll[lllllllllllllllIIlIllIlIIlIlIIll++]);
        final ArrayList lllllllllllllllIIlIllIlIIlIIllIl = Lists.newArrayList();
        while (lllllllllllllllIIlIllIlIIlIlIIll < lllllllllllllllIIlIllIlIIlIIIlll.length) {
            final String lllllllllllllllIIlIllIlIIlIIllII = lllllllllllllllIIlIllIlIIlIIIlll[lllllllllllllllIIlIllIlIIlIlIIll++];
            if (PlayerSelector.hasArguments(lllllllllllllllIIlIllIlIIlIIllII)) {
                final List lllllllllllllllIIlIllIlIIlIIlIll = PlayerSelector.func_179656_b(lllllllllllllllIIlIllIlIIlIIlIII, lllllllllllllllIIlIllIlIIlIIllII, Entity.class);
                if (lllllllllllllllIIlIllIlIIlIIlIll.size() == 0) {
                    throw new EntityNotFoundException();
                }
                lllllllllllllllIIlIllIlIIlIIllIl.addAll(lllllllllllllllIIlIllIlIIlIIlIll);
            }
            else {
                final EntityPlayerMP lllllllllllllllIIlIllIlIIlIIlIlI = MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(lllllllllllllllIIlIllIlIIlIIllII);
                if (lllllllllllllllIIlIllIlIIlIIlIlI == null) {
                    throw new PlayerNotFoundException();
                }
                lllllllllllllllIIlIllIlIIlIIllIl.add(lllllllllllllllIIlIllIlIIlIIlIlI);
            }
        }
        lllllllllllllllIIlIllIlIIlIIlIII.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllllIIlIllIlIIlIIllIl.size());
        if (lllllllllllllllIIlIllIlIIlIIllIl.isEmpty()) {
            throw new EntityNotFoundException();
        }
        lllllllllllllllIIlIllIlIIlIIlIII.addChatMessage(new ChatComponentTranslation(String.valueOf(new StringBuilder("commands.spreadplayers.spreading.").append(lllllllllllllllIIlIllIlIIlIIlllI ? "teams" : "players")), new Object[] { lllllllllllllllIIlIllIlIIlIIllIl.size(), lllllllllllllllIIlIllIlIIlIIllll, lllllllllllllllIIlIllIlIIlIlIIlI, lllllllllllllllIIlIllIlIIlIlIIIl, lllllllllllllllIIlIllIlIIlIlIIII }));
        this.func_110669_a(lllllllllllllllIIlIllIlIIlIIlIII, lllllllllllllllIIlIllIlIIlIIllIl, new Position(lllllllllllllllIIlIllIlIIlIlIIlI, lllllllllllllllIIlIllIlIIlIlIIIl), lllllllllllllllIIlIllIlIIlIlIIII, lllllllllllllllIIlIllIlIIlIIllll, lllllllllllllllIIlIllIlIIlIIllIl.get(0).worldObj, lllllllllllllllIIlIllIlIIlIIlllI);
    }
    
    static class Position
    {
        /* synthetic */ double field_111100_b;
        /* synthetic */ double field_111101_a;
        
        void func_111095_a() {
            final double llllllllllllllIIlIllIlIIIlIlIlIl = this.func_111096_b();
            this.field_111101_a /= llllllllllllllIIlIllIlIIIlIlIlIl;
            this.field_111100_b /= llllllllllllllIIlIllIlIIIlIlIlIl;
        }
        
        public boolean func_111098_b(final World llllllllllllllIIlIllIlIIIIlIIlIl) {
            BlockPos llllllllllllllIIlIllIlIIIIlIlIII = new BlockPos(this.field_111101_a, 256.0, this.field_111100_b);
            while (llllllllllllllIIlIllIlIIIIlIlIII.getY() > 0) {
                llllllllllllllIIlIllIlIIIIlIlIII = llllllllllllllIIlIllIlIIIIlIlIII.offsetDown();
                final Material llllllllllllllIIlIllIlIIIIlIIlll = llllllllllllllIIlIllIlIIIIlIIlIl.getBlockState(llllllllllllllIIlIllIlIIIIlIlIII).getBlock().getMaterial();
                if (llllllllllllllIIlIllIlIIIIlIIlll != Material.air) {
                    return !llllllllllllllIIlIllIlIIIIlIIlll.isLiquid() && llllllllllllllIIlIllIlIIIIlIIlll != Material.fire;
                }
            }
            return false;
        }
        
        public void func_111094_b(final Position llllllllllllllIIlIllIlIIIlIIlIlI) {
            this.field_111101_a -= llllllllllllllIIlIllIlIIIlIIlIlI.field_111101_a;
            this.field_111100_b -= llllllllllllllIIlIllIlIIIlIIlIlI.field_111100_b;
        }
        
        public int func_111092_a(final World llllllllllllllIIlIllIlIIIIllIIll) {
            BlockPos llllllllllllllIIlIllIlIIIIllIIlI = new BlockPos(this.field_111101_a, 256.0, this.field_111100_b);
            while (llllllllllllllIIlIllIlIIIIllIIlI.getY() > 0) {
                llllllllllllllIIlIllIlIIIIllIIlI = llllllllllllllIIlIllIlIIIIllIIlI.offsetDown();
                if (llllllllllllllIIlIllIlIIIIllIIll.getBlockState(llllllllllllllIIlIllIlIIIIllIIlI).getBlock().getMaterial() != Material.air) {
                    return llllllllllllllIIlIllIlIIIIllIIlI.getY() + 1;
                }
            }
            return 257;
        }
        
        public boolean func_111093_a(final double llllllllllllllIIlIllIlIIIIllllII, final double llllllllllllllIIlIllIlIIIIlllIll, final double llllllllllllllIIlIllIlIIIlIIIIII, final double llllllllllllllIIlIllIlIIIIlllIIl) {
            boolean llllllllllllllIIlIllIlIIIIlllllI = false;
            if (this.field_111101_a < llllllllllllllIIlIllIlIIIIllllII) {
                this.field_111101_a = llllllllllllllIIlIllIlIIIIllllII;
                llllllllllllllIIlIllIlIIIIlllllI = true;
            }
            else if (this.field_111101_a > llllllllllllllIIlIllIlIIIlIIIIII) {
                this.field_111101_a = llllllllllllllIIlIllIlIIIlIIIIII;
                llllllllllllllIIlIllIlIIIIlllllI = true;
            }
            if (this.field_111100_b < llllllllllllllIIlIllIlIIIIlllIll) {
                this.field_111100_b = llllllllllllllIIlIllIlIIIIlllIll;
                llllllllllllllIIlIllIlIIIIlllllI = true;
            }
            else if (this.field_111100_b > llllllllllllllIIlIllIlIIIIlllIIl) {
                this.field_111100_b = llllllllllllllIIlIllIlIIIIlllIIl;
                llllllllllllllIIlIllIlIIIIlllllI = true;
            }
            return llllllllllllllIIlIllIlIIIIlllllI;
        }
        
        public void func_111097_a(final Random llllllllllllllIIlIllIlIIIIIlIlIl, final double llllllllllllllIIlIllIlIIIIIllIlI, final double llllllllllllllIIlIllIlIIIIIllIIl, final double llllllllllllllIIlIllIlIIIIIllIII, final double llllllllllllllIIlIllIlIIIIIlIlll) {
            this.field_111101_a = MathHelper.getRandomDoubleInRange(llllllllllllllIIlIllIlIIIIIlIlIl, llllllllllllllIIlIllIlIIIIIllIlI, llllllllllllllIIlIllIlIIIIIllIII);
            this.field_111100_b = MathHelper.getRandomDoubleInRange(llllllllllllllIIlIllIlIIIIIlIlIl, llllllllllllllIIlIllIlIIIIIllIIl, llllllllllllllIIlIllIlIIIIIlIlll);
        }
        
        Position(final double llllllllllllllIIlIllIlIIIllIIllI, final double llllllllllllllIIlIllIlIIIllIlIII) {
            this.field_111101_a = llllllllllllllIIlIllIlIIIllIIllI;
            this.field_111100_b = llllllllllllllIIlIllIlIIIllIlIII;
        }
        
        Position() {
        }
        
        float func_111096_b() {
            return MathHelper.sqrt_double(this.field_111101_a * this.field_111101_a + this.field_111100_b * this.field_111100_b);
        }
        
        double func_111099_a(final Position llllllllllllllIIlIllIlIIIlIllIll) {
            final double llllllllllllllIIlIllIlIIIlIllllI = this.field_111101_a - llllllllllllllIIlIllIlIIIlIllIll.field_111101_a;
            final double llllllllllllllIIlIllIlIIIlIlllIl = this.field_111100_b - llllllllllllllIIlIllIlIIIlIllIll.field_111100_b;
            return Math.sqrt(llllllllllllllIIlIllIlIIIlIllllI * llllllllllllllIIlIllIlIIIlIllllI + llllllllllllllIIlIllIlIIIlIlllIl * llllllllllllllIIlIllIlIIIlIlllIl);
        }
        
        static {
            __OBFID = "CL_00001105";
        }
    }
}
