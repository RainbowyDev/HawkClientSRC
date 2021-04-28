package shadersmod.client;

import org.lwjgl.opengl.*;

public abstract class ShaderUniformBase
{
    private /* synthetic */ int program;
    private /* synthetic */ String name;
    private /* synthetic */ int location;
    
    public int getProgram() {
        return this.program;
    }
    
    public int getLocation() {
        return this.location;
    }
    
    public ShaderUniformBase(final String lllllllllllllIllllllllIlIlllIIll) {
        this.program = -1;
        this.location = -1;
        this.name = lllllllllllllIllllllllIlIlllIIll;
    }
    
    public boolean isDefined() {
        return this.location >= 0;
    }
    
    protected abstract void onProgramChanged();
    
    public String getName() {
        return this.name;
    }
    
    public void setProgram(final int lllllllllllllIllllllllIlIllIllIl) {
        if (this.program != lllllllllllllIllllllllIlIllIllIl) {
            this.program = lllllllllllllIllllllllIlIllIllIl;
            this.location = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllIllllllllIlIllIllIl, (CharSequence)this.name);
            this.onProgramChanged();
        }
    }
}
