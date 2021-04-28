package net.minecraft.client.entity;

import net.minecraft.client.network.*;
import net.minecraft.client.*;
import net.minecraft.network.*;
import net.minecraft.entity.passive.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.*;
import hawk.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import hawk.modules.movement.*;
import net.minecraft.util.*;
import net.minecraft.potion.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.network.play.client.*;
import net.minecraft.world.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.audio.*;
import net.minecraft.command.server.*;
import net.minecraft.client.gui.*;

public class EntityPlayerSP extends AbstractClientPlayer
{
    private /* synthetic */ int horseJumpPowerCounter;
    public /* synthetic */ float renderArmPitch;
    private final /* synthetic */ StatFileWriter field_146108_bO;
    public /* synthetic */ float prevRenderArmYaw;
    private /* synthetic */ float horseJumpPower;
    private /* synthetic */ float field_175164_bL;
    private /* synthetic */ String clientBrand;
    public final /* synthetic */ NetHandlerPlayClient sendQueue;
    public /* synthetic */ float renderArmYaw;
    private /* synthetic */ float field_175165_bM;
    private /* synthetic */ int field_175168_bP;
    protected /* synthetic */ int sprintToggleTimer;
    public /* synthetic */ float timeInPortal;
    private /* synthetic */ boolean field_175171_bO;
    private /* synthetic */ boolean field_175170_bN;
    private /* synthetic */ double field_175172_bI;
    private /* synthetic */ double field_175166_bJ;
    public /* synthetic */ MovementInput movementInput;
    protected /* synthetic */ Minecraft mc;
    public /* synthetic */ float prevTimeInPortal;
    private /* synthetic */ boolean field_175169_bQ;
    public /* synthetic */ float prevRenderArmPitch;
    private /* synthetic */ double field_175167_bK;
    public /* synthetic */ int sprintingTicksLeft;
    
    public void closeScreen() {
        this.sendQueue.addToSendQueue(new C0DPacketCloseWindow(this.openContainer.windowId));
        this.func_175159_q();
    }
    
    @Override
    public void displayGUIHorse(final EntityHorse llllllllllllllllIIllIIIIlllllllI, final IInventory llllllllllllllllIIllIIIIllllllIl) {
        this.mc.displayGuiScreen(new GuiScreenHorseInventory(this.inventory, llllllllllllllllIIllIIIIllllllIl, llllllllllllllllIIllIIIIlllllllI));
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int llllllllllllllllIIllIIIlIIlllIIl, final String llllllllllllllllIIllIIIlIIlllIII) {
        return llllllllllllllllIIllIIIlIIlllIIl <= 0;
    }
    
    public float getHorseJumpPower() {
        return this.horseJumpPower;
    }
    
    @Override
    public void playSound(final String llllllllllllllllIIllIIIlIIlIlllI, final float llllllllllllllllIIllIIIlIIlIllIl, final float llllllllllllllllIIllIIIlIIlIlIII) {
        this.worldObj.playSound(this.posX, this.posY, this.posZ, llllllllllllllllIIllIIIlIIlIlllI, llllllllllllllllIIllIIIlIIlIllIl, llllllllllllllllIIllIIIlIIlIlIII, false);
    }
    
    public StatFileWriter getStatFileWriter() {
        return this.field_146108_bO;
    }
    
    @Override
    public void onCriticalHit(final Entity llllllllllllllllIIllIIIIlllIIlll) {
        this.mc.effectRenderer.func_178926_a(llllllllllllllllIIllIIIIlllIIlll, EnumParticleTypes.CRIT);
    }
    
    @Override
    public void displayVillagerTradeGui(final IMerchant llllllllllllllllIIllIIIIlllIllIl) {
        this.mc.displayGuiScreen(new GuiMerchant(this.inventory, llllllllllllllllIIllIIIIlllIllIl, this.worldObj));
    }
    
    @Override
    protected void damageEntity(final DamageSource llllllllllllllllIIllIIIllIlIllIl, final float llllllllllllllllIIllIIIllIlIllll) {
        if (!this.func_180431_b(llllllllllllllllIIllIIIllIlIllIl)) {
            this.setHealth(this.getHealth() - llllllllllllllllIIllIIIllIlIllll);
        }
    }
    
