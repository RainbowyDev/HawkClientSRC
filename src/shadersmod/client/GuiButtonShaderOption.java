package shadersmod.client;

import net.minecraft.client.gui.*;

public class GuiButtonShaderOption extends GuiButton
{
    private /* synthetic */ ShaderOption shaderOption;
    
    public GuiButtonShaderOption(final int llllllllllllllIIlIllIllIlIlIIIII, final int llllllllllllllIIlIllIllIlIlIIlll, final int llllllllllllllIIlIllIllIlIIllllI, final int llllllllllllllIIlIllIllIlIIlllIl, final int llllllllllllllIIlIllIllIlIIlllII, final ShaderOption llllllllllllllIIlIllIllIlIIllIll, final String llllllllllllllIIlIllIllIlIlIIIlI) {
        super(llllllllllllllIIlIllIllIlIlIIIII, llllllllllllllIIlIllIllIlIlIIlll, llllllllllllllIIlIllIllIlIIllllI, llllllllllllllIIlIllIllIlIIlllIl, llllllllllllllIIlIllIllIlIIlllII, llllllllllllllIIlIllIllIlIlIIIlI);
        this.shaderOption = null;
        this.shaderOption = llllllllllllllIIlIllIllIlIIllIll;
    }
    
    public ShaderOption getShaderOption() {
        return this.shaderOption;
    }
}
