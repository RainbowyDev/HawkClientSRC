package net.minecraft.command.server;

import java.text.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.server.*;
import java.util.concurrent.*;
import net.minecraft.command.*;
import net.minecraft.crash.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;
import io.netty.buffer.*;

public abstract class CommandBlockLogic implements ICommandSender
{
    private final /* synthetic */ CommandResultStats field_175575_g;
    private /* synthetic */ int successCount;
    private static final /* synthetic */ SimpleDateFormat timestampFormat;
    private /* synthetic */ IChatComponent lastOutput;
    private /* synthetic */ String commandStored;
    private /* synthetic */ String customName;
    private /* synthetic */ boolean trackOutput;
    
    public void func_145750_b(final IChatComponent llllllllllllllllIIIllIlIIIIlIIll) {
        this.lastOutput = llllllllllllllllIIIllIlIIIIlIIll;
    }
    
    public IChatComponent getLastOutput() {
        return this.lastOutput;
    }
    
    public CommandResultStats func_175572_n() {
        return this.field_175575_g;
    }
    
    public void readDataFromNBT(final NBTTagCompound llllllllllllllllIIIllIlIIlIllIll) {
        this.commandStored = llllllllllllllllIIIllIlIIlIllIll.getString("Command");
        this.successCount = llllllllllllllllIIIllIlIIlIllIll.getInteger("SuccessCount");
        if (llllllllllllllllIIIllIlIIlIllIll.hasKey("CustomName", 8)) {
            this.customName = llllllllllllllllIIIllIlIIlIllIll.getString("CustomName");
        }
        if (llllllllllllllllIIIllIlIIlIllIll.hasKey("TrackOutput", 1)) {
            this.trackOutput = llllllllllllllllIIIllIlIIlIllIll.getBoolean("TrackOutput");
        }
        if (llllllllllllllllIIIllIlIIlIllIll.hasKey("LastOutput", 8) && this.trackOutput) {
            this.lastOutput = IChatComponent.Serializer.jsonToComponent(llllllllllllllllIIIllIlIIlIllIll.getString("LastOutput"));
        }
        this.field_175575_g.func_179668_a(llllllllllllllllIIIllIlIIlIllIll);
    }
    
    public void writeDataToNBT(final NBTTagCompound llllllllllllllllIIIllIlIIllIIIll) {
        llllllllllllllllIIIllIlIIllIIIll.setString("Command", this.commandStored);
        llllllllllllllllIIIllIlIIllIIIll.setInteger("SuccessCount", this.successCount);
        llllllllllllllllIIIllIlIIllIIIll.setString("CustomName", this.customName);
        llllllllllllllllIIIllIlIIllIIIll.setBoolean("TrackOutput", this.trackOutput);
        if (this.lastOutput != null && this.trackOutput) {
            llllllllllllllllIIIllIlIIllIIIll.setString("LastOutput", IChatComponent.Serializer.componentToJson(this.lastOutput));
        }
        this.field_175575_g.func_179670_b(llllllllllllllllIIIllIlIIllIIIll);
    }
    
    public String getCustomName() {
        return this.commandStored;
    }
    
    public void func_145754_b(final String llllllllllllllllIIIllIlIIIlIlllI) {
        this.customName = llllllllllllllllIIIllIlIIIlIlllI;
    }
    
