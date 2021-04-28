package net.minecraft.tileentity;

import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.crash.*;
import java.util.concurrent.*;
import net.minecraft.block.state.*;
import net.minecraft.network.*;
import net.minecraft.init.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.block.*;

public abstract class TileEntity
{
    protected /* synthetic */ boolean tileEntityInvalid;
    protected /* synthetic */ World worldObj;
    protected /* synthetic */ BlockPos pos;
    private /* synthetic */ int blockMetadata;
    private static /* synthetic */ Map classToNameMap;
    private static /* synthetic */ Map nameToClassMap;
    private static final /* synthetic */ Logger logger;
    protected /* synthetic */ Block blockType;
    
    public void writeToNBT(final NBTTagCompound lllIllIIIlIllI) {
        final String lllIllIIIllIII = TileEntity.classToNameMap.get(this.getClass());
        if (lllIllIIIllIII == null) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append(this.getClass()).append(" is missing a mapping! This is a bug!")));
        }
        lllIllIIIlIllI.setString("id", lllIllIIIllIII);
        lllIllIIIlIllI.setInteger("x", this.pos.getX());
        lllIllIIIlIllI.setInteger("y", this.pos.getY());
        lllIllIIIlIllI.setInteger("z", this.pos.getZ());
    }
    
    public void validate() {
        this.tileEntityInvalid = false;
    }
    
    public void setWorldObj(final World lllIllIIlIlIIl) {
        this.worldObj = lllIllIIlIlIIl;
    }
    
    public void addInfoToCrashReport(final CrashReportCategory lllIlIllIIllll) {
        lllIlIllIIllll.addCrashSectionCallable("Name", new Callable() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(TileEntity.classToNameMap.get(TileEntity.this.getClass()))).append(" // ").append(TileEntity.this.getClass().getCanonicalName()));
            }
            
            static {
                __OBFID = "CL_00000341";
            }
        });
        if (this.worldObj != null) {
            CrashReportCategory.addBlockInfo(lllIlIllIIllll, this.pos, this.getBlockType(), this.getBlockMetadata());
            lllIlIllIIllll.addCrashSectionCallable("Actual block type", new Callable() {
                static {
                    __OBFID = "CL_00000343";
                }
                
                @Override
                public String call() {
                    final int llllllllllllllllIIlIlIIIlllllIll = Block.getIdFromBlock(TileEntity.this.worldObj.getBlockState(TileEntity.this.pos).getBlock());
                    try {
                        return String.format("ID #%d (%s // %s)", llllllllllllllllIIlIlIIIlllllIll, Block.getBlockById(llllllllllllllllIIlIlIIIlllllIll).getUnlocalizedName(), Block.getBlockById(llllllllllllllllIIlIlIIIlllllIll).getClass().getCanonicalName());
                    }
                    catch (Throwable llllllllllllllllIIlIlIIIlllllIlI) {
                        return String.valueOf(new StringBuilder("ID #").append(llllllllllllllllIIlIlIIIlllllIll));
                    }
                }
            });
            lllIlIllIIllll.addCrashSectionCallable("Actual block data value", new Callable() {
                @Override
                public String call() {
                    final IBlockState llllllllllllllllIIIlllllIlllIlII = TileEntity.this.worldObj.getBlockState(TileEntity.this.pos);
                    final int llllllllllllllllIIIlllllIlllIIll = llllllllllllllllIIIlllllIlllIlII.getBlock().getMetaFromState(llllllllllllllllIIIlllllIlllIlII);
                    if (llllllllllllllllIIIlllllIlllIIll < 0) {
                        return String.valueOf(new StringBuilder("Unknown? (Got ").append(llllllllllllllllIIIlllllIlllIIll).append(")"));
                    }
                    final String llllllllllllllllIIIlllllIlllIIlI = String.format("%4s", Integer.toBinaryString(llllllllllllllllIIIlllllIlllIIll)).replace(" ", "0");
                    return String.format("%1$d / 0x%1$X / 0b%2$s", llllllllllllllllIIIlllllIlllIIll, llllllllllllllllIIIlllllIlllIIlI);
                }
                
                static {
                    __OBFID = "CL_00000344";
                }
            });
        }
    }
    
    public Packet getDescriptionPacket() {
        return null;
    }
    
    public TileEntity() {
        this.pos = BlockPos.ORIGIN;
        this.blockMetadata = -1;
    }
    
    public void markDirty() {
        if (this.worldObj != null) {
            final IBlockState lllIllIIIIIIIl = this.worldObj.getBlockState(this.pos);
            this.blockMetadata = lllIllIIIIIIIl.getBlock().getMetaFromState(lllIllIIIIIIIl);
            this.worldObj.func_175646_b(this.pos, this);
            if (this.getBlockType() != Blocks.air) {
                this.worldObj.updateComparatorOutputLevel(this.pos, this.getBlockType());
            }
        }
    }
    
    public Block getBlockType() {
        if (this.blockType == null) {
            this.blockType = this.worldObj.getBlockState(this.pos).getBlock();
        }
        return this.blockType;
    }
    
    public int getBlockMetadata() {
        if (this.blockMetadata == -1) {
            final IBlockState lllIllIIIIIlll = this.worldObj.getBlockState(this.pos);
            this.blockMetadata = lllIllIIIIIlll.getBlock().getMetaFromState(lllIllIIIIIlll);
        }
        return this.blockMetadata;
    }
    
    public World getWorld() {
        return this.worldObj;
    }
    
    public boolean isInvalid() {
        return this.tileEntityInvalid;
    }
    
    public boolean receiveClientEvent(final int lllIlIllIlIlll, final int lllIlIllIlIllI) {
        return false;
    }
    
    public void updateContainingBlockInfo() {
        this.blockType = null;
        this.blockMetadata = -1;
    }
    
    public void readFromNBT(final NBTTagCompound lllIllIIlIIIII) {
        this.pos = new BlockPos(lllIllIIlIIIII.getInteger("x"), lllIllIIlIIIII.getInteger("y"), lllIllIIlIIIII.getInteger("z"));
    }
    
    public BlockPos getPos() {
        return this.pos;
    }
    
    public static TileEntity createAndLoadEntity(final NBTTagCompound lllIllIIIIllIl) {
        TileEntity lllIllIIIlIIII = null;
        try {
            final Class lllIllIIIIllll = TileEntity.nameToClassMap.get(lllIllIIIIllIl.getString("id"));
            if (lllIllIIIIllll != null) {
                lllIllIIIlIIII = lllIllIIIIllll.newInstance();
            }
        }
        catch (Exception lllIllIIIIlllI) {
            lllIllIIIIlllI.printStackTrace();
        }
        if (lllIllIIIlIIII != null) {
            lllIllIIIlIIII.readFromNBT(lllIllIIIIllIl);
        }
        else {
            TileEntity.logger.warn(String.valueOf(new StringBuilder("Skipping BlockEntity with id ").append(lllIllIIIIllIl.getString("id"))));
        }
        return lllIllIIIlIIII;
    }
    
    static {
        __OBFID = "CL_00000340";
        logger = LogManager.getLogger();
        TileEntity.nameToClassMap = Maps.newHashMap();
        TileEntity.classToNameMap = Maps.newHashMap();
        addMapping(TileEntityFurnace.class, "Furnace");
        addMapping(TileEntityChest.class, "Chest");
        addMapping(TileEntityEnderChest.class, "EnderChest");
        addMapping(BlockJukebox.TileEntityJukebox.class, "RecordPlayer");
        addMapping(TileEntityDispenser.class, "Trap");
        addMapping(TileEntityDropper.class, "Dropper");
        addMapping(TileEntitySign.class, "Sign");
        addMapping(TileEntityMobSpawner.class, "MobSpawner");
        addMapping(TileEntityNote.class, "Music");
        addMapping(TileEntityPiston.class, "Piston");
        addMapping(TileEntityBrewingStand.class, "Cauldron");
        addMapping(TileEntityEnchantmentTable.class, "EnchantTable");
        addMapping(TileEntityEndPortal.class, "Airportal");
        addMapping(TileEntityCommandBlock.class, "Control");
        addMapping(TileEntityBeacon.class, "Beacon");
        addMapping(TileEntitySkull.class, "Skull");
        addMapping(TileEntityDaylightDetector.class, "DLDetector");
        addMapping(TileEntityHopper.class, "Hopper");
        addMapping(TileEntityComparator.class, "Comparator");
        addMapping(TileEntityFlowerPot.class, "FlowerPot");
        addMapping(TileEntityBanner.class, "Banner");
    }
    
    private static void addMapping(final Class lllIllIIllIIIl, final String lllIllIIllIIlI) {
        if (TileEntity.nameToClassMap.containsKey(lllIllIIllIIlI)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Duplicate id: ").append(lllIllIIllIIlI)));
        }
        TileEntity.nameToClassMap.put(lllIllIIllIIlI, lllIllIIllIIIl);
        TileEntity.classToNameMap.put(lllIllIIllIIIl, lllIllIIllIIlI);
    }
    
    public boolean hasWorldObj() {
        return this.worldObj != null;
    }
    
    public void invalidate() {
        this.tileEntityInvalid = true;
    }
    
    public double getMaxRenderDistanceSquared() {
        return 4096.0;
    }
    
    public void setPos(final BlockPos lllIlIllIIlIIl) {
        this.pos = lllIlIllIIlIIl;
    }
    
    public double getDistanceSq(final double lllIlIllllIllI, final double lllIlIllllIlIl, final double lllIlIlllIllIl) {
        final double lllIlIllllIIll = this.pos.getX() + 0.5 - lllIlIllllIllI;
        final double lllIlIllllIIlI = this.pos.getY() + 0.5 - lllIlIllllIlIl;
        final double lllIlIllllIIIl = this.pos.getZ() + 0.5 - lllIlIlllIllIl;
        return lllIlIllllIIll * lllIlIllllIIll + lllIlIllllIIlI * lllIlIllllIIlI + lllIlIllllIIIl * lllIlIllllIIIl;
    }
}
