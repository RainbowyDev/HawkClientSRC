package net.minecraft.client.gui.spectator;

import com.mojang.authlib.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import net.minecraft.client.entity.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class PlayerMenuObject implements ISpectatorMenuObject
{
    private final /* synthetic */ GameProfile field_178668_a;
    private final /* synthetic */ ResourceLocation field_178667_b;
    
    @Override
    public void func_178663_a(final float llllllllllllllllIIIIlIllIIlIlIlI, final int llllllllllllllllIIIIlIllIIlIlIIl) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.field_178667_b);
        GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllllllIIIIlIllIIlIlIIl / 255.0f);
        Gui.drawScaledCustomSizeModalRect(2, 2, 8.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
        Gui.drawScaledCustomSizeModalRect(2, 2, 40.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
    }
    
    @Override
    public IChatComponent func_178664_z_() {
        return new ChatComponentText(this.field_178668_a.getName());
    }
    
    public PlayerMenuObject(final GameProfile llllllllllllllllIIIIlIllIIllIlll) {
        this.field_178668_a = llllllllllllllllIIIIlIllIIllIlll;
        this.field_178667_b = AbstractClientPlayer.getLocationSkin(llllllllllllllllIIIIlIllIIllIlll.getName());
        AbstractClientPlayer.getDownloadImageSkin(this.field_178667_b, llllllllllllllllIIIIlIllIIllIlll.getName());
    }
    
    @Override
    public boolean func_178662_A_() {
        return true;
    }
    
    static {
        __OBFID = "CL_00001929";
    }
    
    @Override
    public void func_178661_a(final SpectatorMenu llllllllllllllllIIIIlIllIIllIIlI) {
        Minecraft.getMinecraft().getNetHandler().addToSendQueue(new C18PacketSpectate(this.field_178668_a.getId()));
    }
}
