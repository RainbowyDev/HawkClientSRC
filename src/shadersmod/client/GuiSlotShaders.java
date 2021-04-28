package shadersmod.client;

import net.minecraft.client.gui.*;
import java.util.*;
import optifine.*;

class GuiSlotShaders extends GuiSlot
{
    final /* synthetic */ GuiShaders shadersGui;
    private /* synthetic */ ArrayList shaderslist;
    private /* synthetic */ int selectedIndex;
    private /* synthetic */ long lastClickedCached;
    
    public GuiSlotShaders(final GuiShaders llllllllllllllllIlIlIIIllIIllIll, final int llllllllllllllllIlIlIIIllIIllIlI, final int llllllllllllllllIlIlIIIllIIlIIII, final int llllllllllllllllIlIlIIIllIIllIII, final int llllllllllllllllIlIlIIIllIIIlllI, final int llllllllllllllllIlIlIIIllIIIllIl) {
        super(llllllllllllllllIlIlIIIllIIllIll.getMc(), llllllllllllllllIlIlIIIllIIllIlI, llllllllllllllllIlIlIIIllIIlIIII, llllllllllllllllIlIlIIIllIIllIII, llllllllllllllllIlIlIIIllIIIlllI, llllllllllllllllIlIlIIIllIIIllIl);
        this.lastClickedCached = 0L;
        this.shadersGui = llllllllllllllllIlIlIIIllIIllIll;
        this.updateList();
        this.amountScrolled = 0.0f;
        final int llllllllllllllllIlIlIIIllIIlIlIl = this.selectedIndex * llllllllllllllllIlIlIIIllIIIllIl;
        final int llllllllllllllllIlIlIIIllIIlIlII = (llllllllllllllllIlIlIIIllIIIlllI - llllllllllllllllIlIlIIIllIIllIII) / 2;
        if (llllllllllllllllIlIlIIIllIIlIlIl > llllllllllllllllIlIlIIIllIIlIlII) {
            this.scrollBy(llllllllllllllllIlIlIIIllIIlIlIl - llllllllllllllllIlIlIIIllIIlIlII);
        }
    }
    
    @Override
    protected int getSize() {
        return this.shaderslist.size();
    }
    
    @Override
    protected boolean isSelected(final int llllllllllllllllIlIlIIIlIllIIllI) {
        return llllllllllllllllIlIlIIIlIllIIllI == this.selectedIndex;
    }
    
    public int getSelectedIndex() {
        return this.selectedIndex;
    }
    
    public void updateList() {
        this.shaderslist = Shaders.listOfShaders();
        this.selectedIndex = 0;
        for (int llllllllllllllllIlIlIIIllIIIIIll = 0, llllllllllllllllIlIlIIIllIIIIIlI = this.shaderslist.size(); llllllllllllllllIlIlIIIllIIIIIll < llllllllllllllllIlIlIIIllIIIIIlI; ++llllllllllllllllIlIlIIIllIIIIIll) {
            if (this.shaderslist.get(llllllllllllllllIlIlIIIllIIIIIll).equals(Shaders.currentshadername)) {
                this.selectedIndex = llllllllllllllllIlIlIIIllIIIIIll;
                break;
            }
        }
    }
    
    @Override
    protected int getContentHeight() {
        return this.getSize() * 18;
    }
    
    @Override
    protected void elementClicked(final int llllllllllllllllIlIlIIIlIllIlIll, final boolean llllllllllllllllIlIlIIIlIlllIIlI, final int llllllllllllllllIlIlIIIlIlllIIIl, final int llllllllllllllllIlIlIIIlIllIllll) {
        if (llllllllllllllllIlIlIIIlIllIlIll != this.selectedIndex || this.lastClicked != this.lastClickedCached) {
            this.selectedIndex = llllllllllllllllIlIlIIIlIllIlIll;
            this.lastClickedCached = this.lastClicked;
            Shaders.setShaderPack(this.shaderslist.get(llllllllllllllllIlIlIIIlIllIlIll));
            Shaders.uninit();
            this.shadersGui.updateButtons();
        }
    }
    
    @Override
    public int getListWidth() {
        return this.width - 20;
    }
    
    @Override
    protected void drawBackground() {
    }
    
    @Override
    protected void drawSlot(final int llllllllllllllllIlIlIIIlIlIlIlll, final int llllllllllllllllIlIlIIIlIlIlIllI, final int llllllllllllllllIlIlIIIlIlIIlllI, final int llllllllllllllllIlIlIIIlIlIlIlII, final int llllllllllllllllIlIlIIIlIlIlIIll, final int llllllllllllllllIlIlIIIlIlIlIIlI) {
        String llllllllllllllllIlIlIIIlIlIlIIIl = this.shaderslist.get(llllllllllllllllIlIlIIIlIlIlIlll);
        if (llllllllllllllllIlIlIIIlIlIlIIIl.equals(Shaders.packNameNone)) {
            llllllllllllllllIlIlIIIlIlIlIIIl = Lang.get("of.options.shaders.packNone");
        }
        else if (llllllllllllllllIlIlIIIlIlIlIIIl.equals(Shaders.packNameDefault)) {
            llllllllllllllllIlIlIIIlIlIlIIIl = Lang.get("of.options.shaders.packDefault");
        }
        this.shadersGui.drawCenteredString(llllllllllllllllIlIlIIIlIlIlIIIl, this.width / 2, llllllllllllllllIlIlIIIlIlIIlllI + 1, 16777215);
    }
    
    @Override
    protected int getScrollBarX() {
        return this.width - 6;
    }
}
