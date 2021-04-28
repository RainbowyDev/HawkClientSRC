package com.lukflug.panelstudio;

import java.awt.*;
import com.lukflug.panelstudio.theme.*;

public abstract class Slider extends FocusableComponent
{
    protected /* synthetic */ boolean attached;
    
    @Override
    public void render(final Context lIIIIlllIlI) {
        super.render(lIIIIlllIlI);
        if (this.attached) {
            double lIIIIllllII = (lIIIIlllIlI.getInterface().getMouse().x - lIIIIlllIlI.getPos().x) / (double)(lIIIIlllIlI.getSize().width - 1);
            if (lIIIIllllII < 0.0) {
                lIIIIllllII = 0.0;
            }
            else if (lIIIIllllII > 1.0) {
                lIIIIllllII = 1.0;
            }
            this.setValue(lIIIIllllII);
        }
        if (!lIIIIlllIlI.getInterface().getButton(0)) {
            this.attached = false;
        }
        this.renderer.renderRect(lIIIIlllIlI, "", this.hasFocus(lIIIIlllIlI), false, new Rectangle(new Point(lIIIIlllIlI.getPos().x + (int)(lIIIIlllIlI.getSize().width * this.getValue()), lIIIIlllIlI.getPos().y), new Dimension((int)(lIIIIlllIlI.getSize().width * (1.0 - this.getValue())), this.renderer.getHeight(false))), false);
        this.renderer.renderRect(lIIIIlllIlI, this.title, this.hasFocus(lIIIIlllIlI), true, new Rectangle(lIIIIlllIlI.getPos(), new Dimension((int)(lIIIIlllIlI.getSize().width * this.getValue()), this.renderer.getHeight(false))), true);
    }
    
    protected abstract double getValue();
    
    @Override
    public void handleButton(final Context lIIIIllIIIl, final int lIIIIllIIII) {
        super.handleButton(lIIIIllIIIl, lIIIIllIIII);
        if (lIIIIllIIII == 0 && lIIIIllIIIl.isClicked()) {
            this.attached = true;
        }
    }
    
    public Slider(final String lIIIlIIlIII, final String lIIIlIIIlll, final Renderer lIIIlIIIllI) {
        super(lIIIlIIlIII, lIIIlIIIlll, lIIIlIIIllI);
        this.attached = false;
    }
    
    protected abstract void setValue(final double p0);
}
