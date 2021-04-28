package net.minecraft.client.gui;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import com.google.common.collect.*;
import com.google.common.base.*;

public class GuiPageButtonList extends GuiListExtended
{
    private final /* synthetic */ GuiListEntry[][] field_178078_x;
    private final /* synthetic */ List field_178074_u;
    private final /* synthetic */ IntHashMap field_178073_v;
    private /* synthetic */ GuiResponder field_178076_z;
    private /* synthetic */ Gui field_178075_A;
    private /* synthetic */ int field_178077_y;
    private final /* synthetic */ List field_178072_w;
    
    private Gui func_178058_a(final GuiListEntry llllllllllllllIlIIIIlIIIIlIIIIIl, final int llllllllllllllIlIIIIlIIIIlIIIlII, final boolean llllllllllllllIlIIIIlIIIIIllllll) {
        return (llllllllllllllIlIIIIlIIIIlIIIIIl instanceof GuiSlideEntry) ? this.func_178067_a(this.width / 2 - 155 + llllllllllllllIlIIIIlIIIIlIIIlII, 0, (GuiSlideEntry)llllllllllllllIlIIIIlIIIIlIIIIIl) : ((llllllllllllllIlIIIIlIIIIlIIIIIl instanceof GuiButtonEntry) ? this.func_178065_a(this.width / 2 - 155 + llllllllllllllIlIIIIlIIIIlIIIlII, 0, (GuiButtonEntry)llllllllllllllIlIIIIlIIIIlIIIIIl) : ((llllllllllllllIlIIIIlIIIIlIIIIIl instanceof EditBoxEntry) ? this.func_178068_a(this.width / 2 - 155 + llllllllllllllIlIIIIlIIIIlIIIlII, 0, (EditBoxEntry)llllllllllllllIlIIIIlIIIIlIIIIIl) : ((llllllllllllllIlIIIIlIIIIlIIIIIl instanceof GuiLabelEntry) ? this.func_178063_a(this.width / 2 - 155 + llllllllllllllIlIIIIlIIIIlIIIlII, 0, (GuiLabelEntry)llllllllllllllIlIIIIlIIIIlIIIIIl, llllllllllllllIlIIIIlIIIIIllllll) : null)));
    }
    
    public Gui func_178056_g() {
        return this.field_178075_A;
    }
    
    private GuiTextField func_178068_a(final int llllllllllllllIlIIIIlIIIIIIIIIII, final int llllllllllllllIlIIIIIlllllllllll, final EditBoxEntry llllllllllllllIlIIIIlIIIIIIIIIll) {
        final GuiTextField llllllllllllllIlIIIIlIIIIIIIIIlI = new GuiTextField(llllllllllllllIlIIIIlIIIIIIIIIll.func_178935_b(), this.mc.fontRendererObj, llllllllllllllIlIIIIlIIIIIIIIIII, llllllllllllllIlIIIIIlllllllllll, 150, 20);
        llllllllllllllIlIIIIlIIIIIIIIIlI.setText(llllllllllllllIlIIIIlIIIIIIIIIll.func_178936_c());
        llllllllllllllIlIIIIlIIIIIIIIIlI.func_175207_a(this.field_178076_z);
        llllllllllllllIlIIIIlIIIIIIIIIlI.setVisible(llllllllllllllIlIIIIlIIIIIIIIIll.func_178934_d());
        llllllllllllllIlIIIIlIIIIIIIIIlI.func_175205_a(llllllllllllllIlIIIIlIIIIIIIIIll.func_178950_a());
        return llllllllllllllIlIIIIlIIIIIIIIIlI;
    }
    
    public GuiPageButtonList(final Minecraft llllllllllllllIlIIIIlIIIllIIlIIl, final int llllllllllllllIlIIIIlIIIllIIlIII, final int llllllllllllllIlIIIIlIIIlIlllllI, final int llllllllllllllIlIIIIlIIIlIllllIl, final int llllllllllllllIlIIIIlIIIllIIIlIl, final int llllllllllllllIlIIIIlIIIllIIIlII, final GuiResponder llllllllllllllIlIIIIlIIIllIIIIll, final GuiListEntry[]... llllllllllllllIlIIIIlIIIllIIIIlI) {
        super(llllllllllllllIlIIIIlIIIllIIlIIl, llllllllllllllIlIIIIlIIIllIIlIII, llllllllllllllIlIIIIlIIIlIlllllI, llllllllllllllIlIIIIlIIIlIllllIl, llllllllllllllIlIIIIlIIIllIIIlIl, llllllllllllllIlIIIIlIIIllIIIlII);
        this.field_178074_u = Lists.newArrayList();
        this.field_178073_v = new IntHashMap();
        this.field_178072_w = Lists.newArrayList();
        this.field_178076_z = llllllllllllllIlIIIIlIIIllIIIIll;
        this.field_178078_x = llllllllllllllIlIIIIlIIIllIIIIlI;
        this.field_148163_i = false;
        this.func_178069_s();
        this.func_178055_t();
    }
    
