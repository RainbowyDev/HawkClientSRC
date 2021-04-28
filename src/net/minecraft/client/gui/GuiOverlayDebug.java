package net.minecraft.client.gui;

import com.google.common.base.*;
import org.lwjgl.opengl.*;
import optifine.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.block.state.*;
import com.google.common.collect.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.*;

public class GuiOverlayDebug extends Gui
{
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ FontRenderer fontRenderer;
    
    protected void func_180798_a() {
        final List llllllllllllllllllllIllIlllIIlII = this.call();
        for (int llllllllllllllllllllIllIlllIIIll = 0; llllllllllllllllllllIllIlllIIIll < llllllllllllllllllllIllIlllIIlII.size(); ++llllllllllllllllllllIllIlllIIIll) {
            final String llllllllllllllllllllIllIlllIIIlI = llllllllllllllllllllIllIlllIIlII.get(llllllllllllllllllllIllIlllIIIll);
            if (!Strings.isNullOrEmpty(llllllllllllllllllllIllIlllIIIlI)) {
                final int llllllllllllllllllllIllIlllIIIIl = this.fontRenderer.FONT_HEIGHT;
                final int llllllllllllllllllllIllIlllIIIII = this.fontRenderer.getStringWidth(llllllllllllllllllllIllIlllIIIlI);
                final boolean llllllllllllllllllllIllIllIlllll = true;
                final int llllllllllllllllllllIllIllIllllI = 2 + llllllllllllllllllllIllIlllIIIIl * llllllllllllllllllllIllIlllIIIll;
                Gui.drawRect(1.0, llllllllllllllllllllIllIllIllllI - 1, 2 + llllllllllllllllllllIllIlllIIIII + 1, llllllllllllllllllllIllIllIllllI + llllllllllllllllllllIllIlllIIIIl - 1, -1873784752);
                this.fontRenderer.drawString(llllllllllllllllllllIllIlllIIIlI, 2.0, llllllllllllllllllllIllIllIllllI, 14737632);
            }
        }
    }
    
    static {
        __OBFID = "CL_00001956";
    }
    
    protected void func_175239_b(final ScaledResolution llllllllllllllllllllIllIllIIlIll) {
        final List llllllllllllllllllllIllIllIIlIlI = this.func_175238_c();
        for (int llllllllllllllllllllIllIllIIlIIl = 0; llllllllllllllllllllIllIllIIlIIl < llllllllllllllllllllIllIllIIlIlI.size(); ++llllllllllllllllllllIllIllIIlIIl) {
            final String llllllllllllllllllllIllIllIIlIII = llllllllllllllllllllIllIllIIlIlI.get(llllllllllllllllllllIllIllIIlIIl);
            if (!Strings.isNullOrEmpty(llllllllllllllllllllIllIllIIlIII)) {
                final int llllllllllllllllllllIllIllIIIlll = this.fontRenderer.FONT_HEIGHT;
                final int llllllllllllllllllllIllIllIIIllI = this.fontRenderer.getStringWidth(llllllllllllllllllllIllIllIIlIII);
                final int llllllllllllllllllllIllIllIIIlIl = llllllllllllllllllllIllIllIIlIll.getScaledWidth() - 2 - llllllllllllllllllllIllIllIIIllI;
                final int llllllllllllllllllllIllIllIIIlII = 2 + llllllllllllllllllllIllIllIIIlll * llllllllllllllllllllIllIllIIlIIl;
                Gui.drawRect(llllllllllllllllllllIllIllIIIlIl - 1, llllllllllllllllllllIllIllIIIlII - 1, llllllllllllllllllllIllIllIIIlIl + llllllllllllllllllllIllIllIIIllI + 1, llllllllllllllllllllIllIllIIIlII + llllllllllllllllllllIllIllIIIlll - 1, -1873784752);
                this.fontRenderer.drawString(llllllllllllllllllllIllIllIIlIII, llllllllllllllllllllIllIllIIIlIl, llllllllllllllllllllIllIllIIIlII, 14737632);
            }
        }
    }
    
    private boolean func_175236_d() {
        return this.mc.thePlayer.func_175140_cp() || this.mc.gameSettings.field_178879_v;
    }
    
