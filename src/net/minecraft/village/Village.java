package net.minecraft.village;

import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import net.minecraft.entity.monster.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;

public class Village
{
    private /* synthetic */ int tickCounter;
    private /* synthetic */ int numVillagers;
    private /* synthetic */ World worldObj;
    private /* synthetic */ List villageAgressors;
    private /* synthetic */ TreeMap playerReputation;
    private /* synthetic */ int noBreedTicks;
    private final /* synthetic */ List villageDoorInfoList;
    private /* synthetic */ BlockPos center;
    private /* synthetic */ int lastAddDoorTimestamp;
    private /* synthetic */ BlockPos centerHelper;
    private /* synthetic */ int villageRadius;
    private /* synthetic */ int numIronGolems;
    
    public boolean isAnnihilated() {
        return this.villageDoorInfoList.isEmpty();
    }
    
    public BlockPos func_180608_a() {
        return this.center;
    }
    
    public List getVillageDoorInfoList() {
        return this.villageDoorInfoList;
    }
    
    public EntityLivingBase findNearestVillageAggressor(final EntityLivingBase lllllllllllllllIIllIIlIlIIllIIII) {
        double lllllllllllllllIIllIIlIlIIlIllll = Double.MAX_VALUE;
        VillageAgressor lllllllllllllllIIllIIlIlIIlIlllI = null;
        for (int lllllllllllllllIIllIIlIlIIlIllIl = 0; lllllllllllllllIIllIIlIlIIlIllIl < this.villageAgressors.size(); ++lllllllllllllllIIllIIlIlIIlIllIl) {
            final VillageAgressor lllllllllllllllIIllIIlIlIIlIllII = this.villageAgressors.get(lllllllllllllllIIllIIlIlIIlIllIl);
            final double lllllllllllllllIIllIIlIlIIlIlIll = lllllllllllllllIIllIIlIlIIlIllII.agressor.getDistanceSqToEntity(lllllllllllllllIIllIIlIlIIllIIII);
            if (lllllllllllllllIIllIIlIlIIlIlIll <= lllllllllllllllIIllIIlIlIIlIllll) {
                lllllllllllllllIIllIIlIlIIlIlllI = lllllllllllllllIIllIIlIlIIlIllII;
                lllllllllllllllIIllIIlIlIIlIllll = lllllllllllllllIIllIIlIlIIlIlIll;
            }
        }
        return (lllllllllllllllIIllIIlIlIIlIlllI != null) ? lllllllllllllllIIllIIlIlIIlIlllI.agressor : null;
    }
    
    public int getNumVillagers() {
        return this.numVillagers;
    }
    
    private Vec3 func_179862_a(final BlockPos lllllllllllllllIIllIIlIlllIIllII, final int lllllllllllllllIIllIIlIlllIIIlII, final int lllllllllllllllIIllIIlIlllIIlIlI, final int lllllllllllllllIIllIIlIlllIIlIIl) {
        for (int lllllllllllllllIIllIIlIlllIIlIII = 0; lllllllllllllllIIllIIlIlllIIlIII < 10; ++lllllllllllllllIIllIIlIlllIIlIII) {
            final BlockPos lllllllllllllllIIllIIlIlllIIIlll = lllllllllllllllIIllIIlIlllIIllII.add(this.worldObj.rand.nextInt(16) - 8, this.worldObj.rand.nextInt(6) - 3, this.worldObj.rand.nextInt(16) - 8);
            if (this.func_179866_a(lllllllllllllllIIllIIlIlllIIIlll) && this.func_179861_a(new BlockPos(lllllllllllllllIIllIIlIlllIIIlII, lllllllllllllllIIllIIlIlllIIlIlI, lllllllllllllllIIllIIlIlllIIlIIl), lllllllllllllllIIllIIlIlllIIIlll)) {
                return new Vec3(lllllllllllllllIIllIIlIlllIIIlll.getX(), lllllllllllllllIIllIIlIlllIIIlll.getY(), lllllllllllllllIIllIIlIlllIIIlll.getZ());
            }
        }
        return null;
    }
    
