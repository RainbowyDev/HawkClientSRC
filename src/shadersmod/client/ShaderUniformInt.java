package shadersmod.client;

import org.lwjgl.opengl.*;

public class ShaderUniformInt extends ShaderUniformBase
{
    private /* synthetic */ int value;
    
    @Override
    protected void onProgramChanged() {
        this.value = -1;
    }
    
    public ShaderUniformInt(final String llIlllIllIllIlI) {
        super(llIlllIllIllIlI);
        this.value = -1;
    }
    
    public void setValue(final int llIlllIllIlIIll) {
        if (this.getLocation() >= 0 && this.value != llIlllIllIlIIll) {
            ARBShaderObjects.glUniform1iARB(this.getLocation(), llIlllIllIlIIll);
            Shaders.checkGLError(this.getName());
            this.value = llIlllIllIlIIll;
        }
    }
    
    public int getValue() {
        return this.value;
    }
}
