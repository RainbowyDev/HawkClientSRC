package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockSandStone extends Block
{
    public static final /* synthetic */ PropertyEnum field_176297_a;
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIlllllllIIIIIIII) {
        return ((EnumType)llllllllllllllIlIlllllllIIIIIIII.getValue(BlockSandStone.field_176297_a)).func_176675_a();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIlllllllIIIIIlII) {
        return this.getDefaultState().withProperty(BlockSandStone.field_176297_a, EnumType.func_176673_a(llllllllllllllIlIlllllllIIIIIlII));
    }
    
    static {
        __OBFID = "CL_00000304";
        field_176297_a = PropertyEnum.create("type", EnumType.class);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlIlllllllIIIllllI) {
        return ((EnumType)llllllllllllllIlIlllllllIIIllllI.getValue(BlockSandStone.field_176297_a)).func_176675_a();
    }
    
    public BlockSandStone() {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSandStone.field_176297_a, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public void getSubBlocks(final Item llllllllllllllIlIlllllllIIIIllll, final CreativeTabs llllllllllllllIlIlllllllIIIlIlIl, final List llllllllllllllIlIlllllllIIIIlllI) {
        for (final EnumType llllllllllllllIlIlllllllIIIlIIII : EnumType.values()) {
            llllllllllllllIlIlllllllIIIIlllI.add(new ItemStack(llllllllllllllIlIlllllllIIIIllll, 1, llllllllllllllIlIlllllllIIIlIIII.func_176675_a()));
        }
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockSandStone.field_176297_a });
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ String field_176678_g;
        
        CHISELED("CHISELED", 1, "CHISELED", 1, 1, "chiseled_sandstone", "chiseled");
        
        private final /* synthetic */ int field_176680_e;
        
        DEFAULT("DEFAULT", 0, "DEFAULT", 0, 0, "sandstone", "default"), 
        SMOOTH("SMOOTH", 2, "SMOOTH", 2, 2, "smooth_sandstone", "smooth");
        
        private static final /* synthetic */ EnumType[] field_176679_d;
        private final /* synthetic */ String field_176677_f;
        
        @Override
        public String toString() {
            return this.field_176677_f;
        }
        
        public static EnumType func_176673_a(int llllllllllllllIlIIlllIIllllIIIll) {
            if (llllllllllllllIlIIlllIIllllIIIll < 0 || llllllllllllllIlIIlllIIllllIIIll >= EnumType.field_176679_d.length) {
                llllllllllllllIlIIlllIIllllIIIll = 0;
            }
            return EnumType.field_176679_d[llllllllllllllIlIIlllIIllllIIIll];
        }
        
        private EnumType(final String llllllllllllllIlIIlllIIlllllIIII, final int llllllllllllllIlIIlllIIllllIllll, final String llllllllllllllIlIIlllIIlllllIllI, final int llllllllllllllIlIIlllIIlllllIlIl, final int llllllllllllllIlIIlllIIlllllIlII, final String llllllllllllllIlIIlllIIllllIllIl, final String llllllllllllllIlIIlllIIlllllIIlI) {
            this.field_176680_e = llllllllllllllIlIIlllIIlllllIlII;
            this.field_176677_f = llllllllllllllIlIIlllIIllllIllIl;
            this.field_176678_g = llllllllllllllIlIIlllIIlllllIIlI;
        }
        
        public String func_176676_c() {
            return this.field_176678_g;
        }
        
        public int func_176675_a() {
            return this.field_176680_e;
        }
        
        @Override
        public String getName() {
            return this.field_176677_f;
        }
        
        static {
            __OBFID = "CL_00002068";
            field_176679_d = new EnumType[values().length];
            for (final EnumType llllllllllllllIlIIlllIlIIIIIIIlI : values()) {
                EnumType.field_176679_d[llllllllllllllIlIIlllIlIIIIIIIlI.func_176675_a()] = llllllllllllllIlIIlllIlIIIIIIIlI;
            }
        }
    }
}
