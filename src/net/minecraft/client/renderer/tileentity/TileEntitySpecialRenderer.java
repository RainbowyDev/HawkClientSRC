package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.tileentity.*;

public abstract class TileEntitySpecialRenderer
{
    protected /* synthetic */ TileEntityRendererDispatcher rendererDispatcher;
    
    static {
        __OBFID = "CL_00000964";
        DESTROY_STAGES = new ResourceLocation[] { new ResourceLocation("textures/blocks/destroy_stage_0.png"), new ResourceLocation("textures/blocks/destroy_stage_1.png"), new ResourceLocation("textures/blocks/destroy_stage_2.png"), new ResourceLocation("textures/blocks/destroy_stage_3.png"), new ResourceLocation("textures/blocks/destroy_stage_4.png"), new ResourceLocation("textures/blocks/destroy_stage_5.png"), new ResourceLocation("textures/blocks/destroy_stage_6.png"), new ResourceLocation("textures/blocks/destroy_stage_7.png"), new ResourceLocation("textures/blocks/destroy_stage_8.png"), new ResourceLocation("textures/blocks/destroy_stage_9.png") };
    }
    
    public void setRendererDispatcher(final TileEntityRendererDispatcher llllllllllllllIlIIIIlIIllllIlIII) {
        this.rendererDispatcher = llllllllllllllIlIIIIlIIllllIlIII;
    }
    
    protected World getWorld() {
        return this.rendererDispatcher.worldObj;
    }
    
    public FontRenderer getFontRenderer() {
        return this.rendererDispatcher.getFontRenderer();
    }
    
    protected void bindTexture(final ResourceLocation llllllllllllllIlIIIIlIIlllllIIII) {
        final TextureManager llllllllllllllIlIIIIlIIlllllIIlI = this.rendererDispatcher.renderEngine;
        if (llllllllllllllIlIIIIlIIlllllIIlI != null) {
            llllllllllllllIlIIIIlIIlllllIIlI.bindTexture(llllllllllllllIlIIIIlIIlllllIIII);
        }
    }
    
    public abstract void renderTileEntityAt(final TileEntity p0, final double p1, final double p2, final double p3, final float p4, final int p5);
}
