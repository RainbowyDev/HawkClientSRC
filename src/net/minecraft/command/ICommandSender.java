package net.minecraft.command;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public interface ICommandSender
{
    String getName();
    
    void addChatMessage(final IChatComponent p0);
    
    void func_174794_a(final CommandResultStats.Type p0, final int p1);
    
    IChatComponent getDisplayName();
    
    World getEntityWorld();
    
    Entity getCommandSenderEntity();
    
    boolean canCommandSenderUseCommand(final int p0, final String p1);
    
    BlockPos getPosition();
    
    Vec3 getPositionVector();
    
    boolean sendCommandFeedback();
}
