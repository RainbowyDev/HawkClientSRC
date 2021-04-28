package shadersmod.client;

import org.lwjgl.opengl.*;

public class ShaderUniformFloat4 extends ShaderUniformBase
{
    private /* synthetic */ float[] values;
    
    public ShaderUniformFloat4(final String llllllllllllllllIIIllIIllIllllIl) {
        super(llllllllllllllllIIIllIIllIllllIl);
        this.values = new float[4];
    }
    
    @Override
    protected void onProgramChanged() {
        this.values[0] = 0.0f;
        this.values[1] = 0.0f;
        this.values[2] = 0.0f;
        this.values[3] = 0.0f;
    }
    
    public float[] getValues() {
        return this.values;
    }
    
    public void setValue(final float llllllllllllllllIIIllIIllIllIIIl, final float llllllllllllllllIIIllIIllIlIlIll, final float llllllllllllllllIIIllIIllIlIllll, final float llllllllllllllllIIIllIIllIlIlllI) {
        if (this.getLocation() >= 0 && (this.values[0] != llllllllllllllllIIIllIIllIllIIIl || this.values[1] != llllllllllllllllIIIllIIllIlIlIll || this.values[2] != llllllllllllllllIIIllIIllIlIllll || this.values[3] != llllllllllllllllIIIllIIllIlIlllI)) {
            ARBShaderObjects.glUniform4fARB(this.getLocation(), llllllllllllllllIIIllIIllIllIIIl, llllllllllllllllIIIllIIllIlIlIll, llllllllllllllllIIIllIIllIlIllll, llllllllllllllllIIIllIIllIlIlllI);
            Shaders.checkGLError(this.getName());
            this.values[0] = llllllllllllllllIIIllIIllIllIIIl;
            this.values[1] = llllllllllllllllIIIllIIllIlIlIll;
            this.values[2] = llllllllllllllllIIIllIIllIlIllll;
            this.values[3] = llllllllllllllllIIIllIIllIlIlllI;
        }
    }
}
