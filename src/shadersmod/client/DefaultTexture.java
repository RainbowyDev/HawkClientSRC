package shadersmod.client;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.*;

public class DefaultTexture extends AbstractTexture
{
    public DefaultTexture() {
        this.loadTexture(null);
    }
    
    @Override
    public void loadTexture(final IResourceManager llllllllllllllllIlIIlllIIIlIIlIl) {
        final int[] llllllllllllllllIlIIlllIIIlIIlII = ShadersTex.createAIntImage(1, -1);
        ShadersTex.setupTexture(this.getMultiTexID(), llllllllllllllllIlIIlllIIIlIIlII, 1, 1, false, false);
    }
}
