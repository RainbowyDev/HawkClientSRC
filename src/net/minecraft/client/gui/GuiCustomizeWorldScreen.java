package net.minecraft.client.gui;

import com.google.common.base.*;
import net.minecraft.world.gen.*;
import net.minecraft.client.resources.*;
import java.io.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.*;
import com.google.common.primitives.*;

public class GuiCustomizeWorldScreen extends GuiScreen implements GuiSlider.FormatHelper, GuiPageButtonList.GuiResponder
{
    private /* synthetic */ GuiButton field_175344_w;
    protected /* synthetic */ String field_175335_g;
    private /* synthetic */ Random field_175337_G;
    private /* synthetic */ GuiButton field_175350_z;
    private /* synthetic */ GuiCreateWorld field_175343_i;
    protected /* synthetic */ String[] field_175342_h;
    private /* synthetic */ boolean field_175338_A;
    private /* synthetic */ GuiButton field_175348_s;
    private /* synthetic */ GuiButton field_175346_u;
    private /* synthetic */ GuiButton field_175352_x;
    private /* synthetic */ GuiButton field_175347_t;
    private /* synthetic */ GuiButton field_175351_y;
    private /* synthetic */ Predicate field_175332_D;
    private /* synthetic */ ChunkProviderSettings.Factory field_175334_E;
    private /* synthetic */ ChunkProviderSettings.Factory field_175336_F;
    private /* synthetic */ int field_175339_B;
    protected /* synthetic */ String field_175341_a;
    private /* synthetic */ GuiPageButtonList field_175349_r;
    private /* synthetic */ boolean field_175340_C;
    protected /* synthetic */ String field_175333_f;
    private /* synthetic */ GuiButton field_175345_v;
    
    public void func_175324_a(final String llllllllIIlI) {
        if (llllllllIIlI != null && llllllllIIlI.length() != 0) {
            this.field_175336_F = ChunkProviderSettings.Factory.func_177865_a(llllllllIIlI);
        }
        else {
            this.field_175336_F = new ChunkProviderSettings.Factory();
        }
    }
    
    private void func_175329_a(final boolean lllllIIIlIIl) {
        this.field_175352_x.visible = lllllIIIlIIl;
        this.field_175351_y.visible = lllllIIIlIIl;
        this.field_175347_t.enabled = !lllllIIIlIIl;
        this.field_175348_s.enabled = !lllllIIIlIIl;
        this.field_175345_v.enabled = !lllllIIIlIIl;
        this.field_175344_w.enabled = !lllllIIIlIIl;
        this.field_175346_u.enabled = !lllllIIIlIIl;
        this.field_175350_z.enabled = !lllllIIIlIIl;
    }
    
    @Override
    public String func_175318_a(final int llllllIlIlll, final String llllllIlIllI, final float llllllIllIIl) {
        return String.valueOf(new StringBuilder(String.valueOf(llllllIlIllI)).append(": ").append(this.func_175330_b(llllllIlIlll, llllllIllIIl)));
    }
    
