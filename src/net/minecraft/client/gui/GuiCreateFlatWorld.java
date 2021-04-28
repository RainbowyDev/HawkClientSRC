package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import java.util.*;
import java.io.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.gen.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class GuiCreateFlatWorld extends GuiScreen
{
    private /* synthetic */ String field_146391_r;
    private /* synthetic */ FlatGeneratorInfo theFlatGeneratorInfo;
    private final /* synthetic */ GuiCreateWorld createWorldGui;
    private /* synthetic */ String field_146394_i;
    private /* synthetic */ GuiButton field_146389_t;
    private /* synthetic */ GuiButton field_146388_u;
    private /* synthetic */ Details createFlatWorldListSlotGui;
    private /* synthetic */ GuiButton field_146386_v;
    private /* synthetic */ String field_146393_h;
    
    public void func_146375_g() {
        final boolean llllllllllllllllIllIlIIllIIIlIlI = this.func_146382_i();
        this.field_146386_v.enabled = llllllllllllllllIllIlIIllIIIlIlI;
        this.field_146388_u.enabled = llllllllllllllllIllIlIIllIIIlIlI;
        this.field_146388_u.enabled = false;
        this.field_146389_t.enabled = false;
    }
    
    public String func_146384_e() {
        return this.theFlatGeneratorInfo.toString();
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIllIlIIlIllllllI, final int llllllllllllllllIllIlIIlIlllllIl, final float llllllllllllllllIllIlIIlIlllllII) {
        this.drawDefaultBackground();
        this.createFlatWorldListSlotGui.drawScreen(llllllllllllllllIllIlIIlIllllllI, llllllllllllllllIllIlIIlIlllllIl, llllllllllllllllIllIlIIlIlllllII);
        this.drawCenteredString(this.fontRendererObj, this.field_146393_h, this.width / 2, 8, 16777215);
        final int llllllllllllllllIllIlIIlIllllIll = this.width / 2 - 92 - 16;
        this.drawString(this.fontRendererObj, this.field_146394_i, llllllllllllllllIllIlIIlIllllIll, 32, 16777215);
        this.drawString(this.fontRendererObj, this.field_146391_r, llllllllllllllllIllIlIIlIllllIll + 2 + 213 - this.fontRendererObj.getStringWidth(this.field_146391_r), 32, 16777215);
        super.drawScreen(llllllllllllllllIllIlIIlIllllllI, llllllllllllllllIllIlIIlIlllllIl, llllllllllllllllIllIlIIlIlllllII);
    }
    
    static {
        __OBFID = "CL_00000687";
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.field_146393_h = I18n.format("createWorld.customize.flat.title", new Object[0]);
        this.field_146394_i = I18n.format("createWorld.customize.flat.tile", new Object[0]);
        this.field_146391_r = I18n.format("createWorld.customize.flat.height", new Object[0]);
        this.createFlatWorldListSlotGui = new Details();
        final List buttonList = this.buttonList;
        final GuiButton field_146389_t = new GuiButton(2, this.width / 2 - 154, this.height - 52, 100, 20, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.flat.addLayer", new Object[0]))).append(" (NYI)")));
        this.field_146389_t = field_146389_t;
        buttonList.add(field_146389_t);
        final List buttonList2 = this.buttonList;
        final GuiButton field_146388_u = new GuiButton(3, this.width / 2 - 50, this.height - 52, 100, 20, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.flat.editLayer", new Object[0]))).append(" (NYI)")));
        this.field_146388_u = field_146388_u;
        buttonList2.add(field_146388_u);
        final List buttonList3 = this.buttonList;
        final GuiButton field_146386_v = new GuiButton(4, this.width / 2 - 155, this.height - 52, 150, 20, I18n.format("createWorld.customize.flat.removeLayer", new Object[0]));
        this.field_146386_v = field_146386_v;
        buttonList3.add(field_146386_v);
        this.buttonList.add(new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(new GuiButton(5, this.width / 2 + 5, this.height - 52, 150, 20, I18n.format("createWorld.customize.presets", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        final GuiButton field_146389_t2 = this.field_146389_t;
        final GuiButton field_146388_u2 = this.field_146388_u;
        final boolean b = false;
        field_146388_u2.visible = b;
        field_146389_t2.visible = b;
        this.theFlatGeneratorInfo.func_82645_d();
        this.func_146375_g();
    }
    
    public GuiCreateFlatWorld(final GuiCreateWorld llllllllllllllllIllIlIIllIlIlIlI, final String llllllllllllllllIllIlIIllIlIlIIl) {
        this.theFlatGeneratorInfo = FlatGeneratorInfo.getDefaultFlatGenerator();
        this.createWorldGui = llllllllllllllllIllIlIIllIlIlIlI;
        this.func_146383_a(llllllllllllllllIllIlIIllIlIlIIl);
    }
    
    private boolean func_146382_i() {
        return this.createFlatWorldListSlotGui.field_148228_k > -1 && this.createFlatWorldListSlotGui.field_148228_k < this.theFlatGeneratorInfo.getFlatLayers().size();
    }
    
    public void func_146383_a(final String llllllllllllllllIllIlIIllIIlllll) {
        this.theFlatGeneratorInfo = FlatGeneratorInfo.createFlatGeneratorFromString(llllllllllllllllIllIlIIllIIlllll);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllIllIlIIllIIIllll) throws IOException {
        final int llllllllllllllllIllIlIIllIIlIIIl = this.theFlatGeneratorInfo.getFlatLayers().size() - this.createFlatWorldListSlotGui.field_148228_k - 1;
        if (llllllllllllllllIllIlIIllIIIllll.id == 1) {
            this.mc.displayGuiScreen(this.createWorldGui);
        }
        else if (llllllllllllllllIllIlIIllIIIllll.id == 0) {
            this.createWorldGui.field_146334_a = this.func_146384_e();
            this.mc.displayGuiScreen(this.createWorldGui);
        }
        else if (llllllllllllllllIllIlIIllIIIllll.id == 5) {
            this.mc.displayGuiScreen(new GuiFlatPresets(this));
        }
        else if (llllllllllllllllIllIlIIllIIIllll.id == 4 && this.func_146382_i()) {
            this.theFlatGeneratorInfo.getFlatLayers().remove(llllllllllllllllIllIlIIllIIlIIIl);
            this.createFlatWorldListSlotGui.field_148228_k = Math.min(this.createFlatWorldListSlotGui.field_148228_k, this.theFlatGeneratorInfo.getFlatLayers().size() - 1);
        }
        this.theFlatGeneratorInfo.func_82645_d();
        this.func_146375_g();
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.createFlatWorldListSlotGui.func_178039_p();
    }
    
    class Details extends GuiSlot
    {
        public /* synthetic */ int field_148228_k;
        
        @Override
        protected int getScrollBarX() {
            return this.width - 70;
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllllIlIlIlIIIlIIIllI, final boolean llllllllllllllllIlIlIlIIIlIIIlIl, final int llllllllllllllllIlIlIlIIIlIIIlII, final int llllllllllllllllIlIlIlIIIlIIIIll) {
            this.field_148228_k = llllllllllllllllIlIlIlIIIlIIIllI;
            GuiCreateFlatWorld.this.func_146375_g();
        }
        
        private void func_148225_a(final int llllllllllllllllIlIlIlIIIllllIIl, final int llllllllllllllllIlIlIlIIIllllIII, final ItemStack llllllllllllllllIlIlIlIIIllllIll) {
            this.func_148226_e(llllllllllllllllIlIlIlIIIllllIIl + 1, llllllllllllllllIlIlIlIIIllllIII + 1);
            GlStateManager.enableRescaleNormal();
            if (llllllllllllllllIlIlIlIIIllllIll != null && llllllllllllllllIlIlIlIIIllllIll.getItem() != null) {
                RenderHelper.enableGUIStandardItemLighting();
                GuiCreateFlatWorld.this.itemRender.func_175042_a(llllllllllllllllIlIlIlIIIllllIll, llllllllllllllllIlIlIlIIIllllIIl + 2, llllllllllllllllIlIlIlIIIllllIII + 2);
                RenderHelper.disableStandardItemLighting();
            }
            GlStateManager.disableRescaleNormal();
        }
        
        private void func_148226_e(final int llllllllllllllllIlIlIlIIIllIllll, final int llllllllllllllllIlIlIlIIIlllIIIl) {
            this.func_148224_c(llllllllllllllllIlIlIlIIIllIllll, llllllllllllllllIlIlIlIIIlllIIIl, 0, 0);
        }
        
        static {
            __OBFID = "CL_00000688";
        }
        
        private void func_148224_c(final int llllllllllllllllIlIlIlIIIllIIIIl, final int llllllllllllllllIlIlIlIIIlIlIlIl, final int llllllllllllllllIlIlIlIIIlIlllll, final int llllllllllllllllIlIlIlIIIlIllllI) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(Gui.statIcons);
            final float llllllllllllllllIlIlIlIIIlIlllIl = 0.0078125f;
            final float llllllllllllllllIlIlIlIIIlIlllII = 0.0078125f;
            final boolean llllllllllllllllIlIlIlIIIlIllIll = true;
            final boolean llllllllllllllllIlIlIlIIIlIllIlI = true;
            final Tessellator llllllllllllllllIlIlIlIIIlIllIIl = Tessellator.getInstance();
            final WorldRenderer llllllllllllllllIlIlIlIIIlIllIII = llllllllllllllllIlIlIlIIIlIllIIl.getWorldRenderer();
            llllllllllllllllIlIlIlIIIlIllIII.startDrawingQuads();
            llllllllllllllllIlIlIlIIIlIllIII.addVertexWithUV(llllllllllllllllIlIlIlIIIllIIIIl + 0, llllllllllllllllIlIlIlIIIlIlIlIl + 18, GuiCreateFlatWorld.this.zLevel, (llllllllllllllllIlIlIlIIIlIlllll + 0) * 0.0078125f, (llllllllllllllllIlIlIlIIIlIllllI + 18) * 0.0078125f);
            llllllllllllllllIlIlIlIIIlIllIII.addVertexWithUV(llllllllllllllllIlIlIlIIIllIIIIl + 18, llllllllllllllllIlIlIlIIIlIlIlIl + 18, GuiCreateFlatWorld.this.zLevel, (llllllllllllllllIlIlIlIIIlIlllll + 18) * 0.0078125f, (llllllllllllllllIlIlIlIIIlIllllI + 18) * 0.0078125f);
            llllllllllllllllIlIlIlIIIlIllIII.addVertexWithUV(llllllllllllllllIlIlIlIIIllIIIIl + 18, llllllllllllllllIlIlIlIIIlIlIlIl + 0, GuiCreateFlatWorld.this.zLevel, (llllllllllllllllIlIlIlIIIlIlllll + 18) * 0.0078125f, (llllllllllllllllIlIlIlIIIlIllllI + 0) * 0.0078125f);
            llllllllllllllllIlIlIlIIIlIllIII.addVertexWithUV(llllllllllllllllIlIlIlIIIllIIIIl + 0, llllllllllllllllIlIlIlIIIlIlIlIl + 0, GuiCreateFlatWorld.this.zLevel, (llllllllllllllllIlIlIlIIIlIlllll + 0) * 0.0078125f, (llllllllllllllllIlIlIlIIIlIllllI + 0) * 0.0078125f);
            llllllllllllllllIlIlIlIIIlIllIIl.draw();
        }
        
        @Override
        protected int getSize() {
            return GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().size();
        }
        
        public Details() {
            super(GuiCreateFlatWorld.this.mc, GuiCreateFlatWorld.this.width, GuiCreateFlatWorld.this.height, 43, GuiCreateFlatWorld.this.height - 60, 24);
            this.field_148228_k = -1;
        }
        
        @Override
        protected boolean isSelected(final int llllllllllllllllIlIlIlIIIIlllIll) {
            return llllllllllllllllIlIlIlIIIIlllIll == this.field_148228_k;
        }
        
        @Override
        protected void drawBackground() {
        }
        
        @Override
        protected void drawSlot(final int llllllllllllllllIlIlIlIIIIIlllIl, final int llllllllllllllllIlIlIlIIIIlIllII, final int llllllllllllllllIlIlIlIIIIlIlIll, final int llllllllllllllllIlIlIlIIIIlIlIlI, final int llllllllllllllllIlIlIlIIIIlIlIIl, final int llllllllllllllllIlIlIlIIIIlIlIII) {
            final FlatLayerInfo llllllllllllllllIlIlIlIIIIlIIlll = GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().get(GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().size() - llllllllllllllllIlIlIlIIIIIlllIl - 1);
            final IBlockState llllllllllllllllIlIlIlIIIIlIIllI = llllllllllllllllIlIlIlIIIIlIIlll.func_175900_c();
            final Block llllllllllllllllIlIlIlIIIIlIIlIl = llllllllllllllllIlIlIlIIIIlIIllI.getBlock();
            Item llllllllllllllllIlIlIlIIIIlIIlII = Item.getItemFromBlock(llllllllllllllllIlIlIlIIIIlIIlIl);
            ItemStack llllllllllllllllIlIlIlIIIIlIIIll = (llllllllllllllllIlIlIlIIIIlIIlIl != Blocks.air && llllllllllllllllIlIlIlIIIIlIIlII != null) ? new ItemStack(llllllllllllllllIlIlIlIIIIlIIlII, 1, llllllllllllllllIlIlIlIIIIlIIlIl.getMetaFromState(llllllllllllllllIlIlIlIIIIlIIllI)) : null;
            String llllllllllllllllIlIlIlIIIIlIIIlI = (llllllllllllllllIlIlIlIIIIlIIIll == null) ? "Air" : llllllllllllllllIlIlIlIIIIlIIlII.getItemStackDisplayName(llllllllllllllllIlIlIlIIIIlIIIll);
            if (llllllllllllllllIlIlIlIIIIlIIlII == null) {
                if (llllllllllllllllIlIlIlIIIIlIIlIl != Blocks.water && llllllllllllllllIlIlIlIIIIlIIlIl != Blocks.flowing_water) {
                    if (llllllllllllllllIlIlIlIIIIlIIlIl == Blocks.lava || llllllllllllllllIlIlIlIIIIlIIlIl == Blocks.flowing_lava) {
                        llllllllllllllllIlIlIlIIIIlIIlII = Items.lava_bucket;
                    }
                }
                else {
                    llllllllllllllllIlIlIlIIIIlIIlII = Items.water_bucket;
                }
                if (llllllllllllllllIlIlIlIIIIlIIlII != null) {
                    llllllllllllllllIlIlIlIIIIlIIIll = new ItemStack(llllllllllllllllIlIlIlIIIIlIIlII, 1, llllllllllllllllIlIlIlIIIIlIIlIl.getMetaFromState(llllllllllllllllIlIlIlIIIIlIIllI));
                    llllllllllllllllIlIlIlIIIIlIIIlI = llllllllllllllllIlIlIlIIIIlIIlIl.getLocalizedName();
                }
            }
            this.func_148225_a(llllllllllllllllIlIlIlIIIIlIllII, llllllllllllllllIlIlIlIIIIlIlIll, llllllllllllllllIlIlIlIIIIlIIIll);
            GuiCreateFlatWorld.this.fontRendererObj.drawString(llllllllllllllllIlIlIlIIIIlIIIlI, llllllllllllllllIlIlIlIIIIlIllII + 18 + 5, llllllllllllllllIlIlIlIIIIlIlIll + 3, 16777215);
            String llllllllllllllllIlIlIlIIIIIlllll = null;
            if (llllllllllllllllIlIlIlIIIIIlllIl == 0) {
                final String llllllllllllllllIlIlIlIIIIlIIIIl = I18n.format("createWorld.customize.flat.layer.top", llllllllllllllllIlIlIlIIIIlIIlll.getLayerCount());
            }
            else if (llllllllllllllllIlIlIlIIIIIlllIl == GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().size() - 1) {
                final String llllllllllllllllIlIlIlIIIIlIIIII = I18n.format("createWorld.customize.flat.layer.bottom", llllllllllllllllIlIlIlIIIIlIIlll.getLayerCount());
            }
            else {
                llllllllllllllllIlIlIlIIIIIlllll = I18n.format("createWorld.customize.flat.layer", llllllllllllllllIlIlIlIIIIlIIlll.getLayerCount());
            }
            GuiCreateFlatWorld.this.fontRendererObj.drawString(llllllllllllllllIlIlIlIIIIIlllll, llllllllllllllllIlIlIlIIIIlIllII + 2 + 213 - GuiCreateFlatWorld.this.fontRendererObj.getStringWidth(llllllllllllllllIlIlIlIIIIIlllll), llllllllllllllllIlIlIlIIIIlIlIll + 3, 16777215);
        }
    }
}
