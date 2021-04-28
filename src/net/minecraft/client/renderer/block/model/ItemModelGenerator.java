package net.minecraft.client.renderer.block.model;

import com.google.common.collect.*;
import javax.vecmath.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;

public class ItemModelGenerator
{
    public static final /* synthetic */ List LAYERS;
    
    private List func_178393_a(final TextureAtlasSprite llllllllllllllIlllIlIIIllllIIlll) {
        final int llllllllllllllIlllIlIIIllllIIllI = llllllllllllllIlllIlIIIllllIIlll.getIconWidth();
        final int llllllllllllllIlllIlIIIllllIIlIl = llllllllllllllIlllIlIIIllllIIlll.getIconHeight();
        final ArrayList llllllllllllllIlllIlIIIllllIIlII = Lists.newArrayList();
        for (int llllllllllllllIlllIlIIIllllIIIll = 0; llllllllllllllIlllIlIIIllllIIIll < llllllllllllllIlllIlIIIllllIIlll.getFrameCount(); ++llllllllllllllIlllIlIIIllllIIIll) {
            final int[] llllllllllllllIlllIlIIIllllIIIlI = llllllllllllllIlllIlIIIllllIIlll.getFrameTextureData(llllllllllllllIlllIlIIIllllIIIll)[0];
            for (int llllllllllllllIlllIlIIIllllIIIIl = 0; llllllllllllllIlllIlIIIllllIIIIl < llllllllllllllIlllIlIIIllllIIlIl; ++llllllllllllllIlllIlIIIllllIIIIl) {
                for (int llllllllllllllIlllIlIIIllllIIIII = 0; llllllllllllllIlllIlIIIllllIIIII < llllllllllllllIlllIlIIIllllIIllI; ++llllllllllllllIlllIlIIIllllIIIII) {
                    final boolean llllllllllllllIlllIlIIIlllIlllll = !this.func_178391_a(llllllllllllllIlllIlIIIllllIIIlI, llllllllllllllIlllIlIIIllllIIIII, llllllllllllllIlllIlIIIllllIIIIl, llllllllllllllIlllIlIIIllllIIllI, llllllllllllllIlllIlIIIllllIIlIl);
                    this.func_178396_a(SpanFacing.UP, llllllllllllllIlllIlIIIllllIIlII, llllllllllllllIlllIlIIIllllIIIlI, llllllllllllllIlllIlIIIllllIIIII, llllllllllllllIlllIlIIIllllIIIIl, llllllllllllllIlllIlIIIllllIIllI, llllllllllllllIlllIlIIIllllIIlIl, llllllllllllllIlllIlIIIlllIlllll);
                    this.func_178396_a(SpanFacing.DOWN, llllllllllllllIlllIlIIIllllIIlII, llllllllllllllIlllIlIIIllllIIIlI, llllllllllllllIlllIlIIIllllIIIII, llllllllllllllIlllIlIIIllllIIIIl, llllllllllllllIlllIlIIIllllIIllI, llllllllllllllIlllIlIIIllllIIlIl, llllllllllllllIlllIlIIIlllIlllll);
                    this.func_178396_a(SpanFacing.LEFT, llllllllllllllIlllIlIIIllllIIlII, llllllllllllllIlllIlIIIllllIIIlI, llllllllllllllIlllIlIIIllllIIIII, llllllllllllllIlllIlIIIllllIIIIl, llllllllllllllIlllIlIIIllllIIllI, llllllllllllllIlllIlIIIllllIIlIl, llllllllllllllIlllIlIIIlllIlllll);
                    this.func_178396_a(SpanFacing.RIGHT, llllllllllllllIlllIlIIIllllIIlII, llllllllllllllIlllIlIIIllllIIIlI, llllllllllllllIlllIlIIIllllIIIII, llllllllllllllIlllIlIIIllllIIIIl, llllllllllllllIlllIlIIIllllIIllI, llllllllllllllIlllIlIIIllllIIlIl, llllllllllllllIlllIlIIIlllIlllll);
                }
            }
        }
        return llllllllllllllIlllIlIIIllllIIlII;
    }
    
