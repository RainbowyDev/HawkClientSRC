package net.minecraft.client.gui;

import net.minecraft.client.network.*;
import java.util.*;
import net.minecraft.client.*;
import com.google.common.collect.*;
import net.minecraft.client.multiplayer.*;

public class ServerSelectionList extends GuiListExtended
{
    private final /* synthetic */ GuiMultiplayer owner;
    private final /* synthetic */ IGuiListEntry lanScanEntry;
    private /* synthetic */ int field_148197_o;
    private final /* synthetic */ List field_148198_l;
    private final /* synthetic */ List field_148199_m;
    
    public void func_148192_c(final int llllllllllllllIIIlIIIllIIlIlIIlI) {
        this.field_148197_o = llllllllllllllIIIlIIIllIIlIlIIlI;
    }
    
    @Override
    protected boolean isSelected(final int llllllllllllllIIIlIIIllIIlIIllII) {
        return llllllllllllllIIIlIIIllIIlIIllII == this.field_148197_o;
    }
    
    @Override
    protected int getSize() {
        return this.field_148198_l.size() + 1 + this.field_148199_m.size();
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 30;
    }
    
    public void func_148194_a(final List llllllllllllllIIIlIIIllIIIllIllI) {
        this.field_148199_m.clear();
        for (final LanServerDetector.LanServer llllllllllllllIIIlIIIllIIIlllIII : llllllllllllllIIIlIIIllIIIllIllI) {
            this.field_148199_m.add(new ServerListEntryLanDetected(this.owner, llllllllllllllIIIlIIIllIIIlllIII));
        }
    }
    
    @Override
    public IGuiListEntry getListEntry(int llllllllllllllIIIlIIIllIIlIlllIl) {
        if (llllllllllllllIIIlIIIllIIlIlllIl < this.field_148198_l.size()) {
            return this.field_148198_l.get(llllllllllllllIIIlIIIllIIlIlllIl);
        }
        llllllllllllllIIIlIIIllIIlIlllIl -= this.field_148198_l.size();
        if (llllllllllllllIIIlIIIllIIlIlllIl == 0) {
            return this.lanScanEntry;
        }
        --llllllllllllllIIIlIIIllIIlIlllIl;
        return this.field_148199_m.get(llllllllllllllIIIlIIIllIIlIlllIl);
    }
    
    @Override
    public int getListWidth() {
        return super.getListWidth() + 85;
    }
    
    public ServerSelectionList(final GuiMultiplayer llllllllllllllIIIlIIIllIIllIIlll, final Minecraft llllllllllllllIIIlIIIllIIllIIllI, final int llllllllllllllIIIlIIIllIIllIllIl, final int llllllllllllllIIIlIIIllIIllIIlII, final int llllllllllllllIIIlIIIllIIllIIIll, final int llllllllllllllIIIlIIIllIIllIlIlI, final int llllllllllllllIIIlIIIllIIllIIIIl) {
        super(llllllllllllllIIIlIIIllIIllIIllI, llllllllllllllIIIlIIIllIIllIllIl, llllllllllllllIIIlIIIllIIllIIlII, llllllllllllllIIIlIIIllIIllIIIll, llllllllllllllIIIlIIIllIIllIlIlI, llllllllllllllIIIlIIIllIIllIIIIl);
        this.field_148198_l = Lists.newArrayList();
        this.field_148199_m = Lists.newArrayList();
        this.lanScanEntry = new ServerListEntryLanScan();
        this.field_148197_o = -1;
        this.owner = llllllllllllllIIIlIIIllIIllIIlll;
    }
    
    static {
        __OBFID = "CL_00000819";
    }
    
    public int func_148193_k() {
        return this.field_148197_o;
    }
    
    public void func_148195_a(final ServerList llllllllllllllIIIlIIIllIIlIIIlII) {
        this.field_148198_l.clear();
        for (int llllllllllllllIIIlIIIllIIlIIIIll = 0; llllllllllllllIIIlIIIllIIlIIIIll < llllllllllllllIIIlIIIllIIlIIIlII.countServers(); ++llllllllllllllIIIlIIIllIIlIIIIll) {
            this.field_148198_l.add(new ServerListEntryNormal(this.owner, llllllllllllllIIIlIIIllIIlIIIlII.getServerData(llllllllllllllIIIlIIIllIIlIIIIll)));
        }
    }
}
