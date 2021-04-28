package net.minecraft.server.management;

import net.minecraft.entity.player.*;
import net.minecraft.network.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;
import net.minecraft.network.play.server.*;

public class ItemInWorldManager
{
    private /* synthetic */ int curblockDamage;
    private /* synthetic */ boolean isDestroyingBlock;
    private /* synthetic */ int initialBlockDamage;
    private /* synthetic */ BlockPos field_180240_f;
    public /* synthetic */ World theWorld;
    public /* synthetic */ EntityPlayerMP thisPlayerMP;
    private /* synthetic */ int durabilityRemainingOnBlock;
    private /* synthetic */ BlockPos field_180241_i;
    private /* synthetic */ WorldSettings.GameType gameType;
    private /* synthetic */ int initialDamage;
    private /* synthetic */ boolean receivedFinishDiggingPacket;
    
    public boolean func_180237_b(final BlockPos lllllllllllllllIlIIlllllllIlIIll) {
        if (this.gameType.isCreative() && this.thisPlayerMP.getHeldItem() != null && this.thisPlayerMP.getHeldItem().getItem() instanceof ItemSword) {
            return false;
        }
        final IBlockState lllllllllllllllIlIIllllllllIIIII = this.theWorld.getBlockState(lllllllllllllllIlIIlllllllIlIIll);
        final TileEntity lllllllllllllllIlIIlllllllIlllll = this.theWorld.getTileEntity(lllllllllllllllIlIIlllllllIlIIll);
        if (this.gameType.isAdventure()) {
            if (this.gameType == WorldSettings.GameType.SPECTATOR) {
                return false;
            }
            if (!this.thisPlayerMP.func_175142_cm()) {
                final ItemStack lllllllllllllllIlIIlllllllIlllIl = this.thisPlayerMP.getCurrentEquippedItem();
                if (lllllllllllllllIlIIlllllllIlllIl == null) {
                    return false;
                }
                if (!lllllllllllllllIlIIlllllllIlllIl.canDestroy(lllllllllllllllIlIIllllllllIIIII.getBlock())) {
                    return false;
                }
            }
        }
        this.theWorld.playAuxSFXAtEntity(this.thisPlayerMP, 2001, lllllllllllllllIlIIlllllllIlIIll, Block.getStateId(lllllllllllllllIlIIllllllllIIIII));
        final boolean lllllllllllllllIlIIlllllllIllIll = this.func_180235_c(lllllllllllllllIlIIlllllllIlIIll);
        if (this.isCreative()) {
            this.thisPlayerMP.playerNetServerHandler.sendPacket(new S23PacketBlockChange(this.theWorld, lllllllllllllllIlIIlllllllIlIIll));
        }
        else {
            final ItemStack lllllllllllllllIlIIlllllllIllIIl = this.thisPlayerMP.getCurrentEquippedItem();
            final boolean lllllllllllllllIlIIlllllllIlIlll = this.thisPlayerMP.canHarvestBlock(lllllllllllllllIlIIllllllllIIIII.getBlock());
            if (lllllllllllllllIlIIlllllllIllIIl != null) {
                lllllllllllllllIlIIlllllllIllIIl.onBlockDestroyed(this.theWorld, lllllllllllllllIlIIllllllllIIIII.getBlock(), lllllllllllllllIlIIlllllllIlIIll, this.thisPlayerMP);
                if (lllllllllllllllIlIIlllllllIllIIl.stackSize == 0) {
                    this.thisPlayerMP.destroyCurrentEquippedItem();
                }
            }
            if (lllllllllllllllIlIIlllllllIllIll && lllllllllllllllIlIIlllllllIlIlll) {
                lllllllllllllllIlIIllllllllIIIII.getBlock().harvestBlock(this.theWorld, this.thisPlayerMP, lllllllllllllllIlIIlllllllIlIIll, lllllllllllllllIlIIllllllllIIIII, lllllllllllllllIlIIlllllllIlllll);
            }
        }
        return lllllllllllllllIlIIlllllllIllIll;
    }
    
    public void initializeGameType(final WorldSettings.GameType lllllllllllllllIlIlIIIIIIlllIlII) {
        if (this.gameType == WorldSettings.GameType.NOT_SET) {
            this.gameType = lllllllllllllllIlIlIIIIIIlllIlII;
        }
        this.setGameType(this.gameType);
    }
    
