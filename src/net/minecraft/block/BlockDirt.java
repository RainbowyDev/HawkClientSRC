package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockDirt extends Block
{
    public static final /* synthetic */ PropertyEnum VARIANT;
    public static final /* synthetic */ PropertyBool SNOWY;
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIIlllIllIIllllIll) {
        DirtType lllllllllllllllIIlllIllIIlllllII = (DirtType)lllllllllllllllIIlllIllIIllllIll.getValue(BlockDirt.VARIANT);
        if (lllllllllllllllIIlllIllIIlllllII == DirtType.PODZOL) {
            lllllllllllllllIIlllIllIIlllllII = DirtType.DIRT;
        }
        return lllllllllllllllIIlllIllIIlllllII.getMetadata();
    }
    
    @Override
    public int getDamageValue(final World lllllllllllllllIIlllIllIlIIlIlII, final BlockPos lllllllllllllllIIlllIllIlIIIllll) {
        final IBlockState lllllllllllllllIIlllIllIlIIlIIlI = lllllllllllllllIIlllIllIlIIlIlII.getBlockState(lllllllllllllllIIlllIllIlIIIllll);
        return (lllllllllllllllIIlllIllIlIIlIIlI.getBlock() != this) ? 0 : ((DirtType)lllllllllllllllIIlllIllIlIIlIIlI.getValue(BlockDirt.VARIANT)).getMetadata();
    }
    
    static {
        __OBFID = "CL_00000228";
        VARIANT = PropertyEnum.create("variant", DirtType.class);
        SNOWY = PropertyBool.create("snowy");
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIlllIllIlIIIlIlI) {
        return this.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.byMetadata(lllllllllllllllIIlllIllIlIIIlIlI));
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockDirt.VARIANT, BlockDirt.SNOWY });
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllllIIlllIllIlIlIIlIl, final IBlockAccess lllllllllllllllIIlllIllIlIlIlIII, final BlockPos lllllllllllllllIIlllIllIlIlIIIll) {
        if (lllllllllllllllIIlllIllIlIlIIlIl.getValue(BlockDirt.VARIANT) == DirtType.PODZOL) {
            final Block lllllllllllllllIIlllIllIlIlIIllI = lllllllllllllllIIlllIllIlIlIlIII.getBlockState(lllllllllllllllIIlllIllIlIlIIIll.offsetUp()).getBlock();
            lllllllllllllllIIlllIllIlIlIIlIl = lllllllllllllllIIlllIllIlIlIIlIl.withProperty(BlockDirt.SNOWY, lllllllllllllllIIlllIllIlIlIIllI == Blocks.snow || lllllllllllllllIIlllIllIlIlIIllI == Blocks.snow_layer);
        }
        return lllllllllllllllIIlllIllIlIlIIlIl;
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllIIlllIllIlIIllllI, final CreativeTabs lllllllllllllllIIlllIllIlIIlllIl, final List lllllllllllllllIIlllIllIlIIllIlI) {
        lllllllllllllllIIlllIllIlIIllIlI.add(new ItemStack(this, 1, DirtType.DIRT.getMetadata()));
        lllllllllllllllIIlllIllIlIIllIlI.add(new ItemStack(this, 1, DirtType.COARSE_DIRT.getMetadata()));
        lllllllllllllllIIlllIllIlIIllIlI.add(new ItemStack(this, 1, DirtType.PODZOL.getMetadata()));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIlllIllIlIIIIlIl) {
        return ((DirtType)lllllllllllllllIIlllIllIlIIIIlIl.getValue(BlockDirt.VARIANT)).getMetadata();
    }
    
    protected BlockDirt() {
        super(Material.ground);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockDirt.VARIANT, DirtType.DIRT).withProperty(BlockDirt.SNOWY, false));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public enum DirtType implements IStringSerializable
    {
        private final /* synthetic */ int metadata;
        
        DIRT("DIRT", 0, "DIRT", 0, 0, "dirt", "default"), 
        PODZOL("PODZOL", 2, "PODZOL", 2, 2, "podzol"), 
        COARSE_DIRT("COARSE_DIRT", 1, "COARSE_DIRT", 1, 1, "coarse_dirt", "coarse");
        
        private final /* synthetic */ String unlocalizedName;
        private final /* synthetic */ String name;
        private static final /* synthetic */ DirtType[] METADATA_LOOKUP;
        
        static {
            __OBFID = "CL_00002125";
            METADATA_LOOKUP = new DirtType[values().length];
            for (final DirtType lllllllllllllllIIIlIIlllIlIIIIII : values()) {
                DirtType.METADATA_LOOKUP[lllllllllllllllIIIlIIlllIlIIIIII.getMetadata()] = lllllllllllllllIIIlIIlllIlIIIIII;
            }
        }
        
        public static DirtType byMetadata(int lllllllllllllllIIIlIIlllIIIIlIll) {
            if (lllllllllllllllIIIlIIlllIIIIlIll < 0 || lllllllllllllllIIIlIIlllIIIIlIll >= DirtType.METADATA_LOOKUP.length) {
                lllllllllllllllIIIlIIlllIIIIlIll = 0;
            }
            return DirtType.METADATA_LOOKUP[lllllllllllllllIIIlIIlllIIIIlIll];
        }
        
        private DirtType(final String lllllllllllllllIIIlIIlllIIIllIll, final int lllllllllllllllIIIlIIlllIIIllIlI, final String lllllllllllllllIIIlIIlllIIlIIIIl, final int lllllllllllllllIIIlIIlllIIlIIIII, final int lllllllllllllllIIIlIIlllIIIlllll, final String lllllllllllllllIIIlIIlllIIIllIII, final String lllllllllllllllIIIlIIlllIIIlllIl) {
            this.metadata = lllllllllllllllIIIlIIlllIIIlllll;
            this.name = lllllllllllllllIIIlIIlllIIIllIII;
            this.unlocalizedName = lllllllllllllllIIIlIIlllIIIlllIl;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private DirtType(final String lllllllllllllllIIIlIIlllIIlIlllI, final int lllllllllllllllIIIlIIlllIIlIllIl, final String lllllllllllllllIIIlIIlllIIllIIll, final int lllllllllllllllIIIlIIlllIIlIlIll, final int lllllllllllllllIIIlIIlllIIllIIIl, final String lllllllllllllllIIIlIIlllIIllIIII) {
            this(lllllllllllllllIIIlIIlllIIlIlllI, lllllllllllllllIIIlIIlllIIlIllIl, lllllllllllllllIIIlIIlllIIllIIll, lllllllllllllllIIIlIIlllIIlIlIll, lllllllllllllllIIIlIIlllIIllIIIl, lllllllllllllllIIIlIIlllIIllIIII, lllllllllllllllIIIlIIlllIIllIIII);
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public int getMetadata() {
            return this.metadata;
        }
    }
}