    private void func_178055_t() {
        this.field_178074_u.clear();
        for (int llllllllllllllIlIIIIlIIIlIIIllll = 0; llllllllllllllIlIIIIlIIIlIIIllll < this.field_178078_x[this.field_178077_y].length; llllllllllllllIlIIIIlIIIlIIIllll += 2) {
            final GuiListEntry llllllllllllllIlIIIIlIIIlIIIlllI = this.field_178078_x[this.field_178077_y][llllllllllllllIlIIIIlIIIlIIIllll];
            final GuiListEntry llllllllllllllIlIIIIlIIIlIIIllIl = (llllllllllllllIlIIIIlIIIlIIIllll < this.field_178078_x[this.field_178077_y].length - 1) ? this.field_178078_x[this.field_178077_y][llllllllllllllIlIIIIlIIIlIIIllll + 1] : null;
            final Gui llllllllllllllIlIIIIlIIIlIIIllII = (Gui)this.field_178073_v.lookup(llllllllllllllIlIIIIlIIIlIIIlllI.func_178935_b());
            final Gui llllllllllllllIlIIIIlIIIlIIIlIll = (llllllllllllllIlIIIIlIIIlIIIllIl != null) ? ((Gui)this.field_178073_v.lookup(llllllllllllllIlIIIIlIIIlIIIllIl.func_178935_b())) : null;
            final GuiEntry llllllllllllllIlIIIIlIIIlIIIlIlI = new GuiEntry(llllllllllllllIlIIIIlIIIlIIIllII, llllllllllllllIlIIIIlIIIlIIIlIll);
            this.field_178074_u.add(llllllllllllllIlIIIIlIIIlIIIlIlI);
        }
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 32;
    }
    
    @Override
    public int getListWidth() {
        return 400;
    }
    
    public void func_178071_h() {
        if (this.field_178077_y > 0) {
            final int llllllllllllllIlIIIIlIIIIlllIllI = this.field_178077_y--;
            this.func_178055_t();
            this.func_178060_e(llllllllllllllIlIIIIlIIIIlllIllI, this.field_178077_y);
            this.amountScrolled = 0.0f;
        }
    }
    
    private GuiLabel func_178063_a(final int llllllllllllllIlIIIIIllllllIlllI, final int llllllllllllllIlIIIIIllllllIllIl, final GuiLabelEntry llllllllllllllIlIIIIIllllllIllII, final boolean llllllllllllllIlIIIIIllllllIlIll) {
        GuiLabel llllllllllllllIlIIIIIlllllllIIII = null;
        if (llllllllllllllIlIIIIIllllllIlIll) {
            final GuiLabel llllllllllllllIlIIIIIlllllllIIIl = new GuiLabel(this.mc.fontRendererObj, llllllllllllllIlIIIIIllllllIllII.func_178935_b(), llllllllllllllIlIIIIIllllllIlllI, llllllllllllllIlIIIIIllllllIllIl, this.width - llllllllllllllIlIIIIIllllllIlllI * 2, 20, -1);
        }
        else {
            llllllllllllllIlIIIIIlllllllIIII = new GuiLabel(this.mc.fontRendererObj, llllllllllllllIlIIIIIllllllIllII.func_178935_b(), llllllllllllllIlIIIIIllllllIlllI, llllllllllllllIlIIIIIllllllIllIl, 150, 20, -1);
        }
        llllllllllllllIlIIIIIlllllllIIII.visible = llllllllllllllIlIIIIIllllllIllII.func_178934_d();
        llllllllllllllIlIIIIIlllllllIIII.func_175202_a(llllllllllllllIlIIIIIllllllIllII.func_178936_c());
        llllllllllllllIlIIIIIlllllllIIII.func_175203_a();
        return llllllllllllllIlIIIIIlllllllIIII;
    }
    
    public GuiEntry func_178070_d(final int llllllllllllllIlIIIIIllllIllllIl) {
        return this.field_178074_u.get(llllllllllllllIlIIIIIllllIllllIl);
    }
    
    private GuiListButton func_178065_a(final int llllllllllllllIlIIIIlIIIIIIlIlII, final int llllllllllllllIlIIIIlIIIIIIlIIll, final GuiButtonEntry llllllllllllllIlIIIIlIIIIIIlIIlI) {
        final GuiListButton llllllllllllllIlIIIIlIIIIIIlIIIl = new GuiListButton(this.field_178076_z, llllllllllllllIlIIIIlIIIIIIlIIlI.func_178935_b(), llllllllllllllIlIIIIlIIIIIIlIlII, llllllllllllllIlIIIIlIIIIIIlIIll, llllllllllllllIlIIIIlIIIIIIlIIlI.func_178936_c(), llllllllllllllIlIIIIlIIIIIIlIIlI.func_178940_a());
        llllllllllllllIlIIIIlIIIIIIlIIIl.visible = llllllllllllllIlIIIIlIIIIIIlIIlI.func_178934_d();
        return llllllllllllllIlIIIIlIIIIIIlIIIl;
    }
    
