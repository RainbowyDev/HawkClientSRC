package net.minecraft.client.audio;

import net.minecraft.server.gui.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import org.apache.commons.lang3.*;
import java.util.*;
import org.apache.logging.log4j.*;
import com.google.gson.*;
import java.lang.reflect.*;
import net.minecraft.client.settings.*;
import java.io.*;
import org.apache.commons.io.*;

public class SoundHandler implements IUpdatePlayerListBox, IResourceManagerReloadListener
{
    private final /* synthetic */ SoundManager sndManager;
    public static final /* synthetic */ SoundPoolEntry missing_sound;
    private final /* synthetic */ SoundRegistry sndRegistry;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ IResourceManager mcResourceManager;
    
    public void playSound(final ISound lllllllllllllllIllIlIlIlIIlIIllI) {
        this.sndManager.playSound(lllllllllllllllIllIlIlIlIIlIIllI);
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllllIllIlIlIlIlllIlII) {
        this.sndManager.reloadSoundSystem();
        this.sndRegistry.clearMap();
        for (final String lllllllllllllllIllIlIlIlIlllllIl : lllllllllllllllIllIlIlIlIlllIlII.getResourceDomains()) {
            try {
                final List lllllllllllllllIllIlIlIlIlllllII = lllllllllllllllIllIlIlIlIlllIlII.getAllResources(new ResourceLocation(lllllllllllllllIllIlIlIlIlllllIl, "sounds.json"));
                for (final IResource lllllllllllllllIllIlIlIlIllllIlI : lllllllllllllllIllIlIlIlIlllllII) {
                    try {
                        final Map lllllllllllllllIllIlIlIlIllllIIl = this.getSoundMap(lllllllllllllllIllIlIlIlIllllIlI.getInputStream());
                        for (final Map.Entry lllllllllllllllIllIlIlIlIlllIlll : lllllllllllllllIllIlIlIlIllllIIl.entrySet()) {
                            this.loadSoundResource(new ResourceLocation(lllllllllllllllIllIlIlIlIlllllIl, lllllllllllllllIllIlIlIlIlllIlll.getKey()), lllllllllllllllIllIlIlIlIlllIlll.getValue());
                        }
                    }
                    catch (RuntimeException lllllllllllllllIllIlIlIlIlllIllI) {
                        SoundHandler.logger.warn("Invalid sounds.json", (Throwable)lllllllllllllllIllIlIlIlIlllIllI);
                    }
                }
            }
            catch (IOException ex) {}
        }
    }
    
    public boolean isSoundPlaying(final ISound lllllllllllllllIllIlIlIIlllIIIII) {
        return this.sndManager.isSoundPlaying(lllllllllllllllIllIlIlIIlllIIIII);
    }
    
    @Override
    public void update() {
        this.sndManager.updateAllSounds();
    }
    
    public void pauseSounds() {
        this.sndManager.pauseAllSounds();
    }
    
    public void setListener(final EntityPlayer lllllllllllllllIllIlIlIlIIIlIlIl, final float lllllllllllllllIllIlIlIlIIIlIlII) {
        this.sndManager.setListener(lllllllllllllllIllIlIlIlIIIlIlIl, lllllllllllllllIllIlIlIlIIIlIlII);
    }
    
    public void stopSound(final ISound lllllllllllllllIllIlIlIIlllllIII) {
        this.sndManager.stopSound(lllllllllllllllIllIlIlIIlllllIII);
    }
    
    public SoundEventAccessorComposite getRandomSoundFromCategories(final SoundCategory... lllllllllllllllIllIlIlIIlllIlIII) {
        final ArrayList lllllllllllllllIllIlIlIIlllIllIl = Lists.newArrayList();
        for (final ResourceLocation lllllllllllllllIllIlIlIIlllIlIll : this.sndRegistry.getKeys()) {
            final SoundEventAccessorComposite lllllllllllllllIllIlIlIIlllIlIlI = (SoundEventAccessorComposite)this.sndRegistry.getObject(lllllllllllllllIllIlIlIIlllIlIll);
            if (ArrayUtils.contains((Object[])lllllllllllllllIllIlIlIIlllIlIII, (Object)lllllllllllllllIllIlIlIIlllIlIlI.getSoundCategory())) {
                lllllllllllllllIllIlIlIIlllIllIl.add(lllllllllllllllIllIlIlIIlllIlIlI);
            }
        }
        if (lllllllllllllllIllIlIlIIlllIllIl.isEmpty()) {
            return null;
        }
        return lllllllllllllllIllIlIlIIlllIllIl.get(new Random().nextInt(lllllllllllllllIllIlIlIIlllIllIl.size()));
    }
    
    public void playDelayedSound(final ISound lllllllllllllllIllIlIlIlIIlIIIIl, final int lllllllllllllllIllIlIlIlIIlIIIII) {
        this.sndManager.playDelayedSound(lllllllllllllllIllIlIlIlIIlIIIIl, lllllllllllllllIllIlIlIlIIlIIIII);
    }
    
