package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class BlockWorkbench extends Block
{
    static {
        __OBFID = "CL_00000221";
    }
    
    protected BlockWorkbench() {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIIIIlllIlllIlllll, final BlockPos lllllllllllllllIIIIlllIlllIllllI, final IBlockState lllllllllllllllIIIIlllIllllIIlIl, final EntityPlayer lllllllllllllllIIIIlllIlllIlllIl, final EnumFacing lllllllllllllllIIIIlllIllllIIIll, final float lllllllllllllllIIIIlllIllllIIIlI, final float lllllllllllllllIIIIlllIllllIIIIl, final float lllllllllllllllIIIIlllIllllIIIII) {
        if (lllllllllllllllIIIIlllIlllIlllll.isRemote) {
            return true;
        }
        lllllllllllllllIIIIlllIlllIlllIl.displayGui(new InterfaceCraftingTable(lllllllllllllllIIIIlllIlllIlllll, lllllllllllllllIIIIlllIlllIllllI));
        return true;
    }
    
    public static class InterfaceCraftingTable implements IInteractionObject
    {
        private final /* synthetic */ BlockPos position;
        private final /* synthetic */ World world;
        
        @Override
        public Container createContainer(final InventoryPlayer llllllllllllllIIIIIIIlIIIllIllll, final EntityPlayer llllllllllllllIIIIIIIlIIIllIlllI) {
            return new ContainerWorkbench(llllllllllllllIIIIIIIlIIIllIllll, this.world, this.position);
        }
        
        public InterfaceCraftingTable(final World llllllllllllllIIIIIIIlIIIllllIlI, final BlockPos llllllllllllllIIIIIIIlIIIlllIllI) {
            this.world = llllllllllllllIIIIIIIlIIIllllIlI;
            this.position = llllllllllllllIIIIIIIlIIIlllIllI;
        }
        
        @Override
        public boolean hasCustomName() {
            return false;
        }
        
        @Override
        public IChatComponent getDisplayName() {
            return new ChatComponentTranslation(String.valueOf(new StringBuilder(String.valueOf(Blocks.crafting_table.getUnlocalizedName())).append(".name")), new Object[0]);
        }
        
        @Override
        public String getName() {
            return null;
        }
        
        @Override
        public String getGuiID() {
            return "minecraft:crafting_table";
        }
        
        static {
            __OBFID = "CL_00002127";
        }
    }
}
