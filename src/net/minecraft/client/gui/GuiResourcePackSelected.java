package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import java.util.*;

public class GuiResourcePackSelected extends GuiResourcePackList
{
    @Override
    protected String getListHeader() {
        return I18n.format("resourcePack.selected.title", new Object[0]);
    }
    
    public GuiResourcePackSelected(final Minecraft llllllllllllllllIIllllllllllIIlI, final int llllllllllllllllIIllllllllllIIIl, final int llllllllllllllllIIlllllllllIlIll, final List llllllllllllllllIIlllllllllIllll) {
        super(llllllllllllllllIIllllllllllIIlI, llllllllllllllllIIllllllllllIIIl, llllllllllllllllIIlllllllllIlIll, llllllllllllllllIIlllllllllIllll);
    }
    
    static {
        __OBFID = "CL_00000827";
    }
}
