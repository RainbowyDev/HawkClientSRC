package net.minecraft.block;

import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.stats.*;
import net.minecraft.enchantment.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.item.*;

public class Block
{
    private static final /* synthetic */ ResourceLocation AIR_ID;
    protected /* synthetic */ double maxY;
    public static final /* synthetic */ RegistryNamespacedDefaultedByKey blockRegistry;
    public static final /* synthetic */ SoundType soundTypeGrass;
    public static final /* synthetic */ SoundType soundTypeGravel;
    public static final /* synthetic */ SoundType soundTypeLadder;
    protected /* synthetic */ double minZ;
    public static final /* synthetic */ SoundType soundTypeGlass;
    public /* synthetic */ SoundType stepSound;
    protected /* synthetic */ float blockResistance;
    public static final /* synthetic */ ObjectIntIdentityMap BLOCK_STATE_IDS;
    private /* synthetic */ String unlocalizedName;
    public static final /* synthetic */ SoundType soundTypeStone;
    protected /* synthetic */ boolean isBlockContainer;
    public /* synthetic */ float blockParticleGravity;
    protected /* synthetic */ double maxZ;
    private /* synthetic */ IBlockState defaultBlockState;
    protected /* synthetic */ int lightValue;
    public static final /* synthetic */ SoundType soundTypeCloth;
    protected /* synthetic */ double maxX;
    public /* synthetic */ float slipperiness;
    public static final /* synthetic */ SoundType soundTypeAnvil;
    protected /* synthetic */ boolean useNeighborBrightness;
    protected /* synthetic */ boolean needsRandomTick;
    private /* synthetic */ CreativeTabs displayOnCreativeTab;
    protected /* synthetic */ double minY;
    protected /* synthetic */ float blockHardness;
    protected /* synthetic */ boolean enableStats;
    protected /* synthetic */ boolean translucent;
    public static final /* synthetic */ SoundType soundTypeSnow;
    protected /* synthetic */ boolean fullBlock;
    public static final /* synthetic */ SoundType soundTypePiston;
    public static final /* synthetic */ SoundType soundTypeWood;
    public static final /* synthetic */ SoundType SLIME_SOUND;
    protected final /* synthetic */ Material blockMaterial;
    protected final /* synthetic */ BlockState blockState;
    public static final /* synthetic */ SoundType soundTypeSand;
    public static final /* synthetic */ SoundType soundTypeMetal;
    protected /* synthetic */ double minX;
    protected /* synthetic */ int lightOpacity;
    
    protected ItemStack createStackedBlock(final IBlockState lllllllllllllllllIlllIllIIlIlIIl) {
        int lllllllllllllllllIlllIllIIlIlIII = 0;
        final Item lllllllllllllllllIlllIllIIlIIlll = Item.getItemFromBlock(this);
        if (lllllllllllllllllIlllIllIIlIIlll != null && lllllllllllllllllIlllIllIIlIIlll.getHasSubtypes()) {
            lllllllllllllllllIlllIllIIlIlIII = this.getMetaFromState(lllllllllllllllllIlllIllIIlIlIIl);
        }
        return new ItemStack(lllllllllllllllllIlllIllIIlIIlll, 1, lllllllllllllllllIlllIllIIlIlIII);
    }
    
    public IBlockState getStateForEntityRender(final IBlockState lllllllllllllllllIlllIlIlIlIlIll) {
        return lllllllllllllllllIlllIlIlIlIlIll;
    }
    
    public boolean getTickRandomly() {
        return this.needsRandomTick;
    }
    
    public void onEntityCollidedWithBlock(final World lllllllllllllllllIlllIlllIIlIllI, final BlockPos lllllllllllllllllIlllIlllIIlIlIl, final Entity lllllllllllllllllIlllIlllIIlIlII) {
    }
    
    public void onBlockDestroyedByPlayer(final World lllllllllllllllllIllllIIIllllIlI, final BlockPos lllllllllllllllllIllllIIIllllIIl, final IBlockState lllllllllllllllllIllllIIIllllIII) {
    }
    
    public static IBlockState getStateById(final int lllllllllllllllllIllllIlIlllIlII) {
        final int lllllllllllllllllIllllIlIlllIllI = lllllllllllllllllIllllIlIlllIlII & 0xFFF;
        final int lllllllllllllllllIllllIlIlllIlIl = lllllllllllllllllIllllIlIlllIlII >> 12 & 0xF;
        return getBlockById(lllllllllllllllllIllllIlIlllIllI).getStateFromMeta(lllllllllllllllllIllllIlIlllIlIl);
    }
    
    private boolean isVecInsideXYBounds(final Vec3 lllllllllllllllllIlllIllllIIIlII) {
        return lllllllllllllllllIlllIllllIIIlII != null && (lllllllllllllllllIlllIllllIIIlII.xCoord >= this.minX && lllllllllllllllllIlllIllllIIIlII.xCoord <= this.maxX && lllllllllllllllllIlllIllllIIIlII.yCoord >= this.minY && lllllllllllllllllIlllIllllIIIlII.yCoord <= this.maxY);
    }
    
    protected Block disableStats() {
        this.enableStats = false;
        return this;
    }
    
    public int getLightValue() {
        return this.lightValue;
    }
    
    public boolean hasTileEntity() {
        return this.isBlockContainer;
    }
    
    public void getSubBlocks(final Item lllllllllllllllllIlllIlIllIlIlIl, final CreativeTabs lllllllllllllllllIlllIlIllIlIlll, final List lllllllllllllllllIlllIlIllIlIllI) {
        lllllllllllllllllIlllIlIllIlIllI.add(new ItemStack(lllllllllllllllllIlllIlIllIlIlIl, 1, 0));
    }
    
    protected final void setDefaultState(final IBlockState lllllllllllllllllIlllIlIlIIlllll) {
        this.defaultBlockState = lllllllllllllllllIlllIlIlIIlllll;
    }
    
    protected Block setHardness(final float lllllllllllllllllIllllIlIIIIlIll) {
        this.blockHardness = lllllllllllllllllIllllIlIIIIlIll;
        if (this.blockResistance < lllllllllllllllllIllllIlIIIIlIll * 5.0f) {
            this.blockResistance = lllllllllllllllllIllllIlIIIIlIll * 5.0f;
        }
        return this;
    }
    
    public int getMobilityFlag() {
        return this.blockMaterial.getMaterialMobility();
    }
    
    private boolean isVecInsideXZBounds(final Vec3 lllllllllllllllllIlllIllllIIllII) {
        return lllllllllllllllllIlllIllllIIllII != null && (lllllllllllllllllIlllIllllIIllII.xCoord >= this.minX && lllllllllllllllllIlllIllllIIllII.xCoord <= this.maxX && lllllllllllllllllIlllIllllIIllII.zCoord >= this.minZ && lllllllllllllllllIlllIllllIIllII.zCoord <= this.maxZ);
    }
    
    public int getRenderType() {
        return 3;
    }
    
    public void randomTick(final World lllllllllllllllllIllllIIlIIIlIIl, final BlockPos lllllllllllllllllIllllIIlIIIlIII, final IBlockState lllllllllllllllllIllllIIlIIIIlll, final Random lllllllllllllllllIllllIIlIIIlIll) {
        this.updateTick(lllllllllllllllllIllllIIlIIIlIIl, lllllllllllllllllIllllIIlIIIlIII, lllllllllllllllllIllllIIlIIIIlll, lllllllllllllllllIllllIIlIIIlIll);
    }
    
    public void breakBlock(final World lllllllllllllllllIllllIIIllIlIll, final BlockPos lllllllllllllllllIllllIIIllIlIlI, final IBlockState lllllllllllllllllIllllIIIllIlIIl) {
    }
    
    public boolean isAssociatedBlock(final Block lllllllllllllllllIlllIlIlIlllIll) {
        return this == lllllllllllllllllIlllIlIlIlllIll;
    }
    
    public Block setCreativeTab(final CreativeTabs lllllllllllllllllIlllIlIllIIllIl) {
        this.displayOnCreativeTab = lllllllllllllllllIlllIlIllIIllIl;
        return this;
    }
    
    public boolean isCollidable() {
        return true;
    }
    
    public boolean isSolidFullCube() {
        return this.blockMaterial.blocksMovement() && this.isFullCube();
    }
    
    public int getLightOpacity() {
        return this.lightOpacity;
    }
    
    public int quantityDroppedWithBonus(final int lllllllllllllllllIlllIllIIIlllll, final Random lllllllllllllllllIlllIllIIIlllII) {
        return this.quantityDropped(lllllllllllllllllIlllIllIIIlllII);
    }
    
    public boolean isNormalCube() {
        return this.blockMaterial.isOpaque() && this.isFullCube() && !this.canProvidePower();
    }
    
    public CreativeTabs getCreativeTabToDisplayOn() {
        return this.displayOnCreativeTab;
    }
    
    public Item getItem(final World lllllllllllllllllIlllIlIlllIIlll, final BlockPos lllllllllllllllllIlllIlIlllIIllI) {
        return Item.getItemFromBlock(this);
    }
    
    public boolean isFlowerPot() {
        return false;
    }
    
    public boolean canPlaceBlockOnSide(final World lllllllllllllllllIlllIlllIlIllIl, final BlockPos lllllllllllllllllIlllIlllIlIllII, final EnumFacing lllllllllllllllllIlllIlllIlIlIll) {
        return this.canPlaceBlockAt(lllllllllllllllllIlllIlllIlIllIl, lllllllllllllllllIlllIlllIlIllII);
    }
    
    public Vec3 modifyAcceleration(final World lllllllllllllllllIlllIlllIIIIIII, final BlockPos lllllllllllllllllIlllIllIlllllll, final Entity lllllllllllllllllIlllIllIllllllI, final Vec3 lllllllllllllllllIlllIllIlllllIl) {
        return lllllllllllllllllIlllIllIlllllIl;
    }
    
    public int damageDropped(final IBlockState lllllllllllllllllIllllIIIIIIIIIl) {
        return 0;
    }
    
    public int getDamageValue(final World lllllllllllllllllIlllIlIllIlllIl, final BlockPos lllllllllllllllllIlllIlIllIlllll) {
        return this.damageDropped(lllllllllllllllllIlllIlIllIlllIl.getBlockState(lllllllllllllllllIlllIlIllIlllll));
    }
    
    public final double getBlockBoundsMinX() {
        return this.minX;
    }
    