    public void func_178062_a(final char llllllllllllllIlIIIIIlllllIlllII, final int llllllllllllllIlIIIIIlllllIIllII) {
        if (this.field_178075_A instanceof GuiTextField) {
            GuiTextField llllllllllllllIlIIIIIlllllIllIlI = (GuiTextField)this.field_178075_A;
            if (!GuiScreen.func_175279_e(llllllllllllllIlIIIIIlllllIIllII)) {
                if (llllllllllllllIlIIIIIlllllIIllII == 15) {
                    llllllllllllllIlIIIIIlllllIllIlI.setFocused(false);
                    int llllllllllllllIlIIIIIlllllIlIlll = this.field_178072_w.indexOf(this.field_178075_A);
                    if (GuiScreen.isShiftKeyDown()) {
                        if (llllllllllllllIlIIIIIlllllIlIlll == 0) {
                            llllllllllllllIlIIIIIlllllIlIlll = this.field_178072_w.size() - 1;
                        }
                        else {
                            --llllllllllllllIlIIIIIlllllIlIlll;
                        }
                    }
                    else if (llllllllllllllIlIIIIIlllllIlIlll == this.field_178072_w.size() - 1) {
                        llllllllllllllIlIIIIIlllllIlIlll = 0;
                    }
                    else {
                        ++llllllllllllllIlIIIIIlllllIlIlll;
                    }
                    this.field_178075_A = this.field_178072_w.get(llllllllllllllIlIIIIIlllllIlIlll);
                    llllllllllllllIlIIIIIlllllIllIlI = (GuiTextField)this.field_178075_A;
                    llllllllllllllIlIIIIIlllllIllIlI.setFocused(true);
                    final int llllllllllllllIlIIIIIlllllIlIllI = llllllllllllllIlIIIIIlllllIllIlI.yPosition + this.slotHeight;
                    final int llllllllllllllIlIIIIIlllllIllIIl = llllllllllllllIlIIIIIlllllIllIlI.yPosition;
                    if (llllllllllllllIlIIIIIlllllIlIllI > this.bottom) {
                        this.amountScrolled += llllllllllllllIlIIIIIlllllIlIllI - this.bottom;
                    }
                    else if (llllllllllllllIlIIIIIlllllIllIIl < this.top) {
                        this.amountScrolled = (float)llllllllllllllIlIIIIIlllllIllIIl;
                    }
                }
                else {
                    llllllllllllllIlIIIIIlllllIllIlI.textboxKeyTyped(llllllllllllllIlIIIIIlllllIlllII, llllllllllllllIlIIIIIlllllIIllII);
                }
            }
            else {
                final String llllllllllllllIlIIIIIlllllIlIlIl = GuiScreen.getClipboardString();
                final String[] llllllllllllllIlIIIIIlllllIlIlII = llllllllllllllIlIIIIIlllllIlIlIl.split(";");
                int llllllllllllllIlIIIIIlllllIlIIll;
                final int llllllllllllllIlIIIIIlllllIllIII = llllllllllllllIlIIIIIlllllIlIIll = this.field_178072_w.indexOf(this.field_178075_A);
                final String[] llllllllllllllIlIIIIIlllllIlIIlI = llllllllllllllIlIIIIIlllllIlIlII;
                for (int llllllllllllllIlIIIIIlllllIlIIIl = llllllllllllllIlIIIIIlllllIlIlII.length, llllllllllllllIlIIIIIlllllIlIIII = 0; llllllllllllllIlIIIIIlllllIlIIII < llllllllllllllIlIIIIIlllllIlIIIl; ++llllllllllllllIlIIIIIlllllIlIIII) {
                    final String llllllllllllllIlIIIIIlllllIIllll = llllllllllllllIlIIIIIlllllIlIIlI[llllllllllllllIlIIIIIlllllIlIIII];
                    this.field_178072_w.get(llllllllllllllIlIIIIIlllllIlIIll).setText(llllllllllllllIlIIIIIlllllIIllll);
                    if (llllllllllllllIlIIIIIlllllIlIIll == this.field_178072_w.size() - 1) {
                        llllllllllllllIlIIIIIlllllIlIIll = 0;
                    }
                    else {
                        ++llllllllllllllIlIIIIIlllllIlIIll;
                    }
                    if (llllllllllllllIlIIIIIlllllIlIIll == llllllllllllllIlIIIIIlllllIllIII) {
                        break;
                    }
                }
            }
        }
    }
    
    @Override
    public IGuiListEntry getListEntry(final int llllllllllllllIlIIIIIllllIllIIlI) {
        return this.func_178070_d(llllllllllllllIlIIIIIllllIllIIlI);
    }
    
