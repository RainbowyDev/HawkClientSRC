package hawk.modules.player;

import hawk.modules.*;
import net.minecraft.client.*;
import hawk.settings.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import hawk.events.*;
import hawk.events.listeners.*;
import hawk.util.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.init.*;

public class ScaffoldHopeItWorks extends Module
{
    private /* synthetic */ Timer boosterTimer;
    /* synthetic */ int dorotations;
    private /* synthetic */ BlockUtils2.BlockData blockData;
    public /* synthetic */ BooleanSetting stopMovingOnPlace;
    /* synthetic */ int currentItem;
    public /* synthetic */ BooleanSetting safewalk;
    private /* synthetic */ Timer timer;
    /* synthetic */ double oldY;
    public static /* synthetic */ boolean isEnabled;
    /* synthetic */ int delayplace;
    public /* synthetic */ NumberSetting timerspeed;
    public /* synthetic */ BooleanSetting sneakOnPlace;
    public /* synthetic */ BooleanSetting noSprint;
    /* synthetic */ int rotating;
    public /* synthetic */ long LastBuild;
    public static /* synthetic */ Minecraft mc;
    public /* synthetic */ BooleanSetting timerBoost;
    
    @Override
    public void onEnable() {
        ScaffoldHopeItWorks.isEnabled = true;
        this.boosterTimer.reset();
        this.oldY = ScaffoldHopeItWorks.mc.thePlayer.posY;
    }
    
    @Override
    public void onDisable() {
        ScaffoldHopeItWorks.isEnabled = false;
        ScaffoldHopeItWorks.mc.gameSettings.keyBindSneak.pressed = false;
        ScaffoldHopeItWorks.mc.timer.timerSpeed = 1.0f;
        this.delayplace = 0;
    }
    
    public ScaffoldHopeItWorks() {
        super("Scaffold", 44, Category.PLAYER);
        this.noSprint = new BooleanSetting("No sprint", false, this);
        this.stopMovingOnPlace = new BooleanSetting("Stop Moving on place", true, this);
        this.safewalk = new BooleanSetting("Safewalk", true, this);
        this.sneakOnPlace = new BooleanSetting("Sneak on place", false, this);
        this.timerspeed = new NumberSetting("Timer", 1.0, 0.1, 4.0, 0.1, this);
        this.timerBoost = new BooleanSetting("Timer Boost", true, this);
        this.delayplace = 0;
        this.timer = new Timer();
        this.boosterTimer = new Timer();
        this.rotating = 0;
        this.dorotations = 1;
        this.addSettings(this.noSprint, this.safewalk, this.sneakOnPlace, this.timerspeed, this.timerBoost, this.stopMovingOnPlace);
    }
    
    private void updateHotbarHypixel() {
        final ItemStack llllllllllllllllIIIIllllIIllllll = new ItemStack(Item.getItemById(261));
        try {
            int llllllllllllllllIIIIllllIIlllllI = 36;
            while (llllllllllllllllIIIIllllIIlllllI < 45) {
                final int llllllllllllllllIIIIllllIIllllIl = llllllllllllllllIIIIllllIIlllllI - 36;
                if (!Container.canAddItemToSlot(ScaffoldHopeItWorks.mc.thePlayer.inventoryContainer.getSlot(llllllllllllllllIIIIllllIIlllllI), llllllllllllllllIIIIllllIIllllll, true) && ScaffoldHopeItWorks.mc.thePlayer.inventoryContainer.getSlot(llllllllllllllllIIIIllllIIlllllI).getStack().getItem() instanceof ItemBlock && ScaffoldHopeItWorks.mc.thePlayer.inventoryContainer.getSlot(llllllllllllllllIIIIllllIIlllllI).getStack() != null) {
                    if (ScaffoldHopeItWorks.mc.thePlayer.inventory.currentItem == llllllllllllllllIIIIllllIIllllIl) {
                        break;
                    }
                    ScaffoldHopeItWorks.mc.thePlayer.inventory.currentItem = llllllllllllllllIIIIllllIIllllIl;
                    this.currentItem = llllllllllllllllIIIIllllIIllllIl;
                    ScaffoldHopeItWorks.mc.getNetHandler().addToSendQueue(new C09PacketHeldItemChange(ScaffoldHopeItWorks.mc.thePlayer.inventory.currentItem));
                    ScaffoldHopeItWorks.mc.playerController.updateController();
                    break;
                }
                else {
                    ++llllllllllllllllIIIIllllIIlllllI;
                }
            }
        }
        catch (Exception ex) {}
    }
    
    static {
        ScaffoldHopeItWorks.isEnabled = false;
        ScaffoldHopeItWorks.mc = Minecraft.getMinecraft();
    }
    
