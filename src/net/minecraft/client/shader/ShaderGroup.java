package net.minecraft.client.shader;

import javax.vecmath.*;
import com.google.common.collect.*;
import net.minecraft.client.util.*;
import java.util.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.texture.*;
import com.google.gson.*;
import com.google.common.base.*;
import org.apache.commons.io.*;
import java.io.*;
import net.minecraft.client.resources.*;

public class ShaderGroup
{
    private final /* synthetic */ List listFramebuffers;
    private /* synthetic */ float field_148036_j;
    private /* synthetic */ IResourceManager resourceManager;
    private /* synthetic */ float field_148037_k;
    private /* synthetic */ Framebuffer mainFramebuffer;
    private final /* synthetic */ Map mapFramebuffers;
    private /* synthetic */ int mainFramebufferHeight;
    private /* synthetic */ int mainFramebufferWidth;
    private final /* synthetic */ List listShaders;
    private /* synthetic */ String shaderGroupName;
    private /* synthetic */ Matrix4f projectionMatrix;
    
    public void addFramebuffer(final String llllllllllllllIlIlllIlIIIIlllIll, final int llllllllllllllIlIlllIlIIIIlllIlI, final int llllllllllllllIlIlllIlIIIIllIlII) {
        final Framebuffer llllllllllllllIlIlllIlIIIIlllIII = new Framebuffer(llllllllllllllIlIlllIlIIIIlllIlI, llllllllllllllIlIlllIlIIIIllIlII, true);
        llllllllllllllIlIlllIlIIIIlllIII.setFramebufferColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.mapFramebuffers.put(llllllllllllllIlIlllIlIIIIlllIll, llllllllllllllIlIlllIlIIIIlllIII);
        if (llllllllllllllIlIlllIlIIIIlllIlI == this.mainFramebufferWidth && llllllllllllllIlIlllIlIIIIllIlII == this.mainFramebufferHeight) {
            this.listFramebuffers.add(llllllllllllllIlIlllIlIIIIlllIII);
        }
    }
    
    public ShaderGroup(final TextureManager llllllllllllllIlIlllIlIlIIIIIlIl, final IResourceManager llllllllllllllIlIlllIlIIllllllll, final Framebuffer llllllllllllllIlIlllIlIIlllllllI, final ResourceLocation llllllllllllllIlIlllIlIIllllllIl) throws JsonException {
        this.listShaders = Lists.newArrayList();
        this.mapFramebuffers = Maps.newHashMap();
        this.listFramebuffers = Lists.newArrayList();
        this.resourceManager = llllllllllllllIlIlllIlIIllllllll;
        this.mainFramebuffer = llllllllllllllIlIlllIlIIlllllllI;
        this.field_148036_j = 0.0f;
        this.field_148037_k = 0.0f;
        this.mainFramebufferWidth = llllllllllllllIlIlllIlIIlllllllI.framebufferWidth;
        this.mainFramebufferHeight = llllllllllllllIlIlllIlIIlllllllI.framebufferHeight;
        this.shaderGroupName = llllllllllllllIlIlllIlIIllllllIl.toString();
        this.resetProjectionMatrix();
        this.parseGroup(llllllllllllllIlIlllIlIlIIIIIlIl, llllllllllllllIlIlllIlIIllllllIl);
    }
    
    private void resetProjectionMatrix() {
        this.projectionMatrix = new Matrix4f();
        this.projectionMatrix.setIdentity();
        this.projectionMatrix.m00 = 2.0f / this.mainFramebuffer.framebufferTextureWidth;
        this.projectionMatrix.m11 = 2.0f / -this.mainFramebuffer.framebufferTextureHeight;
        this.projectionMatrix.m22 = -0.0020001999f;
        this.projectionMatrix.m33 = 1.0f;
        this.projectionMatrix.m03 = -1.0f;
        this.projectionMatrix.m13 = 1.0f;
        this.projectionMatrix.m23 = -1.0001999f;
    }
    
