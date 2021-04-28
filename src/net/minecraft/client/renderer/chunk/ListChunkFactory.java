package net.minecraft.client.renderer.chunk;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class ListChunkFactory implements IRenderChunkFactory
{
    @Override
    public RenderChunk func_178602_a(final World llllllllllllllIllllllIlllIllllIl, final RenderGlobal llllllllllllllIllllllIlllIllllII, final BlockPos llllllllllllllIllllllIlllIllIlll, final int llllllllllllllIllllllIlllIlllIlI) {
        return new ListedRenderChunk(llllllllllllllIllllllIlllIllllIl, llllllllllllllIllllllIlllIllllII, llllllllllllllIllllllIlllIllIlll, llllllllllllllIllllllIlllIlllIlI);
    }
}