    @Override
    public void onEvent(final Event llllllllllllllllIIIIllllIllIlIlI) {
        if (llllllllllllllllIIIIllllIllIlIlI instanceof EventMotion) {
            if (llllllllllllllllIIIIllllIllIlIlI.isPre()) {
                final EventMotion llllllllllllllllIIIIllllIllIlIIl = (EventMotion)llllllllllllllllIIIIllllIllIlIlI;
                if (this.blockData != null && ScaffoldHopeItWorks.mc.thePlayer != null && ScaffoldHopeItWorks.mc.theWorld != null) {
                    RotationUtils.getRotationFromPosition(this.blockData.position.getX(), this.blockData.position.getY(), this.blockData.position.getZ());
                }
                ScaffoldHopeItWorks.mc.thePlayer.rotationYawHead = ((EventMotion)llllllllllllllllIIIIllllIllIlIlI).getYaw();
                ScaffoldHopeItWorks.mc.thePlayer.renderYawOffset = ((EventMotion)llllllllllllllllIIIIllllIllIlIlI).getYaw();
            }
            if (this.timerBoost.isEnabled()) {
                if (!this.boosterTimer.hasTimeElapsed(1500L, false)) {
                    ScaffoldHopeItWorks.mc.timer.timerSpeed = 1.75f;
                }
                else {
                    ScaffoldHopeItWorks.mc.timer.timerSpeed = 1.0f;
                }
            }
            if (this.noSprint.isEnabled()) {
                ScaffoldHopeItWorks.mc.thePlayer.setSprinting(false);
            }
            if (this.sneakOnPlace.isEnabled() && this.timer.hasTimeElapsed(50L, true)) {
                ScaffoldHopeItWorks.mc.gameSettings.keyBindSneak.pressed = false;
            }
            if (!this.sneakOnPlace.isEnabled() && ScaffoldHopeItWorks.mc.gameSettings.keyBindSneak.pressed) {
                ScaffoldHopeItWorks.mc.gameSettings.keyBindSneak.pressed = false;
            }
            final EventMotion llllllllllllllllIIIIllllIllIlIII = (EventMotion)llllllllllllllllIIIIllllIllIlIlI;
            if (ScaffoldHopeItWorks.mc.thePlayer.getCurrentEquippedItem() == null) {
                return;
            }
            if (ScaffoldHopeItWorks.mc.thePlayer.getCurrentEquippedItem().getItem() == Item.getItemById(0)) {
                return;
            }
            if (!(ScaffoldHopeItWorks.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemBlock)) {
                return;
            }
            if (llllllllllllllllIIIIllllIllIlIlI.isPre()) {
                ScaffoldHopeItWorks.mc.timer.timerSpeed = (float)this.timerspeed.getValue();
                if (this.sneakOnPlace.isEnabled()) {
                    ScaffoldHopeItWorks.mc.thePlayer.setSneaking(true);
                }
                if (ScaffoldHopeItWorks.mc.theWorld == null || ScaffoldHopeItWorks.mc.thePlayer == null) {
                    return;
                }
                try {
                    this.blockData = null;
                    if (ScaffoldHopeItWorks.mc.thePlayer.getHeldItem() != null) {
                        this.updateHotbarHypixel();
                        final BlockPos llllllllllllllllIIIIllllIllIIlll = new BlockPos(ScaffoldHopeItWorks.mc.thePlayer.posX, ScaffoldHopeItWorks.mc.thePlayer.posY - 1.0, ScaffoldHopeItWorks.mc.thePlayer.posZ);
                        this.blockData = this.getBlockData(llllllllllllllllIIIIllllIllIIlll);
                        final float[] llllllllllllllllIIIIllllIllIIllI = RotationUtils.getRotationFromPosition(this.blockData.position.getX(), this.blockData.position.getY(), this.blockData.position.getZ());
                        ScaffoldHopeItWorks.mc.thePlayer.rotationYawHead = llllllllllllllllIIIIllllIllIlIII.getYaw();
                        ScaffoldHopeItWorks.mc.thePlayer.renderYawOffset = llllllllllllllllIIIIllllIllIlIII.getYaw();
                        llllllllllllllllIIIIllllIllIlIII.setYaw(llllllllllllllllIIIIllllIllIIllI[0]);
                        llllllllllllllllIIIIllllIllIlIII.setPitch(85.0f);
                        if (ScaffoldHopeItWorks.mc.gameSettings.keyBindJump.getIsKeyPressed()) {
                            final float moveForward = ScaffoldHopeItWorks.mc.thePlayer.moveForward;
                        }
                        if (this.blockData == null) {
                            return;
                        }
                        if (ScaffoldHopeItWorks.mc.theWorld == null || ScaffoldHopeItWorks.mc.thePlayer == null) {
                            return;
                        }
                        final Random llllllllllllllllIIIIllllIllIIlIl = new Random();
                        if (this.timer.hasTimeElapsed(1 + llllllllllllllllIIIIllllIllIIlIl.nextInt(9), this.expanded) && ScaffoldHopeItWorks.mc.playerController.func_178890_a(ScaffoldHopeItWorks.mc.thePlayer, ScaffoldHopeItWorks.mc.theWorld, ScaffoldHopeItWorks.mc.thePlayer.getHeldItem(), this.blockData.position, this.blockData.face, new Vec3(this.blockData.position.getX(), this.blockData.position.getY(), this.blockData.position.getZ()))) {
                            ScaffoldHopeItWorks.mc.thePlayer.swingItem();
                            if (this.stopMovingOnPlace.isEnabled()) {
                                ScaffoldHopeItWorks.mc.thePlayer.motionX = 0.0;
                                ScaffoldHopeItWorks.mc.thePlayer.motionZ = 0.0;
                                ScaffoldHopeItWorks.mc.thePlayer.moveForward = 0.0f;
                            }
                            llllllllllllllllIIIIllllIllIlIII.setYaw(llllllllllllllllIIIIllllIllIIllI[0]);
                            llllllllllllllllIIIIllllIllIlIII.setPitch(85.0f);
                            if (this.sneakOnPlace.enabled) {
                                ScaffoldHopeItWorks.mc.gameSettings.keyBindSneak.pressed = true;
                            }
                            ScaffoldHopeItWorks.mc.thePlayer.rotationYawHead = llllllllllllllllIIIIllllIllIlIII.getYaw();
                            ScaffoldHopeItWorks.mc.thePlayer.renderYawOffset = llllllllllllllllIIIIllllIllIlIII.getYaw();
                        }
                    }
                }
                catch (Exception ex) {}
            }
            if (llllllllllllllllIIIIllllIllIlIlI.isPost()) {
                if (this.blockData == null) {
                    return;
                }
                if (ScaffoldHopeItWorks.mc.theWorld == null || ScaffoldHopeItWorks.mc.thePlayer == null) {
                    return;
                }
                final Random llllllllllllllllIIIIllllIllIIlII = new Random();
                if (this.timer.hasTimeElapsed(1 + llllllllllllllllIIIIllllIllIIlII.nextInt(9), this.expanded) && ScaffoldHopeItWorks.mc.playerController.func_178890_a(ScaffoldHopeItWorks.mc.thePlayer, ScaffoldHopeItWorks.mc.theWorld, ScaffoldHopeItWorks.mc.thePlayer.getHeldItem(), this.blockData.position, this.blockData.face, new Vec3(this.blockData.position.getX(), this.blockData.position.getY(), this.blockData.position.getZ()))) {
                    if (this.sneakOnPlace.enabled) {
                        ScaffoldHopeItWorks.mc.gameSettings.keyBindSneak.pressed = true;
                    }
                    ScaffoldHopeItWorks.mc.thePlayer.swingItem();
                    this.LastBuild = System.currentTimeMillis();
                }
            }
        }
    }
    