    public void setWorld(final WorldServer lllllllllllllllIlIIlllllIlIlIlII) {
        this.theWorld = lllllllllllllllIlIIlllllIlIlIlII;
    }
    
    public boolean tryUseItem(final EntityPlayer lllllllllllllllIlIIllllllIllIIlI, final World lllllllllllllllIlIIllllllIllIIII, final ItemStack lllllllllllllllIlIIllllllIlIlllI) {
        if (this.gameType == WorldSettings.GameType.SPECTATOR) {
            return false;
        }
        final int lllllllllllllllIlIIllllllIlllIlI = lllllllllllllllIlIIllllllIlIlllI.stackSize;
        final int lllllllllllllllIlIIllllllIlllIII = lllllllllllllllIlIIllllllIlIlllI.getMetadata();
        final ItemStack lllllllllllllllIlIIllllllIllIllI = lllllllllllllllIlIIllllllIlIlllI.useItemRightClick(lllllllllllllllIlIIllllllIllIIII, lllllllllllllllIlIIllllllIllIIlI);
        if (lllllllllllllllIlIIllllllIllIllI == lllllllllllllllIlIIllllllIlIlllI && (lllllllllllllllIlIIllllllIllIllI == null || (lllllllllllllllIlIIllllllIllIllI.stackSize == lllllllllllllllIlIIllllllIlllIlI && lllllllllllllllIlIIllllllIllIllI.getMaxItemUseDuration() <= 0 && lllllllllllllllIlIIllllllIllIllI.getMetadata() == lllllllllllllllIlIIllllllIlllIII))) {
            return false;
        }
        lllllllllllllllIlIIllllllIllIIlI.inventory.mainInventory[lllllllllllllllIlIIllllllIllIIlI.inventory.currentItem] = lllllllllllllllIlIIllllllIllIllI;
        if (this.isCreative()) {
            lllllllllllllllIlIIllllllIllIllI.stackSize = lllllllllllllllIlIIllllllIlllIlI;
            if (lllllllllllllllIlIIllllllIllIllI.isItemStackDamageable()) {
                lllllllllllllllIlIIllllllIllIllI.setItemDamage(lllllllllllllllIlIIllllllIlllIII);
            }
        }
        if (lllllllllllllllIlIIllllllIllIllI.stackSize == 0) {
            lllllllllllllllIlIIllllllIllIIlI.inventory.mainInventory[lllllllllllllllIlIIllllllIllIIlI.inventory.currentItem] = null;
        }
        if (!lllllllllllllllIlIIllllllIllIIlI.isUsingItem()) {
            ((EntityPlayerMP)lllllllllllllllIlIIllllllIllIIlI).sendContainerToPlayer(lllllllllllllllIlIIllllllIllIIlI.inventoryContainer);
        }
        return true;
    }
    
    public boolean func_180239_c() {
        return this.gameType.isSurvivalOrAdventure();
    }
    
    public WorldSettings.GameType getGameType() {
        return this.gameType;
    }
    
    public ItemInWorldManager(final World lllllllllllllllIlIlIIIIIlIIllIII) {
        this.gameType = WorldSettings.GameType.NOT_SET;
        this.field_180240_f = BlockPos.ORIGIN;
        this.field_180241_i = BlockPos.ORIGIN;
        this.durabilityRemainingOnBlock = -1;
        this.theWorld = lllllllllllllllIlIlIIIIIlIIllIII;
    }
    
    private boolean func_180235_c(final BlockPos lllllllllllllllIlIIllllllllllllI) {
        final IBlockState lllllllllllllllIlIlIIIIIIIIIIlII = this.theWorld.getBlockState(lllllllllllllllIlIIllllllllllllI);
        lllllllllllllllIlIlIIIIIIIIIIlII.getBlock().onBlockHarvested(this.theWorld, lllllllllllllllIlIIllllllllllllI, lllllllllllllllIlIlIIIIIIIIIIlII, this.thisPlayerMP);
        final boolean lllllllllllllllIlIlIIIIIIIIIIIlI = this.theWorld.setBlockToAir(lllllllllllllllIlIIllllllllllllI);
        if (lllllllllllllllIlIlIIIIIIIIIIIlI) {
            lllllllllllllllIlIlIIIIIIIIIIlII.getBlock().onBlockDestroyedByPlayer(this.theWorld, lllllllllllllllIlIIllllllllllllI, lllllllllllllllIlIlIIIIIIIIIIlII);
        }
        return lllllllllllllllIlIlIIIIIIIIIIIlI;
    }
    
