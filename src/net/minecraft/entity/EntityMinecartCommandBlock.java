package net.minecraft.entity;

import net.minecraft.entity.item.*;
import net.minecraft.command.server.*;
import net.minecraft.world.*;
import io.netty.buffer.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;

public class EntityMinecartCommandBlock extends EntityMinecart
{
    private /* synthetic */ int field_145823_b;
    private final /* synthetic */ CommandBlockLogic field_145824_a;
    
    static {
        __OBFID = "CL_00001672";
    }
    
    public EntityMinecartCommandBlock(final World llllllllllllllllIIlIllllllIIlIlI) {
        super(llllllllllllllllIIlIllllllIIlIlI);
        this.field_145824_a = new CommandBlockLogic() {
            @Override
            public Entity getCommandSenderEntity() {
                return EntityMinecartCommandBlock.this;
            }
            
            @Override
            public void func_145756_e() {
                EntityMinecartCommandBlock.this.getDataWatcher().updateObject(23, this.getCustomName());
                EntityMinecartCommandBlock.this.getDataWatcher().updateObject(24, IChatComponent.Serializer.componentToJson(this.getLastOutput()));
            }
            
            @Override
            public void func_145757_a(final ByteBuf llllllllllllllllIlIIlllIlIIlIllI) {
                llllllllllllllllIlIIlllIlIIlIllI.writeInt(EntityMinecartCommandBlock.this.getEntityId());
            }
            
            @Override
            public int func_145751_f() {
                return 1;
            }
            
            @Override
            public Vec3 getPositionVector() {
                return new Vec3(EntityMinecartCommandBlock.this.posX, EntityMinecartCommandBlock.this.posY, EntityMinecartCommandBlock.this.posZ);
            }
            
            @Override
            public World getEntityWorld() {
                return EntityMinecartCommandBlock.this.worldObj;
            }
            
            @Override
            public BlockPos getPosition() {
                return new BlockPos(EntityMinecartCommandBlock.this.posX, EntityMinecartCommandBlock.this.posY + 0.5, EntityMinecartCommandBlock.this.posZ);
            }
            
            static {
                __OBFID = "CL_00001673";
            }
        };
        this.field_145823_b = 0;
    }
    
    @Override
    public IBlockState func_180457_u() {
        return Blocks.command_block.getDefaultState();
    }
    
    @Override
    public EnumMinecartType func_180456_s() {
        return EnumMinecartType.COMMAND_BLOCK;
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllllIIlIlllllIIllIlI) {
        super.writeEntityToNBT(llllllllllllllllIIlIlllllIIllIlI);
        this.field_145824_a.writeDataToNBT(llllllllllllllllIIlIlllllIIllIlI);
    }
    
    @Override
    public void onActivatorRailPass(final int llllllllllllllllIIlIlllllIIIIlII, final int llllllllllllllllIIlIlllllIIIIIll, final int llllllllllllllllIIlIllllIlllllII, final boolean llllllllllllllllIIlIllllIllllIIl) {
        if (llllllllllllllllIIlIllllIllllIIl && this.ticksExisted - this.field_145823_b >= 4) {
            this.func_145822_e().trigger(this.worldObj);
            this.field_145823_b = this.ticksExisted;
        }
    }
    
    public EntityMinecartCommandBlock(final World llllllllllllllllIIlIlllllIllIllI, final double llllllllllllllllIIlIlllllIllIlII, final double llllllllllllllllIIlIlllllIllIIlI, final double llllllllllllllllIIlIlllllIllIIIl) {
        super(llllllllllllllllIIlIlllllIllIllI, llllllllllllllllIIlIlllllIllIlII, llllllllllllllllIIlIlllllIllIIlI, llllllllllllllllIIlIlllllIllIIIl);
        this.field_145824_a = new CommandBlockLogic() {
            @Override
            public Entity getCommandSenderEntity() {
                return EntityMinecartCommandBlock.this;
            }
            
            @Override
            public void func_145756_e() {
                EntityMinecartCommandBlock.this.getDataWatcher().updateObject(23, this.getCustomName());
                EntityMinecartCommandBlock.this.getDataWatcher().updateObject(24, IChatComponent.Serializer.componentToJson(this.getLastOutput()));
            }
            
            @Override
            public void func_145757_a(final ByteBuf llllllllllllllllIlIIlllIlIIlIllI) {
                llllllllllllllllIlIIlllIlIIlIllI.writeInt(EntityMinecartCommandBlock.this.getEntityId());
            }
            
            @Override
            public int func_145751_f() {
                return 1;
            }
            
            @Override
            public Vec3 getPositionVector() {
                return new Vec3(EntityMinecartCommandBlock.this.posX, EntityMinecartCommandBlock.this.posY, EntityMinecartCommandBlock.this.posZ);
            }
            
            @Override
            public World getEntityWorld() {
                return EntityMinecartCommandBlock.this.worldObj;
            }
            
            @Override
            public BlockPos getPosition() {
                return new BlockPos(EntityMinecartCommandBlock.this.posX, EntityMinecartCommandBlock.this.posY + 0.5, EntityMinecartCommandBlock.this.posZ);
            }
            
            static {
                __OBFID = "CL_00001673";
            }
        };
        this.field_145823_b = 0;
    }
    
    @Override
    public boolean interactFirst(final EntityPlayer llllllllllllllllIIlIllllIlllIIlI) {
        this.field_145824_a.func_175574_a(llllllllllllllllIIlIllllIlllIIlI);
        return false;
    }
    
    @Override
    public void func_145781_i(final int llllllllllllllllIIlIllllIlIlllll) {
        super.func_145781_i(llllllllllllllllIIlIllllIlIlllll);
        if (llllllllllllllllIIlIllllIlIlllll == 24) {
            try {
                this.field_145824_a.func_145750_b(IChatComponent.Serializer.jsonToComponent(this.getDataWatcher().getWatchableObjectString(24)));
            }
            catch (Throwable llllllllllllllllIIlIllllIlIllllI) {}
        }
        else if (llllllllllllllllIIlIllllIlIlllll == 23) {
            this.field_145824_a.setCommand(this.getDataWatcher().getWatchableObjectString(23));
        }
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(23, "");
        this.getDataWatcher().addObject(24, "");
    }
    
    public CommandBlockLogic func_145822_e() {
        return this.field_145824_a;
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllllIIlIlllllIlIIIll) {
        super.readEntityFromNBT(llllllllllllllllIIlIlllllIlIIIll);
        this.field_145824_a.readDataFromNBT(llllllllllllllllIIlIlllllIlIIIll);
        this.getDataWatcher().updateObject(23, this.func_145822_e().getCustomName());
        this.getDataWatcher().updateObject(24, IChatComponent.Serializer.componentToJson(this.func_145822_e().getLastOutput()));
    }
}