    private List func_178397_a(final TextureAtlasSprite llllllllllllllIlllIlIIlIIllIIIIl, final String llllllllllllllIlllIlIIlIIIllIIll, final int llllllllllllllIlllIlIIlIIIllIIIl) {
        final float llllllllllllllIlllIlIIlIIlIllIll = (float)llllllllllllllIlllIlIIlIIllIIIIl.getIconWidth();
        final float llllllllllllllIlllIlIIlIIlIllIII = (float)llllllllllllllIlllIlIIlIIllIIIIl.getIconHeight();
        final ArrayList llllllllllllllIlllIlIIlIIlIlIllI = Lists.newArrayList();
        for (final Span llllllllllllllIlllIlIIlIIlIlIIlI : this.func_178393_a(llllllllllllllIlllIlIIlIIllIIIIl)) {
            float llllllllllllllIlllIlIIlIIlIlIIII = 0.0f;
            float llllllllllllllIlllIlIIlIIlIIlllI = 0.0f;
            float llllllllllllllIlllIlIIlIIlIIllII = 0.0f;
            float llllllllllllllIlllIlIIlIIlIIlIlI = 0.0f;
            float llllllllllllllIlllIlIIlIIlIIlIII = 0.0f;
            float llllllllllllllIlllIlIIlIIlIIIllI = 0.0f;
            float llllllllllllllIlllIlIIlIIlIIIlII = 0.0f;
            float llllllllllllllIlllIlIIlIIlIIIIlI = 0.0f;
            float llllllllllllllIlllIlIIlIIlIIIIIl = 0.0f;
            float llllllllllllllIlllIlIIlIIlIIIIII = 0.0f;
            final float llllllllllllllIlllIlIIlIIIlllllI = (float)llllllllllllllIlllIlIIlIIlIlIIlI.func_178385_b();
            final float llllllllllllllIlllIlIIlIIIllllIl = (float)llllllllllllllIlllIlIIlIIlIlIIlI.func_178384_c();
            final float llllllllllllllIlllIlIIlIIIllllII = (float)llllllllllllllIlllIlIIlIIlIlIIlI.func_178381_d();
            final SpanFacing llllllllllllllIlllIlIIlIIIlllIll = llllllllllllllIlllIlIIlIIlIlIIlI.func_178383_a();
            switch (SwitchSpanFacing.field_178390_a[llllllllllllllIlllIlIIlIIIlllIll.ordinal()]) {
                case 1: {
                    llllllllllllllIlllIlIIlIIlIIlIII = llllllllllllllIlllIlIIlIIIlllllI;
                    llllllllllllllIlllIlIIlIIlIlIIII = llllllllllllllIlllIlIIlIIIlllllI;
                    llllllllllllllIlllIlIIlIIlIIIllI = (llllllllllllllIlllIlIIlIIlIIllII = llllllllllllllIlllIlIIlIIIllllIl + 1.0f);
                    llllllllllllllIlllIlIIlIIlIIIlII = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIIlllI = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIIIIlI = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIIlIlI = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIIIIIl = 16.0f / llllllllllllllIlllIlIIlIIlIllIll;
                    llllllllllllllIlllIlIIlIIlIIIIII = 16.0f / (llllllllllllllIlllIlIIlIIlIllIII - 1.0f);
                    break;
                }
                case 2: {
                    llllllllllllllIlllIlIIlIIlIIIIlI = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIIIlII = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIIlIII = llllllllllllllIlllIlIIlIIIlllllI;
                    llllllllllllllIlllIlIIlIIlIlIIII = llllllllllllllIlllIlIIlIIIlllllI;
                    llllllllllllllIlllIlIIlIIlIIIllI = (llllllllllllllIlllIlIIlIIlIIllII = llllllllllllllIlllIlIIlIIIllllIl + 1.0f);
                    llllllllllllllIlllIlIIlIIlIIlllI = llllllllllllllIlllIlIIlIIIllllII + 1.0f;
                    llllllllllllllIlllIlIIlIIlIIlIlI = llllllllllllllIlllIlIIlIIIllllII + 1.0f;
                    llllllllllllllIlllIlIIlIIlIIIIIl = 16.0f / llllllllllllllIlllIlIIlIIlIllIll;
                    llllllllllllllIlllIlIIlIIlIIIIII = 16.0f / (llllllllllllllIlllIlIIlIIlIllIII - 1.0f);
                    break;
                }
                case 3: {
                    llllllllllllllIlllIlIIlIIlIIlIII = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIlIIII = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIIIllI = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIIllII = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIIIIlI = llllllllllllllIlllIlIIlIIIlllllI;
                    llllllllllllllIlllIlIIlIIlIIlllI = llllllllllllllIlllIlIIlIIIlllllI;
                    llllllllllllllIlllIlIIlIIlIIIlII = (llllllllllllllIlllIlIIlIIlIIlIlI = llllllllllllllIlllIlIIlIIIllllIl + 1.0f);
                    llllllllllllllIlllIlIIlIIlIIIIIl = 16.0f / (llllllllllllllIlllIlIIlIIlIllIll - 1.0f);
                    llllllllllllllIlllIlIIlIIlIIIIII = 16.0f / llllllllllllllIlllIlIIlIIlIllIII;
                    break;
                }
                case 4: {
                    llllllllllllllIlllIlIIlIIlIIIllI = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIIlIII = llllllllllllllIlllIlIIlIIIllllII;
                    llllllllllllllIlllIlIIlIIlIlIIII = llllllllllllllIlllIlIIlIIIllllII + 1.0f;
                    llllllllllllllIlllIlIIlIIlIIllII = llllllllllllllIlllIlIIlIIIllllII + 1.0f;
                    llllllllllllllIlllIlIIlIIlIIIIlI = llllllllllllllIlllIlIIlIIIlllllI;
                    llllllllllllllIlllIlIIlIIlIIlllI = llllllllllllllIlllIlIIlIIIlllllI;
                    llllllllllllllIlllIlIIlIIlIIIlII = (llllllllllllllIlllIlIIlIIlIIlIlI = llllllllllllllIlllIlIIlIIIllllIl + 1.0f);
                    llllllllllllllIlllIlIIlIIlIIIIIl = 16.0f / (llllllllllllllIlllIlIIlIIlIllIll - 1.0f);
                    llllllllllllllIlllIlIIlIIlIIIIII = 16.0f / llllllllllllllIlllIlIIlIIlIllIII;
                    break;
                }
            }
            final float llllllllllllllIlllIlIIlIIIlllIlI = 16.0f / llllllllllllllIlllIlIIlIIlIllIll;
            final float llllllllllllllIlllIlIIlIIIlllIIl = 16.0f / llllllllllllllIlllIlIIlIIlIllIII;
            llllllllllllllIlllIlIIlIIlIlIIII *= llllllllllllllIlllIlIIlIIIlllIlI;
            llllllllllllllIlllIlIIlIIlIIllII *= llllllllllllllIlllIlIIlIIIlllIlI;
            llllllllllllllIlllIlIIlIIlIIlllI *= llllllllllllllIlllIlIIlIIIlllIIl;
            llllllllllllllIlllIlIIlIIlIIlIlI *= llllllllllllllIlllIlIIlIIIlllIIl;
            llllllllllllllIlllIlIIlIIlIIlllI = 16.0f - llllllllllllllIlllIlIIlIIlIIlllI;
            llllllllllllllIlllIlIIlIIlIIlIlI = 16.0f - llllllllllllllIlllIlIIlIIlIIlIlI;
            llllllllllllllIlllIlIIlIIlIIlIII *= llllllllllllllIlllIlIIlIIlIIIIIl;
            llllllllllllllIlllIlIIlIIlIIIllI *= llllllllllllllIlllIlIIlIIlIIIIIl;
            llllllllllllllIlllIlIIlIIlIIIlII *= llllllllllllllIlllIlIIlIIlIIIIII;
            llllllllllllllIlllIlIIlIIlIIIIlI *= llllllllllllllIlllIlIIlIIlIIIIII;
            final HashMap llllllllllllllIlllIlIIlIIIlllIII = Maps.newHashMap();
            llllllllllllllIlllIlIIlIIIlllIII.put(llllllllllllllIlllIlIIlIIIlllIll.func_178367_a(), new BlockPartFace(null, llllllllllllllIlllIlIIlIIIllIIIl, llllllllllllllIlllIlIIlIIIllIIll, new BlockFaceUV(new float[] { llllllllllllllIlllIlIIlIIlIIlIII, llllllllllllllIlllIlIIlIIlIIIlII, llllllllllllllIlllIlIIlIIlIIIllI, llllllllllllllIlllIlIIlIIlIIIIlI }, 0)));
            switch (SwitchSpanFacing.field_178390_a[llllllllllllllIlllIlIIlIIIlllIll.ordinal()]) {
                default: {
                    continue;
                }
                case 1: {
                    llllllllllllllIlllIlIIlIIlIlIllI.add(new BlockPart(new Vector3f(llllllllllllllIlllIlIIlIIlIlIIII, llllllllllllllIlllIlIIlIIlIIlllI, 7.5f), new Vector3f(llllllllllllllIlllIlIIlIIlIIllII, llllllllllllllIlllIlIIlIIlIIlllI, 8.5f), llllllllllllllIlllIlIIlIIIlllIII, null, true));
                    continue;
                }
                case 2: {
                    llllllllllllllIlllIlIIlIIlIlIllI.add(new BlockPart(new Vector3f(llllllllllllllIlllIlIIlIIlIlIIII, llllllllllllllIlllIlIIlIIlIIlIlI, 7.5f), new Vector3f(llllllllllllllIlllIlIIlIIlIIllII, llllllllllllllIlllIlIIlIIlIIlIlI, 8.5f), llllllllllllllIlllIlIIlIIIlllIII, null, true));
                    continue;
                }
                case 3: {
                    llllllllllllllIlllIlIIlIIlIlIllI.add(new BlockPart(new Vector3f(llllllllllllllIlllIlIIlIIlIlIIII, llllllllllllllIlllIlIIlIIlIIlllI, 7.5f), new Vector3f(llllllllllllllIlllIlIIlIIlIlIIII, llllllllllllllIlllIlIIlIIlIIlIlI, 8.5f), llllllllllllllIlllIlIIlIIIlllIII, null, true));
                    continue;
                }
                case 4: {
                    llllllllllllllIlllIlIIlIIlIlIllI.add(new BlockPart(new Vector3f(llllllllllllllIlllIlIIlIIlIIllII, llllllllllllllIlllIlIIlIIlIIlllI, 7.5f), new Vector3f(llllllllllllllIlllIlIIlIIlIIllII, llllllllllllllIlllIlIIlIIlIIlIlI, 8.5f), llllllllllllllIlllIlIIlIIIlllIII, null, true));
                    continue;
                }
            }
        }
        return llllllllllllllIlllIlIIlIIlIlIllI;
    }
    
