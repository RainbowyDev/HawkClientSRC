package net.minecraft.client.entity;

import net.minecraft.entity.player.*;
import net.minecraft.client.network.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import java.io.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.world.*;
import com.mojang.authlib.*;
import optifine.*;

public abstract class AbstractClientPlayer extends EntityPlayer
{
    private /* synthetic */ ResourceLocation locationOfCape;
    private /* synthetic */ NetworkPlayerInfo field_175157_a;
    private /* synthetic */ String nameClear;
    
    protected NetworkPlayerInfo func_175155_b() {
        if (this.field_175157_a == null) {
            this.field_175157_a = Minecraft.getMinecraft().getNetHandler().func_175102_a(this.getUniqueID());
        }
        return this.field_175157_a;
    }
    
    @Override
    public boolean func_175149_v() {
        final NetworkPlayerInfo llllllllllllllIlIIlIIlIlIIlIlIll = Minecraft.getMinecraft().getNetHandler().func_175102_a(this.getGameProfile().getId());
        return llllllllllllllIlIIlIIlIlIIlIlIll != null && llllllllllllllIlIIlIIlIlIIlIlIll.getGameType() == WorldSettings.GameType.SPECTATOR;
    }
    
    public static ThreadDownloadImageData getDownloadImageSkin(final ResourceLocation llllllllllllllIlIIlIIlIlIIIIlIII, final String llllllllllllllIlIIlIIlIlIIIIlIll) {
        final TextureManager llllllllllllllIlIIlIIlIlIIIIlIlI = Minecraft.getMinecraft().getTextureManager();
        Object llllllllllllllIlIIlIIlIlIIIIlIIl = llllllllllllllIlIIlIIlIlIIIIlIlI.getTexture(llllllllllllllIlIIlIIlIlIIIIlIII);
        if (llllllllllllllIlIIlIIlIlIIIIlIIl == null) {
            llllllllllllllIlIIlIIlIlIIIIlIIl = new ThreadDownloadImageData(null, String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", StringUtils.stripControlCodes(llllllllllllllIlIIlIIlIlIIIIlIll)), DefaultPlayerSkin.func_177334_a(EntityPlayer.func_175147_b(llllllllllllllIlIIlIIlIlIIIIlIll)), new ImageBufferDownload());
            llllllllllllllIlIIlIIlIlIIIIlIlI.loadTexture(llllllllllllllIlIIlIIlIlIIIIlIII, (ITextureObject)llllllllllllllIlIIlIIlIlIIIIlIIl);
        }
        return (ThreadDownloadImageData)llllllllllllllIlIIlIIlIlIIIIlIIl;
    }
    
    public String getNameClear() {
        return this.nameClear;
    }
    
    public float func_175156_o() {
        float llllllllllllllIlIIlIIlIIllllIlIl = 1.0f;
        if (this.capabilities.isFlying) {
            llllllllllllllIlIIlIIlIIllllIlIl *= 1.1f;
        }
        final IAttributeInstance llllllllllllllIlIIlIIlIIllllIlII = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
        llllllllllllllIlIIlIIlIIllllIlIl *= (float)((llllllllllllllIlIIlIIlIIllllIlII.getAttributeValue() / this.capabilities.getWalkSpeed() + 1.0) / 2.0);
        if (this.capabilities.getWalkSpeed() == 0.0f || Float.isNaN(llllllllllllllIlIIlIIlIIllllIlIl) || Float.isInfinite(llllllllllllllIlIIlIIlIIllllIlIl)) {
            llllllllllllllIlIIlIIlIIllllIlIl = 1.0f;
        }
        if (this.isUsingItem() && this.getItemInUse().getItem() == Items.bow) {
            final int llllllllllllllIlIIlIIlIIllllIIll = this.getItemInUseDuration();
            float llllllllllllllIlIIlIIlIIllllIIlI = llllllllllllllIlIIlIIlIIllllIIll / 20.0f;
            if (llllllllllllllIlIIlIIlIIllllIIlI > 1.0f) {
                llllllllllllllIlIIlIIlIIllllIIlI = 1.0f;
            }
            else {
                llllllllllllllIlIIlIIlIIllllIIlI *= llllllllllllllIlIIlIIlIIllllIIlI;
            }
            llllllllllllllIlIIlIIlIIllllIlIl *= 1.0f - llllllllllllllIlIIlIIlIIllllIIlI * 0.15f;
        }
        return Reflector.ForgeHooksClient_getOffsetFOV.exists() ? Reflector.callFloat(Reflector.ForgeHooksClient_getOffsetFOV, this, llllllllllllllIlIIlIIlIIllllIlIl) : llllllllllllllIlIIlIIlIIllllIlIl;
    }
    
    public void setLocationOfCape(final ResourceLocation llllllllllllllIlIIlIIlIIlllIIIll) {
        this.locationOfCape = llllllllllllllIlIIlIIlIIlllIIIll;
    }
    
    public static ResourceLocation getLocationSkin(final String llllllllllllllIlIIlIIlIlIIIIIIlI) {
        return new ResourceLocation(String.valueOf(new StringBuilder("skins/").append(StringUtils.stripControlCodes(llllllllllllllIlIIlIIlIlIIIIIIlI))));
    }
    
    public boolean hasCape() {
        return this.func_175155_b() != null;
    }
    
    public ResourceLocation getLocationCape() {
        if (!Config.isShowCapes()) {
            return null;
        }
        if (this.locationOfCape != null) {
            return this.locationOfCape;
        }
        final NetworkPlayerInfo llllllllllllllIlIIlIIlIlIIIlIIll = this.func_175155_b();
        return (llllllllllllllIlIIlIIlIlIIIlIIll == null) ? null : llllllllllllllIlIIlIIlIlIIIlIIll.func_178861_h();
    }
    
    public boolean hasSkin() {
        final NetworkPlayerInfo llllllllllllllIlIIlIIlIlIIIlllll = this.func_175155_b();
        return llllllllllllllIlIIlIIlIlIIIlllll != null && llllllllllllllIlIIlIIlIlIIIlllll.func_178856_e();
    }
    
    public ResourceLocation getLocationSkin() {
        final NetworkPlayerInfo llllllllllllllIlIIlIIlIlIIIllIIl = this.func_175155_b();
        return (llllllllllllllIlIIlIIlIlIIIllIIl == null) ? DefaultPlayerSkin.func_177334_a(this.getUniqueID()) : llllllllllllllIlIIlIIlIlIIIllIIl.func_178837_g();
    }
    
    static {
        __OBFID = "CL_00000935";
    }
    
    public AbstractClientPlayer(final World llllllllllllllIlIIlIIlIlIIllIIII, final GameProfile llllllllllllllIlIIlIIlIlIIlIllll) {
        super(llllllllllllllIlIIlIIlIlIIllIIII, llllllllllllllIlIIlIIlIlIIlIllll);
        this.locationOfCape = null;
        this.nameClear = null;
        this.nameClear = llllllllllllllIlIIlIIlIlIIlIllll.getName();
        if (this.nameClear != null && !this.nameClear.isEmpty()) {
            this.nameClear = StringUtils.stripControlCodes(this.nameClear);
        }
        CapeUtils.downloadCape(this);
        PlayerConfigurations.getPlayerConfiguration(this);
    }
    
    public ResourceLocation getLocationOfCape() {
        return this.locationOfCape;
    }
    
    public String func_175154_l() {
        final NetworkPlayerInfo llllllllllllllIlIIlIIlIIlllllllI = this.func_175155_b();
        return (llllllllllllllIlIIlIIlIIlllllllI == null) ? DefaultPlayerSkin.func_177332_b(this.getUniqueID()) : llllllllllllllIlIIlIIlIIlllllllI.func_178851_f();
    }
}
