package net.minecraft.client.gui.achievement;

import net.minecraft.item.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import java.io.*;
import net.minecraft.client.gui.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.*;
import com.google.common.collect.*;
import net.minecraft.stats.*;
import java.util.*;
import org.lwjgl.input.*;
import net.minecraft.util.*;
import net.minecraft.client.audio.*;
import net.minecraft.entity.*;

public class GuiStats extends GuiScreen implements IProgressMeter
{
    private /* synthetic */ StatsItem itemStats;
    private /* synthetic */ StatsBlock blockStats;
    private /* synthetic */ StatsMobsList mobStats;
    protected /* synthetic */ String screenTitle;
    private /* synthetic */ boolean doesGuiPauseGame;
    private /* synthetic */ StatFileWriter field_146546_t;
    protected /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ GuiSlot displaySlot;
    private /* synthetic */ StatsGeneral generalStats;
    
    private void drawStatsScreen(final int llllllllllllllIlIIIlIllllllllIll, final int llllllllllllllIlIIIlIllllllllIlI, final Item llllllllllllllIlIIIlIllllllllIIl) {
        this.drawButtonBackground(llllllllllllllIlIIIlIllllllllIll + 1, llllllllllllllIlIIIlIllllllllIlI + 1);
        GlStateManager.enableRescaleNormal();
        RenderHelper.enableGUIStandardItemLighting();
        this.itemRender.func_175042_a(new ItemStack(llllllllllllllIlIIIlIllllllllIIl, 1, 0), llllllllllllllIlIIIlIllllllllIll + 2, llllllllllllllIlIIIlIllllllllIlI + 2);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
    }
    
    public GuiStats(final GuiScreen llllllllllllllIlIIIllIIIlIIIIlII, final StatFileWriter llllllllllllllIlIIIllIIIIlllllII) {
        this.screenTitle = "Select world";
        this.doesGuiPauseGame = true;
        this.parentScreen = llllllllllllllIlIIIllIIIlIIIIlII;
        this.field_146546_t = llllllllllllllIlIIIllIIIIlllllII;
    }
    
    private void drawButtonBackground(final int llllllllllllllIlIIIlIllllllIlllI, final int llllllllllllllIlIIIlIllllllIlIII) {
        this.drawSprite(llllllllllllllIlIIIlIllllllIlllI, llllllllllllllIlIIIlIllllllIlIII, 0, 0);
    }
    
