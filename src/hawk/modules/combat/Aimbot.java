package hawk.modules.combat;

import hawk.modules.*;
import hawk.util.*;
import net.minecraft.entity.*;
import hawk.events.*;
import hawk.events.listeners.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.*;
import net.minecraft.entity.player.*;

public class Aimbot extends Module
{
    public /* synthetic */ Timer timer;
    public /* synthetic */ float oldSens;
    
    public float[] getRotations(final Entity llllllllllllllIIIIIllIIIlIlllllI) {
        final double llllllllllllllIIIIIllIIIllIIIlIl = llllllllllllllIIIIIllIIIlIlllllI.posX + (llllllllllllllIIIIIllIIIlIlllllI.posX - llllllllllllllIIIIIllIIIlIlllllI.lastTickPosX) - this.mc.thePlayer.posX;
        final double llllllllllllllIIIIIllIIIllIIIlII = llllllllllllllIIIIIllIIIlIlllllI.posY - 3.5 + llllllllllllllIIIIIllIIIlIlllllI.getEyeHeight() - this.mc.thePlayer.posY + this.mc.thePlayer.getEyeHeight();
        final double llllllllllllllIIIIIllIIIllIIIIll = llllllllllllllIIIIIllIIIlIlllllI.posZ + (llllllllllllllIIIIIllIIIlIlllllI.posZ - llllllllllllllIIIIIllIIIlIlllllI.lastTickPosZ) - this.mc.thePlayer.posZ;
        final double llllllllllllllIIIIIllIIIllIIIIlI = Math.sqrt(Math.pow(llllllllllllllIIIIIllIIIllIIIlIl, 2.0) + Math.pow(llllllllllllllIIIIIllIIIllIIIIll, 2.0));
        float llllllllllllllIIIIIllIIIllIIIIIl = (float)Math.toDegrees(-Math.atan(llllllllllllllIIIIIllIIIllIIIlIl / llllllllllllllIIIIIllIIIllIIIIll));
        final float llllllllllllllIIIIIllIIIllIIIIII = (float)(-Math.toDegrees(Math.atan(llllllllllllllIIIIIllIIIllIIIlII / llllllllllllllIIIIIllIIIllIIIIlI)));
        if (llllllllllllllIIIIIllIIIllIIIlIl < 0.0 && llllllllllllllIIIIIllIIIllIIIIll < 0.0) {
            llllllllllllllIIIIIllIIIllIIIIIl = (float)(90.0 + Math.toDegrees(Math.atan(llllllllllllllIIIIIllIIIllIIIIll / llllllllllllllIIIIIllIIIllIIIlIl)));
        }
        else if (llllllllllllllIIIIIllIIIllIIIlIl > 0.0 && llllllllllllllIIIIIllIIIllIIIIll < 0.0) {
            llllllllllllllIIIIIllIIIllIIIIIl = (float)(-90.0 + Math.toDegrees(Math.atan(llllllllllllllIIIIIllIIIllIIIIll / llllllllllllllIIIIIllIIIllIIIlIl)));
        }
        return new float[] { llllllllllllllIIIIIllIIIllIIIIIl, llllllllllllllIIIIIllIIIllIIIIII };
    }
    
    @Override
    public void onDisable() {
        this.mc.gameSettings.mouseSensitivity = this.oldSens;
    }
    
    @Override
    public void onEvent(final Event llllllllllllllIIIIIllIIIllIlIIll) {
        if (llllllllllllllIIIIIllIIIllIlIIll instanceof EventMotion && llllllllllllllIIIIIllIIIllIlIIll.isPre()) {
            final EventMotion llllllllllllllIIIIIllIIIllIlIlll = (EventMotion)llllllllllllllIIIIIllIIIllIlIIll;
            List<EntityLivingBase> llllllllllllllIIIIIllIIIllIlIllI = (List<EntityLivingBase>)this.mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
            llllllllllllllIIIIIllIIIllIlIllI = llllllllllllllIIIIIllIIIllIlIllI.stream().filter(llllllllllllllIIIIIllIIIlIllIlII -> llllllllllllllIIIIIllIIIlIllIlII.getDistanceToEntity(this.mc.thePlayer) < 5.0f && llllllllllllllIIIIIllIIIlIllIlII != this.mc.thePlayer && !llllllllllllllIIIIIllIIIlIllIlII.isDead && !llllllllllllllIIIIIllIIIlIllIlII.isInvisible()).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
            llllllllllllllIIIIIllIIIllIlIllI.sort(Comparator.comparingDouble(llllllllllllllIIIIIllIIIlIlIllII -> llllllllllllllIIIIIllIIIlIlIllII.getDistanceToEntity(this.mc.thePlayer)));
            llllllllllllllIIIIIllIIIllIlIllI = llllllllllllllIIIIIllIIIllIlIllI.stream().filter(EntityPlayer.class::isInstance).collect((Collector<? super Object, ?, List<EntityLivingBase>>)Collectors.toList());
            if (!llllllllllllllIIIIIllIIIllIlIllI.isEmpty()) {
                final EntityLivingBase llllllllllllllIIIIIllIIIllIlIlIl = llllllllllllllIIIIIllIIIllIlIllI.get(0);
                this.mc.thePlayer.rotationYaw = this.getRotations(llllllllllllllIIIIIllIIIllIlIlIl)[0];
                this.mc.thePlayer.rotationPitch = this.getRotations(llllllllllllllIIIIIllIIIllIlIlIl)[1];
                this.timer.hasTimeElapsed(100L, true);
            }
        }
    }
    
    public Aimbot() {
        super("Aimbot", 0, Category.COMBAT);
        this.timer = new Timer();
    }
    
    @Override
    public void onEnable() {
        this.oldSens = this.mc.gameSettings.mouseSensitivity;
    }
}