    public static float[] getFacingRotations(final int llllllllllllllllIIIIllllIlIIlIll, final int llllllllllllllllIIIIllllIlIIlIlI, final int llllllllllllllllIIIIllllIlIlIIII, final EnumFacing llllllllllllllllIIIIllllIlIIlIII, final boolean llllllllllllllllIIIIllllIlIIIlll) {
        Minecraft.getMinecraft();
        final EntitySnowball llllllllllllllllIIIIllllIlIIllIl = new EntitySnowball(ScaffoldHopeItWorks.mc.theWorld);
        if (llllllllllllllllIIIIllllIlIIIlll) {
            final String llllllllllllllllIIIIllllIlIIllII;
            switch (llllllllllllllllIIIIllllIlIIllII = llllllllllllllllIIIIllllIlIIlIII.getName()) {
                case "up": {
                    llllllllllllllllIIIIllllIlIIllIl.posX = llllllllllllllllIIIIllllIlIIlIll + 0.5;
                    llllllllllllllllIIIIllllIlIIllIl.posY = llllllllllllllllIIIIllllIlIIlIlI + 0.5;
                    llllllllllllllllIIIIllllIlIIllIl.posZ = llllllllllllllllIIIIllllIlIlIIII + 0.5;
                    break;
                }
                case "east": {
                    llllllllllllllllIIIIllllIlIIllIl.posX = llllllllllllllllIIIIllllIlIIlIll + 1;
                    llllllllllllllllIIIIllllIlIIllIl.posY = llllllllllllllllIIIIllllIlIIlIlI + 0.5;
                    llllllllllllllllIIIIllllIlIIllIl.posZ = llllllllllllllllIIIIllllIlIlIIII + 0.5;
                    break;
                }
                case "west": {
                    llllllllllllllllIIIIllllIlIIllIl.posX = llllllllllllllllIIIIllllIlIIlIll;
                    llllllllllllllllIIIIllllIlIIllIl.posY = llllllllllllllllIIIIllllIlIIlIlI + 0.5;
                    llllllllllllllllIIIIllllIlIIllIl.posZ = llllllllllllllllIIIIllllIlIlIIII + 0.5;
                    break;
                }
                case "north": {
                    llllllllllllllllIIIIllllIlIIllIl.posX = llllllllllllllllIIIIllllIlIIlIll + 0.5;
                    llllllllllllllllIIIIllllIlIIllIl.posY = llllllllllllllllIIIIllllIlIIlIlI + 0.5;
                    llllllllllllllllIIIIllllIlIIllIl.posZ = llllllllllllllllIIIIllllIlIlIIII;
                    break;
                }
                case "south": {
                    llllllllllllllllIIIIllllIlIIllIl.posX = llllllllllllllllIIIIllllIlIIlIll + 0.5;
                    llllllllllllllllIIIIllllIlIIllIl.posY = llllllllllllllllIIIIllllIlIIlIlI + 0.5;
                    llllllllllllllllIIIIllllIlIIllIl.posZ = llllllllllllllllIIIIllllIlIlIIII + 1;
                    break;
                }
                default:
                    break;
            }
            return RotationUtils.getRotationFromPosition(llllllllllllllllIIIIllllIlIIllIl.posX, llllllllllllllllIIIIllllIlIIllIl.posY, llllllllllllllllIIIIllllIlIIllIl.posZ);
        }
        llllllllllllllllIIIIllllIlIIllIl.posX = llllllllllllllllIIIIllllIlIIlIll + 0.5;
        llllllllllllllllIIIIllllIlIIllIl.posY = llllllllllllllllIIIIllllIlIIlIlI + 0.5;
        llllllllllllllllIIIIllllIlIIllIl.posZ = llllllllllllllllIIIIllllIlIlIIII + 0.5;
        final EntitySnowball entitySnowball = llllllllllllllllIIIIllllIlIIllIl;
        entitySnowball.posX += llllllllllllllllIIIIllllIlIIlIII.getDirectionVec().getX() * 0.25;
        final EntitySnowball entitySnowball2 = llllllllllllllllIIIIllllIlIIllIl;
        entitySnowball2.posY += llllllllllllllllIIIIllllIlIIlIII.getDirectionVec().getY() * 0.25;
        final EntitySnowball entitySnowball3 = llllllllllllllllIIIIllllIlIIllIl;
        entitySnowball3.posZ += llllllllllllllllIIIIllllIlIIlIII.getDirectionVec().getZ() * 0.25;
        return RotationUtils.getRotationFromPosition(llllllllllllllllIIIIllllIlIIllIl.posX, llllllllllllllllIIIIllllIlIIllIl.posY, llllllllllllllllIIIIllllIlIIllIl.posZ);
    }
    
