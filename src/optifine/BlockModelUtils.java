package optifine;

import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import javax.vecmath.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.resources.model.*;
import java.util.*;

public class BlockModelUtils
{
    private static BakedQuad makeBakedQuad(final EnumFacing llllllllllllllIIlIlIIIIIllIIlIIl, final TextureAtlasSprite llllllllllllllIIlIlIIIIIllIIlIII, final int llllllllllllllIIlIlIIIIIllIlIlII) {
        final Vector3f llllllllllllllIIlIlIIIIIllIlIIll = new Vector3f(0.0f, 0.0f, 0.0f);
        final Vector3f llllllllllllllIIlIlIIIIIllIlIIlI = new Vector3f(16.0f, 16.0f, 16.0f);
        final BlockFaceUV llllllllllllllIIlIlIIIIIllIlIIIl = new BlockFaceUV(new float[] { 0.0f, 0.0f, 16.0f, 16.0f }, 0);
        final BlockPartFace llllllllllllllIIlIlIIIIIllIlIIII = new BlockPartFace(llllllllllllllIIlIlIIIIIllIIlIIl, llllllllllllllIIlIlIIIIIllIlIlII, String.valueOf(new StringBuilder("#").append(llllllllllllllIIlIlIIIIIllIIlIIl.getName())), llllllllllllllIIlIlIIIIIllIlIIIl);
        final ModelRotation llllllllllllllIIlIlIIIIIllIIllll = ModelRotation.X0_Y0;
        final Object llllllllllllllIIlIlIIIIIllIIlllI = null;
        final boolean llllllllllllllIIlIlIIIIIllIIllIl = false;
        final boolean llllllllllllllIIlIlIIIIIllIIllII = true;
        final FaceBakery llllllllllllllIIlIlIIIIIllIIlIll = new FaceBakery();
        final BakedQuad llllllllllllllIIlIlIIIIIllIIlIlI = llllllllllllllIIlIlIIIIIllIIlIll.func_178414_a(llllllllllllllIIlIlIIIIIllIlIIll, llllllllllllllIIlIlIIIIIllIlIIlI, llllllllllllllIIlIlIIIIIllIlIIII, llllllllllllllIIlIlIIIIIllIIlIII, llllllllllllllIIlIlIIIIIllIIlIIl, llllllllllllllIIlIlIIIIIllIIllll, (BlockPartRotation)llllllllllllllIIlIlIIIIIllIIlllI, llllllllllllllIIlIlIIIIIllIIllIl, llllllllllllllIIlIlIIIIIllIIllII);
        return llllllllllllllIIlIlIIIIIllIIlIlI;
    }
    
    public static IBakedModel makeModelCube(final TextureAtlasSprite llllllllllllllIIlIlIIIIIlllIlIll, final int llllllllllllllIIlIlIIIIIlllIlIlI) {
        final ArrayList llllllllllllllIIlIlIIIIIllllIIlI = new ArrayList();
        final EnumFacing[] llllllllllllllIIlIlIIIIIllllIIIl = EnumFacing.VALUES;
        final ArrayList llllllllllllllIIlIlIIIIIllllIIII = new ArrayList(llllllllllllllIIlIlIIIIIllllIIIl.length);
        for (int llllllllllllllIIlIlIIIIIlllIllll = 0; llllllllllllllIIlIlIIIIIlllIllll < llllllllllllllIIlIlIIIIIllllIIIl.length; ++llllllllllllllIIlIlIIIIIlllIllll) {
            final EnumFacing llllllllllllllIIlIlIIIIIlllIlllI = llllllllllllllIIlIlIIIIIllllIIIl[llllllllllllllIIlIlIIIIIlllIllll];
            final ArrayList llllllllllllllIIlIlIIIIIlllIllIl = new ArrayList();
            llllllllllllllIIlIlIIIIIlllIllIl.add(makeBakedQuad(llllllllllllllIIlIlIIIIIlllIlllI, llllllllllllllIIlIlIIIIIlllIlIll, llllllllllllllIIlIlIIIIIlllIlIlI));
            llllllllllllllIIlIlIIIIIllllIIII.add(llllllllllllllIIlIlIIIIIlllIllIl);
        }
        final SimpleBakedModel llllllllllllllIIlIlIIIIIlllIllII = new SimpleBakedModel(llllllllllllllIIlIlIIIIIllllIIlI, llllllllllllllIIlIlIIIIIllllIIII, true, true, llllllllllllllIIlIlIIIIIlllIlIll, ItemCameraTransforms.field_178357_a);
        return llllllllllllllIIlIlIIIIIlllIllII;
    }
    
    public static IBakedModel makeModelCube(final String llllllllllllllIIlIlIIIIIllllllll, final int llllllllllllllIIlIlIIIIlIIIIIIIl) {
        final TextureAtlasSprite llllllllllllllIIlIlIIIIlIIIIIIII = Config.getMinecraft().getTextureMapBlocks().getAtlasSprite(llllllllllllllIIlIlIIIIIllllllll);
        return makeModelCube(llllllllllllllIIlIlIIIIlIIIIIIII, llllllllllllllIIlIlIIIIlIIIIIIIl);
    }
}
