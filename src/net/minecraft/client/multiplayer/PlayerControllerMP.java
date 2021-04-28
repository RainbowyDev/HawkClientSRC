package net.minecraft.client.multiplayer;

import net.minecraft.client.network.*;
import net.minecraft.client.*;
import net.minecraft.world.*;
import net.minecraft.stats.*;
import net.minecraft.client.entity.*;
import net.minecraft.network.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.audio.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.network.play.client.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class PlayerControllerMP
{
    private /* synthetic */ ItemStack currentItemHittingBlock;
    private /* synthetic */ int currentPlayerItem;
    private /* synthetic */ BlockPos field_178895_c;
    private final /* synthetic */ NetHandlerPlayClient netClientHandler;
    private /* synthetic */ int blockHitDelay;
    private /* synthetic */ float curBlockDamageMP;
    private /* synthetic */ float stepSoundTickCounter;
    private /* synthetic */ WorldSettings.GameType currentGameType;
    private /* synthetic */ boolean isHittingBlock;
    private final /* synthetic */ Minecraft mc;
    
    private boolean func_178893_a(final BlockPos llIlIIIlIllIlll) {
        final ItemStack llIlIIIlIlllIlI = this.mc.thePlayer.getHeldItem();
        boolean llIlIIIlIlllIIl = this.currentItemHittingBlock == null && llIlIIIlIlllIlI == null;
        if (this.currentItemHittingBlock != null && llIlIIIlIlllIlI != null) {
            llIlIIIlIlllIIl = (llIlIIIlIlllIlI.getItem() == this.currentItemHittingBlock.getItem() && ItemStack.areItemStackTagsEqual(llIlIIIlIlllIlI, this.currentItemHittingBlock) && (llIlIIIlIlllIlI.isItemStackDamageable() || llIlIIIlIlllIlI.getMetadata() == this.currentItemHittingBlock.getMetadata()));
        }
        return llIlIIIlIllIlll.equals(this.field_178895_c) && llIlIIIlIlllIIl;
    }
    
    public PlayerControllerMP(final Minecraft llIlIIllIlIllll, final NetHandlerPlayClient llIlIIllIlIlIIl) {
        this.field_178895_c = new BlockPos(-1, -1, -1);
        this.currentGameType = WorldSettings.GameType.SURVIVAL;
        this.mc = llIlIIllIlIllll;
        this.netClientHandler = llIlIIllIlIlIIl;
    }
    
    public boolean gameIsSurvivalOrAdventure() {
        return this.currentGameType.isSurvivalOrAdventure();
    }
    
    public boolean shouldDrawHUD() {
        return this.currentGameType.isSurvivalOrAdventure();
    }
    
    public EntityPlayerSP func_178892_a(final World llIlIIIIllIllII, final StatFileWriter llIlIIIIllIlIII) {
        return new EntityPlayerSP(this.mc, llIlIIIIllIllII, this.netClientHandler, llIlIIIIllIlIII);
    }
    
    public boolean func_180512_c(final BlockPos llIlIIIllIIlIIl, final EnumFacing llIlIIIllIIlIII) {
        this.syncCurrentPlayItem();
        if (this.blockHitDelay > 0) {
            --this.blockHitDelay;
            return true;
        }
        if (this.currentGameType.isCreative() && this.mc.theWorld.getWorldBorder().contains(llIlIIIllIIlIIl)) {
            this.blockHitDelay = 5;
            this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, llIlIIIllIIlIIl, llIlIIIllIIlIII));
            func_178891_a(this.mc, this, llIlIIIllIIlIIl, llIlIIIllIIlIII);
            return true;
        }
        if (!this.func_178893_a(llIlIIIllIIlIIl)) {
            return this.func_180511_b(llIlIIIllIIlIIl, llIlIIIllIIlIII);
        }
        final Block llIlIIIllIIlIll = this.mc.theWorld.getBlockState(llIlIIIllIIlIIl).getBlock();
        if (llIlIIIllIIlIll.getMaterial() == Material.air) {
            this.isHittingBlock = false;
            return false;
        }
        this.curBlockDamageMP += llIlIIIllIIlIll.getPlayerRelativeBlockHardness(this.mc.thePlayer, this.mc.thePlayer.worldObj, llIlIIIllIIlIIl);
        if (this.stepSoundTickCounter % 4.0f == 0.0f) {
            this.mc.getSoundHandler().playSound(new PositionedSoundRecord(new ResourceLocation(llIlIIIllIIlIll.stepSound.getStepSound()), (llIlIIIllIIlIll.stepSound.getVolume() + 1.0f) / 8.0f, llIlIIIllIIlIll.stepSound.getFrequency() * 0.5f, llIlIIIllIIlIIl.getX() + 0.5f, llIlIIIllIIlIIl.getY() + 0.5f, llIlIIIllIIlIIl.getZ() + 0.5f));
        }
        ++this.stepSoundTickCounter;
        if (this.curBlockDamageMP >= 1.0f) {
            this.isHittingBlock = false;
            this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, llIlIIIllIIlIIl, llIlIIIllIIlIII));
            this.func_178888_a(llIlIIIllIIlIIl, llIlIIIllIIlIII);
            this.curBlockDamageMP = 0.0f;
            this.stepSoundTickCounter = 0.0f;
            this.blockHitDelay = 5;
        }
        this.mc.theWorld.sendBlockBreakProgress(this.mc.thePlayer.getEntityId(), this.field_178895_c, (int)(this.curBlockDamageMP * 10.0f) - 1);
        return true;
    }
    
    static {
        __OBFID = "CL_00000881";
    }
    
    public float getBlockReachDistance() {
        return this.currentGameType.isCreative() ? 5.0f : 4.5f;
    }
    
    public boolean sendUseItem(final EntityPlayer llIlIIIIllllIll, final World llIlIIIIlllIlII, final ItemStack llIlIIIIlllIIll) {
        if (this.currentGameType == WorldSettings.GameType.SPECTATOR) {
            return false;
        }
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new C08PacketPlayerBlockPlacement(llIlIIIIllllIll.inventory.getCurrentItem()));
        final int llIlIIIIllllIII = llIlIIIIlllIIll.stackSize;
        final ItemStack llIlIIIIlllIlll = llIlIIIIlllIIll.useItemRightClick(llIlIIIIlllIlII, llIlIIIIllllIll);
        if (llIlIIIIlllIlll == llIlIIIIlllIIll && (llIlIIIIlllIlll == null || llIlIIIIlllIlll.stackSize == llIlIIIIllllIII)) {
            return false;
        }
        llIlIIIIllllIll.inventory.mainInventory[llIlIIIIllllIll.inventory.currentItem] = llIlIIIIlllIlll;
        if (llIlIIIIlllIlll.stackSize == 0) {
            llIlIIIIllllIll.inventory.mainInventory[llIlIIIIllllIll.inventory.currentItem] = null;
        }
        return true;
    }
    
    public boolean enableEverythingIsScrewedUpMode() {
        return this.currentGameType == WorldSettings.GameType.SPECTATOR;
    }
    
    private void syncCurrentPlayItem() {
        final int llIlIIIlIllIIIl = this.mc.thePlayer.inventory.currentItem;
        if (llIlIIIlIllIIIl != this.currentPlayerItem) {
            this.currentPlayerItem = llIlIIIlIllIIIl;
            this.netClientHandler.addToSendQueue(new C09PacketHeldItemChange(this.currentPlayerItem));
        }
    }
    
    public void onStoppedUsingItem(final EntityPlayer llIlIIIIIIlIIll) {
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
        llIlIIIIIIlIIll.stopUsingItem();
    }
    
    public boolean isInCreativeMode() {
        return this.currentGameType.isCreative();
    }
    
    public void sendEnchantPacket(final int llIlIIIIIlIIlll, final int llIlIIIIIlIIllI) {
        this.netClientHandler.addToSendQueue(new C11PacketEnchantItem(llIlIIIIIlIIlll, llIlIIIIIlIIllI));
    }
    
    public WorldSettings.GameType func_178889_l() {
        return this.currentGameType;
    }
    
    public boolean isSpectatorMode() {
        return this.currentGameType == WorldSettings.GameType.SPECTATOR;
    }
    
    public boolean func_178888_a(final BlockPos llIlIIIllllIllI, final EnumFacing llIlIIIllllIlIl) {
        if (this.currentGameType.isAdventure()) {
            if (this.currentGameType == WorldSettings.GameType.SPECTATOR) {
                return false;
            }
            if (!this.mc.thePlayer.func_175142_cm()) {
                final Block llIlIIIllllIlII = this.mc.theWorld.getBlockState(llIlIIIllllIllI).getBlock();
                final ItemStack llIlIIIllllIIll = this.mc.thePlayer.getCurrentEquippedItem();
                if (llIlIIIllllIIll == null) {
                    return false;
                }
                if (!llIlIIIllllIIll.canDestroy(llIlIIIllllIlII)) {
                    return false;
                }
            }
        }
        if (this.currentGameType.isCreative() && this.mc.thePlayer.getHeldItem() != null && this.mc.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
            return false;
        }
        final WorldClient llIlIIIllllIIlI = this.mc.theWorld;
        final IBlockState llIlIIIllllIIIl = llIlIIIllllIIlI.getBlockState(llIlIIIllllIllI);
        final Block llIlIIIllllIIII = llIlIIIllllIIIl.getBlock();
        if (llIlIIIllllIIII.getMaterial() == Material.air) {
            return false;
        }
        llIlIIIllllIIlI.playAuxSFX(2001, llIlIIIllllIllI, Block.getStateId(llIlIIIllllIIIl));
        final boolean llIlIIIlllIllll = llIlIIIllllIIlI.setBlockToAir(llIlIIIllllIllI);
        if (llIlIIIlllIllll) {
            llIlIIIllllIIII.onBlockDestroyedByPlayer(llIlIIIllllIIlI, llIlIIIllllIllI, llIlIIIllllIIIl);
        }
        this.field_178895_c = new BlockPos(this.field_178895_c.getX(), -1, this.field_178895_c.getZ());
        if (!this.currentGameType.isCreative()) {
            final ItemStack llIlIIIlllIlllI = this.mc.thePlayer.getCurrentEquippedItem();
            if (llIlIIIlllIlllI != null) {
                llIlIIIlllIlllI.onBlockDestroyed(llIlIIIllllIIlI, llIlIIIllllIIII, llIlIIIllllIllI, this.mc.thePlayer);
                if (llIlIIIlllIlllI.stackSize == 0) {
                    this.mc.thePlayer.destroyCurrentEquippedItem();
                }
            }
        }
        return llIlIIIlllIllll;
    }
    
    public void resetBlockRemoving() {
        if (this.isHittingBlock) {
            this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.field_178895_c, EnumFacing.DOWN));
            this.isHittingBlock = false;
            this.curBlockDamageMP = 0.0f;
            this.mc.theWorld.sendBlockBreakProgress(this.mc.thePlayer.getEntityId(), this.field_178895_c, -1);
        }
    }
    
    public void updateController() {
        this.syncCurrentPlayItem();
        if (this.netClientHandler.getNetworkManager().isChannelOpen()) {
            this.netClientHandler.getNetworkManager().processReceivedPackets();
        }
        else {
            this.netClientHandler.getNetworkManager().checkDisconnected();
        }
    }
    
    public void setPlayerCapabilities(final EntityPlayer llIlIIllIIlIIlI) {
        this.currentGameType.configurePlayerCapabilities(llIlIIllIIlIIlI.capabilities);
    }
    
    public boolean isRidingHorse() {
        return this.mc.thePlayer.isRiding() && this.mc.thePlayer.ridingEntity instanceof EntityHorse;
    }
    
    public ItemStack windowClick(final int llIlIIIIIllIlIl, final int llIlIIIIIllllII, final int llIlIIIIIlllIll, final int llIlIIIIIlllIlI, final EntityPlayer llIlIIIIIllIIIl) {
        final short llIlIIIIIlllIII = llIlIIIIIllIIIl.openContainer.getNextTransactionID(llIlIIIIIllIIIl.inventory);
        final ItemStack llIlIIIIIllIlll = llIlIIIIIllIIIl.openContainer.slotClick(llIlIIIIIllllII, llIlIIIIIlllIll, llIlIIIIIlllIlI, llIlIIIIIllIIIl);
        this.netClientHandler.addToSendQueue(new C0EPacketClickWindow(llIlIIIIIllIlIl, llIlIIIIIllllII, llIlIIIIIlllIll, llIlIIIIIlllIlI, llIlIIIIIllIlll, llIlIIIIIlllIII));
        return llIlIIIIIllIlll;
    }
    
    public void flipPlayer(final EntityPlayer llIlIIlIllIlllI) {
        llIlIIlIllIlllI.rotationYaw = -180.0f;
    }
    
    public boolean extendedReach() {
        return this.currentGameType.isCreative();
    }
    
    public void sendSlotPacket(final ItemStack llIlIIIIIlIIIIl, final int llIlIIIIIIlllIl) {
        if (this.currentGameType.isCreative()) {
            this.netClientHandler.addToSendQueue(new C10PacketCreativeInventoryAction(llIlIIIIIIlllIl, llIlIIIIIlIIIIl));
        }
    }
    
    public void sendPacketDropItem(final ItemStack llIlIIIIIIllIIl) {
        if (this.currentGameType.isCreative() && llIlIIIIIIllIIl != null) {
            this.netClientHandler.addToSendQueue(new C10PacketCreativeInventoryAction(-1, llIlIIIIIIllIIl));
        }
    }
    
    public static void func_178891_a(final Minecraft llIlIIllIlIIIII, final PlayerControllerMP llIlIIllIIlllll, final BlockPos llIlIIllIIllllI, final EnumFacing llIlIIllIIlllIl) {
        if (!llIlIIllIlIIIII.theWorld.func_175719_a(llIlIIllIlIIIII.thePlayer, llIlIIllIIllllI, llIlIIllIIlllIl)) {
            llIlIIllIIlllll.func_178888_a(llIlIIllIIllllI, llIlIIllIIlllIl);
        }
    }
    
    public boolean interactWithEntitySendPacket(final EntityPlayer llIlIIIIlIllIlI, final Entity llIlIIIIlIllIIl) {
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new C02PacketUseEntity(llIlIIIIlIllIIl, C02PacketUseEntity.Action.INTERACT));
        return this.currentGameType != WorldSettings.GameType.SPECTATOR && llIlIIIIlIllIlI.interactWith(llIlIIIIlIllIIl);
    }
    
    public boolean func_178890_a(final EntityPlayerSP llIlIIIlIIlllll, final WorldClient llIlIIIlIIIlllI, final ItemStack llIlIIIlIIlllIl, final BlockPos llIlIIIlIIIllII, final EnumFacing llIlIIIlIIllIll, final Vec3 llIlIIIlIIIlIlI) {
        this.syncCurrentPlayItem();
        final float llIlIIIlIIllIIl = (float)(llIlIIIlIIIlIlI.xCoord - llIlIIIlIIIllII.getX());
        final float llIlIIIlIIllIII = (float)(llIlIIIlIIIlIlI.yCoord - llIlIIIlIIIllII.getY());
        final float llIlIIIlIIlIlll = (float)(llIlIIIlIIIlIlI.zCoord - llIlIIIlIIIllII.getZ());
        boolean llIlIIIlIIlIllI = false;
        if (!this.mc.theWorld.getWorldBorder().contains(llIlIIIlIIIllII)) {
            return false;
        }
        if (this.currentGameType != WorldSettings.GameType.SPECTATOR) {
            final IBlockState llIlIIIlIIlIlIl = llIlIIIlIIIlllI.getBlockState(llIlIIIlIIIllII);
            if ((!llIlIIIlIIlllll.isSneaking() || llIlIIIlIIlllll.getHeldItem() == null) && llIlIIIlIIlIlIl.getBlock().onBlockActivated(llIlIIIlIIIlllI, llIlIIIlIIIllII, llIlIIIlIIlIlIl, llIlIIIlIIlllll, llIlIIIlIIllIll, llIlIIIlIIllIIl, llIlIIIlIIllIII, llIlIIIlIIlIlll)) {
                llIlIIIlIIlIllI = true;
            }
            if (!llIlIIIlIIlIllI && llIlIIIlIIlllIl != null && llIlIIIlIIlllIl.getItem() instanceof ItemBlock) {
                final ItemBlock llIlIIIlIIlIlII = (ItemBlock)llIlIIIlIIlllIl.getItem();
                if (!llIlIIIlIIlIlII.canPlaceBlockOnSide(llIlIIIlIIIlllI, llIlIIIlIIIllII, llIlIIIlIIllIll, llIlIIIlIIlllll, llIlIIIlIIlllIl)) {
                    return false;
                }
            }
        }
        this.netClientHandler.addToSendQueue(new C08PacketPlayerBlockPlacement(llIlIIIlIIIllII, llIlIIIlIIllIll.getIndex(), llIlIIIlIIlllll.inventory.getCurrentItem(), llIlIIIlIIllIIl, llIlIIIlIIllIII, llIlIIIlIIlIlll));
        if (llIlIIIlIIlIllI || this.currentGameType == WorldSettings.GameType.SPECTATOR) {
            return true;
        }
        if (llIlIIIlIIlllIl == null) {
            return false;
        }
        if (this.currentGameType.isCreative()) {
            final int llIlIIIlIIlIIll = llIlIIIlIIlllIl.getMetadata();
            final int llIlIIIlIIlIIlI = llIlIIIlIIlllIl.stackSize;
            final boolean llIlIIIlIIlIIIl = llIlIIIlIIlllIl.onItemUse(llIlIIIlIIlllll, llIlIIIlIIIlllI, llIlIIIlIIIllII, llIlIIIlIIllIll, llIlIIIlIIllIIl, llIlIIIlIIllIII, llIlIIIlIIlIlll);
            llIlIIIlIIlllIl.setItemDamage(llIlIIIlIIlIIll);
            llIlIIIlIIlllIl.stackSize = llIlIIIlIIlIIlI;
            return llIlIIIlIIlIIIl;
        }
        return llIlIIIlIIlllIl.onItemUse(llIlIIIlIIlllll, llIlIIIlIIIlllI, llIlIIIlIIIllII, llIlIIIlIIllIll, llIlIIIlIIllIIl, llIlIIIlIIllIII, llIlIIIlIIlIlll);
    }
    
    public void attackEntity(final EntityPlayer llIlIIIIllIIIII, final Entity llIlIIIIllIIIlI) {
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new C02PacketUseEntity(llIlIIIIllIIIlI, C02PacketUseEntity.Action.ATTACK));
        if (this.currentGameType != WorldSettings.GameType.SPECTATOR) {
            llIlIIIIllIIIII.attackTargetEntityWithCurrentItem(llIlIIIIllIIIlI);
        }
    }
    
    public boolean func_180511_b(final BlockPos llIlIIIlllIIIII, final EnumFacing llIlIIIllIlllll) {
        if (this.currentGameType.isAdventure()) {
            if (this.currentGameType == WorldSettings.GameType.SPECTATOR) {
                return false;
            }
            if (!this.mc.thePlayer.func_175142_cm()) {
                final Block llIlIIIllIllllI = this.mc.theWorld.getBlockState(llIlIIIlllIIIII).getBlock();
                final ItemStack llIlIIIllIlllII = this.mc.thePlayer.getCurrentEquippedItem();
                if (llIlIIIllIlllII == null) {
                    return false;
                }
                if (!llIlIIIllIlllII.canDestroy(llIlIIIllIllllI)) {
                    return false;
                }
            }
        }
        if (!this.mc.theWorld.getWorldBorder().contains(llIlIIIlllIIIII)) {
            return false;
        }
        if (this.currentGameType.isCreative()) {
            this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, llIlIIIlllIIIII, llIlIIIllIlllll));
            func_178891_a(this.mc, this, llIlIIIlllIIIII, llIlIIIllIlllll);
            this.blockHitDelay = 5;
        }
        else if (!this.isHittingBlock || !this.func_178893_a(llIlIIIlllIIIII)) {
            if (this.isHittingBlock) {
                this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.field_178895_c, llIlIIIllIlllll));
            }
            this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, llIlIIIlllIIIII, llIlIIIllIlllll));
            final Block llIlIIIllIlllIl = this.mc.theWorld.getBlockState(llIlIIIlllIIIII).getBlock();
            final boolean llIlIIIllIllIll = llIlIIIllIlllIl.getMaterial() != Material.air;
            if (llIlIIIllIllIll && this.curBlockDamageMP == 0.0f) {
                llIlIIIllIlllIl.onBlockClicked(this.mc.theWorld, llIlIIIlllIIIII, this.mc.thePlayer);
            }
            if (llIlIIIllIllIll && llIlIIIllIlllIl.getPlayerRelativeBlockHardness(this.mc.thePlayer, this.mc.thePlayer.worldObj, llIlIIIlllIIIII) >= 1.0f) {
                this.func_178888_a(llIlIIIlllIIIII, llIlIIIllIlllll);
            }
            else {
                this.isHittingBlock = true;
                this.field_178895_c = llIlIIIlllIIIII;
                this.currentItemHittingBlock = this.mc.thePlayer.getHeldItem();
                this.curBlockDamageMP = 0.0f;
                this.stepSoundTickCounter = 0.0f;
                this.mc.theWorld.sendBlockBreakProgress(this.mc.thePlayer.getEntityId(), this.field_178895_c, (int)(this.curBlockDamageMP * 10.0f) - 1);
            }
        }
        return true;
    }
    
    public boolean func_178894_a(final EntityPlayer llIlIIIIlIIlIlI, final Entity llIlIIIIlIIlllI, final MovingObjectPosition llIlIIIIlIIlIII) {
        this.syncCurrentPlayItem();
        final Vec3 llIlIIIIlIIllII = new Vec3(llIlIIIIlIIlIII.hitVec.xCoord - llIlIIIIlIIlllI.posX, llIlIIIIlIIlIII.hitVec.yCoord - llIlIIIIlIIlllI.posY, llIlIIIIlIIlIII.hitVec.zCoord - llIlIIIIlIIlllI.posZ);
        this.netClientHandler.addToSendQueue(new C02PacketUseEntity(llIlIIIIlIIlllI, llIlIIIIlIIllII));
        return this.currentGameType != WorldSettings.GameType.SPECTATOR && llIlIIIIlIIlllI.func_174825_a(llIlIIIIlIIlIlI, llIlIIIIlIIllII);
    }
    
    public boolean isNotCreative() {
        return !this.currentGameType.isCreative();
    }
    
    public void setGameType(final WorldSettings.GameType llIlIIlIlllIllI) {
        this.currentGameType = llIlIIlIlllIllI;
        this.currentGameType.configurePlayerCapabilities(this.mc.thePlayer.capabilities);
    }
}