    public VillageDoorInfo func_179864_e(final BlockPos lllllllllllllllIIllIIlIlIlIlIIII) {
        if (this.center.distanceSq(lllllllllllllllIIllIIlIlIlIlIIII) > this.villageRadius * this.villageRadius) {
            return null;
        }
        for (final VillageDoorInfo lllllllllllllllIIllIIlIlIlIlIIlI : this.villageDoorInfoList) {
            if (lllllllllllllllIIllIIlIlIlIlIIlI.func_179852_d().getX() == lllllllllllllllIIllIIlIlIlIlIIII.getX() && lllllllllllllllIIllIIlIlIlIlIIlI.func_179852_d().getZ() == lllllllllllllllIIllIIlIlIlIlIIII.getZ() && Math.abs(lllllllllllllllIIllIIlIlIlIlIIlI.func_179852_d().getY() - lllllllllllllllIIllIIlIlIlIlIIII.getY()) <= 1) {
                return lllllllllllllllIIllIIlIlIlIlIIlI;
            }
        }
        return null;
    }
    
    private void removeDeadAndOldAgressors() {
        final Iterator lllllllllllllllIIllIIlIlIIIIIlll = this.villageAgressors.iterator();
        while (lllllllllllllllIIllIIlIlIIIIIlll.hasNext()) {
            final VillageAgressor lllllllllllllllIIllIIlIlIIIIIllI = lllllllllllllllIIllIIlIlIIIIIlll.next();
            if (!lllllllllllllllIIllIIlIlIIIIIllI.agressor.isEntityAlive() || Math.abs(this.tickCounter - lllllllllllllllIIllIIlIlIIIIIllI.agressionTime) > 300) {
                lllllllllllllllIIllIIlIlIIIIIlll.remove();
            }
        }
    }
    
    public void addOrRenewAgressor(final EntityLivingBase lllllllllllllllIIllIIlIlIIllllll) {
        for (final VillageAgressor lllllllllllllllIIllIIlIlIIllllIl : this.villageAgressors) {
            if (lllllllllllllllIIllIIlIlIIllllIl.agressor == lllllllllllllllIIllIIlIlIIllllll) {
                lllllllllllllllIIllIIlIlIIllllIl.agressionTime = this.tickCounter;
                return;
            }
        }
        this.villageAgressors.add(new VillageAgressor(lllllllllllllllIIllIIlIlIIllllll, this.tickCounter));
    }
    
    public void endMatingSeason() {
        this.noBreedTicks = this.tickCounter;
    }
    
    public EntityPlayer func_82685_c(final EntityLivingBase lllllllllllllllIIllIIlIlIIIlIIlI) {
        double lllllllllllllllIIllIIlIlIIIllIIl = Double.MAX_VALUE;
        EntityPlayer lllllllllllllllIIllIIlIlIIIllIII = null;
        for (final String lllllllllllllllIIllIIlIlIIIlIllI : this.playerReputation.keySet()) {
            if (this.isPlayerReputationTooLow(lllllllllllllllIIllIIlIlIIIlIllI)) {
                final EntityPlayer lllllllllllllllIIllIIlIlIIIlIlIl = this.worldObj.getPlayerEntityByName(lllllllllllllllIIllIIlIlIIIlIllI);
                if (lllllllllllllllIIllIIlIlIIIlIlIl == null) {
                    continue;
                }
                final double lllllllllllllllIIllIIlIlIIIlIlII = lllllllllllllllIIllIIlIlIIIlIlIl.getDistanceSqToEntity(lllllllllllllllIIllIIlIlIIIlIIlI);
                if (lllllllllllllllIIllIIlIlIIIlIlII > lllllllllllllllIIllIIlIlIIIllIIl) {
                    continue;
                }
                lllllllllllllllIIllIIlIlIIIllIII = lllllllllllllllIIllIIlIlIIIlIlIl;
                lllllllllllllllIIllIIlIlIIIllIIl = lllllllllllllllIIllIIlIlIIIlIlII;
            }
        }
        return lllllllllllllllIIllIIlIlIIIllIII;
    }
    
    public Village(final World lllllllllllllllIIllIIlIllllIlIlI) {
        this.villageDoorInfoList = Lists.newArrayList();
        this.centerHelper = BlockPos.ORIGIN;
        this.center = BlockPos.ORIGIN;
        this.playerReputation = new TreeMap();
        this.villageAgressors = Lists.newArrayList();
        this.worldObj = lllllllllllllllIIllIIlIllllIlIlI;
    }
    