    private void drawSprite(final int llllllllllllllIlIIIlIllllIllIIlI, final int llllllllllllllIlIIIlIllllIllIIIl, final int llllllllllllllIlIIIlIlllllIIIIIl, final int llllllllllllllIlIIIlIllllIlllIlI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiStats.statIcons);
        final float llllllllllllllIlIIIlIllllIlllIIl = 0.0078125f;
        final float llllllllllllllIlIIIlIllllIlllIII = 0.0078125f;
        final boolean llllllllllllllIlIIIlIllllIllIlll = true;
        final boolean llllllllllllllIlIIIlIllllIllIllI = true;
        final Tessellator llllllllllllllIlIIIlIllllIllIlIl = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIlIIIlIllllIllIlII = llllllllllllllIlIIIlIllllIllIlIl.getWorldRenderer();
        llllllllllllllIlIIIlIllllIllIlII.startDrawingQuads();
        llllllllllllllIlIIIlIllllIllIlII.addVertexWithUV(llllllllllllllIlIIIlIllllIllIIlI + 0, llllllllllllllIlIIIlIllllIllIIIl + 18, this.zLevel, (llllllllllllllIlIIIlIlllllIIIIIl + 0) * 0.0078125f, (llllllllllllllIlIIIlIllllIlllIlI + 18) * 0.0078125f);
        llllllllllllllIlIIIlIllllIllIlII.addVertexWithUV(llllllllllllllIlIIIlIllllIllIIlI + 18, llllllllllllllIlIIIlIllllIllIIIl + 18, this.zLevel, (llllllllllllllIlIIIlIlllllIIIIIl + 18) * 0.0078125f, (llllllllllllllIlIIIlIllllIlllIlI + 18) * 0.0078125f);
        llllllllllllllIlIIIlIllllIllIlII.addVertexWithUV(llllllllllllllIlIIIlIllllIllIIlI + 18, llllllllllllllIlIIIlIllllIllIIIl + 0, this.zLevel, (llllllllllllllIlIIIlIlllllIIIIIl + 18) * 0.0078125f, (llllllllllllllIlIIIlIllllIlllIlI + 0) * 0.0078125f);
        llllllllllllllIlIIIlIllllIllIlII.addVertexWithUV(llllllllllllllIlIIIlIllllIllIIlI + 0, llllllllllllllIlIIIlIllllIllIIIl + 0, this.zLevel, (llllllllllllllIlIIIlIlllllIIIIIl + 0) * 0.0078125f, (llllllllllllllIlIIIlIllllIlllIlI + 0) * 0.0078125f);
        llllllllllllllIlIIIlIllllIllIlIl.draw();
    }
    
    public void createButtons() {
        this.buttonList.add(new GuiButton(0, this.width / 2 + 4, this.height - 28, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 160, this.height - 52, 80, 20, I18n.format("stat.generalButton", new Object[0])));
        final GuiButton llllllllllllllIlIIIllIIIIlIlIIlI;
        this.buttonList.add(llllllllllllllIlIIIllIIIIlIlIIlI = new GuiButton(2, this.width / 2 - 80, this.height - 52, 80, 20, I18n.format("stat.blocksButton", new Object[0])));
        final GuiButton llllllllllllllIlIIIllIIIIlIlIIIl;
        this.buttonList.add(llllllllllllllIlIIIllIIIIlIlIIIl = new GuiButton(3, this.width / 2, this.height - 52, 80, 20, I18n.format("stat.itemsButton", new Object[0])));
        final GuiButton llllllllllllllIlIIIllIIIIlIlIIII;
        this.buttonList.add(llllllllllllllIlIIIllIIIIlIlIIII = new GuiButton(4, this.width / 2 + 80, this.height - 52, 80, 20, I18n.format("stat.mobsButton", new Object[0])));
        if (this.blockStats.getSize() == 0) {
            llllllllllllllIlIIIllIIIIlIlIIlI.enabled = false;
        }
        if (this.itemStats.getSize() == 0) {
            llllllllllllllIlIIIllIIIIlIlIIIl.enabled = false;
        }
        if (this.mobStats.getSize() == 0) {
            llllllllllllllIlIIIllIIIIlIlIIII.enabled = false;
        }
    }
    
    static {
        __OBFID = "CL_00000723";
    }
    
    public void func_175366_f() {
        this.generalStats = new StatsGeneral(this.mc);
        this.generalStats.registerScrollButtons(1, 1);
        this.itemStats = new StatsItem(this.mc);
        this.itemStats.registerScrollButtons(1, 1);
        this.blockStats = new StatsBlock(this.mc);
        this.blockStats.registerScrollButtons(1, 1);
        this.mobStats = new StatsMobsList(this.mc);
        this.mobStats.registerScrollButtons(1, 1);
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return !this.doesGuiPauseGame;
    }
    
    @Override
    public void doneLoading() {
        if (this.doesGuiPauseGame) {
            this.func_175366_f();
            this.createButtons();
            this.displaySlot = this.generalStats;
            this.doesGuiPauseGame = false;
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlIIIllIIIIIllIIIl) throws IOException {
        if (llllllllllllllIlIIIllIIIIIllIIIl.enabled) {
            if (llllllllllllllIlIIIllIIIIIllIIIl.id == 0) {
                this.mc.displayGuiScreen(this.parentScreen);
            }
            else if (llllllllllllllIlIIIllIIIIIllIIIl.id == 1) {
                this.displaySlot = this.generalStats;
            }
            else if (llllllllllllllIlIIIllIIIIIllIIIl.id == 3) {
                this.displaySlot = this.itemStats;
            }
            else if (llllllllllllllIlIIIllIIIIIllIIIl.id == 2) {
                this.displaySlot = this.blockStats;
            }
            else if (llllllllllllllIlIIIllIIIIIllIIIl.id == 4) {
                this.displaySlot = this.mobStats;
            }
            else {
                this.displaySlot.actionPerformed(llllllllllllllIlIIIllIIIIIllIIIl);
            }
        }
    }
    
    @Override
    public void initGui() {
        this.screenTitle = I18n.format("gui.stats", new Object[0]);
        this.doesGuiPauseGame = true;
        this.mc.getNetHandler().addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.REQUEST_STATS));
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlIIIllIIIIIIllllI, final int llllllllllllllIlIIIllIIIIIIllIIl, final float llllllllllllllIlIIIllIIIIIIllIII) {
        if (this.doesGuiPauseGame) {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.downloadingStats", new Object[0]), this.width / 2, this.height / 2, 16777215);
            this.drawCenteredString(this.fontRendererObj, GuiStats.lanSearchStates[(int)(Minecraft.getSystemTime() / 150L % GuiStats.lanSearchStates.length)], this.width / 2, this.height / 2 + this.fontRendererObj.FONT_HEIGHT * 2, 16777215);
        }
        else {
            this.displaySlot.drawScreen(llllllllllllllIlIIIllIIIIIIllllI, llllllllllllllIlIIIllIIIIIIllIIl, llllllllllllllIlIIIllIIIIIIllIII);
            this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 20, 16777215);
            super.drawScreen(llllllllllllllIlIIIllIIIIIIllllI, llllllllllllllIlIIIllIIIIIIllIIl, llllllllllllllIlIIIllIIIIIIllIII);
        }
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        if (this.displaySlot != null) {
            this.displaySlot.func_178039_p();
        }
    }
    
    class StatsItem extends Stats
    {
        @Override
        protected void drawListHeader(final int llllllllllllllIIIlIIllIlllllllIl, final int llllllllllllllIIIlIIlllIIIIIIIII, final Tessellator llllllllllllllIIIlIIllIlllllllll) {
            super.drawListHeader(llllllllllllllIIIlIIllIlllllllIl, llllllllllllllIIIlIIlllIIIIIIIII, llllllllllllllIIIlIIllIlllllllll);
            if (this.field_148218_l == 0) {
                GuiStats.this.drawSprite(llllllllllllllIIIlIIllIlllllllIl + 115 - 18 + 1, llllllllllllllIIIlIIlllIIIIIIIII + 1 + 1, 72, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIlIIllIlllllllIl + 115 - 18, llllllllllllllIIIlIIlllIIIIIIIII + 1, 72, 18);
            }
            if (this.field_148218_l == 1) {
                GuiStats.this.drawSprite(llllllllllllllIIIlIIllIlllllllIl + 165 - 18 + 1, llllllllllllllIIIlIIlllIIIIIIIII + 1 + 1, 18, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIlIIllIlllllllIl + 165 - 18, llllllllllllllIIIlIIlllIIIIIIIII + 1, 18, 18);
            }
            if (this.field_148218_l == 2) {
                GuiStats.this.drawSprite(llllllllllllllIIIlIIllIlllllllIl + 215 - 18 + 1, llllllllllllllIIIlIIlllIIIIIIIII + 1 + 1, 36, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIlIIllIlllllllIl + 215 - 18, llllllllllllllIIIlIIlllIIIIIIIII + 1, 36, 18);
            }
        }
        
        public StatsItem(final Minecraft llllllllllllllIIIlIIlllIIIIIlIll) {
            super(llllllllllllllIIIlIIlllIIIIIlIll);
            this.statsHolder = Lists.newArrayList();
            for (final StatCrafting llllllllllllllIIIlIIlllIIIIlIIII : StatList.itemStats) {
                boolean llllllllllllllIIIlIIlllIIIIIllll = false;
                final int llllllllllllllIIIlIIlllIIIIIlllI = Item.getIdFromItem(llllllllllllllIIIlIIlllIIIIlIIII.func_150959_a());
                if (GuiStats.this.field_146546_t.writeStat(llllllllllllllIIIlIIlllIIIIlIIII) > 0) {
                    llllllllllllllIIIlIIlllIIIIIllll = true;
                }
                else if (StatList.objectBreakStats[llllllllllllllIIIlIIlllIIIIIlllI] != null && GuiStats.this.field_146546_t.writeStat(StatList.objectBreakStats[llllllllllllllIIIlIIlllIIIIIlllI]) > 0) {
                    llllllllllllllIIIlIIlllIIIIIllll = true;
                }
                else if (StatList.objectCraftStats[llllllllllllllIIIlIIlllIIIIIlllI] != null && GuiStats.this.field_146546_t.writeStat(StatList.objectCraftStats[llllllllllllllIIIlIIlllIIIIIlllI]) > 0) {
                    llllllllllllllIIIlIIlllIIIIIllll = true;
                }
                if (llllllllllllllIIIlIIlllIIIIIllll) {
                    this.statsHolder.add(llllllllllllllIIIlIIlllIIIIlIIII);
                }
            }
            this.statSorter = new Comparator() {
                @Override
                public int compare(final Object lllllllllllllllIllIIIIIIIlIIllII, final Object lllllllllllllllIllIIIIIIIlIIlIll) {
                    return this.compare((StatCrafting)lllllllllllllllIllIIIIIIIlIIllII, (StatCrafting)lllllllllllllllIllIIIIIIIlIIlIll);
                }
                
                public int compare(final StatCrafting lllllllllllllllIllIIIIIIIllIIIIl, final StatCrafting lllllllllllllllIllIIIIIIIlIlIlll) {
                    final int lllllllllllllllIllIIIIIIIlIlllll = Item.getIdFromItem(lllllllllllllllIllIIIIIIIllIIIIl.func_150959_a());
                    final int lllllllllllllllIllIIIIIIIlIllllI = Item.getIdFromItem(lllllllllllllllIllIIIIIIIlIlIlll.func_150959_a());
                    StatBase lllllllllllllllIllIIIIIIIlIlllIl = null;
                    StatBase lllllllllllllllIllIIIIIIIlIlllII = null;
                    if (StatsItem.this.field_148217_o == 0) {
                        lllllllllllllllIllIIIIIIIlIlllIl = StatList.objectBreakStats[lllllllllllllllIllIIIIIIIlIlllll];
                        lllllllllllllllIllIIIIIIIlIlllII = StatList.objectBreakStats[lllllllllllllllIllIIIIIIIlIllllI];
                    }
                    else if (StatsItem.this.field_148217_o == 1) {
                        lllllllllllllllIllIIIIIIIlIlllIl = StatList.objectCraftStats[lllllllllllllllIllIIIIIIIlIlllll];
                        lllllllllllllllIllIIIIIIIlIlllII = StatList.objectCraftStats[lllllllllllllllIllIIIIIIIlIllllI];
                    }
                    else if (StatsItem.this.field_148217_o == 2) {
                        lllllllllllllllIllIIIIIIIlIlllIl = StatList.objectUseStats[lllllllllllllllIllIIIIIIIlIlllll];
                        lllllllllllllllIllIIIIIIIlIlllII = StatList.objectUseStats[lllllllllllllllIllIIIIIIIlIllllI];
                    }
                    if (lllllllllllllllIllIIIIIIIlIlllIl != null || lllllllllllllllIllIIIIIIIlIlllII != null) {
                        if (lllllllllllllllIllIIIIIIIlIlllIl == null) {
                            return 1;
                        }
                        if (lllllllllllllllIllIIIIIIIlIlllII == null) {
                            return -1;
                        }
                        final int lllllllllllllllIllIIIIIIIlIllIll = GuiStats.this.field_146546_t.writeStat(lllllllllllllllIllIIIIIIIlIlllIl);
                        final int lllllllllllllllIllIIIIIIIlIllIlI = GuiStats.this.field_146546_t.writeStat(lllllllllllllllIllIIIIIIIlIlllII);
                        if (lllllllllllllllIllIIIIIIIlIllIll != lllllllllllllllIllIIIIIIIlIllIlI) {
                            return (lllllllllllllllIllIIIIIIIlIllIll - lllllllllllllllIllIIIIIIIlIllIlI) * StatsItem.this.field_148215_p;
                        }
                    }
                    return lllllllllllllllIllIIIIIIIlIlllll - lllllllllllllllIllIIIIIIIlIllllI;
                }
                
                static {
                    __OBFID = "CL_00000728";
                }
            };
        }
        
        @Override
        protected String func_148210_b(final int llllllllllllllIIIlIIllIlllIlllll) {
            return (llllllllllllllIIIlIIllIlllIlllll == 1) ? "stat.crafted" : ((llllllllllllllIIIlIIllIlllIlllll == 2) ? "stat.used" : "stat.depleted");
        }
        
        static {
            __OBFID = "CL_00000727";
        }
        
        @Override
        protected void drawSlot(final int llllllllllllllIIIlIIllIllllIlIII, final int llllllllllllllIIIlIIllIllllIIlll, final int llllllllllllllIIIlIIllIllllIIllI, final int llllllllllllllIIIlIIllIllllIllll, final int llllllllllllllIIIlIIllIllllIlllI, final int llllllllllllllIIIlIIllIllllIllIl) {
            final StatCrafting llllllllllllllIIIlIIllIllllIllII = this.func_148211_c(llllllllllllllIIIlIIllIllllIlIII);
            final Item llllllllllllllIIIlIIllIllllIlIll = llllllllllllllIIIlIIllIllllIllII.func_150959_a();
            GuiStats.this.drawStatsScreen(llllllllllllllIIIlIIllIllllIIlll + 40, llllllllllllllIIIlIIllIllllIIllI, llllllllllllllIIIlIIllIllllIlIll);
            final int llllllllllllllIIIlIIllIllllIlIlI = Item.getIdFromItem(llllllllllllllIIIlIIllIllllIlIll);
            this.func_148209_a(StatList.objectBreakStats[llllllllllllllIIIlIIllIllllIlIlI], llllllllllllllIIIlIIllIllllIIlll + 115, llllllllllllllIIIlIIllIllllIIllI, llllllllllllllIIIlIIllIllllIlIII % 2 == 0);
            this.func_148209_a(StatList.objectCraftStats[llllllllllllllIIIlIIllIllllIlIlI], llllllllllllllIIIlIIllIllllIIlll + 165, llllllllllllllIIIlIIllIllllIIllI, llllllllllllllIIIlIIllIllllIlIII % 2 == 0);
            this.func_148209_a(llllllllllllllIIIlIIllIllllIllII, llllllllllllllIIIlIIllIllllIIlll + 215, llllllllllllllIIIlIIllIllllIIllI, llllllllllllllIIIlIIllIllllIlIII % 2 == 0);
        }
    }
    
    abstract class Stats extends GuiSlot
    {
        protected /* synthetic */ int field_148218_l;
        protected /* synthetic */ int field_148217_o;
        protected /* synthetic */ Comparator statSorter;
        protected /* synthetic */ int field_148215_p;
        protected /* synthetic */ List statsHolder;
        
        @Override
        protected void func_148142_b(final int llllllllllllllllllIIIlIIIlIIlIll, final int llllllllllllllllllIIIlIIIlIIIIII) {
            if (llllllllllllllllllIIIlIIIlIIIIII >= this.top && llllllllllllllllllIIIlIIIlIIIIII <= this.bottom) {
                final int llllllllllllllllllIIIlIIIlIIlIIl = this.getSlotIndexFromScreenCoords(llllllllllllllllllIIIlIIIlIIlIll, llllllllllllllllllIIIlIIIlIIIIII);
                final int llllllllllllllllllIIIlIIIlIIlIII = this.width / 2 - 92 - 16;
                if (llllllllllllllllllIIIlIIIlIIlIIl >= 0) {
                    if (llllllllllllllllllIIIlIIIlIIlIll < llllllllllllllllllIIIlIIIlIIlIII + 40 || llllllllllllllllllIIIlIIIlIIlIll > llllllllllllllllllIIIlIIIlIIlIII + 40 + 20) {
                        return;
                    }
                    final StatCrafting llllllllllllllllllIIIlIIIlIIIlll = this.func_148211_c(llllllllllllllllllIIIlIIIlIIlIIl);
                    this.func_148213_a(llllllllllllllllllIIIlIIIlIIIlll, llllllllllllllllllIIIlIIIlIIlIll, llllllllllllllllllIIIlIIIlIIIIII);
                }
                else {
                    String llllllllllllllllllIIIlIIIlIIIllI = "";
                    if (llllllllllllllllllIIIlIIIlIIlIll >= llllllllllllllllllIIIlIIIlIIlIII + 115 - 18 && llllllllllllllllllIIIlIIIlIIlIll <= llllllllllllllllllIIIlIIIlIIlIII + 115) {
                        llllllllllllllllllIIIlIIIlIIIllI = this.func_148210_b(0);
                    }
                    else if (llllllllllllllllllIIIlIIIlIIlIll >= llllllllllllllllllIIIlIIIlIIlIII + 165 - 18 && llllllllllllllllllIIIlIIIlIIlIll <= llllllllllllllllllIIIlIIIlIIlIII + 165) {
                        llllllllllllllllllIIIlIIIlIIIllI = this.func_148210_b(1);
                    }
                    else {
                        if (llllllllllllllllllIIIlIIIlIIlIll < llllllllllllllllllIIIlIIIlIIlIII + 215 - 18 || llllllllllllllllllIIIlIIIlIIlIll > llllllllllllllllllIIIlIIIlIIlIII + 215) {
                            return;
                        }
                        llllllllllllllllllIIIlIIIlIIIllI = this.func_148210_b(2);
                    }
                    llllllllllllllllllIIIlIIIlIIIllI = String.valueOf(new StringBuilder().append(I18n.format(llllllllllllllllllIIIlIIIlIIIllI, new Object[0]))).trim();
                    if (llllllllllllllllllIIIlIIIlIIIllI.length() > 0) {
                        final int llllllllllllllllllIIIlIIIlIIIlIl = llllllllllllllllllIIIlIIIlIIlIll + 12;
                        final int llllllllllllllllllIIIlIIIlIIIlII = llllllllllllllllllIIIlIIIlIIIIII - 12;
                        final int llllllllllllllllllIIIlIIIlIIIIll = GuiStats.this.fontRendererObj.getStringWidth(llllllllllllllllllIIIlIIIlIIIllI);
                        Gui.this.drawGradientRect(llllllllllllllllllIIIlIIIlIIIlIl - 3, llllllllllllllllllIIIlIIIlIIIlII - 3, llllllllllllllllllIIIlIIIlIIIlIl + llllllllllllllllllIIIlIIIlIIIIll + 3, llllllllllllllllllIIIlIIIlIIIlII + 8 + 3, -1073741824, -1073741824);
                        GuiStats.this.fontRendererObj.drawStringWithShadow(llllllllllllllllllIIIlIIIlIIIllI, (float)llllllllllllllllllIIIlIIIlIIIlIl, (float)llllllllllllllllllIIIlIIIlIIIlII, -1);
                    }
                }
            }
        }
        
        @Override
        protected boolean isSelected(final int llllllllllllllllllIIIlIIlIIIllII) {
            return false;
        }
        
        protected final StatCrafting func_148211_c(final int llllllllllllllllllIIIlIIIllIlIIl) {
            return this.statsHolder.get(llllllllllllllllllIIIlIIIllIlIIl);
        }
        
        protected void func_148212_h(final int llllllllllllllllllIIIlIIIIIlIIll) {
            if (llllllllllllllllllIIIlIIIIIlIIll != this.field_148217_o) {
                this.field_148217_o = llllllllllllllllllIIIlIIIIIlIIll;
                this.field_148215_p = -1;
            }
            else if (this.field_148215_p == -1) {
                this.field_148215_p = 1;
            }
            else {
                this.field_148217_o = -1;
                this.field_148215_p = 0;
            }
            Collections.sort((List<Object>)this.statsHolder, this.statSorter);
        }
        
        protected void func_148209_a(final StatBase llllllllllllllllllIIIlIIIlIllIlI, final int llllllllllllllllllIIIlIIIlIllIIl, final int llllllllllllllllllIIIlIIIlIllIII, final boolean llllllllllllllllllIIIlIIIlIllllI) {
            if (llllllllllllllllllIIIlIIIlIllIlI != null) {
                final String llllllllllllllllllIIIlIIIlIlllIl = llllllllllllllllllIIIlIIIlIllIlI.func_75968_a(GuiStats.this.field_146546_t.writeStat(llllllllllllllllllIIIlIIIlIllIlI));
                GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllllllIIIlIIIlIlllIl, llllllllllllllllllIIIlIIIlIllIIl - GuiStats.this.fontRendererObj.getStringWidth(llllllllllllllllllIIIlIIIlIlllIl), llllllllllllllllllIIIlIIIlIllIII + 5, llllllllllllllllllIIIlIIIlIllllI ? 16777215 : 9474192);
            }
            else {
                final String llllllllllllllllllIIIlIIIlIlllII = "-";
                GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllllllIIIlIIIlIlllII, llllllllllllllllllIIIlIIIlIllIIl - GuiStats.this.fontRendererObj.getStringWidth(llllllllllllllllllIIIlIIIlIlllII), llllllllllllllllllIIIlIIIlIllIII + 5, llllllllllllllllllIIIlIIIlIllllI ? 16777215 : 9474192);
            }
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllllllIIIlIIlIIlIIIl, final boolean llllllllllllllllllIIIlIIlIIlIIII, final int llllllllllllllllllIIIlIIlIIIllll, final int llllllllllllllllllIIIlIIlIIIlllI) {
        }
        
        @Override
        protected final int getSize() {
            return this.statsHolder.size();
        }
        
        @Override
        protected void drawListHeader(final int llllllllllllllllllIIIlIIIlllllII, final int llllllllllllllllllIIIlIIlIIIIIIl, final Tessellator llllllllllllllllllIIIlIIlIIIIIII) {
            if (!Mouse.isButtonDown(0)) {
                this.field_148218_l = -1;
            }
            if (this.field_148218_l == 0) {
                GuiStats.this.drawSprite(llllllllllllllllllIIIlIIIlllllII + 115 - 18, llllllllllllllllllIIIlIIlIIIIIIl + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllllllIIIlIIIlllllII + 115 - 18, llllllllllllllllllIIIlIIlIIIIIIl + 1, 0, 18);
            }
            if (this.field_148218_l == 1) {
                GuiStats.this.drawSprite(llllllllllllllllllIIIlIIIlllllII + 165 - 18, llllllllllllllllllIIIlIIlIIIIIIl + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllllllIIIlIIIlllllII + 165 - 18, llllllllllllllllllIIIlIIlIIIIIIl + 1, 0, 18);
            }
            if (this.field_148218_l == 2) {
                GuiStats.this.drawSprite(llllllllllllllllllIIIlIIIlllllII + 215 - 18, llllllllllllllllllIIIlIIlIIIIIIl + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllllllIIIlIIIlllllII + 215 - 18, llllllllllllllllllIIIlIIlIIIIIIl + 1, 0, 18);
            }
            if (this.field_148217_o != -1) {
                short llllllllllllllllllIIIlIIIlllllll = 79;
                byte llllllllllllllllllIIIlIIIllllllI = 18;
                if (this.field_148217_o == 1) {
                    llllllllllllllllllIIIlIIIlllllll = 129;
                }
                else if (this.field_148217_o == 2) {
                    llllllllllllllllllIIIlIIIlllllll = 179;
                }
                if (this.field_148215_p == 1) {
                    llllllllllllllllllIIIlIIIllllllI = 36;
                }
                GuiStats.this.drawSprite(llllllllllllllllllIIIlIIIlllllII + llllllllllllllllllIIIlIIIlllllll, llllllllllllllllllIIIlIIlIIIIIIl + 1, llllllllllllllllllIIIlIIIllllllI, 0);
            }
        }
        
        protected void func_148213_a(final StatCrafting llllllllllllllllllIIIlIIIIlIllIl, final int llllllllllllllllllIIIlIIIIlIIIIl, final int llllllllllllllllllIIIlIIIIlIIIII) {
            if (llllllllllllllllllIIIlIIIIlIllIl != null) {
                final Item llllllllllllllllllIIIlIIIIlIlIlI = llllllllllllllllllIIIlIIIIlIllIl.func_150959_a();
                final ItemStack llllllllllllllllllIIIlIIIIlIlIIl = new ItemStack(llllllllllllllllllIIIlIIIIlIlIlI);
                final String llllllllllllllllllIIIlIIIIlIlIII = llllllllllllllllllIIIlIIIIlIlIIl.getUnlocalizedName();
                final String llllllllllllllllllIIIlIIIIlIIlll = String.valueOf(new StringBuilder().append(I18n.format(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllIIIlIIIIlIlIII)).append(".name")), new Object[0]))).trim();
                if (llllllllllllllllllIIIlIIIIlIIlll.length() > 0) {
                    final int llllllllllllllllllIIIlIIIIlIIllI = llllllllllllllllllIIIlIIIIlIIIIl + 12;
                    final int llllllllllllllllllIIIlIIIIlIIlIl = llllllllllllllllllIIIlIIIIlIIIII - 12;
                    final int llllllllllllllllllIIIlIIIIlIIlII = GuiStats.this.fontRendererObj.getStringWidth(llllllllllllllllllIIIlIIIIlIIlll);
                    Gui.this.drawGradientRect(llllllllllllllllllIIIlIIIIlIIllI - 3, llllllllllllllllllIIIlIIIIlIIlIl - 3, llllllllllllllllllIIIlIIIIlIIllI + llllllllllllllllllIIIlIIIIlIIlII + 3, llllllllllllllllllIIIlIIIIlIIlIl + 8 + 3, -1073741824, -1073741824);
                    GuiStats.this.fontRendererObj.drawStringWithShadow(llllllllllllllllllIIIlIIIIlIIlll, (float)llllllllllllllllllIIIlIIIIlIIllI, (float)llllllllllllllllllIIIlIIIIlIIlIl, -1);
                }
            }
        }
        
        @Override
        protected void drawBackground() {
            GuiStats.this.drawDefaultBackground();
        }
        
        protected Stats(final Minecraft llllllllllllllllllIIIlIIlIIlIllI) {
            super(llllllllllllllllllIIIlIIlIIlIllI, GuiStats.this.width, GuiStats.this.height, 32, GuiStats.this.height - 64, 20);
            this.field_148218_l = -1;
            this.field_148217_o = -1;
            this.setShowSelectionBox(false);
            this.setHasListHeader(true, 20);
        }
        
        static {
            __OBFID = "CL_00000730";
        }
        
        protected abstract String func_148210_b(final int p0);
        
        @Override
        protected void func_148132_a(final int llllllllllllllllllIIIlIIIlllIIlI, final int llllllllllllllllllIIIlIIIlllIlII) {
            this.field_148218_l = -1;
            if (llllllllllllllllllIIIlIIIlllIIlI >= 79 && llllllllllllllllllIIIlIIIlllIIlI < 115) {
                this.field_148218_l = 0;
            }
            else if (llllllllllllllllllIIIlIIIlllIIlI >= 129 && llllllllllllllllllIIIlIIIlllIIlI < 165) {
                this.field_148218_l = 1;
            }
            else if (llllllllllllllllllIIIlIIIlllIIlI >= 179 && llllllllllllllllllIIIlIIIlllIIlI < 215) {
                this.field_148218_l = 2;
            }
            if (this.field_148218_l >= 0) {
                this.func_148212_h(this.field_148218_l);
                this.mc.getSoundHandler().playSound(PositionedSoundRecord.createPositionedSoundRecord(new ResourceLocation("gui.button.press"), 1.0f));
            }
        }
    }
    
    class StatsGeneral extends GuiSlot
    {
        @Override
        protected void drawSlot(final int llIIllllIl, final int llIlIIIlIl, final int llIlIIIlII, final int llIlIIIIll, final int llIlIIIIlI, final int llIlIIIIIl) {
            final StatBase llIlIIIIII = StatList.generalStats.get(llIIllllIl);
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llIlIIIIII.getStatName().getUnformattedText(), llIlIIIlIl + 2, llIlIIIlII + 1, (llIIllllIl % 2 == 0) ? 16777215 : 9474192);
            final String llIIllllll = llIlIIIIII.func_75968_a(GuiStats.this.field_146546_t.writeStat(llIlIIIIII));
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llIIllllll, llIlIIIlIl + 2 + 213 - GuiStats.this.fontRendererObj.getStringWidth(llIIllllll), llIlIIIlII + 1, (llIIllllIl % 2 == 0) ? 16777215 : 9474192);
        }
        
        @Override
        protected int getContentHeight() {
            return this.getSize() * 10;
        }
        
        static {
            __OBFID = "CL_00000726";
        }
        
        @Override
        protected void drawBackground() {
            GuiStats.this.drawDefaultBackground();
        }
        
        @Override
        protected boolean isSelected(final int llIlIlIlII) {
            return false;
        }
        
        @Override
        protected int getSize() {
            return StatList.generalStats.size();
        }
        
        public StatsGeneral(final Minecraft llIlIlllll) {
            super(llIlIlllll, GuiStats.this.width, GuiStats.this.height, 32, GuiStats.this.height - 64, 10);
            this.setShowSelectionBox(false);
        }
        
        @Override
        protected void elementClicked(final int llIlIllIIl, final boolean llIlIllIII, final int llIlIlIlll, final int llIlIlIllI) {
        }
    }
    
    class StatsBlock extends Stats
    {
        public StatsBlock(final Minecraft llllllllllllllIlIIllIIIllIlIIlII) {
            super(llllllllllllllIlIIllIIIllIlIIlII);
            this.statsHolder = Lists.newArrayList();
            for (final StatCrafting llllllllllllllIlIIllIIIllIlIIIlI : StatList.objectMineStats) {
                boolean llllllllllllllIlIIllIIIllIlIIIIl = false;
                final int llllllllllllllIlIIllIIIllIlIIIII = Item.getIdFromItem(llllllllllllllIlIIllIIIllIlIIIlI.func_150959_a());
                if (GuiStats.this.field_146546_t.writeStat(llllllllllllllIlIIllIIIllIlIIIlI) > 0) {
                    llllllllllllllIlIIllIIIllIlIIIIl = true;
                }
                else if (StatList.objectUseStats[llllllllllllllIlIIllIIIllIlIIIII] != null && GuiStats.this.field_146546_t.writeStat(StatList.objectUseStats[llllllllllllllIlIIllIIIllIlIIIII]) > 0) {
                    llllllllllllllIlIIllIIIllIlIIIIl = true;
                }
                else if (StatList.objectCraftStats[llllllllllllllIlIIllIIIllIlIIIII] != null && GuiStats.this.field_146546_t.writeStat(StatList.objectCraftStats[llllllllllllllIlIIllIIIllIlIIIII]) > 0) {
                    llllllllllllllIlIIllIIIllIlIIIIl = true;
                }
                if (llllllllllllllIlIIllIIIllIlIIIIl) {
                    this.statsHolder.add(llllllllllllllIlIIllIIIllIlIIIlI);
                }
            }
            this.statSorter = new Comparator() {
                public int compare(final StatCrafting lllllllllllllIllllllllIllllIlIII, final StatCrafting lllllllllllllIllllllllIlllIllllI) {
                    final int lllllllllllllIllllllllIllllIIllI = Item.getIdFromItem(lllllllllllllIllllllllIllllIlIII.func_150959_a());
                    final int lllllllllllllIllllllllIllllIIlIl = Item.getIdFromItem(lllllllllllllIllllllllIlllIllllI.func_150959_a());
                    StatBase lllllllllllllIllllllllIllllIIlII = null;
                    StatBase lllllllllllllIllllllllIllllIIIll = null;
                    if (StatsBlock.this.field_148217_o == 2) {
                        lllllllllllllIllllllllIllllIIlII = StatList.mineBlockStatArray[lllllllllllllIllllllllIllllIIllI];
                        lllllllllllllIllllllllIllllIIIll = StatList.mineBlockStatArray[lllllllllllllIllllllllIllllIIlIl];
                    }
                    else if (StatsBlock.this.field_148217_o == 0) {
                        lllllllllllllIllllllllIllllIIlII = StatList.objectCraftStats[lllllllllllllIllllllllIllllIIllI];
                        lllllllllllllIllllllllIllllIIIll = StatList.objectCraftStats[lllllllllllllIllllllllIllllIIlIl];
                    }
                    else if (StatsBlock.this.field_148217_o == 1) {
                        lllllllllllllIllllllllIllllIIlII = StatList.objectUseStats[lllllllllllllIllllllllIllllIIllI];
                        lllllllllllllIllllllllIllllIIIll = StatList.objectUseStats[lllllllllllllIllllllllIllllIIlIl];
                    }
                    if (lllllllllllllIllllllllIllllIIlII != null || lllllllllllllIllllllllIllllIIIll != null) {
                        if (lllllllllllllIllllllllIllllIIlII == null) {
                            return 1;
                        }
                        if (lllllllllllllIllllllllIllllIIIll == null) {
                            return -1;
                        }
                        final int lllllllllllllIllllllllIllllIIIlI = GuiStats.this.field_146546_t.writeStat(lllllllllllllIllllllllIllllIIlII);
                        final int lllllllllllllIllllllllIllllIIIIl = GuiStats.this.field_146546_t.writeStat(lllllllllllllIllllllllIllllIIIll);
                        if (lllllllllllllIllllllllIllllIIIlI != lllllllllllllIllllllllIllllIIIIl) {
                            return (lllllllllllllIllllllllIllllIIIlI - lllllllllllllIllllllllIllllIIIIl) * StatsBlock.this.field_148215_p;
                        }
                    }
                    return lllllllllllllIllllllllIllllIIllI - lllllllllllllIllllllllIllllIIlIl;
                }
                
                @Override
                public int compare(final Object lllllllllllllIllllllllIlllIlIIII, final Object lllllllllllllIllllllllIlllIIllll) {
                    return this.compare((StatCrafting)lllllllllllllIllllllllIlllIlIIII, (StatCrafting)lllllllllllllIllllllllIlllIIllll);
                }
                
                static {
                    __OBFID = "CL_00000725";
                }
            };
        }
        
        @Override
        protected void drawSlot(final int llllllllllllllIlIIllIIIllIIIIlII, final int llllllllllllllIlIIllIIIllIIIIIll, final int llllllllllllllIlIIllIIIllIIIIIlI, final int llllllllllllllIlIIllIIIllIIIIIIl, final int llllllllllllllIlIIllIIIllIIIIIII, final int llllllllllllllIlIIllIIIlIlllllll) {
            final StatCrafting llllllllllllllIlIIllIIIlIllllllI = this.func_148211_c(llllllllllllllIlIIllIIIllIIIIlII);
            final Item llllllllllllllIlIIllIIIlIlllllIl = llllllllllllllIlIIllIIIlIllllllI.func_150959_a();
            GuiStats.this.drawStatsScreen(llllllllllllllIlIIllIIIllIIIIIll + 40, llllllllllllllIlIIllIIIllIIIIIlI, llllllllllllllIlIIllIIIlIlllllIl);
            final int llllllllllllllIlIIllIIIlIlllllII = Item.getIdFromItem(llllllllllllllIlIIllIIIlIlllllIl);
            this.func_148209_a(StatList.objectCraftStats[llllllllllllllIlIIllIIIlIlllllII], llllllllllllllIlIIllIIIllIIIIIll + 115, llllllllllllllIlIIllIIIllIIIIIlI, llllllllllllllIlIIllIIIllIIIIlII % 2 == 0);
            this.func_148209_a(StatList.objectUseStats[llllllllllllllIlIIllIIIlIlllllII], llllllllllllllIlIIllIIIllIIIIIll + 165, llllllllllllllIlIIllIIIllIIIIIlI, llllllllllllllIlIIllIIIllIIIIlII % 2 == 0);
            this.func_148209_a(llllllllllllllIlIIllIIIlIllllllI, llllllllllllllIlIIllIIIllIIIIIll + 215, llllllllllllllIlIIllIIIllIIIIIlI, llllllllllllllIlIIllIIIllIIIIlII % 2 == 0);
        }
        
        static {
            __OBFID = "CL_00000724";
        }
        
        @Override
        protected void drawListHeader(final int llllllllllllllIlIIllIIIllIIIllll, final int llllllllllllllIlIIllIIIllIIIlllI, final Tessellator llllllllllllllIlIIllIIIllIIlIIIl) {
            super.drawListHeader(llllllllllllllIlIIllIIIllIIIllll, llllllllllllllIlIIllIIIllIIIlllI, llllllllllllllIlIIllIIIllIIlIIIl);
            if (this.field_148218_l == 0) {
                GuiStats.this.drawSprite(llllllllllllllIlIIllIIIllIIIllll + 115 - 18 + 1, llllllllllllllIlIIllIIIllIIIlllI + 1 + 1, 18, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIlIIllIIIllIIIllll + 115 - 18, llllllllllllllIlIIllIIIllIIIlllI + 1, 18, 18);
            }
            if (this.field_148218_l == 1) {
                GuiStats.this.drawSprite(llllllllllllllIlIIllIIIllIIIllll + 165 - 18 + 1, llllllllllllllIlIIllIIIllIIIlllI + 1 + 1, 36, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIlIIllIIIllIIIllll + 165 - 18, llllllllllllllIlIIllIIIllIIIlllI + 1, 36, 18);
            }
            if (this.field_148218_l == 2) {
                GuiStats.this.drawSprite(llllllllllllllIlIIllIIIllIIIllll + 215 - 18 + 1, llllllllllllllIlIIllIIIllIIIlllI + 1 + 1, 54, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIlIIllIIIllIIIllll + 215 - 18, llllllllllllllIlIIllIIIllIIIlllI + 1, 54, 18);
            }
        }
        
        @Override
        protected String func_148210_b(final int llllllllllllllIlIIllIIIlIlllIIIl) {
            return (llllllllllllllIlIIllIIIlIlllIIIl == 0) ? "stat.crafted" : ((llllllllllllllIlIIllIIIlIlllIIIl == 1) ? "stat.used" : "stat.mined");
        }
    }
    
    class StatsMobsList extends GuiSlot
    {
        private final /* synthetic */ List field_148222_l;
        
        @Override
        protected boolean isSelected(final int llllllllllllllIIlIllllllIlIIIlll) {
            return false;
        }
        
        @Override
        protected int getContentHeight() {
            return this.getSize() * GuiStats.this.fontRendererObj.FONT_HEIGHT * 4;
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllIIlIllllllIlIIllII, final boolean llllllllllllllIIlIllllllIlIIlIll, final int llllllllllllllIIlIllllllIlIIlIlI, final int llllllllllllllIIlIllllllIlIIlIIl) {
        }
        
        public StatsMobsList(final Minecraft llllllllllllllIIlIllllllIlIlIIll) {
            super(llllllllllllllIIlIllllllIlIlIIll, GuiStats.this.width, GuiStats.this.height, 32, GuiStats.this.height - 64, GuiStats.this.fontRendererObj.FONT_HEIGHT * 4);
            this.field_148222_l = Lists.newArrayList();
            this.setShowSelectionBox(false);
            for (final EntityList.EntityEggInfo llllllllllllllIIlIllllllIlIlIllI : EntityList.entityEggs.values()) {
                if (GuiStats.this.field_146546_t.writeStat(llllllllllllllIIlIllllllIlIlIllI.field_151512_d) > 0 || GuiStats.this.field_146546_t.writeStat(llllllllllllllIIlIllllllIlIlIllI.field_151513_e) > 0) {
                    this.field_148222_l.add(llllllllllllllIIlIllllllIlIlIllI);
                }
            }
        }
        
        @Override
        protected void drawSlot(final int llllllllllllllIIlIllllllIIlIlIII, final int llllllllllllllIIlIllllllIIllIlII, final int llllllllllllllIIlIllllllIIllIIll, final int llllllllllllllIIlIllllllIIllIIlI, final int llllllllllllllIIlIllllllIIllIIIl, final int llllllllllllllIIlIllllllIIllIIII) {
            final EntityList.EntityEggInfo llllllllllllllIIlIllllllIIlIllll = this.field_148222_l.get(llllllllllllllIIlIllllllIIlIlIII);
            final String llllllllllllllIIlIllllllIIlIlllI = I18n.format(String.valueOf(new StringBuilder("entity.").append(EntityList.getStringFromID(llllllllllllllIIlIllllllIIlIllll.spawnedID)).append(".name")), new Object[0]);
            final int llllllllllllllIIlIllllllIIlIllIl = GuiStats.this.field_146546_t.writeStat(llllllllllllllIIlIllllllIIlIllll.field_151512_d);
            final int llllllllllllllIIlIllllllIIlIllII = GuiStats.this.field_146546_t.writeStat(llllllllllllllIIlIllllllIIlIllll.field_151513_e);
            String llllllllllllllIIlIllllllIIlIlIll = I18n.format("stat.entityKills", llllllllllllllIIlIllllllIIlIllIl, llllllllllllllIIlIllllllIIlIlllI);
            String llllllllllllllIIlIllllllIIlIlIlI = I18n.format("stat.entityKilledBy", llllllllllllllIIlIllllllIIlIlllI, llllllllllllllIIlIllllllIIlIllII);
            if (llllllllllllllIIlIllllllIIlIllIl == 0) {
                llllllllllllllIIlIllllllIIlIlIll = I18n.format("stat.entityKills.none", llllllllllllllIIlIllllllIIlIlllI);
            }
            if (llllllllllllllIIlIllllllIIlIllII == 0) {
                llllllllllllllIIlIllllllIIlIlIlI = I18n.format("stat.entityKilledBy.none", llllllllllllllIIlIllllllIIlIlllI);
            }
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllIIlIllllllIIlIlllI, llllllllllllllIIlIllllllIIllIlII + 2 - 10, llllllllllllllIIlIllllllIIllIIll + 1, 16777215);
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllIIlIllllllIIlIlIll, llllllllllllllIIlIllllllIIllIlII + 2, llllllllllllllIIlIllllllIIllIIll + 1 + GuiStats.this.fontRendererObj.FONT_HEIGHT, (llllllllllllllIIlIllllllIIlIllIl == 0) ? 6316128 : 9474192);
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllIIlIllllllIIlIlIlI, llllllllllllllIIlIllllllIIllIlII + 2, llllllllllllllIIlIllllllIIllIIll + 1 + GuiStats.this.fontRendererObj.FONT_HEIGHT * 2, (llllllllllllllIIlIllllllIIlIllII == 0) ? 6316128 : 9474192);
        }
        
        @Override
        protected int getSize() {
            return this.field_148222_l.size();
        }
        
        static {
            __OBFID = "CL_00000729";
        }
        
        @Override
        protected void drawBackground() {
            GuiStats.this.drawDefaultBackground();
        }
    }
}
