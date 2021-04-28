package net.minecraft.client.resources;

import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import java.io.*;

public class FoliageColorReloadListener implements IResourceManagerReloadListener
{
    private static final /* synthetic */ ResourceLocation field_130079_a;
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllllIllllIIlllIIlllIII) {
        try {
            ColorizerFoliage.setFoliageBiomeColorizer(TextureUtil.readImageData(llllllllllllllIllllIIlllIIlllIII, FoliageColorReloadListener.field_130079_a));
        }
        catch (IOException ex) {}
    }
    
    static {
        __OBFID = "CL_00001077";
        field_130079_a = new ResourceLocation("textures/colormap/foliage.png");
    }
}
