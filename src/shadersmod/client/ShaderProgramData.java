package shadersmod.client;

import org.lwjgl.opengl.*;

public class ShaderProgramData
{
    public /* synthetic */ int uniform_gdepth;
    public /* synthetic */ int uniform_gbufferProjectionInverse;
    public /* synthetic */ int uniform_fogMode;
    public /* synthetic */ int uniform_gnormal;
    public /* synthetic */ int uniform_aspectRatio;
    public /* synthetic */ int uniform_colortex3;
    public /* synthetic */ int uniform_gaux3;
    public /* synthetic */ int uniform_wetness;
    public /* synthetic */ int uniform_heldItemId;
    public /* synthetic */ int programIDGL;
    public /* synthetic */ int uniform_gaux1;
    public /* synthetic */ int uniform_terrainTextureSize;
    public /* synthetic */ int uniform_gbufferPreviousProjection;
    public /* synthetic */ int uniform_gbufferModelViewInverse;
    public /* synthetic */ int uniform_far;
    public /* synthetic */ int uniform_eyeAltitude;
    public /* synthetic */ int uniform_worldTime;
    public /* synthetic */ int uniform_gcolor;
    public /* synthetic */ int uniform_shadowtex1;
    public /* synthetic */ int uniform_isEyeInWater;
    public /* synthetic */ int uniform_previousCameraPosition;
    public /* synthetic */ int uniform_atlasSize;
    public /* synthetic */ int uniform_gbufferPreviousModelView;
    public /* synthetic */ int uniform_colortex4;
    public /* synthetic */ int uniform_heldBlockLightValue;
    public /* synthetic */ int uniform_noisetex;
    public /* synthetic */ int uniform_hideGUI;
    public /* synthetic */ int uniform_gbufferProjection;
    public /* synthetic */ int uniform_gdepthtex;
    public /* synthetic */ int uniform_moonPosition;
    public /* synthetic */ int uniform_shadowProjectionInverse;
    public /* synthetic */ int uniform_shadowModelViewInverse;
    public /* synthetic */ int uniform_rainStrength;
    public /* synthetic */ int uniform_watershadow;
    public /* synthetic */ int uniform_sunPosition;
    public /* synthetic */ int uniform_depthtex2;
    public /* synthetic */ int uniform_texture;
    public /* synthetic */ int uniform_depthtex0;
    public /* synthetic */ int uniform_moonPhase;
    public /* synthetic */ int uniform_shadowcolor0;
    public /* synthetic */ int uniform_upPosition;
    public /* synthetic */ int uniform_viewHeight;
    public /* synthetic */ int uniform_skyColor;
    public /* synthetic */ int uniform_eyeBrightnessSmooth;
    public /* synthetic */ int uniform_tex;
    public /* synthetic */ int uniform_fogColor;
    public /* synthetic */ int uniform_shadowcolor;
    public /* synthetic */ int uniform_colortex6;
    public /* synthetic */ int uniform_frameTimeCounter;
    public /* synthetic */ int uniform_colortex1;
    public /* synthetic */ int uniform_sunAngle;
    public /* synthetic */ int uniform_shadowtex0;
    public /* synthetic */ int uniform_colortex2;
    public /* synthetic */ int uniform_specular;
    public /* synthetic */ int uniform_terrainIconSize;
    public /* synthetic */ int uniform_viewWidth;
    public /* synthetic */ int uniform_shadowProjection;
    public /* synthetic */ int uniform_gaux4;
    public /* synthetic */ int uniform_gaux2;
    public /* synthetic */ int uniform_colortex0;
    public /* synthetic */ int uniform_shadowModelView;
    public /* synthetic */ int uniform_gbufferModelView;
    public /* synthetic */ int uniform_cameraPosition;
    public /* synthetic */ int uniform_normals;
    public /* synthetic */ int uniform_colortex7;
    public /* synthetic */ int uniform_centerDepthSmooth;
    public /* synthetic */ int uniform_lightmap;
    public /* synthetic */ int uniform_shadowcolor1;
    public /* synthetic */ int uniform_shadowAngle;
    public /* synthetic */ int uniform_depthtex1;
    public /* synthetic */ int uniform_near;
    public /* synthetic */ int uniform_composite;
    public /* synthetic */ int uniform_eyeBrightness;
    public /* synthetic */ int uniform_colortex5;
    public /* synthetic */ int uniform_shadow;
    
