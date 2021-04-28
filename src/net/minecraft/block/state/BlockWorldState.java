package net.minecraft.block.state;

import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import com.google.common.base.*;

public class BlockWorldState
{
    private /* synthetic */ boolean field_177512_e;
    private /* synthetic */ TileEntity field_177511_d;
    private final /* synthetic */ World world;
    private final /* synthetic */ BlockPos pos;
    private /* synthetic */ IBlockState field_177514_c;
    
    public BlockWorldState(final World llllllllllllllllIlllIlIlIlIIIllI, final BlockPos llllllllllllllllIlllIlIlIlIIIlIl) {
        this.world = llllllllllllllllIlllIlIlIlIIIllI;
        this.pos = llllllllllllllllIlllIlIlIlIIIlIl;
    }
    
    static {
        __OBFID = "CL_00002026";
    }
    
    public static Predicate hasState(final Predicate llllllllllllllllIlllIlIlIIlllIlI) {
        return (Predicate)new Predicate() {
            public boolean apply(final Object lllllllllllllllIIlllIlIIlIIllIII) {
                return this.func_177503_a((BlockWorldState)lllllllllllllllIIlllIlIIlIIllIII);
            }
            
            static {
                __OBFID = "CL_00002025";
            }
            
            public boolean func_177503_a(final BlockWorldState lllllllllllllllIIlllIlIIlIlIIIII) {
                return lllllllllllllllIIlllIlIIlIlIIIII != null && llllllllllllllllIlllIlIlIIlllIlI.apply((Object)lllllllllllllllIIlllIlIIlIlIIIII.func_177509_a());
            }
        };
    }
    
    public TileEntity func_177507_b() {
        if (this.field_177511_d == null && !this.field_177512_e) {
            this.field_177511_d = this.world.getTileEntity(this.pos);
            this.field_177512_e = true;
        }
        return this.field_177511_d;
    }
    
    public BlockPos getPos() {
        return this.pos;
    }
    
    public IBlockState func_177509_a() {
        if (this.field_177514_c == null && this.world.isBlockLoaded(this.pos)) {
            this.field_177514_c = this.world.getBlockState(this.pos);
        }
        return this.field_177514_c;
    }
}