    public void loadShaderGroup(final float llllllllllllllIlIlllIlIIIIIIIIIl) {
        if (llllllllllllllIlIlllIlIIIIIIIIIl < this.field_148037_k) {
            this.field_148036_j += 1.0f - this.field_148037_k;
            this.field_148036_j += llllllllllllllIlIlllIlIIIIIIIIIl;
        }
        else {
            this.field_148036_j += llllllllllllllIlIlllIlIIIIIIIIIl - this.field_148037_k;
        }
        this.field_148037_k = llllllllllllllIlIlllIlIIIIIIIIIl;
        while (this.field_148036_j > 20.0f) {
            this.field_148036_j -= 20.0f;
        }
        for (final Shader llllllllllllllIlIlllIIllllllllll : this.listShaders) {
            llllllllllllllIlIlllIIllllllllll.loadShader(this.field_148036_j / 20.0f);
        }
    }
    
    private Framebuffer getFramebuffer(final String llllllllllllllIlIlllIIllllllIIlI) {
        return (llllllllllllllIlIlllIIllllllIIlI == null) ? null : (llllllllllllllIlIlllIIllllllIIlI.equals("minecraft:main") ? this.mainFramebuffer : this.mapFramebuffers.get(llllllllllllllIlIlllIIllllllIIlI));
    }
    
    public Shader addShader(final String llllllllllllllIlIlllIlIIIIlIIIlI, final Framebuffer llllllllllllllIlIlllIlIIIIlIIIIl, final Framebuffer llllllllllllllIlIlllIlIIIIlIIIII) throws JsonException {
        final Shader llllllllllllllIlIlllIlIIIIIlllll = new Shader(this.resourceManager, llllllllllllllIlIlllIlIIIIlIIIlI, llllllllllllllIlIlllIlIIIIlIIIIl, llllllllllllllIlIlllIlIIIIlIIIII);
        this.listShaders.add(this.listShaders.size(), llllllllllllllIlIlllIlIIIIIlllll);
        return llllllllllllllIlIlllIlIIIIIlllll;
    }
    
