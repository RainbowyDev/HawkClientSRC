package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockHugeMushroom extends Block
{
    public static final /* synthetic */ PropertyEnum field_176380_a;
    private final /* synthetic */ Block field_176379_b;
    
    @Override
    public Item getItem(final World llllllllllllllIlIlllIIlllIIIIlII, final BlockPos llllllllllllllIlIlllIIlllIIIIIll) {
        return Item.getItemFromBlock(this.field_176379_b);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIlIlllIIlllIIIlllI) {
        return Math.max(0, llllllllllllllIlIlllIIlllIIIlllI.nextInt(10) - 7);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIlllIIllIllIlllI) {
        return ((EnumType)llllllllllllllIlIlllIIllIllIlllI.getValue(BlockHugeMushroom.field_176380_a)).func_176896_a();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockHugeMushroom.field_176380_a });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIlllIIllIlllIIll) {
        return this.getDefaultState().withProperty(BlockHugeMushroom.field_176380_a, EnumType.func_176895_a(llllllllllllllIlIlllIIllIlllIIll));
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIlllIIlllIIIlIlI, final Random llllllllllllllIlIlllIIlllIIIlIIl, final int llllllllllllllIlIlllIIlllIIIlIII) {
        return Item.getItemFromBlock(this.field_176379_b);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIlIlllIIllIlllllll, final BlockPos llllllllllllllIlIlllIIllIllllllI, final EnumFacing llllllllllllllIlIlllIIllIlllllIl, final float llllllllllllllIlIlllIIllIlllllII, final float llllllllllllllIlIlllIIllIllllIll, final float llllllllllllllIlIlllIIllIllllIlI, final int llllllllllllllIlIlllIIllIllllIIl, final EntityLivingBase llllllllllllllIlIlllIIllIllllIII) {
        return this.getDefaultState();
    }
    
    public BlockHugeMushroom(final Material llllllllllllllIlIlllIIlllIIlIIlI, final Block llllllllllllllIlIlllIIlllIIlIlII) {
        super(llllllllllllllIlIlllIIlllIIlIIlI);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockHugeMushroom.field_176380_a, EnumType.ALL_OUTSIDE));
        this.field_176379_b = llllllllllllllIlIlllIIlllIIlIlII;
    }
    
    static {
        __OBFID = "CL_00000258";
        field_176380_a = PropertyEnum.create("variant", EnumType.class);
    }
    
    public enum EnumType implements IStringSerializable
    {
        SOUTH("SOUTH", 7, "SOUTH", 7, 8, "south"), 
        NORTH_WEST("NORTH_WEST", 0, "NORTH_WEST", 0, 1, "north_west"), 
        ALL_OUTSIDE("ALL_OUTSIDE", 11, "ALL_OUTSIDE", 11, 14, "all_outside"), 
        ALL_STEM("ALL_STEM", 12, "ALL_STEM", 12, 15, "all_stem"), 
        STEM("STEM", 9, "STEM", 9, 10, "stem"), 
        SOUTH_WEST("SOUTH_WEST", 6, "SOUTH_WEST", 6, 7, "south_west");
        
        private final /* synthetic */ int field_176906_o;
        private final /* synthetic */ String field_176914_p;
        private static final /* synthetic */ EnumType[] field_176905_n;
        
        CENTER("CENTER", 4, "CENTER", 4, 5, "center"), 
        NORTH_EAST("NORTH_EAST", 2, "NORTH_EAST", 2, 3, "north_east"), 
        ALL_INSIDE("ALL_INSIDE", 10, "ALL_INSIDE", 10, 0, "all_inside"), 
        SOUTH_EAST("SOUTH_EAST", 8, "SOUTH_EAST", 8, 9, "south_east"), 
        NORTH("NORTH", 1, "NORTH", 1, 2, "north"), 
        EAST("EAST", 5, "EAST", 5, 6, "east"), 
        WEST("WEST", 3, "WEST", 3, 4, "west");
        
        private EnumType(final String llllllllllllllIlIIlIlIlIlIlIlIlI, final int llllllllllllllIlIIlIlIlIlIlIlIIl, final String llllllllllllllIlIIlIlIlIlIlIllll, final int llllllllllllllIlIIlIlIlIlIlIlllI, final int llllllllllllllIlIIlIlIlIlIlIlIII, final String llllllllllllllIlIIlIlIlIlIlIIlll) {
            this.field_176906_o = llllllllllllllIlIIlIlIlIlIlIlIII;
            this.field_176914_p = llllllllllllllIlIIlIlIlIlIlIIlll;
        }
        
        static {
            __OBFID = "CL_00002105";
            field_176905_n = new EnumType[16];
            for (final EnumType llllllllllllllIlIIlIlIlIlIlllIlI : values()) {
                EnumType.field_176905_n[llllllllllllllIlIIlIlIlIlIlllIlI.func_176896_a()] = llllllllllllllIlIIlIlIlIlIlllIlI;
            }
        }
        
        @Override
        public String getName() {
            return this.field_176914_p;
        }
        
        public int func_176896_a() {
            return this.field_176906_o;
        }
        
        public static EnumType func_176895_a(int llllllllllllllIlIIlIlIlIlIIlllII) {
            if (llllllllllllllIlIIlIlIlIlIIlllII < 0 || llllllllllllllIlIIlIlIlIlIIlllII >= EnumType.field_176905_n.length) {
                llllllllllllllIlIIlIlIlIlIIlllII = 0;
            }
            final EnumType llllllllllllllIlIIlIlIlIlIIlllIl = EnumType.field_176905_n[llllllllllllllIlIIlIlIlIlIIlllII];
            return (llllllllllllllIlIIlIlIlIlIIlllIl == null) ? EnumType.field_176905_n[0] : llllllllllllllIlIIlIlIlIlIIlllIl;
        }
        
        @Override
        public String toString() {
            return this.field_176914_p;
        }
    }
}
