package net.minecraft.tileentity;

import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;

public abstract class MobSpawnerBaseLogic
{
    private /* synthetic */ Entity cachedEntity;
    private /* synthetic */ int spawnDelay;
    private /* synthetic */ int maxNearbyEntities;
    private /* synthetic */ int maxSpawnDelay;
    private final /* synthetic */ List minecartToSpawn;
    private /* synthetic */ double field_98284_d;
    private /* synthetic */ int minSpawnDelay;
    private /* synthetic */ int activatingRangeFromPlayer;
    private /* synthetic */ WeightedRandomMinecart randomEntity;
    private /* synthetic */ int spawnRange;
    private /* synthetic */ double field_98287_c;
    private /* synthetic */ int spawnCount;
    private /* synthetic */ String mobID;
    
    static {
        __OBFID = "CL_00000129";
    }
    
    public Entity func_180612_a(final World lllllIlIIIIIllI) {
        if (this.cachedEntity == null) {
            Entity lllllIlIIIIlIII = EntityList.createEntityByName(this.getEntityNameToSpawn(), lllllIlIIIIIllI);
            if (lllllIlIIIIlIII != null) {
                lllllIlIIIIlIII = this.func_180613_a(lllllIlIIIIlIII, false);
                this.cachedEntity = lllllIlIIIIlIII;
            }
        }
        return this.cachedEntity;
    }
    
    public MobSpawnerBaseLogic() {
        this.spawnDelay = 20;
        this.mobID = "Pig";
        this.minecartToSpawn = Lists.newArrayList();
        this.minSpawnDelay = 200;
        this.maxSpawnDelay = 800;
        this.spawnCount = 4;
        this.maxNearbyEntities = 6;
        this.activatingRangeFromPlayer = 16;
        this.spawnRange = 4;
    }
    
    public boolean setDelayToMin(final int lllllIlIIIIIIIl) {
        if (lllllIlIIIIIIIl == 1 && this.getSpawnerWorld().isRemote) {
            this.spawnDelay = this.minSpawnDelay;
            return true;
        }
        return false;
    }
    
    public void readFromNBT(final NBTTagCompound lllllIlIIlIIIll) {
        this.mobID = lllllIlIIlIIIll.getString("EntityId");
        this.spawnDelay = lllllIlIIlIIIll.getShort("Delay");
        this.minecartToSpawn.clear();
        if (lllllIlIIlIIIll.hasKey("SpawnPotentials", 9)) {
            final NBTTagList lllllIlIIlIIIlI = lllllIlIIlIIIll.getTagList("SpawnPotentials", 10);
            for (int lllllIlIIlIIIIl = 0; lllllIlIIlIIIIl < lllllIlIIlIIIlI.tagCount(); ++lllllIlIIlIIIIl) {
                this.minecartToSpawn.add(new WeightedRandomMinecart(lllllIlIIlIIIlI.getCompoundTagAt(lllllIlIIlIIIIl)));
            }
        }
        if (lllllIlIIlIIIll.hasKey("SpawnData", 10)) {
            this.setRandomEntity(new WeightedRandomMinecart(lllllIlIIlIIIll.getCompoundTag("SpawnData"), this.mobID));
        }
        else {
            this.setRandomEntity(null);
        }
        if (lllllIlIIlIIIll.hasKey("MinSpawnDelay", 99)) {
            this.minSpawnDelay = lllllIlIIlIIIll.getShort("MinSpawnDelay");
            this.maxSpawnDelay = lllllIlIIlIIIll.getShort("MaxSpawnDelay");
            this.spawnCount = lllllIlIIlIIIll.getShort("SpawnCount");
        }
        if (lllllIlIIlIIIll.hasKey("MaxNearbyEntities", 99)) {
            this.maxNearbyEntities = lllllIlIIlIIIll.getShort("MaxNearbyEntities");
            this.activatingRangeFromPlayer = lllllIlIIlIIIll.getShort("RequiredPlayerRange");
        }
        if (lllllIlIIlIIIll.hasKey("SpawnRange", 99)) {
            this.spawnRange = lllllIlIIlIIIll.getShort("SpawnRange");
        }
        if (this.getSpawnerWorld() != null) {
            this.cachedEntity = null;
        }
    }
    
    public double func_177223_e() {
        return this.field_98284_d;
    }
    
    public abstract void func_98267_a(final int p0);
    
    public void setRandomEntity(final WeightedRandomMinecart lllllIIlllllIII) {
        this.randomEntity = lllllIIlllllIII;
    }
    
    private WeightedRandomMinecart getRandomEntity() {
        return this.randomEntity;
    }
    
