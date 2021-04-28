package net.minecraft.client.renderer;

import net.minecraft.world.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.client.*;
import net.minecraft.block.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import optifine.*;

public class BlockModelRenderer
{
    private static /* synthetic */ float aoLightValueOpaque;
    
    public static float fixAoLightValue(final float llllllllllllllIIIIllllIlIIIllllI) {
        return (llllllllllllllIIIIllllIlIIIllllI == 0.2f) ? BlockModelRenderer.aoLightValueOpaque : llllllllllllllIIIIllllIlIIIllllI;
    }
    
    public boolean func_178259_a(final IBlockAccess llllllllllllllIIIIlllllIllllllII, final IBakedModel llllllllllllllIIIIlllllIllllIlII, final IBlockState llllllllllllllIIIIlllllIlllllIlI, final BlockPos llllllllllllllIIIIlllllIllllIIlI, final WorldRenderer llllllllllllllIIIIlllllIlllllIII) {
        final Block llllllllllllllIIIIlllllIllllIlll = llllllllllllllIIIIlllllIlllllIlI.getBlock();
        llllllllllllllIIIIlllllIllllIlll.setBlockBoundsBasedOnState(llllllllllllllIIIIlllllIllllllII, llllllllllllllIIIIlllllIllllIIlI);
        return this.renderBlockModel(llllllllllllllIIIIlllllIllllllII, llllllllllllllIIIIlllllIllllIlII, llllllllllllllIIIIlllllIlllllIlI, llllllllllllllIIIIlllllIllllIIlI, llllllllllllllIIIIlllllIlllllIII, true);
    }
    
    public boolean renderModelStandard(final IBlockAccess llllllllllllllIIIIlllllIIlIIlIlI, final IBakedModel llllllllllllllIIIIlllllIIlIIlIIl, final Block llllllllllllllIIIIlllllIIlIlllII, final IBlockState llllllllllllllIIIIlllllIIlIllIll, final BlockPos llllllllllllllIIIIlllllIIlIIIllI, final WorldRenderer llllllllllllllIIIIlllllIIlIllIIl, final boolean llllllllllllllIIIIlllllIIlIIIlII) {
        boolean llllllllllllllIIIIlllllIIlIlIlll = false;
        RenderEnv llllllllllllllIIIIlllllIIlIlIllI = null;
        for (final EnumFacing llllllllllllllIIIIlllllIIlIlIIlI : EnumFacing.VALUES) {
            List llllllllllllllIIIIlllllIIlIlIIIl = llllllllllllllIIIIlllllIIlIIlIIl.func_177551_a(llllllllllllllIIIIlllllIIlIlIIlI);
            if (!llllllllllllllIIIIlllllIIlIlIIIl.isEmpty()) {
                final BlockPos llllllllllllllIIIIlllllIIlIlIIII = llllllllllllllIIIIlllllIIlIIIllI.offset(llllllllllllllIIIIlllllIIlIlIIlI);
                if (!llllllllllllllIIIIlllllIIlIIIlII || llllllllllllllIIIIlllllIIlIlllII.shouldSideBeRendered(llllllllllllllIIIIlllllIIlIIlIlI, llllllllllllllIIIIlllllIIlIlIIII, llllllllllllllIIIIlllllIIlIlIIlI)) {
                    if (llllllllllllllIIIIlllllIIlIlIllI == null) {
                        llllllllllllllIIIIlllllIIlIlIllI = RenderEnv.getInstance(llllllllllllllIIIIlllllIIlIIlIlI, llllllllllllllIIIIlllllIIlIllIll, llllllllllllllIIIIlllllIIlIIIllI);
                    }
                    if (!llllllllllllllIIIIlllllIIlIlIllI.isBreakingAnimation(llllllllllllllIIIIlllllIIlIlIIIl) && Config.isBetterGrass()) {
                        llllllllllllllIIIIlllllIIlIlIIIl = BetterGrass.getFaceQuads(llllllllllllllIIIIlllllIIlIIlIlI, llllllllllllllIIIIlllllIIlIlllII, llllllllllllllIIIIlllllIIlIIIllI, llllllllllllllIIIIlllllIIlIlIIlI, llllllllllllllIIIIlllllIIlIlIIIl);
                    }
                    final int llllllllllllllIIIIlllllIIlIIllll = llllllllllllllIIIIlllllIIlIlllII.getMixedBrightnessForBlock(llllllllllllllIIIIlllllIIlIIlIlI, llllllllllllllIIIIlllllIIlIlIIII);
                    this.renderModelStandardQuads(llllllllllllllIIIIlllllIIlIIlIlI, llllllllllllllIIIIlllllIIlIlllII, llllllllllllllIIIIlllllIIlIIIllI, llllllllllllllIIIIlllllIIlIlIIlI, llllllllllllllIIIIlllllIIlIIllll, false, llllllllllllllIIIIlllllIIlIllIIl, llllllllllllllIIIIlllllIIlIlIIIl, llllllllllllllIIIIlllllIIlIlIllI);
                    llllllllllllllIIIIlllllIIlIlIlll = true;
                }
            }
        }
        final List llllllllllllllIIIIlllllIIlIIlllI = llllllllllllllIIIIlllllIIlIIlIIl.func_177550_a();
        if (llllllllllllllIIIIlllllIIlIIlllI.size() > 0) {
            if (llllllllllllllIIIIlllllIIlIlIllI == null) {
                llllllllllllllIIIIlllllIIlIlIllI = RenderEnv.getInstance(llllllllllllllIIIIlllllIIlIIlIlI, llllllllllllllIIIIlllllIIlIllIll, llllllllllllllIIIIlllllIIlIIIllI);
            }
            this.renderModelStandardQuads(llllllllllllllIIIIlllllIIlIIlIlI, llllllllllllllIIIIlllllIIlIlllII, llllllllllllllIIIIlllllIIlIIIllI, null, -1, true, llllllllllllllIIIIlllllIIlIllIIl, llllllllllllllIIIIlllllIIlIIlllI, llllllllllllllIIIIlllllIIlIlIllI);
            llllllllllllllIIIIlllllIIlIlIlll = true;
        }
        if (llllllllllllllIIIIlllllIIlIlIllI != null && Config.isBetterSnow() && !llllllllllllllIIIIlllllIIlIlIllI.isBreakingAnimation() && BetterSnow.shouldRender(llllllllllllllIIIIlllllIIlIIlIlI, llllllllllllllIIIIlllllIIlIlllII, llllllllllllllIIIIlllllIIlIllIll, llllllllllllllIIIIlllllIIlIIIllI) && BetterSnow.shouldRender(llllllllllllllIIIIlllllIIlIIlIlI, llllllllllllllIIIIlllllIIlIlllII, llllllllllllllIIIIlllllIIlIllIll, llllllllllllllIIIIlllllIIlIIIllI)) {
            final IBakedModel llllllllllllllIIIIlllllIIlIIllIl = BetterSnow.getModelSnowLayer();
            final IBlockState llllllllllllllIIIIlllllIIlIIllII = BetterSnow.getStateSnowLayer();
            this.renderModelStandard(llllllllllllllIIIIlllllIIlIIlIlI, llllllllllllllIIIIlllllIIlIIllIl, llllllllllllllIIIIlllllIIlIIllII.getBlock(), llllllllllllllIIIIlllllIIlIIllII, llllllllllllllIIIIlllllIIlIIIllI, llllllllllllllIIIIlllllIIlIllIIl, true);
        }
        return llllllllllllllIIIIlllllIIlIlIlll;
    }
    
