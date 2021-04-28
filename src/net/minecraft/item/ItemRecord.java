package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.creativetab.*;

public class ItemRecord extends Item
{
    public final /* synthetic */ String recordName;
    private static final /* synthetic */ Map field_150928_b;
    
    @Override
    public EnumRarity getRarity(final ItemStack lllllllllllllllIIIllIIlIIIlIlIll) {
        return EnumRarity.RARE;
    }
    
    public static ItemRecord getRecord(final String lllllllllllllllIIIllIIlIIIlIlIII) {
        return ItemRecord.field_150928_b.get(lllllllllllllllIIIllIIlIIIlIlIII);
    }
    
    @Override
    public boolean onItemUse(final ItemStack lllllllllllllllIIIllIIlIIlIIIllI, final EntityPlayer lllllllllllllllIIIllIIlIIlIIIlIl, final World lllllllllllllllIIIllIIlIIlIIIlII, final BlockPos lllllllllllllllIIIllIIlIIIlllIlI, final EnumFacing lllllllllllllllIIIllIIlIIlIIIIlI, final float lllllllllllllllIIIllIIlIIlIIIIIl, final float lllllllllllllllIIIllIIlIIlIIIIII, final float lllllllllllllllIIIllIIlIIIllllll) {
        final IBlockState lllllllllllllllIIIllIIlIIIlllllI = lllllllllllllllIIIllIIlIIlIIIlII.getBlockState(lllllllllllllllIIIllIIlIIIlllIlI);
        if (lllllllllllllllIIIllIIlIIIlllllI.getBlock() != Blocks.jukebox || (boolean)lllllllllllllllIIIllIIlIIIlllllI.getValue(BlockJukebox.HAS_RECORD)) {
            return false;
        }
        if (lllllllllllllllIIIllIIlIIlIIIlII.isRemote) {
            return true;
        }
        ((BlockJukebox)Blocks.jukebox).insertRecord(lllllllllllllllIIIllIIlIIlIIIlII, lllllllllllllllIIIllIIlIIIlllIlI, lllllllllllllllIIIllIIlIIIlllllI, lllllllllllllllIIIllIIlIIlIIIllI);
        lllllllllllllllIIIllIIlIIlIIIlII.playAuxSFXAtEntity(null, 1005, lllllllllllllllIIIllIIlIIIlllIlI, Item.getIdFromItem(this));
        --lllllllllllllllIIIllIIlIIlIIIllI.stackSize;
        return true;
    }
    
    @Override
    public void addInformation(final ItemStack lllllllllllllllIIIllIIlIIIllIlIl, final EntityPlayer lllllllllllllllIIIllIIlIIIllIlII, final List lllllllllllllllIIIllIIlIIIllIIII, final boolean lllllllllllllllIIIllIIlIIIllIIlI) {
        lllllllllllllllIIIllIIlIIIllIIII.add(this.getRecordNameLocal());
    }
    
    public String getRecordNameLocal() {
        return StatCollector.translateToLocal(String.valueOf(new StringBuilder("item.record.").append(this.recordName).append(".desc")));
    }
    
    static {
        __OBFID = "CL_00000057";
        field_150928_b = Maps.newHashMap();
    }
    
    protected ItemRecord(final String lllllllllllllllIIIllIIlIIlIIllIl) {
        this.recordName = lllllllllllllllIIIllIIlIIlIIllIl;
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabMisc);
        ItemRecord.field_150928_b.put(String.valueOf(new StringBuilder("records.").append(lllllllllllllllIIIllIIlIIlIIllIl)), this);
    }
}
