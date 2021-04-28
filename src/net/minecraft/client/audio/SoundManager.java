package net.minecraft.client.audio;

import net.minecraft.client.settings.*;
import net.minecraft.entity.player.*;
import org.apache.logging.log4j.*;
import io.netty.util.internal.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import java.io.*;
import java.net.*;
import com.google.common.collect.*;
import paulscode.sound.libraries.*;
import paulscode.sound.codecs.*;
import paulscode.sound.*;

public class SoundManager
{
    private static final /* synthetic */ Marker LOG_MARKER;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ Map delayedSounds;
    private /* synthetic */ boolean loaded;
    private final /* synthetic */ SoundHandler sndHandler;
    private final /* synthetic */ Map playingSounds;
    private /* synthetic */ int playTime;
    private final /* synthetic */ List tickableSounds;
    private /* synthetic */ Map playingSoundPoolEntries;
    private final /* synthetic */ Multimap categorySounds;
    private final /* synthetic */ GameSettings options;
    private /* synthetic */ SoundSystemStarterThread sndSystem;
    private final /* synthetic */ Map playingSoundsStopTime;
    private final /* synthetic */ Map invPlayingSounds;
    
    private float getNormalizedPitch(final ISound llllllllllllllIllllIIIlIIlIIlIIl, final SoundPoolEntry llllllllllllllIllllIIIlIIlIIlIII) {
        return (float)MathHelper.clamp_double(llllllllllllllIllllIIIlIIlIIlIIl.getPitch() * llllllllllllllIllllIIIlIIlIIlIII.getPitch(), 0.5, 2.0);
    }
    
    private synchronized void loadSoundSystem() {
        if (!this.loaded) {
            try {
                new Thread(new Runnable() {
                    static {
                        __OBFID = "CL_00001142";
                    }
                    
                    @Override
                    public void run() {
                        SoundSystemConfig.setLogger((SoundSystemLogger)new SoundSystemLogger() {
                            public void errorMessage(final String lIlIIIlIIlll, final String lIlIIIlIIllI, final int lIlIIIlIIlIl) {
                                if (!lIlIIIlIIllI.isEmpty()) {
                                    SoundManager.logger.error(String.valueOf(new StringBuilder("Error in class '").append(lIlIIIlIIlll).append("'")));
                                    SoundManager.logger.error(lIlIIIlIIllI);
                                }
                            }
                            
                            public void importantMessage(final String lIlIIIlIllIl, final int lIlIIIlIllII) {
                                if (!lIlIIIlIllIl.isEmpty()) {
                                    SoundManager.logger.warn(lIlIIIlIllIl);
                                }
                            }
                            
                            static {
                                __OBFID = "CL_00002378";
                            }
                            
                            public void message(final String lIlIIIllIIII, final int lIlIIIllIIIl) {
                                if (!lIlIIIllIIII.isEmpty()) {
                                    SoundManager.logger.info(lIlIIIllIIII);
                                }
                            }
                        });
                        SoundManager.access$1(SoundManager.this, new SoundSystemStarterThread(null));
                        SoundManager.access$2(SoundManager.this, true);
                        SoundManager.this.sndSystem.setMasterVolume(SoundManager.this.options.getSoundLevel(SoundCategory.MASTER));
                        SoundManager.logger.info(SoundManager.LOG_MARKER, "Sound engine started");
                    }
                }, "Sound Library Loader").start();
            }
            catch (RuntimeException llllllllllllllIllllIIIlIllIIlIII) {
                SoundManager.logger.error(SoundManager.LOG_MARKER, "Error starting SoundSystem. Turning off sounds & music", (Throwable)llllllllllllllIllllIIIlIllIIlIII);
                this.options.setSoundLevel(SoundCategory.MASTER, 0.0f);
                this.options.saveOptions();
            }
        }
    }
    
    private float getSoundCategoryVolume(final SoundCategory llllllllllllllIllllIIIlIllIIIIII) {
        return (llllllllllllllIllllIIIlIllIIIIII != null && llllllllllllllIllllIIIlIllIIIIII != SoundCategory.MASTER) ? this.options.getSoundLevel(llllllllllllllIllllIIIlIllIIIIII) : 1.0f;
    }
    