    private void renderModelStandardQuads(final IBlockAccess llllllllllllllIIIIllllIllIlIlIll, final Block llllllllllllllIIIIllllIllIIIlllI, final BlockPos llllllllllllllIIIIllllIllIlIlIIl, final EnumFacing llllllllllllllIIIIllllIllIlIlIII, int llllllllllllllIIIIllllIllIIIllII, final boolean llllllllllllllIIIIllllIllIIIlIll, final WorldRenderer llllllllllllllIIIIllllIllIIIlIlI, final List llllllllllllllIIIIllllIllIlIIlII, final RenderEnv llllllllllllllIIIIllllIllIIIlIII) {
        final BitSet llllllllllllllIIIIllllIllIlIIIlI = llllllllllllllIIIIllllIllIIIlIII.getBoundsFlags();
        final IBlockState llllllllllllllIIIIllllIllIlIIIIl = llllllllllllllIIIIllllIllIIIlIII.getBlockState();
        double llllllllllllllIIIIllllIllIlIIIII = llllllllllllllIIIIllllIllIlIlIIl.getX();
        double llllllllllllllIIIIllllIllIIlllll = llllllllllllllIIIIllllIllIlIlIIl.getY();
        double llllllllllllllIIIIllllIllIIllllI = llllllllllllllIIIIllllIllIlIlIIl.getZ();
        final Block.EnumOffsetType llllllllllllllIIIIllllIllIIlllIl = llllllllllllllIIIIllllIllIIIlllI.getOffsetType();
        if (llllllllllllllIIIIllllIllIIlllIl != Block.EnumOffsetType.NONE) {
            final int llllllllllllllIIIIllllIllIIlllII = llllllllllllllIIIIllllIllIlIlIIl.getX();
            final int llllllllllllllIIIIllllIllIIllIll = llllllllllllllIIIIllllIllIlIlIIl.getZ();
            long llllllllllllllIIIIllllIllIIllIlI = (long)(llllllllllllllIIIIllllIllIIlllII * 3129871) ^ llllllllllllllIIIIllllIllIIllIll * 116129781L;
            llllllllllllllIIIIllllIllIIllIlI = llllllllllllllIIIIllllIllIIllIlI * llllllllllllllIIIIllllIllIIllIlI * 42317861L + llllllllllllllIIIIllllIllIIllIlI * 11L;
            llllllllllllllIIIIllllIllIlIIIII += ((llllllllllllllIIIIllllIllIIllIlI >> 16 & 0xFL) / 15.0f - 0.5) * 0.5;
            llllllllllllllIIIIllllIllIIllllI += ((llllllllllllllIIIIllllIllIIllIlI >> 24 & 0xFL) / 15.0f - 0.5) * 0.5;
            if (llllllllllllllIIIIllllIllIIlllIl == Block.EnumOffsetType.XYZ) {
                llllllllllllllIIIIllllIllIIlllll += ((llllllllllllllIIIIllllIllIIllIlI >> 20 & 0xFL) / 15.0f - 1.0) * 0.2;
            }
        }
        for (BakedQuad llllllllllllllIIIIllllIllIIllIII : llllllllllllllIIIIllllIllIlIIlII) {
            if (!llllllllllllllIIIIllllIllIIIlIII.isBreakingAnimation(llllllllllllllIIIIllllIllIIllIII)) {
                final BakedQuad llllllllllllllIIIIllllIllIIlIlll = llllllllllllllIIIIllllIllIIllIII;
                if (Config.isConnectedTextures()) {
                    llllllllllllllIIIIllllIllIIllIII = ConnectedTextures.getConnectedTexture(llllllllllllllIIIIllllIllIlIlIll, llllllllllllllIIIIllllIllIlIIIIl, llllllllllllllIIIIllllIllIlIlIIl, llllllllllllllIIIIllllIllIIllIII, llllllllllllllIIIIllllIllIIIlIII);
                }
                if (llllllllllllllIIIIllllIllIIllIII == llllllllllllllIIIIllllIllIIlIlll && Config.isNaturalTextures()) {
                    llllllllllllllIIIIllllIllIIllIII = NaturalTextures.getNaturalTexture(llllllllllllllIIIIllllIllIlIlIIl, llllllllllllllIIIIllllIllIIllIII);
                }
            }
            if (llllllllllllllIIIIllllIllIIIlIll) {
                this.func_178261_a(llllllllllllllIIIIllllIllIIIlllI, llllllllllllllIIIIllllIllIIllIII.func_178209_a(), llllllllllllllIIIIllllIllIIllIII.getFace(), null, llllllllllllllIIIIllllIllIlIIIlI);
                llllllllllllllIIIIllllIllIIIllII = (llllllllllllllIIIIllllIllIlIIIlI.get(0) ? llllllllllllllIIIIllllIllIIIlllI.getMixedBrightnessForBlock(llllllllllllllIIIIllllIllIlIlIll, llllllllllllllIIIIllllIllIlIlIIl.offset(llllllllllllllIIIIllllIllIIllIII.getFace())) : llllllllllllllIIIIllllIllIIIlllI.getMixedBrightnessForBlock(llllllllllllllIIIIllllIllIlIlIll, llllllllllllllIIIIllllIllIlIlIIl));
            }
            if (llllllllllllllIIIIllllIllIIIlIlI.isMultiTexture()) {
                llllllllllllllIIIIllllIllIIIlIlI.func_178981_a(llllllllllllllIIIIllllIllIIllIII.getVertexDataSingle());
                llllllllllllllIIIIllllIllIIIlIlI.putSprite(llllllllllllllIIIIllllIllIIllIII.getSprite());
            }
            else {
                llllllllllllllIIIIllllIllIIIlIlI.func_178981_a(llllllllllllllIIIIllllIllIIllIII.func_178209_a());
            }
            llllllllllllllIIIIllllIllIIIlIlI.func_178962_a(llllllllllllllIIIIllllIllIIIllII, llllllllllllllIIIIllllIllIIIllII, llllllllllllllIIIIllllIllIIIllII, llllllllllllllIIIIllllIllIIIllII);
            final int llllllllllllllIIIIllllIllIIlIllI = CustomColors.getColorMultiplier(llllllllllllllIIIIllllIllIIllIII, llllllllllllllIIIIllllIllIIIlllI, llllllllllllllIIIIllllIllIlIlIll, llllllllllllllIIIIllllIllIlIlIIl, llllllllllllllIIIIllllIllIIIlIII);
            if (llllllllllllllIIIIllllIllIIllIII.func_178212_b() || llllllllllllllIIIIllllIllIIlIllI != -1) {
                int llllllllllllllIIIIllllIllIIlIlII = 0;
                if (llllllllllllllIIIIllllIllIIlIllI != -1) {
                    final int llllllllllllllIIIIllllIllIIlIlIl = llllllllllllllIIIIllllIllIIlIllI;
                }
                else {
                    llllllllllllllIIIIllllIllIIlIlII = llllllllllllllIIIIllllIllIIIlllI.colorMultiplier(llllllllllllllIIIIllllIllIlIlIll, llllllllllllllIIIIllllIllIlIlIIl, llllllllllllllIIIIllllIllIIllIII.func_178211_c());
                }
                if (EntityRenderer.anaglyphEnable) {
                    llllllllllllllIIIIllllIllIIlIlII = TextureUtil.func_177054_c(llllllllllllllIIIIllllIllIIlIlII);
                }
                final float llllllllllllllIIIIllllIllIIlIIll = (llllllllllllllIIIIllllIllIIlIlII >> 16 & 0xFF) / 255.0f;
                final float llllllllllllllIIIIllllIllIIlIIlI = (llllllllllllllIIIIllllIllIIlIlII >> 8 & 0xFF) / 255.0f;
                final float llllllllllllllIIIIllllIllIIlIIIl = (llllllllllllllIIIIllllIllIIlIlII & 0xFF) / 255.0f;
                llllllllllllllIIIIllllIllIIIlIlI.func_178978_a(llllllllllllllIIIIllllIllIIlIIll, llllllllllllllIIIIllllIllIIlIIlI, llllllllllllllIIIIllllIllIIlIIIl, 4);
                llllllllllllllIIIIllllIllIIIlIlI.func_178978_a(llllllllllllllIIIIllllIllIIlIIll, llllllllllllllIIIIllllIllIIlIIlI, llllllllllllllIIIIllllIllIIlIIIl, 3);
                llllllllllllllIIIIllllIllIIIlIlI.func_178978_a(llllllllllllllIIIIllllIllIIlIIll, llllllllllllllIIIIllllIllIIlIIlI, llllllllllllllIIIIllllIllIIlIIIl, 2);
                llllllllllllllIIIIllllIllIIIlIlI.func_178978_a(llllllllllllllIIIIllllIllIIlIIll, llllllllllllllIIIIllllIllIIlIIlI, llllllllllllllIIIIllllIllIIlIIIl, 1);
            }
            llllllllllllllIIIIllllIllIIIlIlI.func_178987_a(llllllllllllllIIIIllllIllIlIIIII, llllllllllllllIIIIllllIllIIlllll, llllllllllllllIIIIllllIllIIllllI);
        }
    }
    
