package net.minecraft.world.gen;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import com.google.common.collect.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.util.*;

public class ChunkProviderDebug implements IChunkProvider
{
    private final /* synthetic */ World field_177463_c;
    private static final /* synthetic */ int field_177462_b;
    private static final /* synthetic */ List field_177464_a;
    
    @Override
    public boolean canSave() {
        return true;
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }
    
    @Override
    public boolean chunkExists(final int lllllllllllllllIlllIllIIIlIIIIII, final int lllllllllllllllIlllIllIIIIllllll) {
        return true;
    }
    
    public ChunkProviderDebug(final World lllllllllllllllIlllIllIIIllIllIl) {
        this.field_177463_c = lllllllllllllllIlllIllIIIllIllIl;
    }
    
    @Override
    public List func_177458_a(final EnumCreatureType lllllllllllllllIlllIllIIIIlIlIIl, final BlockPos lllllllllllllllIlllIllIIIIlIIlII) {
        final BiomeGenBase lllllllllllllllIlllIllIIIIlIIlll = this.field_177463_c.getBiomeGenForCoords(lllllllllllllllIlllIllIIIIlIIlII);
        return lllllllllllllllIlllIllIIIIlIIlll.getSpawnableList(lllllllllllllllIlllIllIIIIlIlIIl);
    }
    
    @Override
    public void func_180514_a(final Chunk lllllllllllllllIlllIllIIIIIlllII, final int lllllllllllllllIlllIllIIIIIllIll, final int lllllllllllllllIlllIllIIIIIllIlI) {
    }
    
    @Override
    public void populate(final IChunkProvider lllllllllllllllIlllIllIIIIllllIl, final int lllllllllllllllIlllIllIIIIllllII, final int lllllllllllllllIlllIllIIIIlllIll) {
    }
    
    @Override
    public Chunk func_177459_a(final BlockPos lllllllllllllllIlllIllIIIIIlIllI) {
        return this.provideChunk(lllllllllllllllIlllIllIIIIIlIllI.getX() >> 4, lllllllllllllllIlllIllIIIIIlIllI.getZ() >> 4);
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllllIlllIllIIIlIlIlIl, final int lllllllllllllllIlllIllIIIlIlIlII) {
        final ChunkPrimer lllllllllllllllIlllIllIIIllIIIII = new ChunkPrimer();
        for (int lllllllllllllllIlllIllIIIlIlllIl = 0; lllllllllllllllIlllIllIIIlIlllIl < 16; ++lllllllllllllllIlllIllIIIlIlllIl) {
            for (int lllllllllllllllIlllIllIIIlIlllII = 0; lllllllllllllllIlllIllIIIlIlllII < 16; ++lllllllllllllllIlllIllIIIlIlllII) {
                final int lllllllllllllllIlllIllIIIlIllIll = lllllllllllllllIlllIllIIIlIlIlIl * 16 + lllllllllllllllIlllIllIIIlIlllIl;
                final int lllllllllllllllIlllIllIIIlIlllll = lllllllllllllllIlllIllIIIlIlIlII * 16 + lllllllllllllllIlllIllIIIlIlllII;
                lllllllllllllllIlllIllIIIllIIIII.setBlockState(lllllllllllllllIlllIllIIIlIlllIl, 60, lllllllllllllllIlllIllIIIlIlllII, Blocks.barrier.getDefaultState());
                final IBlockState lllllllllllllllIlllIllIIIlIllIlI = func_177461_b(lllllllllllllllIlllIllIIIlIllIll, lllllllllllllllIlllIllIIIlIlllll);
                if (lllllllllllllllIlllIllIIIlIllIlI != null) {
                    lllllllllllllllIlllIllIIIllIIIII.setBlockState(lllllllllllllllIlllIllIIIlIlllIl, 70, lllllllllllllllIlllIllIIIlIlllII, lllllllllllllllIlllIllIIIlIllIlI);
                }
            }
        }
        final Chunk lllllllllllllllIlllIllIIIlIllIIl = new Chunk(this.field_177463_c, lllllllllllllllIlllIllIIIllIIIII, lllllllllllllllIlllIllIIIlIlIlIl, lllllllllllllllIlllIllIIIlIlIlII);
        lllllllllllllllIlllIllIIIlIllIIl.generateSkylightMap();
        final BiomeGenBase[] lllllllllllllllIlllIllIIIlIllIII = this.field_177463_c.getWorldChunkManager().loadBlockGeneratorData(null, lllllllllllllllIlllIllIIIlIlIlIl * 16, lllllllllllllllIlllIllIIIlIlIlII * 16, 16, 16);
        final byte[] lllllllllllllllIlllIllIIIlIlIlll = lllllllllllllllIlllIllIIIlIllIIl.getBiomeArray();
        for (int lllllllllllllllIlllIllIIIlIllllI = 0; lllllllllllllllIlllIllIIIlIllllI < lllllllllllllllIlllIllIIIlIlIlll.length; ++lllllllllllllllIlllIllIIIlIllllI) {
            lllllllllllllllIlllIllIIIlIlIlll[lllllllllllllllIlllIllIIIlIllllI] = (byte)lllllllllllllllIlllIllIIIlIllIII[lllllllllllllllIlllIllIIIlIllllI].biomeID;
        }
        lllllllllllllllIlllIllIIIlIllIIl.generateSkylightMap();
        return lllllllllllllllIlllIllIIIlIllIIl;
    }
    
