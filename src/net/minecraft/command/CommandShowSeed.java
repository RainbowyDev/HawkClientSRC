package net.minecraft.command;

import net.minecraft.entity.player.*;
import net.minecraft.server.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class CommandShowSeed extends CommandBase
{
    @Override
    public void processCommand(final ICommandSender llllllllllllllllllIIlllIlIIIIIII, final String[] llllllllllllllllllIIlllIlIIIIIlI) throws CommandException {
        final Object llllllllllllllllllIIlllIlIIIIIIl = (llllllllllllllllllIIlllIlIIIIIII instanceof EntityPlayer) ? ((EntityPlayer)llllllllllllllllllIIlllIlIIIIIII).worldObj : MinecraftServer.getServer().worldServerForDimension(0);
        llllllllllllllllllIIlllIlIIIIIII.addChatMessage(new ChatComponentTranslation("commands.seed.success", new Object[] { ((World)llllllllllllllllllIIlllIlIIIIIIl).getSeed() }));
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllllIIlllIlIIIIlll) {
        return "commands.seed.usage";
    }
    
    @Override
    public String getCommandName() {
        return "seed";
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final ICommandSender llllllllllllllllllIIlllIlIIIlIll) {
        return MinecraftServer.getServer().isSinglePlayer() || super.canCommandSenderUseCommand(llllllllllllllllllIIlllIlIIIlIll);
    }
    
    static {
        __OBFID = "CL_00001053";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
