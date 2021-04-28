package net.minecraft.client.renderer;

import net.minecraft.client.settings.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.client.resources.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.model.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;

public class BlockRendererDispatcher implements IResourceManagerReloadListener
{
    private final /* synthetic */ BlockModelRenderer blockModelRenderer;
    private final /* synthetic */ GameSettings field_175026_b;
    private final /* synthetic */ ChestRenderer chestRenderer;
    private /* synthetic */ BlockModelShapes field_175028_a;
    private final /* synthetic */ BlockFluidRenderer fluidRenderer;
    
    private IBakedModel func_175017_a(final IBlockState llIlllIlIIIIlI, final BlockPos llIlllIlIIIIIl) {
        IBakedModel llIlllIlIIIIII = this.field_175028_a.func_178125_b(llIlllIlIIIIlI);
        if (llIlllIlIIIIIl != null && this.field_175026_b.field_178880_u && llIlllIlIIIIII instanceof WeightedBakedModel) {
            llIlllIlIIIIII = ((WeightedBakedModel)llIlllIlIIIIII).func_177564_a(MathHelper.func_180186_a(llIlllIlIIIIIl));
        }
        return llIlllIlIIIIII;
    }
    
    public void func_175016_a(final IBlockState llIlllIIIllIll, final float llIlllIIIlllll) {
        final int llIlllIIIllllI = llIlllIIIllIll.getBlock().getRenderType();
        if (llIlllIIIllllI != -1) {
            switch (llIlllIIIllllI) {
                case 2: {
                    this.chestRenderer.func_178175_a(llIlllIIIllIll.getBlock(), llIlllIIIlllll);
                    break;
                }
                case 3: {
                    final IBakedModel llIlllIIIlllIl = this.func_175017_a(llIlllIIIllIll, null);
                    this.blockModelRenderer.func_178266_a(llIlllIIIlllIl, llIlllIIIllIll, llIlllIIIlllll, true);
                    break;
                }
            }
        }
    }
    
    public BlockModelRenderer func_175019_b() {
        return this.blockModelRenderer;
    }
    
    public boolean func_175021_a(final Block llIlllIIIlIIIl, final int llIlllIIIlIIll) {
        if (llIlllIIIlIIIl == null) {
            return false;
        }
        final int llIlllIIIlIIlI = llIlllIIIlIIIl.getRenderType();
        return llIlllIIIlIIlI != 3 && llIlllIIIlIIlI == 2;
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llIlllIIIIllIl) {
        this.fluidRenderer.func_178268_a();
    }
    
    public BlockModelShapes func_175023_a() {
        return this.field_175028_a;
    }
    
    public IBakedModel getModelFromBlockState(IBlockState llIlllIIlIllII, final IBlockAccess llIlllIIlIlIll, final BlockPos llIlllIIllIIIl) {
        final Block llIlllIIllIIII = llIlllIIlIllII.getBlock();
        if (llIlllIIlIlIll.getWorldType() != WorldType.DEBUG_WORLD) {
            try {
                llIlllIIlIllII = llIlllIIllIIII.getActualState(llIlllIIlIllII, llIlllIIlIlIll, llIlllIIllIIIl);
            }
            catch (Exception ex) {}
        }
        IBakedModel llIlllIIlIllll = this.field_175028_a.func_178125_b(llIlllIIlIllII);
        if (llIlllIIllIIIl != null && this.field_175026_b.field_178880_u && llIlllIIlIllll instanceof WeightedBakedModel) {
            llIlllIIlIllll = ((WeightedBakedModel)llIlllIIlIllll).func_177564_a(MathHelper.func_180186_a(llIlllIIllIIIl));
        }
        if (Reflector.ISmartBlockModel.isInstance(llIlllIIlIllll)) {
            final IBlockState llIlllIIlIlllI = (IBlockState)Reflector.call(llIlllIIllIIII, Reflector.ForgeBlock_getExtendedState, llIlllIIlIllII, llIlllIIlIlIll, llIlllIIllIIIl);
            llIlllIIlIllll = (IBakedModel)Reflector.call(llIlllIIlIllll, Reflector.ISmartBlockModel_handleBlockState, llIlllIIlIlllI);
        }
        return llIlllIIlIllll;
    }
    
