package net.minecraft.client.gui;

import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.renderer.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import org.apache.commons.io.*;
import java.io.*;
import java.util.*;

public class GuiWinGame extends GuiScreen
{
    private /* synthetic */ int field_146581_h;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ float field_146578_s;
    private static final /* synthetic */ ResourceLocation field_146577_g;
    private /* synthetic */ List field_146582_i;
    private /* synthetic */ int field_146579_r;
    private static final /* synthetic */ ResourceLocation field_146576_f;
    
    @Override
    public void updateScreen() {
        ++this.field_146581_h;
        final float llllllllllllllIIIIlllIlIllIlllIl = (this.field_146579_r + this.height + this.height + 24) / this.field_146578_s;
        if (this.field_146581_h > llllllllllllllIIIIlllIlIllIlllIl) {
            this.sendRespawnPacket();
        }
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIIIIlllIlIllIlIlll, final int llllllllllllllIIIIlllIlIllIlIlII) throws IOException {
        if (llllllllllllllIIIIlllIlIllIlIlII == 1) {
            this.sendRespawnPacket();
        }
    }
    
    public GuiWinGame() {
        this.field_146578_s = 0.5f;
    }
    
    private void drawWinGameScreen(final int llllllllllllllIIIIlllIlIIlIIllII, final int llllllllllllllIIIIlllIlIIlIIlIll, final float llllllllllllllIIIIlllIlIIlIIlIlI) {
        final Tessellator llllllllllllllIIIIlllIlIIlIIlIIl = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIIIIlllIlIIlIIlIII = llllllllllllllIIIIlllIlIIlIIlIIl.getWorldRenderer();
        this.mc.getTextureManager().bindTexture(Gui.optionsBackground);
        llllllllllllllIIIIlllIlIIlIIlIII.startDrawingQuads();
        llllllllllllllIIIIlllIlIIlIIlIII.func_178960_a(1.0f, 1.0f, 1.0f, 1.0f);
        final int llllllllllllllIIIIlllIlIIlIIIlll = this.width;
        final float llllllllllllllIIIIlllIlIIlIIIllI = 0.0f - (this.field_146581_h + llllllllllllllIIIIlllIlIIlIIlIlI) * 0.5f * this.field_146578_s;
        final float llllllllllllllIIIIlllIlIIlIIIlIl = this.height - (this.field_146581_h + llllllllllllllIIIIlllIlIIlIIlIlI) * 0.5f * this.field_146578_s;
        final float llllllllllllllIIIIlllIlIIlIIIlII = 0.015625f;
        float llllllllllllllIIIIlllIlIIlIIIIlI = (this.field_146581_h + llllllllllllllIIIIlllIlIIlIIlIlI - 0.0f) * 0.02f;
        final float llllllllllllllIIIIlllIlIIlIIIIIl = (this.field_146579_r + this.height + this.height + 24) / this.field_146578_s;
        final float llllllllllllllIIIIlllIlIIlIIIIII = (llllllllllllllIIIIlllIlIIlIIIIIl - 20.0f - (this.field_146581_h + llllllllllllllIIIIlllIlIIlIIlIlI)) * 0.005f;
        if (llllllllllllllIIIIlllIlIIlIIIIII < llllllllllllllIIIIlllIlIIlIIIIlI) {
            llllllllllllllIIIIlllIlIIlIIIIlI = llllllllllllllIIIIlllIlIIlIIIIII;
        }
        if (llllllllllllllIIIIlllIlIIlIIIIlI > 1.0f) {
            llllllllllllllIIIIlllIlIIlIIIIlI = 1.0f;
        }
        llllllllllllllIIIIlllIlIIlIIIIlI *= llllllllllllllIIIIlllIlIIlIIIIlI;
        llllllllllllllIIIIlllIlIIlIIIIlI = llllllllllllllIIIIlllIlIIlIIIIlI * 96.0f / 255.0f;
        llllllllllllllIIIIlllIlIIlIIlIII.func_178986_b(llllllllllllllIIIIlllIlIIlIIIIlI, llllllllllllllIIIIlllIlIIlIIIIlI, llllllllllllllIIIIlllIlIIlIIIIlI);
        llllllllllllllIIIIlllIlIIlIIlIII.addVertexWithUV(0.0, this.height, this.zLevel, 0.0, llllllllllllllIIIIlllIlIIlIIIllI * llllllllllllllIIIIlllIlIIlIIIlII);
        llllllllllllllIIIIlllIlIIlIIlIII.addVertexWithUV(llllllllllllllIIIIlllIlIIlIIIlll, this.height, this.zLevel, llllllllllllllIIIIlllIlIIlIIIlll * llllllllllllllIIIIlllIlIIlIIIlII, llllllllllllllIIIIlllIlIIlIIIllI * llllllllllllllIIIIlllIlIIlIIIlII);
        llllllllllllllIIIIlllIlIIlIIlIII.addVertexWithUV(llllllllllllllIIIIlllIlIIlIIIlll, 0.0, this.zLevel, llllllllllllllIIIIlllIlIIlIIIlll * llllllllllllllIIIIlllIlIIlIIIlII, llllllllllllllIIIIlllIlIIlIIIlIl * llllllllllllllIIIIlllIlIIlIIIlII);
        llllllllllllllIIIIlllIlIIlIIlIII.addVertexWithUV(0.0, 0.0, this.zLevel, 0.0, llllllllllllllIIIIlllIlIIlIIIlIl * llllllllllllllIIIIlllIlIIlIIIlII);
        llllllllllllllIIIIlllIlIIlIIlIIl.draw();
    }
    
