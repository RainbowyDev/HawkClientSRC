package net.minecraft.client.renderer;

import net.minecraft.util.*;

public class RegionRenderCacheBuilder
{
    private final /* synthetic */ WorldRenderer[] field_179040_a;
    
    static {
        __OBFID = "CL_00002564";
    }
    
    public WorldRenderer func_179038_a(final EnumWorldBlockLayer lIllIllIIIll) {
        return this.field_179040_a[lIllIllIIIll.ordinal()];
    }
    
    public WorldRenderer func_179039_a(final int lIllIlIlllll) {
        return this.field_179040_a[lIllIlIlllll];
    }
    
    public RegionRenderCacheBuilder() {
        this.field_179040_a = new WorldRenderer[EnumWorldBlockLayer.values().length];
        this.field_179040_a[EnumWorldBlockLayer.SOLID.ordinal()] = new WorldRenderer(2097152);
        this.field_179040_a[EnumWorldBlockLayer.CUTOUT.ordinal()] = new WorldRenderer(131072);
        this.field_179040_a[EnumWorldBlockLayer.CUTOUT_MIPPED.ordinal()] = new WorldRenderer(131072);
        this.field_179040_a[EnumWorldBlockLayer.TRANSLUCENT.ordinal()] = new WorldRenderer(262144);
    }
}
