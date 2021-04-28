package net.minecraft.client.resources.model;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.block.model.*;
import java.util.*;

public class SimpleBakedModel implements IBakedModel
{
    protected final /* synthetic */ List field_177561_b;
    protected final /* synthetic */ List field_177563_a;
    protected final /* synthetic */ TextureAtlasSprite texture;
    protected final /* synthetic */ boolean ambientOcclusion;
    protected final /* synthetic */ ItemCameraTransforms field_177558_f;
    protected final /* synthetic */ boolean field_177562_c;
    
    public SimpleBakedModel(final List lIlllIIllIll, final List lIlllIIllIlI, final boolean lIlllIIlIIlI, final boolean lIlllIIlIIIl, final TextureAtlasSprite lIlllIIlIlll, final ItemCameraTransforms lIlllIIlIllI) {
        this.field_177563_a = lIlllIIllIll;
        this.field_177561_b = lIlllIIllIlI;
        this.field_177562_c = lIlllIIlIIlI;
        this.ambientOcclusion = lIlllIIlIIIl;
        this.texture = lIlllIIlIlll;
        this.field_177558_f = lIlllIIlIllI;
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }
    
    @Override
    public TextureAtlasSprite getTexture() {
        return this.texture;
    }
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.field_177558_f;
    }
    
    @Override
    public List func_177551_a(final EnumFacing lIlllIIIlIIl) {
        return this.field_177561_b.get(lIlllIIIlIIl.ordinal());
    }
    
    static {
        __OBFID = "CL_00002386";
    }
    
    @Override
    public List func_177550_a() {
        return this.field_177563_a;
    }
    
    @Override
    public boolean isGui3d() {
        return this.field_177562_c;
    }
    
    @Override
    public boolean isAmbientOcclusionEnabled() {
        return this.ambientOcclusion;
    }
    
    public static class Builder
    {
        private final /* synthetic */ List field_177656_a;
        private /* synthetic */ ItemCameraTransforms field_177651_f;
        private final /* synthetic */ List field_177654_b;
        private final /* synthetic */ boolean field_177655_c;
        private /* synthetic */ boolean field_177653_e;
        private /* synthetic */ TextureAtlasSprite field_177652_d;
        
        public Builder func_177648_a(final BakedQuad lIlIIlIIIlllIII) {
            this.field_177656_a.add(lIlIIlIIIlllIII);
            return this;
        }
        
        private Builder(final boolean lIlIIlIIlIIlIll, final boolean lIlIIlIIlIlIIlI, final ItemCameraTransforms lIlIIlIIlIIlIIl) {
            this.field_177656_a = Lists.newArrayList();
            this.field_177654_b = Lists.newArrayListWithCapacity(6);
            for (final EnumFacing lIlIIlIIlIIllIl : EnumFacing.values()) {
                this.field_177654_b.add(Lists.newArrayList());
            }
            this.field_177655_c = lIlIIlIIlIIlIll;
            this.field_177653_e = lIlIIlIIlIlIIlI;
            this.field_177651_f = lIlIIlIIlIIlIIl;
        }
        
        public Builder(final ModelBlock lIlIIlIlIIlIlIl) {
            this(lIlIIlIlIIlIlIl.func_178309_b(), lIlIIlIlIIlIlIl.isAmbientOcclusionEnabled(), new ItemCameraTransforms(lIlIIlIlIIlIlIl.getThirdPersonTransform(), lIlIIlIlIIlIlIl.getFirstPersonTransform(), lIlIIlIlIIlIlIl.getHeadTransform(), lIlIIlIlIIlIlIl.getInGuiTransform()));
        }
        
        static {
            __OBFID = "CL_00002385";
        }
        
        public Builder func_177650_a(final EnumFacing lIlIIlIIlIIIIII, final BakedQuad lIlIIlIIIllllll) {
            this.field_177654_b.get(lIlIIlIIlIIIIII.ordinal()).add(lIlIIlIIIllllll);
            return this;
        }
        
        private void func_177649_a(final IBakedModel lIlIIlIIlllIllI, final TextureAtlasSprite lIlIIlIIlllIlIl, final EnumFacing lIlIIlIIlllIlII) {
            for (final BakedQuad lIlIIlIIlllIIlI : lIlIIlIIlllIllI.func_177551_a(lIlIIlIIlllIlII)) {
                this.func_177650_a(lIlIIlIIlllIlII, new BreakingFour(lIlIIlIIlllIIlI, lIlIIlIIlllIlIl));
            }
        }
        
        public IBakedModel func_177645_b() {
            if (this.field_177652_d == null) {
                throw new RuntimeException("Missing particle!");
            }
            return new SimpleBakedModel(this.field_177656_a, this.field_177654_b, this.field_177655_c, this.field_177653_e, this.field_177652_d, this.field_177651_f);
        }
        
        public Builder(final IBakedModel lIlIIlIlIIIIIll, final TextureAtlasSprite lIlIIlIlIIIlIIl) {
            this(lIlIIlIlIIIIIll.isGui3d(), lIlIIlIlIIIIIll.isAmbientOcclusionEnabled(), lIlIIlIlIIIIIll.getItemCameraTransforms());
            this.field_177652_d = lIlIIlIlIIIIIll.getTexture();
            for (final EnumFacing lIlIIlIlIIIIlIl : EnumFacing.values()) {
                this.func_177649_a(lIlIIlIlIIIIIll, lIlIIlIlIIIlIIl, lIlIIlIlIIIIlIl);
            }
            this.func_177647_a(lIlIIlIlIIIIIll, lIlIIlIlIIIlIIl);
        }
        
        public Builder func_177646_a(final TextureAtlasSprite lIlIIlIIIllIIII) {
            this.field_177652_d = lIlIIlIIIllIIII;
            return this;
        }
        
        private void func_177647_a(final IBakedModel lIlIIlIIllIIlIl, final TextureAtlasSprite lIlIIlIIlIlllll) {
            for (final BakedQuad lIlIIlIIllIIIlI : lIlIIlIIllIIlIl.func_177550_a()) {
                this.func_177648_a(new BreakingFour(lIlIIlIIllIIIlI, lIlIIlIIlIlllll));
            }
        }
    }
}
