package optifine;

import net.minecraft.client.model.*;

public class PlayerItemRenderer
{
    private /* synthetic */ int attachTo;
    private /* synthetic */ float scaleFactor;
    private /* synthetic */ ModelRenderer modelRenderer;
    
    public ModelRenderer getModelRenderer() {
        return this.modelRenderer;
    }
    
    public PlayerItemRenderer(final int lllIllIlllIlI, final float lllIllIlllIIl, final ModelRenderer lllIllIlllIII) {
        this.attachTo = 0;
        this.scaleFactor = 0.0f;
        this.modelRenderer = null;
        this.attachTo = lllIllIlllIlI;
        this.scaleFactor = lllIllIlllIIl;
        this.modelRenderer = lllIllIlllIII;
    }
    
    public void render(final ModelBiped lllIllIlIlIll, final float lllIllIlIlIlI) {
        final ModelRenderer lllIllIlIlIIl = PlayerItemModel.getAttachModel(lllIllIlIlIll, this.attachTo);
        if (lllIllIlIlIIl != null) {
            lllIllIlIlIIl.postRender(lllIllIlIlIlI);
        }
        this.modelRenderer.render(lllIllIlIlIlI * this.scaleFactor);
    }
}
