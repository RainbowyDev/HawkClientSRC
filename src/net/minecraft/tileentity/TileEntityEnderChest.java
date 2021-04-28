package net.minecraft.tileentity;

import net.minecraft.server.gui.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;

public class TileEntityEnderChest extends TileEntity implements IUpdatePlayerListBox
{
    public /* synthetic */ int field_145973_j;
    public /* synthetic */ float field_145972_a;
    private /* synthetic */ int field_145974_k;
    public /* synthetic */ float prevLidAngle;
    
    public boolean func_145971_a(final EntityPlayer lIllIIlllIIlIII) {
        return this.worldObj.getTileEntity(this.pos) == this && lIllIIlllIIlIII.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public boolean receiveClientEvent(final int lIllIIlllIllIIl, final int lIllIIlllIlIlIl) {
        if (lIllIIlllIllIIl == 1) {
            this.field_145973_j = lIllIIlllIlIlIl;
            return true;
        }
        return super.receiveClientEvent(lIllIIlllIllIIl, lIllIIlllIlIlIl);
    }
    
    @Override
    public void update() {
        if (++this.field_145974_k % 20 * 4 == 0) {
            this.worldObj.addBlockEvent(this.pos, Blocks.ender_chest, 1, this.field_145973_j);
        }
        this.prevLidAngle = this.field_145972_a;
        final int lIllIIlllllIIII = this.pos.getX();
        final int lIllIIllllIllll = this.pos.getY();
        final int lIllIIllllIlllI = this.pos.getZ();
        final float lIllIIllllIllIl = 0.1f;
        if (this.field_145973_j > 0 && this.field_145972_a == 0.0f) {
            final double lIllIIllllIlIlI = lIllIIlllllIIII + 0.5;
            final double lIllIIllllIllII = lIllIIllllIlllI + 0.5;
            this.worldObj.playSoundEffect(lIllIIllllIlIlI, lIllIIllllIllll + 0.5, lIllIIllllIllII, "random.chestopen", 0.5f, this.worldObj.rand.nextFloat() * 0.1f + 0.9f);
        }
        if ((this.field_145973_j == 0 && this.field_145972_a > 0.0f) || (this.field_145973_j > 0 && this.field_145972_a < 1.0f)) {
            final float lIllIIllllIlIIl = this.field_145972_a;
            if (this.field_145973_j > 0) {
                this.field_145972_a += lIllIIllllIllIl;
            }
            else {
                this.field_145972_a -= lIllIIllllIllIl;
            }
            if (this.field_145972_a > 1.0f) {
                this.field_145972_a = 1.0f;
            }
            final float lIllIIllllIlIII = 0.5f;
            if (this.field_145972_a < lIllIIllllIlIII && lIllIIllllIlIIl >= lIllIIllllIlIII) {
                final double lIllIIllllIlIll = lIllIIlllllIIII + 0.5;
                final double lIllIIllllIIlll = lIllIIllllIlllI + 0.5;
                this.worldObj.playSoundEffect(lIllIIllllIlIll, lIllIIllllIllll + 0.5, lIllIIllllIIlll, "random.chestclosed", 0.5f, this.worldObj.rand.nextFloat() * 0.1f + 0.9f);
            }
            if (this.field_145972_a < 0.0f) {
                this.field_145972_a = 0.0f;
            }
        }
    }
    
    static {
        __OBFID = "CL_00000355";
    }
    
    @Override
    public void invalidate() {
        this.updateContainingBlockInfo();
        super.invalidate();
    }
    
    public void func_145970_b() {
        --this.field_145973_j;
        this.worldObj.addBlockEvent(this.pos, Blocks.ender_chest, 1, this.field_145973_j);
    }
    
    public void func_145969_a() {
        ++this.field_145973_j;
        this.worldObj.addBlockEvent(this.pos, Blocks.ender_chest, 1, this.field_145973_j);
    }
}