    private List func_178394_a(final int llllllllllllllIlllIlIIlIlIlIlIll, final String llllllllllllllIlllIlIIlIlIlIlIlI, final TextureAtlasSprite llllllllllllllIlllIlIIlIlIlIlIIl) {
        final HashMap llllllllllllllIlllIlIIlIlIlIlllI = Maps.newHashMap();
        llllllllllllllIlllIlIIlIlIlIlllI.put(EnumFacing.SOUTH, new BlockPartFace(null, llllllllllllllIlllIlIIlIlIlIlIll, llllllllllllllIlllIlIIlIlIlIlIlI, new BlockFaceUV(new float[] { 0.0f, 0.0f, 16.0f, 16.0f }, 0)));
        llllllllllllllIlllIlIIlIlIlIlllI.put(EnumFacing.NORTH, new BlockPartFace(null, llllllllllllllIlllIlIIlIlIlIlIll, llllllllllllllIlllIlIIlIlIlIlIlI, new BlockFaceUV(new float[] { 16.0f, 0.0f, 0.0f, 16.0f }, 0)));
        final ArrayList llllllllllllllIlllIlIIlIlIlIllIl = Lists.newArrayList();
        llllllllllllllIlllIlIIlIlIlIllIl.add(new BlockPart(new Vector3f(0.0f, 0.0f, 7.5f), new Vector3f(16.0f, 16.0f, 8.5f), llllllllllllllIlllIlIIlIlIlIlllI, null, true));
        llllllllllllllIlllIlIIlIlIlIllIl.addAll(this.func_178397_a(llllllllllllllIlllIlIIlIlIlIlIIl, llllllllllllllIlllIlIIlIlIlIlIlI, llllllllllllllIlllIlIIlIlIlIlIll));
        return llllllllllllllIlllIlIIlIlIlIllIl;
    }
    
