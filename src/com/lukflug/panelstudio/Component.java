package com.lukflug.panelstudio;

public interface Component
{
    void releaseFocus();
    
    void handleScroll(final Context p0, final int p1);
    
    void exit(final Context p0);
    
    void enter(final Context p0);
    
    void getHeight(final Context p0);
    
    void handleKey(final Context p0, final int p1);
    
    String getTitle();
    
    void handleButton(final Context p0, final int p1);
    
    void render(final Context p0);
}
