package net.minecraft.client.gui.spectator.categories;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.network.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.spectator.*;
import java.util.*;
import com.google.common.collect.*;

public class TeleportToPlayer implements ISpectatorMenuView, ISpectatorMenuObject
{
    private final /* synthetic */ List field_178673_b;
    private static final /* synthetic */ Ordering field_178674_a;
    
    @Override
    public IChatComponent func_178670_b() {
        return new ChatComponentText("Select a player to teleport to");
    }
    
    @Override
    public List func_178669_a() {
        return this.field_178673_b;
    }
    
    @Override
    public void func_178661_a(final SpectatorMenu lllllllllllllllllIllIIIIllIIlIlI) {
        lllllllllllllllllIllIIIIllIIlIlI.func_178647_a(this);
    }
    
    public TeleportToPlayer() {
        this(TeleportToPlayer.field_178674_a.sortedCopy((Iterable)Minecraft.getMinecraft().getNetHandler().func_175106_d()));
    }
    
    @Override
    public IChatComponent func_178664_z_() {
        return new ChatComponentText("Teleport to player");
    }
    
    @Override
    public void func_178663_a(final float lllllllllllllllllIllIIIIllIIIlIl, final int lllllllllllllllllIllIIIIllIIIlII) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.field_175269_a);
        Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0f, 0.0f, 16, 16, 256.0f, 256.0f);
    }
    
    @Override
    public boolean func_178662_A_() {
        return !this.field_178673_b.isEmpty();
    }
    
    public TeleportToPlayer(final Collection lllllllllllllllllIllIIIIllIlIlII) {
        this.field_178673_b = Lists.newArrayList();
        for (final NetworkPlayerInfo lllllllllllllllllIllIIIIllIlIllI : TeleportToPlayer.field_178674_a.sortedCopy((Iterable)lllllllllllllllllIllIIIIllIlIlII)) {
            if (lllllllllllllllllIllIIIIllIlIllI.getGameType() != WorldSettings.GameType.SPECTATOR) {
                this.field_178673_b.add(new PlayerMenuObject(lllllllllllllllllIllIIIIllIlIllI.func_178845_a()));
            }
        }
    }
    
    static {
        __OBFID = "CL_00001922";
        field_178674_a = Ordering.from((Comparator)new Comparator() {
            @Override
            public int compare(final Object lllllllllllllllIllllIIIIlIllIIll, final Object lllllllllllllllIllllIIIIlIlIllll) {
                return this.func_178746_a((NetworkPlayerInfo)lllllllllllllllIllllIIIIlIllIIll, (NetworkPlayerInfo)lllllllllllllllIllllIIIIlIlIllll);
            }
            
            public int func_178746_a(final NetworkPlayerInfo lllllllllllllllIllllIIIIlIlllIIl, final NetworkPlayerInfo lllllllllllllllIllllIIIIlIlllIlI) {
                return ComparisonChain.start().compare((Comparable)lllllllllllllllIllllIIIIlIlllIIl.func_178845_a().getId(), (Comparable)lllllllllllllllIllllIIIIlIlllIlI.func_178845_a().getId()).result();
            }
            
            static {
                __OBFID = "CL_00001921";
            }
        });
    }
}
