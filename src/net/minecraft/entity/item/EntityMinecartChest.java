package net.minecraft.entity.item;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;

public class EntityMinecartChest extends EntityMinecartContainer
{
    @Override
    public int getDefaultDisplayTileOffset() {
        return 8;
    }
    
    @Override
    public void killMinecart(final DamageSource llllllllllllllIlIlIlIIllIIllIlll) {
        super.killMinecart(llllllllllllllIlIlIlIIllIIllIlll);
        this.dropItemWithOffset(Item.getItemFromBlock(Blocks.chest), 1, 0.0f);
    }
    
    static {
        __OBFID = "CL_00001671";
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:chest";
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllIlIlIlIIllIIlIlIlI, final EntityPlayer llllllllllllllIlIlIlIIllIIlIlIIl) {
        return new ContainerChest(llllllllllllllIlIlIlIIllIIlIlIlI, this, llllllllllllllIlIlIlIIllIIlIlIIl);
    }
    
    @Override
    public IBlockState func_180457_u() {
        return Blocks.chest.getDefaultState().withProperty(BlockChest.FACING_PROP, EnumFacing.NORTH);
    }
    
    public EntityMinecartChest(final World llllllllllllllIlIlIlIIllIlIIIlIl, final double llllllllllllllIlIlIlIIllIlIIIlII, final double llllllllllllllIlIlIlIIllIlIIIIll, final double llllllllllllllIlIlIlIIllIlIIIIlI) {
        super(llllllllllllllIlIlIlIIllIlIIIlIl, llllllllllllllIlIlIlIIllIlIIIlII, llllllllllllllIlIlIlIIllIlIIIIll, llllllllllllllIlIlIlIIllIlIIIIlI);
    }
    
    @Override
    public int getSizeInventory() {
        return 27;
    }
    
    public EntityMinecartChest(final World llllllllllllllIlIlIlIIllIlIIllII) {
        super(llllllllllllllIlIlIlIIllIlIIllII);
    }
    
    @Override
    public EnumMinecartType func_180456_s() {
        return EnumMinecartType.CHEST;
    }
}