    private void updateVillageRadiusAndCenter() {
        final int lllllllllllllllIIllIIlIIlllIIlII = this.villageDoorInfoList.size();
        if (lllllllllllllllIIllIIlIIlllIIlII == 0) {
            this.center = new BlockPos(0, 0, 0);
            this.villageRadius = 0;
        }
        else {
            this.center = new BlockPos(this.centerHelper.getX() / lllllllllllllllIIllIIlIIlllIIlII, this.centerHelper.getY() / lllllllllllllllIIllIIlIIlllIIlII, this.centerHelper.getZ() / lllllllllllllllIIllIIlIIlllIIlII);
            int lllllllllllllllIIllIIlIIlllIIIll = 0;
            for (final VillageDoorInfo lllllllllllllllIIllIIlIIlllIIIlI : this.villageDoorInfoList) {
                lllllllllllllllIIllIIlIIlllIIIll = Math.max(lllllllllllllllIIllIIlIIlllIIIlI.func_179848_a(this.center), lllllllllllllllIIllIIlIIlllIIIll);
            }
            this.villageRadius = Math.max(32, (int)Math.sqrt(lllllllllllllllIIllIIlIIlllIIIll) + 1);
        }
    }
    
    public void tick(final int lllllllllllllllIIllIIlIlllIllIII) {
        this.tickCounter = lllllllllllllllIIllIIlIlllIllIII;
        this.removeDeadAndOutOfRangeDoors();
        this.removeDeadAndOldAgressors();
        if (lllllllllllllllIIllIIlIlllIllIII % 20 == 0) {
            this.updateNumVillagers();
        }
        if (lllllllllllllllIIllIIlIlllIllIII % 30 == 0) {
            this.updateNumIronGolems();
        }
        final int lllllllllllllllIIllIIlIlllIlllII = this.numVillagers / 10;
        if (this.numIronGolems < lllllllllllllllIIllIIlIlllIlllII && this.villageDoorInfoList.size() > 20 && this.worldObj.rand.nextInt(7000) == 0) {
            final Vec3 lllllllllllllllIIllIIlIlllIllIll = this.func_179862_a(this.center, 2, 4, 2);
            if (lllllllllllllllIIllIIlIlllIllIll != null) {
                final EntityIronGolem lllllllllllllllIIllIIlIlllIllIlI = new EntityIronGolem(this.worldObj);
                lllllllllllllllIIllIIlIlllIllIlI.setPosition(lllllllllllllllIIllIIlIlllIllIll.xCoord, lllllllllllllllIIllIIlIlllIllIll.yCoord, lllllllllllllllIIllIIlIlllIllIll.zCoord);
                this.worldObj.spawnEntityInWorld(lllllllllllllllIIllIIlIlllIllIlI);
                ++this.numIronGolems;
            }
        }
    }
    
    public boolean func_179866_a(final BlockPos lllllllllllllllIIllIIlIllIIIIlll) {
        return this.center.distanceSq(lllllllllllllllIIllIIlIllIIIIlll) < this.villageRadius * this.villageRadius;
    }
    
    private boolean func_179860_f(final BlockPos lllllllllllllllIIllIIlIIlllIllII) {
        final Block lllllllllllllllIIllIIlIIlllIlllI = this.worldObj.getBlockState(lllllllllllllllIIllIIlIIlllIllII).getBlock();
        return lllllllllllllllIIllIIlIIlllIlllI instanceof BlockDoor && lllllllllllllllIIllIIlIIlllIlllI.getMaterial() == Material.wood;
    }
    
    public void addVillageDoorInfo(final VillageDoorInfo lllllllllllllllIIllIIlIlIlIIlIlI) {
        this.villageDoorInfoList.add(lllllllllllllllIIllIIlIlIlIIlIlI);
        this.centerHelper = this.centerHelper.add(lllllllllllllllIIllIIlIlIlIIlIlI.func_179852_d());
        this.updateVillageRadiusAndCenter();
        this.lastAddDoorTimestamp = lllllllllllllllIIllIIlIlIlIIlIlI.getInsidePosY();
    }
    
    public int getTicksSinceLastDoorAdding() {
        return this.tickCounter - this.lastAddDoorTimestamp;
    }
    
    public Village() {
        this.villageDoorInfoList = Lists.newArrayList();
        this.centerHelper = BlockPos.ORIGIN;
        this.center = BlockPos.ORIGIN;
        this.playerReputation = new TreeMap();
        this.villageAgressors = Lists.newArrayList();
    }
    
