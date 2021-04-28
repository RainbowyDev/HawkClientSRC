package net.minecraft.client.renderer.chunk;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class VboChunkFactory implements IRenderChunkFactory
{
    static {
        __OBFID = "CL_00002451";
    }
    
    @Override
    public RenderChunk func_178602_a(final World llIllIllIlIIIl, final RenderGlobal llIllIllIIllII, final BlockPos llIllIllIIlIll, final int llIllIllIIlllI) {
        return new RenderChunk(llIllIllIlIIIl, llIllIllIIllII, llIllIllIIlIll, llIllIllIIlllI);
    }
}
