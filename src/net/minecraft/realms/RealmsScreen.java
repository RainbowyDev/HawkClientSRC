package net.minecraft.realms;

import net.minecraft.client.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.item.*;
import net.minecraft.client.entity.*;
import com.mojang.util.*;
import net.minecraft.client.resources.*;

public class RealmsScreen
{
    private /* synthetic */ GuiScreenRealmsProxy proxy;
    
    public static String getLocalizedString(final String lllllllllllllllIllllIIIlIIllIIII) {
        return I18n.format(lllllllllllllllIllllIIIlIIllIIII, new Object[0]);
    }
    
    public void buttonsAdd(final RealmsButton lllllllllllllllIllllIIIlIllIIIlI) {
        this.proxy.func_154327_a(lllllllllllllllIllllIIIlIllIIIlI);
    }
    
    public void fillGradient(final int lllllllllllllllIllllIIlIIIIIlIIl, final int lllllllllllllllIllllIIlIIIIIIIIl, final int lllllllllllllllIllllIIlIIIIIIlll, final int lllllllllllllllIllllIIlIIIIIIllI, final int lllllllllllllllIllllIIlIIIIIIlIl, final int lllllllllllllllIllllIIIlllllllIl) {
        this.proxy.drawGradientRect(lllllllllllllllIllllIIlIIIIIlIIl, lllllllllllllllIllllIIlIIIIIIIIl, lllllllllllllllIllllIIlIIIIIIlll, lllllllllllllllIllllIIlIIIIIIllI, lllllllllllllllIllllIIlIIIIIIlIl, lllllllllllllllIllllIIIlllllllIl);
    }
    
    public RealmsScreen() {
        this.proxy = new GuiScreenRealmsProxy(this);
    }
    
    public int width() {
        return this.proxy.width;
    }
    
    public void drawString(final String lllllllllllllllIllllIIlIIllIIIII, final int lllllllllllllllIllllIIlIIllIIlII, final int lllllllllllllllIllllIIlIIllIIIll, final int lllllllllllllllIllllIIlIIllIIIlI) {
        this.proxy.func_154322_b(lllllllllllllllIllllIIlIIllIIIII, lllllllllllllllIllllIIlIIllIIlII, lllllllllllllllIllllIIlIIllIIIll, lllllllllllllllIllllIIlIIllIIIlI);
    }
    
    public static RealmsButton newButton(final int lllllllllllllllIllllIIIllIIIIIlI, final int lllllllllllllllIllllIIIllIIIIIIl, final int lllllllllllllllIllllIIIllIIIIIII, final String lllllllllllllllIllllIIIlIlllllll) {
        return new RealmsButton(lllllllllllllllIllllIIIllIIIIIlI, lllllllllllllllIllllIIIllIIIIIIl, lllllllllllllllIllllIIIllIIIIIII, lllllllllllllllIllllIIIlIlllllll);
    }
    
    public RealmsEditBox newEditBox(final int lllllllllllllllIllllIIIlIlIIlIll, final int lllllllllllllllIllllIIIlIlIIlIlI, final int lllllllllllllllIllllIIIlIlIIlIIl, final int lllllllllllllllIllllIIIlIlIIllIl, final int lllllllllllllllIllllIIIlIlIIllII) {
        return new RealmsEditBox(lllllllllllllllIllllIIIlIlIIlIll, lllllllllllllllIllllIIIlIlIIlIlI, lllllllllllllllIllllIIIlIlIIlIIl, lllllllllllllllIllllIIIlIlIIllIl, lllllllllllllllIllllIIIlIlIIllII);
    }
    
    public static void bind(final String lllllllllllllllIllllIIIllIllIIlI) {
        final ResourceLocation lllllllllllllllIllllIIIllIllIIll = new ResourceLocation(lllllllllllllllIllllIIIllIllIIlI);
        Minecraft.getMinecraft().getTextureManager().bindTexture(lllllllllllllllIllllIIIllIllIIll);
    }
    
