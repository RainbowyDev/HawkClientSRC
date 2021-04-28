package hawk.util;

import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class RenderUtil
{
    public static void drawBoundingBox(final AxisAlignedBB lIIlllIllllII, final float lIIlllIlllIll, final float lIIlllIlllIlI, final float lIIllllIIIIIl, final float lIIlllIlllIII) {
        final int lIIlllIllllll = 3;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4d((double)lIIlllIlllIll, (double)lIIlllIlllIlI, (double)lIIllllIIIIIl, (double)lIIlllIlllIII);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glLineWidth(3.0f);
        GL11.glEnable(2848);
        final Tessellator lIIlllIlllllI = Tessellator.getInstance();
        final WorldRenderer lIIlllIllllIl = lIIlllIlllllI.getWorldRenderer();
        lIIlllIllllIl.startDrawing(lIIlllIllllll);
        lIIlllIllllIl.addVertex(lIIlllIllllII.minX, lIIlllIllllII.minY, lIIlllIllllII.minZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.minX, lIIlllIllllII.minY, lIIlllIllllII.maxZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.maxX, lIIlllIllllII.minY, lIIlllIllllII.maxZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.maxX, lIIlllIllllII.minY, lIIlllIllllII.minZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.minX, lIIlllIllllII.minY, lIIlllIllllII.minZ);
        lIIlllIlllllI.draw();
        lIIlllIllllIl.startDrawing(lIIlllIllllll);
        lIIlllIllllIl.addVertex(lIIlllIllllII.maxX, lIIlllIllllII.maxY, lIIlllIllllII.maxZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.maxX, lIIlllIllllII.maxY, lIIlllIllllII.minZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.minX, lIIlllIllllII.maxY, lIIlllIllllII.minZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.minX, lIIlllIllllII.maxY, lIIlllIllllII.maxZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.maxX, lIIlllIllllII.maxY, lIIlllIllllII.maxZ);
        lIIlllIlllllI.draw();
        lIIlllIllllIl.startDrawing(lIIlllIllllll);
        lIIlllIllllIl.addVertex(lIIlllIllllII.minX, lIIlllIllllII.minY, lIIlllIllllII.minZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.minX, lIIlllIllllII.maxY, lIIlllIllllII.minZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.maxX, lIIlllIllllII.maxY, lIIlllIllllII.minZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.maxX, lIIlllIllllII.minY, lIIlllIllllII.minZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.minX, lIIlllIllllII.minY, lIIlllIllllII.minZ);
        lIIlllIlllllI.draw();
        lIIlllIllllIl.startDrawing(lIIlllIllllll);
        lIIlllIllllIl.addVertex(lIIlllIllllII.minX, lIIlllIllllII.minY, lIIlllIllllII.maxZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.minX, lIIlllIllllII.maxY, lIIlllIllllII.maxZ);
        lIIlllIlllllI.draw();
        lIIlllIllllIl.startDrawing(lIIlllIllllll);
        lIIlllIllllIl.addVertex(lIIlllIllllII.maxX, lIIlllIllllII.minY, lIIlllIllllII.maxZ);
        lIIlllIllllIl.addVertex(lIIlllIllllII.maxX, lIIlllIllllII.maxY, lIIlllIllllII.maxZ);
        lIIlllIlllllI.draw();
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
}
