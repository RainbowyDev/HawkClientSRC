package net.minecraft.realms;

import net.minecraft.client.renderer.*;

public class Tezzelator
{
    public static /* synthetic */ Tessellator t;
    
    public void normal(final float llllllllllllllIIIIIlIIIlIlIIlllI, final float llllllllllllllIIIIIlIIIlIlIlIIII, final float llllllllllllllIIIIIlIIIlIlIIllll) {
        Tezzelator.t.getWorldRenderer().func_178980_d(llllllllllllllIIIIIlIIIlIlIIlllI, llllllllllllllIIIIIlIIIlIlIlIIII, llllllllllllllIIIIIlIIIlIlIIllll);
    }
    
    public void noColor() {
        Tezzelator.t.getWorldRenderer().markDirty();
    }
    
    public void color(final int llllllllllllllIIIIIlIIIlIIIlIllI, final int llllllllllllllIIIIIlIIIlIIIlIlIl) {
        Tezzelator.t.getWorldRenderer().func_178974_a(llllllllllllllIIIIIlIIIlIIIlIllI, llllllllllllllIIIIIlIIIlIIIlIlIl);
    }
    
    public void begin(final int llllllllllllllIIIIIlIIIlIIlIlIll) {
        Tezzelator.t.getWorldRenderer().startDrawing(llllllllllllllIIIIIlIIIlIIlIlIll);
    }
    
    public void color(final float llllllllllllllIIIIIlIIIlIllIlIll, final float llllllllllllllIIIIIlIIIlIllIlIlI, final float llllllllllllllIIIIIlIIIlIllIlIIl, final float llllllllllllllIIIIIlIIIlIllIIlII) {
        Tezzelator.t.getWorldRenderer().func_178960_a(llllllllllllllIIIIIlIIIlIllIlIll, llllllllllllllIIIIIlIIIlIllIlIlI, llllllllllllllIIIIIlIIIlIllIlIIl, llllllllllllllIIIIIlIIIlIllIIlII);
    }
    
    public void color(final int llllllllllllllIIIIIlIIIlIIIIIIll, final int llllllllllllllIIIIIlIIIlIIIIIIlI, final int llllllllllllllIIIIIlIIIlIIIIIIIl, final int llllllllllllllIIIIIlIIIIllllllII) {
        Tezzelator.t.getWorldRenderer().func_178961_b(llllllllllllllIIIIIlIIIlIIIIIIll, llllllllllllllIIIIIlIIIlIIIIIIlI, llllllllllllllIIIIIlIIIlIIIIIIIl, llllllllllllllIIIIIlIIIIllllllII);
    }
    
    public void vertex(final double llllllllllllllIIIIIlIIIlIlllIllI, final double llllllllllllllIIIIIlIIIlIlllIIlI, final double llllllllllllllIIIIIlIIIlIlllIIIl) {
        Tezzelator.t.getWorldRenderer().addVertex(llllllllllllllIIIIIlIIIlIlllIllI, llllllllllllllIIIIIlIIIlIlllIIlI, llllllllllllllIIIIIlIIIlIlllIIIl);
    }
    
    public void begin() {
        Tezzelator.t.getWorldRenderer().startDrawingQuads();
    }
    
    public WorldRenderer.State sortQuads(final float llllllllllllllIIIIIlIIIlIIlllIII, final float llllllllllllllIIIIIlIIIlIIllIlll, final float llllllllllllllIIIIIlIIIlIIllIIll) {
        return Tezzelator.t.getWorldRenderer().getVertexState(llllllllllllllIIIIIlIIIlIIlllIII, llllllllllllllIIIIIlIIIlIIllIlll, llllllllllllllIIIIIlIIIlIIllIIll);
    }
    
    public void color(final int llllllllllllllIIIIIlIIIlIlIIIlll) {
        Tezzelator.t.getWorldRenderer().func_178991_c(llllllllllllllIIIIIlIIIlIlIIIlll);
    }
    
    public void color(final byte llllllllllllllIIIIIlIIIIlllIllIl, final byte llllllllllllllIIIIIlIIIIlllIllII, final byte llllllllllllllIIIIIlIIIIlllIlllI) {
        Tezzelator.t.getWorldRenderer().func_178982_a(llllllllllllllIIIIIlIIIIlllIllIl, llllllllllllllIIIIIlIIIIlllIllII, llllllllllllllIIIIIlIIIIlllIlllI);
    }
    
    public void color(final int llllllllllllllIIIIIlIIIlIlIlllII, final int llllllllllllllIIIIIlIIIlIlIllllI, final int llllllllllllllIIIIIlIIIlIlIlllIl) {
        Tezzelator.t.getWorldRenderer().setPosition(llllllllllllllIIIIIlIIIlIlIlllII, llllllllllllllIIIIIlIIIlIlIllllI, llllllllllllllIIIIIlIIIlIlIlllIl);
    }
    
    public void vertexUV(final double llllllllllllllIIIIIlIIIlIIlIIIll, final double llllllllllllllIIIIIlIIIlIIlIIIlI, final double llllllllllllllIIIIIlIIIlIIlIIIIl, final double llllllllllllllIIIIIlIIIlIIIllIll, final double llllllllllllllIIIIIlIIIlIIIlllll) {
        Tezzelator.t.getWorldRenderer().addVertexWithUV(llllllllllllllIIIIIlIIIlIIlIIIll, llllllllllllllIIIIIlIIIlIIlIIIlI, llllllllllllllIIIIIlIIIlIIlIIIIl, llllllllllllllIIIIIlIIIlIIIllIll, llllllllllllllIIIIIlIIIlIIIlllll);
    }
    
    public void tex(final double llllllllllllllIIIIIlIIIIlllllIII, final double llllllllllllllIIIIIlIIIIllllIlIl) {
        Tezzelator.t.getWorldRenderer().setTextureUV(llllllllllllllIIIIIlIIIIlllllIII, llllllllllllllIIIIIlIIIIllllIlIl);
    }
    
    public void offset(final double llllllllllllllIIIIIlIIIlIIIIlllI, final double llllllllllllllIIIIIlIIIlIIIIllIl, final double llllllllllllllIIIIIlIIIlIIIIlIIl) {
        Tezzelator.t.getWorldRenderer().setTranslation(llllllllllllllIIIIIlIIIlIIIIlllI, llllllllllllllIIIIIlIIIlIIIIllIl, llllllllllllllIIIIIlIIIlIIIIlIIl);
    }
    
    public int end() {
        return Tezzelator.t.draw();
    }
    
    public void tex2(final int llllllllllllllIIIIIlIIIlIlIlIlll) {
        Tezzelator.t.getWorldRenderer().func_178963_b(llllllllllllllIIIIIlIIIlIlIlIlll);
    }
    
    static {
        __OBFID = "CL_00001855";
        Tezzelator.t = Tessellator.getInstance();
        instance = new Tezzelator();
    }
    
    public void restoreState(final WorldRenderer.State llllllllllllllIIIIIlIIIlIIlIllll) {
        Tezzelator.t.getWorldRenderer().setVertexState(llllllllllllllIIIIIlIIIlIIlIllll);
    }
    
    public void color(final float llllllllllllllIIIIIlIIIlIlIIIIlI, final float llllllllllllllIIIIIlIIIlIlIIIIIl, final float llllllllllllllIIIIIlIIIlIIllllIl) {
        Tezzelator.t.getWorldRenderer().func_178986_b(llllllllllllllIIIIIlIIIlIlIIIIlI, llllllllllllllIIIIIlIIIlIlIIIIIl, llllllllllllllIIIIIlIIIlIIllllIl);
    }
}
