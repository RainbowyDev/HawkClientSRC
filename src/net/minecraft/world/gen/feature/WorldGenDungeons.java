package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.inventory.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.tileentity.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;

public class WorldGenDungeons extends WorldGenerator
{
    private static final /* synthetic */ Logger field_175918_a;
    private static final /* synthetic */ String[] SPAWNERTYPES;
    private static final /* synthetic */ List CHESTCONTENT;
    
    private String pickMobSpawner(final Random lllllllllllllllllIIlIlllIllIIlll) {
        return WorldGenDungeons.SPAWNERTYPES[lllllllllllllllllIIlIlllIllIIlll.nextInt(WorldGenDungeons.SPAWNERTYPES.length)];
    }
    
    @Override
    public boolean generate(final World lllllllllllllllllIIlIllllIlIIIll, final Random lllllllllllllllllIIlIllllIIIIIII, final BlockPos lllllllllllllllllIIlIlllIlllllll) {
        final boolean lllllllllllllllllIIlIllllIlIIIII = true;
        final int lllllllllllllllllIIlIllllIIlllll = lllllllllllllllllIIlIllllIIIIIII.nextInt(2) + 2;
        final int lllllllllllllllllIIlIllllIIllllI = -lllllllllllllllllIIlIllllIIlllll - 1;
        final int lllllllllllllllllIIlIllllIIlllIl = lllllllllllllllllIIlIllllIIlllll + 1;
        final boolean lllllllllllllllllIIlIllllIIlllII = true;
        final boolean lllllllllllllllllIIlIllllIIllIll = true;
        final int lllllllllllllllllIIlIllllIIllIlI = lllllllllllllllllIIlIllllIIIIIII.nextInt(2) + 2;
        final int lllllllllllllllllIIlIllllIIllIIl = -lllllllllllllllllIIlIllllIIllIlI - 1;
        final int lllllllllllllllllIIlIllllIIllIII = lllllllllllllllllIIlIllllIIllIlI + 1;
        int lllllllllllllllllIIlIllllIIlIlll = 0;
        for (int lllllllllllllllllIIlIllllIIlIllI = lllllllllllllllllIIlIllllIIllllI; lllllllllllllllllIIlIllllIIlIllI <= lllllllllllllllllIIlIllllIIlllIl; ++lllllllllllllllllIIlIllllIIlIllI) {
            for (int lllllllllllllllllIIlIllllIIlIlIl = -1; lllllllllllllllllIIlIllllIIlIlIl <= 4; ++lllllllllllllllllIIlIllllIIlIlIl) {
                for (int lllllllllllllllllIIlIllllIIlIIlI = lllllllllllllllllIIlIllllIIllIIl; lllllllllllllllllIIlIllllIIlIIlI <= lllllllllllllllllIIlIllllIIllIII; ++lllllllllllllllllIIlIllllIIlIIlI) {
                    final BlockPos lllllllllllllllllIIlIllllIIIllll = lllllllllllllllllIIlIlllIlllllll.add(lllllllllllllllllIIlIllllIIlIllI, lllllllllllllllllIIlIllllIIlIlIl, lllllllllllllllllIIlIllllIIlIIlI);
                    final Material lllllllllllllllllIIlIllllIIIllIl = lllllllllllllllllIIlIllllIlIIIll.getBlockState(lllllllllllllllllIIlIllllIIIllll).getBlock().getMaterial();
                    final boolean lllllllllllllllllIIlIllllIIIllII = lllllllllllllllllIIlIllllIIIllIl.isSolid();
                    if (lllllllllllllllllIIlIllllIIlIlIl == -1 && !lllllllllllllllllIIlIllllIIIllII) {
                        return false;
                    }
                    if (lllllllllllllllllIIlIllllIIlIlIl == 4 && !lllllllllllllllllIIlIllllIIIllII) {
                        return false;
                    }
                    if ((lllllllllllllllllIIlIllllIIlIllI == lllllllllllllllllIIlIllllIIllllI || lllllllllllllllllIIlIllllIIlIllI == lllllllllllllllllIIlIllllIIlllIl || lllllllllllllllllIIlIllllIIlIIlI == lllllllllllllllllIIlIllllIIllIIl || lllllllllllllllllIIlIllllIIlIIlI == lllllllllllllllllIIlIllllIIllIII) && lllllllllllllllllIIlIllllIIlIlIl == 0 && lllllllllllllllllIIlIllllIlIIIll.isAirBlock(lllllllllllllllllIIlIllllIIIllll) && lllllllllllllllllIIlIllllIlIIIll.isAirBlock(lllllllllllllllllIIlIllllIIIllll.offsetUp())) {
                        ++lllllllllllllllllIIlIllllIIlIlll;
                    }
                }
            }
        }
        if (lllllllllllllllllIIlIllllIIlIlll >= 1 && lllllllllllllllllIIlIllllIIlIlll <= 5) {
            for (int lllllllllllllllllIIlIllllIIlIllI = lllllllllllllllllIIlIllllIIllllI; lllllllllllllllllIIlIllllIIlIllI <= lllllllllllllllllIIlIllllIIlllIl; ++lllllllllllllllllIIlIllllIIlIllI) {
                for (int lllllllllllllllllIIlIllllIIlIlII = 3; lllllllllllllllllIIlIllllIIlIlII >= -1; --lllllllllllllllllIIlIllllIIlIlII) {
                    for (int lllllllllllllllllIIlIllllIIlIIIl = lllllllllllllllllIIlIllllIIllIIl; lllllllllllllllllIIlIllllIIlIIIl <= lllllllllllllllllIIlIllllIIllIII; ++lllllllllllllllllIIlIllllIIlIIIl) {
                        final BlockPos lllllllllllllllllIIlIllllIIIlllI = lllllllllllllllllIIlIlllIlllllll.add(lllllllllllllllllIIlIllllIIlIllI, lllllllllllllllllIIlIllllIIlIlII, lllllllllllllllllIIlIllllIIlIIIl);
                        if (lllllllllllllllllIIlIllllIIlIllI != lllllllllllllllllIIlIllllIIllllI && lllllllllllllllllIIlIllllIIlIlII != -1 && lllllllllllllllllIIlIllllIIlIIIl != lllllllllllllllllIIlIllllIIllIIl && lllllllllllllllllIIlIllllIIlIllI != lllllllllllllllllIIlIllllIIlllIl && lllllllllllllllllIIlIllllIIlIlII != 4 && lllllllllllllllllIIlIllllIIlIIIl != lllllllllllllllllIIlIllllIIllIII) {
                            if (lllllllllllllllllIIlIllllIlIIIll.getBlockState(lllllllllllllllllIIlIllllIIIlllI).getBlock() != Blocks.chest) {
                                lllllllllllllllllIIlIllllIlIIIll.setBlockToAir(lllllllllllllllllIIlIllllIIIlllI);
                            }
                        }
                        else if (lllllllllllllllllIIlIllllIIIlllI.getY() >= 0 && !lllllllllllllllllIIlIllllIlIIIll.getBlockState(lllllllllllllllllIIlIllllIIIlllI.offsetDown()).getBlock().getMaterial().isSolid()) {
                            lllllllllllllllllIIlIllllIlIIIll.setBlockToAir(lllllllllllllllllIIlIllllIIIlllI);
                        }
                        else if (lllllllllllllllllIIlIllllIlIIIll.getBlockState(lllllllllllllllllIIlIllllIIIlllI).getBlock().getMaterial().isSolid() && lllllllllllllllllIIlIllllIlIIIll.getBlockState(lllllllllllllllllIIlIllllIIIlllI).getBlock() != Blocks.chest) {
                            if (lllllllllllllllllIIlIllllIIlIlII == -1 && lllllllllllllllllIIlIllllIIIIIII.nextInt(4) != 0) {
                                lllllllllllllllllIIlIllllIlIIIll.setBlockState(lllllllllllllllllIIlIllllIIIlllI, Blocks.mossy_cobblestone.getDefaultState(), 2);
                            }
                            else {
                                lllllllllllllllllIIlIllllIlIIIll.setBlockState(lllllllllllllllllIIlIllllIIIlllI, Blocks.cobblestone.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
            for (int lllllllllllllllllIIlIllllIIlIllI = 0; lllllllllllllllllIIlIllllIIlIllI < 2; ++lllllllllllllllllIIlIllllIIlIllI) {
                for (int lllllllllllllllllIIlIllllIIlIIll = 0; lllllllllllllllllIIlIllllIIlIIll < 3; ++lllllllllllllllllIIlIllllIIlIIll) {
                    final int lllllllllllllllllIIlIllllIIlIIII = lllllllllllllllllIIlIlllIlllllll.getX() + lllllllllllllllllIIlIllllIIIIIII.nextInt(lllllllllllllllllIIlIllllIIlllll * 2 + 1) - lllllllllllllllllIIlIllllIIlllll;
                    final int lllllllllllllllllIIlIllllIIIlIll = lllllllllllllllllIIlIlllIlllllll.getY();
                    final int lllllllllllllllllIIlIllllIIIlIlI = lllllllllllllllllIIlIlllIlllllll.getZ() + lllllllllllllllllIIlIllllIIIIIII.nextInt(lllllllllllllllllIIlIllllIIllIlI * 2 + 1) - lllllllllllllllllIIlIllllIIllIlI;
                    final BlockPos lllllllllllllllllIIlIllllIIIlIIl = new BlockPos(lllllllllllllllllIIlIllllIIlIIII, lllllllllllllllllIIlIllllIIIlIll, lllllllllllllllllIIlIllllIIIlIlI);
                    if (lllllllllllllllllIIlIllllIlIIIll.isAirBlock(lllllllllllllllllIIlIllllIIIlIIl)) {
                        int lllllllllllllllllIIlIllllIIIlIII = 0;
                        for (final EnumFacing lllllllllllllllllIIlIllllIIIIllI : EnumFacing.Plane.HORIZONTAL) {
                            if (lllllllllllllllllIIlIllllIlIIIll.getBlockState(lllllllllllllllllIIlIllllIIIlIIl.offset(lllllllllllllllllIIlIllllIIIIllI)).getBlock().getMaterial().isSolid()) {
                                ++lllllllllllllllllIIlIllllIIIlIII;
                            }
                        }
                        if (lllllllllllllllllIIlIllllIIIlIII == 1) {
                            lllllllllllllllllIIlIllllIlIIIll.setBlockState(lllllllllllllllllIIlIllllIIIlIIl, Blocks.chest.func_176458_f(lllllllllllllllllIIlIllllIlIIIll, lllllllllllllllllIIlIllllIIIlIIl, Blocks.chest.getDefaultState()), 2);
                            final List lllllllllllllllllIIlIllllIIIIlIl = WeightedRandomChestContent.func_177629_a(WorldGenDungeons.CHESTCONTENT, Items.enchanted_book.getRandomEnchantedBook(lllllllllllllllllIIlIllllIIIIIII));
                            final TileEntity lllllllllllllllllIIlIllllIIIIlII = lllllllllllllllllIIlIllllIlIIIll.getTileEntity(lllllllllllllllllIIlIllllIIIlIIl);
                            if (lllllllllllllllllIIlIllllIIIIlII instanceof TileEntityChest) {
                                WeightedRandomChestContent.generateChestContents(lllllllllllllllllIIlIllllIIIIIII, lllllllllllllllllIIlIllllIIIIlIl, (IInventory)lllllllllllllllllIIlIllllIIIIlII, 8);
                                break;
                            }
                            break;
                        }
                    }
                }
            }
            lllllllllllllllllIIlIllllIlIIIll.setBlockState(lllllllllllllllllIIlIlllIlllllll, Blocks.mob_spawner.getDefaultState(), 2);
            final TileEntity lllllllllllllllllIIlIllllIIIIIll = lllllllllllllllllIIlIllllIlIIIll.getTileEntity(lllllllllllllllllIIlIlllIlllllll);
            if (lllllllllllllllllIIlIllllIIIIIll instanceof TileEntityMobSpawner) {
                ((TileEntityMobSpawner)lllllllllllllllllIIlIllllIIIIIll).getSpawnerBaseLogic().setEntityName(this.pickMobSpawner(lllllllllllllllllIIlIllllIIIIIII));
            }
            else {
                WorldGenDungeons.field_175918_a.error(String.valueOf(new StringBuilder("Failed to fetch mob spawner entity at (").append(lllllllllllllllllIIlIlllIlllllll.getX()).append(", ").append(lllllllllllllllllIIlIlllIlllllll.getY()).append(", ").append(lllllllllllllllllIIlIlllIlllllll.getZ()).append(")")));
            }
            return true;
        }
        return false;
    }
    
    static {
        __OBFID = "CL_00000425";
        field_175918_a = LogManager.getLogger();
        SPAWNERTYPES = new String[] { "Skeleton", "Zombie", "Zombie", "Spider" };
        CHESTCONTENT = Lists.newArrayList((Object[])new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 10), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 4, 10), new WeightedRandomChestContent(Items.bread, 0, 1, 1, 10), new WeightedRandomChestContent(Items.wheat, 0, 1, 4, 10), new WeightedRandomChestContent(Items.gunpowder, 0, 1, 4, 10), new WeightedRandomChestContent(Items.string, 0, 1, 4, 10), new WeightedRandomChestContent(Items.bucket, 0, 1, 1, 10), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 1), new WeightedRandomChestContent(Items.redstone, 0, 1, 4, 10), new WeightedRandomChestContent(Items.record_13, 0, 1, 1, 4), new WeightedRandomChestContent(Items.record_cat, 0, 1, 1, 4), new WeightedRandomChestContent(Items.name_tag, 0, 1, 1, 10), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 2), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1) });
    }
}
