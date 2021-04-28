package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockSand extends BlockFalling
{
    public static final /* synthetic */ PropertyEnum VARIANT_PROP;
    
    public BlockSand() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSand.VARIANT_PROP, EnumType.SAND));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlllIIIIlIlllIlll) {
        return this.getDefaultState().withProperty(BlockSand.VARIANT_PROP, EnumType.func_176686_a(lllllllllllllllIlllIIIIlIlllIlll));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIlllIIIIlIlllllII) {
        return ((EnumType)lllllllllllllllIlllIIIIlIlllllII.getValue(BlockSand.VARIANT_PROP)).func_176687_c();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockSand.VARIANT_PROP });
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIlllIIIIllIIlIlII) {
        return ((EnumType)lllllllllllllllIlllIIIIllIIlIlII.getValue(BlockSand.VARIANT_PROP)).func_176688_a();
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlllIIIIlIlllIIlI) {
        return ((EnumType)lllllllllllllllIlllIIIIlIlllIIlI.getValue(BlockSand.VARIANT_PROP)).func_176688_a();
    }
    
    @Override
    public void getSubBlocks(final Item lllllllllllllllIlllIIIIllIIIIlII, final CreativeTabs lllllllllllllllIlllIIIIllIIIlIlI, final List lllllllllllllllIlllIIIIllIIIlIIl) {
        for (final EnumType lllllllllllllllIlllIIIIllIIIIlIl : EnumType.values()) {
            lllllllllllllllIlllIIIIllIIIlIIl.add(new ItemStack(lllllllllllllllIlllIIIIllIIIIlII, 1, lllllllllllllllIlllIIIIllIIIIlIl.func_176688_a()));
        }
    }
    
    static {
        __OBFID = "CL_00000303";
        VARIANT_PROP = PropertyEnum.create("variant", EnumType.class);
    }
    
    public enum EnumType implements IStringSerializable
    {
        SAND("SAND", 0, "SAND", 0, 0, "sand", "default", MapColor.sandColor);
        
        private final /* synthetic */ String field_176693_e;
        private final /* synthetic */ String field_176691_g;
        private final /* synthetic */ int field_176692_d;
        private static final /* synthetic */ EnumType[] field_176695_c;
        
        RED_SAND("RED_SAND", 1, "RED_SAND", 1, 1, "red_sand", "red", MapColor.dirtColor);
        
        private final /* synthetic */ MapColor field_176690_f;
        
        private EnumType(final String llllllllllllllIllIllIllllllIIllI, final int llllllllllllllIllIllIllllllIIlIl, final String llllllllllllllIllIllIllllllIllIl, final int llllllllllllllIllIllIllllllIllII, final int llllllllllllllIllIllIllllllIlIll, final String llllllllllllllIllIllIllllllIlIlI, final String llllllllllllllIllIllIllllllIIIlI, final MapColor llllllllllllllIllIllIllllllIIIIl) {
            this.field_176692_d = llllllllllllllIllIllIllllllIlIll;
            this.field_176693_e = llllllllllllllIllIllIllllllIlIlI;
            this.field_176690_f = llllllllllllllIllIllIllllllIIIIl;
            this.field_176691_g = llllllllllllllIllIllIllllllIIIlI;
        }
        
        public static EnumType func_176686_a(int llllllllllllllIllIllIlllllIlIllI) {
            if (llllllllllllllIllIllIlllllIlIllI < 0 || llllllllllllllIllIllIlllllIlIllI >= EnumType.field_176695_c.length) {
                llllllllllllllIllIllIlllllIlIllI = 0;
            }
            return EnumType.field_176695_c[llllllllllllllIllIllIlllllIlIllI];
        }
        
        @Override
        public String toString() {
            return this.field_176693_e;
        }
        
        public String func_176685_d() {
            return this.field_176691_g;
        }
        
        public MapColor func_176687_c() {
            return this.field_176690_f;
        }
        
        static {
            __OBFID = "CL_00002069";
            field_176695_c = new EnumType[values().length];
            for (final EnumType llllllllllllllIllIllIllllllllIlI : values()) {
                EnumType.field_176695_c[llllllllllllllIllIllIllllllllIlI.func_176688_a()] = llllllllllllllIllIllIllllllllIlI;
            }
        }
        
        @Override
        public String getName() {
            return this.field_176693_e;
        }
        
        public int func_176688_a() {
            return this.field_176692_d;
        }
    }
}
