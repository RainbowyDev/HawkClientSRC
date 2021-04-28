package hawk.modules.player;

import hawk.modules.*;
import hawk.util.*;
import hawk.settings.*;
import net.minecraft.inventory.*;
import net.minecraft.enchantment.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class Autoarmor extends Module
{
    /* synthetic */ Timer timer;
    public /* synthetic */ NumberSetting DelayArmor;
    
    @Override
    public void onEnable() {
        if (AutoSetting.enabled) {
            if (AutoSetting.isHypixel) {
                this.DelayArmor.setValue(200.0);
            }
            if (AutoSetting.isMineplex) {
                this.DelayArmor.setValue(50.0);
            }
            if (AutoSetting.isOldVerus) {
                this.DelayArmor.setValue(200.0);
            }
            if (AutoSetting.isRedesky) {
                this.DelayArmor.setValue(50.0);
            }
        }
    }
    
    public Autoarmor() {
        super("Autoarmor", 0, Category.PLAYER);
        this.timer = new Timer();
        this.DelayArmor = new NumberSetting("Delay", 100.0, 0.0, 1000.0, 50.0, this);
        this.addSettings(this.DelayArmor);
    }
    
    public boolean isChestInventory() {
        return this.mc.thePlayer.openContainer != null && this.mc.thePlayer.openContainer instanceof ContainerChest;
    }
    
    public static int checkProtection(final ItemStack lIlIIIIIIIlllI) {
        return EnchantmentHelper.getEnchantmentLevel(0, lIlIIIIIIIlllI);
    }
    
    public int getFreeSlot() {
        for (int lIlIIIIIIlIlII = 35; lIlIIIIIIlIlII > 0; --lIlIIIIIIlIlII) {
            final ItemStack lIlIIIIIIlIIll = this.mc.thePlayer.inventory.getStackInSlot(lIlIIIIIIlIlII);
            if (lIlIIIIIIlIIll == null) {
                return lIlIIIIIIlIlII;
            }
        }
        return -1;
    }
    
    @Override
    public void onEvent(final Event lIlIIIIIlIIIIl) {
        if (AutoSetting.enabled) {
            if (AutoSetting.isHypixel) {
                this.DelayArmor.setValue(200.0);
            }
            if (AutoSetting.isMineplex) {
                this.DelayArmor.setValue(50.0);
            }
            if (AutoSetting.isOldVerus) {
                this.DelayArmor.setValue(200.0);
            }
            if (AutoSetting.isRedesky) {
                this.DelayArmor.setValue(50.0);
            }
        }
        if (lIlIIIIIlIIIIl instanceof EventUpdate && !this.isChestInventory()) {
            for (int lIlIIIIIlIlIlI = 0; lIlIIIIIlIlIlI < 36; ++lIlIIIIIlIlIlI) {
                final ItemStack lIlIIIIIlIlIIl = this.mc.thePlayer.inventory.getStackInSlot(lIlIIIIIlIlIlI);
                if (lIlIIIIIlIlIIl != null && lIlIIIIIlIlIIl.getItem() instanceof ItemArmor) {
                    final ItemArmor lIlIIIIIlIlIII = (ItemArmor)this.mc.thePlayer.inventory.getStackInSlot(lIlIIIIIlIlIlI).getItem();
                    int lIlIIIIIlIIlll = 0;
                    int lIlIIIIIlIIllI = 0;
                    int lIlIIIIIlIIlIl = 0;
                    if (this.mc.thePlayer.inventory.getStackInSlot(39 - lIlIIIIIlIlIII.armorType) != null) {
                        final ItemArmor lIlIIIIIlIIlII = (ItemArmor)this.mc.thePlayer.inventory.getStackInSlot(39 - lIlIIIIIlIlIII.armorType).getItem();
                        final ItemStack lIlIIIIIlIIIll = this.mc.thePlayer.inventory.getStackInSlot(39 - lIlIIIIIlIlIII.armorType);
                        lIlIIIIIlIIlll = lIlIIIIIlIIlII.getArmorMaterial().getDamageReductionAmount(lIlIIIIIlIlIII.armorType);
                        lIlIIIIIlIIlll += checkProtection(this.mc.thePlayer.inventory.getStackInSlot(39 - lIlIIIIIlIlIII.armorType));
                        lIlIIIIIlIIllI = lIlIIIIIlIIIll.getItemDamage();
                        lIlIIIIIlIIlIl = lIlIIIIIlIlIII.getArmorMaterial().getDamageReductionAmount(lIlIIIIIlIlIII.armorType);
                        lIlIIIIIlIIlIl += checkProtection(this.mc.thePlayer.inventory.getStackInSlot(lIlIIIIIlIlIlI));
                    }
                    if (this.getFreeSlot() != -1 && this.mc.thePlayer.inventory.getStackInSlot(39 - lIlIIIIIlIlIII.armorType) != null && (lIlIIIIIlIIlIl > lIlIIIIIlIIlll || (lIlIIIIIlIIlIl == lIlIIIIIlIIlll && lIlIIIIIlIlIIl.getItemDamage() < lIlIIIIIlIIllI))) {
                        if (lIlIIIIIlIlIlI < 9) {
                            lIlIIIIIlIlIlI += 36;
                        }
                        this.mc.playerController.windowClick(this.mc.thePlayer.inventoryContainer.windowId, 5 + lIlIIIIIlIlIII.armorType, 0, 4, this.mc.thePlayer);
                        this.mc.playerController.windowClick(this.mc.thePlayer.inventoryContainer.windowId, lIlIIIIIlIlIlI, 0, 1, this.mc.thePlayer);
                    }
                    if (this.mc.thePlayer.inventory.getStackInSlot(39 - lIlIIIIIlIlIII.armorType) == null && this.timer.hasTimeElapsed((long)this.DelayArmor.getValue(), true)) {
                        if (lIlIIIIIlIlIlI < 9) {
                            lIlIIIIIlIlIlI += 36;
                        }
                        this.mc.playerController.windowClick(this.mc.thePlayer.inventoryContainer.windowId, lIlIIIIIlIlIlI, 0, 1, this.mc.thePlayer);
                    }
                }
            }
        }
    }
}
