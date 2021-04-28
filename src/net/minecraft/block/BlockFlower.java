package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.init.*;

public abstract class BlockFlower extends BlockBush
{
    protected /* synthetic */ PropertyEnum field_176496_a;
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { this.func_176494_l() });
    }
    
    @Override
    public void getSubBlocks(final Item lllIIIIIllllI, final CreativeTabs lllIIIIlIIlIl, final List lllIIIIlIIlII) {
        for (final EnumFlowerType lllIIIIlIIIII : EnumFlowerType.func_176966_a(this.func_176495_j())) {
            lllIIIIlIIlII.add(new ItemStack(lllIIIIIllllI, 1, lllIIIIlIIIII.func_176968_b()));
        }
    }
    
    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XZ;
    }
    
    public abstract EnumFlowerColor func_176495_j();
    
    @Override
    public IBlockState getStateFromMeta(final int lllIIIIIlIIll) {
        return this.getDefaultState().withProperty(this.func_176494_l(), EnumFlowerType.func_176967_a(this.func_176495_j(), lllIIIIIlIIll));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllIIIIIIlIlI) {
        return ((EnumFlowerType)lllIIIIIIlIlI.getValue(this.func_176494_l())).func_176968_b();
    }
    
    @Override
    public int damageDropped(final IBlockState lllIIIIllIIIl) {
        return ((EnumFlowerType)lllIIIIllIIIl.getValue(this.func_176494_l())).func_176968_b();
    }
    
    protected BlockFlower() {
        super(Material.plants);
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.func_176494_l(), (this.func_176495_j() == EnumFlowerColor.RED) ? EnumFlowerType.POPPY : EnumFlowerType.DANDELION));
    }
    
    public IProperty func_176494_l() {
        if (this.field_176496_a == null) {
            this.field_176496_a = PropertyEnum.create("type", EnumFlowerType.class, (Predicate)new Predicate() {
                public boolean apply(final Object lllllllllllllllIlIlIlIIlIIlIlIIl) {
                    return this.func_180354_a((EnumFlowerType)lllllllllllllllIlIlIlIIlIIlIlIIl);
                }
                
                static {
                    __OBFID = "CL_00002120";
                }
                
                public boolean func_180354_a(final EnumFlowerType lllllllllllllllIlIlIlIIlIIlIllll) {
                    return lllllllllllllllIlIlIlIIlIIlIllll.func_176964_a() == BlockFlower.this.func_176495_j();
                }
            });
        }
        return this.field_176496_a;
    }
    
    static {
        __OBFID = "CL_00000246";
    }
    
    public enum EnumFlowerType implements IStringSerializable
    {
        private final /* synthetic */ int field_176979_m;
        private final /* synthetic */ String field_176977_o;
        private static final /* synthetic */ EnumFlowerType[][] field_176981_k;
        
        ALLIUM("ALLIUM", 3, "ALLIUM", 3, EnumFlowerColor.RED, 2, "allium"), 
        BLUE_ORCHID("BLUE_ORCHID", 2, "BLUE_ORCHID", 2, EnumFlowerColor.RED, 1, "blue_orchid", "blueOrchid"), 
        DANDELION("DANDELION", 0, "DANDELION", 0, EnumFlowerColor.YELLOW, 0, "dandelion"), 
        RED_TULIP("RED_TULIP", 5, "RED_TULIP", 5, EnumFlowerColor.RED, 4, "red_tulip", "tulipRed");
        
        private final /* synthetic */ EnumFlowerColor field_176978_l;
        
        WHITE_TULIP("WHITE_TULIP", 7, "WHITE_TULIP", 7, EnumFlowerColor.RED, 6, "white_tulip", "tulipWhite");
        
        private final /* synthetic */ String field_176976_n;
        
        HOUSTONIA("HOUSTONIA", 4, "HOUSTONIA", 4, EnumFlowerColor.RED, 3, "houstonia"), 
        POPPY("POPPY", 1, "POPPY", 1, EnumFlowerColor.RED, 0, "poppy"), 
        OXEYE_DAISY("OXEYE_DAISY", 9, "OXEYE_DAISY", 9, EnumFlowerColor.RED, 8, "oxeye_daisy", "oxeyeDaisy"), 
        PINK_TULIP("PINK_TULIP", 8, "PINK_TULIP", 8, EnumFlowerColor.RED, 7, "pink_tulip", "tulipPink"), 
        ORANGE_TULIP("ORANGE_TULIP", 6, "ORANGE_TULIP", 6, EnumFlowerColor.RED, 5, "orange_tulip", "tulipOrange");
        
        public static EnumFlowerType[] func_176966_a(final EnumFlowerColor llllllllllllllIIlllIlIlIIIlIIllI) {
            return EnumFlowerType.field_176981_k[llllllllllllllIIlllIlIlIIIlIIllI.ordinal()];
        }
        
        @Override
        public String getName() {
            return this.field_176976_n;
        }
        
        public static EnumFlowerType func_176967_a(final EnumFlowerColor llllllllllllllIIlllIlIlIIIlIllIl, int llllllllllllllIIlllIlIlIIIlIllII) {
            final EnumFlowerType[] llllllllllllllIIlllIlIlIIIlIlIll = EnumFlowerType.field_176981_k[llllllllllllllIIlllIlIlIIIlIllIl.ordinal()];
            if (llllllllllllllIIlllIlIlIIIlIllII < 0 || llllllllllllllIIlllIlIlIIIlIllII >= llllllllllllllIIlllIlIlIIIlIlIll.length) {
                llllllllllllllIIlllIlIlIIIlIllII = 0;
            }
            return llllllllllllllIIlllIlIlIIIlIlIll[llllllllllllllIIlllIlIlIIIlIllII];
        }
        
        public String func_176963_d() {
            return this.field_176977_o;
        }
        
        private EnumFlowerType(final String llllllllllllllIIlllIlIlIIlIlllII, final int llllllllllllllIIlllIlIlIIlIllIll, final String llllllllllllllIIlllIlIlIIlIllIIl, final int llllllllllllllIIlllIlIlIIlIlIlll, final EnumFlowerColor llllllllllllllIIlllIlIlIIllIIIII, final int llllllllllllllIIlllIlIlIIlIlIIll, final String llllllllllllllIIlllIlIlIIlIlIIlI) {
            this(llllllllllllllIIlllIlIlIIlIlllII, llllllllllllllIIlllIlIlIIlIllIll, llllllllllllllIIlllIlIlIIlIllIIl, llllllllllllllIIlllIlIlIIlIlIlll, llllllllllllllIIlllIlIlIIllIIIII, llllllllllllllIIlllIlIlIIlIlIIll, llllllllllllllIIlllIlIlIIlIlIIlI, llllllllllllllIIlllIlIlIIlIlIIlI);
        }
        
        @Override
        public String toString() {
            return this.field_176976_n;
        }
        
        public int func_176968_b() {
            return this.field_176979_m;
        }
        
        private EnumFlowerType(final String llllllllllllllIIlllIlIlIIIllllII, final int llllllllllllllIIlllIlIlIIIlllIll, final String llllllllllllllIIlllIlIlIIlIIIIll, final int llllllllllllllIIlllIlIlIIlIIIIlI, final EnumFlowerColor llllllllllllllIIlllIlIlIIIlllIlI, final int llllllllllllllIIlllIlIlIIlIIIIII, final String llllllllllllllIIlllIlIlIIIlllIII, final String llllllllllllllIIlllIlIlIIIllIlll) {
            this.field_176978_l = llllllllllllllIIlllIlIlIIIlllIlI;
            this.field_176979_m = llllllllllllllIIlllIlIlIIlIIIIII;
            this.field_176976_n = llllllllllllllIIlllIlIlIIIlllIII;
            this.field_176977_o = llllllllllllllIIlllIlIlIIIllIlll;
        }
        
        public EnumFlowerColor func_176964_a() {
            return this.field_176978_l;
        }
        
        static {
            __OBFID = "CL_00002119";
            field_176981_k = new EnumFlowerType[EnumFlowerColor.values().length][];
            for (final EnumFlowerColor llllllllllllllIIlllIlIlIlIIIIllI : EnumFlowerColor.values()) {
                final Collection llllllllllllllIIlllIlIlIlIIIIlII = Collections2.filter((Collection)Lists.newArrayList((Object[])values()), (Predicate)new Predicate() {
                    private final /* synthetic */ EnumFlowerColor val$var3;
                    
                    static {
                        __OBFID = "CL_00002118";
                    }
                    
                    public boolean apply(final Object llllllllllllllIllIlIlIIlIllIIIlI) {
                        return this.func_180350_a((EnumFlowerType)llllllllllllllIllIlIlIIlIllIIIlI);
                    }
                    
                    public boolean func_180350_a(final EnumFlowerType llllllllllllllIllIlIlIIlIllIIllI) {
                        return llllllllllllllIllIlIlIIlIllIIllI.func_176964_a() == this.val$var3;
                    }
                });
                EnumFlowerType.field_176981_k[llllllllllllllIIlllIlIlIlIIIIllI.ordinal()] = llllllllllllllIIlllIlIlIlIIIIlII.toArray(new EnumFlowerType[llllllllllllllIIlllIlIlIlIIIIlII.size()]);
            }
        }
    }
    
    public enum EnumFlowerColor
    {
        RED("RED", 1, "RED", 1), 
        YELLOW("YELLOW", 0, "YELLOW", 0);
        
        private EnumFlowerColor(final String llllllllllllllIllllIlIlIIlIIIlIl, final int llllllllllllllIllllIlIlIIlIIIlII, final String llllllllllllllIllllIlIlIIlIIlIII, final int llllllllllllllIllllIlIlIIlIIIlll) {
        }
        
        static {
            __OBFID = "CL_00002117";
        }
        
        public BlockFlower func_180346_a() {
            return (this == EnumFlowerColor.YELLOW) ? Blocks.yellow_flower : Blocks.red_flower;
        }
    }
}