    private Entity func_180613_a(final Entity lllllIlIIlllIIl, final boolean lllllIlIlIIIllI) {
        if (this.getRandomEntity() != null) {
            NBTTagCompound lllllIlIlIIIlIl = new NBTTagCompound();
            lllllIlIIlllIIl.writeToNBTOptional(lllllIlIlIIIlIl);
            for (final String lllllIlIlIIIIll : this.getRandomEntity().field_98222_b.getKeySet()) {
                final NBTBase lllllIlIlIIIIlI = this.getRandomEntity().field_98222_b.getTag(lllllIlIlIIIIll);
                lllllIlIlIIIlIl.setTag(lllllIlIlIIIIll, lllllIlIlIIIIlI.copy());
            }
            lllllIlIIlllIIl.readFromNBT(lllllIlIlIIIlIl);
            if (lllllIlIIlllIIl.worldObj != null && lllllIlIlIIIllI) {
                lllllIlIIlllIIl.worldObj.spawnEntityInWorld(lllllIlIIlllIIl);
            }
            Entity lllllIlIlIIIIII = lllllIlIIlllIIl;
            while (lllllIlIlIIIlIl.hasKey("Riding", 10)) {
                final NBTTagCompound lllllIlIlIIIIIl = lllllIlIlIIIlIl.getCompoundTag("Riding");
                final Entity lllllIlIIllllll = EntityList.createEntityByName(lllllIlIlIIIIIl.getString("id"), lllllIlIIlllIIl.worldObj);
                if (lllllIlIIllllll != null) {
                    final NBTTagCompound lllllIlIIlllllI = new NBTTagCompound();
                    lllllIlIIllllll.writeToNBTOptional(lllllIlIIlllllI);
                    for (final String lllllIlIIllllII : lllllIlIlIIIIIl.getKeySet()) {
                        final NBTBase lllllIlIIlllIll = lllllIlIlIIIIIl.getTag(lllllIlIIllllII);
                        lllllIlIIlllllI.setTag(lllllIlIIllllII, lllllIlIIlllIll.copy());
                    }
                    lllllIlIIllllll.readFromNBT(lllllIlIIlllllI);
                    lllllIlIIllllll.setLocationAndAngles(lllllIlIlIIIIII.posX, lllllIlIlIIIIII.posY, lllllIlIlIIIIII.posZ, lllllIlIlIIIIII.rotationYaw, lllllIlIlIIIIII.rotationPitch);
                    if (lllllIlIIlllIIl.worldObj != null && lllllIlIlIIIllI) {
                        lllllIlIIlllIIl.worldObj.spawnEntityInWorld(lllllIlIIllllll);
                    }
                    lllllIlIlIIIIII.mountEntity(lllllIlIIllllll);
                }
                lllllIlIlIIIIII = lllllIlIIllllll;
                lllllIlIlIIIlIl = lllllIlIlIIIIIl;
            }
        }
        else if (lllllIlIIlllIIl instanceof EntityLivingBase && lllllIlIIlllIIl.worldObj != null && lllllIlIlIIIllI) {
            ((EntityLiving)lllllIlIIlllIIl).func_180482_a(lllllIlIIlllIIl.worldObj.getDifficultyForLocation(new BlockPos(lllllIlIIlllIIl)), null);
            lllllIlIIlllIIl.worldObj.spawnEntityInWorld(lllllIlIIlllIIl);
        }
        return lllllIlIIlllIIl;
    }
    
    public void writeToNBT(final NBTTagCompound lllllIlIIIlIllI) {
        lllllIlIIIlIllI.setString("EntityId", this.getEntityNameToSpawn());
        lllllIlIIIlIllI.setShort("Delay", (short)this.spawnDelay);
        lllllIlIIIlIllI.setShort("MinSpawnDelay", (short)this.minSpawnDelay);
        lllllIlIIIlIllI.setShort("MaxSpawnDelay", (short)this.maxSpawnDelay);
        lllllIlIIIlIllI.setShort("SpawnCount", (short)this.spawnCount);
        lllllIlIIIlIllI.setShort("MaxNearbyEntities", (short)this.maxNearbyEntities);
        lllllIlIIIlIllI.setShort("RequiredPlayerRange", (short)this.activatingRangeFromPlayer);
        lllllIlIIIlIllI.setShort("SpawnRange", (short)this.spawnRange);
        if (this.getRandomEntity() != null) {
            lllllIlIIIlIllI.setTag("SpawnData", this.getRandomEntity().field_98222_b.copy());
        }
        if (this.getRandomEntity() != null || this.minecartToSpawn.size() > 0) {
            final NBTTagList lllllIlIIIlIlIl = new NBTTagList();
            if (this.minecartToSpawn.size() > 0) {
                for (final WeightedRandomMinecart lllllIlIIIlIIll : this.minecartToSpawn) {
                    lllllIlIIIlIlIl.appendTag(lllllIlIIIlIIll.func_98220_a());
                }
            }
            else {
                lllllIlIIIlIlIl.appendTag(this.getRandomEntity().func_98220_a());
            }
            lllllIlIIIlIllI.setTag("SpawnPotentials", lllllIlIIIlIlIl);
        }
    }
    
