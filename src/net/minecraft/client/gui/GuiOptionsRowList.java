package net.minecraft.client.gui;

import java.util.*;
import net.minecraft.client.*;
import net.minecraft.client.settings.*;
import com.google.common.collect.*;

public class GuiOptionsRowList extends GuiListExtended
{
    private final /* synthetic */ List field_148184_k;
    
    public GuiOptionsRowList(final Minecraft llllllllllllllIlIIIIlIlIIlIllIlI, final int llllllllllllllIlIIIIlIlIIlIllIIl, final int llllllllllllllIlIIIIlIlIIlIIlIll, final int llllllllllllllIlIIIIlIlIIlIlIlll, final int llllllllllllllIlIIIIlIlIIlIIlIIl, final int llllllllllllllIlIIIIlIlIIlIlIlIl, final GameSettings.Options... llllllllllllllIlIIIIlIlIIlIlIlII) {
        super(llllllllllllllIlIIIIlIlIIlIllIlI, llllllllllllllIlIIIIlIlIIlIllIIl, llllllllllllllIlIIIIlIlIIlIIlIll, llllllllllllllIlIIIIlIlIIlIlIlll, llllllllllllllIlIIIIlIlIIlIIlIIl, llllllllllllllIlIIIIlIlIIlIlIlIl);
        this.field_148184_k = Lists.newArrayList();
        this.field_148163_i = false;
        for (int llllllllllllllIlIIIIlIlIIlIlIIll = 0; llllllllllllllIlIIIIlIlIIlIlIIll < llllllllllllllIlIIIIlIlIIlIlIlII.length; llllllllllllllIlIIIIlIlIIlIlIIll += 2) {
            final GameSettings.Options llllllllllllllIlIIIIlIlIIlIlIIlI = llllllllllllllIlIIIIlIlIIlIlIlII[llllllllllllllIlIIIIlIlIIlIlIIll];
            final GameSettings.Options llllllllllllllIlIIIIlIlIIlIlIIIl = (llllllllllllllIlIIIIlIlIIlIlIIll < llllllllllllllIlIIIIlIlIIlIlIlII.length - 1) ? llllllllllllllIlIIIIlIlIIlIlIlII[llllllllllllllIlIIIIlIlIIlIlIIll + 1] : null;
            final GuiButton llllllllllllllIlIIIIlIlIIlIlIIII = this.func_148182_a(llllllllllllllIlIIIIlIlIIlIllIlI, llllllllllllllIlIIIIlIlIIlIllIIl / 2 - 155, 0, llllllllllllllIlIIIIlIlIIlIlIIlI);
            final GuiButton llllllllllllllIlIIIIlIlIIlIIllll = this.func_148182_a(llllllllllllllIlIIIIlIlIIlIllIlI, llllllllllllllIlIIIIlIlIIlIllIIl / 2 - 155 + 160, 0, llllllllllllllIlIIIIlIlIIlIlIIIl);
            this.field_148184_k.add(new Row(llllllllllllllIlIIIIlIlIIlIlIIII, llllllllllllllIlIIIIlIlIIlIIllll));
        }
    }
    
    public Row func_180792_c(final int llllllllllllllIlIIIIlIlIIIlIllII) {
        return this.field_148184_k.get(llllllllllllllIlIIIIlIlIIIlIllII);
    }
    
    @Override
    public int getListWidth() {
        return 400;
    }
    
    static {
        __OBFID = "CL_00000677";
    }
    
    @Override
    protected int getSize() {
        return this.field_148184_k.size();
    }
    
    @Override
    public IGuiListEntry getListEntry(final int llllllllllllllIlIIIIlIlIIIlIIIIl) {
        return this.func_180792_c(llllllllllllllIlIIIIlIlIIIlIIIIl);
    }
    
    private GuiButton func_148182_a(final Minecraft llllllllllllllIlIIIIlIlIIIllIllI, final int llllllllllllllIlIIIIlIlIIIllIlIl, final int llllllllllllllIlIIIIlIlIIIlllIIl, final GameSettings.Options llllllllllllllIlIIIIlIlIIIlllIII) {
        if (llllllllllllllIlIIIIlIlIIIlllIII == null) {
            return null;
        }
        final int llllllllllllllIlIIIIlIlIIIllIlll = llllllllllllllIlIIIIlIlIIIlllIII.returnEnumOrdinal();
        return llllllllllllllIlIIIIlIlIIIlllIII.getEnumFloat() ? new GuiOptionSlider(llllllllllllllIlIIIIlIlIIIllIlll, llllllllllllllIlIIIIlIlIIIllIlIl, llllllllllllllIlIIIIlIlIIIlllIIl, llllllllllllllIlIIIIlIlIIIlllIII) : new GuiOptionButton(llllllllllllllIlIIIIlIlIIIllIlll, llllllllllllllIlIIIIlIlIIIllIlIl, llllllllllllllIlIIIIlIlIIIlllIIl, llllllllllllllIlIIIIlIlIIIlllIII, llllllllllllllIlIIIIlIlIIIllIllI.gameSettings.getKeyBinding(llllllllllllllIlIIIIlIlIIIlllIII));
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 32;
    }
    
