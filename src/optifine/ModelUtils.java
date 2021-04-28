package optifine;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.client.resources.model.*;

public class ModelUtils
{
    private static void dbgQuads(final String llllllllllllllIlllIIIllIIIlIllIl, final List llllllllllllllIlllIIIllIIIlIllII, final String llllllllllllllIlllIIIllIIIlIIllI) {
        for (final BakedQuad llllllllllllllIlllIIIllIIIlIlIIl : llllllllllllllIlllIIIllIIIlIllII) {
            dbgQuad(llllllllllllllIlllIIIllIIIlIllIl, llllllllllllllIlllIIIllIIIlIlIIl, llllllllllllllIlllIIIllIIIlIIllI);
        }
    }
    
    public static void dbgModel(final IBakedModel llllllllllllllIlllIIIllIIIllIlll) {
        if (llllllllllllllIlllIIIllIIIllIlll != null) {
            Config.dbg(String.valueOf(new StringBuilder("Model: ").append(llllllllllllllIlllIIIllIIIllIlll).append(", ao: ").append(llllllllllllllIlllIIIllIIIllIlll.isGui3d()).append(", gui3d: ").append(llllllllllllllIlllIIIllIIIllIlll.isAmbientOcclusionEnabled()).append(", builtIn: ").append(llllllllllllllIlllIIIllIIIllIlll.isBuiltInRenderer()).append(", particle: ").append(llllllllllllllIlllIIIllIIIllIlll.getTexture())));
            final EnumFacing[] llllllllllllllIlllIIIllIIIllllII = EnumFacing.VALUES;
            for (int llllllllllllllIlllIIIllIIIlllIll = 0; llllllllllllllIlllIIIllIIIlllIll < llllllllllllllIlllIIIllIIIllllII.length; ++llllllllllllllIlllIIIllIIIlllIll) {
                final EnumFacing llllllllllllllIlllIIIllIIIlllIlI = llllllllllllllIlllIIIllIIIllllII[llllllllllllllIlllIIIllIIIlllIll];
                final List llllllllllllllIlllIIIllIIIlllIIl = llllllllllllllIlllIIIllIIIllIlll.func_177551_a(llllllllllllllIlllIIIllIIIlllIlI);
                dbgQuads(llllllllllllllIlllIIIllIIIlllIlI.getName(), llllllllllllllIlllIIIllIIIlllIIl, "  ");
            }
            final List llllllllllllllIlllIIIllIIIlllIII = llllllllllllllIlllIIIllIIIllIlll.func_177550_a();
            dbgQuads("General", llllllllllllllIlllIIIllIIIlllIII, "  ");
        }
    }
    
