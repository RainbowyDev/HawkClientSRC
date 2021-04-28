package net.minecraft.client.gui;

import java.io.*;
import com.google.common.collect.*;
import net.minecraft.realms.*;
import net.minecraft.item.*;
import java.util.*;

public class GuiScreenRealmsProxy extends GuiScreen
{
    private /* synthetic */ RealmsScreen field_154330_a;
    
    public RealmsScreen func_154321_a() {
        return this.field_154330_a;
    }
    
    public void mouseClicked(final int llllllllllllllIlllIIIIIIlIIIlIlI, final int llllllllllllllIlllIIIIIIlIIIlIIl, final int llllllllllllllIlllIIIIIIlIIIlIII) throws IOException {
        this.field_154330_a.mouseClicked(llllllllllllllIlllIIIIIIlIIIlIlI, llllllllllllllIlllIIIIIIlIIIlIIl, llllllllllllllIlllIIIIIIlIIIlIII);
        super.mouseClicked(llllllllllllllIlllIIIIIIlIIIlIlI, llllllllllllllIlllIIIIIIlIIIlIIl, llllllllllllllIlllIIIIIIlIIIlIII);
    }
    
    public void keyTyped(final char llllllllllllllIlllIIIIIIIllIIIlI, final int llllllllllllllIlllIIIIIIIlIllllI) throws IOException {
        this.field_154330_a.keyPressed(llllllllllllllIlllIIIIIIIllIIIlI, llllllllllllllIlllIIIIIIIlIllllI);
    }
    
    public void mouseClickMove(final int llllllllllllllIlllIIIIIIIllIllll, final int llllllllllllllIlllIIIIIIIllIlIIl, final int llllllllllllllIlllIIIIIIIllIllIl, final long llllllllllllllIlllIIIIIIIllIllII) {
        this.field_154330_a.mouseDragged(llllllllllllllIlllIIIIIIIllIllll, llllllllllllllIlllIIIIIIIllIlIIl, llllllllllllllIlllIIIIIIIllIllIl, llllllllllllllIlllIIIIIIIllIllII);
    }
    
    public void func_154324_i() {
        super.buttonList.clear();
    }
    
    @Override
    public void handleKeyboardInput() throws IOException {
        this.field_154330_a.keyboardEvent();
        super.handleKeyboardInput();
    }
    
    public List func_154320_j() {
        final ArrayList llllllllllllllIlllIIIIIIlIlIIIII = Lists.newArrayListWithExpectedSize(super.buttonList.size());
        for (final GuiButton llllllllllllllIlllIIIIIIlIIllllI : super.buttonList) {
            llllllllllllllIlllIIIIIIlIlIIIII.add(((GuiButtonRealmsProxy)llllllllllllllIlllIIIIIIlIIllllI).getRealmsButton());
        }
        return llllllllllllllIlllIIIIIIlIlIIIII;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        this.field_154330_a.mouseEvent();
        super.handleMouseInput();
    }
    
    public void drawCreativeTabHoveringText(final String llllllllllllllIlllIIIIIIlllIlIll, final int llllllllllllllIlllIIIIIIlllIIllI, final int llllllllllllllIlllIIIIIIlllIlIIl) {
        super.drawCreativeTabHoveringText(llllllllllllllIlllIIIIIIlllIlIll, llllllllllllllIlllIIIIIIlllIIllI, llllllllllllllIlllIIIIIIlllIlIIl);
    }
    
    public final void actionPerformed(final GuiButton llllllllllllllIlllIIIIIIlIllIIIl) throws IOException {
        this.field_154330_a.buttonClicked(((GuiButtonRealmsProxy)llllllllllllllIlllIIIIIIlIllIIIl).getRealmsButton());
    }
    
    @Override
    public void updateScreen() {
        this.field_154330_a.tick();
        super.updateScreen();
    }
    