    public static class Row implements IGuiListEntry
    {
        private final /* synthetic */ GuiButton field_148323_b;
        private final /* synthetic */ GuiButton field_148324_c;
        private final /* synthetic */ Minecraft field_148325_a;
        
        static {
            __OBFID = "CL_00000678";
        }
        
        @Override
        public void drawEntry(final int lllllllllllllllIIlIlllIlIlIIlIlI, final int lllllllllllllllIIlIlllIlIlIIlIIl, final int lllllllllllllllIIlIlllIlIlIIIIIl, final int lllllllllllllllIIlIlllIlIlIIIlll, final int lllllllllllllllIIlIlllIlIlIIIllI, final int lllllllllllllllIIlIlllIlIlIIIlIl, final int lllllllllllllllIIlIlllIlIlIIIlII, final boolean lllllllllllllllIIlIlllIlIlIIIIll) {
            if (this.field_148323_b != null) {
                this.field_148323_b.yPosition = lllllllllllllllIIlIlllIlIlIIIIIl;
                this.field_148323_b.drawButton(this.field_148325_a, lllllllllllllllIIlIlllIlIlIIIlIl, lllllllllllllllIIlIlllIlIlIIIlII);
            }
            if (this.field_148324_c != null) {
                this.field_148324_c.yPosition = lllllllllllllllIIlIlllIlIlIIIIIl;
                this.field_148324_c.drawButton(this.field_148325_a, lllllllllllllllIIlIlllIlIlIIIlIl, lllllllllllllllIIlIlllIlIlIIIlII);
            }
        }
        
        @Override
        public void mouseReleased(final int lllllllllllllllIIlIlllIlIIlIllIl, final int lllllllllllllllIIlIlllIlIIlIIllI, final int lllllllllllllllIIlIlllIlIIlIIlIl, final int lllllllllllllllIIlIlllIlIIlIlIlI, final int lllllllllllllllIIlIlllIlIIlIlIIl, final int lllllllllllllllIIlIlllIlIIlIlIII) {
            if (this.field_148323_b != null) {
                this.field_148323_b.mouseReleased(lllllllllllllllIIlIlllIlIIlIIllI, lllllllllllllllIIlIlllIlIIlIIlIl);
            }
            if (this.field_148324_c != null) {
                this.field_148324_c.mouseReleased(lllllllllllllllIIlIlllIlIIlIIllI, lllllllllllllllIIlIlllIlIIlIIlIl);
            }
        }
        
        @Override
        public void setSelected(final int lllllllllllllllIIlIlllIlIIlIIIll, final int lllllllllllllllIIlIlllIlIIlIIIlI, final int lllllllllllllllIIlIlllIlIIlIIIIl) {
        }
        
        public Row(final GuiButton lllllllllllllllIIlIlllIlIlIlIlII, final GuiButton lllllllllllllllIIlIlllIlIlIlIIll) {
            this.field_148325_a = Minecraft.getMinecraft();
            this.field_148323_b = lllllllllllllllIIlIlllIlIlIlIlII;
            this.field_148324_c = lllllllllllllllIIlIlllIlIlIlIIll;
        }
        
        @Override
        public boolean mousePressed(final int lllllllllllllllIIlIlllIlIIlllIlI, final int lllllllllllllllIIlIlllIlIIllIIll, final int lllllllllllllllIIlIlllIlIIlllIII, final int lllllllllllllllIIlIlllIlIIllIlll, final int lllllllllllllllIIlIlllIlIIllIllI, final int lllllllllllllllIIlIlllIlIIllIlIl) {
            if (this.field_148323_b.mousePressed(this.field_148325_a, lllllllllllllllIIlIlllIlIIllIIll, lllllllllllllllIIlIlllIlIIlllIII)) {
                if (this.field_148323_b instanceof GuiOptionButton) {
                    this.field_148325_a.gameSettings.setOptionValue(((GuiOptionButton)this.field_148323_b).returnEnumOptions(), 1);
                    this.field_148323_b.displayString = this.field_148325_a.gameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(this.field_148323_b.id));
                }
                return true;
            }
            if (this.field_148324_c != null && this.field_148324_c.mousePressed(this.field_148325_a, lllllllllllllllIIlIlllIlIIllIIll, lllllllllllllllIIlIlllIlIIlllIII)) {
                if (this.field_148324_c instanceof GuiOptionButton) {
                    this.field_148325_a.gameSettings.setOptionValue(((GuiOptionButton)this.field_148324_c).returnEnumOptions(), 1);
                    this.field_148324_c.displayString = this.field_148325_a.gameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(this.field_148324_c.id));
                }
                return true;
            }
            return false;
        }
    }
}
