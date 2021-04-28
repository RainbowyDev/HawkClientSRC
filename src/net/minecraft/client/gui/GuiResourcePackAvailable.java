package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import java.util.*;

public class GuiResourcePackAvailable extends GuiResourcePackList
{
    @Override
    protected String getListHeader() {
        return I18n.format("resourcePack.available.title", new Object[0]);
    }
    
    public GuiResourcePackAvailable(final Minecraft llllllllllllllllIIlIlIllIllIlllI, final int llllllllllllllllIIlIlIllIllIllIl, final int llllllllllllllllIIlIlIllIlllIIIl, final List llllllllllllllllIIlIlIllIlllIIII) {
        super(llllllllllllllllIIlIlIllIllIlllI, llllllllllllllllIIlIlIllIllIllIl, llllllllllllllllIIlIlIllIlllIIIl, llllllllllllllllIIlIlIllIlllIIII);
    }
    
    static {
        __OBFID = "CL_00000824";
    }
}