    public int setReputationForPlayer(final String lllllllllllllllIIllIIlIIllIIIlll, final int lllllllllllllllIIllIIlIIllIIIllI) {
        final int lllllllllllllllIIllIIlIIllIIlIlI = this.getReputationForPlayer(lllllllllllllllIIllIIlIIllIIIlll);
        final int lllllllllllllllIIllIIlIIllIIlIIl = MathHelper.clamp_int(lllllllllllllllIIllIIlIIllIIlIlI + lllllllllllllllIIllIIlIIllIIIllI, -30, 10);
        this.playerReputation.put(lllllllllllllllIIllIIlIIllIIIlll, lllllllllllllllIIllIIlIIllIIlIIl);
        return lllllllllllllllIIllIIlIIllIIlIIl;
    }
    
    public void writeVillageDataToNBT(final NBTTagCompound lllllllllllllllIIllIIIlllllllIlI) {
        lllllllllllllllIIllIIIlllllllIlI.setInteger("PopSize", this.numVillagers);
        lllllllllllllllIIllIIIlllllllIlI.setInteger("Radius", this.villageRadius);
        lllllllllllllllIIllIIIlllllllIlI.setInteger("Golems", this.numIronGolems);
        lllllllllllllllIIllIIIlllllllIlI.setInteger("Stable", this.lastAddDoorTimestamp);
        lllllllllllllllIIllIIIlllllllIlI.setInteger("Tick", this.tickCounter);
        lllllllllllllllIIllIIIlllllllIlI.setInteger("MTick", this.noBreedTicks);
        lllllllllllllllIIllIIIlllllllIlI.setInteger("CX", this.center.getX());
        lllllllllllllllIIllIIIlllllllIlI.setInteger("CY", this.center.getY());
        lllllllllllllllIIllIIIlllllllIlI.setInteger("CZ", this.center.getZ());
        lllllllllllllllIIllIIIlllllllIlI.setInteger("ACX", this.centerHelper.getX());
        lllllllllllllllIIllIIIlllllllIlI.setInteger("ACY", this.centerHelper.getY());
        lllllllllllllllIIllIIIlllllllIlI.setInteger("ACZ", this.centerHelper.getZ());
        final NBTTagList lllllllllllllllIIllIIIlllllllIIl = new NBTTagList();
        for (final VillageDoorInfo lllllllllllllllIIllIIIllllllIlIl : this.villageDoorInfoList) {
            final NBTTagCompound lllllllllllllllIIllIIIllllllIIll = new NBTTagCompound();
            lllllllllllllllIIllIIIllllllIIll.setInteger("X", lllllllllllllllIIllIIIllllllIlIl.func_179852_d().getX());
            lllllllllllllllIIllIIIllllllIIll.setInteger("Y", lllllllllllllllIIllIIIllllllIlIl.func_179852_d().getY());
            lllllllllllllllIIllIIIllllllIIll.setInteger("Z", lllllllllllllllIIllIIIllllllIlIl.func_179852_d().getZ());
            lllllllllllllllIIllIIIllllllIIll.setInteger("IDX", lllllllllllllllIIllIIIllllllIlIl.func_179847_f());
            lllllllllllllllIIllIIIllllllIIll.setInteger("IDZ", lllllllllllllllIIllIIIllllllIlIl.func_179855_g());
            lllllllllllllllIIllIIIllllllIIll.setInteger("TS", lllllllllllllllIIllIIIllllllIlIl.getInsidePosY());
            lllllllllllllllIIllIIIlllllllIIl.appendTag(lllllllllllllllIIllIIIllllllIIll);
        }
        lllllllllllllllIIllIIIlllllllIlI.setTag("Doors", lllllllllllllllIIllIIIlllllllIIl);
        final NBTTagList lllllllllllllllIIllIIIllllllIIlI = new NBTTagList();
        for (final String lllllllllllllllIIllIIIllllllIIII : this.playerReputation.keySet()) {
            final NBTTagCompound lllllllllllllllIIllIIIlllllIlllI = new NBTTagCompound();
            lllllllllllllllIIllIIIlllllIlllI.setString("Name", lllllllllllllllIIllIIIllllllIIII);
            lllllllllllllllIIllIIIlllllIlllI.setInteger("S", this.playerReputation.get(lllllllllllllllIIllIIIllllllIIII));
            lllllllllllllllIIllIIIllllllIIlI.appendTag(lllllllllllllllIIllIIIlllllIlllI);
        }
        lllllllllllllllIIllIIIlllllllIlI.setTag("Players", lllllllllllllllIIllIIIllllllIIlI);
    }
    
