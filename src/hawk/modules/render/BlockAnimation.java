package hawk.modules.render;

import hawk.modules.*;
import hawk.util.*;
import hawk.settings.*;

public class BlockAnimation extends Module
{
    public static /* synthetic */ int BlockAnimationInt;
    /* synthetic */ Timer timer;
    public /* synthetic */ ModeSetting animation;
    /* synthetic */ boolean PlayerEat;
    
    @Override
    public void onEnable() {
        this.toggle();
    }
    
    static {
        BlockAnimation.BlockAnimationInt = 0;
    }
    
    public BlockAnimation() {
        super("SwordAnimations", 0, Category.RENDER);
        this.animation = new ModeSetting("Animation", this, "EZE", new String[] { "EZE", "Vanilla", "Monsoon", "Fan" });
        this.timer = new Timer();
        this.PlayerEat = false;
        this.addSettings(this.animation);
    }
}
