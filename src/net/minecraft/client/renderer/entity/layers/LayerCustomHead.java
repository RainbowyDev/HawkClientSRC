package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.init.*;
import com.mojang.authlib.*;
import java.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.nbt.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class LayerCustomHead implements LayerRenderer
{
    private final /* synthetic */ ModelRenderer field_177209_a;
    
    public LayerCustomHead(final ModelRenderer llllllllllllllIIIIlllIlIlllIIlII) {
        this.field_177209_a = llllllllllllllIIIIlllIlIlllIIlII;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIIIIlllIlIlIllIIIl, final float llllllllllllllIIIIlllIlIllIIIIll, final float llllllllllllllIIIIlllIlIllIIIIlI, final float llllllllllllllIIIIlllIlIllIIIIIl, final float llllllllllllllIIIIlllIlIllIIIIII, final float llllllllllllllIIIIlllIlIlIllllll, final float llllllllllllllIIIIlllIlIlIlllllI, final float llllllllllllllIIIIlllIlIlIllIIII) {
        final ItemStack llllllllllllllIIIIlllIlIlIllllII = llllllllllllllIIIIlllIlIlIllIIIl.getCurrentArmor(3);
        if (llllllllllllllIIIIlllIlIlIllllII != null && llllllllllllllIIIIlllIlIlIllllII.getItem() != null) {
            final Item llllllllllllllIIIIlllIlIlIlllIll = llllllllllllllIIIIlllIlIlIllllII.getItem();
            final Minecraft llllllllllllllIIIIlllIlIlIlllIlI = Minecraft.getMinecraft();
            GlStateManager.pushMatrix();
            if (llllllllllllllIIIIlllIlIlIllIIIl.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            final boolean llllllllllllllIIIIlllIlIlIlllIIl = llllllllllllllIIIIlllIlIlIllIIIl instanceof EntityVillager || (llllllllllllllIIIIlllIlIlIllIIIl instanceof EntityZombie && ((EntityZombie)llllllllllllllIIIIlllIlIlIllIIIl).isVillager());
            if (!llllllllllllllIIIIlllIlIlIlllIIl && llllllllllllllIIIIlllIlIlIllIIIl.isChild()) {
                final float llllllllllllllIIIIlllIlIlIlllIII = 2.0f;
                final float llllllllllllllIIIIlllIlIlIllIlIl = 1.4f;
                GlStateManager.scale(llllllllllllllIIIIlllIlIlIllIlIl / llllllllllllllIIIIlllIlIlIlllIII, llllllllllllllIIIIlllIlIlIllIlIl / llllllllllllllIIIIlllIlIlIlllIII, llllllllllllllIIIIlllIlIlIllIlIl / llllllllllllllIIIIlllIlIlIlllIII);
                GlStateManager.translate(0.0f, 16.0f * llllllllllllllIIIIlllIlIlIllIIII, 0.0f);
            }
            this.field_177209_a.postRender(0.0625f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (llllllllllllllIIIIlllIlIlIlllIll instanceof ItemBlock) {
                final float llllllllllllllIIIIlllIlIlIllIlll = 0.625f;
                GlStateManager.translate(0.0f, -0.25f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.scale(llllllllllllllIIIIlllIlIlIllIlll, -llllllllllllllIIIIlllIlIlIllIlll, -llllllllllllllIIIIlllIlIlIllIlll);
                if (llllllllllllllIIIIlllIlIlIlllIIl) {
                    GlStateManager.translate(0.0f, 0.1875f, 0.0f);
                }
                llllllllllllllIIIIlllIlIlIlllIlI.getItemRenderer().renderItem(llllllllllllllIIIIlllIlIlIllIIIl, llllllllllllllIIIIlllIlIlIllllII, ItemCameraTransforms.TransformType.HEAD);
            }
            else if (llllllllllllllIIIIlllIlIlIlllIll == Items.skull) {
                final float llllllllllllllIIIIlllIlIlIllIllI = 1.1875f;
                GlStateManager.scale(llllllllllllllIIIIlllIlIlIllIllI, -llllllllllllllIIIIlllIlIlIllIllI, -llllllllllllllIIIIlllIlIlIllIllI);
                if (llllllllllllllIIIIlllIlIlIlllIIl) {
                    GlStateManager.translate(0.0f, 0.0625f, 0.0f);
                }
                GameProfile llllllllllllllIIIIlllIlIlIllIlII = null;
                if (llllllllllllllIIIIlllIlIlIllllII.hasTagCompound()) {
                    final NBTTagCompound llllllllllllllIIIIlllIlIlIllIIll = llllllllllllllIIIIlllIlIlIllllII.getTagCompound();
                    if (llllllllllllllIIIIlllIlIlIllIIll.hasKey("SkullOwner", 10)) {
                        llllllllllllllIIIIlllIlIlIllIlII = NBTUtil.readGameProfileFromNBT(llllllllllllllIIIIlllIlIlIllIIll.getCompoundTag("SkullOwner"));
                    }
                    else if (llllllllllllllIIIIlllIlIlIllIIll.hasKey("SkullOwner", 8)) {
                        llllllllllllllIIIIlllIlIlIllIlII = TileEntitySkull.updateGameprofile(new GameProfile((UUID)null, llllllllllllllIIIIlllIlIlIllIIll.getString("SkullOwner")));
                        llllllllllllllIIIIlllIlIlIllIIll.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), llllllllllllllIIIIlllIlIlIllIlII));
                    }
                }
                TileEntitySkullRenderer.instance.renderSkull(-0.5f, 0.0f, -0.5f, EnumFacing.UP, 180.0f, llllllllllllllIIIIlllIlIlIllllII.getMetadata(), llllllllllllllIIIIlllIlIlIllIlII, -1);
            }
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    static {
        __OBFID = "CL_00002422";
    }
}
