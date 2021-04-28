package net.minecraft.client.entity;

import net.minecraft.item.*;
import net.minecraft.world.*;
import com.mojang.authlib.*;
import net.minecraft.client.*;
import net.minecraft.util.*;

public class EntityOtherPlayerMP extends AbstractClientPlayer
{
    private /* synthetic */ double otherPlayerMPPitch;
    private /* synthetic */ double otherPlayerMPZ;
    private /* synthetic */ double otherPlayerMPX;
    private /* synthetic */ boolean isItemInUse;
    private /* synthetic */ double otherPlayerMPY;
    private /* synthetic */ int otherPlayerMPPosRotationIncrements;
    private /* synthetic */ double otherPlayerMPYaw;
    
    static {
        __OBFID = "CL_00000939";
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.otherPlayerMPPosRotationIncrements > 0) {
            final double llllllllllllllllIIlIllIllIIIIlll = this.posX + (this.otherPlayerMPX - this.posX) / this.otherPlayerMPPosRotationIncrements;
            final double llllllllllllllllIIlIllIllIIIIllI = this.posY + (this.otherPlayerMPY - this.posY) / this.otherPlayerMPPosRotationIncrements;
            final double llllllllllllllllIIlIllIllIIIIlIl = this.posZ + (this.otherPlayerMPZ - this.posZ) / this.otherPlayerMPPosRotationIncrements;
            double llllllllllllllllIIlIllIllIIIIlII;
            for (llllllllllllllllIIlIllIllIIIIlII = this.otherPlayerMPYaw - this.rotationYaw; llllllllllllllllIIlIllIllIIIIlII < -180.0; llllllllllllllllIIlIllIllIIIIlII += 360.0) {}
            while (llllllllllllllllIIlIllIllIIIIlII >= 180.0) {
                llllllllllllllllIIlIllIllIIIIlII -= 360.0;
            }
            this.rotationYaw += (float)(llllllllllllllllIIlIllIllIIIIlII / this.otherPlayerMPPosRotationIncrements);
            this.rotationPitch += (float)((this.otherPlayerMPPitch - this.rotationPitch) / this.otherPlayerMPPosRotationIncrements);
            --this.otherPlayerMPPosRotationIncrements;
            this.setPosition(llllllllllllllllIIlIllIllIIIIlll, llllllllllllllllIIlIllIllIIIIllI, llllllllllllllllIIlIllIllIIIIlIl);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        this.prevCameraYaw = this.cameraYaw;
        this.updateArmSwingProgress();
        float llllllllllllllllIIlIllIllIIIIIll = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float llllllllllllllllIIlIllIllIIIIIlI = (float)Math.atan(-this.motionY * 0.20000000298023224) * 15.0f;
        if (llllllllllllllllIIlIllIllIIIIIll > 0.1f) {
            llllllllllllllllIIlIllIllIIIIIll = 0.1f;
        }
        if (!this.onGround || this.getHealth() <= 0.0f) {
            llllllllllllllllIIlIllIllIIIIIll = 0.0f;
        }
        if (this.onGround || this.getHealth() <= 0.0f) {
            llllllllllllllllIIlIllIllIIIIIlI = 0.0f;
        }
        this.cameraYaw += (llllllllllllllllIIlIllIllIIIIIll - this.cameraYaw) * 0.4f;
        this.cameraPitch += (llllllllllllllllIIlIllIllIIIIIlI - this.cameraPitch) * 0.8f;
    }
    
    @Override
    public void onUpdate() {
        this.field_71082_cx = 0.0f;
        super.onUpdate();
        this.prevLimbSwingAmount = this.limbSwingAmount;
        final double llllllllllllllllIIlIllIllIIlIlll = this.posX - this.prevPosX;
        final double llllllllllllllllIIlIllIllIIlIllI = this.posZ - this.prevPosZ;
        float llllllllllllllllIIlIllIllIIlIlIl = MathHelper.sqrt_double(llllllllllllllllIIlIllIllIIlIlll * llllllllllllllllIIlIllIllIIlIlll + llllllllllllllllIIlIllIllIIlIllI * llllllllllllllllIIlIllIllIIlIllI) * 4.0f;
        if (llllllllllllllllIIlIllIllIIlIlIl > 1.0f) {
            llllllllllllllllIIlIllIllIIlIlIl = 1.0f;
        }
        this.limbSwingAmount += (llllllllllllllllIIlIllIllIIlIlIl - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
        if (!this.isItemInUse && this.isEating() && this.inventory.mainInventory[this.inventory.currentItem] != null) {
            final ItemStack llllllllllllllllIIlIllIllIIlIlII = this.inventory.mainInventory[this.inventory.currentItem];
            this.setItemInUse(this.inventory.mainInventory[this.inventory.currentItem], llllllllllllllllIIlIllIllIIlIlII.getItem().getMaxItemUseDuration(llllllllllllllllIIlIllIllIIlIlII));
            this.isItemInUse = true;
        }
        else if (this.isItemInUse && !this.isEating()) {
            this.clearItemInUse();
            this.isItemInUse = false;
        }
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int llllllllllllllllIIlIllIlIllIllIl, final String llllllllllllllllIIlIllIlIllIllII) {
        return false;
    }
    
    public EntityOtherPlayerMP(final World llllllllllllllllIIlIllIllIlllIII, final GameProfile llllllllllllllllIIlIllIllIlllIlI) {
        super(llllllllllllllllIIlIllIllIlllIII, llllllllllllllllIIlIllIllIlllIlI);
        this.stepHeight = 0.0f;
        this.noClip = true;
        this.field_71082_cx = 0.25f;
        this.renderDistanceWeight = 10.0;
    }
    
    @Override
    public void addChatMessage(final IChatComponent llllllllllllllllIIlIllIlIllIllll) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(llllllllllllllllIIlIllIlIllIllll);
    }
    
    @Override
    public void func_180426_a(final double llllllllllllllllIIlIllIllIlIIIll, final double llllllllllllllllIIlIllIllIlIlIlI, final double llllllllllllllllIIlIllIllIlIlIIl, final float llllllllllllllllIIlIllIllIlIlIII, final float llllllllllllllllIIlIllIllIIlllll, final int llllllllllllllllIIlIllIllIIllllI, final boolean llllllllllllllllIIlIllIllIlIIlIl) {
        this.otherPlayerMPX = llllllllllllllllIIlIllIllIlIIIll;
        this.otherPlayerMPY = llllllllllllllllIIlIllIllIlIlIlI;
        this.otherPlayerMPZ = llllllllllllllllIIlIllIllIlIlIIl;
        this.otherPlayerMPYaw = llllllllllllllllIIlIllIllIlIlIII;
        this.otherPlayerMPPitch = llllllllllllllllIIlIllIllIIlllll;
        this.otherPlayerMPPosRotationIncrements = llllllllllllllllIIlIllIllIIllllI;
    }
    
    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5);
    }
    
    @Override
    public void setCurrentItemOrArmor(final int llllllllllllllllIIlIllIlIlllIlII, final ItemStack llllllllllllllllIIlIllIlIlllIIll) {
        if (llllllllllllllllIIlIllIlIlllIlII == 0) {
            this.inventory.mainInventory[this.inventory.currentItem] = llllllllllllllllIIlIllIlIlllIIll;
        }
        else {
            this.inventory.armorInventory[llllllllllllllllIIlIllIlIlllIlII - 1] = llllllllllllllllIIlIllIlIlllIIll;
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllIIlIllIllIllIlIl, final float llllllllllllllllIIlIllIllIllIlII) {
        return true;
    }
}
