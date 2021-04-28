package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.network.*;
import net.minecraft.client.resources.*;

public class ServerListEntryLanDetected implements GuiListExtended.IGuiListEntry
{
    protected final /* synthetic */ Minecraft field_148293_a;
    private /* synthetic */ long field_148290_d;
    private final /* synthetic */ GuiMultiplayer field_148292_c;
    protected final /* synthetic */ LanServerDetector.LanServer field_148291_b;
    
    public LanServerDetector.LanServer getLanServer() {
        return this.field_148291_b;
    }
    
    @Override
    public boolean mousePressed(final int lllllllllllllllIllIlIIlIlIIIIlll, final int lllllllllllllllIllIlIIlIlIIIIllI, final int lllllllllllllllIllIlIIlIlIIIIlIl, final int lllllllllllllllIllIlIIlIlIIIIlII, final int lllllllllllllllIllIlIIlIlIIIIIll, final int lllllllllllllllIllIlIIlIlIIIIIlI) {
        this.field_148292_c.selectServer(lllllllllllllllIllIlIIlIlIIIIlll);
        if (Minecraft.getSystemTime() - this.field_148290_d < 250L) {
            this.field_148292_c.connectToSelected();
        }
        this.field_148290_d = Minecraft.getSystemTime();
        return false;
    }
    
    protected ServerListEntryLanDetected(final GuiMultiplayer lllllllllllllllIllIlIIlIlIIllllI, final LanServerDetector.LanServer lllllllllllllllIllIlIIlIlIIlllIl) {
        this.field_148290_d = 0L;
        this.field_148292_c = lllllllllllllllIllIlIIlIlIIllllI;
        this.field_148291_b = lllllllllllllllIllIlIIlIlIIlllIl;
        this.field_148293_a = Minecraft.getMinecraft();
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllllIllIlIIlIIllllIlI, final int lllllllllllllllIllIlIIlIIllllIIl, final int lllllllllllllllIllIlIIlIIllllIII, final int lllllllllllllllIllIlIIlIIlllIlll, final int lllllllllllllllIllIlIIlIIlllIllI, final int lllllllllllllllIllIlIIlIIlllIlIl) {
    }
    
    static {
        __OBFID = "CL_00000816";
    }
    
    @Override
    public void drawEntry(final int lllllllllllllllIllIlIIlIlIIlIlIl, final int lllllllllllllllIllIlIIlIlIIlIlII, final int lllllllllllllllIllIlIIlIlIIIlIll, final int lllllllllllllllIllIlIIlIlIIlIIlI, final int lllllllllllllllIllIlIIlIlIIlIIIl, final int lllllllllllllllIllIlIIlIlIIlIIII, final int lllllllllllllllIllIlIIlIlIIIllll, final boolean lllllllllllllllIllIlIIlIlIIIlllI) {
        this.field_148293_a.fontRendererObj.drawString(I18n.format("lanServer.title", new Object[0]), lllllllllllllllIllIlIIlIlIIlIlII + 32 + 3, lllllllllllllllIllIlIIlIlIIIlIll + 1, 16777215);
        this.field_148293_a.fontRendererObj.drawString(this.field_148291_b.getServerMotd(), lllllllllllllllIllIlIIlIlIIlIlII + 32 + 3, lllllllllllllllIllIlIIlIlIIIlIll + 12, 8421504);
        if (this.field_148293_a.gameSettings.hideServerAddress) {
            this.field_148293_a.fontRendererObj.drawString(I18n.format("selectServer.hiddenAddress", new Object[0]), lllllllllllllllIllIlIIlIlIIlIlII + 32 + 3, lllllllllllllllIllIlIIlIlIIIlIll + 12 + 11, 3158064);
        }
        else {
            this.field_148293_a.fontRendererObj.drawString(this.field_148291_b.getServerIpPort(), lllllllllllllllIllIlIIlIlIIlIlII + 32 + 3, lllllllllllllllIllIlIIlIlIIIlIll + 12 + 11, 3158064);
        }
    }
    
    @Override
    public void setSelected(final int lllllllllllllllIllIlIIlIIllllllI, final int lllllllllllllllIllIlIIlIIlllllIl, final int lllllllllllllllIllIlIIlIIlllllII) {
    }
}