    private void func_175325_f() {
        final GuiPageButtonList.GuiListEntry[] lIIIIIIIIIIll = { new GuiPageButtonList.GuiSlideEntry(160, I18n.format("createWorld.customize.custom.seaLevel", new Object[0]), true, this, 1.0f, 255.0f, (float)this.field_175336_F.field_177929_r), new GuiPageButtonList.GuiButtonEntry(148, I18n.format("createWorld.customize.custom.useCaves", new Object[0]), true, this.field_175336_F.field_177927_s), new GuiPageButtonList.GuiButtonEntry(150, I18n.format("createWorld.customize.custom.useStrongholds", new Object[0]), true, this.field_175336_F.field_177921_v), new GuiPageButtonList.GuiButtonEntry(151, I18n.format("createWorld.customize.custom.useVillages", new Object[0]), true, this.field_175336_F.field_177919_w), new GuiPageButtonList.GuiButtonEntry(152, I18n.format("createWorld.customize.custom.useMineShafts", new Object[0]), true, this.field_175336_F.field_177944_x), new GuiPageButtonList.GuiButtonEntry(153, I18n.format("createWorld.customize.custom.useTemples", new Object[0]), true, this.field_175336_F.field_177942_y), new GuiPageButtonList.GuiButtonEntry(210, I18n.format("createWorld.customize.custom.useMonuments", new Object[0]), true, this.field_175336_F.field_177940_z), new GuiPageButtonList.GuiButtonEntry(154, I18n.format("createWorld.customize.custom.useRavines", new Object[0]), true, this.field_175336_F.field_177870_A), new GuiPageButtonList.GuiButtonEntry(149, I18n.format("createWorld.customize.custom.useDungeons", new Object[0]), true, this.field_175336_F.field_177925_t), new GuiPageButtonList.GuiSlideEntry(157, I18n.format("createWorld.customize.custom.dungeonChance", new Object[0]), true, this, 1.0f, 100.0f, (float)this.field_175336_F.field_177923_u), new GuiPageButtonList.GuiButtonEntry(155, I18n.format("createWorld.customize.custom.useWaterLakes", new Object[0]), true, this.field_175336_F.field_177871_B), new GuiPageButtonList.GuiSlideEntry(158, I18n.format("createWorld.customize.custom.waterLakeChance", new Object[0]), true, this, 1.0f, 100.0f, (float)this.field_175336_F.field_177872_C), new GuiPageButtonList.GuiButtonEntry(156, I18n.format("createWorld.customize.custom.useLavaLakes", new Object[0]), true, this.field_175336_F.field_177866_D), new GuiPageButtonList.GuiSlideEntry(159, I18n.format("createWorld.customize.custom.lavaLakeChance", new Object[0]), true, this, 10.0f, 100.0f, (float)this.field_175336_F.field_177867_E), new GuiPageButtonList.GuiButtonEntry(161, I18n.format("createWorld.customize.custom.useLavaOceans", new Object[0]), true, this.field_175336_F.field_177868_F), new GuiPageButtonList.GuiSlideEntry(162, I18n.format("createWorld.customize.custom.fixedBiome", new Object[0]), true, this, -1.0f, 37.0f, (float)this.field_175336_F.field_177869_G), new GuiPageButtonList.GuiSlideEntry(163, I18n.format("createWorld.customize.custom.biomeSize", new Object[0]), true, this, 1.0f, 8.0f, (float)this.field_175336_F.field_177877_H), new GuiPageButtonList.GuiSlideEntry(164, I18n.format("createWorld.customize.custom.riverSize", new Object[0]), true, this, 1.0f, 5.0f, (float)this.field_175336_F.field_177878_I) };
        final GuiPageButtonList.GuiListEntry[] lIIIIIIIIIIlI = { new GuiPageButtonList.GuiLabelEntry(416, I18n.format("tile.dirt.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(165, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177879_J), new GuiPageButtonList.GuiSlideEntry(166, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177880_K), new GuiPageButtonList.GuiSlideEntry(167, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177873_L), new GuiPageButtonList.GuiSlideEntry(168, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177874_M), new GuiPageButtonList.GuiLabelEntry(417, I18n.format("tile.gravel.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(169, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177875_N), new GuiPageButtonList.GuiSlideEntry(170, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177876_O), new GuiPageButtonList.GuiSlideEntry(171, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177886_P), new GuiPageButtonList.GuiSlideEntry(172, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177885_Q), new GuiPageButtonList.GuiLabelEntry(418, I18n.format("tile.stone.granite.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(173, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177888_R), new GuiPageButtonList.GuiSlideEntry(174, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177887_S), new GuiPageButtonList.GuiSlideEntry(175, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177882_T), new GuiPageButtonList.GuiSlideEntry(176, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177881_U), new GuiPageButtonList.GuiLabelEntry(419, I18n.format("tile.stone.diorite.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(177, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177884_V), new GuiPageButtonList.GuiSlideEntry(178, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177883_W), new GuiPageButtonList.GuiSlideEntry(179, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177891_X), new GuiPageButtonList.GuiSlideEntry(180, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177890_Y), new GuiPageButtonList.GuiLabelEntry(420, I18n.format("tile.stone.andesite.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(181, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177892_Z), new GuiPageButtonList.GuiSlideEntry(182, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177936_aa), new GuiPageButtonList.GuiSlideEntry(183, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177937_ab), new GuiPageButtonList.GuiSlideEntry(184, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177934_ac), new GuiPageButtonList.GuiLabelEntry(421, I18n.format("tile.oreCoal.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(185, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177935_ad), new GuiPageButtonList.GuiSlideEntry(186, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177941_ae), new GuiPageButtonList.GuiSlideEntry(187, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177943_af), new GuiPageButtonList.GuiSlideEntry(189, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177938_ag), new GuiPageButtonList.GuiLabelEntry(422, I18n.format("tile.oreIron.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(190, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177939_ah), new GuiPageButtonList.GuiSlideEntry(191, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177922_ai), new GuiPageButtonList.GuiSlideEntry(192, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177924_aj), new GuiPageButtonList.GuiSlideEntry(193, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177918_ak), new GuiPageButtonList.GuiLabelEntry(423, I18n.format("tile.oreGold.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(194, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177920_al), new GuiPageButtonList.GuiSlideEntry(195, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177930_am), new GuiPageButtonList.GuiSlideEntry(196, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177932_an), new GuiPageButtonList.GuiSlideEntry(197, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177926_ao), new GuiPageButtonList.GuiLabelEntry(424, I18n.format("tile.oreRedstone.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(198, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177928_ap), new GuiPageButtonList.GuiSlideEntry(199, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177908_aq), new GuiPageButtonList.GuiSlideEntry(200, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177906_ar), new GuiPageButtonList.GuiSlideEntry(201, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177904_as), new GuiPageButtonList.GuiLabelEntry(425, I18n.format("tile.oreDiamond.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(202, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177902_at), new GuiPageButtonList.GuiSlideEntry(203, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177916_au), new GuiPageButtonList.GuiSlideEntry(204, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177914_av), new GuiPageButtonList.GuiSlideEntry(205, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177912_aw), new GuiPageButtonList.GuiLabelEntry(426, I18n.format("tile.oreLapis.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(206, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.field_175336_F.field_177910_ax), new GuiPageButtonList.GuiSlideEntry(207, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.field_175336_F.field_177897_ay), new GuiPageButtonList.GuiSlideEntry(208, I18n.format("createWorld.customize.custom.center", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177895_az), new GuiPageButtonList.GuiSlideEntry(209, I18n.format("createWorld.customize.custom.spread", new Object[0]), false, this, 0.0f, 255.0f, (float)this.field_175336_F.field_177889_aA) };
        final GuiPageButtonList.GuiListEntry[] lIIIIIIIIIIIl = { new GuiPageButtonList.GuiSlideEntry(100, I18n.format("createWorld.customize.custom.mainNoiseScaleX", new Object[0]), false, this, 1.0f, 5000.0f, this.field_175336_F.field_177917_i), new GuiPageButtonList.GuiSlideEntry(101, I18n.format("createWorld.customize.custom.mainNoiseScaleY", new Object[0]), false, this, 1.0f, 5000.0f, this.field_175336_F.field_177911_j), new GuiPageButtonList.GuiSlideEntry(102, I18n.format("createWorld.customize.custom.mainNoiseScaleZ", new Object[0]), false, this, 1.0f, 5000.0f, this.field_175336_F.field_177913_k), new GuiPageButtonList.GuiSlideEntry(103, I18n.format("createWorld.customize.custom.depthNoiseScaleX", new Object[0]), false, this, 1.0f, 2000.0f, this.field_175336_F.field_177893_f), new GuiPageButtonList.GuiSlideEntry(104, I18n.format("createWorld.customize.custom.depthNoiseScaleZ", new Object[0]), false, this, 1.0f, 2000.0f, this.field_175336_F.field_177894_g), new GuiPageButtonList.GuiSlideEntry(105, I18n.format("createWorld.customize.custom.depthNoiseScaleExponent", new Object[0]), false, this, 0.01f, 20.0f, this.field_175336_F.field_177915_h), new GuiPageButtonList.GuiSlideEntry(106, I18n.format("createWorld.customize.custom.baseSize", new Object[0]), false, this, 1.0f, 25.0f, this.field_175336_F.field_177907_l), new GuiPageButtonList.GuiSlideEntry(107, I18n.format("createWorld.customize.custom.coordinateScale", new Object[0]), false, this, 1.0f, 6000.0f, this.field_175336_F.field_177899_b), new GuiPageButtonList.GuiSlideEntry(108, I18n.format("createWorld.customize.custom.heightScale", new Object[0]), false, this, 1.0f, 6000.0f, this.field_175336_F.field_177900_c), new GuiPageButtonList.GuiSlideEntry(109, I18n.format("createWorld.customize.custom.stretchY", new Object[0]), false, this, 0.01f, 50.0f, this.field_175336_F.field_177909_m), new GuiPageButtonList.GuiSlideEntry(110, I18n.format("createWorld.customize.custom.upperLimitScale", new Object[0]), false, this, 1.0f, 5000.0f, this.field_175336_F.field_177896_d), new GuiPageButtonList.GuiSlideEntry(111, I18n.format("createWorld.customize.custom.lowerLimitScale", new Object[0]), false, this, 1.0f, 5000.0f, this.field_175336_F.field_177898_e), new GuiPageButtonList.GuiSlideEntry(112, I18n.format("createWorld.customize.custom.biomeDepthWeight", new Object[0]), false, this, 1.0f, 20.0f, this.field_175336_F.field_177903_n), new GuiPageButtonList.GuiSlideEntry(113, I18n.format("createWorld.customize.custom.biomeDepthOffset", new Object[0]), false, this, 0.0f, 20.0f, this.field_175336_F.field_177905_o), new GuiPageButtonList.GuiSlideEntry(114, I18n.format("createWorld.customize.custom.biomeScaleWeight", new Object[0]), false, this, 1.0f, 20.0f, this.field_175336_F.field_177933_p), new GuiPageButtonList.GuiSlideEntry(115, I18n.format("createWorld.customize.custom.biomeScaleOffset", new Object[0]), false, this, 0.0f, 20.0f, this.field_175336_F.field_177931_q) };
        final GuiPageButtonList.GuiListEntry[] lIIIIIIIIIIII = { new GuiPageButtonList.GuiLabelEntry(400, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.mainNoiseScaleX", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(132, String.format("%5.3f", this.field_175336_F.field_177917_i), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(401, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.mainNoiseScaleY", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(133, String.format("%5.3f", this.field_175336_F.field_177911_j), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(402, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.mainNoiseScaleZ", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(134, String.format("%5.3f", this.field_175336_F.field_177913_k), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(403, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.depthNoiseScaleX", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(135, String.format("%5.3f", this.field_175336_F.field_177893_f), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(404, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.depthNoiseScaleZ", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(136, String.format("%5.3f", this.field_175336_F.field_177894_g), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(405, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.depthNoiseScaleExponent", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(137, String.format("%2.3f", this.field_175336_F.field_177915_h), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(406, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.baseSize", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(138, String.format("%2.3f", this.field_175336_F.field_177907_l), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(407, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.coordinateScale", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(139, String.format("%5.3f", this.field_175336_F.field_177899_b), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(408, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.heightScale", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(140, String.format("%5.3f", this.field_175336_F.field_177900_c), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(409, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.stretchY", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(141, String.format("%2.3f", this.field_175336_F.field_177909_m), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(410, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.upperLimitScale", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(142, String.format("%5.3f", this.field_175336_F.field_177896_d), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(411, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.lowerLimitScale", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(143, String.format("%5.3f", this.field_175336_F.field_177898_e), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(412, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.biomeDepthWeight", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(144, String.format("%2.3f", this.field_175336_F.field_177903_n), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(413, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.biomeDepthOffset", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(145, String.format("%2.3f", this.field_175336_F.field_177905_o), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(414, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.biomeScaleWeight", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(146, String.format("%2.3f", this.field_175336_F.field_177933_p), false, this.field_175332_D), new GuiPageButtonList.GuiLabelEntry(415, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.biomeScaleOffset", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(147, String.format("%2.3f", this.field_175336_F.field_177931_q), false, this.field_175332_D) };
        this.field_175349_r = new GuiPageButtonList(this.mc, this.width, this.height, 32, this.height - 32, 25, this, new GuiPageButtonList.GuiListEntry[][] { lIIIIIIIIIIll, lIIIIIIIIIIlI, lIIIIIIIIIIIl, lIIIIIIIIIIII });
        for (int llllllllllll = 0; llllllllllll < 4; ++llllllllllll) {
            this.field_175342_h[llllllllllll] = I18n.format(String.valueOf(new StringBuilder("createWorld.customize.custom.page").append(llllllllllll)), new Object[0]);
        }
        this.func_175328_i();
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.field_175349_r.func_178039_p();
    }
    
    @Override
    protected void mouseReleased(final int llllIlIlIIll, final int llllIlIlIIlI, final int llllIlIIllIl) {
        super.mouseReleased(llllIlIlIIll, llllIlIlIIlI, llllIlIIllIl);
        if (this.field_175340_C) {
            this.field_175340_C = false;
        }
        else if (this.field_175339_B == 0) {
            this.field_175349_r.func_148181_b(llllIlIlIIll, llllIlIlIIlI, llllIlIIllIl);
        }
    }
    
    @Override
    public void initGui() {
        this.field_175341_a = I18n.format("options.customizeTitle", new Object[0]);
        this.buttonList.clear();
        final List buttonList = this.buttonList;
        final GuiButton field_175345_v = new GuiButton(302, 20, 5, 80, 20, I18n.format("createWorld.customize.custom.prev", new Object[0]));
        this.field_175345_v = field_175345_v;
        buttonList.add(field_175345_v);
        final List buttonList2 = this.buttonList;
        final GuiButton field_175344_w = new GuiButton(303, this.width - 100, 5, 80, 20, I18n.format("createWorld.customize.custom.next", new Object[0]));
        this.field_175344_w = field_175344_w;
        buttonList2.add(field_175344_w);
        final List buttonList3 = this.buttonList;
        final GuiButton field_175346_u = new GuiButton(304, this.width / 2 - 187, this.height - 27, 90, 20, I18n.format("createWorld.customize.custom.defaults", new Object[0]));
        this.field_175346_u = field_175346_u;
        buttonList3.add(field_175346_u);
        final List buttonList4 = this.buttonList;
        final GuiButton field_175347_t = new GuiButton(301, this.width / 2 - 92, this.height - 27, 90, 20, I18n.format("createWorld.customize.custom.randomize", new Object[0]));
        this.field_175347_t = field_175347_t;
        buttonList4.add(field_175347_t);
        final List buttonList5 = this.buttonList;
        final GuiButton field_175350_z = new GuiButton(305, this.width / 2 + 3, this.height - 27, 90, 20, I18n.format("createWorld.customize.custom.presets", new Object[0]));
        this.field_175350_z = field_175350_z;
        buttonList5.add(field_175350_z);
        final List buttonList6 = this.buttonList;
        final GuiButton field_175348_s = new GuiButton(300, this.width / 2 + 98, this.height - 27, 90, 20, I18n.format("gui.done", new Object[0]));
        this.field_175348_s = field_175348_s;
        buttonList6.add(field_175348_s);
        this.field_175352_x = new GuiButton(306, this.width / 2 - 55, 160, 50, 20, I18n.format("gui.yes", new Object[0]));
        this.field_175352_x.visible = false;
        this.buttonList.add(this.field_175352_x);
        this.field_175351_y = new GuiButton(307, this.width / 2 + 5, 160, 50, 20, I18n.format("gui.no", new Object[0]));
        this.field_175351_y.visible = false;
        this.buttonList.add(this.field_175351_y);
        this.func_175325_f();
    }
    
    @Override
    public void drawScreen(final int llllIIlllIIl, final int llllIlIIIIIl, final float llllIlIIIIII) {
        this.drawDefaultBackground();
        this.field_175349_r.drawScreen(llllIIlllIIl, llllIlIIIIIl, llllIlIIIIII);
        this.drawCenteredString(this.fontRendererObj, this.field_175341_a, this.width / 2, 2, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.field_175333_f, this.width / 2, 12, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.field_175335_g, this.width / 2, 22, 16777215);
        super.drawScreen(llllIIlllIIl, llllIlIIIIIl, llllIlIIIIII);
        if (this.field_175339_B != 0) {
            Gui.drawRect(0.0, 0.0, this.width, this.height, Integer.MIN_VALUE);
            this.drawHorizontalLine(this.width / 2 - 91, this.width / 2 + 90, 99, -2039584);
            this.drawHorizontalLine(this.width / 2 - 91, this.width / 2 + 90, 185, -6250336);
            this.drawVerticalLine(this.width / 2 - 91, 99, 185, -2039584);
            this.drawVerticalLine(this.width / 2 + 90, 99, 185, -6250336);
            final float llllIIllllll = 85.0f;
            final float llllIIlllllI = 180.0f;
            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            final Tessellator llllIIllllIl = Tessellator.getInstance();
            final WorldRenderer llllIIllllII = llllIIllllIl.getWorldRenderer();
            this.mc.getTextureManager().bindTexture(GuiCustomizeWorldScreen.optionsBackground);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final float llllIIlllIll = 32.0f;
            llllIIllllII.startDrawingQuads();
            llllIIllllII.func_178991_c(4210752);
            llllIIllllII.addVertexWithUV(this.width / 2 - 90, 185.0, 0.0, 0.0, 2.65625);
            llllIIllllII.addVertexWithUV(this.width / 2 + 90, 185.0, 0.0, 5.625, 2.65625);
            llllIIllllII.addVertexWithUV(this.width / 2 + 90, 100.0, 0.0, 5.625, 0.0);
            llllIIllllII.addVertexWithUV(this.width / 2 - 90, 100.0, 0.0, 0.0, 0.0);
            llllIIllllIl.draw();
            this.drawCenteredString(this.fontRendererObj, I18n.format("createWorld.customize.custom.confirmTitle", new Object[0]), this.width / 2, 105, 16777215);
            this.drawCenteredString(this.fontRendererObj, I18n.format("createWorld.customize.custom.confirm1", new Object[0]), this.width / 2, 125, 16777215);
            this.drawCenteredString(this.fontRendererObj, I18n.format("createWorld.customize.custom.confirm2", new Object[0]), this.width / 2, 135, 16777215);
            this.field_175352_x.drawButton(this.mc, llllIIlllIIl, llllIlIIIIIl);
            this.field_175351_y.drawButton(this.mc, llllIIlllIIl, llllIlIIIIIl);
        }
    }
    
    @Override
    protected void keyTyped(final char lllllIIIIIIl, final int llllIlllllIl) throws IOException {
        super.keyTyped(lllllIIIIIIl, llllIlllllIl);
        if (this.field_175339_B == 0) {
            switch (llllIlllllIl) {
                case 200: {
                    this.func_175327_a(1.0f);
                    break;
                }
                case 208: {
                    this.func_175327_a(-1.0f);
                    break;
                }
                default: {
                    this.field_175349_r.func_178062_a(lllllIIIIIIl, llllIlllllIl);
                    break;
                }
            }
        }
    }
    
    @Override
    public void func_175320_a(final int lllllIlllIll, final float lllllIlllIlI) {
        switch (lllllIlllIll) {
            case 100: {
                this.field_175336_F.field_177917_i = lllllIlllIlI;
                break;
            }
            case 101: {
                this.field_175336_F.field_177911_j = lllllIlllIlI;
                break;
            }
            case 102: {
                this.field_175336_F.field_177913_k = lllllIlllIlI;
                break;
            }
            case 103: {
                this.field_175336_F.field_177893_f = lllllIlllIlI;
                break;
            }
            case 104: {
                this.field_175336_F.field_177894_g = lllllIlllIlI;
                break;
            }
            case 105: {
                this.field_175336_F.field_177915_h = lllllIlllIlI;
                break;
            }
            case 106: {
                this.field_175336_F.field_177907_l = lllllIlllIlI;
                break;
            }
            case 107: {
                this.field_175336_F.field_177899_b = lllllIlllIlI;
                break;
            }
            case 108: {
                this.field_175336_F.field_177900_c = lllllIlllIlI;
                break;
            }
            case 109: {
                this.field_175336_F.field_177909_m = lllllIlllIlI;
                break;
            }
            case 110: {
                this.field_175336_F.field_177896_d = lllllIlllIlI;
                break;
            }
            case 111: {
                this.field_175336_F.field_177898_e = lllllIlllIlI;
                break;
            }
            case 112: {
                this.field_175336_F.field_177903_n = lllllIlllIlI;
                break;
            }
            case 113: {
                this.field_175336_F.field_177905_o = lllllIlllIlI;
                break;
            }
            case 114: {
                this.field_175336_F.field_177933_p = lllllIlllIlI;
                break;
            }
            case 115: {
                this.field_175336_F.field_177931_q = lllllIlllIlI;
                break;
            }
            case 157: {
                this.field_175336_F.field_177923_u = (int)lllllIlllIlI;
                break;
            }
            case 158: {
                this.field_175336_F.field_177872_C = (int)lllllIlllIlI;
                break;
            }
            case 159: {
                this.field_175336_F.field_177867_E = (int)lllllIlllIlI;
                break;
            }
            case 160: {
                this.field_175336_F.field_177929_r = (int)lllllIlllIlI;
                break;
            }
            case 162: {
                this.field_175336_F.field_177869_G = (int)lllllIlllIlI;
                break;
            }
            case 163: {
                this.field_175336_F.field_177877_H = (int)lllllIlllIlI;
                break;
            }
            case 164: {
                this.field_175336_F.field_177878_I = (int)lllllIlllIlI;
                break;
            }
            case 165: {
                this.field_175336_F.field_177879_J = (int)lllllIlllIlI;
                break;
            }
            case 166: {
                this.field_175336_F.field_177880_K = (int)lllllIlllIlI;
                break;
            }
            case 167: {
                this.field_175336_F.field_177873_L = (int)lllllIlllIlI;
                break;
            }
            case 168: {
                this.field_175336_F.field_177874_M = (int)lllllIlllIlI;
                break;
            }
            case 169: {
                this.field_175336_F.field_177875_N = (int)lllllIlllIlI;
                break;
            }
            case 170: {
                this.field_175336_F.field_177876_O = (int)lllllIlllIlI;
                break;
            }
            case 171: {
                this.field_175336_F.field_177886_P = (int)lllllIlllIlI;
                break;
            }
            case 172: {
                this.field_175336_F.field_177885_Q = (int)lllllIlllIlI;
                break;
            }
            case 173: {
                this.field_175336_F.field_177888_R = (int)lllllIlllIlI;
                break;
            }
            case 174: {
                this.field_175336_F.field_177887_S = (int)lllllIlllIlI;
                break;
            }
            case 175: {
                this.field_175336_F.field_177882_T = (int)lllllIlllIlI;
                break;
            }
            case 176: {
                this.field_175336_F.field_177881_U = (int)lllllIlllIlI;
                break;
            }
            case 177: {
                this.field_175336_F.field_177884_V = (int)lllllIlllIlI;
                break;
            }
            case 178: {
                this.field_175336_F.field_177883_W = (int)lllllIlllIlI;
                break;
            }
            case 179: {
                this.field_175336_F.field_177891_X = (int)lllllIlllIlI;
                break;
            }
            case 180: {
                this.field_175336_F.field_177890_Y = (int)lllllIlllIlI;
                break;
            }
            case 181: {
                this.field_175336_F.field_177892_Z = (int)lllllIlllIlI;
                break;
            }
            case 182: {
                this.field_175336_F.field_177936_aa = (int)lllllIlllIlI;
                break;
            }
            case 183: {
                this.field_175336_F.field_177937_ab = (int)lllllIlllIlI;
                break;
            }
            case 184: {
                this.field_175336_F.field_177934_ac = (int)lllllIlllIlI;
                break;
            }
            case 185: {
                this.field_175336_F.field_177935_ad = (int)lllllIlllIlI;
                break;
            }
            case 186: {
                this.field_175336_F.field_177941_ae = (int)lllllIlllIlI;
                break;
            }
            case 187: {
                this.field_175336_F.field_177943_af = (int)lllllIlllIlI;
                break;
            }
            case 189: {
                this.field_175336_F.field_177938_ag = (int)lllllIlllIlI;
                break;
            }
            case 190: {
                this.field_175336_F.field_177939_ah = (int)lllllIlllIlI;
                break;
            }
            case 191: {
                this.field_175336_F.field_177922_ai = (int)lllllIlllIlI;
                break;
            }
            case 192: {
                this.field_175336_F.field_177924_aj = (int)lllllIlllIlI;
                break;
            }
            case 193: {
                this.field_175336_F.field_177918_ak = (int)lllllIlllIlI;
                break;
            }
            case 194: {
                this.field_175336_F.field_177920_al = (int)lllllIlllIlI;
                break;
            }
            case 195: {
                this.field_175336_F.field_177930_am = (int)lllllIlllIlI;
                break;
            }
            case 196: {
                this.field_175336_F.field_177932_an = (int)lllllIlllIlI;
                break;
            }
            case 197: {
                this.field_175336_F.field_177926_ao = (int)lllllIlllIlI;
                break;
            }
            case 198: {
                this.field_175336_F.field_177928_ap = (int)lllllIlllIlI;
                break;
            }
            case 199: {
                this.field_175336_F.field_177908_aq = (int)lllllIlllIlI;
                break;
            }
            case 200: {
                this.field_175336_F.field_177906_ar = (int)lllllIlllIlI;
                break;
            }
            case 201: {
                this.field_175336_F.field_177904_as = (int)lllllIlllIlI;
                break;
            }
            case 202: {
                this.field_175336_F.field_177902_at = (int)lllllIlllIlI;
                break;
            }
            case 203: {
                this.field_175336_F.field_177916_au = (int)lllllIlllIlI;
                break;
            }
            case 204: {
                this.field_175336_F.field_177914_av = (int)lllllIlllIlI;
                break;
            }
            case 205: {
                this.field_175336_F.field_177912_aw = (int)lllllIlllIlI;
                break;
            }
            case 206: {
                this.field_175336_F.field_177910_ax = (int)lllllIlllIlI;
                break;
            }
            case 207: {
                this.field_175336_F.field_177897_ay = (int)lllllIlllIlI;
                break;
            }
            case 208: {
                this.field_175336_F.field_177895_az = (int)lllllIlllIlI;
                break;
            }
            case 209: {
                this.field_175336_F.field_177889_aA = (int)lllllIlllIlI;
                break;
            }
        }
        if (lllllIlllIll >= 100 && lllllIlllIll < 116) {
            final Gui lllllIlllIIl = this.field_175349_r.func_178061_c(lllllIlllIll - 100 + 132);
            if (lllllIlllIIl != null) {
                ((GuiTextField)lllllIlllIIl).setText(this.func_175330_b(lllllIlllIll, lllllIlllIlI));
            }
        }
        if (!this.field_175336_F.equals(this.field_175334_E)) {
            this.field_175338_A = true;
        }
    }
    
    private String func_175330_b(final int llllllIIllII, final float llllllIIlIll) {
        switch (llllllIIllII) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 107:
            case 108:
            case 110:
            case 111:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 139:
            case 140:
            case 142:
            case 143: {
                return String.format("%5.3f", llllllIIlIll);
            }
            case 105:
            case 106:
            case 109:
            case 112:
            case 113:
            case 114:
            case 115:
            case 137:
            case 138:
            case 141:
            case 144:
            case 145:
            case 146:
            case 147: {
                return String.format("%2.3f", llllllIIlIll);
            }
            default: {
                return String.format("%d", (int)llllllIIlIll);
            }
            case 162: {
                if (llllllIIlIll < 0.0f) {
                    return I18n.format("gui.all", new Object[0]);
                }
                if ((int)llllllIIlIll >= BiomeGenBase.hell.biomeID) {
                    final BiomeGenBase llllllIIlllI = BiomeGenBase.getBiomeGenArray()[(int)llllllIIlIll + 2];
                    return (llllllIIlllI != null) ? llllllIIlllI.biomeName : "?";
                }
                final BiomeGenBase llllllIIllIl = BiomeGenBase.getBiomeGenArray()[(int)llllllIIlIll];
                return (llllllIIllIl != null) ? llllllIIllIl.biomeName : "?";
            }
        }
    }
    
    private void func_175322_b(final int lllllIIlIlII) {
        this.field_175339_B = lllllIIlIlII;
        this.func_175329_a(true);
    }
    
    @Override
    public void func_175319_a(final int lllllllIIlII, final String lllllllIlIII) {
        float lllllllIIlll = 0.0f;
        try {
            lllllllIIlll = Float.parseFloat(lllllllIlIII);
        }
        catch (NumberFormatException ex) {}
        float lllllllIIllI = 0.0f;
        switch (lllllllIIlII) {
            case 132: {
                final ChunkProviderSettings.Factory field_175336_F = this.field_175336_F;
                final float clamp_float = MathHelper.clamp_float(lllllllIIlll, 1.0f, 5000.0f);
                field_175336_F.field_177917_i = clamp_float;
                lllllllIIllI = clamp_float;
                break;
            }
            case 133: {
                final ChunkProviderSettings.Factory field_175336_F2 = this.field_175336_F;
                final float clamp_float2 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 5000.0f);
                field_175336_F2.field_177911_j = clamp_float2;
                lllllllIIllI = clamp_float2;
                break;
            }
            case 134: {
                final ChunkProviderSettings.Factory field_175336_F3 = this.field_175336_F;
                final float clamp_float3 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 5000.0f);
                field_175336_F3.field_177913_k = clamp_float3;
                lllllllIIllI = clamp_float3;
                break;
            }
            case 135: {
                final ChunkProviderSettings.Factory field_175336_F4 = this.field_175336_F;
                final float clamp_float4 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 2000.0f);
                field_175336_F4.field_177893_f = clamp_float4;
                lllllllIIllI = clamp_float4;
                break;
            }
            case 136: {
                final ChunkProviderSettings.Factory field_175336_F5 = this.field_175336_F;
                final float clamp_float5 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 2000.0f);
                field_175336_F5.field_177894_g = clamp_float5;
                lllllllIIllI = clamp_float5;
                break;
            }
            case 137: {
                final ChunkProviderSettings.Factory field_175336_F6 = this.field_175336_F;
                final float clamp_float6 = MathHelper.clamp_float(lllllllIIlll, 0.01f, 20.0f);
                field_175336_F6.field_177915_h = clamp_float6;
                lllllllIIllI = clamp_float6;
                break;
            }
            case 138: {
                final ChunkProviderSettings.Factory field_175336_F7 = this.field_175336_F;
                final float clamp_float7 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 25.0f);
                field_175336_F7.field_177907_l = clamp_float7;
                lllllllIIllI = clamp_float7;
                break;
            }
            case 139: {
                final ChunkProviderSettings.Factory field_175336_F8 = this.field_175336_F;
                final float clamp_float8 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 6000.0f);
                field_175336_F8.field_177899_b = clamp_float8;
                lllllllIIllI = clamp_float8;
                break;
            }
            case 140: {
                final ChunkProviderSettings.Factory field_175336_F9 = this.field_175336_F;
                final float clamp_float9 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 6000.0f);
                field_175336_F9.field_177900_c = clamp_float9;
                lllllllIIllI = clamp_float9;
                break;
            }
            case 141: {
                final ChunkProviderSettings.Factory field_175336_F10 = this.field_175336_F;
                final float clamp_float10 = MathHelper.clamp_float(lllllllIIlll, 0.01f, 50.0f);
                field_175336_F10.field_177909_m = clamp_float10;
                lllllllIIllI = clamp_float10;
                break;
            }
            case 142: {
                final ChunkProviderSettings.Factory field_175336_F11 = this.field_175336_F;
                final float clamp_float11 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 5000.0f);
                field_175336_F11.field_177896_d = clamp_float11;
                lllllllIIllI = clamp_float11;
                break;
            }
            case 143: {
                final ChunkProviderSettings.Factory field_175336_F12 = this.field_175336_F;
                final float clamp_float12 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 5000.0f);
                field_175336_F12.field_177898_e = clamp_float12;
                lllllllIIllI = clamp_float12;
                break;
            }
            case 144: {
                final ChunkProviderSettings.Factory field_175336_F13 = this.field_175336_F;
                final float clamp_float13 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 20.0f);
                field_175336_F13.field_177903_n = clamp_float13;
                lllllllIIllI = clamp_float13;
                break;
            }
            case 145: {
                final ChunkProviderSettings.Factory field_175336_F14 = this.field_175336_F;
                final float clamp_float14 = MathHelper.clamp_float(lllllllIIlll, 0.0f, 20.0f);
                field_175336_F14.field_177905_o = clamp_float14;
                lllllllIIllI = clamp_float14;
                break;
            }
            case 146: {
                final ChunkProviderSettings.Factory field_175336_F15 = this.field_175336_F;
                final float clamp_float15 = MathHelper.clamp_float(lllllllIIlll, 1.0f, 20.0f);
                field_175336_F15.field_177933_p = clamp_float15;
                lllllllIIllI = clamp_float15;
                break;
            }
            case 147: {
                final ChunkProviderSettings.Factory field_175336_F16 = this.field_175336_F;
                final float clamp_float16 = MathHelper.clamp_float(lllllllIIlll, 0.0f, 20.0f);
                field_175336_F16.field_177931_q = clamp_float16;
                lllllllIIllI = clamp_float16;
                break;
            }
        }
        if (lllllllIIllI != lllllllIIlll && lllllllIIlll != 0.0f) {
            ((GuiTextField)this.field_175349_r.func_178061_c(lllllllIIlII)).setText(this.func_175330_b(lllllllIIlII, lllllllIIllI));
        }
        ((GuiSlider)this.field_175349_r.func_178061_c(lllllllIIlII - 132 + 100)).func_175218_a(lllllllIIllI, false);
        if (!this.field_175336_F.equals(this.field_175334_E)) {
            this.field_175338_A = true;
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllIlIIIIl) throws IOException {
        if (lllllIlIIIIl.enabled) {
            switch (lllllIlIIIIl.id) {
                case 300: {
                    this.field_175343_i.field_146334_a = this.field_175336_F.toString();
                    this.mc.displayGuiScreen(this.field_175343_i);
                    break;
                }
                case 301: {
                    for (int lllllIlIlIlI = 0; lllllIlIlIlI < this.field_175349_r.getSize(); ++lllllIlIlIlI) {
                        final GuiPageButtonList.GuiEntry lllllIlIlIIl = this.field_175349_r.func_178070_d(lllllIlIlIlI);
                        final Gui lllllIlIlIII = lllllIlIlIIl.func_178022_a();
                        if (lllllIlIlIII instanceof GuiButton) {
                            final GuiButton lllllIlIIlll = (GuiButton)lllllIlIlIII;
                            if (lllllIlIIlll instanceof GuiSlider) {
                                final float lllllIlIIllI = ((GuiSlider)lllllIlIIlll).func_175217_d() * (0.75f + this.field_175337_G.nextFloat() * 0.5f) + (this.field_175337_G.nextFloat() * 0.1f - 0.05f);
                                ((GuiSlider)lllllIlIIlll).func_175219_a(MathHelper.clamp_float(lllllIlIIllI, 0.0f, 1.0f));
                            }
                            else if (lllllIlIIlll instanceof GuiListButton) {
                                ((GuiListButton)lllllIlIIlll).func_175212_b(this.field_175337_G.nextBoolean());
                            }
                        }
                        final Gui lllllIlIIlIl = lllllIlIlIIl.func_178021_b();
                        if (lllllIlIIlIl instanceof GuiButton) {
                            final GuiButton lllllIlIIlII = (GuiButton)lllllIlIIlIl;
                            if (lllllIlIIlII instanceof GuiSlider) {
                                final float lllllIlIIIll = ((GuiSlider)lllllIlIIlII).func_175217_d() * (0.75f + this.field_175337_G.nextFloat() * 0.5f) + (this.field_175337_G.nextFloat() * 0.1f - 0.05f);
                                ((GuiSlider)lllllIlIIlII).func_175219_a(MathHelper.clamp_float(lllllIlIIIll, 0.0f, 1.0f));
                            }
                            else if (lllllIlIIlII instanceof GuiListButton) {
                                ((GuiListButton)lllllIlIIlII).func_175212_b(this.field_175337_G.nextBoolean());
                            }
                        }
                    }
                }
                case 302: {
                    this.field_175349_r.func_178071_h();
                    this.func_175328_i();
                    break;
                }
                case 303: {
                    this.field_175349_r.func_178064_i();
                    this.func_175328_i();
                    break;
                }
                case 304: {
                    if (this.field_175338_A) {
                        this.func_175322_b(304);
                        break;
                    }
                    break;
                }
                case 305: {
                    this.mc.displayGuiScreen(new GuiScreenCustomizePresets(this));
                    break;
                }
                case 306: {
                    this.func_175331_h();
                    break;
                }
                case 307: {
                    this.field_175339_B = 0;
                    this.func_175331_h();
                    break;
                }
            }
        }
    }
    
    private void func_175328_i() {
        this.field_175345_v.enabled = (this.field_175349_r.func_178059_e() != 0);
        this.field_175344_w.enabled = (this.field_175349_r.func_178059_e() != this.field_175349_r.func_178057_f() - 1);
        this.field_175333_f = I18n.format("book.pageIndicator", this.field_175349_r.func_178059_e() + 1, this.field_175349_r.func_178057_f());
        this.field_175335_g = this.field_175342_h[this.field_175349_r.func_178059_e()];
        this.field_175347_t.enabled = (this.field_175349_r.func_178059_e() != this.field_175349_r.func_178057_f() - 1);
    }
    
    private void func_175326_g() {
        this.field_175336_F.func_177863_a();
        this.func_175325_f();
    }
    
    public GuiCustomizeWorldScreen(final GuiScreen lIIIIIlIIllIl, final String lIIIIIlIIlIIl) {
        this.field_175341_a = "Customize World Settings";
        this.field_175333_f = "Page 1 of 3";
        this.field_175335_g = "Basic Settings";
        this.field_175342_h = new String[4];
        this.field_175338_A = false;
        this.field_175339_B = 0;
        this.field_175340_C = false;
        this.field_175332_D = (Predicate)new Predicate() {
            public boolean func_178956_a(final String llllllllllllllllIlIllIlllIIIIIll) {
                final Float llllllllllllllllIlIllIlllIIIIIlI = Floats.tryParse(llllllllllllllllIlIllIlllIIIIIll);
                return llllllllllllllllIlIllIlllIIIIIll.length() == 0 || (llllllllllllllllIlIllIlllIIIIIlI != null && Floats.isFinite((float)llllllllllllllllIlIllIlllIIIIIlI) && llllllllllllllllIlIllIlllIIIIIlI >= 0.0f);
            }
            
            static {
                __OBFID = "CL_00001933";
            }
            
            public boolean apply(final Object llllllllllllllllIlIllIllIlllllII) {
                return this.func_178956_a((String)llllllllllllllllIlIllIllIlllllII);
            }
        };
        this.field_175334_E = new ChunkProviderSettings.Factory();
        this.field_175337_G = new Random();
        this.field_175343_i = (GuiCreateWorld)lIIIIIlIIllIl;
        this.func_175324_a(lIIIIIlIIlIIl);
    }
    
    public String func_175323_a() {
        return this.field_175336_F.toString().replace("\n", "");
    }
    
    @Override
    protected void mouseClicked(final int llllIlIlllll, final int llllIlIllllI, final int llllIlIlllIl) throws IOException {
        super.mouseClicked(llllIlIlllll, llllIlIllllI, llllIlIlllIl);
        if (this.field_175339_B == 0 && !this.field_175340_C) {
            this.field_175349_r.func_148179_a(llllIlIlllll, llllIlIllllI, llllIlIlllIl);
        }
    }
    
    private void func_175327_a(final float llllIllIlIll) {
        final Gui llllIlllIIlI = this.field_175349_r.func_178056_g();
        if (llllIlllIIlI instanceof GuiTextField) {
            float llllIlllIIIl = llllIllIlIll;
            if (GuiScreen.isShiftKeyDown()) {
                llllIlllIIIl = llllIllIlIll * 0.1f;
                if (GuiScreen.isCtrlKeyDown()) {
                    llllIlllIIIl *= 0.1f;
                }
            }
            else if (GuiScreen.isCtrlKeyDown()) {
                llllIlllIIIl = llllIllIlIll * 10.0f;
                if (GuiScreen.func_175283_s()) {
                    llllIlllIIIl *= 10.0f;
                }
            }
            final GuiTextField llllIlllIIII = (GuiTextField)llllIlllIIlI;
            Float llllIllIllll = Floats.tryParse(llllIlllIIII.getText());
            if (llllIllIllll != null) {
                llllIllIllll += llllIlllIIIl;
                final int llllIllIlllI = llllIlllIIII.func_175206_d();
                final String llllIllIllIl = this.func_175330_b(llllIlllIIII.func_175206_d(), llllIllIllll);
                llllIlllIIII.setText(llllIllIllIl);
                this.func_175319_a(llllIllIlllI, llllIllIllIl);
            }
        }
    }
    
    static {
        __OBFID = "CL_00001934";
    }
    
    private void func_175331_h() throws IOException {
        switch (this.field_175339_B) {
            case 300: {
                this.actionPerformed((GuiButton)this.field_175349_r.func_178061_c(300));
                break;
            }
            case 304: {
                this.func_175326_g();
                break;
            }
        }
        this.field_175339_B = 0;
        this.field_175340_C = true;
        this.func_175329_a(false);
    }
    
    @Override
    public void func_175321_a(final int llllllIIIlIl, final boolean llllllIIIIIl) {
        switch (llllllIIIlIl) {
            case 148: {
                this.field_175336_F.field_177927_s = llllllIIIIIl;
                break;
            }
            case 149: {
                this.field_175336_F.field_177925_t = llllllIIIIIl;
                break;
            }
            case 150: {
                this.field_175336_F.field_177921_v = llllllIIIIIl;
                break;
            }
            case 151: {
                this.field_175336_F.field_177919_w = llllllIIIIIl;
                break;
            }
            case 152: {
                this.field_175336_F.field_177944_x = llllllIIIIIl;
                break;
            }
            case 153: {
                this.field_175336_F.field_177942_y = llllllIIIIIl;
                break;
            }
            case 154: {
                this.field_175336_F.field_177870_A = llllllIIIIIl;
                break;
            }
            case 155: {
                this.field_175336_F.field_177871_B = llllllIIIIIl;
                break;
            }
            case 156: {
                this.field_175336_F.field_177866_D = llllllIIIIIl;
                break;
            }
            case 161: {
                this.field_175336_F.field_177868_F = llllllIIIIIl;
                break;
            }
            case 210: {
                this.field_175336_F.field_177940_z = llllllIIIIIl;
                break;
            }
        }
        if (!this.field_175336_F.equals(this.field_175334_E)) {
            this.field_175338_A = true;
        }
    }
}