    public void mouseEvent() {
    }
    
    public void mouseDragged(final int lllllllllllllllIllllIIIlIIlllIll, final int lllllllllllllllIllllIIIlIIlllIlI, final int lllllllllllllllIllllIIIlIIlllIIl, final long lllllllllllllllIllllIIIlIIlllIII) {
    }
    
    public void drawCenteredString(final String lllllllllllllllIllllIIlIIlllIlII, final int lllllllllllllllIllllIIlIIlllIIll, final int lllllllllllllllIllllIIlIIllIllIl, final int lllllllllllllllIllllIIlIIllIllII) {
        this.proxy.func_154325_a(lllllllllllllllIllllIIlIIlllIlII, lllllllllllllllIllllIIlIIlllIIll, lllllllllllllllIllllIIlIIllIllIl, lllllllllllllllIllllIIlIIllIllII);
    }
    
    static {
        SKIN_HEAD_HEIGHT = 8;
        __OBFID = "CL_00001898";
        SKIN_HEAD_U = 8;
        SKIN_TEX_WIDTH = 64;
        SKIN_HEAD_V = 8;
        SKIN_HAT_V = 8;
        SKIN_TEX_HEIGHT = 64;
        SKIN_HAT_U = 40;
        SKIN_HAT_WIDTH = 8;
        SKIN_HEAD_WIDTH = 8;
        SKIN_HAT_HEIGHT = 8;
    }
    
    public void mouseClicked(final int lllllllllllllllIllllIIIlIlIIIlIl, final int lllllllllllllllIllllIIIlIlIIIlII, final int lllllllllllllllIllllIIIlIlIIIIll) {
    }
    
    public int height() {
        return this.proxy.height;
    }
    
    public void buttonsRemove(final RealmsButton lllllllllllllllIllllIIIlIlIlIlll) {
        this.proxy.func_154328_b(lllllllllllllllIllllIIIlIlIlIlll);
    }
    
    public void tick() {
    }
    
    public void renderTooltip(final List lllllllllllllllIllllIIIlllIIIllI, final int lllllllllllllllIllllIIIlllIIIlIl, final int lllllllllllllllIllllIIIlllIIIlII) {
        this.proxy.drawHoveringText(lllllllllllllllIllllIIIlllIIIllI, lllllllllllllllIllllIIIlllIIIlIl, lllllllllllllllIllllIIIlllIIIlII);
    }
    
    public boolean isPauseScreen() {
        return this.proxy.doesGuiPauseGame();
    }
    
    public void buttonsClear() {
        this.proxy.func_154324_i();
    }
    
    public void renderTooltip(final String lllllllllllllllIllllIIIlllIlIIlI, final int lllllllllllllllIllllIIIlllIlIIIl, final int lllllllllllllllIllllIIIlllIIllII) {
        this.proxy.drawCreativeTabHoveringText(lllllllllllllllIllllIIIlllIlIIlI, lllllllllllllllIllllIIIlllIlIIIl, lllllllllllllllIllllIIIlllIIllII);
    }
    
    public void confirmResult(final boolean lllllllllllllllIllllIIIlIIllIIll, final int lllllllllllllllIllllIIIlIIllIIlI) {
    }
    
    public void init() {
    }
    
    public void keyPressed(final char lllllllllllllllIllllIIIlIIllIllI, final int lllllllllllllllIllllIIIlIIllIlIl) {
    }
    
    public void mouseReleased(final int lllllllllllllllIllllIIIlIIllllll, final int lllllllllllllllIllllIIIlIIlllllI, final int lllllllllllllllIllllIIIlIIllllIl) {
    }
    
    public void removed() {
    }
    
