package net.minecraft.client.gui.spectator;

import java.util.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.client.gui.spectator.categories.*;

public class BaseSpectatorGroup implements ISpectatorMenuView
{
    private final /* synthetic */ List field_178671_a;
    
    @Override
    public List func_178669_a() {
        return this.field_178671_a;
    }
    
    @Override
    public IChatComponent func_178670_b() {
        return new ChatComponentText("Press a key to select a command, and again to use it.");
    }
    
    static {
        __OBFID = "CL_00001928";
    }
    
    public BaseSpectatorGroup() {
        this.field_178671_a = Lists.newArrayList();
        this.field_178671_a.add(new TeleportToPlayer());
        this.field_178671_a.add(new TeleportToTeam());
    }
}
