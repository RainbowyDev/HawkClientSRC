package net.minecraft.client.audio;

import net.minecraft.util.*;

public interface ISound
{
    ResourceLocation getSoundLocation();
    
    float getVolume();
    
    AttenuationType getAttenuationType();
    
    float getXPosF();
    
    float getZPosF();
    
    boolean canRepeat();
    
    int getRepeatDelay();
    
    float getYPosF();
    
    float getPitch();
    
    public enum AttenuationType
    {
        private final /* synthetic */ int type;
        
        NONE("NONE", 0, "NONE", 0, 0), 
        LINEAR("LINEAR", 1, "LINEAR", 1, 2);
        
        private AttenuationType(final String llllllllllllllIllIIlIlllIlIIIlII, final int llllllllllllllIllIIlIlllIlIIIIll, final String llllllllllllllIllIIlIlllIlIIlIII, final int llllllllllllllIllIIlIlllIlIIIlll, final int llllllllllllllIllIIlIlllIlIIIllI) {
            this.type = llllllllllllllIllIIlIlllIlIIIllI;
        }
        
        static {
            __OBFID = "CL_00001126";
        }
        
        public int getTypeInt() {
            return this.type;
        }
    }
}