    static {
        __OBFID = "CL_00002002";
        field_177464_a = Lists.newArrayList();
        for (final Block lllllllllllllllIlllIllIIIlllIlIl : Block.blockRegistry) {
            ChunkProviderDebug.field_177464_a.addAll((Collection)lllllllllllllllIlllIllIIIlllIlIl.getBlockState().getValidStates());
        }
        field_177462_b = MathHelper.ceiling_float_int(MathHelper.sqrt_float((float)ChunkProviderDebug.field_177464_a.size()));
    }
    
    @Override
    public BlockPos func_180513_a(final World lllllllllllllllIlllIllIIIIlIIIIl, final String lllllllllllllllIlllIllIIIIlIIIII, final BlockPos lllllllllllllllIlllIllIIIIIlllll) {
        return null;
    }
    
    @Override
    public boolean func_177460_a(final IChunkProvider lllllllllllllllIlllIllIIIIlllIIl, final Chunk lllllllllllllllIlllIllIIIIlllIII, final int lllllllllllllllIlllIllIIIIllIlll, final int lllllllllllllllIlllIllIIIIllIllI) {
        return false;
    }
    
    @Override
    public String makeString() {
        return "DebugLevelSource";
    }
    
    @Override
    public boolean saveChunks(final boolean lllllllllllllllIlllIllIIIIllIlII, final IProgressUpdate lllllllllllllllIlllIllIIIIllIIll) {
        return true;
    }
    
    public static IBlockState func_177461_b(int lllllllllllllllIlllIllIIIlIIlIIl, int lllllllllllllllIlllIllIIIlIIIlII) {
        IBlockState lllllllllllllllIlllIllIIIlIIIlll = null;
        if (lllllllllllllllIlllIllIIIlIIlIIl > 0 && lllllllllllllllIlllIllIIIlIIIlII > 0 && lllllllllllllllIlllIllIIIlIIlIIl % 2 != 0 && lllllllllllllllIlllIllIIIlIIIlII % 2 != 0) {
            lllllllllllllllIlllIllIIIlIIlIIl /= 2;
            lllllllllllllllIlllIllIIIlIIIlII /= 2;
            if (lllllllllllllllIlllIllIIIlIIlIIl <= ChunkProviderDebug.field_177462_b && lllllllllllllllIlllIllIIIlIIIlII <= ChunkProviderDebug.field_177462_b) {
                final int lllllllllllllllIlllIllIIIlIIIllI = MathHelper.abs_int(lllllllllllllllIlllIllIIIlIIlIIl * ChunkProviderDebug.field_177462_b + lllllllllllllllIlllIllIIIlIIIlII);
                if (lllllllllllllllIlllIllIIIlIIIllI < ChunkProviderDebug.field_177464_a.size()) {
                    lllllllllllllllIlllIllIIIlIIIlll = ChunkProviderDebug.field_177464_a.get(lllllllllllllllIlllIllIIIlIIIllI);
                }
            }
        }
        return lllllllllllllllIlllIllIIIlIIIlll;
    }
    
    @Override
    public int getLoadedChunkCount() {
        return 0;
    }
    
    @Override
    public void saveExtraData() {
    }
}
