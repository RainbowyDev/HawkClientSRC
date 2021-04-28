package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import java.text.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;
import org.apache.commons.lang3.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.*;
import java.util.*;
import net.minecraft.util.*;

public class GuiSelectWorld extends GuiScreen implements GuiYesNoCallback
{
    protected /* synthetic */ GuiScreen field_146632_a;
    private /* synthetic */ boolean field_146634_i;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ String[] field_146635_w;
    private /* synthetic */ java.util.List field_146639_s;
    private /* synthetic */ GuiButton field_146630_A;
    private final /* synthetic */ DateFormat field_146633_h;
    private /* synthetic */ GuiButton field_146641_z;
    private /* synthetic */ String field_146637_u;
    protected /* synthetic */ String field_146628_f;
    private /* synthetic */ boolean field_146643_x;
    private /* synthetic */ GuiButton field_146642_y;
    private /* synthetic */ String field_146636_v;
    private /* synthetic */ GuiButton field_146631_B;
    private /* synthetic */ int field_146640_r;
    private /* synthetic */ List field_146638_t;
    
    public static GuiYesNo func_152129_a(final GuiYesNoCallback llllllllllllllIIIlIIIlIllIIIIlII, final String llllllllllllllIIIlIIIlIlIllllIll, final int llllllllllllllIIIlIIIlIlIllllIlI) {
        final String llllllllllllllIIIlIIIlIllIIIIIIl = I18n.format("selectWorld.deleteQuestion", new Object[0]);
        final String llllllllllllllIIIlIIIlIllIIIIIII = String.valueOf(new StringBuilder("'").append(llllllllllllllIIIlIIIlIlIllllIll).append("' ").append(I18n.format("selectWorld.deleteWarning", new Object[0])));
        final String llllllllllllllIIIlIIIlIlIlllllll = I18n.format("selectWorld.deleteButton", new Object[0]);
        final String llllllllllllllIIIlIIIlIlIllllllI = I18n.format("gui.cancel", new Object[0]);
        final GuiYesNo llllllllllllllIIIlIIIlIlIlllllIl = new GuiYesNo(llllllllllllllIIIlIIIlIllIIIIlII, llllllllllllllIIIlIIIlIllIIIIIIl, llllllllllllllIIIlIIIlIllIIIIIII, llllllllllllllIIIlIIIlIlIlllllll, llllllllllllllIIIlIIIlIlIllllllI, llllllllllllllIIIlIIIlIlIllllIlI);
        return llllllllllllllIIIlIIIlIlIlllllIl;
    }
    
    private void func_146627_h() throws AnvilConverterException {
        final ISaveFormat llllllllllllllIIIlIIIlIlllIllIIl = this.mc.getSaveLoader();
        this.field_146639_s = llllllllllllllIIIlIIIlIlllIllIIl.getSaveList();
        Collections.sort((java.util.List<Comparable>)this.field_146639_s);
        this.field_146640_r = -1;
    }
    
    static /* synthetic */ void access$1(final GuiSelectWorld llllllllllllllIIIlIIIlIlIlllIIII, final int llllllllllllllIIIlIIIlIlIllIllll) {
        llllllllllllllIIIlIIIlIlIlllIIII.field_146640_r = llllllllllllllIIIlIIIlIlIllIllll;
    }
    
