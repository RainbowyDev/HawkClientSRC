package net.minecraft.client.resources.model;

import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;

public class ModelManager implements IResourceManagerReloadListener
{
    private final /* synthetic */ BlockModelShapes field_174957_c;
    private final /* synthetic */ TextureMap field_174956_b;
    private /* synthetic */ IBakedModel defaultModel;
    private /* synthetic */ IRegistry modelRegistry;
    
    public IBakedModel getModel(final ModelResourceLocation lllllllllllllllIIIIlIIIlllIlllIl) {
        if (lllllllllllllllIIIIlIIIlllIlllIl == null) {
            return this.defaultModel;
        }
        final IBakedModel lllllllllllllllIIIIlIIIlllIlllll = (IBakedModel)this.modelRegistry.getObject(lllllllllllllllIIIIlIIIlllIlllIl);
        return (lllllllllllllllIIIIlIIIlllIlllll == null) ? this.defaultModel : lllllllllllllllIIIIlIIIlllIlllll;
    }
    
    static {
        __OBFID = "CL_00002388";
    }
    
    public TextureMap func_174952_b() {
        return this.field_174956_b;
    }
    
    public BlockModelShapes getBlockModelShapes() {
        return this.field_174957_c;
    }
    
    public ModelManager(final TextureMap lllllllllllllllIIIIlIIIllllIlllI) {
        this.field_174956_b = lllllllllllllllIIIIlIIIllllIlllI;
        this.field_174957_c = new BlockModelShapes(this);
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllllIIIIlIIIllllIlIIl) {
        final ModelBakery lllllllllllllllIIIIlIIIllllIlIII = new ModelBakery(lllllllllllllllIIIIlIIIllllIlIIl, this.field_174956_b, this.field_174957_c);
        this.modelRegistry = lllllllllllllllIIIIlIIIllllIlIII.setupModelRegistry();
        this.defaultModel = (IBakedModel)this.modelRegistry.getObject(ModelBakery.MODEL_MISSING);
        this.field_174957_c.func_178124_c();
    }
    
    public IBakedModel getMissingModel() {
        return this.defaultModel;
    }
}
