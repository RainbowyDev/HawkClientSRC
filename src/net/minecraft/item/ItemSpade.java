package net.minecraft.item;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import com.google.common.collect.*;

public class ItemSpade extends ItemTool
{
    private static final /* synthetic */ Set field_150916_c;
    
    static {
        __OBFID = "CL_00000063";
        field_150916_c = Sets.newHashSet((Object[])new Block[] { Blocks.clay, Blocks.dirt, Blocks.farmland, Blocks.grass, Blocks.gravel, Blocks.mycelium, Blocks.sand, Blocks.snow, Blocks.snow_layer, Blocks.soul_sand });
    }
    
    @Override
    public boolean canHarvestBlock(final Block lllllllllllllllllIlIIlIIIllIIIII) {
        return lllllllllllllllllIlIIlIIIllIIIII == Blocks.snow_layer || lllllllllllllllllIlIIlIIIllIIIII == Blocks.snow;
    }
    
    public ItemSpade(final ToolMaterial lllllllllllllllllIlIIlIIIllIIlIl) {
        super(1.0f, lllllllllllllllllIlIIlIIIllIIlIl, ItemSpade.field_150916_c);
    }
}