    public boolean isCreative() {
        return this.gameType.isCreative();
    }
    
    public void func_180784_a(final BlockPos lllllllllllllllIlIlIIIIIIIlIlIlI, final EnumFacing lllllllllllllllIlIlIIIIIIIlIlIIl) {
        if (this.isCreative()) {
            if (!this.theWorld.func_175719_a(null, lllllllllllllllIlIlIIIIIIIlIlIlI, lllllllllllllllIlIlIIIIIIIlIlIIl)) {
                this.func_180237_b(lllllllllllllllIlIlIIIIIIIlIlIlI);
            }
        }
        else {
            final Block lllllllllllllllIlIlIIIIIIIlIllll = this.theWorld.getBlockState(lllllllllllllllIlIlIIIIIIIlIlIlI).getBlock();
            if (this.gameType.isAdventure()) {
                if (this.gameType == WorldSettings.GameType.SPECTATOR) {
                    return;
                }
                if (!this.thisPlayerMP.func_175142_cm()) {
                    final ItemStack lllllllllllllllIlIlIIIIIIIlIlllI = this.thisPlayerMP.getCurrentEquippedItem();
                    if (lllllllllllllllIlIlIIIIIIIlIlllI == null) {
                        return;
                    }
                    if (!lllllllllllllllIlIlIIIIIIIlIlllI.canDestroy(lllllllllllllllIlIlIIIIIIIlIllll)) {
                        return;
                    }
                }
            }
            this.theWorld.func_175719_a(null, lllllllllllllllIlIlIIIIIIIlIlIlI, lllllllllllllllIlIlIIIIIIIlIlIIl);
            this.initialDamage = this.curblockDamage;
            float lllllllllllllllIlIlIIIIIIIlIllIl = 1.0f;
            if (lllllllllllllllIlIlIIIIIIIlIllll.getMaterial() != Material.air) {
                lllllllllllllllIlIlIIIIIIIlIllll.onBlockClicked(this.theWorld, lllllllllllllllIlIlIIIIIIIlIlIlI, this.thisPlayerMP);
                lllllllllllllllIlIlIIIIIIIlIllIl = lllllllllllllllIlIlIIIIIIIlIllll.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.worldObj, lllllllllllllllIlIlIIIIIIIlIlIlI);
            }
            if (lllllllllllllllIlIlIIIIIIIlIllll.getMaterial() != Material.air && lllllllllllllllIlIlIIIIIIIlIllIl >= 1.0f) {
                this.func_180237_b(lllllllllllllllIlIlIIIIIIIlIlIlI);
            }
            else {
                this.isDestroyingBlock = true;
                this.field_180240_f = lllllllllllllllIlIlIIIIIIIlIlIlI;
                final int lllllllllllllllIlIlIIIIIIIlIllII = (int)(lllllllllllllllIlIlIIIIIIIlIllIl * 10.0f);
                this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), lllllllllllllllIlIlIIIIIIIlIlIlI, lllllllllllllllIlIlIIIIIIIlIllII);
                this.durabilityRemainingOnBlock = lllllllllllllllIlIlIIIIIIIlIllII;
            }
        }
    }
    
    public boolean func_180236_a(final EntityPlayer lllllllllllllllIlIIlllllIlllIIII, final World lllllllllllllllIlIIlllllIllIllll, final ItemStack lllllllllllllllIlIIllllllIIIIIIl, final BlockPos lllllllllllllllIlIIlllllIlllllll, final EnumFacing lllllllllllllllIlIIlllllIlllllIl, final float lllllllllllllllIlIIlllllIllllIll, final float lllllllllllllllIlIIlllllIllIIlIl, final float lllllllllllllllIlIIlllllIllIIIll) {
        if (this.gameType == WorldSettings.GameType.SPECTATOR) {
            final TileEntity lllllllllllllllIlIIlllllIllllIII = lllllllllllllllIlIIlllllIllIllll.getTileEntity(lllllllllllllllIlIIlllllIlllllll);
            if (lllllllllllllllIlIIlllllIllllIII instanceof ILockableContainer) {
                final Block lllllllllllllllIlIIlllllIlllIlll = lllllllllllllllIlIIlllllIllIllll.getBlockState(lllllllllllllllIlIIlllllIlllllll).getBlock();
                ILockableContainer lllllllllllllllIlIIlllllIlllIllI = (ILockableContainer)lllllllllllllllIlIIlllllIllllIII;
                if (lllllllllllllllIlIIlllllIlllIllI instanceof TileEntityChest && lllllllllllllllIlIIlllllIlllIlll instanceof BlockChest) {
                    lllllllllllllllIlIIlllllIlllIllI = ((BlockChest)lllllllllllllllIlIIlllllIlllIlll).getLockableContainer(lllllllllllllllIlIIlllllIllIllll, lllllllllllllllIlIIlllllIlllllll);
                }
                if (lllllllllllllllIlIIlllllIlllIllI != null) {
                    lllllllllllllllIlIIlllllIlllIIII.displayGUIChest(lllllllllllllllIlIIlllllIlllIllI);
                    return true;
                }
            }
            else if (lllllllllllllllIlIIlllllIllllIII instanceof IInventory) {
                lllllllllllllllIlIIlllllIlllIIII.displayGUIChest((IInventory)lllllllllllllllIlIIlllllIllllIII);
                return true;
            }
            return false;
        }
        if (!lllllllllllllllIlIIlllllIlllIIII.isSneaking() || lllllllllllllllIlIIlllllIlllIIII.getHeldItem() == null) {
            final IBlockState lllllllllllllllIlIIlllllIlllIlIl = lllllllllllllllIlIIlllllIllIllll.getBlockState(lllllllllllllllIlIIlllllIlllllll);
            if (lllllllllllllllIlIIlllllIlllIlIl.getBlock().onBlockActivated(lllllllllllllllIlIIlllllIllIllll, lllllllllllllllIlIIlllllIlllllll, lllllllllllllllIlIIlllllIlllIlIl, lllllllllllllllIlIIlllllIlllIIII, lllllllllllllllIlIIlllllIlllllIl, lllllllllllllllIlIIlllllIllllIll, lllllllllllllllIlIIlllllIllIIlIl, lllllllllllllllIlIIlllllIllIIIll)) {
                return true;
            }
        }
        if (lllllllllllllllIlIIllllllIIIIIIl == null) {
            return false;
        }
        if (this.isCreative()) {
            final int lllllllllllllllIlIIlllllIlllIlII = lllllllllllllllIlIIllllllIIIIIIl.getMetadata();
            final int lllllllllllllllIlIIlllllIlllIIll = lllllllllllllllIlIIllllllIIIIIIl.stackSize;
            final boolean lllllllllllllllIlIIlllllIlllIIlI = lllllllllllllllIlIIllllllIIIIIIl.onItemUse(lllllllllllllllIlIIlllllIlllIIII, lllllllllllllllIlIIlllllIllIllll, lllllllllllllllIlIIlllllIlllllll, lllllllllllllllIlIIlllllIlllllIl, lllllllllllllllIlIIlllllIllllIll, lllllllllllllllIlIIlllllIllIIlIl, lllllllllllllllIlIIlllllIllIIIll);
            lllllllllllllllIlIIllllllIIIIIIl.setItemDamage(lllllllllllllllIlIIlllllIlllIlII);
            lllllllllllllllIlIIllllllIIIIIIl.stackSize = lllllllllllllllIlIIlllllIlllIIll;
            return lllllllllllllllIlIIlllllIlllIIlI;
        }
        return lllllllllllllllIlIIllllllIIIIIIl.onItemUse(lllllllllllllllIlIIlllllIlllIIII, lllllllllllllllIlIIlllllIllIllll, lllllllllllllllIlIIlllllIlllllll, lllllllllllllllIlIIlllllIlllllIl, lllllllllllllllIlIIlllllIllllIll, lllllllllllllllIlIIlllllIllIIlIl, lllllllllllllllIlIIlllllIllIIIll);
    }
    
    static {
        __OBFID = "CL_00001442";
    }
    
    public void func_180785_a(final BlockPos lllllllllllllllIlIlIIIIIIIIlllll) {
        if (lllllllllllllllIlIlIIIIIIIIlllll.equals(this.field_180240_f)) {
            final int lllllllllllllllIlIlIIIIIIIIllllI = this.curblockDamage - this.initialDamage;
            final Block lllllllllllllllIlIlIIIIIIIIlllIl = this.theWorld.getBlockState(lllllllllllllllIlIlIIIIIIIIlllll).getBlock();
            if (lllllllllllllllIlIlIIIIIIIIlllIl.getMaterial() != Material.air) {
                final float lllllllllllllllIlIlIIIIIIIIlllII = lllllllllllllllIlIlIIIIIIIIlllIl.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.worldObj, lllllllllllllllIlIlIIIIIIIIlllll) * (lllllllllllllllIlIlIIIIIIIIllllI + 1);
                if (lllllllllllllllIlIlIIIIIIIIlllII >= 0.7f) {
                    this.isDestroyingBlock = false;
                    this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), lllllllllllllllIlIlIIIIIIIIlllll, -1);
                    this.func_180237_b(lllllllllllllllIlIlIIIIIIIIlllll);
                }
                else if (!this.receivedFinishDiggingPacket) {
                    this.isDestroyingBlock = false;
                    this.receivedFinishDiggingPacket = true;
                    this.field_180241_i = lllllllllllllllIlIlIIIIIIIIlllll;
                    this.initialBlockDamage = this.initialDamage;
                }
            }
        }
    }
    
    public void updateBlockRemoving() {
        ++this.curblockDamage;
        if (this.receivedFinishDiggingPacket) {
            final int lllllllllllllllIlIlIIIIIIlIIllII = this.curblockDamage - this.initialBlockDamage;
            final Block lllllllllllllllIlIlIIIIIIlIIlIlI = this.theWorld.getBlockState(this.field_180241_i).getBlock();
            if (lllllllllllllllIlIlIIIIIIlIIlIlI.getMaterial() == Material.air) {
                this.receivedFinishDiggingPacket = false;
            }
            else {
                final float lllllllllllllllIlIlIIIIIIlIlIlII = lllllllllllllllIlIlIIIIIIlIIlIlI.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.worldObj, this.field_180241_i) * (lllllllllllllllIlIlIIIIIIlIIllII + 1);
                final int lllllllllllllllIlIlIIIIIIlIlIIII = (int)(lllllllllllllllIlIlIIIIIIlIlIlII * 10.0f);
                if (lllllllllllllllIlIlIIIIIIlIlIIII != this.durabilityRemainingOnBlock) {
                    this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.field_180241_i, lllllllllllllllIlIlIIIIIIlIlIIII);
                    this.durabilityRemainingOnBlock = lllllllllllllllIlIlIIIIIIlIlIIII;
                }
                if (lllllllllllllllIlIlIIIIIIlIlIlII >= 1.0f) {
                    this.receivedFinishDiggingPacket = false;
                    this.func_180237_b(this.field_180241_i);
                }
            }
        }
        else if (this.isDestroyingBlock) {
            final Block lllllllllllllllIlIlIIIIIIlIIlIII = this.theWorld.getBlockState(this.field_180240_f).getBlock();
            if (lllllllllllllllIlIlIIIIIIlIIlIII.getMaterial() == Material.air) {
                this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.field_180240_f, -1);
                this.durabilityRemainingOnBlock = -1;
                this.isDestroyingBlock = false;
            }
            else {
                final int lllllllllllllllIlIlIIIIIIlIIIlll = this.curblockDamage - this.initialDamage;
                final float lllllllllllllllIlIlIIIIIIlIlIIlI = lllllllllllllllIlIlIIIIIIlIIlIII.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.worldObj, this.field_180241_i) * (lllllllllllllllIlIlIIIIIIlIIIlll + 1);
                final int lllllllllllllllIlIlIIIIIIlIIlllI = (int)(lllllllllllllllIlIlIIIIIIlIlIIlI * 10.0f);
                if (lllllllllllllllIlIlIIIIIIlIIlllI != this.durabilityRemainingOnBlock) {
                    this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.field_180240_f, lllllllllllllllIlIlIIIIIIlIIlllI);
                    this.durabilityRemainingOnBlock = lllllllllllllllIlIlIIIIIIlIIlllI;
                }
            }
        }
    }
    
    public void func_180238_e() {
        this.isDestroyingBlock = false;
        this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.field_180240_f, -1);
    }
    
    public void setGameType(final WorldSettings.GameType lllllllllllllllIlIlIIIIIlIIlIIII) {
        this.gameType = lllllllllllllllIlIlIIIIIlIIlIIII;
        lllllllllllllllIlIlIIIIIlIIlIIII.configurePlayerCapabilities(this.thisPlayerMP.capabilities);
        this.thisPlayerMP.sendPlayerAbilities();
        this.thisPlayerMP.mcServer.getConfigurationManager().sendPacketToAllPlayers(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.UPDATE_GAME_MODE, new EntityPlayerMP[] { this.thisPlayerMP }));
    }
}
