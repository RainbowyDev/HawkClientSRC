package com.lukflug.panelstudio.settings;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;
import java.awt.*;

public class ColorComponent extends CollapsibleContainer
{
    protected final /* synthetic */ boolean alpha;
    protected final /* synthetic */ boolean rainbow;
    protected /* synthetic */ ColorSetting setting;
    protected /* synthetic */ ColorScheme overrideScheme;
    protected /* synthetic */ Toggleable colorModel;
    protected /* synthetic */ ColorScheme scheme;
    
    @Override
    public void render(final Context lllllllllllllllllllllIIlIlIIlIII) {
        this.renderer.overrideColorScheme(this.scheme);
        super.render(lllllllllllllllllllllIIlIlIIlIII);
        this.renderer.restoreColorScheme();
    }
    
    public ColorComponent(final String lllllllllllllllllllllIIlIlIlIlII, final String lllllllllllllllllllllIIlIlIlIIll, final Renderer lllllllllllllllllllllIIlIlIlllII, final Animation lllllllllllllllllllllIIlIlIlIIIl, final Renderer lllllllllllllllllllllIIlIlIllIlI, final ColorSetting lllllllllllllllllllllIIlIlIllIIl, final boolean lllllllllllllllllllllIIlIlIIlllI, final boolean lllllllllllllllllllllIIlIlIIllIl, final Toggleable lllllllllllllllllllllIIlIlIlIllI) {
        super(lllllllllllllllllllllIIlIlIlIlII, lllllllllllllllllllllIIlIlIlIIll, lllllllllllllllllllllIIlIlIlllII, new SimpleToggleable(false), lllllllllllllllllllllIIlIlIlIIIl, null);
        this.setting = lllllllllllllllllllllIIlIlIllIIl;
        this.alpha = lllllllllllllllllllllIIlIlIIlllI;
        this.rainbow = lllllllllllllllllllllIIlIlIIllIl;
        this.scheme = new ColorSettingScheme(lllllllllllllllllllllIIlIlIlllII);
        this.overrideScheme = new ColorSettingScheme(lllllllllllllllllllllIIlIlIllIlI);
        this.colorModel = lllllllllllllllllllllIIlIlIlIllI;
        if (lllllllllllllllllllllIIlIlIIllIl) {
            this.addComponent(new ColorButton(lllllllllllllllllllllIIlIlIllIlI));
        }
        this.addComponent(new ColorSlider(lllllllllllllllllllllIIlIlIllIlI, 0));
        this.addComponent(new ColorSlider(lllllllllllllllllllllIIlIlIllIlI, 1));
        this.addComponent(new ColorSlider(lllllllllllllllllllllIIlIlIllIlI, 2));
        if (lllllllllllllllllllllIIlIlIIlllI) {
            this.addComponent(new ColorSlider(lllllllllllllllllllllIIlIlIllIlI, 3));
        }
    }
    
    protected class ColorButton extends FocusableComponent
    {
        @Override
        public void handleButton(final Context llllllllllllllIllIIllIIlIIIlIIll, final int llllllllllllllIllIIllIIlIIIlIlIl) {
            super.handleButton(llllllllllllllIllIIllIIlIIIlIIll, llllllllllllllIllIIllIIlIIIlIlIl);
            if (llllllllllllllIllIIllIIlIIIlIlIl == 0 && llllllllllllllIllIIllIIlIIIlIIll.isClicked()) {
                ColorComponent.this.setting.setRainbow(!ColorComponent.this.setting.getRainbow());
            }
        }
        
        @Override
        public void render(final Context llllllllllllllIllIIllIIlIIIlllIl) {
            super.render(llllllllllllllIllIIllIIlIIIlllIl);
            this.renderer.overrideColorScheme(ColorComponent.this.overrideScheme);
            this.renderer.renderTitle(llllllllllllllIllIIllIIlIIIlllIl, this.title, this.hasFocus(llllllllllllllIllIIllIIlIIIlllIl), ColorComponent.this.setting.getRainbow());
            this.renderer.restoreColorScheme();
        }
        
        public ColorButton(final Renderer llllllllllllllIllIIllIIlIIlIIIIl) {
            super("Rainbow", null, llllllllllllllIllIIllIIlIIlIIIIl);
        }
    }
    
