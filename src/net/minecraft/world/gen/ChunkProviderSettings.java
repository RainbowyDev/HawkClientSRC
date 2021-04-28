package net.minecraft.world.gen;

import java.lang.reflect.*;
import net.minecraft.util.*;
import net.minecraft.world.biome.*;
import com.google.gson.*;

public class ChunkProviderSettings
{
    public final /* synthetic */ int field_177814_as;
    public final /* synthetic */ int field_177794_W;
    public final /* synthetic */ float field_177815_o;
    public final /* synthetic */ int field_177812_at;
    public final /* synthetic */ int field_177849_ah;
    public final /* synthetic */ int field_177847_ab;
    public final /* synthetic */ boolean field_177837_s;
    public final /* synthetic */ int field_177798_S;
    public final /* synthetic */ int field_177830_al;
    public final /* synthetic */ float field_177804_g;
    public final /* synthetic */ int field_177828_ak;
    public final /* synthetic */ int field_177797_P;
    public final /* synthetic */ int field_177805_az;
    public final /* synthetic */ int field_177790_J;
    public final /* synthetic */ float field_177811_a;
    public final /* synthetic */ int field_177846_aa;
    public final /* synthetic */ int field_177836_ao;
    public final /* synthetic */ int field_177841_q;
    public final /* synthetic */ float field_177809_b;
    public final /* synthetic */ int field_177835_t;
    public final /* synthetic */ int field_177802_Z;
    public final /* synthetic */ int field_177842_an;
    public final /* synthetic */ boolean field_177850_z;
    public final /* synthetic */ int field_177822_aw;
    public final /* synthetic */ boolean field_177833_u;
    public final /* synthetic */ int field_177782_B;
    public final /* synthetic */ float field_177813_n;
    public final /* synthetic */ int field_177784_L;
    public final /* synthetic */ int field_177848_ag;
    public final /* synthetic */ float field_177823_k;
    public final /* synthetic */ int field_177796_Q;
    public final /* synthetic */ int field_177816_ar;
    public final /* synthetic */ int field_177834_aj;
    public final /* synthetic */ float field_177825_h;
    public final /* synthetic */ int field_177824_av;
    public final /* synthetic */ int field_177807_ay;
    public final /* synthetic */ float field_177808_e;
    public final /* synthetic */ int field_177853_af;
    public final /* synthetic */ float field_177810_c;
    public final /* synthetic */ int field_177799_R;
    public final /* synthetic */ int field_177800_Y;
    public final /* synthetic */ int field_177788_H;
    public final /* synthetic */ int field_177792_U;
    public final /* synthetic */ boolean field_177852_y;
    public final /* synthetic */ int field_177840_am;
    public final /* synthetic */ int field_177844_ac;
    public final /* synthetic */ int field_177791_K;
    public final /* synthetic */ int field_177832_ai;
    public final /* synthetic */ int field_177786_N;
    public final /* synthetic */ float field_177817_l;
    public final /* synthetic */ boolean field_177783_C;
    public final /* synthetic */ boolean field_177778_E;
    public final /* synthetic */ int field_177801_X;
    public final /* synthetic */ boolean field_177831_v;
    public final /* synthetic */ int field_177826_au;
    public final /* synthetic */ float field_177821_j;
    public final /* synthetic */ float field_177827_i;
    public final /* synthetic */ int field_177787_O;
    public final /* synthetic */ boolean field_177829_w;
    public final /* synthetic */ int field_177779_F;
    public final /* synthetic */ int field_177785_M;
    public final /* synthetic */ float field_177819_m;
    public final /* synthetic */ int field_177845_ad;
    public final /* synthetic */ int field_177780_G;
    public final /* synthetic */ boolean field_177854_x;
    public final /* synthetic */ boolean field_177781_A;
    public final /* synthetic */ float field_177806_d;
    public final /* synthetic */ int field_177795_V;
    public final /* synthetic */ int field_177820_ax;
    public final /* synthetic */ float field_177843_p;
    public final /* synthetic */ int field_177789_I;
    public final /* synthetic */ int field_177777_D;
    public final /* synthetic */ int field_177838_ap;
    public final /* synthetic */ int field_177851_ae;
    public final /* synthetic */ int field_177818_aq;
    public final /* synthetic */ int field_177793_T;
    public final /* synthetic */ boolean field_177839_r;
    public final /* synthetic */ float field_177803_f;
    
    static {
        __OBFID = "CL_00002006";
    }
    
    ChunkProviderSettings(final Factory llllllllllllllIlIlIIlIIlllIllllI, final Object llllllllllllllIlIlIIlIIlllIlllIl) {
        this(llllllllllllllIlIlIIlIIlllIllllI);
    }
    
