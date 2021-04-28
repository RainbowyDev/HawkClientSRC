package net.minecraft.village;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class VillageSiege
{
    private /* synthetic */ boolean field_75535_b;
    private /* synthetic */ int field_75532_g;
    private /* synthetic */ int field_75536_c;
    private /* synthetic */ Village theVillage;
    private /* synthetic */ int field_75533_d;
    private /* synthetic */ int field_75534_e;
    private /* synthetic */ World worldObj;
    private /* synthetic */ int field_75539_i;
    private /* synthetic */ int field_75538_h;
    
    private Vec3 func_179867_a(final BlockPos llllllllllllllIllIIlIIIIlIIIlIII) {
        for (int llllllllllllllIllIIlIIIIlIIIIlll = 0; llllllllllllllIllIIlIIIIlIIIIlll < 10; ++llllllllllllllIllIIlIIIIlIIIIlll) {
            final BlockPos llllllllllllllIllIIlIIIIlIIIIllI = llllllllllllllIllIIlIIIIlIIIlIII.add(this.worldObj.rand.nextInt(16) - 8, this.worldObj.rand.nextInt(6) - 3, this.worldObj.rand.nextInt(16) - 8);
            if (this.theVillage.func_179866_a(llllllllllllllIllIIlIIIIlIIIIllI) && SpawnerAnimals.func_180267_a(EntityLiving.SpawnPlacementType.ON_GROUND, this.worldObj, llllllllllllllIllIIlIIIIlIIIIllI)) {
                return new Vec3(llllllllllllllIllIIlIIIIlIIIIllI.getX(), llllllllllllllIllIIlIIIIlIIIIllI.getY(), llllllllllllllIllIIlIIIIlIIIIllI.getZ());
            }
        }
        return null;
    }
    
    private boolean func_75529_b() {
        final List llllllllllllllIllIIlIIIIlIllIIIl = this.worldObj.playerEntities;
        for (final EntityPlayer llllllllllllllIllIIlIIIIlIlIllll : llllllllllllllIllIIlIIIIlIllIIIl) {
            if (!llllllllllllllIllIIlIIIIlIlIllll.func_175149_v()) {
                this.theVillage = this.worldObj.getVillageCollection().func_176056_a(new BlockPos(llllllllllllllIllIIlIIIIlIlIllll), 1);
                if (this.theVillage == null || this.theVillage.getNumVillageDoors() < 10 || this.theVillage.getTicksSinceLastDoorAdding() < 20 || this.theVillage.getNumVillagers() < 20) {
                    continue;
                }
                final BlockPos llllllllllllllIllIIlIIIIlIlIlllI = this.theVillage.func_180608_a();
                final float llllllllllllllIllIIlIIIIlIlIllIl = (float)this.theVillage.getVillageRadius();
                boolean llllllllllllllIllIIlIIIIlIlIllII = false;
                for (int llllllllllllllIllIIlIIIIlIlIlIll = 0; llllllllllllllIllIIlIIIIlIlIlIll < 10; ++llllllllllllllIllIIlIIIIlIlIlIll) {
                    final float llllllllllllllIllIIlIIIIlIlIlIlI = this.worldObj.rand.nextFloat() * 3.1415927f * 2.0f;
                    this.field_75532_g = llllllllllllllIllIIlIIIIlIlIlllI.getX() + (int)(MathHelper.cos(llllllllllllllIllIIlIIIIlIlIlIlI) * llllllllllllllIllIIlIIIIlIlIllIl * 0.9);
                    this.field_75538_h = llllllllllllllIllIIlIIIIlIlIlllI.getY();
                    this.field_75539_i = llllllllllllllIllIIlIIIIlIlIlllI.getZ() + (int)(MathHelper.sin(llllllllllllllIllIIlIIIIlIlIlIlI) * llllllllllllllIllIIlIIIIlIlIllIl * 0.9);
                    llllllllllllllIllIIlIIIIlIlIllII = false;
                    for (final Village llllllllllllllIllIIlIIIIlIlIlIII : this.worldObj.getVillageCollection().getVillageList()) {
                        if (llllllllllllllIllIIlIIIIlIlIlIII != this.theVillage && llllllllllllllIllIIlIIIIlIlIlIII.func_179866_a(new BlockPos(this.field_75532_g, this.field_75538_h, this.field_75539_i))) {
                            llllllllllllllIllIIlIIIIlIlIllII = true;
                            break;
                        }
                    }
                    if (!llllllllllllllIllIIlIIIIlIlIllII) {
                        break;
                    }
                }
                if (llllllllllllllIllIIlIIIIlIlIllII) {
                    return false;
                }
                final Vec3 llllllllllllllIllIIlIIIIlIlIIlll = this.func_179867_a(new BlockPos(this.field_75532_g, this.field_75538_h, this.field_75539_i));
                if (llllllllllllllIllIIlIIIIlIlIIlll != null) {
                    this.field_75534_e = 0;
                    this.field_75533_d = 20;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public void tick() {
        if (this.worldObj.isDaytime()) {
            this.field_75536_c = 0;
        }
        else if (this.field_75536_c != 2) {
            if (this.field_75536_c == 0) {
                final float llllllllllllllIllIIlIIIIllIIIIII = this.worldObj.getCelestialAngle(0.0f);
                if (llllllllllllllIllIIlIIIIllIIIIII < 0.5 || llllllllllllllIllIIlIIIIllIIIIII > 0.501) {
                    return;
                }
                this.field_75536_c = ((this.worldObj.rand.nextInt(10) == 0) ? 1 : 2);
                this.field_75535_b = false;
                if (this.field_75536_c == 2) {
                    return;
                }
            }
            if (this.field_75536_c != -1) {
                if (!this.field_75535_b) {
                    if (!this.func_75529_b()) {
                        return;
                    }
                    this.field_75535_b = true;
                }
                if (this.field_75534_e > 0) {
                    --this.field_75534_e;
                }
                else {
                    this.field_75534_e = 2;
                    if (this.field_75533_d > 0) {
                        this.spawnZombie();
                        --this.field_75533_d;
                    }
                    else {
                        this.field_75536_c = 2;
                    }
                }
            }
        }
    }
    
    private boolean spawnZombie() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: new             Lnet/minecraft/util/BlockPos;
        //     4: dup            
        //     5: aload_0         /* llllllllllllllIllIIlIIIIlIIlIlll */
        //     6: getfield        net/minecraft/village/VillageSiege.field_75532_g:I
        //     9: aload_0         /* llllllllllllllIllIIlIIIIlIIlIlll */
        //    10: getfield        net/minecraft/village/VillageSiege.field_75538_h:I
        //    13: aload_0         /* llllllllllllllIllIIlIIIIlIIlIlll */
        //    14: getfield        net/minecraft/village/VillageSiege.field_75539_i:I
        //    17: invokespecial   net/minecraft/util/BlockPos.<init>:(III)V
        //    20: invokespecial   net/minecraft/village/VillageSiege.func_179867_a:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/Vec3;
        //    23: astore_1        /* llllllllllllllIllIIlIIIIlIIlIIII */
        //    24: aload_1         /* llllllllllllllIllIIlIIIIlIIlIllI */
        //    25: ifnonnull       30
        //    28: iconst_0       
        //    29: ireturn        
        //    30: new             Lnet/minecraft/entity/monster/EntityZombie;
        //    33: dup            
        //    34: aload_0         /* llllllllllllllIllIIlIIIIlIIlIlll */
        //    35: getfield        net/minecraft/village/VillageSiege.worldObj:Lnet/minecraft/world/World;
        //    38: invokespecial   net/minecraft/entity/monster/EntityZombie.<init>:(Lnet/minecraft/world/World;)V
        //    41: astore_2        /* llllllllllllllIllIIlIIIIlIIlIlIl */
        //    42: aload_2         /* llllllllllllllIllIIlIIIIlIIlIlIl */
        //    43: aload_0         /* llllllllllllllIllIIlIIIIlIIlIlll */
        //    44: getfield        net/minecraft/village/VillageSiege.worldObj:Lnet/minecraft/world/World;
        //    47: new             Lnet/minecraft/util/BlockPos;
        //    50: dup            
        //    51: aload_2         /* llllllllllllllIllIIlIIIIlIIlIlIl */
        //    52: invokespecial   net/minecraft/util/BlockPos.<init>:(Lnet/minecraft/entity/Entity;)V
        //    55: invokevirtual   net/minecraft/world/World.getDifficultyForLocation:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/world/DifficultyInstance;
        //    58: aconst_null    
        //    59: invokevirtual   net/minecraft/entity/monster/EntityZombie.func_180482_a:(Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/entity/IEntityLivingData;)Lnet/minecraft/entity/IEntityLivingData;
        //    62: pop            
        //    63: aload_2         /* llllllllllllllIllIIlIIIIlIIlIlIl */
        //    64: iconst_0       
        //    65: invokevirtual   net/minecraft/entity/monster/EntityZombie.setVillager:(Z)V
        //    68: goto            78
        //    71: astore_3        /* llllllllllllllIllIIlIIIIlIIlIIll */
        //    72: aload_3         /* llllllllllllllIllIIlIIIIlIIlIIll */
        //    73: invokevirtual   java/lang/Exception.printStackTrace:()V
        //    76: iconst_0       
        //    77: ireturn        
        //    78: aload_2         /* llllllllllllllIllIIlIIIIlIIlIlII */
        //    79: aload_1         /* llllllllllllllIllIIlIIIIlIIlIllI */
        //    80: getfield        net/minecraft/util/Vec3.xCoord:D
        //    83: aload_1         /* llllllllllllllIllIIlIIIIlIIlIllI */
        //    84: getfield        net/minecraft/util/Vec3.yCoord:D
        //    87: aload_1         /* llllllllllllllIllIIlIIIIlIIlIllI */
        //    88: getfield        net/minecraft/util/Vec3.zCoord:D
        //    91: aload_0         /* llllllllllllllIllIIlIIIIlIIlIlll */
        //    92: getfield        net/minecraft/village/VillageSiege.worldObj:Lnet/minecraft/world/World;
        //    95: getfield        net/minecraft/world/World.rand:Ljava/util/Random;
        //    98: invokevirtual   java/util/Random.nextFloat:()F
        //   101: ldc_w           360.0
        //   104: fmul           
        //   105: fconst_0       
        //   106: invokevirtual   net/minecraft/entity/monster/EntityZombie.setLocationAndAngles:(DDDFF)V
        //   109: aload_0         /* llllllllllllllIllIIlIIIIlIIlIlll */
        //   110: getfield        net/minecraft/village/VillageSiege.worldObj:Lnet/minecraft/world/World;
        //   113: aload_2         /* llllllllllllllIllIIlIIIIlIIlIlII */
        //   114: invokevirtual   net/minecraft/world/World.spawnEntityInWorld:(Lnet/minecraft/entity/Entity;)Z
        //   117: pop            
        //   118: aload_0         /* llllllllllllllIllIIlIIIIlIIlIlll */
        //   119: getfield        net/minecraft/village/VillageSiege.theVillage:Lnet/minecraft/village/Village;
        //   122: invokevirtual   net/minecraft/village/Village.func_180608_a:()Lnet/minecraft/util/BlockPos;
        //   125: astore_3        /* llllllllllllllIllIIlIIIIlIIlIIlI */
        //   126: aload_2         /* llllllllllllllIllIIlIIIIlIIlIlII */
        //   127: aload_3         /* llllllllllllllIllIIlIIIIlIIlIIlI */
        //   128: aload_0         /* llllllllllllllIllIIlIIIIlIIlIlll */
        //   129: getfield        net/minecraft/village/VillageSiege.theVillage:Lnet/minecraft/village/Village;
        //   132: invokevirtual   net/minecraft/village/Village.getVillageRadius:()I
        //   135: invokevirtual   net/minecraft/entity/monster/EntityZombie.func_175449_a:(Lnet/minecraft/util/BlockPos;I)V
        //   138: iconst_1       
        //   139: ireturn        
        //    StackMapTable: 00 03 FC 00 1E 07 00 42 68 07 00 EF FC 00 06 07 00 F1
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  30     68     71     78     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        __OBFID = "CL_00001634";
    }
    
    public VillageSiege(final World llllllllllllllIllIIlIIIIllIIIlII) {
        this.field_75536_c = -1;
        this.worldObj = llllllllllllllIllIIlIIIIllIIIlII;
    }
}
