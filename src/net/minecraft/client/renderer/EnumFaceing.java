package net.minecraft.client.renderer;

import net.minecraft.util.*;

public enum EnumFaceing
{
    NORTH("NORTH", 2, "NORTH", 2, new VertexInformation[] { new VertexInformation(Constants.field_179180_c, Constants.field_179179_b, Constants.field_179177_d, null), new VertexInformation(Constants.field_179180_c, Constants.field_179178_e, Constants.field_179177_d, null), new VertexInformation(Constants.field_179176_f, Constants.field_179178_e, Constants.field_179177_d, null), new VertexInformation(Constants.field_179176_f, Constants.field_179179_b, Constants.field_179177_d, null) }), 
    EAST("EAST", 5, "EAST", 5, new VertexInformation[] { new VertexInformation(Constants.field_179180_c, Constants.field_179179_b, Constants.field_179181_a, null), new VertexInformation(Constants.field_179180_c, Constants.field_179178_e, Constants.field_179181_a, null), new VertexInformation(Constants.field_179180_c, Constants.field_179178_e, Constants.field_179177_d, null), new VertexInformation(Constants.field_179180_c, Constants.field_179179_b, Constants.field_179177_d, null) }), 
    DOWN("DOWN", 0, "DOWN", 0, new VertexInformation[] { new VertexInformation(Constants.field_179176_f, Constants.field_179178_e, Constants.field_179181_a, null), new VertexInformation(Constants.field_179176_f, Constants.field_179178_e, Constants.field_179177_d, null), new VertexInformation(Constants.field_179180_c, Constants.field_179178_e, Constants.field_179177_d, null), new VertexInformation(Constants.field_179180_c, Constants.field_179178_e, Constants.field_179181_a, null) }), 
    UP("UP", 1, "UP", 1, new VertexInformation[] { new VertexInformation(Constants.field_179176_f, Constants.field_179179_b, Constants.field_179177_d, null), new VertexInformation(Constants.field_179176_f, Constants.field_179179_b, Constants.field_179181_a, null), new VertexInformation(Constants.field_179180_c, Constants.field_179179_b, Constants.field_179181_a, null), new VertexInformation(Constants.field_179180_c, Constants.field_179179_b, Constants.field_179177_d, null) }), 
    WEST("WEST", 4, "WEST", 4, new VertexInformation[] { new VertexInformation(Constants.field_179176_f, Constants.field_179179_b, Constants.field_179177_d, null), new VertexInformation(Constants.field_179176_f, Constants.field_179178_e, Constants.field_179177_d, null), new VertexInformation(Constants.field_179176_f, Constants.field_179178_e, Constants.field_179181_a, null), new VertexInformation(Constants.field_179176_f, Constants.field_179179_b, Constants.field_179181_a, null) });
    
    private final /* synthetic */ VertexInformation[] field_179035_h;
    private static final /* synthetic */ EnumFaceing[] field_179029_g;
    
    SOUTH("SOUTH", 3, "SOUTH", 3, new VertexInformation[] { new VertexInformation(Constants.field_179176_f, Constants.field_179179_b, Constants.field_179181_a, null), new VertexInformation(Constants.field_179176_f, Constants.field_179178_e, Constants.field_179181_a, null), new VertexInformation(Constants.field_179180_c, Constants.field_179178_e, Constants.field_179181_a, null), new VertexInformation(Constants.field_179180_c, Constants.field_179179_b, Constants.field_179181_a, null) });
    
    public VertexInformation func_179025_a(final int lIllIIlIlllIlI) {
        return this.field_179035_h[lIllIIlIlllIlI];
    }
    
    static {
        __OBFID = "CL_00002562";
        field_179029_g = new EnumFaceing[6];
        EnumFaceing.field_179029_g[Constants.field_179178_e] = EnumFaceing.DOWN;
        EnumFaceing.field_179029_g[Constants.field_179179_b] = EnumFaceing.UP;
        EnumFaceing.field_179029_g[Constants.field_179177_d] = EnumFaceing.NORTH;
        EnumFaceing.field_179029_g[Constants.field_179181_a] = EnumFaceing.SOUTH;
        EnumFaceing.field_179029_g[Constants.field_179176_f] = EnumFaceing.WEST;
        EnumFaceing.field_179029_g[Constants.field_179180_c] = EnumFaceing.EAST;
    }
    
    public static EnumFaceing func_179027_a(final EnumFacing lIllIIllIIlIlI) {
        return EnumFaceing.field_179029_g[lIllIIllIIlIlI.getIndex()];
    }
    
    private EnumFaceing(final String lIllIIllIIIIII, final int lIllIIlIllllll, final String lIllIIllIIIlII, final int lIllIIllIIIIll, final VertexInformation... lIllIIlIlllllI) {
        this.field_179035_h = lIllIIlIlllllI;
    }
    
    public static final class Constants
    {
        public static final /* synthetic */ int field_179177_d;
        public static final /* synthetic */ int field_179180_c;
        public static final /* synthetic */ int field_179176_f;
        public static final /* synthetic */ int field_179179_b;
        public static final /* synthetic */ int field_179181_a;
        public static final /* synthetic */ int field_179178_e;
        
        static {
            __OBFID = "CL_00002560";
            field_179181_a = EnumFacing.SOUTH.getIndex();
            field_179179_b = EnumFacing.UP.getIndex();
            field_179180_c = EnumFacing.EAST.getIndex();
            field_179177_d = EnumFacing.NORTH.getIndex();
            field_179178_e = EnumFacing.DOWN.getIndex();
            field_179176_f = EnumFacing.WEST.getIndex();
        }
    }
    
    public static class VertexInformation
    {
        public final /* synthetic */ int field_179183_c;
        public final /* synthetic */ int field_179184_a;
        public final /* synthetic */ int field_179182_b;
        
        static {
            __OBFID = "CL_00002559";
        }
        
        private VertexInformation(final int llllllllllllllIlIlIlIIIlllIIIIll, final int llllllllllllllIlIlIlIIIlllIIIllI, final int llllllllllllllIlIlIlIIIlllIIIIIl) {
            this.field_179184_a = llllllllllllllIlIlIlIIIlllIIIIll;
            this.field_179182_b = llllllllllllllIlIlIlIIIlllIIIllI;
            this.field_179183_c = llllllllllllllIlIlIlIIIlllIIIIIl;
        }
        
        VertexInformation(final int llllllllllllllIlIlIlIIIllIlllIll, final int llllllllllllllIlIlIlIIIllIllIlIl, final int llllllllllllllIlIlIlIIIllIllIlII, final Object llllllllllllllIlIlIlIIIllIlllIII) {
            this(llllllllllllllIlIlIlIIIllIlllIll, llllllllllllllIlIlIlIIIllIllIlIl, llllllllllllllIlIlIlIIIllIllIlII);
        }
    }
}