    public boolean isMatingSeason() {
        return this.noBreedTicks == 0 || this.tickCounter - this.noBreedTicks >= 3600;
    }
    
    public VillageDoorInfo func_179865_b(final BlockPos lllllllllllllllIIllIIlIlIllllIll) {
        VillageDoorInfo lllllllllllllllIIllIIlIlIllllIlI = null;
        int lllllllllllllllIIllIIlIlIllllIIl = Integer.MAX_VALUE;
        for (final VillageDoorInfo lllllllllllllllIIllIIlIlIlllIlll : this.villageDoorInfoList) {
            final int lllllllllllllllIIllIIlIlIlllIllI = lllllllllllllllIIllIIlIlIlllIlll.func_179848_a(lllllllllllllllIIllIIlIlIllllIll);
            if (lllllllllllllllIIllIIlIlIlllIllI < lllllllllllllllIIllIIlIlIllllIIl) {
                lllllllllllllllIIllIIlIlIllllIlI = lllllllllllllllIIllIIlIlIlllIlll;
                lllllllllllllllIIllIIlIlIllllIIl = lllllllllllllllIIllIIlIlIlllIllI;
            }
        }
        return lllllllllllllllIIllIIlIlIllllIlI;
    }
    
    private void removeDeadAndOutOfRangeDoors() {
        boolean lllllllllllllllIIllIIlIIllllllII = false;
        final boolean lllllllllllllllIIllIIlIIlllllIll = this.worldObj.rand.nextInt(50) == 0;
        final Iterator lllllllllllllllIIllIIlIIlllllIlI = this.villageDoorInfoList.iterator();
        while (lllllllllllllllIIllIIlIIlllllIlI.hasNext()) {
            final VillageDoorInfo lllllllllllllllIIllIIlIIlllllIIl = lllllllllllllllIIllIIlIIlllllIlI.next();
            if (lllllllllllllllIIllIIlIIlllllIll) {
                lllllllllllllllIIllIIlIIlllllIIl.resetDoorOpeningRestrictionCounter();
            }
            if (!this.func_179860_f(lllllllllllllllIIllIIlIIlllllIIl.func_179852_d()) || Math.abs(this.tickCounter - lllllllllllllllIIllIIlIIlllllIIl.getInsidePosY()) > 1200) {
                this.centerHelper = this.centerHelper.add(lllllllllllllllIIllIIlIIlllllIIl.func_179852_d().multiply(-1));
                lllllllllllllllIIllIIlIIllllllII = true;
                lllllllllllllllIIllIIlIIlllllIIl.func_179853_a(true);
                lllllllllllllllIIllIIlIIlllllIlI.remove();
            }
        }
        if (lllllllllllllllIIllIIlIIllllllII) {
            this.updateVillageRadiusAndCenter();
        }
    }
    
    public void func_82691_a(final World lllllllllllllllIIllIIlIllllIIllI) {
        this.worldObj = lllllllllllllllIIllIIlIllllIIllI;
    }
    
