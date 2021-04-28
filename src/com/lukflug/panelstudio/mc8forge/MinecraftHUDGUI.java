package com.lukflug.panelstudio.mc8forge;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import com.lukflug.panelstudio.hud.*;
import com.lukflug.panelstudio.*;

public abstract class MinecraftHUDGUI extends MinecraftGUI
{
    protected /* synthetic */ boolean hudEditor;
    
    public void handleKeyEvent(final int llllllllllllllIlllIIIllIllIIIIlI) {
        if (llllllllllllllIlllIIIllIllIIIIlI != 1 && !this.getHUDGUI().isOn() && !this.hudEditor) {
            this.getHUDGUI().handleKey(llllllllllllllIlllIIIllIllIIIIlI);
        }
    }
    
    public void enterHUDEditor() {
        this.hudEditor = true;
        if (this.getHUDGUI().isOn()) {
            this.getHUDGUI().toggle();
        }
        Minecraft.getMinecraft().displayGuiScreen(this);
    }
    
    protected abstract HUDClickGUI getHUDGUI();
    
    public MinecraftHUDGUI() {
        this.hudEditor = false;
    }
    
    @Override
    public void exitGUI() {
        this.hudEditor = false;
        super.exitGUI();
    }
    
    @Override
    public void enterGUI() {
        this.hudEditor = false;
        super.enterGUI();
    }
    
    public void render() {
        if (!this.getHUDGUI().isOn() && !this.hudEditor) {
            this.renderGUI();
        }
    }
    
    @Override
    protected ClickGUI getGUI() {
        return this.getHUDGUI();
    }
}