    @Override
    public boolean func_148179_a(final int llllllllllllllIlIIIIlIIIIIlIllll, final int llllllllllllllIlIIIIlIIIIIlIlllI, final int llllllllllllllIlIIIIlIIIIIlIllIl) {
        final boolean llllllllllllllIlIIIIlIIIIIllIIll = super.func_148179_a(llllllllllllllIlIIIIlIIIIIlIllll, llllllllllllllIlIIIIlIIIIIlIlllI, llllllllllllllIlIIIIlIIIIIlIllIl);
        final int llllllllllllllIlIIIIlIIIIIllIIlI = this.getSlotIndexFromScreenCoords(llllllllllllllIlIIIIlIIIIIlIllll, llllllllllllllIlIIIIlIIIIIlIlllI);
        if (llllllllllllllIlIIIIlIIIIIllIIlI >= 0) {
            final GuiEntry llllllllllllllIlIIIIlIIIIIllIIIl = this.func_178070_d(llllllllllllllIlIIIIlIIIIIllIIlI);
            if (this.field_178075_A != llllllllllllllIlIIIIlIIIIIllIIIl.field_178028_d && this.field_178075_A != null && this.field_178075_A instanceof GuiTextField) {
                ((GuiTextField)this.field_178075_A).setFocused(false);
            }
            this.field_178075_A = llllllllllllllIlIIIIlIIIIIllIIIl.field_178028_d;
        }
        return llllllllllllllIlIIIIlIIIIIllIIll;
    }
    
    public void func_178064_i() {
        if (this.field_178077_y < this.field_178078_x.length - 1) {
            final int llllllllllllllIlIIIIlIIIIlllIIII = this.field_178077_y++;
            this.func_178055_t();
            this.func_178060_e(llllllllllllllIlIIIIlIIIIlllIIII, this.field_178077_y);
            this.amountScrolled = 0.0f;
        }
    }
    
    public int func_178059_e() {
        return this.field_178077_y;
    }
    
    public int func_178057_f() {
        return this.field_178078_x.length;
    }
    
    private void func_178066_a(final Gui llllllllllllllIlIIIIlIIIIlIIllII, final boolean llllllllllllllIlIIIIlIIIIlIIllIl) {
        if (llllllllllllllIlIIIIlIIIIlIIllII instanceof GuiButton) {
            ((GuiButton)llllllllllllllIlIIIIlIIIIlIIllII).visible = llllllllllllllIlIIIIlIIIIlIIllIl;
        }
        else if (llllllllllllllIlIIIIlIIIIlIIllII instanceof GuiTextField) {
            ((GuiTextField)llllllllllllllIlIIIIlIIIIlIIllII).setVisible(llllllllllllllIlIIIIlIIIIlIIllIl);
        }
        else if (llllllllllllllIlIIIIlIIIIlIIllII instanceof GuiLabel) {
            ((GuiLabel)llllllllllllllIlIIIIlIIIIlIIllII).visible = llllllllllllllIlIIIIlIIIIlIIllIl;
        }
    }
    
    public int getSize() {
        return this.field_178074_u.size();
    }
    
    private void func_178060_e(final int llllllllllllllIlIIIIlIIIIlIlllll, final int llllllllllllllIlIIIIlIIIIlIlIllI) {
        for (final GuiListEntry llllllllllllllIlIIIIlIIIIlIllIlI : this.field_178078_x[llllllllllllllIlIIIIlIIIIlIlllll]) {
            if (llllllllllllllIlIIIIlIIIIlIllIlI != null) {
                this.func_178066_a((Gui)this.field_178073_v.lookup(llllllllllllllIlIIIIlIIIIlIllIlI.func_178935_b()), false);
            }
        }
        for (final GuiListEntry llllllllllllllIlIIIIlIIIIlIllIIl : this.field_178078_x[llllllllllllllIlIIIIlIIIIlIlIllI]) {
            if (llllllllllllllIlIIIIlIIIIlIllIIl != null) {
                this.func_178066_a((Gui)this.field_178073_v.lookup(llllllllllllllIlIIIIlIIIIlIllIIl.func_178935_b()), true);
            }
        }
    }
    
    private GuiSlider func_178067_a(final int llllllllllllllIlIIIIlIIIIIlIIIll, final int llllllllllllllIlIIIIlIIIIIlIIIlI, final GuiSlideEntry llllllllllllllIlIIIIlIIIIIlIIIIl) {
        final GuiSlider llllllllllllllIlIIIIlIIIIIlIIIII = new GuiSlider(this.field_178076_z, llllllllllllllIlIIIIlIIIIIlIIIIl.func_178935_b(), llllllllllllllIlIIIIlIIIIIlIIIll, llllllllllllllIlIIIIlIIIIIlIIIlI, llllllllllllllIlIIIIlIIIIIlIIIIl.func_178936_c(), llllllllllllllIlIIIIlIIIIIlIIIIl.func_178943_e(), llllllllllllllIlIIIIlIIIIIlIIIIl.func_178944_f(), llllllllllllllIlIIIIlIIIIIlIIIIl.func_178942_g(), llllllllllllllIlIIIIlIIIIIlIIIIl.func_178945_a());
        llllllllllllllIlIIIIlIIIIIlIIIII.visible = llllllllllllllIlIIIIlIIIIIlIIIIl.func_178934_d();
        return llllllllllllllIlIIIIlIIIIIlIIIII;
    }
    
    public Gui func_178061_c(final int llllllllllllllIlIIIIlIIIIllIlIlI) {
        return (Gui)this.field_178073_v.lookup(llllllllllllllIlIIIIlIIIIllIlIlI);
    }
    
