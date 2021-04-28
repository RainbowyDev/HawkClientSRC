package com.lukflug.panelstudio.theme;

public abstract class ThemeMultiplexer implements Theme
{
    protected final /* synthetic */ Renderer containerRenderer;
    protected final /* synthetic */ Renderer panelRenderer;
    protected final /* synthetic */ Renderer componentRenderer;
    
    @Override
    public Renderer getPanelRenderer() {
        return this.panelRenderer;
    }
    
    @Override
    public Renderer getComponentRenderer() {
        return this.componentRenderer;
    }
    
    public ThemeMultiplexer() {
        this.panelRenderer = new PanelRenderer();
        this.containerRenderer = new ContainerRenderer();
        this.componentRenderer = new ComponentRenderer();
    }
    
    @Override
    public Renderer getContainerRenderer() {
        return this.containerRenderer;
    }
    
    protected abstract Theme getTheme();
    
    protected class ComponentRenderer extends RendererProxy
    {
        @Override
        protected Renderer getRenderer() {
            return ThemeMultiplexer.this.getTheme().getComponentRenderer();
        }
    }
    
    protected class PanelRenderer extends RendererProxy
    {
        @Override
        protected Renderer getRenderer() {
            return ThemeMultiplexer.this.getTheme().getPanelRenderer();
        }
    }
    
    protected class ContainerRenderer extends RendererProxy
    {
        @Override
        protected Renderer getRenderer() {
            return ThemeMultiplexer.this.getTheme().getContainerRenderer();
        }
    }
}
