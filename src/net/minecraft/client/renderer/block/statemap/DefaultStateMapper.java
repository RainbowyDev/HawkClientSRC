package net.minecraft.client.renderer.block.statemap;

import net.minecraft.block.state.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import java.util.*;

public class DefaultStateMapper extends StateMapperBase
{
    @Override
    protected ModelResourceLocation func_178132_a(final IBlockState lllllllllllllllIIIlIllIlllllIlII) {
        return new ModelResourceLocation((ResourceLocation)Block.blockRegistry.getNameForObject(lllllllllllllllIIIlIllIlllllIlII.getBlock()), this.func_178131_a((Map)lllllllllllllllIIIlIllIlllllIlII.getProperties()));
    }
    
    static {
        __OBFID = "CL_00002477";
    }
}