    static {
        __OBFID = "CL_00002488";
        LAYERS = Lists.newArrayList((Object[])new String[] { "layer0", "layer1", "layer2", "layer3", "layer4" });
    }
    
    private void func_178395_a(final List llllllllllllllIlllIlIIIllIlIllIl, final SpanFacing llllllllllllllIlllIlIIIllIlIIIlI, final int llllllllllllllIlllIlIIIllIlIIIIl, final int llllllllllllllIlllIlIIIllIlIlIlI) {
        Span llllllllllllllIlllIlIIIllIlIlIIl = null;
        for (final Span llllllllllllllIlllIlIIIllIlIIlll : llllllllllllllIlllIlIIIllIlIllIl) {
            if (llllllllllllllIlllIlIIIllIlIIlll.func_178383_a() == llllllllllllllIlllIlIIIllIlIIIlI) {
                final int llllllllllllllIlllIlIIIllIlIIllI = llllllllllllllIlllIlIIIllIlIIIlI.func_178369_d() ? llllllllllllllIlllIlIIIllIlIlIlI : llllllllllllllIlllIlIIIllIlIIIIl;
                if (llllllllllllllIlllIlIIIllIlIIlll.func_178381_d() == llllllllllllllIlllIlIIIllIlIIllI) {
                    llllllllllllllIlllIlIIIllIlIlIIl = llllllllllllllIlllIlIIIllIlIIlll;
                    break;
                }
                continue;
            }
        }
        final int llllllllllllllIlllIlIIIllIlIIlIl = llllllllllllllIlllIlIIIllIlIIIlI.func_178369_d() ? llllllllllllllIlllIlIIIllIlIlIlI : llllllllllllllIlllIlIIIllIlIIIIl;
        final int llllllllllllllIlllIlIIIllIlIIlII = llllllllllllllIlllIlIIIllIlIIIlI.func_178369_d() ? llllllllllllllIlllIlIIIllIlIIIIl : llllllllllllllIlllIlIIIllIlIlIlI;
        if (llllllllllllllIlllIlIIIllIlIlIIl == null) {
            llllllllllllllIlllIlIIIllIlIllIl.add(new Span(llllllllllllllIlllIlIIIllIlIIIlI, llllllllllllllIlllIlIIIllIlIIlII, llllllllllllllIlllIlIIIllIlIIlIl));
        }
        else {
            llllllllllllllIlllIlIIIllIlIlIIl.func_178382_a(llllllllllllllIlllIlIIIllIlIIlII);
        }
    }
    
