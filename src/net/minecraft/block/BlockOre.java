package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;

public class BlockOre extends Block
{
    @Override
    public int damageDropped(final IBlockState lIlIllIIllIlll) {
        return (this == Blocks.lapis_ore) ? EnumDyeColor.BLUE.getDyeColorDamage() : 0;
    }
    
    @Override
    public int quantityDropped(final Random lIlIllIllIIIII) {
        return (this == Blocks.lapis_ore) ? (4 + lIlIllIllIIIII.nextInt(5)) : 1;
    }
    
    static {
        __OBFID = "CL_00000282";
    }
    
    @Override
    public int quantityDroppedWithBonus(final int lIlIllIlIllIII, final Random lIlIllIlIlIIll) {
        if (lIlIllIlIllIII > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), lIlIllIlIlIIll, lIlIllIlIllIII)) {
            int lIlIllIlIlIllI = lIlIllIlIlIIll.nextInt(lIlIllIlIllIII + 2) - 1;
            if (lIlIllIlIlIllI < 0) {
                lIlIllIlIlIllI = 0;
            }
            return this.quantityDropped(lIlIllIlIlIIll) * (lIlIllIlIlIllI + 1);
        }
        return this.quantityDropped(lIlIllIlIlIIll);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lIlIllIlIIIIlI, final BlockPos lIlIllIlIIlIII, final IBlockState lIlIllIlIIIIII, final float lIlIllIlIIIllI, final int lIlIllIlIIIlIl) {
        super.dropBlockAsItemWithChance(lIlIllIlIIIIlI, lIlIllIlIIlIII, lIlIllIlIIIIII, lIlIllIlIIIllI, lIlIllIlIIIlIl);
        if (this.getItemDropped(lIlIllIlIIIIII, lIlIllIlIIIIlI.rand, lIlIllIlIIIlIl) != Item.getItemFromBlock(this)) {
            int lIlIllIlIIIlII = 0;
            if (this == Blocks.coal_ore) {
                lIlIllIlIIIlII = MathHelper.getRandomIntegerInRange(lIlIllIlIIIIlI.rand, 0, 2);
            }
            else if (this == Blocks.diamond_ore) {
                lIlIllIlIIIlII = MathHelper.getRandomIntegerInRange(lIlIllIlIIIIlI.rand, 3, 7);
            }
            else if (this == Blocks.emerald_ore) {
                lIlIllIlIIIlII = MathHelper.getRandomIntegerInRange(lIlIllIlIIIIlI.rand, 3, 7);
            }
            else if (this == Blocks.lapis_ore) {
                lIlIllIlIIIlII = MathHelper.getRandomIntegerInRange(lIlIllIlIIIIlI.rand, 2, 5);
            }
            else if (this == Blocks.quartz_ore) {
                lIlIllIlIIIlII = MathHelper.getRandomIntegerInRange(lIlIllIlIIIIlI.rand, 2, 5);
            }
            this.dropXpOnBlockBreak(lIlIllIlIIIIlI, lIlIllIlIIlIII, lIlIllIlIIIlII);
        }
    }
    
    public BlockOre() {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lIlIllIllIIlll, final Random lIlIllIllIIllI, final int lIlIllIllIIlIl) {
        return (this == Blocks.coal_ore) ? Items.coal : ((this == Blocks.diamond_ore) ? Items.diamond : ((this == Blocks.lapis_ore) ? Items.dye : ((this == Blocks.emerald_ore) ? Items.emerald : ((this == Blocks.quartz_ore) ? Items.quartz : Item.getItemFromBlock(this)))));
    }
    
    @Override
    public int getDamageValue(final World lIlIllIIlllIll, final BlockPos lIlIllIIlllIlI) {
        return 0;
    }
}