    protected class ColorSlider extends Slider
    {
        private final /* synthetic */ int value;
        
        protected String getTitle(final int llllllllllllllllIIllIlIIllIIIIIl) {
            switch (llllllllllllllllIIllIlIIllIIIIIl) {
                case 0: {
                    return String.valueOf(new StringBuilder(String.valueOf(ColorComponent.this.colorModel.isOn() ? "Hue:" : "Red:")).append(" §7"));
                }
                case 1: {
                    return String.valueOf(new StringBuilder(String.valueOf(ColorComponent.this.colorModel.isOn() ? "Saturation:" : "Green:")).append(" §7"));
                }
                case 2: {
                    return String.valueOf(new StringBuilder(String.valueOf(ColorComponent.this.colorModel.isOn() ? "Brightness:" : "Blue:")).append(" §7"));
                }
                case 3: {
                    return "Alpha: §7";
                }
                default: {
                    return "";
                }
            }
        }
        
        @Override
        public void render(final Context llllllllllllllllIIllIlIIllIllIll) {
            this.title = String.valueOf(new StringBuilder(String.valueOf(this.getTitle(this.value))).append((int)(this.getMax() * this.getValue())));
            this.renderer.overrideColorScheme(ColorComponent.this.overrideScheme);
            super.render(llllllllllllllllIIllIlIIllIllIll);
            this.renderer.restoreColorScheme();
        }
        
        protected int getMax() {
            if (!ColorComponent.this.colorModel.isOn()) {
                return 255;
            }
            if (this.value == 0) {
                return 360;
            }
            if (this.value < 3) {
                return 100;
            }
            return 255;
        }
        
        public ColorSlider(final Renderer llllllllllllllllIIllIlIIlllIIlII, final int llllllllllllllllIIllIlIIlllIIIll) {
            super("", null, llllllllllllllllIIllIlIIlllIIlII);
            this.value = llllllllllllllllIIllIlIIlllIIIll;
        }
        
        @Override
        protected double getValue() {
            final Color llllllllllllllllIIllIlIIllIlIlIl = ColorComponent.this.setting.getColor();
            if (this.value < 3) {
                if (ColorComponent.this.colorModel.isOn()) {
                    return Color.RGBtoHSB(llllllllllllllllIIllIlIIllIlIlIl.getRed(), llllllllllllllllIIllIlIIllIlIlIl.getGreen(), llllllllllllllllIIllIlIIllIlIlIl.getBlue(), null)[this.value];
                }
                switch (this.value) {
                    case 0: {
                        return llllllllllllllllIIllIlIIllIlIlIl.getRed() / 255.0;
                    }
                    case 1: {
                        return llllllllllllllllIIllIlIIllIlIlIl.getGreen() / 255.0;
                    }
                    case 2: {
                        return llllllllllllllllIIllIlIIllIlIlIl.getBlue() / 255.0;
                    }
                }
            }
            return llllllllllllllllIIllIlIIllIlIlIl.getAlpha() / 255.0;
        }
        