    private void func_178069_s() {
        for (final GuiListEntry[] llllllllllllllIlIIIIlIIIlIlIlIIl : this.field_178078_x) {
            for (int llllllllllllllIlIIIIlIIIlIlIlIII = 0; llllllllllllllIlIIIIlIIIlIlIlIII < llllllllllllllIlIIIIlIIIlIlIlIIl.length; llllllllllllllIlIIIIlIIIlIlIlIII += 2) {
                final GuiListEntry llllllllllllllIlIIIIlIIIlIlIIlll = llllllllllllllIlIIIIlIIIlIlIlIIl[llllllllllllllIlIIIIlIIIlIlIlIII];
                final GuiListEntry llllllllllllllIlIIIIlIIIlIlIIllI = (llllllllllllllIlIIIIlIIIlIlIlIII < llllllllllllllIlIIIIlIIIlIlIlIIl.length - 1) ? llllllllllllllIlIIIIlIIIlIlIlIIl[llllllllllllllIlIIIIlIIIlIlIlIII + 1] : null;
                final Gui llllllllllllllIlIIIIlIIIlIlIIlIl = this.func_178058_a(llllllllllllllIlIIIIlIIIlIlIIlll, 0, llllllllllllllIlIIIIlIIIlIlIIllI == null);
                final Gui llllllllllllllIlIIIIlIIIlIlIIlII = this.func_178058_a(llllllllllllllIlIIIIlIIIlIlIIllI, 160, llllllllllllllIlIIIIlIIIlIlIIlll == null);
                final GuiEntry llllllllllllllIlIIIIlIIIlIlIIIll = new GuiEntry(llllllllllllllIlIIIIlIIIlIlIIlIl, llllllllllllllIlIIIIlIIIlIlIIlII);
                this.field_178074_u.add(llllllllllllllIlIIIIlIIIlIlIIIll);
                if (llllllllllllllIlIIIIlIIIlIlIIlll != null && llllllllllllllIlIIIIlIIIlIlIIlIl != null) {
                    this.field_178073_v.addKey(llllllllllllllIlIIIIlIIIlIlIIlll.func_178935_b(), llllllllllllllIlIIIIlIIIlIlIIlIl);
                    if (llllllllllllllIlIIIIlIIIlIlIIlIl instanceof GuiTextField) {
                        this.field_178072_w.add(llllllllllllllIlIIIIlIIIlIlIIlIl);
                    }
                }
                if (llllllllllllllIlIIIIlIIIlIlIIllI != null && llllllllllllllIlIIIIlIIIlIlIIlII != null) {
                    this.field_178073_v.addKey(llllllllllllllIlIIIIlIIIlIlIIllI.func_178935_b(), llllllllllllllIlIIIIlIIIlIlIIlII);
                    if (llllllllllllllIlIIIIlIIIlIlIIlII instanceof GuiTextField) {
                        this.field_178072_w.add(llllllllllllllIlIIIIlIIIlIlIIlII);
                    }
                }
            }
        }
    }
    
    static {
        __OBFID = "CL_00001950";
    }
    
    public static class GuiLabelEntry extends GuiListEntry
    {
        static {
            __OBFID = "CL_00001946";
        }
        
        public GuiLabelEntry(final int lllllllllllllllIlIIIIlIIlIlllllI, final String lllllllllllllllIlIIIIlIIlIllllIl, final boolean lllllllllllllllIlIIIIlIIlIllllII) {
            super(lllllllllllllllIlIIIIlIIlIlllllI, lllllllllllllllIlIIIIlIIlIllllIl, lllllllllllllllIlIIIIlIIlIllllII);
        }
    }
    
    public static class GuiListEntry
    {
        private final /* synthetic */ int field_178939_a;
        private final /* synthetic */ String field_178937_b;
        private final /* synthetic */ boolean field_178938_c;
        
        public GuiListEntry(final int llllllllllllllIIllIIlIllIIIlIIlI, final String llllllllllllllIIllIIlIllIIIlIIIl, final boolean llllllllllllllIIllIIlIllIIIlIIII) {
            this.field_178939_a = llllllllllllllIIllIIlIllIIIlIIlI;
            this.field_178937_b = llllllllllllllIIllIIlIllIIIlIIIl;
            this.field_178938_c = llllllllllllllIIllIIlIllIIIlIIII;
        }
        
        public boolean func_178934_d() {
            return this.field_178938_c;
        }
        
        public String func_178936_c() {
            return this.field_178937_b;
        }
        
        public int func_178935_b() {
            return this.field_178939_a;
        }
        
        static {
            __OBFID = "CL_00001945";
        }
    }
    
    public static class GuiSlideEntry extends GuiListEntry
    {
        private final /* synthetic */ float field_178948_c;
        private final /* synthetic */ GuiSlider.FormatHelper field_178949_a;
        private final /* synthetic */ float field_178947_b;
        private final /* synthetic */ float field_178946_d;
        
        public float func_178944_f() {
            return this.field_178948_c;
        }
        
