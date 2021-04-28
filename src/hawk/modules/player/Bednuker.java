package hawk.modules.player;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;
import hawk.modules.combat.*;
import hawk.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.block.*;

public class Bednuker extends Module
{
    public static /* synthetic */ BedInfo lastBed;
    
    @Override
    public void onEvent(final Event llllllllllllllllIlIIIIIIlIllIlII) {
        if (llllllllllllllllIlIIIIIIlIllIlII instanceof EventRender3D && llllllllllllllllIlIIIIIIlIllIlII.isPre()) {
            final BedInfo llllllllllllllllIlIIIIIIlIllllIl = this.findBed();
            final BlockPos llllllllllllllllIlIIIIIIlIllllII = llllllllllllllllIlIIIIIIlIllllIl.pos;
            final EnumFacing llllllllllllllllIlIIIIIIlIlllIll = llllllllllllllllIlIIIIIIlIllllIl.face;
            if (llllllllllllllllIlIIIIIIlIllllII == null || llllllllllllllllIlIIIIIIlIlllIll == null) {
                return;
            }
        }
        if (llllllllllllllllIlIIIIIIlIllIlII instanceof EventMotion && llllllllllllllllIlIIIIIIlIllIlII.isPost()) {
            final BedInfo llllllllllllllllIlIIIIIIlIlllIlI = this.findBed();
            final BlockPos llllllllllllllllIlIIIIIIlIlllIIl = llllllllllllllllIlIIIIIIlIlllIlI.pos;
            final EnumFacing llllllllllllllllIlIIIIIIlIlllIII = llllllllllllllllIlIIIIIIlIlllIlI.face;
            if (llllllllllllllllIlIIIIIIlIlllIIl == null || llllllllllllllllIlIIIIIIlIlllIII == null) {
                return;
            }
            final EventMotion llllllllllllllllIlIIIIIIlIllIlll = (EventMotion)llllllllllllllllIlIIIIIIlIllIlII;
            if (!Killaura.HasTarget) {
                final float[] llllllllllllllllIlIIIIIIlIllIllI = RotationUtils.getRotationFromPosition(llllllllllllllllIlIIIIIIlIlllIIl.getX(), llllllllllllllllIlIIIIIIlIlllIIl.getZ(), llllllllllllllllIlIIIIIIlIlllIIl.getY());
                llllllllllllllllIlIIIIIIlIllIlll.setYaw(llllllllllllllllIlIIIIIIlIllIllI[0]);
                llllllllllllllllIlIIIIIIlIllIlll.setPitch(llllllllllllllllIlIIIIIIlIllIllI[1]);
            }
            this.mc.thePlayer.swingItem();
            this.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, llllllllllllllllIlIIIIIIlIlllIIl, llllllllllllllllIlIIIIIIlIlllIII));
            this.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, llllllllllllllllIlIIIIIIlIlllIIl, llllllllllllllllIlIIIIIIlIlllIII));
        }
    }
    
    static {
        Bednuker.lastBed = null;
    }
    
    public BedInfo findBed() {
        try {
            if (Bednuker.lastBed != null && this.mc.thePlayer.getDistance(Bednuker.lastBed.pos.getX(), Bednuker.lastBed.pos.getY(), Bednuker.lastBed.pos.getZ()) <= 4.0 && this.mc.theWorld.getBlockState(Bednuker.lastBed.pos).getBlock() instanceof BlockBed) {
                return Bednuker.lastBed;
            }
        }
        catch (Exception ex) {}
        BlockPos llllllllllllllllIlIIIIIIlIIlIIIl = null;
        EnumFacing llllllllllllllllIlIIIIIIlIIlIIII = null;
        final String llllllllllllllllIlIIIIIIIlllllll;
        final double llllllllllllllllIlIIIIIIlIIIIIII = ((EnumFacing[])(Object)(llllllllllllllllIlIIIIIIIlllllll = (String)(Object)EnumFacing.VALUES)).length;
        for (long llllllllllllllllIlIIIIIIlIIIIIIl = 0; llllllllllllllllIlIIIIIIlIIIIIIl < llllllllllllllllIlIIIIIIlIIIIIII; ++llllllllllllllllIlIIIIIIlIIIIIIl) {
            final EnumFacing llllllllllllllllIlIIIIIIlIIIllll = llllllllllllllllIlIIIIIIIlllllll[llllllllllllllllIlIIIIIIlIIIIIIl];
            final BlockPos llllllllllllllllIlIIIIIIlIIIlllI = this.mc.thePlayer.getPosition();
            if (this.mc.theWorld.getBlockState(llllllllllllllllIlIIIIIIlIIIlllI.offset(llllllllllllllllIlIIIIIIlIIIllll)).getBlock() instanceof BlockBed) {
                llllllllllllllllIlIIIIIIlIIlIIIl = llllllllllllllllIlIIIIIIlIIIlllI.offset(llllllllllllllllIlIIIIIIlIIIllll);
                llllllllllllllllIlIIIIIIlIIlIIII = llllllllllllllllIlIIIIIIlIIIllll.getOpposite();
                break;
            }
            final String llllllllllllllllIlIIIIIIIllllIlI;
            final long llllllllllllllllIlIIIIIIIllllIll = ((EnumFacing[])(Object)(llllllllllllllllIlIIIIIIIllllIlI = (String)(Object)EnumFacing.VALUES)).length;
            for (final EnumFacing llllllllllllllllIlIIIIIIlIIIllIl : llllllllllllllllIlIIIIIIIllllIlI) {
                final BlockPos llllllllllllllllIlIIIIIIlIIIllII = llllllllllllllllIlIIIIIIlIIIlllI.offset(llllllllllllllllIlIIIIIIlIIIllIl);
                if (this.mc.theWorld.getBlockState(llllllllllllllllIlIIIIIIlIIIllII).getBlock() instanceof BlockBed) {
                    llllllllllllllllIlIIIIIIlIIlIIIl = llllllllllllllllIlIIIIIIlIIIllII;
                    llllllllllllllllIlIIIIIIlIIlIIII = llllllllllllllllIlIIIIIIlIIIllIl.getOpposite();
                    break;
                }
                final int llllllllllllllllIlIIIIIIIlllIlIl;
                final Exception llllllllllllllllIlIIIIIIIlllIllI = (Exception)((EnumFacing[])(Object)(llllllllllllllllIlIIIIIIIlllIlIl = (int)(Object)EnumFacing.VALUES)).length;
                for (boolean llllllllllllllllIlIIIIIIIlllIlll = false; llllllllllllllllIlIIIIIIIlllIlll < llllllllllllllllIlIIIIIIIlllIllI; ++llllllllllllllllIlIIIIIIIlllIlll) {
                    final EnumFacing llllllllllllllllIlIIIIIIlIIIlIll = llllllllllllllllIlIIIIIIIlllIlIl[llllllllllllllllIlIIIIIIIlllIlll];
                    final BlockPos llllllllllllllllIlIIIIIIlIIIlIlI = llllllllllllllllIlIIIIIIlIIIllII.offset(llllllllllllllllIlIIIIIIlIIIlIll);
                    if (this.mc.theWorld.getBlockState(llllllllllllllllIlIIIIIIlIIIlIlI).getBlock() instanceof BlockBed) {
                        llllllllllllllllIlIIIIIIlIIlIIIl = llllllllllllllllIlIIIIIIlIIIlIlI;
                        llllllllllllllllIlIIIIIIlIIlIIII = llllllllllllllllIlIIIIIIlIIIlIll.getOpposite();
                        break;
                    }
                    final byte llllllllllllllllIlIIIIIIIlllIIII;
                    final int llllllllllllllllIlIIIIIIIlllIIIl = ((EnumFacing[])(Object)(llllllllllllllllIlIIIIIIIlllIIII = (byte)(Object)EnumFacing.VALUES)).length;
                    for (Exception llllllllllllllllIlIIIIIIIlllIIlI = (Exception)0; llllllllllllllllIlIIIIIIIlllIIlI < llllllllllllllllIlIIIIIIIlllIIIl; ++llllllllllllllllIlIIIIIIIlllIIlI) {
                        final EnumFacing llllllllllllllllIlIIIIIIlIIIlIIl = llllllllllllllllIlIIIIIIIlllIIII[llllllllllllllllIlIIIIIIIlllIIlI];
                        final BlockPos llllllllllllllllIlIIIIIIlIIIlIII = llllllllllllllllIlIIIIIIlIIIlIlI.offset(llllllllllllllllIlIIIIIIlIIIlIIl);
                        if (this.mc.theWorld.getBlockState(llllllllllllllllIlIIIIIIlIIIlIII).getBlock() instanceof BlockBed) {
                            llllllllllllllllIlIIIIIIlIIlIIIl = llllllllllllllllIlIIIIIIlIIIlIII;
                            llllllllllllllllIlIIIIIIlIIlIIII = llllllllllllllllIlIIIIIIlIIIlIIl.getOpposite();
                            break;
                        }
                        final String llllllllllllllllIlIIIIIIIllIlIll;
                        final short llllllllllllllllIlIIIIIIIllIllII = (short)((EnumFacing[])(Object)(llllllllllllllllIlIIIIIIIllIlIll = (String)(Object)EnumFacing.VALUES)).length;
                        for (long llllllllllllllllIlIIIIIIIllIllIl = 0; llllllllllllllllIlIIIIIIIllIllIl < llllllllllllllllIlIIIIIIIllIllII; ++llllllllllllllllIlIIIIIIIllIllIl) {
                            final EnumFacing llllllllllllllllIlIIIIIIlIIIIlll = llllllllllllllllIlIIIIIIIllIlIll[llllllllllllllllIlIIIIIIIllIllIl];
                            final BlockPos llllllllllllllllIlIIIIIIlIIIIllI = llllllllllllllllIlIIIIIIlIIIlIII.offset(llllllllllllllllIlIIIIIIlIIIIlll);
                            if (this.mc.theWorld.getBlockState(llllllllllllllllIlIIIIIIlIIIIllI).getBlock() instanceof BlockBed) {
                                llllllllllllllllIlIIIIIIlIIlIIIl = llllllllllllllllIlIIIIIIlIIIIllI;
                                llllllllllllllllIlIIIIIIlIIlIIII = llllllllllllllllIlIIIIIIlIIIIlll.getOpposite();
                                break;
                            }
                        }
                    }
                }
            }
        }
        return Bednuker.lastBed = new BedInfo(llllllllllllllllIlIIIIIIlIIlIIIl, llllllllllllllllIlIIIIIIlIIlIIII);
    }
    
    public Bednuker() {
        super("BedBreaker", 0, Category.PLAYER);
    }
}
