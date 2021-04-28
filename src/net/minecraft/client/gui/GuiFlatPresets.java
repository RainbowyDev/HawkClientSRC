package net.minecraft.client.gui;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import java.io.*;
import org.lwjgl.input.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.item.*;

public class GuiFlatPresets extends GuiScreen
{
    private static final /* synthetic */ List field_146431_f;
    private /* synthetic */ String field_146436_r;
    private /* synthetic */ GuiTextField field_146433_u;
    private final /* synthetic */ GuiCreateFlatWorld field_146432_g;
    private /* synthetic */ String field_146439_i;
    private /* synthetic */ ListSlot field_146435_s;
    private /* synthetic */ String field_146438_h;
    private /* synthetic */ GuiButton field_146434_t;
    
    private static void func_146421_a(final String lIlIIIIlIIlllIl, final Item lIlIIIIlIIlIlll, final BiomeGenBase lIlIIIIlIIllIll, final List lIlIIIIlIIllIlI, final FlatLayerInfo... lIlIIIIlIIllIIl) {
        func_175354_a(lIlIIIIlIIlllIl, lIlIIIIlIIlIlll, 0, lIlIIIIlIIllIll, lIlIIIIlIIllIlI, lIlIIIIlIIllIIl);
    }
    
    public GuiFlatPresets(final GuiCreateFlatWorld lIlIIIIlllIlIll) {
        this.field_146432_g = lIlIIIIlllIlIll;
    }
    
    private static void func_146425_a(final String lIlIIIIlIlIIllI, final Item lIlIIIIlIlIlIIl, final BiomeGenBase lIlIIIIlIlIIlII, final FlatLayerInfo... lIlIIIIlIlIIlll) {
        func_175354_a(lIlIIIIlIlIIllI, lIlIIIIlIlIlIIl, 0, lIlIIIIlIlIIlII, null, lIlIIIIlIlIIlll);
    }
    
    @Override
    public void updateScreen() {
        this.field_146433_u.updateCursorCounter();
        super.updateScreen();
    }
    
    public void func_146426_g() {
        final boolean lIlIIIIlIllIlII = this.func_146430_p();
        this.field_146434_t.enabled = lIlIIIIlIllIlII;
    }
    
    private static void func_175354_a(final String lIlIIIIlIIIlIlI, final Item lIlIIIIlIIIlIIl, final int lIlIIIIIllllllI, final BiomeGenBase lIlIIIIlIIIIlll, final List lIlIIIIIlllllII, final FlatLayerInfo... lIlIIIIIllllIll) {
        final FlatGeneratorInfo lIlIIIIlIIIIlII = new FlatGeneratorInfo();
        for (int lIlIIIIlIIIIIll = lIlIIIIIllllIll.length - 1; lIlIIIIlIIIIIll >= 0; --lIlIIIIlIIIIIll) {
            lIlIIIIlIIIIlII.getFlatLayers().add(lIlIIIIIllllIll[lIlIIIIlIIIIIll]);
        }
        lIlIIIIlIIIIlII.setBiome(lIlIIIIlIIIIlll.biomeID);
        lIlIIIIlIIIIlII.func_82645_d();
        if (lIlIIIIIlllllII != null) {
            for (final String lIlIIIIlIIIIIIl : lIlIIIIIlllllII) {
                lIlIIIIlIIIIlII.getWorldFeatures().put(lIlIIIIlIIIIIIl, Maps.newHashMap());
            }
        }
        GuiFlatPresets.field_146431_f.add(new LayerItem(lIlIIIIlIIIlIIl, lIlIIIIIllllllI, lIlIIIIlIIIlIlI, lIlIIIIlIIIIlII.toString()));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lIlIIIIllIIIlll) throws IOException {
        if (lIlIIIIllIIIlll.id == 0 && this.func_146430_p()) {
            this.field_146432_g.func_146383_a(this.field_146433_u.getText());
            this.mc.displayGuiScreen(this.field_146432_g);
        }
        else if (lIlIIIIllIIIlll.id == 1) {
            this.mc.displayGuiScreen(this.field_146432_g);
        }
    }
    