    private boolean func_178391_a(final int[] llllllllllllllIlllIlIIIllIIlIlIl, final int llllllllllllllIlllIlIIIllIIIllll, final int llllllllllllllIlllIlIIIllIIlIIll, final int llllllllllllllIlllIlIIIllIIIllIl, final int llllllllllllllIlllIlIIIllIIIllII) {
        return llllllllllllllIlllIlIIIllIIIllll < 0 || llllllllllllllIlllIlIIIllIIlIIll < 0 || llllllllllllllIlllIlIIIllIIIllll >= llllllllllllllIlllIlIIIllIIIllIl || llllllllllllllIlllIlIIIllIIlIIll >= llllllllllllllIlllIlIIIllIIIllII || (llllllllllllllIlllIlIIIllIIlIlIl[llllllllllllllIlllIlIIIllIIlIIll * llllllllllllllIlllIlIIIllIIIllIl + llllllllllllllIlllIlIIIllIIIllll] >> 24 & 0xFF) == 0x0;
    }
    
    private void func_178396_a(final SpanFacing llllllllllllllIlllIlIIIllIllllll, final List llllllllllllllIlllIlIIIlllIIlIII, final int[] llllllllllllllIlllIlIIIllIllllIl, final int llllllllllllllIlllIlIIIlllIIIllI, final int llllllllllllllIlllIlIIIlllIIIlIl, final int llllllllllllllIlllIlIIIlllIIIlII, final int llllllllllllllIlllIlIIIlllIIIIll, final boolean llllllllllllllIlllIlIIIllIlllIII) {
        final boolean llllllllllllllIlllIlIIIlllIIIIIl = this.func_178391_a(llllllllllllllIlllIlIIIllIllllIl, llllllllllllllIlllIlIIIlllIIIllI + llllllllllllllIlllIlIIIllIllllll.func_178372_b(), llllllllllllllIlllIlIIIlllIIIlIl + llllllllllllllIlllIlIIIllIllllll.func_178371_c(), llllllllllllllIlllIlIIIlllIIIlII, llllllllllllllIlllIlIIIlllIIIIll) && llllllllllllllIlllIlIIIllIlllIII;
        if (llllllllllllllIlllIlIIIlllIIIIIl) {
            this.func_178395_a(llllllllllllllIlllIlIIIlllIIlIII, llllllllllllllIlllIlIIIllIllllll, llllllllllllllIlllIlIIIlllIIIllI, llllllllllllllIlllIlIIIlllIIIlIl);
        }
    }
    