    private ChunkProviderSettings(final Factory llllllllllllllIlIlIIlIIllllIIIlI) {
        this.field_177811_a = llllllllllllllIlIlIIlIIllllIIIlI.field_177899_b;
        this.field_177809_b = llllllllllllllIlIlIIlIIllllIIIlI.field_177900_c;
        this.field_177810_c = llllllllllllllIlIlIIlIIllllIIIlI.field_177896_d;
        this.field_177806_d = llllllllllllllIlIlIIlIIllllIIIlI.field_177898_e;
        this.field_177808_e = llllllllllllllIlIlIIlIIllllIIIlI.field_177893_f;
        this.field_177803_f = llllllllllllllIlIlIIlIIllllIIIlI.field_177894_g;
        this.field_177804_g = llllllllllllllIlIlIIlIIllllIIIlI.field_177915_h;
        this.field_177825_h = llllllllllllllIlIlIIlIIllllIIIlI.field_177917_i;
        this.field_177827_i = llllllllllllllIlIlIIlIIllllIIIlI.field_177911_j;
        this.field_177821_j = llllllllllllllIlIlIIlIIllllIIIlI.field_177913_k;
        this.field_177823_k = llllllllllllllIlIlIIlIIllllIIIlI.field_177907_l;
        this.field_177817_l = llllllllllllllIlIlIIlIIllllIIIlI.field_177909_m;
        this.field_177819_m = llllllllllllllIlIlIIlIIllllIIIlI.field_177903_n;
        this.field_177813_n = llllllllllllllIlIlIIlIIllllIIIlI.field_177905_o;
        this.field_177815_o = llllllllllllllIlIlIIlIIllllIIIlI.field_177933_p;
        this.field_177843_p = llllllllllllllIlIlIIlIIllllIIIlI.field_177931_q;
        this.field_177841_q = llllllllllllllIlIlIIlIIllllIIIlI.field_177929_r;
        this.field_177839_r = llllllllllllllIlIlIIlIIllllIIIlI.field_177927_s;
        this.field_177837_s = llllllllllllllIlIlIIlIIllllIIIlI.field_177925_t;
        this.field_177835_t = llllllllllllllIlIlIIlIIllllIIIlI.field_177923_u;
        this.field_177833_u = llllllllllllllIlIlIIlIIllllIIIlI.field_177921_v;
        this.field_177831_v = llllllllllllllIlIlIIlIIllllIIIlI.field_177919_w;
        this.field_177829_w = llllllllllllllIlIlIIlIIllllIIIlI.field_177944_x;
        this.field_177854_x = llllllllllllllIlIlIIlIIllllIIIlI.field_177942_y;
        this.field_177852_y = llllllllllllllIlIlIIlIIllllIIIlI.field_177940_z;
        this.field_177850_z = llllllllllllllIlIlIIlIIllllIIIlI.field_177870_A;
        this.field_177781_A = llllllllllllllIlIlIIlIIllllIIIlI.field_177871_B;
        this.field_177782_B = llllllllllllllIlIlIIlIIllllIIIlI.field_177872_C;
        this.field_177783_C = llllllllllllllIlIlIIlIIllllIIIlI.field_177866_D;
        this.field_177777_D = llllllllllllllIlIlIIlIIllllIIIlI.field_177867_E;
        this.field_177778_E = llllllllllllllIlIlIIlIIllllIIIlI.field_177868_F;
        this.field_177779_F = llllllllllllllIlIlIIlIIllllIIIlI.field_177869_G;
        this.field_177780_G = llllllllllllllIlIlIIlIIllllIIIlI.field_177877_H;
        this.field_177788_H = llllllllllllllIlIlIIlIIllllIIIlI.field_177878_I;
        this.field_177789_I = llllllllllllllIlIlIIlIIllllIIIlI.field_177879_J;
        this.field_177790_J = llllllllllllllIlIlIIlIIllllIIIlI.field_177880_K;
        this.field_177791_K = llllllllllllllIlIlIIlIIllllIIIlI.field_177873_L;
        this.field_177784_L = llllllllllllllIlIlIIlIIllllIIIlI.field_177874_M;
        this.field_177785_M = llllllllllllllIlIlIIlIIllllIIIlI.field_177875_N;
        this.field_177786_N = llllllllllllllIlIlIIlIIllllIIIlI.field_177876_O;
        this.field_177787_O = llllllllllllllIlIlIIlIIllllIIIlI.field_177886_P;
        this.field_177797_P = llllllllllllllIlIlIIlIIllllIIIlI.field_177885_Q;
        this.field_177796_Q = llllllllllllllIlIlIIlIIllllIIIlI.field_177888_R;
        this.field_177799_R = llllllllllllllIlIlIIlIIllllIIIlI.field_177887_S;
        this.field_177798_S = llllllllllllllIlIlIIlIIllllIIIlI.field_177882_T;
        this.field_177793_T = llllllllllllllIlIlIIlIIllllIIIlI.field_177881_U;
        this.field_177792_U = llllllllllllllIlIlIIlIIllllIIIlI.field_177884_V;
        this.field_177795_V = llllllllllllllIlIlIIlIIllllIIIlI.field_177883_W;
        this.field_177794_W = llllllllllllllIlIlIIlIIllllIIIlI.field_177891_X;
        this.field_177801_X = llllllllllllllIlIlIIlIIllllIIIlI.field_177890_Y;
        this.field_177800_Y = llllllllllllllIlIlIIlIIllllIIIlI.field_177892_Z;
        this.field_177802_Z = llllllllllllllIlIlIIlIIllllIIIlI.field_177936_aa;
        this.field_177846_aa = llllllllllllllIlIlIIlIIllllIIIlI.field_177937_ab;
        this.field_177847_ab = llllllllllllllIlIlIIlIIllllIIIlI.field_177934_ac;
        this.field_177844_ac = llllllllllllllIlIlIIlIIllllIIIlI.field_177935_ad;
        this.field_177845_ad = llllllllllllllIlIlIIlIIllllIIIlI.field_177941_ae;
        this.field_177851_ae = llllllllllllllIlIlIIlIIllllIIIlI.field_177943_af;
        this.field_177853_af = llllllllllllllIlIlIIlIIllllIIIlI.field_177938_ag;
        this.field_177848_ag = llllllllllllllIlIlIIlIIllllIIIlI.field_177939_ah;
        this.field_177849_ah = llllllllllllllIlIlIIlIIllllIIIlI.field_177922_ai;
        this.field_177832_ai = llllllllllllllIlIlIIlIIllllIIIlI.field_177924_aj;
        this.field_177834_aj = llllllllllllllIlIlIIlIIllllIIIlI.field_177918_ak;
        this.field_177828_ak = llllllllllllllIlIlIIlIIllllIIIlI.field_177920_al;
        this.field_177830_al = llllllllllllllIlIlIIlIIllllIIIlI.field_177930_am;
        this.field_177840_am = llllllllllllllIlIlIIlIIllllIIIlI.field_177932_an;
        this.field_177842_an = llllllllllllllIlIlIIlIIllllIIIlI.field_177926_ao;
        this.field_177836_ao = llllllllllllllIlIlIIlIIllllIIIlI.field_177928_ap;
        this.field_177838_ap = llllllllllllllIlIlIIlIIllllIIIlI.field_177908_aq;
        this.field_177818_aq = llllllllllllllIlIlIIlIIllllIIIlI.field_177906_ar;
        this.field_177816_ar = llllllllllllllIlIlIIlIIllllIIIlI.field_177904_as;
        this.field_177814_as = llllllllllllllIlIlIIlIIllllIIIlI.field_177902_at;
        this.field_177812_at = llllllllllllllIlIlIIlIIllllIIIlI.field_177916_au;
        this.field_177826_au = llllllllllllllIlIlIIlIIllllIIIlI.field_177914_av;
        this.field_177824_av = llllllllllllllIlIlIIlIIllllIIIlI.field_177912_aw;
        this.field_177822_aw = llllllllllllllIlIlIIlIIllllIIIlI.field_177910_ax;
        this.field_177820_ax = llllllllllllllIlIlIIlIIllllIIIlI.field_177897_ay;
        this.field_177807_ay = llllllllllllllIlIlIIlIIllllIIIlI.field_177895_az;
        this.field_177805_az = llllllllllllllIlIlIIlIIllllIIIlI.field_177889_aA;
    }
    
