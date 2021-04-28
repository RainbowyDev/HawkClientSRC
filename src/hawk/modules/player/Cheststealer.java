package hawk.modules.player;

import hawk.modules.*;
import hawk.util.*;
import hawk.settings.*;
import hawk.events.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import hawk.events.listeners.*;

public class Cheststealer extends Module
{
    public static /* synthetic */ boolean silent;
    public /* synthetic */ BooleanSetting silentSteal;
    /* synthetic */ long a;
    public static /* synthetic */ boolean enabled;
    public /* synthetic */ BooleanSetting autoClose;
    public /* synthetic */ NumberSetting delay;
    /* synthetic */ Timer timer;
    
    public Cheststealer() {
        super("ChestStealer", 0, Category.PLAYER);
        this.timer = new Timer();
        this.delay = new NumberSetting("Delay", 20.0, 0.0, 1000.0, 50.0, this);
        this.silentSteal = new BooleanSetting("Silent", false, this);
        this.autoClose = new BooleanSetting("Auto close", true, this);
        this.addSettings(this.delay, this.silentSteal);
    }
    
    @Override
    public void onEnable() {
        Cheststealer.enabled = true;
        this.a = 0L;
        if (AutoSetting.enabled) {
            if (AutoSetting.isHypixel) {
                this.delay.setValue(200.0);
            }
            if (AutoSetting.isMineplex) {
                this.delay.setValue(50.0);
            }
            if (AutoSetting.isOldVerus) {
                this.delay.setValue(200.0);
            }
            if (AutoSetting.isRedesky) {
                this.delay.setValue(50.0);
            }
        }
    }
    
    public void OnDisable() {
        Cheststealer.enabled = false;
    }
    
    static {
        Cheststealer.silent = true;
    }
    
    @Override
    public void onEvent(final Event lllllllllllllllllIIIIIIIlIIlIIll) {
        if (this.mc.thePlayer == null) {
            this.toggled = false;
        }
        if (lllllllllllllllllIIIIIIIlIIlIIll instanceof EventUpdate) {
            if (AutoSetting.enabled) {
                if (AutoSetting.isHypixel) {
                    this.delay.setValue(200.0);
                }
                if (AutoSetting.isMineplex) {
                    this.delay.setValue(50.0);
                }
                if (AutoSetting.isOldVerus) {
                    this.delay.setValue(200.0);
                }
                if (AutoSetting.isRedesky) {
                    this.delay.setValue(50.0);
                }
            }
            if (lllllllllllllllllIIIIIIIlIIlIIll.isPre() && this.mc.thePlayer.openContainer != null && this.mc.thePlayer.openContainer instanceof ContainerChest) {
                final ContainerChest lllllllllllllllllIIIIIIIlIIlIIlI = (ContainerChest)this.mc.thePlayer.openContainer;
                for (int lllllllllllllllllIIIIIIIlIIlIIIl = 0; lllllllllllllllllIIIIIIIlIIlIIIl < lllllllllllllllllIIIIIIIlIIlIIlI.getLowerChestInventory().getSizeInventory(); ++lllllllllllllllllIIIIIIIlIIlIIIl) {
                    if (lllllllllllllllllIIIIIIIlIIlIIlI.getLowerChestInventory().getStackInSlot(lllllllllllllllllIIIIIIIlIIlIIIl) != null && this.timer.hasTimeElapsed((long)this.delay.getValue(), true)) {
                        this.mc.playerController.windowClick(lllllllllllllllllIIIIIIIlIIlIIlI.windowId, lllllllllllllllllIIIIIIIlIIlIIIl, 0, 1, this.mc.thePlayer);
                    }
                }
                lllllllllllllllllIIIIIIIlIIlIIlI.getInventory().isEmpty();
            }
        }
        if (lllllllllllllllllIIIIIIIlIIlIIll instanceof EventOpenChest && this.mc.thePlayer.openContainer != null && this.mc.thePlayer.openContainer instanceof ContainerChest && this.silentSteal.isEnabled()) {
            lllllllllllllllllIIIIIIIlIIlIIll.setCancelled(true);
            this.mc.inGameHasFocus = true;
            this.mc.mouseHelper.grabMouseCursor();
        }
    }
}
