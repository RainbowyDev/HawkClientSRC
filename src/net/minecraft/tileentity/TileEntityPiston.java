package net.minecraft.tileentity;

import net.minecraft.server.gui.*;
import net.minecraft.block.state.*;
import net.minecraft.nbt.*;
import net.minecraft.block.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class TileEntityPiston extends TileEntity implements IUpdatePlayerListBox
{
    private /* synthetic */ List field_174933_k;
    private /* synthetic */ boolean extending;
    private /* synthetic */ float progress;
    private /* synthetic */ EnumFacing field_174931_f;
    private /* synthetic */ float lastProgress;
    private /* synthetic */ IBlockState field_174932_a;
    private /* synthetic */ boolean shouldHeadBeRendered;
    
    public boolean shouldPistonHeadBeRendered() {
        return this.shouldHeadBeRendered;
    }
    
    public float func_145860_a(float lllllllllllllllIIlIlIllIlIIlllII) {
        if (lllllllllllllllIIlIlIllIlIIlllII > 1.0f) {
            lllllllllllllllIIlIlIllIlIIlllII = 1.0f;
        }
        return this.lastProgress + (this.progress - this.lastProgress) * lllllllllllllllIIlIlIllIlIIlllII;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllIIlIlIllIIllIlIIl) {
        super.readFromNBT(lllllllllllllllIIlIlIllIIllIlIIl);
        this.field_174932_a = Block.getBlockById(lllllllllllllllIIlIlIllIIllIlIIl.getInteger("blockId")).getStateFromMeta(lllllllllllllllIIlIlIllIIllIlIIl.getInteger("blockData"));
        this.field_174931_f = EnumFacing.getFront(lllllllllllllllIIlIlIllIIllIlIIl.getInteger("facing"));
        final float float1 = lllllllllllllllIIlIlIllIIllIlIIl.getFloat("progress");
        this.progress = float1;
        this.lastProgress = float1;
        this.extending = lllllllllllllllIIlIlIllIIllIlIIl.getBoolean("extending");
    }
    
    public boolean isExtending() {
        return this.extending;
    }
    
    public IBlockState func_174927_b() {
        return this.field_174932_a;
    }
    
    public float func_174926_d(final float lllllllllllllllIIlIlIllIlIIIlIlI) {
        return this.extending ? ((this.func_145860_a(lllllllllllllllIIlIlIllIlIIIlIlI) - 1.0f) * this.field_174931_f.getFrontOffsetZ()) : ((1.0f - this.func_145860_a(lllllllllllllllIIlIlIllIlIIIlIlI)) * this.field_174931_f.getFrontOffsetZ());
    }
    
    public TileEntityPiston(final IBlockState lllllllllllllllIIlIlIllIlIllIIlI, final EnumFacing lllllllllllllllIIlIlIllIlIllIllI, final boolean lllllllllllllllIIlIlIllIlIllIlIl, final boolean lllllllllllllllIIlIlIllIlIlIllll) {
        this.field_174933_k = Lists.newArrayList();
        this.field_174932_a = lllllllllllllllIIlIlIllIlIllIIlI;
        this.field_174931_f = lllllllllllllllIIlIlIllIlIllIllI;
        this.extending = lllllllllllllllIIlIlIllIlIllIlIl;
        this.shouldHeadBeRendered = lllllllllllllllIIlIlIllIlIlIllll;
    }
    
    public EnumFacing func_174930_e() {
        return this.field_174931_f;
    }
    
    @Override
    public void update() {
        this.lastProgress = this.progress;
        if (this.lastProgress >= 1.0f) {
            this.func_145863_a(1.0f, 0.25f);
            this.worldObj.removeTileEntity(this.pos);
            this.invalidate();
            if (this.worldObj.getBlockState(this.pos).getBlock() == Blocks.piston_extension) {
                this.worldObj.setBlockState(this.pos, this.field_174932_a, 3);
                this.worldObj.notifyBlockOfStateChange(this.pos, this.field_174932_a.getBlock());
            }
        }
        else {
            this.progress += 0.5f;
            if (this.progress >= 1.0f) {
                this.progress = 1.0f;
            }
            if (this.extending) {
                this.func_145863_a(this.progress, this.progress - this.lastProgress + 0.0625f);
            }
        }
    }
    
    public TileEntityPiston() {
        this.field_174933_k = Lists.newArrayList();
    }
    
    public float func_174929_b(final float lllllllllllllllIIlIlIllIlIIllIII) {
        return this.extending ? ((this.func_145860_a(lllllllllllllllIIlIlIllIlIIllIII) - 1.0f) * this.field_174931_f.getFrontOffsetX()) : ((1.0f - this.func_145860_a(lllllllllllllllIIlIlIllIlIIllIII)) * this.field_174931_f.getFrontOffsetX());
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound lllllllllllllllIIlIlIllIIllIIlIl) {
        super.writeToNBT(lllllllllllllllIIlIlIllIIllIIlIl);
        lllllllllllllllIIlIlIllIIllIIlIl.setInteger("blockId", Block.getIdFromBlock(this.field_174932_a.getBlock()));
        lllllllllllllllIIlIlIllIIllIIlIl.setInteger("blockData", this.field_174932_a.getBlock().getMetaFromState(this.field_174932_a));
        lllllllllllllllIIlIlIllIIllIIlIl.setInteger("facing", this.field_174931_f.getIndex());
        lllllllllllllllIIlIlIllIIllIIlIl.setFloat("progress", this.lastProgress);
        lllllllllllllllIIlIlIllIIllIIlIl.setBoolean("extending", this.extending);
    }
    
    @Override
    public int getBlockMetadata() {
        return 0;
    }
    
    public void clearPistonTileEntity() {
        if (this.lastProgress < 1.0f && this.worldObj != null) {
            final float n = 1.0f;
            this.progress = n;
            this.lastProgress = n;
            this.worldObj.removeTileEntity(this.pos);
            this.invalidate();
            if (this.worldObj.getBlockState(this.pos).getBlock() == Blocks.piston_extension) {
                this.worldObj.setBlockState(this.pos, this.field_174932_a, 3);
                this.worldObj.notifyBlockOfStateChange(this.pos, this.field_174932_a.getBlock());
            }
        }
    }
    
    public float func_174928_c(final float lllllllllllllllIIlIlIllIlIIlIIII) {
        return this.extending ? ((this.func_145860_a(lllllllllllllllIIlIlIllIlIIlIIII) - 1.0f) * this.field_174931_f.getFrontOffsetY()) : ((1.0f - this.func_145860_a(lllllllllllllllIIlIlIllIlIIlIIII)) * this.field_174931_f.getFrontOffsetY());
    }
    
    private void func_145863_a(float lllllllllllllllIIlIlIllIIllllIlI, final float lllllllllllllllIIlIlIllIIllllIIl) {
        if (this.extending) {
            lllllllllllllllIIlIlIllIIllllIlI = 1.0f - lllllllllllllllIIlIlIllIIllllIlI;
        }
        else {
            --lllllllllllllllIIlIlIllIIllllIlI;
        }
        final AxisAlignedBB lllllllllllllllIIlIlIllIIlllllll = Blocks.piston_extension.func_176424_a(this.worldObj, this.pos, this.field_174932_a, (float)lllllllllllllllIIlIlIllIIllllIlI, this.field_174931_f);
        if (lllllllllllllllIIlIlIllIIlllllll != null) {
            final List lllllllllllllllIIlIlIllIIllllllI = this.worldObj.getEntitiesWithinAABBExcludingEntity(null, lllllllllllllllIIlIlIllIIlllllll);
            if (!lllllllllllllllIIlIlIllIIllllllI.isEmpty()) {
                this.field_174933_k.addAll(lllllllllllllllIIlIlIllIIllllllI);
                for (final Entity lllllllllllllllIIlIlIllIIlllllII : this.field_174933_k) {
                    if (this.field_174932_a.getBlock() == Blocks.slime_block && this.extending) {
                        switch (SwitchAxis.field_177248_a[this.field_174931_f.getAxis().ordinal()]) {
                            case 1: {
                                lllllllllllllllIIlIlIllIIlllllII.motionX = this.field_174931_f.getFrontOffsetX();
                                continue;
                            }
                            case 2: {
                                lllllllllllllllIIlIlIllIIlllllII.motionY = this.field_174931_f.getFrontOffsetY();
                                continue;
                            }
                            case 3: {
                                lllllllllllllllIIlIlIllIIlllllII.motionZ = this.field_174931_f.getFrontOffsetZ();
                                continue;
                            }
                        }
                    }
                    else {
                        lllllllllllllllIIlIlIllIIlllllII.moveEntity(lllllllllllllllIIlIlIllIIllllIIl * this.field_174931_f.getFrontOffsetX(), lllllllllllllllIIlIlIllIIllllIIl * this.field_174931_f.getFrontOffsetY(), lllllllllllllllIIlIlIllIIllllIIl * this.field_174931_f.getFrontOffsetZ());
                    }
                }
                this.field_174933_k.clear();
            }
        }
    }
    
    static {
        __OBFID = "CL_00000369";
    }
    
    static final class SwitchAxis
    {
        static final /* synthetic */ int[] field_177248_a;
        
        static {
            __OBFID = "CL_00002034";
            field_177248_a = new int[EnumFacing.Axis.values().length];
            try {
                SwitchAxis.field_177248_a[EnumFacing.Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchAxis.field_177248_a[EnumFacing.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchAxis.field_177248_a[EnumFacing.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
        }
    }
}
