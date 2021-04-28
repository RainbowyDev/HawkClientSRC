package net.minecraft.client.audio;

import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public class SoundEventAccessorComposite implements ISoundEventAccessor
{
    private final /* synthetic */ ResourceLocation soundLocation;
    private final /* synthetic */ Random rnd;
    private /* synthetic */ double eventVolume;
    private /* synthetic */ double eventPitch;
    private final /* synthetic */ SoundCategory category;
    private final /* synthetic */ List soundPool;
    
    @Override
    public Object cloneEntry() {
        return this.cloneEntry1();
    }
    
    public SoundEventAccessorComposite(final ResourceLocation lllllllllllllllIIlllIIlIlIlllllI, final double lllllllllllllllIIlllIIlIlIllllIl, final double lllllllllllllllIIlllIIlIlIllIlll, final SoundCategory lllllllllllllllIIlllIIlIlIllIllI) {
        this.soundPool = Lists.newArrayList();
        this.rnd = new Random();
        this.soundLocation = lllllllllllllllIIlllIIlIlIlllllI;
        this.eventVolume = lllllllllllllllIIlllIIlIlIllIlll;
        this.eventPitch = lllllllllllllllIIlllIIlIlIllllIl;
        this.category = lllllllllllllllIIlllIIlIlIllIllI;
    }
    
    static {
        __OBFID = "CL_00001146";
    }
    
    public SoundCategory getSoundCategory() {
        return this.category;
    }
    
    public ResourceLocation getSoundEventLocation() {
        return this.soundLocation;
    }
    
    public void addSoundToEventPool(final ISoundEventAccessor lllllllllllllllIIlllIIlIlIIlIIlI) {
        this.soundPool.add(lllllllllllllllIIlllIIlIlIIlIIlI);
    }
    
    @Override
    public int getWeight() {
        int lllllllllllllllIIlllIIlIlIllIIII = 0;
        for (final ISoundEventAccessor lllllllllllllllIIlllIIlIlIlIllll : this.soundPool) {
            lllllllllllllllIIlllIIlIlIllIIII += lllllllllllllllIIlllIIlIlIlIllll.getWeight();
        }
        return lllllllllllllllIIlllIIlIlIllIIII;
    }
    
    public SoundPoolEntry cloneEntry1() {
        final int lllllllllllllllIIlllIIlIlIlIIIlI = this.getWeight();
        if (!this.soundPool.isEmpty() && lllllllllllllllIIlllIIlIlIlIIIlI != 0) {
            int lllllllllllllllIIlllIIlIlIlIIIIl = this.rnd.nextInt(lllllllllllllllIIlllIIlIlIlIIIlI);
            for (final ISoundEventAccessor lllllllllllllllIIlllIIlIlIIlllll : this.soundPool) {
                lllllllllllllllIIlllIIlIlIlIIIIl -= lllllllllllllllIIlllIIlIlIIlllll.getWeight();
                if (lllllllllllllllIIlllIIlIlIlIIIIl < 0) {
                    final SoundPoolEntry lllllllllllllllIIlllIIlIlIIllllI = (SoundPoolEntry)lllllllllllllllIIlllIIlIlIIlllll.cloneEntry();
                    lllllllllllllllIIlllIIlIlIIllllI.setPitch(lllllllllllllllIIlllIIlIlIIllllI.getPitch() * this.eventPitch);
                    lllllllllllllllIIlllIIlIlIIllllI.setVolume(lllllllllllllllIIlllIIlIlIIllllI.getVolume() * this.eventVolume);
                    return lllllllllllllllIIlllIIlIlIIllllI;
                }
            }
            return SoundHandler.missing_sound;
        }
        return SoundHandler.missing_sound;
    }
}
