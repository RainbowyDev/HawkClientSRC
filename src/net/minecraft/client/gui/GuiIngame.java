package net.minecraft.client.gui;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import net.minecraft.scoreboard.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.*;
import net.minecraft.world.border.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.boss.*;
import net.minecraft.item.*;
import java.awt.*;
import hawk.*;
import net.minecraft.inventory.*;
import net.minecraft.util.*;

public class GuiIngame extends Gui
{
    public /* synthetic */ float prevVignetteBrightness;
    private /* synthetic */ int updateCounter;
    private /* synthetic */ ItemStack highlightingItemStack;
    private /* synthetic */ int field_175189_D;
    private /* synthetic */ int remainingHighlightTicks;
    private /* synthetic */ long field_175191_F;
    private static final /* synthetic */ ResourceLocation widgetsTexPath;
    private /* synthetic */ int field_175193_B;
    private final /* synthetic */ GuiSpectator field_175197_u;
    private /* synthetic */ String field_175200_y;
    private /* synthetic */ int field_175194_C;
    private final /* synthetic */ GuiPlayerTabOverlay overlayPlayerList;
    private final /* synthetic */ RenderItem itemRenderer;
    private static final /* synthetic */ ResourceLocation vignetteTexPath;
    private final /* synthetic */ GuiOverlayDebug overlayDebug;
    private static final /* synthetic */ ResourceLocation pumpkinBlurTexPath;
    private final /* synthetic */ GuiStreamIndicator streamIndicator;
    private final /* synthetic */ GuiNewChat persistantChatGUI;
    private /* synthetic */ String field_175201_x;
    private /* synthetic */ String recordPlaying;
    private /* synthetic */ int field_175199_z;
    private /* synthetic */ boolean recordIsPlaying;
    private /* synthetic */ int field_175195_w;
    private final /* synthetic */ Random rand;
    private /* synthetic */ int field_175192_A;
    private /* synthetic */ int recordPlayingUpFor;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ long field_175190_E;
    
    public void updateTick() {
        if (this.recordPlayingUpFor > 0) {
            --this.recordPlayingUpFor;
        }
        if (this.field_175195_w > 0) {
            --this.field_175195_w;
            if (this.field_175195_w <= 0) {
                this.field_175201_x = "";
                this.field_175200_y = "";
            }
        }
        ++this.updateCounter;
        this.streamIndicator.func_152439_a();
        if (this.mc.thePlayer != null) {
            final ItemStack llllllllllllllllIllllllIIIIIllII = this.mc.thePlayer.inventory.getCurrentItem();
            if (llllllllllllllllIllllllIIIIIllII == null) {
                this.remainingHighlightTicks = 0;
            }
            else if (this.highlightingItemStack != null && llllllllllllllllIllllllIIIIIllII.getItem() == this.highlightingItemStack.getItem() && ItemStack.areItemStackTagsEqual(llllllllllllllllIllllllIIIIIllII, this.highlightingItemStack) && (llllllllllllllllIllllllIIIIIllII.isItemStackDamageable() || llllllllllllllllIllllllIIIIIllII.getMetadata() == this.highlightingItemStack.getMetadata())) {
                if (this.remainingHighlightTicks > 0) {
                    --this.remainingHighlightTicks;
                }
            }
            else {
                this.remainingHighlightTicks = 40;
            }
            this.highlightingItemStack = llllllllllllllllIllllllIIIIIllII;
        }
    }
    
