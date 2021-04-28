package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;

public class BlockDeadBush extends BlockBush
{
    @Override
    protected boolean canPlaceBlockOn(final Block llllllllllllllIIlIIIlIlIIIllllII) {
        return llllllllllllllIIlIIIlIlIIIllllII == Blocks.sand || llllllllllllllIIlIIIlIlIIIllllII == Blocks.hardened_clay || llllllllllllllIIlIIIlIlIIIllllII == Blocks.stained_hardened_clay || llllllllllllllIIlIIIlIlIIIllllII == Blocks.dirt;
    }
    
    protected BlockDeadBush() {
        super(Material.vine);
        final float llllllllllllllIIlIIIlIlIIlIIIIIl = 0.4f;
        this.setBlockBounds(0.5f - llllllllllllllIIlIIIlIlIIlIIIIIl, 0.0f, 0.5f - llllllllllllllIIlIIIlIlIIlIIIIIl, 0.5f + llllllllllllllIIlIIIlIlIIlIIIIIl, 0.8f, 0.5f + llllllllllllllIIlIIIlIlIIlIIIIIl);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIlIIIlIlIIIllIllI, final Random llllllllllllllIIlIIIlIlIIIllIlIl, final int llllllllllllllIIlIIIlIlIIIllIlII) {
        return null;
    }
    
    @Override
    public void harvestBlock(final World llllllllllllllIIlIIIlIlIIIlIllII, final EntityPlayer llllllllllllllIIlIIIlIlIIIlIIlIl, final BlockPos llllllllllllllIIlIIIlIlIIIlIIlII, final IBlockState llllllllllllllIIlIIIlIlIIIlIlIIl, final TileEntity llllllllllllllIIlIIIlIlIIIlIlIII) {
        if (!llllllllllllllIIlIIIlIlIIIlIllII.isRemote && llllllllllllllIIlIIIlIlIIIlIIlIl.getCurrentEquippedItem() != null && llllllllllllllIIlIIIlIlIIIlIIlIl.getCurrentEquippedItem().getItem() == Items.shears) {
            llllllllllllllIIlIIIlIlIIIlIIlIl.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
            Block.spawnAsEntity(llllllllllllllIIlIIIlIlIIIlIllII, llllllllllllllIIlIIIlIlIIIlIIlII, new ItemStack(Blocks.deadbush, 1, 0));
        }
        else {
            super.harvestBlock(llllllllllllllIIlIIIlIlIIIlIllII, llllllllllllllIIlIIIlIlIIIlIIlIl, llllllllllllllIIlIIIlIlIIIlIIlII, llllllllllllllIIlIIIlIlIIIlIlIIl, llllllllllllllIIlIIIlIlIIIlIlIII);
        }
    }
    
    @Override
    public boolean isReplaceable(final World llllllllllllllIIlIIIlIlIIIlllIIl, final BlockPos llllllllllllllIIlIIIlIlIIIlllIII) {
        return true;
    }
    
    static {
        __OBFID = "CL_00000224";
    }
}
