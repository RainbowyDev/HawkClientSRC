package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;

public class CommandExecuteAt extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIllIlIIllIIllIIllI) {
        return "commands.execute.usage";
    }
    
    @Override
    public String getCommandName() {
        return "execute";
    }
    
    static {
        __OBFID = "CL_00002344";
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIllIlIIllIIIIIIIll, final String[] llllllllllllllIllIlIIllIIIIIIIII, final BlockPos llllllllllllllIllIlIIlIlllllllll) {
        return (llllllllllllllIllIlIIllIIIIIIIII.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllIlIIllIIIIIIIII, MinecraftServer.getServer().getAllUsernames()) : ((llllllllllllllIllIlIIllIIIIIIIII.length > 1 && llllllllllllllIllIlIIllIIIIIIIII.length <= 4) ? CommandBase.func_175771_a(llllllllllllllIllIlIIllIIIIIIIII, 1, llllllllllllllIllIlIIlIlllllllll) : ((llllllllllllllIllIlIIllIIIIIIIII.length > 5 && llllllllllllllIllIlIIllIIIIIIIII.length <= 8 && "detect".equals(llllllllllllllIllIlIIllIIIIIIIII[4])) ? CommandBase.func_175771_a(llllllllllllllIllIlIIllIIIIIIIII, 5, llllllllllllllIllIlIIlIlllllllll) : ((llllllllllllllIllIlIIllIIIIIIIII.length == 9 && "detect".equals(llllllllllllllIllIlIIllIIIIIIIII[4])) ? CommandBase.func_175762_a(llllllllllllllIllIlIIllIIIIIIIII, Block.blockRegistry.getKeys()) : null)));
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllIllIlIIllIIIIlIlll, final String[] llllllllllllllIllIlIIllIIIIlIllI) throws CommandException {
        if (llllllllllllllIllIlIIllIIIIlIllI.length < 5) {
            throw new WrongUsageException("commands.execute.usage", new Object[0]);
        }
        final Entity llllllllllllllIllIlIIllIIIllIIll = CommandBase.func_175759_a(llllllllllllllIllIlIIllIIIIlIlll, llllllllllllllIllIlIIllIIIIlIllI[0], Entity.class);
        final double llllllllllllllIllIlIIllIIIllIIIl = CommandBase.func_175761_b(llllllllllllllIllIlIIllIIIllIIll.posX, llllllllllllllIllIlIIllIIIIlIllI[1], false);
        final double llllllllllllllIllIlIIllIIIlIllll = CommandBase.func_175761_b(llllllllllllllIllIlIIllIIIllIIll.posY, llllllllllllllIllIlIIllIIIIlIllI[2], false);
        final double llllllllllllllIllIlIIllIIIlIllIl = CommandBase.func_175761_b(llllllllllllllIllIlIIllIIIllIIll.posZ, llllllllllllllIllIlIIllIIIIlIllI[3], false);
        final BlockPos llllllllllllllIllIlIIllIIIlIlIll = new BlockPos(llllllllllllllIllIlIIllIIIllIIIl, llllllllllllllIllIlIIllIIIlIllll, llllllllllllllIllIlIIllIIIlIllIl);
        byte llllllllllllllIllIlIIllIIIlIlIIl = 4;
        if ("detect".equals(llllllllllllllIllIlIIllIIIIlIllI[4]) && llllllllllllllIllIlIIllIIIIlIllI.length > 10) {
            final World llllllllllllllIllIlIIllIIIlIIlll = llllllllllllllIllIlIIllIIIIlIlll.getEntityWorld();
            final double llllllllllllllIllIlIIllIIIlIIlIl = CommandBase.func_175761_b(llllllllllllllIllIlIIllIIIllIIIl, llllllllllllllIllIlIIllIIIIlIllI[5], false);
            final double llllllllllllllIllIlIIllIIIlIIIll = CommandBase.func_175761_b(llllllllllllllIllIlIIllIIIlIllll, llllllllllllllIllIlIIllIIIIlIllI[6], false);
            final double llllllllllllllIllIlIIllIIIlIIIlI = CommandBase.func_175761_b(llllllllllllllIllIlIIllIIIlIllIl, llllllllllllllIllIlIIllIIIIlIllI[7], false);
            final Block llllllllllllllIllIlIIllIIIlIIIIl = CommandBase.getBlockByText(llllllllllllllIllIlIIllIIIIlIlll, llllllllllllllIllIlIIllIIIIlIllI[8]);
            final int llllllllllllllIllIlIIllIIIlIIIII = CommandBase.parseInt(llllllllllllllIllIlIIllIIIIlIllI[9], -1, 15);
            final BlockPos llllllllllllllIllIlIIllIIIIlllll = new BlockPos(llllllllllllllIllIlIIllIIIlIIlIl, llllllllllllllIllIlIIllIIIlIIIll, llllllllllllllIllIlIIllIIIlIIIlI);
            final IBlockState llllllllllllllIllIlIIllIIIIllllI = llllllllllllllIllIlIIllIIIlIIlll.getBlockState(llllllllllllllIllIlIIllIIIIlllll);
            if (llllllllllllllIllIlIIllIIIIllllI.getBlock() != llllllllllllllIllIlIIllIIIlIIIIl || (llllllllllllllIllIlIIllIIIlIIIII >= 0 && llllllllllllllIllIlIIllIIIIllllI.getBlock().getMetaFromState(llllllllllllllIllIlIIllIIIIllllI) != llllllllllllllIllIlIIllIIIlIIIII)) {
                throw new CommandException("commands.execute.failed", new Object[] { "detect", llllllllllllllIllIlIIllIIIllIIll.getName() });
            }
            llllllllllllllIllIlIIllIIIlIlIIl = 10;
        }
        final String llllllllllllllIllIlIIllIIIIlllIl = CommandBase.func_180529_a(llllllllllllllIllIlIIllIIIIlIllI, llllllllllllllIllIlIIllIIIlIlIIl);
        final ICommandSender llllllllllllllIllIlIIllIIIIlllII = new ICommandSender() {
            @Override
            public String getName() {
                return llllllllllllllIllIlIIllIIIllIIll.getName();
            }
            
            static {
                __OBFID = "CL_00002343";
            }
            
            @Override
            public Vec3 getPositionVector() {
                return new Vec3(llllllllllllllIllIlIIllIIIllIIIl, llllllllllllllIllIlIIllIIIlIllll, llllllllllllllIllIlIIllIIIlIllIl);
            }
            
            @Override
            public IChatComponent getDisplayName() {
                return llllllllllllllIllIlIIllIIIllIIll.getDisplayName();
            }
            
            @Override
            public boolean canCommandSenderUseCommand(final int llllllllllllllIllIIIlllllIlllIIl, final String llllllllllllllIllIIIlllllIlllIll) {
                return llllllllllllllIllIlIIllIIIIlIlll.canCommandSenderUseCommand(llllllllllllllIllIIIlllllIlllIIl, llllllllllllllIllIIIlllllIlllIll);
            }
            
            @Override
            public void addChatMessage(final IChatComponent llllllllllllllIllIIIllllllIIIIll) {
                llllllllllllllIllIlIIllIIIIlIlll.addChatMessage(llllllllllllllIllIIIllllllIIIIll);
            }
            
            @Override
            public boolean sendCommandFeedback() {
                final MinecraftServer llllllllllllllIllIIIlllllIlIlIIl = MinecraftServer.getServer();
                return llllllllllllllIllIIIlllllIlIlIIl == null || llllllllllllllIllIIIlllllIlIlIIl.worldServers[0].getGameRules().getGameRuleBooleanValue("commandBlockOutput");
            }
            
            @Override
            public BlockPos getPosition() {
                return llllllllllllllIllIlIIllIIIlIlIll;
            }
            
            @Override
            public void func_174794_a(final CommandResultStats.Type llllllllllllllIllIIIlllllIlIIIII, final int llllllllllllllIllIIIlllllIlIIIlI) {
                llllllllllllllIllIlIIllIIIllIIll.func_174794_a(llllllllllllllIllIIIlllllIlIIIII, llllllllllllllIllIIIlllllIlIIIlI);
            }
            
            @Override
            public World getEntityWorld() {
                return llllllllllllllIllIlIIllIIIllIIll.worldObj;
            }
            
            @Override
            public Entity getCommandSenderEntity() {
                return llllllllllllllIllIlIIllIIIllIIll;
            }
        };
        final ICommandManager llllllllllllllIllIlIIllIIIIllIll = MinecraftServer.getServer().getCommandManager();
        try {
            final int llllllllllllllIllIlIIllIIIIllIlI = llllllllllllllIllIlIIllIIIIllIll.executeCommand(llllllllllllllIllIlIIllIIIIlllII, llllllllllllllIllIlIIllIIIIlllIl);
            if (llllllllllllllIllIlIIllIIIIllIlI < 1) {
                throw new CommandException("commands.execute.allInvocationsFailed", new Object[] { llllllllllllllIllIlIIllIIIIlllIl });
            }
        }
        catch (Throwable llllllllllllllIllIlIIllIIIIllIIl) {
            throw new CommandException("commands.execute.failed", new Object[] { llllllllllllllIllIlIIllIIIIlllIl, llllllllllllllIllIlIIllIIIllIIll.getName() });
        }
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIllIlIIlIlllllllII, final int llllllllllllllIllIlIIlIllllllIll) {
        return llllllllllllllIllIlIIlIllllllIll == 0;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
