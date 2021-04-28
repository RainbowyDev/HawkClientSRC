package net.minecraft.tileentity;

import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;

public class TileEntityFlowerPot extends TileEntity
{
    private /* synthetic */ Item flowerPotItem;
    private /* synthetic */ int flowerPotData;
    
    public TileEntityFlowerPot() {
    }
    
    public TileEntityFlowerPot(final Item llllllllllllllllIIIlIlIIlIlllIlI, final int llllllllllllllllIIIlIlIIlIllIllI) {
        this.flowerPotItem = llllllllllllllllIIIlIlIIlIlllIlI;
        this.flowerPotData = llllllllllllllllIIIlIlIIlIllIllI;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllllIIIlIlIIlIlIIlll) {
        super.readFromNBT(llllllllllllllllIIIlIlIIlIlIIlll);
        if (llllllllllllllllIIIlIlIIlIlIIlll.hasKey("Item", 8)) {
            this.flowerPotItem = Item.getByNameOrId(llllllllllllllllIIIlIlIIlIlIIlll.getString("Item"));
        }
        else {
            this.flowerPotItem = Item.getItemById(llllllllllllllllIIIlIlIIlIlIIlll.getInteger("Item"));
        }
        this.flowerPotData = llllllllllllllllIIIlIlIIlIlIIlll.getInteger("Data");
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllllIIIlIlIIlIlIlllI) {
        super.writeToNBT(llllllllllllllllIIIlIlIIlIlIlllI);
        final ResourceLocation llllllllllllllllIIIlIlIIlIllIIII = (ResourceLocation)Item.itemRegistry.getNameForObject(this.flowerPotItem);
        llllllllllllllllIIIlIlIIlIlIlllI.setString("Item", (llllllllllllllllIIIlIlIIlIllIIII == null) ? "" : llllllllllllllllIIIlIlIIlIllIIII.toString());
        llllllllllllllllIIIlIlIIlIlIlllI.setInteger("Data", this.flowerPotData);
    }
    
    @Override
    public Packet getDescriptionPacket() {
        final NBTTagCompound llllllllllllllllIIIlIlIIlIlIIIll = new NBTTagCompound();
        this.writeToNBT(llllllllllllllllIIIlIlIIlIlIIIll);
        llllllllllllllllIIIlIlIIlIlIIIll.removeTag("Item");
        llllllllllllllllIIIlIlIIlIlIIIll.setInteger("Item", Item.getIdFromItem(this.flowerPotItem));
        return new S35PacketUpdateTileEntity(this.pos, 5, llllllllllllllllIIIlIlIIlIlIIIll);
    }
    
    public int getFlowerPotData() {
        return this.flowerPotData;
    }
    
    static {
        __OBFID = "CL_00000356";
    }
    
    public Item getFlowerPotItem() {
        return this.flowerPotItem;
    }
    
    public void func_145964_a(final Item llllllllllllllllIIIlIlIIlIIllIIl, final int llllllllllllllllIIIlIlIIlIIllIll) {
        this.flowerPotItem = llllllllllllllllIIIlIlIIlIIllIIl;
        this.flowerPotData = llllllllllllllllIIIlIlIIlIIllIll;
    }
}
