package hawk.modules.player;

import hawk.modules.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import java.util.*;
import hawk.events.*;
import hawk.util.*;
import hawk.events.listeners.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.util.*;

public class Scaffold extends Module
{
    private final /* synthetic */ List validBlocks;
    private final /* synthetic */ Random rng;
    private final /* synthetic */ List invalidBlocks;
    private final /* synthetic */ EnumFacing[] facings;
    public /* synthetic */ boolean rel;
    private final /* synthetic */ BlockPos[] blockPositions;
    private /* synthetic */ int slot;
    private /* synthetic */ float[] angles;
    
    public Scaffold() {
        super("Scaffold", 46, Category.MOVEMENT);
        this.rel = false;
        this.invalidBlocks = Arrays.asList(Blocks.enchanting_table, Blocks.furnace, Blocks.carpet, Blocks.crafting_table, Blocks.trapped_chest, Blocks.chest, Blocks.dispenser, Blocks.air, Blocks.water, Blocks.lava, Blocks.flowing_water, Blocks.flowing_lava, Blocks.sand, Blocks.snow_layer, Blocks.torch, Blocks.anvil, Blocks.jukebox, Blocks.stone_button, Blocks.wooden_button, Blocks.lever, Blocks.noteblock, Blocks.stone_pressure_plate, Blocks.light_weighted_pressure_plate, Blocks.wooden_pressure_plate, Blocks.heavy_weighted_pressure_plate, Blocks.stone_slab, Blocks.wooden_slab, Blocks.stone_slab2, Blocks.red_mushroom, Blocks.brown_mushroom, Blocks.yellow_flower, Blocks.red_flower, Blocks.anvil, Blocks.glass_pane, Blocks.stained_glass_pane, Blocks.iron_bars, Blocks.cactus, Blocks.ladder, Blocks.web);
        this.validBlocks = Arrays.asList(Blocks.air, Blocks.water, Blocks.flowing_water, Blocks.lava, Blocks.flowing_lava);
        this.blockPositions = new BlockPos[] { new BlockPos(-1, 0, 0), new BlockPos(1, 0, 0), new BlockPos(0, 0, -1) };
        this.facings = new EnumFacing[] { EnumFacing.EAST, EnumFacing.WEST, EnumFacing.SOUTH, EnumFacing.NORTH };
        this.rng = new Random();
        this.angles = new float[2];
    }
    
    @Override
    public void onEnable() {
        this.slot = this.mc.thePlayer.inventory.currentItem;
    }
    
    private Vec3 getVec3(final BlockUtils2.BlockData lllllllllllllllIlllllIlIllIIlIll) {
        final BlockPos lllllllllllllllIlllllIlIllIlIIIl = lllllllllllllllIlllllIlIllIIlIll.position;
        final EnumFacing lllllllllllllllIlllllIlIllIlIIII = lllllllllllllllIlllllIlIllIIlIll.face;
        double lllllllllllllllIlllllIlIllIIllll = lllllllllllllllIlllllIlIllIlIIIl.getX() + 0.5;
        double lllllllllllllllIlllllIlIllIIlllI = lllllllllllllllIlllllIlIllIlIIIl.getY() + 0.5;
        double lllllllllllllllIlllllIlIllIIllIl = lllllllllllllllIlllllIlIllIlIIIl.getZ() + 0.5;
        lllllllllllllllIlllllIlIllIIllll += lllllllllllllllIlllllIlIllIlIIII.getFrontOffsetX() / 2.0;
        lllllllllllllllIlllllIlIllIIllIl += lllllllllllllllIlllllIlIllIlIIII.getFrontOffsetZ() / 2.0;
        lllllllllllllllIlllllIlIllIIlllI += lllllllllllllllIlllllIlIllIlIIII.getFrontOffsetY() / 2.0;
        if (lllllllllllllllIlllllIlIllIlIIII != EnumFacing.UP && lllllllllllllllIlllllIlIllIlIIII != EnumFacing.DOWN) {
            lllllllllllllllIlllllIlIllIIlllI += this.randomNumber(0.49, 0.5);
        }
        else {
            lllllllllllllllIlllllIlIllIIllll += this.randomNumber(0.3, -0.3);
            lllllllllllllllIlllllIlIllIIllIl += this.randomNumber(0.3, -0.3);
        }
        if (lllllllllllllllIlllllIlIllIlIIII == EnumFacing.WEST || lllllllllllllllIlllllIlIllIlIIII == EnumFacing.EAST) {
            lllllllllllllllIlllllIlIllIIllIl += this.randomNumber(0.3, -0.3);
        }
        if (lllllllllllllllIlllllIlIllIlIIII == EnumFacing.SOUTH || lllllllllllllllIlllllIlIllIlIIII == EnumFacing.NORTH) {
            lllllllllllllllIlllllIlIllIIllll += this.randomNumber(0.3, -0.3);
        }
        return new Vec3(lllllllllllllllIlllllIlIllIIllll, lllllllllllllllIlllllIlIllIIlllI, lllllllllllllllIlllllIlIllIIllIl);
    }
    