    public void trigger(final World llllllllllllllllIIIllIlIIIllllIl) {
        if (llllllllllllllllIIIllIlIIIllllIl.isRemote) {
            this.successCount = 0;
        }
        final MinecraftServer llllllllllllllllIIIllIlIIlIIIIll = MinecraftServer.getServer();
        if (llllllllllllllllIIIllIlIIlIIIIll != null && llllllllllllllllIIIllIlIIlIIIIll.func_175578_N() && llllllllllllllllIIIllIlIIlIIIIll.isCommandBlockEnabled()) {
            final ICommandManager llllllllllllllllIIIllIlIIlIIIIlI = llllllllllllllllIIIllIlIIlIIIIll.getCommandManager();
            try {
                this.lastOutput = null;
                this.successCount = llllllllllllllllIIIllIlIIlIIIIlI.executeCommand(this, this.commandStored);
                return;
            }
            catch (Throwable llllllllllllllllIIIllIlIIlIIIIIl) {
                final CrashReport llllllllllllllllIIIllIlIIlIIIIII = CrashReport.makeCrashReport(llllllllllllllllIIIllIlIIlIIIIIl, "Executing command block");
                final CrashReportCategory llllllllllllllllIIIllIlIIIllllll = llllllllllllllllIIIllIlIIlIIIIII.makeCategory("Command to be executed");
                llllllllllllllllIIIllIlIIIllllll.addCrashSectionCallable("Command", new Callable() {
                    public String func_180324_a() {
                        return CommandBlockLogic.this.getCustomName();
                    }
                    
                    static {
                        __OBFID = "CL_00002154";
                    }
                    
                    @Override
                    public Object call() {
                        return this.func_180324_a();
                    }
                });
                llllllllllllllllIIIllIlIIIllllll.addCrashSectionCallable("Name", new Callable() {
                    public String func_180326_a() {
                        return CommandBlockLogic.this.getName();
                    }
                    
                    @Override
                    public Object call() {
                        return this.func_180326_a();
                    }
                    
                    static {
                        __OBFID = "CL_00002153";
                    }
                });
                throw new ReportedException(llllllllllllllllIIIllIlIIlIIIIII);
            }
        }
        this.successCount = 0;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int llllllllllllllllIIIllIlIIlIllIII, final String llllllllllllllllIIIllIlIIlIlIlll) {
        return llllllllllllllllIIIllIlIIlIllIII <= 2;
    }
    
    static {
        __OBFID = "CL_00000128";
        timestampFormat = new SimpleDateFormat("HH:mm:ss");
    }
    
    @Override
    public boolean sendCommandFeedback() {
        final MinecraftServer llllllllllllllllIIIllIlIIIlIIIll = MinecraftServer.getServer();
        return llllllllllllllllIIIllIlIIIlIIIll == null || !llllllllllllllllIIIllIlIIIlIIIll.func_175578_N() || llllllllllllllllIIIllIlIIIlIIIll.worldServers[0].getGameRules().getGameRuleBooleanValue("commandBlockOutput");
    }
    
    public int getSuccessCount() {
        return this.successCount;
    }
    
    public boolean func_175574_a(final EntityPlayer llllllllllllllllIIIllIlIIIIIIlII) {
        if (!llllllllllllllllIIIllIlIIIIIIlII.capabilities.isCreativeMode) {
            return false;
        }
        if (llllllllllllllllIIIllIlIIIIIIlII.getEntityWorld().isRemote) {
            llllllllllllllllIIIllIlIIIIIIlII.func_146095_a(this);
        }
        return true;
    }
    
    public boolean func_175571_m() {
        return this.trackOutput;
    }
    
    @Override
    public String getName() {
        return this.customName;
    }
    
    public abstract int func_145751_f();
    
    @Override
    public void addChatMessage(final IChatComponent llllllllllllllllIIIllIlIIIlIlIII) {
        if (this.trackOutput && this.getEntityWorld() != null && !this.getEntityWorld().isRemote) {
            this.lastOutput = new ChatComponentText(String.valueOf(new StringBuilder("[").append(CommandBlockLogic.timestampFormat.format(new Date())).append("] "))).appendSibling(llllllllllllllllIIIllIlIIIlIlIII);
            this.func_145756_e();
        }
    }
    
    @Override
    public void func_174794_a(final CommandResultStats.Type llllllllllllllllIIIllIlIIIIllIlI, final int llllllllllllllllIIIllIlIIIIlllII) {
        this.field_175575_g.func_179672_a(this, llllllllllllllllIIIllIlIIIIllIlI, llllllllllllllllIIIllIlIIIIlllII);
    }
    
    public void func_175573_a(final boolean llllllllllllllllIIIllIlIIIIIllll) {
        this.trackOutput = llllllllllllllllIIIllIlIIIIIllll;
    }
    
    public abstract void func_145756_e();
    
    public CommandBlockLogic() {
        this.trackOutput = true;
        this.lastOutput = null;
        this.commandStored = "";
        this.customName = "@";
        this.field_175575_g = new CommandResultStats();
    }
    
    public abstract void func_145757_a(final ByteBuf p0);
    
    public void setCommand(final String llllllllllllllllIIIllIlIIlIlIIlI) {
        this.commandStored = llllllllllllllllIIIllIlIIlIlIIlI;
        this.successCount = 0;
    }
    
    @Override
    public IChatComponent getDisplayName() {
        return new ChatComponentText(this.getName());
    }
}