    protected void dropXpOnBlockBreak(final World lllllllllllllllllIllllIIIIIIlIlI, final BlockPos lllllllllllllllllIllllIIIIIIlIIl, int lllllllllllllllllIllllIIIIIIIlII) {
        if (!lllllllllllllllllIllllIIIIIIlIlI.isRemote) {
            while (lllllllllllllllllIllllIIIIIIIlII > 0) {
                final int lllllllllllllllllIllllIIIIIIIlll = EntityXPOrb.getXPSplit((int)lllllllllllllllllIllllIIIIIIIlII);
                lllllllllllllllllIllllIIIIIIIlII -= lllllllllllllllllIllllIIIIIIIlll;
                lllllllllllllllllIllllIIIIIIlIlI.spawnEntityInWorld(new EntityXPOrb(lllllllllllllllllIllllIIIIIIlIlI, lllllllllllllllllIllllIIIIIIlIIl.getX() + 0.5, lllllllllllllllllIllllIIIIIIlIIl.getY() + 0.5, lllllllllllllllllIllllIIIIIIlIIl.getZ() + 0.5, lllllllllllllllllIllllIIIIIIIlll));
            }
        }
    }
    
    public boolean isFullCube() {
        return true;
    }
    
    public float getExplosionResistance(final Entity lllllllllllllllllIlllIlllllllllI) {
        return this.blockResistance / 5.0f;
    }
    
    public int getComparatorInputOverride(final World lllllllllllllllllIlllIlIlIllIIII, final BlockPos lllllllllllllllllIlllIlIlIlIllll) {
        return 0;
    }
    
    public Item getItemDropped(final IBlockState lllllllllllllllllIllllIIIllIIlII, final Random lllllllllllllllllIllllIIIllIIIll, final int lllllllllllllllllIllllIIIllIIIlI) {
        return Item.getItemFromBlock(this);
    }
    
    public int tickRate(final World lllllllllllllllllIllllIIIlllIIIl) {
        return 10;
    }
    
    public void updateTick(final World lllllllllllllllllIllllIIlIIIIlII, final BlockPos lllllllllllllllllIllllIIlIIIIIll, final IBlockState lllllllllllllllllIllllIIlIIIIIlI, final Random lllllllllllllllllIllllIIlIIIIIIl) {
    }
    
    public boolean onBlockEventReceived(final World lllllllllllllllllIlllIllIIIIlIII, final BlockPos lllllllllllllllllIlllIllIIIIIlll, final IBlockState lllllllllllllllllIlllIllIIIIIllI, final int lllllllllllllllllIlllIllIIIIIlIl, final int lllllllllllllllllIlllIllIIIIIlII) {
        return false;
    }
    
    public final double getBlockBoundsMaxX() {
        return this.maxX;
    }
    
    public IBlockState onBlockPlaced(final World lllllllllllllllllIlllIlllIIlIIII, final BlockPos lllllllllllllllllIlllIlllIIIllll, final EnumFacing lllllllllllllllllIlllIlllIIIlllI, final float lllllllllllllllllIlllIlllIIIllIl, final float lllllllllllllllllIlllIlllIIIllII, final float lllllllllllllllllIlllIlllIIIlIll, final int lllllllllllllllllIlllIlllIIIlIlI, final EntityLivingBase lllllllllllllllllIlllIlllIIIlIIl) {
        return this.getStateFromMeta(lllllllllllllllllIlllIlllIIIlIlI);
    }
    
    public Material getMaterial() {
        return this.blockMaterial;
    }
    
    private static void registerBlock(final int lllllllllllllllllIlllIlIIlIIlIll, final String lllllllllllllllllIlllIlIIlIIlIlI, final Block lllllllllllllllllIlllIlIIlIIIllI) {
        registerBlock(lllllllllllllllllIlllIlIIlIIlIll, new ResourceLocation(lllllllllllllllllIlllIlIIlIIlIlI), lllllllllllllllllIlllIlIIlIIIllI);
    }
    
    protected Block setBlockUnbreakable() {
        this.setHardness(-1.0f);
        return this;
    }
    
    public void onNeighborBlockChange(final World lllllllllllllllllIllllIIIlllIllI, final BlockPos lllllllllllllllllIllllIIIlllIlIl, final IBlockState lllllllllllllllllIllllIIIlllIlII, final Block lllllllllllllllllIllllIIIlllIIll) {
    }
    
    public void onBlockHarvested(final World lllllllllllllllllIlllIlIllIIlIIl, final BlockPos lllllllllllllllllIlllIlIllIIlIII, final IBlockState lllllllllllllllllIlllIlIllIIIlll, final EntityPlayer lllllllllllllllllIlllIlIllIIIllI) {
    }
    
    public final double getBlockBoundsMinY() {
        return this.minY;
    }
    
    public Block setLightOpacity(final int lllllllllllllllllIllllIlIIllIIII) {
        this.lightOpacity = lllllllllllllllllIllllIlIIllIIII;
        return this;
    }
    
