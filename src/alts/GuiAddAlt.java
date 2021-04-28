package alts;

import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import java.io.*;
import net.minecraft.util.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import com.mojang.authlib.exceptions.*;

public class GuiAddAlt extends GuiScreen
{
    private /* synthetic */ PasswordField password;
    private /* synthetic */ GuiTextField username;
    private final /* synthetic */ GuiAltManager manager;
    private /* synthetic */ String status;
    
    static void access$0(final GuiAddAlt lIIlIIIlllIlIII, final String lIIlIIIlllIIlll) {
        lIIlIIIlllIlIII.status = lIIlIIIlllIIlll;
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 92 + 12, "Login"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 116 + 12, "Back"));
        this.username = new GuiTextField(this.eventButton, this.mc.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.password = new PasswordField(this.mc.fontRendererObj, this.width / 2 - 100, 100, 200, 20);
    }
    
    @Override
    protected void mouseClicked(final int lIIlIIIlllIlllI, final int lIIlIIIlllIllIl, final int lIIlIIIlllIllII) {
        try {
            super.mouseClicked(lIIlIIIlllIlllI, lIIlIIIlllIllIl, lIIlIIIlllIllII);
        }
        catch (IOException lIIlIIIllllIIII) {
            lIIlIIIllllIIII.printStackTrace();
        }
        this.username.mouseClicked(lIIlIIIlllIlllI, lIIlIIIlllIllIl, lIIlIIIlllIllII);
        this.password.mouseClicked(lIIlIIIlllIlllI, lIIlIIIlllIllIl, lIIlIIIlllIllII);
    }
    
    public GuiAddAlt(final GuiAltManager lIIlIIlIIIllIll) {
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Idle..."));
        this.manager = lIIlIIlIIIllIll;
    }
    
    @Override
    public void drawScreen(final int lIIlIIlIIIIlIII, final int lIIlIIlIIIIlIll, final float lIIlIIlIIIIIllI) {
        this.drawDefaultBackground();
        this.username.drawTextBox();
        this.password.drawTextBox();
        this.drawCenteredString(this.fontRendererObj, "Add Alt", this.width / 2, 20, -1);
        if (this.username.getText().isEmpty()) {
            this.drawString(this.mc.fontRendererObj, "Username / E-Mail", this.width / 2 - 96, 66, -7829368);
        }
        if (this.password.getText().isEmpty()) {
            this.drawString(this.mc.fontRendererObj, "Password", this.width / 2 - 96, 106, -7829368);
        }
        this.drawCenteredString(this.fontRendererObj, this.status, this.width / 2, 30, -1);
        super.drawScreen(lIIlIIlIIIIlIII, lIIlIIlIIIIlIll, lIIlIIlIIIIIllI);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lIIlIIlIIIlIllI) {
        switch (lIIlIIlIIIlIllI.id) {
            case 0: {
                final AddAltThread lIIlIIlIIIlIlIl = new AddAltThread(this.username.getText(), this.password.getText());
                lIIlIIlIIIlIlIl.start();
                break;
            }
            case 1: {
                this.mc.displayGuiScreen(this.manager);
                break;
            }
        }
    }
    
    @Override
    protected void keyTyped(final char lIIlIIIlllllllI, final int lIIlIIIllllllIl) {
        this.username.textboxKeyTyped(lIIlIIIlllllllI, lIIlIIIllllllIl);
        this.password.textboxKeyTyped(lIIlIIIlllllllI, lIIlIIIllllllIl);
        if (lIIlIIIlllllllI == '\t' && (this.username.isFocused() || this.password.isFocused())) {
            this.username.setFocused(!this.username.isFocused());
            this.password.setFocused(!this.password.isFocused());
        }
        if (lIIlIIIlllllllI == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
    }
    
    private class AddAltThread extends Thread
    {
        private final /* synthetic */ String username;
        private final /* synthetic */ String password;
        
        public AddAltThread(final String llllllllllllllIlllIlllllllIlllll, final String llllllllllllllIlllIlllllllIllllI) {
            this.username = llllllllllllllIlllIlllllllIlllll;
            this.password = llllllllllllllIlllIlllllllIllllI;
            GuiAddAlt.access$0(GuiAddAlt.this, String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Idle...")));
        }
        
        @Override
        public void run() {
            if (this.password.equals("")) {
                AltManager.registry.add(new Alt(this.username, ""));
                GuiAddAlt.access$0(GuiAddAlt.this, String.valueOf(new StringBuilder().append(EnumChatFormatting.GREEN).append("Alt added. (").append(this.username).append(" - offline name)")));
                return;
            }
            GuiAddAlt.access$0(GuiAddAlt.this, String.valueOf(new StringBuilder().append(EnumChatFormatting.YELLOW).append("Trying alt...")));
            try {
                this.checkAndAddAlt(this.username, this.password);
            }
            catch (IOException llllllllllllllIlllIlllllllIIIIll) {
                llllllllllllllIlllIlllllllIIIIll.printStackTrace();
            }
        }
        
        private final void checkAndAddAlt(final String llllllllllllllIlllIlllllllIIllII, final String llllllllllllllIlllIlllllllIIlIll) throws IOException {
            final YggdrasilAuthenticationService llllllllllllllIlllIlllllllIlIIII = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
            final YggdrasilUserAuthentication llllllllllllllIlllIlllllllIIllll = (YggdrasilUserAuthentication)llllllllllllllIlllIlllllllIlIIII.createUserAuthentication(Agent.MINECRAFT);
            llllllllllllllIlllIlllllllIIllll.setUsername(llllllllllllllIlllIlllllllIIllII);
            llllllllllllllIlllIlllllllIIllll.setPassword(llllllllllllllIlllIlllllllIIlIll);
            try {
                llllllllllllllIlllIlllllllIIllll.logIn();
                AltManager.registry.add(new Alt(llllllllllllllIlllIlllllllIIllII, llllllllllllllIlllIlllllllIIlIll, llllllllllllllIlllIlllllllIIllll.getSelectedProfile().getName()));
                GuiAddAlt.access$0(GuiAddAlt.this, String.valueOf(new StringBuilder("Alt added. (").append(llllllllllllllIlllIlllllllIIllII).append(")")));
            }
            catch (AuthenticationException llllllllllllllIlllIlllllllIIlllI) {
                GuiAddAlt.access$0(GuiAddAlt.this, String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Alt failed!")));
                llllllllllllllIlllIlllllllIIlllI.printStackTrace();
            }
        }
    }
}