    @Override
    protected boolean pushOutOfBlocks(final double llllllllllllllllIIllIIIlIllIllII, final double llllllllllllllllIIllIIIlIllIIIIl, final double llllllllllllllllIIllIIIlIllIIIII) {
        if (this.noClip) {
            return false;
        }
        final BlockPos llllllllllllllllIIllIIIlIllIlIIl = new BlockPos(llllllllllllllllIIllIIIlIllIllII, llllllllllllllllIIllIIIlIllIIIIl, llllllllllllllllIIllIIIlIllIIIII);
        final double llllllllllllllllIIllIIIlIllIlIII = llllllllllllllllIIllIIIlIllIllII - llllllllllllllllIIllIIIlIllIlIIl.getX();
        final double llllllllllllllllIIllIIIlIllIIlll = llllllllllllllllIIllIIIlIllIIIII - llllllllllllllllIIllIIIlIllIlIIl.getZ();
        if (!this.func_175162_d(llllllllllllllllIIllIIIlIllIlIIl)) {
            byte llllllllllllllllIIllIIIlIllIIllI = -1;
            double llllllllllllllllIIllIIIlIllIIlIl = 9999.0;
            if (this.func_175162_d(llllllllllllllllIIllIIIlIllIlIIl.offsetWest()) && llllllllllllllllIIllIIIlIllIlIII < llllllllllllllllIIllIIIlIllIIlIl) {
                llllllllllllllllIIllIIIlIllIIlIl = llllllllllllllllIIllIIIlIllIlIII;
                llllllllllllllllIIllIIIlIllIIllI = 0;
            }
            if (this.func_175162_d(llllllllllllllllIIllIIIlIllIlIIl.offsetEast()) && 1.0 - llllllllllllllllIIllIIIlIllIlIII < llllllllllllllllIIllIIIlIllIIlIl) {
                llllllllllllllllIIllIIIlIllIIlIl = 1.0 - llllllllllllllllIIllIIIlIllIlIII;
                llllllllllllllllIIllIIIlIllIIllI = 1;
            }
            if (this.func_175162_d(llllllllllllllllIIllIIIlIllIlIIl.offsetNorth()) && llllllllllllllllIIllIIIlIllIIlll < llllllllllllllllIIllIIIlIllIIlIl) {
                llllllllllllllllIIllIIIlIllIIlIl = llllllllllllllllIIllIIIlIllIIlll;
                llllllllllllllllIIllIIIlIllIIllI = 4;
            }
            if (this.func_175162_d(llllllllllllllllIIllIIIlIllIlIIl.offsetSouth()) && 1.0 - llllllllllllllllIIllIIIlIllIIlll < llllllllllllllllIIllIIIlIllIIlIl) {
                llllllllllllllllIIllIIIlIllIIlIl = 1.0 - llllllllllllllllIIllIIIlIllIIlll;
                llllllllllllllllIIllIIIlIllIIllI = 5;
            }
            final float llllllllllllllllIIllIIIlIllIIlII = 0.1f;
            if (llllllllllllllllIIllIIIlIllIIllI == 0) {
                this.motionX = -llllllllllllllllIIllIIIlIllIIlII;
            }
            if (llllllllllllllllIIllIIIlIllIIllI == 1) {
                this.motionX = llllllllllllllllIIllIIIlIllIIlII;
            }
            if (llllllllllllllllIIllIIIlIllIIllI == 4) {
                this.motionZ = -llllllllllllllllIIllIIIlIllIIlII;
            }
            if (llllllllllllllllIIllIIIlIllIIllI == 5) {
                this.motionZ = llllllllllllllllIIllIIIlIllIIlII;
            }
        }
        return false;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllIIllIIIlllllllll, final float llllllllllllllllIIllIIIllllllllI) {
        return false;
    }
    
