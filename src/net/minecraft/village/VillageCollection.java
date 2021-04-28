package net.minecraft.village;

import net.minecraft.nbt.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class VillageCollection extends WorldSavedData
{
    private final /* synthetic */ List villagerPositionsList;
    private /* synthetic */ World worldObj;
    private final /* synthetic */ List villageList;
    private final /* synthetic */ List newDoors;
    private /* synthetic */ int tickCounter;
    
    public void func_176060_a(final BlockPos lllllllllllllllIIIlIlIIIIllIIllI) {
        if (this.villagerPositionsList.size() <= 64 && !this.func_176057_e(lllllllllllllllIIIlIlIIIIllIIllI)) {
            this.villagerPositionsList.add(lllllllllllllllIIIlIlIIIIllIIllI);
        }
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound lllllllllllllllIIIlIIllllIlIIIlI) {
        lllllllllllllllIIIlIIllllIlIIIlI.setInteger("Tick", this.tickCounter);
        final NBTTagList lllllllllllllllIIIlIIllllIlIIIIl = new NBTTagList();
        for (final Village lllllllllllllllIIIlIIllllIIlllll : this.villageList) {
            final NBTTagCompound lllllllllllllllIIIlIIllllIIllllI = new NBTTagCompound();
            lllllllllllllllIIIlIIllllIIlllll.writeVillageDataToNBT(lllllllllllllllIIIlIIllllIIllllI);
            lllllllllllllllIIIlIIllllIlIIIIl.appendTag(lllllllllllllllIIIlIIllllIIllllI);
        }
        lllllllllllllllIIIlIIllllIlIIIlI.setTag("Villages", lllllllllllllllIIIlIIllllIlIIIIl);
    }
    
    public void tick() {
        ++this.tickCounter;
        for (final Village lllllllllllllllIIIlIlIIIIlIllllI : this.villageList) {
            lllllllllllllllIIIlIlIIIIlIllllI.tick(this.tickCounter);
        }
        this.removeAnnihilatedVillages();
        this.dropOldestVillagerPosition();
        this.addNewDoorsToVillageOrCreateVillage();
        if (this.tickCounter % 400 == 0) {
            this.markDirty();
        }
    }
    
    private void func_176059_d(final BlockPos lllllllllllllllIIIlIIllllllIIlll) {
        final EnumFacing lllllllllllllllIIIlIIllllllIllII = BlockDoor.func_176517_h(this.worldObj, lllllllllllllllIIIlIIllllllIIlll);
        final EnumFacing lllllllllllllllIIIlIIllllllIlIll = lllllllllllllllIIIlIIllllllIllII.getOpposite();
        final int lllllllllllllllIIIlIIllllllIlIlI = this.func_176061_a(lllllllllllllllIIIlIIllllllIIlll, lllllllllllllllIIIlIIllllllIllII, 5);
        final int lllllllllllllllIIIlIIllllllIlIIl = this.func_176061_a(lllllllllllllllIIIlIIllllllIIlll, lllllllllllllllIIIlIIllllllIlIll, lllllllllllllllIIIlIIllllllIlIlI + 1);
        if (lllllllllllllllIIIlIIllllllIlIlI != lllllllllllllllIIIlIIllllllIlIIl) {
            this.newDoors.add(new VillageDoorInfo(lllllllllllllllIIIlIIllllllIIlll, (lllllllllllllllIIIlIIllllllIlIlI < lllllllllllllllIIIlIIllllllIlIIl) ? lllllllllllllllIIIlIIllllllIllII : lllllllllllllllIIIlIIllllllIlIll, this.tickCounter));
        }
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllIIIlIIllllIllIlII) {
        this.tickCounter = lllllllllllllllIIIlIIllllIllIlII.getInteger("Tick");
        final NBTTagList lllllllllllllllIIIlIIllllIllIIll = lllllllllllllllIIIlIIllllIllIlII.getTagList("Villages", 10);
        for (int lllllllllllllllIIIlIIllllIllIIlI = 0; lllllllllllllllIIIlIIllllIllIIlI < lllllllllllllllIIIlIIllllIllIIll.tagCount(); ++lllllllllllllllIIIlIIllllIllIIlI) {
            final NBTTagCompound lllllllllllllllIIIlIIllllIllIIIl = lllllllllllllllIIIlIIllllIllIIll.getCompoundTagAt(lllllllllllllllIIIlIIllllIllIIlI);
            final Village lllllllllllllllIIIlIIllllIllIIII = new Village();
            lllllllllllllllIIIlIIllllIllIIII.readVillageDataFromNBT(lllllllllllllllIIIlIIllllIllIIIl);
            this.villageList.add(lllllllllllllllIIIlIIllllIllIIII);
        }
    }
    
    public List getVillageList() {
        return this.villageList;
    }
    
    private VillageDoorInfo func_176055_c(final BlockPos lllllllllllllllIIIlIIllllllllIIl) {
        for (final VillageDoorInfo lllllllllllllllIIIlIIlllllllllIl : this.newDoors) {
            if (lllllllllllllllIIIlIIlllllllllIl.func_179852_d().getX() == lllllllllllllllIIIlIIllllllllIIl.getX() && lllllllllllllllIIIlIIlllllllllIl.func_179852_d().getZ() == lllllllllllllllIIIlIIllllllllIIl.getZ() && Math.abs(lllllllllllllllIIIlIIlllllllllIl.func_179852_d().getY() - lllllllllllllllIIIlIIllllllllIIl.getY()) <= 1) {
                return lllllllllllllllIIIlIIlllllllllIl;
            }
        }
        for (final Village lllllllllllllllIIIlIIllllllllIll : this.villageList) {
            final VillageDoorInfo lllllllllllllllIIIlIIlllllllllII = lllllllllllllllIIIlIIllllllllIll.func_179864_e(lllllllllllllllIIIlIIllllllllIIl);
            if (lllllllllllllllIIIlIIlllllllllII != null) {
                return lllllllllllllllIIIlIIlllllllllII;
            }
        }
        return null;
    }
    
    public VillageCollection(final World lllllllllllllllIIIlIlIIIIllllIII) {
        super(func_176062_a(lllllllllllllllIIIlIlIIIIllllIII.provider));
        this.villagerPositionsList = Lists.newArrayList();
        this.newDoors = Lists.newArrayList();
        this.villageList = Lists.newArrayList();
        this.worldObj = lllllllllllllllIIIlIlIIIIllllIII;
        this.markDirty();
    }
    
    private boolean func_176058_f(final BlockPos lllllllllllllllIIIlIIllllIllllIl) {
        final Block lllllllllllllllIIIlIIllllIllllll = this.worldObj.getBlockState(lllllllllllllllIIIlIIllllIllllIl).getBlock();
        return lllllllllllllllIIIlIIllllIllllll instanceof BlockDoor && lllllllllllllllIIIlIIllllIllllll.getMaterial() == Material.wood;
    }
    
    private void addNewDoorsToVillageOrCreateVillage() {
        for (int lllllllllllllllIIIlIlIIIIIlIlIll = 0; lllllllllllllllIIIlIlIIIIIlIlIll < this.newDoors.size(); ++lllllllllllllllIIIlIlIIIIIlIlIll) {
            final VillageDoorInfo lllllllllllllllIIIlIlIIIIIlIlIlI = this.newDoors.get(lllllllllllllllIIIlIlIIIIIlIlIll);
            Village lllllllllllllllIIIlIlIIIIIlIlIIl = this.func_176056_a(lllllllllllllllIIIlIlIIIIIlIlIlI.func_179852_d(), 32);
            if (lllllllllllllllIIIlIlIIIIIlIlIIl == null) {
                lllllllllllllllIIIlIlIIIIIlIlIIl = new Village(this.worldObj);
                this.villageList.add(lllllllllllllllIIIlIlIIIIIlIlIIl);
                this.markDirty();
            }
            lllllllllllllllIIIlIlIIIIIlIlIIl.addVillageDoorInfo(lllllllllllllllIIIlIlIIIIIlIlIlI);
        }
        this.newDoors.clear();
    }
    
    private void func_180609_b(final BlockPos lllllllllllllllIIIlIlIIIIIIIllll) {
        final byte lllllllllllllllIIIlIlIIIIIIllIII = 16;
        final byte lllllllllllllllIIIlIlIIIIIIlIlll = 4;
        final byte lllllllllllllllIIIlIlIIIIIIlIllI = 16;
        for (int lllllllllllllllIIIlIlIIIIIIlIlIl = -lllllllllllllllIIIlIlIIIIIIllIII; lllllllllllllllIIIlIlIIIIIIlIlIl < lllllllllllllllIIIlIlIIIIIIllIII; ++lllllllllllllllIIIlIlIIIIIIlIlIl) {
            for (int lllllllllllllllIIIlIlIIIIIIlIlII = -lllllllllllllllIIIlIlIIIIIIlIlll; lllllllllllllllIIIlIlIIIIIIlIlII < lllllllllllllllIIIlIlIIIIIIlIlll; ++lllllllllllllllIIIlIlIIIIIIlIlII) {
                for (int lllllllllllllllIIIlIlIIIIIIlIIll = -lllllllllllllllIIIlIlIIIIIIlIllI; lllllllllllllllIIIlIlIIIIIIlIIll < lllllllllllllllIIIlIlIIIIIIlIllI; ++lllllllllllllllIIIlIlIIIIIIlIIll) {
                    final BlockPos lllllllllllllllIIIlIlIIIIIIlIIlI = lllllllllllllllIIIlIlIIIIIIIllll.add(lllllllllllllllIIIlIlIIIIIIlIlIl, lllllllllllllllIIIlIlIIIIIIlIlII, lllllllllllllllIIIlIlIIIIIIlIIll);
                    if (this.func_176058_f(lllllllllllllllIIIlIlIIIIIIlIIlI)) {
                        final VillageDoorInfo lllllllllllllllIIIlIlIIIIIIlIIIl = this.func_176055_c(lllllllllllllllIIIlIlIIIIIIlIIlI);
                        if (lllllllllllllllIIIlIlIIIIIIlIIIl == null) {
                            this.func_176059_d(lllllllllllllllIIIlIlIIIIIIlIIlI);
                        }
                        else {
                            lllllllllllllllIIIlIlIIIIIIlIIIl.func_179849_a(this.tickCounter);
                        }
                    }
                }
            }
        }
    }
    
    private void dropOldestVillagerPosition() {
        if (!this.villagerPositionsList.isEmpty()) {
            this.func_180609_b(this.villagerPositionsList.remove(0));
        }
    }
    
    public VillageCollection(final String lllllllllllllllIIIlIlIIIIllllllI) {
        super(lllllllllllllllIIIlIlIIIIllllllI);
        this.villagerPositionsList = Lists.newArrayList();
        this.newDoors = Lists.newArrayList();
        this.villageList = Lists.newArrayList();
    }
    
    public Village func_176056_a(final BlockPos lllllllllllllllIIIlIlIIIIIlllIll, final int lllllllllllllllIIIlIlIIIIlIIIIll) {
        Village lllllllllllllllIIIlIlIIIIlIIIIlI = null;
        double lllllllllllllllIIIlIlIIIIlIIIIIl = 3.4028234663852886E38;
        for (final Village lllllllllllllllIIIlIlIIIIIllllll : this.villageList) {
            final double lllllllllllllllIIIlIlIIIIIlllllI = lllllllllllllllIIIlIlIIIIIllllll.func_180608_a().distanceSq(lllllllllllllllIIIlIlIIIIIlllIll);
            if (lllllllllllllllIIIlIlIIIIIlllllI < lllllllllllllllIIIlIlIIIIlIIIIIl) {
                final float lllllllllllllllIIIlIlIIIIIllllIl = (float)(lllllllllllllllIIIlIlIIIIlIIIIll + lllllllllllllllIIIlIlIIIIIllllll.getVillageRadius());
                if (lllllllllllllllIIIlIlIIIIIlllllI > lllllllllllllllIIIlIlIIIIIllllIl * lllllllllllllllIIIlIlIIIIIllllIl) {
                    continue;
                }
                lllllllllllllllIIIlIlIIIIlIIIIlI = lllllllllllllllIIIlIlIIIIIllllll;
                lllllllllllllllIIIlIlIIIIlIIIIIl = lllllllllllllllIIIlIlIIIIIlllllI;
            }
        }
        return lllllllllllllllIIIlIlIIIIlIIIIlI;
    }
    
    private void removeAnnihilatedVillages() {
        final Iterator lllllllllllllllIIIlIlIIIIlIlIllI = this.villageList.iterator();
        while (lllllllllllllllIIIlIlIIIIlIlIllI.hasNext()) {
            final Village lllllllllllllllIIIlIlIIIIlIlIlIl = lllllllllllllllIIIlIlIIIIlIlIllI.next();
            if (lllllllllllllllIIIlIlIIIIlIlIlIl.isAnnihilated()) {
                lllllllllllllllIIIlIlIIIIlIlIllI.remove();
                this.markDirty();
            }
        }
    }
    
    private int func_176061_a(final BlockPos lllllllllllllllIIIlIIlllllIllIll, final EnumFacing lllllllllllllllIIIlIIlllllIlIlII, final int lllllllllllllllIIIlIIlllllIlIIll) {
        int lllllllllllllllIIIlIIlllllIllIII = 0;
        for (int lllllllllllllllIIIlIIlllllIlIlll = 1; lllllllllllllllIIIlIIlllllIlIlll <= 5; ++lllllllllllllllIIIlIIlllllIlIlll) {
            if (this.worldObj.isAgainstSky(lllllllllllllllIIIlIIlllllIllIll.offset(lllllllllllllllIIIlIIlllllIlIlII, lllllllllllllllIIIlIIlllllIlIlll)) && ++lllllllllllllllIIIlIIlllllIllIII >= lllllllllllllllIIIlIIlllllIlIIll) {
                return lllllllllllllllIIIlIIlllllIllIII;
            }
        }
        return lllllllllllllllIIIlIIlllllIllIII;
    }
    
    private boolean func_176057_e(final BlockPos lllllllllllllllIIIlIIlllllIIIlll) {
        for (final BlockPos lllllllllllllllIIIlIIlllllIIlIIl : this.villagerPositionsList) {
            if (lllllllllllllllIIIlIIlllllIIlIIl.equals(lllllllllllllllIIIlIIlllllIIIlll)) {
                return true;
            }
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00001635";
    }
    
    public static String func_176062_a(final WorldProvider lllllllllllllllIIIlIIllllIIlIlIl) {
        return String.valueOf(new StringBuilder("villages").append(lllllllllllllllIIIlIIllllIIlIlIl.getInternalNameSuffix()));
    }
    
    public void func_82566_a(final World lllllllllllllllIIIlIlIIIIllIllII) {
        this.worldObj = lllllllllllllllIIIlIlIIIIllIllII;
        for (final Village lllllllllllllllIIIlIlIIIIllIlllI : this.villageList) {
            lllllllllllllllIIIlIlIIIIllIlllI.func_82691_a(lllllllllllllllIIIlIlIIIIllIllII);
        }
    }
}
