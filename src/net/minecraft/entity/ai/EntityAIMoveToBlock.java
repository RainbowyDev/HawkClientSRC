package net.minecraft.entity.ai;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public abstract class EntityAIMoveToBlock extends EntityAIBase
{
    private /* synthetic */ int field_179490_f;
    protected /* synthetic */ int field_179496_a;
    private final /* synthetic */ EntityCreature field_179495_c;
    private /* synthetic */ int field_179497_h;
    private final /* synthetic */ double field_179492_d;
    private /* synthetic */ boolean field_179491_g;
    private /* synthetic */ int field_179493_e;
    protected /* synthetic */ BlockPos field_179494_b;
    
    @Override
    public void updateTask() {
        if (this.field_179495_c.func_174831_c(this.field_179494_b.offsetUp()) > 1.0) {
            this.field_179491_g = false;
            ++this.field_179493_e;
            if (this.field_179493_e % 40 == 0) {
                this.field_179495_c.getNavigator().tryMoveToXYZ((float)this.field_179494_b.getX() + 0.5, this.field_179494_b.getY() + 1, (float)this.field_179494_b.getZ() + 0.5, this.field_179492_d);
            }
        }
        else {
            this.field_179491_g = true;
            --this.field_179493_e;
        }
    }
    
    protected abstract boolean func_179488_a(final World p0, final BlockPos p1);
    
    protected boolean func_179487_f() {
        return this.field_179491_g;
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.field_179496_a > 0) {
            --this.field_179496_a;
            return false;
        }
        this.field_179496_a = 200 + this.field_179495_c.getRNG().nextInt(200);
        return this.func_179489_g();
    }
    
    private boolean func_179489_g() {
        final int llllllllllllllIlIIlllllIlIlIlIll = this.field_179497_h;
        final boolean llllllllllllllIlIIlllllIlIlIlIlI = true;
        final BlockPos llllllllllllllIlIIlllllIlIlIlIIl = new BlockPos(this.field_179495_c);
        for (int llllllllllllllIlIIlllllIlIlIlIII = 0; llllllllllllllIlIIlllllIlIlIlIII <= 1; llllllllllllllIlIIlllllIlIlIlIII = ((llllllllllllllIlIIlllllIlIlIlIII > 0) ? (-llllllllllllllIlIIlllllIlIlIlIII) : (1 - llllllllllllllIlIIlllllIlIlIlIII))) {
            for (int llllllllllllllIlIIlllllIlIlIIlll = 0; llllllllllllllIlIIlllllIlIlIIlll < llllllllllllllIlIIlllllIlIlIlIll; ++llllllllllllllIlIIlllllIlIlIIlll) {
                for (int llllllllllllllIlIIlllllIlIlIIllI = 0; llllllllllllllIlIIlllllIlIlIIllI <= llllllllllllllIlIIlllllIlIlIIlll; llllllllllllllIlIIlllllIlIlIIllI = ((llllllllllllllIlIIlllllIlIlIIllI > 0) ? (-llllllllllllllIlIIlllllIlIlIIllI) : (1 - llllllllllllllIlIIlllllIlIlIIllI))) {
                    for (int llllllllllllllIlIIlllllIlIlIIlIl = (llllllllllllllIlIIlllllIlIlIIllI < llllllllllllllIlIIlllllIlIlIIlll && llllllllllllllIlIIlllllIlIlIIllI > -llllllllllllllIlIIlllllIlIlIIlll) ? llllllllllllllIlIIlllllIlIlIIlll : 0; llllllllllllllIlIIlllllIlIlIIlIl <= llllllllllllllIlIIlllllIlIlIIlll; llllllllllllllIlIIlllllIlIlIIlIl = ((llllllllllllllIlIIlllllIlIlIIlIl > 0) ? (-llllllllllllllIlIIlllllIlIlIIlIl) : (1 - llllllllllllllIlIIlllllIlIlIIlIl))) {
                        final BlockPos llllllllllllllIlIIlllllIlIlIIlII = llllllllllllllIlIIlllllIlIlIlIIl.add(llllllllllllllIlIIlllllIlIlIIllI, llllllllllllllIlIIlllllIlIlIlIII - 1, llllllllllllllIlIIlllllIlIlIIlIl);
                        if (this.field_179495_c.func_180485_d(llllllllllllllIlIIlllllIlIlIIlII) && this.func_179488_a(this.field_179495_c.worldObj, llllllllllllllIlIIlllllIlIlIIlII)) {
                            this.field_179494_b = llllllllllllllIlIIlllllIlIlIIlII;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.field_179493_e >= -this.field_179490_f && this.field_179493_e <= 1200 && this.func_179488_a(this.field_179495_c.worldObj, this.field_179494_b);
    }
    
    public EntityAIMoveToBlock(final EntityCreature llllllllllllllIlIIlllllIllIIlIII, final double llllllllllllllIlIIlllllIllIIlIll, final int llllllllllllllIlIIlllllIllIIlIlI) {
        this.field_179494_b = BlockPos.ORIGIN;
        this.field_179495_c = llllllllllllllIlIIlllllIllIIlIII;
        this.field_179492_d = llllllllllllllIlIIlllllIllIIlIll;
        this.field_179497_h = llllllllllllllIlIIlllllIllIIlIlI;
        this.setMutexBits(5);
    }
    
    @Override
    public void startExecuting() {
        this.field_179495_c.getNavigator().tryMoveToXYZ((float)this.field_179494_b.getX() + 0.5, this.field_179494_b.getY() + 1, (float)this.field_179494_b.getZ() + 0.5, this.field_179492_d);
        this.field_179493_e = 0;
        this.field_179490_f = this.field_179495_c.getRNG().nextInt(this.field_179495_c.getRNG().nextInt(1200) + 1200) + 1200;
    }
    
    @Override
    public void resetTask() {
    }
    
    static {
        __OBFID = "CL_00002252";
    }
}
