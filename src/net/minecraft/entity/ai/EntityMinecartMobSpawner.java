package net.minecraft.entity.ai;

import net.minecraft.entity.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;

public class EntityMinecartMobSpawner extends EntityMinecart
{
    private final /* synthetic */ MobSpawnerBaseLogic mobSpawnerLogic;
    
    @Override
    public EnumMinecartType func_180456_s() {
        return EnumMinecartType.SPAWNER;
    }
    
    static {
        __OBFID = "CL_00001678";
    }
    
    public EntityMinecartMobSpawner(final World llllllllllllllIllIIllIIllllIIIII, final double llllllllllllllIllIIllIIllllIIlII, final double llllllllllllllIllIIllIIllllIIIll, final double llllllllllllllIllIIllIIlllIlllIl) {
        super(llllllllllllllIllIIllIIllllIIIII, llllllllllllllIllIIllIIllllIIlII, llllllllllllllIllIIllIIllllIIIll, llllllllllllllIllIIllIIlllIlllIl);
        this.mobSpawnerLogic = new MobSpawnerBaseLogic() {
            static {
                __OBFID = "CL_00001679";
            }
            
            @Override
            public BlockPos func_177221_b() {
                return new BlockPos(EntityMinecartMobSpawner.this);
            }
            
            @Override
            public World getSpawnerWorld() {
                return EntityMinecartMobSpawner.this.worldObj;
            }
            
            @Override
            public void func_98267_a(final int llllllllllllllIlIllllIlllIIlllll) {
                EntityMinecartMobSpawner.this.worldObj.setEntityState(EntityMinecartMobSpawner.this, (byte)llllllllllllllIlIllllIlllIIlllll);
            }
        };
    }
    
    @Override
    public void handleHealthUpdate(final byte llllllllllllllIllIIllIIlllIIlIIl) {
        this.mobSpawnerLogic.setDelayToMin(llllllllllllllIllIIllIIlllIIlIIl);
    }
    
    public EntityMinecartMobSpawner(final World llllllllllllllIllIIllIIllllIllII) {
        super(llllllllllllllIllIIllIIllllIllII);
        this.mobSpawnerLogic = new MobSpawnerBaseLogic() {
            static {
                __OBFID = "CL_00001679";
            }
            
            @Override
            public BlockPos func_177221_b() {
                return new BlockPos(EntityMinecartMobSpawner.this);
            }
            
            @Override
            public World getSpawnerWorld() {
                return EntityMinecartMobSpawner.this.worldObj;
            }
            
            @Override
            public void func_98267_a(final int llllllllllllllIlIllllIlllIIlllll) {
                EntityMinecartMobSpawner.this.worldObj.setEntityState(EntityMinecartMobSpawner.this, (byte)llllllllllllllIlIllllIlllIIlllll);
            }
        };
    }
    
    @Override
    public IBlockState func_180457_u() {
        return Blocks.mob_spawner.getDefaultState();
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllIllIIllIIlllIIllll) {
        super.writeEntityToNBT(llllllllllllllIllIIllIIlllIIllll);
        this.mobSpawnerLogic.writeToNBT(llllllllllllllIllIIllIIlllIIllll);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.mobSpawnerLogic.updateSpawner();
    }
    
    public MobSpawnerBaseLogic func_98039_d() {
        return this.mobSpawnerLogic;
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllIllIIllIIlllIlIlll) {
        super.readEntityFromNBT(llllllllllllllIllIIllIIlllIlIlll);
        this.mobSpawnerLogic.readFromNBT(llllllllllllllIllIIllIIlllIlIlll);
    }
}