    public void readVillageDataFromNBT(final NBTTagCompound lllllllllllllllIIllIIlIIIIllIllI) {
        this.numVillagers = lllllllllllllllIIllIIlIIIIllIllI.getInteger("PopSize");
        this.villageRadius = lllllllllllllllIIllIIlIIIIllIllI.getInteger("Radius");
        this.numIronGolems = lllllllllllllllIIllIIlIIIIllIllI.getInteger("Golems");
        this.lastAddDoorTimestamp = lllllllllllllllIIllIIlIIIIllIllI.getInteger("Stable");
        this.tickCounter = lllllllllllllllIIllIIlIIIIllIllI.getInteger("Tick");
        this.noBreedTicks = lllllllllllllllIIllIIlIIIIllIllI.getInteger("MTick");
        this.center = new BlockPos(lllllllllllllllIIllIIlIIIIllIllI.getInteger("CX"), lllllllllllllllIIllIIlIIIIllIllI.getInteger("CY"), lllllllllllllllIIllIIlIIIIllIllI.getInteger("CZ"));
        this.centerHelper = new BlockPos(lllllllllllllllIIllIIlIIIIllIllI.getInteger("ACX"), lllllllllllllllIIllIIlIIIIllIllI.getInteger("ACY"), lllllllllllllllIIllIIlIIIIllIllI.getInteger("ACZ"));
        final NBTTagList lllllllllllllllIIllIIlIIIIllIlIl = lllllllllllllllIIllIIlIIIIllIllI.getTagList("Doors", 10);
        for (int lllllllllllllllIIllIIlIIIIllIlII = 0; lllllllllllllllIIllIIlIIIIllIlII < lllllllllllllllIIllIIlIIIIllIlIl.tagCount(); ++lllllllllllllllIIllIIlIIIIllIlII) {
            final NBTTagCompound lllllllllllllllIIllIIlIIIIllIIll = lllllllllllllllIIllIIlIIIIllIlIl.getCompoundTagAt(lllllllllllllllIIllIIlIIIIllIlII);
            final VillageDoorInfo lllllllllllllllIIllIIlIIIIllIIlI = new VillageDoorInfo(new BlockPos(lllllllllllllllIIllIIlIIIIllIIll.getInteger("X"), lllllllllllllllIIllIIlIIIIllIIll.getInteger("Y"), lllllllllllllllIIllIIlIIIIllIIll.getInteger("Z")), lllllllllllllllIIllIIlIIIIllIIll.getInteger("IDX"), lllllllllllllllIIllIIlIIIIllIIll.getInteger("IDZ"), lllllllllllllllIIllIIlIIIIllIIll.getInteger("TS"));
            this.villageDoorInfoList.add(lllllllllllllllIIllIIlIIIIllIIlI);
        }
        final NBTTagList lllllllllllllllIIllIIlIIIIllIIIl = lllllllllllllllIIllIIlIIIIllIllI.getTagList("Players", 10);
        for (int lllllllllllllllIIllIIlIIIIllIIII = 0; lllllllllllllllIIllIIlIIIIllIIII < lllllllllllllllIIllIIlIIIIllIIIl.tagCount(); ++lllllllllllllllIIllIIlIIIIllIIII) {
            final NBTTagCompound lllllllllllllllIIllIIlIIIIlIllll = lllllllllllllllIIllIIlIIIIllIIIl.getCompoundTagAt(lllllllllllllllIIllIIlIIIIllIIII);
            this.playerReputation.put(lllllllllllllllIIllIIlIIIIlIllll.getString("Name"), lllllllllllllllIIllIIlIIIIlIllll.getInteger("S"));
        }
    }
    
    private void updateNumIronGolems() {
        final List lllllllllllllllIIllIIlIllIlIIlII = this.worldObj.getEntitiesWithinAABB(EntityIronGolem.class, new AxisAlignedBB(this.center.getX() - this.villageRadius, this.center.getY() - 4, this.center.getZ() - this.villageRadius, this.center.getX() + this.villageRadius, this.center.getY() + 4, this.center.getZ() + this.villageRadius));
        this.numIronGolems = lllllllllllllllIIllIIlIllIlIIlII.size();
    }
    
    private void updateNumVillagers() {
        final List lllllllllllllllIIllIIlIllIIllllI = this.worldObj.getEntitiesWithinAABB(EntityVillager.class, new AxisAlignedBB(this.center.getX() - this.villageRadius, this.center.getY() - 4, this.center.getZ() - this.villageRadius, this.center.getX() + this.villageRadius, this.center.getY() + 4, this.center.getZ() + this.villageRadius));
        this.numVillagers = lllllllllllllllIIllIIlIllIIllllI.size();
        if (this.numVillagers == 0) {
            this.playerReputation.clear();
        }
    }
    
    public int getReputationForPlayer(final String lllllllllllllllIIllIIlIIllIlIlll) {
        final Integer lllllllllllllllIIllIIlIIllIlIllI = this.playerReputation.get(lllllllllllllllIIllIIlIIllIlIlll);
        return (lllllllllllllllIIllIIlIIllIlIllI != null) ? lllllllllllllllIIllIIlIIllIlIllI : 0;
    }
    
    public int getNumVillageDoors() {
        return this.villageDoorInfoList.size();
    }
    
