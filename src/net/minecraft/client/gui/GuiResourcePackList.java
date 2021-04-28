package net.minecraft.client.gui;

import net.minecraft.client.*;
import java.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public abstract class GuiResourcePackList extends GuiListExtended
{
    protected final /* synthetic */ Minecraft mc;
    protected final /* synthetic */ List field_148204_l;
    
    public List getList() {
        return this.field_148204_l;
    }
    
    @Override
    public ResourcePackListEntry getListEntry(final int lllllllllllllllIIlIllllIIIllllII) {
        return this.getList().get(lllllllllllllllIIlIllllIIIllllII);
    }
    
    @Override
    protected int getSize() {
        return this.getList().size();
    }
    
    @Override
    protected void drawListHeader(final int lllllllllllllllIIlIllllIIlIlIIII, final int lllllllllllllllIIlIllllIIlIIlllI, final Tessellator lllllllllllllllIIlIllllIIlIlIIll) {
        final String lllllllllllllllIIlIllllIIlIlIIlI = String.valueOf(new StringBuilder().append(EnumChatFormatting.UNDERLINE).append(EnumChatFormatting.BOLD).append(this.getListHeader()));
        this.mc.fontRendererObj.drawString(lllllllllllllllIIlIllllIIlIlIIlI, lllllllllllllllIIlIllllIIlIlIIII + this.width / 2 - this.mc.fontRendererObj.getStringWidth(lllllllllllllllIIlIllllIIlIlIIlI) / 2, Math.min(this.top + 3, lllllllllllllllIIlIllllIIlIIlllI), 16777215);
    }
    
    public IGuiListEntry getListEntry1(final int lllllllllllllllIIlIllllIIIllIIII) {
        return this.getListEntry(lllllllllllllllIIlIllllIIIllIIII);
    }
    
    public GuiResourcePackList(final Minecraft lllllllllllllllIIlIllllIIllIIIll, final int lllllllllllllllIIlIllllIIlIlllIl, final int lllllllllllllllIIlIllllIIlIlllII, final List lllllllllllllllIIlIllllIIlIllIll) {
        super(lllllllllllllllIIlIllllIIllIIIll, lllllllllllllllIIlIllllIIlIlllIl, lllllllllllllllIIlIllllIIlIlllII, 32, lllllllllllllllIIlIllllIIlIlllII - 55 + 4, 36);
        this.mc = lllllllllllllllIIlIllllIIllIIIll;
        this.field_148204_l = lllllllllllllllIIlIllllIIlIllIll;
        this.field_148163_i = false;
        this.setHasListHeader(true, (int)(lllllllllllllllIIlIllllIIllIIIll.fontRendererObj.FONT_HEIGHT * 1.5f));
    }
    
    @Override
    protected int getScrollBarX() {
        return this.right - 6;
    }
    
    static {
        __OBFID = "CL_00000825";
    }
    
    protected abstract String getListHeader();
    
    @Override
    public int getListWidth() {
        return this.width;
    }
}