    static {
        __OBFID = "CL_00001147";
        logger = LogManager.getLogger();
        field_147699_c = new GsonBuilder().registerTypeAdapter((Type)SoundList.class, (Object)new SoundListSerializer()).create();
        field_147696_d = new ParameterizedType() {
            @Override
            public Type getRawType() {
                return Map.class;
            }
            
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { String.class, SoundList.class };
            }
            
            @Override
            public Type getOwnerType() {
                return null;
            }
            
            static {
                __OBFID = "CL_00001148";
            }
        };
        missing_sound = new SoundPoolEntry(new ResourceLocation("meta:missing_sound"), 0.0, 0.0, false);
    }
    
    public SoundEventAccessorComposite getSound(final ResourceLocation lllllllllllllllIllIlIlIlIIlIllII) {
        return (SoundEventAccessorComposite)this.sndRegistry.getObject(lllllllllllllllIllIlIlIlIIlIllII);
    }
    
    protected Map getSoundMap(final InputStream lllllllllllllllIllIlIlIlIllIIlll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: new             Ljava/io/InputStreamReader;
        //     6: dup            
        //     7: aload_1         /* lllllllllllllllIllIlIlIlIllIIlII */
        //     8: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    11: getstatic       net/minecraft/client/audio/SoundHandler.field_147696_d:Ljava/lang/reflect/ParameterizedType;
        //    14: invokevirtual   com/google/gson/Gson.fromJson:(Ljava/io/Reader;Ljava/lang/reflect/Type;)Ljava/lang/Object;
        //    17: checkcast       Ljava/util/Map;
        //    20: astore_2        /* lllllllllllllllIllIlIlIlIllIIIll */
        //    21: goto            31
        //    24: astore_3        /* lllllllllllllllIllIlIlIlIllIIIlI */
        //    25: aload_1         /* lllllllllllllllIllIlIlIlIllIIlII */
        //    26: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    29: aload_3         /* lllllllllllllllIllIlIlIlIllIIIlI */
        //    30: athrow         
        //    31: aload_1         /* lllllllllllllllIllIlIlIlIllIIlII */
        //    32: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    35: aload_2         /* lllllllllllllllIllIlIlIlIllIIlIl */
        //    36: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      24     24     31     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void setSoundLevel(final SoundCategory lllllllllllllllIllIlIlIlIIIIIIII, final float lllllllllllllllIllIlIlIIllllllll) {
        if (lllllllllllllllIllIlIlIlIIIIIIII == SoundCategory.MASTER && lllllllllllllllIllIlIlIIllllllll <= 0.0f) {
            this.stopSounds();
        }
        this.sndManager.setSoundCategoryVolume(lllllllllllllllIllIlIlIlIIIIIIII, lllllllllllllllIllIlIlIIllllllll);
    }
    
    public void resumeSounds() {
        this.sndManager.resumeAllSounds();
    }
    
    public SoundHandler(final IResourceManager lllllllllllllllIllIlIlIllIIIllll, final GameSettings lllllllllllllllIllIlIlIllIIIlIll) {
        this.sndRegistry = new SoundRegistry();
        this.mcResourceManager = lllllllllllllllIllIlIlIllIIIllll;
        this.sndManager = new SoundManager(this, lllllllllllllllIllIlIlIllIIIlIll);
    }
    
    public void unloadSounds() {
        this.sndManager.unloadSoundSystem();
    }
    
    private void loadSoundResource(final ResourceLocation lllllllllllllllIllIlIlIlIIllllll, final SoundList lllllllllllllllIllIlIlIlIIlllllI) {
        final boolean lllllllllllllllIllIlIlIlIlIIllll = !this.sndRegistry.containsKey(lllllllllllllllIllIlIlIlIIllllll);
        SoundEventAccessorComposite lllllllllllllllIllIlIlIlIlIIllIl = null;
        if (!lllllllllllllllIllIlIlIlIlIIllll && !lllllllllllllllIllIlIlIlIIlllllI.canReplaceExisting()) {
            final SoundEventAccessorComposite lllllllllllllllIllIlIlIlIlIIlllI = (SoundEventAccessorComposite)this.sndRegistry.getObject(lllllllllllllllIllIlIlIlIIllllll);
        }
        else {
            if (!lllllllllllllllIllIlIlIlIlIIllll) {
                SoundHandler.logger.debug("Replaced sound event location {}", new Object[] { lllllllllllllllIllIlIlIlIIllllll });
            }
            lllllllllllllllIllIlIlIlIlIIllIl = new SoundEventAccessorComposite(lllllllllllllllIllIlIlIlIIllllll, 1.0, 1.0, lllllllllllllllIllIlIlIlIIlllllI.getSoundCategory());
            this.sndRegistry.registerSound(lllllllllllllllIllIlIlIlIlIIllIl);
        }
        for (final SoundList.SoundEntry lllllllllllllllIllIlIlIlIlIIlIll : lllllllllllllllIllIlIlIlIIlllllI.getSoundList()) {
            final String lllllllllllllllIllIlIlIlIlIIlIlI = lllllllllllllllIllIlIlIlIlIIlIll.getSoundEntryName();
            final ResourceLocation lllllllllllllllIllIlIlIlIlIIlIIl = new ResourceLocation(lllllllllllllllIllIlIlIlIlIIlIlI);
            final String lllllllllllllllIllIlIlIlIlIIlIII = lllllllllllllllIllIlIlIlIlIIlIlI.contains(":") ? lllllllllllllllIllIlIlIlIlIIlIIl.getResourceDomain() : lllllllllllllllIllIlIlIlIIllllll.getResourceDomain();
            switch (SwitchType.field_148765_a[lllllllllllllllIllIlIlIlIlIIlIll.getSoundEntryType().ordinal()]) {
                case 1: {
                    final ResourceLocation lllllllllllllllIllIlIlIlIlIIIlII = new ResourceLocation(lllllllllllllllIllIlIlIlIlIIlIII, String.valueOf(new StringBuilder("sounds/").append(lllllllllllllllIllIlIlIlIlIIlIIl.getResourcePath()).append(".ogg")));
                    InputStream lllllllllllllllIllIlIlIlIlIIIIll = null;
                    try {
                        lllllllllllllllIllIlIlIlIlIIIIll = this.mcResourceManager.getResource(lllllllllllllllIllIlIlIlIlIIIlII).getInputStream();
                    }
                    catch (FileNotFoundException lllllllllllllllIllIlIlIlIlIIIIlI) {
                        SoundHandler.logger.warn("File {} does not exist, cannot add it to event {}", new Object[] { lllllllllllllllIllIlIlIlIlIIIlII, lllllllllllllllIllIlIlIlIIllllll });
                    }
                    catch (IOException lllllllllllllllIllIlIlIlIlIIIIIl) {
                        SoundHandler.logger.warn(String.valueOf(new StringBuilder("Could not load sound file ").append(lllllllllllllllIllIlIlIlIlIIIlII).append(", cannot add it to event ").append(lllllllllllllllIllIlIlIlIIllllll)), (Throwable)lllllllllllllllIllIlIlIlIlIIIIIl);
                    }
                    finally {
                        IOUtils.closeQuietly(lllllllllllllllIllIlIlIlIlIIIIll);
                    }
                    IOUtils.closeQuietly(lllllllllllllllIllIlIlIlIlIIIIll);
                    final Object lllllllllllllllIllIlIlIlIlIIIlll = new SoundEventAccessor(new SoundPoolEntry(lllllllllllllllIllIlIlIlIlIIIlII, lllllllllllllllIllIlIlIlIlIIlIll.getSoundEntryPitch(), lllllllllllllllIllIlIlIlIlIIlIll.getSoundEntryVolume(), lllllllllllllllIllIlIlIlIlIIlIll.isStreaming()), lllllllllllllllIllIlIlIlIlIIlIll.getSoundEntryWeight());
                    break;
                }
                case 2: {
                    final Object lllllllllllllllIllIlIlIlIlIIIllI = new ISoundEventAccessor(lllllllllllllllIllIlIlIlIlIIlIII, lllllllllllllllIllIlIlIlIlIIlIll) {
                        final /* synthetic */ ResourceLocation field_148726_a = new ResourceLocation(llllllllllllllIlIlllllIIlIlllIlI, llllllllllllllIlIlllllIIlIlllIIl.getSoundEntryName());
                        
                        public SoundPoolEntry getEntry() {
                            final SoundEventAccessorComposite llllllllllllllIlIlllllIIlIlIllll = (SoundEventAccessorComposite)SoundHandler.this.sndRegistry.getObject(this.field_148726_a);
                            return (SoundPoolEntry)((llllllllllllllIlIlllllIIlIlIllll == null) ? SoundHandler.missing_sound : llllllllllllllIlIlllllIIlIlIllll.cloneEntry());
                        }
                        
                        @Override
                        public Object cloneEntry() {
                            return this.getEntry();
                        }
                        
                        @Override
                        public int getWeight() {
                            final SoundEventAccessorComposite llllllllllllllIlIlllllIIlIllIlIl = (SoundEventAccessorComposite)SoundHandler.this.sndRegistry.getObject(this.field_148726_a);
                            return (llllllllllllllIlIlllllIIlIllIlIl == null) ? 0 : llllllllllllllIlIlllllIIlIllIlIl.getWeight();
                        }
                        
                        static {
                            __OBFID = "CL_00001149";
                        }
                    };
                    break;
                }
                default: {
                    throw new IllegalStateException("IN YOU FACE");
                }
            }
            final Object lllllllllllllllIllIlIlIlIlIIIlIl;
            lllllllllllllllIllIlIlIlIlIIllIl.addSoundToEventPool((ISoundEventAccessor)lllllllllllllllIllIlIlIlIlIIIlIl);
        }
    }
    
    public void stopSounds() {
        this.sndManager.stopAllSounds();
    }
    
    static final class SwitchType
    {
        static final /* synthetic */ int[] field_148765_a;
        
        static {
            __OBFID = "CL_00001150";
            field_148765_a = new int[SoundList.SoundEntry.Type.values().length];
            try {
                SwitchType.field_148765_a[SoundList.SoundEntry.Type.FILE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchType.field_148765_a[SoundList.SoundEntry.Type.SOUND_EVENT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
        }
    }
}
