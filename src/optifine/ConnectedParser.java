package optifine;

import net.minecraft.util.*;
import net.minecraft.world.biome.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import java.util.*;

public class ConnectedParser
{
    private static final /* synthetic */ MatchBlock[] NO_MATCH_BLOCKS;
    private /* synthetic */ String context;
    
    public MatchBlock[] parseMatchBlocks(final String llllllllllllllIIlllIIIllIIlIlIlI) {
        if (llllllllllllllIIlllIIIllIIlIlIlI == null) {
            return null;
        }
        final ArrayList llllllllllllllIIlllIIIllIIlIlIIl = new ArrayList();
        final String[] llllllllllllllIIlllIIIllIIlIlIII = Config.tokenize(llllllllllllllIIlllIIIllIIlIlIlI, " ");
        for (int llllllllllllllIIlllIIIllIIlIIlll = 0; llllllllllllllIIlllIIIllIIlIIlll < llllllllllllllIIlllIIIllIIlIlIII.length; ++llllllllllllllIIlllIIIllIIlIIlll) {
            final String llllllllllllllIIlllIIIllIIlIIllI = llllllllllllllIIlllIIIllIIlIlIII[llllllllllllllIIlllIIIllIIlIIlll];
            final MatchBlock[] llllllllllllllIIlllIIIllIIlIIlIl = this.parseMatchBlock(llllllllllllllIIlllIIIllIIlIIllI);
            if (llllllllllllllIIlllIIIllIIlIIlIl == null) {
                return ConnectedParser.NO_MATCH_BLOCKS;
            }
            llllllllllllllIIlllIIIllIIlIlIIl.addAll(Arrays.asList(llllllllllllllIIlllIIIllIIlIIlIl));
        }
        final MatchBlock[] llllllllllllllIIlllIIIllIIlIIlII = llllllllllllllIIlllIIIllIIlIlIIl.toArray(new MatchBlock[llllllllllllllIIlllIIIllIIlIlIIl.size()]);
        return llllllllllllllIIlllIIIllIIlIIlII;
    }
    
    public String parseName(final String llllllllllllllIIlllIIIllIIllllIl) {
        String llllllllllllllIIlllIIIllIlIIIIII = llllllllllllllIIlllIIIllIIllllIl;
        final int llllllllllllllIIlllIIIllIIllllll = llllllllllllllIIlllIIIllIIllllIl.lastIndexOf(47);
        if (llllllllllllllIIlllIIIllIIllllll >= 0) {
            llllllllllllllIIlllIIIllIlIIIIII = llllllllllllllIIlllIIIllIIllllIl.substring(llllllllllllllIIlllIIIllIIllllll + 1);
        }
        final int llllllllllllllIIlllIIIllIIlllllI = llllllllllllllIIlllIIIllIlIIIIII.lastIndexOf(46);
        if (llllllllllllllIIlllIIIllIIlllllI >= 0) {
            llllllllllllllIIlllIIIllIlIIIIII = llllllllllllllIIlllIIIllIlIIIIII.substring(0, llllllllllllllIIlllIIIllIIlllllI);
        }
        return llllllllllllllIIlllIIIllIlIIIIII;
    }
    
