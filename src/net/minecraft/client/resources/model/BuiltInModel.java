package net.minecraft.client.resources.model;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.util.*;

public class BuiltInModel implements IBakedModel
{
    private /* synthetic */ ItemCameraTransforms field_177557_a;
    
    @Override
    public TextureAtlasSprite getTexture() {
        return null;
    }
    
    @Override
    public boolean isGui3d() {
        return false;
    }
    
    static {
        __OBFID = "CL_00002392";
    }
    
    @Override
    public List func_177550_a() {
        return null;
    }
    
    @Override
    public boolean isAmbientOcclusionEnabled() {
        return true;
    }
    
    public BuiltInModel(final ItemCameraTransforms llllllllllllllIIIIIlIIIIIllIlIII) {
        this.field_177557_a = llllllllllllllIIIIIlIIIIIllIlIII;
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return true;
    }
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.field_177557_a;
    }
    
    @Override
    public List func_177551_a(final EnumFacing llllllllllllllIIIIIlIIIIIllIIlII) {
        return null;
    }
}
