package net.minecraft.client.renderer;

import net.minecraft.util.*;
import net.minecraft.client.renderer.chunk.*;
import org.lwjgl.opengl.*;
import optifine.*;
import java.util.*;

public class RenderList extends ChunkRenderContainer
{
    @Override
    public void func_178001_a(final EnumWorldBlockLayer llllllllllllllllIIllIlIIIlllIlIl) {
        if (this.field_178007_b) {
            if (this.field_178009_a.size() == 0) {
                return;
            }
            for (final RenderChunk llllllllllllllllIIllIlIIIllllIII : this.field_178009_a) {
                final ListedRenderChunk llllllllllllllllIIllIlIIIlllIlll = (ListedRenderChunk)llllllllllllllllIIllIlIIIllllIII;
                GlStateManager.pushMatrix();
                this.func_178003_a(llllllllllllllllIIllIlIIIllllIII);
                GL11.glCallList(llllllllllllllllIIllIlIIIlllIlll.func_178600_a(llllllllllllllllIIllIlIIIlllIlIl, llllllllllllllllIIllIlIIIlllIlll.func_178571_g()));
                GlStateManager.popMatrix();
            }
            if (Config.isMultiTexture()) {
                GlStateManager.bindCurrentTexture();
            }
            GlStateManager.func_179117_G();
            this.field_178009_a.clear();
        }
    }
}
