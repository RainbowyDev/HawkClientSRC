package net.minecraft.tileentity;

import net.minecraft.command.server.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import io.netty.buffer.*;
import net.minecraft.command.*;

public class TileEntityCommandBlock extends TileEntity
{
    private final /* synthetic */ CommandBlockLogic field_145994_a;
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllIIlIllIIlIIIllIIl) {
        super.readFromNBT(lllllllllllllllIIlIllIIlIIIllIIl);
        this.field_145994_a.readDataFromNBT(lllllllllllllllIIlIllIIlIIIllIIl);
    }
    
    public CommandBlockLogic getCommandBlockLogic() {
        return this.field_145994_a;
    }
    
    static {
        __OBFID = "CL_00000347";
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound lllllllllllllllIIlIllIIlIIIlllll) {
        super.writeToNBT(lllllllllllllllIIlIllIIlIIIlllll);
        this.field_145994_a.writeDataToNBT(lllllllllllllllIIlIllIIlIIIlllll);
    }
    
    @Override
    public Packet getDescriptionPacket() {
        final NBTTagCompound lllllllllllllllIIlIllIIlIIIlIIll = new NBTTagCompound();
        this.writeToNBT(lllllllllllllllIIlIllIIlIIIlIIll);
        return new S35PacketUpdateTileEntity(this.pos, 2, lllllllllllllllIIlIllIIlIIIlIIll);
    }
    
    public TileEntityCommandBlock() {
        this.field_145994_a = new CommandBlockLogic() {
            @Override
            public BlockPos getPosition() {
                return TileEntityCommandBlock.this.pos;
            }
            
            @Override
            public Vec3 getPositionVector() {
                return new Vec3(TileEntityCommandBlock.this.pos.getX() + 0.5, TileEntityCommandBlock.this.pos.getY() + 0.5, TileEntityCommandBlock.this.pos.getZ() + 0.5);
            }
            
            static {
                __OBFID = "CL_00000348";
            }
            
            @Override
            public void setCommand(final String llllllllllllllIIIlllIllllIllIlII) {
                super.setCommand(llllllllllllllIIIlllIllllIllIlII);
                TileEntityCommandBlock.this.markDirty();
            }
            
            @Override
            public void func_145756_e() {
                TileEntityCommandBlock.this.getWorld().markBlockForUpdate(TileEntityCommandBlock.this.pos);
            }
            
            @Override
            public Entity getCommandSenderEntity() {
                return null;
            }
            
            @Override
            public int func_145751_f() {
                return 0;
            }
            
            @Override
            public World getEntityWorld() {
                return TileEntityCommandBlock.this.getWorld();
            }
            
            @Override
            public void func_145757_a(final ByteBuf llllllllllllllIIIlllIllllIlIllII) {
                llllllllllllllIIIlllIllllIlIllII.writeInt(TileEntityCommandBlock.this.pos.getX());
                llllllllllllllIIIlllIllllIlIllII.writeInt(TileEntityCommandBlock.this.pos.getY());
                llllllllllllllIIIlllIllllIlIllII.writeInt(TileEntityCommandBlock.this.pos.getZ());
            }
        };
    }
    
    public CommandResultStats func_175124_c() {
        return this.field_145994_a.func_175572_n();
    }
}
