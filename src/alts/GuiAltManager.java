package alts;

import com.thealtening.auth.*;
import net.minecraft.util.*;
import java.io.*;
import com.thealtening.auth.service.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;

public class GuiAltManager extends GuiScreen
{
    private /* synthetic */ int offset;
    private /* synthetic */ AltLoginThread loginThread;
    public /* synthetic */ Alt selectedAlt;
    private /* synthetic */ String status;
    private /* synthetic */ GuiButton rename;
    private /* synthetic */ GuiButton remove;
    private /* synthetic */ TheAlteningAuthentication serviceSwitcher;
    private /* synthetic */ GuiButton login;
    
    private boolean isAltInArea(final int llllllllllllllllIIIIIlIIllIIlIlI) {
        return llllllllllllllllIIIIIlIIllIIlIlI - this.offset <= this.height - 50;
    }
    
    public GuiAltManager() {
        this.selectedAlt = null;
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("No alts selected"));
        this.serviceSwitcher = TheAlteningAuthentication.mojang();
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllllIIIIIlIIlIlIlllI, final int llllllllllllllllIIIIIlIIlIlIllIl, final int llllllllllllllllIIIIIlIIlIlIllII) throws IOException {
        if (this.offset < 0) {
            this.offset = 0;
        }
        int llllllllllllllllIIIIIlIIlIllIIlI = 38 - this.offset;
        for (final Alt llllllllllllllllIIIIIlIIlIllIIIl : AltManager.registry) {
            if (this.isMouseOverAlt(llllllllllllllllIIIIIlIIlIlIlllI, llllllllllllllllIIIIIlIIlIlIllIl, llllllllllllllllIIIIIlIIlIllIIlI)) {
                if (llllllllllllllllIIIIIlIIlIllIIIl == this.selectedAlt) {
                    this.actionPerformed(this.buttonList.get(1));
                    return;
                }
                this.selectedAlt = llllllllllllllllIIIIIlIIlIllIIIl;
            }
            llllllllllllllllIIIIIlIIlIllIIlI += 26;
        }
        try {
            super.mouseClicked(llllllllllllllllIIIIIlIIlIlIlllI, llllllllllllllllIIIIIlIIlIlIllIl, llllllllllllllllIIIIIlIIlIlIllII);
        }
        catch (IOException llllllllllllllllIIIIIlIIlIllIIII) {
            llllllllllllllllIIIIIlIIlIllIIII.printStackTrace();
        }
    }
    
    public void actionPerformed(final GuiButton llllllllllllllllIIIIIlIIllllIllI) throws IOException {
        switch (llllllllllllllllIIIIIlIIllllIllI.id) {
            case 0: {
                if (this.loginThread == null) {
                    this.mc.displayGuiScreen(null);
                    break;
                }
                if (!this.loginThread.getStatus().equals(String.valueOf(new StringBuilder().append(EnumChatFormatting.YELLOW).append("Attempting to log in"))) && !this.loginThread.getStatus().equals(String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Do not hit back!").append(EnumChatFormatting.YELLOW).append(" Logging in...")))) {
                    this.mc.displayGuiScreen(null);
                    break;
                }
                this.loginThread.setStatus(String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Failed to login! Please try again!").append(EnumChatFormatting.YELLOW).append(" Logging in...")));
                break;
            }
            case 1: {
                final String llllllllllllllllIIIIIlIIlllllIIl = this.selectedAlt.getUsername();
                final String llllllllllllllllIIIIIlIIlllllIII = this.selectedAlt.getPassword();
                this.loginThread = new AltLoginThread(llllllllllllllllIIIIIlIIlllllIIl, llllllllllllllllIIIIIlIIlllllIII);
                this.loginThread.start();
                break;
            }
            case 2: {
                if (this.loginThread != null) {
                    this.loginThread = null;
                }
                AltManager.registry.remove(this.selectedAlt);
                this.status = "§aRemoved.";
                this.selectedAlt = null;
                break;
            }
            case 3: {
                this.mc.displayGuiScreen(new GuiAddAlt(this));
                break;
            }
            case 4: {
                this.mc.displayGuiScreen(new GuiAltLogin(this));
                break;
            }
            case 6: {
                this.mc.displayGuiScreen(new GuiRenameAlt(this));
                break;
            }
            case 7: {
                this.serviceSwitcher.updateService(AlteningServiceType.MOJANG);
                break;
            }
            case 8: {
                this.serviceSwitcher.updateService(AlteningServiceType.THEALTENING);
                break;
            }
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIIIIIlIIllIlllII, final int llllllllllllllllIIIIIlIIlllIIllI, final float llllllllllllllllIIIIIlIIllIllIlI) {
        if (Mouse.hasWheel()) {
            final int llllllllllllllllIIIIIlIIlllIIlII = Mouse.getDWheel();
            if (llllllllllllllllIIIIIlIIlllIIlII < 0) {
                this.offset += 26;
                if (this.offset < 0) {
                    this.offset = 0;
                }
            }
            else if (llllllllllllllllIIIIIlIIlllIIlII > 0) {
                this.offset -= 26;
                if (this.offset < 0) {
                    this.offset = 0;
                }
            }
        }
        this.drawDefaultBackground();
        this.drawString(this.fontRendererObj, this.mc.session.getUsername(), 10, 10, -7829368);
        final FontRenderer llllllllllllllllIIIIIlIIlllIIIll = this.fontRendererObj;
        final StringBuilder llllllllllllllllIIIIIlIIlllIIIlI = new StringBuilder("Account Manager - ");
        this.drawCenteredString(llllllllllllllllIIIIIlIIlllIIIll, String.valueOf(llllllllllllllllIIIIIlIIlllIIIlI.append(AltManager.registry.size()).append(" alts")), this.width / 2, 10, -1);
        this.drawCenteredString(this.fontRendererObj, (this.loginThread == null) ? this.status : this.loginThread.getStatus(), this.width / 2, 20, -1);
        Gui.drawRect(50.0, 33.0, this.width - 50, this.height - 50, -16777216);
        GL11.glPushMatrix();
        this.prepareScissorBox(0.0f, 33.0f, (float)this.width, (float)(this.height - 50));
        GL11.glEnable(3089);
        int llllllllllllllllIIIIIlIIlllIIIIl = 38;
        for (final Alt llllllllllllllllIIIIIlIIlllIIIII : AltManager.registry) {
            if (!this.isAltInArea(llllllllllllllllIIIIIlIIlllIIIIl)) {
                continue;
            }
            final String llllllllllllllllIIIIIlIIllIlllll = llllllllllllllllIIIIIlIIlllIIIII.getMask().equals("") ? llllllllllllllllIIIIIlIIlllIIIII.getUsername() : llllllllllllllllIIIIIlIIlllIIIII.getMask();
            final String llllllllllllllllIIIIIlIIllIllllI = llllllllllllllllIIIIIlIIlllIIIII.getPassword().equals("") ? "§cCracked" : llllllllllllllllIIIIIlIIlllIIIII.getPassword().replaceAll(".", "*");
            if (llllllllllllllllIIIIIlIIlllIIIII == this.selectedAlt) {
                if (this.isMouseOverAlt(llllllllllllllllIIIIIlIIllIlllII, llllllllllllllllIIIIIlIIlllIIllI, llllllllllllllllIIIIIlIIlllIIIIl - this.offset) && Mouse.isButtonDown(0)) {
                    Gui.drawRect(52.0, llllllllllllllllIIIIIlIIlllIIIIl - this.offset - 4, this.width - 52, llllllllllllllllIIIIIlIIlllIIIIl - this.offset + 20, -2142943931);
                }
                else if (this.isMouseOverAlt(llllllllllllllllIIIIIlIIllIlllII, llllllllllllllllIIIIIlIIlllIIllI, llllllllllllllllIIIIIlIIlllIIIIl - this.offset)) {
                    Gui.drawRect(52.0, llllllllllllllllIIIIIlIIlllIIIIl - this.offset - 4, this.width - 52, llllllllllllllllIIIIIlIIlllIIIIl - this.offset + 20, -2142088622);
                }
                else {
                    Gui.drawRect(52.0, llllllllllllllllIIIIIlIIlllIIIIl - this.offset - 4, this.width - 52, llllllllllllllllIIIIIlIIlllIIIIl - this.offset + 20, -2144259791);
                }
            }
            else if (this.isMouseOverAlt(llllllllllllllllIIIIIlIIllIlllII, llllllllllllllllIIIIIlIIlllIIllI, llllllllllllllllIIIIIlIIlllIIIIl - this.offset) && Mouse.isButtonDown(0)) {
                Gui.drawRect(52.0, llllllllllllllllIIIIIlIIlllIIIIl - this.offset - 4, this.width - 52, llllllllllllllllIIIIIlIIlllIIIIl - this.offset + 20, -16777216);
            }
            else if (this.isMouseOverAlt(llllllllllllllllIIIIIlIIllIlllII, llllllllllllllllIIIIIlIIlllIIllI, llllllllllllllllIIIIIlIIlllIIIIl - this.offset)) {
                Gui.drawRect(52.0, llllllllllllllllIIIIIlIIlllIIIIl - this.offset - 4, this.width - 52, llllllllllllllllIIIIIlIIlllIIIIl - this.offset + 20, -16777216);
            }
            this.drawCenteredString(this.fontRendererObj, llllllllllllllllIIIIIlIIllIlllll, this.width / 2, llllllllllllllllIIIIIlIIlllIIIIl - this.offset, -1);
            this.drawCenteredString(this.fontRendererObj, llllllllllllllllIIIIIlIIllIllllI, this.width / 2, llllllllllllllllIIIIIlIIlllIIIIl - this.offset + 10, 5592405);
            llllllllllllllllIIIIIlIIlllIIIIl += 26;
        }
        GL11.glDisable(3089);
        GL11.glPopMatrix();
        super.drawScreen(llllllllllllllllIIIIIlIIllIlllII, llllllllllllllllIIIIIlIIlllIIllI, llllllllllllllllIIIIIlIIllIllIlI);
        if (this.selectedAlt == null) {
            this.login.enabled = false;
            this.remove.enabled = false;
            this.rename.enabled = false;
        }
        else {
            this.login.enabled = true;
            this.remove.enabled = true;
            this.rename.enabled = true;
        }
        if (Keyboard.isKeyDown(200)) {
            this.offset -= 26;
            if (this.offset < 0) {
                this.offset = 0;
            }
        }
        else if (Keyboard.isKeyDown(208)) {
            this.offset += 26;
            if (this.offset < 0) {
                this.offset = 0;
            }
        }
    }
    
    public void prepareScissorBox(final float llllllllllllllllIIIIIlIIlIIllIIl, final float llllllllllllllllIIIIIlIIlIIllIII, final float llllllllllllllllIIIIIlIIlIIlIlll, final float llllllllllllllllIIIIIlIIlIIlIllI) {
        final ScaledResolution llllllllllllllllIIIIIlIIlIIlllII = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int llllllllllllllllIIIIIlIIlIIllIll = llllllllllllllllIIIIIlIIlIIlllII.getScaleFactor();
        GL11.glScissor((int)(llllllllllllllllIIIIIlIIlIIllIIl * llllllllllllllllIIIIIlIIlIIllIll), (int)((llllllllllllllllIIIIIlIIlIIlllII.getScaledHeight() - llllllllllllllllIIIIIlIIlIIlIllI) * llllllllllllllllIIIIIlIIlIIllIll), (int)((llllllllllllllllIIIIIlIIlIIlIlll - llllllllllllllllIIIIIlIIlIIllIIl) * llllllllllllllllIIIIIlIIlIIllIll), (int)((llllllllllllllllIIIIIlIIlIIlIllI - llllllllllllllllIIIIIlIIlIIllIII) * llllllllllllllllIIIIIlIIlIIllIll));
    }
    
    private boolean isMouseOverAlt(final int llllllllllllllllIIIIIlIIllIIIIII, final int llllllllllllllllIIIIIlIIllIIIIll, final int llllllllllllllllIIIIIlIIllIIIIlI) {
        return llllllllllllllllIIIIIlIIllIIIIII >= 52 && llllllllllllllllIIIIIlIIllIIIIll >= llllllllllllllllIIIIIlIIllIIIIlI - 4 && llllllllllllllllIIIIIlIIllIIIIII <= this.width - 52 && llllllllllllllllIIIIIlIIllIIIIll <= llllllllllllllllIIIIIlIIllIIIIlI + 20 && llllllllllllllllIIIIIlIIllIIIIII >= 0 && llllllllllllllllIIIIIlIIllIIIIll >= 33 && llllllllllllllllIIIIIlIIllIIIIII <= this.width && llllllllllllllllIIIIIlIIllIIIIll <= this.height - 50;
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 + 4 + 50, this.height - 24, 100, 20, "Cancel"));
        this.login = new GuiButton(1, this.width / 2 - 154, this.height - 48, 100, 20, "Login");
        this.buttonList.add(this.login);
        this.remove = new GuiButton(2, this.width / 2 - 154, this.height - 24, 100, 20, "Remove");
        this.buttonList.add(this.remove);
        this.buttonList.add(new GuiButton(3, this.width / 2 + 4 + 50, this.height - 48, 100, 20, "Add"));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 50, this.height - 48, 100, 20, "Direct Login"));
        this.rename = new GuiButton(6, this.width / 2 - 50, this.height - 24, 100, 20, "Edit");
        this.buttonList.add(this.rename);
        this.buttonList.add(new GuiButton(7, this.width - 100, 0, 100, 20, "Use Mojang"));
        this.buttonList.add(new GuiButton(8, this.width - 200, 0, 100, 20, "Use TheAltening"));
        this.login.enabled = false;
        this.remove.enabled = false;
        this.rename.enabled = false;
    }
}
