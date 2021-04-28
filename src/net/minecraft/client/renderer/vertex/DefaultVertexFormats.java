package net.minecraft.client.renderer.vertex;

import shadersmod.client.*;
import optifine.*;

public class DefaultVertexFormats
{
    public static /* synthetic */ VertexFormat field_176599_b;
    public static /* synthetic */ VertexFormat field_176600_a;
    private static final /* synthetic */ VertexFormat BLOCK_VANILLA;
    private static final /* synthetic */ VertexFormat ITEM_VANILLA;
    
    static {
        __OBFID = "CL_00002403";
        DefaultVertexFormats.field_176600_a = new VertexFormat();
        DefaultVertexFormats.field_176599_b = new VertexFormat();
        BLOCK_VANILLA = DefaultVertexFormats.field_176600_a;
        ITEM_VANILLA = DefaultVertexFormats.field_176599_b;
        DefaultVertexFormats.field_176600_a.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.POSITION, 3));
        DefaultVertexFormats.field_176600_a.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUseage.COLOR, 4));
        DefaultVertexFormats.field_176600_a.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.UV, 2));
        DefaultVertexFormats.field_176600_a.func_177349_a(new VertexFormatElement(1, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.UV, 2));
        DefaultVertexFormats.field_176599_b.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.POSITION, 3));
        DefaultVertexFormats.field_176599_b.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUseage.COLOR, 4));
        DefaultVertexFormats.field_176599_b.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.UV, 2));
        DefaultVertexFormats.field_176599_b.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.NORMAL, 3));
        DefaultVertexFormats.field_176599_b.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.PADDING, 1));
    }
    
    public static void updateVertexFormats() {
        if (Config.isShaders()) {
            DefaultVertexFormats.field_176600_a = SVertexFormat.makeDefVertexFormatBlock();
            DefaultVertexFormats.field_176599_b = SVertexFormat.makeDefVertexFormatItem();
        }
        else {
            DefaultVertexFormats.field_176600_a = DefaultVertexFormats.BLOCK_VANILLA;
            DefaultVertexFormats.field_176599_b = DefaultVertexFormats.ITEM_VANILLA;
        }
        if (Reflector.Attributes_DEFAULT_BAKED_FORMAT.exists()) {
            final VertexFormat lllllllllllllllIIlIIlllIIIlIlIlI = DefaultVertexFormats.field_176599_b;
            final VertexFormat lllllllllllllllIIlIIlllIIIlIlIIl = (VertexFormat)Reflector.getFieldValue(Reflector.Attributes_DEFAULT_BAKED_FORMAT);
            lllllllllllllllIIlIIlllIIIlIlIIl.clear();
            for (int lllllllllllllllIIlIIlllIIIlIlIII = 0; lllllllllllllllIIlIIlllIIIlIlIII < lllllllllllllllIIlIIlllIIIlIlIlI.func_177345_h(); ++lllllllllllllllIIlIIlllIIIlIlIII) {
                lllllllllllllllIIlIIlllIIIlIlIIl.func_177349_a(lllllllllllllllIIlIIlllIIIlIlIlI.func_177348_c(lllllllllllllllIIlIIlllIIIlIlIII));
            }
        }
    }
}
