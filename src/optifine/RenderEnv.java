package optifine;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.settings.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.block.*;

public class RenderEnv
{
    private /* synthetic */ boolean[] borderFlags;
    private static /* synthetic */ ThreadLocal threadLocalInstance;
    private /* synthetic */ int blockId;
    private /* synthetic */ int breakingAnimation;
    private /* synthetic */ IBlockAccess blockAccess;
    private /* synthetic */ float[] quadBounds;
    private /* synthetic */ BlockPos blockPos;
    private /* synthetic */ BlockModelRenderer.AmbientOcclusionFace aoFace;
    private /* synthetic */ GameSettings gameSettings;
    private /* synthetic */ BitSet boundsFlags;
    private /* synthetic */ IBlockState blockState;
    private /* synthetic */ BlockPosM colorizerBlockPosM;
    private /* synthetic */ int metadata;
    
    public float[] getQuadBounds() {
        return this.quadBounds;
    }
    
    public boolean isBreakingAnimation() {
        return this.breakingAnimation == 1;
    }
    
    public IBlockState getBlockState() {
        return this.blockState;
    }
    
    public int getMetadata() {
        if (this.metadata < 0) {
            if (this.blockState instanceof BlockStateBase) {
                final BlockStateBase llllllllllllllIIlIlIllIlIIllIIIl = (BlockStateBase)this.blockState;
                this.metadata = llllllllllllllIIlIlIllIlIIllIIIl.getMetadata();
            }
            else {
                this.metadata = this.blockState.getBlock().getMetaFromState(this.blockState);
            }
        }
        return this.metadata;
    }
    
    static {
        RenderEnv.threadLocalInstance = new ThreadLocal();
    }
    
    private RenderEnv(final IBlockAccess llllllllllllllIIlIlIllIlIlIlIlIl, final IBlockState llllllllllllllIIlIlIllIlIlIlIlII, final BlockPos llllllllllllllIIlIlIllIlIlIlIIll) {
        this.blockId = -1;
        this.metadata = -1;
        this.breakingAnimation = -1;
        this.quadBounds = new float[EnumFacing.VALUES.length * 2];
        this.boundsFlags = new BitSet(3);
        this.aoFace = new BlockModelRenderer.AmbientOcclusionFace();
        this.colorizerBlockPosM = null;
        this.borderFlags = null;
        this.blockAccess = llllllllllllllIIlIlIllIlIlIlIlIl;
        this.blockState = llllllllllllllIIlIlIllIlIlIlIlII;
        this.blockPos = llllllllllllllIIlIlIllIlIlIlIIll;
        this.gameSettings = Config.getGameSettings();
    }
    
    public boolean isBreakingAnimation(final List llllllllllllllIIlIlIllIlIIlIIIlI) {
        if (this.breakingAnimation < 0 && llllllllllllllIIlIlIllIlIIlIIIlI.size() > 0) {
            if (llllllllllllllIIlIlIllIlIIlIIIlI.get(0) instanceof BreakingFour) {
                this.breakingAnimation = 1;
            }
            else {
                this.breakingAnimation = 0;
            }
        }
        return this.breakingAnimation == 1;
    }
    
    public static RenderEnv getInstance(final IBlockAccess llllllllllllllIIlIlIllIlIlIIlllI, final IBlockState llllllllllllllIIlIlIllIlIlIIllIl, final BlockPos llllllllllllllIIlIlIllIlIlIIllII) {
        RenderEnv llllllllllllllIIlIlIllIlIlIIlIll = RenderEnv.threadLocalInstance.get();
        if (llllllllllllllIIlIlIllIlIlIIlIll == null) {
            llllllllllllllIIlIlIllIlIlIIlIll = new RenderEnv(llllllllllllllIIlIlIllIlIlIIlllI, llllllllllllllIIlIlIllIlIlIIllIl, llllllllllllllIIlIlIllIlIlIIllII);
            RenderEnv.threadLocalInstance.set(llllllllllllllIIlIlIllIlIlIIlIll);
            return llllllllllllllIIlIlIllIlIlIIlIll;
        }
        llllllllllllllIIlIlIllIlIlIIlIll.reset(llllllllllllllIIlIlIllIlIlIIlllI, llllllllllllllIIlIlIllIlIlIIllIl, llllllllllllllIIlIlIllIlIlIIllII);
        return llllllllllllllIIlIlIllIlIlIIlIll;
    }
    
    public BlockModelRenderer.AmbientOcclusionFace getAoFace() {
        return this.aoFace;
    }
    
    public boolean[] getBorderFlags() {
        if (this.borderFlags == null) {
            this.borderFlags = new boolean[4];
        }
        return this.borderFlags;
    }
    
    public BlockPosM getColorizerBlockPosM() {
        if (this.colorizerBlockPosM == null) {
            this.colorizerBlockPosM = new BlockPosM(0, 0, 0);
        }
        return this.colorizerBlockPosM;
    }
    
    public BitSet getBoundsFlags() {
        return this.boundsFlags;
    }
    
    private void reset(final IBlockAccess llllllllllllllIIlIlIllIlIIllllIl, final IBlockState llllllllllllllIIlIlIllIlIIllllII, final BlockPos llllllllllllllIIlIlIllIlIIlllIll) {
        this.blockAccess = llllllllllllllIIlIlIllIlIIllllIl;
        this.blockState = llllllllllllllIIlIlIllIlIIllllII;
        this.blockPos = llllllllllllllIIlIlIllIlIIlllIll;
        this.blockId = -1;
        this.metadata = -1;
        this.breakingAnimation = -1;
        this.boundsFlags.clear();
    }
    
    public boolean isBreakingAnimation(final BakedQuad llllllllllllllIIlIlIllIlIIIllIlI) {
        if (this.breakingAnimation < 0) {
            if (llllllllllllllIIlIlIllIlIIIllIlI instanceof BreakingFour) {
                this.breakingAnimation = 1;
            }
            else {
                this.breakingAnimation = 0;
            }
        }
        return this.breakingAnimation == 1;
    }
    
    public int getBlockId() {
        if (this.blockId < 0) {
            if (this.blockState instanceof BlockStateBase) {
                final BlockStateBase llllllllllllllIIlIlIllIlIIllIlll = (BlockStateBase)this.blockState;
                this.blockId = llllllllllllllIIlIlIllIlIIllIlll.getBlockId();
            }
            else {
                this.blockId = Block.getIdFromBlock(this.blockState.getBlock());
            }
        }
        return this.blockId;
    }
}