        public GuiSlideEntry(final int llllllllllllllIIlIIIllIlIllIllII, final String llllllllllllllIIlIIIllIlIllIlIll, final boolean llllllllllllllIIlIIIllIlIlllIllI, final GuiSlider.FormatHelper llllllllllllllIIlIIIllIlIlllIlII, final float llllllllllllllIIlIIIllIlIllIIllI, final float llllllllllllllIIlIIIllIlIlllIIII, final float llllllllllllllIIlIIIllIlIllIIIlI) {
            super(llllllllllllllIIlIIIllIlIllIllII, llllllllllllllIIlIIIllIlIllIlIll, llllllllllllllIIlIIIllIlIlllIllI);
            this.field_178949_a = llllllllllllllIIlIIIllIlIlllIlII;
            this.field_178947_b = llllllllllllllIIlIIIllIlIllIIllI;
            this.field_178948_c = llllllllllllllIIlIIIllIlIlllIIII;
            this.field_178946_d = llllllllllllllIIlIIIllIlIllIIIlI;
        }
        
        public float func_178943_e() {
            return this.field_178947_b;
        }
        
        public float func_178942_g() {
            return this.field_178946_d;
        }
        
        static {
            __OBFID = "CL_00001944";
        }
        
        public GuiSlider.FormatHelper func_178945_a() {
            return this.field_178949_a;
        }
    }
    
    public interface GuiResponder
    {
        void func_175319_a(final int p0, final String p1);
        
        void func_175320_a(final int p0, final float p1);
        
        void func_175321_a(final int p0, final boolean p1);
    }
    
    public static class EditBoxEntry extends GuiListEntry
    {
        private final /* synthetic */ Predicate field_178951_a;
        
        public Predicate func_178950_a() {
            return this.field_178951_a;
        }
        
        static {
            __OBFID = "CL_00001948";
        }
        
        public EditBoxEntry(final int llllllllllllllIIIlIlIlIIIIlIlIlI, final String llllllllllllllIIIlIlIlIIIIlIlllI, final boolean llllllllllllllIIIlIlIlIIIIlIllIl, final Predicate llllllllllllllIIIlIlIlIIIIlIllII) {
            super(llllllllllllllIIIlIlIlIIIIlIlIlI, llllllllllllllIIIlIlIlIIIIlIlllI, llllllllllllllIIIlIlIlIIIIlIllIl);
            this.field_178951_a = (Predicate)Objects.firstNonNull((Object)llllllllllllllIIIlIlIlIIIIlIllII, (Object)Predicates.alwaysTrue());
        }
    }
    
    public static class GuiButtonEntry extends GuiListEntry
    {
        private final /* synthetic */ boolean field_178941_a;
        
        public GuiButtonEntry(final int lllllllllllllllIIlllIllIIIlIIIlI, final String lllllllllllllllIIlllIllIIIlIIIIl, final boolean lllllllllllllllIIlllIllIIIIllIll, final boolean lllllllllllllllIIlllIllIIIIllIlI) {
            super(lllllllllllllllIIlllIllIIIlIIIlI, lllllllllllllllIIlllIllIIIlIIIIl, lllllllllllllllIIlllIllIIIIllIll);
            this.field_178941_a = lllllllllllllllIIlllIllIIIIllIlI;
        }
        
        static {
            __OBFID = "CL_00001949";
        }
        
        public boolean func_178940_a() {
            return this.field_178941_a;
        }
    }
    
    public static class GuiEntry implements IGuiListEntry
    {
        private final /* synthetic */ Gui field_178029_b;
        private /* synthetic */ Gui field_178028_d;
        private final /* synthetic */ Minecraft field_178031_a;
        private final /* synthetic */ Gui field_178030_c;
        
        private void func_178025_a(final GuiLabel llllllllllllllllIIlIIIIlIllIIlll, final int llllllllllllllllIIlIIIIlIllIllII, final int llllllllllllllllIIlIIIIlIllIlIll, final int llllllllllllllllIIlIIIIlIllIIlII, final boolean llllllllllllllllIIlIIIIlIllIlIIl) {
            llllllllllllllllIIlIIIIlIllIIlll.field_146174_h = llllllllllllllllIIlIIIIlIllIllII;
            if (!llllllllllllllllIIlIIIIlIllIlIIl) {
                llllllllllllllllIIlIIIIlIllIIlll.drawLabel(this.field_178031_a, llllllllllllllllIIlIIIIlIllIlIll, llllllllllllllllIIlIIIIlIllIIlII);
            }
        }
        
        @Override
        public boolean mousePressed(final int llllllllllllllllIIlIIIIlIlIlIIll, final int llllllllllllllllIIlIIIIlIlIIlIlI, final int llllllllllllllllIIlIIIIlIlIIlIIl, final int llllllllllllllllIIlIIIIlIlIIlIII, final int llllllllllllllllIIlIIIIlIlIIllll, final int llllllllllllllllIIlIIIIlIlIIlllI) {
            final boolean llllllllllllllllIIlIIIIlIlIIllIl = this.func_178026_a(this.field_178029_b, llllllllllllllllIIlIIIIlIlIIlIlI, llllllllllllllllIIlIIIIlIlIIlIIl, llllllllllllllllIIlIIIIlIlIIlIII);
            final boolean llllllllllllllllIIlIIIIlIlIIllII = this.func_178026_a(this.field_178030_c, llllllllllllllllIIlIIIIlIlIIlIlI, llllllllllllllllIIlIIIIlIlIIlIIl, llllllllllllllllIIlIIIIlIlIIlIII);
            return llllllllllllllllIIlIIIIlIlIIllIl || llllllllllllllllIIlIIIIlIlIIllII;
        }
        
