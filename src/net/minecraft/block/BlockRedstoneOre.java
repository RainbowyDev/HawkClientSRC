package net.minecraft.block;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class BlockRedstoneOre extends Block
{
    private final /* synthetic */ boolean isOn;
    
    private void spawnRedstoneParticles(final World llllllllllllllIIIllIIlIllIIIIlII, final BlockPos llllllllllllllIIIllIIlIlIlllIlII) {
        final Random llllllllllllllIIIllIIlIllIIIIIIl = llllllllllllllIIIllIIlIllIIIIlII.rand;
        final double llllllllllllllIIIllIIlIlIlllllll = 0.0625;
        for (int llllllllllllllIIIllIIlIlIlllllIl = 0; llllllllllllllIIIllIIlIlIlllllIl < 6; ++llllllllllllllIIIllIIlIlIlllllIl) {
            double llllllllllllllIIIllIIlIlIllllIll = llllllllllllllIIIllIIlIlIlllIlII.getX() + llllllllllllllIIIllIIlIllIIIIIIl.nextFloat();
            double llllllllllllllIIIllIIlIlIllllIIl = llllllllllllllIIIllIIlIlIlllIlII.getY() + llllllllllllllIIIllIIlIllIIIIIIl.nextFloat();
            double llllllllllllllIIIllIIlIlIlllIlll = llllllllllllllIIIllIIlIlIlllIlII.getZ() + llllllllllllllIIIllIIlIllIIIIIIl.nextFloat();
            if (llllllllllllllIIIllIIlIlIlllllIl == 0 && !llllllllllllllIIIllIIlIllIIIIlII.getBlockState(llllllllllllllIIIllIIlIlIlllIlII.offsetUp()).getBlock().isOpaqueCube()) {
                llllllllllllllIIIllIIlIlIllllIIl = llllllllllllllIIIllIIlIlIlllIlII.getY() + llllllllllllllIIIllIIlIlIlllllll + 1.0;
            }
            if (llllllllllllllIIIllIIlIlIlllllIl == 1 && !llllllllllllllIIIllIIlIllIIIIlII.getBlockState(llllllllllllllIIIllIIlIlIlllIlII.offsetDown()).getBlock().isOpaqueCube()) {
                llllllllllllllIIIllIIlIlIllllIIl = llllllllllllllIIIllIIlIlIlllIlII.getY() - llllllllllllllIIIllIIlIlIlllllll;
            }
            if (llllllllllllllIIIllIIlIlIlllllIl == 2 && !llllllllllllllIIIllIIlIllIIIIlII.getBlockState(llllllllllllllIIIllIIlIlIlllIlII.offsetSouth()).getBlock().isOpaqueCube()) {
                llllllllllllllIIIllIIlIlIlllIlll = llllllllllllllIIIllIIlIlIlllIlII.getZ() + llllllllllllllIIIllIIlIlIlllllll + 1.0;
            }
            if (llllllllllllllIIIllIIlIlIlllllIl == 3 && !llllllllllllllIIIllIIlIllIIIIlII.getBlockState(llllllllllllllIIIllIIlIlIlllIlII.offsetNorth()).getBlock().isOpaqueCube()) {
                llllllllllllllIIIllIIlIlIlllIlll = llllllllllllllIIIllIIlIlIlllIlII.getZ() - llllllllllllllIIIllIIlIlIlllllll;
            }
            if (llllllllllllllIIIllIIlIlIlllllIl == 4 && !llllllllllllllIIIllIIlIllIIIIlII.getBlockState(llllllllllllllIIIllIIlIlIlllIlII.offsetEast()).getBlock().isOpaqueCube()) {
                llllllllllllllIIIllIIlIlIllllIll = llllllllllllllIIIllIIlIlIlllIlII.getX() + llllllllllllllIIIllIIlIlIlllllll + 1.0;
            }
            if (llllllllllllllIIIllIIlIlIlllllIl == 5 && !llllllllllllllIIIllIIlIllIIIIlII.getBlockState(llllllllllllllIIIllIIlIlIlllIlII.offsetWest()).getBlock().isOpaqueCube()) {
                llllllllllllllIIIllIIlIlIllllIll = llllllllllllllIIIllIIlIlIlllIlII.getX() - llllllllllllllIIIllIIlIlIlllllll;
            }
            if (llllllllllllllIIIllIIlIlIllllIll < llllllllllllllIIIllIIlIlIlllIlII.getX() || llllllllllllllIIIllIIlIlIllllIll > llllllllllllllIIIllIIlIlIlllIlII.getX() + 1 || llllllllllllllIIIllIIlIlIllllIIl < 0.0 || llllllllllllllIIIllIIlIlIllllIIl > llllllllllllllIIIllIIlIlIlllIlII.getY() + 1 || llllllllllllllIIIllIIlIlIlllIlll < llllllllllllllIIIllIIlIlIlllIlII.getZ() || llllllllllllllIIIllIIlIlIlllIlll > llllllllllllllIIIllIIlIlIlllIlII.getZ() + 1) {
                llllllllllllllIIIllIIlIllIIIIlII.spawnParticle(EnumParticleTypes.REDSTONE, llllllllllllllIIIllIIlIlIllllIll, llllllllllllllIIIllIIlIlIllllIIl, llllllllllllllIIIllIIlIlIlllIlll, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllllIIIllIIllIIllIlIlI, final BlockPos llllllllllllllIIIllIIllIIllIlIIl, final Entity llllllllllllllIIIllIIllIIllIIlll) {
        this.setOn(llllllllllllllIIIllIIllIIllIlIlI, llllllllllllllIIIllIIllIIllIlIIl);
        super.onEntityCollidedWithBlock(llllllllllllllIIIllIIllIIllIlIlI, llllllllllllllIIIllIIllIIllIlIIl, llllllllllllllIIIllIIllIIllIIlll);
    }
    
    @Override
    protected ItemStack createStackedBlock(final IBlockState llllllllllllllIIIllIIlIlIllIIlII) {
        return new ItemStack(Blocks.redstone_ore);
    }
    
    private void setOn(final World llllllllllllllIIIllIIllIIIlIIlll, final BlockPos llllllllllllllIIIllIIllIIIlIIIll) {
        this.spawnRedstoneParticles(llllllllllllllIIIllIIllIIIlIIlll, llllllllllllllIIIllIIllIIIlIIIll);
        if (this == Blocks.redstone_ore) {
            llllllllllllllIIIllIIllIIIlIIlll.setBlockState(llllllllllllllIIIllIIllIIIlIIIll, Blocks.lit_redstone_ore.getDefaultState());
        }
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIIllIIllIIIIllllI, final BlockPos llllllllllllllIIIllIIllIIIIlllIl, final IBlockState llllllllllllllIIIllIIllIIIIllIll, final Random llllllllllllllIIIllIIllIIIIllIIl) {
        if (this == Blocks.lit_redstone_ore) {
            llllllllllllllIIIllIIllIIIIllllI.setBlockState(llllllllllllllIIIllIIllIIIIlllIl, Blocks.redstone_ore.getDefaultState());
        }
    }
    
    @Override
    public int quantityDroppedWithBonus(final int llllllllllllllIIIllIIllIIIIIIIll, final Random llllllllllllllIIIllIIllIIIIIIIIl) {
        return this.quantityDropped(llllllllllllllIIIllIIllIIIIIIIIl) + llllllllllllllIIIllIIllIIIIIIIIl.nextInt(llllllllllllllIIIllIIllIIIIIIIll + 1);
    }
    
    static {
        __OBFID = "CL_00000294";
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIIllIIllIIlIlIIII, final BlockPos llllllllllllllIIIllIIllIIlIIlllI, final IBlockState llllllllllllllIIIllIIllIIIllllll, final EntityPlayer llllllllllllllIIIllIIllIIlIIlIlI, final EnumFacing llllllllllllllIIIllIIllIIIllllIl, final float llllllllllllllIIIllIIllIIlIIIllI, final float llllllllllllllIIIllIIllIIIlllIIl, final float llllllllllllllIIIllIIllIIIllIlll) {
        this.setOn(llllllllllllllIIIllIIllIIlIlIIII, llllllllllllllIIIllIIllIIlIIlllI);
        return super.onBlockActivated(llllllllllllllIIIllIIllIIlIlIIII, llllllllllllllIIIllIIllIIlIIlllI, llllllllllllllIIIllIIllIIIllllll, llllllllllllllIIIllIIllIIlIIlIlI, llllllllllllllIIIllIIllIIIllllIl, llllllllllllllIIIllIIllIIlIIIllI, llllllllllllllIIIllIIllIIIlllIIl, llllllllllllllIIIllIIllIIIllIlll);
    }
    
    @Override
    public void randomDisplayTick(final World llllllllllllllIIIllIIlIllIllIIll, final BlockPos llllllllllllllIIIllIIlIllIlllIlI, final IBlockState llllllllllllllIIIllIIlIllIlllIIl, final Random llllllllllllllIIIllIIlIllIllIlll) {
        if (this.isOn) {
            this.spawnRedstoneParticles(llllllllllllllIIIllIIlIllIllIIll, llllllllllllllIIIllIIlIllIlllIlI);
        }
    }
    
    public BlockRedstoneOre(final boolean llllllllllllllIIIllIIllIlIIlIIlI) {
        super(Material.rock);
        if (llllllllllllllIIIllIIllIlIIlIIlI) {
            this.setTickRandomly(true);
        }
        this.isOn = llllllllllllllIIIllIIllIlIIlIIlI;
    }
    
    @Override
    public void onBlockClicked(final World llllllllllllllIIIllIIllIlIIIIIIl, final BlockPos llllllllllllllIIIllIIllIIlllIlll, final EntityPlayer llllllllllllllIIIllIIllIIlllIlIl) {
        this.setOn(llllllllllllllIIIllIIllIlIIIIIIl, llllllllllllllIIIllIIllIIlllIlll);
        super.onBlockClicked(llllllllllllllIIIllIIllIlIIIIIIl, llllllllllllllIIIllIIllIIlllIlll, llllllllllllllIIIllIIllIIlllIlIl);
    }
    
    @Override
    public int tickRate(final World llllllllllllllIIIllIIllIlIIIlIll) {
        return 30;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIIllIIlIlllIlIIIl, final BlockPos llllllllllllllIIIllIIlIlllIlIIII, final IBlockState llllllllllllllIIIllIIlIlllIllIIl, final float llllllllllllllIIIllIIlIlllIIllII, final int llllllllllllllIIIllIIlIlllIlIllI) {
        super.dropBlockAsItemWithChance(llllllllllllllIIIllIIlIlllIlIIIl, llllllllllllllIIIllIIlIlllIlIIII, llllllllllllllIIIllIIlIlllIllIIl, llllllllllllllIIIllIIlIlllIIllII, llllllllllllllIIIllIIlIlllIlIllI);
        if (this.getItemDropped(llllllllllllllIIIllIIlIlllIllIIl, llllllllllllllIIIllIIlIlllIlIIIl.rand, llllllllllllllIIIllIIlIlllIlIllI) != Item.getItemFromBlock(this)) {
            final int llllllllllllllIIIllIIlIlllIlIlII = 1 + llllllllllllllIIIllIIlIlllIlIIIl.rand.nextInt(5);
            this.dropXpOnBlockBreak(llllllllllllllIIIllIIlIlllIlIIIl, llllllllllllllIIIllIIlIlllIlIIII, llllllllllllllIIIllIIlIlllIlIlII);
        }
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIIIllIIlIlllllIIlI) {
        return 4 + llllllllllllllIIIllIIlIlllllIIlI.nextInt(2);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIIllIIllIIIIIllIl, final Random llllllllllllllIIIllIIllIIIIIlIll, final int llllllllllllllIIIllIIllIIIIIlIIl) {
        return Items.redstone;
    }
}
