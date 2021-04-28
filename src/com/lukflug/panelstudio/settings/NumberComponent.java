package com.lukflug.panelstudio.settings;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;

public class NumberComponent extends Slider
{
    protected /* synthetic */ NumberSetting setting;
    protected /* synthetic */ String text;
    
    public NumberComponent(final String lllllllllllllllIIIIlIlIllllIIllI, final String lllllllllllllllIIIIlIlIllllIIlIl, final Renderer lllllllllllllllIIIIlIlIllllIlIll, final NumberSetting lllllllllllllllIIIIlIlIllllIIIll, final double lllllllllllllllIIIIlIlIllllIlIIl, final double lllllllllllllllIIIIlIlIllllIlIII) {
        super("", lllllllllllllllIIIIlIlIllllIIlIl, lllllllllllllllIIIIlIlIllllIlIll);
        this.setting = lllllllllllllllIIIIlIlIllllIIIll;
        this.text = lllllllllllllllIIIIlIlIllllIIllI;
    }
    
    @Override
    protected double getValue() {
        return (this.setting.getNumber() - this.setting.getMinimumValue()) / (this.setting.getMaximumValue() - this.setting.getMinimumValue());
    }
    
    @Override
    protected void setValue(final double lllllllllllllllIIIIlIlIlllIlIllI) {
        this.setting.setNumber(lllllllllllllllIIIIlIlIlllIlIllI * (this.setting.getMaximumValue() - this.setting.getMinimumValue()) + this.setting.getMinimumValue());
    }
    
    @Override
    public void render(final Context lllllllllllllllIIIIlIlIlllIlllIl) {
        if (this.setting.getPrecision() == 0) {
            this.title = String.format("%s: §7%d", this.text, (int)this.setting.getNumber());
        }
        else {
            this.title = String.format(String.valueOf(new StringBuilder("%s: §7%.").append(this.setting.getPrecision()).append("f")), this.text, this.setting.getNumber());
        }
        super.render(lllllllllllllllIIIIlIlIlllIlllIl);
    }
}
