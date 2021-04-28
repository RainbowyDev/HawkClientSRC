package net.minecraft.block.material;

public class MapColor
{
    public final /* synthetic */ int colorIndex;
    public static final /* synthetic */ MapColor[] mapColorArray;
    public /* synthetic */ int colorValue;
    
    public int func_151643_b(final int llllllllllllllllIllIIllIlIllllII) {
        short llllllllllllllllIllIIllIllIIIIIl = 220;
        if (llllllllllllllllIllIIllIlIllllII == 3) {
            llllllllllllllllIllIIllIllIIIIIl = 135;
        }
        if (llllllllllllllllIllIIllIlIllllII == 2) {
            llllllllllllllllIllIIllIllIIIIIl = 255;
        }
        if (llllllllllllllllIllIIllIlIllllII == 1) {
            llllllllllllllllIllIIllIllIIIIIl = 220;
        }
        if (llllllllllllllllIllIIllIlIllllII == 0) {
            llllllllllllllllIllIIllIllIIIIIl = 180;
        }
        final int llllllllllllllllIllIIllIllIIIIII = (this.colorValue >> 16 & 0xFF) * llllllllllllllllIllIIllIllIIIIIl / 255;
        final int llllllllllllllllIllIIllIlIllllll = (this.colorValue >> 8 & 0xFF) * llllllllllllllllIllIIllIllIIIIIl / 255;
        final int llllllllllllllllIllIIllIlIlllllI = (this.colorValue & 0xFF) * llllllllllllllllIllIIllIllIIIIIl / 255;
        return 0xFF000000 | llllllllllllllllIllIIllIllIIIIII << 16 | llllllllllllllllIllIIllIlIllllll << 8 | llllllllllllllllIllIIllIlIlllllI;
    }
    
    private MapColor(final int llllllllllllllllIllIIllIllIIlllI, final int llllllllllllllllIllIIllIllIIllIl) {
        if (llllllllllllllllIllIIllIllIIlllI >= 0 && llllllllllllllllIllIIllIllIIlllI <= 63) {
            this.colorIndex = llllllllllllllllIllIIllIllIIlllI;
            this.colorValue = llllllllllllllllIllIIllIllIIllIl;
            MapColor.mapColorArray[llllllllllllllllIllIIllIllIIlllI] = this;
            return;
        }
        throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
    }
    
    static {
        __OBFID = "CL_00000544";
        mapColorArray = new MapColor[64];
        airColor = new MapColor(0, 0);
        grassColor = new MapColor(1, 8368696);
        sandColor = new MapColor(2, 16247203);
        clothColor = new MapColor(3, 10987431);
        tntColor = new MapColor(4, 16711680);
        iceColor = new MapColor(5, 10526975);
        ironColor = new MapColor(6, 10987431);
        foliageColor = new MapColor(7, 31744);
        snowColor = new MapColor(8, 16777215);
        clayColor = new MapColor(9, 10791096);
        dirtColor = new MapColor(10, 12020271);
        stoneColor = new MapColor(11, 7368816);
        waterColor = new MapColor(12, 4210943);
        woodColor = new MapColor(13, 6837042);
        quartzColor = new MapColor(14, 16776437);
        adobeColor = new MapColor(15, 14188339);
        magentaColor = new MapColor(16, 11685080);
        lightBlueColor = new MapColor(17, 6724056);
        yellowColor = new MapColor(18, 15066419);
        limeColor = new MapColor(19, 8375321);
        pinkColor = new MapColor(20, 15892389);
        grayColor = new MapColor(21, 5000268);
        silverColor = new MapColor(22, 10066329);
        cyanColor = new MapColor(23, 5013401);
        purpleColor = new MapColor(24, 8339378);
        blueColor = new MapColor(25, 3361970);
        brownColor = new MapColor(26, 6704179);
        greenColor = new MapColor(27, 6717235);
        redColor = new MapColor(28, 10040115);
        blackColor = new MapColor(29, 1644825);
        goldColor = new MapColor(30, 16445005);
        diamondColor = new MapColor(31, 6085589);
        lapisColor = new MapColor(32, 4882687);
        emeraldColor = new MapColor(33, 55610);
        obsidianColor = new MapColor(34, 1381407);
        netherrackColor = new MapColor(35, 7340544);
    }
}
