package net.minecraft.client.renderer.tileentity;

import net.minecraft.tileentity.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;

public class TileEntityPistonRenderer extends TileEntitySpecialRenderer
{
    private final /* synthetic */ BlockRendererDispatcher field_178462_c;
    
    @Override
    public void renderTileEntityAt(final TileEntity lllllllllllllllIlIIllIlIIllIIIIl, final double lllllllllllllllIlIIllIlIIllIIIII, final double lllllllllllllllIlIIllIlIIlIlllll, final double lllllllllllllllIlIIllIlIIlIlIlll, final float lllllllllllllllIlIIllIlIIlIlIllI, final int lllllllllllllllIlIIllIlIIlIlllII) {
        this.func_178461_a((TileEntityPiston)lllllllllllllllIlIIllIlIIllIIIIl, lllllllllllllllIlIIllIlIIllIIIII, lllllllllllllllIlIIllIlIIlIlllll, lllllllllllllllIlIIllIlIIlIlIlll, lllllllllllllllIlIIllIlIIlIlIllI, lllllllllllllllIlIIllIlIIlIlllII);
    }
    
    static {
        __OBFID = "CL_00002469";
    }
    
    public void func_178461_a(final TileEntityPiston lllllllllllllllIlIIllIlIIlllIllI, final double lllllllllllllllIlIIllIlIlIIIIlII, final double lllllllllllllllIlIIllIlIlIIIIIll, final double lllllllllllllllIlIIllIlIlIIIIIlI, final float lllllllllllllllIlIIllIlIlIIIIIIl, final int lllllllllllllllIlIIllIlIlIIIIIII) {
        final BlockPos lllllllllllllllIlIIllIlIIlllllll = lllllllllllllllIlIIllIlIIlllIllI.getPos();
        IBlockState lllllllllllllllIlIIllIlIIllllllI = lllllllllllllllIlIIllIlIIlllIllI.func_174927_b();
        final Block lllllllllllllllIlIIllIlIIlllllIl = lllllllllllllllIlIIllIlIIllllllI.getBlock();
        if (lllllllllllllllIlIIllIlIIlllllIl.getMaterial() != Material.air && lllllllllllllllIlIIllIlIIlllIllI.func_145860_a(lllllllllllllllIlIIllIlIlIIIIIIl) < 1.0f) {
            final Tessellator lllllllllllllllIlIIllIlIIlllllII = Tessellator.getInstance();
            final WorldRenderer lllllllllllllllIlIIllIlIIllllIll = lllllllllllllllIlIIllIlIIlllllII.getWorldRenderer();
            this.bindTexture(TextureMap.locationBlocksTexture);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.enableBlend();
            GlStateManager.disableCull();
            if (Minecraft.isAmbientOcclusionEnabled()) {
                GlStateManager.shadeModel(7425);
            }
            else {
                GlStateManager.shadeModel(7424);
            }
            lllllllllllllllIlIIllIlIIllllIll.startDrawingQuads();
            lllllllllllllllIlIIllIlIIllllIll.setVertexFormat(DefaultVertexFormats.field_176600_a);
            lllllllllllllllIlIIllIlIIllllIll.setTranslation((float)lllllllllllllllIlIIllIlIlIIIIlII - lllllllllllllllIlIIllIlIIlllllll.getX() + lllllllllllllllIlIIllIlIIlllIllI.func_174929_b(lllllllllllllllIlIIllIlIlIIIIIIl), (float)lllllllllllllllIlIIllIlIlIIIIIll - lllllllllllllllIlIIllIlIIlllllll.getY() + lllllllllllllllIlIIllIlIIlllIllI.func_174928_c(lllllllllllllllIlIIllIlIlIIIIIIl), (float)lllllllllllllllIlIIllIlIlIIIIIlI - lllllllllllllllIlIIllIlIIlllllll.getZ() + lllllllllllllllIlIIllIlIIlllIllI.func_174926_d(lllllllllllllllIlIIllIlIlIIIIIIl));
            lllllllllllllllIlIIllIlIIllllIll.func_178986_b(1.0f, 1.0f, 1.0f);
            final World lllllllllllllllIlIIllIlIIllllIlI = this.getWorld();
            if (lllllllllllllllIlIIllIlIIlllllIl == Blocks.piston_head && lllllllllllllllIlIIllIlIIlllIllI.func_145860_a(lllllllllllllllIlIIllIlIlIIIIIIl) < 0.5f) {
                lllllllllllllllIlIIllIlIIllllllI = lllllllllllllllIlIIllIlIIllllllI.withProperty(BlockPistonExtension.field_176327_M, true);
                this.field_178462_c.func_175019_b().renderBlockModel(lllllllllllllllIlIIllIlIIllllIlI, this.field_178462_c.getModelFromBlockState(lllllllllllllllIlIIllIlIIllllllI, lllllllllllllllIlIIllIlIIllllIlI, lllllllllllllllIlIIllIlIIlllllll), lllllllllllllllIlIIllIlIIllllllI, lllllllllllllllIlIIllIlIIlllllll, lllllllllllllllIlIIllIlIIllllIll, true);
            }
            else if (lllllllllllllllIlIIllIlIIlllIllI.shouldPistonHeadBeRendered() && !lllllllllllllllIlIIllIlIIlllIllI.isExtending()) {
                final BlockPistonExtension.EnumPistonType lllllllllllllllIlIIllIlIIllllIIl = (lllllllllllllllIlIIllIlIIlllllIl == Blocks.sticky_piston) ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT;
                IBlockState lllllllllllllllIlIIllIlIIllllIII = Blocks.piston_head.getDefaultState().withProperty(BlockPistonExtension.field_176325_b, lllllllllllllllIlIIllIlIIllllIIl).withProperty(BlockPistonExtension.field_176326_a, lllllllllllllllIlIIllIlIIllllllI.getValue(BlockPistonBase.FACING));
                lllllllllllllllIlIIllIlIIllllIII = lllllllllllllllIlIIllIlIIllllIII.withProperty(BlockPistonExtension.field_176327_M, lllllllllllllllIlIIllIlIIlllIllI.func_145860_a(lllllllllllllllIlIIllIlIlIIIIIIl) >= 0.5f);
                this.field_178462_c.func_175019_b().renderBlockModel(lllllllllllllllIlIIllIlIIllllIlI, this.field_178462_c.getModelFromBlockState(lllllllllllllllIlIIllIlIIllllIII, lllllllllllllllIlIIllIlIIllllIlI, lllllllllllllllIlIIllIlIIlllllll), lllllllllllllllIlIIllIlIIllllIII, lllllllllllllllIlIIllIlIIlllllll, lllllllllllllllIlIIllIlIIllllIll, true);
                lllllllllllllllIlIIllIlIIllllIll.setTranslation((float)lllllllllllllllIlIIllIlIlIIIIlII - lllllllllllllllIlIIllIlIIlllllll.getX(), (float)lllllllllllllllIlIIllIlIlIIIIIll - lllllllllllllllIlIIllIlIIlllllll.getY(), (float)lllllllllllllllIlIIllIlIlIIIIIlI - lllllllllllllllIlIIllIlIIlllllll.getZ());
                lllllllllllllllIlIIllIlIIllllllI.withProperty(BlockPistonBase.EXTENDED, true);
                this.field_178462_c.func_175019_b().renderBlockModel(lllllllllllllllIlIIllIlIIllllIlI, this.field_178462_c.getModelFromBlockState(lllllllllllllllIlIIllIlIIllllllI, lllllllllllllllIlIIllIlIIllllIlI, lllllllllllllllIlIIllIlIIlllllll), lllllllllllllllIlIIllIlIIllllllI, lllllllllllllllIlIIllIlIIlllllll, lllllllllllllllIlIIllIlIIllllIll, true);
            }
            else {
                this.field_178462_c.func_175019_b().renderBlockModel(lllllllllllllllIlIIllIlIIllllIlI, this.field_178462_c.getModelFromBlockState(lllllllllllllllIlIIllIlIIllllllI, lllllllllllllllIlIIllIlIIllllIlI, lllllllllllllllIlIIllIlIIlllllll), lllllllllllllllIlIIllIlIIllllllI, lllllllllllllllIlIIllIlIIlllllll, lllllllllllllllIlIIllIlIIllllIll, false);
            }
            lllllllllllllllIlIIllIlIIllllIll.setTranslation(0.0, 0.0, 0.0);
            lllllllllllllllIlIIllIlIIlllllII.draw();
            RenderHelper.enableStandardItemLighting();
        }
    }
    
    public TileEntityPistonRenderer() {
        this.field_178462_c = Minecraft.getMinecraft().getBlockRendererDispatcher();
    }
}