    private void func_180477_d(final ScaledResolution llllllllllllllllIllllllIlllIIlII) {
        if (this.mc.func_175606_aa() instanceof EntityPlayer) {
            final EntityPlayer llllllllllllllllIllllllIlllIIIll = (EntityPlayer)this.mc.func_175606_aa();
            final int llllllllllllllllIllllllIlllIIIlI = MathHelper.ceiling_float_int(llllllllllllllllIllllllIlllIIIll.getHealth());
            final boolean llllllllllllllllIllllllIlllIIIIl = this.field_175191_F > this.updateCounter && (this.field_175191_F - this.updateCounter) / 3L % 2L == 1L;
            if (llllllllllllllllIllllllIlllIIIlI < this.field_175194_C && llllllllllllllllIllllllIlllIIIll.hurtResistantTime > 0) {
                this.field_175190_E = Minecraft.getSystemTime();
                this.field_175191_F = this.updateCounter + 20;
            }
            else if (llllllllllllllllIllllllIlllIIIlI > this.field_175194_C && llllllllllllllllIllllllIlllIIIll.hurtResistantTime > 0) {
                this.field_175190_E = Minecraft.getSystemTime();
                this.field_175191_F = this.updateCounter + 10;
            }
            if (Minecraft.getSystemTime() - this.field_175190_E > 1000L) {
                this.field_175194_C = llllllllllllllllIllllllIlllIIIlI;
                this.field_175189_D = llllllllllllllllIllllllIlllIIIlI;
                this.field_175190_E = Minecraft.getSystemTime();
            }
            this.field_175194_C = llllllllllllllllIllllllIlllIIIlI;
            final int llllllllllllllllIllllllIlllIIIII = this.field_175189_D;
            this.rand.setSeed(this.updateCounter * 312871);
            final boolean llllllllllllllllIllllllIllIlllll = false;
            final FoodStats llllllllllllllllIllllllIllIllllI = llllllllllllllllIllllllIlllIIIll.getFoodStats();
            final int llllllllllllllllIllllllIllIlllIl = llllllllllllllllIllllllIllIllllI.getFoodLevel();
            final int llllllllllllllllIllllllIllIlllII = llllllllllllllllIllllllIllIllllI.getPrevFoodLevel();
            final IAttributeInstance llllllllllllllllIllllllIllIllIll = llllllllllllllllIllllllIlllIIIll.getEntityAttribute(SharedMonsterAttributes.maxHealth);
            final int llllllllllllllllIllllllIllIllIlI = llllllllllllllllIllllllIlllIIlII.getScaledWidth() / 2 - 91;
            final int llllllllllllllllIllllllIllIllIIl = llllllllllllllllIllllllIlllIIlII.getScaledWidth() / 2 + 91;
            final int llllllllllllllllIllllllIllIllIII = llllllllllllllllIllllllIlllIIlII.getScaledHeight() - 39;
            final float llllllllllllllllIllllllIllIlIlll = (float)llllllllllllllllIllllllIllIllIll.getAttributeValue();
            final float llllllllllllllllIllllllIllIlIllI = llllllllllllllllIllllllIlllIIIll.getAbsorptionAmount();
            final int llllllllllllllllIllllllIllIlIlIl = MathHelper.ceiling_float_int((llllllllllllllllIllllllIllIlIlll + llllllllllllllllIllllllIllIlIllI) / 2.0f / 10.0f);
            final int llllllllllllllllIllllllIllIlIlII = Math.max(10 - (llllllllllllllllIllllllIllIlIlIl - 2), 3);
            final int llllllllllllllllIllllllIllIlIIll = llllllllllllllllIllllllIllIllIII - (llllllllllllllllIllllllIllIlIlIl - 1) * llllllllllllllllIllllllIllIlIlII - 10;
            float llllllllllllllllIllllllIllIlIIlI = llllllllllllllllIllllllIllIlIllI;
            final int llllllllllllllllIllllllIllIlIIIl = llllllllllllllllIllllllIlllIIIll.getTotalArmorValue();
            int llllllllllllllllIllllllIllIlIIII = -1;
            if (llllllllllllllllIllllllIlllIIIll.isPotionActive(Potion.regeneration)) {
                llllllllllllllllIllllllIllIlIIII = this.updateCounter % MathHelper.ceiling_float_int(llllllllllllllllIllllllIllIlIlll + 5.0f);
            }
            this.mc.mcProfiler.startSection("armor");
            for (int llllllllllllllllIllllllIllIIllll = 0; llllllllllllllllIllllllIllIIllll < 10; ++llllllllllllllllIllllllIllIIllll) {
                if (llllllllllllllllIllllllIllIlIIIl > 0) {
                    final int llllllllllllllllIllllllIllIIlllI = llllllllllllllllIllllllIllIllIlI + llllllllllllllllIllllllIllIIllll * 8;
                    if (llllllllllllllllIllllllIllIIllll * 2 + 1 < llllllllllllllllIllllllIllIlIIIl) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIlllI, llllllllllllllllIllllllIllIlIIll, 34, 9, 9, 9);
                    }
                    if (llllllllllllllllIllllllIllIIllll * 2 + 1 == llllllllllllllllIllllllIllIlIIIl) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIlllI, llllllllllllllllIllllllIllIlIIll, 25, 9, 9, 9);
                    }
                    if (llllllllllllllllIllllllIllIIllll * 2 + 1 > llllllllllllllllIllllllIllIlIIIl) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIlllI, llllllllllllllllIllllllIllIlIIll, 16, 9, 9, 9);
                    }
                }
            }
            this.mc.mcProfiler.endStartSection("health");
            for (int llllllllllllllllIllllllIllIIllll = MathHelper.ceiling_float_int((llllllllllllllllIllllllIllIlIlll + llllllllllllllllIllllllIllIlIllI) / 2.0f) - 1; llllllllllllllllIllllllIllIIllll >= 0; --llllllllllllllllIllllllIllIIllll) {
                int llllllllllllllllIllllllIllIIllIl = 16;
                if (llllllllllllllllIllllllIlllIIIll.isPotionActive(Potion.poison)) {
                    llllllllllllllllIllllllIllIIllIl += 36;
                }
                else if (llllllllllllllllIllllllIlllIIIll.isPotionActive(Potion.wither)) {
                    llllllllllllllllIllllllIllIIllIl += 72;
                }
                byte llllllllllllllllIllllllIllIIIIIl = 0;
                if (llllllllllllllllIllllllIlllIIIIl) {
                    llllllllllllllllIllllllIllIIIIIl = 1;
                }
                final int llllllllllllllllIllllllIllIIlIlI = MathHelper.ceiling_float_int((llllllllllllllllIllllllIllIIllll + 1) / 10.0f) - 1;
                final int llllllllllllllllIllllllIllIIIlll = llllllllllllllllIllllllIllIllIlI + llllllllllllllllIllllllIllIIllll % 10 * 8;
                int llllllllllllllllIllllllIllIIIlII = llllllllllllllllIllllllIllIllIII - llllllllllllllllIllllllIllIIlIlI * llllllllllllllllIllllllIllIlIlII;
                if (llllllllllllllllIllllllIlllIIIlI <= 4) {
                    llllllllllllllllIllllllIllIIIlII += this.rand.nextInt(2);
                }
                if (llllllllllllllllIllllllIllIIllll == llllllllllllllllIllllllIllIlIIII) {
                    llllllllllllllllIllllllIllIIIlII -= 2;
                }
                byte llllllllllllllllIllllllIllIIIIII = 0;
                if (llllllllllllllllIllllllIlllIIIll.worldObj.getWorldInfo().isHardcoreModeEnabled()) {
                    llllllllllllllllIllllllIllIIIIII = 5;
                }
                this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIlll, llllllllllllllllIllllllIllIIIlII, 16 + llllllllllllllllIllllllIllIIIIIl * 9, 9 * llllllllllllllllIllllllIllIIIIII, 9, 9);
                if (llllllllllllllllIllllllIlllIIIIl) {
                    if (llllllllllllllllIllllllIllIIllll * 2 + 1 < llllllllllllllllIllllllIlllIIIII) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIlll, llllllllllllllllIllllllIllIIIlII, llllllllllllllllIllllllIllIIllIl + 54, 9 * llllllllllllllllIllllllIllIIIIII, 9, 9);
                    }
                    if (llllllllllllllllIllllllIllIIllll * 2 + 1 == llllllllllllllllIllllllIlllIIIII) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIlll, llllllllllllllllIllllllIllIIIlII, llllllllllllllllIllllllIllIIllIl + 63, 9 * llllllllllllllllIllllllIllIIIIII, 9, 9);
                    }
                }
                if (llllllllllllllllIllllllIllIlIIlI > 0.0f) {
                    if (llllllllllllllllIllllllIllIlIIlI == llllllllllllllllIllllllIllIlIllI && llllllllllllllllIllllllIllIlIllI % 2.0f == 1.0f) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIlll, llllllllllllllllIllllllIllIIIlII, llllllllllllllllIllllllIllIIllIl + 153, 9 * llllllllllllllllIllllllIllIIIIII, 9, 9);
                    }
                    else {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIlll, llllllllllllllllIllllllIllIIIlII, llllllllllllllllIllllllIllIIllIl + 144, 9 * llllllllllllllllIllllllIllIIIIII, 9, 9);
                    }
                    llllllllllllllllIllllllIllIlIIlI -= 2.0f;
                }
                else {
                    if (llllllllllllllllIllllllIllIIllll * 2 + 1 < llllllllllllllllIllllllIlllIIIlI) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIlll, llllllllllllllllIllllllIllIIIlII, llllllllllllllllIllllllIllIIllIl + 36, 9 * llllllllllllllllIllllllIllIIIIII, 9, 9);
                    }
                    if (llllllllllllllllIllllllIllIIllll * 2 + 1 == llllllllllllllllIllllllIlllIIIlI) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIlll, llllllllllllllllIllllllIllIIIlII, llllllllllllllllIllllllIllIIllIl + 45, 9 * llllllllllllllllIllllllIllIIIIII, 9, 9);
                    }
                }
            }
            final Entity llllllllllllllllIllllllIlIllllll = llllllllllllllllIllllllIlllIIIll.ridingEntity;
            if (llllllllllllllllIllllllIlIllllll == null) {
                this.mc.mcProfiler.endStartSection("food");
                for (int llllllllllllllllIllllllIllIIllII = 0; llllllllllllllllIllllllIllIIllII < 10; ++llllllllllllllllIllllllIllIIllII) {
                    int llllllllllllllllIllllllIlIlllllI = llllllllllllllllIllllllIllIllIII;
                    int llllllllllllllllIllllllIllIIlIIl = 16;
                    byte llllllllllllllllIllllllIlIlllIll = 0;
                    if (llllllllllllllllIllllllIlllIIIll.isPotionActive(Potion.hunger)) {
                        llllllllllllllllIllllllIllIIlIIl += 36;
                        llllllllllllllllIllllllIlIlllIll = 13;
                    }
                    if (llllllllllllllllIllllllIlllIIIll.getFoodStats().getSaturationLevel() <= 0.0f && this.updateCounter % (llllllllllllllllIllllllIllIlllIl * 3 + 1) == 0) {
                        llllllllllllllllIllllllIlIlllllI = llllllllllllllllIllllllIllIllIII + (this.rand.nextInt(3) - 1);
                    }
                    if (llllllllllllllllIllllllIllIlllll) {
                        llllllllllllllllIllllllIlIlllIll = 1;
                    }
                    final int llllllllllllllllIllllllIllIIIIll = llllllllllllllllIllllllIllIllIIl - llllllllllllllllIllllllIllIIllII * 8 - 9;
                    this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIIll, llllllllllllllllIllllllIlIlllllI, 16 + llllllllllllllllIllllllIlIlllIll * 9, 27, 9, 9);
                    if (llllllllllllllllIllllllIllIlllll) {
                        if (llllllllllllllllIllllllIllIIllII * 2 + 1 < llllllllllllllllIllllllIllIlllII) {
                            this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIIll, llllllllllllllllIllllllIlIlllllI, llllllllllllllllIllllllIllIIlIIl + 54, 27, 9, 9);
                        }
                        if (llllllllllllllllIllllllIllIIllII * 2 + 1 == llllllllllllllllIllllllIllIlllII) {
                            this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIIll, llllllllllllllllIllllllIlIlllllI, llllllllllllllllIllllllIllIIlIIl + 63, 27, 9, 9);
                        }
                    }
                    if (llllllllllllllllIllllllIllIIllII * 2 + 1 < llllllllllllllllIllllllIllIlllIl) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIIll, llllllllllllllllIllllllIlIlllllI, llllllllllllllllIllllllIllIIlIIl + 36, 27, 9, 9);
                    }
                    if (llllllllllllllllIllllllIllIIllII * 2 + 1 == llllllllllllllllIllllllIllIlllIl) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIIIIll, llllllllllllllllIllllllIlIlllllI, llllllllllllllllIllllllIllIIlIIl + 45, 27, 9, 9);
                    }
                }
            }
            else if (llllllllllllllllIllllllIlIllllll instanceof EntityLivingBase) {
                this.mc.mcProfiler.endStartSection("mountHealth");
                final EntityLivingBase llllllllllllllllIllllllIlIlllIlI = (EntityLivingBase)llllllllllllllllIllllllIlIllllll;
                final int llllllllllllllllIllllllIlIllllIl = (int)Math.ceil(llllllllllllllllIllllllIlIlllIlI.getHealth());
                final float llllllllllllllllIllllllIlIlllIIl = llllllllllllllllIllllllIlIlllIlI.getMaxHealth();
                int llllllllllllllllIllllllIllIIIllI = (int)(llllllllllllllllIllllllIlIlllIIl + 0.5f) / 2;
                if (llllllllllllllllIllllllIllIIIllI > 30) {
                    llllllllllllllllIllllllIllIIIllI = 30;
                }
                int llllllllllllllllIllllllIllIIIIlI = llllllllllllllllIllllllIllIllIII;
                int llllllllllllllllIllllllIlIlllIII = 0;
                while (llllllllllllllllIllllllIllIIIllI > 0) {
                    final int llllllllllllllllIllllllIlIllIlll = Math.min(llllllllllllllllIllllllIllIIIllI, 10);
                    llllllllllllllllIllllllIllIIIllI -= llllllllllllllllIllllllIlIllIlll;
                    for (int llllllllllllllllIllllllIlIllIllI = 0; llllllllllllllllIllllllIlIllIllI < llllllllllllllllIllllllIlIllIlll; ++llllllllllllllllIllllllIlIllIllI) {
                        final byte llllllllllllllllIllllllIlIllIlIl = 52;
                        byte llllllllllllllllIllllllIlIllIlII = 0;
                        if (llllllllllllllllIllllllIllIlllll) {
                            llllllllllllllllIllllllIlIllIlII = 1;
                        }
                        final int llllllllllllllllIllllllIlIllIIll = llllllllllllllllIllllllIllIllIIl - llllllllllllllllIllllllIlIllIllI * 8 - 9;
                        this.drawTexturedModalRect(llllllllllllllllIllllllIlIllIIll, llllllllllllllllIllllllIllIIIIlI, llllllllllllllllIllllllIlIllIlIl + llllllllllllllllIllllllIlIllIlII * 9, 9, 9, 9);
                        if (llllllllllllllllIllllllIlIllIllI * 2 + 1 + llllllllllllllllIllllllIlIlllIII < llllllllllllllllIllllllIlIllllIl) {
                            this.drawTexturedModalRect(llllllllllllllllIllllllIlIllIIll, llllllllllllllllIllllllIllIIIIlI, llllllllllllllllIllllllIlIllIlIl + 36, 9, 9, 9);
                        }
                        if (llllllllllllllllIllllllIlIllIllI * 2 + 1 + llllllllllllllllIllllllIlIlllIII == llllllllllllllllIllllllIlIllllIl) {
                            this.drawTexturedModalRect(llllllllllllllllIllllllIlIllIIll, llllllllllllllllIllllllIllIIIIlI, llllllllllllllllIllllllIlIllIlIl + 45, 9, 9, 9);
                        }
                    }
                    llllllllllllllllIllllllIllIIIIlI -= 10;
                    llllllllllllllllIllllllIlIlllIII += 20;
                }
            }
            this.mc.mcProfiler.endStartSection("air");
            if (llllllllllllllllIllllllIlllIIIll.isInsideOfMaterial(Material.water)) {
                final int llllllllllllllllIllllllIllIIlIll = this.mc.thePlayer.getAir();
                for (int llllllllllllllllIllllllIlIllllII = MathHelper.ceiling_double_int((llllllllllllllllIllllllIllIIlIll - 2) * 10.0 / 300.0), llllllllllllllllIllllllIllIIlIII = MathHelper.ceiling_double_int(llllllllllllllllIllllllIllIIlIll * 10.0 / 300.0) - llllllllllllllllIllllllIlIllllII, llllllllllllllllIllllllIllIIIlIl = 0; llllllllllllllllIllllllIllIIIlIl < llllllllllllllllIllllllIlIllllII + llllllllllllllllIllllllIllIIlIII; ++llllllllllllllllIllllllIllIIIlIl) {
                    if (llllllllllllllllIllllllIllIIIlIl < llllllllllllllllIllllllIlIllllII) {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIllIIl - llllllllllllllllIllllllIllIIIlIl * 8 - 9, llllllllllllllllIllllllIllIlIIll, 16, 18, 9, 9);
                    }
                    else {
                        this.drawTexturedModalRect(llllllllllllllllIllllllIllIllIIl - llllllllllllllllIllllllIllIIIlIl * 8 - 9, llllllllllllllllIllllllIllIlIIll, 25, 18, 9, 9);
                    }
                }
            }
            this.mc.mcProfiler.endSection();
        }
    }
    
    public void setRecordPlaying(final String llllllllllllllllIlllllIlllllllll, final boolean llllllllllllllllIlllllIllllllllI) {
        this.recordPlaying = llllllllllllllllIlllllIlllllllll;
        this.recordPlayingUpFor = 60;
        this.recordIsPlaying = llllllllllllllllIlllllIllllllllI;
    }
    
    private void func_180475_a(final ScoreObjective llllllllllllllllIlllllllIIlllIIl, final ScaledResolution llllllllllllllllIlllllllIIIllllI) {
        final Scoreboard llllllllllllllllIlllllllIIllIlll = llllllllllllllllIlllllllIIlllIIl.getScoreboard();
        final Collection llllllllllllllllIlllllllIIllIllI = llllllllllllllllIlllllllIIllIlll.getSortedScores(llllllllllllllllIlllllllIIlllIIl);
        final ArrayList llllllllllllllllIlllllllIIllIlIl = Lists.newArrayList(Iterables.filter((Iterable)llllllllllllllllIlllllllIIllIllI, (Predicate)new Predicate() {
            static {
                __OBFID = "CL_00001958";
            }
            
            public boolean func_178903_a(final Score llllllllllllllIIIIlIllIlIlllIlll) {
                return llllllllllllllIIIIlIllIlIlllIlll.getPlayerName() != null && !llllllllllllllIIIIlIllIlIlllIlll.getPlayerName().startsWith("#");
            }
            
            public boolean apply(final Object llllllllllllllIIIIlIllIlIlllIIIl) {
                return this.func_178903_a((Score)llllllllllllllIIIIlIllIlIlllIIIl);
            }
        }));
        ArrayList llllllllllllllllIlllllllIIllIIll = null;
        if (llllllllllllllllIlllllllIIllIlIl.size() > 15) {
            final ArrayList llllllllllllllllIlllllllIIllIlII = Lists.newArrayList(Iterables.skip((Iterable)llllllllllllllllIlllllllIIllIlIl, llllllllllllllllIlllllllIIllIllI.size() - 15));
        }
        else {
            llllllllllllllllIlllllllIIllIIll = llllllllllllllllIlllllllIIllIlIl;
        }
        int llllllllllllllllIlllllllIIllIIlI = this.func_175179_f().getStringWidth(llllllllllllllllIlllllllIIlllIIl.getDisplayName());
        for (final Score llllllllllllllllIlllllllIIlIllll : llllllllllllllllIlllllllIIllIIll) {
            final ScorePlayerTeam llllllllllllllllIlllllllIIlIlllI = llllllllllllllllIlllllllIIllIlll.getPlayersTeam(llllllllllllllllIlllllllIIlIllll.getPlayerName());
            final String llllllllllllllllIlllllllIIllIIIl = String.valueOf(new StringBuilder(String.valueOf(ScorePlayerTeam.formatPlayerName(llllllllllllllllIlllllllIIlIlllI, llllllllllllllllIlllllllIIlIllll.getPlayerName()))).append(": ").append(EnumChatFormatting.RED).append(llllllllllllllllIlllllllIIlIllll.getScorePoints()));
            llllllllllllllllIlllllllIIllIIlI = Math.max(llllllllllllllllIlllllllIIllIIlI, this.func_175179_f().getStringWidth(llllllllllllllllIlllllllIIllIIIl));
        }
        final int llllllllllllllllIlllllllIIlIllIl = llllllllllllllllIlllllllIIllIIll.size() * this.func_175179_f().FONT_HEIGHT;
        final int llllllllllllllllIlllllllIIlIllII = llllllllllllllllIlllllllIIIllllI.getScaledHeight() / 2 + llllllllllllllllIlllllllIIlIllIl / 3;
        final byte llllllllllllllllIlllllllIIlIlIll = 3;
        final int llllllllllllllllIlllllllIIlIlIlI = llllllllllllllllIlllllllIIIllllI.getScaledWidth() - llllllllllllllllIlllllllIIllIIlI - llllllllllllllllIlllllllIIlIlIll;
        int llllllllllllllllIlllllllIIlIlIIl = 0;
        for (final Score llllllllllllllllIlllllllIIlIIlll : llllllllllllllllIlllllllIIllIIll) {
            ++llllllllllllllllIlllllllIIlIlIIl;
            final ScorePlayerTeam llllllllllllllllIlllllllIIlIIllI = llllllllllllllllIlllllllIIllIlll.getPlayersTeam(llllllllllllllllIlllllllIIlIIlll.getPlayerName());
            final String llllllllllllllllIlllllllIIlIIlIl = ScorePlayerTeam.formatPlayerName(llllllllllllllllIlllllllIIlIIllI, llllllllllllllllIlllllllIIlIIlll.getPlayerName());
            final String llllllllllllllllIlllllllIIlIIlII = String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append(llllllllllllllllIlllllllIIlIIlll.getScorePoints()));
            final int llllllllllllllllIlllllllIIlIIIll = llllllllllllllllIlllllllIIlIllII - llllllllllllllllIlllllllIIlIlIIl * this.func_175179_f().FONT_HEIGHT;
            final int llllllllllllllllIlllllllIIlIIIlI = llllllllllllllllIlllllllIIIllllI.getScaledWidth() - llllllllllllllllIlllllllIIlIlIll + 2;
            Gui.drawRect(llllllllllllllllIlllllllIIlIlIlI - 2, llllllllllllllllIlllllllIIlIIIll, llllllllllllllllIlllllllIIlIIIlI, llllllllllllllllIlllllllIIlIIIll + this.func_175179_f().FONT_HEIGHT, 1342177280);
            this.func_175179_f().drawString(llllllllllllllllIlllllllIIlIIlIl, llllllllllllllllIlllllllIIlIlIlI, llllllllllllllllIlllllllIIlIIIll, 553648127);
            this.func_175179_f().drawString(llllllllllllllllIlllllllIIlIIlII, llllllllllllllllIlllllllIIlIIIlI - this.func_175179_f().getStringWidth(llllllllllllllllIlllllllIIlIIlII), llllllllllllllllIlllllllIIlIIIll, 553648127);
            if (llllllllllllllllIlllllllIIlIlIIl == llllllllllllllllIlllllllIIllIIll.size()) {
                final String llllllllllllllllIlllllllIIlIIIIl = llllllllllllllllIlllllllIIlllIIl.getDisplayName();
                Gui.drawRect(llllllllllllllllIlllllllIIlIlIlI - 2, llllllllllllllllIlllllllIIlIIIll - this.func_175179_f().FONT_HEIGHT - 1, llllllllllllllllIlllllllIIlIIIlI, llllllllllllllllIlllllllIIlIIIll - 1, 1610612736);
                Gui.drawRect(llllllllllllllllIlllllllIIlIlIlI - 2, llllllllllllllllIlllllllIIlIIIll - 1, llllllllllllllllIlllllllIIlIIIlI, llllllllllllllllIlllllllIIlIIIll, 1342177280);
                this.func_175179_f().drawString(llllllllllllllllIlllllllIIlIIIIl, llllllllllllllllIlllllllIIlIlIlI + llllllllllllllllIlllllllIIllIIlI / 2 - this.func_175179_f().getStringWidth(llllllllllllllllIlllllllIIlIIIIl) / 2, llllllllllllllllIlllllllIIlIIIll - this.func_175179_f().FONT_HEIGHT, 553648127);
            }
        }
    }
    
    private void func_180476_e(final ScaledResolution llllllllllllllllIllllllIIllIIllI) {
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableAlpha();
        this.mc.getTextureManager().bindTexture(GuiIngame.pumpkinBlurTexPath);
        final Tessellator llllllllllllllllIllllllIIllIlIIl = Tessellator.getInstance();
        final WorldRenderer llllllllllllllllIllllllIIllIlIII = llllllllllllllllIllllllIIllIlIIl.getWorldRenderer();
        llllllllllllllllIllllllIIllIlIII.startDrawingQuads();
        llllllllllllllllIllllllIIllIlIII.addVertexWithUV(0.0, llllllllllllllllIllllllIIllIIllI.getScaledHeight(), -90.0, 0.0, 1.0);
        llllllllllllllllIllllllIIllIlIII.addVertexWithUV(llllllllllllllllIllllllIIllIIllI.getScaledWidth(), llllllllllllllllIllllllIIllIIllI.getScaledHeight(), -90.0, 1.0, 1.0);
        llllllllllllllllIllllllIIllIlIII.addVertexWithUV(llllllllllllllllIllllllIIllIIllI.getScaledWidth(), 0.0, -90.0, 1.0, 0.0);
        llllllllllllllllIllllllIIllIlIII.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
        llllllllllllllllIllllllIIllIlIIl.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    private void func_180474_b(float llllllllllllllllIllllllIIIllIIll, final ScaledResolution llllllllllllllllIllllllIIIllIIlI) {
        if (llllllllllllllllIllllllIIIllIIll < 1.0f) {
            llllllllllllllllIllllllIIIllIIll *= llllllllllllllllIllllllIIIllIIll;
            llllllllllllllllIllllllIIIllIIll *= llllllllllllllllIllllllIIIllIIll;
            llllllllllllllllIllllllIIIllIIll = llllllllllllllllIllllllIIIllIIll * 0.8f + 0.2f;
        }
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(1.0f, 1.0f, 1.0f, (float)llllllllllllllllIllllllIIIllIIll);
        this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        final TextureAtlasSprite llllllllllllllllIllllllIIIlllIll = this.mc.getBlockRendererDispatcher().func_175023_a().func_178122_a(Blocks.portal.getDefaultState());
        final float llllllllllllllllIllllllIIIlllIlI = llllllllllllllllIllllllIIIlllIll.getMinU();
        final float llllllllllllllllIllllllIIIlllIIl = llllllllllllllllIllllllIIIlllIll.getMinV();
        final float llllllllllllllllIllllllIIIlllIII = llllllllllllllllIllllllIIIlllIll.getMaxU();
        final float llllllllllllllllIllllllIIIllIlll = llllllllllllllllIllllllIIIlllIll.getMaxV();
        final Tessellator llllllllllllllllIllllllIIIllIllI = Tessellator.getInstance();
        final WorldRenderer llllllllllllllllIllllllIIIllIlIl = llllllllllllllllIllllllIIIllIllI.getWorldRenderer();
        llllllllllllllllIllllllIIIllIlIl.startDrawingQuads();
        llllllllllllllllIllllllIIIllIlIl.addVertexWithUV(0.0, llllllllllllllllIllllllIIIllIIlI.getScaledHeight(), -90.0, llllllllllllllllIllllllIIIlllIlI, llllllllllllllllIllllllIIIllIlll);
        llllllllllllllllIllllllIIIllIlIl.addVertexWithUV(llllllllllllllllIllllllIIIllIIlI.getScaledWidth(), llllllllllllllllIllllllIIIllIIlI.getScaledHeight(), -90.0, llllllllllllllllIllllllIIIlllIII, llllllllllllllllIllllllIIIllIlll);
        llllllllllllllllIllllllIIIllIlIl.addVertexWithUV(llllllllllllllllIllllllIIIllIIlI.getScaledWidth(), 0.0, -90.0, llllllllllllllllIllllllIIIlllIII, llllllllllllllllIllllllIIIlllIIl);
        llllllllllllllllIllllllIIIllIlIl.addVertexWithUV(0.0, 0.0, -90.0, llllllllllllllllIllllllIIIlllIlI, llllllllllllllllIllllllIIIlllIIl);
        llllllllllllllllIllllllIIIllIllI.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public GuiPlayerTabOverlay getTabList() {
        return this.overlayPlayerList;
    }
    
    private void func_175184_a(final int llllllllllllllllIllllllIIIlIIIII, final int llllllllllllllllIllllllIIIIlllll, final int llllllllllllllllIllllllIIIIlIlIl, final float llllllllllllllllIllllllIIIIlllIl, final EntityPlayer llllllllllllllllIllllllIIIIlllII) {
        final ItemStack llllllllllllllllIllllllIIIIllIll = llllllllllllllllIllllllIIIIlllII.inventory.mainInventory[llllllllllllllllIllllllIIIlIIIII];
        if (llllllllllllllllIllllllIIIIllIll != null) {
            final float llllllllllllllllIllllllIIIIllIlI = llllllllllllllllIllllllIIIIllIll.animationsToGo - llllllllllllllllIllllllIIIIlllIl;
            if (llllllllllllllllIllllllIIIIllIlI > 0.0f) {
                GlStateManager.pushMatrix();
                final float llllllllllllllllIllllllIIIIllIIl = 1.0f + llllllllllllllllIllllllIIIIllIlI / 5.0f;
                GlStateManager.translate((float)(llllllllllllllllIllllllIIIIlllll + 8), (float)(llllllllllllllllIllllllIIIIlIlIl + 12), 0.0f);
                GlStateManager.scale(1.0f / llllllllllllllllIllllllIIIIllIIl, (llllllllllllllllIllllllIIIIllIIl + 1.0f) / 2.0f, 1.0f);
                GlStateManager.translate((float)(-(llllllllllllllllIllllllIIIIlllll + 8)), (float)(-(llllllllllllllllIllllllIIIIlIlIl + 12)), 0.0f);
            }
            this.itemRenderer.func_180450_b(llllllllllllllllIllllllIIIIllIll, llllllllllllllllIllllllIIIIlllll, llllllllllllllllIllllllIIIIlIlIl);
            if (llllllllllllllllIllllllIIIIllIlI > 0.0f) {
                GlStateManager.popMatrix();
            }
            this.itemRenderer.func_175030_a(this.mc.fontRendererObj, llllllllllllllllIllllllIIIIllIll, llllllllllllllllIllllllIIIIlllll, llllllllllllllllIllllllIIIIlIlIl);
        }
    }
    
    public void func_175185_b(final ScaledResolution llllllllllllllllIllllllllIIlIlll) {
        this.mc.mcProfiler.startSection("demo");
        String llllllllllllllllIllllllllIIlIllI = "";
        if (this.mc.theWorld.getTotalWorldTime() >= 120500L) {
            llllllllllllllllIllllllllIIlIllI = I18n.format("demo.demoExpired", new Object[0]);
        }
        else {
            llllllllllllllllIllllllllIIlIllI = I18n.format("demo.remainingTime", StringUtils.ticksToElapsedTime((int)(120500L - this.mc.theWorld.getTotalWorldTime())));
        }
        final int llllllllllllllllIllllllllIIlIlIl = this.func_175179_f().getStringWidth(llllllllllllllllIllllllllIIlIllI);
        this.func_175179_f().drawStringWithShadow(llllllllllllllllIllllllllIIlIllI, (float)(llllllllllllllllIllllllllIIlIlll.getScaledWidth() - llllllllllllllllIllllllllIIlIlIl - 10), 5.0, 16777215);
        this.mc.mcProfiler.endSection();
    }
    
    public FontRenderer func_175179_f() {
        return this.mc.fontRendererObj;
    }
    
    private void func_180480_a(float llllllllllllllllIllllllIIlIlIIII, final ScaledResolution llllllllllllllllIllllllIIlIIllll) {
        if (Config.isVignetteEnabled()) {
            llllllllllllllllIllllllIIlIlIIII = (char)(1.0f - llllllllllllllllIllllllIIlIlIIII);
            llllllllllllllllIllllllIIlIlIIII = (char)MathHelper.clamp_float(llllllllllllllllIllllllIIlIlIIII, 0.0f, 1.0f);
            final WorldBorder llllllllllllllllIllllllIIlIlIlll = this.mc.theWorld.getWorldBorder();
            float llllllllllllllllIllllllIIlIlIllI = (float)llllllllllllllllIllllllIIlIlIlll.getClosestDistance(this.mc.thePlayer);
            final double llllllllllllllllIllllllIIlIlIlIl = Math.min(llllllllllllllllIllllllIIlIlIlll.func_177749_o() * llllllllllllllllIllllllIIlIlIlll.getWarningTime() * 1000.0, Math.abs(llllllllllllllllIllllllIIlIlIlll.getTargetSize() - llllllllllllllllIllllllIIlIlIlll.getDiameter()));
            final double llllllllllllllllIllllllIIlIlIlII = Math.max(llllllllllllllllIllllllIIlIlIlll.getWarningDistance(), llllllllllllllllIllllllIIlIlIlIl);
            if (llllllllllllllllIllllllIIlIlIllI < llllllllllllllllIllllllIIlIlIlII) {
                llllllllllllllllIllllllIIlIlIllI = 1.0f - (float)(llllllllllllllllIllllllIIlIlIllI / llllllllllllllllIllllllIIlIlIlII);
            }
            else {
                llllllllllllllllIllllllIIlIlIllI = 0.0f;
            }
            this.prevVignetteBrightness += (float)((llllllllllllllllIllllllIIlIlIIII - this.prevVignetteBrightness) * 0.01);
            GlStateManager.disableDepth();
            GlStateManager.depthMask(false);
            GlStateManager.tryBlendFuncSeparate(0, 769, 1, 0);
            if (llllllllllllllllIllllllIIlIlIllI > 0.0f) {
                GlStateManager.color(0.0f, llllllllllllllllIllllllIIlIlIllI, llllllllllllllllIllllllIIlIlIllI, 1.0f);
            }
            else {
                GlStateManager.color(this.prevVignetteBrightness, this.prevVignetteBrightness, this.prevVignetteBrightness, 1.0f);
            }
            this.mc.getTextureManager().bindTexture(GuiIngame.vignetteTexPath);
            final Tessellator llllllllllllllllIllllllIIlIlIIll = Tessellator.getInstance();
            final WorldRenderer llllllllllllllllIllllllIIlIlIIlI = llllllllllllllllIllllllIIlIlIIll.getWorldRenderer();
            llllllllllllllllIllllllIIlIlIIlI.startDrawingQuads();
            llllllllllllllllIllllllIIlIlIIlI.addVertexWithUV(0.0, llllllllllllllllIllllllIIlIIllll.getScaledHeight(), -90.0, 0.0, 1.0);
            llllllllllllllllIllllllIIlIlIIlI.addVertexWithUV(llllllllllllllllIllllllIIlIIllll.getScaledWidth(), llllllllllllllllIllllllIIlIIllll.getScaledHeight(), -90.0, 1.0, 1.0);
            llllllllllllllllIllllllIIlIlIIlI.addVertexWithUV(llllllllllllllllIllllllIIlIIllll.getScaledWidth(), 0.0, -90.0, 1.0, 0.0);
            llllllllllllllllIllllllIIlIlIIlI.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
            llllllllllllllllIllllllIIlIlIIll.draw();
            GlStateManager.depthMask(true);
            GlStateManager.enableDepth();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        }
    }
    
    public void func_175176_b(final ScaledResolution llllllllllllllllIlllllllllIlIlll, final int llllllllllllllllIllllllllllIIIlI) {
        this.mc.mcProfiler.startSection("expBar");
        this.mc.getTextureManager().bindTexture(Gui.icons);
        final int llllllllllllllllIllllllllllIIIIl = this.mc.thePlayer.xpBarCap();
        if (llllllllllllllllIllllllllllIIIIl > 0) {
            final short llllllllllllllllIlllllllllIllllI = 182;
            final int llllllllllllllllIlllllllllIlllIl = (int)(this.mc.thePlayer.experience * (llllllllllllllllIlllllllllIllllI + 1));
            final int llllllllllllllllIllllllllllIIIII = llllllllllllllllIlllllllllIlIlll.getScaledHeight() - 32 + 3;
            this.drawTexturedModalRect(llllllllllllllllIllllllllllIIIlI, llllllllllllllllIllllllllllIIIII, 0, 64, llllllllllllllllIlllllllllIllllI, 5);
            if (llllllllllllllllIlllllllllIlllIl > 0) {
                this.drawTexturedModalRect(llllllllllllllllIllllllllllIIIlI, llllllllllllllllIllllllllllIIIII, 0, 69, llllllllllllllllIlllllllllIlllIl, 5);
            }
        }
        this.mc.mcProfiler.endSection();
        if (this.mc.thePlayer.experienceLevel > 0) {
            this.mc.mcProfiler.startSection("expLevel");
            int llllllllllllllllIlllllllllIlllII = 8453920;
            if (Config.isCustomColors()) {
                llllllllllllllllIlllllllllIlllII = CustomColors.getExpBarTextColor(llllllllllllllllIlllllllllIlllII);
            }
            final String llllllllllllllllIlllllllllIllIll = String.valueOf(new StringBuilder().append(this.mc.thePlayer.experienceLevel));
            final int llllllllllllllllIlllllllllIlllll = (llllllllllllllllIlllllllllIlIlll.getScaledWidth() - this.func_175179_f().getStringWidth(llllllllllllllllIlllllllllIllIll)) / 2;
            final int llllllllllllllllIlllllllllIllIlI = llllllllllllllllIlllllllllIlIlll.getScaledHeight() - 31 - 4;
            final boolean llllllllllllllllIlllllllllIllIIl = false;
            this.func_175179_f().drawString(llllllllllllllllIlllllllllIllIll, llllllllllllllllIlllllllllIlllll + 1, llllllllllllllllIlllllllllIllIlI, 0);
            this.func_175179_f().drawString(llllllllllllllllIlllllllllIllIll, llllllllllllllllIlllllllllIlllll - 1, llllllllllllllllIlllllllllIllIlI, 0);
            this.func_175179_f().drawString(llllllllllllllllIlllllllllIllIll, llllllllllllllllIlllllllllIlllll, llllllllllllllllIlllllllllIllIlI + 1, 0);
            this.func_175179_f().drawString(llllllllllllllllIlllllllllIllIll, llllllllllllllllIlllllllllIlllll, llllllllllllllllIlllllllllIllIlI - 1, 0);
            this.func_175179_f().drawString(llllllllllllllllIlllllllllIllIll, llllllllllllllllIlllllllllIlllll, llllllllllllllllIlllllllllIllIlI, llllllllllllllllIlllllllllIlllII);
            this.mc.mcProfiler.endSection();
        }
    }
    
    public GuiNewChat getChatGUI() {
        return this.persistantChatGUI;
    }
    
    public void func_175182_a(final ScaledResolution llllllllllllllllIllllllllIlIIlll) {
        this.mc.mcProfiler.startSection("toolHighlight");
        if (this.remainingHighlightTicks > 0 && this.highlightingItemStack != null) {
            String llllllllllllllllIllllllllIlIllII = this.highlightingItemStack.getDisplayName();
            if (this.highlightingItemStack.hasDisplayName()) {
                llllllllllllllllIllllllllIlIllII = String.valueOf(new StringBuilder().append(EnumChatFormatting.ITALIC).append(llllllllllllllllIllllllllIlIllII));
            }
            final int llllllllllllllllIllllllllIlIlIll = (llllllllllllllllIllllllllIlIIlll.getScaledWidth() - this.func_175179_f().getStringWidth(llllllllllllllllIllllllllIlIllII)) / 2;
            int llllllllllllllllIllllllllIlIlIlI = llllllllllllllllIllllllllIlIIlll.getScaledHeight() - 59;
            if (!this.mc.playerController.shouldDrawHUD()) {
                llllllllllllllllIllllllllIlIlIlI += 14;
            }
            int llllllllllllllllIllllllllIlIlIIl = (int)(this.remainingHighlightTicks * 256.0f / 10.0f);
            if (llllllllllllllllIllllllllIlIlIIl > 255) {
                llllllllllllllllIllllllllIlIlIIl = 255;
            }
            if (llllllllllllllllIllllllllIlIlIIl > 0) {
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                this.func_175179_f().drawStringWithShadow(llllllllllllllllIllllllllIlIllII, (float)llllllllllllllllIllllllllIlIlIll, (float)llllllllllllllllIllllllllIlIlIlI, 16777215 + (llllllllllllllllIllllllllIlIlIIl << 24));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
        }
        this.mc.mcProfiler.endSection();
    }
    
    public void func_180478_c(final ScaledResolution llllllllllllllllIlllllllIlllIIIl) {
        this.streamIndicator.render(llllllllllllllllIlllllllIlllIIIl.getScaledWidth() - 10, 10);
    }
    
    public GuiIngame(final Minecraft lllllllllllllllllIIIIIIIIlIlIllI) {
        this.rand = new Random();
        this.recordPlaying = "";
        this.prevVignetteBrightness = 1.0f;
        this.field_175201_x = "";
        this.field_175200_y = "";
        this.field_175194_C = 0;
        this.field_175189_D = 0;
        this.field_175190_E = 0L;
        this.field_175191_F = 0L;
        this.mc = lllllllllllllllllIIIIIIIIlIlIllI;
        this.itemRenderer = lllllllllllllllllIIIIIIIIlIlIllI.getRenderItem();
        this.overlayDebug = new GuiOverlayDebug(lllllllllllllllllIIIIIIIIlIlIllI);
        this.field_175197_u = new GuiSpectator(lllllllllllllllllIIIIIIIIlIlIllI);
        this.persistantChatGUI = new GuiNewChat(lllllllllllllllllIIIIIIIIlIlIllI);
        this.streamIndicator = new GuiStreamIndicator(lllllllllllllllllIIIIIIIIlIlIllI);
        this.overlayPlayerList = new GuiPlayerTabOverlay(lllllllllllllllllIIIIIIIIlIlIllI, this);
        this.func_175177_a();
    }
    
    public GuiSpectator func_175187_g() {
        return this.field_175197_u;
    }
    
    public void setRecordPlayingMessage(final String llllllllllllllllIllllllIIIIIIlII) {
        this.setRecordPlaying(I18n.format("record.nowPlaying", llllllllllllllllIllllllIIIIIIlII), true);
    }
    
    protected void func_180479_a(final ScaledResolution lllllllllllllllllIIIIIIIIIIlIIll, final float lllllllllllllllllIIIIIIIIIIIlIIl) {
        if (this.mc.func_175606_aa() instanceof EntityPlayer) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(GuiIngame.widgetsTexPath);
            final EntityPlayer lllllllllllllllllIIIIIIIIIIlIIIl = (EntityPlayer)this.mc.func_175606_aa();
            final int lllllllllllllllllIIIIIIIIIIlIIII = lllllllllllllllllIIIIIIIIIIlIIll.getScaledWidth() / 2;
            final float lllllllllllllllllIIIIIIIIIIIllll = this.zLevel;
            this.zLevel = -90.0f;
            this.drawTexturedModalRect(lllllllllllllllllIIIIIIIIIIlIIII - 91, lllllllllllllllllIIIIIIIIIIlIIll.getScaledHeight() - 22, 0, 0, 182, 22);
            this.drawTexturedModalRect(lllllllllllllllllIIIIIIIIIIlIIII - 91 - 1 + lllllllllllllllllIIIIIIIIIIlIIIl.inventory.currentItem * 20, lllllllllllllllllIIIIIIIIIIlIIll.getScaledHeight() - 22 - 1, 0, 22, 24, 22);
            this.zLevel = lllllllllllllllllIIIIIIIIIIIllll;
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            RenderHelper.enableGUIStandardItemLighting();
            for (int lllllllllllllllllIIIIIIIIIIIlllI = 0; lllllllllllllllllIIIIIIIIIIIlllI < 9; ++lllllllllllllllllIIIIIIIIIIIlllI) {
                final int lllllllllllllllllIIIIIIIIIIIllIl = lllllllllllllllllIIIIIIIIIIlIIll.getScaledWidth() / 2 - 90 + lllllllllllllllllIIIIIIIIIIIlllI * 20 + 2;
                final int lllllllllllllllllIIIIIIIIIIIllII = lllllllllllllllllIIIIIIIIIIlIIll.getScaledHeight() - 16 - 3;
                this.func_175184_a(lllllllllllllllllIIIIIIIIIIIlllI, lllllllllllllllllIIIIIIIIIIIllIl, lllllllllllllllllIIIIIIIIIIIllII, lllllllllllllllllIIIIIIIIIIIlIIl, lllllllllllllllllIIIIIIIIIIlIIIl);
            }
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
    }
    
    private void renderBossHealth() {
        if (BossStatus.bossName != null && BossStatus.statusBarTime > 0) {
            --BossStatus.statusBarTime;
            final FontRenderer llllllllllllllllIllllllIlIIIIIlI = this.mc.fontRendererObj;
            final ScaledResolution llllllllllllllllIllllllIlIIIIIIl = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            final int llllllllllllllllIllllllIlIIIIIII = llllllllllllllllIllllllIlIIIIIIl.getScaledWidth();
            final short llllllllllllllllIllllllIIlllllll = 182;
            final int llllllllllllllllIllllllIIllllllI = llllllllllllllllIllllllIlIIIIIII / 2 - llllllllllllllllIllllllIIlllllll / 2;
            final int llllllllllllllllIllllllIIlllllIl = (int)(BossStatus.healthScale * (llllllllllllllllIllllllIIlllllll + 1));
            final byte llllllllllllllllIllllllIIlllllII = 12;
            this.drawTexturedModalRect(llllllllllllllllIllllllIIllllllI, llllllllllllllllIllllllIIlllllII, 0, 74, llllllllllllllllIllllllIIlllllll, 5);
            this.drawTexturedModalRect(llllllllllllllllIllllllIIllllllI, llllllllllllllllIllllllIIlllllII, 0, 74, llllllllllllllllIllllllIIlllllll, 5);
            if (llllllllllllllllIllllllIIlllllIl > 0) {
                this.drawTexturedModalRect(llllllllllllllllIllllllIIllllllI, llllllllllllllllIllllllIIlllllII, 0, 79, llllllllllllllllIllllllIIlllllIl, 5);
            }
            final String llllllllllllllllIllllllIIllllIll = BossStatus.bossName;
            int llllllllllllllllIllllllIIllllIlI = 16777215;
            if (Config.isCustomColors()) {
                llllllllllllllllIllllllIIllllIlI = CustomColors.getBossTextColor(llllllllllllllllIllllllIIllllIlI);
            }
            this.func_175179_f().drawStringWithShadow(llllllllllllllllIllllllIIllllIll, (float)(llllllllllllllllIllllllIlIIIIIII / 2 - this.func_175179_f().getStringWidth(llllllllllllllllIllllllIIllllIll) / 2), (float)(llllllllllllllllIllllllIIlllllII - 10), llllllllllllllllIllllllIIllllIlI);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(GuiIngame.icons);
        }
    }
    
    public void func_175178_a(final String llllllllllllllllIlllllIllllIllIl, final String llllllllllllllllIlllllIlllllIIlI, final int llllllllllllllllIlllllIlllllIIIl, final int llllllllllllllllIlllllIllllIlIlI, final int llllllllllllllllIlllllIllllIllll) {
        if (llllllllllllllllIlllllIllllIllIl == null && llllllllllllllllIlllllIlllllIIlI == null && llllllllllllllllIlllllIlllllIIIl < 0 && llllllllllllllllIlllllIllllIlIlI < 0 && llllllllllllllllIlllllIllllIllll < 0) {
            this.field_175201_x = "";
            this.field_175200_y = "";
            this.field_175195_w = 0;
        }
        else if (llllllllllllllllIlllllIllllIllIl != null) {
            this.field_175201_x = llllllllllllllllIlllllIllllIllIl;
            this.field_175195_w = this.field_175199_z + this.field_175192_A + this.field_175193_B;
        }
        else if (llllllllllllllllIlllllIlllllIIlI != null) {
            this.field_175200_y = llllllllllllllllIlllllIlllllIIlI;
        }
        else {
            if (llllllllllllllllIlllllIlllllIIIl >= 0) {
                this.field_175199_z = llllllllllllllllIlllllIlllllIIIl;
            }
            if (llllllllllllllllIlllllIllllIlIlI >= 0) {
                this.field_175192_A = llllllllllllllllIlllllIllllIlIlI;
            }
            if (llllllllllllllllIlllllIllllIllll >= 0) {
                this.field_175193_B = llllllllllllllllIlllllIllllIllll;
            }
            if (this.field_175195_w > 0) {
                this.field_175195_w = this.field_175199_z + this.field_175192_A + this.field_175193_B;
            }
        }
    }
    
    public void func_175177_a() {
        this.field_175199_z = 10;
        this.field_175192_A = 70;
        this.field_175193_B = 20;
    }
    
    public void func_175188_a(final IChatComponent llllllllllllllllIlllllIllllIIIIl, final boolean llllllllllllllllIlllllIllllIIIll) {
        this.setRecordPlaying(llllllllllllllllIlllllIllllIIIIl.getUnformattedText(), llllllllllllllllIlllllIllllIIIll);
    }
    
    public int getUpdateCounter() {
        return this.updateCounter;
    }
    
    public void func_175186_a(final ScaledResolution llllllllllllllllIlllllllllllIIll, final int llllllllllllllllIllllllllllllIIl) {
        this.mc.mcProfiler.startSection("jumpBar");
        this.mc.getTextureManager().bindTexture(Gui.icons);
        final float llllllllllllllllIllllllllllllIII = this.mc.thePlayer.getHorseJumpPower();
        final short llllllllllllllllIlllllllllllIlll = 182;
        final int llllllllllllllllIlllllllllllIllI = (int)(llllllllllllllllIllllllllllllIII * (llllllllllllllllIlllllllllllIlll + 1));
        final int llllllllllllllllIlllllllllllIlIl = llllllllllllllllIlllllllllllIIll.getScaledHeight() - 32 + 3;
        this.drawTexturedModalRect(llllllllllllllllIllllllllllllIIl, llllllllllllllllIlllllllllllIlIl, 0, 84, llllllllllllllllIlllllllllllIlll, 5);
        if (llllllllllllllllIlllllllllllIllI > 0) {
            this.drawTexturedModalRect(llllllllllllllllIllllllllllllIIl, llllllllllllllllIlllllllllllIlIl, 0, 89, llllllllllllllllIlllllllllllIllI, 5);
        }
        this.mc.mcProfiler.endSection();
    }
    
    public void func_175180_a(final float lllllllllllllllllIIIIIIIIIlIlIlI) {
        final ScaledResolution lllllllllllllllllIIIIIIIIlIIIIII = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int lllllllllllllllllIIIIIIIIIllllll = lllllllllllllllllIIIIIIIIlIIIIII.getScaledWidth();
        final int lllllllllllllllllIIIIIIIIIlllllI = lllllllllllllllllIIIIIIIIlIIIIII.getScaledHeight();
        this.mc.entityRenderer.setupOverlayRendering();
        GlStateManager.enableBlend();
        if (Config.isVignetteEnabled()) {
            this.func_180480_a(this.mc.thePlayer.getBrightness(lllllllllllllllllIIIIIIIIIlIlIlI), lllllllllllllllllIIIIIIIIlIIIIII);
        }
        else {
            GlStateManager.enableDepth();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        }
        final ItemStack lllllllllllllllllIIIIIIIIIllllIl = this.mc.thePlayer.inventory.armorItemInSlot(3);
        if (this.mc.gameSettings.thirdPersonView == 0 && lllllllllllllllllIIIIIIIIIllllIl != null && lllllllllllllllllIIIIIIIIIllllIl.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
            this.func_180476_e(lllllllllllllllllIIIIIIIIlIIIIII);
        }
        if (!this.mc.thePlayer.isPotionActive(Potion.confusion)) {
            final float lllllllllllllllllIIIIIIIIIllllII = this.mc.thePlayer.prevTimeInPortal + (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * lllllllllllllllllIIIIIIIIIlIlIlI;
            if (lllllllllllllllllIIIIIIIIIllllII > 0.0f) {
                this.func_180474_b(lllllllllllllllllIIIIIIIIIllllII, lllllllllllllllllIIIIIIIIlIIIIII);
            }
        }
        if (this.mc.playerController.enableEverythingIsScrewedUpMode()) {
            this.field_175197_u.func_175264_a(lllllllllllllllllIIIIIIIIlIIIIII, lllllllllllllllllIIIIIIIIIlIlIlI);
        }
        else {
            this.func_180479_a(lllllllllllllllllIIIIIIIIlIIIIII, lllllllllllllllllIIIIIIIIIlIlIlI);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiIngame.icons);
        GlStateManager.enableBlend();
        if (this.func_175183_b() && this.mc.gameSettings.thirdPersonView < 1) {
            GlStateManager.tryBlendFuncSeparate(775, 769, 1, 0);
            GlStateManager.enableAlpha();
            this.drawTexturedModalRect(lllllllllllllllllIIIIIIIIIllllll / 2 - 7, lllllllllllllllllIIIIIIIIIlllllI / 2 - 7, 0, 0, 16, 16);
        }
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        this.mc.mcProfiler.startSection("bossHealth");
        this.renderBossHealth();
        this.mc.mcProfiler.endSection();
        if (this.mc.playerController.shouldDrawHUD()) {
            this.func_180477_d(lllllllllllllllllIIIIIIIIlIIIIII);
        }
        GlStateManager.disableBlend();
        if (this.mc.thePlayer.getSleepTimer() > 0) {
            this.mc.mcProfiler.startSection("sleep");
            GlStateManager.disableDepth();
            GlStateManager.disableAlpha();
            final int lllllllllllllllllIIIIIIIIIllIlIl = this.mc.thePlayer.getSleepTimer();
            float lllllllllllllllllIIIIIIIIIlllIll = lllllllllllllllllIIIIIIIIIllIlIl / 100.0f;
            if (lllllllllllllllllIIIIIIIIIlllIll > 1.0f) {
                lllllllllllllllllIIIIIIIIIlllIll = 1.0f - (lllllllllllllllllIIIIIIIIIllIlIl - 100) / 10.0f;
            }
            final int lllllllllllllllllIIIIIIIIIlllIII = (int)(220.0f * lllllllllllllllllIIIIIIIIIlllIll) << 24 | 0x101020;
            Gui.drawRect(0.0, 0.0, lllllllllllllllllIIIIIIIIIllllll, lllllllllllllllllIIIIIIIIIlllllI, lllllllllllllllllIIIIIIIIIlllIII);
            GlStateManager.enableAlpha();
            GlStateManager.enableDepth();
            this.mc.mcProfiler.endSection();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final int lllllllllllllllllIIIIIIIIIllIlII = lllllllllllllllllIIIIIIIIIllllll / 2 - 91;
        if (this.mc.thePlayer.isRidingHorse()) {
            this.func_175186_a(lllllllllllllllllIIIIIIIIlIIIIII, lllllllllllllllllIIIIIIIIIllIlII);
        }
        else if (this.mc.playerController.gameIsSurvivalOrAdventure()) {
            this.func_175176_b(lllllllllllllllllIIIIIIIIlIIIIII, lllllllllllllllllIIIIIIIIIllIlII);
        }
        if (this.mc.gameSettings.heldItemTooltips && !this.mc.playerController.enableEverythingIsScrewedUpMode()) {
            this.func_175182_a(lllllllllllllllllIIIIIIIIlIIIIII);
        }
        else if (this.mc.thePlayer.func_175149_v()) {
            this.field_175197_u.func_175263_a(lllllllllllllllllIIIIIIIIlIIIIII);
        }
        if (this.mc.isDemo()) {
            this.func_175185_b(lllllllllllllllllIIIIIIIIlIIIIII);
        }
        if (this.mc.gameSettings.showDebugInfo) {
            this.overlayDebug.func_175237_a(lllllllllllllllllIIIIIIIIlIIIIII);
        }
        if (this.recordPlayingUpFor > 0) {
            this.mc.mcProfiler.startSection("overlayMessage");
            final float lllllllllllllllllIIIIIIIIIlllIlI = this.recordPlayingUpFor - lllllllllllllllllIIIIIIIIIlIlIlI;
            int lllllllllllllllllIIIIIIIIIllIlll = (int)(lllllllllllllllllIIIIIIIIIlllIlI * 255.0f / 20.0f);
            if (lllllllllllllllllIIIIIIIIIllIlll > 255) {
                lllllllllllllllllIIIIIIIIIllIlll = 255;
            }
            if (lllllllllllllllllIIIIIIIIIllIlll > 8) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(lllllllllllllllllIIIIIIIIIllllll / 2), (float)(lllllllllllllllllIIIIIIIIIlllllI - 68), 0.0f);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                int lllllllllllllllllIIIIIIIIIllIIll = 16777215;
                if (this.recordIsPlaying) {
                    lllllllllllllllllIIIIIIIIIllIIll = (Color.HSBtoRGB(lllllllllllllllllIIIIIIIIIlllIlI / 50.0f, 0.7f, 0.6f) & 0xFFFFFF);
                }
                this.func_175179_f().drawString(this.recordPlaying, -this.func_175179_f().getStringWidth(this.recordPlaying) / 2, -4.0, lllllllllllllllllIIIIIIIIIllIIll + (lllllllllllllllllIIIIIIIIIllIlll << 24 & 0xFF000000));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
            this.mc.mcProfiler.endSection();
        }
        if (this.field_175195_w > 0) {
            this.mc.mcProfiler.startSection("titleAndSubtitle");
            final float lllllllllllllllllIIIIIIIIIlllIIl = this.field_175195_w - lllllllllllllllllIIIIIIIIIlIlIlI;
            int lllllllllllllllllIIIIIIIIIllIllI = 255;
            if (this.field_175195_w > this.field_175193_B + this.field_175192_A) {
                final float lllllllllllllllllIIIIIIIIIllIIIl = this.field_175199_z + this.field_175192_A + this.field_175193_B - lllllllllllllllllIIIIIIIIIlllIIl;
                lllllllllllllllllIIIIIIIIIllIllI = (int)(lllllllllllllllllIIIIIIIIIllIIIl * 255.0f / this.field_175199_z);
            }
            if (this.field_175195_w <= this.field_175193_B) {
                lllllllllllllllllIIIIIIIIIllIllI = (int)(lllllllllllllllllIIIIIIIIIlllIIl * 255.0f / this.field_175193_B);
            }
            lllllllllllllllllIIIIIIIIIllIllI = MathHelper.clamp_int(lllllllllllllllllIIIIIIIIIllIllI, 0, 255);
            if (lllllllllllllllllIIIIIIIIIllIllI > 8) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(lllllllllllllllllIIIIIIIIIllllll / 2), (float)(lllllllllllllllllIIIIIIIIIlllllI / 2), 0.0f);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.pushMatrix();
                GlStateManager.scale(4.0f, 4.0f, 4.0f);
                final int lllllllllllllllllIIIIIIIIIllIIlI = lllllllllllllllllIIIIIIIIIllIllI << 24 & 0xFF000000;
                this.func_175179_f().func_175065_a(this.field_175201_x, (float)(-this.func_175179_f().getStringWidth(this.field_175201_x) / 2), -10.0f, 0xFFFFFF | lllllllllllllllllIIIIIIIIIllIIlI, true);
                GlStateManager.popMatrix();
                GlStateManager.pushMatrix();
                GlStateManager.scale(2.0f, 2.0f, 2.0f);
                this.func_175179_f().func_175065_a(this.field_175200_y, (float)(-this.func_175179_f().getStringWidth(this.field_175200_y) / 2), 5.0f, 0xFFFFFF | lllllllllllllllllIIIIIIIIIllIIlI, true);
                GlStateManager.popMatrix();
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
            this.mc.mcProfiler.endSection();
        }
        final Scoreboard lllllllllllllllllIIIIIIIIIllIIII = this.mc.theWorld.getScoreboard();
        ScoreObjective lllllllllllllllllIIIIIIIIIlIllll = null;
        final ScorePlayerTeam lllllllllllllllllIIIIIIIIIlIlllI = lllllllllllllllllIIIIIIIIIllIIII.getPlayersTeam(this.mc.thePlayer.getName());
        if (lllllllllllllllllIIIIIIIIIlIlllI != null) {
            final int lllllllllllllllllIIIIIIIIIlIllIl = lllllllllllllllllIIIIIIIIIlIlllI.func_178775_l().func_175746_b();
            if (lllllllllllllllllIIIIIIIIIlIllIl >= 0) {
                lllllllllllllllllIIIIIIIIIlIllll = lllllllllllllllllIIIIIIIIIllIIII.getObjectiveInDisplaySlot(3 + lllllllllllllllllIIIIIIIIIlIllIl);
            }
        }
        ScoreObjective lllllllllllllllllIIIIIIIIIlIllII = (lllllllllllllllllIIIIIIIIIlIllll != null) ? lllllllllllllllllIIIIIIIIIlIllll : lllllllllllllllllIIIIIIIIIllIIII.getObjectiveInDisplaySlot(1);
        if (lllllllllllllllllIIIIIIIIIlIllII != null) {
            this.func_180475_a(lllllllllllllllllIIIIIIIIIlIllII, lllllllllllllllllIIIIIIIIlIIIIII);
        }
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.disableAlpha();
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, (float)(lllllllllllllllllIIIIIIIIIlllllI - 48), 0.0f);
        this.mc.mcProfiler.startSection("chat");
        this.persistantChatGUI.drawChat(this.updateCounter);
        this.mc.mcProfiler.endSection();
        GlStateManager.popMatrix();
        lllllllllllllllllIIIIIIIIIlIllII = lllllllllllllllllIIIIIIIIIllIIII.getObjectiveInDisplaySlot(0);
        if (this.mc.gameSettings.keyBindPlayerList.getIsKeyPressed() && (!this.mc.isIntegratedServerRunning() || this.mc.thePlayer.sendQueue.func_175106_d().size() > 1 || lllllllllllllllllIIIIIIIIIlIllII != null)) {
            this.overlayPlayerList.func_175246_a(true);
            this.overlayPlayerList.func_175249_a(lllllllllllllllllIIIIIIIIIllllll, lllllllllllllllllIIIIIIIIIllIIII, lllllllllllllllllIIIIIIIIIlIllII);
        }
        else {
            this.overlayPlayerList.func_175246_a(false);
        }
        Client.hud.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableLighting();
        GlStateManager.enableAlpha();
    }
    
    static {
        __OBFID = "CL_00000661";
        vignetteTexPath = new ResourceLocation("textures/misc/vignette.png");
        widgetsTexPath = new ResourceLocation("textures/gui/widgets.png");
        pumpkinBlurTexPath = new ResourceLocation("textures/misc/pumpkinblur.png");
    }
    
    protected boolean func_175183_b() {
        if (this.mc.gameSettings.showDebugInfo && !this.mc.thePlayer.func_175140_cp() && !this.mc.gameSettings.field_178879_v) {
            return false;
        }
        if (!this.mc.playerController.enableEverythingIsScrewedUpMode()) {
            return true;
        }
        if (this.mc.pointedEntity != null) {
            return true;
        }
        if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final BlockPos llllllllllllllllIlllllllIlllllll = this.mc.objectMouseOver.func_178782_a();
            if (this.mc.theWorld.getTileEntity(llllllllllllllllIlllllllIlllllll) instanceof IInventory) {
                return true;
            }
        }
        return false;
    }
}