    public static class Serializer implements JsonSerializer, JsonDeserializer
    {
        public JsonElement serialize(final Object llllllllllllllllIIlIllIIlllIIlll, final Type llllllllllllllllIIlIllIIlllIIllI, final JsonSerializationContext llllllllllllllllIIlIllIIlllIIlIl) {
            return this.func_177862_a((Factory)llllllllllllllllIIlIllIIlllIIlll, llllllllllllllllIIlIllIIlllIIllI, llllllllllllllllIIlIllIIlllIIlIl);
        }
        
        public Object deserialize(final JsonElement llllllllllllllllIIlIllIIllllIlll, final Type llllllllllllllllIIlIllIIllllIllI, final JsonDeserializationContext llllllllllllllllIIlIllIIlllllIIl) {
            return this.func_177861_a(llllllllllllllllIIlIllIIllllIlll, llllllllllllllllIIlIllIIllllIllI, llllllllllllllllIIlIllIIlllllIIl);
        }
        
        public Factory func_177861_a(final JsonElement llllllllllllllllIIlIllIlIIllIllI, final Type llllllllllllllllIIlIllIlIIllIlIl, final JsonDeserializationContext llllllllllllllllIIlIllIlIIllIlII) {
            final JsonObject llllllllllllllllIIlIllIlIIllIIll = llllllllllllllllIIlIllIlIIllIllI.getAsJsonObject();
            final Factory llllllllllllllllIIlIllIlIIllIIlI = new Factory();
            try {
                llllllllllllllllIIlIllIlIIllIIlI.field_177899_b = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "coordinateScale", llllllllllllllllIIlIllIlIIllIIlI.field_177899_b);
                llllllllllllllllIIlIllIlIIllIIlI.field_177900_c = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "heightScale", llllllllllllllllIIlIllIlIIllIIlI.field_177900_c);
                llllllllllllllllIIlIllIlIIllIIlI.field_177898_e = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "lowerLimitScale", llllllllllllllllIIlIllIlIIllIIlI.field_177898_e);
                llllllllllllllllIIlIllIlIIllIIlI.field_177896_d = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "upperLimitScale", llllllllllllllllIIlIllIlIIllIIlI.field_177896_d);
                llllllllllllllllIIlIllIlIIllIIlI.field_177893_f = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "depthNoiseScaleX", llllllllllllllllIIlIllIlIIllIIlI.field_177893_f);
                llllllllllllllllIIlIllIlIIllIIlI.field_177894_g = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "depthNoiseScaleZ", llllllllllllllllIIlIllIlIIllIIlI.field_177894_g);
                llllllllllllllllIIlIllIlIIllIIlI.field_177915_h = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "depthNoiseScaleExponent", llllllllllllllllIIlIllIlIIllIIlI.field_177915_h);
                llllllllllllllllIIlIllIlIIllIIlI.field_177917_i = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "mainNoiseScaleX", llllllllllllllllIIlIllIlIIllIIlI.field_177917_i);
                llllllllllllllllIIlIllIlIIllIIlI.field_177911_j = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "mainNoiseScaleY", llllllllllllllllIIlIllIlIIllIIlI.field_177911_j);
                llllllllllllllllIIlIllIlIIllIIlI.field_177913_k = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "mainNoiseScaleZ", llllllllllllllllIIlIllIlIIllIIlI.field_177913_k);
                llllllllllllllllIIlIllIlIIllIIlI.field_177907_l = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "baseSize", llllllllllllllllIIlIllIlIIllIIlI.field_177907_l);
                llllllllllllllllIIlIllIlIIllIIlI.field_177909_m = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "stretchY", llllllllllllllllIIlIllIlIIllIIlI.field_177909_m);
                llllllllllllllllIIlIllIlIIllIIlI.field_177903_n = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "biomeDepthWeight", llllllllllllllllIIlIllIlIIllIIlI.field_177903_n);
                llllllllllllllllIIlIllIlIIllIIlI.field_177905_o = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "biomeDepthOffset", llllllllllllllllIIlIllIlIIllIIlI.field_177905_o);
                llllllllllllllllIIlIllIlIIllIIlI.field_177933_p = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "biomeScaleWeight", llllllllllllllllIIlIllIlIIllIIlI.field_177933_p);
                llllllllllllllllIIlIllIlIIllIIlI.field_177931_q = JsonUtils.getJsonObjectFloatFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "biomeScaleOffset", llllllllllllllllIIlIllIlIIllIIlI.field_177931_q);
                llllllllllllllllIIlIllIlIIllIIlI.field_177929_r = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "seaLevel", llllllllllllllllIIlIllIlIIllIIlI.field_177929_r);
                llllllllllllllllIIlIllIlIIllIIlI.field_177927_s = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useCaves", llllllllllllllllIIlIllIlIIllIIlI.field_177927_s);
                llllllllllllllllIIlIllIlIIllIIlI.field_177925_t = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useDungeons", llllllllllllllllIIlIllIlIIllIIlI.field_177925_t);
                llllllllllllllllIIlIllIlIIllIIlI.field_177923_u = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "dungeonChance", llllllllllllllllIIlIllIlIIllIIlI.field_177923_u);
                llllllllllllllllIIlIllIlIIllIIlI.field_177921_v = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useStrongholds", llllllllllllllllIIlIllIlIIllIIlI.field_177921_v);
                llllllllllllllllIIlIllIlIIllIIlI.field_177919_w = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useVillages", llllllllllllllllIIlIllIlIIllIIlI.field_177919_w);
                llllllllllllllllIIlIllIlIIllIIlI.field_177944_x = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useMineShafts", llllllllllllllllIIlIllIlIIllIIlI.field_177944_x);
                llllllllllllllllIIlIllIlIIllIIlI.field_177942_y = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useTemples", llllllllllllllllIIlIllIlIIllIIlI.field_177942_y);
                llllllllllllllllIIlIllIlIIllIIlI.field_177940_z = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useMonuments", llllllllllllllllIIlIllIlIIllIIlI.field_177940_z);
                llllllllllllllllIIlIllIlIIllIIlI.field_177870_A = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useRavines", llllllllllllllllIIlIllIlIIllIIlI.field_177870_A);
                llllllllllllllllIIlIllIlIIllIIlI.field_177871_B = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useWaterLakes", llllllllllllllllIIlIllIlIIllIIlI.field_177871_B);
                llllllllllllllllIIlIllIlIIllIIlI.field_177872_C = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "waterLakeChance", llllllllllllllllIIlIllIlIIllIIlI.field_177872_C);
                llllllllllllllllIIlIllIlIIllIIlI.field_177866_D = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useLavaLakes", llllllllllllllllIIlIllIlIIllIIlI.field_177866_D);
                llllllllllllllllIIlIllIlIIllIIlI.field_177867_E = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "lavaLakeChance", llllllllllllllllIIlIllIlIIllIIlI.field_177867_E);
                llllllllllllllllIIlIllIlIIllIIlI.field_177868_F = JsonUtils.getJsonObjectBooleanFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "useLavaOceans", llllllllllllllllIIlIllIlIIllIIlI.field_177868_F);
                llllllllllllllllIIlIllIlIIllIIlI.field_177869_G = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "fixedBiome", llllllllllllllllIIlIllIlIIllIIlI.field_177869_G);
                if (llllllllllllllllIIlIllIlIIllIIlI.field_177869_G < 38 && llllllllllllllllIIlIllIlIIllIIlI.field_177869_G >= -1) {
                    if (llllllllllllllllIIlIllIlIIllIIlI.field_177869_G >= BiomeGenBase.hell.biomeID) {
                        final Factory factory = llllllllllllllllIIlIllIlIIllIIlI;
                        factory.field_177869_G += 2;
                    }
                }
                else {
                    llllllllllllllllIIlIllIlIIllIIlI.field_177869_G = -1;
                }
                llllllllllllllllIIlIllIlIIllIIlI.field_177877_H = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "biomeSize", llllllllllllllllIIlIllIlIIllIIlI.field_177877_H);
                llllllllllllllllIIlIllIlIIllIIlI.field_177878_I = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "riverSize", llllllllllllllllIIlIllIlIIllIIlI.field_177878_I);
                llllllllllllllllIIlIllIlIIllIIlI.field_177879_J = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "dirtSize", llllllllllllllllIIlIllIlIIllIIlI.field_177879_J);
                llllllllllllllllIIlIllIlIIllIIlI.field_177880_K = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "dirtCount", llllllllllllllllIIlIllIlIIllIIlI.field_177880_K);
                llllllllllllllllIIlIllIlIIllIIlI.field_177873_L = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "dirtMinHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177873_L);
                llllllllllllllllIIlIllIlIIllIIlI.field_177874_M = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "dirtMaxHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177874_M);
                llllllllllllllllIIlIllIlIIllIIlI.field_177875_N = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "gravelSize", llllllllllllllllIIlIllIlIIllIIlI.field_177875_N);
                llllllllllllllllIIlIllIlIIllIIlI.field_177876_O = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "gravelCount", llllllllllllllllIIlIllIlIIllIIlI.field_177876_O);
                llllllllllllllllIIlIllIlIIllIIlI.field_177886_P = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "gravelMinHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177886_P);
                llllllllllllllllIIlIllIlIIllIIlI.field_177885_Q = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "gravelMaxHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177885_Q);
                llllllllllllllllIIlIllIlIIllIIlI.field_177888_R = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "graniteSize", llllllllllllllllIIlIllIlIIllIIlI.field_177888_R);
                llllllllllllllllIIlIllIlIIllIIlI.field_177887_S = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "graniteCount", llllllllllllllllIIlIllIlIIllIIlI.field_177887_S);
                llllllllllllllllIIlIllIlIIllIIlI.field_177882_T = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "graniteMinHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177882_T);
                llllllllllllllllIIlIllIlIIllIIlI.field_177881_U = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "graniteMaxHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177881_U);
                llllllllllllllllIIlIllIlIIllIIlI.field_177884_V = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "dioriteSize", llllllllllllllllIIlIllIlIIllIIlI.field_177884_V);
                llllllllllllllllIIlIllIlIIllIIlI.field_177883_W = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "dioriteCount", llllllllllllllllIIlIllIlIIllIIlI.field_177883_W);
                llllllllllllllllIIlIllIlIIllIIlI.field_177891_X = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "dioriteMinHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177891_X);
                llllllllllllllllIIlIllIlIIllIIlI.field_177890_Y = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "dioriteMaxHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177890_Y);
                llllllllllllllllIIlIllIlIIllIIlI.field_177892_Z = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "andesiteSize", llllllllllllllllIIlIllIlIIllIIlI.field_177892_Z);
                llllllllllllllllIIlIllIlIIllIIlI.field_177936_aa = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "andesiteCount", llllllllllllllllIIlIllIlIIllIIlI.field_177936_aa);
                llllllllllllllllIIlIllIlIIllIIlI.field_177937_ab = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "andesiteMinHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177937_ab);
                llllllllllllllllIIlIllIlIIllIIlI.field_177934_ac = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "andesiteMaxHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177934_ac);
                llllllllllllllllIIlIllIlIIllIIlI.field_177935_ad = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "coalSize", llllllllllllllllIIlIllIlIIllIIlI.field_177935_ad);
                llllllllllllllllIIlIllIlIIllIIlI.field_177941_ae = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "coalCount", llllllllllllllllIIlIllIlIIllIIlI.field_177941_ae);
                llllllllllllllllIIlIllIlIIllIIlI.field_177943_af = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "coalMinHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177943_af);
                llllllllllllllllIIlIllIlIIllIIlI.field_177938_ag = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "coalMaxHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177938_ag);
                llllllllllllllllIIlIllIlIIllIIlI.field_177939_ah = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "ironSize", llllllllllllllllIIlIllIlIIllIIlI.field_177939_ah);
                llllllllllllllllIIlIllIlIIllIIlI.field_177922_ai = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "ironCount", llllllllllllllllIIlIllIlIIllIIlI.field_177922_ai);
                llllllllllllllllIIlIllIlIIllIIlI.field_177924_aj = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "ironMinHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177924_aj);
                llllllllllllllllIIlIllIlIIllIIlI.field_177918_ak = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "ironMaxHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177918_ak);
                llllllllllllllllIIlIllIlIIllIIlI.field_177920_al = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "goldSize", llllllllllllllllIIlIllIlIIllIIlI.field_177920_al);
                llllllllllllllllIIlIllIlIIllIIlI.field_177930_am = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "goldCount", llllllllllllllllIIlIllIlIIllIIlI.field_177930_am);
                llllllllllllllllIIlIllIlIIllIIlI.field_177932_an = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "goldMinHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177932_an);
                llllllllllllllllIIlIllIlIIllIIlI.field_177926_ao = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "goldMaxHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177926_ao);
                llllllllllllllllIIlIllIlIIllIIlI.field_177928_ap = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "redstoneSize", llllllllllllllllIIlIllIlIIllIIlI.field_177928_ap);
                llllllllllllllllIIlIllIlIIllIIlI.field_177908_aq = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "redstoneCount", llllllllllllllllIIlIllIlIIllIIlI.field_177908_aq);
                llllllllllllllllIIlIllIlIIllIIlI.field_177906_ar = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "redstoneMinHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177906_ar);
                llllllllllllllllIIlIllIlIIllIIlI.field_177904_as = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "redstoneMaxHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177904_as);
                llllllllllllllllIIlIllIlIIllIIlI.field_177902_at = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "diamondSize", llllllllllllllllIIlIllIlIIllIIlI.field_177902_at);
                llllllllllllllllIIlIllIlIIllIIlI.field_177916_au = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "diamondCount", llllllllllllllllIIlIllIlIIllIIlI.field_177916_au);
                llllllllllllllllIIlIllIlIIllIIlI.field_177914_av = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "diamondMinHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177914_av);
                llllllllllllllllIIlIllIlIIllIIlI.field_177912_aw = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "diamondMaxHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177912_aw);
                llllllllllllllllIIlIllIlIIllIIlI.field_177910_ax = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "lapisSize", llllllllllllllllIIlIllIlIIllIIlI.field_177910_ax);
                llllllllllllllllIIlIllIlIIllIIlI.field_177897_ay = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "lapisCount", llllllllllllllllIIlIllIlIIllIIlI.field_177897_ay);
                llllllllllllllllIIlIllIlIIllIIlI.field_177895_az = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "lapisCenterHeight", llllllllllllllllIIlIllIlIIllIIlI.field_177895_az);
                llllllllllllllllIIlIllIlIIllIIlI.field_177889_aA = JsonUtils.getJsonObjectIntegerFieldValueOrDefault(llllllllllllllllIIlIllIlIIllIIll, "lapisSpread", llllllllllllllllIIlIllIlIIllIIlI.field_177889_aA);
            }
            catch (Exception ex) {}
            return llllllllllllllllIIlIllIlIIllIIlI;
        }
        
        public JsonElement func_177862_a(final Factory llllllllllllllllIIlIllIlIIIIllII, final Type llllllllllllllllIIlIllIlIIIlIIIl, final JsonSerializationContext llllllllllllllllIIlIllIlIIIIllll) {
            final JsonObject llllllllllllllllIIlIllIlIIIIllIl = new JsonObject();
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("coordinateScale", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177899_b);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("heightScale", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177900_c);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("lowerLimitScale", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177898_e);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("upperLimitScale", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177896_d);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("depthNoiseScaleX", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177893_f);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("depthNoiseScaleZ", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177894_g);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("depthNoiseScaleExponent", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177915_h);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("mainNoiseScaleX", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177917_i);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("mainNoiseScaleY", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177911_j);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("mainNoiseScaleZ", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177913_k);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("baseSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177907_l);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("stretchY", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177909_m);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("biomeDepthWeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177903_n);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("biomeDepthOffset", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177905_o);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("biomeScaleWeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177933_p);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("biomeScaleOffset", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177931_q);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("seaLevel", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177929_r);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useCaves", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177927_s));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useDungeons", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177925_t));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("dungeonChance", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177923_u);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useStrongholds", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177921_v));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useVillages", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177919_w));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useMineShafts", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177944_x));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useTemples", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177942_y));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useMonuments", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177940_z));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useRavines", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177870_A));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useWaterLakes", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177871_B));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("waterLakeChance", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177872_C);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useLavaLakes", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177866_D));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("lavaLakeChance", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177867_E);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("useLavaOceans", Boolean.valueOf(llllllllllllllllIIlIllIlIIIIllII.field_177868_F));
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("fixedBiome", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177869_G);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("biomeSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177877_H);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("riverSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177878_I);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("dirtSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177879_J);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("dirtCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177880_K);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("dirtMinHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177873_L);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("dirtMaxHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177874_M);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("gravelSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177875_N);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("gravelCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177876_O);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("gravelMinHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177886_P);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("gravelMaxHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177885_Q);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("graniteSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177888_R);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("graniteCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177887_S);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("graniteMinHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177882_T);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("graniteMaxHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177881_U);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("dioriteSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177884_V);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("dioriteCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177883_W);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("dioriteMinHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177891_X);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("dioriteMaxHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177890_Y);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("andesiteSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177892_Z);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("andesiteCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177936_aa);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("andesiteMinHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177937_ab);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("andesiteMaxHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177934_ac);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("coalSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177935_ad);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("coalCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177941_ae);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("coalMinHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177943_af);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("coalMaxHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177938_ag);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("ironSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177939_ah);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("ironCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177922_ai);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("ironMinHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177924_aj);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("ironMaxHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177918_ak);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("goldSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177920_al);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("goldCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177930_am);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("goldMinHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177932_an);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("goldMaxHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177926_ao);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("redstoneSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177928_ap);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("redstoneCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177908_aq);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("redstoneMinHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177906_ar);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("redstoneMaxHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177904_as);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("diamondSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177902_at);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("diamondCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177916_au);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("diamondMinHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177914_av);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("diamondMaxHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177912_aw);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("lapisSize", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177910_ax);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("lapisCount", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177897_ay);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("lapisCenterHeight", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177895_az);
            llllllllllllllllIIlIllIlIIIIllIl.addProperty("lapisSpread", (Number)llllllllllllllllIIlIllIlIIIIllII.field_177889_aA);
            return (JsonElement)llllllllllllllllIIlIllIlIIIIllIl;
        }
        
        static {
            __OBFID = "CL_00002003";
        }
    }
    
    public static class Factory
    {
        public /* synthetic */ boolean field_177927_s;
        public /* synthetic */ boolean field_177942_y;
        public /* synthetic */ float field_177898_e;
        public /* synthetic */ float field_177907_l;
        public /* synthetic */ int field_177897_ay;
        public /* synthetic */ int field_177884_V;
        public /* synthetic */ int field_177929_r;
        public /* synthetic */ int field_177875_N;
        public /* synthetic */ boolean field_177925_t;
        public /* synthetic */ int field_177881_U;
        public /* synthetic */ float field_177909_m;
        public /* synthetic */ boolean field_177944_x;
        public /* synthetic */ int field_177941_ae;
        public /* synthetic */ int field_177885_Q;
        public /* synthetic */ int field_177878_I;
        public /* synthetic */ float field_177915_h;
        public /* synthetic */ int field_177890_Y;
        public /* synthetic */ int field_177876_O;
        public /* synthetic */ int field_177889_aA;
        public /* synthetic */ float field_177911_j;
        public /* synthetic */ float field_177899_b;
        public /* synthetic */ int field_177914_av;
        public /* synthetic */ int field_177882_T;
        public /* synthetic */ boolean field_177866_D;
        public /* synthetic */ float field_177893_f;
        public /* synthetic */ int field_177880_K;
        public /* synthetic */ int field_177928_ap;
        public /* synthetic */ int field_177938_ag;
        public /* synthetic */ int field_177924_aj;
        public /* synthetic */ int field_177943_af;
        public /* synthetic */ int field_177923_u;
        public /* synthetic */ int field_177906_ar;
        public /* synthetic */ float field_177896_d;
        public /* synthetic */ float field_177903_n;
        public /* synthetic */ int field_177867_E;
        static final /* synthetic */ Gson field_177901_a;
        public /* synthetic */ int field_177912_aw;
        public /* synthetic */ int field_177922_ai;
        public /* synthetic */ int field_177902_at;
        public /* synthetic */ boolean field_177870_A;
        public /* synthetic */ int field_177908_aq;
        public /* synthetic */ int field_177934_ac;
        public /* synthetic */ boolean field_177868_F;
        public /* synthetic */ int field_177879_J;
        public /* synthetic */ int field_177916_au;
        public /* synthetic */ float field_177900_c;
        public /* synthetic */ float field_177905_o;
        public /* synthetic */ int field_177886_P;
        public /* synthetic */ int field_177936_aa;
        public /* synthetic */ int field_177872_C;
        public /* synthetic */ boolean field_177871_B;
        public /* synthetic */ int field_177869_G;
        public /* synthetic */ int field_177939_ah;
        public /* synthetic */ int field_177877_H;
        public /* synthetic */ int field_177920_al;
        public /* synthetic */ int field_177892_Z;
        public /* synthetic */ float field_177913_k;
        public /* synthetic */ int field_177910_ax;
        public /* synthetic */ float field_177894_g;
        public /* synthetic */ boolean field_177940_z;
        public /* synthetic */ int field_177883_W;
        public /* synthetic */ int field_177887_S;
        public /* synthetic */ float field_177931_q;
        public /* synthetic */ int field_177874_M;
        public /* synthetic */ int field_177926_ao;
        public /* synthetic */ int field_177873_L;
        public /* synthetic */ float field_177933_p;
        public /* synthetic */ int field_177888_R;
        public /* synthetic */ int field_177937_ab;
        public /* synthetic */ int field_177935_ad;
        public /* synthetic */ int field_177930_am;
        public /* synthetic */ int field_177891_X;
        public /* synthetic */ boolean field_177919_w;
        public /* synthetic */ int field_177918_ak;
        public /* synthetic */ int field_177932_an;
        public /* synthetic */ int field_177904_as;
        public /* synthetic */ int field_177895_az;
        public /* synthetic */ float field_177917_i;
        public /* synthetic */ boolean field_177921_v;
        
        @Override
        public boolean equals(final Object llllllllllllllIllIlIlIllllIIllII) {
            if (this == llllllllllllllIllIlIlIllllIIllII) {
                return true;
            }
            if (llllllllllllllIllIlIlIllllIIllII != null && this.getClass() == llllllllllllllIllIlIlIllllIIllII.getClass()) {
                final Factory llllllllllllllIllIlIlIllllIIlllI = (Factory)llllllllllllllIllIlIlIllllIIllII;
                return this.field_177936_aa == llllllllllllllIllIlIlIllllIIlllI.field_177936_aa && this.field_177934_ac == llllllllllllllIllIlIlIllllIIlllI.field_177934_ac && this.field_177937_ab == llllllllllllllIllIlIlIllllIIlllI.field_177937_ab && this.field_177892_Z == llllllllllllllIllIlIlIllllIIlllI.field_177892_Z && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177907_l, this.field_177907_l) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177905_o, this.field_177905_o) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177903_n, this.field_177903_n) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177931_q, this.field_177931_q) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177933_p, this.field_177933_p) == 0 && this.field_177877_H == llllllllllllllIllIlIlIllllIIlllI.field_177877_H && this.field_177941_ae == llllllllllllllIllIlIlIllllIIlllI.field_177941_ae && this.field_177938_ag == llllllllllllllIllIlIlIllllIIlllI.field_177938_ag && this.field_177943_af == llllllllllllllIllIlIlIllllIIlllI.field_177943_af && this.field_177935_ad == llllllllllllllIllIlIlIllllIIlllI.field_177935_ad && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177899_b, this.field_177899_b) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177915_h, this.field_177915_h) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177893_f, this.field_177893_f) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177894_g, this.field_177894_g) == 0 && this.field_177916_au == llllllllllllllIllIlIlIllllIIlllI.field_177916_au && this.field_177912_aw == llllllllllllllIllIlIlIllllIIlllI.field_177912_aw && this.field_177914_av == llllllllllllllIllIlIlIllllIIlllI.field_177914_av && this.field_177902_at == llllllllllllllIllIlIlIllllIIlllI.field_177902_at && this.field_177883_W == llllllllllllllIllIlIlIllllIIlllI.field_177883_W && this.field_177890_Y == llllllllllllllIllIlIlIllllIIlllI.field_177890_Y && this.field_177891_X == llllllllllllllIllIlIlIllllIIlllI.field_177891_X && this.field_177884_V == llllllllllllllIllIlIlIllllIIlllI.field_177884_V && this.field_177880_K == llllllllllllllIllIlIlIllllIIlllI.field_177880_K && this.field_177874_M == llllllllllllllIllIlIlIllllIIlllI.field_177874_M && this.field_177873_L == llllllllllllllIllIlIlIllllIIlllI.field_177873_L && this.field_177879_J == llllllllllllllIllIlIlIllllIIlllI.field_177879_J && this.field_177923_u == llllllllllllllIllIlIlIllllIIlllI.field_177923_u && this.field_177869_G == llllllllllllllIllIlIlIllllIIlllI.field_177869_G && this.field_177930_am == llllllllllllllIllIlIlIllllIIlllI.field_177930_am && this.field_177926_ao == llllllllllllllIllIlIlIllllIIlllI.field_177926_ao && this.field_177932_an == llllllllllllllIllIlIlIllllIIlllI.field_177932_an && this.field_177920_al == llllllllllllllIllIlIlIllllIIlllI.field_177920_al && this.field_177887_S == llllllllllllllIllIlIlIllllIIlllI.field_177887_S && this.field_177881_U == llllllllllllllIllIlIlIllllIIlllI.field_177881_U && this.field_177882_T == llllllllllllllIllIlIlIllllIIlllI.field_177882_T && this.field_177888_R == llllllllllllllIllIlIlIllllIIlllI.field_177888_R && this.field_177876_O == llllllllllllllIllIlIlIllllIIlllI.field_177876_O && this.field_177885_Q == llllllllllllllIllIlIlIllllIIlllI.field_177885_Q && this.field_177886_P == llllllllllllllIllIlIlIllllIIlllI.field_177886_P && this.field_177875_N == llllllllllllllIllIlIlIllllIIlllI.field_177875_N && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177900_c, this.field_177900_c) == 0 && this.field_177922_ai == llllllllllllllIllIlIlIllllIIlllI.field_177922_ai && this.field_177918_ak == llllllllllllllIllIlIlIllllIIlllI.field_177918_ak && this.field_177924_aj == llllllllllllllIllIlIlIllllIIlllI.field_177924_aj && this.field_177939_ah == llllllllllllllIllIlIlIllllIIlllI.field_177939_ah && this.field_177895_az == llllllllllllllIllIlIlIllllIIlllI.field_177895_az && this.field_177897_ay == llllllllllllllIllIlIlIllllIIlllI.field_177897_ay && this.field_177910_ax == llllllllllllllIllIlIlIllllIIlllI.field_177910_ax && this.field_177889_aA == llllllllllllllIllIlIlIllllIIlllI.field_177889_aA && this.field_177867_E == llllllllllllllIllIlIlIllllIIlllI.field_177867_E && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177898_e, this.field_177898_e) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177917_i, this.field_177917_i) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177911_j, this.field_177911_j) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177913_k, this.field_177913_k) == 0 && this.field_177908_aq == llllllllllllllIllIlIlIllllIIlllI.field_177908_aq && this.field_177904_as == llllllllllllllIllIlIlIllllIIlllI.field_177904_as && this.field_177906_ar == llllllllllllllIllIlIlIllllIIlllI.field_177906_ar && this.field_177928_ap == llllllllllllllIllIlIlIllllIIlllI.field_177928_ap && this.field_177878_I == llllllllllllllIllIlIlIllllIIlllI.field_177878_I && this.field_177929_r == llllllllllllllIllIlIlIllllIIlllI.field_177929_r && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177909_m, this.field_177909_m) == 0 && Float.compare(llllllllllllllIllIlIlIllllIIlllI.field_177896_d, this.field_177896_d) == 0 && this.field_177927_s == llllllllllllllIllIlIlIllllIIlllI.field_177927_s && this.field_177925_t == llllllllllllllIllIlIlIllllIIlllI.field_177925_t && this.field_177866_D == llllllllllllllIllIlIlIllllIIlllI.field_177866_D && this.field_177868_F == llllllllllllllIllIlIlIllllIIlllI.field_177868_F && this.field_177944_x == llllllllllllllIllIlIlIllllIIlllI.field_177944_x && this.field_177870_A == llllllllllllllIllIlIlIllllIIlllI.field_177870_A && this.field_177921_v == llllllllllllllIllIlIlIllllIIlllI.field_177921_v && this.field_177942_y == llllllllllllllIllIlIlIllllIIlllI.field_177942_y && this.field_177940_z == llllllllllllllIllIlIlIllllIIlllI.field_177940_z && this.field_177919_w == llllllllllllllIllIlIlIllllIIlllI.field_177919_w && this.field_177871_B == llllllllllllllIllIlIlIllllIIlllI.field_177871_B && this.field_177872_C == llllllllllllllIllIlIlIllllIIlllI.field_177872_C;
            }
            return false;
        }
        
        @Override
        public String toString() {
            return Factory.field_177901_a.toJson((Object)this);
        }
        
        public Factory() {
            this.field_177899_b = 684.412f;
            this.field_177900_c = 684.412f;
            this.field_177896_d = 512.0f;
            this.field_177898_e = 512.0f;
            this.field_177893_f = 200.0f;
            this.field_177894_g = 200.0f;
            this.field_177915_h = 0.5f;
            this.field_177917_i = 80.0f;
            this.field_177911_j = 160.0f;
            this.field_177913_k = 80.0f;
            this.field_177907_l = 8.5f;
            this.field_177909_m = 12.0f;
            this.field_177903_n = 1.0f;
            this.field_177905_o = 0.0f;
            this.field_177933_p = 1.0f;
            this.field_177931_q = 0.0f;
            this.field_177929_r = 63;
            this.field_177927_s = true;
            this.field_177925_t = true;
            this.field_177923_u = 8;
            this.field_177921_v = true;
            this.field_177919_w = true;
            this.field_177944_x = true;
            this.field_177942_y = true;
            this.field_177940_z = true;
            this.field_177870_A = true;
            this.field_177871_B = true;
            this.field_177872_C = 4;
            this.field_177866_D = true;
            this.field_177867_E = 80;
            this.field_177868_F = false;
            this.field_177869_G = -1;
            this.field_177877_H = 4;
            this.field_177878_I = 4;
            this.field_177879_J = 33;
            this.field_177880_K = 10;
            this.field_177873_L = 0;
            this.field_177874_M = 256;
            this.field_177875_N = 33;
            this.field_177876_O = 8;
            this.field_177886_P = 0;
            this.field_177885_Q = 256;
            this.field_177888_R = 33;
            this.field_177887_S = 10;
            this.field_177882_T = 0;
            this.field_177881_U = 80;
            this.field_177884_V = 33;
            this.field_177883_W = 10;
            this.field_177891_X = 0;
            this.field_177890_Y = 80;
            this.field_177892_Z = 33;
            this.field_177936_aa = 10;
            this.field_177937_ab = 0;
            this.field_177934_ac = 80;
            this.field_177935_ad = 17;
            this.field_177941_ae = 20;
            this.field_177943_af = 0;
            this.field_177938_ag = 128;
            this.field_177939_ah = 9;
            this.field_177922_ai = 20;
            this.field_177924_aj = 0;
            this.field_177918_ak = 64;
            this.field_177920_al = 9;
            this.field_177930_am = 2;
            this.field_177932_an = 0;
            this.field_177926_ao = 32;
            this.field_177928_ap = 8;
            this.field_177908_aq = 8;
            this.field_177906_ar = 0;
            this.field_177904_as = 16;
            this.field_177902_at = 8;
            this.field_177916_au = 1;
            this.field_177914_av = 0;
            this.field_177912_aw = 16;
            this.field_177910_ax = 7;
            this.field_177897_ay = 1;
            this.field_177895_az = 16;
            this.field_177889_aA = 16;
            this.func_177863_a();
        }
        
        public static Factory func_177865_a(final String llllllllllllllIllIlIlIllllIllllI) {
            if (llllllllllllllIllIlIlIllllIllllI.length() == 0) {
                return new Factory();
            }
            try {
                return (Factory)Factory.field_177901_a.fromJson(llllllllllllllIllIlIlIllllIllllI, (Class)Factory.class);
            }
            catch (Exception llllllllllllllIllIlIlIllllIlllll) {
                return new Factory();
            }
        }
        
        public ChunkProviderSettings func_177864_b() {
            return new ChunkProviderSettings(this, null);
        }
        
        static {
            __OBFID = "CL_00002004";
            field_177901_a = new GsonBuilder().registerTypeAdapter((Type)Factory.class, (Object)new Serializer()).create();
        }
        
        public void func_177863_a() {
            this.field_177899_b = 684.412f;
            this.field_177900_c = 684.412f;
            this.field_177896_d = 512.0f;
            this.field_177898_e = 512.0f;
            this.field_177893_f = 200.0f;
            this.field_177894_g = 200.0f;
            this.field_177915_h = 0.5f;
            this.field_177917_i = 80.0f;
            this.field_177911_j = 160.0f;
            this.field_177913_k = 80.0f;
            this.field_177907_l = 8.5f;
            this.field_177909_m = 12.0f;
            this.field_177903_n = 1.0f;
            this.field_177905_o = 0.0f;
            this.field_177933_p = 1.0f;
            this.field_177931_q = 0.0f;
            this.field_177929_r = 63;
            this.field_177927_s = true;
            this.field_177925_t = true;
            this.field_177923_u = 8;
            this.field_177921_v = true;
            this.field_177919_w = true;
            this.field_177944_x = true;
            this.field_177942_y = true;
            this.field_177940_z = true;
            this.field_177870_A = true;
            this.field_177871_B = true;
            this.field_177872_C = 4;
            this.field_177866_D = true;
            this.field_177867_E = 80;
            this.field_177868_F = false;
            this.field_177869_G = -1;
            this.field_177877_H = 4;
            this.field_177878_I = 4;
            this.field_177879_J = 33;
            this.field_177880_K = 10;
            this.field_177873_L = 0;
            this.field_177874_M = 256;
            this.field_177875_N = 33;
            this.field_177876_O = 8;
            this.field_177886_P = 0;
            this.field_177885_Q = 256;
            this.field_177888_R = 33;
            this.field_177887_S = 10;
            this.field_177882_T = 0;
            this.field_177881_U = 80;
            this.field_177884_V = 33;
            this.field_177883_W = 10;
            this.field_177891_X = 0;
            this.field_177890_Y = 80;
            this.field_177892_Z = 33;
            this.field_177936_aa = 10;
            this.field_177937_ab = 0;
            this.field_177934_ac = 80;
            this.field_177935_ad = 17;
            this.field_177941_ae = 20;
            this.field_177943_af = 0;
            this.field_177938_ag = 128;
            this.field_177939_ah = 9;
            this.field_177922_ai = 20;
            this.field_177924_aj = 0;
            this.field_177918_ak = 64;
            this.field_177920_al = 9;
            this.field_177930_am = 2;
            this.field_177932_an = 0;
            this.field_177926_ao = 32;
            this.field_177928_ap = 8;
            this.field_177908_aq = 8;
            this.field_177906_ar = 0;
            this.field_177904_as = 16;
            this.field_177902_at = 8;
            this.field_177916_au = 1;
            this.field_177914_av = 0;
            this.field_177912_aw = 16;
            this.field_177910_ax = 7;
            this.field_177897_ay = 1;
            this.field_177895_az = 16;
            this.field_177889_aA = 16;
        }
        
        @Override
        public int hashCode() {
            int llllllllllllllIllIlIlIlllIlIIIll = (this.field_177899_b != 0.0f) ? Float.floatToIntBits(this.field_177899_b) : 0;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177900_c != 0.0f) ? Float.floatToIntBits(this.field_177900_c) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177896_d != 0.0f) ? Float.floatToIntBits(this.field_177896_d) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177898_e != 0.0f) ? Float.floatToIntBits(this.field_177898_e) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177893_f != 0.0f) ? Float.floatToIntBits(this.field_177893_f) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177894_g != 0.0f) ? Float.floatToIntBits(this.field_177894_g) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177915_h != 0.0f) ? Float.floatToIntBits(this.field_177915_h) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177917_i != 0.0f) ? Float.floatToIntBits(this.field_177917_i) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177911_j != 0.0f) ? Float.floatToIntBits(this.field_177911_j) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177913_k != 0.0f) ? Float.floatToIntBits(this.field_177913_k) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177907_l != 0.0f) ? Float.floatToIntBits(this.field_177907_l) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177909_m != 0.0f) ? Float.floatToIntBits(this.field_177909_m) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177903_n != 0.0f) ? Float.floatToIntBits(this.field_177903_n) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177905_o != 0.0f) ? Float.floatToIntBits(this.field_177905_o) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177933_p != 0.0f) ? Float.floatToIntBits(this.field_177933_p) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + ((this.field_177931_q != 0.0f) ? Float.floatToIntBits(this.field_177931_q) : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177929_r;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177927_s ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177925_t ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177923_u;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177921_v ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177919_w ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177944_x ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177942_y ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177940_z ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177870_A ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177871_B ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177872_C;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177866_D ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177867_E;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + (this.field_177868_F ? 1 : 0);
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177869_G;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177877_H;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177878_I;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177879_J;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177880_K;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177873_L;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177874_M;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177875_N;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177876_O;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177886_P;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177885_Q;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177888_R;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177887_S;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177882_T;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177881_U;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177884_V;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177883_W;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177891_X;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177890_Y;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177892_Z;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177936_aa;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177937_ab;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177934_ac;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177935_ad;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177941_ae;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177943_af;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177938_ag;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177939_ah;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177922_ai;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177924_aj;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177918_ak;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177920_al;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177930_am;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177932_an;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177926_ao;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177928_ap;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177908_aq;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177906_ar;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177904_as;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177902_at;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177916_au;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177914_av;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177912_aw;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177910_ax;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177897_ay;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177895_az;
            llllllllllllllIllIlIlIlllIlIIIll = 31 * llllllllllllllIllIlIlIlllIlIIIll + this.field_177889_aA;
            return llllllllllllllIllIlIlIlllIlIIIll;
        }
    }
}
