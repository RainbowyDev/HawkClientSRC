package net.minecraft.util;

import org.lwjgl.input.*;
import org.lwjgl.opengl.*;

public class MouseHelper
{
    public /* synthetic */ int deltaX;
    public /* synthetic */ int deltaY;
    
    public void grabMouseCursor() {
        Mouse.setGrabbed(true);
        this.deltaX = 0;
        this.deltaY = 0;
    }
    
    public void mouseXYChange() {
        this.deltaX = Mouse.getDX();
        this.deltaY = Mouse.getDY();
    }
    
    static {
        __OBFID = "CL_00000648";
    }
    
    public void ungrabMouseCursor() {
        Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
        Mouse.setGrabbed(false);
    }
}
