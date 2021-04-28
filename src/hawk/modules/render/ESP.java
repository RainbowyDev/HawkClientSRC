package hawk.modules.render;

import hawk.modules.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import java.awt.*;
import hawk.util.*;

public class ESP extends Module
{
    @Override
    public void onDisable() {
    }
    
    @Override
    public void onEvent(final Event llllllllllllllIIIlIIlIIlIIllllIl) {
        if (llllllllllllllIIIlIIlIIlIIllllIl instanceof EventRender3D) {
            for (final Object llllllllllllllIIIlIIlIIlIIllllII : this.mc.theWorld.loadedEntityList) {
                if (llllllllllllllIIIlIIlIIlIIllllII instanceof EntityLivingBase) {
                    final EntityLivingBase llllllllllllllIIIlIIlIIlIIlllIlI = (EntityLivingBase)llllllllllllllIIIlIIlIIlIIllllII;
                    final AxisAlignedBB llllllllllllllIIIlIIlIIlIIlllIII = new AxisAlignedBB(llllllllllllllIIIlIIlIIlIIlllIlI.boundingBox.minX - llllllllllllllIIIlIIlIIlIIlllIlI.posX + (llllllllllllllIIIlIIlIIlIIlllIlI.posX - this.mc.getRenderManager().renderPosX), llllllllllllllIIIlIIlIIlIIlllIlI.boundingBox.minY - llllllllllllllIIIlIIlIIlIIlllIlI.posY + (llllllllllllllIIIlIIlIIlIIlllIlI.posY - this.mc.getRenderManager().renderPosY), llllllllllllllIIIlIIlIIlIIlllIlI.boundingBox.minZ - llllllllllllllIIIlIIlIIlIIlllIlI.posZ + (llllllllllllllIIIlIIlIIlIIlllIlI.posZ - this.mc.getRenderManager().renderPosZ), llllllllllllllIIIlIIlIIlIIlllIlI.boundingBox.maxX - llllllllllllllIIIlIIlIIlIIlllIlI.posX + (llllllllllllllIIIlIIlIIlIIlllIlI.posX - this.mc.getRenderManager().renderPosX), llllllllllllllIIIlIIlIIlIIlllIlI.boundingBox.maxY - llllllllllllllIIIlIIlIIlIIlllIlI.posY + (llllllllllllllIIIlIIlIIlIIlllIlI.posY - this.mc.getRenderManager().renderPosY), llllllllllllllIIIlIIlIIlIIlllIlI.boundingBox.maxZ - llllllllllllllIIIlIIlIIlIIlllIlI.posZ + (llllllllllllllIIIlIIlIIlIIlllIlI.posZ - this.mc.getRenderManager().renderPosZ));
                    if (llllllllllllllIIIlIIlIIlIIlllIlI == this.mc.thePlayer || !(llllllllllllllIIIlIIlIIlIIlllIlI instanceof EntityPlayer)) {
                        continue;
                    }
                    final float llllllllllllllIIIlIIlIIlIIllIllI = System.currentTimeMillis() % 4500L / 4500.0f;
                    final int llllllllllllllIIIlIIlIIlIIllIlII = Color.HSBtoRGB(llllllllllllllIIIlIIlIIlIIllIllI, 1.0f, 1.0f);
                    final Color llllllllllllllIIIlIIlIIlIIllIIlI = new Color(llllllllllllllIIIlIIlIIlIIllIlII);
                    final float llllllllllllllIIIlIIlIIlIIllIIII = (float)llllllllllllllIIIlIIlIIlIIllIIlI.getRed();
                    final float llllllllllllllIIIlIIlIIlIIlIlllI = (float)llllllllllllllIIIlIIlIIlIIllIIlI.getGreen();
                    final float llllllllllllllIIIlIIlIIlIIlIllII = (float)llllllllllllllIIIlIIlIIlIIllIIlI.getBlue();
                    final float llllllllllllllIIIlIIlIIlIIlIlIlI = (float)llllllllllllllIIIlIIlIIlIIllIIlI.getAlpha();
                    RenderUtil.drawBoundingBox(llllllllllllllIIIlIIlIIlIIlllIII, llllllllllllllIIIlIIlIIlIIllIIII / 255.0f, llllllllllllllIIIlIIlIIlIIlIlllI / 255.0f, llllllllllllllIIIlIIlIIlIIlIllII / 255.0f, 0.75f);
                }
            }
        }
    }
    
    @Override
    public void onEnable() {
    }
    
    public ESP() {
        super("ESP", 0, Category.RENDER);
    }
}
