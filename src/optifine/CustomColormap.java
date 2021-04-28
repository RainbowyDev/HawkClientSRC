package optifine;

import net.minecraft.world.biome.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import java.io.*;
import java.awt.image.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import java.util.regex.*;

public class CustomColormap implements CustomColors.IColorizer
{
    private /* synthetic */ int width;
    private /* synthetic */ float[][] colorsRgb;
    private /* synthetic */ int yVariance;
    public /* synthetic */ String name;
    private /* synthetic */ int yOffset;
    public /* synthetic */ String basePath;
    private /* synthetic */ int height;
    private /* synthetic */ MatchBlock[] matchBlocks;
    private /* synthetic */ int[] colors;
    private /* synthetic */ int format;
    private /* synthetic */ String source;
    private /* synthetic */ int color;
    
    public int getLength() {
        return (this.format == 2) ? 1 : this.colors.length;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    private static String parseTexture(String llIIlllIIIIllII, final String llIIlllIIIIlIll, final String llIIlllIIIIlIlI) {
        if (llIIlllIIIIllII != null) {
            final String llIIlllIIIlIIII = ".png";
            if (((String)llIIlllIIIIllII).endsWith(llIIlllIIIlIIII)) {
                llIIlllIIIIllII = ((String)llIIlllIIIIllII).substring(0, ((String)llIIlllIIIIllII).length() - llIIlllIIIlIIII.length());
            }
            llIIlllIIIIllII = fixTextureName((String)llIIlllIIIIllII, llIIlllIIIIlIlI);
            return (String)llIIlllIIIIllII;
        }
        String llIIlllIIIIllll = llIIlllIIIIlIll;
        final int llIIlllIIIIlllI = llIIlllIIIIlIll.lastIndexOf(47);
        if (llIIlllIIIIlllI >= 0) {
            llIIlllIIIIllll = llIIlllIIIIlIll.substring(llIIlllIIIIlllI + 1);
        }
        final int llIIlllIIIIllIl = llIIlllIIIIllll.lastIndexOf(46);
        if (llIIlllIIIIllIl >= 0) {
            llIIlllIIIIllll = llIIlllIIIIllll.substring(0, llIIlllIIIIllIl);
        }
        llIIlllIIIIllll = fixTextureName(llIIlllIIIIllll, llIIlllIIIIlIlI);
        return llIIlllIIIIllll;
    }
    
    private static String fixTextureName(String llIIlllIIIIIIII, final String llIIlllIIIIIIlI) {
        llIIlllIIIIIIII = TextureUtils.fixResourcePath(llIIlllIIIIIIII, llIIlllIIIIIIlI);
        if (!llIIlllIIIIIIII.startsWith(llIIlllIIIIIIlI) && !llIIlllIIIIIIII.startsWith("textures/") && !llIIlllIIIIIIII.startsWith("mcpatcher/")) {
            llIIlllIIIIIIII = String.valueOf(new StringBuilder(String.valueOf(llIIlllIIIIIIlI)).append("/").append(llIIlllIIIIIIII));
        }
        if (llIIlllIIIIIIII.endsWith(".png")) {
            llIIlllIIIIIIII = llIIlllIIIIIIII.substring(0, llIIlllIIIIIIII.length() - 4);
        }
        final String llIIlllIIIIIIIl = "textures/blocks/";
        if (llIIlllIIIIIIII.startsWith(llIIlllIIIIIIIl)) {
            llIIlllIIIIIIII = llIIlllIIIIIIII.substring(llIIlllIIIIIIIl.length());
        }
        if (llIIlllIIIIIIII.startsWith("/")) {
            llIIlllIIIIIIII = llIIlllIIIIIIII.substring(1);
        }
        return llIIlllIIIIIIII;
    }
    
    public float[][] getColorsRgb() {
        if (this.colorsRgb == null) {
            this.colorsRgb = toRgb(this.colors);
        }
        return this.colorsRgb;
    }
    
    public CustomColormap(final Properties llIIlllIllIlIlI, final String llIIlllIllIlIIl, final int llIIlllIllIlIII, final int llIIlllIllIIIIl) {
        this.name = null;
        this.basePath = null;
        this.format = -1;
        this.matchBlocks = null;
        this.source = null;
        this.color = -1;
        this.yVariance = 0;
        this.yOffset = 0;
        this.width = 0;
        this.height = 0;
        this.colors = null;
        this.colorsRgb = null;
        final ConnectedParser llIIlllIllIIllI = new ConnectedParser("Colormap");
        this.name = llIIlllIllIIllI.parseName(llIIlllIllIlIIl);
        this.basePath = llIIlllIllIIllI.parseBasePath(llIIlllIllIlIIl);
        this.format = this.parseFormat(llIIlllIllIlIlI.getProperty("format"));
        this.matchBlocks = llIIlllIllIIllI.parseMatchBlocks(llIIlllIllIlIlI.getProperty("blocks"));
        this.source = parseTexture(llIIlllIllIlIlI.getProperty("source"), llIIlllIllIlIIl, this.basePath);
        this.color = ConnectedParser.parseColor(llIIlllIllIlIlI.getProperty("color"), -1);
        this.yVariance = llIIlllIllIIllI.parseInt(llIIlllIllIlIlI.getProperty("yVariance"), 0);
        this.yOffset = llIIlllIllIIllI.parseInt(llIIlllIllIlIlI.getProperty("yOffset"), 0);
        this.width = llIIlllIllIlIII;
        this.height = llIIlllIllIIIIl;
    }
    
    private static float[][] toRgb(final int[] llIIllIIlIIlIIl) {
        final float[][] llIIllIIlIlIIII = new float[llIIllIIlIIlIIl.length][3];
        for (int llIIllIIlIIllll = 0; llIIllIIlIIllll < llIIllIIlIIlIIl.length; ++llIIllIIlIIllll) {
            final int llIIllIIlIIlllI = llIIllIIlIIlIIl[llIIllIIlIIllll];
            final float llIIllIIlIIllIl = (llIIllIIlIIlllI >> 16 & 0xFF) / 255.0f;
            final float llIIllIIlIIllII = (llIIllIIlIIlllI >> 8 & 0xFF) / 255.0f;
            final float llIIllIIlIIlIll = (llIIllIIlIIlllI & 0xFF) / 255.0f;
            final float[] llIIllIIlIIlIlI = llIIllIIlIlIIII[llIIllIIlIIllll];
            llIIllIIlIIlIlI[0] = llIIllIIlIIllIl;
            llIIllIIlIIlIlI[1] = llIIllIIlIIllII;
            llIIllIIlIIlIlI[2] = llIIllIIlIIlIll;
        }
        return llIIllIIlIlIIII;
    }
    
    private int getColorVanilla(final BiomeGenBase llIIllIlIIIIIll, final BlockPos llIIllIlIIIlIIl) {
        final double llIIllIlIIIlIII = MathHelper.clamp_float(llIIllIlIIIIIll.func_180626_a(llIIllIlIIIlIIl), 0.0f, 1.0f);
        double llIIllIlIIIIlll = MathHelper.clamp_float(llIIllIlIIIIIll.getFloatRainfall(), 0.0f, 1.0f);
        llIIllIlIIIIlll *= llIIllIlIIIlIII;
        final int llIIllIlIIIIllI = (int)((1.0 - llIIllIlIIIlIII) * (this.width - 1));
        final int llIIllIlIIIIlIl = (int)((1.0 - llIIllIlIIIIlll) * (this.height - 1));
        return this.getColor(llIIllIlIIIIllI, llIIllIlIIIIlIl);
    }
    
    public boolean matchesBlock(final BlockStateBase llIIllIlllllIII) {
        return Matches.block(llIIllIlllllIII, this.matchBlocks);
    }
    
    public int getColorRandom() {
        if (this.format == 2) {
            return this.color;
        }
        final int llIIllIllllIlII = CustomColors.random.nextInt(this.colors.length);
        return this.colors[llIIllIllllIlII];
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.basePath).append("/").append(this.name).append(", blocks: ").append(Config.arrayToString(this.matchBlocks)).append(", source: ").append(this.source));
    }
    
    public boolean isValid(final String llIIlllIlIllIII) {
        if (this.format != 0 && this.format != 1) {
            if (this.format != 2) {
                return false;
            }
            if (this.color < 0) {
                this.color = 16777215;
            }
        }
        else {
            if (this.source == null) {
                warn(String.valueOf(new StringBuilder("Source not defined: ").append(llIIlllIlIllIII)));
                return false;
            }
            this.readColors();
            if (this.colors == null) {
                return false;
            }
            if (this.color < 0) {
                if (this.format == 0) {
                    this.color = this.getColor(127, 127);
                }
                if (this.format == 1) {
                    this.color = this.getColorGrid(BiomeGenBase.plains, new BlockPos(0, 64, 0));
                }
            }
        }
        return true;
    }
    
    private static void warn(final String llIIlllIIIllIll) {
        Config.warn(String.valueOf(new StringBuilder("CustomColors: ").append(llIIlllIIIllIll)));
    }
    
    private void readColors() {
        try {
            this.colors = null;
            if (this.source == null) {
                return;
            }
            final String llIIlllIIllIIIl = String.valueOf(new StringBuilder(String.valueOf(this.source)).append(".png"));
            final ResourceLocation llIIlllIIllIIII = new ResourceLocation(llIIlllIIllIIIl);
            final InputStream llIIlllIIlIllll = Config.getResourceStream(llIIlllIIllIIII);
            if (llIIlllIIlIllll == null) {
                return;
            }
            final BufferedImage llIIlllIIlIlllI = TextureUtil.func_177053_a(llIIlllIIlIllll);
            if (llIIlllIIlIlllI == null) {
                return;
            }
            final int llIIlllIIlIllIl = llIIlllIIlIlllI.getWidth();
            final int llIIlllIIlIllII = llIIlllIIlIlllI.getHeight();
            final boolean llIIlllIIlIlIll = this.width < 0 || this.width == llIIlllIIlIllIl;
            final boolean llIIlllIIlIlIlI = this.height < 0 || this.height == llIIlllIIlIllII;
            if (!llIIlllIIlIlIll || !llIIlllIIlIlIlI) {
                dbg(String.valueOf(new StringBuilder("Non-standard palette size: ").append(llIIlllIIlIllIl).append("x").append(llIIlllIIlIllII).append(", should be: ").append(this.width).append("x").append(this.height).append(", path: ").append(llIIlllIIllIIIl)));
            }
            this.width = llIIlllIIlIllIl;
            this.height = llIIlllIIlIllII;
            if (this.width <= 0 || this.height <= 0) {
                warn(String.valueOf(new StringBuilder("Invalid palette size: ").append(llIIlllIIlIllIl).append("x").append(llIIlllIIlIllII).append(", path: ").append(llIIlllIIllIIIl)));
                return;
            }
            this.colors = new int[llIIlllIIlIllIl * llIIlllIIlIllII];
            llIIlllIIlIlllI.getRGB(0, 0, llIIlllIIlIllIl, llIIlllIIlIllII, this.colors, 0, llIIlllIIlIllIl);
        }
        catch (IOException llIIlllIIlIlIIl) {
            llIIlllIIlIlIIl.printStackTrace();
        }
    }
    
    public boolean isValidMatchBlocks(final String llIIlllIlIlIIlI) {
        if (this.matchBlocks == null) {
            this.matchBlocks = this.detectMatchBlocks();
            if (this.matchBlocks == null) {
                warn(String.valueOf(new StringBuilder("Match blocks not defined: ").append(llIIlllIlIlIIlI)));
                return false;
            }
        }
        return true;
    }
    
    public int[] getMatchBlockIds() {
        if (this.matchBlocks == null) {
            return null;
        }
        final HashSet llIIllIIIIlllIl = new HashSet();
        for (int llIIllIIIIlllII = 0; llIIllIIIIlllII < this.matchBlocks.length; ++llIIllIIIIlllII) {
            final MatchBlock llIIllIIIIllIll = this.matchBlocks[llIIllIIIIlllII];
            if (llIIllIIIIllIll.getBlockId() >= 0) {
                llIIllIIIIlllIl.add(llIIllIIIIllIll.getBlockId());
            }
        }
        final Integer[] llIIllIIIIllIlI = (Integer[])llIIllIIIIlllIl.toArray(new Integer[llIIllIIIIlllIl.size()]);
        final int[] llIIllIIIIllIIl = new int[llIIllIIIIllIlI.length];
        for (int llIIllIIIIllIII = 0; llIIllIIIIllIII < llIIllIIIIllIlI.length; ++llIIllIIIIllIII) {
            llIIllIIIIllIIl[llIIllIIIIllIII] = llIIllIIIIllIlI[llIIllIIIIllIII];
        }
        return llIIllIIIIllIIl;
    }
    
    @Override
    public int getColor(final IBlockAccess llIIllIllIlIllI, final BlockPos llIIllIllIllIIl) {
        final BiomeGenBase llIIllIllIllIII = CustomColors.getColorBiome(llIIllIllIlIllI, llIIllIllIllIIl);
        return this.getColor(llIIllIllIllIII, llIIllIllIllIIl);
    }
    
    private MatchBlock getMatchBlock(final int llIIllIIIlIIllI) {
        if (this.matchBlocks == null) {
            return null;
        }
        for (int llIIllIIIlIlIIl = 0; llIIllIIIlIlIIl < this.matchBlocks.length; ++llIIllIIIlIlIIl) {
            final MatchBlock llIIllIIIlIlIII = this.matchBlocks[llIIllIIIlIlIIl];
            if (llIIllIIIlIlIII.getBlockId() == llIIllIIIlIIllI) {
                return llIIllIIIlIlIII;
            }
        }
        return null;
    }
    
    public void addMatchBlock(final int llIIllIIIllIllI, final int llIIllIIIllIIIl) {
        final MatchBlock llIIllIIIllIlII = this.getMatchBlock(llIIllIIIllIllI);
        if (llIIllIIIllIlII != null) {
            if (llIIllIIIllIIIl >= 0) {
                llIIllIIIllIlII.addMetadata(llIIllIIIllIIIl);
            }
        }
        else {
            this.addMatchBlock(new MatchBlock(llIIllIIIllIllI, llIIllIIIllIIIl));
        }
    }
    
    private int parseFormat(final String llIIlllIlIlllIl) {
        if (llIIlllIlIlllIl == null) {
            return 0;
        }
        if (llIIlllIlIlllIl.equals("vanilla")) {
            return 0;
        }
        if (llIIlllIlIlllIl.equals("grid")) {
            return 1;
        }
        if (llIIlllIlIlllIl.equals("fixed")) {
            return 2;
        }
        warn(String.valueOf(new StringBuilder("Unknown format: ").append(llIIlllIlIlllIl)));
        return -1;
    }
    
    @Override
    public boolean isColorConstant() {
        return this.format == 2;
    }
    
    private MatchBlock[] detectMatchBlocks() {
        final Block llIIlllIlIIlIII = Block.getBlockFromName(this.name);
        if (llIIlllIlIIlIII != null) {
            return new MatchBlock[] { new MatchBlock(Block.getIdFromBlock(llIIlllIlIIlIII)) };
        }
        final Pattern llIIlllIlIIIlll = Pattern.compile("^block([0-9]+).*$");
        final Matcher llIIlllIlIIIllI = llIIlllIlIIIlll.matcher(this.name);
        if (llIIlllIlIIIllI.matches()) {
            final String llIIlllIlIIIlIl = llIIlllIlIIIllI.group(1);
            final int llIIlllIlIIIlII = Config.parseInt(llIIlllIlIIIlIl, -1);
            if (llIIlllIlIIIlII >= 0) {
                return new MatchBlock[] { new MatchBlock(llIIlllIlIIIlII) };
            }
        }
        final ConnectedParser llIIlllIlIIIIll = new ConnectedParser("Colormap");
        final MatchBlock[] llIIlllIlIIIIlI = llIIlllIlIIIIll.parseMatchBlock(this.name);
        return (MatchBlock[])((llIIlllIlIIIIlI != null) ? llIIlllIlIIIIlI : null);
    }
    
    private static void dbg(final String llIIlllIIIlllIl) {
        Config.dbg(String.valueOf(new StringBuilder("CustomColors: ").append(llIIlllIIIlllIl)));
    }
    
    static {
        FORMAT_VANILLA = 0;
        FORMAT_UNKNOWN = -1;
        KEY_Y_VARIANCE = "yVariance";
        FORMAT_GRID = 1;
        KEY_SOURCE = "source";
        FORMAT_FIXED = 2;
        KEY_COLOR = "color";
        KEY_FORMAT = "format";
        KEY_BLOCKS = "blocks";
        KEY_Y_OFFSET = "yOffset";
    }
    
    public int getColor(int llIIllIlllIllII) {
        llIIllIlllIllII = Config.limit((int)llIIllIlllIllII, 0, this.colors.length);
        return this.colors[llIIllIlllIllII] & 0xFFFFFF;
    }
    
    private int getColorGrid(final BiomeGenBase llIIllIIllIlIlI, final BlockPos llIIllIIllIlIIl) {
        final int llIIllIIlllIIIl = llIIllIIllIlIlI.biomeID;
        int llIIllIIlllIIII = llIIllIIllIlIIl.getY() - this.yOffset;
        if (this.yVariance > 0) {
            final int llIIllIIllIllll = llIIllIIllIlIIl.getX() << 16 + llIIllIIllIlIIl.getZ();
            final int llIIllIIllIlllI = Config.intHash(llIIllIIllIllll);
            final int llIIllIIllIllIl = this.yVariance * 2 + 1;
            final int llIIllIIllIllII = (llIIllIIllIlllI & 0xFF) % llIIllIIllIllIl - this.yVariance;
            llIIllIIlllIIII += llIIllIIllIllII;
        }
        return this.getColor(llIIllIIlllIIIl, llIIllIIlllIIII);
    }
    
    public int getColor(final BiomeGenBase llIIllIllIIllII, final BlockPos llIIllIllIIlIll) {
        return (this.format == 0) ? this.getColorVanilla(llIIllIllIIllII, llIIllIllIIlIll) : ((this.format == 1) ? this.getColorGrid(llIIllIllIIllII, llIIllIllIIlIll) : this.color);
    }
    
    public int getColor(int llIIllIlllIIlII, int llIIllIlllIIIll) {
        llIIllIlllIIlII = Config.limit(llIIllIlllIIlII, 0, this.width - 1);
        llIIllIlllIIIll = Config.limit(llIIllIlllIIIll, 0, this.height - 1);
        return this.colors[llIIllIlllIIIll * this.width + llIIllIlllIIlII] & 0xFFFFFF;
    }
    
    public int getColorSmooth(final IBlockAccess llIIllIlIlIIIlI, final double llIIllIlIllIlII, final double llIIllIlIlIIIII, final double llIIllIlIllIIlI, final int llIIllIlIllIIIl) {
        if (this.format == 2) {
            return this.color;
        }
        final int llIIllIlIllIIII = MathHelper.floor_double(llIIllIlIllIlII);
        final int llIIllIlIlIllll = MathHelper.floor_double(llIIllIlIlIIIII);
        final int llIIllIlIlIlllI = MathHelper.floor_double(llIIllIlIllIIlI);
        int llIIllIlIlIllIl = 0;
        int llIIllIlIlIllII = 0;
        int llIIllIlIlIlIll = 0;
        int llIIllIlIlIlIlI = 0;
        final BlockPosM llIIllIlIlIlIIl = new BlockPosM(0, 0, 0);
        for (int llIIllIlIlIlIII = llIIllIlIllIIII - llIIllIlIllIIIl; llIIllIlIlIlIII <= llIIllIlIllIIII + llIIllIlIllIIIl; ++llIIllIlIlIlIII) {
            for (int llIIllIlIlIIlll = llIIllIlIlIlllI - llIIllIlIllIIIl; llIIllIlIlIIlll <= llIIllIlIlIlllI + llIIllIlIllIIIl; ++llIIllIlIlIIlll) {
                llIIllIlIlIlIIl.setXyz(llIIllIlIlIlIII, llIIllIlIlIllll, llIIllIlIlIIlll);
                final int llIIllIlIlIIlIl = this.getColor(llIIllIlIlIIIlI, llIIllIlIlIlIIl);
                llIIllIlIlIllIl += (llIIllIlIlIIlIl >> 16 & 0xFF);
                llIIllIlIlIllII += (llIIllIlIlIIlIl >> 8 & 0xFF);
                llIIllIlIlIlIll += (llIIllIlIlIIlIl & 0xFF);
                ++llIIllIlIlIlIlI;
            }
        }
        int llIIllIlIlIlIII = llIIllIlIlIllIl / llIIllIlIlIlIlI;
        final int llIIllIlIlIIllI = llIIllIlIlIllII / llIIllIlIlIlIlI;
        final int llIIllIlIlIIlII = llIIllIlIlIlIll / llIIllIlIlIlIlI;
        return llIIllIlIlIlIII << 16 | llIIllIlIlIIllI << 8 | llIIllIlIlIIlII;
    }
    
    public void addMatchBlock(final MatchBlock llIIllIIIllllII) {
        if (this.matchBlocks == null) {
            this.matchBlocks = new MatchBlock[0];
        }
        this.matchBlocks = (MatchBlock[])Config.addObjectToArray(this.matchBlocks, llIIllIIIllllII);
    }
}
