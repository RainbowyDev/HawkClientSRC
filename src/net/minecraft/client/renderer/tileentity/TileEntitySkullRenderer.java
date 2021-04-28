package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.model.*;
import com.mojang.authlib.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import com.mojang.authlib.minecraft.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import java.util.*;

public class TileEntitySkullRenderer extends TileEntitySpecialRenderer
{
    private static final /* synthetic */ ResourceLocation field_147532_f;
    public static /* synthetic */ TileEntitySkullRenderer instance;
    private static final /* synthetic */ ResourceLocation field_147537_c;
    private final /* synthetic */ ModelSkeletonHead field_178468_i;
    private final /* synthetic */ ModelSkeletonHead field_178467_h;
    private static final /* synthetic */ ResourceLocation field_147534_d;
    private static final /* synthetic */ ResourceLocation field_147535_e;
    
    public void func_180542_a(final TileEntitySkull llllllllllllllIIIllllIIlIlIIlIII, final double llllllllllllllIIIllllIIlIlIIllll, final double llllllllllllllIIIllllIIlIlIIIllI, final double llllllllllllllIIIllllIIlIlIIllIl, final float llllllllllllllIIIllllIIlIlIIllII, final int llllllllllllllIIIllllIIlIlIIIlII) {
        final EnumFacing llllllllllllllIIIllllIIlIlIIlIlI = EnumFacing.getFront(llllllllllllllIIIllllIIlIlIIlIII.getBlockMetadata() & 0x7);
        this.renderSkull((float)llllllllllllllIIIllllIIlIlIIllll, (float)llllllllllllllIIIllllIIlIlIIIllI, (float)llllllllllllllIIIllllIIlIlIIllIl, llllllllllllllIIIllllIIlIlIIlIlI, llllllllllllllIIIllllIIlIlIIlIII.getSkullRotation() * 360 / 16.0f, llllllllllllllIIIllllIIlIlIIlIII.getSkullType(), llllllllllllllIIIllllIIlIlIIlIII.getPlayerProfile(), llllllllllllllIIIllllIIlIlIIIlII);
    }
    
    @Override
    public void setRendererDispatcher(final TileEntityRendererDispatcher llllllllllllllIIIllllIIlIIllllll) {
        super.setRendererDispatcher(llllllllllllllIIIllllIIlIIllllll);
        TileEntitySkullRenderer.instance = this;
    }
    
    @Override
    public void renderTileEntityAt(final TileEntity llllllllllllllIIIllllIIlIIIIlIIl, final double llllllllllllllIIIllllIIlIIIIIIIl, final double llllllllllllllIIIllllIIlIIIIIIII, final double llllllllllllllIIIllllIIlIIIIIllI, final float llllllllllllllIIIllllIIlIIIIIlIl, final int llllllllllllllIIIllllIIlIIIIIlII) {
        this.func_180542_a((TileEntitySkull)llllllllllllllIIIllllIIlIIIIlIIl, llllllllllllllIIIllllIIlIIIIIIIl, llllllllllllllIIIllllIIlIIIIIIII, llllllllllllllIIIllllIIlIIIIIllI, llllllllllllllIIIllllIIlIIIIIlIl, llllllllllllllIIIllllIIlIIIIIlII);
    }
    
    public TileEntitySkullRenderer() {
        this.field_178467_h = new ModelSkeletonHead(0, 0, 64, 32);
        this.field_178468_i = new ModelHumanoidHead();
    }
    
    static {
        __OBFID = "CL_00000971";
        field_147537_c = new ResourceLocation("textures/entity/skeleton/skeleton.png");
        field_147534_d = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
        field_147535_e = new ResourceLocation("textures/entity/zombie/zombie.png");
        field_147532_f = new ResourceLocation("textures/entity/creeper/creeper.png");
    }
    
