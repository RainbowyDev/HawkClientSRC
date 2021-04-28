package net.minecraft.command;

import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.server.*;

public class CommandEffect extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIIIIlIlIIIlIlllIl) {
        return "commands.effect.usage";
    }
    
    static {
        __OBFID = "CL_00000323";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender lllllllllllllllIIIIlIlIIIIllIlIl, final String[] lllllllllllllllIIIIlIlIIIIllIlII, final BlockPos lllllllllllllllIIIIlIlIIIIllIIll) {
        return (lllllllllllllllIIIIlIlIIIIllIlII.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIIIlIlIIIIllIlII, this.getAllUsernames()) : ((lllllllllllllllIIIIlIlIIIIllIlII.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIIIlIlIIIIllIlII, Potion.func_180141_c()) : ((lllllllllllllllIIIIlIlIIIIllIlII.length == 5) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIIIIlIlIIIIllIlII, "true", "false") : null));
    }
    
    @Override
    public void processCommand(final ICommandSender lllllllllllllllIIIIlIlIIIlIIIIlI, final String[] lllllllllllllllIIIIlIlIIIlIIllll) throws CommandException {
        if (lllllllllllllllIIIIlIlIIIlIIllll.length < 2) {
            throw new WrongUsageException("commands.effect.usage", new Object[0]);
        }
        final EntityLivingBase lllllllllllllllIIIIlIlIIIlIIlllI = (EntityLivingBase)CommandBase.func_175759_a(lllllllllllllllIIIIlIlIIIlIIIIlI, lllllllllllllllIIIIlIlIIIlIIllll[0], EntityLivingBase.class);
        if (lllllllllllllllIIIIlIlIIIlIIllll[1].equals("clear")) {
            if (lllllllllllllllIIIIlIlIIIlIIlllI.getActivePotionEffects().isEmpty()) {
                throw new CommandException("commands.effect.failure.notActive.all", new Object[] { lllllllllllllllIIIIlIlIIIlIIlllI.getName() });
            }
            lllllllllllllllIIIIlIlIIIlIIlllI.clearActivePotions();
            CommandBase.notifyOperators(lllllllllllllllIIIIlIlIIIlIIIIlI, this, "commands.effect.success.removed.all", lllllllllllllllIIIIlIlIIIlIIlllI.getName());
        }
        else {
            int lllllllllllllllIIIIlIlIIIlIIllII = 0;
            try {
                final int lllllllllllllllIIIIlIlIIIlIIllIl = CommandBase.parseInt(lllllllllllllllIIIIlIlIIIlIIllll[1], 1);
            }
            catch (NumberInvalidException lllllllllllllllIIIIlIlIIIlIIlIll) {
                final Potion lllllllllllllllIIIIlIlIIIlIIlIlI = Potion.func_180142_b(lllllllllllllllIIIIlIlIIIlIIllll[1]);
                if (lllllllllllllllIIIIlIlIIIlIIlIlI == null) {
                    throw lllllllllllllllIIIIlIlIIIlIIlIll;
                }
                lllllllllllllllIIIIlIlIIIlIIllII = lllllllllllllllIIIIlIlIIIlIIlIlI.id;
            }
            int lllllllllllllllIIIIlIlIIIlIIlIIl = 600;
            int lllllllllllllllIIIIlIlIIIlIIlIII = 30;
            int lllllllllllllllIIIIlIlIIIlIIIlll = 0;
            if (lllllllllllllllIIIIlIlIIIlIIllII < 0 || lllllllllllllllIIIIlIlIIIlIIllII >= Potion.potionTypes.length || Potion.potionTypes[lllllllllllllllIIIIlIlIIIlIIllII] == null) {
                throw new NumberInvalidException("commands.effect.notFound", new Object[] { lllllllllllllllIIIIlIlIIIlIIllII });
            }
            final Potion lllllllllllllllIIIIlIlIIIlIIIllI = Potion.potionTypes[lllllllllllllllIIIIlIlIIIlIIllII];
            if (lllllllllllllllIIIIlIlIIIlIIllll.length >= 3) {
                lllllllllllllllIIIIlIlIIIlIIlIII = CommandBase.parseInt(lllllllllllllllIIIIlIlIIIlIIllll[2], 0, 1000000);
                if (lllllllllllllllIIIIlIlIIIlIIIllI.isInstant()) {
                    lllllllllllllllIIIIlIlIIIlIIlIIl = lllllllllllllllIIIIlIlIIIlIIlIII;
                }
                else {
                    lllllllllllllllIIIIlIlIIIlIIlIIl = lllllllllllllllIIIIlIlIIIlIIlIII * 20;
                }
            }
            else if (lllllllllllllllIIIIlIlIIIlIIIllI.isInstant()) {
                lllllllllllllllIIIIlIlIIIlIIlIIl = 1;
            }
            if (lllllllllllllllIIIIlIlIIIlIIllll.length >= 4) {
                lllllllllllllllIIIIlIlIIIlIIIlll = CommandBase.parseInt(lllllllllllllllIIIIlIlIIIlIIllll[3], 0, 255);
            }
            boolean lllllllllllllllIIIIlIlIIIlIIIlIl = true;
            if (lllllllllllllllIIIIlIlIIIlIIllll.length >= 5 && "true".equalsIgnoreCase(lllllllllllllllIIIIlIlIIIlIIllll[4])) {
                lllllllllllllllIIIIlIlIIIlIIIlIl = false;
            }
            if (lllllllllllllllIIIIlIlIIIlIIlIII > 0) {
                final PotionEffect lllllllllllllllIIIIlIlIIIlIIIlII = new PotionEffect(lllllllllllllllIIIIlIlIIIlIIllII, lllllllllllllllIIIIlIlIIIlIIlIIl, lllllllllllllllIIIIlIlIIIlIIIlll, false, lllllllllllllllIIIIlIlIIIlIIIlIl);
                lllllllllllllllIIIIlIlIIIlIIlllI.addPotionEffect(lllllllllllllllIIIIlIlIIIlIIIlII);
                CommandBase.notifyOperators(lllllllllllllllIIIIlIlIIIlIIIIlI, this, "commands.effect.success", new ChatComponentTranslation(lllllllllllllllIIIIlIlIIIlIIIlII.getEffectName(), new Object[0]), lllllllllllllllIIIIlIlIIIlIIllII, lllllllllllllllIIIIlIlIIIlIIIlll, lllllllllllllllIIIIlIlIIIlIIlllI.getName(), lllllllllllllllIIIIlIlIIIlIIlIII);
            }
            else {
                if (!lllllllllllllllIIIIlIlIIIlIIlllI.isPotionActive(lllllllllllllllIIIIlIlIIIlIIllII)) {
                    throw new CommandException("commands.effect.failure.notActive", new Object[] { new ChatComponentTranslation(lllllllllllllllIIIIlIlIIIlIIIllI.getName(), new Object[0]), lllllllllllllllIIIIlIlIIIlIIlllI.getName() });
                }
                lllllllllllllllIIIIlIlIIIlIIlllI.removePotionEffect(lllllllllllllllIIIIlIlIIIlIIllII);
                CommandBase.notifyOperators(lllllllllllllllIIIIlIlIIIlIIIIlI, this, "commands.effect.success.removed", new ChatComponentTranslation(lllllllllllllllIIIIlIlIIIlIIIllI.getName(), new Object[0]), lllllllllllllllIIIIlIlIIIlIIlllI.getName());
            }
        }
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllIIIIlIlIIIIlIllIl, final int lllllllllllllllIIIIlIlIIIIlIllII) {
        return lllllllllllllllIIIIlIlIIIIlIllII == 0;
    }
    
    protected String[] getAllUsernames() {
        return MinecraftServer.getServer().getAllUsernames();
    }
    
    @Override
    public String getCommandName() {
        return "effect";
    }
}
