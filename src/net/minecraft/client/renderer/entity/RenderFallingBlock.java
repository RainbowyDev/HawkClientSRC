package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.util.*;

public class RenderFallingBlock extends Render
{
    public RenderFallingBlock(final RenderManager lllllllllllllllIIllllIlIIlllIIlI) {
        super(lllllllllllllllIIllllIlIIlllIIlI);
        this.shadowSize = 0.5f;
    }
    
    static {
        __OBFID = "CL_00000994";
    }
    
    public void doRender(final EntityFallingBlock lllllllllllllllIIllllIlIIlIlllII, final double lllllllllllllllIIllllIlIIlIIlIIl, final double lllllllllllllllIIllllIlIIlIIlIII, final double lllllllllllllllIIllllIlIIlIIIlll, final float lllllllllllllllIIllllIlIIlIIIllI, final float lllllllllllllllIIllllIlIIlIlIlll) {
        if (lllllllllllllllIIllllIlIIlIlllII.getBlock() != null) {
            this.bindTexture(TextureMap.locationBlocksTexture);
            final IBlockState lllllllllllllllIIllllIlIIlIlIllI = lllllllllllllllIIllllIlIIlIlllII.getBlock();
            final Block lllllllllllllllIIllllIlIIlIlIlIl = lllllllllllllllIIllllIlIIlIlIllI.getBlock();
            final BlockPos lllllllllllllllIIllllIlIIlIlIlII = new BlockPos(lllllllllllllllIIllllIlIIlIlllII);
            final World lllllllllllllllIIllllIlIIlIlIIll = lllllllllllllllIIllllIlIIlIlllII.getWorldObj();
            if (lllllllllllllllIIllllIlIIlIlIllI != lllllllllllllllIIllllIlIIlIlIIll.getBlockState(lllllllllllllllIIllllIlIIlIlIlII) && lllllllllllllllIIllllIlIIlIlIlIl.getRenderType() != -1 && lllllllllllllllIIllllIlIIlIlIlIl.getRenderType() == 3) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)lllllllllllllllIIllllIlIIlIIlIIl, (float)lllllllllllllllIIllllIlIIlIIlIII, (float)lllllllllllllllIIllllIlIIlIIIlll);
                GlStateManager.disableLighting();
                final Tessellator lllllllllllllllIIllllIlIIlIlIIlI = Tessellator.getInstance();
                final WorldRenderer lllllllllllllllIIllllIlIIlIlIIIl = lllllllllllllllIIllllIlIIlIlIIlI.getWorldRenderer();
                lllllllllllllllIIllllIlIIlIlIIIl.startDrawingQuads();
                lllllllllllllllIIllllIlIIlIlIIIl.setVertexFormat(DefaultVertexFormats.field_176600_a);
                final int lllllllllllllllIIllllIlIIlIlIIII = lllllllllllllllIIllllIlIIlIlIlII.getX();
                final int lllllllllllllllIIllllIlIIlIIllll = lllllllllllllllIIllllIlIIlIlIlII.getY();
                final int lllllllllllllllIIllllIlIIlIIlllI = lllllllllllllllIIllllIlIIlIlIlII.getZ();
                lllllllllllllllIIllllIlIIlIlIIIl.setTranslation(-lllllllllllllllIIllllIlIIlIlIIII - 0.5f, -lllllllllllllllIIllllIlIIlIIllll, -lllllllllllllllIIllllIlIIlIIlllI - 0.5f);
                final BlockRendererDispatcher lllllllllllllllIIllllIlIIlIIllIl = Minecraft.getMinecraft().getBlockRendererDispatcher();
                final IBakedModel lllllllllllllllIIllllIlIIlIIllII = lllllllllllllllIIllllIlIIlIIllIl.getModelFromBlockState(lllllllllllllllIIllllIlIIlIlIllI, lllllllllllllllIIllllIlIIlIlIIll, null);
                lllllllllllllllIIllllIlIIlIIllIl.func_175019_b().renderBlockModel(lllllllllllllllIIllllIlIIlIlIIll, lllllllllllllllIIllllIlIIlIIllII, lllllllllllllllIIllllIlIIlIlIllI, lllllllllllllllIIllllIlIIlIlIlII, lllllllllllllllIIllllIlIIlIlIIIl, false);
                lllllllllllllllIIllllIlIIlIlIIIl.setTranslation(0.0, 0.0, 0.0);
                lllllllllllllllIIllllIlIIlIlIIlI.draw();
                GlStateManager.enableLighting();
                GlStateManager.popMatrix();
                super.doRender(lllllllllllllllIIllllIlIIlIlllII, lllllllllllllllIIllllIlIIlIIlIIl, lllllllllllllllIIllllIlIIlIIlIII, lllllllllllllllIIllllIlIIlIIIlll, lllllllllllllllIIllllIlIIlIIIllI, lllllllllllllllIIllllIlIIlIlIlll);
            }
        }
    }
    
    protected ResourceLocation getEntityTexture(final EntityFallingBlock lllllllllllllllIIllllIlIIIlllIII) {
        return TextureMap.locationBlocksTexture;
    }
    
    @Override
    public void doRender(final Entity lllllllllllllllIIllllIlIIIlIlIIl, final double lllllllllllllllIIllllIlIIIlIIIIl, final double lllllllllllllllIIllllIlIIIlIIIII, final double lllllllllllllllIIllllIlIIIIlllll, final float lllllllllllllllIIllllIlIIIIllllI, final float lllllllllllllllIIllllIlIIIlIIlII) {
        this.doRender((EntityFallingBlock)lllllllllllllllIIllllIlIIIlIlIIl, lllllllllllllllIIllllIlIIIlIIIIl, lllllllllllllllIIllllIlIIIlIIIII, lllllllllllllllIIllllIlIIIIlllll, lllllllllllllllIIllllIlIIIIllllI, lllllllllllllllIIllllIlIIIlIIlII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllllIIllllIlIIIllIlII) {
        return this.getEntityTexture((EntityFallingBlock)lllllllllllllllIIllllIlIIIllIlII);
    }
}
