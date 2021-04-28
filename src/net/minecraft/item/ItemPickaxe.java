package net.minecraft.item;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.block.material.*;

public class ItemPickaxe extends ItemTool
{
    private static final /* synthetic */ Set effectiveBlocks;
    
    static {
        __OBFID = "CL_00000053";
        effectiveBlocks = Sets.newHashSet((Object[])new Block[] { Blocks.activator_rail, Blocks.coal_ore, Blocks.cobblestone, Blocks.detector_rail, Blocks.diamond_block, Blocks.diamond_ore, Blocks.double_stone_slab, Blocks.golden_rail, Blocks.gold_block, Blocks.gold_ore, Blocks.ice, Blocks.iron_block, Blocks.iron_ore, Blocks.lapis_block, Blocks.lapis_ore, Blocks.lit_redstone_ore, Blocks.mossy_cobblestone, Blocks.netherrack, Blocks.packed_ice, Blocks.rail, Blocks.redstone_ore, Blocks.sandstone, Blocks.red_sandstone, Blocks.stone, Blocks.stone_slab });
    }
    
    @Override
    public boolean canHarvestBlock(final Block lllllllllllllllllIIllIIIlIlllIlI) {
        return (lllllllllllllllllIIllIIIlIlllIlI == Blocks.obsidian) ? (this.toolMaterial.getHarvestLevel() == 3) : ((lllllllllllllllllIIllIIIlIlllIlI != Blocks.diamond_block && lllllllllllllllllIIllIIIlIlllIlI != Blocks.diamond_ore) ? ((lllllllllllllllllIIllIIIlIlllIlI != Blocks.emerald_ore && lllllllllllllllllIIllIIIlIlllIlI != Blocks.emerald_block) ? ((lllllllllllllllllIIllIIIlIlllIlI != Blocks.gold_block && lllllllllllllllllIIllIIIlIlllIlI != Blocks.gold_ore) ? ((lllllllllllllllllIIllIIIlIlllIlI != Blocks.iron_block && lllllllllllllllllIIllIIIlIlllIlI != Blocks.iron_ore) ? ((lllllllllllllllllIIllIIIlIlllIlI != Blocks.lapis_block && lllllllllllllllllIIllIIIlIlllIlI != Blocks.lapis_ore) ? ((lllllllllllllllllIIllIIIlIlllIlI != Blocks.redstone_ore && lllllllllllllllllIIllIIIlIlllIlI != Blocks.lit_redstone_ore) ? (lllllllllllllllllIIllIIIlIlllIlI.getMaterial() == Material.rock || lllllllllllllllllIIllIIIlIlllIlI.getMaterial() == Material.iron || lllllllllllllllllIIllIIIlIlllIlI.getMaterial() == Material.anvil) : (this.toolMaterial.getHarvestLevel() >= 2)) : (this.toolMaterial.getHarvestLevel() >= 1)) : (this.toolMaterial.getHarvestLevel() >= 1)) : (this.toolMaterial.getHarvestLevel() >= 2)) : (this.toolMaterial.getHarvestLevel() >= 2)) : (this.toolMaterial.getHarvestLevel() >= 2));
    }
    
    @Override
    public float getStrVsBlock(final ItemStack lllllllllllllllllIIllIIIlIllIIIl, final Block lllllllllllllllllIIllIIIlIlIllll) {
        return (lllllllllllllllllIIllIIIlIlIllll.getMaterial() != Material.iron && lllllllllllllllllIIllIIIlIlIllll.getMaterial() != Material.anvil && lllllllllllllllllIIllIIIlIlIllll.getMaterial() != Material.rock) ? super.getStrVsBlock(lllllllllllllllllIIllIIIlIllIIIl, lllllllllllllllllIIllIIIlIlIllll) : this.efficiencyOnProperMaterial;
    }
    
    protected ItemPickaxe(final ToolMaterial lllllllllllllllllIIllIIIlllIIlll) {
        super(2.0f, lllllllllllllllllIIllIIIlllIIlll, ItemPickaxe.effectiveBlocks);
    }
}
