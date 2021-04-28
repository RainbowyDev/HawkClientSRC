package net.minecraft.item;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.block.material.*;

public class ItemAxe extends ItemTool
{
    private static final /* synthetic */ Set field_150917_c;
    
    static {
        __OBFID = "CL_00001770";
        field_150917_c = Sets.newHashSet((Object[])new Block[] { Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder });
    }
    
    protected ItemAxe(final ToolMaterial lllllllllllllllIIlIlllIIIIIIIllI) {
        super(3.0f, lllllllllllllllIIlIlllIIIIIIIllI, ItemAxe.field_150917_c);
    }
    
    @Override
    public float getStrVsBlock(final ItemStack lllllllllllllllIIlIllIllllllllll, final Block lllllllllllllllIIlIllIlllllllllI) {
        return (lllllllllllllllIIlIllIlllllllllI.getMaterial() != Material.wood && lllllllllllllllIIlIllIlllllllllI.getMaterial() != Material.plants && lllllllllllllllIIlIllIlllllllllI.getMaterial() != Material.vine) ? super.getStrVsBlock(lllllllllllllllIIlIllIllllllllll, lllllllllllllllIIlIllIlllllllllI) : this.efficiencyOnProperMaterial;
    }
}