    public VillageDoorInfo func_179863_c(final BlockPos lllllllllllllllIIllIIlIlIlIlllll) {
        VillageDoorInfo lllllllllllllllIIllIIlIlIllIIlIl = null;
        int lllllllllllllllIIllIIlIlIllIIlII = Integer.MAX_VALUE;
        for (final VillageDoorInfo lllllllllllllllIIllIIlIlIllIIIlI : this.villageDoorInfoList) {
            int lllllllllllllllIIllIIlIlIllIIIIl = lllllllllllllllIIllIIlIlIllIIIlI.func_179848_a(lllllllllllllllIIllIIlIlIlIlllll);
            if (lllllllllllllllIIllIIlIlIllIIIIl > 256) {
                lllllllllllllllIIllIIlIlIllIIIIl *= 1000;
            }
            else {
                lllllllllllllllIIllIIlIlIllIIIIl = lllllllllllllllIIllIIlIlIllIIIlI.getDoorOpeningRestrictionCounter();
            }
            if (lllllllllllllllIIllIIlIlIllIIIIl < lllllllllllllllIIllIIlIlIllIIlII) {
                lllllllllllllllIIllIIlIlIllIIlIl = lllllllllllllllIIllIIlIlIllIIIlI;
                lllllllllllllllIIllIIlIlIllIIlII = lllllllllllllllIIllIIlIlIllIIIIl;
            }
        }
        return lllllllllllllllIIllIIlIlIllIIlIl;
    }
    
    static {
        __OBFID = "CL_00001631";
    }
    
    public int getVillageRadius() {
        return this.villageRadius;
    }
    
    private boolean func_179861_a(final BlockPos lllllllllllllllIIllIIlIllIlIlllI, final BlockPos lllllllllllllllIIllIIlIllIllIlIl) {
        if (!World.doesBlockHaveSolidTopSurface(this.worldObj, lllllllllllllllIIllIIlIllIllIlIl.offsetDown())) {
            return false;
        }
        final int lllllllllllllllIIllIIlIllIllIlII = lllllllllllllllIIllIIlIllIllIlIl.getX() - lllllllllllllllIIllIIlIllIlIlllI.getX() / 2;
        final int lllllllllllllllIIllIIlIllIllIIll = lllllllllllllllIIllIIlIllIllIlIl.getZ() - lllllllllllllllIIllIIlIllIlIlllI.getZ() / 2;
        for (int lllllllllllllllIIllIIlIllIllIIlI = lllllllllllllllIIllIIlIllIllIlII; lllllllllllllllIIllIIlIllIllIIlI < lllllllllllllllIIllIIlIllIllIlII + lllllllllllllllIIllIIlIllIlIlllI.getX(); ++lllllllllllllllIIllIIlIllIllIIlI) {
            for (int lllllllllllllllIIllIIlIllIllIIIl = lllllllllllllllIIllIIlIllIllIlIl.getY(); lllllllllllllllIIllIIlIllIllIIIl < lllllllllllllllIIllIIlIllIllIlIl.getY() + lllllllllllllllIIllIIlIllIlIlllI.getY(); ++lllllllllllllllIIllIIlIllIllIIIl) {
                for (int lllllllllllllllIIllIIlIllIllIIII = lllllllllllllllIIllIIlIllIllIIll; lllllllllllllllIIllIIlIllIllIIII < lllllllllllllllIIllIIlIllIllIIll + lllllllllllllllIIllIIlIllIlIlllI.getZ(); ++lllllllllllllllIIllIIlIllIllIIII) {
                    if (this.worldObj.getBlockState(new BlockPos(lllllllllllllllIIllIIlIllIllIIlI, lllllllllllllllIIllIIlIllIllIIIl, lllllllllllllllIIllIIlIllIllIIII)).getBlock().isNormalCube()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void setDefaultPlayerReputation(final int lllllllllllllllIIllIIIllllIllIII) {
        for (final String lllllllllllllllIIllIIIllllIlIllI : this.playerReputation.keySet()) {
            this.setReputationForPlayer(lllllllllllllllIIllIIIllllIlIllI, lllllllllllllllIIllIIIllllIllIII);
        }
    }
    
    public boolean isPlayerReputationTooLow(final String lllllllllllllllIIllIIlIIIlIllIII) {
        return this.getReputationForPlayer(lllllllllllllllIIllIIlIIIlIllIII) <= -15;
    }
    
    class VillageAgressor
    {
        public /* synthetic */ EntityLivingBase agressor;
        public /* synthetic */ int agressionTime;
        
        static {
            __OBFID = "CL_00001632";
        }
        
        VillageAgressor(final EntityLivingBase lllllllllllllllIlllIIIlIIIllIIII, final int lllllllllllllllIlllIIIlIIIlIllll) {
            this.agressor = lllllllllllllllIlllIIIlIIIllIIII;
            this.agressionTime = lllllllllllllllIlllIIIlIIIlIllll;
        }
    }
}
