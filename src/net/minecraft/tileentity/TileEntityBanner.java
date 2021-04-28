package net.minecraft.tileentity;

import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;
import com.google.common.collect.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class TileEntityBanner extends TileEntity
{
    private /* synthetic */ String field_175121_j;
    private /* synthetic */ NBTTagList field_175118_f;
    private /* synthetic */ List field_175122_h;
    private /* synthetic */ boolean field_175119_g;
    private /* synthetic */ int baseColor;
    private /* synthetic */ List field_175123_i;
    
    @Override
    public void writeToNBT(final NBTTagCompound llllllllllllllllIIIllllIIlIIIlll) {
        super.writeToNBT(llllllllllllllllIIIllllIIlIIIlll);
        llllllllllllllllIIIllllIIlIIIlll.setInteger("Base", this.baseColor);
        if (this.field_175118_f != null) {
            llllllllllllllllIIIllllIIlIIIlll.setTag("Patterns", this.field_175118_f);
        }
    }
    
    public String func_175116_e() {
        this.func_175109_g();
        return this.field_175121_j;
    }
    
    public int getBaseColor() {
        return this.baseColor;
    }
    
    public static int func_175113_c(final ItemStack llllllllllllllllIIIllllIIIlIllIl) {
        final NBTTagCompound llllllllllllllllIIIllllIIIlIllII = llllllllllllllllIIIllllIIIlIllIl.getSubCompound("BlockEntityTag", false);
        return (llllllllllllllllIIIllllIIIlIllII != null && llllllllllllllllIIIllllIIIlIllII.hasKey("Patterns")) ? llllllllllllllllIIIllllIIIlIllII.getTagList("Patterns", 10).tagCount() : 0;
    }
    
    @Override
    public Packet getDescriptionPacket() {
        final NBTTagCompound llllllllllllllllIIIllllIIIlllIll = new NBTTagCompound();
        this.writeToNBT(llllllllllllllllIIIllllIIIlllIll);
        return new S35PacketUpdateTileEntity(this.pos, 6, llllllllllllllllIIIllllIIIlllIll);
    }
    
    public List func_175114_c() {
        this.func_175109_g();
        return this.field_175122_h;
    }
    
    private void func_175109_g() {
        if (this.field_175122_h == null || this.field_175123_i == null || this.field_175121_j == null) {
            if (!this.field_175119_g) {
                this.field_175121_j = "";
            }
            else {
                this.field_175122_h = Lists.newArrayList();
                this.field_175123_i = Lists.newArrayList();
                this.field_175122_h.add(EnumBannerPattern.BASE);
                this.field_175123_i.add(EnumDyeColor.func_176766_a(this.baseColor));
                this.field_175121_j = String.valueOf(new StringBuilder("b").append(this.baseColor));
                if (this.field_175118_f != null) {
                    for (int llllllllllllllllIIIllllIIIIllIlI = 0; llllllllllllllllIIIllllIIIIllIlI < this.field_175118_f.tagCount(); ++llllllllllllllllIIIllllIIIIllIlI) {
                        final NBTTagCompound llllllllllllllllIIIllllIIIIllIIl = this.field_175118_f.getCompoundTagAt(llllllllllllllllIIIllllIIIIllIlI);
                        final EnumBannerPattern llllllllllllllllIIIllllIIIIllIII = EnumBannerPattern.func_177268_a(llllllllllllllllIIIllllIIIIllIIl.getString("Pattern"));
                        if (llllllllllllllllIIIllllIIIIllIII != null) {
                            this.field_175122_h.add(llllllllllllllllIIIllllIIIIllIII);
                            final int llllllllllllllllIIIllllIIIIlIlll = llllllllllllllllIIIllllIIIIllIIl.getInteger("Color");
                            this.field_175123_i.add(EnumDyeColor.func_176766_a(llllllllllllllllIIIllllIIIIlIlll));
                            this.field_175121_j = String.valueOf(new StringBuilder(String.valueOf(this.field_175121_j)).append(llllllllllllllllIIIllllIIIIllIII.func_177273_b()).append(llllllllllllllllIIIllllIIIIlIlll));
                        }
                    }
                }
            }
        }
    }
    
    public static void func_175117_e(final ItemStack llllllllllllllllIIIllllIIIIIlllI) {
        final NBTTagCompound llllllllllllllllIIIllllIIIIIllIl = llllllllllllllllIIIllllIIIIIlllI.getSubCompound("BlockEntityTag", false);
        if (llllllllllllllllIIIllllIIIIIllIl != null && llllllllllllllllIIIllllIIIIIllIl.hasKey("Patterns", 9)) {
            final NBTTagList llllllllllllllllIIIllllIIIIIllII = llllllllllllllllIIIllllIIIIIllIl.getTagList("Patterns", 10);
            if (llllllllllllllllIIIllllIIIIIllII.tagCount() > 0) {
                llllllllllllllllIIIllllIIIIIllII.removeTag(llllllllllllllllIIIllllIIIIIllII.tagCount() - 1);
                if (llllllllllllllllIIIllllIIIIIllII.hasNoTags()) {
                    llllllllllllllllIIIllllIIIIIlllI.getTagCompound().removeTag("BlockEntityTag");
                    if (llllllllllllllllIIIllllIIIIIlllI.getTagCompound().hasNoTags()) {
                        llllllllllllllllIIIllllIIIIIlllI.setTagCompound(null);
                    }
                }
            }
        }
    }
    
    public void setItemValues(final ItemStack llllllllllllllllIIIllllIIlIIllll) {
        this.field_175118_f = null;
        if (llllllllllllllllIIIllllIIlIIllll.hasTagCompound() && llllllllllllllllIIIllllIIlIIllll.getTagCompound().hasKey("BlockEntityTag", 10)) {
            final NBTTagCompound llllllllllllllllIIIllllIIlIIlllI = llllllllllllllllIIIllllIIlIIllll.getTagCompound().getCompoundTag("BlockEntityTag");
            if (llllllllllllllllIIIllllIIlIIlllI.hasKey("Patterns")) {
                this.field_175118_f = (NBTTagList)llllllllllllllllIIIllllIIlIIlllI.getTagList("Patterns", 10).copy();
            }
            if (llllllllllllllllIIIllllIIlIIlllI.hasKey("Base", 99)) {
                this.baseColor = llllllllllllllllIIIllllIIlIIlllI.getInteger("Base");
            }
            else {
                this.baseColor = (llllllllllllllllIIIllllIIlIIllll.getMetadata() & 0xF);
            }
        }
        else {
            this.baseColor = (llllllllllllllllIIIllllIIlIIllll.getMetadata() & 0xF);
        }
        this.field_175122_h = null;
        this.field_175123_i = null;
        this.field_175121_j = "";
        this.field_175119_g = true;
    }
    
    static {
        __OBFID = "CL_00002044";
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllllIIIllllIIlIIIIIl) {
        super.readFromNBT(llllllllllllllllIIIllllIIlIIIIIl);
        this.baseColor = llllllllllllllllIIIllllIIlIIIIIl.getInteger("Base");
        this.field_175118_f = llllllllllllllllIIIllllIIlIIIIIl.getTagList("Patterns", 10);
        this.field_175122_h = null;
        this.field_175123_i = null;
        this.field_175121_j = null;
        this.field_175119_g = true;
    }
    
    public List func_175110_d() {
        this.func_175109_g();
        return this.field_175123_i;
    }
    
    public static int getBaseColor(final ItemStack llllllllllllllllIIIllllIIIllIIIl) {
        final NBTTagCompound llllllllllllllllIIIllllIIIllIIlI = llllllllllllllllIIIllllIIIllIIIl.getSubCompound("BlockEntityTag", false);
        return (llllllllllllllllIIIllllIIIllIIlI != null && llllllllllllllllIIIllllIIIllIIlI.hasKey("Base")) ? llllllllllllllllIIIllllIIIllIIlI.getInteger("Base") : llllllllllllllllIIIllllIIIllIIIl.getMetadata();
    }
    
    public enum EnumBannerPattern
    {
        private /* synthetic */ String field_177284_N;
        
        DIAGONAL_RIGHT_MIRROR("DIAGONAL_RIGHT_MIRROR", 23, "DIAGONAL_RIGHT_MIRROR", 23, "diagonal_right", "rud", " ##", "  #", "   ");
        
        private /* synthetic */ String[] field_177291_P;
        
        STRIPE_LEFT("STRIPE_LEFT", 7, "STRIPE_LEFT", 7, "stripe_left", "ls", "#  ", "#  ", "#  "), 
        HALF_HORIZONTAL_MIRROR("HALF_HORIZONTAL_MIRROR", 29, "HALF_HORIZONTAL_MIRROR", 29, "half_horizontal_bottom", "hhb", "   ", "###", "###"), 
        HALF_VERTICAL("HALF_VERTICAL", 26, "HALF_VERTICAL", 26, "half_vertical", "vh", "## ", "## ", "## ");
        
        private /* synthetic */ ItemStack field_177290_Q;
        
        SQUARE_BOTTOM_LEFT("SQUARE_BOTTOM_LEFT", 1, "SQUARE_BOTTOM_LEFT", 1, "square_bottom_left", "bl", "   ", "   ", "#  "), 
        DIAGONAL_LEFT("DIAGONAL_LEFT", 20, "DIAGONAL_LEFT", 20, "diagonal_left", "ld", "## ", "#  ", "   "), 
        STRAIGHT_CROSS("STRAIGHT_CROSS", 15, "STRAIGHT_CROSS", 15, "straight_cross", "sc", " # ", "###", " # "), 
        TRIANGLE_BOTTOM("TRIANGLE_BOTTOM", 16, "TRIANGLE_BOTTOM", 16, "triangle_bottom", "bt", "   ", " # ", "# #"), 
        GRADIENT_UP("GRADIENT_UP", 34, "GRADIENT_UP", 34, "gradient_up", "gru", " # ", " # ", "# #"), 
        TRIANGLES_TOP("TRIANGLES_TOP", 19, "TRIANGLES_TOP", 19, "triangles_top", "tts", " # ", "# #", "   "), 
        STRIPE_RIGHT("STRIPE_RIGHT", 8, "STRIPE_RIGHT", 8, "stripe_right", "rs", "  #", "  #", "  #"), 
        SKULL("SKULL", 36, "SKULL", 36, "skull", "sku", new ItemStack(Items.skull, 1, 1)), 
        STRIPE_DOWNLEFT("STRIPE_DOWNLEFT", 12, "STRIPE_DOWNLEFT", 12, "stripe_downleft", "dls", "  #", " # ", "#  "), 
        HALF_VERTICAL_MIRROR("HALF_VERTICAL_MIRROR", 28, "HALF_VERTICAL_MIRROR", 28, "half_vertical_right", "vhr", " ##", " ##", " ##"), 
        STRIPE_SMALL("STRIPE_SMALL", 13, "STRIPE_SMALL", 13, "small_stripes", "ss", "# #", "# #", "   "), 
        CIRCLE_MIDDLE("CIRCLE_MIDDLE", 24, "CIRCLE_MIDDLE", 24, "circle", "mc", "   ", " # ", "   "), 
        RHOMBUS_MIDDLE("RHOMBUS_MIDDLE", 25, "RHOMBUS_MIDDLE", 25, "rhombus", "mr", " # ", "# #", " # "), 
        SQUARE_TOP_RIGHT("SQUARE_TOP_RIGHT", 4, "SQUARE_TOP_RIGHT", 4, "square_top_right", "tr", "  #", "   ", "   "), 
        SQUARE_BOTTOM_RIGHT("SQUARE_BOTTOM_RIGHT", 2, "SQUARE_BOTTOM_RIGHT", 2, "square_bottom_right", "br", "   ", "   ", "  #"), 
        TRIANGLE_TOP("TRIANGLE_TOP", 17, "TRIANGLE_TOP", 17, "triangle_top", "tt", "# #", " # ", "   "), 
        SQUARE_TOP_LEFT("SQUARE_TOP_LEFT", 3, "SQUARE_TOP_LEFT", 3, "square_top_left", "tl", "#  ", "   ", "   "), 
        BORDER("BORDER", 30, "BORDER", 30, "border", "bo", "###", "# #", "###"), 
        TRIANGLES_BOTTOM("TRIANGLES_BOTTOM", 18, "TRIANGLES_BOTTOM", 18, "triangles_bottom", "bts", "   ", "# #", " # "), 
        DIAGONAL_RIGHT("DIAGONAL_RIGHT", 21, "DIAGONAL_RIGHT", 21, "diagonal_up_right", "rd", "   ", "  #", " ##"), 
        CURLY_BORDER("CURLY_BORDER", 31, "CURLY_BORDER", 31, "curly_border", "cbo", new ItemStack(Blocks.vine)), 
        FLOWER("FLOWER", 37, "FLOWER", 37, "flower", "flo", new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.OXEYE_DAISY.func_176968_b())), 
        HALF_HORIZONTAL("HALF_HORIZONTAL", 27, "HALF_HORIZONTAL", 27, "half_horizontal", "hh", "###", "###", "   "), 
        CREEPER("CREEPER", 32, "CREEPER", 32, "creeper", "cre", new ItemStack(Items.skull, 1, 4)), 
        STRIPE_TOP("STRIPE_TOP", 6, "STRIPE_TOP", 6, "stripe_top", "ts", "###", "   ", "   "), 
        DIAGONAL_LEFT_MIRROR("DIAGONAL_LEFT_MIRROR", 22, "DIAGONAL_LEFT_MIRROR", 22, "diagonal_up_left", "lud", "   ", "#  ", "## "), 
        BRICKS("BRICKS", 35, "BRICKS", 35, "bricks", "bri", new ItemStack(Blocks.brick_block)), 
        CROSS("CROSS", 14, "CROSS", 14, "cross", "cr", "# #", " # ", "# #"), 
        STRIPE_BOTTOM("STRIPE_BOTTOM", 5, "STRIPE_BOTTOM", 5, "stripe_bottom", "bs", "   ", "   ", "###");
        
        private /* synthetic */ String field_177285_O;
        
        STRIPE_CENTER("STRIPE_CENTER", 9, "STRIPE_CENTER", 9, "stripe_center", "cs", " # ", " # ", " # "), 
        MOJANG("MOJANG", 38, "MOJANG", 38, "mojang", "moj", new ItemStack(Items.golden_apple, 1, 1)), 
        STRIPE_MIDDLE("STRIPE_MIDDLE", 10, "STRIPE_MIDDLE", 10, "stripe_middle", "ms", "   ", "###", "   "), 
        BASE("BASE", 0, "BASE", 0, "base", "b"), 
        GRADIENT("GRADIENT", 33, "GRADIENT", 33, "gradient", "gra", "# #", " # ", " # "), 
        STRIPE_DOWNRIGHT("STRIPE_DOWNRIGHT", 11, "STRIPE_DOWNRIGHT", 11, "stripe_downright", "drs", "#  ", " # ", "  #");
        
        public String func_177273_b() {
            return this.field_177285_O;
        }
        
        public String[] func_177267_c() {
            return this.field_177291_P;
        }
        
        public ItemStack func_177272_f() {
            return this.field_177290_Q;
        }
        
        private EnumBannerPattern(final String lllllllllllllllIlllllIIllIIIIlll, final int lllllllllllllllIlllllIIllIIIIllI, final String lllllllllllllllIlllllIIllIIIllII, final int lllllllllllllllIlllllIIllIIIlIll, final String lllllllllllllllIlllllIIllIIIIlIl, final String lllllllllllllllIlllllIIllIIIlIIl) {
            this.field_177291_P = new String[3];
            this.field_177284_N = lllllllllllllllIlllllIIllIIIIlIl;
            this.field_177285_O = lllllllllllllllIlllllIIllIIIlIIl;
        }
        
        public boolean func_177269_e() {
            return this.field_177290_Q != null;
        }
        
        private EnumBannerPattern(final String lllllllllllllllIlllllIIlIlIllIlI, final int lllllllllllllllIlllllIIlIlIllIIl, final String lllllllllllllllIlllllIIlIllIIIlI, final int lllllllllllllllIlllllIIlIlIlIlll, final String lllllllllllllllIlllllIIlIlIlIllI, final String lllllllllllllllIlllllIIlIlIlIlIl, final String lllllllllllllllIlllllIIlIlIlIlII, final String lllllllllllllllIlllllIIlIlIlIIll, final String lllllllllllllllIlllllIIlIlIlIIlI) {
            this(lllllllllllllllIlllllIIlIlIllIlI, lllllllllllllllIlllllIIlIlIllIIl, lllllllllllllllIlllllIIlIllIIIlI, lllllllllllllllIlllllIIlIlIlIlll, lllllllllllllllIlllllIIlIlIlIllI, lllllllllllllllIlllllIIlIlIlIlIl);
            this.field_177291_P[0] = lllllllllllllllIlllllIIlIlIlIlII;
            this.field_177291_P[1] = lllllllllllllllIlllllIIlIlIlIIll;
            this.field_177291_P[2] = lllllllllllllllIlllllIIlIlIlIIlI;
        }
        
        private EnumBannerPattern(final String lllllllllllllllIlllllIIlIlllIlII, final int lllllllllllllllIlllllIIlIlllIIll, final String lllllllllllllllIlllllIIlIllllIlI, final int lllllllllllllllIlllllIIlIllllIIl, final String lllllllllllllllIlllllIIlIlllIIII, final String lllllllllllllllIlllllIIlIlllIlll, final ItemStack lllllllllllllllIlllllIIlIlllIllI) {
            this(lllllllllllllllIlllllIIlIlllIlII, lllllllllllllllIlllllIIlIlllIIll, lllllllllllllllIlllllIIlIllllIlI, lllllllllllllllIlllllIIlIllllIIl, lllllllllllllllIlllllIIlIlllIIII, lllllllllllllllIlllllIIlIlllIlll);
            this.field_177290_Q = lllllllllllllllIlllllIIlIlllIllI;
        }
        
        public String func_177271_a() {
            return this.field_177284_N;
        }
        
        public static EnumBannerPattern func_177268_a(final String lllllllllllllllIlllllIIlIIllIlIl) {
            for (final EnumBannerPattern lllllllllllllllIlllllIIlIIllIllI : values()) {
                if (lllllllllllllllIlllllIIlIIllIllI.field_177285_O.equals(lllllllllllllllIlllllIIlIIllIlIl)) {
                    return lllllllllllllllIlllllIIlIIllIllI;
                }
            }
            return null;
        }
        
        static {
            __OBFID = "CL_00002043";
        }
        
        public boolean func_177270_d() {
            return this.field_177290_Q != null || this.field_177291_P[0] != null;
        }
    }
}