    public static void blit(final int lllllllllllllllIllllIIlIIIllIIll, final int lllllllllllllllIllllIIlIIIllllII, final float lllllllllllllllIllllIIlIIIlllIll, final float lllllllllllllllIllllIIlIIIlllIlI, final int lllllllllllllllIllllIIlIIIlIllll, final int lllllllllllllllIllllIIlIIIlIlllI, final int lllllllllllllllIllllIIlIIIlIllIl, final int lllllllllllllllIllllIIlIIIlIllII, final float lllllllllllllllIllllIIlIIIlIlIll, final float lllllllllllllllIllllIIlIIIllIlII) {
        Gui.drawScaledCustomSizeModalRect(lllllllllllllllIllllIIlIIIllIIll, lllllllllllllllIllllIIlIIIllllII, lllllllllllllllIllllIIlIIIlllIll, lllllllllllllllIllllIIlIIIlllIlI, lllllllllllllllIllllIIlIIIlIllll, lllllllllllllllIllllIIlIIIlIlllI, lllllllllllllllIllllIIlIIIlIllIl, lllllllllllllllIllllIIlIIIlIllII, lllllllllllllllIllllIIlIIIlIlIll, lllllllllllllllIllllIIlIIIllIlII);
    }
    
    public GuiScreenRealmsProxy getProxy() {
        return this.proxy;
    }
    
    public void keyboardEvent() {
    }
    
    public int fontWidth(final String lllllllllllllllIllllIIIllIlIIIIl) {
        return this.proxy.func_154326_c(lllllllllllllllIllllIIIllIlIIIIl);
    }
    
    public int fontLineHeight() {
        return this.proxy.func_154329_h();
    }
    
    public void renderBackground() {
        this.proxy.drawDefaultBackground();
    }
    
    public void fontDrawShadow(final String lllllllllllllllIllllIIIllIIlIlIl, final int lllllllllllllllIllllIIIllIIllIIl, final int lllllllllllllllIllllIIIllIIllIII, final int lllllllllllllllIllllIIIllIIlIlll) {
        this.proxy.func_154319_c(lllllllllllllllIllllIIIllIIlIlIl, lllllllllllllllIllllIIIllIIllIIl, lllllllllllllllIllllIIIllIIllIII, lllllllllllllllIllllIIIllIIlIlll);
    }
    
    public void init(final Minecraft lllllllllllllllIllllIIlIIlllllIl, final int lllllllllllllllIllllIIlIIlllllII, final int lllllllllllllllIllllIIlIIllllIll) {
    }
    
    public static RealmsButton newButton(final int lllllllllllllllIllllIIIlIllIlllI, final int lllllllllllllllIllllIIIlIllIllIl, final int lllllllllllllllIllllIIIlIllIllII, final int lllllllllllllllIllllIIIlIllIlIll, final int lllllllllllllllIllllIIIlIlllIIII, final String lllllllllllllllIllllIIIlIllIllll) {
        return new RealmsButton(lllllllllllllllIllllIIIlIllIlllI, lllllllllllllllIllllIIIlIllIllIl, lllllllllllllllIllllIIIlIllIllII, lllllllllllllllIllllIIIlIllIlIll, lllllllllllllllIllllIIIlIlllIIII, lllllllllllllllIllllIIIlIllIllll);
    }
    
    public void renderBackground(final int lllllllllllllllIllllIIIlllllIIll) {
        this.proxy.drawWorldBackground(lllllllllllllllIllllIIIlllllIIll);
    }
    
    public List buttons() {
        return this.proxy.func_154320_j();
    }
    
    public static String getLocalizedString(final String lllllllllllllllIllllIIIlIIlIllII, final Object... lllllllllllllllIllllIIIlIIlIlIIl) {
        return I18n.format(lllllllllllllllIllllIIIlIIlIllII, lllllllllllllllIllllIIIlIIlIlIIl);
    }
    
    public void blit(final int lllllllllllllllIllllIIlIIlIlIlII, final int lllllllllllllllIllllIIlIIlIlIIll, final int lllllllllllllllIllllIIlIIlIlIIlI, final int lllllllllllllllIllllIIlIIlIIlIlI, final int lllllllllllllllIllllIIlIIlIlIIII, final int lllllllllllllllIllllIIlIIlIIlIII) {
        this.proxy.drawTexturedModalRect(lllllllllllllllIllllIIlIIlIlIlII, lllllllllllllllIllllIIlIIlIlIIll, lllllllllllllllIllllIIlIIlIlIIlI, lllllllllllllllIllllIIlIIlIIlIlI, lllllllllllllllIllllIIlIIlIlIIII, lllllllllllllllIllllIIlIIlIIlIII);
    }
    