    public static void dbgVertexData(final int[] llllllllllllllIlllIIIllIIIIIIlII, final String llllllllllllllIlllIIIllIIIIIlllI) {
        final int llllllllllllllIlllIIIllIIIIIllIl = llllllllllllllIlllIIIllIIIIIIlII.length / 4;
        Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIIllIIIIIlllI)).append("Length: ").append(llllllllllllllIlllIIIllIIIIIIlII.length).append(", step: ").append(llllllllllllllIlllIIIllIIIIIllIl)));
        for (int llllllllllllllIlllIIIllIIIIIllII = 0; llllllllllllllIlllIIIllIIIIIllII < 4; ++llllllllllllllIlllIIIllIIIIIllII) {
            final int llllllllllllllIlllIIIllIIIIIlIll = llllllllllllllIlllIIIllIIIIIllII * llllllllllllllIlllIIIllIIIIIllIl;
            final float llllllllllllllIlllIIIllIIIIIlIlI = Float.intBitsToFloat(llllllllllllllIlllIIIllIIIIIIlII[llllllllllllllIlllIIIllIIIIIlIll + 0]);
            final float llllllllllllllIlllIIIllIIIIIlIIl = Float.intBitsToFloat(llllllllllllllIlllIIIllIIIIIIlII[llllllllllllllIlllIIIllIIIIIlIll + 1]);
            final float llllllllllllllIlllIIIllIIIIIlIII = Float.intBitsToFloat(llllllllllllllIlllIIIllIIIIIIlII[llllllllllllllIlllIIIllIIIIIlIll + 2]);
            final int llllllllllllllIlllIIIllIIIIIIlll = llllllllllllllIlllIIIllIIIIIIlII[llllllllllllllIlllIIIllIIIIIlIll + 3];
            final float llllllllllllllIlllIIIllIIIIIIllI = Float.intBitsToFloat(llllllllllllllIlllIIIllIIIIIIlII[llllllllllllllIlllIIIllIIIIIlIll + 4]);
            final float llllllllllllllIlllIIIllIIIIIIlIl = Float.intBitsToFloat(llllllllllllllIlllIIIllIIIIIIlII[llllllllllllllIlllIIIllIIIIIlIll + 5]);
            Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIIllIIIIIlllI)).append(llllllllllllllIlllIIIllIIIIIllII).append(" xyz: ").append(llllllllllllllIlllIIIllIIIIIlIlI).append(",").append(llllllllllllllIlllIIIllIIIIIlIIl).append(",").append(llllllllllllllIlllIIIllIIIIIlIII).append(" col: ").append(llllllllllllllIlllIIIllIIIIIIlll).append(" u,v: ").append(llllllllllllllIlllIIIllIIIIIIllI).append(",").append(llllllllllllllIlllIIIllIIIIIIlIl)));
        }
    }
    
    public static BakedQuad duplicateQuad(final BakedQuad llllllllllllllIlllIIIlIlllIIllIl) {
        final BakedQuad llllllllllllllIlllIIIlIlllIIlllI = new BakedQuad(llllllllllllllIlllIIIlIlllIIllIl.func_178209_a().clone(), llllllllllllllIlllIIIlIlllIIllIl.func_178211_c(), llllllllllllllIlllIIIlIlllIIllIl.getFace(), llllllllllllllIlllIIIlIlllIIllIl.getSprite());
        return llllllllllllllIlllIIIlIlllIIlllI;
    }
    
    public static IBakedModel duplicateModel(final IBakedModel llllllllllllllIlllIIIlIllllIlIII) {
        final List llllllllllllllIlllIIIlIlllllIIII = duplicateQuadList(llllllllllllllIlllIIIlIllllIlIII.func_177550_a());
        final EnumFacing[] llllllllllllllIlllIIIlIllllIllll = EnumFacing.VALUES;
        final ArrayList llllllllllllllIlllIIIlIllllIlllI = new ArrayList();
        for (int llllllllllllllIlllIIIlIllllIllIl = 0; llllllllllllllIlllIIIlIllllIllIl < llllllllllllllIlllIIIlIllllIllll.length; ++llllllllllllllIlllIIIlIllllIllIl) {
            final EnumFacing llllllllllllllIlllIIIlIllllIllII = llllllllllllllIlllIIIlIllllIllll[llllllllllllllIlllIIIlIllllIllIl];
            final List llllllllllllllIlllIIIlIllllIlIll = llllllllllllllIlllIIIlIllllIlIII.func_177551_a(llllllllllllllIlllIIIlIllllIllII);
            final List llllllllllllllIlllIIIlIllllIlIlI = duplicateQuadList(llllllllllllllIlllIIIlIllllIlIll);
            llllllllllllllIlllIIIlIllllIlllI.add(llllllllllllllIlllIIIlIllllIlIlI);
        }
        final SimpleBakedModel llllllllllllllIlllIIIlIllllIlIIl = new SimpleBakedModel(llllllllllllllIlllIIIlIlllllIIII, llllllllllllllIlllIIIlIllllIlllI, llllllllllllllIlllIIIlIllllIlIII.isGui3d(), llllllllllllllIlllIIIlIllllIlIII.isAmbientOcclusionEnabled(), llllllllllllllIlllIIIlIllllIlIII.getTexture(), llllllllllllllIlllIIIlIllllIlIII.getItemCameraTransforms());
        return llllllllllllllIlllIIIlIllllIlIIl;
    }
    
    public static void dbgQuad(final String llllllllllllllIlllIIIllIIIlIIIII, final BakedQuad llllllllllllllIlllIIIllIIIIlllII, final String llllllllllllllIlllIIIllIIIIllllI) {
        Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIIllIIIIllllI)).append("Quad: ").append(llllllllllllllIlllIIIllIIIIlllII.getClass().getName()).append(", type: ").append(llllllllllllllIlllIIIllIIIlIIIII).append(", face: ").append(llllllllllllllIlllIIIllIIIIlllII.getFace()).append(", tint: ").append(llllllllllllllIlllIIIllIIIIlllII.func_178211_c()).append(", sprite: ").append(llllllllllllllIlllIIIllIIIIlllII.getSprite())));
        dbgVertexData(llllllllllllllIlllIIIllIIIIlllII.func_178209_a(), String.valueOf(new StringBuilder("  ").append(llllllllllllllIlllIIIllIIIIllllI)));
    }
    
    public static List duplicateQuadList(final List llllllllllllllIlllIIIlIlllIlIllI) {
        final ArrayList llllllllllllllIlllIIIlIlllIllIlI = new ArrayList();
        for (final BakedQuad llllllllllllllIlllIIIlIlllIllIII : llllllllllllllIlllIIIlIlllIlIllI) {
            final BakedQuad llllllllllllllIlllIIIlIlllIlIlll = duplicateQuad(llllllllllllllIlllIIIlIlllIllIII);
            llllllllllllllIlllIIIlIlllIllIlI.add(llllllllllllllIlllIIIlIlllIlIlll);
        }
        return llllllllllllllIlllIIIlIlllIllIlI;
    }
}