    public static boolean isEqualTo(final Block lllllllllllllllllIlllIlIlIllIlII, final Block lllllllllllllllllIlllIlIlIllIlIl) {
        return lllllllllllllllllIlllIlIlIllIlII != null && lllllllllllllllllIlllIlIlIllIlIl != null && (lllllllllllllllllIlllIlIlIllIlII == lllllllllllllllllIlllIlIlIllIlIl || lllllllllllllllllIlllIlIlIllIlII.isAssociatedBlock(lllllllllllllllllIlllIlIlIllIlIl));
    }
    
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.SOLID;
    }
    
    public boolean canCollideCheck(final IBlockState lllllllllllllllllIllllIIlIIllIII, final boolean lllllllllllllllllIllllIIlIIlIlll) {
        return this.isCollidable();
    }
    
    public static Block getBlockFromItem(final Item lllllllllllllllllIllllIlIllIllll) {
        return (lllllllllllllllllIllllIlIllIllll instanceof ItemBlock) ? ((ItemBlock)lllllllllllllllllIllllIlIllIllll).getBlock() : null;
    }
    
    public void onBlockAdded(final World lllllllllllllllllIllllIIIllIllll, final BlockPos lllllllllllllllllIllllIIIllIlllI, final IBlockState lllllllllllllllllIllllIIIllIllIl) {
    }
    
    public int colorMultiplier(final IBlockAccess lllllllllllllllllIlllIllIllIIIlI, final BlockPos lllllllllllllllllIlllIllIllIIIIl, final int lllllllllllllllllIlllIllIllIIIII) {
        return 16777215;
    }
    
    public boolean canReplace(final World lllllllllllllllllIlllIlllIllIlII, final BlockPos lllllllllllllllllIlllIlllIlllIII, final EnumFacing lllllllllllllllllIlllIlllIllIlll, final ItemStack lllllllllllllllllIlllIlllIllIllI) {
        return this.canPlaceBlockOnSide(lllllllllllllllllIlllIlllIllIlII, lllllllllllllllllIlllIlllIlllIII, lllllllllllllllllIlllIlllIllIlll);
    }
    
    public MovingObjectPosition collisionRayTrace(final World lllllllllllllllllIlllIlllllIlllI, final BlockPos lllllllllllllllllIlllIlllllIllIl, Vec3 lllllllllllllllllIlllIllllIlllll, Vec3 lllllllllllllllllIlllIllllIllllI) {
        this.setBlockBoundsBasedOnState(lllllllllllllllllIlllIlllllIlllI, lllllllllllllllllIlllIlllllIllIl);
        lllllllllllllllllIlllIllllIlllll = lllllllllllllllllIlllIllllIlllll.addVector(-lllllllllllllllllIlllIlllllIllIl.getX(), -lllllllllllllllllIlllIlllllIllIl.getY(), -lllllllllllllllllIlllIlllllIllIl.getZ());
        lllllllllllllllllIlllIllllIllllI = lllllllllllllllllIlllIllllIllllI.addVector(-lllllllllllllllllIlllIlllllIllIl.getX(), -lllllllllllllllllIlllIlllllIllIl.getY(), -lllllllllllllllllIlllIlllllIllIl.getZ());
        Vec3 lllllllllllllllllIlllIlllllIlIlI = lllllllllllllllllIlllIllllIlllll.getIntermediateWithXValue(lllllllllllllllllIlllIllllIllllI, this.minX);
        Vec3 lllllllllllllllllIlllIlllllIlIIl = lllllllllllllllllIlllIllllIlllll.getIntermediateWithXValue(lllllllllllllllllIlllIllllIllllI, this.maxX);
        Vec3 lllllllllllllllllIlllIlllllIlIII = lllllllllllllllllIlllIllllIlllll.getIntermediateWithYValue(lllllllllllllllllIlllIllllIllllI, this.minY);
        Vec3 lllllllllllllllllIlllIlllllIIlll = lllllllllllllllllIlllIllllIlllll.getIntermediateWithYValue(lllllllllllllllllIlllIllllIllllI, this.maxY);
        Vec3 lllllllllllllllllIlllIlllllIIllI = lllllllllllllllllIlllIllllIlllll.getIntermediateWithZValue(lllllllllllllllllIlllIllllIllllI, this.minZ);
        Vec3 lllllllllllllllllIlllIlllllIIlIl = lllllllllllllllllIlllIllllIlllll.getIntermediateWithZValue(lllllllllllllllllIlllIllllIllllI, this.maxZ);
        if (!this.isVecInsideYZBounds(lllllllllllllllllIlllIlllllIlIlI)) {
            lllllllllllllllllIlllIlllllIlIlI = null;
        }
        if (!this.isVecInsideYZBounds(lllllllllllllllllIlllIlllllIlIIl)) {
            lllllllllllllllllIlllIlllllIlIIl = null;
        }
        if (!this.isVecInsideXZBounds(lllllllllllllllllIlllIlllllIlIII)) {
            lllllllllllllllllIlllIlllllIlIII = null;
        }
        if (!this.isVecInsideXZBounds(lllllllllllllllllIlllIlllllIIlll)) {
            lllllllllllllllllIlllIlllllIIlll = null;
        }
        if (!this.isVecInsideXYBounds(lllllllllllllllllIlllIlllllIIllI)) {
            lllllllllllllllllIlllIlllllIIllI = null;
        }
        if (!this.isVecInsideXYBounds(lllllllllllllllllIlllIlllllIIlIl)) {
            lllllllllllllllllIlllIlllllIIlIl = null;
        }
        Vec3 lllllllllllllllllIlllIlllllIIlII = null;
        if (lllllllllllllllllIlllIlllllIlIlI != null && (lllllllllllllllllIlllIlllllIIlII == null || lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIlIlI) < lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIIlII))) {
            lllllllllllllllllIlllIlllllIIlII = lllllllllllllllllIlllIlllllIlIlI;
        }
        if (lllllllllllllllllIlllIlllllIlIIl != null && (lllllllllllllllllIlllIlllllIIlII == null || lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIlIIl) < lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIIlII))) {
            lllllllllllllllllIlllIlllllIIlII = lllllllllllllllllIlllIlllllIlIIl;
        }
        if (lllllllllllllllllIlllIlllllIlIII != null && (lllllllllllllllllIlllIlllllIIlII == null || lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIlIII) < lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIIlII))) {
            lllllllllllllllllIlllIlllllIIlII = lllllllllllllllllIlllIlllllIlIII;
        }
        if (lllllllllllllllllIlllIlllllIIlll != null && (lllllllllllllllllIlllIlllllIIlII == null || lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIIlll) < lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIIlII))) {
            lllllllllllllllllIlllIlllllIIlII = lllllllllllllllllIlllIlllllIIlll;
        }
        if (lllllllllllllllllIlllIlllllIIllI != null && (lllllllllllllllllIlllIlllllIIlII == null || lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIIllI) < lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIIlII))) {
            lllllllllllllllllIlllIlllllIIlII = lllllllllllllllllIlllIlllllIIllI;
        }
        if (lllllllllllllllllIlllIlllllIIlIl != null && (lllllllllllllllllIlllIlllllIIlII == null || lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIIlIl) < lllllllllllllllllIlllIllllIlllll.squareDistanceTo(lllllllllllllllllIlllIlllllIIlII))) {
            lllllllllllllllllIlllIlllllIIlII = lllllllllllllllllIlllIlllllIIlIl;
        }
        if (lllllllllllllllllIlllIlllllIIlII == null) {
            return null;
        }
        EnumFacing lllllllllllllllllIlllIlllllIIIll = null;
        if (lllllllllllllllllIlllIlllllIIlII == lllllllllllllllllIlllIlllllIlIlI) {
            lllllllllllllllllIlllIlllllIIIll = EnumFacing.WEST;
        }
        if (lllllllllllllllllIlllIlllllIIlII == lllllllllllllllllIlllIlllllIlIIl) {
            lllllllllllllllllIlllIlllllIIIll = EnumFacing.EAST;
        }
        if (lllllllllllllllllIlllIlllllIIlII == lllllllllllllllllIlllIlllllIlIII) {
            lllllllllllllllllIlllIlllllIIIll = EnumFacing.DOWN;
        }
        if (lllllllllllllllllIlllIlllllIIlII == lllllllllllllllllIlllIlllllIIlll) {
            lllllllllllllllllIlllIlllllIIIll = EnumFacing.UP;
        }
        if (lllllllllllllllllIlllIlllllIIlII == lllllllllllllllllIlllIlllllIIllI) {
            lllllllllllllllllIlllIlllllIIIll = EnumFacing.NORTH;
        }
        if (lllllllllllllllllIlllIlllllIIlII == lllllllllllllllllIlllIlllllIIlIl) {
            lllllllllllllllllIlllIlllllIIIll = EnumFacing.SOUTH;
        }
        return new MovingObjectPosition(lllllllllllllllllIlllIlllllIIlII.addVector(lllllllllllllllllIlllIlllllIllIl.getX(), lllllllllllllllllIlllIlllllIllIl.getY(), lllllllllllllllllIlllIlllllIllIl.getZ()), lllllllllllllllllIlllIlllllIIIll, lllllllllllllllllIlllIlllllIllIl);
    }
    
    public int isProvidingStrongPower(final IBlockAccess lllllllllllllllllIlllIllIlIIlIlI, final BlockPos lllllllllllllllllIlllIllIlIIlIIl, final IBlockState lllllllllllllllllIlllIllIlIIlIII, final EnumFacing lllllllllllllllllIlllIllIlIIIlll) {
        return 0;
    }
    
    public boolean getUseNeighborBrightness() {
        return this.useNeighborBrightness;
    }
    
    public boolean canPlaceBlockAt(final World lllllllllllllllllIlllIlllIlIIlII, final BlockPos lllllllllllllllllIlllIlllIlIIIIl) {
        return lllllllllllllllllIlllIlllIlIIlII.getBlockState(lllllllllllllllllIlllIlllIlIIIIl).getBlock().blockMaterial.isReplaceable();
    }
    
    public int quantityDropped(final Random lllllllllllllllllIllllIIIllIIlll) {
        return 1;
    }
    
    public void setBlockBoundsForItemRender() {
    }
    
    public BlockState getBlockState() {
        return this.blockState;
    }
    
    private boolean isVecInsideYZBounds(final Vec3 lllllllllllllllllIlllIllllIlIIII) {
        return lllllllllllllllllIlllIllllIlIIII != null && (lllllllllllllllllIlllIllllIlIIII.yCoord >= this.minY && lllllllllllllllllIlllIllllIlIIII.yCoord <= this.maxY && lllllllllllllllllIlllIllllIlIIII.zCoord >= this.minZ && lllllllllllllllllIlllIllllIlIIII.zCoord <= this.maxZ);
    }
    
    public String getLocalizedName() {
        return StatCollector.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".name")));
    }
    
    public boolean getEnableStats() {
        return this.enableStats;
    }
    
    public Block setUnlocalizedName(final String lllllllllllllllllIlllIllIIIlIIlI) {
        this.unlocalizedName = lllllllllllllllllIlllIllIIIlIIlI;
        return this;
    }
    
    private static void registerBlock(final int lllllllllllllllllIlllIlIIlIlIIIl, final ResourceLocation lllllllllllllllllIlllIlIIlIlIIll, final Block lllllllllllllllllIlllIlIIlIlIIlI) {
        Block.blockRegistry.register(lllllllllllllllllIlllIlIIlIlIIIl, lllllllllllllllllIlllIlIIlIlIIll, lllllllllllllllllIlllIlIIlIlIIlI);
    }
    
    protected final void setBlockBounds(final float lllllllllllllllllIllllIIlllIIlll, final float lllllllllllllllllIllllIIlllIIllI, final float lllllllllllllllllIllllIIlllIllII, final float lllllllllllllllllIllllIIlllIlIll, final float lllllllllllllllllIllllIIlllIIIll, final float lllllllllllllllllIllllIIlllIlIIl) {
        this.minX = lllllllllllllllllIllllIIlllIIlll;
        this.minY = lllllllllllllllllIllllIIlllIIllI;
        this.minZ = lllllllllllllllllIllllIIlllIllII;
        this.maxX = lllllllllllllllllIllllIIlllIlIll;
        this.maxY = lllllllllllllllllIllllIIlllIIIll;
        this.maxZ = lllllllllllllllllIllllIIlllIlIIl;
    }
    
    public boolean isReplaceable(final World lllllllllllllllllIllllIlIIIlIIlI, final BlockPos lllllllllllllllllIllllIlIIIlIIIl) {
        return false;
    }
    
    public void randomDisplayTick(final World lllllllllllllllllIllllIIIlllllll, final BlockPos lllllllllllllllllIllllIIIllllllI, final IBlockState lllllllllllllllllIllllIIIlllllIl, final Random lllllllllllllllllIllllIIIlllllII) {
    }
    
    public int getMixedBrightnessForBlock(final IBlockAccess lllllllllllllllllIllllIIllIllIII, BlockPos lllllllllllllllllIllllIIllIllIll) {
        Block lllllllllllllllllIllllIIllIllIlI = lllllllllllllllllIllllIIllIllIII.getBlockState(lllllllllllllllllIllllIIllIllIll).getBlock();
        final int lllllllllllllllllIllllIIllIllIIl = lllllllllllllllllIllllIIllIllIII.getCombinedLight(lllllllllllllllllIllllIIllIllIll, lllllllllllllllllIllllIIllIllIlI.getLightValue());
        if (lllllllllllllllllIllllIIllIllIIl == 0 && lllllllllllllllllIllllIIllIllIlI instanceof BlockSlab) {
            lllllllllllllllllIllllIIllIllIll = lllllllllllllllllIllllIIllIllIll.offsetDown();
            lllllllllllllllllIllllIIllIllIlI = lllllllllllllllllIllllIIllIllIII.getBlockState(lllllllllllllllllIllllIIllIllIll).getBlock();
            return lllllllllllllllllIllllIIllIllIII.getCombinedLight(lllllllllllllllllIllllIIllIllIll, lllllllllllllllllIllllIIllIllIlI.getLightValue());
        }
        return lllllllllllllllllIllllIIllIllIIl;
    }
    
    public void harvestBlock(final World lllllllllllllllllIlllIllIIllIllI, final EntityPlayer lllllllllllllllllIlllIllIIllIlIl, final BlockPos lllllllllllllllllIlllIllIIllIlII, final IBlockState lllllllllllllllllIlllIllIIllIIll, final TileEntity lllllllllllllllllIlllIllIIlllIlI) {
        lllllllllllllllllIlllIllIIllIlIl.triggerAchievement(StatList.mineBlockStatArray[getIdFromBlock(this)]);
        lllllllllllllllllIlllIllIIllIlIl.addExhaustion(0.025f);
        if (this.canSilkHarvest() && EnchantmentHelper.getSilkTouchModifier(lllllllllllllllllIlllIllIIllIlIl)) {
            final ItemStack lllllllllllllllllIlllIllIIlllIIl = this.createStackedBlock(lllllllllllllllllIlllIllIIllIIll);
            if (lllllllllllllllllIlllIllIIlllIIl != null) {
                spawnAsEntity(lllllllllllllllllIlllIllIIllIllI, lllllllllllllllllIlllIllIIllIlII, lllllllllllllllllIlllIllIIlllIIl);
            }
        }
        else {
            final int lllllllllllllllllIlllIllIIlllIII = EnchantmentHelper.getFortuneModifier(lllllllllllllllllIlllIllIIllIlIl);
            this.dropBlockAsItem(lllllllllllllllllIlllIllIIllIllI, lllllllllllllllllIlllIllIIllIlII, lllllllllllllllllIlllIllIIllIIll, lllllllllllllllllIlllIllIIlllIII);
        }
    }
    
    public boolean isPassable(final IBlockAccess lllllllllllllllllIllllIlIIIlIlll, final BlockPos lllllllllllllllllIllllIlIIIlIllI) {
        return !this.blockMaterial.blocksMovement();
    }
    
    public static Block getBlockFromName(final String lllllllllllllllllIllllIlIllIlIll) {
        final ResourceLocation lllllllllllllllllIllllIlIllIlIlI = new ResourceLocation(lllllllllllllllllIllllIlIllIlIll);
        if (Block.blockRegistry.containsKey(lllllllllllllllllIllllIlIllIlIlI)) {
            return (Block)Block.blockRegistry.getObject(lllllllllllllllllIllllIlIllIlIlI);
        }
        try {
            return (Block)Block.blockRegistry.getObjectById(Integer.parseInt(lllllllllllllllllIllllIlIllIlIll));
        }
        catch (NumberFormatException lllllllllllllllllIllllIlIllIlIIl) {
            return null;
        }
    }
    
    protected Block setLightLevel(final float lllllllllllllllllIllllIlIIlIllII) {
        this.lightValue = (int)(15.0f * lllllllllllllllllIllllIlIIlIllII);
        return this;
    }
    
    public int getRenderColor(final IBlockState lllllllllllllllllIlllIllIllIIlII) {
        return 16777215;
    }
    
    protected boolean canSilkHarvest() {
        return this.isFullCube() && !this.isBlockContainer;
    }
    
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[0]);
    }
    
    public void dropBlockAsItemWithChance(final World lllllllllllllllllIllllIIIIlIllll, final BlockPos lllllllllllllllllIllllIIIIllIlll, final IBlockState lllllllllllllllllIllllIIIIllIllI, final float lllllllllllllllllIllllIIIIllIlIl, final int lllllllllllllllllIllllIIIIlIlIll) {
        if (!lllllllllllllllllIllllIIIIlIllll.isRemote) {
            for (int lllllllllllllllllIllllIIIIllIIll = this.quantityDroppedWithBonus(lllllllllllllllllIllllIIIIlIlIll, lllllllllllllllllIllllIIIIlIllll.rand), lllllllllllllllllIllllIIIIllIIlI = 0; lllllllllllllllllIllllIIIIllIIlI < lllllllllllllllllIllllIIIIllIIll; ++lllllllllllllllllIllllIIIIllIIlI) {
                if (lllllllllllllllllIllllIIIIlIllll.rand.nextFloat() <= lllllllllllllllllIllllIIIIllIlIl) {
                    final Item lllllllllllllllllIllllIIIIllIIIl = this.getItemDropped(lllllllllllllllllIllllIIIIllIllI, lllllllllllllllllIllllIIIIlIllll.rand, lllllllllllllllllIllllIIIIlIlIll);
                    if (lllllllllllllllllIllllIIIIllIIIl != null) {
                        spawnAsEntity(lllllllllllllllllIllllIIIIlIllll, lllllllllllllllllIllllIIIIllIlll, new ItemStack(lllllllllllllllllIllllIIIIllIIIl, 1, this.damageDropped(lllllllllllllllllIllllIIIIllIllI)));
                    }
                }
            }
        }
    }
    
    public void fillWithRain(final World lllllllllllllllllIlllIlIllIIIlII, final BlockPos lllllllllllllllllIlllIlIllIIIIll) {
    }
    
    public int isProvidingWeakPower(final IBlockAccess lllllllllllllllllIlllIllIlIlIlIl, final BlockPos lllllllllllllllllIlllIllIlIlIlII, final IBlockState lllllllllllllllllIlllIllIlIlIIll, final EnumFacing lllllllllllllllllIlllIllIlIlIIlI) {
        return 0;
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess lllllllllllllllllIlllIllIllllIlI, final BlockPos lllllllllllllllllIlllIllIllllIIl) {
    }
    
    public final int colorMultiplier(final IBlockAccess lllllllllllllllllIlllIllIlIllIII, final BlockPos lllllllllllllllllIlllIllIlIlIlll) {
        return this.colorMultiplier(lllllllllllllllllIlllIllIlIllIII, lllllllllllllllllIlllIllIlIlIlll, 0);
    }
    
    public boolean isOpaqueCube() {
        return true;
    }
    
    public float getBlockHardness(final World lllllllllllllllllIllllIlIIIIIlIl, final BlockPos lllllllllllllllllIllllIlIIIIIlII) {
        return this.blockHardness;
    }
    
    public final IBlockState getDefaultState() {
        return this.defaultBlockState;
    }
    
    public static int getIdFromBlock(final Block lllllllllllllllllIllllIllIIIIIIl) {
        return Block.blockRegistry.getIDForObject(lllllllllllllllllIllllIllIIIIIIl);
    }
    
    public boolean isBlockSolid(final IBlockAccess lllllllllllllllllIllllIIllIIIlIl, final BlockPos lllllllllllllllllIllllIIllIIIIIl, final EnumFacing lllllllllllllllllIllllIIllIIIIll) {
        return lllllllllllllllllIllllIIllIIIlIl.getBlockState(lllllllllllllllllIllllIIllIIIIIl).getBlock().getMaterial().isSolid();
    }
    
    public AxisAlignedBB getSelectedBoundingBox(final World lllllllllllllllllIllllIIlIllllIl, final BlockPos lllllllllllllllllIllllIIlIllllII) {
        return new AxisAlignedBB(lllllllllllllllllIllllIIlIllllII.getX() + this.minX, lllllllllllllllllIllllIIlIllllII.getY() + this.minY, lllllllllllllllllIllllIIlIllllII.getZ() + this.minZ, lllllllllllllllllIllllIIlIllllII.getX() + this.maxX, lllllllllllllllllIllllIIlIllllII.getY() + this.maxY, lllllllllllllllllIllllIIlIllllII.getZ() + this.maxZ);
    }
    
    public void onEntityCollidedWithBlock(final World lllllllllllllllllIlllIllIlIIllll, final BlockPos lllllllllllllllllIlllIllIlIIlllI, final IBlockState lllllllllllllllllIlllIllIlIIllIl, final Entity lllllllllllllllllIlllIllIlIIllII) {
    }
    
    public final double getBlockBoundsMaxY() {
        return this.maxY;
    }
    
    public IBlockState getStateFromMeta(final int lllllllllllllllllIllllIlIlIIllIl) {
        return this.getDefaultState();
    }
    
    public static void registerBlocks() {
        registerBlock(0, Block.AIR_ID, new BlockAir().setUnlocalizedName("air"));
        registerBlock(1, "stone", new BlockStone().setHardness(1.5f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone"));
        registerBlock(2, "grass", new BlockGrass().setHardness(0.6f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("grass"));
        registerBlock(3, "dirt", new BlockDirt().setHardness(0.5f).setStepSound(Block.soundTypeGravel).setUnlocalizedName("dirt"));
        final Block lllllllllllllllllIlllIlIlIIIIlIl = new Block(Material.rock).setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("stonebrick").setCreativeTab(CreativeTabs.tabBlock);
        registerBlock(4, "cobblestone", lllllllllllllllllIlllIlIlIIIIlIl);
        final Block lllllllllllllllllIlllIlIlIIIIlII = new BlockPlanks().setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("wood");
        registerBlock(5, "planks", lllllllllllllllllIlllIlIlIIIIlII);
        registerBlock(6, "sapling", new BlockSapling().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("sapling"));
        registerBlock(7, "bedrock", new Block(Material.rock).setBlockUnbreakable().setResistance(6000000.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("bedrock").disableStats().setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(8, "flowing_water", new BlockDynamicLiquid(Material.water).setHardness(100.0f).setLightOpacity(3).setUnlocalizedName("water").disableStats());
        registerBlock(9, "water", new BlockStaticLiquid(Material.water).setHardness(100.0f).setLightOpacity(3).setUnlocalizedName("water").disableStats());
        registerBlock(10, "flowing_lava", new BlockDynamicLiquid(Material.lava).setHardness(100.0f).setLightLevel(1.0f).setUnlocalizedName("lava").disableStats());
        registerBlock(11, "lava", new BlockStaticLiquid(Material.lava).setHardness(100.0f).setLightLevel(1.0f).setUnlocalizedName("lava").disableStats());
        registerBlock(12, "sand", new BlockSand().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("sand"));
        registerBlock(13, "gravel", new BlockGravel().setHardness(0.6f).setStepSound(Block.soundTypeGravel).setUnlocalizedName("gravel"));
        registerBlock(14, "gold_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("oreGold"));
        registerBlock(15, "iron_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("oreIron"));
        registerBlock(16, "coal_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("oreCoal"));
        registerBlock(17, "log", new BlockOldLog().setUnlocalizedName("log"));
        registerBlock(18, "leaves", new BlockOldLeaf().setUnlocalizedName("leaves"));
        registerBlock(19, "sponge", new BlockSponge().setHardness(0.6f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("sponge"));
        registerBlock(20, "glass", new BlockGlass(Material.glass, false).setHardness(0.3f).setStepSound(Block.soundTypeGlass).setUnlocalizedName("glass"));
        registerBlock(21, "lapis_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("oreLapis"));
        registerBlock(22, "lapis_block", new BlockCompressed(MapColor.lapisColor).setHardness(3.0f).setResistance(5.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("blockLapis").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(23, "dispenser", new BlockDispenser().setHardness(3.5f).setStepSound(Block.soundTypePiston).setUnlocalizedName("dispenser"));
        final Block lllllllllllllllllIlllIlIlIIIIIll = new BlockSandStone().setStepSound(Block.soundTypePiston).setHardness(0.8f).setUnlocalizedName("sandStone");
        registerBlock(24, "sandstone", lllllllllllllllllIlllIlIlIIIIIll);
        registerBlock(25, "noteblock", new BlockNote().setHardness(0.8f).setUnlocalizedName("musicBlock"));
        registerBlock(26, "bed", new BlockBed().setStepSound(Block.soundTypeWood).setHardness(0.2f).setUnlocalizedName("bed").disableStats());
        registerBlock(27, "golden_rail", new BlockRailPowered().setHardness(0.7f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("goldenRail"));
        registerBlock(28, "detector_rail", new BlockRailDetector().setHardness(0.7f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("detectorRail"));
        registerBlock(29, "sticky_piston", new BlockPistonBase(true).setUnlocalizedName("pistonStickyBase"));
        registerBlock(30, "web", new BlockWeb().setLightOpacity(1).setHardness(4.0f).setUnlocalizedName("web"));
        registerBlock(31, "tallgrass", new BlockTallGrass().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("tallgrass"));
        registerBlock(32, "deadbush", new BlockDeadBush().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("deadbush"));
        registerBlock(33, "piston", new BlockPistonBase(false).setUnlocalizedName("pistonBase"));
        registerBlock(34, "piston_head", new BlockPistonExtension());
        registerBlock(35, "wool", new BlockColored(Material.cloth).setHardness(0.8f).setStepSound(Block.soundTypeCloth).setUnlocalizedName("cloth"));
        registerBlock(36, "piston_extension", new BlockPistonMoving());
        registerBlock(37, "yellow_flower", new BlockYellowFlower().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("flower1"));
        registerBlock(38, "red_flower", new BlockRedFlower().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("flower2"));
        final Block lllllllllllllllllIlllIlIlIIIIIlI = new BlockMushroom().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setLightLevel(0.125f).setUnlocalizedName("mushroom");
        registerBlock(39, "brown_mushroom", lllllllllllllllllIlllIlIlIIIIIlI);
        final Block lllllllllllllllllIlllIlIlIIIIIIl = new BlockMushroom().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("mushroom");
        registerBlock(40, "red_mushroom", lllllllllllllllllIlllIlIlIIIIIIl);
        registerBlock(41, "gold_block", new BlockCompressed(MapColor.goldColor).setHardness(3.0f).setResistance(10.0f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("blockGold"));
        registerBlock(42, "iron_block", new BlockCompressed(MapColor.ironColor).setHardness(5.0f).setResistance(10.0f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("blockIron"));
        registerBlock(43, "double_stone_slab", new BlockDoubleStoneSlab().setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("stoneSlab"));
        registerBlock(44, "stone_slab", new BlockHalfStoneSlab().setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("stoneSlab"));
        final Block lllllllllllllllllIlllIlIlIIIIIII = new Block(Material.rock).setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("brick").setCreativeTab(CreativeTabs.tabBlock);
        registerBlock(45, "brick_block", lllllllllllllllllIlllIlIlIIIIIII);
        registerBlock(46, "tnt", new BlockTNT().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("tnt"));
        registerBlock(47, "bookshelf", new BlockBookshelf().setHardness(1.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("bookshelf"));
        registerBlock(48, "mossy_cobblestone", new Block(Material.rock).setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("stoneMoss").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(49, "obsidian", new BlockObsidian().setHardness(50.0f).setResistance(2000.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("obsidian"));
        registerBlock(50, "torch", new BlockTorch().setHardness(0.0f).setLightLevel(0.9375f).setStepSound(Block.soundTypeWood).setUnlocalizedName("torch"));
        registerBlock(51, "fire", new BlockFire().setHardness(0.0f).setLightLevel(1.0f).setStepSound(Block.soundTypeCloth).setUnlocalizedName("fire").disableStats());
        registerBlock(52, "mob_spawner", new BlockMobSpawner().setHardness(5.0f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("mobSpawner").disableStats());
        registerBlock(53, "oak_stairs", new BlockStairs(lllllllllllllllllIlllIlIlIIIIlII.getDefaultState().withProperty(BlockPlanks.VARIANT_PROP, BlockPlanks.EnumType.OAK)).setUnlocalizedName("stairsWood"));
        registerBlock(54, "chest", new BlockChest(0).setHardness(2.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("chest"));
        registerBlock(55, "redstone_wire", new BlockRedstoneWire().setHardness(0.0f).setStepSound(Block.soundTypeStone).setUnlocalizedName("redstoneDust").disableStats());
        registerBlock(56, "diamond_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("oreDiamond"));
        registerBlock(57, "diamond_block", new BlockCompressed(MapColor.diamondColor).setHardness(5.0f).setResistance(10.0f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("blockDiamond"));
        registerBlock(58, "crafting_table", new BlockWorkbench().setHardness(2.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("workbench"));
        registerBlock(59, "wheat", new BlockCrops().setUnlocalizedName("crops"));
        final Block lllllllllllllllllIlllIlIIlllllll = new BlockFarmland().setHardness(0.6f).setStepSound(Block.soundTypeGravel).setUnlocalizedName("farmland");
        registerBlock(60, "farmland", lllllllllllllllllIlllIlIIlllllll);
        registerBlock(61, "furnace", new BlockFurnace(false).setHardness(3.5f).setStepSound(Block.soundTypePiston).setUnlocalizedName("furnace").setCreativeTab(CreativeTabs.tabDecorations));
        registerBlock(62, "lit_furnace", new BlockFurnace(true).setHardness(3.5f).setStepSound(Block.soundTypePiston).setLightLevel(0.875f).setUnlocalizedName("furnace"));
        registerBlock(63, "standing_sign", new BlockStandingSign().setHardness(1.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("sign").disableStats());
        registerBlock(64, "wooden_door", new BlockDoor(Material.wood).setHardness(3.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("doorOak").disableStats());
        registerBlock(65, "ladder", new BlockLadder().setHardness(0.4f).setStepSound(Block.soundTypeLadder).setUnlocalizedName("ladder"));
        registerBlock(66, "rail", new BlockRail().setHardness(0.7f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("rail"));
        registerBlock(67, "stone_stairs", new BlockStairs(lllllllllllllllllIlllIlIlIIIIlIl.getDefaultState()).setUnlocalizedName("stairsStone"));
        registerBlock(68, "wall_sign", new BlockWallSign().setHardness(1.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("sign").disableStats());
        registerBlock(69, "lever", new BlockLever().setHardness(0.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("lever"));
        registerBlock(70, "stone_pressure_plate", new BlockPressurePlate(Material.rock, BlockPressurePlate.Sensitivity.MOBS).setHardness(0.5f).setStepSound(Block.soundTypePiston).setUnlocalizedName("pressurePlateStone"));
        registerBlock(71, "iron_door", new BlockDoor(Material.iron).setHardness(5.0f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("doorIron").disableStats());
        registerBlock(72, "wooden_pressure_plate", new BlockPressurePlate(Material.wood, BlockPressurePlate.Sensitivity.EVERYTHING).setHardness(0.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("pressurePlateWood"));
        registerBlock(73, "redstone_ore", new BlockRedstoneOre(false).setHardness(3.0f).setResistance(5.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("oreRedstone").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(74, "lit_redstone_ore", new BlockRedstoneOre(true).setLightLevel(0.625f).setHardness(3.0f).setResistance(5.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("oreRedstone"));
        registerBlock(75, "unlit_redstone_torch", new BlockRedstoneTorch(false).setHardness(0.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("notGate"));
        registerBlock(76, "redstone_torch", new BlockRedstoneTorch(true).setHardness(0.0f).setLightLevel(0.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("notGate").setCreativeTab(CreativeTabs.tabRedstone));
        registerBlock(77, "stone_button", new BlockButtonStone().setHardness(0.5f).setStepSound(Block.soundTypePiston).setUnlocalizedName("button"));
        registerBlock(78, "snow_layer", new BlockSnow().setHardness(0.1f).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow").setLightOpacity(0));
        registerBlock(79, "ice", new BlockIce().setHardness(0.5f).setLightOpacity(3).setStepSound(Block.soundTypeGlass).setUnlocalizedName("ice"));
        registerBlock(80, "snow", new BlockSnowBlock().setHardness(0.2f).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow"));
        registerBlock(81, "cactus", new BlockCactus().setHardness(0.4f).setStepSound(Block.soundTypeCloth).setUnlocalizedName("cactus"));
        registerBlock(82, "clay", new BlockClay().setHardness(0.6f).setStepSound(Block.soundTypeGravel).setUnlocalizedName("clay"));
        registerBlock(83, "reeds", new BlockReed().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("reeds").disableStats());
        registerBlock(84, "jukebox", new BlockJukebox().setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("jukebox"));
        registerBlock(85, "fence", new BlockFence(Material.wood).setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("fence"));
        final Block lllllllllllllllllIlllIlIIllllllI = new BlockPumpkin().setHardness(1.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("pumpkin");
        registerBlock(86, "pumpkin", lllllllllllllllllIlllIlIIllllllI);
        registerBlock(87, "netherrack", new BlockNetherrack().setHardness(0.4f).setStepSound(Block.soundTypePiston).setUnlocalizedName("hellrock"));
        registerBlock(88, "soul_sand", new BlockSoulSand().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("hellsand"));
        registerBlock(89, "glowstone", new BlockGlowstone(Material.glass).setHardness(0.3f).setStepSound(Block.soundTypeGlass).setLightLevel(1.0f).setUnlocalizedName("lightgem"));
        registerBlock(90, "portal", new BlockPortal().setHardness(-1.0f).setStepSound(Block.soundTypeGlass).setLightLevel(0.75f).setUnlocalizedName("portal"));
        registerBlock(91, "lit_pumpkin", new BlockPumpkin().setHardness(1.0f).setStepSound(Block.soundTypeWood).setLightLevel(1.0f).setUnlocalizedName("litpumpkin"));
        registerBlock(92, "cake", new BlockCake().setHardness(0.5f).setStepSound(Block.soundTypeCloth).setUnlocalizedName("cake").disableStats());
        registerBlock(93, "unpowered_repeater", new BlockRedstoneRepeater(false).setHardness(0.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("diode").disableStats());
        registerBlock(94, "powered_repeater", new BlockRedstoneRepeater(true).setHardness(0.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("diode").disableStats());
        registerBlock(95, "stained_glass", new BlockStainedGlass(Material.glass).setHardness(0.3f).setStepSound(Block.soundTypeGlass).setUnlocalizedName("stainedGlass"));
        registerBlock(96, "trapdoor", new BlockTrapDoor(Material.wood).setHardness(3.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("trapdoor").disableStats());
        registerBlock(97, "monster_egg", new BlockSilverfish().setHardness(0.75f).setUnlocalizedName("monsterStoneEgg"));
        final Block lllllllllllllllllIlllIlIIlllllIl = new BlockStoneBrick().setHardness(1.5f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("stonebricksmooth");
        registerBlock(98, "stonebrick", lllllllllllllllllIlllIlIIlllllIl);
        registerBlock(99, "brown_mushroom_block", new BlockHugeMushroom(Material.wood, lllllllllllllllllIlllIlIlIIIIIlI).setHardness(0.2f).setStepSound(Block.soundTypeWood).setUnlocalizedName("mushroom"));
        registerBlock(100, "red_mushroom_block", new BlockHugeMushroom(Material.wood, lllllllllllllllllIlllIlIlIIIIIIl).setHardness(0.2f).setStepSound(Block.soundTypeWood).setUnlocalizedName("mushroom"));
        registerBlock(101, "iron_bars", new BlockPane(Material.iron, true).setHardness(5.0f).setResistance(10.0f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("fenceIron"));
        registerBlock(102, "glass_pane", new BlockPane(Material.glass, false).setHardness(0.3f).setStepSound(Block.soundTypeGlass).setUnlocalizedName("thinGlass"));
        final Block lllllllllllllllllIlllIlIIlllllII = new BlockMelon().setHardness(1.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("melon");
        registerBlock(103, "melon_block", lllllllllllllllllIlllIlIIlllllII);
        registerBlock(104, "pumpkin_stem", new BlockStem(lllllllllllllllllIlllIlIIllllllI).setHardness(0.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("pumpkinStem"));
        registerBlock(105, "melon_stem", new BlockStem(lllllllllllllllllIlllIlIIlllllII).setHardness(0.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("pumpkinStem"));
        registerBlock(106, "vine", new BlockVine().setHardness(0.2f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("vine"));
        registerBlock(107, "fence_gate", new BlockFenceGate().setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("fenceGate"));
        registerBlock(108, "brick_stairs", new BlockStairs(lllllllllllllllllIlllIlIlIIIIIII.getDefaultState()).setUnlocalizedName("stairsBrick"));
        registerBlock(109, "stone_brick_stairs", new BlockStairs(lllllllllllllllllIlllIlIIlllllIl.getDefaultState().withProperty(BlockStoneBrick.VARIANT_PROP, BlockStoneBrick.EnumType.DEFAULT)).setUnlocalizedName("stairsStoneBrickSmooth"));
        registerBlock(110, "mycelium", new BlockMycelium().setHardness(0.6f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("mycel"));
        registerBlock(111, "waterlily", new BlockLilyPad().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("waterlily"));
        final Block lllllllllllllllllIlllIlIIllllIll = new BlockNetherBrick().setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("netherBrick").setCreativeTab(CreativeTabs.tabBlock);
        registerBlock(112, "nether_brick", lllllllllllllllllIlllIlIIllllIll);
        registerBlock(113, "nether_brick_fence", new BlockFence(Material.rock).setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("netherFence"));
        registerBlock(114, "nether_brick_stairs", new BlockStairs(lllllllllllllllllIlllIlIIllllIll.getDefaultState()).setUnlocalizedName("stairsNetherBrick"));
        registerBlock(115, "nether_wart", new BlockNetherWart().setUnlocalizedName("netherStalk"));
        registerBlock(116, "enchanting_table", new BlockEnchantmentTable().setHardness(5.0f).setResistance(2000.0f).setUnlocalizedName("enchantmentTable"));
        registerBlock(117, "brewing_stand", new BlockBrewingStand().setHardness(0.5f).setLightLevel(0.125f).setUnlocalizedName("brewingStand"));
        registerBlock(118, "cauldron", new BlockCauldron().setHardness(2.0f).setUnlocalizedName("cauldron"));
        registerBlock(119, "end_portal", new BlockEndPortal(Material.portal).setHardness(-1.0f).setResistance(6000000.0f));
        registerBlock(120, "end_portal_frame", new BlockEndPortalFrame().setStepSound(Block.soundTypeGlass).setLightLevel(0.125f).setHardness(-1.0f).setUnlocalizedName("endPortalFrame").setResistance(6000000.0f).setCreativeTab(CreativeTabs.tabDecorations));
        registerBlock(121, "end_stone", new Block(Material.rock).setHardness(3.0f).setResistance(15.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("whiteStone").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(122, "dragon_egg", new BlockDragonEgg().setHardness(3.0f).setResistance(15.0f).setStepSound(Block.soundTypePiston).setLightLevel(0.125f).setUnlocalizedName("dragonEgg"));
        registerBlock(123, "redstone_lamp", new BlockRedstoneLight(false).setHardness(0.3f).setStepSound(Block.soundTypeGlass).setUnlocalizedName("redstoneLight").setCreativeTab(CreativeTabs.tabRedstone));
        registerBlock(124, "lit_redstone_lamp", new BlockRedstoneLight(true).setHardness(0.3f).setStepSound(Block.soundTypeGlass).setUnlocalizedName("redstoneLight"));
        registerBlock(125, "double_wooden_slab", new BlockDoubleWoodSlab().setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("woodSlab"));
        registerBlock(126, "wooden_slab", new BlockHalfWoodSlab().setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("woodSlab"));
        registerBlock(127, "cocoa", new BlockCocoa().setHardness(0.2f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("cocoa"));
        registerBlock(128, "sandstone_stairs", new BlockStairs(lllllllllllllllllIlllIlIlIIIIIll.getDefaultState().withProperty(BlockSandStone.field_176297_a, BlockSandStone.EnumType.SMOOTH)).setUnlocalizedName("stairsSandStone"));
        registerBlock(129, "emerald_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("oreEmerald"));
        registerBlock(130, "ender_chest", new BlockEnderChest().setHardness(22.5f).setResistance(1000.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("enderChest").setLightLevel(0.5f));
        registerBlock(131, "tripwire_hook", new BlockTripWireHook().setUnlocalizedName("tripWireSource"));
        registerBlock(132, "tripwire", new BlockTripWire().setUnlocalizedName("tripWire"));
        registerBlock(133, "emerald_block", new BlockCompressed(MapColor.emeraldColor).setHardness(5.0f).setResistance(10.0f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("blockEmerald"));
        registerBlock(134, "spruce_stairs", new BlockStairs(lllllllllllllllllIlllIlIlIIIIlII.getDefaultState().withProperty(BlockPlanks.VARIANT_PROP, BlockPlanks.EnumType.SPRUCE)).setUnlocalizedName("stairsWoodSpruce"));
        registerBlock(135, "birch_stairs", new BlockStairs(lllllllllllllllllIlllIlIlIIIIlII.getDefaultState().withProperty(BlockPlanks.VARIANT_PROP, BlockPlanks.EnumType.BIRCH)).setUnlocalizedName("stairsWoodBirch"));
        registerBlock(136, "jungle_stairs", new BlockStairs(lllllllllllllllllIlllIlIlIIIIlII.getDefaultState().withProperty(BlockPlanks.VARIANT_PROP, BlockPlanks.EnumType.JUNGLE)).setUnlocalizedName("stairsWoodJungle"));
        registerBlock(137, "command_block", new BlockCommandBlock().setBlockUnbreakable().setResistance(6000000.0f).setUnlocalizedName("commandBlock"));
        registerBlock(138, "beacon", new BlockBeacon().setUnlocalizedName("beacon").setLightLevel(1.0f));
        registerBlock(139, "cobblestone_wall", new BlockWall(lllllllllllllllllIlllIlIlIIIIlIl).setUnlocalizedName("cobbleWall"));
        registerBlock(140, "flower_pot", new BlockFlowerPot().setHardness(0.0f).setStepSound(Block.soundTypeStone).setUnlocalizedName("flowerPot"));
        registerBlock(141, "carrots", new BlockCarrot().setUnlocalizedName("carrots"));
        registerBlock(142, "potatoes", new BlockPotato().setUnlocalizedName("potatoes"));
        registerBlock(143, "wooden_button", new BlockButtonWood().setHardness(0.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("button"));
        registerBlock(144, "skull", new BlockSkull().setHardness(1.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("skull"));
        registerBlock(145, "anvil", new BlockAnvil().setHardness(5.0f).setStepSound(Block.soundTypeAnvil).setResistance(2000.0f).setUnlocalizedName("anvil"));
        registerBlock(146, "trapped_chest", new BlockChest(1).setHardness(2.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("chestTrap"));
        registerBlock(147, "light_weighted_pressure_plate", new BlockPressurePlateWeighted("gold_block", Material.iron, 15).setHardness(0.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("weightedPlate_light"));
        registerBlock(148, "heavy_weighted_pressure_plate", new BlockPressurePlateWeighted("iron_block", Material.iron, 150).setHardness(0.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("weightedPlate_heavy"));
        registerBlock(149, "unpowered_comparator", new BlockRedstoneComparator(false).setHardness(0.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("comparator").disableStats());
        registerBlock(150, "powered_comparator", new BlockRedstoneComparator(true).setHardness(0.0f).setLightLevel(0.625f).setStepSound(Block.soundTypeWood).setUnlocalizedName("comparator").disableStats());
        registerBlock(151, "daylight_detector", new BlockDaylightDetector(false));
        registerBlock(152, "redstone_block", new BlockCompressedPowered(MapColor.tntColor).setHardness(5.0f).setResistance(10.0f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("blockRedstone"));
        registerBlock(153, "quartz_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("netherquartz"));
        registerBlock(154, "hopper", new BlockHopper().setHardness(3.0f).setResistance(8.0f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("hopper"));
        final Block lllllllllllllllllIlllIlIIllllIlI = new BlockQuartz().setStepSound(Block.soundTypePiston).setHardness(0.8f).setUnlocalizedName("quartzBlock");
        registerBlock(155, "quartz_block", lllllllllllllllllIlllIlIIllllIlI);
        registerBlock(156, "quartz_stairs", new BlockStairs(lllllllllllllllllIlllIlIIllllIlI.getDefaultState().withProperty(BlockQuartz.VARIANT_PROP, BlockQuartz.EnumType.DEFAULT)).setUnlocalizedName("stairsQuartz"));
        registerBlock(157, "activator_rail", new BlockRailPowered().setHardness(0.7f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("activatorRail"));
        registerBlock(158, "dropper", new BlockDropper().setHardness(3.5f).setStepSound(Block.soundTypePiston).setUnlocalizedName("dropper"));
        registerBlock(159, "stained_hardened_clay", new BlockColored(Material.rock).setHardness(1.25f).setResistance(7.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("clayHardenedStained"));
        registerBlock(160, "stained_glass_pane", new BlockStainedGlassPane().setHardness(0.3f).setStepSound(Block.soundTypeGlass).setUnlocalizedName("thinStainedGlass"));
        registerBlock(161, "leaves2", new BlockNewLeaf().setUnlocalizedName("leaves"));
        registerBlock(162, "log2", new BlockNewLog().setUnlocalizedName("log"));
        registerBlock(163, "acacia_stairs", new BlockStairs(lllllllllllllllllIlllIlIlIIIIlII.getDefaultState().withProperty(BlockPlanks.VARIANT_PROP, BlockPlanks.EnumType.ACACIA)).setUnlocalizedName("stairsWoodAcacia"));
        registerBlock(164, "dark_oak_stairs", new BlockStairs(lllllllllllllllllIlllIlIlIIIIlII.getDefaultState().withProperty(BlockPlanks.VARIANT_PROP, BlockPlanks.EnumType.DARK_OAK)).setUnlocalizedName("stairsWoodDarkOak"));
        registerBlock(165, "slime", new BlockSlime().setUnlocalizedName("slime").setStepSound(Block.SLIME_SOUND));
        registerBlock(166, "barrier", new BlockBarrier().setUnlocalizedName("barrier"));
        registerBlock(167, "iron_trapdoor", new BlockTrapDoor(Material.iron).setHardness(5.0f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("ironTrapdoor").disableStats());
        registerBlock(168, "prismarine", new BlockPrismarine().setHardness(1.5f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("prismarine"));
        registerBlock(169, "sea_lantern", new BlockSeaLantern(Material.glass).setHardness(0.3f).setStepSound(Block.soundTypeGlass).setLightLevel(1.0f).setUnlocalizedName("seaLantern"));
        registerBlock(170, "hay_block", new BlockHay().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("hayBlock").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(171, "carpet", new BlockCarpet().setHardness(0.1f).setStepSound(Block.soundTypeCloth).setUnlocalizedName("woolCarpet").setLightOpacity(0));
        registerBlock(172, "hardened_clay", new BlockHardenedClay().setHardness(1.25f).setResistance(7.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("clayHardened"));
        registerBlock(173, "coal_block", new Block(Material.rock).setHardness(5.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("blockCoal").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(174, "packed_ice", new BlockPackedIce().setHardness(0.5f).setStepSound(Block.soundTypeGlass).setUnlocalizedName("icePacked"));
        registerBlock(175, "double_plant", new BlockDoublePlant());
        registerBlock(176, "standing_banner", new BlockBanner.BlockBannerStanding().setHardness(1.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("banner").disableStats());
        registerBlock(177, "wall_banner", new BlockBanner.BlockBannerHanging().setHardness(1.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("banner").disableStats());
        registerBlock(178, "daylight_detector_inverted", new BlockDaylightDetector(true));
        final Block lllllllllllllllllIlllIlIIllllIIl = new BlockRedSandstone().setStepSound(Block.soundTypePiston).setHardness(0.8f).setUnlocalizedName("redSandStone");
        registerBlock(179, "red_sandstone", lllllllllllllllllIlllIlIIllllIIl);
        registerBlock(180, "red_sandstone_stairs", new BlockStairs(lllllllllllllllllIlllIlIIllllIIl.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.SMOOTH)).setUnlocalizedName("stairsRedSandStone"));
        registerBlock(181, "double_stone_slab2", new BlockDoubleStoneSlabNew().setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("stoneSlab2"));
        registerBlock(182, "stone_slab2", new BlockHalfStoneSlabNew().setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypePiston).setUnlocalizedName("stoneSlab2"));
        registerBlock(183, "spruce_fence_gate", new BlockFenceGate().setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("spruceFenceGate"));
        registerBlock(184, "birch_fence_gate", new BlockFenceGate().setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("birchFenceGate"));
        registerBlock(185, "jungle_fence_gate", new BlockFenceGate().setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("jungleFenceGate"));
        registerBlock(186, "dark_oak_fence_gate", new BlockFenceGate().setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("darkOakFenceGate"));
        registerBlock(187, "acacia_fence_gate", new BlockFenceGate().setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("acaciaFenceGate"));
        registerBlock(188, "spruce_fence", new BlockFence(Material.wood).setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("spruceFence"));
        registerBlock(189, "birch_fence", new BlockFence(Material.wood).setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("birchFence"));
        registerBlock(190, "jungle_fence", new BlockFence(Material.wood).setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("jungleFence"));
        registerBlock(191, "dark_oak_fence", new BlockFence(Material.wood).setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("darkOakFence"));
        registerBlock(192, "acacia_fence", new BlockFence(Material.wood).setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("acaciaFence"));
        registerBlock(193, "spruce_door", new BlockDoor(Material.wood).setHardness(3.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("doorSpruce").disableStats());
        registerBlock(194, "birch_door", new BlockDoor(Material.wood).setHardness(3.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("doorBirch").disableStats());
        registerBlock(195, "jungle_door", new BlockDoor(Material.wood).setHardness(3.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("doorJungle").disableStats());
        registerBlock(196, "acacia_door", new BlockDoor(Material.wood).setHardness(3.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("doorAcacia").disableStats());
        registerBlock(197, "dark_oak_door", new BlockDoor(Material.wood).setHardness(3.0f).setStepSound(Block.soundTypeWood).setUnlocalizedName("doorDarkOak").disableStats());
        Block.blockRegistry.validateKey();
        for (final Block lllllllllllllllllIlllIlIIlllIlll : Block.blockRegistry) {
            if (lllllllllllllllllIlllIlIIlllIlll.blockMaterial == Material.air) {
                lllllllllllllllllIlllIlIIlllIlll.useNeighborBrightness = false;
            }
            else {
                boolean lllllllllllllllllIlllIlIIlllIlIl = false;
                final boolean lllllllllllllllllIlllIlIIlllIlII = lllllllllllllllllIlllIlIIlllIlll instanceof BlockStairs;
                final boolean lllllllllllllllllIlllIlIIlllIIll = lllllllllllllllllIlllIlIIlllIlll instanceof BlockSlab;
                final boolean lllllllllllllllllIlllIlIIlllIIlI = lllllllllllllllllIlllIlIIlllIlll == lllllllllllllllllIlllIlIIlllllll;
                final boolean lllllllllllllllllIlllIlIIlllIIIl = lllllllllllllllllIlllIlIIlllIlll.translucent;
                final boolean lllllllllllllllllIlllIlIIlllIIII = lllllllllllllllllIlllIlIIlllIlll.lightOpacity == 0;
                if (lllllllllllllllllIlllIlIIlllIlII || lllllllllllllllllIlllIlIIlllIIll || lllllllllllllllllIlllIlIIlllIIlI || lllllllllllllllllIlllIlIIlllIIIl || lllllllllllllllllIlllIlIIlllIIII) {
                    lllllllllllllllllIlllIlIIlllIlIl = true;
                }
                lllllllllllllllllIlllIlIIlllIlll.useNeighborBrightness = lllllllllllllllllIlllIlIIlllIlIl;
            }
        }
        for (final Block lllllllllllllllllIlllIlIIlllIllI : Block.blockRegistry) {
            for (final IBlockState lllllllllllllllllIlllIlIIllIlllI : lllllllllllllllllIlllIlIIlllIllI.getBlockState().getValidStates()) {
                final int lllllllllllllllllIlllIlIIllIllIl = Block.blockRegistry.getIDForObject(lllllllllllllllllIlllIlIIlllIllI) << 4 | lllllllllllllllllIlllIlIIlllIllI.getMetaFromState(lllllllllllllllllIlllIlIIllIlllI);
                Block.BLOCK_STATE_IDS.put(lllllllllllllllllIlllIlIIllIlllI, lllllllllllllllllIlllIlIIllIllIl);
            }
        }
    }
    
    protected Block setResistance(final float lllllllllllllllllIllllIlIIlIIlII) {
        this.blockResistance = lllllllllllllllllIllllIlIIlIIlII * 3.0f;
        return this;
    }
    
    public float getAmbientOcclusionLightValue() {
        return this.isSolidFullCube() ? 0.2f : 1.0f;
    }
    
    public boolean canProvidePower() {
        return false;
    }
    
    public static int getStateId(final IBlockState lllllllllllllllllIllllIlIlllllll) {
        return getIdFromBlock(lllllllllllllllllIllllIlIlllllll.getBlock()) + (lllllllllllllllllIllllIlIlllllll.getBlock().getMetaFromState(lllllllllllllllllIllllIlIlllllll) << 12);
    }
    
    public int getBlockColor() {
        return 16777215;
    }
    
    public final void dropBlockAsItem(final World lllllllllllllllllIllllIIIlIIIllI, final BlockPos lllllllllllllllllIllllIIIlIIlIlI, final IBlockState lllllllllllllllllIllllIIIlIIlIIl, final int lllllllllllllllllIllllIIIlIIIIll) {
        this.dropBlockAsItemWithChance(lllllllllllllllllIllllIIIlIIIllI, lllllllllllllllllIllllIIIlIIlIlI, lllllllllllllllllIllllIIIlIIlIIl, 1.0f, lllllllllllllllllIllllIIIlIIIIll);
    }
    
    public boolean canDropFromExplosion(final Explosion lllllllllllllllllIlllIlIlIllllll) {
        return true;
    }
    
    public int getMetaFromState(final IBlockState lllllllllllllllllIllllIlIlIIlIII) {
        if (lllllllllllllllllIllllIlIlIIlIII != null && !lllllllllllllllllIllllIlIlIIlIII.getPropertyNames().isEmpty()) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to convert ").append(lllllllllllllllllIllllIlIlIIlIII).append(" back into data...")));
        }
        return 0;
    }
    
    public boolean shouldSideBeRendered(final IBlockAccess lllllllllllllllllIllllIIllIIllll, final BlockPos lllllllllllllllllIllllIIllIIlIlI, final EnumFacing lllllllllllllllllIllllIIllIIllIl) {
        return (lllllllllllllllllIllllIIllIIllIl == EnumFacing.DOWN && this.minY > 0.0) || (lllllllllllllllllIllllIIllIIllIl == EnumFacing.UP && this.maxY < 1.0) || (lllllllllllllllllIllllIIllIIllIl == EnumFacing.NORTH && this.minZ > 0.0) || (lllllllllllllllllIllllIIllIIllIl == EnumFacing.SOUTH && this.maxZ < 1.0) || (lllllllllllllllllIllllIIllIIllIl == EnumFacing.WEST && this.minX > 0.0) || (lllllllllllllllllIllllIIllIIllIl == EnumFacing.EAST && this.maxX < 1.0) || !lllllllllllllllllIllllIIllIIllll.getBlockState(lllllllllllllllllIllllIIllIIlIlI).getBlock().isOpaqueCube();
    }
    
    public AxisAlignedBB getCollisionBoundingBox(final World lllllllllllllllllIllllIIlIlIIIII, final BlockPos lllllllllllllllllIllllIIlIIlllII, final IBlockState lllllllllllllllllIllllIIlIIllllI) {
        return new AxisAlignedBB(lllllllllllllllllIllllIIlIIlllII.getX() + this.minX, lllllllllllllllllIllllIIlIIlllII.getY() + this.minY, lllllllllllllllllIllllIIlIIlllII.getZ() + this.minZ, lllllllllllllllllIllllIIlIIlllII.getX() + this.maxX, lllllllllllllllllIllllIIlIIlllII.getY() + this.maxY, lllllllllllllllllIllllIIlIIlllII.getZ() + this.maxZ);
    }
    
    protected Block setTickRandomly(final boolean lllllllllllllllllIllllIIllllllll) {
        this.needsRandomTick = lllllllllllllllllIllllIIllllllll;
        return this;
    }
    
    public void onBlockDestroyedByExplosion(final World lllllllllllllllllIlllIllllIIIIlI, final BlockPos lllllllllllllllllIlllIllllIIIIIl, final Explosion lllllllllllllllllIlllIllllIIIIII) {
    }
    
    public void onFallenUpon(final World lllllllllllllllllIlllIlIllllIlII, final BlockPos lllllllllllllllllIlllIlIllllIIll, final Entity lllllllllllllllllIlllIlIllllIIlI, final float lllllllllllllllllIlllIlIlllIllll) {
        lllllllllllllllllIlllIlIllllIIlI.fall(lllllllllllllllllIlllIlIlllIllll, 1.0f);
    }
    
    public static void spawnAsEntity(final World lllllllllllllllllIllllIIIIIlllll, final BlockPos lllllllllllllllllIllllIIIIIllllI, final ItemStack lllllllllllllllllIllllIIIIIlIlIl) {
        if (!lllllllllllllllllIllllIIIIIlllll.isRemote && lllllllllllllllllIllllIIIIIlllll.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
            final float lllllllllllllllllIllllIIIIIlllII = 0.5f;
            final double lllllllllllllllllIllllIIIIIllIll = lllllllllllllllllIllllIIIIIlllll.rand.nextFloat() * lllllllllllllllllIllllIIIIIlllII + (1.0f - lllllllllllllllllIllllIIIIIlllII) * 0.5;
            final double lllllllllllllllllIllllIIIIIllIlI = lllllllllllllllllIllllIIIIIlllll.rand.nextFloat() * lllllllllllllllllIllllIIIIIlllII + (1.0f - lllllllllllllllllIllllIIIIIlllII) * 0.5;
            final double lllllllllllllllllIllllIIIIIllIIl = lllllllllllllllllIllllIIIIIlllll.rand.nextFloat() * lllllllllllllllllIllllIIIIIlllII + (1.0f - lllllllllllllllllIllllIIIIIlllII) * 0.5;
            final EntityItem lllllllllllllllllIllllIIIIIllIII = new EntityItem(lllllllllllllllllIllllIIIIIlllll, lllllllllllllllllIllllIIIIIllllI.getX() + lllllllllllllllllIllllIIIIIllIll, lllllllllllllllllIllllIIIIIllllI.getY() + lllllllllllllllllIllllIIIIIllIlI, lllllllllllllllllIllllIIIIIllllI.getZ() + lllllllllllllllllIllllIIIIIllIIl, lllllllllllllllllIllllIIIIIlIlIl);
            lllllllllllllllllIllllIIIIIllIII.setDefaultPickupDelay();
            lllllllllllllllllIllllIIIIIlllll.spawnEntityInWorld(lllllllllllllllllIllllIIIIIllIII);
        }
    }
    
    public final double getBlockBoundsMinZ() {
        return this.minZ;
    }
    
    public boolean isTranslucent() {
        return this.translucent;
    }
    
    public void addCollisionBoxesToList(final World lllllllllllllllllIllllIIlIllIIIl, final BlockPos lllllllllllllllllIllllIIlIlIlIII, final IBlockState lllllllllllllllllIllllIIlIlIIlll, final AxisAlignedBB lllllllllllllllllIllllIIlIlIIllI, final List lllllllllllllllllIllllIIlIlIllIl, final Entity lllllllllllllllllIllllIIlIlIllII) {
        final AxisAlignedBB lllllllllllllllllIllllIIlIlIlIll = this.getCollisionBoundingBox(lllllllllllllllllIllllIIlIllIIIl, lllllllllllllllllIllllIIlIlIlIII, lllllllllllllllllIllllIIlIlIIlll);
        if (lllllllllllllllllIllllIIlIlIlIll != null && lllllllllllllllllIllllIIlIlIIllI.intersectsWith(lllllllllllllllllIllllIIlIlIlIll)) {
            lllllllllllllllllIllllIIlIlIllIl.add(lllllllllllllllllIllllIIlIlIlIll);
        }
    }
    
    public boolean isFullBlock() {
        return this.fullBlock;
    }
    
    public boolean onBlockActivated(final World lllllllllllllllllIlllIlllIIlllll, final BlockPos lllllllllllllllllIlllIlllIIllllI, final IBlockState lllllllllllllllllIlllIlllIIlllIl, final EntityPlayer lllllllllllllllllIlllIlllIIlllII, final EnumFacing lllllllllllllllllIlllIlllIIllIll, final float lllllllllllllllllIlllIlllIIllIlI, final float lllllllllllllllllIlllIlllIIllIIl, final float lllllllllllllllllIlllIlllIIllIII) {
        return false;
    }
    
    public String getUnlocalizedName() {
        return String.valueOf(new StringBuilder("tile.").append(this.unlocalizedName));
    }
    
    public static Block getBlockById(final int lllllllllllllllllIllllIlIlllllII) {
        return (Block)Block.blockRegistry.getObjectById(lllllllllllllllllIllllIlIlllllII);
    }
    
    public boolean hasComparatorInputOverride() {
        return false;
    }
    
    public void onBlockPlacedBy(final World lllllllllllllllllIlllIllIIIllIlI, final BlockPos lllllllllllllllllIlllIllIIIllIIl, final IBlockState lllllllllllllllllIlllIllIIIllIII, final EntityLivingBase lllllllllllllllllIlllIllIIIlIlll, final ItemStack lllllllllllllllllIlllIllIIIlIllI) {
    }
    
    public boolean requiresUpdates() {
        return true;
    }
    
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.NONE;
    }
    
    public MapColor getMapColor(final IBlockState lllllllllllllllllIllllIlIlIlIIIl) {
        return this.getMaterial().getMaterialMapColor();
    }
    
    public float getPlayerRelativeBlockHardness(final EntityPlayer lllllllllllllllllIllllIIIlIllIlI, final World lllllllllllllllllIllllIIIlIllIIl, final BlockPos lllllllllllllllllIllllIIIlIllIII) {
        final float lllllllllllllllllIllllIIIlIlIlll = this.getBlockHardness(lllllllllllllllllIllllIIIlIllIIl, lllllllllllllllllIllllIIIlIllIII);
        return (lllllllllllllllllIllllIIIlIlIlll < 0.0f) ? 0.0f : (lllllllllllllllllIllllIIIlIllIlI.canHarvestBlock(this) ? (lllllllllllllllllIllllIIIlIllIlI.func_180471_a(this) / lllllllllllllllllIllllIIIlIlIlll / 30.0f) : (lllllllllllllllllIllllIIIlIllIlI.func_180471_a(this) / lllllllllllllllllIllllIIIlIlIlll / 100.0f));
    }
    
    public boolean isVisuallyOpaque() {
        return this.blockMaterial.blocksMovement() && this.isFullCube();
    }
    
    protected Block setStepSound(final SoundType lllllllllllllllllIllllIlIIllIllI) {
        this.stepSound = lllllllllllllllllIllllIlIIllIllI;
        return this;
    }
    
    static {
        __OBFID = "CL_00000199";
        AIR_ID = new ResourceLocation("air");
        blockRegistry = new RegistryNamespacedDefaultedByKey(Block.AIR_ID);
        BLOCK_STATE_IDS = new ObjectIntIdentityMap();
        soundTypeStone = new SoundType("stone", 1.0f, 1.0f);
        soundTypeWood = new SoundType("wood", 1.0f, 1.0f);
        soundTypeGravel = new SoundType("gravel", 1.0f, 1.0f);
        soundTypeGrass = new SoundType("grass", 1.0f, 1.0f);
        soundTypePiston = new SoundType("stone", 1.0f, 1.0f);
        soundTypeMetal = new SoundType("stone", 1.0f, 1.5f);
        soundTypeGlass = new SoundType(1.0f, 1.0f) {
            static {
                __OBFID = "CL_00000200";
            }
            
            @Override
            public String getBreakSound() {
                return "dig.glass";
            }
            
            @Override
            public String getPlaceSound() {
                return "step.stone";
            }
        };
        soundTypeCloth = new SoundType("cloth", 1.0f, 1.0f);
        soundTypeSand = new SoundType("sand", 1.0f, 1.0f);
        soundTypeSnow = new SoundType("snow", 1.0f, 1.0f);
        soundTypeLadder = new SoundType(1.0f, 1.0f) {
            static {
                __OBFID = "CL_00000201";
            }
            
            @Override
            public String getBreakSound() {
                return "dig.wood";
            }
        };
        soundTypeAnvil = new SoundType(0.3f, 1.0f) {
            @Override
            public String getBreakSound() {
                return "dig.stone";
            }
            
            @Override
            public String getPlaceSound() {
                return "random.anvil_land";
            }
            
            static {
                __OBFID = "CL_00000202";
            }
        };
        SLIME_SOUND = new SoundType(1.0f, 1.0f) {
            @Override
            public String getPlaceSound() {
                return "mob.slime.big";
            }
            
            @Override
            public String getBreakSound() {
                return "mob.slime.big";
            }
            
            static {
                __OBFID = "CL_00002133";
            }
            
            @Override
            public String getStepSound() {
                return "mob.slime.small";
            }
        };
    }
    
    protected Block(final Material lllllllllllllllllIllllIlIIlllllI) {
        this.enableStats = true;
        this.stepSound = Block.soundTypeStone;
        this.blockParticleGravity = 1.0f;
        this.slipperiness = 0.6f;
        this.blockMaterial = lllllllllllllllllIllllIlIIlllllI;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.fullBlock = this.isOpaqueCube();
        this.lightOpacity = (this.isOpaqueCube() ? 255 : 0);
        this.translucent = !lllllllllllllllllIllllIlIIlllllI.blocksLight();
        this.blockState = this.createBlockState();
        this.setDefaultState(this.blockState.getBaseState());
    }
    
    public final double getBlockBoundsMaxZ() {
        return this.maxZ;
    }
    
    public void onLanded(final World lllllllllllllllllIlllIlIlllIllII, final Entity lllllllllllllllllIlllIlIlllIlIlI) {
        lllllllllllllllllIlllIlIlllIlIlI.motionY = 0.0;
    }
    
    public IBlockState getActualState(final IBlockState lllllllllllllllllIllllIlIlIIIIlI, final IBlockAccess lllllllllllllllllIllllIlIlIIIlII, final BlockPos lllllllllllllllllIllllIlIlIIIIll) {
        return lllllllllllllllllIllllIlIlIIIIlI;
    }
    
    public void onBlockClicked(final World lllllllllllllllllIlllIlllIIIIlIl, final BlockPos lllllllllllllllllIlllIlllIIIIlII, final EntityPlayer lllllllllllllllllIlllIlllIIIIIll) {
    }
    
    public enum EnumOffsetType
    {
        NONE("NONE", 0, "NONE", 0), 
        XZ("XZ", 1, "XZ", 1), 
        XYZ("XYZ", 2, "XYZ", 2);
        
        static {
            __OBFID = "CL_00002132";
        }
        
        private EnumOffsetType(final String lllllllllllllllllllIIIllIllIlIlI, final int lllllllllllllllllllIIIllIllIlIIl, final String lllllllllllllllllllIIIllIllIllIl, final int lllllllllllllllllllIIIllIllIllII) {
        }
    }
    
    public static class SoundType
    {
        public final /* synthetic */ String soundName;
        public final /* synthetic */ float volume;
        public final /* synthetic */ float frequency;
        
        public String getBreakSound() {
            return String.valueOf(new StringBuilder("dig.").append(this.soundName));
        }
        
        static {
            __OBFID = "CL_00000203";
        }
        
        public String getStepSound() {
            return String.valueOf(new StringBuilder("step.").append(this.soundName));
        }
        
        public SoundType(final String llllIIlIIlIIIII, final float llllIIlIIlIIIll, final float llllIIlIIlIIIlI) {
            this.soundName = llllIIlIIlIIIII;
            this.volume = llllIIlIIlIIIll;
            this.frequency = llllIIlIIlIIIlI;
        }
        
        public String getPlaceSound() {
            return this.getBreakSound();
        }
        
        public float getVolume() {
            return this.volume;
        }
        
        public float getFrequency() {
            return this.frequency;
        }
    }
}
