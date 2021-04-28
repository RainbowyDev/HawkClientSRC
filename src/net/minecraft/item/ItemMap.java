package net.minecraft.item;

import net.minecraft.entity.*;
import net.minecraft.world.storage.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import com.google.common.collect.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.network.*;
import java.util.*;

public class ItemMap extends ItemMapBase
{
    public void updateMapData(final World llllllllllllllIlIIIllIIIllIIlIll, final Entity llllllllllllllIlIIIllIIIllIIlIlI, final MapData llllllllllllllIlIIIllIIIllIIlIIl) {
        if (llllllllllllllIlIIIllIIIllIIlIll.provider.getDimensionId() == llllllllllllllIlIIIllIIIllIIlIIl.dimension && llllllllllllllIlIIIllIIIllIIlIlI instanceof EntityPlayer) {
            final int llllllllllllllIlIIIllIIIlllIllIl = 1 << llllllllllllllIlIIIllIIIllIIlIIl.scale;
            final int llllllllllllllIlIIIllIIIlllIllII = llllllllllllllIlIIIllIIIllIIlIIl.xCenter;
            final int llllllllllllllIlIIIllIIIlllIlIll = llllllllllllllIlIIIllIIIllIIlIIl.zCenter;
            final int llllllllllllllIlIIIllIIIlllIlIlI = MathHelper.floor_double(llllllllllllllIlIIIllIIIllIIlIlI.posX - llllllllllllllIlIIIllIIIlllIllII) / llllllllllllllIlIIIllIIIlllIllIl + 64;
            final int llllllllllllllIlIIIllIIIlllIlIIl = MathHelper.floor_double(llllllllllllllIlIIIllIIIllIIlIlI.posZ - llllllllllllllIlIIIllIIIlllIlIll) / llllllllllllllIlIIIllIIIlllIllIl + 64;
            int llllllllllllllIlIIIllIIIlllIlIII = 128 / llllllllllllllIlIIIllIIIlllIllIl;
            if (llllllllllllllIlIIIllIIIllIIlIll.provider.getHasNoSky()) {
                llllllllllllllIlIIIllIIIlllIlIII /= 2;
            }
            final MapData.MapInfo func_82568_a;
            final MapData.MapInfo llllllllllllllIlIIIllIIIlllIIlll = func_82568_a = llllllllllllllIlIIIllIIIllIIlIIl.func_82568_a((EntityPlayer)llllllllllllllIlIIIllIIIllIIlIlI);
            ++func_82568_a.field_82569_d;
            boolean llllllllllllllIlIIIllIIIlllIIllI = false;
            for (int llllllllllllllIlIIIllIIIlllIIlIl = llllllllllllllIlIIIllIIIlllIlIlI - llllllllllllllIlIIIllIIIlllIlIII + 1; llllllllllllllIlIIIllIIIlllIIlIl < llllllllllllllIlIIIllIIIlllIlIlI + llllllllllllllIlIIIllIIIlllIlIII; ++llllllllllllllIlIIIllIIIlllIIlIl) {
                if ((llllllllllllllIlIIIllIIIlllIIlIl & 0xF) == (llllllllllllllIlIIIllIIIlllIIlll.field_82569_d & 0xF) || llllllllllllllIlIIIllIIIlllIIllI) {
                    llllllllllllllIlIIIllIIIlllIIllI = false;
                    double llllllllllllllIlIIIllIIIlllIIlII = 0.0;
                    for (int llllllllllllllIlIIIllIIIlllIIIll = llllllllllllllIlIIIllIIIlllIlIIl - llllllllllllllIlIIIllIIIlllIlIII - 1; llllllllllllllIlIIIllIIIlllIIIll < llllllllllllllIlIIIllIIIlllIlIIl + llllllllllllllIlIIIllIIIlllIlIII; ++llllllllllllllIlIIIllIIIlllIIIll) {
                        if (llllllllllllllIlIIIllIIIlllIIlIl >= 0 && llllllllllllllIlIIIllIIIlllIIIll >= -1 && llllllllllllllIlIIIllIIIlllIIlIl < 128 && llllllllllllllIlIIIllIIIlllIIIll < 128) {
                            final int llllllllllllllIlIIIllIIIlllIIIlI = llllllllllllllIlIIIllIIIlllIIlIl - llllllllllllllIlIIIllIIIlllIlIlI;
                            final int llllllllllllllIlIIIllIIIlllIIIIl = llllllllllllllIlIIIllIIIlllIIIll - llllllllllllllIlIIIllIIIlllIlIIl;
                            final boolean llllllllllllllIlIIIllIIIlllIIIII = llllllllllllllIlIIIllIIIlllIIIlI * llllllllllllllIlIIIllIIIlllIIIlI + llllllllllllllIlIIIllIIIlllIIIIl * llllllllllllllIlIIIllIIIlllIIIIl > (llllllllllllllIlIIIllIIIlllIlIII - 2) * (llllllllllllllIlIIIllIIIlllIlIII - 2);
                            final int llllllllllllllIlIIIllIIIllIlllll = (llllllllllllllIlIIIllIIIlllIllII / llllllllllllllIlIIIllIIIlllIllIl + llllllllllllllIlIIIllIIIlllIIlIl - 64) * llllllllllllllIlIIIllIIIlllIllIl;
                            final int llllllllllllllIlIIIllIIIllIllllI = (llllllllllllllIlIIIllIIIlllIlIll / llllllllllllllIlIIIllIIIlllIllIl + llllllllllllllIlIIIllIIIlllIIIll - 64) * llllllllllllllIlIIIllIIIlllIllIl;
                            final HashMultiset llllllllllllllIlIIIllIIIllIlllIl = HashMultiset.create();
                            final Chunk llllllllllllllIlIIIllIIIllIlllII = llllllllllllllIlIIIllIIIllIIlIll.getChunkFromBlockCoords(new BlockPos(llllllllllllllIlIIIllIIIllIlllll, 0, llllllllllllllIlIIIllIIIllIllllI));
                            if (!llllllllllllllIlIIIllIIIllIlllII.isEmpty()) {
                                final int llllllllllllllIlIIIllIIIllIllIll = llllllllllllllIlIIIllIIIllIlllll & 0xF;
                                final int llllllllllllllIlIIIllIIIllIllIlI = llllllllllllllIlIIIllIIIllIllllI & 0xF;
                                int llllllllllllllIlIIIllIIIllIllIIl = 0;
                                double llllllllllllllIlIIIllIIIllIllIII = 0.0;
                                if (llllllllllllllIlIIIllIIIllIIlIll.provider.getHasNoSky()) {
                                    int llllllllllllllIlIIIllIIIllIlIlll = llllllllllllllIlIIIllIIIllIlllll + llllllllllllllIlIIIllIIIllIllllI * 231871;
                                    llllllllllllllIlIIIllIIIllIlIlll = llllllllllllllIlIIIllIIIllIlIlll * llllllllllllllIlIIIllIIIllIlIlll * 31287121 + llllllllllllllIlIIIllIIIllIlIlll * 11;
                                    if ((llllllllllllllIlIIIllIIIllIlIlll >> 20 & 0x1) == 0x0) {
                                        llllllllllllllIlIIIllIIIllIlllIl.add((Object)Blocks.dirt.getMapColor(Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT)), 10);
                                    }
                                    else {
                                        llllllllllllllIlIIIllIIIllIlllIl.add((Object)Blocks.stone.getMapColor(Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT_PROP, BlockStone.EnumType.STONE)), 100);
                                    }
                                    llllllllllllllIlIIIllIIIllIllIII = 100.0;
                                }
                                else {
                                    for (int llllllllllllllIlIIIllIIIllIlIllI = 0; llllllllllllllIlIIIllIIIllIlIllI < llllllllllllllIlIIIllIIIlllIllIl; ++llllllllllllllIlIIIllIIIllIlIllI) {
                                        for (int llllllllllllllIlIIIllIIIllIlIlIl = 0; llllllllllllllIlIIIllIIIllIlIlIl < llllllllllllllIlIIIllIIIlllIllIl; ++llllllllllllllIlIIIllIIIllIlIlIl) {
                                            int llllllllllllllIlIIIllIIIllIlIlII = llllllllllllllIlIIIllIIIllIlllII.getHeight(llllllllllllllIlIIIllIIIllIlIllI + llllllllllllllIlIIIllIIIllIllIll, llllllllllllllIlIIIllIIIllIlIlIl + llllllllllllllIlIIIllIIIllIllIlI) + 1;
                                            IBlockState llllllllllllllIlIIIllIIIllIlIIll = Blocks.air.getDefaultState();
                                            if (llllllllllllllIlIIIllIIIllIlIlII > 1) {
                                                do {
                                                    --llllllllllllllIlIIIllIIIllIlIlII;
                                                    llllllllllllllIlIIIllIIIllIlIIll = llllllllllllllIlIIIllIIIllIlllII.getBlockState(new BlockPos(llllllllllllllIlIIIllIIIllIlIllI + llllllllllllllIlIIIllIIIllIllIll, llllllllllllllIlIIIllIIIllIlIlII, llllllllllllllIlIIIllIIIllIlIlIl + llllllllllllllIlIIIllIIIllIllIlI));
                                                } while (llllllllllllllIlIIIllIIIllIlIIll.getBlock().getMapColor(llllllllllllllIlIIIllIIIllIlIIll) == MapColor.airColor && llllllllllllllIlIIIllIIIllIlIlII > 0);
                                                if (llllllllllllllIlIIIllIIIllIlIlII > 0 && llllllllllllllIlIIIllIIIllIlIIll.getBlock().getMaterial().isLiquid()) {
                                                    int llllllllllllllIlIIIllIIIllIlIIlI = llllllllllllllIlIIIllIIIllIlIlII - 1;
                                                    Block llllllllllllllIlIIIllIIIllIlIIIl;
                                                    do {
                                                        llllllllllllllIlIIIllIIIllIlIIIl = llllllllllllllIlIIIllIIIllIlllII.getBlock(llllllllllllllIlIIIllIIIllIlIllI + llllllllllllllIlIIIllIIIllIllIll, llllllllllllllIlIIIllIIIllIlIIlI--, llllllllllllllIlIIIllIIIllIlIlIl + llllllllllllllIlIIIllIIIllIllIlI);
                                                        ++llllllllllllllIlIIIllIIIllIllIIl;
                                                    } while (llllllllllllllIlIIIllIIIllIlIIlI > 0 && llllllllllllllIlIIIllIIIllIlIIIl.getMaterial().isLiquid());
                                                }
                                            }
                                            llllllllllllllIlIIIllIIIllIllIII += llllllllllllllIlIIIllIIIllIlIlII / (double)(llllllllllllllIlIIIllIIIlllIllIl * llllllllllllllIlIIIllIIIlllIllIl);
                                            llllllllllllllIlIIIllIIIllIlllIl.add((Object)llllllllllllllIlIIIllIIIllIlIIll.getBlock().getMapColor(llllllllllllllIlIIIllIIIllIlIIll));
                                        }
                                    }
                                }
                                llllllllllllllIlIIIllIIIllIllIIl /= llllllllllllllIlIIIllIIIlllIllIl * llllllllllllllIlIIIllIIIlllIllIl;
                                double llllllllllllllIlIIIllIIIllIlIIII = (llllllllllllllIlIIIllIIIllIllIII - llllllllllllllIlIIIllIIIlllIIlII) * 4.0 / (llllllllllllllIlIIIllIIIlllIllIl + 4) + ((llllllllllllllIlIIIllIIIlllIIlIl + llllllllllllllIlIIIllIIIlllIIIll & 0x1) - 0.5) * 0.4;
                                byte llllllllllllllIlIIIllIIIllIIllll = 1;
                                if (llllllllllllllIlIIIllIIIllIlIIII > 0.6) {
                                    llllllllllllllIlIIIllIIIllIIllll = 2;
                                }
                                if (llllllllllllllIlIIIllIIIllIlIIII < -0.6) {
                                    llllllllllllllIlIIIllIIIllIIllll = 0;
                                }
                                final MapColor llllllllllllllIlIIIllIIIllIIlllI = (MapColor)Iterables.getFirst((Iterable)Multisets.copyHighestCountFirst((Multiset)llllllllllllllIlIIIllIIIllIlllIl), (Object)MapColor.airColor);
                                if (llllllllllllllIlIIIllIIIllIIlllI == MapColor.waterColor) {
                                    llllllllllllllIlIIIllIIIllIlIIII = llllllllllllllIlIIIllIIIllIllIIl * 0.1 + (llllllllllllllIlIIIllIIIlllIIlIl + llllllllllllllIlIIIllIIIlllIIIll & 0x1) * 0.2;
                                    llllllllllllllIlIIIllIIIllIIllll = 1;
                                    if (llllllllllllllIlIIIllIIIllIlIIII < 0.5) {
                                        llllllllllllllIlIIIllIIIllIIllll = 2;
                                    }
                                    if (llllllllllllllIlIIIllIIIllIlIIII > 0.9) {
                                        llllllllllllllIlIIIllIIIllIIllll = 0;
                                    }
                                }
                                llllllllllllllIlIIIllIIIlllIIlII = llllllllllllllIlIIIllIIIllIllIII;
                                if (llllllllllllllIlIIIllIIIlllIIIll >= 0 && llllllllllllllIlIIIllIIIlllIIIlI * llllllllllllllIlIIIllIIIlllIIIlI + llllllllllllllIlIIIllIIIlllIIIIl * llllllllllllllIlIIIllIIIlllIIIIl < llllllllllllllIlIIIllIIIlllIlIII * llllllllllllllIlIIIllIIIlllIlIII && (!llllllllllllllIlIIIllIIIlllIIIII || (llllllllllllllIlIIIllIIIlllIIlIl + llllllllllllllIlIIIllIIIlllIIIll & 0x1) != 0x0)) {
                                    final byte llllllllllllllIlIIIllIIIllIIllIl = llllllllllllllIlIIIllIIIllIIlIIl.colors[llllllllllllllIlIIIllIIIlllIIlIl + llllllllllllllIlIIIllIIIlllIIIll * 128];
                                    final byte llllllllllllllIlIIIllIIIllIIllII = (byte)(llllllllllllllIlIIIllIIIllIIlllI.colorIndex * 4 + llllllllllllllIlIIIllIIIllIIllll);
                                    if (llllllllllllllIlIIIllIIIllIIllIl != llllllllllllllIlIIIllIIIllIIllII) {
                                        llllllllllllllIlIIIllIIIllIIlIIl.colors[llllllllllllllIlIIIllIIIlllIIlIl + llllllllllllllIlIIIllIIIlllIIIll * 128] = llllllllllllllIlIIIllIIIllIIllII;
                                        llllllllllllllIlIIIllIIIllIIlIIl.func_176053_a(llllllllllllllIlIIIllIIIlllIIlIl, llllllllllllllIlIIIllIIIlllIIIll);
                                        llllllllllllllIlIIIllIIIlllIIllI = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static MapData loadMapData(final int llllllllllllllIlIIIllIIlIIlIIllI, final World llllllllllllllIlIIIllIIlIIlIIIIl) {
        final String llllllllllllllIlIIIllIIlIIlIIlII = String.valueOf(new StringBuilder("map_").append(llllllllllllllIlIIIllIIlIIlIIllI));
        MapData llllllllllllllIlIIIllIIlIIlIIIll = (MapData)llllllllllllllIlIIIllIIlIIlIIIIl.loadItemData(MapData.class, llllllllllllllIlIIIllIIlIIlIIlII);
        if (llllllllllllllIlIIIllIIlIIlIIIll == null) {
            llllllllllllllIlIIIllIIlIIlIIIll = new MapData(llllllllllllllIlIIIllIIlIIlIIlII);
            llllllllllllllIlIIIllIIlIIlIIIIl.setItemData(llllllllllllllIlIIIllIIlIIlIIlII, llllllllllllllIlIIIllIIlIIlIIIll);
        }
        return llllllllllllllIlIIIllIIlIIlIIIll;
    }
    
    @Override
    public void onCreated(final ItemStack llllllllllllllIlIIIllIIIIllllIll, final World llllllllllllllIlIIIllIIIIlllIlIl, final EntityPlayer llllllllllllllIlIIIllIIIIllllIIl) {
        if (llllllllllllllIlIIIllIIIIllllIll.hasTagCompound() && llllllllllllllIlIIIllIIIIllllIll.getTagCompound().getBoolean("map_is_scaling")) {
            final MapData llllllllllllllIlIIIllIIIIllllIII = Items.filled_map.getMapData(llllllllllllllIlIIIllIIIIllllIll, llllllllllllllIlIIIllIIIIlllIlIl);
            llllllllllllllIlIIIllIIIIllllIll.setItemDamage(llllllllllllllIlIIIllIIIIlllIlIl.getUniqueDataId("map"));
            final MapData llllllllllllllIlIIIllIIIIlllIlll = new MapData(String.valueOf(new StringBuilder("map_").append(llllllllllllllIlIIIllIIIIllllIll.getMetadata())));
            llllllllllllllIlIIIllIIIIlllIlll.scale = (byte)(llllllllllllllIlIIIllIIIIllllIII.scale + 1);
            if (llllllllllllllIlIIIllIIIIlllIlll.scale > 4) {
                llllllllllllllIlIIIllIIIIlllIlll.scale = 4;
            }
            llllllllllllllIlIIIllIIIIlllIlll.func_176054_a(llllllllllllllIlIIIllIIIIllllIII.xCenter, llllllllllllllIlIIIllIIIIllllIII.zCenter, llllllllllllllIlIIIllIIIIlllIlll.scale);
            llllllllllllllIlIIIllIIIIlllIlll.dimension = llllllllllllllIlIIIllIIIIllllIII.dimension;
            llllllllllllllIlIIIllIIIIlllIlll.markDirty();
            llllllllllllllIlIIIllIIIIlllIlIl.setItemData(String.valueOf(new StringBuilder("map_").append(llllllllllllllIlIIIllIIIIllllIll.getMetadata())), llllllllllllllIlIIIllIIIIlllIlll);
        }
    }
    
    protected ItemMap() {
        this.setHasSubtypes(true);
    }
    
    @Override
    public Packet createMapDataPacket(final ItemStack llllllllllllllIlIIIllIIIlIIlIIII, final World llllllllllllllIlIIIllIIIlIIIlIll, final EntityPlayer llllllllllllllIlIIIllIIIlIIIlIlI) {
        return this.getMapData(llllllllllllllIlIIIllIIIlIIlIIII, llllllllllllllIlIIIllIIIlIIIlIll).func_176052_a(llllllllllllllIlIIIllIIIlIIlIIII, llllllllllllllIlIIIllIIIlIIIlIll, llllllllllllllIlIIIllIIIlIIIlIlI);
    }
    
    public MapData getMapData(final ItemStack llllllllllllllIlIIIllIIlIIIlIlIl, final World llllllllllllllIlIIIllIIlIIIlIlII) {
        String llllllllllllllIlIIIllIIlIIIlIlll = String.valueOf(new StringBuilder("map_").append(llllllllllllllIlIIIllIIlIIIlIlIl.getMetadata()));
        MapData llllllllllllllIlIIIllIIlIIIlIllI = (MapData)llllllllllllllIlIIIllIIlIIIlIlII.loadItemData(MapData.class, llllllllllllllIlIIIllIIlIIIlIlll);
        if (llllllllllllllIlIIIllIIlIIIlIllI == null && !llllllllllllllIlIIIllIIlIIIlIlII.isRemote) {
            llllllllllllllIlIIIllIIlIIIlIlIl.setItemDamage(llllllllllllllIlIIIllIIlIIIlIlII.getUniqueDataId("map"));
            llllllllllllllIlIIIllIIlIIIlIlll = String.valueOf(new StringBuilder("map_").append(llllllllllllllIlIIIllIIlIIIlIlIl.getMetadata()));
            llllllllllllllIlIIIllIIlIIIlIllI = new MapData(llllllllllllllIlIIIllIIlIIIlIlll);
            llllllllllllllIlIIIllIIlIIIlIllI.scale = 3;
            llllllllllllllIlIIIllIIlIIIlIllI.func_176054_a(llllllllllllllIlIIIllIIlIIIlIlII.getWorldInfo().getSpawnX(), llllllllllllllIlIIIllIIlIIIlIlII.getWorldInfo().getSpawnZ(), llllllllllllllIlIIIllIIlIIIlIllI.scale);
            llllllllllllllIlIIIllIIlIIIlIllI.dimension = (byte)llllllllllllllIlIIIllIIlIIIlIlII.provider.getDimensionId();
            llllllllllllllIlIIIllIIlIIIlIllI.markDirty();
            llllllllllllllIlIIIllIIlIIIlIlII.setItemData(llllllllllllllIlIIIllIIlIIIlIlll, llllllllllllllIlIIIllIIlIIIlIllI);
        }
        return llllllllllllllIlIIIllIIlIIIlIllI;
    }
    
    @Override
    public void addInformation(final ItemStack llllllllllllllIlIIIllIIIIllIIIlI, final EntityPlayer llllllllllllllIlIIIllIIIIllIIIIl, final List llllllllllllllIlIIIllIIIIlIllIlI, final boolean llllllllllllllIlIIIllIIIIlIlllll) {
        final MapData llllllllllllllIlIIIllIIIIlIllllI = this.getMapData(llllllllllllllIlIIIllIIIIllIIIlI, llllllllllllllIlIIIllIIIIllIIIIl.worldObj);
        if (llllllllllllllIlIIIllIIIIlIlllll) {
            if (llllllllllllllIlIIIllIIIIlIllllI == null) {
                llllllllllllllIlIIIllIIIIlIllIlI.add("Unknown map");
            }
            else {
                llllllllllllllIlIIIllIIIIlIllIlI.add(String.valueOf(new StringBuilder("Scaling at 1:").append(1 << llllllllllllllIlIIIllIIIIlIllllI.scale)));
                llllllllllllllIlIIIllIIIIlIllIlI.add(String.valueOf(new StringBuilder("(Level ").append(llllllllllllllIlIIIllIIIIlIllllI.scale).append("/").append(4).append(")")));
            }
        }
    }
    
    static {
        __OBFID = "CL_00000047";
    }
    
    @Override
    public void onUpdate(final ItemStack llllllllllllllIlIIIllIIIlIIllIll, final World llllllllllllllIlIIIllIIIlIlIIIlI, final Entity llllllllllllllIlIIIllIIIlIIllIIl, final int llllllllllllllIlIIIllIIIlIlIIIII, final boolean llllllllllllllIlIIIllIIIlIIllIII) {
        if (!llllllllllllllIlIIIllIIIlIlIIIlI.isRemote) {
            final MapData llllllllllllllIlIIIllIIIlIIllllI = this.getMapData(llllllllllllllIlIIIllIIIlIIllIll, llllllllllllllIlIIIllIIIlIlIIIlI);
            if (llllllllllllllIlIIIllIIIlIIllIIl instanceof EntityPlayer) {
                final EntityPlayer llllllllllllllIlIIIllIIIlIIlllIl = (EntityPlayer)llllllllllllllIlIIIllIIIlIIllIIl;
                llllllllllllllIlIIIllIIIlIIllllI.updateVisiblePlayers(llllllllllllllIlIIIllIIIlIIlllIl, llllllllllllllIlIIIllIIIlIIllIll);
            }
            if (llllllllllllllIlIIIllIIIlIIllIII) {
                this.updateMapData(llllllllllllllIlIIIllIIIlIlIIIlI, llllllllllllllIlIIIllIIIlIIllIIl, llllllllllllllIlIIIllIIIlIIllllI);
            }
        }
    }
}