    private void sendRespawnPacket() {
        this.mc.thePlayer.sendQueue.addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
        this.mc.displayGuiScreen(null);
    }
    
    static {
        __OBFID = "CL_00000719";
        logger = LogManager.getLogger();
        field_146576_f = new ResourceLocation("textures/gui/title/minecraft.png");
        field_146577_g = new ResourceLocation("textures/misc/vignette.png");
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIIIlllIlIIIIIlIll, final int llllllllllllllIIIIlllIlIIIIIlIlI, final float llllllllllllllIIIIlllIlIIIIllIII) {
        this.drawWinGameScreen(llllllllllllllIIIIlllIlIIIIIlIll, llllllllllllllIIIIlllIlIIIIIlIlI, llllllllllllllIIIIlllIlIIIIllIII);
        final Tessellator llllllllllllllIIIIlllIlIIIIlIlll = Tessellator.getInstance();
        final WorldRenderer llllllllllllllIIIIlllIlIIIIlIllI = llllllllllllllIIIIlllIlIIIIlIlll.getWorldRenderer();
        final short llllllllllllllIIIIlllIlIIIIlIlIl = 274;
        final int llllllllllllllIIIIlllIlIIIIlIlII = this.width / 2 - llllllllllllllIIIIlllIlIIIIlIlIl / 2;
        final int llllllllllllllIIIIlllIlIIIIlIIll = this.height + 50;
        final float llllllllllllllIIIIlllIlIIIIlIIlI = -(this.field_146581_h + llllllllllllllIIIIlllIlIIIIllIII) * this.field_146578_s;
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, llllllllllllllIIIIlllIlIIIIlIIlI, 0.0f);
        this.mc.getTextureManager().bindTexture(GuiWinGame.field_146576_f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.drawTexturedModalRect(llllllllllllllIIIIlllIlIIIIlIlII, llllllllllllllIIIIlllIlIIIIlIIll, 0, 0, 155, 44);
        this.drawTexturedModalRect(llllllllllllllIIIIlllIlIIIIlIlII + 155, llllllllllllllIIIIlllIlIIIIlIIll, 0, 45, 155, 44);
        llllllllllllllIIIIlllIlIIIIlIllI.func_178991_c(16777215);
        int llllllllllllllIIIIlllIlIIIIlIIIl = llllllllllllllIIIIlllIlIIIIlIIll + 200;
        for (int llllllllllllllIIIIlllIlIIIIlIIII = 0; llllllllllllllIIIIlllIlIIIIlIIII < this.field_146582_i.size(); ++llllllllllllllIIIIlllIlIIIIlIIII) {
            if (llllllllllllllIIIIlllIlIIIIlIIII == this.field_146582_i.size() - 1) {
                final float llllllllllllllIIIIlllIlIIIIIllll = llllllllllllllIIIIlllIlIIIIlIIIl + llllllllllllllIIIIlllIlIIIIlIIlI - (this.height / 2 - 6);
                if (llllllllllllllIIIIlllIlIIIIIllll < 0.0f) {
                    GlStateManager.translate(0.0f, -llllllllllllllIIIIlllIlIIIIIllll, 0.0f);
                }
            }
            if (llllllllllllllIIIIlllIlIIIIlIIIl + llllllllllllllIIIIlllIlIIIIlIIlI + 12.0f + 8.0f > 0.0f && llllllllllllllIIIIlllIlIIIIlIIIl + llllllllllllllIIIIlllIlIIIIlIIlI < this.height) {
                final String llllllllllllllIIIIlllIlIIIIIlllI = this.field_146582_i.get(llllllllllllllIIIIlllIlIIIIlIIII);
                if (llllllllllllllIIIIlllIlIIIIIlllI.startsWith("[C]")) {
                    this.fontRendererObj.drawStringWithShadow(llllllllllllllIIIIlllIlIIIIIlllI.substring(3), (float)(llllllllllllllIIIIlllIlIIIIlIlII + (llllllllllllllIIIIlllIlIIIIlIlIl - this.fontRendererObj.getStringWidth(llllllllllllllIIIIlllIlIIIIIlllI.substring(3))) / 2), (float)llllllllllllllIIIIlllIlIIIIlIIIl, 16777215);
                }
                else {
                    this.fontRendererObj.fontRandom.setSeed(llllllllllllllIIIIlllIlIIIIlIIII * 4238972211L + this.field_146581_h / 4);
                    this.fontRendererObj.drawStringWithShadow(llllllllllllllIIIIlllIlIIIIIlllI, (float)llllllllllllllIIIIlllIlIIIIlIlII, (float)llllllllllllllIIIIlllIlIIIIlIIIl, 16777215);
                }
            }
            llllllllllllllIIIIlllIlIIIIlIIIl += 12;
        }
        GlStateManager.popMatrix();
        this.mc.getTextureManager().bindTexture(GuiWinGame.field_146577_g);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(0, 769);
        llllllllllllllIIIIlllIlIIIIlIllI.startDrawingQuads();
        llllllllllllllIIIIlllIlIIIIlIllI.func_178960_a(1.0f, 1.0f, 1.0f, 1.0f);
        int llllllllllllllIIIIlllIlIIIIlIIII = this.width;
        final int llllllllllllllIIIIlllIlIIIIIllIl = this.height;
        llllllllllllllIIIIlllIlIIIIlIllI.addVertexWithUV(0.0, llllllllllllllIIIIlllIlIIIIIllIl, this.zLevel, 0.0, 1.0);
        llllllllllllllIIIIlllIlIIIIlIllI.addVertexWithUV(llllllllllllllIIIIlllIlIIIIlIIII, llllllllllllllIIIIlllIlIIIIIllIl, this.zLevel, 1.0, 1.0);
        llllllllllllllIIIIlllIlIIIIlIllI.addVertexWithUV(llllllllllllllIIIIlllIlIIIIlIIII, 0.0, this.zLevel, 1.0, 0.0);
        llllllllllllllIIIIlllIlIIIIlIllI.addVertexWithUV(0.0, 0.0, this.zLevel, 0.0, 0.0);
        llllllllllllllIIIIlllIlIIIIlIlll.draw();
        GlStateManager.disableBlend();
        super.drawScreen(llllllllllllllIIIIlllIlIIIIIlIll, llllllllllllllIIIIlllIlIIIIIlIlI, llllllllllllllIIIIlllIlIIIIllIII);
    }
    
