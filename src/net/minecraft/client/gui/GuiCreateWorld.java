package net.minecraft.client.gui;

import java.io.*;
import org.lwjgl.input.*;
import net.minecraft.client.resources.*;
import java.util.*;
import org.apache.commons.lang3.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.*;

public class GuiCreateWorld extends GuiScreen
{
    private /* synthetic */ GuiButton field_146325_B;
    private /* synthetic */ GuiButton field_146321_E;
    private static final /* synthetic */ String[] field_146327_L;
    private /* synthetic */ String field_175300_s;
    private /* synthetic */ GuiScreen field_146332_f;
    private /* synthetic */ String field_146330_J;
    private /* synthetic */ boolean field_146339_u;
    private /* synthetic */ boolean field_146337_w;
    private /* synthetic */ String field_146342_r;
    private /* synthetic */ String field_146323_G;
    private /* synthetic */ boolean field_146340_t;
    private /* synthetic */ GuiTextField field_146333_g;
    private /* synthetic */ GuiButton field_146320_D;
    private /* synthetic */ boolean field_146344_y;
    private /* synthetic */ boolean field_146345_x;
    private /* synthetic */ GuiTextField field_146335_h;
    private /* synthetic */ int field_146331_K;
    public /* synthetic */ String field_146334_a;
    private /* synthetic */ String field_146329_I;
    private /* synthetic */ boolean field_146341_s;
    private /* synthetic */ GuiButton field_146343_z;
    private /* synthetic */ boolean field_146338_v;
    private /* synthetic */ String field_146336_i;
    private /* synthetic */ GuiButton field_146322_F;
    private /* synthetic */ GuiButton field_146326_C;
    private /* synthetic */ GuiButton field_146324_A;
    private /* synthetic */ String field_146328_H;
    
    @Override
    protected void mouseClicked(final int llllllllllllllllIIIIIIIllIlIllIl, final int llllllllllllllllIIIIIIIllIlIllII, final int llllllllllllllllIIIIIIIllIlIllll) throws IOException {
        super.mouseClicked(llllllllllllllllIIIIIIIllIlIllIl, llllllllllllllllIIIIIIIllIlIllII, llllllllllllllllIIIIIIIllIlIllll);
        if (this.field_146344_y) {
            this.field_146335_h.mouseClicked(llllllllllllllllIIIIIIIllIlIllIl, llllllllllllllllIIIIIIIllIlIllII, llllllllllllllllIIIIIIIllIlIllll);
        }
        else {
            this.field_146333_g.mouseClicked(llllllllllllllllIIIIIIIllIlIllIl, llllllllllllllllIIIIIIIllIlIllII, llllllllllllllllIIIIIIIllIlIllll);
        }
    }
    
