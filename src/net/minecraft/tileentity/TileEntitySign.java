package net.minecraft.tileentity;

import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.command.*;
import com.google.gson.*;
import net.minecraft.event.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;

public class TileEntitySign extends TileEntity
{
    public final /* synthetic */ IChatComponent[] signText;
    private final /* synthetic */ CommandResultStats field_174883_i;
    public /* synthetic */ int lineBeingEdited;
    private /* synthetic */ boolean isEditable;
    private /* synthetic */ EntityPlayer field_145917_k;
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIllIlIllIllIlllIlI) {
        this.isEditable = false;
        super.readFromNBT(llllllllllllllIllIlIllIllIlllIlI);
        final ICommandSender llllllllllllllIllIlIllIllIlllIIl = new ICommandSender() {
            @Override
            public Entity getCommandSenderEntity() {
                return null;
            }
            
            @Override
            public BlockPos getPosition() {
                return TileEntitySign.this.pos;
            }
            
            @Override
            public World getEntityWorld() {
                return TileEntitySign.this.worldObj;
            }
            
            @Override
            public IChatComponent getDisplayName() {
                return new ChatComponentText(this.getName());
            }
            
            static {
                __OBFID = "CL_00002039";
            }
            
            @Override
            public boolean canCommandSenderUseCommand(final int llllllllllllllIlIlIllIlllllllIII, final String llllllllllllllIlIlIllIllllllIlll) {
                return true;
            }
            
            @Override
            public boolean sendCommandFeedback() {
                return false;
            }
            
            @Override
            public void func_174794_a(final CommandResultStats.Type llllllllllllllIlIlIllIlllllIlIlI, final int llllllllllllllIlIlIllIlllllIlIIl) {
            }
            
            @Override
            public String getName() {
                return "Sign";
            }
            
            @Override
            public Vec3 getPositionVector() {
                return new Vec3(TileEntitySign.this.pos.getX() + 0.5, TileEntitySign.this.pos.getY() + 0.5, TileEntitySign.this.pos.getZ() + 0.5);
            }
            
            @Override
            public void addChatMessage(final IChatComponent llllllllllllllIlIlIllIlllllllIlI) {
            }
        };
        for (int llllllllllllllIllIlIllIllIlllIII = 0; llllllllllllllIllIlIllIllIlllIII < 4; ++llllllllllllllIllIlIllIllIlllIII) {
            final String llllllllllllllIllIlIllIllIllIlll = llllllllllllllIllIlIllIllIlllIlI.getString(String.valueOf(new StringBuilder("Text").append(llllllllllllllIllIlIllIllIlllIII + 1)));
            try {
                final IChatComponent llllllllllllllIllIlIllIllIllIllI = IChatComponent.Serializer.jsonToComponent(llllllllllllllIllIlIllIllIllIlll);
                try {
                    this.signText[llllllllllllllIllIlIllIllIlllIII] = ChatComponentProcessor.func_179985_a(llllllllllllllIllIlIllIllIlllIIl, llllllllllllllIllIlIllIllIllIllI, null);
                }
                catch (CommandException llllllllllllllIllIlIllIllIllIlIl) {
                    this.signText[llllllllllllllIllIlIllIllIlllIII] = llllllllllllllIllIlIllIllIllIllI;
                }
            }
            catch (JsonParseException llllllllllllllIllIlIllIllIllIlII) {
                this.signText[llllllllllllllIllIlIllIllIlllIII] = new ChatComponentText(llllllllllllllIllIlIllIllIllIlll);
            }
        }
        this.field_174883_i.func_179668_a(llllllllllllllIllIlIllIllIlllIlI);
    }
    
    public EntityPlayer func_145911_b() {
        return this.field_145917_k;
    }
    
    public CommandResultStats func_174880_d() {
        return this.field_174883_i;
    }
    
    static {
        __OBFID = "CL_00000363";
    }
    
    public boolean func_174882_b(final EntityPlayer llllllllllllllIllIlIllIllIIIllIl) {
        final ICommandSender llllllllllllllIllIlIllIllIIIllII = new ICommandSender() {
            @Override
            public String getName() {
                return llllllllllllllIllIlIllIllIIIllIl.getName();
            }
            
            @Override
            public IChatComponent getDisplayName() {
                return llllllllllllllIllIlIllIllIIIllIl.getDisplayName();
            }
            
            @Override
            public Vec3 getPositionVector() {
                return new Vec3(TileEntitySign.this.pos.getX() + 0.5, TileEntitySign.this.pos.getY() + 0.5, TileEntitySign.this.pos.getZ() + 0.5);
            }
            
            @Override
            public void func_174794_a(final CommandResultStats.Type llIIIIIlIIIIll, final int llIIIIIlIIIIlI) {
                TileEntitySign.this.field_174883_i.func_179672_a(this, llIIIIIlIIIIll, llIIIIIlIIIIlI);
            }
            
            static {
                __OBFID = "CL_00002038";
            }
            
            @Override
            public void addChatMessage(final IChatComponent llIIIIIlIllIII) {
            }
            
            @Override
            public World getEntityWorld() {
                return llllllllllllllIllIlIllIllIIIllIl.getEntityWorld();
            }
            
            @Override
            public boolean sendCommandFeedback() {
                return false;
            }
            
            @Override
            public Entity getCommandSenderEntity() {
                return llllllllllllllIllIlIllIllIIIllIl;
            }
            
            @Override
            public boolean canCommandSenderUseCommand(final int llIIIIIlIlIllI, final String llIIIIIlIlIlIl) {
                return true;
            }
            
            @Override
            public BlockPos getPosition() {
                return TileEntitySign.this.pos;
            }
        };
        for (int llllllllllllllIllIlIllIllIIIlIll = 0; llllllllllllllIllIlIllIllIIIlIll < this.signText.length; ++llllllllllllllIllIlIllIllIIIlIll) {
            final ChatStyle llllllllllllllIllIlIllIllIIIlIlI = (this.signText[llllllllllllllIllIlIllIllIIIlIll] == null) ? null : this.signText[llllllllllllllIllIlIllIllIIIlIll].getChatStyle();
            if (llllllllllllllIllIlIllIllIIIlIlI != null && llllllllllllllIllIlIllIllIIIlIlI.getChatClickEvent() != null) {
                final ClickEvent llllllllllllllIllIlIllIllIIIlIIl = llllllllllllllIllIlIllIllIIIlIlI.getChatClickEvent();
                if (llllllllllllllIllIlIllIllIIIlIIl.getAction() == ClickEvent.Action.RUN_COMMAND) {
                    MinecraftServer.getServer().getCommandManager().executeCommand(llllllllllllllIllIlIllIllIIIllII, llllllllllllllIllIlIllIllIIIlIIl.getValue());
                }
            }
        }
        return true;
    }
    
    @Override
    public Packet getDescriptionPacket() {
        final IChatComponent[] llllllllllllllIllIlIllIllIlIlIIl = new IChatComponent[4];
        System.arraycopy(this.signText, 0, llllllllllllllIllIlIllIllIlIlIIl, 0, 4);
        return new S33PacketUpdateSign(this.worldObj, this.pos, llllllllllllllIllIlIllIllIlIlIIl);
    }
    
    public boolean getIsEditable() {
        return this.isEditable;
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllIllIlIllIlllIIlIIl) {
        super.writeToNBT(llllllllllllllIllIlIllIlllIIlIIl);
        for (int llllllllllllllIllIlIllIlllIIlIII = 0; llllllllllllllIllIlIllIlllIIlIII < 4; ++llllllllllllllIllIlIllIlllIIlIII) {
            final String llllllllllllllIllIlIllIlllIIIlll = IChatComponent.Serializer.componentToJson(this.signText[llllllllllllllIllIlIllIlllIIlIII]);
            llllllllllllllIllIlIllIlllIIlIIl.setString(String.valueOf(new StringBuilder("Text").append(llllllllllllllIllIlIllIlllIIlIII + 1)), llllllllllllllIllIlIllIlllIIIlll);
        }
        this.field_174883_i.func_179670_b(llllllllllllllIllIlIllIlllIIlIIl);
    }
    
    public TileEntitySign() {
        this.signText = new IChatComponent[] { new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText("") };
        this.lineBeingEdited = -1;
        this.isEditable = true;
        this.field_174883_i = new CommandResultStats();
    }
    
    public void setEditable(final boolean llllllllllllllIllIlIllIllIlIIIII) {
        this.isEditable = llllllllllllllIllIlIllIllIlIIIII;
        if (!llllllllllllllIllIlIllIllIlIIIII) {
            this.field_145917_k = null;
        }
    }
    
    public void func_145912_a(final EntityPlayer llllllllllllllIllIlIllIllIIllIlI) {
        this.field_145917_k = llllllllllllllIllIlIllIllIIllIlI;
    }
}
