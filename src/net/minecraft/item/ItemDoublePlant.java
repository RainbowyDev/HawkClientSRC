package net.minecraft.item;

import com.google.common.base.*;
import net.minecraft.block.*;
import net.minecraft.world.*;

public class ItemDoublePlant extends ItemMultiTexture
{
    static {
        __OBFID = "CL_00000021";
    }
    
    public ItemDoublePlant(final Block llllllllllllllIIlIIllIllllIllllI, final Block llllllllllllllIIlIIllIlllllIIIIl, final Function llllllllllllllIIlIIllIllllIlllII) {
        super(llllllllllllllIIlIIllIllllIllllI, llllllllllllllIIlIIllIlllllIIIIl, llllllllllllllIIlIIllIllllIlllII);
    }
    
    @Override
    public int getColorFromItemStack(final ItemStack llllllllllllllIIlIIllIllllIlIIlI, final int llllllllllllllIIlIIllIllllIlIlIl) {
        final BlockDoublePlant.EnumPlantType llllllllllllllIIlIIllIllllIlIlII = BlockDoublePlant.EnumPlantType.func_176938_a(llllllllllllllIIlIIllIllllIlIIlI.getMetadata());
        return (llllllllllllllIIlIIllIllllIlIlII != BlockDoublePlant.EnumPlantType.GRASS && llllllllllllllIIlIIllIllllIlIlII != BlockDoublePlant.EnumPlantType.FERN) ? super.getColorFromItemStack(llllllllllllllIIlIIllIllllIlIIlI, llllllllllllllIIlIIllIllllIlIlIl) : ColorizerGrass.getGrassColor(0.5, 1.0);
    }
}
