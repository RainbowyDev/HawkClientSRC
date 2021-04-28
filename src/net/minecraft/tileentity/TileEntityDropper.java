package net.minecraft.tileentity;

public class TileEntityDropper extends TileEntityDispenser
{
    static {
        __OBFID = "CL_00000353";
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:dropper";
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_146020_a : "container.dropper";
    }
}