        @Override
        protected void setValue(final double llllllllllllllllIIllIlIIllIIllIl) {
            Color llllllllllllllllIIllIlIIllIIllII = ColorComponent.this.setting.getColor();
            final float[] llllllllllllllllIIllIlIIllIIlIll = Color.RGBtoHSB(llllllllllllllllIIllIlIIllIIllII.getRed(), llllllllllllllllIIllIlIIllIIllII.getGreen(), llllllllllllllllIIllIlIIllIIllII.getBlue(), null);
            switch (this.value) {
                case 0: {
                    if (ColorComponent.this.colorModel.isOn()) {
                        llllllllllllllllIIllIlIIllIIllII = Color.getHSBColor((float)llllllllllllllllIIllIlIIllIIllIl, llllllllllllllllIIllIlIIllIIlIll[1], llllllllllllllllIIllIlIIllIIlIll[2]);
                    }
                    else {
                        llllllllllllllllIIllIlIIllIIllII = new Color((int)(255.0 * llllllllllllllllIIllIlIIllIIllIl), llllllllllllllllIIllIlIIllIIllII.getGreen(), llllllllllllllllIIllIlIIllIIllII.getBlue());
                    }
                    if (ColorComponent.this.alpha) {
                        ColorComponent.this.setting.setValue(new Color(llllllllllllllllIIllIlIIllIIllII.getRed(), llllllllllllllllIIllIlIIllIIllII.getGreen(), llllllllllllllllIIllIlIIllIIllII.getBlue(), ColorComponent.this.setting.getColor().getAlpha()));
                        break;
                    }
                    ColorComponent.this.setting.setValue(llllllllllllllllIIllIlIIllIIllII);
                    break;
                }
                case 1: {
                    if (ColorComponent.this.colorModel.isOn()) {
                        llllllllllllllllIIllIlIIllIIllII = Color.getHSBColor(llllllllllllllllIIllIlIIllIIlIll[0], (float)llllllllllllllllIIllIlIIllIIllIl, llllllllllllllllIIllIlIIllIIlIll[2]);
                    }
                    else {
                        llllllllllllllllIIllIlIIllIIllII = new Color(llllllllllllllllIIllIlIIllIIllII.getRed(), (int)(255.0 * llllllllllllllllIIllIlIIllIIllIl), llllllllllllllllIIllIlIIllIIllII.getBlue());
                    }
                    if (ColorComponent.this.alpha) {
                        ColorComponent.this.setting.setValue(new Color(llllllllllllllllIIllIlIIllIIllII.getRed(), llllllllllllllllIIllIlIIllIIllII.getGreen(), llllllllllllllllIIllIlIIllIIllII.getBlue(), ColorComponent.this.setting.getColor().getAlpha()));
                        break;
                    }
                    ColorComponent.this.setting.setValue(llllllllllllllllIIllIlIIllIIllII);
                    break;
                }
                case 2: {
                    if (ColorComponent.this.colorModel.isOn()) {
                        llllllllllllllllIIllIlIIllIIllII = Color.getHSBColor(llllllllllllllllIIllIlIIllIIlIll[0], llllllllllllllllIIllIlIIllIIlIll[1], (float)llllllllllllllllIIllIlIIllIIllIl);
                    }
                    else {
                        llllllllllllllllIIllIlIIllIIllII = new Color(llllllllllllllllIIllIlIIllIIllII.getRed(), llllllllllllllllIIllIlIIllIIllII.getGreen(), (int)(255.0 * llllllllllllllllIIllIlIIllIIllIl));
                    }
                    if (ColorComponent.this.alpha) {
                        ColorComponent.this.setting.setValue(new Color(llllllllllllllllIIllIlIIllIIllII.getRed(), llllllllllllllllIIllIlIIllIIllII.getGreen(), llllllllllllllllIIllIlIIllIIllII.getBlue(), ColorComponent.this.setting.getColor().getAlpha()));
                        break;
                    }
                    ColorComponent.this.setting.setValue(llllllllllllllllIIllIlIIllIIllII);
                    break;
                }
                case 3: {
                    ColorComponent.this.setting.setValue(new Color(llllllllllllllllIIllIlIIllIIllII.getRed(), llllllllllllllllIIllIlIIllIIllII.getGreen(), llllllllllllllllIIllIlIIllIIllII.getBlue(), (int)(255.0 * llllllllllllllllIIllIlIIllIIllIl)));
                    break;
                }
            }
        }
    }
    
    protected class ColorSettingScheme implements ColorScheme
    {
        /* synthetic */ ColorScheme scheme;
        
        public ColorSettingScheme(final Renderer lllllllllllllllIIIIlIllIllIIlIII) {
            this.scheme = lllllllllllllllIIIIlIllIllIIlIII.getDefaultColorScheme();
        }
        
        @Override
        public Color getBackgroundColor() {
            return this.scheme.getBackgroundColor();
        }
        
        @Override
        public Color getOutlineColor() {
            return this.scheme.getOutlineColor();
        }
        
        @Override
        public Color getFontColor() {
            return this.scheme.getFontColor();
        }
        
        @Override
        public Color getInactiveColor() {
            return this.scheme.getInactiveColor();
        }
        
        @Override
        public int getOpacity() {
            return this.scheme.getOpacity();
        }
        
        @Override
        public Color getActiveColor() {
            return ColorComponent.this.setting.getValue();
        }
    }
}
