package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.state.*;

public class ClearWater
{
    public static void updateWaterOpacity(final GameSettings llllllllllllllIlIIllIllllllIlIlI, final World llllllllllllllIlIIllIlllllIIlllI) {
        if (llllllllllllllIlIIllIllllllIlIlI != null) {
            byte llllllllllllllIlIIllIllllllIlIII = 3;
            if (llllllllllllllIlIIllIllllllIlIlI.ofClearWater) {
                llllllllllllllIlIIllIllllllIlIII = 1;
            }
            BlockLeavesBase.setLightOpacity(Blocks.water, llllllllllllllIlIIllIllllllIlIII);
            BlockLeavesBase.setLightOpacity(Blocks.flowing_water, llllllllllllllIlIIllIllllllIlIII);
        }
        if (llllllllllllllIlIIllIlllllIIlllI != null) {
            final IChunkProvider llllllllllllllIlIIllIllllllIIlll = llllllllllllllIlIIllIlllllIIlllI.getChunkProvider();
            if (llllllllllllllIlIIllIllllllIIlll != null) {
                final Entity llllllllllllllIlIIllIllllllIIllI = Config.getMinecraft().func_175606_aa();
                if (llllllllllllllIlIIllIllllllIIllI != null) {
                    final int llllllllllllllIlIIllIllllllIIlIl = (int)llllllllllllllIlIIllIllllllIIllI.posX / 16;
                    final int llllllllllllllIlIIllIllllllIIlII = (int)llllllllllllllIlIIllIllllllIIllI.posZ / 16;
                    final int llllllllllllllIlIIllIllllllIIIll = llllllllllllllIlIIllIllllllIIlIl - 512;
                    final int llllllllllllllIlIIllIllllllIIIlI = llllllllllllllIlIIllIllllllIIlIl + 512;
                    final int llllllllllllllIlIIllIllllllIIIIl = llllllllllllllIlIIllIllllllIIlII - 512;
                    final int llllllllllllllIlIIllIllllllIIIII = llllllllllllllIlIIllIllllllIIlII + 512;
                    int llllllllllllllIlIIllIlllllIlllll = 0;
                    for (int llllllllllllllIlIIllIlllllIllllI = llllllllllllllIlIIllIllllllIIIll; llllllllllllllIlIIllIlllllIllllI < llllllllllllllIlIIllIllllllIIIlI; ++llllllllllllllIlIIllIlllllIllllI) {
                        for (int llllllllllllllIlIIllIlllllIlllIl = llllllllllllllIlIIllIllllllIIIIl; llllllllllllllIlIIllIlllllIlllIl < llllllllllllllIlIIllIllllllIIIII; ++llllllllllllllIlIIllIlllllIlllIl) {
                            if (llllllllllllllIlIIllIllllllIIlll.chunkExists(llllllllllllllIlIIllIlllllIllllI, llllllllllllllIlIIllIlllllIlllIl)) {
                                final Chunk llllllllllllllIlIIllIlllllIlllII = llllllllllllllIlIIllIllllllIIlll.provideChunk(llllllllllllllIlIIllIlllllIllllI, llllllllllllllIlIIllIlllllIlllIl);
                                if (llllllllllllllIlIIllIlllllIlllII != null && !(llllllllllllllIlIIllIlllllIlllII instanceof EmptyChunk)) {
                                    final int llllllllllllllIlIIllIlllllIllIll = llllllllllllllIlIIllIlllllIllllI << 4;
                                    final int llllllllllllllIlIIllIlllllIllIlI = llllllllllllllIlIIllIlllllIlllIl << 4;
                                    final int llllllllllllllIlIIllIlllllIllIIl = llllllllllllllIlIIllIlllllIllIll + 16;
                                    final int llllllllllllllIlIIllIlllllIllIII = llllllllllllllIlIIllIlllllIllIlI + 16;
                                    final BlockPosM llllllllllllllIlIIllIlllllIlIlll = new BlockPosM(0, 0, 0);
                                    final BlockPosM llllllllllllllIlIIllIlllllIlIllI = new BlockPosM(0, 0, 0);
                                    for (int llllllllllllllIlIIllIlllllIlIlIl = llllllllllllllIlIIllIlllllIllIll; llllllllllllllIlIIllIlllllIlIlIl < llllllllllllllIlIIllIlllllIllIIl; ++llllllllllllllIlIIllIlllllIlIlIl) {
                                        for (int llllllllllllllIlIIllIlllllIlIlII = llllllllllllllIlIIllIlllllIllIlI; llllllllllllllIlIIllIlllllIlIlII < llllllllllllllIlIIllIlllllIllIII; ++llllllllllllllIlIIllIlllllIlIlII) {
                                            llllllllllllllIlIIllIlllllIlIlll.setXyz(llllllllllllllIlIIllIlllllIlIlIl, 0, llllllllllllllIlIIllIlllllIlIlII);
                                            final BlockPos llllllllllllllIlIIllIlllllIlIIll = llllllllllllllIlIIllIlllllIIlllI.func_175725_q(llllllllllllllIlIIllIlllllIlIlll);
                                            for (int llllllllllllllIlIIllIlllllIlIIlI = 0; llllllllllllllIlIIllIlllllIlIIlI < llllllllllllllIlIIllIlllllIlIIll.getY(); ++llllllllllllllIlIIllIlllllIlIIlI) {
                                                llllllllllllllIlIIllIlllllIlIllI.setXyz(llllllllllllllIlIIllIlllllIlIlIl, llllllllllllllIlIIllIlllllIlIIlI, llllllllllllllIlIIllIlllllIlIlII);
                                                final IBlockState llllllllllllllIlIIllIlllllIlIIIl = llllllllllllllIlIIllIlllllIIlllI.getBlockState(llllllllllllllIlIIllIlllllIlIllI);
                                                if (llllllllllllllIlIIllIlllllIlIIIl.getBlock().getMaterial() == Material.water) {
                                                    llllllllllllllIlIIllIlllllIIlllI.markBlocksDirtyVertical(llllllllllllllIlIIllIlllllIlIlIl, llllllllllllllIlIIllIlllllIlIlII, llllllllllllllIlIIllIlllllIlIllI.getY(), llllllllllllllIlIIllIlllllIlIIll.getY());
                                                    ++llllllllllllllIlIIllIlllllIlllll;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (llllllllllllllIlIIllIlllllIlllll > 0) {
                        String llllllllllllllIlIIllIlllllIlIIII = "server";
                        if (Config.isMinecraftThread()) {
                            llllllllllllllIlIIllIlllllIlIIII = "client";
                        }
                        Config.dbg(String.valueOf(new StringBuilder("ClearWater (").append(llllllllllllllIlIIllIlllllIlIIII).append(") relighted ").append(llllllllllllllIlIIllIlllllIlllll).append(" chunks")));
                    }
                }
            }
        }
    }
}
