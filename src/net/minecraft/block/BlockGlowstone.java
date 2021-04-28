package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockGlowstone extends Block
{
    @Override
    public Item getItemDropped(final IBlockState lIlllIIIlII, final Random lIlllIIIIll, final int lIlllIIIIlI) {
        return Items.glowstone_dust;
    }
    
    @Override
    public int quantityDropped(final Random lIlllIIIlll) {
        return 2 + lIlllIIIlll.nextInt(3);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lIlllIIIIII) {
        return MapColor.sandColor;
    }
    
    static {
        __OBFID = "CL_00000250";
    }
    
    @Override
    public int quantityDroppedWithBonus(final int lIlllIIlIll, final Random lIlllIIlIlI) {
        return MathHelper.clamp_int(this.quantityDropped(lIlllIIlIlI) + lIlllIIlIlI.nextInt(lIlllIIlIll + 1), 1, 4);
    }
    
    public BlockGlowstone(final Material lIlllIlIlIl) {
        super(lIlllIlIlIl);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
}