    public GuiOverlayDebug(final Minecraft llllllllllllllllllllIllIllllIlll) {
        this.mc = llllllllllllllllllllIllIllllIlll;
        this.fontRenderer = llllllllllllllllllllIllIllllIlll.fontRendererObj;
    }
    
    protected List func_175238_c() {
        final long llllllllllllllllllllIllIlIIlIIlI = Runtime.getRuntime().maxMemory();
        final long llllllllllllllllllllIllIlIIlIIIl = Runtime.getRuntime().totalMemory();
        final long llllllllllllllllllllIllIlIIlIIII = Runtime.getRuntime().freeMemory();
        final long llllllllllllllllllllIllIlIIIllll = llllllllllllllllllllIllIlIIlIIIl - llllllllllllllllllllIllIlIIlIIII;
        final ArrayList llllllllllllllllllllIllIlIIIlllI = Lists.newArrayList((Object[])new String[] { String.format("Java: %s %dbit", System.getProperty("java.version"), this.mc.isJava64bit() ? 64 : 32), String.format("Mem: % 2d%% %03d/%03dMB", llllllllllllllllllllIllIlIIIllll * 100L / llllllllllllllllllllIllIlIIlIIlI, func_175240_a(llllllllllllllllllllIllIlIIIllll), func_175240_a(llllllllllllllllllllIllIlIIlIIlI)), String.format("Allocated: % 2d%% %03dMB", llllllllllllllllllllIllIlIIlIIIl * 100L / llllllllllllllllllllIllIlIIlIIlI, func_175240_a(llllllllllllllllllllIllIlIIlIIIl)), "", String.format("Display: %dx%d (%s)", Display.getWidth(), Display.getHeight(), GL11.glGetString(7936)), GL11.glGetString(7937), GL11.glGetString(7938) });
        if (Reflector.FMLCommonHandler_getBrandings.exists()) {
            final Object llllllllllllllllllllIllIlIIIllIl = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            llllllllllllllllllllIllIlIIIlllI.add("");
            llllllllllllllllllllIllIlIIIlllI.addAll((Collection)Reflector.call(llllllllllllllllllllIllIlIIIllIl, Reflector.FMLCommonHandler_getBrandings, false));
        }
        if (this.func_175236_d()) {
            return llllllllllllllllllllIllIlIIIlllI;
        }
        if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.mc.objectMouseOver.func_178782_a() != null) {
            final BlockPos llllllllllllllllllllIllIlIIIllII = this.mc.objectMouseOver.func_178782_a();
            IBlockState llllllllllllllllllllIllIlIIIlIll = this.mc.theWorld.getBlockState(llllllllllllllllllllIllIlIIIllII);
            if (this.mc.theWorld.getWorldType() != WorldType.DEBUG_WORLD) {
                llllllllllllllllllllIllIlIIIlIll = llllllllllllllllllllIllIlIIIlIll.getBlock().getActualState(llllllllllllllllllllIllIlIIIlIll, this.mc.theWorld, llllllllllllllllllllIllIlIIIllII);
            }
            llllllllllllllllllllIllIlIIIlllI.add("");
            llllllllllllllllllllIllIlIIIlllI.add(String.valueOf(Block.blockRegistry.getNameForObject(llllllllllllllllllllIllIlIIIlIll.getBlock())));
            for (final Map.Entry llllllllllllllllllllIllIlIIIlIlI : llllllllllllllllllllIllIlIIIlIll.getProperties().entrySet()) {
                String llllllllllllllllllllIllIlIIIlIIl = llllllllllllllllllllIllIlIIIlIlI.getValue().toString();
                if (llllllllllllllllllllIllIlIIIlIlI.getValue() == Boolean.TRUE) {
                    llllllllllllllllllllIllIlIIIlIIl = String.valueOf(new StringBuilder().append(EnumChatFormatting.GREEN).append(llllllllllllllllllllIllIlIIIlIIl));
                }
                else if (llllllllllllllllllllIllIlIIIlIlI.getValue() == Boolean.FALSE) {
                    llllllllllllllllllllIllIlIIIlIIl = String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append(llllllllllllllllllllIllIlIIIlIIl));
                }
                llllllllllllllllllllIllIlIIIlllI.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllllIllIlIIIlIlI.getKey().getName())).append(": ").append(llllllllllllllllllllIllIlIIIlIIl)));
            }
        }
        return llllllllllllllllllllIllIlIIIlllI;
    }
    
    protected List call() {
        final BlockPos llllllllllllllllllllIllIlIllIIII = new BlockPos(this.mc.func_175606_aa().posX, this.mc.func_175606_aa().getEntityBoundingBox().minY, this.mc.func_175606_aa().posZ);
        if (this.func_175236_d()) {
            return Lists.newArrayList((Object[])new String[] { String.valueOf(new StringBuilder("Minecraft 1.8 (").append(this.mc.func_175600_c()).append("/").append(ClientBrandRetriever.getClientModName()).append(")")), this.mc.debug, this.mc.renderGlobal.getDebugInfoRenders(), this.mc.renderGlobal.getDebugInfoEntities(), String.valueOf(new StringBuilder("P: ").append(this.mc.effectRenderer.getStatistics()).append(". T: ").append(this.mc.theWorld.getDebugLoadedEntities())), this.mc.theWorld.getProviderName(), "", String.format("Chunk-relative: %d %d %d", llllllllllllllllllllIllIlIllIIII.getX() & 0xF, llllllllllllllllllllIllIlIllIIII.getY() & 0xF, llllllllllllllllllllIllIlIllIIII.getZ() & 0xF) });
        }
        final Entity llllllllllllllllllllIllIlIlIllll = this.mc.func_175606_aa();
        final EnumFacing llllllllllllllllllllIllIlIlIlllI = llllllllllllllllllllIllIlIlIllll.func_174811_aO();
        String llllllllllllllllllllIllIlIlIllIl = "Invalid";
        switch (SwitchEnumFacing.field_178907_a[llllllllllllllllllllIllIlIlIlllI.ordinal()]) {
            case 1: {
                llllllllllllllllllllIllIlIlIllIl = "Towards negative Z";
                break;
            }
            case 2: {
                llllllllllllllllllllIllIlIlIllIl = "Towards positive Z";
                break;
            }
            case 3: {
                llllllllllllllllllllIllIlIlIllIl = "Towards negative X";
                break;
            }
            case 4: {
                llllllllllllllllllllIllIlIlIllIl = "Towards positive X";
                break;
            }
        }
        final ArrayList llllllllllllllllllllIllIlIlIllII = Lists.newArrayList((Object[])new String[] { String.valueOf(new StringBuilder("Minecraft 1.8 (").append(this.mc.func_175600_c()).append("/").append(ClientBrandRetriever.getClientModName()).append(")")), this.mc.debug, this.mc.renderGlobal.getDebugInfoRenders(), this.mc.renderGlobal.getDebugInfoEntities(), String.valueOf(new StringBuilder("P: ").append(this.mc.effectRenderer.getStatistics()).append(". T: ").append(this.mc.theWorld.getDebugLoadedEntities())), this.mc.theWorld.getProviderName(), "", String.format("XYZ: %.3f / %.5f / %.3f", this.mc.func_175606_aa().posX, this.mc.func_175606_aa().getEntityBoundingBox().minY, this.mc.func_175606_aa().posZ), String.format("Block: %d %d %d", llllllllllllllllllllIllIlIllIIII.getX(), llllllllllllllllllllIllIlIllIIII.getY(), llllllllllllllllllllIllIlIllIIII.getZ()), String.format("Chunk: %d %d %d in %d %d %d", llllllllllllllllllllIllIlIllIIII.getX() & 0xF, llllllllllllllllllllIllIlIllIIII.getY() & 0xF, llllllllllllllllllllIllIlIllIIII.getZ() & 0xF, llllllllllllllllllllIllIlIllIIII.getX() >> 4, llllllllllllllllllllIllIlIllIIII.getY() >> 4, llllllllllllllllllllIllIlIllIIII.getZ() >> 4), String.format("Facing: %s (%s) (%.1f / %.1f)", llllllllllllllllllllIllIlIlIlllI, llllllllllllllllllllIllIlIlIllIl, MathHelper.wrapAngleTo180_float(llllllllllllllllllllIllIlIlIllll.rotationYaw), MathHelper.wrapAngleTo180_float(llllllllllllllllllllIllIlIlIllll.rotationPitch)) });
        if (this.mc.theWorld != null && this.mc.theWorld.isBlockLoaded(llllllllllllllllllllIllIlIllIIII)) {
            final Chunk llllllllllllllllllllIllIlIlIlIll = this.mc.theWorld.getChunkFromBlockCoords(llllllllllllllllllllIllIlIllIIII);
            llllllllllllllllllllIllIlIlIllII.add(String.valueOf(new StringBuilder("Biome: ").append(llllllllllllllllllllIllIlIlIlIll.getBiome(llllllllllllllllllllIllIlIllIIII, this.mc.theWorld.getWorldChunkManager()).biomeName)));
            llllllllllllllllllllIllIlIlIllII.add(String.valueOf(new StringBuilder("Light: ").append(llllllllllllllllllllIllIlIlIlIll.setLight(llllllllllllllllllllIllIlIllIIII, 0)).append(" (").append(llllllllllllllllllllIllIlIlIlIll.getLightFor(EnumSkyBlock.SKY, llllllllllllllllllllIllIlIllIIII)).append(" sky, ").append(llllllllllllllllllllIllIlIlIlIll.getLightFor(EnumSkyBlock.BLOCK, llllllllllllllllllllIllIlIllIIII)).append(" block)")));
            DifficultyInstance llllllllllllllllllllIllIlIlIlIlI = this.mc.theWorld.getDifficultyForLocation(llllllllllllllllllllIllIlIllIIII);
            if (this.mc.isIntegratedServerRunning() && this.mc.getIntegratedServer() != null) {
                final EntityPlayerMP llllllllllllllllllllIllIlIlIlIIl = this.mc.getIntegratedServer().getConfigurationManager().func_177451_a(this.mc.thePlayer.getUniqueID());
                if (llllllllllllllllllllIllIlIlIlIIl != null) {
                    llllllllllllllllllllIllIlIlIlIlI = llllllllllllllllllllIllIlIlIlIIl.worldObj.getDifficultyForLocation(new BlockPos(llllllllllllllllllllIllIlIlIlIIl));
                }
            }
            llllllllllllllllllllIllIlIlIllII.add(String.format("Local Difficulty: %.2f (Day %d)", llllllllllllllllllllIllIlIlIlIlI.func_180168_b(), this.mc.theWorld.getWorldTime() / 24000L));
        }
        if (this.mc.entityRenderer != null && this.mc.entityRenderer.isShaderActive()) {
            llllllllllllllllllllIllIlIlIllII.add(String.valueOf(new StringBuilder("Shader: ").append(this.mc.entityRenderer.getShaderGroup().getShaderGroupName())));
        }
        if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.mc.objectMouseOver.func_178782_a() != null) {
            final BlockPos llllllllllllllllllllIllIlIlIlIII = this.mc.objectMouseOver.func_178782_a();
            llllllllllllllllllllIllIlIlIllII.add(String.format("Looking at: %d %d %d", llllllllllllllllllllIllIlIlIlIII.getX(), llllllllllllllllllllIllIlIlIlIII.getY(), llllllllllllllllllllIllIlIlIlIII.getZ()));
        }
        return llllllllllllllllllllIllIlIlIllII;
    }
    
    private static long func_175240_a(final long llllllllllllllllllllIllIIllllIll) {
        return llllllllllllllllllllIllIIllllIll / 1024L / 1024L;
    }
    
    public void func_175237_a(final ScaledResolution llllllllllllllllllllIllIllllIIll) {
        this.mc.mcProfiler.startSection("debug");
        GlStateManager.pushMatrix();
        this.func_180798_a();
        this.func_175239_b(llllllllllllllllllllIllIllllIIll);
        GlStateManager.popMatrix();
        this.mc.mcProfiler.endSection();
    }
    
    static final class SwitchEnumFacing
    {
        static final /* synthetic */ int[] field_178907_a;
        
        static {
            __OBFID = "CL_00001955";
            field_178907_a = new int[EnumFacing.values().length];
            try {
                SwitchEnumFacing.field_178907_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumFacing.field_178907_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumFacing.field_178907_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumFacing.field_178907_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