    public ModelBlock func_178392_a(final TextureMap llllllllllllllIlllIlIIlIllIIIIII, final ModelBlock llllllllllllllIlllIlIIlIlIllllll) {
        final HashMap llllllllllllllIlllIlIIlIllIIIlll = Maps.newHashMap();
        final ArrayList llllllllllllllIlllIlIIlIllIIIllI = Lists.newArrayList();
        for (int llllllllllllllIlllIlIIlIllIIIlIl = 0; llllllllllllllIlllIlIIlIllIIIlIl < ItemModelGenerator.LAYERS.size(); ++llllllllllllllIlllIlIIlIllIIIlIl) {
            final String llllllllllllllIlllIlIIlIllIIIlII = ItemModelGenerator.LAYERS.get(llllllllllllllIlllIlIIlIllIIIlIl);
            if (!llllllllllllllIlllIlIIlIlIllllll.isTexturePresent(llllllllllllllIlllIlIIlIllIIIlII)) {
                break;
            }
            final String llllllllllllllIlllIlIIlIllIIIIll = llllllllllllllIlllIlIIlIlIllllll.resolveTextureName(llllllllllllllIlllIlIIlIllIIIlII);
            llllllllllllllIlllIlIIlIllIIIlll.put(llllllllllllllIlllIlIIlIllIIIlII, llllllllllllllIlllIlIIlIllIIIIll);
            final TextureAtlasSprite llllllllllllllIlllIlIIlIllIIIIlI = llllllllllllllIlllIlIIlIllIIIIII.getAtlasSprite(new ResourceLocation(llllllllllllllIlllIlIIlIllIIIIll).toString());
            llllllllllllllIlllIlIIlIllIIIllI.addAll(this.func_178394_a(llllllllllllllIlllIlIIlIllIIIlIl, llllllllllllllIlllIlIIlIllIIIlII, llllllllllllllIlllIlIIlIllIIIIlI));
        }
        if (llllllllllllllIlllIlIIlIllIIIllI.isEmpty()) {
            return null;
        }
        llllllllllllllIlllIlIIlIllIIIlll.put("particle", llllllllllllllIlllIlIIlIlIllllll.isTexturePresent("particle") ? llllllllllllllIlllIlIIlIlIllllll.resolveTextureName("particle") : llllllllllllllIlllIlIIlIllIIIlll.get("layer0"));
        return new ModelBlock(llllllllllllllIlllIlIIlIllIIIllI, llllllllllllllIlllIlIIlIllIIIlll, false, false, new ItemCameraTransforms(llllllllllllllIlllIlIIlIlIllllll.getThirdPersonTransform(), llllllllllllllIlllIlIIlIlIllllll.getFirstPersonTransform(), llllllllllllllIlllIlIIlIlIllllll.getHeadTransform(), llllllllllllllIlllIlIIlIlIllllll.getInGuiTransform()));
    }
    