    @Override
    public void addChatMessage(final IChatComponent llllllllllllllllIIllIIIlIIllllII) {
        this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllllllIIllIIIlIIllllII);
    }
    
    public void func_175161_p() {
        final EventUpdate llllllllllllllllIIllIIIllllIIIlI = new EventUpdate();
        llllllllllllllllIIllIIIllllIIIlI.setType(EventType.PRE);
        Client.onEvent(llllllllllllllllIIllIIIllllIIIlI);
        final EventMotion llllllllllllllllIIllIIIllllIIIIl = new EventMotion(this.posX, this.getEntityBoundingBox().minY, this.posZ, this.rotationYaw, this.rotationPitch, this.onGround);
        llllllllllllllllIIllIIIllllIIIIl.setType(EventType.PRE);
        Client.onEvent(llllllllllllllllIIllIIIllllIIIIl);
        final boolean llllllllllllllllIIllIIIllllIIIII = this.isSprinting();
        if (llllllllllllllllIIllIIIllllIIIII != this.field_175171_bO) {
            if (llllllllllllllllIIllIIIllllIIIII) {
                this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.START_SPRINTING));
            }
            else {
                this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.STOP_SPRINTING));
            }
            this.field_175171_bO = llllllllllllllllIIllIIIllllIIIII;
        }
        final boolean llllllllllllllllIIllIIIlllIlllll = this.isSneaking();
        if (llllllllllllllllIIllIIIlllIlllll != this.field_175170_bN) {
            if (llllllllllllllllIIllIIIlllIlllll) {
                this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.START_SNEAKING));
            }
            else {
                this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.STOP_SNEAKING));
            }
            this.field_175170_bN = llllllllllllllllIIllIIIlllIlllll;
        }
        if (this.func_175160_A()) {
            final double llllllllllllllllIIllIIIlllIllllI = llllllllllllllllIIllIIIllllIIIIl.getX() - this.field_175172_bI;
            final double llllllllllllllllIIllIIIlllIlllIl = llllllllllllllllIIllIIIllllIIIIl.getY() - this.field_175166_bJ;
            final double llllllllllllllllIIllIIIlllIlllII = llllllllllllllllIIllIIIllllIIIIl.getZ() - this.field_175167_bK;
            final double llllllllllllllllIIllIIIlllIllIll = llllllllllllllllIIllIIIllllIIIIl.getYaw() - this.field_175164_bL;
            final double llllllllllllllllIIllIIIlllIllIlI = llllllllllllllllIIllIIIllllIIIIl.getPitch() - this.field_175165_bM;
            boolean llllllllllllllllIIllIIIlllIllIIl = llllllllllllllllIIllIIIlllIllllI * llllllllllllllllIIllIIIlllIllllI + llllllllllllllllIIllIIIlllIlllIl * llllllllllllllllIIllIIIlllIlllIl + llllllllllllllllIIllIIIlllIlllII * llllllllllllllllIIllIIIlllIlllII > 9.0E-4 || this.field_175168_bP >= 20;
            final boolean llllllllllllllllIIllIIIlllIllIII = llllllllllllllllIIllIIIlllIllIll != 0.0 || llllllllllllllllIIllIIIlllIllIlI != 0.0;
            if (this.ridingEntity == null) {
                if (llllllllllllllllIIllIIIlllIllIIl && llllllllllllllllIIllIIIlllIllIII) {
                    this.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(llllllllllllllllIIllIIIllllIIIIl.getX(), llllllllllllllllIIllIIIllllIIIIl.getY(), llllllllllllllllIIllIIIllllIIIIl.getZ(), llllllllllllllllIIllIIIllllIIIIl.getYaw(), llllllllllllllllIIllIIIllllIIIIl.getPitch(), llllllllllllllllIIllIIIllllIIIIl.isOnGround()));
                }
                else if (llllllllllllllllIIllIIIlllIllIIl) {
                    this.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(llllllllllllllllIIllIIIllllIIIIl.getX(), llllllllllllllllIIllIIIllllIIIIl.getY(), llllllllllllllllIIllIIIllllIIIIl.getZ(), llllllllllllllllIIllIIIllllIIIIl.isOnGround()));
                }
                else if (llllllllllllllllIIllIIIlllIllIII) {
                    this.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(llllllllllllllllIIllIIIllllIIIIl.getYaw(), llllllllllllllllIIllIIIllllIIIIl.getPitch(), llllllllllllllllIIllIIIllllIIIIl.isOnGround()));
                }
                else {
                    this.sendQueue.addToSendQueue(new C03PacketPlayer(llllllllllllllllIIllIIIllllIIIIl.isOnGround()));
                }
            }
            else {
                this.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(this.motionX, -999.0, this.motionZ, llllllllllllllllIIllIIIllllIIIIl.getYaw(), llllllllllllllllIIllIIIllllIIIIl.getPitch(), llllllllllllllllIIllIIIllllIIIIl.isOnGround()));
                llllllllllllllllIIllIIIlllIllIIl = false;
            }
            ++this.field_175168_bP;
            if (llllllllllllllllIIllIIIlllIllIIl) {
                this.field_175172_bI = llllllllllllllllIIllIIIllllIIIIl.getX();
                this.field_175166_bJ = llllllllllllllllIIllIIIllllIIIIl.getY();
                this.field_175167_bK = llllllllllllllllIIllIIIllllIIIIl.getZ();
                this.field_175168_bP = 0;
            }
            if (llllllllllllllllIIllIIIlllIllIII) {
                this.field_175164_bL = llllllllllllllllIIllIIIllllIIIIl.getYaw();
                this.field_175165_bM = llllllllllllllllIIllIIIllllIIIIl.getPitch();
            }
        }
    }
    
    @Override
    protected void joinEntityItemWithWorld(final EntityItem llllllllllllllllIIllIIIlllIIIIIl) {
    }
    
    protected void sendHorseJump() {
        this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.RIDING_JUMP, (int)(this.getHorseJumpPower() * 100.0f)));
    }
    
    @Override
    public void onUpdate() {
        if (this.worldObj.isBlockLoaded(new BlockPos(this.posX, 0.0, this.posZ))) {
            super.onUpdate();
            if (this.isRiding()) {
                this.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(this.rotationYaw, this.rotationPitch, this.onGround));
                this.sendQueue.addToSendQueue(new C0CPacketInput(this.moveStrafing, this.moveForward, this.movementInput.jump, this.movementInput.sneak));
            }
            else {
                this.func_175161_p();
            }
        }
        final EventMotion llllllllllllllllIIllIIIlllllIIlI = new EventMotion(this.posX, this.getEntityBoundingBox().minY, this.posZ, this.rotationYaw, this.rotationPitch, this.onGround);
        llllllllllllllllIIllIIIlllllIIlI.setType(EventType.POST);
        Client.onEvent(llllllllllllllllIIllIIIlllllIIlI);
    }
    
    @Override
    public EntityItem dropOneItem(final boolean llllllllllllllllIIllIIIlllIIIlll) {
        final C07PacketPlayerDigging.Action llllllllllllllllIIllIIIlllIIIllI = llllllllllllllllIIllIIIlllIIIlll ? C07PacketPlayerDigging.Action.DROP_ALL_ITEMS : C07PacketPlayerDigging.Action.DROP_ITEM;
        this.sendQueue.addToSendQueue(new C07PacketPlayerDigging(llllllllllllllllIIllIIIlllIIIllI, BlockPos.ORIGIN, EnumFacing.DOWN));
        return null;
    }
    
    @Override
    public void setSprinting(final boolean llllllllllllllllIIllIIIlIlIIlllI) {
        super.setSprinting(llllllllllllllllIIllIIIlIlIIlllI);
        this.sprintingTicksLeft = (llllllllllllllllIIllIIIlIlIIlllI ? 600 : 0);
    }
    
    @Override
    public void displayGUIBook(final ItemStack llllllllllllllllIIllIIIlIIIIllIl) {
        final Item llllllllllllllllIIllIIIlIIIIllll = llllllllllllllllIIllIIIlIIIIllIl.getItem();
        if (llllllllllllllllIIllIIIlIIIIllll == Items.writable_book) {
            this.mc.displayGuiScreen(new GuiScreenBook(this, llllllllllllllllIIllIIIlIIIIllIl, true));
        }
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.sprintingTicksLeft > 0) {
            --this.sprintingTicksLeft;
            if (this.sprintingTicksLeft == 0 && !Noslow.isnoslow) {
                this.setSprinting(false);
            }
        }
        if (this.sprintToggleTimer > 0) {
            --this.sprintToggleTimer;
        }
        this.prevTimeInPortal = this.timeInPortal;
        if (this.inPortal) {
            if (this.mc.currentScreen != null && !this.mc.currentScreen.doesGuiPauseGame()) {
                this.mc.displayGuiScreen(null);
            }
            if (this.timeInPortal == 0.0f) {
                this.mc.getSoundHandler().playSound(PositionedSoundRecord.createPositionedSoundRecord(new ResourceLocation("portal.trigger"), this.rand.nextFloat() * 0.4f + 0.8f));
            }
            this.timeInPortal += 0.0125f;
            if (this.timeInPortal >= 1.0f) {
                this.timeInPortal = 1.0f;
            }
            this.inPortal = false;
        }
        else if (this.isPotionActive(Potion.confusion) && this.getActivePotionEffect(Potion.confusion).getDuration() > 60) {
            this.timeInPortal += 0.006666667f;
            if (this.timeInPortal > 1.0f) {
                this.timeInPortal = 1.0f;
            }
        }
        else {
            if (this.timeInPortal > 0.0f) {
                this.timeInPortal -= 0.05f;
            }
            if (this.timeInPortal < 0.0f) {
                this.timeInPortal = 0.0f;
            }
        }
        if (this.timeUntilPortal > 0) {
            --this.timeUntilPortal;
        }
        final boolean llllllllllllllllIIllIIIIllIIlIll = this.movementInput.jump;
        final boolean llllllllllllllllIIllIIIIllIIlIlI = this.movementInput.sneak;
        final float llllllllllllllllIIllIIIIllIIlIIl = 0.8f;
        final boolean llllllllllllllllIIllIIIIllIIlIII = MovementInput.moveForward >= llllllllllllllllIIllIIIIllIIlIIl;
        this.movementInput.updatePlayerMoveState();
        if (this.isUsingItem() && !this.isRiding() && !Noslow.isnoslow) {
            MovementInput.moveStrafe *= 0.2f;
            MovementInput.moveForward *= 0.2f;
            this.sprintToggleTimer = 0;
        }
        this.pushOutOfBlocks(this.posX - this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ + this.width * 0.35);
        this.pushOutOfBlocks(this.posX - this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ - this.width * 0.35);
        this.pushOutOfBlocks(this.posX + this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ - this.width * 0.35);
        this.pushOutOfBlocks(this.posX + this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ + this.width * 0.35);
        final boolean llllllllllllllllIIllIIIIllIIIlll = this.getFoodStats().getFoodLevel() > 6.0f || this.capabilities.allowFlying;
        if (this.onGround && !llllllllllllllllIIllIIIIllIIlIlI && !llllllllllllllllIIllIIIIllIIlIII && MovementInput.moveForward >= llllllllllllllllIIllIIIIllIIlIIl && !this.isSprinting() && llllllllllllllllIIllIIIIllIIIlll && !this.isUsingItem() && !this.isPotionActive(Potion.blindness)) {
            if (this.sprintToggleTimer <= 0 && !this.mc.gameSettings.keyBindSprint.getIsKeyPressed()) {
                this.sprintToggleTimer = 7;
            }
            else {
                this.setSprinting(true);
            }
        }
        if (!this.isSprinting() && MovementInput.moveForward >= llllllllllllllllIIllIIIIllIIlIIl && llllllllllllllllIIllIIIIllIIIlll && !this.isUsingItem() && !this.isPotionActive(Potion.blindness) && this.mc.gameSettings.keyBindSprint.getIsKeyPressed()) {
            this.setSprinting(true);
        }
        if (this.isSprinting() && (MovementInput.moveForward < llllllllllllllllIIllIIIIllIIlIIl || this.isCollidedHorizontally || !llllllllllllllllIIllIIIIllIIIlll)) {
            this.setSprinting(false);
        }
        if (this.capabilities.allowFlying) {
            if (this.mc.playerController.isSpectatorMode()) {
                if (!this.capabilities.isFlying) {
                    this.capabilities.isFlying = true;
                    this.sendPlayerAbilities();
                }
            }
            else if (!llllllllllllllllIIllIIIIllIIlIll && this.movementInput.jump) {
                if (this.flyToggleTimer == 0) {
                    this.flyToggleTimer = 7;
                }
                else {
                    this.capabilities.isFlying = !this.capabilities.isFlying;
                    this.sendPlayerAbilities();
                    this.flyToggleTimer = 0;
                }
            }
        }
        if (this.capabilities.isFlying && this.func_175160_A()) {
            if (this.movementInput.sneak) {
                this.motionY -= this.capabilities.getFlySpeed() * 3.0f;
            }
            if (this.movementInput.jump) {
                this.motionY += this.capabilities.getFlySpeed() * 3.0f;
            }
        }
        if (this.isRidingHorse()) {
            if (this.horseJumpPowerCounter < 0) {
                ++this.horseJumpPowerCounter;
                if (this.horseJumpPowerCounter == 0) {
                    this.horseJumpPower = 0.0f;
                }
            }
            if (llllllllllllllllIIllIIIIllIIlIll && !this.movementInput.jump) {
                this.horseJumpPowerCounter = -10;
                this.sendHorseJump();
            }
            else if (!llllllllllllllllIIllIIIIllIIlIll && this.movementInput.jump) {
                this.horseJumpPowerCounter = 0;
                this.horseJumpPower = 0.0f;
            }
            else if (llllllllllllllllIIllIIIIllIIlIll) {
                ++this.horseJumpPowerCounter;
                if (this.horseJumpPowerCounter < 10) {
                    this.horseJumpPower = this.horseJumpPowerCounter * 0.1f;
                }
                else {
                    this.horseJumpPower = 0.8f + 2.0f / (this.horseJumpPowerCounter - 9) * 0.1f;
                }
            }
        }
        else {
            this.horseJumpPower = 0.0f;
        }
        super.onLivingUpdate();
        if (this.onGround && this.capabilities.isFlying && !this.mc.playerController.isSpectatorMode()) {
            this.capabilities.isFlying = false;
            this.sendPlayerAbilities();
        }
    }
    
    @Override
    public void swingItem() {
        super.swingItem();
        this.sendQueue.addToSendQueue(new C0APacketAnimation());
    }
    
    @Override
    public void addStat(final StatBase llllllllllllllllIIllIIIllIIlIlIl, final int llllllllllllllllIIllIIIllIIlIlll) {
        if (llllllllllllllllIIllIIIllIIlIlIl != null && llllllllllllllllIIllIIIllIIlIlIl.isIndependent) {
            super.addStat(llllllllllllllllIIllIIIllIIlIlIl, llllllllllllllllIIllIIIllIIlIlll);
        }
    }
    
    @Override
    public boolean isSneaking() {
        final boolean llllllllllllllllIIllIIIIllIllIll = this.movementInput != null && this.movementInput.sneak;
        return llllllllllllllllIIllIIIIllIllIll && !this.sleeping;
    }
    
    public void func_175163_u() {
        this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.OPEN_INVENTORY));
    }
    
    @Override
    public void respawnPlayer() {
        this.sendQueue.addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
    }
    
    public void func_175158_f(final String llllllllllllllllIIllIIIllIIIIlII) {
        this.clientBrand = llllllllllllllllIIllIIIllIIIIlII;
    }
    
    public void func_175159_q() {
        this.inventory.setItemStack(null);
        super.closeScreen();
        this.mc.displayGuiScreen(null);
    }
    
    @Override
    public void displayGUIChest(final IInventory llllllllllllllllIIllIIIlIIIIIlII) {
        final String llllllllllllllllIIllIIIlIIIIIllI = (llllllllllllllllIIllIIIlIIIIIlII instanceof IInteractionObject) ? ((IInteractionObject)llllllllllllllllIIllIIIlIIIIIlII).getGuiID() : "minecraft:container";
        if ("minecraft:chest".equals(llllllllllllllllIIllIIIlIIIIIllI)) {
            this.mc.displayGuiScreen(new GuiChest(this.inventory, llllllllllllllllIIllIIIlIIIIIlII));
        }
        else if ("minecraft:hopper".equals(llllllllllllllllIIllIIIlIIIIIllI)) {
            this.mc.displayGuiScreen(new GuiHopper(this.inventory, llllllllllllllllIIllIIIlIIIIIlII));
        }
        else if ("minecraft:furnace".equals(llllllllllllllllIIllIIIlIIIIIllI)) {
            this.mc.displayGuiScreen(new GuiFurnace(this.inventory, llllllllllllllllIIllIIIlIIIIIlII));
        }
        else if ("minecraft:brewing_stand".equals(llllllllllllllllIIllIIIlIIIIIllI)) {
            this.mc.displayGuiScreen(new GuiBrewingStand(this.inventory, llllllllllllllllIIllIIIlIIIIIlII));
        }
        else if ("minecraft:beacon".equals(llllllllllllllllIIllIIIlIIIIIllI)) {
            this.mc.displayGuiScreen(new GuiBeacon(this.inventory, llllllllllllllllIIllIIIlIIIIIlII));
        }
        else if (!"minecraft:dispenser".equals(llllllllllllllllIIllIIIlIIIIIllI) && !"minecraft:dropper".equals(llllllllllllllllIIllIIIlIIIIIllI)) {
            this.mc.displayGuiScreen(new GuiChest(this.inventory, llllllllllllllllIIllIIIlIIIIIlII));
        }
        else {
            this.mc.displayGuiScreen(new GuiDispenser(this.inventory, llllllllllllllllIIllIIIlIIIIIlII));
        }
    }
    
    static {
        __OBFID = "CL_00000938";
    }
    
    public void setPlayerSPHealth(final float llllllllllllllllIIllIIIllIlIIIIl) {
        if (this.field_175169_bQ) {
            final float llllllllllllllllIIllIIIllIlIIIII = this.getHealth() - llllllllllllllllIIllIIIllIlIIIIl;
            if (llllllllllllllllIIllIIIllIlIIIII <= 0.0f) {
                this.setHealth(llllllllllllllllIIllIIIllIlIIIIl);
                if (llllllllllllllllIIllIIIllIlIIIII < 0.0f) {
                    this.hurtResistantTime = this.maxHurtResistantTime / 2;
                }
            }
            else {
                this.lastDamage = llllllllllllllllIIllIIIllIlIIIII;
                this.setHealth(this.getHealth());
                this.hurtResistantTime = this.maxHurtResistantTime;
                this.damageEntity(DamageSource.generic, llllllllllllllllIIllIIIllIlIIIII);
                final int n = 10;
                this.maxHurtTime = n;
                this.hurtTime = n;
            }
        }
        else {
            this.setHealth(llllllllllllllllIIllIIIllIlIIIIl);
            this.field_175169_bQ = true;
        }
    }
    
    private boolean func_175162_d(final BlockPos llllllllllllllllIIllIIIlIlIlIlII) {
        return !this.worldObj.getBlockState(llllllllllllllllIIllIIIlIlIlIlII).getBlock().isNormalCube() && !this.worldObj.getBlockState(llllllllllllllllIIllIIIlIlIlIlII.offsetUp()).getBlock().isNormalCube();
    }
    
    public String getClientBrand() {
        return this.clientBrand;
    }
    
    @Override
    public void func_175141_a(final TileEntitySign llllllllllllllllIIllIIIlIIIlllIl) {
        this.mc.displayGuiScreen(new GuiEditSign(llllllllllllllllIIllIIIlIIIlllIl));
    }
    
    @Override
    public void displayGui(final IInteractionObject llllllllllllllllIIllIIIIllllIIlI) {
        final String llllllllllllllllIIllIIIIllllIlII = llllllllllllllllIIllIIIIllllIIlI.getGuiID();
        if ("minecraft:crafting_table".equals(llllllllllllllllIIllIIIIllllIlII)) {
            this.mc.displayGuiScreen(new GuiCrafting(this.inventory, this.worldObj));
        }
        else if ("minecraft:enchanting_table".equals(llllllllllllllllIIllIIIIllllIlII)) {
            this.mc.displayGuiScreen(new GuiEnchantment(this.inventory, this.worldObj, llllllllllllllllIIllIIIIllllIIlI));
        }
        else if ("minecraft:anvil".equals(llllllllllllllllIIllIIIIllllIlII)) {
            this.mc.displayGuiScreen(new GuiRepair(this.inventory, this.worldObj));
        }
    }
    
    @Override
    public void heal(final float llllllllllllllllIIllIIIlllllllII) {
    }
    
    @Override
    public void sendPlayerAbilities() {
        this.sendQueue.addToSendQueue(new C13PacketPlayerAbilities(this.capabilities));
    }
    
    public void sendChatMessage(final String llllllllllllllllIIllIIIllIlllIll) {
        this.sendQueue.addToSendQueue(new C01PacketChatMessage(llllllllllllllllIIllIIIllIlllIll));
    }
    
    @Override
    public void onEnchantmentCritical(final Entity llllllllllllllllIIllIIIIlllIIIIl) {
        this.mc.effectRenderer.func_178926_a(llllllllllllllllIIllIIIIlllIIIIl, EnumParticleTypes.CRIT_MAGIC);
    }
    
    @Override
    public boolean func_175144_cb() {
        return true;
    }
    
    public void updateEntityActionState() {
        super.updateEntityActionState();
        if (this.func_175160_A()) {
            this.moveStrafing = MovementInput.moveStrafe;
            this.moveForward = MovementInput.moveForward;
            this.isJumping = this.movementInput.jump;
            this.prevRenderArmYaw = this.renderArmYaw;
            this.prevRenderArmPitch = this.renderArmPitch;
            this.renderArmPitch += (float)((this.rotationPitch - this.renderArmPitch) * 0.5);
            this.renderArmYaw += (float)((this.rotationYaw - this.renderArmYaw) * 0.5);
        }
    }
    
    public EntityPlayerSP(final Minecraft llllllllllllllllIIllIIlIIIIIIlII, final World llllllllllllllllIIllIIlIIIIIlIII, final NetHandlerPlayClient llllllllllllllllIIllIIlIIIIIIlll, final StatFileWriter llllllllllllllllIIllIIlIIIIIIIIl) {
        super(llllllllllllllllIIllIIlIIIIIlIII, llllllllllllllllIIllIIlIIIIIIlll.func_175105_e());
        this.sendQueue = llllllllllllllllIIllIIlIIIIIIlll;
        this.field_146108_bO = llllllllllllllllIIllIIlIIIIIIIIl;
        this.mc = llllllllllllllllIIllIIlIIIIIIlII;
        this.dimension = 0;
    }
    
    public boolean isRidingHorse() {
        return this.ridingEntity != null && this.ridingEntity instanceof EntityHorse && ((EntityHorse)this.ridingEntity).isHorseSaddled();
    }
    
    protected boolean func_175160_A() {
        return this.mc.func_175606_aa() == this;
    }
    
    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5);
    }
    
    @Override
    public void mountEntity(final Entity llllllllllllllllIIllIIIllllllIII) {
        super.mountEntity(llllllllllllllllIIllIIIllllllIII);
        if (llllllllllllllllIIllIIIllllllIII instanceof EntityMinecart) {
            this.mc.getSoundHandler().playSound(new MovingSoundMinecartRiding(this, (EntityMinecart)llllllllllllllllIIllIIIllllllIII));
        }
    }
    
    public void setXPStats(final float llllllllllllllllIIllIIIlIlIIlIII, final int llllllllllllllllIIllIIIlIlIIIIll, final int llllllllllllllllIIllIIIlIlIIIIlI) {
        this.experience = llllllllllllllllIIllIIIlIlIIlIII;
        this.experienceTotal = llllllllllllllllIIllIIIlIlIIIIll;
        this.experienceLevel = llllllllllllllllIIllIIIlIlIIIIlI;
    }
    
    @Override
    public void func_146095_a(final CommandBlockLogic llllllllllllllllIIllIIIlIIIlIlIl) {
        this.mc.displayGuiScreen(new GuiCommandBlock(llllllllllllllllIIllIIIlIIIlIlIl));
    }
    
    @Override
    public boolean isServerWorld() {
        return true;
    }
    
    @Override
    public void addChatComponentMessage(final IChatComponent llllllllllllllllIIllIIIlIllllIII) {
        this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllllllIIllIIIlIllllIII);
    }
}