    public void setListener(final EntityPlayer llllllllllllllIllllIIIIlllllllll, final float llllllllllllllIllllIIIIllllIllII) {
        if (this.loaded && llllllllllllllIllllIIIIlllllllll != null) {
            final float llllllllllllllIllllIIIIlllllllIl = llllllllllllllIllllIIIIlllllllll.prevRotationPitch + (llllllllllllllIllllIIIIlllllllll.rotationPitch - llllllllllllllIllllIIIIlllllllll.prevRotationPitch) * llllllllllllllIllllIIIIllllIllII;
            final float llllllllllllllIllllIIIIlllllllII = llllllllllllllIllllIIIIlllllllll.prevRotationYaw + (llllllllllllllIllllIIIIlllllllll.rotationYaw - llllllllllllllIllllIIIIlllllllll.prevRotationYaw) * llllllllllllllIllllIIIIllllIllII;
            final double llllllllllllllIllllIIIIllllllIll = llllllllllllllIllllIIIIlllllllll.prevPosX + (llllllllllllllIllllIIIIlllllllll.posX - llllllllllllllIllllIIIIlllllllll.prevPosX) * llllllllllllllIllllIIIIllllIllII;
            final double llllllllllllllIllllIIIIllllllIlI = llllllllllllllIllllIIIIlllllllll.prevPosY + (llllllllllllllIllllIIIIlllllllll.posY - llllllllllllllIllllIIIIlllllllll.prevPosY) * llllllllllllllIllllIIIIllllIllII + llllllllllllllIllllIIIIlllllllll.getEyeHeight();
            final double llllllllllllllIllllIIIIllllllIIl = llllllllllllllIllllIIIIlllllllll.prevPosZ + (llllllllllllllIllllIIIIlllllllll.posZ - llllllllllllllIllllIIIIlllllllll.prevPosZ) * llllllllllllllIllllIIIIllllIllII;
            final float llllllllllllllIllllIIIIllllllIII = MathHelper.cos((llllllllllllllIllllIIIIlllllllII + 90.0f) * 0.017453292f);
            final float llllllllllllllIllllIIIIlllllIlll = MathHelper.sin((llllllllllllllIllllIIIIlllllllII + 90.0f) * 0.017453292f);
            final float llllllllllllllIllllIIIIlllllIllI = MathHelper.cos(-llllllllllllllIllllIIIIlllllllIl * 0.017453292f);
            final float llllllllllllllIllllIIIIlllllIlIl = MathHelper.sin(-llllllllllllllIllllIIIIlllllllIl * 0.017453292f);
            final float llllllllllllllIllllIIIIlllllIlII = MathHelper.cos((-llllllllllllllIllllIIIIlllllllIl + 90.0f) * 0.017453292f);
            final float llllllllllllllIllllIIIIlllllIIll = MathHelper.sin((-llllllllllllllIllllIIIIlllllllIl + 90.0f) * 0.017453292f);
            final float llllllllllllllIllllIIIIlllllIIlI = llllllllllllllIllllIIIIllllllIII * llllllllllllllIllllIIIIlllllIllI;
            final float llllllllllllllIllllIIIIlllllIIIl = llllllllllllllIllllIIIIlllllIlll * llllllllllllllIllllIIIIlllllIllI;
            final float llllllllllllllIllllIIIIlllllIIII = llllllllllllllIllllIIIIllllllIII * llllllllllllllIllllIIIIlllllIlII;
            final float llllllllllllllIllllIIIIllllIllll = llllllllllllllIllllIIIIlllllIlll * llllllllllllllIllllIIIIlllllIlII;
            this.sndSystem.setListenerPosition((float)llllllllllllllIllllIIIIllllllIll, (float)llllllllllllllIllllIIIIllllllIlI, (float)llllllllllllllIllllIIIIllllllIIl);
            this.sndSystem.setListenerOrientation(llllllllllllllIllllIIIIlllllIIlI, llllllllllllllIllllIIIIlllllIlIl, llllllllllllllIllllIIIIlllllIIIl, llllllllllllllIllllIIIIlllllIIII, llllllllllllllIllllIIIIlllllIIll, llllllllllllllIllllIIIIllllIllll);
        }
    }
    
    static {
        __OBFID = "CL_00001141";
        LOG_MARKER = MarkerManager.getMarker("SOUNDS");
        logger = LogManager.getLogger();
    }
    
