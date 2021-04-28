package net.minecraft.client.renderer;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import optifine.*;

public class RegionRenderCache extends ChunkCache
{
    private static /* synthetic */ ArrayDeque<int[]> cacheLights;
    private final /* synthetic */ BlockPos field_175633_g;
    private static final /* synthetic */ IBlockState field_175632_f;
    private /* synthetic */ int[] field_175634_h;
    private static /* synthetic */ ArrayDeque<IBlockState[]> cacheStates;
    private static /* synthetic */ int maxCacheSize;
    private /* synthetic */ IBlockState[] field_175635_i;
    
    static {
        __OBFID = "CL_00002565";
        field_175632_f = Blocks.air.getDefaultState();
        RegionRenderCache.cacheLights = new ArrayDeque<int[]>();
        RegionRenderCache.cacheStates = new ArrayDeque<IBlockState[]>();
        RegionRenderCache.maxCacheSize = Config.limit(Runtime.getRuntime().availableProcessors(), 1, 32);
    }
    
    private static IBlockState[] allocateStates(final int llllllllllllllIlIlIlIllIllIlIlll) {
        final ArrayDeque llllllllllllllIlIlIlIllIllIlIllI = RegionRenderCache.cacheStates;
        synchronized (RegionRenderCache.cacheStates) {
            IBlockState[] llllllllllllllIlIlIlIllIllIlIlIl = RegionRenderCache.cacheStates.pollLast();
            if (llllllllllllllIlIlIlIllIllIlIlIl != null && llllllllllllllIlIlIlIllIllIlIlIl.length >= llllllllllllllIlIlIlIllIllIlIlll) {
                Arrays.fill(llllllllllllllIlIlIlIllIllIlIlIl, null);
            }
            else {
                llllllllllllllIlIlIlIllIllIlIlIl = new IBlockState[llllllllllllllIlIlIlIllIllIlIlll];
            }
            // monitorexit(RegionRenderCache.cacheStates)
            return llllllllllllllIlIlIlIllIllIlIlIl;
        }
    }
    
    @Override
    public TileEntity getTileEntity(final BlockPos llllllllllllllIlIlIlIllllIIIIlII) {
        final int llllllllllllllIlIlIlIllllIIIIlll = (llllllllllllllIlIlIlIllllIIIIlII.getX() >> 4) - this.chunkX;
        final int llllllllllllllIlIlIlIllllIIIIllI = (llllllllllllllIlIlIlIllllIIIIlII.getZ() >> 4) - this.chunkZ;
        return this.chunkArray[llllllllllllllIlIlIlIllllIIIIlll][llllllllllllllIlIlIlIllllIIIIllI].func_177424_a(llllllllllllllIlIlIlIllllIIIIlII, Chunk.EnumCreateEntityType.QUEUED);
    }
    
    public void freeBuffers() {
        freeLights(this.field_175634_h);
        freeStates(this.field_175635_i);
    }
    
    private IBlockState func_175631_c(final BlockPos llllllllllllllIlIlIlIlllIIllllll) {
        if (llllllllllllllIlIlIlIlllIIllllll.getY() >= 0 && llllllllllllllIlIlIlIlllIIllllll.getY() < 256) {
            final int llllllllllllllIlIlIlIlllIIlllllI = (llllllllllllllIlIlIlIlllIIllllll.getX() >> 4) - this.chunkX;
            final int llllllllllllllIlIlIlIlllIIllllIl = (llllllllllllllIlIlIlIlllIIllllll.getZ() >> 4) - this.chunkZ;
            return this.chunkArray[llllllllllllllIlIlIlIlllIIlllllI][llllllllllllllIlIlIlIlllIIllllIl].getBlockState(llllllllllllllIlIlIlIlllIIllllll);
        }
        return RegionRenderCache.field_175632_f;
    }
    
    @Override
    public IBlockState getBlockState(final BlockPos llllllllllllllIlIlIlIlllIlIllIIl) {
        final int llllllllllllllIlIlIlIlllIlIlIlll = this.func_175630_e(llllllllllllllIlIlIlIlllIlIllIIl);
        IBlockState llllllllllllllIlIlIlIlllIlIlIlIl = this.field_175635_i[llllllllllllllIlIlIlIlllIlIlIlll];
        if (llllllllllllllIlIlIlIlllIlIlIlIl == null) {
            llllllllllllllIlIlIlIlllIlIlIlIl = this.func_175631_c(llllllllllllllIlIlIlIlllIlIllIIl);
            this.field_175635_i[llllllllllllllIlIlIlIlllIlIlIlll] = llllllllllllllIlIlIlIlllIlIlIlIl;
        }
        return llllllllllllllIlIlIlIlllIlIlIlIl;
    }
    
