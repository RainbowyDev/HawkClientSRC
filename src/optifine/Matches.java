package optifine;

import net.minecraft.block.state.*;
import net.minecraft.world.biome.*;
import net.minecraft.client.renderer.texture.*;

public class Matches
{
    public static boolean block(final int llllllllllllllIllIlIllllIIIlIllI, final int llllllllllllllIllIlIllllIIIlIlIl, final MatchBlock[] llllllllllllllIllIlIllllIIIlIlII) {
        if (llllllllllllllIllIlIllllIIIlIlII == null) {
            return true;
        }
        for (int llllllllllllllIllIlIllllIIIlIIll = 0; llllllllllllllIllIlIllllIIIlIIll < llllllllllllllIllIlIllllIIIlIlII.length; ++llllllllllllllIllIlIllllIIIlIIll) {
            final MatchBlock llllllllllllllIllIlIllllIIIlIIlI = llllllllllllllIllIlIllllIIIlIlII[llllllllllllllIllIlIllllIIIlIIll];
            if (llllllllllllllIllIlIllllIIIlIIlI.matches(llllllllllllllIllIlIllllIIIlIllI, llllllllllllllIllIlIllllIIIlIlIl)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean block(final BlockStateBase llllllllllllllIllIlIllllIIlIlIlI, final MatchBlock[] llllllllllllllIllIlIllllIIlIIIll) {
        if (llllllllllllllIllIlIllllIIlIIIll == null) {
            return true;
        }
        for (int llllllllllllllIllIlIllllIIlIIlll = 0; llllllllllllllIllIlIllllIIlIIlll < llllllllllllllIllIlIllllIIlIIIll.length; ++llllllllllllllIllIlIllllIIlIIlll) {
            final MatchBlock llllllllllllllIllIlIllllIIlIIllI = llllllllllllllIllIlIllllIIlIIIll[llllllllllllllIllIlIllllIIlIIlll];
            if (llllllllllllllIllIlIllllIIlIIllI.matches(llllllllllllllIllIlIllllIIlIlIlI)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean biome(final BiomeGenBase llllllllllllllIllIlIlllIlllIlIII, final BiomeGenBase[] llllllllllllllIllIlIlllIlllIlIlI) {
        if (llllllllllllllIllIlIlllIlllIlIlI == null) {
            return true;
        }
        for (int llllllllllllllIllIlIlllIlllIlIIl = 0; llllllllllllllIllIlIlllIlllIlIIl < llllllllllllllIllIlIlllIlllIlIlI.length; ++llllllllllllllIllIlIlllIlllIlIIl) {
            if (llllllllllllllIllIlIlllIlllIlIlI[llllllllllllllIllIlIlllIlllIlIIl] == llllllllllllllIllIlIlllIlllIlIII) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean blockId(final int llllllllllllllIllIlIllllIIIIlIII, final MatchBlock[] llllllllllllllIllIlIllllIIIIIlll) {
        if (llllllllllllllIllIlIllllIIIIIlll == null) {
            return true;
        }
        for (int llllllllllllllIllIlIllllIIIIIllI = 0; llllllllllllllIllIlIllllIIIIIllI < llllllllllllllIllIlIllllIIIIIlll.length; ++llllllllllllllIllIlIllllIIIIIllI) {
            final MatchBlock llllllllllllllIllIlIllllIIIIIlIl = llllllllllllllIllIlIllllIIIIIlll[llllllllllllllIllIlIllllIIIIIllI];
            if (llllllllllllllIllIlIllllIIIIIlIl.getBlockId() == llllllllllllllIllIlIllllIIIIlIII) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean metadata(final int llllllllllllllIllIlIlllIlllllIlI, final int[] llllllllllllllIllIlIlllIlllllIIl) {
        if (llllllllllllllIllIlIlllIlllllIIl == null) {
            return true;
        }
        for (int llllllllllllllIllIlIlllIlllllIll = 0; llllllllllllllIllIlIlllIlllllIll < llllllllllllllIllIlIlllIlllllIIl.length; ++llllllllllllllIllIlIlllIlllllIll) {
            if (llllllllllllllIllIlIlllIlllllIIl[llllllllllllllIllIlIlllIlllllIll] == llllllllllllllIllIlIlllIlllllIlI) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean sprite(final TextureAtlasSprite llllllllllllllIllIlIlllIllllIIIl, final TextureAtlasSprite[] llllllllllllllIllIlIlllIllllIIII) {
        if (llllllllllllllIllIlIlllIllllIIII == null) {
            return true;
        }
        for (int llllllllllllllIllIlIlllIllllIIlI = 0; llllllllllllllIllIlIlllIllllIIlI < llllllllllllllIllIlIlllIllllIIII.length; ++llllllllllllllIllIlIlllIllllIIlI) {
            if (llllllllllllllIllIlIlllIllllIIII[llllllllllllllIllIlIlllIllllIIlI] == llllllllllllllIllIlIlllIllllIIIl) {
                return true;
            }
        }
        return false;
    }
}
