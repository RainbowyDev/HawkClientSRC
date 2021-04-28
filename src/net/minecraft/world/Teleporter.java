package net.minecraft.world;

import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import com.google.common.collect.*;

public class Teleporter
{
    private final /* synthetic */ List destinationCoordinateKeys;
    private final /* synthetic */ WorldServer worldServerInstance;
    private final /* synthetic */ LongHashMap destinationCoordinateCache;
    private final /* synthetic */ Random random;
    
    public boolean func_180620_b(final Entity llllllllllllllIIllIllllllIIlllII, final float llllllllllllllIIllIllllllIlllllI) {
        final boolean llllllllllllllIIllIllllllIllllIl = true;
        double llllllllllllllIIllIllllllIllllII = -1.0;
        final int llllllllllllllIIllIllllllIlllIll = MathHelper.floor_double(llllllllllllllIIllIllllllIIlllII.posX);
        final int llllllllllllllIIllIllllllIlllIlI = MathHelper.floor_double(llllllllllllllIIllIllllllIIlllII.posZ);
        boolean llllllllllllllIIllIllllllIlllIIl = true;
        Object llllllllllllllIIllIllllllIlllIII = BlockPos.ORIGIN;
        final long llllllllllllllIIllIllllllIllIlll = ChunkCoordIntPair.chunkXZ2Int(llllllllllllllIIllIllllllIlllIll, llllllllllllllIIllIllllllIlllIlI);
        if (this.destinationCoordinateCache.containsItem(llllllllllllllIIllIllllllIllIlll)) {
            final PortalPosition llllllllllllllIIllIllllllIllIllI = (PortalPosition)this.destinationCoordinateCache.getValueByKey(llllllllllllllIIllIllllllIllIlll);
            llllllllllllllIIllIllllllIllllII = 0.0;
            llllllllllllllIIllIllllllIlllIII = llllllllllllllIIllIllllllIllIllI;
            llllllllllllllIIllIllllllIllIllI.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            llllllllllllllIIllIllllllIlllIIl = false;
        }
        else {
            final BlockPos llllllllllllllIIllIllllllIllIlIl = new BlockPos(llllllllllllllIIllIllllllIIlllII);
            for (int llllllllllllllIIllIllllllIllIlII = -128; llllllllllllllIIllIllllllIllIlII <= 128; ++llllllllllllllIIllIllllllIllIlII) {
                for (int llllllllllllllIIllIllllllIllIIlI = -128; llllllllllllllIIllIllllllIllIIlI <= 128; ++llllllllllllllIIllIllllllIllIIlI) {
                    BlockPos llllllllllllllIIllIllllllIllIIll;
                    for (BlockPos llllllllllllllIIllIllllllIllIIIl = llllllllllllllIIllIllllllIllIlIl.add(llllllllllllllIIllIllllllIllIlII, this.worldServerInstance.getActualHeight() - 1 - llllllllllllllIIllIllllllIllIlIl.getY(), llllllllllllllIIllIllllllIllIIlI); llllllllllllllIIllIllllllIllIIIl.getY() >= 0; llllllllllllllIIllIllllllIllIIIl = llllllllllllllIIllIllllllIllIIll) {
                        llllllllllllllIIllIllllllIllIIll = llllllllllllllIIllIllllllIllIIIl.offsetDown();
                        if (this.worldServerInstance.getBlockState(llllllllllllllIIllIllllllIllIIIl).getBlock() == Blocks.portal) {
                            while (this.worldServerInstance.getBlockState(llllllllllllllIIllIllllllIllIIll = llllllllllllllIIllIllllllIllIIIl.offsetDown()).getBlock() == Blocks.portal) {
                                llllllllllllllIIllIllllllIllIIIl = llllllllllllllIIllIllllllIllIIll;
                            }
                            final double llllllllllllllIIllIllllllIllIIII = llllllllllllllIIllIllllllIllIIIl.distanceSq(llllllllllllllIIllIllllllIllIlIl);
                            if (llllllllllllllIIllIllllllIllllII < 0.0 || llllllllllllllIIllIllllllIllIIII < llllllllllllllIIllIllllllIllllII) {
                                llllllllllllllIIllIllllllIllllII = llllllllllllllIIllIllllllIllIIII;
                                llllllllllllllIIllIllllllIlllIII = llllllllllllllIIllIllllllIllIIIl;
                            }
                        }
                    }
                }
            }
        }
        if (llllllllllllllIIllIllllllIllllII >= 0.0) {
            if (llllllllllllllIIllIllllllIlllIIl) {
                this.destinationCoordinateCache.add(llllllllllllllIIllIllllllIllIlll, new PortalPosition((BlockPos)llllllllllllllIIllIllllllIlllIII, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(llllllllllllllIIllIllllllIllIlll);
            }
            double llllllllllllllIIllIllllllIlIllll = ((BlockPos)llllllllllllllIIllIllllllIlllIII).getX() + 0.5;
            double llllllllllllllIIllIllllllIlIlllI = ((BlockPos)llllllllllllllIIllIllllllIlllIII).getY() + 0.5;
            double llllllllllllllIIllIllllllIlIllIl = ((BlockPos)llllllllllllllIIllIllllllIlllIII).getZ() + 0.5;
            EnumFacing llllllllllllllIIllIllllllIlIllII = null;
            if (this.worldServerInstance.getBlockState(((BlockPos)llllllllllllllIIllIllllllIlllIII).offsetWest()).getBlock() == Blocks.portal) {
                llllllllllllllIIllIllllllIlIllII = EnumFacing.NORTH;
            }
            if (this.worldServerInstance.getBlockState(((BlockPos)llllllllllllllIIllIllllllIlllIII).offsetEast()).getBlock() == Blocks.portal) {
                llllllllllllllIIllIllllllIlIllII = EnumFacing.SOUTH;
            }
            if (this.worldServerInstance.getBlockState(((BlockPos)llllllllllllllIIllIllllllIlllIII).offsetNorth()).getBlock() == Blocks.portal) {
                llllllllllllllIIllIllllllIlIllII = EnumFacing.EAST;
            }
            if (this.worldServerInstance.getBlockState(((BlockPos)llllllllllllllIIllIllllllIlllIII).offsetSouth()).getBlock() == Blocks.portal) {
                llllllllllllllIIllIllllllIlIllII = EnumFacing.WEST;
            }
            final EnumFacing llllllllllllllIIllIllllllIlIlIll = EnumFacing.getHorizontal(llllllllllllllIIllIllllllIIlllII.getTeleportDirection());
            if (llllllllllllllIIllIllllllIlIllII != null) {
                EnumFacing llllllllllllllIIllIllllllIlIlIlI = llllllllllllllIIllIllllllIlIllII.rotateYCCW();
                final BlockPos llllllllllllllIIllIllllllIlIlIIl = ((BlockPos)llllllllllllllIIllIllllllIlllIII).offset(llllllllllllllIIllIllllllIlIllII);
                boolean llllllllllllllIIllIllllllIlIlIII = this.func_180265_a(llllllllllllllIIllIllllllIlIlIIl);
                boolean llllllllllllllIIllIllllllIlIIlll = this.func_180265_a(llllllllllllllIIllIllllllIlIlIIl.offset(llllllllllllllIIllIllllllIlIlIlI));
                if (llllllllllllllIIllIllllllIlIIlll && llllllllllllllIIllIllllllIlIlIII) {
                    llllllllllllllIIllIllllllIlllIII = ((BlockPos)llllllllllllllIIllIllllllIlllIII).offset(llllllllllllllIIllIllllllIlIlIlI);
                    llllllllllllllIIllIllllllIlIllII = llllllllllllllIIllIllllllIlIllII.getOpposite();
                    llllllllllllllIIllIllllllIlIlIlI = llllllllllllllIIllIllllllIlIlIlI.getOpposite();
                    final BlockPos llllllllllllllIIllIllllllIlIIllI = ((BlockPos)llllllllllllllIIllIllllllIlllIII).offset(llllllllllllllIIllIllllllIlIllII);
                    llllllllllllllIIllIllllllIlIlIII = this.func_180265_a(llllllllllllllIIllIllllllIlIIllI);
                    llllllllllllllIIllIllllllIlIIlll = this.func_180265_a(llllllllllllllIIllIllllllIlIIllI.offset(llllllllllllllIIllIllllllIlIlIlI));
                }
                float llllllllllllllIIllIllllllIlIIlIl = 0.5f;
                float llllllllllllllIIllIllllllIlIIlII = 0.5f;
                if (!llllllllllllllIIllIllllllIlIIlll && llllllllllllllIIllIllllllIlIlIII) {
                    llllllllllllllIIllIllllllIlIIlIl = 1.0f;
                }
                else if (llllllllllllllIIllIllllllIlIIlll && !llllllllllllllIIllIllllllIlIlIII) {
                    llllllllllllllIIllIllllllIlIIlIl = 0.0f;
                }
                else if (llllllllllllllIIllIllllllIlIIlll) {
                    llllllllllllllIIllIllllllIlIIlII = 0.0f;
                }
                llllllllllllllIIllIllllllIlIllll = ((BlockPos)llllllllllllllIIllIllllllIlllIII).getX() + 0.5;
                llllllllllllllIIllIllllllIlIlllI = ((BlockPos)llllllllllllllIIllIllllllIlllIII).getY() + 0.5;
                llllllllllllllIIllIllllllIlIllIl = ((BlockPos)llllllllllllllIIllIllllllIlllIII).getZ() + 0.5;
                llllllllllllllIIllIllllllIlIllll += llllllllllllllIIllIllllllIlIlIlI.getFrontOffsetX() * llllllllllllllIIllIllllllIlIIlIl + llllllllllllllIIllIllllllIlIllII.getFrontOffsetX() * llllllllllllllIIllIllllllIlIIlII;
                llllllllllllllIIllIllllllIlIllIl += llllllllllllllIIllIllllllIlIlIlI.getFrontOffsetZ() * llllllllllllllIIllIllllllIlIIlIl + llllllllllllllIIllIllllllIlIllII.getFrontOffsetZ() * llllllllllllllIIllIllllllIlIIlII;
                float llllllllllllllIIllIllllllIlIIIll = 0.0f;
                float llllllllllllllIIllIllllllIlIIIlI = 0.0f;
                float llllllllllllllIIllIllllllIlIIIIl = 0.0f;
                float llllllllllllllIIllIllllllIlIIIII = 0.0f;
                if (llllllllllllllIIllIllllllIlIllII == llllllllllllllIIllIllllllIlIlIll) {
                    llllllllllllllIIllIllllllIlIIIll = 1.0f;
                    llllllllllllllIIllIllllllIlIIIlI = 1.0f;
                }
                else if (llllllllllllllIIllIllllllIlIllII == llllllllllllllIIllIllllllIlIlIll.getOpposite()) {
                    llllllllllllllIIllIllllllIlIIIll = -1.0f;
                    llllllllllllllIIllIllllllIlIIIlI = -1.0f;
                }
                else if (llllllllllllllIIllIllllllIlIllII == llllllllllllllIIllIllllllIlIlIll.rotateY()) {
                    llllllllllllllIIllIllllllIlIIIIl = 1.0f;
                    llllllllllllllIIllIllllllIlIIIII = -1.0f;
                }
                else {
                    llllllllllllllIIllIllllllIlIIIIl = -1.0f;
                    llllllllllllllIIllIllllllIlIIIII = 1.0f;
                }
                final double llllllllllllllIIllIllllllIIlllll = llllllllllllllIIllIllllllIIlllII.motionX;
                final double llllllllllllllIIllIllllllIIllllI = llllllllllllllIIllIllllllIIlllII.motionZ;
                llllllllllllllIIllIllllllIIlllII.motionX = llllllllllllllIIllIllllllIIlllll * llllllllllllllIIllIllllllIlIIIll + llllllllllllllIIllIllllllIIllllI * llllllllllllllIIllIllllllIlIIIII;
                llllllllllllllIIllIllllllIIlllII.motionZ = llllllllllllllIIllIllllllIIlllll * llllllllllllllIIllIllllllIlIIIIl + llllllllllllllIIllIllllllIIllllI * llllllllllllllIIllIllllllIlIIIlI;
                llllllllllllllIIllIllllllIIlllII.rotationYaw = llllllllllllllIIllIllllllIlllllI - llllllllllllllIIllIllllllIlIlIll.getHorizontalIndex() * 90 + llllllllllllllIIllIllllllIlIllII.getHorizontalIndex() * 90;
            }
            else {
                final double motionX = 0.0;
                llllllllllllllIIllIllllllIIlllII.motionZ = motionX;
                llllllllllllllIIllIllllllIIlllII.motionY = motionX;
                llllllllllllllIIllIllllllIIlllII.motionX = motionX;
            }
            llllllllllllllIIllIllllllIIlllII.setLocationAndAngles(llllllllllllllIIllIllllllIlIllll, llllllllllllllIIllIllllllIlIlllI, llllllllllllllIIllIllllllIlIllIl, llllllllllllllIIllIllllllIIlllII.rotationYaw, llllllllllllllIIllIllllllIIlllII.rotationPitch);
            return true;
        }
        return false;
    }
    
    private boolean func_180265_a(final BlockPos llllllllllllllIIllIlllllIlllllII) {
        return !this.worldServerInstance.isAirBlock(llllllllllllllIIllIlllllIlllllII) || !this.worldServerInstance.isAirBlock(llllllllllllllIIllIlllllIlllllII.offsetUp());
    }
    
    public void removeStalePortalLocations(final long llllllllllllllIIllIllllIlllIlIII) {
        if (llllllllllllllIIllIllllIlllIlIII % 100L == 0L) {
            final Iterator llllllllllllllIIllIllllIlllIllIl = this.destinationCoordinateKeys.iterator();
            final long llllllllllllllIIllIllllIlllIllII = llllllllllllllIIllIllllIlllIlIII - 600L;
            while (llllllllllllllIIllIllllIlllIllIl.hasNext()) {
                final Long llllllllllllllIIllIllllIlllIlIll = llllllllllllllIIllIllllIlllIllIl.next();
                final PortalPosition llllllllllllllIIllIllllIlllIlIlI = (PortalPosition)this.destinationCoordinateCache.getValueByKey(llllllllllllllIIllIllllIlllIlIll);
                if (llllllllllllllIIllIllllIlllIlIlI == null || llllllllllllllIIllIllllIlllIlIlI.lastUpdateTime < llllllllllllllIIllIllllIlllIllII) {
                    llllllllllllllIIllIllllIlllIllIl.remove();
                    this.destinationCoordinateCache.remove(llllllllllllllIIllIllllIlllIlIll);
                }
            }
        }
    }
    
    public boolean makePortal(final Entity llllllllllllllIIllIlllllIlIlIlll) {
        final byte llllllllllllllIIllIlllllIlIlIllI = 16;
        double llllllllllllllIIllIlllllIlIlIlIl = -1.0;
        final int llllllllllllllIIllIlllllIlIlIlII = MathHelper.floor_double(llllllllllllllIIllIlllllIlIlIlll.posX);
        final int llllllllllllllIIllIlllllIlIlIIll = MathHelper.floor_double(llllllllllllllIIllIlllllIlIlIlll.posY);
        final int llllllllllllllIIllIlllllIlIlIIlI = MathHelper.floor_double(llllllllllllllIIllIlllllIlIlIlll.posZ);
        int llllllllllllllIIllIlllllIlIlIIIl = llllllllllllllIIllIlllllIlIlIlII;
        int llllllllllllllIIllIlllllIlIlIIII = llllllllllllllIIllIlllllIlIlIIll;
        int llllllllllllllIIllIlllllIlIIllll = llllllllllllllIIllIlllllIlIlIIlI;
        int llllllllllllllIIllIlllllIlIIlllI = 0;
        final int llllllllllllllIIllIlllllIlIIllIl = this.random.nextInt(4);
        for (int llllllllllllllIIllIlllllIlIIllII = llllllllllllllIIllIlllllIlIlIlII - llllllllllllllIIllIlllllIlIlIllI; llllllllllllllIIllIlllllIlIIllII <= llllllllllllllIIllIlllllIlIlIlII + llllllllllllllIIllIlllllIlIlIllI; ++llllllllllllllIIllIlllllIlIIllII) {
            final double llllllllllllllIIllIlllllIlIIlIll = llllllllllllllIIllIlllllIlIIllII + 0.5 - llllllllllllllIIllIlllllIlIlIlll.posX;
            for (int llllllllllllllIIllIlllllIlIIlIIl = llllllllllllllIIllIlllllIlIlIIlI - llllllllllllllIIllIlllllIlIlIllI; llllllllllllllIIllIlllllIlIIlIIl <= llllllllllllllIIllIlllllIlIlIIlI + llllllllllllllIIllIlllllIlIlIllI; ++llllllllllllllIIllIlllllIlIIlIIl) {
                final double llllllllllllllIIllIlllllIlIIIllI = llllllllllllllIIllIlllllIlIIlIIl + 0.5 - llllllllllllllIIllIlllllIlIlIlll.posZ;
            Label_0452:
                for (int llllllllllllllIIllIlllllIlIIIlII = this.worldServerInstance.getActualHeight() - 1; llllllllllllllIIllIlllllIlIIIlII >= 0; --llllllllllllllIIllIlllllIlIIIlII) {
                    if (this.worldServerInstance.isAirBlock(new BlockPos(llllllllllllllIIllIlllllIlIIllII, llllllllllllllIIllIlllllIlIIIlII, llllllllllllllIIllIlllllIlIIlIIl))) {
                        while (llllllllllllllIIllIlllllIlIIIlII > 0 && this.worldServerInstance.isAirBlock(new BlockPos(llllllllllllllIIllIlllllIlIIllII, llllllllllllllIIllIlllllIlIIIlII - 1, llllllllllllllIIllIlllllIlIIlIIl))) {
                            --llllllllllllllIIllIlllllIlIIIlII;
                        }
                        for (int llllllllllllllIIllIlllllIlIIIIIl = llllllllllllllIIllIlllllIlIIllIl; llllllllllllllIIllIlllllIlIIIIIl < llllllllllllllIIllIlllllIlIIllIl + 4; ++llllllllllllllIIllIlllllIlIIIIIl) {
                            int llllllllllllllIIllIlllllIIllllIl = llllllllllllllIIllIlllllIlIIIIIl % 2;
                            int llllllllllllllIIllIlllllIIlllIIl = 1 - llllllllllllllIIllIlllllIIllllIl;
                            if (llllllllllllllIIllIlllllIlIIIIIl % 4 >= 2) {
                                llllllllllllllIIllIlllllIIllllIl = -llllllllllllllIIllIlllllIIllllIl;
                                llllllllllllllIIllIlllllIIlllIIl = -llllllllllllllIIllIlllllIIlllIIl;
                            }
                            for (int llllllllllllllIIllIlllllIIllIlII = 0; llllllllllllllIIllIlllllIIllIlII < 3; ++llllllllllllllIIllIlllllIIllIlII) {
                                for (int llllllllllllllIIllIlllllIIlIllll = 0; llllllllllllllIIllIlllllIIlIllll < 4; ++llllllllllllllIIllIlllllIIlIllll) {
                                    for (int llllllllllllllIIllIlllllIIlIlIlI = -1; llllllllllllllIIllIlllllIIlIlIlI < 4; ++llllllllllllllIIllIlllllIIlIlIlI) {
                                        final int llllllllllllllIIllIlllllIIlIIllI = llllllllllllllIIllIlllllIlIIllII + (llllllllllllllIIllIlllllIIlIllll - 1) * llllllllllllllIIllIlllllIIllllIl + llllllllllllllIIllIlllllIIllIlII * llllllllllllllIIllIlllllIIlllIIl;
                                        final int llllllllllllllIIllIlllllIIlIIlII = llllllllllllllIIllIlllllIlIIIlII + llllllllllllllIIllIlllllIIlIlIlI;
                                        final int llllllllllllllIIllIlllllIIIllllI = llllllllllllllIIllIlllllIlIIlIIl + (llllllllllllllIIllIlllllIIlIllll - 1) * llllllllllllllIIllIlllllIIlllIIl - llllllllllllllIIllIlllllIIllIlII * llllllllllllllIIllIlllllIIllllIl;
                                        if (llllllllllllllIIllIlllllIIlIlIlI < 0 && !this.worldServerInstance.getBlockState(new BlockPos(llllllllllllllIIllIlllllIIlIIllI, llllllllllllllIIllIlllllIIlIIlII, llllllllllllllIIllIlllllIIIllllI)).getBlock().getMaterial().isSolid()) {
                                            continue Label_0452;
                                        }
                                        if (llllllllllllllIIllIlllllIIlIlIlI >= 0 && !this.worldServerInstance.isAirBlock(new BlockPos(llllllllllllllIIllIlllllIIlIIllI, llllllllllllllIIllIlllllIIlIIlII, llllllllllllllIIllIlllllIIIllllI))) {
                                            continue Label_0452;
                                        }
                                    }
                                }
                            }
                            final double llllllllllllllIIllIlllllIIlIIIlI = llllllllllllllIIllIlllllIlIIIlII + 0.5 - llllllllllllllIIllIlllllIlIlIlll.posY;
                            final double llllllllllllllIIllIlllllIIlIIIII = llllllllllllllIIllIlllllIlIIlIll * llllllllllllllIIllIlllllIlIIlIll + llllllllllllllIIllIlllllIIlIIIlI * llllllllllllllIIllIlllllIIlIIIlI + llllllllllllllIIllIlllllIlIIIllI * llllllllllllllIIllIlllllIlIIIllI;
                            if (llllllllllllllIIllIlllllIlIlIlIl < 0.0 || llllllllllllllIIllIlllllIIlIIIII < llllllllllllllIIllIlllllIlIlIlIl) {
                                llllllllllllllIIllIlllllIlIlIlIl = llllllllllllllIIllIlllllIIlIIIII;
                                llllllllllllllIIllIlllllIlIlIIIl = llllllllllllllIIllIlllllIlIIllII;
                                llllllllllllllIIllIlllllIlIlIIII = llllllllllllllIIllIlllllIlIIIlII;
                                llllllllllllllIIllIlllllIlIIllll = llllllllllllllIIllIlllllIlIIlIIl;
                                llllllllllllllIIllIlllllIlIIlllI = llllllllllllllIIllIlllllIlIIIIIl % 4;
                            }
                        }
                    }
                }
            }
        }
        if (llllllllllllllIIllIlllllIlIlIlIl < 0.0) {
            for (int llllllllllllllIIllIlllllIlIIllII = llllllllllllllIIllIlllllIlIlIlII - llllllllllllllIIllIlllllIlIlIllI; llllllllllllllIIllIlllllIlIIllII <= llllllllllllllIIllIlllllIlIlIlII + llllllllllllllIIllIlllllIlIlIllI; ++llllllllllllllIIllIlllllIlIIllII) {
                final double llllllllllllllIIllIlllllIlIIlIlI = llllllllllllllIIllIlllllIlIIllII + 0.5 - llllllllllllllIIllIlllllIlIlIlll.posX;
                for (int llllllllllllllIIllIlllllIlIIlIII = llllllllllllllIIllIlllllIlIlIIlI - llllllllllllllIIllIlllllIlIlIllI; llllllllllllllIIllIlllllIlIIlIII <= llllllllllllllIIllIlllllIlIlIIlI + llllllllllllllIIllIlllllIlIlIllI; ++llllllllllllllIIllIlllllIlIIlIII) {
                    final double llllllllllllllIIllIlllllIlIIIlIl = llllllllllllllIIllIlllllIlIIlIII + 0.5 - llllllllllllllIIllIlllllIlIlIlll.posZ;
                Label_0838:
                    for (int llllllllllllllIIllIlllllIlIIIIll = this.worldServerInstance.getActualHeight() - 1; llllllllllllllIIllIlllllIlIIIIll >= 0; --llllllllllllllIIllIlllllIlIIIIll) {
                        if (this.worldServerInstance.isAirBlock(new BlockPos(llllllllllllllIIllIlllllIlIIllII, llllllllllllllIIllIlllllIlIIIIll, llllllllllllllIIllIlllllIlIIlIII))) {
                            while (llllllllllllllIIllIlllllIlIIIIll > 0 && this.worldServerInstance.isAirBlock(new BlockPos(llllllllllllllIIllIlllllIlIIllII, llllllllllllllIIllIlllllIlIIIIll - 1, llllllllllllllIIllIlllllIlIIlIII))) {
                                --llllllllllllllIIllIlllllIlIIIIll;
                            }
                            for (int llllllllllllllIIllIlllllIlIIIIII = llllllllllllllIIllIlllllIlIIllIl; llllllllllllllIIllIlllllIlIIIIII < llllllllllllllIIllIlllllIlIIllIl + 2; ++llllllllllllllIIllIlllllIlIIIIII) {
                                final int llllllllllllllIIllIlllllIIllllII = llllllllllllllIIllIlllllIlIIIIII % 2;
                                final int llllllllllllllIIllIlllllIIlllIII = 1 - llllllllllllllIIllIlllllIIllllII;
                                for (int llllllllllllllIIllIlllllIIllIIll = 0; llllllllllllllIIllIlllllIIllIIll < 4; ++llllllllllllllIIllIlllllIIllIIll) {
                                    for (int llllllllllllllIIllIlllllIIlIlllI = -1; llllllllllllllIIllIlllllIIlIlllI < 4; ++llllllllllllllIIllIlllllIIlIlllI) {
                                        final int llllllllllllllIIllIlllllIIlIlIIl = llllllllllllllIIllIlllllIlIIllII + (llllllllllllllIIllIlllllIIllIIll - 1) * llllllllllllllIIllIlllllIIllllII;
                                        final int llllllllllllllIIllIlllllIIlIIlIl = llllllllllllllIIllIlllllIlIIIIll + llllllllllllllIIllIlllllIIlIlllI;
                                        final int llllllllllllllIIllIlllllIIlIIIll = llllllllllllllIIllIlllllIlIIlIII + (llllllllllllllIIllIlllllIIllIIll - 1) * llllllllllllllIIllIlllllIIlllIII;
                                        if (llllllllllllllIIllIlllllIIlIlllI < 0 && !this.worldServerInstance.getBlockState(new BlockPos(llllllllllllllIIllIlllllIIlIlIIl, llllllllllllllIIllIlllllIIlIIlIl, llllllllllllllIIllIlllllIIlIIIll)).getBlock().getMaterial().isSolid()) {
                                            continue Label_0838;
                                        }
                                        if (llllllllllllllIIllIlllllIIlIlllI >= 0 && !this.worldServerInstance.isAirBlock(new BlockPos(llllllllllllllIIllIlllllIIlIlIIl, llllllllllllllIIllIlllllIIlIIlIl, llllllllllllllIIllIlllllIIlIIIll))) {
                                            continue Label_0838;
                                        }
                                    }
                                }
                                final double llllllllllllllIIllIlllllIIlIIIIl = llllllllllllllIIllIlllllIlIIIIll + 0.5 - llllllllllllllIIllIlllllIlIlIlll.posY;
                                final double llllllllllllllIIllIlllllIIIlllll = llllllllllllllIIllIlllllIlIIlIlI * llllllllllllllIIllIlllllIlIIlIlI + llllllllllllllIIllIlllllIIlIIIIl * llllllllllllllIIllIlllllIIlIIIIl + llllllllllllllIIllIlllllIlIIIlIl * llllllllllllllIIllIlllllIlIIIlIl;
                                if (llllllllllllllIIllIlllllIlIlIlIl < 0.0 || llllllllllllllIIllIlllllIIIlllll < llllllllllllllIIllIlllllIlIlIlIl) {
                                    llllllllllllllIIllIlllllIlIlIlIl = llllllllllllllIIllIlllllIIIlllll;
                                    llllllllllllllIIllIlllllIlIlIIIl = llllllllllllllIIllIlllllIlIIllII;
                                    llllllllllllllIIllIlllllIlIlIIII = llllllllllllllIIllIlllllIlIIIIll;
                                    llllllllllllllIIllIlllllIlIIllll = llllllllllllllIIllIlllllIlIIlIII;
                                    llllllllllllllIIllIlllllIlIIlllI = llllllllllllllIIllIlllllIlIIIIII % 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        final int llllllllllllllIIllIlllllIIIlllIl = llllllllllllllIIllIlllllIlIlIIIl;
        int llllllllllllllIIllIlllllIIIlllII = llllllllllllllIIllIlllllIlIlIIII;
        final int llllllllllllllIIllIlllllIlIIIlll = llllllllllllllIIllIlllllIlIIllll;
        int llllllllllllllIIllIlllllIIIllIll = llllllllllllllIIllIlllllIlIIlllI % 2;
        int llllllllllllllIIllIlllllIIIllIlI = 1 - llllllllllllllIIllIlllllIIIllIll;
        if (llllllllllllllIIllIlllllIlIIlllI % 4 >= 2) {
            llllllllllllllIIllIlllllIIIllIll = -llllllllllllllIIllIlllllIIIllIll;
            llllllllllllllIIllIlllllIIIllIlI = -llllllllllllllIIllIlllllIIIllIlI;
        }
        if (llllllllllllllIIllIlllllIlIlIlIl < 0.0) {
            llllllllllllllIIllIlllllIlIlIIII = (llllllllllllllIIllIlllllIIIlllII = MathHelper.clamp_int(llllllllllllllIIllIlllllIlIlIIII, 70, this.worldServerInstance.getActualHeight() - 10));
            for (int llllllllllllllIIllIlllllIlIIIIlI = -1; llllllllllllllIIllIlllllIlIIIIlI <= 1; ++llllllllllllllIIllIlllllIlIIIIlI) {
                for (int llllllllllllllIIllIlllllIIllllll = 1; llllllllllllllIIllIlllllIIllllll < 3; ++llllllllllllllIIllIlllllIIllllll) {
                    for (int llllllllllllllIIllIlllllIIlllIll = -1; llllllllllllllIIllIlllllIIlllIll < 3; ++llllllllllllllIIllIlllllIIlllIll) {
                        final int llllllllllllllIIllIlllllIIllIlll = llllllllllllllIIllIlllllIIIlllIl + (llllllllllllllIIllIlllllIIllllll - 1) * llllllllllllllIIllIlllllIIIllIll + llllllllllllllIIllIlllllIlIIIIlI * llllllllllllllIIllIlllllIIIllIlI;
                        final int llllllllllllllIIllIlllllIIllIIlI = llllllllllllllIIllIlllllIIIlllII + llllllllllllllIIllIlllllIIlllIll;
                        final int llllllllllllllIIllIlllllIIlIllIl = llllllllllllllIIllIlllllIlIIIlll + (llllllllllllllIIllIlllllIIllllll - 1) * llllllllllllllIIllIlllllIIIllIlI - llllllllllllllIIllIlllllIlIIIIlI * llllllllllllllIIllIlllllIIIllIll;
                        final boolean llllllllllllllIIllIlllllIIIllIIl = llllllllllllllIIllIlllllIIlllIll < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(llllllllllllllIIllIlllllIIllIlll, llllllllllllllIIllIlllllIIllIIlI, llllllllllllllIIllIlllllIIlIllIl), llllllllllllllIIllIlllllIIIllIIl ? Blocks.obsidian.getDefaultState() : Blocks.air.getDefaultState());
                    }
                }
            }
        }
        final IBlockState llllllllllllllIIllIlllllIIIllIII = Blocks.portal.getDefaultState().withProperty(BlockPortal.field_176550_a, (llllllllllllllIIllIlllllIIIllIll != 0) ? EnumFacing.Axis.X : EnumFacing.Axis.Z);
        for (int llllllllllllllIIllIlllllIIlllllI = 0; llllllllllllllIIllIlllllIIlllllI < 4; ++llllllllllllllIIllIlllllIIlllllI) {
            for (int llllllllllllllIIllIlllllIIlllIlI = 0; llllllllllllllIIllIlllllIIlllIlI < 4; ++llllllllllllllIIllIlllllIIlllIlI) {
                for (int llllllllllllllIIllIlllllIIllIllI = -1; llllllllllllllIIllIlllllIIllIllI < 4; ++llllllllllllllIIllIlllllIIllIllI) {
                    final int llllllllllllllIIllIlllllIIllIIIl = llllllllllllllIIllIlllllIIIlllIl + (llllllllllllllIIllIlllllIIlllIlI - 1) * llllllllllllllIIllIlllllIIIllIll;
                    final int llllllllllllllIIllIlllllIIlIllII = llllllllllllllIIllIlllllIIIlllII + llllllllllllllIIllIlllllIIllIllI;
                    final int llllllllllllllIIllIlllllIIlIlIII = llllllllllllllIIllIlllllIlIIIlll + (llllllllllllllIIllIlllllIIlllIlI - 1) * llllllllllllllIIllIlllllIIIllIlI;
                    final boolean llllllllllllllIIllIlllllIIIlIlll = llllllllllllllIIllIlllllIIlllIlI == 0 || llllllllllllllIIllIlllllIIlllIlI == 3 || llllllllllllllIIllIlllllIIllIllI == -1 || llllllllllllllIIllIlllllIIllIllI == 3;
                    this.worldServerInstance.setBlockState(new BlockPos(llllllllllllllIIllIlllllIIllIIIl, llllllllllllllIIllIlllllIIlIllII, llllllllllllllIIllIlllllIIlIlIII), llllllllllllllIIllIlllllIIIlIlll ? Blocks.obsidian.getDefaultState() : llllllllllllllIIllIlllllIIIllIII, 2);
                }
            }
            for (int llllllllllllllIIllIlllllIIlllIlI = 0; llllllllllllllIIllIlllllIIlllIlI < 4; ++llllllllllllllIIllIlllllIIlllIlI) {
                for (int llllllllllllllIIllIlllllIIllIlIl = -1; llllllllllllllIIllIlllllIIllIlIl < 4; ++llllllllllllllIIllIlllllIIllIlIl) {
                    final int llllllllllllllIIllIlllllIIllIIII = llllllllllllllIIllIlllllIIIlllIl + (llllllllllllllIIllIlllllIIlllIlI - 1) * llllllllllllllIIllIlllllIIIllIll;
                    final int llllllllllllllIIllIlllllIIlIlIll = llllllllllllllIIllIlllllIIIlllII + llllllllllllllIIllIlllllIIllIlIl;
                    final int llllllllllllllIIllIlllllIIlIIlll = llllllllllllllIIllIlllllIlIIIlll + (llllllllllllllIIllIlllllIIlllIlI - 1) * llllllllllllllIIllIlllllIIIllIlI;
                    this.worldServerInstance.notifyNeighborsOfStateChange(new BlockPos(llllllllllllllIIllIlllllIIllIIII, llllllllllllllIIllIlllllIIlIlIll, llllllllllllllIIllIlllllIIlIIlll), this.worldServerInstance.getBlockState(new BlockPos(llllllllllllllIIllIlllllIIllIIII, llllllllllllllIIllIlllllIIlIlIll, llllllllllllllIIllIlllllIIlIIlll)).getBlock());
                }
            }
        }
        return true;
    }
    
    public void func_180266_a(final Entity llllllllllllllIIllIllllllllIllII, final float llllllllllllllIIllIllllllllllIlI) {
        if (this.worldServerInstance.provider.getDimensionId() != 1) {
            if (!this.func_180620_b(llllllllllllllIIllIllllllllIllII, llllllllllllllIIllIllllllllllIlI)) {
                this.makePortal(llllllllllllllIIllIllllllllIllII);
                this.func_180620_b(llllllllllllllIIllIllllllllIllII, llllllllllllllIIllIllllllllllIlI);
            }
        }
        else {
            final int llllllllllllllIIllIllllllllllIIl = MathHelper.floor_double(llllllllllllllIIllIllllllllIllII.posX);
            final int llllllllllllllIIllIllllllllllIII = MathHelper.floor_double(llllllllllllllIIllIllllllllIllII.posY) - 1;
            final int llllllllllllllIIllIlllllllllIlll = MathHelper.floor_double(llllllllllllllIIllIllllllllIllII.posZ);
            final byte llllllllllllllIIllIlllllllllIllI = 1;
            final byte llllllllllllllIIllIlllllllllIlIl = 0;
            for (int llllllllllllllIIllIlllllllllIlII = -2; llllllllllllllIIllIlllllllllIlII <= 2; ++llllllllllllllIIllIlllllllllIlII) {
                for (int llllllllllllllIIllIlllllllllIIll = -2; llllllllllllllIIllIlllllllllIIll <= 2; ++llllllllllllllIIllIlllllllllIIll) {
                    for (int llllllllllllllIIllIlllllllllIIlI = -1; llllllllllllllIIllIlllllllllIIlI < 3; ++llllllllllllllIIllIlllllllllIIlI) {
                        final int llllllllllllllIIllIlllllllllIIIl = llllllllllllllIIllIllllllllllIIl + llllllllllllllIIllIlllllllllIIll * llllllllllllllIIllIlllllllllIllI + llllllllllllllIIllIlllllllllIlII * llllllllllllllIIllIlllllllllIlIl;
                        final int llllllllllllllIIllIlllllllllIIII = llllllllllllllIIllIllllllllllIII + llllllllllllllIIllIlllllllllIIlI;
                        final int llllllllllllllIIllIllllllllIllll = llllllllllllllIIllIlllllllllIlll + llllllllllllllIIllIlllllllllIIll * llllllllllllllIIllIlllllllllIlIl - llllllllllllllIIllIlllllllllIlII * llllllllllllllIIllIlllllllllIllI;
                        final boolean llllllllllllllIIllIllllllllIlllI = llllllllllllllIIllIlllllllllIIlI < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(llllllllllllllIIllIlllllllllIIIl, llllllllllllllIIllIlllllllllIIII, llllllllllllllIIllIllllllllIllll), llllllllllllllIIllIllllllllIlllI ? Blocks.obsidian.getDefaultState() : Blocks.air.getDefaultState());
                    }
                }
            }
            llllllllllllllIIllIllllllllIllII.setLocationAndAngles(llllllllllllllIIllIllllllllllIIl, llllllllllllllIIllIllllllllllIII, llllllllllllllIIllIlllllllllIlll, llllllllllllllIIllIllllllllIllII.rotationYaw, 0.0f);
            final double motionX = 0.0;
            llllllllllllllIIllIllllllllIllII.motionZ = motionX;
            llllllllllllllIIllIllllllllIllII.motionY = motionX;
            llllllllllllllIIllIllllllllIllII.motionX = motionX;
        }
    }
    
    public Teleporter(final WorldServer llllllllllllllIIlllIIIIIIIIIllII) {
        this.destinationCoordinateCache = new LongHashMap();
        this.destinationCoordinateKeys = Lists.newArrayList();
        this.worldServerInstance = llllllllllllllIIlllIIIIIIIIIllII;
        this.random = new Random(llllllllllllllIIlllIIIIIIIIIllII.getSeed());
    }
    
    static {
        __OBFID = "CL_00000153";
    }
    
    public class PortalPosition extends BlockPos
    {
        public /* synthetic */ long lastUpdateTime;
        
        public PortalPosition(final BlockPos llllllllllllllIlllIIIllIllllIlII, final long llllllllllllllIlllIIIllIllllIlll) {
            super(llllllllllllllIlllIIIllIllllIlII.getX(), llllllllllllllIlllIIIllIllllIlII.getY(), llllllllllllllIlllIIIllIllllIlII.getZ());
            this.lastUpdateTime = llllllllllllllIlllIIIllIllllIlll;
        }
        
        static {
            __OBFID = "CL_00000154";
        }
    }
}
