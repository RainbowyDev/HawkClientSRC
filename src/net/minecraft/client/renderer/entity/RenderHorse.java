package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.*;

public class RenderHorse extends RenderLiving
{
    private static final /* synthetic */ ResourceLocation donkeyTextures;
    private static final /* synthetic */ ResourceLocation zombieHorseTextures;
    private static final /* synthetic */ Map field_110852_a;
    private static final /* synthetic */ ResourceLocation muleTextures;
    private static final /* synthetic */ ResourceLocation skeletonHorseTextures;
    private static final /* synthetic */ ResourceLocation whiteHorseTextures;
    
    @Override
    protected void preRenderCallback(final EntityLivingBase llllllllllllllIIllIIIlIllllIIIll, final float llllllllllllllIIllIIIlIlllIlllll) {
        this.func_180580_a((EntityHorse)llllllllllllllIIllIIIlIllllIIIll, llllllllllllllIIllIIIlIlllIlllll);
    }
    
    private ResourceLocation func_110848_b(final EntityHorse llllllllllllllIIllIIIlIllllIllIl) {
        final String llllllllllllllIIllIIIlIllllIllII = llllllllllllllIIllIIIlIllllIllIl.getHorseTexture();
        if (!llllllllllllllIIllIIIlIllllIllIl.func_175507_cI()) {
            return null;
        }
        ResourceLocation llllllllllllllIIllIIIlIllllIlIll = RenderHorse.field_110852_a.get(llllllllllllllIIllIIIlIllllIllII);
        if (llllllllllllllIIllIIIlIllllIlIll == null) {
            llllllllllllllIIllIIIlIllllIlIll = new ResourceLocation(llllllllllllllIIllIIIlIllllIllII);
            Minecraft.getMinecraft().getTextureManager().loadTexture(llllllllllllllIIllIIIlIllllIlIll, new LayeredTexture(llllllllllllllIIllIIIlIllllIllIl.getVariantTexturePaths()));
            RenderHorse.field_110852_a.put(llllllllllllllIIllIIIlIllllIllII, llllllllllllllIIllIIIlIllllIlIll);
        }
        return llllllllllllllIIllIIIlIllllIlIll;
    }
    
    protected ResourceLocation func_180581_a(final EntityHorse llllllllllllllIIllIIIlIlllllIIlI) {
        if (llllllllllllllIIllIIIlIlllllIIlI.func_110239_cn()) {
            return this.func_110848_b(llllllllllllllIIllIIIlIlllllIIlI);
        }
        switch (llllllllllllllIIllIIIlIlllllIIlI.getHorseType()) {
            default: {
                return RenderHorse.whiteHorseTextures;
            }
            case 1: {
                return RenderHorse.donkeyTextures;
            }
            case 2: {
                return RenderHorse.muleTextures;
            }
            case 3: {
                return RenderHorse.zombieHorseTextures;
            }
            case 4: {
                return RenderHorse.skeletonHorseTextures;
            }
        }
    }
    
    public RenderHorse(final RenderManager llllllllllllllIIllIIIllIIIIIllIl, final ModelHorse llllllllllllllIIllIIIllIIIIIllII, final float llllllllllllllIIllIIIllIIIIIlIll) {
        super(llllllllllllllIIllIIIllIIIIIllIl, llllllllllllllIIllIIIllIIIIIllII, llllllllllllllIIllIIIllIIIIIlIll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllllIIllIIIlIlllIllIIl) {
        return this.func_180581_a((EntityHorse)llllllllllllllIIllIIIlIlllIllIIl);
    }
    
    static {
        __OBFID = "CL_00001000";
        field_110852_a = Maps.newHashMap();
        whiteHorseTextures = new ResourceLocation("textures/entity/horse/horse_white.png");
        muleTextures = new ResourceLocation("textures/entity/horse/mule.png");
        donkeyTextures = new ResourceLocation("textures/entity/horse/donkey.png");
        zombieHorseTextures = new ResourceLocation("textures/entity/horse/horse_zombie.png");
        skeletonHorseTextures = new ResourceLocation("textures/entity/horse/horse_skeleton.png");
    }
    
    protected void func_180580_a(final EntityHorse llllllllllllllIIllIIIllIIIIIIIII, final float llllllllllllllIIllIIIlIlllllllll) {
        float llllllllllllllIIllIIIlIllllllllI = 1.0f;
        final int llllllllllllllIIllIIIlIlllllllIl = llllllllllllllIIllIIIllIIIIIIIII.getHorseType();
        if (llllllllllllllIIllIIIlIlllllllIl == 1) {
            llllllllllllllIIllIIIlIllllllllI *= 0.87f;
        }
        else if (llllllllllllllIIllIIIlIlllllllIl == 2) {
            llllllllllllllIIllIIIlIllllllllI *= 0.92f;
        }
        GlStateManager.scale(llllllllllllllIIllIIIlIllllllllI, llllllllllllllIIllIIIlIllllllllI, llllllllllllllIIllIIIlIllllllllI);
        super.preRenderCallback(llllllllllllllIIllIIIllIIIIIIIII, llllllllllllllIIllIIIlIlllllllll);
    }
}