    private void func_146315_i() {
        this.func_146316_a(!this.field_146344_y);
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("selectWorld.create", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        final List buttonList = this.buttonList;
        final GuiButton field_146343_z = new GuiButton(2, this.width / 2 - 75, 115, 150, 20, I18n.format("selectWorld.gameMode", new Object[0]));
        this.field_146343_z = field_146343_z;
        buttonList.add(field_146343_z);
        final List buttonList2 = this.buttonList;
        final GuiButton field_146324_A = new GuiButton(3, this.width / 2 - 75, 187, 150, 20, I18n.format("selectWorld.moreWorldOptions", new Object[0]));
        this.field_146324_A = field_146324_A;
        buttonList2.add(field_146324_A);
        final List buttonList3 = this.buttonList;
        final GuiButton field_146325_B = new GuiButton(4, this.width / 2 - 155, 100, 150, 20, I18n.format("selectWorld.mapFeatures", new Object[0]));
        this.field_146325_B = field_146325_B;
        buttonList3.add(field_146325_B);
        this.field_146325_B.visible = false;
        final List buttonList4 = this.buttonList;
        final GuiButton field_146326_C = new GuiButton(7, this.width / 2 + 5, 151, 150, 20, I18n.format("selectWorld.bonusItems", new Object[0]));
        this.field_146326_C = field_146326_C;
        buttonList4.add(field_146326_C);
        this.field_146326_C.visible = false;
        final List buttonList5 = this.buttonList;
        final GuiButton field_146320_D = new GuiButton(5, this.width / 2 + 5, 100, 150, 20, I18n.format("selectWorld.mapType", new Object[0]));
        this.field_146320_D = field_146320_D;
        buttonList5.add(field_146320_D);
        this.field_146320_D.visible = false;
        final List buttonList6 = this.buttonList;
        final GuiButton field_146321_E = new GuiButton(6, this.width / 2 - 155, 151, 150, 20, I18n.format("selectWorld.allowCommands", new Object[0]));
        this.field_146321_E = field_146321_E;
        buttonList6.add(field_146321_E);
        this.field_146321_E.visible = false;
        final List buttonList7 = this.buttonList;
        final GuiButton field_146322_F = new GuiButton(8, this.width / 2 + 5, 120, 150, 20, I18n.format("selectWorld.customizeType", new Object[0]));
        this.field_146322_F = field_146322_F;
        buttonList7.add(field_146322_F);
        this.field_146322_F.visible = false;
        this.field_146333_g = new GuiTextField(9, this.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.field_146333_g.setFocused(true);
        this.field_146333_g.setText(this.field_146330_J);
        this.field_146335_h = new GuiTextField(10, this.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.field_146335_h.setText(this.field_146329_I);
        this.func_146316_a(this.field_146344_y);
        this.func_146314_g();
        this.func_146319_h();
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllIIIIIIIlllIllIll) throws IOException {
        if (llllllllllllllllIIIIIIIlllIllIll.enabled) {
            if (llllllllllllllllIIIIIIIlllIllIll.id == 1) {
                this.mc.displayGuiScreen(this.field_146332_f);
            }
            else if (llllllllllllllllIIIIIIIlllIllIll.id == 0) {
                this.mc.displayGuiScreen(null);
                if (this.field_146345_x) {
                    return;
                }
                this.field_146345_x = true;
                long llllllllllllllllIIIIIIIlllIllIlI = new Random().nextLong();
                final String llllllllllllllllIIIIIIIlllIllIIl = this.field_146335_h.getText();
                if (!StringUtils.isEmpty((CharSequence)llllllllllllllllIIIIIIIlllIllIIl)) {
                    try {
                        final long llllllllllllllllIIIIIIIlllIllIII = Long.parseLong(llllllllllllllllIIIIIIIlllIllIIl);
                        if (llllllllllllllllIIIIIIIlllIllIII != 0L) {
                            llllllllllllllllIIIIIIIlllIllIlI = llllllllllllllllIIIIIIIlllIllIII;
                        }
                    }
                    catch (NumberFormatException llllllllllllllllIIIIIIIlllIlIlll) {
                        llllllllllllllllIIIIIIIlllIllIlI = llllllllllllllllIIIIIIIlllIllIIl.hashCode();
                    }
                }
                final WorldSettings.GameType llllllllllllllllIIIIIIIlllIlIllI = WorldSettings.GameType.getByName(this.field_146342_r);
                final WorldSettings llllllllllllllllIIIIIIIlllIlIlIl = new WorldSettings(llllllllllllllllIIIIIIIlllIllIlI, llllllllllllllllIIIIIIIlllIlIllI, this.field_146341_s, this.field_146337_w, WorldType.worldTypes[this.field_146331_K]);
                llllllllllllllllIIIIIIIlllIlIlIl.setWorldName(this.field_146334_a);
                if (this.field_146338_v && !this.field_146337_w) {
                    llllllllllllllllIIIIIIIlllIlIlIl.enableBonusChest();
                }
                if (this.field_146340_t && !this.field_146337_w) {
                    llllllllllllllllIIIIIIIlllIlIlIl.enableCommands();
                }
                this.mc.launchIntegratedServer(this.field_146336_i, this.field_146333_g.getText().trim(), llllllllllllllllIIIIIIIlllIlIlIl);
            }
            else if (llllllllllllllllIIIIIIIlllIllIll.id == 3) {
                this.func_146315_i();
            }
            else if (llllllllllllllllIIIIIIIlllIllIll.id == 2) {
                if (this.field_146342_r.equals("survival")) {
                    if (!this.field_146339_u) {
                        this.field_146340_t = false;
                    }
                    this.field_146337_w = false;
                    this.field_146342_r = "hardcore";
                    this.field_146337_w = true;
                    this.field_146321_E.enabled = false;
                    this.field_146326_C.enabled = false;
                    this.func_146319_h();
                }
                else if (this.field_146342_r.equals("hardcore")) {
                    if (!this.field_146339_u) {
                        this.field_146340_t = true;
                    }
                    this.field_146337_w = false;
                    this.field_146342_r = "creative";
                    this.func_146319_h();
                    this.field_146337_w = false;
                    this.field_146321_E.enabled = true;
                    this.field_146326_C.enabled = true;
                }
                else {
                    if (!this.field_146339_u) {
                        this.field_146340_t = false;
                    }
                    this.field_146342_r = "survival";
                    this.func_146319_h();
                    this.field_146321_E.enabled = true;
                    this.field_146326_C.enabled = true;
                    this.field_146337_w = false;
                }
                this.func_146319_h();
            }
            else if (llllllllllllllllIIIIIIIlllIllIll.id == 4) {
                this.field_146341_s = !this.field_146341_s;
                this.func_146319_h();
            }
            else if (llllllllllllllllIIIIIIIlllIllIll.id == 7) {
                this.field_146338_v = !this.field_146338_v;
                this.func_146319_h();
            }
            else if (llllllllllllllllIIIIIIIlllIllIll.id == 5) {
                ++this.field_146331_K;
                if (this.field_146331_K >= WorldType.worldTypes.length) {
                    this.field_146331_K = 0;
                }
                while (!this.func_175299_g()) {
                    ++this.field_146331_K;
                    if (this.field_146331_K >= WorldType.worldTypes.length) {
                        this.field_146331_K = 0;
                    }
                }
                this.field_146334_a = "";
                this.func_146319_h();
                this.func_146316_a(this.field_146344_y);
            }
            else if (llllllllllllllllIIIIIIIlllIllIll.id == 6) {
                this.field_146339_u = true;
                this.field_146340_t = !this.field_146340_t;
                this.func_146319_h();
            }
            else if (llllllllllllllllIIIIIIIlllIllIll.id == 8) {
                if (WorldType.worldTypes[this.field_146331_K] == WorldType.FLAT) {
                    this.mc.displayGuiScreen(new GuiCreateFlatWorld(this, this.field_146334_a));
                }
                else {
                    this.mc.displayGuiScreen(new GuiCustomizeWorldScreen(this, this.field_146334_a));
                }
            }
        }
    }
    
    private void func_146316_a(final boolean llllllllllllllllIIIIIIIlllIIIIII) {
        this.field_146344_y = llllllllllllllllIIIIIIIlllIIIIII;
        if (WorldType.worldTypes[this.field_146331_K] == WorldType.DEBUG_WORLD) {
            this.field_146343_z.visible = !this.field_146344_y;
            this.field_146343_z.enabled = false;
            if (this.field_175300_s == null) {
                this.field_175300_s = this.field_146342_r;
            }
            this.field_146342_r = "spectator";
            this.field_146325_B.visible = false;
            this.field_146326_C.visible = false;
            this.field_146320_D.visible = this.field_146344_y;
            this.field_146321_E.visible = false;
            this.field_146322_F.visible = false;
        }
        else {
            this.field_146343_z.visible = !this.field_146344_y;
            this.field_146343_z.enabled = true;
            if (this.field_175300_s != null) {
                this.field_146342_r = this.field_175300_s;
                this.field_175300_s = null;
            }
            this.field_146325_B.visible = (this.field_146344_y && WorldType.worldTypes[this.field_146331_K] != WorldType.CUSTOMIZED);
            this.field_146326_C.visible = this.field_146344_y;
            this.field_146320_D.visible = this.field_146344_y;
            this.field_146321_E.visible = this.field_146344_y;
            this.field_146322_F.visible = (this.field_146344_y && (WorldType.worldTypes[this.field_146331_K] == WorldType.FLAT || WorldType.worldTypes[this.field_146331_K] == WorldType.CUSTOMIZED));
        }
        this.func_146319_h();
        if (this.field_146344_y) {
            this.field_146324_A.displayString = I18n.format("gui.done", new Object[0]);
        }
        else {
            this.field_146324_A.displayString = I18n.format("selectWorld.moreWorldOptions", new Object[0]);
        }
    }
    
    static {
        __OBFID = "CL_00000689";
        field_146327_L = new String[] { "CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9" };
    }
    
    private void func_146319_h() {
        this.field_146343_z.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.gameMode", new Object[0]))).append(": ").append(I18n.format(String.valueOf(new StringBuilder("selectWorld.gameMode.").append(this.field_146342_r)), new Object[0])));
        this.field_146323_G = I18n.format(String.valueOf(new StringBuilder("selectWorld.gameMode.").append(this.field_146342_r).append(".line1")), new Object[0]);
        this.field_146328_H = I18n.format(String.valueOf(new StringBuilder("selectWorld.gameMode.").append(this.field_146342_r).append(".line2")), new Object[0]);
        this.field_146325_B.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.mapFeatures", new Object[0]))).append(" "));
        if (this.field_146341_s) {
            this.field_146325_B.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146325_B.displayString)).append(I18n.format("options.on", new Object[0])));
        }
        else {
            this.field_146325_B.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146325_B.displayString)).append(I18n.format("options.off", new Object[0])));
        }
        this.field_146326_C.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.bonusItems", new Object[0]))).append(" "));
        if (this.field_146338_v && !this.field_146337_w) {
            this.field_146326_C.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146326_C.displayString)).append(I18n.format("options.on", new Object[0])));
        }
        else {
            this.field_146326_C.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146326_C.displayString)).append(I18n.format("options.off", new Object[0])));
        }
        this.field_146320_D.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.mapType", new Object[0]))).append(" ").append(I18n.format(WorldType.worldTypes[this.field_146331_K].getTranslateName(), new Object[0])));
        this.field_146321_E.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0]))).append(" "));
        if (this.field_146340_t && !this.field_146337_w) {
            this.field_146321_E.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146321_E.displayString)).append(I18n.format("options.on", new Object[0])));
        }
        else {
            this.field_146321_E.displayString = String.valueOf(new StringBuilder(String.valueOf(this.field_146321_E.displayString)).append(I18n.format("options.off", new Object[0])));
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    private boolean func_175299_g() {
        final WorldType llllllllllllllllIIIIIIIlllIIlIll = WorldType.worldTypes[this.field_146331_K];
        return llllllllllllllllIIIIIIIlllIIlIll != null && llllllllllllllllIIIIIIIlllIIlIll.getCanBeCreated() && (llllllllllllllllIIIIIIIlllIIlIll != WorldType.DEBUG_WORLD || GuiScreen.isShiftKeyDown());
    }
    
    public static String func_146317_a(final ISaveFormat llllllllllllllllIIIIIIIllllIllll, String llllllllllllllllIIIIIIIllllIlIII) {
        llllllllllllllllIIIIIIIllllIlIII = llllllllllllllllIIIIIIIllllIlIII.replaceAll("[\\./\"]", "_");
        for (final String llllllllllllllllIIIIIIIllllIlIlI : GuiCreateWorld.field_146327_L) {
            if (llllllllllllllllIIIIIIIllllIlIII.equalsIgnoreCase(llllllllllllllllIIIIIIIllllIlIlI)) {
                llllllllllllllllIIIIIIIllllIlIII = String.valueOf(new StringBuilder("_").append(llllllllllllllllIIIIIIIllllIlIII).append("_"));
            }
        }
        while (llllllllllllllllIIIIIIIllllIllll.getWorldInfo(llllllllllllllllIIIIIIIllllIlIII) != null) {
            llllllllllllllllIIIIIIIllllIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIIIllllIlIII)).append("-"));
        }
        return llllllllllllllllIIIIIIIllllIlIII;
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllllIIIIIIIllIlllIll, final int llllllllllllllllIIIIIIIllIlllIlI) throws IOException {
        if (this.field_146333_g.isFocused() && !this.field_146344_y) {
            this.field_146333_g.textboxKeyTyped(llllllllllllllllIIIIIIIllIlllIll, llllllllllllllllIIIIIIIllIlllIlI);
            this.field_146330_J = this.field_146333_g.getText();
        }
        else if (this.field_146335_h.isFocused() && this.field_146344_y) {
            this.field_146335_h.textboxKeyTyped(llllllllllllllllIIIIIIIllIlllIll, llllllllllllllllIIIIIIIllIlllIlI);
            this.field_146329_I = this.field_146335_h.getText();
        }
        if (llllllllllllllllIIIIIIIllIlllIlI == 28 || llllllllllllllllIIIIIIIllIlllIlI == 156) {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.buttonList.get(0).enabled = (this.field_146333_g.getText().length() > 0);
        this.func_146314_g();
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIIIIIIIllIlIIlIl, final int llllllllllllllllIIIIIIIllIlIIIII, final float llllllllllllllllIIIIIIIllIIlllll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("selectWorld.create", new Object[0]), this.width / 2, 20, -1);
        if (this.field_146344_y) {
            this.drawString(this.fontRendererObj, I18n.format("selectWorld.enterSeed", new Object[0]), this.width / 2 - 100, 47, -6250336);
            this.drawString(this.fontRendererObj, I18n.format("selectWorld.seedInfo", new Object[0]), this.width / 2 - 100, 85, -6250336);
            if (this.field_146325_B.visible) {
                this.drawString(this.fontRendererObj, I18n.format("selectWorld.mapFeatures.info", new Object[0]), this.width / 2 - 150, 122, -6250336);
            }
            if (this.field_146321_E.visible) {
                this.drawString(this.fontRendererObj, I18n.format("selectWorld.allowCommands.info", new Object[0]), this.width / 2 - 150, 172, -6250336);
            }
            this.field_146335_h.drawTextBox();
            if (WorldType.worldTypes[this.field_146331_K].showWorldInfoNotice()) {
                this.fontRendererObj.drawSplitString(I18n.format(WorldType.worldTypes[this.field_146331_K].func_151359_c(), new Object[0]), this.field_146320_D.xPosition + 2, this.field_146320_D.yPosition + 22, this.field_146320_D.getButtonWidth(), 10526880);
            }
        }
        else {
            this.drawString(this.fontRendererObj, I18n.format("selectWorld.enterName", new Object[0]), this.width / 2 - 100, 47, -6250336);
            this.drawString(this.fontRendererObj, String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.resultFolder", new Object[0]))).append(" ").append(this.field_146336_i)), this.width / 2 - 100, 85, -6250336);
            this.field_146333_g.drawTextBox();
            this.drawString(this.fontRendererObj, this.field_146323_G, this.width / 2 - 100, 137, -6250336);
            this.drawString(this.fontRendererObj, this.field_146328_H, this.width / 2 - 100, 149, -6250336);
        }
        super.drawScreen(llllllllllllllllIIIIIIIllIlIIlIl, llllllllllllllllIIIIIIIllIlIIIII, llllllllllllllllIIIIIIIllIIlllll);
    }
    
    private void func_146314_g() {
        this.field_146336_i = this.field_146333_g.getText().trim();
        for (final char llllllllllllllllIIIIIIIllllllllI : ChatAllowedCharacters.allowedCharactersArray) {
            this.field_146336_i = this.field_146336_i.replace(llllllllllllllllIIIIIIIllllllllI, '_');
        }
        if (StringUtils.isEmpty((CharSequence)this.field_146336_i)) {
            this.field_146336_i = "World";
        }
        this.field_146336_i = func_146317_a(this.mc.getSaveLoader(), this.field_146336_i);
    }
    
    public GuiCreateWorld(final GuiScreen llllllllllllllllIIIIIIlIIIIIlllI) {
        this.field_146342_r = "survival";
        this.field_146341_s = true;
        this.field_146334_a = "";
        this.field_146332_f = llllllllllllllllIIIIIIlIIIIIlllI;
        this.field_146329_I = "";
        this.field_146330_J = I18n.format("selectWorld.newWorld", new Object[0]);
    }
    
    public void func_146318_a(final WorldInfo llllllllllllllllIIIIIIIllIIllIIl) {
        this.field_146330_J = I18n.format("selectWorld.newWorld.copyOf", llllllllllllllllIIIIIIIllIIllIIl.getWorldName());
        this.field_146329_I = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIIIllIIllIIl.getSeed())));
        this.field_146331_K = llllllllllllllllIIIIIIIllIIllIIl.getTerrainType().getWorldTypeID();
        this.field_146334_a = llllllllllllllllIIIIIIIllIIllIIl.getGeneratorOptions();
        this.field_146341_s = llllllllllllllllIIIIIIIllIIllIIl.isMapFeaturesEnabled();
        this.field_146340_t = llllllllllllllllIIIIIIIllIIllIIl.areCommandsAllowed();
        if (llllllllllllllllIIIIIIIllIIllIIl.isHardcoreModeEnabled()) {
            this.field_146342_r = "hardcore";
        }
        else if (llllllllllllllllIIIIIIIllIIllIIl.getGameType().isSurvivalOrAdventure()) {
            this.field_146342_r = "survival";
        }
        else if (llllllllllllllllIIIIIIIllIIllIIl.getGameType().isCreative()) {
            this.field_146342_r = "creative";
        }
    }
    
    @Override
    public void updateScreen() {
        this.field_146333_g.updateCursorCounter();
        this.field_146335_h.updateCursorCounter();
    }
}
