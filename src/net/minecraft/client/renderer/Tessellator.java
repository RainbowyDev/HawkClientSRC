package net.minecraft.client.renderer;

public class Tessellator
{
    public static final /* synthetic */ Tessellator instance;
    private /* synthetic */ WorldVertexBufferUploader field_178182_b;
    private /* synthetic */ WorldRenderer worldRenderer;
    
    static {
        __OBFID = "CL_00000960";
        instance = new Tessellator(2097152);
    }
    
    public int draw() {
        return this.field_178182_b.draw(this.worldRenderer, this.worldRenderer.draw());
    }
    
    public WorldRenderer getWorldRenderer() {
        return this.worldRenderer;
    }
    
    public static Tessellator getInstance() {
        return Tessellator.instance;
    }
    
    public Tessellator(final int llllllllllllllllIlllIllIlIlIlllI) {
        this.field_178182_b = new WorldVertexBufferUploader();
        this.worldRenderer = new WorldRenderer(llllllllllllllllIlllIllIlIlIlllI);
    }
}
