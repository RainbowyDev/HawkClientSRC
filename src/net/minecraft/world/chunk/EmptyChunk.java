package net.minecraft.world.chunk;

import net.minecraft.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.google.common.base.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;

public class EmptyChunk extends Chunk
{
    @Override
    public TileEntity func_177424_a(final BlockPos lllllllllllllllIIllIlllIllIllllI, final EnumCreateEntityType lllllllllllllllIIllIlllIllIlllIl) {
        return null;
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    public void setLightFor(final EnumSkyBlock lllllllllllllllIIllIlllIlllIlllI, final BlockPos lllllllllllllllIIllIlllIlllIllIl, final int lllllllllllllllIIllIlllIlllIllII) {
    }
    
    @Override
    public boolean canSeeSky(final BlockPos lllllllllllllllIIllIlllIlllIIIII) {
        return false;
    }
    
    @Override
    public int getBlockLightOpacity(final BlockPos lllllllllllllllIIllIlllIllllIlll) {
        return 255;
    }
    
    @Override
    public void addEntity(final Entity lllllllllllllllIIllIlllIlllIIlll) {
    }
    
    @Override
    public void onChunkUnload() {
    }
    
    @Override
    public boolean needsSaving(final boolean lllllllllllllllIIllIlllIllIIIlll) {
        return false;
    }
    
    @Override
    public void removeEntity(final Entity lllllllllllllllIIllIlllIlllIIlIl) {
    }
    
    public void generateHeightMap() {
    }
    
    @Override
    public void generateSkylightMap() {
    }
    
    @Override
    public boolean isAtLocation(final int lllllllllllllllIIllIllllIIIIIlII, final int lllllllllllllllIIllIllllIIIIIIII) {
        return lllllllllllllllIIllIllllIIIIIlII == this.xPosition && lllllllllllllllIIllIllllIIIIIIII == this.zPosition;
    }
    
    @Override
    public void onChunkLoad() {
    }
    
    @Override
    public int getBlockMetadata(final BlockPos lllllllllllllllIIllIlllIllllIlIl) {
        return 0;
    }
    
    @Override
    public boolean getAreLevelsEmpty(final int lllllllllllllllIIllIlllIlIlllllI, final int lllllllllllllllIIllIlllIlIllllIl) {
        return true;
    }
    
    @Override
    public void func_177414_a(final Entity lllllllllllllllIIllIlllIllIlIIIl, final AxisAlignedBB lllllllllllllllIIllIlllIllIlIIII, final List lllllllllllllllIIllIlllIllIIllll, final Predicate lllllllllllllllIIllIlllIllIIlllI) {
    }
    
    @Override
    public void addTileEntity(final BlockPos lllllllllllllllIIllIlllIllIllIIl, final TileEntity lllllllllllllllIIllIlllIllIllIII) {
    }
    
    @Override
    public void removeTileEntity(final BlockPos lllllllllllllllIIllIlllIllIlIllI) {
    }
    
    @Override
    public void func_177430_a(final Class lllllllllllllllIIllIlllIllIIllII, final AxisAlignedBB lllllllllllllllIIllIlllIllIIlIll, final List lllllllllllllllIIllIlllIllIIlIlI, final Predicate lllllllllllllllIIllIlllIllIIlIIl) {
    }
    
    @Override
    public void setChunkModified() {
    }
    
    public EmptyChunk(final World lllllllllllllllIIllIllllIIIIllll, final int lllllllllllllllIIllIllllIIIIlIlI, final int lllllllllllllllIIllIllllIIIIlIIl) {
        super(lllllllllllllllIIllIllllIIIIllll, lllllllllllllllIIllIllllIIIIlIlI, lllllllllllllllIIllIllllIIIIlIIl);
    }
    
    @Override
    public int setLight(final BlockPos lllllllllllllllIIllIlllIlllIlIlI, final int lllllllllllllllIIllIlllIlllIlIIl) {
        return 0;
    }
    
    @Override
    public Random getRandomWithSeed(final long lllllllllllllllIIllIlllIllIIIIIl) {
        return new Random(this.getWorld().getSeed() + this.xPosition * this.xPosition * 4987142 + this.xPosition * 5947611 + this.zPosition * this.zPosition * 4392871L + this.zPosition * 389711 ^ lllllllllllllllIIllIlllIllIIIIIl);
    }
    
    static {
        __OBFID = "CL_00000372";
    }
    
    @Override
    public Block getBlock(final BlockPos lllllllllllllllIIllIlllIlllllIIl) {
        return Blocks.air;
    }
    
    @Override
    public void addTileEntity(final TileEntity lllllllllllllllIIllIlllIllIllIll) {
    }
    
    @Override
    public int getLightFor(final EnumSkyBlock lllllllllllllllIIllIlllIllllIIII, final BlockPos lllllllllllllllIIllIlllIllllIIIl) {
        return lllllllllllllllIIllIlllIllllIIII.defaultLightValue;
    }
    
    @Override
    public int getHeight(final int lllllllllllllllIIllIlllIlllllllI, final int lllllllllllllllIIllIlllIllllllIl) {
        return 0;
    }
    
    @Override
    public void removeEntityAtIndex(final Entity lllllllllllllllIIllIlllIlllIIIll, final int lllllllllllllllIIllIlllIlllIIIlI) {
    }
}
