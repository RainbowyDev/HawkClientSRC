package net.minecraft.world.gen;

import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class FlatLayerInfo
{
    private /* synthetic */ IBlockState field_175901_b;
    private /* synthetic */ int layerCount;
    private final /* synthetic */ int field_175902_a;
    private /* synthetic */ int layerMinimumY;
    
    private int getFillBlockMeta() {
        return this.field_175901_b.getBlock().getMetaFromState(this.field_175901_b);
    }
    
    public IBlockState func_175900_c() {
        return this.field_175901_b;
    }
    
    public FlatLayerInfo(final int llllllllllllllIllIIIIlIllIlIIIll, final int llllllllllllllIllIIIIlIllIlIIlll, final Block llllllllllllllIllIIIIlIllIlIIllI, final int llllllllllllllIllIIIIlIllIlIIlIl) {
        this(llllllllllllllIllIIIIlIllIlIIIll, llllllllllllllIllIIIIlIllIlIIlll, llllllllllllllIllIIIIlIllIlIIllI);
        this.field_175901_b = llllllllllllllIllIIIIlIllIlIIllI.getStateFromMeta(llllllllllllllIllIIIIlIllIlIIlIl);
    }
    
    public void setMinY(final int llllllllllllllIllIIIIlIllIIIllIl) {
        this.layerMinimumY = llllllllllllllIllIIIIlIllIIIllIl;
    }
    
    private Block func_151536_b() {
        return this.field_175901_b.getBlock();
    }
    
    public int getMinY() {
        return this.layerMinimumY;
    }
    
    public FlatLayerInfo(final int llllllllllllllIllIIIIlIllIllIIIl, final int llllllllllllllIllIIIIlIllIllIlII, final Block llllllllllllllIllIIIIlIllIllIIll) {
        this.layerCount = 1;
        this.field_175902_a = llllllllllllllIllIIIIlIllIllIIIl;
        this.layerCount = llllllllllllllIllIIIIlIllIllIlII;
        this.field_175901_b = llllllllllllllIllIIIIlIllIllIIll.getDefaultState();
    }
    
    public FlatLayerInfo(final int llllllllllllllIllIIIIlIllIllllII, final Block llllllllllllllIllIIIIlIllIlllIll) {
        this(3, llllllllllllllIllIIIIlIllIllllII, llllllllllllllIllIIIIlIllIlllIll);
    }
    
    @Override
    public String toString() {
        String llllllllllllllIllIIIIlIllIIIIlIl = null;
        if (this.field_175902_a >= 3) {
            final ResourceLocation llllllllllllllIllIIIIlIllIIIIlII = (ResourceLocation)Block.blockRegistry.getNameForObject(this.func_151536_b());
            String llllllllllllllIllIIIIlIllIIIIllI = (llllllllllllllIllIIIIlIllIIIIlII == null) ? "null" : llllllllllllllIllIIIIlIllIIIIlII.toString();
            if (this.layerCount > 1) {
                llllllllllllllIllIIIIlIllIIIIllI = String.valueOf(new StringBuilder(String.valueOf(this.layerCount)).append("*").append(llllllllllllllIllIIIIlIllIIIIllI));
            }
        }
        else {
            llllllllllllllIllIIIIlIllIIIIlIl = Integer.toString(Block.getIdFromBlock(this.func_151536_b()));
            if (this.layerCount > 1) {
                llllllllllllllIllIIIIlIllIIIIlIl = String.valueOf(new StringBuilder(String.valueOf(this.layerCount)).append("x").append(llllllllllllllIllIIIIlIllIIIIlIl));
            }
        }
        final int llllllllllllllIllIIIIlIllIIIIIll = this.getFillBlockMeta();
        if (llllllllllllllIllIIIIlIllIIIIIll > 0) {
            llllllllllllllIllIIIIlIllIIIIlIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlIllIIIIlIl)).append(":").append(llllllllllllllIllIIIIlIllIIIIIll));
        }
        return llllllllllllllIllIIIIlIllIIIIlIl;
    }
    
    static {
        __OBFID = "CL_00000441";
    }
    
    public int getLayerCount() {
        return this.layerCount;
    }
}
