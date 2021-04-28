package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.model.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.block.*;

public class TileEntityChestRenderer extends TileEntitySpecialRenderer
{
    private static final /* synthetic */ ResourceLocation textureNormal;
    private /* synthetic */ boolean isChristams;
    private static final /* synthetic */ ResourceLocation textureTrappedDouble;
    private /* synthetic */ ModelChest simpleChest;
    private /* synthetic */ ModelChest largeChest;
    private static final /* synthetic */ ResourceLocation textureChristmas;
    private static final /* synthetic */ ResourceLocation textureNormalDouble;
    private static final /* synthetic */ ResourceLocation textureTrapped;
    private static final /* synthetic */ ResourceLocation textureChristmasDouble;
    
    static {
        __OBFID = "CL_00000965";
        textureTrappedDouble = new ResourceLocation("textures/entity/chest/trapped_double.png");
        textureChristmasDouble = new ResourceLocation("textures/entity/chest/christmas_double.png");
        textureNormalDouble = new ResourceLocation("textures/entity/chest/normal_double.png");
        textureTrapped = new ResourceLocation("textures/entity/chest/trapped.png");
        textureChristmas = new ResourceLocation("textures/entity/chest/christmas.png");
        textureNormal = new ResourceLocation("textures/entity/chest/normal.png");
    }
    
    @Override
    public void renderTileEntityAt(final TileEntity lIIIIIllll, final double lIIIIIlllI, final double lIIIIlIlII, final double lIIIIlIIll, final float lIIIIIlIll, final int lIIIIIlIlI) {
        this.func_180538_a((TileEntityChest)lIIIIIllll, lIIIIIlllI, lIIIIlIlII, lIIIIlIIll, lIIIIIlIll, lIIIIIlIlI);
    }
    
    public TileEntityChestRenderer() {
        this.simpleChest = new ModelChest();
        this.largeChest = new ModelLargeChest();
        final Calendar lIIlIIlIIl = Calendar.getInstance();
        if (lIIlIIlIIl.get(2) + 1 == 12 && lIIlIIlIIl.get(5) >= 24 && lIIlIIlIIl.get(5) <= 26) {
            this.isChristams = true;
        }
    }
    