    public ShaderProgramData(final int lllllllllllllllIIlIlIlIllIlIlIII) {
        this.programIDGL = lllllllllllllllIIlIlIlIllIlIlIII;
        this.uniform_texture = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"texture");
        this.uniform_lightmap = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"lightmap");
        this.uniform_normals = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"normals");
        this.uniform_specular = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"specular");
        this.uniform_shadow = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadow");
        this.uniform_watershadow = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"watershadow");
        this.uniform_shadowtex0 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadowtex0");
        this.uniform_shadowtex1 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadowtex1");
        this.uniform_depthtex0 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"depthtex0");
        this.uniform_depthtex1 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"depthtex1");
        this.uniform_shadowcolor = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadowcolor");
        this.uniform_shadowcolor0 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadowcolor0");
        this.uniform_shadowcolor1 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadowcolor1");
        this.uniform_noisetex = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"noisetex");
        this.uniform_gcolor = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gcolor");
        this.uniform_gdepth = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gdepth");
        this.uniform_gnormal = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gnormal");
        this.uniform_composite = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"composite");
        this.uniform_gaux1 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gaux1");
        this.uniform_gaux2 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gaux2");
        this.uniform_gaux3 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gaux3");
        this.uniform_gaux4 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gaux4");
        this.uniform_colortex0 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"colortex0");
        this.uniform_colortex1 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"colortex1");
        this.uniform_colortex2 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"colortex2");
        this.uniform_colortex3 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"colortex3");
        this.uniform_colortex4 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"colortex4");
        this.uniform_colortex5 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"colortex5");
        this.uniform_colortex6 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"colortex6");
        this.uniform_colortex7 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"colortex7");
        this.uniform_gdepthtex = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gdepthtex");
        this.uniform_depthtex2 = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"depthtex2");
        this.uniform_tex = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"tex");
        this.uniform_heldItemId = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"heldItemId");
        this.uniform_heldBlockLightValue = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"heldBlockLightValue");
        this.uniform_fogMode = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"fogMode");
        this.uniform_fogColor = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"fogColor");
        this.uniform_skyColor = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"skyColor");
        this.uniform_worldTime = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"worldTime");
        this.uniform_moonPhase = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"moonPhase");
        this.uniform_frameTimeCounter = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"frameTimeCounter");
        this.uniform_sunAngle = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"sunAngle");
        this.uniform_shadowAngle = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadowAngle");
        this.uniform_rainStrength = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"rainStrength");
        this.uniform_aspectRatio = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"aspectRatio");
        this.uniform_viewWidth = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"viewWidth");
        this.uniform_viewHeight = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"viewHeight");
        this.uniform_near = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"near");
        this.uniform_far = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"far");
        this.uniform_sunPosition = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"sunPosition");
        this.uniform_moonPosition = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"moonPosition");
        this.uniform_upPosition = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"upPosition");
        this.uniform_previousCameraPosition = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"previousCameraPosition");
        this.uniform_cameraPosition = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"cameraPosition");
        this.uniform_gbufferModelView = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gbufferModelView");
        this.uniform_gbufferModelViewInverse = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gbufferModelViewInverse");
        this.uniform_gbufferPreviousProjection = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gbufferPreviousProjection");
        this.uniform_gbufferProjection = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gbufferProjection");
        this.uniform_gbufferProjectionInverse = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gbufferProjectionInverse");
        this.uniform_gbufferPreviousModelView = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"gbufferPreviousModelView");
        this.uniform_shadowProjection = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadowProjection");
        this.uniform_shadowProjectionInverse = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadowProjectionInverse");
        this.uniform_shadowModelView = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadowModelView");
        this.uniform_shadowModelViewInverse = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"shadowModelViewInverse");
        this.uniform_wetness = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"wetness");
        this.uniform_eyeAltitude = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"eyeAltitude");
        this.uniform_eyeBrightness = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"eyeBrightness");
        this.uniform_eyeBrightnessSmooth = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"eyeBrightnessSmooth");
        this.uniform_terrainTextureSize = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"terrainTextureSize");
        this.uniform_terrainIconSize = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"terrainIconSize");
        this.uniform_isEyeInWater = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"isEyeInWater");
        this.uniform_hideGUI = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"hideGUI");
        this.uniform_centerDepthSmooth = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"centerDepthSmooth");
        this.uniform_atlasSize = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIlIlIlIllIlIlIII, (CharSequence)"atlasSize");
    }
}
