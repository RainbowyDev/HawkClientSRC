package shadersmod.client;

public class ShaderOptionScreen extends ShaderOption
{
    public ShaderOptionScreen(final String lllllllllllllllIllIlIIllIIllIllI) {
        super(lllllllllllllllIllIlIIllIIllIllI, null, null, new String[1], null, null);
    }
    
    @Override
    public String getDescriptionText() {
        return Shaders.translate(String.valueOf(new StringBuilder("screen.").append(this.getName()).append(".comment")), null);
    }
    
    @Override
    public String getNameText() {
        return Shaders.translate(String.valueOf(new StringBuilder("screen.").append(this.getName())), this.getName());
    }
}
