package net.minecraft.client.gui;

import java.util.*;
import org.lwjgl.input.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;
import net.minecraft.world.gen.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.renderer.*;

public class GuiScreenCustomizePresets extends GuiScreen
{
    private /* synthetic */ GuiCustomizeWorldScreen field_175314_r;
    private /* synthetic */ GuiTextField field_175317_i;
    private /* synthetic */ String field_175312_t;
    protected /* synthetic */ String field_175315_a;
    private /* synthetic */ ListPreset field_175311_g;
    private /* synthetic */ GuiButton field_175316_h;
    private static final /* synthetic */ List field_175310_f;
    private /* synthetic */ String field_175313_s;
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.field_175315_a = I18n.format("createWorld.customize.custom.presets.title", new Object[0]);
        this.field_175313_s = I18n.format("createWorld.customize.presets.share", new Object[0]);
        this.field_175312_t = I18n.format("createWorld.customize.presets.list", new Object[0]);
        this.field_175317_i = new GuiTextField(2, this.fontRendererObj, 50, 40, this.width - 100, 20);
        this.field_175311_g = new ListPreset();
        this.field_175317_i.setMaxStringLength(2000);
        this.field_175317_i.setText(this.field_175314_r.func_175323_a());
        final List buttonList = this.buttonList;
        final GuiButton field_175316_h = new GuiButton(0, this.width / 2 - 102, this.height - 27, 100, 20, I18n.format("createWorld.customize.presets.select", new Object[0]));
        this.field_175316_h = field_175316_h;
        buttonList.add(field_175316_h);
        this.buttonList.add(new GuiButton(1, this.width / 2 + 3, this.height - 27, 100, 20, I18n.format("gui.cancel", new Object[0])));
        this.func_175304_a();
    }
    
    static {
        __OBFID = "CL_00001937";
        field_175310_f = Lists.newArrayList();
        ChunkProviderSettings.Factory llllllllllllllllIIlllIIIIlllIllI = ChunkProviderSettings.Factory.func_177865_a("{ \"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":5000.0, \"mainNoiseScaleY\":1000.0, \"mainNoiseScaleZ\":5000.0, \"baseSize\":8.5, \"stretchY\":8.0, \"biomeDepthWeight\":2.0, \"biomeDepthOffset\":0.5, \"biomeScaleWeight\":2.0, \"biomeScaleOffset\":0.375, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":255 }");
        ResourceLocation llllllllllllllllIIlllIIIIlllIlIl = new ResourceLocation("textures/gui/presets/water.png");
        GuiScreenCustomizePresets.field_175310_f.add(new Info(I18n.format("createWorld.customize.custom.preset.waterWorld", new Object[0]), llllllllllllllllIIlllIIIIlllIlIl, llllllllllllllllIIlllIIIIlllIllI));
        llllllllllllllllIIlllIIIIlllIllI = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":3000.0, \"heightScale\":6000.0, \"upperLimitScale\":250.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":10.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
        llllllllllllllllIIlllIIIIlllIlIl = new ResourceLocation("textures/gui/presets/isles.png");
        GuiScreenCustomizePresets.field_175310_f.add(new Info(I18n.format("createWorld.customize.custom.preset.isleLand", new Object[0]), llllllllllllllllIIlllIIIIlllIlIl, llllllllllllllllIIlllIIIIlllIllI));
        llllllllllllllllIIlllIIIIlllIllI = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":5000.0, \"mainNoiseScaleY\":1000.0, \"mainNoiseScaleZ\":5000.0, \"baseSize\":8.5, \"stretchY\":5.0, \"biomeDepthWeight\":2.0, \"biomeDepthOffset\":1.0, \"biomeScaleWeight\":4.0, \"biomeScaleOffset\":1.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
        llllllllllllllllIIlllIIIIlllIlIl = new ResourceLocation("textures/gui/presets/delight.png");
        GuiScreenCustomizePresets.field_175310_f.add(new Info(I18n.format("createWorld.customize.custom.preset.caveDelight", new Object[0]), llllllllllllllllIIlllIIIIlllIlIl, llllllllllllllllIIlllIIIIlllIllI));
        llllllllllllllllIIlllIIIIlllIllI = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":738.41864, \"heightScale\":157.69133, \"upperLimitScale\":801.4267, \"lowerLimitScale\":1254.1643, \"depthNoiseScaleX\":374.93652, \"depthNoiseScaleZ\":288.65228, \"depthNoiseScaleExponent\":1.2092624, \"mainNoiseScaleX\":1355.9908, \"mainNoiseScaleY\":745.5343, \"mainNoiseScaleZ\":1183.464, \"baseSize\":1.8758626, \"stretchY\":1.7137525, \"biomeDepthWeight\":1.7553768, \"biomeDepthOffset\":3.4701107, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":2.535211, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
        llllllllllllllllIIlllIIIIlllIlIl = new ResourceLocation("textures/gui/presets/madness.png");
        GuiScreenCustomizePresets.field_175310_f.add(new Info(I18n.format("createWorld.customize.custom.preset.mountains", new Object[0]), llllllllllllllllIIlllIIIIlllIlIl, llllllllllllllllIIlllIIIIlllIllI));
        llllllllllllllllIIlllIIIIlllIllI = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":1000.0, \"mainNoiseScaleY\":3000.0, \"mainNoiseScaleZ\":1000.0, \"baseSize\":8.5, \"stretchY\":10.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":20 }");
        llllllllllllllllIIlllIIIIlllIlIl = new ResourceLocation("textures/gui/presets/drought.png");
        GuiScreenCustomizePresets.field_175310_f.add(new Info(I18n.format("createWorld.customize.custom.preset.drought", new Object[0]), llllllllllllllllIIlllIIIIlllIlIl, llllllllllllllllIIlllIIIIlllIllI));
        llllllllllllllllIIlllIIIIlllIllI = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":2.0, \"lowerLimitScale\":64.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":12.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":6 }");
        llllllllllllllllIIlllIIIIlllIlIl = new ResourceLocation("textures/gui/presets/chaos.png");
        GuiScreenCustomizePresets.field_175310_f.add(new Info(I18n.format("createWorld.customize.custom.preset.caveChaos", new Object[0]), llllllllllllllllIIlllIIIIlllIlIl, llllllllllllllllIIlllIIIIlllIllI));
        llllllllllllllllIIlllIIIIlllIllI = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":12.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":true, \"seaLevel\":40 }");
        llllllllllllllllIIlllIIIIlllIlIl = new ResourceLocation("textures/gui/presets/luck.png");
        GuiScreenCustomizePresets.field_175310_f.add(new Info(I18n.format("createWorld.customize.custom.preset.goodLuck", new Object[0]), llllllllllllllllIIlllIIIIlllIlIl, llllllllllllllllIIlllIIIIlllIllI));
    }
    
    private boolean func_175305_g() {
        return (this.field_175311_g.field_178053_u > -1 && this.field_175311_g.field_178053_u < GuiScreenCustomizePresets.field_175310_f.size()) || this.field_175317_i.getText().length() > 1;
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllllIIlllIIIIlIlIIlI, final int llllllllllllllllIIlllIIIIlIlIlII) throws IOException {
        if (!this.field_175317_i.textboxKeyTyped(llllllllllllllllIIlllIIIIlIlIIlI, llllllllllllllllIIlllIIIIlIlIlII)) {
            super.keyTyped(llllllllllllllllIIlllIIIIlIlIIlI, llllllllllllllllIIlllIIIIlIlIlII);
        }
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllllIIlllIIIIllIIIII, final int llllllllllllllllIIlllIIIIlIllIll, final int llllllllllllllllIIlllIIIIlIllllI) throws IOException {
        this.field_175317_i.mouseClicked(llllllllllllllllIIlllIIIIllIIIII, llllllllllllllllIIlllIIIIlIllIll, llllllllllllllllIIlllIIIIlIllllI);
        super.mouseClicked(llllllllllllllllIIlllIIIIllIIIII, llllllllllllllllIIlllIIIIlIllIll, llllllllllllllllIIlllIIIIlIllllI);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void updateScreen() {
        this.field_175317_i.updateCursorCounter();
        super.updateScreen();
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.field_175311_g.func_178039_p();
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIIlllIIIIlIIIlIl, final int llllllllllllllllIIlllIIIIlIIIIII, final float llllllllllllllllIIlllIIIIIllllll) {
        this.drawDefaultBackground();
        this.field_175311_g.drawScreen(llllllllllllllllIIlllIIIIlIIIlIl, llllllllllllllllIIlllIIIIlIIIIII, llllllllllllllllIIlllIIIIIllllll);
        this.drawCenteredString(this.fontRendererObj, this.field_175315_a, this.width / 2, 8, 16777215);
        this.drawString(this.fontRendererObj, this.field_175313_s, 50, 30, 10526880);
        this.drawString(this.fontRendererObj, this.field_175312_t, 50, 70, 10526880);
        this.field_175317_i.drawTextBox();
        super.drawScreen(llllllllllllllllIIlllIIIIlIIIlIl, llllllllllllllllIIlllIIIIlIIIIII, llllllllllllllllIIlllIIIIIllllll);
    }
    
    public GuiScreenCustomizePresets(final GuiCustomizeWorldScreen llllllllllllllllIIlllIIIIllIllIl) {
        this.field_175315_a = "Customize World Presets";
        this.field_175314_r = llllllllllllllllIIlllIIIIllIllIl;
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllIIlllIIIIlIIlIll) throws IOException {
        switch (llllllllllllllllIIlllIIIIlIIlIll.id) {
            case 0: {
                this.field_175314_r.func_175324_a(this.field_175317_i.getText());
                this.mc.displayGuiScreen(this.field_175314_r);
                break;
            }
            case 1: {
                this.mc.displayGuiScreen(this.field_175314_r);
                break;
            }
        }
    }
    
    public void func_175304_a() {
        this.field_175316_h.enabled = this.func_175305_g();
    }
    
    static class Info
    {
        public /* synthetic */ String field_178955_a;
        public /* synthetic */ ResourceLocation field_178953_b;
        public /* synthetic */ ChunkProviderSettings.Factory field_178954_c;
        
        public Info(final String lllllllllllllllIIlIIlIIIIIlIIIlI, final ResourceLocation lllllllllllllllIIlIIlIIIIIlIIlIl, final ChunkProviderSettings.Factory lllllllllllllllIIlIIlIIIIIlIIIII) {
            this.field_178955_a = lllllllllllllllIIlIIlIIIIIlIIIlI;
            this.field_178953_b = lllllllllllllllIIlIIlIIIIIlIIlIl;
            this.field_178954_c = lllllllllllllllIIlIIlIIIIIlIIIII;
        }
        
        static {
            __OBFID = "CL_00001936";
        }
    }
    
    class ListPreset extends GuiSlot
    {
        public /* synthetic */ int field_178053_u;
        
        public ListPreset() {
            super(GuiScreenCustomizePresets.this.mc, GuiScreenCustomizePresets.this.width, GuiScreenCustomizePresets.this.height, 80, GuiScreenCustomizePresets.this.height - 32, 38);
            this.field_178053_u = -1;
        }
        
        @Override
        protected void drawSlot(final int lllllllllllllllIIIllllllIlIlIIll, final int lllllllllllllllIIIllllllIlIllIlI, final int lllllllllllllllIIIllllllIlIllIIl, final int lllllllllllllllIIIllllllIlIllIII, final int lllllllllllllllIIIllllllIlIlIlll, final int lllllllllllllllIIIllllllIlIlIllI) {
            final Info lllllllllllllllIIIllllllIlIlIlIl = GuiScreenCustomizePresets.field_175310_f.get(lllllllllllllllIIIllllllIlIlIIll);
            this.func_178051_a(lllllllllllllllIIIllllllIlIllIlI, lllllllllllllllIIIllllllIlIllIIl, lllllllllllllllIIIllllllIlIlIlIl.field_178953_b);
            GuiScreenCustomizePresets.this.fontRendererObj.drawString(lllllllllllllllIIIllllllIlIlIlIl.field_178955_a, lllllllllllllllIIIllllllIlIllIlI + 32 + 10, lllllllllllllllIIIllllllIlIllIIl + 14, 16777215);
        }
        
        @Override
        protected void drawBackground() {
        }
        
        @Override
        protected int getSize() {
            return GuiScreenCustomizePresets.field_175310_f.size();
        }
        
        static {
            __OBFID = "CL_00001935";
        }
        
        private void func_178051_a(final int lllllllllllllllIIIllllllIlllIIlI, final int lllllllllllllllIIIllllllIllIlIII, final ResourceLocation lllllllllllllllIIIllllllIllIIlll) {
            final int lllllllllllllllIIIllllllIllIllll = lllllllllllllllIIIllllllIlllIIlI + 5;
            GuiScreenCustomizePresets.this.drawHorizontalLine(lllllllllllllllIIIllllllIllIllll - 1, lllllllllllllllIIIllllllIllIllll + 32, lllllllllllllllIIIllllllIllIlIII - 1, -2039584);
            GuiScreenCustomizePresets.this.drawHorizontalLine(lllllllllllllllIIIllllllIllIllll - 1, lllllllllllllllIIIllllllIllIllll + 32, lllllllllllllllIIIllllllIllIlIII + 32, -6250336);
            GuiScreenCustomizePresets.this.drawVerticalLine(lllllllllllllllIIIllllllIllIllll - 1, lllllllllllllllIIIllllllIllIlIII - 1, lllllllllllllllIIIllllllIllIlIII + 32, -2039584);
            GuiScreenCustomizePresets.this.drawVerticalLine(lllllllllllllllIIIllllllIllIllll + 32, lllllllllllllllIIIllllllIllIlIII - 1, lllllllllllllllIIIllllllIllIlIII + 32, -6250336);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(lllllllllllllllIIIllllllIllIIlll);
            final boolean lllllllllllllllIIIllllllIllIlllI = true;
            final boolean lllllllllllllllIIIllllllIllIllIl = true;
            final Tessellator lllllllllllllllIIIllllllIllIllII = Tessellator.getInstance();
            final WorldRenderer lllllllllllllllIIIllllllIllIlIll = lllllllllllllllIIIllllllIllIllII.getWorldRenderer();
            lllllllllllllllIIIllllllIllIlIll.startDrawingQuads();
            lllllllllllllllIIIllllllIllIlIll.addVertexWithUV(lllllllllllllllIIIllllllIllIllll + 0, lllllllllllllllIIIllllllIllIlIII + 32, 0.0, 0.0, 1.0);
            lllllllllllllllIIIllllllIllIlIll.addVertexWithUV(lllllllllllllllIIIllllllIllIllll + 32, lllllllllllllllIIIllllllIllIlIII + 32, 0.0, 1.0, 1.0);
            lllllllllllllllIIIllllllIllIlIll.addVertexWithUV(lllllllllllllllIIIllllllIllIllll + 32, lllllllllllllllIIIllllllIllIlIII + 0, 0.0, 1.0, 0.0);
            lllllllllllllllIIIllllllIllIlIll.addVertexWithUV(lllllllllllllllIIIllllllIllIllll + 0, lllllllllllllllIIIllllllIllIlIII + 0, 0.0, 0.0, 0.0);
            lllllllllllllllIIIllllllIllIllII.draw();
        }
        
        @Override
        protected void elementClicked(final int lllllllllllllllIIIlllllllIIIlIIl, final boolean lllllllllllllllIIIlllllllIIIlIII, final int lllllllllllllllIIIlllllllIIIIlll, final int lllllllllllllllIIIlllllllIIIIllI) {
            this.field_178053_u = lllllllllllllllIIIlllllllIIIlIIl;
            GuiScreenCustomizePresets.this.func_175304_a();
            GuiScreenCustomizePresets.this.field_175317_i.setText(GuiScreenCustomizePresets.field_175310_f.get(GuiScreenCustomizePresets.this.field_175311_g.field_178053_u).field_178954_c.toString());
        }
        
        @Override
        protected boolean isSelected(final int lllllllllllllllIIIlllllllIIIIIII) {
            return lllllllllllllllIIIlllllllIIIIIII == this.field_178053_u;
        }
    }
}