    private void resetTimer() {
        if (this.maxSpawnDelay <= this.minSpawnDelay) {
            this.spawnDelay = this.minSpawnDelay;
        }
        else {
            final int lllllIlIIlIlIll = this.maxSpawnDelay - this.minSpawnDelay;
            this.spawnDelay = this.minSpawnDelay + this.getSpawnerWorld().rand.nextInt(lllllIlIIlIlIll);
        }
        if (this.minecartToSpawn.size() > 0) {
            this.setRandomEntity((WeightedRandomMinecart)WeightedRandom.getRandomItem(this.getSpawnerWorld().rand, this.minecartToSpawn));
        }
        this.func_98267_a(1);
    }
    
    public abstract World getSpawnerWorld();
    
    public double func_177222_d() {
        return this.field_98287_c;
    }
    
    private boolean isActivated() {
        final BlockPos lllllIlIllllIII = this.func_177221_b();
        return this.getSpawnerWorld().func_175636_b(lllllIlIllllIII.getX() + 0.5, lllllIlIllllIII.getY() + 0.5, lllllIlIllllIII.getZ() + 0.5, this.activatingRangeFromPlayer);
    }
    
    public void setEntityName(final String lllllIlIlllllII) {
        this.mobID = lllllIlIlllllII;
    }
    
    private String getEntityNameToSpawn() {
        if (this.getRandomEntity() == null) {
            if (this.mobID.equals("Minecart")) {
                this.mobID = "MinecartRideable";
            }
            return this.mobID;
        }
        return this.getRandomEntity().entityType;
    }
    
