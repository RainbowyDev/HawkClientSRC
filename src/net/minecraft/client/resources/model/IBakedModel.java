package net.minecraft.client.resources.model;

import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.util.*;

public interface IBakedModel
{
    TextureAtlasSprite getTexture();
    
    List func_177550_a();
    
    boolean isAmbientOcclusionEnabled();
    
    boolean isGui3d();
    
    ItemCameraTransforms getItemCameraTransforms();
    
    List func_177551_a(final EnumFacing p0);
    
    boolean isBuiltInRenderer();
}
