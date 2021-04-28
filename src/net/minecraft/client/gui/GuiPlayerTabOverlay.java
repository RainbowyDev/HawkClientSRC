package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.client.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.scoreboard.*;
import java.util.*;
import com.google.common.collect.*;

public class GuiPlayerTabOverlay extends Gui
{
    private /* synthetic */ IChatComponent header;
    private final /* synthetic */ GuiIngame field_175251_g;
    private /* synthetic */ IChatComponent footer;
    private final /* synthetic */ Minecraft field_175250_f;
    private static final /* synthetic */ Ordering field_175252_a;
    private /* synthetic */ long field_175253_j;
    private /* synthetic */ boolean field_175254_k;
    
    public void setHeader(final IChatComponent llllllllllllllIIIllIlllIIIIlIIll) {
        this.header = llllllllllllllIIIllIlllIIIIlIIll;
    }
    
    public void setFooter(final IChatComponent llllllllllllllIIIllIlllIIIIllIIl) {
        this.footer = llllllllllllllIIIllIlllIIIIllIIl;
    }
    
    private void func_175247_a(final ScoreObjective llllllllllllllIIIllIlllIIIlIlIlI, final int llllllllllllllIIIllIlllIIIlIlIIl, final String llllllllllllllIIIllIlllIIIlllIIl, final int llllllllllllllIIIllIlllIIIlllIII, final int llllllllllllllIIIllIlllIIIlIIllI, final NetworkPlayerInfo llllllllllllllIIIllIlllIIIlIIlIl) {
        final int llllllllllllllIIIllIlllIIIllIlIl = llllllllllllllIIIllIlllIIIlIlIlI.getScoreboard().getValueFromObjective(llllllllllllllIIIllIlllIIIlllIIl, llllllllllllllIIIllIlllIIIlIlIlI).getScorePoints();
        if (llllllllllllllIIIllIlllIIIlIlIlI.func_178766_e() == IScoreObjectiveCriteria.EnumRenderType.HEARTS) {
            this.field_175250_f.getTextureManager().bindTexture(GuiPlayerTabOverlay.icons);
            if (this.field_175253_j == llllllllllllllIIIllIlllIIIlIIlIl.func_178855_p()) {
                if (llllllllllllllIIIllIlllIIIllIlIl < llllllllllllllIIIllIlllIIIlIIlIl.func_178835_l()) {
                    llllllllllllllIIIllIlllIIIlIIlIl.func_178846_a(Minecraft.getSystemTime());
                    llllllllllllllIIIllIlllIIIlIIlIl.func_178844_b(this.field_175251_g.getUpdateCounter() + 20);
                }
                else if (llllllllllllllIIIllIlllIIIllIlIl > llllllllllllllIIIllIlllIIIlIIlIl.func_178835_l()) {
                    llllllllllllllIIIllIlllIIIlIIlIl.func_178846_a(Minecraft.getSystemTime());
                    llllllllllllllIIIllIlllIIIlIIlIl.func_178844_b(this.field_175251_g.getUpdateCounter() + 10);
                }
            }
            if (Minecraft.getSystemTime() - llllllllllllllIIIllIlllIIIlIIlIl.func_178847_n() > 1000L || this.field_175253_j != llllllllllllllIIIllIlllIIIlIIlIl.func_178855_p()) {
                llllllllllllllIIIllIlllIIIlIIlIl.func_178836_b(llllllllllllllIIIllIlllIIIllIlIl);
                llllllllllllllIIIllIlllIIIlIIlIl.func_178857_c(llllllllllllllIIIllIlllIIIllIlIl);
                llllllllllllllIIIllIlllIIIlIIlIl.func_178846_a(Minecraft.getSystemTime());
            }
            llllllllllllllIIIllIlllIIIlIIlIl.func_178843_c(this.field_175253_j);
            llllllllllllllIIIllIlllIIIlIIlIl.func_178836_b(llllllllllllllIIIllIlllIIIllIlIl);
            final int llllllllllllllIIIllIlllIIIllIlII = MathHelper.ceiling_float_int(Math.max(llllllllllllllIIIllIlllIIIllIlIl, llllllllllllllIIIllIlllIIIlIIlIl.func_178860_m()) / 2.0f);
            final int llllllllllllllIIIllIlllIIIllIIll = Math.max(MathHelper.ceiling_float_int((float)(llllllllllllllIIIllIlllIIIllIlIl / 2)), Math.max(MathHelper.ceiling_float_int((float)(llllllllllllllIIIllIlllIIIlIIlIl.func_178860_m() / 2)), 10));
            final boolean llllllllllllllIIIllIlllIIIllIIlI = llllllllllllllIIIllIlllIIIlIIlIl.func_178858_o() > this.field_175251_g.getUpdateCounter() && (llllllllllllllIIIllIlllIIIlIIlIl.func_178858_o() - this.field_175251_g.getUpdateCounter()) / 3L % 2L == 1L;
            if (llllllllllllllIIIllIlllIIIllIlII > 0) {
                final float llllllllllllllIIIllIlllIIIllIIIl = Math.min((llllllllllllllIIIllIlllIIIlIIllI - llllllllllllllIIIllIlllIIIlllIII - 4) / (float)llllllllllllllIIIllIlllIIIllIIll, 9.0f);
                if (llllllllllllllIIIllIlllIIIllIIIl > 3.0f) {
                    for (int llllllllllllllIIIllIlllIIIllIIII = llllllllllllllIIIllIlllIIIllIlII; llllllllllllllIIIllIlllIIIllIIII < llllllllllllllIIIllIlllIIIllIIll; ++llllllllllllllIIIllIlllIIIllIIII) {
                        this.func_175174_a(llllllllllllllIIIllIlllIIIlllIII + llllllllllllllIIIllIlllIIIllIIII * llllllllllllllIIIllIlllIIIllIIIl, (float)llllllllllllllIIIllIlllIIIlIlIIl, llllllllllllllIIIllIlllIIIllIIlI ? 25 : 16, 0, 9, 9);
                    }
                    for (int llllllllllllllIIIllIlllIIIllIIII = 0; llllllllllllllIIIllIlllIIIllIIII < llllllllllllllIIIllIlllIIIllIlII; ++llllllllllllllIIIllIlllIIIllIIII) {
                        this.func_175174_a(llllllllllllllIIIllIlllIIIlllIII + llllllllllllllIIIllIlllIIIllIIII * llllllllllllllIIIllIlllIIIllIIIl, (float)llllllllllllllIIIllIlllIIIlIlIIl, llllllllllllllIIIllIlllIIIllIIlI ? 25 : 16, 0, 9, 9);
                        if (llllllllllllllIIIllIlllIIIllIIlI) {
                            if (llllllllllllllIIIllIlllIIIllIIII * 2 + 1 < llllllllllllllIIIllIlllIIIlIIlIl.func_178860_m()) {
                                this.func_175174_a(llllllllllllllIIIllIlllIIIlllIII + llllllllllllllIIIllIlllIIIllIIII * llllllllllllllIIIllIlllIIIllIIIl, (float)llllllllllllllIIIllIlllIIIlIlIIl, 70, 0, 9, 9);
                            }
                            if (llllllllllllllIIIllIlllIIIllIIII * 2 + 1 == llllllllllllllIIIllIlllIIIlIIlIl.func_178860_m()) {
                                this.func_175174_a(llllllllllllllIIIllIlllIIIlllIII + llllllllllllllIIIllIlllIIIllIIII * llllllllllllllIIIllIlllIIIllIIIl, (float)llllllllllllllIIIllIlllIIIlIlIIl, 79, 0, 9, 9);
                            }
                        }
                        if (llllllllllllllIIIllIlllIIIllIIII * 2 + 1 < llllllllllllllIIIllIlllIIIllIlIl) {
                            this.func_175174_a(llllllllllllllIIIllIlllIIIlllIII + llllllllllllllIIIllIlllIIIllIIII * llllllllllllllIIIllIlllIIIllIIIl, (float)llllllllllllllIIIllIlllIIIlIlIIl, (llllllllllllllIIIllIlllIIIllIIII >= 10) ? 160 : 52, 0, 9, 9);
                        }
                        if (llllllllllllllIIIllIlllIIIllIIII * 2 + 1 == llllllllllllllIIIllIlllIIIllIlIl) {
                            this.func_175174_a(llllllllllllllIIIllIlllIIIlllIII + llllllllllllllIIIllIlllIIIllIIII * llllllllllllllIIIllIlllIIIllIIIl, (float)llllllllllllllIIIllIlllIIIlIlIIl, (llllllllllllllIIIllIlllIIIllIIII >= 10) ? 169 : 61, 0, 9, 9);
                        }
                    }
                }
                else {
                    final float llllllllllllllIIIllIlllIIIlIllll = MathHelper.clamp_float(llllllllllllllIIIllIlllIIIllIlIl / 20.0f, 0.0f, 1.0f);
                    final int llllllllllllllIIIllIlllIIIlIlllI = (int)((1.0f - llllllllllllllIIIllIlllIIIlIllll) * 255.0f) << 16 | (int)(llllllllllllllIIIllIlllIIIlIllll * 255.0f) << 8;
                    String llllllllllllllIIIllIlllIIIlIllIl = String.valueOf(new StringBuilder().append(llllllllllllllIIIllIlllIIIllIlIl / 2.0f));
                    if (llllllllllllllIIIllIlllIIIlIIllI - this.field_175250_f.fontRendererObj.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIllIlllIIIlIllIl)).append("hp"))) >= llllllllllllllIIIllIlllIIIlllIII) {
                        llllllllllllllIIIllIlllIIIlIllIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIllIlllIIIlIllIl)).append("hp"));
                    }
                    this.field_175250_f.fontRendererObj.drawStringWithShadow(llllllllllllllIIIllIlllIIIlIllIl, (float)((llllllllllllllIIIllIlllIIIlIIllI + llllllllllllllIIIllIlllIIIlllIII) / 2 - this.field_175250_f.fontRendererObj.getStringWidth(llllllllllllllIIIllIlllIIIlIllIl) / 2), (float)llllllllllllllIIIllIlllIIIlIlIIl, llllllllllllllIIIllIlllIIIlIlllI);
                }
            }
        }
        else {
            final String llllllllllllllIIIllIlllIIIlIllII = String.valueOf(new StringBuilder().append(EnumChatFormatting.YELLOW).append(llllllllllllllIIIllIlllIIIllIlIl));
            this.field_175250_f.fontRendererObj.drawStringWithShadow(llllllllllllllIIIllIlllIIIlIllII, (float)(llllllllllllllIIIllIlllIIIlIIllI - this.field_175250_f.fontRendererObj.getStringWidth(llllllllllllllIIIllIlllIIIlIllII)), (float)llllllllllllllIIIllIlllIIIlIlIIl, 16777215);
        }
    }
    
    public void func_175246_a(final boolean llllllllllllllIIIllIlllIllIlIIll) {
        if (llllllllllllllIIIllIlllIllIlIIll && !this.field_175254_k) {
            this.field_175253_j = Minecraft.getSystemTime();
        }
        this.field_175254_k = llllllllllllllIIIllIlllIllIlIIll;
    }
    
    public void func_175249_a(final int llllllllllllllIIIllIlllIlIllIIlI, final Scoreboard llllllllllllllIIIllIlllIlIIIIlIl, final ScoreObjective llllllllllllllIIIllIlllIlIIIIlII) {
        final NetHandlerPlayClient llllllllllllllIIIllIlllIlIlIllll = this.field_175250_f.thePlayer.sendQueue;
        List llllllllllllllIIIllIlllIlIlIlllI = GuiPlayerTabOverlay.field_175252_a.sortedCopy((Iterable)llllllllllllllIIIllIlllIlIlIllll.func_175106_d());
        int llllllllllllllIIIllIlllIlIlIllIl = 0;
        int llllllllllllllIIIllIlllIlIlIllII = 0;
        for (final NetworkPlayerInfo llllllllllllllIIIllIlllIlIlIlIII : llllllllllllllIIIllIlllIlIlIlllI) {
            int llllllllllllllIIIllIlllIlIlIlIlI = this.field_175250_f.fontRendererObj.getStringWidth(this.func_175243_a(llllllllllllllIIIllIlllIlIlIlIII));
            llllllllllllllIIIllIlllIlIlIllIl = Math.max(llllllllllllllIIIllIlllIlIlIllIl, llllllllllllllIIIllIlllIlIlIlIlI);
            if (llllllllllllllIIIllIlllIlIIIIlII != null && llllllllllllllIIIllIlllIlIIIIlII.func_178766_e() != IScoreObjectiveCriteria.EnumRenderType.HEARTS) {
                llllllllllllllIIIllIlllIlIlIlIlI = this.field_175250_f.fontRendererObj.getStringWidth(String.valueOf(new StringBuilder(" ").append(llllllllllllllIIIllIlllIlIIIIlIl.getValueFromObjective(llllllllllllllIIIllIlllIlIlIlIII.func_178845_a().getName(), llllllllllllllIIIllIlllIlIIIIlII).getScorePoints())));
                llllllllllllllIIIllIlllIlIlIllII = Math.max(llllllllllllllIIIllIlllIlIlIllII, llllllllllllllIIIllIlllIlIlIlIlI);
            }
        }
        llllllllllllllIIIllIlllIlIlIlllI = llllllllllllllIIIllIlllIlIlIlllI.subList(0, Math.min(llllllllllllllIIIllIlllIlIlIlllI.size(), 80));
        int llllllllllllllIIIllIlllIlIlIIllI;
        int llllllllllllllIIIllIlllIlIlIIlll;
        int llllllllllllllIIIllIlllIlIlIlIIl;
        for (llllllllllllllIIIllIlllIlIlIIlll = (llllllllllllllIIIllIlllIlIlIIllI = llllllllllllllIIIllIlllIlIlIlllI.size()), llllllllllllllIIIllIlllIlIlIlIIl = 1; llllllllllllllIIIllIlllIlIlIIllI > 20; llllllllllllllIIIllIlllIlIlIIllI = (llllllllllllllIIIllIlllIlIlIIlll + llllllllllllllIIIllIlllIlIlIlIIl - 1) / llllllllllllllIIIllIlllIlIlIlIIl) {
            ++llllllllllllllIIIllIlllIlIlIlIIl;
        }
        final boolean llllllllllllllIIIllIlllIlIlIIlIl = this.field_175250_f.isIntegratedServerRunning() || this.field_175250_f.getNetHandler().getNetworkManager().func_179292_f();
        int llllllllllllllIIIllIlllIlIlIIIlI = 0;
        if (llllllllllllllIIIllIlllIlIIIIlII != null) {
            if (llllllllllllllIIIllIlllIlIIIIlII.func_178766_e() == IScoreObjectiveCriteria.EnumRenderType.HEARTS) {
                final int llllllllllllllIIIllIlllIlIlIIlII = 90;
            }
            else {
                final int llllllllllllllIIIllIlllIlIlIIIll = llllllllllllllIIIllIlllIlIlIllII;
            }
        }
        else {
            llllllllllllllIIIllIlllIlIlIIIlI = 0;
        }
        final int llllllllllllllIIIllIlllIlIlIIIIl = Math.min(llllllllllllllIIIllIlllIlIlIlIIl * ((llllllllllllllIIIllIlllIlIlIIlIl ? 9 : 0) + llllllllllllllIIIllIlllIlIlIllIl + llllllllllllllIIIllIlllIlIlIIIlI + 13), llllllllllllllIIIllIlllIlIllIIlI - 50) / llllllllllllllIIIllIlllIlIlIlIIl;
        final int llllllllllllllIIIllIlllIlIlIIIII = llllllllllllllIIIllIlllIlIllIIlI / 2 - (llllllllllllllIIIllIlllIlIlIIIIl * llllllllllllllIIIllIlllIlIlIlIIl + (llllllllllllllIIIllIlllIlIlIlIIl - 1) * 5) / 2;
        int llllllllllllllIIIllIlllIlIIlllll = 10;
        int llllllllllllllIIIllIlllIlIIllllI = llllllllllllllIIIllIlllIlIlIIIIl * llllllllllllllIIIllIlllIlIlIlIIl + (llllllllllllllIIIllIlllIlIlIlIIl - 1) * 5;
        List llllllllllllllIIIllIlllIlIIlllIl = null;
        List llllllllllllllIIIllIlllIlIIlllII = null;
        if (this.header != null) {
            llllllllllllllIIIllIlllIlIIlllIl = this.field_175250_f.fontRendererObj.listFormattedStringToWidth(this.header.getFormattedText(), llllllllllllllIIIllIlllIlIllIIlI - 50);
            for (final String llllllllllllllIIIllIlllIlIIlIlll : llllllllllllllIIIllIlllIlIIlllIl) {
                llllllllllllllIIIllIlllIlIIllllI = Math.max(llllllllllllllIIIllIlllIlIIllllI, this.field_175250_f.fontRendererObj.getStringWidth(llllllllllllllIIIllIlllIlIIlIlll));
            }
        }
        if (this.footer != null) {
            llllllllllllllIIIllIlllIlIIlllII = this.field_175250_f.fontRendererObj.listFormattedStringToWidth(this.footer.getFormattedText(), llllllllllllllIIIllIlllIlIllIIlI - 50);
            for (final String llllllllllllllIIIllIlllIlIIlIllI : llllllllllllllIIIllIlllIlIIlllII) {
                llllllllllllllIIIllIlllIlIIllllI = Math.max(llllllllllllllIIIllIlllIlIIllllI, this.field_175250_f.fontRendererObj.getStringWidth(llllllllllllllIIIllIlllIlIIlIllI));
            }
        }
        if (llllllllllllllIIIllIlllIlIIlllIl != null) {
            Gui.drawRect(llllllllllllllIIIllIlllIlIllIIlI / 2 - llllllllllllllIIIllIlllIlIIllllI / 2 - 1, llllllllllllllIIIllIlllIlIIlllll - 1, llllllllllllllIIIllIlllIlIllIIlI / 2 + llllllllllllllIIIllIlllIlIIllllI / 2 + 1, llllllllllllllIIIllIlllIlIIlllll + llllllllllllllIIIllIlllIlIIlllIl.size() * this.field_175250_f.fontRendererObj.FONT_HEIGHT, Integer.MIN_VALUE);
            for (final String llllllllllllllIIIllIlllIlIIlIlIl : llllllllllllllIIIllIlllIlIIlllIl) {
                final int llllllllllllllIIIllIlllIlIIlIIll = this.field_175250_f.fontRendererObj.getStringWidth(llllllllllllllIIIllIlllIlIIlIlIl);
                this.field_175250_f.fontRendererObj.drawStringWithShadow(llllllllllllllIIIllIlllIlIIlIlIl, (float)(llllllllllllllIIIllIlllIlIllIIlI / 2 - llllllllllllllIIIllIlllIlIIlIIll / 2), (float)llllllllllllllIIIllIlllIlIIlllll, -1);
                llllllllllllllIIIllIlllIlIIlllll += this.field_175250_f.fontRendererObj.FONT_HEIGHT;
            }
            ++llllllllllllllIIIllIlllIlIIlllll;
        }
        Gui.drawRect(llllllllllllllIIIllIlllIlIllIIlI / 2 - llllllllllllllIIIllIlllIlIIllllI / 2 - 1, llllllllllllllIIIllIlllIlIIlllll - 1, llllllllllllllIIIllIlllIlIllIIlI / 2 + llllllllllllllIIIllIlllIlIIllllI / 2 + 1, llllllllllllllIIIllIlllIlIIlllll + llllllllllllllIIIllIlllIlIlIIllI * 9, Integer.MIN_VALUE);
        for (int llllllllllllllIIIllIlllIlIIlIIII = 0; llllllllllllllIIIllIlllIlIIlIIII < llllllllllllllIIIllIlllIlIlIIlll; ++llllllllllllllIIIllIlllIlIIlIIII) {
            final int llllllllllllllIIIllIlllIlIIIllll = llllllllllllllIIIllIlllIlIIlIIII / llllllllllllllIIIllIlllIlIlIIllI;
            final int llllllllllllllIIIllIlllIlIIlIIlI = llllllllllllllIIIllIlllIlIIlIIII % llllllllllllllIIIllIlllIlIlIIllI;
            int llllllllllllllIIIllIlllIlIIIlllI = llllllllllllllIIIllIlllIlIlIIIII + llllllllllllllIIIllIlllIlIIIllll * llllllllllllllIIIllIlllIlIlIIIIl + llllllllllllllIIIllIlllIlIIIllll * 5;
            final int llllllllllllllIIIllIlllIlIIIllIl = llllllllllllllIIIllIlllIlIIlllll + llllllllllllllIIIllIlllIlIIlIIlI * 9;
            Gui.drawRect(llllllllllllllIIIllIlllIlIIIlllI, llllllllllllllIIIllIlllIlIIIllIl, llllllllllllllIIIllIlllIlIIIlllI + llllllllllllllIIIllIlllIlIlIIIIl, llllllllllllllIIIllIlllIlIIIllIl + 8, 553648127);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            if (llllllllllllllIIIllIlllIlIIlIIII < llllllllllllllIIIllIlllIlIlIlllI.size()) {
                final NetworkPlayerInfo llllllllllllllIIIllIlllIlIIIllII = llllllllllllllIIIllIlllIlIlIlllI.get(llllllllllllllIIIllIlllIlIIlIIII);
                String llllllllllllllIIIllIlllIlIIIlIll = this.func_175243_a(llllllllllllllIIIllIlllIlIIIllII);
                if (llllllllllllllIIIllIlllIlIlIIlIl) {
                    this.field_175250_f.getTextureManager().bindTexture(llllllllllllllIIIllIlllIlIIIllII.func_178837_g());
                    Gui.drawScaledCustomSizeModalRect(llllllllllllllIIIllIlllIlIIIlllI, llllllllllllllIIIllIlllIlIIIllIl, 8.0f, 8.0f, 8, 8, 8, 8, 64.0f, 64.0f);
                    final EntityPlayer llllllllllllllIIIllIlllIlIIIlIlI = this.field_175250_f.theWorld.getPlayerEntityByUUID(llllllllllllllIIIllIlllIlIIIllII.func_178845_a().getId());
                    if (llllllllllllllIIIllIlllIlIIIlIlI != null && llllllllllllllIIIllIlllIlIIIlIlI.func_175148_a(EnumPlayerModelParts.HAT)) {
                        Gui.drawScaledCustomSizeModalRect(llllllllllllllIIIllIlllIlIIIlllI, llllllllllllllIIIllIlllIlIIIllIl, 40.0f, 8.0f, 8, 8, 8, 8, 64.0f, 64.0f);
                    }
                    llllllllllllllIIIllIlllIlIIIlllI += 9;
                }
                if (llllllllllllllIIIllIlllIlIIIllII.getGameType() == WorldSettings.GameType.SPECTATOR) {
                    llllllllllllllIIIllIlllIlIIIlIll = String.valueOf(new StringBuilder().append(EnumChatFormatting.ITALIC).append(llllllllllllllIIIllIlllIlIIIlIll));
                    this.field_175250_f.fontRendererObj.drawStringWithShadow(llllllllllllllIIIllIlllIlIIIlIll, (float)llllllllllllllIIIllIlllIlIIIlllI, (float)llllllllllllllIIIllIlllIlIIIllIl, -1862270977);
                }
                else {
                    this.field_175250_f.fontRendererObj.drawStringWithShadow(llllllllllllllIIIllIlllIlIIIlIll, (float)llllllllllllllIIIllIlllIlIIIlllI, (float)llllllllllllllIIIllIlllIlIIIllIl, -1);
                }
                if (llllllllllllllIIIllIlllIlIIIIlII != null && llllllllllllllIIIllIlllIlIIIllII.getGameType() != WorldSettings.GameType.SPECTATOR) {
                    final int llllllllllllllIIIllIlllIlIIIlIIl = llllllllllllllIIIllIlllIlIIIlllI + llllllllllllllIIIllIlllIlIlIllIl + 1;
                    final int llllllllllllllIIIllIlllIlIIIlIII = llllllllllllllIIIllIlllIlIIIlIIl + llllllllllllllIIIllIlllIlIlIIIlI;
                    if (llllllllllllllIIIllIlllIlIIIlIII - llllllllllllllIIIllIlllIlIIIlIIl > 5) {
                        this.func_175247_a(llllllllllllllIIIllIlllIlIIIIlII, llllllllllllllIIIllIlllIlIIIllIl, llllllllllllllIIIllIlllIlIIIllII.func_178845_a().getName(), llllllllllllllIIIllIlllIlIIIlIIl, llllllllllllllIIIllIlllIlIIIlIII, llllllllllllllIIIllIlllIlIIIllII);
                    }
                }
                this.func_175245_a(llllllllllllllIIIllIlllIlIlIIIIl, llllllllllllllIIIllIlllIlIIIlllI - (llllllllllllllIIIllIlllIlIlIIlIl ? 9 : 0), llllllllllllllIIIllIlllIlIIIllIl, llllllllllllllIIIllIlllIlIIIllII);
            }
        }
        if (llllllllllllllIIIllIlllIlIIlllII != null) {
            llllllllllllllIIIllIlllIlIIlllll += llllllllllllllIIIllIlllIlIlIIllI * 9 + 1;
            Gui.drawRect(llllllllllllllIIIllIlllIlIllIIlI / 2 - llllllllllllllIIIllIlllIlIIllllI / 2 - 1, llllllllllllllIIIllIlllIlIIlllll - 1, llllllllllllllIIIllIlllIlIllIIlI / 2 + llllllllllllllIIIllIlllIlIIllllI / 2 + 1, llllllllllllllIIIllIlllIlIIlllll + llllllllllllllIIIllIlllIlIIlllII.size() * this.field_175250_f.fontRendererObj.FONT_HEIGHT, Integer.MIN_VALUE);
            for (final String llllllllllllllIIIllIlllIlIIlIlII : llllllllllllllIIIllIlllIlIIlllII) {
                final int llllllllllllllIIIllIlllIlIIlIIIl = this.field_175250_f.fontRendererObj.getStringWidth(llllllllllllllIIIllIlllIlIIlIlII);
                this.field_175250_f.fontRendererObj.drawStringWithShadow(llllllllllllllIIIllIlllIlIIlIlII, (float)(llllllllllllllIIIllIlllIlIllIIlI / 2 - llllllllllllllIIIllIlllIlIIlIIIl / 2), (float)llllllllllllllIIIllIlllIlIIlllll, -1);
                llllllllllllllIIIllIlllIlIIlllll += this.field_175250_f.fontRendererObj.FONT_HEIGHT;
            }
        }
    }
    
    public GuiPlayerTabOverlay(final Minecraft llllllllllllllIIIllIlllIlllIIIIl, final GuiIngame llllllllllllllIIIllIlllIllIlllIl) {
        this.field_175250_f = llllllllllllllIIIllIlllIlllIIIIl;
        this.field_175251_g = llllllllllllllIIIllIlllIllIlllIl;
    }
    
    protected void func_175245_a(final int llllllllllllllIIIllIlllIIlIlIIlI, final int llllllllllllllIIIllIlllIIlIlIIIl, final int llllllllllllllIIIllIlllIIlIlllIl, final NetworkPlayerInfo llllllllllllllIIIllIlllIIlIIllll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_175250_f.getTextureManager().bindTexture(GuiPlayerTabOverlay.icons);
        final byte llllllllllllllIIIllIlllIIlIllIll = 0;
        final boolean llllllllllllllIIIllIlllIIlIllIlI = false;
        byte llllllllllllllIIIllIlllIIlIlIlII = 0;
        if (llllllllllllllIIIllIlllIIlIIllll.getResponseTime() < 0) {
            final byte llllllllllllllIIIllIlllIIlIllIIl = 5;
        }
        else if (llllllllllllllIIIllIlllIIlIIllll.getResponseTime() < 150) {
            final byte llllllllllllllIIIllIlllIIlIllIII = 0;
        }
        else if (llllllllllllllIIIllIlllIIlIIllll.getResponseTime() < 300) {
            final byte llllllllllllllIIIllIlllIIlIlIlll = 1;
        }
        else if (llllllllllllllIIIllIlllIIlIIllll.getResponseTime() < 600) {
            final byte llllllllllllllIIIllIlllIIlIlIllI = 2;
        }
        else if (llllllllllllllIIIllIlllIIlIIllll.getResponseTime() < 1000) {
            final byte llllllllllllllIIIllIlllIIlIlIlIl = 3;
        }
        else {
            llllllllllllllIIIllIlllIIlIlIlII = 4;
        }
        this.zLevel += 100.0f;
        this.drawTexturedModalRect(llllllllllllllIIIllIlllIIlIlIIIl + llllllllllllllIIIllIlllIIlIlIIlI - 11, llllllllllllllIIIllIlllIIlIlllIl, 0 + llllllllllllllIIIllIlllIIlIllIll * 10, 176 + llllllllllllllIIIllIlllIIlIlIlII * 8, 10, 8);
        this.zLevel -= 100.0f;
    }
    
    public String func_175243_a(final NetworkPlayerInfo llllllllllllllIIIllIlllIllIllIlI) {
        return (llllllllllllllIIIllIlllIllIllIlI.func_178854_k() != null) ? llllllllllllllIIIllIlllIllIllIlI.func_178854_k().getFormattedText() : ScorePlayerTeam.formatPlayerName(llllllllllllllIIIllIlllIllIllIlI.func_178850_i(), llllllllllllllIIIllIlllIllIllIlI.func_178845_a().getName());
    }
    
    static {
        __OBFID = "CL_00001943";
        field_175252_a = Ordering.from((Comparator)new PlayerComparator(null));
    }
    
    static class PlayerComparator implements Comparator
    {
        PlayerComparator(final Object llllllllllllllIllIIIIIIlIlIIllll) {
            this();
        }
        
        @Override
        public int compare(final Object llllllllllllllIllIIIIIIlIlIlIIll, final Object llllllllllllllIllIIIIIIlIlIlIlIl) {
            return this.func_178952_a((NetworkPlayerInfo)llllllllllllllIllIIIIIIlIlIlIIll, (NetworkPlayerInfo)llllllllllllllIllIIIIIIlIlIlIlIl);
        }
        
        private PlayerComparator() {
        }
        
        public int func_178952_a(final NetworkPlayerInfo llllllllllllllIllIIIIIIlIllIIIlI, final NetworkPlayerInfo llllllllllllllIllIIIIIIlIlIlllIl) {
            final ScorePlayerTeam llllllllllllllIllIIIIIIlIllIIIII = llllllllllllllIllIIIIIIlIllIIIlI.func_178850_i();
            final ScorePlayerTeam llllllllllllllIllIIIIIIlIlIlllll = llllllllllllllIllIIIIIIlIlIlllIl.func_178850_i();
            return ComparisonChain.start().compareTrueFirst(llllllllllllllIllIIIIIIlIllIIIlI.getGameType() != WorldSettings.GameType.SPECTATOR, llllllllllllllIllIIIIIIlIlIlllIl.getGameType() != WorldSettings.GameType.SPECTATOR).compare((Comparable)((llllllllllllllIllIIIIIIlIllIIIII != null) ? llllllllllllllIllIIIIIIlIllIIIII.getRegisteredName() : ""), (Comparable)((llllllllllllllIllIIIIIIlIlIlllll != null) ? llllllllllllllIllIIIIIIlIlIlllll.getRegisteredName() : "")).compare((Comparable)llllllllllllllIllIIIIIIlIllIIIlI.func_178845_a().getName(), (Comparable)llllllllllllllIllIIIIIIlIlIlllIl.func_178845_a().getName()).result();
        }
        
        static {
            __OBFID = "CL_00001941";
        }
    }
}
