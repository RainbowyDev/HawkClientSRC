package net.minecraft.client.player.inventory;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class LocalBlockIntercommunication implements IInteractionObject
{
    private /* synthetic */ IChatComponent field_175125_b;
    private /* synthetic */ String field_175126_a;
    
    @Override
    public String getName() {
        return this.field_175125_b.getUnformattedText();
    }
    
    @Override
    public boolean hasCustomName() {
        return true;
    }
    
    public LocalBlockIntercommunication(final String llllllllllllllIlIIIllIIllllllIII, final IChatComponent llllllllllllllIlIIIllIIlllllIlll) {
        this.field_175126_a = llllllllllllllIlIIIllIIllllllIII;
        this.field_175125_b = llllllllllllllIlIIIllIIlllllIlll;
    }
    
    static {
        __OBFID = "CL_00002571";
    }
    
    @Override
    public IChatComponent getDisplayName() {
        return this.field_175125_b;
    }
    
    @Override
    public String getGuiID() {
        return this.field_175126_a;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllIlIIIllIIlllllIIlI, final EntityPlayer llllllllllllllIlIIIllIIlllllIIIl) {
        throw new UnsupportedOperationException();
    }
}
