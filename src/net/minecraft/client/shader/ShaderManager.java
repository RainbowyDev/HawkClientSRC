package net.minecraft.client.shader;

import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;
import com.google.gson.*;
import net.minecraft.util.*;
import com.google.common.base.*;
import org.apache.commons.io.*;
import java.io.*;
import org.apache.logging.log4j.*;

public class ShaderManager
{
    private final /* synthetic */ JsonBlendingMode field_148016_p;
    private static final /* synthetic */ ShaderDefault defaultShaderUniform;
    private final /* synthetic */ ShaderLoader fragmentShaderLoader;
    private static /* synthetic */ boolean field_148000_e;
    private final /* synthetic */ List samplerNames;
    private static /* synthetic */ ShaderManager staticShaderManager;
    private static /* synthetic */ int currentProgram;
    private /* synthetic */ boolean isDirty;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ int program;
    private final /* synthetic */ List shaderUniforms;
    private final /* synthetic */ List field_148014_r;
    private final /* synthetic */ List field_148015_q;
    private final /* synthetic */ List shaderSamplerLocations;
    private final /* synthetic */ Map mappedShaderUniforms;
    private final /* synthetic */ Map shaderSamplers;
    private final /* synthetic */ List shaderUniformLocations;
    private final /* synthetic */ ShaderLoader vertexShaderLoader;
    private final /* synthetic */ boolean useFaceCulling;
    private final /* synthetic */ String programFilename;
    