        @Override
        public void mouseReleased(final int llllllllllllllllIIlIIIIlIIIlIIlI, final int llllllllllllllllIIlIIIIlIIIlIIIl, final int llllllllllllllllIIlIIIIlIIIlIIII, final int llllllllllllllllIIlIIIIlIIIIllll, final int llllllllllllllllIIlIIIIlIIIIlllI, final int llllllllllllllllIIlIIIIlIIIIllIl) {
            this.func_178016_b(this.field_178029_b, llllllllllllllllIIlIIIIlIIIlIIIl, llllllllllllllllIIlIIIIlIIIlIIII, llllllllllllllllIIlIIIIlIIIIllll);
            this.func_178016_b(this.field_178030_c, llllllllllllllllIIlIIIIlIIIlIIIl, llllllllllllllllIIlIIIIlIIIlIIII, llllllllllllllllIIlIIIIlIIIIllll);
        }
        
        private void func_178027_a(final GuiTextField llllllllllllllllIIlIIIIlIllllIlI, final int llllllllllllllllIIlIIIIlIlllIllI, final boolean llllllllllllllllIIlIIIIlIlllIlIl) {
            llllllllllllllllIIlIIIIlIllllIlI.yPosition = llllllllllllllllIIlIIIIlIlllIllI;
            if (!llllllllllllllllIIlIIIIlIlllIlIl) {
                llllllllllllllllIIlIIIIlIllllIlI.drawTextBox();
            }
        }
        
        @Override
        public void setSelected(final int llllllllllllllllIIlIIIIlIlIlllll, final int llllllllllllllllIIlIIIIlIlIllllI, final int llllllllllllllllIIlIIIIlIlIllIll) {
            this.func_178017_a(this.field_178029_b, llllllllllllllllIIlIIIIlIlIllIll, 0, 0, true);
            this.func_178017_a(this.field_178030_c, llllllllllllllllIIlIIIIlIlIllIll, 0, 0, true);
        }
        
        private boolean func_178026_a(final Gui llllllllllllllllIIlIIIIlIIlllIlI, final int llllllllllllllllIIlIIIIlIIlllllI, final int llllllllllllllllIIlIIIIlIIllllIl, final int llllllllllllllllIIlIIIIlIIllllII) {
            if (llllllllllllllllIIlIIIIlIIlllIlI == null) {
                return false;
            }
            if (llllllllllllllllIIlIIIIlIIlllIlI instanceof GuiButton) {
                return this.func_178023_a((GuiButton)llllllllllllllllIIlIIIIlIIlllIlI, llllllllllllllllIIlIIIIlIIlllllI, llllllllllllllllIIlIIIIlIIllllIl, llllllllllllllllIIlIIIIlIIllllII);
            }
            if (llllllllllllllllIIlIIIIlIIlllIlI instanceof GuiTextField) {
                this.func_178018_a((GuiTextField)llllllllllllllllIIlIIIIlIIlllIlI, llllllllllllllllIIlIIIIlIIlllllI, llllllllllllllllIIlIIIIlIIllllIl, llllllllllllllllIIlIIIIlIIllllII);
            }
            return false;
        }
        
        @Override
        public void drawEntry(final int llllllllllllllllIIlIIIIllIlIlllI, final int llllllllllllllllIIlIIIIllIlIllIl, final int llllllllllllllllIIlIIIIllIlIllII, final int llllllllllllllllIIlIIIIllIlIlIll, final int llllllllllllllllIIlIIIIllIlIlIlI, final int llllllllllllllllIIlIIIIllIlIlIIl, final int llllllllllllllllIIlIIIIllIlIIIll, final boolean llllllllllllllllIIlIIIIllIlIIlll) {
            this.func_178017_a(this.field_178029_b, llllllllllllllllIIlIIIIllIlIllII, llllllllllllllllIIlIIIIllIlIlIIl, llllllllllllllllIIlIIIIllIlIIIll, false);
            this.func_178017_a(this.field_178030_c, llllllllllllllllIIlIIIIllIlIllII, llllllllllllllllIIlIIIIllIlIlIIl, llllllllllllllllIIlIIIIllIlIIIll, false);
        }
        