    public GuiSelectWorld(final GuiScreen llllllllllllllIIIlIIIlIllllIIllI) {
        this.field_146633_h = new SimpleDateFormat();
        this.field_146628_f = "Select world";
        this.field_146635_w = new String[4];
        this.field_146632_a = llllllllllllllIIIlIIIlIllllIIllI;
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIIlIIIlIllIlllllI) throws IOException {
        if (llllllllllllllIIIlIIIlIllIlllllI.enabled) {
            if (llllllllllllllIIIlIIIlIllIlllllI.id == 2) {
                final String llllllllllllllIIIlIIIlIllIllllIl = this.func_146614_d(this.field_146640_r);
                if (llllllllllllllIIIlIIIlIllIllllIl != null) {
                    this.field_146643_x = true;
                    final GuiYesNo llllllllllllllIIIlIIIlIllIllllII = func_152129_a(this, llllllllllllllIIIlIIIlIllIllllIl, this.field_146640_r);
                    this.mc.displayGuiScreen(llllllllllllllIIIlIIIlIllIllllII);
                }
            }
            else if (llllllllllllllIIIlIIIlIllIlllllI.id == 1) {
                this.func_146615_e(this.field_146640_r);
            }
            else if (llllllllllllllIIIlIIIlIllIlllllI.id == 3) {
                this.mc.displayGuiScreen(new GuiCreateWorld(this));
            }
            else if (llllllllllllllIIIlIIIlIllIlllllI.id == 6) {
                this.mc.displayGuiScreen(new GuiRenameWorld(this, this.func_146621_a(this.field_146640_r)));
            }
            else if (llllllllllllllIIIlIIIlIllIlllllI.id == 0) {
                this.mc.displayGuiScreen(this.field_146632_a);
            }
            else if (llllllllllllllIIIlIIIlIllIlllllI.id == 7) {
                final GuiCreateWorld llllllllllllllIIIlIIIlIllIlllIll = new GuiCreateWorld(this);
                final ISaveHandler llllllllllllllIIIlIIIlIllIlllIlI = this.mc.getSaveLoader().getSaveLoader(this.func_146621_a(this.field_146640_r), false);
                final WorldInfo llllllllllllllIIIlIIIlIllIlllIIl = llllllllllllllIIIlIIIlIllIlllIlI.loadWorldInfo();
                llllllllllllllIIIlIIIlIllIlllIlI.flush();
                llllllllllllllIIIlIIIlIllIlllIll.func_146318_a(llllllllllllllIIIlIIIlIllIlllIIl);
                this.mc.displayGuiScreen(llllllllllllllIIIlIIIlIllIlllIll);
            }
            else {
                this.field_146638_t.actionPerformed(llllllllllllllIIIlIIIlIllIlllllI);
            }
        }
    }
    
