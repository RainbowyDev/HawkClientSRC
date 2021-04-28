package net.minecraft.block.state;

import net.minecraft.world.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import java.util.*;

public class BlockPistonStructureHelper
{
    private final /* synthetic */ List field_177258_e;
    private final /* synthetic */ World field_177261_a;
    private final /* synthetic */ BlockPos field_177259_b;
    private final /* synthetic */ BlockPos field_177260_c;
    private final /* synthetic */ List field_177256_f;
    private final /* synthetic */ EnumFacing field_177257_d;
    
    public List func_177252_d() {
        return this.field_177256_f;
    }
    
    public BlockPistonStructureHelper(final World llllllllllllllIIllllllIIIIIlIIll, final BlockPos llllllllllllllIIllllllIIIIIlIIlI, final EnumFacing llllllllllllllIIllllllIIIIIlIllI, final boolean llllllllllllllIIllllllIIIIIlIlIl) {
        this.field_177258_e = Lists.newArrayList();
        this.field_177256_f = Lists.newArrayList();
        this.field_177261_a = llllllllllllllIIllllllIIIIIlIIll;
        this.field_177259_b = llllllllllllllIIllllllIIIIIlIIlI;
        if (llllllllllllllIIllllllIIIIIlIlIl) {
            this.field_177257_d = llllllllllllllIIllllllIIIIIlIllI;
            this.field_177260_c = llllllllllllllIIllllllIIIIIlIIlI.offset(llllllllllllllIIllllllIIIIIlIllI);
        }
        else {
            this.field_177257_d = llllllllllllllIIllllllIIIIIlIllI.getOpposite();
            this.field_177260_c = llllllllllllllIIllllllIIIIIlIIlI.offset(llllllllllllllIIllllllIIIIIlIllI, 2);
        }
    }
    
    private boolean func_177251_a(final BlockPos llllllllllllllIIlllllIlllllIllIl) {
        Block llllllllllllllIIlllllIllllllIlll = this.field_177261_a.getBlockState(llllllllllllllIIlllllIlllllIllIl).getBlock();
        if (llllllllllllllIIlllllIllllllIlll.getMaterial() == Material.air) {
            return true;
        }
        if (!BlockPistonBase.func_180696_a(llllllllllllllIIlllllIllllllIlll, this.field_177261_a, llllllllllllllIIlllllIlllllIllIl, this.field_177257_d, false)) {
            return true;
        }
        if (llllllllllllllIIlllllIlllllIllIl.equals(this.field_177259_b)) {
            return true;
        }
        if (this.field_177258_e.contains(llllllllllllllIIlllllIlllllIllIl)) {
            return true;
        }
        int llllllllllllllIIlllllIllllllIllI = 1;
        if (llllllllllllllIIlllllIllllllIllI + this.field_177258_e.size() > 12) {
            return false;
        }
        while (llllllllllllllIIlllllIllllllIlll == Blocks.slime_block) {
            final BlockPos llllllllllllllIIlllllIllllllIlIl = llllllllllllllIIlllllIlllllIllIl.offset(this.field_177257_d.getOpposite(), llllllllllllllIIlllllIllllllIllI);
            llllllllllllllIIlllllIllllllIlll = this.field_177261_a.getBlockState(llllllllllllllIIlllllIllllllIlIl).getBlock();
            if (llllllllllllllIIlllllIllllllIlll.getMaterial() == Material.air || !BlockPistonBase.func_180696_a(llllllllllllllIIlllllIllllllIlll, this.field_177261_a, llllllllllllllIIlllllIllllllIlIl, this.field_177257_d, false)) {
                break;
            }
            if (llllllllllllllIIlllllIllllllIlIl.equals(this.field_177259_b)) {
                break;
            }
            if (++llllllllllllllIIlllllIllllllIllI + this.field_177258_e.size() > 12) {
                return false;
            }
        }
        int llllllllllllllIIlllllIllllllIlII = 0;
        for (int llllllllllllllIIlllllIllllllIIll = llllllllllllllIIlllllIllllllIllI - 1; llllllllllllllIIlllllIllllllIIll >= 0; --llllllllllllllIIlllllIllllllIIll) {
            this.field_177258_e.add(llllllllllllllIIlllllIlllllIllIl.offset(this.field_177257_d.getOpposite(), llllllllllllllIIlllllIllllllIIll));
            ++llllllllllllllIIlllllIllllllIlII;
        }
        int llllllllllllllIIlllllIllllllIIll = 1;
        while (true) {
            final BlockPos llllllllllllllIIlllllIllllllIIlI = llllllllllllllIIlllllIlllllIllIl.offset(this.field_177257_d, llllllllllllllIIlllllIllllllIIll);
            final int llllllllllllllIIlllllIllllllIIIl = this.field_177258_e.indexOf(llllllllllllllIIlllllIllllllIIlI);
            if (llllllllllllllIIlllllIllllllIIIl > -1) {
                this.func_177255_a(llllllllllllllIIlllllIllllllIlII, llllllllllllllIIlllllIllllllIIIl);
                for (int llllllllllllllIIlllllIllllllIIII = 0; llllllllllllllIIlllllIllllllIIII <= llllllllllllllIIlllllIllllllIIIl + llllllllllllllIIlllllIllllllIlII; ++llllllllllllllIIlllllIllllllIIII) {
                    final BlockPos llllllllllllllIIlllllIlllllIllll = this.field_177258_e.get(llllllllllllllIIlllllIllllllIIII);
                    if (this.field_177261_a.getBlockState(llllllllllllllIIlllllIlllllIllll).getBlock() == Blocks.slime_block && !this.func_177250_b(llllllllllllllIIlllllIlllllIllll)) {
                        return false;
                    }
                }
                return true;
            }
            llllllllllllllIIlllllIllllllIlll = this.field_177261_a.getBlockState(llllllllllllllIIlllllIllllllIIlI).getBlock();
            if (llllllllllllllIIlllllIllllllIlll.getMaterial() == Material.air) {
                return true;
            }
            if (!BlockPistonBase.func_180696_a(llllllllllllllIIlllllIllllllIlll, this.field_177261_a, llllllllllllllIIlllllIllllllIIlI, this.field_177257_d, true) || llllllllllllllIIlllllIllllllIIlI.equals(this.field_177259_b)) {
                return false;
            }
            if (llllllllllllllIIlllllIllllllIlll.getMobilityFlag() == 1) {
                this.field_177256_f.add(llllllllllllllIIlllllIllllllIIlI);
                return true;
            }
            if (this.field_177258_e.size() >= 12) {
                return false;
            }
            this.field_177258_e.add(llllllllllllllIIlllllIllllllIIlI);
            ++llllllllllllllIIlllllIllllllIlII;
            ++llllllllllllllIIlllllIllllllIIll;
        }
    }
    
