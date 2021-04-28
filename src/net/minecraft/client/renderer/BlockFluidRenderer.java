package net.minecraft.client.renderer;

import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import optifine.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;

public class BlockFluidRenderer
{
    private /* synthetic */ TextureAtlasSprite[] field_178271_b;
    private /* synthetic */ TextureAtlasSprite[] field_178272_a;
    
    public BlockFluidRenderer() {
        this.field_178272_a = new TextureAtlasSprite[2];
        this.field_178271_b = new TextureAtlasSprite[2];
        this.func_178268_a();
    }
    
    protected void func_178268_a() {
        final TextureMap llllllllllllllllIIllIllIllllllII = Minecraft.getMinecraft().getTextureMapBlocks();
        this.field_178272_a[0] = llllllllllllllllIIllIllIllllllII.getAtlasSprite("minecraft:blocks/lava_still");
        this.field_178272_a[1] = llllllllllllllllIIllIllIllllllII.getAtlasSprite("minecraft:blocks/lava_flow");
        this.field_178271_b[0] = llllllllllllllllIIllIllIllllllII.getAtlasSprite("minecraft:blocks/water_still");
        this.field_178271_b[1] = llllllllllllllllIIllIllIllllllII.getAtlasSprite("minecraft:blocks/water_flow");
    }
    
    static {
        __OBFID = "CL_00002519";
    }
    
