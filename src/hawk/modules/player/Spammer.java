package hawk.modules.player;

import hawk.modules.*;
import java.util.*;
import hawk.util.*;
import hawk.events.*;
import hawk.events.listeners.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import hawk.settings.*;

public class Spammer extends Module
{
    /* synthetic */ Random random;
    public /* synthetic */ ModeSetting mode;
    public /* synthetic */ NumberSetting delay;
    /* synthetic */ String message;
    /* synthetic */ Timer timer;
    
    @Override
    public void onEvent(final Event lIllIIlIIllll) {
        if (lIllIIlIIllll instanceof EventUpdate) {
            if (this.timer.hasTimeElapsed(50L, true)) {
                this.mc.thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(String.valueOf(new StringBuilder("/r spam moment").append(this.random.nextInt(1000)))));
            }
            this.setDisplayname("Spammer");
            if (this.mode.is("Redesky")) {
                this.message = " Redesky anticheat best ww ";
            }
            else if (this.mode.is("Developing hawk")) {
                this.message = " Yescheatplus status : developing Hawk ";
            }
            if (this.timer.hasTimeElapsed((long)this.delay.getValue(), true)) {
                this.mc.thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(String.valueOf(new StringBuilder(String.valueOf(this.random.nextInt(1000))).append(this.message).append(this.random.nextInt(1000)))));
            }
        }
    }
    
    public Spammer() {
        super("Spammer", 0, Category.PLAYER);
        this.timer = new Timer();
        this.delay = new NumberSetting("Delay (in ms)", 4500.0, 50.0, 60000.0, 50.0, this);
        this.mode = new ModeSetting("Mode", this, "Redesky", new String[] { "Redesky", "Developing hawk" });
        this.random = new Random();
        this.addSettings(this.delay);
    }
}