    private void parsePass(final TextureManager llllllllllllllIlIlllIlIIlIIIIIIl, final JsonElement llllllllllllllIlIlllIlIIlIIIIIII) throws JsonException {
        final JsonObject llllllllllllllIlIlllIlIIlIIlllll = JsonUtils.getElementAsJsonObject(llllllllllllllIlIlllIlIIlIIIIIII, "pass");
        final String llllllllllllllIlIlllIlIIlIIllllI = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIlIlllIlIIlIIlllll, "name");
        final String llllllllllllllIlIlllIlIIlIIlllIl = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIlIlllIlIIlIIlllll, "intarget");
        final String llllllllllllllIlIlllIlIIlIIlllII = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIlIlllIlIIlIIlllll, "outtarget");
        final Framebuffer llllllllllllllIlIlllIlIIlIIllIll = this.getFramebuffer(llllllllllllllIlIlllIlIIlIIlllIl);
        final Framebuffer llllllllllllllIlIlllIlIIlIIllIlI = this.getFramebuffer(llllllllllllllIlIlllIlIIlIIlllII);
        if (llllllllllllllIlIlllIlIIlIIllIll == null) {
            throw new JsonException(String.valueOf(new StringBuilder("Input target '").append(llllllllllllllIlIlllIlIIlIIlllIl).append("' does not exist")));
        }
        if (llllllllllllllIlIlllIlIIlIIllIlI == null) {
            throw new JsonException(String.valueOf(new StringBuilder("Output target '").append(llllllllllllllIlIlllIlIIlIIlllII).append("' does not exist")));
        }
        final Shader llllllllllllllIlIlllIlIIlIIllIIl = this.addShader(llllllllllllllIlIlllIlIIlIIllllI, llllllllllllllIlIlllIlIIlIIllIll, llllllllllllllIlIlllIlIIlIIllIlI);
        final JsonArray llllllllllllllIlIlllIlIIlIIllIII = JsonUtils.getJsonObjectJsonArrayFieldOrDefault(llllllllllllllIlIlllIlIIlIIlllll, "auxtargets", null);
        if (llllllllllllllIlIlllIlIIlIIllIII != null) {
            int llllllllllllllIlIlllIlIIlIIlIlll = 0;
            for (final JsonElement llllllllllllllIlIlllIlIIlIIlIlIl : llllllllllllllIlIlllIlIIlIIllIII) {
                try {
                    final JsonObject llllllllllllllIlIlllIlIIlIIlIlII = JsonUtils.getElementAsJsonObject(llllllllllllllIlIlllIlIIlIIlIlIl, "auxtarget");
                    final String llllllllllllllIlIlllIlIIlIIlIIll = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIlIlllIlIIlIIlIlII, "name");
                    final String llllllllllllllIlIlllIlIIlIIlIIlI = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIlIlllIlIIlIIlIlII, "id");
                    final Framebuffer llllllllllllllIlIlllIlIIlIIlIIIl = this.getFramebuffer(llllllllllllllIlIlllIlIIlIIlIIlI);
                    if (llllllllllllllIlIlllIlIIlIIlIIIl == null) {
                        final ResourceLocation llllllllllllllIlIlllIlIIlIIlIIII = new ResourceLocation(String.valueOf(new StringBuilder("textures/effect/").append(llllllllllllllIlIlllIlIIlIIlIIlI).append(".png")));
                        try {
                            this.resourceManager.getResource(llllllllllllllIlIlllIlIIlIIlIIII);
                        }
                        catch (FileNotFoundException llllllllllllllIlIlllIlIIlIIIllll) {
                            throw new JsonException(String.valueOf(new StringBuilder("Render target or texture '").append(llllllllllllllIlIlllIlIIlIIlIIlI).append("' does not exist")));
                        }
                        llllllllllllllIlIlllIlIIlIIIIIIl.bindTexture(llllllllllllllIlIlllIlIIlIIlIIII);
                        final ITextureObject llllllllllllllIlIlllIlIIlIIIlllI = llllllllllllllIlIlllIlIIlIIIIIIl.getTexture(llllllllllllllIlIlllIlIIlIIlIIII);
                        final int llllllllllllllIlIlllIlIIlIIIllIl = JsonUtils.getJsonObjectIntegerFieldValue(llllllllllllllIlIlllIlIIlIIlIlII, "width");
                        final int llllllllllllllIlIlllIlIIlIIIllII = JsonUtils.getJsonObjectIntegerFieldValue(llllllllllllllIlIlllIlIIlIIlIlII, "height");
                        final boolean llllllllllllllIlIlllIlIIlIIIlIll = JsonUtils.getJsonObjectBooleanFieldValue(llllllllllllllIlIlllIlIIlIIlIlII, "bilinear");
                        if (llllllllllllllIlIlllIlIIlIIIlIll) {
                            GL11.glTexParameteri(3553, 10241, 9729);
                            GL11.glTexParameteri(3553, 10240, 9729);
                        }
                        else {
                            GL11.glTexParameteri(3553, 10241, 9728);
                            GL11.glTexParameteri(3553, 10240, 9728);
                        }
                        llllllllllllllIlIlllIlIIlIIllIIl.addAuxFramebuffer(llllllllllllllIlIlllIlIIlIIlIIll, llllllllllllllIlIlllIlIIlIIIlllI.getGlTextureId(), llllllllllllllIlIlllIlIIlIIIllIl, llllllllllllllIlIlllIlIIlIIIllII);
                    }
                    else {
                        llllllllllllllIlIlllIlIIlIIllIIl.addAuxFramebuffer(llllllllllllllIlIlllIlIIlIIlIIll, llllllllllllllIlIlllIlIIlIIlIIIl, llllllllllllllIlIlllIlIIlIIlIIIl.framebufferTextureWidth, llllllllllllllIlIlllIlIIlIIlIIIl.framebufferTextureHeight);
                    }
                }
                catch (Exception llllllllllllllIlIlllIlIIlIIIlIlI) {
                    final JsonException llllllllllllllIlIlllIlIIlIIIlIIl = JsonException.func_151379_a(llllllllllllllIlIlllIlIIlIIIlIlI);
                    llllllllllllllIlIlllIlIIlIIIlIIl.func_151380_a(String.valueOf(new StringBuilder("auxtargets[").append(llllllllllllllIlIlllIlIIlIIlIlll).append("]")));
                    throw llllllllllllllIlIlllIlIIlIIIlIIl;
                }
                ++llllllllllllllIlIlllIlIIlIIlIlll;
            }
        }
        final JsonArray llllllllllllllIlIlllIlIIlIIIlIII = JsonUtils.getJsonObjectJsonArrayFieldOrDefault(llllllllllllllIlIlllIlIIlIIlllll, "uniforms", null);
        if (llllllllllllllIlIlllIlIIlIIIlIII != null) {
            int llllllllllllllIlIlllIlIIlIIIIlll = 0;
            for (final JsonElement llllllllllllllIlIlllIlIIlIIIIlIl : llllllllllllllIlIlllIlIIlIIIlIII) {
                try {
                    this.initUniform(llllllllllllllIlIlllIlIIlIIIIlIl);
                }
                catch (Exception llllllllllllllIlIlllIlIIlIIIIlII) {
                    final JsonException llllllllllllllIlIlllIlIIlIIIIIll = JsonException.func_151379_a(llllllllllllllIlIlllIlIIlIIIIlII);
                    llllllllllllllIlIlllIlIIlIIIIIll.func_151380_a(String.valueOf(new StringBuilder("uniforms[").append(llllllllllllllIlIlllIlIIlIIIIlll).append("]")));
                    throw llllllllllllllIlIlllIlIIlIIIIIll;
                }
                ++llllllllllllllIlIlllIlIIlIIIIlll;
            }
        }
    }
    
    public Framebuffer func_177066_a(final String llllllllllllllIlIlllIlIIIlIIIlII) {
        return this.mapFramebuffers.get(llllllllllllllIlIlllIlIIIlIIIlII);
    }
    
    private void initUniform(final JsonElement llllllllllllllIlIlllIlIIIlIlIIlI) throws JsonException {
        final JsonObject llllllllllllllIlIlllIlIIIlIlllIl = JsonUtils.getElementAsJsonObject(llllllllllllllIlIlllIlIIIlIlIIlI, "uniform");
        final String llllllllllllllIlIlllIlIIIlIlllII = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIlIlllIlIIIlIlllIl, "name");
        final ShaderUniform llllllllllllllIlIlllIlIIIlIllIll = this.listShaders.get(this.listShaders.size() - 1).getShaderManager().getShaderUniform(llllllllllllllIlIlllIlIIIlIlllII);
        if (llllllllllllllIlIlllIlIIIlIllIll == null) {
            throw new JsonException(String.valueOf(new StringBuilder("Uniform '").append(llllllllllllllIlIlllIlIIIlIlllII).append("' does not exist")));
        }
        final float[] llllllllllllllIlIlllIlIIIlIllIlI = new float[4];
        int llllllllllllllIlIlllIlIIIlIllIIl = 0;
        final JsonArray llllllllllllllIlIlllIlIIIlIllIII = JsonUtils.getJsonObjectJsonArrayField(llllllllllllllIlIlllIlIIIlIlllIl, "values");
        for (final JsonElement llllllllllllllIlIlllIlIIIlIlIllI : llllllllllllllIlIlllIlIIIlIllIII) {
            try {
                llllllllllllllIlIlllIlIIIlIllIlI[llllllllllllllIlIlllIlIIIlIllIIl] = JsonUtils.getJsonElementFloatValue(llllllllllllllIlIlllIlIIIlIlIllI, "value");
            }
            catch (Exception llllllllllllllIlIlllIlIIIlIlIlIl) {
                final JsonException llllllllllllllIlIlllIlIIIlIlIlII = JsonException.func_151379_a(llllllllllllllIlIlllIlIIIlIlIlIl);
                llllllllllllllIlIlllIlIIIlIlIlII.func_151380_a(String.valueOf(new StringBuilder("values[").append(llllllllllllllIlIlllIlIIIlIllIIl).append("]")));
                throw llllllllllllllIlIlllIlIIIlIlIlII;
            }
            ++llllllllllllllIlIlllIlIIIlIllIIl;
        }
        switch (llllllllllllllIlIlllIlIIIlIllIIl) {
            case 1: {
                llllllllllllllIlIlllIlIIIlIllIll.set(llllllllllllllIlIlllIlIIIlIllIlI[0]);
                break;
            }
            case 2: {
                llllllllllllllIlIlllIlIIIlIllIll.set(llllllllllllllIlIlllIlIIIlIllIlI[0], llllllllllllllIlIlllIlIIIlIllIlI[1]);
                break;
            }
            case 3: {
                llllllllllllllIlIlllIlIIIlIllIll.set(llllllllllllllIlIlllIlIIIlIllIlI[0], llllllllllllllIlIlllIlIIIlIllIlI[1], llllllllllllllIlIlllIlIIIlIllIlI[2]);
                break;
            }
            case 4: {
                llllllllllllllIlIlllIlIIIlIllIll.set(llllllllllllllIlIlllIlIIIlIllIlI[0], llllllllllllllIlIlllIlIIIlIllIlI[1], llllllllllllllIlIlllIlIIIlIllIlI[2], llllllllllllllIlIlllIlIIIlIllIlI[3]);
                break;
            }
        }
    }
    
    public void deleteShaderGroup() {
        for (final Framebuffer llllllllllllllIlIlllIlIIIIlIllIl : this.mapFramebuffers.values()) {
            llllllllllllllIlIlllIlIIIIlIllIl.deleteFramebuffer();
        }
        for (final Shader llllllllllllllIlIlllIlIIIIlIllII : this.listShaders) {
            llllllllllllllIlIlllIlIIIIlIllII.deleteShader();
        }
        this.listShaders.clear();
    }
    
    public void parseGroup(final TextureManager llllllllllllllIlIlllIlIIllIllIII, final ResourceLocation llllllllllllllIlIlllIlIIllIlIlll) throws JsonException {
        final JsonParser llllllllllllllIlIlllIlIIlllIlIll = new JsonParser();
        InputStream llllllllllllllIlIlllIlIIlllIlIlI = null;
        try {
            final IResource llllllllllllllIlIlllIlIIlllIlIIl = this.resourceManager.getResource(llllllllllllllIlIlllIlIIllIlIlll);
            llllllllllllllIlIlllIlIIlllIlIlI = llllllllllllllIlIlllIlIIlllIlIIl.getInputStream();
            final JsonObject llllllllllllllIlIlllIlIIlllIlIII = llllllllllllllIlIlllIlIIlllIlIll.parse(IOUtils.toString(llllllllllllllIlIlllIlIIlllIlIlI, Charsets.UTF_8)).getAsJsonObject();
            if (JsonUtils.jsonObjectFieldTypeIsArray(llllllllllllllIlIlllIlIIlllIlIII, "targets")) {
                final JsonArray llllllllllllllIlIlllIlIIlllIIlll = llllllllllllllIlIlllIlIIlllIlIII.getAsJsonArray("targets");
                int llllllllllllllIlIlllIlIIlllIIlIl = 0;
                for (final JsonElement llllllllllllllIlIlllIlIIlllIIIIl : llllllllllllllIlIlllIlIIlllIIlll) {
                    try {
                        this.initTarget(llllllllllllllIlIlllIlIIlllIIIIl);
                    }
                    catch (Exception llllllllllllllIlIlllIlIIllIlllIl) {
                        final JsonException llllllllllllllIlIlllIlIIllIlllll = JsonException.func_151379_a(llllllllllllllIlIlllIlIIllIlllIl);
                        llllllllllllllIlIlllIlIIllIlllll.func_151380_a(String.valueOf(new StringBuilder("targets[").append(llllllllllllllIlIlllIlIIlllIIlIl).append("]")));
                        throw llllllllllllllIlIlllIlIIllIlllll;
                    }
                    ++llllllllllllllIlIlllIlIIlllIIlIl;
                }
            }
            if (JsonUtils.jsonObjectFieldTypeIsArray(llllllllllllllIlIlllIlIIlllIlIII, "passes")) {
                final JsonArray llllllllllllllIlIlllIlIIlllIIllI = llllllllllllllIlIlllIlIIlllIlIII.getAsJsonArray("passes");
                int llllllllllllllIlIlllIlIIlllIIlII = 0;
                for (final JsonElement llllllllllllllIlIlllIlIIlllIIIII : llllllllllllllIlIlllIlIIlllIIllI) {
                    try {
                        this.parsePass(llllllllllllllIlIlllIlIIllIllIII, llllllllllllllIlIlllIlIIlllIIIII);
                    }
                    catch (Exception llllllllllllllIlIlllIlIIllIlllII) {
                        final JsonException llllllllllllllIlIlllIlIIllIllllI = JsonException.func_151379_a(llllllllllllllIlIlllIlIIllIlllII);
                        llllllllllllllIlIlllIlIIllIllllI.func_151380_a(String.valueOf(new StringBuilder("passes[").append(llllllllllllllIlIlllIlIIlllIIlII).append("]")));
                        throw llllllllllllllIlIlllIlIIllIllllI;
                    }
                    ++llllllllllllllIlIlllIlIIlllIIlII;
                }
            }
        }
        catch (Exception llllllllllllllIlIlllIlIIllIllIll) {
            final JsonException llllllllllllllIlIlllIlIIllIllIlI = JsonException.func_151379_a(llllllllllllllIlIlllIlIIllIllIll);
            llllllllllllllIlIlllIlIIllIllIlI.func_151381_b(llllllllllllllIlIlllIlIIllIlIlll.getResourcePath());
            throw llllllllllllllIlIlllIlIIllIllIlI;
        }
        finally {
            IOUtils.closeQuietly(llllllllllllllIlIlllIlIIlllIlIlI);
        }
        IOUtils.closeQuietly(llllllllllllllIlIlllIlIIlllIlIlI);
    }
    
    static {
        __OBFID = "CL_00001041";
    }
    
    private void initTarget(final JsonElement llllllllllllllIlIlllIlIIllIIIlII) throws JsonException {
        if (JsonUtils.jsonElementTypeIsString(llllllllllllllIlIlllIlIIllIIIlII)) {
            this.addFramebuffer(llllllllllllllIlIlllIlIIllIIIlII.getAsString(), this.mainFramebufferWidth, this.mainFramebufferHeight);
        }
        else {
            final JsonObject llllllllllllllIlIlllIlIIllIIIIll = JsonUtils.getElementAsJsonObject(llllllllllllllIlIlllIlIIllIIIlII, "target");
            final String llllllllllllllIlIlllIlIIllIIIIlI = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIlIlllIlIIllIIIIll, "name");
            final int llllllllllllllIlIlllIlIIllIIIIIl = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllIlIlllIlIIllIIIIll, "width", this.mainFramebufferWidth);
            final int llllllllllllllIlIlllIlIIllIIIIII = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllIlIlllIlIIllIIIIll, "height", this.mainFramebufferHeight);
            if (this.mapFramebuffers.containsKey(llllllllllllllIlIlllIlIIllIIIIlI)) {
                throw new JsonException(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIlllIlIIllIIIIlI)).append(" is already defined")));
            }
            this.addFramebuffer(llllllllllllllIlIlllIlIIllIIIIlI, llllllllllllllIlIlllIlIIllIIIIIl, llllllllllllllIlIlllIlIIllIIIIII);
        }
    }
    
    public void createBindFramebuffers(final int llllllllllllllIlIlllIlIIIIIlIIII, final int llllllllllllllIlIlllIlIIIIIIllll) {
        this.mainFramebufferWidth = this.mainFramebuffer.framebufferTextureWidth;
        this.mainFramebufferHeight = this.mainFramebuffer.framebufferTextureHeight;
        this.resetProjectionMatrix();
        for (final Shader llllllllllllllIlIlllIlIIIIIIllIl : this.listShaders) {
            llllllllllllllIlIlllIlIIIIIIllIl.setProjectionMatrix(this.projectionMatrix);
        }
        for (final Framebuffer llllllllllllllIlIlllIlIIIIIIllII : this.listFramebuffers) {
            llllllllllllllIlIlllIlIIIIIIllII.createBindFramebuffer(llllllllllllllIlIlllIlIIIIIlIIII, llllllllllllllIlIlllIlIIIIIIllll);
        }
    }
    
    public final String getShaderGroupName() {
        return this.shaderGroupName;
    }
}