    public EnumFacing parseFace(String llllllllllllllIIlllIIIIlllIIlIII) {
        llllllllllllllIIlllIIIIlllIIlIII = (boolean)((String)llllllllllllllIIlllIIIIlllIIlIII).toLowerCase();
        if (((String)llllllllllllllIIlllIIIIlllIIlIII).equals("bottom") || ((String)llllllllllllllIIlllIIIIlllIIlIII).equals("down")) {
            return EnumFacing.DOWN;
        }
        if (((String)llllllllllllllIIlllIIIIlllIIlIII).equals("top") || ((String)llllllllllllllIIlllIIIIlllIIlIII).equals("up")) {
            return EnumFacing.UP;
        }
        if (((String)llllllllllllllIIlllIIIIlllIIlIII).equals("north")) {
            return EnumFacing.NORTH;
        }
        if (((String)llllllllllllllIIlllIIIIlllIIlIII).equals("south")) {
            return EnumFacing.SOUTH;
        }
        if (((String)llllllllllllllIIlllIIIIlllIIlIII).equals("east")) {
            return EnumFacing.EAST;
        }
        if (((String)llllllllllllllIIlllIIIIlllIIlIII).equals("west")) {
            return EnumFacing.WEST;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown face: ").append((String)llllllllllllllIIlllIIIIlllIIlIII)));
        return null;
    }
    
    public boolean isFullBlockName(final String[] llllllllllllllIIlllIIIlIlllIlIlI) {
        if (llllllllllllllIIlllIIIlIlllIlIlI.length < 2) {
            return false;
        }
        final String llllllllllllllIIlllIIIlIlllIlIIl = llllllllllllllIIlllIIIlIlllIlIlI[1];
        return llllllllllllllIIlllIIIlIlllIlIIl.length() >= 1 && !this.startsWithDigit(llllllllllllllIIlllIIIlIlllIlIIl) && !llllllllllllllIIlllIIIlIlllIlIIl.contains("=");
    }
    
    public BiomeGenBase findBiome(String llllllllllllllIIlllIIIlIIIlIIIII) {
        llllllllllllllIIlllIIIlIIIlIIIII = llllllllllllllIIlllIIIlIIIlIIIII.toLowerCase();
        if (llllllllllllllIIlllIIIlIIIlIIIII.equals("nether")) {
            return BiomeGenBase.hell;
        }
        final BiomeGenBase[] llllllllllllllIIlllIIIlIIIlIIlII = BiomeGenBase.getBiomeGenArray();
        for (int llllllllllllllIIlllIIIlIIIlIIIll = 0; llllllllllllllIIlllIIIlIIIlIIIll < llllllllllllllIIlllIIIlIIIlIIlII.length; ++llllllllllllllIIlllIIIlIIIlIIIll) {
            final BiomeGenBase llllllllllllllIIlllIIIlIIIlIIIlI = llllllllllllllIIlllIIIlIIIlIIlII[llllllllllllllIIlllIIIlIIIlIIIll];
            if (llllllllllllllIIlllIIIlIIIlIIIlI != null) {
                final String llllllllllllllIIlllIIIlIIIlIIIIl = llllllllllllllIIlllIIIlIIIlIIIlI.biomeName.replace(" ", "").toLowerCase();
                if (llllllllllllllIIlllIIIlIIIlIIIIl.equals(llllllllllllllIIlllIIIlIIIlIIIII)) {
                    return llllllllllllllIIlllIIIlIIIlIIIlI;
                }
            }
        }
        return null;
    }
    
    private RangeInt parseRangeInt(final String llllllllllllllIIlllIIIIllIIllIlI) {
        if (llllllllllllllIIlllIIIIllIIllIlI == null) {
            return null;
        }
        if (llllllllllllllIIlllIIIIllIIllIlI.indexOf(45) >= 0) {
            final String[] llllllllllllllIIlllIIIIllIIlllll = Config.tokenize(llllllllllllllIIlllIIIIllIIllIlI, "-");
            if (llllllllllllllIIlllIIIIllIIlllll.length != 2) {
                this.warn(String.valueOf(new StringBuilder("Invalid range: ").append(llllllllllllllIIlllIIIIllIIllIlI)));
                return null;
            }
            final int llllllllllllllIIlllIIIIllIIllllI = Config.parseInt(llllllllllllllIIlllIIIIllIIlllll[0], -1);
            final int llllllllllllllIIlllIIIIllIIlllIl = Config.parseInt(llllllllllllllIIlllIIIIllIIlllll[1], -1);
            if (llllllllllllllIIlllIIIIllIIllllI >= 0 && llllllllllllllIIlllIIIIllIIlllIl >= 0) {
                return new RangeInt(llllllllllllllIIlllIIIIllIIllllI, llllllllllllllIIlllIIIIllIIlllIl);
            }
            this.warn(String.valueOf(new StringBuilder("Invalid range: ").append(llllllllllllllIIlllIIIIllIIllIlI)));
            return null;
        }
        else {
            final int llllllllllllllIIlllIIIIllIIlllII = Config.parseInt(llllllllllllllIIlllIIIIllIIllIlI, -1);
            if (llllllllllllllIIlllIIIIllIIlllII < 0) {
                this.warn(String.valueOf(new StringBuilder("Invalid integer: ").append(llllllllllllllIIlllIIIIllIIllIlI)));
                return null;
            }
            return new RangeInt(llllllllllllllIIlllIIIIllIIlllII, llllllllllllllIIlllIIIIllIIlllII);
        }
    }
    
    public int[] parseBlockMetadatas(final Block llllllllllllllIIlllIIIlIlIIlIlll, final String[] llllllllllllllIIlllIIIlIlIIlIllI) {
        if (llllllllllllllIIlllIIIlIlIIlIllI.length <= 0) {
            return null;
        }
        final String llllllllllllllIIlllIIIlIlIlIlllI = llllllllllllllIIlllIIIlIlIIlIllI[0];
        if (this.startsWithDigit(llllllllllllllIIlllIIIlIlIlIlllI)) {
            final int[] llllllllllllllIIlllIIIlIlIlIllIl = this.parseIntList(llllllllllllllIIlllIIIlIlIlIlllI);
            return llllllllllllllIIlllIIIlIlIlIllIl;
        }
        final IBlockState llllllllllllllIIlllIIIlIlIlIllII = llllllllllllllIIlllIIIlIlIIlIlll.getDefaultState();
        final Collection llllllllllllllIIlllIIIlIlIlIlIll = llllllllllllllIIlllIIIlIlIlIllII.getPropertyNames();
        final HashMap llllllllllllllIIlllIIIlIlIlIlIlI = new HashMap();
        for (int llllllllllllllIIlllIIIlIlIlIlIIl = 0; llllllllllllllIIlllIIIlIlIlIlIIl < llllllllllllllIIlllIIIlIlIIlIllI.length; ++llllllllllllllIIlllIIIlIlIlIlIIl) {
            final String llllllllllllllIIlllIIIlIlIlIlIII = llllllllllllllIIlllIIIlIlIIlIllI[llllllllllllllIIlllIIIlIlIlIlIIl];
            if (llllllllllllllIIlllIIIlIlIlIlIII.length() > 0) {
                final String[] llllllllllllllIIlllIIIlIlIlIIlll = Config.tokenize(llllllllllllllIIlllIIIlIlIlIlIII, "=");
                if (llllllllllllllIIlllIIIlIlIlIIlll.length != 2) {
                    this.warn(String.valueOf(new StringBuilder("Invalid block property: ").append(llllllllllllllIIlllIIIlIlIlIlIII)));
                    return null;
                }
                final String llllllllllllllIIlllIIIlIlIlIIllI = llllllllllllllIIlllIIIlIlIlIIlll[0];
                final String llllllllllllllIIlllIIIlIlIlIIlIl = llllllllllllllIIlllIIIlIlIlIIlll[1];
                final IProperty llllllllllllllIIlllIIIlIlIlIIlII = ConnectedProperties.getProperty(llllllllllllllIIlllIIIlIlIlIIllI, llllllllllllllIIlllIIIlIlIlIlIll);
                if (llllllllllllllIIlllIIIlIlIlIIlII == null) {
                    this.warn(String.valueOf(new StringBuilder("Property not found: ").append(llllllllllllllIIlllIIIlIlIlIIllI).append(", block: ").append(llllllllllllllIIlllIIIlIlIIlIlll)));
                    return null;
                }
                Object llllllllllllllIIlllIIIlIlIlIIIll = llllllllllllllIIlllIIIlIlIlIlIlI.get(llllllllllllllIIlllIIIlIlIlIIllI);
                if (llllllllllllllIIlllIIIlIlIlIIIll == null) {
                    llllllllllllllIIlllIIIlIlIlIIIll = new ArrayList();
                    llllllllllllllIIlllIIIlIlIlIlIlI.put(llllllllllllllIIlllIIIlIlIlIIlII, llllllllllllllIIlllIIIlIlIlIIIll);
                }
                final String[] llllllllllllllIIlllIIIlIlIlIIIlI = Config.tokenize(llllllllllllllIIlllIIIlIlIlIIlIl, ",");
                for (int llllllllllllllIIlllIIIlIlIlIIIIl = 0; llllllllllllllIIlllIIIlIlIlIIIIl < llllllllllllllIIlllIIIlIlIlIIIlI.length; ++llllllllllllllIIlllIIIlIlIlIIIIl) {
                    final String llllllllllllllIIlllIIIlIlIlIIIII = llllllllllllllIIlllIIIlIlIlIIIlI[llllllllllllllIIlllIIIlIlIlIIIIl];
                    final Comparable llllllllllllllIIlllIIIlIlIIlllll = parsePropertyValue(llllllllllllllIIlllIIIlIlIlIIlII, llllllllllllllIIlllIIIlIlIlIIIII);
                    if (llllllllllllllIIlllIIIlIlIIlllll == null) {
                        this.warn(String.valueOf(new StringBuilder("Property value not found: ").append(llllllllllllllIIlllIIIlIlIlIIIII).append(", property: ").append(llllllllllllllIIlllIIIlIlIlIIllI).append(", block: ").append(llllllllllllllIIlllIIIlIlIIlIlll)));
                        return null;
                    }
                    ((List)llllllllllllllIIlllIIIlIlIlIIIll).add(llllllllllllllIIlllIIIlIlIIlllll);
                }
            }
        }
        if (llllllllllllllIIlllIIIlIlIlIlIlI.isEmpty()) {
            return null;
        }
        final ArrayList llllllllllllllIIlllIIIlIlIIllllI = new ArrayList();
        for (int llllllllllllllIIlllIIIlIlIIllIll = 0; llllllllllllllIIlllIIIlIlIIllIll < 16; ++llllllllllllllIIlllIIIlIlIIllIll) {
            final int llllllllllllllIIlllIIIlIlIIlllIl = llllllllllllllIIlllIIIlIlIIllIll;
            try {
                final IBlockState llllllllllllllIIlllIIIlIlIIllIlI = this.getStateFromMeta(llllllllllllllIIlllIIIlIlIIlIlll, llllllllllllllIIlllIIIlIlIIlllIl);
                if (this.matchState(llllllllllllllIIlllIIIlIlIIllIlI, llllllllllllllIIlllIIIlIlIlIlIlI)) {
                    llllllllllllllIIlllIIIlIlIIllllI.add(llllllllllllllIIlllIIIlIlIIlllIl);
                }
            }
            catch (IllegalArgumentException ex) {}
        }
        if (llllllllllllllIIlllIIIlIlIIllllI.size() == 16) {
            return null;
        }
        final int[] llllllllllllllIIlllIIIlIlIIllIIl = new int[llllllllllllllIIlllIIIlIlIIllllI.size()];
        for (int llllllllllllllIIlllIIIlIlIIlllII = 0; llllllllllllllIIlllIIIlIlIIlllII < llllllllllllllIIlllIIIlIlIIllIIl.length; ++llllllllllllllIIlllIIIlIlIIlllII) {
            llllllllllllllIIlllIIIlIlIIllIIl[llllllllllllllIIlllIIIlIlIIlllII] = llllllllllllllIIlllIIIlIlIIllllI.get(llllllllllllllIIlllIIIlIlIIlllII);
        }
        return llllllllllllllIIlllIIIlIlIIllIIl;
    }
    
    public int parseInt(final String llllllllllllllIIlllIIIlIIIIlIlII) {
        if (llllllllllllllIIlllIIIlIIIIlIlII == null) {
            return -1;
        }
        final int llllllllllllllIIlllIIIlIIIIlIllI = Config.parseInt(llllllllllllllIIlllIIIlIIIIlIlII, -1);
        if (llllllllllllllIIlllIIIlIIIIlIllI < 0) {
            this.warn(String.valueOf(new StringBuilder("Invalid number: ").append(llllllllllllllIIlllIIIlIIIIlIlII)));
        }
        return llllllllllllllIIlllIIIlIIIIlIllI;
    }
    
    public Block[] parseBlockPart(final String llllllllllllllIIlllIIIlIllIIlIlI, final String llllllllllllllIIlllIIIlIllIIlIIl) {
        if (this.startsWithDigit(llllllllllllllIIlllIIIlIllIIlIIl)) {
            final int[] llllllllllllllIIlllIIIlIllIlIIll = this.parseIntList(llllllllllllllIIlllIIIlIllIIlIIl);
            if (llllllllllllllIIlllIIIlIllIlIIll == null) {
                return null;
            }
            final Block[] llllllllllllllIIlllIIIlIllIlIIlI = new Block[llllllllllllllIIlllIIIlIllIlIIll.length];
            for (int llllllllllllllIIlllIIIlIllIlIIIl = 0; llllllllllllllIIlllIIIlIllIlIIIl < llllllllllllllIIlllIIIlIllIlIIll.length; ++llllllllllllllIIlllIIIlIllIlIIIl) {
                final int llllllllllllllIIlllIIIlIllIlIIII = llllllllllllllIIlllIIIlIllIlIIll[llllllllllllllIIlllIIIlIllIlIIIl];
                final Block llllllllllllllIIlllIIIlIllIIllll = Block.getBlockById(llllllllllllllIIlllIIIlIllIlIIII);
                if (llllllllllllllIIlllIIIlIllIIllll == null) {
                    this.warn(String.valueOf(new StringBuilder("Block not found for id: ").append(llllllllllllllIIlllIIIlIllIlIIII)));
                    return null;
                }
                llllllllllllllIIlllIIIlIllIlIIlI[llllllllllllllIIlllIIIlIllIlIIIl] = llllllllllllllIIlllIIIlIllIIllll;
            }
            return llllllllllllllIIlllIIIlIllIlIIlI;
        }
        else {
            final String llllllllllllllIIlllIIIlIllIIlllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlllIIIlIllIIlIlI)).append(":").append(llllllllllllllIIlllIIIlIllIIlIIl));
            final Block llllllllllllllIIlllIIIlIllIIllIl = Block.getBlockFromName(llllllllllllllIIlllIIIlIllIIlllI);
            if (llllllllllllllIIlllIIIlIllIIllIl == null) {
                this.warn(String.valueOf(new StringBuilder("Block not found for name: ").append(llllllllllllllIIlllIIIlIllIIlllI)));
                return null;
            }
            final Block[] llllllllllllllIIlllIIIlIllIIllII = { llllllllllllllIIlllIIIlIllIIllIl };
            return llllllllllllllIIlllIIIlIllIIllII;
        }
    }
    
    public static Comparable getPropertyValue(final String llllllllllllllIIlllIIIlIIllIIIIl, final Collection llllllllllllllIIlllIIIlIIllIIlII) {
        for (final Comparable llllllllllllllIIlllIIIlIIllIIIlI : llllllllllllllIIlllIIIlIIllIIlII) {
            if (String.valueOf(llllllllllllllIIlllIIIlIIllIIIlI).equals(llllllllllllllIIlllIIIlIIllIIIIl)) {
                return llllllllllllllIIlllIIIlIIllIIIlI;
            }
        }
        return null;
    }
    
    public static int parseColor(String llllllllllllllIIlllIIIIllIIIllII, final int llllllllllllllIIlllIIIIllIIIllll) {
        if (llllllllllllllIIlllIIIIllIIIllII == null) {
            return llllllllllllllIIlllIIIIllIIIllll;
        }
        llllllllllllllIIlllIIIIllIIIllII = llllllllllllllIIlllIIIIllIIIllII.trim();
        try {
            final int llllllllllllllIIlllIIIIllIIIlllI = Integer.parseInt(llllllllllllllIIlllIIIIllIIIllII, 16) & 0xFFFFFF;
            return llllllllllllllIIlllIIIIllIIIlllI;
        }
        catch (NumberFormatException llllllllllllllIIlllIIIIllIIIllIl) {
            return llllllllllllllIIlllIIIIllIIIllll;
        }
    }
    
    public void dbg(final String llllllllllllllIIlllIIIIlllIIIIlI) {
        Config.dbg(String.valueOf(new StringBuilder().append(this.context).append(": ").append(llllllllllllllIIlllIIIIlllIIIIlI)));
    }
    
    public void warn(final String llllllllllllllIIlllIIIIllIllllII) {
        Config.warn(String.valueOf(new StringBuilder().append(this.context).append(": ").append(llllllllllllllIIlllIIIIllIllllII)));
    }
    
    public static Comparable parsePropertyValue(final IProperty llllllllllllllIIlllIIIlIIllIlllI, final String llllllllllllllIIlllIIIlIIllIllIl) {
        final Class llllllllllllllIIlllIIIlIIlllIIIl = llllllllllllllIIlllIIIlIIllIlllI.getValueClass();
        Comparable llllllllllllllIIlllIIIlIIlllIIII = parseValue(llllllllllllllIIlllIIIlIIllIllIl, llllllllllllllIIlllIIIlIIlllIIIl);
        if (llllllllllllllIIlllIIIlIIlllIIII == null) {
            final Collection llllllllllllllIIlllIIIlIIllIllll = llllllllllllllIIlllIIIlIIllIlllI.getAllowedValues();
            llllllllllllllIIlllIIIlIIlllIIII = getPropertyValue(llllllllllllllIIlllIIIlIIllIllIl, llllllllllllllIIlllIIIlIIllIllll);
        }
        return llllllllllllllIIlllIIIlIIlllIIII;
    }
    
    public boolean startsWithDigit(final String llllllllllllllIIlllIIIlIlllIIIlI) {
        if (llllllllllllllIIlllIIIlIlllIIIlI == null) {
            return false;
        }
        if (llllllllllllllIIlllIIIlIlllIIIlI.length() < 1) {
            return false;
        }
        final char llllllllllllllIIlllIIIlIlllIIIIl = llllllllllllllIIlllIIIlIlllIIIlI.charAt(0);
        return Character.isDigit(llllllllllllllIIlllIIIlIlllIIIIl);
    }
    
    public ConnectedParser(final String llllllllllllllIIlllIIIllIlIIlIIl) {
        this.context = null;
        this.context = llllllllllllllIIlllIIIllIlIIlIIl;
    }
    
    public MatchBlock[] parseMatchBlock(String llllllllllllllIIlllIIIlIllllllII) {
        if (llllllllllllllIIlllIIIlIllllllII == null) {
            return null;
        }
        llllllllllllllIIlllIIIlIllllllII = llllllllllllllIIlllIIIlIllllllII.trim();
        if (llllllllllllllIIlllIIIlIllllllII.length() <= 0) {
            return null;
        }
        final String[] llllllllllllllIIlllIIIllIIIIlIll = Config.tokenize(llllllllllllllIIlllIIIlIllllllII, ":");
        String llllllllllllllIIlllIIIllIIIIlIlI = "minecraft";
        final boolean llllllllllllllIIlllIIIllIIIIlIIl = false;
        byte llllllllllllllIIlllIIIllIIIIIlll = 0;
        if (llllllllllllllIIlllIIIllIIIIlIll.length > 1 && this.isFullBlockName(llllllllllllllIIlllIIIllIIIIlIll)) {
            llllllllllllllIIlllIIIllIIIIlIlI = llllllllllllllIIlllIIIllIIIIlIll[0];
            final byte llllllllllllllIIlllIIIllIIIIlIII = 1;
        }
        else {
            llllllllllllllIIlllIIIllIIIIlIlI = "minecraft";
            llllllllllllllIIlllIIIllIIIIIlll = 0;
        }
        final String llllllllllllllIIlllIIIllIIIIIllI = llllllllllllllIIlllIIIllIIIIlIll[llllllllllllllIIlllIIIllIIIIIlll];
        final String[] llllllllllllllIIlllIIIllIIIIIlIl = Arrays.copyOfRange(llllllllllllllIIlllIIIllIIIIlIll, llllllllllllllIIlllIIIllIIIIIlll + 1, llllllllllllllIIlllIIIllIIIIlIll.length);
        final Block[] llllllllllllllIIlllIIIllIIIIIlII = this.parseBlockPart(llllllllllllllIIlllIIIllIIIIlIlI, llllllllllllllIIlllIIIllIIIIIllI);
        if (llllllllllllllIIlllIIIllIIIIIlII == null) {
            return null;
        }
        final MatchBlock[] llllllllllllllIIlllIIIllIIIIIIll = new MatchBlock[llllllllllllllIIlllIIIllIIIIIlII.length];
        for (int llllllllllllllIIlllIIIllIIIIIIlI = 0; llllllllllllllIIlllIIIllIIIIIIlI < llllllllllllllIIlllIIIllIIIIIlII.length; ++llllllllllllllIIlllIIIllIIIIIIlI) {
            final Block llllllllllllllIIlllIIIllIIIIIIIl = llllllllllllllIIlllIIIllIIIIIlII[llllllllllllllIIlllIIIllIIIIIIlI];
            final int llllllllllllllIIlllIIIllIIIIIIII = Block.getIdFromBlock(llllllllllllllIIlllIIIllIIIIIIIl);
            int[] llllllllllllllIIlllIIIlIllllllll = null;
            if (llllllllllllllIIlllIIIllIIIIIlIl.length > 0) {
                llllllllllllllIIlllIIIlIllllllll = this.parseBlockMetadatas(llllllllllllllIIlllIIIllIIIIIIIl, llllllllllllllIIlllIIIllIIIIIlIl);
                if (llllllllllllllIIlllIIIlIllllllll == null) {
                    return null;
                }
            }
            final MatchBlock llllllllllllllIIlllIIIlIlllllllI = new MatchBlock(llllllllllllllIIlllIIIllIIIIIIII, llllllllllllllIIlllIIIlIllllllll);
            llllllllllllllIIlllIIIllIIIIIIll[llllllllllllllIIlllIIIllIIIIIIlI] = llllllllllllllIIlllIIIlIlllllllI;
        }
        return llllllllllllllIIlllIIIllIIIIIIll;
    }
    
    private IBlockState getStateFromMeta(final Block llllllllllllllIIlllIIIlIIlllllII, final int llllllllllllllIIlllIIIlIIllllIll) {
        try {
            IBlockState llllllllllllllIIlllIIIlIIlllllll = llllllllllllllIIlllIIIlIIlllllII.getStateFromMeta(llllllllllllllIIlllIIIlIIllllIll);
            if (llllllllllllllIIlllIIIlIIlllllII == Blocks.double_plant && llllllllllllllIIlllIIIlIIllllIll > 7) {
                final IBlockState llllllllllllllIIlllIIIlIIllllllI = llllllllllllllIIlllIIIlIIlllllII.getStateFromMeta(llllllllllllllIIlllIIIlIIllllIll & 0x7);
                llllllllllllllIIlllIIIlIIlllllll = llllllllllllllIIlllIIIlIIlllllll.withProperty(BlockDoublePlant.VARIANT_PROP, llllllllllllllIIlllIIIlIIllllllI.getValue(BlockDoublePlant.VARIANT_PROP));
            }
            return llllllllllllllIIlllIIIlIIlllllll;
        }
        catch (IllegalArgumentException llllllllllllllIIlllIIIlIIlllllIl) {
            return llllllllllllllIIlllIIIlIIlllllII.getDefaultState();
        }
    }
    
    public static Comparable parseValue(final String llllllllllllllIIlllIIIlIIlIllIIl, final Class llllllllllllllIIlllIIIlIIlIllIlI) {
        return (Comparable)((llllllllllllllIIlllIIIlIIlIllIlI == String.class) ? llllllllllllllIIlllIIIlIIlIllIIl : ((llllllllllllllIIlllIIIlIIlIllIlI == Boolean.class) ? Boolean.valueOf(llllllllllllllIIlllIIIlIIlIllIIl) : ((Double)((llllllllllllllIIlllIIIlIIlIllIlI == Float.class) ? Float.valueOf(llllllllllllllIIlllIIIlIIlIllIIl) : ((llllllllllllllIIlllIIIlIIlIllIlI == Double.class) ? Double.valueOf(llllllllllllllIIlllIIIlIIlIllIIl) : ((double)((llllllllllllllIIlllIIIlIIlIllIlI == Integer.class) ? Integer.valueOf(llllllllllllllIIlllIIIlIIlIllIIl) : ((long)((llllllllllllllIIlllIIIlIIlIllIlI == Long.class) ? Long.valueOf(llllllllllllllIIlllIIIlIIlIllIIl) : null)))))))));
    }
    
    public RangeListInt parseRangeListInt(final String llllllllllllllIIlllIIIIllIlIllII) {
        if (llllllllllllllIIlllIIIIllIlIllII == null) {
            return null;
        }
        final RangeListInt llllllllllllllIIlllIIIIllIllIIlI = new RangeListInt();
        final String[] llllllllllllllIIlllIIIIllIllIIIl = Config.tokenize(llllllllllllllIIlllIIIIllIlIllII, " ,");
        for (int llllllllllllllIIlllIIIIllIllIIII = 0; llllllllllllllIIlllIIIIllIllIIII < llllllllllllllIIlllIIIIllIllIIIl.length; ++llllllllllllllIIlllIIIIllIllIIII) {
            final String llllllllllllllIIlllIIIIllIlIllll = llllllllllllllIIlllIIIIllIllIIIl[llllllllllllllIIlllIIIIllIllIIII];
            final RangeInt llllllllllllllIIlllIIIIllIlIlllI = this.parseRangeInt(llllllllllllllIIlllIIIIllIlIllll);
            if (llllllllllllllIIlllIIIIllIlIlllI == null) {
                return null;
            }
            llllllllllllllIIlllIIIIllIllIIlI.addRange(llllllllllllllIIlllIIIIllIlIlllI);
        }
        return llllllllllllllIIlllIIIIllIllIIlI;
    }
    
    static {
        NO_MATCH_BLOCKS = new MatchBlock[0];
    }
    
    public boolean[] parseFaces(final String llllllllllllllIIlllIIIIlllIlllII, final boolean[] llllllllllllllIIlllIIIIlllIlIIIl) {
        if (llllllllllllllIIlllIIIIlllIlllII == null) {
            return llllllllllllllIIlllIIIIlllIlIIIl;
        }
        final EnumSet llllllllllllllIIlllIIIIlllIllIlI = EnumSet.allOf(EnumFacing.class);
        final String[] llllllllllllllIIlllIIIIlllIllIIl = Config.tokenize(llllllllllllllIIlllIIIIlllIlllII, " ,");
        for (int llllllllllllllIIlllIIIIlllIllIII = 0; llllllllllllllIIlllIIIIlllIllIII < llllllllllllllIIlllIIIIlllIllIIl.length; ++llllllllllllllIIlllIIIIlllIllIII) {
            final String llllllllllllllIIlllIIIIlllIlIlll = llllllllllllllIIlllIIIIlllIllIIl[llllllllllllllIIlllIIIIlllIllIII];
            if (llllllllllllllIIlllIIIIlllIlIlll.equals("sides")) {
                llllllllllllllIIlllIIIIlllIllIlI.add(EnumFacing.NORTH);
                llllllllllllllIIlllIIIIlllIllIlI.add(EnumFacing.SOUTH);
                llllllllllllllIIlllIIIIlllIllIlI.add(EnumFacing.WEST);
                llllllllllllllIIlllIIIIlllIllIlI.add(EnumFacing.EAST);
            }
            else if (llllllllllllllIIlllIIIIlllIlIlll.equals("all")) {
                llllllllllllllIIlllIIIIlllIllIlI.addAll(Arrays.asList(EnumFacing.VALUES));
            }
            else {
                final EnumFacing llllllllllllllIIlllIIIIlllIlIllI = this.parseFace(llllllllllllllIIlllIIIIlllIlIlll);
                if (llllllllllllllIIlllIIIIlllIlIllI != null) {
                    llllllllllllllIIlllIIIIlllIllIlI.add(llllllllllllllIIlllIIIIlllIlIllI);
                }
            }
        }
        final boolean[] llllllllllllllIIlllIIIIlllIlIlIl = new boolean[EnumFacing.VALUES.length];
        for (int llllllllllllllIIlllIIIIlllIlIlII = 0; llllllllllllllIIlllIIIIlllIlIlII < llllllllllllllIIlllIIIIlllIlIlIl.length; ++llllllllllllllIIlllIIIIlllIlIlII) {
            llllllllllllllIIlllIIIIlllIlIlIl[llllllllllllllIIlllIIIIlllIlIlII] = llllllllllllllIIlllIIIIlllIllIlI.contains(EnumFacing.VALUES[llllllllllllllIIlllIIIIlllIlIlII]);
        }
        return llllllllllllllIIlllIIIIlllIlIlIl;
    }
    
    public boolean matchState(final IBlockState llllllllllllllIIlllIIIlIIlIIllll, final Map<IProperty, List<Comparable>> llllllllllllllIIlllIIIlIIlIIIlll) {
        final Set llllllllllllllIIlllIIIlIIlIIllIl = llllllllllllllIIlllIIIlIIlIIIlll.keySet();
        for (final IProperty llllllllllllllIIlllIIIlIIlIIlIIl : llllllllllllllIIlllIIIlIIlIIllIl) {
            final List llllllllllllllIIlllIIIlIIlIIlIll = llllllllllllllIIlllIIIlIIlIIIlll.get(llllllllllllllIIlllIIIlIIlIIlIIl);
            final Comparable llllllllllllllIIlllIIIlIIlIIlIlI = llllllllllllllIIlllIIIlIIlIIllll.getValue(llllllllllllllIIlllIIIlIIlIIlIIl);
            if (llllllllllllllIIlllIIIlIIlIIlIlI == null) {
                return false;
            }
            if (!llllllllllllllIIlllIIIlIIlIIlIll.contains(llllllllllllllIIlllIIIlIIlIIlIlI)) {
                return false;
            }
        }
        return true;
    }
    
    public String parseBasePath(final String llllllllllllllIIlllIIIllIIllIllI) {
        final int llllllllllllllIIlllIIIllIIllIlIl = llllllllllllllIIlllIIIllIIllIllI.lastIndexOf(47);
        return (llllllllllllllIIlllIIIllIIllIlIl < 0) ? "" : llllllllllllllIIlllIIIllIIllIllI.substring(0, llllllllllllllIIlllIIIllIIllIlIl);
    }
    
    public BiomeGenBase[] parseBiomes(final String llllllllllllllIIlllIIIlIIIllIIIl) {
        if (llllllllllllllIIlllIIIlIIIllIIIl == null) {
            return null;
        }
        final String[] llllllllllllllIIlllIIIlIIIlllIII = Config.tokenize(llllllllllllllIIlllIIIlIIIllIIIl, " ");
        final ArrayList llllllllllllllIIlllIIIlIIIllIlll = new ArrayList();
        for (int llllllllllllllIIlllIIIlIIIllIllI = 0; llllllllllllllIIlllIIIlIIIllIllI < llllllllllllllIIlllIIIlIIIlllIII.length; ++llllllllllllllIIlllIIIlIIIllIllI) {
            final String llllllllllllllIIlllIIIlIIIllIlIl = llllllllllllllIIlllIIIlIIIlllIII[llllllllllllllIIlllIIIlIIIllIllI];
            final BiomeGenBase llllllllllllllIIlllIIIlIIIllIlII = this.findBiome(llllllllllllllIIlllIIIlIIIllIlIl);
            if (llllllllllllllIIlllIIIlIIIllIlII == null) {
                this.warn(String.valueOf(new StringBuilder("Biome not found: ").append(llllllllllllllIIlllIIIlIIIllIlIl)));
            }
            else {
                llllllllllllllIIlllIIIlIIIllIlll.add(llllllllllllllIIlllIIIlIIIllIlII);
            }
        }
        final BiomeGenBase[] llllllllllllllIIlllIIIlIIIllIIll = llllllllllllllIIlllIIIlIIIllIlll.toArray(new BiomeGenBase[llllllllllllllIIlllIIIlIIIllIlll.size()]);
        return llllllllllllllIIlllIIIlIIIllIIll;
    }
    
    public int parseInt(final String llllllllllllllIIlllIIIlIIIIIllIl, final int llllllllllllllIIlllIIIlIIIIIllII) {
        if (llllllllllllllIIlllIIIlIIIIIllIl == null) {
            return llllllllllllllIIlllIIIlIIIIIllII;
        }
        final int llllllllllllllIIlllIIIlIIIIIlIll = Config.parseInt(llllllllllllllIIlllIIIlIIIIIllIl, -1);
        if (llllllllllllllIIlllIIIlIIIIIlIll < 0) {
            this.warn(String.valueOf(new StringBuilder("Invalid number: ").append(llllllllllllllIIlllIIIlIIIIIllIl)));
            return llllllllllllllIIlllIIIlIIIIIllII;
        }
        return llllllllllllllIIlllIIIlIIIIIlIll;
    }
    
    public int[] parseIntList(final String llllllllllllllIIlllIIIIllllIlllI) {
        if (llllllllllllllIIlllIIIIllllIlllI == null) {
            return null;
        }
        final ArrayList llllllllllllllIIlllIIIIllllllIlI = new ArrayList();
        final String[] llllllllllllllIIlllIIIIllllllIIl = Config.tokenize(llllllllllllllIIlllIIIIllllIlllI, " ,");
        for (int llllllllllllllIIlllIIIIllllllIII = 0; llllllllllllllIIlllIIIIllllllIII < llllllllllllllIIlllIIIIllllllIIl.length; ++llllllllllllllIIlllIIIIllllllIII) {
            final String llllllllllllllIIlllIIIIlllllIlll = llllllllllllllIIlllIIIIllllllIIl[llllllllllllllIIlllIIIIllllllIII];
            if (llllllllllllllIIlllIIIIlllllIlll.contains("-")) {
                final String[] llllllllllllllIIlllIIIIlllllIllI = Config.tokenize(llllllllllllllIIlllIIIIlllllIlll, "-");
                if (llllllllllllllIIlllIIIIlllllIllI.length != 2) {
                    this.warn(String.valueOf(new StringBuilder("Invalid interval: ").append(llllllllllllllIIlllIIIIlllllIlll).append(", when parsing: ").append(llllllllllllllIIlllIIIIllllIlllI)));
                }
                else {
                    final int llllllllllllllIIlllIIIIlllllIlIl = Config.parseInt(llllllllllllllIIlllIIIIlllllIllI[0], -1);
                    final int llllllllllllllIIlllIIIIlllllIlII = Config.parseInt(llllllllllllllIIlllIIIIlllllIllI[1], -1);
                    if (llllllllllllllIIlllIIIIlllllIlIl >= 0 && llllllllllllllIIlllIIIIlllllIlII >= 0 && llllllllllllllIIlllIIIIlllllIlIl <= llllllllllllllIIlllIIIIlllllIlII) {
                        for (int llllllllllllllIIlllIIIIlllllIIll = llllllllllllllIIlllIIIIlllllIlIl; llllllllllllllIIlllIIIIlllllIIll <= llllllllllllllIIlllIIIIlllllIlII; ++llllllllllllllIIlllIIIIlllllIIll) {
                            llllllllllllllIIlllIIIIllllllIlI.add(llllllllllllllIIlllIIIIlllllIIll);
                        }
                    }
                    else {
                        this.warn(String.valueOf(new StringBuilder("Invalid interval: ").append(llllllllllllllIIlllIIIIlllllIlll).append(", when parsing: ").append(llllllllllllllIIlllIIIIllllIlllI)));
                    }
                }
            }
            else {
                final int llllllllllllllIIlllIIIIlllllIIlI = Config.parseInt(llllllllllllllIIlllIIIIlllllIlll, -1);
                if (llllllllllllllIIlllIIIIlllllIIlI < 0) {
                    this.warn(String.valueOf(new StringBuilder("Invalid number: ").append(llllllllllllllIIlllIIIIlllllIlll).append(", when parsing: ").append(llllllllllllllIIlllIIIIllllIlllI)));
                }
                else {
                    llllllllllllllIIlllIIIIllllllIlI.add(llllllllllllllIIlllIIIIlllllIIlI);
                }
            }
        }
        final int[] llllllllllllllIIlllIIIIlllllIIIl = new int[llllllllllllllIIlllIIIIllllllIlI.size()];
        for (int llllllllllllllIIlllIIIIlllllIIII = 0; llllllllllllllIIlllIIIIlllllIIII < llllllllllllllIIlllIIIIlllllIIIl.length; ++llllllllllllllIIlllIIIIlllllIIII) {
            llllllllllllllIIlllIIIIlllllIIIl[llllllllllllllIIlllIIIIlllllIIII] = llllllllllllllIIlllIIIIllllllIlI.get(llllllllllllllIIlllIIIIlllllIIII);
        }
        return llllllllllllllIIlllIIIIlllllIIIl;
    }
    
    public static boolean parseBoolean(final String llllllllllllllIIlllIIIIllIIlIlII) {
        return llllllllllllllIIlllIIIIllIIlIlII != null && llllllllllllllIIlllIIIIllIIlIlII.toLowerCase().equals("true");
    }
}
