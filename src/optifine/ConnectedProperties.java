package optifine;

import net.minecraft.world.biome.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import java.util.*;

public class ConnectedProperties
{
    public /* synthetic */ MatchBlock[] matchBlocks;
    public /* synthetic */ int faces;
    public /* synthetic */ int maxHeight;
    public /* synthetic */ int[] metadatas;
    public /* synthetic */ String[] tiles;
    public /* synthetic */ String basePath;
    public /* synthetic */ String name;
    public /* synthetic */ TextureAtlasSprite[] tileIcons;
    public /* synthetic */ BiomeGenBase[] biomes;
    public /* synthetic */ boolean innerSeams;
    public /* synthetic */ int connect;
    public /* synthetic */ int[] sumWeights;
    public /* synthetic */ int height;
    public /* synthetic */ int[] weights;
    public /* synthetic */ int width;
    public /* synthetic */ int method;
    public /* synthetic */ String[] matchTiles;
    public /* synthetic */ int minHeight;
    public /* synthetic */ int sumAllWeights;
    public /* synthetic */ int symmetry;
    public /* synthetic */ int renderPass;
    public /* synthetic */ TextureAtlasSprite[] matchTileIcons;
    
    static {
        METHOD_TOP = 3;
        CONNECT_BLOCK = 1;
        FACE_UNKNOWN = 128;
        CONNECT_MATERIAL = 3;
        FACE_NORTH = 4;
        METHOD_HORIZONTAL_VERTICAL = 8;
        FACE_SIDES = 60;
        FACE_EAST = 32;
        CONNECT_UNKNOWN = 128;
        FACE_TOP = 2;
        METHOD_HORIZONTAL = 2;
        SYMMETRY_ALL = 6;
        METHOD_NONE = 0;
        FACE_SOUTH = 8;
        CONNECT_TILE = 2;
        CONNECT_NONE = 0;
        FACE_WEST = 16;
        SYMMETRY_NONE = 1;
        METHOD_REPEAT = 5;
        METHOD_FIXED = 7;
        FACE_ALL = 63;
        METHOD_RANDOM = 4;
        METHOD_VERTICAL = 6;
        SYMMETRY_OPPOSITE = 2;
        SYMMETRY_UNKNOWN = 128;
        METHOD_VERTICAL_HORIZONTAL = 9;
        METHOD_CTM = 1;
        FACE_BOTTOM = 1;
    }
    
    private boolean isValidRepeat(final String llllllllllllllIIllIllIIlIIIllIlI) {
        if (this.tiles == null) {
            Config.warn(String.valueOf(new StringBuilder("Tiles not defined: ").append(llllllllllllllIIllIllIIlIIIllIlI)));
            return false;
        }
        if (this.width <= 0 || this.width > 16) {
            Config.warn(String.valueOf(new StringBuilder("Invalid width: ").append(llllllllllllllIIllIllIIlIIIllIlI)));
            return false;
        }
        if (this.height <= 0 || this.height > 16) {
            Config.warn(String.valueOf(new StringBuilder("Invalid height: ").append(llllllllllllllIIllIllIIlIIIllIlI)));
            return false;
        }
        if (this.tiles.length != this.width * this.height) {
            Config.warn(String.valueOf(new StringBuilder("Number of tiles does not equal width x height: ").append(llllllllllllllIIllIllIIlIIIllIlI)));
            return false;
        }
        return true;
    }
    
    private MatchBlock[] detectMatchBlocks() {
        final int[] llllllllllllllIIllIllIIlIlllIIll = this.detectMatchBlockIds();
        if (llllllllllllllIIllIllIIlIlllIIll == null) {
            return null;
        }
        final MatchBlock[] llllllllllllllIIllIllIIlIlllIIlI = new MatchBlock[llllllllllllllIIllIllIIlIlllIIll.length];
        for (int llllllllllllllIIllIllIIlIlllIIIl = 0; llllllllllllllIIllIllIIlIlllIIIl < llllllllllllllIIllIllIIlIlllIIlI.length; ++llllllllllllllIIllIllIIlIlllIIIl) {
            llllllllllllllIIllIllIIlIlllIIlI[llllllllllllllIIllIllIIlIlllIIIl] = new MatchBlock(llllllllllllllIIllIllIIlIlllIIll[llllllllllllllIIllIllIIlIlllIIIl]);
        }
        return llllllllllllllIIllIllIIlIlllIIlI;
    }
    
