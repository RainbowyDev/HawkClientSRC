package shadersmod.client;

import net.minecraft.client.renderer.vertex.*;

public class SVertexFormat
{
    static {
        offsetEntity = 12;
        vertexSizeBlock = 14;
        offsetTangent = 10;
        offsetMidTexCoord = 8;
        defVertexFormatTextured = makeDefVertexFormatTextured();
    }
    
    public static VertexFormat makeDefVertexFormatBlock() {
        final VertexFormat llllllllllllllIIlIIIIIIIlIIllIIl = new VertexFormat();
        llllllllllllllIIlIIIIIIIlIIllIIl.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.POSITION, 3));
        llllllllllllllIIlIIIIIIIlIIllIIl.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUseage.COLOR, 4));
        llllllllllllllIIlIIIIIIIlIIllIIl.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.UV, 2));
        llllllllllllllIIlIIIIIIIlIIllIIl.func_177349_a(new VertexFormatElement(1, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.UV, 2));
        llllllllllllllIIlIIIIIIIlIIllIIl.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.NORMAL, 3));
        llllllllllllllIIlIIIIIIIlIIllIIl.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.PADDING, 1));
        llllllllllllllIIlIIIIIIIlIIllIIl.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.PADDING, 2));
        llllllllllllllIIlIIIIIIIlIIllIIl.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 4));
        llllllllllllllIIlIIIIIIIlIIllIIl.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 4));
        return llllllllllllllIIlIIIIIIIlIIllIIl;
    }
    
    public static VertexFormat makeDefVertexFormatTextured() {
        final VertexFormat llllllllllllllIIlIIIIIIIlIIlIIll = new VertexFormat();
        llllllllllllllIIlIIIIIIIlIIlIIll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.POSITION, 3));
        llllllllllllllIIlIIIIIIIlIIlIIll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUseage.PADDING, 4));
        llllllllllllllIIlIIIIIIIlIIlIIll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.UV, 2));
        llllllllllllllIIlIIIIIIIlIIlIIll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 2));
        llllllllllllllIIlIIIIIIIlIIlIIll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.NORMAL, 3));
        llllllllllllllIIlIIIIIIIlIIlIIll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.PADDING, 1));
        llllllllllllllIIlIIIIIIIlIIlIIll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.PADDING, 2));
        llllllllllllllIIlIIIIIIIlIIlIIll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 4));
        llllllllllllllIIlIIIIIIIlIIlIIll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 4));
        return llllllllllllllIIlIIIIIIIlIIlIIll;
    }
    
    public static void setDefBakedFormat(final VertexFormat llllllllllllllIIlIIIIIIIlIIIllll) {
        llllllllllllllIIlIIIIIIIlIIIllll.clear();
        llllllllllllllIIlIIIIIIIlIIIllll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.POSITION, 3));
        llllllllllllllIIlIIIIIIIlIIIllll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUseage.COLOR, 4));
        llllllllllllllIIlIIIIIIIlIIIllll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.UV, 2));
        llllllllllllllIIlIIIIIIIlIIIllll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 2));
        llllllllllllllIIlIIIIIIIlIIIllll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.NORMAL, 3));
        llllllllllllllIIlIIIIIIIlIIIllll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.PADDING, 1));
        llllllllllllllIIlIIIIIIIlIIIllll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.PADDING, 2));
        llllllllllllllIIlIIIIIIIlIIIllll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 4));
        llllllllllllllIIlIIIIIIIlIIIllll.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 4));
    }
    
    public static VertexFormat makeDefVertexFormatItem() {
        final VertexFormat llllllllllllllIIlIIIIIIIlIIlIllI = new VertexFormat();
        llllllllllllllIIlIIIIIIIlIIlIllI.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.POSITION, 3));
        llllllllllllllIIlIIIIIIIlIIlIllI.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUseage.COLOR, 4));
        llllllllllllllIIlIIIIIIIlIIlIllI.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.UV, 2));
        llllllllllllllIIlIIIIIIIlIIlIllI.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 2));
        llllllllllllllIIlIIIIIIIlIIlIllI.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.NORMAL, 3));
        llllllllllllllIIlIIIIIIIlIIlIllI.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUseage.PADDING, 1));
        llllllllllllllIIlIIIIIIIlIIlIllI.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.PADDING, 2));
        llllllllllllllIIlIIIIIIIlIIlIllI.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 4));
        llllllllllllllIIlIIIIIIIlIIlIllI.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUseage.PADDING, 4));
        return llllllllllllllIIlIIIIIIIlIIlIllI;
    }
}