    public void func_180538_a(final TileEntityChest lIIIlllIIl, final double lIIIlIlIII, final double lIIIlIIlll, final double lIIIllIllI, final float lIIIllIlIl, final int lIIIlIIlII) {
        int lIIIllIIlI = 0;
        if (!lIIIlllIIl.hasWorldObj()) {
            final int lIIIllIIll = 0;
        }
        else {
            final Block lIIIllIIIl = lIIIlllIIl.getBlockType();
            lIIIllIIlI = lIIIlllIIl.getBlockMetadata();
            if (lIIIllIIIl instanceof BlockChest && lIIIllIIlI == 0) {
                ((BlockChest)lIIIllIIIl).checkForSurroundingChests(lIIIlllIIl.getWorld(), lIIIlllIIl.getPos(), lIIIlllIIl.getWorld().getBlockState(lIIIlllIIl.getPos()));
                lIIIllIIlI = lIIIlllIIl.getBlockMetadata();
            }
            lIIIlllIIl.checkForAdjacentChests();
        }
        if (lIIIlllIIl.adjacentChestZNeg == null && lIIIlllIIl.adjacentChestXNeg == null) {
            ModelChest lIIIlIllll = null;
            if (lIIIlllIIl.adjacentChestXPos == null && lIIIlllIIl.adjacentChestZPos == null) {
                final ModelChest lIIIllIIII = this.simpleChest;
                if (lIIIlIIlII >= 0) {
                    this.bindTexture(TileEntityChestRenderer.DESTROY_STAGES[lIIIlIIlII]);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(4.0f, 4.0f, 1.0f);
                    GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
                    GlStateManager.matrixMode(5888);
                }
                else if (lIIIlllIIl.getChestType() == 1) {
                    this.bindTexture(TileEntityChestRenderer.textureTrapped);
                }
                else if (this.isChristams) {
                    this.bindTexture(TileEntityChestRenderer.textureChristmas);
                }
                else {
                    this.bindTexture(TileEntityChestRenderer.textureNormal);
                }
            }
            else {
                lIIIlIllll = this.largeChest;
                if (lIIIlIIlII >= 0) {
                    this.bindTexture(TileEntityChestRenderer.DESTROY_STAGES[lIIIlIIlII]);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(8.0f, 4.0f, 1.0f);
                    GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
                    GlStateManager.matrixMode(5888);
                }
                else if (lIIIlllIIl.getChestType() == 1) {
                    this.bindTexture(TileEntityChestRenderer.textureTrappedDouble);
                }
                else if (this.isChristams) {
                    this.bindTexture(TileEntityChestRenderer.textureChristmasDouble);
                }
                else {
                    this.bindTexture(TileEntityChestRenderer.textureNormalDouble);
                }
            }
            GlStateManager.pushMatrix();
            GlStateManager.enableRescaleNormal();
            if (lIIIlIIlII < 0) {
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            }
            GlStateManager.translate((float)lIIIlIlIII, (float)lIIIlIIlll + 1.0f, (float)lIIIllIllI + 1.0f);
            GlStateManager.scale(1.0f, -1.0f, -1.0f);
            GlStateManager.translate(0.5f, 0.5f, 0.5f);
            short lIIIlIlllI = 0;
            if (lIIIllIIlI == 2) {
                lIIIlIlllI = 180;
            }
            if (lIIIllIIlI == 3) {
                lIIIlIlllI = 0;
            }
            if (lIIIllIIlI == 4) {
                lIIIlIlllI = 90;
            }
            if (lIIIllIIlI == 5) {
                lIIIlIlllI = -90;
            }
            if (lIIIllIIlI == 2 && lIIIlllIIl.adjacentChestXPos != null) {
                GlStateManager.translate(1.0f, 0.0f, 0.0f);
            }
            if (lIIIllIIlI == 5 && lIIIlllIIl.adjacentChestZPos != null) {
                GlStateManager.translate(0.0f, 0.0f, -1.0f);
            }
            GlStateManager.rotate(lIIIlIlllI, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(-0.5f, -0.5f, -0.5f);
            float lIIIlIllIl = lIIIlllIIl.prevLidAngle + (lIIIlllIIl.lidAngle - lIIIlllIIl.prevLidAngle) * lIIIllIlIl;
            if (lIIIlllIIl.adjacentChestZNeg != null) {
                final float lIIIlIllII = lIIIlllIIl.adjacentChestZNeg.prevLidAngle + (lIIIlllIIl.adjacentChestZNeg.lidAngle - lIIIlllIIl.adjacentChestZNeg.prevLidAngle) * lIIIllIlIl;
                if (lIIIlIllII > lIIIlIllIl) {
                    lIIIlIllIl = lIIIlIllII;
                }
            }
            if (lIIIlllIIl.adjacentChestXNeg != null) {
                final float lIIIlIlIll = lIIIlllIIl.adjacentChestXNeg.prevLidAngle + (lIIIlllIIl.adjacentChestXNeg.lidAngle - lIIIlllIIl.adjacentChestXNeg.prevLidAngle) * lIIIllIlIl;
                if (lIIIlIlIll > lIIIlIllIl) {
                    lIIIlIllIl = lIIIlIlIll;
                }
            }
            lIIIlIllIl = 1.0f - lIIIlIllIl;
            lIIIlIllIl = 1.0f - lIIIlIllIl * lIIIlIllIl * lIIIlIllIl;
            lIIIlIllll.chestLid.rotateAngleX = -(lIIIlIllIl * 3.1415927f / 2.0f);
            lIIIlIllll.renderAll();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (lIIIlIIlII >= 0) {
                GlStateManager.matrixMode(5890);
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5888);
            }
        }
    }
}
