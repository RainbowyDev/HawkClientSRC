package net.minecraft.client.renderer.tileentity;

import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import com.mojang.authlib.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;

public class TileEntityRendererChestHelper
{
    private /* synthetic */ TileEntityChest field_147717_b;
    private /* synthetic */ TileEntityChest field_147718_c;
    private /* synthetic */ TileEntitySkull field_179023_f;
    private /* synthetic */ TileEntityBanner banner;
    private /* synthetic */ TileEntityEnderChest field_147716_d;
    public static /* synthetic */ TileEntityRendererChestHelper instance;
    
    static {
        __OBFID = "CL_00000946";
        TileEntityRendererChestHelper.instance = new TileEntityRendererChestHelper();
    }
    
    public TileEntityRendererChestHelper() {
        this.field_147717_b = new TileEntityChest(0);
        this.field_147718_c = new TileEntityChest(1);
        this.field_147716_d = new TileEntityEnderChest();
        this.banner = new TileEntityBanner();
        this.field_179023_f = new TileEntitySkull();
    }
    
    public void renderByItem(final ItemStack lIIIlIIIllllIII) {
        if (lIIIlIIIllllIII.getItem() == Items.banner) {
            this.banner.setItemValues(lIIIlIIIllllIII);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.banner, 0.0, 0.0, 0.0, 0.0f);
        }
        else if (lIIIlIIIllllIII.getItem() == Items.skull) {
            GameProfile lIIIlIIIlllIlll = null;
            if (lIIIlIIIllllIII.hasTagCompound()) {
                final NBTTagCompound lIIIlIIIlllIllI = lIIIlIIIllllIII.getTagCompound();
                if (lIIIlIIIlllIllI.hasKey("SkullOwner", 10)) {
                    lIIIlIIIlllIlll = NBTUtil.readGameProfileFromNBT(lIIIlIIIlllIllI.getCompoundTag("SkullOwner"));
                }
                else if (lIIIlIIIlllIllI.hasKey("SkullOwner", 8) && lIIIlIIIlllIllI.getString("SkullOwner").length() > 0) {
                    lIIIlIIIlllIlll = new GameProfile((UUID)null, lIIIlIIIlllIllI.getString("SkullOwner"));
                    lIIIlIIIlllIlll = TileEntitySkull.updateGameprofile(lIIIlIIIlllIlll);
                    lIIIlIIIlllIllI.removeTag("SkullOwner");
                    lIIIlIIIlllIllI.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), lIIIlIIIlllIlll));
                }
            }
            if (TileEntitySkullRenderer.instance != null) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(-0.5f, 0.0f, -0.5f);
                GlStateManager.scale(2.0f, 2.0f, 2.0f);
                GlStateManager.disableCull();
                TileEntitySkullRenderer.instance.renderSkull(0.0f, 0.0f, 0.0f, EnumFacing.UP, 0.0f, lIIIlIIIllllIII.getMetadata(), lIIIlIIIlllIlll, -1);
                GlStateManager.enableCull();
                GlStateManager.popMatrix();
            }
        }
        else {
            final Block lIIIlIIIlllIlIl = Block.getBlockFromItem(lIIIlIIIllllIII.getItem());
            if (lIIIlIIIlllIlIl == Blocks.ender_chest) {
                TileEntityRendererDispatcher.instance.renderTileEntityAt(this.field_147716_d, 0.0, 0.0, 0.0, 0.0f);
            }
            else if (lIIIlIIIlllIlIl == Blocks.trapped_chest) {
                TileEntityRendererDispatcher.instance.renderTileEntityAt(this.field_147718_c, 0.0, 0.0, 0.0, 0.0f);
            }
            else {
                TileEntityRendererDispatcher.instance.renderTileEntityAt(this.field_147717_b, 0.0, 0.0, 0.0, 0.0f);
            }
        }
    }
}
