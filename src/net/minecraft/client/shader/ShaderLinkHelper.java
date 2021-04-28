package net.minecraft.client.shader;

import org.apache.logging.log4j.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.util.*;

public class ShaderLinkHelper
{
    private static /* synthetic */ ShaderLinkHelper staticShaderLinkHelper;
    private static final /* synthetic */ Logger logger;
    
    static {
        __OBFID = "CL_00001045";
        logger = LogManager.getLogger();
    }
    
    public void deleteShader(final ShaderManager llllllllllllllIlllIllIIIIlIlIlIl) {
        llllllllllllllIlllIllIIIIlIlIlIl.getFragmentShaderLoader().deleteShader(llllllllllllllIlllIllIIIIlIlIlIl);
        llllllllllllllIlllIllIIIIlIlIlIl.getVertexShaderLoader().deleteShader(llllllllllllllIlllIllIIIIlIlIlIl);
        OpenGlHelper.glDeleteProgram(llllllllllllllIlllIllIIIIlIlIlIl.getProgram());
    }
    
    public void linkProgram(final ShaderManager llllllllllllllIlllIllIIIIlIIlIlI) {
        llllllllllllllIlllIllIIIIlIIlIlI.getFragmentShaderLoader().attachShader(llllllllllllllIlllIllIIIIlIIlIlI);
        llllllllllllllIlllIllIIIIlIIlIlI.getVertexShaderLoader().attachShader(llllllllllllllIlllIllIIIIlIIlIlI);
        OpenGlHelper.glLinkProgram(llllllllllllllIlllIllIIIIlIIlIlI.getProgram());
        final int llllllllllllllIlllIllIIIIlIIlIll = OpenGlHelper.glGetProgrami(llllllllllllllIlllIllIIIIlIIlIlI.getProgram(), OpenGlHelper.GL_LINK_STATUS);
        if (llllllllllllllIlllIllIIIIlIIlIll == 0) {
            ShaderLinkHelper.logger.warn(String.valueOf(new StringBuilder("Error encountered when linking program containing VS ").append(llllllllllllllIlllIllIIIIlIIlIlI.getVertexShaderLoader().getShaderFilename()).append(" and FS ").append(llllllllllllllIlllIllIIIIlIIlIlI.getFragmentShaderLoader().getShaderFilename()).append(". Log output:")));
            ShaderLinkHelper.logger.warn(OpenGlHelper.glGetProgramInfoLog(llllllllllllllIlllIllIIIIlIIlIlI.getProgram(), 32768));
        }
    }
    
    public static ShaderLinkHelper getStaticShaderLinkHelper() {
        return ShaderLinkHelper.staticShaderLinkHelper;
    }
    
    public int createProgram() throws JsonException {
        final int llllllllllllllIlllIllIIIIlIlIIIl = OpenGlHelper.glCreateProgram();
        if (llllllllllllllIlllIllIIIIlIlIIIl <= 0) {
            throw new JsonException(String.valueOf(new StringBuilder("Could not create shader program (returned program ID ").append(llllllllllllllIlllIllIIIIlIlIIIl).append(")")));
        }
        return llllllllllllllIlllIllIIIIlIlIIIl;
    }
    
    public static void setNewStaticShaderLinkHelper() {
        ShaderLinkHelper.staticShaderLinkHelper = new ShaderLinkHelper();
    }
}
