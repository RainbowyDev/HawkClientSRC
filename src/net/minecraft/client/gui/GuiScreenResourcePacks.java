package net.minecraft.client.gui;

import net.minecraft.util.*;
import java.net.*;
import org.lwjgl.*;
import com.google.common.collect.*;
import java.io.*;
import java.util.*;
import net.minecraft.client.resources.*;
import org.apache.logging.log4j.*;

public class GuiScreenResourcePacks extends GuiScreen
{
    private /* synthetic */ GuiResourcePackSelected field_146967_r;
    private /* synthetic */ GuiResourcePackAvailable field_146970_i;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ GuiScreen field_146965_f;
    private /* synthetic */ List field_146969_h;
    private /* synthetic */ List field_146966_g;
    private /* synthetic */ boolean field_175289_s;
    
    @Override
    public void drawScreen(final int lllllllllllllllIlIIllIllIIlIIlll, final int lllllllllllllllIlIIllIllIIlIIllI, final float lllllllllllllllIlIIllIllIIlIlIIl) {
        this.drawBackground(0);
        this.field_146970_i.drawScreen(lllllllllllllllIlIIllIllIIlIIlll, lllllllllllllllIlIIllIllIIlIIllI, lllllllllllllllIlIIllIllIIlIlIIl);
        this.field_146967_r.drawScreen(lllllllllllllllIlIIllIllIIlIIlll, lllllllllllllllIlIIllIllIIlIIllI, lllllllllllllllIlIIllIllIIlIlIIl);
        this.drawCenteredString(this.fontRendererObj, I18n.format("resourcePack.title", new Object[0]), this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRendererObj, I18n.format("resourcePack.folderInfo", new Object[0]), this.width / 2 - 77, this.height - 26, 8421504);
        super.drawScreen(lllllllllllllllIlIIllIllIIlIIlll, lllllllllllllllIlIIllIllIIlIIllI, lllllllllllllllIlIIllIllIIlIlIIl);
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.field_146967_r.func_178039_p();
        this.field_146970_i.func_178039_p();
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllllllIlIIllIllIIllIlll, final int lllllllllllllllIlIIllIllIIllIIlI, final int lllllllllllllllIlIIllIllIIllIlIl) {
        super.mouseReleased(lllllllllllllllIlIIllIllIIllIlll, lllllllllllllllIlIIllIllIIllIIlI, lllllllllllllllIlIIllIllIIllIlIl);
    }
    
    public GuiScreenResourcePacks(final GuiScreen lllllllllllllllIlIIllIlllIIIllIl) {
        this.field_175289_s = false;
        this.field_146965_f = lllllllllllllllIlIIllIlllIIIllIl;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIlIIllIllIlIlllIl) throws IOException {
        if (lllllllllllllllIlIIllIllIlIlllIl.enabled) {
            if (lllllllllllllllIlIIllIllIlIlllIl.id == 2) {
                final File lllllllllllllllIlIIllIllIlIlllII = this.mc.getResourcePackRepository().getDirResourcepacks();
                final String lllllllllllllllIlIIllIllIlIllIll = lllllllllllllllIlIIllIllIlIlllII.getAbsolutePath();
                Label_0135: {
                    if (Util.getOSType() == Util.EnumOS.OSX) {
                        try {
                            GuiScreenResourcePacks.logger.info(lllllllllllllllIlIIllIllIlIllIll);
                            Runtime.getRuntime().exec(new String[] { "/usr/bin/open", lllllllllllllllIlIIllIllIlIllIll });
                            return;
                        }
                        catch (IOException lllllllllllllllIlIIllIllIlIllIlI) {
                            GuiScreenResourcePacks.logger.error("Couldn't open file", (Throwable)lllllllllllllllIlIIllIllIlIllIlI);
                            break Label_0135;
                        }
                    }
                    if (Util.getOSType() == Util.EnumOS.WINDOWS) {
                        final String lllllllllllllllIlIIllIllIlIllIIl = String.format("cmd.exe /C start \"Open file\" \"%s\"", lllllllllllllllIlIIllIllIlIllIll);
                        try {
                            Runtime.getRuntime().exec(lllllllllllllllIlIIllIllIlIllIIl);
                            return;
                        }
                        catch (IOException lllllllllllllllIlIIllIllIlIllIII) {
                            GuiScreenResourcePacks.logger.error("Couldn't open file", (Throwable)lllllllllllllllIlIIllIllIlIllIII);
                        }
                    }
                }
                boolean lllllllllllllllIlIIllIllIlIlIlll = false;
                try {
                    final Class lllllllllllllllIlIIllIllIlIlIllI = Class.forName("java.awt.Desktop");
                    final Object lllllllllllllllIlIIllIllIlIlIlIl = lllllllllllllllIlIIllIllIlIlIllI.getMethod("getDesktop", (Class[])new Class[0]).invoke(null, new Object[0]);
                    lllllllllllllllIlIIllIllIlIlIllI.getMethod("browse", URI.class).invoke(lllllllllllllllIlIIllIllIlIlIlIl, lllllllllllllllIlIIllIllIlIlllII.toURI());
                }
                catch (Throwable lllllllllllllllIlIIllIllIlIlIlII) {
                    GuiScreenResourcePacks.logger.error("Couldn't open link", lllllllllllllllIlIIllIllIlIlIlII);
                    lllllllllllllllIlIIllIllIlIlIlll = true;
                }
                if (lllllllllllllllIlIIllIllIlIlIlll) {
                    GuiScreenResourcePacks.logger.info("Opening via system class!");
                    Sys.openURL(String.valueOf(new StringBuilder("file://").append(lllllllllllllllIlIIllIllIlIllIll)));
                }
            }
            else if (lllllllllllllllIlIIllIllIlIlllIl.id == 1) {
                if (this.field_175289_s) {
                    final ArrayList lllllllllllllllIlIIllIllIlIlIIll = Lists.newArrayList();
                    for (final ResourcePackListEntry lllllllllllllllIlIIllIllIlIlIIIl : this.field_146969_h) {
                        if (lllllllllllllllIlIIllIllIlIlIIIl instanceof ResourcePackListEntryFound) {
                            lllllllllllllllIlIIllIllIlIlIIll.add(((ResourcePackListEntryFound)lllllllllllllllIlIIllIllIlIlIIIl).func_148318_i());
                        }
                    }
                    Collections.reverse(lllllllllllllllIlIIllIllIlIlIIll);
                    this.mc.getResourcePackRepository().func_148527_a(lllllllllllllllIlIIllIllIlIlIIll);
                    this.mc.gameSettings.resourcePacks.clear();
                    for (final ResourcePackRepository.Entry lllllllllllllllIlIIllIllIlIlIIII : lllllllllllllllIlIIllIllIlIlIIll) {
                        this.mc.gameSettings.resourcePacks.add(lllllllllllllllIlIIllIllIlIlIIII.getResourcePackName());
                    }
                    this.mc.gameSettings.saveOptions();
                    this.mc.refreshResources();
                }
                this.mc.displayGuiScreen(this.field_146965_f);
            }
        }
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllIlIIllIllIIllllll, final int lllllllllllllllIlIIllIllIIlllllI, final int lllllllllllllllIlIIllIllIlIIIIIl) throws IOException {
        super.mouseClicked(lllllllllllllllIlIIllIllIIllllll, lllllllllllllllIlIIllIllIIlllllI, lllllllllllllllIlIIllIllIlIIIIIl);
        this.field_146970_i.func_148179_a(lllllllllllllllIlIIllIllIIllllll, lllllllllllllllIlIIllIllIIlllllI, lllllllllllllllIlIIllIllIlIIIIIl);
        this.field_146967_r.func_148179_a(lllllllllllllllIlIIllIllIIllllll, lllllllllllllllIlIIllIllIIlllllI, lllllllllllllllIlIIllIllIlIIIIIl);
    }
    