    public void useShader() {
        this.isDirty = false;
        ShaderManager.staticShaderManager = this;
        this.field_148016_p.func_148109_a();
        if (this.program != ShaderManager.currentProgram) {
            OpenGlHelper.glUseProgram(this.program);
            ShaderManager.currentProgram = this.program;
        }
        if (this.useFaceCulling) {
            GlStateManager.enableCull();
        }
        else {
            GlStateManager.disableCull();
        }
        for (int llllllllllllllIIlIllllIlIlIlllII = 0; llllllllllllllIIlIllllIlIlIlllII < this.shaderSamplerLocations.size(); ++llllllllllllllIIlIllllIlIlIlllII) {
            if (this.shaderSamplers.get(this.samplerNames.get(llllllllllllllIIlIllllIlIlIlllII)) != null) {
                GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllllllIIlIllllIlIlIlllII);
                GlStateManager.func_179098_w();
                final Object llllllllllllllIIlIllllIlIlIllIll = this.shaderSamplers.get(this.samplerNames.get(llllllllllllllIIlIllllIlIlIlllII));
                int llllllllllllllIIlIllllIlIlIllIlI = -1;
                if (llllllllllllllIIlIllllIlIlIllIll instanceof Framebuffer) {
                    llllllllllllllIIlIllllIlIlIllIlI = ((Framebuffer)llllllllllllllIIlIllllIlIlIllIll).framebufferTexture;
                }
                else if (llllllllllllllIIlIllllIlIlIllIll instanceof ITextureObject) {
                    llllllllllllllIIlIllllIlIlIllIlI = ((ITextureObject)llllllllllllllIIlIllllIlIlIllIll).getGlTextureId();
                }
                else if (llllllllllllllIIlIllllIlIlIllIll instanceof Integer) {
                    llllllllllllllIIlIllllIlIlIllIlI = (int)llllllllllllllIIlIllllIlIlIllIll;
                }
                if (llllllllllllllIIlIllllIlIlIllIlI != -1) {
                    GlStateManager.func_179144_i(llllllllllllllIIlIllllIlIlIllIlI);
                    OpenGlHelper.glUniform1i(OpenGlHelper.glGetUniformLocation(this.program, this.samplerNames.get(llllllllllllllIIlIllllIlIlIlllII)), llllllllllllllIIlIllllIlIlIlllII);
                }
            }
        }
        for (final ShaderUniform llllllllllllllIIlIllllIlIlIllIII : this.shaderUniforms) {
            llllllllllllllIIlIllllIlIlIllIII.upload();
        }
    }
    
    private void parseUniform(final JsonElement llllllllllllllIIlIllllIlIIIIllII) throws JsonException {
        final JsonObject llllllllllllllIIlIllllIlIIIIlIll = JsonUtils.getElementAsJsonObject(llllllllllllllIIlIllllIlIIIIllII, "uniform");
        final String llllllllllllllIIlIllllIlIIIIlIlI = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIIlIllllIlIIIIlIll, "name");
        final int llllllllllllllIIlIllllIlIIIIlIIl = ShaderUniform.parseType(JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIIlIllllIlIIIIlIll, "type"));
        final int llllllllllllllIIlIllllIlIIIIlIII = JsonUtils.getJsonObjectIntegerFieldValue(llllllllllllllIIlIllllIlIIIIlIll, "count");
        final float[] llllllllllllllIIlIllllIlIIIIIlll = new float[Math.max(llllllllllllllIIlIllllIlIIIIlIII, 16)];
        final JsonArray llllllllllllllIIlIllllIlIIIIIllI = JsonUtils.getJsonObjectJsonArrayField(llllllllllllllIIlIllllIlIIIIlIll, "values");
        if (llllllllllllllIIlIllllIlIIIIIllI.size() != llllllllllllllIIlIllllIlIIIIlIII && llllllllllllllIIlIllllIlIIIIIllI.size() > 1) {
            throw new JsonException(String.valueOf(new StringBuilder("Invalid amount of values specified (expected ").append(llllllllllllllIIlIllllIlIIIIlIII).append(", found ").append(llllllllllllllIIlIllllIlIIIIIllI.size()).append(")")));
        }
        int llllllllllllllIIlIllllIlIIIIIlIl = 0;
        for (final JsonElement llllllllllllllIIlIllllIlIIIIIIll : llllllllllllllIIlIllllIlIIIIIllI) {
            try {
                llllllllllllllIIlIllllIlIIIIIlll[llllllllllllllIIlIllllIlIIIIIlIl] = JsonUtils.getJsonElementFloatValue(llllllllllllllIIlIllllIlIIIIIIll, "value");
            }
            catch (Exception llllllllllllllIIlIllllIlIIIIIIlI) {
                final JsonException llllllllllllllIIlIllllIlIIIIIIIl = JsonException.func_151379_a(llllllllllllllIIlIllllIlIIIIIIlI);
                llllllllllllllIIlIllllIlIIIIIIIl.func_151380_a(String.valueOf(new StringBuilder("values[").append(llllllllllllllIIlIllllIlIIIIIlIl).append("]")));
                throw llllllllllllllIIlIllllIlIIIIIIIl;
            }
            ++llllllllllllllIIlIllllIlIIIIIlIl;
        }
        if (llllllllllllllIIlIllllIlIIIIlIII > 1 && llllllllllllllIIlIllllIlIIIIIllI.size() == 1) {
            while (llllllllllllllIIlIllllIlIIIIIlIl < llllllllllllllIIlIllllIlIIIIlIII) {
                llllllllllllllIIlIllllIlIIIIIlll[llllllllllllllIIlIllllIlIIIIIlIl] = llllllllllllllIIlIllllIlIIIIIlll[0];
                ++llllllllllllllIIlIllllIlIIIIIlIl;
            }
        }
        final int llllllllllllllIIlIllllIlIIIIIIII = (llllllllllllllIIlIllllIlIIIIlIII > 1 && llllllllllllllIIlIllllIlIIIIlIII <= 4 && llllllllllllllIIlIllllIlIIIIlIIl < 8) ? (llllllllllllllIIlIllllIlIIIIlIII - 1) : 0;
        final ShaderUniform llllllllllllllIIlIllllIIllllllll = new ShaderUniform(llllllllllllllIIlIllllIlIIIIlIlI, llllllllllllllIIlIllllIlIIIIlIIl + llllllllllllllIIlIllllIlIIIIIIII, llllllllllllllIIlIllllIlIIIIlIII, this);
        if (llllllllllllllIIlIllllIlIIIIlIIl <= 3) {
            llllllllllllllIIlIllllIIllllllll.set((int)llllllllllllllIIlIllllIlIIIIIlll[0], (int)llllllllllllllIIlIllllIlIIIIIlll[1], (int)llllllllllllllIIlIllllIlIIIIIlll[2], (int)llllllllllllllIIlIllllIlIIIIIlll[3]);
        }
        else if (llllllllllllllIIlIllllIlIIIIlIIl <= 7) {
            llllllllllllllIIlIllllIIllllllll.func_148092_b(llllllllllllllIIlIllllIlIIIIIlll[0], llllllllllllllIIlIllllIlIIIIIlll[1], llllllllllllllIIlIllllIlIIIIIlll[2], llllllllllllllIIlIllllIlIIIIIlll[3]);
        }
        else {
            llllllllllllllIIlIllllIIllllllll.set(llllllllllllllIIlIllllIlIIIIIlll);
        }
        this.shaderUniforms.add(llllllllllllllIIlIllllIIllllllll);
    }
    
    public void endShader() {
        OpenGlHelper.glUseProgram(0);
        ShaderManager.currentProgram = -1;
        ShaderManager.staticShaderManager = null;
        ShaderManager.field_148000_e = true;
        for (int llllllllllllllIIlIllllIlIllIIlII = 0; llllllllllllllIIlIllllIlIllIIlII < this.shaderSamplerLocations.size(); ++llllllllllllllIIlIllllIlIllIIlII) {
            if (this.shaderSamplers.get(this.samplerNames.get(llllllllllllllIIlIllllIlIllIIlII)) != null) {
                GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllllllIIlIllllIlIllIIlII);
                GlStateManager.func_179144_i(0);
            }
        }
    }
    
    public ShaderUniform getShaderUniform(final String llllllllllllllIIlIllllIlIlIIllIl) {
        return this.mappedShaderUniforms.containsKey(llllllllllllllIIlIllllIlIlIIllIl) ? this.mappedShaderUniforms.get(llllllllllllllIIlIllllIlIlIIllIl) : null;
    }
    
    public ShaderUniform getShaderUniformOrDefault(final String llllllllllllllIIlIllllIlIlIIIlll) {
        return this.mappedShaderUniforms.containsKey(llllllllllllllIIlIllllIlIlIIIlll) ? this.mappedShaderUniforms.get(llllllllllllllIIlIllllIlIlIIIlll) : ShaderManager.defaultShaderUniform;
    }
    
    public void addSamplerTexture(final String llllllllllllllIIlIllllIlIIIlllll, final Object llllllllllllllIIlIllllIlIIIllIll) {
        if (this.shaderSamplers.containsKey(llllllllllllllIIlIllllIlIIIlllll)) {
            this.shaderSamplers.remove(llllllllllllllIIlIllllIlIIIlllll);
        }
        this.shaderSamplers.put(llllllllllllllIIlIllllIlIIIlllll, llllllllllllllIIlIllllIlIIIllIll);
        this.markDirty();
    }
    
    private void setupUniforms() {
        for (int llllllllllllllIIlIllllIlIIllllIl = 0, llllllllllllllIIlIllllIlIIlllIII = 0; llllllllllllllIIlIllllIlIIllllIl < this.samplerNames.size(); ++llllllllllllllIIlIllllIlIIllllIl, ++llllllllllllllIIlIllllIlIIlllIII) {
            final String llllllllllllllIIlIllllIlIIllllII = this.samplerNames.get(llllllllllllllIIlIllllIlIIllllIl);
            final int llllllllllllllIIlIllllIlIIlllIlI = OpenGlHelper.glGetUniformLocation(this.program, llllllllllllllIIlIllllIlIIllllII);
            if (llllllllllllllIIlIllllIlIIlllIlI == -1) {
                ShaderManager.logger.warn(String.valueOf(new StringBuilder("Shader ").append(this.programFilename).append("could not find sampler named ").append(llllllllllllllIIlIllllIlIIllllII).append(" in the specified shader program.")));
                this.shaderSamplers.remove(llllllllllllllIIlIllllIlIIllllII);
                this.samplerNames.remove(llllllllllllllIIlIllllIlIIlllIII);
                --llllllllllllllIIlIllllIlIIlllIII;
            }
            else {
                this.shaderSamplerLocations.add(llllllllllllllIIlIllllIlIIlllIlI);
            }
        }
        for (final ShaderUniform llllllllllllllIIlIllllIlIIllIllI : this.shaderUniforms) {
            final String llllllllllllllIIlIllllIlIIlllIll = llllllllllllllIIlIllllIlIIllIllI.getShaderName();
            final int llllllllllllllIIlIllllIlIIlllIIl = OpenGlHelper.glGetUniformLocation(this.program, llllllllllllllIIlIllllIlIIlllIll);
            if (llllllllllllllIIlIllllIlIIlllIIl == -1) {
                ShaderManager.logger.warn(String.valueOf(new StringBuilder("Could not find uniform named ").append(llllllllllllllIIlIllllIlIIlllIll).append(" in the specified").append(" shader program.")));
            }
            else {
                this.shaderUniformLocations.add(llllllllllllllIIlIllllIlIIlllIIl);
                llllllllllllllIIlIllllIlIIllIllI.setUniformLocation(llllllllllllllIIlIllllIlIIlllIIl);
                this.mappedShaderUniforms.put(llllllllllllllIIlIllllIlIIlllIll, llllllllllllllIIlIllllIlIIllIllI);
            }
        }
    }
    
    public ShaderLoader getVertexShaderLoader() {
        return this.vertexShaderLoader;
    }
    
    public ShaderManager(final IResourceManager llllllllllllllIIlIllllIlIlllllII, final String llllllllllllllIIlIllllIllIIllIll) throws JsonException {
        this.shaderSamplers = Maps.newHashMap();
        this.samplerNames = Lists.newArrayList();
        this.shaderSamplerLocations = Lists.newArrayList();
        this.shaderUniforms = Lists.newArrayList();
        this.shaderUniformLocations = Lists.newArrayList();
        this.mappedShaderUniforms = Maps.newHashMap();
        final JsonParser llllllllllllllIIlIllllIllIIllIlI = new JsonParser();
        final ResourceLocation llllllllllllllIIlIllllIllIIllIIl = new ResourceLocation(String.valueOf(new StringBuilder("shaders/program/").append(llllllllllllllIIlIllllIllIIllIll).append(".json")));
        this.programFilename = llllllllllllllIIlIllllIllIIllIll;
        InputStream llllllllllllllIIlIllllIllIIllIII = null;
        try {
            llllllllllllllIIlIllllIllIIllIII = llllllllllllllIIlIllllIlIlllllII.getResource(llllllllllllllIIlIllllIllIIllIIl).getInputStream();
            final JsonObject llllllllllllllIIlIllllIllIIlIlll = llllllllllllllIIlIllllIllIIllIlI.parse(IOUtils.toString(llllllllllllllIIlIllllIllIIllIII, Charsets.UTF_8)).getAsJsonObject();
            final String llllllllllllllIIlIllllIllIIlIllI = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIIlIllllIllIIlIlll, "vertex");
            final String llllllllllllllIIlIllllIllIIlIlIl = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIIlIllllIllIIlIlll, "fragment");
            final JsonArray llllllllllllllIIlIllllIllIIlIlII = JsonUtils.getJsonObjectJsonArrayFieldOrDefault(llllllllllllllIIlIllllIllIIlIlll, "samplers", null);
            if (llllllllllllllIIlIllllIllIIlIlII != null) {
                int llllllllllllllIIlIllllIllIIlIIll = 0;
                for (final JsonElement llllllllllllllIIlIllllIllIIlIIIl : llllllllllllllIIlIllllIllIIlIlII) {
                    try {
                        this.parseSampler(llllllllllllllIIlIllllIllIIlIIIl);
                    }
                    catch (Exception llllllllllllllIIlIllllIllIIlIIII) {
                        final JsonException llllllllllllllIIlIllllIllIIIllll = JsonException.func_151379_a(llllllllllllllIIlIllllIllIIlIIII);
                        llllllllllllllIIlIllllIllIIIllll.func_151380_a(String.valueOf(new StringBuilder("samplers[").append(llllllllllllllIIlIllllIllIIlIIll).append("]")));
                        throw llllllllllllllIIlIllllIllIIIllll;
                    }
                    ++llllllllllllllIIlIllllIllIIlIIll;
                }
            }
            final JsonArray llllllllllllllIIlIllllIllIIIlllI = JsonUtils.getJsonObjectJsonArrayFieldOrDefault(llllllllllllllIIlIllllIllIIlIlll, "attributes", null);
            if (llllllllllllllIIlIllllIllIIIlllI != null) {
                int llllllllllllllIIlIllllIllIIIlIll = 0;
                this.field_148015_q = Lists.newArrayListWithCapacity(llllllllllllllIIlIllllIllIIIlllI.size());
                this.field_148014_r = Lists.newArrayListWithCapacity(llllllllllllllIIlIllllIllIIIlllI.size());
                for (final JsonElement llllllllllllllIIlIllllIllIIIlIlI : llllllllllllllIIlIllllIllIIIlllI) {
                    try {
                        this.field_148014_r.add(JsonUtils.getJsonElementStringValue(llllllllllllllIIlIllllIllIIIlIlI, "attribute"));
                    }
                    catch (Exception llllllllllllllIIlIllllIllIIIlIIl) {
                        final JsonException llllllllllllllIIlIllllIllIIIlIII = JsonException.func_151379_a(llllllllllllllIIlIllllIllIIIlIIl);
                        llllllllllllllIIlIllllIllIIIlIII.func_151380_a(String.valueOf(new StringBuilder("attributes[").append(llllllllllllllIIlIllllIllIIIlIll).append("]")));
                        throw llllllllllllllIIlIllllIllIIIlIII;
                    }
                    ++llllllllllllllIIlIllllIllIIIlIll;
                }
            }
            else {
                this.field_148015_q = null;
                this.field_148014_r = null;
            }
            final JsonArray llllllllllllllIIlIllllIllIIIIlll = JsonUtils.getJsonObjectJsonArrayFieldOrDefault(llllllllllllllIIlIllllIllIIlIlll, "uniforms", null);
            if (llllllllllllllIIlIllllIllIIIIlll != null) {
                int llllllllllllllIIlIllllIllIIIIllI = 0;
                for (final JsonElement llllllllllllllIIlIllllIllIIIIlII : llllllllllllllIIlIllllIllIIIIlll) {
                    try {
                        this.parseUniform(llllllllllllllIIlIllllIllIIIIlII);
                    }
                    catch (Exception llllllllllllllIIlIllllIllIIIIIll) {
                        final JsonException llllllllllllllIIlIllllIllIIIIIlI = JsonException.func_151379_a(llllllllllllllIIlIllllIllIIIIIll);
                        llllllllllllllIIlIllllIllIIIIIlI.func_151380_a(String.valueOf(new StringBuilder("uniforms[").append(llllllllllllllIIlIllllIllIIIIllI).append("]")));
                        throw llllllllllllllIIlIllllIllIIIIIlI;
                    }
                    ++llllllllllllllIIlIllllIllIIIIllI;
                }
            }
            this.field_148016_p = JsonBlendingMode.func_148110_a(JsonUtils.getJsonObjectFieldOrDefault(llllllllllllllIIlIllllIllIIlIlll, "blend", null));
            this.useFaceCulling = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllIIlIllllIllIIlIlll, "cull", true);
            this.vertexShaderLoader = ShaderLoader.loadShader(llllllllllllllIIlIllllIlIlllllII, ShaderLoader.ShaderType.VERTEX, llllllllllllllIIlIllllIllIIlIllI);
            this.fragmentShaderLoader = ShaderLoader.loadShader(llllllllllllllIIlIllllIlIlllllII, ShaderLoader.ShaderType.FRAGMENT, llllllllllllllIIlIllllIllIIlIlIl);
            this.program = ShaderLinkHelper.getStaticShaderLinkHelper().createProgram();
            ShaderLinkHelper.getStaticShaderLinkHelper().linkProgram(this);
            this.setupUniforms();
            if (this.field_148014_r != null) {
                for (final String llllllllllllllIIlIllllIllIIIIIIl : this.field_148014_r) {
                    final int llllllllllllllIIlIllllIllIIIIIII = OpenGlHelper.glGetAttribLocation(this.program, llllllllllllllIIlIllllIllIIIIIIl);
                    this.field_148015_q.add(llllllllllllllIIlIllllIllIIIIIII);
                }
            }
        }
        catch (Exception llllllllllllllIIlIllllIlIlllllll) {
            final JsonException llllllllllllllIIlIllllIlIllllllI = JsonException.func_151379_a(llllllllllllllIIlIllllIlIlllllll);
            llllllllllllllIIlIllllIlIllllllI.func_151381_b(llllllllllllllIIlIllllIllIIllIIl.getResourcePath());
            throw llllllllllllllIIlIllllIlIllllllI;
        }
        finally {
            IOUtils.closeQuietly(llllllllllllllIIlIllllIllIIllIII);
        }
        IOUtils.closeQuietly(llllllllllllllIIlIllllIllIIllIII);
        this.markDirty();
    }
    
    static {
        __OBFID = "CL_00001040";
        logger = LogManager.getLogger();
        defaultShaderUniform = new ShaderDefault();
        ShaderManager.staticShaderManager = null;
        ShaderManager.currentProgram = -1;
        ShaderManager.field_148000_e = true;
    }
    
    public void deleteShader() {
        ShaderLinkHelper.getStaticShaderLinkHelper().deleteShader(this);
    }
    
    public void markDirty() {
        this.isDirty = true;
    }
    
    public int getProgram() {
        return this.program;
    }
    
    public ShaderLoader getFragmentShaderLoader() {
        return this.fragmentShaderLoader;
    }
    
    private void parseSampler(final JsonElement llllllllllllllIIlIllllIlIIlIIllI) {
        final JsonObject llllllllllllllIIlIllllIlIIlIlIIl = JsonUtils.getElementAsJsonObject(llllllllllllllIIlIllllIlIIlIIllI, "sampler");
        final String llllllllllllllIIlIllllIlIIlIlIII = JsonUtils.getJsonObjectStringFieldValue(llllllllllllllIIlIllllIlIIlIlIIl, "name");
        if (!JsonUtils.jsonObjectFieldTypeIsString(llllllllllllllIIlIllllIlIIlIlIIl, "file")) {
            this.shaderSamplers.put(llllllllllllllIIlIllllIlIIlIlIII, null);
            this.samplerNames.add(llllllllllllllIIlIllllIlIIlIlIII);
        }
        else {
            this.samplerNames.add(llllllllllllllIIlIllllIlIIlIlIII);
        }
    }
}