    @Override
    public void onEvent(final Event lllllllllllllllIlllllIlIllllIIIl) {
        if (lllllllllllllllIlllllIlIllllIIIl instanceof EventMotion) {
            final EventMotion lllllllllllllllIlllllIlIllllIIII = (EventMotion)lllllllllllllllIlllllIlIllllIIIl;
            final EntityPlayerSP lllllllllllllllIlllllIlIlllIllll = this.mc.thePlayer;
            final WorldClient lllllllllllllllIlllllIlIlllIlllI = this.mc.theWorld;
            double lllllllllllllllIlllllIlIlllIllIl = 1.0;
            BlockUtils2.BlockData lllllllllllllllIlllllIlIlllIllII = null;
            for (double lllllllllllllllIlllllIlIlllIlIll = lllllllllllllllIlllllIlIlllIllll.posY - 1.0; lllllllllllllllIlllllIlIlllIlIll > 0.0; --lllllllllllllllIlllllIlIlllIlIll) {
                final BlockUtils2.BlockData lllllllllllllllIlllllIlIlllIlIlI = this.getBlockData(new BlockPos(lllllllllllllllIlllllIlIlllIllll.posX, lllllllllllllllIlllllIlIlllIlIll, lllllllllllllllIlllllIlIlllIllll.posZ));
                if (lllllllllllllllIlllllIlIlllIlIlI != null) {
                    lllllllllllllllIlllllIlIlllIllIl = lllllllllllllllIlllllIlIlllIllll.posY - lllllllllllllllIlllllIlIlllIlIll;
                    if (lllllllllllllllIlllllIlIlllIllIl <= 3.0) {
                        lllllllllllllllIlllllIlIlllIllII = lllllllllllllllIlllllIlIlllIlIlI;
                        break;
                    }
                }
            }
            final float[] lllllllllllllllIlllllIlIlllIlIIl = RotationUtils.getRotationFromPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ);
            if (lllllllllllllllIlllllIlIlllIllII != null) {
                final BlockPos lllllllllllllllIlllllIlIlllIlIII = lllllllllllllllIlllllIlIlllIllII.position;
                final Block lllllllllllllllIlllllIlIlllIIlll = lllllllllllllllIlllllIlIlllIlllI.getBlockState(lllllllllllllllIlllllIlIlllIlIII.offset(lllllllllllllllIlllllIlIlllIllII.face)).getBlock();
                final Vec3 lllllllllllllllIlllllIlIlllIIllI = this.getVec3(lllllllllllllllIlllllIlIlllIllII);
                this.mc.playerController.func_178890_a(lllllllllllllllIlllllIlIlllIllll, lllllllllllllllIlllllIlIlllIlllI, lllllllllllllllIlllllIlIlllIllll.getCurrentEquippedItem(), lllllllllllllllIlllllIlIlllIlIII, lllllllllllllllIlllllIlIlllIllII.face, lllllllllllllllIlllllIlIlllIIllI);
                this.mc.playerController.func_178890_a(lllllllllllllllIlllllIlIlllIllll, lllllllllllllllIlllllIlIlllIlllI, lllllllllllllllIlllllIlIlllIllll.getCurrentEquippedItem(), lllllllllllllllIlllllIlIlllIlIII, lllllllllllllllIlllllIlIlllIllII.face, lllllllllllllllIlllllIlIlllIIllI);
                this.mc.playerController.func_178890_a(lllllllllllllllIlllllIlIlllIllll, lllllllllllllllIlllllIlIlllIlllI, lllllllllllllllIlllllIlIlllIllll.getCurrentEquippedItem(), lllllllllllllllIlllllIlIlllIlIII, lllllllllllllllIlllllIlIlllIllII.face, lllllllllllllllIlllllIlIlllIIllI);
                this.mc.thePlayer.setPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ);
            }
        }
        if (lllllllllllllllIlllllIlIllllIIIl instanceof EventUpdate) {
            this.mc.timer.timerSpeed = 1.1f;
        }
    }
    
    private double randomNumber(final double lllllllllllllllIlllllIlIllIIIIII, final double lllllllllllllllIlllllIlIlIllllll) {
        return Math.random() * (lllllllllllllllIlllllIlIllIIIIII - lllllllllllllllIlllllIlIlIllllll) + lllllllllllllllIlllllIlIlIllllll;
    }
    
    private BlockUtils2.BlockData getBlockData(final BlockPos lllllllllllllllIlllllIlIlIllIIII) {
        final BlockPos[] lllllllllllllllIlllllIlIlIlIllll = this.blockPositions;
        final EnumFacing[] lllllllllllllllIlllllIlIlIlIlllI = this.facings;
        final WorldClient lllllllllllllllIlllllIlIlIlIllIl = this.mc.theWorld;
        final BlockPos lllllllllllllllIlllllIlIlIlIllII = new BlockPos(0, -1, 0);
        final List lllllllllllllllIlllllIlIlIlIlIll = this.validBlocks;
        if (!lllllllllllllllIlllllIlIlIlIlIll.contains(lllllllllllllllIlllllIlIlIlIllIl.getBlockState(lllllllllllllllIlllllIlIlIllIIII.add(lllllllllllllllIlllllIlIlIlIllII)).getBlock())) {
            return new BlockUtils2.BlockData(lllllllllllllllIlllllIlIlIllIIII.add(lllllllllllllllIlllllIlIlIlIllII), EnumFacing.UP);
        }
        for (int lllllllllllllllIlllllIlIlIlIlIlI = 0, lllllllllllllllIlllllIlIlIlIlIIl = lllllllllllllllIlllllIlIlIlIllll.length; lllllllllllllllIlllllIlIlIlIlIlI < lllllllllllllllIlllllIlIlIlIlIIl; ++lllllllllllllllIlllllIlIlIlIlIlI) {
            final BlockPos lllllllllllllllIlllllIlIlIlIlIII = lllllllllllllllIlllllIlIlIllIIII.add(lllllllllllllllIlllllIlIlIlIllll[lllllllllllllllIlllllIlIlIlIlIlI]);
            if (!lllllllllllllllIlllllIlIlIlIlIll.contains(lllllllllllllllIlllllIlIlIlIllIl.getBlockState(lllllllllllllllIlllllIlIlIlIlIII).getBlock())) {
                return new BlockUtils2.BlockData(lllllllllllllllIlllllIlIlIlIlIII, lllllllllllllllIlllllIlIlIlIlllI[lllllllllllllllIlllllIlIlIlIlIlI]);
            }
            for (int lllllllllllllllIlllllIlIlIlIIlll = 0; lllllllllllllllIlllllIlIlIlIIlll < lllllllllllllllIlllllIlIlIlIlIIl; ++lllllllllllllllIlllllIlIlIlIIlll) {
                final BlockPos lllllllllllllllIlllllIlIlIlIIllI = lllllllllllllllIlllllIlIlIllIIII.add(lllllllllllllllIlllllIlIlIlIllll[lllllllllllllllIlllllIlIlIlIIlll]);
                final BlockPos lllllllllllllllIlllllIlIlIlIIlIl = lllllllllllllllIlllllIlIlIlIlIII.add(lllllllllllllllIlllllIlIlIlIllll[lllllllllllllllIlllllIlIlIlIIlll]);
                if (!lllllllllllllllIlllllIlIlIlIlIll.contains(lllllllllllllllIlllllIlIlIlIllIl.getBlockState(lllllllllllllllIlllllIlIlIlIIllI).getBlock())) {
                    return new BlockUtils2.BlockData(lllllllllllllllIlllllIlIlIlIIllI, lllllllllllllllIlllllIlIlIlIlllI[lllllllllllllllIlllllIlIlIlIIlll]);
                }
                if (!lllllllllllllllIlllllIlIlIlIlIll.contains(lllllllllllllllIlllllIlIlIlIllIl.getBlockState(lllllllllllllllIlllllIlIlIlIIlIl).getBlock())) {
                    return new BlockUtils2.BlockData(lllllllllllllllIlllllIlIlIlIIlIl, lllllllllllllllIlllllIlIlIlIlllI[lllllllllllllllIlllllIlIlIlIIlll]);
                }
            }
        }
        return null;
    }
    
    @Override
    public void onDisable() {
        this.mc.thePlayer.inventory.currentItem = this.slot;
        this.mc.gameSettings.keyBindUseItem.pressed = false;
        this.mc.timer.timerSpeed = 1.0f;
    }
}
