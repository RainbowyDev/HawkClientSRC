package optifine;

import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.chunk.*;
import net.minecraft.util.*;

public class RenderInfoLazy
{
    private /* synthetic */ RenderGlobal.ContainerLocalRenderInformation renderInfo;
    private /* synthetic */ RenderChunk renderChunk;
    
    public void setRenderChunk(final RenderChunk llllllllllllllIIllIllllIIIIIlIIl) {
        this.renderChunk = llllllllllllllIIllIllllIIIIIlIIl;
        this.renderInfo = null;
    }
    
    public RenderChunk getRenderChunk() {
        return this.renderChunk;
    }
    
    public RenderGlobal.ContainerLocalRenderInformation getRenderInfo() {
        if (this.renderInfo == null) {
            this.renderInfo = new RenderGlobal.ContainerLocalRenderInformation(this.renderChunk, null, 0);
        }
        return this.renderInfo;
    }
}
