package net.minecraft.client.resources.model;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import com.google.common.collect.*;

public class WeightedBakedModel implements IBakedModel
{
    private final /* synthetic */ IBakedModel baseModel;
    private final /* synthetic */ List models;
    private final /* synthetic */ int totalWeight;
    
    @Override
    public boolean isAmbientOcclusionEnabled() {
        return this.baseModel.isAmbientOcclusionEnabled();
    }
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.baseModel.getItemCameraTransforms();
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return this.baseModel.isBuiltInRenderer();
    }
    
    @Override
    public List func_177550_a() {
        return this.baseModel.func_177550_a();
    }
    
    @Override
    public List func_177551_a(final EnumFacing llllllllllllllIIlIIlIIllllllllll) {
        return this.baseModel.func_177551_a(llllllllllllllIIlIIlIIllllllllll);
    }
    
    public WeightedBakedModel(final List llllllllllllllIIlIIlIlIIIIIIIlll) {
        this.models = llllllllllllllIIlIIlIlIIIIIIIlll;
        this.totalWeight = WeightedRandom.getTotalWeight(llllllllllllllIIlIIlIlIIIIIIIlll);
        this.baseModel = llllllllllllllIIlIIlIlIIIIIIIlll.get(0).model;
    }
    
    @Override
    public TextureAtlasSprite getTexture() {
        return this.baseModel.getTexture();
    }
    
    @Override
    public boolean isGui3d() {
        return this.baseModel.isGui3d();
    }
    
    public IBakedModel func_177564_a(final long llllllllllllllIIlIIlIIlllllIlIIl) {
        return ((MyWeighedRandomItem)WeightedRandom.func_180166_a(this.models, Math.abs((int)llllllllllllllIIlIIlIIlllllIlIIl >> 16) % this.totalWeight)).model;
    }
    
    static {
        __OBFID = "CL_00002384";
    }
    
    static class MyWeighedRandomItem extends WeightedRandom.Item implements Comparable
    {
        protected final /* synthetic */ IBakedModel model;
        
        protected int func_177635_a() {
            int llllllllllllllIIlIllllIIIllIllII = this.model.func_177550_a().size();
            for (final EnumFacing llllllllllllllIIlIllllIIIllIlIII : EnumFacing.values()) {
                llllllllllllllIIlIllllIIIllIllII += this.model.func_177551_a(llllllllllllllIIlIllllIIIllIlIII).size();
            }
            return llllllllllllllIIlIllllIIIllIllII;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder("MyWeighedRandomItem{weight=").append(this.itemWeight).append(", model=").append(this.model).append('}'));
        }
        
        static {
            __OBFID = "CL_00002382";
        }
        
        @Override
        public int compareTo(final Object llllllllllllllIIlIllllIIIlIllIIl) {
            return this.func_177634_a((MyWeighedRandomItem)llllllllllllllIIlIllllIIIlIllIIl);
        }
        
        public MyWeighedRandomItem(final IBakedModel llllllllllllllIIlIllllIIIllllIll, final int llllllllllllllIIlIllllIIIlllllIl) {
            super(llllllllllllllIIlIllllIIIlllllIl);
            this.model = llllllllllllllIIlIllllIIIllllIll;
        }
        
        public int func_177634_a(final MyWeighedRandomItem llllllllllllllIIlIllllIIIlllIllI) {
            return ComparisonChain.start().compare(llllllllllllllIIlIllllIIIlllIllI.itemWeight, this.itemWeight).compare(this.func_177635_a(), llllllllllllllIIlIllllIIIlllIllI.func_177635_a()).result();
        }
    }
    
    public static class Builder
    {
        private /* synthetic */ List field_177678_a;
        
        static {
            __OBFID = "CL_00002383";
        }
        
        public WeightedBakedModel build() {
            Collections.sort((List<Comparable>)this.field_177678_a);
            return new WeightedBakedModel(this.field_177678_a);
        }
        
        public Builder() {
            this.field_177678_a = Lists.newArrayList();
        }
        
        public IBakedModel first() {
            return this.field_177678_a.get(0).model;
        }
        
        public Builder add(final IBakedModel llllllllllllllIllIIlIIllIIlIlllI, final int llllllllllllllIllIIlIIllIIlIllIl) {
            this.field_177678_a.add(new MyWeighedRandomItem(llllllllllllllIllIIlIIllIIlIlllI, llllllllllllllIllIIlIIllIIlIllIl));
            return this;
        }
    }
}