    public void func_175020_a(IBlockState llIlllIlllIllI, final BlockPos llIlllIlllIlIl, final TextureAtlasSprite llIllllIIIIlII, final IBlockAccess llIlllIlllIIll) {
        final Block llIllllIIIIIlI = llIlllIlllIllI.getBlock();
        final int llIllllIIIIIIl = llIllllIIIIIlI.getRenderType();
        if (llIllllIIIIIIl == 3) {
            llIlllIlllIllI = llIllllIIIIIlI.getActualState(llIlllIlllIllI, llIlllIlllIIll, llIlllIlllIlIl);
            final IBakedModel llIllllIIIIIII = this.field_175028_a.func_178125_b(llIlllIlllIllI);
            if (Reflector.ISmartBlockModel.isInstance(llIllllIIIIIII)) {
                final IBlockState llIlllIlllllll = (IBlockState)Reflector.call(llIllllIIIIIlI, Reflector.ForgeBlock_getExtendedState, llIlllIlllIllI, llIlllIlllIIll, llIlllIlllIlIl);
                for (final EnumWorldBlockLayer llIlllIllllIll : EnumWorldBlockLayer.values()) {
                    if (Reflector.callBoolean(llIllllIIIIIlI, Reflector.ForgeBlock_canRenderInLayer, llIlllIllllIll)) {
                        Reflector.callVoid(Reflector.ForgeHooksClient_setRenderLayer, llIlllIllllIll);
                        final IBakedModel llIlllIllllIlI = (IBakedModel)Reflector.call(llIllllIIIIIII, Reflector.ISmartBlockModel_handleBlockState, llIlllIlllllll);
                        final IBakedModel llIlllIllllIIl = new SimpleBakedModel.Builder(llIlllIllllIlI, llIllllIIIIlII).func_177645_b();
                        this.blockModelRenderer.func_178259_a(llIlllIlllIIll, llIlllIllllIIl, llIlllIlllIllI, llIlllIlllIlIl, Tessellator.getInstance().getWorldRenderer());
                    }
                }
                return;
            }
            final IBakedModel llIlllIllllIII = new SimpleBakedModel.Builder(llIllllIIIIIII, llIllllIIIIlII).func_177645_b();
            this.blockModelRenderer.func_178259_a(llIlllIlllIIll, llIlllIllllIII, llIlllIlllIllI, llIlllIlllIlIl, Tessellator.getInstance().getWorldRenderer());
        }
    }
    
    public BlockRendererDispatcher(final BlockModelShapes llIllllIIllIll, final GameSettings llIllllIIllIlI) {
        this.blockModelRenderer = new BlockModelRenderer();
        this.chestRenderer = new ChestRenderer();
        this.fluidRenderer = new BlockFluidRenderer();
        this.field_175028_a = llIllllIIllIll;
        this.field_175026_b = llIllllIIllIlI;
    }
    
    public boolean func_175018_a(final IBlockState llIlllIlIlIIlI, final BlockPos llIlllIlIlllIl, final IBlockAccess llIlllIlIlIIII, final WorldRenderer llIlllIlIIllll) {
        try {
            final int llIlllIlIllIlI = llIlllIlIlIIlI.getBlock().getRenderType();
            if (llIlllIlIllIlI == -1) {
                return false;
            }
            switch (llIlllIlIllIlI) {
                case 1: {
                    if (Config.isShaders()) {
                        SVertexBuilder.pushEntity(llIlllIlIlIIlI, llIlllIlIlllIl, llIlllIlIlIIII, llIlllIlIIllll);
                    }
                    final boolean llIlllIlIllIIl = this.fluidRenderer.func_178270_a(llIlllIlIlIIII, llIlllIlIlIIlI, llIlllIlIlllIl, llIlllIlIIllll);
                    if (Config.isShaders()) {
                        SVertexBuilder.popEntity(llIlllIlIIllll);
                    }
                    return llIlllIlIllIIl;
                }
                case 2: {
                    return false;
                }
                case 3: {
                    final IBakedModel llIlllIlIllIII = this.getModelFromBlockState(llIlllIlIlIIlI, llIlllIlIlIIII, llIlllIlIlllIl);
                    if (Config.isShaders()) {
                        SVertexBuilder.pushEntity(llIlllIlIlIIlI, llIlllIlIlllIl, llIlllIlIlIIII, llIlllIlIIllll);
                    }
                    final boolean llIlllIlIlIlll = this.blockModelRenderer.func_178259_a(llIlllIlIlIIII, llIlllIlIllIII, llIlllIlIlIIlI, llIlllIlIlllIl, llIlllIlIIllll);
                    if (Config.isShaders()) {
                        SVertexBuilder.popEntity(llIlllIlIIllll);
                    }
                    return llIlllIlIlIlll;
                }
                default: {
                    return false;
                }
            }
        }
        catch (Throwable llIlllIlIlIllI) {
            final CrashReport llIlllIlIlIlIl = CrashReport.makeCrashReport(llIlllIlIlIllI, "Tesselating block in world");
            final CrashReportCategory llIlllIlIlIlII = llIlllIlIlIlIl.makeCategory("Block being tesselated");
            CrashReportCategory.addBlockInfo(llIlllIlIlIlII, llIlllIlIlllIl, llIlllIlIlIIlI.getBlock(), llIlllIlIlIIlI.getBlock().getMetaFromState(llIlllIlIlIIlI));
            throw new ReportedException(llIlllIlIlIlIl);
        }
    }
}
