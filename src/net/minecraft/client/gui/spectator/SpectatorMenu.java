package net.minecraft.client.gui.spectator;

import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.client.gui.spectator.categories.*;
import com.google.common.base.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public class SpectatorMenu
{
    private static final /* synthetic */ ISpectatorMenuObject field_178655_b;
    private static final /* synthetic */ ISpectatorMenuObject field_178653_d;
    private /* synthetic */ int field_178658_j;
    public static final /* synthetic */ ISpectatorMenuObject field_178657_a;
    private static final /* synthetic */ ISpectatorMenuObject field_178654_e;
    private static final /* synthetic */ ISpectatorMenuObject field_178656_c;
    private /* synthetic */ int field_178660_i;
    private final /* synthetic */ List field_178652_g;
    private /* synthetic */ ISpectatorMenuView field_178659_h;
    private final /* synthetic */ ISpectatorMenuReciepient field_178651_f;
    
    public void func_178647_a(final ISpectatorMenuView llllllllllllllllIIlIIllIIIIIlIll) {
        this.field_178652_g.add(this.func_178646_f());
        this.field_178659_h = llllllllllllllllIIlIIllIIIIIlIll;
        this.field_178660_i = -1;
        this.field_178658_j = 0;
    }
    
    public int func_178648_e() {
        return this.field_178660_i;
    }
    
    static {
        __OBFID = "CL_00001927";
        field_178655_b = new EndSpectatorObject(null);
        field_178656_c = new MoveMenuObject(-1, true);
        field_178653_d = new MoveMenuObject(1, true);
        field_178654_e = new MoveMenuObject(1, false);
        field_178657_a = new ISpectatorMenuObject() {
            static {
                __OBFID = "CL_00001926";
            }
            
            @Override
            public void func_178663_a(final float llllllllllllllllIIIIllIIllIIllII, final int llllllllllllllllIIIIllIIllIIlIll) {
            }
            
            @Override
            public IChatComponent func_178664_z_() {
                return new ChatComponentText("");
            }
            
            @Override
            public boolean func_178662_A_() {
                return false;
            }
            
            @Override
            public void func_178661_a(final SpectatorMenu llllllllllllllllIIIIllIIllIIllll) {
            }
        };
    }
    
    public void func_178644_b(final int llllllllllllllllIIlIIllIIIIllIII) {
        final ISpectatorMenuObject llllllllllllllllIIlIIllIIIIllIlI = this.func_178643_a(llllllllllllllllIIlIIllIIIIllIII);
        if (llllllllllllllllIIlIIllIIIIllIlI != SpectatorMenu.field_178657_a) {
            if (this.field_178660_i == llllllllllllllllIIlIIllIIIIllIII && llllllllllllllllIIlIIllIIIIllIlI.func_178662_A_()) {
                llllllllllllllllIIlIIllIIIIllIlI.func_178661_a(this);
            }
            else {
                this.field_178660_i = llllllllllllllllIIlIIllIIIIllIII;
            }
        }
    }
    
    public ISpectatorMenuObject func_178645_b() {
        return this.func_178643_a(this.field_178660_i);
    }
    
    public void func_178641_d() {
        this.field_178651_f.func_175257_a(this);
    }
    
    public List func_178642_a() {
        final ArrayList llllllllllllllllIIlIIllIIIlIlIlI = Lists.newArrayList();
        for (int llllllllllllllllIIlIIllIIIlIlIIl = 0; llllllllllllllllIIlIIllIIIlIlIIl <= 8; ++llllllllllllllllIIlIIllIIIlIlIIl) {
            llllllllllllllllIIlIIllIIIlIlIlI.add(this.func_178643_a(llllllllllllllllIIlIIllIIIlIlIIl));
        }
        return llllllllllllllllIIlIIllIIIlIlIlI;
    }
    
    public SpectatorDetails func_178646_f() {
        return new SpectatorDetails(this.field_178659_h, this.func_178642_a(), this.field_178660_i);
    }
    
    public SpectatorMenu(final ISpectatorMenuReciepient llllllllllllllllIIlIIllIIIlllIlI) {
        this.field_178652_g = Lists.newArrayList();
        this.field_178659_h = new BaseSpectatorGroup();
        this.field_178660_i = -1;
        this.field_178651_f = llllllllllllllllIIlIIllIIIlllIlI;
    }
    
    static /* synthetic */ void access$0(final SpectatorMenu llllllllllllllllIIlIIllIIIIIIlIl, final int llllllllllllllllIIlIIllIIIIIIlII) {
        llllllllllllllllIIlIIllIIIIIIlIl.field_178658_j = llllllllllllllllIIlIIllIIIIIIlII;
    }
    
    public ISpectatorMenuObject func_178643_a(final int llllllllllllllllIIlIIllIIIllIIll) {
        final int llllllllllllllllIIlIIllIIIllIIlI = llllllllllllllllIIlIIllIIIllIIll + this.field_178658_j * 6;
        return (ISpectatorMenuObject)((this.field_178658_j > 0 && llllllllllllllllIIlIIllIIIllIIll == 0) ? SpectatorMenu.field_178656_c : ((llllllllllllllllIIlIIllIIIllIIll == 7) ? ((llllllllllllllllIIlIIllIIIllIIlI < this.field_178659_h.func_178669_a().size()) ? SpectatorMenu.field_178653_d : SpectatorMenu.field_178654_e) : ((llllllllllllllllIIlIIllIIIllIIll == 8) ? SpectatorMenu.field_178655_b : ((llllllllllllllllIIlIIllIIIllIIlI >= 0 && llllllllllllllllIIlIIllIIIllIIlI < this.field_178659_h.func_178669_a().size()) ? Objects.firstNonNull(this.field_178659_h.func_178669_a().get(llllllllllllllllIIlIIllIIIllIIlI), (Object)SpectatorMenu.field_178657_a) : SpectatorMenu.field_178657_a))));
    }
    
    public ISpectatorMenuView func_178650_c() {
        return this.field_178659_h;
    }
    
    static class EndSpectatorObject implements ISpectatorMenuObject
    {
        @Override
        public void func_178663_a(final float lllllllllllllllllllIIlIlIIIlllll, final int lllllllllllllllllllIIlIlIIIllllI) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.field_175269_a);
            Gui.drawModalRectWithCustomSizedTexture(0, 0, 128.0f, 0.0f, 16, 16, 256.0f, 256.0f);
        }
        
        EndSpectatorObject(final Object lllllllllllllllllllIIlIlIIIllIlI) {
            this();
        }
        
        @Override
        public void func_178661_a(final SpectatorMenu lllllllllllllllllllIIlIlIIlIIIll) {
            lllllllllllllllllllIIlIlIIlIIIll.func_178641_d();
        }
        
        static {
            __OBFID = "CL_00001925";
        }
        
        private EndSpectatorObject() {
        }
        
        @Override
        public boolean func_178662_A_() {
            return true;
        }
        
        @Override
        public IChatComponent func_178664_z_() {
            return new ChatComponentText("Close menu");
        }
    }
    
    static class MoveMenuObject implements ISpectatorMenuObject
    {
        private final /* synthetic */ int field_178666_a;
        private final /* synthetic */ boolean field_178665_b;
        
        public MoveMenuObject(final int lllllllllllllllllIIlIIllIlIlIIIl, final boolean lllllllllllllllllIIlIIllIlIlIIll) {
            this.field_178666_a = lllllllllllllllllIIlIIllIlIlIIIl;
            this.field_178665_b = lllllllllllllllllIIlIIllIlIlIIll;
        }
        
        @Override
        public void func_178661_a(final SpectatorMenu lllllllllllllllllIIlIIllIlIIllII) {
            SpectatorMenu.access$0(lllllllllllllllllIIlIIllIlIIllII, this.field_178666_a);
        }
        
        @Override
        public IChatComponent func_178664_z_() {
            return (this.field_178666_a < 0) ? new ChatComponentText("Previous Page") : new ChatComponentText("Next Page");
        }
        
        static {
            __OBFID = "CL_00001924";
        }
        
        @Override
        public boolean func_178662_A_() {
            return this.field_178665_b;
        }
        
        @Override
        public void func_178663_a(final float lllllllllllllllllIIlIIllIlIIIlII, final int lllllllllllllllllIIlIIllIlIIIIll) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.field_175269_a);
            if (this.field_178666_a < 0) {
                Gui.drawModalRectWithCustomSizedTexture(0, 0, 144.0f, 0.0f, 16, 16, 256.0f, 256.0f);
            }
            else {
                Gui.drawModalRectWithCustomSizedTexture(0, 0, 160.0f, 0.0f, 16, 16, 256.0f, 256.0f);
            }
        }
    }
}