    public boolean func_178270_a(final IBlockAccess llllllllllllllllIIllIllIllIIIlIl, final IBlockState llllllllllllllllIIllIllIllIIIlII, final BlockPos llllllllllllllllIIllIllIIllIlIlI, final WorldRenderer llllllllllllllllIIllIllIIllIlIIl) {
        final BlockLiquid llllllllllllllllIIllIllIllIIIIIl = (BlockLiquid)llllllllllllllllIIllIllIllIIIlII.getBlock();
        llllllllllllllllIIllIllIllIIIIIl.setBlockBoundsBasedOnState(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI);
        final TextureAtlasSprite[] llllllllllllllllIIllIllIllIIIIII = (llllllllllllllllIIllIllIllIIIIIl.getMaterial() == Material.lava) ? this.field_178272_a : this.field_178271_b;
        final RenderEnv llllllllllllllllIIllIllIlIllllll = RenderEnv.getInstance(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIllIIIlII, llllllllllllllllIIllIllIIllIlIlI);
        final int llllllllllllllllIIllIllIlIlllllI = CustomColors.getFluidColor(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIllIIIlII, llllllllllllllllIIllIllIIllIlIlI, llllllllllllllllIIllIllIlIllllll);
        final float llllllllllllllllIIllIllIlIllllIl = (llllllllllllllllIIllIllIlIlllllI >> 16 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllIllIlIllllII = (llllllllllllllllIIllIllIlIlllllI >> 8 & 0xFF) / 255.0f;
        final float llllllllllllllllIIllIllIlIlllIll = (llllllllllllllllIIllIllIlIlllllI & 0xFF) / 255.0f;
        final boolean llllllllllllllllIIllIllIlIlllIlI = llllllllllllllllIIllIllIllIIIIIl.shouldSideBeRendered(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetUp(), EnumFacing.UP);
        final boolean llllllllllllllllIIllIllIlIlllIIl = llllllllllllllllIIllIllIllIIIIIl.shouldSideBeRendered(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetDown(), EnumFacing.DOWN);
        final boolean[] llllllllllllllllIIllIllIlIlllIII = llllllllllllllllIIllIllIlIllllll.getBorderFlags();
        llllllllllllllllIIllIllIlIlllIII[0] = llllllllllllllllIIllIllIllIIIIIl.shouldSideBeRendered(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetNorth(), EnumFacing.NORTH);
        llllllllllllllllIIllIllIlIlllIII[1] = llllllllllllllllIIllIllIllIIIIIl.shouldSideBeRendered(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetSouth(), EnumFacing.SOUTH);
        llllllllllllllllIIllIllIlIlllIII[2] = llllllllllllllllIIllIllIllIIIIIl.shouldSideBeRendered(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetWest(), EnumFacing.WEST);
        llllllllllllllllIIllIllIlIlllIII[3] = llllllllllllllllIIllIllIllIIIIIl.shouldSideBeRendered(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetEast(), EnumFacing.EAST);
        if (!llllllllllllllllIIllIllIlIlllIlI && !llllllllllllllllIIllIllIlIlllIIl && !llllllllllllllllIIllIllIlIlllIII[0] && !llllllllllllllllIIllIllIlIlllIII[1] && !llllllllllllllllIIllIllIlIlllIII[2] && !llllllllllllllllIIllIllIlIlllIII[3]) {
            return false;
        }
        boolean llllllllllllllllIIllIllIlIllIlll = false;
        final float llllllllllllllllIIllIllIlIllIllI = 0.5f;
        final float llllllllllllllllIIllIllIlIllIlIl = 1.0f;
        final float llllllllllllllllIIllIllIlIllIlII = 0.8f;
        final float llllllllllllllllIIllIllIlIllIIll = 0.6f;
        final Material llllllllllllllllIIllIllIlIllIIlI = llllllllllllllllIIllIllIllIIIIIl.getMaterial();
        float llllllllllllllllIIllIllIlIllIIIl = this.func_178269_a(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI, llllllllllllllllIIllIllIlIllIIlI);
        float llllllllllllllllIIllIllIlIllIIII = this.func_178269_a(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetSouth(), llllllllllllllllIIllIllIlIllIIlI);
        float llllllllllllllllIIllIllIlIlIllll = this.func_178269_a(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetEast().offsetSouth(), llllllllllllllllIIllIllIlIllIIlI);
        float llllllllllllllllIIllIllIlIlIlllI = this.func_178269_a(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetEast(), llllllllllllllllIIllIllIlIllIIlI);
        final double llllllllllllllllIIllIllIlIlIllIl = llllllllllllllllIIllIllIIllIlIlI.getX();
        final double llllllllllllllllIIllIllIlIlIllII = llllllllllllllllIIllIllIIllIlIlI.getY();
        final double llllllllllllllllIIllIllIlIlIlIll = llllllllllllllllIIllIllIIllIlIlI.getZ();
        final float llllllllllllllllIIllIllIlIlIlIlI = 0.001f;
        if (llllllllllllllllIIllIllIlIlllIlI) {
            llllllllllllllllIIllIllIlIllIlll = true;
            TextureAtlasSprite llllllllllllllllIIllIllIlIlIlIIl = llllllllllllllllIIllIllIllIIIIII[0];
            final float llllllllllllllllIIllIllIlIlIIlll = (float)BlockLiquid.func_180689_a(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI, llllllllllllllllIIllIllIlIllIIlI);
            if (llllllllllllllllIIllIllIlIlIIlll > -999.0f) {
                llllllllllllllllIIllIllIlIlIlIIl = llllllllllllllllIIllIllIllIIIIII[1];
            }
            llllllllllllllllIIllIllIIllIlIIl.setSprite(llllllllllllllllIIllIllIlIlIlIIl);
            llllllllllllllllIIllIllIlIllIIIl -= llllllllllllllllIIllIllIlIlIlIlI;
            llllllllllllllllIIllIllIlIllIIII -= llllllllllllllllIIllIllIlIlIlIlI;
            llllllllllllllllIIllIllIlIlIllll -= llllllllllllllllIIllIllIlIlIlIlI;
            llllllllllllllllIIllIllIlIlIlllI -= llllllllllllllllIIllIllIlIlIlIlI;
            float llllllllllllllllIIllIllIlIlIIlII = 0.0f;
            float llllllllllllllllIIllIllIlIIlIlIl = 0.0f;
            float llllllllllllllllIIllIllIlIlIIIIl = 0.0f;
            float llllllllllllllllIIllIllIlIIIllll = 0.0f;
            float llllllllllllllllIIllIllIlIIllllI = 0.0f;
            float llllllllllllllllIIllIllIlIIIllIl = 0.0f;
            float llllllllllllllllIIllIllIlIIllIll = 0.0f;
            float llllllllllllllllIIllIllIlIIIlIll = 0.0f;
            if (llllllllllllllllIIllIllIlIlIIlll < -999.0f) {
                final float llllllllllllllllIIllIllIlIlIIlIl = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedU(0.0);
                final float llllllllllllllllIIllIllIlIIlIllI = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedV(0.0);
                final float llllllllllllllllIIllIllIlIlIIIlI = llllllllllllllllIIllIllIlIlIIlIl;
                final float llllllllllllllllIIllIllIlIIlIIII = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedV(16.0);
                final float llllllllllllllllIIllIllIlIIlllll = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedU(16.0);
                final float llllllllllllllllIIllIllIlIIIlllI = llllllllllllllllIIllIllIlIIlIIII;
                final float llllllllllllllllIIllIllIlIIlllII = llllllllllllllllIIllIllIlIIlllll;
                final float llllllllllllllllIIllIllIlIIIllII = llllllllllllllllIIllIllIlIIlIllI;
            }
            else {
                final float llllllllllllllllIIllIllIlIIIlIlI = MathHelper.sin(llllllllllllllllIIllIllIlIlIIlll) * 0.25f;
                final float llllllllllllllllIIllIllIlIIIlIIl = MathHelper.cos(llllllllllllllllIIllIllIlIlIIlll) * 0.25f;
                final float llllllllllllllllIIllIllIlIIIlIII = 8.0f;
                llllllllllllllllIIllIllIlIlIIlII = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedU(8.0f + (-llllllllllllllllIIllIllIlIIIlIIl - llllllllllllllllIIllIllIlIIIlIlI) * 16.0f);
                llllllllllllllllIIllIllIlIIlIlIl = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedV(8.0f + (-llllllllllllllllIIllIllIlIIIlIIl + llllllllllllllllIIllIllIlIIIlIlI) * 16.0f);
                llllllllllllllllIIllIllIlIlIIIIl = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedU(8.0f + (-llllllllllllllllIIllIllIlIIIlIIl + llllllllllllllllIIllIllIlIIIlIlI) * 16.0f);
                llllllllllllllllIIllIllIlIIIllll = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedV(8.0f + (llllllllllllllllIIllIllIlIIIlIIl + llllllllllllllllIIllIllIlIIIlIlI) * 16.0f);
                llllllllllllllllIIllIllIlIIllllI = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedU(8.0f + (llllllllllllllllIIllIllIlIIIlIIl + llllllllllllllllIIllIllIlIIIlIlI) * 16.0f);
                llllllllllllllllIIllIllIlIIIllIl = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedV(8.0f + (llllllllllllllllIIllIllIlIIIlIIl - llllllllllllllllIIllIllIlIIIlIlI) * 16.0f);
                llllllllllllllllIIllIllIlIIllIll = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedU(8.0f + (llllllllllllllllIIllIllIlIIIlIIl - llllllllllllllllIIllIllIlIIIlIlI) * 16.0f);
                llllllllllllllllIIllIllIlIIIlIll = llllllllllllllllIIllIllIlIlIlIIl.getInterpolatedV(8.0f + (-llllllllllllllllIIllIllIlIIIlIIl - llllllllllllllllIIllIllIlIIIlIlI) * 16.0f);
            }
            llllllllllllllllIIllIllIIllIlIIl.func_178963_b(llllllllllllllllIIllIllIllIIIIIl.getMixedBrightnessForBlock(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI));
            llllllllllllllllIIllIllIIllIlIIl.func_178986_b(llllllllllllllllIIllIllIlIllIlIl * llllllllllllllllIIllIllIlIllllIl, llllllllllllllllIIllIllIlIllIlIl * llllllllllllllllIIllIllIlIllllII, llllllllllllllllIIllIllIlIllIlIl * llllllllllllllllIIllIllIlIlllIll);
            llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl + 0.0, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIllIIIl, llllllllllllllllIIllIllIlIlIlIll + 0.0, llllllllllllllllIIllIllIlIlIIlII, llllllllllllllllIIllIllIlIIlIlIl);
            llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl + 0.0, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIllIIII, llllllllllllllllIIllIllIlIlIlIll + 1.0, llllllllllllllllIIllIllIlIlIIIIl, llllllllllllllllIIllIllIlIIIllll);
            llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl + 1.0, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIlIllll, llllllllllllllllIIllIllIlIlIlIll + 1.0, llllllllllllllllIIllIllIlIIllllI, llllllllllllllllIIllIllIlIIIllIl);
            llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl + 1.0, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIlIlllI, llllllllllllllllIIllIllIlIlIlIll + 0.0, llllllllllllllllIIllIllIlIIllIll, llllllllllllllllIIllIllIlIIIlIll);
            if (llllllllllllllllIIllIllIllIIIIIl.func_176364_g(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetUp())) {
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl + 0.0, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIllIIIl, llllllllllllllllIIllIllIlIlIlIll + 0.0, llllllllllllllllIIllIllIlIlIIlII, llllllllllllllllIIllIllIlIIlIlIl);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl + 1.0, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIlIlllI, llllllllllllllllIIllIllIlIlIlIll + 0.0, llllllllllllllllIIllIllIlIIllIll, llllllllllllllllIIllIllIlIIIlIll);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl + 1.0, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIlIllll, llllllllllllllllIIllIllIlIlIlIll + 1.0, llllllllllllllllIIllIllIlIIllllI, llllllllllllllllIIllIllIlIIIllIl);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl + 0.0, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIllIIII, llllllllllllllllIIllIllIlIlIlIll + 1.0, llllllllllllllllIIllIllIlIlIIIIl, llllllllllllllllIIllIllIlIIIllll);
            }
        }
        if (llllllllllllllllIIllIllIlIlllIIl) {
            llllllllllllllllIIllIllIIllIlIIl.func_178963_b(llllllllllllllllIIllIllIllIIIIIl.getMixedBrightnessForBlock(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIIllIlIlI.offsetDown()));
            llllllllllllllllIIllIllIIllIlIIl.func_178986_b(llllllllllllllllIIllIllIlIllIllI, llllllllllllllllIIllIllIlIllIllI, llllllllllllllllIIllIllIlIllIllI);
            final float llllllllllllllllIIllIllIlIlIIllI = llllllllllllllllIIllIllIllIIIIII[0].getMinU();
            final float llllllllllllllllIIllIllIlIlIIIll = llllllllllllllllIIllIllIllIIIIII[0].getMaxU();
            final float llllllllllllllllIIllIllIlIlIIIII = llllllllllllllllIIllIllIllIIIIII[0].getMinV();
            final float llllllllllllllllIIllIllIlIIlllIl = llllllllllllllllIIllIllIllIIIIII[0].getMaxV();
            llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl, llllllllllllllllIIllIllIlIlIllII, llllllllllllllllIIllIllIlIlIlIll + 1.0, llllllllllllllllIIllIllIlIlIIllI, llllllllllllllllIIllIllIlIIlllIl);
            llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl, llllllllllllllllIIllIllIlIlIllII, llllllllllllllllIIllIllIlIlIlIll, llllllllllllllllIIllIllIlIlIIllI, llllllllllllllllIIllIllIlIlIIIII);
            llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl + 1.0, llllllllllllllllIIllIllIlIlIllII, llllllllllllllllIIllIllIlIlIlIll, llllllllllllllllIIllIllIlIlIIIll, llllllllllllllllIIllIllIlIlIIIII);
            llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIlIllIl + 1.0, llllllllllllllllIIllIllIlIlIllII, llllllllllllllllIIllIllIlIlIlIll + 1.0, llllllllllllllllIIllIllIlIlIIIll, llllllllllllllllIIllIllIlIIlllIl);
            llllllllllllllllIIllIllIlIllIlll = true;
        }
        for (int llllllllllllllllIIllIllIlIIIIlll = 0; llllllllllllllllIIllIllIlIIIIlll < 4; ++llllllllllllllllIIllIllIlIIIIlll) {
            int llllllllllllllllIIllIllIlIIIIllI = 0;
            int llllllllllllllllIIllIllIlIIIIlIl = 0;
            if (llllllllllllllllIIllIllIlIIIIlll == 0) {
                --llllllllllllllllIIllIllIlIIIIlIl;
            }
            if (llllllllllllllllIIllIllIlIIIIlll == 1) {
                ++llllllllllllllllIIllIllIlIIIIlIl;
            }
            if (llllllllllllllllIIllIllIlIIIIlll == 2) {
                --llllllllllllllllIIllIllIlIIIIllI;
            }
            if (llllllllllllllllIIllIllIlIIIIlll == 3) {
                ++llllllllllllllllIIllIllIlIIIIllI;
            }
            final BlockPos llllllllllllllllIIllIllIlIIIIlII = llllllllllllllllIIllIllIIllIlIlI.add(llllllllllllllllIIllIllIlIIIIllI, 0, llllllllllllllllIIllIllIlIIIIlIl);
            final TextureAtlasSprite llllllllllllllllIIllIllIlIlIlIII = llllllllllllllllIIllIllIllIIIIII[1];
            llllllllllllllllIIllIllIIllIlIIl.setSprite(llllllllllllllllIIllIllIlIlIlIII);
            if (llllllllllllllllIIllIllIlIlllIII[llllllllllllllllIIllIllIlIIIIlll]) {
                float llllllllllllllllIIllIllIlIIlIlll = 0.0f;
                float llllllllllllllllIIllIllIlIIlIIIl = 0.0f;
                double llllllllllllllllIIllIllIlIIIIIII = 0.0;
                double llllllllllllllllIIllIllIIllllIII = 0.0;
                double llllllllllllllllIIllIllIIlllllII = 0.0;
                double llllllllllllllllIIllIllIIlllIlII = 0.0;
                if (llllllllllllllllIIllIllIlIIIIlll == 0) {
                    final float llllllllllllllllIIllIllIlIIllIlI = llllllllllllllllIIllIllIlIllIIIl;
                    final float llllllllllllllllIIllIllIlIIlIlII = llllllllllllllllIIllIllIlIlIlllI;
                    final double llllllllllllllllIIllIllIlIIIIIll = llllllllllllllllIIllIllIlIlIllIl;
                    final double llllllllllllllllIIllIllIIllllIll = llllllllllllllllIIllIllIlIlIllIl + 1.0;
                    final double llllllllllllllllIIllIllIIlllllll = llllllllllllllllIIllIllIlIlIlIll + llllllllllllllllIIllIllIlIlIlIlI;
                    final double llllllllllllllllIIllIllIIlllIlll = llllllllllllllllIIllIllIlIlIlIll + llllllllllllllllIIllIllIlIlIlIlI;
                }
                else if (llllllllllllllllIIllIllIlIIIIlll == 1) {
                    final float llllllllllllllllIIllIllIlIIllIIl = llllllllllllllllIIllIllIlIlIllll;
                    final float llllllllllllllllIIllIllIlIIlIIll = llllllllllllllllIIllIllIlIllIIII;
                    final double llllllllllllllllIIllIllIlIIIIIlI = llllllllllllllllIIllIllIlIlIllIl + 1.0;
                    final double llllllllllllllllIIllIllIIllllIlI = llllllllllllllllIIllIllIlIlIllIl;
                    final double llllllllllllllllIIllIllIIllllllI = llllllllllllllllIIllIllIlIlIlIll + 1.0 - llllllllllllllllIIllIllIlIlIlIlI;
                    final double llllllllllllllllIIllIllIIlllIllI = llllllllllllllllIIllIllIlIlIlIll + 1.0 - llllllllllllllllIIllIllIlIlIlIlI;
                }
                else if (llllllllllllllllIIllIllIlIIIIlll == 2) {
                    final float llllllllllllllllIIllIllIlIIllIII = llllllllllllllllIIllIllIlIllIIII;
                    final float llllllllllllllllIIllIllIlIIlIIlI = llllllllllllllllIIllIllIlIllIIIl;
                    final double llllllllllllllllIIllIllIlIIIIIIl = llllllllllllllllIIllIllIlIlIllIl + llllllllllllllllIIllIllIlIlIlIlI;
                    final double llllllllllllllllIIllIllIIllllIIl = llllllllllllllllIIllIllIlIlIllIl + llllllllllllllllIIllIllIlIlIlIlI;
                    final double llllllllllllllllIIllIllIIlllllIl = llllllllllllllllIIllIllIlIlIlIll + 1.0;
                    final double llllllllllllllllIIllIllIIlllIlIl = llllllllllllllllIIllIllIlIlIlIll;
                }
                else {
                    llllllllllllllllIIllIllIlIIlIlll = llllllllllllllllIIllIllIlIlIlllI;
                    llllllllllllllllIIllIllIlIIlIIIl = llllllllllllllllIIllIllIlIlIllll;
                    llllllllllllllllIIllIllIlIIIIIII = llllllllllllllllIIllIllIlIlIllIl + 1.0 - llllllllllllllllIIllIllIlIlIlIlI;
                    llllllllllllllllIIllIllIIllllIII = llllllllllllllllIIllIllIlIlIllIl + 1.0 - llllllllllllllllIIllIllIlIlIlIlI;
                    llllllllllllllllIIllIllIIlllllII = llllllllllllllllIIllIllIlIlIlIll;
                    llllllllllllllllIIllIllIIlllIlII = llllllllllllllllIIllIllIlIlIlIll + 1.0;
                }
                llllllllllllllllIIllIllIlIllIlll = true;
                final float llllllllllllllllIIllIllIIlllIIll = llllllllllllllllIIllIllIlIlIlIII.getInterpolatedU(0.0);
                final float llllllllllllllllIIllIllIIlllIIlI = llllllllllllllllIIllIllIlIlIlIII.getInterpolatedU(8.0);
                final float llllllllllllllllIIllIllIIlllIIIl = llllllllllllllllIIllIllIlIlIlIII.getInterpolatedV((1.0f - llllllllllllllllIIllIllIlIIlIlll) * 16.0f * 0.5f);
                final float llllllllllllllllIIllIllIIlllIIII = llllllllllllllllIIllIllIlIlIlIII.getInterpolatedV((1.0f - llllllllllllllllIIllIllIlIIlIIIl) * 16.0f * 0.5f);
                final float llllllllllllllllIIllIllIIllIllll = llllllllllllllllIIllIllIlIlIlIII.getInterpolatedV(8.0);
                llllllllllllllllIIllIllIIllIlIIl.func_178963_b(llllllllllllllllIIllIllIllIIIIIl.getMixedBrightnessForBlock(llllllllllllllllIIllIllIllIIIlIl, llllllllllllllllIIllIllIlIIIIlII));
                float llllllllllllllllIIllIllIIllIlllI = 1.0f;
                llllllllllllllllIIllIllIIllIlllI *= ((llllllllllllllllIIllIllIlIIIIlll < 2) ? llllllllllllllllIIllIllIlIllIlII : llllllllllllllllIIllIllIlIllIIll);
                llllllllllllllllIIllIllIIllIlIIl.func_178986_b(llllllllllllllllIIllIllIlIllIlIl * llllllllllllllllIIllIllIIllIlllI * llllllllllllllllIIllIllIlIllllIl, llllllllllllllllIIllIllIlIllIlIl * llllllllllllllllIIllIllIIllIlllI * llllllllllllllllIIllIllIlIllllII, llllllllllllllllIIllIllIlIllIlIl * llllllllllllllllIIllIllIIllIlllI * llllllllllllllllIIllIllIlIlllIll);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIIIIIII, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIIlIlll, llllllllllllllllIIllIllIIlllllII, llllllllllllllllIIllIllIIlllIIll, llllllllllllllllIIllIllIIlllIIIl);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIIllllIII, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIIlIIIl, llllllllllllllllIIllIllIIlllIlII, llllllllllllllllIIllIllIIlllIIlI, llllllllllllllllIIllIllIIlllIIII);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIIllllIII, llllllllllllllllIIllIllIlIlIllII + 0.0, llllllllllllllllIIllIllIIlllIlII, llllllllllllllllIIllIllIIlllIIlI, llllllllllllllllIIllIllIIllIllll);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIIIIIII, llllllllllllllllIIllIllIlIlIllII + 0.0, llllllllllllllllIIllIllIIlllllII, llllllllllllllllIIllIllIIlllIIll, llllllllllllllllIIllIllIIllIllll);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIIIIIII, llllllllllllllllIIllIllIlIlIllII + 0.0, llllllllllllllllIIllIllIIlllllII, llllllllllllllllIIllIllIIlllIIll, llllllllllllllllIIllIllIIllIllll);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIIllllIII, llllllllllllllllIIllIllIlIlIllII + 0.0, llllllllllllllllIIllIllIIlllIlII, llllllllllllllllIIllIllIIlllIIlI, llllllllllllllllIIllIllIIllIllll);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIIllllIII, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIIlIIIl, llllllllllllllllIIllIllIIlllIlII, llllllllllllllllIIllIllIIlllIIlI, llllllllllllllllIIllIllIIlllIIII);
                llllllllllllllllIIllIllIIllIlIIl.addVertexWithUV(llllllllllllllllIIllIllIlIIIIIII, llllllllllllllllIIllIllIlIlIllII + llllllllllllllllIIllIllIlIIlIlll, llllllllllllllllIIllIllIIlllllII, llllllllllllllllIIllIllIIlllIIll, llllllllllllllllIIllIllIIlllIIIl);
            }
        }
        llllllllllllllllIIllIllIIllIlIIl.setSprite(null);
        return llllllllllllllllIIllIllIlIllIlll;
    }
    
    private float func_178269_a(final IBlockAccess llllllllllllllllIIllIllIIIlIIlIl, final BlockPos llllllllllllllllIIllIllIIIlIIlII, final Material llllllllllllllllIIllIllIIIlIllIl) {
        int llllllllllllllllIIllIllIIIlIllII = 0;
        float llllllllllllllllIIllIllIIIlIlIll = 0.0f;
        for (int llllllllllllllllIIllIllIIIlIlIlI = 0; llllllllllllllllIIllIllIIIlIlIlI < 4; ++llllllllllllllllIIllIllIIIlIlIlI) {
            final BlockPos llllllllllllllllIIllIllIIIlIlIIl = llllllllllllllllIIllIllIIIlIIlII.add(-(llllllllllllllllIIllIllIIIlIlIlI & 0x1), 0, -(llllllllllllllllIIllIllIIIlIlIlI >> 1 & 0x1));
            if (llllllllllllllllIIllIllIIIlIIlIl.getBlockState(llllllllllllllllIIllIllIIIlIlIIl.offsetUp()).getBlock().getMaterial() == llllllllllllllllIIllIllIIIlIllIl) {
                return 1.0f;
            }
            final IBlockState llllllllllllllllIIllIllIIIlIlIII = llllllllllllllllIIllIllIIIlIIlIl.getBlockState(llllllllllllllllIIllIllIIIlIlIIl);
            final Material llllllllllllllllIIllIllIIIlIIlll = llllllllllllllllIIllIllIIIlIlIII.getBlock().getMaterial();
            if (llllllllllllllllIIllIllIIIlIIlll == llllllllllllllllIIllIllIIIlIllIl) {
                final int llllllllllllllllIIllIllIIIlIIllI = (int)llllllllllllllllIIllIllIIIlIlIII.getValue(BlockLiquid.LEVEL);
                if (llllllllllllllllIIllIllIIIlIIllI >= 8 || llllllllllllllllIIllIllIIIlIIllI == 0) {
                    llllllllllllllllIIllIllIIIlIlIll += BlockLiquid.getLiquidHeightPercent(llllllllllllllllIIllIllIIIlIIllI) * 10.0f;
                    llllllllllllllllIIllIllIIIlIllII += 10;
                }
                llllllllllllllllIIllIllIIIlIlIll += BlockLiquid.getLiquidHeightPercent(llllllllllllllllIIllIllIIIlIIllI);
                ++llllllllllllllllIIllIllIIIlIllII;
            }
            else if (!llllllllllllllllIIllIllIIIlIIlll.isSolid()) {
                ++llllllllllllllllIIllIllIIIlIlIll;
                ++llllllllllllllllIIllIllIIIlIllII;
            }
        }
        return 1.0f - llllllllllllllllIIllIllIIIlIlIll / llllllllllllllllIIllIllIIIlIllII;
    }
}
