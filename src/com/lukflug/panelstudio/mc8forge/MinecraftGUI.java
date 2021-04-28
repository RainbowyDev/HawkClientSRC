package com.lukflug.panelstudio.mc8forge;

import net.minecraft.client.gui.*;
import java.awt.*;
import com.lukflug.panelstudio.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;

public abstract class MinecraftGUI extends GuiScreen
{
    private /* synthetic */ boolean rButton;
    private /* synthetic */ boolean lButton;
    private /* synthetic */ Point mouse;
    
    protected abstract GUIInterface getInterface();
    
    @Override
    protected void keyTyped(final char llllllllllllllIlllIIlIIlIIIIlIlI, final int llllllllllllllIlllIIlIIlIIIIlIIl) {
        if (llllllllllllllIlllIIlIIlIIIIlIIl == 1) {
            this.exitGUI();
        }
        else {
            this.getGUI().handleKey(llllllllllllllIlllIIlIIlIIIIlIIl);
        }
    }
    
    public MinecraftGUI() {
        this.mouse = new Point();
        this.lButton = false;
        this.rButton = false;
    }
    
    protected abstract int getScrollSpeed();
    
    protected abstract ClickGUI getGUI();
    
    protected void renderGUI() {
        this.getInterface().getMatrices();
        GLInterface.begin();
        this.getGUI().render();
        GLInterface.end();
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    public void enterGUI() {
        Minecraft.getMinecraft().displayGuiScreen(this);
        this.getGUI().enter();
    }
    
    public void mouseClicked(final int llllllllllllllIlllIIlIIlIIlIIIII, final int llllllllllllllIlllIIlIIlIIIlllll, final int llllllllllllllIlllIIlIIlIIIllllI) {
        this.mouse = new Point(llllllllllllllIlllIIlIIlIIlIIIII, llllllllllllllIlllIIlIIlIIIlllll);
        switch (llllllllllllllIlllIIlIIlIIIllllI) {
            case 0: {
                this.lButton = true;
                break;
            }
            case 1: {
                this.rButton = true;
                break;
            }
        }
        this.getGUI().handleButton(llllllllllllllIlllIIlIIlIIIllllI);
    }
    
    public void exitGUI() {
        this.getGUI().exit();
        Minecraft.getMinecraft().displayGuiScreen(null);
    }
    
    public void mouseReleased(final int llllllllllllllIlllIIlIIlIIIlIlII, final int llllllllllllllIlllIIlIIlIIIlIIll, final int llllllllllllllIlllIIlIIlIIIIlllI) {
        this.mouse = new Point(llllllllllllllIlllIIlIIlIIIlIlII, llllllllllllllIlllIIlIIlIIIlIIll);
        switch (llllllllllllllIlllIIlIIlIIIIlllI) {
            case 0: {
                this.lButton = false;
                break;
            }
            case 1: {
                this.rButton = false;
                break;
            }
        }
        this.getGUI().handleButton(llllllllllllllIlllIIlIIlIIIIlllI);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlllIIlIIlIIlIllIl, final int llllllllllllllIlllIIlIIlIIlIllII, final float llllllllllllllIlllIIlIIlIIlIlIll) {
        this.mouse = new Point(llllllllllllllIlllIIlIIlIIlIllIl, llllllllllllllIlllIIlIIlIIlIllII);
        this.renderGUI();
        final int llllllllllllllIlllIIlIIlIIlIlIlI = Mouse.getDWheel();
        if (llllllllllllllIlllIIlIIlIIlIlIlI != 0) {
            if (llllllllllllllIlllIIlIIlIIlIlIlI > 0) {
                this.getGUI().handleScroll(-this.getScrollSpeed());
            }
            else {
                this.getGUI().handleScroll(this.getScrollSpeed());
            }
        }
    }
    
    public abstract class GUIInterface extends GLInterface
    {
        @Override
        protected float getZLevel() {
            return MinecraftGUI.this.zLevel;
        }
        
        public GUIInterface(final boolean llllllllllllllIlIlIIlIlllllIllII) {
            super(llllllllllllllIlIlIIlIlllllIllII);
        }
        
        @Override
        public Point getMouse() {
            return new Point(MinecraftGUI.this.mouse);
        }
        
        @Override
        public boolean getButton(final int llllllllllllllIlIlIIlIlllllIIIll) {
            switch (llllllllllllllIlIlIIlIlllllIIIll) {
                case 0: {
                    return MinecraftGUI.this.lButton;
                }
                case 1: {
                    return MinecraftGUI.this.rButton;
                }
                default: {
                    return false;
                }
            }
        }
    }
}