    public void updateSpawner() {
        if (this.isActivated()) {
            final BlockPos lllllIlIllIlIlI = this.func_177221_b();
            if (this.getSpawnerWorld().isRemote) {
                final double lllllIlIllIIlll = lllllIlIllIlIlI.getX() + this.getSpawnerWorld().rand.nextFloat();
                final double lllllIlIllIIllI = lllllIlIllIlIlI.getY() + this.getSpawnerWorld().rand.nextFloat();
                final double lllllIlIllIlIIl = lllllIlIllIlIlI.getZ() + this.getSpawnerWorld().rand.nextFloat();
                this.getSpawnerWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllIlIllIIlll, lllllIlIllIIllI, lllllIlIllIlIIl, 0.0, 0.0, 0.0, new int[0]);
                this.getSpawnerWorld().spawnParticle(EnumParticleTypes.FLAME, lllllIlIllIIlll, lllllIlIllIIllI, lllllIlIllIlIIl, 0.0, 0.0, 0.0, new int[0]);
                if (this.spawnDelay > 0) {
                    --this.spawnDelay;
                }
                this.field_98284_d = this.field_98287_c;
                this.field_98287_c = (this.field_98287_c + 1000.0f / (this.spawnDelay + 200.0f)) % 360.0;
            }
            else {
                if (this.spawnDelay == -1) {
                    this.resetTimer();
                }
                if (this.spawnDelay > 0) {
                    --this.spawnDelay;
                    return;
                }
                boolean lllllIlIllIIlIl = false;
                for (int lllllIlIllIIlII = 0; lllllIlIllIIlII < this.spawnCount; ++lllllIlIllIIlII) {
                    final Entity lllllIlIllIIIll = EntityList.createEntityByName(this.getEntityNameToSpawn(), this.getSpawnerWorld());
                    if (lllllIlIllIIIll == null) {
                        return;
                    }
                    final int lllllIlIllIIIlI = this.getSpawnerWorld().getEntitiesWithinAABB(lllllIlIllIIIll.getClass(), new AxisAlignedBB(lllllIlIllIlIlI.getX(), lllllIlIllIlIlI.getY(), lllllIlIllIlIlI.getZ(), lllllIlIllIlIlI.getX() + 1, lllllIlIllIlIlI.getY() + 1, lllllIlIllIlIlI.getZ() + 1).expand(this.spawnRange, this.spawnRange, this.spawnRange)).size();
                    if (lllllIlIllIIIlI >= this.maxNearbyEntities) {
                        this.resetTimer();
                        return;
                    }
                    final double lllllIlIllIlIII = lllllIlIllIlIlI.getX() + (this.getSpawnerWorld().rand.nextDouble() - this.getSpawnerWorld().rand.nextDouble()) * this.spawnRange + 0.5;
                    final double lllllIlIllIIIIl = lllllIlIllIlIlI.getY() + this.getSpawnerWorld().rand.nextInt(3) - 1;
                    final double lllllIlIllIIIII = lllllIlIllIlIlI.getZ() + (this.getSpawnerWorld().rand.nextDouble() - this.getSpawnerWorld().rand.nextDouble()) * this.spawnRange + 0.5;
                    final EntityLiving lllllIlIlIlllll = (lllllIlIllIIIll instanceof EntityLiving) ? ((EntityLiving)lllllIlIllIIIll) : null;
                    lllllIlIllIIIll.setLocationAndAngles(lllllIlIllIlIII, lllllIlIllIIIIl, lllllIlIllIIIII, this.getSpawnerWorld().rand.nextFloat() * 360.0f, 0.0f);
                    if (lllllIlIlIlllll == null || (lllllIlIlIlllll.getCanSpawnHere() && lllllIlIlIlllll.handleLavaMovement())) {
                        this.func_180613_a(lllllIlIllIIIll, true);
                        this.getSpawnerWorld().playAuxSFX(2004, lllllIlIllIlIlI, 0);
                        if (lllllIlIlIlllll != null) {
                            lllllIlIlIlllll.spawnExplosionParticle();
                        }
                        lllllIlIllIIlIl = true;
                    }
                }
                if (lllllIlIllIIlIl) {
                    this.resetTimer();
                }
            }
        }
    }
    
    public abstract BlockPos func_177221_b();
    
    public class WeightedRandomMinecart extends WeightedRandom.Item
    {
        private final /* synthetic */ NBTTagCompound field_98222_b;
        private final /* synthetic */ String entityType;
        
        private WeightedRandomMinecart(final NBTTagCompound llllllllllllllIllIIlIIIlIllIlllI, String llllllllllllllIllIIlIIIlIllIlIII, final int llllllllllllllIllIIlIIIlIllIllII) {
            super(llllllllllllllIllIIlIIIlIllIllII);
            if (llllllllllllllIllIIlIIIlIllIlIII.equals("Minecart")) {
                if (llllllllllllllIllIIlIIIlIllIlllI != null) {
                    llllllllllllllIllIIlIIIlIllIlIII = EntityMinecart.EnumMinecartType.func_180038_a(llllllllllllllIllIIlIIIlIllIlllI.getInteger("Type")).func_180040_b();
                }
                else {
                    llllllllllllllIllIIlIIIlIllIlIII = "MinecartRideable";
                }
            }
            this.field_98222_b = llllllllllllllIllIIlIIIlIllIlllI;
            this.entityType = llllllllllllllIllIIlIIIlIllIlIII;
        }
        
        public WeightedRandomMinecart(final MobSpawnerBaseLogic llllllllllllllIllIIlIIIlIlllIlll, final NBTTagCompound llllllllllllllIllIIlIIIlIlllIllI, final String llllllllllllllIllIIlIIIlIllllIIl) {
            this(llllllllllllllIllIIlIIIlIlllIlll, llllllllllllllIllIIlIIIlIlllIllI, llllllllllllllIllIIlIIIlIllllIIl, 1);
        }
        
        static {
            __OBFID = "CL_00000130";
        }
        
        public WeightedRandomMinecart(final MobSpawnerBaseLogic llllllllllllllIllIIlIIIllIIIIIIl, final NBTTagCompound llllllllllllllIllIIlIIIllIIIIIll) {
            this(llllllllllllllIllIIlIIIllIIIIIIl, llllllllllllllIllIIlIIIllIIIIIll.getCompoundTag("Properties"), llllllllllllllIllIIlIIIllIIIIIll.getString("Type"), llllllllllllllIllIIlIIIllIIIIIll.getInteger("Weight"));
        }
        
        public NBTTagCompound func_98220_a() {
            final NBTTagCompound llllllllllllllIllIIlIIIlIllIIIll = new NBTTagCompound();
            llllllllllllllIllIIlIIIlIllIIIll.setTag("Properties", this.field_98222_b);
            llllllllllllllIllIIlIIIlIllIIIll.setString("Type", this.entityType);
            llllllllllllllIllIIlIIIlIllIIIll.setInteger("Weight", this.itemWeight);
            return llllllllllllllIllIIlIIIlIllIIIll;
        }
    }
}