    private static int[] allocateLights(final int llllllllllllllIlIlIlIlllIIIIllII) {
        final ArrayDeque llllllllllllllIlIlIlIlllIIIIlIlI = RegionRenderCache.cacheLights;
        synchronized (RegionRenderCache.cacheLights) {
            int[] llllllllllllllIlIlIlIlllIIIIlIII = RegionRenderCache.cacheLights.pollLast();
            if (llllllllllllllIlIlIlIlllIIIIlIII == null || llllllllllllllIlIlIlIlllIIIIlIII.length < llllllllllllllIlIlIlIlllIIIIllII) {
                llllllllllllllIlIlIlIlllIIIIlIII = new int[llllllllllllllIlIlIlIlllIIIIllII];
            }
            // monitorexit(RegionRenderCache.cacheLights)
            return llllllllllllllIlIlIlIlllIIIIlIII;
        }
    }
    
    public static void freeStates(final IBlockState[] llllllllllllllIlIlIlIllIllIIlIll) {
        final ArrayDeque llllllllllllllIlIlIlIllIllIIllII = RegionRenderCache.cacheStates;
        synchronized (RegionRenderCache.cacheStates) {
            if (RegionRenderCache.cacheStates.size() < RegionRenderCache.maxCacheSize) {
                RegionRenderCache.cacheStates.add(llllllllllllllIlIlIlIllIllIIlIll);
            }
        }
        // monitorexit(RegionRenderCache.cacheStates)
    }
    
    public static void freeLights(final int[] llllllllllllllIlIlIlIllIlllIllIl) {
        final ArrayDeque llllllllllllllIlIlIlIllIlllIllll = RegionRenderCache.cacheLights;
        synchronized (RegionRenderCache.cacheLights) {
            if (RegionRenderCache.cacheLights.size() < RegionRenderCache.maxCacheSize) {
                RegionRenderCache.cacheLights.add(llllllllllllllIlIlIlIllIlllIllIl);
            }
        }
        // monitorexit(RegionRenderCache.cacheLights)
    }
    
    public RegionRenderCache(final World llllllllllllllIlIlIlIllllIlIllII, final BlockPos llllllllllllllIlIlIlIllllIlIlIlI, final BlockPos llllllllllllllIlIlIlIllllIlIlIII, final int llllllllllllllIlIlIlIllllIIllIll) {
        super(llllllllllllllIlIlIlIllllIlIllII, llllllllllllllIlIlIlIllllIlIlIlI, llllllllllllllIlIlIlIllllIlIlIII, llllllllllllllIlIlIlIllllIIllIll);
        this.field_175633_g = llllllllllllllIlIlIlIllllIlIlIlI.subtract(new Vec3i(llllllllllllllIlIlIlIllllIIllIll, llllllllllllllIlIlIlIllllIIllIll, llllllllllllllIlIlIlIllllIIllIll));
        final boolean llllllllllllllIlIlIlIllllIlIIlIl = true;
        this.field_175634_h = allocateLights(8000);
        Arrays.fill(this.field_175634_h, -1);
        this.field_175635_i = allocateStates(8000);
    }
    
    @Override
    public int getCombinedLight(final BlockPos llllllllllllllIlIlIlIlllIlllIIll, final int llllllllllllllIlIlIlIlllIlllIIIl) {
        final int llllllllllllllIlIlIlIlllIllllIIl = this.func_175630_e(llllllllllllllIlIlIlIlllIlllIIll);
        int llllllllllllllIlIlIlIlllIlllIlll = this.field_175634_h[llllllllllllllIlIlIlIlllIllllIIl];
        if (llllllllllllllIlIlIlIlllIlllIlll == -1) {
            llllllllllllllIlIlIlIlllIlllIlll = super.getCombinedLight(llllllllllllllIlIlIlIlllIlllIIll, llllllllllllllIlIlIlIlllIlllIIIl);
            if (Config.isDynamicLights() && !this.getBlockState(llllllllllllllIlIlIlIlllIlllIIll).getBlock().isOpaqueCube()) {
                llllllllllllllIlIlIlIlllIlllIlll = DynamicLights.getCombinedLight(llllllllllllllIlIlIlIlllIlllIIll, llllllllllllllIlIlIlIlllIlllIlll);
            }
            this.field_175634_h[llllllllllllllIlIlIlIlllIllllIIl] = llllllllllllllIlIlIlIlllIlllIlll;
        }
        return llllllllllllllIlIlIlIlllIlllIlll;
    }
    
    private int func_175630_e(final BlockPos llllllllllllllIlIlIlIlllIIlIlIII) {
        final int llllllllllllllIlIlIlIlllIIlIIllI = llllllllllllllIlIlIlIlllIIlIlIII.getX() - this.field_175633_g.getX();
        final int llllllllllllllIlIlIlIlllIIlIIlII = llllllllllllllIlIlIlIlllIIlIlIII.getY() - this.field_175633_g.getY();
        final int llllllllllllllIlIlIlIlllIIlIIIll = llllllllllllllIlIlIlIlllIIlIlIII.getZ() - this.field_175633_g.getZ();
        return llllllllllllllIlIlIlIlllIIlIIllI * 400 + llllllllllllllIlIlIlIlllIIlIIIll * 20 + llllllllllllllIlIlIlIlllIIlIIlII;
    }
}
