package optifine;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.chunk.*;

public class DynamicLight
{
    private /* synthetic */ double lastPosZ;
    private /* synthetic */ double lastPosX;
    private /* synthetic */ int lastLightLevel;
    private /* synthetic */ double offsetY;
    private /* synthetic */ Entity entity;
    private /* synthetic */ BlockPosM blockPosMutable;
    private /* synthetic */ boolean underwater;
    private /* synthetic */ long timeCheckMs;
    private /* synthetic */ Set<BlockPos> setLitChunkPos;
    private /* synthetic */ double lastPosY;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Entity: ").append(this.entity).append(", offsetY: ").append(this.offsetY));
    }
    
    public Entity getEntity() {
        return this.entity;
    }
    
    public DynamicLight(final Entity llllllllllllllIlIIlIlIIlIIllIIII) {
        this.entity = null;
        this.offsetY = 0.0;
        this.lastPosX = -2.147483648E9;
        this.lastPosY = -2.147483648E9;
        this.lastPosZ = -2.147483648E9;
        this.lastLightLevel = 0;
        this.underwater = false;
        this.timeCheckMs = 0L;
        this.setLitChunkPos = new HashSet<BlockPos>();
        this.blockPosMutable = new BlockPosM(0, 0, 0);
        this.entity = llllllllllllllIlIIlIlIIlIIllIIII;
        this.offsetY = llllllllllllllIlIIlIlIIlIIllIIII.getEyeHeight();
    }
    
    public double getOffsetY() {
        return this.offsetY;
    }
    
    public void updateLitChunks(final RenderGlobal llllllllllllllIlIIlIlIIIllIIllII) {
        for (final BlockPos llllllllllllllIlIIlIlIIIllIIlIlI : this.setLitChunkPos) {
            final RenderChunk llllllllllllllIlIIlIlIIIllIIlIIl = llllllllllllllIlIIlIlIIIllIIllII.getRenderChunk(llllllllllllllIlIIlIlIIIllIIlIlI);
            this.updateChunkLight(llllllllllllllIlIIlIlIIIllIIlIIl, null, null);
        }
    }
    
    public void update(final RenderGlobal llllllllllllllIlIIlIlIIIlllllIIl) {
        if (Config.isDynamicLightsFast()) {
            final long llllllllllllllIlIIlIlIIlIIIlIIll = System.currentTimeMillis();
            if (llllllllllllllIlIIlIlIIlIIIlIIll < this.timeCheckMs + 500L) {
                return;
            }
            this.timeCheckMs = llllllllllllllIlIIlIlIIlIIIlIIll;
        }
        final double llllllllllllllIlIIlIlIIlIIIlIIlI = this.entity.posX - 0.5;
        final double llllllllllllllIlIIlIlIIlIIIlIIIl = this.entity.posY - 0.5 + this.offsetY;
        final double llllllllllllllIlIIlIlIIlIIIlIIII = this.entity.posZ - 0.5;
        final int llllllllllllllIlIIlIlIIlIIIIllll = DynamicLights.getLightLevel(this.entity);
        final double llllllllllllllIlIIlIlIIlIIIIlllI = llllllllllllllIlIIlIlIIlIIIlIIlI - this.lastPosX;
        final double llllllllllllllIlIIlIlIIlIIIIllIl = llllllllllllllIlIIlIlIIlIIIlIIIl - this.lastPosY;
        final double llllllllllllllIlIIlIlIIlIIIIllII = llllllllllllllIlIIlIlIIlIIIlIIII - this.lastPosZ;
        final double llllllllllllllIlIIlIlIIlIIIIlIll = 0.1;
        if (Math.abs(llllllllllllllIlIIlIlIIlIIIIlllI) > llllllllllllllIlIIlIlIIlIIIIlIll || Math.abs(llllllllllllllIlIIlIlIIlIIIIllIl) > llllllllllllllIlIIlIlIIlIIIIlIll || Math.abs(llllllllllllllIlIIlIlIIlIIIIllII) > llllllllllllllIlIIlIlIIlIIIIlIll || this.lastLightLevel != llllllllllllllIlIIlIlIIlIIIIllll) {
            this.lastPosX = llllllllllllllIlIIlIlIIlIIIlIIlI;
            this.lastPosY = llllllllllllllIlIIlIlIIlIIIlIIIl;
            this.lastPosZ = llllllllllllllIlIIlIlIIlIIIlIIII;
            this.lastLightLevel = llllllllllllllIlIIlIlIIlIIIIllll;
            this.underwater = false;
            final WorldClient llllllllllllllIlIIlIlIIlIIIIlIlI = llllllllllllllIlIIlIlIIIlllllIIl.getWorld();
            if (llllllllllllllIlIIlIlIIlIIIIlIlI != null) {
                this.blockPosMutable.setXyz(MathHelper.floor_double(llllllllllllllIlIIlIlIIlIIIlIIlI), MathHelper.floor_double(llllllllllllllIlIIlIlIIlIIIlIIIl), MathHelper.floor_double(llllllllllllllIlIIlIlIIlIIIlIIII));
                final IBlockState llllllllllllllIlIIlIlIIlIIIIlIIl = llllllllllllllIlIIlIlIIlIIIIlIlI.getBlockState(this.blockPosMutable);
                final Block llllllllllllllIlIIlIlIIlIIIIlIII = llllllllllllllIlIIlIlIIlIIIIlIIl.getBlock();
                this.underwater = (llllllllllllllIlIIlIlIIlIIIIlIII == Blocks.water);
            }
            final HashSet llllllllllllllIlIIlIlIIlIIIIIlll = new HashSet();
            if (llllllllllllllIlIIlIlIIlIIIIllll > 0) {
                final EnumFacing llllllllllllllIlIIlIlIIlIIIIIllI = ((MathHelper.floor_double(llllllllllllllIlIIlIlIIlIIIlIIlI) & 0xF) >= 8) ? EnumFacing.EAST : EnumFacing.WEST;
                final EnumFacing llllllllllllllIlIIlIlIIlIIIIIlIl = ((MathHelper.floor_double(llllllllllllllIlIIlIlIIlIIIlIIIl) & 0xF) >= 8) ? EnumFacing.UP : EnumFacing.DOWN;
                final EnumFacing llllllllllllllIlIIlIlIIlIIIIIlII = ((MathHelper.floor_double(llllllllllllllIlIIlIlIIlIIIlIIII) & 0xF) >= 8) ? EnumFacing.SOUTH : EnumFacing.NORTH;
                final BlockPos llllllllllllllIlIIlIlIIlIIIIIIll = new BlockPos(llllllllllllllIlIIlIlIIlIIIlIIlI, llllllllllllllIlIIlIlIIlIIIlIIIl, llllllllllllllIlIIlIlIIlIIIlIIII);
                final RenderChunk llllllllllllllIlIIlIlIIlIIIIIIlI = llllllllllllllIlIIlIlIIIlllllIIl.getRenderChunk(llllllllllllllIlIIlIlIIlIIIIIIll);
                final RenderChunk llllllllllllllIlIIlIlIIlIIIIIIIl = llllllllllllllIlIIlIlIIIlllllIIl.getRenderChunk(llllllllllllllIlIIlIlIIlIIIIIIlI, llllllllllllllIlIIlIlIIlIIIIIllI);
                final RenderChunk llllllllllllllIlIIlIlIIlIIIIIIII = llllllllllllllIlIIlIlIIIlllllIIl.getRenderChunk(llllllllllllllIlIIlIlIIlIIIIIIlI, llllllllllllllIlIIlIlIIlIIIIIlII);
                final RenderChunk llllllllllllllIlIIlIlIIIllllllll = llllllllllllllIlIIlIlIIIlllllIIl.getRenderChunk(llllllllllllllIlIIlIlIIlIIIIIIIl, llllllllllllllIlIIlIlIIlIIIIIlII);
                final RenderChunk llllllllllllllIlIIlIlIIIlllllllI = llllllllllllllIlIIlIlIIIlllllIIl.getRenderChunk(llllllllllllllIlIIlIlIIlIIIIIIlI, llllllllllllllIlIIlIlIIlIIIIIlIl);
                final RenderChunk llllllllllllllIlIIlIlIIIllllllIl = llllllllllllllIlIIlIlIIIlllllIIl.getRenderChunk(llllllllllllllIlIIlIlIIIlllllllI, llllllllllllllIlIIlIlIIlIIIIIllI);
                final RenderChunk llllllllllllllIlIIlIlIIIllllllII = llllllllllllllIlIIlIlIIIlllllIIl.getRenderChunk(llllllllllllllIlIIlIlIIIlllllllI, llllllllllllllIlIIlIlIIlIIIIIlII);
                final RenderChunk llllllllllllllIlIIlIlIIIlllllIll = llllllllllllllIlIIlIlIIIlllllIIl.getRenderChunk(llllllllllllllIlIIlIlIIIllllllIl, llllllllllllllIlIIlIlIIlIIIIIlII);
                this.updateChunkLight(llllllllllllllIlIIlIlIIlIIIIIIlI, this.setLitChunkPos, llllllllllllllIlIIlIlIIlIIIIIlll);
                this.updateChunkLight(llllllllllllllIlIIlIlIIlIIIIIIIl, this.setLitChunkPos, llllllllllllllIlIIlIlIIlIIIIIlll);
                this.updateChunkLight(llllllllllllllIlIIlIlIIlIIIIIIII, this.setLitChunkPos, llllllllllllllIlIIlIlIIlIIIIIlll);
                this.updateChunkLight(llllllllllllllIlIIlIlIIIllllllll, this.setLitChunkPos, llllllllllllllIlIIlIlIIlIIIIIlll);
                this.updateChunkLight(llllllllllllllIlIIlIlIIIlllllllI, this.setLitChunkPos, llllllllllllllIlIIlIlIIlIIIIIlll);
                this.updateChunkLight(llllllllllllllIlIIlIlIIIllllllIl, this.setLitChunkPos, llllllllllllllIlIIlIlIIlIIIIIlll);
                this.updateChunkLight(llllllllllllllIlIIlIlIIIllllllII, this.setLitChunkPos, llllllllllllllIlIIlIlIIlIIIIIlll);
                this.updateChunkLight(llllllllllllllIlIIlIlIIIlllllIll, this.setLitChunkPos, llllllllllllllIlIIlIlIIlIIIIIlll);
            }
            this.updateLitChunks(llllllllllllllIlIIlIlIIIlllllIIl);
            this.setLitChunkPos = (Set<BlockPos>)llllllllllllllIlIIlIlIIlIIIIIlll;
        }
    }
    
    private void updateChunkLight(final RenderChunk llllllllllllllIlIIlIlIIIllIlIlll, final Set<BlockPos> llllllllllllllIlIIlIlIIIllIlIllI, final Set<BlockPos> llllllllllllllIlIIlIlIIIllIlIlIl) {
        if (llllllllllllllIlIIlIlIIIllIlIlll != null) {
            final CompiledChunk llllllllllllllIlIIlIlIIIllIllIIl = llllllllllllllIlIIlIlIIIllIlIlll.func_178571_g();
            if (llllllllllllllIlIIlIlIIIllIllIIl != null && !llllllllllllllIlIIlIlIIIllIllIIl.func_178489_a()) {
                llllllllllllllIlIIlIlIIIllIlIlll.func_178575_a(true);
            }
            final BlockPos llllllllllllllIlIIlIlIIIllIllIII = llllllllllllllIlIIlIlIIIllIlIlll.func_178568_j();
            if (llllllllllllllIlIIlIlIIIllIlIllI != null) {
                llllllllllllllIlIIlIlIIIllIlIllI.remove(llllllllllllllIlIIlIlIIIllIllIII);
            }
            if (llllllllllllllIlIIlIlIIIllIlIlIl != null) {
                llllllllllllllIlIIlIlIIIllIlIlIl.add(llllllllllllllIlIIlIlIIIllIllIII);
            }
        }
    }
    
    public double getLastPosZ() {
        return this.lastPosZ;
    }
    
    public double getLastPosY() {
        return this.lastPosY;
    }
    
    public int getLastLightLevel() {
        return this.lastLightLevel;
    }
    
    public double getLastPosX() {
        return this.lastPosX;
    }
    
    public boolean isUnderwater() {
        return this.underwater;
    }
}
