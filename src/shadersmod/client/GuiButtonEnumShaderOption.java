package shadersmod.client;

import net.minecraft.client.gui.*;
import net.minecraft.client.resources.*;

public class GuiButtonEnumShaderOption extends GuiButton
{
    private /* synthetic */ EnumShaderOption enumShaderOption;
    
    public EnumShaderOption getEnumShaderOption() {
        return this.enumShaderOption;
    }
    
    public void updateButtonText() {
        this.displayString = getButtonText(this.enumShaderOption);
    }
    
    public GuiButtonEnumShaderOption(final EnumShaderOption llllllllllllllllIlIIlIIIlllIIlIl, final int llllllllllllllllIlIIlIIIlllIIlII, final int llllllllllllllllIlIIlIIIlllIIIll, final int llllllllllllllllIlIIlIIIllIlllII, final int llllllllllllllllIlIIlIIIlllIIIIl) {
        super(llllllllllllllllIlIIlIIIlllIIlIl.ordinal(), llllllllllllllllIlIIlIIIlllIIlII, llllllllllllllllIlIIlIIIlllIIIll, llllllllllllllllIlIIlIIIllIlllII, llllllllllllllllIlIIlIIIlllIIIIl, getButtonText(llllllllllllllllIlIIlIIIlllIIlIl));
        this.enumShaderOption = null;
        this.enumShaderOption = llllllllllllllllIlIIlIIIlllIIlIl;
    }
    
    private static String getButtonText(final EnumShaderOption llllllllllllllllIlIIlIIIllIlIlIl) {
        final String llllllllllllllllIlIIlIIIllIlIlII = String.valueOf(new StringBuilder(String.valueOf(I18n.format(llllllllllllllllIlIIlIIIllIlIlIl.getResourceKey(), new Object[0]))).append(": "));
        switch (NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[llllllllllllllllIlIIlIIIllIlIlIl.ordinal()]) {
            case 1: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(GuiShaders.toStringAa(Shaders.configAntialiasingLevel)));
            }
            case 2: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(GuiShaders.toStringOnOff(Shaders.configNormalMap)));
            }
            case 3: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(GuiShaders.toStringOnOff(Shaders.configSpecularMap)));
            }
            case 4: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(GuiShaders.toStringQuality(Shaders.configRenderResMul)));
            }
            case 5: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(GuiShaders.toStringQuality(Shaders.configShadowResMul)));
            }
            case 6: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(GuiShaders.toStringHandDepth(Shaders.configHandDepthMul)));
            }
            case 7: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(GuiShaders.toStringOnOff(Shaders.configCloudShadow)));
            }
            case 8: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(Shaders.configOldLighting.getUserValue()));
            }
            case 9: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(GuiShaders.toStringOnOff(Shaders.configShadowClipFrustrum)));
            }
            case 10: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(GuiShaders.toStringOnOff(Shaders.configTweakBlockDamage)));
            }
            default: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIIllIlIlII)).append(Shaders.getEnumShaderOption(llllllllllllllllIlIIlIIIllIlIlIl)));
            }
        }
    }
    
    static class NamelessClass895471824
    {
        static final /* synthetic */ int[] $SwitchMap$shadersmod$client$EnumShaderOption;
        
        static {
            $SwitchMap$shadersmod$client$EnumShaderOption = new int[EnumShaderOption.values().length];
            try {
                NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.ANTIALIASING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.NORMAL_MAP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.SPECULAR_MAP.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.RENDER_RES_MUL.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.SHADOW_RES_MUL.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.HAND_DEPTH_MUL.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.CLOUD_SHADOW.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.OLD_LIGHTING.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.SHADOW_CLIP_FRUSTRUM.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                NamelessClass895471824.$SwitchMap$shadersmod$client$EnumShaderOption[EnumShaderOption.TWEAK_BLOCK_DAMAGE.ordinal()] = 10;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
        }
    }
}
