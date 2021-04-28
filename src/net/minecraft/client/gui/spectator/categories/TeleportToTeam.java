package net.minecraft.client.gui.spectator.categories;

import com.google.common.collect.*;
import net.minecraft.client.*;
import net.minecraft.scoreboard.*;
import net.minecraft.client.gui.spectator.*;
import net.minecraft.client.network.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.resources.*;
import java.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class TeleportToTeam implements ISpectatorMenuObject, ISpectatorMenuView
{
    private final /* synthetic */ List field_178672_a;
    
    @Override
    public IChatComponent func_178670_b() {
        return new ChatComponentText("Select a team to teleport to");
    }
    
    @Override
    public boolean func_178662_A_() {
        for (final ISpectatorMenuObject llllllllllllllIIlIllIlIIlIlIIIIl : this.field_178672_a) {
            if (llllllllllllllIIlIllIlIIlIlIIIIl.func_178662_A_()) {
                return true;
            }
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00001920";
    }
    
    public TeleportToTeam() {
        this.field_178672_a = Lists.newArrayList();
        final Minecraft llllllllllllllIIlIllIlIIlIlllIll = Minecraft.getMinecraft();
        for (final ScorePlayerTeam llllllllllllllIIlIllIlIIlIlllIIl : llllllllllllllIIlIllIlIIlIlllIll.theWorld.getScoreboard().getTeams()) {
            this.field_178672_a.add(new TeamSelectionObject(llllllllllllllIIlIllIlIIlIlllIIl));
        }
    }
    
    @Override
    public void func_178661_a(final SpectatorMenu llllllllllllllIIlIllIlIIlIlIllIl) {
        llllllllllllllIIlIllIlIIlIlIllIl.func_178647_a(this);
    }
    
    @Override
    public List func_178669_a() {
        return this.field_178672_a;
    }
    
    @Override
    public void func_178663_a(final float llllllllllllllIIlIllIlIIlIlIlIII, final int llllllllllllllIIlIllIlIIlIlIIlll) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.field_175269_a);
        Gui.drawModalRectWithCustomSizedTexture(0, 0, 16.0f, 0.0f, 16, 16, 256.0f, 256.0f);
    }
    
    @Override
    public IChatComponent func_178664_z_() {
        return new ChatComponentText("Teleport to team member");
    }
    
    class TeamSelectionObject implements ISpectatorMenuObject
    {
        private final /* synthetic */ ScorePlayerTeam field_178676_b;
        private final /* synthetic */ ResourceLocation field_178677_c;
        private final /* synthetic */ List field_178675_d;
        
        @Override
        public boolean func_178662_A_() {
            return !this.field_178675_d.isEmpty();
        }
        
        static {
            __OBFID = "CL_00001919";
        }
        
        public TeamSelectionObject(final ScorePlayerTeam llllllllllllllIIIllIllIlIlllIllI) {
            this.field_178676_b = llllllllllllllIIIllIllIlIlllIllI;
            this.field_178675_d = Lists.newArrayList();
            for (final String llllllllllllllIIIllIllIlIlllIIlI : llllllllllllllIIIllIllIlIlllIllI.getMembershipCollection()) {
                final NetworkPlayerInfo llllllllllllllIIIllIllIlIlllIIII = Minecraft.getMinecraft().getNetHandler().func_175104_a(llllllllllllllIIIllIllIlIlllIIlI);
                if (llllllllllllllIIIllIllIlIlllIIII != null) {
                    this.field_178675_d.add(llllllllllllllIIIllIllIlIlllIIII);
                }
            }
            if (!this.field_178675_d.isEmpty()) {
                final String llllllllllllllIIIllIllIlIllIlllI = this.field_178675_d.get(new Random().nextInt(this.field_178675_d.size())).func_178845_a().getName();
                this.field_178677_c = AbstractClientPlayer.getLocationSkin(llllllllllllllIIIllIllIlIllIlllI);
                AbstractClientPlayer.getDownloadImageSkin(this.field_178677_c, llllllllllllllIIIllIllIlIllIlllI);
            }
            else {
                this.field_178677_c = DefaultPlayerSkin.func_177335_a();
            }
        }
        
        @Override
        public void func_178661_a(final SpectatorMenu llllllllllllllIIIllIllIlIllIIIll) {
            llllllllllllllIIIllIllIlIllIIIll.func_178647_a(new TeleportToPlayer(this.field_178675_d));
        }
        
        @Override
        public void func_178663_a(final float llllllllllllllIIIllIllIlIIllIIIl, final int llllllllllllllIIIllIllIlIIlIllll) {
            int llllllllllllllIIIllIllIlIIllllII = -1;
            final String llllllllllllllIIIllIllIlIIlllIll = FontRenderer.getFormatFromString(this.field_178676_b.getColorPrefix());
            if (llllllllllllllIIIllIllIlIIlllIll.length() >= 2) {
                llllllllllllllIIIllIllIlIIllllII = Minecraft.getMinecraft().fontRendererObj.func_175064_b(llllllllllllllIIIllIllIlIIlllIll.charAt(1));
            }
            if (llllllllllllllIIIllIllIlIIllllII >= 0) {
                final float llllllllllllllIIIllIllIlIIlllIIl = (llllllllllllllIIIllIllIlIIllllII >> 16 & 0xFF) / 255.0f;
                final float llllllllllllllIIIllIllIlIIllIlll = (llllllllllllllIIIllIllIlIIllllII >> 8 & 0xFF) / 255.0f;
                final float llllllllllllllIIIllIllIlIIllIlIl = (llllllllllllllIIIllIllIlIIllllII & 0xFF) / 255.0f;
                Gui.drawRect(1.0, 1.0, 15.0, 15.0, MathHelper.func_180183_b(llllllllllllllIIIllIllIlIIlllIIl * llllllllllllllIIIllIllIlIIllIIIl, llllllllllllllIIIllIllIlIIllIlll * llllllllllllllIIIllIllIlIIllIIIl, llllllllllllllIIIllIllIlIIllIlIl * llllllllllllllIIIllIllIlIIllIIIl) | llllllllllllllIIIllIllIlIIlIllll << 24);
            }
            Minecraft.getMinecraft().getTextureManager().bindTexture(this.field_178677_c);
            GlStateManager.color(llllllllllllllIIIllIllIlIIllIIIl, llllllllllllllIIIllIllIlIIllIIIl, llllllllllllllIIIllIllIlIIllIIIl, llllllllllllllIIIllIllIlIIlIllll / 255.0f);
            Gui.drawScaledCustomSizeModalRect(2, 2, 8.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
            Gui.drawScaledCustomSizeModalRect(2, 2, 40.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
        }
        
        @Override
        public IChatComponent func_178664_z_() {
            return new ChatComponentText(this.field_178676_b.func_96669_c());
        }
    }
}