    @Override
    public void initGui() {
        if (this.field_146582_i == null) {
            this.field_146582_i = Lists.newArrayList();
            try {
                String llllllllllllllIIIIlllIlIlIIlIlIl = "";
                final String llllllllllllllIIIIlllIlIlIIlIIll = String.valueOf(new StringBuilder().append(EnumChatFormatting.WHITE).append(EnumChatFormatting.OBFUSCATED).append(EnumChatFormatting.GREEN).append(EnumChatFormatting.AQUA));
                final short llllllllllllllIIIIlllIlIlIIlIIIl = 274;
                BufferedReader llllllllllllllIIIIlllIlIlIIIllll = new BufferedReader(new InputStreamReader(this.mc.getResourceManager().getResource(new ResourceLocation("texts/end.txt")).getInputStream(), Charsets.UTF_8));
                final Random llllllllllllllIIIIlllIlIlIIIllIl = new Random(8124371L);
                while ((llllllllllllllIIIIlllIlIlIIlIlIl = llllllllllllllIIIIlllIlIlIIIllll.readLine()) != null) {
                    String llllllllllllllIIIIlllIlIlIIIIlll;
                    String llllllllllllllIIIIlllIlIlIIIIlIl;
                    for (llllllllllllllIIIIlllIlIlIIlIlIl = llllllllllllllIIIIlllIlIlIIlIlIl.replaceAll("PLAYERNAME", this.mc.getSession().getUsername()); llllllllllllllIIIIlllIlIlIIlIlIl.contains(llllllllllllllIIIIlllIlIlIIlIIll); llllllllllllllIIIIlllIlIlIIlIlIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIlllIlIlIIIIlll)).append(EnumChatFormatting.WHITE).append(EnumChatFormatting.OBFUSCATED).append("XXXXXXXX".substring(0, llllllllllllllIIIIlllIlIlIIIllIl.nextInt(4) + 3)).append(llllllllllllllIIIIlllIlIlIIIIlIl))) {
                        final int llllllllllllllIIIIlllIlIlIIIlIll = llllllllllllllIIIIlllIlIlIIlIlIl.indexOf(llllllllllllllIIIIlllIlIlIIlIIll);
                        llllllllllllllIIIIlllIlIlIIIIlll = llllllllllllllIIIIlllIlIlIIlIlIl.substring(0, llllllllllllllIIIIlllIlIlIIIlIll);
                        llllllllllllllIIIIlllIlIlIIIIlIl = llllllllllllllIIIIlllIlIlIIlIlIl.substring(llllllllllllllIIIIlllIlIlIIIlIll + llllllllllllllIIIIlllIlIlIIlIIll.length());
                    }
                    this.field_146582_i.addAll(this.mc.fontRendererObj.listFormattedStringToWidth(llllllllllllllIIIIlllIlIlIIlIlIl, llllllllllllllIIIIlllIlIlIIlIIIl));
                    this.field_146582_i.add("");
                }
                for (int llllllllllllllIIIIlllIlIlIIIlIIl = 0; llllllllllllllIIIIlllIlIlIIIlIIl < 8; ++llllllllllllllIIIIlllIlIlIIIlIIl) {
                    this.field_146582_i.add("");
                }
                llllllllllllllIIIIlllIlIlIIIllll = new BufferedReader(new InputStreamReader(this.mc.getResourceManager().getResource(new ResourceLocation("texts/credits.txt")).getInputStream(), Charsets.UTF_8));
                while ((llllllllllllllIIIIlllIlIlIIlIlIl = llllllllllllllIIIIlllIlIlIIIllll.readLine()) != null) {
                    llllllllllllllIIIIlllIlIlIIlIlIl = llllllllllllllIIIIlllIlIlIIlIlIl.replaceAll("PLAYERNAME", this.mc.getSession().getUsername());
                    llllllllllllllIIIIlllIlIlIIlIlIl = llllllllllllllIIIIlllIlIlIIlIlIl.replaceAll("\t", "    ");
                    this.field_146582_i.addAll(this.mc.fontRendererObj.listFormattedStringToWidth(llllllllllllllIIIIlllIlIlIIlIlIl, llllllllllllllIIIIlllIlIlIIlIIIl));
                    this.field_146582_i.add("");
                }
                this.field_146579_r = this.field_146582_i.size() * 12;
            }
            catch (Exception llllllllllllllIIIIlllIlIlIIIIIll) {
                GuiWinGame.logger.error("Couldn't load credits", (Throwable)llllllllllllllIIIIlllIlIlIIIIIll);
            }
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }
}