    enum SpanFacing
    {
        private final /* synthetic */ EnumFacing field_178376_e;
        
        DOWN("DOWN", 1, "DOWN", 1, EnumFacing.DOWN, 0, 1), 
        UP("UP", 0, "UP", 0, EnumFacing.UP, 0, -1);
        
        private final /* synthetic */ int field_178374_g;
        
        RIGHT("RIGHT", 3, "RIGHT", 3, EnumFacing.WEST, 1, 0), 
        LEFT("LEFT", 2, "LEFT", 2, EnumFacing.EAST, -1, 0);
        
        private final /* synthetic */ int field_178373_f;
        
        private SpanFacing(final String lllllllllllllllIlIlIIlllIIlIIlll, final int lllllllllllllllIlIlIIlllIIlIIllI, final String lllllllllllllllIlIlIIlllIIlIllIl, final int lllllllllllllllIlIlIIlllIIlIllII, final EnumFacing lllllllllllllllIlIlIIlllIIlIlIll, final int lllllllllllllllIlIlIIlllIIlIIlII, final int lllllllllllllllIlIlIIlllIIlIlIIl) {
            this.field_178376_e = lllllllllllllllIlIlIIlllIIlIlIll;
            this.field_178373_f = lllllllllllllllIlIlIIlllIIlIIlII;
            this.field_178374_g = lllllllllllllllIlIlIIlllIIlIlIIl;
        }
        
        public EnumFacing func_178367_a() {
            return this.field_178376_e;
        }
        
        static {
            __OBFID = "CL_00002485";
        }
        
        public int func_178371_c() {
            return this.field_178374_g;
        }
        
        private boolean func_178369_d() {
            return this == SpanFacing.DOWN || this == SpanFacing.UP;
        }
        
        public int func_178372_b() {
            return this.field_178373_f;
        }
    }
    
    static final class SwitchSpanFacing
    {
        static final /* synthetic */ int[] field_178390_a;
        
        static {
            __OBFID = "CL_00002487";
            field_178390_a = new int[SpanFacing.values().length];
            try {
                SwitchSpanFacing.field_178390_a[SpanFacing.UP.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchSpanFacing.field_178390_a[SpanFacing.DOWN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchSpanFacing.field_178390_a[SpanFacing.LEFT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchSpanFacing.field_178390_a[SpanFacing.RIGHT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
    
    static class Span
    {
        private /* synthetic */ int field_178388_c;
        private final /* synthetic */ int field_178386_d;
        private /* synthetic */ int field_178387_b;
        private final /* synthetic */ SpanFacing field_178389_a;
        
        public SpanFacing func_178383_a() {
            return this.field_178389_a;
        }
        
        public Span(final SpanFacing lllllllllllllllllIllIlIIIlIlllll, final int lllllllllllllllllIllIlIIIllIIIlI, final int lllllllllllllllllIllIlIIIllIIIIl) {
            this.field_178389_a = lllllllllllllllllIllIlIIIlIlllll;
            this.field_178387_b = lllllllllllllllllIllIlIIIllIIIlI;
            this.field_178388_c = lllllllllllllllllIllIlIIIllIIIlI;
            this.field_178386_d = lllllllllllllllllIllIlIIIllIIIIl;
        }
        
        public void func_178382_a(final int lllllllllllllllllIllIlIIIlIlIlll) {
            if (lllllllllllllllllIllIlIIIlIlIlll < this.field_178387_b) {
                this.field_178387_b = lllllllllllllllllIllIlIIIlIlIlll;
            }
            else if (lllllllllllllllllIllIlIIIlIlIlll > this.field_178388_c) {
                this.field_178388_c = lllllllllllllllllIllIlIIIlIlIlll;
            }
        }
        
        public int func_178381_d() {
            return this.field_178386_d;
        }
        
        static {
            __OBFID = "CL_00002486";
        }
        
        public int func_178385_b() {
            return this.field_178387_b;
        }
        
        public int func_178384_c() {
            return this.field_178388_c;
        }
    }
}