    public void func_146618_g() {
        final java.util.List buttonList = this.buttonList;
        final GuiButton field_146641_z = new GuiButton(1, this.width / 2 - 154, this.height - 52, 150, 20, I18n.format("selectWorld.select", new Object[0]));
        this.field_146641_z = field_146641_z;
        buttonList.add(field_146641_z);
        this.buttonList.add(new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, I18n.format("selectWorld.create", new Object[0])));
        final java.util.List buttonList2 = this.buttonList;
        final GuiButton field_146630_A = new GuiButton(6, this.width / 2 - 154, this.height - 28, 72, 20, I18n.format("selectWorld.rename", new Object[0]));
        this.field_146630_A = field_146630_A;
        buttonList2.add(field_146630_A);
        final java.util.List buttonList3 = this.buttonList;
        final GuiButton field_146642_y = new GuiButton(2, this.width / 2 - 76, this.height - 28, 72, 20, I18n.format("selectWorld.delete", new Object[0]));
        this.field_146642_y = field_146642_y;
        buttonList3.add(field_146642_y);
        final java.util.List buttonList4 = this.buttonList;
        final GuiButton field_146631_B = new GuiButton(7, this.width / 2 + 4, this.height - 28, 72, 20, I18n.format("selectWorld.recreate", new Object[0]));
        this.field_146631_B = field_146631_B;
        buttonList4.add(field_146631_B);
        this.buttonList.add(new GuiButton(0, this.width / 2 + 82, this.height - 28, 72, 20, I18n.format("gui.cancel", new Object[0])));
        this.field_146641_z.enabled = false;
        this.field_146642_y.enabled = false;
        this.field_146630_A.enabled = false;
        this.field_146631_B.enabled = false;
    }
    
    @Override
    public void initGui() {
        this.field_146628_f = I18n.format("selectWorld.title", new Object[0]);
        try {
            this.func_146627_h();
        }
        catch (AnvilConverterException llllllllllllllIIIlIIIlIllllIIIlI) {
            GuiSelectWorld.logger.error("Couldn't load level list", (Throwable)llllllllllllllIIIlIIIlIllllIIIlI);
            this.mc.displayGuiScreen(new GuiErrorScreen("Unable to load worlds", llllllllllllllIIIlIIIlIllllIIIlI.getMessage()));
            return;
        }
        this.field_146637_u = I18n.format("selectWorld.world", new Object[0]);
        this.field_146636_v = I18n.format("selectWorld.conversion", new Object[0]);
        this.field_146635_w[WorldSettings.GameType.SURVIVAL.getID()] = I18n.format("gameMode.survival", new Object[0]);
        this.field_146635_w[WorldSettings.GameType.CREATIVE.getID()] = I18n.format("gameMode.creative", new Object[0]);
        this.field_146635_w[WorldSettings.GameType.ADVENTURE.getID()] = I18n.format("gameMode.adventure", new Object[0]);
        this.field_146635_w[WorldSettings.GameType.SPECTATOR.getID()] = I18n.format("gameMode.spectator", new Object[0]);
        this.field_146638_t = new List(this.mc);
        this.field_146638_t.registerScrollButtons(4, 5);
        this.func_146618_g();
    }
    
    protected String func_146614_d(final int llllllllllllllIIIlIIIlIlllIIlIIl) {
        String llllllllllllllIIIlIIIlIlllIIlIll = this.field_146639_s.get(llllllllllllllIIIlIIIlIlllIIlIIl).getDisplayName();
        if (StringUtils.isEmpty((CharSequence)llllllllllllllIIIlIIIlIlllIIlIll)) {
            llllllllllllllIIIlIIIlIlllIIlIll = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.world", new Object[0]))).append(" ").append(llllllllllllllIIIlIIIlIlllIIlIIl + 1));
        }
        return llllllllllllllIIIlIIIlIlllIIlIll;
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllIIIlIIIlIllIlIIIIl, final int llllllllllllllIIIlIIIlIllIlIIIII) {
        if (this.field_146643_x) {
            this.field_146643_x = false;
            if (llllllllllllllIIIlIIIlIllIlIIIIl) {
                final ISaveFormat llllllllllllllIIIlIIIlIllIIlllll = this.mc.getSaveLoader();
                llllllllllllllIIIlIIIlIllIIlllll.flushCache();
                llllllllllllllIIIlIIIlIllIIlllll.deleteWorldDirectory(this.func_146621_a(llllllllllllllIIIlIIIlIllIlIIIII));
                try {
                    this.func_146627_h();
                }
                catch (AnvilConverterException llllllllllllllIIIlIIIlIllIIllllI) {
                    GuiSelectWorld.logger.error("Couldn't load level list", (Throwable)llllllllllllllIIIlIIIlIllIIllllI);
                }
            }
            this.mc.displayGuiScreen(this);
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIIlIIIlIllIIlIIll, final int llllllllllllllIIIlIIIlIllIIIlllI, final float llllllllllllllIIIlIIIlIllIIIllIl) {
        this.field_146638_t.drawScreen(llllllllllllllIIIlIIIlIllIIlIIll, llllllllllllllIIIlIIIlIllIIIlllI, llllllllllllllIIIlIIIlIllIIIllIl);
        this.drawCenteredString(this.fontRendererObj, this.field_146628_f, this.width / 2, 20, 16777215);
        super.drawScreen(llllllllllllllIIIlIIIlIllIIlIIll, llllllllllllllIIIlIIIlIllIIIlllI, llllllllllllllIIIlIIIlIllIIIllIl);
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.field_146638_t.func_178039_p();
    }
    
    public void func_146615_e(final int llllllllllllllIIIlIIIlIllIlIlIlI) {
        this.mc.displayGuiScreen(null);
        if (!this.field_146634_i) {
            this.field_146634_i = true;
            String llllllllllllllIIIlIIIlIllIlIllIl = this.func_146621_a(llllllllllllllIIIlIIIlIllIlIlIlI);
            if (llllllllllllllIIIlIIIlIllIlIllIl == null) {
                llllllllllllllIIIlIIIlIllIlIllIl = String.valueOf(new StringBuilder("World").append(llllllllllllllIIIlIIIlIllIlIlIlI));
            }
            String llllllllllllllIIIlIIIlIllIlIllII = this.func_146614_d(llllllllllllllIIIlIIIlIllIlIlIlI);
            if (llllllllllllllIIIlIIIlIllIlIllII == null) {
                llllllllllllllIIIlIIIlIllIlIllII = String.valueOf(new StringBuilder("World").append(llllllllllllllIIIlIIIlIllIlIlIlI));
            }
            if (this.mc.getSaveLoader().canLoadWorld(llllllllllllllIIIlIIIlIllIlIllIl)) {
                this.mc.launchIntegratedServer(llllllllllllllIIIlIIIlIllIlIllIl, llllllllllllllIIIlIIIlIllIlIllII, null);
            }
        }
    }
    
    protected String func_146621_a(final int llllllllllllllIIIlIIIlIlllIlIIIl) {
        return this.field_146639_s.get(llllllllllllllIIIlIIIlIlllIlIIIl).getFileName();
    }
    
    static {
        __OBFID = "CL_00000711";
        logger = LogManager.getLogger();
    }
    
    class List extends GuiSlot
    {
        @Override
        protected int getContentHeight() {
            return GuiSelectWorld.this.field_146639_s.size() * 36;
        }
        
        @Override
        protected void drawBackground() {
            GuiSelectWorld.this.drawDefaultBackground();
        }
        
        static {
            __OBFID = "CL_00000712";
        }
        
        public List(final Minecraft llllllllllllllIlIlllIlIllIIIIlIl) {
            super(llllllllllllllIlIlllIlIllIIIIlIl, GuiSelectWorld.this.width, GuiSelectWorld.this.height, 32, GuiSelectWorld.this.height - 64, 36);
        }
        
        @Override
        protected void drawSlot(final int llllllllllllllIlIlllIlIlIlIllIll, final int llllllllllllllIlIlllIlIlIlIIllll, final int llllllllllllllIlIlllIlIlIlIIlllI, final int llllllllllllllIlIlllIlIlIlIllIII, final int llllllllllllllIlIlllIlIlIlIlIlll, final int llllllllllllllIlIlllIlIlIlIlIllI) {
            final SaveFormatComparator llllllllllllllIlIlllIlIlIlIlIlIl = GuiSelectWorld.this.field_146639_s.get(llllllllllllllIlIlllIlIlIlIllIll);
            String llllllllllllllIlIlllIlIlIlIlIlII = llllllllllllllIlIlllIlIlIlIlIlIl.getDisplayName();
            if (StringUtils.isEmpty((CharSequence)llllllllllllllIlIlllIlIlIlIlIlII)) {
                llllllllllllllIlIlllIlIlIlIlIlII = String.valueOf(new StringBuilder(String.valueOf(GuiSelectWorld.this.field_146637_u)).append(" ").append(llllllllllllllIlIlllIlIlIlIllIll + 1));
            }
            String llllllllllllllIlIlllIlIlIlIlIIll = llllllllllllllIlIlllIlIlIlIlIlIl.getFileName();
            llllllllllllllIlIlllIlIlIlIlIIll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIlllIlIlIlIlIIll)).append(" (").append(GuiSelectWorld.this.field_146633_h.format(new Date(llllllllllllllIlIlllIlIlIlIlIlIl.getLastTimePlayed()))));
            llllllllllllllIlIlllIlIlIlIlIIll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIlllIlIlIlIlIIll)).append(")"));
            String llllllllllllllIlIlllIlIlIlIlIIlI = "";
            if (llllllllllllllIlIlllIlIlIlIlIlIl.requiresConversion()) {
                llllllllllllllIlIlllIlIlIlIlIIlI = String.valueOf(new StringBuilder(String.valueOf(GuiSelectWorld.this.field_146636_v)).append(" ").append(llllllllllllllIlIlllIlIlIlIlIIlI));
            }
            else {
                llllllllllllllIlIlllIlIlIlIlIIlI = GuiSelectWorld.this.field_146635_w[llllllllllllllIlIlllIlIlIlIlIlIl.getEnumGameType().getID()];
                if (llllllllllllllIlIlllIlIlIlIlIlIl.isHardcoreModeEnabled()) {
                    llllllllllllllIlIlllIlIlIlIlIIlI = String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_RED).append(I18n.format("gameMode.hardcore", new Object[0])).append(EnumChatFormatting.RESET));
                }
                if (llllllllllllllIlIlllIlIlIlIlIlIl.getCheatsEnabled()) {
                    llllllllllllllIlIlllIlIlIlIlIIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIlllIlIlIlIlIIlI)).append(", ").append(I18n.format("selectWorld.cheats", new Object[0])));
                }
            }
            GuiSelectWorld.this.drawString(GuiSelectWorld.this.fontRendererObj, llllllllllllllIlIlllIlIlIlIlIlII, llllllllllllllIlIlllIlIlIlIIllll + 2, llllllllllllllIlIlllIlIlIlIIlllI + 1, 16777215);
            GuiSelectWorld.this.drawString(GuiSelectWorld.this.fontRendererObj, llllllllllllllIlIlllIlIlIlIlIIll, llllllllllllllIlIlllIlIlIlIIllll + 2, llllllllllllllIlIlllIlIlIlIIlllI + 12, 8421504);
            GuiSelectWorld.this.drawString(GuiSelectWorld.this.fontRendererObj, llllllllllllllIlIlllIlIlIlIlIIlI, llllllllllllllIlIlllIlIlIlIIllll + 2, llllllllllllllIlIlllIlIlIlIIlllI + 12 + 10, 8421504);
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllIlIlllIlIlIllllIIl, final boolean llllllllllllllIlIlllIlIlIlllIIlI, final int llllllllllllllIlIlllIlIlIlllIlll, final int llllllllllllllIlIlllIlIlIlllIllI) {
            GuiSelectWorld.access$1(GuiSelectWorld.this, llllllllllllllIlIlllIlIlIllllIIl);
            final boolean llllllllllllllIlIlllIlIlIlllIlIl = GuiSelectWorld.this.field_146640_r >= 0 && GuiSelectWorld.this.field_146640_r < this.getSize();
            GuiSelectWorld.this.field_146641_z.enabled = llllllllllllllIlIlllIlIlIlllIlIl;
            GuiSelectWorld.this.field_146642_y.enabled = llllllllllllllIlIlllIlIlIlllIlIl;
            GuiSelectWorld.this.field_146630_A.enabled = llllllllllllllIlIlllIlIlIlllIlIl;
            GuiSelectWorld.this.field_146631_B.enabled = llllllllllllllIlIlllIlIlIlllIlIl;
            if (llllllllllllllIlIlllIlIlIlllIIlI && llllllllllllllIlIlllIlIlIlllIlIl) {
                GuiSelectWorld.this.func_146615_e(llllllllllllllIlIlllIlIlIllllIIl);
            }
        }
        
        @Override
        protected int getSize() {
            return GuiSelectWorld.this.field_146639_s.size();
        }
        
        @Override
        protected boolean isSelected(final int llllllllllllllIlIlllIlIlIllIllIl) {
            return llllllllllllllIlIlllIlIlIllIllIl == GuiSelectWorld.this.field_146640_r;
        }
    }
}
