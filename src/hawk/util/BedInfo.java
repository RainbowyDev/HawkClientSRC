package hawk.util;

import net.minecraft.util.*;
import net.minecraft.client.*;
import hawk.modules.player.*;
import net.minecraft.block.*;

public class BedInfo
{
    public /* synthetic */ EnumFacing face;
    public /* synthetic */ BlockPos pos;
    public static /* synthetic */ Minecraft mc;
    
    public BedInfo findBed() {
        try {
            if (Bednuker.lastBed != null && BedInfo.mc.thePlayer.getDistance(Bednuker.lastBed.pos.getX(), Bednuker.lastBed.pos.getY(), Bednuker.lastBed.pos.getZ()) <= 4.0 && BedInfo.mc.theWorld.getBlockState(Bednuker.lastBed.pos).getBlock() instanceof BlockBed) {
                return Bednuker.lastBed;
            }
        }
        catch (Exception ex) {}
        BlockPos llllllllllllllIIlIIIIlllIlIlIllI = null;
        EnumFacing llllllllllllllIIlIIIIlllIlIlIlIl = null;
        final int llllllllllllllIIlIIIIlllIlIIIlIl;
        final short llllllllllllllIIlIIIIlllIlIIIllI = (short)((EnumFacing[])(Object)(llllllllllllllIIlIIIIlllIlIIIlIl = (int)(Object)EnumFacing.VALUES)).length;
        for (char llllllllllllllIIlIIIIlllIlIIIlll = '\0'; llllllllllllllIIlIIIIlllIlIIIlll < llllllllllllllIIlIIIIlllIlIIIllI; ++llllllllllllllIIlIIIIlllIlIIIlll) {
            final EnumFacing llllllllllllllIIlIIIIlllIlIlIlII = llllllllllllllIIlIIIIlllIlIIIlIl[llllllllllllllIIlIIIIlllIlIIIlll];
            final BlockPos llllllllllllllIIlIIIIlllIlIlIIll = BedInfo.mc.thePlayer.getPosition();
            if (BedInfo.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlllIlIlIIll.offset(llllllllllllllIIlIIIIlllIlIlIlII)).getBlock() instanceof BlockBed) {
                llllllllllllllIIlIIIIlllIlIlIllI = llllllllllllllIIlIIIIlllIlIlIIll.offset(llllllllllllllIIlIIIIlllIlIlIlII);
                llllllllllllllIIlIIIIlllIlIlIlIl = llllllllllllllIIlIIIIlllIlIlIlII.getOpposite();
                break;
            }
            final boolean llllllllllllllIIlIIIIlllIlIIIIII;
            final char llllllllllllllIIlIIIIlllIlIIIIIl = (char)((EnumFacing[])(Object)(llllllllllllllIIlIIIIlllIlIIIIII = (boolean)(Object)EnumFacing.VALUES)).length;
            for (long llllllllllllllIIlIIIIlllIlIIIIlI = 0; llllllllllllllIIlIIIIlllIlIIIIlI < llllllllllllllIIlIIIIlllIlIIIIIl; ++llllllllllllllIIlIIIIlllIlIIIIlI) {
                final EnumFacing llllllllllllllIIlIIIIlllIlIlIIlI = llllllllllllllIIlIIIIlllIlIIIIII[llllllllllllllIIlIIIIlllIlIIIIlI];
                final BlockPos llllllllllllllIIlIIIIlllIlIlIIIl = llllllllllllllIIlIIIIlllIlIlIIll.offset(llllllllllllllIIlIIIIlllIlIlIIlI);
                if (BedInfo.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlllIlIlIIIl).getBlock() instanceof BlockBed) {
                    llllllllllllllIIlIIIIlllIlIlIllI = llllllllllllllIIlIIIIlllIlIlIIIl;
                    llllllllllllllIIlIIIIlllIlIlIlIl = llllllllllllllIIlIIIIlllIlIlIIlI.getOpposite();
                    break;
                }
                final byte llllllllllllllIIlIIIIlllIIlllIll;
                final float llllllllllllllIIlIIIIlllIIllllII = ((EnumFacing[])(Object)(llllllllllllllIIlIIIIlllIIlllIll = (byte)(Object)EnumFacing.VALUES)).length;
                for (boolean llllllllllllllIIlIIIIlllIIllllIl = false; (llllllllllllllIIlIIIIlllIIllllIl ? 1 : 0) < llllllllllllllIIlIIIIlllIIllllII; ++llllllllllllllIIlIIIIlllIIllllIl) {
                    final EnumFacing llllllllllllllIIlIIIIlllIlIlIIII = llllllllllllllIIlIIIIlllIIlllIll[llllllllllllllIIlIIIIlllIIllllIl];
                    final BlockPos llllllllllllllIIlIIIIlllIlIIllll = llllllllllllllIIlIIIIlllIlIlIIIl.offset(llllllllllllllIIlIIIIlllIlIlIIII);
                    if (BedInfo.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlllIlIIllll).getBlock() instanceof BlockBed) {
                        llllllllllllllIIlIIIIlllIlIlIllI = llllllllllllllIIlIIIIlllIlIIllll;
                        llllllllllllllIIlIIIIlllIlIlIlIl = llllllllllllllIIlIIIIlllIlIlIIII.getOpposite();
                        break;
                    }
                    final float llllllllllllllIIlIIIIlllIIllIllI;
                    final short llllllllllllllIIlIIIIlllIIllIlll = (short)((EnumFacing[])(Object)(llllllllllllllIIlIIIIlllIIllIllI = (float)(Object)EnumFacing.VALUES)).length;
                    for (long llllllllllllllIIlIIIIlllIIlllIII = 0; llllllllllllllIIlIIIIlllIIlllIII < llllllllllllllIIlIIIIlllIIllIlll; ++llllllllllllllIIlIIIIlllIIlllIII) {
                        final EnumFacing llllllllllllllIIlIIIIlllIlIIlllI = llllllllllllllIIlIIIIlllIIllIllI[llllllllllllllIIlIIIIlllIIlllIII];
                        final BlockPos llllllllllllllIIlIIIIlllIlIIllIl = llllllllllllllIIlIIIIlllIlIIllll.offset(llllllllllllllIIlIIIIlllIlIIlllI);
                        if (BedInfo.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlllIlIIllIl).getBlock() instanceof BlockBed) {
                            llllllllllllllIIlIIIIlllIlIlIllI = llllllllllllllIIlIIIIlllIlIIllIl;
                            llllllllllllllIIlIIIIlllIlIlIlIl = llllllllllllllIIlIIIIlllIlIIlllI.getOpposite();
                            break;
                        }
                        final String llllllllllllllIIlIIIIlllIIllIIIl;
                        final char llllllllllllllIIlIIIIlllIIllIIlI = (char)((EnumFacing[])(Object)(llllllllllllllIIlIIIIlllIIllIIIl = (String)(Object)EnumFacing.VALUES)).length;
                        for (double llllllllllllllIIlIIIIlllIIllIIll = 0; llllllllllllllIIlIIIIlllIIllIIll < llllllllllllllIIlIIIIlllIIllIIlI; ++llllllllllllllIIlIIIIlllIIllIIll) {
                            final EnumFacing llllllllllllllIIlIIIIlllIlIIllII = llllllllllllllIIlIIIIlllIIllIIIl[llllllllllllllIIlIIIIlllIIllIIll];
                            final BlockPos llllllllllllllIIlIIIIlllIlIIlIll = llllllllllllllIIlIIIIlllIlIIllIl.offset(llllllllllllllIIlIIIIlllIlIIllII);
                            if (BedInfo.mc.theWorld.getBlockState(llllllllllllllIIlIIIIlllIlIIlIll).getBlock() instanceof BlockBed) {
                                llllllllllllllIIlIIIIlllIlIlIllI = llllllllllllllIIlIIIIlllIlIIlIll;
                                llllllllllllllIIlIIIIlllIlIlIlIl = llllllllllllllIIlIIIIlllIlIIllII.getOpposite();
                                break;
                            }
                        }
                    }
                }
            }
        }
        return Bednuker.lastBed = new BedInfo(llllllllllllllIIlIIIIlllIlIlIllI, llllllllllllllIIlIIIIlllIlIlIlIl);
    }
    
    public BedInfo(final BlockPos llllllllllllllIIlIIIIlllIlllIlII, final EnumFacing llllllllllllllIIlIIIIlllIlllIllI) {
        this.pos = llllllllllllllIIlIIIIlllIlllIlII;
        this.face = llllllllllllllIIlIIIIlllIlllIllI;
    }
}