    @Override
    public void drawScreen(final int lIlIIIIllIIIIIl, final int lIlIIIIlIllllII, final float lIlIIIIlIlllIll) {
        this.drawDefaultBackground();
        this.field_146435_s.drawScreen(lIlIIIIllIIIIIl, lIlIIIIlIllllII, lIlIIIIlIlllIll);
        this.drawCenteredString(this.fontRendererObj, this.field_146438_h, this.width / 2, 8, 16777215);
        this.drawString(this.fontRendererObj, this.field_146439_i, 50, 30, 10526880);
        this.drawString(this.fontRendererObj, this.field_146436_r, 50, 70, 10526880);
        this.field_146433_u.drawTextBox();
        super.drawScreen(lIlIIIIllIIIIIl, lIlIIIIlIllllII, lIlIIIIlIlllIll);
    }
    
    @Override
    protected void keyTyped(final char lIlIIIIllIIlllI, final int lIlIIIIllIIllIl) throws IOException {
        if (!this.field_146433_u.textboxKeyTyped(lIlIIIIllIIlllI, lIlIIIIllIIllIl)) {
            super.keyTyped(lIlIIIIllIIlllI, lIlIIIIllIIllIl);
        }
    }
    
    @Override
    protected void mouseClicked(final int lIlIIIIllIllIII, final int lIlIIIIllIllIll, final int lIlIIIIllIlIllI) throws IOException {
        this.field_146433_u.mouseClicked(lIlIIIIllIllIII, lIlIIIIllIllIll, lIlIIIIllIlIllI);
        super.mouseClicked(lIlIIIIllIllIII, lIlIIIIllIllIll, lIlIIIIllIlIllI);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.field_146438_h = I18n.format("createWorld.customize.presets.title", new Object[0]);
        this.field_146439_i = I18n.format("createWorld.customize.presets.share", new Object[0]);
        this.field_146436_r = I18n.format("createWorld.customize.presets.list", new Object[0]);
        this.field_146433_u = new GuiTextField(2, this.fontRendererObj, 50, 40, this.width - 100, 20);
        this.field_146435_s = new ListSlot();
        this.field_146433_u.setMaxStringLength(1230);
        this.field_146433_u.setText(this.field_146432_g.func_146384_e());
        final List buttonList = this.buttonList;
        final GuiButton field_146434_t = new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("createWorld.customize.presets.select", new Object[0]));
        this.field_146434_t = field_146434_t;
        buttonList.add(field_146434_t);
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.func_146426_g();
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.field_146435_s.func_178039_p();
    }
    
    private boolean func_146430_p() {
        return (this.field_146435_s.field_148175_k > -1 && this.field_146435_s.field_148175_k < GuiFlatPresets.field_146431_f.size()) || this.field_146433_u.getText().length() > 1;
    }
    
    static {
        __OBFID = "CL_00000704";
        field_146431_f = Lists.newArrayList();
        func_146421_a("Classic Flat", Item.getItemFromBlock(Blocks.grass), BiomeGenBase.plains, Arrays.asList("village"), new FlatLayerInfo(1, Blocks.grass), new FlatLayerInfo(2, Blocks.dirt), new FlatLayerInfo(1, Blocks.bedrock));
        func_146421_a("Tunnelers' Dream", Item.getItemFromBlock(Blocks.stone), BiomeGenBase.extremeHills, Arrays.asList("biome_1", "dungeon", "decoration", "stronghold", "mineshaft"), new FlatLayerInfo(1, Blocks.grass), new FlatLayerInfo(5, Blocks.dirt), new FlatLayerInfo(230, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
        func_146421_a("Water World", Items.water_bucket, BiomeGenBase.deepOcean, Arrays.asList("biome_1", "oceanmonument"), new FlatLayerInfo(90, Blocks.water), new FlatLayerInfo(5, Blocks.sand), new FlatLayerInfo(5, Blocks.dirt), new FlatLayerInfo(5, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
        func_175354_a("Overworld", Item.getItemFromBlock(Blocks.tallgrass), BlockTallGrass.EnumType.GRASS.func_177044_a(), BiomeGenBase.plains, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon", "lake", "lava_lake"), new FlatLayerInfo(1, Blocks.grass), new FlatLayerInfo(3, Blocks.dirt), new FlatLayerInfo(59, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
        func_146421_a("Snowy Kingdom", Item.getItemFromBlock(Blocks.snow_layer), BiomeGenBase.icePlains, Arrays.asList("village", "biome_1"), new FlatLayerInfo(1, Blocks.snow_layer), new FlatLayerInfo(1, Blocks.grass), new FlatLayerInfo(3, Blocks.dirt), new FlatLayerInfo(59, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
        func_146421_a("Bottomless Pit", Items.feather, BiomeGenBase.plains, Arrays.asList("village", "biome_1"), new FlatLayerInfo(1, Blocks.grass), new FlatLayerInfo(3, Blocks.dirt), new FlatLayerInfo(2, Blocks.cobblestone));
        func_146421_a("Desert", Item.getItemFromBlock(Blocks.sand), BiomeGenBase.desert, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon"), new FlatLayerInfo(8, Blocks.sand), new FlatLayerInfo(52, Blocks.sandstone), new FlatLayerInfo(3, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
        func_146425_a("Redstone Ready", Items.redstone, BiomeGenBase.desert, new FlatLayerInfo(52, Blocks.sandstone), new FlatLayerInfo(3, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
    }
    
    static class LayerItem
    {
        public /* synthetic */ int field_179037_b;
        public /* synthetic */ Item field_148234_a;
        public /* synthetic */ String field_148233_c;
        public /* synthetic */ String field_148232_b;
        
        public LayerItem(final Item llllllllllllllllIIlIlIlIllllIIII, final int llllllllllllllllIIlIlIlIlllIllll, final String llllllllllllllllIIlIlIlIllllIIll, final String llllllllllllllllIIlIlIlIllllIIlI) {
            this.field_148234_a = llllllllllllllllIIlIlIlIllllIIII;
            this.field_179037_b = llllllllllllllllIIlIlIlIlllIllll;
            this.field_148232_b = llllllllllllllllIIlIlIlIllllIIll;
            this.field_148233_c = llllllllllllllllIIlIlIlIllllIIlI;
        }
        
        static {
            __OBFID = "CL_00000705";
        }
    }
    
    class ListSlot extends GuiSlot
    {
        public /* synthetic */ int field_148175_k;
        
        @Override
        protected boolean isSelected(final int llllllllllllllllllIIllllIIIIlllI) {
            return llllllllllllllllllIIllllIIIIlllI == this.field_148175_k;
        }
        
        @Override
        protected void drawSlot(final int llllllllllllllllllIIllllIIIIIlII, final int llllllllllllllllllIIlllIlllllIll, final int llllllllllllllllllIIllllIIIIIIlI, final int llllllllllllllllllIIllllIIIIIIIl, final int llllllllllllllllllIIllllIIIIIIII, final int llllllllllllllllllIIlllIllllllll) {
            final LayerItem llllllllllllllllllIIlllIlllllllI = GuiFlatPresets.field_146431_f.get(llllllllllllllllllIIllllIIIIIlII);
            this.func_178054_a(llllllllllllllllllIIlllIlllllIll, llllllllllllllllllIIllllIIIIIIlI, llllllllllllllllllIIlllIlllllllI.field_148234_a, llllllllllllllllllIIlllIlllllllI.field_179037_b);
            GuiFlatPresets.this.fontRendererObj.drawString(llllllllllllllllllIIlllIlllllllI.field_148232_b, llllllllllllllllllIIlllIlllllIll + 18 + 5, llllllllllllllllllIIllllIIIIIIlI + 6, 16777215);
        }
        
        private void func_148171_c(final int llllllllllllllllllIIllllIIlIIlIl, final int llllllllllllllllllIIllllIIlIIlII, final int llllllllllllllllllIIllllIIlIIIll, final int llllllllllllllllllIIllllIIlIIIlI) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(Gui.statIcons);
            final float llllllllllllllllllIIllllIIlIllII = 0.0078125f;
            final float llllllllllllllllllIIllllIIlIlIll = 0.0078125f;
            final boolean llllllllllllllllllIIllllIIlIlIlI = true;
            final boolean llllllllllllllllllIIllllIIlIlIIl = true;
            final Tessellator llllllllllllllllllIIllllIIlIlIII = Tessellator.getInstance();
            final WorldRenderer llllllllllllllllllIIllllIIlIIlll = llllllllllllllllllIIllllIIlIlIII.getWorldRenderer();
            llllllllllllllllllIIllllIIlIIlll.startDrawingQuads();
            llllllllllllllllllIIllllIIlIIlll.addVertexWithUV(llllllllllllllllllIIllllIIlIIlIl + 0, llllllllllllllllllIIllllIIlIIlII + 18, GuiFlatPresets.this.zLevel, (llllllllllllllllllIIllllIIlIIIll + 0) * 0.0078125f, (llllllllllllllllllIIllllIIlIIIlI + 18) * 0.0078125f);
            llllllllllllllllllIIllllIIlIIlll.addVertexWithUV(llllllllllllllllllIIllllIIlIIlIl + 18, llllllllllllllllllIIllllIIlIIlII + 18, GuiFlatPresets.this.zLevel, (llllllllllllllllllIIllllIIlIIIll + 18) * 0.0078125f, (llllllllllllllllllIIllllIIlIIIlI + 18) * 0.0078125f);
            llllllllllllllllllIIllllIIlIIlll.addVertexWithUV(llllllllllllllllllIIllllIIlIIlIl + 18, llllllllllllllllllIIllllIIlIIlII + 0, GuiFlatPresets.this.zLevel, (llllllllllllllllllIIllllIIlIIIll + 18) * 0.0078125f, (llllllllllllllllllIIllllIIlIIIlI + 0) * 0.0078125f);
            llllllllllllllllllIIllllIIlIIlll.addVertexWithUV(llllllllllllllllllIIllllIIlIIlIl + 0, llllllllllllllllllIIllllIIlIIlII + 0, GuiFlatPresets.this.zLevel, (llllllllllllllllllIIllllIIlIIIll + 0) * 0.0078125f, (llllllllllllllllllIIllllIIlIIIlI + 0) * 0.0078125f);
            llllllllllllllllllIIllllIIlIlIII.draw();
        }
        
        public ListSlot() {
            super(GuiFlatPresets.this.mc, GuiFlatPresets.this.width, GuiFlatPresets.this.height, 80, GuiFlatPresets.this.height - 37, 24);
            this.field_148175_k = -1;
        }
        
        @Override
        protected void drawBackground() {
        }
        
        @Override
        protected int getSize() {
            return GuiFlatPresets.field_146431_f.size();
        }
        
        static {
            __OBFID = "CL_00000706";
        }
        
        private void func_148173_e(final int llllllllllllllllllIIllllIIlllllI, final int llllllllllllllllllIIllllIlIIIIII) {
            this.func_148171_c(llllllllllllllllllIIllllIIlllllI, llllllllllllllllllIIllllIlIIIIII, 0, 0);
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllllllIIllllIIIlIlll, final boolean llllllllllllllllllIIllllIIIlIllI, final int llllllllllllllllllIIllllIIIlIlIl, final int llllllllllllllllllIIllllIIIlIlII) {
            this.field_148175_k = llllllllllllllllllIIllllIIIlIlll;
            GuiFlatPresets.this.func_146426_g();
            GuiFlatPresets.this.field_146433_u.setText(GuiFlatPresets.field_146431_f.get(GuiFlatPresets.this.field_146435_s.field_148175_k).field_148233_c);
        }
        
        private void func_178054_a(final int llllllllllllllllllIIllllIlIIlllI, final int llllllllllllllllllIIllllIlIIlIII, final Item llllllllllllllllllIIllllIlIIIlll, final int llllllllllllllllllIIllllIlIIIllI) {
            this.func_148173_e(llllllllllllllllllIIllllIlIIlllI + 1, llllllllllllllllllIIllllIlIIlIII + 1);
            GlStateManager.enableRescaleNormal();
            RenderHelper.enableGUIStandardItemLighting();
            GuiFlatPresets.this.itemRender.func_175042_a(new ItemStack(llllllllllllllllllIIllllIlIIIlll, 1, llllllllllllllllllIIllllIlIIIllI), llllllllllllllllllIIllllIlIIlllI + 2, llllllllllllllllllIIllllIlIIlIII + 2);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
        }
    }
}
