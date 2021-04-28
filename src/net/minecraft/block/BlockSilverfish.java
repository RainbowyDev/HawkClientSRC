package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.util.*;

public class BlockSilverfish extends Block
{
    public static final /* synthetic */ PropertyEnum VARIANT_PROP;
    
    @Override
    protected ItemStack createStackedBlock(final IBlockState lIIIIlIlIllllIl) {
        switch (SwitchEnumType.field_180178_a[((EnumType)lIIIIlIlIllllIl.getValue(BlockSilverfish.VARIANT_PROP)).ordinal()]) {
            case 1: {
                return new ItemStack(Blocks.cobblestone);
            }
            case 2: {
                return new ItemStack(Blocks.stonebrick);
            }
            case 3: {
                return new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.EnumType.MOSSY.getMetaFromState());
            }
            case 4: {
                return new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.EnumType.CRACKED.getMetaFromState());
            }
            case 5: {
                return new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.EnumType.CHISELED.getMetaFromState());
            }
            default: {
                return new ItemStack(Blocks.stone);
            }
        }
    }
    
    @Override
    public int quantityDropped(final Random lIIIIlIllIIIllI) {
        return 0;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lIIIIlIlIllIlll, final BlockPos lIIIIlIlIllIIII, final IBlockState lIIIIlIlIllIlIl, final float lIIIIlIlIllIlII, final int lIIIIlIlIllIIll) {
        if (!lIIIIlIlIllIlll.isRemote && lIIIIlIlIllIlll.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
            final EntitySilverfish lIIIIlIlIllIIlI = new EntitySilverfish(lIIIIlIlIllIlll);
            lIIIIlIlIllIIlI.setLocationAndAngles(lIIIIlIlIllIIII.getX() + 0.5, lIIIIlIlIllIIII.getY(), lIIIIlIlIllIIII.getZ() + 0.5, 0.0f, 0.0f);
            lIIIIlIlIllIlll.spawnEntityInWorld(lIIIIlIlIllIIlI);
            lIIIIlIlIllIIlI.spawnExplosionParticle();
        }
    }
    
    public BlockSilverfish() {
        super(Material.clay);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSilverfish.VARIANT_PROP, EnumType.STONE));
        this.setHardness(0.0f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lIIIIlIlIIIIlll) {
        return ((EnumType)lIIIIlIlIIIIlll.getValue(BlockSilverfish.VARIANT_PROP)).func_176881_a();
    }
    
    public static boolean func_176377_d(final IBlockState lIIIIlIllIIIIIl) {
        final Block lIIIIlIllIIIIlI = lIIIIlIllIIIIIl.getBlock();
        return lIIIIlIllIIIIIl == Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT_PROP, BlockStone.EnumType.STONE) || lIIIIlIllIIIIlI == Blocks.cobblestone || lIIIIlIllIIIIlI == Blocks.stonebrick;
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { BlockSilverfish.VARIANT_PROP });
    }
    
    @Override
    public int getDamageValue(final World lIIIIlIlIlIIlll, final BlockPos lIIIIlIlIlIlIIl) {
        final IBlockState lIIIIlIlIlIlIII = lIIIIlIlIlIIlll.getBlockState(lIIIIlIlIlIlIIl);
        return lIIIIlIlIlIlIII.getBlock().getMetaFromState(lIIIIlIlIlIlIII);
    }
    
    static {
        __OBFID = "CL_00000271";
        VARIANT_PROP = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public void getSubBlocks(final Item lIIIIlIlIIlIllI, final CreativeTabs lIIIIlIlIIlllII, final List lIIIIlIlIIllIll) {
        for (final EnumType lIIIIlIlIIlIlll : EnumType.values()) {
            lIIIIlIlIIllIll.add(new ItemStack(lIIIIlIlIIlIllI, 1, lIIIIlIlIIlIlll.func_176881_a()));
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIIIlIlIIIlIll) {
        return this.getDefaultState().withProperty(BlockSilverfish.VARIANT_PROP, EnumType.func_176879_a(lIIIIlIlIIIlIll));
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ int field_176893_h;
        
        MOSSY_STONEBRICK(3, "MOSSY_STONEBRICK", 3, 3, "mossy_brick", "mossybrick", (SwitchEnumType)null) {
            @Override
            public IBlockState func_176883_d() {
                return Blocks.stonebrick.getDefaultState().withProperty(BlockStoneBrick.VARIANT_PROP, BlockStoneBrick.EnumType.MOSSY);
            }
            
            static {
                __OBFID = "CL_00002094";
            }
        }, 
        COBBLESTONE(1, "COBBLESTONE", 1, 1, "cobblestone", "cobble", (SwitchEnumType)null) {
            @Override
            public IBlockState func_176883_d() {
                return Blocks.cobblestone.getDefaultState();
            }
            
            static {
                __OBFID = "CL_00002096";
            }
        }, 
        CRACKED_STONEBRICK(4, "CRACKED_STONEBRICK", 4, 4, "cracked_brick", "crackedbrick", (SwitchEnumType)null) {
            static {
                __OBFID = "CL_00002093";
            }
            
            @Override
            public IBlockState func_176883_d() {
                return Blocks.stonebrick.getDefaultState().withProperty(BlockStoneBrick.VARIANT_PROP, BlockStoneBrick.EnumType.CRACKED);
            }
        }, 
        STONE(0, "STONE", 0, 0, "stone", (SwitchEnumType)null) {
            static {
                __OBFID = "CL_00002097";
            }
            
            @Override
            public IBlockState func_176883_d() {
                return Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT_PROP, BlockStone.EnumType.STONE);
            }
        };
        
        private final /* synthetic */ String field_176891_j;
        private final /* synthetic */ String field_176894_i;
        
        STONEBRICK(2, "STONEBRICK", 2, 2, "stone_brick", "brick", (SwitchEnumType)null) {
            static {
                __OBFID = "CL_00002095";
            }
            
            @Override
            public IBlockState func_176883_d() {
                return Blocks.stonebrick.getDefaultState().withProperty(BlockStoneBrick.VARIANT_PROP, BlockStoneBrick.EnumType.DEFAULT);
            }
        }, 
        CHISELED_STONEBRICK(5, "CHISELED_STONEBRICK", 5, 5, "chiseled_brick", "chiseledbrick", (SwitchEnumType)null) {
            @Override
            public IBlockState func_176883_d() {
                return Blocks.stonebrick.getDefaultState().withProperty(BlockStoneBrick.VARIANT_PROP, BlockStoneBrick.EnumType.CHISELED);
            }
            
            static {
                __OBFID = "CL_00002092";
            }
        };
        
        private static final /* synthetic */ EnumType[] field_176885_g;
        
        public static EnumType func_176879_a(int lllllllllllllllIlIIIlllIIIllIIlI) {
            if (lllllllllllllllIlIIIlllIIIllIIlI < 0 || lllllllllllllllIlIIIlllIIIllIIlI >= EnumType.field_176885_g.length) {
                lllllllllllllllIlIIIlllIIIllIIlI = 0;
            }
            return EnumType.field_176885_g[lllllllllllllllIlIIIlllIIIllIIlI];
        }
        
        @Override
        public String toString() {
            return this.field_176894_i;
        }
        
        @Override
        public String getName() {
            return this.field_176894_i;
        }
        
        public abstract IBlockState func_176883_d();
        
        private EnumType(final String lllllllllllllllIlIIIlllIIIIIlllI, final int lllllllllllllllIlIIIlllIIIIIllIl, final String lllllllllllllllIlIIIlllIIIIlIlII, final int lllllllllllllllIlIIIlllIIIIlIIll, final int lllllllllllllllIlIIIlllIIIIlIIlI, final String lllllllllllllllIlIIIlllIIIIlIIIl, final SwitchEnumType lllllllllllllllIlIIIlllIIIIlIIII) {
            this(lllllllllllllllIlIIIlllIIIIIlllI, lllllllllllllllIlIIIlllIIIIIllIl, lllllllllllllllIlIIIlllIIIIlIlII, lllllllllllllllIlIIIlllIIIIlIIll, lllllllllllllllIlIIIlllIIIIlIIlI, lllllllllllllllIlIIIlllIIIIlIIIl);
        }
        
        private EnumType(final String lllllllllllllllIlIIIlllIIlIlIIlI, final int lllllllllllllllIlIIIlllIIlIlIIIl, final String lllllllllllllllIlIIIlllIIlIlIlll, final int lllllllllllllllIlIIIlllIIlIlIllI, final int lllllllllllllllIlIIIlllIIlIIlllI, final String lllllllllllllllIlIIIlllIIlIlIlII) {
            this(lllllllllllllllIlIIIlllIIlIlIIlI, lllllllllllllllIlIIIlllIIlIlIIIl, lllllllllllllllIlIIIlllIIlIlIlll, lllllllllllllllIlIIIlllIIlIlIllI, lllllllllllllllIlIIIlllIIlIIlllI, lllllllllllllllIlIIIlllIIlIlIlII, lllllllllllllllIlIIIlllIIlIlIlII);
        }
        
        public String func_176882_c() {
            return this.field_176891_j;
        }
        
        public int func_176881_a() {
            return this.field_176893_h;
        }
        
        public static EnumType func_176878_a(final IBlockState lllllllllllllllIlIIIlllIIIlIIllI) {
            for (final EnumType lllllllllllllllIlIIIlllIIIlIIIlI : values()) {
                if (lllllllllllllllIlIIIlllIIIlIIllI == lllllllllllllllIlIIIlllIIIlIIIlI.func_176883_d()) {
                    return lllllllllllllllIlIIIlllIIIlIIIlI;
                }
            }
            return EnumType.STONE;
        }
        
        private EnumType(final String lllllllllllllllIlIIIlllIIIllllll, final int lllllllllllllllIlIIIlllIIIlllllI, final String lllllllllllllllIlIIIlllIIlIIIlIl, final int lllllllllllllllIlIIIlllIIlIIIlII, final int lllllllllllllllIlIIIlllIIIllllIl, final String lllllllllllllllIlIIIlllIIIllllII, final String lllllllllllllllIlIIIlllIIlIIIIIl) {
            this.field_176893_h = lllllllllllllllIlIIIlllIIIllllIl;
            this.field_176894_i = lllllllllllllllIlIIIlllIIIllllII;
            this.field_176891_j = lllllllllllllllIlIIIlllIIlIIIIIl;
        }
        
        static {
            __OBFID = "CL_00002098";
            field_176885_g = new EnumType[values().length];
            for (final EnumType lllllllllllllllIlIIIlllIIllIIlII : values()) {
                EnumType.field_176885_g[lllllllllllllllIlIIIlllIIllIIlII.func_176881_a()] = lllllllllllllllIlIIIlllIIllIIlII;
            }
        }
        
        private EnumType(final String lllllllllllllllIlIIIllIllllllIII, final int lllllllllllllllIlIIIllIlllllIlll, final String lllllllllllllllIlIIIllIlllllllll, final int lllllllllllllllIlIIIllIllllllllI, final int lllllllllllllllIlIIIllIlllllllIl, final String lllllllllllllllIlIIIllIlllllIIll, final String lllllllllllllllIlIIIllIlllllIIlI, final SwitchEnumType lllllllllllllllIlIIIllIllllllIlI) {
            this(lllllllllllllllIlIIIllIllllllIII, lllllllllllllllIlIIIllIlllllIlll, lllllllllllllllIlIIIllIlllllllll, lllllllllllllllIlIIIllIllllllllI, lllllllllllllllIlIIIllIlllllllIl, lllllllllllllllIlIIIllIlllllIIll, lllllllllllllllIlIIIllIlllllIIlI);
        }
    }
    
    static final class SwitchEnumType
    {
        static final /* synthetic */ int[] field_180178_a;
        
        static {
            __OBFID = "CL_00002099";
            field_180178_a = new int[EnumType.values().length];
            try {
                SwitchEnumType.field_180178_a[EnumType.COBBLESTONE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumType.field_180178_a[EnumType.STONEBRICK.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumType.field_180178_a[EnumType.MOSSY_STONEBRICK.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumType.field_180178_a[EnumType.CRACKED_STONEBRICK.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                SwitchEnumType.field_180178_a[EnumType.CHISELED_STONEBRICK.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
        }
    }
}