        private void func_178017_a(final Gui llllllllllllllllIIlIIIIllIIlIlIl, final int llllllllllllllllIIlIIIIllIIlIlII, final int llllllllllllllllIIlIIIIllIIllIIl, final int llllllllllllllllIIlIIIIllIIlIIlI, final boolean llllllllllllllllIIlIIIIllIIlIIIl) {
            if (llllllllllllllllIIlIIIIllIIlIlIl != null) {
                if (llllllllllllllllIIlIIIIllIIlIlIl instanceof GuiButton) {
                    this.func_178024_a((GuiButton)llllllllllllllllIIlIIIIllIIlIlIl, llllllllllllllllIIlIIIIllIIlIlII, llllllllllllllllIIlIIIIllIIllIIl, llllllllllllllllIIlIIIIllIIlIIlI, llllllllllllllllIIlIIIIllIIlIIIl);
                }
                else if (llllllllllllllllIIlIIIIllIIlIlIl instanceof GuiTextField) {
                    this.func_178027_a((GuiTextField)llllllllllllllllIIlIIIIllIIlIlIl, llllllllllllllllIIlIIIIllIIlIlII, llllllllllllllllIIlIIIIllIIlIIIl);
                }
                else if (llllllllllllllllIIlIIIIllIIlIlIl instanceof GuiLabel) {
                    this.func_178025_a((GuiLabel)llllllllllllllllIIlIIIIllIIlIlIl, llllllllllllllllIIlIIIIllIIlIlII, llllllllllllllllIIlIIIIllIIllIIl, llllllllllllllllIIlIIIIllIIlIIlI, llllllllllllllllIIlIIIIllIIlIIIl);
                }
            }
        }
        
        private void func_178016_b(final Gui llllllllllllllllIIlIIIIlIIIIIIlI, final int llllllllllllllllIIlIIIIIllllllII, final int llllllllllllllllIIlIIIIlIIIIIIII, final int llllllllllllllllIIlIIIIIllllllll) {
            if (llllllllllllllllIIlIIIIlIIIIIIlI != null && llllllllllllllllIIlIIIIlIIIIIIlI instanceof GuiButton) {
                this.func_178019_b((GuiButton)llllllllllllllllIIlIIIIlIIIIIIlI, llllllllllllllllIIlIIIIIllllllII, llllllllllllllllIIlIIIIlIIIIIIII, llllllllllllllllIIlIIIIIllllllll);
            }
        }
        
        static {
            __OBFID = "CL_00001947";
        }
        
        public Gui func_178021_b() {
            return this.field_178030_c;
        }
        
        private void func_178024_a(final GuiButton llllllllllllllllIIlIIIIllIIIIIll, final int llllllllllllllllIIlIIIIllIIIlIII, final int llllllllllllllllIIlIIIIllIIIIlll, final int llllllllllllllllIIlIIIIllIIIIIII, final boolean llllllllllllllllIIlIIIIlIlllllll) {
            llllllllllllllllIIlIIIIllIIIIIll.yPosition = llllllllllllllllIIlIIIIllIIIlIII;
            if (!llllllllllllllllIIlIIIIlIlllllll) {
                llllllllllllllllIIlIIIIllIIIIIll.drawButton(this.field_178031_a, llllllllllllllllIIlIIIIllIIIIlll, llllllllllllllllIIlIIIIllIIIIIII);
            }
        }
        
        private boolean func_178023_a(final GuiButton llllllllllllllllIIlIIIIlIIlIlIlI, final int llllllllllllllllIIlIIIIlIIlIllll, final int llllllllllllllllIIlIIIIlIIlIlIII, final int llllllllllllllllIIlIIIIlIIlIllIl) {
            final boolean llllllllllllllllIIlIIIIlIIlIllII = llllllllllllllllIIlIIIIlIIlIlIlI.mousePressed(this.field_178031_a, llllllllllllllllIIlIIIIlIIlIllll, llllllllllllllllIIlIIIIlIIlIlIII);
            if (llllllllllllllllIIlIIIIlIIlIllII) {
                this.field_178028_d = llllllllllllllllIIlIIIIlIIlIlIlI;
            }
            return llllllllllllllllIIlIIIIlIIlIllII;
        }
        
        private void func_178018_a(final GuiTextField llllllllllllllllIIlIIIIlIIIllIll, final int llllllllllllllllIIlIIIIlIIIlllll, final int llllllllllllllllIIlIIIIlIIIllIIl, final int llllllllllllllllIIlIIIIlIIIlllIl) {
            llllllllllllllllIIlIIIIlIIIllIll.mouseClicked(llllllllllllllllIIlIIIIlIIIlllll, llllllllllllllllIIlIIIIlIIIllIIl, llllllllllllllllIIlIIIIlIIIlllIl);
            if (llllllllllllllllIIlIIIIlIIIllIll.isFocused()) {
                this.field_178028_d = llllllllllllllllIIlIIIIlIIIllIll;
            }
        }
        
        private void func_178019_b(final GuiButton llllllllllllllllIIlIIIIIllllIIIl, final int llllllllllllllllIIlIIIIIllllIlII, final int llllllllllllllllIIlIIIIIlllIllll, final int llllllllllllllllIIlIIIIIllllIIlI) {
            llllllllllllllllIIlIIIIIllllIIIl.mouseReleased(llllllllllllllllIIlIIIIIllllIlII, llllllllllllllllIIlIIIIIlllIllll);
        }
        
        public Gui func_178022_a() {
            return this.field_178029_b;
        }
        
        public GuiEntry(final Gui llllllllllllllllIIlIIIIlllIIlIll, final Gui llllllllllllllllIIlIIIIlllIIIlll) {
            this.field_178031_a = Minecraft.getMinecraft();
            this.field_178029_b = llllllllllllllllIIlIIIIlllIIlIll;
            this.field_178030_c = llllllllllllllllIIlIIIIlllIIIlll;
        }
    }
}