    public void renderSkull(final float llllllllllllllIIIllllIIlIIlIllIl, final float llllllllllllllIIIllllIIlIIlIllII, final float llllllllllllllIIIllllIIlIIlIlIll, final EnumFacing llllllllllllllIIIllllIIlIIIllIll, float llllllllllllllIIIllllIIlIIIllIlI, final int llllllllllllllIIIllllIIlIIIllIIl, final GameProfile llllllllllllllIIIllllIIlIIIllIII, final int llllllllllllllIIIllllIIlIIlIIllI) {
        ModelSkeletonHead llllllllllllllIIIllllIIlIIlIIlIl = this.field_178467_h;
        if (llllllllllllllIIIllllIIlIIlIIllI >= 0) {
            this.bindTexture(TileEntitySkullRenderer.DESTROY_STAGES[llllllllllllllIIIllllIIlIIlIIllI]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 2.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            switch (llllllllllllllIIIllllIIlIIIllIIl) {
                default: {
                    this.bindTexture(TileEntitySkullRenderer.field_147537_c);
                    break;
                }
                case 1: {
                    this.bindTexture(TileEntitySkullRenderer.field_147534_d);
                    break;
                }
                case 2: {
                    this.bindTexture(TileEntitySkullRenderer.field_147535_e);
                    llllllllllllllIIIllllIIlIIlIIlIl = this.field_178468_i;
                    break;
                }
                case 3: {
                    llllllllllllllIIIllllIIlIIlIIlIl = this.field_178468_i;
                    ResourceLocation llllllllllllllIIIllllIIlIIlIIlII = DefaultPlayerSkin.func_177335_a();
                    if (llllllllllllllIIIllllIIlIIIllIII != null) {
                        final Minecraft llllllllllllllIIIllllIIlIIlIIIll = Minecraft.getMinecraft();
                        final Map llllllllllllllIIIllllIIlIIlIIIlI = llllllllllllllIIIllllIIlIIlIIIll.getSkinManager().loadSkinFromCache(llllllllllllllIIIllllIIlIIIllIII);
                        if (llllllllllllllIIIllllIIlIIlIIIlI.containsKey(MinecraftProfileTexture.Type.SKIN)) {
                            llllllllllllllIIIllllIIlIIlIIlII = llllllllllllllIIIllllIIlIIlIIIll.getSkinManager().loadSkin(llllllllllllllIIIllllIIlIIlIIIlI.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN);
                        }
                        else {
                            final UUID llllllllllllllIIIllllIIlIIlIIIIl = EntityPlayer.getUUID(llllllllllllllIIIllllIIlIIIllIII);
                            llllllllllllllIIIllllIIlIIlIIlII = DefaultPlayerSkin.func_177334_a(llllllllllllllIIIllllIIlIIlIIIIl);
                        }
                    }
                    this.bindTexture(llllllllllllllIIIllllIIlIIlIIlII);
                    break;
                }
                case 4: {
                    this.bindTexture(TileEntitySkullRenderer.field_147532_f);
                    break;
                }
            }
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        if (llllllllllllllIIIllllIIlIIIllIll != EnumFacing.UP) {
            switch (SwitchEnumFacing.field_178458_a[llllllllllllllIIIllllIIlIIIllIll.ordinal()]) {
                case 1: {
                    GlStateManager.translate(llllllllllllllIIIllllIIlIIlIllIl + 0.5f, llllllllllllllIIIllllIIlIIlIllII + 0.25f, llllllllllllllIIIllllIIlIIlIlIll + 0.74f);
                    break;
                }
                case 2: {
                    GlStateManager.translate(llllllllllllllIIIllllIIlIIlIllIl + 0.5f, llllllllllllllIIIllllIIlIIlIllII + 0.25f, llllllllllllllIIIllllIIlIIlIlIll + 0.26f);
                    llllllllllllllIIIllllIIlIIIllIlI = 180.0f;
                    break;
                }
                case 3: {
                    GlStateManager.translate(llllllllllllllIIIllllIIlIIlIllIl + 0.74f, llllllllllllllIIIllllIIlIIlIllII + 0.25f, llllllllllllllIIIllllIIlIIlIlIll + 0.5f);
                    llllllllllllllIIIllllIIlIIIllIlI = 270.0f;
                    break;
                }
                default: {
                    GlStateManager.translate(llllllllllllllIIIllllIIlIIlIllIl + 0.26f, llllllllllllllIIIllllIIlIIlIllII + 0.25f, llllllllllllllIIIllllIIlIIlIlIll + 0.5f);
                    llllllllllllllIIIllllIIlIIIllIlI = 90.0f;
                    break;
                }
            }
        }
        else {
            GlStateManager.translate(llllllllllllllIIIllllIIlIIlIllIl + 0.5f, llllllllllllllIIIllllIIlIIlIllII, llllllllllllllIIIllllIIlIIlIlIll + 0.5f);
        }
        final float llllllllllllllIIIllllIIlIIlIIIII = 0.0625f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        GlStateManager.enableAlpha();
        llllllllllllllIIIllllIIlIIlIIlIl.render(null, 0.0f, 0.0f, 0.0f, llllllllllllllIIIllllIIlIIIllIlI, 0.0f, llllllllllllllIIIllllIIlIIlIIIII);
        GlStateManager.popMatrix();
        if (llllllllllllllIIIllllIIlIIlIIllI >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_178458_a;
        
        static {
            __OBFID = "CL_00002468";
            field_178458_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_178458_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_178458_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_178458_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_178458_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
