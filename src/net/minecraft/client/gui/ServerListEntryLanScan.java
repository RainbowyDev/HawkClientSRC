package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.resources.*;

public class ServerListEntryLanScan implements GuiListExtended.IGuiListEntry
{
    private final /* synthetic */ Minecraft field_148288_a;
    
    @Override
    public void drawEntry(final int llllllllllllllllIlIlIlIlIIIIlIlI, final int llllllllllllllllIlIlIlIlIIIIlIIl, final int llllllllllllllllIlIlIlIIllllllIl, final int llllllllllllllllIlIlIlIlIIIIIlll, final int llllllllllllllllIlIlIlIIllllllII, final int llllllllllllllllIlIlIlIlIIIIIlIl, final int llllllllllllllllIlIlIlIlIIIIIlII, final boolean llllllllllllllllIlIlIlIlIIIIIIll) {
        final int llllllllllllllllIlIlIlIlIIIIIIlI = llllllllllllllllIlIlIlIIllllllIl + llllllllllllllllIlIlIlIIllllllII / 2 - this.field_148288_a.fontRendererObj.FONT_HEIGHT / 2;
        this.field_148288_a.fontRendererObj.drawString(I18n.format("lanServer.scanning", new Object[0]), this.field_148288_a.currentScreen.width / 2 - this.field_148288_a.fontRendererObj.getStringWidth(I18n.format("lanServer.scanning", new Object[0])) / 2, llllllllllllllllIlIlIlIlIIIIIIlI, 16777215);
        final String llllllllllllllllIlIlIlIIllllllll;
        switch ((int)(Minecraft.getSystemTime() / 300L % 4L)) {
            default: {
                final String llllllllllllllllIlIlIlIlIIIIIIIl = "O o o";
                break;
            }
            case 1:
            case 3: {
                final String llllllllllllllllIlIlIlIlIIIIIIII = "o O o";
                break;
            }
            case 2: {
                llllllllllllllllIlIlIlIIllllllll = "o o O";
                break;
            }
        }
        this.field_148288_a.fontRendererObj.drawString(llllllllllllllllIlIlIlIIllllllll, this.field_148288_a.currentScreen.width / 2 - this.field_148288_a.fontRendererObj.getStringWidth(llllllllllllllllIlIlIlIIllllllll) / 2, llllllllllllllllIlIlIlIlIIIIIIlI + this.field_148288_a.fontRendererObj.FONT_HEIGHT, 8421504);
    }
    
    @Override
    public boolean mousePressed(final int llllllllllllllllIlIlIlIIllllIlII, final int llllllllllllllllIlIlIlIIllllIIll, final int llllllllllllllllIlIlIlIIllllIIlI, final int llllllllllllllllIlIlIlIIllllIIIl, final int llllllllllllllllIlIlIlIIllllIIII, final int llllllllllllllllIlIlIlIIlllIllll) {
        return false;
    }
    
    @Override
    public void setSelected(final int llllllllllllllllIlIlIlIIlllllIII, final int llllllllllllllllIlIlIlIIllllIlll, final int llllllllllllllllIlIlIlIIllllIllI) {
    }
    
    static {
        __OBFID = "CL_00000815";
    }
    
    public ServerListEntryLanScan() {
        this.field_148288_a = Minecraft.getMinecraft();
    }
    
    @Override
    public void mouseReleased(final int llllllllllllllllIlIlIlIIlllIllIl, final int llllllllllllllllIlIlIlIIlllIllII, final int llllllllllllllllIlIlIlIIlllIlIll, final int llllllllllllllllIlIlIlIIlllIlIlI, final int llllllllllllllllIlIlIlIIlllIlIIl, final int llllllllllllllllIlIlIlIIlllIlIII) {
    }
}