    private boolean isValidCtm(final String llllllllllllllIIllIllIIlIlIIlIII) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("0-11 16-27 32-43 48-58");
        }
        if (this.tiles.length < 47) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be at least 47: ").append(llllllllllllllIIllIllIIlIlIIlIII)));
            return false;
        }
        return true;
    }
    
    private static int parseFaces(final String llllllllllllllIIllIllIIllIlIIIlI) {
        if (llllllllllllllIIllIllIIllIlIIIlI == null) {
            return 63;
        }
        final String[] llllllllllllllIIllIllIIllIlIIIIl = Config.tokenize(llllllllllllllIIllIllIIllIlIIIlI, " ,");
        int llllllllllllllIIllIllIIllIlIIIII = 0;
        for (int llllllllllllllIIllIllIIllIIlllll = 0; llllllllllllllIIllIllIIllIIlllll < llllllllllllllIIllIllIIllIlIIIIl.length; ++llllllllllllllIIllIllIIllIIlllll) {
            final String llllllllllllllIIllIllIIllIIllllI = llllllllllllllIIllIllIIllIlIIIIl[llllllllllllllIIllIllIIllIIlllll];
            final int llllllllllllllIIllIllIIllIIlllIl = parseFace(llllllllllllllIIllIllIIllIIllllI);
            llllllllllllllIIllIllIIllIlIIIII |= llllllllllllllIIllIllIIllIIlllIl;
        }
        return llllllllllllllIIllIllIIllIlIIIII;
    }
    
    public boolean matchesBiome(final BiomeGenBase llllllllllllllIIllIllIIIlIlllIlI) {
        return Matches.biome(llllllllllllllIIllIllIIIlIlllIlI, this.biomes);
    }
    
    private static String parseName(final String llllllllllllllIIllIllIIlllIlIlll) {
        String llllllllllllllIIllIllIIlllIllIlI = llllllllllllllIIllIllIIlllIlIlll;
        final int llllllllllllllIIllIllIIlllIllIIl = llllllllllllllIIllIllIIlllIlIlll.lastIndexOf(47);
        if (llllllllllllllIIllIllIIlllIllIIl >= 0) {
            llllllllllllllIIllIllIIlllIllIlI = llllllllllllllIIllIllIIlllIlIlll.substring(llllllllllllllIIllIllIIlllIllIIl + 1);
        }
        final int llllllllllllllIIllIllIIlllIllIII = llllllllllllllIIllIllIIlllIllIlI.lastIndexOf(46);
        if (llllllllllllllIIllIllIIlllIllIII >= 0) {
            llllllllllllllIIllIllIIlllIllIlI = llllllllllllllIIllIllIIlllIllIlI.substring(0, llllllllllllllIIllIllIIlllIllIII);
        }
        return llllllllllllllIIllIllIIlllIllIlI;
    }
    
    private static int parseSymmetry(final String llllllllllllllIIllIllIIllIlIlIIl) {
        if (llllllllllllllIIllIllIIllIlIlIIl == null) {
            return 1;
        }
        if (llllllllllllllIIllIllIIllIlIlIIl.equals("opposite")) {
            return 2;
        }
        if (llllllllllllllIIllIllIIllIlIlIIl.equals("all")) {
            return 6;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown symmetry: ").append(llllllllllllllIIllIllIIllIlIlIIl)));
        return 1;
    }
    
    private boolean isValidRandom(final String llllllllllllllIIllIllIIlIIlIlIIl) {
        if (this.tiles != null && this.tiles.length > 0) {
            if (this.weights != null) {
                if (this.weights.length > this.tiles.length) {
                    Config.warn(String.valueOf(new StringBuilder("More weights defined than tiles, trimming weights: ").append(llllllllllllllIIllIllIIlIIlIlIIl)));
                    final int[] llllllllllllllIIllIllIIlIIlIlIII = new int[this.tiles.length];
                    System.arraycopy(this.weights, 0, llllllllllllllIIllIllIIlIIlIlIII, 0, llllllllllllllIIllIllIIlIIlIlIII.length);
                    this.weights = llllllllllllllIIllIllIIlIIlIlIII;
                }
                if (this.weights.length < this.tiles.length) {
                    Config.warn(String.valueOf(new StringBuilder("Less weights defined than tiles, expanding weights: ").append(llllllllllllllIIllIllIIlIIlIlIIl)));
                    final int[] llllllllllllllIIllIllIIlIIlIIlll = new int[this.tiles.length];
                    System.arraycopy(this.weights, 0, llllllllllllllIIllIllIIlIIlIIlll, 0, this.weights.length);
                    final int llllllllllllllIIllIllIIlIIlIIllI = MathUtils.getAverage(this.weights);
                    for (int llllllllllllllIIllIllIIlIIlIIlII = this.weights.length; llllllllllllllIIllIllIIlIIlIIlII < llllllllllllllIIllIllIIlIIlIIlll.length; ++llllllllllllllIIllIllIIlIIlIIlII) {
                        llllllllllllllIIllIllIIlIIlIIlll[llllllllllllllIIllIllIIlIIlIIlII] = llllllllllllllIIllIllIIlIIlIIllI;
                    }
                    this.weights = llllllllllllllIIllIllIIlIIlIIlll;
                }
                this.sumWeights = new int[this.weights.length];
                int llllllllllllllIIllIllIIlIIlIIIll = 0;
                for (int llllllllllllllIIllIllIIlIIlIIlIl = 0; llllllllllllllIIllIllIIlIIlIIlIl < this.weights.length; ++llllllllllllllIIllIllIIlIIlIIlIl) {
                    llllllllllllllIIllIllIIlIIlIIIll += this.weights[llllllllllllllIIllIllIIlIIlIIlIl];
                    this.sumWeights[llllllllllllllIIllIllIIlIIlIIlIl] = llllllllllllllIIllIllIIlIIlIIIll;
                }
                this.sumAllWeights = llllllllllllllIIllIllIIlIIlIIIll;
                if (this.sumAllWeights <= 0) {
                    Config.warn(String.valueOf(new StringBuilder("Invalid sum of all weights: ").append(llllllllllllllIIllIllIIlIIlIIIll)));
                    this.sumAllWeights = 1;
                }
            }
            return true;
        }
        Config.warn(String.valueOf(new StringBuilder("Tiles not defined: ").append(llllllllllllllIIllIllIIlIIlIlIIl)));
        return false;
    }
    
    public boolean matchesIcon(final TextureAtlasSprite llllllllllllllIIllIllIIIllIIIlIl) {
        return Matches.sprite(llllllllllllllIIllIllIIIllIIIlIl, this.matchTileIcons);
    }
    
    private boolean isValidVertical(final String llllllllllllllIIllIllIIlIIllllII) {
        if (this.tiles == null) {
            Config.warn(String.valueOf(new StringBuilder("No tiles defined for vertical: ").append(llllllllllllllIIllIllIIlIIllllII)));
            return false;
        }
        if (this.tiles.length != 4) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be exactly 4: ").append(llllllllllllllIIllIllIIlIIllllII)));
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("CTM name: ").append(this.name).append(", basePath: ").append(this.basePath).append(", matchBlocks: ").append(Config.arrayToString(this.matchBlocks)).append(", matchTiles: ").append(Config.arrayToString(this.matchTiles)));
    }
    
    private boolean isValidFixed(final String llllllllllllllIIllIllIIlIIIlIIlI) {
        if (this.tiles == null) {
            Config.warn(String.valueOf(new StringBuilder("Tiles not defined: ").append(llllllllllllllIIllIllIIlIIIlIIlI)));
            return false;
        }
        if (this.tiles.length != 1) {
            Config.warn("Number of tiles should be 1 for method: fixed.");
            return false;
        }
        return true;
    }
    
    private boolean isValidHorizontal(final String llllllllllllllIIllIllIIlIlIIIIlI) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("12-15");
        }
        if (this.tiles.length != 4) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be exactly 4: ").append(llllllllllllllIIllIllIIlIlIIIIlI)));
            return false;
        }
        return true;
    }
    
    public boolean matchesBlock(final int llllllllllllllIIllIllIIIllIIlIlI, final int llllllllllllllIIllIllIIIllIIllII) {
        return Matches.block(llllllllllllllIIllIllIIIllIIlIlI, llllllllllllllIIllIllIIIllIIllII, this.matchBlocks) && Matches.metadata(llllllllllllllIIllIllIIIllIIllII, this.metadatas);
    }
    
    private static int parseMethod(final String llllllllllllllIIllIllIIllIIIIIlI) {
        if (llllllllllllllIIllIllIIllIIIIIlI == null) {
            return 1;
        }
        if (llllllllllllllIIllIllIIllIIIIIlI.equals("ctm") || llllllllllllllIIllIllIIllIIIIIlI.equals("glass")) {
            return 1;
        }
        if (llllllllllllllIIllIllIIllIIIIIlI.equals("horizontal") || llllllllllllllIIllIllIIllIIIIIlI.equals("bookshelf")) {
            return 2;
        }
        if (llllllllllllllIIllIllIIllIIIIIlI.equals("vertical")) {
            return 6;
        }
        if (llllllllllllllIIllIllIIllIIIIIlI.equals("top")) {
            return 3;
        }
        if (llllllllllllllIIllIllIIllIIIIIlI.equals("random")) {
            return 4;
        }
        if (llllllllllllllIIllIllIIllIIIIIlI.equals("repeat")) {
            return 5;
        }
        if (llllllllllllllIIllIllIIllIIIIIlI.equals("fixed")) {
            return 7;
        }
        if (llllllllllllllIIllIllIIllIIIIIlI.equals("horizontal+vertical") || llllllllllllllIIllIllIIllIIIIIlI.equals("h+v")) {
            return 8;
        }
        if (!llllllllllllllIIllIllIIllIIIIIlI.equals("vertical+horizontal") && !llllllllllllllIIllIllIIllIIIIIlI.equals("v+h")) {
            Config.warn(String.valueOf(new StringBuilder("Unknown method: ").append(llllllllllllllIIllIllIIllIIIIIlI)));
            return 0;
        }
        return 9;
    }
    
    private int detectConnect() {
        return (this.matchBlocks != null) ? 1 : ((this.matchTiles != null) ? 2 : 128);
    }
    
    public boolean isValid(final String llllllllllllllIIllIllIIlIllllllI) {
        if (this.name == null || this.name.length() <= 0) {
            Config.warn(String.valueOf(new StringBuilder("No name found: ").append(llllllllllllllIIllIllIIlIllllllI)));
            return false;
        }
        if (this.basePath == null) {
            Config.warn(String.valueOf(new StringBuilder("No base path found: ").append(llllllllllllllIIllIllIIlIllllllI)));
            return false;
        }
        if (this.matchBlocks == null) {
            this.matchBlocks = this.detectMatchBlocks();
        }
        if (this.matchTiles == null && this.matchBlocks == null) {
            this.matchTiles = this.detectMatchTiles();
        }
        if (this.matchBlocks == null && this.matchTiles == null) {
            Config.warn(String.valueOf(new StringBuilder("No matchBlocks or matchTiles specified: ").append(llllllllllllllIIllIllIIlIllllllI)));
            return false;
        }
        if (this.method == 0) {
            Config.warn(String.valueOf(new StringBuilder("No method: ").append(llllllllllllllIIllIllIIlIllllllI)));
            return false;
        }
        if (this.tiles == null || this.tiles.length <= 0) {
            Config.warn(String.valueOf(new StringBuilder("No tiles specified: ").append(llllllllllllllIIllIllIIlIllllllI)));
            return false;
        }
        if (this.connect == 0) {
            this.connect = this.detectConnect();
        }
        if (this.connect == 128) {
            Config.warn(String.valueOf(new StringBuilder("Invalid connect in: ").append(llllllllllllllIIllIllIIlIllllllI)));
            return false;
        }
        if (this.renderPass > 0) {
            Config.warn(String.valueOf(new StringBuilder("Render pass not supported: ").append(this.renderPass)));
            return false;
        }
        if ((this.faces & 0x80) != 0x0) {
            Config.warn(String.valueOf(new StringBuilder("Invalid faces in: ").append(llllllllllllllIIllIllIIlIllllllI)));
            return false;
        }
        if ((this.symmetry & 0x80) != 0x0) {
            Config.warn(String.valueOf(new StringBuilder("Invalid symmetry in: ").append(llllllllllllllIIllIllIIlIllllllI)));
            return false;
        }
        switch (this.method) {
            case 1: {
                return this.isValidCtm(llllllllllllllIIllIllIIlIllllllI);
            }
            case 2: {
                return this.isValidHorizontal(llllllllllllllIIllIllIIlIllllllI);
            }
            case 3: {
                return this.isValidTop(llllllllllllllIIllIllIIlIllllllI);
            }
            case 4: {
                return this.isValidRandom(llllllllllllllIIllIllIIlIllllllI);
            }
            case 5: {
                return this.isValidRepeat(llllllllllllllIIllIllIIlIllllllI);
            }
            case 6: {
                return this.isValidVertical(llllllllllllllIIllIllIIlIllllllI);
            }
            case 7: {
                return this.isValidFixed(llllllllllllllIIllIllIIlIllllllI);
            }
            case 8: {
                return this.isValidHorizontalVertical(llllllllllllllIIllIllIIlIllllllI);
            }
            case 9: {
                return this.isValidVerticalHorizontal(llllllllllllllIIllIllIIlIllllllI);
            }
            default: {
                Config.warn(String.valueOf(new StringBuilder("Unknown method: ").append(llllllllllllllIIllIllIIlIllllllI)));
                return false;
            }
        }
    }
    
    public void updateIcons(final TextureMap llllllllllllllIIllIllIIlIIIIIllI) {
        if (this.matchTiles != null) {
            this.matchTileIcons = registerIcons(this.matchTiles, llllllllllllllIIllIllIIlIIIIIllI);
        }
        if (this.tiles != null) {
            this.tileIcons = registerIcons(this.tiles, llllllllllllllIIllIllIIlIIIIIllI);
        }
    }
    
    private String[] parseMatchTiles(final String llllllllllllllIIllIllIIllllIIIll) {
        if (llllllllllllllIIllIllIIllllIIIll == null) {
            return null;
        }
        final String[] llllllllllllllIIllIllIIllllIIlll = Config.tokenize(llllllllllllllIIllIllIIllllIIIll, " ");
        for (int llllllllllllllIIllIllIIllllIIllI = 0; llllllllllllllIIllIllIIllllIIllI < llllllllllllllIIllIllIIllllIIlll.length; ++llllllllllllllIIllIllIIllllIIllI) {
            String llllllllllllllIIllIllIIllllIIlIl = llllllllllllllIIllIllIIllllIIlll[llllllllllllllIIllIllIIllllIIllI];
            if (llllllllllllllIIllIllIIllllIIlIl.endsWith(".png")) {
                llllllllllllllIIllIllIIllllIIlIl = llllllllllllllIIllIllIIllllIIlIl.substring(0, llllllllllllllIIllIllIIllllIIlIl.length() - 4);
            }
            llllllllllllllIIllIllIIllllIIlIl = TextureUtils.fixResourcePath(llllllllllllllIIllIllIIllllIIlIl, this.basePath);
            llllllllllllllIIllIllIIllllIIlll[llllllllllllllIIllIllIIllllIIllI] = llllllllllllllIIllIllIIllllIIlIl;
        }
        return llllllllllllllIIllIllIIllllIIlll;
    }
    
    public ConnectedProperties(final Properties llllllllllllllIIllIllIIlllllIlIl, final String llllllllllllllIIllIllIIlllllIlII) {
        this.name = null;
        this.basePath = null;
        this.matchBlocks = null;
        this.metadatas = null;
        this.matchTiles = null;
        this.method = 0;
        this.tiles = null;
        this.connect = 0;
        this.faces = 63;
        this.biomes = null;
        this.minHeight = 0;
        this.maxHeight = 1024;
        this.renderPass = 0;
        this.innerSeams = false;
        this.width = 0;
        this.height = 0;
        this.weights = null;
        this.symmetry = 1;
        this.sumWeights = null;
        this.sumAllWeights = 1;
        this.matchTileIcons = null;
        this.tileIcons = null;
        final ConnectedParser llllllllllllllIIllIllIIlllllIIll = new ConnectedParser("ConnectedTextures");
        this.name = llllllllllllllIIllIllIIlllllIIll.parseName(llllllllllllllIIllIllIIlllllIlII);
        this.basePath = llllllllllllllIIllIllIIlllllIIll.parseBasePath(llllllllllllllIIllIllIIlllllIlII);
        this.matchBlocks = llllllllllllllIIllIllIIlllllIIll.parseMatchBlocks(llllllllllllllIIllIllIIlllllIlIl.getProperty("matchBlocks"));
        this.metadatas = llllllllllllllIIllIllIIlllllIIll.parseIntList(llllllllllllllIIllIllIIlllllIlIl.getProperty("metadata"));
        this.matchTiles = this.parseMatchTiles(llllllllllllllIIllIllIIlllllIlIl.getProperty("matchTiles"));
        this.method = parseMethod(llllllllllllllIIllIllIIlllllIlIl.getProperty("method"));
        this.tiles = this.parseTileNames(llllllllllllllIIllIllIIlllllIlIl.getProperty("tiles"));
        this.connect = parseConnect(llllllllllllllIIllIllIIlllllIlIl.getProperty("connect"));
        this.faces = parseFaces(llllllllllllllIIllIllIIlllllIlIl.getProperty("faces"));
        this.biomes = llllllllllllllIIllIllIIlllllIIll.parseBiomes(llllllllllllllIIllIllIIlllllIlIl.getProperty("biomes"));
        this.minHeight = llllllllllllllIIllIllIIlllllIIll.parseInt(llllllllllllllIIllIllIIlllllIlIl.getProperty("minHeight"), -1);
        this.maxHeight = llllllllllllllIIllIllIIlllllIIll.parseInt(llllllllllllllIIllIllIIlllllIlIl.getProperty("maxHeight"), 1024);
        this.renderPass = llllllllllllllIIllIllIIlllllIIll.parseInt(llllllllllllllIIllIllIIlllllIlIl.getProperty("renderPass"));
        this.innerSeams = ConnectedParser.parseBoolean(llllllllllllllIIllIllIIlllllIlIl.getProperty("innerSeams"));
        this.width = llllllllllllllIIllIllIIlllllIIll.parseInt(llllllllllllllIIllIllIIlllllIlIl.getProperty("width"));
        this.height = llllllllllllllIIllIllIIlllllIIll.parseInt(llllllllllllllIIllIllIIlllllIlIl.getProperty("height"));
        this.weights = llllllllllllllIIllIllIIlllllIIll.parseIntList(llllllllllllllIIllIllIIlllllIlIl.getProperty("weights"));
        this.symmetry = parseSymmetry(llllllllllllllIIllIllIIlllllIlIl.getProperty("symmetry"));
    }
    
    private boolean isValidTop(final String llllllllllllllIIllIllIIlIIIIlllI) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("66");
        }
        if (this.tiles.length != 1) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be exactly 1: ").append(llllllllllllllIIllIllIIlIIIIlllI)));
            return false;
        }
        return true;
    }
    
    private static TextureAtlasSprite getIcon(final String llllllllllllllIIllIllIIlIlIlIIII) {
        final TextureMap llllllllllllllIIllIllIIlIlIlIIlI = Minecraft.getMinecraft().getTextureMapBlocks();
        TextureAtlasSprite llllllllllllllIIllIllIIlIlIlIIIl = llllllllllllllIIllIllIIlIlIlIIlI.getSpriteSafe(llllllllllllllIIllIllIIlIlIlIIII);
        if (llllllllllllllIIllIllIIlIlIlIIIl != null) {
            return llllllllllllllIIllIllIIlIlIlIIIl;
        }
        llllllllllllllIIllIllIIlIlIlIIIl = llllllllllllllIIllIllIIlIlIlIIlI.getSpriteSafe(String.valueOf(new StringBuilder("blocks/").append(llllllllllllllIIllIllIIlIlIlIIII)));
        return llllllllllllllIIllIllIIlIlIlIIIl;
    }
    
    public int getMetadataMax() {
        final byte llllllllllllllIIllIllIIIlIllIIll = -1;
        int llllllllllllllIIllIllIIIlIllIIlI = this.getMax(this.metadatas, llllllllllllllIIllIllIIIlIllIIll);
        if (this.matchBlocks != null) {
            for (int llllllllllllllIIllIllIIIlIllIIIl = 0; llllllllllllllIIllIllIIIlIllIIIl < this.matchBlocks.length; ++llllllllllllllIIllIllIIIlIllIIIl) {
                final MatchBlock llllllllllllllIIllIllIIIlIllIIII = this.matchBlocks[llllllllllllllIIllIllIIIlIllIIIl];
                llllllllllllllIIllIllIIIlIllIIlI = this.getMax(llllllllllllllIIllIllIIIlIllIIII.getMetadatas(), llllllllllllllIIllIllIIIlIllIIlI);
            }
        }
        return llllllllllllllIIllIllIIIlIllIIlI;
    }
    
    private boolean isValidVerticalHorizontal(final String llllllllllllllIIllIllIIlIIllIIlI) {
        if (this.tiles == null) {
            Config.warn(String.valueOf(new StringBuilder("No tiles defined for vertical+horizontal: ").append(llllllllllllllIIllIllIIlIIllIIlI)));
            return false;
        }
        if (this.tiles.length != 7) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be exactly 7: ").append(llllllllllllllIIllIllIIlIIllIIlI)));
            return false;
        }
        return true;
    }
    
    private int[] detectMatchBlockIds() {
        if (!this.name.startsWith("block")) {
            return null;
        }
        int llllllllllllllIIllIllIIlIllIIlIl;
        int llllllllllllllIIllIllIIlIllIIllI;
        for (llllllllllllllIIllIllIIlIllIIllI = (llllllllllllllIIllIllIIlIllIIlIl = "block".length()); llllllllllllllIIllIllIIlIllIIlIl < this.name.length(); ++llllllllllllllIIllIllIIlIllIIlIl) {
            final char llllllllllllllIIllIllIIlIllIIlII = this.name.charAt(llllllllllllllIIllIllIIlIllIIlIl);
            if (llllllllllllllIIllIllIIlIllIIlII < '0') {
                break;
            }
            if (llllllllllllllIIllIllIIlIllIIlII > '9') {
                break;
            }
        }
        if (llllllllllllllIIllIllIIlIllIIlIl == llllllllllllllIIllIllIIlIllIIllI) {
            return null;
        }
        final String llllllllllllllIIllIllIIlIllIIIll = this.name.substring(llllllllllllllIIllIllIIlIllIIllI, llllllllllllllIIllIllIIlIllIIlIl);
        final int llllllllllllllIIllIllIIlIllIIIlI = Config.parseInt(llllllllllllllIIllIllIIlIllIIIll, -1);
        return (int[])((llllllllllllllIIllIllIIlIllIIIlI < 0) ? null : new int[] { llllllllllllllIIllIllIIlIllIIIlI });
    }
    
    private static int parseFace(String llllllllllllllIIllIllIIllIIlIlII) {
        llllllllllllllIIllIllIIllIIlIlII = llllllllllllllIIllIllIIllIIlIlII.toLowerCase();
        if (llllllllllllllIIllIllIIllIIlIlII.equals("bottom") || llllllllllllllIIllIllIIllIIlIlII.equals("down")) {
            return 1;
        }
        if (llllllllllllllIIllIllIIllIIlIlII.equals("top") || llllllllllllllIIllIllIIllIIlIlII.equals("up")) {
            return 2;
        }
        if (llllllllllllllIIllIllIIllIIlIlII.equals("north")) {
            return 4;
        }
        if (llllllllllllllIIllIllIIllIIlIlII.equals("south")) {
            return 8;
        }
        if (llllllllllllllIIllIllIIllIIlIlII.equals("east")) {
            return 32;
        }
        if (llllllllllllllIIllIllIIllIIlIlII.equals("west")) {
            return 16;
        }
        if (llllllllllllllIIllIllIIllIIlIlII.equals("sides")) {
            return 60;
        }
        if (llllllllllllllIIllIllIIllIIlIlII.equals("all")) {
            return 63;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown face: ").append(llllllllllllllIIllIllIIllIIlIlII)));
        return 128;
    }
    
    private static String parseBasePath(final String llllllllllllllIIllIllIIlllIlIIIl) {
        final int llllllllllllllIIllIllIIlllIlIIII = llllllllllllllIIllIllIIlllIlIIIl.lastIndexOf(47);
        return (llllllllllllllIIllIllIIlllIlIIII < 0) ? "" : llllllllllllllIIllIllIIlllIlIIIl.substring(0, llllllllllllllIIllIllIIlllIlIIII);
    }
    
    private String[] detectMatchTiles() {
        final TextureAtlasSprite llllllllllllllIIllIllIIlIlIllIIl = getIcon(this.name);
        return (String[])((llllllllllllllIIllIllIIlIlIllIIl == null) ? null : new String[] { this.name });
    }
    
    public boolean matchesBlockId(final int llllllllllllllIIllIllIIIllIlIlII) {
        return Matches.blockId(llllllllllllllIIllIllIIIllIlIlII, this.matchBlocks);
    }
    
    private static TextureAtlasSprite[] registerIcons(final String[] llllllllllllllIIllIllIIIlllIIllI, final TextureMap llllllllllllllIIllIllIIIlllIIlIl) {
        if (llllllllllllllIIllIllIIIlllIIllI == null) {
            return null;
        }
        final ArrayList llllllllllllllIIllIllIIIllllIlII = new ArrayList();
        for (int llllllllllllllIIllIllIIIllllIIll = 0; llllllllllllllIIllIllIIIllllIIll < llllllllllllllIIllIllIIIlllIIllI.length; ++llllllllllllllIIllIllIIIllllIIll) {
            final String llllllllllllllIIllIllIIIllllIIlI = llllllllllllllIIllIllIIIlllIIllI[llllllllllllllIIllIllIIIllllIIll];
            final ResourceLocation llllllllllllllIIllIllIIIllllIIIl = new ResourceLocation(llllllllllllllIIllIllIIIllllIIlI);
            final String llllllllllllllIIllIllIIIllllIIII = llllllllllllllIIllIllIIIllllIIIl.getResourceDomain();
            String llllllllllllllIIllIllIIIlllIllll = llllllllllllllIIllIllIIIllllIIIl.getResourcePath();
            if (!llllllllllllllIIllIllIIIlllIllll.contains("/")) {
                llllllllllllllIIllIllIIIlllIllll = String.valueOf(new StringBuilder("textures/blocks/").append(llllllllllllllIIllIllIIIlllIllll));
            }
            final String llllllllllllllIIllIllIIIlllIlllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIllIIIlllIllll)).append(".png"));
            final ResourceLocation llllllllllllllIIllIllIIIlllIllIl = new ResourceLocation(llllllllllllllIIllIllIIIllllIIII, llllllllllllllIIllIllIIIlllIlllI);
            final boolean llllllllllllllIIllIllIIIlllIllII = Config.hasResource(llllllllllllllIIllIllIIIlllIllIl);
            if (!llllllllllllllIIllIllIIIlllIllII) {
                Config.warn(String.valueOf(new StringBuilder("File not found: ").append(llllllllllllllIIllIllIIIlllIlllI)));
            }
            final String llllllllllllllIIllIllIIIlllIlIll = "textures/";
            String llllllllllllllIIllIllIIIlllIlIlI = llllllllllllllIIllIllIIIlllIllll;
            if (llllllllllllllIIllIllIIIlllIllll.startsWith(llllllllllllllIIllIllIIIlllIlIll)) {
                llllllllllllllIIllIllIIIlllIlIlI = llllllllllllllIIllIllIIIlllIllll.substring(llllllllllllllIIllIllIIIlllIlIll.length());
            }
            final ResourceLocation llllllllllllllIIllIllIIIlllIlIIl = new ResourceLocation(llllllllllllllIIllIllIIIllllIIII, llllllllllllllIIllIllIIIlllIlIlI);
            final TextureAtlasSprite llllllllllllllIIllIllIIIlllIlIII = llllllllllllllIIllIllIIIlllIIlIl.func_174942_a(llllllllllllllIIllIllIIIlllIlIIl);
            llllllllllllllIIllIllIIIllllIlII.add(llllllllllllllIIllIllIIIlllIlIII);
        }
        final TextureAtlasSprite[] llllllllllllllIIllIllIIIlllIIlll = llllllllllllllIIllIllIIIllllIlII.toArray(new TextureAtlasSprite[llllllllllllllIIllIllIIIllllIlII.size()]);
        return llllllllllllllIIllIllIIIlllIIlll;
    }
    
    private boolean isValidHorizontalVertical(final String llllllllllllllIIllIllIIlIIlllIII) {
        if (this.tiles == null) {
            Config.warn(String.valueOf(new StringBuilder("No tiles defined for horizontal+vertical: ").append(llllllllllllllIIllIllIIlIIlllIII)));
            return false;
        }
        if (this.tiles.length != 7) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be exactly 7: ").append(llllllllllllllIIllIllIIlIIlllIII)));
            return false;
        }
        return true;
    }
    
    private int getMax(final int[] llllllllllllllIIllIllIIIlIlIIIIl, int llllllllllllllIIllIllIIIlIlIIIII) {
        if (llllllllllllllIIllIllIIIlIlIIIIl == null) {
            return llllllllllllllIIllIllIIIlIlIIIII;
        }
        for (int llllllllllllllIIllIllIIIlIlIIIll = 0; llllllllllllllIIllIllIIIlIlIIIll < llllllllllllllIIllIllIIIlIlIIIIl.length; ++llllllllllllllIIllIllIIIlIlIIIll) {
            final int llllllllllllllIIllIllIIIlIlIIIlI = llllllllllllllIIllIllIIIlIlIIIIl[llllllllllllllIIllIllIIIlIlIIIll];
            if (llllllllllllllIIllIllIIIlIlIIIlI > llllllllllllllIIllIllIIIlIlIIIII) {
                llllllllllllllIIllIllIIIlIlIIIII = llllllllllllllIIllIllIIIlIlIIIlI;
            }
        }
        return llllllllllllllIIllIllIIIlIlIIIII;
    }
    
    public static IProperty getProperty(final String llllllllllllllIIllIllIIllIIIllII, final Collection llllllllllllllIIllIllIIllIIIlIll) {
        for (final IProperty llllllllllllllIIllIllIIllIIIlIIl : llllllllllllllIIllIllIIllIIIlIll) {
            if (llllllllllllllIIllIllIIllIIIllII.equals(llllllllllllllIIllIllIIllIIIlIIl.getName())) {
                return llllllllllllllIIllIllIIllIIIlIIl;
            }
        }
        return null;
    }
    
    private static int parseConnect(final String llllllllllllllIIllIllIIllIIlIIlI) {
        if (llllllllllllllIIllIllIIllIIlIIlI == null) {
            return 0;
        }
        if (llllllllllllllIIllIllIIllIIlIIlI.equals("block")) {
            return 1;
        }
        if (llllllllllllllIIllIllIIllIIlIIlI.equals("tile")) {
            return 2;
        }
        if (llllllllllllllIIllIllIIllIIlIIlI.equals("material")) {
            return 3;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown connect: ").append(llllllllllllllIIllIllIIllIIlIIlI)));
        return 128;
    }
    
    private String[] parseTileNames(final String llllllllllllllIIllIllIIlllIIIIlI) {
        if (llllllllllllllIIllIllIIlllIIIIlI == null) {
            return null;
        }
        final ArrayList llllllllllllllIIllIllIIlllIIIIIl = new ArrayList();
        final String[] llllllllllllllIIllIllIIlllIIIIII = Config.tokenize(llllllllllllllIIllIllIIlllIIIIlI, " ,");
        for (int llllllllllllllIIllIllIIllIllllll = 0; llllllllllllllIIllIllIIllIllllll < llllllllllllllIIllIllIIlllIIIIII.length; ++llllllllllllllIIllIllIIllIllllll) {
            final String llllllllllllllIIllIllIIllIlllllI = llllllllllllllIIllIllIIlllIIIIII[llllllllllllllIIllIllIIllIllllll];
            if (llllllllllllllIIllIllIIllIlllllI.contains("-")) {
                final String[] llllllllllllllIIllIllIIllIllllIl = Config.tokenize(llllllllllllllIIllIllIIllIlllllI, "-");
                if (llllllllllllllIIllIllIIllIllllIl.length == 2) {
                    final int llllllllllllllIIllIllIIllIllllII = Config.parseInt(llllllllllllllIIllIllIIllIllllIl[0], -1);
                    final int llllllllllllllIIllIllIIllIlllIll = Config.parseInt(llllllllllllllIIllIllIIllIllllIl[1], -1);
                    if (llllllllllllllIIllIllIIllIllllII >= 0 && llllllllllllllIIllIllIIllIlllIll >= 0) {
                        if (llllllllllllllIIllIllIIllIllllII <= llllllllllllllIIllIllIIllIlllIll) {
                            for (int llllllllllllllIIllIllIIllIlllIlI = llllllllllllllIIllIllIIllIllllII; llllllllllllllIIllIllIIllIlllIlI <= llllllllllllllIIllIllIIllIlllIll; ++llllllllllllllIIllIllIIllIlllIlI) {
                                llllllllllllllIIllIllIIlllIIIIIl.add(String.valueOf(llllllllllllllIIllIllIIllIlllIlI));
                            }
                            continue;
                        }
                        Config.warn(String.valueOf(new StringBuilder("Invalid interval: ").append(llllllllllllllIIllIllIIllIlllllI).append(", when parsing: ").append(llllllllllllllIIllIllIIlllIIIIlI)));
                        continue;
                    }
                }
            }
            llllllllllllllIIllIllIIlllIIIIIl.add(llllllllllllllIIllIllIIllIlllllI);
        }
        final String[] llllllllllllllIIllIllIIllIlllIIl = llllllllllllllIIllIllIIlllIIIIIl.toArray(new String[llllllllllllllIIllIllIIlllIIIIIl.size()]);
        for (int llllllllllllllIIllIllIIllIlllIII = 0; llllllllllllllIIllIllIIllIlllIII < llllllllllllllIIllIllIIllIlllIIl.length; ++llllllllllllllIIllIllIIllIlllIII) {
            String llllllllllllllIIllIllIIllIllIlll = llllllllllllllIIllIllIIllIlllIIl[llllllllllllllIIllIllIIllIlllIII];
            llllllllllllllIIllIllIIllIllIlll = TextureUtils.fixResourcePath(llllllllllllllIIllIllIIllIllIlll, this.basePath);
            if (!llllllllllllllIIllIllIIllIllIlll.startsWith(this.basePath) && !llllllllllllllIIllIllIIllIllIlll.startsWith("textures/") && !llllllllllllllIIllIllIIllIllIlll.startsWith("mcpatcher/")) {
                llllllllllllllIIllIllIIllIllIlll = String.valueOf(new StringBuilder(String.valueOf(this.basePath)).append("/").append(llllllllllllllIIllIllIIllIllIlll));
            }
            if (llllllllllllllIIllIllIIllIllIlll.endsWith(".png")) {
                llllllllllllllIIllIllIIllIllIlll = llllllllllllllIIllIllIIllIllIlll.substring(0, llllllllllllllIIllIllIIllIllIlll.length() - 4);
            }
            final String llllllllllllllIIllIllIIllIllIllI = "textures/blocks/";
            if (llllllllllllllIIllIllIIllIllIlll.startsWith(llllllllllllllIIllIllIIllIllIllI)) {
                llllllllllllllIIllIllIIllIllIlll = llllllllllllllIIllIllIIllIllIlll.substring(llllllllllllllIIllIllIIllIllIllI.length());
            }
            if (llllllllllllllIIllIllIIllIllIlll.startsWith("/")) {
                llllllllllllllIIllIllIIllIllIlll = llllllllllllllIIllIllIIllIllIlll.substring(1);
            }
            llllllllllllllIIllIllIIllIlllIIl[llllllllllllllIIllIllIIllIlllIII] = llllllllllllllIIllIllIIllIllIlll;
        }
        return llllllllllllllIIllIllIIllIlllIIl;
    }
}
