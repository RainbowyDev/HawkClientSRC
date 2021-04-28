package net.minecraft.client.resources;

import net.minecraft.util.*;
import java.util.*;

public class DefaultPlayerSkin
{
    private static final /* synthetic */ ResourceLocation field_177336_b;
    private static final /* synthetic */ ResourceLocation field_177337_a;
    
    public static String func_177332_b(final UUID llllllllllllllllIlIlIIIIlllIlllI) {
        return func_177333_c(llllllllllllllllIlIlIIIIlllIlllI) ? "slim" : "default";
    }
    
    public static ResourceLocation func_177334_a(final UUID llllllllllllllllIlIlIIIIllllIIIl) {
        return func_177333_c(llllllllllllllllIlIlIIIIllllIIIl) ? DefaultPlayerSkin.field_177336_b : DefaultPlayerSkin.field_177337_a;
    }
    
    static {
        __OBFID = "CL_00002396";
        field_177337_a = new ResourceLocation("textures/entity/steve.png");
        field_177336_b = new ResourceLocation("textures/entity/alex.png");
    }
    
    public static ResourceLocation func_177335_a() {
        return DefaultPlayerSkin.field_177337_a;
    }
    
    private static boolean func_177333_c(final UUID llllllllllllllllIlIlIIIIlllIlIlI) {
        return (llllllllllllllllIlIlIIIIlllIlIlI.hashCode() & 0x1) == 0x1;
    }
}
