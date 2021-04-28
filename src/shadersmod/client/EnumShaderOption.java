package shadersmod.client;

public enum EnumShaderOption
{
    ANTIALIASING("ANTIALIASING", 0, "ANTIALIASING", 0, "of.options.shaders.ANTIALIASING", "antialiasingLevel", "0");
    
    private /* synthetic */ String resourceKey;
    private /* synthetic */ String valueDefault;
    
    RENDER_RES_MUL("RENDER_RES_MUL", 3, "RENDER_RES_MUL", 3, "of.options.shaders.RENDER_RES_MUL", "renderResMul", "1.0"), 
    CLOUD_SHADOW("CLOUD_SHADOW", 6, "CLOUD_SHADOW", 6, "of.options.shaders.CLOUD_SHADOW", "cloudShadow", "true"), 
    SPECULAR_MAP("SPECULAR_MAP", 2, "SPECULAR_MAP", 2, "of.options.shaders.SPECULAR_MAP", "specularMapEnabled", "true"), 
    SHADOW_CLIP_FRUSTRUM("SHADOW_CLIP_FRUSTRUM", 10, "SHADOW_CLIP_FRUSTRUM", 10, "of.options.shaders.SHADOW_CLIP_FRUSTRUM", "shadowClipFrustrum", "true");
    
    private /* synthetic */ String propertyKey;
    
    TEX_MIN_FIL_B("TEX_MIN_FIL_B", 11, "TEX_MIN_FIL_B", 11, "of.options.shaders.TEX_MIN_FIL_B", "TexMinFilB", "0"), 
    NORMAL_MAP("NORMAL_MAP", 1, "NORMAL_MAP", 1, "of.options.shaders.NORMAL_MAP", "normalMapEnabled", "true"), 
    OLD_LIGHTING("OLD_LIGHTING", 7, "OLD_LIGHTING", 7, "of.options.shaders.OLD_LIGHTING", "oldLighting", "default"), 
    TEX_MIN_FIL_N("TEX_MIN_FIL_N", 12, "TEX_MIN_FIL_N", 12, "of.options.shaders.TEX_MIN_FIL_N", "TexMinFilN", "0"), 
    SHADER_PACK("SHADER_PACK", 8, "SHADER_PACK", 8, "of.options.shaders.SHADER_PACK", "shaderPack", ""), 
    TEX_MAG_FIL_S("TEX_MAG_FIL_S", 16, "TEX_MAG_FIL_S", 16, "of.options.shaders.TEX_MAG_FIL_S", "TexMagFilS", "0"), 
    HAND_DEPTH_MUL("HAND_DEPTH_MUL", 5, "HAND_DEPTH_MUL", 5, "of.options.shaders.HAND_DEPTH_MUL", "handDepthMul", "0.125"), 
    TWEAK_BLOCK_DAMAGE("TWEAK_BLOCK_DAMAGE", 9, "TWEAK_BLOCK_DAMAGE", 9, "of.options.shaders.TWEAK_BLOCK_DAMAGE", "tweakBlockDamage", "false"), 
    TEX_MAG_FIL_B("TEX_MAG_FIL_B", 14, "TEX_MAG_FIL_B", 14, "of.options.shaders.TEX_MAG_FIL_B", "TexMagFilB", "0"), 
    TEX_MIN_FIL_S("TEX_MIN_FIL_S", 13, "TEX_MIN_FIL_S", 13, "of.options.shaders.TEX_MIN_FIL_S", "TexMinFilS", "0"), 
    SHADOW_RES_MUL("SHADOW_RES_MUL", 4, "SHADOW_RES_MUL", 4, "of.options.shaders.SHADOW_RES_MUL", "shadowResMul", "1.0"), 
    TEX_MAG_FIL_N("TEX_MAG_FIL_N", 15, "TEX_MAG_FIL_N", 15, "of.options.shaders.TEX_MAG_FIL_N", "TexMagFilN", "0");
    
    private EnumShaderOption(final String lllllllllllllllIlIlIIIlIIlIllIll, final int lllllllllllllllIlIlIIIlIIlIllIlI, final String lllllllllllllllIlIlIIIlIIllIIIIl, final int lllllllllllllllIlIlIIIlIIllIIIII, final String lllllllllllllllIlIlIIIlIIlIllIIl, final String lllllllllllllllIlIlIIIlIIlIllIII, final String lllllllllllllllIlIlIIIlIIlIlIlll) {
        this.resourceKey = null;
        this.propertyKey = null;
        this.valueDefault = null;
        this.resourceKey = lllllllllllllllIlIlIIIlIIlIllIIl;
        this.propertyKey = lllllllllllllllIlIlIIIlIIlIllIII;
        this.valueDefault = lllllllllllllllIlIlIIIlIIlIlIlll;
    }
    
    public String getValueDefault() {
        return this.valueDefault;
    }
    
    public String getPropertyKey() {
        return this.propertyKey;
    }
    
    public String getResourceKey() {
        return this.resourceKey;
    }
}