    public void pauseAllSounds() {
        for (final String llllllllllllllIllllIIIlIIIllIlII : this.playingSounds.keySet()) {
            SoundManager.logger.debug(SoundManager.LOG_MARKER, "Pausing channel {}", new Object[] { llllllllllllllIllllIIIlIIIllIlII });
            this.sndSystem.pause(llllllllllllllIllllIIIlIIIllIlII);
        }
    }
    
    public void stopSound(final ISound llllllllllllllIllllIIIlIIlllIlIl) {
        if (this.loaded) {
            final String llllllllllllllIllllIIIlIIlllIlII = this.invPlayingSounds.get(llllllllllllllIllllIIIlIIlllIlIl);
            if (llllllllllllllIllllIIIlIIlllIlII != null) {
                this.sndSystem.stop(llllllllllllllIllllIIIlIIlllIlII);
            }
        }
    }
    
    public void playDelayedSound(final ISound llllllllllllllIllllIIIlIIIlIIIII, final int llllllllllllllIllllIIIlIIIlIIIlI) {
        this.delayedSounds.put(llllllllllllllIllllIIIlIIIlIIIII, this.playTime + llllllllllllllIllllIIIlIIIlIIIlI);
    }
    
    public void stopAllSounds() {
        if (this.loaded) {
            for (final String llllllllllllllIllllIIIlIlIlIIIlI : this.playingSounds.keySet()) {
                this.sndSystem.stop(llllllllllllllIllllIIIlIlIlIIIlI);
            }
            this.playingSounds.clear();
            this.delayedSounds.clear();
            this.tickableSounds.clear();
            this.categorySounds.clear();
            this.playingSoundPoolEntries.clear();
            this.playingSoundsStopTime.clear();
        }
    }
    
    public void updateAllSounds() {
        ++this.playTime;
        for (final ITickableSound llllllllllllllIllllIIIlIlIIlIIlI : this.tickableSounds) {
            llllllllllllllIllllIIIlIlIIlIIlI.update();
            if (llllllllllllllIllllIIIlIlIIlIIlI.isDonePlaying()) {
                this.stopSound(llllllllllllllIllllIIIlIlIIlIIlI);
            }
            else {
                final String llllllllllllllIllllIIIlIlIIlIlII = this.invPlayingSounds.get(llllllllllllllIllllIIIlIlIIlIIlI);
                this.sndSystem.setVolume(llllllllllllllIllllIIIlIlIIlIlII, this.getNormalizedVolume(llllllllllllllIllllIIIlIlIIlIIlI, this.playingSoundPoolEntries.get(llllllllllllllIllllIIIlIlIIlIIlI), this.sndHandler.getSound(llllllllllllllIllllIIIlIlIIlIIlI.getSoundLocation()).getSoundCategory()));
                this.sndSystem.setPitch(llllllllllllllIllllIIIlIlIIlIlII, this.getNormalizedPitch(llllllllllllllIllllIIIlIlIIlIIlI, this.playingSoundPoolEntries.get(llllllllllllllIllllIIIlIlIIlIIlI)));
                this.sndSystem.setPosition(llllllllllllllIllllIIIlIlIIlIlII, llllllllllllllIllllIIIlIlIIlIIlI.getXPosF(), llllllllllllllIllllIIIlIlIIlIIlI.getYPosF(), llllllllllllllIllllIIIlIlIIlIIlI.getZPosF());
            }
        }
        final Iterator llllllllllllllIllllIIIlIlIIlIlIl = this.playingSounds.entrySet().iterator();
        while (llllllllllllllIllllIIIlIlIIlIlIl.hasNext()) {
            final Map.Entry llllllllllllllIllllIIIlIlIIIllll = llllllllllllllIllllIIIlIlIIlIlIl.next();
            final String llllllllllllllIllllIIIlIlIIlIIll = llllllllllllllIllllIIIlIlIIIllll.getKey();
            final ISound llllllllllllllIllllIIIlIlIIlIIIl = llllllllllllllIllllIIIlIlIIIllll.getValue();
            if (!this.sndSystem.playing(llllllllllllllIllllIIIlIlIIlIIll)) {
                final int llllllllllllllIllllIIIlIlIIIlllI = this.playingSoundsStopTime.get(llllllllllllllIllllIIIlIlIIlIIll);
                if (llllllllllllllIllllIIIlIlIIIlllI > this.playTime) {
                    continue;
                }
                final int llllllllllllllIllllIIIlIlIIIllIl = llllllllllllllIllllIIIlIlIIlIIIl.getRepeatDelay();
                if (llllllllllllllIllllIIIlIlIIlIIIl.canRepeat() && llllllllllllllIllllIIIlIlIIIllIl > 0) {
                    this.delayedSounds.put(llllllllllllllIllllIIIlIlIIlIIIl, this.playTime + llllllllllllllIllllIIIlIlIIIllIl);
                }
                llllllllllllllIllllIIIlIlIIlIlIl.remove();
                SoundManager.logger.debug(SoundManager.LOG_MARKER, "Removed channel {} because it's not playing anymore", new Object[] { llllllllllllllIllllIIIlIlIIlIIll });
                this.sndSystem.removeSource(llllllllllllllIllllIIIlIlIIlIIll);
                this.playingSoundsStopTime.remove(llllllllllllllIllllIIIlIlIIlIIll);
                this.playingSoundPoolEntries.remove(llllllllllllllIllllIIIlIlIIlIIIl);
                try {
                    this.categorySounds.remove((Object)this.sndHandler.getSound(llllllllllllllIllllIIIlIlIIlIIIl.getSoundLocation()).getSoundCategory(), (Object)llllllllllllllIllllIIIlIlIIlIIll);
                }
                catch (RuntimeException ex) {}
                if (!(llllllllllllllIllllIIIlIlIIlIIIl instanceof ITickableSound)) {
                    continue;
                }
                this.tickableSounds.remove(llllllllllllllIllllIIIlIlIIlIIIl);
            }
        }
        final Iterator llllllllllllllIllllIIIlIlIIIllII = this.delayedSounds.entrySet().iterator();
        while (llllllllllllllIllllIIIlIlIIIllII.hasNext()) {
            final Map.Entry llllllllllllllIllllIIIlIlIIIlIll = llllllllllllllIllllIIIlIlIIIllII.next();
            if (this.playTime >= llllllllllllllIllllIIIlIlIIIlIll.getValue()) {
                final ISound llllllllllllllIllllIIIlIlIIlIIII = llllllllllllllIllllIIIlIlIIIlIll.getKey();
                if (llllllllllllllIllllIIIlIlIIlIIII instanceof ITickableSound) {
                    ((ITickableSound)llllllllllllllIllllIIIlIlIIlIIII).update();
                }
                this.playSound(llllllllllllllIllllIIIlIlIIlIIII);
                llllllllllllllIllllIIIlIlIIIllII.remove();
            }
        }
    }
    
