package net.minecraft.world.demo;

import net.minecraft.server.management.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class DemoWorldManager extends ItemInWorldManager
{
    private /* synthetic */ boolean demoTimeExpired;
    private /* synthetic */ boolean field_73105_c;
    private /* synthetic */ int field_73102_f;
    private /* synthetic */ int field_73104_e;
    
    @Override
    public void updateBlockRemoving() {
        super.updateBlockRemoving();
        ++this.field_73102_f;
        final long lllllllllllllllIllllIllIlllIIIIl = this.theWorld.getTotalWorldTime();
        final long lllllllllllllllIllllIllIlllIIIII = lllllllllllllllIllllIllIlllIIIIl / 24000L + 1L;
        if (!this.field_73105_c && this.field_73102_f > 20) {
            this.field_73105_c = true;
            this.thisPlayerMP.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(5, 0.0f));
        }
        this.demoTimeExpired = (lllllllllllllllIllllIllIlllIIIIl > 120500L);
        if (this.demoTimeExpired) {
            ++this.field_73104_e;
        }
        if (lllllllllllllllIllllIllIlllIIIIl % 24000L == 500L) {
            if (lllllllllllllllIllllIllIlllIIIII <= 6L) {
                this.thisPlayerMP.addChatMessage(new ChatComponentTranslation(String.valueOf(new StringBuilder("demo.day.").append(lllllllllllllllIllllIllIlllIIIII)), new Object[0]));
            }
        }
        else if (lllllllllllllllIllllIllIlllIIIII == 1L) {
            if (lllllllllllllllIllllIllIlllIIIIl == 100L) {
                this.thisPlayerMP.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(5, 101.0f));
            }
            else if (lllllllllllllllIllllIllIlllIIIIl == 175L) {
                this.thisPlayerMP.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(5, 102.0f));
            }
            else if (lllllllllllllllIllllIllIlllIIIIl == 250L) {
                this.thisPlayerMP.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(5, 103.0f));
            }
        }
        else if (lllllllllllllllIllllIllIlllIIIII == 5L && lllllllllllllllIllllIllIlllIIIIl % 24000L == 22000L) {
            this.thisPlayerMP.addChatMessage(new ChatComponentTranslation("demo.day.warning", new Object[0]));
        }
    }
    
    public DemoWorldManager(final World lllllllllllllllIllllIllIlllIIllI) {
        super(lllllllllllllllIllllIllIlllIIllI);
    }
    
    @Override
    public boolean tryUseItem(final EntityPlayer lllllllllllllllIllllIllIlIllllll, final World lllllllllllllllIllllIllIlIlllIlI, final ItemStack lllllllllllllllIllllIllIlIllllIl) {
        if (this.demoTimeExpired) {
            this.sendDemoReminder();
            return false;
        }
        return super.tryUseItem(lllllllllllllllIllllIllIlIllllll, lllllllllllllllIllllIllIlIlllIlI, lllllllllllllllIllllIllIlIllllIl);
    }
    
    static {
        __OBFID = "CL_00001429";
    }
    
    @Override
    public boolean func_180237_b(final BlockPos lllllllllllllllIllllIllIllIIIlIl) {
        return !this.demoTimeExpired && super.func_180237_b(lllllllllllllllIllllIllIllIIIlIl);
    }
    
    @Override
    public boolean func_180236_a(final EntityPlayer lllllllllllllllIllllIllIlIlIIlIl, final World lllllllllllllllIllllIllIlIlIllIl, final ItemStack lllllllllllllllIllllIllIlIlIllII, final BlockPos lllllllllllllllIllllIllIlIlIIIlI, final EnumFacing lllllllllllllllIllllIllIlIlIlIlI, final float lllllllllllllllIllllIllIlIlIlIIl, final float lllllllllllllllIllllIllIlIIlllll, final float lllllllllllllllIllllIllIlIIllllI) {
        if (this.demoTimeExpired) {
            this.sendDemoReminder();
            return false;
        }
        return super.func_180236_a(lllllllllllllllIllllIllIlIlIIlIl, lllllllllllllllIllllIllIlIlIllIl, lllllllllllllllIllllIllIlIlIllII, lllllllllllllllIllllIllIlIlIIIlI, lllllllllllllllIllllIllIlIlIlIlI, lllllllllllllllIllllIllIlIlIlIIl, lllllllllllllllIllllIllIlIIlllll, lllllllllllllllIllllIllIlIIllllI);
    }
    
    @Override
    public void func_180785_a(final BlockPos lllllllllllllllIllllIllIllIIllIl) {
        if (!this.demoTimeExpired) {
            super.func_180785_a(lllllllllllllllIllllIllIllIIllIl);
        }
    }
    
    @Override
    public void func_180784_a(final BlockPos lllllllllllllllIllllIllIllIlIIlI, final EnumFacing lllllllllllllllIllllIllIllIlIlII) {
        if (this.demoTimeExpired) {
            this.sendDemoReminder();
        }
        else {
            super.func_180784_a(lllllllllllllllIllllIllIllIlIIlI, lllllllllllllllIllllIllIllIlIlII);
        }
    }
    
    private void sendDemoReminder() {
        if (this.field_73104_e > 100) {
            this.thisPlayerMP.addChatMessage(new ChatComponentTranslation("demo.reminder", new Object[0]));
            this.field_73104_e = 0;
        }
    }
}
