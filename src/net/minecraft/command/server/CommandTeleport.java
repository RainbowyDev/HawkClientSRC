package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.command.*;

public class CommandTeleport extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllllIlIlIllIIIIllllI, final String[] llllllllllllllllIlIlIllIIIIllIll, final BlockPos llllllllllllllllIlIlIllIIIIlllII) {
        return (llllllllllllllllIlIlIllIIIIllIll.length != 1 && llllllllllllllllIlIlIllIIIIllIll.length != 2) ? null : CommandBase.getListOfStringsMatchingLastWord(llllllllllllllllIlIlIllIIIIllIll, MinecraftServer.getServer().getAllUsernames());
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIlIlIllIIlIIllll) {
        return "commands.tp.usage";
    }
    
    @Override
    public void processCommand(final ICommandSender llllllllllllllllIlIlIllIIIllllll, final String[] llllllllllllllllIlIlIllIIIlIllII) throws CommandException {
        if (llllllllllllllllIlIlIllIIIlIllII.length < 1) {
            throw new WrongUsageException("commands.tp.usage", new Object[0]);
        }
        byte llllllllllllllllIlIlIllIIIllllIl = 0;
        Object llllllllllllllllIlIlIllIIIlllIll = null;
        if (llllllllllllllllIlIlIllIIIlIllII.length != 2 && llllllllllllllllIlIlIllIIIlIllII.length != 4 && llllllllllllllllIlIlIllIIIlIllII.length != 6) {
            final Object llllllllllllllllIlIlIllIIIllllII = CommandBase.getCommandSenderAsPlayer(llllllllllllllllIlIlIllIIIllllll);
        }
        else {
            llllllllllllllllIlIlIllIIIlllIll = CommandBase.func_175768_b(llllllllllllllllIlIlIllIIIllllll, llllllllllllllllIlIlIllIIIlIllII[0]);
            llllllllllllllllIlIlIllIIIllllIl = 1;
        }
        if (llllllllllllllllIlIlIllIIIlIllII.length != 1 && llllllllllllllllIlIlIllIIIlIllII.length != 2) {
            if (llllllllllllllllIlIlIllIIIlIllII.length < llllllllllllllllIlIlIllIIIllllIl + 3) {
                throw new WrongUsageException("commands.tp.usage", new Object[0]);
            }
            if (((Entity)llllllllllllllllIlIlIllIIIlllIll).worldObj != null) {
                int llllllllllllllllIlIlIllIIIlllIlI = llllllllllllllllIlIlIllIIIllllIl + 1;
                final CoordinateArg llllllllllllllllIlIlIllIIIlllIIl = CommandBase.func_175770_a(((Entity)llllllllllllllllIlIlIllIIIlllIll).posX, llllllllllllllllIlIlIllIIIlIllII[llllllllllllllllIlIlIllIIIllllIl], true);
                final CoordinateArg llllllllllllllllIlIlIllIIIlllIII = CommandBase.func_175767_a(((Entity)llllllllllllllllIlIlIllIIIlllIll).posY, llllllllllllllllIlIlIllIIIlIllII[llllllllllllllllIlIlIllIIIlllIlI++], 0, 0, false);
                final CoordinateArg llllllllllllllllIlIlIllIIIllIlll = CommandBase.func_175770_a(((Entity)llllllllllllllllIlIlIllIIIlllIll).posZ, llllllllllllllllIlIlIllIIIlIllII[llllllllllllllllIlIlIllIIIlllIlI++], true);
                final CoordinateArg llllllllllllllllIlIlIllIIIllIllI = CommandBase.func_175770_a(((Entity)llllllllllllllllIlIlIllIIIlllIll).rotationYaw, (llllllllllllllllIlIlIllIIIlIllII.length > llllllllllllllllIlIlIllIIIlllIlI) ? llllllllllllllllIlIlIllIIIlIllII[llllllllllllllllIlIlIllIIIlllIlI++] : "~", false);
                final CoordinateArg llllllllllllllllIlIlIllIIIllIlIl = CommandBase.func_175770_a(((Entity)llllllllllllllllIlIlIllIIIlllIll).rotationPitch, (llllllllllllllllIlIlIllIIIlIllII.length > llllllllllllllllIlIlIllIIIlllIlI) ? llllllllllllllllIlIlIllIIIlIllII[llllllllllllllllIlIlIllIIIlllIlI] : "~", false);
                if (llllllllllllllllIlIlIllIIIlllIll instanceof EntityPlayerMP) {
                    final EnumSet llllllllllllllllIlIlIllIIIllIIlI = EnumSet.noneOf(S08PacketPlayerPosLook.EnumFlags.class);
                    if (llllllllllllllllIlIlIllIIIlllIIl.func_179630_c()) {
                        llllllllllllllllIlIlIllIIIllIIlI.add(S08PacketPlayerPosLook.EnumFlags.X);
                    }
                    if (llllllllllllllllIlIlIllIIIlllIII.func_179630_c()) {
                        llllllllllllllllIlIlIllIIIllIIlI.add(S08PacketPlayerPosLook.EnumFlags.Y);
                    }
                    if (llllllllllllllllIlIlIllIIIllIlll.func_179630_c()) {
                        llllllllllllllllIlIlIllIIIllIIlI.add(S08PacketPlayerPosLook.EnumFlags.Z);
                    }
                    if (llllllllllllllllIlIlIllIIIllIlIl.func_179630_c()) {
                        llllllllllllllllIlIlIllIIIllIIlI.add(S08PacketPlayerPosLook.EnumFlags.X_ROT);
                    }
                    if (llllllllllllllllIlIlIllIIIllIllI.func_179630_c()) {
                        llllllllllllllllIlIlIllIIIllIIlI.add(S08PacketPlayerPosLook.EnumFlags.Y_ROT);
                    }
                    float llllllllllllllllIlIlIllIIIllIlII = (float)llllllllllllllllIlIlIllIIIllIllI.func_179629_b();
                    if (!llllllllllllllllIlIlIllIIIllIllI.func_179630_c()) {
                        llllllllllllllllIlIlIllIIIllIlII = MathHelper.wrapAngleTo180_float(llllllllllllllllIlIlIllIIIllIlII);
                    }
                    float llllllllllllllllIlIlIllIIIllIIIl = (float)llllllllllllllllIlIlIllIIIllIlIl.func_179629_b();
                    if (!llllllllllllllllIlIlIllIIIllIlIl.func_179630_c()) {
                        llllllllllllllllIlIlIllIIIllIIIl = MathHelper.wrapAngleTo180_float(llllllllllllllllIlIlIllIIIllIIIl);
                    }
                    if (llllllllllllllllIlIlIllIIIllIIIl > 90.0f || llllllllllllllllIlIlIllIIIllIIIl < -90.0f) {
                        llllllllllllllllIlIlIllIIIllIIIl = MathHelper.wrapAngleTo180_float(180.0f - llllllllllllllllIlIlIllIIIllIIIl);
                        llllllllllllllllIlIlIllIIIllIlII = MathHelper.wrapAngleTo180_float(llllllllllllllllIlIlIllIIIllIlII + 180.0f);
                    }
                    ((Entity)llllllllllllllllIlIlIllIIIlllIll).mountEntity(null);
                    ((EntityPlayerMP)llllllllllllllllIlIlIllIIIlllIll).playerNetServerHandler.func_175089_a(llllllllllllllllIlIlIllIIIlllIIl.func_179629_b(), llllllllllllllllIlIlIllIIIlllIII.func_179629_b(), llllllllllllllllIlIlIllIIIllIlll.func_179629_b(), llllllllllllllllIlIlIllIIIllIlII, llllllllllllllllIlIlIllIIIllIIIl, llllllllllllllllIlIlIllIIIllIIlI);
                    ((Entity)llllllllllllllllIlIlIllIIIlllIll).setRotationYawHead(llllllllllllllllIlIlIllIIIllIlII);
                }
                else {
                    float llllllllllllllllIlIlIllIIIllIIII = (float)MathHelper.wrapAngleTo180_double(llllllllllllllllIlIlIllIIIllIllI.func_179628_a());
                    float llllllllllllllllIlIlIllIIIllIIll = (float)MathHelper.wrapAngleTo180_double(llllllllllllllllIlIlIllIIIllIlIl.func_179628_a());
                    if (llllllllllllllllIlIlIllIIIllIIll > 90.0f || llllllllllllllllIlIlIllIIIllIIll < -90.0f) {
                        llllllllllllllllIlIlIllIIIllIIll = MathHelper.wrapAngleTo180_float(180.0f - llllllllllllllllIlIlIllIIIllIIll);
                        llllllllllllllllIlIlIllIIIllIIII = MathHelper.wrapAngleTo180_float(llllllllllllllllIlIlIllIIIllIIII + 180.0f);
                    }
                    ((Entity)llllllllllllllllIlIlIllIIIlllIll).setLocationAndAngles(llllllllllllllllIlIlIllIIIlllIIl.func_179628_a(), llllllllllllllllIlIlIllIIIlllIII.func_179628_a(), llllllllllllllllIlIlIllIIIllIlll.func_179628_a(), llllllllllllllllIlIlIllIIIllIIII, llllllllllllllllIlIlIllIIIllIIll);
                    ((Entity)llllllllllllllllIlIlIllIIIlllIll).setRotationYawHead(llllllllllllllllIlIlIllIIIllIIII);
                }
                CommandBase.notifyOperators(llllllllllllllllIlIlIllIIIllllll, this, "commands.tp.success.coordinates", ((Entity)llllllllllllllllIlIlIllIIIlllIll).getName(), llllllllllllllllIlIlIllIIIlllIIl.func_179628_a(), llllllllllllllllIlIlIllIIIlllIII.func_179628_a(), llllllllllllllllIlIlIllIIIllIlll.func_179628_a());
            }
        }
        else {
            final Entity llllllllllllllllIlIlIllIIIlIllll = CommandBase.func_175768_b(llllllllllllllllIlIlIllIIIllllll, llllllllllllllllIlIlIllIIIlIllII[llllllllllllllllIlIlIllIIIlIllII.length - 1]);
            if (llllllllllllllllIlIlIllIIIlIllll.worldObj != ((Entity)llllllllllllllllIlIlIllIIIlllIll).worldObj) {
                throw new CommandException("commands.tp.notSameDimension", new Object[0]);
            }
            ((Entity)llllllllllllllllIlIlIllIIIlllIll).mountEntity(null);
            if (llllllllllllllllIlIlIllIIIlllIll instanceof EntityPlayerMP) {
                ((EntityPlayerMP)llllllllllllllllIlIlIllIIIlllIll).playerNetServerHandler.setPlayerLocation(llllllllllllllllIlIlIllIIIlIllll.posX, llllllllllllllllIlIlIllIIIlIllll.posY, llllllllllllllllIlIlIllIIIlIllll.posZ, llllllllllllllllIlIlIllIIIlIllll.rotationYaw, llllllllllllllllIlIlIllIIIlIllll.rotationPitch);
            }
            else {
                ((Entity)llllllllllllllllIlIlIllIIIlllIll).setLocationAndAngles(llllllllllllllllIlIlIllIIIlIllll.posX, llllllllllllllllIlIlIllIIIlIllll.posY, llllllllllllllllIlIlIllIIIlIllll.posZ, llllllllllllllllIlIlIllIIIlIllll.rotationYaw, llllllllllllllllIlIlIllIIIlIllll.rotationPitch);
            }
            CommandBase.notifyOperators(llllllllllllllllIlIlIllIIIllllll, this, "commands.tp.success", ((Entity)llllllllllllllllIlIlIllIIIlllIll).getName(), llllllllllllllllIlIlIllIIIlIllll.getName());
        }
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllllIlIlIllIIIIllIII, final int llllllllllllllllIlIlIllIIIIlIllI) {
        return llllllllllllllllIlIlIllIIIIlIllI == 0;
    }
    
    static {
        __OBFID = "CL_00001180";
    }
    
    @Override
    public String getCommandName() {
        return "tp";
    }
}
