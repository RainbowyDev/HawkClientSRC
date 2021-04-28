package net.minecraft.world;

public class WorldProviderSurface extends WorldProvider
{
    static {
        __OBFID = "CL_00000388";
    }
    
    @Override
    public String getInternalNameSuffix() {
        return "";
    }
    
    @Override
    public String getDimensionName() {
        return "Overworld";
    }
}
