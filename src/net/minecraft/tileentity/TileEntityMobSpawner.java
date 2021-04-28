package net.minecraft.tileentity;

import net.minecraft.server.gui.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;

public class TileEntityMobSpawner extends TileEntity implements IUpdatePlayerListBox
{
    private final /* synthetic */ MobSpawnerBaseLogic field_145882_a;
    
    public MobSpawnerBaseLogic getSpawnerBaseLogic() {
        return this.field_145882_a;
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllIllIllllIIllIIIIIl) {
        super.writeToNBT(llllllllllllllIllIllllIIllIIIIIl);
        this.field_145882_a.writeToNBT(llllllllllllllIllIllllIIllIIIIIl);
    }
    
    public TileEntityMobSpawner() {
        this.field_145882_a = new MobSpawnerBaseLogic() {
            @Override
            public BlockPos func_177221_b() {
                return TileEntityMobSpawner.this.pos;
            }
            
            @Override
            public void func_98267_a(final int llllllllllllllIlllIlllIllIllIIII) {
                TileEntityMobSpawner.this.worldObj.addBlockEvent(TileEntityMobSpawner.this.pos, Blocks.mob_spawner, llllllllllllllIlllIlllIllIllIIII, 0);
            }
            
            static {
                __OBFID = "CL_00000361";
            }
            
            @Override
            public World getSpawnerWorld() {
                return TileEntityMobSpawner.this.worldObj;
            }
            
            @Override
            public void setRandomEntity(final WeightedRandomMinecart llllllllllllllIlllIlllIllIlIIlII) {
                super.setRandomEntity(llllllllllllllIlllIlllIllIlIIlII);
                if (this.getSpawnerWorld() != null) {
                    this.getSpawnerWorld().markBlockForUpdate(TileEntityMobSpawner.this.pos);
                }
            }
        };
    }
    
    static {
        __OBFID = "CL_00000360";
    }
    
    @Override
    public boolean receiveClientEvent(final int llllllllllllllIllIllllIIlIllIIII, final int llllllllllllllIllIllllIIlIlIllll) {
        return this.field_145882_a.setDelayToMin(llllllllllllllIllIllllIIlIllIIII) || super.receiveClientEvent(llllllllllllllIllIllllIIlIllIIII, llllllllllllllIllIllllIIlIlIllll);
    }
    
    @Override
    public Packet getDescriptionPacket() {
        final NBTTagCompound llllllllllllllIllIllllIIlIlllIlI = new NBTTagCompound();
        this.writeToNBT(llllllllllllllIllIllllIIlIlllIlI);
        llllllllllllllIllIllllIIlIlllIlI.removeTag("SpawnPotentials");
        return new S35PacketUpdateTileEntity(this.pos, 1, llllllllllllllIllIllllIIlIlllIlI);
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIllIllllIIllIIlIIl) {
        super.readFromNBT(llllllllllllllIllIllllIIllIIlIIl);
        this.field_145882_a.readFromNBT(llllllllllllllIllIllllIIllIIlIIl);
    }
    
    @Override
    public void update() {
        this.field_145882_a.updateSpawner();
    }
}
