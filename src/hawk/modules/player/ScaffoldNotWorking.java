package hawk.modules.player;

import hawk.modules.*;
import hawk.util.*;
import java.util.*;
import net.minecraft.block.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.init.*;
import net.minecraft.network.*;
import net.minecraft.network.play.client.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class ScaffoldNotWorking extends Module
{
    /* synthetic */ Timer timer;
    private /* synthetic */ int slot;
    private /* synthetic */ BlockData blockData;
    
    @Override
    public void onEvent(final Event llllllllllllllIIIlllIIIIlIIllIlI) {
        if (llllllllllllllIIIlllIIIIlIIllIlI instanceof EventMotion) {
            if (llllllllllllllIIIlllIIIIlIIllIlI.isPre()) {
                final int llllllllllllllIIIlllIIIIlIlIIlll = this.getBlockSlot();
                this.blockData = null;
                this.slot = -1;
                if (!this.mc.thePlayer.isSneaking() && llllllllllllllIIIlllIIIIlIlIIlll != -1) {
                    final EventMotion llllllllllllllIIIlllIIIIlIlIIllI = (EventMotion)llllllllllllllIIIlllIIIIlIIllIlI;
                    final double llllllllllllllIIIlllIIIIlIlIIlIl = Math.cos(Math.toRadians(this.mc.thePlayer.rotationYaw + 90.0f));
                    final double llllllllllllllIIIlllIIIIlIlIIlII = Math.sin(Math.toRadians(this.mc.thePlayer.rotationYaw + 90.0f));
                    final double llllllllllllllIIIlllIIIIlIlIIIll = MovementInput.moveForward * 0.4 * llllllllllllllIIIlllIIIIlIlIIlIl + MovementInput.moveStrafe * 0.4 * llllllllllllllIIIlllIIIIlIlIIlII;
                    final double llllllllllllllIIIlllIIIIlIlIIIlI = MovementInput.moveForward * 0.4 * llllllllllllllIIIlllIIIIlIlIIlII - MovementInput.moveStrafe * 0.4 * llllllllllllllIIIlllIIIIlIlIIlIl;
                    final double llllllllllllllIIIlllIIIIlIlIIIIl = this.mc.thePlayer.posX + llllllllllllllIIIlllIIIIlIlIIIll;
                    final double llllllllllllllIIIlllIIIIlIlIIIII = this.mc.thePlayer.posY - 1.0;
                    final double llllllllllllllIIIlllIIIIlIIlllll = this.mc.thePlayer.posZ + llllllllllllllIIIlllIIIIlIlIIIlI;
                    final BlockPos llllllllllllllIIIlllIIIIlIIllllI = new BlockPos(llllllllllllllIIIlllIIIIlIlIIIIl, llllllllllllllIIIlllIIIIlIlIIIII, llllllllllllllIIIlllIIIIlIIlllll);
                    if (this.mc.theWorld.getBlockState(llllllllllllllIIIlllIIIIlIIllllI).getBlock() == Blocks.air) {
                        this.blockData = getBlockData(llllllllllllllIIIlllIIIIlIIllllI, (List)this.blockData);
                        this.slot = llllllllllllllIIIlllIIIIlIlIIlll;
                        if (this.blockData != null && this.mc.thePlayer != null) {
                            llllllllllllllIIIlllIIIIlIlIIllI.setYaw(ScaffoldHelper.getBlockRotations(this.blockData.position.getX(), this.blockData.position.getY(), this.blockData.position.getZ(), this.blockData.face)[0]);
                            llllllllllllllIIIlllIIIIlIlIIllI.setPitch(ScaffoldHelper.getBlockRotations(this.blockData.position.getX(), this.blockData.position.getY(), this.blockData.position.getZ(), this.blockData.face)[1]);
                        }
                    }
                }
            }
            else if (llllllllllllllIIIlllIIIIlIIllIlI.isPre() && this.blockData != null && this.timer.hasTimeElapsed(75L, true) && this.slot != -1) {
                this.mc.rightClickDelayTimer = 3;
                if (this.mc.gameSettings.keyBindJump.pressed && MovementInput.moveForward == 0.0f && MovementInput.moveStrafe == 0.0f) {
                    this.mc.thePlayer.jump();
                    this.mc.thePlayer.motionY = 0.0;
                }
                final boolean llllllllllllllIIIlllIIIIlIIlllIl = this.mc.thePlayer.inventory.currentItem != this.slot;
                if (llllllllllllllIIIlllIIIIlIIlllIl) {
                    this.mc.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(this.slot));
                }
                if (this.mc.playerController.func_178890_a(this.mc.thePlayer, this.mc.theWorld, this.mc.thePlayer.inventoryContainer.getSlot(36 + this.slot).getStack(), this.blockData.position, this.blockData.face, new Vec3(this.blockData.position.getX(), this.blockData.position.getY(), this.blockData.position.getZ()))) {
                    this.mc.thePlayer.sendQueue.addToSendQueue(new C0APacketAnimation());
                }
                if (llllllllllllllIIIlllIIIIlIIlllIl) {
                    this.mc.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(this.mc.thePlayer.inventory.currentItem));
                }
            }
        }
    }
    
    public static BlockData getBlockData(final BlockPos llllllllllllllIIIlllIIIIlIIIllII, final List llllllllllllllIIIlllIIIIlIIIllIl) {
        System.out.println(String.valueOf(new StringBuilder().append(llllllllllllllIIIlllIIIIlIIIllIl)));
        return llllllllllllllIIIlllIIIIlIIIllIl.contains(Minecraft.getMinecraft().theWorld.getBlockState(llllllllllllllIIIlllIIIIlIIIllII.add(0, -1, 0)).getBlock()) ? (llllllllllllllIIIlllIIIIlIIIllIl.contains(Minecraft.getMinecraft().theWorld.getBlockState(llllllllllllllIIIlllIIIIlIIIllII.add(-1, 0, 0)).getBlock()) ? (llllllllllllllIIIlllIIIIlIIIllIl.contains(Minecraft.getMinecraft().theWorld.getBlockState(llllllllllllllIIIlllIIIIlIIIllII.add(1, 0, 0)).getBlock()) ? (llllllllllllllIIIlllIIIIlIIIllIl.contains(Minecraft.getMinecraft().theWorld.getBlockState(llllllllllllllIIIlllIIIIlIIIllII.add(0, 0, -1)).getBlock()) ? (llllllllllllllIIIlllIIIIlIIIllIl.contains(Minecraft.getMinecraft().theWorld.getBlockState(llllllllllllllIIIlllIIIIlIIIllII.add(0, 0, 1)).getBlock()) ? null : new BlockData(llllllllllllllIIIlllIIIIlIIIllII.add(0, 0, 1), EnumFacing.NORTH)) : new BlockData(llllllllllllllIIIlllIIIIlIIIllII.add(0, 0, -1), EnumFacing.SOUTH)) : new BlockData(llllllllllllllIIIlllIIIIlIIIllII.add(1, 0, 0), EnumFacing.WEST)) : new BlockData(llllllllllllllIIIlllIIIIlIIIllII.add(-1, 0, 0), EnumFacing.EAST)) : new BlockData(llllllllllllllIIIlllIIIIlIIIllII.add(0, -1, 0), EnumFacing.UP);
    }
    
    public static Block getBlock(final int llllllllllllllIIIlllIIIIlIIIIlII, final int llllllllllllllIIIlllIIIIlIIIIIll, final int llllllllllllllIIIlllIIIIlIIIIlIl) {
        return Minecraft.getMinecraft().theWorld.getBlockState(new BlockPos(llllllllllllllIIIlllIIIIlIIIIlII, llllllllllllllIIIlllIIIIlIIIIIll, llllllllllllllIIIlllIIIIlIIIIlIl)).getBlock();
    }
    
    public ScaffoldNotWorking() {
        super("Crash the game - Scaffold", 0, Category.PLAYER);
        this.timer = new Timer();
    }
    
    private int getBlockSlot() {
        for (int llllllllllllllIIIlllIIIIIlllllIl = 36; llllllllllllllIIIlllIIIIIlllllIl < 45; ++llllllllllllllIIIlllIIIIIlllllIl) {
            final ItemStack llllllllllllllIIIlllIIIIIlllllII = this.mc.thePlayer.inventoryContainer.getSlot(llllllllllllllIIIlllIIIIIlllllIl).getStack();
            if (llllllllllllllIIIlllIIIIIlllllII != null && llllllllllllllIIIlllIIIIIlllllII.getItem() instanceof ItemBlock) {
                return llllllllllllllIIIlllIIIIIlllllIl - 36;
            }
        }
        return -1;
    }
    
    public static class BlockData
    {
        public /* synthetic */ BlockPos position;
        public /* synthetic */ EnumFacing face;
        
        public BlockData(final BlockPos lIlIllIIIlIII, final EnumFacing lIlIllIIIIlII) {
            this.position = lIlIllIIIlIII;
            this.face = lIlIllIIIIlII;
        }
    }
}