    public List func_146963_h() {
        return this.field_146969_h;
    }
    
    public List func_146964_g() {
        return this.field_146966_g;
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiOptionButton(2, this.width / 2 - 154, this.height - 48, I18n.format("resourcePack.openFolder", new Object[0])));
        this.buttonList.add(new GuiOptionButton(1, this.width / 2 + 4, this.height - 48, I18n.format("gui.done", new Object[0])));
        this.field_146966_g = Lists.newArrayList();
        this.field_146969_h = Lists.newArrayList();
        final ResourcePackRepository lllllllllllllllIlIIllIlllIIIIlII = this.mc.getResourcePackRepository();
        lllllllllllllllIlIIllIlllIIIIlII.updateRepositoryEntriesAll();
        final ArrayList lllllllllllllllIlIIllIlllIIIIIll = Lists.newArrayList((Iterable)lllllllllllllllIlIIllIlllIIIIlII.getRepositoryEntriesAll());
        lllllllllllllllIlIIllIlllIIIIIll.removeAll(lllllllllllllllIlIIllIlllIIIIlII.getRepositoryEntries());
        for (final ResourcePackRepository.Entry lllllllllllllllIlIIllIlllIIIIIIl : lllllllllllllllIlIIllIlllIIIIIll) {
            this.field_146966_g.add(new ResourcePackListEntryFound(this, lllllllllllllllIlIIllIlllIIIIIIl));
        }
        for (final ResourcePackRepository.Entry lllllllllllllllIlIIllIlllIIIIIII : Lists.reverse(lllllllllllllllIlIIllIlllIIIIlII.getRepositoryEntries())) {
            this.field_146969_h.add(new ResourcePackListEntryFound(this, lllllllllllllllIlIIllIlllIIIIIII));
        }
        this.field_146969_h.add(new ResourcePackListEntryDefault(this));
        this.field_146970_i = new GuiResourcePackAvailable(this.mc, 200, this.height, this.field_146966_g);
        this.field_146970_i.setSlotXBoundsFromLeft(this.width / 2 - 4 - 200);
        this.field_146970_i.registerScrollButtons(7, 8);
        this.field_146967_r = new GuiResourcePackSelected(this.mc, 200, this.height, this.field_146969_h);
        this.field_146967_r.setSlotXBoundsFromLeft(this.width / 2 + 4);
        this.field_146967_r.registerScrollButtons(7, 8);
    }
    
    public void func_175288_g() {
        this.field_175289_s = true;
    }
    
    static {
        __OBFID = "CL_00000820";
        logger = LogManager.getLogger();
    }
    
    public boolean hasResourcePackEntry(final ResourcePackListEntry lllllllllllllllIlIIllIllIlllIIlI) {
        return this.field_146969_h.contains(lllllllllllllllIlIIllIllIlllIIlI);
    }
    
    public List func_146962_b(final ResourcePackListEntry lllllllllllllllIlIIllIllIllIllII) {
        return this.hasResourcePackEntry(lllllllllllllllIlIIllIllIllIllII) ? this.field_146969_h : this.field_146966_g;
    }
}
