package net.minecraft.util;

public abstract class LazyLoadBase
{
    private /* synthetic */ boolean isLoaded;
    private /* synthetic */ Object value;
    
    static {
        __OBFID = "CL_00002263";
    }
    
    protected abstract Object load();
    
    public Object getValue() {
        if (!this.isLoaded) {
            this.isLoaded = true;
            this.value = this.load();
        }
        return this.value;
    }
    
    public LazyLoadBase() {
        this.isLoaded = false;
    }
}
