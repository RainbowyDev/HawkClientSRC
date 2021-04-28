package net.minecraft.client.resources;

import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import java.io.*;

public class GrassColorReloadListener implements IResourceManagerReloadListener
{
    private static final /* synthetic */ ResourceLocation field_130078_a;
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllllIlIIIllIlIlllIlIIl) {
        try {
            ColorizerGrass.setGrassBiomeColorizer(TextureUtil.readImageData(llllllllllllllIlIIIllIlIlllIlIIl, GrassColorReloadListener.field_130078_a));
        }
        catch (IOException ex) {}
    }
    
    static {
        __OBFID = "CL_00001078";
        field_130078_a = new ResourceLocation("textures/colormap/grass.png");
    }
}
