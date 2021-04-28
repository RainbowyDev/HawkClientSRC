package net.minecraft.client.resources;

import net.minecraft.client.gui.*;

public class ResourcePackListEntryFound extends ResourcePackListEntry
{
    private final /* synthetic */ ResourcePackRepository.Entry field_148319_c;
    
    @Override
    protected String func_148312_b() {
        return this.field_148319_c.getResourcePackName();
    }
    
    static {
        __OBFID = "CL_00000823";
    }
    
    public ResourcePackListEntryFound(final GuiScreenResourcePacks llllllllllllllIlllIlIIIIIIIIIIIl, final ResourcePackRepository.Entry llllllllllllllIlllIlIIIIIIIIIIII) {
        super(llllllllllllllIlllIlIIIIIIIIIIIl);
        this.field_148319_c = llllllllllllllIlllIlIIIIIIIIIIII;
    }
    
    @Override
    protected void func_148313_c() {
        this.field_148319_c.bindTexturePackIcon(this.field_148317_a.getTextureManager());
    }
    
    public ResourcePackRepository.Entry func_148318_i() {
        return this.field_148319_c;
    }
    
    @Override
    protected String func_148311_a() {
        return this.field_148319_c.getTexturePackDescription();
    }
}