    public void func_154327_a(final RealmsButton llllllllllllllIlllIIIIIIlIlIlIII) {
        super.buttonList.add(llllllllllllllIlllIIIIIIlIlIlIII.getProxy());
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllIlllIIIIIIIlIlIllI, final int llllllllllllllIlllIIIIIIIlIlIlIl) {
        this.field_154330_a.confirmResult(llllllllllllllIlllIIIIIIIlIlIllI, llllllllllllllIlllIIIIIIIlIlIlIl);
    }
    
    static {
        __OBFID = "CL_00001847";
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return super.doesGuiPauseGame();
    }
    
    @Override
    public void drawWorldBackground(final int llllllllllllllIlllIIIIIlIIIIlIll) {
        super.drawWorldBackground(llllllllllllllIlllIIIIIlIIIIlIll);
    }
    
    @Override
    public void drawTexturedModalRect(final int llllllllllllllIlllIIIIIlIIlIllll, final int llllllllllllllIlllIIIIIlIIllIlIl, final int llllllllllllllIlllIIIIIlIIlIllIl, final int llllllllllllllIlllIIIIIlIIllIIll, final int llllllllllllllIlllIIIIIlIIlIlIll, final int llllllllllllllIlllIIIIIlIIlIlIlI) {
        this.field_154330_a.blit(llllllllllllllIlllIIIIIlIIlIllll, llllllllllllllIlllIIIIIlIIllIlIl, llllllllllllllIlllIIIIIlIIlIllIl, llllllllllllllIlllIIIIIlIIllIIll, llllllllllllllIlllIIIIIlIIlIlIll, llllllllllllllIlllIIIIIlIIlIlIlI);
        super.drawTexturedModalRect(llllllllllllllIlllIIIIIlIIlIllll, llllllllllllllIlllIIIIIlIIllIlIl, llllllllllllllIlllIIIIIlIIlIllIl, llllllllllllllIlllIIIIIlIIllIIll, llllllllllllllIlllIIIIIlIIlIlIll, llllllllllllllIlllIIIIIlIIlIlIlI);
    }
    
    public void func_154325_a(final String llllllllllllllIlllIIIIIlIllIIlII, final int llllllllllllllIlllIIIIIlIlIlllIl, final int llllllllllllllIlllIIIIIlIllIIIIl, final int llllllllllllllIlllIIIIIlIllIIIII) {
        super.drawCenteredString(this.fontRendererObj, llllllllllllllIlllIIIIIlIllIIlII, llllllllllllllIlllIIIIIlIlIlllIl, llllllllllllllIlllIIIIIlIllIIIIl, llllllllllllllIlllIIIIIlIllIIIII);
    }
    
    @Override
    public void drawDefaultBackground() {
        super.drawDefaultBackground();
    }
    
    public void func_154319_c(final String llllllllllllllIlllIIIIIIllIIIIIl, final int llllllllllllllIlllIIIIIIllIIIIII, final int llllllllllllllIlllIIIIIIllIIIlII, final int llllllllllllllIlllIIIIIIllIIIIll) {
        this.fontRendererObj.drawStringWithShadow(llllllllllllllIlllIIIIIIllIIIIIl, (float)llllllllllllllIlllIIIIIIllIIIIII, (float)llllllllllllllIlllIIIIIIllIIIlII, llllllllllllllIlllIIIIIIllIIIIll);
    }
    
    public List func_154323_a(final String llllllllllllllIlllIIIIIIlIllIllI, final int llllllllllllllIlllIIIIIIlIlllIII) {
        return this.fontRendererObj.listFormattedStringToWidth(llllllllllllllIlllIIIIIIlIllIllI, llllllllllllllIlllIIIIIIlIlllIII);
    }
    
    public void mouseReleased(final int llllllllllllllIlllIIIIIIIllllIII, final int llllllllllllllIlllIIIIIIIllllIll, final int llllllllllllllIlllIIIIIIIlllIllI) {
        this.field_154330_a.mouseReleased(llllllllllllllIlllIIIIIIIllllIII, llllllllllllllIlllIIIIIIIllllIll, llllllllllllllIlllIIIIIIIlllIllI);
    }
    
