package com.lukflug.panelstudio;

import com.lukflug.panelstudio.theme.*;
import java.util.*;

public class Container extends FocusableComponent
{
    private /* synthetic */ String tempDescription;
    protected /* synthetic */ List<Component> components;
    
    @Override
    public void getHeight(final Context llllllllllllllIIIIIIlIlllIIIllII) {
        this.doComponentLoop(llllllllllllllIIIIIIlIlllIIIllII, (llllllllllllllIIIIIIlIllIIlIlllI, llllllllllllllIIIIIIlIllIIlIlIll) -> llllllllllllllIIIIIIlIllIIlIlIll.getHeight(llllllllllllllIIIIIIlIllIIlIlllI));
    }
    
    @Override
    protected void handleFocus(final Context llllllllllllllIIIIIIlIllIlllIlII, final boolean llllllllllllllIIIIIIlIllIlllIIll) {
        if (!llllllllllllllIIIIIIlIllIlllIIll) {
            this.releaseFocus();
        }
    }
    
    @Override
    public void handleKey(final Context llllllllllllllIIIIIIlIlllIIlllII, final int llllllllllllllIIIIIIlIlllIIllllI) {
        this.doComponentLoop(llllllllllllllIIIIIIlIlllIIlllII, (llllllllllllllIIIIIIlIllIIlllIlI, llllllllllllllIIIIIIlIllIIlllIIl) -> llllllllllllllIIIIIIlIllIIlllIIl.handleKey(llllllllllllllIIIIIIlIllIIlllIlI, llllllllllllllIIIIIIlIlllIIllllI));
    }
    
    @Override
    public void releaseFocus() {
        super.releaseFocus();
        for (final Component llllllllllllllIIIIIIlIllIllllIll : this.components) {
            llllllllllllllIIIIIIlIllIllllIll.releaseFocus();
        }
    }
    
    protected Context getSubContext(final Context llllllllllllllIIIIIIlIllIllIllII, final int llllllllllllllIIIIIIlIllIllIlIII) {
        return new Context(llllllllllllllIIIIIIlIllIllIllII, this.renderer.getBorder(), this.renderer.getBorder(), llllllllllllllIIIIIIlIllIllIlIII, this.hasFocus(llllllllllllllIIIIIIlIllIllIllII), true);
    }
    
    @Override
    public void render(final Context llllllllllllllIIIIIIlIlllIlIllIl) {
        this.tempDescription = null;
        this.doComponentLoop(llllllllllllllIIIIIIlIlllIlIllIl, (llllllllllllllIIIIIIlIllIlIIllII, llllllllllllllIIIIIIlIllIlIIlllI) -> {
            llllllllllllllIIIIIIlIllIlIIlllI.render(llllllllllllllIIIIIIlIllIlIIllII);
            if (llllllllllllllIIIIIIlIllIlIIllII.isHovered() && llllllllllllllIIIIIIlIllIlIIllII.getDescription() != null) {
                this.tempDescription = llllllllllllllIIIIIIlIllIlIIllII.getDescription();
            }
            return;
        });
        if (this.tempDescription == null) {
            this.tempDescription = this.description;
        }
        llllllllllllllIIIIIIlIlllIlIllIl.setDescription(this.tempDescription);
    }
    
    public Container(final String llllllllllllllIIIIIIlIlllIllllll, final String llllllllllllllIIIIIIlIlllIlllIlI, final Renderer llllllllllllllIIIIIIlIlllIllllIl) {
        super(llllllllllllllIIIIIIlIlllIllllll, llllllllllllllIIIIIIlIlllIlllIlI, llllllllllllllIIIIIIlIlllIllllIl);
        this.components = new ArrayList<Component>();
    }
    
    @Override
    public void handleButton(final Context llllllllllllllIIIIIIlIlllIlIlIII, final int llllllllllllllIIIIIIlIlllIlIIlll) {
        this.getHeight(llllllllllllllIIIIIIlIlllIlIlIII);
        this.updateFocus(llllllllllllllIIIIIIlIlllIlIlIII, llllllllllllllIIIIIIlIlllIlIIlll);
        this.doComponentLoop(llllllllllllllIIIIIIlIlllIlIlIII, (llllllllllllllIIIIIIlIllIlIIIllI, llllllllllllllIIIIIIlIllIlIIIIIl) -> {
            llllllllllllllIIIIIIlIllIlIIIIIl.handleButton(llllllllllllllIIIIIIlIllIlIIIllI, llllllllllllllIIIIIIlIlllIlIIlll);
            if (llllllllllllllIIIIIIlIllIlIIIllI.focusReleased()) {
                llllllllllllllIIIIIIlIlllIlIlIII.releaseFocus();
            }
        });
    }
    
    @Override
    public void enter(final Context llllllllllllllIIIIIIlIlllIIIlIII) {
        this.doComponentLoop(llllllllllllllIIIIIIlIlllIIIlIII, (llllllllllllllIIIIIIlIllIIlIIllI, llllllllllllllIIIIIIlIllIIlIIlll) -> llllllllllllllIIIIIIlIllIIlIIlll.enter(llllllllllllllIIIIIIlIllIIlIIllI));
    }
    
    @Override
    public void handleScroll(final Context llllllllllllllIIIIIIlIlllIIlIIll, final int llllllllllllllIIIIIIlIlllIIlIlIl) {
        this.doComponentLoop(llllllllllllllIIIIIIlIlllIIlIIll, (llllllllllllllIIIIIIlIllIIllIIlI, llllllllllllllIIIIIIlIllIIllIIIl) -> llllllllllllllIIIIIIlIllIIllIIIl.handleScroll(llllllllllllllIIIIIIlIllIIllIIlI, llllllllllllllIIIIIIlIlllIIlIlIl));
    }
    
    public void addComponent(final Component llllllllllllllIIIIIIlIlllIllIlIl) {
        this.components.add(llllllllllllllIIIIIIlIlllIllIlIl);
    }
    
    protected void doComponentLoop(final Context llllllllllllllIIIIIIlIllIlIllIIl, final LoopFunction llllllllllllllIIIIIIlIllIlIllIII) {
        int llllllllllllllIIIIIIlIllIlIlllIl = this.renderer.getOffset();
        for (final Component llllllllllllllIIIIIIlIllIlIlllII : this.components) {
            final Context llllllllllllllIIIIIIlIllIlIllIll = this.getSubContext(llllllllllllllIIIIIIlIllIlIllIIl, llllllllllllllIIIIIIlIllIlIlllIl);
            llllllllllllllIIIIIIlIllIlIllIII.loop(llllllllllllllIIIIIIlIllIlIllIll, llllllllllllllIIIIIIlIllIlIlllII);
            llllllllllllllIIIIIIlIllIlIlllIl += llllllllllllllIIIIIIlIllIlIllIll.getSize().height + this.renderer.getOffset();
        }
        llllllllllllllIIIIIIlIllIlIllIIl.setHeight(llllllllllllllIIIIIIlIllIlIlllIl);
    }
    
    @Override
    public void exit(final Context llllllllllllllIIIIIIlIlllIIIIIlI) {
        this.doComponentLoop(llllllllllllllIIIIIIlIlllIIIIIlI, (llllllllllllllIIIIIIlIllIIlIIIII, llllllllllllllIIIIIIlIllIIIlllll) -> llllllllllllllIIIIIIlIllIIIlllll.exit(llllllllllllllIIIIIIlIllIIlIIIII));
    }
    
    protected interface LoopFunction
    {
        void loop(final Context p0, final Component p1);
    }
}