    public void renderTooltip(final ItemStack lllllllllllllllIllllIIIlllIllllI, final int lllllllllllllllIllllIIIlllIlllIl, final int lllllllllllllllIllllIIIlllIllIII) {
        this.proxy.renderToolTip(lllllllllllllllIllllIIIlllIllllI, lllllllllllllllIllllIIIlllIlllIl, lllllllllllllllIllllIIIlllIllIII);
    }
    
    public static void blit(final int lllllllllllllllIllllIIlIIIIllIIl, final int lllllllllllllllIllllIIlIIIlIIIII, final float lllllllllllllllIllllIIlIIIIlllll, final float lllllllllllllllIllllIIlIIIIlIllI, final int lllllllllllllllIllllIIlIIIIlIlIl, final int lllllllllllllllIllllIIlIIIIlIlII, final float lllllllllllllllIllllIIlIIIIllIll, final float lllllllllllllllIllllIIlIIIIlIIlI) {
        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllllIllllIIlIIIIllIIl, lllllllllllllllIllllIIlIIIlIIIII, lllllllllllllllIllllIIlIIIIlllll, lllllllllllllllIllllIIlIIIIlIllI, lllllllllllllllIllllIIlIIIIlIlIl, lllllllllllllllIllllIIlIIIIlIlII, lllllllllllllllIllllIIlIIIIllIll, lllllllllllllllIllllIIlIIIIlIIlI);
    }
    
    public void buttonClicked(final RealmsButton lllllllllllllllIllllIIIllIIIIlll) {
    }
    
    public static void bindFace(final String lllllllllllllllIllllIIIllIlllIIl, final String lllllllllllllllIllllIIIllIlllIII) {
        ResourceLocation lllllllllllllllIllllIIIllIlllIlI = AbstractClientPlayer.getLocationSkin(lllllllllllllllIllllIIIllIlllIII);
        if (lllllllllllllllIllllIIIllIlllIlI == null) {
            lllllllllllllllIllllIIIllIlllIlI = DefaultPlayerSkin.func_177334_a(UUIDTypeAdapter.fromString(lllllllllllllllIllllIIIllIlllIIl));
        }
        AbstractClientPlayer.getDownloadImageSkin(lllllllllllllllIllllIIIllIlllIlI, lllllllllllllllIllllIIIllIlllIII);
        Minecraft.getMinecraft().getTextureManager().bindTexture(lllllllllllllllIllllIIIllIlllIlI);
    }
    
    public void render(final int lllllllllllllllIllllIIIllllIIllI, final int lllllllllllllllIllllIIIllllIIlIl, final float lllllllllllllllIllllIIIllllIlIIl) {
        for (int lllllllllllllllIllllIIIllllIlIII = 0; lllllllllllllllIllllIIIllllIlIII < this.proxy.func_154320_j().size(); ++lllllllllllllllIllllIIIllllIlIII) {
            this.proxy.func_154320_j().get(lllllllllllllllIllllIIIllllIlIII).render(lllllllllllllllIllllIIIllllIIllI, lllllllllllllllIllllIIIllllIIlIl);
        }
    }
    
    public List fontSplit(final String lllllllllllllllIllllIIIllIIIllIl, final int lllllllllllllllIllllIIIllIIIllII) {
        return this.proxy.func_154323_a(lllllllllllllllIllllIIIllIIIllIl, lllllllllllllllIllllIIIllIIIllII);
    }
    
    public RealmsAnvilLevelStorageSource getLevelStorageSource() {
        return new RealmsAnvilLevelStorageSource(Minecraft.getMinecraft().getSaveLoader());
    }
}
