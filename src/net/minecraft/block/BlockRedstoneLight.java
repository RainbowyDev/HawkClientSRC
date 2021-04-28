package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class BlockRedstoneLight extends Block
{
    private final /* synthetic */ boolean isOn;
    
    @Override
    protected ItemStack createStackedBlock(final IBlockState llIllIlIIIlllI) {
        return new ItemStack(Blocks.redstone_lamp);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llIllIlIIlIlIl, final Random llIllIlIIlIlII, final int llIllIlIIlIIll) {
        return Item.getItemFromBlock(Blocks.redstone_lamp);
    }
    
    static {
        __OBFID = "CL_00000297";
    }
    
    public BlockRedstoneLight(final boolean llIllIlIlllIIl) {
        super(Material.redstoneLight);
        this.isOn = llIllIlIlllIIl;
        if (llIllIlIlllIIl) {
            this.setLightLevel(1.0f);
        }
    }
    
    @Override
    public void updateTick(final World llIllIlIIlllIl, final BlockPos llIllIlIIlllII, final IBlockState llIllIlIIllIll, final Random llIllIlIIllIlI) {
        if (!llIllIlIIlllIl.isRemote && this.isOn && !llIllIlIIlllIl.isBlockPowered(llIllIlIIlllII)) {
            llIllIlIIlllIl.setBlockState(llIllIlIIlllII, Blocks.redstone_lamp.getDefaultState(), 2);
        }
    }
    
    @Override
    public void onNeighborBlockChange(final World llIllIlIlIlIII, final BlockPos llIllIlIlIIIlI, final IBlockState llIllIlIlIIllI, final Block llIllIlIlIIlIl) {
        if (!llIllIlIlIlIII.isRemote) {
            if (this.isOn && !llIllIlIlIlIII.isBlockPowered(llIllIlIlIIIlI)) {
                llIllIlIlIlIII.scheduleUpdate(llIllIlIlIIIlI, this, 4);
            }
            else if (!this.isOn && llIllIlIlIlIII.isBlockPowered(llIllIlIlIIIlI)) {
                llIllIlIlIlIII.setBlockState(llIllIlIlIIIlI, Blocks.lit_redstone_lamp.getDefaultState(), 2);
            }
        }
    }
    
    @Override
    public Item getItem(final World llIllIlIIlIIIl, final BlockPos llIllIlIIlIIII) {
        return Item.getItemFromBlock(Blocks.redstone_lamp);
    }
    
    @Override
    public void onBlockAdded(final World llIllIlIlIlllI, final BlockPos llIllIlIllIIIl, final IBlockState llIllIlIllIIII) {
        if (!llIllIlIlIlllI.isRemote) {
            if (this.isOn && !llIllIlIlIlllI.isBlockPowered(llIllIlIllIIIl)) {
                llIllIlIlIlllI.setBlockState(llIllIlIllIIIl, Blocks.redstone_lamp.getDefaultState(), 2);
            }
            else if (!this.isOn && llIllIlIlIlllI.isBlockPowered(llIllIlIllIIIl)) {
                llIllIlIlIlllI.setBlockState(llIllIlIllIIIl, Blocks.lit_redstone_lamp.getDefaultState(), 2);
            }
        }
    }
}
