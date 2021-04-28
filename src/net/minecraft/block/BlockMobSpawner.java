package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.util.*;

public class BlockMobSpawner extends BlockContainer
{
    @Override
    public Item getItem(final World llllllllllllllIlllIIllIllIIIlIlI, final BlockPos llllllllllllllIlllIIllIllIIIlIIl) {
        return null;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIlllIIllIllIlIlIll, final int llllllllllllllIlllIIllIllIlIlIlI) {
        return new TileEntityMobSpawner();
    }
    
    protected BlockMobSpawner() {
        super(Material.rock);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlllIIllIllIlIlIII, final Random llllllllllllllIlllIIllIllIlIIlll, final int llllllllllllllIlllIIllIllIlIIllI) {
        return null;
    }
    
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }
    
    @Override
    public int getRenderType() {
        return 3;
    }
    
    static {
        __OBFID = "CL_00000269";
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIlllIIllIllIlIIlII) {
        return 0;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIlllIIllIllIIllIll, final BlockPos llllllllllllllIlllIIllIllIIllIlI, final IBlockState llllllllllllllIlllIIllIllIIllIIl, final float llllllllllllllIlllIIllIllIIlIIIl, final int llllllllllllllIlllIIllIllIIlIlll) {
        super.dropBlockAsItemWithChance(llllllllllllllIlllIIllIllIIllIll, llllllllllllllIlllIIllIllIIllIlI, llllllllllllllIlllIIllIllIIllIIl, llllllllllllllIlllIIllIllIIlIIIl, llllllllllllllIlllIIllIllIIlIlll);
        final int llllllllllllllIlllIIllIllIIlIllI = 15 + llllllllllllllIlllIIllIllIIllIll.rand.nextInt(15) + llllllllllllllIlllIIllIllIIllIll.rand.nextInt(15);
        this.dropXpOnBlockBreak(llllllllllllllIlllIIllIllIIllIll, llllllllllllllIlllIIllIllIIllIlI, llllllllllllllIlllIIllIllIIlIllI);
    }
}
