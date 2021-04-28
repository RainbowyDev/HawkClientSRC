package net.minecraft.client.player.inventory;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class ContainerLocalMenu extends InventoryBasic implements ILockableContainer
{
    private /* synthetic */ String field_174896_a;
    private /* synthetic */ Map field_174895_b;
    
    static {
        __OBFID = "CL_00002570";
    }
    
    @Override
    public String getGuiID() {
        return this.field_174896_a;
    }
    
    @Override
    public LockCode getLockCode() {
        return LockCode.EMPTY_CODE;
    }
    
    @Override
    public int getField(final int llllllllllllllllIIlIlllllIlIIlll) {
        return this.field_174895_b.containsKey(llllllllllllllllIIlIlllllIlIIlll) ? this.field_174895_b.get(llllllllllllllllIIlIlllllIlIIlll) : 0;
    }
    
    @Override
    public boolean isLocked() {
        return false;
    }
    
    public ContainerLocalMenu(final String llllllllllllllllIIlIlllllIllllIl, final IChatComponent llllllllllllllllIIlIlllllIllIlIl, final int llllllllllllllllIIlIlllllIlllIll) {
        super(llllllllllllllllIIlIlllllIllIlIl, llllllllllllllllIIlIlllllIlllIll);
        this.field_174895_b = Maps.newHashMap();
        this.field_174896_a = llllllllllllllllIIlIlllllIllllIl;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllllIIlIllllIllllllI, final EntityPlayer llllllllllllllllIIlIllllIlllllIl) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setLockCode(final LockCode llllllllllllllllIIlIlllllIIIlIlI) {
    }
    
    @Override
    public int getFieldCount() {
        return this.field_174895_b.size();
    }
    
    @Override
    public void setField(final int llllllllllllllllIIlIlllllIIlIlIl, final int llllllllllllllllIIlIlllllIIlIlll) {
        this.field_174895_b.put(llllllllllllllllIIlIlllllIIlIlIl, llllllllllllllllIIlIlllllIIlIlll);
    }
}
