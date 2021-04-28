package com.lukflug.panelstudio;

import java.awt.*;

public interface Interface
{
    int loadImage(final String p0);
    
    int getFontWidth(final String p0);
    
    Point getMouse();
    
    void drawRect(final Rectangle p0, final Color p1, final Color p2, final Color p3, final Color p4);
    
    void fillTriangle(final Point p0, final Point p1, final Point p2, final Color p3, final Color p4, final Color p5);
    
    int getFontHeight();
    
    void window(final Rectangle p0);
    
    void restore();
    
    void drawString(final Point p0, final String p1, final Color p2);
    
    boolean getButton(final int p0);
    
    void fillRect(final Rectangle p0, final Color p1, final Color p2, final Color p3, final Color p4);
    
    void drawLine(final Point p0, final Point p1, final Color p2, final Color p3);
    
    void drawImage(final Rectangle p0, final int p1, final boolean p2, final int p3);
}