    @Override
    public void onGuiClosed() {
        this.field_154330_a.removed();
        super.onGuiClosed();
    }
    
    public void renderToolTip(final ItemStack llllllllllllllIlllIIIIIIllllIIll, final int llllllllllllllIlllIIIIIIllllIIlI, final int llllllllllllllIlllIIIIIIllllIIIl) {
        super.renderToolTip(llllllllllllllIlllIIIIIIllllIIll, llllllllllllllIlllIIIIIIllllIIlI, llllllllllllllIlllIIIIIIllllIIIl);
    }
    
    public int func_154329_h() {
        return this.fontRendererObj.FONT_HEIGHT;
    }
    
    public void drawHoveringText(final List llllllllllllllIlllIIIIIIllIlllll, final int llllllllllllllIlllIIIIIIllIllIlI, final int llllllllllllllIlllIIIIIIllIllIIl) {
        super.drawHoveringText(llllllllllllllIlllIIIIIIllIlllll, llllllllllllllIlllIIIIIIllIllIlI, llllllllllllllIlllIIIIIIllIllIIl);
    }
    
    public GuiScreenRealmsProxy(final RealmsScreen llllllllllllllIlllIIIIIllIIIIIlI) {
        this.field_154330_a = llllllllllllllIlllIIIIIllIIIIIlI;
        super.buttonList = Collections.synchronizedList((List<Object>)Lists.newArrayList());
    }
    
    public int func_154326_c(final String llllllllllllllIlllIIIIIIllIIllll) {
        return this.fontRendererObj.getStringWidth(llllllllllllllIlllIIIIIIllIIllll);
    }
    
    @Override
    public void initGui() {
        this.field_154330_a.init();
        super.initGui();
    }
    
    public void drawGradientRect(final int llllllllllllllIlllIIIIIlIIlIIIIl, final int llllllllllllllIlllIIIIIlIIlIIIII, final int llllllllllllllIlllIIIIIlIIIlllll, final int llllllllllllllIlllIIIIIlIIIllllI, final int llllllllllllllIlllIIIIIlIIIlIllI, final int llllllllllllllIlllIIIIIlIIIlIlIl) {
        super.drawGradientRect(llllllllllllllIlllIIIIIlIIlIIIIl, llllllllllllllIlllIIIIIlIIlIIIII, llllllllllllllIlllIIIIIlIIIlllll, llllllllllllllIlllIIIIIlIIIllllI, llllllllllllllIlllIIIIIlIIIlIllI, llllllllllllllIlllIIIIIlIIIlIlIl);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlllIIIIIlIIIIIIll, final int llllllllllllllIlllIIIIIlIIIIIIlI, final float llllllllllllllIlllIIIIIlIIIIIIIl) {
        this.field_154330_a.render(llllllllllllllIlllIIIIIlIIIIIIll, llllllllllllllIlllIIIIIlIIIIIIlI, llllllllllllllIlllIIIIIlIIIIIIIl);
    }
    
    public void func_154328_b(final RealmsButton llllllllllllllIlllIIIIIIlIIlIllI) {
        super.buttonList.remove(llllllllllllllIlllIIIIIIlIIlIllI);
    }
    
    public void func_154322_b(final String llllllllllllllIlllIIIIIlIlIIIIlI, final int llllllllllllllIlllIIIIIlIlIIIIIl, final int llllllllllllllIlllIIIIIlIlIIIlIl, final int llllllllllllllIlllIIIIIlIIllllll) {
        super.drawString(this.fontRendererObj, llllllllllllllIlllIIIIIlIlIIIIlI, llllllllllllllIlllIIIIIlIlIIIIIl, llllllllllllllIlllIIIIIlIlIIIlIl, llllllllllllllIlllIIIIIlIIllllll);
    }
}
