package net.minecraft.block;

import net.minecraft.item.*;
import net.minecraft.init.*;

public class BlockCarrot extends BlockCrops
{
    static {
        __OBFID = "CL_00000212";
    }
    
    @Override
    protected Item getSeed() {
        return Items.carrot;
    }
    
    @Override
    protected Item getCrop() {
        return Items.carrot;
    }
}