    public BlockUtils2.BlockData getBlockData(final BlockPos llllllllllllllllIIIIllllIlIllIlI) {
        return (ScaffoldHopeItWorks.mc.theWorld.getBlockState(llllllllllllllllIIIIllllIlIllIlI.add(0, -1, 0)).getBlock() != Blocks.air) ? new BlockUtils2.BlockData(llllllllllllllllIIIIllllIlIllIlI.add(0, -1, 0), EnumFacing.UP) : ((ScaffoldHopeItWorks.mc.theWorld.getBlockState(llllllllllllllllIIIIllllIlIllIlI.add(-1, 0, 0)).getBlock() != Blocks.air) ? new BlockUtils2.BlockData(llllllllllllllllIIIIllllIlIllIlI.add(-1, 0, 0), EnumFacing.EAST) : ((ScaffoldHopeItWorks.mc.theWorld.getBlockState(llllllllllllllllIIIIllllIlIllIlI.add(1, 0, 0)).getBlock() != Blocks.air) ? new BlockUtils2.BlockData(llllllllllllllllIIIIllllIlIllIlI.add(1, 0, 0), EnumFacing.WEST) : ((ScaffoldHopeItWorks.mc.theWorld.getBlockState(llllllllllllllllIIIIllllIlIllIlI.add(0, 0, -1)).getBlock() != Blocks.air) ? new BlockUtils2.BlockData(llllllllllllllllIIIIllllIlIllIlI.add(0, 0, -1), EnumFacing.SOUTH) : ((ScaffoldHopeItWorks.mc.theWorld.getBlockState(llllllllllllllllIIIIllllIlIllIlI.add(0, 0, 1)).getBlock() != Blocks.air) ? new BlockUtils2.BlockData(llllllllllllllllIIIIllllIlIllIlI.add(0, 0, 1), EnumFacing.NORTH) : null))));
    }
}
