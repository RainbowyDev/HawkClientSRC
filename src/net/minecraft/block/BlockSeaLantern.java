package net.minecraft.block;

import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class BlockSeaLantern extends Block
{
    public BlockSeaLantern(final Material llllllllllllllIIlIllIIlllIlIIllI) {
        super(llllllllllllllIIlIllIIlllIlIIllI);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    static {
        __OBFID = "CL_00002066";
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIIlIllIIlllIIlIIIl) {
        return MapColor.quartzColor;
    }
    
    @Override
    public int quantityDroppedWithBonus(final int llllllllllllllIIlIllIIlllIIllIll, final Random llllllllllllllIIlIllIIlllIIlIlll) {
        return MathHelper.clamp_int(this.quantityDropped(llllllllllllllIIlIllIIlllIIlIlll) + llllllllllllllIIlIllIIlllIIlIlll.nextInt(llllllllllllllIIlIllIIlllIIllIll + 1), 1, 5);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIlIllIIlllIIlIlIl, final Random llllllllllllllIIlIllIIlllIIlIlII, final int llllllllllllllIIlIllIIlllIIlIIll) {
        return Items.prismarine_crystals;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIIlIllIIlllIlIIIII) {
        return 2 + llllllllllllllIIlIllIIlllIlIIIII.nextInt(2);
    }
}