    static {
        __OBFID = "CL_00002033";
    }
    
    public boolean func_177253_a() {
        this.field_177258_e.clear();
        this.field_177256_f.clear();
        final Block llllllllllllllIIllllllIIIIIIlIlI = this.field_177261_a.getBlockState(this.field_177260_c).getBlock();
        if (!BlockPistonBase.func_180696_a(llllllllllllllIIllllllIIIIIIlIlI, this.field_177261_a, this.field_177260_c, this.field_177257_d, false)) {
            if (llllllllllllllIIllllllIIIIIIlIlI.getMobilityFlag() != 1) {
                return false;
            }
            this.field_177256_f.add(this.field_177260_c);
            return true;
        }
        else {
            if (!this.func_177251_a(this.field_177260_c)) {
                return false;
            }
            for (int llllllllllllllIIllllllIIIIIIlIIl = 0; llllllllllllllIIllllllIIIIIIlIIl < this.field_177258_e.size(); ++llllllllllllllIIllllllIIIIIIlIIl) {
                final BlockPos llllllllllllllIIllllllIIIIIIlIII = this.field_177258_e.get(llllllllllllllIIllllllIIIIIIlIIl);
                if (this.field_177261_a.getBlockState(llllllllllllllIIllllllIIIIIIlIII).getBlock() == Blocks.slime_block && !this.func_177250_b(llllllllllllllIIllllllIIIIIIlIII)) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public List func_177254_c() {
        return this.field_177258_e;
    }
    
    private void func_177255_a(final int llllllllllllllIIlllllIllllIlllIl, final int llllllllllllllIIlllllIllllIlIllI) {
        final ArrayList llllllllllllllIIlllllIllllIllIll = Lists.newArrayList();
        final ArrayList llllllllllllllIIlllllIllllIllIlI = Lists.newArrayList();
        final ArrayList llllllllllllllIIlllllIllllIllIIl = Lists.newArrayList();
        llllllllllllllIIlllllIllllIllIll.addAll(this.field_177258_e.subList(0, llllllllllllllIIlllllIllllIlIllI));
        llllllllllllllIIlllllIllllIllIlI.addAll(this.field_177258_e.subList(this.field_177258_e.size() - llllllllllllllIIlllllIllllIlllIl, this.field_177258_e.size()));
        llllllllllllllIIlllllIllllIllIIl.addAll(this.field_177258_e.subList(llllllllllllllIIlllllIllllIlIllI, this.field_177258_e.size() - llllllllllllllIIlllllIllllIlllIl));
        this.field_177258_e.clear();
        this.field_177258_e.addAll(llllllllllllllIIlllllIllllIllIll);
        this.field_177258_e.addAll(llllllllllllllIIlllllIllllIllIlI);
        this.field_177258_e.addAll(llllllllllllllIIlllllIllllIllIIl);
    }
    
    private boolean func_177250_b(final BlockPos llllllllllllllIIlllllIllllIIIlIl) {
        for (final EnumFacing llllllllllllllIIlllllIllllIIIlll : EnumFacing.values()) {
            if (llllllllllllllIIlllllIllllIIIlll.getAxis() != this.field_177257_d.getAxis() && !this.func_177251_a(llllllllllllllIIlllllIllllIIIlIl.offset(llllllllllllllIIlllllIllllIIIlll))) {
                return false;
            }
        }
        return true;
    }
}