    public void playSound(final ISound llllllllllllllIllllIIIlIIlIlIlll) {
        if (this.loaded) {
            if (this.sndSystem.getMasterVolume() <= 0.0f) {
                SoundManager.logger.debug(SoundManager.LOG_MARKER, "Skipped playing soundEvent: {}, master volume was zero", new Object[] { llllllllllllllIllllIIIlIIlIlIlll.getSoundLocation() });
            }
            else {
                final SoundEventAccessorComposite llllllllllllllIllllIIIlIIllIIIlI = this.sndHandler.getSound(llllllllllllllIllllIIIlIIlIlIlll.getSoundLocation());
                if (llllllllllllllIllllIIIlIIllIIIlI == null) {
                    SoundManager.logger.warn(SoundManager.LOG_MARKER, "Unable to play unknown soundEvent: {}", new Object[] { llllllllllllllIllllIIIlIIlIlIlll.getSoundLocation() });
                }
                else {
                    final SoundPoolEntry llllllllllllllIllllIIIlIIllIIIIl = (SoundPoolEntry)llllllllllllllIllllIIIlIIllIIIlI.cloneEntry();
                    if (llllllllllllllIllllIIIlIIllIIIIl == SoundHandler.missing_sound) {
                        SoundManager.logger.warn(SoundManager.LOG_MARKER, "Unable to play empty soundEvent: {}", new Object[] { llllllllllllllIllllIIIlIIllIIIlI.getSoundEventLocation() });
                    }
                    else {
                        final float llllllllllllllIllllIIIlIIllIIIII = llllllllllllllIllllIIIlIIlIlIlll.getVolume();
                        float llllllllllllllIllllIIIlIIlIlllll = 16.0f;
                        if (llllllllllllllIllllIIIlIIllIIIII > 1.0f) {
                            llllllllllllllIllllIIIlIIlIlllll *= llllllllllllllIllllIIIlIIllIIIII;
                        }
                        final SoundCategory llllllllllllllIllllIIIlIIlIllllI = llllllllllllllIllllIIIlIIllIIIlI.getSoundCategory();
                        final float llllllllllllllIllllIIIlIIlIlllIl = this.getNormalizedVolume(llllllllllllllIllllIIIlIIlIlIlll, llllllllllllllIllllIIIlIIllIIIIl, llllllllllllllIllllIIIlIIlIllllI);
                        final double llllllllllllllIllllIIIlIIlIlllII = this.getNormalizedPitch(llllllllllllllIllllIIIlIIlIlIlll, llllllllllllllIllllIIIlIIllIIIIl);
                        final ResourceLocation llllllllllllllIllllIIIlIIlIllIll = llllllllllllllIllllIIIlIIllIIIIl.getSoundPoolEntryLocation();
                        if (llllllllllllllIllllIIIlIIlIlllIl == 0.0f) {
                            SoundManager.logger.debug(SoundManager.LOG_MARKER, "Skipped playing sound {}, volume was zero.", new Object[] { llllllllllllllIllllIIIlIIlIllIll });
                        }
                        else {
                            final boolean llllllllllllllIllllIIIlIIlIllIlI = llllllllllllllIllllIIIlIIlIlIlll.canRepeat() && llllllllllllllIllllIIIlIIlIlIlll.getRepeatDelay() == 0;
                            final String llllllllllllllIllllIIIlIIlIllIIl = MathHelper.func_180182_a((Random)ThreadLocalRandom.current()).toString();
                            if (llllllllllllllIllllIIIlIIllIIIIl.isStreamingSound()) {
                                this.sndSystem.newStreamingSource(false, llllllllllllllIllllIIIlIIlIllIIl, getURLForSoundResource(llllllllllllllIllllIIIlIIlIllIll), llllllllllllllIllllIIIlIIlIllIll.toString(), llllllllllllllIllllIIIlIIlIllIlI, llllllllllllllIllllIIIlIIlIlIlll.getXPosF(), llllllllllllllIllllIIIlIIlIlIlll.getYPosF(), llllllllllllllIllllIIIlIIlIlIlll.getZPosF(), llllllllllllllIllllIIIlIIlIlIlll.getAttenuationType().getTypeInt(), llllllllllllllIllllIIIlIIlIlllll);
                            }
                            else {
                                this.sndSystem.newSource(false, llllllllllllllIllllIIIlIIlIllIIl, getURLForSoundResource(llllllllllllllIllllIIIlIIlIllIll), llllllllllllllIllllIIIlIIlIllIll.toString(), llllllllllllllIllllIIIlIIlIllIlI, llllllllllllllIllllIIIlIIlIlIlll.getXPosF(), llllllllllllllIllllIIIlIIlIlIlll.getYPosF(), llllllllllllllIllllIIIlIIlIlIlll.getZPosF(), llllllllllllllIllllIIIlIIlIlIlll.getAttenuationType().getTypeInt(), llllllllllllllIllllIIIlIIlIlllll);
                            }
                            SoundManager.logger.debug(SoundManager.LOG_MARKER, "Playing sound {} for event {} as channel {}", new Object[] { llllllllllllllIllllIIIlIIllIIIIl.getSoundPoolEntryLocation(), llllllllllllllIllllIIIlIIllIIIlI.getSoundEventLocation(), llllllllllllllIllllIIIlIIlIllIIl });
                            this.sndSystem.setPitch(llllllllllllllIllllIIIlIIlIllIIl, (float)llllllllllllllIllllIIIlIIlIlllII);
                            this.sndSystem.setVolume(llllllllllllllIllllIIIlIIlIllIIl, llllllllllllllIllllIIIlIIlIlllIl);
                            this.sndSystem.play(llllllllllllllIllllIIIlIIlIllIIl);
                            this.playingSoundsStopTime.put(llllllllllllllIllllIIIlIIlIllIIl, this.playTime + 20);
                            this.playingSounds.put(llllllllllllllIllllIIIlIIlIllIIl, llllllllllllllIllllIIIlIIlIlIlll);
                            this.playingSoundPoolEntries.put(llllllllllllllIllllIIIlIIlIlIlll, llllllllllllllIllllIIIlIIllIIIIl);
                            if (llllllllllllllIllllIIIlIIlIllllI != SoundCategory.MASTER) {
                                this.categorySounds.put((Object)llllllllllllllIllllIIIlIIlIllllI, (Object)llllllllllllllIllllIIIlIIlIllIIl);
                            }
                            if (llllllllllllllIllllIIIlIIlIlIlll instanceof ITickableSound) {
                                this.tickableSounds.add(llllllllllllllIllllIIIlIIlIlIlll);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void resumeAllSounds() {
        for (final String llllllllllllllIllllIIIlIIIlIlIll : this.playingSounds.keySet()) {
            SoundManager.logger.debug(SoundManager.LOG_MARKER, "Resuming channel {}", new Object[] { llllllllllllllIllllIIIlIIIlIlIll });
            this.sndSystem.play(llllllllllllllIllllIIIlIIIlIlIll);
        }
    }
    
    static /* synthetic */ void access$1(final SoundManager llllllllllllllIllllIIIIlllIllIlI, final SoundSystemStarterThread llllllllllllllIllllIIIIlllIllIIl) {
        llllllllllllllIllllIIIIlllIllIlI.sndSystem = llllllllllllllIllllIIIIlllIllIIl;
    }
    
    public void setSoundCategoryVolume(final SoundCategory llllllllllllllIllllIIIlIlIllIIII, final float llllllllllllllIllllIIIlIlIllIllI) {
        if (this.loaded) {
            if (llllllllllllllIllllIIIlIlIllIIII == SoundCategory.MASTER) {
                this.sndSystem.setMasterVolume(llllllllllllllIllllIIIlIlIllIllI);
            }
            else {
                for (final String llllllllllllllIllllIIIlIlIllIlII : this.categorySounds.get((Object)llllllllllllllIllllIIIlIlIllIIII)) {
                    final ISound llllllllllllllIllllIIIlIlIllIIll = this.playingSounds.get(llllllllllllllIllllIIIlIlIllIlII);
                    final float llllllllllllllIllllIIIlIlIllIIlI = this.getNormalizedVolume(llllllllllllllIllllIIIlIlIllIIll, this.playingSoundPoolEntries.get(llllllllllllllIllllIIIlIlIllIIll), llllllllllllllIllllIIIlIlIllIIII);
                    if (llllllllllllllIllllIIIlIlIllIIlI <= 0.0f) {
                        this.stopSound(llllllllllllllIllllIIIlIlIllIIll);
                    }
                    else {
                        this.sndSystem.setVolume(llllllllllllllIllllIIIlIlIllIlII, llllllllllllllIllllIIIlIlIllIIlI);
                    }
                }
            }
        }
    }
    
    private static URL getURLForSoundResource(final ResourceLocation llllllllllllllIllllIIIlIIIIllIlI) {
        final String llllllllllllllIllllIIIlIIIIllIIl = String.format("%s:%s:%s", "mcsounddomain", llllllllllllllIllllIIIlIIIIllIlI.getResourceDomain(), llllllllllllllIllllIIIlIIIIllIlI.getResourcePath());
        final URLStreamHandler llllllllllllllIllllIIIlIIIIllIII = new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(final URL llllllllllllllIllllIIIlllIlIIIIl) {
                return new URLConnection(llllllllllllllIllllIIIlllIlIIIIl) {
                    @Override
                    public void connect() {
                    }
                    
                    static {
                        __OBFID = "CL_00001144";
                    }
                    
                    @Override
                    public InputStream getInputStream() throws IOException {
                        return Minecraft.getMinecraft().getResourceManager().getResource(llllllllllllllIllllIIIlIIIIllIlI).getInputStream();
                    }
                };
            }
            
            static {
                __OBFID = "CL_00001143";
            }
        };
        try {
            return new URL(null, llllllllllllllIllllIIIlIIIIllIIl, llllllllllllllIllllIIIlIIIIllIII);
        }
        catch (MalformedURLException llllllllllllllIllllIIIlIIIIlIlll) {
            throw new Error("TODO: Sanely handle url exception! :D");
        }
    }
    
    private float getNormalizedVolume(final ISound llllllllllllllIllllIIIlIIIllllII, final SoundPoolEntry llllllllllllllIllllIIIlIIIlllIll, final SoundCategory llllllllllllllIllllIIIlIIIlllIlI) {
        return (float)MathHelper.clamp_double(llllllllllllllIllllIIIlIIIllllII.getVolume() * llllllllllllllIllllIIIlIIIlllIll.getVolume(), 0.0, 1.0) * this.getSoundCategoryVolume(llllllllllllllIllllIIIlIIIlllIlI);
    }
    
    public void unloadSoundSystem() {
        if (this.loaded) {
            this.stopAllSounds();
            this.sndSystem.cleanup();
            this.loaded = false;
        }
    }
    
    public SoundManager(final SoundHandler llllllllllllllIllllIIIlIllIlIIIl, final GameSettings llllllllllllllIllllIIIlIllIlIIII) {
        this.playTime = 0;
        this.playingSounds = (Map)HashBiMap.create();
        this.invPlayingSounds = (Map)((BiMap)this.playingSounds).inverse();
        this.playingSoundPoolEntries = Maps.newHashMap();
        this.categorySounds = (Multimap)HashMultimap.create();
        this.tickableSounds = Lists.newArrayList();
        this.delayedSounds = Maps.newHashMap();
        this.playingSoundsStopTime = Maps.newHashMap();
        this.sndHandler = llllllllllllllIllllIIIlIllIlIIIl;
        this.options = llllllllllllllIllllIIIlIllIlIIII;
        try {
            SoundSystemConfig.addLibrary((Class)LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", (Class)CodecJOrbis.class);
        }
        catch (SoundSystemException llllllllllllllIllllIIIlIllIlIIll) {
            SoundManager.logger.error(SoundManager.LOG_MARKER, "Error linking with the LibraryJavaSound plug-in", (Throwable)llllllllllllllIllllIIIlIllIlIIll);
        }
    }
    
    public void reloadSoundSystem() {
        this.unloadSoundSystem();
        this.loadSoundSystem();
    }
    
    static /* synthetic */ void access$2(final SoundManager llllllllllllllIllllIIIIlllIlIllI, final boolean llllllllllllllIllllIIIIlllIlIlIl) {
        llllllllllllllIllllIIIIlllIlIllI.loaded = llllllllllllllIllllIIIIlllIlIlIl;
    }
    
    public boolean isSoundPlaying(final ISound llllllllllllllIllllIIIlIIllllllI) {
        if (!this.loaded) {
            return false;
        }
        final String llllllllllllllIllllIIIlIIlllllIl = this.invPlayingSounds.get(llllllllllllllIllllIIIlIIllllllI);
        return llllllllllllllIllllIIIlIIlllllIl != null && (this.sndSystem.playing(llllllllllllllIllllIIIlIIlllllIl) || (this.playingSoundsStopTime.containsKey(llllllllllllllIllllIIIlIIlllllIl) && this.playingSoundsStopTime.get(llllllllllllllIllllIIIlIIlllllIl) <= this.playTime));
    }
    
    class SoundSystemStarterThread extends SoundSystem
    {
        public boolean playing(final String llllllllllllllllIllIlllIIlllllll) {
            final Object llllllllllllllllIllIlllIlIIIIIlI = SoundSystemConfig.THREAD_SYNC;
            synchronized (SoundSystemConfig.THREAD_SYNC) {
                if (this.soundLibrary == null) {
                    // monitorexit(SoundSystemConfig.THREAD_SYNC)
                    return false;
                }
                final Source llllllllllllllllIllIlllIlIIIIIIl = this.soundLibrary.getSources().get(llllllllllllllllIllIlllIIlllllll);
                // monitorexit(SoundSystemConfig.THREAD_SYNC)
                return llllllllllllllllIllIlllIlIIIIIIl != null && (llllllllllllllllIllIlllIlIIIIIIl.playing() || llllllllllllllllIllIlllIlIIIIIIl.paused() || llllllllllllllllIllIlllIlIIIIIIl.preLoad);
            }
        }
        
        private SoundSystemStarterThread() {
        }
        
        SoundSystemStarterThread(final SoundManager llllllllllllllllIllIlllIIlllIllI, final Object llllllllllllllllIllIlllIIllllIII) {
            this(llllllllllllllllIllIlllIIlllIllI);
        }
        
        static {
            __OBFID = "CL_00001145";
        }
    }
}
