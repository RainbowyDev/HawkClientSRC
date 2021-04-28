package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;

public class WorldGenSpikes extends WorldGenerator
{
    private /* synthetic */ Block field_150520_a;
    
    public WorldGenSpikes(final Block llllllllllllllllIIIlIIIIllIlIlII) {
        this.field_150520_a = llllllllllllllllIIIlIIIIllIlIlII;
    }
    
    @Override
    public boolean generate(final World llllllllllllllllIIIlIIIIllIIIlIl, final Random llllllllllllllllIIIlIIIIllIIIlII, final BlockPos llllllllllllllllIIIlIIIIllIIIIll) {
        if (llllllllllllllllIIIlIIIIllIIIlIl.isAirBlock(llllllllllllllllIIIlIIIIllIIIIll) && llllllllllllllllIIIlIIIIllIIIlIl.getBlockState(llllllllllllllllIIIlIIIIllIIIIll.offsetDown()).getBlock() == this.field_150520_a) {
            final int llllllllllllllllIIIlIIIIllIIIIlI = llllllllllllllllIIIlIIIIllIIIlII.nextInt(32) + 6;
            final int llllllllllllllllIIIlIIIIllIIIIIl = llllllllllllllllIIIlIIIIllIIIlII.nextInt(4) + 1;
            for (int llllllllllllllllIIIlIIIIllIIIIII = llllllllllllllllIIIlIIIIllIIIIll.getX() - llllllllllllllllIIIlIIIIllIIIIIl; llllllllllllllllIIIlIIIIllIIIIII <= llllllllllllllllIIIlIIIIllIIIIll.getX() + llllllllllllllllIIIlIIIIllIIIIIl; ++llllllllllllllllIIIlIIIIllIIIIII) {
                for (int llllllllllllllllIIIlIIIIlIllllll = llllllllllllllllIIIlIIIIllIIIIll.getZ() - llllllllllllllllIIIlIIIIllIIIIIl; llllllllllllllllIIIlIIIIlIllllll <= llllllllllllllllIIIlIIIIllIIIIll.getZ() + llllllllllllllllIIIlIIIIllIIIIIl; ++llllllllllllllllIIIlIIIIlIllllll) {
                    final int llllllllllllllllIIIlIIIIlIllllIl = llllllllllllllllIIIlIIIIllIIIIII - llllllllllllllllIIIlIIIIllIIIIll.getX();
                    final int llllllllllllllllIIIlIIIIlIlllIll = llllllllllllllllIIIlIIIIlIllllll - llllllllllllllllIIIlIIIIllIIIIll.getZ();
                    if (llllllllllllllllIIIlIIIIlIllllIl * llllllllllllllllIIIlIIIIlIllllIl + llllllllllllllllIIIlIIIIlIlllIll * llllllllllllllllIIIlIIIIlIlllIll <= llllllllllllllllIIIlIIIIllIIIIIl * llllllllllllllllIIIlIIIIllIIIIIl + 1 && llllllllllllllllIIIlIIIIllIIIlIl.getBlockState(new BlockPos(llllllllllllllllIIIlIIIIllIIIIII, llllllllllllllllIIIlIIIIllIIIIll.getY() - 1, llllllllllllllllIIIlIIIIlIllllll)).getBlock() != this.field_150520_a) {
                        return false;
                    }
                }
            }
            for (int llllllllllllllllIIIlIIIIllIIIIII = llllllllllllllllIIIlIIIIllIIIIll.getY(); llllllllllllllllIIIlIIIIllIIIIII < llllllllllllllllIIIlIIIIllIIIIll.getY() + llllllllllllllllIIIlIIIIllIIIIlI && llllllllllllllllIIIlIIIIllIIIIII < 256; ++llllllllllllllllIIIlIIIIllIIIIII) {
                for (int llllllllllllllllIIIlIIIIlIlllllI = llllllllllllllllIIIlIIIIllIIIIll.getX() - llllllllllllllllIIIlIIIIllIIIIIl; llllllllllllllllIIIlIIIIlIlllllI <= llllllllllllllllIIIlIIIIllIIIIll.getX() + llllllllllllllllIIIlIIIIllIIIIIl; ++llllllllllllllllIIIlIIIIlIlllllI) {
                    for (int llllllllllllllllIIIlIIIIlIllllII = llllllllllllllllIIIlIIIIllIIIIll.getZ() - llllllllllllllllIIIlIIIIllIIIIIl; llllllllllllllllIIIlIIIIlIllllII <= llllllllllllllllIIIlIIIIllIIIIll.getZ() + llllllllllllllllIIIlIIIIllIIIIIl; ++llllllllllllllllIIIlIIIIlIllllII) {
                        final int llllllllllllllllIIIlIIIIlIlllIlI = llllllllllllllllIIIlIIIIlIlllllI - llllllllllllllllIIIlIIIIllIIIIll.getX();
                        final int llllllllllllllllIIIlIIIIlIlllIIl = llllllllllllllllIIIlIIIIlIllllII - llllllllllllllllIIIlIIIIllIIIIll.getZ();
                        if (llllllllllllllllIIIlIIIIlIlllIlI * llllllllllllllllIIIlIIIIlIlllIlI + llllllllllllllllIIIlIIIIlIlllIIl * llllllllllllllllIIIlIIIIlIlllIIl <= llllllllllllllllIIIlIIIIllIIIIIl * llllllllllllllllIIIlIIIIllIIIIIl + 1) {
                            llllllllllllllllIIIlIIIIllIIIlIl.setBlockState(new BlockPos(llllllllllllllllIIIlIIIIlIlllllI, llllllllllllllllIIIlIIIIllIIIIII, llllllllllllllllIIIlIIIIlIllllII), Blocks.obsidian.getDefaultState(), 2);
                        }
                    }
                }
            }
            final EntityEnderCrystal llllllllllllllllIIIlIIIIlIlllIII = new EntityEnderCrystal(llllllllllllllllIIIlIIIIllIIIlIl);
            llllllllllllllllIIIlIIIIlIlllIII.setLocationAndAngles(llllllllllllllllIIIlIIIIllIIIIll.getX() + 0.5f, llllllllllllllllIIIlIIIIllIIIIll.getY() + llllllllllllllllIIIlIIIIllIIIIlI, llllllllllllllllIIIlIIIIllIIIIll.getZ() + 0.5f, llllllllllllllllIIIlIIIIllIIIlII.nextFloat() * 360.0f, 0.0f);
            llllllllllllllllIIIlIIIIllIIIlIl.spawnEntityInWorld(llllllllllllllllIIIlIIIIlIlllIII);
            llllllllllllllllIIIlIIIIllIIIlIl.setBlockState(llllllllllllllllIIIlIIIIllIIIIll.offsetUp(llllllllllllllllIIIlIIIIllIIIIlI), Blocks.bedrock.getDefaultState(), 2);
            return true;
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00000433";
    }
}
