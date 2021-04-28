package net.minecraft.client.renderer;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.minecraft.client.resources.model.*;
import java.util.*;
import com.google.common.collect.*;

public class ItemModelMesher
{
    private final /* synthetic */ ModelManager modelManager;
    private final /* synthetic */ Map simpleShapesCache;
    private final /* synthetic */ Map simpleShapes;
    private final /* synthetic */ Map shapers;
    
    public TextureAtlasSprite getParticleIcon(final Item lllllllllllllllIlIIlIIIIlIIllIlI) {
        return this.getParticleIcon(lllllllllllllllIlIIlIIIIlIIllIlI, 0);
    }
    
    public ModelManager getModelManager() {
        return this.modelManager;
    }
    
    protected IBakedModel getItemModel(final Item lllllllllllllllIlIIlIIIIIlllIlII, final int lllllllllllllllIlIIlIIIIIlllIllI) {
        return this.simpleShapesCache.get(this.getIndex(lllllllllllllllIlIIlIIIIIlllIlII, lllllllllllllllIlIIlIIIIIlllIllI));
    }
    
    static {
        __OBFID = "CL_00002536";
    }
    
    public TextureAtlasSprite getParticleIcon(final Item lllllllllllllllIlIIlIIIIlIIlIIII, final int lllllllllllllllIlIIlIIIIlIIlIIlI) {
        return this.getItemModel(new ItemStack(lllllllllllllllIlIIlIIIIlIIlIIII, 1, lllllllllllllllIlIIlIIIIlIIlIIlI)).getTexture();
    }
    
    protected int getMetadata(final ItemStack lllllllllllllllIlIIlIIIIIlllllII) {
        return lllllllllllllllIlIIlIIIIIlllllII.isItemStackDamageable() ? 0 : lllllllllllllllIlIIlIIIIIlllllII.getMetadata();
    }
    
    private int getIndex(final Item lllllllllllllllIlIIlIIIIIllIllll, final int lllllllllllllllIlIIlIIIIIllIllII) {
        return Item.getIdFromItem(lllllllllllllllIlIIlIIIIIllIllll) << 16 | lllllllllllllllIlIIlIIIIIllIllII;
    }
    
    public void rebuildCache() {
        this.simpleShapesCache.clear();
        for (final Map.Entry lllllllllllllllIlIIlIIIIIlIIlllI : this.simpleShapes.entrySet()) {
            this.simpleShapesCache.put(lllllllllllllllIlIIlIIIIIlIIlllI.getKey(), this.modelManager.getModel(lllllllllllllllIlIIlIIIIIlIIlllI.getValue()));
        }
    }
    
    public IBakedModel getItemModel(final ItemStack lllllllllllllllIlIIlIIIIlIIIIIll) {
        final Item lllllllllllllllIlIIlIIIIlIIIIlll = lllllllllllllllIlIIlIIIIlIIIIIll.getItem();
        IBakedModel lllllllllllllllIlIIlIIIIlIIIIllI = this.getItemModel(lllllllllllllllIlIIlIIIIlIIIIlll, this.getMetadata(lllllllllllllllIlIIlIIIIlIIIIIll));
        if (lllllllllllllllIlIIlIIIIlIIIIllI == null) {
            final ItemMeshDefinition lllllllllllllllIlIIlIIIIlIIIIlIl = this.shapers.get(lllllllllllllllIlIIlIIIIlIIIIlll);
            if (lllllllllllllllIlIIlIIIIlIIIIlIl != null) {
                lllllllllllllllIlIIlIIIIlIIIIllI = this.modelManager.getModel(lllllllllllllllIlIIlIIIIlIIIIlIl.getModelLocation(lllllllllllllllIlIIlIIIIlIIIIIll));
            }
        }
        if (lllllllllllllllIlIIlIIIIlIIIIllI == null) {
            lllllllllllllllIlIIlIIIIlIIIIllI = this.modelManager.getMissingModel();
        }
        return lllllllllllllllIlIIlIIIIlIIIIllI;
    }
    
    public void register(final Item lllllllllllllllIlIIlIIIIIllIIIlI, final int lllllllllllllllIlIIlIIIIIllIIlIl, final ModelResourceLocation lllllllllllllllIlIIlIIIIIllIIIII) {
        this.simpleShapes.put(this.getIndex(lllllllllllllllIlIIlIIIIIllIIIlI, lllllllllllllllIlIIlIIIIIllIIlIl), lllllllllllllllIlIIlIIIIIllIIIII);
        this.simpleShapesCache.put(this.getIndex(lllllllllllllllIlIIlIIIIIllIIIlI, lllllllllllllllIlIIlIIIIIllIIlIl), this.modelManager.getModel(lllllllllllllllIlIIlIIIIIllIIIII));
    }
    
    public ItemModelMesher(final ModelManager lllllllllllllllIlIIlIIIIlIlIIIII) {
        this.simpleShapes = Maps.newHashMap();
        this.simpleShapesCache = Maps.newHashMap();
        this.shapers = Maps.newHashMap();
        this.modelManager = lllllllllllllllIlIIlIIIIlIlIIIII;
    }
    
    public void register(final Item lllllllllllllllIlIIlIIIIIlIllIll, final ItemMeshDefinition lllllllllllllllIlIIlIIIIIlIllIlI) {
        this.shapers.put(lllllllllllllllIlIIlIIIIIlIllIll, lllllllllllllllIlIIlIIIIIlIllIlI);
    }
}