    private void func_178261_a(final Block llllllllllllllIIIIllllIlllIlIIlI, final int[] llllllllllllllIIIIllllIlllIlIIIl, final EnumFacing llllllllllllllIIIIllllIllllIIIlI, final float[] llllllllllllllIIIIllllIlllIIllll, final BitSet llllllllllllllIIIIllllIllllIIIII) {
        float llllllllllllllIIIIllllIlllIlllll = 32.0f;
        float llllllllllllllIIIIllllIlllIllllI = 32.0f;
        float llllllllllllllIIIIllllIlllIlllIl = 32.0f;
        float llllllllllllllIIIIllllIlllIlllII = -32.0f;
        float llllllllllllllIIIIllllIlllIllIll = -32.0f;
        float llllllllllllllIIIIllllIlllIllIlI = -32.0f;
        final int llllllllllllllIIIIllllIlllIllIIl = llllllllllllllIIIIllllIlllIlIIIl.length / 4;
        for (int llllllllllllllIIIIllllIlllIlIllI = 0; llllllllllllllIIIIllllIlllIlIllI < 4; ++llllllllllllllIIIIllllIlllIlIllI) {
            final float llllllllllllllIIIIllllIlllIllIII = Float.intBitsToFloat(llllllllllllllIIIIllllIlllIlIIIl[llllllllllllllIIIIllllIlllIlIllI * llllllllllllllIIIIllllIlllIllIIl]);
            final float llllllllllllllIIIIllllIlllIlIlIl = Float.intBitsToFloat(llllllllllllllIIIIllllIlllIlIIIl[llllllllllllllIIIIllllIlllIlIllI * llllllllllllllIIIIllllIlllIllIIl + 1]);
            final float llllllllllllllIIIIllllIlllIlIlII = Float.intBitsToFloat(llllllllllllllIIIIllllIlllIlIIIl[llllllllllllllIIIIllllIlllIlIllI * llllllllllllllIIIIllllIlllIllIIl + 2]);
            llllllllllllllIIIIllllIlllIlllll = Math.min(llllllllllllllIIIIllllIlllIlllll, llllllllllllllIIIIllllIlllIllIII);
            llllllllllllllIIIIllllIlllIllllI = Math.min(llllllllllllllIIIIllllIlllIllllI, llllllllllllllIIIIllllIlllIlIlIl);
            llllllllllllllIIIIllllIlllIlllIl = Math.min(llllllllllllllIIIIllllIlllIlllIl, llllllllllllllIIIIllllIlllIlIlII);
            llllllllllllllIIIIllllIlllIlllII = Math.max(llllllllllllllIIIIllllIlllIlllII, llllllllllllllIIIIllllIlllIllIII);
            llllllllllllllIIIIllllIlllIllIll = Math.max(llllllllllllllIIIIllllIlllIllIll, llllllllllllllIIIIllllIlllIlIlIl);
            llllllllllllllIIIIllllIlllIllIlI = Math.max(llllllllllllllIIIIllllIlllIllIlI, llllllllllllllIIIIllllIlllIlIlII);
        }
        if (llllllllllllllIIIIllllIlllIIllll != null) {
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.WEST.getIndex()] = llllllllllllllIIIIllllIlllIlllll;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.EAST.getIndex()] = llllllllllllllIIIIllllIlllIlllII;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.DOWN.getIndex()] = llllllllllllllIIIIllllIlllIllllI;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.UP.getIndex()] = llllllllllllllIIIIllllIlllIllIll;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.NORTH.getIndex()] = llllllllllllllIIIIllllIlllIlllIl;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.SOUTH.getIndex()] = llllllllllllllIIIIllllIlllIllIlI;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.WEST.getIndex() + EnumFacing.VALUES.length] = 1.0f - llllllllllllllIIIIllllIlllIlllll;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.EAST.getIndex() + EnumFacing.VALUES.length] = 1.0f - llllllllllllllIIIIllllIlllIlllII;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.DOWN.getIndex() + EnumFacing.VALUES.length] = 1.0f - llllllllllllllIIIIllllIlllIllllI;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.UP.getIndex() + EnumFacing.VALUES.length] = 1.0f - llllllllllllllIIIIllllIlllIllIll;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.NORTH.getIndex() + EnumFacing.VALUES.length] = 1.0f - llllllllllllllIIIIllllIlllIlllIl;
            llllllllllllllIIIIllllIlllIIllll[EnumFacing.SOUTH.getIndex() + EnumFacing.VALUES.length] = 1.0f - llllllllllllllIIIIllllIlllIllIlI;
        }
        final float llllllllllllllIIIIllllIlllIlIIll = 1.0E-4f;
        final float llllllllllllllIIIIllllIlllIlIlll = 0.9999f;
        switch (SwitchEnumFacing.field_178290_a[llllllllllllllIIIIllllIllllIIIlI.ordinal()]) {
            case 1: {
                llllllllllllllIIIIllllIllllIIIII.set(1, llllllllllllllIIIIllllIlllIlllll >= 1.0E-4f || llllllllllllllIIIIllllIlllIlllIl >= 1.0E-4f || llllllllllllllIIIIllllIlllIlllII <= 0.9999f || llllllllllllllIIIIllllIlllIllIlI <= 0.9999f);
                llllllllllllllIIIIllllIllllIIIII.set(0, (llllllllllllllIIIIllllIlllIllllI < 1.0E-4f || llllllllllllllIIIIllllIlllIlIIlI.isFullCube()) && llllllllllllllIIIIllllIlllIllllI == llllllllllllllIIIIllllIlllIllIll);
                break;
            }
            case 2: {
                llllllllllllllIIIIllllIllllIIIII.set(1, llllllllllllllIIIIllllIlllIlllll >= 1.0E-4f || llllllllllllllIIIIllllIlllIlllIl >= 1.0E-4f || llllllllllllllIIIIllllIlllIlllII <= 0.9999f || llllllllllllllIIIIllllIlllIllIlI <= 0.9999f);
                llllllllllllllIIIIllllIllllIIIII.set(0, (llllllllllllllIIIIllllIlllIllIll > 0.9999f || llllllllllllllIIIIllllIlllIlIIlI.isFullCube()) && llllllllllllllIIIIllllIlllIllllI == llllllllllllllIIIIllllIlllIllIll);
                break;
            }
            case 3: {
                llllllllllllllIIIIllllIllllIIIII.set(1, llllllllllllllIIIIllllIlllIlllll >= 1.0E-4f || llllllllllllllIIIIllllIlllIllllI >= 1.0E-4f || llllllllllllllIIIIllllIlllIlllII <= 0.9999f || llllllllllllllIIIIllllIlllIllIll <= 0.9999f);
                llllllllllllllIIIIllllIllllIIIII.set(0, (llllllllllllllIIIIllllIlllIlllIl < 1.0E-4f || llllllllllllllIIIIllllIlllIlIIlI.isFullCube()) && llllllllllllllIIIIllllIlllIlllIl == llllllllllllllIIIIllllIlllIllIlI);
                break;
            }
            case 4: {
                llllllllllllllIIIIllllIllllIIIII.set(1, llllllllllllllIIIIllllIlllIlllll >= 1.0E-4f || llllllllllllllIIIIllllIlllIllllI >= 1.0E-4f || llllllllllllllIIIIllllIlllIlllII <= 0.9999f || llllllllllllllIIIIllllIlllIllIll <= 0.9999f);
                llllllllllllllIIIIllllIllllIIIII.set(0, (llllllllllllllIIIIllllIlllIllIlI > 0.9999f || llllllllllllllIIIIllllIlllIlIIlI.isFullCube()) && llllllllllllllIIIIllllIlllIlllIl == llllllllllllllIIIIllllIlllIllIlI);
                break;
            }
            case 5: {
                llllllllllllllIIIIllllIllllIIIII.set(1, llllllllllllllIIIIllllIlllIllllI >= 1.0E-4f || llllllllllllllIIIIllllIlllIlllIl >= 1.0E-4f || llllllllllllllIIIIllllIlllIllIll <= 0.9999f || llllllllllllllIIIIllllIlllIllIlI <= 0.9999f);
                llllllllllllllIIIIllllIllllIIIII.set(0, (llllllllllllllIIIIllllIlllIlllll < 1.0E-4f || llllllllllllllIIIIllllIlllIlIIlI.isFullCube()) && llllllllllllllIIIIllllIlllIlllll == llllllllllllllIIIIllllIlllIlllII);
                break;
            }
            case 6: {
                llllllllllllllIIIIllllIllllIIIII.set(1, llllllllllllllIIIIllllIlllIllllI >= 1.0E-4f || llllllllllllllIIIIllllIlllIlllIl >= 1.0E-4f || llllllllllllllIIIIllllIlllIllIll <= 0.9999f || llllllllllllllIIIIllllIlllIllIlI <= 0.9999f);
                llllllllllllllIIIIllllIllllIIIII.set(0, (llllllllllllllIIIIllllIlllIlllII > 0.9999f || llllllllllllllIIIIllllIlllIlIIlI.isFullCube()) && llllllllllllllIIIIllllIlllIlllll == llllllllllllllIIIIllllIlllIlllII);
                break;
            }
        }
    }
    
    public boolean func_178265_a(final IBlockAccess llllllllllllllIIIIlllllIllIIIlIl, final IBakedModel llllllllllllllIIIIlllllIllIIIlII, final Block llllllllllllllIIIIlllllIllIIIIll, final BlockPos llllllllllllllIIIIlllllIllIIIIlI, final WorldRenderer llllllllllllllIIIIlllllIlIlllIlI, final boolean llllllllllllllIIIIlllllIlIlllIIl) {
        return this.renderModelAmbientOcclusion(llllllllllllllIIIIlllllIllIIIlIl, llllllllllllllIIIIlllllIllIIIlII, llllllllllllllIIIIlllllIllIIIIll, llllllllllllllIIIIlllllIllIIIlIl.getBlockState(llllllllllllllIIIIlllllIllIIIIlI), llllllllllllllIIIIlllllIllIIIIlI, llllllllllllllIIIIlllllIlIlllIlI, llllllllllllllIIIIlllllIlIlllIIl);
    }
    
    public boolean func_178258_b(final IBlockAccess llllllllllllllIIIIlllllIIlllllIl, final IBakedModel llllllllllllllIIIIlllllIIlllllII, final Block llllllllllllllIIIIlllllIIlllIlII, final BlockPos llllllllllllllIIIIlllllIIlllIIll, final WorldRenderer llllllllllllllIIIIlllllIIlllIIlI, final boolean llllllllllllllIIIIlllllIIllllIII) {
        return this.renderModelStandard(llllllllllllllIIIIlllllIIlllllIl, llllllllllllllIIIIlllllIIlllllII, llllllllllllllIIIIlllllIIlllIlII, llllllllllllllIIIIlllllIIlllllIl.getBlockState(llllllllllllllIIIIlllllIIlllIIll), llllllllllllllIIIIlllllIIlllIIll, llllllllllllllIIIIlllllIIlllIIlI, llllllllllllllIIIIlllllIIllllIII);
    }
    
    public static void updateAoLightValue() {
        BlockModelRenderer.aoLightValueOpaque = 1.0f - Config.getAmbientOcclusionLevel() * 0.8f;
    }
    
    public void func_178262_a(final IBakedModel llllllllllllllIIIIllllIlIllIIlIl, final float llllllllllllllIIIIllllIlIllIlllI, final float llllllllllllllIIIIllllIlIllIllIl, final float llllllllllllllIIIIllllIlIllIIIlI, final float llllllllllllllIIIIllllIlIllIlIll) {
        for (final EnumFacing llllllllllllllIIIIllllIlIllIIlll : EnumFacing.VALUES) {
            this.func_178264_a(llllllllllllllIIIIllllIlIllIlllI, llllllllllllllIIIIllllIlIllIllIl, llllllllllllllIIIIllllIlIllIIIlI, llllllllllllllIIIIllllIlIllIlIll, llllllllllllllIIIIllllIlIllIIlIl.func_177551_a(llllllllllllllIIIIllllIlIllIIlll));
        }
        this.func_178264_a(llllllllllllllIIIIllllIlIllIlllI, llllllllllllllIIIIllllIlIllIllIl, llllllllllllllIIIIllllIlIllIIIlI, llllllllllllllIIIIllllIlIllIlIll, llllllllllllllIIIIllllIlIllIIlIl.func_177550_a());
    }
    
    private void renderModelAmbientOcclusionQuads(final IBlockAccess llllllllllllllIIIIlllllIIIlIIIll, final Block llllllllllllllIIIIlllllIIIlIIIlI, final BlockPos llllllllllllllIIIIlllllIIIIIlIII, final WorldRenderer llllllllllllllIIIIlllllIIIIIIlll, final List llllllllllllllIIIIlllllIIIIIIllI, final RenderEnv llllllllllllllIIIIlllllIIIIIIlIl) {
        final float[] llllllllllllllIIIIlllllIIIIlllIl = llllllllllllllIIIIlllllIIIIIIlIl.getQuadBounds();
        final BitSet llllllllllllllIIIIlllllIIIIlllII = llllllllllllllIIIIlllllIIIIIIlIl.getBoundsFlags();
        final AmbientOcclusionFace llllllllllllllIIIIlllllIIIIllIll = llllllllllllllIIIIlllllIIIIIIlIl.getAoFace();
        final IBlockState llllllllllllllIIIIlllllIIIIllIlI = llllllllllllllIIIIlllllIIIIIIlIl.getBlockState();
        double llllllllllllllIIIIlllllIIIIllIIl = llllllllllllllIIIIlllllIIIIIlIII.getX();
        double llllllllllllllIIIIlllllIIIIllIII = llllllllllllllIIIIlllllIIIIIlIII.getY();
        double llllllllllllllIIIIlllllIIIIlIlll = llllllllllllllIIIIlllllIIIIIlIII.getZ();
        final Block.EnumOffsetType llllllllllllllIIIIlllllIIIIlIllI = llllllllllllllIIIIlllllIIIlIIIlI.getOffsetType();
        if (llllllllllllllIIIIlllllIIIIlIllI != Block.EnumOffsetType.NONE) {
            final long llllllllllllllIIIIlllllIIIIlIlIl = MathHelper.func_180186_a(llllllllllllllIIIIlllllIIIIIlIII);
            llllllllllllllIIIIlllllIIIIllIIl += ((llllllllllllllIIIIlllllIIIIlIlIl >> 16 & 0xFL) / 15.0f - 0.5) * 0.5;
            llllllllllllllIIIIlllllIIIIlIlll += ((llllllllllllllIIIIlllllIIIIlIlIl >> 24 & 0xFL) / 15.0f - 0.5) * 0.5;
            if (llllllllllllllIIIIlllllIIIIlIllI == Block.EnumOffsetType.XYZ) {
                llllllllllllllIIIIlllllIIIIllIII += ((llllllllllllllIIIIlllllIIIIlIlIl >> 20 & 0xFL) / 15.0f - 1.0) * 0.2;
            }
        }
        for (BakedQuad llllllllllllllIIIIlllllIIIIlIIll : llllllllllllllIIIIlllllIIIIIIllI) {
            if (!llllllllllllllIIIIlllllIIIIIIlIl.isBreakingAnimation(llllllllllllllIIIIlllllIIIIlIIll)) {
                final BakedQuad llllllllllllllIIIIlllllIIIIlIIlI = llllllllllllllIIIIlllllIIIIlIIll;
                if (Config.isConnectedTextures()) {
                    llllllllllllllIIIIlllllIIIIlIIll = ConnectedTextures.getConnectedTexture(llllllllllllllIIIIlllllIIIlIIIll, llllllllllllllIIIIlllllIIIIllIlI, llllllllllllllIIIIlllllIIIIIlIII, llllllllllllllIIIIlllllIIIIlIIll, llllllllllllllIIIIlllllIIIIIIlIl);
                }
                if (llllllllllllllIIIIlllllIIIIlIIll == llllllllllllllIIIIlllllIIIIlIIlI && Config.isNaturalTextures()) {
                    llllllllllllllIIIIlllllIIIIlIIll = NaturalTextures.getNaturalTexture(llllllllllllllIIIIlllllIIIIIlIII, llllllllllllllIIIIlllllIIIIlIIll);
                }
            }
            this.func_178261_a(llllllllllllllIIIIlllllIIIlIIIlI, llllllllllllllIIIIlllllIIIIlIIll.func_178209_a(), llllllllllllllIIIIlllllIIIIlIIll.getFace(), llllllllllllllIIIIlllllIIIIlllIl, llllllllllllllIIIIlllllIIIIlllII);
            llllllllllllllIIIIlllllIIIIllIll.func_178204_a(llllllllllllllIIIIlllllIIIlIIIll, llllllllllllllIIIIlllllIIIlIIIlI, llllllllllllllIIIIlllllIIIIIlIII, llllllllllllllIIIIlllllIIIIlIIll.getFace(), llllllllllllllIIIIlllllIIIIlllIl, llllllllllllllIIIIlllllIIIIlllII);
            if (llllllllllllllIIIIlllllIIIIIIlll.isMultiTexture()) {
                llllllllllllllIIIIlllllIIIIIIlll.func_178981_a(llllllllllllllIIIIlllllIIIIlIIll.getVertexDataSingle());
                llllllllllllllIIIIlllllIIIIIIlll.putSprite(llllllllllllllIIIIlllllIIIIlIIll.getSprite());
            }
            else {
                llllllllllllllIIIIlllllIIIIIIlll.func_178981_a(llllllllllllllIIIIlllllIIIIlIIll.func_178209_a());
            }
            llllllllllllllIIIIlllllIIIIIIlll.func_178962_a(llllllllllllllIIIIlllllIIIIllIll.field_178207_c[0], llllllllllllllIIIIlllllIIIIllIll.field_178207_c[1], llllllllllllllIIIIlllllIIIIllIll.field_178207_c[2], llllllllllllllIIIIlllllIIIIllIll.field_178207_c[3]);
            final int llllllllllllllIIIIlllllIIIIlIIIl = CustomColors.getColorMultiplier(llllllllllllllIIIIlllllIIIIlIIll, llllllllllllllIIIIlllllIIIlIIIlI, llllllllllllllIIIIlllllIIIlIIIll, llllllllllllllIIIIlllllIIIIIlIII, llllllllllllllIIIIlllllIIIIIIlIl);
            if (!llllllllllllllIIIIlllllIIIIlIIll.func_178212_b() && llllllllllllllIIIIlllllIIIIlIIIl == -1) {
                llllllllllllllIIIIlllllIIIIIIlll.func_178978_a(llllllllllllllIIIIlllllIIIIllIll.field_178206_b[0], llllllllllllllIIIIlllllIIIIllIll.field_178206_b[0], llllllllllllllIIIIlllllIIIIllIll.field_178206_b[0], 4);
                llllllllllllllIIIIlllllIIIIIIlll.func_178978_a(llllllllllllllIIIIlllllIIIIllIll.field_178206_b[1], llllllllllllllIIIIlllllIIIIllIll.field_178206_b[1], llllllllllllllIIIIlllllIIIIllIll.field_178206_b[1], 3);
                llllllllllllllIIIIlllllIIIIIIlll.func_178978_a(llllllllllllllIIIIlllllIIIIllIll.field_178206_b[2], llllllllllllllIIIIlllllIIIIllIll.field_178206_b[2], llllllllllllllIIIIlllllIIIIllIll.field_178206_b[2], 2);
                llllllllllllllIIIIlllllIIIIIIlll.func_178978_a(llllllllllllllIIIIlllllIIIIllIll.field_178206_b[3], llllllllllllllIIIIlllllIIIIllIll.field_178206_b[3], llllllllllllllIIIIlllllIIIIllIll.field_178206_b[3], 1);
            }
            else {
                int llllllllllllllIIIIlllllIIIIIllll = 0;
                if (llllllllllllllIIIIlllllIIIIlIIIl != -1) {
                    final int llllllllllllllIIIIlllllIIIIlIIII = llllllllllllllIIIIlllllIIIIlIIIl;
                }
                else {
                    llllllllllllllIIIIlllllIIIIIllll = llllllllllllllIIIIlllllIIIlIIIlI.colorMultiplier(llllllllllllllIIIIlllllIIIlIIIll, llllllllllllllIIIIlllllIIIIIlIII, llllllllllllllIIIIlllllIIIIlIIll.func_178211_c());
                }
                if (EntityRenderer.anaglyphEnable) {
                    llllllllllllllIIIIlllllIIIIIllll = TextureUtil.func_177054_c(llllllllllllllIIIIlllllIIIIIllll);
                }
                final float llllllllllllllIIIIlllllIIIIIlllI = (llllllllllllllIIIIlllllIIIIIllll >> 16 & 0xFF) / 255.0f;
                final float llllllllllllllIIIIlllllIIIIIllIl = (llllllllllllllIIIIlllllIIIIIllll >> 8 & 0xFF) / 255.0f;
                final float llllllllllllllIIIIlllllIIIIIllII = (llllllllllllllIIIIlllllIIIIIllll & 0xFF) / 255.0f;
                llllllllllllllIIIIlllllIIIIIIlll.func_178978_a(llllllllllllllIIIIlllllIIIIllIll.field_178206_b[0] * llllllllllllllIIIIlllllIIIIIlllI, llllllllllllllIIIIlllllIIIIllIll.field_178206_b[0] * llllllllllllllIIIIlllllIIIIIllIl, llllllllllllllIIIIlllllIIIIllIll.field_178206_b[0] * llllllllllllllIIIIlllllIIIIIllII, 4);
                llllllllllllllIIIIlllllIIIIIIlll.func_178978_a(llllllllllllllIIIIlllllIIIIllIll.field_178206_b[1] * llllllllllllllIIIIlllllIIIIIlllI, llllllllllllllIIIIlllllIIIIllIll.field_178206_b[1] * llllllllllllllIIIIlllllIIIIIllIl, llllllllllllllIIIIlllllIIIIllIll.field_178206_b[1] * llllllllllllllIIIIlllllIIIIIllII, 3);
                llllllllllllllIIIIlllllIIIIIIlll.func_178978_a(llllllllllllllIIIIlllllIIIIllIll.field_178206_b[2] * llllllllllllllIIIIlllllIIIIIlllI, llllllllllllllIIIIlllllIIIIllIll.field_178206_b[2] * llllllllllllllIIIIlllllIIIIIllIl, llllllllllllllIIIIlllllIIIIllIll.field_178206_b[2] * llllllllllllllIIIIlllllIIIIIllII, 2);
                llllllllllllllIIIIlllllIIIIIIlll.func_178978_a(llllllllllllllIIIIlllllIIIIllIll.field_178206_b[3] * llllllllllllllIIIIlllllIIIIIlllI, llllllllllllllIIIIlllllIIIIllIll.field_178206_b[3] * llllllllllllllIIIIlllllIIIIIllIl, llllllllllllllIIIIlllllIIIIllIll.field_178206_b[3] * llllllllllllllIIIIlllllIIIIIllII, 1);
            }
            llllllllllllllIIIIlllllIIIIIIlll.func_178987_a(llllllllllllllIIIIlllllIIIIllIIl, llllllllllllllIIIIlllllIIIIllIII, llllllllllllllIIIIlllllIIIIlIlll);
        }
    }
    
    static {
        __OBFID = "CL_00002518";
        BlockModelRenderer.aoLightValueOpaque = 0.2f;
    }
    
    public void func_178266_a(final IBakedModel llllllllllllllIIIIllllIlIlIlIIIl, final IBlockState llllllllllllllIIIIllllIlIlIIIllI, final float llllllllllllllIIIIllllIlIlIIllll, final boolean llllllllllllllIIIIllllIlIlIIIlII) {
        final Block llllllllllllllIIIIllllIlIlIIllIl = llllllllllllllIIIIllllIlIlIIIllI.getBlock();
        llllllllllllllIIIIllllIlIlIIllIl.setBlockBoundsForItemRender();
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        int llllllllllllllIIIIllllIlIlIIllII = llllllllllllllIIIIllllIlIlIIllIl.getRenderColor(llllllllllllllIIIIllllIlIlIIllIl.getStateForEntityRender(llllllllllllllIIIIllllIlIlIIIllI));
        if (EntityRenderer.anaglyphEnable) {
            llllllllllllllIIIIllllIlIlIIllII = TextureUtil.func_177054_c(llllllllllllllIIIIllllIlIlIIllII);
        }
        final float llllllllllllllIIIIllllIlIlIIlIll = (llllllllllllllIIIIllllIlIlIIllII >> 16 & 0xFF) / 255.0f;
        final float llllllllllllllIIIIllllIlIlIIlIlI = (llllllllllllllIIIIllllIlIlIIllII >> 8 & 0xFF) / 255.0f;
        final float llllllllllllllIIIIllllIlIlIIlIIl = (llllllllllllllIIIIllllIlIlIIllII & 0xFF) / 255.0f;
        if (!llllllllllllllIIIIllllIlIlIIIlII) {
            GlStateManager.color(llllllllllllllIIIIllllIlIlIIllll, llllllllllllllIIIIllllIlIlIIllll, llllllllllllllIIIIllllIlIlIIllll, 1.0f);
        }
        this.func_178262_a(llllllllllllllIIIIllllIlIlIlIIIl, llllllllllllllIIIIllllIlIlIIllll, llllllllllllllIIIIllllIlIlIIlIll, llllllllllllllIIIIllllIlIlIIlIlI, llllllllllllllIIIIllllIlIlIIlIIl);
    }
    
    public boolean renderBlockModel(final IBlockAccess llllllllllllllIIIIlllllIllIlIlll, IBakedModel llllllllllllllIIIIlllllIllIlIllI, final IBlockState llllllllllllllIIIIlllllIlllIIIIl, final BlockPos llllllllllllllIIIIlllllIllIlIlII, final WorldRenderer llllllllllllllIIIIlllllIllIlIIll, final boolean llllllllllllllIIIIlllllIllIllllI) {
        final boolean llllllllllllllIIIIlllllIllIlllIl = Minecraft.isAmbientOcclusionEnabled() && llllllllllllllIIIIlllllIlllIIIIl.getBlock().getLightValue() == 0 && llllllllllllllIIIIlllllIllIlIllI.isGui3d();
        try {
            final Block llllllllllllllIIIIlllllIllIlllII = llllllllllllllIIIIlllllIlllIIIIl.getBlock();
            if (Config.isTreesSmart() && llllllllllllllIIIIlllllIlllIIIIl.getBlock() instanceof BlockLeavesBase) {
                llllllllllllllIIIIlllllIllIlIllI = SmartLeaves.getLeavesModel(llllllllllllllIIIIlllllIllIlIllI);
            }
            return llllllllllllllIIIIlllllIllIlllIl ? this.renderModelAmbientOcclusion(llllllllllllllIIIIlllllIllIlIlll, llllllllllllllIIIIlllllIllIlIllI, llllllllllllllIIIIlllllIllIlllII, llllllllllllllIIIIlllllIlllIIIIl, llllllllllllllIIIIlllllIllIlIlII, llllllllllllllIIIIlllllIllIlIIll, llllllllllllllIIIIlllllIllIllllI) : this.renderModelStandard(llllllllllllllIIIIlllllIllIlIlll, llllllllllllllIIIIlllllIllIlIllI, llllllllllllllIIIIlllllIllIlllII, llllllllllllllIIIIlllllIlllIIIIl, llllllllllllllIIIIlllllIllIlIlII, llllllllllllllIIIIlllllIllIlIIll, llllllllllllllIIIIlllllIllIllllI);
        }
        catch (Throwable llllllllllllllIIIIlllllIllIllIll) {
            final CrashReport llllllllllllllIIIIlllllIllIllIlI = CrashReport.makeCrashReport(llllllllllllllIIIIlllllIllIllIll, "Tesselating block model");
            final CrashReportCategory llllllllllllllIIIIlllllIllIllIIl = llllllllllllllIIIIlllllIllIllIlI.makeCategory("Block model being tesselated");
            CrashReportCategory.addBlockInfo(llllllllllllllIIIIlllllIllIllIIl, llllllllllllllIIIIlllllIllIlIlII, llllllllllllllIIIIlllllIlllIIIIl);
            llllllllllllllIIIIlllllIllIllIIl.addCrashSection("Using AO", llllllllllllllIIIIlllllIllIlllIl);
            throw new ReportedException(llllllllllllllIIIIlllllIllIllIlI);
        }
    }
    
    private void func_178264_a(final float llllllllllllllIIIIllllIlIIllIIll, final float llllllllllllllIIIIllllIlIIllIIlI, final float llllllllllllllIIIIllllIlIIlIIlll, final float llllllllllllllIIIIllllIlIIllIIII, final List llllllllllllllIIIIllllIlIIlIllll) {
        final Tessellator llllllllllllllIIIIllllIlIIlIlllI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIIIIllllIlIIlIllIl = llllllllllllllIIIIllllIlIIlIlllI.getWorldRenderer();
        for (final BakedQuad llllllllllllllIIIIllllIlIIlIlIll : llllllllllllllIIIIllllIlIIlIllll) {
            llllllllllllllIIIIllllIlIIlIllIl.startDrawingQuads();
            llllllllllllllIIIIllllIlIIlIllIl.setVertexFormat(DefaultVertexFormats.field_176599_b);
            llllllllllllllIIIIllllIlIIlIllIl.func_178981_a(llllllllllllllIIIIllllIlIIlIlIll.func_178209_a());
            if (llllllllllllllIIIIllllIlIIlIlIll.func_178212_b()) {
                llllllllllllllIIIIllllIlIIlIllIl.func_178990_f(llllllllllllllIIIIllllIlIIllIIlI * llllllllllllllIIIIllllIlIIllIIll, llllllllllllllIIIIllllIlIIlIIlll * llllllllllllllIIIIllllIlIIllIIll, llllllllllllllIIIIllllIlIIllIIII * llllllllllllllIIIIllllIlIIllIIll);
            }
            else {
                llllllllllllllIIIIllllIlIIlIllIl.func_178990_f(llllllllllllllIIIIllllIlIIllIIll, llllllllllllllIIIIllllIlIIllIIll, llllllllllllllIIIIllllIlIIllIIll);
            }
            final Vec3i llllllllllllllIIIIllllIlIIlIlIlI = llllllllllllllIIIIllllIlIIlIlIll.getFace().getDirectionVec();
            llllllllllllllIIIIllllIlIIlIllIl.func_178975_e((float)llllllllllllllIIIIllllIlIIlIlIlI.getX(), (float)llllllllllllllIIIIllllIlIIlIlIlI.getY(), (float)llllllllllllllIIIIllllIlIIlIlIlI.getZ());
            llllllllllllllIIIIllllIlIIlIlllI.draw();
        }
    }
    
    public BlockModelRenderer() {
        if (Reflector.ForgeModContainer_forgeLightPipelineEnabled.exists()) {
            Reflector.setFieldValue(Reflector.ForgeModContainer_forgeLightPipelineEnabled, false);
        }
    }
    
    public boolean renderModelAmbientOcclusion(final IBlockAccess llllllllllllllIIIIlllllIlIlIIlll, final IBakedModel llllllllllllllIIIIlllllIlIIlIIll, final Block llllllllllllllIIIIlllllIlIlIIlIl, final IBlockState llllllllllllllIIIIlllllIlIlIIlII, final BlockPos llllllllllllllIIIIlllllIlIIlIIII, final WorldRenderer llllllllllllllIIIIlllllIlIlIIIlI, final boolean llllllllllllllIIIIlllllIlIlIIIIl) {
        boolean llllllllllllllIIIIlllllIlIlIIIII = false;
        llllllllllllllIIIIlllllIlIlIIIlI.func_178963_b(983055);
        RenderEnv llllllllllllllIIIIlllllIlIIlllll = null;
        for (final EnumFacing llllllllllllllIIIIlllllIlIIllIll : EnumFacing.VALUES) {
            List llllllllllllllIIIIlllllIlIIllIlI = llllllllllllllIIIIlllllIlIIlIIll.func_177551_a(llllllllllllllIIIIlllllIlIIllIll);
            if (!llllllllllllllIIIIlllllIlIIllIlI.isEmpty()) {
                final BlockPos llllllllllllllIIIIlllllIlIIllIIl = llllllllllllllIIIIlllllIlIIlIIII.offset(llllllllllllllIIIIlllllIlIIllIll);
                if (!llllllllllllllIIIIlllllIlIlIIIIl || llllllllllllllIIIIlllllIlIlIIlIl.shouldSideBeRendered(llllllllllllllIIIIlllllIlIlIIlll, llllllllllllllIIIIlllllIlIIllIIl, llllllllllllllIIIIlllllIlIIllIll)) {
                    if (llllllllllllllIIIIlllllIlIIlllll == null) {
                        llllllllllllllIIIIlllllIlIIlllll = RenderEnv.getInstance(llllllllllllllIIIIlllllIlIlIIlll, llllllllllllllIIIIlllllIlIlIIlII, llllllllllllllIIIIlllllIlIIlIIII);
                    }
                    if (!llllllllllllllIIIIlllllIlIIlllll.isBreakingAnimation(llllllllllllllIIIIlllllIlIIllIlI) && Config.isBetterGrass()) {
                        llllllllllllllIIIIlllllIlIIllIlI = BetterGrass.getFaceQuads(llllllllllllllIIIIlllllIlIlIIlll, llllllllllllllIIIIlllllIlIlIIlIl, llllllllllllllIIIIlllllIlIIlIIII, llllllllllllllIIIIlllllIlIIllIll, llllllllllllllIIIIlllllIlIIllIlI);
                    }
                    this.renderModelAmbientOcclusionQuads(llllllllllllllIIIIlllllIlIlIIlll, llllllllllllllIIIIlllllIlIlIIlIl, llllllllllllllIIIIlllllIlIIlIIII, llllllllllllllIIIIlllllIlIlIIIlI, llllllllllllllIIIIlllllIlIIllIlI, llllllllllllllIIIIlllllIlIIlllll);
                    llllllllllllllIIIIlllllIlIlIIIII = true;
                }
            }
        }
        final List llllllllllllllIIIIlllllIlIIllIII = llllllllllllllIIIIlllllIlIIlIIll.func_177550_a();
        if (llllllllllllllIIIIlllllIlIIllIII.size() > 0) {
            if (llllllllllllllIIIIlllllIlIIlllll == null) {
                llllllllllllllIIIIlllllIlIIlllll = RenderEnv.getInstance(llllllllllllllIIIIlllllIlIlIIlll, llllllllllllllIIIIlllllIlIlIIlII, llllllllllllllIIIIlllllIlIIlIIII);
            }
            this.renderModelAmbientOcclusionQuads(llllllllllllllIIIIlllllIlIlIIlll, llllllllllllllIIIIlllllIlIlIIlIl, llllllllllllllIIIIlllllIlIIlIIII, llllllllllllllIIIIlllllIlIlIIIlI, llllllllllllllIIIIlllllIlIIllIII, llllllllllllllIIIIlllllIlIIlllll);
            llllllllllllllIIIIlllllIlIlIIIII = true;
        }
        if (llllllllllllllIIIIlllllIlIIlllll != null && Config.isBetterSnow() && !llllllllllllllIIIIlllllIlIIlllll.isBreakingAnimation() && BetterSnow.shouldRender(llllllllllllllIIIIlllllIlIlIIlll, llllllllllllllIIIIlllllIlIlIIlIl, llllllllllllllIIIIlllllIlIlIIlII, llllllllllllllIIIIlllllIlIIlIIII)) {
            final IBakedModel llllllllllllllIIIIlllllIlIIlIlll = BetterSnow.getModelSnowLayer();
            final IBlockState llllllllllllllIIIIlllllIlIIlIllI = BetterSnow.getStateSnowLayer();
            this.renderModelAmbientOcclusion(llllllllllllllIIIIlllllIlIlIIlll, llllllllllllllIIIIlllllIlIIlIlll, llllllllllllllIIIIlllllIlIIlIllI.getBlock(), llllllllllllllIIIIlllllIlIIlIllI, llllllllllllllIIIIlllllIlIIlIIII, llllllllllllllIIIIlllllIlIlIIIlI, true);
        }
        return llllllllllllllIIIIlllllIlIlIIIII;
    }
    
    public enum Orientation
    {
        protected final /* synthetic */ int field_178229_m;
        
        DOWN("DOWN", 0, "DOWN", 0, "DOWN", 0, EnumFacing.DOWN, false), 
        WEST("WEST", 4, "WEST", 4, "WEST", 4, EnumFacing.WEST, false), 
        FLIP_WEST("FLIP_WEST", 10, "FLIP_WEST", 10, "FLIP_WEST", 10, EnumFacing.WEST, true), 
        FLIP_SOUTH("FLIP_SOUTH", 9, "FLIP_SOUTH", 9, "FLIP_SOUTH", 9, EnumFacing.SOUTH, true), 
        FLIP_EAST("FLIP_EAST", 11, "FLIP_EAST", 11, "FLIP_EAST", 11, EnumFacing.EAST, true), 
        UP("UP", 1, "UP", 1, "UP", 1, EnumFacing.UP, false), 
        FLIP_NORTH("FLIP_NORTH", 8, "FLIP_NORTH", 8, "FLIP_NORTH", 8, EnumFacing.NORTH, true), 
        NORTH("NORTH", 2, "NORTH", 2, "NORTH", 2, EnumFacing.NORTH, false), 
        FLIP_DOWN("FLIP_DOWN", 6, "FLIP_DOWN", 6, "FLIP_DOWN", 6, EnumFacing.DOWN, true), 
        EAST("EAST", 5, "EAST", 5, "EAST", 5, EnumFacing.EAST, false), 
        FLIP_UP("FLIP_UP", 7, "FLIP_UP", 7, "FLIP_UP", 7, EnumFacing.UP, true), 
        SOUTH("SOUTH", 3, "SOUTH", 3, "SOUTH", 3, EnumFacing.SOUTH, false);
        
        private Orientation(final String lIlIlIllIIlIII, final int lIlIlIllIIIlll, final String lIlIlIllIIllll, final int lIlIlIllIIlllI, final String lIlIlIllIIllIl, final int lIlIlIllIIllII, final EnumFacing lIlIlIllIIIllI, final boolean lIlIlIllIIlIlI) {
            this.field_178229_m = lIlIlIllIIIllI.getIndex() + (lIlIlIllIIlIlI ? EnumFacing.values().length : 0);
        }
        
        static {
            __OBFID = "CL_00002513";
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_178290_a;
        
        static {
            __OBFID = "CL_00002517";
            field_178290_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_178290_a[EnumFacing.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_178290_a[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_178290_a[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_178290_a[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumFacing.field_178290_a[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                SwitchEnumFacing.field_178290_a[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
    
    public static class AmbientOcclusionFace
    {
        private final /* synthetic */ float[] field_178206_b;
        private final /* synthetic */ int[] field_178207_c;
        
        public AmbientOcclusionFace() {
            this.field_178206_b = new float[4];
            this.field_178207_c = new int[4];
        }
        
        private int getAoBrightness(int llllllllllllllIlllIllIllIIIllIll, int llllllllllllllIlllIllIllIIIllIlI, int llllllllllllllIlllIllIllIIIllIIl, final int llllllllllllllIlllIllIllIIIlllII) {
            if (llllllllllllllIlllIllIllIIIllIll == 0) {
                llllllllllllllIlllIllIllIIIllIll = llllllllllllllIlllIllIllIIIlllII;
            }
            if (llllllllllllllIlllIllIllIIIllIlI == 0) {
                llllllllllllllIlllIllIllIIIllIlI = llllllllllllllIlllIllIllIIIlllII;
            }
            if (llllllllllllllIlllIllIllIIIllIIl == 0) {
                llllllllllllllIlllIllIllIIIllIIl = llllllllllllllIlllIllIllIIIlllII;
            }
            return llllllllllllllIlllIllIllIIIllIll + llllllllllllllIlllIllIllIIIllIlI + llllllllllllllIlllIllIllIIIllIIl + llllllllllllllIlllIllIllIIIlllII >> 2 & 0xFF00FF;
        }
        
        static {
            __OBFID = "CL_00002515";
        }
        
        public void func_178204_a(final IBlockAccess llllllllllllllIlllIllIllIllIIIII, final Block llllllllllllllIlllIllIllIlIlllll, final BlockPos llllllllllllllIlllIllIlllIlIlIlI, final EnumFacing llllllllllllllIlllIllIllIlIlllIl, final float[] llllllllllllllIlllIllIllIlIlllII, final BitSet llllllllllllllIlllIllIlllIlIIlll) {
            final BlockPos llllllllllllllIlllIllIlllIlIIllI = llllllllllllllIlllIllIlllIlIIlll.get(0) ? llllllllllllllIlllIllIlllIlIlIlI.offset(llllllllllllllIlllIllIllIlIlllIl) : llllllllllllllIlllIllIlllIlIlIlI;
            final EnumNeighborInfo llllllllllllllIlllIllIlllIlIIlIl = EnumNeighborInfo.func_178273_a(llllllllllllllIlllIllIllIlIlllIl);
            final BlockPos llllllllllllllIlllIllIlllIlIIlII = llllllllllllllIlllIllIlllIlIIllI.offset(llllllllllllllIlllIllIlllIlIIlIl.field_178276_g[0]);
            final BlockPos llllllllllllllIlllIllIlllIlIIIll = llllllllllllllIlllIllIlllIlIIllI.offset(llllllllllllllIlllIllIlllIlIIlIl.field_178276_g[1]);
            final BlockPos llllllllllllllIlllIllIlllIlIIIlI = llllllllllllllIlllIllIlllIlIIllI.offset(llllllllllllllIlllIllIlllIlIIlIl.field_178276_g[2]);
            final BlockPos llllllllllllllIlllIllIlllIlIIIIl = llllllllllllllIlllIllIlllIlIIllI.offset(llllllllllllllIlllIllIlllIlIIlIl.field_178276_g[3]);
            final int llllllllllllllIlllIllIlllIlIIIII = llllllllllllllIlllIllIllIlIlllll.getMixedBrightnessForBlock(llllllllllllllIlllIllIllIllIIIII, llllllllllllllIlllIllIlllIlIIlII);
            final int llllllllllllllIlllIllIlllIIlllll = llllllllllllllIlllIllIllIlIlllll.getMixedBrightnessForBlock(llllllllllllllIlllIllIllIllIIIII, llllllllllllllIlllIllIlllIlIIIll);
            final int llllllllllllllIlllIllIlllIIllllI = llllllllllllllIlllIllIllIlIlllll.getMixedBrightnessForBlock(llllllllllllllIlllIllIllIllIIIII, llllllllllllllIlllIllIlllIlIIIlI);
            final int llllllllllllllIlllIllIlllIIlllIl = llllllllllllllIlllIllIllIlIlllll.getMixedBrightnessForBlock(llllllllllllllIlllIllIllIllIIIII, llllllllllllllIlllIllIlllIlIIIIl);
            final float llllllllllllllIlllIllIlllIIlllII = BlockModelRenderer.fixAoLightValue(llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIIlII).getBlock().getAmbientOcclusionLightValue());
            final float llllllllllllllIlllIllIlllIIllIll = BlockModelRenderer.fixAoLightValue(llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIIIll).getBlock().getAmbientOcclusionLightValue());
            final float llllllllllllllIlllIllIlllIIllIlI = BlockModelRenderer.fixAoLightValue(llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIIIlI).getBlock().getAmbientOcclusionLightValue());
            final float llllllllllllllIlllIllIlllIIllIIl = BlockModelRenderer.fixAoLightValue(llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIIIIl).getBlock().getAmbientOcclusionLightValue());
            final boolean llllllllllllllIlllIllIlllIIllIII = llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIIlII.offset(llllllllllllllIlllIllIllIlIlllIl)).getBlock().isTranslucent();
            final boolean llllllllllllllIlllIllIlllIIlIlll = llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIIIll.offset(llllllllllllllIlllIllIllIlIlllIl)).getBlock().isTranslucent();
            final boolean llllllllllllllIlllIllIlllIIlIllI = llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIIIlI.offset(llllllllllllllIlllIllIllIlIlllIl)).getBlock().isTranslucent();
            final boolean llllllllllllllIlllIllIlllIIlIlIl = llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIIIIl.offset(llllllllllllllIlllIllIllIlIlllIl)).getBlock().isTranslucent();
            float llllllllllllllIlllIllIlllIIlIIll = 0.0f;
            int llllllllllllllIlllIllIlllIIlIIIl = 0;
            if (!llllllllllllllIlllIllIlllIIlIllI && !llllllllllllllIlllIllIlllIIllIII) {
                final float llllllllllllllIlllIllIlllIIlIlII = llllllllllllllIlllIllIlllIIlllII;
                final int llllllllllllllIlllIllIlllIIlIIlI = llllllllllllllIlllIllIlllIlIIIII;
            }
            else {
                final BlockPos llllllllllllllIlllIllIlllIIlIIII = llllllllllllllIlllIllIlllIlIIlII.offset(llllllllllllllIlllIllIlllIlIIlIl.field_178276_g[2]);
                llllllllllllllIlllIllIlllIIlIIll = BlockModelRenderer.fixAoLightValue(llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIIlIIII).getBlock().getAmbientOcclusionLightValue());
                llllllllllllllIlllIllIlllIIlIIIl = llllllllllllllIlllIllIllIlIlllll.getMixedBrightnessForBlock(llllllllllllllIlllIllIllIllIIIII, llllllllllllllIlllIllIlllIIlIIII);
            }
            float llllllllllllllIlllIllIlllIIIlIll = 0.0f;
            int llllllllllllllIlllIllIlllIIIlIIl = 0;
            if (!llllllllllllllIlllIllIlllIIlIlIl && !llllllllllllllIlllIllIlllIIllIII) {
                final float llllllllllllllIlllIllIlllIIIllII = llllllllllllllIlllIllIlllIIlllII;
                final int llllllllllllllIlllIllIlllIIIlIlI = llllllllllllllIlllIllIlllIlIIIII;
            }
            else {
                final BlockPos llllllllllllllIlllIllIlllIIIllll = llllllllllllllIlllIllIlllIlIIlII.offset(llllllllllllllIlllIllIlllIlIIlIl.field_178276_g[3]);
                llllllllllllllIlllIllIlllIIIlIll = BlockModelRenderer.fixAoLightValue(llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIIIllll).getBlock().getAmbientOcclusionLightValue());
                llllllllllllllIlllIllIlllIIIlIIl = llllllllllllllIlllIllIllIlIlllll.getMixedBrightnessForBlock(llllllllllllllIlllIllIllIllIIIII, llllllllllllllIlllIllIlllIIIllll);
            }
            float llllllllllllllIlllIllIlllIIIIlll = 0.0f;
            int llllllllllllllIlllIllIlllIIIIlIl = 0;
            if (!llllllllllllllIlllIllIlllIIlIllI && !llllllllllllllIlllIllIlllIIlIlll) {
                final float llllllllllllllIlllIllIlllIIIlIII = llllllllllllllIlllIllIlllIIllIll;
                final int llllllllllllllIlllIllIlllIIIIllI = llllllllllllllIlllIllIlllIIlllll;
            }
            else {
                final BlockPos llllllllllllllIlllIllIlllIIIlllI = llllllllllllllIlllIllIlllIlIIIll.offset(llllllllllllllIlllIllIlllIlIIlIl.field_178276_g[2]);
                llllllllllllllIlllIllIlllIIIIlll = BlockModelRenderer.fixAoLightValue(llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIIIlllI).getBlock().getAmbientOcclusionLightValue());
                llllllllllllllIlllIllIlllIIIIlIl = llllllllllllllIlllIllIllIlIlllll.getMixedBrightnessForBlock(llllllllllllllIlllIllIllIllIIIII, llllllllllllllIlllIllIlllIIIlllI);
            }
            float llllllllllllllIlllIllIlllIIIIIll = 0.0f;
            int llllllllllllllIlllIllIlllIIIIIIl = 0;
            if (!llllllllllllllIlllIllIlllIIlIlIl && !llllllllllllllIlllIllIlllIIlIlll) {
                final float llllllllllllllIlllIllIlllIIIIlII = llllllllllllllIlllIllIlllIIllIll;
                final int llllllllllllllIlllIllIlllIIIIIlI = llllllllllllllIlllIllIlllIIlllll;
            }
            else {
                final BlockPos llllllllllllllIlllIllIlllIIIllIl = llllllllllllllIlllIllIlllIlIIIll.offset(llllllllllllllIlllIllIlllIlIIlIl.field_178276_g[3]);
                llllllllllllllIlllIllIlllIIIIIll = BlockModelRenderer.fixAoLightValue(llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIIIllIl).getBlock().getAmbientOcclusionLightValue());
                llllllllllllllIlllIllIlllIIIIIIl = llllllllllllllIlllIllIllIlIlllll.getMixedBrightnessForBlock(llllllllllllllIlllIllIllIllIIIII, llllllllllllllIlllIllIlllIIIllIl);
            }
            int llllllllllllllIlllIllIlllIIIIIII = llllllllllllllIlllIllIllIlIlllll.getMixedBrightnessForBlock(llllllllllllllIlllIllIllIllIIIII, llllllllllllllIlllIllIlllIlIlIlI);
            if (llllllllllllllIlllIllIlllIlIIlll.get(0) || !llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIlIlI.offset(llllllllllllllIlllIllIllIlIlllIl)).getBlock().isOpaqueCube()) {
                llllllllllllllIlllIllIlllIIIIIII = llllllllllllllIlllIllIllIlIlllll.getMixedBrightnessForBlock(llllllllllllllIlllIllIllIllIIIII, llllllllllllllIlllIllIlllIlIlIlI.offset(llllllllllllllIlllIllIllIlIlllIl));
            }
            float llllllllllllllIlllIllIllIlllllll = llllllllllllllIlllIllIlllIlIIlll.get(0) ? llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIIllI).getBlock().getAmbientOcclusionLightValue() : llllllllllllllIlllIllIllIllIIIII.getBlockState(llllllllllllllIlllIllIlllIlIlIlI).getBlock().getAmbientOcclusionLightValue();
            llllllllllllllIlllIllIllIlllllll = BlockModelRenderer.fixAoLightValue(llllllllllllllIlllIllIllIlllllll);
            final VertexTranslations llllllllllllllIlllIllIllIllllllI = VertexTranslations.func_178184_a(llllllllllllllIlllIllIllIlIlllIl);
            if (llllllllllllllIlllIllIlllIlIIlll.get(1) && llllllllllllllIlllIllIlllIlIIlIl.field_178289_i) {
                final float llllllllllllllIlllIllIllIlllllIl = (llllllllllllllIlllIllIlllIIllIIl + llllllllllllllIlllIllIlllIIlllII + llllllllllllllIlllIllIlllIIIlIll + llllllllllllllIlllIllIllIlllllll) * 0.25f;
                final float llllllllllllllIlllIllIllIllllIll = (llllllllllllllIlllIllIlllIIllIlI + llllllllllllllIlllIllIlllIIlllII + llllllllllllllIlllIllIlllIIlIIll + llllllllllllllIlllIllIllIlllllll) * 0.25f;
                final float llllllllllllllIlllIllIllIllllIIl = (llllllllllllllIlllIllIlllIIllIlI + llllllllllllllIlllIllIlllIIllIll + llllllllllllllIlllIllIlllIIIIlll + llllllllllllllIlllIllIllIlllllll) * 0.25f;
                final float llllllllllllllIlllIllIllIlllIlll = (llllllllllllllIlllIllIlllIIllIIl + llllllllllllllIlllIllIlllIIllIll + llllllllllllllIlllIllIlllIIIIIll + llllllllllllllIlllIllIllIlllllll) * 0.25f;
                final float llllllllllllllIlllIllIllIlllIlIl = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178286_j[0].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178286_j[1].field_178229_m];
                final float llllllllllllllIlllIllIllIlllIlII = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178286_j[2].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178286_j[3].field_178229_m];
                final float llllllllllllllIlllIllIllIlllIIll = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178286_j[4].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178286_j[5].field_178229_m];
                final float llllllllllllllIlllIllIllIlllIIlI = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178286_j[6].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178286_j[7].field_178229_m];
                final float llllllllllllllIlllIllIllIlllIIIl = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178287_k[0].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178287_k[1].field_178229_m];
                final float llllllllllllllIlllIllIllIlllIIII = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178287_k[2].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178287_k[3].field_178229_m];
                final float llllllllllllllIlllIllIllIllIllll = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178287_k[4].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178287_k[5].field_178229_m];
                final float llllllllllllllIlllIllIllIllIlllI = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178287_k[6].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178287_k[7].field_178229_m];
                final float llllllllllllllIlllIllIllIllIllIl = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178284_l[0].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178284_l[1].field_178229_m];
                final float llllllllllllllIlllIllIllIllIllII = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178284_l[2].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178284_l[3].field_178229_m];
                final float llllllllllllllIlllIllIllIllIlIll = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178284_l[4].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178284_l[5].field_178229_m];
                final float llllllllllllllIlllIllIllIllIlIlI = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178284_l[6].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178284_l[7].field_178229_m];
                final float llllllllllllllIlllIllIllIllIlIIl = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178285_m[0].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178285_m[1].field_178229_m];
                final float llllllllllllllIlllIllIllIllIlIII = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178285_m[2].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178285_m[3].field_178229_m];
                final float llllllllllllllIlllIllIllIllIIlll = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178285_m[4].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178285_m[5].field_178229_m];
                final float llllllllllllllIlllIllIllIllIIllI = llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178285_m[6].field_178229_m] * llllllllllllllIlllIllIllIlIlllII[llllllllllllllIlllIllIlllIlIIlIl.field_178285_m[7].field_178229_m];
                this.field_178206_b[llllllllllllllIlllIllIllIllllllI.field_178191_g] = llllllllllllllIlllIllIllIlllllIl * llllllllllllllIlllIllIllIlllIlIl + llllllllllllllIlllIllIllIllllIll * llllllllllllllIlllIllIllIlllIlII + llllllllllllllIlllIllIllIllllIIl * llllllllllllllIlllIllIllIlllIIll + llllllllllllllIlllIllIllIlllIlll * llllllllllllllIlllIllIllIlllIIlI;
                this.field_178206_b[llllllllllllllIlllIllIllIllllllI.field_178200_h] = llllllllllllllIlllIllIllIlllllIl * llllllllllllllIlllIllIllIlllIIIl + llllllllllllllIlllIllIllIllllIll * llllllllllllllIlllIllIllIlllIIII + llllllllllllllIlllIllIllIllllIIl * llllllllllllllIlllIllIllIllIllll + llllllllllllllIlllIllIllIlllIlll * llllllllllllllIlllIllIllIllIlllI;
                this.field_178206_b[llllllllllllllIlllIllIllIllllllI.field_178201_i] = llllllllllllllIlllIllIllIlllllIl * llllllllllllllIlllIllIllIllIllIl + llllllllllllllIlllIllIllIllllIll * llllllllllllllIlllIllIllIllIllII + llllllllllllllIlllIllIllIllllIIl * llllllllllllllIlllIllIllIllIlIll + llllllllllllllIlllIllIllIlllIlll * llllllllllllllIlllIllIllIllIlIlI;
                this.field_178206_b[llllllllllllllIlllIllIllIllllllI.field_178198_j] = llllllllllllllIlllIllIllIlllllIl * llllllllllllllIlllIllIllIllIlIIl + llllllllllllllIlllIllIllIllllIll * llllllllllllllIlllIllIllIllIlIII + llllllllllllllIlllIllIllIllllIIl * llllllllllllllIlllIllIllIllIIlll + llllllllllllllIlllIllIllIlllIlll * llllllllllllllIlllIllIllIllIIllI;
                final int llllllllllllllIlllIllIllIllIIlIl = this.getAoBrightness(llllllllllllllIlllIllIlllIIlllIl, llllllllllllllIlllIllIlllIlIIIII, llllllllllllllIlllIllIlllIIIlIIl, llllllllllllllIlllIllIlllIIIIIII);
                final int llllllllllllllIlllIllIllIllIIlII = this.getAoBrightness(llllllllllllllIlllIllIlllIIllllI, llllllllllllllIlllIllIlllIlIIIII, llllllllllllllIlllIllIlllIIlIIIl, llllllllllllllIlllIllIlllIIIIIII);
                final int llllllllllllllIlllIllIllIllIIIll = this.getAoBrightness(llllllllllllllIlllIllIlllIIllllI, llllllllllllllIlllIllIlllIIlllll, llllllllllllllIlllIllIlllIIIIlIl, llllllllllllllIlllIllIlllIIIIIII);
                final int llllllllllllllIlllIllIllIllIIIlI = this.getAoBrightness(llllllllllllllIlllIllIlllIIlllIl, llllllllllllllIlllIllIlllIIlllll, llllllllllllllIlllIllIlllIIIIIIl, llllllllllllllIlllIllIlllIIIIIII);
                this.field_178207_c[llllllllllllllIlllIllIllIllllllI.field_178191_g] = this.func_178203_a(llllllllllllllIlllIllIllIllIIlIl, llllllllllllllIlllIllIllIllIIlII, llllllllllllllIlllIllIllIllIIIll, llllllllllllllIlllIllIllIllIIIlI, llllllllllllllIlllIllIllIlllIlIl, llllllllllllllIlllIllIllIlllIlII, llllllllllllllIlllIllIllIlllIIll, llllllllllllllIlllIllIllIlllIIlI);
                this.field_178207_c[llllllllllllllIlllIllIllIllllllI.field_178200_h] = this.func_178203_a(llllllllllllllIlllIllIllIllIIlIl, llllllllllllllIlllIllIllIllIIlII, llllllllllllllIlllIllIllIllIIIll, llllllllllllllIlllIllIllIllIIIlI, llllllllllllllIlllIllIllIlllIIIl, llllllllllllllIlllIllIllIlllIIII, llllllllllllllIlllIllIllIllIllll, llllllllllllllIlllIllIllIllIlllI);
                this.field_178207_c[llllllllllllllIlllIllIllIllllllI.field_178201_i] = this.func_178203_a(llllllllllllllIlllIllIllIllIIlIl, llllllllllllllIlllIllIllIllIIlII, llllllllllllllIlllIllIllIllIIIll, llllllllllllllIlllIllIllIllIIIlI, llllllllllllllIlllIllIllIllIllIl, llllllllllllllIlllIllIllIllIllII, llllllllllllllIlllIllIllIllIlIll, llllllllllllllIlllIllIllIllIlIlI);
                this.field_178207_c[llllllllllllllIlllIllIllIllllllI.field_178198_j] = this.func_178203_a(llllllllllllllIlllIllIllIllIIlIl, llllllllllllllIlllIllIllIllIIlII, llllllllllllllIlllIllIllIllIIIll, llllllllllllllIlllIllIllIllIIIlI, llllllllllllllIlllIllIllIllIlIIl, llllllllllllllIlllIllIllIllIlIII, llllllllllllllIlllIllIllIllIIlll, llllllllllllllIlllIllIllIllIIllI);
            }
            else {
                final float llllllllllllllIlllIllIllIlllllII = (llllllllllllllIlllIllIlllIIllIIl + llllllllllllllIlllIllIlllIIlllII + llllllllllllllIlllIllIlllIIIlIll + llllllllllllllIlllIllIllIlllllll) * 0.25f;
                final float llllllllllllllIlllIllIllIllllIlI = (llllllllllllllIlllIllIlllIIllIlI + llllllllllllllIlllIllIlllIIlllII + llllllllllllllIlllIllIlllIIlIIll + llllllllllllllIlllIllIllIlllllll) * 0.25f;
                final float llllllllllllllIlllIllIllIllllIII = (llllllllllllllIlllIllIlllIIllIlI + llllllllllllllIlllIllIlllIIllIll + llllllllllllllIlllIllIlllIIIIlll + llllllllllllllIlllIllIllIlllllll) * 0.25f;
                final float llllllllllllllIlllIllIllIlllIllI = (llllllllllllllIlllIllIlllIIllIIl + llllllllllllllIlllIllIlllIIllIll + llllllllllllllIlllIllIlllIIIIIll + llllllllllllllIlllIllIllIlllllll) * 0.25f;
                this.field_178207_c[llllllllllllllIlllIllIllIllllllI.field_178191_g] = this.getAoBrightness(llllllllllllllIlllIllIlllIIlllIl, llllllllllllllIlllIllIlllIlIIIII, llllllllllllllIlllIllIlllIIIlIIl, llllllllllllllIlllIllIlllIIIIIII);
                this.field_178207_c[llllllllllllllIlllIllIllIllllllI.field_178200_h] = this.getAoBrightness(llllllllllllllIlllIllIlllIIllllI, llllllllllllllIlllIllIlllIlIIIII, llllllllllllllIlllIllIlllIIlIIIl, llllllllllllllIlllIllIlllIIIIIII);
                this.field_178207_c[llllllllllllllIlllIllIllIllllllI.field_178201_i] = this.getAoBrightness(llllllllllllllIlllIllIlllIIllllI, llllllllllllllIlllIllIlllIIlllll, llllllllllllllIlllIllIlllIIIIlIl, llllllllllllllIlllIllIlllIIIIIII);
                this.field_178207_c[llllllllllllllIlllIllIllIllllllI.field_178198_j] = this.getAoBrightness(llllllllllllllIlllIllIlllIIlllIl, llllllllllllllIlllIllIlllIIlllll, llllllllllllllIlllIllIlllIIIIIIl, llllllllllllllIlllIllIlllIIIIIII);
                this.field_178206_b[llllllllllllllIlllIllIllIllllllI.field_178191_g] = llllllllllllllIlllIllIllIlllllII;
                this.field_178206_b[llllllllllllllIlllIllIllIllllllI.field_178200_h] = llllllllllllllIlllIllIllIllllIlI;
                this.field_178206_b[llllllllllllllIlllIllIllIllllllI.field_178201_i] = llllllllllllllIlllIllIllIllllIII;
                this.field_178206_b[llllllllllllllIlllIllIllIllllllI.field_178198_j] = llllllllllllllIlllIllIllIlllIllI;
            }
        }
        
        public AmbientOcclusionFace(final BlockModelRenderer llllllllllllllIlllIllIlllllIllll) {
            this.field_178206_b = new float[4];
            this.field_178207_c = new int[4];
        }
        
        private int func_178203_a(final int llllllllllllllIlllIllIllIIIIllII, final int llllllllllllllIlllIllIllIIIIIIIl, final int llllllllllllllIlllIllIllIIIIIIII, final int llllllllllllllIlllIllIllIIIIlIIl, final float llllllllllllllIlllIllIlIlllllllI, final float llllllllllllllIlllIllIllIIIIIlll, final float llllllllllllllIlllIllIllIIIIIllI, final float llllllllllllllIlllIllIllIIIIIlIl) {
            final int llllllllllllllIlllIllIllIIIIIlII = (int)((llllllllllllllIlllIllIllIIIIllII >> 16 & 0xFF) * llllllllllllllIlllIllIlIlllllllI + (llllllllllllllIlllIllIllIIIIIIIl >> 16 & 0xFF) * llllllllllllllIlllIllIllIIIIIlll + (llllllllllllllIlllIllIllIIIIIIII >> 16 & 0xFF) * llllllllllllllIlllIllIllIIIIIllI + (llllllllllllllIlllIllIllIIIIlIIl >> 16 & 0xFF) * llllllllllllllIlllIllIllIIIIIlIl) & 0xFF;
            final int llllllllllllllIlllIllIllIIIIIIll = (int)((llllllllllllllIlllIllIllIIIIllII & 0xFF) * llllllllllllllIlllIllIlIlllllllI + (llllllllllllllIlllIllIllIIIIIIIl & 0xFF) * llllllllllllllIlllIllIllIIIIIlll + (llllllllllllllIlllIllIllIIIIIIII & 0xFF) * llllllllllllllIlllIllIllIIIIIllI + (llllllllllllllIlllIllIllIIIIlIIl & 0xFF) * llllllllllllllIlllIllIllIIIIIlIl) & 0xFF;
            return llllllllllllllIlllIllIllIIIIIlII << 16 | llllllllllllllIlllIllIllIIIIIIll;
        }
    }
    
    enum VertexTranslations
    {
        NORTH("NORTH", 2, "NORTH", 2, "NORTH", 2, 3, 0, 1, 2), 
        DOWN("DOWN", 0, "DOWN", 0, "DOWN", 0, 0, 1, 2, 3), 
        EAST("EAST", 5, "EAST", 5, "EAST", 5, 1, 2, 3, 0);
        
        private final /* synthetic */ int field_178198_j;
        private final /* synthetic */ int field_178201_i;
        private static final /* synthetic */ VertexTranslations[] field_178199_k;
        private final /* synthetic */ int field_178191_g;
        
        SOUTH("SOUTH", 3, "SOUTH", 3, "SOUTH", 3, 0, 1, 2, 3), 
        WEST("WEST", 4, "WEST", 4, "WEST", 4, 3, 0, 1, 2), 
        UP("UP", 1, "UP", 1, "UP", 1, 2, 3, 0, 1);
        
        private final /* synthetic */ int field_178200_h;
        
        static {
            __OBFID = "CL_00002514";
            field_178199_k = new VertexTranslations[6];
            VertexTranslations.field_178199_k[EnumFacing.DOWN.getIndex()] = VertexTranslations.DOWN;
            VertexTranslations.field_178199_k[EnumFacing.UP.getIndex()] = VertexTranslations.UP;
            VertexTranslations.field_178199_k[EnumFacing.NORTH.getIndex()] = VertexTranslations.NORTH;
            VertexTranslations.field_178199_k[EnumFacing.SOUTH.getIndex()] = VertexTranslations.SOUTH;
            VertexTranslations.field_178199_k[EnumFacing.WEST.getIndex()] = VertexTranslations.WEST;
            VertexTranslations.field_178199_k[EnumFacing.EAST.getIndex()] = VertexTranslations.EAST;
        }
        
        private VertexTranslations(final String llllllllllllllIIlIIIIlllIIIlIlII, final int llllllllllllllIIlIIIIlllIIIlIIll, final String llllllllllllllIIlIIIIlllIIIlllIl, final int llllllllllllllIIlIIIIlllIIIlllII, final String llllllllllllllIIlIIIIlllIIIllIll, final int llllllllllllllIIlIIIIlllIIIllIlI, final int llllllllllllllIIlIIIIlllIIIllIIl, final int llllllllllllllIIlIIIIlllIIIlIIIl, final int llllllllllllllIIlIIIIlllIIIlIlll, final int llllllllllllllIIlIIIIlllIIIlIllI) {
            this.field_178191_g = llllllllllllllIIlIIIIlllIIIllIIl;
            this.field_178200_h = llllllllllllllIIlIIIIlllIIIlIIIl;
            this.field_178201_i = llllllllllllllIIlIIIIlllIIIlIlll;
            this.field_178198_j = llllllllllllllIIlIIIIlllIIIlIllI;
        }
        
        public static VertexTranslations func_178184_a(final EnumFacing llllllllllllllIIlIIIIlllIIIIllII) {
            return VertexTranslations.field_178199_k[llllllllllllllIIlIIIIlllIIIIllII.getIndex()];
        }
    }
    
    public enum EnumNeighborInfo
    {
        UP("UP", 1, "UP", 1, "UP", 1, new EnumFacing[] { EnumFacing.EAST, EnumFacing.WEST, EnumFacing.NORTH, EnumFacing.SOUTH }, 1.0f, true, new Orientation[] { Orientation.EAST, Orientation.SOUTH, Orientation.EAST, Orientation.FLIP_SOUTH, Orientation.FLIP_EAST, Orientation.FLIP_SOUTH, Orientation.FLIP_EAST, Orientation.SOUTH }, new Orientation[] { Orientation.EAST, Orientation.NORTH, Orientation.EAST, Orientation.FLIP_NORTH, Orientation.FLIP_EAST, Orientation.FLIP_NORTH, Orientation.FLIP_EAST, Orientation.NORTH }, new Orientation[] { Orientation.WEST, Orientation.NORTH, Orientation.WEST, Orientation.FLIP_NORTH, Orientation.FLIP_WEST, Orientation.FLIP_NORTH, Orientation.FLIP_WEST, Orientation.NORTH }, new Orientation[] { Orientation.WEST, Orientation.SOUTH, Orientation.WEST, Orientation.FLIP_SOUTH, Orientation.FLIP_WEST, Orientation.FLIP_SOUTH, Orientation.FLIP_WEST, Orientation.SOUTH }), 
        DOWN("DOWN", 0, "DOWN", 0, "DOWN", 0, new EnumFacing[] { EnumFacing.WEST, EnumFacing.EAST, EnumFacing.NORTH, EnumFacing.SOUTH }, 0.5f, true, new Orientation[] { Orientation.FLIP_WEST, Orientation.SOUTH, Orientation.FLIP_WEST, Orientation.FLIP_SOUTH, Orientation.WEST, Orientation.FLIP_SOUTH, Orientation.WEST, Orientation.SOUTH }, new Orientation[] { Orientation.FLIP_WEST, Orientation.NORTH, Orientation.FLIP_WEST, Orientation.FLIP_NORTH, Orientation.WEST, Orientation.FLIP_NORTH, Orientation.WEST, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_EAST, Orientation.NORTH, Orientation.FLIP_EAST, Orientation.FLIP_NORTH, Orientation.EAST, Orientation.FLIP_NORTH, Orientation.EAST, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_EAST, Orientation.SOUTH, Orientation.FLIP_EAST, Orientation.FLIP_SOUTH, Orientation.EAST, Orientation.FLIP_SOUTH, Orientation.EAST, Orientation.SOUTH });
        
        protected final /* synthetic */ boolean field_178289_i;
        protected final /* synthetic */ Orientation[] field_178287_k;
        
        WEST("WEST", 4, "WEST", 4, "WEST", 4, new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN, EnumFacing.NORTH, EnumFacing.SOUTH }, 0.6f, true, new Orientation[] { Orientation.UP, Orientation.SOUTH, Orientation.UP, Orientation.FLIP_SOUTH, Orientation.FLIP_UP, Orientation.FLIP_SOUTH, Orientation.FLIP_UP, Orientation.SOUTH }, new Orientation[] { Orientation.UP, Orientation.NORTH, Orientation.UP, Orientation.FLIP_NORTH, Orientation.FLIP_UP, Orientation.FLIP_NORTH, Orientation.FLIP_UP, Orientation.NORTH }, new Orientation[] { Orientation.DOWN, Orientation.NORTH, Orientation.DOWN, Orientation.FLIP_NORTH, Orientation.FLIP_DOWN, Orientation.FLIP_NORTH, Orientation.FLIP_DOWN, Orientation.NORTH }, new Orientation[] { Orientation.DOWN, Orientation.SOUTH, Orientation.DOWN, Orientation.FLIP_SOUTH, Orientation.FLIP_DOWN, Orientation.FLIP_SOUTH, Orientation.FLIP_DOWN, Orientation.SOUTH });
        
        protected final /* synthetic */ EnumFacing[] field_178276_g;
        protected final /* synthetic */ float field_178288_h;
        protected final /* synthetic */ Orientation[] field_178285_m;
        
        EAST("EAST", 5, "EAST", 5, "EAST", 5, new EnumFacing[] { EnumFacing.DOWN, EnumFacing.UP, EnumFacing.NORTH, EnumFacing.SOUTH }, 0.6f, true, new Orientation[] { Orientation.FLIP_DOWN, Orientation.SOUTH, Orientation.FLIP_DOWN, Orientation.FLIP_SOUTH, Orientation.DOWN, Orientation.FLIP_SOUTH, Orientation.DOWN, Orientation.SOUTH }, new Orientation[] { Orientation.FLIP_DOWN, Orientation.NORTH, Orientation.FLIP_DOWN, Orientation.FLIP_NORTH, Orientation.DOWN, Orientation.FLIP_NORTH, Orientation.DOWN, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_UP, Orientation.NORTH, Orientation.FLIP_UP, Orientation.FLIP_NORTH, Orientation.UP, Orientation.FLIP_NORTH, Orientation.UP, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_UP, Orientation.SOUTH, Orientation.FLIP_UP, Orientation.FLIP_SOUTH, Orientation.UP, Orientation.FLIP_SOUTH, Orientation.UP, Orientation.SOUTH });
        
        protected final /* synthetic */ Orientation[] field_178284_l;
        private static final /* synthetic */ EnumNeighborInfo[] field_178282_n;
        protected final /* synthetic */ Orientation[] field_178286_j;
        
        SOUTH("SOUTH", 3, "SOUTH", 3, "SOUTH", 3, new EnumFacing[] { EnumFacing.WEST, EnumFacing.EAST, EnumFacing.DOWN, EnumFacing.UP }, 0.8f, true, new Orientation[] { Orientation.UP, Orientation.FLIP_WEST, Orientation.FLIP_UP, Orientation.FLIP_WEST, Orientation.FLIP_UP, Orientation.WEST, Orientation.UP, Orientation.WEST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_WEST, Orientation.FLIP_DOWN, Orientation.FLIP_WEST, Orientation.FLIP_DOWN, Orientation.WEST, Orientation.DOWN, Orientation.WEST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_EAST, Orientation.FLIP_DOWN, Orientation.FLIP_EAST, Orientation.FLIP_DOWN, Orientation.EAST, Orientation.DOWN, Orientation.EAST }, new Orientation[] { Orientation.UP, Orientation.FLIP_EAST, Orientation.FLIP_UP, Orientation.FLIP_EAST, Orientation.FLIP_UP, Orientation.EAST, Orientation.UP, Orientation.EAST }), 
        NORTH("NORTH", 2, "NORTH", 2, "NORTH", 2, new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN, EnumFacing.EAST, EnumFacing.WEST }, 0.8f, true, new Orientation[] { Orientation.UP, Orientation.FLIP_WEST, Orientation.UP, Orientation.WEST, Orientation.FLIP_UP, Orientation.WEST, Orientation.FLIP_UP, Orientation.FLIP_WEST }, new Orientation[] { Orientation.UP, Orientation.FLIP_EAST, Orientation.UP, Orientation.EAST, Orientation.FLIP_UP, Orientation.EAST, Orientation.FLIP_UP, Orientation.FLIP_EAST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_EAST, Orientation.DOWN, Orientation.EAST, Orientation.FLIP_DOWN, Orientation.EAST, Orientation.FLIP_DOWN, Orientation.FLIP_EAST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_WEST, Orientation.DOWN, Orientation.WEST, Orientation.FLIP_DOWN, Orientation.WEST, Orientation.FLIP_DOWN, Orientation.FLIP_WEST });
        
        private EnumNeighborInfo(final String llllllllllllllIIlIIIllIlllIlIIII, final int llllllllllllllIIlIIIllIlllIIllll, final String llllllllllllllIIlIIIllIlllIlllII, final int llllllllllllllIIlIIIllIlllIllIll, final String llllllllllllllIIlIIIllIlllIllIlI, final int llllllllllllllIIlIIIllIlllIllIIl, final EnumFacing[] llllllllllllllIIlIIIllIlllIllIII, final float llllllllllllllIIlIIIllIlllIIllIl, final boolean llllllllllllllIIlIIIllIlllIIllII, final Orientation[] llllllllllllllIIlIIIllIlllIlIlIl, final Orientation[] llllllllllllllIIlIIIllIlllIlIlII, final Orientation[] llllllllllllllIIlIIIllIlllIIlIIl, final Orientation[] llllllllllllllIIlIIIllIlllIIlIII) {
            this.field_178276_g = llllllllllllllIIlIIIllIlllIllIII;
            this.field_178288_h = llllllllllllllIIlIIIllIlllIIllIl;
            this.field_178289_i = llllllllllllllIIlIIIllIlllIIllII;
            this.field_178286_j = llllllllllllllIIlIIIllIlllIlIlIl;
            this.field_178287_k = llllllllllllllIIlIIIllIlllIlIlII;
            this.field_178284_l = llllllllllllllIIlIIIllIlllIIlIIl;
            this.field_178285_m = llllllllllllllIIlIIIllIlllIIlIII;
        }
        
        static {
            __OBFID = "CL_00002516";
            field_178282_n = new EnumNeighborInfo[6];
            EnumNeighborInfo.field_178282_n[EnumFacing.DOWN.getIndex()] = EnumNeighborInfo.DOWN;
            EnumNeighborInfo.field_178282_n[EnumFacing.UP.getIndex()] = EnumNeighborInfo.UP;
            EnumNeighborInfo.field_178282_n[EnumFacing.NORTH.getIndex()] = EnumNeighborInfo.NORTH;
            EnumNeighborInfo.field_178282_n[EnumFacing.SOUTH.getIndex()] = EnumNeighborInfo.SOUTH;
            EnumNeighborInfo.field_178282_n[EnumFacing.WEST.getIndex()] = EnumNeighborInfo.WEST;
            EnumNeighborInfo.field_178282_n[EnumFacing.EAST.getIndex()] = EnumNeighborInfo.EAST;
        }
        
        public static EnumNeighborInfo func_178273_a(final EnumFacing llllllllllllllIIlIIIllIlllIIIlIl) {
            return EnumNeighborInfo.field_178282_n[llllllllllllllIIlIIIllIlllIIIlIl.getIndex()];
        }
    }
}
