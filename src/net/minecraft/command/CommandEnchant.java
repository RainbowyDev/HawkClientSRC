package net.minecraft.command;

import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.server.*;

public class CommandEnchant extends CommandBase
{
    @Override
    public String getCommandName() {
        return "enchant";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIlllllIIlllIllIlII, final String[] llllllllllllllIlllllIIllllIIIIlI) throws CommandException {
        if (llllllllllllllIlllllIIllllIIIIlI.length < 2) {
            throw new WrongUsageException("commands.enchant.usage", new Object[0]);
        }
        final EntityPlayerMP llllllllllllllIlllllIIllllIIIIIl = CommandBase.getPlayer(llllllllllllllIlllllIIlllIllIlII, llllllllllllllIlllllIIllllIIIIlI[0]);
        llllllllllllllIlllllIIlllIllIlII.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, 0);
        int llllllllllllllIlllllIIlllIllllll = 0;
        try {
            final int llllllllllllllIlllllIIllllIIIIII = CommandBase.parseInt(llllllllllllllIlllllIIllllIIIIlI[1], 0);
        }
        catch (NumberInvalidException llllllllllllllIlllllIIlllIlllllI) {
            final Enchantment llllllllllllllIlllllIIlllIllllIl = Enchantment.func_180305_b(llllllllllllllIlllllIIllllIIIIlI[1]);
            if (llllllllllllllIlllllIIlllIllllIl == null) {
                throw llllllllllllllIlllllIIlllIlllllI;
            }
            llllllllllllllIlllllIIlllIllllll = llllllllllllllIlllllIIlllIllllIl.effectId;
        }
        int llllllllllllllIlllllIIlllIllllII = 1;
        final ItemStack llllllllllllllIlllllIIlllIlllIll = llllllllllllllIlllllIIllllIIIIIl.getCurrentEquippedItem();
        if (llllllllllllllIlllllIIlllIlllIll == null) {
            throw new CommandException("commands.enchant.noItem", new Object[0]);
        }
        final Enchantment llllllllllllllIlllllIIlllIlllIlI = Enchantment.func_180306_c(llllllllllllllIlllllIIlllIllllll);
        if (llllllllllllllIlllllIIlllIlllIlI == null) {
            throw new NumberInvalidException("commands.enchant.notFound", new Object[] { llllllllllllllIlllllIIlllIllllll });
        }
        if (!llllllllllllllIlllllIIlllIlllIlI.canApply(llllllllllllllIlllllIIlllIlllIll)) {
            throw new CommandException("commands.enchant.cantEnchant", new Object[0]);
        }
        if (llllllllllllllIlllllIIllllIIIIlI.length >= 3) {
            llllllllllllllIlllllIIlllIllllII = CommandBase.parseInt(llllllllllllllIlllllIIllllIIIIlI[2], llllllllllllllIlllllIIlllIlllIlI.getMinLevel(), llllllllllllllIlllllIIlllIlllIlI.getMaxLevel());
        }
        if (llllllllllllllIlllllIIlllIlllIll.hasTagCompound()) {
            final NBTTagList llllllllllllllIlllllIIlllIlllIIl = llllllllllllllIlllllIIlllIlllIll.getEnchantmentTagList();
            if (llllllllllllllIlllllIIlllIlllIIl != null) {
                for (int llllllllllllllIlllllIIlllIlllIII = 0; llllllllllllllIlllllIIlllIlllIII < llllllllllllllIlllllIIlllIlllIIl.tagCount(); ++llllllllllllllIlllllIIlllIlllIII) {
                    final short llllllllllllllIlllllIIlllIllIlll = llllllllllllllIlllllIIlllIlllIIl.getCompoundTagAt(llllllllllllllIlllllIIlllIlllIII).getShort("id");
                    if (Enchantment.func_180306_c(llllllllllllllIlllllIIlllIllIlll) != null) {
                        final Enchantment llllllllllllllIlllllIIlllIllIllI = Enchantment.func_180306_c(llllllllllllllIlllllIIlllIllIlll);
                        if (!llllllllllllllIlllllIIlllIllIllI.canApplyTogether(llllllllllllllIlllllIIlllIlllIlI)) {
                            throw new CommandException("commands.enchant.cantCombine", new Object[] { llllllllllllllIlllllIIlllIlllIlI.getTranslatedName(llllllllllllllIlllllIIlllIllllII), llllllllllllllIlllllIIlllIllIllI.getTranslatedName(llllllllllllllIlllllIIlllIlllIIl.getCompoundTagAt(llllllllllllllIlllllIIlllIlllIII).getShort("lvl")) });
                        }
                    }
                }
            }
        }
        llllllllllllllIlllllIIlllIlllIll.addEnchantment(llllllllllllllIlllllIIlllIlllIlI, llllllllllllllIlllllIIlllIllllII);
        CommandBase.notifyOperators(llllllllllllllIlllllIIlllIllIlII, this, "commands.enchant.success", new Object[0]);
        llllllllllllllIlllllIIlllIllIlII.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, 1);
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIlllllIIlllIlIIllI, final String[] llllllllllllllIlllllIIlllIlIIIlI, final BlockPos llllllllllllllIlllllIIlllIlIIlII) {
        return (llllllllllllllIlllllIIlllIlIIIlI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlllllIIlllIlIIIlI, this.getListOfPlayers()) : ((llllllllllllllIlllllIIlllIlIIIlI.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIlllllIIlllIlIIIlI, Enchantment.func_180304_c()) : null);
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIlllllIIlllIIllllI, final int llllllllllllllIlllllIIlllIIlllII) {
        return llllllllllllllIlllllIIlllIIlllII == 0;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlllllIIllllIlIIIl) {
        return "commands.enchant.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    protected String[] getListOfPlayers() {
        return MinecraftServer.getServer().getAllUsernames();
    }
    
    static {
        __OBFID = "CL_00000377";
    }
}
